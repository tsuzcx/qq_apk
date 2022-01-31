import android.text.TextUtils;
import com.tencent.mobileqq.vip.KCWraperV2.1;
import dualsim.common.IPhoneInfoBridge;

public class batx
  implements IPhoneInfoBridge
{
  public batx(KCWraperV2.1 param1) {}
  
  public String a(String paramString)
  {
    if ("imei".equals(paramString)) {
      return befc.a("a4bd32");
    }
    if ("imsi".equals(paramString)) {
      return befc.b("a4bd32");
    }
    return "";
  }
  
  public boolean isAllow(String paramString)
  {
    return !TextUtils.isEmpty(a(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     batx
 * JD-Core Version:    0.7.0.1
 */