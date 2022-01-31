import android.content.DialogInterface.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class bbgy
  implements CompoundButton.OnCheckedChangeListener
{
  bbgy(bbgu parambbgu, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    bbgu localbbgu;
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null)
    {
      paramCompoundButton = this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
      localbbgu = this.jdField_a_of_type_Bbgu;
      if (!paramBoolean) {
        break label34;
      }
    }
    label34:
    for (int i = 1;; i = 0)
    {
      paramCompoundButton.onClick(localbbgu, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbgy
 * JD-Core Version:    0.7.0.1
 */