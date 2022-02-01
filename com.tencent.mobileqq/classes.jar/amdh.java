import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity;
import com.tencent.mobileqq.activity.specialcare.SpecialCareUtils.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class amdh
{
  public static void a(Activity paramActivity, String paramString, int paramInt)
  {
    if ((paramInt == 3) && (aunx.a().a()))
    {
      localObject = new HashMap();
      ((Map)localObject).put("uin", paramString);
      ((Map)localObject).put("from", Integer.valueOf(3));
      auon.a(paramActivity, "SpecialCareFriendSettingPage", (Map)localObject);
      return;
    }
    Object localObject = new Intent(paramActivity, QQSpecialCareSettingActivity.class);
    ((Intent)localObject).putExtra("key_friend_uin", paramString);
    ((Intent)localObject).putExtra("key_start_from", 3);
    paramActivity.startActivity((Intent)localObject);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new SpecialCareUtils.1(paramQQAppInterface), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amdh
 * JD-Core Version:    0.7.0.1
 */