import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.richmedia.capture.adapter.PtvTemplateAdapter.2.1;
import com.tencent.mobileqq.richmedia.capture.adapter.PtvTemplateAdapter.2.2;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;

public class axnw
  implements azcw
{
  axnw(axnu paramaxnu) {}
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    if (this.a.a != null) {
      this.a.a.runOnUiThread(new PtvTemplateAdapter.2.2(this, paramPtvTemplateInfo, paramInt));
    }
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean)
  {
    if (this.a.a != null) {
      this.a.a.runOnUiThread(new PtvTemplateAdapter.2.1(this, paramPtvTemplateInfo, paramBoolean));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axnw
 * JD-Core Version:    0.7.0.1
 */