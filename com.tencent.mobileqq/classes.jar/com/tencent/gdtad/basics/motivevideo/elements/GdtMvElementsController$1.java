package com.tencent.gdtad.basics.motivevideo.elements;

import com.tencent.gdtad.basics.motivevideo.report.GdtMotiveVideoClickCoordinateReportHelper.OnMoveCompleteListener;
import com.tencent.qphone.base.util.QLog;

class GdtMvElementsController$1
  implements GdtMotiveVideoClickCoordinateReportHelper.OnMoveCompleteListener
{
  GdtMvElementsController$1(GdtMvElementsController paramGdtMvElementsController) {}
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GdtMvElementsController.a(this.a, paramInt3);
    GdtMvElementsController.b(this.a, paramInt4);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mClickUpX:");
      localStringBuilder.append(GdtMvElementsController.a(this.a));
      localStringBuilder.append(";mClickUpY:");
      localStringBuilder.append(GdtMvElementsController.b(this.a));
      QLog.i("GdtMvElementsController", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.elements.GdtMvElementsController.1
 * JD-Core Version:    0.7.0.1
 */