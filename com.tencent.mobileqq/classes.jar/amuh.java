import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.statistics.QIMReportController;
import com.tencent.mobileqq.statistics.reportitem.QIMReadWriteReportItem;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import dov.com.qq.im.capture.QIMCaptureController;
import dov.com.qq.im.capture.banner.QIMCaptureBannerManager;
import dov.com.qq.im.capture.view.PressScaleAnimDelegate;

public class amuh
  implements View.OnClickListener
{
  public amuh(QIMCaptureController paramQIMCaptureController, RedDotImageView paramRedDotImageView, boolean paramBoolean1, boolean paramBoolean2, QIMCaptureBannerManager paramQIMCaptureBannerManager, boolean paramBoolean3) {}
  
  public void onClick(View paramView)
  {
    paramView = new amui(this);
    if ((this.jdField_a_of_type_Boolean) && (this.b)) {
      this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerManager.c(true);
    }
    if ((this.jdField_a_of_type_Boolean) && (this.c)) {
      this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerManager.d(true);
    }
    PressScaleAnimDelegate.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView, 200L, paramView);
    QIMCaptureController.a(this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController, (RelativeLayout)QIMCaptureController.a(this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController).findViewById(2131365884));
    paramView = new QIMReadWriteReportItem();
    paramView.d = "0X8008D52";
    QIMReportController.b(null, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     amuh
 * JD-Core Version:    0.7.0.1
 */