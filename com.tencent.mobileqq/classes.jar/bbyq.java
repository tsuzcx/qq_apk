import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class bbyq
  implements CompoundButton.OnCheckedChangeListener
{
  bbyq(bbyp parambbyp, bbvs parambbvs) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_a_of_type_Bbvs.b = paramBoolean;
    this.jdField_a_of_type_Bbyp.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbyq
 * JD-Core Version:    0.7.0.1
 */