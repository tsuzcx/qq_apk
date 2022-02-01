import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.TroopFeedItem;

class bfxe
  extends bfxd
{
  bfxe(bfwx parambfwx)
  {
    super(parambfwx);
  }
  
  protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(this.a.a).inflate(2131560558, null);
    }
    paramView = (bfxf)localView.getTag();
    Object localObject = paramView;
    if (paramView == null)
    {
      localObject = new bfxf(this);
      ((bfxf)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131372517));
      ((bfxf)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378776));
      ((bfxf)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131381047));
      ((bfxf)localObject).b = ((TextView)localView.findViewById(2131381050));
      ((bfxf)localObject).c = ((TextView)localView.findViewById(2131381051));
      localView.setOnClickListener(this.a);
      localView.setTag(localObject);
    }
    ((bfxf)localObject).jdField_a_of_type_Int = paramInt;
    ((bfxf)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = paramTroopFeedItem;
    paramView = "[" + paramTroopFeedItem.tag + "] " + paramTroopFeedItem.title;
    ((bfxf)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
    ((bfxf)localObject).b.setText(paramTroopFeedItem.content);
    ((bfxf)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    paramView = anni.a(2131713985) + paramTroopFeedItem.tag + " " + paramTroopFeedItem.title + " " + paramTroopFeedItem.content;
    if (!bgsp.a(paramTroopFeedItem.ex_1))
    {
      ((bfxf)localObject).c.setText(paramTroopFeedItem.ex_1);
      paramView = paramView + " " + paramTroopFeedItem.ex_1;
    }
    for (;;)
    {
      ((bfxf)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843588);
      paramTroopFeedItem = paramView;
      if (!paramBoolean) {
        paramTroopFeedItem = paramView + " " + anni.a(2131713981);
      }
      localView.setContentDescription(paramTroopFeedItem);
      return localView;
      ((bfxf)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfxe
 * JD-Core Version:    0.7.0.1
 */