package com.tencent.image;

import com.tencent.image.api.ILog;
import com.tencent.image.api.URLDrawableDepWrap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    MappedByteBuffer localMappedByteBuffer = this.mMappedBuffer;
    if (localMappedByteBuffer == null) {
      return;
    }
    localMappedByteBuffer.position(0);
    this.mMappedBuffer.put(TYPE[0]);
    this.mMappedBuffer.put(TYPE[1]);
    this.mMappedBuffer.putInt(0);
    this.mMappedBuffer.putInt(0);
    this.mMappedBuffer.putInt(500);
    this.mMappedBuffer.force();
  }
  
  public static MmapCache getInstance(String paramString)
  {
    try
    {
      if (instance == null) {
        try
        {
          if (instance == null)
          {
            instance = new MmapCache();
            instance.mMappedBuffer = instance.getMappedBuffer(paramString);
            instance.path = paramString;
          }
        }
        finally {}
      }
      if (!paramString.equals(instance.path)) {
        try
        {
          instance.mMappedBuffer = instance.getMappedBuffer(paramString);
        }
        finally {}
      }
      return instance;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private MappedByteBuffer getMappedBuffer(String paramString)
  {
    try
    {
      localObject = new RandomAccessFile(paramString, "rw");
      paramString = (String)localObject;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Object localObject;
      label16:
      File localFile;
      break label16;
    }
    localObject = new File(paramString);
    localFile = new File(((File)localObject).getParent());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    ((File)localObject).createNewFile();
    paramString = new RandomAccessFile(paramString, "rw");
    this.mMappedBuffer = paramString.getChannel().map(FileChannel.MapMode.READ_WRITE, 0L, 8030L);
    createHead();
    if (this.mMappedBuffer == null) {
      this.mMappedBuffer = paramString.getChannel().map(FileChannel.MapMode.READ_WRITE, 0L, 8030L);
    }
    paramString.close();
    return this.mMappedBuffer;
  }
  
  public void deleteItem(String paramString)
  {
    try
    {
      localObject = MD5Util.byteArrayToMd5(paramString);
      if (localObject == null) {
        return;
      }
      paramString = this.mMappedBuffer;
      if (paramString == null) {
        return;
      }
      this.mMappedBuffer.position(0);
      if ((this.mMappedBuffer.get() != TYPE[0]) || (this.mMappedBuffer.get() != TYPE[1])) {
        break label384;
      }
      this.mMappedBuffer.position(2);
      m = this.mMappedBuffer.getInt();
      n = this.mMappedBuffer.getInt();
      i1 = this.mMappedBuffer.getInt();
      if ((i1 < 0) || (i1 < m) || (i1 < n)) {
        break label377;
      }
      paramString = new byte[16];
      k = n - 1;
      i = k;
    }
    finally
    {
      for (;;)
      {
        Object localObject;
        int m;
        int n;
        int i1;
        int k;
        int i;
        int j;
        StringBuilder localStringBuilder;
        label384:
        for (;;)
        {
          label377:
          throw paramString;
        }
        label402:
        i += 1;
        continue;
        label409:
        j -= 1;
        continue;
        label416:
        i -= 1;
      }
    }
    if (i >= 0)
    {
      j = (m + i) % i1;
      this.mMappedBuffer.position(j * 16 + 14);
      this.mMappedBuffer.get(paramString, 0, 16);
      if (!Arrays.equals(paramString, (byte[])localObject)) {
        break label416;
      }
      if (!URLDrawable.depImp.mLog.isColorLevel()) {
        break label402;
      }
      localObject = URLDrawable.depImp.mLog;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("deleteItem() 找到了,pos:");
      localStringBuilder.append(j);
      ((ILog)localObject).d("SafeBitmapFactory", 2, localStringBuilder.toString());
      break label402;
      while (i < k)
      {
        j = (m + i) % i1;
        this.mMappedBuffer.position(j * 16 + 14);
        this.mMappedBuffer.get(paramString, 0, 16);
        if (j != 0) {
          break label409;
        }
        j = i1 - 1;
        this.mMappedBuffer.position(j * 16 + 14);
        this.mMappedBuffer.put(paramString);
        i += 1;
      }
      if (n > 0)
      {
        this.mMappedBuffer.position(6);
        this.mMappedBuffer.putInt(k);
      }
    }
    this.mMappedBuffer.force();
    return;
    createHead();
    return;
    createHead();
  }
  
  public int findOrAddItem(String paramString)
  {
    try
    {
      paramString = MD5Util.byteArrayToMd5(paramString);
      if (paramString == null) {
        return -1;
      }
      localObject = this.mMappedBuffer;
      if (localObject == null) {
        return -1;
      }
      this.mMappedBuffer.position(0);
      if ((this.mMappedBuffer.get() != TYPE[0]) || (this.mMappedBuffer.get() != TYPE[1])) {
        createHead();
      }
      this.mMappedBuffer.position(2);
      j = this.mMappedBuffer.getInt();
      k = this.mMappedBuffer.getInt();
      m = this.mMappedBuffer.getInt();
      if (!URLDrawable.depImp.mLog.isColorLevel()) {
        break label510;
      }
      localObject = URLDrawable.depImp.mLog;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("findOrAddItem() start:");
      localStringBuilder.append(j);
      localStringBuilder.append("，valid:");
      localStringBuilder.append(k);
      localStringBuilder.append("，max:");
      localStringBuilder.append(m);
      ((ILog)localObject).d("SafeBitmapFactory", 2, localStringBuilder.toString());
    }
    finally
    {
      for (;;)
      {
        Object localObject;
        int j;
        int k;
        int m;
        int i;
        for (;;)
        {
          throw paramString;
        }
        label510:
        if ((m >= 0) && (m >= j)) {
          if (m >= k) {}
        }
      }
    }
    createHead();
    localObject = new byte[16];
    i = k - 1;
    while (i >= 0)
    {
      this.mMappedBuffer.position((j + i) % m * 16 + 14);
      this.mMappedBuffer.get((byte[])localObject, 0, 16);
      boolean bool = Arrays.equals((byte[])localObject, paramString);
      if (bool) {
        return 1;
      }
      i -= 1;
    }
    this.mMappedBuffer.position((j + k) % m * 16 + 14);
    this.mMappedBuffer.put(paramString);
    if (k < m)
    {
      i = k + 1;
      this.mMappedBuffer.position(6);
      this.mMappedBuffer.putInt(i);
      if (URLDrawable.depImp.mLog.isColorLevel())
      {
        paramString = URLDrawable.depImp.mLog;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("findOrAddItem() 没找到 ，总数未满跟新 valid:");
        ((StringBuilder)localObject).append(i);
        paramString.d("SafeBitmapFactory", 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      i = (j + 1) % m;
      this.mMappedBuffer.position(2);
      this.mMappedBuffer.putInt(i);
      if (URLDrawable.depImp.mLog.isColorLevel())
      {
        paramString = URLDrawable.depImp.mLog;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("findOrAddItem() 没找到 ，总数已满跟新 start:");
        ((StringBuilder)localObject).append(i);
        paramString.d("SafeBitmapFactory", 2, ((StringBuilder)localObject).toString());
      }
    }
    this.mMappedBuffer.force();
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.image.MmapCache
 * JD-Core Version:    0.7.0.1
 */