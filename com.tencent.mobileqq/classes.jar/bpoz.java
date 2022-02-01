import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.animation.DecelerateInterpolator;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;

public abstract class bpoz
  extends Drawable
{
  public static final int g = a(1.0F, BaseApplicationImpl.getContext().getResources());
  protected ValueAnimator a;
  protected Context a;
  protected bpon a;
  private bppc a;
  protected String a;
  protected ArrayList<Integer> a;
  protected Bitmap b;
  protected int f;
  
  public bpoz(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_Bpon = new bpon();
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static final int a(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public int a()
  {
    return this.f;
  }
  
  protected int a(ArrayList<Integer> paramArrayList, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramArrayList != null)
    {
      i = paramInt2;
      if (paramArrayList.size() > paramInt1)
      {
        paramArrayList = (Integer)paramArrayList.get(paramInt1);
        i = paramInt2;
        if (paramArrayList != null) {
          i = paramArrayList.intValue();
        }
      }
    }
    return i;
  }
  
  public Bitmap a()
  {
    return a(this.jdField_a_of_type_Bpon.a());
  }
  
  public Bitmap a(long paramLong)
  {
    Bitmap localBitmap = b();
    Canvas localCanvas = new Canvas(localBitmap);
    ArrayList localArrayList = this.jdField_a_of_type_Bpon.a(paramLong);
    if (localArrayList != null) {
      a(localCanvas, localArrayList);
    }
    return localBitmap;
  }
  
  protected abstract void a(Canvas paramCanvas, ArrayList<Integer> paramArrayList);
  
  public abstract String[] a(String paramString);
  
  protected Bitmap b()
  {
    if (this.b == null) {
      this.b = Bitmap.createBitmap(getIntrinsicWidth(), getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
    }
    for (;;)
    {
      return this.b;
      new Canvas(this.b).drawColor(0, PorterDuff.Mode.CLEAR);
    }
  }
  
  protected abstract void b();
  
  public String c()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected void c()
  {
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofObject(this.jdField_a_of_type_Bpon, new Object[] { this.jdField_a_of_type_Bpon.b(), this.jdField_a_of_type_Bpon.a() });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new DecelerateInterpolator());
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new bppa(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new bppb(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(this.jdField_a_of_type_Bpon.a());
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      a(paramCanvas, this.jdField_a_of_type_JavaUtilArrayList);
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpoz
 * JD-Core Version:    0.7.0.1
 */