package com.tencent.mm.plugin.appbrand.phonenumber;

import android.text.SpannableString;
import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManageLogic;", "", "addPhone", "", "editPhoneNumber", "enableEdit", "", "finishEdit", "getSpanString", "Landroid/text/SpannableString;", "getView", "Landroid/view/View;", "init", "removePhone", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "uninit", "updateView", "showDelete", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public abstract interface o
{
  public abstract void a();
  
  public abstract void a(@NotNull r paramr);
  
  public abstract void a(boolean paramBoolean);
  
  @Nullable
  public abstract View b();
  
  public abstract void b(boolean paramBoolean);
  
  public abstract void c();
  
  @NotNull
  public abstract SpannableString d();
  
  public abstract void e();
  
  public abstract void f();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.o
 * JD-Core Version:    0.7.0.1
 */