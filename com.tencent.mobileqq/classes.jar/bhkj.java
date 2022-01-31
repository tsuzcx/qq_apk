import android.media.MediaRecorder;
import android.media.MediaRecorder.OnInfoListener;
import android.util.Log;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.widget.camera.MiniAppCamera;

public class bhkj
  implements MediaRecorder.OnInfoListener
{
  public bhkj(MiniAppCamera paramMiniAppCamera, bgok parambgok) {}
  
  public void onInfo(MediaRecorder paramMediaRecorder, int paramInt1, int paramInt2)
  {
    Log.i("MiniAppCamera", "onInfo: " + paramInt1);
    QMLog.i("MiniAppCamera", "setOnInfoListener|reson: " + paramInt1);
    if (paramInt1 == 800) {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetCameraMiniAppCamera.b(this.jdField_a_of_type_Bgok);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhkj
 * JD-Core Version:    0.7.0.1
 */