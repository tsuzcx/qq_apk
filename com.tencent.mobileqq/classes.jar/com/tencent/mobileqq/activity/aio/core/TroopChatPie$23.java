package com.tencent.mobileqq.activity.aio.core;

import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousStatusListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import mqq.os.MqqHandler;

class TroopChatPie$23
  implements AnonymousChatHelper.AnonymousStatusListener
{
  TroopChatPie$23(TroopChatPie paramTroopChatPie) {}
  
  public void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a))) {
      this.a.jdField_a_of_type_MqqOsMqqHandler.post(new TroopChatPie.23.1(this, paramString2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.23
 * JD-Core Version:    0.7.0.1
 */