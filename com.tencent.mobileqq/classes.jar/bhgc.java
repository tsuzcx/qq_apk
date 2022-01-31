import android.media.MediaRecorder;
import android.media.MediaRecorder.OnInfoListener;
import android.util.Log;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.widget.camera.MiniAppCamera;

public class bhgc
  implements MediaRecorder.OnInfoListener
{
  public bhgc(MiniAppCamera paramMiniAppCamera, bgkd parambgkd) {}
  
  public void onInfo(MediaRecorder paramMediaRecorder, int paramInt1, int paramInt2)
  {
    Log.i("MiniAppCamera", "onInfo: " + paramInt1);
    QMLog.i("MiniAppCamera", "setOnInfoListener|reson: " + paramInt1);
    if (paramInt1 == 800) {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCameraMiniAppCamera.b(this.jdField_a_of_type_Bgkd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhgc
 * JD-Core Version:    0.7.0.1
 */