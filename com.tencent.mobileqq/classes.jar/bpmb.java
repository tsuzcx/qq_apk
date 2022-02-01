import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.2.1;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.2.2;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.2.3;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import mqq.os.MqqHandler;

public class bpmb
  implements brhk
{
  bpmb(bplz parambplz) {}
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    ThreadManager.getUIHandler().post(new QIMPtvTemplateAdapter.2.3(this, paramPtvTemplateInfo, paramInt));
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean)
  {
    if (paramPtvTemplateInfo.usable)
    {
      bpvy.a(paramPtvTemplateInfo).b();
      if ((!(bplz.a(this.a) instanceof bplj)) || (((bplj)bplz.a(this.a)).e())) {
        break label54;
      }
    }
    label54:
    do
    {
      return;
      bpvy.a(paramPtvTemplateInfo).c();
      break;
      ThreadManager.getUIHandler().post(new QIMPtvTemplateAdapter.2.1(this, paramPtvTemplateInfo, paramBoolean));
    } while (paramBoolean);
    bqyg.a("", "0X80075BB", "", "", "", "");
    ThreadManager.getUIHandler().post(new QIMPtvTemplateAdapter.2.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpmb
 * JD-Core Version:    0.7.0.1
 */