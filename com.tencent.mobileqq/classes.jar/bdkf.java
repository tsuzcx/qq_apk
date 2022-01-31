import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.BaseApplication;

public class bdkf
{
  private static double a;
  public static float a;
  public static int a;
  private static float jdField_b_of_type_Float;
  private static int jdField_b_of_type_Int = -1;
  private static float jdField_c_of_type_Float;
  private static int jdField_c_of_type_Int = -1;
  private static float jdField_d_of_type_Float;
  private static int jdField_d_of_type_Int = -1;
  private static int e;
  
  static
  {
    DisplayMetrics localDisplayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
    jdField_a_of_type_Float = localDisplayMetrics.density;
    jdField_a_of_type_Int = localDisplayMetrics.densityDpi;
    jdField_c_of_type_Float = -1.0F;
    jdField_d_of_type_Float = -1.0F;
  }
  
  public static double a()
  {
    if (jdField_a_of_type_Double <= 0.0D)
    {
      DisplayMetrics localDisplayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
      double d1 = Math.pow(localDisplayMetrics.widthPixels, 2.0D);
      jdField_a_of_type_Double = Math.sqrt(Math.pow(localDisplayMetrics.heightPixels, 2.0D) + d1) / c();
    }
    return jdField_a_of_type_Double;
  }
  
  public static float a()
  {
    if (jdField_c_of_type_Float < 0.0F) {
      jdField_c_of_type_Float = BaseApplication.getContext().getResources().getDisplayMetrics().density;
    }
    return jdField_c_of_type_Float;
  }
  
  public static float a(float paramFloat)
  {
    if (jdField_b_of_type_Float == 0.0F) {
      jdField_b_of_type_Float = jdField_a_of_type_Int;
    }
    return jdField_b_of_type_Float * paramFloat / 160.0F;
  }
  
  public static int a()
  {
    if (jdField_c_of_type_Int < 0) {
      if (BaseApplication.getContext().getResources().getConfiguration().orientation != 2) {
        break label41;
      }
    }
    label41:
    for (jdField_c_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;; jdField_c_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels) {
      return jdField_c_of_type_Int;
    }
  }
  
  public static int a(float paramFloat)
  {
    return (int)(jdField_a_of_type_Float * paramFloat + 0.5F);
  }
  
  public static int a(Context paramContext)
  {
    int i = 0;
    paramContext = paramContext.getResources();
    int j = paramContext.getIdentifier("status_bar_height", "dimen", "android");
    if (j > 0) {
      i = paramContext.getDimensionPixelSize(j);
    }
    return i;
  }
  
  public static void a()
  {
    jdField_c_of_type_Int = -1;
    jdField_d_of_type_Int = -1;
  }
  
