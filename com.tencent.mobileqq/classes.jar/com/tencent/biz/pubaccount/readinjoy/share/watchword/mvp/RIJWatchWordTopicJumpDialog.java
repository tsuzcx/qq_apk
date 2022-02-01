package com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJWatchWordTopicJumpDialog;", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJWatchWordJumpDialog;", "parent", "Landroid/view/ViewGroup;", "userName", "", "topicInfo", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJReadWatchWordModel$TopicInfo;", "jumpAction", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "clickType", "", "(Landroid/view/ViewGroup;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJReadWatchWordModel$TopicInfo;Lkotlin/jvm/functions/Function1;)V", "createView", "Landroid/view/View;", "initOnClickListener", "initView", "onClick", "v", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJWatchWordTopicJumpDialog
  extends RIJWatchWordJumpDialog
{
  private final RIJReadWatchWordModel.TopicInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyShareWatchwordMvpRIJReadWatchWordModel$TopicInfo;
  private final String jdField_a_of_type_JavaLangString;
  
  public RIJWatchWordTopicJumpDialog(@NotNull ViewGroup paramViewGroup, @NotNull String paramString, @NotNull RIJReadWatchWordModel.TopicInfo paramTopicInfo, @Nullable Function1<? super Integer, Unit> paramFunction1)
  {
    super(paramViewGroup, paramFunction1);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyShareWatchwordMvpRIJReadWatchWordModel$TopicInfo = paramTopicInfo;
    d();
    c();
  }
  
  private final void c()
  {
    ImageView localImageView = (ImageView)a(2131379700);
    if (localImageView != null) {
      localImageView.setOnClickListener((View.OnClickListener)this);
    }
  }
  
  private final void d()
  {
    Object localObject = (TextView)a(2131381083);
    TextView localTextView = (TextView)a(2131379715);
    ImageView localImageView = (ImageView)a(2131379700);
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)this.jdField_a_of_type_JavaLangString);
    }
    if (localTextView != null) {
      localTextView.setText((CharSequence)(ReadInJoyUtils.a(2131718403) + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyShareWatchwordMvpRIJReadWatchWordModel$TopicInfo.b()));
    }
    localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = ((Drawable)new ColorDrawable(0));
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = ((Drawable)new ColorDrawable(0));
    if (localImageView != null) {
      localImageView.setImageDrawable((Drawable)URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyShareWatchwordMvpRIJReadWatchWordModel$TopicInfo.a(), (URLDrawable.URLDrawableOptions)localObject));
    }
  }
  
  @NotNull
  protected View b()
  {
    View localView = LayoutInflater.from(a().getContext()).inflate(2131562899, a(), false);
    Intrinsics.checkExpressionValueIsNotNull(localView, "LayoutInflater.from(pare…mp_dialog, parent, false)");
    return localView;
  }
  
  public void onClick(@Nullable View paramView)
  {
    super.onClick(paramView);
    if (Intrinsics.areEqual(paramView, a(2131379700)))
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
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.RIJWatchWordTopicJumpDialog
 * JD-Core Version:    0.7.0.1
 */