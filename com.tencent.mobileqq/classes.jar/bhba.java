import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.videoshelf.model.edit.NodeItem;
import dov.com.qq.im.AECamera.qudong.AEVideoShelfEditFragment;
import dov.com.qq.im.AECamera.qudong.ScaleMoveImageViewer;

public class bhba
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public bhba(AEVideoShelfEditFragment paramAEVideoShelfEditFragment, ScaleMoveImageViewer paramScaleMoveImageViewer, NodeItem paramNodeItem) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.jdField_a_of_type_DovComQqImAECameraQudongScaleMoveImageViewer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
    for (;;)
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_DovComQqImAECameraQudongScaleMoveImageViewer.getLayoutParams();
      int i = (int)(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.maskRect.left * AEVideoShelfEditFragment.a(this.jdField_a_of_type_DovComQqImAECameraQudongAEVideoShelfEditFragment));
      int j = (int)(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.maskRect.top * AEVideoShelfEditFragment.b(this.jdField_a_of_type_DovComQqImAECameraQudongAEVideoShelfEditFragment));
      int k = (int)((1.0F - this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.maskRect.right) * AEVideoShelfEditFragment.a(this.jdField_a_of_type_DovComQqImAECameraQudongAEVideoShelfEditFragment));
      int m = (int)((1.0F - this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.maskRect.bottom) * AEVideoShelfEditFragment.b(this.jdField_a_of_type_DovComQqImAECameraQudongAEVideoShelfEditFragment));
      localMarginLayoutParams.leftMargin = i;
      localMarginLayoutParams.topMargin = j;
      localMarginLayoutParams.rightMargin = k;
      localMarginLayoutParams.bottomMargin = m;
      localMarginLayoutParams.width = (AEVideoShelfEditFragment.a(this.jdField_a_of_type_DovComQqImAECameraQudongAEVideoShelfEditFragment) - k - i);
      localMarginLayoutParams.height = (AEVideoShelfEditFragment.b(this.jdField_a_of_type_DovComQqImAECameraQudongAEVideoShelfEditFragment) - m - j);
      this.jdField_a_of_type_DovComQqImAECameraQudongScaleMoveImageViewer.setLayoutParams(localMarginLayoutParams);
      AEVideoShelfEditFragment.a(this.jdField_a_of_type_DovComQqImAECameraQudongAEVideoShelfEditFragment, this.jdField_a_of_type_DovComQqImAECameraQudongScaleMoveImageViewer, AEVideoShelfEditFragment.a(this.jdField_a_of_type_DovComQqImAECameraQudongAEVideoShelfEditFragment), AEVideoShelfEditFragment.b(this.jdField_a_of_type_DovComQqImAECameraQudongAEVideoShelfEditFragment));
      if (QLog.isDebugVersion()) {
        QLog.d("AEVideoShelfEditFrag", 2, new Object[] { "initAllNodeViewer onGlobalLayout: wxh=", Integer.valueOf(localMarginLayoutParams.width), "x", Integer.valueOf(localMarginLayoutParams.height) });
      }
      return;
      this.jdField_a_of_type_DovComQqImAECameraQudongScaleMoveImageViewer.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhba
 * JD-Core Version:    0.7.0.1
 */