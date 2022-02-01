import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import java.util.ArrayList;
import java.util.Iterator;

class bhxp
  implements INetEventHandler
{
  bhxp(bhxo parambhxo) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    int i = HttpUtil.getNetWorkType();
    Iterator localIterator = bhxo.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bhxr)localIterator.next()).a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhxp
 * JD-Core Version:    0.7.0.1
 */