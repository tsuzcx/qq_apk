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

public class bpbr
  implements boji, bpbw
{
  private final long jdField_a_of_type_Long = 1000L;
  private AEEditorOrderBroadcastReceiver jdField_a_of_type_DovComQqImAeCameraCoreAEEditorOrderBroadcastReceiver = new AEEditorOrderBroadcastReceiver(this);
  private Map<String, bpbv> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Queue<bpbv> jdField_a_of_type_JavaUtilQueue = new ArrayDeque();
  private boolean jdField_a_of_type_Boolean;
  private final long b;
  
  private bpbr()
  {
    this.jdField_b_of_type_Long = 5000L;
    this.jdField_a_of_type_DovComQqImAeCameraCoreAEEditorOrderBroadcastReceiver.a(BaseApplicationImpl.getContext());
  }
  
  public static bpbr a()
  {
    return bpbt.a;
  }
  
  private void a(@NonNull bpbv parambpbv)
  {
    if (this.jdField_a_of_type_JavaUtilQueue.size() == 0)
    {
      bpam.b("AEEditorProcessManager", "[tryStartTask] size 0");
      this.jdField_a_of_type_JavaUtilQueue.add(parambpbv);
      parambpbv.jdField_b_of_type_Long = System.currentTimeMillis();
      parambpbv.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable.run();
      return;
    }
    bpbv localbpbv = (bpbv)this.jdField_a_of_type_JavaUtilQueue.peek();
    if (Math.abs(System.currentTimeMillis() - localbpbv.jdField_b_of_type_Long) > 5000L)
    {
      bpam.b("AEEditorProcessManager", "[tryStartTask] Dog Dead next Mission");
      this.jdField_a_of_type_JavaUtilQueue.remove(localbpbv);
      this.jdField_a_of_type_JavaUtilQueue.add(parambpbv);
      c();
      return;
    }
    bpam.b("AEEditorProcessManager", "[tryStartTask]Dog alive");
    this.jdField_a_of_type_JavaUtilQueue.add(parambpbv);
  }
  
  private void b(@NonNull bpbv parambpbv)
  {
    Intent localIntent = new Intent();
    localIntent.setAction(parambpbv.e);
    localIntent.setPackage(BaseApplicationImpl.getContext().getPackageName());
    localIntent.putExtra("generate_materialid", parambpbv.g);
    localIntent.putExtra("generate_materialname", parambpbv.h);
    localIntent.putExtra("generate_filterid", parambpbv.i);
    localIntent.putExtra("generate_scheme", parambpbv.j);
    localIntent.putExtra("generate_path", parambpbv.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("generate_mission", parambpbv.f);
    localIntent.putExtra("generate_progress", parambpbv.jdField_a_of_type_Float);
    localIntent.putExtra("generate_thumb_ptah", parambpbv.d);
    localIntent.putExtra("generate_errorcode", parambpbv.jdField_a_of_type_Int);
    localIntent.putExtra("generate_source_path", parambpbv.jdField_b_of_type_JavaLangString);
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_JavaUtilQueue.size() == 0) {
      bpam.b("AEEditorProcessManager", "[tryStartNext] No mission");
    }
    bpbv localbpbv;
    do
    {
      return;
      localbpbv = (bpbv)this.jdField_a_of_type_JavaUtilQueue.peek();
    } while (localbpbv == null);
    bpam.b("AEEditorProcessManager", "[tryStartNext] next mission");
    localbpbv.jdField_b_of_type_Long = System.currentTimeMillis();
    localbpbv.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable.run();
  }
  
  private void e(@NonNull String paramString)
  {
    bpam.b("AEEditorProcessManager", "[cancel mission]");
    paramString = (bpbv)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((paramString != null) && (!paramString.e.equals("AEEDITOR_GENERATE_STATUS_READY")))
    {
      paramString = paramString.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable.a();
      if (paramString != null) {
        paramString.cancel();
      }
    }
  }
  
  private void f(@NonNull String paramString)
  {
    bpam.b("AEEditorProcessManager", "[save mission]");
    bpbv localbpbv = (bpbv)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localbpbv != null)
    {
      bozz.a().a(paramString, localbpbv.jdField_a_of_type_ComTencentWeseevideoModelMediaModel.toString(), 0);
      bozz.a().a(paramString + "sourcePath", localbpbv.jdField_b_of_type_JavaLangString, 0);
      bozz.a().a(paramString + "outputPath", localbpbv.c, 0);
      bozz.a().a(paramString + "thumbPath", localbpbv.d, 0);
      bozz.a().a(paramString + "status", localbpbv.e, 0);
      bozz.a().a(paramString + "materialID", localbpbv.g, 0);
      bozz.a().a(paramString + "materialName", localbpbv.h, 0);
      bozz.a().a(paramString + "filterID", localbpbv.i, 0);
      bozz.a().a(paramString + "scheme", localbpbv.j, 0);
    }
  }
  
  private void g(@NonNull String paramString)
  {
    bpam.b("AEEditorProcessManager", "[remove mission]");
    bozz.a().a(paramString, 0);
    bozz.a().a(paramString + "sourcePath", 0);
    bozz.a().a(paramString + "outputPath", 0);
    bozz.a().a(paramString + "thumbPath", 0);
    bozz.a().a(paramString + "status", 0);
  }
  
  @Nullable
  public MediaModel a(@NonNull String paramString)
  {
    paramString = bozz.a().a(paramString, "", 0);
    if (!TextUtils.isEmpty(paramString)) {
      return (MediaModel)GsonUtils.json2Obj(paramString, MediaModel.class);
    }
    return null;
  }
  
  public void a()
  {
    if (!boem.a()) {
      bpam.a("AEEditorProcessManager", "AEKitForQQ.init() fail");
    }
    for (;;)
    {
      TAVCut.initTAVCut(BaseApplicationImpl.getContext(), FeatureManager.getResourceDir(), FeatureManager.getResourceDir(), new bpbs(this));
      return;
      if (!FeatureManager.loadBasicFeatures()) {
        bpam.a("AEEditorProcessManager", "loadBasicFeatures.init() fail");
      }
      if (!FeatureManager.Features.PAG.init()) {
        bpam.a("AEEditorProcessManager", "PAG.init() fail");
      }
      if (!FeatureManager.Features.IMAGE_ALGO.init()) {
        bpam.a("AEEditorProcessManager", "IMAGE_ALGO.init() fail");
      }
    }
  }
  
  public void a(String paramString)
  {
    e(paramString);
  }
  
  public void a(@NonNull String paramString, float paramFloat)
  {
    paramString = (bpbv)this.jdField_a_of_type_JavaUtilMap.get(paramString);
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
    paramString = (bpbv)this.jdField_a_of_type_JavaUtilMap.get(paramString);
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
    bpbv localbpbv = (bpbv)this.jdField_a_of_type_JavaUtilMap.get(paramString1);
    if (localbpbv != null)
    {
      localbpbv.e = "AEEDITOR_GENERATE_STATUS_READY";
      localbpbv.jdField_a_of_type_JavaLangString = paramString2;
      localbpbv.jdField_a_of_type_Float = 1.0F;
      b(localbpbv);
      bozz.a().a(paramString1 + "status", localbpbv.e, 0);
      this.jdField_a_of_type_JavaUtilQueue.remove(localbpbv);
      c();
    }
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3, @NonNull String paramString4, @NonNull String paramString5, @NonNull String paramString6, @NonNull String paramString7, @NonNull String paramString8, @NonNull MediaModel paramMediaModel)
  {
    if (this.jdField_a_of_type_JavaUtilMap.get(paramString5) == null)
    {
      paramString1 = new bpbv(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramMediaModel);
      this.jdField_a_of_type_JavaUtilMap.put(paramString5, paramString1);
      f(paramString5);
    }
    for (;;)
    {
      paramString1.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable = new AEEditorGenerateRunnable(paramString5, paramString6, paramString7, paramMediaModel, this);
      a(paramString1);
      do
      {
        return;
        paramString1 = (bpbv)this.jdField_a_of_type_JavaUtilMap.get(paramString5);
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
      if ((((bpbv)localEntry.getValue()).e.equals("AEEDITOR_GENERATE_STATUS_DOWNLOADING")) || (((bpbv)localEntry.getValue()).e.equals("AEEDITOR_GENERATE_STATUS_WAIT"))) {
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
  
  public void c(@Nullable String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      bpam.d("AEEditorProcessManager", "[requestGenerateVideo] mission is none");
      return;
    }
    bpbv localbpbv = (bpbv)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localbpbv == null)
    {
      String str1 = bozz.a().a(paramString + "sourcePath", "", 0);
      String str2 = bozz.a().a(paramString + "outputPath", "", 0);
      String str3 = bozz.a().a(paramString + "thumbPath", "", 0);
      Object localObject = bozz.a().a(paramString + "status", "", 0);
      String str4 = bozz.a().a(paramString + "materialID", "", 0);
      String str5 = bozz.a().a(paramString + "materialName", "", 0);
      String str6 = bozz.a().a(paramString + "filterID", "", 0);
      String str7 = bozz.a().a(paramString + "scheme", "", 0);
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty((CharSequence)localObject)))
      {
        paramString = new bpbv(str4, str5, str6, str7, paramString, str1, str2, str3, null);
        paramString.e = "AEEDITOR_GENERATE_STATUS_ERROR";
        paramString.jdField_a_of_type_Int = -2;
        bpam.d("AEEditorProcessManager", "[requestGenerateVideo] GENERATE_ERROR_NODATA");
        b(paramString);
        return;
      }
      if (((String)localObject).equals("AEEDITOR_GENERATE_STATUS_READY"))
      {
        bpam.b("AEEditorProcessManager", "[requestGenerateVideo] mission is Ready");
        paramString = new bpbv(str4, str5, str6, str7, paramString, str1, str2, str3, null);
        paramString.e = "AEEDITOR_GENERATE_STATUS_READY";
        b(paramString);
        return;
      }
      localObject = a(paramString);
      bpam.b("AEEditorProcessManager", "[requestGenerateVideo] peak is dead");
      if (localObject == null)
      {
        localbpbv.e = "AEEDITOR_GENERATE_STATUS_ERROR";
        localbpbv.jdField_a_of_type_Int = -2;
        bpam.d("AEEditorProcessManager", "[requestGenerateVideo] GENERATE_ERROR_NODATA");
        b(localbpbv);
        return;
      }
      a(str4, str5, str6, str7, paramString, str1, str2, str3, (MediaModel)localObject);
      return;
    }
    bpam.b("AEEditorProcessManager", "[requestGenerateVideo] peak is alive");
    a(localbpbv.g, localbpbv.h, localbpbv.i, localbpbv.j, paramString, localbpbv.jdField_b_of_type_JavaLangString, localbpbv.c, localbpbv.d, localbpbv.jdField_a_of_type_ComTencentWeseevideoModelMediaModel);
  }
  
  public void d(@NonNull String paramString)
  {
    paramString = (bpbv)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null)
    {
      paramString.jdField_b_of_type_Long = System.currentTimeMillis();
      paramString.e = "AEEDITOR_GENERATE_STATUS_DOWNLOADING";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpbr
 * JD-Core Version:    0.7.0.1
 */