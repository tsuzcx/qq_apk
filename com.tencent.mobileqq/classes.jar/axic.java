import android.annotation.TargetApi;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceHolder;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class axic
  extends Handler
  implements Camera.AutoFocusCallback
{
  axic(axhz paramaxhz, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  @TargetApi(14)
  private void a(Rect paramRect1, Rect paramRect2, Camera.AutoFocusCallback paramAutoFocusCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_REQUEST_FOCUS");
    }
    Camera.Parameters localParameters = axhr.a().a();
    if ((Build.VERSION.SDK_INT >= 14) && (paramRect1 != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("CameraProxy", 2, "[handleMessage] focus area = " + paramRect1);
      }
      localParameters.setFocusMode("auto");
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new Camera.Area(paramRect1, 1000));
      localParameters.setFocusAreas(localArrayList);
      if ((localParameters.getMaxNumMeteringAreas() > 0) && (paramRect2 != null))
      {
        paramRect1 = new ArrayList(1);
        paramRect1.add(new Camera.Area(new Rect(paramRect2), 1000));
        localParameters.setMeteringAreas(paramRect1);
      }
      axhr.a().jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters);
    }
    paramRect1 = paramAutoFocusCallback;
    if (paramAutoFocusCallback == null) {
      paramRect1 = new axid(this);
    }
    axhr.a().a(paramRect1);
  }
  
  public String a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "[@] getDefaultFocusMode: Build.MANUFACTURER=" + Build.MANUFACTURER + "VERSION.SDK_INT=" + Build.VERSION.SDK_INT);
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (Build.VERSION.SDK_INT >= 14)) {}
    return "continuous-picture";
  }
  
  public String b()
  {
    String str2 = "continuous-video";
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "[@] getRecordingFocusMode: Build.MANUFACTURER=" + Build.MANUFACTURER + "VERSION.SDK_INT=" + Build.VERSION.SDK_INT);
    }
    String str1 = str2;
    if (Build.MANUFACTURER.equalsIgnoreCase("samsung"))
    {
      str1 = str2;
      if (Build.VERSION.SDK_INT >= 14) {
        str1 = "continuous-picture";
      }
    }
    return str1;
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool2 = false;
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      try
      {
        throw new RuntimeException("Unimplemented CameraProxy message=" + paramMessage.what);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("CameraProxy", 2, "[Camera2Handler.handleMessage]", localException);
        }
        return;
        bjah.b("CameraProxy", "[handleMessage] OPEN_CAMERA + BEGIN");
        i = ((Integer)((Object[])(Object[])paramMessage.obj)[0]).intValue();
        if (QLog.isColorLevel()) {
          QLog.i("CameraProxy", 2, "[handleMessage] OPEN_CAMERA");
        }
        i = axhr.a().a(i);
        bjah.b("CameraProxy", "[handleMessage] OPEN_CAMERA, result = " + i);
        if (i == 5)
        {
          this.a.jdField_a_of_type_Axif.a(1, new Object[] { Boolean.valueOf(true) });
          return;
        }
        if (i != 0)
        {
          this.a.jdField_a_of_type_Axif.a(1, new Object[] { "open camera failed:errcode=" + axhr.a(i) });
          return;
        }
        if (!axhr.a().c())
        {
          this.a.jdField_a_of_type_Axif.a(1, new Object[] { "open camera failed, orientation error." });
          return;
        }
        this.a.jdField_a_of_type_Axif.a(1, new Object[] { Boolean.valueOf(true) });
        this.a.jdField_a_of_type_Boolean = false;
        return;
        if (QLog.isColorLevel()) {
          QLog.i("CameraProxy", 2, "[handleMessage]CHANGED");
        }
        int k = Integer.parseInt(paramMessage.obj.toString());
        i = paramMessage.arg1;
        j = paramMessage.arg2;
        this.a.jdField_a_of_type_Boolean = false;
        axhz.a(this.a, false);
        if (QLog.isColorLevel()) {
          QLog.i("CameraProxy", 2, "[@] surfaceChanged start, format = " + k + ",width = " + i + ",height = " + j);
        }
        if ((this.a.jdField_b_of_type_Int <= 0) || (i <= this.a.jdField_b_of_type_Int)) {
          break label5339;
        }
        i = this.a.jdField_b_of_type_Int;
        if ((this.a.jdField_c_of_type_Int <= 0) || (j <= this.a.jdField_c_of_type_Int)) {
          break label5336;
        }
        j = this.a.jdField_c_of_type_Int;
        localObject7 = axhr.a();
        if (Build.VERSION.SDK_INT <= 10) {
          axhr.a().b();
        }
        if (this.a.jdField_a_of_type_Int == 1)
        {
          localObject1 = this.a.jdField_a_of_type_Axii;
          if (((axii)localObject1).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
            continue;
          }
          if (!axhr.a().e()) {
            this.a.jdField_a_of_type_Axif.a(2, new Object[] { "set preview format failed" });
          }
        }
        else
        {
          if (this.a.jdField_a_of_type_Int == 3)
          {
            if (ahty.jdField_a_of_type_Int == 1)
            {
              localObject1 = this.a.jdField_c_of_type_Axii;
              continue;
            }
            if (ahty.jdField_a_of_type_Int == 2)
            {
              localObject1 = this.a.jdField_b_of_type_Axii;
              continue;
            }
            this.a.jdField_a_of_type_Axif.a(2, new Object[] { "set preview format failed[Camera Kind error:PROGNOSIS_FULL_FILTER]" });
            return;
          }
          if (this.a.jdField_a_of_type_Int == 2)
          {
            if (ahty.jdField_a_of_type_Int == 1)
            {
              localObject1 = this.a.e;
              continue;
            }
            if (ahty.jdField_a_of_type_Int == 2)
            {
              localObject1 = this.a.d;
              continue;
            }
            this.a.jdField_a_of_type_Axif.a(2, new Object[] { "set preview format failed[Camera Kind error:RATIO_SCREEN]" });
            return;
          }
          if (this.a.jdField_a_of_type_Int == 4)
          {
            if (ahty.jdField_a_of_type_Int == 1)
            {
              localObject1 = this.a.g;
              continue;
            }
            if (ahty.jdField_a_of_type_Int == 2)
            {
              localObject1 = this.a.f;
              continue;
            }
            this.a.jdField_a_of_type_Axif.a(2, new Object[] { "set preview format failed[Camera Kind error:PROGNOSIS_FULL_FILTER]" });
            return;
          }
          if (this.a.jdField_a_of_type_Int == 5)
          {
            localObject1 = this.a.h;
            continue;
          }
          this.a.jdField_a_of_type_Axif.a(2, new Object[] { "set preview format failed[Preview Selector Error]" });
          return;
        }
        localObject6 = null;
        if ((this.a.jdField_a_of_type_Int == 1) || (this.a.jdField_a_of_type_Int == 3) || (this.a.jdField_a_of_type_Int == 4))
        {
          localObject6 = ((axhr)localObject7).c(axim.j, axim.k, this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int);
          localObject5 = localObject6[0];
          localObject6 = localObject6[1];
          if (localObject5 == null) {
            break label5330;
          }
          bool1 = axhr.a().a((axhu)localObject5);
          break label5342;
          if (!bool1) {
            this.a.jdField_a_of_type_Axif.a(2, new Object[] { "set preview size failed" + (String)localObject5 });
          }
        }
        else
        {
          if (this.a.jdField_a_of_type_Int == 2)
          {
            localObject5 = ((axhr)localObject7).a(axim.j, axim.k, i, j);
            bool1 = bool4;
            if (localObject5 == null) {
              break label5350;
            }
            bool1 = axhr.a().a((axhu)localObject5);
            break label5350;
          }
          if (this.a.jdField_a_of_type_Int != 5) {
            break label5366;
          }
          if ((Build.MANUFACTURER.equals("Xiaomi")) && (Build.MODEL.equals("MI 3")))
          {
            localObject5 = new axhu();
            ((axhu)localObject5).jdField_a_of_type_Int = 640;
            ((axhu)localObject5).jdField_b_of_type_Int = 480;
            bool1 = bool5;
            if (localObject5 == null) {
              break label5358;
            }
            bool1 = axhr.a().a((axhu)localObject5);
            break label5358;
          }
          localObject5 = ((axhr)localObject7).a(480);
          continue;
        }
        if (!axhr.a().a(axim.g))
        {
          this.a.jdField_a_of_type_Axif.a(2, new Object[] { "set preview fps failed" });
          return;
        }
        if ((this.a.jdField_a_of_type_Int != 1) && (this.a.jdField_a_of_type_Int != 4) && (this.a.jdField_a_of_type_Int != 5) && (localObject6 != null) && (!((axhr)localObject7).b((axhu)localObject6))) {}
        ((axii)localObject1).jdField_a_of_type_Int = axhr.a().a();
        ((axii)localObject1).jdField_a_of_type_Axhu = axhr.a().a();
        localObject5 = axhr.a().b();
        if (localObject5 != null)
        {
          ((axii)localObject1).jdField_b_of_type_Axhu = ((axhu)localObject5);
          ((axii)localObject1).jdField_a_of_type_Boolean = true;
        }
        localObject5 = axhr.a().a();
        ((axii)localObject1).jdField_b_of_type_Int = localObject5[0];
        ((axii)localObject1).jdField_c_of_type_Int = localObject5[1];
        if ((this.a.jdField_a_of_type_Int != 1) && (this.a.jdField_a_of_type_Int != 3) && (this.a.jdField_a_of_type_Int != 4) && (this.a.jdField_a_of_type_Int != 5))
        {
          ((axii)localObject1).jdField_b_of_type_Axhu = axhr.a().b();
          ((axii)localObject1).jdField_a_of_type_Boolean = true;
        }
        if (this.a.jdField_a_of_type_Int == 4) {
          ((axii)localObject1).jdField_a_of_type_Boolean = false;
        }
        ((axii)localObject1).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true);
        Object localObject1 = a();
        if ((!axhr.a().a((String)localObject1)) && (!axhr.a().a("auto")) && (!axhr.a().a(this))) {
          this.a.jdField_a_of_type_Axif.a(9, new Object[] { ajya.a(2131701330) });
        }
        if (!axhr.a().c())
        {
          this.a.jdField_a_of_type_Axif.a(2, new Object[] { "set display orientation failed" });
          return;
          if (!axhr.a().a((axii)localObject1))
          {
            this.a.jdField_a_of_type_Axif.a(2, new Object[] { "set Camera Params failed" });
            return;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("CameraProxy", 2, "[handleMessage]Set camera param by cache params");
          continue;
        }
      }
      finally
      {
        axil.a(paramMessage);
      }
      Object localObject3 = axhr.a().a();
      int i = axhr.a().a();
      Object localObject5 = axhr.a().a();
      this.a.jdField_a_of_type_Axif.a(2, new Object[] { localObject5, Integer.valueOf(i), localObject3 });
      continue;
      localObject3 = (Object[])paramMessage.obj;
      localObject5 = (axhu)localObject3[0];
      Object localObject7 = (axhu)localObject3[1];
      i = ((Integer)localObject3[2]).intValue();
      int j = ((Integer)localObject3[3]).intValue();
      bool2 = ((Boolean)localObject3[4]).booleanValue();
      if (QLog.isColorLevel()) {
        QLog.i("CameraProxy", 2, "[handleMessage] SET_PARAMS, , wantedSize = " + localObject5 + " , viewSize = " + localObject7 + " , selectMode = " + i + " , resolutionMode = " + bool2);
      }
      this.a.jdField_a_of_type_Boolean = false;
      axhz.a(this.a, false);
      Object localObject6 = axhr.a();
      Object localObject8 = axhr.a().jdField_a_of_type_Int + "#" + localObject5 + "#" + localObject7 + "#" + i;
      localObject3 = (axii)this.a.jdField_a_of_type_JavaUtilMap.get(localObject8);
      if (localObject3 == null)
      {
        localObject3 = new axii();
        this.a.jdField_a_of_type_JavaUtilMap.put(localObject8, localObject3);
      }
      for (;;)
      {
        for (;;)
        {
          if (!((axii)localObject3).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
          {
            if (!axhr.a().e())
            {
              this.a.jdField_a_of_type_Axif.a(2, new Object[] { "set preview format failed" });
              axil.a(paramMessage);
              return;
            }
            if (!bool2) {}
            for (localObject5 = ((axhr)localObject6).a(((axhu)localObject5).jdField_a_of_type_Int, ((axhu)localObject5).jdField_b_of_type_Int, ((axhu)localObject7).jdField_a_of_type_Int, ((axhu)localObject7).jdField_b_of_type_Int);; localObject5 = ((axhr)localObject6).b(((axhu)localObject5).jdField_a_of_type_Int, ((axhu)localObject5).jdField_b_of_type_Int, ((axhu)localObject7).jdField_a_of_type_Int, ((axhu)localObject7).jdField_b_of_type_Int))
            {
              localObject7 = localObject5[0];
              localObject5 = localObject5[1];
              if (localObject7 != null) {
                bool1 = axhr.a().a((axhu)localObject7);
              }
              if (bool1) {
                break;
              }
              this.a.jdField_a_of_type_Axif.a(2, new Object[] { "set preview size failed" + "" });
              axil.a(paramMessage);
              return;
            }
            if (((localObject5 == null) || (((axhr)localObject6).b((axhu)localObject5))) || (!axhr.a().a(j)))
            {
              this.a.jdField_a_of_type_Axif.a(2, new Object[] { "set preview fps failed" });
              axil.a(paramMessage);
              return;
            }
            ((axii)localObject3).jdField_a_of_type_Int = axhr.a().a();
            ((axii)localObject3).jdField_a_of_type_Axhu = axhr.a().a();
            localObject5 = axhr.a().b();
            if (localObject5 != null)
            {
              ((axii)localObject3).jdField_b_of_type_Axhu = ((axhu)localObject5);
              ((axii)localObject3).jdField_a_of_type_Boolean = true;
            }
            localObject5 = axhr.a().a();
            ((axii)localObject3).jdField_b_of_type_Int = localObject5[0];
            ((axii)localObject3).jdField_c_of_type_Int = localObject5[1];
            ((axii)localObject3).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true);
          }
          for (;;)
          {
            localObject3 = a();
            if ((!axhr.a().a((String)localObject3)) && (!axhr.a().a("auto")) && (!axhr.a().a(this))) {
              this.a.jdField_a_of_type_Axif.a(9, new Object[] { ajya.a(2131701327) });
            }
            if (axhr.a().c()) {
              break;
            }
            this.a.jdField_a_of_type_Axif.a(2, new Object[] { "set display orientation failed" });
            axil.a(paramMessage);
            return;
            if (!axhr.a().a((axii)localObject3))
            {
              this.a.jdField_a_of_type_Axif.a(2, new Object[] { "set Camera Params failed" });
              axil.a(paramMessage);
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage] Set camera param by cache params");
            }
          }
          localObject3 = axhr.a().a();
          i = axhr.a().a();
          localObject5 = axhr.a().a();
          this.a.jdField_a_of_type_Axif.a(2, new Object[] { localObject5, Integer.valueOf(i), localObject3 });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_DEFAULT");
          }
          localObject3 = a();
          if ((axhr.a().a((String)localObject3)) || (axhr.a().a("auto")) || (axhr.a().a(this))) {
            break;
          }
          this.a.jdField_a_of_type_Axif.a(9, new Object[] { ajya.a(2131701329) });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_AUTO");
          }
          if (axhr.a().a("auto")) {
            break;
          }
          this.a.jdField_a_of_type_Axif.a(9, new Object[] { ajya.a(2131701328) });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_RECORDING");
          }
          localObject3 = b();
          if (axhr.a().a((String)localObject3)) {
            break;
          }
          this.a.jdField_a_of_type_Axif.a(9, new Object[] { ajya.a(2131701323) });
          break;
          localObject3 = (axih)paramMessage.obj;
          a(((axih)localObject3).jdField_a_of_type_AndroidGraphicsRect, ((axih)localObject3).b, ((axih)localObject3).jdField_a_of_type_AndroidHardwareCamera$AutoFocusCallback);
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_SET_SURFACE");
          }
          localObject3 = (SurfaceTexture)paramMessage.obj;
          if (axhr.a().a((SurfaceTexture)localObject3)) {
            break;
          }
          this.a.jdField_a_of_type_Axif.a(2, new Object[] { "set preview texture failed" });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_SET_SURFACE_HOLDER");
          }
          localObject3 = (SurfaceHolder)paramMessage.obj;
          if (axhr.a().a((SurfaceHolder)localObject3)) {
            break;
          }
          this.a.jdField_a_of_type_Axif.a(2, new Object[] { "set surface holder failed" });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_SET_CALLBACK");
          }
          localObject3 = (Camera.PreviewCallback)paramMessage.obj;
          bool1 = bool3;
          if (paramMessage.arg1 > 0) {
            bool1 = true;
          }
          if (axhr.a().a((Camera.PreviewCallback)localObject3, bool1)) {
            break;
          }
          this.a.jdField_a_of_type_Axif.a(2, new Object[] { "set preview callback failed" });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_START");
          }
          if (!axhr.a().a())
          {
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_START error");
            }
            bjah.b("CameraProxy", "[handleMessage] PREVIEW_START");
            this.a.jdField_a_of_type_Axif.a(3, new Object[] { "start preview failed" });
            break;
          }
          localObject3 = axhr.a();
          if (((axhr)localObject3).jdField_a_of_type_Int != 1) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_START, cameraId = " + ((axhr)localObject3).jdField_a_of_type_Int);
          }
          bjah.b("CameraProxy", "【Camera 】PREVIEW_START success cameraID:" + ((axhr)localObject3).jdField_a_of_type_Int);
          if ((!((axhr)localObject3).d()) || (axhz.a(this.a) == null)) {
            break;
          }
          QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_START, startFaceDetection");
          ((axhr)localObject3).a(axhz.a(this.a));
          ((axhr)localObject3).c();
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]FACE_DETECT_SWITCH" + paramMessage.arg1);
          }
          localObject3 = axhr.a();
          if ((!((axhr)localObject3).d()) || (axhz.a(this.a) == null)) {
            break;
          }
          if (paramMessage.arg1 == 1)
          {
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]FACE_DETECT_SWITCH " + ((axhr)localObject3).jdField_a_of_type_Int);
            }
            if (((axhr)localObject3).jdField_a_of_type_Int != 1) {
              break;
            }
            ((axhr)localObject3).a(axhz.a(this.a));
            ((axhr)localObject3).c();
            break;
          }
          if (paramMessage.arg1 != 2) {
            break;
          }
          ((axhr)localObject3).d();
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_STOP");
          }
          bjah.b("CameraProxy", "【Camera】PREVIEW_STOP success");
          if (!axhr.a().b())
          {
            this.a.jdField_a_of_type_Axif.a(4, new Object[] { "stop preview failed" });
            break;
          }
          localObject3 = axhr.a();
          if ((!((axhr)localObject3).d()) || (axhz.a(this.a) == null)) {
            break;
          }
          ((axhr)localObject3).d();
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]RELEASE");
          }
          axhr.a().b();
          this.a.jdField_a_of_type_Boolean = true;
          try
          {
            Thread.sleep(50L);
            bjah.b("CameraProxy", "【Camera】RELEASE success");
            this.a.jdField_a_of_type_Axif.a(11, new Object[] { "camera destory" });
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]NIGHT_MODE_ON_OFF" + paramMessage.arg1);
            }
            if (paramMessage.arg1 == 1)
            {
              axhz.a(this.a);
              break;
            }
            if (paramMessage.arg1 != 2) {
              break;
            }
            axhz.b(this.a);
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]FLASH_LIGHT_ON_OFF");
            }
            if (paramMessage.arg1 == 1)
            {
              if (axhr.a().a(true)) {
                break;
              }
              this.a.jdField_a_of_type_Axif.a(6, new Object[] { "turn on flash light failed" });
              break;
            }
            if ((paramMessage.arg1 != 2) || (axhr.a().a(false))) {
              break;
            }
            this.a.jdField_a_of_type_Axif.a(6, new Object[] { "turn off flash light failed" });
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]FLASH_LIGHT_SWITCH");
            }
            if (paramMessage.arg1 == 0)
            {
              if (axhr.a().f()) {
                break;
              }
              this.a.jdField_a_of_type_Axif.a(6, new Object[] { "switch flash light failed" });
              break;
            }
            if (paramMessage.arg1 == 1)
            {
              if (axhr.a().b(true)) {
                break;
              }
              this.a.jdField_a_of_type_Axif.a(6, new Object[] { "turn on flash light failed" });
              break;
            }
            if ((paramMessage.arg1 != 2) || (axhr.a().b(false))) {
              break;
            }
            this.a.jdField_a_of_type_Axif.a(6, new Object[] { "turn off flash light failed" });
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]PICTURE_TAKE");
            }
            ahvx.a("received");
            localObject3 = (axik)paramMessage.obj;
            localObject5 = axhr.a();
            if (!((axhr)localObject5).jdField_a_of_type_Boolean)
            {
              if (QLog.isColorLevel()) {
                QLog.i("CameraProxy", 2, "[takePicture]Camera is not previewing...");
              }
              axil.a(paramMessage);
              return;
            }
            if (((axik)localObject3).jdField_a_of_type_JavaIoFile == null)
            {
              this.a.jdField_a_of_type_Axif.a(2, new Object[] { "take picture error" });
              axil.a(paramMessage);
              return;
            }
            ((axhr)localObject5).a(((axik)localObject3).jdField_a_of_type_JavaIoFile, ((axik)localObject3).jdField_a_of_type_AndroidGraphicsRect, ((axik)localObject3).jdField_a_of_type_Aiai, ((axik)localObject3).jdField_a_of_type_Int, ((axik)localObject3).jdField_a_of_type_Boolean, ((axik)localObject3).jdField_b_of_type_Int);
            break;
            i = ((Integer)((Object[])(Object[])paramMessage.obj)[0]).intValue();
            axhr.a().b(i);
            break;
            localObject3 = (String)((Object[])(Object[])paramMessage.obj)[0];
            axhr.a().b((String)localObject3);
            break;
            bjah.b("CameraProxy", "camera2 open in.");
            localObject3 = (Object[])paramMessage.obj;
            i = ((Integer)localObject3[0]).intValue();
            if ((localObject3[1] instanceof axga))
            {
              localObject3 = (axga)localObject3[1];
              if (Camera2Control.a().b())
              {
                axgf.a(1, "[Camera2] camera2 is opening!");
                axil.a(paramMessage);
                return;
              }
              i = Camera2Control.a().a(i, (axga)localObject3);
              if (i == 0) {
                break;
              }
              bjah.d("CameraProxy", "【Camera2 Open Error】EVENT_CAMERA2_ERROR:" + i);
              this.a.jdField_a_of_type_Axif.a(13, new Object[] { Integer.valueOf(i) });
              break;
              localObject3 = (SurfaceTexture)((Object[])(Object[])paramMessage.obj)[0];
              Camera2Control.a().a((SurfaceTexture)localObject3);
              bjah.b("CameraProxy", "【Camera2】PREVIEW_START");
              break;
              localObject3 = (Camera.PreviewCallback)((Object[])(Object[])paramMessage.obj)[0];
              Camera2Control.a().a((Camera.PreviewCallback)localObject3);
              break;
              Camera2Control.a().e();
              bjah.b("CameraProxy", "【Camera2】CAMERA2_RELEASE");
              break;
              localObject7 = (Object[])paramMessage.obj;
              localObject5 = (axhu)localObject7[0];
              localObject8 = (axhu)localObject7[1];
              bool1 = ((Boolean)localObject7[4]).booleanValue();
              localObject3 = new StringBuilder();
              Camera2Control.a();
              localObject6 = Camera2Control.a + "#" + localObject5 + "#" + localObject8;
              if (QLog.isColorLevel()) {
                QLog.i("CameraProxy", 2, "[handleMessage]CAMERA2_SET_PARAMS,wantedSize = " + localObject5 + " , viewSize = " + localObject8 + ",resolutionMode:" + bool1);
              }
              localObject3 = (axij)this.a.jdField_b_of_type_JavaUtilMap.get(localObject6);
              if (localObject3 == null)
              {
                localObject3 = new axij();
                this.a.jdField_b_of_type_JavaUtilMap.put(localObject6, localObject3);
                if (!((axij)localObject3).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
                {
                  localObject6 = Camera2Control.a().a();
                  if (!bool1) {}
                  for (localObject5 = axgf.a(((axhu)localObject5).jdField_a_of_type_Int, ((axhu)localObject5).jdField_b_of_type_Int, ((axhu)localObject8).jdField_a_of_type_Int, ((axhu)localObject8).jdField_b_of_type_Int, (axfz)localObject6);; localObject5 = axgf.b(((axhu)localObject5).jdField_a_of_type_Int, ((axhu)localObject5).jdField_b_of_type_Int, ((axhu)localObject8).jdField_a_of_type_Int, ((axhu)localObject8).jdField_b_of_type_Int, (axfz)localObject6))
                  {
                    if ((localObject5 == null) || (localObject5.length < 2)) {
                      break label5309;
                    }
                    localObject6 = localObject5[0];
                    localObject5 = localObject5[1];
                    localObject8 = new axhu(Math.max(((axhu)localObject8).jdField_a_of_type_Int, ((axhu)localObject8).jdField_b_of_type_Int), Math.min(((axhu)localObject8).jdField_a_of_type_Int, ((axhu)localObject8).jdField_b_of_type_Int));
                    localObject8 = Camera2Control.a().a((axhu)localObject8);
                    if (Camera2Control.a().a((axhu)localObject6)) {
                      break;
                    }
                    this.a.jdField_a_of_type_Axif.a(14, new Object[] { "[Camera2]setCamera2 previewSize error!" });
                    axil.a(paramMessage);
                    return;
                  }
                  if (!Camera2Control.a().b((axhu)localObject5))
                  {
                    this.a.jdField_a_of_type_Axif.a(14, new Object[] { "[Camera2]setCamera2 pictureSize error!" });
                    axil.a(paramMessage);
                    return;
                  }
                  if (!Camera2Control.a().a(((Integer)localObject7[3]).intValue()))
                  {
                    this.a.jdField_a_of_type_Axif.a(14, new Object[] { "[Camera2]setCamera2 fps error!" });
                    axil.a(paramMessage);
                    return;
                  }
                  ((axij)localObject3).jdField_a_of_type_Axhu = ((axhu)localObject6);
                  ((axij)localObject3).jdField_b_of_type_Axhu = ((axhu)localObject5);
                  ((axij)localObject3).c = ((axhu)localObject8);
                  ((axij)localObject3).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true);
                }
                while (Camera2Control.a().a((axij)localObject3))
                {
                  localObject3 = Camera2Control.a().b();
                  localObject5 = Camera2Control.a().a();
                  this.a.jdField_a_of_type_Axif.a(14, new Object[] { localObject3, localObject5 });
                  break;
                }
                this.a.jdField_a_of_type_Axif.a(14, new Object[] { "[Camera2]setCamera2ParamOnce error!" });
                axil.a(paramMessage);
                return;
                if (QLog.isColorLevel()) {
                  QLog.i("CameraProxy", 2, "[handleMessage]CAMERA2_PICTURE_TAKE");
                }
                localObject3 = (axik)paramMessage.obj;
                if (((axik)localObject3).jdField_a_of_type_JavaIoFile == null)
                {
                  this.a.jdField_a_of_type_Axif.a(2, new Object[] { "take picture error" });
                  axil.a(paramMessage);
                  return;
                }
                localObject5 = new axgb();
                ((axgb)localObject5).jdField_a_of_type_Aiai = ((axik)localObject3).jdField_a_of_type_Aiai;
                ((axgb)localObject5).jdField_a_of_type_Boolean = ((axik)localObject3).jdField_a_of_type_Boolean;
                ((axgb)localObject5).jdField_a_of_type_Int = ((axik)localObject3).jdField_a_of_type_Int;
                ((axgb)localObject5).jdField_a_of_type_JavaIoFile = ((axik)localObject3).jdField_a_of_type_JavaIoFile;
                ((axgb)localObject5).jdField_a_of_type_AndroidGraphicsRect = ((axik)localObject3).jdField_a_of_type_AndroidGraphicsRect;
                Camera2Control.a().a((axgb)localObject5);
                break;
                if (QLog.isColorLevel()) {
                  QLog.i("CameraProxy", 2, "[handleMessage]CAMERA2_STOP_VIDEO");
                }
                Camera2Control.a().c();
                break;
                localObject3 = (axih)paramMessage.obj;
                Camera2Control.a().a((axih)localObject3);
                break;
                i = ((Integer)((Object[])(Object[])paramMessage.obj)[0]).intValue();
                Camera2Control.a().a(i);
                break;
                bool1 = ((Boolean)((Object[])(Object[])paramMessage.obj)[0]).booleanValue();
                Camera2Control.a().a(bool1);
                break;
                Camera2Control.a().a();
                break;
                if (QLog.isColorLevel()) {
                  QLog.i("CameraProxy", 2, "[handleMessage]CAMERA2_START_VIDEO");
                }
                Camera2Control.a().b();
                break;
                axgf.a(2, "[Camera2] error:" + paramMessage.arg1);
                bjah.d("CameraProxy", "【Camera2 Open Error】CAMERA2_ERROR_CALLBACK:" + paramMessage.arg1);
                i = paramMessage.arg1;
                switch (i)
                {
                case -203: 
                case -202: 
                case -201: 
                  this.a.jdField_a_of_type_Axif.a(14, new Object[] { "[Camera2]setCamera2 previewSize error:" + i });
                  break;
                case -105: 
                case -102: 
                  this.a.jdField_a_of_type_Axif.a(13, new Object[] { Integer.valueOf(i) });
                }
              }
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              continue;
              label5309:
              localObject5 = null;
              localObject6 = null;
              continue;
              continue;
              Object localObject4 = null;
            }
          }
        }
      }
      label5330:
      bool1 = false;
      break label5342;
      label5336:
      continue;
      label5339:
      continue;
      label5342:
      localObject5 = "";
      continue;
      label5350:
      localObject5 = "";
      continue;
      label5358:
      localObject5 = "";
      continue;
      label5366:
      localObject5 = " :[Preview Selector Error]";
      bool1 = bool2;
    }
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "[onAutoFocus]success " + paramBoolean);
    }
    paramCamera = a();
    axhr.a().a(paramCamera);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axic
 * JD-Core Version:    0.7.0.1
 */