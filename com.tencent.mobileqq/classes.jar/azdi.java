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

public class azdi
  extends Handler
  implements Camera.AutoFocusCallback
{
  azdi(azdf paramazdf, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  @TargetApi(14)
  private void a(Rect paramRect1, Rect paramRect2, Camera.AutoFocusCallback paramAutoFocusCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_REQUEST_FOCUS");
    }
    Camera.Parameters localParameters = azcx.a().a();
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
      azcx.a().jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters);
    }
    paramRect1 = paramAutoFocusCallback;
    if (paramAutoFocusCallback == null) {
      paramRect1 = new azdj(this);
    }
    azcx.a().a(paramRect1);
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
        blfg.b("CameraProxy", "[handleMessage] OPEN_CAMERA + BEGIN");
        i = ((Integer)((Object[])(Object[])paramMessage.obj)[0]).intValue();
        if (QLog.isColorLevel()) {
          QLog.i("CameraProxy", 2, "[handleMessage] OPEN_CAMERA");
        }
        i = azcx.a().a(i);
        blfg.b("CameraProxy", "[handleMessage] OPEN_CAMERA, result = " + i);
        if (i == 5)
        {
          this.a.jdField_a_of_type_Azdl.a(1, new Object[] { Boolean.valueOf(true) });
          return;
        }
        if (i != 0)
        {
          this.a.jdField_a_of_type_Azdl.a(1, new Object[] { "open camera failed:errcode=" + azcx.a(i) });
          return;
        }
        if (!azcx.a().c())
        {
          this.a.jdField_a_of_type_Azdl.a(1, new Object[] { "open camera failed, orientation error." });
          return;
        }
        this.a.jdField_a_of_type_Azdl.a(1, new Object[] { Boolean.valueOf(true) });
        this.a.jdField_a_of_type_Boolean = false;
        return;
        if (QLog.isColorLevel()) {
          QLog.i("CameraProxy", 2, "[handleMessage]CHANGED");
        }
        int k = Integer.parseInt(paramMessage.obj.toString());
        i = paramMessage.arg1;
        j = paramMessage.arg2;
        this.a.jdField_a_of_type_Boolean = false;
        azdf.a(this.a, false);
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
        localObject7 = azcx.a();
        if (Build.VERSION.SDK_INT <= 10) {
          azcx.a().b();
        }
        if (this.a.jdField_a_of_type_Int == 1)
        {
          localObject1 = this.a.jdField_a_of_type_Azdo;
          if (((azdo)localObject1).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
            continue;
          }
          if (!azcx.a().e()) {
            this.a.jdField_a_of_type_Azdl.a(2, new Object[] { "set preview format failed" });
          }
        }
        else
        {
          if (this.a.jdField_a_of_type_Int == 3)
          {
            if (ajli.jdField_a_of_type_Int == 1)
            {
              localObject1 = this.a.jdField_c_of_type_Azdo;
              continue;
            }
            if (ajli.jdField_a_of_type_Int == 2)
            {
              localObject1 = this.a.jdField_b_of_type_Azdo;
              continue;
            }
            this.a.jdField_a_of_type_Azdl.a(2, new Object[] { "set preview format failed[Camera Kind error:PROGNOSIS_FULL_FILTER]" });
            return;
          }
          if (this.a.jdField_a_of_type_Int == 2)
          {
            if (ajli.jdField_a_of_type_Int == 1)
            {
              localObject1 = this.a.e;
              continue;
            }
            if (ajli.jdField_a_of_type_Int == 2)
            {
              localObject1 = this.a.d;
              continue;
            }
            this.a.jdField_a_of_type_Azdl.a(2, new Object[] { "set preview format failed[Camera Kind error:RATIO_SCREEN]" });
            return;
          }
          if (this.a.jdField_a_of_type_Int == 4)
          {
            if (ajli.jdField_a_of_type_Int == 1)
            {
              localObject1 = this.a.g;
              continue;
            }
            if (ajli.jdField_a_of_type_Int == 2)
            {
              localObject1 = this.a.f;
              continue;
            }
            this.a.jdField_a_of_type_Azdl.a(2, new Object[] { "set preview format failed[Camera Kind error:PROGNOSIS_FULL_FILTER]" });
            return;
          }
          if (this.a.jdField_a_of_type_Int == 5)
          {
            localObject1 = this.a.h;
            continue;
          }
          this.a.jdField_a_of_type_Azdl.a(2, new Object[] { "set preview format failed[Preview Selector Error]" });
          return;
        }
        localObject6 = null;
        if ((this.a.jdField_a_of_type_Int == 1) || (this.a.jdField_a_of_type_Int == 3) || (this.a.jdField_a_of_type_Int == 4))
        {
          localObject6 = ((azcx)localObject7).c(azds.j, azds.k, this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int);
          localObject5 = localObject6[0];
          localObject6 = localObject6[1];
          if (localObject5 == null) {
            break label5330;
          }
          bool1 = azcx.a().a((azda)localObject5);
          break label5342;
          if (!bool1) {
            this.a.jdField_a_of_type_Azdl.a(2, new Object[] { "set preview size failed" + (String)localObject5 });
          }
        }
        else
        {
          if (this.a.jdField_a_of_type_Int == 2)
          {
            localObject5 = ((azcx)localObject7).a(azds.j, azds.k, i, j);
            bool1 = bool4;
            if (localObject5 == null) {
              break label5350;
            }
            bool1 = azcx.a().a((azda)localObject5);
            break label5350;
          }
          if (this.a.jdField_a_of_type_Int != 5) {
            break label5366;
          }
          if ((Build.MANUFACTURER.equals("Xiaomi")) && (Build.MODEL.equals("MI 3")))
          {
            localObject5 = new azda();
            ((azda)localObject5).jdField_a_of_type_Int = 640;
            ((azda)localObject5).jdField_b_of_type_Int = 480;
            bool1 = bool5;
            if (localObject5 == null) {
              break label5358;
            }
            bool1 = azcx.a().a((azda)localObject5);
            break label5358;
          }
          localObject5 = ((azcx)localObject7).a(480);
          continue;
        }
        if (!azcx.a().a(azds.g))
        {
          this.a.jdField_a_of_type_Azdl.a(2, new Object[] { "set preview fps failed" });
          return;
        }
        if ((this.a.jdField_a_of_type_Int != 1) && (this.a.jdField_a_of_type_Int != 4) && (this.a.jdField_a_of_type_Int != 5) && (localObject6 != null) && (!((azcx)localObject7).b((azda)localObject6))) {}
        ((azdo)localObject1).jdField_a_of_type_Int = azcx.a().a();
        ((azdo)localObject1).jdField_a_of_type_Azda = azcx.a().a();
        localObject5 = azcx.a().b();
        if (localObject5 != null)
        {
          ((azdo)localObject1).jdField_b_of_type_Azda = ((azda)localObject5);
          ((azdo)localObject1).jdField_a_of_type_Boolean = true;
        }
        localObject5 = azcx.a().a();
        ((azdo)localObject1).jdField_b_of_type_Int = localObject5[0];
        ((azdo)localObject1).jdField_c_of_type_Int = localObject5[1];
        if ((this.a.jdField_a_of_type_Int != 1) && (this.a.jdField_a_of_type_Int != 3) && (this.a.jdField_a_of_type_Int != 4) && (this.a.jdField_a_of_type_Int != 5))
        {
          ((azdo)localObject1).jdField_b_of_type_Azda = azcx.a().b();
          ((azdo)localObject1).jdField_a_of_type_Boolean = true;
        }
        if (this.a.jdField_a_of_type_Int == 4) {
          ((azdo)localObject1).jdField_a_of_type_Boolean = false;
        }
        ((azdo)localObject1).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true);
        Object localObject1 = a();
        if ((!azcx.a().a((String)localObject1)) && (!azcx.a().a("auto")) && (!azcx.a().a(this))) {
          this.a.jdField_a_of_type_Azdl.a(9, new Object[] { alpo.a(2131701703) });
        }
        if (!azcx.a().c())
        {
          this.a.jdField_a_of_type_Azdl.a(2, new Object[] { "set display orientation failed" });
          return;
          if (!azcx.a().a((azdo)localObject1))
          {
            this.a.jdField_a_of_type_Azdl.a(2, new Object[] { "set Camera Params failed" });
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
        azdr.a(paramMessage);
      }
      Object localObject3 = azcx.a().a();
      int i = azcx.a().a();
      Object localObject5 = azcx.a().a();
      this.a.jdField_a_of_type_Azdl.a(2, new Object[] { localObject5, Integer.valueOf(i), localObject3 });
      continue;
      localObject3 = (Object[])paramMessage.obj;
      localObject5 = (azda)localObject3[0];
      Object localObject7 = (azda)localObject3[1];
      i = ((Integer)localObject3[2]).intValue();
      int j = ((Integer)localObject3[3]).intValue();
      bool2 = ((Boolean)localObject3[4]).booleanValue();
      if (QLog.isColorLevel()) {
        QLog.i("CameraProxy", 2, "[handleMessage] SET_PARAMS, , wantedSize = " + localObject5 + " , viewSize = " + localObject7 + " , selectMode = " + i + " , resolutionMode = " + bool2);
      }
      this.a.jdField_a_of_type_Boolean = false;
      azdf.a(this.a, false);
      Object localObject6 = azcx.a();
      Object localObject8 = azcx.a().jdField_a_of_type_Int + "#" + localObject5 + "#" + localObject7 + "#" + i;
      localObject3 = (azdo)this.a.jdField_a_of_type_JavaUtilMap.get(localObject8);
      if (localObject3 == null)
      {
        localObject3 = new azdo();
        this.a.jdField_a_of_type_JavaUtilMap.put(localObject8, localObject3);
      }
      for (;;)
      {
        for (;;)
        {
          if (!((azdo)localObject3).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
          {
            if (!azcx.a().e())
            {
              this.a.jdField_a_of_type_Azdl.a(2, new Object[] { "set preview format failed" });
              azdr.a(paramMessage);
              return;
            }
            if (!bool2) {}
            for (localObject5 = ((azcx)localObject6).a(((azda)localObject5).jdField_a_of_type_Int, ((azda)localObject5).jdField_b_of_type_Int, ((azda)localObject7).jdField_a_of_type_Int, ((azda)localObject7).jdField_b_of_type_Int);; localObject5 = ((azcx)localObject6).b(((azda)localObject5).jdField_a_of_type_Int, ((azda)localObject5).jdField_b_of_type_Int, ((azda)localObject7).jdField_a_of_type_Int, ((azda)localObject7).jdField_b_of_type_Int))
            {
              localObject7 = localObject5[0];
              localObject5 = localObject5[1];
              if (localObject7 != null) {
                bool1 = azcx.a().a((azda)localObject7);
              }
              if (bool1) {
                break;
              }
              this.a.jdField_a_of_type_Azdl.a(2, new Object[] { "set preview size failed" + "" });
              azdr.a(paramMessage);
              return;
            }
            if (((localObject5 == null) || (((azcx)localObject6).b((azda)localObject5))) || (!azcx.a().a(j)))
            {
              this.a.jdField_a_of_type_Azdl.a(2, new Object[] { "set preview fps failed" });
              azdr.a(paramMessage);
              return;
            }
            ((azdo)localObject3).jdField_a_of_type_Int = azcx.a().a();
            ((azdo)localObject3).jdField_a_of_type_Azda = azcx.a().a();
            localObject5 = azcx.a().b();
            if (localObject5 != null)
            {
              ((azdo)localObject3).jdField_b_of_type_Azda = ((azda)localObject5);
              ((azdo)localObject3).jdField_a_of_type_Boolean = true;
            }
            localObject5 = azcx.a().a();
            ((azdo)localObject3).jdField_b_of_type_Int = localObject5[0];
            ((azdo)localObject3).jdField_c_of_type_Int = localObject5[1];
            ((azdo)localObject3).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true);
          }
          for (;;)
          {
            localObject3 = a();
            if ((!azcx.a().a((String)localObject3)) && (!azcx.a().a("auto")) && (!azcx.a().a(this))) {
              this.a.jdField_a_of_type_Azdl.a(9, new Object[] { alpo.a(2131701700) });
            }
            if (azcx.a().c()) {
              break;
            }
            this.a.jdField_a_of_type_Azdl.a(2, new Object[] { "set display orientation failed" });
            azdr.a(paramMessage);
            return;
            if (!azcx.a().a((azdo)localObject3))
            {
              this.a.jdField_a_of_type_Azdl.a(2, new Object[] { "set Camera Params failed" });
              azdr.a(paramMessage);
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage] Set camera param by cache params");
            }
          }
          localObject3 = azcx.a().a();
          i = azcx.a().a();
          localObject5 = azcx.a().a();
          this.a.jdField_a_of_type_Azdl.a(2, new Object[] { localObject5, Integer.valueOf(i), localObject3 });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_DEFAULT");
          }
          localObject3 = a();
          if ((azcx.a().a((String)localObject3)) || (azcx.a().a("auto")) || (azcx.a().a(this))) {
            break;
          }
          this.a.jdField_a_of_type_Azdl.a(9, new Object[] { alpo.a(2131701702) });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_AUTO");
          }
          if (azcx.a().a("auto")) {
            break;
          }
          this.a.jdField_a_of_type_Azdl.a(9, new Object[] { alpo.a(2131701701) });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_RECORDING");
          }
          localObject3 = b();
          if (azcx.a().a((String)localObject3)) {
            break;
          }
          this.a.jdField_a_of_type_Azdl.a(9, new Object[] { alpo.a(2131701696) });
          break;
          localObject3 = (azdn)paramMessage.obj;
          a(((azdn)localObject3).jdField_a_of_type_AndroidGraphicsRect, ((azdn)localObject3).b, ((azdn)localObject3).jdField_a_of_type_AndroidHardwareCamera$AutoFocusCallback);
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_SET_SURFACE");
          }
          localObject3 = (SurfaceTexture)paramMessage.obj;
          if (azcx.a().a((SurfaceTexture)localObject3)) {
            break;
          }
          this.a.jdField_a_of_type_Azdl.a(2, new Object[] { "set preview texture failed" });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_SET_SURFACE_HOLDER");
          }
          localObject3 = (SurfaceHolder)paramMessage.obj;
          if (azcx.a().a((SurfaceHolder)localObject3)) {
            break;
          }
          this.a.jdField_a_of_type_Azdl.a(2, new Object[] { "set surface holder failed" });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_SET_CALLBACK");
          }
          localObject3 = (Camera.PreviewCallback)paramMessage.obj;
          bool1 = bool3;
          if (paramMessage.arg1 > 0) {
            bool1 = true;
          }
          if (azcx.a().a((Camera.PreviewCallback)localObject3, bool1)) {
            break;
          }
          this.a.jdField_a_of_type_Azdl.a(2, new Object[] { "set preview callback failed" });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_START");
          }
          if (!azcx.a().a())
          {
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_START error");
            }
            blfg.b("CameraProxy", "[handleMessage] PREVIEW_START");
            this.a.jdField_a_of_type_Azdl.a(3, new Object[] { "start preview failed" });
            break;
          }
          localObject3 = azcx.a();
          if (((azcx)localObject3).jdField_a_of_type_Int != 1) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_START, cameraId = " + ((azcx)localObject3).jdField_a_of_type_Int);
          }
          blfg.b("CameraProxy", "【Camera 】PREVIEW_START success cameraID:" + ((azcx)localObject3).jdField_a_of_type_Int);
          if ((!((azcx)localObject3).d()) || (azdf.a(this.a) == null)) {
            break;
          }
          QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_START, startFaceDetection");
          ((azcx)localObject3).a(azdf.a(this.a));
          ((azcx)localObject3).c();
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]FACE_DETECT_SWITCH" + paramMessage.arg1);
          }
          localObject3 = azcx.a();
          if ((!((azcx)localObject3).d()) || (azdf.a(this.a) == null)) {
            break;
          }
          if (paramMessage.arg1 == 1)
          {
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]FACE_DETECT_SWITCH " + ((azcx)localObject3).jdField_a_of_type_Int);
            }
            if (((azcx)localObject3).jdField_a_of_type_Int != 1) {
              break;
            }
            ((azcx)localObject3).a(azdf.a(this.a));
            ((azcx)localObject3).c();
            break;
          }
          if (paramMessage.arg1 != 2) {
            break;
          }
          ((azcx)localObject3).d();
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_STOP");
          }
          blfg.b("CameraProxy", "【Camera】PREVIEW_STOP success");
          if (!azcx.a().b())
          {
            this.a.jdField_a_of_type_Azdl.a(4, new Object[] { "stop preview failed" });
            break;
          }
          localObject3 = azcx.a();
          if ((!((azcx)localObject3).d()) || (azdf.a(this.a) == null)) {
            break;
          }
          ((azcx)localObject3).d();
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]RELEASE");
          }
          azcx.a().b();
          this.a.jdField_a_of_type_Boolean = true;
          try
          {
            Thread.sleep(50L);
            blfg.b("CameraProxy", "【Camera】RELEASE success");
            this.a.jdField_a_of_type_Azdl.a(11, new Object[] { "camera destory" });
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]NIGHT_MODE_ON_OFF" + paramMessage.arg1);
            }
            if (paramMessage.arg1 == 1)
            {
              azdf.a(this.a);
              break;
            }
            if (paramMessage.arg1 != 2) {
              break;
            }
            azdf.b(this.a);
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]FLASH_LIGHT_ON_OFF");
            }
            if (paramMessage.arg1 == 1)
            {
              if (azcx.a().a(true)) {
                break;
              }
              this.a.jdField_a_of_type_Azdl.a(6, new Object[] { "turn on flash light failed" });
              break;
            }
            if ((paramMessage.arg1 != 2) || (azcx.a().a(false))) {
              break;
            }
            this.a.jdField_a_of_type_Azdl.a(6, new Object[] { "turn off flash light failed" });
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]FLASH_LIGHT_SWITCH");
            }
            if (paramMessage.arg1 == 0)
            {
              if (azcx.a().f()) {
                break;
              }
              this.a.jdField_a_of_type_Azdl.a(6, new Object[] { "switch flash light failed" });
              break;
            }
            if (paramMessage.arg1 == 1)
            {
              if (azcx.a().b(true)) {
                break;
              }
              this.a.jdField_a_of_type_Azdl.a(6, new Object[] { "turn on flash light failed" });
              break;
            }
            if ((paramMessage.arg1 != 2) || (azcx.a().b(false))) {
              break;
            }
            this.a.jdField_a_of_type_Azdl.a(6, new Object[] { "turn off flash light failed" });
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]PICTURE_TAKE");
            }
            ajnh.a("received");
            localObject3 = (azdq)paramMessage.obj;
            localObject5 = azcx.a();
            if (!((azcx)localObject5).jdField_a_of_type_Boolean)
            {
              if (QLog.isColorLevel()) {
                QLog.i("CameraProxy", 2, "[takePicture]Camera is not previewing...");
              }
              azdr.a(paramMessage);
              return;
            }
            if (((azdq)localObject3).jdField_a_of_type_JavaIoFile == null)
            {
              this.a.jdField_a_of_type_Azdl.a(2, new Object[] { "take picture error" });
              azdr.a(paramMessage);
              return;
            }
            ((azcx)localObject5).a(((azdq)localObject3).jdField_a_of_type_JavaIoFile, ((azdq)localObject3).jdField_a_of_type_AndroidGraphicsRect, ((azdq)localObject3).jdField_a_of_type_Ajrs, ((azdq)localObject3).jdField_a_of_type_Int, ((azdq)localObject3).jdField_a_of_type_Boolean, ((azdq)localObject3).jdField_b_of_type_Int);
            break;
            i = ((Integer)((Object[])(Object[])paramMessage.obj)[0]).intValue();
            azcx.a().b(i);
            break;
            localObject3 = (String)((Object[])(Object[])paramMessage.obj)[0];
            azcx.a().b((String)localObject3);
            break;
            blfg.b("CameraProxy", "camera2 open in.");
            localObject3 = (Object[])paramMessage.obj;
            i = ((Integer)localObject3[0]).intValue();
            if ((localObject3[1] instanceof azbg))
            {
              localObject3 = (azbg)localObject3[1];
              if (Camera2Control.a().b())
              {
                azbl.a(1, "[Camera2] camera2 is opening!");
                azdr.a(paramMessage);
                return;
              }
              i = Camera2Control.a().a(i, (azbg)localObject3);
              if (i == 0) {
                break;
              }
              blfg.d("CameraProxy", "【Camera2 Open Error】EVENT_CAMERA2_ERROR:" + i);
              this.a.jdField_a_of_type_Azdl.a(13, new Object[] { Integer.valueOf(i) });
              break;
              localObject3 = (SurfaceTexture)((Object[])(Object[])paramMessage.obj)[0];
              Camera2Control.a().a((SurfaceTexture)localObject3);
              blfg.b("CameraProxy", "【Camera2】PREVIEW_START");
              break;
              localObject3 = (Camera.PreviewCallback)((Object[])(Object[])paramMessage.obj)[0];
              Camera2Control.a().a((Camera.PreviewCallback)localObject3);
              break;
              Camera2Control.a().e();
              blfg.b("CameraProxy", "【Camera2】CAMERA2_RELEASE");
              break;
              localObject7 = (Object[])paramMessage.obj;
              localObject5 = (azda)localObject7[0];
              localObject8 = (azda)localObject7[1];
              bool1 = ((Boolean)localObject7[4]).booleanValue();
              localObject3 = new StringBuilder();
              Camera2Control.a();
              localObject6 = Camera2Control.a + "#" + localObject5 + "#" + localObject8;
              if (QLog.isColorLevel()) {
                QLog.i("CameraProxy", 2, "[handleMessage]CAMERA2_SET_PARAMS,wantedSize = " + localObject5 + " , viewSize = " + localObject8 + ",resolutionMode:" + bool1);
              }
              localObject3 = (azdp)this.a.jdField_b_of_type_JavaUtilMap.get(localObject6);
              if (localObject3 == null)
              {
                localObject3 = new azdp();
                this.a.jdField_b_of_type_JavaUtilMap.put(localObject6, localObject3);
                if (!((azdp)localObject3).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
                {
                  localObject6 = Camera2Control.a().a();
                  if (!bool1) {}
                  for (localObject5 = azbl.a(((azda)localObject5).jdField_a_of_type_Int, ((azda)localObject5).jdField_b_of_type_Int, ((azda)localObject8).jdField_a_of_type_Int, ((azda)localObject8).jdField_b_of_type_Int, (azbf)localObject6);; localObject5 = azbl.b(((azda)localObject5).jdField_a_of_type_Int, ((azda)localObject5).jdField_b_of_type_Int, ((azda)localObject8).jdField_a_of_type_Int, ((azda)localObject8).jdField_b_of_type_Int, (azbf)localObject6))
                  {
                    if ((localObject5 == null) || (localObject5.length < 2)) {
                      break label5309;
                    }
                    localObject6 = localObject5[0];
                    localObject5 = localObject5[1];
                    localObject8 = new azda(Math.max(((azda)localObject8).jdField_a_of_type_Int, ((azda)localObject8).jdField_b_of_type_Int), Math.min(((azda)localObject8).jdField_a_of_type_Int, ((azda)localObject8).jdField_b_of_type_Int));
                    localObject8 = Camera2Control.a().a((azda)localObject8);
                    if (Camera2Control.a().a((azda)localObject6)) {
                      break;
                    }
                    this.a.jdField_a_of_type_Azdl.a(14, new Object[] { "[Camera2]setCamera2 previewSize error!" });
                    azdr.a(paramMessage);
                    return;
                  }
                  if (!Camera2Control.a().b((azda)localObject5))
                  {
                    this.a.jdField_a_of_type_Azdl.a(14, new Object[] { "[Camera2]setCamera2 pictureSize error!" });
                    azdr.a(paramMessage);
                    return;
                  }
                  if (!Camera2Control.a().a(((Integer)localObject7[3]).intValue()))
                  {
                    this.a.jdField_a_of_type_Azdl.a(14, new Object[] { "[Camera2]setCamera2 fps error!" });
                    azdr.a(paramMessage);
                    return;
                  }
                  ((azdp)localObject3).jdField_a_of_type_Azda = ((azda)localObject6);
                  ((azdp)localObject3).jdField_b_of_type_Azda = ((azda)localObject5);
                  ((azdp)localObject3).c = ((azda)localObject8);
                  ((azdp)localObject3).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true);
                }
                while (Camera2Control.a().a((azdp)localObject3))
                {
                  localObject3 = Camera2Control.a().b();
                  localObject5 = Camera2Control.a().a();
                  this.a.jdField_a_of_type_Azdl.a(14, new Object[] { localObject3, localObject5 });
                  break;
                }
                this.a.jdField_a_of_type_Azdl.a(14, new Object[] { "[Camera2]setCamera2ParamOnce error!" });
                azdr.a(paramMessage);
                return;
                if (QLog.isColorLevel()) {
                  QLog.i("CameraProxy", 2, "[handleMessage]CAMERA2_PICTURE_TAKE");
                }
                localObject3 = (azdq)paramMessage.obj;
                if (((azdq)localObject3).jdField_a_of_type_JavaIoFile == null)
                {
                  this.a.jdField_a_of_type_Azdl.a(2, new Object[] { "take picture error" });
                  azdr.a(paramMessage);
                  return;
                }
                localObject5 = new azbh();
                ((azbh)localObject5).jdField_a_of_type_Ajrs = ((azdq)localObject3).jdField_a_of_type_Ajrs;
                ((azbh)localObject5).jdField_a_of_type_Boolean = ((azdq)localObject3).jdField_a_of_type_Boolean;
                ((azbh)localObject5).jdField_a_of_type_Int = ((azdq)localObject3).jdField_a_of_type_Int;
                ((azbh)localObject5).jdField_a_of_type_JavaIoFile = ((azdq)localObject3).jdField_a_of_type_JavaIoFile;
                ((azbh)localObject5).jdField_a_of_type_AndroidGraphicsRect = ((azdq)localObject3).jdField_a_of_type_AndroidGraphicsRect;
                Camera2Control.a().a((azbh)localObject5);
                break;
                if (QLog.isColorLevel()) {
                  QLog.i("CameraProxy", 2, "[handleMessage]CAMERA2_STOP_VIDEO");
                }
                Camera2Control.a().c();
                break;
                localObject3 = (azdn)paramMessage.obj;
                Camera2Control.a().a((azdn)localObject3);
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
                azbl.a(2, "[Camera2] error:" + paramMessage.arg1);
                blfg.d("CameraProxy", "【Camera2 Open Error】CAMERA2_ERROR_CALLBACK:" + paramMessage.arg1);
                i = paramMessage.arg1;
                switch (i)
                {
                case -203: 
                case -202: 
                case -201: 
                  this.a.jdField_a_of_type_Azdl.a(14, new Object[] { "[Camera2]setCamera2 previewSize error:" + i });
                  break;
                case -105: 
                case -102: 
                  this.a.jdField_a_of_type_Azdl.a(13, new Object[] { Integer.valueOf(i) });
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
    azcx.a().a(paramCamera);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azdi
 * JD-Core Version:    0.7.0.1
 */