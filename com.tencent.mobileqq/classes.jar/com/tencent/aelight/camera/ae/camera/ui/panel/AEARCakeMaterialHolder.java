package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.data.AEARCakeMaterial;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.view.AEDownLoadingView;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.NetworkUtil;

public class AEARCakeMaterialHolder
  extends RecyclerView.ViewHolder
{
  ImageView a;
  AEDownLoadingView b;
  private URLImageView c;
  private Context d;
  private View e;
  private View f;
  private TextView g;
  private TextView h;
  private TextView i;
  
  public AEARCakeMaterialHolder(Context paramContext, View paramView)
  {
    super(paramView);
    this.d = paramContext;
    this.c = ((URLImageView)paramView.findViewById(2063991486));
    this.a = ((ImageView)paramView.findViewById(2063991017));
    this.b = ((AEDownLoadingView)paramView.findViewById(2063991328));
    this.e = paramView.findViewById(2063991421);
    this.g = ((TextView)paramView.findViewById(2063991121));
    this.h = ((TextView)paramView.findViewById(2063991120));
    this.e.setVisibility(8);
    this.i = ((TextView)paramView.findViewById(2063990941));
    this.f = paramView.findViewById(2063991359);
    int j = AIOUtils.b(6.0F, this.b.getResources());
    int k = AIOUtils.b(2.0F, this.b.getResources());
    int m = AIOUtils.b(16.0F, this.b.getResources());
    this.b.setBgCorner(m / 2);
    this.b.setMinimumHeight(m);
    this.b.setMinimumWidth(m);
    this.b.setProgressSizeAndMode(j, k, false);
    this.b.setBgColor(0);
    this.b.setProgressColor(-1);
    this.b.setBgColor(-1);
    this.b.setProgressColor(-16725252);
    this.b.a(false);
  }
  
  public void a(int paramInt)
  {
    this.a.setVisibility(paramInt);
  }
  
  public void a(AEARCakeMaterial paramAEARCakeMaterial)
  {
    UIUtils.a(this.c, paramAEARCakeMaterial.q, UIUtils.a(this.c.getContext(), 67.0F), UIUtils.a(this.c.getContext(), 67.0F), this.d.getResources().getDrawable(2063925645), null);
  }
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData.A)
    {
      a(8);
      b(8);
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(this.d))
    {
      AEQLog.d("AEARCakeMaterialHolder", "net work not available");
      a(0);
      b(8);
      return;
    }
    if (paramAEMaterialMetaData.B)
    {
      a(8);
      b(0);
      this.b.setProgress(paramAEMaterialMetaData.C);
      return;
    }
    a(0);
    b(8);
  }
  
  public void a(String paramString)
  {
    if (paramString == null)
    {
      this.g.setText(2064187638);
      this.h.setText(2064187636);
      return;
    }
    if (paramString.length() <= 4)
    {
      this.h.setText(2064187636);
      this.g.setText(paramString);
      return;
    }
    paramString = paramString.substring(0, 4);
    this.g.setText(paramString);
    this.h.setText(2064187637);
  }
  
  public void b(int paramInt)
  {
    this.b.setVisibility(paramInt);
  }
  
  public void b(String paramString)
  {
    this.i.setText(paramString);
  }
  
  public void c(int paramInt)
  {
    this.e.setVisibility(paramInt);
  }
  
  public void d(int paramInt)
  {
    this.f.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialHolder
 * JD-Core Version:    0.7.0.1
 */