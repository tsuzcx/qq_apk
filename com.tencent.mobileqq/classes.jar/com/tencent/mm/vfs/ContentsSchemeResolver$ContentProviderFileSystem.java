package com.tencent.mm.vfs;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;

final class ContentsSchemeResolver$ContentProviderFileSystem
  extends AbstractFileSystem
{
  public static final Parcelable.Creator<ContentProviderFileSystem> CREATOR;
  private final ContentResolver mCR;
  
  ContentsSchemeResolver$ContentProviderFileSystem(Context paramContext)
  {
    this.mCR = paramContext.getContentResolver();
  }
  
  public int capabilityFlags()
  {
    return 1;
  }
  
  public boolean delete(String paramString)
  {
    return this.mCR.delete(Uri.parse(paramString), null, null) >= 1;
  }
  
  public boolean deleteDir(String paramString, boolean paramBoolean)
  {
    return false;
  }
  
  public boolean exists(String paramString)
  {
    return stat(paramString) != null;
  }
  
  public FileSystem.FsStat fileSystemStat(String paramString)
  {
    return new FileSystem.FsStat();
  }
  
  public Iterable<FileSystem.FileEntry> list(String paramString, boolean paramBoolean)
  {
    return null;
  }
  
  public boolean mkdirs(String paramString)
  {
    return false;
  }
  
  public ParcelFileDescriptor openParcelFd(String paramString1, String paramString2)
  {
    return this.mCR.openFileDescriptor(Uri.parse(paramString1), paramString2);
  }
  
  public InputStream openRead(String paramString)
  {
    return this.mCR.openInputStream(Uri.parse(paramString));
  }
  
  public ByteChannel openReadWriteChannel(String paramString)
  {
    throw new FileNotFoundException("Not supported.");
  }
  
  public OutputStream openWrite(String paramString, boolean paramBoolean)
  {
    ContentResolver localContentResolver = this.mCR;
    Uri localUri = Uri.parse(paramString);
    if (paramBoolean) {
      paramString = "wa";
    } else {
      paramString = "w";
    }
    return localContentResolver.openOutputStream(localUri, paramString);
  }
  
  public String realPath(String paramString, boolean paramBoolean)
  {
    return null;
  }
  
  public boolean setModifiedTime(String paramString, long paramLong)
  {
    return false;
  }
  
  /* Error */
  public FileSystem.FileEntry stat(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 24	com/tencent/mm/vfs/ContentsSchemeResolver$ContentProviderFileSystem:mCR	Landroid/content/ContentResolver;
    //   4: aload_1
    //   5: invokestatic 34	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   8: aconst_null
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: invokevirtual 95	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   15: astore 5
    //   17: aload 5
    //   19: ifnonnull +10 -> 29
    //   22: aload 5
    //   24: invokestatic 101	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Landroid/database/Cursor;)V
    //   27: aconst_null
    //   28: areturn
    //   29: aload 5
    //   31: ldc 103
    //   33: invokeinterface 109 2 0
    //   38: istore_2
    //   39: aload 5
    //   41: ldc 111
    //   43: invokeinterface 109 2 0
    //   48: istore_3
    //   49: aload 5
    //   51: invokeinterface 115 1 0
    //   56: istore 4
    //   58: iload 4
    //   60: ifne +10 -> 70
    //   63: aload 5
    //   65: invokestatic 101	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Landroid/database/Cursor;)V
    //   68: aconst_null
    //   69: areturn
    //   70: new 117	com/tencent/mm/vfs/FileSystem$FileEntry
    //   73: dup
    //   74: aload_0
    //   75: aload_1
    //   76: aload 5
    //   78: iload_2
    //   79: invokeinterface 121 2 0
    //   84: aload 5
    //   86: iload_3
    //   87: invokeinterface 125 2 0
    //   92: lconst_0
    //   93: lconst_0
    //   94: iconst_0
    //   95: invokespecial 128	com/tencent/mm/vfs/FileSystem$FileEntry:<init>	(Lcom/tencent/mm/vfs/FileSystem;Ljava/lang/String;Ljava/lang/String;JJJZ)V
    //   98: astore_1
    //   99: aload 5
    //   101: invokestatic 101	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Landroid/database/Cursor;)V
    //   104: aload_1
    //   105: areturn
    //   106: astore_1
    //   107: goto +7 -> 114
    //   110: astore_1
    //   111: aconst_null
    //   112: astore 5
    //   114: aload 5
    //   116: invokestatic 101	com/tencent/mm/vfs/VFSUtils:closeQuietly	(Landroid/database/Cursor;)V
    //   119: aload_1
    //   120: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	ContentProviderFileSystem
    //   0	121	1	paramString	String
    //   38	41	2	i	int
    //   48	39	3	j	int
    //   56	3	4	bool	boolean
    //   15	100	5	localCursor	android.database.Cursor
    // Exception table:
    //   from	to	target	type
    //   29	58	106	finally
    //   70	99	106	finally
    //   0	17	110	finally
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.vfs.ContentsSchemeResolver.ContentProviderFileSystem
 * JD-Core Version:    0.7.0.1
 */