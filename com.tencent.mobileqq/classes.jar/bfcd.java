import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class bfcd
  implements CompoundButton.OnCheckedChangeListener
{
  bfcd(bfcc parambfcc, bezj parambezj) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_a_of_type_Bezj.b = paramBoolean;
    this.jdField_a_of_type_Bfcc.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfcd
 * JD-Core Version:    0.7.0.1
 */