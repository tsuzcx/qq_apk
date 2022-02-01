import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import java.util.ArrayList;
import java.util.Iterator;

class bjir
  implements INetEventHandler
{
  bjir(bjiq parambjiq) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    int i = HttpUtil.getNetWorkType();
    Iterator localIterator = bjiq.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bjit)localIterator.next()).a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjir
 * JD-Core Version:    0.7.0.1
 */