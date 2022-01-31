import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.task.ServiceCreateTask.2;
import com.tencent.smtt.sdk.JsVirtualMachine;
import com.tencent.smtt.sdk.QbSdk;

@bglp(a="ServiceCreateTask")
public class bhij
  extends bhlt
{
  private long jdField_a_of_type_Long;
  bhey jdField_a_of_type_Bhey;
  private bhhc jdField_a_of_type_Bhhc;
  JsVirtualMachine jdField_a_of_type_ComTencentSmttSdkJsVirtualMachine;
  private long b;
  
  public bhij(Context paramContext, bgun parambgun)
  {
    super(paramContext, parambgun);
  }
  
  private void d()
  {
    try
    {
      QMLog.i("ServiceCreateTask", "AppBrandWebviewService create start");
      a(new bhhh(this.jdField_a_of_type_Bhey, null));
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("ServiceCreateTask", "AppBrandWebviewService execute exception!", localThrowable);
      e();
    }
  }
  
  public long a()
  {
    return this.b - this.jdField_a_of_type_Long;
  }
  
  public bhhc a()
  {
    return this.jdField_a_of_type_Bhhc;
  }
  
  public void a()
  {
    Object localObject2 = null;
    if (this.jdField_a_of_type_Bhey != null) {}
    for (Object localObject1 = this.jdField_a_of_type_Bhey.a();; localObject1 = null)
    {
      bhck.a((MiniAppInfo)localObject1, 100, "0");
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      bhih localbhih = (bhih)a().getTask(bhih.class);
      localObject1 = localObject2;
      if (localbhih != null) {
        localObject1 = localbhih.a();
      }
      this.jdField_a_of_type_Bhey = ((bhey)localObject1);
      int i = QbSdk.getTbsVersion(a());
      int j = QbSdk.getTmpDirTbsVersion(a());
      if (((i <= 0) && (j <= 0)) || (a(a()))) {
        break;
      }
      try
      {
        QMLog.i("ServiceCreateTask", "AppBrandService create start");
        localObject1 = new bhhd(this.jdField_a_of_type_Bhey, null);
        ((bhhd)localObject1).a(a(), new bhik(this, (bhhd)localObject1));
        return;
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("ServiceCreateTask", "ServiceCreateTask JsCore execute exception!", localThrowable);
        return;
      }
    }
    new Handler(Looper.getMainLooper()).post(new ServiceCreateTask.2(this));
  }
  
  protected void a(bhhc parambhhc)
  {
    try
    {
      QMLog.i("ServiceCreateTask", "onServiceCreateSucc service:" + parambhhc);
      if ((this.jdField_a_of_type_Bhhc == null) && (parambhhc != null))
      {
        this.jdField_a_of_type_Bhhc = parambhhc;
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
    if (this.jdField_a_of_type_Bhey != null) {}
    for (MiniAppInfo localMiniAppInfo = this.jdField_a_of_type_Bhey.a();; localMiniAppInfo = null)
    {
      bhck.a(localMiniAppInfo, 101, "0");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhij
 * JD-Core Version:    0.7.0.1
 */