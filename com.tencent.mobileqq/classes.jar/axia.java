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

public class axia
  extends Handler
  implements Camera.AutoFocusCallback
{
  axia(axhx paramaxhx, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  @TargetApi(14)
  private void a(Rect paramRect1, Rect paramRect2, Camera.AutoFocusCallback paramAutoFocusCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_REQUEST_FOCUS");
    }
    Camera.Parameters localParameters = axhp.a().a();
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
      axhp.a().jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters);
    }
    paramRect1 = paramAutoFocusCallback;
    if (paramAutoFocusCallback == null) {
      paramRect1 = new axib(this);
    }
    axhp.a().a(paramRect1);
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
        bizq.b("CameraProxy", "[handleMessage] OPEN_CAMERA + BEGIN");
        i = ((Integer)((Object[])(Object[])paramMessage.obj)[0]).intValue();
        if (QLog.isColorLevel()) {
          QLog.i("CameraProxy", 2, "[handleMessage] OPEN_CAMERA");
        }
        i = axhp.a().a(i);
        bizq.b("CameraProxy", "[handleMessage] OPEN_CAMERA, result = " + i);
        if (i == 5)
        {
          this.a.jdField_a_of_type_Axid.a(1, new Object[] { Boolean.valueOf(true) });
          return;
        }
        if (i != 0)
        {
          this.a.jdField_a_of_type_Axid.a(1, new Object[] { "open camera failed:errcode=" + axhp.a(i) });
          return;
        }
        if (!axhp.a().c())
        {
          this.a.jdField_a_of_type_Axid.a(1, new Object[] { "open camera failed, orientation error." });
          return;
        }
        this.a.jdField_a_of_type_Axid.a(1, new Object[] { Boolean.valueOf(true) });
        this.a.jdField_a_of_type_Boolean = false;
        return;
        if (QLog.isColorLevel()) {
          QLog.i("CameraProxy", 2, "[handleMessage]CHANGED");
        }
        int k = Integer.parseInt(paramMessage.obj.toString());
        i = paramMessage.arg1;
        j = paramMessage.arg2;
        this.a.jdField_a_of_type_Boolean = false;
        axhx.a(this.a, false);
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
        localObject7 = axhp.a();
        if (Build.VERSION.SDK_INT <= 10) {
          axhp.a().b();
        }
        if (this.a.jdField_a_of_type_Int == 1)
        {
          localObject1 = this.a.jdField_a_of_type_Axig;
          if (((axig)localObject1).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
            continue;
          }
          if (!axhp.a().e()) {
            this.a.jdField_a_of_type_Axid.a(2, new Object[] { "set preview format failed" });
          }
        }
        else
        {
          if (this.a.jdField_a_of_type_Int == 3)
          {
            if (ahua.jdField_a_of_type_Int == 1)
            {
              localObject1 = this.a.jdField_c_of_type_Axig;
              continue;
            }
            if (ahua.jdField_a_of_type_Int == 2)
            {
              localObject1 = this.a.jdField_b_of_type_Axig;
              continue;
            }
            this.a.jdField_a_of_type_Axid.a(2, new Object[] { "set preview format failed[Camera Kind error:PROGNOSIS_FULL_FILTER]" });
            return;
          }
          if (this.a.jdField_a_of_type_Int == 2)
          {
            if (ahua.jdField_a_of_type_Int == 1)
            {
              localObject1 = this.a.e;
              continue;
            }
            if (ahua.jdField_a_of_type_Int == 2)
            {
              localObject1 = this.a.d;
              continue;
            }
            this.a.jdField_a_of_type_Axid.a(2, new Object[] { "set preview format failed[Camera Kind error:RATIO_SCREEN]" });
            return;
          }
          if (this.a.jdField_a_of_type_Int == 4)
          {
            if (ahua.jdField_a_of_type_Int == 1)
            {
              localObject1 = this.a.g;
              continue;
            }
            if (ahua.jdField_a_of_type_Int == 2)
            {
              localObject1 = this.a.f;
              continue;
            }
            this.a.jdField_a_of_type_Axid.a(2, new Object[] { "set preview format failed[Camera Kind error:PROGNOSIS_FULL_FILTER]" });
            return;
          }
          if (this.a.jdField_a_of_type_Int == 5)
          {
            localObject1 = this.a.h;
            continue;
          }
          this.a.jdField_a_of_type_Axid.a(2, new Object[] { "set preview format failed[Preview Selector Error]" });
          return;
        }
        localObject6 = null;
        if ((this.a.jdField_a_of_type_Int == 1) || (this.a.jdField_a_of_type_Int == 3) || (this.a.jdField_a_of_type_Int == 4))
        {
          localObject6 = ((axhp)localObject7).c(axik.j, axik.k, this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int);
          localObject5 = localObject6[0];
          localObject6 = localObject6[1];
          if (localObject5 == null) {
            break label5330;
          }
          bool1 = axhp.a().a((axhs)localObject5);
          break label5342;
          if (!bool1) {
            this.a.jdField_a_of_type_Axid.a(2, new Object[] { "set preview size failed" + (String)localObject5 });
          }
        }
        else
        {
          if (this.a.jdField_a_of_type_Int == 2)
          {
            localObject5 = ((axhp)localObject7).a(axik.j, axik.k, i, j);
            bool1 = bool4;
            if (localObject5 == null) {
              break label5350;
            }
            bool1 = axhp.a().a((axhs)localObject5);
            break label5350;
          }
          if (this.a.jdField_a_of_type_Int != 5) {
            break label5366;
          }
          if ((Build.MANUFACTURER.equals("Xiaomi")) && (Build.MODEL.equals("MI 3")))
          {
            localObject5 = new axhs();
            ((axhs)localObject5).jdField_a_of_type_Int = 640;
            ((axhs)localObject5).jdField_b_of_type_Int = 480;
            bool1 = bool5;
            if (localObject5 == null) {
              break label5358;
            }
            bool1 = axhp.a().a((axhs)localObject5);
            break label5358;
          }
          localObject5 = ((axhp)localObject7).a(480);
          continue;
        }
        if (!axhp.a().a(axik.g))
        {
          this.a.jdField_a_of_type_Axid.a(2, new Object[] { "set preview fps failed" });
          return;
        }
        if ((this.a.jdField_a_of_type_Int != 1) && (this.a.jdField_a_of_type_Int != 4) && (this.a.jdField_a_of_type_Int != 5) && (localObject6 != null) && (!((axhp)localObject7).b((axhs)localObject6))) {}
        ((axig)localObject1).jdField_a_of_type_Int = axhp.a().a();
        ((axig)localObject1).jdField_a_of_type_Axhs = axhp.a().a();
        localObject5 = axhp.a().b();
        if (localObject5 != null)
        {
          ((axig)localObject1).jdField_b_of_type_Axhs = ((axhs)localObject5);
          ((axig)localObject1).jdField_a_of_type_Boolean = true;
        }
        localObject5 = axhp.a().a();
        ((axig)localObject1).jdField_b_of_type_Int = localObject5[0];
        ((axig)localObject1).jdField_c_of_type_Int = localObject5[1];
        if ((this.a.jdField_a_of_type_Int != 1) && (this.a.jdField_a_of_type_Int != 3) && (this.a.jdField_a_of_type_Int != 4) && (this.a.jdField_a_of_type_Int != 5))
        {
          ((axig)localObject1).jdField_b_of_type_Axhs = axhp.a().b();
          ((axig)localObject1).jdField_a_of_type_Boolean = true;
        }
        if (this.a.jdField_a_of_type_Int == 4) {
          ((axig)localObject1).jdField_a_of_type_Boolean = false;
        }
        ((axig)localObject1).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true);
        Object localObject1 = a();
        if ((!axhp.a().a((String)localObject1)) && (!axhp.a().a("auto")) && (!axhp.a().a(this))) {
          this.a.jdField_a_of_type_Axid.a(9, new Object[] { ajyc.a(2131701319) });
        }
        if (!axhp.a().c())
        {
          this.a.jdField_a_of_type_Axid.a(2, new Object[] { "set display orientation failed" });
          return;
          if (!axhp.a().a((axig)localObject1))
          {
            this.a.jdField_a_of_type_Axid.a(2, new Object[] { "set Camera Params failed" });
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
        axij.a(paramMessage);
      }
      Object localObject3 = axhp.a().a();
      int i = axhp.a().a();
      Object localObject5 = axhp.a().a();
      this.a.jdField_a_of_type_Axid.a(2, new Object[] { localObject5, Integer.valueOf(i), localObject3 });
      continue;
      localObject3 = (Object[])paramMessage.obj;
      localObject5 = (axhs)localObject3[0];
      Object localObject7 = (axhs)localObject3[1];
      i = ((Integer)localObject3[2]).intValue();
      int j = ((Integer)localObject3[3]).intValue();
      bool2 = ((Boolean)localObject3[4]).booleanValue();
      if (QLog.isColorLevel()) {
        QLog.i("CameraProxy", 2, "[handleMessage] SET_PARAMS, , wantedSize = " + localObject5 + " , viewSize = " + localObject7 + " , selectMode = " + i + " , resolutionMode = " + bool2);
      }
      this.a.jdField_a_of_type_Boolean = false;
      axhx.a(this.a, false);
      Object localObject6 = axhp.a();
      Object localObject8 = axhp.a().jdField_a_of_type_Int + "#" + localObject5 + "#" + localObject7 + "#" + i;
      localObject3 = (axig)this.a.jdField_a_of_type_JavaUtilMap.get(localObject8);
      if (localObject3 == null)
      {
        localObject3 = new axig();
        this.a.jdField_a_of_type_JavaUtilMap.put(localObject8, localObject3);
      }
      for (;;)
      {
        for (;;)
        {
          if (!((axig)localObject3).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
          {
            if (!axhp.a().e())
            {
              this.a.jdField_a_of_type_Axid.a(2, new Object[] { "set preview format failed" });
              axij.a(paramMessage);
              return;
            }
            if (!bool2) {}
            for (localObject5 = ((axhp)localObject6).a(((axhs)localObject5).jdField_a_of_type_Int, ((axhs)localObject5).jdField_b_of_type_Int, ((axhs)localObject7).jdField_a_of_type_Int, ((axhs)localObject7).jdField_b_of_type_Int);; localObject5 = ((axhp)localObject6).b(((axhs)localObject5).jdField_a_of_type_Int, ((axhs)localObject5).jdField_b_of_type_Int, ((axhs)localObject7).jdField_a_of_type_Int, ((axhs)localObject7).jdField_b_of_type_Int))
            {
              localObject7 = localObject5[0];
              localObject5 = localObject5[1];
              if (localObject7 != null) {
                bool1 = axhp.a().a((axhs)localObject7);
              }
              if (bool1) {
                break;
              }
              this.a.jdField_a_of_type_Axid.a(2, new Object[] { "set preview size failed" + "" });
              axij.a(paramMessage);
              return;
            }
            if (((localObject5 == null) || (((axhp)localObject6).b((axhs)localObject5))) || (!axhp.a().a(j)))
            {
              this.a.jdField_a_of_type_Axid.a(2, new Object[] { "set preview fps failed" });
              axij.a(paramMessage);
              return;
            }
            ((axig)localObject3).jdField_a_of_type_Int = axhp.a().a();
            ((axig)localObject3).jdField_a_of_type_Axhs = axhp.a().a();
            localObject5 = axhp.a().b();
            if (localObject5 != null)
            {
              ((axig)localObject3).jdField_b_of_type_Axhs = ((axhs)localObject5);
              ((axig)localObject3).jdField_a_of_type_Boolean = true;
            }
            localObject5 = axhp.a().a();
            ((axig)localObject3).jdField_b_of_type_Int = localObject5[0];
            ((axig)localObject3).jdField_c_of_type_Int = localObject5[1];
            ((axig)localObject3).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true);
          }
          for (;;)
          {
            localObject3 = a();
            if ((!axhp.a().a((String)localObject3)) && (!axhp.a().a("auto")) && (!axhp.a().a(this))) {
              this.a.jdField_a_of_type_Axid.a(9, new Object[] { ajyc.a(2131701316) });
            }
            if (axhp.a().c()) {
              break;
            }
            this.a.jdField_a_of_type_Axid.a(2, new Object[] { "set display orientation failed" });
            axij.a(paramMessage);
            return;
            if (!axhp.a().a((axig)localObject3))
            {
              this.a.jdField_a_of_type_Axid.a(2, new Object[] { "set Camera Params failed" });
              axij.a(paramMessage);
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage] Set camera param by cache params");
            }
          }
          localObject3 = axhp.a().a();
          i = axhp.a().a();
          localObject5 = axhp.a().a();
          this.a.jdField_a_of_type_Axid.a(2, new Object[] { localObject5, Integer.valueOf(i), localObject3 });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_DEFAULT");
          }
          localObject3 = a();
          if ((axhp.a().a((String)localObject3)) || (axhp.a().a("auto")) || (axhp.a().a(this))) {
            break;
          }
          this.a.jdField_a_of_type_Axid.a(9, new Object[] { ajyc.a(2131701318) });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_AUTO");
          }
          if (axhp.a().a("auto")) {
            break;
          }
          this.a.jdField_a_of_type_Axid.a(9, new Object[] { ajyc.a(2131701317) });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_RECORDING");
          }
          localObject3 = b();
          if (axhp.a().a((String)localObject3)) {
            break;
          }
          this.a.jdField_a_of_type_Axid.a(9, new Object[] { ajyc.a(2131701312) });
          break;
          localObject3 = (axif)paramMessage.obj;
          a(((axif)localObject3).jdField_a_of_type_AndroidGraphicsRect, ((axif)localObject3).b, ((axif)localObject3).jdField_a_of_type_AndroidHardwareCamera$AutoFocusCallback);
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_SET_SURFACE");
          }
          localObject3 = (SurfaceTexture)paramMessage.obj;
          if (axhp.a().a((SurfaceTexture)localObject3)) {
            break;
          }
          this.a.jdField_a_of_type_Axid.a(2, new Object[] { "set preview texture failed" });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_SET_SURFACE_HOLDER");
          }
          localObject3 = (SurfaceHolder)paramMessage.obj;
          if (axhp.a().a((SurfaceHolder)localObject3)) {
            break;
          }
          this.a.jdField_a_of_type_Axid.a(2, new Object[] { "set surface holder failed" });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_SET_CALLBACK");
          }
          localObject3 = (Camera.PreviewCallback)paramMessage.obj;
          bool1 = bool3;
          if (paramMessage.arg1 > 0) {
            bool1 = true;
          }
          if (axhp.a().a((Camera.PreviewCallback)localObject3, bool1)) {
            break;
          }
          this.a.jdField_a_of_type_Axid.a(2, new Object[] { "set preview callback failed" });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_START");
          }
          if (!axhp.a().a())
          {
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_START error");
            }
            bizq.b("CameraProxy", "[handleMessage] PREVIEW_START");
            this.a.jdField_a_of_type_Axid.a(3, new Object[] { "start preview failed" });
            break;
          }
          localObject3 = axhp.a();
          if (((axhp)localObject3).jdField_a_of_type_Int != 1) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_START, cameraId = " + ((axhp)localObject3).jdField_a_of_type_Int);
          }
          bizq.b("CameraProxy", "【Camera 】PREVIEW_START success cameraID:" + ((axhp)localObject3).jdField_a_of_type_Int);
          if ((!((axhp)localObject3).d()) || (axhx.a(this.a) == null)) {
            break;
          }
          QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_START, startFaceDetection");
          ((axhp)localObject3).a(axhx.a(this.a));
          ((axhp)localObject3).c();
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]FACE_DETECT_SWITCH" + paramMessage.arg1);
          }
          localObject3 = axhp.a();
          if ((!((axhp)localObject3).d()) || (axhx.a(this.a) == null)) {
            break;
          }
          if (paramMessage.arg1 == 1)
          {
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]FACE_DETECT_SWITCH " + ((axhp)localObject3).jdField_a_of_type_Int);
            }
            if (((axhp)localObject3).jdField_a_of_type_Int != 1) {
              break;
            }
            ((axhp)localObject3).a(axhx.a(this.a));
            ((axhp)localObject3).c();
            break;
          }
          if (paramMessage.arg1 != 2) {
            break;
          }
          ((axhp)localObject3).d();
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_STOP");
          }
          bizq.b("CameraProxy", "【Camera】PREVIEW_STOP success");
          if (!axhp.a().b())
          {
            this.a.jdField_a_of_type_Axid.a(4, new Object[] { "stop preview failed" });
            break;
          }
          localObject3 = axhp.a();
          if ((!((axhp)localObject3).d()) || (axhx.a(this.a) == null)) {
            break;
          }
          ((axhp)localObject3).d();
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]RELEASE");
          }
          axhp.a().b();
          this.a.jdField_a_of_type_Boolean = true;
          try
          {
            Thread.sleep(50L);
            bizq.b("CameraProxy", "【Camera】RELEASE success");
            this.a.jdField_a_of_type_Axid.a(11, new Object[] { "camera destory" });
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]NIGHT_MODE_ON_OFF" + paramMessage.arg1);
            }
            if (paramMessage.arg1 == 1)
            {
              axhx.a(this.a);
              break;
            }
            if (paramMessage.arg1 != 2) {
              break;
            }
            axhx.b(this.a);
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]FLASH_LIGHT_ON_OFF");
            }
            if (paramMessage.arg1 == 1)
            {
              if (axhp.a().a(true)) {
                break;
              }
              this.a.jdField_a_of_type_Axid.a(6, new Object[] { "turn on flash light failed" });
              break;
            }
            if ((paramMessage.arg1 != 2) || (axhp.a().a(false))) {
              break;
            }
            this.a.jdField_a_of_type_Axid.a(6, new Object[] { "turn off flash light failed" });
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]FLASH_LIGHT_SWITCH");
            }
            if (paramMessage.arg1 == 0)
            {
              if (axhp.a().f()) {
                break;
              }
              this.a.jdField_a_of_type_Axid.a(6, new Object[] { "switch flash light failed" });
              break;
            }
            if (paramMessage.arg1 == 1)
            {
              if (axhp.a().b(true)) {
                break;
              }
              this.a.jdField_a_of_type_Axid.a(6, new Object[] { "turn on flash light failed" });
              break;
            }
            if ((paramMessage.arg1 != 2) || (axhp.a().b(false))) {
              break;
            }
            this.a.jdField_a_of_type_Axid.a(6, new Object[] { "turn off flash light failed" });
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]PICTURE_TAKE");
            }
            ahvz.a("received");
            localObject3 = (axii)paramMessage.obj;
            localObject5 = axhp.a();
            if (!((axhp)localObject5).jdField_a_of_type_Boolean)
            {
              if (QLog.isColorLevel()) {
                QLog.i("CameraProxy", 2, "[takePicture]Camera is not previewing...");
              }
              axij.a(paramMessage);
              return;
            }
            if (((axii)localObject3).jdField_a_of_type_JavaIoFile == null)
            {
              this.a.jdField_a_of_type_Axid.a(2, new Object[] { "take picture error" });
              axij.a(paramMessage);
              return;
            }
            ((axhp)localObject5).a(((axii)localObject3).jdField_a_of_type_JavaIoFile, ((axii)localObject3).jdField_a_of_type_AndroidGraphicsRect, ((axii)localObject3).jdField_a_of_type_Aiak, ((axii)localObject3).jdField_a_of_type_Int, ((axii)localObject3).jdField_a_of_type_Boolean, ((axii)localObject3).jdField_b_of_type_Int);
            break;
            i = ((Integer)((Object[])(Object[])paramMessage.obj)[0]).intValue();
            axhp.a().b(i);
            break;
            localObject3 = (String)((Object[])(Object[])paramMessage.obj)[0];
            axhp.a().b((String)localObject3);
            break;
            bizq.b("CameraProxy", "camera2 open in.");
            localObject3 = (Object[])paramMessage.obj;
            i = ((Integer)localObject3[0]).intValue();
            if ((localObject3[1] instanceof axfy))
            {
              localObject3 = (axfy)localObject3[1];
              if (Camera2Control.a().b())
              {
                axgd.a(1, "[Camera2] camera2 is opening!");
                axij.a(paramMessage);
                return;
              }
              i = Camera2Control.a().a(i, (axfy)localObject3);
              if (i == 0) {
                break;
              }
              bizq.d("CameraProxy", "【Camera2 Open Error】EVENT_CAMERA2_ERROR:" + i);
              this.a.jdField_a_of_type_Axid.a(13, new Object[] { Integer.valueOf(i) });
              break;
              localObject3 = (SurfaceTexture)((Object[])(Object[])paramMessage.obj)[0];
              Camera2Control.a().a((SurfaceTexture)localObject3);
              bizq.b("CameraProxy", "【Camera2】PREVIEW_START");
              break;
              localObject3 = (Camera.PreviewCallback)((Object[])(Object[])paramMessage.obj)[0];
              Camera2Control.a().a((Camera.PreviewCallback)localObject3);
              break;
              Camera2Control.a().e();
              bizq.b("CameraProxy", "【Camera2】CAMERA2_RELEASE");
              break;
              localObject7 = (Object[])paramMessage.obj;
              localObject5 = (axhs)localObject7[0];
              localObject8 = (axhs)localObject7[1];
              bool1 = ((Boolean)localObject7[4]).booleanValue();
              localObject3 = new StringBuilder();
              Camera2Control.a();
              localObject6 = Camera2Control.a + "#" + localObject5 + "#" + localObject8;
              if (QLog.isColorLevel()) {
                QLog.i("CameraProxy", 2, "[handleMessage]CAMERA2_SET_PARAMS,wantedSize = " + localObject5 + " , viewSize = " + localObject8 + ",resolutionMode:" + bool1);
              }
              localObject3 = (axih)this.a.jdField_b_of_type_JavaUtilMap.get(localObject6);
              if (localObject3 == null)
              {
                localObject3 = new axih();
                this.a.jdField_b_of_type_JavaUtilMap.put(localObject6, localObject3);
                if (!((axih)localObject3).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
                {
                  localObject6 = Camera2Control.a().a();
                  if (!bool1) {}
                  for (localObject5 = axgd.a(((axhs)localObject5).jdField_a_of_type_Int, ((axhs)localObject5).jdField_b_of_type_Int, ((axhs)localObject8).jdField_a_of_type_Int, ((axhs)localObject8).jdField_b_of_type_Int, (axfx)localObject6);; localObject5 = axgd.b(((axhs)localObject5).jdField_a_of_type_Int, ((axhs)localObject5).jdField_b_of_type_Int, ((axhs)localObject8).jdField_a_of_type_Int, ((axhs)localObject8).jdField_b_of_type_Int, (axfx)localObject6))
                  {
                    if ((localObject5 == null) || (localObject5.length < 2)) {
                      break label5309;
                    }
                    localObject6 = localObject5[0];
                    localObject5 = localObject5[1];
                    localObject8 = new axhs(Math.max(((axhs)localObject8).jdField_a_of_type_Int, ((axhs)localObject8).jdField_b_of_type_Int), Math.min(((axhs)localObject8).jdField_a_of_type_Int, ((axhs)localObject8).jdField_b_of_type_Int));
                    localObject8 = Camera2Control.a().a((axhs)localObject8);
                    if (Camera2Control.a().a((axhs)localObject6)) {
                      break;
                    }
                    this.a.jdField_a_of_type_Axid.a(14, new Object[] { "[Camera2]setCamera2 previewSize error!" });
                    axij.a(paramMessage);
                    return;
                  }
                  if (!Camera2Control.a().b((axhs)localObject5))
                  {
                    this.a.jdField_a_of_type_Axid.a(14, new Object[] { "[Camera2]setCamera2 pictureSize error!" });
                    axij.a(paramMessage);
                    return;
                  }
                  if (!Camera2Control.a().a(((Integer)localObject7[3]).intValue()))
                  {
                    this.a.jdField_a_of_type_Axid.a(14, new Object[] { "[Camera2]setCamera2 fps error!" });
                    axij.a(paramMessage);
                    return;
                  }
                  ((axih)localObject3).jdField_a_of_type_Axhs = ((axhs)localObject6);
                  ((axih)localObject3).jdField_b_of_type_Axhs = ((axhs)localObject5);
                  ((axih)localObject3).c = ((axhs)localObject8);
                  ((axih)localObject3).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true);
                }
                while (Camera2Control.a().a((axih)localObject3))
                {
                  localObject3 = Camera2Control.a().b();
                  localObject5 = Camera2Control.a().a();
                  this.a.jdField_a_of_type_Axid.a(14, new Object[] { localObject3, localObject5 });
                  break;
                }
                this.a.jdField_a_of_type_Axid.a(14, new Object[] { "[Camera2]setCamera2ParamOnce error!" });
                axij.a(paramMessage);
                return;
                if (QLog.isColorLevel()) {
                  QLog.i("CameraProxy", 2, "[handleMessage]CAMERA2_PICTURE_TAKE");
                }
                localObject3 = (axii)paramMessage.obj;
                if (((axii)localObject3).jdField_a_of_type_JavaIoFile == null)
                {
                  this.a.jdField_a_of_type_Axid.a(2, new Object[] { "take picture error" });
                  axij.a(paramMessage);
                  return;
                }
                localObject5 = new axfz();
                ((axfz)localObject5).jdField_a_of_type_Aiak = ((axii)localObject3).jdField_a_of_type_Aiak;
                ((axfz)localObject5).jdField_a_of_type_Boolean = ((axii)localObject3).jdField_a_of_type_Boolean;
                ((axfz)localObject5).jdField_a_of_type_Int = ((axii)localObject3).jdField_a_of_type_Int;
                ((axfz)localObject5).jdField_a_of_type_JavaIoFile = ((axii)localObject3).jdField_a_of_type_JavaIoFile;
                ((axfz)localObject5).jdField_a_of_type_AndroidGraphicsRect = ((axii)localObject3).jdField_a_of_type_AndroidGraphicsRect;
                Camera2Control.a().a((axfz)localObject5);
                break;
                if (QLog.isColorLevel()) {
                  QLog.i("CameraProxy", 2, "[handleMessage]CAMERA2_STOP_VIDEO");
                }
                Camera2Control.a().c();
                break;
                localObject3 = (axif)paramMessage.obj;
                Camera2Control.a().a((axif)localObject3);
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
                axgd.a(2, "[Camera2] error:" + paramMessage.arg1);
                bizq.d("CameraProxy", "【Camera2 Open Error】CAMERA2_ERROR_CALLBACK:" + paramMessage.arg1);
                i = paramMessage.arg1;
                switch (i)
                {
                case -203: 
                case -202: 
                case -201: 
                  this.a.jdField_a_of_type_Axid.a(14, new Object[] { "[Camera2]setCamera2 previewSize error:" + i });
                  break;
                case -105: 
                case -102: 
                  this.a.jdField_a_of_type_Axid.a(13, new Object[] { Integer.valueOf(i) });
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
    axhp.a().a(paramCamera);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axia
 * JD-Core Version:    0.7.0.1
 */