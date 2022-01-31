import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class bkou
  implements CompoundButton.OnCheckedChangeListener
{
  bkou(bkot parambkot) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    bkot.a(this.a).g = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkou
 * JD-Core Version:    0.7.0.1
 */