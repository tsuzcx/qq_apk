package com.tencent.luggage.wxa.ei;

import com.tencent.luggage.wxa.ih.d;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/setting/presenter/ISubscribeMsgSettingPagePresenter;", "", "getCheckBoxState", "", "item", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "loadData", "", "bizUsername", "", "mAppId", "l", "Lcom/tencent/luggage/setting/presenter/ISubscribeMsgSettingPagePresenter$LoadDataListener;", "onActivityCreated", "activity", "Landroid/app/Activity;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivityStarted", "onActivityStopped", "onFinish", "onSubscribeMsgItemCheckBoxChanged", "itemChanged", "check", "onSubscribeSwitchChanged", "on", "LoadDataListener", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public abstract interface b
{
  public abstract void a(@NotNull d paramd, boolean paramBoolean);
  
  public abstract void a(@NotNull String paramString1, @NotNull String paramString2, @NotNull b.a parama);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract boolean a(@NotNull d paramd);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ei.b
 * JD-Core Version:    0.7.0.1
 */