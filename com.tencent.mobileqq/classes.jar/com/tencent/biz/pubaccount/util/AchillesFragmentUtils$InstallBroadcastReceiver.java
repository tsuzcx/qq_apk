package com.tencent.biz.pubaccount.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import bgve;
import com.tencent.biz.pubaccount.CustomWebView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class AchillesFragmentUtils$InstallBroadcastReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      String str = paramIntent.getAction();
      paramContext = (bgve)AchillesFragmentUtils.a().get();
      paramIntent = paramIntent.getData().getEncodedSchemeSpecificPart();
      if ((paramContext != null) && (!TextUtils.isEmpty(paramIntent))) {
        if (paramContext == null) {
          break label111;
        }
      }
      label111:
      for (paramContext = paramContext.a();; paramContext = null)
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("code", 1);
        localJSONObject.put("packageName", paramIntent);
        if ((paramContext != null) && (!TextUtils.isEmpty(AchillesFragmentUtils.a()))) {
          paramContext.callJs(AchillesFragmentUtils.a(), new String[] { localJSONObject.toString() });
        }
        AchillesFragmentUtils.a("appinstall", str, paramIntent, null);
        return;
      }
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.AchillesFragmentUtils.InstallBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */