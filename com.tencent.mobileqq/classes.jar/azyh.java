import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;

public class azyh
{
  public static boolean a(Context paramContext, AppInterface paramAppInterface)
  {
    return (SettingCloneUtil.readValue(paramContext, paramAppInterface.getCurrentAccountUin(), paramContext.getString(2131653024), "qqsetting_notify_blncontrol_key", true)) && ((paramAppInterface.isBackground_Pause) || (!azyx.a(BaseApplicationImpl.sApplication))) && (!FriendsStatusUtil.a(paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azyh
 * JD-Core Version:    0.7.0.1
 */