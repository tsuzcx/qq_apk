import SummaryCard.CondFitUser;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.conditionsearch.SearchResultActivity;
import com.tencent.mobileqq.widget.InterestLabelTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class apqy
  extends BaseAdapter
{
  private apqy(SearchResultActivity paramSearchResultActivity) {}
  
  public int getCount()
  {
    int j = this.a.jdField_a_of_type_JavaUtilList.size();
    if (this.a.b != 0) {}
    for (int i = 1;; i = 0) {
      return i + j;
    }
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt < this.a.jdField_a_of_type_JavaUtilList.size()) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (getItemViewType(paramInt) == 0)
    {
      localView = paramView;
      if (paramView == null)
      {
        localView = this.a.getLayoutInflater().inflate(2131561000, null);
        localView.setOnClickListener(this.a);
        paramView = new apqz();
        paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131367958));
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371790));
        paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377484));
        paramView.jdField_b_of_type_ComTencentMobileqqWidgetInterestLabelTextView = ((InterestLabelTextView)localView.findViewById(2131367495));
        paramView.c = ((InterestLabelTextView)localView.findViewById(2131381262));
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView = ((InterestLabelTextView)localView.findViewById(2131364278));
        paramView.d = ((InterestLabelTextView)localView.findViewById(2131370317));
        localView.setTag(paramView);
      }
      paramView = (apqz)localView.getTag();
      CondFitUser localCondFitUser = (CondFitUser)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramView = this.a.a(paramView, localCondFitUser);
      if (SearchResultActivity.jdField_a_of_type_Boolean) {
        localView.setContentDescription(paramView);
      }
      paramView = localView;
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localView = paramView;
      if (paramView == null)
      {
        localView = this.a.getLayoutInflater().inflate(2131559487, null);
        localView.setOnClickListener(this.a);
        paramView = new apra();
        localView.setTag(paramView);
        paramView.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView.findViewById(2131376213));
        localView.findViewById(2131370261).setVisibility(8);
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371401));
      }
      if (this.a.b == 1)
      {
        this.a.b = 2;
        SearchResultActivity.d(this.a);
      }
      paramView = (apra)localView.getTag();
      if (this.a.b == 3)
      {
        paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131712766));
        paramView = localView;
      }
      else if (this.a.b == 2)
      {
        paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131712757));
        paramView = localView;
      }
      else
      {
        if (this.a.b == 4)
        {
          paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          paramView.jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131712756));
        }
        paramView = localView;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apqy
 * JD-Core Version:    0.7.0.1
 */