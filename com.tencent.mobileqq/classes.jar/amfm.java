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

public class amfm
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
      amfj.a(this.jdField_a_of_type_Amfj).setPreviewTexture((SurfaceTexture)paramObject);
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
        if ((paramMessage.what != 2) && (amfj.a(this.jdField_a_of_type_Amfj) != null))
        {
          QLog.e(this.jdField_a_of_type_JavaLangString, 1, "mCamera != null, but RuntimeException");
          try
          {
            amfj.a(this.jdField_a_of_type_Amfj).release();
            amfj.a(this.jdField_a_of_type_Amfj, null);
            if (paramMessage.obj != null)
            {
              QLog.w(this.jdField_a_of_type_JavaLangString, 1, "相机已经打开，运行时异常 " + paramMessage.what);
              if ((paramMessage.obj instanceof amfe))
              {
                ((amfe)paramMessage.obj).b(paramMessage.arg1);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] OPEN_CAMERA " + paramMessage.arg1);
                }
                amfj.a(this.jdField_a_of_type_Amfj, Camera.open(paramMessage.arg1));
                if (amfj.a(this.jdField_a_of_type_Amfj) != null)
                {
                  amfj.a(this.jdField_a_of_type_Amfj, true);
                  if (amfj.a(this.jdField_a_of_type_Amfj) == null)
                  {
                    amfj.a(this.jdField_a_of_type_Amfj, amfj.a(this.jdField_a_of_type_Amfj).getParameters());
                    if (QLog.isColorLevel()) {
                      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] OPEN_CAMERA, parameter = " + amfj.a(this.jdField_a_of_type_Amfj));
                    }
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] OPEN_CAMERA, open result mCamera = " + amfj.a(this.jdField_a_of_type_Amfj));
                  }
                }
                else
                {
                  if (paramMessage.obj == null) {
                    continue;
                  }
                  ((amfe)paramMessage.obj).b(paramMessage.arg1);
                  continue;
                }
                continue;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] RELEASE");
                }
                if (amfj.a(this.jdField_a_of_type_Amfj) != null) {
                  amfj.a(this.jdField_a_of_type_Amfj).release();
                }
                amfj.a(this.jdField_a_of_type_Amfj, null);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] RECONNECT");
                }
                amfj.a(this.jdField_a_of_type_Amfj, null);
                try
                {
                  if (amfj.a(this.jdField_a_of_type_Amfj) == null) {
                    continue;
                  }
                  amfj.a(this.jdField_a_of_type_Amfj).reconnect();
                  return;
                }
                catch (IOException localIOException1)
                {
                  amfj.a(this.jdField_a_of_type_Amfj, localIOException1);
                  return;
                }
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] UNLOCK");
                }
                if (amfj.a(this.jdField_a_of_type_Amfj) == null) {
                  continue;
                }
                amfj.a(this.jdField_a_of_type_Amfj).unlock();
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] LOCK");
                }
                if (amfj.a(this.jdField_a_of_type_Amfj) == null) {
                  continue;
                }
                amfj.a(this.jdField_a_of_type_Amfj).lock();
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
                  if (amfj.a(this.jdField_a_of_type_Amfj) == null) {
                    continue;
                  }
                  amfj.a(this.jdField_a_of_type_Amfj).setPreviewDisplay((SurfaceHolder)paramMessage.obj);
                  return;
                }
                catch (IOException localIOException2)
                {
                  throw new RuntimeException(localIOException2);
                }
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] START_PREVIEW_ASYNC");
                }
                if (amfj.a(this.jdField_a_of_type_Amfj) == null) {
                  continue;
                }
                amfj.a(this.jdField_a_of_type_Amfj).startPreview();
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] STOP_PREVIEW");
                }
                try
                {
                  if (amfj.a(this.jdField_a_of_type_Amfj) == null) {
                    continue;
                  }
                  amfj.a(this.jdField_a_of_type_Amfj).stopPreview();
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
                if (amfj.a(this.jdField_a_of_type_Amfj) == null) {
                  continue;
                }
                amfj.a(this.jdField_a_of_type_Amfj).setOneShotPreviewCallback((Camera.PreviewCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_PREVIEW_CALLBACK, obj = " + paramMessage.obj);
                }
                if (amfj.a(this.jdField_a_of_type_Amfj) == null) {
                  continue;
                }
                amfj.a(this.jdField_a_of_type_Amfj).setPreviewCallback((Camera.PreviewCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_PREVIEW_CALLBACK_WITH_BUFFER, obj = " + paramMessage.obj);
                }
                if (amfj.a(this.jdField_a_of_type_Amfj) == null) {
                  continue;
                }
                amfj.a(this.jdField_a_of_type_Amfj).setPreviewCallbackWithBuffer((Camera.PreviewCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] ADD_CALLBACK_BUFFER");
                }
                if (amfj.a(this.jdField_a_of_type_Amfj) == null) {
                  continue;
                }
                amfj.a(this.jdField_a_of_type_Amfj).addCallbackBuffer((byte[])paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] AUTO_FOCUS");
                }
                if (amfj.a(this.jdField_a_of_type_Amfj) == null) {
                  continue;
                }
                amfj.a(this.jdField_a_of_type_Amfj).autoFocus((Camera.AutoFocusCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] CANCEL_AUTO_FOCUS");
                }
                if (amfj.a(this.jdField_a_of_type_Amfj) == null) {
                  continue;
                }
                amfj.a(this.jdField_a_of_type_Amfj).cancelAutoFocus();
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_AUTO_FOCUS_MOVE_CALLBACK");
                }
                if (amfj.a(this.jdField_a_of_type_Amfj) == null) {
                  continue;
                }
                a(amfj.a(this.jdField_a_of_type_Amfj), paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_DISPLAY_ORIENTATION");
                }
                if (amfj.a(this.jdField_a_of_type_Amfj) == null) {
                  continue;
                }
                amfj.a(this.jdField_a_of_type_Amfj).setDisplayOrientation(paramMessage.arg1);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_ZOOM_CHANGE_LISTENER");
                }
                if (amfj.a(this.jdField_a_of_type_Amfj) == null) {
                  continue;
                }
                amfj.a(this.jdField_a_of_type_Amfj).setZoomChangeListener((Camera.OnZoomChangeListener)paramMessage.obj);
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
                if (amfj.a(this.jdField_a_of_type_Amfj) == null) {
                  continue;
                }
                amfj.a(this.jdField_a_of_type_Amfj).setErrorCallback((Camera.ErrorCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_PARAMETERS");
                }
                if (amfj.a(this.jdField_a_of_type_Amfj) == null) {
                  continue;
                }
                amfj.a(this.jdField_a_of_type_Amfj, true);
                amfj.a(this.jdField_a_of_type_Amfj).unflatten((String)paramMessage.obj);
                amfj.a(this.jdField_a_of_type_Amfj).setParameters(amfj.a(this.jdField_a_of_type_Amfj));
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] GET_PARAMETERS");
                }
                if ((amfj.a(this.jdField_a_of_type_Amfj) == null) || (!amfj.a(this.jdField_a_of_type_Amfj))) {
                  continue;
                }
                amfj.b(this.jdField_a_of_type_Amfj, amfj.a(this.jdField_a_of_type_Amfj).getParameters());
                amfj.a(this.jdField_a_of_type_Amfj, false);
                return;
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] ENABLE_SHUTTER_SOUND");
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] REFRESH_PARAMETERS");
                }
                amfj.a(this.jdField_a_of_type_Amfj, true);
                return;
              }
            }
          }
          catch (Exception localException2)
          {
            QLog.e(this.jdField_a_of_type_JavaLangString, 2, "Fail to release the camera.");
            continue;
            if (!(paramMessage.obj instanceof amfk)) {
              continue;
            }
            ((amfk)paramMessage.obj).onAutoFocus(false, amfj.a(this.jdField_a_of_type_Amfj));
            return;
          }
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "相机参数设置错误, 请尝试重启机器 " + paramMessage.what);
          throw localException1;
        }
        if (amfj.a(this.jdField_a_of_type_Amfj) == null) {
          if (paramMessage.what == 1)
          {
            QLog.e(this.jdField_a_of_type_JavaLangString, 1, "mCamera == null Since Camera is disabled");
            if ((paramMessage.obj != null) && ((paramMessage.obj instanceof amfe))) {
              ((amfe)paramMessage.obj).a(paramMessage.arg1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amfm
 * JD-Core Version:    0.7.0.1
 */