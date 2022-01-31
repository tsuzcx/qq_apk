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

public class awiu
  extends Handler
  implements Camera.AutoFocusCallback
{
  awiu(awir paramawir, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  @TargetApi(14)
  private void a(Rect paramRect1, Rect paramRect2, Camera.AutoFocusCallback paramAutoFocusCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_REQUEST_FOCUS");
    }
    Camera.Parameters localParameters = awij.a().a();
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
      awij.a().jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters);
    }
    paramRect1 = paramAutoFocusCallback;
    if (paramAutoFocusCallback == null) {
      paramRect1 = new awiv(this);
    }
    awij.a().a(paramRect1);
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
        i = ((Integer)((Object[])(Object[])paramMessage.obj)[0]).intValue();
        if (QLog.isColorLevel()) {
          QLog.i("CameraProxy", 2, "[handleMessage]OPEN_CAMERA_OLD");
        }
        i = awij.a().a(i);
        bhcs.a("CameraProxy", 1, "【Open Old Camera Result】:" + i);
        if (i == 5)
        {
          this.a.jdField_a_of_type_Awix.a(1, new Object[] { Boolean.valueOf(true) });
          return;
        }
        if (i != 0)
        {
          this.a.jdField_a_of_type_Awix.a(1, new Object[] { "open camera failed:errcode=" + awij.a(i) });
          return;
        }
        if (!awij.a().c())
        {
          this.a.jdField_a_of_type_Awix.a(1, new Object[] { "open camera failed, orientation error." });
          return;
        }
        this.a.jdField_a_of_type_Awix.a(1, new Object[] { Boolean.valueOf(true) });
        this.a.jdField_a_of_type_Boolean = false;
        return;
        if (QLog.isColorLevel()) {
          QLog.i("CameraProxy", 2, "[handleMessage]CHANGED");
        }
        int k = Integer.parseInt(paramMessage.obj.toString());
        i = paramMessage.arg1;
        j = paramMessage.arg2;
        this.a.jdField_a_of_type_Boolean = false;
        awir.a(this.a, false);
        if (QLog.isColorLevel()) {
          QLog.i("CameraProxy", 2, "[@] surfaceChanged start, format = " + k + ",width = " + i + ",height = " + j);
        }
        if ((this.a.jdField_b_of_type_Int <= 0) || (i <= this.a.jdField_b_of_type_Int)) {
          break label5323;
        }
        i = this.a.jdField_b_of_type_Int;
        if ((this.a.jdField_c_of_type_Int <= 0) || (j <= this.a.jdField_c_of_type_Int)) {
          break label5320;
        }
        j = this.a.jdField_c_of_type_Int;
        localObject7 = awij.a();
        if (Build.VERSION.SDK_INT <= 10) {
          awij.a().b();
        }
        if (this.a.jdField_a_of_type_Int == 1)
        {
          localObject1 = this.a.jdField_a_of_type_Awja;
          if (((awja)localObject1).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
            continue;
          }
          if (!awij.a().e()) {
            this.a.jdField_a_of_type_Awix.a(2, new Object[] { "set preview format failed" });
          }
        }
        else
        {
          if (this.a.jdField_a_of_type_Int == 3)
          {
            if (ahhj.jdField_a_of_type_Int == 1)
            {
              localObject1 = this.a.jdField_c_of_type_Awja;
              continue;
            }
            if (ahhj.jdField_a_of_type_Int == 2)
            {
              localObject1 = this.a.jdField_b_of_type_Awja;
              continue;
            }
            this.a.jdField_a_of_type_Awix.a(2, new Object[] { "set preview format failed[Camera Kind error:PROGNOSIS_FULL_FILTER]" });
            return;
          }
          if (this.a.jdField_a_of_type_Int == 2)
          {
            if (ahhj.jdField_a_of_type_Int == 1)
            {
              localObject1 = this.a.e;
              continue;
            }
            if (ahhj.jdField_a_of_type_Int == 2)
            {
              localObject1 = this.a.d;
              continue;
            }
            this.a.jdField_a_of_type_Awix.a(2, new Object[] { "set preview format failed[Camera Kind error:RATIO_SCREEN]" });
            return;
          }
          if (this.a.jdField_a_of_type_Int == 4)
          {
            if (ahhj.jdField_a_of_type_Int == 1)
            {
              localObject1 = this.a.g;
              continue;
            }
            if (ahhj.jdField_a_of_type_Int == 2)
            {
              localObject1 = this.a.f;
              continue;
            }
            this.a.jdField_a_of_type_Awix.a(2, new Object[] { "set preview format failed[Camera Kind error:PROGNOSIS_FULL_FILTER]" });
            return;
          }
          if (this.a.jdField_a_of_type_Int == 5)
          {
            localObject1 = this.a.h;
            continue;
          }
          this.a.jdField_a_of_type_Awix.a(2, new Object[] { "set preview format failed[Preview Selector Error]" });
          return;
        }
        localObject6 = null;
        if ((this.a.jdField_a_of_type_Int == 1) || (this.a.jdField_a_of_type_Int == 3) || (this.a.jdField_a_of_type_Int == 4))
        {
          localObject6 = ((awij)localObject7).c(awje.j, awje.k, this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int);
          localObject5 = localObject6[0];
          localObject6 = localObject6[1];
          if (localObject5 == null) {
            break label5314;
          }
          bool1 = awij.a().a((awim)localObject5);
          break label5326;
          if (!bool1) {
            this.a.jdField_a_of_type_Awix.a(2, new Object[] { "set preview size failed" + (String)localObject5 });
          }
        }
        else
        {
          if (this.a.jdField_a_of_type_Int == 2)
          {
            localObject5 = ((awij)localObject7).a(awje.j, awje.k, i, j);
            bool1 = bool4;
            if (localObject5 == null) {
              break label5334;
            }
            bool1 = awij.a().a((awim)localObject5);
            break label5334;
          }
          if (this.a.jdField_a_of_type_Int != 5) {
            break label5350;
          }
          if ((Build.MANUFACTURER.equals("Xiaomi")) && (Build.MODEL.equals("MI 3")))
          {
            localObject5 = new awim();
            ((awim)localObject5).jdField_a_of_type_Int = 640;
            ((awim)localObject5).jdField_b_of_type_Int = 480;
            bool1 = bool5;
            if (localObject5 == null) {
              break label5342;
            }
            bool1 = awij.a().a((awim)localObject5);
            break label5342;
          }
          localObject5 = ((awij)localObject7).a(480);
          continue;
        }
        if (!awij.a().a(awje.g))
        {
          this.a.jdField_a_of_type_Awix.a(2, new Object[] { "set preview fps failed" });
          return;
        }
        if ((this.a.jdField_a_of_type_Int != 1) && (this.a.jdField_a_of_type_Int != 4) && (this.a.jdField_a_of_type_Int != 5) && (localObject6 != null) && (!((awij)localObject7).b((awim)localObject6))) {}
        ((awja)localObject1).jdField_a_of_type_Int = awij.a().a();
        ((awja)localObject1).jdField_a_of_type_Awim = awij.a().a();
        localObject5 = awij.a().b();
        if (localObject5 != null)
        {
          ((awja)localObject1).jdField_b_of_type_Awim = ((awim)localObject5);
          ((awja)localObject1).jdField_a_of_type_Boolean = true;
        }
        localObject5 = awij.a().a();
        ((awja)localObject1).jdField_b_of_type_Int = localObject5[0];
        ((awja)localObject1).jdField_c_of_type_Int = localObject5[1];
        if ((this.a.jdField_a_of_type_Int != 1) && (this.a.jdField_a_of_type_Int != 3) && (this.a.jdField_a_of_type_Int != 4) && (this.a.jdField_a_of_type_Int != 5))
        {
          ((awja)localObject1).jdField_b_of_type_Awim = awij.a().b();
          ((awja)localObject1).jdField_a_of_type_Boolean = true;
        }
        if (this.a.jdField_a_of_type_Int == 4) {
          ((awja)localObject1).jdField_a_of_type_Boolean = false;
        }
        ((awja)localObject1).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true);
        Object localObject1 = a();
        if ((!awij.a().a((String)localObject1)) && (!awij.a().a("auto")) && (!awij.a().a(this))) {
          this.a.jdField_a_of_type_Awix.a(9, new Object[] { ajjy.a(2131635535) });
        }
        if (!awij.a().c())
        {
          this.a.jdField_a_of_type_Awix.a(2, new Object[] { "set display orientation failed" });
          return;
          if (!awij.a().a((awja)localObject1))
          {
            this.a.jdField_a_of_type_Awix.a(2, new Object[] { "set Camera Params failed" });
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
        awjd.a(paramMessage);
      }
      Object localObject3 = awij.a().a();
      int i = awij.a().a();
      Object localObject5 = awij.a().a();
      this.a.jdField_a_of_type_Awix.a(2, new Object[] { localObject5, Integer.valueOf(i), localObject3 });
      continue;
      localObject3 = (Object[])paramMessage.obj;
      localObject5 = (awim)localObject3[0];
      Object localObject7 = (awim)localObject3[1];
      i = ((Integer)localObject3[2]).intValue();
      int j = ((Integer)localObject3[3]).intValue();
      bool2 = ((Boolean)localObject3[4]).booleanValue();
      if (QLog.isColorLevel()) {
        QLog.i("CameraProxy", 2, "[handleMessage]SET_PARAMS, , wantedSize = " + localObject5 + " , viewSize = " + localObject7 + " , selectMode = " + i + " , resolutionMode = " + bool2);
      }
      this.a.jdField_a_of_type_Boolean = false;
      awir.a(this.a, false);
      Object localObject6 = awij.a();
      Object localObject8 = awij.a().jdField_a_of_type_Int + "#" + localObject5 + "#" + localObject7 + "#" + i;
      localObject3 = (awja)this.a.jdField_a_of_type_JavaUtilMap.get(localObject8);
      if (localObject3 == null)
      {
        localObject3 = new awja();
        this.a.jdField_a_of_type_JavaUtilMap.put(localObject8, localObject3);
      }
      for (;;)
      {
        for (;;)
        {
          if (!((awja)localObject3).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
          {
            if (!awij.a().e())
            {
              this.a.jdField_a_of_type_Awix.a(2, new Object[] { "set preview format failed" });
              awjd.a(paramMessage);
              return;
            }
            if (!bool2) {}
            for (localObject5 = ((awij)localObject6).a(((awim)localObject5).jdField_a_of_type_Int, ((awim)localObject5).jdField_b_of_type_Int, ((awim)localObject7).jdField_a_of_type_Int, ((awim)localObject7).jdField_b_of_type_Int);; localObject5 = ((awij)localObject6).b(((awim)localObject5).jdField_a_of_type_Int, ((awim)localObject5).jdField_b_of_type_Int, ((awim)localObject7).jdField_a_of_type_Int, ((awim)localObject7).jdField_b_of_type_Int))
            {
              localObject7 = localObject5[0];
              localObject5 = localObject5[1];
              if (localObject7 != null) {
                bool1 = awij.a().a((awim)localObject7);
              }
              if (bool1) {
                break;
              }
              this.a.jdField_a_of_type_Awix.a(2, new Object[] { "set preview size failed" + "" });
              awjd.a(paramMessage);
              return;
            }
            if (((localObject5 == null) || (((awij)localObject6).b((awim)localObject5))) || (!awij.a().a(j)))
            {
              this.a.jdField_a_of_type_Awix.a(2, new Object[] { "set preview fps failed" });
              awjd.a(paramMessage);
              return;
            }
            ((awja)localObject3).jdField_a_of_type_Int = awij.a().a();
            ((awja)localObject3).jdField_a_of_type_Awim = awij.a().a();
            localObject5 = awij.a().b();
            if (localObject5 != null)
            {
              ((awja)localObject3).jdField_b_of_type_Awim = ((awim)localObject5);
              ((awja)localObject3).jdField_a_of_type_Boolean = true;
            }
            localObject5 = awij.a().a();
            ((awja)localObject3).jdField_b_of_type_Int = localObject5[0];
            ((awja)localObject3).jdField_c_of_type_Int = localObject5[1];
            ((awja)localObject3).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true);
          }
          for (;;)
          {
            localObject3 = a();
            if ((!awij.a().a((String)localObject3)) && (!awij.a().a("auto")) && (!awij.a().a(this))) {
              this.a.jdField_a_of_type_Awix.a(9, new Object[] { ajjy.a(2131635532) });
            }
            if (awij.a().c()) {
              break;
            }
            this.a.jdField_a_of_type_Awix.a(2, new Object[] { "set display orientation failed" });
            awjd.a(paramMessage);
            return;
            if (!awij.a().a((awja)localObject3))
            {
              this.a.jdField_a_of_type_Awix.a(2, new Object[] { "set Camera Params failed" });
              awjd.a(paramMessage);
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]Set camera param by cache params");
            }
          }
          localObject3 = awij.a().a();
          i = awij.a().a();
          localObject5 = awij.a().a();
          this.a.jdField_a_of_type_Awix.a(2, new Object[] { localObject5, Integer.valueOf(i), localObject3 });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_DEFAULT");
          }
          localObject3 = a();
          if ((awij.a().a((String)localObject3)) || (awij.a().a("auto")) || (awij.a().a(this))) {
            break;
          }
          this.a.jdField_a_of_type_Awix.a(9, new Object[] { ajjy.a(2131635534) });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_AUTO");
          }
          if (awij.a().a("auto")) {
            break;
          }
          this.a.jdField_a_of_type_Awix.a(9, new Object[] { ajjy.a(2131635533) });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_RECORDING");
          }
          localObject3 = b();
          if (awij.a().a((String)localObject3)) {
            break;
          }
          this.a.jdField_a_of_type_Awix.a(9, new Object[] { ajjy.a(2131635528) });
          break;
          localObject3 = (awiz)paramMessage.obj;
          a(((awiz)localObject3).jdField_a_of_type_AndroidGraphicsRect, ((awiz)localObject3).b, ((awiz)localObject3).jdField_a_of_type_AndroidHardwareCamera$AutoFocusCallback);
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_SET_SURFACE");
          }
          localObject3 = (SurfaceTexture)paramMessage.obj;
          if (awij.a().a((SurfaceTexture)localObject3)) {
            break;
          }
          this.a.jdField_a_of_type_Awix.a(2, new Object[] { "set preview texture failed" });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_SET_SURFACE_HOLDER");
          }
          localObject3 = (SurfaceHolder)paramMessage.obj;
          if (awij.a().a((SurfaceHolder)localObject3)) {
            break;
          }
          this.a.jdField_a_of_type_Awix.a(2, new Object[] { "set surface holder failed" });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_SET_CALLBACK");
          }
          localObject3 = (Camera.PreviewCallback)paramMessage.obj;
          bool1 = bool3;
          if (paramMessage.arg1 > 0) {
            bool1 = true;
          }
          if (awij.a().a((Camera.PreviewCallback)localObject3, bool1)) {
            break;
          }
          this.a.jdField_a_of_type_Awix.a(2, new Object[] { "set preview callback failed" });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_START");
          }
          if (!awij.a().a())
          {
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_START error");
            }
            bhcs.b("CameraProxy", 1, "【Camera 】PREVIEW_START error");
            this.a.jdField_a_of_type_Awix.a(3, new Object[] { "start preview failed" });
            break;
          }
          localObject3 = awij.a();
          if (((awij)localObject3).jdField_a_of_type_Int != 1) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_START " + ((awij)localObject3).jdField_a_of_type_Int);
          }
          bhcs.a("CameraProxy", 1, "【Camera 】PREVIEW_START success cameraID:" + ((awij)localObject3).jdField_a_of_type_Int);
          if ((!((awij)localObject3).d()) || (awir.a(this.a) == null)) {
            break;
          }
          ((awij)localObject3).a(awir.a(this.a));
          ((awij)localObject3).c();
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]FACE_DETECT_SWITCH" + paramMessage.arg1);
          }
          localObject3 = awij.a();
          if ((!((awij)localObject3).d()) || (awir.a(this.a) == null)) {
            break;
          }
          if (paramMessage.arg1 == 1)
          {
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]FACE_DETECT_SWITCH " + ((awij)localObject3).jdField_a_of_type_Int);
            }
            if (((awij)localObject3).jdField_a_of_type_Int != 1) {
              break;
            }
            ((awij)localObject3).a(awir.a(this.a));
            ((awij)localObject3).c();
            break;
          }
          if (paramMessage.arg1 != 2) {
            break;
          }
          ((awij)localObject3).d();
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_STOP");
          }
          bhcs.a("CameraProxy", 1, "【Camera】PREVIEW_STOP success");
          if (!awij.a().b())
          {
            this.a.jdField_a_of_type_Awix.a(4, new Object[] { "stop preview failed" });
            break;
          }
          localObject3 = awij.a();
          if ((!((awij)localObject3).d()) || (awir.a(this.a) == null)) {
            break;
          }
          ((awij)localObject3).d();
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]RELEASE");
          }
          awij.a().b();
          this.a.jdField_a_of_type_Boolean = true;
          try
          {
            Thread.sleep(50L);
            bhcs.a("CameraProxy", 1, "【Camera】RELEASE success");
            this.a.jdField_a_of_type_Awix.a(11, new Object[] { "camera destory" });
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]NIGHT_MODE_ON_OFF" + paramMessage.arg1);
            }
            if (paramMessage.arg1 == 1)
            {
              awir.a(this.a);
              break;
            }
            if (paramMessage.arg1 != 2) {
              break;
            }
            awir.b(this.a);
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]FLASH_LIGHT_ON_OFF");
            }
            if (paramMessage.arg1 == 1)
            {
              if (awij.a().a(true)) {
                break;
              }
              this.a.jdField_a_of_type_Awix.a(6, new Object[] { "turn on flash light failed" });
              break;
            }
            if ((paramMessage.arg1 != 2) || (awij.a().a(false))) {
              break;
            }
            this.a.jdField_a_of_type_Awix.a(6, new Object[] { "turn off flash light failed" });
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]FLASH_LIGHT_SWITCH");
            }
            if (paramMessage.arg1 == 0)
            {
              if (awij.a().f()) {
                break;
              }
              this.a.jdField_a_of_type_Awix.a(6, new Object[] { "switch flash light failed" });
              break;
            }
            if (paramMessage.arg1 == 1)
            {
              if (awij.a().b(true)) {
                break;
              }
              this.a.jdField_a_of_type_Awix.a(6, new Object[] { "turn on flash light failed" });
              break;
            }
            if ((paramMessage.arg1 != 2) || (awij.a().b(false))) {
              break;
            }
            this.a.jdField_a_of_type_Awix.a(6, new Object[] { "turn off flash light failed" });
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]PICTURE_TAKE");
            }
            ahji.a("received");
            localObject3 = (awjc)paramMessage.obj;
            localObject5 = awij.a();
            if (!((awij)localObject5).jdField_a_of_type_Boolean)
            {
              if (QLog.isColorLevel()) {
                QLog.i("CameraProxy", 2, "[takePicture]Camera is not previewing...");
              }
              awjd.a(paramMessage);
              return;
            }
            if (((awjc)localObject3).jdField_a_of_type_JavaIoFile == null)
            {
              this.a.jdField_a_of_type_Awix.a(2, new Object[] { "take picture error" });
              awjd.a(paramMessage);
              return;
            }
            ((awij)localObject5).a(((awjc)localObject3).jdField_a_of_type_JavaIoFile, ((awjc)localObject3).jdField_a_of_type_AndroidGraphicsRect, ((awjc)localObject3).jdField_a_of_type_Ahns, ((awjc)localObject3).jdField_a_of_type_Int, ((awjc)localObject3).jdField_a_of_type_Boolean, ((awjc)localObject3).jdField_b_of_type_Int);
            break;
            i = ((Integer)((Object[])(Object[])paramMessage.obj)[0]).intValue();
            awij.a().b(i);
            break;
            localObject3 = (String)((Object[])(Object[])paramMessage.obj)[0];
            awij.a().b((String)localObject3);
            break;
            localObject3 = (Object[])paramMessage.obj;
            i = ((Integer)localObject3[0]).intValue();
            if ((localObject3[1] instanceof awgs))
            {
              localObject3 = (awgs)localObject3[1];
              if (Camera2Control.a().b())
              {
                awgx.a(1, "[Camera2] camera2 is opening!");
                awjd.a(paramMessage);
                return;
              }
              i = Camera2Control.a().a(i, (awgs)localObject3);
              if (i == 0) {
                break;
              }
              bhcs.b("CameraProxy", 1, "【Camera2 Open Error】EVENT_CAMERA2_ERROR:" + i);
              this.a.jdField_a_of_type_Awix.a(13, new Object[] { Integer.valueOf(i) });
              break;
              localObject3 = (SurfaceTexture)((Object[])(Object[])paramMessage.obj)[0];
              Camera2Control.a().a((SurfaceTexture)localObject3);
              bhcs.a("CameraProxy", 1, "【Camera2】PREVIEW_START");
              break;
              localObject3 = (Camera.PreviewCallback)((Object[])(Object[])paramMessage.obj)[0];
              Camera2Control.a().a((Camera.PreviewCallback)localObject3);
              break;
              Camera2Control.a().e();
              bhcs.a("CameraProxy", 1, "【Camera2】CAMERA2_RELEASE");
              break;
              localObject7 = (Object[])paramMessage.obj;
              localObject5 = (awim)localObject7[0];
              localObject8 = (awim)localObject7[1];
              bool1 = ((Boolean)localObject7[4]).booleanValue();
              localObject3 = new StringBuilder();
              Camera2Control.a();
              localObject6 = Camera2Control.a + "#" + localObject5 + "#" + localObject8;
              if (QLog.isColorLevel()) {
                QLog.i("CameraProxy", 2, "[handleMessage]CAMERA2_SET_PARAMS,wantedSize = " + localObject5 + " , viewSize = " + localObject8 + ",resolutionMode:" + bool1);
              }
              localObject3 = (awjb)this.a.jdField_b_of_type_JavaUtilMap.get(localObject6);
              if (localObject3 == null)
              {
                localObject3 = new awjb();
                this.a.jdField_b_of_type_JavaUtilMap.put(localObject6, localObject3);
                if (!((awjb)localObject3).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
                {
                  localObject6 = Camera2Control.a().a();
                  if (!bool1) {}
                  for (localObject5 = awgx.a(((awim)localObject5).jdField_a_of_type_Int, ((awim)localObject5).jdField_b_of_type_Int, ((awim)localObject8).jdField_a_of_type_Int, ((awim)localObject8).jdField_b_of_type_Int, (awgr)localObject6);; localObject5 = awgx.b(((awim)localObject5).jdField_a_of_type_Int, ((awim)localObject5).jdField_b_of_type_Int, ((awim)localObject8).jdField_a_of_type_Int, ((awim)localObject8).jdField_b_of_type_Int, (awgr)localObject6))
                  {
                    if ((localObject5 == null) || (localObject5.length < 2)) {
                      break label5293;
                    }
                    localObject6 = localObject5[0];
                    localObject5 = localObject5[1];
                    localObject8 = new awim(Math.max(((awim)localObject8).jdField_a_of_type_Int, ((awim)localObject8).jdField_b_of_type_Int), Math.min(((awim)localObject8).jdField_a_of_type_Int, ((awim)localObject8).jdField_b_of_type_Int));
                    localObject8 = Camera2Control.a().a((awim)localObject8);
                    if (Camera2Control.a().a((awim)localObject6)) {
                      break;
                    }
                    this.a.jdField_a_of_type_Awix.a(14, new Object[] { "[Camera2]setCamera2 previewSize error!" });
                    awjd.a(paramMessage);
                    return;
                  }
                  if (!Camera2Control.a().b((awim)localObject5))
                  {
                    this.a.jdField_a_of_type_Awix.a(14, new Object[] { "[Camera2]setCamera2 pictureSize error!" });
                    awjd.a(paramMessage);
                    return;
                  }
                  if (!Camera2Control.a().a(((Integer)localObject7[3]).intValue()))
                  {
                    this.a.jdField_a_of_type_Awix.a(14, new Object[] { "[Camera2]setCamera2 fps error!" });
                    awjd.a(paramMessage);
                    return;
                  }
                  ((awjb)localObject3).jdField_a_of_type_Awim = ((awim)localObject6);
                  ((awjb)localObject3).jdField_b_of_type_Awim = ((awim)localObject5);
                  ((awjb)localObject3).c = ((awim)localObject8);
                  ((awjb)localObject3).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true);
                }
                while (Camera2Control.a().a((awjb)localObject3))
                {
                  localObject3 = Camera2Control.a().b();
                  localObject5 = Camera2Control.a().a();
                  this.a.jdField_a_of_type_Awix.a(14, new Object[] { localObject3, localObject5 });
                  break;
                }
                this.a.jdField_a_of_type_Awix.a(14, new Object[] { "[Camera2]setCamera2ParamOnce error!" });
                awjd.a(paramMessage);
                return;
                if (QLog.isColorLevel()) {
                  QLog.i("CameraProxy", 2, "[handleMessage]CAMERA2_PICTURE_TAKE");
                }
                localObject3 = (awjc)paramMessage.obj;
                if (((awjc)localObject3).jdField_a_of_type_JavaIoFile == null)
                {
                  this.a.jdField_a_of_type_Awix.a(2, new Object[] { "take picture error" });
                  awjd.a(paramMessage);
                  return;
                }
                localObject5 = new awgt();
                ((awgt)localObject5).jdField_a_of_type_Ahns = ((awjc)localObject3).jdField_a_of_type_Ahns;
                ((awgt)localObject5).jdField_a_of_type_Boolean = ((awjc)localObject3).jdField_a_of_type_Boolean;
                ((awgt)localObject5).jdField_a_of_type_Int = ((awjc)localObject3).jdField_a_of_type_Int;
                ((awgt)localObject5).jdField_a_of_type_JavaIoFile = ((awjc)localObject3).jdField_a_of_type_JavaIoFile;
                ((awgt)localObject5).jdField_a_of_type_AndroidGraphicsRect = ((awjc)localObject3).jdField_a_of_type_AndroidGraphicsRect;
                Camera2Control.a().a((awgt)localObject5);
                break;
                if (QLog.isColorLevel()) {
                  QLog.i("CameraProxy", 2, "[handleMessage]CAMERA2_STOP_VIDEO");
                }
                Camera2Control.a().c();
                break;
                localObject3 = (awiz)paramMessage.obj;
                Camera2Control.a().a((awiz)localObject3);
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
                awgx.a(2, "[Camera2] error:" + paramMessage.arg1);
                bhcs.b("CameraProxy", 1, "【Camera2 Open Error】CAMERA2_ERROR_CALLBACK:" + paramMessage.arg1);
                i = paramMessage.arg1;
                switch (i)
                {
                case -203: 
                case -202: 
                case -201: 
                  this.a.jdField_a_of_type_Awix.a(14, new Object[] { "[Camera2]setCamera2 previewSize error:" + i });
                  break;
                case -105: 
                case -102: 
                  this.a.jdField_a_of_type_Awix.a(13, new Object[] { Integer.valueOf(i) });
                }
              }
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              continue;
              label5293:
              localObject5 = null;
              localObject6 = null;
              continue;
              continue;
              Object localObject4 = null;
            }
          }
        }
      }
      label5314:
      bool1 = false;
      break label5326;
      label5320:
      continue;
      label5323:
      continue;
      label5326:
      localObject5 = "";
      continue;
      label5334:
      localObject5 = "";
      continue;
      label5342:
      localObject5 = "";
      continue;
      label5350:
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
    awij.a().a(paramCamera);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awiu
 * JD-Core Version:    0.7.0.1
 */