import dov.com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import dov.com.tencent.mobileqq.richmedia.capture.data.TemplateGroupItem;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.Iterator;
import java.util.List;

public class anvf
  implements Runnable
{
  public anvf(CapturePtvTemplateManager paramCapturePtvTemplateManager) {}
  
  public void run()
  {
    Iterator localIterator = this.a.a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (TemplateGroupItem)localIterator.next();
      if (((TemplateGroupItem)localObject).a != null)
      {
        localObject = ((TemplateGroupItem)localObject).a.iterator();
        while (((Iterator)localObject).hasNext())
        {
          PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next();
          if (localPtvTemplateInfo != null) {
            localPtvTemplateInfo.usable = this.a.a(localPtvTemplateInfo);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anvf
 * JD-Core Version:    0.7.0.1
 */