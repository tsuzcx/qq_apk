package com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public abstract class NickNameLayoutExtender
{
  protected NickNameExtenderViewBasicAbility ability;
  protected ViewGroup.LayoutParams layoutParams;
  public Context mContext;
  
  public NickNameLayoutExtender(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public abstract NickNameExtenderViewBasicAbility getBasicAbility();
  
  public abstract View getView();
  
  public ViewGroup.LayoutParams getViewLayoutParams()
  {
    return this.layoutParams;
  }
  
  public void updateView(NickNameLayoutProcessor.NickNameLayoutData paramNickNameLayoutData) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameLayoutExtender
 * JD-Core Version:    0.7.0.1
 */