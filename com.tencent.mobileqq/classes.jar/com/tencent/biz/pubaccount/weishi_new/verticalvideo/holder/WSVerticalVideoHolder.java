package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stSimpleMetaFeed;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.baseui.IWSItemView;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.player.IWSPlayerUIDelegate;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerUtils;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerUtils.PlayerLayoutParams;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.Presenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public abstract class WSVerticalVideoHolder
  extends WSVerticalBaseHolder<WSVerticalItemData>
{
  private static final int a;
  public IWSPlayerUIDelegate a;
  public WSPlayerParam a;
  
  static
  {
    jdField_a_of_type_Int = ScreenUtil.dip2px(51.0F);
  }
  
  public WSVerticalVideoHolder(ViewGroup paramViewGroup, int paramInt1, int paramInt2, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramViewGroup, paramInt1, paramInt2, paramWSVerticalPageFragment);
  }
  
  private View a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView instanceof AbsWSVideoItemView)) {
      return ((AbsWSVideoItemView)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView).a();
    }
    return null;
  }
  
  private View b()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView instanceof AbsWSVideoItemView)) {
      return ((AbsWSVideoItemView)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView).b();
    }
    return null;
  }
  
  private void b(int paramInt)
  {
    View localView = b();
    if (localView == null) {
      return;
    }
    if ((paramInt == 0) || (paramInt == 1) || (paramInt == 2))
    {
      localView.setVisibility(0);
      return;
    }
    localView.setVisibility(8);
  }
  
  private int c(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    WSPlayerUtils.PlayerLayoutParams localPlayerLayoutParams = new WSPlayerUtils.PlayerLayoutParams(a(), a(), paramstSimpleMetaFeed.video.width, paramstSimpleMetaFeed.video.height, b(), a());
    int i = a(paramstSimpleMetaFeed);
    WSLog.e("WSVerticalVideoHolder", "[WSVerticalVideoHolder.java][calculatePlayerLayoutRatio] videoScaleType:" + i + ", " + localPlayerLayoutParams.toString());
    switch (i)
    {
    case 0: 
    default: 
      return WSPlayerUtils.b(localPlayerLayoutParams);
    case -1: 
      return WSPlayerUtils.a(localPlayerLayoutParams);
    case 1: 
      return WSPlayerUtils.b(localPlayerLayoutParams);
    }
    return WSPlayerUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.getActivity(), localPlayerLayoutParams, new WSVerticalVideoHolder.1(this));
  }
  
  public int a()
  {
    return jdField_a_of_type_Int;
  }
  
  public int a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    return WSExpABTestManager.a().b();
  }
  
  public abstract void a();
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a() != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a().f(a());
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a().e(a());
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(b());
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(c());
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView.b(paramInt);
    }
  }
  
  public void a(WSVerticalItemData paramWSVerticalItemData)
  {
    super.a(paramWSVerticalItemData);
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView.a(paramWSVerticalItemData);
    }
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public int b()
  {
    return ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b()).b();
  }
  
  public int b(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    return c(paramstSimpleMetaFeed);
  }
  
  public abstract void b();
  
  protected boolean b()
  {
    return true;
  }
  
  public abstract void c();
  
  protected boolean c()
  {
    return true;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView.c();
    }
  }
  
  public void h()
  {
    super.h();
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder
 * JD-Core Version:    0.7.0.1
 */