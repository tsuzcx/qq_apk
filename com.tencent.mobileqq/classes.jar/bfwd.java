import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.Stack;

public abstract class bfwd
{
  protected String a;
  protected final bfwf[] a;
  protected final Stack<View>[] a;
  protected final int b;
  
  public bfwd(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = bfwd.class.getSimpleName();
    this.b = paramInt1;
    if ((this.b < 0) || ((this.b > 0) && (paramInt2 < 1))) {
      throw new IllegalArgumentException("SwipRightMenuBuilder, menuTypeCount = " + paramInt2);
    }
    this.jdField_a_of_type_ArrayOfJavaUtilStack = new Stack[paramInt2];
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      this.jdField_a_of_type_ArrayOfJavaUtilStack[paramInt1] = new Stack();
      paramInt1 += 1;
    }
    this.jdField_a_of_type_ArrayOfBfwf = new bfwf[this.b];
    paramInt1 = i;
    while (paramInt1 < this.b)
    {
      this.jdField_a_of_type_ArrayOfBfwf[paramInt1] = new bfwf();
      paramInt1 += 1;
    }
  }
  
  public int a(Context paramContext, View paramView, int paramInt, Object paramObject, bfwe parambfwe, View.OnClickListener paramOnClickListener)
  {
    int i = 0;
    if ((!(paramView instanceof LinearLayout)) || (parambfwe == null) || (parambfwe.jdField_a_of_type_ArrayOfBfwf == null) || (parambfwe.jdField_a_of_type_ArrayOfBfwf.length == 0) || (parambfwe.jdField_a_of_type_ArrayOfBfwf.length > this.b)) {
      return 0;
    }
    LinearLayout localLinearLayout = (LinearLayout)paramView;
    a(paramInt, paramObject, this.jdField_a_of_type_ArrayOfBfwf);
    int j = 0;
    int n = 0;
    while (n < this.b)
    {
      if ((this.jdField_a_of_type_ArrayOfJavaUtilStack.length > 1) && (parambfwe.jdField_a_of_type_ArrayOfBfwf[n].jdField_a_of_type_Int != this.jdField_a_of_type_ArrayOfBfwf[n].jdField_a_of_type_Int)) {
        a(parambfwe.jdField_a_of_type_ArrayOfBfwf[n]);
      }
      parambfwe.jdField_a_of_type_ArrayOfBfwf[n].jdField_a_of_type_Int = this.jdField_a_of_type_ArrayOfBfwf[n].jdField_a_of_type_Int;
      parambfwe.jdField_a_of_type_ArrayOfBfwf[n].b = this.jdField_a_of_type_ArrayOfBfwf[n].b;
      parambfwe.jdField_a_of_type_ArrayOfBfwf[n].c = 0;
      parambfwe.jdField_a_of_type_ArrayOfBfwf[n].d = -1;
      int k = parambfwe.jdField_a_of_type_ArrayOfBfwf[n].jdField_a_of_type_Int;
      Object localObject1 = parambfwe.jdField_a_of_type_ArrayOfBfwf[n].jdField_a_of_type_AndroidViewView;
      int m;
      if ((k < 0) || (k >= this.jdField_a_of_type_ArrayOfJavaUtilStack.length))
      {
        m = j;
        k = i;
        if (localObject1 != null)
        {
          ((View)localObject1).setVisibility(8);
          k = j + 1;
          j = i;
          i = k;
          n += 1;
          k = j;
          j = i;
          i = k;
        }
      }
      else
      {
        int i1;
        if (localObject1 == null)
        {
          synchronized (this.jdField_a_of_type_ArrayOfJavaUtilStack)
          {
            if (!this.jdField_a_of_type_ArrayOfJavaUtilStack[k].isEmpty()) {
              localObject1 = (View)this.jdField_a_of_type_ArrayOfJavaUtilStack[k].pop();
            }
            ??? = localObject1;
            if (localObject1 == null) {
              ??? = a(paramContext, k);
            }
            if (??? == null) {
              throw new NullPointerException("updateRightMenuView menuView is null");
            }
          }
          parambfwe.jdField_a_of_type_ArrayOfBfwf[n].jdField_a_of_type_AndroidViewView = ((View)???);
          i1 = 1;
          localObject1 = ???;
        }
        for (;;)
        {
          a(paramInt, paramObject, parambfwe.jdField_a_of_type_ArrayOfBfwf[n], paramOnClickListener);
          if (parambfwe.jdField_a_of_type_ArrayOfBfwf[n].c >= 0) {
            break;
          }
          throw new IllegalArgumentException("updateRightMenuView, menuWidth = " + parambfwe.jdField_a_of_type_ArrayOfBfwf[n].c);
          i1 = 0;
        }
        i += parambfwe.jdField_a_of_type_ArrayOfBfwf[n].c;
        j += 1;
        ((View)localObject1).setVisibility(0);
        m = j;
        k = i;
        if (i1 != 0)
        {
          ??? = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
          if (??? != null) {
            break label594;
          }
          ??? = new LinearLayout.LayoutParams(parambfwe.jdField_a_of_type_ArrayOfBfwf[n].c, parambfwe.jdField_a_of_type_ArrayOfBfwf[n].d);
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)???);
        }
      }
      for (;;)
      {
        ((LinearLayout.LayoutParams)???).gravity = 16;
        localLinearLayout.addView((View)localObject1, j);
        k = i;
        m = j;
        i = m;
        j = k;
        break;
        label594:
        ((LinearLayout.LayoutParams)???).width = parambfwe.jdField_a_of_type_ArrayOfBfwf[n].c;
        ((LinearLayout.LayoutParams)???).height = parambfwe.jdField_a_of_type_ArrayOfBfwf[n].d;
      }
    }
    paramView.setTag(-3, Integer.valueOf(i));
    return i;
  }
  
  public abstract View a(int paramInt, Object paramObject, bfwf parambfwf, View.OnClickListener paramOnClickListener);
  
  public abstract View a(Context paramContext, int paramInt);
  
  public View a(Context paramContext, View paramView, bfwe parambfwe, int paramInt)
  {
    if ((parambfwe == null) || (paramView == null)) {
      throw new NullPointerException("SwipRightMenuBuilder.createView holder is null or leftView is null");
    }
    if (this.b > 0)
    {
      parambfwe.jdField_a_of_type_ArrayOfBfwf = new bfwf[this.b];
      int i = 0;
      while (i < this.b)
      {
        parambfwe.jdField_a_of_type_ArrayOfBfwf[i] = new bfwf();
        parambfwe.jdField_a_of_type_ArrayOfBfwf[i].jdField_a_of_type_Int = -1;
        parambfwe.jdField_a_of_type_ArrayOfBfwf[i].c = 0;
        parambfwe.jdField_a_of_type_ArrayOfBfwf[i].jdField_a_of_type_AndroidViewView = null;
        i += 1;
      }
      paramContext = new LinearLayout(paramContext);
      paramContext.setOrientation(0);
      paramContext.addView(paramView, new LinearLayout.LayoutParams(paramInt, -2));
    }
    for (;;)
    {
      parambfwe.g = paramView;
      return paramContext;
      parambfwe.jdField_a_of_type_ArrayOfBfwf = null;
      paramContext = paramView;
    }
  }
  
  public abstract void a(int paramInt, Object paramObject, bfwf[] paramArrayOfbfwf);
  
  protected void a(bfwf parambfwf)
  {
    if (parambfwf == null) {
      return;
    }
    if (parambfwf.jdField_a_of_type_AndroidViewView != null)
    {
      ??? = parambfwf.jdField_a_of_type_AndroidViewView.getParent();
      if (??? != null) {
        break label74;
      }
    }
    synchronized (this.jdField_a_of_type_ArrayOfJavaUtilStack)
    {
      for (;;)
      {
        if ((parambfwf.jdField_a_of_type_Int >= 0) && (parambfwf.jdField_a_of_type_Int < this.jdField_a_of_type_ArrayOfJavaUtilStack.length)) {
          this.jdField_a_of_type_ArrayOfJavaUtilStack[parambfwf.jdField_a_of_type_Int].push(parambfwf.jdField_a_of_type_AndroidViewView);
        }
        parambfwf.a();
        return;
        label74:
        if (!(??? instanceof ViewGroup)) {
          break;
        }
        ((ViewGroup)???).removeView(parambfwf.jdField_a_of_type_AndroidViewView);
      }
      throw new IllegalArgumentException("recycleMenuView, parent is not ViewGroup");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfwd
 * JD-Core Version:    0.7.0.1
 */