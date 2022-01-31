import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class bdcq
  implements CompoundButton.OnCheckedChangeListener
{
  bdcq(bdcp parambdcp, bczs parambczs) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_a_of_type_Bczs.b = paramBoolean;
    this.jdField_a_of_type_Bdcp.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdcq
 * JD-Core Version:    0.7.0.1
 */