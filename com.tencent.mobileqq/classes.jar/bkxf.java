import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import dov.com.qq.im.ae.camera.ui.panel.AEBeautyProviderView;

public class bkxf
  implements SeekBar.OnSeekBarChangeListener
{
  public bkxf(AEBeautyProviderView paramAEBeautyProviderView) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (AEBeautyProviderView.a(this.a) != null)
    {
      AEBeautyProviderView.a(this.a).b(paramInt);
      this.a.b.setText("+" + String.format("%.1f", new Object[] { Float.valueOf(paramInt / 10.0F) }));
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    AEBeautyProviderView.a(this.a, AEBeautyProviderView.b(this.a), AEBeautyProviderView.a(this.a));
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if ((AEBeautyProviderView.c(this.a) != null) && ((AEBeautyProviderView.c(this.a) instanceof ViewGroup))) {
      ((ViewGroup)AEBeautyProviderView.c(this.a)).setMotionEventSplittingEnabled(true);
    }
    AEBeautyProviderView.b(this.a, paramSeekBar.getProgress());
    bliy.a().e(paramSeekBar.getProgress());
    AEBeautyProviderView.b(this.a, AEBeautyProviderView.b(this.a), AEBeautyProviderView.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkxf
 * JD-Core Version:    0.7.0.1
 */