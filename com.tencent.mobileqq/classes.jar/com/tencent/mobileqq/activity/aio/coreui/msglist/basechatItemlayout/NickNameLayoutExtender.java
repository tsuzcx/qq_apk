package com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public abstract class NickNameLayoutExtender
{
  protected BaseChatItemLayoutViewBasicAbility ability;
  protected ViewGroup.LayoutParams layoutParams;
  protected Context mContext;
  
  public NickNameLayoutExtender(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public abstract BaseChatItemLayoutViewBasicAbility getBasicAbility();
  
  public abstract View getView();
  
  public ViewGroup.LayoutParams getViewLayoutParams()
  {
    return this.layoutParams;
  }
  
  public void updateView(NickNameChatItemLayoutProcessor.NickNameLayoutData paramNickNameLayoutData) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameLayoutExtender
 * JD-Core Version:    0.7.0.1
 */