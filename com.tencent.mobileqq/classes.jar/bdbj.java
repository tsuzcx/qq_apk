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

public class bdbj
  extends Handler
  implements Camera.AutoFocusCallback
{
  bdbj(bdbg parambdbg, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  @TargetApi(14)
  private void a(Rect paramRect1, Rect paramRect2, Camera.AutoFocusCallback paramAutoFocusCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_REQUEST_FOCUS");
    }
    Camera.Parameters localParameters = bday.a().a();
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
      bday.a().jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters);
    }
    paramRect1 = paramAutoFocusCallback;
    if (paramAutoFocusCallback == null) {
      paramRect1 = new bdbk(this);
    }
    bday.a().a(paramRect1);
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
        bpam.b("CameraProxy", "[handleMessage] OPEN_CAMERA + BEGIN");
        i = ((Integer)((Object[])(Object[])paramMessage.obj)[0]).intValue();
        if (QLog.isColorLevel()) {
          QLog.i("CameraProxy", 2, "[handleMessage] OPEN_CAMERA");
        }
        i = bday.a().a(i);
        bpam.b("CameraProxy", "[handleMessage] OPEN_CAMERA, result = " + i);
        if (i == 5)
        {
          this.a.jdField_a_of_type_Bdbm.a(1, new Object[] { Boolean.valueOf(true) });
          return;
        }
        if (i != 0)
        {
          this.a.jdField_a_of_type_Bdbm.a(1, new Object[] { "open camera failed:errcode=" + bday.a(i) });
          return;
        }
        if (!bday.a().c())
        {
          this.a.jdField_a_of_type_Bdbm.a(1, new Object[] { "open camera failed, orientation error." });
          return;
        }
        this.a.jdField_a_of_type_Bdbm.a(1, new Object[] { Boolean.valueOf(true) });
        this.a.jdField_a_of_type_Boolean = false;
        return;
        if (QLog.isColorLevel()) {
          QLog.i("CameraProxy", 2, "[handleMessage]CHANGED");
        }
        int k = Integer.parseInt(paramMessage.obj.toString());
        i = paramMessage.arg1;
        j = paramMessage.arg2;
        this.a.jdField_a_of_type_Boolean = false;
        bdbg.a(this.a, false);
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
        localObject7 = bday.a();
        if (Build.VERSION.SDK_INT <= 10) {
          bday.a().b();
        }
        if (this.a.jdField_a_of_type_Int == 1)
        {
          localObject1 = this.a.jdField_a_of_type_Bdbp;
          if (((bdbp)localObject1).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
            continue;
          }
          if (!bday.a().e()) {
            this.a.jdField_a_of_type_Bdbm.a(2, new Object[] { "set preview format failed" });
          }
        }
        else
        {
          if (this.a.jdField_a_of_type_Int == 3)
          {
            if (aluf.jdField_a_of_type_Int == 1)
            {
              localObject1 = this.a.jdField_c_of_type_Bdbp;
              continue;
            }
            if (aluf.jdField_a_of_type_Int == 2)
            {
              localObject1 = this.a.jdField_b_of_type_Bdbp;
              continue;
            }
            this.a.jdField_a_of_type_Bdbm.a(2, new Object[] { "set preview format failed[Camera Kind error:PROGNOSIS_FULL_FILTER]" });
            return;
          }
          if (this.a.jdField_a_of_type_Int == 2)
          {
            if (aluf.jdField_a_of_type_Int == 1)
            {
              localObject1 = this.a.e;
              continue;
            }
            if (aluf.jdField_a_of_type_Int == 2)
            {
              localObject1 = this.a.d;
              continue;
            }
            this.a.jdField_a_of_type_Bdbm.a(2, new Object[] { "set preview format failed[Camera Kind error:RATIO_SCREEN]" });
            return;
          }
          if (this.a.jdField_a_of_type_Int == 4)
          {
            if (aluf.jdField_a_of_type_Int == 1)
            {
              localObject1 = this.a.g;
              continue;
            }
            if (aluf.jdField_a_of_type_Int == 2)
            {
              localObject1 = this.a.f;
              continue;
            }
            this.a.jdField_a_of_type_Bdbm.a(2, new Object[] { "set preview format failed[Camera Kind error:PROGNOSIS_FULL_FILTER]" });
            return;
          }
          if (this.a.jdField_a_of_type_Int == 5)
          {
            localObject1 = this.a.h;
            continue;
          }
          this.a.jdField_a_of_type_Bdbm.a(2, new Object[] { "set preview format failed[Preview Selector Error]" });
          return;
        }
        localObject6 = null;
        if ((this.a.jdField_a_of_type_Int == 1) || (this.a.jdField_a_of_type_Int == 3) || (this.a.jdField_a_of_type_Int == 4))
        {
          localObject6 = ((bday)localObject7).c(bdbt.j, bdbt.k, this.a.jdField_b_of_type_Int, this.a.jdField_c_of_type_Int);
          localObject5 = localObject6[0];
          localObject6 = localObject6[1];
          if (localObject5 == null) {
            break label5330;
          }
          bool1 = bday.a().a((bdbb)localObject5);
          break label5342;
          if (!bool1) {
            this.a.jdField_a_of_type_Bdbm.a(2, new Object[] { "set preview size failed" + (String)localObject5 });
          }
        }
        else
        {
          if (this.a.jdField_a_of_type_Int == 2)
          {
            localObject5 = ((bday)localObject7).a(bdbt.j, bdbt.k, i, j);
            bool1 = bool4;
            if (localObject5 == null) {
              break label5350;
            }
            bool1 = bday.a().a((bdbb)localObject5);
            break label5350;
          }
          if (this.a.jdField_a_of_type_Int != 5) {
            break label5366;
          }
          if ((Build.MANUFACTURER.equals("Xiaomi")) && (Build.MODEL.equals("MI 3")))
          {
            localObject5 = new bdbb();
            ((bdbb)localObject5).jdField_a_of_type_Int = 640;
            ((bdbb)localObject5).jdField_b_of_type_Int = 480;
            bool1 = bool5;
            if (localObject5 == null) {
              break label5358;
            }
            bool1 = bday.a().a((bdbb)localObject5);
            break label5358;
          }
          localObject5 = ((bday)localObject7).a(480);
          continue;
        }
        if (!bday.a().a(bdbt.g))
        {
          this.a.jdField_a_of_type_Bdbm.a(2, new Object[] { "set preview fps failed" });
          return;
        }
        if ((this.a.jdField_a_of_type_Int != 1) && (this.a.jdField_a_of_type_Int != 4) && (this.a.jdField_a_of_type_Int != 5) && (localObject6 != null) && (!((bday)localObject7).b((bdbb)localObject6))) {}
        ((bdbp)localObject1).jdField_a_of_type_Int = bday.a().a();
        ((bdbp)localObject1).jdField_a_of_type_Bdbb = bday.a().a();
        localObject5 = bday.a().b();
        if (localObject5 != null)
        {
          ((bdbp)localObject1).jdField_b_of_type_Bdbb = ((bdbb)localObject5);
          ((bdbp)localObject1).jdField_a_of_type_Boolean = true;
        }
        localObject5 = bday.a().a();
        ((bdbp)localObject1).jdField_b_of_type_Int = localObject5[0];
        ((bdbp)localObject1).jdField_c_of_type_Int = localObject5[1];
        if ((this.a.jdField_a_of_type_Int != 1) && (this.a.jdField_a_of_type_Int != 3) && (this.a.jdField_a_of_type_Int != 4) && (this.a.jdField_a_of_type_Int != 5))
        {
          ((bdbp)localObject1).jdField_b_of_type_Bdbb = bday.a().b();
          ((bdbp)localObject1).jdField_a_of_type_Boolean = true;
        }
        if (this.a.jdField_a_of_type_Int == 4) {
          ((bdbp)localObject1).jdField_a_of_type_Boolean = false;
        }
        ((bdbp)localObject1).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true);
        Object localObject1 = a();
        if ((!bday.a().a((String)localObject1)) && (!bday.a().a("auto")) && (!bday.a().a(this))) {
          this.a.jdField_a_of_type_Bdbm.a(9, new Object[] { anzj.a(2131700242) });
        }
        if (!bday.a().c())
        {
          this.a.jdField_a_of_type_Bdbm.a(2, new Object[] { "set display orientation failed" });
          return;
          if (!bday.a().a((bdbp)localObject1))
          {
            this.a.jdField_a_of_type_Bdbm.a(2, new Object[] { "set Camera Params failed" });
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
        bdbs.a(paramMessage);
      }
      Object localObject3 = bday.a().a();
      int i = bday.a().a();
      Object localObject5 = bday.a().a();
      this.a.jdField_a_of_type_Bdbm.a(2, new Object[] { localObject5, Integer.valueOf(i), localObject3 });
      continue;
      localObject3 = (Object[])paramMessage.obj;
      localObject5 = (bdbb)localObject3[0];
      Object localObject7 = (bdbb)localObject3[1];
      i = ((Integer)localObject3[2]).intValue();
      int j = ((Integer)localObject3[3]).intValue();
      bool2 = ((Boolean)localObject3[4]).booleanValue();
      if (QLog.isColorLevel()) {
        QLog.i("CameraProxy", 2, "[handleMessage] SET_PARAMS, , wantedSize = " + localObject5 + " , viewSize = " + localObject7 + " , selectMode = " + i + " , resolutionMode = " + bool2);
      }
      this.a.jdField_a_of_type_Boolean = false;
      bdbg.a(this.a, false);
      Object localObject6 = bday.a();
      Object localObject8 = bday.a().jdField_a_of_type_Int + "#" + localObject5 + "#" + localObject7 + "#" + i;
      localObject3 = (bdbp)this.a.jdField_a_of_type_JavaUtilMap.get(localObject8);
      if (localObject3 == null)
      {
        localObject3 = new bdbp();
        this.a.jdField_a_of_type_JavaUtilMap.put(localObject8, localObject3);
      }
      for (;;)
      {
        for (;;)
        {
          if (!((bdbp)localObject3).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
          {
            if (!bday.a().e())
            {
              this.a.jdField_a_of_type_Bdbm.a(2, new Object[] { "set preview format failed" });
              bdbs.a(paramMessage);
              return;
            }
            if (!bool2) {}
            for (localObject5 = ((bday)localObject6).a(((bdbb)localObject5).jdField_a_of_type_Int, ((bdbb)localObject5).jdField_b_of_type_Int, ((bdbb)localObject7).jdField_a_of_type_Int, ((bdbb)localObject7).jdField_b_of_type_Int);; localObject5 = ((bday)localObject6).b(((bdbb)localObject5).jdField_a_of_type_Int, ((bdbb)localObject5).jdField_b_of_type_Int, ((bdbb)localObject7).jdField_a_of_type_Int, ((bdbb)localObject7).jdField_b_of_type_Int))
            {
              localObject7 = localObject5[0];
              localObject5 = localObject5[1];
              if (localObject7 != null) {
                bool1 = bday.a().a((bdbb)localObject7);
              }
              if (bool1) {
                break;
              }
              this.a.jdField_a_of_type_Bdbm.a(2, new Object[] { "set preview size failed" + "" });
              bdbs.a(paramMessage);
              return;
            }
            if (((localObject5 == null) || (((bday)localObject6).b((bdbb)localObject5))) || (!bday.a().a(j)))
            {
              this.a.jdField_a_of_type_Bdbm.a(2, new Object[] { "set preview fps failed" });
              bdbs.a(paramMessage);
              return;
            }
            ((bdbp)localObject3).jdField_a_of_type_Int = bday.a().a();
            ((bdbp)localObject3).jdField_a_of_type_Bdbb = bday.a().a();
            localObject5 = bday.a().b();
            if (localObject5 != null)
            {
              ((bdbp)localObject3).jdField_b_of_type_Bdbb = ((bdbb)localObject5);
              ((bdbp)localObject3).jdField_a_of_type_Boolean = true;
            }
            localObject5 = bday.a().a();
            ((bdbp)localObject3).jdField_b_of_type_Int = localObject5[0];
            ((bdbp)localObject3).jdField_c_of_type_Int = localObject5[1];
            ((bdbp)localObject3).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true);
          }
          for (;;)
          {
            localObject3 = a();
            if ((!bday.a().a((String)localObject3)) && (!bday.a().a("auto")) && (!bday.a().a(this))) {
              this.a.jdField_a_of_type_Bdbm.a(9, new Object[] { anzj.a(2131700239) });
            }
            if (bday.a().c()) {
              break;
            }
            this.a.jdField_a_of_type_Bdbm.a(2, new Object[] { "set display orientation failed" });
            bdbs.a(paramMessage);
            return;
            if (!bday.a().a((bdbp)localObject3))
            {
              this.a.jdField_a_of_type_Bdbm.a(2, new Object[] { "set Camera Params failed" });
              bdbs.a(paramMessage);
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage] Set camera param by cache params");
            }
          }
          localObject3 = bday.a().a();
          i = bday.a().a();
          localObject5 = bday.a().a();
          this.a.jdField_a_of_type_Bdbm.a(2, new Object[] { localObject5, Integer.valueOf(i), localObject3 });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_DEFAULT");
          }
          localObject3 = a();
          if ((bday.a().a((String)localObject3)) || (bday.a().a("auto")) || (bday.a().a(this))) {
            break;
          }
          this.a.jdField_a_of_type_Bdbm.a(9, new Object[] { anzj.a(2131700241) });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_AUTO");
          }
          if (bday.a().a("auto")) {
            break;
          }
          this.a.jdField_a_of_type_Bdbm.a(9, new Object[] { anzj.a(2131700240) });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]SET_FOCUS_MODE_RECORDING");
          }
          localObject3 = b();
          if (bday.a().a((String)localObject3)) {
            break;
          }
          this.a.jdField_a_of_type_Bdbm.a(9, new Object[] { anzj.a(2131700235) });
          break;
          localObject3 = (bdbo)paramMessage.obj;
          a(((bdbo)localObject3).jdField_a_of_type_AndroidGraphicsRect, ((bdbo)localObject3).b, ((bdbo)localObject3).jdField_a_of_type_AndroidHardwareCamera$AutoFocusCallback);
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_SET_SURFACE");
          }
          localObject3 = (SurfaceTexture)paramMessage.obj;
          if (bday.a().a((SurfaceTexture)localObject3)) {
            break;
          }
          this.a.jdField_a_of_type_Bdbm.a(2, new Object[] { "set preview texture failed" });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_SET_SURFACE_HOLDER");
          }
          localObject3 = (SurfaceHolder)paramMessage.obj;
          if (bday.a().a((SurfaceHolder)localObject3)) {
            break;
          }
          this.a.jdField_a_of_type_Bdbm.a(2, new Object[] { "set surface holder failed" });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_SET_CALLBACK");
          }
          localObject3 = (Camera.PreviewCallback)paramMessage.obj;
          bool1 = bool3;
          if (paramMessage.arg1 > 0) {
            bool1 = true;
          }
          if (bday.a().a((Camera.PreviewCallback)localObject3, bool1)) {
            break;
          }
          this.a.jdField_a_of_type_Bdbm.a(2, new Object[] { "set preview callback failed" });
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_START");
          }
          if (!bday.a().a())
          {
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_START error");
            }
            bpam.b("CameraProxy", "[handleMessage] PREVIEW_START");
            this.a.jdField_a_of_type_Bdbm.a(3, new Object[] { "start preview failed" });
            break;
          }
          localObject3 = bday.a();
          if (((bday)localObject3).jdField_a_of_type_Int != 1) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_START, cameraId = " + ((bday)localObject3).jdField_a_of_type_Int);
          }
          bpam.b("CameraProxy", "【Camera 】PREVIEW_START success cameraID:" + ((bday)localObject3).jdField_a_of_type_Int);
          if ((!((bday)localObject3).d()) || (bdbg.a(this.a) == null)) {
            break;
          }
          QLog.i("CameraProxy", 2, "[handleMessage] PREVIEW_START, startFaceDetection");
          ((bday)localObject3).a(bdbg.a(this.a));
          ((bday)localObject3).c();
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]FACE_DETECT_SWITCH" + paramMessage.arg1);
          }
          localObject3 = bday.a();
          if ((!((bday)localObject3).d()) || (bdbg.a(this.a) == null)) {
            break;
          }
          if (paramMessage.arg1 == 1)
          {
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]FACE_DETECT_SWITCH " + ((bday)localObject3).jdField_a_of_type_Int);
            }
            if (((bday)localObject3).jdField_a_of_type_Int != 1) {
              break;
            }
            ((bday)localObject3).a(bdbg.a(this.a));
            ((bday)localObject3).c();
            break;
          }
          if (paramMessage.arg1 != 2) {
            break;
          }
          ((bday)localObject3).d();
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]PREVIEW_STOP");
          }
          bpam.b("CameraProxy", "【Camera】PREVIEW_STOP success");
          if (!bday.a().b())
          {
            this.a.jdField_a_of_type_Bdbm.a(4, new Object[] { "stop preview failed" });
            break;
          }
          localObject3 = bday.a();
          if ((!((bday)localObject3).d()) || (bdbg.a(this.a) == null)) {
            break;
          }
          ((bday)localObject3).d();
          break;
          if (QLog.isColorLevel()) {
            QLog.i("CameraProxy", 2, "[handleMessage]RELEASE");
          }
          bday.a().b();
          this.a.jdField_a_of_type_Boolean = true;
          try
          {
            Thread.sleep(50L);
            bpam.b("CameraProxy", "【Camera】RELEASE success");
            this.a.jdField_a_of_type_Bdbm.a(11, new Object[] { "camera destory" });
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]NIGHT_MODE_ON_OFF" + paramMessage.arg1);
            }
            if (paramMessage.arg1 == 1)
            {
              bdbg.a(this.a);
              break;
            }
            if (paramMessage.arg1 != 2) {
              break;
            }
            bdbg.b(this.a);
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]FLASH_LIGHT_ON_OFF");
            }
            if (paramMessage.arg1 == 1)
            {
              if (bday.a().a(true)) {
                break;
              }
              this.a.jdField_a_of_type_Bdbm.a(6, new Object[] { "turn on flash light failed" });
              break;
            }
            if ((paramMessage.arg1 != 2) || (bday.a().a(false))) {
              break;
            }
            this.a.jdField_a_of_type_Bdbm.a(6, new Object[] { "turn off flash light failed" });
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]FLASH_LIGHT_SWITCH");
            }
            if (paramMessage.arg1 == 0)
            {
              if (bday.a().f()) {
                break;
              }
              this.a.jdField_a_of_type_Bdbm.a(6, new Object[] { "switch flash light failed" });
              break;
            }
            if (paramMessage.arg1 == 1)
            {
              if (bday.a().b(true)) {
                break;
              }
              this.a.jdField_a_of_type_Bdbm.a(6, new Object[] { "turn on flash light failed" });
              break;
            }
            if ((paramMessage.arg1 != 2) || (bday.a().b(false))) {
              break;
            }
            this.a.jdField_a_of_type_Bdbm.a(6, new Object[] { "turn off flash light failed" });
            break;
            if (QLog.isColorLevel()) {
              QLog.i("CameraProxy", 2, "[handleMessage]PICTURE_TAKE");
            }
            alwe.a("received");
            localObject3 = (bdbr)paramMessage.obj;
            localObject5 = bday.a();
            if (!((bday)localObject5).jdField_a_of_type_Boolean)
            {
              if (QLog.isColorLevel()) {
                QLog.i("CameraProxy", 2, "[takePicture]Camera is not previewing...");
              }
              bdbs.a(paramMessage);
              return;
            }
            if (((bdbr)localObject3).jdField_a_of_type_JavaIoFile == null)
            {
              this.a.jdField_a_of_type_Bdbm.a(2, new Object[] { "take picture error" });
              bdbs.a(paramMessage);
              return;
            }
            ((bday)localObject5).a(((bdbr)localObject3).jdField_a_of_type_JavaIoFile, ((bdbr)localObject3).jdField_a_of_type_AndroidGraphicsRect, ((bdbr)localObject3).jdField_a_of_type_Amap, ((bdbr)localObject3).jdField_a_of_type_Int, ((bdbr)localObject3).jdField_a_of_type_Boolean, ((bdbr)localObject3).jdField_b_of_type_Int);
            break;
            i = ((Integer)((Object[])(Object[])paramMessage.obj)[0]).intValue();
            bday.a().b(i);
            break;
            localObject3 = (String)((Object[])(Object[])paramMessage.obj)[0];
            bday.a().b((String)localObject3);
            break;
            bpam.b("CameraProxy", "camera2 open in.");
            localObject3 = (Object[])paramMessage.obj;
            i = ((Integer)localObject3[0]).intValue();
            if ((localObject3[1] instanceof bczh))
            {
              localObject3 = (bczh)localObject3[1];
              if (Camera2Control.a().b())
              {
                bczm.a(1, "[Camera2] camera2 is opening!");
                bdbs.a(paramMessage);
                return;
              }
              i = Camera2Control.a().a(i, (bczh)localObject3);
              if (i == 0) {
                break;
              }
              bpam.d("CameraProxy", "【Camera2 Open Error】EVENT_CAMERA2_ERROR:" + i);
              this.a.jdField_a_of_type_Bdbm.a(13, new Object[] { Integer.valueOf(i) });
              break;
              localObject3 = (SurfaceTexture)((Object[])(Object[])paramMessage.obj)[0];
              Camera2Control.a().a((SurfaceTexture)localObject3);
              bpam.b("CameraProxy", "【Camera2】PREVIEW_START");
              break;
              localObject3 = (Camera.PreviewCallback)((Object[])(Object[])paramMessage.obj)[0];
              Camera2Control.a().a((Camera.PreviewCallback)localObject3);
              break;
              Camera2Control.a().e();
              bpam.b("CameraProxy", "【Camera2】CAMERA2_RELEASE");
              break;
              localObject7 = (Object[])paramMessage.obj;
              localObject5 = (bdbb)localObject7[0];
              localObject8 = (bdbb)localObject7[1];
              bool1 = ((Boolean)localObject7[4]).booleanValue();
              localObject3 = new StringBuilder();
              Camera2Control.a();
              localObject6 = Camera2Control.a + "#" + localObject5 + "#" + localObject8;
              if (QLog.isColorLevel()) {
                QLog.i("CameraProxy", 2, "[handleMessage]CAMERA2_SET_PARAMS,wantedSize = " + localObject5 + " , viewSize = " + localObject8 + ",resolutionMode:" + bool1);
              }
              localObject3 = (bdbq)this.a.jdField_b_of_type_JavaUtilMap.get(localObject6);
              if (localObject3 == null)
              {
                localObject3 = new bdbq();
                this.a.jdField_b_of_type_JavaUtilMap.put(localObject6, localObject3);
                if (!((bdbq)localObject3).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
                {
                  localObject6 = Camera2Control.a().a();
                  if (!bool1) {}
                  for (localObject5 = bczm.a(((bdbb)localObject5).jdField_a_of_type_Int, ((bdbb)localObject5).jdField_b_of_type_Int, ((bdbb)localObject8).jdField_a_of_type_Int, ((bdbb)localObject8).jdField_b_of_type_Int, (bczg)localObject6);; localObject5 = bczm.b(((bdbb)localObject5).jdField_a_of_type_Int, ((bdbb)localObject5).jdField_b_of_type_Int, ((bdbb)localObject8).jdField_a_of_type_Int, ((bdbb)localObject8).jdField_b_of_type_Int, (bczg)localObject6))
                  {
                    if ((localObject5 == null) || (localObject5.length < 2)) {
                      break label5309;
                    }
                    localObject6 = localObject5[0];
                    localObject5 = localObject5[1];
                    localObject8 = new bdbb(Math.max(((bdbb)localObject8).jdField_a_of_type_Int, ((bdbb)localObject8).jdField_b_of_type_Int), Math.min(((bdbb)localObject8).jdField_a_of_type_Int, ((bdbb)localObject8).jdField_b_of_type_Int));
                    localObject8 = Camera2Control.a().a((bdbb)localObject8);
                    if (Camera2Control.a().a((bdbb)localObject6)) {
                      break;
                    }
                    this.a.jdField_a_of_type_Bdbm.a(14, new Object[] { "[Camera2]setCamera2 previewSize error!" });
                    bdbs.a(paramMessage);
                    return;
                  }
                  if (!Camera2Control.a().b((bdbb)localObject5))
                  {
                    this.a.jdField_a_of_type_Bdbm.a(14, new Object[] { "[Camera2]setCamera2 pictureSize error!" });
                    bdbs.a(paramMessage);
                    return;
                  }
                  if (!Camera2Control.a().a(((Integer)localObject7[3]).intValue()))
                  {
                    this.a.jdField_a_of_type_Bdbm.a(14, new Object[] { "[Camera2]setCamera2 fps error!" });
                    bdbs.a(paramMessage);
                    return;
                  }
                  ((bdbq)localObject3).jdField_a_of_type_Bdbb = ((bdbb)localObject6);
                  ((bdbq)localObject3).jdField_b_of_type_Bdbb = ((bdbb)localObject5);
                  ((bdbq)localObject3).c = ((bdbb)localObject8);
                  ((bdbq)localObject3).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true);
                }
                while (Camera2Control.a().a((bdbq)localObject3))
                {
                  localObject3 = Camera2Control.a().b();
                  localObject5 = Camera2Control.a().a();
                  this.a.jdField_a_of_type_Bdbm.a(14, new Object[] { localObject3, localObject5 });
                  break;
                }
                this.a.jdField_a_of_type_Bdbm.a(14, new Object[] { "[Camera2]setCamera2ParamOnce error!" });
                bdbs.a(paramMessage);
                return;
                if (QLog.isColorLevel()) {
                  QLog.i("CameraProxy", 2, "[handleMessage]CAMERA2_PICTURE_TAKE");
                }
                localObject3 = (bdbr)paramMessage.obj;
                if (((bdbr)localObject3).jdField_a_of_type_JavaIoFile == null)
                {
                  this.a.jdField_a_of_type_Bdbm.a(2, new Object[] { "take picture error" });
                  bdbs.a(paramMessage);
                  return;
                }
                localObject5 = new bczi();
                ((bczi)localObject5).jdField_a_of_type_Amap = ((bdbr)localObject3).jdField_a_of_type_Amap;
                ((bczi)localObject5).jdField_a_of_type_Boolean = ((bdbr)localObject3).jdField_a_of_type_Boolean;
                ((bczi)localObject5).jdField_a_of_type_Int = ((bdbr)localObject3).jdField_a_of_type_Int;
                ((bczi)localObject5).jdField_a_of_type_JavaIoFile = ((bdbr)localObject3).jdField_a_of_type_JavaIoFile;
                ((bczi)localObject5).jdField_a_of_type_AndroidGraphicsRect = ((bdbr)localObject3).jdField_a_of_type_AndroidGraphicsRect;
                Camera2Control.a().a((bczi)localObject5);
                break;
                if (QLog.isColorLevel()) {
                  QLog.i("CameraProxy", 2, "[handleMessage]CAMERA2_STOP_VIDEO");
                }
                Camera2Control.a().c();
                break;
                localObject3 = (bdbo)paramMessage.obj;
                Camera2Control.a().a((bdbo)localObject3);
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
                bpam.d("CameraProxy", "【Camera2 Open Error】CAMERA2_ERROR_CALLBACK:" + paramMessage.arg1);
                i = paramMessage.arg1;
                switch (i)
                {
                case -203: 
                case -202: 
                case -201: 
                  this.a.jdField_a_of_type_Bdbm.a(14, new Object[] { "[Camera2]setCamera2 previewSize error:" + i });
                  break;
                case -105: 
                case -102: 
                  this.a.jdField_a_of_type_Bdbm.a(13, new Object[] { Integer.valueOf(i) });
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
    bday.a().a(paramCamera);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdbj
 * JD-Core Version:    0.7.0.1
 */