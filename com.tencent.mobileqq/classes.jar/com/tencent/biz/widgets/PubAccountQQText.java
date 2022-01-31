package com.tencent.biz.widgets;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.webkit.URLUtil;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;

public class PubAccountQQText
  extends QQText
{
  public String a;
  public String b;
  
  public PubAccountQQText(CharSequence paramCharSequence, int paramInt)
  {
    super(paramCharSequence, paramInt);
  }
  
  protected void a(View paramView, String paramString)
  {
    Context localContext = paramView.getContext();
    Intent localIntent = new Intent(localContext, PublicAccountBrowser.class);
    localIntent.putExtra("uin", this.a);
    int i = paramString.lastIndexOf("#");
    if (i > 0) {}
    for (paramView = paramString.substring(i);; paramView = null)
    {
      String str2 = URLUtil.guessUrl(paramString);
      String str1 = str2;
      if (paramView != null) {
        str1 = str2 + paramView;
      }
      localIntent.putExtra("url", str1);
      localIntent.putExtra("assignBackText", localContext.getResources().getString(2131433712));
      localIntent.putExtra("puin", this.b);
      localIntent.putExtra("key_isReadModeEnabled", true);
      localIntent.putExtra("fromAio", true);
      localIntent.putExtra("fromPublicAccount", true);
      localIntent.putExtra("articalChannelId", 1);
      PublicAccountUtil.a(localIntent, paramString);
      localContext.startActivity(localIntent);
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, str1, "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.widgets.PubAccountQQText
 * JD-Core Version:    0.7.0.1
 */