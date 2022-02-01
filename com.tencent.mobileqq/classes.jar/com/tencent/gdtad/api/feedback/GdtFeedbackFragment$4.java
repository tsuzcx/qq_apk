package com.tencent.gdtad.api.feedback;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.toast.AdToast;
import com.tencent.ad.tangram.web.AdBrowser;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;

class GdtFeedbackFragment$4
  implements Runnable
{
  GdtFeedbackFragment$4(GdtFeedbackFragment paramGdtFeedbackFragment, int paramInt, String paramString) {}
  
  public void run()
  {
    try
    {
      GdtFeedbackResultParams localGdtFeedbackResultParams = new GdtFeedbackResultParams();
      if (this.a != 3)
      {
        String str = this.b;
        if (TextUtils.isEmpty(str))
        {
          AdLog.e(GdtFeedbackFragment.b(), "cannot handle this action because of an empty jump url");
        }
        else
        {
          Object localObject = str;
          if (GdtFeedbackFragment.c(this.this$0))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(str);
            ((StringBuilder)localObject).append(URLEncoder.encode("&isnm=2", "utf-8"));
            localObject = ((StringBuilder)localObject).toString();
          }
          localObject = AdBrowser.showWithoutAd(GdtFeedbackFragment.b(this.this$0), (String)localObject, null);
          localGdtFeedbackResultParams.a = ((AdError)localObject);
          if (!((AdError)localObject).isSuccess())
          {
            str = GdtFeedbackFragment.b();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("cannot start AdBrowser. error_code = ");
            localStringBuilder.append(((AdError)localObject).getErrorCode());
            AdLog.e(str, localStringBuilder.toString());
          }
        }
      }
      else
      {
        AdToast.show((Context)GdtFeedbackFragment.b(this.this$0).get(), 2, this.this$0.getResources().getString(2131889959), 0);
        AdLog.i(GdtFeedbackFragment.b(), "handle hide ad");
        localGdtFeedbackResultParams.a = new AdError(0);
      }
      localGdtFeedbackResultParams.b = this.a;
      GdtFeedbackFragment.a(this.this$0, localGdtFeedbackResultParams);
      return;
    }
    catch (Exception localException)
    {
      AdLog.e(GdtFeedbackFragment.b(), "onItemClicked Handler error in sub thread", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.feedback.GdtFeedbackFragment.4
 * JD-Core Version:    0.7.0.1
 */