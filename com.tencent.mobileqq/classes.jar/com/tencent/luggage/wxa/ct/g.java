package com.tencent.luggage.wxa.ct;

import android.text.TextUtils;
import android.view.View;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.kd.d;
import com.tencent.luggage.wxa.pd.k;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.xweb.WebView;
import java.util.Locale;
import org.json.JSONObject;

public class g
  extends d
{
  public static final int CTRL_INDEX = 300;
  public static final String NAME = "updateHTMLWebView";
  
  protected int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.getInt("htmlId");
  }
  
  protected boolean a(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    if (!(paramView instanceof a)) {
      return false;
    }
    paramJSONObject = paramJSONObject.optString("src", "");
    o.d("MicroMsg.AppBrand.JsApiUpdateHTMLWebView", "onUpdateView appId[%s] viewId[%d] viewHash[%d] src[%s]", new Object[] { parame.getAppId(), Integer.valueOf(paramInt), Integer.valueOf(paramView.hashCode()), paramJSONObject });
    if (TextUtils.isEmpty(paramJSONObject)) {
      return true;
    }
    parame = ((a)paramView).getWebView();
    if ((paramJSONObject.indexOf("#") >= 0) && (!TextUtils.isEmpty(parame.getUrl())) && (!paramJSONObject.endsWith("#wechat_redirect")))
    {
      parame.evaluateJavascript(String.format(Locale.ENGLISH, "window.location=\"%s\"", new Object[] { k.a(paramJSONObject) }), null);
      return true;
    }
    parame.loadUrl(paramJSONObject);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ct.g
 * JD-Core Version:    0.7.0.1
 */