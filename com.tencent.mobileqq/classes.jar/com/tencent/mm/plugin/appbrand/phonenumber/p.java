package com.tencent.mm.plugin.appbrand.phonenumber;

import android.view.View;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManagerView;", "", "getView", "Landroid/view/View;", "updateView", "", "showDelete", "", "phoneItems", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public abstract interface p
{
  @Nullable
  public abstract View a();
  
  public abstract void a(boolean paramBoolean, @NotNull List<r> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.p
 * JD-Core Version:    0.7.0.1
 */