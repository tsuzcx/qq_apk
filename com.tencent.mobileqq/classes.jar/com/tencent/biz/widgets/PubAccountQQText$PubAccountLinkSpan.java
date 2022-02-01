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
  
  protected void a(View paramView, String paramString)
  {
    Context localContext = paramView.getContext();
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", this.a.a);
    int i = paramString.lastIndexOf("#");
    if (i > 0) {
      paramView = paramString.substring(i);
    } else {
      paramView = null;
    }
    String str = URLUtil.guessUrl(paramString);
    Object localObject = str;
    if (paramView != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(paramView);
      localObject = ((StringBuilder)localObject).toString();
    }
    localIntent.putExtra("url", (String)localObject);
    localIntent.putExtra("assignBackText", localContext.getResources().getString(2131887625));
    localIntent.putExtra("puin", this.a.b);
    localIntent.putExtra("key_isReadModeEnabled", true);
    localIntent.putExtra("fromAio", true);
    localIntent.putExtra("fromPublicAccount", true);
    localIntent.putExtra("articalChannelId", 1);
    localIntent.putExtra("big_brother_source_key", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId(this.a.b));
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(localIntent, paramString);
    if (localIntent.getComponent() != null)
    {
      localContext.startActivity(localIntent);
    }
    else
    {
      paramView = new ActivityURIRequest(localContext, "/pubaccount/browser");
      paramView.extra().putAll(localIntent.getExtras());
      QRoute.startUri(paramView, null);
    }
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, (String)localObject, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.widgets.PubAccountQQText.PubAccountLinkSpan
 * JD-Core Version:    0.7.0.1
 */