package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class ConversationTitleBtnCtrl$7
  implements QQPermissionCallback
{
  ConversationTitleBtnCtrl$7(ConversationTitleBtnCtrl paramConversationTitleBtnCtrl, View paramView) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(ConversationTitleBtnCtrl.m(this.b).P());
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.b.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.7
 * JD-Core Version:    0.7.0.1
 */