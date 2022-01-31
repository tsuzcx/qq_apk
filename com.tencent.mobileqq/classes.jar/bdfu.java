import android.content.DialogInterface.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class bdfu
  implements CompoundButton.OnCheckedChangeListener
{
  bdfu(bdfq parambdfq, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    bdfq localbdfq;
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null)
    {
      paramCompoundButton = this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
      localbdfq = this.jdField_a_of_type_Bdfq;
      if (!paramBoolean) {
        break label34;
      }
    }
    label34:
    for (int i = 1;; i = 0)
    {
      paramCompoundButton.onClick(localbdfq, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdfu
 * JD-Core Version:    0.7.0.1
 */