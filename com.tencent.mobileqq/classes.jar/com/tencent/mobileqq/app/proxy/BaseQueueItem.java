package com.tencent.mobileqq.app.proxy;

import android.content.ContentValues;
import com.tencent.mobileqq.persistence.Entity;

public class BaseQueueItem
{
  public static final int QUEUE_ITEM_ACTION_DELETE = 5;
  public static final int QUEUE_ITEM_ACTION_DELETE_WITH_CLAUSE = 6;
  public static final int QUEUE_ITEM_ACTION_INSERT = 3;
  public static final int QUEUE_ITEM_ACTION_UPDATE = 4;
  public static final int QUEUE_MESSAGE_ACTION_DELETE = 2;
  public static final int QUEUE_MESSAGE_ACTION_INSERT = 0;
  public static final int QUEUE_MESSAGE_ACTION_UPDATE = 1;
  public int action;
  public String frindUin;
  public Entity item;
  ProxyListener listener;
  public String tableName;
  public int type;
  public ContentValues value;
  public String[] whereArgs;
  public String whereClause;
  
  public BaseQueueItem(String paramString1, int paramInt1, String paramString2, ContentValues paramContentValues, String paramString3, String[] paramArrayOfString, int paramInt2, ProxyListener paramProxyListener)
  {
    this.frindUin = paramString1;
    this.type = paramInt1;
    this.tableName = paramString2;
    this.whereClause = paramString3;
    this.whereArgs = paramArrayOfString;
    this.value = paramContentValues;
    this.action = paramInt2;
    this.listener = paramProxyListener;
  }
  
  public BaseQueueItem(String paramString1, int paramInt1, String paramString2, Entity paramEntity, int paramInt2, ProxyListener paramProxyListener)
  {
    this.frindUin = paramString1;
    this.type = paramInt1;
    this.tableName = paramString2;
    this.item = paramEntity;
    this.action = paramInt2;
    this.listener = paramProxyListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.BaseQueueItem
 * JD-Core Version:    0.7.0.1
 */