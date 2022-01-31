import android.content.Context;
import android.util.Log;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.Properties;

@begt(a="ServiceInitTask")
public class bfds
  extends bfeq
{
  bfar jdField_a_of_type_Bfar;
  private bfco jdField_a_of_type_Bfco;
  
  public bfds(Context paramContext, bepv parambepv)
  {
    super(paramContext, parambepv);
  }
  
  public bfco a()
  {
    return this.jdField_a_of_type_Bfco;
  }
  
  public void a()
  {
    Object localObject;
    label45:
    bfdq localbfdq;
    if (this.jdField_a_of_type_Bfar != null)
    {
      localObject = this.jdField_a_of_type_Bfar.a();
      beyr.a((MiniAppInfo)localObject, 14, "0");
      localObject = (bfdo)a().getTask(bfdo.class);
      if (localObject == null) {
        break label132;
      }
      localObject = ((bfdo)localObject).a();
      this.jdField_a_of_type_Bfar = ((bfar)localObject);
      localbfdq = (bfdq)a().getTask(bfdq.class);
      if (localbfdq == null) {
        break label137;
      }
      localObject = localbfdq.a();
      label75:
      if (localbfdq == null) {
        break label142;
      }
    }
    label132:
    label137:
    label142:
    for (long l = localbfdq.a();; l = 0L)
    {
      if (localObject == null) {
        break label147;
      }
      if (this.jdField_a_of_type_Bfar != null) {
        ((bfco)localObject).a(this.jdField_a_of_type_Bfar.a());
      }
      ((bfco)localObject).a(new bfdt(this, (bfco)localObject, l));
      ((bfco)localObject).b();
      return;
      localObject = null;
      break;
      localObject = null;
      break label45;
      localObject = null;
      break label75;
    }
    label147:
    f();
  }
  
  protected void a(bfco parambfco, long paramLong1, long paramLong2)
  {
    for (;;)
    {
      try
      {
        Properties localProperties;
        if ((this.jdField_a_of_type_Bfco == null) && (parambfco != null))
        {
          this.jdField_a_of_type_Bfco = parambfco;
          c();
          localProperties = new Properties();
          if ((parambfco instanceof bfcw))
          {
            localProperties.put("service_type", "v8");
            localProperties.put("service_init_timecost", Long.valueOf(paramLong1));
            localProperties.put("service_exec_timecost", Long.valueOf(paramLong2));
            localProperties.put("reserved", "1");
            Log.d("ServiceInitTask", parambfco + ",serviceInit:" + paramLong1 + ",serviceExec:" + paramLong2);
            this.jdField_a_of_type_Bfar.a(bejl.a(50, new berh("miniapp_service_init", localProperties)));
          }
        }
        else
        {
          return;
        }
        if ((parambfco instanceof bfcp)) {
          localProperties.put("service_type", "x5");
        } else {
          localProperties.put("service_type", "unexpected");
        }
      }
      finally {}
    }
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_Bfar != null) {}
    for (MiniAppInfo localMiniAppInfo = this.jdField_a_of_type_Bfar.a();; localMiniAppInfo = null)
    {
      beyr.a(localMiniAppInfo, 15, "0");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfds
 * JD-Core Version:    0.7.0.1
 */