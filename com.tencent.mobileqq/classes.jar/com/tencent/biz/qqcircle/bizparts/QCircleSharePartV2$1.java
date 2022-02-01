package com.tencent.biz.qqcircle.bizparts;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.qqcircle.flutter.event.QCircleFlutterShareCloseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;

class QCircleSharePartV2$1
  implements DialogInterface.OnDismissListener
{
  QCircleSharePartV2$1(QCircleSharePartV2 paramQCircleSharePartV2) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    QCircleSharePartV2.a(this.a);
    QCircleSharePartV2.b(this.a);
    SimpleEventBus.getInstance().dispatchEvent(new QCircleFlutterShareCloseEvent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleSharePartV2.1
 * JD-Core Version:    0.7.0.1
 */