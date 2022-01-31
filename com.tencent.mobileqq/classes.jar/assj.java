import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import mqq.app.AppRuntime;

final class assj
  implements asrz
{
  public String a()
  {
    return asry.b;
  }
  
  public void a(int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      ((VasQuickUpdateManager)((AppRuntime)localObject).getManager(184)).downloadItem(5L, "font.hifont.android." + paramInt, "HiBoomDownloader");
      localObject = ((assg)((AppRuntime)localObject).getManager(219)).a(paramInt);
      ((assf)localObject).b = true;
      ((assf)localObject).c = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     assj
 * JD-Core Version:    0.7.0.1
 */