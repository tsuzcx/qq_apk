package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public class WSVerticalOperationCenterBottomVideoHolder
  extends WSVerticalCommonVideoHolder
{
  private static final int a;
  
  static
  {
    jdField_a_of_type_Int = ScreenUtil.dip2px(45.0F);
  }
  
  public WSVerticalOperationCenterBottomVideoHolder(ViewGroup paramViewGroup, int paramInt, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramViewGroup, paramInt, paramWSVerticalPageFragment);
  }
  
  public int a()
  {
    return 0;
  }
  
  public AbsWSVideoItemView a(int paramInt)
  {
    return new WSVerticalVideoOperationCenterBottomItemView(a(), this);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public int b()
  {
    return jdField_a_of_type_Int;
  }
  
  protected boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null) && (TextUtils.equals(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), "aio_home_page"))) {
      return false;
    }
    return super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalOperationCenterBottomVideoHolder
 * JD-Core Version:    0.7.0.1
 */