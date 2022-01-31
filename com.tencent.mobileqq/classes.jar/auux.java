import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class auux
{
  public static bdfq a(Activity paramActivity, String paramString, int paramInt)
  {
    return a(paramActivity, paramString, paramInt, 0L);
  }
  
  public static bdfq a(Activity paramActivity, String paramString, int paramInt, long paramLong)
  {
    paramString = bdcd.a(paramActivity, 230, null, alpo.a(2131705519), alpo.a(2131705525), alpo.a(2131705450), new auvd(paramActivity, paramString, paramInt, paramLong), new auve());
    if (!paramActivity.isFinishing()) {
      paramString.show();
    }
    return paramString;
  }
  
  public static bdfq a(Activity paramActivity, String paramString1, String paramString2)
  {
    if (paramActivity.isFinishing()) {
      paramString1 = null;
    }
    bdfq localbdfq;
    do
    {
      return paramString1;
      localbdfq = bdcd.a(paramActivity, 230);
      localbdfq.setTitle(paramString1);
      localbdfq.setMessage(paramString2);
      localbdfq.setNegativeButton(alpo.a(2131705459), new auvb());
      localbdfq.setPositiveButton(alpo.a(2131705444), new auvc(paramActivity));
      paramString1 = localbdfq;
    } while (paramActivity.isFinishing());
    localbdfq.show();
    return localbdfq;
  }
  
  public static bdfq a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = bdcd.a(paramContext, 230);
      paramContext.setTitle(paramString1);
      paramContext.setMessage(paramString2);
      paramContext.setPositiveButton(2131694951, new auva());
      paramContext.show();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static bdfq a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    try
    {
      bdfq localbdfq = bdcd.a(paramContext, 230);
      localbdfq.setTitle(paramString1);
      localbdfq.setMessage(paramString2);
      localbdfq.setNegativeButton(alpo.a(2131705463), new auuy());
      localbdfq.setPositiveButton(alpo.a(2131705451), new auuz(paramContext, paramString3, paramInt));
      localbdfq.show();
      return localbdfq;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    String str = "https://nearby.qq.com/werewolf/game-overview.html?_bid=2652&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_anim=true&_nav_alpha=0&_wv=16779011&_wwv=5&from=" + paramInt;
    if (ndd.a(str)) {}
    try
    {
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("url", URLUtil.guessUrl(str));
      localIntent.putExtra("op_type", "wolf");
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("GameRoomUtils", 2, "发起新游戏 error, " + paramContext);
    }
  }
  
  public static void a(Context paramContext, HotChatInfo paramHotChatInfo, int paramInt, String paramString1, String paramString2)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    paramHotChatInfo.isGameRoom = true;
    Object localObject = localQQAppInterface.getEntityManagerFactory().createEntityManager();
    ((awbw)localObject).a(paramHotChatInfo);
    ((awbw)localObject).a();
    localObject = (HotChatManager)localQQAppInterface.getManager(60);
    List localList = ((HotChatManager)localObject).a();
    if ((localList != null) && (!localList.contains(paramHotChatInfo))) {
      localList.add(paramHotChatInfo);
    }
    ((HotChatManager)localObject).a(paramHotChatInfo, 4);
    paramHotChatInfo = new Intent(paramContext, ChatActivity.class);
    paramHotChatInfo.putExtra("uin", paramInt + "");
    paramHotChatInfo.putExtra("uintype", 1);
    paramHotChatInfo.putExtra("troop_uin", paramInt + "");
    paramHotChatInfo.putExtra("uinname", paramString2);
    paramHotChatInfo.putExtra("hotnamecode", paramString1);
    paramHotChatInfo = aekt.a(paramHotChatInfo, new int[] { 2 });
    paramHotChatInfo.addFlags(268435456);
    paramContext.startActivity(paramHotChatInfo);
    bdiv.a(paramContext, localQQAppInterface.getCurrentAccountUin(), false, System.currentTimeMillis());
    bdiv.f(paramContext, localQQAppInterface.getCurrentAccountUin(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auux
 * JD-Core Version:    0.7.0.1
 */