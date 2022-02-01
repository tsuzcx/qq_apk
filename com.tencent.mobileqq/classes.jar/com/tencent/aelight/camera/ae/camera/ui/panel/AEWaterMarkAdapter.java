package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import com.tencent.aelight.camera.ae.control.AEQIMManager;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.download.AEMaterialDownloader.MaterialDownloadListener;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.ToastUtil;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class AEWaterMarkAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements View.OnClickListener, AEMaterialDownloader.MaterialDownloadListener, Observer
{
  public ArrayList<AEMaterialMetaData> a = new ArrayList();
  private LayoutInflater b;
  private Context c;
  private RecyclerView d;
  private AEWaterMarkPanel.AEWaterMarkPanelListener e;
  private AEMaterialManager f;
  private String g;
  private AEMaterialMetaData h = null;
  private AEVideoStoryTopBarViewModel.Ratio i;
  
  AEWaterMarkAdapter(Context paramContext, AEWaterMarkPanel.AEWaterMarkPanelListener paramAEWaterMarkPanelListener)
  {
    this.b = LayoutInflater.from(paramContext);
    this.c = paramContext;
    this.e = paramAEWaterMarkPanelListener;
    this.f = ((AEMaterialManager)AEQIMManager.a(1));
    this.f.a(this, 114);
    this.f.a(this, 115);
    this.f.a(this, 1025);
    this.f.a(this, 113);
  }
  
  private void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    AEMaterialMetaData localAEMaterialMetaData = this.h;
    if ((localAEMaterialMetaData != null) && (!localAEMaterialMetaData.equals(paramAEMaterialMetaData)))
    {
      localAEMaterialMetaData = this.h;
      localAEMaterialMetaData.v = false;
      localAEMaterialMetaData.w = false;
    }
    this.h = paramAEMaterialMetaData;
  }
  
  private void a(boolean paramBoolean, Object paramObject)
  {
    paramObject = (VideoMaterial)paramObject;
    if (paramObject == null) {
      return;
    }
    int j = 0;
    while (j < this.a.size())
    {
      if ((paramObject.getId() != null) && (paramObject.getId().equals(((AEMaterialMetaData)this.a.get(j)).m)))
      {
        ((AEMaterialMetaData)this.a.get(j)).u = paramBoolean;
        notifyItemChanged(j, Integer.valueOf(1));
        return;
      }
      j += 1;
    }
  }
  
  private static void b(RecyclerView paramRecyclerView, int paramInt, boolean paramBoolean)
  {
    if (paramRecyclerView == null) {
      return;
    }
    LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)paramRecyclerView.getLayoutManager();
    if (localLinearLayoutManager == null) {
      return;
    }
    paramRecyclerView = new AEWaterMarkAdapter.7(paramRecyclerView.getContext(), localLinearLayoutManager, paramBoolean);
    paramRecyclerView.setTargetPosition(paramInt);
    localLinearLayoutManager.startSmoothScroll(paramRecyclerView);
  }
  
  private void b(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData == null) {
      return;
    }
    if (paramAEMaterialMetaData.B) {
      return;
    }
    if (TextUtils.isEmpty(paramAEMaterialMetaData.m)) {
      return;
    }
    if (this.f == null) {
      return;
    }
    c(paramAEMaterialMetaData);
  }
  
  private void c(AEMaterialMetaData paramAEMaterialMetaData)
  {
    AEMaterialManager localAEMaterialManager = this.f;
    localAEMaterialManager.a(localAEMaterialManager.getApp(), paramAEMaterialMetaData, this);
  }
  
  private int d(AEMaterialMetaData paramAEMaterialMetaData)
  {
    int j = 0;
    while (j < this.a.size())
    {
      if (((AEMaterialMetaData)this.a.get(j)).m.equals(paramAEMaterialMetaData.m)) {
        return j;
      }
      j += 1;
    }
    return 0;
  }
  
  public void a()
  {
    if (this.a == null)
    {
      AEQLog.d("AEWaterMarkAdapter", "mTemplateList is null");
      notifyDataSetChanged();
      return;
    }
    AEMaterialMetaData localAEMaterialMetaData1 = AEMaterialManager.o();
    int j = 0;
    int m;
    for (int k = 0; j < this.a.size(); k = m)
    {
      AEMaterialMetaData localAEMaterialMetaData2 = (AEMaterialMetaData)this.a.get(j);
      m = k;
      if (localAEMaterialMetaData1 != null)
      {
        m = k;
        if (localAEMaterialMetaData1.m.equals(localAEMaterialMetaData2.m)) {
          m = j;
        }
      }
      j += 1;
    }
    a(k);
  }
  
  public void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setSelectedIndex:");
    ((StringBuilder)localObject).append(paramInt);
    AEQLog.a("AEWaterMarkAdapter", ((StringBuilder)localObject).toString());
    notifyDataSetChanged();
    localObject = this.d;
    if (localObject != null) {
      ((RecyclerView)localObject).post(new AEWaterMarkAdapter.3(this, paramInt));
    }
  }
  
  public void a(AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setCircleCaptureStyle:");
    localStringBuilder.append(paramRatio);
    AEQLog.a("AEWaterMarkAdapter", localStringBuilder.toString());
    this.i = paramRatio;
  }
  
  public void a(List<AEMaterialMetaData> paramList)
  {
    this.a.clear();
    this.a.add(AEMaterialMetaData.l);
    this.a.addAll(paramList);
    this.d.postDelayed(new AEWaterMarkAdapter.2(this), 200L);
  }
  
  public int getItemCount()
  {
    ArrayList localArrayList = this.a;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return 1;
  }
  
  public void notify(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    ThreadManager.getUIHandler().post(new AEWaterMarkAdapter.8(this, paramInt, paramVarArgs));
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.d = paramRecyclerView;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject = (AEMaterialMetaData)this.a.get(paramInt);
    if (localObject == null) {
      return;
    }
    AEMaterialMetaData localAEMaterialMetaData = AEMaterialManager.o();
    if ((paramViewHolder instanceof AEMaterialWaterMarkNoneViewHolder))
    {
      if (localAEMaterialMetaData == null)
      {
        localObject = (AEMaterialWaterMarkNoneViewHolder)paramViewHolder;
        ((AEMaterialWaterMarkNoneViewHolder)localObject).b.setVisibility(0);
        ((AEMaterialWaterMarkNoneViewHolder)localObject).a.setVisibility(8);
      }
      else
      {
        localObject = (AEMaterialWaterMarkNoneViewHolder)paramViewHolder;
        ((AEMaterialWaterMarkNoneViewHolder)localObject).b.setVisibility(8);
        ((AEMaterialWaterMarkNoneViewHolder)localObject).a.setVisibility(0);
      }
      if (this.i != AEVideoStoryTopBarViewModel.Ratio.FULL)
      {
        ((AEMaterialWaterMarkNoneViewHolder)paramViewHolder).c.setBackgroundDrawable(this.c.getResources().getDrawable(2063925300));
        return;
      }
      paramViewHolder = (AEMaterialWaterMarkNoneViewHolder)paramViewHolder;
      paramViewHolder.d.setVisibility(0);
      paramViewHolder.d.setBackgroundColor(this.c.getResources().getColor(2131168478));
      return;
    }
    if ((paramViewHolder instanceof AEMaterialWaterMarkViewHolder))
    {
      paramViewHolder = (AEMaterialWaterMarkViewHolder)paramViewHolder;
      paramViewHolder.a((AEMaterialMetaData)localObject);
      boolean bool;
      if (localAEMaterialMetaData == null)
      {
        if (paramInt == 0) {
          bool = true;
        } else {
          bool = false;
        }
      }
      else {
        bool = localAEMaterialMetaData.m.equals(((AEMaterialMetaData)localObject).m);
      }
      if (bool)
      {
        if (localAEMaterialMetaData != null) {
          ((AEMaterialMetaData)localObject).u = localAEMaterialMetaData.u;
        }
        if (((AEMaterialMetaData)localObject).u)
        {
          paramViewHolder.f.setVisibility(8);
          paramViewHolder.g.setVisibility(0);
        }
        else
        {
          paramViewHolder.g.setVisibility(8);
          paramViewHolder.f.setVisibility(0);
        }
        paramViewHolder.a(8);
        paramViewHolder.b(8);
      }
      else
      {
        paramViewHolder.g.setVisibility(8);
        paramViewHolder.f.setVisibility(8);
        paramViewHolder.b((AEMaterialMetaData)localObject);
      }
      if (this.i != AEVideoStoryTopBarViewModel.Ratio.FULL) {
        paramViewHolder.h.setBackgroundDrawable(this.c.getResources().getDrawable(2063925300));
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int j = this.d.getChildAdapterPosition(paramView);
    if (j == -1) {
      return;
    }
    if (this.e == null)
    {
      AEQLog.d("AEWaterMarkAdapter", "water mark mlistener is null");
      return;
    }
    AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)this.a.get(j);
    if ((j != 0) && (localAEMaterialMetaData != null))
    {
      if ((!NetworkUtil.isNetworkAvailable(this.c)) && (!localAEMaterialMetaData.A))
      {
        AEQLog.d("AEWaterMarkAdapter", "net work not available");
        ToastUtil.a().a(HardCodeUtil.a(2131913581));
        return;
      }
      a(localAEMaterialMetaData);
      AEBaseDataReporter localAEBaseDataReporter = AEBaseDataReporter.a();
      if (localAEMaterialMetaData.m == null) {
        paramView = "none";
      } else {
        paramView = localAEMaterialMetaData.m;
      }
      localAEBaseDataReporter.p(paramView);
      if (localAEMaterialMetaData.v) {
        localAEMaterialMetaData.w = true;
      } else {
        localAEMaterialMetaData.v = true;
      }
      this.g = localAEMaterialMetaData.m;
      this.f.a(this.g);
      if (localAEMaterialMetaData.A)
      {
        if (!AEResUtil.e())
        {
          QQToast.makeText(BaseApplicationImpl.getContext(), HardCodeUtil.a(2131907500), 0).show();
          ThreadManager.excute(new AEWaterMarkAdapter.1(this), 64, null, true);
          return;
        }
        this.f.b(localAEMaterialMetaData, true);
        this.e.a(localAEMaterialMetaData);
        a(j);
      }
      else
      {
        b(localAEMaterialMetaData);
      }
    }
    else
    {
      this.e.a();
      this.g = null;
      this.f.b(null, true);
      a(0);
      AEBaseDataReporter.a().aD();
    }
    if (AECameraEntryManager.o(((Activity)this.c).getIntent()))
    {
      paramView = new HashMap();
      paramView.put("ext2", localAEMaterialMetaData.m);
      AEReportUtils.b(9, paramView);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject;
    if (paramInt == 0)
    {
      paramViewGroup = this.b.inflate(2064056344, paramViewGroup, false);
      localObject = new AEMaterialWaterMarkNoneViewHolder(paramViewGroup);
    }
    else
    {
      paramViewGroup = this.b.inflate(2064056343, paramViewGroup, false);
      localObject = new AEMaterialWaterMarkViewHolder(paramViewGroup, this.c);
    }
    paramViewGroup.setOnClickListener(this);
    return localObject;
  }
  
  public void onDownloadFinish(AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean, int paramInt)
  {
    if (paramAEMaterialMetaData == null) {
      return;
    }
    paramInt = d(paramAEMaterialMetaData);
    if (paramInt <= 0) {
      return;
    }
    ThreadManager.getUIHandler().post(new AEWaterMarkAdapter.4(this, paramInt, paramAEMaterialMetaData, paramBoolean));
    if (!paramBoolean) {
      ThreadManager.getUIHandler().post(new AEWaterMarkAdapter.5(this));
    }
  }
  
  public void onProgressUpdate(AEMaterialMetaData paramAEMaterialMetaData, int paramInt)
  {
    paramInt = d(paramAEMaterialMetaData);
    ThreadManager.getUIHandler().post(new AEWaterMarkAdapter.6(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEWaterMarkAdapter
 * JD-Core Version:    0.7.0.1
 */