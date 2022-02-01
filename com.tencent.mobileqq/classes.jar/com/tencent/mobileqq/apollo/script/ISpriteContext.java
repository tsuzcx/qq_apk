package com.tencent.mobileqq.apollo.script;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/script/ISpriteContext;", "", "execScript", "", "script", "", "getAIOType", "", "getFriendUin", "getHideValue", "getSelfUin", "getSpriteFrom", "initHide", "isAIOHide", "", "isBubbleMeme", "isCanInitCmShow", "isHide", "isInAIOHiddenList", "from", "isNoneApolloActionPlay", "isSurfaceReady", "setCanInitCmshow", "initCmShow", "setHideSprite", "setIsBubbleMeme", "setNoneApolloActionPlay", "setPanelShow", "panelShow", "cmshow_api_release"}, k=1, mv={1, 1, 16})
public abstract interface ISpriteContext
{
  public abstract void a(@NotNull String paramString, boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract boolean a();
  
  public abstract boolean a(@NotNull String paramString);
  
  public abstract void b(@Nullable String paramString);
  
  public abstract void b(boolean paramBoolean);
  
  public abstract boolean b();
  
  public abstract void c(boolean paramBoolean);
  
  public abstract boolean c();
  
  public abstract void d(boolean paramBoolean);
  
  public abstract boolean d();
  
  public abstract int e();
  
  public abstract boolean f();
  
  @NotNull
  public abstract String g();
  
  @NotNull
  public abstract String h();
  
  public abstract int i();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.ISpriteContext
 * JD-Core Version:    0.7.0.1
 */