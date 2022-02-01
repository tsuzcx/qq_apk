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
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class bdbi
  extends Handler
  implements Camera.AutoFocusCallback
{
  bdbi(bdbf parambdbf, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  @TargetApi(14)
  private void a(Rect paramRect1, Rect paramRect2, Camera.AutoFocusCallback paramAutoFocusCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_REQUEST_FOCUS");
    }
    Camera.Parameters localParameters = bdax.a().a();
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
      bdax.a().jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters);
    }
    paramRect1 = paramAutoFocusCallback;
    if (paramAutoFocusCallback == null) {
      paramRect1 = new bdbj(this);
    }
    bdax.a().a(paramRect1);
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
        bnrh.b("CameraProxy", "[handleMessage] OPEN_CAMERA + BEGIN");
        i = ((Integer)((Object[])(Object[])paramMessage.obj)[0]).intValue();
        if (QLog.isColorLevel()) {
          QLog.i("CameraProxy", 2, "[handleMessage] OPEN_CAMERA");
        }
        i = bdax.a().a(i);
        bnrh.b("CameraProxy", "[handleMessage] OPEN_CAMERA, result = " + i);
        if (i == 5)
        {
          this.a.jdField_a_of_type_Bdbl.a(1, new Object[] { Boolean.valueOf(true) });
          return;
        }
        if (i != 0)
        {
          this.a.jdField_a_of_type_Bdbl.a(1, new Object[] { "open camera failed:errcode=" + bdax.a(i) });
          return;
        }
        if (!bdax.a().c())
        {
          this.a.jdField_a_of_type_Bdbl.a(1, new Object[] { "open camera failed, orientation error." });
          return;
        }
        this.a.jdField_a_of_type_Bdbl.a(1, new Object[] { Boolean.valueOf(true) });
        this.a.jdField_a_of_type_Boolean = false;
        return;
        if (QLog.isColorLevel()) {
          QLog.i("CameraProxy", 2, "[handleMessage]CHANGED");
        }
        int k = Integer.parseInt(paramMessage.obj.toString());
        i = paramMessage.arg1;
        j = paramMessage.arg2;
        this.a.jdField_a_of_type_Boolean = false;
        bdbf.a(this.a, false);
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
        localObject7 = bdax.a();
        if (Build.VERSION.SDK_INT <= 10) {
          bdax.a().b();
        }
        if (this.a.jdField_a_of_type_Int == 1)
        {
          localObject1 = this.a.jdField_a_of_type_Bdbo;
          if (((bdbo)localObject1).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
            continue;
          }
          if (!bdax.a().e()) {
            this.a.jdField_a_of_type_Bdbl.a(2, new Object[] { "set preview format failed" });
          }
        }
        else
        {
          if (this.a.jdField_a_of_type_Int == 3)
          {
            if (alps.jdField_a_of_type_Int == 1)
            {
              localObject1 = this.a.jdField_c_of_type_Bdbo;
              continue;
            }
            if (alps.jdField_a_of_type_Int == 2)
            {
              localObject1 = this.a.jdField_b_of_type_Bdbo;
              continue;
            }
            this.a.jdField_a_of_type_Bdbl.a(2, new Object[] { "set preview format failed[Camera Kind error:PROGNOSIS_FULL_FILTER]" });
            return;
          }
          if (this.a.jdField_a_of_type_Int == 2)
          {
            if (alps.jdField_a_of_type_Int == 1)
            {
              localObject1 = this.a.e;
              continue;
            }
            if (alps.jdField_a_of_type_Int == 2)
            {
              localObject1 = this.a.d;
              continue;
            }
            this.a.jdField_a_of_type_Bdbl.a(2, new Object[] { "set preview format failed[Camera Kind error:RATIO_SCREEN]" });
            return;
          }
          if (this.a.jdField_a_of_type_Int == 4)
          {
            if (alps.jdField_a_of_type_Int == 1)
            {
              localObject1 = this.a.g;
              continue;
            }
            if (alps.jdField_a_of_type_Int == 2)
            {
              localObject1 = this.a.f;
              continue;
            }
            this.a.jdField_a_of_type_Bdbl.a(2, new Object[] { "set preview format failed[Camera Kind error:PROGNOSIS_FULL_FILTER]" });
            return;
          }
          if (this.a.jdField_a_of_type_Int == 5)
          {
            localObject1 = this.a.h;
            continue;
          }
          this.a.jdField_a_of_type_Bdbl.a(2, new Object[] { "set preview format failed[Preview Selector Error]" });
          return;
        }
        localObject6 = null;
        if ((this.a.jdField_a_of_type_Int == 1) || (this.a.jdField_a_of_type_Int == 3) || (this.a.jdField_a_of_type_Int == 4))
        {
          localObject6 = ((bdax)localObject7).c(CodecParam.DST_VIDEO_WIDTH, CodecParam.DST_VIDEO_HEIGHT, this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int);
          localObject5 = localObject6[0];
          localObject6 = localObject6[1];
          if (localObject5 == null) {
            break label5330;
          }
          bool1 = bdax.a().a((bdba)localObject5);
          break label5342;
          if (!bool1) {
            this.a.jdField_a_of_type_Bdbl.a(2, new Object[] { "set preview size failed" + (String)localObject5 });
          }
        }
        else
        {
          if (this.a.jdField_a_of_type_Int == 2)
          {
            localObject5 = ((bdax)localObject7).a(CodecParam.DST_VIDEO_WIDTH, CodecParam.DST_VIDEO_HEIGHT, i, j);
            bool1 = bool4;
            if (localObject5 == null) {
              break label5350;
            }
            bool1 = bdax.a().a((bdba)localObject5);
            break label5350;
          }
          if (this.a.jdField_a_of_type_Int != 5) {
            break label5366;
          }
          if ((Build.MANUFACTURER.equals("Xiaomi")) && (Build.MODEL.equals("MI 3")))
          {
            localObject5 = new bdba();
            ((bdba)localObject5).jdField_a_of_type_Int = 640;
            ((bdba)localObject5).jdField_b_of_type_Int = 480;
            bool1 = bool5;
            if (localObject5 == null) {
              break label5358;
            }
            bool1 = bdax.a().a((bdba)localObject5);
            break label5358;
          }
          localObject5 = ((bdax)localObject7).a(480);
          continue;
        }
        if (!bdax.a().a(CodecParam.VIDEO_FPS))
        {
          this.a.jdField_a_of_type_Bdbl.a(2, new Object[] { "set preview fps failed" });
          return;
        }
        if ((this.a.jdField_a_of_type_Int != 1) && (this.a.jdField_a_of_type_Int != 4) && (this.a.jdField_a_of_type_Int != 5) && (localObject6 != null) && (!((bdax)localObject7).b((bdba)localObject6))) {}
        ((bdbo)localObject1).jdField_a_of_type_Int = bdax.a().a();
        ((bdbo)localObject1).jdField_a_of_type_Bdba = bdax.a().a();
        localObject5 = bdax.a().b();
        if (localObject5 != null)
        {
          ((bdbo)localObject1).jdField_b_of_type_Bdba = ((bdba)localObject5);
          ((bdbo)localObject1).jdField_a_of_type_Boolean = true;
        }
        localObject5 = bdax.a().a();
        ((bdbo)localObject1).jdField_b_of_type_Int = localObject5[0];
        ((bdbo)localObject1).jdField_c_of_type_Int = localObject5[1];
        if ((this.a.jdField_a_of_type_Int != 1) && (this.a.jdField_a_of_type_Int != 3) && (this.a.jdField_a_of_type_Int != 4) && (this.a.jdField_a_of_type_Int != 5))
        {
          ((bdbo)localObject1).jdField_b_of_type_Bdba = bdax.a().b();
          ((bdbo)localObject1).jdField_a_of_type_Boolean = true;
        }
        if (this.a.jdField_a_of_type_Int == 4) {
          ((bdbo)localObject1).jdField_a_of_type_Boolean = false;
        }
        ((bdbo)localObject1).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true);
        Object localObject1 = a();
        if ((!bdax.a().a((String)localObject1)) && (!bdax.a().a("auto")) && (!bdax.a().a(this))) {
          this.a.jdField_a_of_type_Bdbl.a(9, new Object[] { anvx.a(2131700828) });
        }
        if (!bdax.a().c())
        {
          this.a.jdField_a_of_type_Bdbl.a(2, new Object[] { "set display orientation failed" });
          return;
          if (!bdax.a().a((bdbo)localObject1))
          {
            this.a.jdField_a_of_type_Bdbl.a(2, new Object[] { "set Camera Params failed" });
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
        bdbr.a(paramMessage);
      }
      Object localObject3 = bdax.a().a();
      int i = bdax.a().a();
      Object localObject5 = bdax.a().a();
      this.a.jdField_a_of_type_Bdbl.a(2, new Object[] { localObject5, Integer.valueOf(i), localObject3 });
      continue;
      localObject3 = (Object[])paramMessage.obj;
      localObject5 = (bdba)localObject3[0];
      Object localObject7 = (bdba)localObject3[1];
      i = ((Integer)localObject3[2]).intValue();
      int j = ((Integer)localObject3[3]).intValue();
      bool2 = ((Boolean)localObject3[4]).booleanValue();
      if (QLog.isColorLevel()) {
        QLog.i("CameraProxy", 2, "[handleMessage] SET_PARAMS, , wantedSize = " + localObject5 + " , viewSize = " + localObject7 + " , selectMode = " + i + " , resolutionMode = " + bool2);
      }
      this.a.jdField_a_of_type_Boolean = false;
      bdbf.a(this.a, false);
      Object localObject6 = bdax.a();
      Object localObject8 = bdax.a().jdField_a_of_type_Int + "#" + localObject5 + "#" + localObject7 + "#" + i;
      localObject3 = (bdbo)this.a.jdField_a_of_type_JavaUtilMap.get(localObject8);
      if (localObject3 == null)
      {
        localObject3 = new bdbo();
        this.a.jdField_a_of_type_JavaUtilMap.put(localObject8, localObject3);
      }
      for (;;)
      {
        for (;;)
        {
          if (!((bdbo)localObject3).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
          {
            if (!bdax.a().e())
            {
              this.a.jdField_a_of_type_Bdbl.a(2, new Object[] { "set preview format failed" });
              bdbr.a(paramMessage);
              return;
            }
            if (!bool2) {}
            for (localObject5 = ((bdax)localObject6).a(((bdba)localObject5).jdField_a_of_type_Int, ((bdba)localObject5).jdField_b_of_type_Int, ((bdba)localObject7).jdField_a_of_type_Int, ((bdba)localObject7).jdField_b_of_type_Int);; localObject5 = ((bdax)localObject6).b(((bdba)localObject5).jdField_a_of_type_Int, ((bdba)localObject5).jdField_b_of_type_Int, ((bdba)localObject7).jdField_a_of_type_Int, ((bdba)localObject7).jdField_b_of_type_Int))
            {
              localObject7 = localObject5[0];
              localObject5 = localObject5[1];
              if (localObject7 != null) {
                bool1 = bdax.a().a((bdba)localObject7);
              }
              if (bool1) {
                break;
              }
              this.a.jdField_a_of_type_Bdbl.a(2, new Object[] { "set preview size failed" + "" });
              bdbr.a(paramMessage);
              return;
            }
            if (((localObject5 == null) || (((bdax)localObject6).b((bdba)localObject5))) || (!bdax.a().a(j)))
            {
              this.a.jdField_a_of_type_Bdbl.a(2, new Object[] { "set preview fps failed" });
              bdbr.a(paramMessage);
              return;
            }
            ((bdbo)localObject3).jdField_a_of_type_Int = bdax.a().a();
            ((bdbo)localObject3).jdField_a_of_type_Bdba = bdax.a().a();
            localObject5 = bdax.a().b();
            if (localObject5 != null)
            {
              ((bdbo)localObject3).jdField_b_of_type_Bdba = ((bdba)localObject5);
              ((bdbo)localObject3).jdField_a_of_type_Boolean = true;
            }
            localObject5 = bdax.a().a();
            ((bdbo)localObject3).jdField_b_of_type_Int = localObject5[0];
            ((bdbo)localObject3).jdField_c_of_type_Int = localObject5[1];
            ((bdbo)localObject3).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true);
          }
          for (;;)
          {
            localObject3 = a();
            if ((!bdax.a().a((String)localObject3)) && (!bdax.a().a("auto")) && (!bdax.a().a(this))) {
              this.a.jdField_a_of_type_Bdbl.a(9, new Object[] { anvx.a(2131700825) });
            }
            if (bdax.a().c()) {
              break;
            }
            this.a.jdField_a_of_type_Bdbl.a(2, new Object[] { "set display orientation failed" });
            bdbr.a(paramMessage);
            return;
            if (!bdax.a().a((bdbo)localObject3))
            {
              this.a.jdField_a_of_type_Bdbl.a(2, new Object[] { "set Camera Params failed" });
              bdbr.a(paramMessage);
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage] Set camera param by cache params");
            }
          }
          localObject3 = bdax.a().a();
          i = bdax.a().a();
          localObject5 = bdax.a().a();
          this.a.jdField_a_of_type_Bdbl.a(2, new Object[] { localObject5, Integer.valueOf(i), localObject3 });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_DEFAULT");
          }
          localObject3 = a();
          if ((bdax.a().a((String)localObject3)) || (bdax.a().a("auto")) || (bdax.a().a(this))) {
            break;
          }
          this.a.jdField_a_of_type_Bdbl.a(9, new Object[] { anvx.a(2131700827) });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_AUTO");
          }
          if (bdax.a().a("auto")) {
            break;
          }
          this.a.jdField_a_of_type_Bdbl.a(9, new Object[] { anvx.a(2131700826) });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_RECORDING");
          }
          localObject3 = b();
          if (bdax.a().a((String)localObject3)) {
            break;
          }
          this.a.jdField_a_of_type_Bdbl.a(9, new Object[] { anvx.a(2131700821) });
          break;
          localObject3 = (bdbn)paramMessage.obj;
          a(((bdbn)localObject3).jdField_a_of_type_AndroidGraphicsRect, ((bdbn)localObject3).b, ((bdbn)localObject3).jdField_a_of_type_AndroidHardwareCamera$AutoFocusCallback);
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_SET_SURFACE");
          }
          localObject3 = (SurfaceTexture)paramMessage.obj;
          if (bdax.a().a((SurfaceTexture)localObject3)) {
            break;
          }
          this.a.jdField_a_of_type_Bdbl.a(2, new Object[] { "set preview texture failed" });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_SET_SURFACE_HOLDER");
          }
          localObject3 = (SurfaceHolder)paramMessage.obj;
          if (bdax.a().a((SurfaceHolder)localObject3)) {
            break;
          }
          this.a.jdField_a_of_type_Bdbl.a(2, new Object[] { "set surface holder failed" });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_SET_CALLBACK");
          }
          localObject3 = (Camera.PreviewCallback)paramMessage.obj;
          bool1 = bool3;
          if (paramMessage.arg1 > 0) {
            bool1 = true;
          }
          if (bdax.a().a((Camera.PreviewCallback)localObject3, bool1)) {
            break;
          }
          this.a.jdField_a_of_type_Bdbl.a(2, new Object[] { "set preview callback failed" });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_START");
          }
          if (!bdax.a().a())
          {
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_START error");
            }
            bnrh.b("CameraProxy", "[handleMessage] PREVIEW_START");
            this.a.jdField_a_of_type_Bdbl.a(3, new Object[] { "start preview failed" });
            break;
          }
          localObject3 = bdax.a();
          if (((bdax)localObject3).jdField_a_of_type_Int != 1) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_START, cameraId = " + ((bdax)localObject3).jdField_a_of_type_Int);
          }
          bnrh.b("CameraProxy", "【Camera 】PREVIEW_START success cameraID:" + ((bdax)localObject3).jdField_a_of_type_Int);
          if ((!((bdax)localObject3).d()) || (bdbf.a(this.a) == null)) {
            break;
          }
          QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_START, startFaceDetection");
          ((bdax)localObject3).a(bdbf.a(this.a));
          ((bdax)localObject3).c();
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]FACE_DETECT_SWITCH" + paramMessage.arg1);
          }
          localObject3 = bdax.a();
          if ((!((bdax)localObject3).d()) || (bdbf.a(this.a) == null)) {
            break;
          }
          if (paramMessage.arg1 == 1)
          {
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]FACE_DETECT_SWITCH " + ((bdax)localObject3).jdField_a_of_type_Int);
            }
            if (((bdax)localObject3).jdField_a_of_type_Int != 1) {
              break;
            }
            ((bdax)localObject3).a(bdbf.a(this.a));
            ((bdax)localObject3).c();
            break;
          }
          if (paramMessage.arg1 != 2) {
            break;
          }
          ((bdax)localObject3).d();
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_STOP");
          }
          bnrh.b("CameraProxy", "【Camera】PREVIEW_STOP success");
          if (!bdax.a().b())
          {
            this.a.jdField_a_of_type_Bdbl.a(4, new Object[] { "stop preview failed" });
            break;
          }
          localObject3 = bdax.a();
          if ((!((bdax)localObject3).d()) || (bdbf.a(this.a) == null)) {
            break;
          }
          ((bdax)localObject3).d();
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]RELEASE");
          }
          bdax.a().b();
          this.a.jdField_a_of_type_Boolean = true;
          try
          {
            Thread.sleep(50L);
            bnrh.b("CameraProxy", "【Camera】RELEASE success");
            this.a.jdField_a_of_type_Bdbl.a(11, new Object[] { "camera destory" });
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]NIGHT_MODE_ON_OFF" + paramMessage.arg1);
            }
            if (paramMessage.arg1 == 1)
            {
              bdbf.a(this.a);
              break;
            }
            if (paramMessage.arg1 != 2) {
              break;
            }
            bdbf.b(this.a);
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]FLASH_LIGHT_ON_OFF");
            }
            if (paramMessage.arg1 == 1)
            {
              if (bdax.a().a(true)) {
                break;
              }
              this.a.jdField_a_of_type_Bdbl.a(6, new Object[] { "turn on flash light failed" });
              break;
            }
            if ((paramMessage.arg1 != 2) || (bdax.a().a(false))) {
              break;
            }
            this.a.jdField_a_of_type_Bdbl.a(6, new Object[] { "turn off flash light failed" });
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]FLASH_LIGHT_SWITCH");
            }
            if (paramMessage.arg1 == 0)
            {
              if (bdax.a().f()) {
                break;
              }
              this.a.jdField_a_of_type_Bdbl.a(6, new Object[] { "switch flash light failed" });
              break;
            }
            if (paramMessage.arg1 == 1)
            {
              if (bdax.a().b(true)) {
                break;
              }
              this.a.jdField_a_of_type_Bdbl.a(6, new Object[] { "turn on flash light failed" });
              break;
            }
            if ((paramMessage.arg1 != 2) || (bdax.a().b(false))) {
              break;
            }
            this.a.jdField_a_of_type_Bdbl.a(6, new Object[] { "turn off flash light failed" });
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]PICTURE_TAKE");
            }
            alrr.a("received");
            localObject3 = (bdbq)paramMessage.obj;
            localObject5 = bdax.a();
            if (!((bdax)localObject5).jdField_a_of_type_Boolean)
            {
              if (QLog.isColorLevel()) {
                QLog.i("CameraProxy", 2, "[takePicture]Camera is not previewing...");
              }
              bdbr.a(paramMessage);
              return;
            }
            if (((bdbq)localObject3).jdField_a_of_type_JavaIoFile == null)
            {
              this.a.jdField_a_of_type_Bdbl.a(2, new Object[] { "take picture error" });
              bdbr.a(paramMessage);
              return;
            }
            ((bdax)localObject5).a(((bdbq)localObject3).jdField_a_of_type_JavaIoFile, ((bdbq)localObject3).jdField_a_of_type_AndroidGraphicsRect, ((bdbq)localObject3).jdField_a_of_type_Alun, ((bdbq)localObject3).jdField_a_of_type_Int, ((bdbq)localObject3).jdField_a_of_type_Boolean, ((bdbq)localObject3).jdField_b_of_type_Int);
            break;
            i = ((Integer)((Object[])(Object[])paramMessage.obj)[0]).intValue();
            bdax.a().b(i);
            break;
            localObject3 = (String)((Object[])(Object[])paramMessage.obj)[0];
            bdax.a().b((String)localObject3);
            break;
            bnrh.b("CameraProxy", "camera2 open in.");
            localObject3 = (Object[])paramMessage.obj;
            i = ((Integer)localObject3[0]).intValue();
            if ((localObject3[1] instanceof bczh))
            {
              localObject3 = (bczh)localObject3[1];
              if (Camera2Control.a().b())
              {
                bczm.a(1, "[Camera2] camera2 is opening!");
                bdbr.a(paramMessage);
                return;
              }
              i = Camera2Control.a().a(i, (bczh)localObject3);
              if (i == 0) {
                break;
              }
              bnrh.d("CameraProxy", "【Camera2 Open Error】EVENT_CAMERA2_ERROR:" + i);
              this.a.jdField_a_of_type_Bdbl.a(13, new Object[] { Integer.valueOf(i) });
              break;
              localObject3 = (SurfaceTexture)((Object[])(Object[])paramMessage.obj)[0];
              Camera2Control.a().a((SurfaceTexture)localObject3);
              bnrh.b("CameraProxy", "【Camera2】PREVIEW_START");
              break;
              localObject3 = (Camera.PreviewCallback)((Object[])(Object[])paramMessage.obj)[0];
              Camera2Control.a().a((Camera.PreviewCallback)localObject3);
              break;
              Camera2Control.a().e();
              bnrh.b("CameraProxy", "【Camera2】CAMERA2_RELEASE");
              break;
              localObject7 = (Object[])paramMessage.obj;
              localObject5 = (bdba)localObject7[0];
              localObject8 = (bdba)localObject7[1];
              bool1 = ((Boolean)localObject7[4]).booleanValue();
              localObject3 = new StringBuilder();
              Camera2Control.a();
              localObject6 = Camera2Control.a + "#" + localObject5 + "#" + localObject8;
              if (QLog.isColorLevel()) {
                QLog.i("CameraProxy", 2, "[handleMessage]CAMERA2_SET_PARAMS,wantedSize = " + localObject5 + " , viewSize = " + localObject8 + ",resolutionMode:" + bool1);
              }
              localObject3 = (bdbp)this.a.jdField_b_of_type_JavaUtilMap.get(localObject6);
              if (localObject3 == null)
              {
                localObject3 = new bdbp();
                this.a.jdField_b_of_type_JavaUtilMap.put(localObject6, localObject3);
                if (!((bdbp)localObject3).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
                {
                  localObject6 = Camera2Control.a().a();
                  if (!bool1) {}
                  for (localObject5 = bczm.a(((bdba)localObject5).jdField_a_of_type_Int, ((bdba)localObject5).jdField_b_of_type_Int, ((bdba)localObject8).jdField_a_of_type_Int, ((bdba)localObject8).jdField_b_of_type_Int, (bczg)localObject6);; localObject5 = bczm.b(((bdba)localObject5).jdField_a_of_type_Int, ((bdba)localObject5).jdField_b_of_type_Int, ((bdba)localObject8).jdField_a_of_type_Int, ((bdba)localObject8).jdField_b_of_type_Int, (bczg)localObject6))
                  {
                    if ((localObject5 == null) || (localObject5.length < 2)) {
                      break label5309;
                    }
                    localObject6 = localObject5[0];
                    localObject5 = localObject5[1];
                    localObject8 = new bdba(Math.max(((bdba)localObject8).jdField_a_of_type_Int, ((bdba)localObject8).jdField_b_of_type_Int), Math.min(((bdba)localObject8).jdField_a_of_type_Int, ((bdba)localObject8).jdField_b_of_type_Int));
                    localObject8 = Camera2Control.a().a((bdba)localObject8);
                    if (Camera2Control.a().a((bdba)localObject6)) {
                      break;
                    }
                    this.a.jdField_a_of_type_Bdbl.a(14, new Object[] { "[Camera2]setCamera2 previewSize error!" });
                    bdbr.a(paramMessage);
                    return;
                  }
                  if (!Camera2Control.a().b((bdba)localObject5))
                  {
                    this.a.jdField_a_of_type_Bdbl.a(14, new Object[] { "[Camera2]setCamera2 pictureSize error!" });
                    bdbr.a(paramMessage);
                    return;
                  }
                  if (!Camera2Control.a().a(((Integer)localObject7[3]).intValue()))
                  {
                    this.a.jdField_a_of_type_Bdbl.a(14, new Object[] { "[Camera2]setCamera2 fps error!" });
                    bdbr.a(paramMessage);
                    return;
                  }
                  ((bdbp)localObject3).jdField_a_of_type_Bdba = ((bdba)localObject6);
                  ((bdbp)localObject3).jdField_b_of_type_Bdba = ((bdba)localObject5);
                  ((bdbp)localObject3).c = ((bdba)localObject8);
                  ((bdbp)localObject3).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true);
                }
                while (Camera2Control.a().a((bdbp)localObject3))
                {
                  localObject3 = Camera2Control.a().b();
                  localObject5 = Camera2Control.a().a();
                  this.a.jdField_a_of_type_Bdbl.a(14, new Object[] { localObject3, localObject5 });
                  break;
                }
                this.a.jdField_a_of_type_Bdbl.a(14, new Object[] { "[Camera2]setCamera2ParamOnce error!" });
                bdbr.a(paramMessage);
                return;
                if (QLog.isColorLevel()) {
                  QLog.i("CameraProxy", 2, "[handleMessage]CAMERA2_PICTURE_TAKE");
                }
                localObject3 = (bdbq)paramMessage.obj;
                if (((bdbq)localObject3).jdField_a_of_type_JavaIoFile == null)
                {
                  this.a.jdField_a_of_type_Bdbl.a(2, new Object[] { "take picture error" });
                  bdbr.a(paramMessage);
                  return;
                }
                localObject5 = new bczi();
                ((bczi)localObject5).jdField_a_of_type_Alun = ((bdbq)localObject3).jdField_a_of_type_Alun;
                ((bczi)localObject5).jdField_a_of_type_Boolean = ((bdbq)localObject3).jdField_a_of_type_Boolean;
                ((bczi)localObject5).jdField_a_of_type_Int = ((bdbq)localObject3).jdField_a_of_type_Int;
                ((bczi)localObject5).jdField_a_of_type_JavaIoFile = ((bdbq)localObject3).jdField_a_of_type_JavaIoFile;
                ((bczi)localObject5).jdField_a_of_type_AndroidGraphicsRect = ((bdbq)localObject3).jdField_a_of_type_AndroidGraphicsRect;
                Camera2Control.a().a((bczi)localObject5);
                break;
                if (QLog.isColorLevel()) {
                  QLog.i("CameraProxy", 2, "[handleMessage]CAMERA2_STOP_VIDEO");
                }
                Camera2Control.a().c();
                break;
                localObject3 = (bdbn)paramMessage.obj;
                Camera2Control.a().a((bdbn)localObject3);
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
                bczm.a(2, "[Camera2] error:" + paramMessage.arg1);
                bnrh.d("CameraProxy", "【Camera2 Open Error】CAMERA2_ERROR_CALLBACK:" + paramMessage.arg1);
                i = paramMessage.arg1;
                switch (i)
                {
                case -203: 
                case -202: 
                case -201: 
                  this.a.jdField_a_of_type_Bdbl.a(14, new Object[] { "[Camera2]setCamera2 previewSize error:" + i });
                  break;
                case -105: 
                case -102: 
                  this.a.jdField_a_of_type_Bdbl.a(13, new Object[] { Integer.valueOf(i) });
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
    bdax.a().a(paramCamera);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdbi
 * JD-Core Version:    0.7.0.1
 */