package com.dataline.mpfile;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="time,msgid")
public class MpfileTaskRecord
  extends MessageRecord
  implements Cloneable
{
  public long currentSize;
  public long din;
  public String fileId;
  public String fileName;
  public String filePath;
  public String fileTempPath;
  public String fileTime;
  public long sessionId;
  public long totalSize;
  
  public MpfileTaskRecord()
  {
    this.selfuin = String.valueOf(AppConstants.DATALINE_PC_UIN);
    this.frienduin = this.selfuin;
    this.senderuin = this.selfuin;
    this.istroop = 6000;
    this.versionCode = 1;
  }
  
  public static String tableName()
  {
    return "mr_dataline_mpfile";
  }
  
  public MpfileTaskRecord clone()
  {
    try
    {
      MpfileTaskRecord localMpfileTaskRecord = (MpfileTaskRecord)super.clone();
      return localMpfileTaskRecord;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public void doPrewrite()
  {
    prewrite();
  }
  
  protected Class<? extends Entity> getClassForTable()
  {
    return MpfileTaskRecord.class;
  }
  
  public String getTableName()
  {
    return "mr_dataline_mpfile";
  }
  
  protected void postRead() {}
  
  protected void prewrite() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.mpfile.MpfileTaskRecord
 * JD-Core Version:    0.7.0.1
 */