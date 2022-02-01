import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.richstatus.ActionListActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class baly
  extends BaseAdapter
{
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList;
  
  public baly(ArrayList<Integer> paramArrayList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilArrayList = localObject;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    balx localbalx;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity.getLayoutInflater().inflate(2131562832, paramViewGroup, false);
      localbalx = new balx(null);
      localbalx.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377917));
      localbalx.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377918));
      paramView.setTag(localbalx);
    }
    for (;;)
    {
      localbalx = (balx)paramView.getTag();
      balv localbalv = ActionListActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity).a(((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).intValue());
      if ((localbalv != null) && (localbalx.jdField_a_of_type_Int != localbalv.jdField_a_of_type_Int))
      {
        localbalx.jdField_a_of_type_Int = localbalv.jdField_a_of_type_Int;
        localbalx.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new bhji(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity.getResources(), ActionListActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity).a(localbalv.jdField_a_of_type_Int, 201), false, false));
        localbalx.jdField_a_of_type_AndroidWidgetTextView.setText(localbalv.c);
        if (localbalv.b != 1) {
          break label226;
        }
        localbalx.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      }
      for (;;)
      {
        paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        label226:
        localbalx.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity.getResources().getDrawable(2130839316), null);
        localbalx.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baly
 * JD-Core Version:    0.7.0.1
 */