import com.tencent.ttpic.openapi.watermark.LogicDataManager.OnGetQQNumberEventListener;
import dov.com.qq.im.ae.camera.ui.watermark.WaterMarkOnlineUserManager.1.1;
import java.util.Random;

public class bipf
  implements LogicDataManager.OnGetQQNumberEventListener
{
  bipf(bipe parambipe) {}
  
  public int onGetQQNumber()
  {
    long l = System.currentTimeMillis();
    if (l - bipe.a(this.a) > 60000L)
    {
      bipe.a(this.a, l);
      new Thread(new WaterMarkOnlineUserManager.1.1(this)).start();
      if (l - bipe.b(this.a) <= 1000L) {
        break label168;
      }
      bipe.b(this.a, l);
    }
    for (;;)
    {
      synchronized (bipe.a(this.a))
      {
        if (bipe.a(this.a) != 0) {
          bipe.a(this.a, bipe.a(this.a) - 1000 + new Random().nextInt(2000));
        }
        return bipe.a(this.a);
        if (l - bipe.a(this.a) >= 0L) {
          break;
        }
        bipe.a(this.a, l);
      }
      label168:
      if (l - bipe.b(this.a) < 0L) {
        bipe.b(this.a, l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bipf
 * JD-Core Version:    0.7.0.1
 */