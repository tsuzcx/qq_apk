import android.content.Context;
import android.util.Log;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.Properties;

@behk(a="ServiceInitTask")
public class bfej
  extends bffh
{
  bfbi jdField_a_of_type_Bfbi;
  private bfdf jdField_a_of_type_Bfdf;
  
  public bfej(Context paramContext, beqm parambeqm)
  {
    super(paramContext, parambeqm);
  }
  
  public bfdf a()
  {
    return this.jdField_a_of_type_Bfdf;
  }
  
  public void a()
  {
    Object localObject;
    label45:
    bfeh localbfeh;
    if (this.jdField_a_of_type_Bfbi != null)
    {
      localObject = this.jdField_a_of_type_Bfbi.a();
      bezi.a((MiniAppInfo)localObject, 14, "0");
      localObject = (bfef)a().getTask(bfef.class);
      if (localObject == null) {
        break label132;
      }
      localObject = ((bfef)localObject).a();
      this.jdField_a_of_type_Bfbi = ((bfbi)localObject);
      localbfeh = (bfeh)a().getTask(bfeh.class);
      if (localbfeh == null) {
        break label137;
      }
      localObject = localbfeh.a();
      label75:
      if (localbfeh == null) {
        break label142;
      }
    }
    label132:
    label137:
    label142:
    for (long l = localbfeh.a();; l = 0L)
    {
      if (localObject == null) {
        break label147;
      }
      if (this.jdField_a_of_type_Bfbi != null) {
        ((bfdf)localObject).a(this.jdField_a_of_type_Bfbi.a());
      }
      ((bfdf)localObject).a(new bfek(this, (bfdf)localObject, l));
      ((bfdf)localObject).b();
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
  
  protected void a(bfdf parambfdf, long paramLong1, long paramLong2)
  {
    for (;;)
    {
      try
      {
        Properties localProperties;
        if ((this.jdField_a_of_type_Bfdf == null) && (parambfdf != null))
        {
          this.jdField_a_of_type_Bfdf = parambfdf;
          c();
          localProperties = new Properties();
          if ((parambfdf instanceof bfdn))
          {
            localProperties.put("service_type", "v8");
            localProperties.put("service_init_timecost", Long.valueOf(paramLong1));
            localProperties.put("service_exec_timecost", Long.valueOf(paramLong2));
            localProperties.put("reserved", "1");
            Log.d("ServiceInitTask", parambfdf + ",serviceInit:" + paramLong1 + ",serviceExec:" + paramLong2);
            this.jdField_a_of_type_Bfbi.a(bekc.a(50, new bery("miniapp_service_init", localProperties)));
          }
        }
        else
        {
          return;
        }
        if ((parambfdf instanceof bfdg)) {
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
    if (this.jdField_a_of_type_Bfbi != null) {}
    for (MiniAppInfo localMiniAppInfo = this.jdField_a_of_type_Bfbi.a();; localMiniAppInfo = null)
    {
      bezi.a(localMiniAppInfo, 15, "0");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfej
 * JD-Core Version:    0.7.0.1
 */