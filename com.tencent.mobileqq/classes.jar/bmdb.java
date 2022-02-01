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

public class bmdb
  implements bmdg, AEEditorOrderBroadcastReceiver.AEEditorOrderListener
{
  private final long jdField_a_of_type_Long = 1000L;
  private AEEditorOrderBroadcastReceiver jdField_a_of_type_DovComQqImAeCameraCoreAEEditorOrderBroadcastReceiver = new AEEditorOrderBroadcastReceiver(this);
  private Map<String, bmdf> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Queue<bmdf> jdField_a_of_type_JavaUtilQueue = new ArrayDeque();
  private boolean jdField_a_of_type_Boolean;
  private final long b;
  
  private bmdb()
  {
    this.jdField_b_of_type_Long = 5000L;
    this.jdField_a_of_type_DovComQqImAeCameraCoreAEEditorOrderBroadcastReceiver.registerSelf(BaseApplicationImpl.getContext());
  }
  
  public static bmdb a()
  {
    return bmdd.a;
  }
  
  private void a(@NonNull bmdf parambmdf)
  {
    if (this.jdField_a_of_type_JavaUtilQueue.size() == 0)
    {
      bmbx.b("AEEditorProcessManager", "[tryStartTask] size 0");
      this.jdField_a_of_type_JavaUtilQueue.add(parambmdf);
      parambmdf.jdField_b_of_type_Long = System.currentTimeMillis();
      parambmdf.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable.run();
      return;
    }
    bmdf localbmdf = (bmdf)this.jdField_a_of_type_JavaUtilQueue.peek();
    long l = System.currentTimeMillis();
    if ((localbmdf != null) && (Math.abs(l - localbmdf.jdField_b_of_type_Long) > 5000L))
    {
      bmbx.b("AEEditorProcessManager", "[tryStartTask] Dog Dead next Mission");
      this.jdField_a_of_type_JavaUtilQueue.remove(localbmdf);
      this.jdField_a_of_type_JavaUtilQueue.add(parambmdf);
      c();
      return;
    }
    bmbx.b("AEEditorProcessManager", "[tryStartTask]Dog alive");
    this.jdField_a_of_type_JavaUtilQueue.add(parambmdf);
  }
  
  private void b(@NonNull bmdf parambmdf)
  {
    Intent localIntent = new Intent();
    localIntent.setAction(parambmdf.e);
    localIntent.setPackage(BaseApplicationImpl.getContext().getPackageName());
    localIntent.putExtra("generate_materialid", parambmdf.g);
    localIntent.putExtra("generate_materialname", parambmdf.h);
    localIntent.putExtra("generate_filterid", parambmdf.i);
    localIntent.putExtra("generate_scheme", parambmdf.j);
    localIntent.putExtra("generate_show_circle_take_same", parambmdf.jdField_b_of_type_Int);
    localIntent.putExtra("generate_path", parambmdf.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("generate_mission", parambmdf.f);
    localIntent.putExtra("generate_progress", parambmdf.jdField_a_of_type_Float);
    localIntent.putExtra("generate_thumb_ptah", parambmdf.d);
    localIntent.putExtra("generate_errorcode", parambmdf.jdField_a_of_type_Int);
    localIntent.putExtra("generate_source_path", parambmdf.jdField_b_of_type_JavaLangString);
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_JavaUtilQueue.size() == 0) {
      bmbx.b("AEEditorProcessManager", "[tryStartNext] No mission");
    }
    bmdf localbmdf;
    do
    {
      return;
      localbmdf = (bmdf)this.jdField_a_of_type_JavaUtilQueue.peek();
    } while (localbmdf == null);
    bmbx.b("AEEditorProcessManager", "[tryStartNext] next mission");
    localbmdf.jdField_b_of_type_Long = System.currentTimeMillis();
    localbmdf.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable.run();
  }
  
  private void c(@NonNull String paramString)
  {
    bmbx.b("AEEditorProcessManager", "[cancel mission]");
    paramString = (bmdf)this.jdField_a_of_type_JavaUtilMap.get(paramString);
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
    bmbx.b("AEEditorProcessManager", "[save mission]");
    bmdf localbmdf = (bmdf)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localbmdf != null)
    {
      bmbk.a().a(paramString, localbmdf.jdField_a_of_type_ComTencentWeseevideoModelMediaModel.toString(), 0);
      bmbk.a().a(paramString + "sourcePath", localbmdf.jdField_b_of_type_JavaLangString, 0);
      bmbk.a().a(paramString + "outputPath", localbmdf.c, 0);
      bmbk.a().a(paramString + "thumbPath", localbmdf.d, 0);
      bmbk.a().a(paramString + "status", localbmdf.e, 0);
      bmbk.a().a(paramString + "materialID", localbmdf.g, 0);
      bmbk.a().a(paramString + "materialName", localbmdf.h, 0);
      bmbk.a().a(paramString + "filterID", localbmdf.i, 0);
      bmbk.a().a(paramString + "scheme", localbmdf.j, 0);
      bmbk.a().a(paramString + "showCircleTakeSame", localbmdf.jdField_b_of_type_Int, 0);
    }
  }
  
  private void e(@NonNull String paramString)
  {
    bmbx.b("AEEditorProcessManager", "[remove mission]");
    bmbk.a().a(paramString, 0);
    bmbk.a().a(paramString + "sourcePath", 0);
    bmbk.a().a(paramString + "outputPath", 0);
    bmbk.a().a(paramString + "thumbPath", 0);
    bmbk.a().a(paramString + "status", 0);
  }
  
  @Nullable
  public MediaModel a(@NonNull String paramString)
  {
    paramString = bmbk.a().a(paramString, "", 0);
    if (!TextUtils.isEmpty(paramString)) {
      return (MediaModel)GsonUtils.json2Obj(paramString, MediaModel.class);
    }
    return null;
  }
  
  public void a()
  {
    if (!bljd.a()) {
      bmbx.a("AEEditorProcessManager", "AEKitForQQ.init() fail");
    }
    for (;;)
    {
      TAVCut.initTAVCut(BaseApplicationImpl.getContext(), FeatureManager.getResourceDir(), FeatureManager.getResourceDir(), new bmdc(this));
      return;
      if (!FeatureManager.loadBasicFeatures()) {
        bmbx.a("AEEditorProcessManager", "loadBasicFeatures.init() fail");
      }
      if (!FeatureManager.Features.PAG.init()) {
        bmbx.a("AEEditorProcessManager", "PAG.init() fail");
      }
      if (!FeatureManager.Features.IMAGE_ALGO.init()) {
        bmbx.a("AEEditorProcessManager", "IMAGE_ALGO.init() fail");
      }
    }
  }
  
  public void a(@Nullable String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      bmbx.d("AEEditorProcessManager", "[requestGenerateVideo] mission is none");
      return;
    }
    bmdf localbmdf = (bmdf)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localbmdf == null)
    {
      String str1 = bmbk.a().a(paramString + "sourcePath", "", 0);
      String str2 = bmbk.a().a(paramString + "outputPath", "", 0);
      String str3 = bmbk.a().a(paramString + "thumbPath", "", 0);
      Object localObject = bmbk.a().a(paramString + "status", "", 0);
      String str4 = bmbk.a().a(paramString + "materialID", "", 0);
      String str5 = bmbk.a().a(paramString + "materialName", "", 0);
      String str6 = bmbk.a().a(paramString + "filterID", "", 0);
      String str7 = bmbk.a().a(paramString + "scheme", "", 0);
      int i = bmbk.a().a(paramString + "showCircleTakeSame", 0, 0);
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty((CharSequence)localObject)))
      {
        paramString = new bmdf(str4, str5, str6, str7, i, paramString, str1, str2, str3, null);
        paramString.e = "AEEDITOR_GENERATE_STATUS_ERROR";
        paramString.jdField_a_of_type_Int = -2;
        bmbx.d("AEEditorProcessManager", "[requestGenerateVideo] GENERATE_ERROR_NODATA");
        b(paramString);
        return;
      }
      if (((String)localObject).equals("AEEDITOR_GENERATE_STATUS_READY"))
      {
        bmbx.b("AEEditorProcessManager", "[requestGenerateVideo] mission is Ready");
        paramString = new bmdf(str4, str5, str6, str7, i, paramString, str1, str2, str3, null);
        paramString.e = "AEEDITOR_GENERATE_STATUS_READY";
        b(paramString);
        return;
      }
      localObject = a(paramString);
      bmbx.b("AEEditorProcessManager", "[requestGenerateVideo] peak is dead");
      if (localObject == null)
      {
        localbmdf.e = "AEEDITOR_GENERATE_STATUS_ERROR";
        localbmdf.jdField_a_of_type_Int = -2;
        bmbx.d("AEEditorProcessManager", "[requestGenerateVideo] GENERATE_ERROR_NODATA");
        b(localbmdf);
        return;
      }
      a(str4, str5, str6, str7, i, paramString, str1, str2, str3, (MediaModel)localObject);
      return;
    }
    bmbx.b("AEEditorProcessManager", "[requestGenerateVideo] peak is alive");
    a(localbmdf.g, localbmdf.h, localbmdf.i, localbmdf.j, localbmdf.jdField_b_of_type_Int, paramString, localbmdf.jdField_b_of_type_JavaLangString, localbmdf.c, localbmdf.d, localbmdf.jdField_a_of_type_ComTencentWeseevideoModelMediaModel);
  }
  
  public void a(@NonNull String paramString, float paramFloat)
  {
    paramString = (bmdf)this.jdField_a_of_type_JavaUtilMap.get(paramString);
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
    paramString = (bmdf)this.jdField_a_of_type_JavaUtilMap.get(paramString);
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
    bmdf localbmdf = (bmdf)this.jdField_a_of_type_JavaUtilMap.get(paramString1);
    if (localbmdf != null)
    {
      localbmdf.e = "AEEDITOR_GENERATE_STATUS_READY";
      localbmdf.jdField_a_of_type_JavaLangString = paramString2;
      localbmdf.jdField_a_of_type_Float = 1.0F;
      b(localbmdf);
      bmbk.a().a(paramString1 + "status", localbmdf.e, 0);
      this.jdField_a_of_type_JavaUtilQueue.remove(localbmdf);
      c();
    }
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3, @NonNull String paramString4, int paramInt, @NonNull String paramString5, @NonNull String paramString6, @NonNull String paramString7, @NonNull String paramString8, @NonNull MediaModel paramMediaModel)
  {
    if (this.jdField_a_of_type_JavaUtilMap.get(paramString5) == null)
    {
      paramString1 = new bmdf(paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramString7, paramString8, paramMediaModel);
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
        paramString1 = (bmdf)this.jdField_a_of_type_JavaUtilMap.get(paramString5);
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
      if ((((bmdf)localEntry.getValue()).e.equals("AEEDITOR_GENERATE_STATUS_DOWNLOADING")) || (((bmdf)localEntry.getValue()).e.equals("AEEDITOR_GENERATE_STATUS_WAIT"))) {
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
    paramString = (bmdf)this.jdField_a_of_type_JavaUtilMap.get(paramString);
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
 * Qualified Name:     bmdb
 * JD-Core Version:    0.7.0.1
 */