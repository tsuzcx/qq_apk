import android.content.Context;
import android.content.Intent;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.ChatActivity;

public class avdc
{
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    QLog.i("GameBuddyUtil", 1, "[openGameBuddyAio]");
    Intent localIntent = new Intent(paramContext, ChatActivity.class);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", paramInt);
    paramContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avdc
 * JD-Core Version:    0.7.0.1
 */