import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.Stack;

public abstract class bjty
{
  protected String a;
  protected final bjua[] a;
  protected final Stack<View>[] a;
  protected final int b;
  
  public bjty(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = bjty.class.getSimpleName();
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
    this.jdField_a_of_type_ArrayOfBjua = new bjua[this.b];
    paramInt1 = i;
    while (paramInt1 < this.b)
    {
      this.jdField_a_of_type_ArrayOfBjua[paramInt1] = new bjua();
      paramInt1 += 1;
    }
  }
  
  public int a(Context paramContext, View paramView, int paramInt, Object paramObject, bjtz parambjtz, View.OnClickListener paramOnClickListener)
  {
    int i = 0;
    if ((!(paramView instanceof LinearLayout)) || (parambjtz == null) || (parambjtz.jdField_a_of_type_ArrayOfBjua == null) || (parambjtz.jdField_a_of_type_ArrayOfBjua.length == 0) || (parambjtz.jdField_a_of_type_ArrayOfBjua.length > this.b)) {
      return 0;
    }
    LinearLayout localLinearLayout = (LinearLayout)paramView;
    a(paramInt, paramObject, this.jdField_a_of_type_ArrayOfBjua);
    int j = 0;
    int n = 0;
    while (n < this.b)
    {
      if ((this.jdField_a_of_type_ArrayOfJavaUtilStack.length > 1) && (parambjtz.jdField_a_of_type_ArrayOfBjua[n].jdField_a_of_type_Int != this.jdField_a_of_type_ArrayOfBjua[n].jdField_a_of_type_Int)) {
        a(parambjtz.jdField_a_of_type_ArrayOfBjua[n]);
      }
      parambjtz.jdField_a_of_type_ArrayOfBjua[n].jdField_a_of_type_Int = this.jdField_a_of_type_ArrayOfBjua[n].jdField_a_of_type_Int;
      parambjtz.jdField_a_of_type_ArrayOfBjua[n].b = this.jdField_a_of_type_ArrayOfBjua[n].b;
      parambjtz.jdField_a_of_type_ArrayOfBjua[n].c = 0;
      parambjtz.jdField_a_of_type_ArrayOfBjua[n].d = -1;
      int k = parambjtz.jdField_a_of_type_ArrayOfBjua[n].jdField_a_of_type_Int;
      Object localObject1 = parambjtz.jdField_a_of_type_ArrayOfBjua[n].jdField_a_of_type_AndroidViewView;
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
          parambjtz.jdField_a_of_type_ArrayOfBjua[n].jdField_a_of_type_AndroidViewView = ((View)???);
          i1 = 1;
          localObject1 = ???;
        }
        for (;;)
        {
          a(paramInt, paramObject, parambjtz.jdField_a_of_type_ArrayOfBjua[n], paramOnClickListener);
          if (parambjtz.jdField_a_of_type_ArrayOfBjua[n].c >= 0) {
            break;
          }
          throw new IllegalArgumentException("updateRightMenuView, menuWidth = " + parambjtz.jdField_a_of_type_ArrayOfBjua[n].c);
          i1 = 0;
        }
        i += parambjtz.jdField_a_of_type_ArrayOfBjua[n].c;
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
          ??? = new LinearLayout.LayoutParams(parambjtz.jdField_a_of_type_ArrayOfBjua[n].c, parambjtz.jdField_a_of_type_ArrayOfBjua[n].d);
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
        ((LinearLayout.LayoutParams)???).width = parambjtz.jdField_a_of_type_ArrayOfBjua[n].c;
        ((LinearLayout.LayoutParams)???).height = parambjtz.jdField_a_of_type_ArrayOfBjua[n].d;
      }
    }
    paramView.setTag(-3, Integer.valueOf(i));
    return i;
  }
  
  public abstract View a(int paramInt, Object paramObject, bjua parambjua, View.OnClickListener paramOnClickListener);
  
  public abstract View a(Context paramContext, int paramInt);
  
  public View a(Context paramContext, View paramView, bjtz parambjtz, int paramInt)
  {
    if ((parambjtz == null) || (paramView == null)) {
      throw new NullPointerException("SwipRightMenuBuilder.createView holder is null or leftView is null");
    }
    if (this.b > 0)
    {
      parambjtz.jdField_a_of_type_ArrayOfBjua = new bjua[this.b];
      int i = 0;
      while (i < this.b)
      {
        parambjtz.jdField_a_of_type_ArrayOfBjua[i] = new bjua();
        parambjtz.jdField_a_of_type_ArrayOfBjua[i].jdField_a_of_type_Int = -1;
        parambjtz.jdField_a_of_type_ArrayOfBjua[i].c = 0;
        parambjtz.jdField_a_of_type_ArrayOfBjua[i].jdField_a_of_type_AndroidViewView = null;
        i += 1;
      }
      paramContext = new LinearLayout(paramContext);
      paramContext.setOrientation(0);
      paramContext.addView(paramView, new LinearLayout.LayoutParams(paramInt, -2));
    }
    for (;;)
    {
      parambjtz.g = paramView;
      return paramContext;
      parambjtz.jdField_a_of_type_ArrayOfBjua = null;
      paramContext = paramView;
    }
  }
  
  public abstract void a(int paramInt, Object paramObject, bjua[] paramArrayOfbjua);
  
  protected void a(bjua parambjua)
  {
    if (parambjua == null) {
      return;
    }
    if (parambjua.jdField_a_of_type_AndroidViewView != null)
    {
      ??? = parambjua.jdField_a_of_type_AndroidViewView.getParent();
      if (??? != null) {
        break label74;
      }
    }
    synchronized (this.jdField_a_of_type_ArrayOfJavaUtilStack)
    {
      for (;;)
      {
        if ((parambjua.jdField_a_of_type_Int >= 0) && (parambjua.jdField_a_of_type_Int < this.jdField_a_of_type_ArrayOfJavaUtilStack.length)) {
          this.jdField_a_of_type_ArrayOfJavaUtilStack[parambjua.jdField_a_of_type_Int].push(parambjua.jdField_a_of_type_AndroidViewView);
        }
        parambjua.a();
        return;
        label74:
        if (!(??? instanceof ViewGroup)) {
          break;
        }
        ((ViewGroup)???).removeView(parambjua.jdField_a_of_type_AndroidViewView);
      }
      throw new IllegalArgumentException("recycleMenuView, parent is not ViewGroup");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjty
 * JD-Core Version:    0.7.0.1
 */