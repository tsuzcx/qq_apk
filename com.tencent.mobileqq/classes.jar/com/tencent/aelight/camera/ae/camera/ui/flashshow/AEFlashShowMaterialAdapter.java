package com.tencent.aelight.camera.ae.camera.ui.flashshow;

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
import com.tencent.aelight.camera.ae.control.AEQIMManager;
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
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowMaterialAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/FlashShowMaterialViewHolder;", "Lcom/tencent/mobileqq/shortvideo/common/Observer;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/aelight/camera/ae/download/AEMaterialDownloader$MaterialDownloadListener;", "mContext", "Landroid/content/Context;", "gridView", "Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowGridView;", "listener", "Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowMaterialPanel$AEMaterialPanelListener;", "isFavoriteTab", "", "(Landroid/content/Context;Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowGridView;Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowMaterialPanel$AEMaterialPanelListener;Z)V", "mCategory", "Lcom/tencent/aelight/camera/ae/data/AEMaterialCategory;", "mGridView", "mLastMaterialMetaData", "Lcom/tencent/aelight/camera/ae/data/AEMaterialMetaData;", "getMLastMaterialMetaData", "()Lcom/tencent/aelight/camera/ae/data/AEMaterialMetaData;", "setMLastMaterialMetaData", "(Lcom/tencent/aelight/camera/ae/data/AEMaterialMetaData;)V", "mLastSelectedMaterialId", "", "getMLastSelectedMaterialId", "()Ljava/lang/String;", "setMLastSelectedMaterialId", "(Ljava/lang/String;)V", "mLayoutInflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "mMaterialPanelListener", "mPendingReportMaterialIds", "Ljava/util/HashSet;", "mReportHandler", "com/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowMaterialAdapter$mReportHandler$1", "Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowMaterialAdapter$mReportHandler$1;", "mTemplateList", "Ljava/util/ArrayList;", "mTemplateManager", "Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowMaterialManager;", "cancelPendingReportExpose", "", "info", "doRealDownload", "data", "downloadMaterial", "findMaterialIndex", "", "getItemCount", "notify", "sender", "", "eventId", "args", "", "(Ljava/lang/Object;I[Ljava/lang/Object;)V", "onBindViewHolder", "viewHolder", "position", "onClick", "view", "Landroid/view/View;", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "onDetachedFromRecyclerView", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onDownloadFinish", "isSuccess", "resCode", "onProgressUpdate", "progress", "onViewAttachedToWindow", "holder", "onViewDetachedFromWindow", "pendingReportExpose", "resetWaterMarkInfoOnChangeMaterial", "selectSpecificMaterial", "toggleWatermarkEditIcon", "show", "material", "updateMaterialList", "category", "items", "", "Companion", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AEFlashShowMaterialAdapter
  extends RecyclerView.Adapter<FlashShowMaterialViewHolder>
  implements View.OnClickListener, AEMaterialDownloader.MaterialDownloadListener, Observer
{
  public static final AEFlashShowMaterialAdapter.Companion a = new AEFlashShowMaterialAdapter.Companion(null);
  private final LayoutInflater b;
  private final AEFlashShowGridView c;
  private final AEFlashShowMaterialManager d;
  private AEMaterialCategory e;
  private ArrayList<AEMaterialMetaData> f;
  @Nullable
  private AEMaterialMetaData g;
  @Nullable
  private String h;
  private final AEFlashShowMaterialPanel.AEMaterialPanelListener i;
  private boolean j;
  private final HashSet<String> k;
  private final AEFlashShowMaterialAdapter.mReportHandler.1 l;
  private final Context m;
  
  public AEFlashShowMaterialAdapter(@NotNull Context paramContext, @NotNull AEFlashShowGridView paramAEFlashShowGridView, @Nullable AEFlashShowMaterialPanel.AEMaterialPanelListener paramAEMaterialPanelListener, boolean paramBoolean)
  {
    this.m = paramContext;
    this.b = LayoutInflater.from(this.m);
    this.f = new ArrayList();
    this.k = new HashSet();
    this.l = new AEFlashShowMaterialAdapter.mReportHandler.1(this, ThreadManager.getSubThreadLooper());
    paramContext = AEQIMManager.a(3);
    if (paramContext != null)
    {
      this.d = ((AEFlashShowMaterialManager)paramContext);
      this.i = paramAEMaterialPanelListener;
      this.c = paramAEFlashShowGridView;
      this.j = paramBoolean;
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMaterialManager");
  }
  
  private final void a(boolean paramBoolean, Object paramObject)
  {
    if (paramObject != null)
    {
      paramObject = (VideoMaterial)paramObject;
      if (paramObject != null)
      {
        ArrayList localArrayList = this.f;
        int n = 0;
        int i1 = ((Collection)localArrayList).size();
        while (n < i1)
        {
          if ((paramObject.getId() != null) && (Intrinsics.areEqual(paramObject.getId(), ((AEMaterialMetaData)localArrayList.get(n)).m)))
          {
            ((AEMaterialMetaData)localArrayList.get(n)).u = paramBoolean;
            notifyItemChanged(n, Integer.valueOf(1));
            return;
          }
          n += 1;
        }
      }
      return;
    }
    paramObject = new TypeCastException("null cannot be cast to non-null type com.tencent.ttpic.openapi.model.VideoMaterial");
    for (;;)
    {
      throw paramObject;
    }
  }
  
  private final void b(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if ((Intrinsics.areEqual(this.g, paramAEMaterialMetaData) ^ true))
    {
      AEMaterialMetaData localAEMaterialMetaData = this.g;
      if (localAEMaterialMetaData != null) {
        localAEMaterialMetaData.v = false;
      }
      localAEMaterialMetaData = this.g;
      if (localAEMaterialMetaData != null) {
        localAEMaterialMetaData.w = false;
      }
    }
    this.g = paramAEMaterialMetaData;
  }
  
  private final int c(AEMaterialMetaData paramAEMaterialMetaData)
  {
    int i1 = ((Collection)this.f).size();
    int n = 0;
    while (n < i1)
    {
      if (Intrinsics.areEqual(((AEMaterialMetaData)this.f.get(n)).m, paramAEMaterialMetaData.m)) {
        return n;
      }
      n += 1;
    }
    return 0;
  }
  
  private final void d(AEMaterialMetaData paramAEMaterialMetaData)
  {
    Message localMessage = this.l.obtainMessage(1);
    localMessage.what = 1;
    localMessage.obj = paramAEMaterialMetaData;
    this.l.sendMessageDelayed(localMessage, 500L);
    this.k.add(paramAEMaterialMetaData.m);
  }
  
  private final void e(AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.k.remove(paramAEMaterialMetaData.m);
  }
  
  private final void f(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData == null) {
      return;
    }
    if (paramAEMaterialMetaData.B) {
      return;
    }
    if (TextUtils.isEmpty((CharSequence)paramAEMaterialMetaData.m)) {
      return;
    }
    if (this.d == null) {
      return;
    }
    g(paramAEMaterialMetaData);
  }
  
  private final void g(AEMaterialMetaData paramAEMaterialMetaData)
  {
    AEFlashShowMaterialManager localAEFlashShowMaterialManager = this.d;
    if (localAEFlashShowMaterialManager != null) {
      localAEFlashShowMaterialManager.a(localAEFlashShowMaterialManager.getApp(), paramAEMaterialMetaData, (AEMaterialDownloader.MaterialDownloadListener)this);
    }
  }
  
  @NotNull
  public FlashShowMaterialViewHolder a(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "viewGroup");
    paramViewGroup = this.b.inflate(2064056355, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "mLayoutInflater.inflate(…l_item, viewGroup, false)");
    FlashShowMaterialViewHolder localFlashShowMaterialViewHolder = new FlashShowMaterialViewHolder(paramViewGroup);
    localFlashShowMaterialViewHolder.a(this.m);
    paramViewGroup.setOnClickListener((View.OnClickListener)this);
    return localFlashShowMaterialViewHolder;
  }
  
  @Nullable
  public final String a()
  {
    return this.h;
  }
  
  public void a(@Nullable FlashShowMaterialViewHolder paramFlashShowMaterialViewHolder)
  {
    if (paramFlashShowMaterialViewHolder != null)
    {
      int n = paramFlashShowMaterialViewHolder.getAdapterPosition();
      paramFlashShowMaterialViewHolder = this.f.get(n);
      Intrinsics.checkExpressionValueIsNotNull(paramFlashShowMaterialViewHolder, "mTemplateList[adapterPosition]");
      AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)paramFlashShowMaterialViewHolder;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onViewAttachedToWindow---position=");
      localStringBuilder.append(n);
      localStringBuilder.append(", material=");
      if (localAEMaterialMetaData != null) {
        paramFlashShowMaterialViewHolder = localAEMaterialMetaData.m;
      } else {
        paramFlashShowMaterialViewHolder = null;
      }
      localStringBuilder.append(paramFlashShowMaterialViewHolder);
      AEQLog.a("AEMaterialAdapter", localStringBuilder.toString());
      if (localAEMaterialMetaData != null) {
        d(localAEMaterialMetaData);
      }
    }
  }
  
  public void a(@NotNull FlashShowMaterialViewHolder paramFlashShowMaterialViewHolder, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramFlashShowMaterialViewHolder, "viewHolder");
    Object localObject = this.f.get(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mTemplateList[position]");
    localObject = (AEMaterialMetaData)localObject;
    if ((Intrinsics.areEqual(localObject, AEFlashShowMaterialManager.a.b())) && (((AEMaterialMetaData)localObject).A))
    {
      paramFlashShowMaterialViewHolder.a(2, (AEMaterialMetaData)localObject);
    }
    else
    {
      ((AEMaterialMetaData)localObject).u = false;
      paramFlashShowMaterialViewHolder.a(1, (AEMaterialMetaData)localObject);
    }
    VideoReport.setElementId(paramFlashShowMaterialViewHolder.itemView, "em_xsj_props_item");
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(FlashShowDtReportHelper.a().c());
    localHashMap.put("xsj_props_name", ((AEMaterialMetaData)localObject).m);
    localObject = this.e;
    if (localObject != null)
    {
      localObject = ((AEMaterialCategory)localObject).d;
      if (localObject != null) {}
    }
    else
    {
      localObject = "none";
    }
    localHashMap.put("xsj_props_category", localObject);
    VideoReport.setElementParams(paramFlashShowMaterialViewHolder.itemView, (Map)localHashMap);
  }
  
  public final void a(@Nullable AEMaterialCategory paramAEMaterialCategory, @Nullable List<? extends AEMaterialMetaData> paramList)
  {
    this.e = paramAEMaterialCategory;
    if (paramList != null)
    {
      this.f.clear();
      this.f.addAll((Collection)paramList);
      notifyDataSetChanged();
    }
  }
  
  public final void a(@Nullable AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData == null)
    {
      this.h = ((String)null);
      return;
    }
    this.h = paramAEMaterialMetaData.m;
    AEFlashShowMaterialManager localAEFlashShowMaterialManager = this.d;
    if (localAEFlashShowMaterialManager != null)
    {
      localObject = this.h;
      if (localObject == null) {
        localObject = "";
      }
      localAEFlashShowMaterialManager.a((String)localObject);
    }
    AEBaseReportParam.a().b(paramAEMaterialMetaData.W);
    AEBaseReportParam.a().a(paramAEMaterialMetaData.m);
    AEBaseReportParam.a().f(-1);
    AEBaseReportParam.a().r("none");
    AEBaseReportParam.a().q("1");
    AEBaseReportParam.a().g(0);
    AEBaseDataReporter.a().c(paramAEMaterialMetaData.m);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("【Select Material】：");
    ((StringBuilder)localObject).append(paramAEMaterialMetaData.m);
    AEQLog.b("AEMaterialAdapter", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("【Select Material】Usable :");
    ((StringBuilder)localObject).append(paramAEMaterialMetaData.A);
    AEQLog.b("AEMaterialAdapter", ((StringBuilder)localObject).toString());
    if ((!TextUtils.isEmpty((CharSequence)paramAEMaterialMetaData.m)) && (!AEMaterialMetaData.a(paramAEMaterialMetaData)))
    {
      if (paramAEMaterialMetaData.a())
      {
        WeishiGuideUtils.a(this.m, paramAEMaterialMetaData, 1);
        return;
      }
      if (paramAEMaterialMetaData.A)
      {
        if (!AEResUtil.e())
        {
          QQToast.makeText((Context)BaseApplicationImpl.getContext(), (CharSequence)HardCodeUtil.a(2131907500), 0).show();
          ThreadManager.excute((Runnable)AEFlashShowMaterialAdapter.selectSpecificMaterial.1.a, 64, null, true);
          return;
        }
        localObject = this.d;
        if (localObject != null) {
          ((AEFlashShowMaterialManager)localObject).a(paramAEMaterialMetaData, this.j ^ true);
        }
        localObject = this.i;
        if (localObject != null) {
          ((AEFlashShowMaterialPanel.AEMaterialPanelListener)localObject).a(paramAEMaterialMetaData);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("### [material panel] select material ");
        ((StringBuilder)localObject).append(paramAEMaterialMetaData.m);
        QLog.d("AEMaterialAdapter", 4, ((StringBuilder)localObject).toString());
        return;
      }
      f(paramAEMaterialMetaData);
      return;
    }
    paramAEMaterialMetaData = this.i;
    if (paramAEMaterialMetaData != null) {
      paramAEMaterialMetaData.a();
    }
    paramAEMaterialMetaData = this.d;
    if (paramAEMaterialMetaData != null) {
      paramAEMaterialMetaData.a(AEMaterialMetaData.l, this.j ^ true);
    }
    QLog.d("AEMaterialAdapter", 4, "### [material panel] select material none");
    paramAEMaterialMetaData = this.m;
    if (paramAEMaterialMetaData != null)
    {
      ((Activity)paramAEMaterialMetaData).getIntent().removeExtra("widgetinfo");
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
  }
  
  public void b(@Nullable FlashShowMaterialViewHolder paramFlashShowMaterialViewHolder)
  {
    if (paramFlashShowMaterialViewHolder != null)
    {
      int n = paramFlashShowMaterialViewHolder.getAdapterPosition();
      if (n >= 0)
      {
        if (n >= this.f.size()) {
          return;
        }
        paramFlashShowMaterialViewHolder = this.f.get(n);
        Intrinsics.checkExpressionValueIsNotNull(paramFlashShowMaterialViewHolder, "mTemplateList[adapterPosition]");
        AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)paramFlashShowMaterialViewHolder;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onViewDetachedFromWindow---position=");
        localStringBuilder.append(n);
        localStringBuilder.append(", material=");
        if (localAEMaterialMetaData != null) {
          paramFlashShowMaterialViewHolder = localAEMaterialMetaData.m;
        } else {
          paramFlashShowMaterialViewHolder = null;
        }
        localStringBuilder.append(paramFlashShowMaterialViewHolder);
        AEQLog.a("AEMaterialAdapter", localStringBuilder.toString());
        if (localAEMaterialMetaData != null) {
          e(localAEMaterialMetaData);
        }
      }
    }
  }
  
  public int getItemCount()
  {
    return this.f.size();
  }
  
  public void notify(@NotNull Object paramObject, int paramInt, @NotNull Object... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "sender");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    if (paramInt == 113)
    {
      if (AEFlashShowMaterialManager.a.b() != null) {
        notifyDataSetChanged();
      }
    }
    else
    {
      if (paramInt == 1024)
      {
        QLog.d("AEMaterialAdapter", 4, "current watermark has change");
        notifyDataSetChanged();
        return;
      }
      if (paramInt == 111)
      {
        if ((paramVarArgs.length == 1) && (this.j))
        {
          paramObject = paramVarArgs[0];
          if (paramObject != null)
          {
            paramObject = (AEMaterialCategory)paramObject;
            a(paramObject, paramObject.a);
            notifyDataSetChanged();
            return;
          }
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.aelight.camera.ae.data.AEMaterialCategory");
        }
      }
      else if (paramInt == 114)
      {
        if (paramVarArgs.length == 1) {
          a(true, paramVarArgs[0]);
        }
      }
      else if ((paramInt == 115) && (paramVarArgs.length == 1)) {
        a(false, paramVarArgs[0]);
      }
    }
  }
  
  public void onClick(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    int n = this.c.getChildAdapterPosition(paramView);
    if (n == -1) {
      return;
    }
    paramView = this.f.get(n);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "tplList[position]");
    paramView = (AEMaterialMetaData)paramView;
    b(paramView);
    if (paramView.v) {
      paramView.w = true;
    } else {
      paramView.v = true;
    }
    a(paramView);
  }
  
  public void onDetachedFromRecyclerView(@Nullable RecyclerView paramRecyclerView)
  {
    AEQLog.a("AEMaterialAdapter", "onDetachedFromRecyclerView");
    this.l.removeMessages(1);
    this.k.clear();
  }
  
  public void onDownloadFinish(@NotNull AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramAEMaterialMetaData, "info");
    paramInt = c(paramAEMaterialMetaData);
    if (paramInt <= 0) {
      return;
    }
    ThreadManager.getUIHandler().post((Runnable)new AEFlashShowMaterialAdapter.onDownloadFinish.1(this, paramInt, paramAEMaterialMetaData, paramBoolean));
    if (!paramBoolean) {
      ThreadManager.getUIHandler().post((Runnable)new AEFlashShowMaterialAdapter.onDownloadFinish.2(this));
    }
  }
  
  public void onProgressUpdate(@NotNull AEMaterialMetaData paramAEMaterialMetaData, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramAEMaterialMetaData, "info");
    paramInt = c(paramAEMaterialMetaData);
    ThreadManager.getUIHandler().post((Runnable)new AEFlashShowMaterialAdapter.onProgressUpdate.1(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMaterialAdapter
 * JD-Core Version:    0.7.0.1
 */