package com.tencent.biz.qqcircle.publish.activity;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.TextView;

class QCirclePublishPicPreviewPart$1
  implements View.OnLongClickListener
{
  QCirclePublishPicPreviewPart$1(QCirclePublishPicPreviewPart paramQCirclePublishPicPreviewPart) {}
  
  public boolean onLongClick(View paramView)
  {
    if (QCirclePublishPicPreviewPart.a(this.a) != null) {
      if (QCirclePublishPicPreviewPart.a(this.a).getVisibility() == 0) {
        QCirclePublishPicPreviewPart.a(this.a).setVisibility(8);
      } else {
        QCirclePublishPicPreviewPart.a(this.a).setVisibility(0);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCirclePublishPicPreviewPart.1
 * JD-Core Version:    0.7.0.1
 */