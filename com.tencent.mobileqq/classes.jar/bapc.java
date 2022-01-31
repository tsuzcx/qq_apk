import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.TroopFeedItem;

class bapc
  extends bapb
{
  bapc(baov parambaov)
  {
    super(parambaov);
  }
  
  protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(this.a.a).inflate(2131560296, null);
    }
    paramView = (bapd)localView.getTag();
    Object localObject = paramView;
    if (paramView == null)
    {
      localObject = new bapd(this);
      ((bapd)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131371608));
      ((bapd)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377350));
      ((bapd)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131379322));
      ((bapd)localObject).b = ((TextView)localView.findViewById(2131379325));
      ((bapd)localObject).c = ((TextView)localView.findViewById(2131379326));
      localView.setOnClickListener(this.a);
      localView.setTag(localObject);
    }
    ((bapd)localObject).jdField_a_of_type_Int = paramInt;
    ((bapd)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = paramTroopFeedItem;
    paramView = "[" + paramTroopFeedItem.tag + "] " + paramTroopFeedItem.title;
    ((bapd)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
    ((bapd)localObject).b.setText(paramTroopFeedItem.content);
    ((bapd)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    paramView = ajyc.a(2131715309) + paramTroopFeedItem.tag + " " + paramTroopFeedItem.title + " " + paramTroopFeedItem.content;
    if (!bbjw.a(paramTroopFeedItem.ex_1))
    {
      ((bapd)localObject).c.setText(paramTroopFeedItem.ex_1);
      paramView = paramView + " " + paramTroopFeedItem.ex_1;
    }
    for (;;)
    {
      ((bapd)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843029);
      paramTroopFeedItem = paramView;
      if (!paramBoolean) {
        paramTroopFeedItem = paramView + " " + ajyc.a(2131715305);
      }
      localView.setContentDescription(paramTroopFeedItem);
      return localView;
      ((bapd)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bapc
 * JD-Core Version:    0.7.0.1
 */