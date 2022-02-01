package com.tencent.biz.qcircleshadow.lib;

import com.tencent.mobileqq.qcircle.api.IQCircleImagePreviewUtil;
import com.tencent.mobileqq.qroute.QRoute;

public class QCircleHostImagePreviewHelper
{
  public static int[] getTargetSize(int paramInt1, int paramInt2)
  {
    return ((IQCircleImagePreviewUtil)QRoute.api(IQCircleImagePreviewUtil.class)).getTargetWidthAndHeight(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostImagePreviewHelper
 * JD-Core Version:    0.7.0.1
 */