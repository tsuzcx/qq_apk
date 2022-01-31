import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Hashtable;

class bdhx
  extends altm
{
  private final bdhk b;
  
  bdhx(bdhk parambdhk1, bdhk parambdhk2)
  {
    this.b = parambdhk2;
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (bdhk.a(this.a) == null) || (!bdhk.a(this.a).containsKey(paramString))) {}
    do
    {
      return;
      bdhk.a(this.a).remove(paramString);
      if (bdhk.a(this.a).size() == 0) {
        bdhk.a(this.a).removeObserver(bdhk.a(this.a));
      }
      Object localObject = Uri.parse(bdhk.a(this.a) + "&uin=" + paramString);
      localObject = new Intent(this.b.h, (Uri)localObject);
      this.a.a.sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
    } while (!QLog.isColorLevel());
    QLog.i("JumpAction", 2, "download head " + paramString + " success. Send broadcast to " + this.b.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdhx
 * JD-Core Version:    0.7.0.1
 */