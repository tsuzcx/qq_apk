package com.tencent.biz.pubaccount.AccountDetail.activity.api.impl;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;

class PublicAccountDetailActivityImpl$20
  extends Handler
{
  PublicAccountDetailActivityImpl$20(PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 3: 
      this.a.setHDFace();
      return;
    case 1: 
      if (this.a.isFirst)
      {
        PublicAccountDetailActivityImpl.access$1000(this.a);
        this.a.removeLoading();
      }
      for (;;)
      {
        this.a.reportSource2(this.a.getIntent());
        return;
        PublicAccountDetailActivityImpl.access$1000(this.a);
      }
    case 2: 
      paramMessage = new Intent();
      paramMessage.putExtra("isNeedFinish", true);
      this.a.setResult(-1, paramMessage);
      this.a.finish();
      return;
    case 4: 
      paramMessage = new Intent(this.a.getActivity(), QQBrowserActivity.class);
      paramMessage.putExtra("BSafeReportPost", true);
      try
      {
        if (this.a.postData != null) {
          paramMessage.putExtra("SafeReportData", this.a.postData.toString().getBytes("utf-8"));
        }
        paramMessage.putExtra("hide_more_buttonbutton", true);
        paramMessage.putExtra("ishiderefresh", true);
        paramMessage.putExtra("ishidebackforward", true);
        this.a.startActivity(paramMessage.putExtra("url", "https://jubao.mp.qq.com/mobile/reportAccount"));
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
      }
    }
    paramMessage = new AlphaAnimation(1.0F, 0.0F);
    paramMessage.setDuration(500L);
    this.a.topFollowed.startAnimation(paramMessage);
    this.a.topFollowed.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.PublicAccountDetailActivityImpl.20
 * JD-Core Version:    0.7.0.1
 */