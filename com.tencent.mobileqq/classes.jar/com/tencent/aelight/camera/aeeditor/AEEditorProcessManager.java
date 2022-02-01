package com.tencent.aelight.camera.aeeditor;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.AEKitForQQ;
import com.tencent.aelight.camera.ae.camera.core.AEEditorOrderBroadcastReceiver;
import com.tencent.aelight.camera.ae.camera.core.AEEditorOrderBroadcastReceiver.AEEditorOrderListener;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.aeeditor.data.AEEditorVideoInfo;
import com.tencent.aelight.camera.aeeditor.listener.AETavSessionStatusListener;
import com.tencent.aelight.camera.aeeditor.module.export.AEEditorGenerateRunnable;
import com.tencent.aelight.camera.log.AEQLog;
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
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AEEditorProcessManager
  implements AEEditorOrderBroadcastReceiver.AEEditorOrderListener, AETavSessionStatusListener
{
  private final long jdField_a_of_type_Long = 1000L;
  private AEEditorOrderBroadcastReceiver jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAEEditorOrderBroadcastReceiver = new AEEditorOrderBroadcastReceiver(this);
  private Map<String, AEEditorVideoInfo> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Queue<AEEditorVideoInfo> jdField_a_of_type_JavaUtilQueue = new ArrayDeque();
  private boolean jdField_a_of_type_Boolean = false;
  private final long b;
  
  private AEEditorProcessManager()
  {
    this.jdField_b_of_type_Long = 5000L;
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAEEditorOrderBroadcastReceiver.registerSelf(BaseApplicationImpl.getContext());
  }
  
  public static AEEditorProcessManager a()
  {
    return AEEditorProcessManager.InstanceHolder.a;
  }
  
  private void a(@NonNull AEEditorVideoInfo paramAEEditorVideoInfo)
  {
    if (this.jdField_a_of_type_JavaUtilQueue.size() == 0)
    {
      AEQLog.b("AEEditorProcessManager", "[tryStartTask] size 0");
      this.jdField_a_of_type_JavaUtilQueue.add(paramAEEditorVideoInfo);
      paramAEEditorVideoInfo.jdField_b_of_type_Long = System.currentTimeMillis();
      paramAEEditorVideoInfo.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleExportAEEditorGenerateRunnable.run();
      return;
    }
    AEEditorVideoInfo localAEEditorVideoInfo = (AEEditorVideoInfo)this.jdField_a_of_type_JavaUtilQueue.peek();
    long l = System.currentTimeMillis();
    if ((localAEEditorVideoInfo != null) && (Math.abs(l - localAEEditorVideoInfo.jdField_b_of_type_Long) > 5000L))
    {
      AEQLog.b("AEEditorProcessManager", "[tryStartTask] Dog Dead next Mission");
      this.jdField_a_of_type_JavaUtilQueue.remove(localAEEditorVideoInfo);
      this.jdField_a_of_type_JavaUtilQueue.add(paramAEEditorVideoInfo);
      c();
      return;
    }
    AEQLog.b("AEEditorProcessManager", "[tryStartTask]Dog alive");
    this.jdField_a_of_type_JavaUtilQueue.add(paramAEEditorVideoInfo);
  }
  
  private void b(@NonNull AEEditorVideoInfo paramAEEditorVideoInfo)
  {
    Intent localIntent = new Intent();
    localIntent.setAction(paramAEEditorVideoInfo.jdField_e_of_type_JavaLangString);
    localIntent.setPackage(BaseApplicationImpl.getContext().getPackageName());
    localIntent.putExtra("generate_materialid", paramAEEditorVideoInfo.h);
    localIntent.putExtra("generate_materialname", paramAEEditorVideoInfo.i);
    localIntent.putExtra("generate_filterid", paramAEEditorVideoInfo.j);
    localIntent.putExtra("generate_scheme", paramAEEditorVideoInfo.k);
    localIntent.putExtra("generate_show_circle_take_same", paramAEEditorVideoInfo.jdField_b_of_type_Int);
    localIntent.putExtra("generate_path", paramAEEditorVideoInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("generate_mission", paramAEEditorVideoInfo.jdField_f_of_type_JavaLangString);
    localIntent.putExtra("generate_progress", paramAEEditorVideoInfo.jdField_a_of_type_Float);
    localIntent.putExtra("generate_thumb_ptah", paramAEEditorVideoInfo.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("generate_errorcode", paramAEEditorVideoInfo.jdField_a_of_type_Int);
    localIntent.putExtra("generate_errormessage", paramAEEditorVideoInfo.g);
    localIntent.putExtra("generate_source_path", paramAEEditorVideoInfo.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("generate_KuolieId", paramAEEditorVideoInfo.l);
    localIntent.putExtra("generate_centerX", paramAEEditorVideoInfo.jdField_b_of_type_Float);
    localIntent.putExtra("generate_centerY", paramAEEditorVideoInfo.jdField_c_of_type_Float);
    localIntent.putExtra("generate_widthScale", paramAEEditorVideoInfo.jdField_e_of_type_Float);
    localIntent.putExtra("generate_HeightScale", paramAEEditorVideoInfo.jdField_f_of_type_Float);
    localIntent.putExtra("generate_rotate", paramAEEditorVideoInfo.jdField_d_of_type_Float);
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_JavaUtilQueue.size() == 0)
    {
      AEQLog.b("AEEditorProcessManager", "[tryStartNext] No mission");
      return;
    }
    AEEditorVideoInfo localAEEditorVideoInfo = (AEEditorVideoInfo)this.jdField_a_of_type_JavaUtilQueue.peek();
    if (localAEEditorVideoInfo != null)
    {
      AEQLog.b("AEEditorProcessManager", "[tryStartNext] next mission");
      localAEEditorVideoInfo.jdField_b_of_type_Long = System.currentTimeMillis();
      localAEEditorVideoInfo.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleExportAEEditorGenerateRunnable.run();
    }
  }
  
  private void d(@NonNull String paramString)
  {
    AEQLog.b("AEEditorProcessManager", "[cancel mission]");
    paramString = (AEEditorVideoInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((paramString != null) && (!paramString.jdField_e_of_type_JavaLangString.equals("AEEDITOR_GENERATE_STATUS_READY")))
    {
      paramString = paramString.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleExportAEEditorGenerateRunnable.a();
      if (paramString != null) {
        paramString.cancel();
      }
    }
  }
  
  private void e(@NonNull String paramString)
  {
    AEQLog.b("AEEditorProcessManager", "[save mission]");
    AEEditorVideoInfo localAEEditorVideoInfo = (AEEditorVideoInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localAEEditorVideoInfo != null)
    {
      AECameraPrefsUtil.a().a(paramString, localAEEditorVideoInfo.jdField_a_of_type_ComTencentWeseevideoModelMediaModel.toString(), 4);
      AECameraPrefsUtil localAECameraPrefsUtil = AECameraPrefsUtil.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("sourcePath");
      localAECameraPrefsUtil.a(localStringBuilder.toString(), localAEEditorVideoInfo.jdField_b_of_type_JavaLangString, 4);
      localAECameraPrefsUtil = AECameraPrefsUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("outputPath");
      localAECameraPrefsUtil.a(localStringBuilder.toString(), localAEEditorVideoInfo.jdField_c_of_type_JavaLangString, 4);
      localAECameraPrefsUtil = AECameraPrefsUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("thumbPath");
      localAECameraPrefsUtil.a(localStringBuilder.toString(), localAEEditorVideoInfo.jdField_d_of_type_JavaLangString, 4);
      localAECameraPrefsUtil = AECameraPrefsUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("status");
      localAECameraPrefsUtil.a(localStringBuilder.toString(), localAEEditorVideoInfo.jdField_e_of_type_JavaLangString, 4);
      localAECameraPrefsUtil = AECameraPrefsUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("materialID");
      localAECameraPrefsUtil.a(localStringBuilder.toString(), localAEEditorVideoInfo.h, 4);
      localAECameraPrefsUtil = AECameraPrefsUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("materialName");
      localAECameraPrefsUtil.a(localStringBuilder.toString(), localAEEditorVideoInfo.i, 4);
      localAECameraPrefsUtil = AECameraPrefsUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("filterID");
      localAECameraPrefsUtil.a(localStringBuilder.toString(), localAEEditorVideoInfo.j, 4);
      localAECameraPrefsUtil = AECameraPrefsUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("scheme");
      localAECameraPrefsUtil.a(localStringBuilder.toString(), localAEEditorVideoInfo.k, 4);
      localAECameraPrefsUtil = AECameraPrefsUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("showCircleTakeSame");
      localAECameraPrefsUtil.a(localStringBuilder.toString(), localAEEditorVideoInfo.jdField_b_of_type_Int, 4);
      localAECameraPrefsUtil = AECameraPrefsUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("mKuolieId");
      localAECameraPrefsUtil.a(localStringBuilder.toString(), localAEEditorVideoInfo.l, 4);
      localAECameraPrefsUtil = AECameraPrefsUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("mKuolieCenterX");
      localAECameraPrefsUtil.a(localStringBuilder.toString(), localAEEditorVideoInfo.jdField_b_of_type_Float, 4);
      localAECameraPrefsUtil = AECameraPrefsUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("mKuolieCenterY");
      localAECameraPrefsUtil.a(localStringBuilder.toString(), localAEEditorVideoInfo.jdField_c_of_type_Float, 4);
      localAECameraPrefsUtil = AECameraPrefsUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("mKuolieWidthScale");
      localAECameraPrefsUtil.a(localStringBuilder.toString(), localAEEditorVideoInfo.jdField_e_of_type_Float, 4);
      localAECameraPrefsUtil = AECameraPrefsUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("mKuolieHeightScale");
      localAECameraPrefsUtil.a(localStringBuilder.toString(), localAEEditorVideoInfo.jdField_f_of_type_Float, 4);
      localAECameraPrefsUtil = AECameraPrefsUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("mKuolieRotate");
      localAECameraPrefsUtil.a(localStringBuilder.toString(), localAEEditorVideoInfo.jdField_d_of_type_Float, 4);
    }
  }
  
  private void f(@NonNull String paramString)
  {
    AEQLog.b("AEEditorProcessManager", "[remove mission]");
    AECameraPrefsUtil.a().a(paramString, 4);
    AECameraPrefsUtil localAECameraPrefsUtil = AECameraPrefsUtil.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("sourcePath");
    localAECameraPrefsUtil.a(localStringBuilder.toString(), 4);
    localAECameraPrefsUtil = AECameraPrefsUtil.a();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("outputPath");
    localAECameraPrefsUtil.a(localStringBuilder.toString(), 4);
    localAECameraPrefsUtil = AECameraPrefsUtil.a();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("thumbPath");
    localAECameraPrefsUtil.a(localStringBuilder.toString(), 4);
    localAECameraPrefsUtil = AECameraPrefsUtil.a();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("status");
    localAECameraPrefsUtil.a(localStringBuilder.toString(), 4);
    localAECameraPrefsUtil = AECameraPrefsUtil.a();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("mKuolieId");
    localAECameraPrefsUtil.a(localStringBuilder.toString(), 4);
    localAECameraPrefsUtil = AECameraPrefsUtil.a();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("mKuolieCenterX");
    localAECameraPrefsUtil.a(localStringBuilder.toString(), 4);
    localAECameraPrefsUtil = AECameraPrefsUtil.a();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("mKuolieCenterY");
    localAECameraPrefsUtil.a(localStringBuilder.toString(), 4);
    localAECameraPrefsUtil = AECameraPrefsUtil.a();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("mKuolieWidthScale");
    localAECameraPrefsUtil.a(localStringBuilder.toString(), 4);
    localAECameraPrefsUtil = AECameraPrefsUtil.a();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("mKuolieHeightScale");
    localAECameraPrefsUtil.a(localStringBuilder.toString(), 4);
    localAECameraPrefsUtil = AECameraPrefsUtil.a();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("mKuolieRotate");
    localAECameraPrefsUtil.a(localStringBuilder.toString(), 4);
  }
  
  public AEEditorVideoInfo a(String paramString)
  {
    Map localMap = this.jdField_a_of_type_JavaUtilMap;
    if (localMap != null) {
      return (AEEditorVideoInfo)localMap.get(paramString);
    }
    return null;
  }
  
  @Nullable
  public MediaModel a(@NonNull String paramString)
  {
    paramString = AECameraPrefsUtil.a().a(paramString, "", 4);
    if (!TextUtils.isEmpty(paramString)) {
      return (MediaModel)GsonUtils.json2Obj(paramString, MediaModel.class);
    }
    return null;
  }
  
  public void a()
  {
    if (!AEKitForQQ.a())
    {
      AEQLog.a("AEEditorProcessManager", "AEKitForQQ.init() fail");
    }
    else
    {
      if (!FeatureManager.loadBasicFeatures()) {
        AEQLog.a("AEEditorProcessManager", "loadBasicFeatures.init() fail");
      }
      if (!FeatureManager.Features.PAG.init()) {
        AEQLog.a("AEEditorProcessManager", "PAG.init() fail");
      }
      if (!FeatureManager.Features.IMAGE_ALGO.init()) {
        AEQLog.a("AEEditorProcessManager", "IMAGE_ALGO.init() fail");
      }
    }
    TAVCut.initTAVCut(BaseApplicationImpl.getContext(), FeatureManager.getResourceDir(), FeatureManager.getResourceDir(), AEResUtil.g(), new AEEditorProcessManager.1(this));
  }
  
  public void a(@Nullable String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      AEQLog.d("AEEditorProcessManager", "[requestGenerateVideo] mission is none");
      return;
    }
    AEEditorVideoInfo localAEEditorVideoInfo = (AEEditorVideoInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localAEEditorVideoInfo == null)
    {
      Object localObject1 = AECameraPrefsUtil.a();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("sourcePath");
      localObject1 = ((AECameraPrefsUtil)localObject1).a(((StringBuilder)localObject2).toString(), "", 4);
      localObject2 = AECameraPrefsUtil.a();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramString);
      ((StringBuilder)localObject3).append("outputPath");
      localObject2 = ((AECameraPrefsUtil)localObject2).a(((StringBuilder)localObject3).toString(), "", 4);
      localObject3 = AECameraPrefsUtil.a();
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(paramString);
      ((StringBuilder)localObject4).append("thumbPath");
      localObject3 = ((AECameraPrefsUtil)localObject3).a(((StringBuilder)localObject4).toString(), "", 4);
      localObject4 = AECameraPrefsUtil.a();
      Object localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(paramString);
      ((StringBuilder)localObject5).append("status");
      localObject4 = ((AECameraPrefsUtil)localObject4).a(((StringBuilder)localObject5).toString(), "", 4);
      localObject5 = AECameraPrefsUtil.a();
      Object localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append(paramString);
      ((StringBuilder)localObject6).append("materialID");
      localObject5 = ((AECameraPrefsUtil)localObject5).a(((StringBuilder)localObject6).toString(), "", 4);
      localObject6 = AECameraPrefsUtil.a();
      Object localObject7 = new StringBuilder();
      ((StringBuilder)localObject7).append(paramString);
      ((StringBuilder)localObject7).append("materialName");
      localObject6 = ((AECameraPrefsUtil)localObject6).a(((StringBuilder)localObject7).toString(), "", 4);
      localObject7 = AECameraPrefsUtil.a();
      Object localObject8 = new StringBuilder();
      ((StringBuilder)localObject8).append(paramString);
      ((StringBuilder)localObject8).append("filterID");
      localObject7 = ((AECameraPrefsUtil)localObject7).a(((StringBuilder)localObject8).toString(), "", 4);
      localObject8 = AECameraPrefsUtil.a();
      Object localObject9 = new StringBuilder();
      ((StringBuilder)localObject9).append(paramString);
      ((StringBuilder)localObject9).append("scheme");
      localObject8 = ((AECameraPrefsUtil)localObject8).a(((StringBuilder)localObject9).toString(), "", 4);
      localObject9 = AECameraPrefsUtil.a();
      Object localObject10 = new StringBuilder();
      ((StringBuilder)localObject10).append(paramString);
      ((StringBuilder)localObject10).append("showCircleTakeSame");
      int i = ((AECameraPrefsUtil)localObject9).a(((StringBuilder)localObject10).toString(), 0, 4);
      localObject9 = AECameraPrefsUtil.a();
      localObject10 = new StringBuilder();
      ((StringBuilder)localObject10).append(paramString);
      ((StringBuilder)localObject10).append("mKuolieId");
      localObject9 = ((AECameraPrefsUtil)localObject9).a(((StringBuilder)localObject10).toString(), "", 4);
      localObject10 = AECameraPrefsUtil.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("mKuolieCenterX");
      float f1 = ((AECameraPrefsUtil)localObject10).a(localStringBuilder.toString(), 0.0F, 4);
      localObject10 = AECameraPrefsUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("mKuolieCenterY");
      float f2 = ((AECameraPrefsUtil)localObject10).a(localStringBuilder.toString(), 0.0F, 4);
      localObject10 = AECameraPrefsUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("mKuolieWidthScale");
      float f3 = ((AECameraPrefsUtil)localObject10).a(localStringBuilder.toString(), 0.0F, 4);
      localObject10 = AECameraPrefsUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("mKuolieHeightScale");
      float f4 = ((AECameraPrefsUtil)localObject10).a(localStringBuilder.toString(), 0.0F, 4);
      localObject10 = AECameraPrefsUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("mKuolieRotate");
      float f5 = ((AECameraPrefsUtil)localObject10).a(localStringBuilder.toString(), 0.0F, 4);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject4)))
      {
        if (((String)localObject4).equals("AEEDITOR_GENERATE_STATUS_READY"))
        {
          AEQLog.b("AEEditorProcessManager", "[requestGenerateVideo] mission is Ready");
          paramString = new AEEditorVideoInfo((String)localObject5, (String)localObject6, (String)localObject7, (String)localObject8, i, paramString, (String)localObject1, (String)localObject2, (String)localObject3, null, (String)localObject9, f1, f2, f3, f4, f5);
          paramString.jdField_e_of_type_JavaLangString = "AEEDITOR_GENERATE_STATUS_READY";
          b(paramString);
          return;
        }
        localObject4 = a(paramString);
        AEQLog.b("AEEditorProcessManager", "[requestGenerateVideo] peak is dead");
        if (localObject4 == null)
        {
          localAEEditorVideoInfo.jdField_e_of_type_JavaLangString = "AEEDITOR_GENERATE_STATUS_ERROR";
          localAEEditorVideoInfo.jdField_a_of_type_Int = -2;
          AEQLog.d("AEEditorProcessManager", "[requestGenerateVideo] GENERATE_ERROR_NODATA");
          b(localAEEditorVideoInfo);
          return;
        }
        a((String)localObject5, (String)localObject6, (String)localObject7, (String)localObject8, i, paramString, (String)localObject1, (String)localObject2, (String)localObject3, (MediaModel)localObject4, (String)localObject9, f1, f2, f3, f4, f5);
        return;
      }
      paramString = new AEEditorVideoInfo((String)localObject5, (String)localObject6, (String)localObject7, (String)localObject8, i, paramString, (String)localObject1, (String)localObject2, (String)localObject3, null, (String)localObject9, f1, f2, f3, f4, f5);
      paramString.jdField_e_of_type_JavaLangString = "AEEDITOR_GENERATE_STATUS_ERROR";
      paramString.jdField_a_of_type_Int = -2;
      AEQLog.d("AEEditorProcessManager", "[requestGenerateVideo] GENERATE_ERROR_NODATA");
      b(paramString);
      return;
    }
    AEQLog.b("AEEditorProcessManager", "[requestGenerateVideo] peak is alive");
    a(localAEEditorVideoInfo.h, localAEEditorVideoInfo.i, localAEEditorVideoInfo.j, localAEEditorVideoInfo.k, localAEEditorVideoInfo.jdField_b_of_type_Int, paramString, localAEEditorVideoInfo.jdField_b_of_type_JavaLangString, localAEEditorVideoInfo.jdField_c_of_type_JavaLangString, localAEEditorVideoInfo.jdField_d_of_type_JavaLangString, localAEEditorVideoInfo.jdField_a_of_type_ComTencentWeseevideoModelMediaModel, localAEEditorVideoInfo.l, localAEEditorVideoInfo.jdField_b_of_type_Float, localAEEditorVideoInfo.jdField_c_of_type_Float, localAEEditorVideoInfo.jdField_e_of_type_Float, localAEEditorVideoInfo.jdField_f_of_type_Float, localAEEditorVideoInfo.jdField_d_of_type_Float);
  }
  
  public void a(@NonNull String paramString, float paramFloat)
  {
    paramString = (AEEditorVideoInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
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
  
  public void a(@NonNull String paramString1, int paramInt, String paramString2)
  {
    paramString1 = (AEEditorVideoInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString1);
    if (paramString1 != null)
    {
      paramString1.jdField_e_of_type_JavaLangString = "AEEDITOR_GENERATE_STATUS_ERROR";
      paramString1.g = paramString2;
      paramString1.jdField_a_of_type_Float = 0.0F;
      paramString1.jdField_a_of_type_Int = paramInt;
      b(paramString1);
      this.jdField_a_of_type_JavaUtilQueue.remove(paramString1);
      c();
    }
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2)
  {
    AEEditorVideoInfo localAEEditorVideoInfo = (AEEditorVideoInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString1);
    if (localAEEditorVideoInfo != null)
    {
      localAEEditorVideoInfo.jdField_e_of_type_JavaLangString = "AEEDITOR_GENERATE_STATUS_READY";
      localAEEditorVideoInfo.jdField_a_of_type_JavaLangString = paramString2;
      localAEEditorVideoInfo.jdField_a_of_type_Float = 1.0F;
      b(localAEEditorVideoInfo);
      paramString2 = AECameraPrefsUtil.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("status");
      paramString2.a(localStringBuilder.toString(), localAEEditorVideoInfo.jdField_e_of_type_JavaLangString, 4);
      this.jdField_a_of_type_JavaUtilQueue.remove(localAEEditorVideoInfo);
      c();
    }
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3, @NonNull String paramString4, int paramInt, @NonNull String paramString5, @NonNull String paramString6, @NonNull String paramString7, @NonNull String paramString8, @NonNull MediaModel paramMediaModel, String paramString9, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    if (this.jdField_a_of_type_JavaUtilMap.get(paramString5) == null)
    {
      paramString1 = new AEEditorVideoInfo(paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramString7, paramString8, paramMediaModel, paramString9, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5);
      paramString2 = this.jdField_a_of_type_JavaUtilMap;
      paramString2.put(paramString5, paramString1);
      e(paramString5);
    }
    else
    {
      paramString1 = (AEEditorVideoInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString5);
      if ((!paramString1.jdField_e_of_type_JavaLangString.equals("AEEDITOR_GENERATE_STATUS_ERROR")) && (!paramString1.jdField_e_of_type_JavaLangString.equals("AEEDITOR_GENERATE_STATUS_CANEL")))
      {
        if (paramString1.jdField_e_of_type_JavaLangString.equals("AEEDITOR_GENERATE_STATUS_READY")) {
          b(paramString1);
        }
        return;
      }
    }
    paramString1.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleExportAEEditorGenerateRunnable = new AEEditorGenerateRunnable(paramString5, paramString6, paramString7, paramMediaModel, this);
    a(paramString1);
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
      if ((((AEEditorVideoInfo)localEntry.getValue()).jdField_e_of_type_JavaLangString.equals("AEEDITOR_GENERATE_STATUS_DOWNLOADING")) || (((AEEditorVideoInfo)localEntry.getValue()).jdField_e_of_type_JavaLangString.equals("AEEDITOR_GENERATE_STATUS_WAIT"))) {
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAEEditorOrderBroadcastReceiver.unRegisterSelf(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_JavaUtilQueue.clear();
  }
  
  public void b(@NonNull String paramString)
  {
    paramString = (AEEditorVideoInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null)
    {
      paramString.jdField_b_of_type_Long = System.currentTimeMillis();
      paramString.jdField_e_of_type_JavaLangString = "AEEDITOR_GENERATE_STATUS_DOWNLOADING";
    }
  }
  
  public void c(@NonNull String paramString)
  {
    paramString = (AEEditorVideoInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null)
    {
      paramString.jdField_e_of_type_JavaLangString = "AEEDITOR_GENERATE_STATUS_CANEL";
      paramString.jdField_a_of_type_Float = 0.0F;
      this.jdField_a_of_type_JavaUtilQueue.remove(paramString);
      c();
    }
  }
  
  public void onAEEditorCancel(String paramString)
  {
    d(paramString);
  }
  
  public void onAEEditorRemove(String paramString)
  {
    f(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.AEEditorProcessManager
 * JD-Core Version:    0.7.0.1
 */