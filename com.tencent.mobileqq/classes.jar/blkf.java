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

public class blkf
  implements bkta, blkk
{
  private final long jdField_a_of_type_Long = 1000L;
  private AEEditorOrderBroadcastReceiver jdField_a_of_type_DovComQqImAeCameraCoreAEEditorOrderBroadcastReceiver = new AEEditorOrderBroadcastReceiver(this);
  private Map<String, blkj> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Queue<blkj> jdField_a_of_type_JavaUtilQueue = new ArrayDeque();
  private boolean jdField_a_of_type_Boolean;
  private final long b;
  
  private blkf()
  {
    this.jdField_b_of_type_Long = 5000L;
    this.jdField_a_of_type_DovComQqImAeCameraCoreAEEditorOrderBroadcastReceiver.a(BaseApplicationImpl.getContext());
  }
  
  public static blkf a()
  {
    return blkh.a;
  }
  
  @Nullable
  private MediaModel a(@NonNull String paramString)
  {
    paramString = bljc.a().a(paramString, "", 0);
    if (!TextUtils.isEmpty(paramString)) {
      return (MediaModel)GsonUtils.json2Obj(paramString, MediaModel.class);
    }
    return null;
  }
  
  private void a(@NonNull blkj paramblkj)
  {
    if (this.jdField_a_of_type_JavaUtilQueue.size() == 0)
    {
      bljn.b("AEEditorProcessManager", "[tryStartTask] size 0");
      this.jdField_a_of_type_JavaUtilQueue.add(paramblkj);
      paramblkj.jdField_b_of_type_Long = System.currentTimeMillis();
      paramblkj.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable.run();
      return;
    }
    blkj localblkj = (blkj)this.jdField_a_of_type_JavaUtilQueue.peek();
    if (Math.abs(System.currentTimeMillis() - localblkj.jdField_b_of_type_Long) > 5000L)
    {
      bljn.b("AEEditorProcessManager", "[tryStartTask] Dog Dead next Mission");
      this.jdField_a_of_type_JavaUtilQueue.remove(localblkj);
      this.jdField_a_of_type_JavaUtilQueue.add(paramblkj);
      c();
      return;
    }
    bljn.b("AEEditorProcessManager", "[tryStartTask]Dog alive");
    this.jdField_a_of_type_JavaUtilQueue.add(paramblkj);
  }
  
  private void b(@NonNull blkj paramblkj)
  {
    Intent localIntent = new Intent();
    localIntent.setAction(paramblkj.e);
    localIntent.setPackage(BaseApplicationImpl.getContext().getPackageName());
    localIntent.putExtra("generate_path", paramblkj.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("generate_mission", paramblkj.f);
    localIntent.putExtra("generate_progress", paramblkj.jdField_a_of_type_Float);
    localIntent.putExtra("generate_thumb_ptah", paramblkj.d);
    localIntent.putExtra("generate_errorcode", paramblkj.jdField_a_of_type_Int);
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_JavaUtilQueue.size() == 0) {
      bljn.b("AEEditorProcessManager", "[tryStartNext] No mission");
    }
    blkj localblkj;
    do
    {
      return;
      localblkj = (blkj)this.jdField_a_of_type_JavaUtilQueue.peek();
    } while (localblkj == null);
    bljn.b("AEEditorProcessManager", "[tryStartNext] next mission");
    localblkj.jdField_b_of_type_Long = System.currentTimeMillis();
    localblkj.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable.run();
  }
  
  private void f(@NonNull String paramString)
  {
    bljn.b("AEEditorProcessManager", "[cancel mission]");
    paramString = (blkj)this.jdField_a_of_type_JavaUtilMap.get(paramString);
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
    bljn.b("AEEditorProcessManager", "[save mission]");
    blkj localblkj = (blkj)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localblkj != null)
    {
      bljc.a().a(paramString, localblkj.jdField_a_of_type_ComTencentWeseevideoModelMediaModel.toString(), 0);
      bljc.a().a(paramString + "sourcePath", localblkj.jdField_b_of_type_JavaLangString, 0);
      bljc.a().a(paramString + "outputPath", localblkj.c, 0);
      bljc.a().a(paramString + "thumbPath", localblkj.d, 0);
      bljc.a().a(paramString + "status", localblkj.e, 0);
    }
  }
  
  private void h(@NonNull String paramString)
  {
    bljn.b("AEEditorProcessManager", "[remove mission]");
    bljc.a().a(paramString, 0);
    bljc.a().a(paramString + "sourcePath", 0);
    bljc.a().a(paramString + "outputPath", 0);
    bljc.a().a(paramString + "thumbPath", 0);
    bljc.a().a(paramString + "status", 0);
  }
  
  public void a()
  {
    if (!bkoq.a()) {
      bljn.a("AEEditorProcessManager", "AEKitForQQ.init() fail");
    }
    for (;;)
    {
      TAVCut.initTAVCut(BaseApplicationImpl.getContext(), FeatureManager.getResourceDir(), FeatureManager.getResourceDir(), new blkg(this));
      return;
      if (!FeatureManager.loadBasicFeatures()) {
        bljn.a("AEEditorProcessManager", "loadBasicFeatures.init() fail");
      }
      if (!FeatureManager.Features.PAG.init()) {
        bljn.a("AEEditorProcessManager", "PAG.init() fail");
      }
      if (!FeatureManager.Features.IMAGE_ALGO.init()) {
        bljn.a("AEEditorProcessManager", "IMAGE_ALGO.init() fail");
      }
    }
  }
  
  public void a(String paramString)
  {
    f(paramString);
  }
  
  public void a(@NonNull String paramString, float paramFloat)
  {
    paramString = (blkj)this.jdField_a_of_type_JavaUtilMap.get(paramString);
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
    paramString = (blkj)this.jdField_a_of_type_JavaUtilMap.get(paramString);
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
    blkj localblkj = (blkj)this.jdField_a_of_type_JavaUtilMap.get(paramString1);
    if (localblkj != null)
    {
      localblkj.e = "AEEDITOR_GENERATE_STATUS_READY";
      localblkj.jdField_a_of_type_JavaLangString = paramString2;
      localblkj.jdField_a_of_type_Float = 1.0F;
      b(localblkj);
      bljc.a().a(paramString1 + "status", localblkj.e, 0);
      this.jdField_a_of_type_JavaUtilQueue.remove(localblkj);
      c();
    }
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3, @NonNull String paramString4, @NonNull MediaModel paramMediaModel)
  {
    if (this.jdField_a_of_type_JavaUtilMap.get(paramString1) == null)
    {
      paramString4 = new blkj(paramString1, paramString2, paramString3, paramString4, paramMediaModel);
      this.jdField_a_of_type_JavaUtilMap.put(paramString1, paramString4);
    }
    for (;;)
    {
      paramString4.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable = new AEEditorGenerateRunnable(paramString1, paramString2, paramString3, paramMediaModel, this);
      a(paramString4);
      do
      {
        return;
        paramString4 = (blkj)this.jdField_a_of_type_JavaUtilMap.get(paramString1);
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
      if ((((blkj)localEntry.getValue()).e.equals("AEEDITOR_GENERATE_STATUS_DOWNLOADING")) || (((blkj)localEntry.getValue()).e.equals("AEEDITOR_GENERATE_STATUS_WAIT"))) {
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
      bljn.d("AEEditorProcessManager", "[requestGenerateVideo] mission is none");
      return;
    }
    blkj localblkj = (blkj)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localblkj == null)
    {
      String str1 = bljc.a().a(paramString + "sourcePath", "", 0);
      String str2 = bljc.a().a(paramString + "outputPath", "", 0);
      String str3 = bljc.a().a(paramString + "thumbPath", "", 0);
      Object localObject = bljc.a().a(paramString + "status", "", 0);
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty((CharSequence)localObject)))
      {
        paramString = new blkj(paramString, str1, str2, str3, null);
        paramString.e = "AEEDITOR_GENERATE_STATUS_ERROR";
        paramString.jdField_a_of_type_Int = -2;
        bljn.d("AEEditorProcessManager", "[requestGenerateVideo] GENERATE_ERROR_NODATA");
        b(paramString);
        return;
      }
      if (((String)localObject).equals("AEEDITOR_GENERATE_STATUS_READY"))
      {
        bljn.b("AEEditorProcessManager", "[requestGenerateVideo] mission is Ready");
        paramString = new blkj(paramString, str1, str2, str3, null);
        paramString.e = "AEEDITOR_GENERATE_STATUS_READY";
        b(paramString);
        return;
      }
      localObject = a(paramString);
      bljn.b("AEEditorProcessManager", "[requestGenerateVideo] peak is dead");
      if (localObject == null)
      {
        localblkj.e = "AEEDITOR_GENERATE_STATUS_ERROR";
        localblkj.jdField_a_of_type_Int = -2;
        bljn.d("AEEditorProcessManager", "[requestGenerateVideo] GENERATE_ERROR_NODATA");
        b(localblkj);
        return;
      }
      a(paramString, str1, str2, str3, (MediaModel)localObject);
      return;
    }
    bljn.b("AEEditorProcessManager", "[requestGenerateVideo] peak is alive");
    a(paramString, localblkj.jdField_b_of_type_JavaLangString, localblkj.c, localblkj.d, localblkj.jdField_a_of_type_ComTencentWeseevideoModelMediaModel);
  }
  
  public void e(@NonNull String paramString)
  {
    paramString = (blkj)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null)
    {
      paramString.jdField_b_of_type_Long = System.currentTimeMillis();
      paramString.e = "AEEDITOR_GENERATE_STATUS_DOWNLOADING";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blkf
 * JD-Core Version:    0.7.0.1
 */