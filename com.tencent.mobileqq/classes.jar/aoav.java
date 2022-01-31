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

public class aoav
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
      aoas.a(this.jdField_a_of_type_Aoas).setPreviewTexture((SurfaceTexture)paramObject);
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
        if ((paramMessage.what != 2) && (aoas.a(this.jdField_a_of_type_Aoas) != null))
        {
          QLog.e(this.jdField_a_of_type_JavaLangString, 1, "mCamera != null, but RuntimeException");
          try
          {
            aoas.a(this.jdField_a_of_type_Aoas).release();
            aoas.a(this.jdField_a_of_type_Aoas, null);
            if (paramMessage.obj != null)
            {
              QLog.w(this.jdField_a_of_type_JavaLangString, 1, "相机已经打开，运行时异常 " + paramMessage.what);
              if ((paramMessage.obj instanceof aoan))
              {
                ((aoan)paramMessage.obj).b(paramMessage.arg1);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] OPEN_CAMERA " + paramMessage.arg1);
                }
                aoas.a(this.jdField_a_of_type_Aoas, Camera.open(paramMessage.arg1));
                if (aoas.a(this.jdField_a_of_type_Aoas) != null)
                {
                  aoas.a(this.jdField_a_of_type_Aoas, true);
                  if (aoas.a(this.jdField_a_of_type_Aoas) == null)
                  {
                    aoas.a(this.jdField_a_of_type_Aoas, aoas.a(this.jdField_a_of_type_Aoas).getParameters());
                    if (QLog.isColorLevel()) {
                      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] OPEN_CAMERA, parameter = " + aoas.a(this.jdField_a_of_type_Aoas));
                    }
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] OPEN_CAMERA, open result mCamera = " + aoas.a(this.jdField_a_of_type_Aoas));
                  }
                }
                else
                {
                  if (paramMessage.obj == null) {
                    continue;
                  }
                  ((aoan)paramMessage.obj).b(paramMessage.arg1);
                  continue;
                }
                continue;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] RELEASE");
                }
                if (aoas.a(this.jdField_a_of_type_Aoas) != null) {
                  aoas.a(this.jdField_a_of_type_Aoas).release();
                }
                aoas.a(this.jdField_a_of_type_Aoas, null);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] RECONNECT");
                }
                aoas.a(this.jdField_a_of_type_Aoas, null);
                try
                {
                  if (aoas.a(this.jdField_a_of_type_Aoas) == null) {
                    continue;
                  }
                  aoas.a(this.jdField_a_of_type_Aoas).reconnect();
                  return;
                }
                catch (IOException localIOException1)
                {
                  aoas.a(this.jdField_a_of_type_Aoas, localIOException1);
                  return;
                }
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] UNLOCK");
                }
                if (aoas.a(this.jdField_a_of_type_Aoas) == null) {
                  continue;
                }
                aoas.a(this.jdField_a_of_type_Aoas).unlock();
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] LOCK");
                }
                if (aoas.a(this.jdField_a_of_type_Aoas) == null) {
                  continue;
                }
                aoas.a(this.jdField_a_of_type_Aoas).lock();
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
                  if (aoas.a(this.jdField_a_of_type_Aoas) == null) {
                    continue;
                  }
                  aoas.a(this.jdField_a_of_type_Aoas).setPreviewDisplay((SurfaceHolder)paramMessage.obj);
                  return;
                }
                catch (IOException localIOException2)
                {
                  throw new RuntimeException(localIOException2);
                }
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] START_PREVIEW_ASYNC");
                }
                if (aoas.a(this.jdField_a_of_type_Aoas) == null) {
                  continue;
                }
                aoas.a(this.jdField_a_of_type_Aoas).startPreview();
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] STOP_PREVIEW");
                }
                try
                {
                  if (aoas.a(this.jdField_a_of_type_Aoas) == null) {
                    continue;
                  }
                  aoas.a(this.jdField_a_of_type_Aoas).stopPreview();
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
                if (aoas.a(this.jdField_a_of_type_Aoas) == null) {
                  continue;
                }
                aoas.a(this.jdField_a_of_type_Aoas).setOneShotPreviewCallback((Camera.PreviewCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_PREVIEW_CALLBACK, obj = " + paramMessage.obj);
                }
                if (aoas.a(this.jdField_a_of_type_Aoas) == null) {
                  continue;
                }
                aoas.a(this.jdField_a_of_type_Aoas).setPreviewCallback((Camera.PreviewCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_PREVIEW_CALLBACK_WITH_BUFFER, obj = " + paramMessage.obj);
                }
                if (aoas.a(this.jdField_a_of_type_Aoas) == null) {
                  continue;
                }
                aoas.a(this.jdField_a_of_type_Aoas).setPreviewCallbackWithBuffer((Camera.PreviewCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] ADD_CALLBACK_BUFFER");
                }
                if (aoas.a(this.jdField_a_of_type_Aoas) == null) {
                  continue;
                }
                aoas.a(this.jdField_a_of_type_Aoas).addCallbackBuffer((byte[])paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] AUTO_FOCUS");
                }
                if (aoas.a(this.jdField_a_of_type_Aoas) == null) {
                  continue;
                }
                aoas.a(this.jdField_a_of_type_Aoas).autoFocus((Camera.AutoFocusCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] CANCEL_AUTO_FOCUS");
                }
                if (aoas.a(this.jdField_a_of_type_Aoas) == null) {
                  continue;
                }
                aoas.a(this.jdField_a_of_type_Aoas).cancelAutoFocus();
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_AUTO_FOCUS_MOVE_CALLBACK");
                }
                if (aoas.a(this.jdField_a_of_type_Aoas) == null) {
                  continue;
                }
                a(aoas.a(this.jdField_a_of_type_Aoas), paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_DISPLAY_ORIENTATION");
                }
                if (aoas.a(this.jdField_a_of_type_Aoas) == null) {
                  continue;
                }
                aoas.a(this.jdField_a_of_type_Aoas).setDisplayOrientation(paramMessage.arg1);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_ZOOM_CHANGE_LISTENER");
                }
                if (aoas.a(this.jdField_a_of_type_Aoas) == null) {
                  continue;
                }
                aoas.a(this.jdField_a_of_type_Aoas).setZoomChangeListener((Camera.OnZoomChangeListener)paramMessage.obj);
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
                if (aoas.a(this.jdField_a_of_type_Aoas) == null) {
                  continue;
                }
                aoas.a(this.jdField_a_of_type_Aoas).setErrorCallback((Camera.ErrorCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_PARAMETERS");
                }
                if (aoas.a(this.jdField_a_of_type_Aoas) == null) {
                  continue;
                }
                aoas.a(this.jdField_a_of_type_Aoas, true);
                aoas.a(this.jdField_a_of_type_Aoas).unflatten((String)paramMessage.obj);
                aoas.a(this.jdField_a_of_type_Aoas).setParameters(aoas.a(this.jdField_a_of_type_Aoas));
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] GET_PARAMETERS");
                }
                if ((aoas.a(this.jdField_a_of_type_Aoas) == null) || (!aoas.a(this.jdField_a_of_type_Aoas))) {
                  continue;
                }
                aoas.b(this.jdField_a_of_type_Aoas, aoas.a(this.jdField_a_of_type_Aoas).getParameters());
                aoas.a(this.jdField_a_of_type_Aoas, false);
                return;
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] ENABLE_SHUTTER_SOUND");
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] REFRESH_PARAMETERS");
                }
                aoas.a(this.jdField_a_of_type_Aoas, true);
                return;
              }
            }
          }
          catch (Exception localException2)
          {
            QLog.e(this.jdField_a_of_type_JavaLangString, 2, "Fail to release the camera.");
            continue;
            if (!(paramMessage.obj instanceof aoat)) {
              continue;
            }
            ((aoat)paramMessage.obj).onAutoFocus(false, aoas.a(this.jdField_a_of_type_Aoas));
            return;
          }
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "相机参数设置错误, 请尝试重启机器 " + paramMessage.what);
          throw localException1;
        }
        if (aoas.a(this.jdField_a_of_type_Aoas) == null) {
          if (paramMessage.what == 1)
          {
            QLog.e(this.jdField_a_of_type_JavaLangString, 1, "mCamera == null Since Camera is disabled");
            if ((paramMessage.obj != null) && ((paramMessage.obj instanceof aoan))) {
              ((aoan)paramMessage.obj).a(paramMessage.arg1);
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
 * Qualified Name:     aoav
 * JD-Core Version:    0.7.0.1
 */