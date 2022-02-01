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
      this.a.setReaded(this.b, 1008, true, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.config.QQComicConfBean.ServiceAccountConfig.1
 * JD-Core Version:    0.7.0.1
 */