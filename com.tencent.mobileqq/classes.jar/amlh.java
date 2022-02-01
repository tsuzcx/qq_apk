import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.TMG.sdk.AVContext;
import com.tencent.TMG.sdk.AVVideoCtrl;
import com.tencent.TMG.utils.QLog;

public class amlh
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private SurfaceHolder.Callback jdField_a_of_type_AndroidViewSurfaceHolder$Callback = new amli(this);
  public SurfaceView a;
  
  public amlh(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  AVVideoCtrl a()
  {
    AVContext localAVContext = anie.a(this.jdField_a_of_type_AndroidContentContext).a();
    if (localAVContext != null) {
      return localAVContext.getVideoCtrl();
    }
    return null;
  }
  
  public void a()
  {
    WindowManager localWindowManager = (WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window");
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.width = 1;
    localLayoutParams.height = 1;
    localLayoutParams.flags = 776;
    localLayoutParams.format = -3;
    localLayoutParams.windowAnimations = 0;
    localLayoutParams.gravity = 51;
    try
    {
      if (this.jdField_a_of_type_AndroidViewSurfaceView == null)
      {
        this.jdField_a_of_type_AndroidViewSurfaceView = new SurfaceView(this.jdField_a_of_type_AndroidContentContext);
        SurfaceHolder localSurfaceHolder = this.jdField_a_of_type_AndroidViewSurfaceView.getHolder();
        localSurfaceHolder.addCallback(this.jdField_a_of_type_AndroidViewSurfaceHolder$Callback);
        localSurfaceHolder.setType(3);
        this.jdField_a_of_type_AndroidViewSurfaceView.setZOrderMediaOverlay(true);
        localWindowManager.addView(this.jdField_a_of_type_AndroidViewSurfaceView, localLayoutParams);
      }
      QLog.e("AVCameraCaptureModel", 0, "memoryLeak initCameraPreview");
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        localWindowManager.updateViewLayout(this.jdField_a_of_type_AndroidViewSurfaceView, localLayoutParams);
        if (QLog.isColorLevel()) {
          QLog.d("AVCameraCaptureModel", 0, "add camera surface view fail: IllegalStateException." + localIllegalStateException);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AVCameraCaptureModel", 0, "add camera surface view fail." + localException);
        }
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_AndroidViewSurfaceView == null)) {
      return;
    }
    WindowManager localWindowManager = (WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window");
    try
    {
      localWindowManager.removeView(this.jdField_a_of_type_AndroidViewSurfaceView);
      this.jdField_a_of_type_AndroidViewSurfaceView = null;
      QLog.e("AVCameraCaptureModel", 0, "memoryLeak unInitCameraaPreview");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AVCameraCaptureModel", 0, "remove camera view fail.", localException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amlh
 * JD-Core Version:    0.7.0.1
 */