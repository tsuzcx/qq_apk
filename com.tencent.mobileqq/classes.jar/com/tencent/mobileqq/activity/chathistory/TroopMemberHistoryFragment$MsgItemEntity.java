package com.tencent.mobileqq.activity.chathistory;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import java.util.Calendar;

class TroopMemberHistoryFragment$MsgItemEntity
{
  String a;
  long b;
  CharSequence c;
  long d;
  CharSequence e;
  MessageRecord f;
  boolean g;
  
  public TroopMemberHistoryFragment$MsgItemEntity(TroopMemberHistoryFragment paramTroopMemberHistoryFragment, String paramString, long paramLong1, CharSequence paramCharSequence, long paramLong2, MessageRecord paramMessageRecord)
  {
    this.a = paramString;
    this.b = paramLong1;
    this.c = paramCharSequence;
    this.d = paramLong2;
    this.f = paramMessageRecord;
    this.g = false;
  }
  
  public CharSequence a()
  {
    if (this.e == null)
    {
      Calendar.getInstance().setTimeInMillis(this.b * 1000L);
      this.e = TimeFormatterUtils.a(BaseApplicationImpl.getApplication().getApplicationContext(), 3, this.b * 1000L);
    }
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment.MsgItemEntity
 * JD-Core Version:    0.7.0.1
 */