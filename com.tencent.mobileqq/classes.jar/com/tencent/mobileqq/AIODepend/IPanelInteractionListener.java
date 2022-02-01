package com.tencent.mobileqq.AIODepend;

import android.view.ViewGroup;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.emosm.IAIOEmoticonUIHelper;
import com.tencent.mobileqq.popanim.PopOutAnimConfig;
import com.tencent.mobileqq.qqemoticon.api.IPanelListener;

public abstract interface IPanelInteractionListener
  extends IPanelListener
{
  public abstract BaseAIOContext getAIOContext();
  
  public abstract IAIOEmoticonUIHelper getAIOEmoticonUIHelper();
  
  public abstract EditText getAIOInput();
  
  public abstract ViewGroup getAIORootView();
  
  public abstract Object getBaseChatPie();
  
  public abstract String getCurFriendUin();
  
  public abstract int getCurType();
  
  public abstract int getPanelChatPieType();
  
  public abstract ViewGroup getPanelicons();
  
  public abstract PopOutAnimConfig getPopOutAnimConfig();
  
  public abstract void removeEmoticonGuideBubble();
  
  public abstract void setPaneliconsInterceptListener(IPanelInteractionListener.InterceptListener paramInterceptListener);
  
  public abstract void setPaneliconsShowRed(int paramInt, boolean paramBoolean);
  
  public abstract void stickerEditMode(boolean paramBoolean);
  
  public abstract void stopAnimationConatiner();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.AIODepend.IPanelInteractionListener
 * JD-Core Version:    0.7.0.1
 */