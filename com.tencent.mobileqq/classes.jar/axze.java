import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.now.SmallVideoFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;

public class axze
{
  public static <T> T a(View paramView, Class<T> paramClass)
  {
    if (paramView == null) {}
    do
    {
      return null;
      if (!(paramView.getParent() instanceof AbsListView)) {
        break;
      }
    } while (!a(paramView.getTag().getClass(), paramClass));
    return paramView.getTag();
    return a((View)paramView.getParent(), paramClass);
  }
  
  public static String a(long paramLong)
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = l1 - paramLong;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(l1);
    int i = localCalendar.get(5);
    int j = localCalendar.get(1);
    localCalendar.setTimeInMillis(paramLong);
    int k = localCalendar.get(5);
    int m = localCalendar.get(1);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat();
    if (l2 < 600000L) {
      return anni.a(2131706005);
    }
    if (l2 < 3600000L) {
      return l2 / 60L / 1000L + 1L + anni.a(2131705998);
    }
    if ((l2 < 21600000L) && (k == i)) {
      return l2 / 60L / 60L / 1000L + anni.a(2131705992);
    }
    if ((l2 < 86400000L) && (k == i))
    {
      localSimpleDateFormat.applyPattern("HH:mm");
      return localSimpleDateFormat.format(localCalendar.getTime());
    }
    if ((l2 < 86400000L) && (k != i))
    {
      localSimpleDateFormat.applyPattern("HH:mm");
      return anni.a(2131706003) + localSimpleDateFormat.format(localCalendar.getTime());
    }
    if (m == j)
    {
      localSimpleDateFormat.applyPattern("MM-dd");
      return localSimpleDateFormat.format(localCalendar.getTime());
    }
    localSimpleDateFormat.applyPattern("yyyy-MM-dd");
    return localSimpleDateFormat.format(localCalendar.getTime());
  }
  
  public static void a(Context paramContext, PublishVideoEntry paramPublishVideoEntry, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    File localFile1 = new File(paramPublishVideoEntry.mLocalRawVideoDir + "");
    File localFile2 = new File(paramPublishVideoEntry.thumbPath + "");
    paramPublishVideoEntry = new File(paramPublishVideoEntry.doodlePath + "");
    try
    {
      localJSONObject.put("videoUrl", localFile1.toURI() + "");
      localJSONObject.put("coverUrl", localFile2.toURI() + "");
      localJSONObject.put("doodleUrl", paramPublishVideoEntry.toURI() + "");
      localJSONObject.put("is_local", "1");
      paramPublishVideoEntry = new Bundle();
      paramPublishVideoEntry.putString("preLoadParams", localJSONObject.toString());
      paramPublishVideoEntry.putBoolean("scroll_to_comment", false);
      paramPublishVideoEntry.putString("isLocal", "1");
      paramPublishVideoEntry.putString("_from", "3");
      paramPublishVideoEntry.putString("play_mode", String.valueOf(2));
      paramPublishVideoEntry.putBoolean("is_multi_progress_bar", false);
      paramPublishVideoEntry.putString("feed_type", String.valueOf(paramInt));
      SmallVideoFragment.a(paramContext, paramPublishVideoEntry);
      return;
    }
    catch (JSONException paramPublishVideoEntry)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("NearbyMomentUtils", 2, "getPreviewPage, e=" + paramPublishVideoEntry.toString());
        }
      }
    }
  }
  
  private static boolean a(Class paramClass1, Class paramClass2)
  {
    if ((paramClass1 == Object.class) || (paramClass1 == null)) {
      return false;
    }
    if (paramClass1 == paramClass2) {
      return true;
    }
    return a(paramClass1.getSuperclass(), paramClass2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axze
 * JD-Core Version:    0.7.0.1
 */