import com.tencent.mobileqq.startup.step.InitMagnifierSDK;
import com.tencent.qapmsdk.base.listener.IMemoryCellingListener;
import com.tencent.qapmsdk.memory.DumpMemInfoHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class azpk
  implements IMemoryCellingListener
{
  public void onAfterDump()
  {
    QLog.i("QAPM_QQ_Impl", 1, "Celling onAfterDump ");
  }
  
  @NotNull
  public List<String> onBeforeDump(@NotNull String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = DumpMemInfoHandler.generateHprof(paramString);
    boolean bool = ((Boolean)paramString[0]).booleanValue();
    if ((bool) && (paramString[1] != null)) {
      localArrayList.add((String)paramString[1]);
    }
    QLog.i("QAPM_QQ_Impl", 1, "Celling onBeforeDump " + bool);
    return localArrayList;
  }
  
  public void onBeforeUploadJson()
  {
    QLog.i("QAPM_QQ_Impl", 1, "Celling onBeforeUploadJson");
  }
  
  public boolean onCanDump(long paramLong)
  {
    InitMagnifierSDK.a(paramLong);
    return false;
  }
  
  public void onLowMemory(long paramLong)
  {
    amfn.a().a(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azpk
 * JD-Core Version:    0.7.0.1
 */