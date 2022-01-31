import android.content.Context;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

@behk(a="V8ServiceInitTask")
public class bfel
  extends bfej
{
  public bfel(Context paramContext, beqm parambeqm)
  {
    super(paramContext, parambeqm);
  }
  
  public void a()
  {
    beyq.a(208, "", a().getMiniAppInfoForReport());
    try
    {
      Object localObject = (bfef)a().getTask(bfef.class);
      long l1;
      label67:
      bfdn localbfdn;
      if (localObject != null)
      {
        localObject = ((bfef)localObject).a();
        this.a = ((bfbi)localObject);
        l1 = System.currentTimeMillis();
        if (this.a == null) {
          break label167;
        }
        localObject = this.a.a();
        bezi.a((MiniAppInfo)localObject, 100, "0");
        localbfdn = new bfdn(this.a);
        if (this.a == null) {
          break label173;
        }
      }
      label167:
      label173:
      for (localObject = this.a.a();; localObject = null)
      {
        bezi.a((MiniAppInfo)localObject, 101, "0");
        long l2 = System.currentTimeMillis();
        if (this.a != null) {
          localbfdn.a(this.a.a());
        }
        localbfdn.a(new bfem(this, localbfdn, l2 - l1));
        localbfdn.b();
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
      betc.d("minisdk-start", "ServiceInitTask execute exception!", localThrowable);
    }
  }
  
  public void c()
  {
    super.c();
    beyq.a(209, "", a().getMiniAppInfoForReport());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfel
 * JD-Core Version:    0.7.0.1
 */