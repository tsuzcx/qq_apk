import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader.TileMode;
import android.support.annotation.NonNull;
import com.tencent.image.DownloadParams.DecodeHandler;

public final class bban
{
  public static final DownloadParams.DecodeHandler a = new bbao();
  public static final DownloadParams.DecodeHandler b = new bbap(bavi.s, a);
  
  public static Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    try
    {
      paramConfig = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
      return paramConfig;
    }
    catch (Exception paramConfig)
    {
      return null;
    }
    catch (OutOfMemoryError paramConfig) {}
    return null;
  }
  
  public static Bitmap a(@NonNull Bitmap paramBitmap)
  {
    return a(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
  }
  
  public static Bitmap a(@NonNull Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if ((paramBitmap.getWidth() <= 0) || (paramBitmap.getHeight() <= 0) || ((paramInt1 <= 0) && (paramInt2 <= 0))) {}
    Bitmap localBitmap;
    do
    {
      return paramBitmap;
      localBitmap = a(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    } while (localBitmap == null);
    return a(paramBitmap, localBitmap, paramInt1, paramInt2);
  }
  
  public static Bitmap a(@NonNull Bitmap paramBitmap1, @NonNull Bitmap paramBitmap2, int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      return paramBitmap1;
    }
    paramBitmap2.setDensity((int)bbkx.c());
    Canvas localCanvas = new Canvas(paramBitmap2);
    Path localPath = a(paramInt1, paramInt2);
    BitmapShader localBitmapShader = new BitmapShader(paramBitmap1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    localBitmapShader.setLocalMatrix(a(paramBitmap1.getWidth(), paramBitmap1.getHeight(), paramInt1, paramInt2));
    paramBitmap1 = new Paint();
    paramBitmap1.setShader(localBitmapShader);
    paramBitmap1.setAntiAlias(true);
    localCanvas.drawPath(localPath, paramBitmap1);
    return paramBitmap2;
  }
  
  @NonNull
  private static Matrix a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = 0.0F;
    Matrix localMatrix = new Matrix();
    if ((paramInt1 == paramInt3) && (paramInt2 == paramInt4)) {
      return localMatrix;
    }
    float f3;
    float f2;
    if (paramInt1 * paramInt4 > paramInt3 * paramInt2)
    {
      f3 = paramInt4 / paramInt2;
      f2 = (paramInt3 - paramInt1 * f3) * 0.5F;
    }
    for (;;)
    {
      localMatrix.setScale(f3, f3);
      localMatrix.postTranslate(Math.round(f2), Math.round(f1));
      return localMatrix;
      f3 = paramInt3 / paramInt1;
      f1 = paramInt4;
      float f4 = paramInt2;
      f2 = 0.0F;
      f1 = (f1 - f4 * f3) * 0.5F;
    }
  }
  
  @NonNull
  public static Path a(int paramInt1, int paramInt2)
  {
    Path localPath = new Path();
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      return localPath;
    }
    float f1 = Math.min(paramInt1 * 0.0618F, paramInt2 * 0.0618F);
    float f2 = paramInt1 / 2.0F;
    float f3 = paramInt2 / 2.0F;
    localPath.moveTo(0.0F, f3);
    localPath.cubicTo(0.0F, f1, f1, 0.0F, f2, 0.0F);
    localPath.cubicTo(paramInt1 - f1, 0.0F, paramInt1, f1, paramInt1, f3);
    localPath.cubicTo(paramInt1, paramInt2 - f1, paramInt1 - f1, paramInt2, f2, paramInt2);
    localPath.cubicTo(f1, paramInt2, 0.0F, paramInt2 - f1, 0.0F, f3);
    return localPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bban
 * JD-Core Version:    0.7.0.1
 */