package com.tencent.mobileqq.apollo.api.sdk;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/api/sdk/ICmShowRenderViewDelegate;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "bringToFront", "", "changeSpriteModel", "uin", "", "mode", "", "destroy", "disableTouchEvent", "disable", "", "disposeAvatar", "uins", "", "all", "getCmShowMode", "getHeight", "getParent", "Landroid/view/ViewParent;", "getView", "Landroid/view/View;", "getWidth", "hideBubble", "initAvatar", "selfUin", "friendUin", "scale", "", "seq", "extraBundle", "Landroid/os/Bundle;", "initView", "iRenderViewListener", "Lcom/tencent/mobileqq/apollo/api/sdk/IRenderViewListener;", "traceReportId", "pause", "playAction", "playActionConfig", "Lcom/tencent/mobileqq/apollo/api/sdk/PlayActionConfig;", "resume", "setTouchEventRect", "boxRect", "Landroid/graphics/Rect;", "leftRect", "leftUin", "rightRect", "rightUin", "showBubble", "bubbleText", "direction", "bubbleStyle", "showOrHideAvatar", "show", "stopAction", "actionId", "actionSeqId", "updateAvatarParam", "x", "y", "rotate", "Constant", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface ICmShowRenderViewDelegate
  extends QRouteApi
{
  public static final int CMSHOW_BUBBLE_STYLE_DEFAULT = 0;
  public static final int CMSHOW_BUBBLE_STYLE_QZONE = 1;
  public static final int CMSHOW_MODE_TYPE_2D = 1;
  public static final int CMSHOW_MODE_TYPE_3D = 2;
  public static final int CMSHOW_MODE_TYPE_NONE = 0;
  public static final int CMSHO_BUBBLE_DIRECTION_LEFT = -1;
  public static final int CMSHO_BUBBLE_DIRECTION_RIGHT = 1;
  public static final ICmShowRenderViewDelegate.Constant Constant = ICmShowRenderViewDelegate.Constant.a;
  public static final int TRACE_REPORT_ID_QZONE = 113;
  public static final int TRACE_REPORT_ID_VAS = 118;
  
  public abstract void bringToFront();
  
  public abstract void changeSpriteModel(@NotNull String paramString, int paramInt);
  
  public abstract void destroy();
  
  public abstract void disableTouchEvent(boolean paramBoolean);
  
  public abstract void disposeAvatar(@Nullable List<String> paramList, boolean paramBoolean);
  
  public abstract int getCmShowMode(@Nullable String paramString);
  
  public abstract int getHeight();
  
  @NotNull
  public abstract ViewParent getParent();
  
  @NotNull
  public abstract View getView();
  
  public abstract int getWidth();
  
  public abstract void hideBubble(@Nullable String paramString);
  
  public abstract void initAvatar(@Nullable String paramString1, @Nullable String paramString2, float paramFloat, int paramInt, @Nullable Bundle paramBundle);
  
  public abstract void initView(@Nullable IRenderViewListener paramIRenderViewListener, @Nullable String paramString1, @Nullable String paramString2, int paramInt);
  
  public abstract void pause();
  
  public abstract void playAction(@Nullable PlayActionConfig paramPlayActionConfig);
  
  public abstract void resume();
  
  public abstract void setTouchEventRect(@NotNull Rect paramRect1, @NotNull Rect paramRect2, @Nullable String paramString1, @NotNull Rect paramRect3, @Nullable String paramString2);
  
  public abstract void showBubble(@Nullable String paramString1, @Nullable String paramString2, int paramInt1, int paramInt2);
  
  public abstract void showOrHideAvatar(@Nullable String paramString, boolean paramBoolean);
  
  public abstract void stopAction(int paramInt1, int paramInt2);
  
  public abstract void updateAvatarParam(@Nullable String paramString, int paramInt1, int paramInt2, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.sdk.ICmShowRenderViewDelegate
 * JD-Core Version:    0.7.0.1
 */