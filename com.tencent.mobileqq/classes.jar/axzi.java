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
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class axzi
{
  public static bhpc a(Activity paramActivity, String paramString, int paramInt)
  {
    return a(paramActivity, paramString, paramInt, 0L);
  }
  
  public static bhpc a(Activity paramActivity, String paramString, int paramInt, long paramLong)
  {
    paramString = bhlq.a(paramActivity, 230, null, anzj.a(2131704034), anzj.a(2131704040), anzj.a(2131703965), new axzo(paramActivity, paramString, paramInt, paramLong), new axzp());
    if (!paramActivity.isFinishing()) {
      paramString.show();
    }
    return paramString;
  }
  
  public static bhpc a(Activity paramActivity, String paramString1, String paramString2)
  {
    if (paramActivity.isFinishing()) {
      paramString1 = null;
    }
    bhpc localbhpc;
    do
    {
      return paramString1;
      localbhpc = bhlq.a(paramActivity, 230);
      localbhpc.setTitle(paramString1);
      localbhpc.setMessage(paramString2);
      localbhpc.setNegativeButton(anzj.a(2131703974), new axzm());
      localbhpc.setPositiveButton(anzj.a(2131703959), new axzn(paramActivity));
      paramString1 = localbhpc;
    } while (paramActivity.isFinishing());
    localbhpc.show();
    return localbhpc;
  }
  
  public static bhpc a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = bhlq.a(paramContext, 230);
      paramContext.setTitle(paramString1);
      paramContext.setMessage(paramString2);
      paramContext.setPositiveButton(2131694098, new axzl());
      paramContext.show();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static bhpc a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    try
    {
      bhpc localbhpc = bhlq.a(paramContext, 230);
      localbhpc.setTitle(paramString1);
      localbhpc.setMessage(paramString2);
      localbhpc.setNegativeButton(anzj.a(2131703978), new axzj());
      localbhpc.setPositiveButton(anzj.a(2131703966), new axzk(paramContext, paramString3, paramInt));
      localbhpc.show();
      return localbhpc;
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
    if (nnr.a(str)) {}
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
    Object localObject = localQQAppInterface.a().createEntityManager();
    ((EntityManager)localObject).update(paramHotChatInfo);
    ((EntityManager)localObject).close();
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
    paramHotChatInfo = agej.a(paramHotChatInfo, new int[] { 2 });
    paramHotChatInfo.addFlags(268435456);
    paramContext.startActivity(paramHotChatInfo);
    bhsi.a(paramContext, localQQAppInterface.getCurrentAccountUin(), false, System.currentTimeMillis());
    bhsi.f(paramContext, localQQAppInterface.getCurrentAccountUin(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axzi
 * JD-Core Version:    0.7.0.1
 */