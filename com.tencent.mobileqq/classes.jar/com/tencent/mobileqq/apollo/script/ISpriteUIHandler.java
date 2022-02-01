package com.tencent.mobileqq.apollo.script;

import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.widget.XListAdapter;
import com.tencent.widget.XListView;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/script/ISpriteUIHandler;", "Lcom/tencent/mobileqq/apollo/script/ISpriteTaskStatusCallback;", "addOrRemoveMargin", "", "status", "", "whiteHeight", "checkTapHeight", "", "e", "Landroid/view/MotionEvent;", "mContent", "Landroid/widget/RelativeLayout;", "onActionDownloadNotify", "ret", "msgId", "", "onDoubleTap", "app", "Lmqq/app/AppRuntime;", "aioType", "friendUin", "", "setAdapter", "listView", "Lcom/tencent/widget/XListView;", "adapter", "Lcom/tencent/widget/XListAdapter;", "showOrHidePanel", "showOrHideSprite", "isHide", "isRecord", "from", "showOrHideSurfaceView", "showToast", "text", "cmshow_api_release"}, k=1, mv={1, 1, 16})
public abstract interface ISpriteUIHandler
  extends ISpriteTaskStatusCallback
{
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(int paramInt1, int paramInt2, long paramLong);
  
  public abstract void a(@Nullable XListView paramXListView, @Nullable XListAdapter paramXListAdapter);
  
  public abstract void a(@Nullable String paramString);
  
  public abstract void a(@NotNull AppRuntime paramAppRuntime, int paramInt, @Nullable String paramString);
  
  public abstract void a(boolean paramBoolean, @Nullable String paramString);
  
  public abstract void a(boolean paramBoolean1, boolean paramBoolean2, @Nullable String paramString);
  
  public abstract boolean a(@NotNull MotionEvent paramMotionEvent, @NotNull RelativeLayout paramRelativeLayout);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.ISpriteUIHandler
 * JD-Core Version:    0.7.0.1
 */