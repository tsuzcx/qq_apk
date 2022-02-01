package com.tencent.biz.pubaccount.weishi_new.comment;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.download.WeishiDownloadUtil;
import com.tencent.biz.pubaccount.weishi_new.report.WSCommentBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiScehmeUtil;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.mobileqq.app.BaseFragment;

class WSCommentClickListenerFactory$ShowMoreCommentListener
  extends WSCommentClickListenerFactory.BaseCommentListener
{
  WSCommentClickListenerFactory$ShowMoreCommentListener(WsCommentPresenter paramWsCommentPresenter)
  {
    super(paramWsCommentPresenter);
  }
  
  public void a(Object paramObject, int paramInt)
  {
    paramObject = (String)paramObject;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("weishi://feed?feed_id=");
    ((StringBuilder)localObject).append(paramObject);
    String str1 = ((StringBuilder)localObject).toString();
    WSDownloadParams localWSDownloadParams = a(str1, 14);
    String str2 = this.a.a();
    String str3 = this.a.b();
    localObject = WSCommentBeaconReport.d(str2);
    paramObject = localObject;
    if (TextUtils.equals(str2, "focus"))
    {
      paramObject = new StringBuilder();
      paramObject.append((String)localObject);
      paramObject.append(this.a.m());
      paramObject = paramObject.toString();
    }
    localObject = this.a.c().getActivity();
    if (WeishiGuideUtils.a(((FragmentActivity)localObject).getApplicationContext()))
    {
      WeishiScehmeUtil.a((Context)localObject, "biz_src_jc_gzh_weishi", str1, localWSDownloadParams.mScene, localWSDownloadParams.mLinkStrategyType, localWSDownloadParams.mEventId);
      WSCommentBeaconReport.a(str2, str3, paramObject, 1000003, this.a.n());
      return;
    }
    WeishiDownloadUtil.b((Activity)localObject, localWSDownloadParams);
    WSCommentBeaconReport.a(str2, str3, paramObject, 1000002, this.a.n());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WSCommentClickListenerFactory.ShowMoreCommentListener
 * JD-Core Version:    0.7.0.1
 */