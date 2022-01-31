import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;

public class azkh
{
  int jdField_a_of_type_Int;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new azki(this);
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  azmb jdField_a_of_type_Azmb;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  View c;
  
  public azkh(View paramView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131378556));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378558));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378555));
    this.c = paramView.findViewById(2131378557);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131378559);
  }
  
  public void a(Context paramContext, azmb paramazmb, View.OnClickListener paramOnClickListener)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setAlpha(1.0F);
    this.jdField_b_of_type_AndroidViewView.setTranslationY(0.0F);
    this.c.setRotation(0.0F);
    this.jdField_a_of_type_AndroidViewView.setTag(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramazmb.b);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramazmb.b);
    this.jdField_a_of_type_Azmb = paramazmb;
    if (paramazmb.jdField_a_of_type_Int != 0)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramazmb.jdField_a_of_type_Int);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      if (!paramazmb.jdField_a_of_type_Boolean) {
        break label142;
      }
      this.c.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(paramOnClickListener);
      return;
      if (paramazmb.jdField_a_of_type_Int == 0) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramazmb.jdField_a_of_type_Int);
      break;
      label142:
      this.c.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azkh
 * JD-Core Version:    0.7.0.1
 */