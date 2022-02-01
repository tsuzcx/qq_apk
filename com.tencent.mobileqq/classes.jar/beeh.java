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

public abstract class beeh
  extends beem
{
  public static befo a;
  private static int[] jdField_a_of_type_ArrayOfInt = { BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298795), BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298796) };
  public static befo b;
  public static befo c;
  protected int a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new beei(this);
  private beel jdField_a_of_type_Beel;
  protected blfn a;
  
  static
  {
    jdField_a_of_type_Befo = new befo(0, 2131364742, 2131690853, 2130839569);
    b = new befo(0, 2131364741, 2131690852, 2130839570);
    c = new befo(0, 2131364743, 2131690854, 2130839571);
  }
  
  public beeh(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    super(paramQQAppInterface, paramContext, paramBaseAdapter, paramInt);
    this.jdField_a_of_type_Int = 0;
  }
  
  private blfn a()
  {
    if (this.jdField_a_of_type_Blfn != null) {
      return this.jdField_a_of_type_Blfn;
    }
    ArrayList localArrayList = new ArrayList(a());
    if (localArrayList.size() > 3) {
      localArrayList.add(0, jdField_a_of_type_Befo);
    }
    int[] arrayOfInt1 = new int[localArrayList.size()];
    int[] arrayOfInt2 = new int[localArrayList.size()];
    int[] arrayOfInt3 = new int[localArrayList.size()];
    int[] arrayOfInt4 = new int[localArrayList.size()];
    int i = 0;
    while (i < localArrayList.size())
    {
      befo localbefo = (befo)localArrayList.get(i);
      arrayOfInt1[i] = localbefo.b();
      arrayOfInt2[i] = localbefo.c();
      arrayOfInt3[i] = localbefo.d();
      arrayOfInt4[i] = localbefo.a();
      i += 1;
    }
    this.jdField_a_of_type_Blfn = new beej(this, localArrayList.size(), 2, jdField_a_of_type_ArrayOfInt, -1, arrayOfInt1, arrayOfInt2, arrayOfInt3, localArrayList, arrayOfInt4);
    return this.jdField_a_of_type_Blfn;
  }
  
  private void a(befn parambefn)
  {
    bkzi localbkzi = (bkzi)bkzz.a(this.jdField_a_of_type_AndroidContentContext, null);
    List localList = a(parambefn);
    localList = localList.subList(0, localList.size() - 2);
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      befo localbefo = (befo)localIterator.next();
      localbkzi.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(localbefo.c()), 1);
    }
    localbkzi.c(2131690697);
    localbkzi.a(new beek(this, localList, parambefn, localbkzi));
    localbkzi.show();
  }
  
  public final View a(int paramInt1, befn parambefn, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2)
  {
    blfn localblfn = a();
    if (paramView == null)
    {
      paramView = new blfl();
      paramViewGroup = b(paramInt1, parambefn, paramView.g, paramViewGroup, paramBoolean1, paramBoolean2, paramOnClickListener, paramOnLongClickListener, paramBoolean3, paramInt2);
      paramOnClickListener = localblfn.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup, paramView, -1);
      paramOnClickListener.setTag(paramView);
      paramViewGroup = paramView;
      paramView = paramOnClickListener;
    }
    for (;;)
    {
      localblfn.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt1, parambefn, paramViewGroup, this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setEnabled(false);
      return paramView;
      blfl localblfl = (blfl)paramView.getTag();
      b(paramInt1, parambefn, localblfl.g, paramViewGroup, paramBoolean1, paramBoolean2, paramOnClickListener, paramOnLongClickListener, paramBoolean3, paramInt2);
      paramViewGroup = localblfl;
    }
  }
  
  public abstract List<befo> a();
  
  public abstract List<befo> a(befn parambefn);
  
  public void a(beel parambeel)
  {
    this.jdField_a_of_type_Beel = parambeel;
  }
  
  public abstract View b(int paramInt1, befn parambefn, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beeh
 * JD-Core Version:    0.7.0.1
 */