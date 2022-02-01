import android.content.Context;
import dov.com.qq.im.ae.cmshow.config.AECMShowConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$AEKitEssentialResDownloadTask;", "Lcom/tencent/mobileqq/apollo/utils/task/AsyncTask;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "materialPath", "", "getMaterialPath", "()Ljava/lang/String;", "setMaterialPath", "(Ljava/lang/String;)V", "executeAsync", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class amuq
  extends anmo
{
  @NotNull
  public String a;
  
  public amuq(@NotNull Context paramContext)
  {
    super(paramContext);
  }
  
  @NotNull
  public final String a()
  {
    String str = this.a;
    if (str == null) {
      Intrinsics.throwUninitializedPropertyAccessException("materialPath");
    }
    return str;
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    bnis.a(AECMShowConfig.ESSENTIAL_RESOURCE_ID_LIST, (bnjf)new amur(this, l));
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amuq
 * JD-Core Version:    0.7.0.1
 */