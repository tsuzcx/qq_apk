package com.tencent.mobileqq.activity.home;

import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.mobileqq.activity.ConversationTitleBtnCtrl;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;

class Conversation$70
  implements StudyModeChangeListener
{
  Conversation$70(Conversation paramConversation) {}
  
  public void onChange(boolean paramBoolean)
  {
    this.a.a("pa_WhiteList_in_studyMode_860178803");
    ServiceAccountFolderManager.a().b((QQAppInterface)this.a.P().getAppRuntime());
    if (this.a.U != null) {
      this.a.U.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.70
 * JD-Core Version:    0.7.0.1
 */