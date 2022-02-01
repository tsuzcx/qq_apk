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
import dov.com.qq.im.ae.camera.core.AEEditorOrderBroadcastReceiver.AEEditorOrderListener;
import dov.com.qq.im.aeeditor.module.export.AEEditorGenerateRunnable;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class bnst
  implements bnsy, AEEditorOrderBroadcastReceiver.AEEditorOrderListener
{
  private final long jdField_a_of_type_Long = 1000L;
  private AEEditorOrderBroadcastReceiver jdField_a_of_type_DovComQqImAeCameraCoreAEEditorOrderBroadcastReceiver = new AEEditorOrderBroadcastReceiver(this);
  private Map<String, bnsx> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Queue<bnsx> jdField_a_of_type_JavaUtilQueue = new ArrayDeque();
  private boolean jdField_a_of_type_Boolean;
  private final long b;
  
  private bnst()
  {
    this.jdField_b_of_type_Long = 5000L;
    this.jdField_a_of_type_DovComQqImAeCameraCoreAEEditorOrderBroadcastReceiver.registerSelf(BaseApplicationImpl.getContext());
  }
  
  public static bnst a()
  {
    return bnsv.a;
  }
  
  private void a(@NonNull bnsx parambnsx)
  {
    if (this.jdField_a_of_type_JavaUtilQueue.size() == 0)
    {
      bnrh.b("AEEditorProcessManager", "[tryStartTask] size 0");
      this.jdField_a_of_type_JavaUtilQueue.add(parambnsx);
      parambnsx.jdField_b_of_type_Long = System.currentTimeMillis();
      parambnsx.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable.run();
      return;
    }
    bnsx localbnsx = (bnsx)this.jdField_a_of_type_JavaUtilQueue.peek();
    long l = System.currentTimeMillis();
    if ((localbnsx != null) && (Math.abs(l - localbnsx.jdField_b_of_type_Long) > 5000L))
    {
      bnrh.b("AEEditorProcessManager", "[tryStartTask] Dog Dead next Mission");
      this.jdField_a_of_type_JavaUtilQueue.remove(localbnsx);
      this.jdField_a_of_type_JavaUtilQueue.add(parambnsx);
      c();
      return;
    }
    bnrh.b("AEEditorProcessManager", "[tryStartTask]Dog alive");
    this.jdField_a_of_type_JavaUtilQueue.add(parambnsx);
  }
  
  private void b(@NonNull bnsx parambnsx)
  {
    Intent localIntent = new Intent();
    localIntent.setAction(parambnsx.e);
    localIntent.setPackage(BaseApplicationImpl.getContext().getPackageName());
    localIntent.putExtra("generate_materialid", parambnsx.g);
    localIntent.putExtra("generate_materialname", parambnsx.h);
    localIntent.putExtra("generate_filterid", parambnsx.i);
    localIntent.putExtra("generate_scheme", parambnsx.j);
    localIntent.putExtra("generate_show_circle_take_same", parambnsx.jdField_b_of_type_Int);
    localIntent.putExtra("generate_path", parambnsx.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("generate_mission", parambnsx.f);
    localIntent.putExtra("generate_progress", parambnsx.jdField_a_of_type_Float);
    localIntent.putExtra("generate_thumb_ptah", parambnsx.d);
    localIntent.putExtra("generate_errorcode", parambnsx.jdField_a_of_type_Int);
    localIntent.putExtra("generate_source_path", parambnsx.jdField_b_of_type_JavaLangString);
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_JavaUtilQueue.size() == 0) {
      bnrh.b("AEEditorProcessManager", "[tryStartNext] No mission");
    }
    bnsx localbnsx;
    do
    {
      return;
      localbnsx = (bnsx)this.jdField_a_of_type_JavaUtilQueue.peek();
    } while (localbnsx == null);
    bnrh.b("AEEditorProcessManager", "[tryStartNext] next mission");
    localbnsx.jdField_b_of_type_Long = System.currentTimeMillis();
    localbnsx.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable.run();
  }
  
  private void c(@NonNull String paramString)
  {
    bnrh.b("AEEditorProcessManager", "[cancel mission]");
    paramString = (bnsx)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((paramString != null) && (!paramString.e.equals("AEEDITOR_GENERATE_STATUS_READY")))
    {
      paramString = paramString.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable.a();
      if (paramString != null) {
        paramString.cancel();
      }
    }
  }
  
  private void d(@NonNull String paramString)
  {
    bnrh.b("AEEditorProcessManager", "[save mission]");
    bnsx localbnsx = (bnsx)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localbnsx != null)
    {
      bnqu.a().a(paramString, localbnsx.jdField_a_of_type_ComTencentWeseevideoModelMediaModel.toString(), 0);
      bnqu.a().a(paramString + "sourcePath", localbnsx.jdField_b_of_type_JavaLangString, 0);
      bnqu.a().a(paramString + "outputPath", localbnsx.c, 0);
      bnqu.a().a(paramString + "thumbPath", localbnsx.d, 0);
      bnqu.a().a(paramString + "status", localbnsx.e, 0);
      bnqu.a().a(paramString + "materialID", localbnsx.g, 0);
      bnqu.a().a(paramString + "materialName", localbnsx.h, 0);
      bnqu.a().a(paramString + "filterID", localbnsx.i, 0);
      bnqu.a().a(paramString + "scheme", localbnsx.j, 0);
      bnqu.a().a(paramString + "showCircleTakeSame", localbnsx.jdField_b_of_type_Int, 0);
    }
  }
  
  private void e(@NonNull String paramString)
  {
    bnrh.b("AEEditorProcessManager", "[remove mission]");
    bnqu.a().a(paramString, 0);
    bnqu.a().a(paramString + "sourcePath", 0);
    bnqu.a().a(paramString + "outputPath", 0);
    bnqu.a().a(paramString + "thumbPath", 0);
    bnqu.a().a(paramString + "status", 0);
  }
  
  @Nullable
  public MediaModel a(@NonNull String paramString)
  {
    paramString = bnqu.a().a(paramString, "", 0);
    if (!TextUtils.isEmpty(paramString)) {
      return (MediaModel)GsonUtils.json2Obj(paramString, MediaModel.class);
    }
    return null;
  }
  
  public void a()
  {
    if (!bmwb.a()) {
      bnrh.a("AEEditorProcessManager", "AEKitForQQ.init() fail");
    }
    for (;;)
    {
      TAVCut.initTAVCut(BaseApplicationImpl.getContext(), FeatureManager.getResourceDir(), FeatureManager.getResourceDir(), new bnsu(this));
      return;
      if (!FeatureManager.loadBasicFeatures()) {
        bnrh.a("AEEditorProcessManager", "loadBasicFeatures.init() fail");
      }
      if (!FeatureManager.Features.PAG.init()) {
        bnrh.a("AEEditorProcessManager", "PAG.init() fail");
      }
      if (!FeatureManager.Features.IMAGE_ALGO.init()) {
        bnrh.a("AEEditorProcessManager", "IMAGE_ALGO.init() fail");
      }
    }
  }
  
  public void a(@Nullable String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      bnrh.d("AEEditorProcessManager", "[requestGenerateVideo] mission is none");
      return;
    }
    bnsx localbnsx = (bnsx)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localbnsx == null)
    {
      String str1 = bnqu.a().a(paramString + "sourcePath", "", 0);
      String str2 = bnqu.a().a(paramString + "outputPath", "", 0);
      String str3 = bnqu.a().a(paramString + "thumbPath", "", 0);
      Object localObject = bnqu.a().a(paramString + "status", "", 0);
      String str4 = bnqu.a().a(paramString + "materialID", "", 0);
      String str5 = bnqu.a().a(paramString + "materialName", "", 0);
      String str6 = bnqu.a().a(paramString + "filterID", "", 0);
      String str7 = bnqu.a().a(paramString + "scheme", "", 0);
      int i = bnqu.a().a(paramString + "showCircleTakeSame", 0, 0);
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty((CharSequence)localObject)))
      {
        paramString = new bnsx(str4, str5, str6, str7, i, paramString, str1, str2, str3, null);
        paramString.e = "AEEDITOR_GENERATE_STATUS_ERROR";
        paramString.jdField_a_of_type_Int = -2;
        bnrh.d("AEEditorProcessManager", "[requestGenerateVideo] GENERATE_ERROR_NODATA");
        b(paramString);
        return;
      }
      if (((String)localObject).equals("AEEDITOR_GENERATE_STATUS_READY"))
      {
        bnrh.b("AEEditorProcessManager", "[requestGenerateVideo] mission is Ready");
        paramString = new bnsx(str4, str5, str6, str7, i, paramString, str1, str2, str3, null);
        paramString.e = "AEEDITOR_GENERATE_STATUS_READY";
        b(paramString);
        return;
      }
      localObject = a(paramString);
      bnrh.b("AEEditorProcessManager", "[requestGenerateVideo] peak is dead");
      if (localObject == null)
      {
        localbnsx.e = "AEEDITOR_GENERATE_STATUS_ERROR";
        localbnsx.jdField_a_of_type_Int = -2;
        bnrh.d("AEEditorProcessManager", "[requestGenerateVideo] GENERATE_ERROR_NODATA");
        b(localbnsx);
        return;
      }
      a(str4, str5, str6, str7, i, paramString, str1, str2, str3, (MediaModel)localObject);
      return;
    }
    bnrh.b("AEEditorProcessManager", "[requestGenerateVideo] peak is alive");
    a(localbnsx.g, localbnsx.h, localbnsx.i, localbnsx.j, localbnsx.jdField_b_of_type_Int, paramString, localbnsx.jdField_b_of_type_JavaLangString, localbnsx.c, localbnsx.d, localbnsx.jdField_a_of_type_ComTencentWeseevideoModelMediaModel);
  }
  
  public void a(@NonNull String paramString, float paramFloat)
  {
    paramString = (bnsx)this.jdField_a_of_type_JavaUtilMap.get(paramString);
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
    paramString = (bnsx)this.jdField_a_of_type_JavaUtilMap.get(paramString);
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
    bnsx localbnsx = (bnsx)this.jdField_a_of_type_JavaUtilMap.get(paramString1);
    if (localbnsx != null)
    {
      localbnsx.e = "AEEDITOR_GENERATE_STATUS_READY";
      localbnsx.jdField_a_of_type_JavaLangString = paramString2;
      localbnsx.jdField_a_of_type_Float = 1.0F;
      b(localbnsx);
      bnqu.a().a(paramString1 + "status", localbnsx.e, 0);
      this.jdField_a_of_type_JavaUtilQueue.remove(localbnsx);
      c();
    }
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3, @NonNull String paramString4, int paramInt, @NonNull String paramString5, @NonNull String paramString6, @NonNull String paramString7, @NonNull String paramString8, @NonNull MediaModel paramMediaModel)
  {
    if (this.jdField_a_of_type_JavaUtilMap.get(paramString5) == null)
    {
      paramString1 = new bnsx(paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramString7, paramString8, paramMediaModel);
      this.jdField_a_of_type_JavaUtilMap.put(paramString5, paramString1);
      d(paramString5);
    }
    for (;;)
    {
      paramString1.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable = new AEEditorGenerateRunnable(paramString5, paramString6, paramString7, paramMediaModel, this);
      a(paramString1);
      do
      {
        return;
        paramString1 = (bnsx)this.jdField_a_of_type_JavaUtilMap.get(paramString5);
        if (paramString1.e.equals("AEEDITOR_GENERATE_STATUS_ERROR")) {
          break;
        }
      } while (!paramString1.e.equals("AEEDITOR_GENERATE_STATUS_READY"));
      b(paramString1);
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
      if ((((bnsx)localEntry.getValue()).e.equals("AEEDITOR_GENERATE_STATUS_DOWNLOADING")) || (((bnsx)localEntry.getValue()).e.equals("AEEDITOR_GENERATE_STATUS_WAIT"))) {
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAEEditorOrderBroadcastReceiver.unRegisterSelf(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_JavaUtilQueue.clear();
  }
  
  public void b(@NonNull String paramString)
  {
    paramString = (bnsx)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null)
    {
      paramString.jdField_b_of_type_Long = System.currentTimeMillis();
      paramString.e = "AEEDITOR_GENERATE_STATUS_DOWNLOADING";
    }
  }
  
  public void onAEEditorCancel(String paramString)
  {
    c(paramString);
  }
  
  public void onAEEditorRemove(String paramString)
  {
    e(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnst
 * JD-Core Version:    0.7.0.1
 */