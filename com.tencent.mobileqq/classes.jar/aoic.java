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
import java.util.List;

public class aoic
  extends BaseAdapter
{
  private aoic(SearchResultActivity paramSearchResultActivity) {}
  
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
    Object localObject;
    if (getItemViewType(paramInt) == 0)
    {
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = this.a.getLayoutInflater().inflate(2131560884, null);
        paramViewGroup.setOnClickListener(this.a);
        paramView = new aoid();
        paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367546));
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131371160));
        paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131376756));
        paramView.jdField_b_of_type_ComTencentMobileqqWidgetInterestLabelTextView = ((InterestLabelTextView)paramViewGroup.findViewById(2131367114));
        paramView.c = ((InterestLabelTextView)paramViewGroup.findViewById(2131380351));
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView = ((InterestLabelTextView)paramViewGroup.findViewById(2131364013));
        paramView.d = ((InterestLabelTextView)paramViewGroup.findViewById(2131369811));
        paramViewGroup.setTag(paramView);
      }
      paramView = (aoid)paramViewGroup.getTag();
      localObject = (CondFitUser)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
      localObject = this.a.a(paramView, (CondFitUser)localObject);
      paramView = paramViewGroup;
      if (SearchResultActivity.jdField_a_of_type_Boolean)
      {
        paramViewGroup.setContentDescription((CharSequence)localObject);
        paramView = paramViewGroup;
      }
    }
    do
    {
      return paramView;
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = this.a.getLayoutInflater().inflate(2131559364, null);
        paramViewGroup.setOnClickListener(this.a);
        paramView = new aoie();
        paramViewGroup.setTag(paramView);
        paramView.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131375588));
        paramViewGroup.findViewById(2131369761).setVisibility(8);
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131370767));
      }
      if (this.a.b == 1)
      {
        this.a.b = 2;
        SearchResultActivity.d(this.a);
      }
      localObject = (aoie)paramViewGroup.getTag();
      if (this.a.b == 3)
      {
        ((aoie)localObject).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        ((aoie)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131714046));
        return paramViewGroup;
      }
      if (this.a.b == 2)
      {
        ((aoie)localObject).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        ((aoie)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131714037));
        return paramViewGroup;
      }
      paramView = paramViewGroup;
    } while (this.a.b != 4);
    ((aoie)localObject).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    ((aoie)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131714036));
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoic
 * JD-Core Version:    0.7.0.1
 */