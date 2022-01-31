import android.graphics.Bitmap;
import com.tencent.gdtad.util.GdtSmartBlur;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;

final class bcvb
  implements DownloadParams.DecodeHandler
{
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    paramDownloadParams = paramDownloadParams.tag;
    if ((GdtSmartBlur.a().a) && ((paramDownloadParams instanceof int[])) && (((int[])paramDownloadParams).length == 1))
    {
      int i = ((int[])(int[])paramDownloadParams)[0];
      GdtSmartBlur.a().a(paramBitmap, i);
    }
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcvb
 * JD-Core Version:    0.7.0.1
 */