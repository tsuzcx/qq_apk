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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class beec
  extends BaseAdapter
  implements bedv
{
  protected int a;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  protected Handler a;
  protected View.OnClickListener a;
  protected View.OnLongClickListener a;
  private beab jdField_a_of_type_Beab;
  private bedy jdField_a_of_type_Bedy = new bedy();
  private befe jdField_a_of_type_Befe;
  private befi jdField_a_of_type_Befi;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected List<Object> a;
  protected boolean a;
  public int b;
  protected View.OnClickListener b;
  protected boolean b;
  
  public beec(QQAppInterface paramQQAppInterface, Activity paramActivity, beab parambeab, Handler paramHandler)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new beed(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Beab = parambeab;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_Long = (bcrg.a() * 1000L);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void a(int paramInt, beex parambeex)
  {
    parambeex = (PadInfo)parambeex;
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Beab == null);
      this.jdField_a_of_type_Beab.b(parambeex);
      return;
    } while (this.jdField_a_of_type_Beab == null);
    this.jdField_a_of_type_Beab.a(parambeex);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  protected void a(bedw parambedw)
  {
    if ((parambedw instanceof bedr)) {
      ((bedr)parambedw).a(this);
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
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Bedy);
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
    return ((beex)this.jdField_a_of_type_JavaUtilList.get(paramInt)).getCloudFileType();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    beex localbeex = (beex)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject2;
    Object localObject1;
    if (localbeex.getCloudFileType() == 10)
    {
      localObject2 = this.jdField_a_of_type_Befi;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new befi(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Befi = ((befi)localObject1);
      }
    }
    for (;;)
    {
      a((bedw)localObject1);
      paramView = ((bedw)localObject1).a(paramInt, localbeex, paramView, paramViewGroup, this.jdField_a_of_type_Boolean, false, this.jdField_b_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_b_of_type_Boolean, this.jdField_b_of_type_Int);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject2 = this.jdField_a_of_type_Befe;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new befe(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Befe = ((befe)localObject1);
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 12;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beec
 * JD-Core Version:    0.7.0.1
 */