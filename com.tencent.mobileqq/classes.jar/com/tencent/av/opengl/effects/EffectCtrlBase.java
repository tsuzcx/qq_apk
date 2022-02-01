package com.tencent.av.opengl.effects;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.av.camera.CameraObserver;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.config.EffectFaceDeviceConfig;
import com.tencent.av.utils.FramePerfData;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.AEKitForQQ;

public abstract class EffectCtrlBase
  extends EffectRenderWrapper
  implements EffectController
{
  private static boolean b = false;
  protected Context a;
  private CameraObserver a;
  
  public EffectCtrlBase()
  {
    this.jdField_a_of_type_ComTencentAvCameraCameraObserver = new EffectCtrlBase.1(this);
  }
  
  private void a(CameraFrame paramCameraFrame, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, short paramShort1, short paramShort2)
  {
    if (paramCameraFrame != null)
    {
      paramArrayOfByte1 = a(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramShort1, paramShort2, (short)paramCameraFrame.jdField_a_of_type_Int, (short)paramCameraFrame.jdField_b_of_type_Int);
      if (paramCameraFrame.jdField_a_of_type_ComTencentAvUtilsFramePerfData != null) {
        paramCameraFrame.jdField_a_of_type_ComTencentAvUtilsFramePerfData.f();
      }
      GraphicRenderMgr.getInstance().sendCameraFrame(paramCameraFrame.jdField_a_of_type_ArrayOfByte, paramCameraFrame.c, paramCameraFrame.jdField_a_of_type_Int, paramCameraFrame.jdField_b_of_type_Int, paramCameraFrame.d, paramCameraFrame.e, paramCameraFrame.jdField_b_of_type_Long, paramCameraFrame.jdField_a_of_type_Boolean, a(), paramArrayOfByte1, paramCameraFrame.f, paramCameraFrame.g);
      paramCameraFrame.b();
    }
  }
  
  public static boolean a(int paramInt, long paramLong)
  {
    if (e()) {
      return true;
    }
    int i = DeviceInfoUtil.a();
    if (i < 17)
    {
      AVLog.printColorLog("EffectRenderWrapper", "isUserEffectFace error  osVersion:" + i);
      return false;
    }
    return a(paramInt, paramLong, 1073741824L);
  }
  
  public static boolean a(int paramInt, long paramLong1, long paramLong2)
  {
    int i = VcSystemInfo.getNumCores();
    if (i < paramInt)
    {
      QLog.w("EffectRenderWrapper", 1, "isSupportOfDevice fail, cpuCount[" + i + " < " + paramInt + "]");
      return false;
    }
    long l = VcSystemInfo.getMaxCpuFreq();
    if ((l != 0L) && (l < paramLong1))
    {
      QLog.w("EffectRenderWrapper", 1, "isSupportOfDevice fail, cpuFrequency[" + l + " < " + paramLong1 + "]");
      return false;
    }
    paramLong1 = DeviceInfoUtil.a();
    if (paramLong1 < paramLong2)
    {
      QLog.w("EffectRenderWrapper", 1, "isSupportOfDevice fail, mem[" + paramLong1 + " < " + paramLong2 + "]");
      return false;
    }
    return true;
  }
  
  public static boolean b()
  {
    return (AEKitForQQ.b()) && (PtvFilterSoLoad.a());
  }
  
  public static boolean c()
  {
    if (Build.VERSION.SDK_INT <= 15) {
      return false;
    }
    return a(2, 1200000L, 1073741824L);
  }
  
  public static boolean d()
  {
    if (b) {
      return true;
    }
    EffectFaceDeviceConfig localEffectFaceDeviceConfig = EffectFaceDeviceConfig.a();
    if ((localEffectFaceDeviceConfig != null) && (localEffectFaceDeviceConfig.f()))
    {
      b = true;
      return true;
    }
    if (!c()) {
      return false;
    }
    if ((a(4, 1400000L, 1073741824L)) || (a(8, 1200000L, 1073741824L))) {}
    for (int i = 1; i == 0; i = 0) {
      return false;
    }
    if ((localEffectFaceDeviceConfig != null) && (!localEffectFaceDeviceConfig.e()))
    {
      AVLog.printErrorLog("EffectRenderWrapper", "isUserEffectFace| model in black list.modle=" + Build.MANUFACTURER + ":" + Build.MODEL);
      return false;
    }
    b = true;
    return true;
  }
  
  public static boolean e()
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
      int i = EffectPendantTools.a(paramRenderParams.a, paramRenderParams.b);
      GraphicRenderMgr.getInstance().setBeautyOrFaceConfig(i, 1);
    }
    if (paramRenderResult != null) {
      a(paramRenderResult.jdField_a_of_type_ComTencentAvOpenglEffectsCameraFrame, paramRenderResult.jdField_a_of_type_ArrayOfByte, paramRenderResult.jdField_b_of_type_ArrayOfByte, paramRenderResult.c, paramRenderResult.jdField_a_of_type_Short, paramRenderResult.jdField_b_of_type_Short);
    }
  }
  
  protected abstract byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, short paramShort1, short paramShort2, short paramShort3, short paramShort4);
  
  protected abstract float[] a();
  
  public void b()
  {
    super.b();
    CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_ComTencentAvCameraCameraObserver);
  }
  
  public void c()
  {
    CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).b(this.jdField_a_of_type_ComTencentAvCameraCameraObserver);
    super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.effects.EffectCtrlBase
 * JD-Core Version:    0.7.0.1
 */