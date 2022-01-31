import android.content.Context;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;

@bglp(a="V8ServiceInitTask")
public class bhio
  extends bhil
{
  public bhio(Context paramContext, bgun parambgun)
  {
    super(paramContext, parambgun);
  }
  
  public void a()
  {
    bhbs.a(208, "", a().getMiniAppInfoForReport());
    try
    {
      Object localObject = (bhih)a().getTask(bhih.class);
      long l1;
      label67:
      bhhk localbhhk;
      if (localObject != null)
      {
        localObject = ((bhih)localObject).a();
        this.a = ((bhey)localObject);
        l1 = System.currentTimeMillis();
        if (this.a == null) {
          break label167;
        }
        localObject = this.a.a();
        bhck.a((MiniAppInfo)localObject, 100, "0");
        localbhhk = new bhhk(this.a);
        if (this.a == null) {
          break label173;
        }
      }
      label167:
      label173:
      for (localObject = this.a.a();; localObject = null)
      {
        bhck.a((MiniAppInfo)localObject, 101, "0");
        long l2 = System.currentTimeMillis();
        if (this.a != null) {
          localbhhk.a(this.a.a());
        }
        localbhhk.addStateChangeListener(new bhip(this, localbhhk, l2 - l1));
        localbhhk.b();
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
    bhbs.a(209, "", a().getMiniAppInfoForReport());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhio
 * JD-Core Version:    0.7.0.1
 */