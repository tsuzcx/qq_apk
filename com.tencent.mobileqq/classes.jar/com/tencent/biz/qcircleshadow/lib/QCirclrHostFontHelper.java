package com.tencent.biz.qcircleshadow.lib;

import com.tencent.biz.qcircleshadow.lib.listener.QCircleFullTypeResult;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleTrueTypeResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.font.IFontManager;

public class QCirclrHostFontHelper
{
  public static String getFullTypeFont(int paramInt, String paramString1, String paramString2, QCircleFullTypeResult paramQCircleFullTypeResult)
  {
    return ((IFontManager)QRoute.api(IFontManager.class)).getFullTypeFont(paramInt, paramString1, paramString2, new QCirclrHostFontHelper.1(paramQCircleFullTypeResult));
  }
  
  public static String getTrueTypeFont(int paramInt, String paramString1, String paramString2, boolean paramBoolean, QCircleTrueTypeResult paramQCircleTrueTypeResult)
  {
    return ((IFontManager)QRoute.api(IFontManager.class)).getTrueTypeFont(paramInt, paramString1, paramString2, paramBoolean, new QCirclrHostFontHelper.2(paramQCircleTrueTypeResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCirclrHostFontHelper
 * JD-Core Version:    0.7.0.1
 */