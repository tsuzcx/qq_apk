package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.widget.TextView;

class KandianCompetitiveAdPandentView$1
  implements Handler.Callback
{
  KandianCompetitiveAdPandentView$1(KandianCompetitiveAdPandentView paramKandianCompetitiveAdPandentView) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i == 2) {
        KandianCompetitiveAdPandentView.f(this.a);
      }
    }
    else
    {
      KandianCompetitiveAdPandentView.a(this.a);
      if (KandianCompetitiveAdPandentView.b(this.a) <= 0)
      {
        KandianCompetitiveAdPandentView.c(this.a);
      }
      else
      {
        paramMessage = KandianCompetitiveAdPandentView.d(this.a);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(KandianCompetitiveAdPandentView.b(this.a));
        localStringBuilder.append("s后消失");
        paramMessage.setText(localStringBuilder.toString());
        if (KandianCompetitiveAdPandentView.e(this.a) != null) {
          KandianCompetitiveAdPandentView.e(this.a).sendEmptyMessageDelayed(1, 1000L);
        } else {
          KandianCompetitiveAdPandentView.f(this.a);
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.KandianCompetitiveAdPandentView.1
 * JD-Core Version:    0.7.0.1
 */