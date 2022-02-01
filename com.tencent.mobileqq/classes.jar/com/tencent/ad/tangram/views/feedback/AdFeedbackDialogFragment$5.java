package com.tencent.ad.tangram.views.feedback;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.toast.AdToast;
import com.tencent.ad.tangram.web.AdBrowser;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;

class AdFeedbackDialogFragment$5
  implements Runnable
{
  AdFeedbackDialogFragment$5(AdFeedbackDialogFragment paramAdFeedbackDialogFragment, int paramInt, String paramString) {}
  
  public void run()
  {
    AdFeedbackDialogFragment.ResultParams localResultParams = new AdFeedbackDialogFragment.ResultParams();
    int i = this.val$actionType;
    localResultParams.action = i;
    String str2;
    Object localObject;
    if (i != 3)
    {
      str2 = this.val$jumpUrl;
      if (TextUtils.isEmpty(str2))
      {
        AdLog.e(AdFeedbackDialogFragment.access$500(), "cannot handle this action because of an empty jump url");
        localResultParams.result = new AdError(4);
        break label214;
      }
      localObject = str2;
      if (!AdFeedbackDialogFragment.access$700(this.this$0)) {}
    }
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append(URLEncoder.encode("&isnm=2", "utf-8"));
      localObject = ((StringBuilder)localObject).toString();
      localObject = AdBrowser.showWithoutAd(AdFeedbackDialogFragment.access$600(this.this$0), (String)localObject, null);
      localResultParams.result = ((AdError)localObject);
      if (!((AdError)localObject).isSuccess())
      {
        str2 = AdFeedbackDialogFragment.access$500();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cannot start AdBrowser. error_code = ");
        localStringBuilder.append(((AdError)localObject).getErrorCode());
        AdLog.e(str2, localStringBuilder.toString());
        break label214;
        AdToast.show((Context)AdFeedbackDialogFragment.access$600(this.this$0).get(), 2, "感谢反馈，将减少此类广告推荐", 0);
        AdLog.i(AdFeedbackDialogFragment.access$500(), "handle hide ad");
        localResultParams.result = new AdError(0);
      }
      label214:
      AdFeedbackDialogFragment.access$800(this.this$0, localResultParams);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        String str1 = str2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment.5
 * JD-Core Version:    0.7.0.1
 */