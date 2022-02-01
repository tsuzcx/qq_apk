package com.tencent.aelight.camera.ae.camera.ui.panel.daoju;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.aelight.camera.ae.camera.ui.panel.MaterialViewHolder;
import com.tencent.aelight.camera.ae.data.AEMaterialCategory;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.download.AEMaterialDownloader.MaterialDownloadListener;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.flashshow.FlashShowDtReportHelper;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/panel/daoju/AENewMaterialAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/MaterialViewHolder;", "Lcom/tencent/aelight/camera/ae/download/AEMaterialDownloader$MaterialDownloadListener;", "mContext", "Landroid/content/Context;", "mRepository", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/daoju/AEMaterialRepository;", "mEnvironment", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/daoju/AEMaterialEnvironment;", "(Landroid/content/Context;Lcom/tencent/aelight/camera/ae/camera/ui/panel/daoju/AEMaterialRepository;Lcom/tencent/aelight/camera/ae/camera/ui/panel/daoju/AEMaterialEnvironment;)V", "mCategory", "Lcom/tencent/aelight/camera/ae/data/AEMaterialCategory;", "mLastMaterial", "Lcom/tencent/aelight/camera/ae/data/AEMaterialMetaData;", "mPendingReportMaterialIds", "Ljava/util/HashSet;", "", "mReportHandler", "com/tencent/aelight/camera/ae/camera/ui/panel/daoju/AENewMaterialAdapter$mReportHandler$1", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/daoju/AENewMaterialAdapter$mReportHandler$1;", "mTemplateList", "", "cancelPendingReportExpose", "", "info", "downloadMaterial", "material", "getItemCount", "", "onBindViewHolder", "viewHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "onDetachedFromRecyclerView", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onDownloadFinish", "isSuccess", "", "resCode", "onMaterialClicked", "onProgressUpdate", "progress", "onViewAttachedToWindow", "holder", "onViewDetachedFromWindow", "pendingReportExpose", "selectSpecificMaterial", "setCategory", "category", "setMaterialList", "list", "Companion", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AENewMaterialAdapter
  extends RecyclerView.Adapter<MaterialViewHolder>
  implements AEMaterialDownloader.MaterialDownloadListener
{
  public static final AENewMaterialAdapter.Companion a = new AENewMaterialAdapter.Companion(null);
  private AEMaterialCategory b;
  private List<? extends AEMaterialMetaData> c;
  private AEMaterialMetaData d;
  private final HashSet<String> e;
  private final AENewMaterialAdapter.mReportHandler.1 f;
  private final Context g;
  private final AEMaterialRepository h;
  private final AEMaterialEnvironment i;
  
  public AENewMaterialAdapter(@NotNull Context paramContext, @NotNull AEMaterialRepository paramAEMaterialRepository, @NotNull AEMaterialEnvironment paramAEMaterialEnvironment)
  {
    this.g = paramContext;
    this.h = paramAEMaterialRepository;
    this.i = paramAEMaterialEnvironment;
    this.c = CollectionsKt.emptyList();
    this.e = new HashSet();
    this.f = new AENewMaterialAdapter.mReportHandler.1(this, ThreadManager.getSubThreadLooper());
  }
  
  private final void b(AEMaterialMetaData paramAEMaterialMetaData)
  {
    Message localMessage = this.f.obtainMessage(1);
    localMessage.what = 1;
    localMessage.obj = paramAEMaterialMetaData;
    this.f.sendMessageDelayed(localMessage, 500L);
    this.e.add(paramAEMaterialMetaData.m);
  }
  
  private final void c(AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.e.remove(paramAEMaterialMetaData.m);
  }
  
  private final void d(AEMaterialMetaData paramAEMaterialMetaData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onMaterialClicked, categoryname = [");
    Object localObject = this.b;
    if (localObject != null) {
      localObject = ((AEMaterialCategory)localObject).d;
    } else {
      localObject = null;
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("], materialid = [");
    localStringBuilder.append(paramAEMaterialMetaData.m);
    localStringBuilder.append(']');
    AEQLog.b("AEBottomPanelPart_AENewMaterialAdapter", localStringBuilder.toString());
    if ((Intrinsics.areEqual(this.d, paramAEMaterialMetaData) ^ true))
    {
      localObject = this.d;
      if (localObject != null) {
        ((AEMaterialMetaData)localObject).v = false;
      }
      localObject = this.d;
      if (localObject != null) {
        ((AEMaterialMetaData)localObject).w = false;
      }
    }
    if (paramAEMaterialMetaData.v) {
      paramAEMaterialMetaData.w = true;
    }
    paramAEMaterialMetaData.v = true;
    a(paramAEMaterialMetaData);
  }
  
  private final void e(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData.B) {
      return;
    }
    if (TextUtils.isEmpty((CharSequence)paramAEMaterialMetaData.m)) {
      return;
    }
    this.h.a(paramAEMaterialMetaData, (AEMaterialDownloader.MaterialDownloadListener)this);
  }
  
  @NotNull
  public MaterialViewHolder a(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "viewGroup");
    paramViewGroup = new MaterialViewHolder(LayoutInflater.from(this.g).inflate(2064056372, paramViewGroup, false));
    paramViewGroup.a(this.g);
    return paramViewGroup;
  }
  
  public void a(@Nullable MaterialViewHolder paramMaterialViewHolder)
  {
    if (paramMaterialViewHolder != null)
    {
      int j = paramMaterialViewHolder.getAdapterPosition();
      if (j == -1) {
        return;
      }
      AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)this.c.get(j);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onViewAttachedToWindow---position=");
      localStringBuilder.append(j);
      localStringBuilder.append(", material=");
      if (localAEMaterialMetaData != null) {
        paramMaterialViewHolder = localAEMaterialMetaData.m;
      } else {
        paramMaterialViewHolder = null;
      }
      localStringBuilder.append(paramMaterialViewHolder);
      AEQLog.a("AEBottomPanelPart_AENewMaterialAdapter", localStringBuilder.toString());
      if (localAEMaterialMetaData != null) {
        b(localAEMaterialMetaData);
      }
    }
  }
  
  public void a(@NotNull MaterialViewHolder paramMaterialViewHolder, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramMaterialViewHolder, "viewHolder");
    Object localObject1 = (AEMaterialMetaData)this.c.get(paramInt);
    Object localObject2 = this.h.b();
    if ((((AEMaterialMetaData)localObject1).A) && (Intrinsics.areEqual(((AEMaterialMetaData)localObject1).m, localObject2)))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("update selected material: ");
      ((StringBuilder)localObject2).append(((AEMaterialMetaData)localObject1).m);
      AEQLog.b("AEBottomPanelPart_AENewMaterialAdapter", ((StringBuilder)localObject2).toString());
      paramMaterialViewHolder.a(2, (AEMaterialMetaData)localObject1);
    }
    else
    {
      ((AEMaterialMetaData)localObject1).u = false;
      paramMaterialViewHolder.a(1, (AEMaterialMetaData)localObject1);
    }
    VideoReport.setElementReuseIdentifier(paramMaterialViewHolder.itemView, ((AEMaterialMetaData)localObject1).m);
    paramMaterialViewHolder.itemView.setOnClickListener((View.OnClickListener)new AENewMaterialAdapter.onBindViewHolder.1(this, (AEMaterialMetaData)localObject1));
    VideoReport.setElementId(paramMaterialViewHolder.itemView, "em_xsj_props_item");
    localObject2 = new HashMap();
    ((HashMap)localObject2).putAll(FlashShowDtReportHelper.a().c());
    ((HashMap)localObject2).put("xsj_props_name", ((AEMaterialMetaData)localObject1).m);
    localObject1 = this.b;
    if (localObject1 != null)
    {
      localObject1 = ((AEMaterialCategory)localObject1).d;
      if (localObject1 != null) {}
    }
    else
    {
      localObject1 = "none";
    }
    ((HashMap)localObject2).put("xsj_props_category", localObject1);
    VideoReport.setElementParams(paramMaterialViewHolder.itemView, (Map)localObject2);
  }
  
  public final void a(@Nullable AEMaterialCategory paramAEMaterialCategory)
  {
    this.b = paramAEMaterialCategory;
  }
  
  public final void a(@NotNull AEMaterialMetaData paramAEMaterialMetaData)
  {
    Intrinsics.checkParameterIsNotNull(paramAEMaterialMetaData, "material");
    this.d = paramAEMaterialMetaData;
    Object localObject = (CharSequence)paramAEMaterialMetaData.m;
    int j;
    if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
      j = 0;
    } else {
      j = 1;
    }
    if ((j == 0) && (!AEMaterialMetaData.a(paramAEMaterialMetaData)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("### [material panel] select material id = ");
      ((StringBuilder)localObject).append(paramAEMaterialMetaData.m);
      AEQLog.b("AEBottomPanelPart_AENewMaterialAdapter", ((StringBuilder)localObject).toString());
      if (paramAEMaterialMetaData.a())
      {
        WeishiGuideUtils.a(this.g, paramAEMaterialMetaData, 1);
        return;
      }
      if (!paramAEMaterialMetaData.A)
      {
        this.h.a(paramAEMaterialMetaData.m);
        e(paramAEMaterialMetaData);
        return;
      }
      if (!AEResUtil.e())
      {
        QQToast.makeText((Context)BaseApplicationImpl.getContext(), (CharSequence)HardCodeUtil.a(2131907500), 0).show();
        ThreadManager.excute((Runnable)AENewMaterialAdapter.selectSpecificMaterial.1.a, 64, null, true);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("### [material panel] select material ");
      ((StringBuilder)localObject).append(paramAEMaterialMetaData.m);
      AEQLog.b("AEBottomPanelPart_AENewMaterialAdapter", ((StringBuilder)localObject).toString());
      this.h.a(paramAEMaterialMetaData);
    }
    else
    {
      AEQLog.b("AEBottomPanelPart_AENewMaterialAdapter", "### [material panel] select material none");
      localObject = this.g;
      if (localObject == null) {
        break label396;
      }
      ((Activity)localObject).getIntent().removeExtra("widgetinfo");
      this.h.a(paramAEMaterialMetaData);
    }
    AEBaseReportParam.a().b(paramAEMaterialMetaData.W);
    AEBaseReportParam.a().a(paramAEMaterialMetaData.m);
    AEBaseReportParam.a().f(-1);
    AEBaseReportParam.a().r("none");
    AEBaseReportParam.a().q("1");
    AEBaseReportParam.a().g(0);
    AEBaseDataReporter.a().c(paramAEMaterialMetaData.m);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("【Select Material】：");
    ((StringBuilder)localObject).append(paramAEMaterialMetaData.m);
    AEQLog.b("AEBottomPanelPart_AENewMaterialAdapter", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("【Select Material】Usable :");
    ((StringBuilder)localObject).append(paramAEMaterialMetaData.A);
    AEQLog.b("AEBottomPanelPart_AENewMaterialAdapter", ((StringBuilder)localObject).toString());
    return;
    label396:
    throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
  }
  
  public final void a(@NotNull List<? extends AEMaterialMetaData> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "list");
    this.c = ((List)new ArrayList((Collection)paramList));
    notifyDataSetChanged();
  }
  
  public void b(@Nullable MaterialViewHolder paramMaterialViewHolder)
  {
    if (paramMaterialViewHolder != null)
    {
      int j = paramMaterialViewHolder.getAdapterPosition();
      if (j == -1) {
        return;
      }
      AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)this.c.get(j);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onViewDetachedFromWindow---position=");
      localStringBuilder.append(j);
      localStringBuilder.append(", material=");
      if (localAEMaterialMetaData != null) {
        paramMaterialViewHolder = localAEMaterialMetaData.m;
      } else {
        paramMaterialViewHolder = null;
      }
      localStringBuilder.append(paramMaterialViewHolder);
      AEQLog.a("AEBottomPanelPart_AENewMaterialAdapter", localStringBuilder.toString());
      if (localAEMaterialMetaData != null) {
        c(localAEMaterialMetaData);
      }
    }
  }
  
  public int getItemCount()
  {
    return this.c.size();
  }
  
  public void onDetachedFromRecyclerView(@Nullable RecyclerView paramRecyclerView)
  {
    AEQLog.a("AEBottomPanelPart_AENewMaterialAdapter", "onDetachedFromRecyclerView");
    this.f.removeMessages(1);
    this.e.clear();
  }
  
  public void onDownloadFinish(@Nullable AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean, int paramInt)
  {
    if (paramAEMaterialMetaData != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("material [");
      ((StringBuilder)localObject).append(paramAEMaterialMetaData.m);
      ((StringBuilder)localObject).append("] download finish, success = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", resCode = ");
      ((StringBuilder)localObject).append(paramInt);
      AEQLog.b("AEBottomPanelPart_AENewMaterialAdapter", ((StringBuilder)localObject).toString());
      if (!paramBoolean)
      {
        ThreadManager.getUIHandler().post((Runnable)new AENewMaterialAdapter.onDownloadFinish.1(this));
        return;
      }
      Iterator localIterator = ((Iterable)this.c).iterator();
      while (localIterator.hasNext())
      {
        localObject = localIterator.next();
        if (Intrinsics.areEqual(((AEMaterialMetaData)localObject).m, paramAEMaterialMetaData.m))
        {
          paramAEMaterialMetaData = (AEMaterialMetaData)localObject;
          break label156;
        }
      }
      paramAEMaterialMetaData = null;
      label156:
      paramAEMaterialMetaData = (AEMaterialMetaData)paramAEMaterialMetaData;
      if (paramAEMaterialMetaData == null)
      {
        AEQLog.b("AEBottomPanelPart_AENewMaterialAdapter", "download material is not present in list anymore!");
        return;
      }
      ThreadManager.getUIHandler().post((Runnable)new AENewMaterialAdapter.onDownloadFinish.2(this, paramAEMaterialMetaData));
    }
  }
  
  public void onProgressUpdate(@Nullable AEMaterialMetaData paramAEMaterialMetaData, int paramInt)
  {
    if (paramAEMaterialMetaData != null)
    {
      Object localObject = this.c;
      paramInt = 0;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)((Iterator)localObject).next();
        if (Intrinsics.areEqual(paramAEMaterialMetaData.m, localAEMaterialMetaData.m)) {
          break label65;
        }
        paramInt += 1;
      }
      paramInt = -1;
      label65:
      if (paramInt >= 0) {
        ThreadManager.getUIHandler().post((Runnable)new AENewMaterialAdapter.onProgressUpdate.1(this, paramInt));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.daoju.AENewMaterialAdapter
 * JD-Core Version:    0.7.0.1
 */