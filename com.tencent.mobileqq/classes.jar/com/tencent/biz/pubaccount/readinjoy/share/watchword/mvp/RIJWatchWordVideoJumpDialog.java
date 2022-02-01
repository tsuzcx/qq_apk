package com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJWatchWordVideoJumpDialog;", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJWatchWordJumpDialog;", "parent", "Landroid/view/ViewGroup;", "userName", "", "videoInfo", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJReadWatchWordModel$VideoInfo;", "jumpAction", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "clickType", "", "(Landroid/view/ViewGroup;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJReadWatchWordModel$VideoInfo;Lkotlin/jvm/functions/Function1;)V", "createView", "Landroid/view/View;", "initOnClickListener", "initView", "onClick", "v", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJWatchWordVideoJumpDialog
  extends RIJWatchWordJumpDialog
{
  private final RIJReadWatchWordModel.VideoInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyShareWatchwordMvpRIJReadWatchWordModel$VideoInfo;
  private final String jdField_a_of_type_JavaLangString;
  
  public RIJWatchWordVideoJumpDialog(@NotNull ViewGroup paramViewGroup, @NotNull String paramString, @NotNull RIJReadWatchWordModel.VideoInfo paramVideoInfo, @Nullable Function1<? super Integer, Unit> paramFunction1)
  {
    super(paramViewGroup, paramFunction1);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyShareWatchwordMvpRIJReadWatchWordModel$VideoInfo = paramVideoInfo;
    d();
    c();
  }
  
  private final void c()
  {
    ImageView localImageView = (ImageView)a(2131381434);
    if (localImageView != null) {
      localImageView.setOnClickListener((View.OnClickListener)this);
    }
  }
  
  private final void d()
  {
    ViewGroup.LayoutParams localLayoutParams2 = null;
    ViewGroup.LayoutParams localLayoutParams1 = null;
    Object localObject = (TextView)a(2131381083);
    ImageView localImageView = (ImageView)a(2131381434);
    RelativeLayout localRelativeLayout = (RelativeLayout)a(2131381435);
    View localView = a(2131381417);
    TextView localTextView = (TextView)a(2131379536);
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)this.jdField_a_of_type_JavaLangString);
    }
    if (localTextView != null) {
      localTextView.setText((CharSequence)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyShareWatchwordMvpRIJReadWatchWordModel$VideoInfo.b());
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyShareWatchwordMvpRIJReadWatchWordModel$VideoInfo.a() == 1)
    {
      if (localImageView != null)
      {
        localLayoutParams2 = localImageView.getLayoutParams();
        if (localLayoutParams2 != null)
        {
          localObject = a();
          if (localObject == null) {
            break label282;
          }
          localObject = ((View)localObject).getContext();
          localLayoutParams2.height = DisplayUtil.b((Context)localObject, 170.0F);
        }
      }
      if (localRelativeLayout != null)
      {
        localLayoutParams2 = localRelativeLayout.getLayoutParams();
        if (localLayoutParams2 != null)
        {
          localObject = a();
          if (localObject == null) {
            break label287;
          }
        }
      }
      label282:
      label287:
      for (localObject = ((View)localObject).getContext();; localObject = null)
      {
        localLayoutParams2.height = DisplayUtil.b((Context)localObject, 170.0F);
        if (localView != null)
        {
          localLayoutParams2 = localView.getLayoutParams();
          if (localLayoutParams2 != null)
          {
            localView = a();
            localObject = localLayoutParams1;
            if (localView != null) {
              localObject = localView.getContext();
            }
            localLayoutParams2.height = DisplayUtil.b((Context)localObject, 85.0F);
          }
        }
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = ((Drawable)new ColorDrawable(0));
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = ((Drawable)new ColorDrawable(0));
        if (localImageView != null) {
          localImageView.setImageDrawable((Drawable)URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyShareWatchwordMvpRIJReadWatchWordModel$VideoInfo.a(), (URLDrawable.URLDrawableOptions)localObject));
        }
        return;
        localObject = null;
        break;
      }
    }
    if (localImageView != null)
    {
      localLayoutParams1 = localImageView.getLayoutParams();
      if (localLayoutParams1 != null)
      {
        localObject = a();
        if (localObject == null) {
          break label473;
        }
        localObject = ((View)localObject).getContext();
        label321:
        localLayoutParams1.height = DisplayUtil.b((Context)localObject, 270.0F);
      }
    }
    if (localRelativeLayout != null)
    {
      localLayoutParams1 = localRelativeLayout.getLayoutParams();
      if (localLayoutParams1 != null)
      {
        localObject = a();
        if (localObject == null) {
          break label478;
        }
      }
    }
    label473:
    label478:
    for (localObject = ((View)localObject).getContext();; localObject = null)
    {
      localLayoutParams1.height = DisplayUtil.b((Context)localObject, 270.0F);
      if (localView != null)
      {
        localLayoutParams1 = localView.getLayoutParams();
        if (localLayoutParams1 != null)
        {
          localView = a();
          localObject = localLayoutParams2;
          if (localView != null) {
            localObject = localView.getContext();
          }
          localLayoutParams1.height = DisplayUtil.b((Context)localObject, 135.0F);
        }
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = ((Drawable)new ColorDrawable(0));
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = ((Drawable)new ColorDrawable(0));
      if (localImageView == null) {
        break;
      }
      localImageView.setImageDrawable((Drawable)URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyShareWatchwordMvpRIJReadWatchWordModel$VideoInfo.a(), (URLDrawable.URLDrawableOptions)localObject));
      return;
      localObject = null;
      break label321;
    }
  }
  
  @NotNull
  protected View b()
  {
    View localView = LayoutInflater.from(a().getContext()).inflate(2131562900, a(), false);
    Intrinsics.checkExpressionValueIsNotNull(localView, "LayoutInflater.from(pare…mp_dialog, parent, false)");
    return localView;
  }
  
  public void onClick(@Nullable View paramView)
  {
    super.onClick(paramView);
    if (Intrinsics.areEqual(paramView, a(2131381434)))
    {
      Object localObject = a();
      if (localObject != null) {
        localObject = (Unit)((Function1)localObject).invoke(Integer.valueOf(1));
      }
      b(false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.RIJWatchWordVideoJumpDialog
 * JD-Core Version:    0.7.0.1
 */