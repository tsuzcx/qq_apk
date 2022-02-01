package com.tencent.luggage.wxa.eh;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.ui.base.i.e;
import com.tencent.mm.ui.widget.menu.MMPopupMenu;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/setting/entity/WxaUserInfoListOperationController;", "Lcom/tencent/luggage/setting/entity/IUserInfoListOperationController;", "context", "Landroid/content/Context;", "mUserAvatarInfo", "Lcom/tencent/luggage/setting/entity/MMUserAvatarInfo;", "scope", "", "mListener", "Lcom/tencent/luggage/setting/entity/WxaUserInfoListOperationController$WxaUserInfoEventListener;", "(Landroid/content/Context;Lcom/tencent/luggage/setting/entity/MMUserAvatarInfo;Ljava/lang/String;Lcom/tencent/luggage/setting/entity/WxaUserInfoListOperationController$WxaUserInfoEventListener;)V", "START_CREATE_AVATAR_UI_REQUEST_CODE", "", "currentCheckedAvatarId", "Ljava/util/concurrent/atomic/AtomicInteger;", "deleteAvatarTaskCallback", "Lcom/tencent/luggage/setting/entity/IUserInfoListOperationController$DeleteAvatarTaskCallback;", "getDeleteAvatarTaskCallback", "()Lcom/tencent/luggage/setting/entity/IUserInfoListOperationController$DeleteAvatarTaskCallback;", "setDeleteAvatarTaskCallback", "(Lcom/tencent/luggage/setting/entity/IUserInfoListOperationController$DeleteAvatarTaskCallback;)V", "mCurrentItems", "Ljava/util/ArrayList;", "Lcom/tencent/luggage/setting/ui/WxaUserInfoListAdapter$Item;", "mmPopupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "getScope", "()Ljava/lang/String;", "deleteUser", "", "itemIndex", "callback", "dismissPopWindow", "genDialogItem", "", "mmUserAvatarInfo", "goAddUserPage", "activity", "Landroid/app/Activity;", "appId", "handleAfterCreateUser", "data", "Landroid/content/Intent;", "notifyUserInfoItemChanged", "item", "onItemChecked", "onItemLongClick", "view", "Landroid/view/View;", "index", "touchX", "touchY", "showPopWindow", "Companion", "WxaUserInfoEventListener", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class d
  implements a
{
  public static final d.a a = new d.a(null);
  private final ArrayList<com.tencent.luggage.setting.ui.a.a> b;
  private final AtomicInteger c;
  private final int d;
  @Nullable
  private a.a e;
  private MMPopupMenu f;
  private final Context g;
  private final b h;
  @NotNull
  private final String i;
  private final d.b j;
  
  public d(@NotNull Context paramContext, @NotNull b paramb, @NotNull String paramString, @NotNull d.b paramb1)
  {
    this.g = paramContext;
    this.h = paramb;
    this.i = paramString;
    this.j = paramb1;
    this.b = new ArrayList();
    this.c = new AtomicInteger(this.h.d());
    this.d = com.tencent.luggage.wxa.ef.a.a(this);
    this.b.addAll((Collection)a(this.i, this.h));
    a(this.b);
  }
  
  private final List<com.tencent.luggage.setting.ui.a.a> a(String paramString, b paramb)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = paramb.a();
    int m = localArrayList2.size();
    int k = 0;
    while (k < m)
    {
      Object localObject = localArrayList2.get(k);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "avatar_list[i]");
      localObject = (b.b)localObject;
      String str1 = ((b.b)localObject).b();
      String str2 = ((b.b)localObject).d();
      boolean bool;
      if (paramb.d() == ((b.b)localObject).a()) {
        bool = true;
      } else {
        bool = false;
      }
      localArrayList1.add(new com.tencent.luggage.setting.ui.a.a(str1, str2, paramString, bool, ((b.b)localObject).c(), ((b.b)localObject).a()));
      k += 1;
    }
    return (List)localArrayList1;
  }
  
  private final void a(ArrayList<com.tencent.luggage.setting.ui.a.a> paramArrayList)
  {
    this.j.a((List)paramArrayList);
    d.b localb = this.j;
    boolean bool2 = this.h.b();
    boolean bool1;
    if (this.h.c() <= paramArrayList.size()) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramArrayList = this.h.f();
    if (paramArrayList == null) {
      paramArrayList = "";
    }
    String str = this.h.e();
    if (str == null) {
      str = "";
    }
    localb.a(bool2, bool1, paramArrayList, str, (Function2)new d.c(this));
  }
  
  private final void b(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.f = new MMPopupMenu(paramView.getContext());
    if (paramInt1 == 0) {
      return;
    }
    MMPopupMenu localMMPopupMenu = this.f;
    if (localMMPopupMenu == null) {
      Intrinsics.throwNpe();
    }
    localMMPopupMenu.openPopupMenu(paramView, paramInt1, 0L, (View.OnCreateContextMenuListener)new d.d(paramView), (i.e)new d.e(this, paramInt1), paramInt2, paramInt3);
  }
  
  @Nullable
  public final a.a a()
  {
    return this.e;
  }
  
  public void a(int paramInt, @Nullable a.a parama)
  {
    parama = new StringBuilder();
    parama.append("[deleteUser] index=");
    parama.append(paramInt);
    o.d("WxaUserInfoListOperationController", parama.toString());
  }
  
  public void a(@NotNull Activity paramActivity, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
  }
  
  public void a(@NotNull View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    b(paramView, paramInt1, paramInt2, paramInt3);
  }
  
  public void a(@NotNull com.tencent.luggage.setting.ui.a.a parama)
  {
    Intrinsics.checkParameterIsNotNull(parama, "item");
    this.c.set(parama.f());
  }
  
  public final void a(@Nullable a.a parama)
  {
    this.e = parama;
  }
  
  public final void b()
  {
    MMPopupMenu localMMPopupMenu = this.f;
    if (localMMPopupMenu != null) {
      localMMPopupMenu.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.eh.d
 * JD-Core Version:    0.7.0.1
 */