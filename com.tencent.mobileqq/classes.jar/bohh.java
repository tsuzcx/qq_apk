import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

class bohh
  implements SeekBar.OnSeekBarChangeListener
{
  bohh(bohf parambohf) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!bohf.c(this.a)) {
        break label57;
      }
      bohf.a(this.a, paramInt / 100.0F);
      if (bohf.a(this.a) != null) {
        bohf.a(this.a).a(bohf.a(this.a));
      }
    }
    label57:
    do
    {
      return;
      bohf.b(this.a, paramInt / 100.0F);
      if (bohf.a(this.a) != null) {
        bohf.a(this.a).b(bohf.b(this.a));
      }
      if (paramInt == 0)
      {
        bohf.a(this.a).setEnabled(false);
        return;
      }
    } while (!bohf.d(this.a));
    bohf.a(this.a).setEnabled(true);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bohh
 * JD-Core Version:    0.7.0.1
 */