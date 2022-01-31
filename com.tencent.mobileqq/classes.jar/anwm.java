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

public class anwm
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
      anwj.a(this.jdField_a_of_type_Anwj).setPreviewTexture((SurfaceTexture)paramObject);
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
        if ((paramMessage.what != 2) && (anwj.a(this.jdField_a_of_type_Anwj) != null))
        {
          QLog.e(this.jdField_a_of_type_JavaLangString, 1, "mCamera != null, but RuntimeException");
          try
          {
            anwj.a(this.jdField_a_of_type_Anwj).release();
            anwj.a(this.jdField_a_of_type_Anwj, null);
            if (paramMessage.obj != null)
            {
              QLog.w(this.jdField_a_of_type_JavaLangString, 1, "相机已经打开，运行时异常 " + paramMessage.what);
              if ((paramMessage.obj instanceof anwe))
              {
                ((anwe)paramMessage.obj).b(paramMessage.arg1);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] OPEN_CAMERA " + paramMessage.arg1);
                }
                anwj.a(this.jdField_a_of_type_Anwj, Camera.open(paramMessage.arg1));
                if (anwj.a(this.jdField_a_of_type_Anwj) != null)
                {
                  anwj.a(this.jdField_a_of_type_Anwj, true);
                  if (anwj.a(this.jdField_a_of_type_Anwj) == null)
                  {
                    anwj.a(this.jdField_a_of_type_Anwj, anwj.a(this.jdField_a_of_type_Anwj).getParameters());
                    if (QLog.isColorLevel()) {
                      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] OPEN_CAMERA, parameter = " + anwj.a(this.jdField_a_of_type_Anwj));
                    }
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] OPEN_CAMERA, open result mCamera = " + anwj.a(this.jdField_a_of_type_Anwj));
                  }
                }
                else
                {
                  if (paramMessage.obj == null) {
                    continue;
                  }
                  ((anwe)paramMessage.obj).b(paramMessage.arg1);
                  continue;
                }
                continue;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] RELEASE");
                }
                if (anwj.a(this.jdField_a_of_type_Anwj) != null) {
                  anwj.a(this.jdField_a_of_type_Anwj).release();
                }
                anwj.a(this.jdField_a_of_type_Anwj, null);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] RECONNECT");
                }
                anwj.a(this.jdField_a_of_type_Anwj, null);
                try
                {
                  if (anwj.a(this.jdField_a_of_type_Anwj) == null) {
                    continue;
                  }
                  anwj.a(this.jdField_a_of_type_Anwj).reconnect();
                  return;
                }
                catch (IOException localIOException1)
                {
                  anwj.a(this.jdField_a_of_type_Anwj, localIOException1);
                  return;
                }
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] UNLOCK");
                }
                if (anwj.a(this.jdField_a_of_type_Anwj) == null) {
                  continue;
                }
                anwj.a(this.jdField_a_of_type_Anwj).unlock();
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] LOCK");
                }
                if (anwj.a(this.jdField_a_of_type_Anwj) == null) {
                  continue;
                }
                anwj.a(this.jdField_a_of_type_Anwj).lock();
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
                  if (anwj.a(this.jdField_a_of_type_Anwj) == null) {
                    continue;
                  }
                  anwj.a(this.jdField_a_of_type_Anwj).setPreviewDisplay((SurfaceHolder)paramMessage.obj);
                  return;
                }
                catch (IOException localIOException2)
                {
                  throw new RuntimeException(localIOException2);
                }
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] START_PREVIEW_ASYNC");
                }
                if (anwj.a(this.jdField_a_of_type_Anwj) == null) {
                  continue;
                }
                anwj.a(this.jdField_a_of_type_Anwj).startPreview();
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] STOP_PREVIEW");
                }
                try
                {
                  if (anwj.a(this.jdField_a_of_type_Anwj) == null) {
                    continue;
                  }
                  anwj.a(this.jdField_a_of_type_Anwj).stopPreview();
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
                if (anwj.a(this.jdField_a_of_type_Anwj) == null) {
                  continue;
                }
                anwj.a(this.jdField_a_of_type_Anwj).setOneShotPreviewCallback((Camera.PreviewCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_PREVIEW_CALLBACK, obj = " + paramMessage.obj);
                }
                if (anwj.a(this.jdField_a_of_type_Anwj) == null) {
                  continue;
                }
                anwj.a(this.jdField_a_of_type_Anwj).setPreviewCallback((Camera.PreviewCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_PREVIEW_CALLBACK_WITH_BUFFER, obj = " + paramMessage.obj);
                }
                if (anwj.a(this.jdField_a_of_type_Anwj) == null) {
                  continue;
                }
                anwj.a(this.jdField_a_of_type_Anwj).setPreviewCallbackWithBuffer((Camera.PreviewCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] ADD_CALLBACK_BUFFER");
                }
                if (anwj.a(this.jdField_a_of_type_Anwj) == null) {
                  continue;
                }
                anwj.a(this.jdField_a_of_type_Anwj).addCallbackBuffer((byte[])paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] AUTO_FOCUS");
                }
                if (anwj.a(this.jdField_a_of_type_Anwj) == null) {
                  continue;
                }
                anwj.a(this.jdField_a_of_type_Anwj).autoFocus((Camera.AutoFocusCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] CANCEL_AUTO_FOCUS");
                }
                if (anwj.a(this.jdField_a_of_type_Anwj) == null) {
                  continue;
                }
                anwj.a(this.jdField_a_of_type_Anwj).cancelAutoFocus();
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_AUTO_FOCUS_MOVE_CALLBACK");
                }
                if (anwj.a(this.jdField_a_of_type_Anwj) == null) {
                  continue;
                }
                a(anwj.a(this.jdField_a_of_type_Anwj), paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_DISPLAY_ORIENTATION");
                }
                if (anwj.a(this.jdField_a_of_type_Anwj) == null) {
                  continue;
                }
                anwj.a(this.jdField_a_of_type_Anwj).setDisplayOrientation(paramMessage.arg1);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_ZOOM_CHANGE_LISTENER");
                }
                if (anwj.a(this.jdField_a_of_type_Anwj) == null) {
                  continue;
                }
                anwj.a(this.jdField_a_of_type_Anwj).setZoomChangeListener((Camera.OnZoomChangeListener)paramMessage.obj);
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
                if (anwj.a(this.jdField_a_of_type_Anwj) == null) {
                  continue;
                }
                anwj.a(this.jdField_a_of_type_Anwj).setErrorCallback((Camera.ErrorCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_PARAMETERS");
                }
                if (anwj.a(this.jdField_a_of_type_Anwj) == null) {
                  continue;
                }
                anwj.a(this.jdField_a_of_type_Anwj, true);
                anwj.a(this.jdField_a_of_type_Anwj).unflatten((String)paramMessage.obj);
                anwj.a(this.jdField_a_of_type_Anwj).setParameters(anwj.a(this.jdField_a_of_type_Anwj));
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] GET_PARAMETERS");
                }
                if ((anwj.a(this.jdField_a_of_type_Anwj) == null) || (!anwj.a(this.jdField_a_of_type_Anwj))) {
                  continue;
                }
                anwj.b(this.jdField_a_of_type_Anwj, anwj.a(this.jdField_a_of_type_Anwj).getParameters());
                anwj.a(this.jdField_a_of_type_Anwj, false);
                return;
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] ENABLE_SHUTTER_SOUND");
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] REFRESH_PARAMETERS");
                }
                anwj.a(this.jdField_a_of_type_Anwj, true);
                return;
              }
            }
          }
          catch (Exception localException2)
          {
            QLog.e(this.jdField_a_of_type_JavaLangString, 2, "Fail to release the camera.");
            continue;
            if (!(paramMessage.obj instanceof anwk)) {
              continue;
            }
            ((anwk)paramMessage.obj).onAutoFocus(false, anwj.a(this.jdField_a_of_type_Anwj));
            return;
          }
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "相机参数设置错误, 请尝试重启机器 " + paramMessage.what);
          throw localException1;
        }
        if (anwj.a(this.jdField_a_of_type_Anwj) == null) {
          if (paramMessage.what == 1)
          {
            QLog.e(this.jdField_a_of_type_JavaLangString, 1, "mCamera == null Since Camera is disabled");
            if ((paramMessage.obj != null) && ((paramMessage.obj instanceof anwe))) {
              ((anwe)paramMessage.obj).a(paramMessage.arg1);
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
 * Qualified Name:     anwm
 * JD-Core Version:    0.7.0.1
 */