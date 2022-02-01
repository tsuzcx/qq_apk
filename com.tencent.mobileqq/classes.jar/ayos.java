import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.now.NowQQLiveFragment;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import mqq.app.AppRuntime;

public class ayos
{
  private static final String a = BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/testEnv/";
  
  public static int a()
  {
    Object localObject = a();
    if (!(localObject instanceof QQAppInterface)) {
      return 0;
    }
    localObject = (QQAppInterface)localObject;
    if ((((QQAppInterface)localObject).getMessageFacade() == null) || (((QQAppInterface)localObject).getMessageFacade().getConversationFacade() == null)) {
      return 0;
    }
    return ((QQAppInterface)localObject).getMessageFacade().getConversationFacade().a(ayoq.a, 1008);
  }
  
  public static AppRuntime a()
  {
    AppRuntime localAppRuntime = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      localAppRuntime = localBaseApplicationImpl.getRuntime();
    }
    return localAppRuntime;
  }
  
  public static boolean a()
  {
    Object localObject = a();
    if (!(localObject instanceof QQAppInterface)) {
      return false;
    }
    localObject = (QQAppInterface)localObject;
    if ((((QQAppInterface)localObject).getMessageFacade() == null) || (((QQAppInterface)localObject).getMessageFacade().getConversationFacade() == null)) {
      return false;
    }
    ((QQAppInterface)localObject).getMessageFacade().setReaded(ayoq.a, 1008, true, true);
    alik.b((QQAppInterface)localObject, ayoq.a, 1008);
    uot.a().a((QQAppInterface)localObject, ayoq.a);
    return true;
  }
  
  public static final boolean a(Context paramContext, String paramString, int paramInt)
  {
    NowQQLiveFragment.a(paramContext, paramString, paramInt);
    return true;
  }
  
  public static boolean b()
  {
    return new File(a, "testserver").exists();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayos
 * JD-Core Version:    0.7.0.1
 */