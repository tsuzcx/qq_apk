import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.qphone.base.util.QLog;

public class blrj
  extends RemoteCommand
{
  private boolean a;
  
  public blrj(String paramString, boolean paramBoolean)
  {
    super(paramString);
    this.a = paramBoolean;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = PluginCommunicationHandler.getInstance();
    if (paramQQAppInterface != null) {
      paramQQAppInterface.register(new blrj("qqcomicemoticonipccmd", false));
    }
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface)) {
      if (QLog.isColorLevel()) {
        QLog.d("VipComicEmoticonUploadRemoteCmd", 2, "onRemoteInvoke cannot get QQAppInterface");
      }
    }
    do
    {
      do
      {
        return null;
        localObject = (QQAppInterface)localObject;
      } while (!"Remotecall_uploadEmoticon".equals(paramBundle.getString("qqcomicemoticonipccmd")));
      localObject = (blrh)((QQAppInterface)localObject).getManager(QQManagerFactory.QQCOMIC_UPLOAD_MANAGER);
    } while (localObject == null);
    ((blrh)localObject).a(paramBundle, paramOnInvokeFinishLinstener);
    return null;
  }
  
  public boolean isSynchronized()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blrj
 * JD-Core Version:    0.7.0.1
 */