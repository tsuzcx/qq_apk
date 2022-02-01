package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.content.Context;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSPlayerControlBar;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalVideoRelativeLayout;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;

public class WSVerticalItemVideoProgressController
  extends AbsWsUIGroup<WSVerticalItemData>
{
  private SeekBar.OnSeekBarChangeListener jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new WSVerticalItemVideoProgressController.3(this);
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private WSPlayerControlBar jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar;
  private WSVerticalVideoRelativeLayout jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalVideoRelativeLayout;
  private WSVerticalVideoHolder jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder;
  private boolean jdField_a_of_type_Boolean;
  
  public WSVerticalItemVideoProgressController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder, WSVerticalVideoRelativeLayout paramWSVerticalVideoRelativeLayout)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder = paramWSVerticalVideoHolder;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalVideoRelativeLayout = paramWSVerticalVideoRelativeLayout;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder.a != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder.a.a();
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalVideoRelativeLayout == null) {
      return;
    }
    WSVerticalItemVideoProgressController.1 local1 = new WSVerticalItemVideoProgressController.1(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalVideoRelativeLayout.setDispatchTouchEventListener(new WSVerticalItemVideoProgressController.2(this, local1));
  }
  
  public void a() {}
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar.setProgress(paramFloat);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return 2131560158;
  }
  
  public void b()
  {
    a(0.0F);
  }
  
  public void c()
  {
    h();
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar = ((WSPlayerControlBar)a(2131381548));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar.setSeekBarChangeListener(this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener);
    i();
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar.a();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar.b();
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemVideoProgressController
 * JD-Core Version:    0.7.0.1
 */