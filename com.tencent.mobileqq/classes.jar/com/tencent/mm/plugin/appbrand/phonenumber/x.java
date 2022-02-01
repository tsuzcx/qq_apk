package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageLogic;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManageLogic;", "mContext", "Landroid/content/Context;", "mAppId", "", "mPagePath", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "mDeletePhoneItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lkotlin/collections/ArrayList;", "mPhoneItems", "mPhoneNumberManagerView", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManagerView;", "mShowDelete", "", "addPhone", "", "editPhoneNumber", "enableEdit", "finishEdit", "getSpanString", "Landroid/text/SpannableString;", "getView", "Landroid/view/View;", "init", "removePhone", "phoneItem", "uninit", "updateView", "showDelete", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class x
  implements o
{
  private p a;
  private final ArrayList<r> b;
  private final ArrayList<r> c;
  private boolean d;
  private final Context e;
  private final String f;
  private final String g;
  
  public x(@NotNull Context paramContext, @NotNull String paramString1, @NotNull String paramString2)
  {
    this.e = paramContext;
    this.f = paramString1;
    this.g = paramString2;
    this.b = new ArrayList();
    this.c = new ArrayList();
  }
  
  public void a()
  {
    this.a = ((p)new y(this.e, (o)this));
    this.b.clear();
    this.b.addAll((Collection)s.a.a());
    aa.a.c(this.f);
  }
  
  public void a(@NotNull r paramr)
  {
    Intrinsics.checkParameterIsNotNull(paramr, "phoneItem");
    this.c.add(paramr);
    this.b.remove(paramr);
    paramr = this.a;
    if (paramr != null) {
      paramr.a(this.d, (List)this.b);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b.clear();
    this.b.addAll((Collection)s.a.a());
    p localp = this.a;
    if (localp != null) {
      localp.a(paramBoolean, (List)this.b);
    }
  }
  
  @Nullable
  public View b()
  {
    p localp = this.a;
    if (localp != null) {
      return localp.a();
    }
    return null;
  }
  
  public void b(boolean paramBoolean)
  {
    this.d = (paramBoolean ^ true);
    p localp = this.a;
    if (localp != null) {
      localp.a(this.d, (List)this.b);
    }
  }
  
  public void c()
  {
    z localz = aa.a.d(this.f);
    if (localz != null)
    {
      Object localObject = aa.a.d(this.f);
      if (localObject != null) {
        localObject = Long.valueOf(((z)localObject).s());
      } else {
        localObject = null;
      }
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localz.t(((Long)localObject).longValue() + 1L);
    }
    v.a.a().a(this.e, this.f, (Function2)x.a.a);
  }
  
  @NotNull
  public SpannableString d()
  {
    return v.a.a().a(this.e, this.f, this.g);
  }
  
  public void e()
  {
    if (this.c.size() >= 0)
    {
      localObject2 = this.c.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        r localr = (r)((Iterator)localObject2).next();
        z localz = aa.a.d(this.f);
        if (localz != null)
        {
          localObject1 = aa.a.d(this.f);
          if (localObject1 != null) {
            localObject1 = Long.valueOf(((z)localObject1).t());
          } else {
            localObject1 = null;
          }
          if (localObject1 == null) {
            Intrinsics.throwNpe();
          }
          localz.u(((Long)localObject1).longValue() + 1L);
        }
        new g(this.f, localr.b(), 1).a((Function1)new x.b(this));
      }
    }
    Object localObject1 = s.a;
    Object localObject2 = this.c;
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    ((s)localObject1).a((ArrayList)localObject2);
  }
  
  public void f()
  {
    aa.a.b(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.x
 * JD-Core Version:    0.7.0.1
 */