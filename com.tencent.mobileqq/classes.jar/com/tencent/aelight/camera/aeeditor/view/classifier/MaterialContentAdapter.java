package com.tencent.aelight.camera.aeeditor.view.classifier;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.module.MetaMaterialKt;
import com.tencent.aelight.camera.aeeditor.module.filter.AdapterUtil;
import com.tencent.aelight.camera.aeeditor.util.AEQCircleReport;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast.IToastValidListener;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.os.MqqHandler;

public abstract class MaterialContentAdapter
  extends RecyclerView.Adapter<MaterialContentAdapter.ContentItemVH>
{
  protected boolean a;
  private final int b;
  private RecyclerView c;
  private List<MetaMaterial> d;
  private int e = -1;
  private int f;
  private ApplyMaterialTask g;
  private MaterialContentAdapter.ItemListener h;
  private QQToast.IToastValidListener i;
  private final int j;
  private final int k;
  private final int l;
  private final int m;
  @DrawableRes
  private final int n;
  
  public MaterialContentAdapter(@NonNull Context paramContext, int paramInt)
  {
    this(paramContext, paramInt, 1);
  }
  
  public MaterialContentAdapter(@NonNull Context paramContext, int paramInt1, int paramInt2)
  {
    this.b = paramInt2;
    this.d = new ArrayList();
    this.j = AIOUtils.b(12.0F, paramContext.getResources());
    this.k = AIOUtils.b(6.0F, paramContext.getResources());
    this.l = AIOUtils.b(2.0F, paramContext.getResources());
    this.m = AIOUtils.b(16.0F, paramContext.getResources());
    if (paramInt1 != 2)
    {
      this.n = 2130853651;
      return;
    }
    this.n = 2063925448;
  }
  
  private void a(@NonNull MetaMaterial paramMetaMaterial, String paramString)
  {
    if (paramMetaMaterial != null)
    {
      long l1 = AEQCircleReport.a().b(paramMetaMaterial.id);
      if (l1 > 0L)
      {
        ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).reportPublishQuality(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).pMaterialDownloadFinish(), Arrays.asList(new FeedCloudCommon.Entry[] { ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).ext1(), paramMetaMaterial.id), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).ext3(), String.valueOf(l1)), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).keyRetCode(), paramString) }));
        return;
      }
      AEQLog.b("MaterialContentAdapter", "reportMaterialDownloadCost time < 0");
    }
  }
  
  private void a(ApplyMaterialTask.Status paramStatus, int paramInt, MetaMaterial paramMetaMaterial)
  {
    ApplyMaterialTaskHelper.a("onPostDownloadMaterial", paramMetaMaterial, "start");
    this.g.a(paramStatus, paramInt, paramMetaMaterial, new MaterialContentAdapter.3(this, paramMetaMaterial, paramStatus, paramInt));
  }
  
  private void b(int paramInt, MetaMaterial paramMetaMaterial)
  {
    if (paramMetaMaterial == null) {
      return;
    }
    if (paramInt == this.e) {
      return;
    }
    this.f = paramInt;
    c(paramInt, paramMetaMaterial);
  }
  
  private void c(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    if (this.g == null) {
      return;
    }
    ApplyMaterialTaskHelper.a("onPreExecute", paramMetaMaterial, "start");
    if (paramMetaMaterial != null) {
      AEQCircleReport.a().a(paramMetaMaterial.id);
    }
    this.g.a(paramInt, paramMetaMaterial, new MaterialContentAdapter.2(this, paramMetaMaterial, paramInt));
  }
  
  private void d(int paramInt, MetaMaterial paramMetaMaterial)
  {
    MetaMaterialKt.a(paramMetaMaterial, -1);
    ThreadManager.getUIHandler().post(new MaterialContentAdapter.4(this, paramInt));
  }
  
  protected abstract MaterialContentAdapter.ContentItemVH a(ViewGroup paramViewGroup, int paramInt);
  
  public Boolean a(int paramInt, String paramString)
  {
    List localList = this.d;
    if ((localList != null) && (localList.size() > paramInt) && (paramInt >= 0) && (!TextUtils.isEmpty(paramString))) {
      return Boolean.valueOf(((MetaMaterial)this.d.get(paramInt)).id.equals(paramString));
    }
    return Boolean.valueOf(false);
  }
  
  public void a(int paramInt, MetaMaterial paramMetaMaterial)
  {
    b(paramInt, paramMetaMaterial);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getClass().getSimpleName());
      localStringBuilder.append(" setSelectedIndex:");
      localStringBuilder.append(paramInt);
      QLog.i("MaterialContentAdapter", 2, localStringBuilder.toString());
    }
    if ((paramInt >= 0) && ((this.c.getLayoutManager() instanceof LinearLayoutManager))) {
      if (((LinearLayoutManager)this.c.getLayoutManager()).getOrientation() == 0) {
        AdapterUtil.a(this.c, this.e, paramInt, paramBoolean, false);
      } else {
        AdapterUtil.b(this.c, this.e, paramInt, paramBoolean, false);
      }
    }
    this.e = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(ApplyMaterialTask paramApplyMaterialTask)
  {
    this.g = paramApplyMaterialTask;
  }
  
  public final void a(MaterialContentAdapter.ContentItemVH paramContentItemVH, int paramInt)
  {
    MetaMaterial localMetaMaterial = (MetaMaterial)this.d.get(paramInt);
    Object localObject = this.h;
    if (localObject != null) {
      ((MaterialContentAdapter.ItemListener)localObject).a(paramInt, localMetaMaterial);
    }
    if (localMetaMaterial == null) {
      return;
    }
    int i1 = this.e;
    boolean bool1 = true;
    if (i1 == paramInt) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (!TextUtils.isEmpty(MetaMaterialKt.l(localMetaMaterial)))
    {
      paramContentItemVH.d.setVisibility(0);
      paramContentItemVH.d.setText(MetaMaterialKt.l(localMetaMaterial));
      paramContentItemVH.c.setVisibility(4);
    }
    else if (TextUtils.isEmpty(localMetaMaterial.thumbUrl))
    {
      paramContentItemVH.d.setVisibility(4);
      paramContentItemVH.c.setVisibility(0);
      paramContentItemVH.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramContentItemVH.c.setImageResource(this.n);
    }
    else if (localMetaMaterial.thumbUrl.startsWith("http"))
    {
      paramContentItemVH.d.setVisibility(4);
      paramContentItemVH.c.setVisibility(0);
      paramContentItemVH.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
      UIUtils.a(paramContentItemVH.c, localMetaMaterial.thumbUrl, UIUtils.a(paramContentItemVH.c.getContext(), 67.0F), UIUtils.a(paramContentItemVH.c.getContext(), 67.0F), ContextCompat.getDrawable(paramContentItemVH.c.getContext(), this.n), null);
    }
    else
    {
      paramContentItemVH.d.setVisibility(4);
      paramContentItemVH.c.setVisibility(0);
      paramContentItemVH.c.setScaleType(ImageView.ScaleType.FIT_XY);
      paramContentItemVH.c.setImageResource(MetaMaterialKt.n(localMetaMaterial));
    }
    if (paramContentItemVH.k != null) {
      paramContentItemVH.k.setText(MetaMaterialKt.a(localMetaMaterial));
    }
    if (i1 != 0)
    {
      paramContentItemVH.f.setVisibility(0);
      paramContentItemVH.f.setImageResource(MetaMaterialKt.m(localMetaMaterial));
      MaterialContentAdapter.ContentItemVH.a(paramContentItemVH, false, -1);
      MaterialContentAdapter.ContentItemVH.a(paramContentItemVH, false);
    }
    else
    {
      paramContentItemVH.f.setVisibility(4);
      if (MetaMaterialKt.i(localMetaMaterial))
      {
        i1 = MetaMaterialKt.k(localMetaMaterial);
        if ((i1 != -1) && (i1 != 100))
        {
          MaterialContentAdapter.ContentItemVH.a(paramContentItemVH, true, i1);
        }
        else
        {
          MaterialContentAdapter.ContentItemVH.a(paramContentItemVH, false, i1);
          localObject = this.g;
          if (localObject != null)
          {
            boolean bool2 = ((ApplyMaterialTask)localObject).c(paramInt, localMetaMaterial);
            if ((i1 != -1) || (bool2) || (!MetaMaterialKt.b(localMetaMaterial))) {
              bool1 = false;
            }
            MaterialContentAdapter.ContentItemVH.a(paramContentItemVH, bool1);
          }
        }
      }
    }
    if (TextUtils.isEmpty(MetaMaterialKt.d(localMetaMaterial)))
    {
      paramContentItemVH.g.setVisibility(4);
    }
    else
    {
      paramContentItemVH.g.setVisibility(0);
      UIUtils.a(paramContentItemVH.g, MetaMaterialKt.d(localMetaMaterial), UIUtils.a(paramContentItemVH.g.getContext(), 26.0F), UIUtils.a(paramContentItemVH.g.getContext(), 26.0F), null, null);
    }
    paramContentItemVH.itemView.setOnClickListener(new MaterialContentAdapter.1(this, paramInt, localMetaMaterial));
    a(paramContentItemVH, paramInt, localMetaMaterial);
  }
  
  protected void a(MaterialContentAdapter.ContentItemVH paramContentItemVH, int paramInt, @NonNull MetaMaterial paramMetaMaterial) {}
  
  public void a(MaterialContentAdapter.ItemListener paramItemListener)
  {
    this.h = paramItemListener;
  }
  
  public void a(QQToast.IToastValidListener paramIToastValidListener)
  {
    this.i = paramIToastValidListener;
  }
  
  public final void a(List<MetaMaterial> paramList)
  {
    this.d = paramList;
  }
  
  public boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.d == null) {
        return false;
      }
      int i1 = 0;
      while (i1 < this.d.size())
      {
        if ((this.d.get(i1) != null) && (paramString.equals(((MetaMaterial)this.d.get(i1)).id)))
        {
          a(i1, (MetaMaterial)this.d.get(i1));
          return true;
        }
        i1 += 1;
      }
    }
    return false;
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.d == null) {
        return false;
      }
      int i1 = 0;
      while (i1 < this.d.size())
      {
        if ((this.d.get(i1) != null) && (paramString.equals(((MetaMaterial)this.d.get(i1)).id)))
        {
          a(i1, paramBoolean);
          return true;
        }
        i1 += 1;
      }
    }
    return false;
  }
  
  public final MaterialContentAdapter.ContentItemVH b(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = a(paramViewGroup, paramInt);
    if (this.b == 1)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramViewGroup.itemView.getLayoutParams();
      if (paramInt == 0) {
        localLayoutParams.leftMargin = this.j;
      } else if (paramInt == 2) {
        localLayoutParams.rightMargin = this.j;
      }
    }
    MaterialContentAdapter.ContentItemVH.a(paramViewGroup, this.k, this.l, this.m);
    return paramViewGroup;
  }
  
  public List<MetaMaterial> b()
  {
    return this.d;
  }
  
  public void b(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void b(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public int c()
  {
    return this.e;
  }
  
  public final int getItemCount()
  {
    List localList = this.d;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    List localList = this.d;
    if ((localList != null) && (paramInt == localList.size() - 1)) {
      return 2;
    }
    return 1;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.c = paramRecyclerView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.classifier.MaterialContentAdapter
 * JD-Core Version:    0.7.0.1
 */