import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.Stack;

public abstract class bhxa
{
  protected String a;
  protected final bhxc[] a;
  protected final Stack<View>[] a;
  protected final int b;
  
  public bhxa(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = bhxa.class.getSimpleName();
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
    this.jdField_a_of_type_ArrayOfBhxc = new bhxc[this.b];
    paramInt1 = i;
    while (paramInt1 < this.b)
    {
      this.jdField_a_of_type_ArrayOfBhxc[paramInt1] = new bhxc();
      paramInt1 += 1;
    }
  }
  
  public int a(Context paramContext, View paramView, int paramInt, Object paramObject, bhxb parambhxb, View.OnClickListener paramOnClickListener)
  {
    int i = 0;
    if ((!(paramView instanceof LinearLayout)) || (parambhxb == null) || (parambhxb.jdField_a_of_type_ArrayOfBhxc == null) || (parambhxb.jdField_a_of_type_ArrayOfBhxc.length == 0) || (parambhxb.jdField_a_of_type_ArrayOfBhxc.length > this.b)) {
      return 0;
    }
    LinearLayout localLinearLayout = (LinearLayout)paramView;
    a(paramInt, paramObject, this.jdField_a_of_type_ArrayOfBhxc);
    int j = 0;
    int n = 0;
    while (n < this.b)
    {
      if ((this.jdField_a_of_type_ArrayOfJavaUtilStack.length > 1) && (parambhxb.jdField_a_of_type_ArrayOfBhxc[n].jdField_a_of_type_Int != this.jdField_a_of_type_ArrayOfBhxc[n].jdField_a_of_type_Int)) {
        a(parambhxb.jdField_a_of_type_ArrayOfBhxc[n]);
      }
      parambhxb.jdField_a_of_type_ArrayOfBhxc[n].jdField_a_of_type_Int = this.jdField_a_of_type_ArrayOfBhxc[n].jdField_a_of_type_Int;
      parambhxb.jdField_a_of_type_ArrayOfBhxc[n].b = this.jdField_a_of_type_ArrayOfBhxc[n].b;
      parambhxb.jdField_a_of_type_ArrayOfBhxc[n].c = 0;
      parambhxb.jdField_a_of_type_ArrayOfBhxc[n].d = -1;
      int k = parambhxb.jdField_a_of_type_ArrayOfBhxc[n].jdField_a_of_type_Int;
      Object localObject1 = parambhxb.jdField_a_of_type_ArrayOfBhxc[n].jdField_a_of_type_AndroidViewView;
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
          parambhxb.jdField_a_of_type_ArrayOfBhxc[n].jdField_a_of_type_AndroidViewView = ((View)???);
          i1 = 1;
          localObject1 = ???;
        }
        for (;;)
        {
          a(paramInt, paramObject, parambhxb.jdField_a_of_type_ArrayOfBhxc[n], paramOnClickListener);
          if (parambhxb.jdField_a_of_type_ArrayOfBhxc[n].c >= 0) {
            break;
          }
          throw new IllegalArgumentException("updateRightMenuView, menuWidth = " + parambhxb.jdField_a_of_type_ArrayOfBhxc[n].c);
          i1 = 0;
        }
        i += parambhxb.jdField_a_of_type_ArrayOfBhxc[n].c;
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
          ??? = new LinearLayout.LayoutParams(parambhxb.jdField_a_of_type_ArrayOfBhxc[n].c, parambhxb.jdField_a_of_type_ArrayOfBhxc[n].d);
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
        ((LinearLayout.LayoutParams)???).width = parambhxb.jdField_a_of_type_ArrayOfBhxc[n].c;
        ((LinearLayout.LayoutParams)???).height = parambhxb.jdField_a_of_type_ArrayOfBhxc[n].d;
      }
    }
    paramView.setTag(-3, Integer.valueOf(i));
    return i;
  }
  
  public abstract View a(int paramInt, Object paramObject, bhxc parambhxc, View.OnClickListener paramOnClickListener);
  
  public abstract View a(Context paramContext, int paramInt);
  
  public View a(Context paramContext, View paramView, bhxb parambhxb, int paramInt)
  {
    if ((parambhxb == null) || (paramView == null)) {
      throw new NullPointerException("SwipRightMenuBuilder.createView holder is null or leftView is null");
    }
    if (this.b > 0)
    {
      parambhxb.jdField_a_of_type_ArrayOfBhxc = new bhxc[this.b];
      int i = 0;
      while (i < this.b)
      {
        parambhxb.jdField_a_of_type_ArrayOfBhxc[i] = new bhxc();
        parambhxb.jdField_a_of_type_ArrayOfBhxc[i].jdField_a_of_type_Int = -1;
        parambhxb.jdField_a_of_type_ArrayOfBhxc[i].c = 0;
        parambhxb.jdField_a_of_type_ArrayOfBhxc[i].jdField_a_of_type_AndroidViewView = null;
        i += 1;
      }
      paramContext = new LinearLayout(paramContext);
      paramContext.setOrientation(0);
      paramContext.addView(paramView, new LinearLayout.LayoutParams(paramInt, -2));
    }
    for (;;)
    {
      parambhxb.g = paramView;
      return paramContext;
      parambhxb.jdField_a_of_type_ArrayOfBhxc = null;
      paramContext = paramView;
    }
  }
  
  public abstract void a(int paramInt, Object paramObject, bhxc[] paramArrayOfbhxc);
  
  protected void a(bhxc parambhxc)
  {
    if (parambhxc == null) {
      return;
    }
    if (parambhxc.jdField_a_of_type_AndroidViewView != null)
    {
      ??? = parambhxc.jdField_a_of_type_AndroidViewView.getParent();
      if (??? != null) {
        break label74;
      }
    }
    synchronized (this.jdField_a_of_type_ArrayOfJavaUtilStack)
    {
      for (;;)
      {
        if ((parambhxc.jdField_a_of_type_Int >= 0) && (parambhxc.jdField_a_of_type_Int < this.jdField_a_of_type_ArrayOfJavaUtilStack.length)) {
          this.jdField_a_of_type_ArrayOfJavaUtilStack[parambhxc.jdField_a_of_type_Int].push(parambhxc.jdField_a_of_type_AndroidViewView);
        }
        parambhxc.a();
        return;
        label74:
        if (!(??? instanceof ViewGroup)) {
          break;
        }
        ((ViewGroup)???).removeView(parambhxc.jdField_a_of_type_AndroidViewView);
      }
      throw new IllegalArgumentException("recycleMenuView, parent is not ViewGroup");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhxa
 * JD-Core Version:    0.7.0.1
 */