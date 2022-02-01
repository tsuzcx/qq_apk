package com.tencent.biz.qqcircle.bizparts;

import com.tencent.biz.qqcircle.share.interfaces.IDialogListener;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qcircle.api.event.QCircleTransActivityLifeEvent;

class QCircleSharePartV2$6
  implements IDialogListener
{
  QCircleSharePartV2$6(QCircleSharePartV2 paramQCircleSharePartV2) {}
  
  public void a()
  {
    SimpleEventBus.getInstance().dispatchEvent(new QCircleTransActivityLifeEvent(0));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    QCircleSharePartV2.a(this.a, paramBoolean1, paramBoolean2);
  }
  
  public void b()
  {
    if (this.a.E() != null)
    {
      this.a.c("rich_media_download_show", null);
      return;
    }
    if (QCircleSharePartV2.c(this.a) != null) {
      QCircleSharePartV2.c(this.a).a("rich_media_download_show", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleSharePartV2.6
 * JD-Core Version:    0.7.0.1
 */