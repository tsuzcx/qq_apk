import android.content.Context;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

@begt(a="V8ServiceInitTask")
public class bfdu
  extends bfds
{
  public bfdu(Context paramContext, bepv parambepv)
  {
    super(paramContext, parambepv);
  }
  
  public void a()
  {
    bexz.a(208, "", a().getMiniAppInfoForReport());
    try
    {
      Object localObject = (bfdo)a().getTask(bfdo.class);
      long l1;
      label67:
      bfcw localbfcw;
      if (localObject != null)
      {
        localObject = ((bfdo)localObject).a();
        this.a = ((bfar)localObject);
        l1 = System.currentTimeMillis();
        if (this.a == null) {
          break label167;
        }
        localObject = this.a.a();
        beyr.a((MiniAppInfo)localObject, 100, "0");
        localbfcw = new bfcw(this.a);
        if (this.a == null) {
          break label173;
        }
      }
      label167:
      label173:
      for (localObject = this.a.a();; localObject = null)
      {
        beyr.a((MiniAppInfo)localObject, 101, "0");
        long l2 = System.currentTimeMillis();
        if (this.a != null) {
          localbfcw.a(this.a.a());
        }
        localbfcw.a(new bfdv(this, localbfcw, l2 - l1));
        localbfcw.b();
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
      besl.d("minisdk-start", "ServiceInitTask execute exception!", localThrowable);
    }
  }
  
  public void c()
  {
    super.c();
    bexz.a(209, "", a().getMiniAppInfoForReport());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfdu
 * JD-Core Version:    0.7.0.1
 */