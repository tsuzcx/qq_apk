import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;

public class banm
  extends banj
{
  protected String a(QQAppInterface paramQQAppInterface)
  {
    if (bhsr.a(this.f)) {
      paramQQAppInterface = "";
    }
    aqyl localaqyl;
    do
    {
      String str;
      do
      {
        return paramQQAppInterface;
        if (this.f.equalsIgnoreCase("qqgame")) {
          return bhyk.a("vipGameCenter");
        }
        if (!this.f.equalsIgnoreCase("confessmsg")) {
          break;
        }
        localaqyl = ((aqyp)paramQQAppInterface.getManager(269)).b();
        str = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=message_box";
        paramQQAppInterface = str;
      } while (localaqyl == null);
      paramQQAppInterface = str;
    } while (TextUtils.isEmpty(localaqyl.l));
    return localaqyl.l;
    if (this.f.equalsIgnoreCase("qinterest"))
    {
      paramQQAppInterface = bhsi.c(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        return paramQQAppInterface.trim();
      }
      return aoaw.a;
    }
    if (this.f.equalsIgnoreCase("bodong")) {}
    return "";
  }
  
  protected void a(bhmr parambhmr, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (this.f.equalsIgnoreCase("qqgame")) {
      parambhmr.e("platformId=qq_m");
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    paramQQAppInterface = a(paramQQAppInterface);
    if (bhsr.a(paramQQAppInterface)) {
      return;
    }
    this.b = paramQQAppInterface;
  }
  
  protected boolean b(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    return !bhsr.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     banm
 * JD-Core Version:    0.7.0.1
 */