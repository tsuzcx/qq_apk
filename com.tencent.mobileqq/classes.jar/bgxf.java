import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.TroopFeedItem;

class bgxf
  extends bgxe
{
  bgxf(bgwy parambgwy)
  {
    super(parambgwy);
  }
  
  protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(this.a.a).inflate(2131560573, null);
    }
    paramView = (bgxg)localView.getTag();
    Object localObject = paramView;
    if (paramView == null)
    {
      localObject = new bgxg(this);
      ((bgxg)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131372628));
      ((bgxg)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378936));
      ((bgxg)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131381229));
      ((bgxg)localObject).b = ((TextView)localView.findViewById(2131381232));
      ((bgxg)localObject).c = ((TextView)localView.findViewById(2131381233));
      localView.setOnClickListener(this.a);
      localView.setTag(localObject);
    }
    ((bgxg)localObject).jdField_a_of_type_Int = paramInt;
    ((bgxg)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = paramTroopFeedItem;
    paramView = "[" + paramTroopFeedItem.tag + "] " + paramTroopFeedItem.title;
    ((bgxg)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
    ((bgxg)localObject).b.setText(paramTroopFeedItem.content);
    ((bgxg)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    paramView = anzj.a(2131714094) + paramTroopFeedItem.tag + " " + paramTroopFeedItem.title + " " + paramTroopFeedItem.content;
    if (!bhsr.a(paramTroopFeedItem.ex_1))
    {
      ((bgxg)localObject).c.setText(paramTroopFeedItem.ex_1);
      paramView = paramView + " " + paramTroopFeedItem.ex_1;
    }
    for (;;)
    {
      ((bgxg)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843606);
      paramTroopFeedItem = paramView;
      if (!paramBoolean) {
        paramTroopFeedItem = paramView + " " + anzj.a(2131714090);
      }
      localView.setContentDescription(paramTroopFeedItem);
      return localView;
      ((bgxg)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgxf
 * JD-Core Version:    0.7.0.1
 */