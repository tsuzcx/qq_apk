package com.tencent.aelight.camera.ae.camera.ui.dashboard;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import androidx.lifecycle.MutableLiveData;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.aebase.AECaptureContext;
import com.tencent.aelight.camera.aeeditor.module.params.ParamsUtil;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.ttpic.openapi.initializer.Feature;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class AEDashboardUtil
{
  public static final AEDashboardUtil.ResolutionInfo a;
  private static int b = AECameraEntry.a.a();
  private static boolean c = false;
  private static boolean d = false;
  private static final List<Feature> e;
  private static final List<Pair<String, Integer>> f;
  private static final List<AEDashboardUtil.NetInfo> g;
  private static final MutableLiveData<AEDashboardUtil.NetInfo> h;
  private static final MutableLiveData<Float> i;
  
  static
  {
    a = new AEDashboardUtil.ResolutionInfo();
    e = new LinkedList();
    f = new LinkedList();
    g = new LinkedList();
    h = new MutableLiveData();
    i = new MutableLiveData();
    if (f())
    {
      i();
      j();
      k();
    }
  }
  
  public static MutableLiveData<AEDashboardUtil.NetInfo> a()
  {
    return h;
  }
  
  public static List<AEDashboardUtil.NetInfo> a(@Nullable AEDashboardUtil.NetInfo paramNetInfo)
  {
    LinkedList localLinkedList = new LinkedList(g);
    if (paramNetInfo != null)
    {
      if (TextUtils.isEmpty(paramNetInfo.a)) {
        return localLinkedList;
      }
      Iterator localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
      {
        AEDashboardUtil.NetInfo localNetInfo = (AEDashboardUtil.NetInfo)localIterator.next();
        if ((localNetInfo != null) && (!TextUtils.isEmpty(localNetInfo.a)) && (localNetInfo.a.equals(paramNetInfo.a)))
        {
          localNetInfo.b = paramNetInfo.b;
          localNetInfo.c = paramNetInfo.c;
        }
      }
    }
    return localLinkedList;
  }
  
  public static void a(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getExtras() != null))
    {
      b = paramIntent.getExtras().getInt("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());
      boolean bool;
      if ((b != AECameraEntry.e.a()) && (b != AECameraEntry.g.a()) && (b != AECameraEntry.c.a()) && (b != AECameraEntry.q.a())) {
        bool = false;
      } else {
        bool = true;
      }
      c = bool;
    }
  }
  
  public static void a(@Nullable AEVideoStoryDashboardPart.IDebugInfoCallback paramIDebugInfoCallback, long paramLong)
  {
    ThreadManager.getUIHandler().postDelayed(new AEDashboardUtil.1(paramIDebugInfoCallback), paramLong);
  }
  
  public static void a(boolean paramBoolean)
  {
    AECaptureContext.a().getApp().getSharedPreferences("com.tencent.aelight.camera.video_story_dashboard", 4).edit().putBoolean("com.tencent.aelight.camera.cosmetic_filter_data_source_asset", paramBoolean).apply();
  }
  
  public static MutableLiveData<Float> b()
  {
    return i;
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
  
  public static void b(boolean paramBoolean)
  {
    AECaptureContext.a().getApp().getSharedPreferences("com.tencent.aelight.camera.video_story_dashboard", 4).edit().putBoolean("com.tencent.aelight.camera.dy_style", paramBoolean).apply();
  }
  
  public static boolean c()
  {
    return AECaptureContext.a().getApp().getSharedPreferences("com.tencent.aelight.camera.video_story_dashboard", 4).getBoolean("com.tencent.aelight.camera.cosmetic_filter_data_source_asset", false);
  }
  
  public static boolean d()
  {
    return true;
  }
  
  public static void e()
  {
    boolean bool3 = n();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (c)
      {
        bool1 = bool2;
        if (AECaptureContext.a().getApp().getSharedPreferences("com.tencent.aelight.camera.video_story_dashboard", 4).getBoolean("com.tencent.aelight.camera.dy_style", false)) {
          bool1 = true;
        }
      }
    }
    d = bool1;
  }
  
  public static boolean f()
  {
    return false;
  }
  
  private static void i() {}
  
  private static void j()
  {
    List localList = f;
    Integer localInteger = Integer.valueOf(4);
    localList.add(new Pair("app_alg_entrance_qzone_id_from833", localInteger));
    f.add(new Pair("app_ui_playshow_ad_id", localInteger));
  }
  
  private static void k()
  {
    g.add(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetCameraConfig"));
    g.add(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetCategoryMaterial.MqStoryCamera"));
    g.add(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetCategoryMaterial.MqEmoCamera"));
    g.add(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetCategoryMaterial.MqCircleWatermark"));
    g.add(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetCategoryMaterial.MqKuaishanCamera"));
    g.add(new AEDashboardUtil.NetInfo("ShadowBackendSvc.GetPlayShowCatMatTree"));
  }
  
  /* Error */
  private static List<AEDashboardUtil.BinaryInfo> l()
  {
    // Byte code:
    //   0: new 48	java/util/LinkedList
    //   3: dup
    //   4: invokespecial 49	java/util/LinkedList:<init>	()V
    //   7: astore_0
    //   8: getstatic 51	com/tencent/aelight/camera/ae/camera/ui/dashboard/AEDashboardUtil:e	Ljava/util/List;
    //   11: invokeinterface 100 1 0
    //   16: astore_2
    //   17: aload_2
    //   18: invokeinterface 105 1 0
    //   23: ifeq +79 -> 102
    //   26: aload_2
    //   27: invokeinterface 109 1 0
    //   32: checkcast 276	com/tencent/ttpic/openapi/initializer/Feature
    //   35: astore_3
    //   36: new 278	com/tencent/aelight/camera/ae/camera/ui/dashboard/AEDashboardUtil$BinaryInfo
    //   39: dup
    //   40: invokespecial 279	com/tencent/aelight/camera/ae/camera/ui/dashboard/AEDashboardUtil$BinaryInfo:<init>	()V
    //   43: astore_1
    //   44: aload_1
    //   45: aload_3
    //   46: invokevirtual 283	com/tencent/ttpic/openapi/initializer/Feature:getName	()Ljava/lang/String;
    //   49: putfield 284	com/tencent/aelight/camera/ae/camera/ui/dashboard/AEDashboardUtil$BinaryInfo:a	Ljava/lang/String;
    //   52: aload_1
    //   53: aload_3
    //   54: invokevirtual 287	com/tencent/ttpic/openapi/initializer/Feature:isFunctionReady	()Z
    //   57: putfield 289	com/tencent/aelight/camera/ae/camera/ui/dashboard/AEDashboardUtil$BinaryInfo:b	Z
    //   60: aload_0
    //   61: aload_1
    //   62: invokeinterface 255 2 0
    //   67: pop
    //   68: goto -51 -> 17
    //   71: astore_2
    //   72: goto +20 -> 92
    //   75: astore_3
    //   76: aload_1
    //   77: iconst_0
    //   78: putfield 289	com/tencent/aelight/camera/ae/camera/ui/dashboard/AEDashboardUtil$BinaryInfo:b	Z
    //   81: aload_1
    //   82: aload_3
    //   83: invokevirtual 292	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   86: putfield 293	com/tencent/aelight/camera/ae/camera/ui/dashboard/AEDashboardUtil$BinaryInfo:c	Ljava/lang/String;
    //   89: goto -29 -> 60
    //   92: aload_0
    //   93: aload_1
    //   94: invokeinterface 255 2 0
    //   99: pop
    //   100: aload_2
    //   101: athrow
    //   102: aload_0
    //   103: new 295	com/tencent/aelight/camera/ae/camera/ui/dashboard/AEDashboardUtil$4
    //   106: dup
    //   107: invokespecial 296	com/tencent/aelight/camera/ae/camera/ui/dashboard/AEDashboardUtil$4:<init>	()V
    //   110: invokestatic 302	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
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
  
  private static List<AEDashboardUtil.ABTestInfo> m()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = f.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      AEDashboardUtil.ABTestInfo localABTestInfo = new AEDashboardUtil.ABTestInfo();
      localABTestInfo.a = ((String)localPair.first);
      localABTestInfo.b = AECameraPrefsUtil.a().b((String)localPair.first, "null", ((Integer)localPair.second).intValue());
      localLinkedList.add(localABTestInfo);
    }
    return localLinkedList;
  }
  
  private static boolean n()
  {
    return ParamsUtil.b() > 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil
 * JD-Core Version:    0.7.0.1
 */