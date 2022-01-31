import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import java.util.ArrayList;
import java.util.Iterator;

class bfjs
  implements INetEventHandler
{
  bfjs(bfjr parambfjr) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    int i = ndd.a();
    Iterator localIterator = bfjr.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bfju)localIterator.next()).a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfjs
 * JD-Core Version:    0.7.0.1
 */