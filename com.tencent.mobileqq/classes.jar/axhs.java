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

public class axhs
  extends BaseAdapter
  implements axhl
{
  protected int a;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  protected Handler a;
  protected View.OnClickListener a;
  protected View.OnLongClickListener a;
  private axds jdField_a_of_type_Axds;
  private axho jdField_a_of_type_Axho = new axho();
  private axiu jdField_a_of_type_Axiu;
  private axiy jdField_a_of_type_Axiy;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected List<Object> a;
  protected boolean a;
  public int b;
  protected View.OnClickListener b;
  protected boolean b;
  
  public axhs(QQAppInterface paramQQAppInterface, Activity paramActivity, axds paramaxds, Handler paramHandler)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new axht(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Axds = paramaxds;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_Long = (awao.a() * 1000L);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void a(int paramInt, axin paramaxin)
  {
    paramaxin = (PadInfo)paramaxin;
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Axds == null);
      this.jdField_a_of_type_Axds.b(paramaxin);
      return;
    } while (this.jdField_a_of_type_Axds == null);
    this.jdField_a_of_type_Axds.a(paramaxin);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  protected void a(axhm paramaxhm)
  {
    if ((paramaxhm instanceof axhh)) {
      ((axhh)paramaxhm).a(this);
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
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Axho);
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
    return ((axin)this.jdField_a_of_type_JavaUtilList.get(paramInt)).getCloudFileType();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    axin localaxin = (axin)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject2;
    Object localObject1;
    if (localaxin.getCloudFileType() == 10)
    {
      localObject2 = this.jdField_a_of_type_Axiy;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new axiy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Axiy = ((axiy)localObject1);
      }
    }
    for (;;)
    {
      a((axhm)localObject1);
      return ((axhm)localObject1).a(paramInt, localaxin, paramView, paramViewGroup, this.jdField_a_of_type_Boolean, false, this.jdField_b_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_b_of_type_Boolean, this.jdField_b_of_type_Int);
      localObject2 = this.jdField_a_of_type_Axiu;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new axiu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Axiu = ((axiu)localObject1);
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 12;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axhs
 * JD-Core Version:    0.7.0.1
 */