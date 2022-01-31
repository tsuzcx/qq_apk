import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter;
import dov.com.qq.im.capture.view.QIMCommonLoadingProgress;
import dov.com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.IPtvTemplateDownloadListener;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import mqq.os.MqqHandler;

public class amut
  implements PtvTemplateManager.IPtvTemplateDownloadListener
{
  public amut(QIMPtvTemplateAdapter paramQIMPtvTemplateAdapter) {}
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    ThreadManager.getUIHandler().post(new amuw(this, paramPtvTemplateInfo, paramInt));
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean)
  {
    if (paramPtvTemplateInfo.usable) {
      QIMCommonLoadingProgress.a(paramPtvTemplateInfo).b();
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new amuu(this, paramPtvTemplateInfo, paramBoolean));
      if (!paramBoolean)
      {
        FlowCameraMqqAction.a("", "0X80075BB", "", "", "", "");
        ThreadManager.getUIHandler().post(new amuv(this));
      }
      return;
      QIMCommonLoadingProgress.a(paramPtvTemplateInfo).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     amut
 * JD-Core Version:    0.7.0.1
 */