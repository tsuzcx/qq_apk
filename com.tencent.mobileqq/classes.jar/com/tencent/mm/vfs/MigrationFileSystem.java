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
  private boolean mSpeedMigrateSucc;
  
  protected MigrationFileSystem(Parcel paramParcel)
  {
    int i = 0;
    this.mSpeedMigrateSucc = false;
    VFSUtils.checkFileSystemVersion(paramParcel, MigrationFileSystem.class, 3);
    int j = paramParcel.readInt();
    boolean bool = true;
    if (j != 1) {
      bool = false;
    }
    this.mSpeedMigrateSucc = bool;
    j = paramParcel.readInt();
    this.mFSList = new FileSystem[j];
    while (i < j)
    {
      FileSystem localFileSystem = (FileSystem)paramParcel.readParcelable(getClass().getClassLoader());
      if (localFileSystem != null)
      {
        this.mFSList[i] = localFileSystem;
        i += 1;
      }
      else
      {
        throw new IllegalArgumentException("Wrong wrapped filesystem.");
      }
    }
    this.mPositiveMacro = paramParcel.readString();
    this.mEffectiveFS = Arrays.asList(this.mFSList);
    ensureCallback();
  }
  
  public MigrationFileSystem(String paramString, FileSystem paramFileSystem, FileSystem... paramVarArgs)
  {
    int i = 0;
    this.mSpeedMigrateSucc = false;
    if (paramFileSystem != null)
    {
      this.mPositiveMacro = paramString;
      int k = paramVarArgs.length;
      int j = 1;
      paramString = new FileSystem[k + 1];
      paramString[0] = paramFileSystem;
      int m = paramVarArgs.length;
      while (i < m)
      {
        paramFileSystem = paramVarArgs[i];
        k = j;
        if (paramFileSystem != null)
        {
          paramString[j] = paramFileSystem;
          k = j + 1;
        }
        i += 1;
        j = k;
      }
      if (j != paramString.length) {
        paramString = (FileSystem[])Arrays.copyOf(paramString, j);
      }
      this.mFSList = paramString;
      this.mEffectiveFS = Arrays.asList(this.mFSList);
      ensureCallback();
      return;
    }
    paramString = new IllegalArgumentException("destination == null");
    for (;;)
    {
      throw paramString;
    }
  }
  
  public MigrationFileSystem(boolean paramBoolean, FileSystem paramFileSystem, FileSystem... paramVarArgs)
  {
    this(str, paramFileSystem, paramVarArgs);
  }
  
  private void doMaintenance(CancellationSignalCompat paramCancellationSignalCompat)
  {
    Object localObject2 = this;
    if (((MigrationFileSystem)localObject2).mSpeedMigrateSucc)
    {
      paramCancellationSignalCompat = new StringBuilder();
      paramCancellationSignalCompat.append("doMaintenance no need! fast move is success!");
      paramCancellationSignalCompat.append(toString());
      QLog.d("VFS.MigrationFileSystem", 1, paramCancellationSignalCompat.toString());
      return;
    }
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      Object localObject1;
      int j;
      int m;
      int n;
      try
      {
        FileSystem localFileSystem1 = (FileSystem)((MigrationFileSystem)localObject2).mEffectiveFS.get(0);
        Object localObject3 = new HashSet();
        paramCancellationSignalCompat.throwIfCanceled();
        if ((localFileSystem1 instanceof NativeFileSystem)) {
          localObject1 = ((NativeFileSystem)localFileSystem1).basePath();
        } else {
          localObject1 = localFileSystem1.toString();
        }
        ((MigrationFileSystem)localObject2).statistics(1, new Object[] { "destination", localObject1 });
        j = ((MigrationFileSystem)localObject2).mEffectiveFS.size();
        m = 1;
        i = 0;
        localObject1 = localObject3;
        int k;
        if (m < j) {
          k = i;
        }
        try
        {
          paramCancellationSignalCompat.throwIfCanceled();
          k = i;
          localFileSystem2 = (FileSystem)this.mEffectiveFS.get(m);
          k = i;
          localObject3 = localFileSystem2.list("", true);
          if (localObject3 == null)
          {
            n = i;
            break label1545;
          }
          k = i;
          n = localFileSystem2.capabilityFlags();
          if ((n & 0x9) == 9) {
            try
            {
              localObject2 = new TreeSet();
            }
            catch (Exception paramCancellationSignalCompat)
            {
              break label1373;
            }
          } else {
            localObject2 = null;
          }
          k = i;
          localObject3 = ((Iterable)localObject3).iterator();
          k = i;
          if (((Iterator)localObject3).hasNext())
          {
            k = i;
            localFileEntry = (FileSystem.FileEntry)((Iterator)localObject3).next();
            k = i;
            paramCancellationSignalCompat.throwIfCanceled();
            k = i;
            bool1 = localFileEntry.isDirectory;
            if (bool1) {
              k = i;
            }
          }
        }
        catch (Exception paramCancellationSignalCompat)
        {
          FileSystem localFileSystem2;
          FileSystem.FileEntry localFileEntry;
          boolean bool1;
          boolean bool2;
          Object localObject4;
          StringBuilder localStringBuilder1;
          int i1;
          i = k;
        }
      }
      catch (Exception paramCancellationSignalCompat)
      {
        i = 0;
      }
      try
      {
        bool2 = localFileSystem1.moveFile(localFileEntry.relPath, localFileSystem2, localFileEntry.relPath);
        bool1 = bool2;
        k = i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        k = i;
        localObject4 = new StringBuilder();
        k = i;
        ((StringBuilder)localObject4).append("migrate file -> moveFile :");
        k = i;
        ((StringBuilder)localObject4).append(localFileEntry.relPath);
        k = i;
        ((StringBuilder)localObject4).append(" [");
        k = i;
        ((StringBuilder)localObject4).append(toString());
        k = i;
        ((StringBuilder)localObject4).append("], issucc = ");
        k = i;
        ((StringBuilder)localObject4).append(bool2);
        k = i;
        QLog.d("VFS.MigrationFileSystem", 2, ((StringBuilder)localObject4).toString());
        bool1 = bool2;
      }
      catch (IOException localIOException1)
      {
        continue;
        continue;
        continue;
        continue;
        if (localObject2 == null) {
          continue;
        }
        continue;
      }
      bool1 = false;
      if (bool1)
      {
        k = i;
        ((HashSet)localObject1).add(localFileEntry.relPath);
      }
      else
      {
        k = i;
        if (((HashSet)localObject1).add(localFileEntry.relPath))
        {
          k = i;
          localFileSystem1.mkdirs(localFileEntry.relPath);
          k = i;
          if (QLog.isColorLevel())
          {
            k = i;
            localObject4 = new StringBuilder();
            k = i;
            ((StringBuilder)localObject4).append("migrate file failed! -> mkdirs :");
            k = i;
            ((StringBuilder)localObject4).append(localFileEntry.relPath);
            k = i;
            ((StringBuilder)localObject4).append(" [");
            k = i;
            ((StringBuilder)localObject4).append(toString());
            k = i;
            ((StringBuilder)localObject4).append("]");
            k = i;
            QLog.d("VFS.MigrationFileSystem", 2, ((StringBuilder)localObject4).toString());
          }
        }
        if (localObject2 != null)
        {
          k = i;
          ((TreeSet)localObject2).add(localFileEntry.relPath);
          break label1528;
          k = i;
          localObject4 = VFSUtils.getParentPath(localFileEntry.relPath);
          if (localObject4 == null) {
            break label1534;
          }
          k = i;
          if (!((HashSet)localObject1).add(localObject4)) {
            break label1531;
          }
          k = i;
          localFileSystem1.mkdirs((String)localObject4);
          k = i;
          if (!QLog.isColorLevel()) {
            break label1531;
          }
          k = i;
          localStringBuilder1 = new StringBuilder();
          k = i;
          localStringBuilder1.append("migrate file -> mkdirs :");
          k = i;
          localStringBuilder1.append((String)localObject4);
          k = i;
          localStringBuilder1.append(" [");
          k = i;
          localStringBuilder1.append(toString());
          k = i;
          localStringBuilder1.append("]");
          k = i;
          QLog.d("VFS.MigrationFileSystem", 2, localStringBuilder1.toString());
          if (localObject2 != null)
          {
            k = i;
            ((TreeSet)localObject2).add(localObject4);
          }
          k = i;
          if (localFileSystem1.exists(localFileEntry.relPath))
          {
            k = i;
            if (QLog.isColorLevel())
            {
              k = i;
              localObject4 = new StringBuilder();
              k = i;
              ((StringBuilder)localObject4).append("migrate file -> exists :");
              k = i;
              ((StringBuilder)localObject4).append(localFileEntry.relPath);
              k = i;
              ((StringBuilder)localObject4).append(" [");
              k = i;
              ((StringBuilder)localObject4).append(toString());
              k = i;
              ((StringBuilder)localObject4).append("]");
              k = i;
              QLog.d("VFS.MigrationFileSystem", 2, ((StringBuilder)localObject4).toString());
            }
            k = i;
            localFileSystem2.delete(localFileEntry.relPath);
          }
          else
          {
            k = i;
            try
            {
              localFileSystem1.moveFile(localFileEntry.relPath, localFileSystem2, localFileEntry.relPath);
              k = i;
              if (QLog.isColorLevel())
              {
                k = i;
                localStringBuilder1 = new StringBuilder();
                k = i;
                localStringBuilder1.append("migrate file -> moveFile :");
                k = i;
                localStringBuilder1.append(localFileEntry.relPath);
                k = i;
                localStringBuilder1.append(" [");
                k = i;
                localStringBuilder1.append(toString());
                k = i;
                localStringBuilder1.append("]");
                k = i;
                QLog.d("VFS.MigrationFileSystem", 2, localStringBuilder1.toString());
              }
              k = i;
              long l = localFileEntry.diskSpace;
            }
            catch (IOException localIOException2)
            {
              i += 1;
            }
          }
          try
          {
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("Failed to migrate file: ");
            localStringBuilder2.append(localFileEntry.relPath);
            localStringBuilder2.append(" [");
            localStringBuilder2.append(toString());
            localStringBuilder2.append("]");
            QLog.e("VFS.MigrationFileSystem", 1, localStringBuilder2.toString());
            if (localHashMap.size() >= 3) {
              break label1537;
            }
            localHashMap.put(localFileEntry.relPath, localIOException2.getMessage());
          }
          catch (Exception paramCancellationSignalCompat)
          {
            break label1373;
          }
          if (localObject4 != null)
          {
            ((TreeSet)localObject2).remove(localObject4);
            localObject4 = VFSUtils.getParentPath((String)localObject4);
            continue;
          }
          continue;
          i1 = j;
          localObject3 = localObject1;
          n = i;
          j = i1;
          localObject1 = localObject3;
          if (localObject2 == null) {
            break label1545;
          }
          k = i;
          localObject2 = ((TreeSet)localObject2).descendingSet().iterator();
          k = i;
          n = i;
          j = i1;
          localObject1 = localObject3;
          if (!((Iterator)localObject2).hasNext()) {
            break label1545;
          }
          k = i;
          localObject1 = (String)((Iterator)localObject2).next();
          k = i;
          paramCancellationSignalCompat.throwIfCanceled();
          k = i;
          localFileSystem2.deleteDir((String)localObject1, false);
          continue;
          k = i;
          if ((localFileSystem1 instanceof NativeFileSystem))
          {
            k = i;
            paramCancellationSignalCompat = ((NativeFileSystem)localFileSystem1).basePath();
          }
          else
          {
            k = i;
            paramCancellationSignalCompat = localFileSystem1.toString();
          }
          statistics(3, new Object[] { "destination", paramCancellationSignalCompat, "filesFailed", Integer.valueOf(i), "failedPathCollections", localHashMap });
          return;
          label1373:
          localObject2 = this;
          if ((paramCancellationSignalCompat instanceof OperationCanceledException)) {
            j = 4;
          } else {
            j = 5;
          }
          QLog.e("VFS.MigrationFileSystem", 1, "maintain error!", paramCancellationSignalCompat);
          if ((((MigrationFileSystem)localObject2).mEffectiveFS.get(0) instanceof NativeFileSystem)) {
            localObject1 = ((NativeFileSystem)((MigrationFileSystem)localObject2).mEffectiveFS.get(0)).basePath();
          } else {
            localObject1 = ((FileSystem)((MigrationFileSystem)localObject2).mEffectiveFS.get(0)).toString();
          }
          ((MigrationFileSystem)localObject2).statistics(j, new Object[] { "destination", localObject1, "filesFailed", Integer.valueOf(i), "failedDetail", paramCancellationSignalCompat.getMessage(), "failedPathCollections", localHashMap });
          for (;;)
          {
            throw paramCancellationSignalCompat;
          }
        }
      }
      label1528:
      label1531:
      label1534:
      m += 1;
      label1537:
      label1545:
      int i = n;
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
    Object localObject1 = this.mFSList;
    int j = localObject1.length;
    boolean bool = false;
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
    paramMap = this.mFSList;
    Object localObject3;
    Object localObject2;
    if ((paramMap[0] instanceof NativeFileSystem))
    {
      localObject3 = ((NativeFileSystem)paramMap[0]).basePath();
      if (localObject3 != null)
      {
        localObject2 = new File((String)localObject3);
        paramMap = (Map<String, String>)localObject2;
        if (((File)localObject2).exists()) {
          paramMap = null;
        }
        localHashSet.add(localObject3);
        break label149;
      }
    }
    paramMap = null;
    label149:
    if (!this.mSpeedMigrateSucc)
    {
      j = 0;
      localObject1 = "";
      i = 1;
      localObject2 = paramMap;
      paramMap = (Map<String, String>)localObject1;
      for (;;)
      {
        localObject1 = this.mFSList;
        if (i >= localObject1.length) {
          break;
        }
        int k;
        if (!(localObject1[i] instanceof NativeFileSystem))
        {
          this.mEffectiveFS.add(localObject1[i]);
          k = j;
          localObject1 = paramMap;
          localObject3 = localObject2;
        }
        else
        {
          NativeFileSystem localNativeFileSystem = (NativeFileSystem)localObject1[i];
          String str = localNativeFileSystem.basePath();
          k = j;
          localObject1 = paramMap;
          localObject3 = localObject2;
          if (str != null)
          {
            localObject1 = new File(str);
            if (((File)localObject1).isDirectory())
            {
              if (localObject2 == null) {
                paramMap = "dest dir is exist, so fast rename is failed";
              }
              if (localObject2 != null)
              {
                if (((File)localObject1).renameTo((File)localObject2))
                {
                  k = j + 1;
                  if (QLog.isColorLevel())
                  {
                    localObject3 = new StringBuilder();
                    ((StringBuilder)localObject3).append("Fast moved '");
                    ((StringBuilder)localObject3).append(localObject1);
                    ((StringBuilder)localObject3).append("' -> '");
                    ((StringBuilder)localObject3).append(localObject2);
                    ((StringBuilder)localObject3).append("'");
                    QLog.i("VFS.MigrationFileSystem", 2, ((StringBuilder)localObject3).toString());
                  }
                  localObject3 = null;
                  localObject1 = paramMap;
                }
                else
                {
                  localObject1 = "srcDir renameTo destDir is error!";
                  k = j;
                  localObject3 = localObject2;
                }
              }
              else
              {
                k = j;
                localObject1 = paramMap;
                localObject3 = localObject2;
                if (localHashSet.add(str))
                {
                  this.mEffectiveFS.add(localNativeFileSystem);
                  k = j;
                  localObject1 = paramMap;
                  localObject3 = localObject2;
                }
              }
            }
            else
            {
              localObject1 = "srcDir not is Directory";
              localObject3 = localObject2;
              k = j;
            }
          }
        }
        i += 1;
        j = k;
        paramMap = (Map<String, String>)localObject1;
        localObject2 = localObject3;
      }
      if (j == localObject1.length - 1) {
        this.mSpeedMigrateSucc = true;
      }
      localObject1 = paramMap;
    }
    if ((!this.mSpeedMigrateSucc) && ((this.mEffectiveFS.get(0) instanceof NativeFileSystem))) {
      statistics(7, new Object[] { "destination", ((NativeFileSystem)this.mEffectiveFS.get(0)).basePath(), "fastMigrateState", Boolean.valueOf(this.mSpeedMigrateSucc), "fastMigrateError", localObject1 });
    }
    if (this.mPositiveMacro != null) {
      bool = true;
    }
    this.mPositive = bool;
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
    Iterator localIterator = this.mEffectiveFS.iterator();
    Object localObject1 = null;
    while (localIterator.hasNext())
    {
      Object localObject2 = (FileSystem)localIterator.next();
      try
      {
        localObject2 = ((FileSystem)localObject2).openRead(paramString);
        if (localObject2 == null) {
          continue;
        }
        return localObject2;
      }
      catch (FileNotFoundException localFileNotFoundException) {}
      if (localObject1 == null) {
        localObject1 = localFileNotFoundException;
      }
    }
    if (localObject1 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" not found on any file systems.");
      localObject1 = new FileNotFoundException(((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  public ReadableByteChannel openReadChannel(String paramString)
  {
    Iterator localIterator = this.mEffectiveFS.iterator();
    Object localObject1 = null;
    while (localIterator.hasNext())
    {
      Object localObject2 = (FileSystem)localIterator.next();
      try
      {
        localObject2 = ((FileSystem)localObject2).openReadChannel(paramString);
        if (localObject2 == null) {
          continue;
        }
        return localObject2;
      }
      catch (FileNotFoundException localFileNotFoundException) {}
      if (localObject1 == null) {
        localObject1 = localFileNotFoundException;
      }
    }
    if (localObject1 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" not found on any file systems.");
      localObject1 = new FileNotFoundException(((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      throw ((Throwable)localObject1);
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
    StringBuilder localStringBuilder = new StringBuilder("Migration [");
    localStringBuilder.append(this.mFSList[0].toString());
    localStringBuilder.append(" <= ");
    int i = 1;
    for (;;)
    {
      FileSystem[] arrayOfFileSystem = this.mFSList;
      if (i >= arrayOfFileSystem.length) {
        break;
      }
      localStringBuilder.append(arrayOfFileSystem[i].toString());
      localStringBuilder.append(", ");
      i += 1;
    }
    localStringBuilder.setLength(localStringBuilder.length() - 2);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.vfs.MigrationFileSystem
 * JD-Core Version:    0.7.0.1
 */