import com.tencent.ttpic.openapi.watermark.LogicDataManager.OnGetQQNumberEventListener;
import dov.com.qq.im.ae.camera.ui.watermark.WaterMarkOnlineUserManager.1.1;
import java.util.Random;

public class bkuq
  implements LogicDataManager.OnGetQQNumberEventListener
{
  bkuq(bkup parambkup) {}
  
  public int onGetQQNumber()
  {
    long l = System.currentTimeMillis();
    if (l - bkup.a(this.a) > 60000L)
    {
      bkup.a(this.a, l);
      new Thread(new WaterMarkOnlineUserManager.1.1(this)).start();
      if (l - bkup.b(this.a) <= 1000L) {
        break label168;
      }
      bkup.b(this.a, l);
    }
    for (;;)
    {
      synchronized (bkup.a(this.a))
      {
        if (bkup.a(this.a) != 0) {
          bkup.a(this.a, bkup.a(this.a) - 1000 + new Random().nextInt(2000));
        }
        return bkup.a(this.a);
        if (l - bkup.a(this.a) >= 0L) {
          break;
        }
        bkup.a(this.a, l);
      }
      label168:
      if (l - bkup.b(this.a) < 0L) {
        bkup.b(this.a, l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkuq
 * JD-Core Version:    0.7.0.1
 */