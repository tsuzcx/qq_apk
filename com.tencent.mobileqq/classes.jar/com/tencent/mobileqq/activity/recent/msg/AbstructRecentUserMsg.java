package com.tencent.mobileqq.activity.recent.msg;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;

public abstract class AbstructRecentUserMsg
  implements IRecentUserMsg
{
  public int a;
  public long a;
  public MessageNavInfo a;
  public String a;
  public int b;
  public long b;
  public String b;
  public String c;
  
  public AbstructRecentUserMsg()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_b_of_type_Int = -35072;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo();
  }
  
  @Nullable
  public abstract Object a(int paramInt, MessageInfo paramMessageInfo, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface);
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.AbstructRecentUserMsg
 * JD-Core Version:    0.7.0.1
 */