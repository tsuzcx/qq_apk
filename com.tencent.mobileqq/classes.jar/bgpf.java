import android.content.DialogInterface.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bgpf
  implements CompoundButton.OnCheckedChangeListener
{
  bgpf(bgpa parambgpa, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    DialogInterface.OnClickListener localOnClickListener = this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
    bgpa localbgpa = this.jdField_a_of_type_Bgpa;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localOnClickListener.onClick(localbgpa, i);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bgpf
 * JD-Core Version:    0.7.0.1
 */