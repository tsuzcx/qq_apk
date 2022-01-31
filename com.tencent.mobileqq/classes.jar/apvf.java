import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonPanelFavHelper.5.1;
import mqq.os.MqqHandler;

public class apvf
  extends alsc
{
  apvf(apvd paramapvd) {}
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      this.a.j();
    }
    if ((paramObject != null) && ((paramObject instanceof Integer))) {
      ThreadManager.getUIHandler().post(new EmoticonPanelFavHelper.5.1(this, paramObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apvf
 * JD-Core Version:    0.7.0.1
 */