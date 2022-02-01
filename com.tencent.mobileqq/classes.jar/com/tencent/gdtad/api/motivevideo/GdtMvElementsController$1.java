package com.tencent.gdtad.api.motivevideo;

import com.tencent.qphone.base.util.QLog;

class GdtMvElementsController$1
  implements GdtMotiveVideoClickCoordinateReportHelper.OnMoveCompleteListener
{
  GdtMvElementsController$1(GdtMvElementsController paramGdtMvElementsController) {}
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GdtMvElementsController.a(this.a, paramInt3);
    GdtMvElementsController.b(this.a, paramInt4);
    if (QLog.isColorLevel()) {
      QLog.i("GdtMvElementsController", 2, "mClickUpX:" + GdtMvElementsController.a(this.a) + ";mClickUpY:" + GdtMvElementsController.b(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvElementsController.1
 * JD-Core Version:    0.7.0.1
 */