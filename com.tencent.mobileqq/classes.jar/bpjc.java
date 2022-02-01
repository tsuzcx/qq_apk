import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

class bpjc
  implements SeekBar.OnSeekBarChangeListener
{
  bpjc(bpja parambpja) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!bpja.c(this.a)) {
        break label57;
      }
      bpja.a(this.a, paramInt / 100.0F);
      if (bpja.a(this.a) != null) {
        bpja.a(this.a).a(bpja.a(this.a));
      }
    }
    label57:
    do
    {
      return;
      bpja.b(this.a, paramInt / 100.0F);
      if (bpja.a(this.a) != null) {
        bpja.a(this.a).b(bpja.b(this.a));
      }
      if (paramInt == 0)
      {
        bpja.a(this.a).setEnabled(false);
        return;
      }
    } while (!bpja.d(this.a));
    bpja.a(this.a).setEnabled(true);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpjc
 * JD-Core Version:    0.7.0.1
 */