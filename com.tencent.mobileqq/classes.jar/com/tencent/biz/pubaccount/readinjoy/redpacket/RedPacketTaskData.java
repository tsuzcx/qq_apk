package com.tencent.biz.pubaccount.readinjoy.redpacket;

import android.support.annotation.NonNull;
import awbv;
import awdj;

public class RedPacketTaskData
  extends awbv
{
  public static final String TABLE_NAME = RedPacketTaskData.class.getSimpleName();
  public long insertTime;
  @awdj
  @NonNull
  public String rowKey = "";
  
  @NonNull
  public String toString()
  {
    return "{rowKey:" + this.rowKey + ", insertTime: " + this.insertTime + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.redpacket.RedPacketTaskData
 * JD-Core Version:    0.7.0.1
 */