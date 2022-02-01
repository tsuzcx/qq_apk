package com.tencent.av.camera;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.os.SystemClock;
import com.tencent.av.AVLog;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.api.IGraphicRender;
import com.tencent.av.opengl.config.EffectFaceDeviceConfig;
import com.tencent.avcore.config.CameraConfigHelper;
import com.tencent.avcore.jni.render.FocusDetectCallback;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class VcCamera
  extends AndroidCamera
  implements FocusDetectCallback
{
  private Camera.AutoFocusCallback a;
  
  public VcCamera(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidHardwareCamera$AutoFocusCallback = new VcCamera.1(this);
  }
  
  @TargetApi(9)
  private void a(Camera.Parameters paramParameters, boolean paramBoolean)
  {
    if (paramParameters == null)
    {
      AVLog.printColorLog("AndroidCamera", "parameters null, do nothing about focus config");
      return;
    }
    List localList = paramParameters.getSupportedFocusModes();
    if (localList == null)
    {
      AVLog.printColorLog("AndroidCamera", "getSupportedFocusModes empty");
      return;
    }
    EffectFaceDeviceConfig localEffectFaceDeviceConfig = EffectFaceDeviceConfig.a();
    boolean bool;
    if ((localEffectFaceDeviceConfig != null) && (localEffectFaceDeviceConfig.e())) {
      bool = true;
    } else {
      bool = false;
    }
    AVLog.printColorLog("AndroidCamera", String.format("enableAutoFocus, isUserSelfFocusDev[%s], enable[%s]", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) }));
    if (bool)
    {
      a(paramBoolean, localList);
      return;
    }
    a(paramBoolean, localList, paramParameters);
  }
  
  private void a(boolean paramBoolean, List<String> paramList)
  {
    if (!paramList.contains("auto")) {
      return;
    }
    if (paramBoolean)
    {
      GraphicRenderMgr.getInstance().setFocusDetectCallback(this);
      GraphicRenderMgr.getInstance().setFocusConfig(true, SystemClock.elapsedRealtime(), 111, 3000);
      return;
    }
    GraphicRenderMgr.getInstance().setFocusDetectCallback(null);
    GraphicRenderMgr.getInstance().setFocusConfig(false, SystemClock.elapsedRealtime(), 111, 3000);
  }
  
  private void a(boolean paramBoolean, List<String> paramList, Camera.Parameters paramParameters)
  {
    if ((paramBoolean) && (this.h >= 9) && (paramList.contains("continuous-video"))) {
      paramParameters.setFocusMode("continuous-video");
    }
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.setParameters(paramParameters);
      return;
    }
    catch (Exception paramList) {}
  }
  
  protected void a(long paramLong, int paramInt1, int paramInt2)
  {
    super.a(paramLong, paramInt1, paramInt2);
    if (this.jdField_a_of_type_AndroidHardwareCamera != null)
    {
      Object localObject = null;
      try
      {
        Camera.Parameters localParameters = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
        localObject = localParameters;
      }
      catch (Exception localException)
      {
        QLog.d("AndroidCamera", 2, "setCameraPara exception", localException);
      }
      if (localObject != null)
      {
        CameraConfigHelper.getInstance(BaseApplication.getContext()).setCameraParameters(localObject.flatten());
        a(localObject, true);
        return;
      }
      if (QLog.isDevelopLevel()) {
        QLog.w("AndroidCamera", 1, "setCameraPara, parameters[null]");
      }
    }
    else if (QLog.isDevelopLevel())
    {
      QLog.w("AndroidCamera", 1, "setCameraPara, camera[false]");
    }
  }
  
  public boolean c(long paramLong)
  {
    try
    {
      boolean bool = b;
      if (bool)
      {
        Object localObject3 = null;
        Object localObject1;
        try
        {
          localObject1 = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
        }
        catch (Exception localException)
        {
          localObject1 = localObject3;
          if (QLog.isColorLevel())
          {
            QLog.e("AndroidCamera", 2, "closeCamera", localException);
            localObject1 = localObject3;
          }
        }
        a((Camera.Parameters)localObject1, false);
      }
      bool = super.c(paramLong);
      return bool;
    }
    finally {}
  }
  
  public int h()
  {
    return a(this.i, this.jdField_a_of_type_AndroidHardwareCamera).c;
  }
  
  public void onFocusDetectResult(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidHardwareCamera == null)
      {
        AVLog.printColorLog("AndroidCamera", "camera null, return");
        return;
      }
      GraphicRenderMgr.getInstance().setIsFocusing(true);
      this.jdField_a_of_type_AndroidHardwareCamera.autoFocus(this.jdField_a_of_type_AndroidHardwareCamera$AutoFocusCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.camera.VcCamera
 * JD-Core Version:    0.7.0.1
 */