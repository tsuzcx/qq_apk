import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.runtime.task.ServiceCreateTask.2;
import com.tencent.smtt.sdk.JsVirtualMachine;
import com.tencent.smtt.sdk.QbSdk;

@begt(a="ServiceCreateTask")
public class bfdq
  extends bfeq
{
  private long jdField_a_of_type_Long;
  bfar jdField_a_of_type_Bfar;
  private bfco jdField_a_of_type_Bfco;
  JsVirtualMachine jdField_a_of_type_ComTencentSmttSdkJsVirtualMachine;
  private long b;
  
  public bfdq(Context paramContext, bepv parambepv)
  {
    super(paramContext, parambepv);
  }
  
  private void g()
  {
    try
    {
      besl.b("ServiceCreateTask", "AppBrandWebviewService create start");
      a(new bfct(this.jdField_a_of_type_Bfar, null));
      return;
    }
    catch (Throwable localThrowable)
    {
      besl.d("ServiceCreateTask", "AppBrandWebviewService execute exception!", localThrowable);
      f();
    }
  }
  
  public long a()
  {
    return this.b - this.jdField_a_of_type_Long;
  }
  
  public bfco a()
  {
    return this.jdField_a_of_type_Bfco;
  }
  
  public void a()
  {
    Object localObject2 = null;
    if (this.jdField_a_of_type_Bfar != null) {}
    for (Object localObject1 = this.jdField_a_of_type_Bfar.a();; localObject1 = null)
    {
      beyr.a((MiniAppInfo)localObject1, 100, "0");
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      bfdo localbfdo = (bfdo)a().getTask(bfdo.class);
      localObject1 = localObject2;
      if (localbfdo != null) {
        localObject1 = localbfdo.a();
      }
      this.jdField_a_of_type_Bfar = ((bfar)localObject1);
      int i = QbSdk.getTbsVersion(a());
      int j = QbSdk.getTmpDirTbsVersion(a());
      if (((i <= 0) && (j <= 0)) || (a(a()))) {
        break;
      }
      try
      {
        besl.b("ServiceCreateTask", "AppBrandService create start");
        localObject1 = new bfcp(this.jdField_a_of_type_Bfar, null);
        ((bfcp)localObject1).a(a(), new bfdr(this, (bfcp)localObject1));
        return;
      }
      catch (Throwable localThrowable)
      {
        besl.d("ServiceCreateTask", "ServiceCreateTask JsCore execute exception!", localThrowable);
        return;
      }
    }
    new Handler(Looper.getMainLooper()).post(new ServiceCreateTask.2(this));
  }
  
  protected void a(bfco parambfco)
  {
    try
    {
      besl.b("ServiceCreateTask", "onServiceCreateSucc service:" + parambfco);
      if ((this.jdField_a_of_type_Bfco == null) && (parambfco != null))
      {
        this.jdField_a_of_type_Bfco = parambfco;
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
    if (this.jdField_a_of_type_Bfar != null) {}
    for (MiniAppInfo localMiniAppInfo = this.jdField_a_of_type_Bfar.a();; localMiniAppInfo = null)
    {
      beyr.a(localMiniAppInfo, 101, "0");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfdq
 * JD-Core Version:    0.7.0.1
 */