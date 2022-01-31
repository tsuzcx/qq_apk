package com.tencent.image;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.Arrays;

public class MmapCache
{
  public static final int FIND_RESULT_FAILURE = -1;
  public static final int FIND_RESULT_FIND = 1;
  public static final int FIND_RESULT_SAVE = 0;
  public static final int HEAD_BYTE = 14;
  public static final int HEAD_MAX_POSITION = 10;
  public static final int HEAD_START_POSITION = 2;
  public static final int HEAD_VALID_POSITION = 6;
  public static final int MAX_ENTRY = 500;
  public static final int PER_ENTRY_BYTE = 16;
  private static final String TAG = "SafeBitmapFactory";
  private static final byte[] TYPE = { 77, 67 };
  private static volatile MmapCache instance;
  private MappedByteBuffer mMappedBuffer = null;
  private String path = "";
  
  private void createHead()
  {
    if (this.mMappedBuffer == null) {
      return;
    }
    this.mMappedBuffer.position(0);
    this.mMappedBuffer.put(TYPE[0]);
    this.mMappedBuffer.put(TYPE[1]);
    this.mMappedBuffer.putInt(0);
    this.mMappedBuffer.putInt(0);
    this.mMappedBuffer.putInt(500);
    this.mMappedBuffer.force();
  }
  
  /* Error */
  public static MmapCache getInstance(String paramString)
  {
    // Byte code:
    //   0: getstatic 75	com/tencent/image/MmapCache:instance	Lcom/tencent/image/MmapCache;
    //   3: ifnonnull +45 -> 48
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 75	com/tencent/image/MmapCache:instance	Lcom/tencent/image/MmapCache;
    //   12: ifnonnull +33 -> 45
    //   15: new 2	com/tencent/image/MmapCache
    //   18: dup
    //   19: invokespecial 76	com/tencent/image/MmapCache:<init>	()V
    //   22: putstatic 75	com/tencent/image/MmapCache:instance	Lcom/tencent/image/MmapCache;
    //   25: getstatic 75	com/tencent/image/MmapCache:instance	Lcom/tencent/image/MmapCache;
    //   28: getstatic 75	com/tencent/image/MmapCache:instance	Lcom/tencent/image/MmapCache;
    //   31: aload_0
    //   32: invokespecial 80	com/tencent/image/MmapCache:getMappedBuffer	(Ljava/lang/String;)Ljava/nio/MappedByteBuffer;
    //   35: putfield 46	com/tencent/image/MmapCache:mMappedBuffer	Ljava/nio/MappedByteBuffer;
    //   38: getstatic 75	com/tencent/image/MmapCache:instance	Lcom/tencent/image/MmapCache;
    //   41: aload_0
    //   42: putfield 50	com/tencent/image/MmapCache:path	Ljava/lang/String;
    //   45: ldc 2
    //   47: monitorexit
    //   48: aload_0
    //   49: getstatic 75	com/tencent/image/MmapCache:instance	Lcom/tencent/image/MmapCache;
    //   52: getfield 50	com/tencent/image/MmapCache:path	Ljava/lang/String;
    //   55: invokevirtual 86	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   58: ifne +22 -> 80
    //   61: ldc 2
    //   63: monitorenter
    //   64: getstatic 75	com/tencent/image/MmapCache:instance	Lcom/tencent/image/MmapCache;
    //   67: getstatic 75	com/tencent/image/MmapCache:instance	Lcom/tencent/image/MmapCache;
    //   70: aload_0
    //   71: invokespecial 80	com/tencent/image/MmapCache:getMappedBuffer	(Ljava/lang/String;)Ljava/nio/MappedByteBuffer;
    //   74: putfield 46	com/tencent/image/MmapCache:mMappedBuffer	Ljava/nio/MappedByteBuffer;
    //   77: ldc 2
    //   79: monitorexit
    //   80: getstatic 75	com/tencent/image/MmapCache:instance	Lcom/tencent/image/MmapCache;
    //   83: areturn
    //   84: astore_0
    //   85: ldc 2
    //   87: monitorexit
    //   88: aload_0
    //   89: athrow
    //   90: astore_0
    //   91: aload_0
    //   92: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   95: goto -15 -> 80
    //   98: astore_0
    //   99: ldc 2
    //   101: monitorexit
    //   102: aload_0
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	paramString	String
    // Exception table:
    //   from	to	target	type
    //   9	45	84	finally
    //   45	48	84	finally
    //   85	88	84	finally
    //   0	9	90	java/io/IOException
    //   48	64	90	java/io/IOException
    //   88	90	90	java/io/IOException
    //   102	104	90	java/io/IOException
    //   64	80	98	finally
    //   99	102	98	finally
  }
  
