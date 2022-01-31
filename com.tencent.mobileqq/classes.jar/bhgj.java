import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.widget.ScrollerCompat;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.tencent.qqmini.sdk.runtime.core.page.swipe.ViewDragHelper.2;
import java.util.Arrays;

public class bhgj
{
  private static final Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new bhgk();
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private ScrollerCompat jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View jdField_a_of_type_AndroidViewView;
  private final ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private final bhgl jdField_a_of_type_Bhgl;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new ViewDragHelper.2(this);
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat;
  private int[] jdField_a_of_type_ArrayOfInt;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private float[] jdField_b_of_type_ArrayOfFloat;
  private int[] jdField_b_of_type_ArrayOfInt;
  private int jdField_c_of_type_Int = -1;
  private float[] jdField_c_of_type_ArrayOfFloat;
  private int[] jdField_c_of_type_ArrayOfInt;
  private int jdField_d_of_type_Int;
  private float[] jdField_d_of_type_ArrayOfFloat;
  private int e;
  private int f;
  
  private bhgj(Context paramContext, ViewGroup paramViewGroup, bhgl parambhgl)
  {
    if (paramViewGroup == null) {
      throw new IllegalArgumentException("Parent view may not be null");
    }
    if (parambhgl == null) {
      throw new IllegalArgumentException("Callback may not be null");
    }
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_Bhgl = parambhgl;
    paramViewGroup = ViewConfiguration.get(paramContext);
    this.e = ((int)(paramContext.getResources().getDisplayMetrics().density * 20.0F + 0.5F));
    this.jdField_b_of_type_Int = paramViewGroup.getScaledTouchSlop();
    this.jdField_a_of_type_Float = paramViewGroup.getScaledMaximumFlingVelocity();
    this.jdField_b_of_type_Float = paramViewGroup.getScaledMinimumFlingVelocity();
    this.jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat = ScrollerCompat.create(paramContext, jdField_a_of_type_AndroidViewAnimationInterpolator);
  }
  
