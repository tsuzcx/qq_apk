import android.content.DialogInterface.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class bbgk
  implements CompoundButton.OnCheckedChangeListener
{
  bbgk(bbgg parambbgg, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    bbgg localbbgg;
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null)
    {
      paramCompoundButton = this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
      localbbgg = this.jdField_a_of_type_Bbgg;
      if (!paramBoolean) {
        break label34;
      }
    }
    label34:
    for (int i = 1;; i = 0)
    {
      paramCompoundButton.onClick(localbbgg, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbgk
 * JD-Core Version:    0.7.0.1
 */