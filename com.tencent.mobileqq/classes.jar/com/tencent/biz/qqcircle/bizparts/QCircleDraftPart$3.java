package com.tencent.biz.qqcircle.bizparts;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.biz.qqcircle.widgets.QCircleDraftRecyclerView;

class QCircleDraftPart$3
  implements DialogInterface.OnClickListener
{
  QCircleDraftPart$3(QCircleDraftPart paramQCircleDraftPart) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if (QCircleDraftPart.a(this.a) != null)
      {
        QCircleDraftPart.a(this.a).b(QCircleDraftPart.b(this.a));
        QCircleDraftPart.a(this.a).a();
      }
      if (QCircleDraftPart.b(this.a) != null)
      {
        QCircleDraftPart.b(this.a).setEnabled(false);
        QCircleDraftPart.b(this.a).setText(this.a.g().getString(2131895785));
      }
      if ((QCircleDraftPart.c(this.a) != null) && (QCircleDraftPart.c(this.a).isChecked())) {
        QCircleDraftPart.c(this.a).setChecked(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleDraftPart.3
 * JD-Core Version:    0.7.0.1
 */