import com.tencent.TMG.sdk.AVAudioCtrl.EnableMicCompleteCallback;
import com.tencent.qphone.base.util.QLog;

class bioy
  extends AVAudioCtrl.EnableMicCompleteCallback
{
  bioy(biov parambiov) {}
  
  public void onComplete(boolean paramBoolean, int paramInt)
  {
    QLog.d("AVEngineWalper", 1, "StartOpenMic.OnComplete. bOpen = " + paramBoolean + ", result = " + paramInt);
    if (this.a.a != null) {
      this.a.a.a(paramBoolean, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bioy
 * JD-Core Version:    0.7.0.1
 */