import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.TroopFeedItem;

class bcod
  extends bcoc
{
  bcod(bcnw parambcnw)
  {
    super(parambcnw);
  }
  
  protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(this.a.a).inflate(2131560404, null);
    }
    paramView = (bcoe)localView.getTag();
    Object localObject = paramView;
    if (paramView == null)
    {
      localObject = new bcoe(this);
      ((bcoe)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131371925));
      ((bcoe)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377884));
      ((bcoe)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131380028));
      ((bcoe)localObject).b = ((TextView)localView.findViewById(2131380031));
      ((bcoe)localObject).c = ((TextView)localView.findViewById(2131380032));
      localView.setOnClickListener(this.a);
      localView.setTag(localObject);
    }
    ((bcoe)localObject).jdField_a_of_type_Int = paramInt;
    ((bcoe)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = paramTroopFeedItem;
    paramView = "[" + paramTroopFeedItem.tag + "] " + paramTroopFeedItem.title;
    ((bcoe)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
    ((bcoe)localObject).b.setText(paramTroopFeedItem.content);
    ((bcoe)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    paramView = alpo.a(2131715692) + paramTroopFeedItem.tag + " " + paramTroopFeedItem.title + " " + paramTroopFeedItem.content;
    if (!bdje.a(paramTroopFeedItem.ex_1))
    {
      ((bcoe)localObject).c.setText(paramTroopFeedItem.ex_1);
      paramView = paramView + " " + paramTroopFeedItem.ex_1;
    }
    for (;;)
    {
      ((bcoe)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843214);
      paramTroopFeedItem = paramView;
      if (!paramBoolean) {
        paramTroopFeedItem = paramView + " " + alpo.a(2131715688);
      }
      localView.setContentDescription(paramTroopFeedItem);
      return localView;
      ((bcoe)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcod
 * JD-Core Version:    0.7.0.1
 */