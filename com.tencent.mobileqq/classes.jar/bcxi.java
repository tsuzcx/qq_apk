import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class bcxi
  extends bcxn
{
  public static bcyp a;
  private static int[] jdField_a_of_type_ArrayOfInt = { BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298791), BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298792) };
  public static bcyp b;
  public static bcyp c;
  protected int a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new bcxj(this);
  private bcxm jdField_a_of_type_Bcxm;
  protected bjub a;
  
  static
  {
    jdField_a_of_type_Bcyp = new bcyp(0, 2131364658, 2131690776, 2130839548);
    b = new bcyp(0, 2131364657, 2131690775, 2130839549);
    c = new bcyp(0, 2131364659, 2131690777, 2130839550);
  }
  
  public bcxi(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    super(paramQQAppInterface, paramContext, paramBaseAdapter, paramInt);
    this.jdField_a_of_type_Int = 0;
  }
  
  private bjub a()
  {
    if (this.jdField_a_of_type_Bjub != null) {
      return this.jdField_a_of_type_Bjub;
    }
    ArrayList localArrayList = new ArrayList(a());
    if (localArrayList.size() > 3) {
      localArrayList.add(0, jdField_a_of_type_Bcyp);
    }
    int[] arrayOfInt1 = new int[localArrayList.size()];
    int[] arrayOfInt2 = new int[localArrayList.size()];
    int[] arrayOfInt3 = new int[localArrayList.size()];
    int[] arrayOfInt4 = new int[localArrayList.size()];
    int i = 0;
    while (i < localArrayList.size())
    {
      bcyp localbcyp = (bcyp)localArrayList.get(i);
      arrayOfInt1[i] = localbcyp.b();
      arrayOfInt2[i] = localbcyp.c();
      arrayOfInt3[i] = localbcyp.d();
      arrayOfInt4[i] = localbcyp.a();
      i += 1;
    }
    this.jdField_a_of_type_Bjub = new bcxk(this, localArrayList.size(), 2, jdField_a_of_type_ArrayOfInt, -1, arrayOfInt1, arrayOfInt2, arrayOfInt3, localArrayList, arrayOfInt4);
    return this.jdField_a_of_type_Bjub;
  }
  
  private void a(bcyo parambcyo)
  {
    bjnw localbjnw = (bjnw)bjon.a(this.jdField_a_of_type_AndroidContentContext, null);
    List localList = a(parambcyo);
    localList = localList.subList(0, localList.size() - 2);
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      bcyp localbcyp = (bcyp)localIterator.next();
      localbjnw.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(localbcyp.c()), 1);
    }
    localbjnw.c(2131690620);
    localbjnw.a(new bcxl(this, localList, parambcyo, localbjnw));
    localbjnw.show();
  }
  
  public final View a(int paramInt1, bcyo parambcyo, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2)
  {
    bjub localbjub = a();
    if (paramView == null)
    {
      paramView = new bjtz();
      paramViewGroup = b(paramInt1, parambcyo, paramView.g, paramViewGroup, paramBoolean1, paramBoolean2, paramOnClickListener, paramOnLongClickListener, paramBoolean3, paramInt2);
      paramOnClickListener = localbjub.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup, paramView, -1);
      paramOnClickListener.setTag(paramView);
      paramViewGroup = paramView;
      paramView = paramOnClickListener;
    }
    for (;;)
    {
      localbjub.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt1, parambcyo, paramViewGroup, this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setEnabled(false);
      return paramView;
      bjtz localbjtz = (bjtz)paramView.getTag();
      b(paramInt1, parambcyo, localbjtz.g, paramViewGroup, paramBoolean1, paramBoolean2, paramOnClickListener, paramOnLongClickListener, paramBoolean3, paramInt2);
      paramViewGroup = localbjtz;
    }
  }
  
  public abstract List<bcyp> a();
  
  public abstract List<bcyp> a(bcyo parambcyo);
  
  public void a(bcxm parambcxm)
  {
    this.jdField_a_of_type_Bcxm = parambcxm;
  }
  
  public abstract View b(int paramInt1, bcyo parambcyo, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcxi
 * JD-Core Version:    0.7.0.1
 */