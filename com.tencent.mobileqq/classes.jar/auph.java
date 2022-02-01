import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class auph
  extends BroadcastReceiver
{
  auph(aupf paramaupf) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int j = 0;
    if ((paramIntent == null) || (!"com.tencent.qqhead.changed".equals(paramIntent.getAction()))) {}
    for (;;)
    {
      return;
      paramContext = paramIntent.getStringExtra("uin");
      int k = paramIntent.getIntExtra("faceType", -1);
      QLog.i("QFlutter.qqface", 1, String.format("mQQFaceChangeReceiver.onReceive uin=%s", new Object[] { paramContext }));
      if (!TextUtils.isEmpty(paramContext))
      {
        paramIntent = aupb.a(k, paramContext);
        int m = paramIntent.length;
        int i = 0;
        while (i < m)
        {
          Object localObject = paramIntent[i];
          aupf.b(this.a).remove(localObject);
          i += 1;
        }
        paramContext = aupb.b(k, paramContext);
        k = paramContext.length;
        i = j;
        while (i < k)
        {
          paramIntent = paramContext[i];
          aupf.a(this.a).remove(paramIntent);
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auph
 * JD-Core Version:    0.7.0.1
 */