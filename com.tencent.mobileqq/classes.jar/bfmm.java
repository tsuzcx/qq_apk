import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.ViewGroup;

public class bfmm
{
  public static Bitmap a(Bitmap paramBitmap)
  {
    Paint localPaint = new Paint();
    localPaint.setMaskFilter(new BlurMaskFilter(1.0F, BlurMaskFilter.Blur.NORMAL));
    int[] arrayOfInt = new int[2];
    Bitmap localBitmap1 = paramBitmap.extractAlpha(localPaint, arrayOfInt);
    Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1.getWidth(), localBitmap1.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas();
    localCanvas.setBitmap(localBitmap2);
    localCanvas.drawBitmap(localBitmap1, 0.0F, 0.0F, localPaint);
    localCanvas.drawBitmap(paramBitmap, -arrayOfInt[0], -arrayOfInt[1], null);
    localBitmap1.recycle();
    return localBitmap2;
  }
  
  public static Bitmap a(View paramView)
  {
    a(paramView);
    for (;;)
    {
      try
      {
        int i = paramView.getWidth();
        int j = paramView.getHeight();
        if ((i != 0) && (j != 0))
        {
          Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
          paramView.draw(new Canvas(localBitmap));
          paramView = localBitmap;
          return paramView;
        }
      }
      catch (OutOfMemoryError paramView)
      {
        return null;
      }
      catch (Exception paramView)
      {
        return null;
      }
      paramView = null;
    }
  }
  
  public static StateListDrawable a(Resources paramResources, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    Object localObject = null;
    StateListDrawable localStateListDrawable = new StateListDrawable();
    if (paramBitmap1 != null)
    {
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(paramResources, paramBitmap1);
      paramBitmap1 = localObject;
      if (paramBitmap2 != null) {
        paramBitmap1 = new BitmapDrawable(paramResources, paramBitmap2);
      }
      if (paramBitmap1 != null) {
        localStateListDrawable.addState(new int[] { 16842919, 16842910 }, paramBitmap1);
      }
      localStateListDrawable.addState(new int[] { 16842908 }, localBitmapDrawable);
      localStateListDrawable.addState(new int[0], localBitmapDrawable);
      return localStateListDrawable;
    }
    return null;
  }
  
  private static void a(View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      if (!(paramView instanceof ViewGroup)) {
        break;
      }
      paramView.destroyDrawingCache();
      paramView.invalidate();
      int i = 0;
      while (i < ((ViewGroup)paramView).getChildCount())
      {
        a(((ViewGroup)paramView).getChildAt(i));
        i += 1;
      }
    }
    paramView.destroyDrawingCache();
    paramView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bfmm
 * JD-Core Version:    0.7.0.1
 */