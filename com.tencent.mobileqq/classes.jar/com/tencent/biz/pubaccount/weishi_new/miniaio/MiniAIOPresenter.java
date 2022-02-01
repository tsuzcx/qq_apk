package com.tencent.biz.pubaccount.weishi_new.miniaio;

import android.view.View;
import com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;

public class MiniAIOPresenter
{
  private View a;
  private int b = 0;
  private boolean c = true;
  
  private IMiniMsgUnreadCallback c()
  {
    return new MiniAIOPresenter.1(this);
  }
  
  public MiniMsgUserParam a()
  {
    MiniMsgUserParam localMiniMsgUserParam = new MiniMsgUserParam();
    localMiniMsgUserParam.businessName = 6;
    localMiniMsgUserParam.accessType = 2;
    localMiniMsgUserParam.filterMsgType = 0;
    localMiniMsgUserParam.unreadCallback = c();
    return localMiniMsgUserParam;
  }
  
  public void a(View paramView)
  {
    this.a = paramView;
  }
  
  public void a(MiniMsgUser paramMiniMsgUser)
  {
    if ((this.b > 0) && (paramMiniMsgUser != null))
    {
      View localView = this.a;
      if (localView != null)
      {
        this.b = 0;
        localView.setVisibility(4);
        paramMiniMsgUser.onClick(this.a);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public int b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.miniaio.MiniAIOPresenter
 * JD-Core Version:    0.7.0.1
 */