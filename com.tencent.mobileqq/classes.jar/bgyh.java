import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import dov.com.qq.im.AECamera.View.AEBeautyProviderView;

public class bgyh
  implements SeekBar.OnSeekBarChangeListener
{
  public bgyh(AEBeautyProviderView paramAEBeautyProviderView) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (AEBeautyProviderView.a(this.a) != null)
    {
      AEBeautyProviderView.a(this.a).a(paramInt);
      this.a.a.setText("+" + String.format("%.1f", new Object[] { Float.valueOf(paramInt / 10.0F) }));
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    AEBeautyProviderView.a(this.a, AEBeautyProviderView.a(this.a), AEBeautyProviderView.b(this.a));
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if ((AEBeautyProviderView.c(this.a) != null) && ((AEBeautyProviderView.c(this.a) instanceof ViewGroup))) {
      ((ViewGroup)AEBeautyProviderView.c(this.a)).setMotionEventSplittingEnabled(true);
    }
    AEBeautyProviderView.a(this.a, paramSeekBar.getProgress());
    AEBeautyProviderView.b(this.a, AEBeautyProviderView.a(this.a), AEBeautyProviderView.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bgyh
 * JD-Core Version:    0.7.0.1
 */