import com.tencent.ttpic.openapi.watermark.LogicDataManager.OnGetQQNumberEventListener;
import dov.com.qq.im.ae.camera.ui.watermark.WaterMarkOnlineUserManager.1.1;
import java.util.Random;

public class bltt
  implements LogicDataManager.OnGetQQNumberEventListener
{
  bltt(blts paramblts) {}
  
  public int onGetQQNumber()
  {
    long l = System.currentTimeMillis();
    if (l - blts.a(this.a) > 60000L)
    {
      blts.a(this.a, l);
      new Thread(new WaterMarkOnlineUserManager.1.1(this)).start();
      if (l - blts.b(this.a) <= 1000L) {
        break label168;
      }
      blts.b(this.a, l);
    }
    for (;;)
    {
      synchronized (blts.a(this.a))
      {
        if (blts.a(this.a) != 0) {
          blts.a(this.a, blts.a(this.a) - 1000 + new Random().nextInt(2000));
        }
        return blts.a(this.a);
        if (l - blts.a(this.a) >= 0L) {
          break;
        }
        blts.a(this.a, l);
      }
      label168:
      if (l - blts.b(this.a) < 0L) {
        blts.b(this.a, l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bltt
 * JD-Core Version:    0.7.0.1
 */