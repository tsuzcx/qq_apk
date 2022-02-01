package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bfuc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;

class MemoryManager$LowMemoryReport
{
  int clearCount;
  long clearRemainMemory;
  long clearWarningMemory;
  int lowMemoryCount;
  long lowRemainMemory;
  long lowWarningMemory;
  long reportTime;
  
  public void init()
  {
    long l = DeviceInfoUtil.getSystemTotalMemory();
    try
    {
      Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("MemoryManagerMemoryStat", 0).getString("LowMemoryStat", null);
      if (localObject == null) {
        return;
      }
      if (((String)localObject).length() == 0) {
        return;
      }
      localObject = new DataInputStream(new ByteArrayInputStream(bfuc.decode((String)localObject, 0)));
      this.lowRemainMemory = ((DataInputStream)localObject).readLong();
      this.lowWarningMemory = ((DataInputStream)localObject).readLong();
      this.lowMemoryCount = ((DataInputStream)localObject).readInt();
      this.clearRemainMemory = ((DataInputStream)localObject).readLong();
      this.clearWarningMemory = ((DataInputStream)localObject).readLong();
      this.clearCount = ((DataInputStream)localObject).readInt();
      this.reportTime = ((DataInputStream)localObject).readLong();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        reset();
      }
    }
    if ((l < this.lowRemainMemory) || (l < this.lowWarningMemory) || (l < this.clearRemainMemory) || (l < this.clearWarningMemory))
    {
      reset();
      return;
    }
  }
  
  public void reset()
  {
    this.lowRemainMemory = 0L;
    this.lowWarningMemory = 0L;
    this.lowMemoryCount = 0;
    this.clearRemainMemory = 0L;
    this.clearWarningMemory = 0L;
    this.clearCount = 0;
    this.reportTime = 0L;
  }
  
  public void save()
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
      localDataOutputStream.writeLong(this.lowRemainMemory);
      localDataOutputStream.writeLong(this.lowWarningMemory);
      localDataOutputStream.writeInt(this.lowMemoryCount);
      localDataOutputStream.writeLong(this.clearRemainMemory);
      localDataOutputStream.writeLong(this.clearWarningMemory);
      localDataOutputStream.writeInt(this.clearCount);
      localDataOutputStream.writeLong(this.reportTime);
      localDataOutputStream.flush();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      BaseApplicationImpl.getApplication().getSharedPreferences("MemoryManagerMemoryStat", 0).edit().putString("LowMemoryStat", bfuc.encodeToString((byte[])localObject, 0)).commit();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MemoryManager.LowMemoryReport
 * JD-Core Version:    0.7.0.1
 */