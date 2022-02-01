package com.tencent.luggage.setting.ui;

import android.app.Activity;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tencent.luggage.wxa.eh.d.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/setting/ui/AppBrandUserInfoAuthorizeUI$onCreate$4", "Lcom/tencent/luggage/setting/entity/WxaUserInfoListOperationController$WxaUserInfoEventListener;", "onItemListChanged", "", "items", "", "Lcom/tencent/luggage/setting/ui/WxaUserInfoListAdapter$Item;", "updateAddNewAvatarEntry", "isBan", "", "reachMaxCount", "limitWording", "", "avatarWording", "goAddUserPage", "Lkotlin/Function2;", "Landroid/app/Activity;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class AppBrandUserInfoAuthorizeUI$f
  implements d.b
{
  public void a(@NotNull List<a.a> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "items");
    if (AppBrandUserInfoAuthorizeUI.b(this.a) == null) {
      AppBrandUserInfoAuthorizeUI.a(this.a, (List)new ArrayList((Collection)paramList));
    }
    AppBrandUserInfoAuthorizeUI.c(this.a).clear();
    AppBrandUserInfoAuthorizeUI.c(this.a).addAll((Collection)paramList);
    paramList = AppBrandUserInfoAuthorizeUI.d(this.a).findViewById(2131449261);
    Intrinsics.checkExpressionValueIsNotNull(paramList, "rootView.findViewById<Re…iew>(R.id.user_info_list)");
    paramList = ((RecyclerView)paramList).getAdapter();
    if (paramList != null) {
      paramList.notifyDataSetChanged();
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, @NotNull String paramString1, @NotNull String paramString2, @NotNull Function2<? super Activity, ? super String, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "limitWording");
    Intrinsics.checkParameterIsNotNull(paramString2, "avatarWording");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "goAddUserPage");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.setting.ui.AppBrandUserInfoAuthorizeUI.f
 * JD-Core Version:    0.7.0.1
 */