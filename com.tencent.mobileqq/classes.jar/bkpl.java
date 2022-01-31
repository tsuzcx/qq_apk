import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class bkpl
  implements CompoundButton.OnCheckedChangeListener
{
  bkpl(bkpk parambkpk) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    bkpk.a(this.a).g = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkpl
 * JD-Core Version:    0.7.0.1
 */