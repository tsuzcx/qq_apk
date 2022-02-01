package com.tencent.hippy.qq.module.tkd;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJCreateArticleInfoForBiu;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/hippy/qq/module/tkd/TKDBiuModule$openBiuEditor$1", "Lcom/tencent/hippy/qq/module/tkd/TKDBiuModule$ParamsFetcher;", "onGetParams", "", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "adTag", "", "biuType", "sourceUrl", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class TKDBiuModule$openBiuEditor$1
  implements TKDBiuModule.ParamsFetcher
{
  TKDBiuModule$openBiuEditor$1(Activity paramActivity, String paramString1, long paramLong, String paramString2) {}
  
  public void onGetParams(@NotNull ArticleInfo paramArticleInfo, int paramInt1, int paramInt2, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramArticleInfo, "articleInfo");
    Intrinsics.checkParameterIsNotNull(paramString, "sourceUrl");
    paramArticleInfo = RIJCreateArticleInfoForBiu.a(new Intent((Context)this.$activity, ReadInJoyDeliverBiuActivity.class), paramArticleInfo, paramInt2, this.$comment, this.$uin, this.$nickname, 0, paramInt1);
    Intrinsics.checkExpressionValueIsNotNull(paramArticleInfo, "RIJCreateArticleInfoForB…tInfo.OP_TYPE_BIU, adTag)");
    this.$activity.startActivityForResult(paramArticleInfo, 113);
    this.$activity.overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.tkd.TKDBiuModule.openBiuEditor.1
 * JD-Core Version:    0.7.0.1
 */