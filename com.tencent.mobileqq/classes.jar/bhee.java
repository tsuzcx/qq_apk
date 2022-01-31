import android.os.Bundle;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.shortvideo.filter.QQEmojiRedPackFilter;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;

class bhee
  implements bhgv
{
  bhee(bhec parambhec) {}
  
  public void a(bhhh parambhhh) {}
  
  public void a(bhhh parambhhh, boolean paramBoolean, int paramInt, Bundle paramBundle)
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
        parambhhh = bhec.a(this.a, parambhhh);
        paramBundle.setWatermarkPath(parambhhh);
        if (QLog.isColorLevel()) {
          QLog.i("QIMEmojiRedPacketCameraCapture", 2, "redPackFilter setWatermarkPath:" + parambhhh);
        }
      }
      return;
    }
    catch (Throwable parambhhh)
    {
      QLog.e("QIMEmojiRedPacketCameraCapture", 2, parambhhh.getStackTrace());
    }
  }
  
  public void a(bhhk parambhhk, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(bhhr parambhhr, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(bjad parambjad)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "onComboFilterDataUpdated");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhee
 * JD-Core Version:    0.7.0.1
 */