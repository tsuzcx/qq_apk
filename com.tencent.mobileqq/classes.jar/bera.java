import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bera
{
  private Context jdField_a_of_type_AndroidContentContext;
  private beqr jdField_a_of_type_Beqr;
  private Class jdField_a_of_type_JavaLangClass;
  
  private static beqr a(Context paramContext)
  {
    beqr localbeqr = new beqt(paramContext).a();
    if (!a(localbeqr))
    {
      betc.d("minisdk-start_MiniSDKImpl", "Failed to create invalid configuration");
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localbeqr.a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (bequ)localIterator.next();
      localObject = new besx(((bequ)localObject).jdField_a_of_type_ComTencentQqminiSdkLauncherShellProcessType, ((bequ)localObject).jdField_a_of_type_JavaLangString, ((bequ)localObject).jdField_a_of_type_JavaLangClass, ((bequ)localObject).b);
      betc.b("minisdk-start_MiniSDKImpl", "createConfiguration. Add processor config: " + localObject);
      localArrayList.add(localObject);
    }
    a(paramContext, localArrayList);
    return localbeqr;
  }
  
  private static void a(Context paramContext, List<besx> paramList)
  {
    betc.b("minisdk-start_MiniSDKImpl", "registerProcessInfo");
    beqb.a().a().registerProcessInfo(paramList);
    beqb.a().a().init(paramContext);
  }
  
  private static boolean a(beqr parambeqr)
  {
    return (parambeqr != null) && (parambeqr.a != null) && (parambeqr.a.size() > 0);
  }
  
  public Class a()
  {
    if (this.jdField_a_of_type_JavaLangClass == null) {
      this.jdField_a_of_type_JavaLangClass = beqb.a().a("com.tencent.qqmini.sdk.launcher.MiniAppInfoLoadingFragment");
    }
    return this.jdField_a_of_type_JavaLangClass;
  }
  
  public void a(Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    betc.b("minisdk-start_MiniSDKImpl", "startMiniApp miniappInfo:" + paramMiniAppInfo);
    if (beqb.a().a())
    {
      beqb.a().a().startMiniApp(paramActivity, paramMiniAppInfo, paramBundle, paramResultReceiver);
      return;
    }
    beqb.a().a().startMiniApp(paramActivity, paramMiniAppInfo, paramBundle, paramResultReceiver);
  }
  
  public void a(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      try
      {
        betc.d("minisdk-start_MiniSDKImpl", "Failed to init MiniSDK. context is null");
        return;
      }
      finally {}
      if (this.jdField_a_of_type_AndroidContentContext == null)
      {
        betc.b("minisdk-start_MiniSDKImpl", "MiniSDK init context.");
        this.jdField_a_of_type_AndroidContentContext = paramContext;
        beqb.a().a(paramContext);
      }
      if (this.jdField_a_of_type_Beqr == null) {
        this.jdField_a_of_type_Beqr = a(paramContext);
      }
    }
  }
  
  public void a(Context paramContext, Bundle paramBundle)
  {
    betc.b("minisdk-start_MiniSDKImpl", "preloadMiniApp");
    if (beqb.a().a())
    {
      beqb.a().a().preloadMiniApp(paramBundle);
      return;
    }
    betc.d("minisdk-start_MiniSDKImpl", "preloadMiniApp should be called only in main process!!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bera
 * JD-Core Version:    0.7.0.1
 */