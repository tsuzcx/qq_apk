import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.listentogether.lyrics.FloatIconLayout;
import com.tencent.qphone.base.util.QLog;

public class awgt
  implements DownloadParams.DecodeHandler
{
  public awgt(FloatIconLayout paramFloatIconLayout) {}
  
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("FloatBaseLayout.Icon", 4, "ROUND_FACE_DECODER");
    }
    if (paramBitmap == null) {
      return null;
    }
    return bheg.a(paramBitmap, this.a.d / 2, this.a.d / 2, this.a.d / 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awgt
 * JD-Core Version:    0.7.0.1
 */