package com.tencent.mobileqq.activity.qqsettingme;

import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.webview.util.WebProcessStartListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class QQSettingMeApolloProcessor$WebPreloadTask$1
  implements WebProcessStartListener
{
  QQSettingMeApolloProcessor$WebPreloadTask$1(QQSettingMeApolloProcessor.WebPreloadTask paramWebPreloadTask) {}
  
  public void onResult(boolean paramBoolean)
  {
    if ((paramBoolean) && (QQSettingMeApolloProcessor.WebPreloadTask.a(this.a).get() != null) && (QQSettingMeApolloProcessor.b((QQSettingMeApolloProcessor)QQSettingMeApolloProcessor.WebPreloadTask.a(this.a).get()) != null)) {
      QQSettingMeApolloProcessor.b((QQSettingMeApolloProcessor)QQSettingMeApolloProcessor.WebPreloadTask.a(this.a).get()).a();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WebPreloadTask preloadWebProcess isProcessExist: ");
      localStringBuilder.append(paramBoolean ^ true);
      QLog.d("QQSettingRedesign", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeApolloProcessor.WebPreloadTask.1
 * JD-Core Version:    0.7.0.1
 */