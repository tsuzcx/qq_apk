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

public abstract class bafj
  extends bafo
{
  public static bagq a;
  private static int[] jdField_a_of_type_ArrayOfInt = { BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298631), BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298632) };
  public static bagq b;
  public static bagq c;
  protected int a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new bafk(this);
  private bafn jdField_a_of_type_Bafn;
  protected bhxd a;
  
  static
  {
    jdField_a_of_type_Bagq = new bagq(0, 2131364369, 2131690894, 2130839327);
    b = new bagq(0, 2131364368, 2131690893, 2130839328);
    c = new bagq(0, 2131364370, 2131690895, 2130839329);
  }
  
  public bafj(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    super(paramQQAppInterface, paramContext, paramBaseAdapter, paramInt);
    this.jdField_a_of_type_Int = 0;
  }
  
  private bhxd a()
  {
    if (this.jdField_a_of_type_Bhxd != null) {
      return this.jdField_a_of_type_Bhxd;
    }
    ArrayList localArrayList = new ArrayList(a());
    if (localArrayList.size() > 3) {
      localArrayList.add(0, jdField_a_of_type_Bagq);
    }
    int[] arrayOfInt1 = new int[localArrayList.size()];
    int[] arrayOfInt2 = new int[localArrayList.size()];
    int[] arrayOfInt3 = new int[localArrayList.size()];
    int[] arrayOfInt4 = new int[localArrayList.size()];
    int i = 0;
    while (i < localArrayList.size())
    {
      bagq localbagq = (bagq)localArrayList.get(i);
      arrayOfInt1[i] = localbagq.b();
      arrayOfInt2[i] = localbagq.c();
      arrayOfInt3[i] = localbagq.d();
      arrayOfInt4[i] = localbagq.a();
      i += 1;
    }
    this.jdField_a_of_type_Bhxd = new bafl(this, localArrayList.size(), 2, jdField_a_of_type_ArrayOfInt, -1, arrayOfInt1, arrayOfInt2, arrayOfInt3, localArrayList, arrayOfInt4);
    return this.jdField_a_of_type_Bhxd;
  }
  
  private void a(bagp parambagp)
  {
    bhpy localbhpy = (bhpy)bhql.a(this.jdField_a_of_type_AndroidContentContext, null);
    List localList = a(parambagp);
    localList = localList.subList(0, localList.size() - 2);
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      bagq localbagq = (bagq)localIterator.next();
      localbhpy.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(localbagq.c()), 1);
    }
    localbhpy.c(2131690648);
    localbhpy.a(new bafm(this, localList, parambagp, localbhpy));
    localbhpy.show();
  }
  
  public final View a(int paramInt1, bagp parambagp, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2)
  {
    bhxd localbhxd = a();
    if (paramView == null)
    {
      paramView = new bhxb();
      paramViewGroup = b(paramInt1, parambagp, paramView.g, paramViewGroup, paramBoolean1, paramBoolean2, paramOnClickListener, paramOnLongClickListener, paramBoolean3, paramInt2);
      paramOnClickListener = localbhxd.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup, paramView, -1);
      paramOnClickListener.setTag(paramView);
      paramViewGroup = paramView;
      paramView = paramOnClickListener;
    }
    for (;;)
    {
      localbhxd.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt1, parambagp, paramViewGroup, this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setEnabled(false);
      return paramView;
      bhxb localbhxb = (bhxb)paramView.getTag();
      b(paramInt1, parambagp, localbhxb.g, paramViewGroup, paramBoolean1, paramBoolean2, paramOnClickListener, paramOnLongClickListener, paramBoolean3, paramInt2);
      paramViewGroup = localbhxb;
    }
  }
  
  public abstract List<bagq> a();
  
  public abstract List<bagq> a(bagp parambagp);
  
  public void a(bafn parambafn)
  {
    this.jdField_a_of_type_Bafn = parambafn;
  }
  
  public abstract View b(int paramInt1, bagp parambagp, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bafj
 * JD-Core Version:    0.7.0.1
 */