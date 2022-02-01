package com.tencent.av.opengl;

import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.avcore.jni.render.RenderProxy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.download.AEResUtil;

public class GraphicRenderMgr
  extends RenderProxy
{
  private static final String TAG = "GraphicRenderMgr";
  public static boolean ptuSoVersion = false;
  private static volatile GraphicRenderMgr sGraphicRenderMgr;
  public static boolean soloaded = false;
  public static boolean soloadedPTV = false;
  public int decoderPtrRef = 0;
  
  private GraphicRenderMgr()
  {
    loadSo();
  }
  
  public static GraphicRenderMgr getInstance()
  {
    if (sGraphicRenderMgr == null) {}
    try
    {
      if (sGraphicRenderMgr == null) {
        sGraphicRenderMgr = new GraphicRenderMgr();
      }
      return sGraphicRenderMgr;
    }
    finally {}
  }
  
  public static void loadPtuSO()
  {
    if (EffectsRenderController.b())
    {
      soloadedPTV = AEResUtil.e();
      ptuSoVersion = AEResUtil.d();
    }
    if (QLog.isColorLevel()) {
      QLog.w("GraphicRenderMgr", 1, "loadPtuSO, soloadedPTV[" + soloadedPTV + "], ptuSoVersion[" + ptuSoVersion + "], isSupported[" + EffectsRenderController.b() + "]");
    }
  }
  
  public static boolean loadSo()
  {
    if (!soloaded) {}
    try
    {
      long l = AudioHelper.b();
      QLog.w("GraphicRenderMgr", 1, "loadSo, seq[" + l + "]");
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      SoLoadUtil.a(localBaseApplication, "c++_shared", 0, false);
      SoLoadUtil.a(localBaseApplication, "xplatform", 0, false);
      AVSoUtils.b(l, localBaseApplication, "SDKCommon", true);
      AVSoUtils.a(l, localBaseApplication, "SDKCommon", true);
      AVSoUtils.b(l, localBaseApplication, "qav_graphics", true);
      AVSoUtils.a(l, localBaseApplication, "qav_graphics", true);
      soloaded = true;
      return soloaded;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
        QLog.w("GraphicRenderMgr", 1, "loadSo UnsatisfiedLinkError", localUnsatisfiedLinkError);
      }
    }
  }
  
  public void setGlRender(String paramString, YUVTexture paramYUVTexture)
  {
    if (paramYUVTexture == null) {}
    for (paramYUVTexture = null;; paramYUVTexture = paramYUVTexture.a())
    {
      setGlRender2Native(paramString, paramYUVTexture);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.GraphicRenderMgr
 * JD-Core Version:    0.7.0.1
 */