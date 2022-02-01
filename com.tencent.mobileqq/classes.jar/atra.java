import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.fragment.HotChatFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class atra
  extends BroadcastReceiver
{
  public atra(HotChatFragment paramHotChatFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.tencent.mobileqq.get_banner_rect".equals(paramIntent.getAction())))
    {
      paramContext = paramIntent.getStringExtra("content");
      if (!TextUtils.isEmpty(paramContext)) {
        break label31;
      }
    }
    label31:
    do
    {
      for (;;)
      {
        return;
        try
        {
          paramContext = new JSONObject(paramContext).getJSONObject("params").getJSONArray("bannerHeight");
          if (paramContext != null)
          {
            float f = this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources().getDisplayMetrics().density;
            int j = paramContext.length();
            this.a.jdField_a_of_type_JavaUtilArrayList.clear();
            int i = 0;
            while (i < j)
            {
              paramIntent = paramContext.getJSONObject(i);
              Rect localRect = new Rect();
              localRect.top = ((int)(paramIntent.getInt("top") * f));
              localRect.bottom = ((int)(paramIntent.getInt("bottom") * f));
              this.a.jdField_a_of_type_JavaUtilArrayList.add(localRect);
              i += 1;
            }
            this.a.d = true;
            return;
          }
        }
        catch (JSONException paramContext) {}
      }
    } while (!QLog.isDevelopLevel());
    paramContext.printStackTrace();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atra
 * JD-Core Version:    0.7.0.1
 */