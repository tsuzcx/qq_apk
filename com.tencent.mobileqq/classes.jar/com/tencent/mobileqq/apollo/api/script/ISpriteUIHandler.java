package com.tencent.mobileqq.apollo.api.script;

import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XListView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/api/script/ISpriteUIHandler;", "", "addOrRemoveMargin", "", "status", "", "whiteHeight", "checkTapHeight", "", "e", "Landroid/view/MotionEvent;", "mContent", "Landroid/widget/RelativeLayout;", "onActionDownloadNotify", "ret", "msgId", "", "onDoubleTap", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "aioType", "friendUin", "", "setAdapter", "listView", "Lcom/tencent/widget/XListView;", "adapter", "Lcom/tencent/mobileqq/activity/aio/ChatAdapter1;", "showOrHidePanel", "showOrHideSprite", "isHide", "isRecord", "from", "showOrHideSurfaceView", "showToast", "text", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface ISpriteUIHandler
{
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(int paramInt1, int paramInt2, long paramLong);
  
  public abstract void a(@NotNull QQAppInterface paramQQAppInterface, int paramInt, @Nullable String paramString);
  
  public abstract void a(@Nullable XListView paramXListView, @Nullable ChatAdapter1 paramChatAdapter1);
  
  public abstract void a(@Nullable String paramString);
  
  public abstract void a(boolean paramBoolean, @Nullable String paramString);
  
  public abstract void a(boolean paramBoolean1, boolean paramBoolean2, @Nullable String paramString);
  
  public abstract boolean a(@NotNull MotionEvent paramMotionEvent, @NotNull RelativeLayout paramRelativeLayout);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.script.ISpriteUIHandler
 * JD-Core Version:    0.7.0.1
 */