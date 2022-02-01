import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;

final class avel
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    String str2 = null;
    long l = NetConnInfoCenter.getServerTimeMillis();
    if (Math.abs(l - avek.a()) < 1000L) {}
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              EventCollector.getInstance().onViewClicked(paramView);
              return;
              avek.a(l);
            } while ((paramView == null) || (paramView.getContext() == null));
            localObject1 = paramView.getContext();
          } while (!(localObject1 instanceof Activity));
          localObject1 = (Activity)localObject1;
        } while (((Activity)localObject1).isFinishing());
        localObject2 = paramView.getTag(-1);
      } while (!(localObject2 instanceof String));
      localObject2 = (String)localObject2;
    } while (TextUtils.isEmpty((CharSequence)localObject2));
    Object localObject3 = ((String)localObject2).substring(0, 6).toLowerCase();
    for (;;)
    {
      int j;
      int k;
      try
      {
        if ((!((String)localObject3).startsWith("http")) && (!((String)localObject3).startsWith("https"))) {
          break label415;
        }
        localObject3 = new Intent((Context)localObject1, QQBrowserActivity.class);
        ((Intent)localObject3).putExtra("url", (String)localObject2);
        ((Intent)localObject3).putExtra("startOpenPageTime", System.currentTimeMillis());
        ((Activity)localObject1).startActivityForResult((Intent)localObject3, -1);
        localObject2 = paramView.getTag(-4);
        if (!(localObject2 instanceof String)) {
          break;
        }
        localObject1 = paramView.getTag(-2);
        localObject3 = paramView.getTag(-3);
        Object localObject4 = paramView.getTag(-5);
        if ((!(localObject1 instanceof Integer)) || (!(localObject3 instanceof Integer)) || (!(localObject4 instanceof Integer))) {
          break;
        }
        int i = ((Integer)localObject1).intValue();
        j = ((Integer)localObject3).intValue();
        k = ((Integer)localObject4).intValue();
        if ((i == 0) || (j == 0)) {
          break label483;
        }
        aveh.a().a((String)localObject2, ((Integer)localObject1).intValue(), ((Integer)localObject3).intValue());
      }
      catch (Throwable localThrowable) {}
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break;
      }
      localObject3 = new HashMap();
      ((Map)localObject3).put(Integer.valueOf(2), j + "");
      ((Map)localObject3).put(Integer.valueOf(4), "20");
      abuf.a(null, "870", (String)localObject1, (String)localObject2, str2, "1", "145", (Map)localObject3);
      break;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      localThrowable.printStackTrace();
      break;
      label415:
      if (((String)localObject3).startsWith("mqqapi"))
      {
        localObject3 = new Intent(localThrowable, JumpActivity.class);
        ((Intent)localObject3).setData(Uri.parse((String)localObject2));
        localThrowable.startActivityForResult((Intent)localObject3, -1);
        continue;
        label483:
        do
        {
          if (k == 2)
          {
            str2 = "87007";
            str1 = "206676";
            break;
          }
          str1 = null;
          break;
        } while ((k != 1) && (k != 0));
        str2 = "87006";
        String str1 = "206675";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avel
 * JD-Core Version:    0.7.0.1
 */