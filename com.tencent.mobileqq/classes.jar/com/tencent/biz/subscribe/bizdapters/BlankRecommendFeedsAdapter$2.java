package com.tencent.biz.subscribe.bizdapters;

import NS_COMM.COMM.StCommonExt;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.subscribe.SubscribeConstants;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import mqq.app.AppRuntime;

class BlankRecommendFeedsAdapter$2
  implements View.OnClickListener
{
  BlankRecommendFeedsAdapter$2(BlankRecommendFeedsAdapter paramBlankRecommendFeedsAdapter) {}
  
  public void onClick(View paramView)
  {
    StringBuilder localStringBuilder = new StringBuilder(SubscribeConstants.b(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
    if (this.a.a() != null) {}
    for (;;)
    {
      try
      {
        localStringBuilder.append(URLEncoder.encode(this.a.a().attachInfo.get(), "UTF-8"));
        VSReporter.b("auth_follow", "clk_more", 0, 0, new String[0]);
        SubscribeLaucher.a(localStringBuilder.toString());
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        continue;
      }
      QLog.d(BlankRecommendFeedsAdapter.a, 0, "jump more recommend H5 page with no attach info!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.BlankRecommendFeedsAdapter.2
 * JD-Core Version:    0.7.0.1
 */