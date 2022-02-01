package com.tencent.av.opengl.effects;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.aelight.camera.download.api.IAEKitForQQ;
import com.tencent.av.AVLog;
import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.av.camera.CameraObserver;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.api.IGraphicRender;
import com.tencent.av.opengl.config.EffectFaceDeviceConfig;
import com.tencent.av.utils.FramePerfData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

public abstract class EffectCtrlBase
  extends EffectRenderWrapper
  implements EffectController
{
  private static boolean h = false;
  protected Context a;
  private CameraObserver j = new EffectCtrlBase.1(this);
  
  private void a(CameraFrame paramCameraFrame, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, short paramShort1, short paramShort2)
  {
    if (paramCameraFrame != null)
    {
      paramArrayOfByte1 = a(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramShort1, paramShort2, (short)paramCameraFrame.b, (short)paramCameraFrame.c);
      if (paramCameraFrame.k != null) {
        paramCameraFrame.k.g();
      }
      GraphicRenderMgr.getInstance().sendCameraFrame(paramCameraFrame.a, paramCameraFrame.d, paramCameraFrame.b, paramCameraFrame.c, paramCameraFrame.e, paramCameraFrame.f, paramCameraFrame.i, paramCameraFrame.g, i(), paramArrayOfByte1, paramCameraFrame.l, paramCameraFrame.m);
      paramCameraFrame.e();
    }
  }
  
  public static boolean a(int paramInt, long paramLong)
  {
    if (f()) {
      return true;
    }
    int i = DeviceInfoUtil.d();
    if (i < 17)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isUserEffectFace error  osVersion:");
      localStringBuilder.append(i);
      AVLog.printColorLog("EffectRenderWrapper", localStringBuilder.toString());
      return false;
    }
    return EffectCtrlUtils.a(paramInt, paramLong, 1073741824L);
  }
  
  public static boolean c()
  {
    return (((IAEKitForQQ)QRoute.api(IAEKitForQQ.class)).isSupported()) && (PtvFilterSoLoad.a());
  }
  
  public static boolean d()
  {
    if (Build.VERSION.SDK_INT <= 15) {
      return false;
    }
    return EffectCtrlUtils.a(2, 1200000L, 1073741824L);
  }
  
  public static boolean e()
  {
    if (h) {
      return true;
    }
    Object localObject = EffectFaceDeviceConfig.g();
    if ((localObject != null) && (((EffectFaceDeviceConfig)localObject).d()))
    {
      h = true;
      return true;
    }
    if (!d()) {
      return false;
    }
    int i;
    if ((!EffectCtrlUtils.a(4, 1400000L, 1073741824L)) && (!EffectCtrlUtils.a(8, 1200000L, 1073741824L))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0) {
      return false;
    }
    if ((localObject != null) && (!((EffectFaceDeviceConfig)localObject).c()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isUserEffectFace| model in black list.modle=");
      ((StringBuilder)localObject).append(Build.MANUFACTURER);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(Build.MODEL);
      AVLog.printErrorLog("EffectRenderWrapper", ((StringBuilder)localObject).toString());
      return false;
    }
    h = true;
    return true;
  }
  
  public static boolean f()
  {
    String str = Build.MODEL;
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return str.equals("MI 5");
  }
  
  protected void a(RenderParams paramRenderParams, RenderResult paramRenderResult)
  {
    if (paramRenderParams != null)
    {
      int i = EffectPendantTools.a(paramRenderParams.c, paramRenderParams.f);
      GraphicRenderMgr.getInstance().setBeautyOrFaceConfig(i, 1);
    }
    if (paramRenderResult != null) {
      a(paramRenderResult.a, paramRenderResult.b, paramRenderResult.c, paramRenderResult.d, paramRenderResult.e, paramRenderResult.f);
    }
  }
  
  protected abstract byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, short paramShort1, short paramShort2, short paramShort3, short paramShort4);
  
  public void g()
  {
    super.g();
    CameraUtils.a(this.a).addObserver(this.j);
  }
  
  public void h()
  {
    CameraUtils.a(this.a).deleteObserver(this.j);
    super.h();
  }
  
  protected abstract float[] i();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.EffectCtrlBase
 * JD-Core Version:    0.7.0.1
 */