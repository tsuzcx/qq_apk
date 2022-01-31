import dov.com.qq.im.capture.paster.CaptureComboPtvTemplate;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.IPtvTemplateDownloadListener;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;

public class anmu
  implements PtvTemplateManager.IPtvTemplateDownloadListener
{
  public anmu(CaptureComboPtvTemplate paramCaptureComboPtvTemplate) {}
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    synchronized (CaptureComboPtvTemplate.a(this.a))
    {
      if (paramPtvTemplateInfo.id.equals(CaptureComboPtvTemplate.a(this.a).id))
      {
        CaptureComboPtvTemplate.a(this.a).downloading = true;
        CaptureComboPtvTemplate.a(this.a, 1.0F * paramInt / 100.0F);
        CaptureComboPtvTemplate.a(this.a, 1);
      }
      return;
    }
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean)
  {
    synchronized (CaptureComboPtvTemplate.a(this.a))
    {
      if (paramPtvTemplateInfo.id.equals(CaptureComboPtvTemplate.a(this.a).id))
      {
        CaptureComboPtvTemplate.a(this.a).downloading = false;
        CaptureComboPtvTemplate.a(this.a).usable = paramBoolean;
      }
      if (paramBoolean)
      {
        if (CaptureComboPtvTemplate.a(this.a).id.equals(paramPtvTemplateInfo.id))
        {
          CaptureComboPtvTemplate.a(this.a, 3);
          CaptureComboPtvTemplate.a(this.a, 1.0F);
          this.a.b();
        }
        return;
      }
      this.a.a(1);
      CaptureComboPtvTemplate.a(this.a, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anmu
 * JD-Core Version:    0.7.0.1
 */