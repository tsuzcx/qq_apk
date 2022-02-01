package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.Presenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public class WSVerticalCommonVideoHolder
  extends WSVerticalVideoHolder
{
  private static final int a;
  
  static
  {
    jdField_a_of_type_Int = ScreenUtil.dip2px(45.0F);
  }
  
  public WSVerticalCommonVideoHolder(ViewGroup paramViewGroup, int paramInt, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramViewGroup, 2131560028, paramInt, paramWSVerticalPageFragment);
  }
  
  public FrameLayout a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView instanceof AbsWSVideoItemView)) {
      return ((AbsWSVideoItemView)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView).a();
    }
    return null;
  }
  
  public AbsWSVideoItemView a(int paramInt)
  {
    return new WSVerticalVideoItemView(getContext(), this);
  }
  
  public void a() {}
  
  public void a(boolean paramBoolean) {}
  
  protected boolean a()
  {
    if ((this.jdField_a_of_type_JavaLangObject != null) && (((WSVerticalItemData)this.jdField_a_of_type_JavaLangObject).b())) {
      return true;
    }
    if (((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b()).d()) {
      return false;
    }
    boolean bool = WSExpABTestManager.a().d();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSVerticalCommonVideoHolder.java][isPlayLoop] isLoop:");
    localStringBuilder.append(bool);
    WSLog.e("WS_VIDEO_PLAY_TIME", localStringBuilder.toString());
    return bool;
  }
  
  public int b()
  {
    return jdField_a_of_type_Int;
  }
  
  public void b() {}
  
  public void b(boolean paramBoolean) {}
  
  protected boolean b()
  {
    return true;
  }
  
  public void c() {}
  
  protected boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalCommonVideoHolder
 * JD-Core Version:    0.7.0.1
 */