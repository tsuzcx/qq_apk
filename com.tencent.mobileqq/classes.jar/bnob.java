import com.tencent.ttpic.openapi.watermark.LogicDataManager.OnGetQQNumberEventListener;
import dov.com.qq.im.ae.camera.ui.watermark.WaterMarkOnlineUserManager.1.1;
import java.util.Random;

public class bnob
  implements LogicDataManager.OnGetQQNumberEventListener
{
  bnob(bnoa parambnoa) {}
  
  public int onGetQQNumber()
  {
    long l = System.currentTimeMillis();
    if (l - bnoa.a(this.a) > 60000L)
    {
      bnoa.a(this.a, l);
      new Thread(new WaterMarkOnlineUserManager.1.1(this)).start();
      if (l - bnoa.b(this.a) <= 1000L) {
        break label168;
      }
      bnoa.b(this.a, l);
    }
    for (;;)
    {
      synchronized (bnoa.a(this.a))
      {
        if (bnoa.a(this.a) != 0) {
          bnoa.a(this.a, bnoa.a(this.a) - 1000 + new Random().nextInt(2000));
        }
        return bnoa.a(this.a);
        if (l - bnoa.a(this.a) >= 0L) {
          break;
        }
        bnoa.a(this.a, l);
      }
      label168:
      if (l - bnoa.b(this.a) < 0L) {
        bnoa.b(this.a, l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnob
 * JD-Core Version:    0.7.0.1
 */