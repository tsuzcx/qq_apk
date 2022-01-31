import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Hashtable;

class bada
  extends ajjh
{
  private final bacn b;
  
  bada(bacn parambacn1, bacn parambacn2)
  {
    this.b = parambacn2;
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (bacn.a(this.a) == null) || (!bacn.a(this.a).containsKey(paramString))) {}
    do
    {
      return;
      bacn.a(this.a).remove(paramString);
      if (bacn.a(this.a).size() == 0) {
        bacn.a(this.a).removeObserver(bacn.a(this.a));
      }
      Object localObject = Uri.parse(bacn.a(this.a) + "&uin=" + paramString);
      localObject = new Intent(this.b.h, (Uri)localObject);
      this.a.a.sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
    } while (!QLog.isColorLevel());
    QLog.i("JumpAction", 2, "download head " + paramString + " success. Send broadcast to " + this.b.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bada
 * JD-Core Version:    0.7.0.1
 */