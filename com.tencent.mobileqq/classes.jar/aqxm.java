import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import mqq.app.AppRuntime;

final class aqxm
  implements aqxc
{
  public String a()
  {
    return aqxb.b;
  }
  
  public void a(int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      ((VasQuickUpdateManager)((AppRuntime)localObject).getManager(184)).downloadItem(5L, "font.hifont.android." + paramInt, "HiBoomDownloader");
      localObject = ((aqxj)((AppRuntime)localObject).getManager(219)).a(paramInt);
      ((aqxi)localObject).b = true;
      ((aqxi)localObject).c = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqxm
 * JD-Core Version:    0.7.0.1
 */