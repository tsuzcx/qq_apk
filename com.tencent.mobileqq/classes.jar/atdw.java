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

public class atdw
{
  public static bbgg a(Activity paramActivity, String paramString, int paramInt)
  {
    return a(paramActivity, paramString, paramInt, 0L);
  }
  
  public static bbgg a(Activity paramActivity, String paramString, int paramInt, long paramLong)
  {
    paramString = bbcv.a(paramActivity, 230, null, ajyc.a(2131705136), ajyc.a(2131705142), ajyc.a(2131705067), new atec(paramActivity, paramString, paramInt, paramLong), new ated());
    if (!paramActivity.isFinishing()) {
      paramString.show();
    }
    return paramString;
  }
  
  public static bbgg a(Activity paramActivity, String paramString1, String paramString2)
  {
    if (paramActivity.isFinishing()) {
      paramString1 = null;
    }
    bbgg localbbgg;
    do
    {
      return paramString1;
      localbbgg = bbcv.a(paramActivity, 230);
      localbbgg.setTitle(paramString1);
      localbbgg.setMessage(paramString2);
      localbbgg.setNegativeButton(ajyc.a(2131705076), new atea());
      localbbgg.setPositiveButton(ajyc.a(2131705061), new ateb(paramActivity));
      paramString1 = localbbgg;
    } while (paramActivity.isFinishing());
    localbbgg.show();
    return localbbgg;
  }
  
  public static bbgg a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = bbcv.a(paramContext, 230);
      paramContext.setTitle(paramString1);
      paramContext.setMessage(paramString2);
      paramContext.setPositiveButton(2131694793, new atdz());
      paramContext.show();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static bbgg a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    try
    {
      bbgg localbbgg = bbcv.a(paramContext, 230);
      localbbgg.setTitle(paramString1);
      localbbgg.setMessage(paramString2);
      localbbgg.setNegativeButton(ajyc.a(2131705080), new atdx());
      localbbgg.setPositiveButton(ajyc.a(2131705068), new atdy(paramContext, paramString3, paramInt));
      localbbgg.show();
      return localbbgg;
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
    if (nam.a(str)) {}
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
    ((aukn)localObject).a(paramHotChatInfo);
    ((aukn)localObject).a();
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
    paramHotChatInfo = actn.a(paramHotChatInfo, new int[] { 2 });
    paramHotChatInfo.addFlags(268435456);
    paramContext.startActivity(paramHotChatInfo);
    bbjn.a(paramContext, localQQAppInterface.getCurrentAccountUin(), false, System.currentTimeMillis());
    bbjn.e(paramContext, localQQAppInterface.getCurrentAccountUin(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atdw
 * JD-Core Version:    0.7.0.1
 */