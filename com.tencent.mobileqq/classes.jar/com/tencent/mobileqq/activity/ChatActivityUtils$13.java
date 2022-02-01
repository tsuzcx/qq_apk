package com.tencent.mobileqq.activity;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QAVHrMeeting.OnGetNickNameOfMaskDisc;

final class ChatActivityUtils$13
  implements QAVHrMeeting.OnGetNickNameOfMaskDisc
{
  ChatActivityUtils$13(Bundle paramBundle, QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString) {}
  
  public void a(String paramString, int paramInt)
  {
    this.a.putInt("MeetingStasks", paramInt);
    ChatActivityUtils.a(this.b, this.c, this.d, this.e, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityUtils.13
 * JD-Core Version:    0.7.0.1
 */