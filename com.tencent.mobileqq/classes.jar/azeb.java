import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class azeb
  extends BroadcastReceiver
{
  azeb(azea paramazea) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramIntent.getAction())) && ("CommentSendSuccess".equals(paramIntent.getStringExtra("event"))))
    {
      this.a.a = true;
      this.a.dismiss();
      if (QLog.isColorLevel()) {
        QLog.d("PublicCommentPopupWindow", 2, "web call finish----------------");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azeb
 * JD-Core Version:    0.7.0.1
 */