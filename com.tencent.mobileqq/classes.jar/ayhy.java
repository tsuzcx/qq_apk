import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.PadInfo;
import java.util.ArrayList;
import java.util.List;

public class ayhy
  extends BaseAdapter
  implements ayhr
{
  protected int a;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  protected Handler a;
  protected View.OnClickListener a;
  protected View.OnLongClickListener a;
  private aydw jdField_a_of_type_Aydw;
  private ayhu jdField_a_of_type_Ayhu = new ayhu();
  private ayja jdField_a_of_type_Ayja;
  private ayje jdField_a_of_type_Ayje;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected List<Object> a;
  protected boolean a;
  public int b;
  protected View.OnClickListener b;
  protected boolean b;
  
  public ayhy(QQAppInterface paramQQAppInterface, Activity paramActivity, aydw paramaydw, Handler paramHandler)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new ayhz(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Aydw = paramaydw;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_Long = (awzy.a() * 1000L);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void a(int paramInt, ayit paramayit)
  {
    paramayit = (PadInfo)paramayit;
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Aydw == null);
      this.jdField_a_of_type_Aydw.b(paramayit);
      return;
    } while (this.jdField_a_of_type_Aydw == null);
    this.jdField_a_of_type_Aydw.a(paramayit);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  protected void a(ayhs paramayhs)
  {
    if ((paramayhs instanceof ayhn)) {
      ((ayhn)paramayhs).a(this);
    }
  }
  
  public void a(List<? extends Object> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      }
      notifyDataSetChanged();
    }
    do
    {
      return;
      a();
    } while (this.jdField_a_of_type_AndroidOsHandler == null);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
  }
  
  public void b(List<? extends Object> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Ayhu);
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((ayit)this.jdField_a_of_type_JavaUtilList.get(paramInt)).getCloudFileType();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ayit localayit = (ayit)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject2;
    Object localObject1;
    if (localayit.getCloudFileType() == 10)
    {
      localObject2 = this.jdField_a_of_type_Ayje;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ayje(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Ayje = ((ayje)localObject1);
      }
    }
    for (;;)
    {
      a((ayhs)localObject1);
      return ((ayhs)localObject1).a(paramInt, localayit, paramView, paramViewGroup, this.jdField_a_of_type_Boolean, false, this.jdField_b_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_b_of_type_Boolean, this.jdField_b_of_type_Int);
      localObject2 = this.jdField_a_of_type_Ayja;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ayja(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Ayja = ((ayja)localObject1);
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 12;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayhy
 * JD-Core Version:    0.7.0.1
 */