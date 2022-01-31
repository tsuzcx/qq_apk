import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

class bbid
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<ResultRecord> jdField_a_of_type_JavaUtilList;
  
  public bbid(QQAppInterface paramQQAppInterface, Context paramContext, List<ResultRecord> paramList, View.OnClickListener paramOnClickListener)
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
    if (ajsd.z.equals(paramResultRecord.a))
    {
      paramImageView.setImageResource(2130843409);
      return;
    }
    if (ajsd.A.equals(paramResultRecord.a))
    {
      paramImageView.setImageResource(2130843407);
      return;
    }
    if (ajsd.B.equals(paramResultRecord.a))
    {
      paramImageView.setImageResource(2130843412);
      return;
    }
    if (ajsd.y.equals(paramResultRecord.a))
    {
      paramImageView.setImageResource(2130839295);
      return;
    }
    int i = a(paramResultRecord.a());
    paramImageView.setImageDrawable(bayh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, paramResultRecord.a));
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
    if (paramView == null)
    {
      paramView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_Bbhz.i, this.jdField_a_of_type_Bbhz.i));
    }
    for (;;)
    {
      a(paramView, a(paramInt));
      paramView.setTag(a(paramInt));
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setFocusable(false);
      return paramView;
      paramView = (ImageView)paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbid
 * JD-Core Version:    0.7.0.1
 */