  private float a(float paramFloat)
  {
    return (float)Math.sin((float)((paramFloat - 0.5F) * 0.47123891676382D));
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = Math.abs(paramFloat1);
    if (f1 < paramFloat2) {
      paramFloat2 = 0.0F;
    }
    do
    {
      return paramFloat2;
      if (f1 <= paramFloat3) {
        break;
      }
      paramFloat2 = paramFloat3;
    } while (paramFloat1 > 0.0F);
    return -paramFloat3;
    return paramFloat1;
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int j = 0;
    if (paramInt1 < this.jdField_a_of_type_AndroidViewViewGroup.getLeft() + this.e) {
      j = 1;
    }
    int i = j;
    if (paramInt2 < this.jdField_a_of_type_AndroidViewViewGroup.getTop() + this.e) {
      i = j | 0x4;
    }
    j = i;
    if (paramInt1 > this.jdField_a_of_type_AndroidViewViewGroup.getRight() - this.e) {
      j = i | 0x2;
    }
    paramInt1 = j;
    if (paramInt2 > this.jdField_a_of_type_AndroidViewViewGroup.getBottom() - this.e) {
      paramInt1 = j | 0x8;
    }
    return paramInt1;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0) {
      return 0;
    }
    int i = this.jdField_a_of_type_AndroidViewViewGroup.getWidth();
    int j = i / 2;
    float f3 = Math.min(1.0F, Math.abs(paramInt1) / i);
    float f1 = j;
    float f2 = j;
    f3 = a(f3);
    paramInt2 = Math.abs(paramInt2);
    if (paramInt2 > 0) {}
    for (paramInt1 = Math.round(Math.abs((f3 * f2 + f1) / paramInt2) * 1000.0F) * 4;; paramInt1 = (int)((Math.abs(paramInt1) / paramInt3 + 1.0F) * 256.0F)) {
      return Math.min(paramInt1, 600);
    }
  }
  
  private int a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = b(paramInt3, (int)this.jdField_b_of_type_Float, (int)this.jdField_a_of_type_Float);
    paramInt4 = b(paramInt4, (int)this.jdField_b_of_type_Float, (int)this.jdField_a_of_type_Float);
    int i = Math.abs(paramInt1);
    int j = Math.abs(paramInt2);
    int k = Math.abs(paramInt3);
    int m = Math.abs(paramInt4);
    int n = k + m;
    int i1 = i + j;
    float f1;
    if (paramInt3 != 0)
    {
      f1 = k / n;
      if (paramInt4 == 0) {
        break label165;
      }
    }
    label165:
    for (float f2 = m / n;; f2 = j / i1)
    {
      paramInt1 = a(paramInt1, paramInt3, this.jdField_a_of_type_Bhgl.a(paramView));
      paramInt2 = a(paramInt2, paramInt4, this.jdField_a_of_type_Bhgl.b(paramView));
      float f3 = paramInt1;
      return (int)(f2 * paramInt2 + f1 * f3);
      f1 = i / i1;
      break;
    }
  }
  
  public static bhgj a(ViewGroup paramViewGroup, float paramFloat, bhgl parambhgl)
  {
    paramViewGroup = a(paramViewGroup, parambhgl);
    paramViewGroup.jdField_b_of_type_Int = ((int)(paramViewGroup.jdField_b_of_type_Int * (1.0F / paramFloat)));
    return paramViewGroup;
  }
  
  public static bhgj a(ViewGroup paramViewGroup, bhgl parambhgl)
  {
    return new bhgj(paramViewGroup.getContext(), paramViewGroup, parambhgl);
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bhgl.a(this.jdField_a_of_type_AndroidViewView, paramFloat1, paramFloat2);
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Int == 1) {
      b(0);
    }
  }
  
  private void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    d(paramInt);
    float[] arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
    this.jdField_c_of_type_ArrayOfFloat[paramInt] = paramFloat1;
    arrayOfFloat[paramInt] = paramFloat1;
    arrayOfFloat = this.jdField_b_of_type_ArrayOfFloat;
    this.jdField_d_of_type_ArrayOfFloat[paramInt] = paramFloat2;
    arrayOfFloat[paramInt] = paramFloat2;
    this.jdField_a_of_type_ArrayOfInt[paramInt] = a((int)paramFloat1, (int)paramFloat2);
    this.jdField_d_of_type_Int |= 1 << paramInt;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = this.jdField_a_of_type_AndroidViewView.getLeft();
    int j = this.jdField_a_of_type_AndroidViewView.getTop();
    if (paramInt3 != 0)
    {
      paramInt1 = this.jdField_a_of_type_Bhgl.a(this.jdField_a_of_type_AndroidViewView, paramInt1, paramInt3);
      this.jdField_a_of_type_AndroidViewView.offsetLeftAndRight(paramInt1 - i);
    }
    for (;;)
    {
      if (paramInt4 != 0)
      {
        paramInt2 = this.jdField_a_of_type_Bhgl.b(this.jdField_a_of_type_AndroidViewView, paramInt2, paramInt4);
        this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(paramInt2 - j);
      }
      for (;;)
      {
        if ((paramInt3 != 0) || (paramInt4 != 0)) {
          this.jdField_a_of_type_Bhgl.a(this.jdField_a_of_type_AndroidViewView, paramInt1, paramInt2, paramInt1 - i, paramInt2 - j);
        }
        return;
      }
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    if (((this.jdField_a_of_type_ArrayOfInt[paramInt1] & paramInt2) != paramInt2) || ((this.f & paramInt2) == 0) || ((this.jdField_c_of_type_ArrayOfInt[paramInt1] & paramInt2) == paramInt2) || ((this.jdField_b_of_type_ArrayOfInt[paramInt1] & paramInt2) == paramInt2) || ((paramFloat1 <= this.jdField_b_of_type_Int) && (paramFloat2 <= this.jdField_b_of_type_Int))) {}
    do
    {
      return false;
      if ((paramFloat1 < paramFloat2 * 0.5F) && (this.jdField_a_of_type_Bhgl.a(paramInt2)))
      {
        int[] arrayOfInt = this.jdField_c_of_type_ArrayOfInt;
        arrayOfInt[paramInt1] |= paramInt2;
        return false;
      }
    } while (((this.jdField_b_of_type_ArrayOfInt[paramInt1] & paramInt2) != 0) || (paramFloat1 <= this.jdField_b_of_type_Int));
    return true;
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = this.jdField_a_of_type_AndroidViewView.getLeft();
    int j = this.jdField_a_of_type_AndroidViewView.getTop();
    paramInt1 -= i;
    paramInt2 -= j;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat.abortAnimation();
      b(0);
      return false;
    }
    paramInt3 = a(this.jdField_a_of_type_AndroidViewView, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat.startScroll(i, j, paramInt1, paramInt2, paramInt3);
    b(2);
    return true;
  }
  
  private boolean a(View paramView, float paramFloat1, float paramFloat2)
  {
    boolean bool = true;
    if (paramView == null) {
      bool = false;
    }
    label27:
    label80:
    label86:
    do
    {
      int j;
      do
      {
        return bool;
        int i;
        if (this.jdField_a_of_type_Bhgl.a(paramView) > 0)
        {
          i = 1;
          if (this.jdField_a_of_type_Bhgl.b(paramView) <= 0) {
            break label80;
          }
        }
        for (j = 1;; j = 0)
        {
          if ((i == 0) || (j == 0)) {
            break label86;
          }
          if (paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 > this.jdField_b_of_type_Int * this.jdField_b_of_type_Int) {
            break;
          }
          return false;
          i = 0;
          break label27;
        }
        if (i == 0) {
          break;
        }
      } while (Math.abs(paramFloat1) > this.jdField_b_of_type_Int);
      return false;
      if (j == 0) {
        break;
      }
    } while (Math.abs(paramFloat2) > this.jdField_b_of_type_Int);
    return false;
    return false;
  }
  
  private int b(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = Math.abs(paramInt1);
    if (i < paramInt2) {
      paramInt2 = 0;
    }
    do
    {
      return paramInt2;
      if (i <= paramInt3) {
        break;
      }
      paramInt2 = paramInt3;
    } while (paramInt1 > 0);
    return -paramInt3;
    return paramInt1;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ArrayOfFloat == null) {
      return;
    }
    Arrays.fill(this.jdField_a_of_type_ArrayOfFloat, 0.0F);
    Arrays.fill(this.jdField_b_of_type_ArrayOfFloat, 0.0F);
    Arrays.fill(this.jdField_c_of_type_ArrayOfFloat, 0.0F);
    Arrays.fill(this.jdField_d_of_type_ArrayOfFloat, 0.0F);
    Arrays.fill(this.jdField_a_of_type_ArrayOfInt, 0);
    Arrays.fill(this.jdField_b_of_type_ArrayOfInt, 0);
    Arrays.fill(this.jdField_c_of_type_ArrayOfInt, 0);
    this.jdField_d_of_type_Int = 0;
  }
  
  private void b(float paramFloat1, float paramFloat2, int paramInt)
  {
    int j = 1;
    if (a(paramFloat1, paramFloat2, paramInt, 1)) {}
    for (;;)
    {
      int i = j;
      if (a(paramFloat2, paramFloat1, paramInt, 4)) {
        i = j | 0x4;
      }
      j = i;
      if (a(paramFloat1, paramFloat2, paramInt, 2)) {
        j = i | 0x2;
      }
      i = j;
      if (a(paramFloat2, paramFloat1, paramInt, 8)) {
        i = j | 0x8;
      }
      if (i != 0)
      {
        int[] arrayOfInt = this.jdField_b_of_type_ArrayOfInt;
        arrayOfInt[paramInt] |= i;
        this.jdField_a_of_type_Bhgl.b(i, paramInt);
      }
      return;
      j = 0;
    }
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getPointerCount();
    int i = 0;
    if (i < j)
    {
      int k = paramMotionEvent.getPointerId(i);
      if (!b(k)) {}
      for (;;)
      {
        i += 1;
        break;
        float f1 = paramMotionEvent.getX(i);
        float f2 = paramMotionEvent.getY(i);
        this.jdField_c_of_type_ArrayOfFloat[k] = f1;
        this.jdField_d_of_type_ArrayOfFloat[k] = f2;
      }
    }
  }
  
  private boolean b(int paramInt)
  {
    return a(paramInt);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000, this.jdField_a_of_type_Float);
    a(a(VelocityTrackerCompat.getXVelocity(this.jdField_a_of_type_AndroidViewVelocityTracker, this.jdField_c_of_type_Int), this.jdField_b_of_type_Float, this.jdField_a_of_type_Float), a(VelocityTrackerCompat.getYVelocity(this.jdField_a_of_type_AndroidViewVelocityTracker, this.jdField_c_of_type_Int), this.jdField_b_of_type_Float, this.jdField_a_of_type_Float));
  }
  
  private void c(int paramInt)
  {
    if ((this.jdField_a_of_type_ArrayOfFloat == null) || (!a(paramInt))) {
      return;
    }
    this.jdField_a_of_type_ArrayOfFloat[paramInt] = 0.0F;
    this.jdField_b_of_type_ArrayOfFloat[paramInt] = 0.0F;
    this.jdField_c_of_type_ArrayOfFloat[paramInt] = 0.0F;
    this.jdField_d_of_type_ArrayOfFloat[paramInt] = 0.0F;
    this.jdField_a_of_type_ArrayOfInt[paramInt] = 0;
    this.jdField_b_of_type_ArrayOfInt[paramInt] = 0;
    this.jdField_c_of_type_ArrayOfInt[paramInt] = 0;
    this.jdField_d_of_type_Int &= (1 << paramInt ^ 0xFFFFFFFF);
  }
  
  private void d(int paramInt)
  {
    if ((this.jdField_a_of_type_ArrayOfFloat == null) || (this.jdField_a_of_type_ArrayOfFloat.length <= paramInt))
    {
      float[] arrayOfFloat1 = new float[paramInt + 1];
      float[] arrayOfFloat2 = new float[paramInt + 1];
      float[] arrayOfFloat3 = new float[paramInt + 1];
      float[] arrayOfFloat4 = new float[paramInt + 1];
      int[] arrayOfInt1 = new int[paramInt + 1];
      int[] arrayOfInt2 = new int[paramInt + 1];
      int[] arrayOfInt3 = new int[paramInt + 1];
      if (this.jdField_a_of_type_ArrayOfFloat != null)
      {
        System.arraycopy(this.jdField_a_of_type_ArrayOfFloat, 0, arrayOfFloat1, 0, this.jdField_a_of_type_ArrayOfFloat.length);
        System.arraycopy(this.jdField_b_of_type_ArrayOfFloat, 0, arrayOfFloat2, 0, this.jdField_b_of_type_ArrayOfFloat.length);
        System.arraycopy(this.jdField_c_of_type_ArrayOfFloat, 0, arrayOfFloat3, 0, this.jdField_c_of_type_ArrayOfFloat.length);
        System.arraycopy(this.jdField_d_of_type_ArrayOfFloat, 0, arrayOfFloat4, 0, this.jdField_d_of_type_ArrayOfFloat.length);
        System.arraycopy(this.jdField_a_of_type_ArrayOfInt, 0, arrayOfInt1, 0, this.jdField_a_of_type_ArrayOfInt.length);
        System.arraycopy(this.jdField_b_of_type_ArrayOfInt, 0, arrayOfInt2, 0, this.jdField_b_of_type_ArrayOfInt.length);
        System.arraycopy(this.jdField_c_of_type_ArrayOfInt, 0, arrayOfInt3, 0, this.jdField_c_of_type_ArrayOfInt.length);
      }
      this.jdField_a_of_type_ArrayOfFloat = arrayOfFloat1;
      this.jdField_b_of_type_ArrayOfFloat = arrayOfFloat2;
      this.jdField_c_of_type_ArrayOfFloat = arrayOfFloat3;
      this.jdField_d_of_type_ArrayOfFloat = arrayOfFloat4;
      this.jdField_a_of_type_ArrayOfInt = arrayOfInt1;
      this.jdField_b_of_type_ArrayOfInt = arrayOfInt2;
      this.jdField_c_of_type_ArrayOfInt = arrayOfInt3;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View a(int paramInt1, int paramInt2)
  {
    int i = this.jdField_a_of_type_AndroidViewViewGroup.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(this.jdField_a_of_type_Bhgl.a(i));
      if ((paramInt1 >= localView.getLeft()) && (paramInt1 < localView.getRight()) && (paramInt2 >= localView.getTop()) && (paramInt2 < localView.getBottom())) {
        return localView;
      }
      i -= 1;
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_c_of_type_Int = -1;
    b();
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    int i = 0;
    int j = 0;
    int m = MotionEventCompat.getActionMasked(paramMotionEvent);
    int k = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (m == 0) {
      a();
    }
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    float f1;
    float f2;
    switch (m)
    {
    case 4: 
    default: 
    case 0: 
    case 5: 
    case 2: 
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              f1 = paramMotionEvent.getX();
              f2 = paramMotionEvent.getY();
              i = paramMotionEvent.getPointerId(0);
              paramMotionEvent = a((int)f1, (int)f2);
              a(f1, f2, i);
              a(paramMotionEvent, i);
              j = this.jdField_a_of_type_ArrayOfInt[i];
            } while ((this.f & j) == 0);
            this.jdField_a_of_type_Bhgl.a(j & this.f, i);
            return;
            i = paramMotionEvent.getPointerId(k);
            f1 = paramMotionEvent.getX(k);
            f2 = paramMotionEvent.getY(k);
            a(f1, f2, i);
            if (this.jdField_a_of_type_Int != 0) {
              break;
            }
            a(a((int)f1, (int)f2), i);
            j = this.jdField_a_of_type_ArrayOfInt[i];
          } while ((this.f & j) == 0);
          this.jdField_a_of_type_Bhgl.a(j & this.f, i);
          return;
        } while (!b((int)f1, (int)f2));
        a(this.jdField_a_of_type_AndroidViewView, i);
        return;
        if (this.jdField_a_of_type_Int != 1) {
          break;
        }
      } while (!b(this.jdField_c_of_type_Int));
      i = paramMotionEvent.findPointerIndex(this.jdField_c_of_type_Int);
      f1 = paramMotionEvent.getX(i);
      f2 = paramMotionEvent.getY(i);
      i = (int)(f1 - this.jdField_c_of_type_ArrayOfFloat[this.jdField_c_of_type_Int]);
      j = (int)(f2 - this.jdField_d_of_type_ArrayOfFloat[this.jdField_c_of_type_Int]);
      a(this.jdField_a_of_type_AndroidViewView.getLeft() + i, this.jdField_a_of_type_AndroidViewView.getTop() + j, i, j);
      b(paramMotionEvent);
      return;
      k = paramMotionEvent.getPointerCount();
      i = j;
      float f3;
      float f4;
      while (i < k)
      {
        j = paramMotionEvent.getPointerId(i);
        if (!b(j))
        {
          i += 1;
        }
        else
        {
          f1 = paramMotionEvent.getX(i);
          f2 = paramMotionEvent.getY(i);
          f3 = f1 - this.jdField_a_of_type_ArrayOfFloat[j];
          f4 = f2 - this.jdField_b_of_type_ArrayOfFloat[j];
          b(f3, f4, j);
          if (this.jdField_a_of_type_Int != 1) {
            break label490;
          }
        }
      }
      for (;;)
      {
        b(paramMotionEvent);
        return;
        View localView = a((int)f1, (int)f2);
        if ((!a(localView, f3, f4)) || (!a(localView, j))) {
          break;
        }
      }
    case 6: 
      label490:
      j = paramMotionEvent.getPointerId(k);
      if ((this.jdField_a_of_type_Int == 1) && (j == this.jdField_c_of_type_Int))
      {
        k = paramMotionEvent.getPointerCount();
        if (i >= k) {
          break label692;
        }
        m = paramMotionEvent.getPointerId(i);
        if (m == this.jdField_c_of_type_Int) {}
        do
        {
          i += 1;
          break;
          f1 = paramMotionEvent.getX(i);
          f2 = paramMotionEvent.getY(i);
        } while ((a((int)f1, (int)f2) != this.jdField_a_of_type_AndroidViewView) || (!a(this.jdField_a_of_type_AndroidViewView, m)));
      }
      break;
    }
    label692:
    for (i = this.jdField_c_of_type_Int;; i = -1)
    {
      if (i == -1) {
        c();
      }
      c(j);
      return;
      if (this.jdField_a_of_type_Int == 1) {
        c();
      }
      a();
      return;
      if (this.jdField_a_of_type_Int == 1) {
        a(0.0F, 0.0F);
      }
      a();
      return;
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    if (paramView.getParent() != this.jdField_a_of_type_AndroidViewViewGroup) {
      throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.jdField_a_of_type_AndroidViewViewGroup + ")");
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_Bhgl.a(paramView, paramInt);
    b(1);
  }
  
  public boolean a(int paramInt)
  {
    return (this.jdField_d_of_type_Int & 1 << paramInt) != 0;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_Boolean) {
      throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }
    return a(paramInt1, paramInt2, (int)VelocityTrackerCompat.getXVelocity(this.jdField_a_of_type_AndroidViewVelocityTracker, this.jdField_c_of_type_Int), (int)VelocityTrackerCompat.getYVelocity(this.jdField_a_of_type_AndroidViewVelocityTracker, this.jdField_c_of_type_Int));
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int j = MotionEventCompat.getActionMasked(paramMotionEvent);
    int i = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (j == 0) {
      a();
    }
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    switch (j)
    {
    }
    while (this.jdField_a_of_type_Int == 1)
    {
      return true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      i = paramMotionEvent.getPointerId(0);
      a(f1, f2, i);
      paramMotionEvent = a((int)f1, (int)f2);
      if ((paramMotionEvent == this.jdField_a_of_type_AndroidViewView) && (this.jdField_a_of_type_Int == 2)) {
        a(paramMotionEvent, i);
      }
      j = this.jdField_a_of_type_ArrayOfInt[i];
      if ((this.f & j) != 0)
      {
        this.jdField_a_of_type_Bhgl.a(j & this.f, i);
        continue;
        j = paramMotionEvent.getPointerId(i);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        a(f1, f2, j);
        if (this.jdField_a_of_type_Int == 0)
        {
          i = this.jdField_a_of_type_ArrayOfInt[j];
          if ((this.f & i) != 0) {
            this.jdField_a_of_type_Bhgl.a(i & this.f, j);
          }
        }
        else if (this.jdField_a_of_type_Int == 2)
        {
          paramMotionEvent = a((int)f1, (int)f2);
          if (paramMotionEvent == this.jdField_a_of_type_AndroidViewView)
          {
            a(paramMotionEvent, j);
            continue;
            if ((this.jdField_a_of_type_ArrayOfFloat != null) && (this.jdField_b_of_type_ArrayOfFloat != null))
            {
              int k = paramMotionEvent.getPointerCount();
              i = 0;
              int m;
              label352:
              float f3;
              float f4;
              View localView;
              while (i < k)
              {
                m = paramMotionEvent.getPointerId(i);
                if (!b(m))
                {
                  i += 1;
                }
                else
                {
                  f1 = paramMotionEvent.getX(i);
                  f2 = paramMotionEvent.getY(i);
                  f3 = f1 - this.jdField_a_of_type_ArrayOfFloat[m];
                  f4 = f2 - this.jdField_b_of_type_ArrayOfFloat[m];
                  localView = a((int)f1, (int)f2);
                  if ((localView == null) || (!a(localView, f3, f4))) {
                    break label559;
                  }
                  j = 1;
                  label428:
                  if (j == 0) {
                    break label565;
                  }
                  int n = localView.getLeft();
                  int i1 = (int)f3;
                  i1 = this.jdField_a_of_type_Bhgl.a(localView, i1 + n, (int)f3);
                  int i2 = localView.getTop();
                  int i3 = (int)f4;
                  i3 = this.jdField_a_of_type_Bhgl.b(localView, i3 + i2, (int)f4);
                  int i4 = this.jdField_a_of_type_Bhgl.a(localView);
                  int i5 = this.jdField_a_of_type_Bhgl.b(localView);
                  if (((i4 != 0) && ((i4 <= 0) || (i1 != n))) || ((i5 != 0) && ((i5 <= 0) || (i3 != i2)))) {
                    break label565;
                  }
                }
              }
              for (;;)
              {
                b(paramMotionEvent);
                break;
                label559:
                j = 0;
                break label428;
                label565:
                b(f3, f4, m);
                if (this.jdField_a_of_type_Int != 1) {
                  if ((j == 0) || (!a(localView, m))) {
                    break label352;
                  }
                }
              }
              c(paramMotionEvent.getPointerId(i));
              continue;
              a();
            }
          }
        }
      }
    }
    return false;
  }
  
  boolean a(View paramView, int paramInt)
  {
    if ((paramView == this.jdField_a_of_type_AndroidViewView) && (this.jdField_c_of_type_Int == paramInt)) {
      return true;
    }
    if ((paramView != null) && (this.jdField_a_of_type_Bhgl.a(paramView, paramInt)))
    {
      this.jdField_c_of_type_Int = paramInt;
      a(paramView, paramInt);
      return true;
    }
    return false;
  }
  
  public boolean a(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {}
    while ((paramInt1 < paramView.getLeft()) || (paramInt1 >= paramView.getRight()) || (paramInt2 < paramView.getTop()) || (paramInt2 >= paramView.getBottom())) {
      return false;
    }
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    boolean bool;
    if (this.jdField_a_of_type_Int == 2)
    {
      bool = this.jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat.computeScrollOffset();
      int i = this.jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat.getCurrX();
      int j = this.jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat.getCurrY();
      int k = i - this.jdField_a_of_type_AndroidViewView.getLeft();
      int m = j - this.jdField_a_of_type_AndroidViewView.getTop();
      if (k != 0) {
        this.jdField_a_of_type_AndroidViewView.offsetLeftAndRight(k);
      }
      if (m != 0) {
        this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(m);
      }
      if ((k != 0) || (m != 0)) {
        this.jdField_a_of_type_Bhgl.a(this.jdField_a_of_type_AndroidViewView, i, j, k, m);
      }
      if ((!bool) || (i != this.jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat.getFinalX()) || (j != this.jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat.getFinalY())) {
        break label188;
      }
      this.jdField_a_of_type_AndroidSupportV4WidgetScrollerCompat.abortAnimation();
      bool = false;
    }
    label178:
    label188:
    for (;;)
    {
      if (!bool)
      {
        if (!paramBoolean) {
          break label178;
        }
        this.jdField_a_of_type_AndroidViewViewGroup.post(this.jdField_a_of_type_JavaLangRunnable);
      }
      while (this.jdField_a_of_type_Int == 2)
      {
        return true;
        b(0);
      }
      return false;
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewViewGroup.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_Bhgl.a(paramInt);
      if (this.jdField_a_of_type_Int == 0) {
        this.jdField_a_of_type_AndroidViewView = null;
      }
    }
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    return a(this.jdField_a_of_type_AndroidViewView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhgj
 * JD-Core Version:    0.7.0.1
 */