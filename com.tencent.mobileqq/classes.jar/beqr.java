import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.tencent.qqmini.sdk.launcher.shell.ProcessType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class beqr
{
  public List<bequ> a;
  public boolean a;
  
  private beqr(Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (a()) {
      b(paramContext);
    }
    for (;;)
    {
      c(paramContext);
      return;
      a(paramContext);
    }
  }
  
  private Class a(String paramString)
  {
    return beqb.a().a(paramString);
  }
  
  private void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
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
    bequ localbequ = new bequ();
    localbequ.jdField_a_of_type_JavaLangString = paramString;
    localbequ.jdField_a_of_type_JavaLangClass = paramClass1;
    localbequ.b = paramClass2;
    localbequ.jdField_a_of_type_ComTencentQqminiSdkLauncherShellProcessType = paramProcessType;
    this.jdField_a_of_type_JavaUtilList.add(localbequ);
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
    this.jdField_a_of_type_Boolean = ((Boolean)berh.a("com.tencent.qqmini.sdk.core.generated.CustomConfiguration").a("FLUTTER_ENABLED")).booleanValue();
    Iterator localIterator = ((List)berh.a("com.tencent.qqmini.sdk.core.generated.CustomConfiguration").a("MINI_PROCESS_LIST")).iterator();
    label49:
    Object localObject;
    bequ localbequ;
    String str;
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if ((localObject instanceof Map))
      {
        localObject = (Map)localObject;
        localbequ = new bequ();
        localbequ.jdField_a_of_type_JavaLangString = (paramContext + ":" + ((Map)localObject).get("name").toString());
        str = ((Map)localObject).get("processType").toString();
        if (!"MINI_GAME".equals(str)) {
          break label210;
        }
        localbequ.jdField_a_of_type_ComTencentQqminiSdkLauncherShellProcessType = ProcessType.MINI_GAME;
      }
    }
    for (;;)
    {
      localbequ.jdField_a_of_type_JavaLangClass = a(((Map)localObject).get("ui").toString());
      localbequ.b = a(((Map)localObject).get("receiver").toString());
      this.jdField_a_of_type_JavaUtilList.add(localbequ);
      break label49;
      break;
      label210:
      if ("MINI_APP".equals(str)) {
        localbequ.jdField_a_of_type_ComTencentQqminiSdkLauncherShellProcessType = ProcessType.MINI_APP;
      }
    }
  }
  
  private void c(Context paramContext)
  {
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
      while (i >= 0)
      {
        bequ localbequ = (bequ)this.jdField_a_of_type_JavaUtilList.get(i);
        Intent localIntent = new Intent();
        localIntent.setClassName(paramContext.getPackageName(), localbequ.jdField_a_of_type_JavaLangClass.getName());
        if (localPackageManager.resolveActivity(localIntent, 0) == null)
        {
          betc.d("Configuration", "Not registered manifest. uiClass:" + localbequ.jdField_a_of_type_JavaLangClass.getName());
          this.jdField_a_of_type_JavaUtilList.remove(i);
        }
        i -= 1;
      }
      return;
    }
    catch (Throwable paramContext)
    {
      betc.d("Configuration", "getDefaultConfiguration exception. ", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beqr
 * JD-Core Version:    0.7.0.1
 */