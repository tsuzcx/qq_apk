import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;

public class aued
  extends auea
{
  protected String a(QQAppInterface paramQQAppInterface)
  {
    if (baip.a(this.f)) {
      paramQQAppInterface = "";
    }
    alxu localalxu;
    do
    {
      String str;
      do
      {
        return paramQQAppInterface;
        if (this.f.equalsIgnoreCase("qqgame")) {
          return bant.a("vipGameCenter");
        }
        if (!this.f.equalsIgnoreCase("confessmsg")) {
          break;
        }
        localalxu = ((alxy)paramQQAppInterface.getManager(269)).b();
        str = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=message_box";
        paramQQAppInterface = str;
      } while (localalxu == null);
      paramQQAppInterface = str;
    } while (TextUtils.isEmpty(localalxu.l));
    return localalxu.l;
    if (this.f.equalsIgnoreCase("qinterest"))
    {
      paramQQAppInterface = baig.c(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        return paramQQAppInterface.trim();
      }
      return ajlh.a;
    }
    if (this.f.equalsIgnoreCase("bodong")) {}
    return "";
  }
  
  protected void a(bacn parambacn, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (this.f.equalsIgnoreCase("qqgame")) {
      parambacn.d("platformId=qq_m");
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    paramQQAppInterface = a(paramQQAppInterface);
    if (baip.a(paramQQAppInterface)) {
      return;
    }
    this.b = paramQQAppInterface;
  }
  
  protected boolean b(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    return !baip.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aued
 * JD-Core Version:    0.7.0.1
 */