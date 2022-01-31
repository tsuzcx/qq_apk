import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import mqq.app.AppRuntime;

final class aqxk
  implements aqxa
{
  public String a()
  {
    return aqwz.b;
  }
  
  public void a(int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      ((VasQuickUpdateManager)((AppRuntime)localObject).getManager(184)).downloadItem(5L, "font.hifont.android." + paramInt, "HiBoomDownloader");
      localObject = ((aqxh)((AppRuntime)localObject).getManager(219)).a(paramInt);
      ((aqxg)localObject).b = true;
      ((aqxg)localObject).c = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqxk
 * JD-Core Version:    0.7.0.1
 */