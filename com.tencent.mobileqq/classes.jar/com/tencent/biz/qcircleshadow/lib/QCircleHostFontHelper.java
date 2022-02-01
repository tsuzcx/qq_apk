package com.tencent.biz.qcircleshadow.lib;

import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import com.etrump.mixlayout.FontSoLoader;
import com.etrump.mixlayout.api.IETDecoration;
import com.etrump.mixlayout.api.IETEngine;
import com.etrump.mixlayout.api.IETFont;
import com.etrump.mixlayout.api.IETSegment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.font.api.IETFontService;

public class QCircleHostFontHelper
{
  public static IETDecoration createDecorationSpace(IETEngine paramIETEngine, String paramString, int paramInt1, int paramInt2, Point paramPoint, int paramInt3, Point[] paramArrayOfPoint, int paramInt4, IETSegment[] paramArrayOfIETSegment, Object[] paramArrayOfObject, boolean paramBoolean1, int paramInt5, boolean paramBoolean2, IETFont paramIETFont, boolean paramBoolean3)
  {
    return ((IETFontService)QRoute.api(IETFontService.class)).createDecorationSpace(paramIETEngine, paramString, paramInt1, paramInt2, paramPoint, paramInt3, paramArrayOfPoint, paramInt4, paramArrayOfIETSegment, paramArrayOfObject, paramBoolean1, paramInt5, paramBoolean2, paramIETFont, paramBoolean3);
  }
  
  public static IETFont createETFont(int paramInt, String paramString, float paramFloat)
  {
    return ((IETFontService)QRoute.api(IETFontService.class)).createETFont(0, null, 0.0F);
  }
  
  public static IETFont createETFont(IETFont paramIETFont)
  {
    return ((IETFontService)QRoute.api(IETFontService.class)).createETFont(paramIETFont);
  }
  
  public static ReplacementSpan createETImageSpan(Drawable paramDrawable)
  {
    return ((IETFontService)QRoute.api(IETFontService.class)).createETImageSpan(paramDrawable);
  }
  
  public static IETSegment createETSegment()
  {
    return ((IETFontService)QRoute.api(IETFontService.class)).createETSegment();
  }
  
  public static IETEngine getETEngineInstance()
  {
    return ((IETFontService)QRoute.api(IETFontService.class)).getETEngineInstance();
  }
  
  public static IETEngine getInstanceForAnimation()
  {
    return ((IETFontService)QRoute.api(IETFontService.class)).getInstanceForAnimation();
  }
  
  public static IETEngine getInstanceForSpace()
  {
    return ((IETFontService)QRoute.api(IETFontService.class)).getInstanceForSpace();
  }
  
  public static boolean isVipFontSoDownloaded()
  {
    return FontSoLoader.a();
  }
  
  public static boolean isVipFontSoLoaded()
  {
    return FontSoLoader.b();
  }
  
  public static boolean loadSoLib()
  {
    return FontSoLoader.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostFontHelper
 * JD-Core Version:    0.7.0.1
 */