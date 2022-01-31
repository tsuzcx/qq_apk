import com.tencent.mobileqq.highway.netprobe.WeakNetCallback;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

final class bana
  implements WeakNetCallback
{
  private azmz a = azmz.a(BaseApplication.getContext());
  
  public void onResultOverflow(HashMap<String, String> paramHashMap)
  {
    this.a.a(bdhy.a(), "actWeaknetProbe", true, 0L, paramHashMap.size(), paramHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bana
 * JD-Core Version:    0.7.0.1
 */