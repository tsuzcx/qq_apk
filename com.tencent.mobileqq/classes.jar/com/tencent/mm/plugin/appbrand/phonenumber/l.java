package com.tencent.mm.plugin.appbrand.phonenumber;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;", "", "getView", "Landroid/view/View;", "init", "", "sendSms", "mobile", "", "uninit", "verifyCode", "isCheck", "", "code", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public abstract interface l
{
  public abstract void a();
  
  public abstract void a(@NotNull String paramString);
  
  public abstract void a(boolean paramBoolean, @NotNull String paramString1, @NotNull String paramString2);
  
  @Nullable
  public abstract View b();
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.l
 * JD-Core Version:    0.7.0.1
 */