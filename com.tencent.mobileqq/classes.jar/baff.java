import android.content.DialogInterface.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class baff
  implements CompoundButton.OnCheckedChangeListener
{
  baff(bafb parambafb, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    bafb localbafb;
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null)
    {
      paramCompoundButton = this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
      localbafb = this.jdField_a_of_type_Bafb;
      if (!paramBoolean) {
        break label34;
      }
    }
    label34:
    for (int i = 1;; i = 0)
    {
      paramCompoundButton.onClick(localbafb, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     baff
 * JD-Core Version:    0.7.0.1
 */