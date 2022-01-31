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

public class atdy
{
  public static bbgu a(Activity paramActivity, String paramString, int paramInt)
  {
    return a(paramActivity, paramString, paramInt, 0L);
  }
  
  public static bbgu a(Activity paramActivity, String paramString, int paramInt, long paramLong)
  {
    paramString = bbdj.a(paramActivity, 230, null, ajya.a(2131705147), ajya.a(2131705153), ajya.a(2131705078), new atee(paramActivity, paramString, paramInt, paramLong), new atef());
    if (!paramActivity.isFinishing()) {
      paramString.show();
    }
    return paramString;
  }
  
  public static bbgu a(Activity paramActivity, String paramString1, String paramString2)
  {
    if (paramActivity.isFinishing()) {
      paramString1 = null;
    }
    bbgu localbbgu;
    do
    {
      return paramString1;
      localbbgu = bbdj.a(paramActivity, 230);
      localbbgu.setTitle(paramString1);
      localbbgu.setMessage(paramString2);
      localbbgu.setNegativeButton(ajya.a(2131705087), new atec());
      localbbgu.setPositiveButton(ajya.a(2131705072), new ated(paramActivity));
      paramString1 = localbbgu;
    } while (paramActivity.isFinishing());
    localbbgu.show();
    return localbbgu;
  }
  
  public static bbgu a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = bbdj.a(paramContext, 230);
      paramContext.setTitle(paramString1);
      paramContext.setMessage(paramString2);
      paramContext.setPositiveButton(2131694794, new ateb());
      paramContext.show();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static bbgu a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    try
    {
      bbgu localbbgu = bbdj.a(paramContext, 230);
      localbbgu.setTitle(paramString1);
      localbbgu.setMessage(paramString2);
      localbbgu.setNegativeButton(ajya.a(2131705091), new atdz());
      localbbgu.setPositiveButton(ajya.a(2131705079), new atea(paramContext, paramString3, paramInt));
      localbbgu.show();
      return localbbgu;
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
    if (naj.a(str)) {}
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
    ((aukp)localObject).a(paramHotChatInfo);
    ((aukp)localObject).a();
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
    paramHotChatInfo = actj.a(paramHotChatInfo, new int[] { 2 });
    paramHotChatInfo.addFlags(268435456);
    paramContext.startActivity(paramHotChatInfo);
    bbkb.a(paramContext, localQQAppInterface.getCurrentAccountUin(), false, System.currentTimeMillis());
    bbkb.e(paramContext, localQQAppInterface.getCurrentAccountUin(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atdy
 * JD-Core Version:    0.7.0.1
 */