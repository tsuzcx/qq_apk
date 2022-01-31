import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class amet
  extends Animation
{
  static final WeakHashMap<View, amet> jdField_a_of_type_JavaUtilWeakHashMap;
  public static final boolean a;
  float jdField_a_of_type_Float = 1.0F;
  final Camera jdField_a_of_type_AndroidGraphicsCamera = new Camera();
  final Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  final WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  float jdField_b_of_type_Float;
  final RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  boolean jdField_b_of_type_Boolean;
  float c;
  float d;
  float e;
  float f;
  float g = 1.0F;
  float h = 1.0F;
  float i;
  float j;
  
  static
  {
    if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 11) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      jdField_a_of_type_JavaUtilWeakHashMap = new WeakHashMap();
      return;
    }
  }
  
  private amet(View paramView)
  {
    setDuration(0L);
    setFillAfter(true);
    paramView.setAnimation(this);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
  }
  
  public static amet a(View paramView)
  {
    amet localamet2 = (amet)jdField_a_of_type_JavaUtilWeakHashMap.get(paramView);
    amet localamet1;
    if (localamet2 != null)
    {
      localamet1 = localamet2;
      if (localamet2 == paramView.getAnimation()) {}
    }
    else
    {
      localamet1 = new amet(paramView);
      jdField_a_of_type_JavaUtilWeakHashMap.put(paramView, localamet1);
    }
    return localamet1;
  }
  
  private void a()
  {
    View localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localView != null) {
      a(this.jdField_a_of_type_AndroidGraphicsRectF, localView);
    }
  }
  
  private void a(Matrix paramMatrix, View paramView)
  {
    float f3 = paramView.getWidth();
    float f4 = paramView.getHeight();
    boolean bool = this.jdField_b_of_type_Boolean;
    float f1;
    if (bool)
    {
      f1 = this.jdField_b_of_type_Float;
      if (!bool) {
        break label226;
      }
    }
    label226:
    for (float f2 = this.c;; f2 = f4 / 2.0F)
    {
      float f5 = this.d;
      float f6 = this.e;
      float f7 = this.f;
      if ((f5 != 0.0F) || (f6 != 0.0F) || (f7 != 0.0F))
      {
        paramView = this.jdField_a_of_type_AndroidGraphicsCamera;
        paramView.save();
        paramView.rotateX(f5);
        paramView.rotateY(f6);
        paramView.rotateZ(-f7);
        paramView.getMatrix(paramMatrix);
        paramView.restore();
        paramMatrix.preTranslate(-f1, -f2);
        paramMatrix.postTranslate(f1, f2);
      }
      f5 = this.g;
      f6 = this.h;
      if ((f5 != 1.0F) || (f6 != 1.0F))
      {
        paramMatrix.postScale(f5, f6);
        paramMatrix.postTranslate(-(f1 / f3) * (f5 * f3 - f3), -(f2 / f4) * (f6 * f4 - f4));
      }
      paramMatrix.postTranslate(this.i, this.j);
      return;
      f1 = f3 / 2.0F;
      break;
    }
  }
  
  private void b()
  {
    View localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localView == null) || (localView.getParent() == null)) {
      return;
    }
    RectF localRectF = this.jdField_b_of_type_AndroidGraphicsRectF;
    a(localRectF, localView);
    localRectF.union(this.jdField_a_of_type_AndroidGraphicsRectF);
    ((View)localView.getParent()).invalidate((int)Math.floor(localRectF.left), (int)Math.floor(localRectF.top), (int)Math.ceil(localRectF.right), (int)Math.ceil(localRectF.bottom));
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_Float != paramFloat)
    {
      this.jdField_a_of_type_Float = paramFloat;
      View localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localView != null) {
        localView.invalidate();
      }
    }
  }
  
  public void a(RectF paramRectF, View paramView)
  {
    paramRectF.set(0.0F, 0.0F, paramView.getWidth(), paramView.getHeight());
    Matrix localMatrix = this.jdField_a_of_type_AndroidGraphicsMatrix;
    localMatrix.reset();
    a(localMatrix, paramView);
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(paramRectF);
    paramRectF.offset(paramView.getLeft(), paramView.getTop());
    float f1;
    if (paramRectF.right < paramRectF.left)
    {
      f1 = paramRectF.right;
      paramRectF.right = paramRectF.left;
      paramRectF.left = f1;
    }
    if (paramRectF.bottom < paramRectF.top)
    {
      f1 = paramRectF.top;
      paramRectF.top = paramRectF.bottom;
      paramRectF.bottom = f1;
    }
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    View localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localView != null)
    {
      paramTransformation.setAlpha(this.jdField_a_of_type_Float);
      a(paramTransformation.getMatrix(), localView);
    }
  }
  
  public void b(float paramFloat)
  {
    if ((!this.jdField_b_of_type_Boolean) || (this.jdField_b_of_type_Float != paramFloat))
    {
      a();
      this.jdField_b_of_type_Boolean = true;
      this.jdField_b_of_type_Float = paramFloat;
      b();
    }
  }
  
  public void c(float paramFloat)
  {
    if ((!this.jdField_b_of_type_Boolean) || (this.c != paramFloat))
    {
      a();
      this.jdField_b_of_type_Boolean = true;
      this.c = paramFloat;
      b();
    }
  }
  
  public void d(float paramFloat)
  {
    if (this.g != paramFloat)
    {
      a();
      this.g = paramFloat;
      b();
    }
  }
  
  public void e(float paramFloat)
  {
    if (this.h != paramFloat)
    {
      a();
      this.h = paramFloat;
      b();
    }
  }
  
  public void f(float paramFloat)
  {
    if (this.i != paramFloat)
    {
      a();
      this.i = paramFloat;
      b();
    }
  }
  
  public void g(float paramFloat)
  {
    if (this.j != paramFloat)
    {
      a();
      this.j = paramFloat;
      b();
    }
  }
  
  public void h(float paramFloat)
  {
    View localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localView != null) {
      f(paramFloat - localView.getLeft());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     amet
 * JD-Core Version:    0.7.0.1
 */