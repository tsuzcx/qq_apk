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

public class aqqc
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
      aqpz.a(this.jdField_a_of_type_Aqpz).setPreviewTexture((SurfaceTexture)paramObject);
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
        if ((paramMessage.what != 2) && (aqpz.a(this.jdField_a_of_type_Aqpz) != null))
        {
          QLog.e(this.jdField_a_of_type_JavaLangString, 1, "mCamera != null, but RuntimeException");
          try
          {
            aqpz.a(this.jdField_a_of_type_Aqpz).release();
            aqpz.a(this.jdField_a_of_type_Aqpz, null);
            if (paramMessage.obj != null)
            {
              QLog.w(this.jdField_a_of_type_JavaLangString, 1, "相机已经打开，运行时异常 " + paramMessage.what);
              if ((paramMessage.obj instanceof aqpu))
              {
                ((aqpu)paramMessage.obj).b(paramMessage.arg1);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] OPEN_CAMERA " + paramMessage.arg1);
                }
                aqpz.a(this.jdField_a_of_type_Aqpz, Camera.open(paramMessage.arg1));
                if (aqpz.a(this.jdField_a_of_type_Aqpz) != null)
                {
                  aqpz.a(this.jdField_a_of_type_Aqpz, true);
                  if (aqpz.a(this.jdField_a_of_type_Aqpz) == null)
                  {
                    aqpz.a(this.jdField_a_of_type_Aqpz, aqpz.a(this.jdField_a_of_type_Aqpz).getParameters());
                    if (QLog.isColorLevel()) {
                      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] OPEN_CAMERA, parameter = " + aqpz.a(this.jdField_a_of_type_Aqpz));
                    }
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] OPEN_CAMERA, open result mCamera = " + aqpz.a(this.jdField_a_of_type_Aqpz));
                  }
                }
                else
                {
                  if (paramMessage.obj == null) {
                    continue;
                  }
                  ((aqpu)paramMessage.obj).b(paramMessage.arg1);
                  continue;
                }
                continue;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] RELEASE");
                }
                if (aqpz.a(this.jdField_a_of_type_Aqpz) != null) {
                  aqpz.a(this.jdField_a_of_type_Aqpz).release();
                }
                aqpz.a(this.jdField_a_of_type_Aqpz, null);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] RECONNECT");
                }
                aqpz.a(this.jdField_a_of_type_Aqpz, null);
                try
                {
                  if (aqpz.a(this.jdField_a_of_type_Aqpz) == null) {
                    continue;
                  }
                  aqpz.a(this.jdField_a_of_type_Aqpz).reconnect();
                  return;
                }
                catch (IOException localIOException1)
                {
                  aqpz.a(this.jdField_a_of_type_Aqpz, localIOException1);
                  return;
                }
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] UNLOCK");
                }
                if (aqpz.a(this.jdField_a_of_type_Aqpz) == null) {
                  continue;
                }
                aqpz.a(this.jdField_a_of_type_Aqpz).unlock();
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] LOCK");
                }
                if (aqpz.a(this.jdField_a_of_type_Aqpz) == null) {
                  continue;
                }
                aqpz.a(this.jdField_a_of_type_Aqpz).lock();
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
                  if (aqpz.a(this.jdField_a_of_type_Aqpz) == null) {
                    continue;
                  }
                  aqpz.a(this.jdField_a_of_type_Aqpz).setPreviewDisplay((SurfaceHolder)paramMessage.obj);
                  return;
                }
                catch (IOException localIOException2)
                {
                  throw new RuntimeException(localIOException2);
                }
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] START_PREVIEW_ASYNC");
                }
                if (aqpz.a(this.jdField_a_of_type_Aqpz) == null) {
                  continue;
                }
                aqpz.a(this.jdField_a_of_type_Aqpz).startPreview();
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] STOP_PREVIEW");
                }
                try
                {
                  if (aqpz.a(this.jdField_a_of_type_Aqpz) == null) {
                    continue;
                  }
                  aqpz.a(this.jdField_a_of_type_Aqpz).stopPreview();
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
                if (aqpz.a(this.jdField_a_of_type_Aqpz) == null) {
                  continue;
                }
                aqpz.a(this.jdField_a_of_type_Aqpz).setOneShotPreviewCallback((Camera.PreviewCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_PREVIEW_CALLBACK, obj = " + paramMessage.obj);
                }
                if (aqpz.a(this.jdField_a_of_type_Aqpz) == null) {
                  continue;
                }
                aqpz.a(this.jdField_a_of_type_Aqpz).setPreviewCallback((Camera.PreviewCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_PREVIEW_CALLBACK_WITH_BUFFER, obj = " + paramMessage.obj);
                }
                if (aqpz.a(this.jdField_a_of_type_Aqpz) == null) {
                  continue;
                }
                aqpz.a(this.jdField_a_of_type_Aqpz).setPreviewCallbackWithBuffer((Camera.PreviewCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] ADD_CALLBACK_BUFFER");
                }
                if (aqpz.a(this.jdField_a_of_type_Aqpz) == null) {
                  continue;
                }
                aqpz.a(this.jdField_a_of_type_Aqpz).addCallbackBuffer((byte[])paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] AUTO_FOCUS");
                }
                if (aqpz.a(this.jdField_a_of_type_Aqpz) == null) {
                  continue;
                }
                aqpz.a(this.jdField_a_of_type_Aqpz).autoFocus((Camera.AutoFocusCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] CANCEL_AUTO_FOCUS");
                }
                if (aqpz.a(this.jdField_a_of_type_Aqpz) == null) {
                  continue;
                }
                aqpz.a(this.jdField_a_of_type_Aqpz).cancelAutoFocus();
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_AUTO_FOCUS_MOVE_CALLBACK");
                }
                if (aqpz.a(this.jdField_a_of_type_Aqpz) == null) {
                  continue;
                }
                a(aqpz.a(this.jdField_a_of_type_Aqpz), paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_DISPLAY_ORIENTATION");
                }
                if (aqpz.a(this.jdField_a_of_type_Aqpz) == null) {
                  continue;
                }
                aqpz.a(this.jdField_a_of_type_Aqpz).setDisplayOrientation(paramMessage.arg1);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_ZOOM_CHANGE_LISTENER");
                }
                if (aqpz.a(this.jdField_a_of_type_Aqpz) == null) {
                  continue;
                }
                aqpz.a(this.jdField_a_of_type_Aqpz).setZoomChangeListener((Camera.OnZoomChangeListener)paramMessage.obj);
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
                if (aqpz.a(this.jdField_a_of_type_Aqpz) == null) {
                  continue;
                }
                aqpz.a(this.jdField_a_of_type_Aqpz).setErrorCallback((Camera.ErrorCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_PARAMETERS");
                }
                if (aqpz.a(this.jdField_a_of_type_Aqpz) == null) {
                  continue;
                }
                aqpz.a(this.jdField_a_of_type_Aqpz, true);
                aqpz.a(this.jdField_a_of_type_Aqpz).unflatten((String)paramMessage.obj);
                aqpz.a(this.jdField_a_of_type_Aqpz).setParameters(aqpz.a(this.jdField_a_of_type_Aqpz));
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] GET_PARAMETERS");
                }
                if ((aqpz.a(this.jdField_a_of_type_Aqpz) == null) || (!aqpz.a(this.jdField_a_of_type_Aqpz))) {
                  continue;
                }
                aqpz.b(this.jdField_a_of_type_Aqpz, aqpz.a(this.jdField_a_of_type_Aqpz).getParameters());
                aqpz.a(this.jdField_a_of_type_Aqpz, false);
                return;
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] ENABLE_SHUTTER_SOUND");
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] REFRESH_PARAMETERS");
                }
                aqpz.a(this.jdField_a_of_type_Aqpz, true);
                return;
              }
            }
          }
          catch (Exception localException2)
          {
            QLog.e(this.jdField_a_of_type_JavaLangString, 2, "Fail to release the camera.");
            continue;
            if (!(paramMessage.obj instanceof aqqa)) {
              continue;
            }
            ((aqqa)paramMessage.obj).onAutoFocus(false, aqpz.a(this.jdField_a_of_type_Aqpz));
            return;
          }
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "相机参数设置错误, 请尝试重启机器 " + paramMessage.what);
          throw localException1;
        }
        if (aqpz.a(this.jdField_a_of_type_Aqpz) == null) {
          if (paramMessage.what == 1)
          {
            QLog.e(this.jdField_a_of_type_JavaLangString, 1, "mCamera == null Since Camera is disabled");
            if ((paramMessage.obj != null) && ((paramMessage.obj instanceof aqpu))) {
              ((aqpu)paramMessage.obj).a(paramMessage.arg1);
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
 * Qualified Name:     aqqc
 * JD-Core Version:    0.7.0.1
 */