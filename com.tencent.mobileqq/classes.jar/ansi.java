import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.shortvideo.dancemachine.DisplayUtils;
import com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr.DItemInfo;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import mqq.os.MqqHandler;

public class ansi
  implements Runnable
{
  public ansi(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit, RecentDanceConfigMgr.DItemInfo paramDItemInfo) {}
  
  public void run()
  {
    this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit.b = new ImageView(QIMEffectCameraCaptureUnit.a(this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit).getContext());
    this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit.b.setImageResource(2130845629);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(11, -1);
    this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit.b.setTranslationY(-500.0F);
    localLayoutParams.rightMargin = DisplayUtils.a(-154.0F);
    this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit.b.setClickable(true);
    this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit.b.setOnTouchListener(new ansj(this));
    if (QIMEffectCameraCaptureUnit.a(this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit) == null) {
      QIMEffectCameraCaptureUnit.a(this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit, new ansk(this));
    }
    this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit.a.a(QIMEffectCameraCaptureUnit.a(this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit));
    QIMEffectCameraCaptureUnit.a(this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit).addView(this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit.b, localLayoutParams);
    int i = DisplayUtils.a(98.0F);
    QIMEffectCameraCaptureUnit.a(this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit, ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit.b, "translationX", new float[] { i, 0.0F }));
    QIMEffectCameraCaptureUnit.a(this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit).setDuration(300L);
    QIMEffectCameraCaptureUnit.b(this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit, ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit.b, "translationX", new float[] { 0.0F, i }));
    QIMEffectCameraCaptureUnit.b(this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit).setDuration(500L);
    QIMEffectCameraCaptureUnit.a(this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit, true);
    CaptureReportUtil.j();
    ThreadManager.getUIHandler().postDelayed(new ansl(this), 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ansi
 * JD-Core Version:    0.7.0.1
 */