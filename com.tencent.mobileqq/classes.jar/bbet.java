import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Hashtable;

class bbet
  extends ajxj
{
  private final bbeg b;
  
  bbet(bbeg parambbeg1, bbeg parambbeg2)
  {
    this.b = parambbeg2;
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (bbeg.a(this.a) == null) || (!bbeg.a(this.a).containsKey(paramString))) {}
    do
    {
      return;
      bbeg.a(this.a).remove(paramString);
      if (bbeg.a(this.a).size() == 0) {
        bbeg.a(this.a).removeObserver(bbeg.a(this.a));
      }
      Object localObject = Uri.parse(bbeg.a(this.a) + "&uin=" + paramString);
      localObject = new Intent(this.b.h, (Uri)localObject);
      this.a.a.sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
    } while (!QLog.isColorLevel());
    QLog.i("JumpAction", 2, "download head " + paramString + " success. Send broadcast to " + this.b.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbet
 * JD-Core Version:    0.7.0.1
 */