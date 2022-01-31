import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.task.ServiceCreateTask.2;
import com.tencent.smtt.sdk.JsVirtualMachine;
import com.tencent.smtt.sdk.QbSdk;

@bghi(a="ServiceCreateTask")
public class bhec
  extends bhhm
{
  private long jdField_a_of_type_Long;
  bhar jdField_a_of_type_Bhar;
  private bhcv jdField_a_of_type_Bhcv;
  JsVirtualMachine jdField_a_of_type_ComTencentSmttSdkJsVirtualMachine;
  private long b;
  
  public bhec(Context paramContext, bgqg parambgqg)
  {
    super(paramContext, parambgqg);
  }
  
  private void d()
  {
    try
    {
      QMLog.i("ServiceCreateTask", "AppBrandWebviewService create start");
      a(new bhda(this.jdField_a_of_type_Bhar, null));
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
  
  public bhcv a()
  {
    return this.jdField_a_of_type_Bhcv;
  }
  
  public void a()
  {
    Object localObject2 = null;
    if (this.jdField_a_of_type_Bhar != null) {}
    for (Object localObject1 = this.jdField_a_of_type_Bhar.a();; localObject1 = null)
    {
      bgyd.a((MiniAppInfo)localObject1, 100, "0");
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      bhea localbhea = (bhea)a().getTask(bhea.class);
      localObject1 = localObject2;
      if (localbhea != null) {
        localObject1 = localbhea.a();
      }
      this.jdField_a_of_type_Bhar = ((bhar)localObject1);
      int i = QbSdk.getTbsVersion(a());
      int j = QbSdk.getTmpDirTbsVersion(a());
      if (((i <= 0) && (j <= 0)) || (a(a()))) {
        break;
      }
      try
      {
        QMLog.i("ServiceCreateTask", "AppBrandService create start");
        localObject1 = new bhcw(this.jdField_a_of_type_Bhar, null);
        ((bhcw)localObject1).a(a(), new bhed(this, (bhcw)localObject1));
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
  
  protected void a(bhcv parambhcv)
  {
    try
    {
      QMLog.i("ServiceCreateTask", "onServiceCreateSucc service:" + parambhcv);
      if ((this.jdField_a_of_type_Bhcv == null) && (parambhcv != null))
      {
        this.jdField_a_of_type_Bhcv = parambhcv;
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
    if (this.jdField_a_of_type_Bhar != null) {}
    for (MiniAppInfo localMiniAppInfo = this.jdField_a_of_type_Bhar.a();; localMiniAppInfo = null)
    {
      bgyd.a(localMiniAppInfo, 101, "0");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhec
 * JD-Core Version:    0.7.0.1
 */