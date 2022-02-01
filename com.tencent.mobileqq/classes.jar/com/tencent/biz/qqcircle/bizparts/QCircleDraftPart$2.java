package com.tencent.biz.qqcircle.bizparts;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqcircle.widgets.QCircleDraftRecyclerView;

class QCircleDraftPart$2
  implements DialogInterface.OnClickListener
{
  QCircleDraftPart$2(QCircleDraftPart paramQCircleDraftPart, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((paramInt == 1) && (QCircleDraftPart.a(this.b) != null)) {
      QCircleDraftPart.a(this.b).a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleDraftPart.2
 * JD-Core Version:    0.7.0.1
 */