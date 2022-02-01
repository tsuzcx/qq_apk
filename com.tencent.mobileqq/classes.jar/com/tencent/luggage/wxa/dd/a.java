package com.tencent.luggage.wxa.dd;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/account/BaseAccountManager;", "Lcom/tencent/luggage/login/account/IWxaAccountManager;", "()V", "accountCallbacks", "Ljava/util/HashSet;", "Lcom/tencent/luggage/login/account/IWxaAccountManager$IAccountCallback;", "Lkotlin/collections/HashSet;", "addAccountCallbacks", "", "callback", "isShare", "", "login", "logic", "Lcom/tencent/luggage/login/account/IWxaAccountManager$ILogin;", "logicCallback", "Lcom/tencent/luggage/login/account/IWxaAccountManager$ILoginCallback;", "logout", "notifyAccountLogin", "notifyAccountLogout", "removeAccountCallbacks", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public abstract class a
  implements b
{
  private HashSet<b.a> a = new HashSet();
  
  public void a(@NotNull b.a parama)
  {
    Intrinsics.checkParameterIsNotNull(parama, "callback");
    this.a.add(parama);
  }
  
  public void a(@NotNull b.b paramb, @Nullable b.c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "logic");
    paramb.a((b.c)new a.a(this, paramc));
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b()
  {
    d();
  }
  
  public void b(@NotNull b.a parama)
  {
    Intrinsics.checkParameterIsNotNull(parama, "callback");
    this.a.remove(parama);
  }
  
  protected final void c()
  {
    Object localObject = new HashSet();
    ((HashSet)localObject).addAll((Collection)this.a);
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b.a)((Iterator)localObject).next()).a();
    }
  }
  
  public final void d()
  {
    Object localObject = new HashSet();
    ((HashSet)localObject).addAll((Collection)this.a);
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b.a)((Iterator)localObject).next()).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dd.a
 * JD-Core Version:    0.7.0.1
 */