package com.tencent.luggage.opensdk;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.wxa.jx.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/opensdk/QRCodeDisplayDialog$PayLayoutFactory;", "Lcom/tencent/luggage/opensdk/QRCodeDisplayDialog$LayoutFactory;", "()V", "onAttached", "", "dialog", "Lcom/tencent/luggage/opensdk/QRCodeDisplayDialog;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "args", "Lorg/json/JSONObject;", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
final class k$c
  implements k.a
{
  public static final k.c.a a = new k.c.a(null);
  @NotNull
  private static final String[] b = { "requestVirtualPayment", "requestPayment", "requestPaymentToBank" };
  
  public void a(@NotNull k paramk)
  {
    Intrinsics.checkParameterIsNotNull(paramk, "dialog");
    k.a.a.a(this, paramk);
  }
  
  public void a(@NotNull k paramk, @NotNull h paramh, @NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramk, "dialog");
    Intrinsics.checkParameterIsNotNull(paramh, "component");
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "args");
    paramh = new ImageView(paramk.getContext());
    paramh.setImageResource(2130853490);
    paramh.setAdjustViewBounds(true);
    paramJSONObject = paramk.getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "dialog.context");
    paramJSONObject = new LinearLayout.LayoutParams(-2, l.a(paramJSONObject, 19.5F));
    paramJSONObject.gravity = 1;
    k.a(paramk).addView((View)paramh, 0, (ViewGroup.LayoutParams)paramJSONObject);
    paramh = new TextView(paramk.getContext());
    paramh.setText(2131914177);
    paramh.setTextColor(-16777216);
    paramJSONObject = paramk.getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "dialog.context");
    paramh.setTextSize(0, l.a(paramJSONObject, 13.0F));
    paramJSONObject = new LinearLayout.LayoutParams(-2, -2);
    Context localContext = paramk.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "dialog.context");
    paramJSONObject.topMargin = l.a(localContext, 10.5F);
    localContext = paramk.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "dialog.context");
    paramJSONObject.bottomMargin = l.a(localContext, 12.7F);
    paramJSONObject.gravity = 1;
    k.a(paramk).addView((View)paramh, 1, (ViewGroup.LayoutParams)paramJSONObject);
    paramh = k.a(paramk);
    paramJSONObject = paramk.getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "dialog.context");
    int i = l.a(paramJSONObject, 50.400002F);
    paramk = paramk.getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramk, "dialog.context");
    paramh.setPadding(0, i, 0, l.a(paramk, 51.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.k.c
 * JD-Core Version:    0.7.0.1
 */