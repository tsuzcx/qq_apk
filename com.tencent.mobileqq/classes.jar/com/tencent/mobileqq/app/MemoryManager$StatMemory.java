package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bhcu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.HashMap;

class MemoryManager$StatMemory
{
  public long dalvikHeapSize;
  public long dalvikPss;
  public long imageCacheMax;
  public long imageCacheUsed;
  public int imageHitCount;
  public int imageMissCount;
  public long nativePss;
  public long qqOtherUsedMemory;
  public long qqUsedMemory;
  private String spKey;
  public int statCount;
  public long sysAvailableMemory;
  
  public void init(String paramString)
  {
    this.spKey = paramString;
    try
    {
      paramString = BaseApplicationImpl.getApplication().getSharedPreferences("MemoryManagerMemoryStat", 0).getString(this.spKey, null);
      if ((paramString == null) || (paramString.length() == 0))
      {
        reset();
        return;
      }
      paramString = new DataInputStream(new ByteArrayInputStream(bhcu.decode(paramString, 0)));
      this.statCount = paramString.readInt();
      this.sysAvailableMemory = paramString.readLong();
      this.qqOtherUsedMemory = paramString.readLong();
      this.qqUsedMemory = paramString.readLong();
      this.imageCacheMax = paramString.readLong();
      this.imageCacheUsed = paramString.readLong();
      this.imageMissCount = paramString.readInt();
      this.imageHitCount = paramString.readInt();
      this.nativePss = paramString.readLong();
      this.dalvikPss = paramString.readLong();
      this.dalvikHeapSize = paramString.readLong();
      return;
    }
    catch (Exception paramString)
    {
      paramString = new HashMap(3);
      paramString.put("type", "wrong-value");
      paramString.put("file", "MemoryManagerMemoryStat");
      paramString.put("key", "MemoryInfomation");
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "evSpError", true, 0L, 0L, paramString, null);
      reset();
    }
  }
  
  public void reset()
  {
    this.statCount = 0;
    this.sysAvailableMemory = 0L;
    this.qqOtherUsedMemory = 0L;
    this.qqUsedMemory = 0L;
    this.imageCacheMax = 0L;
    this.imageCacheUsed = 0L;
    this.imageMissCount = 0;
    this.imageHitCount = 0;
    this.nativePss = 0L;
    this.dalvikPss = 0L;
    this.dalvikHeapSize = 0L;
  }
  
  public void save()
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
      localDataOutputStream.writeInt(this.statCount);
      localDataOutputStream.writeLong(this.sysAvailableMemory);
      localDataOutputStream.writeLong(this.qqOtherUsedMemory);
      localDataOutputStream.writeLong(this.qqUsedMemory);
      localDataOutputStream.writeLong(this.imageCacheMax);
      localDataOutputStream.writeLong(this.imageCacheUsed);
      localDataOutputStream.writeInt(this.imageMissCount);
      localDataOutputStream.writeInt(this.imageHitCount);
      localDataOutputStream.writeLong(this.nativePss);
      localDataOutputStream.writeLong(this.dalvikPss);
      localDataOutputStream.writeLong(this.dalvikHeapSize);
      localDataOutputStream.flush();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      BaseApplicationImpl.getApplication().getSharedPreferences("MemoryManagerMemoryStat", 0).edit().putString(this.spKey, bhcu.encodeToString((byte[])localObject, 0)).commit();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.Memory.MemoryManager", 2, "StatMemory.save exception", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MemoryManager.StatMemory
 * JD-Core Version:    0.7.0.1
 */