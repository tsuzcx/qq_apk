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
import com.tencent.qcircle.tavcut.TAVCut;
import com.tencent.qcircle.tavcut.exporter.VideoExporter;
import com.tencent.qcircle.weseevideo.common.utils.GsonUtils;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.ttpic.openapi.initializer.ImageAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.PagInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
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
  private final long a = 1000L;
  private final long b = 5000L;
  private Map<String, AEEditorVideoInfo> c = new ConcurrentHashMap();
  private boolean d = false;
  private AEEditorOrderBroadcastReceiver e = new AEEditorOrderBroadcastReceiver(this);
  private Queue<AEEditorVideoInfo> f = new ArrayDeque();
  
  private AEEditorProcessManager()
  {
    this.e.registerSelf(BaseApplicationImpl.getContext());
  }
  
  public static AEEditorProcessManager a()
  {
    return AEEditorProcessManager.InstanceHolder.a;
  }
  
  private void a(@NonNull AEEditorVideoInfo paramAEEditorVideoInfo)
  {
    if (this.f.size() == 0)
    {
      AEQLog.b("AEEditorProcessManager", "[tryStartTask] size 0");
      this.f.add(paramAEEditorVideoInfo);
      paramAEEditorVideoInfo.m = System.currentTimeMillis();
      paramAEEditorVideoInfo.i.run();
      return;
    }
    AEEditorVideoInfo localAEEditorVideoInfo = (AEEditorVideoInfo)this.f.peek();
    long l = System.currentTimeMillis();
    if ((localAEEditorVideoInfo != null) && (Math.abs(l - localAEEditorVideoInfo.m) > 5000L))
    {
      AEQLog.b("AEEditorProcessManager", "[tryStartTask] Dog Dead next Mission");
      this.f.remove(localAEEditorVideoInfo);
      this.f.add(paramAEEditorVideoInfo);
      e();
      return;
    }
    AEQLog.b("AEEditorProcessManager", "[tryStartTask]Dog alive");
    this.f.add(paramAEEditorVideoInfo);
  }
  
  private void b(@NonNull AEEditorVideoInfo paramAEEditorVideoInfo)
  {
    Intent localIntent = new Intent();
    localIntent.setAction(paramAEEditorVideoInfo.g);
    localIntent.setPackage(BaseApplicationImpl.getContext().getPackageName());
    localIntent.putExtra("generate_materialid", paramAEEditorVideoInfo.n);
    localIntent.putExtra("generate_materialname", paramAEEditorVideoInfo.o);
    localIntent.putExtra("generate_filterid", paramAEEditorVideoInfo.p);
    localIntent.putExtra("generate_scheme", paramAEEditorVideoInfo.q);
    localIntent.putExtra("generate_show_circle_take_same", paramAEEditorVideoInfo.r);
    localIntent.putExtra("generate_path", paramAEEditorVideoInfo.a);
    localIntent.putExtra("generate_mission", paramAEEditorVideoInfo.h);
    localIntent.putExtra("generate_progress", paramAEEditorVideoInfo.e);
    localIntent.putExtra("generate_thumb_ptah", paramAEEditorVideoInfo.d);
    localIntent.putExtra("generate_errorcode", paramAEEditorVideoInfo.k);
    localIntent.putExtra("generate_errormessage", paramAEEditorVideoInfo.l);
    localIntent.putExtra("generate_source_path", paramAEEditorVideoInfo.b);
    localIntent.putExtra("generate_KuolieId", paramAEEditorVideoInfo.s);
    localIntent.putExtra("generate_centerX", paramAEEditorVideoInfo.t);
    localIntent.putExtra("generate_centerY", paramAEEditorVideoInfo.u);
    localIntent.putExtra("generate_widthScale", paramAEEditorVideoInfo.w);
    localIntent.putExtra("generate_HeightScale", paramAEEditorVideoInfo.x);
    localIntent.putExtra("generate_rotate", paramAEEditorVideoInfo.v);
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  private void e()
  {
    if (this.f.size() == 0)
    {
      AEQLog.b("AEEditorProcessManager", "[tryStartNext] No mission");
      return;
    }
    AEEditorVideoInfo localAEEditorVideoInfo = (AEEditorVideoInfo)this.f.peek();
    if (localAEEditorVideoInfo != null)
    {
      AEQLog.b("AEEditorProcessManager", "[tryStartNext] next mission");
      localAEEditorVideoInfo.m = System.currentTimeMillis();
      localAEEditorVideoInfo.i.run();
    }
  }
  
  private void f(@NonNull String paramString)
  {
    AEQLog.b("AEEditorProcessManager", "[cancel mission]");
    paramString = (AEEditorVideoInfo)this.c.get(paramString);
    if ((paramString != null) && (!paramString.g.equals("AEEDITOR_GENERATE_STATUS_READY")))
    {
      paramString = paramString.i.a();
      if (paramString != null) {
        paramString.cancel();
      }
    }
  }
  
  private void g(@NonNull String paramString)
  {
    AEQLog.b("AEEditorProcessManager", "[save mission]");
    AEEditorVideoInfo localAEEditorVideoInfo = (AEEditorVideoInfo)this.c.get(paramString);
    if (localAEEditorVideoInfo != null)
    {
      AECameraPrefsUtil.a().a(paramString, localAEEditorVideoInfo.j.toString(), 4);
      AECameraPrefsUtil localAECameraPrefsUtil = AECameraPrefsUtil.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("sourcePath");
      localAECameraPrefsUtil.a(localStringBuilder.toString(), localAEEditorVideoInfo.b, 4);
      localAECameraPrefsUtil = AECameraPrefsUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("outputPath");
      localAECameraPrefsUtil.a(localStringBuilder.toString(), localAEEditorVideoInfo.c, 4);
      localAECameraPrefsUtil = AECameraPrefsUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("thumbPath");
      localAECameraPrefsUtil.a(localStringBuilder.toString(), localAEEditorVideoInfo.d, 4);
      localAECameraPrefsUtil = AECameraPrefsUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("status");
      localAECameraPrefsUtil.a(localStringBuilder.toString(), localAEEditorVideoInfo.g, 4);
      localAECameraPrefsUtil = AECameraPrefsUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("materialID");
      localAECameraPrefsUtil.a(localStringBuilder.toString(), localAEEditorVideoInfo.n, 4);
      localAECameraPrefsUtil = AECameraPrefsUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("materialName");
      localAECameraPrefsUtil.a(localStringBuilder.toString(), localAEEditorVideoInfo.o, 4);
      localAECameraPrefsUtil = AECameraPrefsUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("filterID");
      localAECameraPrefsUtil.a(localStringBuilder.toString(), localAEEditorVideoInfo.p, 4);
      localAECameraPrefsUtil = AECameraPrefsUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("scheme");
      localAECameraPrefsUtil.a(localStringBuilder.toString(), localAEEditorVideoInfo.q, 4);
      localAECameraPrefsUtil = AECameraPrefsUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("showCircleTakeSame");
      localAECameraPrefsUtil.a(localStringBuilder.toString(), localAEEditorVideoInfo.r, 4);
      localAECameraPrefsUtil = AECameraPrefsUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("mKuolieId");
      localAECameraPrefsUtil.a(localStringBuilder.toString(), localAEEditorVideoInfo.s, 4);
      localAECameraPrefsUtil = AECameraPrefsUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("mKuolieCenterX");
      localAECameraPrefsUtil.a(localStringBuilder.toString(), localAEEditorVideoInfo.t, 4);
      localAECameraPrefsUtil = AECameraPrefsUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("mKuolieCenterY");
      localAECameraPrefsUtil.a(localStringBuilder.toString(), localAEEditorVideoInfo.u, 4);
      localAECameraPrefsUtil = AECameraPrefsUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("mKuolieWidthScale");
      localAECameraPrefsUtil.a(localStringBuilder.toString(), localAEEditorVideoInfo.w, 4);
      localAECameraPrefsUtil = AECameraPrefsUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("mKuolieHeightScale");
      localAECameraPrefsUtil.a(localStringBuilder.toString(), localAEEditorVideoInfo.x, 4);
      localAECameraPrefsUtil = AECameraPrefsUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("mKuolieRotate");
      localAECameraPrefsUtil.a(localStringBuilder.toString(), localAEEditorVideoInfo.v, 4);
    }
  }
  
  private void h(@NonNull String paramString)
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
  
  public void a(@Nullable String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      AEQLog.d("AEEditorProcessManager", "[requestGenerateVideo] mission is none");
      return;
    }
    AEEditorVideoInfo localAEEditorVideoInfo = (AEEditorVideoInfo)this.c.get(paramString);
    if (localAEEditorVideoInfo == null)
    {
      Object localObject1 = AECameraPrefsUtil.a();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("sourcePath");
      localObject1 = ((AECameraPrefsUtil)localObject1).b(((StringBuilder)localObject2).toString(), "", 4);
      localObject2 = AECameraPrefsUtil.a();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramString);
      ((StringBuilder)localObject3).append("outputPath");
      localObject2 = ((AECameraPrefsUtil)localObject2).b(((StringBuilder)localObject3).toString(), "", 4);
      localObject3 = AECameraPrefsUtil.a();
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(paramString);
      ((StringBuilder)localObject4).append("thumbPath");
      localObject3 = ((AECameraPrefsUtil)localObject3).b(((StringBuilder)localObject4).toString(), "", 4);
      localObject4 = AECameraPrefsUtil.a();
      Object localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(paramString);
      ((StringBuilder)localObject5).append("status");
      localObject4 = ((AECameraPrefsUtil)localObject4).b(((StringBuilder)localObject5).toString(), "", 4);
      localObject5 = AECameraPrefsUtil.a();
      Object localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append(paramString);
      ((StringBuilder)localObject6).append("materialID");
      localObject5 = ((AECameraPrefsUtil)localObject5).b(((StringBuilder)localObject6).toString(), "", 4);
      localObject6 = AECameraPrefsUtil.a();
      Object localObject7 = new StringBuilder();
      ((StringBuilder)localObject7).append(paramString);
      ((StringBuilder)localObject7).append("materialName");
      localObject6 = ((AECameraPrefsUtil)localObject6).b(((StringBuilder)localObject7).toString(), "", 4);
      localObject7 = AECameraPrefsUtil.a();
      Object localObject8 = new StringBuilder();
      ((StringBuilder)localObject8).append(paramString);
      ((StringBuilder)localObject8).append("filterID");
      localObject7 = ((AECameraPrefsUtil)localObject7).b(((StringBuilder)localObject8).toString(), "", 4);
      localObject8 = AECameraPrefsUtil.a();
      Object localObject9 = new StringBuilder();
      ((StringBuilder)localObject9).append(paramString);
      ((StringBuilder)localObject9).append("scheme");
      localObject8 = ((AECameraPrefsUtil)localObject8).b(((StringBuilder)localObject9).toString(), "", 4);
      localObject9 = AECameraPrefsUtil.a();
      Object localObject10 = new StringBuilder();
      ((StringBuilder)localObject10).append(paramString);
      ((StringBuilder)localObject10).append("showCircleTakeSame");
      int i = ((AECameraPrefsUtil)localObject9).b(((StringBuilder)localObject10).toString(), 0, 4);
      localObject9 = AECameraPrefsUtil.a();
      localObject10 = new StringBuilder();
      ((StringBuilder)localObject10).append(paramString);
      ((StringBuilder)localObject10).append("mKuolieId");
      localObject9 = ((AECameraPrefsUtil)localObject9).b(((StringBuilder)localObject10).toString(), "", 4);
      localObject10 = AECameraPrefsUtil.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("mKuolieCenterX");
      float f1 = ((AECameraPrefsUtil)localObject10).b(localStringBuilder.toString(), 0.0F, 4);
      localObject10 = AECameraPrefsUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("mKuolieCenterY");
      float f2 = ((AECameraPrefsUtil)localObject10).b(localStringBuilder.toString(), 0.0F, 4);
      localObject10 = AECameraPrefsUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("mKuolieWidthScale");
      float f3 = ((AECameraPrefsUtil)localObject10).b(localStringBuilder.toString(), 0.0F, 4);
      localObject10 = AECameraPrefsUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("mKuolieHeightScale");
      float f4 = ((AECameraPrefsUtil)localObject10).b(localStringBuilder.toString(), 0.0F, 4);
      localObject10 = AECameraPrefsUtil.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("mKuolieRotate");
      float f5 = ((AECameraPrefsUtil)localObject10).b(localStringBuilder.toString(), 0.0F, 4);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject4)))
      {
        if (((String)localObject4).equals("AEEDITOR_GENERATE_STATUS_READY"))
        {
          AEQLog.b("AEEditorProcessManager", "[requestGenerateVideo] mission is Ready");
          paramString = new AEEditorVideoInfo((String)localObject5, (String)localObject6, (String)localObject7, (String)localObject8, i, paramString, (String)localObject1, (String)localObject2, (String)localObject3, null, (String)localObject9, f1, f2, f3, f4, f5);
          paramString.g = "AEEDITOR_GENERATE_STATUS_READY";
          b(paramString);
          return;
        }
        localObject4 = b(paramString);
        AEQLog.b("AEEditorProcessManager", "[requestGenerateVideo] peak is dead");
        if (localObject4 == null)
        {
          localAEEditorVideoInfo.g = "AEEDITOR_GENERATE_STATUS_ERROR";
          localAEEditorVideoInfo.k = -2;
          AEQLog.d("AEEditorProcessManager", "[requestGenerateVideo] GENERATE_ERROR_NODATA");
          b(localAEEditorVideoInfo);
          return;
        }
        a((String)localObject5, (String)localObject6, (String)localObject7, (String)localObject8, i, paramString, (String)localObject1, (String)localObject2, (String)localObject3, (MediaModel)localObject4, (String)localObject9, f1, f2, f3, f4, f5);
        return;
      }
      paramString = new AEEditorVideoInfo((String)localObject5, (String)localObject6, (String)localObject7, (String)localObject8, i, paramString, (String)localObject1, (String)localObject2, (String)localObject3, null, (String)localObject9, f1, f2, f3, f4, f5);
      paramString.g = "AEEDITOR_GENERATE_STATUS_ERROR";
      paramString.k = -2;
      AEQLog.d("AEEditorProcessManager", "[requestGenerateVideo] GENERATE_ERROR_NODATA");
      b(paramString);
      return;
    }
    AEQLog.b("AEEditorProcessManager", "[requestGenerateVideo] peak is alive");
    a(localAEEditorVideoInfo.n, localAEEditorVideoInfo.o, localAEEditorVideoInfo.p, localAEEditorVideoInfo.q, localAEEditorVideoInfo.r, paramString, localAEEditorVideoInfo.b, localAEEditorVideoInfo.c, localAEEditorVideoInfo.d, localAEEditorVideoInfo.j, localAEEditorVideoInfo.s, localAEEditorVideoInfo.t, localAEEditorVideoInfo.u, localAEEditorVideoInfo.w, localAEEditorVideoInfo.x, localAEEditorVideoInfo.v);
  }
  
  public void a(@NonNull String paramString, float paramFloat)
  {
    paramString = (AEEditorVideoInfo)this.c.get(paramString);
    if (paramString != null)
    {
      paramString.m = System.currentTimeMillis();
      paramString.e = paramFloat;
      long l = System.currentTimeMillis();
      if (Math.abs(l - paramString.f) > 1000L)
      {
        paramString.f = l;
        b(paramString);
      }
    }
  }
  
  public void a(@NonNull String paramString1, int paramInt, String paramString2)
  {
    paramString1 = (AEEditorVideoInfo)this.c.get(paramString1);
    if (paramString1 != null)
    {
      paramString1.g = "AEEDITOR_GENERATE_STATUS_ERROR";
      paramString1.l = paramString2;
      paramString1.e = 0.0F;
      paramString1.k = paramInt;
      b(paramString1);
      this.f.remove(paramString1);
      e();
    }
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2)
  {
    AEEditorVideoInfo localAEEditorVideoInfo = (AEEditorVideoInfo)this.c.get(paramString1);
    if (localAEEditorVideoInfo != null)
    {
      localAEEditorVideoInfo.g = "AEEDITOR_GENERATE_STATUS_READY";
      localAEEditorVideoInfo.a = paramString2;
      localAEEditorVideoInfo.e = 1.0F;
      b(localAEEditorVideoInfo);
      paramString2 = AECameraPrefsUtil.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("status");
      paramString2.a(localStringBuilder.toString(), localAEEditorVideoInfo.g, 4);
      this.f.remove(localAEEditorVideoInfo);
      e();
    }
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3, @NonNull String paramString4, int paramInt, @NonNull String paramString5, @NonNull String paramString6, @NonNull String paramString7, @NonNull String paramString8, @NonNull MediaModel paramMediaModel, String paramString9, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    if (this.c.get(paramString5) == null)
    {
      paramString1 = new AEEditorVideoInfo(paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramString7, paramString8, paramMediaModel, paramString9, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5);
      paramString2 = this.c;
      paramString2.put(paramString5, paramString1);
      g(paramString5);
    }
    else
    {
      paramString1 = (AEEditorVideoInfo)this.c.get(paramString5);
      if ((!paramString1.g.equals("AEEDITOR_GENERATE_STATUS_ERROR")) && (!paramString1.g.equals("AEEDITOR_GENERATE_STATUS_CANEL")))
      {
        if (paramString1.g.equals("AEEDITOR_GENERATE_STATUS_READY")) {
          b(paramString1);
        }
        return;
      }
    }
    paramString1.i = new AEEditorGenerateRunnable(paramString5, paramString6, paramString7, paramMediaModel, this);
    a(paramString1);
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  @Nullable
  public MediaModel b(@NonNull String paramString)
  {
    paramString = AECameraPrefsUtil.a().b(paramString, "", 4);
    if (!TextUtils.isEmpty(paramString)) {
      return (MediaModel)GsonUtils.json2Obj(paramString, MediaModel.class);
    }
    return null;
  }
  
  public void b()
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
    TAVCut.initTAVCut(BaseApplicationImpl.getContext(), FeatureManager.getResourceDir(), FeatureManager.getResourceDir(), AEResUtil.n(), new AEEditorProcessManager.1(this));
  }
  
  public AEEditorVideoInfo c(String paramString)
  {
    Map localMap = this.c;
    if (localMap != null) {
      return (AEEditorVideoInfo)localMap.get(paramString);
    }
    return null;
  }
  
  public void c()
  {
    this.e.unRegisterSelf(BaseApplicationImpl.getContext());
    this.f.clear();
  }
  
  public void d(@NonNull String paramString)
  {
    paramString = (AEEditorVideoInfo)this.c.get(paramString);
    if (paramString != null)
    {
      paramString.m = System.currentTimeMillis();
      paramString.g = "AEEDITOR_GENERATE_STATUS_DOWNLOADING";
    }
  }
  
  public boolean d()
  {
    if (this.d) {
      return true;
    }
    Iterator localIterator = this.c.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((((AEEditorVideoInfo)localEntry.getValue()).g.equals("AEEDITOR_GENERATE_STATUS_DOWNLOADING")) || (((AEEditorVideoInfo)localEntry.getValue()).g.equals("AEEDITOR_GENERATE_STATUS_WAIT"))) {
        return true;
      }
    }
    return false;
  }
  
  public void e(@NonNull String paramString)
  {
    paramString = (AEEditorVideoInfo)this.c.get(paramString);
    if (paramString != null)
    {
      paramString.g = "AEEDITOR_GENERATE_STATUS_CANEL";
      paramString.e = 0.0F;
      this.f.remove(paramString);
      e();
    }
  }
  
  public void onAEEditorCancel(String paramString)
  {
    f(paramString);
  }
  
  public void onAEEditorRemove(String paramString)
  {
    h(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.AEEditorProcessManager
 * JD-Core Version:    0.7.0.1
 */