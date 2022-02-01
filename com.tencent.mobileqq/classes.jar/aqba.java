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

public class aqba
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
      aqax.a(this.jdField_a_of_type_Aqax).setPreviewTexture((SurfaceTexture)paramObject);
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
        if ((paramMessage.what != 2) && (aqax.a(this.jdField_a_of_type_Aqax) != null))
        {
          QLog.e(this.jdField_a_of_type_JavaLangString, 1, "mCamera != null, but RuntimeException");
          try
          {
            aqax.a(this.jdField_a_of_type_Aqax).release();
            aqax.a(this.jdField_a_of_type_Aqax, null);
            if (paramMessage.obj != null)
            {
              QLog.w(this.jdField_a_of_type_JavaLangString, 1, "相机已经打开，运行时异常 " + paramMessage.what);
              if ((paramMessage.obj instanceof aqas))
              {
                ((aqas)paramMessage.obj).b(paramMessage.arg1);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] OPEN_CAMERA " + paramMessage.arg1);
                }
                aqax.a(this.jdField_a_of_type_Aqax, Camera.open(paramMessage.arg1));
                if (aqax.a(this.jdField_a_of_type_Aqax) != null)
                {
                  aqax.a(this.jdField_a_of_type_Aqax, true);
                  if (aqax.a(this.jdField_a_of_type_Aqax) == null)
                  {
                    aqax.a(this.jdField_a_of_type_Aqax, aqax.a(this.jdField_a_of_type_Aqax).getParameters());
                    if (QLog.isColorLevel()) {
                      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] OPEN_CAMERA, parameter = " + aqax.a(this.jdField_a_of_type_Aqax));
                    }
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] OPEN_CAMERA, open result mCamera = " + aqax.a(this.jdField_a_of_type_Aqax));
                  }
                }
                else
                {
                  if (paramMessage.obj == null) {
                    continue;
                  }
                  ((aqas)paramMessage.obj).b(paramMessage.arg1);
                  continue;
                }
                continue;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] RELEASE");
                }
                if (aqax.a(this.jdField_a_of_type_Aqax) != null) {
                  aqax.a(this.jdField_a_of_type_Aqax).release();
                }
                aqax.a(this.jdField_a_of_type_Aqax, null);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] RECONNECT");
                }
                aqax.a(this.jdField_a_of_type_Aqax, null);
                try
                {
                  if (aqax.a(this.jdField_a_of_type_Aqax) == null) {
                    continue;
                  }
                  aqax.a(this.jdField_a_of_type_Aqax).reconnect();
                  return;
                }
                catch (IOException localIOException1)
                {
                  aqax.a(this.jdField_a_of_type_Aqax, localIOException1);
                  return;
                }
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] UNLOCK");
                }
                if (aqax.a(this.jdField_a_of_type_Aqax) == null) {
                  continue;
                }
                aqax.a(this.jdField_a_of_type_Aqax).unlock();
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] LOCK");
                }
                if (aqax.a(this.jdField_a_of_type_Aqax) == null) {
                  continue;
                }
                aqax.a(this.jdField_a_of_type_Aqax).lock();
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
                  if (aqax.a(this.jdField_a_of_type_Aqax) == null) {
                    continue;
                  }
                  aqax.a(this.jdField_a_of_type_Aqax).setPreviewDisplay((SurfaceHolder)paramMessage.obj);
                  return;
                }
                catch (IOException localIOException2)
                {
                  throw new RuntimeException(localIOException2);
                }
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] START_PREVIEW_ASYNC");
                }
                if (aqax.a(this.jdField_a_of_type_Aqax) == null) {
                  continue;
                }
                aqax.a(this.jdField_a_of_type_Aqax).startPreview();
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] STOP_PREVIEW");
                }
                try
                {
                  if (aqax.a(this.jdField_a_of_type_Aqax) == null) {
                    continue;
                  }
                  aqax.a(this.jdField_a_of_type_Aqax).stopPreview();
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
                if (aqax.a(this.jdField_a_of_type_Aqax) == null) {
                  continue;
                }
                aqax.a(this.jdField_a_of_type_Aqax).setOneShotPreviewCallback((Camera.PreviewCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_PREVIEW_CALLBACK, obj = " + paramMessage.obj);
                }
                if (aqax.a(this.jdField_a_of_type_Aqax) == null) {
                  continue;
                }
                aqax.a(this.jdField_a_of_type_Aqax).setPreviewCallback((Camera.PreviewCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_PREVIEW_CALLBACK_WITH_BUFFER, obj = " + paramMessage.obj);
                }
                if (aqax.a(this.jdField_a_of_type_Aqax) == null) {
                  continue;
                }
                aqax.a(this.jdField_a_of_type_Aqax).setPreviewCallbackWithBuffer((Camera.PreviewCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] ADD_CALLBACK_BUFFER");
                }
                if (aqax.a(this.jdField_a_of_type_Aqax) == null) {
                  continue;
                }
                aqax.a(this.jdField_a_of_type_Aqax).addCallbackBuffer((byte[])paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] AUTO_FOCUS");
                }
                if (aqax.a(this.jdField_a_of_type_Aqax) == null) {
                  continue;
                }
                aqax.a(this.jdField_a_of_type_Aqax).autoFocus((Camera.AutoFocusCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] CANCEL_AUTO_FOCUS");
                }
                if (aqax.a(this.jdField_a_of_type_Aqax) == null) {
                  continue;
                }
                aqax.a(this.jdField_a_of_type_Aqax).cancelAutoFocus();
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_AUTO_FOCUS_MOVE_CALLBACK");
                }
                if (aqax.a(this.jdField_a_of_type_Aqax) == null) {
                  continue;
                }
                a(aqax.a(this.jdField_a_of_type_Aqax), paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_DISPLAY_ORIENTATION");
                }
                if (aqax.a(this.jdField_a_of_type_Aqax) == null) {
                  continue;
                }
                aqax.a(this.jdField_a_of_type_Aqax).setDisplayOrientation(paramMessage.arg1);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_ZOOM_CHANGE_LISTENER");
                }
                if (aqax.a(this.jdField_a_of_type_Aqax) == null) {
                  continue;
                }
                aqax.a(this.jdField_a_of_type_Aqax).setZoomChangeListener((Camera.OnZoomChangeListener)paramMessage.obj);
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
                if (aqax.a(this.jdField_a_of_type_Aqax) == null) {
                  continue;
                }
                aqax.a(this.jdField_a_of_type_Aqax).setErrorCallback((Camera.ErrorCallback)paramMessage.obj);
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] SET_PARAMETERS");
                }
                if (aqax.a(this.jdField_a_of_type_Aqax) == null) {
                  continue;
                }
                aqax.a(this.jdField_a_of_type_Aqax, true);
                aqax.a(this.jdField_a_of_type_Aqax).unflatten((String)paramMessage.obj);
                aqax.a(this.jdField_a_of_type_Aqax).setParameters(aqax.a(this.jdField_a_of_type_Aqax));
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] GET_PARAMETERS");
                }
                if ((aqax.a(this.jdField_a_of_type_Aqax) == null) || (!aqax.a(this.jdField_a_of_type_Aqax))) {
                  continue;
                }
                aqax.b(this.jdField_a_of_type_Aqax, aqax.a(this.jdField_a_of_type_Aqax).getParameters());
                aqax.a(this.jdField_a_of_type_Aqax, false);
                return;
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] ENABLE_SHUTTER_SOUND");
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[handleMessage] REFRESH_PARAMETERS");
                }
                aqax.a(this.jdField_a_of_type_Aqax, true);
                return;
              }
            }
          }
          catch (Exception localException2)
          {
            QLog.e(this.jdField_a_of_type_JavaLangString, 2, "Fail to release the camera.");
            continue;
            if (!(paramMessage.obj instanceof aqay)) {
              continue;
            }
            ((aqay)paramMessage.obj).onAutoFocus(false, aqax.a(this.jdField_a_of_type_Aqax));
            return;
          }
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "相机参数设置错误, 请尝试重启机器 " + paramMessage.what);
          throw localException1;
        }
        if (aqax.a(this.jdField_a_of_type_Aqax) == null) {
          if (paramMessage.what == 1)
          {
            QLog.e(this.jdField_a_of_type_JavaLangString, 1, "mCamera == null Since Camera is disabled");
            if ((paramMessage.obj != null) && ((paramMessage.obj instanceof aqas))) {
              ((aqas)paramMessage.obj).a(paramMessage.arg1);
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
 * Qualified Name:     aqba
 * JD-Core Version:    0.7.0.1
 */