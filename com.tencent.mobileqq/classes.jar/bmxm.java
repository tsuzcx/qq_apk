import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.util.LruCache;
import java.util.ArrayList;

class bmxm
  extends BroadcastReceiver
{
  bmxm(bmxk parambmxk) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    wsv.c("Q.qqstory.record.StoryFaceDrawableFactory", "mQQHeadBroadcastReceiver onReceive.");
    if ((paramIntent != null) && ("com.tencent.qqhead.getheadresp".equals(paramIntent.getAction())))
    {
      paramContext = paramIntent.getStringArrayListExtra("uinList");
      paramIntent = paramIntent.getStringArrayListExtra("headPathList");
      int i;
      if ((paramContext != null) && (paramContext.size() > 0) && (paramIntent != null) && (paramIntent.size() > 0))
      {
        wsv.b("Q.qqstory.record.StoryFaceDrawableFactory", "mQQHeadBroadcastReceiver uinList.size()=%d headPathList.size()=%d.", Integer.valueOf(paramContext.size()), Integer.valueOf(paramIntent.size()));
        i = 0;
      }
      while (i < paramContext.size())
      {
        String str = (String)paramContext.get(i);
        if (this.a.a.contains(str))
        {
          this.a.a.remove(str);
          this.a.b.put(str, paramIntent.get(i));
          this.a.a(str, (String)paramIntent.get(i));
        }
        i += 1;
        continue;
        wsv.e("Q.qqstory.record.StoryFaceDrawableFactory", "mQQHeadBroadcastReceiver uinList.size()=0 | headPathList.size()=0.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmxm
 * JD-Core Version:    0.7.0.1
 */