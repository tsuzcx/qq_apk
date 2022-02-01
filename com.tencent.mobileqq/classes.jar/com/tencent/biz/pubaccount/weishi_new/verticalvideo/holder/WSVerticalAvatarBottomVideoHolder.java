package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class WSVerticalAvatarBottomVideoHolder
  extends WSVerticalCommonVideoHolder
{
  public WSVerticalAvatarBottomVideoHolder(ViewGroup paramViewGroup, int paramInt, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramViewGroup, paramInt, paramWSVerticalPageFragment);
  }
  
  public AbsWSVideoItemView a(int paramInt)
  {
    return new WSVerticalVideoAvatarBottomItemView(getContext(), this);
  }
  
  public void a(boolean paramBoolean)
  {
    ((WSVerticalVideoOperationRightItemView)this.a).c(paramBoolean);
  }
  
  public void b(boolean paramBoolean)
  {
    ((WSVerticalVideoOperationRightItemView)this.a).a(paramBoolean);
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalAvatarBottomVideoHolder
 * JD-Core Version:    0.7.0.1
 */