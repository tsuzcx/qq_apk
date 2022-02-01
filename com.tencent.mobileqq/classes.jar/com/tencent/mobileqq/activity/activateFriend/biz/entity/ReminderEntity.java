package com.tencent.mobileqq.activity.activateFriend.biz.entity;

import Wallet.AcsMsg;
import aevc;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;

public class ReminderEntity
  extends Entity
{
  public static final int DAY_OF_TIME = 86400000;
  public static final String TAG = "ReminderEntity.class";
  private boolean hasReminded;
  @notColumn
  private AcsMsg mAcsMsg;
  @unique
  public String mKey;
  public byte[] mMsgDate;
  public String mMsgId;
  public long mReminderTime;
  
  private void acsMsgExtract()
  {
    this.mMsgId = this.mAcsMsg.msg_id;
    this.mReminderTime = this.mAcsMsg.notice_time;
    this.mKey = aevc.a(this.mAcsMsg);
  }
  
  private void acsMsgPack()
  {
    this.mAcsMsg.msg_id = this.mMsgId;
    this.mAcsMsg.notice_time = this.mReminderTime;
  }
  
  public AcsMsg getAcsMsg()
  {
    return this.mAcsMsg;
  }
  
  public void postRead()
  {
    super.postRead();
    JceInputStream localJceInputStream = new JceInputStream(this.mMsgDate);
    localJceInputStream.setServerEncoding("utf-8");
    this.mAcsMsg = new AcsMsg();
    this.mAcsMsg.readFrom(localJceInputStream);
    acsMsgPack();
  }
  
  public void prewrite()
  {
    super.prewrite();
    JceOutputStream localJceOutputStream = new JceOutputStream();
    localJceOutputStream.setServerEncoding("utf-8");
    acsMsgExtract();
    this.mAcsMsg.writeTo(localJceOutputStream);
    this.mMsgDate = localJceOutputStream.toByteArray();
  }
  
  public void setAcsMsg(AcsMsg paramAcsMsg)
  {
    this.mAcsMsg = paramAcsMsg;
    acsMsgExtract();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.biz.entity.ReminderEntity
 * JD-Core Version:    0.7.0.1
 */