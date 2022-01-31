import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

class armj
  implements SeekBar.OnSeekBarChangeListener
{
  armj(armi paramarmi) {}
  
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
    armi.a(this.a, false);
    if ((this.a.a != null) && (!this.a.a.b(armi.a(this.a)))) {
      this.a.a.d();
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    armi.a(this.a, true);
    if (this.a.a != null) {
      this.a.a.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     armj
 * JD-Core Version:    0.7.0.1
 */