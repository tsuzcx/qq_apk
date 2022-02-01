package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="feedsId")
public class TroopNotificationCache
  extends Entity
{
  public static final int FEED_TYPE_NEW_GUIDE = 34;
  public static final int FEED_TYPE_NOTICE = 23;
  public static final int SERVICE_ID_NEW_OBJ_STREAM = 20;
  public static final int SERVICE_ID_NOTIFICATION = 27;
  public int appId;
  public String ctrlStr;
  public String currentUin;
  public int feedType = 34;
  public String feedsId;
  public long filterID;
  public boolean needConfirm;
  public boolean read;
  public int serviceID;
  public int src;
  public int time;
  public String title;
  public long troopUin;
  public long userUin;
  public byte[] xmlBytes;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopNotificationCache
 * JD-Core Version:    0.7.0.1
 */