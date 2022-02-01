package com.tencent.biz.pubaccount.readinjoy.reward;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class RedPacketTaskData
  extends Entity
{
  public static final String TABLE_NAME = RedPacketTaskData.class.getSimpleName();
  public long insertTime = 0L;
  @unique
  @NonNull
  public String rowKey = "";
  
  @NonNull
  public String toString()
  {
    return "{rowKey:" + this.rowKey + ", insertTime: " + this.insertTime + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.RedPacketTaskData
 * JD-Core Version:    0.7.0.1
 */