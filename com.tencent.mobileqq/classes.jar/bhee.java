import android.content.Context;
import android.util.Log;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.MtaReportSt;
import java.util.Properties;

@bghi(a="ServiceInitTask")
public class bhee
  extends bhhm
{
  bhar jdField_a_of_type_Bhar;
  private bhcv jdField_a_of_type_Bhcv;
  
  public bhee(Context paramContext, bgqg parambgqg)
  {
    super(paramContext, parambgqg);
  }
  
  public bhcv a()
  {
    return this.jdField_a_of_type_Bhcv;
  }
  
  public void a()
  {
    Object localObject;
    label45:
    bhec localbhec;
    if (this.jdField_a_of_type_Bhar != null)
    {
      localObject = this.jdField_a_of_type_Bhar.a();
      bgyd.a((MiniAppInfo)localObject, 14, "0");
      localObject = (bhea)a().getTask(bhea.class);
      if (localObject == null) {
        break label132;
      }
      localObject = ((bhea)localObject).a();
      this.jdField_a_of_type_Bhar = ((bhar)localObject);
      localbhec = (bhec)a().getTask(bhec.class);
      if (localbhec == null) {
        break label137;
      }
      localObject = localbhec.a();
      label75:
      if (localbhec == null) {
        break label142;
      }
    }
    label132:
    label137:
    label142:
    for (long l = localbhec.a();; l = 0L)
    {
      if (localObject == null) {
        break label147;
      }
      if (this.jdField_a_of_type_Bhar != null) {
        ((bhcv)localObject).a(this.jdField_a_of_type_Bhar.a());
      }
      ((bhcv)localObject).addStateChangeListener(new bhef(this, (bhcv)localObject, l));
      ((bhcv)localObject).b();
      return;
      localObject = null;
      break;
      localObject = null;
      break label45;
      localObject = null;
      break label75;
    }
    label147:
    e();
  }
  
  protected void a(bhcv parambhcv, long paramLong1, long paramLong2)
  {
    for (;;)
    {
      try
      {
        Properties localProperties;
        if ((this.jdField_a_of_type_Bhcv == null) && (parambhcv != null))
        {
          this.jdField_a_of_type_Bhcv = parambhcv;
          c();
          localProperties = new Properties();
          if ((parambhcv instanceof bhdd))
          {
            localProperties.put("service_type", "v8");
            localProperties.put("service_init_timecost", Long.valueOf(paramLong1));
            localProperties.put("service_exec_timecost", Long.valueOf(paramLong2));
            localProperties.put("reserved", "1");
            Log.d("ServiceInitTask", parambhcv + ",serviceInit:" + paramLong1 + ",serviceExec:" + paramLong2);
            this.jdField_a_of_type_Bhar.a(bghw.a(50, new MtaReportSt("miniapp_service_init", localProperties)));
          }
        }
        else
        {
          return;
        }
        if ((parambhcv instanceof bhcw)) {
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
    if (this.jdField_a_of_type_Bhar != null) {}
    for (MiniAppInfo localMiniAppInfo = this.jdField_a_of_type_Bhar.a();; localMiniAppInfo = null)
    {
      bgyd.a(localMiniAppInfo, 15, "0");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhee
 * JD-Core Version:    0.7.0.1
 */