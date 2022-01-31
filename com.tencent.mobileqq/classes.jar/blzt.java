import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import dov.com.qq.im.capture.view.QIMProviderContainerView;

public class blzt
  implements SeekBar.OnSeekBarChangeListener
{
  public blzt(AdvancedProviderView paramAdvancedProviderView, TextView paramTextView, View paramView1, View paramView2, QIMProviderContainerView paramQIMProviderContainerView, View paramView3) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewAdvancedProviderView.a != null)
    {
      this.jdField_a_of_type_DovComQqImCaptureViewAdvancedProviderView.a.c(paramInt);
      this.jdField_a_of_type_AndroidWidgetTextView.setText("+" + String.format("%.1f", new Object[] { Float.valueOf(paramInt / 10.0F) }));
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView instanceof ViewGroup))) {
      ((ViewGroup)this.jdField_a_of_type_AndroidViewView).setMotionEventSplittingEnabled(false);
    }
    int j = 300;
    int i = j;
    if (AdvancedProviderView.a(this.jdField_a_of_type_DovComQqImCaptureViewAdvancedProviderView) != null)
    {
      i = j;
      if (!AdvancedProviderView.a(this.jdField_a_of_type_DovComQqImCaptureViewAdvancedProviderView).hasEnded())
      {
        AdvancedProviderView.a(this.jdField_a_of_type_DovComQqImCaptureViewAdvancedProviderView).cancel();
        i = 0;
      }
    }
    this.b.setAlpha(1.0F);
    AdvancedProviderView.a(this.jdField_a_of_type_DovComQqImCaptureViewAdvancedProviderView, AdvancedProviderView.a(this.jdField_a_of_type_DovComQqImCaptureViewAdvancedProviderView, this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView, this.c, AdvancedProviderView.a(this.jdField_a_of_type_DovComQqImCaptureViewAdvancedProviderView), 0.0F));
    AdvancedProviderView.a(this.jdField_a_of_type_DovComQqImCaptureViewAdvancedProviderView).setDuration((AdvancedProviderView.a(this.jdField_a_of_type_DovComQqImCaptureViewAdvancedProviderView) * AdvancedProviderView.a(this.jdField_a_of_type_DovComQqImCaptureViewAdvancedProviderView)));
    AdvancedProviderView.a(this.jdField_a_of_type_DovComQqImCaptureViewAdvancedProviderView).setStartOffset(i);
    this.jdField_a_of_type_DovComQqImCaptureViewAdvancedProviderView.startAnimation(AdvancedProviderView.a(this.jdField_a_of_type_DovComQqImCaptureViewAdvancedProviderView));
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView instanceof ViewGroup))) {
      ((ViewGroup)this.jdField_a_of_type_AndroidViewView).setMotionEventSplittingEnabled(true);
    }
    this.jdField_a_of_type_DovComQqImCaptureViewAdvancedProviderView.b(paramSeekBar.getProgress());
    if ((AdvancedProviderView.a(this.jdField_a_of_type_DovComQqImCaptureViewAdvancedProviderView) != null) && (!AdvancedProviderView.a(this.jdField_a_of_type_DovComQqImCaptureViewAdvancedProviderView).hasEnded())) {
      AdvancedProviderView.a(this.jdField_a_of_type_DovComQqImCaptureViewAdvancedProviderView).cancel();
    }
    this.b.setAlpha(1.0F);
    AdvancedProviderView.a(this.jdField_a_of_type_DovComQqImCaptureViewAdvancedProviderView, AdvancedProviderView.a(this.jdField_a_of_type_DovComQqImCaptureViewAdvancedProviderView, this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView, this.c, AdvancedProviderView.a(this.jdField_a_of_type_DovComQqImCaptureViewAdvancedProviderView), 1.0F));
    AdvancedProviderView.a(this.jdField_a_of_type_DovComQqImCaptureViewAdvancedProviderView).setDuration(((1.0F - AdvancedProviderView.a(this.jdField_a_of_type_DovComQqImCaptureViewAdvancedProviderView)) * AdvancedProviderView.a(this.jdField_a_of_type_DovComQqImCaptureViewAdvancedProviderView)));
    this.jdField_a_of_type_DovComQqImCaptureViewAdvancedProviderView.startAnimation(AdvancedProviderView.a(this.jdField_a_of_type_DovComQqImCaptureViewAdvancedProviderView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blzt
 * JD-Core Version:    0.7.0.1
 */