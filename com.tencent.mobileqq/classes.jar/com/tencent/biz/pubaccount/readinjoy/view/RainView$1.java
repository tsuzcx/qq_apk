package com.tencent.biz.pubaccount.readinjoy.view;

import com.tencent.mobileqq.surfaceviewaction.action.Action.OnActionEndListener;
import com.tencent.mobileqq.surfaceviewaction.gl.Sprite;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

class RainView$1
  implements Action.OnActionEndListener
{
  RainView$1(RainView paramRainView, Sprite paramSprite) {}
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRainView.b(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSprite);
    if ((RainView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRainView).incrementAndGet() == RainView.a() * RainView.b() * RainView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRainView).get()) && (RainView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRainView) != null))
    {
      RainView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRainView).set(0);
      RainView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRainView).set(0);
      RainView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRainView).a();
      if (QLog.isColorLevel()) {
        QLog.d("SpriteGLView", 2, "rain animation end");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.RainView.1
 * JD-Core Version:    0.7.0.1
 */