  private MappedByteBuffer getMappedBuffer(String paramString)
  {
    try
    {
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(paramString, "rw");
      paramString = localRandomAccessFile;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        File localFile1 = new File(paramString);
        File localFile2 = new File(localFile1.getParent());
        if (!localFile2.exists()) {
          localFile2.mkdirs();
        }
        localFile1.createNewFile();
        paramString = new RandomAccessFile(paramString, "rw");
        this.mMappedBuffer = paramString.getChannel().map(FileChannel.MapMode.READ_WRITE, 0L, 8030L);
        createHead();
      }
    }
    if (this.mMappedBuffer == null) {
      this.mMappedBuffer = paramString.getChannel().map(FileChannel.MapMode.READ_WRITE, 0L, 8030L);
    }
    if (paramString != null) {
      paramString.close();
    }
    return this.mMappedBuffer;
  }
  
  public void deleteItem(String paramString)
  {
    int k;
    int m;
    int n;
    for (;;)
    {
      try
      {
        paramString = MD5Util.byteArrayToMd5(paramString);
        if (paramString == null) {
          return;
        }
        if (this.mMappedBuffer == null) {
          continue;
        }
        this.mMappedBuffer.position(0);
        if ((this.mMappedBuffer.get() != TYPE[0]) || (this.mMappedBuffer.get() != TYPE[1]))
        {
          createHead();
          continue;
        }
        this.mMappedBuffer.position(2);
      }
      finally {}
      k = this.mMappedBuffer.getInt();
      m = this.mMappedBuffer.getInt();
      n = this.mMappedBuffer.getInt();
      if ((n >= 0) && (n >= k) && (n >= m)) {
        break;
      }
      createHead();
    }
    byte[] arrayOfByte = new byte[16];
    int i = m - 1;
    label145:
    int j;
    if (i >= 0)
    {
      j = (k + i) % n;
      this.mMappedBuffer.position(j * 16 + 14);
      this.mMappedBuffer.get(arrayOfByte, 0, 16);
      if (!Arrays.equals(arrayOfByte, paramString)) {
        break label351;
      }
      if (!QLog.isColorLevel()) {
        break label358;
      }
      QLog.d("SafeBitmapFactory", 2, "deleteItem() 找到了,pos:" + j);
      break label358;
      label228:
      if (i < m - 1)
      {
        j = (k + i) % n;
        this.mMappedBuffer.position(j * 16 + 14);
        this.mMappedBuffer.get(arrayOfByte, 0, 16);
        if (j != 0) {
          break label365;
        }
        j = n - 1;
      }
    }
    for (;;)
    {
      this.mMappedBuffer.position(j * 16 + 14);
      this.mMappedBuffer.put(arrayOfByte);
      i += 1;
      break label228;
      if (m > 0)
      {
        this.mMappedBuffer.position(6);
        this.mMappedBuffer.putInt(m - 1);
      }
      this.mMappedBuffer.force();
      break;
      label351:
      i -= 1;
      break label145;
      label358:
      i += 1;
      break label228;
      label365:
      j -= 1;
    }
  }
  
  public int findOrAddItem(String paramString)
  {
    int i = -1;
    int j;
    int k;
    int m;
    label156:
    label160:
    try
    {
      paramString = MD5Util.byteArrayToMd5(paramString);
      if (paramString == null) {}
      while (this.mMappedBuffer == null) {
        return i;
      }
      this.mMappedBuffer.position(0);
      if ((this.mMappedBuffer.get() != TYPE[0]) || (this.mMappedBuffer.get() != TYPE[1])) {
        createHead();
      }
      this.mMappedBuffer.position(2);
      j = this.mMappedBuffer.getInt();
      k = this.mMappedBuffer.getInt();
      m = this.mMappedBuffer.getInt();
      if (!QLog.isColorLevel()) {
        break label391;
      }
      QLog.d("SafeBitmapFactory", 2, "findOrAddItem() start:" + j + "，valid:" + k + "，max:" + m);
    }
    finally {}
    createHead();
    byte[] arrayOfByte = new byte[16];
    i = k - 1;
    for (;;)
    {
      if (i >= 0)
      {
        this.mMappedBuffer.position((j + i) % m * 16 + 14);
        this.mMappedBuffer.get(arrayOfByte, 0, 16);
        if (!Arrays.equals(arrayOfByte, paramString)) {
          break label412;
        }
        i = 1;
        break;
      }
      this.mMappedBuffer.position((j + k) % m * 16 + 14);
      this.mMappedBuffer.put(paramString);
      if (k < m)
      {
        i = k + 1;
        this.mMappedBuffer.position(6);
        this.mMappedBuffer.putInt(i);
        if (QLog.isColorLevel()) {
          QLog.d("SafeBitmapFactory", 2, "findOrAddItem() 没找到 ，总数未满跟新 valid:" + i);
        }
      }
      for (;;)
      {
        this.mMappedBuffer.force();
        i = 0;
        break;
        i = (j + 1) % m;
        this.mMappedBuffer.position(2);
        this.mMappedBuffer.putInt(i);
        if (QLog.isColorLevel()) {
          QLog.d("SafeBitmapFactory", 2, "findOrAddItem() 没找到 ，总数已满跟新 start:" + i);
        }
      }
      label391:
      if ((m < 0) || (m < j)) {
        break label156;
      }
      if (m >= k) {
        break label160;
      }
      break label156;
      label412:
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.MmapCache
 * JD-Core Version:    0.7.0.1
 */