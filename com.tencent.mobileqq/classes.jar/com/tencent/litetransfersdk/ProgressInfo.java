package com.tencent.litetransfersdk;

import atmp;
import atmq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RouterMsgRecord;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class ProgressInfo
{
  public static final int Fail = 4;
  public static final int Queueing = 1;
  public static final int Running = 2;
  public static final int Success = 3;
  public static final int Unknown = 0;
  public String filename;
  public String filepath;
  private int nCount_for_timeout;
  public String timeDes;
  private int uint32_status = 2;
  public long uint64_fileSize;
  public long uint64_progress;
  public long uint64_sessionid;
  private long uint64_time;
  
  public void GetFilePath(QQAppInterface paramQQAppInterface, long paramLong)
  {
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    List localList = paramQQAppInterface.a(RouterMsgRecord.class, "select * from " + RouterMsgRecord.sBasicTableName + paramLong + " where uSessionID = ?", new String[] { String.valueOf(this.uint64_sessionid) });
    paramQQAppInterface.a();
    if ((localList != null) && (localList.size() > 0)) {
      this.filepath = ((RouterMsgRecord)localList.get(0)).filename;
    }
  }
  
  public int GetStatus()
  {
    return this.uint32_status;
  }
  
  public long GetTime()
  {
    return this.uint64_time;
  }
  
  public int GetWeight()
  {
    if (this.uint32_status == 2) {
      return 20;
    }
    if (this.uint32_status == 1) {
      return 30;
    }
    if (this.uint32_status == 4) {
      return 40;
    }
    if (this.uint32_status == 3) {
      return 50;
    }
    if (this.uint32_status == 0) {
      return 60;
    }
    return 0;
  }
  
  public boolean IsComplete()
  {
    return (this.uint32_status == 4) || (this.uint32_status == 3);
  }
  
  public boolean IsPersistentTimeout()
  {
    return this.nCount_for_timeout >= 2;
  }
  
  public void SetStatus(int paramInt)
  {
    this.nCount_for_timeout = 0;
    this.uint32_status = paramInt;
  }
  
  public void SetTime(long paramLong)
  {
    if (this.uint64_time == paramLong) {
      return;
    }
    this.uint64_time = paramLong;
    this.timeDes = new SimpleDateFormat("\nMM-dd HH:mm:ss").format(new Date(this.uint64_time * 1000L));
  }
  
  public void SetTimeout()
  {
    if (!IsComplete()) {
      this.nCount_for_timeout += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.litetransfersdk.ProgressInfo
 * JD-Core Version:    0.7.0.1
 */