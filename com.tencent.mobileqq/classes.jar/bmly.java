import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

class bmly
  implements SeekBar.OnSeekBarChangeListener
{
  bmly(bmlw parambmlw) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!bmlw.c(this.a)) {
        break label57;
      }
      bmlw.a(this.a, paramInt / 100.0F);
      if (bmlw.a(this.a) != null) {
        bmlw.a(this.a).a(bmlw.a(this.a));
      }
    }
    label57:
    do
    {
      return;
      bmlw.b(this.a, paramInt / 100.0F);
      if (bmlw.a(this.a) != null) {
        bmlw.a(this.a).b(bmlw.b(this.a));
      }
      if (paramInt == 0)
      {
        bmlw.a(this.a).setEnabled(false);
        return;
      }
    } while (!bmlw.d(this.a));
    bmlw.a(this.a).setEnabled(true);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmly
 * JD-Core Version:    0.7.0.1
 */