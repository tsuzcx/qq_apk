import android.os.Bundle;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.shortvideo.filter.QQEmojiRedPackFilter;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;

class bkno
  implements blsa
{
  bkno(bknm parambknm) {}
  
  public void a(blsn paramblsn) {}
  
  public void a(blsn paramblsn, boolean paramBoolean, int paramInt, Bundle paramBundle)
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
        paramblsn = bknm.a(this.a, paramblsn);
        paramBundle.setWatermarkPath(paramblsn);
        if (QLog.isColorLevel()) {
          QLog.i("QIMEmojiRedPacketCameraCapture", 2, "redPackFilter setWatermarkPath:" + paramblsn);
        }
      }
      return;
    }
    catch (Throwable paramblsn)
    {
      QLog.e("QIMEmojiRedPacketCameraCapture", 2, paramblsn.getStackTrace());
    }
  }
  
  public void a(blsq paramblsq, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(blsx paramblsx, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(bnhc parambnhc)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "onComboFilterDataUpdated");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkno
 * JD-Core Version:    0.7.0.1
 */