import android.content.Context;
import android.content.Intent;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;

public class bhpo
{
  public static void a(Context paramContext, FollowUpdateEvent paramFollowUpdateEvent)
  {
    if (paramFollowUpdateEvent != null) {
      a(paramContext, paramFollowUpdateEvent.useId, paramFollowUpdateEvent.followStatus);
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    if ((paramContext == null) || (paramString == null)) {
      return;
    }
    Intent localIntent = new Intent("action.qzone_public_account_follow");
    localIntent.putExtra("followed", paramInt);
    localIntent.putExtra("uin", paramString);
    paramContext.sendBroadcast(localIntent, "com.tencent.qzone.permission.notify");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhpo
 * JD-Core Version:    0.7.0.1
 */