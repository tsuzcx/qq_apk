import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class aymk
  extends BroadcastReceiver
{
  aymk(aymj paramaymj) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int k = 0;
    if ((paramIntent != null) && ("com.tencent.qqhead.getheadresp".equals(paramIntent.getAction())))
    {
      if (paramIntent.getIntExtra("faceType", -1) != 1) {
        QLog.d("ProfileCardShareHelper", 1, "getHead onReceive FaceType not match!");
      }
    }
    else {
      return;
    }
    if (TextUtils.isEmpty(aymj.a(this.a)))
    {
      QLog.d("ProfileCardShareHelper", 1, "getHead onReceive mUin is empty!");
      return;
    }
    paramContext = paramIntent.getStringArrayListExtra("uinList");
    paramIntent = paramIntent.getStringArrayListExtra("headPathList");
    int j = k;
    int i;
    if (paramContext != null)
    {
      j = k;
      if (paramIntent != null)
      {
        j = k;
        if (paramContext.size() == paramIntent.size()) {
          i = 0;
        }
      }
    }
    for (;;)
    {
      j = k;
      if (i < paramContext.size())
      {
        if (((String)paramContext.get(i)).equals(aymj.a(this.a)))
        {
          aymj.a(this.a, (String)paramIntent.get(i));
          j = 1;
        }
      }
      else
      {
        if ((j == 0) || (!aymj.a(this.a))) {
          break;
        }
        aymj.a(this.a, aymj.b(this.a));
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aymk
 * JD-Core Version:    0.7.0.1
 */