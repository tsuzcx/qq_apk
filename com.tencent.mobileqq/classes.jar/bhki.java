import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;
import android.util.Log;
import com.tencent.qqmini.sdk.runtime.widget.camera.MiniAppCamera;

public class bhki
  implements MediaRecorder.OnErrorListener
{
  public bhki(MiniAppCamera paramMiniAppCamera, bgok parambgok) {}
  
  public void onError(MediaRecorder paramMediaRecorder, int paramInt1, int paramInt2)
  {
    Log.i("MiniAppCamera", "onError: " + paramInt1);
    this.jdField_a_of_type_Bgok.b();
    MiniAppCamera.a(this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCameraMiniAppCamera);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhki
 * JD-Core Version:    0.7.0.1
 */