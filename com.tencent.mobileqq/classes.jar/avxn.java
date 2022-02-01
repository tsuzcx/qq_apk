import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.tencent.theme.SkinnableBitmapDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"MAX_SHOWN_AVATAR_COUNT", "", "TAG", "", "getHalfAlphaDrawableList", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "d", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class avxn
{
  @NotNull
  public static final Drawable a(@NotNull Context paramContext, @NotNull Drawable paramDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramDrawable, "d");
    Drawable localDrawable;
    Object localObject;
    Bitmap localBitmap;
    Resources localResources;
    if (!(paramDrawable instanceof SkinnableBitmapDrawable))
    {
      localDrawable = paramDrawable;
      if (!(paramDrawable instanceof BitmapDrawable)) {}
    }
    else
    {
      localObject = (Bitmap)null;
      if (!(paramDrawable instanceof SkinnableBitmapDrawable)) {
        break label175;
      }
      localObject = ((SkinnableBitmapDrawable)paramDrawable).getBitmap();
      localBitmap = Bitmap.createBitmap((Bitmap)localObject);
      localResources = paramContext.getResources();
      localDrawable = paramDrawable;
      if (localResources != null) {
        if ((localObject == null) || (localBitmap != null)) {
          break label193;
        }
      }
    }
    label175:
    label193:
    label204:
    for (paramContext = (Context)localObject;; paramContext = localBitmap)
    {
      paramDrawable = new BitmapDrawable(localResources, (Bitmap)localObject);
      localObject = new BitmapDrawable(localResources, paramContext);
      ((BitmapDrawable)localObject).setAlpha(127);
      paramContext = new StateListDrawable();
      localObject = (Drawable)localObject;
      paramContext.addState(new int[] { 16842919, 16842910 }, (Drawable)localObject);
      localObject = (Drawable)paramDrawable;
      paramContext.addState(new int[] { 16842908 }, (Drawable)localObject);
      paramDrawable = (Drawable)paramDrawable;
      paramContext.addState(new int[0], paramDrawable);
      localDrawable = (Drawable)paramContext;
      do
      {
        return localDrawable;
        if (!(paramDrawable instanceof BitmapDrawable)) {
          break;
        }
        localObject = ((BitmapDrawable)paramDrawable).getBitmap();
        break;
        if (localObject != null) {
          break label204;
        }
        localDrawable = paramDrawable;
      } while (localBitmap == null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avxn
 * JD-Core Version:    0.7.0.1
 */