  @TargetApi(11)
  public static void a(View paramView, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      paramView.setAlpha(paramFloat);
    }
    while (paramView.getBackground() == null) {
      return;
    }
    paramView.getBackground().setAlpha((int)(255.0F * paramFloat));
  }
  
  @TargetApi(11)
  public static void a(View paramView, int paramInt)
  {
    if (paramView.getBackground() != null) {
      paramView.getBackground().setAlpha(paramInt);
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        a(paramView.getChildAt(i), paramInt);
        i += 1;
      }
    }
  }
  
  @TargetApi(16)
  public static void a(View paramView, Drawable paramDrawable)
  {
    if (paramView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT < 16)
    {
      paramView.setBackgroundDrawable(paramDrawable);
      return;
    }
    paramView.setBackground(paramDrawable);
  }
  
  public static void a(View paramView1, View paramView2, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length < 2)) {}
    label156:
    for (;;)
    {
      return;
      int i = 0;
      int j = 0;
      int k;
      int m;
      if (paramView1.getParent() != null)
      {
        j = paramView1.getLeft() + j;
        k = paramView1.getTop() + i;
        if (paramView1.getParent() == paramView2)
        {
          paramArrayOfInt[0] = j;
          paramArrayOfInt[1] = k;
          i = k;
          m = j;
          if (paramArrayOfInt.length >= 4)
          {
            paramArrayOfInt[2] = paramView1.getMeasuredWidth();
            paramArrayOfInt[3] = paramView1.getMeasuredHeight();
            m = j;
            i = k;
          }
        }
      }
      for (;;)
      {
        for (;;)
        {
          if (paramView2 != null) {
            break label156;
          }
          paramArrayOfInt[0] = m;
          paramArrayOfInt[1] = i;
          return;
          try
          {
            paramView1 = (View)paramView1.getParent();
            if (paramArrayOfInt.length >= 4)
            {
              paramArrayOfInt[2] = paramView1.getMeasuredWidth();
              paramArrayOfInt[3] = paramView1.getMeasuredHeight();
            }
            i = k;
          }
          catch (ClassCastException paramView1)
          {
            i = k;
            m = j;
          }
        }
        continue;
        m = j;
      }
    }
  }
  
  public static boolean a(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      paramView.setVisibility(paramInt);
      return true;
    }
    return false;
  }
  
  public static boolean a(View paramView1, View paramView2)
  {
    if (paramView1 == paramView2) {
      return true;
    }
    if ((paramView2 instanceof ViewGroup))
    {
      int j = ((ViewGroup)paramView2).getChildCount();
      int i = 0;
      while (i < j)
      {
        if (a(paramView1, ((ViewGroup)paramView2).getChildAt(i))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static float b()
  {
    if (jdField_d_of_type_Float < 0.0F) {
      jdField_d_of_type_Float = BaseApplication.getContext().getResources().getDisplayMetrics().scaledDensity;
    }
    return jdField_d_of_type_Float;
  }
  
  public static int b()
  {
    if (jdField_d_of_type_Int < 0) {
      if (BaseApplication.getContext().getResources().getConfiguration().orientation != 2) {
        break label41;
      }
    }
    label41:
    for (jdField_d_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;; jdField_d_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels) {
      return jdField_d_of_type_Int;
    }
  }
  
  public static int b(float paramFloat)
  {
    return Math.round(a() * paramFloat);
  }
  
  @TargetApi(11)
  public static void b(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return;
    }
    paramView.setScaleX(paramFloat);
  }
  
  public static void b(View paramView, int paramInt)
  {
    if ((paramView != null) && (paramView.getVisibility() != paramInt)) {
      paramView.setVisibility(paramInt);
    }
  }
  
  public static float c()
  {
    if (jdField_b_of_type_Int < 0) {
      jdField_b_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
    }
    return jdField_b_of_type_Int;
  }
  
  public static int c()
  {
    if (e <= 0) {
      e = (int)(BaseApplication.getContext().getResources().getDisplayMetrics().xdpi / 2.54D);
    }
    return e;
  }
  
  public static int c(float paramFloat)
  {
    return Math.round(paramFloat / a());
  }
  
  @TargetApi(11)
  public static void c(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return;
    }
    paramView.setScaleY(paramFloat);
  }
  
  public static int d(float paramFloat)
  {
    return (int)(BaseApplication.getContext().getResources().getDisplayMetrics().scaledDensity * paramFloat + 0.5F);
  }
  
  @TargetApi(11)
  public static void d(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return;
    }
    paramView.setPivotX(paramFloat);
  }
  
  public static int e(float paramFloat)
  {
    return (int)(paramFloat / BaseApplication.getContext().getResources().getDisplayMetrics().scaledDensity + 0.5F);
  }
  
  @TargetApi(11)
  public static void e(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return;
    }
    paramView.setPivotY(paramFloat);
  }
  
  @TargetApi(11)
  public static void f(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return;
    }
    paramView.setTranslationX(paramFloat);
  }
  
  @TargetApi(11)
  public static void g(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return;
    }
    paramView.setTranslationY(paramFloat);
  }
  
  @TargetApi(11)
  public static void h(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return;
    }
    paramView.setRotation(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdkf
 * JD-Core Version:    0.7.0.1
 */