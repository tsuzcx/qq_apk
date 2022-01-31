import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.videoshelf.model.edit.NodeItem;
import dov.com.qq.im.ae.play.AEVideoShelfEditFragment;
import dov.com.qq.im.ae.play.ScaleMoveImageViewer;

public class bixm
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public bixm(AEVideoShelfEditFragment paramAEVideoShelfEditFragment, ScaleMoveImageViewer paramScaleMoveImageViewer, NodeItem paramNodeItem) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.jdField_a_of_type_DovComQqImAePlayScaleMoveImageViewer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
    for (;;)
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_DovComQqImAePlayScaleMoveImageViewer.getLayoutParams();
      int i = (int)(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.maskRect.left * AEVideoShelfEditFragment.a(this.jdField_a_of_type_DovComQqImAePlayAEVideoShelfEditFragment));
      int j = (int)(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.maskRect.top * AEVideoShelfEditFragment.b(this.jdField_a_of_type_DovComQqImAePlayAEVideoShelfEditFragment));
      int k = (int)((1.0F - this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.maskRect.right) * AEVideoShelfEditFragment.a(this.jdField_a_of_type_DovComQqImAePlayAEVideoShelfEditFragment));
      int m = (int)((1.0F - this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.maskRect.bottom) * AEVideoShelfEditFragment.b(this.jdField_a_of_type_DovComQqImAePlayAEVideoShelfEditFragment));
      localMarginLayoutParams.leftMargin = i;
      localMarginLayoutParams.topMargin = j;
      localMarginLayoutParams.rightMargin = k;
      localMarginLayoutParams.bottomMargin = m;
      localMarginLayoutParams.width = (AEVideoShelfEditFragment.a(this.jdField_a_of_type_DovComQqImAePlayAEVideoShelfEditFragment) - k - i);
      localMarginLayoutParams.height = (AEVideoShelfEditFragment.b(this.jdField_a_of_type_DovComQqImAePlayAEVideoShelfEditFragment) - m - j);
      this.jdField_a_of_type_DovComQqImAePlayScaleMoveImageViewer.setLayoutParams(localMarginLayoutParams);
      AEVideoShelfEditFragment.a(this.jdField_a_of_type_DovComQqImAePlayAEVideoShelfEditFragment, this.jdField_a_of_type_DovComQqImAePlayScaleMoveImageViewer, AEVideoShelfEditFragment.a(this.jdField_a_of_type_DovComQqImAePlayAEVideoShelfEditFragment), AEVideoShelfEditFragment.b(this.jdField_a_of_type_DovComQqImAePlayAEVideoShelfEditFragment));
      if (QLog.isDebugVersion()) {
        QLog.d("AEVideoShelfEditFrag", 2, new Object[] { "initAllNodeViewer onGlobalLayout: wxh=", Integer.valueOf(localMarginLayoutParams.width), "x", Integer.valueOf(localMarginLayoutParams.height) });
      }
      return;
      this.jdField_a_of_type_DovComQqImAePlayScaleMoveImageViewer.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bixm
 * JD-Core Version:    0.7.0.1
 */