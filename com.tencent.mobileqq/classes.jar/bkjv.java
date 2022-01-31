import com.tencent.mfsdk.LeakInspector.LeakInspector.InspectUUID;
import com.tencent.mobileqq.app.BaseActivity;
import cooperation.weiyun.WeiyunMagnifierSDK.LeakListener.1;
import cooperation.weiyun.WeiyunMagnifierSDK.LeakListener.2;
import java.util.ArrayList;
import java.util.List;

public class bkjv
  implements abvf
{
  public List<String> a(String paramString)
  {
    if (BaseActivity.sTopActivity != null) {
      BaseActivity.sTopActivity.runOnUiThread(new WeiyunMagnifierSDK.LeakListener.1(this, paramString));
    }
    paramString = new ArrayList(4);
    paramString.add(abvc.b());
    paramString.add(abvc.a());
    paramString.addAll(abvc.b());
    return paramString;
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (BaseActivity.sTopActivity != null) {
      BaseActivity.sTopActivity.runOnUiThread(new WeiyunMagnifierSDK.LeakListener.2(this, paramString1, paramBoolean, paramString2));
    }
  }
  
  public boolean a(LeakInspector.InspectUUID paramInspectUUID)
  {
    return this.a.a(paramInspectUUID);
  }
  
  public boolean a(Object paramObject)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkjv
 * JD-Core Version:    0.7.0.1
 */