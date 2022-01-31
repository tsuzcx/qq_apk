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

public class bafu
  extends BaseAdapter
  implements bafn
{
  protected int a;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  protected Handler a;
  protected View.OnClickListener a;
  protected View.OnLongClickListener a;
  private babt jdField_a_of_type_Babt;
  private bafq jdField_a_of_type_Bafq = new bafq();
  private bagw jdField_a_of_type_Bagw;
  private baha jdField_a_of_type_Baha;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected List<Object> a;
  protected boolean a;
  public int b;
  protected View.OnClickListener b;
  protected boolean b;
  
  public bafu(QQAppInterface paramQQAppInterface, Activity paramActivity, babt parambabt, Handler paramHandler)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new bafv(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Babt = parambabt;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_Long = (ayvc.a() * 1000L);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void a(int paramInt, bagp parambagp)
  {
    parambagp = (PadInfo)parambagp;
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Babt == null);
      this.jdField_a_of_type_Babt.b(parambagp);
      return;
    } while (this.jdField_a_of_type_Babt == null);
    this.jdField_a_of_type_Babt.a(parambagp);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  protected void a(bafo parambafo)
  {
    if ((parambafo instanceof bafj)) {
      ((bafj)parambafo).a(this);
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
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Bafq);
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
    return ((bagp)this.jdField_a_of_type_JavaUtilList.get(paramInt)).getCloudFileType();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    bagp localbagp = (bagp)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject2;
    Object localObject1;
    if (localbagp.getCloudFileType() == 10)
    {
      localObject2 = this.jdField_a_of_type_Baha;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new baha(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Baha = ((baha)localObject1);
      }
    }
    for (;;)
    {
      a((bafo)localObject1);
      return ((bafo)localObject1).a(paramInt, localbagp, paramView, paramViewGroup, this.jdField_a_of_type_Boolean, false, this.jdField_b_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_b_of_type_Boolean, this.jdField_b_of_type_Int);
      localObject2 = this.jdField_a_of_type_Bagw;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new bagw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Bagw = ((bagw)localObject1);
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 12;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bafu
 * JD-Core Version:    0.7.0.1
 */