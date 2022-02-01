import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.troop.activity.TroopBarPublishLocationSelectActivity;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class bfjh
  extends blqv
{
  protected LayoutInflater a;
  protected boolean a;
  
  public bfjh(TroopBarPublishLocationSelectActivity paramTroopBarPublishLocationSelectActivity, Context paramContext, boolean paramBoolean)
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
    View localView;
    Object localObject;
    int i;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562290, null);
      paramView = new bfji(this);
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369813));
      paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131377305));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131369801));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131369796));
      localView.setTag(paramView);
      localObject = (TroopBarPOI)this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity.a.get(paramInt);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((TroopBarPOI)localObject).c);
      ImageView localImageView = paramView.jdField_b_of_type_AndroidWidgetImageView;
      if (!((TroopBarPOI)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity.c)) {
        break label261;
      }
      i = 0;
      label139:
      localImageView.setVisibility(i);
      if (TextUtils.isEmpty(((TroopBarPOI)localObject).d)) {
        break label268;
      }
      paramView.jdField_b_of_type_AndroidWidgetTextView.setText(((TroopBarPOI)localObject).d);
      paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      label177:
      if (paramInt != 0) {
        break label280;
      }
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      label189:
      if (!this.jdField_a_of_type_Boolean) {
        break label291;
      }
      localView.setBackgroundResource(17170445);
    }
    for (;;)
    {
      localView.setContentDescription(((TroopBarPOI)localObject).c);
      localView.setFocusable(true);
      localView.setFocusableInTouchMode(true);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (bfji)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label261:
      i = 8;
      break label139;
      label268:
      paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label177;
      label280:
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      break label189;
      label291:
      localView.setBackgroundResource(2130848368);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfjh
 * JD-Core Version:    0.7.0.1
 */