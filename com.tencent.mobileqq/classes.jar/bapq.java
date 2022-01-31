import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.TroopFeedItem;

class bapq
  extends bapp
{
  bapq(bapj parambapj)
  {
    super(parambapj);
  }
  
  protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(this.a.a).inflate(2131560296, null);
    }
    paramView = (bapr)localView.getTag();
    Object localObject = paramView;
    if (paramView == null)
    {
      localObject = new bapr(this);
      ((bapr)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131371608));
      ((bapr)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377350));
      ((bapr)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131379327));
      ((bapr)localObject).b = ((TextView)localView.findViewById(2131379330));
      ((bapr)localObject).c = ((TextView)localView.findViewById(2131379331));
      localView.setOnClickListener(this.a);
      localView.setTag(localObject);
    }
    ((bapr)localObject).jdField_a_of_type_Int = paramInt;
    ((bapr)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = paramTroopFeedItem;
    paramView = "[" + paramTroopFeedItem.tag + "] " + paramTroopFeedItem.title;
    ((bapr)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
    ((bapr)localObject).b.setText(paramTroopFeedItem.content);
    ((bapr)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    paramView = ajya.a(2131715320) + paramTroopFeedItem.tag + " " + paramTroopFeedItem.title + " " + paramTroopFeedItem.content;
    if (!bbkk.a(paramTroopFeedItem.ex_1))
    {
      ((bapr)localObject).c.setText(paramTroopFeedItem.ex_1);
      paramView = paramView + " " + paramTroopFeedItem.ex_1;
    }
    for (;;)
    {
      ((bapr)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843030);
      paramTroopFeedItem = paramView;
      if (!paramBoolean) {
        paramTroopFeedItem = paramView + " " + ajya.a(2131715316);
      }
      localView.setContentDescription(paramTroopFeedItem);
      return localView;
      ((bapr)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bapq
 * JD-Core Version:    0.7.0.1
 */