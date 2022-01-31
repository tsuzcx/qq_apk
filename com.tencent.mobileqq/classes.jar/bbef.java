import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Hashtable;

class bbef
  extends ajxl
{
  private final bbds b;
  
  bbef(bbds parambbds1, bbds parambbds2)
  {
    this.b = parambbds2;
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (bbds.a(this.a) == null) || (!bbds.a(this.a).containsKey(paramString))) {}
    do
    {
      return;
      bbds.a(this.a).remove(paramString);
      if (bbds.a(this.a).size() == 0) {
        bbds.a(this.a).removeObserver(bbds.a(this.a));
      }
      Object localObject = Uri.parse(bbds.a(this.a) + "&uin=" + paramString);
      localObject = new Intent(this.b.h, (Uri)localObject);
      this.a.a.sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
    } while (!QLog.isColorLevel());
    QLog.i("JumpAction", 2, "download head " + paramString + " success. Send broadcast to " + this.b.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbef
 * JD-Core Version:    0.7.0.1
 */