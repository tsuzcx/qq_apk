import com.tencent.ttpic.openapi.watermark.LogicDataManager.OnGetQQNumberEventListener;
import dov.com.qq.im.ae.camera.ui.watermark.WaterMarkOnlineUserManager.1.1;
import java.util.Random;

public class bipw
  implements LogicDataManager.OnGetQQNumberEventListener
{
  bipw(bipv parambipv) {}
  
  public int onGetQQNumber()
  {
    long l = System.currentTimeMillis();
    if (l - bipv.a(this.a) > 60000L)
    {
      bipv.a(this.a, l);
      new Thread(new WaterMarkOnlineUserManager.1.1(this)).start();
      if (l - bipv.b(this.a) <= 1000L) {
        break label168;
      }
      bipv.b(this.a, l);
    }
    for (;;)
    {
      synchronized (bipv.a(this.a))
      {
        if (bipv.a(this.a) != 0) {
          bipv.a(this.a, bipv.a(this.a) - 1000 + new Random().nextInt(2000));
        }
        return bipv.a(this.a);
        if (l - bipv.a(this.a) >= 0L) {
          break;
        }
        bipv.a(this.a, l);
      }
      label168:
      if (l - bipv.b(this.a) < 0L) {
        bipv.b(this.a, l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bipw
 * JD-Core Version:    0.7.0.1
 */