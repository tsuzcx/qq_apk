import com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import com.tencent.mobileqq.videoplatform.SDKInitListener;

class bbqv
  implements SDKInitListener
{
  bbqv(bbqu parambbqu) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    bbqu.a(this.a);
    BaseShortVideoOprerator.a(this.a.a.a, bbqu.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbqv
 * JD-Core Version:    0.7.0.1
 */