package com.tencent.luggage.opensdk;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.h;
import com.tencent.mm.modelappbrand.image.WxaIconTransformation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/opensdk/QRCodeDisplayDialog$ShareAppMessageLayoutFactory;", "Lcom/tencent/luggage/opensdk/QRCodeDisplayDialog$LayoutFactory;", "()V", "invokeArgs", "Lorg/json/JSONObject;", "onAttached", "", "dialog", "Lcom/tencent/luggage/opensdk/QRCodeDisplayDialog;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "args", "onQRCodeReady", "Companion", "ThumbImageTransformation", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
final class k$d
  implements k.a
{
  public static final k.d.a a = new k.d.a(null);
  @NotNull
  private static final String[] c = { "shareAppMessage", "shareAppMessageDirectly" };
  private JSONObject b;
  
  public void a(@NotNull k paramk)
  {
    Intrinsics.checkParameterIsNotNull(paramk, "dialog");
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((JSONObject)localObject).optString("imageUrl", null);
      if (localObject != null) {
        AppBrandSimpleImageLoader.instance().attach((ImageView)k.a(paramk).findViewById(2131445774), (String)localObject, null, (AppBrandSimpleImageLoader.h)k.d.b.a);
      }
    }
  }
  
  public void a(@NotNull k paramk, @NotNull com.tencent.luggage.wxa.jx.h paramh, @NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramk, "dialog");
    Intrinsics.checkParameterIsNotNull(paramh, "component");
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "args");
    this.b = paramJSONObject;
    Object localObject1 = new ImageView(paramk.getContext());
    ((ImageView)localObject1).setImageResource(2130853489);
    ((ImageView)localObject1).setAdjustViewBounds(true);
    Object localObject2 = paramk.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "dialog.context");
    localObject2 = new LinearLayout.LayoutParams(-2, l.a((Context)localObject2, 24.0F));
    ((LinearLayout.LayoutParams)localObject2).gravity = 1;
    k.a(paramk).addView((View)localObject1, 0, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new TextView(paramk.getContext());
    ((TextView)localObject1).setText(2131914181);
    ((TextView)localObject1).setTextColor(-16777216);
    localObject2 = paramk.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "dialog.context");
    ((TextView)localObject1).setTextSize(0, l.a((Context)localObject2, 13.0F));
    localObject2 = new LinearLayout.LayoutParams(-2, -2);
    Object localObject3 = paramk.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "dialog.context");
    ((LinearLayout.LayoutParams)localObject2).topMargin = l.a((Context)localObject3, 11.7F);
    localObject3 = paramk.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "dialog.context");
    ((LinearLayout.LayoutParams)localObject2).bottomMargin = l.a((Context)localObject3, 11.7F);
    ((LinearLayout.LayoutParams)localObject2).gravity = 1;
    k.a(paramk).addView((View)localObject1, 1, (ViewGroup.LayoutParams)localObject2);
    localObject3 = LayoutInflater.from(paramk.getContext()).inflate(2131625226, (ViewGroup)k.a(paramk), false);
    k.a(paramk).addView((View)localObject3);
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "descriptionCell");
    localObject1 = ((View)localObject3).getLayoutParams();
    boolean bool = localObject1 instanceof ViewGroup.MarginLayoutParams;
    localObject2 = null;
    if (!bool) {
      localObject1 = null;
    }
    localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
    if (localObject1 != null)
    {
      localObject4 = paramk.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "dialog.context");
      ((ViewGroup.MarginLayoutParams)localObject1).topMargin = l.a((Context)localObject4, 23.0F);
      localObject4 = paramk.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "dialog.context");
      ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = l.a((Context)localObject4, 16.0F);
      localObject4 = paramk.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "dialog.context");
      ((ViewGroup.MarginLayoutParams)localObject1).rightMargin = l.a((Context)localObject4, 16.0F);
      ((View)localObject3).requestLayout();
    }
    Object localObject4 = AppBrandSimpleImageLoader.instance();
    ImageView localImageView = (ImageView)((View)localObject3).findViewById(2131445773);
    localObject1 = paramh.q();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "component.runtime");
    String str = l.a((d)localObject1);
    com.tencent.mm.plugin.appbrand.widget.h localh = (com.tencent.mm.plugin.appbrand.widget.h)paramh.a(com.tencent.mm.plugin.appbrand.widget.h.class);
    localObject1 = localObject2;
    if (localh != null) {
      localObject1 = localh.a();
    }
    ((AppBrandSimpleImageLoader)localObject4).attach(localImageView, str, (Drawable)localObject1, (AppBrandSimpleImageLoader.h)WxaIconTransformation.INSTANCE);
    localObject1 = ((View)localObject3).findViewById(2131445771);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "descriptionCell.findView…hare_description_appname)");
    localObject1 = (TextView)localObject1;
    localObject2 = paramh.q();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "component.runtime");
    ((TextView)localObject1).setText((CharSequence)l.b((d)localObject2));
    paramh = paramh.q();
    Intrinsics.checkExpressionValueIsNotNull(paramh, "component.runtime");
    paramh = paramJSONObject.optString("desc", l.b(paramh));
    paramJSONObject = ((View)localObject3).findViewById(2131445772);
    Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "descriptionCell.findView…share_description_digest)");
    ((TextView)paramJSONObject).setText((CharSequence)paramh);
    paramh = k.a(paramk);
    paramJSONObject = paramk.getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "dialog.context");
    int i = l.a(paramJSONObject, 36.0F);
    paramk = paramk.getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramk, "dialog.context");
    paramh.setPadding(0, i, 0, l.a(paramk, 16.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.k.d
 * JD-Core Version:    0.7.0.1
 */