package com.tencent.aelight.camera.ae.biz.circle.part;

import android.view.View;
import com.tencent.aelight.camera.ae.biz.circle.adapter.PicPreviewMoveAdapter.PicOperationListener;
import com.tencent.aelight.camera.ae.biz.circle.event.AECircleSelectChangeEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;

class AECircleSelectPanelPart$2
  implements PicPreviewMoveAdapter.PicOperationListener
{
  AECircleSelectPanelPart$2(AECircleSelectPanelPart paramAECircleSelectPanelPart) {}
  
  public void a(int paramInt)
  {
    SimpleEventBus.getInstance().dispatchEvent(new AECircleSelectChangeEvent());
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 88, 11, 2);
  }
  
  public void a(View paramView) {}
  
  public void a(View paramView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.part.AECircleSelectPanelPart.2
 * JD-Core Version:    0.7.0.1
 */