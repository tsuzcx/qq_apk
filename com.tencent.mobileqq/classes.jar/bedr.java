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

public abstract class bedr
  extends bedw
{
  public static beey a;
  private static int[] jdField_a_of_type_ArrayOfInt = { BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298726), BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298727) };
  public static beey b;
  public static beey c;
  protected int a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new beds(this);
  private bedv jdField_a_of_type_Bedv;
  protected blpy a;
  
  static
  {
    jdField_a_of_type_Beey = new beey(0, 2131364627, 2131690736, 2130839513);
    b = new beey(0, 2131364626, 2131690735, 2130839514);
    c = new beey(0, 2131364628, 2131690737, 2130839515);
  }
  
  public bedr(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    super(paramQQAppInterface, paramContext, paramBaseAdapter, paramInt);
    this.jdField_a_of_type_Int = 0;
  }
  
  private blpy a()
  {
    if (this.jdField_a_of_type_Blpy != null) {
      return this.jdField_a_of_type_Blpy;
    }
    ArrayList localArrayList = new ArrayList(a());
    if (localArrayList.size() > 3) {
      localArrayList.add(0, jdField_a_of_type_Beey);
    }
    int[] arrayOfInt1 = new int[localArrayList.size()];
    int[] arrayOfInt2 = new int[localArrayList.size()];
    int[] arrayOfInt3 = new int[localArrayList.size()];
    int[] arrayOfInt4 = new int[localArrayList.size()];
    int i = 0;
    while (i < localArrayList.size())
    {
      beey localbeey = (beey)localArrayList.get(i);
      arrayOfInt1[i] = localbeey.b();
      arrayOfInt2[i] = localbeey.c();
      arrayOfInt3[i] = localbeey.d();
      arrayOfInt4[i] = localbeey.a();
      i += 1;
    }
    this.jdField_a_of_type_Blpy = new bedt(this, localArrayList.size(), 2, jdField_a_of_type_ArrayOfInt, -1, arrayOfInt1, arrayOfInt2, arrayOfInt3, localArrayList, arrayOfInt4);
    return this.jdField_a_of_type_Blpy;
  }
  
  private void a(beex parambeex)
  {
    blir localblir = (blir)blji.a(this.jdField_a_of_type_AndroidContentContext, null);
    List localList = a(parambeex);
    localList = localList.subList(0, localList.size() - 2);
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      beey localbeey = (beey)localIterator.next();
      localblir.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(localbeey.c()), 1);
    }
    localblir.c(2131690580);
    localblir.a(new bedu(this, localList, parambeex, localblir));
    localblir.show();
  }
  
  public final View a(int paramInt1, beex parambeex, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2)
  {
    blpy localblpy = a();
    if (paramView == null)
    {
      paramView = new blpw();
      paramViewGroup = b(paramInt1, parambeex, paramView.g, paramViewGroup, paramBoolean1, paramBoolean2, paramOnClickListener, paramOnLongClickListener, paramBoolean3, paramInt2);
      paramOnClickListener = localblpy.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup, paramView, -1);
      paramOnClickListener.setTag(paramView);
      paramViewGroup = paramView;
      paramView = paramOnClickListener;
    }
    for (;;)
    {
      localblpy.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt1, parambeex, paramViewGroup, this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setEnabled(false);
      return paramView;
      blpw localblpw = (blpw)paramView.getTag();
      b(paramInt1, parambeex, localblpw.g, paramViewGroup, paramBoolean1, paramBoolean2, paramOnClickListener, paramOnLongClickListener, paramBoolean3, paramInt2);
      paramViewGroup = localblpw;
    }
  }
  
  public abstract List<beey> a();
  
  public abstract List<beey> a(beex parambeex);
  
  public void a(bedv parambedv)
  {
    this.jdField_a_of_type_Bedv = parambedv;
  }
  
  public abstract View b(int paramInt1, beex parambeex, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bedr
 * JD-Core Version:    0.7.0.1
 */