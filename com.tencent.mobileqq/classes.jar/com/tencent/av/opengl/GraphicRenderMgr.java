package com.tencent.av.opengl;

import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.av.opengl.api.IGraphicRender;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.temp.IExternalUtilsApi;
import com.tencent.av.utils.AVSoUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class GraphicRenderMgr
{
  private static final String TAG = "GraphicRenderMgr";
  public static boolean ptuSoVersion = false;
  private static volatile IGraphicRender sGraphicRender;
  public static boolean soloadedPTV = false;
  
  public static IGraphicRender getInstance()
  {
    if (sGraphicRender == null) {
      try
      {
        if (sGraphicRender == null)
        {
          sGraphicRender = (IGraphicRender)QRoute.api(IGraphicRender.class);
          AVSoUtils.d();
        }
      }
      finally {}
    }
    return sGraphicRender;
  }
  
  public static void loadPtuSO()
  {
    if (((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).isEnableAEModuleManager())
    {
      soloadedPTV = ((IAEResUtil)QRoute.api(IAEResUtil.class)).loadAEBaseSo();
      ptuSoVersion = ((IAEResUtil)QRoute.api(IAEResUtil.class)).isFilterFaceSoVersionOK();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadPtuSO, soloadedPTV[");
      localStringBuilder.append(soloadedPTV);
      localStringBuilder.append("], ptuSoVersion[");
      localStringBuilder.append(ptuSoVersion);
      localStringBuilder.append("], isSupported[");
      localStringBuilder.append(((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).isEnableAEModuleManager());
      localStringBuilder.append("]");
      QLog.w("GraphicRenderMgr", 1, localStringBuilder.toString());
    }
  }
  
  public static void setGlRender(String paramString, YUVTexture paramYUVTexture)
  {
    IGraphicRender localIGraphicRender = getInstance();
    if (paramYUVTexture == null) {
      paramYUVTexture = null;
    } else {
      paramYUVTexture = paramYUVTexture.a();
    }
    localIGraphicRender.setGlRender2Native(paramString, paramYUVTexture);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.GraphicRenderMgr
 * JD-Core Version:    0.7.0.1
 */