package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class WSVerticalOperationRightVideoHolder
  extends WSVerticalCommonVideoHolder
{
  public WSVerticalOperationRightVideoHolder(ViewGroup paramViewGroup, int paramInt, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramViewGroup, paramInt, paramWSVerticalPageFragment);
  }
  
  public void a(boolean paramBoolean)
  {
    ((WSVerticalVideoOperationRightItemView)this.c).c(paramBoolean);
  }
  
  public AbsWSVideoItemView b(int paramInt)
  {
    return new WSVerticalVideoOperationRightItemView(getContext(), this);
  }
  
  public void b(boolean paramBoolean)
  {
    ((WSVerticalVideoOperationRightItemView)this.c).a(paramBoolean);
  }
  
  public boolean g()
  {
    return false;
  }
  
  public boolean h()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalOperationRightVideoHolder
 * JD-Core Version:    0.7.0.1
 */