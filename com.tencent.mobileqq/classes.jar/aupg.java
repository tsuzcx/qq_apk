import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.util.MQLruCache;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class aupg
  extends BroadcastReceiver
{
  aupg(aupf paramaupf) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (!"com.tencent.qqhead.getheadresp".equals(paramIntent.getAction()))) {}
    do
    {
      int j;
      ArrayList localArrayList;
      do
      {
        return;
        j = paramIntent.getIntExtra("faceType", -1);
        paramContext = paramIntent.getStringArrayListExtra("uinList");
        localArrayList = paramIntent.getStringArrayListExtra("headPathList");
        if (QLog.isColorLevel()) {
          QLog.d("QFlutter.qqface", 2, "onReceive, faceType: " + j + ", uinList: " + paramContext + ", pathList: " + localArrayList);
        }
      } while ((paramContext == null) || (paramContext.isEmpty()) || (localArrayList == null) || (localArrayList.isEmpty()) || (paramContext.size() != localArrayList.size()));
      paramIntent = new ArrayList();
      int i = 0;
      while (i < paramContext.size())
      {
        String str1 = (String)localArrayList.get(i);
        String str2 = (String)paramContext.get(i);
        aupb localaupb = new aupb(j, str2, 3);
        if (aupf.a(this.a, localaupb))
        {
          aupf.a(this.a, j, str2);
          paramIntent.add(localaupb);
          aupf.a(this.a).put(localaupb.c, str1);
        }
        i += 1;
      }
    } while (paramIntent.isEmpty());
    paramContext = aupf.a(this.a).obtainMessage(0);
    paramContext.obj = paramIntent;
    aupf.a(this.a).sendMessage(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aupg
 * JD-Core Version:    0.7.0.1
 */