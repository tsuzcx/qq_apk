package com.tencent.biz.qqcircle.publish.preview;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.publish.event.QCirclePublishMediaDeleteEvent;
import com.tencent.biz.qqcircle.publish.preview.adapter.QCirclePhotoPeviewerAdapter;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.block.base.QCirclePagerSnapHelper;
import java.util.List;

class QCircleViewerPart$1
  implements DialogInterface.OnClickListener
{
  QCircleViewerPart$1(QCircleViewerPart paramQCircleViewerPart) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    SimpleEventBus.getInstance().dispatchEvent(new QCirclePublishMediaDeleteEvent(QCircleViewerPart.a(this.a)));
    if (QCircleViewerPart.a(this.a) < QCircleViewerPart.b(this.a).size()) {
      QCircleViewerPart.b(this.a).remove(QCircleViewerPart.a(this.a));
    }
    if (QCircleViewerPart.b(this.a).size() == 0)
    {
      this.a.c().finish();
      return;
    }
    QCircleViewerPart.c(this.a).notifyDataSetChanged();
    QCircleViewerPart.d(this.a).b();
    QCircleViewerPart.e(this.a).scrollToPosition(QCircleViewerPart.a(this.a) - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.preview.QCircleViewerPart.1
 * JD-Core Version:    0.7.0.1
 */