package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.concurrent.ConcurrentHashMap;

class BabyQIPCModule$2
  extends ProfileCardObserver
{
  BabyQIPCModule$2(BabyQIPCModule paramBabyQIPCModule) {}
  
  public void onGetProfileCard(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BabyQIPCModule", 2, "babyqWeb onCardDownload ");
    }
    if ((paramObject instanceof Card))
    {
      paramObject = (Card)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("BabyQIPCModule", 2, "babyqWeb onCardDownload set card info uin = " + paramObject.uin);
      }
      if (AppConstants.BABY_Q_UIN.equals(paramObject.uin))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqDataCard = paramObject;
        this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard = this.a.jdField_a_of_type_ComTencentMobileqqDataCard;
        this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0] = this.a.jdField_a_of_type_ComTencentMobileqqDataCard.strNick;
        this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4] = this.a.jdField_a_of_type_ComTencentMobileqqDataCard.strReMark;
      }
    }
    if (BabyQIPCModule.a(this.a).get("getZanVoteCount") != null)
    {
      paramObject = (Bundle)BabyQIPCModule.a(this.a).get("getZanVoteCount");
      int i = paramObject.getInt("key_process_callback_id");
      paramObject = paramObject.getString("key_js_callback_id");
      Bundle localBundle = new Bundle();
      localBundle.putString("key_method_action", "getZanVoteCount");
      localBundle.putLong("key_get_zan_vote_count", this.a.jdField_a_of_type_ComTencentMobileqqDataCard.lVoteCount);
      localBundle.putString("web_js_call_back_id", paramObject);
      this.a.callbackResult(i, EIPCResult.createSuccessResult(localBundle));
      BabyQIPCModule.a(this.a).remove("getZanVoteCount");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.BabyQIPCModule.2
 * JD-Core Version:    0.7.0.1
 */