import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class beqj
{
  private Context jdField_a_of_type_AndroidContentContext;
  private beqa jdField_a_of_type_Beqa;
  private Class jdField_a_of_type_JavaLangClass;
  
  private static beqa a(Context paramContext)
  {
    beqa localbeqa = new beqc(paramContext).a();
    if (!a(localbeqa))
    {
      besl.d("minisdk-start_MiniSDKImpl", "Failed to create invalid configuration");
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localbeqa.a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (beqd)localIterator.next();
      localObject = new besg(((beqd)localObject).jdField_a_of_type_ComTencentQqminiSdkLauncherShellProcessType, ((beqd)localObject).jdField_a_of_type_JavaLangString, ((beqd)localObject).jdField_a_of_type_JavaLangClass, ((beqd)localObject).b);
      besl.b("minisdk-start_MiniSDKImpl", "createConfiguration. Add processor config: " + localObject);
      localArrayList.add(localObject);
    }
    a(paramContext, localArrayList);
    return localbeqa;
  }
  
  private static void a(Context paramContext, List<besg> paramList)
  {
    besl.b("minisdk-start_MiniSDKImpl", "registerProcessInfo");
    bepk.a().a().registerProcessInfo(paramList);
    bepk.a().a().init(paramContext);
  }
  
  private static boolean a(beqa parambeqa)
  {
    return (parambeqa != null) && (parambeqa.a != null) && (parambeqa.a.size() > 0);
  }
  
  public Class a()
  {
    if (this.jdField_a_of_type_JavaLangClass == null) {
      this.jdField_a_of_type_JavaLangClass = bepk.a().a("com.tencent.qqmini.sdk.launcher.MiniAppInfoLoadingFragment");
    }
    return this.jdField_a_of_type_JavaLangClass;
  }
  
  public void a(Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    besl.b("minisdk-start_MiniSDKImpl", "startMiniApp miniappInfo:" + paramMiniAppInfo);
    if (bepk.a().a())
    {
      bepk.a().a().startMiniApp(paramActivity, paramMiniAppInfo, paramBundle, paramResultReceiver);
      return;
    }
    bepk.a().a().startMiniApp(paramActivity, paramMiniAppInfo, paramBundle, paramResultReceiver);
  }
  
  public void a(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      try
      {
        besl.d("minisdk-start_MiniSDKImpl", "Failed to init MiniSDK. context is null");
        return;
      }
      finally {}
      if (this.jdField_a_of_type_AndroidContentContext == null)
      {
        besl.b("minisdk-start_MiniSDKImpl", "MiniSDK init context.");
        this.jdField_a_of_type_AndroidContentContext = paramContext;
        bepk.a().a(paramContext);
      }
      if (this.jdField_a_of_type_Beqa == null) {
        this.jdField_a_of_type_Beqa = a(paramContext);
      }
    }
  }
  
  public void a(Context paramContext, Bundle paramBundle)
  {
    besl.b("minisdk-start_MiniSDKImpl", "preloadMiniApp");
    if (bepk.a().a())
    {
      bepk.a().a().preloadMiniApp(paramBundle);
      return;
    }
    besl.d("minisdk-start_MiniSDKImpl", "preloadMiniApp should be called only in main process!!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beqj
 * JD-Core Version:    0.7.0.1
 */