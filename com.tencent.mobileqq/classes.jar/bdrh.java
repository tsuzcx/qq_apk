import android.view.View;
import android.widget.TextView;

class bdrh
  extends aoeg
{
  bdrg jdField_a_of_type_Bdrg = null;
  
  public bdrh(bdrf parambdrf, bdrg parambdrg)
  {
    this.jdField_a_of_type_Bdrg = parambdrg;
  }
  
  public void onFollowPublicAccount(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_Bdrg != null)
    {
      this.jdField_a_of_type_Bdrg.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Bdrg.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (paramBoolean)
      {
        this.jdField_a_of_type_Bdrg.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
        this.jdField_a_of_type_Bdrg.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131713406));
        this.jdField_a_of_type_Bdrg.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdrh
 * JD-Core Version:    0.7.0.1
 */