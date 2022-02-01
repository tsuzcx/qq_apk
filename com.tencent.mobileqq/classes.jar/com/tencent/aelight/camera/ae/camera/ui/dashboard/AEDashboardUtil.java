package com.tencent.aelight.camera.ae.camera.ui.dashboard;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import androidx.lifecycle.MutableLiveData;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.ttpic.openapi.initializer.Feature;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class AEDashboardUtil
{
  private static final MutableLiveData<AEDashboardUtil.NetInfo> jdField_a_of_type_AndroidxLifecycleMutableLiveData;
  public static final AEDashboardUtil.ResolutionInfo a;
  private static final List<Feature> jdField_a_of_type_JavaUtilList;
  private static final List<Pair<String, Integer>> b;
  private static final List<AEDashboardUtil.NetInfo> c;
  
  static
  {
    jdField_a_of_type_ComTencentAelightCameraAeCameraUiDashboardAEDashboardUtil$ResolutionInfo = new AEDashboardUtil.ResolutionInfo();
    jdField_a_of_type_JavaUtilList = new LinkedList();
    b = new LinkedList();
    c = new LinkedList();
    jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
    if (a())
    {
      a();
      b();
      c();
    }
  }
  
  public static MutableLiveData<AEDashboardUtil.NetInfo> a()
  {
    return jdField_a_of_type_AndroidxLifecycleMutableLiveData;
  }
  
  public static List<AEDashboardUtil.NetInfo> a(@Nullable AEDashboardUtil.NetInfo paramNetInfo)
  {
    LinkedList localLinkedList = new LinkedList(c);
    if (paramNetInfo != null)
    {
      if (TextUtils.isEmpty(paramNetInfo.jdField_a_of_type_JavaLangString)) {
        return localLinkedList;
      }
      Iterator localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
      {
        AEDashboardUtil.NetInfo localNetInfo = (AEDashboardUtil.NetInfo)localIterator.next();
        if ((localNetInfo != null) && (!TextUtils.isEmpty(localNetInfo.jdField_a_of_type_JavaLangString)) && (localNetInfo.jdField_a_of_type_JavaLangString.equals(paramNetInfo.jdField_a_of_type_JavaLangString)))
        {
          localNetInfo.b = paramNetInfo.b;
          localNetInfo.c = paramNetInfo.c;
        }
      }
    }
    return localLinkedList;
  }
  
  private static void a() {}
  
  public static void a(@Nullable AEVideoStoryDashboardPart.IDebugInfoCallback paramIDebugInfoCallback, long paramLong)
  {
    ThreadManager.getUIHandler().postDelayed(new AEDashboardUtil.1(paramIDebugInfoCallback), paramLong);
  }
  
  public static boolean a()
  {
    return false;
  }
  
  private static void b()
  {
    List localList = b;
    Integer localInteger = Integer.valueOf(4);
    localList.add(new Pair("app_alg_entrance_qzone_id_from833", localInteger));
    b.add(new Pair("app_ui_playshow_ad_id", localInteger));
  }
  
  private static void b(@Nullable AEVideoStoryDashboardPart.IDebugInfoCallback paramIDebugInfoCallback)
  {
    ThreadManager.excute(new AEDashboardUtil.2(paramIDebugInfoCallback), 64, null, true);
  }
  
  private static void b(@Nullable AEVideoStoryDashboardPart.IDebugInfoCallback paramIDebugInfoCallback, @NonNull List<AEDashboardUtil.BinaryInfo> paramList, @NonNull List<AEDashboardUtil.ABTestInfo> paramList1)
  {
    if (paramIDebugInfoCallback == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new AEDashboardUtil.3(paramIDebugInfoCallback, paramList, paramList1));
  }
  
  /* Error */
  private static List<AEDashboardUtil.BinaryInfo> c()
  {
    // Byte code:
    //   0: new 25	java/util/LinkedList
    //   3: dup
    //   4: invokespecial 26	java/util/LinkedList:<init>	()V
    //   7: astore_0
    //   8: getstatic 28	com/tencent/aelight/camera/ae/camera/ui/dashboard/AEDashboardUtil:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   11: invokeinterface 76 1 0
    //   16: astore_2
    //   17: aload_2
    //   18: invokeinterface 81 1 0
    //   23: ifeq +79 -> 102
    //   26: aload_2
    //   27: invokeinterface 85 1 0
    //   32: checkcast 162	com/tencent/ttpic/openapi/initializer/Feature
    //   35: astore_3
    //   36: new 164	com/tencent/aelight/camera/ae/camera/ui/dashboard/AEDashboardUtil$BinaryInfo
    //   39: dup
    //   40: invokespecial 165	com/tencent/aelight/camera/ae/camera/ui/dashboard/AEDashboardUtil$BinaryInfo:<init>	()V
    //   43: astore_1
    //   44: aload_1
    //   45: aload_3
    //   46: invokevirtual 169	com/tencent/ttpic/openapi/initializer/Feature:getName	()Ljava/lang/String;
    //   49: putfield 170	com/tencent/aelight/camera/ae/camera/ui/dashboard/AEDashboardUtil$BinaryInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   52: aload_1
    //   53: aload_3
    //   54: invokevirtual 173	com/tencent/ttpic/openapi/initializer/Feature:isFunctionReady	()Z
    //   57: putfield 176	com/tencent/aelight/camera/ae/camera/ui/dashboard/AEDashboardUtil$BinaryInfo:jdField_a_of_type_Boolean	Z
    //   60: aload_0
    //   61: aload_1
    //   62: invokeinterface 139 2 0
    //   67: pop
    //   68: goto -51 -> 17
    //   71: astore_2
    //   72: goto +20 -> 92
    //   75: astore_3
    //   76: aload_1
    //   77: iconst_0
    //   78: putfield 176	com/tencent/aelight/camera/ae/camera/ui/dashboard/AEDashboardUtil$BinaryInfo:jdField_a_of_type_Boolean	Z
    //   81: aload_1
    //   82: aload_3
    //   83: invokevirtual 179	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   86: putfield 180	com/tencent/aelight/camera/ae/camera/ui/dashboard/AEDashboardUtil$BinaryInfo:b	Ljava/lang/String;
    //   89: goto -29 -> 60
    //   92: aload_0
    //   93: aload_1
    //   94: invokeinterface 139 2 0
    //   99: pop
    //   100: aload_2
    //   101: athrow
    //   102: aload_0
    //   103: new 182	com/tencent/aelight/camera/ae/camera/ui/dashboard/AEDashboardUtil$4
    //   106: dup
    //   107: invokespecial 183	com/tencent/aelight/camera/ae/camera/ui/dashboard/AEDashboardUtil$4:<init>	()V
    //   110: invokestatic 189	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   113: aload_0
    //   114: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   7	107	0	localLinkedList	LinkedList
    //   43	51	1	localBinaryInfo	AEDashboardUtil.BinaryInfo
    //   16	11	2	localIterator	Iterator
    //   71	30	2	localObject	Object
    //   35	19	3	localFeature	Feature
    //   75	8	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   44	60	71	finally
    //   76	89	71	finally
    //   44	60	75	java/lang/Exception
  }
  
  private static void c()
  {
    c.add(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetCameraConfig"));
    c.add(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetCategoryMaterial.MqStoryCamera"));
    c.add(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetCategoryMaterial.MqEmoCamera"));
    c.add(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetCategoryMaterial.MqCircleWatermark"));
    c.add(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetPlayShowCatMatTree"));
  }
  
  private static List<AEDashboardUtil.ABTestInfo> d()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      AEDashboardUtil.ABTestInfo localABTestInfo = new AEDashboardUtil.ABTestInfo();
      localABTestInfo.jdField_a_of_type_JavaLangString = ((String)localPair.first);
      localABTestInfo.b = AECameraPrefsUtil.a().a((String)localPair.first, "null", ((Integer)localPair.second).intValue());
      localLinkedList.add(localABTestInfo);
    }
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil
 * JD-Core Version:    0.7.0.1
 */