import android.os.Bundle;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.shortvideo.filter.QQEmojiRedPackFilter;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;

class bkjh
  implements blno
{
  bkjh(bkjf parambkjf) {}
  
  public void a(blob paramblob) {}
  
  public void a(blob paramblob, boolean paramBoolean, int paramInt, Bundle paramBundle)
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
        paramblob = bkjf.a(this.a, paramblob);
        paramBundle.setWatermarkPath(paramblob);
        if (QLog.isColorLevel()) {
          QLog.i("QIMEmojiRedPacketCameraCapture", 2, "redPackFilter setWatermarkPath:" + paramblob);
        }
      }
      return;
    }
    catch (Throwable paramblob)
    {
      QLog.e("QIMEmojiRedPacketCameraCapture", 2, paramblob.getStackTrace());
    }
  }
  
  public void a(bloe parambloe, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(blol paramblol, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(bncq parambncq)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "onComboFilterDataUpdated");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkjh
 * JD-Core Version:    0.7.0.1
 */