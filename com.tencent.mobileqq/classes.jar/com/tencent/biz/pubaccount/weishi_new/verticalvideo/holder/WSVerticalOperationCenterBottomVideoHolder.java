package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public class WSVerticalOperationCenterBottomVideoHolder
  extends WSVerticalCommonVideoHolder
{
  private static final int a = ScreenUtil.dip2px(45.0F);
  
  public WSVerticalOperationCenterBottomVideoHolder(ViewGroup paramViewGroup, int paramInt, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramViewGroup, paramInt, paramWSVerticalPageFragment);
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public AbsWSVideoItemView b(int paramInt)
  {
    return new WSVerticalVideoOperationCenterBottomItemView(getContext(), this);
  }
  
  public void c(int paramInt)
  {
    super.c(paramInt);
  }
  
  public int f()
  {
    return 0;
  }
  
  protected boolean g()
  {
    if ((this.d != null) && (TextUtils.equals(this.d.k(), "aio_home_page"))) {
      return false;
    }
    return super.g();
  }
  
  public int i()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalOperationCenterBottomVideoHolder
 * JD-Core Version:    0.7.0.1
 */