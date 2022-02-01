import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/gldrawable/AbsBaseDrawable;", "Landroid/graphics/drawable/Drawable;", "()V", "clipArea", "Landroid/graphics/RectF;", "drawRect", "Landroid/graphics/Rect;", "forceLockWH", "", "viewRect", "calculateClipArea", "dstBounds", "calculateLockWH", "width", "", "height", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getResID", "", "isRecyclyed", "onDraw", "left", "top", "right", "bottom", "onTouch", "x", "", "y", "recycle", "setDrawArea", "x0", "y0", "x1", "y1", "setLockWH", "b", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract class bhqr
  extends Drawable
{
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private boolean jdField_a_of_type_Boolean;
  private final Rect b = new Rect();
  
  private final Rect a(int paramInt1, int paramInt2, Rect paramRect)
  {
    this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, paramInt1, paramInt2);
    float f1 = paramRect.width() / this.jdField_a_of_type_AndroidGraphicsRect.width();
    float f2 = paramRect.height() / this.jdField_a_of_type_AndroidGraphicsRect.height();
    if (f1 > f2)
    {
      this.jdField_a_of_type_AndroidGraphicsRect.right = paramRect.width();
      this.jdField_a_of_type_AndroidGraphicsRect.bottom = ((int)(f1 * this.jdField_a_of_type_AndroidGraphicsRect.bottom));
    }
    for (;;)
    {
      Gravity.apply(17, this.jdField_a_of_type_AndroidGraphicsRect.width(), this.jdField_a_of_type_AndroidGraphicsRect.height(), paramRect, this.jdField_a_of_type_AndroidGraphicsRect);
      return this.jdField_a_of_type_AndroidGraphicsRect;
      this.jdField_a_of_type_AndroidGraphicsRect.bottom = paramRect.height();
      this.jdField_a_of_type_AndroidGraphicsRect.right = ((int)(f2 * this.jdField_a_of_type_AndroidGraphicsRect.right));
    }
  }
  
  private final Rect a(Rect paramRect)
  {
    RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    if (localRectF != null)
    {
      float f1 = localRectF.width();
      float f2 = localRectF.height();
      f1 = paramRect.width() / f1;
      f2 = paramRect.height() / f2;
      this.jdField_a_of_type_AndroidGraphicsRect.left = ((int)(paramRect.left - localRectF.left * f1));
      Rect localRect = this.jdField_a_of_type_AndroidGraphicsRect;
      float f3 = paramRect.right;
      localRect.right = ((int)(f1 * (1.0F - localRectF.right) + f3));
      this.jdField_a_of_type_AndroidGraphicsRect.top = ((int)(paramRect.top - localRectF.top * f2));
      localRect = this.jdField_a_of_type_AndroidGraphicsRect;
      f1 = paramRect.bottom;
      localRect.bottom = ((int)((1.0F - localRectF.bottom) * f2 + f1));
    }
    return this.jdField_a_of_type_AndroidGraphicsRect;
  }
  
  public final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((paramFloat1 < 0.0F) || (paramFloat2 < 0.0F) || (paramFloat3 < 0.0F) || (paramFloat4 < 0.0F) || (paramFloat1 > 1.0F) || (paramFloat2 > 1.0F) || (paramFloat3 > 1.0F) || (paramFloat4 > 1.0F)) {
      this.jdField_a_of_type_AndroidGraphicsRectF = ((RectF)null);
    }
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public abstract void a(@NotNull Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public final void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final void draw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    Rect localRect = getBounds();
    Intrinsics.checkExpressionValueIsNotNull(localRect, "bounds");
    if (localRect.isEmpty()) {
      this.b.set(0, 0, paramCanvas.getWidth(), paramCanvas.getHeight());
    }
    while (this.b.isEmpty())
    {
      return;
      this.b.set(localRect);
    }
    if ((getIntrinsicHeight() > 0) && (getIntrinsicWidth() > 0))
    {
      if (this.jdField_a_of_type_Boolean)
      {
        localRect = a(getIntrinsicWidth(), getIntrinsicHeight(), this.b);
        a(paramCanvas, localRect.left, localRect.top, localRect.right, localRect.bottom);
        return;
      }
      if (this.jdField_a_of_type_AndroidGraphicsRectF != null)
      {
        localRect = a(this.b);
        a(paramCanvas, localRect.left, localRect.top, localRect.right, localRect.bottom);
        return;
      }
      a(paramCanvas, this.b.left, this.b.top, this.b.right, this.b.bottom);
      return;
    }
    a(paramCanvas, this.b.left, this.b.top, this.b.right, this.b.bottom);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhqr
 * JD-Core Version:    0.7.0.1
 */