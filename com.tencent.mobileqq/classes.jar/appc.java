import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

class appc
  implements SeekBar.OnSeekBarChangeListener
{
  appc(appb paramappb) {}
  
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
    appb.a(this.a, false);
    if ((this.a.a != null) && (!this.a.a.b(appb.a(this.a)))) {
      this.a.a.d();
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    appb.a(this.a, true);
    if (this.a.a != null) {
      this.a.a.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     appc
 * JD-Core Version:    0.7.0.1
 */