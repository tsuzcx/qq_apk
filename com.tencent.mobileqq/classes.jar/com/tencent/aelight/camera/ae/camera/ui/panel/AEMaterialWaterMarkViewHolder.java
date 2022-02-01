package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.view.AEDownLoadingView;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.NetworkUtil;

public class AEMaterialWaterMarkViewHolder
  extends RecyclerView.ViewHolder
{
  AEDownLoadingView a;
  ImageView b;
  ImageView c;
  ImageView d;
  ImageView e;
  ImageView f;
  View g;
  public View h;
  private URLImageView i;
  private Context j;
  
  public AEMaterialWaterMarkViewHolder(View paramView, Context paramContext)
  {
    super(paramView);
    this.i = ((URLImageView)paramView.findViewById(2063991486));
    this.b = ((ImageView)paramView.findViewById(2063991018));
    this.c = ((ImageView)paramView.findViewById(2063991017));
    this.d = ((ImageView)paramView.findViewById(2063991246));
    this.e = ((ImageView)paramView.findViewById(2063991247));
    this.a = ((AEDownLoadingView)paramView.findViewById(2063991328));
    this.f = ((ImageView)paramView.findViewById(2063991420));
    this.g = paramView.findViewById(2063991619);
    this.h = paramView.findViewById(2063991620);
    this.j = paramContext;
    int k = AIOUtils.b(6.0F, this.a.getResources());
    int m = AIOUtils.b(2.0F, this.a.getResources());
    int n = AIOUtils.b(16.0F, this.a.getResources());
    this.a.setBgCorner(n / 2);
    this.a.setMinimumHeight(n);
    this.a.setMinimumWidth(n);
    this.a.setProgressSizeAndMode(k, m, false);
    this.a.setBgColor(0);
    this.a.setProgressColor(-1);
    this.a.a(false);
  }
  
  public void a(int paramInt)
  {
    this.b.setVisibility(paramInt);
    this.c.setVisibility(paramInt);
  }
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (TextUtils.isEmpty(paramAEMaterialMetaData.q)) {
      return;
    }
    UIUtils.a(this.i, paramAEMaterialMetaData.q, UIUtils.a(this.i.getContext(), 67.0F), UIUtils.a(this.i.getContext(), 67.0F), this.j.getResources().getDrawable(2063925293), null);
  }
  
  public void b(int paramInt)
  {
    this.a.setVisibility(paramInt);
    this.d.setVisibility(paramInt);
    this.e.setVisibility(paramInt);
  }
  
  public void b(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData.a())
    {
      a(8);
      b(8);
      return;
    }
    if (paramAEMaterialMetaData.A)
    {
      a(8);
      b(8);
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(this.j))
    {
      AEQLog.d("AEMaterialWaterMarkViewHolder", "net work not available");
      a(0);
      b(8);
      return;
    }
    if (paramAEMaterialMetaData.B)
    {
      a(8);
      b(0);
      this.a.setProgress(paramAEMaterialMetaData.C);
      return;
    }
    a(0);
    b(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialWaterMarkViewHolder
 * JD-Core Version:    0.7.0.1
 */