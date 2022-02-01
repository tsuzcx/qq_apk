import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import java.util.ArrayList;
import java.util.Iterator;

public class aztf
{
  public float a;
  public Drawable a;
  public Transformation a;
  public ArrayList<Animation> a;
  public float b = 1.0F;
  public int f;
  public int g;
  public int h;
  public int i;
  public int j = 255;
  
  public aztf()
  {
    this.jdField_a_of_type_AndroidViewAnimationTransformation = new Transformation();
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramInt3;
    this.i = paramInt4;
  }
  
  public void a(Animation paramAnimation)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramAnimation);
    paramAnimation.start();
  }
  
  public boolean a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Animation localAnimation = (Animation)localIterator.next();
      if ((bool) || (localAnimation.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.jdField_a_of_type_AndroidViewAnimationTransformation))) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    return bool;
  }
  
  public boolean a(Canvas paramCanvas)
  {
    if ((this.j != 0) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      paramCanvas.save();
      paramCanvas.translate(this.f, this.g);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(this.j);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.h, this.i);
      paramCanvas.scale(this.jdField_a_of_type_Float, this.b, this.h / 2, this.i / 2);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      paramCanvas.restore();
    }
    paramCanvas = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    boolean bool = false;
    if (paramCanvas.hasNext())
    {
      Animation localAnimation = (Animation)paramCanvas.next();
      if ((bool) || (localAnimation.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.jdField_a_of_type_AndroidViewAnimationTransformation))) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    return bool;
  }
  
  public void c(Canvas paramCanvas)
  {
    if ((this.j != 0) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      paramCanvas.save();
      paramCanvas.translate(this.f, this.g);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(this.j);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.h, this.i);
      paramCanvas.scale(this.jdField_a_of_type_Float, this.b, this.h / 2, this.i / 2);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      paramCanvas.restore();
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aztf
 * JD-Core Version:    0.7.0.1
 */