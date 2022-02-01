package com.tencent.biz.pubaccount.readinjoy.pts.util;

import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.common.ProteusSupportUtil;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.pts.lite.PTSLiteItemViewBuilder;
import com.tencent.biz.pubaccount.readinjoy.pts.lite.PTSLitePlayableCardView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/pts/util/PTSLiteItemViewUtil$Companion;", "", "()V", "CARD_TYPE_NORMAL", "", "CARD_TYPE_SPECIAL", "DIVIDER_BAR_COLOR", "DIVIDER_BAR_HEIGHT", "getDIVIDER_BAR_HEIGHT", "()I", "DIVIDER_LINE_COLOR", "DIVIDER_LINE_HEIGHT", "DIVIDER_ROUND_MARGIN_HORIZONTAL", "getDIVIDER_ROUND_MARGIN_HORIZONTAL", "setDIVIDER_ROUND_MARGIN_HORIZONTAL", "(I)V", "DIVIDER_SQUARE_MARGIN_HORIZONTAL", "getDIVIDER_SQUARE_MARGIN_HORIZONTAL", "setDIVIDER_SQUARE_MARGIN_HORIZONTAL", "DIVIDER_TYPE_NULL", "DIVIDER_TYPE_ROUND_LINE", "DIVIDER_TYPE_SQUARE_BAR", "DIVIDER_TYPE_SQUARE_LINE", "STYLE_TYPE_ROUND", "STYLE_TYPE_SQUARE", "TAG", "", "markWhiteList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "showMark", "", "getShowMark", "()Z", "setShowMark", "(Z)V", "addMarkText", "", "ptsItemView", "Landroid/view/ViewGroup;", "getCardType", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "cellType", "getDividerType", "readInJoyModel", "Lcom/tencent/biz/pubaccount/readinjoy/model/IReadInJoyModel;", "handleFooter", "ptsLitePlayableCardView", "Lcom/tencent/biz/pubaccount/readinjoy/pts/lite/PTSLitePlayableCardView;", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class PTSLiteItemViewUtil$Companion
{
  private final int a(IReadInJoyModel paramIReadInJoyModel)
  {
    if (paramIReadInJoyModel.g()) {
      return 3;
    }
    ArticleInfo localArticleInfo1 = paramIReadInJoyModel.a();
    int j = paramIReadInJoyModel.a();
    ArticleInfo localArticleInfo2 = paramIReadInJoyModel.b();
    int i = paramIReadInJoyModel.b();
    j = ((Companion)this).a(localArticleInfo1, j);
    i = ((Companion)this).a(localArticleInfo2, i);
    if (localArticleInfo1 != null)
    {
      if (localArticleInfo1.ptsRoundCornerCard)
      {
        if ((j == 0) && (i == 0)) {
          return 2;
        }
        return 3;
      }
      if ((int)localArticleInfo1.mChannelID == 70) {
        return 1;
      }
      if ((j == 0) && (i == 0)) {
        return 0;
      }
      return 1;
    }
    return 0;
  }
  
  public final int a()
  {
    return PTSLiteItemViewUtil.a();
  }
  
  public final int a(@Nullable ArticleInfo paramArticleInfo, int paramInt)
  {
    if (((PTSLiteItemViewBuilder.a((BaseArticleInfo)paramArticleInfo)) && (paramArticleInfo != null) && (paramArticleInfo.ptsSpecialCard == true)) || ((!PTSLiteItemViewBuilder.a((BaseArticleInfo)paramArticleInfo)) && (!ProteusSupportUtil.b(paramInt)))) {
      return 1;
    }
    return 0;
  }
  
  public final void a(@NotNull ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "ptsItemView");
  }
  
  public final void a(@NotNull IReadInJoyModel paramIReadInJoyModel, @NotNull PTSLitePlayableCardView paramPTSLitePlayableCardView, @NotNull ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    Intrinsics.checkParameterIsNotNull(paramIReadInJoyModel, "readInJoyModel");
    Intrinsics.checkParameterIsNotNull(paramPTSLitePlayableCardView, "ptsLitePlayableCardView");
    Intrinsics.checkParameterIsNotNull(paramReadInJoyBaseAdapter, "adapter");
    paramPTSLitePlayableCardView.a(((Companion)this).a(paramIReadInJoyModel));
    paramPTSLitePlayableCardView.a(paramIReadInJoyModel, paramReadInJoyBaseAdapter);
  }
  
  public final int b()
  {
    return PTSLiteItemViewUtil.b();
  }
  
  public final int c()
  {
    return PTSLiteItemViewUtil.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.util.PTSLiteItemViewUtil.Companion
 * JD-Core Version:    0.7.0.1
 */