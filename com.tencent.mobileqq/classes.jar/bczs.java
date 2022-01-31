import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.theme.SkinnableNinePatchDrawable;

public class bczs
{
  public static int a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    do
    {
      return -1;
      if ((paramDrawable instanceof BitmapDrawable)) {
        return bdal.a(((BitmapDrawable)paramDrawable).getBitmap());
      }
      if ((paramDrawable instanceof SkinnableBitmapDrawable)) {
        return bdal.a(((SkinnableBitmapDrawable)paramDrawable).getBitmap());
      }
    } while (!(paramDrawable instanceof SkinnableNinePatchDrawable));
    return bdal.a(((SkinnableNinePatchDrawable)paramDrawable).getBitmap());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bczs
 * JD-Core Version:    0.7.0.1
 */