package com.tencent.biz.pubaccount.readinjoy.view;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyBaseViewController;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity.SerializableMap;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.ark.ReadInJoyArkUtil;
import com.tencent.biz.pubaccount.readinjoy.ark.ReadInJoyArkViewController;
import com.tencent.biz.pubaccount.readinjoy.channelCover.ChannelCoverView;
import com.tencent.biz.pubaccount.readinjoy.common.GalleryReportedUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyAnimUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyPageItemCache;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.MessageObserver;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager;
import com.tencent.biz.pubaccount.readinjoy.engine.hb.ReadinjoyHBLogic;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasFragment;
import com.tencent.biz.pubaccount.readinjoy.logic.DiandianTopConfigManager;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadinjoyFixPosArticleManager;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyModelImpl;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentVerticalSmallVideo;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.UtilsForComponent;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyRefreshManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.LebaKDCellInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.PolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.FeedsReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.VideoExtraRepoerData;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoBehaviorsReporter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoBrightnessControl;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoRecommendManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.TimeUtil;
import com.tencent.biz.pubaccount.readinjoy.view.headers.HeaderViewController;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyFeedsHeaderViewController;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoyAnimBaseManager.PullRefreshComplete;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.biz.webviewplugin.PubAccountPreloadPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.intervideo.now.NowFromData;
import com.tencent.mobileqq.intervideo.now.NowProxy;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import com.tencent.widget.XListView.DrawFinishedListener;
import cooperation.readinjoy.ReadInJoyHelper;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mlt;
import mlu;
import mlv;
import mlx;
import mlz;
import mmc;
import mmd;
import mme;
import mmg;
import mmh;
import mmi;
import mmj;
import mmk;
import mml;
import mmm;
import mmn;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyListViewGroup
  extends ReadInJoyBaseListViewGroup
  implements View.OnClickListener, ReadInJoyBaseAdapter.OnGalleryImageClickListener, ReadInJoyBaseAdapter.OnHorizontalSubArticleClick, ReadInJoyBaseAdapter.OnLastReadRefreshListener, ReadInJoyBaseAdapter.OnSubRegionClickListener, ReadInJoyBaseListView.RefreshCallback, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener
{
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  ChannelCoverView jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelCoverChannelCoverView;
  private KandianMergeManager.MessageObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$MessageObserver = new mlz(this);
  private ReadInJoyObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private VideoAutoPlayController jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController;
  private KandianTipFloatingWindow jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianTipFloatingWindow;
  private ReadInJoyArticleAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter;
  private ReadInJoyXListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView;
  private ReadinjoySocialMsgTips jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySocialMsgTips;
  private HeaderViewController jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersHeaderViewController;
  private ReadInJoyAnimBaseManager.PullRefreshComplete jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager$PullRefreshComplete;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new mmd(this);
  protected FaceDecoder a;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new mlt(this);
  private XListView.DrawFinishedListener jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener = new mlv(this);
  private Runnable jdField_a_of_type_JavaLangRunnable = new mmk(this);
  private mmn jdField_a_of_type_Mmn;
  public boolean a;
  private int jdField_b_of_type_Int = 1;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = -1L;
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -1;
  private long jdField_e_of_type_Long;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = -1;
  private long jdField_f_of_type_Long = -1L;
  private boolean jdField_f_of_type_Boolean = true;
  private boolean g;
  private boolean h = true;
  private boolean i;
  private boolean j;
  private boolean k;
  
  public ReadInJoyListViewGroup(ReadInJoyBaseViewController paramReadInJoyBaseViewController, int paramInt1, int paramInt2, int paramInt3, ReadInJoyPageItemCache paramReadInJoyPageItemCache)
  {
    super(paramReadInJoyBaseViewController, paramInt1, paramReadInJoyPageItemCache);
    a().getLayoutInflater().inflate(2130969647, this);
    this.jdField_e_of_type_Int = paramInt2;
    this.jdField_e_of_type_Long = paramInt3;
    this.jdField_a_of_type_Mmn = new mmn(this);
    this.jdField_f_of_type_Boolean = VideoFeedsHelper.a();
    setId(2131362481);
    o();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.jdField_c_of_type_Long = ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.a());
  }
  
  public ReadInJoyListViewGroup(ReadInJoyBaseViewController paramReadInJoyBaseViewController, int paramInt1, int paramInt2, ReadInJoyPageItemCache paramReadInJoyPageItemCache)
  {
    this(paramReadInJoyBaseViewController, paramInt1, paramInt2, -1, paramReadInJoyPageItemCache);
  }
  
  public ReadInJoyListViewGroup(ReadInJoyBaseViewController paramReadInJoyBaseViewController, int paramInt, ReadInJoyPageItemCache paramReadInJoyPageItemCache)
  {
    this(paramReadInJoyBaseViewController, paramInt, -1, paramReadInJoyPageItemCache);
  }
  
  private int a()
  {
    if (this.jdField_e_of_type_Int != -1) {
      return this.jdField_e_of_type_Int;
    }
    return a().getIntent().getIntExtra("channel_type", 0);
  }
  
  private long a()
  {
    if ((c()) && (a().getIntent().getIntExtra("channel_from", -1) == 4))
    {
      Object localObject = (ReadInJoyChannelActivity.SerializableMap)a().getIntent().getSerializableExtra("channel_map_data");
      if ((localObject != null) && (((ReadInJoyChannelActivity.SerializableMap)localObject).getMap() != null))
      {
        localObject = ((ReadInJoyChannelActivity.SerializableMap)localObject).getMap();
        long l = ((Long)((Map)localObject).get("param_key_ariticle_id")).longValue();
        if (((Integer)((Map)localObject).get("param_key_channel_cover_style")).intValue() == 1) {
          return l;
        }
      }
    }
    return -1L;
  }
  
  private List a()
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a().getIntent();
    List localList = null;
    Long localLong = Long.valueOf(localIntent.getLongExtra("subscription_click_article_id", -1L));
    int m = localIntent.getIntExtra("channel_id", 0);
    if (this.jdField_a_of_type_Int == m) {
      localList = (List)localIntent.getSerializableExtra("subscription_all_article_id");
    }
    if ((localLong.longValue() > 0L) && (localList != null) && (localList.size() > 0))
    {
      localList.remove(localLong);
      localList.add(0, localLong);
    }
    return localList;
  }
  
  private void a(long paramLong)
  {
    if (this.jdField_f_of_type_Long == -1L)
    {
      this.k = true;
      this.jdField_f_of_type_Long = paramLong;
    }
  }
  
  private void a(View paramView)
  {
    if ((a() instanceof ReadInJoyNewFeedsActivity)) {
      ((ReadInJoyNewFeedsActivity)a()).b(paramView);
    }
    for (;;)
    {
      return;
      if (ReadInJoyHelper.f()) {
        try
        {
          ReadinjoyTabFrame localReadinjoyTabFrame = (ReadinjoyTabFrame)FrameHelperActivity.a((BaseActivity)a()).a(ReadinjoyTabFrame.class);
          if (localReadinjoyTabFrame != null)
          {
            localReadinjoyTabFrame.a(paramView);
            return;
          }
        }
        catch (Exception paramView)
        {
          QLog.d("ReadInJoyListViewGroup", 2, "readinjoy tab add dispatch touch event view fail ! e : " + paramView);
          paramView.printStackTrace();
        }
      }
    }
  }
  
  private void a(LinearLayout paramLinearLayout)
  {
    paramLinearLayout = (TextView)paramLinearLayout.findViewById(2131367055);
    if (paramLinearLayout != null)
    {
      paramLinearLayout.setTextColor(getContext().getResources().getColor(2131493482));
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.videoanimation", 2, " change ui state after readed");
      }
    }
  }
  
  private void a(ProteusItemView paramProteusItemView)
  {
    paramProteusItemView = (TextBase)paramProteusItemView.a().a().a("id_artilce_title");
    if (paramProteusItemView != null)
    {
      paramProteusItemView.c(getContext().getResources().getColor(2131493482));
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.videoanimation", 2, " change ui state after readed");
      }
    }
  }
  
  private void a(AdvertisementInfo paramAdvertisementInfo)
  {
    ReadinJoyActionUtil.a(a(), paramAdvertisementInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter, this.jdField_a_of_type_Int);
  }
  
  private void a(AdvertisementInfo paramAdvertisementInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    ReadinJoyActionUtil.a(a(), paramAdvertisementInfo, paramReadInJoyBaseAdapter);
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    d(paramArticleInfo);
    ReadInJoyLogicEngine.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.notifyDataSetChanged();
    TimeUtil.a("FastWebActivity.show");
    Intent localIntent = new Intent(getContext(), FastWebActivity.class);
    localIntent.putExtra("fast_web_article_info", paramArticleInfo);
    a().startActivityForResult(localIntent, 10922);
  }
  
  private void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if ((paramArticleInfo != null) && (!TextUtils.isEmpty(paramArticleInfo.innerUniqueID))) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(), paramArticleInfo.mArticleID))
      {
        m = 1;
        ReadInJoyAtlasFragment.a(a(), paramArticleInfo.innerUniqueID, 1, paramInt, paramArticleInfo.mAlgorithmID, m);
        d(paramArticleInfo);
        localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        str = "";
        if (localQQAppInterface != null) {
          str = localQQAppInterface.c();
        }
        str = GalleryReportedUtils.a(getContext(), str, 1, paramArticleInfo.mArticleID, paramInt, paramArticleInfo.innerUniqueID, paramArticleInfo.galleryReprotExdData, paramArticleInfo.articleStyle - 2, 0);
        PublicAccountReportUtils.a(null, "", "0X8008E2F", "0X8008E2F", 0, 0, "", paramArticleInfo.mArticleID + "", paramArticleInfo.mAlgorithmID + "", str, false);
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        QQAppInterface localQQAppInterface;
        String str;
        return;
        int m = 0;
      }
    }
    QLog.e("ReadInJoyListViewGroup", 2, "jumpToGallery falied articleInfo is null or rowkey is empty");
  }
  
  private void a(ArticleInfo paramArticleInfo, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Intent localIntent = new Intent(getContext(), ReadInJoyChannelActivity.class);
    localIntent.putExtra("channel_id", 56);
    localIntent.putExtra("channel_name", "视频");
    localIntent.putExtra("channel_type", 3);
    localIntent.putExtra("channel_from", 1);
    localIntent.putExtra("is_channel_activity", true);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", paramArticleInfo.mArticleID);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", paramArticleInfo.mRecommendSeq);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", true);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_HIDE_REFRESH_HEADER", true);
    boolean bool;
    if (!ReadInJoyBaseAdapter.o(paramArticleInfo))
    {
      bool = true;
      localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_IS_UGC_VIDEO", bool);
      localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_INFO", paramArticleInfo);
      int m = ReadInJoyBaseAdapter.c(paramArticleInfo);
      if ((m != 6) && (m != 28) && (m != 71)) {
        break label256;
      }
      localIntent.putExtra("is_need_show_animation_translate", true);
      localIntent.putExtra("is_need_show_animation_adapter", true);
      if (paramBoolean)
      {
        localIntent.putExtra("view_translation_animation_top", paramInt1);
        localIntent.putExtra("view_translation_animation_left", paramInt2);
      }
    }
    for (;;)
    {
      getContext().startActivity(localIntent);
      VideoReporter.jdField_a_of_type_JavaUtilHashMap.put(ReadInJoyChannelActivity.class, VideoReporter.b());
      VideoVolumeControl.a().a(false, "jumpFromKandianFeed", 1);
      return;
      bool = false;
      break;
      label256:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.notifyDataSetChanged();
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, View paramView)
  {
    VideoPlayManager.VideoPlayParam localVideoPlayParam = new VideoPlayManager.VideoPlayParam();
    localVideoPlayParam.jdField_a_of_type_Long = paramArticleInfo.mArticleID;
    localVideoPlayParam.jdField_c_of_type_Long = paramArticleInfo.mXGFileSize;
    localVideoPlayParam.jdField_g_of_type_JavaLangString = paramArticleInfo.thirdUin;
    localVideoPlayParam.jdField_h_of_type_JavaLangString = paramArticleInfo.thirdUinName;
    localVideoPlayParam.jdField_j_of_type_JavaLangString = paramArticleInfo.mSubscribeID;
    localVideoPlayParam.jdField_g_of_type_Int = paramArticleInfo.mStrategyId;
    localVideoPlayParam.jdField_f_of_type_Long = paramArticleInfo.mAlgorithmID;
    ReadinjoyVideoReportData localReadinjoyVideoReportData = new ReadinjoyVideoReportData();
    localReadinjoyVideoReportData.jdField_a_of_type_JavaLangLong = Long.valueOf(paramArticleInfo.mArticleID);
    localReadinjoyVideoReportData.jdField_a_of_type_JavaLangString = paramArticleInfo.innerUniqueID;
    if (((!ReadInJoyBaseAdapter.f(paramArticleInfo)) && (!ReadInJoyBaseAdapter.g(paramArticleInfo)) && (!ReadInJoyBaseAdapter.h(paramArticleInfo)) && (!ReadInJoyBaseAdapter.i(paramArticleInfo))) || ((!ReadInJoyBaseAdapter.o(paramArticleInfo)) || ((ReadInJoyUtils.f(paramArticleInfo)) && (!ReadInJoyBaseAdapter.o(paramArticleInfo)))))
    {
      localVideoPlayParam.jdField_e_of_type_Int = ((SocializeFeedsInfo.UGCVideoInfo)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b.get(0)).jdField_f_of_type_Int;
      localVideoPlayParam.jdField_b_of_type_Int = ((SocializeFeedsInfo.UGCVideoInfo)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b.get(0)).jdField_a_of_type_Int;
      localVideoPlayParam.jdField_c_of_type_Int = ((SocializeFeedsInfo.UGCVideoInfo)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b.get(0)).jdField_b_of_type_Int;
      localReadinjoyVideoReportData.jdField_a_of_type_Int = ((SocializeFeedsInfo.UGCVideoInfo)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b.get(0)).jdField_f_of_type_Int;
      localVideoPlayParam.jdField_a_of_type_Int = ((int)(((SocializeFeedsInfo.UGCVideoInfo)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b.get(0)).jdField_a_of_type_Long / 1000L));
      localVideoPlayParam.jdField_b_of_type_JavaLangString = ((SocializeFeedsInfo.UGCVideoInfo)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b.get(0)).jdField_d_of_type_JavaLangString;
      localVideoPlayParam.jdField_i_of_type_JavaLangString = ((SocializeFeedsInfo.UGCVideoInfo)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b.get(0)).jdField_g_of_type_JavaLangString;
      localVideoPlayParam.jdField_a_of_type_JavaLangString = ((SocializeFeedsInfo.UGCVideoInfo)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b.get(0)).jdField_i_of_type_JavaLangString;
      if ((ReadInJoyUtils.d(paramArticleInfo)) && (ReadInJoyUtils.a(paramArticleInfo)) && (paramArticleInfo.mPolymericSmallVideoCoverUrl != null)) {
        localVideoPlayParam.jdField_b_of_type_JavaLangString = paramArticleInfo.mPolymericSmallVideoCoverUrl.getFile();
      }
    }
    for (;;)
    {
      localReadinjoyVideoReportData.jdField_b_of_type_JavaLangString = paramArticleInfo.mVideoVid;
      localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData = localReadinjoyVideoReportData;
      localVideoPlayParam.jdField_c_of_type_JavaLangString = paramArticleInfo.thirdIcon;
      localVideoPlayParam.jdField_d_of_type_JavaLangString = paramArticleInfo.thirdName;
      localVideoPlayParam.jdField_e_of_type_JavaLangString = paramArticleInfo.thirdAction;
      if (paramView != null)
      {
        localObject = new int[2];
        paramView.getLocationOnScreen((int[])localObject);
        localVideoPlayParam.jdField_h_of_type_Int = localObject[0];
        localVideoPlayParam.jdField_i_of_type_Int = localObject[1];
        localVideoPlayParam.jdField_j_of_type_Int = paramView.getWidth();
        localVideoPlayParam.k = paramView.getHeight();
        if (((paramView instanceof ComponentContentVerticalSmallVideo)) && (((ComponentContentVerticalSmallVideo)paramView).jdField_a_of_type_Boolean))
        {
          localObject = ReadInJoyDisplayUtils.a(3, this.jdField_a_of_type_Int);
          int m = localVideoPlayParam.jdField_h_of_type_Int;
          localVideoPlayParam.jdField_h_of_type_Int = ((localVideoPlayParam.jdField_j_of_type_Int - ((Integer)((Pair)localObject).first).intValue()) / 2 + m);
          localVideoPlayParam.jdField_j_of_type_Int = ((Integer)((Pair)localObject).first).intValue();
        }
      }
      localObject = new ReportInfo.VideoExtraRepoerData();
      ((ReportInfo.VideoExtraRepoerData)localObject).jdField_a_of_type_Int = 409409;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(localVideoPlayParam, paramArticleInfo);
      if (this.jdField_a_of_type_Int == 0) {
        VideoReporter.a(paramArticleInfo.mArticleID, paramArticleInfo.innerUniqueID, this.jdField_a_of_type_Int, 24, -1L, (ReportInfo.VideoExtraRepoerData)localObject);
      }
      ReadInJoyLogicEngine.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      if (!(paramView instanceof ComponentContentVerticalSmallVideo)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.notifyDataSetChanged();
      }
      return;
      localVideoPlayParam.jdField_b_of_type_JavaLangString = ((SocializeFeedsInfo.UGCVideoInfo)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b.get(0)).jdField_d_of_type_JavaLangString;
      continue;
      if ((!ReadInJoyUtils.d(paramArticleInfo)) || (!ReadInJoyUtils.a(paramArticleInfo)) || (paramArticleInfo.mPolymericSmallVideoCoverUrl == null)) {
        break;
      }
      localVideoPlayParam.jdField_b_of_type_JavaLangString = paramArticleInfo.mPolymericSmallVideoCoverUrl.getFile();
      localVideoPlayParam.jdField_a_of_type_JavaLangString = paramArticleInfo.mVideoVid;
      localVideoPlayParam.jdField_e_of_type_Int = paramArticleInfo.busiType;
      localVideoPlayParam.jdField_b_of_type_Int = paramArticleInfo.mVideoJsonWidth;
      localVideoPlayParam.jdField_c_of_type_Int = paramArticleInfo.mVideoJsonHeight;
      localReadinjoyVideoReportData.jdField_a_of_type_Int = paramArticleInfo.busiType;
      localVideoPlayParam.jdField_a_of_type_Int = paramArticleInfo.mVideoDuration;
      localVideoPlayParam.jdField_i_of_type_JavaLangString = paramArticleInfo.innerUniqueID;
      localVideoPlayParam.jdField_f_of_type_JavaLangString = paramArticleInfo.mThirdVideoURL;
      localVideoPlayParam.jdField_d_of_type_Long = paramArticleInfo.mThirdVideoURLExpireTime;
    }
    if (paramArticleInfo.mVideoCoverUrl == null) {}
    for (Object localObject = null;; localObject = paramArticleInfo.mVideoCoverUrl.getFile())
    {
      localVideoPlayParam.jdField_b_of_type_JavaLangString = ((String)localObject);
      break;
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, View paramView, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if (paramArticleInfo.mFeedType == 2)
    {
      a((AdvertisementInfo)paramArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter);
      b(paramArticleInfo);
      ReadInJoyLogicEngine.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.notifyDataSetChanged();
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_Int == 0) && (!ReadInJoyUtils.d(paramArticleInfo))) {
        break;
      }
      a(paramArticleInfo, paramView);
      ReadInJoyLogicEngine.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      if (!(paramView instanceof ComponentContentVerticalSmallVideo)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.notifyDataSetChanged();
      }
    } while (!ReadInJoyUtils.f(paramArticleInfo));
    paramView = ReadinjoyReportUtils.a(getContext(), paramArticleInfo.mVideoAdsSource, paramInt3, paramArticleInfo.getInnerUniqueID(), 54, ReadinjoyReportUtils.a(paramArticleInfo), paramArticleInfo.videoReportInfo);
    PublicAccountReportUtils.a(null, "CliOper", "", String.valueOf(paramArticleInfo.mPolymericInfo.jdField_b_of_type_Long), "0X8008D33", "0X8008D33", 0, 0, Long.toString(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), paramView, false);
    return;
    ReadInJoyLogicEngine.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    paramInt3 = -1;
    if (paramArticleInfo.videoJumpChannelID > 0) {
      if (paramArticleInfo.videoJumpChannelID == 56)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.videoanimation", 2, " init translation animation for viewTop:" + paramInt1 + "view left:" + paramInt2 + "isFromItemClick:" + paramBoolean);
        }
        a(paramArticleInfo, paramInt1, paramInt2, paramBoolean);
        label277:
        paramInt1 = paramArticleInfo.videoJumpChannelID;
        b(paramArticleInfo);
      }
    }
    for (;;)
    {
      if (paramInt1 != -1)
      {
        paramView = new ReportInfo.VideoExtraRepoerData();
        paramView.jdField_a_of_type_Int = paramInt1;
        VideoReporter.a(paramArticleInfo.mArticleID, paramArticleInfo.innerUniqueID, this.jdField_a_of_type_Int, 24, -1L, paramView);
      }
      if ((ReadInJoyBaseAdapter.c(paramArticleInfo) == 6) || (ReadInJoyBaseAdapter.c(paramArticleInfo) == 28)) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.notifyDataSetChanged();
      return;
      paramView = new HashMap();
      paramView.put("param_key_insert_article_id", Long.valueOf(paramArticleInfo.mArticleID));
      ReadInJoyActivityHelper.b(a(), paramArticleInfo.videoJumpChannelID, paramArticleInfo.videoJumpChannelName, paramArticleInfo.videoJumpChannelType, 5, paramView);
      break label277;
      if (ReadInJoyHelper.d(BaseApplicationImpl.getApplication().getRuntime()) == 1)
      {
        paramInt3 = 56;
        a(paramArticleInfo, paramInt1, paramInt2, paramBoolean);
        b(paramArticleInfo);
        paramInt1 = paramInt3;
      }
      else
      {
        a(paramArticleInfo, paramView);
        paramInt1 = paramInt3;
      }
    }
  }
  
  private void a(String paramString)
  {
    a(paramString, null);
  }
  
  private void a(String paramString, Drawable paramDrawable)
  {
    findViewById(2131367096).setVisibility(8);
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = ((ViewStub)findViewById(2131367326)).inflate();
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367223));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367222));
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setEmptyView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    if (paramDrawable != null)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
      if (this.jdField_a_of_type_Int == 70)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-4473925);
        ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).topMargin = AIOUtils.a(20.0F, getResources());
      }
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130838494));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131493485));
    ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).topMargin = AIOUtils.a(10.0F, getResources());
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.g();
    boolean bool = a().getIntent().getBooleanExtra("READINJOY_VIDEO_FORCE_INSERT_HIDE_REFRESH_HEADER", false);
    a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_HIDE_REFRESH_HEADER", false);
    if (bool) {
      return;
    }
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      this.jdField_b_of_type_AndroidViewView = ((ViewStub)findViewById(2131367327)).inflate();
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(new mml(this));
    }
    if (this.jdField_a_of_type_Int == 70)
    {
      if ((paramBoolean) && (paramInt > 0)) {}
      for (localObject = getResources().getString(2131428443);; localObject = getResources().getString(2131428444))
      {
        ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131364130)).setText((CharSequence)localObject);
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_b_of_type_AndroidViewView.clearAnimation();
        ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        localObject = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView, "alpha", new float[] { 0.0F, 1.0F, 0.0F });
        ((ObjectAnimator)localObject).setDuration(2000L);
        ((ObjectAnimator)localObject).start();
        ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
        return;
      }
    }
    if (this.jdField_a_of_type_Int == 40677)
    {
      if ((paramBoolean) && (paramInt > 0)) {}
      for (localObject = String.format(getResources().getString(2131428440), new Object[] { Integer.valueOf(paramInt * 2) });; localObject = getResources().getString(2131428442)) {
        break;
      }
    }
    if ((paramBoolean) && (paramInt > 0)) {}
    for (Object localObject = String.format(getResources().getString(2131428440), new Object[] { Integer.valueOf(paramInt) });; localObject = getResources().getString(2131428442)) {
      break;
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Int == 56) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.b())) {
      return false;
    }
    long l2 = System.currentTimeMillis();
    boolean bool3;
    label93:
    boolean bool2;
    label114:
    boolean bool6;
    boolean bool4;
    label137:
    boolean bool5;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.getCount() == 0)
    {
      bool3 = true;
      if (!c()) {
        break label438;
      }
      paramBoolean = false;
      localObject2 = ((BaseActivity)a()).app;
      localObject1 = (KandianMergeManager)((QQAppInterface)localObject2).getManager(161);
      if (this.jdField_a_of_type_Int != 70) {
        break label360;
      }
      if (((KandianMergeManager)localObject1).b(2) <= 0) {
        break label355;
      }
      paramBoolean = true;
      if (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.jdField_d_of_type_Long <= 300000L) {
        break label414;
      }
      bool2 = true;
      bool6 = d();
      if ((!a()) || (this.j)) {
        break label420;
      }
      bool4 = true;
      if ((!ReadInJoyHelper.g()) || (this.jdField_a_of_type_Int != 56) || (this.jdField_e_of_type_Long != 1L) || (!((KandianMergeManager)localObject1).h())) {
        break label426;
      }
      bool5 = true;
      label172:
      if ((!bool3) && (!bool2) && (!bool6) && (!paramBoolean) && (!bool4) && (!bool5)) {
        break label432;
      }
    }
    label414:
    label420:
    label426:
    label432:
    for (boolean bool1 = true;; bool1 = false)
    {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 1, String.format("loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, isLastExitChannelOver5Min=%s, hasChannelMap=%s, hasPushMsg=%s, needForceInsertFresh=%s, hasRed=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool6), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool4), Boolean.valueOf(bool5) }));
      paramBoolean = bool1;
      if (this.jdField_a_of_type_Int != 70)
      {
        paramBoolean = bool1;
        if (this.jdField_a_of_type_Int != 56)
        {
          paramBoolean = bool1;
          if (this.jdField_a_of_type_Int != 40677) {
            paramBoolean = true;
          }
        }
      }
      if (!paramBoolean) {
        break label782;
      }
      b(true, 1);
      return true;
      bool3 = false;
      break;
      label355:
      paramBoolean = false;
      break label93;
      label360:
      if (this.jdField_a_of_type_Int != 40677) {
        break label93;
      }
      localObject2 = (WeishiManager)((QQAppInterface)localObject2).getManager(274);
      if ((((WeishiManager)localObject2).a() != null) && (((WeishiManager)localObject2).a().size() > 0))
      {
        paramBoolean = true;
        break label93;
      }
      paramBoolean = false;
      break label93;
      bool2 = false;
      break label114;
      bool4 = false;
      break label137;
      bool5 = false;
      break label172;
    }
    label438:
    Object localObject1 = ((BaseActivity)a()).app;
    Object localObject2 = (KandianMergeManager)((QQAppInterface)localObject1).getManager(161);
    label478:
    long l1;
    label497:
    int m;
    label516:
    int n;
    if (ReadInJoyHelper.a((QQAppInterface)localObject1))
    {
      bool1 = ((KandianMergeManager)localObject2).a();
      bool5 = a() instanceof ReadInJoyNewFeedsActivity;
      if (!bool5) {
        break label718;
      }
      l1 = 600000L;
      if (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.jdField_c_of_type_Long <= l1) {
        break label726;
      }
      m = 1;
      bool6 = a().getIntent().getBooleanExtra("from_search", false);
      if (a().getIntent().getIntExtra("launch_from", -1) != 8) {
        break label731;
      }
      n = 1;
      label553:
      if ((!bool3) && (!bool1) && (!bool6) && ((m == 0) || (!paramBoolean)) && (n == 0)) {
        break label736;
      }
      bool2 = true;
      label583:
      if ((m == 0) || (!paramBoolean)) {
        break label742;
      }
      bool4 = true;
      label594:
      QLog.d("ReadInJoyListViewGroup", 1, String.format("loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, hasPushMsg=%s, fromSearch=%s, lastExitKandianOver10min=%s, isInMessageKandian=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool6), Boolean.valueOf(bool4), Boolean.valueOf(bool5) }));
      if (!bool3) {
        break label748;
      }
      m = 1;
    }
    label782:
    for (;;)
    {
      paramBoolean = bool2;
      if (!bool2) {
        break;
      }
      ReadInJoyUtils.b(m);
      paramBoolean = bool2;
      break;
      localObject1 = a();
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        bool1 = true;
        break label478;
      }
      bool1 = false;
      break label478;
      label718:
      l1 = 900000L;
      break label497;
      label726:
      m = 0;
      break label516;
      label731:
      n = 0;
      break label553;
      label736:
      bool2 = false;
      break label583;
      label742:
      bool4 = false;
      break label594;
      label748:
      if (bool1)
      {
        m = 1;
      }
      else if (bool6)
      {
        m = 1;
      }
      else if ((m != 0) && (paramBoolean))
      {
        m = 6;
        continue;
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.jdField_a_of_type_Long == 0L) {}
        for (l1 = l2;; l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.jdField_a_of_type_Long)
        {
          ((ReadInJoyPageItemCache)localObject1).jdField_a_of_type_Long = l1;
          if (this.jdField_a_of_type_Int == 0) {
            ReadInJoyLogicEngine.a().e(this.jdField_a_of_type_Int);
          }
          return false;
        }
      }
      else
      {
        m = 1;
      }
    }
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayerType(2, null);
    this.jdField_b_of_type_AndroidWidgetTextView.setLayerType(2, null);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetTextView, View.ALPHA, new float[] { 0.0F, 1.0F });
    localObjectAnimator1.addListener(new mmg(this));
    localObjectAnimator1.setDuration(400L);
    localObjectAnimator1.setInterpolator(new LinearInterpolator());
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetLinearLayout, View.TRANSLATION_Y, new float[] { 0.0F, -paramInt });
    localObjectAnimator2.addListener(new mmh(this));
    localObjectAnimator2.setDuration(400L);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAlpha(0.0F);
    localObjectAnimator2.start();
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    localObjectAnimator1.start();
  }
  
  private void b(ArticleInfo paramArticleInfo)
  {
    int i2 = this.jdField_a_of_type_Int;
    Object localObject3 = ReadInJoyUtils.a(paramArticleInfo);
    int n;
    label36:
    int i1;
    label49:
    Object localObject2;
    Object localObject1;
    if (paramArticleInfo.hasChannelInfo())
    {
      m = paramArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
        break label680;
      }
      n = 0;
      if (paramArticleInfo.videoJumpChannelID <= 0) {
        break label685;
      }
      i1 = paramArticleInfo.videoJumpChannelID;
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), ReadInJoyUtils.b(paramArticleInfo.mAlgorithmID, ReadInJoyUtils.a(paramArticleInfo), this.jdField_a_of_type_Int, m), false);
      PublicAccountReportUtils.a("0X80066FA", "", "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), ReadInJoyUtils.b(paramArticleInfo.mAlgorithmID, ReadInJoyUtils.a(paramArticleInfo), this.jdField_a_of_type_Int, m));
      if ((!ReadInJoyBaseAdapter.g(paramArticleInfo)) && (!ReadInJoyBaseAdapter.f(paramArticleInfo)) && (!ReadInJoyBaseAdapter.h(paramArticleInfo)) && (!ReadInJoyBaseAdapter.i(paramArticleInfo))) {
        break label692;
      }
      localObject2 = ReadInJoyUtils.a(paramArticleInfo.mAlgorithmID, ReadInJoyUtils.a(paramArticleInfo), i2, m, n, NetworkUtil.h(getContext()), String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long), paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, ReadInJoyUtils.c(paramArticleInfo), i1, paramArticleInfo);
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Int == 0)
      {
        localObject1 = VideoReporter.a(paramArticleInfo, VideoReporter.a(i1, (String)VideoReporter.jdField_a_of_type_JavaUtilHashMap.get(ReadInJoyChannelActivity.class), (String)localObject2));
        localObject1 = VideoReporter.a(paramArticleInfo.videoReportInfo, (String)localObject1);
      }
      PublicAccountReportUtils.a(null, "CliOper", "", String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long), "0X8007625", "0X8007625", 0, 0, Long.toString(paramArticleInfo.mFeedId), paramArticleInfo.businessId + "", Integer.toString(paramArticleInfo.mStrategyId), (String)localObject1, false);
    }
    for (;;)
    {
      PublicAccountReportUtils.a("0X8007625", paramArticleInfo.mSubscribeID, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), ReadInJoyUtils.a(paramArticleInfo.mAlgorithmID, ReadInJoyUtils.a(paramArticleInfo), i2, m, n, NetworkUtil.h(getContext()), (String)localObject3, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, ReadInJoyUtils.c(paramArticleInfo), i1, paramArticleInfo));
      localObject1 = new ArrayList();
      localObject2 = new ReportInfo();
      ((ReportInfo)localObject2).mUin = ReadInJoyUtils.a();
      ((ReportInfo)localObject2).mSource = 0;
      ((ReportInfo)localObject2).mSourceArticleId = paramArticleInfo.mArticleID;
      ((ReportInfo)localObject2).mChannelId = this.jdField_a_of_type_Int;
      ((ReportInfo)localObject2).mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
      ((ReportInfo)localObject2).mStrategyId = paramArticleInfo.mStrategyId;
      ((ReportInfo)localObject2).mOperation = 1;
      ((ReportInfo)localObject2).mServerContext = paramArticleInfo.mServerContext;
      ((ReportInfo)localObject2).mReadTimeLength = -1;
      if (paramArticleInfo.mSocialFeedInfo == null) {
        break label836;
      }
      localObject3 = new ReportInfo.FeedsReportData();
      ((ReportInfo.FeedsReportData)localObject3).jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null) {
        ((ReportInfo.FeedsReportData)localObject3).jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
      }
      ((ReportInfo.FeedsReportData)localObject3).jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      ((ReportInfo.FeedsReportData)localObject3).jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
      Object localObject4 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((localObject4 == null) || (((List)localObject4).isEmpty())) {
        break label829;
      }
      ((ReportInfo.FeedsReportData)localObject3).jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject4 = ((List)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        SocializeFeedsInfo.FeedsInfoUser localFeedsInfoUser = (SocializeFeedsInfo.FeedsInfoUser)((Iterator)localObject4).next();
        if (localFeedsInfoUser != null) {
          ((ReportInfo.FeedsReportData)localObject3).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localFeedsInfoUser.jdField_a_of_type_Long));
        }
      }
      m = 0;
      break;
      label680:
      n = 1;
      break label36;
      label685:
      i1 = 56;
      break label49;
      label692:
      localObject2 = ReadInJoyUtils.a(paramArticleInfo.mAlgorithmID, ReadInJoyUtils.a(paramArticleInfo), i2, m, n, NetworkUtil.h(getContext()), (String)localObject3, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, ReadInJoyUtils.c(paramArticleInfo), i1, paramArticleInfo);
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Int == 0)
      {
        localObject1 = VideoReporter.a(paramArticleInfo, VideoReporter.a(i1, (String)VideoReporter.jdField_a_of_type_JavaUtilHashMap.get(ReadInJoyChannelActivity.class), (String)localObject2));
        localObject1 = VideoReporter.a(paramArticleInfo.videoReportInfo, (String)localObject1);
      }
      PublicAccountReportUtils.a(null, "CliOper", "", paramArticleInfo.mSubscribeID, "0X8007625", "0X8007625", 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), (String)localObject1, false);
    }
    label829:
    ((ReportInfo)localObject2).mFeedsReportData = ((ReportInfo.FeedsReportData)localObject3);
    label836:
    ((List)localObject1).add(localObject2);
    ReadInJoyLogicEngine.a().a((List)localObject1);
    if ((paramArticleInfo instanceof AdvertisementInfo)) {
      if (!ReadInJoyUtils.a(paramArticleInfo)) {
        break label890;
      }
    }
    label890:
    for (int m = NativeAdUtils.p;; m = NativeAdUtils.k)
    {
      NativeAdUtils.a(null, BaseApplicationImpl.getContext(), NativeAdUtils.jdField_a_of_type_Int, m, (AdvertisementInfo)paramArticleInfo, null, 0L);
      return;
    }
  }
  
  private void b(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramInt == 1) {
      ReadInJoyUtils.a(getContext(), paramArticleInfo, false);
    }
    while (paramInt != 2) {
      return;
    }
    ReadInJoyUtils.a(getContext(), paramArticleInfo, 3);
  }
  
  private void b(List paramList)
  {
    Object localObject = ReadInJoyUtils.a();
    if ((!ReadInJoyHelper.r((AppRuntime)localObject)) || (!ReadInJoyHelper.s((AppRuntime)localObject))) {}
    while ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    if (paramList.size() > 5) {}
    for (int m = 5;; m = paramList.size())
    {
      localObject = new ArrayList();
      int n = 0;
      while (n < m)
      {
        long l = ((Long)paramList.get(n)).longValue();
        BaseArticleInfo localBaseArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(this.jdField_a_of_type_Int, l);
        if ((localBaseArticleInfo != null) && (!ReadInJoyUtils.a(localBaseArticleInfo))) {
          ((ArrayList)localObject).add((ArticleInfo)localBaseArticleInfo);
        }
        n += 1;
      }
    }
    ReadInJoyLogicEngine.a().a().a((List)localObject);
  }
  
  private void b(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.jdField_a_of_type_Long = System.currentTimeMillis();
    ReadInJoyHelper.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.jdField_a_of_type_Long, (QQAppInterface)ReadInJoyUtils.a());
    Object localObject9 = null;
    Object localObject2 = null;
    long l2 = 0L;
    long l1 = 0L;
    Object localObject5 = null;
    Object localObject1 = null;
    Object localObject11 = null;
    Object localObject7 = null;
    Object localObject8 = null;
    boolean bool1 = false;
    Object localObject4 = null;
    boolean bool2 = false;
    boolean bool3 = false;
    Object localObject6 = null;
    Object localObject10 = null;
    int i1 = 0;
    int m = -1;
    QQAppInterface localQQAppInterface = ((BaseActivity)a()).app;
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)localQQAppInterface.getManager(161);
    if (this.jdField_a_of_type_Int == 0)
    {
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.jdField_a_of_type_Boolean) {
        break label1617;
      }
      localObject1 = a();
      bool3 = b();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.jdField_a_of_type_Boolean = false;
      if (a().getIntent().getIntExtra("launch_from", -1) == 8)
      {
        bool1 = true;
        localObject5 = (LebaKDCellInfo)a().getIntent().getSerializableExtra("param_leba_cell_articleinfo");
        bool2 = bool1;
        bool1 = bool3;
      }
    }
    for (;;)
    {
      int n;
      if (localObject1 == null)
      {
        localObject1 = localKandianMergeManager.b();
        if ((localObject1 != null) && (((List)localObject1).size() > 2))
        {
          l1 = ((Long)((List)localObject1).get(((List)localObject1).size() - 2)).longValue();
          l2 = ((Long)((List)localObject1).get(((List)localObject1).size() - 1)).longValue();
          localObject1 = ((List)localObject1).subList(0, ((List)localObject1).size() - 2);
          localObject2 = localKandianMergeManager.a();
          m = 1;
          bool3 = a().getIntent().getBooleanExtra("from_lock_screen", false);
          if (a().getIntent().getIntExtra("launch_from", -1) == 6) {}
          for (n = 1;; n = 0)
          {
            if (!bool3)
            {
              localObject4 = localObject1;
              if (n == 0) {
                break label461;
              }
            }
            localObject6 = localKandianMergeManager.a();
            localObject4 = localObject1;
            if (localObject6 == null) {
              break label461;
            }
            n = ((List)localObject6).size() - 1;
            while (n >= 0)
            {
              localObject7 = (Long)((List)localObject6).get(n);
              localObject4 = localObject1;
              if (localObject1 == null) {
                localObject4 = new ArrayList();
              }
              if (!((List)localObject4).contains(localObject7)) {
                ((List)localObject4).add(0, localObject7);
              }
              n -= 1;
              localObject1 = localObject4;
            }
            bool1 = false;
            break;
          }
          localObject4 = localObject1;
          label461:
          localKandianMergeManager.e();
          localKandianMergeManager.d();
          localObject1 = localObject4;
        }
      }
      for (;;)
      {
        localObject4 = localKandianMergeManager.a();
        localKandianMergeManager.l();
        if (ReadInJoyUtils.e())
        {
          n = 32;
          ReadInJoyUtils.b(false);
          localObject6 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject6;
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter != null) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(paramBoolean);
          }
          if (localObject4 == null)
          {
            localObject6 = null;
            label536:
            if (localObject4 != null) {
              break label1406;
            }
            localObject4 = null;
            label544:
            if (this.jdField_a_of_type_Int != 70) {
              break label1419;
            }
            ReadInJoyLogicEngine.a().b(true);
            DiandianTopConfigManager.a().a(true);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setNoMoreData(false);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.jdField_c_of_type_Int = 1;
            this.jdField_b_of_type_Int += 1;
            if ((a() instanceof ReadInJoyNewFeedsActivity)) {
              a(-2);
            }
            return;
            if ((a()) && (!this.j))
            {
              l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
              bool1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a().getIntent().getBooleanExtra("READINJOY_VIDEO_FORCE_INSERT_IS_UGC_VIDEO", false);
              this.j = true;
              this.i = true;
              if (bool1)
              {
                localObject2 = (ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a().getIntent().getParcelableExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_INFO");
                if (localObject2 == null) {
                  break label1560;
                }
                localObject1 = new Pair(((ArticleInfo)localObject2).getInnerUniqueID(), ((ArticleInfo)localObject2).mTitle);
                localObject4 = new JSONObject();
              }
            }
          }
          for (;;)
          {
            try
            {
              ((JSONObject)localObject4).put("ArticleId", ReadInJoyUtils.a(((ArticleInfo)localObject2).mArticleID));
              ((JSONObject)localObject4).put("FeedsId", ReadInJoyUtils.a(((ArticleInfo)localObject2).mFeedId));
              ((JSONObject)localObject4).put("algorithmIds", 0);
              ((JSONObject)localObject4).put("biuUin", 0);
              localObject2 = new JSONObject();
              ((JSONObject)localObject2).put("socialFeedsType", 1);
              ((JSONObject)localObject4).put("extension", localObject2);
              ((JSONObject)localObject4).put("feedsType", 1);
              ((JSONObject)localObject4).put("id", 0);
              ((JSONObject)localObject4).put("network_type", 1);
              ((JSONObject)localObject4).put("orange", "");
              ((JSONObject)localObject4).put("pushMessage", "");
              ((JSONObject)localObject4).put("push_type", 0);
              ((JSONObject)localObject4).put("strategyIds", 0);
              ((JSONObject)localObject4).put("title", "");
              ((JSONObject)localObject4).put("uin", localQQAppInterface.getLongAccountUin());
              localObject2 = ((JSONObject)localObject4).toString();
              localObject5 = null;
              localObject4 = localObject2;
              localObject2 = localObject5;
              m = 5;
              bool1 = false;
              localObject5 = localObject4;
              l2 = 0L;
              l1 = 0L;
              localObject4 = localObject1;
              localObject1 = localObject5;
              localObject5 = localObject6;
              n = i1;
            }
            catch (JSONException localJSONException)
            {
              localJSONException.printStackTrace();
              localObject3 = null;
              continue;
            }
            localObject3 = new ArrayList();
            ((List)localObject3).add(Long.valueOf(l1));
            localObject1 = null;
            localObject4 = localObject5;
            continue;
            if (this.jdField_a_of_type_Int == 70)
            {
              bool1 = false;
              localObject1 = null;
              l2 = 0L;
              l1 = 0L;
              localObject5 = localObject6;
              n = i1;
              break;
            }
            if ((this.jdField_a_of_type_Int == 56) && (this.jdField_e_of_type_Long == 1L))
            {
              localObject5 = localKandianMergeManager.a();
              if (localObject5 == null) {
                break label1547;
              }
              if (((KandianRedDotInfo)localObject5).hasArticleID())
              {
                localObject3 = ((KandianRedDotInfo)localObject5).articleIDList;
                localObject1 = ((KandianRedDotInfo)localObject5).cookie;
                l2 = ((KandianRedDotInfo)localObject5).algorithmID;
                l1 = ((KandianRedDotInfo)localObject5).strategyID;
                m = 1;
                n = 10;
                label1116:
                localKandianMergeManager.n();
              }
            }
            for (;;)
            {
              long l3 = l1;
              l1 = l2;
              bool1 = false;
              l2 = l3;
              localObject5 = localObject6;
              break;
              localObject3 = null;
              n = 6;
              break label1116;
              if (this.jdField_a_of_type_Int == 40677)
              {
                localObject8 = (WeishiManager)localQQAppInterface.getManager(274);
                localObject3 = localObject9;
                n = m;
                localObject1 = localObject7;
                if (((WeishiManager)localObject8).a() != null)
                {
                  localObject3 = localObject9;
                  n = m;
                  localObject1 = localObject7;
                  if (((WeishiManager)localObject8).a().size() > 0)
                  {
                    localObject5 = new ArrayList(((WeishiManager)localObject8).a());
                    m = 8;
                    localObject3 = localObject5;
                    n = m;
                    localObject1 = localObject7;
                    if (!TextUtils.isEmpty(((WeishiManager)localObject8).a()))
                    {
                      localObject1 = ((WeishiManager)localObject8).a();
                      n = m;
                      localObject3 = localObject5;
                    }
                  }
                }
                ((WeishiManager)localObject8).a(a());
                bool1 = false;
                l2 = 0L;
                l1 = 0L;
                m = n;
                localObject5 = localObject6;
                n = i1;
                break;
              }
              l1 = a();
              localObject1 = (ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.b(0);
              if ((l1 != -1L) && (localObject1 != null) && (l1 != ((ArticleInfo)localObject1).mArticleID))
              {
                localObject3 = new ArrayList();
                ((List)localObject3).add(Long.valueOf(l1));
                m = 6;
                bool1 = false;
                localObject1 = null;
                l2 = 0L;
                l1 = 0L;
                localObject5 = localObject6;
                n = i1;
                break;
                localObject6 = ((Pair)localObject4).first;
                break label536;
                label1406:
                localObject4 = (String)((Pair)localObject4).second;
                break label544;
                label1419:
                localObject8 = ReadInJoyLogicEngine.a();
                i1 = this.jdField_a_of_type_Int;
                int i2 = this.jdField_b_of_type_Int;
                if ((localObject6 instanceof String))
                {
                  localObject7 = (String)localObject6;
                  label1451:
                  if (!(localObject6 instanceof Long)) {
                    break label1516;
                  }
                }
                label1516:
                for (l3 = ((Long)localObject6).longValue();; l3 = -1L)
                {
                  ((ReadInJoyLogicEngine)localObject8).a(i1, (List)localObject3, m, true, bool1, i2, (String)localObject7, l3, (String)localObject4, a(), l1, l2, (String)localObject1, paramInt, bool2, (LebaKDCellInfo)localObject5, n);
                  break;
                  localObject7 = null;
                  break label1451;
                }
              }
              bool1 = false;
              localObject1 = null;
              l2 = 0L;
              l1 = 0L;
              localObject5 = localObject6;
              n = i1;
              break;
              label1547:
              localObject3 = null;
              n = 2;
              localObject1 = localObject11;
            }
            label1560:
            localObject1 = null;
            localObject3 = localObject8;
          }
          localObject6 = localObject3;
          localObject3 = localObject1;
          localObject1 = localObject6;
          n = i1;
        }
        m = -1;
        Object localObject3 = null;
        l2 = 0L;
        l1 = 0L;
        break;
        m = -1;
        localObject3 = null;
        l2 = 0L;
        l1 = 0L;
      }
      label1617:
      localObject1 = null;
      bool2 = bool3;
      localObject5 = localObject10;
    }
  }
  
  private boolean b()
  {
    List localList = (List)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a().getIntent().getSerializableExtra("subscription_all_article_id");
    if ((localList != null) && (localList.size() > 0)) {}
    for (long l = ((Long)localList.get(0)).longValue(); Long.valueOf(l).longValue() != 0L; l = -1L) {
      return true;
    }
    return false;
  }
  
  private void c(ArticleInfo paramArticleInfo)
  {
    ReadinJoyActionUtil.a(a(), paramArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter, this.jdField_a_of_type_Int);
  }
  
  private void c(Map paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext())
    {
      Object localObject2 = (BaseReportData)paramMap.next();
      if (!((BaseReportData)localObject2).jdField_b_of_type_Boolean)
      {
        ((BaseReportData)localObject2).jdField_b_of_type_Boolean = true;
        ReportInfo localReportInfo = new ReportInfo();
        localReportInfo.mUin = ReadInJoyUtils.a();
        localReportInfo.mSource = 0;
        localReportInfo.mSourceArticleId = ((BaseReportData)localObject2).jdField_a_of_type_JavaLangLong.longValue();
        localReportInfo.mChannelId = this.jdField_a_of_type_Int;
        localReportInfo.mAlgorithmId = ((int)((BaseReportData)localObject2).jdField_a_of_type_Long);
        localReportInfo.mStrategyId = ((BaseReportData)localObject2).jdField_b_of_type_Int;
        localReportInfo.mOperation = 7;
        localReportInfo.mServerContext = ((BaseReportData)localObject2).jdField_a_of_type_ArrayOfByte;
        localReportInfo.mReadTimeLength = -1;
        Object localObject1;
        if (this.jdField_a_of_type_Int == 56)
        {
          localReportInfo.mOpSource = 11;
          localObject1 = new ReportInfo.VideoExtraRepoerData();
          if (this.jdField_d_of_type_Long != 0L) {
            break label569;
          }
        }
        label569:
        for (int m = 1;; m = 0)
        {
          ((ReportInfo.VideoExtraRepoerData)localObject1).jdField_c_of_type_Int = m;
          localObject1 = ((ReportInfo.VideoExtraRepoerData)localObject1).toString();
          localReportInfo.mInnerId = ((BaseReportData)localObject2).jdField_e_of_type_JavaLangString;
          if (QLog.isColorLevel()) {
            QLog.d("VideoReporter", 2, "reportVideoUserOperationByOidbOfFeed--mUin:" + localReportInfo.mUin + "; mSource:" + localReportInfo.mSource + "; mOpSource:" + localReportInfo.mOpSource + "; mInnerId:" + localReportInfo.mInnerId + "; mChannelId:" + localReportInfo.mChannelId + "; mAlgorithmId:" + localReportInfo.mAlgorithmId + "; mStrategyId:" + localReportInfo.mStrategyId + "; mOperation:" + localReportInfo.mOperation + "; mPlayTimeLength:" + localReportInfo.mPlayTimeLength + "; videoExtraRepoerData:" + (String)localObject1);
          }
          if ((((BaseReportData)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) || (((BaseReportData)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo == null)) {
            break label581;
          }
          localObject1 = new ReportInfo.FeedsReportData();
          ((ReportInfo.FeedsReportData)localObject1).jdField_a_of_type_Long = ((BaseReportData)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
          if (((BaseReportData)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null) {
            ((ReportInfo.FeedsReportData)localObject1).jdField_b_of_type_Long = ((BaseReportData)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
          }
          ((ReportInfo.FeedsReportData)localObject1).jdField_a_of_type_Int = ((BaseReportData)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
          ((ReportInfo.FeedsReportData)localObject1).jdField_b_of_type_Int = ((BaseReportData)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
          localObject2 = ((BaseReportData)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
          if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
            break;
          }
          ((ReportInfo.FeedsReportData)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            SocializeFeedsInfo.FeedsInfoUser localFeedsInfoUser = (SocializeFeedsInfo.FeedsInfoUser)((Iterator)localObject2).next();
            if (localFeedsInfoUser != null) {
              ((ReportInfo.FeedsReportData)localObject1).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localFeedsInfoUser.jdField_a_of_type_Long));
            }
          }
        }
        localReportInfo.mFeedsReportData = ((ReportInfo.FeedsReportData)localObject1);
        label581:
        localArrayList.add(localReportInfo);
      }
    }
    if (!localArrayList.isEmpty()) {
      ReadInJoyLogicEngine.a().a(localArrayList);
    }
  }
  
  private boolean c()
  {
    return this.jdField_a_of_type_Int != 0;
  }
  
  private void d(ArticleInfo paramArticleInfo)
  {
    ReadinJoyActionUtil.a(a(), paramArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter, this.jdField_a_of_type_Int);
  }
  
  private boolean d()
  {
    if ((c()) && (a().getIntent().getIntExtra("channel_from", -1) == 4))
    {
      Object localObject = (ReadInJoyChannelActivity.SerializableMap)a().getIntent().getSerializableExtra("channel_map_data");
      if ((localObject != null) && (((ReadInJoyChannelActivity.SerializableMap)localObject).getMap() != null))
      {
        localObject = ((ReadInJoyChannelActivity.SerializableMap)localObject).getMap();
        ((Long)((Map)localObject).get("param_key_ariticle_id")).longValue();
        if (((Integer)((Map)localObject).get("param_key_channel_cover_style")).intValue() == 1) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void e(ArticleInfo paramArticleInfo)
  {
    TimeUtil.b("fast_web_show_light_house_1");
    FastWebModule localFastWebModule = ReadInJoyLogicEngine.a().a();
    if (localFastWebModule != null) {
      this.jdField_f_of_type_Int = localFastWebModule.a(paramArticleInfo.mArticleContentUrl, String.valueOf(paramArticleInfo.innerUniqueID), paramArticleInfo.mSubscribeID, 1, null);
    }
    a(paramArticleInfo);
  }
  
  private void o()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = ((ReadInJoyXListView)findViewById(2131367323));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367324));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131367325));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367329));
    Object localObject;
    if ((this.jdField_a_of_type_Int == 0) && (ReadInJoyHelper.h()))
    {
      localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).setMargins(((FrameLayout.LayoutParams)localObject).leftMargin, ((FrameLayout.LayoutParams)localObject).topMargin, ViewUtils.a(34.0F), ViewUtils.a(130.0F));
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new mme(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setContentBackground(2130838219);
    if (this.jdField_a_of_type_Int == 0)
    {
      h();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setChannelId(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOnItemClickListener(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setRefreshCallback(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOnItemLongClickListener(this);
      if (this.jdField_a_of_type_Int == 0)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOverScrollTouchMode(1);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOverScrollFlingMode(1);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setDrawFinishedListener(this.jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController = VideoAutoPlayController.a(a().getApplicationContext());
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(a(), ((BaseActivity)a()).app);
      if (this.jdField_a_of_type_Int != 56) {
        break label674;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter = new ReadInJoyArticleAdapter(a(), a().getLayoutInflater(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder);
      this.jdField_d_of_type_Long = a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      VideoReporter.jdField_a_of_type_Int = VideoReporter.a(a().getIntent().getIntExtra("channel_from", -1));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setContentBackground(new ColorDrawable(-1));
      label356:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.b(a());
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a() != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a());
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter);
      w();
      p();
      ReadinjoyFixPosArticleManager.a().a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter);
      ((BaseActivity)a()).app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      ((KandianMergeManager)ReadInJoyUtils.a().getManager(161)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$MessageObserver);
      boolean bool = a().getIntent().getBooleanExtra("is_need_show_animation_translate", false);
      long l = a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", 0L);
      localObject = ReadInJoyLogicEngine.a().a(0, l);
      if ((bool) && ((a() instanceof ReadInJoyChannelActivity)))
      {
        if (!this.jdField_f_of_type_Boolean) {
          break label753;
        }
        m = ReadInJoyBaseAdapter.c((ArticleInfo)localObject);
        if ((m != 6) && (m != 71)) {
          break label711;
        }
        this.jdField_d_of_type_Int = a().getIntent().getIntExtra("view_translation_animation_left", 0);
        this.jdField_c_of_type_Int = a().getIntent().getIntExtra("view_translation_animation_top", 0);
        ReadInJoyAnimUtils.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, (ArticleInfo)localObject, a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter, this.jdField_a_of_type_Int, this.jdField_d_of_type_Int, this.jdField_c_of_type_Int);
        b(this.jdField_c_of_type_Int);
      }
    }
    label674:
    label711:
    while (m != 28)
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAnimType(0);
      break;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter = new ReadInJoyArticleAdapter(a(), a().getLayoutInflater(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder);
      break label356;
    }
    int m = ReadInJoyHelper.f(ReadInJoyUtils.a());
    ReadInJoyAnimUtils.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, (ArticleInfo)localObject, a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter, this.jdField_a_of_type_Int, 0, m);
    b(m);
    return;
    label753:
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.h();
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersHeaderViewController = new ReadInJoyFeedsHeaderViewController(getContext());
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersHeaderViewController != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersHeaderViewController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
      }
      return;
      if (this.jdField_a_of_type_Int == 56)
      {
        if (ReadInJoyHelper.C(ReadInJoyUtils.a()) != 2)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelCoverChannelCoverView = new ChannelCoverView(a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
          a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelCoverChannelCoverView.a());
        }
      }
      else if (this.jdField_a_of_type_Int == 70) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersHeaderViewController = new ReadInJoyDiandianHeaderController(getContext());
      }
    }
  }
  
  private void q()
  {
    VideoPlayManager localVideoPlayManager = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a();
    if ((localVideoPlayManager != null) && (localVideoPlayManager.a() != null)) {
      localVideoPlayManager.b(11);
    }
  }
  
  private void r()
  {
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {}
    try
    {
      Parcelable localParcelable = ((ReadInJoyLogicManager)ReadInJoyUtils.a().getManager(162)).a().a(this.jdField_a_of_type_Int);
      if (localParcelable != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.onRestoreInstanceState(localParcelable);
        QLog.d("ReadInJoyListViewGroup", 1, new Object[] { "channelID: ", Integer.valueOf(this.jdField_a_of_type_Int), " restoreToHistoryPos." });
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        QLog.d("ReadInJoyListViewGroup", 1, "restoreToHistoryPos Exception.");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "restoreToHistoryPos cost: ", Long.valueOf(System.currentTimeMillis() - l) });
    }
  }
  
  private void s()
  {
    long l1;
    int m;
    Object localObject1;
    if (a())
    {
      l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      long l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", 0L);
      m = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a().getIntent().getIntExtra("READINJOY_VIDEO_FORCE_INSERT_TOW_VIDEO_ITEM_INDEX", 0);
      localObject1 = ReadInJoyLogicEngine.a().a(0, l2);
      if ((m != 2) || (localObject1 == null) || (((ArticleInfo)localObject1).mSubArtilceList == null) || (((ArticleInfo)localObject1).mSubArtilceList.size() != 1)) {
        break label676;
      }
      localObject1 = (ArticleInfo)((ArticleInfo)localObject1).mSubArtilceList.get(0);
    }
    label670:
    label676:
    for (;;)
    {
      ArticleInfo localArticleInfo;
      Object localObject2;
      List localList;
      if (localObject1 != null)
      {
        localArticleInfo = ((ArticleInfo)localObject1).clone();
        localObject2 = ReadInJoyLogicEngine.a().a(Integer.valueOf(56));
        localList = a().a();
        if ((localList != null) && (!localList.isEmpty()) && (localObject2 != null) && (!((List)localObject2).isEmpty())) {
          break label222;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "handleJump2VideoChannelForceInsert(): adapterSeqList is empty, just ignore.");
        }
      }
      return;
      label222:
      if (((List)localObject2).contains(Long.valueOf(l1)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "handleJump2VideoChannelForceInsert(): 发现强插重复, need to delete old, sourceArticleInfo =" + localObject1);
        }
        localObject2 = ReadInJoyLogicEngine.a().b(Integer.valueOf(56));
        if (localObject2 == null) {
          break label670;
        }
        Iterator localIterator = ((List)localObject2).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject2 = (ArticleInfo)localIterator.next();
        } while (((ArticleInfo)localObject2).mArticleID != l1);
      }
      for (;;)
      {
        if (localObject2 != null)
        {
          ReadInJoyLogicEngine.a().a(56, (BaseArticleInfo)localObject2, Boolean.valueOf(false));
          boolean bool = localList.remove(localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "delete duplicateArticleInfo: " + localObject2 + ", deleteDuplicateSuccess= " + bool);
          }
        }
        l1 = Long.valueOf(((BaseArticleInfo)localList.get(0)).mRecommendSeq).longValue();
        localArticleInfo.mRecommendSeq = (1L + l1);
        localArticleInfo.mChannelID = 56L;
        if (localArticleInfo.isTwoItemVideoFeed()) {
          localArticleInfo.mSubArtilceList = null;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "handleJump2VideoChannelForceInsert(): sourceArticleInfo =" + localObject1 + ",firtstArticleSeq=" + l1 + "， insert cloneInfo=" + localArticleInfo);
        }
        localObject1 = new ArrayList();
        ((List)localObject1).add(localArticleInfo);
        ReadInJoyLogicEngine.a().a(Integer.valueOf(56), (List)localObject1, true);
        localList.add(0, localArticleInfo);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.notifyDataSetChanged();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter);
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelCoverChannelCoverView == null) {}
        for (m = 0;; m = 1)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setSelectionFromTop(m, 0);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, ReadInJoyBaseAdapter.jdField_b_of_type_Int);
          return;
        }
        localObject2 = null;
      }
    }
  }
  
  private void t()
  {
    this.k = false;
  }
  
  private void u()
  {
    ArticleInfo localArticleInfo = ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_Int, this.jdField_f_of_type_Long);
    String str;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("articleInfo = ");
      if (localArticleInfo == null)
      {
        str = "null";
        QLog.d("ReadInJoyListViewGroup", 2, str);
      }
    }
    else
    {
      if (localArticleInfo != null) {
        break label73;
      }
    }
    label73:
    boolean bool;
    do
    {
      do
      {
        return;
        str = localArticleInfo.toString();
        break;
      } while (localArticleInfo.mPUinIsActive);
      bool = ReadInJoyUtils.d();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyListViewGroup", 2, "neadShowNoActiveTipsFlag = " + bool);
      }
    } while (!bool);
    ReadInJoyUtils.a(false);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianTipFloatingWindow != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianTipFloatingWindow.a())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianTipFloatingWindow.a(false);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.b();
  }
  
  private void v()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.getItem(0);
    if ((this.jdField_a_of_type_Int == 0) && ((localObject instanceof ArticleInfo)))
    {
      localObject = (ArticleInfo)localObject;
      if (localObject != null)
      {
        this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)localObject);
        localObject = PublicAccountUtil.b((QQAppInterface)ReadInJoyUtils.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        String str = PublicAccountUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        PublicAccountUtil.a(((BaseActivity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a()).app, str, String.valueOf(this.jdField_a_of_type_Long), (String)localObject, true);
      }
    }
  }
  
  private void w()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    View localView = findViewById(2131367096);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setEmptyView(localView);
    localView.setOnClickListener(null);
  }
  
  private void x()
  {
    this.h = false;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      PublicTracker.a("recommend_tab_cost", null);
      return;
    case 56: 
      PublicTracker.a("video_tab_cost", null);
      return;
    }
    PublicTracker.a("subscribe_tab_cost", null);
  }
  
  public ReadInJoyArticleAdapter a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView == null) {
      return;
    }
    a(true);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianTipFloatingWindow == null) {}
    while ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianTipFloatingWindow.a()) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianTipFloatingWindow.a() != 0)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianTipFloatingWindow.a(false);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 9991) {
      a(2, paramIntent);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramInt1 == 9091)
            {
              a(0, paramIntent);
              return;
            }
            if (paramInt1 != 9993) {
              break;
            }
          } while (paramInt2 != 1);
          a();
          return;
          if (paramInt1 != 21) {
            break;
          }
        } while ((paramInt2 != -1) || (paramIntent == null));
        ForwardUtils.a((QQAppInterface)ReadInJoyUtils.a(), a(), a().getApplicationContext(), paramIntent, null);
        return;
        if (paramInt1 == 2)
        {
          a(2, paramIntent);
          return;
        }
        if (paramInt1 == 1)
        {
          a(1, paramIntent);
          return;
        }
        if (paramInt1 == 32000)
        {
          ReadinjoyHBLogic.a().a();
          a(1, paramIntent);
          return;
        }
      } while ((paramInt1 != 10922) || (paramInt2 != -10069) || (paramIntent == null));
      paramIntent = (ArticleInfo)paramIntent.getExtras().get("fast_web_article_info");
    } while (paramIntent == null);
    c(paramIntent);
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(paramInt, paramIntent);
  }
  
  public void a(int paramInt, List paramList)
  {
    PublicTracker.a(null, "KANDIAN_NEW_FEEDS_ON_CHANNEL_ARTICLE_LOADED");
    if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter == null)) {
      return;
    }
    Object localObject1;
    Object localObject2;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.jdField_b_of_type_Boolean = true;
      setAdapterData(ReadInJoyLogicEngine.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList), 1);
      if (paramInt == 70)
      {
        localObject1 = ReadInJoyUtils.a();
        if (localObject1 != null)
        {
          paramInt = ((KandianMergeManager)((AppRuntime)localObject1).getManager(161)).a();
          if ((paramInt >= 0) && (paramList.size() >= paramInt)) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setNoMoreData(true);
          }
        }
      }
      Object localObject3;
      if (!paramList.isEmpty())
      {
        localObject1 = (Long)paramList.get(0);
        localObject2 = ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_Int, ((Long)localObject1).longValue());
        localObject3 = new StringBuilder().append("load history successful ! first article title : ");
        if (localObject2 == null) {
          break label353;
        }
        localObject1 = ((ArticleInfo)localObject2).mTitle;
        localObject1 = ReadInJoyUtils.d((String)localObject1);
        localObject3 = new StringBuilder().append((String)localObject1).append(" articleID : ");
        if (localObject2 == null) {
          break label361;
        }
      }
      label353:
      label361:
      for (localObject1 = Long.valueOf(((ArticleInfo)localObject2).mArticleID);; localObject1 = "-1")
      {
        localObject1 = localObject1;
        QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 1, (String)localObject1);
        if (!QLog.isColorLevel()) {
          break label401;
        }
        localObject1 = new StringBuilder("onChannelArticleLoaded ");
        localObject2 = paramList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Long)((Iterator)localObject2).next();
          ((StringBuilder)localObject1).append("recommendSeq = " + localObject3 + ",\n ");
        }
        localObject1 = "";
        break;
      }
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 1, ((StringBuilder)localObject1).toString());
    }
    label401:
    if ((paramList != null) && (!paramList.isEmpty()) && (this.jdField_a_of_type_Int == 0))
    {
      this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_Int, ((Long)paramList.get(0)).longValue());
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
      {
        localObject1 = PublicAccountUtil.b((QQAppInterface)ReadInJoyUtils.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        localObject2 = PublicAccountUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        PublicAccountUtil.a(((BaseActivity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a()).app, (String)localObject2, String.valueOf(this.jdField_a_of_type_Long), (String)localObject1, false);
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.jdField_b_of_type_Long = 0L;
    if (!this.g)
    {
      bool1 = true;
      this.jdField_e_of_type_Boolean = a(bool1);
      if (a().getIntent().getIntExtra("launch_from", 5) != 11) {
        break label797;
      }
    }
    label797:
    for (int m = 1;; m = 0)
    {
      paramInt = 0;
      try
      {
        localObject1 = ((KandianMergeManager)ReadInJoyUtils.a().getManager(161)).f();
        if (localObject1 == null) {
          break label937;
        }
        int n = ((KandianOx210MsgInfo)localObject1).jdField_a_of_type_Int;
        if (n <= 0) {
          break label937;
        }
        paramInt = 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          long l;
          localException.printStackTrace();
          continue;
          bool1 = ReadInJoyUtils.a(((ReadInJoyNewFeedsActivity)a()).b());
          continue;
          if (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.jdField_d_of_type_Long < ReadInJoyPageItemCache.jdField_a_of_type_Int) {}
          for (boolean bool2 = true;; bool2 = false)
          {
            bool1 = bool2;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "isNeedToRememberHistoryPos, timeInterval = ", Long.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.jdField_d_of_type_Long), " isNeedToRemember = ", Boolean.valueOf(bool2) });
            bool1 = bool2;
            break;
          }
          if (this.jdField_a_of_type_Int != 0)
          {
            r();
            continue;
            paramInt = 0;
          }
        }
      }
      if (!(a() instanceof ReadInJoyNewFeedsActivity)) {
        break label830;
      }
      if (m == 0) {
        break label812;
      }
      bool1 = true;
      if ((!this.jdField_e_of_type_Boolean) && (bool1))
      {
        if ((m == 0) && (paramInt != 0)) {
          break label923;
        }
        r();
      }
      if (!this.g) {
        this.g = true;
      }
      if ((this.jdField_a_of_type_Int == 40677) && (paramList != null) && (!paramList.isEmpty()))
      {
        l = NetConnInfoCenter.getServerTime();
        localObject1 = (QQAppInterface)ReadInJoyUtils.a();
        if (localObject1 != null)
        {
          paramList = ((ReadInJoyLogicManager)((QQAppInterface)localObject1).getManager(162)).a().a(this.jdField_a_of_type_Int, ((Long)paramList.get(0)).longValue());
          if (paramList != null)
          {
            localObject2 = (WeishiManager)((QQAppInterface)localObject1).getManager(274);
            if (localObject2 != null) {
              ((WeishiManager)localObject2).a(PublicAccountUtil.a((QQAppInterface)localObject1, paramList), l);
            }
          }
        }
      }
      s();
      PublicTracker.a("KANDIAN_NEW_FEEDS_ON_CHANNEL_ARTICLE_LOADED", null);
      PublicTracker.a("KANDIAN_NEW_FEEDS_LOAD_ARTICLE", null);
      PublicTracker.a(null, "KANDIAN_NEW_FEEDS_LOAD_ARTICLE_FINISH_TO_MEASURE");
      return;
      bool1 = false;
      break;
    }
  }
  
  public void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!TextUtils.isEmpty(paramString)) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(), paramArticleInfo.mArticleID))
      {
        m = 1;
        ReadInJoyAtlasFragment.a(paramContext, paramString, paramInt1, paramInt2, paramInt3, paramArticleInfo.mAlgorithmID, m);
        ReadInJoyLogicEngine.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.notifyDataSetChanged();
        d(paramArticleInfo);
        paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        paramContext = "";
        if (paramString != null) {
          paramContext = paramString.c();
        }
        paramInt1 = GalleryReportedUtils.a(ReadInJoyUtils.a(paramArticleInfo));
        paramContext = GalleryReportedUtils.a(getContext(), paramContext, paramInt2, paramArticleInfo.mArticleID, paramInt3, paramArticleInfo.innerUniqueID, paramArticleInfo.galleryReprotExdData, paramInt1, paramInt4);
        PublicAccountReportUtils.a(null, "", "0X8008E2F", "0X8008E2F", 0, 0, "", paramArticleInfo.mArticleID + "", paramArticleInfo.mAlgorithmID + "", paramContext, false);
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        int m = 0;
      }
    }
    QLog.e("ReadInJoyListViewGroup", 2, "rowKey is empty");
  }
  
  public void a(View paramView, ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramArticleInfo == null) {}
    do
    {
      do
      {
        return;
        ReadInJoyUtils.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
        if (paramInt != 2) {
          break;
        }
        paramInt = ReadInJoyBaseAdapter.c(paramArticleInfo);
        if ((paramInt == 23) || (paramInt == 26) || (paramInt == 56) || (paramInt == 59) || (paramInt == 19) || (paramInt == 17) || (paramInt == 11) || (paramInt == 28))
        {
          a(paramArticleInfo, paramView);
          return;
        }
        if ((UtilsForComponent.b(ReadInJoyBaseAdapter.c(paramArticleInfo))) || (ReadInJoyBaseAdapter.g(paramArticleInfo)) || (ReadInJoyBaseAdapter.f(paramArticleInfo)) || (ReadInJoyBaseAdapter.h(paramArticleInfo)) || (ReadInJoyBaseAdapter.i(paramArticleInfo)))
        {
          if ((ReadInJoyBaseAdapter.c(paramArticleInfo) == 11) || (ReadInJoyBaseAdapter.c(paramArticleInfo) == 28) || (ReadInJoyBaseAdapter.a(paramArticleInfo) == 23) || (ReadInJoyBaseAdapter.b(paramArticleInfo) == 56)) {
            a(paramArticleInfo, null, 0, 0, false, 0);
          }
          for (;;)
          {
            v();
            return;
            if (ReadInJoyUtils.a(paramArticleInfo.mArticleContentUrl, paramArticleInfo.mChannelID, paramArticleInfo.mFeedType, paramArticleInfo)) {
              e(paramArticleInfo);
            } else {
              c(paramArticleInfo);
            }
          }
        }
      } while ((!ReadInJoyBaseAdapter.a(paramArticleInfo)) && (!ReadInJoyBaseAdapter.e(paramArticleInfo)) && (!ReadInJoyUtils.b(paramArticleInfo)) && (!ReadInJoyUtils.c(paramArticleInfo)) && (!ReadInJoyUtils.d(paramArticleInfo)) && (!ReadInJoyUtils.e(paramArticleInfo)));
      if (ReadInJoyUtils.a(paramArticleInfo))
      {
        a(paramArticleInfo, null, 0, 0, false, 0);
        return;
      }
      if (ReadInJoyUtils.a(paramArticleInfo.mArticleContentUrl, paramArticleInfo.mChannelID, paramArticleInfo.mFeedType, paramArticleInfo))
      {
        e(paramArticleInfo);
        return;
      }
      c(paramArticleInfo);
      return;
    } while (paramInt != 1);
    b(paramArticleInfo, 2);
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, View paramView, int paramInt, long paramLong)
  {
    paramBaseArticleInfo = (ArticleInfo)paramBaseArticleInfo;
    if (paramBaseArticleInfo != null)
    {
      paramBaseArticleInfo.invalidateProteusTemplateBean();
      ReadInJoyUtils.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramBaseArticleInfo;
      if (ReadInJoyUtils.f(paramBaseArticleInfo))
      {
        a(paramBaseArticleInfo, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt);
        paramInt = 4;
      }
    }
    for (;;)
    {
      if ((getContext() instanceof ReadInJoyNewFeedsActivity)) {
        ((ReadInJoyNewFeedsActivity)getContext()).g(paramInt);
      }
      for (;;)
      {
        Object localObject;
        for (;;)
        {
          v();
          return;
          if (paramBaseArticleInfo.mFeedType == 3)
          {
            paramView = BaseApplicationImpl.getApplication().getRuntime();
            label138:
            Bundle localBundle;
            boolean bool;
            if ((paramView instanceof QQAppInterface))
            {
              paramView = (NowProxy)((QQAppInterface)paramView).getManager(181);
              localObject = new NowFromData();
              if (this.jdField_a_of_type_Int != 56) {
                break label199;
              }
              ((NowFromData)localObject).jdField_b_of_type_JavaLangString = "kandian_video";
              ((NowFromData)localObject).jdField_a_of_type_JavaLangString = "kandian_video";
              localBundle = new Bundle();
              if (paramBaseArticleInfo.mCommentIconType != 1) {
                break label218;
              }
              bool = true;
              localBundle.putBoolean("jump_now_switch", bool);
            }
            try
            {
              paramView.a(null, Long.valueOf(paramBaseArticleInfo.mArticleContentUrl).longValue(), (NowFromData)localObject, 2, localBundle);
              d(paramBaseArticleInfo);
              paramInt = 0;
              break;
              label199:
              ((NowFromData)localObject).jdField_b_of_type_JavaLangString = "kandian_shouye";
              ((NowFromData)localObject).jdField_a_of_type_JavaLangString = "kandian_shouye";
              break label138;
              label218:
              bool = false;
            }
            catch (NumberFormatException paramView)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ReadInJoyListViewGroup", 2, "subscribeId to roomId error, " + paramView.getMessage());
                }
              }
            }
          }
        }
        if (paramBaseArticleInfo.mFeedType == 13)
        {
          paramView = paramBaseArticleInfo.mArticleContentUrl;
          if (!TextUtils.isEmpty(paramView))
          {
            localObject = new Intent(getContext(), QQBrowserActivity.class);
            ((Intent)localObject).putExtra("url", paramView);
            getContext().startActivity((Intent)localObject);
          }
          d(paramBaseArticleInfo);
          paramInt = 0;
          break;
        }
        if (ReadInJoyBaseAdapter.a(paramBaseArticleInfo))
        {
          ReadInJoyUtils.a(getContext(), paramBaseArticleInfo, 1, false, 4, false);
          paramInt = 0;
          break;
        }
        if (ReadInJoyBaseAdapter.c(paramBaseArticleInfo) == 71)
        {
          if ((paramView instanceof ProteusItemView)) {
            a((ProteusItemView)paramView);
          }
          for (;;)
          {
            a(paramBaseArticleInfo, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt);
            paramInt = 4;
            break;
            if ((paramView instanceof LinearLayout)) {
              a((LinearLayout)paramView);
            }
          }
        }
        if ((ReadInJoyBaseAdapter.f(paramBaseArticleInfo)) || (ReadInJoyBaseAdapter.h(paramBaseArticleInfo)))
        {
          ReadInJoyUtils.a(getContext(), paramBaseArticleInfo, 4, false, 3, false);
          ReadInJoyBaseAdapter.a(paramBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a());
          paramInt = 0;
          break;
        }
        if ((ReadInJoyUtils.b(paramBaseArticleInfo)) || (ReadInJoyUtils.c(paramBaseArticleInfo)))
        {
          ReadInJoyUtils.a(getContext(), paramBaseArticleInfo, 1, false, 4, false);
          ReadInJoyBaseAdapter.a(paramBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a());
          ReadInJoyUtils.a(paramBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a());
          paramInt = 0;
          break;
        }
        if (ReadInJoyUtils.a(paramBaseArticleInfo))
        {
          b(paramBaseArticleInfo, 1);
          paramInt = 2;
          break;
        }
        if ((ReadInJoyBaseAdapter.g(paramBaseArticleInfo)) || (ReadInJoyBaseAdapter.i(paramBaseArticleInfo)))
        {
          ReadInJoyUtils.a(getContext(), paramBaseArticleInfo, 0, false, 1, false);
          ReadInJoyBaseAdapter.a(paramBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a());
          paramInt = 0;
          break;
        }
        if (ReadInJoyBaseAdapter.e(paramBaseArticleInfo))
        {
          ReadInJoyUtils.a(getContext(), paramBaseArticleInfo, 1, false, 4, false);
          paramInt = 0;
          break;
        }
        if (ReadInJoyUtils.a(paramBaseArticleInfo))
        {
          if (paramBaseArticleInfo.isTwoItemVideoFeed())
          {
            QLog.d("Q.readinjoy.video", 2, "JumpAndForceInsert onVideoArticleClick() RETURN article.mArticleID:" + paramBaseArticleInfo.mArticleID + " article.mTitle:" + paramBaseArticleInfo.mTitle);
            return;
          }
          if (ReadInJoyBaseAdapter.c(paramBaseArticleInfo) == 6)
          {
            if (!(paramView instanceof ProteusItemView)) {
              break label813;
            }
            a((ProteusItemView)paramView);
          }
          for (;;)
          {
            a(paramBaseArticleInfo, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt);
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.video", 2, "JumpAndForceInsert onVideoArticleClick() article.mArticleID:" + paramBaseArticleInfo.mArticleID + " article.mTitle:" + paramBaseArticleInfo.mTitle + " article.mSummary:" + paramBaseArticleInfo.mSummary + "mJsonVideoList:" + paramBaseArticleInfo.mJsonVideoList + " videoJumpChannelID=" + paramBaseArticleInfo.videoJumpChannelID + " videoJumpChannelName=" + paramBaseArticleInfo.videoJumpChannelName + " videoJumpChannelType=" + paramBaseArticleInfo.videoJumpChannelType);
            }
            paramInt = 4;
            break;
            label813:
            if ((paramView instanceof LinearLayout)) {
              a((LinearLayout)paramView);
            }
          }
        }
        if (AdvertisementInfo.isAppAdvertisementInfo(paramBaseArticleInfo))
        {
          a((AdvertisementInfo)paramBaseArticleInfo);
          paramInt = 0;
          break;
        }
        if (ReadInJoyUtils.b(paramBaseArticleInfo))
        {
          a(paramBaseArticleInfo, paramInt - 1);
          ReadInJoyLogicEngine.a().a(paramBaseArticleInfo.mArticleID, System.currentTimeMillis());
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.notifyDataSetChanged();
          paramInt = 0;
          break;
        }
        if (ReadInJoyUtils.a(paramBaseArticleInfo.mArticleContentUrl, paramBaseArticleInfo.mChannelID, paramBaseArticleInfo.mFeedType, paramBaseArticleInfo))
        {
          e(paramBaseArticleInfo);
          paramInt = 2;
          break;
        }
        c(paramBaseArticleInfo);
        paramInt = 2;
        break;
        if ((getContext() instanceof SplashActivity))
        {
          paramBaseArticleInfo = ReadInJoyUtils.a(getContext());
          if (paramBaseArticleInfo != null) {
            paramBaseArticleInfo.a(paramInt);
          }
        }
      }
      paramInt = 0;
    }
  }
  
  public void a(KandianOx210MsgInfo paramKandianOx210MsgInfo)
  {
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)ReadInJoyUtils.a().getManager(161);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySocialMsgTips == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySocialMsgTips = new ReadinjoySocialMsgTips(a(), a().getLayoutInflater().inflate(2130969646, null));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySocialMsgTips.a(new mmc(this, localKandianMergeManager));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySocialMsgTips.a(paramKandianOx210MsgInfo);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.addHeaderView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySocialMsgTips.a());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySocialMsgTips.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.postInvalidate();
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.removeHeaderView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySocialMsgTips.a());
    }
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    int i1 = 0;
    int n = 0;
    if (paramInt == 4) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_d_of_type_Boolean = bool;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyListViewGroup", 2, "loadmorechannel " + this.jdField_a_of_type_Int + " " + paramInt + " " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.jdField_c_of_type_Int);
      }
      paramReadInJoyBaseListView = ReadInJoyUtils.a();
      int m = i1;
      if (paramReadInJoyBaseListView != null)
      {
        m = i1;
        if (this.jdField_a_of_type_Int == 56)
        {
          m = i1;
          if (this.jdField_e_of_type_Long == 1L)
          {
            m = n;
            if (((KandianMergeManager)paramReadInJoyBaseListView.getManager(161)).h()) {
              m = 4;
            }
            m |= 0x2;
          }
        }
      }
      ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_Int, a(), paramInt, m);
      ThreadManager.executeOnSubThread(new mlu(this));
      return;
    }
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView, boolean paramBoolean)
  {
    if ((getContext() instanceof ReadInJoyNewFeedsActivity))
    {
      paramReadInJoyBaseListView = (ReadInJoyNewFeedsActivity)getContext();
      paramReadInJoyBaseListView.g(1);
      if (this.jdField_a_of_type_Int == 0) {
        paramReadInJoyBaseListView.c(false);
      }
      if ((ReadInJoyUtils.a()) && (!c()) && (!paramBoolean)) {
        break label120;
      }
      m = 1;
      label54:
      ReadInJoyUtils.b(3);
      if (m == 0) {
        break label125;
      }
    }
    label120:
    label125:
    for (int m = 3;; m = 1001)
    {
      b(true, m);
      ThreadManager.executeOnSubThread(new mmm(this));
      return;
      if (!(getContext() instanceof SplashActivity)) {
        break;
      }
      ReadInJoyLogicEngineEventDispatcher.a().a(2, null);
      paramReadInJoyBaseListView = ReadInJoyUtils.a(getContext());
      if (paramReadInJoyBaseListView == null) {
        break;
      }
      paramReadInJoyBaseListView.a(1);
      break;
      m = 0;
      break label54;
    }
  }
  
  public void a(ReadInJoyAnimBaseManager.PullRefreshComplete paramPullRefreshComplete)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(paramPullRefreshComplete);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager$PullRefreshComplete = paramPullRefreshComplete;
    }
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.getItem((int)paramLong);
    paramAdapterView = null;
    if ((localObject instanceof ArticleInfo)) {
      paramAdapterView = (ArticleInfo)localObject;
    }
    a(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public void a(List paramList)
  {
    if (!PreloadManager.a().a()) {}
    for (;;)
    {
      return;
      PreloadManager.a().e();
      int n = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a();
      if ((paramList != null) && (paramList.size() >= 5))
      {
        int m = 0;
        while (m < 5)
        {
          long l = ((Long)paramList.get(m)).longValue();
          Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(n, l);
          if ((localObject != null) && (!ReadInJoyUtils.a(((BaseArticleInfo)localObject).mArticleContentUrl, ((BaseArticleInfo)localObject).mChannelID, ((BaseArticleInfo)localObject).mFeedType, (ArticleInfo)localObject)) && (!ReadInJoyUtils.a((BaseArticleInfo)localObject)) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(n, ((BaseArticleInfo)localObject).mArticleID)))
          {
            localObject = ((BaseArticleInfo)localObject).mArticleContentUrl;
            if (PubAccountPreloadPlugin.a((String)localObject)) {
              PreloadManager.a().a((String)localObject);
            }
          }
          m += 1;
        }
      }
    }
  }
  
  public void a(Map paramMap) {}
  
  public void a(Map paramMap, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "detachFromViewGroup()");
    }
    ThreadManager.post(new mmj(this, paramMap, paramBoolean), 5, null, false);
    ReadInJoyDisplayUtils.a();
    if (c())
    {
      if (this.jdField_a_of_type_Int != 56) {
        break label146;
      }
      ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.a(), System.currentTimeMillis(), a());
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.b(false);
      }
      a().getIntent().putExtra("from_search", false);
      a(-1);
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        this.jdField_b_of_type_AndroidViewView.clearAnimation();
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      return;
      label146:
      ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.a(), System.currentTimeMillis(), this.jdField_a_of_type_Int);
    }
  }
  
  public void a(Set paramSet, Map paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "attachToViewGroup()");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(paramSet, paramMap);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.jdField_b_of_type_Long = System.currentTimeMillis();
    if (c()) {
      if (this.jdField_a_of_type_Int != 56) {
        break label156;
      }
    }
    label156:
    for (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.jdField_d_of_type_Long = ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.a(), a());; this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.jdField_d_of_type_Long = ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.a(), this.jdField_a_of_type_Int))
    {
      l();
      PublicTracker.a(null, "KANDIAN_FEEDS_STAGE_2_COST");
      PublicTracker.a(null, "KANDIAN_NEW_FEEDS_LOAD_ARTICLE");
      ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_Int, 20, 9223372036854775807L, true);
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        this.jdField_b_of_type_AndroidViewView.clearAnimation();
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.smoothScrollBy(0, 0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setSelection(0);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.e();
    }
    for (;;)
    {
      this.h = true;
      q();
      return;
      a(2, null);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, List paramList1, List paramList2)
  {
    int i1 = 0;
    int m;
    int n;
    if ((paramBoolean) && (paramList1 != null) && (paramList1.size() > 0) && (paramInt == 56))
    {
      m = 0;
      for (paramInt = -1; m < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount(); paramInt = n)
      {
        Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(m);
        n = paramInt;
        if (localObject != null)
        {
          n = paramInt;
          if (((View)localObject).getTag() != null)
          {
            n = paramInt;
            if ((((View)localObject).getTag() instanceof ReadInJoyBaseAdapter.VideoFeedsViewHolder))
            {
              localObject = (ReadInJoyBaseAdapter.VideoFeedsViewHolder)((View)localObject).getTag();
              n = paramInt;
              if (paramLong == ((ReadInJoyBaseAdapter.VideoFeedsViewHolder)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_Long) {
                n = ((ReadInJoyBaseAdapter.VideoFeedsViewHolder)localObject).jdField_a_of_type_Int;
              }
            }
          }
        }
        m += 1;
      }
      n = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getHeaderViewsCount();
      m = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition() - n;
      if (m >= 0) {
        break label354;
      }
      m = i1;
    }
    label354:
    for (;;)
    {
      i1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getLastVisiblePosition() - n;
      if ((paramInt + 1 >= m) && (paramInt + 1 <= i1))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(ReadInJoyLogicEngine.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList1));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.c(paramInt + 1);
      }
      for (;;)
      {
        paramList1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a();
        if (paramList1 != null) {
          paramList1.a(paramList2);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyListViewGroup", 2, "onVideoRealtimeRelpaceListRefreshed success!  reqArticleID=" + paramLong + ", positionRequested=" + paramInt + ", firstVisiblePosi=" + m + ", lastVisblePosi=" + i1 + "， headerCount=" + n);
        }
        return;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(ReadInJoyLogicEngine.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList1));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.notifyDataSetChanged();
      }
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List paramList, boolean paramBoolean2)
  {
    int n = 1;
    if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter == null)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.getCount() == 0) {}
    int i1;
    StringBuilder localStringBuilder;
    for (int m = 1;; m = 0)
    {
      i1 = ReadInJoyLogicEngine.a().a(Integer.valueOf(paramInt));
      if (!paramBoolean1) {
        break label415;
      }
      if ((paramList == null) || (i1 <= 0) || (paramList.size() <= 0)) {
        break label352;
      }
      if (!QLog.isColorLevel()) {
        break label188;
      }
      localStringBuilder = new StringBuilder("onChannelRefreshed ");
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        localStringBuilder.append("recommendSeq = " + localLong + ",\n ");
      }
    }
    QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 1, localStringBuilder.toString());
    label188:
    a(((Long)paramList.get(0)).longValue());
    VideoBehaviorsReporter.a().c(true);
    setAdapterData(ReadInJoyLogicEngine.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList), 1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(0);
    if (paramInt == 70) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setNoMoreData(paramBoolean2);
    }
    label415:
    for (;;)
    {
      if ((c()) || (this.jdField_a_of_type_Int == 56) || (m == 0)) {
        a(paramBoolean1, i1);
      }
      if (this.jdField_a_of_type_Int == 70) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.jdField_c_of_type_Int = 0;
      }
      if ((this.jdField_a_of_type_Int == 56) && (this.i))
      {
        paramInt = n;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelCoverChannelCoverView == null) {
          paramInt = 0;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setSelectionFromTop(paramInt, 0);
        this.i = false;
      }
      a(paramList);
      b(paramList);
      return;
      label352:
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.isEmpty()) {
        if (this.jdField_a_of_type_Int == 70)
        {
          a(getResources().getString(2131428445), getResources().getDrawable(2130845492));
        }
        else
        {
          a(getResources().getString(2131428447));
          continue;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.isEmpty()) {
            a(getResources().getString(2131428446));
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Int == 56) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L) != 0L);
  }
  
  public boolean a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(2, null);
  }
  
  public void b(int paramInt, List paramList)
  {
    if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter == null) || (paramList == null)) {}
    do
    {
      return;
      if (paramList.size() > 0)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder("refreshChannelData ");
          localStringBuilder.append("channelID : ").append(paramInt).append("\n");
          Iterator localIterator = paramList.iterator();
          while (localIterator.hasNext())
          {
            Long localLong = (Long)localIterator.next();
            localStringBuilder.append("recommendSeq = " + localLong + ",\n ");
          }
          QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 1, localStringBuilder.toString());
        }
        a(((Long)paramList.get(0)).longValue());
        VideoBehaviorsReporter.a().c(true);
        setAdapterData(ReadInJoyLogicEngine.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList), 1);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(0);
        return;
      }
    } while (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.isEmpty());
    a(getResources().getString(2131428447));
  }
  
  public void b(Map paramMap)
  {
    paramMap.put(Integer.valueOf(this.jdField_a_of_type_Int), Boolean.valueOf(true));
  }
  
  public void b(Map paramMap, boolean paramBoolean)
  {
    if ((paramMap == null) || (paramMap.isEmpty()) || (!paramBoolean))
    {
      QLog.d("ReadInJoyListViewGroup", 2, "report data is null ");
      return;
    }
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_Int == 56)
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a();
      if (localObject1 != null)
      {
        localObject2 = paramMap.values().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (BaseReportData)((Iterator)localObject2).next();
          ((BaseReportData)localObject3).jdField_h_of_type_Int = ((VideoRecommendManager)localObject1).a();
          if (((VideoRecommendManager)localObject1).a(((BaseReportData)localObject3).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID)) {
            ((BaseReportData)localObject3).jdField_f_of_type_Boolean = true;
          }
        }
      }
    }
    Object localObject3 = new HashMap();
    Iterator localIterator = paramMap.values().iterator();
    BaseReportData localBaseReportData;
    long l1;
    int m;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localBaseReportData = (BaseReportData)localIterator.next();
        if (!localBaseReportData.jdField_a_of_type_Boolean)
        {
          localBaseReportData.jdField_a_of_type_Boolean = true;
          if ((getContext() instanceof ReadInJoyNewFeedsActivity)) {
            if (((ReadInJoyNewFeedsActivity)getContext()).a() > 0L)
            {
              l1 = ((ReadInJoyNewFeedsActivity)getContext()).a();
              if (!((ReadInJoyNewFeedsActivity)getContext()).a()) {
                break label623;
              }
              m = 0;
            }
          }
        }
      }
    }
    for (;;)
    {
      label231:
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80066FC", "0X80066FC", 0, 0, "", Long.toString(localBaseReportData.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localBaseReportData.jdField_b_of_type_Int), ReadInJoyUtils.a(localBaseReportData.jdField_a_of_type_Long, localBaseReportData.jdField_c_of_type_Int, this.jdField_a_of_type_Int, localBaseReportData.jdField_d_of_type_Int), false);
      PublicAccountReportUtils.a("0X80066FC", "", "", Long.toString(localBaseReportData.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localBaseReportData.jdField_b_of_type_Int), ReadInJoyUtils.a(localBaseReportData.jdField_a_of_type_Long, localBaseReportData.jdField_c_of_type_Int, this.jdField_a_of_type_Int, localBaseReportData.jdField_d_of_type_Int));
      localObject2 = ReadInJoyUtils.a(localBaseReportData.jdField_a_of_type_Long, localBaseReportData.jdField_c_of_type_Int, this.jdField_a_of_type_Int, localBaseReportData.jdField_d_of_type_Int, localBaseReportData.jdField_e_of_type_Int, NetworkUtil.h(getContext()), localBaseReportData.jdField_a_of_type_JavaLangString, localBaseReportData.jdField_c_of_type_JavaLangString, localBaseReportData.jdField_e_of_type_JavaLangString, ReadInJoyUtils.c(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, l1, m, localBaseReportData.jdField_f_of_type_Int, localBaseReportData.jdField_g_of_type_Int, localBaseReportData.jdField_h_of_type_Int, localBaseReportData.jdField_f_of_type_Boolean, localBaseReportData.jdField_j_of_type_Int, localBaseReportData.jdField_i_of_type_Int);
      if (localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) {
        break;
      }
      if (this.jdField_a_of_type_Int == 56) {
        localObject1 = ReadInJoyUtils.a((String)localObject2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a().a(), VideoReporter.jdField_a_of_type_Int);
      }
      label623:
      int n;
      for (;;)
      {
        if (!ReadInJoyBaseAdapter.b(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
          break label774;
        }
        m = 0;
        while (m < localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTopicRecommendFeedsInfo.a.size())
        {
          PublicAccountReportUtils.a(null, localBaseReportData.jdField_d_of_type_JavaLangString, "0X8007626", "0X8007626", 0, 0, Long.toString(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), ((TopicRecommendFeedsInfo.TopicRecommendInfo)localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTopicRecommendFeedsInfo.a.get(m)).jdField_a_of_type_Int + "", Integer.toString(localBaseReportData.jdField_b_of_type_Int), (String)localObject1, false);
          m += 1;
        }
        l1 = System.currentTimeMillis() - ((ReadInJoyNewFeedsActivity)getContext()).b();
        break;
        m = 1;
        break label231;
        if (!(getContext() instanceof SplashActivity)) {
          break label1984;
        }
        localObject1 = ReadInJoyUtils.a(getContext());
        if (localObject1 == null) {
          break label1984;
        }
        if (((ReadinjoyTabFrame)localObject1).jdField_c_of_type_Int != 0) {}
        for (m = 0;; m = 1)
        {
          l1 = ((ReadinjoyTabFrame)localObject1).a();
          break;
        }
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Int == 0)
        {
          localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter;
          n = ReadInJoyArticleAdapter.c((ArticleInfo)localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
          if ((n != 6) && (n != 66) && (n != 28) && (n != 11) && (n != 26))
          {
            localObject1 = localObject2;
            if (n != 19) {}
          }
          else
          {
            localObject1 = VideoReporter.a(VideoReporter.a((ArticleInfo)localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (String)localObject2);
          }
        }
      }
      label774:
      label910:
      long l3;
      int i1;
      if (ReadInJoyUtils.f(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
        if (ReadInJoyUtils.e(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
        {
          localObject1 = (BaseArticleInfo)localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGroupSubArticleList.get(0);
          localObject2 = ReadinjoyReportUtils.a(getContext(), ((BaseArticleInfo)localObject1).mArticleID, ((BaseArticleInfo)localObject1).mAlgorithmID, 54, this.jdField_a_of_type_Int, ((BaseArticleInfo)localObject1).getInnerUniqueID(), ((BaseArticleInfo)localObject1).getVideoVid(), ReadinjoyReportUtils.a((BaseArticleInfo)localObject1), ((BaseArticleInfo)localObject1).videoReportInfo);
          PublicAccountReportUtils.a(null, "CliOper", "", localBaseReportData.jdField_d_of_type_JavaLangString, "0X8007626", "0X8007626", 0, 0, Long.toString(((BaseArticleInfo)localObject1).mFeedId), Long.toString(((BaseArticleInfo)localObject1).mArticleID), Integer.toString(((BaseArticleInfo)localObject1).mStrategyId), (String)localObject2, false);
          if ((localBaseReportData.jdField_c_of_type_Int == 48) || (localBaseReportData.jdField_c_of_type_Int == 49) || (localBaseReportData.jdField_c_of_type_Int == 50) || (localBaseReportData.jdField_c_of_type_Int == 51) || (localBaseReportData.jdField_c_of_type_Int == 52) || (localBaseReportData.jdField_c_of_type_Int == 53))
          {
            l3 = localBaseReportData.jdField_b_of_type_Long;
            m = localBaseReportData.k;
            n = GalleryReportedUtils.a(this.jdField_a_of_type_Int, localBaseReportData.jdField_c_of_type_Int);
            i1 = GalleryReportedUtils.a(localBaseReportData.jdField_c_of_type_Int);
            l1 = 0L;
            localObject1 = null;
            localObject2 = null;
            if (localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) {
              break label1978;
            }
            l1 = localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID;
            localObject1 = localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID;
            localObject2 = localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.galleryReprotExdData;
          }
        }
      }
      label1978:
      for (long l2 = localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mAlgorithmID;; l2 = 0L)
      {
        Object localObject4;
        for (;;)
        {
          localObject4 = GalleryReportedUtils.a(getContext(), ReadInJoyUtils.a(), n, l1, l3, m, (String)localObject1, (String)localObject2, i1);
          PublicAccountReportUtils.a(null, "", "0X8008E2E", "0X8008E2E", 0, 0, "", l1 + "", l2 + "", (String)localObject4, false);
          GalleryReportedUtils.a(7, ReadInJoyUtils.a(), (int)l2, n, l3, m, (String)localObject1, (String)localObject2);
          if (!localBaseReportData.jdField_c_of_type_Boolean) {
            break;
          }
          try
          {
            if (!localBaseReportData.jdField_d_of_type_Boolean) {
              break;
            }
            localObject1 = ReadInJoyUtils.a();
            ((JSONObject)localObject1).put("feeds_source", localBaseReportData.jdField_a_of_type_JavaLangString);
            ((JSONObject)localObject1).put("kandian_mode", ReadInJoyUtils.e());
            PublicAccountReportUtils.a(null, "CliOper", "", "", "0X800744E", "0X800744E", 0, 0, ReadInJoyUtils.b(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), "", "", ((JSONObject)localObject1).toString(), false);
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
        }
        break;
        String str = ReadinjoyReportUtils.a(getContext(), localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoAdsSource, localBaseReportData.k, localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getInnerUniqueID(), 54, ReadinjoyReportUtils.a(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo);
        PublicAccountReportUtils.a(null, "CliOper", "", localBaseReportData.jdField_d_of_type_JavaLangString, "0X80091A8", "0X80091A8", 0, 0, Long.toString(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID), Integer.toString(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId), str, false);
        break label910;
        if (ReadInJoyUtils.d(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
        {
          localObject2 = localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
          localObject4 = ReadInJoyUtils.a(((BaseArticleInfo)localObject2).mPolymericInfo);
          PublicAccountReportUtils.a(null, "CliOper", "", localBaseReportData.jdField_d_of_type_JavaLangString, "0X8008F57", "0X8008F57", 0, 0, localBaseReportData.k + "", Long.toString(localBaseReportData.jdField_a_of_type_JavaLangLong.longValue()), Long.toString(((BaseArticleInfo)localObject2).mPolymericInfo.jdField_d_of_type_Long), ((JSONObject)localObject4).toString(), false);
          if (((HashMap)localObject3).containsKey(Long.valueOf(((BaseArticleInfo)localObject2).mPolymericInfo.jdField_c_of_type_Long))) {
            break;
          }
          ((HashMap)localObject3).put(Long.valueOf(((BaseArticleInfo)localObject2).mPolymericInfo.jdField_c_of_type_Long), Boolean.valueOf(true));
        }
        if (this.jdField_a_of_type_Int == 40677)
        {
          PublicAccountReportUtils.a(null, "CliOper", "", localBaseReportData.jdField_d_of_type_JavaLangString, "0X8009292", "0X8009292", 0, 0, Long.toString(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(localBaseReportData.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localBaseReportData.jdField_b_of_type_Int), str, false);
          PublicAccountReportUtils.a("0X8009292", localBaseReportData.jdField_d_of_type_JavaLangString, Long.toString(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(localBaseReportData.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localBaseReportData.jdField_b_of_type_Int), ReadInJoyUtils.a(localBaseReportData.jdField_a_of_type_Long, localBaseReportData.jdField_c_of_type_Int, this.jdField_a_of_type_Int, localBaseReportData.jdField_d_of_type_Int, localBaseReportData.jdField_e_of_type_Int, NetworkUtil.h(getContext()), localBaseReportData.jdField_a_of_type_JavaLangString, localBaseReportData.jdField_c_of_type_JavaLangString, localBaseReportData.jdField_e_of_type_JavaLangString, ReadInJoyUtils.c(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, l1, m, localBaseReportData.jdField_f_of_type_Int, localBaseReportData.jdField_g_of_type_Int, localBaseReportData.jdField_h_of_type_Int, localBaseReportData.jdField_f_of_type_Boolean, localBaseReportData.jdField_j_of_type_Int, localBaseReportData.jdField_i_of_type_Int));
          break label910;
        }
        str = VideoReporter.a(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, str);
        str = VideoReporter.a(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo, str);
        PublicAccountReportUtils.a(null, "CliOper", "", localBaseReportData.jdField_d_of_type_JavaLangString, "0X8007626", "0X8007626", 0, 0, Long.toString(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(localBaseReportData.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localBaseReportData.jdField_b_of_type_Int), str, false);
        PublicAccountReportUtils.a("0X8007626", localBaseReportData.jdField_d_of_type_JavaLangString, Long.toString(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(localBaseReportData.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localBaseReportData.jdField_b_of_type_Int), ReadInJoyUtils.a(localBaseReportData.jdField_a_of_type_Long, localBaseReportData.jdField_c_of_type_Int, this.jdField_a_of_type_Int, localBaseReportData.jdField_d_of_type_Int, localBaseReportData.jdField_e_of_type_Int, NetworkUtil.h(getContext()), localBaseReportData.jdField_a_of_type_JavaLangString, localBaseReportData.jdField_c_of_type_JavaLangString, localBaseReportData.jdField_e_of_type_JavaLangString, ReadInJoyUtils.c(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, l1, m, localBaseReportData.jdField_f_of_type_Int, localBaseReportData.jdField_g_of_type_Int, localBaseReportData.jdField_h_of_type_Int, localBaseReportData.jdField_f_of_type_Boolean, localBaseReportData.jdField_j_of_type_Int, localBaseReportData.jdField_i_of_type_Int));
        break label910;
        if (this.jdField_a_of_type_Int != 40677) {
          c(paramMap);
        }
        ReadinjoyReportUtils.b();
        return;
      }
      label1984:
      m = -1;
      l1 = 0L;
    }
  }
  
  public void b(boolean paramBoolean1, int paramInt, List paramList, boolean paramBoolean2)
  {
    boolean bool2 = true;
    if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter == null))
    {
      this.jdField_d_of_type_Boolean = false;
      return;
    }
    if ((paramBoolean1) && (paramList != null)) {
      setAdapterData(ReadInJoyLogicEngine.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList), 2);
    }
    boolean bool1;
    label84:
    ReadInJoyXListView localReadInJoyXListView;
    if ((paramBoolean1) && (paramList == null))
    {
      paramBoolean1 = true;
      bool1 = paramBoolean1;
      if (this.jdField_a_of_type_Int == 70)
      {
        if ((!paramBoolean1) && (!paramBoolean2)) {
          break label267;
        }
        paramBoolean1 = true;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.jdField_b_of_type_Boolean = paramBoolean1;
        bool1 = paramBoolean1;
      }
      localReadInJoyXListView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView;
      if (bool1) {
        break label272;
      }
    }
    label267:
    label272:
    for (paramBoolean1 = bool2;; paramBoolean1 = false)
    {
      localReadInJoyXListView.a(paramBoolean1);
      if ((paramList != null) && (!paramList.isEmpty())) {
        this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyListViewGroup", 2, "autoLoad:" + this.jdField_d_of_type_Boolean + " noMoreData:" + bool1 + " fore:" + GesturePWDUtils.isAppOnForeground(getContext()));
      }
      if ((!this.jdField_d_of_type_Boolean) && (bool1) && (GesturePWDUtils.isAppOnForeground(getContext())) && (this.jdField_a_of_type_Int != 70))
      {
        paramList = getResources().getString(2131428442);
        QQToast.a(getContext().getApplicationContext(), paramList, 0).a();
      }
      this.jdField_d_of_type_Boolean = false;
      return;
      paramBoolean1 = false;
      break;
      paramBoolean1 = false;
      break label84;
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "OnResume()");
    }
    if (this.jdField_a_of_type_Int == 56) {
      ReadInJoyLogicEngine.a().a(56);
    }
    if (ReadInJoyHelper.a(a()))
    {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      VideoBrightnessControl.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a());
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.i();
    }
    ReadInJoyArkViewController.a().a(this, "0");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersHeaderViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersHeaderViewController.c();
    }
    l();
    this.h = true;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.invalidate();
    boolean bool = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a().getIntent().getBooleanExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", false);
    if ((a()) && (!bool) && ((!ReadInJoyHelper.f()) || ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a() instanceof ReadInJoyNewFeedsActivity))))
    {
      q();
      s();
    }
    if (((!ReadInJoyHelper.f()) || ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a() instanceof ReadInJoyNewFeedsActivity))) && (this.jdField_a_of_type_Int == 56)) {
      VideoReporter.jdField_a_of_type_Int = VideoReporter.a(a().getIntent().getIntExtra("channel_from", -1));
    }
    ReadInJoyArkUtil.b(this.jdField_a_of_type_Int);
    int m;
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount() > 0)) {
      m = 0;
    }
    for (;;)
    {
      if (m < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
      {
        Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(m);
        if ((((View)localObject1).getTag(2131362079) instanceof ReadInJoyModelImpl))
        {
          Object localObject2 = (ReadInJoyModelImpl)((View)localObject1).getTag(2131362079);
          if ((((ReadInJoyModelImpl)localObject2).a() == 39) || (((ReadInJoyModelImpl)localObject2).a() == 66))
          {
            localObject1 = (TextView)((View)localObject1).findViewById(2131367049);
            if (localObject1 != null)
            {
              localObject2 = (AdvertisementInfo)((ReadInJoyModelImpl)localObject2).a();
              try
              {
                localObject2 = new JSONObject(((AdvertisementInfo)localObject2).mAdExt);
                if (PackageUtil.a(getContext(), ((JSONObject)localObject2).optString("pkg_name"))) {
                  ((TextView)localObject1).setText(getContext().getString(2131438709));
                } else {
                  ((TextView)localObject1).setText(getContext().getString(2131438708));
                }
              }
              catch (JSONException localJSONException) {}
            }
          }
        }
      }
      else
      {
        return;
      }
      m += 1;
    }
  }
  
  public void c(int paramInt, List paramList)
  {
    if ((paramInt != this.jdField_a_of_type_Int) || (paramList == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.b(ReadInJoyLogicEngine.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.notifyDataSetChanged();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "onPause()");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.j();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersHeaderViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersHeaderViewController.d();
    }
    if (this.jdField_a_of_type_Int == 56)
    {
      this.j = false;
      this.i = false;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", 0L);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_TOW_VIDEO_ITEM_INDEX", 0);
    }
    ReadInJoyArkUtil.a(this.jdField_a_of_type_Int);
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {}
    try
    {
      if ((ReadInJoyHelper.g()) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a() instanceof SplashActivity))) {
        return;
      }
      Parcelable localParcelable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.onSaveInstanceState();
      ((ReadInJoyLogicManager)ReadInJoyUtils.a().getManager(162)).a().a(this.jdField_a_of_type_Int, localParcelable);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        QLog.d("ReadInJoyListViewGroup", 1, "updateLeaveChannelPosInfo Exception.");
      }
    }
    if (QLog.isColorLevel())
    {
      QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "mListView onSaveInstanceState cost: ", Long.valueOf(System.currentTimeMillis() - l) });
      return;
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "onStart()");
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "onStop()");
    }
    if (!c()) {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianTipFloatingWindow != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianTipFloatingWindow.a())) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianTipFloatingWindow.a(false);
      }
    }
    ArticleInfo localArticleInfo;
    do
    {
      do
      {
        return;
      } while (!d());
      localArticleInfo = (ArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.b(0);
    } while (localArticleInfo == null);
    ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_Int, localArticleInfo.mTitle, localArticleInfo.mArticleID);
  }
  
  public void g()
  {
    ReadInJoyHelper.a(System.currentTimeMillis(), (QQAppInterface)ReadInJoyUtils.a());
    FastWebModule localFastWebModule = ((ReadInJoyLogicManager)ReadInJoyUtils.a().getManager(162)).a().a();
    if (localFastWebModule != null) {
      localFastWebModule.a(this.jdField_f_of_type_Int);
    }
    ((BaseActivity)a()).app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    ReadinjoyFixPosArticleManager.a().a(this.jdField_a_of_type_Int);
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.d();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setDrawFinishedListener(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setRefreshCallback(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver != null) {
      ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianTipFloatingWindow != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianTipFloatingWindow.b();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianTipFloatingWindow = null;
    }
    ReadInJoyHelper.b(((BaseActivity)a()).app);
    ReadinjoyHBLogic.a().a(this);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelCoverChannelCoverView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelCoverChannelCoverView.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyChannelCoverChannelCoverView = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySocialMsgTips != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySocialMsgTips.c();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySocialMsgTips = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersHeaderViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersHeaderViewController.b();
    }
    ((KandianMergeManager)ReadInJoyUtils.a().getManager(161)).b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$MessageObserver);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$MessageObserver = null;
  }
  
  public void h()
  {
    Activity localActivity = a();
    if ((localActivity instanceof BaseActivity))
    {
      Object localObject = ((BaseActivity)localActivity).getAppInterface();
      if (localObject != null)
      {
        ReadInJoyRefreshManager localReadInJoyRefreshManager = (ReadInJoyRefreshManager)((AppInterface)localObject).getManager(269);
        localObject = (ReadInJoySkinManager)((AppInterface)localObject).getManager(260);
        ThreadManager.post(new mmi(this, localReadInJoyRefreshManager.a(localActivity), localReadInJoyRefreshManager, ((ReadInJoySkinManager)localObject).a(localActivity), (ReadInJoySkinManager)localObject), 8, null, true);
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAnimType(0);
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.c();
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.d();
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.notifyDataSetChanged();
    }
  }
  
  public void l()
  {
    if (c()) {
      return;
    }
    ThreadManager.post(new mlx(this), 8, null, false);
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager$PullRefreshComplete);
    }
  }
  
  public void n()
  {
    w();
    List localList = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a();
    if (localList != null)
    {
      localList.clear();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.notifyDataSetChanged();
    }
    ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_Int, 20, 9223372036854775807L, true);
    QLog.d("Q.readinjoy.4tab", 2, "onAccountChange, reload listview data for new account, channelID : " + this.jdField_a_of_type_Int);
    l();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    w();
    ReadInJoyUtils.b(3);
    b(true, 3);
  }
  
  public void setAdapterData(List paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((BaseArticleInfo)localIterator.next());
    }
    paramList = ReadinjoyFixPosArticleManager.a().a(this.jdField_a_of_type_Int, paramList, localArrayList, paramInt);
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(true);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.a(paramList);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyArticleAdapter.notifyDataSetChanged();
  }
  
  public void setChannelType(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup
 * JD-Core Version:    0.7.0.1
 */