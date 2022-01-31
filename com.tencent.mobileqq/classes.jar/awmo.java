import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class awmo
  extends BroadcastReceiver
{
  awmo(awmn paramawmn) {}
  
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
    if (TextUtils.isEmpty(awmn.a(this.a)))
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
        if (((String)paramContext.get(i)).equals(awmn.a(this.a)))
        {
          awmn.a(this.a, (String)paramIntent.get(i));
          j = 1;
        }
      }
      else
      {
        if ((j == 0) || (!awmn.a(this.a))) {
          break;
        }
        awmn.a(this.a, awmn.b(this.a));
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awmo
 * JD-Core Version:    0.7.0.1
 */