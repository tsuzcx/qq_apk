import android.content.Context;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;

@bghi(a="V8ServiceInitTask")
public class bheh
  extends bhee
{
  public bheh(Context paramContext, bgqg parambgqg)
  {
    super(paramContext, parambgqg);
  }
  
  public void a()
  {
    bgxl.a(208, "", a().getMiniAppInfoForReport());
    try
    {
      Object localObject = (bhea)a().getTask(bhea.class);
      long l1;
      label67:
      bhdd localbhdd;
      if (localObject != null)
      {
        localObject = ((bhea)localObject).a();
        this.a = ((bhar)localObject);
        l1 = System.currentTimeMillis();
        if (this.a == null) {
          break label167;
        }
        localObject = this.a.a();
        bgyd.a((MiniAppInfo)localObject, 100, "0");
        localbhdd = new bhdd(this.a);
        if (this.a == null) {
          break label173;
        }
      }
      label167:
      label173:
      for (localObject = this.a.a();; localObject = null)
      {
        bgyd.a((MiniAppInfo)localObject, 101, "0");
        long l2 = System.currentTimeMillis();
        if (this.a != null) {
          localbhdd.a(this.a.a());
        }
        localbhdd.addStateChangeListener(new bhei(this, localbhdd, l2 - l1));
        localbhdd.b();
        return;
        localObject = null;
        break;
        localObject = null;
        break label67;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start", "ServiceInitTask execute exception!", localThrowable);
    }
  }
  
  public void c()
  {
    super.c();
    bgxl.a(209, "", a().getMiniAppInfoForReport());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bheh
 * JD-Core Version:    0.7.0.1
 */