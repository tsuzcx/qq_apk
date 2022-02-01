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

public class bnzw
  implements bnia, boab
{
  private final long jdField_a_of_type_Long = 1000L;
  private AEEditorOrderBroadcastReceiver jdField_a_of_type_DovComQqImAeCameraCoreAEEditorOrderBroadcastReceiver = new AEEditorOrderBroadcastReceiver(this);
  private Map<String, boaa> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Queue<boaa> jdField_a_of_type_JavaUtilQueue = new ArrayDeque();
  private boolean jdField_a_of_type_Boolean;
  private final long b;
  
  private bnzw()
  {
    this.jdField_b_of_type_Long = 5000L;
    this.jdField_a_of_type_DovComQqImAeCameraCoreAEEditorOrderBroadcastReceiver.a(BaseApplicationImpl.getContext());
  }
  
  public static bnzw a()
  {
    return bnzy.a;
  }
  
  private void a(@NonNull boaa paramboaa)
  {
    if (this.jdField_a_of_type_JavaUtilQueue.size() == 0)
    {
      bnzb.b("AEEditorProcessManager", "[tryStartTask] size 0");
      this.jdField_a_of_type_JavaUtilQueue.add(paramboaa);
      paramboaa.jdField_b_of_type_Long = System.currentTimeMillis();
      paramboaa.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable.run();
      return;
    }
    boaa localboaa = (boaa)this.jdField_a_of_type_JavaUtilQueue.peek();
    if (Math.abs(System.currentTimeMillis() - localboaa.jdField_b_of_type_Long) > 5000L)
    {
      bnzb.b("AEEditorProcessManager", "[tryStartTask] Dog Dead next Mission");
      this.jdField_a_of_type_JavaUtilQueue.remove(localboaa);
      this.jdField_a_of_type_JavaUtilQueue.add(paramboaa);
      c();
      return;
    }
    bnzb.b("AEEditorProcessManager", "[tryStartTask]Dog alive");
    this.jdField_a_of_type_JavaUtilQueue.add(paramboaa);
  }
  
  private void b(@NonNull boaa paramboaa)
  {
    Intent localIntent = new Intent();
    localIntent.setAction(paramboaa.e);
    localIntent.setPackage(BaseApplicationImpl.getContext().getPackageName());
    localIntent.putExtra("generate_materialid", paramboaa.g);
    localIntent.putExtra("generate_materialname", paramboaa.h);
    localIntent.putExtra("generate_filterid", paramboaa.i);
    localIntent.putExtra("generate_scheme", paramboaa.j);
    localIntent.putExtra("generate_path", paramboaa.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("generate_mission", paramboaa.f);
    localIntent.putExtra("generate_progress", paramboaa.jdField_a_of_type_Float);
    localIntent.putExtra("generate_thumb_ptah", paramboaa.d);
    localIntent.putExtra("generate_errorcode", paramboaa.jdField_a_of_type_Int);
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_JavaUtilQueue.size() == 0) {
      bnzb.b("AEEditorProcessManager", "[tryStartNext] No mission");
    }
    boaa localboaa;
    do
    {
      return;
      localboaa = (boaa)this.jdField_a_of_type_JavaUtilQueue.peek();
    } while (localboaa == null);
    bnzb.b("AEEditorProcessManager", "[tryStartNext] next mission");
    localboaa.jdField_b_of_type_Long = System.currentTimeMillis();
    localboaa.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable.run();
  }
  
  private void e(@NonNull String paramString)
  {
    bnzb.b("AEEditorProcessManager", "[cancel mission]");
    paramString = (boaa)this.jdField_a_of_type_JavaUtilMap.get(paramString);
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
    bnzb.b("AEEditorProcessManager", "[save mission]");
    boaa localboaa = (boaa)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localboaa != null)
    {
      bnyp.a().a(paramString, localboaa.jdField_a_of_type_ComTencentWeseevideoModelMediaModel.toString(), 0);
      bnyp.a().a(paramString + "sourcePath", localboaa.jdField_b_of_type_JavaLangString, 0);
      bnyp.a().a(paramString + "outputPath", localboaa.c, 0);
      bnyp.a().a(paramString + "thumbPath", localboaa.d, 0);
      bnyp.a().a(paramString + "status", localboaa.e, 0);
      bnyp.a().a(paramString + "materialID", localboaa.g, 0);
      bnyp.a().a(paramString + "materialName", localboaa.h, 0);
      bnyp.a().a(paramString + "filterID", localboaa.i, 0);
      bnyp.a().a(paramString + "scheme", localboaa.j, 0);
    }
  }
  
  private void g(@NonNull String paramString)
  {
    bnzb.b("AEEditorProcessManager", "[remove mission]");
    bnyp.a().a(paramString, 0);
    bnyp.a().a(paramString + "sourcePath", 0);
    bnyp.a().a(paramString + "outputPath", 0);
    bnyp.a().a(paramString + "thumbPath", 0);
    bnyp.a().a(paramString + "status", 0);
  }
  
  @Nullable
  public MediaModel a(@NonNull String paramString)
  {
    paramString = bnyp.a().a(paramString, "", 0);
    if (!TextUtils.isEmpty(paramString)) {
      return (MediaModel)GsonUtils.json2Obj(paramString, MediaModel.class);
    }
    return null;
  }
  
  public void a()
  {
    if (!bndd.a()) {
      bnzb.a("AEEditorProcessManager", "AEKitForQQ.init() fail");
    }
    for (;;)
    {
      TAVCut.initTAVCut(BaseApplicationImpl.getContext(), FeatureManager.getResourceDir(), FeatureManager.getResourceDir(), new bnzx(this));
      return;
      if (!FeatureManager.loadBasicFeatures()) {
        bnzb.a("AEEditorProcessManager", "loadBasicFeatures.init() fail");
      }
      if (!FeatureManager.Features.PAG.init()) {
        bnzb.a("AEEditorProcessManager", "PAG.init() fail");
      }
      if (!FeatureManager.Features.IMAGE_ALGO.init()) {
        bnzb.a("AEEditorProcessManager", "IMAGE_ALGO.init() fail");
      }
    }
  }
  
  public void a(String paramString)
  {
    e(paramString);
  }
  
  public void a(@NonNull String paramString, float paramFloat)
  {
    paramString = (boaa)this.jdField_a_of_type_JavaUtilMap.get(paramString);
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
    paramString = (boaa)this.jdField_a_of_type_JavaUtilMap.get(paramString);
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
    boaa localboaa = (boaa)this.jdField_a_of_type_JavaUtilMap.get(paramString1);
    if (localboaa != null)
    {
      localboaa.e = "AEEDITOR_GENERATE_STATUS_READY";
      localboaa.jdField_a_of_type_JavaLangString = paramString2;
      localboaa.jdField_a_of_type_Float = 1.0F;
      b(localboaa);
      bnyp.a().a(paramString1 + "status", localboaa.e, 0);
      this.jdField_a_of_type_JavaUtilQueue.remove(localboaa);
      c();
    }
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3, @NonNull String paramString4, @NonNull String paramString5, @NonNull String paramString6, @NonNull String paramString7, @NonNull String paramString8, @NonNull MediaModel paramMediaModel)
  {
    if (this.jdField_a_of_type_JavaUtilMap.get(paramString5) == null)
    {
      paramString1 = new boaa(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramMediaModel);
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
        paramString1 = (boaa)this.jdField_a_of_type_JavaUtilMap.get(paramString5);
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
      if ((((boaa)localEntry.getValue()).e.equals("AEEDITOR_GENERATE_STATUS_DOWNLOADING")) || (((boaa)localEntry.getValue()).e.equals("AEEDITOR_GENERATE_STATUS_WAIT"))) {
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
      bnzb.d("AEEditorProcessManager", "[requestGenerateVideo] mission is none");
      return;
    }
    boaa localboaa = (boaa)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localboaa == null)
    {
      String str1 = bnyp.a().a(paramString + "sourcePath", "", 0);
      String str2 = bnyp.a().a(paramString + "outputPath", "", 0);
      String str3 = bnyp.a().a(paramString + "thumbPath", "", 0);
      Object localObject = bnyp.a().a(paramString + "status", "", 0);
      String str4 = bnyp.a().a(paramString + "materialID", "", 0);
      String str5 = bnyp.a().a(paramString + "materialName", "", 0);
      String str6 = bnyp.a().a(paramString + "filterID", "", 0);
      String str7 = bnyp.a().a(paramString + "scheme", "", 0);
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty((CharSequence)localObject)))
      {
        paramString = new boaa(str4, str5, str6, str7, paramString, str1, str2, str3, null);
        paramString.e = "AEEDITOR_GENERATE_STATUS_ERROR";
        paramString.jdField_a_of_type_Int = -2;
        bnzb.d("AEEditorProcessManager", "[requestGenerateVideo] GENERATE_ERROR_NODATA");
        b(paramString);
        return;
      }
      if (((String)localObject).equals("AEEDITOR_GENERATE_STATUS_READY"))
      {
        bnzb.b("AEEditorProcessManager", "[requestGenerateVideo] mission is Ready");
        paramString = new boaa(str4, str5, str6, str7, paramString, str1, str2, str3, null);
        paramString.e = "AEEDITOR_GENERATE_STATUS_READY";
        b(paramString);
        return;
      }
      localObject = a(paramString);
      bnzb.b("AEEditorProcessManager", "[requestGenerateVideo] peak is dead");
      if (localObject == null)
      {
        localboaa.e = "AEEDITOR_GENERATE_STATUS_ERROR";
        localboaa.jdField_a_of_type_Int = -2;
        bnzb.d("AEEditorProcessManager", "[requestGenerateVideo] GENERATE_ERROR_NODATA");
        b(localboaa);
        return;
      }
      a(str4, str5, str6, str7, paramString, str1, str2, str3, (MediaModel)localObject);
      return;
    }
    bnzb.b("AEEditorProcessManager", "[requestGenerateVideo] peak is alive");
    a(localboaa.g, localboaa.h, localboaa.i, localboaa.j, paramString, localboaa.jdField_b_of_type_JavaLangString, localboaa.c, localboaa.d, localboaa.jdField_a_of_type_ComTencentWeseevideoModelMediaModel);
  }
  
  public void d(@NonNull String paramString)
  {
    paramString = (boaa)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null)
    {
      paramString.jdField_b_of_type_Long = System.currentTimeMillis();
      paramString.e = "AEEDITOR_GENERATE_STATUS_DOWNLOADING";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnzw
 * JD-Core Version:    0.7.0.1
 */