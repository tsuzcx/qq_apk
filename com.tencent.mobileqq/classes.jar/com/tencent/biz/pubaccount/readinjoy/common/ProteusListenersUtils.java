package com.tencent.biz.pubaccount.readinjoy.common;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.NativeAd.report.VideoAdClickRecorder;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.comment.RIJMedalUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtParamBuilder;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.UserOptInfo;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertController;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertRecordAction.ActionType;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertAction;
import com.tencent.biz.pubaccount.readinjoy.model.FreeNetFlowInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyModelImpl;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnAccountCardClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnAdLocationClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnAnswerCapsuleClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnArticleWrapperClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnBiuClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnCommentClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnFriendsBiuClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnGalleryCommentClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnJumpChannelListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnJumpWrapperClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnLikeClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnMoreBiuClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnPivacyClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnReadArticleClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnShareClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnSmallGameCardClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnSocialAvatarClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnSocialBiuCountClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnSocialHeaderClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnSocialHeaderFollowClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnSocialLikeCountClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnSuperTopicClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnTopicCapsuleClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnTopicDeliverClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnTopicRecommendHeaderClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnTopicRecommendHeaderFollowClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnUserCommentClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnUserCommentEditClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnWeChatVideoWatchLaterClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeSummaryView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCellTypeProteus;
import com.tencent.biz.pubaccount.readinjoy.report.UserActionCollector;
import com.tencent.biz.pubaccount.readinjoy.srtUtils.UGRuleManager;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AwesomeCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdClickPosUtil;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/common/ProteusListenersUtils;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "methodsMap", "", "", "Lkotlin/Function9;", "Lcom/tencent/biz/pubaccount/readinjoy/proteus/item/ProteusItemView;", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/VafContext;", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;", "Lcom/tencent/biz/pubaccount/readinjoy/model/IReadInJoyModel;", "Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/container/Container;", "", "getMethodsMap", "()Ljava/util/Map;", "STR_ID_CMD_ACCOUNT_CARD_CLICK_FUN", "adapterViewType", "itemView", "vafContext", "faceDecoder", "adapter", "model", "articleInfo", "viewBase", "container", "STR_ID_CMD_AD_BUBBLE_CLICK_FUN", "STR_ID_CMD_AD_COLOR_ICON_CLICK_FUN", "STR_ID_CMD_AD_DOWNLOAD_AREA_CLICK_FUN", "STR_ID_CMD_AD_EDUCATION_TEACHER_ICON_CLICK_FUN", "STR_ID_CMD_AD_EDUCATION_TEACHER_NAME_CLICK_FUN", "STR_ID_CMD_AD_GAME1_CLICK_FUN", "STR_ID_CMD_AD_IMG_CLICK_FUN", "STR_ID_CMD_AD_NAME_CLICK_IN_RECOMMEND_FUN", "STR_ID_CMD_AD_NOTHING_CLICK_IN_RECOMMEND_FUN", "STR_ID_CMD_AD_OPERATION_PK_LEFT_FUN", "STR_ID_CMD_AD_TAGS_CLICK_FUN", "STR_ID_CMD_AD_TEXT_CLICK_FUN", "STR_ID_CMD_AD_TITLE_CLICK_IN_RECOMMEND_FUN", "STR_ID_CMD_ANSWER_CAPSULE_CLICK_FUN", "STR_ID_CMD_ARTICLE_WRAPPER_CLICK_FUN", "STR_ID_CMD_AWESOME_CLICK_FUN", "STR_ID_CMD_BIU_CLICK_FUN", "STR_ID_CMD_CMD_SOCIAL_BOTTOM_CLICK_FUN", "STR_ID_CMD_COMMENT_CLICK_FUN", "STR_ID_CMD_COMMUNITY_CLICK_FUN", "STR_ID_CMD_DISLIKE_CLICK_FUN", "STR_ID_CMD_FRIENDS_BIU_FUN", "STR_ID_CMD_GALLERY_COMMENT_CLICK_FUN", "STR_ID_CMD_HEAD_MEDAL_CLICK_FUN", "STR_ID_CMD_HOT_QUESTION_HEAD_CLICK_FUN", "STR_ID_CMD_JUMP_CLICK_FUN", "STR_ID_CMD_JUMP_WRAPPER_CLICK_FUN", "STR_ID_CMD_LARGET_VIDEO_ACTIVITY_WRAPPER_CLICK_FUN", "STR_ID_CMD_LARGE_IMG_CLICK_FUN", "STR_ID_CMD_LARGE_VIDEO_CLICK_FUN", "STR_ID_CMD_LIKE_CLICK_FUN", "STR_ID_CMD_LOCATION_CLICK_FUN", "STR_ID_CMD_NATIVE_DETAIL_AD_NEGATIVE_CLICK_FUN", "STR_ID_CMD_PACK_BOTTOM_CLICK_FUN", "STR_ID_CMD_PARTNER_HEADER_CLICK_FUN", "STR_ID_CMD_PRIVACY_LIST_CLICK_FUN", "STR_ID_CMD_READ_ARTICLE_CLICK_FUN", "STR_ID_CMD_RIGHT_DISLIKE_CLICK_FUN", "STR_ID_CMD_SHARE_CLICK_FUN", "STR_ID_CMD_SOCIAL_AVATAR_CLICK_FUN", "STR_ID_CMD_SOCIAL_DATA_BIU_CLICK_FUN", "STR_ID_CMD_SOCIAL_DATA_LIKE_CLICK_FUN", "STR_ID_CMD_SOCIAL_HEADER_FOLLOW_BUTTON_CLICK_FUN", "STR_ID_CMD_SUMMARY_CLICK_FUN", "STR_ID_CMD_SUPER_TOPIC_BUTTON_CLICK_FUN", "STR_ID_CMD_SUPER_TOPIC_CLICK_FUN", "STR_ID_CMD_TOPIC_CAPSULE_CLICK_FUN", "STR_ID_CMD_TOPIC_RECOMMEND_HEADER_CLICK_FUN", "STR_ID_CMD_TOPIC_RECOMMEND_HEADER_FOLLOW_CLICK_FUN", "STR_ID_CMD_UGC_AD_CLICK_FUN", "STR_ID_CMD_URL_CLICK_CARD_REPORT_FUN", "STR_ID_CMD_URL_CLICK_NO_CARD_REPORT_FUN", "STR_ID_CMD_USERS_COMMENT_EDIT_FUN", "STR_ID_CMD_USERS_COMMENT_FUN", "STR_ID_COMMENT_BIU_MORE_IMG_FUN", "STR_ID_FAMILY_ICON_CLICK_FUN", "STR_ID_STR_ID_CMD_WE_CHAT_SEE_LATER_CLICK_FUN", "doNothing", "getContext", "Landroid/content/Context;", "getModelChannelID", "invokeListener", "cmd", "viewType", "view", "context", "face", "ad", "iModel", "info", "base", "con", "registerListeners", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ProteusListenersUtils
{
  public static final ProteusListenersUtils a;
  @NotNull
  private static final String jdField_a_of_type_JavaLangString = "ProteusListenersUtils";
  @NotNull
  private static final Map<Integer, Function9<Integer, ProteusItemView, VafContext, IFaceDecoder, ReadInJoyBaseAdapter, IReadInJoyModel, BaseArticleInfo, ViewBase, Container, Unit>> jdField_a_of_type_JavaUtilMap;
  
  static
  {
    ProteusListenersUtils localProteusListenersUtils = new ProteusListenersUtils();
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonProteusListenersUtils = localProteusListenersUtils;
    jdField_a_of_type_JavaLangString = "ProteusListenersUtils";
    jdField_a_of_type_JavaUtilMap = (Map)new LinkedHashMap();
    localProteusListenersUtils.a();
  }
  
  private final int a(IReadInJoyModel paramIReadInJoyModel)
  {
    if (paramIReadInJoyModel != null) {
      return paramIReadInJoyModel.e();
    }
    return 0;
  }
  
  private final void a()
  {
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1001), new ProteusListenersUtils.registerListeners.1((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1198), new ProteusListenersUtils.registerListeners.2((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1071), new ProteusListenersUtils.registerListeners.3((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1002), new ProteusListenersUtils.registerListeners.4((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1020), new ProteusListenersUtils.registerListeners.5((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1025), new ProteusListenersUtils.registerListeners.6((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1003), new ProteusListenersUtils.registerListeners.7((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1004), new ProteusListenersUtils.registerListeners.8((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1005), new ProteusListenersUtils.registerListeners.9((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1034), new ProteusListenersUtils.registerListeners.10((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1006), new ProteusListenersUtils.registerListeners.11((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1007), new ProteusListenersUtils.registerListeners.12((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1008), new ProteusListenersUtils.registerListeners.13((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1010), new ProteusListenersUtils.registerListeners.14((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1012), new ProteusListenersUtils.registerListeners.15((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1013), new ProteusListenersUtils.registerListeners.16((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1014), new ProteusListenersUtils.registerListeners.17((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1015), new ProteusListenersUtils.registerListeners.18((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1016), new ProteusListenersUtils.registerListeners.19((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1037), new ProteusListenersUtils.registerListeners.20((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1019), new ProteusListenersUtils.registerListeners.21((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1021), new ProteusListenersUtils.registerListeners.22((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1022), new ProteusListenersUtils.registerListeners.23((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1023), new ProteusListenersUtils.registerListeners.24((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1026), new ProteusListenersUtils.registerListeners.25((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1027), new ProteusListenersUtils.registerListeners.26((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1028), new ProteusListenersUtils.registerListeners.27((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1030), new ProteusListenersUtils.registerListeners.28((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1032), new ProteusListenersUtils.registerListeners.29((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1033), new ProteusListenersUtils.registerListeners.30((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1036), new ProteusListenersUtils.registerListeners.31((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1174), new ProteusListenersUtils.registerListeners.32((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1175), new ProteusListenersUtils.registerListeners.33((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1157), new ProteusListenersUtils.registerListeners.34((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1038), new ProteusListenersUtils.registerListeners.35((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1040), new ProteusListenersUtils.registerListeners.36((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1039), new ProteusListenersUtils.registerListeners.37((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1043), new ProteusListenersUtils.registerListeners.38((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1103), new ProteusListenersUtils.registerListeners.39((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1104), new ProteusListenersUtils.registerListeners.40((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1106), new ProteusListenersUtils.registerListeners.41((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1112), new ProteusListenersUtils.registerListeners.42((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1111), new ProteusListenersUtils.registerListeners.43((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1110), new ProteusListenersUtils.registerListeners.44((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1109), new ProteusListenersUtils.registerListeners.45((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1108), new ProteusListenersUtils.registerListeners.46((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1107), new ProteusListenersUtils.registerListeners.47((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1113), new ProteusListenersUtils.registerListeners.48((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1120), new ProteusListenersUtils.registerListeners.49((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1115), new ProteusListenersUtils.registerListeners.50((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1114), new ProteusListenersUtils.registerListeners.51((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1116), new ProteusListenersUtils.registerListeners.52((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1117), new ProteusListenersUtils.registerListeners.53((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1118), new ProteusListenersUtils.registerListeners.54((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1119), new ProteusListenersUtils.registerListeners.55((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1044), new ProteusListenersUtils.registerListeners.56((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1044), new ProteusListenersUtils.registerListeners.57((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1045), new ProteusListenersUtils.registerListeners.58((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1046), new ProteusListenersUtils.registerListeners.59((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1047), new ProteusListenersUtils.registerListeners.60((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1065), new ProteusListenersUtils.registerListeners.61((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1066), new ProteusListenersUtils.registerListeners.62((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1067), new ProteusListenersUtils.registerListeners.63((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1156), new ProteusListenersUtils.registerListeners.64((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1085), new ProteusListenersUtils.registerListeners.65((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1099), new ProteusListenersUtils.registerListeners.66((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1100), new ProteusListenersUtils.registerListeners.67((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1101), new ProteusListenersUtils.registerListeners.68((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1102), new ProteusListenersUtils.registerListeners.69((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1098), new ProteusListenersUtils.registerListeners.70((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1179), new ProteusListenersUtils.registerListeners.71((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1180), new ProteusListenersUtils.registerListeners.72((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1041), new ProteusListenersUtils.registerListeners.73((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1195), new ProteusListenersUtils.registerListeners.74((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1197), new ProteusListenersUtils.registerListeners.75((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1196), new ProteusListenersUtils.registerListeners.76((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1199), new ProteusListenersUtils.registerListeners.77((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1200), new ProteusListenersUtils.registerListeners.78((ProteusListenersUtils)this));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1201), new ProteusListenersUtils.registerListeners.79((ProteusListenersUtils)this));
  }
  
  public final void A(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    paramProteusItemView = ReadInJoyLogicEngine.a();
    Intrinsics.checkExpressionValueIsNotNull(paramProteusItemView, "ReadInJoyLogicEngine.getInstance()");
    paramProteusItemView = paramProteusItemView.a();
    if ((paramProteusItemView != null) && (paramBaseArticleInfo != null) && (paramContainer != null))
    {
      paramBaseArticleInfo.isShowFreeNetFlow = false;
      ReadInJoyUtils.a(a(paramVafContext), paramProteusItemView.a());
      ReadInJoyDisplayUtils.a(false, paramContainer.getVirtualView(), null);
      FreeNetFlowInfoModule.a("0X8009661");
    }
  }
  
  public final void B(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnJumpChannelListener((ArticleInfo)paramBaseArticleInfo, a(paramVafContext), paramInt).onClick(paramViewBase);
  }
  
  public final void C(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    paramIFaceDecoder = (ArticleInfo)paramBaseArticleInfo;
    paramVafContext = a(paramVafContext);
    if (paramViewBase != null) {}
    for (paramProteusItemView = paramViewBase.getEventAttachedData();; paramProteusItemView = null)
    {
      new OnTopicDeliverClickListener(paramIFaceDecoder, paramVafContext, paramInt, paramProteusItemView).onClick(paramViewBase);
      return;
    }
  }
  
  public final void D(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer) {}
  
  public final void E(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnShareClickListener((ArticleInfo)paramBaseArticleInfo, a(paramVafContext)).onClick(paramViewBase);
  }
  
  public final void F(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnPivacyClickListener(a(paramVafContext), (ArticleInfo)paramBaseArticleInfo).onClick(paramViewBase);
  }
  
  public final void G(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if ((!(paramBaseArticleInfo instanceof ArticleInfo)) || (paramBaseArticleInfo.mProteusTemplateBean == null)) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "click exception, return ");
    }
    while (paramReadInJoyBaseAdapter == null) {
      return;
    }
    label105:
    int i;
    if ((paramReadInJoyBaseAdapter.a() == 0) || (DailyModeConfigHandler.c(paramReadInJoyBaseAdapter.a())))
    {
      paramIReadInJoyModel = ReadinjoySPEventReport.a().a;
      if (paramContainer != null)
      {
        paramIFaceDecoder = paramContainer.getRootView();
        paramIReadInJoyModel.a(paramIFaceDecoder, (AbsListView)paramReadInJoyBaseAdapter.a(), paramBaseArticleInfo);
        paramIReadInJoyModel = UserActionCollector.a();
        if (paramContainer == null) {
          break label408;
        }
        paramIFaceDecoder = paramContainer.getRootView();
        paramIReadInJoyModel.a(paramIFaceDecoder, (AbsListView)paramReadInJoyBaseAdapter.a(), paramBaseArticleInfo);
      }
    }
    else
    {
      if (DailyModeConfigHandler.c(paramReadInJoyBaseAdapter.a()))
      {
        if (!RIJFeedsType.a(paramBaseArticleInfo)) {
          break label414;
        }
        i = 4;
        label144:
        KandianDailyReportUtils.a(i);
        QLog.d(jdField_a_of_type_JavaLangString, 2, "click daily card , update operationFlag : " + i);
      }
      paramIFaceDecoder = paramBaseArticleInfo.mProteusTemplateBean;
      Intrinsics.checkExpressionValueIsNotNull(paramIFaceDecoder, "articleInfo.mProteusTemplateBean");
      paramIReadInJoyModel = paramIFaceDecoder.getStyleName();
      paramContainer = ProteusSupportUtil.a(null, paramInt, paramBaseArticleInfo);
      if (paramContainer != null)
      {
        if (paramViewBase == null) {
          break label420;
        }
        paramIFaceDecoder = paramViewBase.getName();
        label225:
        ProteusSupportUtil.a(paramContainer.findViewById(paramIFaceDecoder));
      }
      if (paramProteusItemView != null) {
        EventCollector.getInstance().onViewClicked((View)paramProteusItemView);
      }
      if (UGRuleManager.c(paramBaseArticleInfo)) {
        break label559;
      }
    }
    label408:
    label414:
    label420:
    label559:
    for (boolean bool = ReadInJoySrtUtils.a().a(paramBaseArticleInfo, paramContainer, paramViewBase);; bool = false)
    {
      ProteusSupportUtil.a(paramBaseArticleInfo, paramContainer, paramViewBase);
      ReadInJoyLogicEngine.a().a(paramBaseArticleInfo.mArticleID, System.currentTimeMillis());
      paramBaseArticleInfo.invalidateProteusTemplateBean();
      paramReadInJoyBaseAdapter.notifyDataSetChanged();
      ProteusSupportUtil.a(paramBaseArticleInfo, paramViewBase, paramContainer);
      paramProteusItemView = ProteusSupportUtil.a(paramBaseArticleInfo);
      paramIFaceDecoder = ReadInJoySrtUtils.a();
      Intrinsics.checkExpressionValueIsNotNull(paramIFaceDecoder, "ReadInJoySrtUtils.getInstance()");
      paramIFaceDecoder = paramIFaceDecoder.a();
      if (!TextUtils.isEmpty((CharSequence)paramProteusItemView))
      {
        if (UGRuleManager.a(paramProteusItemView)) {
          RIJJumpUtils.a(a(paramVafContext), paramBaseArticleInfo, paramProteusItemView);
        }
        for (;;)
        {
          QLog.d(jdField_a_of_type_JavaLangString, 1, "UGRuleManager articleInfo hit ug title" + ((ArticleInfo)paramBaseArticleInfo).mTitle);
          return;
          paramIFaceDecoder = null;
          break;
          paramIFaceDecoder = null;
          break label105;
          i = 2;
          break label144;
          paramIFaceDecoder = null;
          break label225;
          VideoFeedsHelper.a(a(paramVafContext), paramProteusItemView);
        }
      }
      if ((!UGRuleManager.c(paramBaseArticleInfo)) && (bool) && (!TextUtils.isEmpty((CharSequence)paramIFaceDecoder)))
      {
        RIJJumpUtils.a(a(paramVafContext), paramBaseArticleInfo, paramIFaceDecoder);
        return;
      }
      if ((!UGRuleManager.c(paramBaseArticleInfo)) && (!ReadInJoySrtUtils.a().a()) && (RIJTransMergeKanDianReport.a(a(paramVafContext), paramBaseArticleInfo, paramIReadInJoyModel)))
      {
        RIJJumpUtils.a(a(paramVafContext), paramBaseArticleInfo, RIJJumpUtils.b(((ArticleInfo)paramBaseArticleInfo).getInnerUniqueID()));
        return;
      }
      paramVafContext = a(paramVafContext);
      if (paramViewBase != null) {}
      for (paramProteusItemView = paramViewBase.getEventAttachedData();; paramProteusItemView = null)
      {
        RIJJumpUtils.a(paramVafContext, paramBaseArticleInfo, paramProteusItemView);
        return;
      }
    }
  }
  
  public final void H(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (((paramBaseArticleInfo instanceof AdvertisementInfo)) && (paramIReadInJoyModel != null))
    {
      if (paramContainer != null) {}
      for (paramProteusItemView = paramContainer.getVirtualView();; paramProteusItemView = null)
      {
        paramVafContext = a(paramVafContext);
        if (paramVafContext != null) {
          break;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
      }
      ReadinJoyActionUtil.a(paramProteusItemView, paramViewBase, (Activity)paramVafContext, (ArticleInfo)paramBaseArticleInfo, paramIReadInJoyModel.a(), a(paramIReadInJoyModel), 5);
    }
  }
  
  public final void I(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramIReadInJoyModel != null)
    {
      if (paramContainer != null) {}
      for (paramProteusItemView = paramContainer.getVirtualView();; paramProteusItemView = null)
      {
        paramVafContext = jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonProteusListenersUtils.a(paramVafContext);
        if (paramVafContext != null) {
          break;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
      }
      ReadinJoyActionUtil.a(paramProteusItemView, paramViewBase, (Activity)paramVafContext, (ArticleInfo)paramBaseArticleInfo, paramIReadInJoyModel.a(), jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonProteusListenersUtils.a(paramIReadInJoyModel), 5);
    }
  }
  
  public final void J(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramIReadInJoyModel != null)
    {
      if (paramContainer != null) {}
      for (paramProteusItemView = paramContainer.getVirtualView();; paramProteusItemView = null)
      {
        paramVafContext = jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonProteusListenersUtils.a(paramVafContext);
        if (paramVafContext != null) {
          break;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
      }
      ReadinJoyActionUtil.a(paramProteusItemView, paramViewBase, (Activity)paramVafContext, (ArticleInfo)paramBaseArticleInfo, paramIReadInJoyModel.a(), jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonProteusListenersUtils.a(paramIReadInJoyModel), 8);
    }
  }
  
  public final void K(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramIReadInJoyModel != null)
    {
      if (paramViewBase != null)
      {
        paramProteusItemView = paramViewBase.getClickEvnet();
        paramInt = StringCommon.getStrIdFromString(paramProteusItemView);
        if (paramContainer == null) {
          break label60;
        }
      }
      label60:
      for (paramProteusItemView = paramContainer.getVirtualView();; paramProteusItemView = null)
      {
        paramVafContext = jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonProteusListenersUtils.a(paramVafContext);
        if (paramVafContext != null) {
          break label65;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
        paramProteusItemView = null;
        break;
      }
      label65:
      ReadinJoyActionUtil.a(paramProteusItemView, paramViewBase, (Activity)paramVafContext, (ArticleInfo)paramBaseArticleInfo, paramIReadInJoyModel.a(), jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonProteusListenersUtils.a(paramIReadInJoyModel), AdClickPosUtil.a(paramInt));
    }
  }
  
  public final void L(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramIReadInJoyModel != null) {
      if (paramViewBase == null) {
        break label58;
      }
    }
    label58:
    for (paramProteusItemView = paramViewBase.getClickEvnet();; paramProteusItemView = null)
    {
      paramInt = StringCommon.getStrIdFromString(paramProteusItemView);
      new OnSmallGameCardClickListener(paramIReadInJoyModel, jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonProteusListenersUtils.a(paramVafContext), paramInt, paramIReadInJoyModel.e(), paramIReadInJoyModel.g()).onClick(paramViewBase);
      return;
    }
  }
  
  public final void M(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (((paramBaseArticleInfo instanceof AdvertisementInfo)) && (paramIReadInJoyModel != null))
    {
      VideoAdClickRecorder.a((AdvertisementInfo)paramBaseArticleInfo);
      if (paramContainer != null) {}
      for (paramProteusItemView = paramContainer.getVirtualView();; paramProteusItemView = null)
      {
        paramVafContext = a(paramVafContext);
        if (paramVafContext != null) {
          break;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
      }
      ReadinJoyActionUtil.a(paramProteusItemView, paramViewBase, (Activity)paramVafContext, (ArticleInfo)paramBaseArticleInfo, paramIReadInJoyModel.a(), a(paramIReadInJoyModel), 6);
    }
  }
  
  public final void N(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if ((ReadinJoyActionUtil.a((ArticleInfo)paramBaseArticleInfo)) && (paramIReadInJoyModel != null)) {
      ReadinJoyActionUtil.a(a(paramVafContext), (AdvertisementInfo)paramBaseArticleInfo, paramIReadInJoyModel.a(), a(paramIReadInJoyModel), false);
    }
  }
  
  public final void O(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnGalleryCommentClickListener((ArticleInfo)paramBaseArticleInfo, a(paramVafContext)).onClick(paramViewBase);
  }
  
  public final void P(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramBaseArticleInfo != null) {
      RIJMedalUtils.a(a(paramVafContext), paramBaseArticleInfo);
    }
  }
  
  public final void Q(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer) {}
  
  public final void R(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    AwesomeCommentInfo.a(paramBaseArticleInfo, "0X8009B77");
    paramVafContext = a(paramVafContext);
    if (paramBaseArticleInfo != null) {}
    for (paramProteusItemView = paramBaseArticleInfo.jumpUrl;; paramProteusItemView = null)
    {
      RIJJumpUtils.a(paramVafContext, paramBaseArticleInfo, paramProteusItemView);
      return;
    }
  }
  
  public final void S(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    paramIFaceDecoder = null;
    if (paramBaseArticleInfo != null)
    {
      paramVafContext = a(paramVafContext);
      if (paramViewBase == null) {
        break label80;
      }
    }
    label80:
    for (paramProteusItemView = paramViewBase.getEventAttachedData();; paramProteusItemView = null)
    {
      RIJJumpUtils.a(paramVafContext, paramBaseArticleInfo, paramProteusItemView);
      paramVafContext = jdField_a_of_type_JavaLangString;
      paramReadInJoyBaseAdapter = new StringBuilder().append("familyJumpUrl ");
      paramProteusItemView = paramIFaceDecoder;
      if (paramViewBase != null) {
        paramProteusItemView = paramViewBase.getEventAttachedData();
      }
      QLog.d(paramVafContext, 2, paramProteusItemView);
      return;
    }
  }
  
  public final void T(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnAdLocationClickListener(paramBaseArticleInfo, a(paramVafContext)).onClick(paramViewBase);
  }
  
  public final void U(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramIReadInJoyModel != null)
    {
      if (paramContainer != null) {}
      for (paramProteusItemView = paramContainer.getVirtualView();; paramProteusItemView = null)
      {
        paramVafContext = jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonProteusListenersUtils.a(paramVafContext);
        if (paramVafContext != null) {
          break;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
      }
      ReadinJoyActionUtil.a(paramProteusItemView, paramViewBase, (Activity)paramVafContext, (ArticleInfo)paramBaseArticleInfo, paramIReadInJoyModel.a(), jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonProteusListenersUtils.a(paramIReadInJoyModel), 4);
    }
  }
  
  public final void V(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramIReadInJoyModel != null)
    {
      if (paramContainer != null) {}
      for (paramProteusItemView = paramContainer.getVirtualView();; paramProteusItemView = null)
      {
        paramVafContext = jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonProteusListenersUtils.a(paramVafContext);
        if (paramVafContext != null) {
          break;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
      }
      ReadinJoyActionUtil.a(paramProteusItemView, paramViewBase, (Activity)paramVafContext, (ArticleInfo)paramBaseArticleInfo, paramIReadInJoyModel.a(), jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonProteusListenersUtils.a(paramIReadInJoyModel), 1);
    }
  }
  
  public final void W(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramIReadInJoyModel != null)
    {
      if (paramContainer != null) {}
      for (paramProteusItemView = paramContainer.getVirtualView();; paramProteusItemView = null)
      {
        paramVafContext = jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonProteusListenersUtils.a(paramVafContext);
        if (paramVafContext != null) {
          break;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
      }
      ReadinJoyActionUtil.a(paramProteusItemView, paramViewBase, (Activity)paramVafContext, (ArticleInfo)paramBaseArticleInfo, paramIReadInJoyModel.a(), jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonProteusListenersUtils.a(paramIReadInJoyModel), 9);
    }
  }
  
  public final void X(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramIReadInJoyModel != null)
    {
      if (paramContainer != null) {}
      for (paramProteusItemView = paramContainer.getVirtualView();; paramProteusItemView = null)
      {
        paramVafContext = jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonProteusListenersUtils.a(paramVafContext);
        if (paramVafContext != null) {
          break;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
      }
      ReadinJoyActionUtil.a(paramProteusItemView, paramViewBase, (Activity)paramVafContext, (ArticleInfo)paramBaseArticleInfo, paramIReadInJoyModel.a(), jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonProteusListenersUtils.a(paramIReadInJoyModel), 28);
    }
  }
  
  public final void Y(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramIReadInJoyModel != null)
    {
      if (paramContainer != null) {}
      for (paramProteusItemView = paramContainer.getVirtualView();; paramProteusItemView = null)
      {
        paramVafContext = jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonProteusListenersUtils.a(paramVafContext);
        if (paramVafContext != null) {
          break;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
      }
      ReadinJoyActionUtil.a(paramProteusItemView, paramViewBase, (Activity)paramVafContext, (ArticleInfo)paramBaseArticleInfo, paramIReadInJoyModel.a(), jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonProteusListenersUtils.a(paramIReadInJoyModel), 2);
    }
  }
  
  public final void Z(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramIReadInJoyModel != null)
    {
      if (paramContainer != null) {}
      for (paramProteusItemView = paramContainer.getVirtualView();; paramProteusItemView = null)
      {
        paramVafContext = jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonProteusListenersUtils.a(paramVafContext);
        if (paramVafContext != null) {
          break;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
      }
      ReadinJoyActionUtil.a(paramProteusItemView, paramViewBase, (Activity)paramVafContext, (ArticleInfo)paramBaseArticleInfo, paramIReadInJoyModel.a(), jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonProteusListenersUtils.a(paramIReadInJoyModel), 3);
    }
  }
  
  @Nullable
  public final Context a(@Nullable VafContext paramVafContext)
  {
    Context localContext = (Context)null;
    if (paramVafContext != null) {
      localContext = paramVafContext.getContext();
    }
    paramVafContext = localContext;
    if (localContext == null) {
      paramVafContext = (Context)BaseApplication.getContext();
    }
    return paramVafContext;
  }
  
  public final void a(int paramInt1, int paramInt2, @NotNull ProteusItemView paramProteusItemView, @NotNull VafContext paramVafContext, @NotNull IFaceDecoder paramIFaceDecoder, @NotNull ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @NotNull IReadInJoyModel paramIReadInJoyModel, @NotNull BaseArticleInfo paramBaseArticleInfo, @NotNull ViewBase paramViewBase, @NotNull Container paramContainer)
  {
    Intrinsics.checkParameterIsNotNull(paramProteusItemView, "view");
    Intrinsics.checkParameterIsNotNull(paramVafContext, "context");
    Intrinsics.checkParameterIsNotNull(paramIFaceDecoder, "face");
    Intrinsics.checkParameterIsNotNull(paramReadInJoyBaseAdapter, "ad");
    Intrinsics.checkParameterIsNotNull(paramIReadInJoyModel, "iModel");
    Intrinsics.checkParameterIsNotNull(paramBaseArticleInfo, "info");
    Intrinsics.checkParameterIsNotNull(paramViewBase, "base");
    Intrinsics.checkParameterIsNotNull(paramContainer, "con");
    Function9 localFunction9 = (Function9)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1));
    if ((localFunction9 != null) && ((Unit)localFunction9.invoke(Integer.valueOf(paramInt2), paramProteusItemView, paramVafContext, paramIFaceDecoder, paramReadInJoyBaseAdapter, paramIReadInJoyModel, paramBaseArticleInfo, paramViewBase, paramContainer) != null)) {
      return;
    }
    af(paramInt2, paramProteusItemView, paramVafContext, paramIFaceDecoder, paramReadInJoyBaseAdapter, paramIReadInJoyModel, paramBaseArticleInfo, paramViewBase, paramContainer);
    paramProteusItemView = Unit.INSTANCE;
  }
  
  public final void a(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if ((paramContainer == null) || (paramReadInJoyBaseAdapter == null) || (paramIReadInJoyModel == null)) {}
    do
    {
      return;
      paramProteusItemView = a(paramVafContext);
      if ((paramProteusItemView != null) && (paramViewBase != null))
      {
        paramProteusItemView = new FeedItemCellTypeProteus(paramProteusItemView, paramIFaceDecoder, paramReadInJoyBaseAdapter);
        paramProteusItemView.a(paramIReadInJoyModel);
        paramProteusItemView.a((View)paramContainer);
        paramProteusItemView.a(paramViewBase.getNativeView());
      }
    } while ((paramBaseArticleInfo == null) || ((paramBaseArticleInfo instanceof AdvertisementInfo)));
    VideoReport.reportEvent("clck", RIJDtParamBuilder.a(new RIJDtParamBuilder().f("feedback_button").e(paramBaseArticleInfo.innerUniqueID).b((Number)Integer.valueOf(paramBaseArticleInfo.dtReportContentType)).c("click_feedback"), null, 1, null).b("list").g(paramBaseArticleInfo.dtReportBackendInfo).a("14").a((Number)Long.valueOf(paramBaseArticleInfo.mChannelID)).a());
  }
  
  public final void aa(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramIReadInJoyModel != null)
    {
      if (paramContainer != null) {}
      for (paramProteusItemView = paramContainer.getVirtualView();; paramProteusItemView = null)
      {
        paramVafContext = jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonProteusListenersUtils.a(paramVafContext);
        if (paramVafContext != null) {
          break;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
      }
      ReadinJoyActionUtil.a(paramProteusItemView, paramViewBase, (Activity)paramVafContext, (ArticleInfo)paramBaseArticleInfo, paramIReadInJoyModel.a(), jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonProteusListenersUtils.a(paramIReadInJoyModel), 29);
    }
  }
  
  public final void ab(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramIReadInJoyModel != null)
    {
      if (paramContainer != null) {}
      for (paramProteusItemView = paramContainer.getVirtualView();; paramProteusItemView = null)
      {
        paramVafContext = jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonProteusListenersUtils.a(paramVafContext);
        if (paramVafContext != null) {
          break;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
      }
      ReadinJoyActionUtil.a(paramProteusItemView, paramViewBase, (Activity)paramVafContext, (ArticleInfo)paramBaseArticleInfo, paramIReadInJoyModel.a(), jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonProteusListenersUtils.a(paramIReadInJoyModel), 3);
    }
  }
  
  public final void ac(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramIReadInJoyModel != null)
    {
      if (paramContainer != null) {}
      for (paramProteusItemView = paramContainer.getVirtualView();; paramProteusItemView = null)
      {
        paramVafContext = jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonProteusListenersUtils.a(paramVafContext);
        if (paramVafContext != null) {
          break;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
      }
      ReadinJoyActionUtil.a(paramProteusItemView, paramViewBase, (Activity)paramVafContext, (ArticleInfo)paramBaseArticleInfo, paramIReadInJoyModel.a(), jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonProteusListenersUtils.a(paramIReadInJoyModel), 1000);
    }
  }
  
  public final void ad(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    paramReadInJoyBaseAdapter = null;
    if ((!(paramBaseArticleInfo instanceof ArticleInfo)) || (paramBaseArticleInfo.mProteusTemplateBean == null))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "STR_ID_CMD_PARTNER_HEADER_CLICK,click exception, return");
      return;
    }
    paramIReadInJoyModel = ProteusSupportUtil.a(null, paramInt, paramBaseArticleInfo);
    if (paramIReadInJoyModel != null) {
      if (paramViewBase == null) {
        break label160;
      }
    }
    label160:
    for (paramIFaceDecoder = paramViewBase.getName();; paramIFaceDecoder = null)
    {
      ProteusSupportUtil.a(paramIReadInJoyModel.findViewById(paramIFaceDecoder));
      if (paramProteusItemView != null) {
        EventCollector.getInstance().onViewClicked((View)paramProteusItemView);
      }
      ProteusSupportUtil.a(paramBaseArticleInfo, paramIReadInJoyModel, paramViewBase);
      OnSocialAvatarClickListener.a((ArticleInfo)paramBaseArticleInfo, paramInt);
      paramVafContext = a(paramVafContext);
      paramProteusItemView = paramReadInJoyBaseAdapter;
      if (paramViewBase != null) {
        paramProteusItemView = paramViewBase.getEventAttachedData();
      }
      RIJJumpUtils.a(paramVafContext, paramProteusItemView);
      if (paramBaseArticleInfo.mChannelID != 0L) {
        break;
      }
      RIJFeedsDynamicInsertController.a.a(paramBaseArticleInfo.innerUniqueID, new RIJFeedsInsertAction(RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_ENTER, 0, 0, 0), 1);
      return;
    }
  }
  
  public final void ae(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramIReadInJoyModel != null)
    {
      paramProteusItemView = paramIReadInJoyModel.a();
      Intrinsics.checkExpressionValueIsNotNull(paramProteusItemView, "it.adapter");
      RIJJumpUtils.b(paramProteusItemView.a(), paramIReadInJoyModel.a());
      paramProteusItemView = paramIReadInJoyModel.a();
      Intrinsics.checkExpressionValueIsNotNull(paramProteusItemView, "it.adapter");
      RIJJumpUtils.a((Context)paramProteusItemView.a(), paramIReadInJoyModel.a(), paramIReadInJoyModel.a(), paramIReadInJoyModel.e());
      QLog.d(jdField_a_of_type_JavaLangString, 1, "clickCommentBiuCardWrapper exception, model is null!");
    }
  }
  
  public final void af(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    paramIFaceDecoder = null;
    if ((paramContainer == null) || (paramReadInJoyBaseAdapter == null) || (paramIReadInJoyModel == null)) {
      return;
    }
    if (paramViewBase != null)
    {
      paramProteusItemView = paramViewBase.getClickEvnet();
      StringCommon.getStrIdFromString(paramProteusItemView);
      paramReadInJoyBaseAdapter = ProteusSupportUtil.a(null, paramInt, paramBaseArticleInfo);
      if (paramReadInJoyBaseAdapter != null) {
        if (paramViewBase == null) {
          break label111;
        }
      }
    }
    label111:
    for (paramProteusItemView = paramViewBase.getName();; paramProteusItemView = null)
    {
      paramProteusItemView = paramReadInJoyBaseAdapter.findViewById(paramProteusItemView);
      ProteusSupportUtil.a(paramReadInJoyBaseAdapter, paramViewBase);
      ProteusSupportUtil.a(paramProteusItemView);
      paramVafContext = a(paramVafContext);
      paramProteusItemView = paramIFaceDecoder;
      if (paramViewBase != null) {
        paramProteusItemView = paramViewBase.getEventAttachedData();
      }
      RIJJumpUtils.a(paramVafContext, paramBaseArticleInfo, paramProteusItemView);
      return;
      paramProteusItemView = null;
      break;
    }
  }
  
  public final void ag(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnWeChatVideoWatchLaterClickListener(paramBaseArticleInfo).onClick(paramViewBase);
  }
  
  public final void b(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if ((paramContainer == null) || (paramReadInJoyBaseAdapter == null) || (paramIReadInJoyModel == null)) {
      return;
    }
    paramProteusItemView = a(paramVafContext);
    paramVafContext = (ArticleInfo)null;
    if ((paramProteusItemView != null) && (paramViewBase != null))
    {
      paramIFaceDecoder = new FeedItemCellTypeProteus(paramProteusItemView, paramIFaceDecoder, paramReadInJoyBaseAdapter);
      paramProteusItemView = paramIReadInJoyModel.a();
      if (paramProteusItemView != null)
      {
        paramProteusItemView = paramProteusItemView.mSubArtilceList;
        label67:
        if ((paramProteusItemView == null) || (paramProteusItemView.size() <= 0)) {
          break label322;
        }
        paramProteusItemView = (ArticleInfo)paramProteusItemView.get(0);
        paramIFaceDecoder.a(new ReadInJoyModelImpl((Context)paramReadInJoyBaseAdapter.a(), paramProteusItemView, paramIReadInJoyModel.a(), paramReadInJoyBaseAdapter.a(), paramReadInJoyBaseAdapter.b(), paramIReadInJoyModel.g(), paramReadInJoyBaseAdapter.b(), paramReadInJoyBaseAdapter.getCount(), paramIReadInJoyModel.b(), paramReadInJoyBaseAdapter));
        paramIFaceDecoder.a((ReadInJoyModelImpl)paramIReadInJoyModel);
        paramIFaceDecoder.a((View)paramContainer);
        paramIFaceDecoder.a(paramViewBase.getNativeView());
        label188:
        if ((paramBaseArticleInfo == null) || ((paramBaseArticleInfo instanceof AdvertisementInfo))) {
          break label335;
        }
        paramIFaceDecoder = new RIJDtParamBuilder().f("feedback_button");
        if (paramProteusItemView == null) {
          break label337;
        }
        paramVafContext = paramProteusItemView.innerUniqueID;
        label225:
        paramIFaceDecoder = paramIFaceDecoder.e(paramVafContext);
        if (paramProteusItemView == null) {
          break label342;
        }
        paramVafContext = (Number)Integer.valueOf(paramProteusItemView.dtReportContentType);
        label248:
        paramVafContext = RIJDtParamBuilder.a(paramIFaceDecoder.b(paramVafContext).c("click_feedback"), null, 1, null).b("list");
        if (paramProteusItemView == null) {
          break label353;
        }
      }
    }
    label322:
    label335:
    label337:
    label342:
    label353:
    for (paramProteusItemView = paramProteusItemView.dtReportBackendInfo;; paramProteusItemView = null)
    {
      VideoReport.reportEvent("clck", paramVafContext.g(paramProteusItemView).a("14").a((Number)Long.valueOf(paramBaseArticleInfo.mChannelID)).a());
      return;
      paramProteusItemView = null;
      break label67;
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[STR_ID_CMD_RIGHT_DISLIKE_CLICK_FUN], cmd_right_dislike_click failed, there is no sub article.");
      paramProteusItemView = paramVafContext;
      break label188;
      break;
      paramVafContext = null;
      break label225;
      paramVafContext = (Number)Integer.valueOf(0);
      break label248;
    }
  }
  
  public final void c(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo))
    {
      paramProteusItemView = a(paramVafContext);
      if (paramIReadInJoyModel != null)
      {
        if (paramBaseArticleInfo == null) {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo");
        }
        ReadinJoyActionUtil.a(paramProteusItemView, (AdvertisementInfo)paramBaseArticleInfo, paramIReadInJoyModel.a(), paramIReadInJoyModel.e(), false);
      }
    }
  }
  
  public final void d(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramBaseArticleInfo == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo");
    }
    new OnLikeClickListener((ArticleInfo)paramBaseArticleInfo, a(paramVafContext)).onClick(paramViewBase);
  }
  
  public final void e(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramContainer == null) {
      return;
    }
    if (paramBaseArticleInfo == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo");
    }
    new OnUserCommentClickListener((ArticleInfo)paramBaseArticleInfo, a(paramVafContext), paramReadInJoyBaseAdapter).onClick(paramViewBase);
  }
  
  public final void f(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramBaseArticleInfo == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo");
    }
    new OnUserCommentEditClickListener((ArticleInfo)paramBaseArticleInfo, paramVafContext).onClick(paramViewBase);
  }
  
  public final void g(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramBaseArticleInfo == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo");
    }
    new OnCommentClickListener((ArticleInfo)paramBaseArticleInfo, paramVafContext).onClick(paramViewBase);
  }
  
  public final void h(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramBaseArticleInfo == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo");
    }
    new OnBiuClickListener((ArticleInfo)paramBaseArticleInfo, a(paramVafContext)).onClick(paramViewBase);
  }
  
  public final void i(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramBaseArticleInfo == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo");
    }
    new OnTopicRecommendHeaderClickListener((ArticleInfo)paramBaseArticleInfo, a(paramVafContext)).onClick(paramViewBase);
  }
  
  public final void j(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramBaseArticleInfo != null)
    {
      paramProteusItemView = paramBaseArticleInfo.mNewPolymericInfo;
      if ((paramProteusItemView != null) && (paramContainer != null))
      {
        paramProteusItemView = paramBaseArticleInfo.mNewPolymericInfo;
        if (paramProteusItemView == null) {
          break label52;
        }
      }
    }
    label52:
    for (paramProteusItemView = paramProteusItemView.d;; paramProteusItemView = null)
    {
      RIJJumpUtils.a(paramContainer.getContext(), paramProteusItemView, null);
      return;
      paramProteusItemView = null;
      break;
    }
  }
  
  public final void k(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnTopicRecommendHeaderFollowClickListener((ArticleInfo)paramBaseArticleInfo, a(paramVafContext)).onClick(paramViewBase);
  }
  
  public final void l(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if ((paramBaseArticleInfo != null) && ((RIJFeedsType.c((ArticleInfo)paramBaseArticleInfo)) || (RIJFeedsType.d((ArticleInfo)paramBaseArticleInfo)))) {
      NativeSummaryView.a((ArticleInfo)paramBaseArticleInfo, jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonProteusListenersUtils.a(paramVafContext));
    }
  }
  
  public final void m(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramReadInJoyBaseAdapter == null) {
      return;
    }
    new OnArticleWrapperClickListener((ArticleInfo)paramBaseArticleInfo, paramReadInJoyBaseAdapter).onClick(paramViewBase);
  }
  
  public final void n(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnJumpWrapperClickListener(a(paramVafContext), (ArticleInfo)paramBaseArticleInfo).onClick(paramViewBase);
  }
  
  public final void o(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnSocialHeaderFollowClickListener((ArticleInfo)paramBaseArticleInfo, a(paramVafContext), paramInt).onClick(paramViewBase);
  }
  
  public final void p(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnTopicCapsuleClickListener((ArticleInfo)paramBaseArticleInfo, a(paramVafContext)).onClick(paramViewBase);
  }
  
  public final void q(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnSuperTopicClickListener((ArticleInfo)paramBaseArticleInfo, a(paramVafContext)).onClick(paramViewBase);
  }
  
  public final void r(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramReadInJoyBaseAdapter == null) {
      return;
    }
    new OnReadArticleClickListener((ArticleInfo)paramBaseArticleInfo, a(paramVafContext), paramReadInJoyBaseAdapter).onClick(paramViewBase);
  }
  
  public final void s(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnAnswerCapsuleClickListener((ArticleInfo)paramBaseArticleInfo, a(paramVafContext)).onClick(paramViewBase);
  }
  
  public final void t(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnSocialHeaderClickListener((ArticleInfo)paramBaseArticleInfo, a(paramVafContext)).onClick(paramViewBase);
  }
  
  public final void u(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramReadInJoyBaseAdapter == null) {
      return;
    }
    new OnSocialLikeCountClickListener((ArticleInfo)paramBaseArticleInfo, a(paramVafContext), paramReadInJoyBaseAdapter).onClick(paramViewBase);
  }
  
  public final void v(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    if (paramReadInJoyBaseAdapter == null) {
      return;
    }
    new OnSocialBiuCountClickListener((ArticleInfo)paramBaseArticleInfo, a(paramVafContext), paramReadInJoyBaseAdapter).onClick(paramViewBase);
  }
  
  public final void w(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnSocialAvatarClickListener((ArticleInfo)paramBaseArticleInfo, a(paramVafContext), paramInt).onClick(paramViewBase);
  }
  
  public final void x(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnMoreBiuClickListener((ArticleInfo)paramBaseArticleInfo, a(paramVafContext)).onClick(paramViewBase);
  }
  
  public final void y(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnFriendsBiuClickListener((ArticleInfo)paramBaseArticleInfo, a(paramVafContext), paramInt).onClick(paramViewBase);
  }
  
  public final void z(int paramInt, @Nullable ProteusItemView paramProteusItemView, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, @Nullable BaseArticleInfo paramBaseArticleInfo, @Nullable ViewBase paramViewBase, @Nullable Container paramContainer)
  {
    new OnAccountCardClickListener(paramBaseArticleInfo).onClick(paramViewBase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ProteusListenersUtils
 * JD-Core Version:    0.7.0.1
 */