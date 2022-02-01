import com.tencent.TMG.utils.QLog;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.common.config.AppSetting;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/utils/ApolloDtReportUtil;", "", "()V", "APOLLO_DEBUG_KEY", "", "APOLLO_EVEMT_ROTATE", "APOLLO_EVENT_CHANGE_DRESS", "APOLLO_EVENT_EXPOSE", "APOLLO_EVENT_STAY", "APOLLO_KEY", "APOLLO_MODE_HPME_PAGE", "APOLLO_MODE_MODEL", "APOLLO_PAGE_CODE", "APOLLO_PARAMS_KEY_DURATION", "APOLLO_PARAMS_KEY_ITEMIDS", "TAG", "report", "", "pageCode", "modeCode", "eventCode", "params", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ankl
{
  public static final ankl a = new ankl();
  
  static
  {
    UserAction.registerTunnel(new TunnelInfo("0AND0FB8I14UU93I", AppSetting.f(), "1000"));
  }
  
  @JvmStatic
  public static final void a(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @Nullable Map<String, String> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "pageCode");
    Intrinsics.checkParameterIsNotNull(paramString2, "modeCode");
    Intrinsics.checkParameterIsNotNull(paramString3, "eventCode");
    paramString1 = paramString1 + "#" + paramString2 + "#" + paramString3;
    QLog.d("ApolloDtReportUtil", 1, "report " + paramString1);
    UserAction.onUserActionToTunnel("0AND0FB8I14UU93I", paramString1, paramMap, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ankl
 * JD-Core Version:    0.7.0.1
 */