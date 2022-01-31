import com.tencent.mfsdk.LeakInspector.LeakInspector.InspectUUID;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.startup.step.InitMagnifierSDKData;
import com.tencent.mobileqq.startup.step.InitMagnifierSDKData.LeakListener.1;
import com.tencent.mobileqq.startup.step.InitMagnifierSDKData.LeakListener.2;
import java.util.ArrayList;
import java.util.List;

public class axok
  implements zzt
{
  public List<String> a(String paramString)
  {
    if (BaseActivity.sTopActivity != null) {
      BaseActivity.sTopActivity.runOnUiThread(new InitMagnifierSDKData.LeakListener.1(this, paramString));
    }
    paramString = new ArrayList(4);
    paramString.add(zzq.b());
    paramString.add(zzq.a());
    paramString.addAll(zzq.b());
    return paramString;
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (BaseActivity.sTopActivity != null) {
      BaseActivity.sTopActivity.runOnUiThread(new InitMagnifierSDKData.LeakListener.2(this, paramString1, paramBoolean, paramString2));
    }
  }
  
  public boolean a(LeakInspector.InspectUUID paramInspectUUID)
  {
    return InitMagnifierSDKData.a(paramInspectUUID);
  }
  
  public boolean a(Object paramObject)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     axok
 * JD-Core Version:    0.7.0.1
 */