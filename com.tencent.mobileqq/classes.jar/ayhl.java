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

public abstract class ayhl
  extends ayhq
{
  public static ayis a;
  private static int[] jdField_a_of_type_ArrayOfInt = { BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298603), BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298604) };
  public static ayis b;
  public static ayis c;
  protected int a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ayhm(this);
  private ayhp jdField_a_of_type_Ayhp;
  protected bfvp a;
  
  static
  {
    jdField_a_of_type_Ayis = new ayis(0, 2131364302, 2131690842, 2130839238);
    b = new ayis(0, 2131364301, 2131690841, 2130839239);
    c = new ayis(0, 2131364303, 2131690843, 2130839240);
  }
  
  public ayhl(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    super(paramQQAppInterface, paramContext, paramBaseAdapter, paramInt);
    this.jdField_a_of_type_Int = 0;
  }
  
  private bfvp a()
  {
    if (this.jdField_a_of_type_Bfvp != null) {
      return this.jdField_a_of_type_Bfvp;
    }
    ArrayList localArrayList = new ArrayList(a());
    if (localArrayList.size() > 3) {
      localArrayList.add(0, jdField_a_of_type_Ayis);
    }
    int[] arrayOfInt1 = new int[localArrayList.size()];
    int[] arrayOfInt2 = new int[localArrayList.size()];
    int[] arrayOfInt3 = new int[localArrayList.size()];
    int[] arrayOfInt4 = new int[localArrayList.size()];
    int i = 0;
    while (i < localArrayList.size())
    {
      ayis localayis = (ayis)localArrayList.get(i);
      arrayOfInt1[i] = localayis.b();
      arrayOfInt2[i] = localayis.c();
      arrayOfInt3[i] = localayis.d();
      arrayOfInt4[i] = localayis.a();
      i += 1;
    }
    this.jdField_a_of_type_Bfvp = new ayhn(this, localArrayList.size(), 2, jdField_a_of_type_ArrayOfInt, -1, arrayOfInt1, arrayOfInt2, arrayOfInt3, localArrayList, arrayOfInt4);
    return this.jdField_a_of_type_Bfvp;
  }
  
  private void a(ayir paramayir)
  {
    bfol localbfol = (bfol)bfoy.a(this.jdField_a_of_type_AndroidContentContext, null);
    List localList = a(paramayir);
    localList = localList.subList(0, localList.size() - 2);
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      ayis localayis = (ayis)localIterator.next();
      localbfol.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(localayis.c()), 1);
    }
    localbfol.c(2131690596);
    localbfol.a(new ayho(this, localList, paramayir, localbfol));
    localbfol.show();
  }
  
  public final View a(int paramInt1, ayir paramayir, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2)
  {
    bfvp localbfvp = a();
    if (paramView == null)
    {
      paramView = new bfvn();
      paramViewGroup = b(paramInt1, paramayir, paramView.g, paramViewGroup, paramBoolean1, paramBoolean2, paramOnClickListener, paramOnLongClickListener, paramBoolean3, paramInt2);
      paramOnClickListener = localbfvp.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup, paramView, -1);
      paramOnClickListener.setTag(paramView);
      paramViewGroup = paramView;
      paramView = paramOnClickListener;
    }
    for (;;)
    {
      localbfvp.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt1, paramayir, paramViewGroup, this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setEnabled(false);
      return paramView;
      bfvn localbfvn = (bfvn)paramView.getTag();
      b(paramInt1, paramayir, localbfvn.g, paramViewGroup, paramBoolean1, paramBoolean2, paramOnClickListener, paramOnLongClickListener, paramBoolean3, paramInt2);
      paramViewGroup = localbfvn;
    }
  }
  
  public abstract List<ayis> a();
  
  public abstract List<ayis> a(ayir paramayir);
  
  public void a(ayhp paramayhp)
  {
    this.jdField_a_of_type_Ayhp = paramayhp;
  }
  
  public abstract View b(int paramInt1, ayir paramayir, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayhl
 * JD-Core Version:    0.7.0.1
 */