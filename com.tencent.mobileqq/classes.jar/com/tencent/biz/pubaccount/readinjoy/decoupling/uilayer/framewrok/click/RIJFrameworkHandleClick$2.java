package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.click;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ClickHandler;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class RIJFrameworkHandleClick$2
  implements ClickHandler
{
  RIJFrameworkHandleClick$2(RIJFrameworkHandleClick paramRIJFrameworkHandleClick) {}
  
  public void onClick(View paramView)
  {
    BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)paramView.getTag();
    String str2 = null;
    String str1;
    label78:
    String str3;
    long l;
    label113:
    IPublicAccountReportUtils localIPublicAccountReportUtils;
    if ((!TextUtils.isEmpty(localBaseArticleInfo.getSubscribeUin())) && (!"16888".equals(localBaseArticleInfo.getSubscribeUin())))
    {
      str1 = localBaseArticleInfo.getSubscribeUin();
      if ((str1 == null) || (localBaseArticleInfo.unowned)) {
        break label351;
      }
      RIJFrameworkHandleClick.a(this.a, str1, RIJFrameworkHandleClick.a(this.a).a().a());
      str2 = localBaseArticleInfo.mVideoVid;
      str3 = String.valueOf(localBaseArticleInfo.innerUniqueID);
      if (RIJFrameworkHandleClick.a(this.a).a().a() != null) {
        break label389;
      }
      l = 0L;
      str3 = new VideoR5.Builder(null, str1, str2, str3, l, localBaseArticleInfo.mVideoDuration * 1000).a(RIJFrameworkHandleClick.a(this.a).a().b()).a().a();
      localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      if (TextUtils.isEmpty(localBaseArticleInfo.innerUniqueID)) {
        break label409;
      }
    }
    label389:
    label409:
    for (str2 = String.valueOf(localBaseArticleInfo.innerUniqueID);; str2 = "0")
    {
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str1, "0X8007410", "0X8007410", 0, 0, "2", "", str2, str3, false);
      ReadinJoyActionUtil.a(RIJFrameworkHandleClick.a(this.a).a().a(), (ArticleInfo)localBaseArticleInfo, RIJFrameworkHandleClick.a(this.a).a().a(), 56);
      ReadinJoyActionUtil.a((Activity)RIJFrameworkHandleClick.a(this.a).a().a(), (ArticleInfo)localBaseArticleInfo, RIJFrameworkHandleClick.a(this.a).a().a(), 56, false, null);
      if (paramView.getId() == 2131361878) {
        VideoHandler.a(paramView);
      }
      return;
      str1 = str2;
      if (TextUtils.isEmpty(localBaseArticleInfo.thirdUin)) {
        break;
      }
      str1 = str2;
      if ("16888".equals(localBaseArticleInfo.thirdUin)) {
        break;
      }
      str1 = localBaseArticleInfo.thirdUin;
      break;
      label351:
      if (!QLog.isColorLevel()) {
        break label78;
      }
      QLog.d("RIJFrameworkHandleClick", 2, "onClick: handleAccountViewGroupClick articleinfo unowned = " + localBaseArticleInfo.unowned);
      break label78;
      l = RIJFrameworkHandleClick.a(this.a).a().a().a();
      break label113;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.click.RIJFrameworkHandleClick.2
 * JD-Core Version:    0.7.0.1
 */