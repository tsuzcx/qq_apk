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
import dov.com.qq.im.AECamera.AEDashboardUtil.1;
import dov.com.qq.im.AECamera.AEDashboardUtil.2;
import dov.com.qq.im.AECamera.AEDashboardUtil.3;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class bgxl
{
  public static final bgxq a;
  private static final bhwf<bgxp> jdField_a_of_type_Bhwf;
  private static final List<Feature> jdField_a_of_type_JavaUtilList;
  private static final List<Pair<String, Integer>> b;
  private static final List<bgxp> c;
  
  static
  {
    jdField_a_of_type_Bgxq = new bgxq();
    jdField_a_of_type_JavaUtilList = new LinkedList();
    b = new LinkedList();
    c = new LinkedList();
    jdField_a_of_type_Bhwf = new bhwf();
    if (a())
    {
      a();
      b();
      c();
    }
  }
  
  public static bhwf<bgxp> a()
  {
    return jdField_a_of_type_Bhwf;
  }
  
  public static List<bgxp> a(@Nullable bgxp parambgxp)
  {
    LinkedList localLinkedList = new LinkedList(c);
    if ((parambgxp == null) || (TextUtils.isEmpty(parambgxp.jdField_a_of_type_JavaLangString))) {
      return localLinkedList;
    }
    Iterator localIterator = localLinkedList.iterator();
    while (localIterator.hasNext())
    {
      bgxp localbgxp = (bgxp)localIterator.next();
      if ((localbgxp != null) && (!TextUtils.isEmpty(localbgxp.jdField_a_of_type_JavaLangString)) && (localbgxp.jdField_a_of_type_JavaLangString.equals(parambgxp.jdField_a_of_type_JavaLangString)))
      {
        localbgxp.b = parambgxp.b;
        localbgxp.c = parambgxp.c;
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
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.GAMEPLAY);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.FILAMENT);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.VOICE_CHANGDER);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.VOICE_TO_TEXT);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.ANIMOJI);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.PARTICLE_SYSTEM);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.GENDER_DETECTOR);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.AGE_DETECT);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.FACE_KIT);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.PAG);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.RAPID_NET);
    jdField_a_of_type_JavaUtilList.add(FeatureManager.Features.IMAGE_ALGO);
    jdField_a_of_type_JavaUtilList.add(AEHandDetector.HAND_DETECTOR);
    jdField_a_of_type_JavaUtilList.add(PTSegmenter.SEGMENT);
    jdField_a_of_type_JavaUtilList.add(PTEmotionDetector.EMOTION_DETECTOR);
    jdField_a_of_type_JavaUtilList.add(PTSkySegmenter.SKY_SEGMENT);
    jdField_a_of_type_JavaUtilList.add(PTHairSegmenter.HAIR_SEGMENT);
  }
  
  public static void a(@Nullable wsu paramwsu, long paramLong)
  {
    ThreadManager.getUIHandler().postDelayed(new AEDashboardUtil.1(paramwsu), paramLong);
  }
  
  public static boolean a()
  {
    return false;
  }
  
  private static void b()
  {
    b.add(new Pair("app_alg_aio_camera_type_id", Integer.valueOf(4)));
    b.add(new Pair("app_alg_entrance_id", Integer.valueOf(4)));
    b.add(new Pair("app_ui_playshow_ad_id", Integer.valueOf(4)));
  }
  
  private static void b(@Nullable wsu paramwsu)
  {
    ThreadManager.excute(new AEDashboardUtil.2(paramwsu), 64, null, true);
  }
  
  private static void b(@Nullable wsu paramwsu, @NonNull List<bgxo> paramList, @NonNull List<bgxn> paramList1)
  {
    if (paramwsu == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new AEDashboardUtil.3(paramwsu, paramList, paramList1));
  }
  
  private static List<bgxo> c()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Feature)localIterator.next();
      bgxo localbgxo = new bgxo();
      try
      {
        localbgxo.jdField_a_of_type_JavaLangString = ((Feature)localObject1).getName();
        localbgxo.jdField_a_of_type_Boolean = ((Feature)localObject1).isFunctionReady();
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
          localbgxo.c = localStringBuilder.toString();
          localLinkedList.add(localbgxo);
          break;
          localObject1 = "GPU";
          break label94;
        }
      }
      catch (Exception localException)
      {
        localbgxo.jdField_a_of_type_Boolean = false;
        localbgxo.b = localException.getMessage();
        localLinkedList.add(localbgxo);
      }
      finally
      {
        localLinkedList.add(localbgxo);
      }
    }
    Collections.sort(localLinkedList, new bgxm());
    return localLinkedList;
  }
  
  private static void c()
  {
    c.add(new bgxp("CameraModuleSvc.GetCameraConfig"));
    c.add(new bgxp("CameraModuleSvc.GetCompressedCategoryMaterial.MqStoryCamera"));
    c.add(new bgxp("CameraModuleSvc.GetCompressedCategoryMaterial.MqEmoCamera"));
    c.add(new bgxp("CameraModuleSvc.GetPlayShowCatMatTree"));
  }
  
  private static List<bgxn> d()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      bgxn localbgxn = new bgxn();
      localbgxn.jdField_a_of_type_JavaLangString = ((String)localPair.first);
      localbgxn.b = bgxb.a().a((String)localPair.first, "null", ((Integer)localPair.second).intValue());
      localLinkedList.add(localbgxn);
    }
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bgxl
 * JD-Core Version:    0.7.0.1
 */