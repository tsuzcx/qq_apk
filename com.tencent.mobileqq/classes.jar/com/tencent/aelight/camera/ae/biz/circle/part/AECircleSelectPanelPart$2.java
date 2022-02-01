package com.tencent.aelight.camera.ae.biz.circle.part;

import android.view.View;
import com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic;
import com.tencent.aelight.camera.ae.biz.circle.adapter.PicPreviewMoveAdapter.PicOperationListener;
import com.tencent.aelight.camera.ae.biz.circle.event.AECircleSelectChangeEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
import com.tencent.mobileqq.qroute.QRoute;

class AECircleSelectPanelPart$2
  implements PicPreviewMoveAdapter.PicOperationListener
{
  AECircleSelectPanelPart$2(AECircleSelectPanelPart paramAECircleSelectPanelPart) {}
  
  public void a(int paramInt)
  {
    SimpleEventBus.getInstance().dispatchEvent(new AECircleSelectChangeEvent());
    String str;
    if (AECircleSelectPanelPart.a(this.a) != null) {
      str = AECircleSelectPanelPart.b(this.a).i();
    } else {
      str = "";
    }
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(88).setSubActionType(11).setThrActionType(2).setExt6(str));
  }
  
  public void a(View paramView) {}
  
  public void a(View paramView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.part.AECircleSelectPanelPart.2
 * JD-Core Version:    0.7.0.1
 */