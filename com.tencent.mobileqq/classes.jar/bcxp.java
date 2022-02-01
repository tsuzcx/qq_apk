import com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import com.tencent.mobileqq.videoplatform.SDKInitListener;

class bcxp
  implements SDKInitListener
{
  bcxp(bcxo parambcxo) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    bcxo.a(this.a);
    BaseShortVideoOprerator.a(this.a.a.a, bcxo.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcxp
 * JD-Core Version:    0.7.0.1
 */