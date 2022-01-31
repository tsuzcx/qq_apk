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

public class azhr
  extends Handler
  implements Camera.AutoFocusCallback
{
  azhr(azho paramazho, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  @TargetApi(14)
  private void a(Rect paramRect1, Rect paramRect2, Camera.AutoFocusCallback paramAutoFocusCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_REQUEST_FOCUS");
    }
    Camera.Parameters localParameters = azhg.a().a();
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
      azhg.a().jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters);
    }
    paramRect1 = paramAutoFocusCallback;
    if (paramAutoFocusCallback == null) {
      paramRect1 = new azhs(this);
    }
    azhg.a().a(paramRect1);
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
        bljn.b("CameraProxy", "[handleMessage] OPEN_CAMERA + BEGIN");
        i = ((Integer)((Object[])(Object[])paramMessage.obj)[0]).intValue();
        if (QLog.isColorLevel()) {
          QLog.i("CameraProxy", 2, "[handleMessage] OPEN_CAMERA");
        }
        i = azhg.a().a(i);
        bljn.b("CameraProxy", "[handleMessage] OPEN_CAMERA, result = " + i);
        if (i == 5)
        {
          this.a.jdField_a_of_type_Azhu.a(1, new Object[] { Boolean.valueOf(true) });
          return;
        }
        if (i != 0)
        {
          this.a.jdField_a_of_type_Azhu.a(1, new Object[] { "open camera failed:errcode=" + azhg.a(i) });
          return;
        }
        if (!azhg.a().c())
        {
          this.a.jdField_a_of_type_Azhu.a(1, new Object[] { "open camera failed, orientation error." });
          return;
        }
        this.a.jdField_a_of_type_Azhu.a(1, new Object[] { Boolean.valueOf(true) });
        this.a.jdField_a_of_type_Boolean = false;
        return;
        if (QLog.isColorLevel()) {
          QLog.i("CameraProxy", 2, "[handleMessage]CHANGED");
        }
        int k = Integer.parseInt(paramMessage.obj.toString());
        i = paramMessage.arg1;
        j = paramMessage.arg2;
        this.a.jdField_a_of_type_Boolean = false;
        azho.a(this.a, false);
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
        localObject7 = azhg.a();
        if (Build.VERSION.SDK_INT <= 10) {
          azhg.a().b();
        }
        if (this.a.jdField_a_of_type_Int == 1)
        {
          localObject1 = this.a.jdField_a_of_type_Azhx;
          if (((azhx)localObject1).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
            continue;
          }
          if (!azhg.a().e()) {
            this.a.jdField_a_of_type_Azhu.a(2, new Object[] { "set preview format failed" });
          }
        }
        else
        {
          if (this.a.jdField_a_of_type_Int == 3)
          {
            if (ajpx.jdField_a_of_type_Int == 1)
            {
              localObject1 = this.a.jdField_c_of_type_Azhx;
              continue;
            }
            if (ajpx.jdField_a_of_type_Int == 2)
            {
              localObject1 = this.a.jdField_b_of_type_Azhx;
              continue;
            }
            this.a.jdField_a_of_type_Azhu.a(2, new Object[] { "set preview format failed[Camera Kind error:PROGNOSIS_FULL_FILTER]" });
            return;
          }
          if (this.a.jdField_a_of_type_Int == 2)
          {
            if (ajpx.jdField_a_of_type_Int == 1)
            {
              localObject1 = this.a.e;
              continue;
            }
            if (ajpx.jdField_a_of_type_Int == 2)
            {
              localObject1 = this.a.d;
              continue;
            }
            this.a.jdField_a_of_type_Azhu.a(2, new Object[] { "set preview format failed[Camera Kind error:RATIO_SCREEN]" });
            return;
          }
          if (this.a.jdField_a_of_type_Int == 4)
          {
            if (ajpx.jdField_a_of_type_Int == 1)
            {
              localObject1 = this.a.g;
              continue;
            }
            if (ajpx.jdField_a_of_type_Int == 2)
            {
              localObject1 = this.a.f;
              continue;
            }
            this.a.jdField_a_of_type_Azhu.a(2, new Object[] { "set preview format failed[Camera Kind error:PROGNOSIS_FULL_FILTER]" });
            return;
          }
          if (this.a.jdField_a_of_type_Int == 5)
          {
            localObject1 = this.a.h;
            continue;
          }
          this.a.jdField_a_of_type_Azhu.a(2, new Object[] { "set preview format failed[Preview Selector Error]" });
          return;
        }
        localObject6 = null;
        if ((this.a.jdField_a_of_type_Int == 1) || (this.a.jdField_a_of_type_Int == 3) || (this.a.jdField_a_of_type_Int == 4))
        {
          localObject6 = ((azhg)localObject7).c(azib.j, azib.k, this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int);
          localObject5 = localObject6[0];
          localObject6 = localObject6[1];
          if (localObject5 == null) {
            break label5330;
          }
          bool1 = azhg.a().a((azhj)localObject5);
          break label5342;
          if (!bool1) {
            this.a.jdField_a_of_type_Azhu.a(2, new Object[] { "set preview size failed" + (String)localObject5 });
          }
        }
        else
        {
          if (this.a.jdField_a_of_type_Int == 2)
          {
            localObject5 = ((azhg)localObject7).a(azib.j, azib.k, i, j);
            bool1 = bool4;
            if (localObject5 == null) {
              break label5350;
            }
            bool1 = azhg.a().a((azhj)localObject5);
            break label5350;
          }
          if (this.a.jdField_a_of_type_Int != 5) {
            break label5366;
          }
          if ((Build.MANUFACTURER.equals("Xiaomi")) && (Build.MODEL.equals("MI 3")))
          {
            localObject5 = new azhj();
            ((azhj)localObject5).jdField_a_of_type_Int = 640;
            ((azhj)localObject5).jdField_b_of_type_Int = 480;
            bool1 = bool5;
            if (localObject5 == null) {
              break label5358;
            }
            bool1 = azhg.a().a((azhj)localObject5);
            break label5358;
          }
          localObject5 = ((azhg)localObject7).a(480);
          continue;
        }
        if (!azhg.a().a(azib.g))
        {
          this.a.jdField_a_of_type_Azhu.a(2, new Object[] { "set preview fps failed" });
          return;
        }
        if ((this.a.jdField_a_of_type_Int != 1) && (this.a.jdField_a_of_type_Int != 4) && (this.a.jdField_a_of_type_Int != 5) && (localObject6 != null) && (!((azhg)localObject7).b((azhj)localObject6))) {}
        ((azhx)localObject1).jdField_a_of_type_Int = azhg.a().a();
        ((azhx)localObject1).jdField_a_of_type_Azhj = azhg.a().a();
        localObject5 = azhg.a().b();
        if (localObject5 != null)
        {
          ((azhx)localObject1).jdField_b_of_type_Azhj = ((azhj)localObject5);
          ((azhx)localObject1).jdField_a_of_type_Boolean = true;
        }
        localObject5 = azhg.a().a();
        ((azhx)localObject1).jdField_b_of_type_Int = localObject5[0];
        ((azhx)localObject1).jdField_c_of_type_Int = localObject5[1];
        if ((this.a.jdField_a_of_type_Int != 1) && (this.a.jdField_a_of_type_Int != 3) && (this.a.jdField_a_of_type_Int != 4) && (this.a.jdField_a_of_type_Int != 5))
        {
          ((azhx)localObject1).jdField_b_of_type_Azhj = azhg.a().b();
          ((azhx)localObject1).jdField_a_of_type_Boolean = true;
        }
        if (this.a.jdField_a_of_type_Int == 4) {
          ((azhx)localObject1).jdField_a_of_type_Boolean = false;
        }
        ((azhx)localObject1).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true);
        Object localObject1 = a();
        if ((!azhg.a().a((String)localObject1)) && (!azhg.a().a("auto")) && (!azhg.a().a(this))) {
          this.a.jdField_a_of_type_Azhu.a(9, new Object[] { alud.a(2131701715) });
        }
        if (!azhg.a().c())
        {
          this.a.jdField_a_of_type_Azhu.a(2, new Object[] { "set display orientation failed" });
          return;
          if (!azhg.a().a((azhx)localObject1))
          {
            this.a.jdField_a_of_type_Azhu.a(2, new Object[] { "set Camera Params failed" });
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
        azia.a(paramMessage);
      }
      Object localObject3 = azhg.a().a();
      int i = azhg.a().a();
      Object localObject5 = azhg.a().a();
      this.a.jdField_a_of_type_Azhu.a(2, new Object[] { localObject5, Integer.valueOf(i), localObject3 });
      continue;
      localObject3 = (Object[])paramMessage.obj;
      localObject5 = (azhj)localObject3[0];
      Object localObject7 = (azhj)localObject3[1];
      i = ((Integer)localObject3[2]).intValue();
      int j = ((Integer)localObject3[3]).intValue();
      bool2 = ((Boolean)localObject3[4]).booleanValue();
      if (QLog.isColorLevel()) {
        QLog.i("CameraProxy", 2, "[handleMessage] SET_PARAMS, , wantedSize = " + localObject5 + " , viewSize = " + localObject7 + " , selectMode = " + i + " , resolutionMode = " + bool2);
      }
      this.a.jdField_a_of_type_Boolean = false;
      azho.a(this.a, false);
      Object localObject6 = azhg.a();
      Object localObject8 = azhg.a().jdField_a_of_type_Int + "#" + localObject5 + "#" + localObject7 + "#" + i;
      localObject3 = (azhx)this.a.jdField_a_of_type_JavaUtilMap.get(localObject8);
      if (localObject3 == null)
      {
        localObject3 = new azhx();
        this.a.jdField_a_of_type_JavaUtilMap.put(localObject8, localObject3);
      }
      for (;;)
      {
        for (;;)
        {
          if (!((azhx)localObject3).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
          {
            if (!azhg.a().e())
            {
              this.a.jdField_a_of_type_Azhu.a(2, new Object[] { "set preview format failed" });
              azia.a(paramMessage);
              return;
            }
            if (!bool2) {}
            for (localObject5 = ((azhg)localObject6).a(((azhj)localObject5).jdField_a_of_type_Int, ((azhj)localObject5).jdField_b_of_type_Int, ((azhj)localObject7).jdField_a_of_type_Int, ((azhj)localObject7).jdField_b_of_type_Int);; localObject5 = ((azhg)localObject6).b(((azhj)localObject5).jdField_a_of_type_Int, ((azhj)localObject5).jdField_b_of_type_Int, ((azhj)localObject7).jdField_a_of_type_Int, ((azhj)localObject7).jdField_b_of_type_Int))
            {
              localObject7 = localObject5[0];
              localObject5 = localObject5[1];
              if (localObject7 != null) {
                bool1 = azhg.a().a((azhj)localObject7);
              }
              if (bool1) {
                break;
              }
              this.a.jdField_a_of_type_Azhu.a(2, new Object[] { "set preview size failed" + "" });
              azia.a(paramMessage);
              return;
            }
            if (((localObject5 == null) || (((azhg)localObject6).b((azhj)localObject5))) || (!azhg.a().a(j)))
            {
              this.a.jdField_a_of_type_Azhu.a(2, new Object[] { "set preview fps failed" });
              azia.a(paramMessage);
              return;
            }
            ((azhx)localObject3).jdField_a_of_type_Int = azhg.a().a();
            ((azhx)localObject3).jdField_a_of_type_Azhj = azhg.a().a();
            localObject5 = azhg.a().b();
            if (localObject5 != null)
            {
              ((azhx)localObject3).jdField_b_of_type_Azhj = ((azhj)localObject5);
              ((azhx)localObject3).jdField_a_of_type_Boolean = true;
            }
            localObject5 = azhg.a().a();
            ((azhx)localObject3).jdField_b_of_type_Int = localObject5[0];
            ((azhx)localObject3).jdField_c_of_type_Int = localObject5[1];
            ((azhx)localObject3).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true);
          }
          for (;;)
          {
            localObject3 = a();
            if ((!azhg.a().a((String)localObject3)) && (!azhg.a().a("auto")) && (!azhg.a().a(this))) {
              this.a.jdField_a_of_type_Azhu.a(9, new Object[] { alud.a(2131701712) });
            }
            if (azhg.a().c()) {
              break;
            }
            this.a.jdField_a_of_type_Azhu.a(2, new Object[] { "set display orientation failed" });
            azia.a(paramMessage);
            return;
            if (!azhg.a().a((azhx)localObject3))
            {
              this.a.jdField_a_of_type_Azhu.a(2, new Object[] { "set Camera Params failed" });
              azia.a(paramMessage);
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage] Set camera param by cache params");
            }
          }
          localObject3 = azhg.a().a();
          i = azhg.a().a();
          localObject5 = azhg.a().a();
          this.a.jdField_a_of_type_Azhu.a(2, new Object[] { localObject5, Integer.valueOf(i), localObject3 });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_DEFAULT");
          }
          localObject3 = a();
          if ((azhg.a().a((String)localObject3)) || (azhg.a().a("auto")) || (azhg.a().a(this))) {
            break;
          }
          this.a.jdField_a_of_type_Azhu.a(9, new Object[] { alud.a(2131701714) });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_AUTO");
          }
          if (azhg.a().a("auto")) {
            break;
          }
          this.a.jdField_a_of_type_Azhu.a(9, new Object[] { alud.a(2131701713) });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_RECORDING");
          }
          localObject3 = b();
          if (azhg.a().a((String)localObject3)) {
            break;
          }
          this.a.jdField_a_of_type_Azhu.a(9, new Object[] { alud.a(2131701708) });
          break;
          localObject3 = (azhw)paramMessage.obj;
          a(((azhw)localObject3).jdField_a_of_type_AndroidGraphicsRect, ((azhw)localObject3).b, ((azhw)localObject3).jdField_a_of_type_AndroidHardwareCamera$AutoFocusCallback);
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_SET_SURFACE");
          }
          localObject3 = (SurfaceTexture)paramMessage.obj;
          if (azhg.a().a((SurfaceTexture)localObject3)) {
            break;
          }
          this.a.jdField_a_of_type_Azhu.a(2, new Object[] { "set preview texture failed" });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_SET_SURFACE_HOLDER");
          }
          localObject3 = (SurfaceHolder)paramMessage.obj;
          if (azhg.a().a((SurfaceHolder)localObject3)) {
            break;
          }
          this.a.jdField_a_of_type_Azhu.a(2, new Object[] { "set surface holder failed" });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_SET_CALLBACK");
          }
          localObject3 = (Camera.PreviewCallback)paramMessage.obj;
          bool1 = bool3;
          if (paramMessage.arg1 > 0) {
            bool1 = true;
          }
          if (azhg.a().a((Camera.PreviewCallback)localObject3, bool1)) {
            break;
          }
          this.a.jdField_a_of_type_Azhu.a(2, new Object[] { "set preview callback failed" });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_START");
          }
          if (!azhg.a().a())
          {
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_START error");
            }
            bljn.b("CameraProxy", "[handleMessage] PREVIEW_START");
            this.a.jdField_a_of_type_Azhu.a(3, new Object[] { "start preview failed" });
            break;
          }
          localObject3 = azhg.a();
          if (((azhg)localObject3).jdField_a_of_type_Int != 1) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_START, cameraId = " + ((azhg)localObject3).jdField_a_of_type_Int);
          }
          bljn.b("CameraProxy", "【Camera 】PREVIEW_START success cameraID:" + ((azhg)localObject3).jdField_a_of_type_Int);
          if ((!((azhg)localObject3).d()) || (azho.a(this.a) == null)) {
            break;
          }
          QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_START, startFaceDetection");
          ((azhg)localObject3).a(azho.a(this.a));
          ((azhg)localObject3).c();
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]FACE_DETECT_SWITCH" + paramMessage.arg1);
          }
          localObject3 = azhg.a();
          if ((!((azhg)localObject3).d()) || (azho.a(this.a) == null)) {
            break;
          }
          if (paramMessage.arg1 == 1)
          {
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]FACE_DETECT_SWITCH " + ((azhg)localObject3).jdField_a_of_type_Int);
            }
            if (((azhg)localObject3).jdField_a_of_type_Int != 1) {
              break;
            }
            ((azhg)localObject3).a(azho.a(this.a));
            ((azhg)localObject3).c();
            break;
          }
          if (paramMessage.arg1 != 2) {
            break;
          }
          ((azhg)localObject3).d();
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_STOP");
          }
          bljn.b("CameraProxy", "【Camera】PREVIEW_STOP success");
          if (!azhg.a().b())
          {
            this.a.jdField_a_of_type_Azhu.a(4, new Object[] { "stop preview failed" });
            break;
          }
          localObject3 = azhg.a();
          if ((!((azhg)localObject3).d()) || (azho.a(this.a) == null)) {
            break;
          }
          ((azhg)localObject3).d();
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]RELEASE");
          }
          azhg.a().b();
          this.a.jdField_a_of_type_Boolean = true;
          try
          {
            Thread.sleep(50L);
            bljn.b("CameraProxy", "【Camera】RELEASE success");
            this.a.jdField_a_of_type_Azhu.a(11, new Object[] { "camera destory" });
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]NIGHT_MODE_ON_OFF" + paramMessage.arg1);
            }
            if (paramMessage.arg1 == 1)
            {
              azho.a(this.a);
              break;
            }
            if (paramMessage.arg1 != 2) {
              break;
            }
            azho.b(this.a);
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]FLASH_LIGHT_ON_OFF");
            }
            if (paramMessage.arg1 == 1)
            {
              if (azhg.a().a(true)) {
                break;
              }
              this.a.jdField_a_of_type_Azhu.a(6, new Object[] { "turn on flash light failed" });
              break;
            }
            if ((paramMessage.arg1 != 2) || (azhg.a().a(false))) {
              break;
            }
            this.a.jdField_a_of_type_Azhu.a(6, new Object[] { "turn off flash light failed" });
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]FLASH_LIGHT_SWITCH");
            }
            if (paramMessage.arg1 == 0)
            {
              if (azhg.a().f()) {
                break;
              }
              this.a.jdField_a_of_type_Azhu.a(6, new Object[] { "switch flash light failed" });
              break;
            }
            if (paramMessage.arg1 == 1)
            {
              if (azhg.a().b(true)) {
                break;
              }
              this.a.jdField_a_of_type_Azhu.a(6, new Object[] { "turn on flash light failed" });
              break;
            }
            if ((paramMessage.arg1 != 2) || (azhg.a().b(false))) {
              break;
            }
            this.a.jdField_a_of_type_Azhu.a(6, new Object[] { "turn off flash light failed" });
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]PICTURE_TAKE");
            }
            ajrw.a("received");
            localObject3 = (azhz)paramMessage.obj;
            localObject5 = azhg.a();
            if (!((azhg)localObject5).jdField_a_of_type_Boolean)
            {
              if (QLog.isColorLevel()) {
                QLog.i("CameraProxy", 2, "[takePicture]Camera is not previewing...");
              }
              azia.a(paramMessage);
              return;
            }
            if (((azhz)localObject3).jdField_a_of_type_JavaIoFile == null)
            {
              this.a.jdField_a_of_type_Azhu.a(2, new Object[] { "take picture error" });
              azia.a(paramMessage);
              return;
            }
            ((azhg)localObject5).a(((azhz)localObject3).jdField_a_of_type_JavaIoFile, ((azhz)localObject3).jdField_a_of_type_AndroidGraphicsRect, ((azhz)localObject3).jdField_a_of_type_Ajwh, ((azhz)localObject3).jdField_a_of_type_Int, ((azhz)localObject3).jdField_a_of_type_Boolean, ((azhz)localObject3).jdField_b_of_type_Int);
            break;
            i = ((Integer)((Object[])(Object[])paramMessage.obj)[0]).intValue();
            azhg.a().b(i);
            break;
            localObject3 = (String)((Object[])(Object[])paramMessage.obj)[0];
            azhg.a().b((String)localObject3);
            break;
            bljn.b("CameraProxy", "camera2 open in.");
            localObject3 = (Object[])paramMessage.obj;
            i = ((Integer)localObject3[0]).intValue();
            if ((localObject3[1] instanceof azfp))
            {
              localObject3 = (azfp)localObject3[1];
              if (Camera2Control.a().b())
              {
                azfu.a(1, "[Camera2] camera2 is opening!");
                azia.a(paramMessage);
                return;
              }
              i = Camera2Control.a().a(i, (azfp)localObject3);
              if (i == 0) {
                break;
              }
              bljn.d("CameraProxy", "【Camera2 Open Error】EVENT_CAMERA2_ERROR:" + i);
              this.a.jdField_a_of_type_Azhu.a(13, new Object[] { Integer.valueOf(i) });
              break;
              localObject3 = (SurfaceTexture)((Object[])(Object[])paramMessage.obj)[0];
              Camera2Control.a().a((SurfaceTexture)localObject3);
              bljn.b("CameraProxy", "【Camera2】PREVIEW_START");
              break;
              localObject3 = (Camera.PreviewCallback)((Object[])(Object[])paramMessage.obj)[0];
              Camera2Control.a().a((Camera.PreviewCallback)localObject3);
              break;
              Camera2Control.a().e();
              bljn.b("CameraProxy", "【Camera2】CAMERA2_RELEASE");
              break;
              localObject7 = (Object[])paramMessage.obj;
              localObject5 = (azhj)localObject7[0];
              localObject8 = (azhj)localObject7[1];
              bool1 = ((Boolean)localObject7[4]).booleanValue();
              localObject3 = new StringBuilder();
              Camera2Control.a();
              localObject6 = Camera2Control.a + "#" + localObject5 + "#" + localObject8;
              if (QLog.isColorLevel()) {
                QLog.i("CameraProxy", 2, "[handleMessage]CAMERA2_SET_PARAMS,wantedSize = " + localObject5 + " , viewSize = " + localObject8 + ",resolutionMode:" + bool1);
              }
              localObject3 = (azhy)this.a.jdField_b_of_type_JavaUtilMap.get(localObject6);
              if (localObject3 == null)
              {
                localObject3 = new azhy();
                this.a.jdField_b_of_type_JavaUtilMap.put(localObject6, localObject3);
                if (!((azhy)localObject3).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
                {
                  localObject6 = Camera2Control.a().a();
                  if (!bool1) {}
                  for (localObject5 = azfu.a(((azhj)localObject5).jdField_a_of_type_Int, ((azhj)localObject5).jdField_b_of_type_Int, ((azhj)localObject8).jdField_a_of_type_Int, ((azhj)localObject8).jdField_b_of_type_Int, (azfo)localObject6);; localObject5 = azfu.b(((azhj)localObject5).jdField_a_of_type_Int, ((azhj)localObject5).jdField_b_of_type_Int, ((azhj)localObject8).jdField_a_of_type_Int, ((azhj)localObject8).jdField_b_of_type_Int, (azfo)localObject6))
                  {
                    if ((localObject5 == null) || (localObject5.length < 2)) {
                      break label5309;
                    }
                    localObject6 = localObject5[0];
                    localObject5 = localObject5[1];
                    localObject8 = new azhj(Math.max(((azhj)localObject8).jdField_a_of_type_Int, ((azhj)localObject8).jdField_b_of_type_Int), Math.min(((azhj)localObject8).jdField_a_of_type_Int, ((azhj)localObject8).jdField_b_of_type_Int));
                    localObject8 = Camera2Control.a().a((azhj)localObject8);
                    if (Camera2Control.a().a((azhj)localObject6)) {
                      break;
                    }
                    this.a.jdField_a_of_type_Azhu.a(14, new Object[] { "[Camera2]setCamera2 previewSize error!" });
                    azia.a(paramMessage);
                    return;
                  }
                  if (!Camera2Control.a().b((azhj)localObject5))
                  {
                    this.a.jdField_a_of_type_Azhu.a(14, new Object[] { "[Camera2]setCamera2 pictureSize error!" });
                    azia.a(paramMessage);
                    return;
                  }
                  if (!Camera2Control.a().a(((Integer)localObject7[3]).intValue()))
                  {
                    this.a.jdField_a_of_type_Azhu.a(14, new Object[] { "[Camera2]setCamera2 fps error!" });
                    azia.a(paramMessage);
                    return;
                  }
                  ((azhy)localObject3).jdField_a_of_type_Azhj = ((azhj)localObject6);
                  ((azhy)localObject3).jdField_b_of_type_Azhj = ((azhj)localObject5);
                  ((azhy)localObject3).c = ((azhj)localObject8);
                  ((azhy)localObject3).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true);
                }
                while (Camera2Control.a().a((azhy)localObject3))
                {
                  localObject3 = Camera2Control.a().b();
                  localObject5 = Camera2Control.a().a();
                  this.a.jdField_a_of_type_Azhu.a(14, new Object[] { localObject3, localObject5 });
                  break;
                }
                this.a.jdField_a_of_type_Azhu.a(14, new Object[] { "[Camera2]setCamera2ParamOnce error!" });
                azia.a(paramMessage);
                return;
                if (QLog.isColorLevel()) {
                  QLog.i("CameraProxy", 2, "[handleMessage]CAMERA2_PICTURE_TAKE");
                }
                localObject3 = (azhz)paramMessage.obj;
                if (((azhz)localObject3).jdField_a_of_type_JavaIoFile == null)
                {
                  this.a.jdField_a_of_type_Azhu.a(2, new Object[] { "take picture error" });
                  azia.a(paramMessage);
                  return;
                }
                localObject5 = new azfq();
                ((azfq)localObject5).jdField_a_of_type_Ajwh = ((azhz)localObject3).jdField_a_of_type_Ajwh;
                ((azfq)localObject5).jdField_a_of_type_Boolean = ((azhz)localObject3).jdField_a_of_type_Boolean;
                ((azfq)localObject5).jdField_a_of_type_Int = ((azhz)localObject3).jdField_a_of_type_Int;
                ((azfq)localObject5).jdField_a_of_type_JavaIoFile = ((azhz)localObject3).jdField_a_of_type_JavaIoFile;
                ((azfq)localObject5).jdField_a_of_type_AndroidGraphicsRect = ((azhz)localObject3).jdField_a_of_type_AndroidGraphicsRect;
                Camera2Control.a().a((azfq)localObject5);
                break;
                if (QLog.isColorLevel()) {
                  QLog.i("CameraProxy", 2, "[handleMessage]CAMERA2_STOP_VIDEO");
                }
                Camera2Control.a().c();
                break;
                localObject3 = (azhw)paramMessage.obj;
                Camera2Control.a().a((azhw)localObject3);
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
                azfu.a(2, "[Camera2] error:" + paramMessage.arg1);
                bljn.d("CameraProxy", "【Camera2 Open Error】CAMERA2_ERROR_CALLBACK:" + paramMessage.arg1);
                i = paramMessage.arg1;
                switch (i)
                {
                case -203: 
                case -202: 
                case -201: 
                  this.a.jdField_a_of_type_Azhu.a(14, new Object[] { "[Camera2]setCamera2 previewSize error:" + i });
                  break;
                case -105: 
                case -102: 
                  this.a.jdField_a_of_type_Azhu.a(13, new Object[] { Integer.valueOf(i) });
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
    azhg.a().a(paramCamera);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azhr
 * JD-Core Version:    0.7.0.1
 */