import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class bixm
{
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  TextView b;
  TextView c;
  TextView d;
  
  public bixm(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131311048));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131311069));
    this.b = ((TextView)paramView.findViewById(2131311039));
    this.c = ((TextView)paramView.findViewById(2131311038));
    this.d = ((TextView)paramView.findViewById(2131311071));
  }
  
  private void a(TextView paramTextView, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramTextView.setVisibility(8);
      return;
    }
    paramTextView.setVisibility(0);
    paramTextView.setText(paramString);
  }
  
  public void a(vik paramvik1, vik paramvik2)
  {
    a(this.jdField_a_of_type_AndroidWidgetTextView, paramvik1.jdField_a_of_type_Vil.jdField_a_of_type_JavaLangString);
    a(this.b, paramvik1.jdField_a_of_type_Vil.b);
    if (paramvik1.jdField_a_of_type_Int <= 0) {
      this.c.setVisibility(8);
    }
    for (;;)
    {
      a(this.d, paramvik1.jdField_a_of_type_JavaLangString);
      if (!paramvik1.equals(paramvik2)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845754);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#12B7F5"));
      return;
      a(this.c, paramvik1.jdField_a_of_type_Int + ajjy.a(2131645272));
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845758);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFFFFF"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bixm
 * JD-Core Version:    0.7.0.1
 */