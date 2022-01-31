import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.TroopFeedItem;

class azny
  extends aznx
{
  azny(aznr paramaznr)
  {
    super(paramaznr);
  }
  
  protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(this.a.a).inflate(2131494724, null);
    }
    paramView = (aznz)localView.getTag();
    Object localObject = paramView;
    if (paramView == null)
    {
      localObject = new aznz(this);
      ((aznz)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131305912));
      ((aznz)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131311534));
      ((aznz)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131313487));
      ((aznz)localObject).b = ((TextView)localView.findViewById(2131313490));
      ((aznz)localObject).c = ((TextView)localView.findViewById(2131313491));
      localView.setOnClickListener(this.a);
      localView.setTag(localObject);
    }
    ((aznz)localObject).jdField_a_of_type_Int = paramInt;
    ((aznz)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = paramTroopFeedItem;
    paramView = "[" + paramTroopFeedItem.tag + "] " + paramTroopFeedItem.title;
    ((aznz)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
    ((aznz)localObject).b.setText(paramTroopFeedItem.content);
    ((aznz)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    paramView = ajjy.a(2131649519) + paramTroopFeedItem.tag + " " + paramTroopFeedItem.title + " " + paramTroopFeedItem.content;
    if (!baip.a(paramTroopFeedItem.ex_1))
    {
      ((aznz)localObject).c.setText(paramTroopFeedItem.ex_1);
      paramView = paramView + " " + paramTroopFeedItem.ex_1;
    }
    for (;;)
    {
      ((aznz)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842946);
      paramTroopFeedItem = paramView;
      if (!paramBoolean) {
        paramTroopFeedItem = paramView + " " + ajjy.a(2131649515);
      }
      localView.setContentDescription(paramTroopFeedItem);
      return localView;
      ((aznz)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azny
 * JD-Core Version:    0.7.0.1
 */