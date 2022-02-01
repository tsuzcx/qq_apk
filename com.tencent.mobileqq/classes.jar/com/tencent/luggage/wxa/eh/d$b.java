package com.tencent.luggage.wxa.eh;

import android.app.Activity;
import com.tencent.luggage.setting.ui.a.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/setting/entity/WxaUserInfoListOperationController$WxaUserInfoEventListener;", "", "onItemListChanged", "", "items", "", "Lcom/tencent/luggage/setting/ui/WxaUserInfoListAdapter$Item;", "updateAddNewAvatarEntry", "isBan", "", "reachMaxCount", "limitWording", "", "avatarWording", "goAddUserPage", "Lkotlin/Function2;", "Landroid/app/Activity;", "Lkotlin/ParameterName;", "name", "activity", "appId", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public abstract interface d$b
{
  public abstract void a(@NotNull List<a.a> paramList);
  
  public abstract void a(boolean paramBoolean1, boolean paramBoolean2, @NotNull String paramString1, @NotNull String paramString2, @NotNull Function2<? super Activity, ? super String, Unit> paramFunction2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.eh.d.b
 * JD-Core Version:    0.7.0.1
 */