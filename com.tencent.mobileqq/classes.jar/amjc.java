import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.util.AnimateUtils;
import com.tencent.widget.Gallery;
import com.tencent.widget.Gallery.OnScollListener;
import com.tencent.widget.OverScroller;

public class amjc
  implements Runnable
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private OverScroller jdField_a_of_type_ComTencentWidgetOverScroller;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private float c;
  private float d;
  private float e;
  
  public amjc(Gallery paramGallery)
  {
    this.jdField_a_of_type_ComTencentWidgetOverScroller = new OverScroller(paramGallery.getContext());
    this.jdField_a_of_type_ComTencentWidgetOverScroller.a(0.04F);
  }
  
  private float a(float paramFloat)
  {
    return AnimateUtils.a(paramFloat);
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentWidgetGallery.removeCallbacks(this);
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetOverScroller.a(true);
    this.jdField_a_of_type_Long = -1L;
    if (this.jdField_a_of_type_ComTencentWidgetGallery.jdField_a_of_type_ComTencentWidgetGallery$OnScollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetGallery.jdField_a_of_type_ComTencentWidgetGallery$OnScollListener.b(this.jdField_a_of_type_ComTencentWidgetGallery.mSelectedPosition);
    }
    if (Gallery.c(this.jdField_a_of_type_ComTencentWidgetGallery) == 2)
    {
      this.jdField_a_of_type_ComTencentWidgetGallery.b(this.jdField_a_of_type_ComTencentWidgetGallery.mSelectedPosition, this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(0), this.jdField_a_of_type_ComTencentWidgetGallery);
      Gallery.b(this.jdField_a_of_type_ComTencentWidgetGallery);
    }
    Gallery.a(this.jdField_a_of_type_ComTencentWidgetGallery, -1);
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentWidgetOverScroller.a(paramInt1, 0, paramInt2, 0, -2147483648, 2147483647, 0, 0);
    return this.jdField_a_of_type_ComTencentWidgetOverScroller.c();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {}
    do
    {
      return;
      a();
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentWidgetOverScroller.a(0, 0, paramInt1, paramInt2, Gallery.b(this.jdField_a_of_type_ComTencentWidgetGallery));
      this.jdField_a_of_type_ComTencentWidgetGallery.post(this);
    } while (this.jdField_a_of_type_ComTencentWidgetGallery.jdField_a_of_type_ComTencentWidgetGallery$OnScollListener == null);
    this.jdField_a_of_type_ComTencentWidgetGallery.jdField_a_of_type_ComTencentWidgetGallery$OnScollListener.a(this.jdField_a_of_type_ComTencentWidgetGallery.mSelectedPosition);
  }
  
  public void a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramFloat1 == paramFloat2) && (paramFloat3 == paramFloat4)) {
      return;
    }
    a();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentWidgetOverScroller.a(0, 0, paramInt1, paramInt2, Gallery.b(this.jdField_a_of_type_ComTencentWidgetGallery));
    this.jdField_a_of_type_ComTencentWidgetGallery.post(this);
    this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = (paramFloat2 - paramFloat1);
    this.e = (1.0F / Gallery.b(this.jdField_a_of_type_ComTencentWidgetGallery));
    this.c = paramFloat3;
    this.d = (paramFloat4 - paramFloat3);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      return;
    }
    a();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    if (AnimationUtils.currentAnimationTimeMillis() - this.jdField_a_of_type_ComTencentWidgetGallery.jdField_a_of_type_Long > 15L) {
      this.jdField_a_of_type_ComTencentWidgetOverScroller.a(this.jdField_a_of_type_ComTencentWidgetGallery.jdField_a_of_type_Long + 15L, 0, 0, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, Gallery.a(this.jdField_a_of_type_ComTencentWidgetGallery), Gallery.a(this.jdField_a_of_type_ComTencentWidgetGallery));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetGallery.post(this);
      if (this.jdField_a_of_type_ComTencentWidgetGallery.jdField_a_of_type_ComTencentWidgetGallery$OnScollListener == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentWidgetGallery.jdField_a_of_type_ComTencentWidgetGallery$OnScollListener.a(this.jdField_a_of_type_ComTencentWidgetGallery.mSelectedPosition);
      return;
      this.jdField_a_of_type_ComTencentWidgetOverScroller.a(0, 0, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, Gallery.a(this.jdField_a_of_type_ComTencentWidgetGallery), Gallery.a(this.jdField_a_of_type_ComTencentWidgetGallery));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetGallery.removeCallbacks(this);
    b(paramBoolean);
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentWidgetGallery.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetGallery.mItemCount == 0)
    {
      b(true);
      return;
    }
    Gallery.b(this.jdField_a_of_type_ComTencentWidgetGallery, false);
    Object localObject = this.jdField_a_of_type_ComTencentWidgetOverScroller;
    boolean bool = ((OverScroller)localObject).b();
    int i = ((OverScroller)localObject).a();
    int j = ((OverScroller)localObject).b();
    int k = this.jdField_a_of_type_Int;
    int m = this.jdField_b_of_type_Int;
    float f2;
    float f3;
    if (this.jdField_a_of_type_Long >= 0L)
    {
      int n = (int)(AnimationUtils.currentAnimationTimeMillis() - this.jdField_a_of_type_Long);
      if (n >= Gallery.b(this.jdField_a_of_type_ComTencentWidgetGallery)) {
        break label273;
      }
      f1 = a(n * this.e);
      f2 = this.jdField_a_of_type_Float + this.jdField_b_of_type_Float * f1;
      f3 = this.c;
    }
    for (float f1 = f1 * this.d + f3;; f1 = this.c + this.d)
    {
      Gallery.a(this.jdField_a_of_type_ComTencentWidgetGallery, this.jdField_a_of_type_ComTencentWidgetGallery.jdField_a_of_type_AndroidViewView, f2);
      Gallery.b(this.jdField_a_of_type_ComTencentWidgetGallery, this.jdField_a_of_type_ComTencentWidgetGallery.jdField_a_of_type_AndroidViewView, f1);
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_ComTencentWidgetGallery.a(i - k, j - m, false);
      if ((!bool) || (Gallery.a(this.jdField_a_of_type_ComTencentWidgetGallery))) {
        break label298;
      }
      this.jdField_a_of_type_Int = i;
      this.jdField_b_of_type_Int = j;
      this.jdField_a_of_type_ComTencentWidgetGallery.post(this);
      if ((Gallery.c(this.jdField_a_of_type_ComTencentWidgetGallery) != 1) || (!Gallery.b(this.jdField_a_of_type_ComTencentWidgetGallery))) {
        break;
      }
      Gallery.a(this.jdField_a_of_type_ComTencentWidgetGallery, true, 1);
      return;
      label273:
      f1 = this.jdField_a_of_type_Float;
      f2 = this.jdField_b_of_type_Float + f1;
    }
    label298:
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      if (Gallery.b(this.jdField_a_of_type_ComTencentWidgetGallery))
      {
        f1 = 1.0F;
        if (this.jdField_a_of_type_ComTencentWidgetGallery.jdField_a_of_type_AndroidViewView.getTag(2131296385) != null) {
          f1 = ((Float)this.jdField_a_of_type_ComTencentWidgetGallery.jdField_a_of_type_AndroidViewView.getTag(2131296385)).floatValue();
        }
        f2 = this.jdField_a_of_type_ComTencentWidgetGallery.a(this.jdField_a_of_type_ComTencentWidgetGallery.jdField_a_of_type_AndroidViewView);
        localObject = this.jdField_a_of_type_ComTencentWidgetGallery;
        if (f2 - f1 <= 1.E-005D) {
          break label404;
        }
        bool = true;
        Gallery.a((Gallery)localObject, bool);
      }
    }
    for (;;)
    {
      b(false);
      return;
      label404:
      bool = false;
      break;
      if (Gallery.c(this.jdField_a_of_type_ComTencentWidgetGallery) == 1)
      {
        Gallery.b(this.jdField_a_of_type_ComTencentWidgetGallery, 0);
        if (Gallery.b(this.jdField_a_of_type_ComTencentWidgetGallery)) {
          Gallery.a(this.jdField_a_of_type_ComTencentWidgetGallery, true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amjc
 * JD-Core Version:    0.7.0.1
 */