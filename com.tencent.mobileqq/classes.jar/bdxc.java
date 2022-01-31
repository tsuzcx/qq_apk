import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.runtime.task.ServiceInitTask.2;
import java.util.Properties;

@bdcu(a="ServiceInitTask")
public class bdxc
  extends bdxy
{
  public bduj a;
  private bdwf jdField_a_of_type_Bdwf;
  private boolean jdField_a_of_type_Boolean;
  private bdwf b;
  private bdwf c;
  
  public bdxc(Context paramContext, bdlq parambdlq)
  {
    super(paramContext, parambdlq);
  }
  
  private void a(bdwf parambdwf, long paramLong1, long paramLong2)
  {
    for (;;)
    {
      try
      {
        Properties localProperties;
        if ((this.jdField_a_of_type_Bdwf == null) && (parambdwf != null))
        {
          this.jdField_a_of_type_Bdwf = parambdwf;
          c();
          localProperties = new Properties();
          if ((parambdwf instanceof bdwj))
          {
            localProperties.put("service_type", "v8");
            localProperties.put("service_init_timecost", Long.valueOf(paramLong1));
            localProperties.put("service_exec_timecost", Long.valueOf(paramLong2));
            localProperties.put("reserved", "1");
            Log.d("ServiceInit", parambdwf + ",serviceInit:" + paramLong1 + ",serviceExec:" + paramLong2);
            this.jdField_a_of_type_Bduj.a(bdfl.a(50, new bdmx("miniapp_service_init", localProperties)));
          }
        }
        else
        {
          return;
        }
        if ((parambdwf instanceof bdwg)) {
          localProperties.put("service_type", "x5");
        } else {
          localProperties.put("service_type", "unexpected");
        }
      }
      finally {}
    }
  }
  
  public bdwf a()
  {
    return this.jdField_a_of_type_Bdwf;
  }
  
  public void a()
  {
    Object localObject2 = null;
    bdsc.a(208, "", a().getMiniAppInfoForReport());
    this.jdField_a_of_type_Bdwf = null;
    Object localObject1 = (bdxa)a().getTask(bdxa.class);
    if (localObject1 != null)
    {
      localObject1 = ((bdxa)localObject1).a();
      this.jdField_a_of_type_Bduj = ((bduj)localObject1);
      if (this.jdField_a_of_type_Bduj == null) {
        break label204;
      }
    }
    label204:
    for (localObject1 = this.jdField_a_of_type_Bduj.a();; localObject1 = null)
    {
      bdsu.a((MiniAppInfo)localObject1, 100, "0");
      if (!this.jdField_a_of_type_Boolean) {
        break label226;
      }
      try
      {
        long l1 = System.currentTimeMillis();
        this.b = new bdwj(this.jdField_a_of_type_Bduj);
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Bduj != null) {
          localObject1 = this.jdField_a_of_type_Bduj.a();
        }
        bdsu.a((MiniAppInfo)localObject1, 101, "0");
        long l2 = System.currentTimeMillis();
        if (this.jdField_a_of_type_Bduj != null) {
          this.b.a(this.jdField_a_of_type_Bduj.a());
        }
        this.b.a(new bdxd(this, l2 - l1));
        this.b.b();
        i = 1;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          bdnw.d("minisdk-start", "ServiceInitTask execute exception!", localThrowable);
          int i = 0;
        }
      }
      if (i == 0) {
        f();
      }
      return;
      localObject1 = null;
      break;
    }
    label226:
    new Handler(Looper.getMainLooper()).post(new ServiceInitTask.2(this));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void c()
  {
    super.c();
    bdsc.a(209, "", a().getMiniAppInfoForReport());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdxc
 * JD-Core Version:    0.7.0.1
 */