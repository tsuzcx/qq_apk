import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;

public class avdl
  extends avdi
{
  protected String a(QQAppInterface paramQQAppInterface)
  {
    if (bbkk.a(this.f)) {
      paramQQAppInterface = "";
    }
    amnj localamnj;
    do
    {
      String str;
      do
      {
        return paramQQAppInterface;
        if (this.f.equalsIgnoreCase("qqgame")) {
          return bbqd.a("vipGameCenter");
        }
        if (!this.f.equalsIgnoreCase("confessmsg")) {
          break;
        }
        localamnj = ((amnn)paramQQAppInterface.getManager(269)).b();
        str = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=message_box";
        paramQQAppInterface = str;
      } while (localamnj == null);
      paramQQAppInterface = str;
    } while (TextUtils.isEmpty(localamnj.l));
    return localamnj.l;
    if (this.f.equalsIgnoreCase("qinterest"))
    {
      paramQQAppInterface = bbkb.c(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        return paramQQAppInterface.trim();
      }
      return ajzm.a;
    }
    if (this.f.equalsIgnoreCase("bodong")) {}
    return "";
  }
  
  protected void a(bbeg parambbeg, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (this.f.equalsIgnoreCase("qqgame")) {
      parambbeg.d("platformId=qq_m");
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    paramQQAppInterface = a(paramQQAppInterface);
    if (bbkk.a(paramQQAppInterface)) {
      return;
    }
    this.b = paramQQAppInterface;
  }
  
  protected boolean b(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    return !bbkk.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avdl
 * JD-Core Version:    0.7.0.1
 */