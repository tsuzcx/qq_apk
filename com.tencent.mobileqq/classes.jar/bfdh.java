import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;

public class bfdh
{
  int jdField_a_of_type_Int;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new bfdi(this);
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  bffb jdField_a_of_type_Bffb;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  View c;
  
  public bfdh(View paramView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131380397));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380399));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380396));
    this.c = paramView.findViewById(2131380398);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131380400);
  }
  
  public void a(Context paramContext, bffb parambffb, View.OnClickListener paramOnClickListener)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setAlpha(1.0F);
    this.jdField_b_of_type_AndroidViewView.setTranslationY(0.0F);
    this.c.setRotation(0.0F);
    this.jdField_a_of_type_AndroidViewView.setTag(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(parambffb.b);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(parambffb.b);
    this.jdField_a_of_type_Bffb = parambffb;
    if (parambffb.jdField_a_of_type_Int != 0)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(parambffb.jdField_a_of_type_Int);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      if (!parambffb.jdField_a_of_type_Boolean) {
        break label142;
      }
      this.c.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(paramOnClickListener);
      return;
      if (parambffb.jdField_a_of_type_Int == 0) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(parambffb.jdField_a_of_type_Int);
      break;
      label142:
      this.c.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfdh
 * JD-Core Version:    0.7.0.1
 */