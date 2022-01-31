import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

class apoy
  implements SeekBar.OnSeekBarChangeListener
{
  apoy(apox paramapox) {}
  
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
    apox.a(this.a, false);
    if ((this.a.a != null) && (!this.a.a.b(apox.a(this.a)))) {
      this.a.a.d();
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    apox.a(this.a, true);
    if (this.a.a != null) {
      this.a.a.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apoy
 * JD-Core Version:    0.7.0.1
 */