package com.tencent.mobileqq.activity.recent.msg;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;

public abstract class AbstructRecentUserMsg
  implements IRecentUserMsg
{
  public long a = -1L;
  public long b = -1L;
  public String c;
  public String d;
  public int e;
  public int f = -35072;
  public String g;
  public MessageNavInfo h = new MessageNavInfo();
  
  @Nullable
  public abstract Object a(int paramInt, MessageInfo paramMessageInfo, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface);
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.AbstructRecentUserMsg
 * JD-Core Version:    0.7.0.1
 */