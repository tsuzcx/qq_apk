package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.aelight.camera.ae.control.AEQIMManager;
import com.tencent.aelight.camera.ae.data.AEARCakeMaterial;
import com.tencent.aelight.camera.ae.data.AEGiftMaterial;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.download.AEMaterialDownloader.MaterialDownloadListener;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class AEARCakeMaterialAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements AEMaterialDownloader.MaterialDownloadListener, Observer
{
  AEARCakePanel.AEARCakePanelListener a;
  public ArrayList<AEGiftMaterial> b = new ArrayList();
  private LayoutInflater c;
  private Context d;
  private RecyclerView e;
  private AEMaterialManager f;
  private AEARCakeMaterialManager g;
  
  AEARCakeMaterialAdapter(Context paramContext, AEARCakePanel.AEARCakePanelListener paramAEARCakePanelListener)
  {
    this.a = paramAEARCakePanelListener;
    this.c = LayoutInflater.from(paramContext);
    this.d = paramContext;
    this.f = ((AEMaterialManager)AEQIMManager.a(1));
    this.g = AEARCakeMaterialManager.a();
  }
  
  private int a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    int i = 0;
    while (i < this.b.size())
    {
      String str = ((AEGiftMaterial)this.b.get(i)).c().V;
      if ((str != null) && (str.equals(paramAEMaterialMetaData.V))) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  private void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("arcake : onClick postion");
    ((StringBuilder)localObject).append(paramInt);
    AEQLog.a("AEARCakeMaterialAdapter", ((StringBuilder)localObject).toString());
    if (paramInt == -1) {
      return;
    }
    if (this.a == null)
    {
      AEQLog.d("AEARCakeMaterialAdapter", "MaterialPanelListener is null");
      return;
    }
    localObject = (AEGiftMaterial)this.b.get(paramInt);
    if (localObject == null)
    {
      AEQLog.d("AEARCakeMaterialAdapter", "giftMaterial is null");
      return;
    }
    AEARCakeMaterial localAEARCakeMaterial = ((AEGiftMaterial)localObject).c();
    if (localAEARCakeMaterial == null) {
      return;
    }
    if (!a(localAEARCakeMaterial.m))
    {
      AEQLog.a("AEARCakeMaterialAdapter", "arcake downing can not click");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("arcake :onclick :");
    localStringBuilder.append(localAEARCakeMaterial.toString());
    localStringBuilder.append("downloading : ");
    localStringBuilder.append(localAEARCakeMaterial.B);
    localStringBuilder.append(" usable ");
    localStringBuilder.append(localAEARCakeMaterial.A);
    AEQLog.a("AEARCakeMaterialAdapter", localStringBuilder.toString());
    if ((!NetworkUtil.isNetworkAvailable(this.d)) && (!localAEARCakeMaterial.A))
    {
      AEQLog.d("AEARCakeMaterialAdapter", "arcake net work not available");
      QQToast.makeText(BaseApplicationImpl.getContext(), HardCodeUtil.a(2064187644), 1).show();
      return;
    }
    this.g.a((AEGiftMaterial)localObject, paramInt);
    if (localAEARCakeMaterial.A)
    {
      if (!AEResUtil.e())
      {
        QQToast.makeText(BaseApplicationImpl.getContext(), HardCodeUtil.a(2131907500), 0).show();
        ThreadManager.excute(new AEARCakeMaterialAdapter.2(this), 64, null, true);
        return;
      }
      this.a.a(localAEARCakeMaterial);
    }
    else
    {
      this.g.a(localAEARCakeMaterial);
      b(localAEARCakeMaterial);
    }
    notifyDataSetChanged();
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject1 = this.b.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (AEGiftMaterial)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        localObject2 = ((AEGiftMaterial)localObject2).c();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("arcake same downloading :");
        localStringBuilder.append(((AEARCakeMaterial)localObject2).V);
        localStringBuilder.append(" downloading ");
        localStringBuilder.append(((AEARCakeMaterial)localObject2).B);
        AEQLog.a("AEARCakeMaterialAdapter", localStringBuilder.toString());
        if ((paramString.equals(((AEARCakeMaterial)localObject2).m)) && (((AEARCakeMaterial)localObject2).B))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("arcake same downloading :");
          ((StringBuilder)localObject1).append(paramString);
          AEQLog.a("AEARCakeMaterialAdapter", ((StringBuilder)localObject1).toString());
          return false;
        }
      }
    }
    return true;
  }
  
  private void b(int paramInt)
  {
    notifyDataSetChanged();
    a(paramInt);
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("arcake : doRealDownload");
    ((StringBuilder)localObject).append(paramAEMaterialMetaData.V);
    AEQLog.b("AEARCakeMaterialAdapter", ((StringBuilder)localObject).toString());
    if (AEMaterialManager.a(paramAEMaterialMetaData))
    {
      paramAEMaterialMetaData.A = AEMaterialManager.a(paramAEMaterialMetaData);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("arcake : already download ");
      ((StringBuilder)localObject).append(paramAEMaterialMetaData.V);
      AEQLog.a("AEARCakeMaterialAdapter", ((StringBuilder)localObject).toString());
      onDownloadFinish(paramAEMaterialMetaData, true, 200);
      return;
    }
    localObject = this.f;
    ((AEMaterialManager)localObject).a(((AEMaterialManager)localObject).getApp(), paramAEMaterialMetaData, this);
  }
  
  public void a(List<AEGiftMaterial> paramList, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("arcake : updateMaterialList");
    int i;
    if (paramList != null) {
      i = paramList.size();
    } else {
      i = -1;
    }
    localStringBuilder.append(i);
    AEQLog.a("AEARCakeMaterialAdapter", localStringBuilder.toString());
    this.b.clear();
    this.b.addAll(paramList);
    this.e.postDelayed(new AEARCakeMaterialAdapter.5(this, paramInt), 200L);
  }
  
  public int getItemCount()
  {
    ArrayList localArrayList = this.b;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
  
  public void notify(Object paramObject, int paramInt, Object... paramVarArgs) {}
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.e = paramRecyclerView;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    AEGiftMaterial localAEGiftMaterial = (AEGiftMaterial)this.b.get(paramInt);
    if (localAEGiftMaterial != null)
    {
      if (paramViewHolder == null) {
        return;
      }
      AEARCakeMaterial localAEARCakeMaterial = localAEGiftMaterial.c();
      if (localAEARCakeMaterial == null) {
        return;
      }
      paramViewHolder = (AEARCakeMaterialHolder)paramViewHolder;
      paramViewHolder.a(localAEARCakeMaterial);
      int i;
      if (localAEARCakeMaterial.A) {
        i = 8;
      } else {
        i = 0;
      }
      paramViewHolder.d(i);
      paramViewHolder.a(localAEGiftMaterial.a());
      paramViewHolder.b(localAEGiftMaterial.b());
      if (this.g.g() == paramInt) {
        paramViewHolder.c(0);
      } else {
        paramViewHolder.c(8);
      }
      if (this.b.size() <= 1) {
        paramViewHolder.d(8);
      }
      paramViewHolder.itemView.setOnClickListener(new AEARCakeMaterialAdapter.1(this, paramViewHolder));
      paramViewHolder.a(localAEARCakeMaterial);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = this.c.inflate(2064056320, paramViewGroup, false);
    return new AEARCakeMaterialHolder(this.d, paramViewGroup);
  }
  
  public void onDownloadFinish(AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("arcake : onDownloadFinish ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("resCode ");
    localStringBuilder.append(paramInt);
    AEQLog.a("AEARCakeMaterialAdapter", localStringBuilder.toString());
    ThreadManager.getUIHandler().post(new AEARCakeMaterialAdapter.3(this, paramInt, paramAEMaterialMetaData, paramBoolean));
  }
  
  public void onProgressUpdate(AEMaterialMetaData paramAEMaterialMetaData, int paramInt)
  {
    int i = a(paramAEMaterialMetaData);
    ThreadManager.getUIHandler().post(new AEARCakeMaterialAdapter.4(this, i, paramAEMaterialMetaData, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialAdapter
 * JD-Core Version:    0.7.0.1
 */