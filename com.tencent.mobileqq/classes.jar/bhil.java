import android.content.Context;
import android.util.Log;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.MtaReportSt;
import java.util.Properties;

@bglp(a="ServiceInitTask")
public class bhil
  extends bhlt
{
  bhey jdField_a_of_type_Bhey;
  private bhhc jdField_a_of_type_Bhhc;
  
  public bhil(Context paramContext, bgun parambgun)
  {
    super(paramContext, parambgun);
  }
  
  public bhhc a()
  {
    return this.jdField_a_of_type_Bhhc;
  }
  
  public void a()
  {
    Object localObject;
    label45:
    bhij localbhij;
    if (this.jdField_a_of_type_Bhey != null)
    {
      localObject = this.jdField_a_of_type_Bhey.a();
      bhck.a((MiniAppInfo)localObject, 14, "0");
      localObject = (bhih)a().getTask(bhih.class);
      if (localObject == null) {
        break label132;
      }
      localObject = ((bhih)localObject).a();
      this.jdField_a_of_type_Bhey = ((bhey)localObject);
      localbhij = (bhij)a().getTask(bhij.class);
      if (localbhij == null) {
        break label137;
      }
      localObject = localbhij.a();
      label75:
      if (localbhij == null) {
        break label142;
      }
    }
    label132:
    label137:
    label142:
    for (long l = localbhij.a();; l = 0L)
    {
      if (localObject == null) {
        break label147;
      }
      if (this.jdField_a_of_type_Bhey != null) {
        ((bhhc)localObject).a(this.jdField_a_of_type_Bhey.a());
      }
      ((bhhc)localObject).addStateChangeListener(new bhim(this, (bhhc)localObject, l));
      ((bhhc)localObject).b();
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
  
  protected void a(bhhc parambhhc, long paramLong1, long paramLong2)
  {
    for (;;)
    {
      try
      {
        Properties localProperties;
        if ((this.jdField_a_of_type_Bhhc == null) && (parambhhc != null))
        {
          this.jdField_a_of_type_Bhhc = parambhhc;
          c();
          localProperties = new Properties();
          if ((parambhhc instanceof bhhk))
          {
            localProperties.put("service_type", "v8");
            localProperties.put("service_init_timecost", Long.valueOf(paramLong1));
            localProperties.put("service_exec_timecost", Long.valueOf(paramLong2));
            localProperties.put("reserved", "1");
            Log.d("ServiceInitTask", parambhhc + ",serviceInit:" + paramLong1 + ",serviceExec:" + paramLong2);
            this.jdField_a_of_type_Bhey.a(bgmd.a(50, new MtaReportSt("miniapp_service_init", localProperties)));
          }
        }
        else
        {
          return;
        }
        if ((parambhhc instanceof bhhd)) {
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
    if (this.jdField_a_of_type_Bhey != null) {}
    for (MiniAppInfo localMiniAppInfo = this.jdField_a_of_type_Bhey.a();; localMiniAppInfo = null)
    {
      bhck.a(localMiniAppInfo, 15, "0");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhil
 * JD-Core Version:    0.7.0.1
 */