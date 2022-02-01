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

public class bomz
{
  private static final MutableLiveData<bond> jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
  public static final bone a;
  private static final List<Feature> jdField_a_of_type_JavaUtilList;
  private static final List<Pair<String, Integer>> b;
  private static final List<bond> c;
  
  static
  {
    jdField_a_of_type_Bone = new bone();
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
  
  public static MutableLiveData<bond> a()
  {
    return jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  public static List<bond> a(@Nullable bond parambond)
  {
    LinkedList localLinkedList = new LinkedList(c);
    if ((parambond == null) || (TextUtils.isEmpty(parambond.jdField_a_of_type_JavaLangString))) {
      return localLinkedList;
    }
    Iterator localIterator = localLinkedList.iterator();
    while (localIterator.hasNext())
    {
      bond localbond = (bond)localIterator.next();
      if ((localbond != null) && (!TextUtils.isEmpty(localbond.jdField_a_of_type_JavaLangString)) && (localbond.jdField_a_of_type_JavaLangString.equals(parambond.jdField_a_of_type_JavaLangString)))
      {
        localbond.b = parambond.b;
        localbond.c = parambond.c;
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
  
  public static void a(@Nullable bonq parambonq, long paramLong)
  {
    ThreadManager.getUIHandler().postDelayed(new AEDashboardUtil.1(parambonq), paramLong);
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
  
  private static void b(@Nullable bonq parambonq)
  {
    ThreadManager.excute(new AEDashboardUtil.2(parambonq), 64, null, true);
  }
  
  private static void b(@Nullable bonq parambonq, @NonNull List<bonc> paramList, @NonNull List<bonb> paramList1)
  {
    if (parambonq == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new AEDashboardUtil.3(parambonq, paramList, paramList1));
  }
  
  private static List<bonc> c()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Feature)localIterator.next();
      bonc localbonc = new bonc();
      try
      {
        localbonc.jdField_a_of_type_JavaLangString = ((Feature)localObject1).getName();
        localbonc.jdField_a_of_type_Boolean = ((Feature)localObject1).isFunctionReady();
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
          localbonc.c = localStringBuilder.toString();
          localLinkedList.add(localbonc);
          break;
          localObject1 = "GPU";
          break label94;
        }
      }
      catch (Exception localException)
      {
        localbonc.jdField_a_of_type_Boolean = false;
        localbonc.b = localException.getMessage();
        localLinkedList.add(localbonc);
      }
      finally
      {
        localLinkedList.add(localbonc);
      }
    }
    Collections.sort(localLinkedList, new bona());
    return localLinkedList;
  }
  
  private static void c()
  {
    c.add(new bond("CameraModuleSvc.GetCameraConfig"));
    c.add(new bond("CameraModuleSvc.GetCompressedCategoryMaterial.MqStoryCamera"));
    c.add(new bond("CameraModuleSvc.GetCompressedCategoryMaterial.MqEmoCamera"));
    c.add(new bond("CameraModuleSvc.GetPlayShowCatMatTree"));
  }
  
  private static List<bonb> d()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      bonb localbonb = new bonb();
      localbonb.jdField_a_of_type_JavaLangString = ((String)localPair.first);
      localbonb.b = bozz.a().a((String)localPair.first, "null", ((Integer)localPair.second).intValue());
      localLinkedList.add(localbonb);
    }
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bomz
 * JD-Core Version:    0.7.0.1
 */