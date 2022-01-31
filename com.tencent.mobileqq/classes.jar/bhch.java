import android.graphics.Bitmap;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;

public class bhch
{
  public static Bitmap a(Bitmap paramBitmap, String paramString)
  {
    if (!BitmapUtils.isLegal(paramBitmap)) {}
    int i;
    do
    {
      return paramBitmap;
      i = BitmapUtils.getDegreeByExif(paramString) % 360;
    } while (i == 0);
    return BitmapUtils.rotateBitmap(paramBitmap, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhch
 * JD-Core Version:    0.7.0.1
 */