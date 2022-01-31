import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import java.util.ArrayList;
import java.util.Iterator;

class bcbv
  implements INetEventHandler
{
  bcbv(bcbu parambcbu) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    int i = mpl.a();
    Iterator localIterator = bcbu.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bcbx)localIterator.next()).a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcbv
 * JD-Core Version:    0.7.0.1
 */