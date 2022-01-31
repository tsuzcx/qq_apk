import com.tencent.mfsdk.LeakInspector.LeakInspector.InspectUUID;
import com.tencent.mobileqq.startup.step.InitMagnifierSDK;
import com.tencent.qapmsdk.base.listener.IInspectorListener;
import com.tencent.qapmsdk.common.util.InspectUUID;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class azto
  implements IInspectorListener
{
  public void onCheckingLeaked(int paramInt, @NotNull String paramString) {}
  
  public boolean onFilter(@NotNull Object paramObject)
  {
    return InitMagnifierSDK.a(paramObject);
  }
  
  public void onFinishDump(boolean paramBoolean, @NotNull String paramString1, @NotNull String paramString2)
  {
    InitMagnifierSDK.a(paramBoolean, paramString1, paramString2);
  }
  
  public boolean onLeaked(@NotNull InspectUUID paramInspectUUID)
  {
    LeakInspector.InspectUUID localInspectUUID = null;
    if (paramInspectUUID != null)
    {
      localInspectUUID = new LeakInspector.InspectUUID();
      localInspectUUID.classname = paramInspectUUID.className;
      localInspectUUID.digest = paramInspectUUID.digest;
      localInspectUUID.weakObj = paramInspectUUID.weakObj;
      localInspectUUID.uuid = paramInspectUUID.uuid;
      localInspectUUID.digest = paramInspectUUID.digest;
    }
    return InitMagnifierSDK.a(localInspectUUID);
  }
  
  @NotNull
  public List<String> onPrepareDump(@NotNull String paramString)
  {
    return InitMagnifierSDK.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azto
 * JD-Core Version:    0.7.0.1
 */