import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.Stack;

public abstract class blpv
{
  protected String a;
  protected final blpx[] a;
  protected final Stack<View>[] a;
  protected final int b;
  
  public blpv(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = blpv.class.getSimpleName();
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
    this.jdField_a_of_type_ArrayOfBlpx = new blpx[this.b];
    paramInt1 = i;
    while (paramInt1 < this.b)
    {
      this.jdField_a_of_type_ArrayOfBlpx[paramInt1] = new blpx();
      paramInt1 += 1;
    }
  }
  
  public int a(Context paramContext, View paramView, int paramInt, Object paramObject, blpw paramblpw, View.OnClickListener paramOnClickListener)
  {
    int i = 0;
    if ((!(paramView instanceof LinearLayout)) || (paramblpw == null) || (paramblpw.jdField_a_of_type_ArrayOfBlpx == null) || (paramblpw.jdField_a_of_type_ArrayOfBlpx.length == 0) || (paramblpw.jdField_a_of_type_ArrayOfBlpx.length > this.b)) {
      return 0;
    }
    LinearLayout localLinearLayout = (LinearLayout)paramView;
    a(paramInt, paramObject, this.jdField_a_of_type_ArrayOfBlpx);
    int j = 0;
    int n = 0;
    while (n < this.b)
    {
      if ((this.jdField_a_of_type_ArrayOfJavaUtilStack.length > 1) && (paramblpw.jdField_a_of_type_ArrayOfBlpx[n].jdField_a_of_type_Int != this.jdField_a_of_type_ArrayOfBlpx[n].jdField_a_of_type_Int)) {
        a(paramblpw.jdField_a_of_type_ArrayOfBlpx[n]);
      }
      paramblpw.jdField_a_of_type_ArrayOfBlpx[n].jdField_a_of_type_Int = this.jdField_a_of_type_ArrayOfBlpx[n].jdField_a_of_type_Int;
      paramblpw.jdField_a_of_type_ArrayOfBlpx[n].b = this.jdField_a_of_type_ArrayOfBlpx[n].b;
      paramblpw.jdField_a_of_type_ArrayOfBlpx[n].c = 0;
      paramblpw.jdField_a_of_type_ArrayOfBlpx[n].d = -1;
      int k = paramblpw.jdField_a_of_type_ArrayOfBlpx[n].jdField_a_of_type_Int;
      Object localObject1 = paramblpw.jdField_a_of_type_ArrayOfBlpx[n].jdField_a_of_type_AndroidViewView;
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
          paramblpw.jdField_a_of_type_ArrayOfBlpx[n].jdField_a_of_type_AndroidViewView = ((View)???);
          i1 = 1;
          localObject1 = ???;
        }
        for (;;)
        {
          a(paramInt, paramObject, paramblpw.jdField_a_of_type_ArrayOfBlpx[n], paramOnClickListener);
          if (paramblpw.jdField_a_of_type_ArrayOfBlpx[n].c >= 0) {
            break;
          }
          throw new IllegalArgumentException("updateRightMenuView, menuWidth = " + paramblpw.jdField_a_of_type_ArrayOfBlpx[n].c);
          i1 = 0;
        }
        i += paramblpw.jdField_a_of_type_ArrayOfBlpx[n].c;
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
          ??? = new LinearLayout.LayoutParams(paramblpw.jdField_a_of_type_ArrayOfBlpx[n].c, paramblpw.jdField_a_of_type_ArrayOfBlpx[n].d);
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
        ((LinearLayout.LayoutParams)???).width = paramblpw.jdField_a_of_type_ArrayOfBlpx[n].c;
        ((LinearLayout.LayoutParams)???).height = paramblpw.jdField_a_of_type_ArrayOfBlpx[n].d;
      }
    }
    paramView.setTag(-3, Integer.valueOf(i));
    return i;
  }
  
  public abstract View a(int paramInt, Object paramObject, blpx paramblpx, View.OnClickListener paramOnClickListener);
  
  public abstract View a(Context paramContext, int paramInt);
  
  public View a(Context paramContext, View paramView, blpw paramblpw, int paramInt)
  {
    if ((paramblpw == null) || (paramView == null)) {
      throw new NullPointerException("SwipRightMenuBuilder.createView holder is null or leftView is null");
    }
    if (this.b > 0)
    {
      paramblpw.jdField_a_of_type_ArrayOfBlpx = new blpx[this.b];
      int i = 0;
      while (i < this.b)
      {
        paramblpw.jdField_a_of_type_ArrayOfBlpx[i] = new blpx();
        paramblpw.jdField_a_of_type_ArrayOfBlpx[i].jdField_a_of_type_Int = -1;
        paramblpw.jdField_a_of_type_ArrayOfBlpx[i].c = 0;
        paramblpw.jdField_a_of_type_ArrayOfBlpx[i].jdField_a_of_type_AndroidViewView = null;
        i += 1;
      }
      paramContext = new LinearLayout(paramContext);
      paramContext.setOrientation(0);
      paramContext.addView(paramView, new LinearLayout.LayoutParams(paramInt, -2));
    }
    for (;;)
    {
      paramblpw.g = paramView;
      return paramContext;
      paramblpw.jdField_a_of_type_ArrayOfBlpx = null;
      paramContext = paramView;
    }
  }
  
  public abstract void a(int paramInt, Object paramObject, blpx[] paramArrayOfblpx);
  
  protected void a(blpx paramblpx)
  {
    if (paramblpx == null) {
      return;
    }
    if (paramblpx.jdField_a_of_type_AndroidViewView != null)
    {
      ??? = paramblpx.jdField_a_of_type_AndroidViewView.getParent();
      if (??? != null) {
        break label74;
      }
    }
    synchronized (this.jdField_a_of_type_ArrayOfJavaUtilStack)
    {
      for (;;)
      {
        if ((paramblpx.jdField_a_of_type_Int >= 0) && (paramblpx.jdField_a_of_type_Int < this.jdField_a_of_type_ArrayOfJavaUtilStack.length)) {
          this.jdField_a_of_type_ArrayOfJavaUtilStack[paramblpx.jdField_a_of_type_Int].push(paramblpx.jdField_a_of_type_AndroidViewView);
        }
        paramblpx.a();
        return;
        label74:
        if (!(??? instanceof ViewGroup)) {
          break;
        }
        ((ViewGroup)???).removeView(paramblpx.jdField_a_of_type_AndroidViewView);
      }
      throw new IllegalArgumentException("recycleMenuView, parent is not ViewGroup");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blpv
 * JD-Core Version:    0.7.0.1
 */