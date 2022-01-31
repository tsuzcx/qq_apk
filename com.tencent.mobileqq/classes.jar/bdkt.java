import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class bdkt
  extends bdkv
{
  private Context a;
  public String a;
  
  public bdkt(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public Bundle a(String paramString1, String paramString2, Bundle paramBundle)
  {
    bdnw.b("minisdk-start_AppMainService", "requestAync cmd:" + paramString1 + " process:" + paramString2);
    try
    {
      if ("query_mini_process".equals(paramString1))
      {
        boolean bool = bdle.a().a().isMiniProcess(paramString2);
        paramString1 = new Bundle();
        paramString1.putBoolean("key_result", bool);
        return paramString1;
      }
    }
    catch (Throwable paramString1)
    {
      bdnw.b("minisdk-start_AppMainService", "requestAync exception!", paramString1);
    }
    return null;
  }
  
  public void a()
  {
    bdnw.c("minisdk-start_AppMainService", "AppMainServiceBinder call preloadMiniApp not from Main Processor . pName=" + this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(int paramInt, String paramString, MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    bdnw.b("minisdk-start_AppMainService", "handleAppLifecycle lifecycle:" + paramInt + " process:" + paramString + " miniAppInfo:" + paramMiniAppInfo);
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      bdle.a().a().onAppStart(paramString, paramMiniAppInfo, paramBundle);
      return;
    case 4: 
      bdle.a().a().onAppStop(paramString, paramMiniAppInfo, paramBundle);
      return;
    case 2: 
      bdle.a().a().onAppForeground(paramString, paramMiniAppInfo, paramBundle);
      return;
    }
    bdle.a().a().onAppBackground(paramString, paramMiniAppInfo, paramBundle);
  }
  
  public void a(MiniAppInfo paramMiniAppInfo)
  {
    bdnw.c("minisdk-start_AppMainService", "AppMainServiceBinder call preloadPackage not from Main Processor. pName=" + this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    bdnw.c("minisdk-start_AppMainService", "AppMainServiceBinder call startMiniApp not from Main Processor. pName=" + this.jdField_a_of_type_JavaLangString);
    bdle.a().a().startMiniApp(null, paramMiniAppInfo, paramBundle, paramResultReceiver);
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle, bdkz parambdkz)
  {
    bdkx.a().a(paramString1, paramBundle, parambdkz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdkt
 * JD-Core Version:    0.7.0.1
 */