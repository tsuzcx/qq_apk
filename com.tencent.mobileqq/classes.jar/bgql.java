import android.content.Context;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.shell.ProcessType;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class bgql
{
  public List<bgqo> a;
  public boolean a;
  public boolean b = true;
  
  private bgql(Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (a())
    {
      b(paramContext);
      return;
    }
    QMLog.i("Configuration", "OK with CustomConfiguration not found. Use default configuration");
    a(paramContext);
  }
  
  private Class a(String paramString)
  {
    return AppLoaderFactory.g().findClass(paramString);
  }
  
  private void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    this.b = true;
    paramContext = paramContext.getPackageName();
    a(paramContext + ":mini1", a("com.tencent.qqmini.sdk.ui.MiniActivity1"), a("com.tencent.qqmini.sdk.receiver.AppBrandMainReceiver1"), ProcessType.MINI_GAME);
    a(paramContext + ":mini2", a("com.tencent.qqmini.sdk.ui.MiniActivity2"), a("com.tencent.qqmini.sdk.receiver.AppBrandMainReceiver2"), ProcessType.MINI_GAME);
    a(paramContext + ":mini3", a("com.tencent.qqmini.sdk.ui.MiniActivity3"), a("com.tencent.qqmini.sdk.receiver.AppBrandMainReceiver3"), ProcessType.MINI_GAME);
    a(paramContext + ":mini4", a("com.tencent.qqmini.sdk.ui.MiniActivity4"), a("com.tencent.qqmini.sdk.receiver.AppBrandMainReceiver4"), ProcessType.MINI_GAME);
    a(paramContext + ":mini5", a("com.tencent.qqmini.sdk.ui.MiniActivity5"), a("com.tencent.qqmini.sdk.receiver.AppBrandMainReceiver5"), ProcessType.MINI_GAME);
    a(paramContext + ":mini_internal", a("com.tencent.qqmini.sdk.ui.InternalMiniActivity"), a("com.tencent.qqmini.sdk.receiver.InternalAppBrandMainReceiver"), ProcessType.MINI_INTERNAL);
  }
  
  private void a(String paramString, Class paramClass1, Class paramClass2, ProcessType paramProcessType)
  {
    bgqo localbgqo = new bgqo();
    localbgqo.jdField_a_of_type_JavaLangString = paramString;
    localbgqo.jdField_a_of_type_JavaLangClass = paramClass1;
    localbgqo.b = paramClass2;
    localbgqo.jdField_a_of_type_ComTencentQqminiSdkLauncherShellProcessType = paramProcessType;
    this.jdField_a_of_type_JavaUtilList.add(localbgqo);
  }
  
  private boolean a()
  {
    return a("com.tencent.qqmini.sdk.core.generated.CustomConfiguration") != null;
  }
  
  private void b(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    paramContext = paramContext.getPackageName();
    this.jdField_a_of_type_Boolean = ((Boolean)bgqz.a("com.tencent.qqmini.sdk.core.generated.CustomConfiguration").a("FLUTTER_ENABLED")).booleanValue();
    this.b = ((Boolean)bgqz.a("com.tencent.qqmini.sdk.core.generated.CustomConfiguration").a("DEXLOADER_ENABLED")).booleanValue();
    Iterator localIterator = ((List)bgqz.a("com.tencent.qqmini.sdk.core.generated.CustomConfiguration").a("MINI_PROCESS_LIST")).iterator();
    label69:
    Object localObject;
    bgqo localbgqo;
    String str;
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if ((localObject instanceof Map))
      {
        localObject = (Map)localObject;
        localbgqo = new bgqo();
        localbgqo.jdField_a_of_type_JavaLangString = (paramContext + ":" + ((Map)localObject).get("name").toString());
        str = ((Map)localObject).get("processType").toString();
        if (!"MINI_GAME".equals(str)) {
          break label230;
        }
        localbgqo.jdField_a_of_type_ComTencentQqminiSdkLauncherShellProcessType = ProcessType.MINI_GAME;
      }
    }
    for (;;)
    {
      localbgqo.jdField_a_of_type_JavaLangClass = a(((Map)localObject).get("ui").toString());
      localbgqo.b = a(((Map)localObject).get("receiver").toString());
      this.jdField_a_of_type_JavaUtilList.add(localbgqo);
      break label69;
      break;
      label230:
      if ("MINI_APP".equals(str)) {
        localbgqo.jdField_a_of_type_ComTencentQqminiSdkLauncherShellProcessType = ProcessType.MINI_APP;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgql
 * JD-Core Version:    0.7.0.1
 */