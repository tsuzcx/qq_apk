import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import java.util.ArrayList;
import java.util.Iterator;

class birb
  implements INetEventHandler
{
  birb(bira parambira) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    int i = nlw.a();
    Iterator localIterator = bira.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bird)localIterator.next()).a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     birb
 * JD-Core Version:    0.7.0.1
 */