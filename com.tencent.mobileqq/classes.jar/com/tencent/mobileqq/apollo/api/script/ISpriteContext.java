package com.tencent.mobileqq.apollo.api.script;

import com.tencent.mobileqq.apollo.IApolloRenderView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/api/script/ISpriteContext;", "", "getAIOType", "", "getFriendUin", "", "getHideValue", "getRenderView", "Lcom/tencent/mobileqq/apollo/IApolloRenderView;", "getSelfUin", "getSpriteFrom", "initHide", "", "isAIOHide", "", "isCanInitCmShow", "isHide", "isInAIOHiddenList", "from", "isNoneApolloActionPlay", "isSurfaceReady", "setCanInitCmshow", "initCmShow", "setHideSprite", "setIsBubbleMeme", "isBubbleMeme", "setNoneApolloActionPlay", "setPanelShow", "panelShow", "setRenderView", "view", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface ISpriteContext
{
  public abstract int a();
  
  @NotNull
  public abstract IApolloRenderView a();
  
  @NotNull
  public abstract String a();
  
  public abstract void a();
  
  public abstract void a(@NotNull IApolloRenderView paramIApolloRenderView);
  
  public abstract void a(@NotNull String paramString, boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract boolean a();
  
  public abstract boolean a(@NotNull String paramString);
  
  public abstract int b();
  
  @NotNull
  public abstract String b();
  
  public abstract void b(boolean paramBoolean);
  
  public abstract boolean b();
  
  public abstract int c();
  
  public abstract void c(boolean paramBoolean);
  
  public abstract boolean c();
  
  public abstract void d(boolean paramBoolean);
  
  public abstract boolean d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.script.ISpriteContext
 * JD-Core Version:    0.7.0.1
 */