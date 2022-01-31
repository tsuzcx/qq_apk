import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.theme.SkinnableNinePatchDrawable;

public class bbay
{
  public static int a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    do
    {
      return -1;
      if ((paramDrawable instanceof BitmapDrawable)) {
        return bbbr.a(((BitmapDrawable)paramDrawable).getBitmap());
      }
      if ((paramDrawable instanceof SkinnableBitmapDrawable)) {
        return bbbr.a(((SkinnableBitmapDrawable)paramDrawable).getBitmap());
      }
    } while (!(paramDrawable instanceof SkinnableNinePatchDrawable));
    return bbbr.a(((SkinnableNinePatchDrawable)paramDrawable).getBitmap());
  }
  
  public static final Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    do
    {
      return null;
      if ((paramDrawable instanceof BitmapDrawable)) {
        return ((BitmapDrawable)paramDrawable).getBitmap();
      }
    } while (!(paramDrawable instanceof SkinnableBitmapDrawable));
    return ((SkinnableBitmapDrawable)paramDrawable).getBitmap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbay
 * JD-Core Version:    0.7.0.1
 */