import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.ttpic.openai.ttpicmodule.AEHandDetector;
import com.tencent.ttpic.openapi.initializer.Feature;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.ttpicmodule.PTEmotionDetector;
import com.tencent.ttpic.openapi.ttpicmodule.module_hair_segment.PTHairSegmenter;
import com.tencent.ttpic.openapi.ttpicmodule.module_human_segment.PTHumanSegmenter;
import com.tencent.ttpic.openapi.ttpicmodule.module_sky_segment.PTSkySegmenter;
import com.tencent.ttpic.openapi.ttpicmodule.module_sky_segment.SkySegmentInitializer;
import dov.com.qq.im.ae.camera.ui.dashboard.AEDashboardUtil.1;
import dov.com.qq.im.ae.camera.ui.dashboard.AEDashboardUtil.2;
import dov.com.qq.im.ae.camera.ui.dashboard.AEDashboardUtil.3;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class bnep
{
  private static final MutableLiveData<bnet> jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
  public static final bneu a;
  private static final List<Feature> jdField_a_of_type_JavaUtilList;
  private static final List<Pair<String, Integer>> b;
  private static final List<bnet> c;
  
  static
  {
    jdField_a_of_type_Bneu = new bneu();
    jdField_a_of_type_JavaUtilList = new LinkedList();
    b = new LinkedList();
    c = new LinkedList();
    jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
    if (a())
    {
      a();
      b();
      c();
    }
  }
  
  public static MutableLiveData<bnet> a()
  {
    return jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  public static List<bnet> a(@Nullable bnet parambnet)
  {
    LinkedList localLinkedList = new LinkedList(c);
    if ((parambnet == null) || (TextUtils.isEmpty(parambnet.jdField_a_of_type_JavaLangString))) {
      return localLinkedList;
    }
    Iterator localIterator = localLinkedList.iterator();
    while (localIterator.hasNext())
    {
      bnet localbnet = (bnet)localIterator.next();
      if ((localbnet != null) && (!TextUtils.isEmpty(localbnet.jdField_a_of_type_JavaLangString)) && (localbnet.jdField_a_of_type_JavaLangString.equals(parambnet.jdField_a_of_type_JavaLangString)))
      {
        localbnet.b = parambnet.b;
        localbnet.c = parambnet.c;
      }
    }
    return localLinkedList;
  }
  
  private static void a()
  {
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.YT_COMMON);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.FACE_DETECT);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.PTU_TOOLS);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.PTU_ALGO);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.MASK_IMAGES);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.ACE_3D_ENGINE);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.VOICE_CHANGDER);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.VOICE_TO_TEXT);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.PARTICLE_SYSTEM);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.AGE_DETECT);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.FACE_3D_LIB);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.RAPID_NET_CAT);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.RAPID_NET_GENDER_DETECT);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.TNN_STYLE_CHILD_INITIALIZER);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.PAG);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.RAPID_NET_SEG_CPU);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.RAPID_NET_SEG_GPU);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.RAPID_NET_GENDER_SWITCH);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.RAPID_NET_GESTURE);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.IMAGE_ALGO);
    jdField_a_of_type_JavaUtilList.add(AEHandDetector.HAND_DETECTOR);
    jdField_a_of_type_JavaUtilList.add(PTHumanSegmenter.HUMAN_SEGMENT);
    jdField_a_of_type_JavaUtilList.add(PTEmotionDetector.EMOTION_DETECTOR);
    jdField_a_of_type_JavaUtilList.add(PTSkySegmenter.SKY_SEGMENT);
    jdField_a_of_type_JavaUtilList.add(PTHairSegmenter.HAIR_SEGMENT);
  }
  
  public static void a(@Nullable bnfg parambnfg, long paramLong)
  {
    ThreadManager.getUIHandler().postDelayed(new AEDashboardUtil.1(parambnfg), paramLong);
  }
  
  public static boolean a()
  {
    return false;
  }
  
  private static void b()
  {
    b.add(new Pair("app_alg_aio_camera_type_id", Integer.valueOf(4)));
    b.add(new Pair("app_alg_entrance_qzone_id_from833", Integer.valueOf(4)));
    b.add(new Pair("app_ui_playshow_ad_id", Integer.valueOf(4)));
  }
  
  private static void b(@Nullable bnfg parambnfg)
  {
    ThreadManager.excute(new AEDashboardUtil.2(parambnfg), 64, null, true);
  }
  
  private static void b(@Nullable bnfg parambnfg, @NonNull List<bnes> paramList, @NonNull List<bner> paramList1)
  {
    if (parambnfg == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new AEDashboardUtil.3(parambnfg, paramList, paramList1));
  }
  
  private static List<bnes> c()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Feature)localIterator.next();
      bnes localbnes = new bnes();
      try
      {
        localbnes.jdField_a_of_type_JavaLangString = ((Feature)localObject1).getName();
        localbnes.jdField_a_of_type_Boolean = ((Feature)localObject1).isFunctionReady();
        StringBuilder localStringBuilder;
        if (localObject1 == PTSkySegmenter.SKY_SEGMENT)
        {
          SkySegmentInitializer localSkySegmentInitializer = (SkySegmentInitializer)localObject1;
          localStringBuilder = new StringBuilder();
          if (!localSkySegmentInitializer.isUseCPULib()) {
            break label149;
          }
          localObject1 = "CPU";
          label94:
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append("&");
          if (!localSkySegmentInitializer.isUseSmallModel()) {
            break label156;
          }
        }
        label149:
        label156:
        for (localObject1 = "smallModel";; localObject1 = "bigModel")
        {
          localStringBuilder.append((String)localObject1);
          localbnes.c = localStringBuilder.toString();
          localLinkedList.add(localbnes);
          break;
          localObject1 = "GPU";
          break label94;
        }
      }
      catch (Exception localException)
      {
        localbnes.jdField_a_of_type_Boolean = false;
        localbnes.b = localException.getMessage();
        localLinkedList.add(localbnes);
      }
      finally
      {
        localLinkedList.add(localbnes);
      }
    }
    Collections.sort(localLinkedList, new bneq());
    return localLinkedList;
  }
  
  private static void c()
  {
    c.add(new bnet("CameraModuleSvc.GetCameraConfig"));
    c.add(new bnet("CameraModuleSvc.GetCompressedCategoryMaterial.MqStoryCamera"));
    c.add(new bnet("CameraModuleSvc.GetCompressedCategoryMaterial.MqEmoCamera"));
    c.add(new bnet("CameraModuleSvc.GetCompressedCategoryMaterial.MqCircleWatermark"));
    c.add(new bnet("CameraModuleSvc.GetPlayShowCatMatTree"));
  }
  
  private static List<bner> d()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      bner localbner = new bner();
      localbner.jdField_a_of_type_JavaLangString = ((String)localPair.first);
      localbner.b = bnqu.a().a((String)localPair.first, "null", ((Integer)localPair.second).intValue());
      localLinkedList.add(localbner);
    }
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnep
 * JD-Core Version:    0.7.0.1
 */