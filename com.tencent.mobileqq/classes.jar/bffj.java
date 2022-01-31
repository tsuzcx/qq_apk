import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import java.util.ArrayList;
import java.util.Iterator;

class bffj
  implements INetEventHandler
{
  bffj(bffi parambffi) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    int i = ndd.a();
    Iterator localIterator = bffi.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bffl)localIterator.next()).a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bffj
 * JD-Core Version:    0.7.0.1
 */