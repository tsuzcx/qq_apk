import com.tencent.tmdatasourcesdk.ITMAssistantExchangeURLListenner;
import com.tencent.tmdatasourcesdk.internal.protocol.jce.AppSimpleDetail;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

class bjte
  implements ITMAssistantExchangeURLListenner
{
  bjte(bjtd parambjtd) {}
  
  public void onExchangedURLSucceed(ArrayList arg1, boolean paramBoolean)
  {
    bjtx.b("DownloadResolver", "onExchangedURLSucceed --- ");
    if ((paramBoolean) && (??? != null) && (???.size() > 0))
    {
      ??? = ???.iterator();
      while (???.hasNext())
      {
        Object localObject1 = ???.next();
        if ((localObject1 instanceof AppSimpleDetail))
        {
          int i = ((AppSimpleDetail)localObject1).versionCode;
          if (i > 0) {
            bjtd.a(this.a).put(((AppSimpleDetail)localObject1).packageName, Integer.valueOf(i));
          }
        }
      }
    }
    synchronized (bjtd.a(this.a))
    {
      bjtd.a(this.a).notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjte
 * JD-Core Version:    0.7.0.1
 */