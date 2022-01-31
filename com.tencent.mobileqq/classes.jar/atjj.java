import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.listentogether.lyrics.FloatIconLayout;
import com.tencent.qphone.base.util.QLog;

public class atjj
  implements DownloadParams.DecodeHandler
{
  public atjj(FloatIconLayout paramFloatIconLayout) {}
  
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("FloatBaseLayout.Icon", 4, "ROUND_FACE_DECODER");
    }
    if (paramBitmap == null) {
      return null;
    }
    return bdda.a(paramBitmap, this.a.d / 2, this.a.d / 2, this.a.d / 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atjj
 * JD-Core Version:    0.7.0.1
 */