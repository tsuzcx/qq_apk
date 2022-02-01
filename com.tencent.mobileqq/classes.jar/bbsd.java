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

public class bbsd
  extends BaseAdapter
{
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList;
  
  public bbsd(ArrayList<Integer> paramArrayList)
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
    bbsc localbbsc;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity.getLayoutInflater().inflate(2131562953, paramViewGroup, false);
      localbbsc = new bbsc(null);
      localbbsc.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131378146));
      localbbsc.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378147));
      paramView.setTag(localbbsc);
    }
    for (;;)
    {
      localbbsc = (bbsc)paramView.getTag();
      bbsa localbbsa = ActionListActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity).a(((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).intValue());
      if ((localbbsa != null) && (localbbsc.jdField_a_of_type_Int != localbbsa.jdField_a_of_type_Int))
      {
        localbbsc.jdField_a_of_type_Int = localbbsa.jdField_a_of_type_Int;
        localbbsc.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new bjdm(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity.getResources(), ActionListActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity).a(localbbsa.jdField_a_of_type_Int, 201), false, false));
        localbbsc.jdField_a_of_type_AndroidWidgetTextView.setText(localbbsa.c);
        if (localbbsa.b != 1) {
          break label226;
        }
        localbbsc.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      }
      for (;;)
      {
        paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        label226:
        localbbsc.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity.getResources().getDrawable(2130839281), null);
        localbbsc.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbsd
 * JD-Core Version:    0.7.0.1
 */