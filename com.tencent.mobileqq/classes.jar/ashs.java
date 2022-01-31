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

public class ashs
{
  public static bafb a(Activity paramActivity, String paramString, int paramInt)
  {
    return a(paramActivity, paramString, paramInt, 0L);
  }
  
  public static bafb a(Activity paramActivity, String paramString, int paramInt, long paramLong)
  {
    paramString = babr.a(paramActivity, 230, null, ajjy.a(2131639351), ajjy.a(2131639357), ajjy.a(2131639282), new ashy(paramActivity, paramString, paramInt, paramLong), new ashz());
    if (!paramActivity.isFinishing()) {
      paramString.show();
    }
    return paramString;
  }
  
  public static bafb a(Activity paramActivity, String paramString1, String paramString2)
  {
    if (paramActivity.isFinishing()) {
      paramString1 = null;
    }
    bafb localbafb;
    do
    {
      return paramString1;
      localbafb = babr.a(paramActivity, 230);
      localbafb.setTitle(paramString1);
      localbafb.setMessage(paramString2);
      localbafb.setNegativeButton(ajjy.a(2131639291), new ashw());
      localbafb.setPositiveButton(ajjy.a(2131639276), new ashx(paramActivity));
      paramString1 = localbafb;
    } while (paramActivity.isFinishing());
    localbafb.show();
    return localbafb;
  }
  
  public static bafb a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = babr.a(paramContext, 230);
      paramContext.setTitle(paramString1);
      paramContext.setMessage(paramString2);
      paramContext.setPositiveButton(2131629116, new ashv());
      paramContext.show();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static bafb a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    try
    {
      bafb localbafb = babr.a(paramContext, 230);
      localbafb.setTitle(paramString1);
      localbafb.setMessage(paramString2);
      localbafb.setNegativeButton(ajjy.a(2131639295), new asht());
      localbafb.setPositiveButton(ajjy.a(2131639283), new ashu(paramContext, paramString3, paramInt));
      localbafb.show();
      return localbafb;
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
    if (mpl.a(str)) {}
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
    ((atmp)localObject).a(paramHotChatInfo);
    ((atmp)localObject).a();
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
    paramHotChatInfo = aciy.a(paramHotChatInfo, new int[] { 2 });
    paramHotChatInfo.addFlags(268435456);
    paramContext.startActivity(paramHotChatInfo);
    baig.a(paramContext, localQQAppInterface.getCurrentAccountUin(), false, System.currentTimeMillis());
    baig.e(paramContext, localQQAppInterface.getCurrentAccountUin(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ashs
 * JD-Core Version:    0.7.0.1
 */