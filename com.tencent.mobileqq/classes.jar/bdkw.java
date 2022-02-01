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

public abstract class bdkw
  extends bdlb
{
  public static bdmd a;
  private static int[] jdField_a_of_type_ArrayOfInt = { BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298713), BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298714) };
  public static bdmd b;
  public static bdmd c;
  protected int a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new bdkx(this);
  private bdla jdField_a_of_type_Bdla;
  protected bkov a;
  
  static
  {
    jdField_a_of_type_Bdmd = new bdmd(0, 2131364582, 2131690736, 2130839505);
    b = new bdmd(0, 2131364581, 2131690735, 2130839506);
    c = new bdmd(0, 2131364583, 2131690737, 2130839507);
  }
  
  public bdkw(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    super(paramQQAppInterface, paramContext, paramBaseAdapter, paramInt);
    this.jdField_a_of_type_Int = 0;
  }
  
  private bkov a()
  {
    if (this.jdField_a_of_type_Bkov != null) {
      return this.jdField_a_of_type_Bkov;
    }
    ArrayList localArrayList = new ArrayList(a());
    if (localArrayList.size() > 3) {
      localArrayList.add(0, jdField_a_of_type_Bdmd);
    }
    int[] arrayOfInt1 = new int[localArrayList.size()];
    int[] arrayOfInt2 = new int[localArrayList.size()];
    int[] arrayOfInt3 = new int[localArrayList.size()];
    int[] arrayOfInt4 = new int[localArrayList.size()];
    int i = 0;
    while (i < localArrayList.size())
    {
      bdmd localbdmd = (bdmd)localArrayList.get(i);
      arrayOfInt1[i] = localbdmd.b();
      arrayOfInt2[i] = localbdmd.c();
      arrayOfInt3[i] = localbdmd.d();
      arrayOfInt4[i] = localbdmd.a();
      i += 1;
    }
    this.jdField_a_of_type_Bkov = new bdky(this, localArrayList.size(), 2, jdField_a_of_type_ArrayOfInt, -1, arrayOfInt1, arrayOfInt2, arrayOfInt3, localArrayList, arrayOfInt4);
    return this.jdField_a_of_type_Bkov;
  }
  
  private void a(bdmc parambdmc)
  {
    bkho localbkho = (bkho)bkif.a(this.jdField_a_of_type_AndroidContentContext, null);
    List localList = a(parambdmc);
    localList = localList.subList(0, localList.size() - 2);
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      bdmd localbdmd = (bdmd)localIterator.next();
      localbkho.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(localbdmd.c()), 1);
    }
    localbkho.c(2131690582);
    localbkho.a(new bdkz(this, localList, parambdmc, localbkho));
    localbkho.show();
  }
  
  public final View a(int paramInt1, bdmc parambdmc, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2)
  {
    bkov localbkov = a();
    if (paramView == null)
    {
      paramView = new bkot();
      paramViewGroup = b(paramInt1, parambdmc, paramView.g, paramViewGroup, paramBoolean1, paramBoolean2, paramOnClickListener, paramOnLongClickListener, paramBoolean3, paramInt2);
      paramOnClickListener = localbkov.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup, paramView, -1);
      paramOnClickListener.setTag(paramView);
      paramViewGroup = paramView;
      paramView = paramOnClickListener;
    }
    for (;;)
    {
      localbkov.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt1, parambdmc, paramViewGroup, this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setEnabled(false);
      return paramView;
      bkot localbkot = (bkot)paramView.getTag();
      b(paramInt1, parambdmc, localbkot.g, paramViewGroup, paramBoolean1, paramBoolean2, paramOnClickListener, paramOnLongClickListener, paramBoolean3, paramInt2);
      paramViewGroup = localbkot;
    }
  }
  
  public abstract List<bdmd> a();
  
  public abstract List<bdmd> a(bdmc parambdmc);
  
  public void a(bdla parambdla)
  {
    this.jdField_a_of_type_Bdla = parambdla;
  }
  
  public abstract View b(int paramInt1, bdmc parambdmc, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdkw
 * JD-Core Version:    0.7.0.1
 */