import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class bnel
{
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  TextView b;
  TextView c;
  TextView d;
  
  public bnel(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377427));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377449));
    this.b = ((TextView)paramView.findViewById(2131377418));
    this.c = ((TextView)paramView.findViewById(2131377417));
    this.d = ((TextView)paramView.findViewById(2131377451));
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
  
  public void a(xoe paramxoe1, xoe paramxoe2)
  {
    a(this.jdField_a_of_type_AndroidWidgetTextView, paramxoe1.jdField_a_of_type_Xof.jdField_a_of_type_JavaLangString);
    a(this.b, paramxoe1.jdField_a_of_type_Xof.b);
    if (paramxoe1.jdField_a_of_type_Int <= 0) {
      this.c.setVisibility(8);
    }
    for (;;)
    {
      a(this.d, paramxoe1.jdField_a_of_type_JavaLangString);
      if (!paramxoe1.equals(paramxoe2)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846393);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#12B7F5"));
      return;
      a(this.c, paramxoe1.jdField_a_of_type_Int + alud.a(2131711455));
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846397);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFFFFF"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnel
 * JD-Core Version:    0.7.0.1
 */