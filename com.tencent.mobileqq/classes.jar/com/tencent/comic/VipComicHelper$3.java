package com.tencent.comic;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.webbundle.sdk.WebBundleH5OptionListner;
import mqq.os.MqqHandler;

final class VipComicHelper$3
  implements WebBundleH5OptionListner
{
  VipComicHelper$3(SharedPreferences paramSharedPreferences) {}
  
  public void enableWebBundle(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handle enable webbundle. enable = ");
    localStringBuilder.append(paramBoolean);
    QLog.d("WebBundle.Comic", 2, localStringBuilder.toString());
    this.a.edit().putBoolean("webbundle_enable", paramBoolean).apply();
    if (!paramBoolean) {
      ThreadManager.getUIHandler().post(new VipComicHelper.3.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.VipComicHelper.3
 * JD-Core Version:    0.7.0.1
 */