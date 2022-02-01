package com.tencent.mobileqq.apollo.api.sdk.impl;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.api.sdk.ICmShowRenderViewDelegate;
import com.tencent.mobileqq.apollo.api.sdk.IRenderViewListener;
import com.tencent.mobileqq.apollo.api.sdk.PlayActionConfig;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/api/sdk/impl/CmShowRenderViewDelegateImpl;", "Lcom/tencent/mobileqq/apollo/api/sdk/ICmShowRenderViewDelegate;", "()V", "renderView", "Lcom/tencent/mobileqq/apollo/sdk/CmShowRenderView;", "bringToFront", "", "changeSpriteModel", "uin", "", "mode", "", "destroy", "disableTouchEvent", "disable", "", "disposeAvatar", "uins", "", "all", "getCmShowMode", "getHeight", "getParent", "Landroid/view/ViewParent;", "getView", "Landroid/view/View;", "getWidth", "hideBubble", "initAvatar", "selfUin", "friendUin", "scale", "", "seq", "extraBundle", "Landroid/os/Bundle;", "initView", "iRenderViewListener", "Lcom/tencent/mobileqq/apollo/api/sdk/IRenderViewListener;", "traceReportId", "pause", "playAction", "playActionConfig", "Lcom/tencent/mobileqq/apollo/api/sdk/PlayActionConfig;", "resume", "setTouchEventRect", "boxRect", "Landroid/graphics/Rect;", "leftRect", "leftUin", "rightRect", "rightUin", "showBubble", "bubbleText", "direction", "bubbleStyle", "showOrHideAvatar", "show", "stopAction", "actionId", "actionSeqId", "updateAvatarParam", "x", "y", "rotate", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class CmShowRenderViewDelegateImpl
  implements ICmShowRenderViewDelegate
{
  private CmShowRenderView renderView = new CmShowRenderView((Context)BaseApplicationImpl.getContext());
  
  public void bringToFront()
  {
    this.renderView.bringToFront();
  }
  
  public void changeSpriteModel(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    this.renderView.a(paramString, paramInt);
  }
  
  public void destroy()
  {
    this.renderView.c();
  }
  
  public void disableTouchEvent(boolean paramBoolean)
  {
    this.renderView.disableTouchEvent(paramBoolean);
  }
  
  public void disposeAvatar(@Nullable List<String> paramList, boolean paramBoolean)
  {
    this.renderView.a(paramList, paramBoolean);
  }
  
  public int getCmShowMode(@Nullable String paramString)
  {
    return this.renderView.a(paramString);
  }
  
  public int getHeight()
  {
    return this.renderView.getHeight();
  }
  
  @NotNull
  public ViewParent getParent()
  {
    ViewParent localViewParent = this.renderView.getParent();
    Intrinsics.checkExpressionValueIsNotNull(localViewParent, "renderView.parent");
    return localViewParent;
  }
  
  @NotNull
  public View getView()
  {
    return (View)this.renderView;
  }
  
  public int getWidth()
  {
    return this.renderView.getWidth();
  }
  
  public void hideBubble(@Nullable String paramString)
  {
    this.renderView.a(paramString);
  }
  
  public void initAvatar(@Nullable String paramString1, @Nullable String paramString2, float paramFloat, int paramInt, @Nullable Bundle paramBundle)
  {
    this.renderView.a(paramString1, paramString2, paramFloat, paramInt, paramBundle);
  }
  
  public void initView(@Nullable IRenderViewListener paramIRenderViewListener, @Nullable String paramString1, @Nullable String paramString2, int paramInt)
  {
    this.renderView.a(paramIRenderViewListener, paramString1, paramString2, paramInt);
  }
  
  public void pause()
  {
    this.renderView.a();
  }
  
  public void playAction(@Nullable PlayActionConfig paramPlayActionConfig)
  {
    this.renderView.a(paramPlayActionConfig);
  }
  
  public void resume()
  {
    this.renderView.b();
  }
  
  public void setTouchEventRect(@NotNull Rect paramRect1, @NotNull Rect paramRect2, @Nullable String paramString1, @NotNull Rect paramRect3, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramRect1, "boxRect");
    Intrinsics.checkParameterIsNotNull(paramRect2, "leftRect");
    Intrinsics.checkParameterIsNotNull(paramRect3, "rightRect");
    this.renderView.setTouchEventRect(paramRect1, paramRect2, paramString1, paramRect3, paramString2);
  }
  
  public void showBubble(@Nullable String paramString1, @Nullable String paramString2, int paramInt1, int paramInt2)
  {
    this.renderView.a(paramString1, paramString2, paramInt1, paramInt2);
  }
  
  public void showOrHideAvatar(@Nullable String paramString, boolean paramBoolean)
  {
    this.renderView.a(paramString, paramBoolean);
  }
  
  public void stopAction(int paramInt1, int paramInt2)
  {
    this.renderView.a(paramInt1, paramInt2);
  }
  
  public void updateAvatarParam(@Nullable String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.renderView.a(paramString, paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.sdk.impl.CmShowRenderViewDelegateImpl
 * JD-Core Version:    0.7.0.1
 */