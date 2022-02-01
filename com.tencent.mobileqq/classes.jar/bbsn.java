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

public class bbsn
  extends BaseAdapter
{
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList;
  
  public bbsn(ArrayList<Integer> paramArrayList)
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
    bbsm localbbsm;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity.getLayoutInflater().inflate(2131562903, paramViewGroup, false);
      localbbsm = new bbsm(null);
      localbbsm.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131378203));
      localbbsm.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378204));
      paramView.setTag(localbbsm);
    }
    for (;;)
    {
      localbbsm = (bbsm)paramView.getTag();
      bbsk localbbsk = ActionListActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity).a(((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).intValue());
      if ((localbbsk != null) && (localbbsm.jdField_a_of_type_Int != localbbsk.jdField_a_of_type_Int))
      {
        localbbsm.jdField_a_of_type_Int = localbbsk.jdField_a_of_type_Int;
        localbbsm.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new bity(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity.getResources(), ActionListActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity).a(localbbsk.jdField_a_of_type_Int, 201), false, false));
        localbbsm.jdField_a_of_type_AndroidWidgetTextView.setText(localbbsk.c);
        if (localbbsk.b != 1) {
          break label226;
        }
        localbbsm.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      }
      for (;;)
      {
        paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        label226:
        localbbsm.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity.getResources().getDrawable(2130839337), null);
        localbbsm.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbsn
 * JD-Core Version:    0.7.0.1
 */