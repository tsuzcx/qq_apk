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

public abstract class axhh
  extends axhm
{
  public static axio a;
  private static int[] jdField_a_of_type_ArrayOfInt = { BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131167510), BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131167511) };
  public static axio b;
  public static axio c;
  protected int a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new axhi(this);
  private axhl jdField_a_of_type_Axhl;
  protected benv a;
  
  static
  {
    jdField_a_of_type_Axio = new axio(0, 2131298745, 2131625279, 2130839214);
    b = new axio(0, 2131298744, 2131625278, 2130839215);
    c = new axio(0, 2131298746, 2131625280, 2130839216);
  }
  
  public axhh(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    super(paramQQAppInterface, paramContext, paramBaseAdapter, paramInt);
    this.jdField_a_of_type_Int = 0;
  }
  
  private benv a()
  {
    if (this.jdField_a_of_type_Benv != null) {
      return this.jdField_a_of_type_Benv;
    }
    ArrayList localArrayList = new ArrayList(a());
    if (localArrayList.size() > 3) {
      localArrayList.add(0, jdField_a_of_type_Axio);
    }
    int[] arrayOfInt1 = new int[localArrayList.size()];
    int[] arrayOfInt2 = new int[localArrayList.size()];
    int[] arrayOfInt3 = new int[localArrayList.size()];
    int[] arrayOfInt4 = new int[localArrayList.size()];
    int i = 0;
    while (i < localArrayList.size())
    {
      axio localaxio = (axio)localArrayList.get(i);
      arrayOfInt1[i] = localaxio.b();
      arrayOfInt2[i] = localaxio.c();
      arrayOfInt3[i] = localaxio.d();
      arrayOfInt4[i] = localaxio.a();
      i += 1;
    }
    this.jdField_a_of_type_Benv = new axhj(this, localArrayList.size(), 2, jdField_a_of_type_ArrayOfInt, -1, arrayOfInt1, arrayOfInt2, arrayOfInt3, localArrayList, arrayOfInt4);
    return this.jdField_a_of_type_Benv;
  }
  
  private void a(axin paramaxin)
  {
    begr localbegr = (begr)behe.a(this.jdField_a_of_type_AndroidContentContext, null);
    List localList = a(paramaxin);
    localList = localList.subList(0, localList.size() - 2);
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      axio localaxio = (axio)localIterator.next();
      localbegr.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(localaxio.c()), 1);
    }
    localbegr.c(2131625035);
    localbegr.a(new axhk(this, localList, paramaxin, localbegr));
    localbegr.show();
  }
  
  public final View a(int paramInt1, axin paramaxin, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2)
  {
    benv localbenv = a();
    if (paramView == null)
    {
      paramView = new bent();
      paramViewGroup = b(paramInt1, paramaxin, paramView.g, paramViewGroup, paramBoolean1, paramBoolean2, paramOnClickListener, paramOnLongClickListener, paramBoolean3, paramInt2);
      paramOnClickListener = localbenv.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup, paramView, -1);
      paramOnClickListener.setTag(paramView);
      paramViewGroup = paramView;
      paramView = paramOnClickListener;
    }
    for (;;)
    {
      localbenv.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt1, paramaxin, paramViewGroup, this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setEnabled(false);
      return paramView;
      bent localbent = (bent)paramView.getTag();
      b(paramInt1, paramaxin, localbent.g, paramViewGroup, paramBoolean1, paramBoolean2, paramOnClickListener, paramOnLongClickListener, paramBoolean3, paramInt2);
      paramViewGroup = localbent;
    }
  }
  
  public abstract List<axio> a();
  
  public abstract List<axio> a(axin paramaxin);
  
  public void a(axhl paramaxhl)
  {
    this.jdField_a_of_type_Axhl = paramaxhl;
  }
  
  public abstract View b(int paramInt1, axin paramaxin, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axhh
 * JD-Core Version:    0.7.0.1
 */