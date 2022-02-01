package com.tencent.comic.config;

import android.os.Bundle;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.mobileqq.msg.api.IMessageFacade;

class QQComicConfBean$ServiceAccountConfig$1
  implements MiniAppLaunchListener
{
  QQComicConfBean$ServiceAccountConfig$1(QQComicConfBean.ServiceAccountConfig paramServiceAccountConfig, IMessageFacade paramIMessageFacade, String paramString) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.setReaded(this.jdField_a_of_type_JavaLangString, 1008, true, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.config.QQComicConfBean.ServiceAccountConfig.1
 * JD-Core Version:    0.7.0.1
 */