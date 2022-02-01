import android.os.Bundle;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.shortvideo.filter.QQEmojiRedPackFilter;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;

class bncb
  implements bole
{
  bncb(bnbz parambnbz) {}
  
  public void a(bolr parambolr) {}
  
  public void a(bolr parambolr, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "onComboApply: success:" + paramBoolean + ",errorCode=" + paramInt);
    }
    if ((paramBoolean) && ((this.a.a instanceof EffectsCameraCaptureView))) {
      paramBundle = (EffectsCameraCaptureView)this.a.a;
    }
    try
    {
      paramBundle = (QQEmojiRedPackFilter)paramBundle.a().getQQFilterByType(185);
      if (paramBundle != null)
      {
        parambolr = bnbz.a(this.a, parambolr);
        paramBundle.setWatermarkPath(parambolr);
        if (QLog.isColorLevel()) {
          QLog.i("QIMEmojiRedPacketCameraCapture", 2, "redPackFilter setWatermarkPath:" + parambolr);
        }
      }
      return;
    }
    catch (Throwable parambolr)
    {
      QLog.e("QIMEmojiRedPacketCameraCapture", 2, parambolr.getStackTrace());
    }
  }
  
  public void a(bolu parambolu, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(bomb parambomb, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(bpyf parambpyf)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "onComboFilterDataUpdated");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bncb
 * JD-Core Version:    0.7.0.1
 */