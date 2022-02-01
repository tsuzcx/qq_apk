package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Collections;
import java.util.Iterator;

public class ExpireFileSystem
  extends DelegateFileSystem
{
  public static final Parcelable.Creator<ExpireFileSystem> CREATOR = new ExpireFileSystem.1();
  private static final int VERSION = 1;
  private final long mExpireTime;
  private final FileSystem mFS;
  private final Iterable<FileSystem> mFSList;
  
  protected ExpireFileSystem(Parcel paramParcel)
  {
    VFSUtils.checkFileSystemVersion(paramParcel, ExpireFileSystem.class, 1);
    this.mFS = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
    FileSystem localFileSystem = this.mFS;
    if (localFileSystem != null)
    {
      this.mFSList = Collections.singletonList(localFileSystem);
      this.mExpireTime = paramParcel.readLong();
      return;
    }
    throw new IllegalArgumentException("Wrong wrapped filesystem.");
  }
  
  public ExpireFileSystem(FileSystem paramFileSystem, long paramLong)
  {
    this.mFS = paramFileSystem;
    this.mFSList = Collections.singletonList(this.mFS);
    this.mExpireTime = paramLong;
  }
  
  protected Iterable<FileSystem> allFileSystems()
  {
    return this.mFSList;
  }
  
  protected FileSystem delegate(String paramString, int paramInt)
  {
    return this.mFS;
  }
  
  public void maintain(CancellationSignalCompat paramCancellationSignalCompat)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.mExpireTime;
    Object localObject = this.mFS.list("", true);
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        FileSystem.FileEntry localFileEntry = (FileSystem.FileEntry)((Iterator)localObject).next();
        paramCancellationSignalCompat.throwIfCanceled();
        if ((!localFileEntry.isDirectory) && (localFileEntry.modifiedTime <= l1 - l2)) {
          localFileEntry.delete();
        }
      }
    }
    super.maintain(paramCancellationSignalCompat);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    VFSUtils.writeFileSystemVersion(paramParcel, ExpireFileSystem.class, 1);
    paramParcel.writeParcelable(this.mFS, paramInt);
    paramParcel.writeLong(this.mExpireTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.vfs.ExpireFileSystem
 * JD-Core Version:    0.7.0.1
 */