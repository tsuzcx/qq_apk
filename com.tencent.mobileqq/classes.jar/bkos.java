import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.Stack;

public abstract class bkos
{
  protected String a;
  protected final bkou[] a;
  protected final Stack<View>[] a;
  protected final int b;
  
  public bkos(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = bkos.class.getSimpleName();
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
    this.jdField_a_of_type_ArrayOfBkou = new bkou[this.b];
    paramInt1 = i;
    while (paramInt1 < this.b)
    {
      this.jdField_a_of_type_ArrayOfBkou[paramInt1] = new bkou();
      paramInt1 += 1;
    }
  }
  
  public int a(Context paramContext, View paramView, int paramInt, Object paramObject, bkot parambkot, View.OnClickListener paramOnClickListener)
  {
    int i = 0;
    if ((!(paramView instanceof LinearLayout)) || (parambkot == null) || (parambkot.jdField_a_of_type_ArrayOfBkou == null) || (parambkot.jdField_a_of_type_ArrayOfBkou.length == 0) || (parambkot.jdField_a_of_type_ArrayOfBkou.length > this.b)) {
      return 0;
    }
    LinearLayout localLinearLayout = (LinearLayout)paramView;
    a(paramInt, paramObject, this.jdField_a_of_type_ArrayOfBkou);
    int j = 0;
    int n = 0;
    while (n < this.b)
    {
      if ((this.jdField_a_of_type_ArrayOfJavaUtilStack.length > 1) && (parambkot.jdField_a_of_type_ArrayOfBkou[n].jdField_a_of_type_Int != this.jdField_a_of_type_ArrayOfBkou[n].jdField_a_of_type_Int)) {
        a(parambkot.jdField_a_of_type_ArrayOfBkou[n]);
      }
      parambkot.jdField_a_of_type_ArrayOfBkou[n].jdField_a_of_type_Int = this.jdField_a_of_type_ArrayOfBkou[n].jdField_a_of_type_Int;
      parambkot.jdField_a_of_type_ArrayOfBkou[n].b = this.jdField_a_of_type_ArrayOfBkou[n].b;
      parambkot.jdField_a_of_type_ArrayOfBkou[n].c = 0;
      parambkot.jdField_a_of_type_ArrayOfBkou[n].d = -1;
      int k = parambkot.jdField_a_of_type_ArrayOfBkou[n].jdField_a_of_type_Int;
      Object localObject1 = parambkot.jdField_a_of_type_ArrayOfBkou[n].jdField_a_of_type_AndroidViewView;
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
          parambkot.jdField_a_of_type_ArrayOfBkou[n].jdField_a_of_type_AndroidViewView = ((View)???);
          i1 = 1;
          localObject1 = ???;
        }
        for (;;)
        {
          a(paramInt, paramObject, parambkot.jdField_a_of_type_ArrayOfBkou[n], paramOnClickListener);
          if (parambkot.jdField_a_of_type_ArrayOfBkou[n].c >= 0) {
            break;
          }
          throw new IllegalArgumentException("updateRightMenuView, menuWidth = " + parambkot.jdField_a_of_type_ArrayOfBkou[n].c);
          i1 = 0;
        }
        i += parambkot.jdField_a_of_type_ArrayOfBkou[n].c;
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
          ??? = new LinearLayout.LayoutParams(parambkot.jdField_a_of_type_ArrayOfBkou[n].c, parambkot.jdField_a_of_type_ArrayOfBkou[n].d);
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
        ((LinearLayout.LayoutParams)???).width = parambkot.jdField_a_of_type_ArrayOfBkou[n].c;
        ((LinearLayout.LayoutParams)???).height = parambkot.jdField_a_of_type_ArrayOfBkou[n].d;
      }
    }
    paramView.setTag(-3, Integer.valueOf(i));
    return i;
  }
  
  public abstract View a(int paramInt, Object paramObject, bkou parambkou, View.OnClickListener paramOnClickListener);
  
  public abstract View a(Context paramContext, int paramInt);
  
  public View a(Context paramContext, View paramView, bkot parambkot, int paramInt)
  {
    if ((parambkot == null) || (paramView == null)) {
      throw new NullPointerException("SwipRightMenuBuilder.createView holder is null or leftView is null");
    }
    if (this.b > 0)
    {
      parambkot.jdField_a_of_type_ArrayOfBkou = new bkou[this.b];
      int i = 0;
      while (i < this.b)
      {
        parambkot.jdField_a_of_type_ArrayOfBkou[i] = new bkou();
        parambkot.jdField_a_of_type_ArrayOfBkou[i].jdField_a_of_type_Int = -1;
        parambkot.jdField_a_of_type_ArrayOfBkou[i].c = 0;
        parambkot.jdField_a_of_type_ArrayOfBkou[i].jdField_a_of_type_AndroidViewView = null;
        i += 1;
      }
      paramContext = new LinearLayout(paramContext);
      paramContext.setOrientation(0);
      paramContext.addView(paramView, new LinearLayout.LayoutParams(paramInt, -2));
    }
    for (;;)
    {
      parambkot.g = paramView;
      return paramContext;
      parambkot.jdField_a_of_type_ArrayOfBkou = null;
      paramContext = paramView;
    }
  }
  
  public abstract void a(int paramInt, Object paramObject, bkou[] paramArrayOfbkou);
  
  protected void a(bkou parambkou)
  {
    if (parambkou == null) {
      return;
    }
    if (parambkou.jdField_a_of_type_AndroidViewView != null)
    {
      ??? = parambkou.jdField_a_of_type_AndroidViewView.getParent();
      if (??? != null) {
        break label74;
      }
    }
    synchronized (this.jdField_a_of_type_ArrayOfJavaUtilStack)
    {
      for (;;)
      {
        if ((parambkou.jdField_a_of_type_Int >= 0) && (parambkou.jdField_a_of_type_Int < this.jdField_a_of_type_ArrayOfJavaUtilStack.length)) {
          this.jdField_a_of_type_ArrayOfJavaUtilStack[parambkou.jdField_a_of_type_Int].push(parambkou.jdField_a_of_type_AndroidViewView);
        }
        parambkou.a();
        return;
        label74:
        if (!(??? instanceof ViewGroup)) {
          break;
        }
        ((ViewGroup)???).removeView(parambkou.jdField_a_of_type_AndroidViewView);
      }
      throw new IllegalArgumentException("recycleMenuView, parent is not ViewGroup");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkos
 * JD-Core Version:    0.7.0.1
 */