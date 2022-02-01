import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.qphone.base.util.QLog;

class anhn
  extends BroadcastReceiver
{
  anhn(anhm paramanhm) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!TextUtils.isEmpty(anhm.a(this.a)))
    {
      int i = paramIntent.getIntExtra("result", -1);
      paramContext = "{ \"ret\": " + i + " }";
      if (QLog.isColorLevel()) {
        QLog.d("BabyQFriendStatusWebViewPlugin", 2, "babyqWeb js req method = setFriendStatus, return = " + paramContext);
      }
      if (i != 0) {
        break label176;
      }
      if (anhm.a(this.a) != null)
      {
        paramContext = new Intent(anhm.a(this.a), ChatActivity.class);
        paramContext.putExtra("uin", anhk.aC);
        paramContext.putExtra("uintype", 0);
        paramContext.putExtra("uinname", "babyQ");
        paramContext.putExtra("selfSet_leftViewText", anhm.a(this.a).getString(2131690563));
        anhm.a(this.a).startActivity(paramContext);
        anhm.a(this.a).finish();
      }
    }
    return;
    label176:
    this.a.callJs(anhm.a(this.a) + "(" + paramContext + ");");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anhn
 * JD-Core Version:    0.7.0.1
 */