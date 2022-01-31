import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.TroopFeedItem;

class bcsm
  extends bcsl
{
  bcsm(bcsf parambcsf)
  {
    super(parambcsf);
  }
  
  protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(this.a.a).inflate(2131560403, null);
    }
    paramView = (bcsn)localView.getTag();
    Object localObject = paramView;
    if (paramView == null)
    {
      localObject = new bcsn(this);
      ((bcsn)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131371945));
      ((bcsn)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377938));
      ((bcsn)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131380086));
      ((bcsn)localObject).b = ((TextView)localView.findViewById(2131380089));
      ((bcsn)localObject).c = ((TextView)localView.findViewById(2131380090));
      localView.setOnClickListener(this.a);
      localView.setTag(localObject);
    }
    ((bcsn)localObject).jdField_a_of_type_Int = paramInt;
    ((bcsn)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = paramTroopFeedItem;
    paramView = "[" + paramTroopFeedItem.tag + "] " + paramTroopFeedItem.title;
    ((bcsn)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
    ((bcsn)localObject).b.setText(paramTroopFeedItem.content);
    ((bcsn)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    paramView = alud.a(2131715704) + paramTroopFeedItem.tag + " " + paramTroopFeedItem.title + " " + paramTroopFeedItem.content;
    if (!bdnn.a(paramTroopFeedItem.ex_1))
    {
      ((bcsn)localObject).c.setText(paramTroopFeedItem.ex_1);
      paramView = paramView + " " + paramTroopFeedItem.ex_1;
    }
    for (;;)
    {
      ((bcsn)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843227);
      paramTroopFeedItem = paramView;
      if (!paramBoolean) {
        paramTroopFeedItem = paramView + " " + alud.a(2131715700);
      }
      localView.setContentDescription(paramTroopFeedItem);
      return localView;
      ((bcsn)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcsm
 * JD-Core Version:    0.7.0.1
 */