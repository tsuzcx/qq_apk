package com.tencent.mobileqq.activity.aio.core;

import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousStatusListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import mqq.os.MqqHandler;

class TroopChatPie$22
  implements AnonymousChatHelper.AnonymousStatusListener
{
  TroopChatPie$22(TroopChatPie paramTroopChatPie) {}
  
  public void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a))) {
      this.a.jdField_a_of_type_MqqOsMqqHandler.post(new TroopChatPie.22.1(this, paramString2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.22
 * JD-Core Version:    0.7.0.1
 */