import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr.DItemInfo;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;
import dov.com.qq.im.capture.view.QIMProviderContainerView;

class ansj
  implements View.OnTouchListener
{
  ansj(ansi paramansi) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit.b == null) {}
    do
    {
      return false;
      if (paramMotionEvent.getAction() == 1)
      {
        this.a.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit.b.setAlpha(255);
        this.a.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit.a.a(3, this.a.jdField_a_of_type_ComTencentMobileqqShortvideoUtilRecentDanceConfigMgr$DItemInfo.categoryID, this.a.jdField_a_of_type_ComTencentMobileqqShortvideoUtilRecentDanceConfigMgr$DItemInfo.itemID, true);
        CaptureReportUtil.k();
        return false;
      }
    } while (paramMotionEvent.getAction() != 0);
    this.a.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit.b.setAlpha(100);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ansj
 * JD-Core Version:    0.7.0.1
 */