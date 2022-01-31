import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.ttpic.openai.ttpicmodule.AEHandDetector;
import com.tencent.ttpic.openapi.initializer.Feature;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.ttpicmodule.PTEmotionDetector;
import com.tencent.ttpic.openapi.ttpicmodule.PTSegmenter;
import com.tencent.ttpic.openapi.ttpicmodule.module_hair_segment.PTHairSegmenter;
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

public class bkwl
{
  public static final bkwq a;
  private static final bmen<bkwp> jdField_a_of_type_Bmen;
  private static final List<Feature> jdField_a_of_type_JavaUtilList;
  private static final List<Pair<String, Integer>> b;
  private static final List<bkwp> c;
  
  static
  {
    jdField_a_of_type_Bkwq = new bkwq();
    jdField_a_of_type_JavaUtilList = new LinkedList();
    b = new LinkedList();
    c = new LinkedList();
    jdField_a_of_type_Bmen = new bmen();
    if (a())
    {
      a();
      b();
      c();
    }
  }
  
  public static bmen<bkwp> a()
  {
    return jdField_a_of_type_Bmen;
  }
  
  public static List<bkwp> a(@Nullable bkwp parambkwp)
  {
    LinkedList localLinkedList = new LinkedList(c);
    if ((parambkwp == null) || (TextUtils.isEmpty(parambkwp.jdField_a_of_type_JavaLangString))) {
      return localLinkedList;
    }
    Iterator localIterator = localLinkedList.iterator();
    while (localIterator.hasNext())
    {
      bkwp localbkwp = (bkwp)localIterator.next();
      if ((localbkwp != null) && (!TextUtils.isEmpty(localbkwp.jdField_a_of_type_JavaLangString)) && (localbkwp.jdField_a_of_type_JavaLangString.equals(parambkwp.jdField_a_of_type_JavaLangString)))
      {
        localbkwp.b = parambkwp.b;
        localbkwp.c = parambkwp.c;
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
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.FILAMENT);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.VOICE_CHANGDER);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.VOICE_TO_TEXT);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.ANIMOJI);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.PARTICLE_SYSTEM);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.GENDER_DETECTOR);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.AGE_DETECT);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.FACE_KIT);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.PAG);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.RAPID_NET_SEG_CPU);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.RAPID_NET_SEG_GPU);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.RAPID_NET_GENDER_SWITCH);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.RAPID_NET_GESTURE);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.IMAGE_ALGO);
    jdField_a_of_type_JavaUtilList.add(AEHandDetector.HAND_DETECTOR);
    jdField_a_of_type_JavaUtilList.add(PTSegmenter.SEGMENT);
    jdField_a_of_type_JavaUtilList.add(PTEmotionDetector.EMOTION_DETECTOR);
    jdField_a_of_type_JavaUtilList.add(PTSkySegmenter.SKY_SEGMENT);
    jdField_a_of_type_JavaUtilList.add(PTHairSegmenter.HAIR_SEGMENT);
  }
  
  public static void a(@Nullable bkxc parambkxc, long paramLong)
  {
    ThreadManager.getUIHandler().postDelayed(new AEDashboardUtil.1(parambkxc), paramLong);
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
  
  private static void b(@Nullable bkxc parambkxc)
  {
    ThreadManager.excute(new AEDashboardUtil.2(parambkxc), 64, null, true);
  }
  
  private static void b(@Nullable bkxc parambkxc, @NonNull List<bkwo> paramList, @NonNull List<bkwn> paramList1)
  {
    if (parambkxc == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new AEDashboardUtil.3(parambkxc, paramList, paramList1));
  }
  
  private static List<bkwo> c()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Feature)localIterator.next();
      bkwo localbkwo = new bkwo();
      try
      {
        localbkwo.jdField_a_of_type_JavaLangString = ((Feature)localObject1).getName();
        localbkwo.jdField_a_of_type_Boolean = ((Feature)localObject1).isFunctionReady();
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
          localbkwo.c = localStringBuilder.toString();
          localLinkedList.add(localbkwo);
          break;
          localObject1 = "GPU";
          break label94;
        }
      }
      catch (Exception localException)
      {
        localbkwo.jdField_a_of_type_Boolean = false;
        localbkwo.b = localException.getMessage();
        localLinkedList.add(localbkwo);
      }
      finally
      {
        localLinkedList.add(localbkwo);
      }
    }
    Collections.sort(localLinkedList, new bkwm());
    return localLinkedList;
  }
  
  private static void c()
  {
    c.add(new bkwp("CameraModuleSvc.GetCameraConfig"));
    c.add(new bkwp("CameraModuleSvc.GetCompressedCategoryMaterial.MqStoryCamera"));
    c.add(new bkwp("CameraModuleSvc.GetCompressedCategoryMaterial.MqEmoCamera"));
    c.add(new bkwp("CameraModuleSvc.GetPlayShowCatMatTree"));
  }
  
  private static List<bkwn> d()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      bkwn localbkwn = new bkwn();
      localbkwn.jdField_a_of_type_JavaLangString = ((String)localPair.first);
      localbkwn.b = bljc.a().a((String)localPair.first, "null", ((Integer)localPair.second).intValue());
      localLinkedList.add(localbkwn);
    }
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkwl
 * JD-Core Version:    0.7.0.1
 */