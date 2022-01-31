import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class bfgm
  implements CompoundButton.OnCheckedChangeListener
{
  bfgm(bfgl parambfgl, bfds parambfds) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_a_of_type_Bfds.b = paramBoolean;
    this.jdField_a_of_type_Bfgl.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfgm
 * JD-Core Version:    0.7.0.1
 */