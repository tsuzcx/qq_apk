package com.tencent.luggage.sdk.customize.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.wxa.jx.z;
import com.tencent.luggage.wxa.qw.ib;
import com.tencent.luggage.wxa.qz.o;

public class FullSdkExternalToolsHelper
  implements z
{
  private static void a(ib paramib, Intent paramIntent) {}
  
  public void a(Context paramContext, String paramString, ib paramib)
  {
    o.e("Luggage.FullSdkExternalToolsHelper", "open webview activity url: %s", new Object[] { paramString });
    Intent localIntent = new Intent(paramContext, FullSdkExternalToolsHelper.SimpleWebViewActivity.class);
    localIntent.putExtra("_url_", paramString);
    a(paramib, localIntent);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    paramContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.customize.impl.FullSdkExternalToolsHelper
 * JD-Core Version:    0.7.0.1
 */