import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class beox
  extends beoz
{
  private Context a;
  public String a;
  
  public beox(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public Bundle a(String paramString1, String paramString2, Bundle paramBundle)
  {
    besl.b("minisdk-start_AppMainService", "requestAync cmd:" + paramString1 + " process:" + paramString2);
    try
    {
      if ("query_mini_process".equals(paramString1))
      {
        boolean bool = bepk.a().a().isMiniProcess(paramString2);
        paramString1 = new Bundle();
        paramString1.putBoolean("key_result", bool);
        return paramString1;
      }
    }
    catch (Throwable paramString1)
    {
      besl.b("minisdk-start_AppMainService", "requestAync exception!", paramString1);
    }
    return null;
  }
  
  public void a()
  {
    besl.c("minisdk-start_AppMainService", "AppMainServiceBinder call preloadMiniApp not from Main Processor . pName=" + this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(int paramInt, String paramString, MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    besl.b("minisdk-start_AppMainService", "handleAppLifecycle lifecycle:" + paramInt + " process:" + paramString + " miniAppInfo:" + paramMiniAppInfo);
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      bepk.a().a().onAppStart(paramString, paramMiniAppInfo, paramBundle);
      return;
    case 4: 
      bepk.a().a().onAppStop(paramString, paramMiniAppInfo, paramBundle);
      return;
    case 2: 
      bepk.a().a().onAppForeground(paramString, paramMiniAppInfo, paramBundle);
      return;
    }
    bepk.a().a().onAppBackground(paramString, paramMiniAppInfo, paramBundle);
  }
  
  public void a(MiniAppInfo paramMiniAppInfo)
  {
    besl.c("minisdk-start_AppMainService", "AppMainServiceBinder call preloadPackage not from Main Processor. pName=" + this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    besl.c("minisdk-start_AppMainService", "AppMainServiceBinder call startMiniApp not from Main Processor. pName=" + this.jdField_a_of_type_JavaLangString);
    bepk.a().a().startMiniApp(null, paramMiniAppInfo, paramBundle, paramResultReceiver);
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle, bepd parambepd)
  {
    bepb.a().a(paramString1, paramBundle, parambepd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beox
 * JD-Core Version:    0.7.0.1
 */