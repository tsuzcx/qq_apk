import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.2.1;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.2.2;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.2.3;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import mqq.os.MqqHandler;

public class blmq
  implements bnkw
{
  blmq(blmo paramblmo) {}
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    ThreadManager.getUIHandler().post(new QIMPtvTemplateAdapter.2.3(this, paramPtvTemplateInfo, paramInt));
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean)
  {
    if (paramPtvTemplateInfo.usable)
    {
      blwn.a(paramPtvTemplateInfo).b();
      if ((!(blmo.a(this.a) instanceof blly)) || (((blly)blmo.a(this.a)).e())) {
        break label54;
      }
    }
    label54:
    do
    {
      return;
      blwn.a(paramPtvTemplateInfo).c();
      break;
      ThreadManager.getUIHandler().post(new QIMPtvTemplateAdapter.2.1(this, paramPtvTemplateInfo, paramBoolean));
    } while (paramBoolean);
    bnaw.a("", "0X80075BB", "", "", "", "");
    ThreadManager.getUIHandler().post(new QIMPtvTemplateAdapter.2.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blmq
 * JD-Core Version:    0.7.0.1
 */