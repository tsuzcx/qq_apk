package com.tencent.biz.pubaccount.accountdetail.api.impl;

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
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return;
            }
            paramMessage = new AlphaAnimation(1.0F, 0.0F);
            paramMessage.setDuration(500L);
            this.a.topFollowed.startAnimation(paramMessage);
            this.a.topFollowed.setVisibility(8);
            return;
          }
          paramMessage = new Intent(this.a.getActivity(), QQBrowserActivity.class);
          paramMessage.putExtra("BSafeReportPost", true);
          try
          {
            if (this.a.postData != null) {
              paramMessage.putExtra("SafeReportData", this.a.postData.toString().getBytes("utf-8"));
            }
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            localUnsupportedEncodingException.printStackTrace();
          }
          paramMessage.putExtra("hide_more_buttonbutton", true);
          paramMessage.putExtra("ishiderefresh", true);
          paramMessage.putExtra("ishidebackforward", true);
          this.a.startActivity(paramMessage.putExtra("url", "https://jubao.mp.qq.com/mobile/reportAccount"));
          return;
        }
        this.a.setHDFace();
        return;
      }
      paramMessage = new Intent();
      paramMessage.putExtra("isNeedFinish", true);
      this.a.setResult(-1, paramMessage);
      this.a.finish();
      return;
    }
    if (this.a.isFirst)
    {
      PublicAccountDetailActivityImpl.access$1000(this.a);
      this.a.removeLoading();
    }
    else
    {
      PublicAccountDetailActivityImpl.access$1000(this.a);
    }
    paramMessage = this.a;
    paramMessage.reportSource2(paramMessage.getIntent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.20
 * JD-Core Version:    0.7.0.1
 */