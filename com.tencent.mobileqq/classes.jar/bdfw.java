import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import java.util.ArrayList;
import java.util.Iterator;

class bdfw
  implements INetEventHandler
{
  bdfw(bdfv parambdfv) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    int i = nam.a();
    Iterator localIterator = bdfv.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bdfy)localIterator.next()).a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdfw
 * JD-Core Version:    0.7.0.1
 */