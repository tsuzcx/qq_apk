import android.content.Context;
import com.tencent.ttpic.filament.CmShowAssetsData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$CmShowResDownloadTask;", "Lcom/tencent/mobileqq/apollo/utils/task/AsyncTask;", "context", "Landroid/content/Context;", "uin", "", "(Landroid/content/Context;Ljava/lang/String;)V", "cmShowAssetsFullData", "Lcom/tencent/ttpic/filament/CmShowAssetsData;", "getCmShowAssetsFullData", "()Lcom/tencent/ttpic/filament/CmShowAssetsData;", "setCmShowAssetsFullData", "(Lcom/tencent/ttpic/filament/CmShowAssetsData;)V", "executeAsync", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class amuu
  extends anmo
{
  @Nullable
  private CmShowAssetsData jdField_a_of_type_ComTencentTtpicFilamentCmShowAssetsData;
  private final String jdField_a_of_type_JavaLangString;
  
  public amuu(@NotNull Context paramContext, @NotNull String paramString)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  @Nullable
  public final CmShowAssetsData a()
  {
    return this.jdField_a_of_type_ComTencentTtpicFilamentCmShowAssetsData;
  }
  
  public void a()
  {
    amlo.a(this.jdField_a_of_type_JavaLangString, (amof)new amuv(this));
  }
  
  public final void a(@Nullable CmShowAssetsData paramCmShowAssetsData)
  {
    this.jdField_a_of_type_ComTencentTtpicFilamentCmShowAssetsData = paramCmShowAssetsData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amuu
 * JD-Core Version:    0.7.0.1
 */