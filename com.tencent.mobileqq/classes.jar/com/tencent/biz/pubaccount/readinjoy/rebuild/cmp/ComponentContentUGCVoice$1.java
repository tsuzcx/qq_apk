package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVoiceInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.voice.ReadInJoyVoicePlayController;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ComponentContentUGCVoice$1
  implements View.OnClickListener
{
  ComponentContentUGCVoice$1(ComponentContentUGCVoice paramComponentContentUGCVoice) {}
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((ComponentContentUGCVoice.a(this.a) != null) && (!TextUtils.isEmpty(ComponentContentUGCVoice.a(this.a).voiceUrl))) {
      if (ComponentContentUGCVoice.a(this.a).isPlaying)
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009CA4", "0X8009CA4", 0, 0, localQQAppInterface.getCurrentAccountUin(), ComponentContentUGCVoice.a(this.a).mFeedId + "", "2", "", false);
        ReadInJoyVoicePlayController.a().a();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009CA4", "0X8009CA4", 0, 0, localQQAppInterface.getCurrentAccountUin(), ComponentContentUGCVoice.a(this.a).mFeedId + "", "1", "", false);
      ReadInJoyVoicePlayController.a().a(this.a, ComponentContentUGCVoice.a(this.a));
      continue;
      if (QLog.isColorLevel()) {
        QLog.d(ComponentContentUGCVoice.a, 2, "mUGCVoiceInfo or its voiceUrl is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUGCVoice.1
 * JD-Core Version:    0.7.0.1
 */