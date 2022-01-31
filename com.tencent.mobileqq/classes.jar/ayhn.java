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

public abstract class ayhn
  extends ayhs
{
  public static ayiu a;
  private static int[] jdField_a_of_type_ArrayOfInt = { BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298603), BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298604) };
  public static ayiu b;
  public static ayiu c;
  protected int a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ayho(this);
  private ayhr jdField_a_of_type_Ayhr;
  protected bfwg a;
  
  static
  {
    jdField_a_of_type_Ayiu = new ayiu(0, 2131364301, 2131690842, 2130839238);
    b = new ayiu(0, 2131364300, 2131690841, 2130839239);
    c = new ayiu(0, 2131364302, 2131690843, 2130839240);
  }
  
  public ayhn(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    super(paramQQAppInterface, paramContext, paramBaseAdapter, paramInt);
    this.jdField_a_of_type_Int = 0;
  }
  
  private bfwg a()
  {
    if (this.jdField_a_of_type_Bfwg != null) {
      return this.jdField_a_of_type_Bfwg;
    }
    ArrayList localArrayList = new ArrayList(a());
    if (localArrayList.size() > 3) {
      localArrayList.add(0, jdField_a_of_type_Ayiu);
    }
    int[] arrayOfInt1 = new int[localArrayList.size()];
    int[] arrayOfInt2 = new int[localArrayList.size()];
    int[] arrayOfInt3 = new int[localArrayList.size()];
    int[] arrayOfInt4 = new int[localArrayList.size()];
    int i = 0;
    while (i < localArrayList.size())
    {
      ayiu localayiu = (ayiu)localArrayList.get(i);
      arrayOfInt1[i] = localayiu.b();
      arrayOfInt2[i] = localayiu.c();
      arrayOfInt3[i] = localayiu.d();
      arrayOfInt4[i] = localayiu.a();
      i += 1;
    }
    this.jdField_a_of_type_Bfwg = new ayhp(this, localArrayList.size(), 2, jdField_a_of_type_ArrayOfInt, -1, arrayOfInt1, arrayOfInt2, arrayOfInt3, localArrayList, arrayOfInt4);
    return this.jdField_a_of_type_Bfwg;
  }
  
  private void a(ayit paramayit)
  {
    bfpc localbfpc = (bfpc)bfpp.a(this.jdField_a_of_type_AndroidContentContext, null);
    List localList = a(paramayit);
    localList = localList.subList(0, localList.size() - 2);
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      ayiu localayiu = (ayiu)localIterator.next();
      localbfpc.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(localayiu.c()), 1);
    }
    localbfpc.c(2131690596);
    localbfpc.a(new ayhq(this, localList, paramayit, localbfpc));
    localbfpc.show();
  }
  
  public final View a(int paramInt1, ayit paramayit, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2)
  {
    bfwg localbfwg = a();
    if (paramView == null)
    {
      paramView = new bfwe();
      paramViewGroup = b(paramInt1, paramayit, paramView.g, paramViewGroup, paramBoolean1, paramBoolean2, paramOnClickListener, paramOnLongClickListener, paramBoolean3, paramInt2);
      paramOnClickListener = localbfwg.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup, paramView, -1);
      paramOnClickListener.setTag(paramView);
      paramViewGroup = paramView;
      paramView = paramOnClickListener;
    }
    for (;;)
    {
      localbfwg.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt1, paramayit, paramViewGroup, this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setEnabled(false);
      return paramView;
      bfwe localbfwe = (bfwe)paramView.getTag();
      b(paramInt1, paramayit, localbfwe.g, paramViewGroup, paramBoolean1, paramBoolean2, paramOnClickListener, paramOnLongClickListener, paramBoolean3, paramInt2);
      paramViewGroup = localbfwe;
    }
  }
  
  public abstract List<ayiu> a();
  
  public abstract List<ayiu> a(ayit paramayit);
  
  public void a(ayhr paramayhr)
  {
    this.jdField_a_of_type_Ayhr = paramayhr;
  }
  
  public abstract View b(int paramInt1, ayit paramayit, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayhn
 * JD-Core Version:    0.7.0.1
 */