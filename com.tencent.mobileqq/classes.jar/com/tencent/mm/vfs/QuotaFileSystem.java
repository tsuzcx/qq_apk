package com.tencent.mm.vfs;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class QuotaFileSystem
  extends DelegateFileSystem
  implements Handler.Callback
{
  public static final Parcelable.Creator<QuotaFileSystem> CREATOR = new QuotaFileSystem.2();
  public static final String STAT_DESTINATION = "destination";
  public static final String STAT_DIR_COUNT = "dirCount";
  public static final String STAT_FILE_COUNT = "fileCount";
  public static final String STAT_TOTAL_SIZE = "totalSize";
  private static final String TAG = "VFS.QuotaFileSystem";
  private static final int VERSION = 2;
  private final long FLUSH_CACHE_DELAY = 60000L;
  private HashMap<String, Long> mAccessTimeCache;
  private final Object mCacheLock = new Object();
  private final long mCleaningThreshold;
  private final boolean mEmulateAccessTime;
  private final long mExpireTime;
  private final FileSystem mFS;
  private final Iterable<FileSystem> mFSList;
  private final Handler mFlushCacheHandler;
  private final long mTargetSize;
  
  protected QuotaFileSystem(Parcel paramParcel)
  {
    VFSUtils.checkFileSystemVersion(paramParcel, QuotaFileSystem.class, 2);
    this.mFS = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
    if (this.mFS == null) {
      throw new IllegalArgumentException("Wrong wrapped filesystem.");
    }
    this.mFSList = Collections.singletonList(this.mFS);
    this.mTargetSize = paramParcel.readLong();
    this.mCleaningThreshold = paramParcel.readLong();
    this.mExpireTime = paramParcel.readLong();
    boolean bool;
    if (paramParcel.readByte() != 0)
    {
      bool = true;
      this.mEmulateAccessTime = bool;
      if (!this.mEmulateAccessTime) {
        break label159;
      }
      this.mAccessTimeCache = new HashMap();
    }
    for (this.mFlushCacheHandler = new Handler(FileSystemManager.instance().maintenanceLooper(), this);; this.mFlushCacheHandler = null)
    {
      checkParameters();
      return;
      bool = false;
      break;
      label159:
      this.mAccessTimeCache = null;
    }
  }
  
  public QuotaFileSystem(FileSystem paramFileSystem, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    this.mFS = paramFileSystem;
    this.mFSList = Collections.singletonList(this.mFS);
    this.mTargetSize = paramLong1;
    this.mCleaningThreshold = paramLong2;
    this.mExpireTime = paramLong3;
    this.mEmulateAccessTime = paramBoolean;
    if (this.mEmulateAccessTime) {
      this.mAccessTimeCache = new HashMap();
    }
    for (this.mFlushCacheHandler = new Handler(FileSystemManager.instance().maintenanceLooper(), this);; this.mFlushCacheHandler = null)
    {
      checkParameters();
      return;
      this.mAccessTimeCache = null;
    }
  }
  
  private void checkParameters()
  {
    if (this.mCleaningThreshold < this.mTargetSize) {
      throw new IllegalArgumentException("Cleaning threshold must not less than target size.");
    }
  }
  
  private void doMaintenance(CancellationSignalCompat paramCancellationSignalCompat)
  {
    long l2 = 0L;
    int i1 = 0;
    int i = 0;
    int j = 0;
    int n = 0;
    int k = n;
    int m = i;
    long l1 = l2;
    int i2;
    try
    {
      i2 = this.mFS.capabilityFlags();
      if ((i2 & 0x1) == 0)
      {
        k = n;
        m = i;
        l1 = l2;
        QLog.e("VFS.QuotaFileSystem", 1, "No quota operation can be done on read-only file system: " + this.mFS.toString());
        return;
      }
      if ((i2 & 0x4) != 0) {
        break label252;
      }
      k = n;
      m = i;
      l1 = l2;
      QLog.e("VFS.QuotaFileSystem", 1, "No quota operation can be done on non-listable file system: " + this.mFS.toString());
      return;
    }
    catch (Exception paramCancellationSignalCompat)
    {
      j = m;
      i = k;
    }
    label202:
    label252:
    Object localObject1;
    Object localObject2;
    long l3;
    if ((paramCancellationSignalCompat instanceof OperationCanceledException))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VFS.QuotaFileSystem", 2, "Maintenance cancelled. files: " + j + ", dirs: " + i + ", totalSize: " + l1);
      }
      k = 4;
      statistics(k, new Object[] { "fileCount", Integer.valueOf(j), "dirCount", Integer.valueOf(i), "totalSize", Long.valueOf(l1) });
      throw paramCancellationSignalCompat;
      k = n;
      m = i;
      l1 = l2;
      paramCancellationSignalCompat.throwIfCanceled();
      k = n;
      m = i;
      l1 = l2;
      statistics(1, new Object[] { "destination", this.mFS });
      k = n;
      m = i;
      l1 = l2;
      if (this.mEmulateAccessTime)
      {
        localObject1 = null;
        k = n;
        m = i;
        l1 = l2;
        localObject2 = this.mCacheLock;
        k = n;
        m = i;
        l1 = l2;
        try
        {
          if (!this.mAccessTimeCache.isEmpty())
          {
            localObject1 = this.mAccessTimeCache;
            this.mAccessTimeCache = new HashMap();
          }
          if (localObject1 != null)
          {
            k = n;
            m = i;
            l1 = l2;
            localObject1 = ((HashMap)localObject1).entrySet().iterator();
            for (;;)
            {
              k = n;
              m = i;
              l1 = l2;
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              k = n;
              m = i;
              l1 = l2;
              localObject2 = (Map.Entry)((Iterator)localObject1).next();
              k = n;
              m = i;
              l1 = l2;
              paramCancellationSignalCompat.throwIfCanceled();
              k = n;
              m = i;
              l1 = l2;
              this.mFS.setModifiedTime((String)((Map.Entry)localObject2).getKey(), ((Long)((Map.Entry)localObject2).getValue()).longValue());
            }
          }
          k = n;
        }
        finally
        {
          k = n;
          m = i;
          l1 = l2;
        }
      }
      m = i;
      l1 = l2;
      paramCancellationSignalCompat.throwIfCanceled();
      k = n;
      m = i;
      l1 = l2;
      Object localObject4 = new ArrayList();
      k = n;
      m = i;
      l1 = l2;
      localObject1 = this.mFS.list("", true);
      if (localObject1 == null)
      {
        k = n;
        m = i;
        l1 = l2;
        QLog.e("VFS.QuotaFileSystem", 1, "Unable to list files in FS: " + toString());
        return;
      }
      k = n;
      m = i;
      l1 = l2;
      localObject1 = ((Iterable)localObject1).iterator();
      i = i1;
      k = j;
      m = i;
      l1 = l2;
      if (((Iterator)localObject1).hasNext())
      {
        k = j;
        m = i;
        l1 = l2;
        localObject2 = (FileSystem.FileEntry)((Iterator)localObject1).next();
        k = j;
        m = i;
        l1 = l2;
        paramCancellationSignalCompat.throwIfCanceled();
        k = j;
        m = i;
        l1 = l2;
        if (((FileSystem.FileEntry)localObject2).diskSpace < 0L)
        {
          k = j;
          m = i;
          l1 = l2;
          l3 = ((FileSystem.FileEntry)localObject2).size;
        }
        for (l1 = l3;; l1 = l3)
        {
          for (;;)
          {
            l2 += l1;
            k = j;
            m = i;
            l1 = l2;
            boolean bool = ((FileSystem.FileEntry)localObject2).isDirectory;
            if (!bool) {
              break label2229;
            }
            j += 1;
            try
            {
              label792:
              ((List)localObject4).add(localObject2);
            }
            catch (Exception paramCancellationSignalCompat)
            {
              Iterator localIterator;
              Object localObject3;
              k = i;
              i = j;
              j = k;
              l1 = l2;
            }
          }
          k = j;
          m = i;
          l1 = l2;
          l3 = ((FileSystem.FileEntry)localObject2).diskSpace;
        }
      }
      k = j;
      m = i;
      l1 = l2;
      if (QLog.isColorLevel())
      {
        k = j;
        m = i;
        l1 = l2;
        QLog.i("VFS.QuotaFileSystem", 2, "Total size: " + l2 + ", Cleaning threshold: " + this.mCleaningThreshold);
      }
      k = j;
      m = i;
      l1 = l2;
      statistics(2, new Object[] { "fileCount", Integer.valueOf(i), "dirCount", Integer.valueOf(j), "totalSize", Long.valueOf(l2) });
      k = j;
      m = i;
      l1 = l2;
      if (l2 <= this.mCleaningThreshold)
      {
        k = j;
        m = i;
        l1 = l2;
        if (QLog.isColorLevel())
        {
          k = j;
          m = i;
          l1 = l2;
          QLog.e("VFS.QuotaFileSystem", 2, "Threshold not reached, skip cleaning.");
        }
        k = j;
        m = i;
        l1 = l2;
        statistics(6, new Object[] { "fileCount", Integer.valueOf(i), "dirCount", Integer.valueOf(j), "totalSize", Long.valueOf(l2) });
        return;
      }
      if ((i2 & 0x8) == 0) {
        break label2223;
      }
      k = j;
      m = i;
      l1 = l2;
      localObject2 = new HashMap();
      k = j;
      m = i;
      l1 = l2;
      localIterator = ((List)localObject4).iterator();
      for (;;)
      {
        k = j;
        m = i;
        l1 = l2;
        if (!localIterator.hasNext()) {
          break;
        }
        k = j;
        m = i;
        l1 = l2;
        FileSystem.FileEntry localFileEntry = (FileSystem.FileEntry)localIterator.next();
        k = j;
        m = i;
        l1 = l2;
        if (localFileEntry.isDirectory)
        {
          k = j;
          m = i;
          l1 = l2;
          if (!((HashMap)localObject2).containsKey(localFileEntry.relPath))
          {
            k = j;
            m = i;
            l1 = l2;
            ((HashMap)localObject2).put(localFileEntry.relPath, new QuotaFileSystem.DirEntry(localFileEntry));
          }
        }
        k = j;
        m = i;
        l1 = l2;
        String str = VFSUtils.getParentPath(localFileEntry.relPath);
        if (str != null)
        {
          k = j;
          m = i;
          l1 = l2;
          localObject3 = (QuotaFileSystem.DirEntry)((HashMap)localObject2).get(str);
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            k = j;
            m = i;
            l1 = l2;
            localObject1 = new QuotaFileSystem.DirEntry(localFileEntry);
            k = j;
            m = i;
            l1 = l2;
            ((HashMap)localObject2).put(str, localObject1);
          }
          k = j;
          m = i;
          l1 = l2;
          ((QuotaFileSystem.DirEntry)localObject1).childCount += 1;
        }
      }
      k = j;
      m = i;
      l1 = l2;
      paramCancellationSignalCompat.throwIfCanceled();
      localObject1 = localObject2;
      label1365:
      k = j;
      m = i;
      l1 = l2;
      localObject3 = new ArrayList(((List)localObject4).size());
      k = j;
      m = i;
      l1 = l2;
      localObject2 = ((List)localObject4).iterator();
      for (;;)
      {
        k = j;
        m = i;
        l1 = l2;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        k = j;
        m = i;
        l1 = l2;
        localObject4 = (FileSystem.FileEntry)((Iterator)localObject2).next();
        k = j;
        m = i;
        l1 = l2;
        if (!((FileSystem.FileEntry)localObject4).isDirectory)
        {
          k = j;
          m = i;
          l1 = l2;
          ((ArrayList)localObject3).add(localObject4);
        }
      }
      k = j;
      m = i;
      l1 = l2;
      Collections.sort((List)localObject3, new QuotaFileSystem.1(this));
      k = j;
      m = i;
      l1 = l2;
      n = ((ArrayList)localObject3).size();
      m = n - 1;
      k = i;
      l1 = l2;
      i = j;
      j = i;
      l2 = l1;
      for (;;)
      {
        for (;;)
        {
          try
          {
            if ((l1 > this.mTargetSize) && (m >= 0))
            {
              j = i;
              l2 = l1;
              paramCancellationSignalCompat.throwIfCanceled();
              j = i;
              l2 = l1;
              localObject2 = (FileSystem.FileEntry)((ArrayList)localObject3).get(m);
              j = i;
              l2 = l1;
              localObject4 = ((FileSystem.FileEntry)localObject2).relPath;
              j = i;
              l2 = l1;
              if (!this.mFS.delete((String)localObject4)) {
                break label2217;
              }
              j = i;
              l2 = l1;
              if (((FileSystem.FileEntry)localObject2).diskSpace < 0L)
              {
                j = i;
                l2 = l1;
                l3 = ((FileSystem.FileEntry)localObject2).size;
                l2 = l3;
                l1 -= l2;
                j = k - 1;
                label1673:
                if (localObject1 == null) {
                  break label2214;
                }
              }
            }
          }
          catch (Exception paramCancellationSignalCompat)
          {
            label1707:
            i = j;
            j = k;
            l1 = l2;
          }
          try
          {
            localObject2 = VFSUtils.getParentPath((String)localObject4);
            if (localObject2 == null) {
              break label2211;
            }
          }
          catch (Exception paramCancellationSignalCompat) {}
          try
          {
            localObject4 = (QuotaFileSystem.DirEntry)((HashMap)localObject1).get(localObject2);
            if (localObject4 == null)
            {
              m -= 1;
              k = j;
              break;
              j = i;
              l2 = l1;
              l3 = ((FileSystem.FileEntry)localObject2).diskSpace;
              l2 = l3;
              continue;
            }
            k = ((QuotaFileSystem.DirEntry)localObject4).childCount - 1;
            ((QuotaFileSystem.DirEntry)localObject4).childCount = k;
            if ((k != 0) || (!this.mFS.deleteDir((String)localObject2, false))) {
              break label2211;
            }
            if (((QuotaFileSystem.DirEntry)localObject4).entry.diskSpace < 0L)
            {
              l2 = ((QuotaFileSystem.DirEntry)localObject4).entry.size;
              l1 -= l2;
              i -= 1;
            }
          }
          catch (Exception paramCancellationSignalCompat) {}
        }
        try
        {
          ((HashMap)localObject1).remove(localObject2);
          localObject2 = VFSUtils.getParentPath((String)localObject2);
        }
        catch (Exception paramCancellationSignalCompat) {}
        l2 = ((QuotaFileSystem.DirEntry)localObject4).entry.diskSpace;
        continue;
        m = i;
        l3 = l1;
        if (localObject1 != null)
        {
          j = i;
          l2 = l1;
          localObject1 = ((HashMap)localObject1).values().iterator();
        }
      }
    }
    label2211:
    label2214:
    label2217:
    label2223:
    label2229:
    label2236:
    label2247:
    for (;;)
    {
      m = i;
      l3 = l1;
      j = i;
      l2 = l1;
      if (((Iterator)localObject1).hasNext())
      {
        j = i;
        l2 = l1;
        localObject2 = (QuotaFileSystem.DirEntry)((Iterator)localObject1).next();
        j = i;
        l2 = l1;
        if (((QuotaFileSystem.DirEntry)localObject2).childCount == 0)
        {
          j = i;
          l2 = l1;
          paramCancellationSignalCompat.throwIfCanceled();
          j = i;
          l2 = l1;
          if (this.mFS.deleteDir(((QuotaFileSystem.DirEntry)localObject2).entry.relPath, false))
          {
            j = i;
            l2 = l1;
            if (((QuotaFileSystem.DirEntry)localObject2).entry.diskSpace < 0L)
            {
              j = i;
              l2 = l1;
              l3 = ((QuotaFileSystem.DirEntry)localObject2).entry.size;
              l2 = l3;
              break label2236;
            }
            j = i;
            l2 = l1;
            l3 = ((QuotaFileSystem.DirEntry)localObject2).entry.diskSpace;
            l2 = l3;
            break label2236;
          }
        }
      }
      else
      {
        j = m;
        l2 = l3;
        if (QLog.isColorLevel())
        {
          j = m;
          l2 = l3;
          QLog.i("VFS.QuotaFileSystem", 2, "Maintenance done. files: " + k + ", dirs: " + m + ", totalSize: " + l3);
        }
        j = m;
        l2 = l3;
        statistics(3, new Object[] { "fileCount", Integer.valueOf(k), "dirCount", Integer.valueOf(m), "totalSize", Long.valueOf(l3) });
        return;
        break;
        QLog.e("VFS.QuotaFileSystem", 1, "Maintenance failed.", paramCancellationSignalCompat);
        k = 5;
        break label202;
        break;
        break;
        break;
        break;
      }
      break label2247;
      break label1707;
      break label1707;
      j = k;
      break label1673;
      localObject1 = null;
      break label1365;
      i += 1;
      break label792;
      i -= 1;
      l1 -= l2;
    }
  }
  
  private static int longSigning(long paramLong)
  {
    if (paramLong == 0L) {
      return 0;
    }
    if (paramLong > 0L) {
      return 1;
    }
    return -1;
  }
  
  private void updateAccessTime(String paramString, boolean paramBoolean)
  {
    if (!this.mEmulateAccessTime) {}
    for (;;)
    {
      return;
      if (paramBoolean) {
        synchronized (this.mCacheLock)
        {
          this.mAccessTimeCache.remove(paramString);
          return;
        }
      }
      long l = System.currentTimeMillis();
      synchronized (this.mCacheLock)
      {
        paramBoolean = this.mAccessTimeCache.isEmpty();
        this.mAccessTimeCache.put(paramString, Long.valueOf(l));
        if (!paramBoolean) {
          continue;
        }
        this.mFlushCacheHandler.sendMessageDelayed(Message.obtain(), 60000L);
        return;
      }
    }
  }
  
  protected Iterable<FileSystem> allFileSystems()
  {
    return this.mFSList;
  }
  
  protected FileSystem delegate(String paramString, int paramInt)
  {
    return this.mFS;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    for (;;)
    {
      synchronized (this.mCacheLock)
      {
        if (this.mAccessTimeCache.isEmpty()) {
          break label144;
        }
        paramMessage = this.mAccessTimeCache;
        this.mAccessTimeCache = new HashMap();
        if (paramMessage == null) {
          break label142;
        }
        ??? = paramMessage.entrySet().iterator();
        if (((Iterator)???).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)???).next();
          this.mFS.setModifiedTime((String)localEntry.getKey(), ((Long)localEntry.getValue()).longValue());
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("VFS.QuotaFileSystem", 2, "Flush access time cache entries: " + paramMessage.size());
      }
      label142:
      return true;
      label144:
      paramMessage = null;
    }
  }
  
  public void maintain(CancellationSignalCompat paramCancellationSignalCompat)
  {
    doMaintenance(paramCancellationSignalCompat);
    super.maintain(paramCancellationSignalCompat);
  }
  
  public ParcelFileDescriptor openParcelFd(String paramString1, String paramString2)
  {
    ParcelFileDescriptor localParcelFileDescriptor = this.mFS.openParcelFd(paramString1, paramString2);
    updateAccessTime(paramString1, paramString2.contains("w"));
    return localParcelFileDescriptor;
  }
  
  public InputStream openRead(String paramString)
  {
    InputStream localInputStream = this.mFS.openRead(paramString);
    updateAccessTime(paramString, false);
    return localInputStream;
  }
  
  public ReadableByteChannel openReadChannel(String paramString)
  {
    ReadableByteChannel localReadableByteChannel = this.mFS.openReadChannel(paramString);
    updateAccessTime(paramString, false);
    return localReadableByteChannel;
  }
  
  public ByteChannel openReadWriteChannel(String paramString)
  {
    ByteChannel localByteChannel = this.mFS.openReadWriteChannel(paramString);
    updateAccessTime(paramString, true);
    return localByteChannel;
  }
  
  public OutputStream openWrite(String paramString, boolean paramBoolean)
  {
    OutputStream localOutputStream = this.mFS.openWrite(paramString, paramBoolean);
    updateAccessTime(paramString, true);
    return localOutputStream;
  }
  
  public WritableByteChannel openWriteChannel(String paramString, boolean paramBoolean)
  {
    WritableByteChannel localWritableByteChannel = this.mFS.openWriteChannel(paramString, paramBoolean);
    updateAccessTime(paramString, true);
    return localWritableByteChannel;
  }
  
  public String toString()
  {
    long l = this.mTargetSize / 1024L / 1024L;
    return "QuotaFS [" + l + "MB | " + this.mFS.toString() + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    VFSUtils.writeFileSystemVersion(paramParcel, QuotaFileSystem.class, 2);
    paramParcel.writeParcelable(this.mFS, paramInt);
    paramParcel.writeLong(this.mTargetSize);
    paramParcel.writeLong(this.mCleaningThreshold);
    paramParcel.writeLong(this.mExpireTime);
    if (this.mEmulateAccessTime) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.vfs.QuotaFileSystem
 * JD-Core Version:    0.7.0.1
 */