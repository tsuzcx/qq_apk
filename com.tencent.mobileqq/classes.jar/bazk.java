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

public class bazk
  extends BaseAdapter
{
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList;
  
  public bazk(ArrayList<Integer> paramArrayList)
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
    bazj localbazj;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity.getLayoutInflater().inflate(2131562919, paramViewGroup, false);
      localbazj = new bazj(null);
      localbazj.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377990));
      localbazj.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377991));
      paramView.setTag(localbazj);
    }
    for (;;)
    {
      localbazj = (bazj)paramView.getTag();
      bazh localbazh = ActionListActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity).a(((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).intValue());
      if ((localbazh != null) && (localbazj.jdField_a_of_type_Int != localbazh.jdField_a_of_type_Int))
      {
        localbazj.jdField_a_of_type_Int = localbazh.jdField_a_of_type_Int;
        localbazj.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new bico(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity.getResources(), ActionListActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity).a(localbazh.jdField_a_of_type_Int, 201), false, false));
        localbazj.jdField_a_of_type_AndroidWidgetTextView.setText(localbazh.c);
        if (localbazh.b != 1) {
          break label226;
        }
        localbazj.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      }
      for (;;)
      {
        paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        label226:
        localbazj.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity.getResources().getDrawable(2130839273), null);
        localbazj.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bazk
 * JD-Core Version:    0.7.0.1
 */