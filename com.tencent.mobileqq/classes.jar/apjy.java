import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;

public class apjy
{
  public static int a(int paramInt, double paramDouble)
  {
    float f = 1.0F;
    if (paramInt > 150) {
      f = paramInt / 100;
    }
    if (paramDouble <= 1.5D) {
      return (int)(f * 9.0F);
    }
    if (paramDouble <= 2.0D) {
      return (int)(f * 9.0F);
    }
    return (int)(f * 4.0F);
  }
  
  public static Drawable a(Bitmap paramBitmap)
  {
    Object localObject = null;
    Bitmap localBitmap = bacm.a(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
    paramBitmap = localObject;
    if (localBitmap != null) {
      paramBitmap = new BitmapDrawable(BaseApplicationImpl.getApplication().getResources(), localBitmap);
    }
    return paramBitmap;
  }
  
  public static Drawable a(Bitmap paramBitmap, double paramDouble)
  {
    Object localObject = null;
    Bitmap localBitmap = bacm.a(paramBitmap, a(0, paramDouble));
    paramBitmap = localObject;
    if (localBitmap != null) {
      paramBitmap = new BitmapDrawable(BaseApplicationImpl.getApplication().getResources(), localBitmap);
    }
    return paramBitmap;
  }
  
  public static Drawable a(Drawable paramDrawable, double paramDouble)
  {
    return a(azzg.a(paramDrawable), paramDouble);
  }
  
  public static final boolean a(Intent paramIntent)
  {
    return (paramIntent != null) && (paramIntent.hasExtra("report")) && ("Music_gene_aio".equals(paramIntent.getStringExtra("report")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apjy
 * JD-Core Version:    0.7.0.1
 */