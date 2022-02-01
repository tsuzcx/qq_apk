import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class bhqm
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<ResultRecord> jdField_a_of_type_JavaUtilList;
  
  public bhqm(QQAppInterface paramQQAppInterface, Context paramContext, List<ResultRecord> paramList, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramContext;
    this.jdField_a_of_type_AndroidContentContext = paramList;
    Object localObject;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = localObject;
    this.jdField_a_of_type_JavaUtilList = paramOnClickListener;
  }
  
  private int a(int paramInt)
  {
    if (paramInt == 4) {}
    do
    {
      return 11;
      if (paramInt == 1) {
        return 4;
      }
      if (paramInt == 3000) {
        return 101;
      }
    } while (paramInt == 1006);
    return 1;
  }
  
  private void a(ImageView paramImageView, ResultRecord paramResultRecord)
  {
    if (antf.z.equals(paramResultRecord.a))
    {
      paramImageView.setImageResource(2130844234);
      return;
    }
    if (antf.A.equals(paramResultRecord.a))
    {
      paramImageView.setImageResource(2130844232);
      return;
    }
    if (antf.B.equals(paramResultRecord.a))
    {
      paramImageView.setImageResource(2130844237);
      return;
    }
    if (antf.y.equals(paramResultRecord.a))
    {
      paramImageView.setImageResource(2130839573);
      return;
    }
    int i = a(paramResultRecord.a());
    paramImageView.setImageDrawable(aoot.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, paramResultRecord.a));
  }
  
  public ResultRecord a(int paramInt)
  {
    return (ResultRecord)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ImageView localImageView;
    if (paramView == null)
    {
      localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localImageView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_Bhqi.i, this.jdField_a_of_type_Bhqi.i));
    }
    for (;;)
    {
      a(localImageView, a(paramInt));
      localImageView.setTag(a(paramInt));
      localImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localImageView.setFocusable(false);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localImageView;
      localImageView = (ImageView)paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhqm
 * JD-Core Version:    0.7.0.1
 */