package com.tencent.luggage.wxa.dd;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/account/IWxaAccountManager;", "", "addAccountCallbacks", "", "callback", "Lcom/tencent/luggage/login/account/IWxaAccountManager$IAccountCallback;", "getSessionInfo", "Lcom/tencent/luggage/login/account/SessionInfo;", "getSessionKey", "", "hasLogin", "", "init", "share", "isShare", "login", "logic", "Lcom/tencent/luggage/login/account/IWxaAccountManager$ILogin;", "logicCallback", "Lcom/tencent/luggage/login/account/IWxaAccountManager$ILoginCallback;", "loginSessionInfo", "sessionInfo", "logout", "refreshSession", "Lcom/tencent/mm/vending/pipeline/Pipeable;", "refreshSessionInfoSync", "release", "removeAccountCallbacks", "IAccountCallback", "ILogin", "ILoginCallback", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public abstract interface b
{
  public abstract void a(@NotNull b.a parama);
  
  public abstract void a(@NotNull b.b paramb, @Nullable b.c paramc);
  
  public abstract void a(@Nullable g paramg);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract boolean a();
  
  public abstract void b();
  
  public abstract void b(@NotNull b.a parama);
  
  @NotNull
  public abstract String e();
  
  @Nullable
  public abstract g f();
  
  public abstract boolean g();
  
  public abstract boolean h();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dd.b
 * JD-Core Version:    0.7.0.1
 */