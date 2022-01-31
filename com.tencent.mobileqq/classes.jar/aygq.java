import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.troop.activity.TroopBarPublishLocationSelectActivity;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import java.util.ArrayList;

public class aygq
  extends beot
{
  protected LayoutInflater a;
  protected boolean a;
  
  public aygq(TroopBarPublishLocationSelectActivity paramTroopBarPublishLocationSelectActivity, Context paramContext, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity.a == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TroopBarPOI localTroopBarPOI;
    int i;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131496215, null);
      paramViewGroup = new aygr(this);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131303410));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131310057));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131303399));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131303395));
      paramView.setTag(paramViewGroup);
      localTroopBarPOI = (TroopBarPOI)this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity.a.get(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localTroopBarPOI.c);
      ImageView localImageView = paramViewGroup.jdField_b_of_type_AndroidWidgetImageView;
      if (!localTroopBarPOI.equals(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity.c)) {
        break label228;
      }
      i = 0;
      label133:
      localImageView.setVisibility(i);
      if (TextUtils.isEmpty(localTroopBarPOI.d)) {
        break label235;
      }
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localTroopBarPOI.d);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      label171:
      if (paramInt != 0) {
        break label247;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      label183:
      if (!this.jdField_a_of_type_Boolean) {
        break label258;
      }
      paramView.setBackgroundResource(17170445);
    }
    for (;;)
    {
      paramView.setContentDescription(localTroopBarPOI.c);
      paramView.setFocusable(true);
      paramView.setFocusableInTouchMode(true);
      return paramView;
      paramViewGroup = (aygr)paramView.getTag();
      break;
      label228:
      i = 8;
      break label133;
      label235:
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label171;
      label247:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      break label183;
      label258:
      paramView.setBackgroundResource(2130847195);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aygq
 * JD-Core Version:    0.7.0.1
 */