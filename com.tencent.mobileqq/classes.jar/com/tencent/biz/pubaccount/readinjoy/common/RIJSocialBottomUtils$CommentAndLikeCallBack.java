package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentViewItem;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager.OnDataChangeListener;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule.FastWebArticleRichReqCallback;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/common/RIJSocialBottomUtils$CommentAndLikeCallBack;", "Lcom/tencent/biz/pubaccount/readinjoy/model/FastWebModule$FastWebArticleRichReqCallback;", "Lcom/tencent/biz/pubaccount/readinjoy/comment/data/ReadInJoyCommentDataManager$OnDataChangeListener;", "articleRowkey", "", "bottomSocialView", "Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyFastWebBottomSocialViewNew;", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "fastWebInfo", "Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebArticleInfo;", "(Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyFastWebBottomSocialViewNew;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebArticleInfo;)V", "getArticleInfo", "()Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "getArticleRowkey", "()Ljava/lang/String;", "setArticleRowkey", "(Ljava/lang/String;)V", "getBottomSocialView", "()Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyFastWebBottomSocialViewNew;", "setBottomSocialView", "(Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyFastWebBottomSocialViewNew;)V", "getFastWebInfo", "()Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebArticleInfo;", "setFastWebInfo", "(Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebArticleInfo;)V", "handleLikeStateResp", "", "isLiked", "", "rowKey", "onCommentBlock", "commentType", "", "success", "deleteCommentsPair", "Lcom/tencent/util/Pair;", "", "Lcom/tencent/biz/pubaccount/readinjoy/comment/data/BaseCommentData;", "onCommentCreate", "newComment", "Lcom/tencent/biz/pubaccount/readinjoy/comment/data/CommentViewItem;", "recordHotHisPos", "commentViewItemList", "", "feedsType", "onCommentDelete", "deleteComment", "onCommentLikeOrDislike", "commentData", "opType", "value", "onCommentListLoad", "totalCommentDataList", "hasNextPage", "flow", "onCommentLoadMore", "onCommentReply", "replyComment", "onCommentReport", "firstCommentID", "secondCommentID", "onCommentStateError", "code", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJSocialBottomUtils$CommentAndLikeCallBack
  extends FastWebModule.FastWebArticleRichReqCallback
  implements ReadInJoyCommentDataManager.OnDataChangeListener
{
  @Nullable
  private final ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  @Nullable
  private ReadInJoyFastWebBottomSocialViewNew jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew;
  @Nullable
  private FastWebArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
  @Nullable
  private String jdField_a_of_type_JavaLangString;
  
  public RIJSocialBottomUtils$CommentAndLikeCallBack()
  {
    this(null, null, null, null, 15, null);
  }
  
  public RIJSocialBottomUtils$CommentAndLikeCallBack(@Nullable String paramString, @Nullable ReadInJoyFastWebBottomSocialViewNew paramReadInJoyFastWebBottomSocialViewNew, @Nullable ArticleInfo paramArticleInfo, @Nullable FastWebArticleInfo paramFastWebArticleInfo)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew = paramReadInJoyFastWebBottomSocialViewNew;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo = paramFastWebArticleInfo;
  }
  
  public final void a(@Nullable ReadInJoyFastWebBottomSocialViewNew paramReadInJoyFastWebBottomSocialViewNew)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew = paramReadInJoyFastWebBottomSocialViewNew;
  }
  
  public void a(boolean paramBoolean, @Nullable String paramString)
  {
    QLog.d("RIJSocialBottomUtils", 1, "handleLikeStateResp back! isLiked=" + paramBoolean + ", rowKey=" + paramString + ", articleRowkey=" + this.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_JavaLangString != null) && (StringsKt.equals(this.jdField_a_of_type_JavaLangString, paramString, true)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew != null))
    {
      paramString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
      if (paramString != null) {
        paramString.a = paramBoolean;
      }
      RIJSocialBottomUtils.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo);
    }
  }
  
  public void onCommentBlock(int paramInt, boolean paramBoolean, @Nullable Pair<List<BaseCommentData>, List<BaseCommentData>> paramPair) {}
  
  public void onCommentCreate(boolean paramBoolean, @NotNull CommentViewItem paramCommentViewItem, @NotNull List<? extends CommentViewItem> paramList, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCommentViewItem, "newComment");
    Intrinsics.checkParameterIsNotNull(paramList, "commentViewItemList");
  }
  
  public void onCommentCreate(boolean paramBoolean1, @NotNull CommentViewItem paramCommentViewItem, boolean paramBoolean2, @NotNull List<? extends CommentViewItem> paramList, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCommentViewItem, "newComment");
    Intrinsics.checkParameterIsNotNull(paramList, "commentViewItemList");
  }
  
  public void onCommentDelete(int paramInt1, boolean paramBoolean, @NotNull CommentViewItem paramCommentViewItem, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramCommentViewItem, "deleteComment");
  }
  
  public void onCommentLikeOrDislike(boolean paramBoolean, @NotNull BaseCommentData paramBaseCommentData, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseCommentData, "commentData");
  }
  
  public void onCommentListLoad(int paramInt1, boolean paramBoolean1, @NotNull List<? extends CommentViewItem> paramList, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "totalCommentDataList");
    paramList = ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    QLog.d("RIJSocialBottomUtils", 1, "onCommentListLoad back! ");
    if (paramList != null)
    {
      long l = paramList.a();
      paramList = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
      if (paramList != null) {
        paramList.b = l;
      }
      RIJSocialBottomUtils.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo);
      QLog.d("RIJSocialBottomUtils", 1, "onCommentListLoad back!  count=" + l);
    }
  }
  
  public void onCommentLoadMore(int paramInt1, boolean paramBoolean1, @NotNull List<? extends CommentViewItem> paramList, boolean paramBoolean2, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "totalCommentDataList");
  }
  
  public void onCommentReply(boolean paramBoolean, @NotNull CommentViewItem paramCommentViewItem)
  {
    Intrinsics.checkParameterIsNotNull(paramCommentViewItem, "replyComment");
  }
  
  public void onCommentReport(int paramInt, boolean paramBoolean, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "firstCommentID");
    Intrinsics.checkParameterIsNotNull(paramString2, "secondCommentID");
  }
  
  public void onCommentStateError(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.RIJSocialBottomUtils.CommentAndLikeCallBack
 * JD-Core Version:    0.7.0.1
 */