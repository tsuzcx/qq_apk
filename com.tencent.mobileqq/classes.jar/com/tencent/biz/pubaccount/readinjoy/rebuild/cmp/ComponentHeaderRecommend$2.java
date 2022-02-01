package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.graphics.Color;
import android.text.TextPaint;
import android.widget.Button;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.Ox978RespCallBack;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

class ComponentHeaderRecommend$2
  implements UserOperationModule.Ox978RespCallBack
{
  ComponentHeaderRecommend$2(ComponentHeaderRecommend paramComponentHeaderRecommend) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    ComponentHeaderRecommend.a(this.a).setText(HardCodeUtil.a(2131702354));
    ComponentHeaderRecommend.a(this.a).setTextColor(Color.parseColor("#BBBBBB"));
    ComponentHeaderRecommend.a(this.a).setEnabled(false);
    ComponentHeaderRecommend.a(this.a).getPaint().setFakeBoldText(false);
    if (QLog.isColorLevel()) {
      QLog.d("ComponentHeaderRecommend", 2, "followPubAccount() onFollowPublicAccount uin=" + paramString + ", isSuccess=" + paramBoolean);
    }
    ArticleInfo localArticleInfo;
    String str;
    if ((this.a.a.a != null) && (this.a.a.a.a() != null))
    {
      localArticleInfo = this.a.a.a.a();
      str = RIJTransMergeKanDianReport.a(localArticleInfo.mAlgorithmID, RIJFeedsType.a(localArticleInfo), this.a.a.a.e(), 0, 0, NetworkUtil.h(this.a.getContext()), ComponentHeaderRecommend.a(this.a) + "", null, localArticleInfo.innerUniqueID, null, localArticleInfo);
      if (!ReadinjoyReportUtils.a(this.a.a.a.e())) {
        break label315;
      }
    }
    label315:
    for (paramString = "0X800941D";; paramString = "0X80080EC")
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ComponentHeaderRecommend.a(this.a) + "", paramString, paramString, 0, 0, String.valueOf(localArticleInfo.mFeedId), String.valueOf(localArticleInfo.mArticleID), Integer.toString(localArticleInfo.mStrategyId), str, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderRecommend.2
 * JD-Core Version:    0.7.0.1
 */