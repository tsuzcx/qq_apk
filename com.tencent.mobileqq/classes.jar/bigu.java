import android.os.Bundle;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.shortvideo.filter.QQEmojiRedPackFilter;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;

class bigu
  implements bjbn
{
  bigu(bigs parambigs) {}
  
  public void a(bjbz parambjbz) {}
  
  public void a(bjbz parambjbz, boolean paramBoolean, int paramInt, Bundle paramBundle)
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
        parambjbz = bigs.a(this.a, parambjbz);
        paramBundle.setWatermarkPath(parambjbz);
        if (QLog.isColorLevel()) {
          QLog.i("QIMEmojiRedPacketCameraCapture", 2, "redPackFilter setWatermarkPath:" + parambjbz);
        }
      }
      return;
    }
    catch (Throwable parambjbz)
    {
      QLog.e("QIMEmojiRedPacketCameraCapture", 2, parambjbz.getStackTrace());
    }
  }
  
  public void a(bjcc parambjcc, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(bjcj parambjcj, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(bkqp parambkqp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "onComboFilterDataUpdated");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bigu
 * JD-Core Version:    0.7.0.1
 */