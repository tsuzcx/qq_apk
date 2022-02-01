import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.Stack;

public abstract class blfk
{
  protected String a;
  protected final blfm[] a;
  protected final Stack<View>[] a;
  protected final int b;
  
  public blfk(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = blfk.class.getSimpleName();
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
    this.jdField_a_of_type_ArrayOfBlfm = new blfm[this.b];
    paramInt1 = i;
    while (paramInt1 < this.b)
    {
      this.jdField_a_of_type_ArrayOfBlfm[paramInt1] = new blfm();
      paramInt1 += 1;
    }
  }
  
  public int a(Context paramContext, View paramView, int paramInt, Object paramObject, blfl paramblfl, View.OnClickListener paramOnClickListener)
  {
    int i = 0;
    if ((!(paramView instanceof LinearLayout)) || (paramblfl == null) || (paramblfl.jdField_a_of_type_ArrayOfBlfm == null) || (paramblfl.jdField_a_of_type_ArrayOfBlfm.length == 0) || (paramblfl.jdField_a_of_type_ArrayOfBlfm.length > this.b)) {
      return 0;
    }
    LinearLayout localLinearLayout = (LinearLayout)paramView;
    a(paramInt, paramObject, this.jdField_a_of_type_ArrayOfBlfm);
    int j = 0;
    int n = 0;
    while (n < this.b)
    {
      if ((this.jdField_a_of_type_ArrayOfJavaUtilStack.length > 1) && (paramblfl.jdField_a_of_type_ArrayOfBlfm[n].jdField_a_of_type_Int != this.jdField_a_of_type_ArrayOfBlfm[n].jdField_a_of_type_Int)) {
        a(paramblfl.jdField_a_of_type_ArrayOfBlfm[n]);
      }
      paramblfl.jdField_a_of_type_ArrayOfBlfm[n].jdField_a_of_type_Int = this.jdField_a_of_type_ArrayOfBlfm[n].jdField_a_of_type_Int;
      paramblfl.jdField_a_of_type_ArrayOfBlfm[n].b = this.jdField_a_of_type_ArrayOfBlfm[n].b;
      paramblfl.jdField_a_of_type_ArrayOfBlfm[n].c = 0;
      paramblfl.jdField_a_of_type_ArrayOfBlfm[n].d = -1;
      int k = paramblfl.jdField_a_of_type_ArrayOfBlfm[n].jdField_a_of_type_Int;
      Object localObject1 = paramblfl.jdField_a_of_type_ArrayOfBlfm[n].jdField_a_of_type_AndroidViewView;
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
          paramblfl.jdField_a_of_type_ArrayOfBlfm[n].jdField_a_of_type_AndroidViewView = ((View)???);
          i1 = 1;
          localObject1 = ???;
        }
        for (;;)
        {
          a(paramInt, paramObject, paramblfl.jdField_a_of_type_ArrayOfBlfm[n], paramOnClickListener);
          if (paramblfl.jdField_a_of_type_ArrayOfBlfm[n].c >= 0) {
            break;
          }
          throw new IllegalArgumentException("updateRightMenuView, menuWidth = " + paramblfl.jdField_a_of_type_ArrayOfBlfm[n].c);
          i1 = 0;
        }
        i += paramblfl.jdField_a_of_type_ArrayOfBlfm[n].c;
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
          ??? = new LinearLayout.LayoutParams(paramblfl.jdField_a_of_type_ArrayOfBlfm[n].c, paramblfl.jdField_a_of_type_ArrayOfBlfm[n].d);
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
        ((LinearLayout.LayoutParams)???).width = paramblfl.jdField_a_of_type_ArrayOfBlfm[n].c;
        ((LinearLayout.LayoutParams)???).height = paramblfl.jdField_a_of_type_ArrayOfBlfm[n].d;
      }
    }
    paramView.setTag(-3, Integer.valueOf(i));
    return i;
  }
  
  public abstract View a(int paramInt, Object paramObject, blfm paramblfm, View.OnClickListener paramOnClickListener);
  
  public abstract View a(Context paramContext, int paramInt);
  
  public View a(Context paramContext, View paramView, blfl paramblfl, int paramInt)
  {
    if ((paramblfl == null) || (paramView == null)) {
      throw new NullPointerException("SwipRightMenuBuilder.createView holder is null or leftView is null");
    }
    if (this.b > 0)
    {
      paramblfl.jdField_a_of_type_ArrayOfBlfm = new blfm[this.b];
      int i = 0;
      while (i < this.b)
      {
        paramblfl.jdField_a_of_type_ArrayOfBlfm[i] = new blfm();
        paramblfl.jdField_a_of_type_ArrayOfBlfm[i].jdField_a_of_type_Int = -1;
        paramblfl.jdField_a_of_type_ArrayOfBlfm[i].c = 0;
        paramblfl.jdField_a_of_type_ArrayOfBlfm[i].jdField_a_of_type_AndroidViewView = null;
        i += 1;
      }
      paramContext = new LinearLayout(paramContext);
      paramContext.setOrientation(0);
      paramContext.addView(paramView, new LinearLayout.LayoutParams(paramInt, -2));
    }
    for (;;)
    {
      paramblfl.g = paramView;
      return paramContext;
      paramblfl.jdField_a_of_type_ArrayOfBlfm = null;
      paramContext = paramView;
    }
  }
  
  public abstract void a(int paramInt, Object paramObject, blfm[] paramArrayOfblfm);
  
  protected void a(blfm paramblfm)
  {
    if (paramblfm == null) {
      return;
    }
    if (paramblfm.jdField_a_of_type_AndroidViewView != null)
    {
      ??? = paramblfm.jdField_a_of_type_AndroidViewView.getParent();
      if (??? != null) {
        break label74;
      }
    }
    synchronized (this.jdField_a_of_type_ArrayOfJavaUtilStack)
    {
      for (;;)
      {
        if ((paramblfm.jdField_a_of_type_Int >= 0) && (paramblfm.jdField_a_of_type_Int < this.jdField_a_of_type_ArrayOfJavaUtilStack.length)) {
          this.jdField_a_of_type_ArrayOfJavaUtilStack[paramblfm.jdField_a_of_type_Int].push(paramblfm.jdField_a_of_type_AndroidViewView);
        }
        paramblfm.a();
        return;
        label74:
        if (!(??? instanceof ViewGroup)) {
          break;
        }
        ((ViewGroup)???).removeView(paramblfm.jdField_a_of_type_AndroidViewView);
      }
      throw new IllegalArgumentException("recycleMenuView, parent is not ViewGroup");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blfk
 * JD-Core Version:    0.7.0.1
 */