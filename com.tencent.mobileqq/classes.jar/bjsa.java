import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import java.util.ArrayList;
import java.util.Iterator;

class bjsa
  implements INetEventHandler
{
  bjsa(bjrz parambjrz) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    int i = nnr.a();
    Iterator localIterator = bjrz.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bjsc)localIterator.next()).a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjsa
 * JD-Core Version:    0.7.0.1
 */