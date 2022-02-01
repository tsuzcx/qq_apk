import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ptv.BaseButton;
import dov.com.qq.im.ptv.LightWeightCaptureButtonLayout;
import dov.com.qq.im.ptv.LightWeightProgress;

class bpzo
  implements View.OnClickListener
{
  bpzo(bpzm parambpzm) {}
  
  public void onClick(View paramView)
  {
    this.a.a.jdField_a_of_type_DovComQqImPtvLightWeightProgress.setStatus(true);
    this.a.a.jdField_a_of_type_DovComQqImPtvBaseButton.setScaleX(1.0F);
    this.a.a.jdField_a_of_type_DovComQqImPtvBaseButton.setScaleY(1.0F);
    this.a.a.j();
    awlk.b();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpzo
 * JD-Core Version:    0.7.0.1
 */