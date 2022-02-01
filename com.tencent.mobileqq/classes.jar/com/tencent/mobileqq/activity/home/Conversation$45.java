package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.data.DataLineMsgRecord;

class Conversation$45
  extends DataLineObserver
{
  Conversation$45(Conversation paramConversation) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString)
  {
    super.a(paramBoolean, paramLong, paramString);
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    if (i == 0) {
      this.a.a(8, AppConstants.DATALINE_PC_UIN, 6000);
    }
    while (i != 1) {
      return;
    }
    this.a.a(8, AppConstants.DATALINE_IPAD_UIN, 6000);
  }
  
  public void a(boolean paramBoolean, Long paramLong, String paramString)
  {
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong.longValue());
    if (i == 0) {
      this.a.a(9, AppConstants.DATALINE_PC_UIN, 6003);
    }
    while (i != 1) {
      return;
    }
    this.a.a(8, AppConstants.DATALINE_IPAD_UIN, 6003);
  }
  
  public void b(boolean paramBoolean, long paramLong, String paramString)
  {
    super.b(paramBoolean, paramLong, paramString);
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    if (i == 0) {
      this.a.a(8, AppConstants.DATALINE_PC_UIN, 6000);
    }
    while (i != 1) {
      return;
    }
    this.a.a(8, AppConstants.DATALINE_IPAD_UIN, 6003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.45
 * JD-Core Version:    0.7.0.1
 */