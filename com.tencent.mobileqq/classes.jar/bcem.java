import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class bcem
  extends BroadcastReceiver
{
  public bcem(VisitorTroopCardFragment paramVisitorTroopCardFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int j = 0;
    paramContext = paramIntent.getAction();
    int i = j;
    if (this.a.a != null)
    {
      i = j;
      if (this.a.a.isHomeworkTroop()) {
        i = 1;
      }
    }
    if ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramContext))
    {
      paramContext = paramIntent.getStringExtra("data");
      if (("onHomeworkTroopIdentityChanged".equals(paramIntent.getStringExtra("event"))) && (i != 0)) {}
    }
    for (;;)
    {
      return;
      if (!TextUtils.isEmpty(paramContext)) {
        try
        {
          paramContext = new JSONObject(paramContext);
          paramIntent = paramContext.optString("groupCode");
          if (TextUtils.equals(this.a.a.troopUin, paramIntent))
          {
            String str1 = paramContext.optString("content");
            String str2 = paramContext.optString("source");
            i = paramContext.optInt("rankId", 333);
            String str3 = paramContext.optString("nickName");
            paramContext.optString("uin");
            paramContext.optString("course");
            paramContext.optString("name");
            if ("join".equals(str2))
            {
              if (QLog.isColorLevel()) {
                QLog.d("wyx", 2, new Object[] { "mHomeworkTroopIdentityChangedReceiver source=join. cGroupOption=", Short.valueOf(this.a.a.cGroupOption), ", joinType=", Integer.valueOf(VisitorTroopCardFragment.a(this.a)) });
              }
              if (VisitorTroopCardFragment.a(this.a) != 1) {
                break label323;
              }
              this.a.e();
            }
            while (QLog.isColorLevel())
            {
              QLog.d("zivonchen", 2, "mHomeworkTroopIdentityChangedReceiver troopUin = " + paramIntent + ", content = " + str1 + ", source = " + str2 + ", rankId = " + i + ", nickName = " + str3);
              return;
              label323:
              if (VisitorTroopCardFragment.a(this.a) == 2) {
                VisitorTroopCardFragment.a(this.a, str1);
              }
            }
            if ("start_recomend_page".equals(paramContext))
            {
              this.a.getActivity().finish();
              return;
            }
          }
        }
        catch (JSONException paramContext) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcem
 * JD-Core Version:    0.7.0.1
 */