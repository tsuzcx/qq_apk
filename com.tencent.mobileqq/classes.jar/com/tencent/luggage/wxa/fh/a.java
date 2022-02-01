package com.tencent.luggage.wxa.fh;

import android.content.Context;
import androidx.annotation.StringRes;
import com.tencent.luggage.ui.WxaAlertActivity;
import com.tencent.luggage.ui.WxaAlertActivity.a;
import com.tencent.luggage.wxa.dc.h.a;
import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/opensdk/OpenSDKTransferAlertUtils;", "", "()V", "showErrorAlert", "", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "messageResId", "", "message", "", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class a
{
  public static final a a = new a();
  
  public final void a(@Nullable b paramb, @StringRes int paramInt)
  {
    a(paramb, r.a().getString(paramInt));
  }
  
  public final void a(@Nullable b paramb, @Nullable String paramString)
  {
    if (paramb == null)
    {
      paramb = r.a();
      WxaAlertActivity.a.a(r.a(), new h.a(paramb.getString(2131889038), paramString));
      return;
    }
    f.a.a((Runnable)new a.a(paramb, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fh.a
 * JD-Core Version:    0.7.0.1
 */