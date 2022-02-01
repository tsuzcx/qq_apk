package com.tencent.biz.pubaccount.readinjoy.comment.ui;

import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.QShareUtils;
import com.tencent.biz.pubaccount.util.ReadInJoyShareHelperV2.BaseSheetItemClickProcessor;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/ui/RIJCommentBubbleView$SheetItemClickProcessor;", "Lcom/tencent/biz/pubaccount/util/ReadInJoyShareHelperV2$BaseSheetItemClickProcessor;", "mArticleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "commentData", "Lcom/tencent/biz/pubaccount/readinjoy/comment/data/BaseCommentData;", "mActivityReference", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "(Lcom/tencent/biz/pubaccount/readinjoy/comment/ui/RIJCommentBubbleView;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;Lcom/tencent/biz/pubaccount/readinjoy/comment/data/BaseCommentData;Ljava/lang/ref/WeakReference;)V", "getCommentData", "()Lcom/tencent/biz/pubaccount/readinjoy/comment/data/BaseCommentData;", "getMActivityReference", "()Ljava/lang/ref/WeakReference;", "getMArticleInfo", "()Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "mShareUtils", "Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/QShareUtils;", "processClick", "", "action", "", "item", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJCommentBubbleView$SheetItemClickProcessor
  extends ReadInJoyShareHelperV2.BaseSheetItemClickProcessor
{
  @NotNull
  private final BaseCommentData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
  @NotNull
  private final ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private final QShareUtils jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesQShareUtils;
  @NotNull
  private final WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  
  public RIJCommentBubbleView$SheetItemClickProcessor(ArticleInfo paramArticleInfo, @NotNull BaseCommentData paramBaseCommentData, @NotNull WeakReference<Activity> paramWeakReference)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramBaseCommentData;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData = paramWeakReference;
    this.jdField_a_of_type_JavaLangRefWeakReference = localObject;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesQShareUtils = new QShareUtils();
  }
  
  public boolean a(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    Intrinsics.checkParameterIsNotNull(paramActionSheetItem, "item");
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("shareCallBack", "");
      localJSONObject.put("title", "腾讯看点热评");
      localJSONObject.put("back", true);
      localJSONObject.put("sourceName", HardCodeUtil.a(2131702751));
      localJSONObject.put("WXShareFromQQKandian", 1);
      localJSONObject.put("src_iconUrl", "https://sqimg.qq.com/qq_product_operations/kan/images/viola/shortPGC/kd_icon_v4.png");
      localJSONObject.put("srcIconUrl", "https://sqimg.qq.com/qq_product_operations/kan/images/viola/shortPGC/kd_icon_v4.png");
      localJSONObject.put("src_action", "plugin");
      localJSONObject.put("src_webActionUrl", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
      localJSONObject.put("src_actionData", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
      localJSONObject.put("desc", "精彩评论： " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentContent);
      localJSONObject.put("menu_title", HardCodeUtil.a(2131713537));
      localJSONObject.put("share_url", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.shareUrl);
      localJSONObject.put("image_url", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFirstPagePicUrl);
      localJSONObject.put("keepShareUrl", 1);
      localJSONObject.put("weibo_title", HardCodeUtil.a(2131712989));
      localJSONObject.put("uin", "");
      localJSONObject.put("puin", 0);
      String str = (String)null;
      if (paramActionSheetItem.action == 72)
      {
        str = paramActionSheetItem.uin;
        if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesQShareUtils.a(localJSONObject, paramInt, (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), str, paramActionSheetItem.uinType, paramActionSheetItem.label);
        }
        return super.a(paramInt, paramActionSheetItem);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.w("RIJCommentBubbleView", 1, localJSONException.toString());
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        QLog.e("RIJCommentBubbleView", 1, localNullPointerException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ui.RIJCommentBubbleView.SheetItemClickProcessor
 * JD-Core Version:    0.7.0.1
 */