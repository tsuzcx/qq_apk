import com.tencent.ttpic.openapi.watermark.LogicDataManager.OnGetQQNumberEventListener;
import dov.com.qq.im.ae.camera.ui.watermark.WaterMarkOnlineUserManager.1.1;
import java.util.Random;

public class bkyx
  implements LogicDataManager.OnGetQQNumberEventListener
{
  bkyx(bkyw parambkyw) {}
  
  public int onGetQQNumber()
  {
    long l = System.currentTimeMillis();
    if (l - bkyw.a(this.a) > 60000L)
    {
      bkyw.a(this.a, l);
      new Thread(new WaterMarkOnlineUserManager.1.1(this)).start();
      if (l - bkyw.b(this.a) <= 1000L) {
        break label168;
      }
      bkyw.b(this.a, l);
    }
    for (;;)
    {
      synchronized (bkyw.a(this.a))
      {
        if (bkyw.a(this.a) != 0) {
          bkyw.a(this.a, bkyw.a(this.a) - 1000 + new Random().nextInt(2000));
        }
        return bkyw.a(this.a);
        if (l - bkyw.a(this.a) >= 0L) {
          break;
        }
        bkyw.a(this.a, l);
      }
      label168:
      if (l - bkyw.b(this.a) < 0L) {
        bkyw.b(this.a, l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkyx
 * JD-Core Version:    0.7.0.1
 */