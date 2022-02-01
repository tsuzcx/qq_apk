import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.QLog;

class anql
  extends BroadcastReceiver
{
  anql(anqk paramanqk) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!TextUtils.isEmpty(anqk.a(this.a)))
    {
      int i = paramIntent.getIntExtra("result", -1);
      paramContext = "{ \"ret\": " + i + " }";
      if (QLog.isColorLevel()) {
        QLog.d("BabyQFriendStatusWebViewPlugin", 2, "babyqWeb js req method = setFriendStatus, return = " + paramContext);
      }
      if (i != 0) {
        break label176;
      }
      if (anqk.a(this.a) != null)
      {
        paramContext = new Intent(anqk.a(this.a), ChatActivity.class);
        paramContext.putExtra("uin", AppConstants.BABY_Q_UIN);
        paramContext.putExtra("uintype", 0);
        paramContext.putExtra("uinname", "babyQ");
        paramContext.putExtra("selfSet_leftViewText", anqk.a(this.a).getString(2131690676));
        anqk.a(this.a).startActivity(paramContext);
        anqk.a(this.a).finish();
      }
    }
    return;
    label176:
    this.a.callJs(anqk.a(this.a) + "(" + paramContext + ");");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anql
 * JD-Core Version:    0.7.0.1
 */