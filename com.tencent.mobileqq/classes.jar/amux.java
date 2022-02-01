import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.initializer.Ace3DEngineInitializer;
import com.tencent.ttpic.openapi.initializer.Face3DLibInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$InitAEEngineTask;", "Lcom/tencent/mobileqq/apollo/utils/task/AsyncTask;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "executeAsync", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class amux
  extends anmo
{
  public amux(@NotNull Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    bmwb.a();
    if (!FeatureManager.loadBasicFeatures())
    {
      QLog.e(amup.a.a(), 1, "[initStepInitAEKitEngine] loadBasicFeatures error");
      a(-5034, "");
      anlx.a("aekit_init", String.valueOf(System.currentTimeMillis() - l), "init AEKit fail");
      return;
    }
    if ((FeatureManager.Features.ACE_3D_ENGINE.init()) && (FeatureManager.Features.FACE_3D_LIB.init())) {}
    for (int i = 1; i == 0; i = 0)
    {
      QLog.e(amup.a.a(), 1, "[initStepInitAEKitEngine] load FACE_3D_LIB error");
      a(-5034, "");
      anlx.a("aekit_init", String.valueOf(System.currentTimeMillis() - l), "init 3DFeature fail");
      return;
    }
    QLog.i(amup.a.a(), 1, "[initStepInitAEKitEngine] success");
    e();
    anlx.a("aekit_init", String.valueOf(System.currentTimeMillis() - l), "success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amux
 * JD-Core Version:    0.7.0.1
 */