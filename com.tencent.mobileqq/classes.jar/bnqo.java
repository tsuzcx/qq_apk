import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;

public class bnqo
{
  public static final String a = bigv.a("QzonePet");
  
  public static Bitmap a(Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt1, int paramInt2, int paramInt3)
  {
    Bitmap localBitmap;
    if (paramBitmap1 == null) {
      localBitmap = null;
    }
    do
    {
      return localBitmap;
      localBitmap = paramBitmap1;
    } while (paramBitmap2 == null);
    int i;
    if (paramInt3 == 0) {
      i = paramBitmap1.getWidth();
    }
    for (paramInt3 = paramBitmap1.getHeight() + paramBitmap2.getHeight();; paramInt3 = Math.max(paramBitmap1.getHeight(), paramBitmap2.getHeight()))
    {
      localBitmap = Bitmap.createBitmap(i, paramInt3, paramBitmap1.getConfig());
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawBitmap(paramBitmap1, new Matrix(), null);
      localCanvas.drawBitmap(paramBitmap2, paramInt1, paramInt2, null);
      return localBitmap;
      i = Math.max(paramBitmap1.getWidth(), paramBitmap2.getWidth());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnqo
 * JD-Core Version:    0.7.0.1
 */