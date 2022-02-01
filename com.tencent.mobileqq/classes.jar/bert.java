import com.tencent.mobileqq.highway.netprobe.WeakNetCallback;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

final class bert
  implements WeakNetCallback
{
  private bdmc a = bdmc.a(BaseApplication.getContext());
  
  public void onResultOverflow(HashMap<String, String> paramHashMap)
  {
    this.a.a(bhrl.a(), "actWeaknetProbe", true, 0L, paramHashMap.size(), paramHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bert
 * JD-Core Version:    0.7.0.1
 */