import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.2.1;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.2.2;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.2.3;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import mqq.os.MqqHandler;

public class bjbg
  implements bkzm
{
  bjbg(bjbe parambjbe) {}
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    ThreadManager.getUIHandler().post(new QIMPtvTemplateAdapter.2.3(this, paramPtvTemplateInfo, paramInt));
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean)
  {
    if (paramPtvTemplateInfo.usable)
    {
      bjld.a(paramPtvTemplateInfo).b();
      if ((!(bjbe.a(this.a) instanceof bjao)) || (((bjao)bjbe.a(this.a)).e())) {
        break label54;
      }
    }
    label54:
    do
    {
      return;
      bjld.a(paramPtvTemplateInfo).c();
      break;
      ThreadManager.getUIHandler().post(new QIMPtvTemplateAdapter.2.1(this, paramPtvTemplateInfo, paramBoolean));
    } while (paramBoolean);
    bkpm.a("", "0X80075BB", "", "", "", "");
    ThreadManager.getUIHandler().post(new QIMPtvTemplateAdapter.2.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjbg
 * JD-Core Version:    0.7.0.1
 */