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

public class ammv
  extends BaseAdapter
{
  private ammv(SearchResultActivity paramSearchResultActivity) {}
  
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
        paramViewGroup = this.a.getLayoutInflater().inflate(2131560690, null);
        paramViewGroup.setOnClickListener(this.a);
        paramView = new ammw();
        paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367407));
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131370830));
        paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131376200));
        paramView.jdField_b_of_type_ComTencentMobileqqWidgetInterestLabelTextView = ((InterestLabelTextView)paramViewGroup.findViewById(2131366981));
        paramView.c = ((InterestLabelTextView)paramViewGroup.findViewById(2131379550));
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView = ((InterestLabelTextView)paramViewGroup.findViewById(2131363953));
        paramView.d = ((InterestLabelTextView)paramViewGroup.findViewById(2131369530));
        paramViewGroup.setTag(paramView);
      }
      paramView = (ammw)paramViewGroup.getTag();
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
        paramViewGroup = this.a.getLayoutInflater().inflate(2131559314, null);
        paramViewGroup.setOnClickListener(this.a);
        paramView = new ammx();
        paramViewGroup.setTag(paramView);
        paramView.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131375056));
        paramViewGroup.findViewById(2131369480).setVisibility(8);
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131370442));
      }
      if (this.a.b == 1)
      {
        this.a.b = 2;
        SearchResultActivity.d(this.a);
      }
      localObject = (ammx)paramViewGroup.getTag();
      if (this.a.b == 3)
      {
        ((ammx)localObject).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        ((ammx)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131713662));
        return paramViewGroup;
      }
      if (this.a.b == 2)
      {
        ((ammx)localObject).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        ((ammx)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131713653));
        return paramViewGroup;
      }
      paramView = paramViewGroup;
    } while (this.a.b != 4);
    ((ammx)localObject).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    ((ammx)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131713652));
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ammv
 * JD-Core Version:    0.7.0.1
 */