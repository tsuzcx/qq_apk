import com.tencent.ttpic.openapi.watermark.LogicDataManager.OnGetQQNumberEventListener;
import dov.com.qq.im.ae.camera.ui.watermark.WaterMarkOnlineUserManager.1.1;
import java.util.Random;

public class bnhw
  implements LogicDataManager.OnGetQQNumberEventListener
{
  bnhw(bnhv parambnhv) {}
  
  public int onGetQQNumber()
  {
    long l = System.currentTimeMillis();
    if (l - bnhv.a(this.a) > 60000L)
    {
      bnhv.a(this.a, l);
      new Thread(new WaterMarkOnlineUserManager.1.1(this)).start();
      if (l - bnhv.b(this.a) <= 1000L) {
        break label168;
      }
      bnhv.b(this.a, l);
    }
    for (;;)
    {
      synchronized (bnhv.a(this.a))
      {
        if (bnhv.a(this.a) != 0) {
          bnhv.a(this.a, bnhv.a(this.a) - 1000 + new Random().nextInt(2000));
        }
        return bnhv.a(this.a);
        if (l - bnhv.a(this.a) >= 0L) {
          break;
        }
        bnhv.a(this.a, l);
      }
      label168:
      if (l - bnhv.b(this.a) < 0L) {
        bnhv.b(this.a, l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnhw
 * JD-Core Version:    0.7.0.1
 */