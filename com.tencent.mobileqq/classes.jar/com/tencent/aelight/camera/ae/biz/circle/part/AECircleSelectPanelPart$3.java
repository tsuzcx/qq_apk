package com.tencent.aelight.camera.ae.biz.circle.part;

import com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic;
import com.tencent.aelight.camera.ae.biz.circle.event.AECircleSelectChangeEvent;
import com.tencent.aelight.camera.ae.biz.circle.helper.PicDragHelperCallback.DragListener;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class AECircleSelectPanelPart$3
  implements PicDragHelperCallback.DragListener
{
  AECircleSelectPanelPart$3(AECircleSelectPanelPart paramAECircleSelectPanelPart) {}
  
  public void a() {}
  
  public void a(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDragFinish  isInside = ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("AECircleSelectPanelPart", 1, ((StringBuilder)localObject).toString());
    localObject = new AECircleSelectChangeEvent();
    ((AECircleSelectChangeEvent)localObject).setImageDragEventFlag(true);
    SimpleEventBus.getInstance().dispatchEvent((SimpleBaseEvent)localObject);
    if (AECircleSelectPanelPart.c(this.a) != null) {
      localObject = AECircleSelectPanelPart.d(this.a).i();
    } else {
      localObject = "";
    }
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(88).setSubActionType(10).setThrActionType(1).setExt6((String)localObject));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.part.AECircleSelectPanelPart.3
 * JD-Core Version:    0.7.0.1
 */