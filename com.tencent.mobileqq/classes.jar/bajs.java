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

public abstract class bajs
  extends bajx
{
  public static bakz a;
  private static int[] jdField_a_of_type_ArrayOfInt = { BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298631), BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298632) };
  public static bakz b;
  public static bakz c;
  protected int a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new bajt(this);
  private bajw jdField_a_of_type_Bajw;
  protected bibk a;
  
  static
  {
    jdField_a_of_type_Bakz = new bakz(0, 2131364371, 2131690895, 2130839328);
    b = new bakz(0, 2131364370, 2131690894, 2130839329);
    c = new bakz(0, 2131364372, 2131690896, 2130839330);
  }
  
  public bajs(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    super(paramQQAppInterface, paramContext, paramBaseAdapter, paramInt);
    this.jdField_a_of_type_Int = 0;
  }
  
  private bibk a()
  {
    if (this.jdField_a_of_type_Bibk != null) {
      return this.jdField_a_of_type_Bibk;
    }
    ArrayList localArrayList = new ArrayList(a());
    if (localArrayList.size() > 3) {
      localArrayList.add(0, jdField_a_of_type_Bakz);
    }
    int[] arrayOfInt1 = new int[localArrayList.size()];
    int[] arrayOfInt2 = new int[localArrayList.size()];
    int[] arrayOfInt3 = new int[localArrayList.size()];
    int[] arrayOfInt4 = new int[localArrayList.size()];
    int i = 0;
    while (i < localArrayList.size())
    {
      bakz localbakz = (bakz)localArrayList.get(i);
      arrayOfInt1[i] = localbakz.b();
      arrayOfInt2[i] = localbakz.c();
      arrayOfInt3[i] = localbakz.d();
      arrayOfInt4[i] = localbakz.a();
      i += 1;
    }
    this.jdField_a_of_type_Bibk = new baju(this, localArrayList.size(), 2, jdField_a_of_type_ArrayOfInt, -1, arrayOfInt1, arrayOfInt2, arrayOfInt3, localArrayList, arrayOfInt4);
    return this.jdField_a_of_type_Bibk;
  }
  
  private void a(baky parambaky)
  {
    bhuf localbhuf = (bhuf)bhus.a(this.jdField_a_of_type_AndroidContentContext, null);
    List localList = a(parambaky);
    localList = localList.subList(0, localList.size() - 2);
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      bakz localbakz = (bakz)localIterator.next();
      localbhuf.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(localbakz.c()), 1);
    }
    localbhuf.c(2131690648);
    localbhuf.a(new bajv(this, localList, parambaky, localbhuf));
    localbhuf.show();
  }
  
  public final View a(int paramInt1, baky parambaky, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2)
  {
    bibk localbibk = a();
    if (paramView == null)
    {
      paramView = new bibi();
      paramViewGroup = b(paramInt1, parambaky, paramView.g, paramViewGroup, paramBoolean1, paramBoolean2, paramOnClickListener, paramOnLongClickListener, paramBoolean3, paramInt2);
      paramOnClickListener = localbibk.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup, paramView, -1);
      paramOnClickListener.setTag(paramView);
      paramViewGroup = paramView;
      paramView = paramOnClickListener;
    }
    for (;;)
    {
      localbibk.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt1, parambaky, paramViewGroup, this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setEnabled(false);
      return paramView;
      bibi localbibi = (bibi)paramView.getTag();
      b(paramInt1, parambaky, localbibi.g, paramViewGroup, paramBoolean1, paramBoolean2, paramOnClickListener, paramOnLongClickListener, paramBoolean3, paramInt2);
      paramViewGroup = localbibi;
    }
  }
  
  public abstract List<bakz> a();
  
  public abstract List<bakz> a(baky parambaky);
  
  public void a(bajw parambajw)
  {
    this.jdField_a_of_type_Bajw = parambajw;
  }
  
  public abstract View b(int paramInt1, baky parambaky, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bajs
 * JD-Core Version:    0.7.0.1
 */