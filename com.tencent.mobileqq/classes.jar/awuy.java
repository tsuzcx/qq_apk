import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;

public class awuy
  extends awuv
{
  protected String a(QQAppInterface paramQQAppInterface)
  {
    if (bdje.a(this.f)) {
      paramQQAppInterface = "";
    }
    aoeh localaoeh;
    do
    {
      String str;
      do
      {
        return paramQQAppInterface;
        if (this.f.equalsIgnoreCase("qqgame")) {
          return bdox.a("vipGameCenter");
        }
        if (!this.f.equalsIgnoreCase("confessmsg")) {
          break;
        }
        localaoeh = ((aoel)paramQQAppInterface.getManager(269)).b();
        str = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=message_box";
        paramQQAppInterface = str;
      } while (localaoeh == null);
      paramQQAppInterface = str;
    } while (TextUtils.isEmpty(localaoeh.l));
    return localaoeh.l;
    if (this.f.equalsIgnoreCase("qinterest"))
    {
      paramQQAppInterface = bdiv.c(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        return paramQQAppInterface.trim();
      }
      return alra.a;
    }
    if (this.f.equalsIgnoreCase("bodong")) {}
    return "";
  }
  
  protected void a(bddb parambddb, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (this.f.equalsIgnoreCase("qqgame")) {
      parambddb.d("platformId=qq_m");
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    paramQQAppInterface = a(paramQQAppInterface);
    if (bdje.a(paramQQAppInterface)) {
      return;
    }
    this.b = paramQQAppInterface;
  }
  
  protected boolean b(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    return !bdje.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awuy
 * JD-Core Version:    0.7.0.1
 */