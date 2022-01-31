import android.os.Bundle;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.shortvideo.filter.QQEmojiRedPackFilter;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;

class bihl
  implements bjce
{
  bihl(bihj parambihj) {}
  
  public void a(bjcq parambjcq) {}
  
  public void a(bjcq parambjcq, boolean paramBoolean, int paramInt, Bundle paramBundle)
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
        parambjcq = bihj.a(this.a, parambjcq);
        paramBundle.setWatermarkPath(parambjcq);
        if (QLog.isColorLevel()) {
          QLog.i("QIMEmojiRedPacketCameraCapture", 2, "redPackFilter setWatermarkPath:" + parambjcq);
        }
      }
      return;
    }
    catch (Throwable parambjcq)
    {
      QLog.e("QIMEmojiRedPacketCameraCapture", 2, parambjcq.getStackTrace());
    }
  }
  
  public void a(bjct parambjct, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(bjda parambjda, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(bkrg parambkrg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "onComboFilterDataUpdated");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bihl
 * JD-Core Version:    0.7.0.1
 */