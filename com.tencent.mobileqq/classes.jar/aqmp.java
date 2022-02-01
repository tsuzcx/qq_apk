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

public class aqmp
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
      aqmm.a(this.jdField_a_of_type_Aqmm).setPreviewTexture((SurfaceTexture)paramObject);
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
        if ((paramMessage.what != 2) && (aqmm.a(this.jdField_a_of_type_Aqmm) != null))
        {
          QLog.e(this.jdField_a_of_type_JavaLangString, 1, "mCamera != null, but RuntimeException");
          try
          {
            aqmm.a(this.jdField_a_of_type_Aqmm).release();
            aqmm.a(this.jdField_a_of_type_Aqmm, null);
            if (paramMessage.obj != null)
            {
              QLog.w(this.jdField_a_of_type_JavaLangString, 1, "相机已经打开，运行时异常 " + paramMessage.what);
              if ((paramMessage.obj instanceof aqmh))
              {
                ((aqmh)paramMessage.obj).b(paramMessage.arg1);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] OPEN_CAMERA " + paramMessage.arg1);
                }
                aqmm.a(this.jdField_a_of_type_Aqmm, Camera.open(paramMessage.arg1));
                if (aqmm.a(this.jdField_a_of_type_Aqmm) != null)
                {
                  aqmm.a(this.jdField_a_of_type_Aqmm, true);
                  if (aqmm.a(this.jdField_a_of_type_Aqmm) == null)
                  {
                    aqmm.a(this.jdField_a_of_type_Aqmm, aqmm.a(this.jdField_a_of_type_Aqmm).getParameters());
                    if (QLog.isColorLevel()) {
                      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] OPEN_CAMERA, parameter = " + aqmm.a(this.jdField_a_of_type_Aqmm));
                    }
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] OPEN_CAMERA, open result mCamera = " + aqmm.a(this.jdField_a_of_type_Aqmm));
                  }
                }
                else
                {
                  if (paramMessage.obj == null) {
                    continue;
                  }
                  ((aqmh)paramMessage.obj).b(paramMessage.arg1);
                  continue;
                }
                continue;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] RELEASE");
                }
                if (aqmm.a(this.jdField_a_of_type_Aqmm) != null) {
                  aqmm.a(this.jdField_a_of_type_Aqmm).release();
                }
                aqmm.a(this.jdField_a_of_type_Aqmm, null);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] RECONNECT");
                }
                aqmm.a(this.jdField_a_of_type_Aqmm, null);
                try
                {
                  if (aqmm.a(this.jdField_a_of_type_Aqmm) == null) {
                    continue;
                  }
                  aqmm.a(this.jdField_a_of_type_Aqmm).reconnect();
                  return;
                }
                catch (IOException localIOException1)
                {
                  aqmm.a(this.jdField_a_of_type_Aqmm, localIOException1);
                  return;
                }
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] UNLOCK");
                }
                if (aqmm.a(this.jdField_a_of_type_Aqmm) == null) {
                  continue;
                }
                aqmm.a(this.jdField_a_of_type_Aqmm).unlock();
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] LOCK");
                }
                if (aqmm.a(this.jdField_a_of_type_Aqmm) == null) {
                  continue;
                }
                aqmm.a(this.jdField_a_of_type_Aqmm).lock();
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
                  if (aqmm.a(this.jdField_a_of_type_Aqmm) == null) {
                    continue;
                  }
                  aqmm.a(this.jdField_a_of_type_Aqmm).setPreviewDisplay((SurfaceHolder)paramMessage.obj);
                  return;
                }
                catch (IOException localIOException2)
                {
                  throw new RuntimeException(localIOException2);
                }
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] START_PREVIEW_ASYNC");
                }
                if (aqmm.a(this.jdField_a_of_type_Aqmm) == null) {
                  continue;
                }
                aqmm.a(this.jdField_a_of_type_Aqmm).startPreview();
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] STOP_PREVIEW");
                }
                try
                {
                  if (aqmm.a(this.jdField_a_of_type_Aqmm) == null) {
                    continue;
                  }
                  aqmm.a(this.jdField_a_of_type_Aqmm).stopPreview();
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
                if (aqmm.a(this.jdField_a_of_type_Aqmm) == null) {
                  continue;
                }
                aqmm.a(this.jdField_a_of_type_Aqmm).setOneShotPreviewCallback((Camera.PreviewCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_PREVIEW_CALLBACK, obj = " + paramMessage.obj);
                }
                if (aqmm.a(this.jdField_a_of_type_Aqmm) == null) {
                  continue;
                }
                aqmm.a(this.jdField_a_of_type_Aqmm).setPreviewCallback((Camera.PreviewCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_PREVIEW_CALLBACK_WITH_BUFFER, obj = " + paramMessage.obj);
                }
                if (aqmm.a(this.jdField_a_of_type_Aqmm) == null) {
                  continue;
                }
                aqmm.a(this.jdField_a_of_type_Aqmm).setPreviewCallbackWithBuffer((Camera.PreviewCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] ADD_CALLBACK_BUFFER");
                }
                if (aqmm.a(this.jdField_a_of_type_Aqmm) == null) {
                  continue;
                }
                aqmm.a(this.jdField_a_of_type_Aqmm).addCallbackBuffer((byte[])paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] AUTO_FOCUS");
                }
                if (aqmm.a(this.jdField_a_of_type_Aqmm) == null) {
                  continue;
                }
                aqmm.a(this.jdField_a_of_type_Aqmm).autoFocus((Camera.AutoFocusCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] CANCEL_AUTO_FOCUS");
                }
                if (aqmm.a(this.jdField_a_of_type_Aqmm) == null) {
                  continue;
                }
                aqmm.a(this.jdField_a_of_type_Aqmm).cancelAutoFocus();
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_AUTO_FOCUS_MOVE_CALLBACK");
                }
                if (aqmm.a(this.jdField_a_of_type_Aqmm) == null) {
                  continue;
                }
                a(aqmm.a(this.jdField_a_of_type_Aqmm), paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_DISPLAY_ORIENTATION");
                }
                if (aqmm.a(this.jdField_a_of_type_Aqmm) == null) {
                  continue;
                }
                aqmm.a(this.jdField_a_of_type_Aqmm).setDisplayOrientation(paramMessage.arg1);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_ZOOM_CHANGE_LISTENER");
                }
                if (aqmm.a(this.jdField_a_of_type_Aqmm) == null) {
                  continue;
                }
                aqmm.a(this.jdField_a_of_type_Aqmm).setZoomChangeListener((Camera.OnZoomChangeListener)paramMessage.obj);
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
                if (aqmm.a(this.jdField_a_of_type_Aqmm) == null) {
                  continue;
                }
                aqmm.a(this.jdField_a_of_type_Aqmm).setErrorCallback((Camera.ErrorCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_PARAMETERS");
                }
                if (aqmm.a(this.jdField_a_of_type_Aqmm) == null) {
                  continue;
                }
                aqmm.a(this.jdField_a_of_type_Aqmm, true);
                aqmm.a(this.jdField_a_of_type_Aqmm).unflatten((String)paramMessage.obj);
                aqmm.a(this.jdField_a_of_type_Aqmm).setParameters(aqmm.a(this.jdField_a_of_type_Aqmm));
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] GET_PARAMETERS");
                }
                if ((aqmm.a(this.jdField_a_of_type_Aqmm) == null) || (!aqmm.a(this.jdField_a_of_type_Aqmm))) {
                  continue;
                }
                aqmm.b(this.jdField_a_of_type_Aqmm, aqmm.a(this.jdField_a_of_type_Aqmm).getParameters());
                aqmm.a(this.jdField_a_of_type_Aqmm, false);
                return;
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] ENABLE_SHUTTER_SOUND");
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] REFRESH_PARAMETERS");
                }
                aqmm.a(this.jdField_a_of_type_Aqmm, true);
                return;
              }
            }
          }
          catch (Exception localException2)
          {
            QLog.e(this.jdField_a_of_type_JavaLangString, 2, "Fail to release the camera.");
            continue;
            if (!(paramMessage.obj instanceof aqmn)) {
              continue;
            }
            ((aqmn)paramMessage.obj).onAutoFocus(false, aqmm.a(this.jdField_a_of_type_Aqmm));
            return;
          }
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "相机参数设置错误, 请尝试重启机器 " + paramMessage.what);
          throw localException1;
        }
        if (aqmm.a(this.jdField_a_of_type_Aqmm) == null) {
          if (paramMessage.what == 1)
          {
            QLog.e(this.jdField_a_of_type_JavaLangString, 1, "mCamera == null Since Camera is disabled");
            if ((paramMessage.obj != null) && ((paramMessage.obj instanceof aqmh))) {
              ((aqmh)paramMessage.obj).a(paramMessage.arg1);
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
 * Qualified Name:     aqmp
 * JD-Core Version:    0.7.0.1
 */