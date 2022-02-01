import android.os.Bundle;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.shortvideo.filter.QQEmojiRedPackFilter;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;

class bodj
  implements bpmz
{
  bodj(bodh parambodh) {}
  
  public void a(bpnm parambpnm) {}
  
  public void a(bpnm parambpnm, boolean paramBoolean, int paramInt, Bundle paramBundle)
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
        parambpnm = bodh.a(this.a, parambpnm);
        paramBundle.setWatermarkPath(parambpnm);
        if (QLog.isColorLevel()) {
          QLog.i("QIMEmojiRedPacketCameraCapture", 2, "redPackFilter setWatermarkPath:" + parambpnm);
        }
      }
      return;
    }
    catch (Throwable parambpnm)
    {
      QLog.e("QIMEmojiRedPacketCameraCapture", 2, parambpnm.getStackTrace());
    }
  }
  
  public void a(bpnp parambpnp, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(bpnw parambpnw, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(braa parambraa)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "onComboFilterDataUpdated");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bodj
 * JD-Core Version:    0.7.0.1
 */