package com.tencent.av.camera;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.tencent.av.AVLog;
import com.tencent.av.core.VcControllerImpl;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.GraphicRenderMgr.FocusDetectCallback;
import com.tencent.av.opengl.config.EffectFaceDeviceConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import jhg;
import jhr;

public class VcCamera
  extends AndroidCamera
  implements GraphicRenderMgr.FocusDetectCallback
{
  private Camera.AutoFocusCallback a;
  
  static
  {
    if (Build.VERSION.SDK_INT < 16)
    {
      k = 320;
      l = 240;
    }
    DisplayMetrics localDisplayMetrics = BaseApplicationImpl.sApplication.getResources().getDisplayMetrics();
    if (Math.max(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) <= 1280)
    {
      k = 320;
      l = 240;
    }
  }
  
  public VcCamera(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidHardwareCamera$AutoFocusCallback = new jhr(this);
  }
  
  @TargetApi(9)
  private void a(Camera.Parameters paramParameters, boolean paramBoolean)
  {
    if (paramParameters == null)
    {
      AVLog.c("AndroidCamera", "parameters null, do nothing about focus config");
      return;
    }
    List localList = paramParameters.getSupportedFocusModes();
    if (localList == null)
    {
      AVLog.c("AndroidCamera", "getSupportedFocusModes empty");
      return;
    }
    EffectFaceDeviceConfig localEffectFaceDeviceConfig = EffectFaceDeviceConfig.a();
    if ((localEffectFaceDeviceConfig != null) && (localEffectFaceDeviceConfig.f())) {}
    for (boolean bool = true;; bool = false)
    {
      AVLog.c("AndroidCamera", String.format("enableAutoFocus, isUserSelfFocusDev[%s], enable[%s]", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) }));
      if (!bool) {
        break;
      }
      a(paramBoolean, localList);
      return;
    }
    a(paramBoolean, localList, paramParameters);
  }
  
  private void a(boolean paramBoolean, List paramList)
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
  
  private void a(boolean paramBoolean, List paramList, Camera.Parameters paramParameters)
  {
    if ((paramBoolean) && (this.e >= 9) && (paramList.contains("continuous-video"))) {
      paramParameters.setFocusMode("continuous-video");
    }
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.setParameters(paramParameters);
      return;
    }
    catch (Exception paramList) {}
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    String str;
    if (this.jdField_a_of_type_AndroidHardwareCamera != null) {
      str = null;
    }
    try
    {
      localObject = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
      if (localObject != null)
      {
        bool = VcControllerImpl.setCameraParameters(((Camera.Parameters)localObject).flatten());
        str = ((Camera.Parameters)localObject).flatten();
        if (!bool)
        {
          bool = true;
          QQGAudioCtrl.setCameraParameters(str, bool);
          a((Camera.Parameters)localObject, true);
        }
      }
      else
      {
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool;
        Object localObject = str;
        if (QLog.isColorLevel())
        {
          QLog.d("AndroidCamera", 2, "getParameters exception", localException);
          localObject = str;
          continue;
          bool = false;
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidHardwareCamera == null) {
        AVLog.c("AndroidCamera", "camera null, return");
      }
    }
    else {
      return;
    }
    GraphicRenderMgr.getInstance().setIsFocusing(true);
    this.jdField_a_of_type_AndroidHardwareCamera.autoFocus(this.jdField_a_of_type_AndroidHardwareCamera$AutoFocusCallback);
  }
  
  /* Error */
  public boolean c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 216	com/tencent/av/camera/VcCamera:jdField_a_of_type_Boolean	Z
    //   5: istore_1
    //   6: iload_1
    //   7: ifeq +17 -> 24
    //   10: aload_0
    //   11: getfield 162	com/tencent/av/camera/VcCamera:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   14: invokevirtual 175	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   17: astore_2
    //   18: aload_0
    //   19: aload_2
    //   20: iconst_0
    //   21: invokespecial 192	com/tencent/av/camera/VcCamera:a	(Landroid/hardware/Camera$Parameters;Z)V
    //   24: aload_0
    //   25: invokespecial 218	com/tencent/av/camera/AndroidCamera:c	()Z
    //   28: istore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: iload_1
    //   32: ireturn
    //   33: astore_2
    //   34: invokestatic 197	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   37: ifeq +28 -> 65
    //   40: ldc 72
    //   42: iconst_2
    //   43: new 220	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   50: ldc 224
    //   52: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_2
    //   56: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 237	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   65: aconst_null
    //   66: astore_2
    //   67: goto -49 -> 18
    //   70: astore_2
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_2
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	VcCamera
    //   5	27	1	bool	boolean
    //   17	3	2	localParameters	Camera.Parameters
    //   33	23	2	localException	Exception
    //   66	1	2	localObject1	Object
    //   70	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   10	18	33	java/lang/Exception
    //   2	6	70	finally
    //   10	18	70	finally
    //   18	24	70	finally
    //   24	29	70	finally
    //   34	65	70	finally
  }
  
  public int g()
  {
    return a(this.f, this.jdField_a_of_type_AndroidHardwareCamera).c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.camera.VcCamera
 * JD-Core Version:    0.7.0.1
 */