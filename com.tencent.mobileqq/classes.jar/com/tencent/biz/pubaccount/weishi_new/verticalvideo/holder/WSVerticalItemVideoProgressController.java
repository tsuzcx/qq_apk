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
    paramContext = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalVideoHolder;
    if ((paramContext != null) && (paramContext.a != null)) {
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
  
  protected void a() {}
  
  public void a(float paramFloat)
  {
    WSPlayerControlBar localWSPlayerControlBar = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar;
    if (localWSPlayerControlBar != null) {
      localWSPlayerControlBar.setProgress(paramFloat);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected int b()
  {
    return 2131560043;
  }
  
  protected void b()
  {
    a(0.0F);
  }
  
  protected void c()
  {
    h();
  }
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar = ((WSPlayerControlBar)a(2131380784));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar.setSeekBarChangeListener(this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener);
    i();
  }
  
  public void f()
  {
    WSPlayerControlBar localWSPlayerControlBar = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar;
    if (localWSPlayerControlBar != null) {
      localWSPlayerControlBar.a();
    }
  }
  
  public void g()
  {
    WSPlayerControlBar localWSPlayerControlBar = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar;
    if (localWSPlayerControlBar != null) {
      localWSPlayerControlBar.b();
    }
  }
  
  public void h()
  {
    WSPlayerControlBar localWSPlayerControlBar = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSPlayerControlBar;
    if (localWSPlayerControlBar != null) {
      localWSPlayerControlBar.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemVideoProgressController
 * JD-Core Version:    0.7.0.1
 */