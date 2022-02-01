import com.tencent.ttpic.openapi.watermark.LogicDataManager.OnGetQQNumberEventListener;
import dov.com.qq.im.ae.camera.ui.watermark.WaterMarkOnlineUserManager.1.1;
import java.util.Random;

public class bopm
  implements LogicDataManager.OnGetQQNumberEventListener
{
  bopm(bopl parambopl) {}
  
  public int onGetQQNumber()
  {
    long l = System.currentTimeMillis();
    if (l - bopl.a(this.a) > 60000L)
    {
      bopl.a(this.a, l);
      new Thread(new WaterMarkOnlineUserManager.1.1(this)).start();
      if (l - bopl.b(this.a) <= 1000L) {
        break label168;
      }
      bopl.b(this.a, l);
    }
    for (;;)
    {
      synchronized (bopl.a(this.a))
      {
        if (bopl.a(this.a) != 0) {
          bopl.a(this.a, bopl.a(this.a) - 1000 + new Random().nextInt(2000));
        }
        return bopl.a(this.a);
        if (l - bopl.a(this.a) >= 0L) {
          break;
        }
        bopl.a(this.a, l);
      }
      label168:
      if (l - bopl.b(this.a) < 0L) {
        bopl.b(this.a, l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bopm
 * JD-Core Version:    0.7.0.1
 */