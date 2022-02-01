package com.tencent.biz.widgets;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.webkit.URLUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.style.LinkSpan;

public class PubAccountQQText$PubAccountLinkSpan
  extends LinkSpan
{
  public PubAccountQQText$PubAccountLinkSpan(PubAccountQQText paramPubAccountQQText, String paramString)
  {
    super(paramString);
  }
  
  public void a(View paramView, String paramString)
  {
    Context localContext = paramView.getContext();
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", this.a.a);
    int i = paramString.lastIndexOf("#");
    if (i > 0) {}
    for (String str1 = paramString.substring(i);; str1 = null)
    {
      String str2 = URLUtil.guessUrl(paramString);
      paramView = str2;
      if (str1 != null) {
        paramView = str2 + str1;
      }
      localIntent.putExtra("url", paramView);
      localIntent.putExtra("assignBackText", localContext.getResources().getString(2131690778));
      localIntent.putExtra("puin", this.a.b);
      localIntent.putExtra("key_isReadModeEnabled", true);
      localIntent.putExtra("fromAio", true);
      localIntent.putExtra("fromPublicAccount", true);
      localIntent.putExtra("articalChannelId", 1);
      localIntent.putExtra("big_brother_source_key", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId(this.a.b));
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(localIntent, paramString);
      if (localIntent.getComponent() != null) {
        localContext.startActivity(localIntent);
      }
      for (;;)
      {
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramView, "", "", "");
        return;
        paramString = new ActivityURIRequest(localContext, "/pubaccount/browser");
        paramString.extra().putAll(localIntent.getExtras());
        QRoute.startUri(paramString, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.widgets.PubAccountQQText.PubAccountLinkSpan
 * JD-Core Version:    0.7.0.1
 */