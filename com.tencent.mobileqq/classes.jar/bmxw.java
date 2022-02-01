import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.ttpic.openapi.watermark.LogicDataManager.IOnClickWatermarkListener;
import dov.com.qq.im.ae.AEPituCameraUnit.9.1;
import mqq.os.MqqHandler;

public class bmxw
  implements LogicDataManager.IOnClickWatermarkListener
{
  bmxw(bmxa parambmxa) {}
  
  public void onClickWatermark()
  {
    bnrh.a(this.a.a, "onClickWatermark");
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.9.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmxw
 * JD-Core Version:    0.7.0.1
 */