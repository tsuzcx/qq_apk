import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import java.util.ArrayList;

public class bgyr
{
  public static final Uri a()
  {
    String str = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getString("LastScreenShotUri", "");
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return Uri.parse(str);
  }
  
  public static String a()
  {
    Time localTime = new Time();
    localTime.setToNow();
    localTime.switchTimezone("Asia/Shanghai");
    return localTime.format("%Y%m%d%H%M%S");
  }
  
  public static String a(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Time localTime = new Time();
    localTime.setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.process.exit");
    localStringBuilder.append(localTime.year).append(localTime.month + 1).append(localTime.monthDay);
    localStringBuilder.append(localTime.hour);
    if (paramBoolean)
    {
      localStringBuilder.append(localTime.minute - 1);
      if (paramArrayList != null) {
        break label134;
      }
    }
    label134:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      localStringBuilder.append(paramArrayList);
      paramArrayList = MD5.toMD5(localStringBuilder.toString());
      return MD5.toMD5(paramArrayList + localStringBuilder.toString());
      localStringBuilder.append(localTime.minute);
      break;
    }
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) || (paramLong2 == 0L)) {}
    long l;
    do
    {
      return false;
      l = System.currentTimeMillis();
    } while ((l < paramLong1) || (l > paramLong2));
    return true;
  }
  
  public static boolean a(String paramString, ArrayList<String> paramArrayList)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while ((!paramString.equals(a(paramArrayList, false))) && (!paramString.equals(a(paramArrayList, true)))) {
      return false;
    }
    return true;
  }
  
  public static boolean a(ArrayList<String> paramArrayList, Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      bool1 = true;
    }
    do
    {
      return bool1;
      paramContext = BaseApplicationImpl.processName;
      bool1 = bool2;
    } while (paramContext == null);
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= paramArrayList.size()) {
        break;
      }
      if (paramContext.equals(paramArrayList.get(i))) {
        return true;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bgyr
 * JD-Core Version:    0.7.0.1
 */