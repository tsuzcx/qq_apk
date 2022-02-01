package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.data.DataLineMsgRecord;

class Conversation$48
  extends DataLineObserver
{
  Conversation$48(Conversation paramConversation) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString)
  {
    super.a(paramBoolean, paramLong, paramString);
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    if (i == 0)
    {
      this.a.a(8, AppConstants.DATALINE_PC_UIN, 6000);
      return;
    }
    if (i == 1) {
      this.a.a(8, AppConstants.DATALINE_IPAD_UIN, 6000);
    }
  }
  
  protected void a(boolean paramBoolean, Long paramLong, String paramString)
  {
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong.longValue());
    if (i == 0)
    {
      this.a.a(9, AppConstants.DATALINE_PC_UIN, 6003);
      return;
    }
    if (i == 1) {
      this.a.a(8, AppConstants.DATALINE_IPAD_UIN, 6003);
    }
  }
  
  protected void b(boolean paramBoolean, long paramLong, String paramString)
  {
    super.b(paramBoolean, paramLong, paramString);
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    if (i == 0)
    {
      this.a.a(8, AppConstants.DATALINE_PC_UIN, 6000);
      return;
    }
    if (i == 1) {
      this.a.a(8, AppConstants.DATALINE_IPAD_UIN, 6003);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.48
 * JD-Core Version:    0.7.0.1
 */