import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class biyx
  implements CompoundButton.OnCheckedChangeListener
{
  biyx(biyw parambiyw) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    biyw.a(this.a).f = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biyx
 * JD-Core Version:    0.7.0.1
 */