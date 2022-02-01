package com.tencent.biz.pubaccount.weishi_new.comment;

import UserGrowth.stSchema;
import UserGrowth.stSimpleMetaPerson;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.profile.WSProfileFragment;
import com.tencent.biz.pubaccount.weishi_new.report.UserActionReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.report.WSCommentBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import java.util.Map;

abstract class WSCommentClickListenerFactory$BaseCommentListener
  implements WSOnCommentClickListener
{
  WsCommentPresenter a;
  
  WSCommentClickListenerFactory$BaseCommentListener(WsCommentPresenter paramWsCommentPresenter)
  {
    this.a = paramWsCommentPresenter;
  }
  
  private void a(int paramInt1, int paramInt2, Map<String, String> paramMap)
  {
    WSCommentBeaconReport.a(this.a.a(), this.a.b(), this.a.l(), paramInt1, paramInt2, this.a.n(), paramMap);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    Map localMap = this.a.p();
    localMap.put("click_status", String.valueOf(paramInt2));
    a(1000001, paramInt1, localMap);
  }
  
  protected WSDownloadParams a(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = WSGlobalConfig.a().d();
    localWSDownloadParams.mEventId = paramInt;
    localWSDownloadParams.mTestId = WeishiUtils.a(1);
    localWSDownloadParams.mStReportItem = UserActionReportPresenter.a();
    localWSDownloadParams.mScheme = paramString;
    return localWSDownloadParams;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, this.a.p());
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    Map localMap = this.a.p();
    localMap.put("comment_id", paramString);
    a(paramInt1, paramInt2, localMap);
  }
  
  protected void a(stSimpleMetaPerson paramstSimpleMetaPerson, stSchema paramstSchema, int paramInt)
  {
    paramstSchema = this.a.c();
    QBaseActivity localQBaseActivity = paramstSchema.getQBaseActivity();
    if ((paramstSchema instanceof WSVerticalPageFragment))
    {
      paramstSchema = (WSVerticalPageFragment)paramstSchema;
      String str = paramstSchema.k();
      if ((TextUtils.equals(str, "personal_guest")) || (TextUtils.equals(str, "personal_main")))
      {
        if (paramstSchema.getArguments() != null) {
          paramstSchema = paramstSchema.getArguments().getString("person_id");
        } else {
          paramstSchema = "";
        }
        if (TextUtils.equals(paramstSimpleMetaPerson.id, paramstSchema))
        {
          this.a.r();
          localQBaseActivity.doOnBackPressed();
          b(paramInt, 2);
          return;
        }
      }
    }
    WSProfileFragment.a(localQBaseActivity, paramstSimpleMetaPerson);
    b(paramInt, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WSCommentClickListenerFactory.BaseCommentListener
 * JD-Core Version:    0.7.0.1
 */