import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.AutoFocusMoveCallback;
import android.hardware.Camera.ErrorCallback;
import android.hardware.Camera.OnZoomChangeListener;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.os.Handler;
import android.os.Message;
import android.view.SurfaceHolder;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class apjl
  extends Handler
{
  private String a;
  
  @TargetApi(16)
  private void a(Camera paramCamera, Object paramObject)
  {
    paramCamera.setAutoFocusMoveCallback((Camera.AutoFocusMoveCallback)paramObject);
  }
  
  @TargetApi(14)
  private void a(Object paramObject)
  {
    try
    {
      apji.a(this.jdField_a_of_type_Apji).setPreviewTexture((SurfaceTexture)paramObject);
      return;
    }
    catch (IOException paramObject)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "Could not set preview texture", paramObject);
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    for (;;)
    {
      try
      {
        switch (paramMessage.what)
        {
        case 1: 
          throw new RuntimeException("Invalid CameraProxy message=" + paramMessage.what);
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        localRuntimeException.printStackTrace();
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, localRuntimeException, new Object[0]);
        if ((paramMessage.what != 2) && (apji.a(this.jdField_a_of_type_Apji) != null))
        {
          QLog.e(this.jdField_a_of_type_JavaLangString, 1, "mCamera != null, but RuntimeException");
          try
          {
            apji.a(this.jdField_a_of_type_Apji).release();
            apji.a(this.jdField_a_of_type_Apji, null);
            if (paramMessage.obj != null)
            {
              QLog.w(this.jdField_a_of_type_JavaLangString, 1, "相机已经打开，运行时异常 " + paramMessage.what);
              if ((paramMessage.obj instanceof apjd))
              {
                ((apjd)paramMessage.obj).b(paramMessage.arg1);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] OPEN_CAMERA " + paramMessage.arg1);
                }
                apji.a(this.jdField_a_of_type_Apji, Camera.open(paramMessage.arg1));
                if (apji.a(this.jdField_a_of_type_Apji) != null)
                {
                  apji.a(this.jdField_a_of_type_Apji, true);
                  if (apji.a(this.jdField_a_of_type_Apji) == null)
                  {
                    apji.a(this.jdField_a_of_type_Apji, apji.a(this.jdField_a_of_type_Apji).getParameters());
                    if (QLog.isColorLevel()) {
                      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] OPEN_CAMERA, parameter = " + apji.a(this.jdField_a_of_type_Apji));
                    }
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] OPEN_CAMERA, open result mCamera = " + apji.a(this.jdField_a_of_type_Apji));
                  }
                }
                else
                {
                  if (paramMessage.obj == null) {
                    continue;
                  }
                  ((apjd)paramMessage.obj).b(paramMessage.arg1);
                  continue;
                }
                continue;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] RELEASE");
                }
                if (apji.a(this.jdField_a_of_type_Apji) != null) {
                  apji.a(this.jdField_a_of_type_Apji).release();
                }
                apji.a(this.jdField_a_of_type_Apji, null);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] RECONNECT");
                }
                apji.a(this.jdField_a_of_type_Apji, null);
                try
                {
                  if (apji.a(this.jdField_a_of_type_Apji) == null) {
                    continue;
                  }
                  apji.a(this.jdField_a_of_type_Apji).reconnect();
                  return;
                }
                catch (IOException localIOException1)
                {
                  apji.a(this.jdField_a_of_type_Apji, localIOException1);
                  return;
                }
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] UNLOCK");
                }
                if (apji.a(this.jdField_a_of_type_Apji) == null) {
                  continue;
                }
                apji.a(this.jdField_a_of_type_Apji).unlock();
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] LOCK");
                }
                if (apji.a(this.jdField_a_of_type_Apji) == null) {
                  continue;
                }
                apji.a(this.jdField_a_of_type_Apji).lock();
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_PREVIEW_TEXTURE_ASYNC");
                }
                a(paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_PREVIEW_DISPLAY");
                }
                try
                {
                  if (apji.a(this.jdField_a_of_type_Apji) == null) {
                    continue;
                  }
                  apji.a(this.jdField_a_of_type_Apji).setPreviewDisplay((SurfaceHolder)paramMessage.obj);
                  return;
                }
                catch (IOException localIOException2)
                {
                  throw new RuntimeException(localIOException2);
                }
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] START_PREVIEW_ASYNC");
                }
                if (apji.a(this.jdField_a_of_type_Apji) == null) {
                  continue;
                }
                apji.a(this.jdField_a_of_type_Apji).startPreview();
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] STOP_PREVIEW");
                }
                try
                {
                  if (apji.a(this.jdField_a_of_type_Apji) == null) {
                    continue;
                  }
                  apji.a(this.jdField_a_of_type_Apji).stopPreview();
                  return;
                }
                catch (Exception localException1)
                {
                  localException1.printStackTrace();
                  return;
                }
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_ONE_SHOT_PREVIEW_CALlBACK");
                }
                if (apji.a(this.jdField_a_of_type_Apji) == null) {
                  continue;
                }
                apji.a(this.jdField_a_of_type_Apji).setOneShotPreviewCallback((Camera.PreviewCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_PREVIEW_CALLBACK, obj = " + paramMessage.obj);
                }
                if (apji.a(this.jdField_a_of_type_Apji) == null) {
                  continue;
                }
                apji.a(this.jdField_a_of_type_Apji).setPreviewCallback((Camera.PreviewCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_PREVIEW_CALLBACK_WITH_BUFFER, obj = " + paramMessage.obj);
                }
                if (apji.a(this.jdField_a_of_type_Apji) == null) {
                  continue;
                }
                apji.a(this.jdField_a_of_type_Apji).setPreviewCallbackWithBuffer((Camera.PreviewCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] ADD_CALLBACK_BUFFER");
                }
                if (apji.a(this.jdField_a_of_type_Apji) == null) {
                  continue;
                }
                apji.a(this.jdField_a_of_type_Apji).addCallbackBuffer((byte[])paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] AUTO_FOCUS");
                }
                if (apji.a(this.jdField_a_of_type_Apji) == null) {
                  continue;
                }
                apji.a(this.jdField_a_of_type_Apji).autoFocus((Camera.AutoFocusCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] CANCEL_AUTO_FOCUS");
                }
                if (apji.a(this.jdField_a_of_type_Apji) == null) {
                  continue;
                }
                apji.a(this.jdField_a_of_type_Apji).cancelAutoFocus();
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_AUTO_FOCUS_MOVE_CALLBACK");
                }
                if (apji.a(this.jdField_a_of_type_Apji) == null) {
                  continue;
                }
                a(apji.a(this.jdField_a_of_type_Apji), paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_DISPLAY_ORIENTATION");
                }
                if (apji.a(this.jdField_a_of_type_Apji) == null) {
                  continue;
                }
                apji.a(this.jdField_a_of_type_Apji).setDisplayOrientation(paramMessage.arg1);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_ZOOM_CHANGE_LISTENER");
                }
                if (apji.a(this.jdField_a_of_type_Apji) == null) {
                  continue;
                }
                apji.a(this.jdField_a_of_type_Apji).setZoomChangeListener((Camera.OnZoomChangeListener)paramMessage.obj);
                return;
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_FACE_DETECTION_LISTENER");
                return;
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] START_FACE_DETECTION");
                return;
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] STOP_FACE_DETECTION");
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_ERROR_CALLBACK");
                }
                if (apji.a(this.jdField_a_of_type_Apji) == null) {
                  continue;
                }
                apji.a(this.jdField_a_of_type_Apji).setErrorCallback((Camera.ErrorCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_PARAMETERS");
                }
                if (apji.a(this.jdField_a_of_type_Apji) == null) {
                  continue;
                }
                apji.a(this.jdField_a_of_type_Apji, true);
                apji.a(this.jdField_a_of_type_Apji).unflatten((String)paramMessage.obj);
                apji.a(this.jdField_a_of_type_Apji).setParameters(apji.a(this.jdField_a_of_type_Apji));
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] GET_PARAMETERS");
                }
                if ((apji.a(this.jdField_a_of_type_Apji) == null) || (!apji.a(this.jdField_a_of_type_Apji))) {
                  continue;
                }
                apji.b(this.jdField_a_of_type_Apji, apji.a(this.jdField_a_of_type_Apji).getParameters());
                apji.a(this.jdField_a_of_type_Apji, false);
                return;
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] ENABLE_SHUTTER_SOUND");
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] REFRESH_PARAMETERS");
                }
                apji.a(this.jdField_a_of_type_Apji, true);
                return;
              }
            }
          }
          catch (Exception localException2)
          {
            QLog.e(this.jdField_a_of_type_JavaLangString, 2, "Fail to release the camera.");
            continue;
            if (!(paramMessage.obj instanceof apjj)) {
              continue;
            }
            ((apjj)paramMessage.obj).onAutoFocus(false, apji.a(this.jdField_a_of_type_Apji));
            return;
          }
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "相机参数设置错误, 请尝试重启机器 " + paramMessage.what);
          throw localException1;
        }
        if (apji.a(this.jdField_a_of_type_Apji) == null) {
          if (paramMessage.what == 1)
          {
            QLog.e(this.jdField_a_of_type_JavaLangString, 1, "mCamera == null Since Camera is disabled");
            if ((paramMessage.obj != null) && ((paramMessage.obj instanceof apjd))) {
              ((apjd)paramMessage.obj).a(paramMessage.arg1);
            }
          }
          else
          {
            QLog.e(this.jdField_a_of_type_JavaLangString, 1, "mCamera == null, Cannot handle message, 相机运行异常，请尝试重启机器");
            throw localException1;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apjl
 * JD-Core Version:    0.7.0.1
 */