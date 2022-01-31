import android.text.TextUtils;
import com.tencent.mobileqq.vip.KCWraperV2.1;
import dualsim.common.IPhoneInfoBridge;

public class beap
  implements IPhoneInfoBridge
{
  public beap(KCWraperV2.1 param1) {}
  
  public String a(String paramString)
  {
    if ("imei".equals(paramString)) {
      return bhsp.a("a4bd32");
    }
    if ("imsi".equals(paramString)) {
      return bhsp.b("a4bd32");
    }
    return "";
  }
  
  public boolean isAllow(String paramString)
  {
    return !TextUtils.isEmpty(a(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beap
 * JD-Core Version:    0.7.0.1
 */