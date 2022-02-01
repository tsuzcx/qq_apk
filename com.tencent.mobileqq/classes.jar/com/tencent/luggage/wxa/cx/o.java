package com.tencent.luggage.wxa.cx;

import android.app.Activity;
import android.content.Context;
import com.tencent.luggage.ui.WxaSimpleWebViewActivity;
import com.tencent.luggage.ui.WxaSimpleWebViewActivity.a;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/launch/WxaLaunchErrorActionH5;", "Lcom/tencent/luggage/launch/WxaLaunchErrorAction;", "url", "", "(Ljava/lang/String;)V", "showError", "", "activity", "Landroid/app/Activity;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class o
  extends m
{
  private final String b;
  
  public o(@Nullable String paramString)
  {
    this.b = paramString;
  }
  
  public void a(@Nullable Activity paramActivity)
  {
    WxaSimpleWebViewActivity.a.a((Context)paramActivity, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.o
 * JD-Core Version:    0.7.0.1
 */