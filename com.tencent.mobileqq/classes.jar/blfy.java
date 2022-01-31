import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tavcut.TAVCut;
import com.tencent.tavcut.exporter.VideoExporter;
import com.tencent.ttpic.openapi.initializer.ImageAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.PagInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.weseevideo.common.utils.GsonUtils;
import com.tencent.weseevideo.model.MediaModel;
import dov.com.qq.im.ae.camera.core.AEEditorOrderBroadcastReceiver;
import dov.com.qq.im.aeeditor.module.export.AEEditorGenerateRunnable;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class blfy
  implements bkot, blgd
{
  private final long jdField_a_of_type_Long = 1000L;
  private AEEditorOrderBroadcastReceiver jdField_a_of_type_DovComQqImAeCameraCoreAEEditorOrderBroadcastReceiver = new AEEditorOrderBroadcastReceiver(this);
  private Map<String, blgc> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Queue<blgc> jdField_a_of_type_JavaUtilQueue = new ArrayDeque();
  private boolean jdField_a_of_type_Boolean;
  private final long b;
  
  private blfy()
  {
    this.jdField_b_of_type_Long = 5000L;
    this.jdField_a_of_type_DovComQqImAeCameraCoreAEEditorOrderBroadcastReceiver.a(BaseApplicationImpl.getContext());
  }
  
  public static blfy a()
  {
    return blga.a;
  }
  
  @Nullable
  private MediaModel a(@NonNull String paramString)
  {
    paramString = blev.a().a(paramString, "", 0);
    if (!TextUtils.isEmpty(paramString)) {
      return (MediaModel)GsonUtils.json2Obj(paramString, MediaModel.class);
    }
    return null;
  }
  
  private void a(@NonNull blgc paramblgc)
  {
    if (this.jdField_a_of_type_JavaUtilQueue.size() == 0)
    {
      blfg.b("AEEditorProcessManager", "[tryStartTask] size 0");
      this.jdField_a_of_type_JavaUtilQueue.add(paramblgc);
      paramblgc.jdField_b_of_type_Long = System.currentTimeMillis();
      paramblgc.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable.run();
      return;
    }
    blgc localblgc = (blgc)this.jdField_a_of_type_JavaUtilQueue.peek();
    if (Math.abs(System.currentTimeMillis() - localblgc.jdField_b_of_type_Long) > 5000L)
    {
      blfg.b("AEEditorProcessManager", "[tryStartTask] Dog Dead next Mission");
      this.jdField_a_of_type_JavaUtilQueue.remove(localblgc);
      this.jdField_a_of_type_JavaUtilQueue.add(paramblgc);
      c();
      return;
    }
    blfg.b("AEEditorProcessManager", "[tryStartTask]Dog alive");
    this.jdField_a_of_type_JavaUtilQueue.add(paramblgc);
  }
  
  private void b(@NonNull blgc paramblgc)
  {
    Intent localIntent = new Intent();
    localIntent.setAction(paramblgc.e);
    localIntent.setPackage(BaseApplicationImpl.getContext().getPackageName());
    localIntent.putExtra("generate_path", paramblgc.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("generate_mission", paramblgc.f);
    localIntent.putExtra("generate_progress", paramblgc.jdField_a_of_type_Float);
    localIntent.putExtra("generate_thumb_ptah", paramblgc.d);
    localIntent.putExtra("generate_errorcode", paramblgc.jdField_a_of_type_Int);
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_JavaUtilQueue.size() == 0) {
      blfg.b("AEEditorProcessManager", "[tryStartNext] No mission");
    }
    blgc localblgc;
    do
    {
      return;
      localblgc = (blgc)this.jdField_a_of_type_JavaUtilQueue.peek();
    } while (localblgc == null);
    blfg.b("AEEditorProcessManager", "[tryStartNext] next mission");
    localblgc.jdField_b_of_type_Long = System.currentTimeMillis();
    localblgc.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable.run();
  }
  
  private void f(@NonNull String paramString)
  {
    blfg.b("AEEditorProcessManager", "[cancel mission]");
    paramString = (blgc)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((paramString != null) && (!paramString.e.equals("AEEDITOR_GENERATE_STATUS_READY")))
    {
      paramString = paramString.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable.a();
      if (paramString != null) {
        paramString.cancel();
      }
    }
  }
  
  private void g(@NonNull String paramString)
  {
    blfg.b("AEEditorProcessManager", "[save mission]");
    blgc localblgc = (blgc)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localblgc != null)
    {
      blev.a().a(paramString, localblgc.jdField_a_of_type_ComTencentWeseevideoModelMediaModel.toString(), 0);
      blev.a().a(paramString + "sourcePath", localblgc.jdField_b_of_type_JavaLangString, 0);
      blev.a().a(paramString + "outputPath", localblgc.c, 0);
      blev.a().a(paramString + "thumbPath", localblgc.d, 0);
      blev.a().a(paramString + "status", localblgc.e, 0);
    }
  }
  
  private void h(@NonNull String paramString)
  {
    blfg.b("AEEditorProcessManager", "[remove mission]");
    blev.a().a(paramString, 0);
    blev.a().a(paramString + "sourcePath", 0);
    blev.a().a(paramString + "outputPath", 0);
    blev.a().a(paramString + "thumbPath", 0);
    blev.a().a(paramString + "status", 0);
  }
  
  public void a()
  {
    if (!bkkj.a()) {
      blfg.a("AEEditorProcessManager", "AEKitForQQ.init() fail");
    }
    for (;;)
    {
      TAVCut.initTAVCut(BaseApplicationImpl.getContext(), FeatureManager.getResourceDir(), FeatureManager.getResourceDir(), new blfz(this));
      return;
      if (!FeatureManager.loadBasicFeatures()) {
        blfg.a("AEEditorProcessManager", "loadBasicFeatures.init() fail");
      }
      if (!FeatureManager.Features.PAG.init()) {
        blfg.a("AEEditorProcessManager", "PAG.init() fail");
      }
      if (!FeatureManager.Features.IMAGE_ALGO.init()) {
        blfg.a("AEEditorProcessManager", "IMAGE_ALGO.init() fail");
      }
    }
  }
  
  public void a(String paramString)
  {
    f(paramString);
  }
  
  public void a(@NonNull String paramString, float paramFloat)
  {
    paramString = (blgc)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null)
    {
      paramString.jdField_b_of_type_Long = System.currentTimeMillis();
      paramString.jdField_a_of_type_Float = paramFloat;
      long l = System.currentTimeMillis();
      if (Math.abs(l - paramString.jdField_a_of_type_Long) > 1000L)
      {
        paramString.jdField_a_of_type_Long = l;
        b(paramString);
      }
    }
  }
  
  public void a(@NonNull String paramString, int paramInt)
  {
    paramString = (blgc)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null)
    {
      paramString.e = "AEEDITOR_GENERATE_STATUS_ERROR";
      paramString.jdField_a_of_type_Float = 0.0F;
      paramString.jdField_a_of_type_Int = paramInt;
      b(paramString);
      this.jdField_a_of_type_JavaUtilQueue.remove(paramString);
      c();
    }
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2)
  {
    blgc localblgc = (blgc)this.jdField_a_of_type_JavaUtilMap.get(paramString1);
    if (localblgc != null)
    {
      localblgc.e = "AEEDITOR_GENERATE_STATUS_READY";
      localblgc.jdField_a_of_type_JavaLangString = paramString2;
      localblgc.jdField_a_of_type_Float = 1.0F;
      b(localblgc);
      blev.a().a(paramString1 + "status", localblgc.e, 0);
      this.jdField_a_of_type_JavaUtilQueue.remove(localblgc);
      c();
    }
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3, @NonNull String paramString4, @NonNull MediaModel paramMediaModel)
  {
    if (this.jdField_a_of_type_JavaUtilMap.get(paramString1) == null)
    {
      paramString4 = new blgc(paramString1, paramString2, paramString3, paramString4, paramMediaModel);
      this.jdField_a_of_type_JavaUtilMap.put(paramString1, paramString4);
    }
    for (;;)
    {
      paramString4.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable = new AEEditorGenerateRunnable(paramString1, paramString2, paramString3, paramMediaModel, this);
      a(paramString4);
      do
      {
        return;
        paramString4 = (blgc)this.jdField_a_of_type_JavaUtilMap.get(paramString1);
        if (paramString4.e.equals("AEEDITOR_GENERATE_STATUS_ERROR")) {
          break;
        }
      } while (!paramString4.e.equals("AEEDITOR_GENERATE_STATUS_READY"));
      b(paramString4);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((((blgc)localEntry.getValue()).e.equals("AEEDITOR_GENERATE_STATUS_DOWNLOADING")) || (((blgc)localEntry.getValue()).e.equals("AEEDITOR_GENERATE_STATUS_WAIT"))) {
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAEEditorOrderBroadcastReceiver.b(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_JavaUtilQueue.clear();
  }
  
  public void b(String paramString)
  {
    g(paramString);
  }
  
  public void c(String paramString)
  {
    h(paramString);
  }
  
  public void d(@Nullable String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      blfg.d("AEEditorProcessManager", "[requestGenerateVideo] mission is none");
      return;
    }
    blgc localblgc = (blgc)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localblgc == null)
    {
      String str1 = blev.a().a(paramString + "sourcePath", "", 0);
      String str2 = blev.a().a(paramString + "outputPath", "", 0);
      String str3 = blev.a().a(paramString + "thumbPath", "", 0);
      Object localObject = blev.a().a(paramString + "status", "", 0);
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty((CharSequence)localObject)))
      {
        paramString = new blgc(paramString, str1, str2, str3, null);
        paramString.e = "AEEDITOR_GENERATE_STATUS_ERROR";
        paramString.jdField_a_of_type_Int = -2;
        blfg.d("AEEditorProcessManager", "[requestGenerateVideo] GENERATE_ERROR_NODATA");
        b(paramString);
        return;
      }
      if (((String)localObject).equals("AEEDITOR_GENERATE_STATUS_READY"))
      {
        blfg.b("AEEditorProcessManager", "[requestGenerateVideo] mission is Ready");
        paramString = new blgc(paramString, str1, str2, str3, null);
        paramString.e = "AEEDITOR_GENERATE_STATUS_READY";
        b(paramString);
        return;
      }
      localObject = a(paramString);
      blfg.b("AEEditorProcessManager", "[requestGenerateVideo] peak is dead");
      if (localObject == null)
      {
        localblgc.e = "AEEDITOR_GENERATE_STATUS_ERROR";
        localblgc.jdField_a_of_type_Int = -2;
        blfg.d("AEEditorProcessManager", "[requestGenerateVideo] GENERATE_ERROR_NODATA");
        b(localblgc);
        return;
      }
      a(paramString, str1, str2, str3, (MediaModel)localObject);
      return;
    }
    blfg.b("AEEditorProcessManager", "[requestGenerateVideo] peak is alive");
    a(paramString, localblgc.jdField_b_of_type_JavaLangString, localblgc.c, localblgc.d, localblgc.jdField_a_of_type_ComTencentWeseevideoModelMediaModel);
  }
  
  public void e(@NonNull String paramString)
  {
    paramString = (blgc)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null)
    {
      paramString.jdField_b_of_type_Long = System.currentTimeMillis();
      paramString.e = "AEEDITOR_GENERATE_STATUS_DOWNLOADING";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blfy
 * JD-Core Version:    0.7.0.1
 */