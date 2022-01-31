import com.tencent.mobileqq.highway.netprobe.WeakNetCallback;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

final class axoq
  implements WeakNetCallback
{
  private awrn a = awrn.a(BaseApplication.getContext());
  
  public void onResultOverflow(HashMap<String, String> paramHashMap)
  {
    this.a.a(bahj.a(), "actWeaknetProbe", true, 0L, paramHashMap.size(), paramHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axoq
 * JD-Core Version:    0.7.0.1
 */