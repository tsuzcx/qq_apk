import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class bkpj
  implements CompoundButton.OnCheckedChangeListener
{
  bkpj(bkpi parambkpi) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    bkpi.a(this.a).f = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkpj
 * JD-Core Version:    0.7.0.1
 */