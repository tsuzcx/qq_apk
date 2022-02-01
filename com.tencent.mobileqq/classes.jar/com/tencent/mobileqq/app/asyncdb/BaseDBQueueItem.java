package com.tencent.mobileqq.app.asyncdb;

import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.persistence.Entity;

public class BaseDBQueueItem
{
  public static final int QUEUE_ACTION_DELETE = 2;
  public static final int QUEUE_ACTION_INSERT = 0;
  public static final int QUEUE_ACTION_UPDATE = 1;
  public static final int QUEUE_NOTIFY_ATONCE = 1;
  public static final int QUEUE_NOTIFY_DEFAULT = 0;
  public static final int QUEUE_NOTIFY_DELAY = 2;
  public int action;
  public Entity item;
  ProxyListener listener;
  public int notify;
  
  public BaseDBQueueItem(Entity paramEntity, int paramInt1, int paramInt2, ProxyListener paramProxyListener)
  {
    this.item = paramEntity;
    this.action = paramInt1;
    this.notify = paramInt2;
    this.listener = paramProxyListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.BaseDBQueueItem
 * JD-Core Version:    0.7.0.1
 */