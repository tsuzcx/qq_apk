import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.utils.StringUtil;

class bfgr
  extends bfgq
{
  bfgr(bfgk parambfgk)
  {
    super(parambfgk);
  }
  
  protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(this.a.a).inflate(2131560583, null);
    }
    paramView = (bfgs)localView.getTag();
    Object localObject = paramView;
    if (paramView == null)
    {
      localObject = new bfgs(this);
      ((bfgs)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131372596));
      ((bfgs)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378707));
      ((bfgs)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131380951));
      ((bfgs)localObject).b = ((TextView)localView.findViewById(2131380954));
      ((bfgs)localObject).c = ((TextView)localView.findViewById(2131380955));
      localView.setOnClickListener(this.a);
      localView.setTag(localObject);
    }
    ((bfgs)localObject).jdField_a_of_type_Int = paramInt;
    ((bfgs)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = paramTroopFeedItem;
    paramView = "[" + paramTroopFeedItem.tag + "] " + paramTroopFeedItem.title;
    ((bfgs)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
    ((bfgs)localObject).b.setText(paramTroopFeedItem.content);
    ((bfgs)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    paramView = amtj.a(2131714326) + paramTroopFeedItem.tag + " " + paramTroopFeedItem.title + " " + paramTroopFeedItem.content;
    if (!StringUtil.isEmpty(paramTroopFeedItem.ex_1))
    {
      ((bfgs)localObject).c.setText(paramTroopFeedItem.ex_1);
      paramView = paramView + " " + paramTroopFeedItem.ex_1;
    }
    for (;;)
    {
      ((bfgs)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843668);
      paramTroopFeedItem = paramView;
      if (!paramBoolean) {
        paramTroopFeedItem = paramView + " " + amtj.a(2131714322);
      }
      localView.setContentDescription(paramTroopFeedItem);
      return localView;
      ((bfgs)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfgr
 * JD-Core Version:    0.7.0.1
 */