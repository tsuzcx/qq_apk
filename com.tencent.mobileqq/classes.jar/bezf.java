import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;

class bezf
{
  private final Drawable a;
  private final Drawable b;
  
  bezf(Context paramContext)
  {
    paramContext = paramContext.getResources();
    int i = 2130837549;
    if (bibv.a()) {
      i = 2130837548;
    }
    this.a = paramContext.getDrawable(i);
    this.b = paramContext.getDrawable(2130837553);
  }
  
  private Drawable a(Drawable paramDrawable)
  {
    return new LayerDrawable(new Drawable[] { paramDrawable, this.b });
  }
  
  private Drawable b(Drawable paramDrawable)
  {
    paramDrawable = paramDrawable.getConstantState().newDrawable().mutate();
    paramDrawable.setColorFilter(2147483647, PorterDuff.Mode.MULTIPLY);
    return paramDrawable;
  }
  
  Drawable a(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    paramDrawable = new LayerDrawable(new Drawable[] { this.a, paramDrawable });
    paramDrawable.setLayerInset(1, paramInt1, paramInt2, paramInt1, paramInt2);
    return paramDrawable;
  }
  
  StateListDrawable a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842919 }, paramDrawable2);
    localStateListDrawable.addState(new int[0], paramDrawable1);
    return localStateListDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bezf
 * JD-Core Version:    0.7.0.1
 */