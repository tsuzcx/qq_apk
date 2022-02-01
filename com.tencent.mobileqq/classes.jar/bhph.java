import android.content.DialogInterface.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bhph
  implements CompoundButton.OnCheckedChangeListener
{
  bhph(bhpc parambhpc, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    DialogInterface.OnClickListener localOnClickListener = this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
    bhpc localbhpc = this.jdField_a_of_type_Bhpc;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localOnClickListener.onClick(localbhpc, i);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhph
 * JD-Core Version:    0.7.0.1
 */