package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import android.annotation.TargetApi;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.MQLruCache;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.VisibleForTesting;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.KandianUGStatisticUtils;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyDropFrameHelper;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentMixDataManager;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListAdapter;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentReportManager;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentTopGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentTopGestureLayout.IFirstLevelCommentContainer;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils.CommentListListener;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils.CommentReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoySecondCommentListFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SimpleCommentData;
import com.tencent.biz.pubaccount.readinjoy.common.ProteusSupportUtil;
import com.tencent.biz.pubaccount.readinjoy.common.RIJJsonUtils;
import com.tencent.biz.pubaccount.readinjoy.common.RIJSocialBottomUtils;
import com.tencent.biz.pubaccount.readinjoy.common.RIJSocialBottomUtils.Companion;
import com.tencent.biz.pubaccount.readinjoy.common.RIJXTabFrameUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.common.TimeSliceHelper;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAladdinUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJWebSearchUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtParamBuilder;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJProteusDtImpl;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertConfig;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertController;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertRecordAction.ActionType;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertAction;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule.FastWebContentGetCallback;
import com.tencent.biz.pubaccount.readinjoy.model.FollowListInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.FollowListInfoModule.FollowStatusObserver;
import com.tencent.biz.pubaccount.readinjoy.model.RIJLiveStatusModule;
import com.tencent.biz.pubaccount.readinjoy.model.RIJLiveStatusModule.LiveStatusCallback;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.biz.pubaccount.readinjoy.popup.RIJFollowRecommendPopupCommand;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeAvatarView;
import com.tencent.biz.pubaccount.readinjoy.proteus.wrap.ReadInjoyContext;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskArticleTimer;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskConfig;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.FeedsReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.FastWebMergeAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.FastWebMergeAdapter.OnDataSetChangeListener;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.WebFastAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AuthorData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusRecommendItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.TitleData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.FastWebAdapterShowHelper;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemHeightHelper;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher.AdPostionReportManager;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.BaseItemViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebActivityStackUtil;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebActivityStackUtil.SaveState;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebDislikeUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebPTSDataConverter;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebPTSUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebProteusReportUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRecommendUGInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebShareUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.HtmlChangeUtil;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ItemDatasListUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.JumpAdUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ScreenShotShareHelper;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.TimeUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.StyleConfigHelper;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.CommonAdBar;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.CommonAdFloatingBarUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate.GamesComponentAdDelegate;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate.IUIDelegate;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.RIJAdDownloadCache;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerBigPicItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdExposeFreshManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdReqFreshManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.FastWebVideoPlayManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.IADArticleDownloadListener;
import com.tencent.biz.pubaccount.util.ReadInJoyShareHelperV2;
import com.tencent.biz.pubaccount.util.ReadInJoyShareHelperV2.OnFontSizeChangeListener;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.biz.pubaccount.util.SneakyCallback;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.tuwen.adapter.TKDTuWenHippyCommentAdapter;
import com.tencent.hippy.qq.tuwen.adapter.TKDTuWenHippyCommentAdapter.Builder;
import com.tencent.hippy.qq.tuwen.util.TKDTuWenCommentUtil;
import com.tencent.hippy.qq.utils.tkd.TKDCommentDispatcher;
import com.tencent.hippy.qq.utils.tkd.TKDCommentDispatcher.HippyCommentEvent;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.miniaio.MiniMsgIPCServer;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.colornote.ColorNoteController;
import com.tencent.mobileqq.colornote.swipeback.SwipeLayoutUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.page.IScrollReader;
import com.tencent.util.URLUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.AbsListView.SavedState;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.EdgeEffect;
import com.tencent.widget.XListView.DrawFinishedListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class FastWebActivity
  extends FragmentActivity
  implements View.OnClickListener, ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener, ReadInJoyCommentTopGestureLayout.IFirstLevelCommentContainer, ReadInJoyCommentUtils.CommentListListener, IADArticleDownloadListener, ReadInJoyShareHelperV2.OnFontSizeChangeListener, MiniMsgUser.IMiniMsgActionCallback, DecodeTaskCompletionListener
{
  public static boolean a;
  public static boolean b;
  public static boolean c;
  private boolean A = false;
  private boolean B = false;
  private boolean C = true;
  private boolean D = true;
  private boolean E = false;
  private float jdField_a_of_type_Float = DeviceInfoUtil.e() * 500 / 160.0F;
  private int jdField_a_of_type_Int = 1;
  protected long a;
  private MessageQueue.IdleHandler jdField_a_of_type_AndroidOsMessageQueue$IdleHandler;
  SparseArray<Float> jdField_a_of_type_AndroidUtilSparseArray;
  private View jdField_a_of_type_AndroidViewView;
  private DecelerateInterpolator jdField_a_of_type_AndroidViewAnimationDecelerateInterpolator = new DecelerateInterpolator(this.jdField_c_of_type_Float);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RIJBiuAndCommentMixDataManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixDataManager;
  private ReadInJoyCommentListAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter;
  private ReadInJoyCommentListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView;
  private ReadInJoyCommentTopGestureLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout;
  private ReadInJoySecondCommentListFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment;
  private AnchorData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData;
  private TimeSliceHelper jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper = new TimeSliceHelper();
  private ReadInJoyObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new FastWebActivity.25(this);
  private FastWebModule.FastWebContentGetCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFastWebModule$FastWebContentGetCallback = new FastWebActivity.34(this);
  FollowListInfoModule.FollowStatusObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowListInfoModule$FollowStatusObserver = new FastWebActivity.41(this);
  private RIJLiveStatusModule.LiveStatusCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJLiveStatusModule$LiveStatusCallback = new FastWebActivity.9(this);
  private RIJLiveStatusModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJLiveStatusModule;
  private ReadInJoyUserInfoModule.RefreshUserInfoCallBack jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule$RefreshUserInfoCallBack = new FastWebActivity.10(this);
  private NativeAvatarView jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeAvatarView;
  private RIJRewardTaskArticleTimer jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskArticleTimer = new RIJRewardTaskArticleTimer();
  public ArticleInfo a;
  private ReadInJoyFastWebBottomSocialViewNew jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew;
  private FastWebActivity.ArticleRichInfoCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$ArticleRichInfoCallback = new FastWebActivity.ArticleRichInfoCallback(this, null);
  private FastWebActivity.RecommendAndAdCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$RecommendAndAdCallback;
  FastWebMergeAdapter.OnDataSetChangeListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterFastWebMergeAdapter$OnDataSetChangeListener = new FastWebActivity.39(this);
  private FastWebMergeAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterFastWebMergeAdapter;
  private WebFastAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterWebFastAdapter;
  private AuthorData jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData;
  private TitleData jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData;
  private FastWebAdapterShowHelper jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventFastWebAdapterShowHelper;
  private ItemHeightHelper jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemHeightHelper;
  private ItemShowDispatcher jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher = new ItemShowDispatcher();
  private FastWebActivityStackUtil.SaveState jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebActivityStackUtil$SaveState;
  private FastWebActivityStackUtil jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebActivityStackUtil = new FastWebActivityStackUtil(this);
  private FastWebArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
  private FastWebShareUtils jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebShareUtils = new FastWebShareUtils();
  private ScreenShotShareHelper jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  private CommonSuspensionGestureLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout;
  private CommonAdBar jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar;
  private ReadInJoyShareHelperV2 jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2;
  private Share jdField_a_of_type_ComTencentBizWebviewpluginShare;
  private TKDTuWenHippyCommentAdapter jdField_a_of_type_ComTencentHippyQqTuwenAdapterTKDTuWenHippyCommentAdapter;
  public MiniMsgUser a;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private ColorNoteController jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController;
  public INetInfoHandler a;
  private IScrollReader jdField_a_of_type_ComTencentQqliveModuleVideoreportPageIScrollReader;
  AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new FastWebActivity.24(this);
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  private XListView.DrawFinishedListener jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener = new FastWebActivity.30(this);
  Runnable jdField_a_of_type_JavaLangRunnable = new FastWebActivity.42(this);
  protected String a;
  private HashMap<String, ArrayList<String>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<BaseData> jdField_a_of_type_JavaUtilList;
  Set<BaseData> jdField_a_of_type_JavaUtilSet = new HashSet();
  private float jdField_b_of_type_Float = DeviceInfoUtil.e() * 1000 / 160.0F;
  private int jdField_b_of_type_Int = 0;
  protected long b;
  private MessageQueue.IdleHandler jdField_b_of_type_AndroidOsMessageQueue$IdleHandler = new FastWebActivity.37(this);
  private SparseArray<View> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray(1);
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ReadInJoyObserver jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new FastWebActivity.26(this);
  private String jdField_b_of_type_JavaLangString = System.currentTimeMillis() + "";
  private float jdField_c_of_type_Float = 1.5F;
  private int jdField_c_of_type_Int = -1;
  long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString = "";
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString = "";
  boolean jdField_d_of_type_Boolean = true;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long = 0L;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  public boolean e;
  private int jdField_f_of_type_Int = 0;
  private long jdField_f_of_type_Long;
  public boolean f;
  private int jdField_g_of_type_Int = 0;
  private long jdField_g_of_type_Long = 0L;
  private boolean jdField_g_of_type_Boolean = true;
  private int jdField_h_of_type_Int = 0;
  private boolean jdField_h_of_type_Boolean = false;
  private int jdField_i_of_type_Int = 0;
  private boolean jdField_i_of_type_Boolean = false;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean = false;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean = false;
  private int jdField_l_of_type_Int = 1000;
  private boolean jdField_l_of_type_Boolean = false;
  private int jdField_m_of_type_Int = 2;
  private boolean jdField_m_of_type_Boolean = false;
  private int jdField_n_of_type_Int = 0;
  private boolean jdField_n_of_type_Boolean = false;
  private int jdField_o_of_type_Int = 0;
  private boolean jdField_o_of_type_Boolean = false;
  private int jdField_p_of_type_Int = 0;
  private boolean jdField_p_of_type_Boolean = false;
  private int jdField_q_of_type_Int = 0;
  private boolean jdField_q_of_type_Boolean = false;
  private int jdField_r_of_type_Int = 0;
  private boolean jdField_r_of_type_Boolean = false;
  private int jdField_s_of_type_Int = 0;
  private boolean jdField_s_of_type_Boolean = false;
  private int jdField_t_of_type_Int = 0;
  private boolean jdField_t_of_type_Boolean = false;
  private int jdField_u_of_type_Int = 1;
  private boolean jdField_u_of_type_Boolean = false;
  private int jdField_v_of_type_Int;
  private boolean jdField_v_of_type_Boolean = true;
  private int jdField_w_of_type_Int = 0;
  private boolean jdField_w_of_type_Boolean = false;
  private int jdField_x_of_type_Int = -1;
  private boolean jdField_x_of_type_Boolean = false;
  private int jdField_y_of_type_Int = 0;
  private boolean jdField_y_of_type_Boolean = false;
  private int jdField_z_of_type_Int = 0;
  private boolean jdField_z_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    jdField_c_of_type_Boolean = false;
  }
  
  public FastWebActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new FastWebActivity.36(this);
  }
  
  private void A()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterFastWebMergeAdapter == null) {
      return;
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterFastWebMergeAdapter.notifyDataSetChanged();
      return;
    }
    runOnUiThread(new FastWebActivity.11(this));
  }
  
  private void B()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData = ((AnchorData)getIntent().getExtras().get("intent_key_anchor_data"));
    if (!a(1)) {
      a(1);
    }
    C();
  }
  
  private void C()
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("arg_comment_list_biu_btn", false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment = new ReadInJoySecondCommentListFragment();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(this, (Bundle)localObject, new FastWebActivity.14(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(new FastWebActivity.15(this));
    localObject = getSupportFragmentManager().beginTransaction();
    ((FragmentTransaction)localObject).add(2131377654, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
    ((FragmentTransaction)localObject).hide(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
    ((FragmentTransaction)localObject).commitAllowingStateLoss();
  }
  
  private void D()
  {
    FastWebModule localFastWebModule = ReadInJoyLogicEngine.a().a();
    if (localFastWebModule == null)
    {
      if (!this.jdField_n_of_type_Boolean) {
        E();
      }
      QLog.d("FastWebActivity", 2, "fastWebModule == null");
      return;
    }
    localFastWebModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID, 1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFastWebModule$FastWebContentGetCallback);
  }
  
  private void E()
  {
    z();
    QLog.d("FastWebActivity", 1, "openWeb  mArticleInfo: " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    this.jdField_o_of_type_Boolean = true;
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    getMainLooper();
    Looper.myQueue().addIdleHandler(new FastWebActivity.16(this));
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8009C50", "0X8009C50", 0, 0, "", Long.toString(this.jdField_a_of_type_Long), Integer.toString(this.jdField_k_of_type_Int), "", false);
  }
  
  private void F()
  {
    if (this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler != null)
    {
      getMainLooper();
      Looper.myQueue().removeIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
    }
    this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new FastWebActivity.17(this);
    getMainLooper();
    Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
  }
  
  private void G()
  {
    View localView = findViewById(2131374174);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setEmptyView(localView);
    localView.setOnClickListener(null);
  }
  
  private void H()
  {
    ((ClipboardManager)getSystemService("clipboard")).setText(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
    QRUtils.a(2, 2131691374);
    if (this.jdField_s_of_type_Boolean) {}
    for (String str = "0X8008994";; str = "0X800898D")
    {
      FastWebShareUtils.a(this, str, 9, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      ReportUtil.a(this, getAppInterface(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, -1, 3, false);
      return;
    }
  }
  
  private void I()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
    ReportUtil.a(this, getAppInterface(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 6, -1, false);
  }
  
  private void J()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
    ReportUtil.a(this, getAppInterface(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 7, -1, false);
  }
  
  private void K()
  {
    a(17, -1, false);
    ReportUtil.a(this, getAppInterface(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 0, -1, false);
  }
  
  private void L()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.setFavoriteArticle(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo);
    }
    if (this.jdField_s_of_type_Boolean) {}
    for (String str = "0X8008994";; str = "0X800898D")
    {
      FastWebShareUtils.a(this, str, 8, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      ReportUtil.a(this, getAppInterface(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, -1, 4, false);
      return;
    }
  }
  
  private void M()
  {
    ThreadManager.executeOnSubThread(new FastWebActivity.19(this));
    if (this.jdField_s_of_type_Boolean) {}
    for (String str = "0X8008994";; str = "0X800898D")
    {
      FastWebShareUtils.a(this, str, 10, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      ReportUtil.a(this, getAppInterface(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, -1, 5, false);
      return;
    }
  }
  
  private void N()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2.c();
    if (this.jdField_s_of_type_Boolean) {}
    for (String str = "0X8008994";; str = "0X800898D")
    {
      FastWebShareUtils.a(this, str, 7, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      ReportUtil.a(this, getAppInterface(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, -1, 0, false);
      return;
    }
  }
  
  private void O()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2.a(this, true);
    ReportUtil.a(this, getAppInterface(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, -1, 1, false, false, RIJJsonUtils.a(null, "function_type", Integer.valueOf(7)));
  }
  
  private void P()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
    ReportUtil.a(this, getAppInterface(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, -1, 2, false);
  }
  
  private void Q()
  {
    TeamWorkConvertUtils.a(1, 2);
    TeamWorkConvertUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle);
  }
  
  private void R()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.b()) {
        break label71;
      }
      QLog.d("FastWebActivity", 2, "mColorNoteController ：add colorNote");
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.e();
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebActivityStackUtil.a()) {
        QQToast.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131690972), 5000).a();
      }
    }
    return;
    label71:
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.i();
  }
  
  private void S()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController != null) && (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.c()))
    {
      QQToast.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131690976), 5000).a();
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.f();
      QLog.d("FastWebActivity", 2, "mColorNoteController ： delete colorNote");
    }
  }
  
  private void T()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeAvatarView = ((NativeAvatarView)findViewById(2131363131));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363132));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367277));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeAvatarView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  private void U()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData != null) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getFirstVisiblePosition(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData);
    }
  }
  
  private void V()
  {
    W();
    getMainLooper();
    Looper.myQueue().addIdleHandler(this.jdField_b_of_type_AndroidOsMessageQueue$IdleHandler);
  }
  
  private void W()
  {
    getMainLooper();
    Looper.myQueue().removeIdleHandler(this.jdField_b_of_type_AndroidOsMessageQueue$IdleHandler);
  }
  
  private void X()
  {
    if (b()) {
      return;
    }
    int i3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getLastVisiblePosition();
    d(i3);
    int i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getFirstVisiblePosition();
    int i1 = 0;
    boolean bool = false;
    label34:
    if (i2 <= i3)
    {
      i1 = a(i2);
      if ((i2 >= this.jdField_a_of_type_JavaUtilList.size()) || (!((BaseData)this.jdField_a_of_type_JavaUtilList.get(i2)).jdField_d_of_type_Boolean)) {
        break label211;
      }
      this.jdField_q_of_type_Boolean = true;
      if (this.jdField_b_of_type_Int == 0) {
        this.jdField_b_of_type_Int = a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, this.jdField_w_of_type_Int);
      }
      bool = true;
    }
    label133:
    label162:
    label188:
    label193:
    label211:
    for (;;)
    {
      i2 += 1;
      break label34;
      e(bool);
      int[] arrayOfInt = ReportUtil.jdField_a_of_type_ArrayOfInt;
      int i4 = arrayOfInt.length;
      i2 = 0;
      Integer localInteger;
      if (i2 < i4)
      {
        localInteger = Integer.valueOf(arrayOfInt[i2]);
        if ((1 << localInteger.intValue() & i1) == 0) {
          break label188;
        }
        i3 = 1;
        if (i3 == 0) {
          break label193;
        }
        TimeSliceHelper.b(ReportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, localInteger.intValue()));
      }
      for (;;)
      {
        i2 += 1;
        break label133;
        break;
        i3 = 0;
        break label162;
        TimeSliceHelper.c(ReportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, localInteger.intValue()));
      }
    }
  }
  
  private void Y()
  {
    this.jdField_y_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.d();
    QLog.d("FastWebActivity", 2, "mColorNoteController ：exitAnimation");
  }
  
  private void Z()
  {
    this.jdField_y_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.a(0, 4);
    QLog.d("FastWebActivity", 2, "mFloating doClostAnimTopToBottom ");
  }
  
  private float a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemHeightHelper == null)
    {
      QLog.e("Q.readinjoy.fast_web", 2, "getRatio itemsHeight == null ");
      return 0.0F;
    }
    if (this.jdField_g_of_type_Int <= 0) {
      X();
    }
    int i1 = a();
    int i2 = b();
    if ((i1 >= i2) || (i2 <= 0)) {
      return 1.0F;
    }
    return i1 / i2;
  }
  
  private int a()
  {
    return a(this.jdField_g_of_type_Int, this.jdField_h_of_type_Int);
  }
  
  private int a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
    {
      float f1 = BaseData.a((BaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      if (f1 <= ReportUtil.jdField_a_of_type_ArrayOfFloat[0]) {
        return 1;
      }
      if (f1 <= ReportUtil.jdField_a_of_type_ArrayOfFloat[1]) {
        return 2;
      }
      if (f1 <= ReportUtil.jdField_a_of_type_ArrayOfFloat[2]) {
        return 4;
      }
    }
    else
    {
      return 8;
    }
    return 0;
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int i1 = 0;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemHeightHelper == null)
    {
      QLog.e("Q.readinjoy.fast_web", 2, "getRatio itemsHeight == null ");
      return 0;
    }
    int i2 = 0;
    while ((i1 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemHeightHelper.a()) && (i1 <= paramInt1))
    {
      i2 += this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemHeightHelper.a(i1);
      i1 += 1;
    }
    return i2 - paramInt2;
  }
  
  private int a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      this.jdField_j_of_type_Int = a(paramAbsListView.getLastVisiblePosition(), this.jdField_i_of_type_Int);
    }
    for (;;)
    {
      return this.jdField_j_of_type_Int;
      if (this.jdField_j_of_type_Int == 0) {
        this.jdField_j_of_type_Int = a(paramAbsListView.getLastVisiblePosition(), this.jdField_i_of_type_Int);
      }
    }
  }
  
  private Bundle a(Bundle paramBundle)
  {
    Bundle localBundle1 = getIntent().getExtras();
    Bundle localBundle2 = localBundle1;
    if (localBundle1 == null) {
      if (paramBundle == null) {
        break label52;
      }
    }
    label52:
    for (paramBundle = paramBundle.getBundle("bundle_key_save_instancestate");; paramBundle = localBundle1)
    {
      if (paramBundle != null) {
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actKandianFastWebdoOnCreateSucc", true, 0L, 0L, null, null);
      }
      localBundle2 = paramBundle;
      return localBundle2;
    }
  }
  
  private VafContext a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new ReadInjoyContext();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(this);
      ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "native_article");
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter = new ReadInJoyCommentListAdapter(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, paramInt);
    String str2;
    String str1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData != null)
    {
      str2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData.jdField_a_of_type_JavaLangString;
      str1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData.jdField_b_of_type_JavaLangString;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str2))
      {
        QLog.d("Q.readinjoy.fast_web", 1, " mainComment : " + str2 + "  subComment : " + str1);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.a(new FastWebActivity.13(this, str2, str1));
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData, 1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.a(new FastWebActivity.CommentNumChangedlistener(this, null));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterFastWebMergeAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter);
      return;
      str1 = null;
      str2 = null;
    }
  }
  
  private void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentHippyQqTuwenAdapterTKDTuWenHippyCommentAdapter == null)
    {
      d(paramIntent);
      return;
    }
    int i2;
    if ((SimpleCommentData)paramIntent.getParcelableExtra("comment_create_data") != null)
    {
      i1 = 1;
      i2 = i1;
      if (i1 == 0)
      {
        i2 = paramIntent.getIntExtra("click_comment_edit_src", -1);
        if (i2 != 2) {
          break label108;
        }
      }
    }
    label108:
    for (int i1 = 1;; i1 = 0)
    {
      QLog.d("FastWebActivity", 1, "handleCommentEditorResponse commentEditClickSrc=" + i2);
      i2 = i1;
      if (i2 == 0) {
        break label114;
      }
      b(paramInt1, paramInt2, paramIntent);
      return;
      i1 = 0;
      break;
    }
    label114:
    d(paramIntent);
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    if ((paramInt == -1) && (paramIntent != null))
    {
      paramIntent = paramIntent.getParcelableExtra("key_ad_info");
      if (((paramIntent instanceof AdData)) && (this.jdField_a_of_type_JavaUtilList != null))
      {
        paramIntent = ((AdData)paramIntent).m;
        if (!TextUtils.isEmpty(paramIntent))
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext())
          {
            BaseData localBaseData = (BaseData)localIterator.next();
            if (((localBaseData instanceof AdData)) && (paramIntent.equals(((AdData)localBaseData).m)))
            {
              a(localBaseData);
              QQToast.a(this, -1, getString(2131699745), 0).b(getTitleBarHeight());
            }
          }
        }
      }
    }
  }
  
  private void a(int paramInt, AuthorData paramAuthorData)
  {
    boolean bool = FastWebPTSUtils.a(paramInt, this.jdField_a_of_type_JavaUtilList);
    paramInt = 4;
    if (bool) {
      paramInt = 0;
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeAvatarView.setVisibility(paramInt);
    b(paramInt, paramAuthorData);
  }
  
  private void a(long paramLong)
  {
    try
    {
      QLog.d("FastWebActivity", 1, "start to fetch live status");
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(paramLong));
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJLiveStatusModule == null) {
        y();
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJLiveStatusModule != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJLiveStatusModule.a(localArrayList);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("FastWebActivity", 1, "fetchLiveStatus error:" + localException);
    }
  }
  
  private void a(Bundle paramBundle)
  {
    Object localObject = getSupportFragmentManager();
    if ((paramBundle != null) && (localObject != null))
    {
      paramBundle = ((FragmentManager)localObject).getFragments();
      if ((paramBundle != null) && (paramBundle.size() > 0))
      {
        localObject = ((FragmentManager)localObject).beginTransaction();
        paramBundle = paramBundle.iterator();
        while (paramBundle.hasNext()) {
          ((FragmentTransaction)localObject).remove((Fragment)paramBundle.next());
        }
        ((FragmentTransaction)localObject).commit();
      }
    }
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    QLog.d("FastWebActivity", 1, " url: " + paramArticleInfo.mArticleContentUrl);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout != null) && (this.B)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.b();
    }
    int i1 = (int)paramArticleInfo.mChannelID;
    Bundle localBundle = new Bundle();
    localBundle.putString("leftViewText", null);
    Object localObject2 = paramArticleInfo.mArticleContentUrl;
    Object localObject1 = localObject2;
    if (RIJItemViewType.h(paramArticleInfo))
    {
      localObject1 = localObject2;
      if (!RIJItemViewType.l(paramArticleInfo)) {
        localObject1 = ((TopicRecommendFeedsInfo.TopicRecommendInfo)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.a.get(0)).jdField_b_of_type_JavaLangString;
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      al();
      QLog.d("FastWebActivity", 1, " url is null!");
      return;
    }
    localObject2 = localObject1;
    if (!(paramArticleInfo instanceof AdvertisementInfo))
    {
      if (((String)localObject1).contains("?"))
      {
        localObject1 = (String)localObject1 + "&";
        localObject2 = (String)localObject1 + "from=0";
      }
    }
    else
    {
      localObject1 = localObject2;
      if (AdvertisementInfo.isAppAdvertisementInfo(paramArticleInfo))
      {
        localObject1 = localObject2;
        if (NetworkUtil.h(null))
        {
          if (!((String)localObject2).contains("?")) {
            break label503;
          }
          localObject1 = (String)localObject2 + "&";
          label260:
          localObject1 = (String)localObject1 + "acttype=42";
        }
      }
      localObject2 = new Intent(this, ReadInJoyArticleDetailActivity.class);
      localBundle.putString("url", (String)localObject1);
      localBundle.putBoolean("hide_operation_bar", true);
      localBundle.putBoolean("from_native", true);
      localBundle.putString("from", String.valueOf(53));
      localBundle.putString("subscribename", paramArticleInfo.mSubscribeName);
      localBundle.putLong("articleid", paramArticleInfo.mArticleID);
      localBundle.putString("row_key", paramArticleInfo.innerUniqueID);
      localBundle.putInt("channelid", i1);
      localBundle.putInt("strategyid", paramArticleInfo.mStrategyId);
      localBundle.putLong("algorithmid", paramArticleInfo.mAlgorithmID);
      localBundle.putParcelable("fastwebinfo", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo);
      localBundle.putParcelable("articleinfo", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      localBundle.putInt("articalChannelId", 9);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null) {
        break label528;
      }
    }
    label528:
    for (i1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_d_of_type_Int;; i1 = 0)
    {
      localBundle.putInt("article_source", i1);
      ((Intent)localObject2).putExtras(localBundle);
      startActivityForResult((Intent)localObject2, 10923);
      return;
      localObject1 = (String)localObject1 + "?";
      break;
      label503:
      localObject1 = (String)localObject2 + "?";
      break label260;
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    int i1 = (int)paramArticleInfo.mChannelID;
    Object localObject;
    if (paramFastWebArticleInfo.c())
    {
      localObject = "2";
      localObject = RIJTransMergeKanDianReport.a(this, paramArticleInfo, i1, (String)localObject);
    }
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("comment", paramFastWebArticleInfo.jdField_b_of_type_Long);
        if (!this.jdField_w_of_type_Boolean) {
          continue;
        }
        i1 = 1;
        ((JSONObject)localObject).put("click_src", i1);
        if ((this.B) && (this.jdField_x_of_type_Int != -1)) {
          ((JSONObject)localObject).put("source_extratype", this.jdField_x_of_type_Int);
        }
      }
      catch (JSONException paramFastWebArticleInfo)
      {
        paramFastWebArticleInfo.printStackTrace();
        continue;
      }
      ReportUtil.a(paramArticleInfo, "0X8008989", ((JSONObject)localObject).toString());
      b();
      return;
      localObject = "1";
      break;
      i1 = 0;
    }
  }
  
  private void a(AuthorData paramAuthorData)
  {
    if (paramAuthorData == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeAvatarView.setUin(Long.parseLong(paramAuthorData.jdField_c_of_type_JavaLangString));
    this.jdField_e_of_type_AndroidWidgetTextView.setText(paramAuthorData.jdField_b_of_type_JavaLangString);
    d(paramAuthorData.jdField_a_of_type_Boolean);
  }
  
  private void a(AuthorData paramAuthorData, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if ((paramAuthorData == null) || (paramFastWebArticleInfo == null)) {
      return;
    }
    paramAuthorData.c(paramFastWebArticleInfo.q);
    paramAuthorData.a();
  }
  
  private void a(TitleData paramTitleData, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if ((paramTitleData == null) || (paramFastWebArticleInfo == null)) {
      return;
    }
    paramTitleData.a();
    paramTitleData.c(paramFastWebArticleInfo.q);
  }
  
  private void a(FastWebActivityStackUtil.SaveState paramSaveState)
  {
    an();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramSaveState.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebActivityStackUtil$SaveState = paramSaveState;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebActivityStackUtil$SaveState.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher;
    this.jdField_p_of_type_Boolean = paramSaveState.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventFastWebAdapterShowHelper = paramSaveState.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventFastWebAdapterShowHelper;
    s();
  }
  
  private void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    this.jdField_c_of_type_JavaLangString = paramActionSheetItem.uin;
    this.jdField_y_of_type_Int = paramActionSheetItem.uinType;
    this.jdField_d_of_type_JavaLangString = paramActionSheetItem.label;
  }
  
  private void a(AbsListView paramAbsListView, int paramInt, boolean paramBoolean)
  {
    this.jdField_c_of_type_Int = paramInt;
    if (((!this.jdField_k_of_type_Boolean) && (!paramBoolean)) || ((this.jdField_j_of_type_Boolean) && (!paramBoolean)) || (this.jdField_l_of_type_Boolean)) {}
    Object localObject2;
    int i1;
    label179:
    int i2;
    label320:
    label325:
    do
    {
      do
      {
        float f1;
        do
        {
          return;
          f1 = paramAbsListView.getFlingVelocityY();
        } while (((!paramBoolean) && ((f1 < this.jdField_a_of_type_Float) || (f1 > this.jdField_b_of_type_Float))) || (this.jdField_c_of_type_Int > paramInt) || (paramInt >= paramAbsListView.getCount() - 1));
        this.jdField_c_of_type_Int = paramInt;
        localObject1 = (ListAdapter)paramAbsListView.getAdapter();
        if (!paramBoolean) {
          break;
        }
        localObject2 = ((ListAdapter)localObject1).getItem(paramInt);
      } while ((!(localObject2 instanceof ProteusBannerBigPicItemData)) && (!(localObject2 instanceof ProteusBannerVideoItemData)));
      i1 = ((ListAdapter)localObject1).getItemViewType(paramInt);
      localObject2 = (View)this.jdField_b_of_type_AndroidUtilSparseArray.get(i1);
      ViewGroup.LayoutParams localLayoutParams;
      if (localObject2 == null)
      {
        localObject1 = ((ListAdapter)localObject1).getView(paramInt, null, paramAbsListView);
        this.jdField_b_of_type_AndroidUtilSparseArray.put(i1, localObject1);
        localObject2 = paramAbsListView.getChildAt(paramAbsListView.getLastVisiblePosition() - paramAbsListView.getFirstVisiblePosition());
        if ((localObject2 == null) || (localObject1 == null)) {
          break;
        }
        i1 = paramAbsListView.getRemainFlingDisY();
        i2 = ((View)localObject2).getBottom() + paramAbsListView.getTop() - paramAbsListView.getBottom() - paramAbsListView.getPaddingBottom();
        localLayoutParams = ((View)localObject1).getLayoutParams();
        if (localLayoutParams == null) {
          break label320;
        }
      }
      for (paramInt = localLayoutParams.width;; paramInt = -1)
      {
        ((View)localObject1).measure(ViewGroup.getChildMeasureSpec(paramAbsListView.getMeasuredWidthAndState(), paramAbsListView.getPaddingLeft() + paramAbsListView.getPaddingRight(), paramInt), 0);
        paramInt = ((View)localObject1).getMeasuredHeight();
        if ((!paramBoolean) || (i2 >= paramInt / 2)) {
          break label325;
        }
        this.jdField_l_of_type_Boolean = true;
        return;
        paramInt += 1;
        break;
        localObject1 = ((ListAdapter)localObject1).getView(paramInt, (View)localObject2, paramAbsListView);
        break label179;
      }
    } while (((i1 <= i2) || (i1 >= paramInt / 2 + i2)) && ((!paramBoolean) || (i2 <= paramInt / 2)));
    this.jdField_j_of_type_Boolean = true;
    Object localObject1 = new FastWebActivity.SmoothScrollTask(this, (View)localObject2, paramAbsListView, i1, paramInt, paramBoolean);
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramAbsListView.postOnAnimation((Runnable)localObject1);
      return;
    }
    paramAbsListView.post((Runnable)localObject1);
    return;
    this.jdField_l_of_type_Boolean = true;
  }
  
  private void a(Object paramObject)
  {
    if (!(paramObject instanceof Boolean)) {}
    do
    {
      do
      {
        return;
      } while (((Boolean)paramObject).booleanValue());
      d(true);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.notifyDataSetChanged();
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.b(true);
  }
  
  private void a(List<BaseData> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BaseData localBaseData = (BaseData)paramList.next();
      if ((localBaseData instanceof ProteusBannerVideoItemData)) {
        ((ProteusBannerVideoItemData)localBaseData).jdField_f_of_type_Boolean = false;
      }
    }
  }
  
  private void a(boolean paramBoolean, String paramString, List<BaseData> paramList1, List<BaseData> paramList2)
  {
    ReadInJoyAdLog.a("REPORT_LINK", "requestAdData onGetRecommendsResult");
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.o.equals(paramString)))
    {
      paramString = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramList2.iterator();
      while (localIterator.hasNext())
      {
        BaseData localBaseData = (BaseData)localIterator.next();
        if (localBaseData.jdField_d_of_type_Boolean) {
          paramString.add(localBaseData);
        } else {
          localArrayList.add(localBaseData);
        }
      }
      ItemDatasListUtils.a(this.jdField_a_of_type_JavaUtilList, paramList1, paramString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, true, this.jdField_a_of_type_AndroidUtilSparseArray, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher);
      ItemDatasListUtils.a(this.jdField_a_of_type_JavaUtilList, paramList1, localArrayList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, false, this.jdField_a_of_type_AndroidUtilSparseArray, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher);
      paramString = ReadInJoyLogicEngine.a().a();
      if (paramString != null) {
        paramString.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.j, this.jdField_a_of_type_JavaUtilList);
      }
      ab();
      ItemDatasListUtils.a(this.jdField_a_of_type_JavaUtilList);
      A();
      CommonAdFloatingBarUtils.a(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar, paramList2);
      QLog.d("FastWebActivity", 1, "adback initCommentAreaAnchor mCommentAreaLastFirstVisItemPos = " + this.jdField_s_of_type_Int);
      d();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, 0);
    }
  }
  
  private boolean a()
  {
    this.jdField_a_of_type_JavaUtilList = ReadInJoyLogicEngine.a().a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.j);
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      TimeUtil.a("HtmlChangeUtil.parse");
      if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
        this.jdField_a_of_type_AndroidUtilSparseArray = FastWebPTSDataConverter.a();
      }
      this.jdField_a_of_type_JavaUtilList = HtmlChangeUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_AndroidUtilSparseArray);
      ak();
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
        throw new RuntimeException("parse data is empty!");
      }
      this.jdField_a_of_type_JavaUtilList.add(0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData);
      this.jdField_a_of_type_JavaUtilList.add(1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData);
      r();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.a(this.jdField_a_of_type_JavaUtilList);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        BaseData localBaseData = (BaseData)localIterator.next();
        localBaseData.b = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
        localBaseData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
      }
      TimeUtil.a("HtmlChangeUtil.parse");
      return false;
    }
    if ((this.jdField_a_of_type_JavaUtilList.size() >= 2) && ((this.jdField_a_of_type_JavaUtilList.get(0) instanceof TitleData)) && ((this.jdField_a_of_type_JavaUtilList.get(1) instanceof AuthorData)))
    {
      this.jdField_a_of_type_JavaUtilList.set(0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData);
      this.jdField_a_of_type_JavaUtilList.set(1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData);
    }
    for (;;)
    {
      if ((this.jdField_l_of_type_Int != 1001) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebActivityStackUtil$SaveState == null)) {
        ItemDatasListUtils.d(this.jdField_a_of_type_JavaUtilList);
      }
      ItemDatasListUtils.e(this.jdField_a_of_type_JavaUtilList);
      return true;
      AIOUtils.a("Q.readinjoy.fast_web", "  " + this.jdField_a_of_type_JavaUtilList.size() + "  :  " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl, new IllegalArgumentException());
    }
  }
  
  private boolean a(int paramInt)
  {
    if ((!TKDTuWenCommentUtil.isCommentSwitchOn()) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("mArticleInfo is null? ");
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {}
      for (boolean bool = true;; bool = false)
      {
        QLog.d("FastWebActivity", 1, bool);
        return false;
      }
    }
    this.jdField_a_of_type_ComTencentHippyQqTuwenAdapterTKDTuWenHippyCommentAdapter = new TKDTuWenHippyCommentAdapter.Builder(this).articleInfo(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo).anchorData(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData).contentSrc(paramInt).listView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView).build();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterFastWebMergeAdapter.a(this.jdField_a_of_type_ComTencentHippyQqTuwenAdapterTKDTuWenHippyCommentAdapter);
    this.jdField_a_of_type_ComTencentHippyQqTuwenAdapterTKDTuWenHippyCommentAdapter.setHippyCommentPageListener(new FastWebActivity.12(this, paramInt));
    this.jdField_a_of_type_ComTencentHippyQqTuwenAdapterTKDTuWenHippyCommentAdapter.init();
    return true;
  }
  
  private boolean a(BaseAdapter paramBaseAdapter, int paramInt1, int paramInt2)
  {
    if (!(paramBaseAdapter instanceof ReadInJoyCommentListAdapter)) {
      return false;
    }
    return c(paramBaseAdapter, paramInt1, paramInt2);
  }
  
  private byte[] a()
  {
    byte[] arrayOfByte2 = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return null;
    }
    byte[] arrayOfByte1 = arrayOfByte2;
    try
    {
      Parcel localParcel = Parcel.obtain();
      arrayOfByte1 = arrayOfByte2;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.writeToParcel(localParcel, 0);
      arrayOfByte1 = arrayOfByte2;
      localParcel.setDataPosition(0);
      arrayOfByte1 = arrayOfByte2;
      arrayOfByte2 = localParcel.marshall();
      arrayOfByte1 = arrayOfByte2;
      localParcel.recycle();
      return arrayOfByte2;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d("FastWebActivity", 2, "init color bytes error");
    }
    return arrayOfByte1;
  }
  
  private void aa()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null)
    {
      Parcelable localParcelable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.onSaveInstanceState();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
      {
        FastWebModule localFastWebModule = ((ReadInJoyLogicManager)this.app.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).a().a();
        if (localFastWebModule != null) {
          localFastWebModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "", localParcelable);
        }
      }
    }
  }
  
  private void ab()
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    if (i1 < this.jdField_a_of_type_JavaUtilList.size())
    {
      BaseData localBaseData = (BaseData)this.jdField_a_of_type_JavaUtilList.get(i1);
      if (localBaseData.jdField_s_of_type_Int == 6) {}
      for (;;)
      {
        i1 += 1;
        break;
        if (AdData.a(localBaseData))
        {
          localArrayList.add(new ItemShowDispatcher.AdPostionReportManager(i1, Long.valueOf(0L), localBaseData));
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a(i1, new FastWebActivity.21(this, i1, localBaseData));
        }
        else if (ReportUtil.a(localBaseData))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.b(i1, new FastWebActivity.22(this, localBaseData));
        }
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a(localArrayList);
  }
  
  private void ac()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher == null)) {}
    for (;;)
    {
      return;
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_JavaUtilList.size())
      {
        BaseData localBaseData = (BaseData)this.jdField_a_of_type_JavaUtilList.get(i1);
        if (b(localBaseData.jdField_s_of_type_Int)) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.b(i1, new FastWebActivity.23(this, localBaseData));
        }
        i1 += 1;
      }
    }
  }
  
  private void ad()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher == null) || (this.jdField_a_of_type_JavaUtilList == null)) {}
    while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a.size() <= 0)) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a.iterator();
    label208:
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      int i1 = 0;
      for (;;)
      {
        if (i1 >= this.jdField_a_of_type_JavaUtilList.size()) {
          break label208;
        }
        if (localInteger.intValue() == i1)
        {
          BaseData localBaseData = (BaseData)this.jdField_a_of_type_JavaUtilList.get(localInteger.intValue());
          if (AdData.a(localBaseData))
          {
            ReportUtil.a(this.app, (AdData)localBaseData);
            if (localBaseData.b == null) {
              break;
            }
            ReadInJoyAdLog.a("REPORT_LINK", "invalidADExposurePos report " + localBaseData.b.mTitle);
            break;
          }
          QLog.d("FastWebActivity", 1, "invalidADExposurePos report invalid key" + localInteger);
          break;
        }
        i1 += 1;
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a.clear();
  }
  
  private void ae()
  {
    int i1 = b();
    ReportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, a(), i1, this.jdField_p_of_type_Boolean, this.jdField_b_of_type_Long, this.jdField_x_of_type_Int);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterWebFastAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterWebFastAdapter.e();
    }
  }
  
  private void af()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      TimeSliceHelper.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.a() != null))
      {
        ReadInJoyCommentReportManager localReadInJoyCommentReportManager = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.a();
        localReadInJoyCommentReportManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper.b(), this.jdField_u_of_type_Int);
        localReadInJoyCommentReportManager.a(0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getLastVisiblePosition() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterWebFastAdapter.getCount());
      }
      if (this.jdField_a_of_type_ComTencentHippyQqTuwenAdapterTKDTuWenHippyCommentAdapter != null) {
        this.jdField_a_of_type_ComTencentHippyQqTuwenAdapterTKDTuWenHippyCommentAdapter.sendCommentReadTime(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper.b());
      }
    }
  }
  
  private void ag()
  {
    long l1 = TimeUtil.c("fast_web_show_light_house_1");
    boolean bool = true;
    if (l1 < 0L) {
      return;
    }
    if (this.jdField_n_of_type_Boolean) {
      bool = false;
    }
    long l2 = TimeUtil.c("fast_web_show_light_house_2");
    long l3 = TimeUtil.c("fast_web_show_light_house_3");
    long l4 = TimeUtil.c("fast_web_show_light_house_draw_finish");
    long l5 = TimeUtil.c("fast_web_show_light_house_step4_2");
    long l6 = TimeUtil.c("fast_web_show_light_house_step4_1");
    HashMap localHashMap = new HashMap();
    localHashMap.put("which", "1");
    localHashMap.put("step1", String.valueOf(l2 - l1));
    localHashMap.put("step2", String.valueOf(l3 - l2));
    localHashMap.put("step3", String.valueOf(l4 - l3));
    localHashMap.put("step4", String.valueOf(l5 - l6));
    localHashMap.put("param_uin", ReadInJoyUtils.a());
    QLog.d("Q.readinjoy.fast_web", 2, "reportSpentTime, params = " + localHashMap.toString() + "  all cost : " + (l4 - l1));
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actKandianFastWebCost", bool, l4 - l1, 0L, localHashMap, null);
  }
  
  private void ah()
  {
    this.jdField_n_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getFirstVisiblePosition();
    View localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(0);
    int i1;
    boolean bool1;
    boolean bool2;
    if (localView == null)
    {
      i1 = 0;
      this.jdField_o_of_type_Int = i1;
      this.jdField_p_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getLastVisiblePosition();
      bool1 = c(this.jdField_n_of_type_Int);
      bool2 = c(this.jdField_p_of_type_Int);
      if ((bool1) || (bool2)) {
        break label101;
      }
      this.jdField_q_of_type_Int = this.jdField_n_of_type_Int;
      this.jdField_r_of_type_Int = this.jdField_o_of_type_Int;
      this.jdField_v_of_type_Boolean = true;
    }
    label101:
    do
    {
      return;
      i1 = localView.getTop();
      break;
      if ((bool1) && (bool2))
      {
        this.jdField_s_of_type_Int = this.jdField_n_of_type_Int;
        this.jdField_t_of_type_Int = this.jdField_o_of_type_Int;
        this.jdField_v_of_type_Boolean = false;
        this.jdField_i_of_type_Boolean = true;
        QLog.d("FastWebActivity", 1, "upCmtHisPos mCommentAreaLastFirstVisItemPos = " + this.jdField_s_of_type_Int);
        return;
      }
    } while ((bool1) || (!bool2));
    this.jdField_v_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = true;
    this.jdField_q_of_type_Int = 0;
    this.jdField_r_of_type_Int = 0;
    QLog.d("FastWebActivity", 1, "2area show together initCommentAreaAnchor mCommentAreaLastFirstVisItemPos = " + this.jdField_s_of_type_Int);
    d();
  }
  
  private void ai()
  {
    try
    {
      FastWebPTSDataConverter.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher, this.jdField_a_of_type_AndroidUtilSparseArray);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.setData(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("FastWebActivity", 1, "updateConfigInfo error ! msg=" + localException);
    }
  }
  
  private void aj()
  {
    if (!this.jdField_o_of_type_Boolean) {}
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebActivityStackUtil$SaveState != null) {
      return;
    }
    finish();
  }
  
  private void ak()
  {
    FastWebPTSUtils.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  private void al()
  {
    Object localObject = findViewById(2131374174);
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = (TextView)findViewById(2131376583);
    String str = getString(2131718319);
    if ((localObject != null) && (!TextUtils.isEmpty(str)))
    {
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(str);
    }
  }
  
  private void am()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebActivityStackUtil.a()) {}
    FastWebActivityStackUtil.SaveState localSaveState;
    do
    {
      return;
      this.jdField_u_of_type_Boolean = true;
      doOnPause();
      doOnStop();
      ae();
      VideoReport.pageLogicDestroy(this);
      this.jdField_u_of_type_Boolean = false;
      localSaveState = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebActivityStackUtil.a();
    } while (localSaveState == null);
    a(localSaveState);
    this.jdField_u_of_type_Boolean = true;
    doOnStart();
    doOnResume();
    h();
    this.jdField_u_of_type_Boolean = false;
  }
  
  private void an()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebActivityStackUtil$SaveState = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData = null;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemHeightHelper = null;
    this.jdField_n_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher = null;
    this.jdField_r_of_type_Boolean = false;
    this.jdField_s_of_type_Boolean = false;
    this.jdField_t_of_type_Boolean = false;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_g_of_type_Int = 0;
    this.jdField_h_of_type_Int = 0;
    this.jdField_p_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = (System.currentTimeMillis() + "");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setDrawFinishedListener(null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.removeScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    FastWebModule localFastWebModule = ReadInJoyLogicEngine.a().a();
    if (localFastWebModule != null)
    {
      localFastWebModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$ArticleRichInfoCallback);
      localFastWebModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFastWebModule$FastWebContentGetCallback);
    }
    this.jdField_j_of_type_Int = 0;
  }
  
  private void ao()
  {
    int i1 = b();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (i1 != 0)) {
      RIJFeedsDynamicInsertController.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, new RIJFeedsInsertAction(RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_ARTICLE_READ_PROGRESS, a() * 100 / i1, 0, (int)TimeSliceHelper.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID) / 1000), 5);
    }
  }
  
  private void ap()
  {
    RIJFeedsType.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("preGotoConversation mActivityStack size = ").append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebActivityStackUtil.a()).append("ismain = ");
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break label88;
      }
    }
    label88:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("FastWebActivity", 2, bool);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebActivityStackUtil.a(new FastWebActivity.33(this));
      return;
    }
  }
  
  private void aq()
  {
    A();
  }
  
  private void ar()
  {
    Object localObject = getIntent();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((Intent)localObject).getExtras();
    } while (localObject == null);
    this.B = ((Bundle)localObject).getBoolean("launch_from_floating_window", false);
    if (this.B)
    {
      this.C = ((Bundle)localObject).getBoolean("scroll_to_top", true);
      this.D = ((Bundle)localObject).getBoolean("up_animation", true);
      this.jdField_x_of_type_Int = ((Bundle)localObject).getInt("floating_window_scene", -1);
    }
    QLog.d("FastWebActivity", 1, "mFloating initFloatingWindow,isFromFloatingLayer=" + this.B + "  isSuctionTop=" + this.C);
  }
  
  private void as()
  {
    int i1 = (int)(com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.device.RIJDisplayStyleManager.a(this)[0] / 16.0F * 9.0F);
    if ((i1 > 0) && (this.jdField_c_of_type_AndroidViewView != null) && ((this.jdField_c_of_type_AndroidViewView.getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
      ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams()).topMargin = i1;
    }
  }
  
  private void at()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixDataManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixDataManager.a();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixDataManager = new RIJBiuAndCommentMixDataManager();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixDataManager.a(new FastWebActivity.40(this));
  }
  
  private void au()
  {
    Intent localIntent = getIntent();
    if ((localIntent == null) || (localIntent.getExtras() == null)) {
      return;
    }
    switch (localIntent.getExtras().getInt("native_article_launch_from", 1000))
    {
    case 1001: 
    default: 
      return;
    case 1000: 
      this.jdField_m_of_type_Int = c();
      return;
    case 1004: 
      this.jdField_m_of_type_Int = 32;
      return;
    case 1003: 
      this.jdField_m_of_type_Int = 64;
      return;
    }
    this.jdField_m_of_type_Int = 16;
  }
  
  private int b()
  {
    int i3;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemHeightHelper == null)
    {
      QLog.e("Q.readinjoy.fast_web", 2, "getRatio itemsHeight == null ");
      i3 = -1;
      return i3;
    }
    int i2 = 0;
    for (int i1 = 0;; i1 = i3)
    {
      i3 = i1;
      if (i2 >= this.jdField_a_of_type_JavaUtilList.size()) {
        break;
      }
      i3 = i1;
      if (FastWebPTSUtils.a((BaseData)this.jdField_a_of_type_JavaUtilList.get(i2))) {
        i3 = i1 + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemHeightHelper.a(i2);
      }
      i2 += 1;
    }
  }
  
  private void b(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentHippyQqTuwenAdapterTKDTuWenHippyCommentAdapter == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentHippyQqTuwenAdapterTKDTuWenHippyCommentAdapter.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  private void b(int paramInt, Intent paramIntent)
  {
    if ((paramInt == -10069) && (paramIntent != null) && (paramIntent.getExtras() != null)) {
      ReadInJoyUtils.a(this, ((ArticleInfo)paramIntent.getExtras().get("fast_web_article_info")).mArticleContentUrl);
    }
  }
  
  private void b(int paramInt, AuthorData paramAuthorData)
  {
    if (paramAuthorData != null) {
      d(paramAuthorData.jdField_a_of_type_Boolean);
    }
    for (;;)
    {
      int i1 = this.jdField_b_of_type_AndroidWidgetImageView.getVisibility();
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(paramInt);
      if ((i1 != paramInt) && (paramInt == 0)) {
        ReadinjoyReportUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, ReadinjoyReportUtils.jdField_d_of_type_Int, true, "");
      }
      return;
      paramInt = 4;
    }
  }
  
  private void b(long paramLong)
  {
    ThreadManager.getUIHandler().postDelayed(new FastWebActivity.32(this), paramLong);
  }
  
  private void b(Intent paramIntent)
  {
    int i1 = 2;
    if (paramIntent.getIntExtra("click_comment_edit_src", -1) == 2) {
      i1 = 1;
    }
    ReadInJoyCommentListFragment.a(paramIntent, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixDataManager, 1, true, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.b(), i1);
    QLog.d("FastWebActivity", 1, "back from biuAndComment");
  }
  
  private void b(Bundle paramBundle)
  {
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null)
    {
      QLog.d("FastWebActivity", 1, "onSaveInstanceState data != null");
      paramBundle.putBundle("bundle_key_save_instancestate", localBundle);
    }
  }
  
  private void b(BaseData paramBaseData)
  {
    if (paramBaseData == null) {}
    while (this.jdField_a_of_type_JavaUtilSet.contains(paramBaseData)) {
      return;
    }
    for (;;)
    {
      Object localObject;
      try
      {
        if (paramBaseData.jdField_s_of_type_Int == 6)
        {
          ReportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramBaseData);
          if ((paramBaseData instanceof ProteusRecommendItemData))
          {
            JSONObject localJSONObject1 = ((ProteusRecommendItemData)paramBaseData).c;
            if ((localJSONObject1 != null) && (localJSONObject1.opt("id_recommend_category_txt") != null) && (localJSONObject1.opt("kd_ug_download_url") != null) && (localJSONObject1.optString("kd_ug_rsp_info") != null))
            {
              String str = "";
              localObject = str;
              if (localJSONObject1.opt("card_info") != null)
              {
                JSONObject localJSONObject2 = localJSONObject1.getJSONObject("card_info");
                localObject = str;
                if (localJSONObject2.opt("rowKey") != null) {
                  localObject = localJSONObject2.getString("rowKey");
                }
              }
              KandianUGStatisticUtils.a(KandianUGStatisticUtils.a(new FastWebRecommendUGInfo(localJSONObject1.optString("kd_ug_rsp_info")).jdField_a_of_type_JavaLangString, (String)localObject, "2"));
            }
          }
          this.jdField_a_of_type_JavaUtilSet.add(paramBaseData);
          return;
        }
      }
      catch (Exception paramBaseData)
      {
        QLog.d("FastWebActivity", 1, "doExposure error! msg=" + paramBaseData);
        return;
      }
      if (paramBaseData.jdField_s_of_type_Int == 26)
      {
        localObject = (ProteusItemData)paramBaseData;
        if (((ProteusItemData)localObject).jdField_x_of_type_Int == 2)
        {
          FastWebDislikeUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X80099DA");
          FastWebDislikeUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X80100DB");
          FastWebDislikeUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X8009A5A");
        }
        else
        {
          FastWebProteusReportUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, (ProteusItemData)localObject);
        }
      }
      else
      {
        ReportUtil.a(paramBaseData);
        if (paramBaseData.b != null) {
          ReadInJoyAdLog.a("REPORT_LINK", "doExposure baseData=" + paramBaseData.b.mTitle);
        }
      }
    }
  }
  
  private void b(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      QidianManager.a(this, 6, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSummary, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFirstPagePicUrl, paramActionSheetItem.uin, paramActionSheetItem.uinType, false);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.A) {}
    do
    {
      return;
      this.A = true;
      int i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebActivityStackUtil.a();
      QLog.d("FastWebActivity", 2, "mColorNoteController ：finishOneByOne  size:" + i2);
      int i1 = 0;
      while (i1 < i2)
      {
        finish();
        i1 += 1;
      }
      finish();
    } while ((!this.B) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout == null) || (!paramBoolean));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.d();
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemHeightHelper == null) || ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterWebFastAdapter != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterWebFastAdapter.getCount() != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemHeightHelper.a())))
    {
      QLog.e("Q.readinjoy.fast_web", 2, "refreshMaxReadHeight itemsHeight == null ");
      return true;
    }
    return false;
  }
  
  private boolean b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private boolean b(BaseAdapter paramBaseAdapter, int paramInt1, int paramInt2)
  {
    if (!(paramBaseAdapter instanceof TKDTuWenHippyCommentAdapter)) {
      return false;
    }
    return c(paramBaseAdapter, paramInt1, paramInt2);
  }
  
  private int c()
  {
    if (this.jdField_b_of_type_Long == 0L) {
      return 2;
    }
    if (this.jdField_b_of_type_Long == 70L) {
      return 4;
    }
    return 8;
  }
  
  private void c(int paramInt)
  {
    ReadInJoyLogicEngine.a().a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID + "", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID, paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$ArticleRichInfoCallback);
  }
  
  private void c(Intent paramIntent)
  {
    paramIntent = paramIntent.getSerializableExtra("backToImageData");
    if ((paramIntent instanceof List))
    {
      paramIntent = (List)paramIntent;
      if (!paramIntent.isEmpty())
      {
        ThreadManager.getUIHandler().post(new FastWebActivity.28(this, paramIntent));
        QLog.d("FastWebActivity", 2, "update comments info from commentlist activity ! size : " + paramIntent.size());
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.setData(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.setVisibility(8);
  }
  
  private boolean c()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null) || (this.jdField_n_of_type_Boolean);
  }
  
  private boolean c(int paramInt)
  {
    if (!e()) {
      return false;
    }
    int i3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterFastWebMergeAdapter.a().size();
    int i1 = 0;
    int i2 = 0;
    while (i1 < i3)
    {
      BaseAdapter localBaseAdapter = (BaseAdapter)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterFastWebMergeAdapter.a().get(i1);
      if ((a(localBaseAdapter, paramInt, i2)) || (b(localBaseAdapter, paramInt, i2))) {
        return true;
      }
      i2 += localBaseAdapter.getCount();
      i1 += 1;
    }
    return false;
  }
  
  private boolean c(BaseAdapter paramBaseAdapter, int paramInt1, int paramInt2)
  {
    int i1 = paramBaseAdapter.getCount();
    return (paramInt1 >= paramInt2) && (paramInt1 < i1 + paramInt2);
  }
  
  private void d(int paramInt)
  {
    if (paramInt > this.jdField_g_of_type_Int) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemHeightHelper != null)
      {
        int i2 = paramInt;
        if (this.jdField_g_of_type_Int > paramInt) {
          i2 = this.jdField_g_of_type_Int;
        }
        this.jdField_g_of_type_Int = i2;
        paramInt = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getFirstVisiblePosition();
        paramInt = this.jdField_g_of_type_Int - paramInt;
        if ((paramInt < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildCount()) && (this.jdField_g_of_type_Int < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemHeightHelper.a()))
        {
          View localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(paramInt);
          paramInt = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getHeight();
          i2 = localView.getTop();
          this.jdField_i_of_type_Int = (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemHeightHelper.a(this.jdField_g_of_type_Int) - (paramInt - i2));
          if (i1 == 0) {
            break;
          }
          this.jdField_h_of_type_Int = this.jdField_i_of_type_Int;
          if (this.jdField_h_of_type_Int < 0) {
            this.jdField_h_of_type_Int = 0;
          }
          QLog.d("Q.readinjoy.fast_web", 2, "  mMaxLastPosition  " + this.jdField_g_of_type_Int + "  mMaxLastItemInvisibleHeight " + this.jdField_h_of_type_Int);
        }
      }
      return;
    }
    if (this.jdField_i_of_type_Int < this.jdField_h_of_type_Int) {}
    for (paramInt = this.jdField_i_of_type_Int;; paramInt = this.jdField_h_of_type_Int)
    {
      this.jdField_h_of_type_Int = paramInt;
      break;
    }
  }
  
  private void d(Intent paramIntent)
  {
    int i1 = -1;
    String str = paramIntent.getStringExtra("arg_result_json");
    int i2 = paramIntent.getIntExtra("click_comment_edit_src", -1);
    paramIntent = ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    if (paramIntent == null)
    {
      paramIntent = new StringBuilder().append("commentDataManage is null, src : ").append(i2).append(", hasInit : ");
      if (this.jdField_a_of_type_JavaUtilList != null) {}
      for (boolean bool = true;; bool = false)
      {
        AIOUtils.a("FastWebActivity", bool, new NullPointerException());
        return;
      }
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter != null) {
      i1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.b();
    }
    switch (i2)
    {
    default: 
      return;
    case 2: 
      paramIntent.d(str, i1);
      return;
    }
    paramIntent.c(str, i1);
  }
  
  private void d(boolean paramBoolean)
  {
    Object localObject = this.jdField_b_of_type_AndroidWidgetImageView;
    if (paramBoolean)
    {
      i1 = 2130843095;
      ((ImageView)localObject).setImageResource(i1);
      this.jdField_b_of_type_AndroidWidgetImageView.setTag(Boolean.valueOf(paramBoolean));
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
      {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
        if (!paramBoolean) {
          break label106;
        }
      }
    }
    label106:
    for (i1 = BaseArticleInfo.TYPE_FOLLOWED_BUTTON;; i1 = BaseArticleInfo.TYPE_UNFOLLOW_BUTTON)
    {
      ((ArticleInfo)localObject).showFollowButtonType = i1;
      long l1 = 0L;
      try
      {
        long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.getSubscribeUin());
        l1 = l2;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          QLog.d("FastWebActivity", 1, "mArticleInfo.getSubscribeUin() parse to long error" + localNumberFormatException);
          continue;
          i1 = BaseArticleInfo.TYPE_UNFOLLOW_BUTTON;
        }
      }
      localObject = ReadInJoyLogicEngine.a().a();
      if (!paramBoolean) {
        break label146;
      }
      i1 = BaseArticleInfo.TYPE_FOLLOWED_BUTTON;
      ((FollowListInfoModule)localObject).a(l1, i1);
      return;
      i1 = 2130843246;
      break;
    }
  }
  
  private boolean d()
  {
    return (this.jdField_l_of_type_Int == 1001) && (!DailyModeConfigHandler.c(this.jdField_e_of_type_Int));
  }
  
  private boolean d(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (paramInt > 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return FastWebPTSUtils.a((BaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    }
    return false;
  }
  
  private void e(int paramInt)
  {
    int i1;
    AppInterface localAppInterface;
    ArticleInfo localArticleInfo;
    if (this.jdField_f_of_type_Int == 72)
    {
      i1 = 13;
      localAppInterface = getAppInterface();
      localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      if (paramInt != -1) {
        break label50;
      }
    }
    label50:
    for (boolean bool = true;; bool = false)
    {
      ReportUtil.a(this, localAppInterface, localArticleInfo, 1, i1, false, bool, false);
      return;
      i1 = -1;
      break;
    }
  }
  
  private void e(Intent paramIntent)
  {
    an();
    paramIntent = paramIntent.getExtras();
    if (paramIntent == null)
    {
      QLog.e("Q.readinjoy.fast_web", 1, " refrashFromIntent data == null ");
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)paramIntent.get("fast_web_article_info"));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher = new ItemShowDispatcher();
    this.jdField_g_of_type_Boolean = true;
    this.jdField_p_of_type_Boolean = paramIntent.getBoolean("fast_web_from_article_recommend", false);
    s();
  }
  
  private void e(boolean paramBoolean)
  {
    IUIDelegate localIUIDelegate;
    boolean bool2;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar.a() != null))
    {
      localIUIDelegate = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar.a();
      bool2 = localIUIDelegate.jdField_a_of_type_Boolean;
      if (CommonAdFloatingBarUtils.a(localIUIDelegate)) {
        if (!(localIUIDelegate instanceof GamesComponentAdDelegate)) {
          break label177;
        }
      }
    }
    label177:
    for (boolean bool1 = ((GamesComponentAdDelegate)localIUIDelegate).a();; bool1 = false)
    {
      if ((localIUIDelegate.jdField_a_of_type_Int == 2) && (CommonAdFloatingBarUtils.a(a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, this.jdField_w_of_type_Int), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getHeight(), this.jdField_b_of_type_Int, bool1, paramBoolean, bool2)))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar.setVisibility(0);
        localIUIDelegate.d();
        return;
      }
      if ((localIUIDelegate.jdField_a_of_type_Int == 1) && (CommonAdFloatingBarUtils.a(paramBoolean, this.jdField_q_of_type_Boolean, bool2)) && (localIUIDelegate.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (localIUIDelegate.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_q_of_type_Int == 1))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar.setVisibility(0);
        localIUIDelegate.d();
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar.setVisibility(8);
      return;
    }
  }
  
  private boolean e()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterFastWebMergeAdapter == null) {}
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterFastWebMergeAdapter.a().size() <= 0) {
      return false;
    }
    return true;
  }
  
  private void f(int paramInt)
  {
    if ((paramInt == -1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo != null))
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
      ((FastWebArticleInfo)localObject).jdField_c_of_type_Long += 1L;
      ThreadManager.getUIHandler().post(new FastWebActivity.27(this));
    }
    Object localObject = getAppInterface();
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    if (paramInt == -1) {}
    for (boolean bool = true;; bool = false)
    {
      ReportUtil.a(this, (AppInterface)localObject, localArticleInfo, 0, -1, false, bool, false);
      return;
    }
  }
  
  private void f(boolean paramBoolean)
  {
    runOnUiThread(new FastWebActivity.35(this, paramBoolean));
  }
  
  private void g(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout != null) && (this.B))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.setVisibility(paramInt);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.c();
    }
  }
  
  private void g(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo != null) && (!this.jdField_o_of_type_Boolean)) {
      F();
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return;
    }
    VideoReport.setPageId(this, "1");
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID)) {}
    for (String str = "null";; str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID)
    {
      VideoReport.setPageContentId(this, str);
      VideoReport.setPageParams(this, new RIJDtParamBuilder().e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID).a(Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID)).a("ref_channel", Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID)).b(Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.dtReportContentType)).a());
      return;
    }
  }
  
  private void h(int paramInt)
  {
    QLog.d("FastWebActivity", 1, "requestControllInfo delayTime: " + paramInt + " rowKey: " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramInt);
  }
  
  private void i()
  {
    if ((this.B) && (this.jdField_z_of_type_Boolean)) {
      ThreadManager.getUIHandler().postDelayed(new FastWebActivity.1(this), 500L);
    }
  }
  
  private void j()
  {
    if ((this.B) && (this.jdField_z_of_type_Boolean))
    {
      Intent localIntent = getIntent();
      Bundle localBundle = null;
      if (localIntent != null) {
        localBundle = localIntent.getExtras();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout = new CommonSuspensionGestureLayout(this, localBundle);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setIsAutoSuctionTop(this.C);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setIsNeedPopAnim(this.D);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setIsStatusImmersive(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setContentScrollListener(new FastWebActivity.2(this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setViolaGestureListener(new FastWebActivity.3(this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.a(this, 2131377161, 2131363837);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setMaskBackGroundDrawable(getResources().getDrawable(2130841879));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.setBackgroundColor(-1);
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      QLog.d("FastWebActivity", 2, "init color error mArticleInfo is null");
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController = new ColorNoteController(this, true, false, true, true, 0);
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a(this);
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a(new FastWebActivity.4(this));
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
        QLog.d("FastWebActivity", 2, "mColorNoteController ： mOutterRowKey : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID + "mTitle : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle + "mSubscribeName : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName + "mSubscribeName : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName);
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a(new FastWebActivity.5(this));
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a(new FastWebActivity.6(this));
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a(new FastWebActivity.7(this));
    } while (this.jdField_z_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.j();
  }
  
  private void l()
  {
    jdField_b_of_type_Boolean = false;
    SneakyCallback.a(4);
  }
  
  private void m()
  {
    jdField_b_of_type_Boolean = false;
    jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_Long = 0L;
  }
  
  private void n()
  {
    try
    {
      this.jdField_b_of_type_AndroidViewView = findViewById(2131377273);
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        this.jdField_b_of_type_AndroidViewView.setFitsSystemWindows(true);
        this.jdField_b_of_type_AndroidViewView.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      }
      if (ThemeUtil.isInNightMode(ReadInJoyUtils.a()))
      {
        if (this.jdField_a_of_type_AndroidViewView == null) {
          this.jdField_a_of_type_AndroidViewView = ((ViewStub)findViewById(2131376600)).inflate();
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369534));
      findViewById(2131369487).setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew = ((ReadInJoyFastWebBottomSocialViewNew)findViewById(2131363837));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.setProteusContext(a());
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = ((ReadInJoyCommentListView)findViewById(2131382096));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setEdgeEffectEnabled(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.mEdgeGlowTop.setEdgeDrawable(getResources().getDrawable(2131167305));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.mEdgeGlowBottom.setEdgeDrawable(getResources().getDrawable(2131167305));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setOverScrollTouchMode(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setOverScrollFlingMode(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setDescendantFocusability(262144);
      o();
      Object localObject = (QQAppInterface)ReadInJoyUtils.a();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)((QQAppInterface)localObject).getRuntimeService(IQQAvatarService.class, "")).getInstance((AppInterface)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380273));
      if (this.jdField_b_of_type_AndroidWidgetTextView.getPaint() != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      }
      this.jdField_d_of_type_AndroidViewView = findViewById(2131371073);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      T();
      p();
      q();
      localObject = findViewById(2131377083);
      ((View)localObject).setOnClickListener(this);
      a((View)localObject, "more_function_button", "more_function_button", "click_more_function");
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366896));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$RecommendAndAdCallback = new FastWebActivity.RecommendAndAdCallback(this);
      G();
      s();
      ar();
      au();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      setResult(-10069, getIntent());
      finish();
    }
  }
  
  private void o()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar = ((CommonAdBar)findViewById(2131378289));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar.bringToFront();
  }
  
  private void p()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131377324));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371623));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371624));
    Drawable localDrawable = ImageUtil.a(this.jdField_a_of_type_AndroidWidgetImageView.getResources().getDrawable(2130841208), -16777216);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
    a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, "news_button", "news_button", "click_news");
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser = new MiniMsgUser(getActivity(), a());
    }
  }
  
  private void r()
  {
    if (Aladdin.getConfig(423).getIntegerFromString("native_article_show_read_count", 1) == 1)
    {
      ProteusItemData localProteusItemData = FastWebPTSDataConverter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_AndroidUtilSparseArray);
      if (localProteusItemData != null) {
        this.jdField_a_of_type_JavaUtilList.add(localProteusItemData);
      }
    }
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null)
    {
      D();
      return;
    }
    localHashMap = new HashMap();
    try
    {
      z();
      TimeUtil.b("fast_web_show_light_house_step4_1");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowListInfoModule$FollowStatusObserver);
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo);
      bool = a();
      FastWebPTSDataConverter.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo);
      ItemDatasListUtils.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo);
      v();
      TimeUtil.b("fast_web_show_light_house_step4_2");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterFastWebMergeAdapter = new FastWebMergeAdapter();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemHeightHelper = new ItemHeightHelper(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterFastWebMergeAdapter);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemHeightHelper);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterWebFastAdapter = new WebFastAdapter(this, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, a());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterFastWebMergeAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterWebFastAdapter);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.b()) {
        B();
      }
      u();
      w();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setDrawFinishedListener(this.jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterFastWebMergeAdapter);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterFastWebMergeAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterFastWebMergeAdapter$OnDataSetChangeListener);
      this.jdField_c_of_type_AndroidViewView = findViewById(2131377654);
      as();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout = ((ReadInJoyCommentTopGestureLayout)this.jdField_b_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jdField_b_of_type_AndroidViewView, true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setFirstLevelCommentContainer(this, false);
      localFastWebModule = ReadInJoyLogicEngine.a().a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebActivityStackUtil$SaveState == null) {
        break label753;
      }
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebActivityStackUtil$SaveState.jdField_a_of_type_AndroidOsParcelable;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        FastWebModule localFastWebModule;
        Object localObject1;
        label370:
        QLog.e("FastWebActivity", 1, "has parse error, use webview open url! e=" + localException);
        localHashMap.put("param_error", localException.toString());
        t();
        boolean bool = false;
        continue;
        c(true);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
        ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
        if (this.jdField_d_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.b();
          this.jdField_d_of_type_Boolean = false;
          continue;
          Object localObject2 = null;
          continue;
          if (bool) {}
        }
      }
    }
    if (localObject1 != null)
    {
      localObject1 = (AbsListView.SavedState)localObject1;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.onRestoreInstanceState((Parcelable)localObject1);
      a(((AbsListView.SavedState)localObject1).position, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData);
      if ((this.jdField_l_of_type_Int == 1001) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebActivityStackUtil$SaveState != null)) {
        break label916;
      }
      a(this.jdField_a_of_type_JavaUtilList);
      if (localFastWebModule != null) {
        localFastWebModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebFastWebActivity$ArticleRichInfoCallback, true);
      }
      if ((!bool) && (localFastWebModule != null)) {
        localFastWebModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_JavaUtilList);
      }
      bool = true;
      localHashMap.put("param_uin", ReadInJoyUtils.a());
      localHashMap.put("param_url", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
      localHashMap.put("param_articleID", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "");
      localHashMap.put("param_rowkey", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID + "");
      localHashMap.put("param_channelID", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actNativeWebParser", bool, 100L, 0L, localHashMap, "", true);
      if (bool) {
        break label853;
      }
      c(false);
      E();
      ReadInJoyDropFrameHelper.a().a(5555, this);
      ReadInJoyDropFrameHelper.a().a(6666, this);
      d();
      new StyleConfigHelper().a("native_article");
      at();
      QLog.d("FastWebActivity", 1, "initData,isParseSuccess=" + bool);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_d_of_type_Long == 0L)) {
        break;
      }
      ReadInJoyUserInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule$RefreshUserInfoCallBack, true);
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_d_of_type_Long);
      return;
      label753:
      if (localFastWebModule == null) {
        break label911;
      }
      localObject1 = localFastWebModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "");
      break label370;
      a(0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData);
    }
  }
  
  private void t() {}
  
  private void u()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getFooterViewsCount() == 0) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.initFooterView();
    }
  }
  
  private void v()
  {
    this.jdField_v_of_type_Int = 0;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      BaseData localBaseData = (BaseData)localIterator.next();
      if ((localBaseData != null) && ((localBaseData instanceof ProteusItemData)))
      {
        ProteusItemData localProteusItemData = (ProteusItemData)localBaseData;
        if ((localProteusItemData.jdField_x_of_type_Int == 1) && ((localProteusItemData.jdField_w_of_type_Int == 1) || (localProteusItemData.jdField_w_of_type_Int == 2)) && (localBaseData.jdField_s_of_type_Int != 0)) {
          this.jdField_v_of_type_Int += 1;
        }
      }
    }
  }
  
  private void w()
  {
    this.jdField_a_of_type_ComTencentQqliveModuleVideoreportPageIScrollReader = new FastWebActivity.8(this);
    VideoReport.markAsPageBodyView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, this.jdField_a_of_type_ComTencentQqliveModuleVideoreportPageIScrollReader);
    VideoReport.setPageBodyContentRange(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, 0, this.jdField_a_of_type_JavaUtilList.size());
  }
  
  private void x()
  {
    ArticleInfo localArticleInfo;
    int i1;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.a("https://pub.idqqimg.com/pc/misc/files/20200611/2a67e74aa4ed4a71a8e877deac8e41cf.png");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.b("https://pub.idqqimg.com/pc/misc/files/20200611/558a344321d34d25b847cf32ff9403f8.png");
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
      {
        localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
        i1 = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c())) {
          break label105;
        }
        localObject = "2";
      }
    }
    for (;;)
    {
      localObject = RIJTransMergeKanDianReport.a(this, localArticleInfo, i1, (String)localObject);
      try
      {
        ((JSONObject)localObject).put("live_circle_from_page", 1);
        ReportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X800B17D", ((JSONObject)localObject).toString());
        A();
        return;
        label105:
        localObject = "1";
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("FastWebActivity", 2, "live status error:" + localJSONException.getMessage());
        }
      }
    }
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJLiveStatusModule == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJLiveStatusModule = ReadInJoyLogicEngine.a().a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJLiveStatusModule != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJLiveStatusModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJLiveStatusModule$LiveStatusCallback);
      }
    }
  }
  
  private void z()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null)) {
      QLog.d("FastWebActivity", 1, "initArticleInfo error!");
    }
    do
    {
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.o)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID = Long.parseLong(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.o);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_c_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_c_of_type_JavaLangString;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.r)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFirstPagePicUrl = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.r;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.e)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.e;
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_d_of_type_Long != 0L) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID))) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID = ("" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_d_of_type_Long);
      }
    } while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.s));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.t = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.s;
    QLog.d("FastWebActivity", 1, "initArticleInfo, update url,url=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
  }
  
  protected MiniMsgUserParam a()
  {
    MiniMsgUserParam localMiniMsgUserParam = new MiniMsgUserParam();
    localMiniMsgUserParam.businessName = 3;
    localMiniMsgUserParam.accessType = 1;
    localMiniMsgUserParam.filterMsgType = 1;
    localMiniMsgUserParam.actionCallback = this;
    localMiniMsgUserParam.entryView = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    localMiniMsgUserParam.unreadView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131371624));
    localMiniMsgUserParam.filterMsgType = 1;
    return localMiniMsgUserParam;
  }
  
  public void a()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("arg_article_info", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    localIntent.putExtra("readinjoy_open_comment_from_image", true);
    PublicFragmentActivity.a(this, localIntent, ReadInJoyCommentListFragment.class, 1001);
  }
  
  public void a(int paramInt, float paramFloat)
  {
    float f1 = paramFloat;
    if (paramFloat > 5.0F) {
      f1 = 1.0F;
    }
    ReadInJoyHelper.a("readinjoy_font_size_ratio_sp", Float.valueOf(f1));
    TKDCommentDispatcher.INSTANCE.getEvent().onFontScaleChange(f1);
    ReportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X800B257", RIJJsonUtils.a(null, "font_size", Integer.valueOf(paramInt + 1)));
    A();
    QLog.d("FastWebActivity", 1, "onFontSizeChange,index=" + paramInt + " ,textSizeRatio=" + f1);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 2)
    {
      findViewById(2131371073).setVisibility(8);
      FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
      localFragmentTransaction.setCustomAnimations(2130771983, 2130772015);
      localFragmentTransaction.hide(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
      localFragmentTransaction.commitAllowingStateLoss();
      this.jdField_h_of_type_Boolean = false;
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jdField_b_of_type_AndroidViewView, true);
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    RIJSocialBottomUtils.a.a(paramInt1, paramInt2, paramBoolean, this, 2002, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo);
  }
  
  @VisibleForTesting
  void a(int paramInt, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramInt == 72) {
      a(paramActionSheetItem);
    }
    if (paramInt == 1)
    {
      H();
      return;
    }
    if (paramInt == 5)
    {
      I();
      return;
    }
    if (paramInt == 4)
    {
      J();
      return;
    }
    if (paramInt == 13)
    {
      K();
      return;
    }
    if (paramInt == 6)
    {
      L();
      return;
    }
    if (paramInt == 11)
    {
      M();
      return;
    }
    if (paramInt == 21)
    {
      N();
      return;
    }
    if (paramInt == 7)
    {
      O();
      return;
    }
    if (paramInt == 26)
    {
      P();
      return;
    }
    if (paramInt == 68)
    {
      Q();
      return;
    }
    if (paramInt == 70)
    {
      R();
      return;
    }
    if (paramInt == 82)
    {
      S();
      return;
    }
    if (paramInt == 19)
    {
      b(paramActionSheetItem);
      return;
    }
    c(paramInt);
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_u_of_type_Boolean = true;
    doOnPause();
    doOnStop();
    VideoReport.pageLogicDestroy(this);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterWebFastAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterWebFastAdapter.d();
    }
    this.jdField_u_of_type_Boolean = false;
    FastWebActivityStackUtil.SaveState localSaveState = new FastWebActivityStackUtil.SaveState();
    localSaveState.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    localSaveState.jdField_a_of_type_AndroidOsParcelable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.onSaveInstanceState();
    localSaveState.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localSaveState.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher;
    localSaveState.jdField_a_of_type_Boolean = this.jdField_p_of_type_Boolean;
    localSaveState.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventFastWebAdapterShowHelper = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventFastWebAdapterShowHelper;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebActivityStackUtil.a(localSaveState);
    this.jdField_b_of_type_JavaLangString = (ReadInJoyUtils.a() + System.currentTimeMillis());
    e(paramIntent);
    this.jdField_u_of_type_Boolean = true;
    doOnStart();
    doOnResume();
    this.jdField_u_of_type_Boolean = false;
    h();
    ThreadManager.getUIHandler().post(new FastWebActivity.29(this));
  }
  
  public void a(View paramView, String paramString1, String paramString2, String paramString3)
  {
    RIJDtParamBuilder localRIJDtParamBuilder = new RIJDtParamBuilder();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null) {}
    for (String str = "";; str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.j)
    {
      paramString2 = localRIJDtParamBuilder.e(str).b(Integer.valueOf(5)).a("1").f(paramString2).c(paramString3).a();
      new RIJProteusDtImpl().setDtElementIdWithParams(paramView, paramString1, paramString2.a());
      return;
    }
  }
  
  public void a(BaseData paramBaseData)
  {
    runOnUiThread(new FastWebActivity.31(this, paramBaseData));
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    boolean bool;
    if (paramInt == 2)
    {
      bool = true;
      this.jdField_k_of_type_Boolean = bool;
      if (paramInt != 0) {
        break label32;
      }
      a(paramAbsListView, this.jdField_c_of_type_Int, true);
    }
    label32:
    while (this.jdField_k_of_type_Boolean)
    {
      return;
      bool = false;
      break;
    }
    this.jdField_j_of_type_Boolean = false;
    paramAbsListView.setInterpolator(null);
  }
  
  public void a(BubblePopupWindow paramBubblePopupWindow)
  {
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = paramBubblePopupWindow;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView == null) {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  @TargetApi(23)
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      getWindow().getDecorView().setSystemUiVisibility(9216);
      return;
    }
    getWindow().getDecorView().setSystemUiVisibility(0);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    a(paramBoolean, paramString1, paramString2, 2130772354, 2130772353);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout = ((ReadInJoyCommentTopGestureLayout)this.jdField_b_of_type_AndroidViewView);
    }
    if (paramBoolean)
    {
      if ((this.jdField_z_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController != null)) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.j();
      }
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      new Bundle().putBoolean("arg_comment_list_biu_btn", false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramString1, paramString2, 1);
      if (!isFinishing())
      {
        paramString1 = getSupportFragmentManager().beginTransaction();
        paramString1.setCustomAnimations(paramInt1, paramInt2);
        paramString1.show(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
        paramString1.commitAllowingStateLoss();
      }
      this.jdField_h_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jdField_c_of_type_AndroidViewView, false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper.b();
      this.jdField_a_of_type_Int = 2;
      g(8);
      return;
    }
    if ((this.jdField_z_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController != null)) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.k();
    }
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper.a();
    if (!isFinishing())
    {
      paramString1 = getSupportFragmentManager().beginTransaction();
      if (TextUtils.isEmpty(paramString2)) {
        break label307;
      }
    }
    label307:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 0) {
        paramString1.setCustomAnimations(paramInt1, paramInt2);
      }
      paramString1.hide(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
      paramString1.commitAllowingStateLoss();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.d();
      this.jdField_h_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jdField_b_of_type_AndroidViewView, true);
      A();
      this.jdField_a_of_type_Int = 1;
      g(0);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    TimeSliceHelper.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    if (paramBoolean1)
    {
      this.jdField_s_of_type_Boolean = false;
      localArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      localArticleInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      i1 = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {}
      for (str = "2";; str = "1")
      {
        ReportUtil.a(localArticleInfo1, "0X800898C", RIJTransMergeKanDianReport.a(this, localArticleInfo2, i1, str).toString());
        if (this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2 == null) {
          this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2 = new ReadInJoyShareHelperV2(this, this.app, new FastWebActivity.FastWebSheetItemClickProcessor(this));
        }
        this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2.a().setActionSheetTitle("biu出去让更多好友看到");
        this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2.a().setOnDismissListener(new FastWebActivity.18(this));
        if (!paramBoolean2) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2.a(a(paramBoolean2), 18, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        return;
      }
    }
    this.jdField_s_of_type_Boolean = true;
    ArticleInfo localArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    ArticleInfo localArticleInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    int i1 = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {}
    for (String str = "2";; str = "1")
    {
      ReportUtil.a(localArticleInfo1, "0X8008993", RIJTransMergeKanDianReport.a(this, localArticleInfo2, i1, str).toString());
      break;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2.a(a(false), 1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
  }
  
  public List<Integer>[] a(boolean paramBoolean)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null) {
      return null;
    }
    Object localObject = URLUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
    int i2 = 0;
    int i1 = i2;
    if (((Map)localObject).containsKey("_wv")) {}
    ArrayList localArrayList;
    try
    {
      i1 = Integer.valueOf((String)((Map)localObject).get("_wv")).intValue();
      if (!((Map)localObject).containsKey("_wwv")) {}
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      for (;;)
      {
        try
        {
          i2 = Integer.valueOf((String)((Map)localObject).get("_wwv")).intValue();
          localObject = new ArrayList();
          ((List)localObject).add(Integer.valueOf(13));
          if ((i1 & 0x8) == 0L) {
            ((List)localObject).add(Integer.valueOf(2));
          }
          if ((i1 & 0x10) == 0L) {
            ((List)localObject).add(Integer.valueOf(3));
          }
          if ((i1 & 0x4000) == 0L) {
            ((List)localObject).add(Integer.valueOf(9));
          }
          if ((i1 & 0x8000) == 0L) {
            ((List)localObject).add(Integer.valueOf(10));
          }
          ((List)localObject).add(Integer.valueOf(12));
          ((List)localObject).add(Integer.valueOf(26));
          ((List)localObject).add(Integer.valueOf(5));
          if ((i1 & 0x100) == 0L) {
            ((List)localObject).add(Integer.valueOf(4));
          }
          if ((RIJAladdinUtils.d()) || (!paramBoolean)) {
            break;
          }
          return new List[] { localObject, new ArrayList() };
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          localNumberFormatException1.printStackTrace();
        }
        localNumberFormatException2 = localNumberFormatException2;
        localNumberFormatException2.printStackTrace();
        i1 = i2;
        continue;
        i2 = 0;
      }
      localArrayList = new ArrayList();
      if ((!TextUtils.isEmpty(localAppRuntime.getAccount())) && ((i1 & 0x2000) == 0L)) {
        localArrayList.add(Integer.valueOf(6));
      }
      localArrayList.add(Integer.valueOf(21));
      localArrayList.add(Integer.valueOf(7));
      if ((i1 & 0x20) == 0L) {
        localArrayList.add(Integer.valueOf(1));
      }
      localArrayList.add(Integer.valueOf(11));
      Collections.sort(localArrayList);
      if ((i2 & 0x4000) != 0L) {
        break label531;
      }
    }
    if (TeamWorkConvertUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl))
    {
      i2 = localArrayList.indexOf(Integer.valueOf(6));
      i1 = i2;
      if (i2 < 0) {
        i1 = localArrayList.indexOf(Integer.valueOf(1));
      }
      if (i1 >= 0)
      {
        if (i1 >= localArrayList.size() - 1) {
          break label603;
        }
        localArrayList.add(i1 + 1, Integer.valueOf(68));
        TeamWorkConvertUtils.a(0, 2);
      }
    }
    label531:
    if ((this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController != null) && (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a()) && (this.jdField_z_of_type_Boolean))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.c()) {
        break label619;
      }
      localArrayList.add(0, Integer.valueOf(82));
      QLog.d("FastWebActivity", 2, "mColorNoteController ： open sheet delete colorNote");
    }
    for (;;)
    {
      return new List[] { localNumberFormatException1, localArrayList };
      label603:
      localArrayList.add(Integer.valueOf(68));
      break;
      label619:
      localArrayList.add(0, Integer.valueOf(70));
      QLog.d("FastWebActivity", 2, "mColorNoteController ： open sheet add colorNote");
    }
  }
  
  protected void b()
  {
    ReportInfo localReportInfo = new ReportInfo();
    Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    if (localObject2 != null)
    {
      Object localObject3 = ((ArticleInfo)localObject2).mSocialFeedInfo;
      localObject1 = new ReportInfo.FeedsReportData();
      localReportInfo.mUin = ReadInJoyUtils.a();
      localReportInfo.mSource = ((int)((ArticleInfo)localObject2).mChannelID);
      localReportInfo.mSourceArticleId = ((ArticleInfo)localObject2).mArticleID;
      localReportInfo.mChannelId = ((int)((ArticleInfo)localObject2).mChannelID);
      localReportInfo.mAlgorithmId = ((int)((ArticleInfo)localObject2).mAlgorithmID);
      localReportInfo.mStrategyId = ((ArticleInfo)localObject2).mStrategyId;
      localReportInfo.mServerContext = ((ArticleInfo)localObject2).mServerContext;
      localReportInfo.mInnerId = ((ArticleInfo)localObject2).innerUniqueID;
      localReportInfo.mReadTimeLength = -1;
      if (localObject3 != null)
      {
        ((ReportInfo.FeedsReportData)localObject1).jdField_a_of_type_Long = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_Long;
        if (((SocializeFeedsInfo)localObject3).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null) {
          ((ReportInfo.FeedsReportData)localObject1).jdField_b_of_type_Long = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
        }
        ((ReportInfo.FeedsReportData)localObject1).jdField_a_of_type_Int = ((SocializeFeedsInfo)localObject3).jdField_b_of_type_Int;
        ((ReportInfo.FeedsReportData)localObject1).jdField_b_of_type_Int = ((SocializeFeedsInfo)localObject3).jdField_d_of_type_Int;
        localObject2 = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_JavaUtilList;
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          ((ReportInfo.FeedsReportData)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (SocializeFeedsInfo.FeedsInfoUser)((Iterator)localObject2).next();
            if (localObject3 != null) {
              ((ReportInfo.FeedsReportData)localObject1).jdField_a_of_type_JavaUtilList.add(Long.valueOf(((SocializeFeedsInfo.FeedsInfoUser)localObject3).jdField_a_of_type_Long));
            }
          }
        }
      }
      localReportInfo.mOperation = 29;
      localReportInfo.mOpSource = 12;
      localReportInfo.mFeedsReportData = ((ReportInfo.FeedsReportData)localObject1);
    }
    Object localObject1 = new ArrayList();
    ((List)localObject1).add(localReportInfo);
    ReadInJoyLogicEngine.a().a((List)localObject1);
  }
  
  public void b(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return;
    case 2: 
      ItemDatasListUtils.b(this.jdField_a_of_type_JavaUtilList);
      A();
      return;
    }
    ItemDatasListUtils.c(this.jdField_a_of_type_JavaUtilList);
    A();
  }
  
  public void c()
  {
    Object localObject = new ReadInJoyCommentUtils.CommentReportR5Builder(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null).a(1);
    QLog.d("FastWebActivity", 1, "scrollToLastReadPos | begin");
    int i1;
    if (this.jdField_v_of_type_Boolean)
    {
      QLog.d("FastWebActivity", 1, "Scroll2CommentArea");
      if (this.jdField_s_of_type_Int == 0)
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent((QQAppInterface)getAppInterface(), ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009C69", "0X8009C69", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, "", false);
        QLog.d("FastWebActivity", 1, "mCommentAreaLastFirstVisItemPos == 0 return");
        return;
      }
      this.jdField_u_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setSelectionFromTop(this.jdField_s_of_type_Int, this.jdField_t_of_type_Int);
      this.jdField_v_of_type_Boolean = false;
      this.jdField_i_of_type_Boolean = true;
      ((ReadInJoyCommentUtils.CommentReportR5Builder)localObject).d(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper.a();
      localObject = ((ReadInJoyCommentUtils.CommentReportR5Builder)localObject).a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent((QQAppInterface)getAppInterface(), ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009749", "0X8009749", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, (String)localObject, false);
      i1 = this.jdField_s_of_type_Int;
    }
    for (;;)
    {
      QLog.d("FastWebActivity", 1, "scrollToLastReadPos | done");
      a(i1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData);
      return;
      QLog.d("FastWebActivity", 1, "Scroll2ArticleArea");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setSelectionFromTop(this.jdField_q_of_type_Int, this.jdField_r_of_type_Int);
      i1 = this.jdField_q_of_type_Int;
      this.jdField_v_of_type_Boolean = true;
      ((ReadInJoyCommentUtils.CommentReportR5Builder)localObject).d(2);
      localObject = ((ReadInJoyCommentUtils.CommentReportR5Builder)localObject).a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent((QQAppInterface)getAppInterface(), ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009749", "0X8009749", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, (String)localObject, false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper.b();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterWebFastAdapter != null) {}
    for (int i1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterWebFastAdapter.getCount();; i1 = 0)
    {
      this.jdField_s_of_type_Int = i1;
      this.jdField_t_of_type_Int = 0;
      QLog.d("FastWebActivity", 1, "initCommentAreaAnchor mCommentAreaLastFirstVisItemPos = " + this.jdField_s_of_type_Int);
      return;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnBackPressed()
  {
    FastWebVideoPlayManager.a.a(ReportConstants.VideoEndType.EXIT_SCENE);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2 != null) && (this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2.a())) {}
    do
    {
      return;
      this.jdField_r_of_type_Boolean = true;
    } while (onBackEvent());
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    VideoReport.addToDetectionWhitelist(this);
    PTSDeviceUtil.init(this);
    getWindow().setFlags(16777216, 16777216);
    Bundle localBundle = a(paramBundle);
    if (localBundle == null)
    {
      AIOUtils.a("Q.readinjoy.fast_web", "  " + paramBundle, new IllegalArgumentException());
      finish();
      return true;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)localBundle.get("fast_web_article_info"));
    this.jdField_d_of_type_Int = localBundle.getInt("fast_web_from_channel_id");
    this.jdField_w_of_type_Boolean = getIntent().getBooleanExtra("from_color_note", false);
    QLog.d("FastWebActivity", 1, "is from colorNote : " + this.jdField_w_of_type_Boolean);
    this.jdField_z_of_type_Boolean = SwipeLayoutUtils.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
    {
      localBundle = localBundle.getBundle("banner_webview_extra");
      if ((localBundle != null) && (localBundle.get("fast_web_article_info") != null))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)localBundle.get("fast_web_article_info"));
        this.jdField_e_of_type_Int = localBundle.getInt("fast_web_banner_from_channel_id");
        this.jdField_l_of_type_Int = 1001;
        this.jdField_p_of_type_Boolean = localBundle.getBoolean("fast_web_from_article_recommend", false);
      }
    }
    else
    {
      this.jdField_k_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId;
      this.jdField_f_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID;
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID;
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID;
      this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
      this.jdField_b_of_type_JavaLangString = (ReadInJoyUtils.a() + System.currentTimeMillis());
      h();
      a(paramBundle);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8009C4F", "0X8009C4F", 0, 0, "", Long.toString(this.jdField_a_of_type_Long), Integer.toString(this.jdField_k_of_type_Int), "", false);
    }
    try
    {
      setContentView(2131560295);
      n();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterWebFastAdapter != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterWebFastAdapter.a();
      }
      j();
      k();
      FastWebVideoPlayManager.a.a();
      this.jdField_a_of_type_AndroidUtilSparseArray = FastWebPTSDataConverter.a();
      y();
      h(RIJFeedsDynamicInsertConfig.a.a(5));
      return true;
      setResult(-10069, getIntent());
      finish();
      return true;
    }
    catch (OutOfMemoryError paramBundle)
    {
      for (;;)
      {
        GlobalImageCache.a.evict(0);
        try
        {
          setContentView(2131560295);
          n();
        }
        catch (Throwable paramBundle)
        {
          finish();
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    af();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterWebFastAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterWebFastAdapter.d();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterFastWebMergeAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterFastWebMergeAdapter.a();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.d();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.onDestroy();
    }
    ae();
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare != null) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.c();
    }
    this.jdField_a_of_type_ComTencentBizWebviewpluginShare = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper.a();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2 != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInJoyShareHelperV2.b();
    }
    JumpAdUtils.a();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(null);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.a();
    }
    VideoAutoPlayController.a().jdField_b_of_type_Boolean = false;
    Object localObject = ReadInJoyLogicEngine.a().a();
    if (localObject != null) {
      ((FastWebModule)localObject).a();
    }
    if (this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler != null)
    {
      getMainLooper();
      Looper.myQueue().removeIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
    }
    W();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onBackground();
      if (!this.jdField_f_of_type_Boolean) {
        MiniMsgIPCServer.a(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.getParam().businessName);
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebShareUtils.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebShareUtils = null;
    ReadInJoyDropFrameHelper.a().b(5555, this);
    ReadInJoyDropFrameHelper.a().b(6666, this);
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.c();
      QLog.d("FastWebActivity", 2, "mColorNoteController.onDestroy");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData != null) {
      ReadInJoyUserInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.jdField_c_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixDataManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuAndCommentMixRIJBiuAndCommentMixDataManager.a();
    }
    localObject = ReadInJoyLogicEngine.a().a();
    if (localObject != null) {
      ((FollowListInfoModule)localObject).b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowListInfoModule$FollowStatusObserver);
    }
    AdReqFreshManager.a().a("RIJAdRefreshSceneNativeArticle");
    AdExposeFreshManager.a().a("RIJAdRefreshSceneNativeArticle");
    FastWebVideoPlayManager.a.d();
    RIJAdDownloadCache.a.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJLiveStatusModule != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJLiveStatusModule.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJLiveStatusModule$LiveStatusCallback);
    }
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    if (paramIntent != null) {}
    for (boolean bool = paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);; bool = false)
    {
      if ((paramIntent != null) && (!bool)) {
        a(paramIntent);
      }
      super.doOnNewIntent(paramIntent);
      if ((paramIntent != null) && (bool))
      {
        paramIntent.removeExtra("PhotoConst.SEND_FLAG");
        Object localObject = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          localObject = (String)((ArrayList)localObject).get(0);
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper == null) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper = new ScreenShotShareHelper(this);
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper.a((String)localObject, paramIntent.getStringExtra("image_path"), paramIntent.getIntExtra("EditPicType", 0));
        }
      }
      return;
    }
  }
  
  public void doOnPause()
  {
    if (!this.jdField_u_of_type_Boolean) {
      super.doOnPause();
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null) || (this.jdField_o_of_type_Boolean)) {}
    for (;;)
    {
      return;
      AbstractGifImage.pauseAll();
      Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      Object localObject1;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c())
      {
        localObject1 = "2";
        localObject1 = RIJTransMergeKanDianReport.a(this, (ArticleInfo)localObject2, 0, (String)localObject1);
      }
      try
      {
        float f1 = (float)(System.currentTimeMillis() - this.jdField_d_of_type_Long) / 1000.0F;
        float f2 = a();
        ((JSONObject)localObject1).put("read_time", f1);
        ((JSONObject)localObject1).put("read_ratio", f2);
        ((JSONObject)localObject1).put("session_id", this.jdField_b_of_type_JavaLangString);
        ((JSONObject)localObject1).put("channel_id", "" + ReportUtil.a(this.jdField_p_of_type_Boolean, this.jdField_b_of_type_Long));
        QLog.d("Q.readinjoy.fast_web", 2, "  time " + f1 + "  ratio : " + f2 + " session : " + this.jdField_b_of_type_JavaLangString);
        ReportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X800898E", ((JSONObject)localObject1).toString());
        long l1 = System.currentTimeMillis() - this.jdField_e_of_type_Long;
        if (!this.jdField_u_of_type_Boolean) {}
        try
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("folder_status", RIJKanDianFolderStatus.jdField_a_of_type_Int);
          ((JSONObject)localObject1).put("algorithm_id", this.jdField_f_of_type_Long);
          ((JSONObject)localObject1).put("feeds_friends_interaction", 0);
          ((JSONObject)localObject1).put("session_id", this.jdField_b_of_type_JavaLangString);
          ((JSONObject)localObject1).put("os", "1");
          ((JSONObject)localObject1).put("version", "8.5.5".replace(".", ""));
          ((JSONObject)localObject1).put("rowkey", this.jdField_a_of_type_JavaLangString);
          localObject2 = ((JSONObject)localObject1).toString();
          if (!ReadinjoyReportUtils.a(this.jdField_b_of_type_Long)) {
            break label747;
          }
          localObject1 = "0X8009359";
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 0, Long.toString(l1 / 1000L), Long.toString(this.jdField_a_of_type_Long), Integer.toString(this.jdField_k_of_type_Int), (String)localObject2, false);
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            int i1;
            QLog.e("Q.readinjoy.fast_web", 2, localJSONException, new Object[] { "0X80066FB!" });
          }
        }
        localObject1 = new ArrayList();
        localObject2 = new ReportInfo();
        ((ReportInfo)localObject2).mUin = ReadInJoyUtils.a();
        ((ReportInfo)localObject2).mSource = 0;
        ((ReportInfo)localObject2).mSourceArticleId = this.jdField_a_of_type_Long;
        ((ReportInfo)localObject2).mChannelId = ((int)this.jdField_b_of_type_Long);
        ((ReportInfo)localObject2).mAlgorithmId = ((int)this.jdField_f_of_type_Long);
        ((ReportInfo)localObject2).mStrategyId = this.jdField_k_of_type_Int;
        ((ReportInfo)localObject2).mOperation = 9;
        ((ReportInfo)localObject2).mOpSource = 12;
        ((ReportInfo)localObject2).mReadTimeLength = ((int)(l1 / 1000L));
        ((ReportInfo)localObject2).mInnerId = this.jdField_a_of_type_JavaLangString;
        i1 = b();
        ((ReportInfo)localObject2).mArticleLength = i1;
        ((ReportInfo)localObject2).mReadArticleLength = ((int)(i1 * a()));
        ((List)localObject1).add(localObject2);
        ThreadManager.getSubThreadHandler().post(new FastWebActivity.20(this, (List)localObject1));
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterWebFastAdapter != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterWebFastAdapter.c();
        }
        if (jdField_c_of_type_Boolean) {
          this.jdField_c_of_type_Long = System.currentTimeMillis();
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null) && (!this.jdField_e_of_type_Boolean)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onBackground();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.b();
          QLog.d("FastWebActivity", 2, "mColorNoteController.onPause");
        }
        FastWebVideoPlayManager.a.c();
        if ((d()) || (RIJXTabFrameUtils.a.a()))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskArticleTimer.b();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskArticleTimer.a();
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar != null)
        {
          localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar.a();
          if (localObject1 != null) {
            ((IUIDelegate)localObject1).f();
          }
        }
        if (!isFinishing()) {
          continue;
        }
        ao();
        return;
        localObject1 = "1";
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("Q.readinjoy.fast_web", 2, localException, new Object[] { "doOnPause" });
          continue;
          label747:
          localObject1 = "0X80066FB";
        }
      }
    }
  }
  
  public void doOnResume()
  {
    if (!this.jdField_u_of_type_Boolean) {
      super.doOnResume();
    }
    if (!this.jdField_u_of_type_Boolean) {
      this.jdField_e_of_type_Long = System.currentTimeMillis();
    }
    TimeUtil.b("fast_web_show_light_house_3");
    f();
    AbstractGifImage.resumeAll();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    A();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterWebFastAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebAdapterWebFastAdapter.b();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      TimeSliceHelper.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      ReadInJoyLogicEngine.a().d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    }
    AppNetConnInfo.registerConnectionChangeReceiver(this, this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    if (jdField_c_of_type_Boolean)
    {
      if (jdField_b_of_type_Boolean) {
        RIJFrameworkReportManager.a(4, this.jdField_c_of_type_Long);
      }
      m();
    }
    l();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null)
    {
      this.jdField_e_of_type_Boolean = false;
      this.jdField_f_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onForeground();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a();
      QLog.d("FastWebActivity", 2, "mColorNoteController.onResume");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowListInfoModule$FollowStatusObserver);
    }
    this.jdField_z_of_type_Int = 0;
    if (((d()) || (RIJRewardTaskArticleTimer.b())) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskArticleTimer.a(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskArticleTimer.b();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskArticleTimer.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, RIJRewardTaskConfig.c());
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar != null)
    {
      IUIDelegate localIUIDelegate = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar.a();
      if (localIUIDelegate != null) {
        localIUIDelegate.e();
      }
    }
    FastWebVideoPlayManager.a.b();
    SimpleEventBus.getInstance().dispatchEvent(new RIJFollowRecommendPopupCommand(2, null));
  }
  
  public void doOnStart()
  {
    if (!this.jdField_u_of_type_Boolean) {
      super.doOnStart();
    }
  }
  
  public void doOnStop()
  {
    if (!this.jdField_u_of_type_Boolean) {
      super.doOnStop();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return;
    }
    if ((!mAppForground) || (this.jdField_u_of_type_Boolean))
    {
      TimeSliceHelper.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper.b();
    }
    if ((isFinishing()) || (this.jdField_u_of_type_Boolean))
    {
      QLog.d("FastWebActivity", 1, "fastwebActivity doOnStop | removeCommentDataManager");
      ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    }
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      i();
    }
  }
  
  public void e()
  {
    ItemDatasListUtils.b(this.jdField_a_of_type_JavaUtilList);
    A();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.removeFooter();
  }
  
  public void f()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      ImmersiveUtils.clearCoverForStatus(getWindow(), this.isClearCoverLayer);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      this.mSystemBarComp.init();
      if (!ThemeUtil.isInNightMode(this.app)) {
        break label115;
      }
      if ((!SystemUtil.b()) && (!SystemUtil.d())) {
        this.mSystemBarComp.setStatusBarColor(-7829368);
      }
    }
    else
    {
      return;
    }
    this.mSystemBarComp.setStatusBarColor(-7829368);
    this.mSystemBarComp.setStatusBarDarkMode(true);
    return;
    label115:
    if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
    {
      a(true);
      this.mSystemBarComp.setStatusBarColor(-1);
      return;
    }
    if (!SystemUtil.d())
    {
      this.mSystemBarComp.setStatusBarColor(-2368549);
      return;
    }
    this.mSystemBarComp.setStatusBarColor(-1);
    this.mSystemBarComp.setStatusBarDarkMode(true);
  }
  
  public void finish()
  {
    QLog.d("FastWebActivity", 2, "mFloating ：finish");
    if ((this.jdField_x_of_type_Boolean) && (!this.jdField_y_of_type_Boolean))
    {
      Y();
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebActivityStackUtil.a())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController == null) {
        e(this);
      }
      if ((this.B) && (this.jdField_z_of_type_Boolean) && (this.D) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.a()) && (!this.jdField_y_of_type_Boolean))
      {
        Z();
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController != null) && (!this.jdField_y_of_type_Boolean))
      {
        Y();
        return;
      }
      if (this.jdField_l_of_type_Int == 1001)
      {
        if (this.jdField_e_of_type_Int != 70) {
          break label284;
        }
        KandianSubscribeManager.a(this, 2);
      }
      if (this.jdField_g_of_type_Long != 0L) {
        ReportUtil.a(NetConnInfoCenter.getServerTime() - this.jdField_g_of_type_Long, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, getApplicationContext());
      }
    }
    this.jdField_n_of_type_Boolean = true;
    ad();
    ag();
    aa();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    String str1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
    {
      str1 = "";
      label232:
      if (!this.jdField_r_of_type_Boolean) {
        break label366;
      }
    }
    label284:
    label366:
    for (String str2 = "1";; str2 = "2")
    {
      localIPublicAccountReportUtils.publicAccountReportClickEventForMigrate(null, "CliOper", "", str1, "0X8008995", "0X8008995", 0, 0, str2, null, null, null, false);
      am();
      QLog.d("FastWebActivity", 2, "mFloating ：finish over");
      return;
      if (this.jdField_e_of_type_Int == 0)
      {
        ReadInJoyActivityHelper.a(this.app, this, 11, 0);
        break;
      }
      if (DailyModeConfigHandler.c(this.jdField_e_of_type_Int))
      {
        KandianDailyManager.a(this);
        break;
      }
      if (!ReadInJoyHelper.m()) {
        break;
      }
      ReadInJoyActivityHelper.a(this, 11);
      break;
      str1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID + "";
      break label232;
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b())) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 10922) {
      b(paramInt2, paramIntent);
    }
    do
    {
      return;
      if (paramInt1 == 10923)
      {
        aj();
        return;
      }
      if ((paramInt1 == 117) && (paramIntent != null) && (paramInt2 == -1))
      {
        a(paramInt1, paramInt2, paramIntent);
        return;
      }
      if ((paramInt1 == 1001) && (paramIntent != null))
      {
        c(paramIntent);
        return;
      }
      if (paramInt1 == 2002)
      {
        f(paramInt2);
        return;
      }
      if (paramInt1 == 1)
      {
        e(paramInt2);
        return;
      }
      if (paramInt1 == 9999)
      {
        a(paramInt2, paramIntent);
        return;
      }
    } while ((paramInt1 != 117) || (paramIntent == null) || (paramInt2 != 1699));
    b(paramIntent);
  }
  
  public boolean onBackEvent()
  {
    boolean bool = false;
    if (this.jdField_h_of_type_Boolean)
    {
      a(false, null, null);
      g();
      bool = true;
    }
    return bool;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() != 2131369487) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131363131: 
      case 2131363132: 
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
          FastWebPTSUtils.a(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.getSubscribeUin(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, true);
        }
        break;
      case 2131369487: 
        this.jdField_r_of_type_Boolean = true;
        FastWebVideoPlayManager.a.a(ReportConstants.VideoEndType.EXIT_SCENE);
        finish();
        break;
      case 2131367277: 
        a(paramView.getTag());
        break;
      case 2131377083: 
        a(true, false);
        break;
      case 2131369534: 
        if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.isStackFromBottom()) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setStackFromBottom(true);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setStackFromBottom(false);
        break;
      case 2131371073: 
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment != null) {
          RIJTransMergeKanDianReport.a(1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(), 4);
        }
        a(false, null, null);
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null)
    {
      paramInt1 = 0;
      while (paramInt1 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildCount())
      {
        BaseItemViewHolder localBaseItemViewHolder = (BaseItemViewHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(paramInt1).getTag();
        if (localBaseItemViewHolder != null) {
          localBaseItemViewHolder.a(paramString, paramBitmap);
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onFromMiniAIOToAIO() {}
  
  public void onGoToConversation()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FastWebActivity", 2, "onGoToConversation..");
    }
    this.jdField_f_of_type_Boolean = true;
    ThreadManager.getUIHandler().post(new FastWebActivity.38(this));
  }
  
  public void onOpenMiniAIOCallback()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FastWebActivity", 2, "onOpenMiniAIOCallback..");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null))
    {
      QLog.e("FastWebActivity", 2, "onOpenMiniAIOCallback mMiniMsgUser == null || mArticleInfo == null || mFastWebInfo == null");
      return;
    }
    for (;;)
    {
      try
      {
        this.jdField_e_of_type_Boolean = true;
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.getParam();
        ((MiniMsgUserParam)localObject).backConversationIntent = RIJWebSearchUtils.a(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_d_of_type_Int, this.jdField_p_of_type_Boolean);
        ((MiniMsgUserParam)localObject).isNeedBackConversation = true;
        ArticleInfo localArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
        ArticleInfo localArticleInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
        int i1 = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c())
        {
          localObject = "2";
          ReportUtil.a(localArticleInfo1, "0X800A09C", RIJTransMergeKanDianReport.a(this, localArticleInfo2, i1, (String)localObject).toString());
          localArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
          localArticleInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
          i1 = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
          if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {
            break label227;
          }
          localObject = "2";
          ReportUtil.a(localArticleInfo1, "0X800A09D", RIJTransMergeKanDianReport.a(this, localArticleInfo2, i1, (String)localObject).toString());
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("FastWebActivity", 2, "onOpenMiniAIOCallback Exception = " + localException);
        return;
      }
      String str = "1";
      continue;
      label227:
      str = "1";
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    b(paramBundle);
    QLog.e("FastWebActivity", 2, "onSaveInstanceState(Bundle outState)");
    super.onSaveInstanceState(paramBundle);
  }
  
  public void onSaveInstanceState(Bundle paramBundle, PersistableBundle paramPersistableBundle)
  {
    b(paramBundle);
    QLog.e("FastWebActivity", 2, "onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState)");
    super.onSaveInstanceState(paramBundle, paramPersistableBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity
 * JD-Core Version:    0.7.0.1
 */