package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import java.util.NavigableSet;
import java.util.TreeSet;

public class MigrationFileSystem
  extends DelegateFileSystem
{
  public static final Parcelable.Creator<MigrationFileSystem> CREATOR = new MigrationFileSystem.1();
  public static final String STAT_DESTINATION = "destination";
  public static final String STAT_DEST_OVERRIDE = "destOverride";
  public static final String STAT_DIRS_CREATED = "dirsCreated";
  public static final String STAT_DIRS_DELETED = "dirsDeleted";
  public static final String STAT_DIRS_MOVED = "dirsMoved";
  public static final String STAT_FILES_COPIED = "filesCopied";
  public static final String STAT_FILES_FAILED = "filesFailed";
  public static final String STAT_MIGRATE_ERROR_DETAIL = "failedDetail";
  public static final String STAT_MIGRATE_FAILED = "failedPathCollections";
  public static final String STAT_MIGRATE_FAST = "fastMigrateState";
  public static final String STAT_MIGRATE_FAST_ERROR = "fastMigrateError";
  public static final String STAT_SIZE_COPIED = "sizeCopied";
  private static final String TAG = "VFS.MigrationFileSystem";
  private static final int VERSION = 3;
  private List<FileSystem> mEffectiveFS;
  private final FileSystem[] mFSList;
  private boolean mPositive;
  private final String mPositiveMacro;
  private boolean mSpeedMigrateSucc = false;
  
  protected MigrationFileSystem(Parcel paramParcel)
  {
    VFSUtils.checkFileSystemVersion(paramParcel, MigrationFileSystem.class, 3);
    int j;
    if (paramParcel.readInt() == 1)
    {
      this.mSpeedMigrateSucc = bool;
      j = paramParcel.readInt();
      this.mFSList = new FileSystem[j];
    }
    for (;;)
    {
      if (i >= j) {
        break label105;
      }
      FileSystem localFileSystem = (FileSystem)paramParcel.readParcelable(getClass().getClassLoader());
      if (localFileSystem == null)
      {
        throw new IllegalArgumentException("Wrong wrapped filesystem.");
        bool = false;
        break;
      }
      this.mFSList[i] = localFileSystem;
      i += 1;
    }
    label105:
    this.mPositiveMacro = paramParcel.readString();
    this.mEffectiveFS = Arrays.asList(this.mFSList);
    ensureCallback();
  }
  
  public MigrationFileSystem(String paramString, FileSystem paramFileSystem, FileSystem... paramVarArgs)
  {
    if (paramFileSystem == null) {
      throw new IllegalArgumentException("destination == null");
    }
    this.mPositiveMacro = paramString;
    paramString = new FileSystem[paramVarArgs.length + 1];
    paramString[0] = paramFileSystem;
    int i = 1;
    int m = paramVarArgs.length;
    int j = 0;
    if (j < m)
    {
      paramFileSystem = paramVarArgs[j];
      if (paramFileSystem == null) {
        break label131;
      }
      int k = i + 1;
      paramString[i] = paramFileSystem;
      i = k;
    }
    label131:
    for (;;)
    {
      j += 1;
      break;
      if (i == paramString.length) {}
      for (;;)
      {
        this.mFSList = paramString;
        this.mEffectiveFS = Arrays.asList(this.mFSList);
        ensureCallback();
        return;
        paramString = (FileSystem[])Arrays.copyOf(paramString, i);
      }
    }
  }
  
  public MigrationFileSystem(boolean paramBoolean, FileSystem paramFileSystem, FileSystem... paramVarArgs) {}
  
  private void doMaintenance(CancellationSignalCompat paramCancellationSignalCompat)
  {
    if (this.mSpeedMigrateSucc)
    {
      QLog.d("VFS.MigrationFileSystem", 1, "doMaintenance no need! fast move is success!" + toString());
      return;
    }
    j = 0;
    k = 0;
    int i1 = 0;
    int m = 0;
    n = 0;
    i3 = 0;
    i = 0;
    long l1 = 0L;
    localHashMap = new HashMap();
    i2 = i3;
    for (;;)
    {
      try
      {
        localFileSystem1 = (FileSystem)this.mEffectiveFS.get(0);
        i2 = i3;
        localHashSet = new HashSet();
        i2 = i3;
        paramCancellationSignalCompat.throwIfCanceled();
        i2 = i3;
        if (!(localFileSystem1 instanceof NativeFileSystem)) {
          continue;
        }
        i2 = i3;
        localObject1 = ((NativeFileSystem)localFileSystem1).basePath();
        i2 = i3;
        statistics(1, new Object[] { "destination", localObject1 });
        i2 = i3;
        i5 = this.mEffectiveFS.size();
        i4 = 1;
      }
      catch (Exception paramCancellationSignalCompat)
      {
        FileSystem localFileSystem1;
        HashSet localHashSet;
        int i5;
        int i4;
        FileSystem localFileSystem2;
        Object localObject2;
        Iterator localIterator;
        FileSystem.FileEntry localFileEntry;
        boolean bool2;
        long l2;
        if (!(paramCancellationSignalCompat instanceof OperationCanceledException)) {
          continue;
        }
        i = 4;
        QLog.e("VFS.MigrationFileSystem", 1, "maintain error!", paramCancellationSignalCompat);
        if (!(this.mEffectiveFS.get(0) instanceof NativeFileSystem)) {
          continue;
        }
        localObject1 = ((NativeFileSystem)this.mEffectiveFS.get(0)).basePath();
        statistics(i, new Object[] { "destination", localObject1, "filesFailed", Integer.valueOf(i2), "failedDetail", paramCancellationSignalCompat.getMessage(), "failedPathCollections", localHashMap });
        throw paramCancellationSignalCompat;
        i2 = i;
        paramCancellationSignalCompat = localFileSystem1.toString();
        continue;
        i = 5;
        continue;
        localObject1 = ((FileSystem)this.mEffectiveFS.get(0)).toString();
        continue;
        continue;
        continue;
        n = j;
        j = i3;
        continue;
        i3 = k;
        continue;
        continue;
        i4 += 1;
        continue;
        i2 = n;
        n = k;
        k = j;
        j = i2;
        i2 = n;
        n = j;
        j = i2;
        continue;
        localObject1 = null;
        continue;
      }
      if (i4 >= i5) {
        continue;
      }
      i2 = i;
      paramCancellationSignalCompat.throwIfCanceled();
      i2 = i;
      localFileSystem2 = (FileSystem)this.mEffectiveFS.get(i4);
      i2 = i;
      localObject2 = localFileSystem2.list("", true);
      if (localObject2 != null) {
        continue;
      }
      continue;
      i2 = i3;
      localObject1 = localFileSystem1.toString();
    }
    i2 = i;
    if ((localFileSystem2.capabilityFlags() & 0x9) == 9)
    {
      i2 = i;
      localObject1 = new TreeSet();
      i2 = i;
      localIterator = ((Iterable)localObject2).iterator();
      i2 = i;
      if (localIterator.hasNext())
      {
        i2 = i;
        localFileEntry = (FileSystem.FileEntry)localIterator.next();
        i2 = i;
        paramCancellationSignalCompat.throwIfCanceled();
        i2 = i;
        bool1 = localFileEntry.isDirectory;
        if (bool1) {
          i2 = i;
        }
      }
    }
    try
    {
      bool2 = localFileSystem1.moveFile(localFileEntry.relPath, localFileSystem2, localFileEntry.relPath);
      bool1 = bool2;
      i2 = i;
      if (QLog.isColorLevel())
      {
        i2 = i;
        QLog.d("VFS.MigrationFileSystem", 2, "migrate file -> moveFile :" + localFileEntry.relPath + " [" + toString() + "], issucc = " + bool2);
        bool1 = bool2;
      }
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        bool1 = false;
        continue;
        i3 = k + 1;
        continue;
        k = j;
        j = i3;
        continue;
        i3 = k + 1;
        continue;
        if (localObject1 == null) {}
      }
    }
    if (bool1)
    {
      i2 = i;
      localHashSet.add(localFileEntry.relPath);
      i2 = j + 1;
      j = k;
      k = i2;
    }
    else
    {
      i3 = k;
      i2 = i;
      if (localHashSet.add(localFileEntry.relPath))
      {
        i2 = i;
        localFileSystem1.mkdirs(localFileEntry.relPath);
        i2 = i;
        if (!QLog.isColorLevel()) {
          break label1445;
        }
        i2 = i;
        QLog.d("VFS.MigrationFileSystem", 2, "migrate file failed! -> mkdirs :" + localFileEntry.relPath + " [" + toString() + "]");
        break label1445;
      }
      if (localObject1 == null) {
        break label1454;
      }
      i2 = i;
      ((TreeSet)localObject1).add(localFileEntry.relPath);
      break label1454;
      i2 = i;
      localObject2 = VFSUtils.getParentPath(localFileEntry.relPath);
      if (localObject2 != null)
      {
        i2 = i;
        if (localHashSet.add(localObject2))
        {
          i2 = i;
          localFileSystem1.mkdirs((String)localObject2);
          i2 = i;
          if (!QLog.isColorLevel()) {
            break label1463;
          }
          i2 = i;
          QLog.d("VFS.MigrationFileSystem", 2, "migrate file -> mkdirs :" + (String)localObject2 + " [" + toString() + "]");
          break label1463;
          k = i3;
          if (localObject1 != null)
          {
            i2 = i;
            ((TreeSet)localObject1).add(localObject2);
            k = i3;
          }
          i2 = i;
          if (localFileSystem1.exists(localFileEntry.relPath))
          {
            i2 = i;
            if (QLog.isColorLevel())
            {
              i2 = i;
              QLog.d("VFS.MigrationFileSystem", 2, "migrate file -> exists :" + localFileEntry.relPath + " [" + toString() + "]");
            }
            i2 = i;
            localFileSystem2.delete(localFileEntry.relPath);
            m += 1;
            i2 = j;
            j = n;
            n = i2;
            break label1418;
          }
          i3 = n;
          i2 = i;
          try
          {
            localFileSystem1.moveFile(localFileEntry.relPath, localFileSystem2, localFileEntry.relPath);
            i3 = n;
            i2 = i;
            if (QLog.isColorLevel())
            {
              i3 = n;
              i2 = i;
              QLog.d("VFS.MigrationFileSystem", 2, "migrate file -> moveFile :" + localFileEntry.relPath + " [" + toString() + "]");
            }
            n += 1;
            i3 = n;
            i2 = i;
            l2 = localFileEntry.diskSpace;
            l1 = l2 + l1;
            i2 = n;
            n = j;
            j = i2;
          }
          catch (IOException localIOException2)
          {
            i += 1;
          }
          for (;;)
          {
            try
            {
              QLog.e("VFS.MigrationFileSystem", 1, "Failed to migrate file: " + localFileEntry.relPath + " [" + toString() + "]");
              if (localHashMap.size() >= 3) {
                break label1472;
              }
              localHashMap.put(localFileEntry.relPath, localIOException2.getMessage());
            }
            catch (Exception paramCancellationSignalCompat)
            {
              i2 = i;
              continue;
            }
            if (localObject2 == null) {
              break label1376;
            }
            ((TreeSet)localObject1).remove(localObject2);
            localObject2 = VFSUtils.getParentPath((String)localObject2);
          }
          if (localObject1 != null)
          {
            i2 = i;
            localObject1 = ((TreeSet)localObject1).descendingSet().iterator();
            for (;;)
            {
              i2 = i;
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              i2 = i;
              localObject2 = (String)((Iterator)localObject1).next();
              i2 = i;
              paramCancellationSignalCompat.throwIfCanceled();
              i2 = i;
              localFileSystem2.deleteDir((String)localObject2, false);
              i1 += 1;
            }
            i2 = i;
            if ((localFileSystem1 instanceof NativeFileSystem))
            {
              i2 = i;
              paramCancellationSignalCompat = ((NativeFileSystem)localFileSystem1).basePath();
              i2 = i;
              statistics(3, new Object[] { "destination", paramCancellationSignalCompat, "filesFailed", Integer.valueOf(i), "failedPathCollections", localHashMap });
              return;
            }
          }
        }
      }
    }
  }
  
  private void ensureCallback()
  {
    if ((this.mEffectiveFS.get(0) instanceof NativeFileSystem)) {
      setStatisticsCallback(((NativeFileSystem)this.mEffectiveFS.get(0)).basePath(), FileSystemManager.statisticsCallback());
    }
  }
  
  private boolean tryCreateParentDirFromOtherFileSystem(String paramString)
  {
    paramString = VFSUtils.getParentPath(paramString);
    if (paramString == null) {
      return false;
    }
    FileSystem localFileSystem = (FileSystem)this.mEffectiveFS.get(0);
    if (localFileSystem.exists(paramString)) {
      return false;
    }
    int j = this.mEffectiveFS.size();
    int i = 1;
    while (i < j)
    {
      FileSystem.FileEntry localFileEntry = ((FileSystem)this.mEffectiveFS.get(i)).stat(paramString);
      if ((localFileEntry != null) && (localFileEntry.isDirectory)) {
        return localFileSystem.mkdirs(paramString);
      }
      i += 1;
    }
    return false;
  }
  
  protected Iterable<FileSystem> allFileSystems()
  {
    return this.mEffectiveFS;
  }
  
  public void configure(Map<String, String> paramMap)
  {
    boolean bool = true;
    Object localObject1 = this.mFSList;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localObject1[i].configure(paramMap);
      i += 1;
    }
    this.mEffectiveFS = new ArrayList(this.mFSList.length);
    this.mEffectiveFS.add(this.mFSList[0]);
    HashSet localHashSet = new HashSet();
    localObject1 = "";
    Object localObject3;
    Object localObject2;
    if ((this.mFSList[0] instanceof NativeFileSystem))
    {
      localObject3 = ((NativeFileSystem)this.mFSList[0]).basePath();
      if (localObject3 != null)
      {
        localObject2 = new File((String)localObject3);
        paramMap = (Map<String, String>)localObject2;
        if (((File)localObject2).exists()) {
          paramMap = null;
        }
        localHashSet.add(localObject3);
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (!this.mSpeedMigrateSucc)
      {
        j = 1;
        i = 0;
        if (j < this.mFSList.length) {
          if (!(this.mFSList[j] instanceof NativeFileSystem))
          {
            this.mEffectiveFS.add(this.mFSList[j]);
            localObject2 = localObject1;
            localObject1 = paramMap;
            paramMap = (Map<String, String>)localObject2;
          }
        }
      }
      for (;;)
      {
        j += 1;
        localObject2 = localObject1;
        localObject1 = paramMap;
        paramMap = (Map<String, String>)localObject2;
        break;
        localObject3 = (NativeFileSystem)this.mFSList[j];
        String str = ((NativeFileSystem)localObject3).basePath();
        localObject2 = localObject1;
        if (str != null)
        {
          localObject2 = new File(str);
          if (((File)localObject2).isDirectory())
          {
            if (paramMap == null) {
              localObject1 = "dest dir is exist, so fast rename is failed";
            }
            if (paramMap != null)
            {
              if (((File)localObject2).renameTo(paramMap))
              {
                i += 1;
                if (QLog.isColorLevel()) {
                  QLog.i("VFS.MigrationFileSystem", 2, "Fast moved '" + localObject2 + "' -> '" + paramMap + "'");
                }
                paramMap = (Map<String, String>)localObject1;
                localObject1 = null;
                continue;
              }
              localObject1 = paramMap;
              paramMap = "srcDir renameTo destDir is error!";
              continue;
            }
            localObject2 = localObject1;
            if (localHashSet.add(str))
            {
              this.mEffectiveFS.add(localObject3);
              localObject2 = paramMap;
              paramMap = (Map<String, String>)localObject1;
              localObject1 = localObject2;
            }
          }
          else
          {
            localObject1 = paramMap;
            paramMap = "srcDir not is Directory";
            continue;
            localObject2 = localObject1;
            if (i == this.mFSList.length - 1)
            {
              this.mSpeedMigrateSucc = true;
              localObject2 = localObject1;
            }
            if ((!this.mSpeedMigrateSucc) && ((this.mEffectiveFS.get(0) instanceof NativeFileSystem))) {
              statistics(7, new Object[] { "destination", ((NativeFileSystem)this.mEffectiveFS.get(0)).basePath(), "fastMigrateState", Boolean.valueOf(this.mSpeedMigrateSucc), "fastMigrateError", localObject2 });
            }
            if (this.mPositiveMacro != null) {}
            for (;;)
            {
              this.mPositive = bool;
              return;
              bool = false;
            }
          }
        }
        localObject1 = paramMap;
        paramMap = (Map<String, String>)localObject2;
      }
      paramMap = null;
    }
  }
  
  protected FileSystem delegate(String paramString, int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 3))
    {
      Iterator localIterator = this.mEffectiveFS.iterator();
      while (localIterator.hasNext())
      {
        FileSystem localFileSystem = (FileSystem)localIterator.next();
        if (localFileSystem.exists(paramString)) {
          return localFileSystem;
        }
      }
    }
    return (FileSystem)this.mEffectiveFS.get(0);
  }
  
  public boolean exists(String paramString)
  {
    Iterator localIterator = this.mEffectiveFS.iterator();
    while (localIterator.hasNext()) {
      if (((FileSystem)localIterator.next()).exists(paramString)) {
        return true;
      }
    }
    return false;
  }
  
  public void maintain(CancellationSignalCompat paramCancellationSignalCompat)
  {
    if (this.mPositive) {
      doMaintenance(paramCancellationSignalCompat);
    }
    super.maintain(paramCancellationSignalCompat);
  }
  
  public InputStream openRead(String paramString)
  {
    Object localObject1 = null;
    Iterator localIterator = this.mEffectiveFS.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label65;
      }
      Object localObject2 = (FileSystem)localIterator.next();
      try
      {
        localObject2 = ((FileSystem)localObject2).openRead(paramString);
        if (localObject2 != null) {
          return localObject2;
        }
        localObject2 = localObject1;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          if (localObject1 != null) {
            Object localObject3 = localObject1;
          }
        }
      }
      localObject1 = localObject2;
    }
    label65:
    if (localObject1 != null) {}
    for (;;)
    {
      throw ((Throwable)localObject1);
      localObject1 = new FileNotFoundException(paramString + " not found on any file systems.");
    }
  }
  
  public ReadableByteChannel openReadChannel(String paramString)
  {
    Object localObject1 = null;
    Iterator localIterator = this.mEffectiveFS.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label65;
      }
      Object localObject2 = (FileSystem)localIterator.next();
      try
      {
        localObject2 = ((FileSystem)localObject2).openReadChannel(paramString);
        if (localObject2 != null) {
          return localObject2;
        }
        localObject2 = localObject1;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          if (localObject1 != null) {
            Object localObject3 = localObject1;
          }
        }
      }
      localObject1 = localObject2;
    }
    label65:
    if (localObject1 != null) {}
    for (;;)
    {
      throw ((Throwable)localObject1);
      localObject1 = new FileNotFoundException(paramString + " not found on any file systems.");
    }
  }
  
  public OutputStream openWrite(String paramString, boolean paramBoolean)
  {
    FileSystem localFileSystem = (FileSystem)this.mEffectiveFS.get(0);
    try
    {
      OutputStream localOutputStream = localFileSystem.openWrite(paramString, paramBoolean);
      return localOutputStream;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      if ((!paramBoolean) && (tryCreateParentDirFromOtherFileSystem(paramString))) {
        return localFileSystem.openWrite(paramString, false);
      }
      throw localFileNotFoundException;
    }
  }
  
  public WritableByteChannel openWriteChannel(String paramString, boolean paramBoolean)
  {
    FileSystem localFileSystem = (FileSystem)this.mEffectiveFS.get(0);
    try
    {
      WritableByteChannel localWritableByteChannel = localFileSystem.openWriteChannel(paramString, paramBoolean);
      return localWritableByteChannel;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      if ((!paramBoolean) && (tryCreateParentDirFromOtherFileSystem(paramString))) {
        return localFileSystem.openWriteChannel(paramString, false);
      }
      throw localFileNotFoundException;
    }
  }
  
  public FileSystem.FileEntry stat(String paramString)
  {
    Iterator localIterator = this.mEffectiveFS.iterator();
    while (localIterator.hasNext())
    {
      FileSystem.FileEntry localFileEntry = ((FileSystem)localIterator.next()).stat(paramString);
      if (localFileEntry != null) {
        return localFileEntry;
      }
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Migration [").append(this.mFSList[0].toString()).append(" <= ");
    int i = 1;
    while (i < this.mFSList.length)
    {
      localStringBuilder.append(this.mFSList[i].toString()).append(", ");
      i += 1;
    }
    localStringBuilder.setLength(localStringBuilder.length() - 2);
    return ']';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 0;
    VFSUtils.writeFileSystemVersion(paramParcel, MigrationFileSystem.class, 3);
    if (this.mSpeedMigrateSucc) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeInt(this.mFSList.length);
      FileSystem[] arrayOfFileSystem = this.mFSList;
      int k = arrayOfFileSystem.length;
      i = j;
      while (i < k)
      {
        paramParcel.writeParcelable(arrayOfFileSystem[i], paramInt);
        i += 1;
      }
    }
    paramParcel.writeString(this.mPositiveMacro);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.vfs.MigrationFileSystem
 * JD-Core Version:    0.7.0.1
 */