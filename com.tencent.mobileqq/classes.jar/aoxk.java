import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

class aoxk
  implements SeekBar.OnSeekBarChangeListener
{
  aoxk(aoxj paramaoxj) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.a.a != null))
    {
      this.a.a.a(paramInt);
      this.a.b(paramInt);
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    aoxj.a(this.a, false);
    if ((this.a.a != null) && (!this.a.a.b(aoxj.a(this.a)))) {
      this.a.a.d();
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    aoxj.a(this.a, true);
    if (this.a.a != null) {
      this.a.a.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoxk
 * JD-Core Version:    0.7.0.1
 */