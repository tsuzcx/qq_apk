package com.tencent.biz.qqcircle.bizparts;

import android.content.Context;
import android.content.res.Resources;
import android.widget.RelativeLayout;
import com.tencent.biz.qqcircle.events.QCircleDanmakuEvent;
import com.tencent.biz.qqcircle.flutter.event.QCircleFlutterCommentCloseEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.IStatusListener;
import com.tencent.biz.qqcircle.utils.QCircleThemeUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import cooperation.qqcircle.report.QCircleReportHelper;

class QCircleCommentPanelPart$4
  implements QCircleSlidBottomView.IStatusListener
{
  QCircleCommentPanelPart$4(QCircleCommentPanelPart paramQCircleCommentPanelPart) {}
  
  public void a()
  {
    QCircleReportHelper.getInstance().recordPageStartShow(61);
    if (QCircleCommentPanelPart.b(this.a)) {
      QCircleThemeUtil.a(this.a.c(), this.a.g().getResources().getColor(2131168376));
    }
    QCircleCommentPanelPart.a(this.a, 76);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      QCircleCommentPanelPart.a(this.a, 77);
      return;
    }
    if (paramInt == 1) {
      QCircleCommentPanelPart.a(this.a, 76);
    }
  }
  
  public void b()
  {
    QCircleReportHelper localQCircleReportHelper = QCircleReportHelper.getInstance();
    boolean bool;
    if (((this.a.j() instanceof QCircleBaseFragment)) && (((QCircleBaseFragment)this.a.j()).g())) {
      bool = true;
    } else {
      bool = false;
    }
    localQCircleReportHelper.recordPageEndShow(61, bool);
    QCircleCommentPanelPart.c(this.a).setVisibility(8);
    if (QCircleCommentPanelPart.b(this.a)) {
      QCircleThemeUtil.a(this.a.c(), this.a.g().getResources().getColor(2131168376));
    }
    QCircleCommentPanelPart.a(this.a, 77);
    SimpleEventBus.getInstance().dispatchEvent(new QCircleFlutterCommentCloseEvent());
    SimpleEventBus.getInstance().dispatchEvent(new QCircleDanmakuEvent(8, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleCommentPanelPart.4
 * JD-Core Version:    0.7.0.1
 */