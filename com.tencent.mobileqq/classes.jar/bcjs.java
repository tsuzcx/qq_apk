import android.view.View;
import android.widget.TextView;

class bcjs
  extends amyh
{
  bcjr jdField_a_of_type_Bcjr = null;
  
  public bcjs(bcjq parambcjq, bcjr parambcjr)
  {
    this.jdField_a_of_type_Bcjr = parambcjr;
  }
  
  public void onFollowPublicAccount(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_Bcjr != null)
    {
      this.jdField_a_of_type_Bcjr.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Bcjr.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (paramBoolean)
      {
        this.jdField_a_of_type_Bcjr.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
        this.jdField_a_of_type_Bcjr.jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131713638));
        this.jdField_a_of_type_Bcjr.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcjs
 * JD-Core Version:    0.7.0.1
 */