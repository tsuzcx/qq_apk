import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.StringUtil;

public class bakh
  extends bakd
{
  protected String a(QQAppInterface paramQQAppInterface)
  {
    if (StringUtil.isEmpty(this.f)) {
      paramQQAppInterface = "";
    }
    aquz localaquz;
    do
    {
      String str;
      do
      {
        return paramQQAppInterface;
        if (this.f.equalsIgnoreCase("qqgame")) {
          return bhnp.a("vipGameCenter");
        }
        if (!this.f.equalsIgnoreCase("confessmsg")) {
          break;
        }
        localaquz = ((aqvd)paramQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).b();
        str = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=message_box";
        paramQQAppInterface = str;
      } while (localaquz == null);
      paramQQAppInterface = str;
    } while (TextUtils.isEmpty(localaquz.l));
    return localaquz.l;
    if (this.f.equalsIgnoreCase("qinterest"))
    {
      paramQQAppInterface = bhhr.c(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        return paramQQAppInterface.trim();
      }
      return anxl.a;
    }
    return "";
  }
  
  protected void a(bheh parambheh, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (this.f.equalsIgnoreCase("qqgame")) {
      parambheh.e("platformId=qq_m");
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    paramQQAppInterface = a(paramQQAppInterface);
    if (StringUtil.isEmpty(paramQQAppInterface)) {
      return;
    }
    this.b = paramQQAppInterface;
  }
  
  protected boolean b(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    return !StringUtil.isEmpty(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bakh
 * JD-Core Version:    0.7.0.1
 */