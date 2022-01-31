import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Hashtable;

class bddo
  extends alox
{
  private final bddb b;
  
  bddo(bddb parambddb1, bddb parambddb2)
  {
    this.b = parambddb2;
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (bddb.a(this.a) == null) || (!bddb.a(this.a).containsKey(paramString))) {}
    do
    {
      return;
      bddb.a(this.a).remove(paramString);
      if (bddb.a(this.a).size() == 0) {
        bddb.a(this.a).removeObserver(bddb.a(this.a));
      }
      Object localObject = Uri.parse(bddb.a(this.a) + "&uin=" + paramString);
      localObject = new Intent(this.b.h, (Uri)localObject);
      this.a.a.sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
    } while (!QLog.isColorLevel());
    QLog.i("JumpAction", 2, "download head " + paramString + " success. Send broadcast to " + this.b.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bddo
 * JD-Core Version:    0.7.0.1
 */