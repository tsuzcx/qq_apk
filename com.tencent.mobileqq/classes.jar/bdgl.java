import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import java.util.ArrayList;
import java.util.Iterator;

class bdgl
  implements INetEventHandler
{
  bdgl(bdgk parambdgk) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    int i = naj.a();
    Iterator localIterator = bdgk.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bdgn)localIterator.next()).a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdgl
 * JD-Core Version:    0.7.0.1
 */