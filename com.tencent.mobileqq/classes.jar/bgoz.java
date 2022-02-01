import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.utils.StringUtil;

class bgoz
  extends bgoy
{
  bgoz(bgos parambgos)
  {
    super(parambgos);
  }
  
  protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(this.a.a).inflate(2131560635, null);
    }
    paramView = (bgpa)localView.getTag();
    Object localObject = paramView;
    if (paramView == null)
    {
      localObject = new bgpa(this);
      ((bgpa)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131372790));
      ((bgpa)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379001));
      ((bgpa)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131381303));
      ((bgpa)localObject).b = ((TextView)localView.findViewById(2131381306));
      ((bgpa)localObject).c = ((TextView)localView.findViewById(2131381307));
      localView.setOnClickListener(this.a);
      localView.setTag(localObject);
    }
    ((bgpa)localObject).jdField_a_of_type_Int = paramInt;
    ((bgpa)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = paramTroopFeedItem;
    paramView = "[" + paramTroopFeedItem.tag + "] " + paramTroopFeedItem.title;
    ((bgpa)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
    ((bgpa)localObject).b.setText(paramTroopFeedItem.content);
    ((bgpa)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    paramView = anvx.a(2131714673) + paramTroopFeedItem.tag + " " + paramTroopFeedItem.title + " " + paramTroopFeedItem.content;
    if (!StringUtil.isEmpty(paramTroopFeedItem.ex_1))
    {
      ((bgpa)localObject).c.setText(paramTroopFeedItem.ex_1);
      paramView = paramView + " " + paramTroopFeedItem.ex_1;
    }
    for (;;)
    {
      ((bgpa)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843706);
      paramTroopFeedItem = paramView;
      if (!paramBoolean) {
        paramTroopFeedItem = paramView + " " + anvx.a(2131714669);
      }
      localView.setContentDescription(paramTroopFeedItem);
      return localView;
      ((bgpa)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgoz
 * JD-Core Version:    0.7.0.1
 */