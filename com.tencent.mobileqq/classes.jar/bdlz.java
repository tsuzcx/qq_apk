import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.ProcessType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bdlz
{
  private Context jdField_a_of_type_AndroidContentContext;
  private bdcq jdField_a_of_type_Bdcq;
  private boolean jdField_a_of_type_Boolean;
  private bdcq jdField_b_of_type_Bdcq;
  private boolean jdField_b_of_type_Boolean;
  
  /* Error */
  private void a(List<bdns> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 17	bdlz:jdField_a_of_type_Boolean	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 17	bdlz:jdField_a_of_type_Boolean	Z
    //   19: ldc 19
    //   21: ldc 21
    //   23: invokestatic 26	bdnw:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: invokestatic 31	bdle:a	()Lbdle;
    //   29: invokevirtual 34	bdle:a	()Lbdnr;
    //   32: aload_1
    //   33: invokeinterface 38 2 0
    //   38: invokestatic 31	bdle:a	()Lbdle;
    //   41: invokevirtual 34	bdle:a	()Lbdnr;
    //   44: aload_0
    //   45: getfield 40	bdlz:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   48: invokeinterface 44 2 0
    //   53: goto -42 -> 11
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	bdlz
    //   0	61	1	paramList	List<bdns>
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	56	finally
    //   14	53	56	finally
  }
  
  public bdcq a(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    bdle.a().a(paramContext);
    if (this.jdField_b_of_type_Bdcq == null)
    {
      this.jdField_b_of_type_Bdcq = new bdcr(paramContext).a(false).a(paramContext.getPackageName() + ":mini1", bdle.a().a("com.tencent.qqmini.sdk.ui.MiniActivity1"), bdle.a().a("com.tencent.qqmini.sdk.receiver.AppBrandMainReceiver1"), ProcessType.MINI_GAME).a(paramContext.getPackageName() + ":mini2", bdle.a().a("com.tencent.qqmini.sdk.ui.MiniActivity2"), bdle.a().a("com.tencent.qqmini.sdk.receiver.AppBrandMainReceiver2"), ProcessType.MINI_GAME).a(paramContext.getPackageName() + ":mini3", bdle.a().a("com.tencent.qqmini.sdk.ui.MiniActivity3"), bdle.a().a("com.tencent.qqmini.sdk.receiver.AppBrandMainReceiver3"), ProcessType.MINI_GAME).a(paramContext.getPackageName() + ":mini4", bdle.a().a("com.tencent.qqmini.sdk.ui.MiniActivity4"), bdle.a().a("com.tencent.qqmini.sdk.receiver.AppBrandMainReceiver4"), ProcessType.MINI_APP).a(paramContext.getPackageName() + ":mini5", bdle.a().a("com.tencent.qqmini.sdk.ui.MiniActivity5"), bdle.a().a("com.tencent.qqmini.sdk.receiver.AppBrandMainReceiver5"), ProcessType.MINI_APP).a();
      try
      {
        PackageManager localPackageManager = paramContext.getPackageManager();
        int i = this.jdField_b_of_type_Bdcq.a.size() - 1;
        while (i >= 0)
        {
          bdcs localbdcs = (bdcs)this.jdField_b_of_type_Bdcq.a.get(i);
          Intent localIntent = new Intent();
          localIntent.setClassName(paramContext.getPackageName(), localbdcs.jdField_a_of_type_JavaLangClass.getName());
          if (localPackageManager.resolveActivity(localIntent, 0) == null)
          {
            bdnw.d("minisdk-start_MiniSDKImpl", "DefaultConfiguration not regist manifest. uiClass:" + localbdcs.jdField_a_of_type_JavaLangClass.getName());
            this.jdField_b_of_type_Bdcq.a.remove(i);
          }
          i -= 1;
        }
        return this.jdField_b_of_type_Bdcq;
      }
      catch (Throwable paramContext)
      {
        bdnw.d("minisdk-start_MiniSDKImpl", "getDefaultConfiguration exception. ", paramContext);
      }
    }
  }
  
  public void a(Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    bdnw.b("minisdk-start_MiniSDKImpl", "startMiniApp miniappInfo:" + paramMiniAppInfo);
    if (bdle.a().a())
    {
      bdle.a().a().startMiniApp(paramActivity, paramMiniAppInfo, paramBundle, paramResultReceiver);
      return;
    }
    bdle.a().a().startMiniApp(paramActivity, paramMiniAppInfo, paramBundle, paramResultReceiver);
  }
  
  public void a(Context paramContext)
  {
    a(paramContext, a(paramContext));
  }
  
  public void a(Context paramContext, Bundle paramBundle)
  {
    bdnw.b("minisdk-start_MiniSDKImpl", "preloadMiniApp");
    if (bdle.a().a())
    {
      bdle.a().a().preloadMiniApp(paramBundle);
      return;
    }
    bdnw.d("minisdk-start_MiniSDKImpl", "preloadMiniApp should be called only in main process!!!");
  }
  
  public void a(Context paramContext, bdcq parambdcq)
  {
    try
    {
      if ((this.jdField_a_of_type_AndroidContentContext == null) && (paramContext != null))
      {
        bdnw.b("minisdk-start_MiniSDKImpl", "MiniSDK init context.");
        this.jdField_a_of_type_AndroidContentContext = paramContext;
        bdle.a().a(paramContext);
        bdnw.b("minisdk-start_MiniSDKImpl", "MiniSDK version " + bdle.a().a().getVersionName());
      }
      if ((parambdcq != null) && (!this.jdField_b_of_type_Boolean))
      {
        this.jdField_b_of_type_Boolean = true;
        if ((parambdcq == null) || (!a(parambdcq))) {
          break label216;
        }
        bdnw.b("minisdk-start_MiniSDKImpl", "MiniSDK init Configuration.");
        this.jdField_a_of_type_Bdcq = parambdcq;
        paramContext = new ArrayList();
        parambdcq = parambdcq.a.iterator();
        while (parambdcq.hasNext())
        {
          Object localObject = (bdcs)parambdcq.next();
          localObject = new bdns(((bdcs)localObject).jdField_a_of_type_ComTencentQqminiSdkLauncherShellProcessType, ((bdcs)localObject).jdField_a_of_type_JavaLangString, ((bdcs)localObject).jdField_a_of_type_JavaLangClass, ((bdcs)localObject).b);
          bdnw.b("minisdk-start_MiniSDKImpl", "add processor config: " + localObject);
          paramContext.add(localObject);
        }
        a(paramContext);
      }
    }
    finally {}
    for (;;)
    {
      return;
      label216:
      bdnw.b("minisdk-start_MiniSDKImpl", "MiniSDK init Configuration inValid");
    }
  }
  
  public boolean a(bdcq parambdcq)
  {
    return (parambdcq != null) && (parambdcq.a != null) && (parambdcq.a.size() > 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdlz
 * JD-Core Version:    0.7.0.1
 */