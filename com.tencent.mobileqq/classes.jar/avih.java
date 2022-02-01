import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.data.MessageForFuDai;
import com.tencent.mobileqq.widget.FilterRelativeLayout;

public class avih
  extends aggl
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FilterRelativeLayout jdField_a_of_type_ComTencentMobileqqWidgetFilterRelativeLayout;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ImageView c;
  private ImageView d;
  private int e;
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFilterRelativeLayout = ((FilterRelativeLayout)paramView.findViewById(2131367304));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367298));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367302));
    this.c = ((ImageView)paramView.findViewById(2131367303));
    this.d = ((ImageView)paramView.findViewById(2131367299));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367305));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367306));
  }
  
  private void a(MessageForFuDai paramMessageForFuDai)
  {
    this.e = paramMessageForFuDai.themeId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avih
 * JD-Core Version:    0.7.0.1
 */