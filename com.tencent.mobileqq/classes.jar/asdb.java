import android.content.Context;
import com.tencent.beacon.event.UserAction;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.dtreport.api.IDTReport;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/dt/QQDtReporter;", "Lcom/tencent/qqlive/module/videoreport/dtreport/api/IDTReport;", "()V", "dtEvent", "", "obj", "", "eventKey", "", "params", "", "isImmediatelyUpload", "appkey", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class asdb
  implements IDTReport
{
  private static volatile asdb a;
  public static final asdc a;
  
  static
  {
    jdField_a_of_type_Asdc = new asdc(null);
  }
  
  @Nullable
  public static final asdb b()
  {
    return jdField_a_of_type_Asdc.a();
  }
  
  public boolean dtEvent(@Nullable Object paramObject, @Nullable String paramString, @Nullable Map<String, String> paramMap, boolean paramBoolean)
  {
    if (paramString == null) {
      return false;
    }
    UserAction.onDTUserAction((Context)BaseApplication.context, paramString, true, -1L, -1L, paramMap, paramBoolean, paramBoolean);
    return true;
  }
  
  public boolean dtEvent(@Nullable Object paramObject, @Nullable String paramString1, @Nullable Map<String, String> paramMap, boolean paramBoolean, @Nullable String paramString2)
  {
    if (paramString1 == null) {
      return false;
    }
    if (paramString2 == null)
    {
      dtEvent(paramObject, paramString1, paramMap, paramBoolean);
      return false;
    }
    UserAction.onDTUserActionToTunnel((Context)BaseApplication.context, paramString2, paramString1, paramMap, paramBoolean, paramBoolean);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asdb
 * JD-Core Version:    0.7.0.1
 */