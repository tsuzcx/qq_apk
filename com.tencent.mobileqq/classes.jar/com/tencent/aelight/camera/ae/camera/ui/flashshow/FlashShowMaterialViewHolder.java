package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.view.AEDownLoadingView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/FlashShowMaterialViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "mAEProgressView", "Lcom/tencent/aelight/camera/ae/view/AEDownLoadingView;", "getMAEProgressView", "()Lcom/tencent/aelight/camera/ae/view/AEDownLoadingView;", "setMAEProgressView", "(Lcom/tencent/aelight/camera/ae/view/AEDownLoadingView;)V", "mContext", "Landroid/content/Context;", "mCurrentState", "", "mHightlightImage", "Landroid/widget/ImageView;", "getMHightlightImage", "()Landroid/widget/ImageView;", "setMHightlightImage", "(Landroid/widget/ImageView;)V", "mImgDownAndNewIcon", "getMImgDownAndNewIcon", "setMImgDownAndNewIcon", "mImgvTemplateIcon", "Lcom/tencent/image/URLImageView;", "getMImgvTemplateIcon", "()Lcom/tencent/image/URLImageView;", "setMImgvTemplateIcon", "(Lcom/tencent/image/URLImageView;)V", "mWaterMarkEditImage", "Landroid/widget/RelativeLayout;", "getMWaterMarkEditImage", "()Landroid/widget/RelativeLayout;", "setMWaterMarkEditImage", "(Landroid/widget/RelativeLayout;)V", "topRightIcon", "getTopRightIcon", "setTopRightIcon", "init", "", "context", "initMaterialBasicInfo", "info", "Lcom/tencent/aelight/camera/ae/data/AEMaterialMetaData;", "setCurrentState", "state", "data", "showAsInValidState", "showAsValidSelectedState", "showAsValidUnSelectedState", "showDownloadIcon", "showStateView", "showTopRightIcon", "Companion", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class FlashShowMaterialViewHolder
  extends RecyclerView.ViewHolder
{
  public static final FlashShowMaterialViewHolder.Companion a = new FlashShowMaterialViewHolder.Companion(null);
  @NotNull
  private URLImageView b;
  @NotNull
  private ImageView c;
  @NotNull
  private ImageView d;
  @NotNull
  private ImageView e;
  @NotNull
  private AEDownLoadingView f;
  @NotNull
  private RelativeLayout g;
  private int h;
  private Context i;
  
  public FlashShowMaterialViewHolder(@NotNull View paramView)
  {
    super(paramView);
    View localView = paramView.findViewById(2063991486);
    Intrinsics.checkExpressionValueIsNotNull(localView, "itemView.findViewById(R.id.thumb)");
    this.b = ((URLImageView)localView);
    localView = paramView.findViewById(2063991419);
    Intrinsics.checkExpressionValueIsNotNull(localView, "itemView.findViewById(R.id.select_highlight)");
    this.c = ((ImageView)localView);
    localView = paramView.findViewById(2063991019);
    Intrinsics.checkExpressionValueIsNotNull(localView, "itemView.findViewById(R.id.download_view)");
    this.d = ((ImageView)localView);
    localView = paramView.findViewById(2063991502);
    Intrinsics.checkExpressionValueIsNotNull(localView, "itemView.findViewById(R.id.topright_view)");
    this.e = ((ImageView)localView);
    localView = paramView.findViewById(2063991328);
    Intrinsics.checkExpressionValueIsNotNull(localView, "itemView.findViewById(R.id.progress_view)");
    this.f = ((AEDownLoadingView)localView);
    paramView = paramView.findViewById(2063991619);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "itemView.findViewById(R.id.watermark_edit)");
    this.g = ((RelativeLayout)paramView);
  }
  
  private final void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.c.setVisibility(8);
    this.d.setVisibility(8);
    this.e.setVisibility(8);
    this.g.setVisibility(8);
  }
  
  private final void b(AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.c.setVisibility(8);
    c(paramAEMaterialMetaData);
    e(paramAEMaterialMetaData);
    this.g.setVisibility(FlashShowMaterialViewHolder.Companion.a(a, paramAEMaterialMetaData.u));
  }
  
  private final void c(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData.a())
    {
      this.d.setVisibility(8);
      this.f.setVisibility(8);
      return;
    }
    if (paramAEMaterialMetaData.A)
    {
      this.d.setVisibility(8);
      this.f.setVisibility(8);
      return;
    }
    if (paramAEMaterialMetaData.B)
    {
      this.d.setVisibility(8);
      this.f.setVisibility(0);
      this.f.setProgress(paramAEMaterialMetaData.C);
      return;
    }
    this.d.setVisibility(0);
    this.d.setImageResource(2063925326);
    this.f.setVisibility(8);
  }
  
  private final void d(AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.c.setVisibility(0);
    this.c.setImageResource(2063925330);
    c(paramAEMaterialMetaData);
    e(paramAEMaterialMetaData);
    this.g.setVisibility(FlashShowMaterialViewHolder.Companion.a(a, paramAEMaterialMetaData.u));
  }
  
  private final void e(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData.a())
    {
      this.e.setVisibility(0);
      this.e.setImageResource(2130847606);
      return;
    }
    if (paramAEMaterialMetaData.b())
    {
      this.e.setVisibility(0);
      this.e.setImageResource(paramAEMaterialMetaData.c());
      return;
    }
    this.e.setVisibility(8);
  }
  
  private final void f(AEMaterialMetaData paramAEMaterialMetaData)
  {
    int j = this.h;
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2)
        {
          a(paramAEMaterialMetaData);
          return;
        }
        d(paramAEMaterialMetaData);
        g(paramAEMaterialMetaData);
        return;
      }
      b(paramAEMaterialMetaData);
      g(paramAEMaterialMetaData);
      return;
    }
    a(paramAEMaterialMetaData);
  }
  
  private final void g(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (TextUtils.isEmpty((CharSequence)paramAEMaterialMetaData.q)) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    float f1 = 64;
    Object localObject = this.i;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    int j = AIOUtils.b(f1, ((Context)localObject).getResources());
    localObject = this.i;
    if (localObject != null)
    {
      localObject = ((Context)localObject).getResources();
      if (localObject != null)
      {
        localObject = ((Resources)localObject).getDrawable(2063925549);
        break label85;
      }
    }
    localObject = null;
    label85:
    localURLDrawableOptions.mRequestWidth = j;
    localURLDrawableOptions.mRequestHeight = j;
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mRetryCount = 3;
    paramAEMaterialMetaData = URLDrawable.getDrawable(paramAEMaterialMetaData.q, localURLDrawableOptions);
    Intrinsics.checkExpressionValueIsNotNull(paramAEMaterialMetaData, "drawable");
    if (paramAEMaterialMetaData.getStatus() == 2) {
      paramAEMaterialMetaData.restartDownload();
    }
    this.b.setImageDrawable((Drawable)paramAEMaterialMetaData);
  }
  
  public final void a(int paramInt, @NotNull AEMaterialMetaData paramAEMaterialMetaData)
  {
    Intrinsics.checkParameterIsNotNull(paramAEMaterialMetaData, "data");
    this.h = paramInt;
    f(paramAEMaterialMetaData);
  }
  
  public final void a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    this.i = paramContext;
    int j = AIOUtils.b(6, paramContext.getResources());
    int k = AIOUtils.b(1.5F, paramContext.getResources());
    int m = AIOUtils.b((float)13.699999999999999D, paramContext.getResources());
    this.f.setBgCorner(m / 2);
    this.f.setMinimumHeight(m);
    this.f.setMinimumWidth(m);
    this.f.setProgressSizeAndMode(j, k, false);
    this.f.setBgColor(1996488704);
    this.f.setProgressColor(-1);
    this.f.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.FlashShowMaterialViewHolder
 * JD-Core Version:    0.7.0.1
 */