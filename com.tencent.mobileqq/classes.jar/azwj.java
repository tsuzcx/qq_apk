import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.LikeRankingListActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class azwj
{
  public static final void a(Activity paramActivity, boolean paramBoolean)
  {
    QLog.d("", 1, String.format("openLikeRankingList flutterPage=%b", new Object[] { Boolean.valueOf(paramBoolean) }));
    if (paramBoolean)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("kUin", BaseApplicationImpl.getApplication().getRuntime().getAccount());
      auon.a(paramActivity, "ZanLeaderboardPage", localHashMap, 1024, true, false);
      return;
    }
    paramActivity.startActivity(new Intent(paramActivity, LikeRankingListActivity.class));
  }
  
  public static final void a(Context paramContext, String paramString)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((!TextUtils.isEmpty(paramString)) && (localObject != null))
    {
      String str = ((AppRuntime)localObject).getAccount();
      localObject = "2";
      if (paramString.equals(str)) {
        localObject = "1";
      }
      bdla.b(null, "dc00898", "", "", "0X8007616", "0X8007616", 0, 0, (String)localObject, "", "", "");
      ProfileActivity.b(paramContext, new ProfileActivity.AllInOne(paramString, 1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azwj
 * JD-Core Version:    0.7.0.1
 */