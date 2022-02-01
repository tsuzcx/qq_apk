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
      if (this.jdField_a_of_type_Int != 3)
      {
        String str = this.jdField_a_of_type_JavaLangString;
        if (TextUtils.isEmpty(str))
        {
          AdLog.e(GdtFeedbackFragment.a(), "cannot handle this action because of an empty jump url");
        }
        else
        {
          Object localObject = str;
          if (GdtFeedbackFragment.a(this.this$0))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(str);
            ((StringBuilder)localObject).append(URLEncoder.encode("&isnm=2", "utf-8"));
            localObject = ((StringBuilder)localObject).toString();
          }
          localObject = AdBrowser.showWithoutAd(GdtFeedbackFragment.a(this.this$0), (String)localObject, null);
          localGdtFeedbackResultParams.jdField_a_of_type_ComTencentAdTangramAdError = ((AdError)localObject);
          if (!((AdError)localObject).isSuccess())
          {
            str = GdtFeedbackFragment.a();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("cannot start AdBrowser. error_code = ");
            localStringBuilder.append(((AdError)localObject).getErrorCode());
            AdLog.e(str, localStringBuilder.toString());
          }
        }
      }
      else
      {
        AdToast.show((Context)GdtFeedbackFragment.a(this.this$0).get(), 2, this.this$0.getResources().getString(2131692850), 0);
        AdLog.i(GdtFeedbackFragment.a(), "handle hide ad");
        localGdtFeedbackResultParams.jdField_a_of_type_ComTencentAdTangramAdError = new AdError(0);
      }
      localGdtFeedbackResultParams.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      GdtFeedbackFragment.a(this.this$0, localGdtFeedbackResultParams);
      return;
    }
    catch (Exception localException)
    {
      AdLog.e(GdtFeedbackFragment.a(), "onItemClicked Handler error in sub thread", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.feedback.GdtFeedbackFragment.4
 * JD-Core Version:    0.7.0.1
 */