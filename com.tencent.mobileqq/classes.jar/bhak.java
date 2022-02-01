import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/VasStatisticCollector;", "", "()V", "APP_KEY", "", "TAG", "hit", "", "calculateHit", "i", "", "calculateHit$AQQLiteApp_release", "isHit", "report", "", "eventCode", "elapse", "", "params", "", "Lkotlin/Pair;", "(Ljava/lang/String;J[Lkotlin/Pair;)V", "", "reportReal", "isReal", "isImmediately", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bhak
{
  public static final bhak a;
  private static final boolean a;
  
  static
  {
    bhak localbhak = new bhak();
    jdField_a_of_type_Bhak = localbhak;
    UserAction.registerTunnel(new TunnelInfo("00000TEDPU36RWUZ", AppSetting.f(), "1000"));
    if (localbhak.a(100)) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void a(@NotNull String paramString, long paramLong, @Nullable Map<String, String> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "eventCode");
    if (!jdField_a_of_type_Boolean) {
      return;
    }
    a(paramString, paramMap, paramLong, false, false, 24, null);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void a(@NotNull String paramString, long paramLong, @NotNull Pair<String, String>... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "eventCode");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "params");
    if (!jdField_a_of_type_Boolean) {
      return;
    }
    a(paramString, paramLong, MapsKt.toMutableMap(MapsKt.toMap(paramVarArgs)));
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void a(@NotNull String paramString, @Nullable Map<String, String> paramMap, long paramLong)
  {
    a(paramString, paramMap, paramLong, false, false, 24, null);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void a(@NotNull String paramString, @Nullable Map<String, String> paramMap, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "eventCode");
    if (QLog.isColorLevel()) {
      QLog.e("VasStatisticCollector", 1, "eventCode=" + paramString + ", elapse=" + paramLong + ", params=" + String.valueOf(paramMap));
    }
    if (paramMap == null)
    {
      paramMap = new HashMap();
      paramMap.put("qquin", String.valueOf(blek.a()));
      UserAction.onUserActionToTunnel("00000TEDPU36RWUZ", paramString, true, paramLong, -1L, (Map)paramMap, paramBoolean1, paramBoolean2);
      return;
    }
    paramMap.put("qquin", String.valueOf(blek.a()));
    UserAction.onUserActionToTunnel("00000TEDPU36RWUZ", paramString, true, paramLong, -1L, paramMap, paramBoolean1, paramBoolean2);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void a(@NotNull String paramString, @NotNull Pair<String, String>... paramVarArgs)
  {
    a(paramString, 0L, paramVarArgs, 2, null);
  }
  
  @JvmStatic
  public static final boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void b(@NotNull String paramString, long paramLong, @NotNull Pair<String, String>... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "eventCode");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "params");
    a(paramString, MapsKt.toMutableMap(MapsKt.toMap(paramVarArgs)), paramLong, false, false, 24, null);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void b(@NotNull String paramString, @NotNull Pair<String, String>... paramVarArgs)
  {
    b(paramString, 0L, paramVarArgs, 2, null);
  }
  
  public final boolean a(int paramInt)
  {
    return MathKt.roundToInt(Math.floor(paramInt * Math.random())) == paramInt / 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhak
 * JD-Core Version:    0.7.0.1
 */