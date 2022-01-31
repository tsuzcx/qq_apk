import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.runtime.task.ServiceCreateTask.2;
import com.tencent.smtt.sdk.JsVirtualMachine;
import com.tencent.smtt.sdk.QbSdk;

@behk(a="ServiceCreateTask")
public class bfeh
  extends bffh
{
  private long jdField_a_of_type_Long;
  bfbi jdField_a_of_type_Bfbi;
  private bfdf jdField_a_of_type_Bfdf;
  JsVirtualMachine jdField_a_of_type_ComTencentSmttSdkJsVirtualMachine;
  private long b;
  
  public bfeh(Context paramContext, beqm parambeqm)
  {
    super(paramContext, parambeqm);
  }
  
  private void g()
  {
    try
    {
      betc.b("ServiceCreateTask", "AppBrandWebviewService create start");
      a(new bfdk(this.jdField_a_of_type_Bfbi, null));
      return;
    }
    catch (Throwable localThrowable)
    {
      betc.d("ServiceCreateTask", "AppBrandWebviewService execute exception!", localThrowable);
      f();
    }
  }
  
  public long a()
  {
    return this.b - this.jdField_a_of_type_Long;
  }
  
  public bfdf a()
  {
    return this.jdField_a_of_type_Bfdf;
  }
  
  public void a()
  {
    Object localObject2 = null;
    if (this.jdField_a_of_type_Bfbi != null) {}
    for (Object localObject1 = this.jdField_a_of_type_Bfbi.a();; localObject1 = null)
    {
      bezi.a((MiniAppInfo)localObject1, 100, "0");
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      bfef localbfef = (bfef)a().getTask(bfef.class);
      localObject1 = localObject2;
      if (localbfef != null) {
        localObject1 = localbfef.a();
      }
      this.jdField_a_of_type_Bfbi = ((bfbi)localObject1);
      int i = QbSdk.getTbsVersion(a());
      int j = QbSdk.getTmpDirTbsVersion(a());
      if (((i <= 0) && (j <= 0)) || (a(a()))) {
        break;
      }
      try
      {
        betc.b("ServiceCreateTask", "AppBrandService create start");
        localObject1 = new bfdg(this.jdField_a_of_type_Bfbi, null);
        ((bfdg)localObject1).a(a(), new bfei(this, (bfdg)localObject1));
        return;
      }
      catch (Throwable localThrowable)
      {
        betc.d("ServiceCreateTask", "ServiceCreateTask JsCore execute exception!", localThrowable);
        return;
      }
    }
    new Handler(Looper.getMainLooper()).post(new ServiceCreateTask.2(this));
  }
  
  protected void a(bfdf parambfdf)
  {
    try
    {
      betc.b("ServiceCreateTask", "onServiceCreateSucc service:" + parambfdf);
      if ((this.jdField_a_of_type_Bfdf == null) && (parambfdf != null))
      {
        this.jdField_a_of_type_Bfdf = parambfdf;
        this.b = System.currentTimeMillis();
        c();
      }
      return;
    }
    finally {}
  }
  
  public boolean a(Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentSmttSdkJsVirtualMachine == null) {
      this.jdField_a_of_type_ComTencentSmttSdkJsVirtualMachine = new JsVirtualMachine(paramContext);
    }
    return this.jdField_a_of_type_ComTencentSmttSdkJsVirtualMachine.isFallback();
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_Bfbi != null) {}
    for (MiniAppInfo localMiniAppInfo = this.jdField_a_of_type_Bfbi.a();; localMiniAppInfo = null)
    {
      bezi.a(localMiniAppInfo, 101, "0");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfeh
 * JD-Core Version:    0.7.0.1
 */