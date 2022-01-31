import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;
import cooperation.qzone.share.QZoneShareActivity;

public class anhg
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public anhg(QZoneShareActivity paramQZoneShareActivity, RelativeLayout paramRelativeLayout) {}
  
  public void onGlobalLayout()
  {
    int i = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
    if (QZoneShareActivity.a(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity) - i > 150) {
      this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity.c.setVisibility(0);
    }
    for (;;)
    {
      QZoneShareActivity.a(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity, i);
      return;
      if ((i - QZoneShareActivity.a(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity) > 150) && (!this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity.d)) {
        this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity.c.setVisibility(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anhg
 * JD-Core Version:    0.7.0.1
 */