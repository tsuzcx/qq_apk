package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.aelight.camera.ae.control.AEQIMManager;
import com.tencent.aelight.camera.ae.data.AEMaterialCategory;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.download.AEMaterialDownloader.MaterialDownloadListener;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class AEMaterialAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements View.OnClickListener, AEMaterialDownloader.MaterialDownloadListener, Observer
{
  public ArrayList<AEMaterialMetaData> a = new ArrayList();
  public AEMaterialMetaData b = null;
  public String c;
  private final LayoutInflater d;
  private final Context e;
  private AEGridView f;
  private AEMaterialManager g;
  private HashMap<String, Boolean> h = new HashMap();
  private AEMaterialPanel.AEMaterialPanelListener i;
  private boolean j = false;
  
  public AEMaterialAdapter(Context paramContext, AEGridView paramAEGridView, AEMaterialPanel.AEMaterialPanelListener paramAEMaterialPanelListener, boolean paramBoolean)
  {
    this.e = paramContext;
    this.d = LayoutInflater.from(paramContext);
    this.g = ((AEMaterialManager)AEQIMManager.a(1));
    this.i = paramAEMaterialPanelListener;
    this.f = paramAEGridView;
    this.j = paramBoolean;
  }
  
  private void a(AEMaterialMetaData paramAEMaterialMetaData, int paramInt)
  {
    if (paramAEMaterialMetaData == null)
    {
      this.c = null;
      return;
    }
    this.c = paramAEMaterialMetaData.m;
    this.g.a(this.c);
    AEBaseReportParam.a().b(paramAEMaterialMetaData.W);
    AEBaseReportParam.a().a(paramAEMaterialMetaData.m);
    AEBaseReportParam.a().f(-1);
    AEBaseReportParam.a().r("none");
    AEBaseReportParam.a().q("1");
    AEBaseReportParam.a().g(0);
    Object localObject;
    if (paramAEMaterialMetaData != null)
    {
      AEBaseDataReporter.a().c(paramAEMaterialMetaData.m);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("【Select Material】：");
      ((StringBuilder)localObject).append(paramAEMaterialMetaData.m);
      AEQLog.b("AEMaterialAdapter", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("【Select Material】Usable :");
      ((StringBuilder)localObject).append(paramAEMaterialMetaData.A);
      AEQLog.b("AEMaterialAdapter", ((StringBuilder)localObject).toString());
    }
    else
    {
      AEBaseDataReporter.a().c("null");
      AEQLog.b("AEMaterialAdapter", "【Select Material】：null");
    }
    if ((paramAEMaterialMetaData != null) && (!TextUtils.isEmpty(paramAEMaterialMetaData.m)) && (!AEMaterialMetaData.a(paramAEMaterialMetaData)))
    {
      if (paramAEMaterialMetaData.a())
      {
        WeishiGuideUtils.a(this.e, paramAEMaterialMetaData, 1);
        return;
      }
      if (paramAEMaterialMetaData.A)
      {
        if (!AEResUtil.e())
        {
          QQToast.makeText(BaseApplicationImpl.getContext(), HardCodeUtil.a(2131907500), 0).show();
          ThreadManager.excute(new AEMaterialAdapter.1(this), 64, null, true);
          return;
        }
        this.g.a(paramAEMaterialMetaData, this.j ^ true);
        localObject = this.i;
        if (localObject != null) {
          ((AEMaterialPanel.AEMaterialPanelListener)localObject).a(paramAEMaterialMetaData);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("### [material panel] select material ");
        ((StringBuilder)localObject).append(paramAEMaterialMetaData.m);
        QLog.d("AEMaterialAdapter", 4, ((StringBuilder)localObject).toString());
      }
      else
      {
        d(paramAEMaterialMetaData);
      }
      if (!this.j)
      {
        localObject = this.e;
        if (((localObject instanceof Activity)) && (AECameraEntryManager.o(((Activity)localObject).getIntent())))
        {
          this.g.c(paramAEMaterialMetaData);
          return;
        }
        this.g.b(paramAEMaterialMetaData);
      }
      return;
    }
    paramAEMaterialMetaData = this.i;
    if (paramAEMaterialMetaData != null) {
      paramAEMaterialMetaData.a();
    }
    this.g.a(AEMaterialMetaData.l, this.j ^ true);
    QLog.d("AEMaterialAdapter", 4, "### [material panel] select material none");
    ((Activity)this.e).getIntent().removeExtra("widgetinfo");
  }
  
  private void a(boolean paramBoolean, Object paramObject)
  {
    paramObject = (VideoMaterial)paramObject;
    if (paramObject == null) {
      return;
    }
    int k = 0;
    while (k < this.a.size())
    {
      if ((paramObject.getId() != null) && (paramObject.getId().equals(((AEMaterialMetaData)this.a.get(k)).m)))
      {
        ((AEMaterialMetaData)this.a.get(k)).u = paramBoolean;
        notifyItemChanged(k, Integer.valueOf(1));
        return;
      }
      k += 1;
    }
  }
  
  private void b(AEMaterialMetaData paramAEMaterialMetaData)
  {
    AEMaterialMetaData localAEMaterialMetaData = this.b;
    if ((localAEMaterialMetaData != null) && (!localAEMaterialMetaData.equals(paramAEMaterialMetaData)))
    {
      localAEMaterialMetaData = this.b;
      localAEMaterialMetaData.v = false;
      localAEMaterialMetaData.w = false;
    }
    this.b = paramAEMaterialMetaData;
  }
  
  private int c(AEMaterialMetaData paramAEMaterialMetaData)
  {
    int k = 0;
    while (k < this.a.size())
    {
      if (((AEMaterialMetaData)this.a.get(k)).m.equals(paramAEMaterialMetaData.m)) {
        return k;
      }
      k += 1;
    }
    return 0;
  }
  
  private void d(AEMaterialMetaData paramAEMaterialMetaData)
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
    if (this.g == null) {
      return;
    }
    e(paramAEMaterialMetaData);
  }
  
  private void e(AEMaterialMetaData paramAEMaterialMetaData)
  {
    AEMaterialManager localAEMaterialManager = this.g;
    localAEMaterialManager.a(localAEMaterialManager.getApp(), paramAEMaterialMetaData, this);
  }
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    a(paramAEMaterialMetaData, c(paramAEMaterialMetaData));
  }
  
  public void a(List<AEMaterialMetaData> paramList)
  {
    this.a.clear();
    this.h.clear();
    this.a.add(AEMaterialMetaData.l);
    this.a.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    Object localObject1 = this.a;
    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("dtexpose mTemplateList position");
      ((StringBuilder)localObject1).append(paramInt);
      AEQLog.a("AEMaterialAdapter", ((StringBuilder)localObject1).toString());
      if (paramInt < this.a.size())
      {
        localObject1 = (AEMaterialMetaData)this.a.get(paramInt);
        if (localObject1 != null)
        {
          Object localObject2 = this.h;
          if (localObject2 != null) {
            if (((HashMap)localObject2).containsKey(((AEMaterialMetaData)localObject1).m))
            {
              boolean bool = ((Boolean)this.h.get(((AEMaterialMetaData)localObject1).m)).booleanValue();
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("dtexpose mTemplateList data.id");
              ((StringBuilder)localObject2).append(((AEMaterialMetaData)localObject1).m);
              ((StringBuilder)localObject2).append(" vis");
              ((StringBuilder)localObject2).append(bool);
              AEQLog.a("AEMaterialAdapter", ((StringBuilder)localObject2).toString());
              if ((!bool) && (paramBoolean))
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("dtexpose mTemplateList report ~~~~data.id");
                ((StringBuilder)localObject2).append(((AEMaterialMetaData)localObject1).m);
                AEQLog.a("AEMaterialAdapter", ((StringBuilder)localObject2).toString());
                AEBaseDataReporter.a().g(((AEMaterialMetaData)localObject1).m);
              }
            }
            else
            {
              this.h.put(((AEMaterialMetaData)localObject1).m, Boolean.valueOf(true));
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("dtexpose mTemplateList report ~~~~~data.id");
              ((StringBuilder)localObject2).append(((AEMaterialMetaData)localObject1).m);
              AEQLog.a("AEMaterialAdapter", ((StringBuilder)localObject2).toString());
              AEBaseDataReporter.a().g(((AEMaterialMetaData)localObject1).m);
            }
          }
        }
      }
      return;
    }
    AEQLog.a("AEMaterialAdapter", "dtexpose mTemplateList is null");
  }
  
  public void a(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null)
    {
      if (paramArrayOfInt.length != 2) {
        return;
      }
      if (this.h == null) {
        return;
      }
      Object localObject = this.a;
      if (localObject != null)
      {
        if (((ArrayList)localObject).isEmpty()) {
          return;
        }
        int m = paramArrayOfInt[0];
        int n = paramArrayOfInt[1];
        paramArrayOfInt = new StringBuilder();
        paramArrayOfInt.append("dtexpose begin");
        paramArrayOfInt.append(m);
        paramArrayOfInt.append(" end ");
        paramArrayOfInt.append(n);
        AEQLog.a("AEMaterialAdapter", paramArrayOfInt.toString());
        int k = 0;
        while (k < this.a.size())
        {
          if ((k < m) || (k > n))
          {
            paramArrayOfInt = (AEMaterialMetaData)this.a.get(k);
            if ((paramArrayOfInt != null) && (this.h.containsKey(paramArrayOfInt.m)))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("dtexpose materialMetaData.id");
              ((StringBuilder)localObject).append(paramArrayOfInt.m);
              ((StringBuilder)localObject).append(" gone ");
              AEQLog.a("AEMaterialAdapter", ((StringBuilder)localObject).toString());
              this.h.put(paramArrayOfInt.m, Boolean.valueOf(false));
            }
          }
          k += 1;
        }
      }
    }
  }
  
  public void b(List<AEMaterialMetaData> paramList)
  {
    AEQLog.a("AEMaterialAdapter", "dtexpose reportFirstItems");
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      if (this.h == null) {
        return;
      }
      int k = 14;
      if (paramList.size() < 15) {
        k = paramList.size() - 1;
      }
      int m = 0;
      while (m < k)
      {
        AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)paramList.get(m);
        if (localAEMaterialMetaData != null)
        {
          this.h.put(localAEMaterialMetaData.m, Boolean.valueOf(true));
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("dtexpose mTemplateList report ~~~~~ data.id");
          localStringBuilder.append(localAEMaterialMetaData.m);
          AEQLog.a("AEMaterialAdapter", localStringBuilder.toString());
          AEBaseDataReporter.a().g(localAEMaterialMetaData.m);
        }
        m += 1;
      }
    }
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
    if (paramInt == 113)
    {
      if (AEMaterialManager.n() != null) {
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
        if ((paramVarArgs != null) && (paramVarArgs.length == 1) && (this.j))
        {
          a(((AEMaterialCategory)paramVarArgs[0]).a);
          notifyDataSetChanged();
        }
      }
      else if (paramInt == 114)
      {
        if ((paramVarArgs != null) && (paramVarArgs.length == 1)) {
          a(true, paramVarArgs[0]);
        }
      }
      else if ((paramInt == 115) && (paramVarArgs != null) && (paramVarArgs.length == 1)) {
        a(false, paramVarArgs[0]);
      }
    }
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)this.a.get(paramInt);
    if (localAEMaterialMetaData == null) {
      return;
    }
    if ((paramViewHolder instanceof MaterialNoneViewHolder))
    {
      paramViewHolder = (MaterialNoneViewHolder)paramViewHolder;
      if ((AEMaterialManager.n() != null) && (!localAEMaterialMetaData.equals(AEMaterialManager.n())))
      {
        paramViewHolder.b();
        return;
      }
      paramViewHolder.a();
      return;
    }
    if ((paramViewHolder instanceof MaterialViewHolder))
    {
      paramViewHolder = (MaterialViewHolder)paramViewHolder;
      if ((localAEMaterialMetaData.equals(AEMaterialManager.n())) && (localAEMaterialMetaData.A))
      {
        paramViewHolder.a(2, localAEMaterialMetaData);
        return;
      }
      localAEMaterialMetaData.u = false;
      paramViewHolder.a(1, localAEMaterialMetaData);
    }
  }
  
  public void onClick(View paramView)
  {
    int k = this.f.getChildAdapterPosition(paramView);
    if (k == -1) {
      return;
    }
    paramView = (AEMaterialMetaData)this.a.get(k);
    b(paramView);
    if (paramView.v) {
      paramView.w = true;
    } else {
      paramView.v = true;
    }
    a(paramView, k);
    if (AECameraEntryManager.o(((Activity)this.e).getIntent()))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("ext2", paramView.m);
      AEReportUtils.b(5, localHashMap);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject;
    if (paramInt == 0)
    {
      paramViewGroup = this.d.inflate(2064056373, paramViewGroup, false);
      localObject = new MaterialNoneViewHolder(paramViewGroup);
    }
    else
    {
      paramViewGroup = this.d.inflate(2064056372, paramViewGroup, false);
      localObject = new MaterialViewHolder(paramViewGroup);
      ((MaterialViewHolder)localObject).a(this.e);
    }
    paramViewGroup.setOnClickListener(this);
    return localObject;
  }
  
  public void onDownloadFinish(AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean, int paramInt)
  {
    if (paramAEMaterialMetaData == null) {
      return;
    }
    paramInt = c(paramAEMaterialMetaData);
    if (paramInt <= 0) {
      return;
    }
    ThreadManager.getUIHandler().post(new AEMaterialAdapter.2(this, paramInt, paramAEMaterialMetaData, paramBoolean));
    if (!paramBoolean) {
      ThreadManager.getUIHandler().post(new AEMaterialAdapter.3(this));
    }
  }
  
  public void onProgressUpdate(AEMaterialMetaData paramAEMaterialMetaData, int paramInt)
  {
    paramInt = c(paramAEMaterialMetaData);
    ThreadManager.getUIHandler().post(new AEMaterialAdapter.4(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialAdapter
 * JD-Core Version:    0.7.0.1
 */