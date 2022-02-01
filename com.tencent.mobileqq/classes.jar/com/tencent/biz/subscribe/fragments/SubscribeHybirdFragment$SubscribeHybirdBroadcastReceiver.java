package com.tencent.biz.subscribe.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import org.json.JSONException;
import org.json.JSONObject;

class SubscribeHybirdFragment$SubscribeHybirdBroadcastReceiver
  extends BroadcastReceiver
{
  private SubscribeHybirdFragment$SubscribeHybirdBroadcastReceiver(SubscribeHybirdFragment paramSubscribeHybirdFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if (TextUtils.equals(paramContext, "action_update_follow_state")) {
        try
        {
          paramContext = new JSONObject();
          paramContext.put("uin", paramIntent.getStringExtra("uin"));
          paramContext.put("followState", paramIntent.getIntExtra("followState", 0));
          if (this.a.getWebView() == null) {
            break label328;
          }
          this.a.getWebView().callJs(WebViewPlugin.toJsScript("updateFollowState", paramContext, null));
          return;
        }
        catch (JSONException paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
      } else if (!TextUtils.equals(paramContext, "action_get_lbs_location")) {}
    }
    for (;;)
    {
      int i;
      try
      {
        paramContext = paramIntent.getStringArrayExtra("code");
        String[] arrayOfString = paramIntent.getStringArrayExtra("location");
        paramIntent = new JSONObject();
        JSONObject localJSONObject = new JSONObject();
        if ((paramContext != null) && (arrayOfString != null) && (paramContext.length == 4) && (arrayOfString.length == 4))
        {
          i = 0;
          if (i < 4)
          {
            if (!"0".equals(paramContext[i])) {
              break label329;
            }
            paramContext[i] = "";
            arrayOfString[i] = "";
            break label329;
          }
          paramIntent.put("country", paramContext[0]);
          paramIntent.put("province", paramContext[1]);
          paramIntent.put("city", paramContext[2]);
          paramIntent.put("area", paramContext[3]);
          localJSONObject.put("country", arrayOfString[0]);
          localJSONObject.put("province", arrayOfString[1]);
          localJSONObject.put("city", arrayOfString[2]);
          localJSONObject.put("area", arrayOfString[3]);
        }
        paramContext = new JSONObject();
        paramContext.put("code", paramIntent);
        paramContext.put("location", localJSONObject);
        if (this.a.getWebView() != null)
        {
          this.a.getWebView().callJs(WebViewPlugin.toJsScript("getlbslocationCallback", paramContext, null));
          return;
        }
      }
      catch (JSONException paramContext)
      {
        paramContext.printStackTrace();
      }
      label328:
      return;
      label329:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeHybirdFragment.SubscribeHybirdBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */