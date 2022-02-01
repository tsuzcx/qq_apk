import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

class bobq
  implements SeekBar.OnSeekBarChangeListener
{
  bobq(bobo parambobo) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!bobo.c(this.a)) {
        break label57;
      }
      bobo.a(this.a, paramInt / 100.0F);
      if (bobo.a(this.a) != null) {
        bobo.a(this.a).a(bobo.a(this.a));
      }
    }
    label57:
    do
    {
      return;
      bobo.b(this.a, paramInt / 100.0F);
      if (bobo.a(this.a) != null) {
        bobo.a(this.a).b(bobo.b(this.a));
      }
      if (paramInt == 0)
      {
        bobo.a(this.a).setEnabled(false);
        return;
      }
    } while (!bobo.d(this.a));
    bobo.a(this.a).setEnabled(true);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bobq
 * JD-Core Version:    0.7.0.1
 */