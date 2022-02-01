import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.tavcut.TAVCut;
import com.tencent.tavcut.TAVCut.Callback;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/vas/ui/VasPagView$MyLoader$doLoad$1", "Ldov/com/qq/im/ae/download/AEResManager$AEDownloadCallBack;", "onAEDownloadFinish", "", "aeResInfo", "Ldov/com/qq/im/ae/download/AEResInfo;", "localFilePath", "", "downloaded", "", "errorType", "", "onAEProgressUpdate", "currentOffset", "", "totalLength", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bhug
  implements bnkw
{
  bhug(Function0 paramFunction0) {}
  
  public void onAEDownloadFinish(@NotNull bnkt parambnkt, @NotNull String paramString, boolean paramBoolean, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(parambnkt, "aeResInfo");
    Intrinsics.checkParameterIsNotNull(paramString, "localFilePath");
    bmwb.a();
    TAVCut.initTAVCut((Context)BaseApplicationImpl.getContext(), FeatureManager.getResourceDir(), FeatureManager.getResourceDir(), (TAVCut.Callback)new bhuh(this));
  }
  
  public void onAEProgressUpdate(@NotNull bnkt parambnkt, long paramLong1, long paramLong2)
  {
    Intrinsics.checkParameterIsNotNull(parambnkt, "aeResInfo");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhug
 * JD-Core Version:    0.7.0.1
 */