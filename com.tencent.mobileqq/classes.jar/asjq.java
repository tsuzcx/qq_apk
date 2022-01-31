import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.data.MessageForFuDai;
import com.tencent.mobileqq.widget.FilterRelativeLayout;

public class asjq
  extends aeqi
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetFilterRelativeLayout = ((FilterRelativeLayout)paramView.findViewById(2131366982));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366976));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366980));
    this.c = ((ImageView)paramView.findViewById(2131366981));
    this.d = ((ImageView)paramView.findViewById(2131366977));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366983));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366984));
  }
  
  private void a(MessageForFuDai paramMessageForFuDai)
  {
    this.e = paramMessageForFuDai.themeId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asjq
 * JD-Core Version:    0.7.0.1
 */