package com.tencent.aelight.camera.ae.biz.circle.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.module.MetaMaterialKt;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RecomAutoTemplateAdapter
  extends RecyclerView.Adapter<RecomAutoTemplateAdapter.ContentItemVH>
  implements URLDrawableDownListener
{
  private List<RecomAutoTemplateAdapter.RecomAutoTemplateData> a = new ArrayList();
  private int b = -1;
  private RecomAutoTemplateAdapter.ApplyMaterial c;
  private final int d;
  private final int e;
  
  public RecomAutoTemplateAdapter(@NonNull Context paramContext)
  {
    this.d = AIOUtils.b(16.0F, paramContext.getResources());
    this.e = AIOUtils.b(8.0F, paramContext.getResources());
  }
  
  public static String a(ArrayList<LocalMediaInfo> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramArrayList.iterator();
    for (paramArrayList = ""; localIterator.hasNext(); paramArrayList = ",")
    {
      LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)localIterator.next();
      localStringBuilder.append(paramArrayList);
      localStringBuilder.append(localLocalMediaInfo._id);
    }
    return localStringBuilder.toString();
  }
  
  private void a(int paramInt, MetaMaterial paramMetaMaterial)
  {
    if (paramMetaMaterial == null) {
      return;
    }
    if (paramInt == this.b) {
      return;
    }
    this.b = paramInt;
    if (AEEditorResourceManager.a().b(paramMetaMaterial))
    {
      a(((RecomAutoTemplateAdapter.RecomAutoTemplateData)this.a.get(paramInt)).d, paramMetaMaterial, ((RecomAutoTemplateAdapter.RecomAutoTemplateData)this.a.get(paramInt)).f);
      return;
    }
    RecomAutoTemplateAdapter.ApplyMaterial localApplyMaterial = this.c;
    if (localApplyMaterial != null) {
      localApplyMaterial.a();
    }
    AEEditorResourceManager.a().a(paramMetaMaterial, new RecomAutoTemplateAdapter.2(this, paramInt, paramMetaMaterial));
  }
  
  private void a(ArrayList<LocalMediaInfo> paramArrayList, MetaMaterial paramMetaMaterial, String paramString)
  {
    if (this.c != null)
    {
      MetaMaterialKt.b(paramMetaMaterial, AEEditorResourceManager.a().a(paramMetaMaterial));
      this.c.a(paramArrayList, paramMetaMaterial, paramString);
      this.b = -1;
    }
  }
  
  public final RecomAutoTemplateAdapter.ContentItemVH a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new RecomAutoTemplateAdapter.ContentItemVH(LayoutInflater.from(paramViewGroup.getContext()).inflate(2064056488, paramViewGroup, false));
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramViewGroup.itemView.getLayoutParams();
    if (paramInt == 0)
    {
      localLayoutParams.leftMargin = this.d;
      return paramViewGroup;
    }
    if (paramInt == 1)
    {
      localLayoutParams.leftMargin = this.e;
      return paramViewGroup;
    }
    localLayoutParams.leftMargin = this.e;
    localLayoutParams.rightMargin = this.d;
    return paramViewGroup;
  }
  
  public List<RecomAutoTemplateAdapter.RecomAutoTemplateData> a()
  {
    return this.a;
  }
  
  public void a(RecomAutoTemplateAdapter.ApplyMaterial paramApplyMaterial)
  {
    this.c = paramApplyMaterial;
  }
  
  public final void a(RecomAutoTemplateAdapter.ContentItemVH paramContentItemVH, @SuppressLint({"RecyclerView"}) int paramInt)
  {
    MetaMaterial localMetaMaterial = ((RecomAutoTemplateAdapter.RecomAutoTemplateData)this.a.get(paramInt)).b;
    if (localMetaMaterial == null) {
      return;
    }
    if (TextUtils.isEmpty(((RecomAutoTemplateAdapter.RecomAutoTemplateData)this.a.get(paramInt)).c))
    {
      paramContentItemVH.b.setVisibility(4);
    }
    else
    {
      paramContentItemVH.b.setVisibility(0);
      paramContentItemVH.b.setText(((RecomAutoTemplateAdapter.RecomAutoTemplateData)this.a.get(paramInt)).c);
    }
    paramContentItemVH.a.setVisibility(0);
    paramContentItemVH.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if (((RecomAutoTemplateAdapter.RecomAutoTemplateData)this.a.get(paramInt)).e != null)
    {
      paramContentItemVH.a.setImageBitmap(((RecomAutoTemplateAdapter.RecomAutoTemplateData)this.a.get(paramInt)).e);
      if (localMetaMaterial.additionalFields != null)
      {
        String str = (String)localMetaMaterial.additionalFields.get("pTuForegroundImage");
        if (!TextUtils.isEmpty(str))
        {
          paramContentItemVH.c.setVisibility(0);
          UIUtils.a(paramContentItemVH.c, str, UIUtils.a(paramContentItemVH.c.getContext(), 88.0F), UIUtils.a(paramContentItemVH.c.getContext(), 128.0F), ContextCompat.getDrawable(paramContentItemVH.c.getContext(), 2063925448), null);
        }
      }
    }
    else
    {
      paramContentItemVH.a.setImageResource(2063925448);
    }
    paramContentItemVH.itemView.setOnClickListener(new RecomAutoTemplateAdapter.1(this, paramInt, localMetaMaterial));
  }
  
  public final void a(List<RecomAutoTemplateAdapter.RecomAutoTemplateData> paramList)
  {
    this.a = paramList;
    notifyDataSetChanged();
  }
  
  public final int getItemCount()
  {
    List localList = this.a;
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
    List localList = this.a;
    if ((localList != null) && (paramInt == localList.size() - 1)) {
      return 2;
    }
    return 1;
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    new Rect();
    paramView = (LocalMediaInfo)paramURLDrawable.getTag();
    int i = paramView.listViewPosition;
    if (i != -1)
    {
      if (paramView.visableTime == 0L) {
        return;
      }
      long l1 = SystemClock.uptimeMillis();
      long l2 = paramView.visableTime;
      if (QLog.isColorLevel())
      {
        paramURLDrawable = new StringBuilder();
        paramURLDrawable.append("onLoadSuccessed,no next ,listViewPositon:");
        paramURLDrawable.append(i);
        paramURLDrawable.append(" costTime:");
        paramURLDrawable.append(l1 - l2);
        paramURLDrawable.append(" imageInfo;");
        paramURLDrawable.append(paramView);
        QLog.d("RecomAutoTemplateAdapter", 2, paramURLDrawable.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.adapter.RecomAutoTemplateAdapter
 * JD-Core Version:    0.7.0.1
 */