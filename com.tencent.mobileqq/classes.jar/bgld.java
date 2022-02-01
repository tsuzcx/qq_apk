import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;

public abstract class bgld
  implements bgky
{
  protected Rect a;
  protected SurfaceHolder a;
  private boolean a;
  
  public bgld(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewSurfaceHolder = paramSurfaceHolder;
  }
  
  private void b(Drawable paramDrawable)
  {
    if (bgio.a(paramDrawable))
    {
      bgio.a().a(paramDrawable, true);
      paramDrawable.setBounds(this.jdField_a_of_type_AndroidGraphicsRect);
      return;
    }
    Rect localRect = new Rect();
    Object localObject;
    float f2;
    if ((paramDrawable instanceof BitmapDrawable))
    {
      localObject = (BitmapDrawable)paramDrawable;
      localRect.set(0, 0, ((BitmapDrawable)localObject).getBitmap().getWidth(), ((BitmapDrawable)localObject).getBitmap().getHeight());
      float f1 = this.jdField_a_of_type_AndroidGraphicsRect.width() / localRect.width();
      f2 = this.jdField_a_of_type_AndroidGraphicsRect.height() / localRect.height();
      if (f1 <= f2) {
        break label200;
      }
      localRect.right = this.jdField_a_of_type_AndroidGraphicsRect.right;
      localRect.bottom = ((int)(f1 * localRect.bottom));
    }
    for (;;)
    {
      Gravity.apply(17, localRect.width(), localRect.height(), this.jdField_a_of_type_AndroidGraphicsRect, localRect);
      paramDrawable.setBounds(localRect);
      return;
      if (!(paramDrawable instanceof ApngDrawable)) {
        break;
      }
      localObject = (ApngDrawable)paramDrawable;
      localRect.set(0, 0, ((ApngDrawable)localObject).getImage().getWidth(), ((ApngDrawable)localObject).getImage().getHeight());
      break;
      label200:
      localRect.bottom = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
      localRect.right = ((int)(localRect.right * f2));
    }
  }
  
  abstract Canvas a(SurfaceHolder paramSurfaceHolder);
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public final void a(Rect paramRect)
  {
    this.jdField_a_of_type_AndroidGraphicsRect.set(paramRect);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public final void a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    Canvas localCanvas;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_AndroidViewSurfaceHolder == null) || (this.jdField_a_of_type_AndroidViewSurfaceHolder.getSurface() == null) || (!this.jdField_a_of_type_AndroidViewSurfaceHolder.getSurface().isValid()));
      localCanvas = a(this.jdField_a_of_type_AndroidViewSurfaceHolder);
    } while (localCanvas == null);
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidGraphicsRect.width() == 0) {
        this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      }
      this.jdField_a_of_type_Boolean = false;
      b(paramDrawable);
    }
    paramDrawable.draw(localCanvas);
    this.jdField_a_of_type_AndroidViewSurfaceHolder.unlockCanvasAndPost(localCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgld
 * JD-Core Version:    0.7.0.1
 */