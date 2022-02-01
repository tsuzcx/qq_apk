import com.tencent.mobileqq.pb.PBField;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get.QQAdGetRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcooperation/vip/perload/VasPreloadService$Companion;", "", "()V", "preloadedAd", "", "", "Ltencent/gdt/qq_ad_get$QQAdGetRsp;", "getAd", "businessId", "getAdAsJson", "removeAd", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bmoa
{
  @JvmStatic
  @Nullable
  public final String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "businessId");
    paramString = ((bmoa)this).b(paramString);
    if (paramString != null)
    {
      paramString = achn.a((PBField)paramString);
      if (paramString != null) {
        return paramString.toString();
      }
      return null;
    }
    return null;
  }
  
  @JvmStatic
  @Nullable
  public final qq_ad_get.QQAdGetRsp a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "businessId");
    return (qq_ad_get.QQAdGetRsp)bmny.a().remove(paramString);
  }
  
  @JvmStatic
  @Nullable
  public final qq_ad_get.QQAdGetRsp b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "businessId");
    return (qq_ad_get.QQAdGetRsp)bmny.a().get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmoa
 * JD-Core Version:    0.7.0.1
 */