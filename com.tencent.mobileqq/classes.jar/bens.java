import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.Stack;

public abstract class bens
{
  protected String a;
  protected final benu[] a;
  protected final Stack<View>[] a;
  protected final int b;
  
  public bens(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = bens.class.getSimpleName();
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
    this.jdField_a_of_type_ArrayOfBenu = new benu[this.b];
    paramInt1 = i;
    while (paramInt1 < this.b)
    {
      this.jdField_a_of_type_ArrayOfBenu[paramInt1] = new benu();
      paramInt1 += 1;
    }
  }
  
  public int a(Context paramContext, View paramView, int paramInt, Object paramObject, bent parambent, View.OnClickListener paramOnClickListener)
  {
    int i = 0;
    if ((!(paramView instanceof LinearLayout)) || (parambent == null) || (parambent.jdField_a_of_type_ArrayOfBenu == null) || (parambent.jdField_a_of_type_ArrayOfBenu.length == 0) || (parambent.jdField_a_of_type_ArrayOfBenu.length > this.b)) {
      return 0;
    }
    LinearLayout localLinearLayout = (LinearLayout)paramView;
    a(paramInt, paramObject, this.jdField_a_of_type_ArrayOfBenu);
    int j = 0;
    int n = 0;
    while (n < this.b)
    {
      if ((this.jdField_a_of_type_ArrayOfJavaUtilStack.length > 1) && (parambent.jdField_a_of_type_ArrayOfBenu[n].jdField_a_of_type_Int != this.jdField_a_of_type_ArrayOfBenu[n].jdField_a_of_type_Int)) {
        a(parambent.jdField_a_of_type_ArrayOfBenu[n]);
      }
      parambent.jdField_a_of_type_ArrayOfBenu[n].jdField_a_of_type_Int = this.jdField_a_of_type_ArrayOfBenu[n].jdField_a_of_type_Int;
      parambent.jdField_a_of_type_ArrayOfBenu[n].b = this.jdField_a_of_type_ArrayOfBenu[n].b;
      parambent.jdField_a_of_type_ArrayOfBenu[n].c = 0;
      parambent.jdField_a_of_type_ArrayOfBenu[n].d = -1;
      int k = parambent.jdField_a_of_type_ArrayOfBenu[n].jdField_a_of_type_Int;
      Object localObject1 = parambent.jdField_a_of_type_ArrayOfBenu[n].jdField_a_of_type_AndroidViewView;
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
          parambent.jdField_a_of_type_ArrayOfBenu[n].jdField_a_of_type_AndroidViewView = ((View)???);
          i1 = 1;
          localObject1 = ???;
        }
        for (;;)
        {
          a(paramInt, paramObject, parambent.jdField_a_of_type_ArrayOfBenu[n], paramOnClickListener);
          if (parambent.jdField_a_of_type_ArrayOfBenu[n].c >= 0) {
            break;
          }
          throw new IllegalArgumentException("updateRightMenuView, menuWidth = " + parambent.jdField_a_of_type_ArrayOfBenu[n].c);
          i1 = 0;
        }
        i += parambent.jdField_a_of_type_ArrayOfBenu[n].c;
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
          ??? = new LinearLayout.LayoutParams(parambent.jdField_a_of_type_ArrayOfBenu[n].c, parambent.jdField_a_of_type_ArrayOfBenu[n].d);
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
        ((LinearLayout.LayoutParams)???).width = parambent.jdField_a_of_type_ArrayOfBenu[n].c;
        ((LinearLayout.LayoutParams)???).height = parambent.jdField_a_of_type_ArrayOfBenu[n].d;
      }
    }
    paramView.setTag(-3, Integer.valueOf(i));
    return i;
  }
  
  public abstract View a(int paramInt, Object paramObject, benu parambenu, View.OnClickListener paramOnClickListener);
  
  public abstract View a(Context paramContext, int paramInt);
  
  public View a(Context paramContext, View paramView, bent parambent, int paramInt)
  {
    if ((parambent == null) || (paramView == null)) {
      throw new NullPointerException("SwipRightMenuBuilder.createView holder is null or leftView is null");
    }
    if (this.b > 0)
    {
      parambent.jdField_a_of_type_ArrayOfBenu = new benu[this.b];
      int i = 0;
      while (i < this.b)
      {
        parambent.jdField_a_of_type_ArrayOfBenu[i] = new benu();
        parambent.jdField_a_of_type_ArrayOfBenu[i].jdField_a_of_type_Int = -1;
        parambent.jdField_a_of_type_ArrayOfBenu[i].c = 0;
        parambent.jdField_a_of_type_ArrayOfBenu[i].jdField_a_of_type_AndroidViewView = null;
        i += 1;
      }
      paramContext = new LinearLayout(paramContext);
      paramContext.setOrientation(0);
      paramContext.addView(paramView, new LinearLayout.LayoutParams(paramInt, -2));
    }
    for (;;)
    {
      parambent.g = paramView;
      return paramContext;
      parambent.jdField_a_of_type_ArrayOfBenu = null;
      paramContext = paramView;
    }
  }
  
  public abstract void a(int paramInt, Object paramObject, benu[] paramArrayOfbenu);
  
  protected void a(benu parambenu)
  {
    if (parambenu == null) {
      return;
    }
    if (parambenu.jdField_a_of_type_AndroidViewView != null)
    {
      ??? = parambenu.jdField_a_of_type_AndroidViewView.getParent();
      if (??? != null) {
        break label74;
      }
    }
    synchronized (this.jdField_a_of_type_ArrayOfJavaUtilStack)
    {
      for (;;)
      {
        if ((parambenu.jdField_a_of_type_Int >= 0) && (parambenu.jdField_a_of_type_Int < this.jdField_a_of_type_ArrayOfJavaUtilStack.length)) {
          this.jdField_a_of_type_ArrayOfJavaUtilStack[parambenu.jdField_a_of_type_Int].push(parambenu.jdField_a_of_type_AndroidViewView);
        }
        parambenu.a();
        return;
        label74:
        if (!(??? instanceof ViewGroup)) {
          break;
        }
        ((ViewGroup)???).removeView(parambenu.jdField_a_of_type_AndroidViewView);
      }
      throw new IllegalArgumentException("recycleMenuView, parent is not ViewGroup");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bens
 * JD-Core Version:    0.7.0.1
 */