package com.tencent.luggage.opensdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.luggage.opensdk.ui.QRCodeTransferQRDisplayWidget;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.jx.m;
import com.tencent.mm.plugin.appbrand.widget.dialog.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang.ArrayUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/opensdk/QRCodeDisplayDialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAlertDialog;", "Lcom/tencent/luggage/opensdk/QRCodeDisplayInterface;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "closeImage", "Landroid/widget/ImageView;", "containerLL", "Landroid/widget/LinearLayout;", "layoutFactory", "Lcom/tencent/luggage/opensdk/QRCodeDisplayDialog$LayoutFactory;", "qrcodeDisplay", "Lcom/tencent/luggage/opensdk/ui/QRCodeTransferQRDisplayWidget;", "attachJsApi", "", "jsapi", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "args", "Lorg/json/JSONObject;", "dismiss", "notifyQRCodeConnectError", "notifyQRCodeExpired", "notifyQRCodeScanned", "refreshQRCode", "bitmap", "Landroid/graphics/Bitmap;", "setOnRefreshButtonClickListener", "l", "Landroid/view/View$OnClickListener;", "showCloseBtn", "closeListener", "LayoutFactory", "NormalLayoutFactory", "PayLayoutFactory", "ShareAppMessageLayoutFactory", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class k
  extends b
{
  private final LinearLayout a;
  private final ImageView b;
  private final QRCodeTransferQRDisplayWidget c;
  private k.a d;
  
  public k(@NotNull Context paramContext)
  {
    super(paramContext);
    setContentView(LayoutInflater.from((Context)new ContextThemeWrapper(paramContext, 2131952509)).inflate(2131625224, null));
    Object localObject = getContentView().findViewById(2131431305);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "contentView.findViewById(R.id.container_ll)");
    this.a = ((LinearLayout)localObject);
    localObject = getContentView().findViewById(2131430806);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "contentView.findViewById(R.id.close)");
    this.b = ((ImageView)localObject);
    ImageView localImageView = this.b;
    Rect localRect = new Rect();
    localImageView.getHitRect(localRect);
    int i = l.a(paramContext, 15.0F);
    localRect.top -= i;
    localRect.right += i;
    localRect.left -= i;
    localRect.bottom += i;
    localObject = localImageView.getParent();
    paramContext = (Context)localObject;
    if (!(localObject instanceof View)) {
      paramContext = null;
    }
    paramContext = (View)paramContext;
    if (paramContext != null) {
      paramContext.setTouchDelegate(new TouchDelegate(localRect, (View)localImageView));
    }
    paramContext = getContentView().findViewById(2131442862);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "contentView.findViewById(R.id.qrcode_display)");
    this.c = ((QRCodeTransferQRDisplayWidget)paramContext);
    getContentView().addOnAttachStateChangeListener((View.OnAttachStateChangeListener)new k.1(this));
  }
  
  public void a()
  {
    this.c.a();
  }
  
  public void a(@NotNull Bitmap paramBitmap)
  {
    Intrinsics.checkParameterIsNotNull(paramBitmap, "bitmap");
    this.c.a(paramBitmap);
    paramBitmap = this.d;
    if (paramBitmap != null) {
      paramBitmap.a(this);
    }
  }
  
  public void a(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.b.setVisibility(0);
    this.b.setOnClickListener(paramOnClickListener);
  }
  
  public final void a(@NotNull m paramm, @NotNull h paramh, @NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramm, "jsapi");
    Intrinsics.checkParameterIsNotNull(paramh, "component");
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "args");
    if (ArrayUtils.contains(k.c.a.a(), paramm.d())) {
      paramm = (k.a)new k.c();
    } else if (ArrayUtils.contains(k.d.a.a(), paramm.d())) {
      paramm = (k.a)new k.d();
    } else {
      paramm = (k.a)new k.b();
    }
    this.d = paramm;
    paramm.a(this, paramh, paramJSONObject);
  }
  
  public void b()
  {
    this.c.b();
  }
  
  public void c()
  {
    this.c.c();
  }
  
  public void dismiss()
  {
    com.tencent.luggage.wxa.pc.l.a((Runnable)new k.e(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.k
 * JD-Core Version:    0.7.0.1
 */