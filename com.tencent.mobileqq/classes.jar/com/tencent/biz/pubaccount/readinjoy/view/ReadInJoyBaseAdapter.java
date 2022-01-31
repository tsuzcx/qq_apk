package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoInfo.ChannelInfo;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.ark.FeedItemCellArk;
import com.tencent.biz.pubaccount.readinjoy.ark.ReadInJoyArkUtil;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ProteusSupportUtil;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyTimeUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVideoManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyModelImpl;
import com.tencent.biz.pubaccount.readinjoy.presenter.IReadInJoyPresenter;
import com.tencent.biz.pubaccount.readinjoy.presenter.ReadInJoyPresenterImpl;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.CellFactory;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.PolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.FeedsReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.VideoExtraRepoerData;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VidUrl;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoBehaviorsReporter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsStartStatistic;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreloadReportData;
import com.tencent.biz.pubaccount.readinjoy.video.VideoRecommendManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoRecommendManager.Listener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoShareHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionPreloadManager;
import com.tencent.biz.ui.CustomAnimationAdapter;
import com.tencent.biz.webviewplugin.PubAccountPreloadPlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.KandianPopupWindow;
import com.tencent.widget.KandianPopupWindow.OnUninterestConfirmListener;
import com.tencent.widget.KandianPopupWindowForAd;
import com.tencent.widget.ListView;
import cooperation.plugin.PluginBaseActivity;
import cooperation.readinjoy.ReadInJoyHelper;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mfq;
import mfr;
import mfs;
import mft;
import mfu;
import mfv;
import mfw;
import mfy;
import mga;
import mgl;
import mgm;
import mgn;
import mgo;
import mgp;
import mgq;
import mgr;
import mgs;
import mgt;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ChannelInfo;

public abstract class ReadInJoyBaseAdapter
  extends CustomAnimationAdapter
  implements View.OnClickListener, View.OnLongClickListener, VideoRecommendManager.Listener
{
  public static float a;
  public static int a;
  public static int b;
  public static int e;
  public static int f;
  public static int g;
  public static int h;
  public static int i;
  private static int jdField_k_of_type_Int;
  private static int jdField_l_of_type_Int;
  protected long a;
  public Activity a;
  protected Drawable a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  protected LayoutInflater a;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  private VideoAutoPlayController jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController;
  public VideoPlayManager a;
  public VideoPreDownloadMgr a;
  public VideoRecommendManager a;
  private VideoShareHelper jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoShareHelper;
  protected ReadInJoyBaseAdapter.OnGalleryImageClickListener a;
  protected ReadInJoyBaseAdapter.OnHorizontalSubArticleClick a;
  protected ReadInJoyBaseAdapter.OnLastReadRefreshListener a;
  protected ReadInJoyBaseAdapter.OnSubRegionClickListener a;
  private ReadInJoyBaseAdapter.PrefetchListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$PrefetchListener;
  public ReadInJoyBaseAdapter.VideoFeedsViewHolder a;
  public ReadInJoyBaseListView.OnDrawCompleteListener a;
  public ReadInJoyXListView a;
  public ThreadPriorityUtil a;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new VafContext();
  public QQAppInterface a;
  public INetInfoHandler a;
  public AbsListView.OnScrollListener a;
  private KandianPopupWindow jdField_a_of_type_ComTencentWidgetKandianPopupWindow;
  private KandianPopupWindowForAd jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd;
  private Runnable jdField_a_of_type_JavaLangRunnable = new mfr(this);
  protected List a;
  public Map a;
  protected Set a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler();
  public boolean a;
  private long jdField_b_of_type_Long;
  private AnimationSet jdField_b_of_type_AndroidViewAnimationAnimationSet;
  private AbsListView.OnScrollListener jdField_b_of_type_ComTencentWidgetAbsListView$OnScrollListener = new mft(this);
  public List b;
  protected Set b;
  protected boolean b;
  public int c;
  private AbsListView.OnScrollListener c;
  public boolean c;
  protected int d;
  public boolean d;
  protected boolean e;
  protected boolean f;
  protected boolean g;
  public boolean h;
  public boolean i;
  public int j;
  private boolean j;
  private boolean jdField_k_of_type_Boolean;
  private boolean jdField_l_of_type_Boolean = true;
  private int jdField_m_of_type_Int = -1;
  private boolean jdField_m_of_type_Boolean;
  private int jdField_n_of_type_Int;
  private boolean jdField_n_of_type_Boolean;
  private boolean o;
  private boolean p;
  private boolean q;
  
  static
  {
    jdField_a_of_type_Int = 20;
    jdField_b_of_type_Int = 250;
    jdField_e_of_type_Int = 1000;
    jdField_k_of_type_Int = 10;
    jdField_l_of_type_Int = 10;
    jdField_a_of_type_Float = ViewConfiguration.getScrollFriction();
    if (Build.VERSION.SDK_INT < 21) {
      jdField_a_of_type_Float = 0.025F;
    }
  }
  
  public ReadInJoyBaseAdapter(Activity paramActivity, LayoutInflater paramLayoutInflater, int paramInt, ListView paramListView)
  {
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_i_of_type_Boolean = true;
    this.jdField_j_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewThreadPriorityUtil = new ThreadPriorityUtil();
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new mfs(this);
    this.jdField_c_of_type_ComTencentWidgetAbsListView$OnScrollListener = new mfu(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$OnDrawCompleteListener = new mfw(this);
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new mga(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.a(paramActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.a(paramActivity);
    ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = ((ReadInJoyXListView)paramListView);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoShareHelper = new VideoShareHelper(paramActivity);
    n();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView instanceof ReadInJoyXListView)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOnDrawCompleteListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$OnDrawCompleteListener);
    }
    this.jdField_a_of_type_AndroidOsHandler = new mfq(this, Looper.getMainLooper());
    if ((a() instanceof ReadInJoyChannelActivity))
    {
      this.jdField_d_of_type_Boolean = a().getIntent().getBooleanExtra("is_need_show_animation", false);
      this.jdField_f_of_type_Boolean = a().getIntent().getBooleanExtra("is_need_show_animation_adapter", false);
      if (this.jdField_d_of_type_Boolean) {
        break label464;
      }
    }
    label464:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_e_of_type_Boolean = bool;
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet = ((AnimationSet)AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidAppActivity, 2131034193));
      if (!VideoFeedsHelper.a()) {
        this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setDuration(400L);
      }
      paramActivity = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramActivity instanceof QQAppInterface)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramActivity);
      }
      this.jdField_a_of_type_ComTencentWidgetKandianPopupWindow = new KandianPopupWindow(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd = new KandianPopupWindowForAd(this.jdField_a_of_type_AndroidAppActivity);
      b();
      if (this.jdField_c_of_type_Int == 56)
      {
        VideoBehaviorsReporter.a().a(true);
        VideoBehaviorsReporter.a().a(0);
      }
      AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      return;
    }
  }
  
  public static int a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseAdapter", 2, "ugc feeds info is null");
      }
      return 21;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int)
    {
    case 1: 
    default: 
      return 21;
    case 2: 
    case 3: 
      if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 9) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 1)) {
        return 36;
      }
      return 22;
    }
    return 23;
  }
  
  public static int a(ArticleInfo paramArticleInfo, int paramInt)
  {
    int i1 = 16;
    if (paramArticleInfo == null)
    {
      i1 = 0;
      return i1;
    }
    if (paramArticleInfo.mGroupSubArticleList != null) {
      paramInt = 53;
    }
    for (;;)
    {
      i1 = paramInt;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReadInJoyBaseAdapter", 2, "ArticleId = " + paramArticleInfo.mArticleID + ", FeedsType = " + paramInt);
      return paramInt;
      if (paramArticleInfo.mFeedType == 15)
      {
        paramInt = 38;
      }
      else if ((paramArticleInfo.mFeedType == 3) || (paramArticleInfo.mFeedType == 13))
      {
        paramInt = 15;
      }
      else if ((paramArticleInfo.mFeedType == 1) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mChannelID != 56L))
      {
        if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.b != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.b.longValue() == 11L)) {
          paramInt = 33;
        } else if (ReadInJoyUtils.f(paramArticleInfo)) {
          switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int)
          {
          default: 
            paramInt = 12;
            break;
          case 1: 
            paramInt = 44;
            break;
          case 2: 
            paramInt = 43;
            break;
          case 9: 
            paramInt = 45;
            break;
          }
        } else if (ReadInJoyUtils.g(paramArticleInfo)) {
          switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int)
          {
          default: 
            paramInt = 57;
            break;
          case 1: 
            paramInt = 57;
            break;
          case 2: 
          case 3: 
            paramInt = 58;
            break;
          case 4: 
          case 5: 
            paramInt = 59;
            break;
          }
        } else if (!g(paramArticleInfo))
        {
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 0) {
            paramInt = 12;
          } else if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 1) {
            paramInt = 10;
          } else if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5) {
            paramInt = 11;
          } else if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 2) {
            paramInt = 27;
          } else if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 6) {
            paramInt = 28;
          } else if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 9)
          {
            if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_c_of_type_Int == 1)) {
              paramInt = 63;
            } else {
              paramInt = 35;
            }
          }
          else if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 3) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_c_of_type_Int == 1)) {
            paramInt = 62;
          } else if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 8) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_c_of_type_Int == 1)) {
            paramInt = 49;
          } else {
            paramInt = 12;
          }
        }
        else if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int == 1) {
          paramInt = 24;
        } else if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int == 3) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int == 2))
        {
          if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 9) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 1)) {
            paramInt = 37;
          } else {
            paramInt = 25;
          }
        }
        else {
          paramInt = 26;
        }
      }
      else if (((paramArticleInfo.mFeedType == 11) || (paramArticleInfo.mFeedType == 14)) && (paramArticleInfo.mTopicRecommendFeedsInfo != null) && (paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null) && (paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        if (paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
          paramInt = 30;
        } else {
          paramInt = 29;
        }
      }
      else if (a(paramArticleInfo))
      {
        paramInt = i1;
        if (paramArticleInfo.mSocialFeedInfo != null) {
          switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int)
          {
          case 1: 
          case 4: 
          case 7: 
          default: 
            paramInt = i1;
            break;
          case 0: 
            paramInt = 20;
            break;
          case 5: 
            paramInt = 17;
            break;
          case 2: 
            paramInt = 18;
            break;
          case 6: 
            paramInt = 19;
            break;
          case 9: 
            if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_c_of_type_Int == 1))
            {
              paramInt = 65;
              continue;
            }
            paramInt = 34;
            break;
          case 3: 
            paramInt = i1;
            if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo == null) {
              continue;
            }
            paramInt = i1;
            if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_c_of_type_Int != 1) {
              continue;
            }
            paramInt = 64;
            break;
          case 8: 
            paramInt = i1;
            if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo == null) {
              continue;
            }
            paramInt = i1;
            if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_c_of_type_Int != 1) {
              continue;
            }
            paramInt = 48;
            break;
          }
        }
      }
      else if ((f(paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo != null))
      {
        paramInt = a(paramArticleInfo);
      }
      else if ((ReadInJoyUtils.b(paramArticleInfo)) || (ReadInJoyUtils.c(paramArticleInfo)))
      {
        paramInt = 40;
        if (paramArticleInfo.mSocialFeedInfo == null) {}
      }
      else
      {
        switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int)
        {
        default: 
          paramInt = 40;
          break;
        case 2: 
          paramInt = 40;
          break;
        case 1: 
          paramInt = 41;
          break;
        case 9: 
          paramInt = 42;
          continue;
          if ((ReadInJoyUtils.d(paramArticleInfo)) || (ReadInJoyUtils.e(paramArticleInfo)))
          {
            paramInt = b(paramArticleInfo);
          }
          else if (e(paramArticleInfo))
          {
            paramInt = 31;
            if (paramArticleInfo.mSocialFeedInfo != null) {
              switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int)
              {
              default: 
                paramInt = 31;
                break;
              case 2: 
                paramInt = 31;
                break;
              case 6: 
                paramInt = 32;
                break;
              }
            }
          }
          else if (paramArticleInfo.isWeishiGridTwoItemFeed())
          {
            paramInt = 70;
          }
          else if (paramArticleInfo.isTwoItemVideoFeed())
          {
            paramInt = 46;
          }
          else if ((ReadInJoyUtils.a(paramArticleInfo)) && (paramArticleInfo.mPictures != null) && (paramArticleInfo.mPictures.length >= 3) && (paramArticleInfo.mChannelID == 0L))
          {
            paramInt = 14;
          }
          else if (ReadInJoyUtils.a(paramArticleInfo))
          {
            if (paramArticleInfo.mVideoType == 0)
            {
              if (ReadInJoyUtils.a())
              {
                if ((paramArticleInfo.mChannelID == 56L) || (paramInt == 3)) {
                  paramInt = 4;
                } else if (AdvertisementInfo.isAppAdvertisementInfo(paramArticleInfo)) {
                  paramInt = 66;
                } else {
                  paramInt = 6;
                }
              }
              else if (AdvertisementInfo.isAppAdvertisementInfo(paramArticleInfo)) {
                paramInt = 66;
              } else {
                paramInt = 6;
              }
            }
            else if (paramArticleInfo.mChannelID == 56L) {
              paramInt = 4;
            } else {
              paramInt = 5;
            }
          }
          else if (paramArticleInfo.mShowBigPicture)
          {
            if (paramArticleInfo.mIsGallery == 0)
            {
              if (paramArticleInfo.mTopicPicWHRatio != 0.0D) {
                paramInt = 9;
              } else if (AdvertisementInfo.isAppAdvertisementInfo(paramArticleInfo)) {
                paramInt = 39;
              } else {
                paramInt = 2;
              }
            }
            else if (paramArticleInfo.articleStyle == 3) {
              paramInt = 47;
            } else if (paramArticleInfo.articleStyle == 4) {
              paramInt = 60;
            } else if (paramArticleInfo.articleStyle == 5) {
              paramInt = 61;
            } else {
              paramInt = 8;
            }
          }
          else if ((paramArticleInfo.mPictures != null) && (paramArticleInfo.mPictures.length >= 3))
          {
            paramInt = 3;
          }
          else
          {
            if (TextUtils.isEmpty(paramArticleInfo.mFirstPagePicUrl)) {
              return 0;
            }
            if (paramArticleInfo.mIsGallery == 0) {
              paramInt = 1;
            } else {
              paramInt = 7;
            }
          }
          break;
        }
      }
    }
  }
  
  private ShapeDrawable a(int paramInt)
  {
    float f9 = AIOUtils.a(1.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    float f1 = 6;
    float f2 = 6;
    float f3 = 6;
    float f4 = 6;
    float f5 = 6;
    float f6 = 6;
    float f7 = 6;
    float f8 = 6;
    Object localObject = new RectF(f9, f9, f9, f9);
    f9 = 5;
    float f10 = 5;
    float f11 = 5;
    float f12 = 5;
    float f13 = 5;
    float f14 = 5;
    float f15 = 5;
    float f16 = 5;
    localObject = new ShapeDrawable(new RoundRectShape(new float[] { f1, f2, f3, f4, f5, f6, f7, f8 }, (RectF)localObject, new float[] { f9, f10, f11, f12, f13, f14, f15, f16 }));
    LinearGradient localLinearGradient = new LinearGradient(50.0F, 50.0F, 50.0F, 50.0F, paramInt, paramInt, Shader.TileMode.REPEAT);
    ((ShapeDrawable)localObject).getPaint().setShader(localLinearGradient);
    return localObject;
  }
  
  private Bundle a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, BaseArticleInfo paramBaseArticleInfo)
  {
    Bundle localBundle1 = new Bundle();
    label111:
    boolean bool;
    label148:
    label170:
    label299:
    int i1;
    label388:
    label414:
    label506:
    Bundle localBundle2;
    if (paramVideoPlayParam.jdField_e_of_type_Int == 1)
    {
      localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", paramBaseArticleInfo.mSubscribeID);
      localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.mSubscribeName);
      if (paramVideoPlayParam.jdField_e_of_type_Int != 6) {
        break label1090;
      }
      localBundle1.putString("VIDEO_H5_URL", ((SocializeFeedsInfo.UGCVideoInfo)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).h);
      localBundle1.putString("VIDEO_CREATE_TIME", ReadInJoyTimeUtils.a(((SocializeFeedsInfo.UGCVideoInfo)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_Int, true));
      localBundle1.putString("VIDEO_TIME", String.valueOf(paramVideoPlayParam.jdField_a_of_type_Int));
      if (paramBaseArticleInfo.mVideoJsonWidth == 0) {
        break label1121;
      }
      localBundle1.putString("VIDEO_WIDTH", String.valueOf(paramBaseArticleInfo.mVideoJsonWidth));
      if (paramBaseArticleInfo.mVideoJsonHeight == 0) {
        break label1164;
      }
      localBundle1.putString("VIDEO_HEIGHT", String.valueOf(paramBaseArticleInfo.mVideoJsonHeight));
      localBundle1.putString("VIDEO_VID", paramVideoPlayParam.jdField_a_of_type_JavaLangString);
      localBundle1.putString("VIDEO_COVER", paramVideoPlayParam.jdField_b_of_type_JavaLangString);
      localBundle1.putLong("VIDEO_XG_FILE_SIZE", paramBaseArticleInfo.mXGFileSize);
      localBundle1.putInt("VIDEO_STRATEGY_ID", paramBaseArticleInfo.mStrategyId);
      localBundle1.putLong("VIDEO_ALGORITHM_ID", paramBaseArticleInfo.mAlgorithmID);
      localBundle1.putString("VIDEO_SECOND_INDEX_INNER_ID", paramVideoPlayParam.m);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_Long != paramVideoPlayParam.jdField_a_of_type_Long)) {
        break label1207;
      }
      localBundle1.putLong("VIDEO_PLAY_POSITION", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a());
      if (paramVideoPlayParam.jdField_e_of_type_Int != 6) {
        break label1219;
      }
      localBundle1.putString("VIDEO_ARTICLE_ID", ((SocializeFeedsInfo.UGCVideoInfo)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).g);
      localBundle1.putLong("VIDEO_FEED_ID", paramBaseArticleInfo.mFeedId);
      localBundle1.putInt("VIDEO_FEED_TYPE", paramBaseArticleInfo.mFeedType);
      localBundle1.putString("VIDEO_TITLE", ((SocializeFeedsInfo.UGCVideoInfo)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_JavaLangString);
      localBundle1.putBoolean("IS_FROM_READINJOY_VIDEO_CHANNEL", ReadInJoyHelper.a(this.jdField_d_of_type_Int));
      if (paramVideoPlayParam.jdField_e_of_type_Int != 1) {
        break label1246;
      }
      bool = true;
      localBundle1.putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool);
      localBundle1.putString("VIDEO_RECOMMEND_REASON", paramBaseArticleInfo.mRecommentdReason);
      localBundle1.putBoolean("isFromKandian", true);
      localBundle1.putLong("channelID", paramBaseArticleInfo.mChannelID);
      localBundle1.putLong("algorithmID", paramBaseArticleInfo.mAlgorithmID);
      localBundle1.putString("innderId", paramBaseArticleInfo.innerUniqueID);
      localBundle1.putLong("strategyId", paramBaseArticleInfo.mStrategyId);
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleFriendLikeText)) {
        break label1252;
      }
      i1 = 0;
      localBundle1.putInt("interactionType", i1);
      localBundle1.putString("VIDEO_THIRD_ICON", paramVideoPlayParam.jdField_c_of_type_JavaLangString);
      localBundle1.putString("VIDEO_THIRD_NAME", paramVideoPlayParam.jdField_d_of_type_JavaLangString);
      localBundle1.putString("VIDEO_THIRD_ACTION", paramVideoPlayParam.jdField_e_of_type_JavaLangString);
      localBundle1.putString("VIDEO_THIRD_URL", paramVideoPlayParam.jdField_f_of_type_JavaLangString);
      localBundle1.putLong("VIDEO_THRID_URL_EXPIRE_TIME", paramVideoPlayParam.jdField_d_of_type_Long);
      localBundle1.putInt("VIDEO_ARTICLE_BUSITYPE", paramVideoPlayParam.jdField_e_of_type_Int);
      localBundle2 = new Bundle();
      localBundle2.putString("VINFO", paramVideoPlayParam.jdField_a_of_type_JavaLangString);
      localBundle2.putString("TINFO", paramVideoPlayParam.jdField_a_of_type_JavaLangString);
      localBundle2.putInt("PREVIEW_VIDEO_TIME", paramVideoPlayParam.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null) {
        break label1257;
      }
      i1 = 0;
      label641:
      localBundle2.putInt("PREVIEW_START_POSI", VideoPlayUtils.a(i1, paramVideoPlayParam.jdField_a_of_type_Int));
      localBundle2.putInt("PREVIEW_VIDEO_WIDTH", paramVideoPlayParam.jdField_b_of_type_Int);
      localBundle2.putInt("PREVIEW_VIDEO_HEIGHT", paramVideoPlayParam.jdField_c_of_type_Int);
      localBundle2.putInt("FULL_VIDEO_TIME", paramVideoPlayParam.jdField_a_of_type_Int);
      localBundle2.putString("source_puin", paramBaseArticleInfo.mSubscribeID);
      if (paramVideoPlayParam.jdField_e_of_type_Int != 1) {
        break label1269;
      }
      localBundle2.putString("ACCOUNT_UIN", paramBaseArticleInfo.mSubscribeID);
      localBundle2.putString("ACCOUNT_NAME", paramBaseArticleInfo.mSubscribeName);
    }
    for (;;)
    {
      localBundle2.putInt("TYPE", paramVideoPlayParam.jdField_e_of_type_Int);
      localBundle2.putString("ARTICLE_ID", paramBaseArticleInfo.innerUniqueID);
      localBundle2.putInt("layout_item", 5);
      localBundle2.putBoolean("video_url_load", false);
      localBundle2.putString("image_url_remote", paramVideoPlayParam.jdField_b_of_type_JavaLangString);
      localBundle2.putString("detail_url", paramBaseArticleInfo.mArticleContentUrl + "&sourcefrom=0");
      localBundle2.putString("video_url", paramVideoPlayParam.jdField_a_of_type_JavaLangString);
      localBundle2.putString("title", paramBaseArticleInfo.mTitle);
      localBundle2.putString("req_create_time", ReadInJoyTimeUtils.b(paramBaseArticleInfo.mTime));
      localBundle2.putString("brief_key", paramBaseArticleInfo.mTitle);
      localBundle1.putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)StructMsgFactory.a(localBundle2)).getBytes());
      localBundle1.putParcelableArrayList("VIDEO_TOPIC_INFO_LIST", a(paramBaseArticleInfo));
      return localBundle1;
      if (paramVideoPlayParam.jdField_e_of_type_Int == 6)
      {
        if (f((ArticleInfo)paramBaseArticleInfo)) {
          localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long);
        }
        for (;;)
        {
          localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaLangString);
          if (o((ArticleInfo)paramBaseArticleInfo)) {
            break;
          }
          localBundle1.putString("VIDEO_URL", ((SocializeFeedsInfo.UGCVideoInfo)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaLangString);
          break;
          localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long);
        }
      }
      localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", paramBaseArticleInfo.thirdUin);
      localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.thirdUinName);
      break;
      label1090:
      localBundle1.putString("VIDEO_H5_URL", paramBaseArticleInfo.mArticleContentUrl);
      localBundle1.putString("VIDEO_CREATE_TIME", ReadInJoyTimeUtils.a(paramBaseArticleInfo.mTime, true));
      break label111;
      label1121:
      if (paramVideoPlayParam.jdField_e_of_type_Int != 6) {
        break label148;
      }
      localBundle1.putString("VIDEO_WIDTH", String.valueOf(((SocializeFeedsInfo.UGCVideoInfo)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int));
      break label148;
      label1164:
      if (paramVideoPlayParam.jdField_e_of_type_Int != 6) {
        break label170;
      }
      localBundle1.putString("VIDEO_HEIGHT", String.valueOf(((SocializeFeedsInfo.UGCVideoInfo)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_Int));
      break label170;
      label1207:
      localBundle1.putLong("VIDEO_PLAY_POSITION", 0L);
      break label299;
      label1219:
      localBundle1.putString("VIDEO_ARTICLE_ID", paramBaseArticleInfo.innerUniqueID);
      localBundle1.putString("VIDEO_TITLE", paramBaseArticleInfo.mTitle);
      break label388;
      label1246:
      bool = false;
      break label414;
      label1252:
      i1 = 1;
      break label506;
      label1257:
      i1 = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
      break label641;
      label1269:
      localBundle2.putString("ACCOUNT_UIN", paramBaseArticleInfo.thirdUin);
      localBundle2.putString("ACCOUNT_NAME", paramBaseArticleInfo.thirdUinName);
    }
  }
  
  private View a(int paramInt, View paramView)
  {
    BaseArticleInfo localBaseArticleInfo = b(paramInt);
    if (localBaseArticleInfo != null)
    {
      ArkAppMessage localArkAppMessage = ReadInJoyArkUtil.a(localBaseArticleInfo.mArkAppFeedsInfo);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseAdapter", 2, new Object[] { "getArkAppView, position: ", Integer.valueOf(paramInt), ", articleInfo: ", localBaseArticleInfo, ", arkAppMessage: ", localArkAppMessage });
      }
      return a(localBaseArticleInfo, paramView, localArkAppMessage);
    }
    ReadInJoyArkUtil.b(paramView);
    return paramView;
  }
  
  private View a(BaseArticleInfo paramBaseArticleInfo, View paramView, ArkAppMessage paramArkAppMessage)
  {
    Object localObject2;
    if (paramBaseArticleInfo == null)
    {
      localObject2 = paramView;
      return localObject2;
    }
    Object localObject1;
    if ((paramView != null) && ((paramView.getTag() instanceof FeedItemCellArk))) {
      localObject1 = (FeedItemCellArk)paramView.getTag();
    }
    for (;;)
    {
      localObject2 = paramView;
      if (localObject1 == null) {
        break;
      }
      localObject2 = paramView;
      if (paramView == null) {
        break;
      }
      if (!ReadInJoyArkUtil.a(paramArkAppMessage)) {
        break label124;
      }
      ((FeedItemCellArk)localObject1).a(paramArkAppMessage, paramBaseArticleInfo);
      ((FeedItemCellArk)localObject1).b();
      ReadInJoyArkUtil.a(paramView);
      return paramView;
      localObject2 = new FeedItemCellArk(paramArkAppMessage, paramBaseArticleInfo);
      ReadInJoyArkUtil.a((FeedItemCellArk)localObject2, this.jdField_c_of_type_Int);
      localObject1 = localObject2;
      if (((FeedItemCellArk)localObject2).a() != null)
      {
        paramView = ((FeedItemCellArk)localObject2).a();
        paramView.setTag(localObject2);
        localObject1 = localObject2;
      }
    }
    label124:
    ReadInJoyArkUtil.a(paramArkAppMessage, 0);
    ReadInJoyArkUtil.b(paramView);
    return paramView;
  }
  
  private AnimationSet a()
  {
    if (this.jdField_b_of_type_AndroidViewAnimationAnimationSet == null) {
      this.jdField_b_of_type_AndroidViewAnimationAnimationSet = ((AnimationSet)AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidAppActivity, 2131034182));
    }
    AnimationSet localAnimationSet = new AnimationSet(true);
    List localList = this.jdField_b_of_type_AndroidViewAnimationAnimationSet.getAnimations();
    int i2 = localList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      localAnimationSet.addAnimation((Animation)localList.get(i1));
      i1 += 1;
    }
    return localAnimationSet;
  }
  
  private VideoPlayManager.VideoPlayParam a(BaseArticleInfo paramBaseArticleInfo)
  {
    VideoPlayManager.VideoPlayParam localVideoPlayParam = new VideoPlayManager.VideoPlayParam();
    localVideoPlayParam.jdField_a_of_type_JavaLangString = paramBaseArticleInfo.mVideoVid;
    localVideoPlayParam.jdField_a_of_type_Long = paramBaseArticleInfo.mArticleID;
    localVideoPlayParam.jdField_a_of_type_Int = paramBaseArticleInfo.mVideoDuration;
    localVideoPlayParam.jdField_b_of_type_Int = paramBaseArticleInfo.mVideoJsonWidth;
    localVideoPlayParam.jdField_c_of_type_Int = paramBaseArticleInfo.mVideoJsonHeight;
    if (paramBaseArticleInfo.mVideoCoverUrl == null) {}
    for (Object localObject = null;; localObject = paramBaseArticleInfo.mVideoCoverUrl.getFile())
    {
      localVideoPlayParam.jdField_b_of_type_JavaLangString = ((String)localObject);
      localVideoPlayParam.jdField_j_of_type_JavaLangString = paramBaseArticleInfo.mSubscribeID;
      localVideoPlayParam.jdField_g_of_type_Int = paramBaseArticleInfo.mStrategyId;
      localVideoPlayParam.jdField_f_of_type_Long = paramBaseArticleInfo.mAlgorithmID;
      localObject = new ReadinjoyVideoReportData();
      ((ReadinjoyVideoReportData)localObject).jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.mArticleID);
      ((ReadinjoyVideoReportData)localObject).jdField_a_of_type_JavaLangString = paramBaseArticleInfo.mVideoVid;
      ((ReadinjoyVideoReportData)localObject).jdField_a_of_type_Int = paramBaseArticleInfo.busiType;
      ((ReadinjoyVideoReportData)localObject).jdField_h_of_type_Int = paramBaseArticleInfo.mVideoJsonWidth;
      ((ReadinjoyVideoReportData)localObject).jdField_i_of_type_Int = paramBaseArticleInfo.mVideoJsonHeight;
      ((ReadinjoyVideoReportData)localObject).s = paramBaseArticleInfo.mVideoDuration;
      localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData = ((ReadinjoyVideoReportData)localObject);
      localVideoPlayParam.jdField_c_of_type_JavaLangString = paramBaseArticleInfo.thirdIcon;
      localVideoPlayParam.jdField_d_of_type_JavaLangString = paramBaseArticleInfo.thirdName;
      localVideoPlayParam.jdField_e_of_type_JavaLangString = paramBaseArticleInfo.thirdAction;
      localVideoPlayParam.jdField_e_of_type_Int = paramBaseArticleInfo.busiType;
      localVideoPlayParam.jdField_i_of_type_JavaLangString = paramBaseArticleInfo.innerUniqueID;
      localVideoPlayParam.jdField_e_of_type_Long = paramBaseArticleInfo.mChannelID;
      return localVideoPlayParam;
    }
  }
  
  private ReadInJoyBaseAdapter.VideoFeedsViewHolder a(AbsListView paramAbsListView)
  {
    int i1 = 1;
    if ((!a()) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController == null) || (paramAbsListView.getChildCount() <= 0)) {
      return null;
    }
    if (paramAbsListView.getChildCount() == 1)
    {
      paramAbsListView = paramAbsListView.getChildAt(0);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController.a(paramAbsListView))
      {
        paramAbsListView = paramAbsListView.getTag();
        if ((paramAbsListView instanceof ReadInJoyBaseAdapter.VideoFeedsViewHolder)) {
          return (ReadInJoyBaseAdapter.VideoFeedsViewHolder)paramAbsListView;
        }
      }
    }
    else
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "itemView == null, not auto play");
        }
        i1 += 1;
        if (i1 >= paramAbsListView.getChildCount()) {
          break;
        }
        View localView2 = paramAbsListView.getChildAt(i1 - 1);
        View localView1 = paramAbsListView.getChildAt(i1);
        boolean bool1 = localView2.getTag() instanceof ReadInJoyBaseAdapter.VideoFeedsViewHolder;
        boolean bool2 = localView1.getTag() instanceof ReadInJoyBaseAdapter.VideoFeedsViewHolder;
        if ((bool1) && (bool2)) {
          localView1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController.a(localView2, localView1);
        }
        while ((localView1 != null) && (localView1.getTag() != null) && ((localView1.getTag() instanceof ReadInJoyBaseAdapter.VideoFeedsViewHolder)))
        {
          return (ReadInJoyBaseAdapter.VideoFeedsViewHolder)localView1.getTag();
          if (bool1)
          {
            localView1 = localView2;
            if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController.a(localView2))
            {
              k();
              localView1 = null;
            }
          }
          else if (bool2)
          {
            if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController.a(localView1))
            {
              k();
              localView1 = null;
            }
          }
          else
          {
            localView1 = null;
          }
        }
      }
    }
    return null;
  }
  
  private ReadInJoyBaseAdapter.VideoFeedsViewHolder a(String paramString)
  {
    Object localObject2 = null;
    int i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition();
    int i3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getLastVisiblePosition();
    int i1 = Math.max(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getHeaderViewsCount(), i2);
    for (;;)
    {
      Object localObject1 = localObject2;
      if (i1 <= i3)
      {
        int i4 = i1 - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getHeaderViewsCount();
        localObject1 = b(i4);
        if ((4 != getItemViewType(i4)) || (localObject1 == null) || (!TextUtils.equals(((BaseArticleInfo)localObject1).innerUniqueID, paramString))) {
          break label119;
        }
        paramString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i1 - i2);
        localObject1 = localObject2;
        if (paramString != null) {
          localObject1 = (ReadInJoyBaseAdapter.VideoFeedsViewHolder)paramString.getTag();
        }
      }
      return localObject1;
      label119:
      i1 += 1;
    }
  }
  
  public static String a(long paramLong)
  {
    long l1 = (paramLong >>> 1) / 5L;
    return Long.toString(l1) + (paramLong - 10L * l1);
  }
  
  private ArrayList a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo.mLabelListObj == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramBaseArticleInfo = paramBaseArticleInfo.mLabelListObj.iterator();
    while (paramBaseArticleInfo.hasNext())
    {
      oidb_cmd0x68b.ChannelInfo localChannelInfo = (oidb_cmd0x68b.ChannelInfo)paramBaseArticleInfo.next();
      VideoInfo.ChannelInfo localChannelInfo1 = new VideoInfo.ChannelInfo();
      localChannelInfo1.jdField_a_of_type_Int = localChannelInfo.uint32_channel_id.get();
      localChannelInfo1.jdField_b_of_type_Int = localChannelInfo.uint32_channel_type.get();
      localChannelInfo1.jdField_a_of_type_JavaLangString = localChannelInfo.bytes_channel_name.get().toStringUtf8();
      localChannelInfo1.jdField_b_of_type_JavaLangString = localChannelInfo.bytes_channel_display_name.get().toStringUtf8();
      localChannelInfo1.jdField_c_of_type_JavaLangString = localChannelInfo.bytes_channel_url.get().toStringUtf8();
      localChannelInfo1.jdField_c_of_type_Int = localChannelInfo.uint32_is_topic.get();
      localArrayList.add(localChannelInfo1);
    }
    return localArrayList;
  }
  
  public static JSONArray a(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1);
    if ((paramString1 == null) || (paramString1.length() <= 0)) {
      paramString1 = null;
    }
    do
    {
      return paramString1;
      paramString2 = paramString1.optJSONArray(paramString2);
      if (paramString2 == null) {
        break;
      }
      paramString1 = paramString2;
    } while (paramString2.length() > 0);
    return null;
  }
  
  public static JSONObject a(String paramString)
  {
    try
    {
      paramString = (JSONObject)new JSONTokener(paramString).nextValue();
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    a(paramArticleInfo, "0X8007625", "0X8007625", paramInt);
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    if (paramArticleInfo == null) {
      return;
    }
    String str = "";
    long l2 = paramArticleInfo.mFeedId;
    paramInt1 += 1;
    long l1;
    if ((f(paramArticleInfo)) || (g(paramArticleInfo)) || (h(paramArticleInfo)) || (i(paramArticleInfo)))
    {
      if ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null)) {
        break label233;
      }
      str = Long.toString(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long);
      l1 = 0L;
    }
    for (;;)
    {
      paramArticleInfo = ReadInJoyUtils.a(paramInt2, null, ReadInJoyUtils.a(paramArticleInfo), paramArticleInfo.innerUniqueID, ReadInJoyUtils.a(paramArticleInfo));
      PublicAccountReportUtils.a(null, "CliOper", "", str, "0X8008899", "0X8008899", 0, 0, Long.toString(l2), Long.toString(l1), Integer.toString(paramInt1), paramArticleInfo, false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReadInJoyBaseAdapter", 2, new Object[] { "reportGridImageClickEvent report click data, toUin: ", str, ", r2(feedsId): ", Long.valueOf(l2), ", r3(articleId): ", Long.valueOf(l1), " r4(imagePos): ", Integer.valueOf(paramInt1), ", r5: ", paramArticleInfo });
      return;
      str = paramArticleInfo.mSubscribeID;
      l1 = paramArticleInfo.mArticleID;
      continue;
      label233:
      l1 = 0L;
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, String paramString, int paramInt, Bundle paramBundle)
  {
    if (paramArticleInfo == null) {
      return;
    }
    String str2 = "";
    long l2 = 0L;
    int i2 = 0;
    long l3 = paramArticleInfo.mFeedId;
    int i1;
    String str1;
    long l1;
    if ((f(paramArticleInfo)) || (g(paramArticleInfo)) || (h(paramArticleInfo)) || (i(paramArticleInfo)))
    {
      i1 = i2;
      str1 = str2;
      l1 = l2;
      if (paramArticleInfo.mSocialFeedInfo != null)
      {
        i1 = i2;
        str1 = str2;
        l1 = l2;
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo != null)
        {
          str2 = Long.toString(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long);
          i1 = i2;
          str1 = str2;
          l1 = l2;
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null)
          {
            i1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size();
            l1 = l2;
            str1 = str2;
          }
        }
      }
    }
    for (;;)
    {
      paramString = ReadInJoyUtils.a(i1, paramString, ReadInJoyUtils.a(paramArticleInfo), paramArticleInfo.innerUniqueID);
      paramArticleInfo = ReadInJoyUtils.a(i1, null, ReadInJoyUtils.a(paramArticleInfo), paramArticleInfo.innerUniqueID, ReadInJoyUtils.a(paramArticleInfo));
      paramBundle.putString("to_uin", str1);
      paramBundle.putString("feeds_id", Long.toString(l3));
      paramBundle.putString("article_id", Long.toString(l1));
      paramBundle.putInt("position", paramInt + 1);
      paramBundle.putString("read_article_r5", paramString);
      paramBundle.putString("scroll_image_r5", paramArticleInfo);
      return;
      str2 = paramArticleInfo.mSubscribeID;
      l2 = paramArticleInfo.mArticleID;
      i1 = i2;
      str1 = str2;
      l1 = l2;
      if (paramArticleInfo.mSocialFeedInfo != null)
      {
        i1 = i2;
        str1 = str2;
        l1 = l2;
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo != null)
        {
          i1 = i2;
          str1 = str2;
          l1 = l2;
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null)
          {
            i1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size();
            str1 = str2;
            l1 = l2;
          }
        }
      }
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, String paramString1, String paramString2, int paramInt)
  {
    if ((paramArticleInfo == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    String str = ReadInJoyUtils.a(paramArticleInfo);
    int i1;
    if (paramArticleInfo.hasChannelInfo())
    {
      i1 = paramArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
        break label127;
      }
    }
    label127:
    for (int i2 = 0;; i2 = 1)
    {
      PublicAccountReportUtils.a(null, ReadInJoyUtils.a(paramArticleInfo), paramString1, paramString2, 0, 0, a(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.businessId), Integer.toString(paramArticleInfo.mStrategyId), ReadInJoyUtils.a(paramArticleInfo.mAlgorithmID, ReadInJoyUtils.a(paramArticleInfo), paramInt, i1, i2, NetworkUtil.h(null), str, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, ReadInJoyUtils.c(paramArticleInfo), paramArticleInfo), false);
      return;
      i1 = 0;
      break;
    }
  }
  
  private void a(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.feedsFirstExposurePos == -1)) {
      paramBaseArticleInfo.feedsFirstExposurePos = paramInt;
    }
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, boolean paramBoolean)
  {
    ReadInJoyDisplayUtils.a(paramKandianUrlImageView, paramURL, this.jdField_a_of_type_AndroidAppActivity, paramBoolean);
  }
  
  private void a(ReadInJoyBaseAdapter.VideoFeedsTwoItemViewHolder paramVideoFeedsTwoItemViewHolder, BaseArticleInfo paramBaseArticleInfo)
  {
    paramVideoFeedsTwoItemViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    paramVideoFeedsTwoItemViewHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = ((BaseArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0));
    BaseArticleInfo localBaseArticleInfo = paramVideoFeedsTwoItemViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    paramVideoFeedsTwoItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localBaseArticleInfo.mTitle);
    paramVideoFeedsTwoItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    paramVideoFeedsTwoItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(VideoFeedsHelper.c(localBaseArticleInfo.mVideoPlayCount));
    paramVideoFeedsTwoItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(ReadInJoyDisplayUtils.a(localBaseArticleInfo.mVideoDuration));
    a(paramVideoFeedsTwoItemViewHolder.jdField_a_of_type_ComTencentImageURLImageView, localBaseArticleInfo);
    paramVideoFeedsTwoItemViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(localBaseArticleInfo.mSubscribeName);
    paramVideoFeedsTwoItemViewHolder.jdField_d_of_type_AndroidWidgetTextView.setText(localBaseArticleInfo.mSubscribeName);
    paramVideoFeedsTwoItemViewHolder.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(localBaseArticleInfo.mSubscribeName);
    paramVideoFeedsTwoItemViewHolder.jdField_d_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    paramVideoFeedsTwoItemViewHolder.jdField_b_of_type_AndroidViewViewGroup.setTag(localBaseArticleInfo);
    paramVideoFeedsTwoItemViewHolder.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(this);
    KandianUrlImageView localKandianUrlImageView = paramVideoFeedsTwoItemViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
    if (localBaseArticleInfo.mVideoCoverUrl != null)
    {
      paramBaseArticleInfo = localBaseArticleInfo.mVideoCoverUrl;
      a(localKandianUrlImageView, paramBaseArticleInfo, false);
      paramVideoFeedsTwoItemViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(paramVideoFeedsTwoItemViewHolder);
      paramVideoFeedsTwoItemViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
      VideoFeedsHelper.a(localBaseArticleInfo.mVideoArticleSubsText, localBaseArticleInfo.mVideoArticleSubsColor, paramVideoFeedsTwoItemViewHolder.jdField_e_of_type_AndroidWidgetTextView);
      localBaseArticleInfo = paramVideoFeedsTwoItemViewHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      paramVideoFeedsTwoItemViewHolder.jdField_f_of_type_AndroidWidgetTextView.setText(localBaseArticleInfo.mTitle);
      paramVideoFeedsTwoItemViewHolder.jdField_f_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      paramVideoFeedsTwoItemViewHolder.g.setText(VideoFeedsHelper.c(localBaseArticleInfo.mVideoPlayCount));
      paramVideoFeedsTwoItemViewHolder.h.setText(ReadInJoyDisplayUtils.a(localBaseArticleInfo.mVideoDuration));
      a(paramVideoFeedsTwoItemViewHolder.jdField_b_of_type_ComTencentImageURLImageView, localBaseArticleInfo);
      paramVideoFeedsTwoItemViewHolder.jdField_b_of_type_ComTencentImageURLImageView.setContentDescription(localBaseArticleInfo.mSubscribeName);
      paramVideoFeedsTwoItemViewHolder.i.setText(localBaseArticleInfo.mSubscribeName);
      paramVideoFeedsTwoItemViewHolder.i.setContentDescription(localBaseArticleInfo.mSubscribeName);
      paramVideoFeedsTwoItemViewHolder.i.getPaint().setFakeBoldText(true);
      paramVideoFeedsTwoItemViewHolder.jdField_d_of_type_AndroidViewViewGroup.setTag(localBaseArticleInfo);
      paramVideoFeedsTwoItemViewHolder.jdField_d_of_type_AndroidViewViewGroup.setOnClickListener(this);
      localKandianUrlImageView = paramVideoFeedsTwoItemViewHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
      if (localBaseArticleInfo.mVideoCoverUrl == null) {
        break label411;
      }
      paramBaseArticleInfo = localBaseArticleInfo.mVideoCoverUrl;
    }
    for (;;)
    {
      a(localKandianUrlImageView, paramBaseArticleInfo, false);
      paramVideoFeedsTwoItemViewHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(paramVideoFeedsTwoItemViewHolder);
      paramVideoFeedsTwoItemViewHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
      VideoFeedsHelper.a(localBaseArticleInfo.mVideoArticleSubsText, localBaseArticleInfo.mVideoArticleSubsColor, paramVideoFeedsTwoItemViewHolder.j);
      return;
      if (localBaseArticleInfo.mSinglePicture != null)
      {
        paramBaseArticleInfo = localBaseArticleInfo.mSinglePicture;
        break;
      }
      paramBaseArticleInfo = ReadInJoyUtils.b(localBaseArticleInfo.mFirstPagePicUrl);
      break;
      label411:
      if (localBaseArticleInfo.mSinglePicture != null) {
        paramBaseArticleInfo = localBaseArticleInfo.mSinglePicture;
      } else {
        paramBaseArticleInfo = ReadInJoyUtils.b(localBaseArticleInfo.mFirstPagePicUrl);
      }
    }
  }
  
  private void a(ReadInJoyBaseAdapter.VideoFeedsViewHolder paramVideoFeedsViewHolder, BaseArticleInfo paramBaseArticleInfo)
  {
    VideoPlayManager.VideoPlayParam localVideoPlayParam;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager == null)
    {
      localVideoPlayParam = null;
      if ((localVideoPlayParam != null) && (localVideoPlayParam.jdField_e_of_type_Long == this.jdField_c_of_type_Int)) {
        break label90;
      }
      localVideoPlayParam = a(paramBaseArticleInfo);
      localVideoPlayParam.jdField_a_of_type_AndroidViewView = paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
      localVideoPlayParam.jdField_f_of_type_JavaLangString = paramBaseArticleInfo.mThirdVideoURL;
      localVideoPlayParam.jdField_d_of_type_Long = paramBaseArticleInfo.mThirdVideoURLExpireTime;
    }
    for (;;)
    {
      localVideoPlayParam.jdField_f_of_type_Int = paramVideoFeedsViewHolder.jdField_a_of_type_Int;
      localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
      paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = localVideoPlayParam;
      return;
      localVideoPlayParam = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(paramBaseArticleInfo.mArticleID);
      break;
      label90:
      localVideoPlayParam.jdField_a_of_type_AndroidViewView = paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
    }
  }
  
  /* Error */
  private void a(ReadInJoyBaseAdapter.VideoFeedsViewHolder paramVideoFeedsViewHolder, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: aload_1
    //   7: aload_2
    //   8: invokespecial 1363	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder;Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)V
    //   11: aload_1
    //   12: getfield 629	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoPlayManager$VideoPlayParam;
    //   15: astore 7
    //   17: aload_1
    //   18: getfield 1364	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   21: aload_2
    //   22: getfield 766	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTitle	Ljava/lang/String;
    //   25: invokevirtual 1252	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   28: aload_1
    //   29: getfield 1364	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   32: invokevirtual 1255	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   35: iconst_1
    //   36: invokevirtual 1260	android/text/TextPaint:setFakeBoldText	(Z)V
    //   39: aload_1
    //   40: getfield 1364	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   43: aload_0
    //   44: getfield 164	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   47: invokevirtual 482	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   50: ldc_w 1365
    //   53: invokevirtual 1370	android/content/res/Resources:getColor	(I)I
    //   56: invokevirtual 1373	android/widget/TextView:setTextColor	(I)V
    //   59: aload_2
    //   60: getfield 1265	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoPlayCount	I
    //   63: ifne +673 -> 736
    //   66: aload_1
    //   67: getfield 1374	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   70: bipush 8
    //   72: invokevirtual 1377	android/widget/TextView:setVisibility	(I)V
    //   75: aload_1
    //   76: getfield 1380	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   79: bipush 8
    //   81: invokevirtual 1383	android/widget/ImageView:setVisibility	(I)V
    //   84: aload_1
    //   85: getfield 1384	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   88: aload 7
    //   90: getfield 571	com/tencent/biz/pubaccount/readinjoy/video/VideoPlayManager$VideoPlayParam:jdField_a_of_type_Int	I
    //   93: invokestatic 1271	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyDisplayUtils:a	(I)Ljava/lang/String;
    //   96: invokevirtual 1252	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   99: aload_0
    //   100: aload_1
    //   101: getfield 1385	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   104: aload_2
    //   105: invokespecial 1277	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter:a	(Lcom/tencent/image/URLImageView;Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)V
    //   108: aload_1
    //   109: getfield 1385	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_a_of_type_ComTencentImageURLImageView	Lcom/tencent/image/URLImageView;
    //   112: aload_2
    //   113: getfield 547	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSubscribeName	Ljava/lang/String;
    //   116: invokevirtual 1282	com/tencent/image/URLImageView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   119: aload_2
    //   120: getfield 547	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSubscribeName	Ljava/lang/String;
    //   123: astore 5
    //   125: aload_2
    //   126: invokestatic 1388	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isAdvertisementInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   129: ifeq +1237 -> 1366
    //   132: aload_2
    //   133: checkcast 444	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo
    //   136: astore 6
    //   138: aload_2
    //   139: invokestatic 447	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isAppAdvertisementInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   142: ifeq +648 -> 790
    //   145: new 1106	org/json/JSONObject
    //   148: dup
    //   149: aload 6
    //   151: getfield 1391	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   154: invokespecial 1392	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   157: ldc_w 1394
    //   160: invokevirtual 1398	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   163: astore 6
    //   165: aload 6
    //   167: astore 5
    //   169: aload_2
    //   170: getfield 547	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSubscribeName	Ljava/lang/String;
    //   173: invokevirtual 1399	java/lang/String:length	()I
    //   176: istore 4
    //   178: aload_2
    //   179: invokestatic 1388	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isAdvertisementInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   182: ifeq +618 -> 800
    //   185: bipush 9
    //   187: istore_3
    //   188: iload 4
    //   190: iload_3
    //   191: if_icmple +51 -> 242
    //   194: new 342	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   201: astore 5
    //   203: aload_2
    //   204: getfield 547	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSubscribeName	Ljava/lang/String;
    //   207: astore 6
    //   209: aload_2
    //   210: invokestatic 1388	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isAdvertisementInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   213: ifeq +593 -> 806
    //   216: bipush 8
    //   218: istore_3
    //   219: aload 5
    //   221: aload 6
    //   223: iconst_0
    //   224: iload_3
    //   225: invokevirtual 1403	java/lang/String:substring	(II)Ljava/lang/String;
    //   228: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: ldc_w 1405
    //   234: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 364	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: astore 5
    //   242: aload_1
    //   243: getfield 1406	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   246: iconst_0
    //   247: invokevirtual 1377	android/widget/TextView:setVisibility	(I)V
    //   250: aload_1
    //   251: getfield 1406	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   254: aload 5
    //   256: invokevirtual 1252	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   259: aload_1
    //   260: getfield 1406	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   263: aload_2
    //   264: getfield 547	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSubscribeName	Ljava/lang/String;
    //   267: invokevirtual 1285	android/widget/TextView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   270: aload_1
    //   271: getfield 1406	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   274: invokevirtual 1255	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   277: iconst_1
    //   278: invokevirtual 1260	android/text/TextPaint:setFakeBoldText	(Z)V
    //   281: aload_1
    //   282: getfield 1408	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   285: aload_2
    //   286: invokevirtual 1291	android/view/ViewGroup:setTag	(Ljava/lang/Object;)V
    //   289: aload_1
    //   290: getfield 1408	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   293: aload_0
    //   294: invokevirtual 1295	android/view/ViewGroup:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   297: aload_2
    //   298: invokestatic 1388	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isAdvertisementInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   301: ifeq +619 -> 920
    //   304: aload_2
    //   305: checkcast 444	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo
    //   308: astore 5
    //   310: aload_1
    //   311: getfield 1409	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:i	Landroid/widget/TextView;
    //   314: iconst_0
    //   315: invokevirtual 1377	android/widget/TextView:setVisibility	(I)V
    //   318: aload_1
    //   319: getfield 1409	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:i	Landroid/widget/TextView;
    //   322: aload_0
    //   323: ldc_w 1411
    //   326: invokestatic 1417	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   329: invokespecial 1419	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter:a	(I)Landroid/graphics/drawable/ShapeDrawable;
    //   332: invokestatic 1424	com/tencent/biz/pubaccount/readinjoy/common/ApiCompatibilityUtils:a	(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V
    //   335: aload_2
    //   336: getfield 1427	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptText	Ljava/lang/String;
    //   339: invokestatic 470	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   342: ifne +470 -> 812
    //   345: aload_1
    //   346: getfield 1409	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:i	Landroid/widget/TextView;
    //   349: aload_2
    //   350: getfield 1427	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleSubscriptText	Ljava/lang/String;
    //   353: invokevirtual 1252	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   356: aload_1
    //   357: getfield 1430	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_b_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   360: iconst_0
    //   361: invokevirtual 1433	android/widget/LinearLayout:setVisibility	(I)V
    //   364: aload_2
    //   365: invokestatic 447	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:isAppAdvertisementInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   368: ifeq +506 -> 874
    //   371: new 1106	org/json/JSONObject
    //   374: dup
    //   375: aload 5
    //   377: getfield 1391	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExt	Ljava/lang/String;
    //   380: invokespecial 1392	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   383: astore 5
    //   385: aload_0
    //   386: getfield 164	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   389: aload 5
    //   391: ldc_w 1435
    //   394: invokevirtual 1438	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   397: invokestatic 1443	com/tencent/mobileqq/utils/PackageUtil:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   400: ifeq +432 -> 832
    //   403: aload_1
    //   404: getfield 1444	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:j	Landroid/widget/TextView;
    //   407: aload_0
    //   408: getfield 164	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   411: ldc_w 1445
    //   414: invokevirtual 1447	android/app/Activity:getString	(I)Ljava/lang/String;
    //   417: invokevirtual 1252	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   420: aload_0
    //   421: aload_1
    //   422: invokespecial 1450	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter:b	(Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder;)V
    //   425: aload_1
    //   426: getfield 1453	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup;
    //   429: bipush 8
    //   431: invokevirtual 1456	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup:setVisibility	(I)V
    //   434: aload_1
    //   435: getfield 1458	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   438: bipush 8
    //   440: invokevirtual 1433	android/widget/LinearLayout:setVisibility	(I)V
    //   443: aload_2
    //   444: getfield 1307	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoArticleSubsText	Ljava/lang/String;
    //   447: aload_2
    //   448: getfield 1310	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoArticleSubsColor	Ljava/lang/String;
    //   451: aload_1
    //   452: getfield 1459	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   455: invokestatic 1315	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsHelper:a	(Ljava/lang/String;Ljava/lang/String;Landroid/widget/TextView;)V
    //   458: aload_1
    //   459: getfield 1342	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   462: astore 6
    //   464: aload_2
    //   465: getfield 929	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoCoverUrl	Ljava/net/URL;
    //   468: ifnull +538 -> 1006
    //   471: aload_2
    //   472: getfield 929	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoCoverUrl	Ljava/net/URL;
    //   475: astore 5
    //   477: aload_0
    //   478: aload 6
    //   480: aload 5
    //   482: iconst_0
    //   483: invokespecial 1300	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;Ljava/net/URL;Z)V
    //   486: aload_1
    //   487: getfield 1342	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   490: aload_0
    //   491: invokevirtual 1304	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   494: aload_1
    //   495: getfield 1342	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   498: aload_1
    //   499: invokevirtual 1303	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setTag	(Ljava/lang/Object;)V
    //   502: aload_1
    //   503: getfield 1384	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   506: iconst_0
    //   507: invokevirtual 1377	android/widget/TextView:setVisibility	(I)V
    //   510: aload_1
    //   511: getfield 1384	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   514: invokevirtual 1462	android/widget/TextView:clearAnimation	()V
    //   517: aload_1
    //   518: getfield 1465	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   521: fconst_1
    //   522: aload 7
    //   524: getfield 731	com/tencent/biz/pubaccount/readinjoy/video/VideoPlayManager$VideoPlayParam:jdField_b_of_type_Int	I
    //   527: aload 7
    //   529: getfield 734	com/tencent/biz/pubaccount/readinjoy/video/VideoPlayManager$VideoPlayParam:jdField_c_of_type_Int	I
    //   532: invokestatic 1468	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyDisplayUtils:a	(II)F
    //   535: invokevirtual 1474	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setCustomSize	(FF)V
    //   538: aload_1
    //   539: getfield 1465	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   542: aload_0
    //   543: invokevirtual 1475	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   546: aload_1
    //   547: getfield 1465	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup;
    //   550: aload_1
    //   551: invokevirtual 1476	com/tencent/biz/pubaccount/readinjoy/view/VideoViewGroup:setTag	(Ljava/lang/Object;)V
    //   554: aload_0
    //   555: aload_0
    //   556: getfield 94	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter:jdField_c_of_type_Int	I
    //   559: aload_2
    //   560: getfield 922	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   563: invokevirtual 1479	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter:b	(IJ)Z
    //   566: ifeq +23 -> 589
    //   569: aload_1
    //   570: getfield 1481	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   573: aload_0
    //   574: getfield 164	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   577: invokevirtual 482	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   580: ldc_w 1482
    //   583: invokevirtual 1370	android/content/res/Resources:getColor	(I)I
    //   586: invokevirtual 1485	android/view/View:setBackgroundColor	(I)V
    //   589: aload_1
    //   590: getfield 1488	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_a_of_type_AndroidWidgetFrameLayout	Landroid/widget/FrameLayout;
    //   593: aload_0
    //   594: invokevirtual 1491	android/widget/FrameLayout:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   597: aload_1
    //   598: getfield 1488	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_a_of_type_AndroidWidgetFrameLayout	Landroid/widget/FrameLayout;
    //   601: aload_1
    //   602: invokevirtual 1492	android/widget/FrameLayout:setTag	(Ljava/lang/Object;)V
    //   605: aload_2
    //   606: getfield 1495	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoCommentCount	I
    //   609: ifle +458 -> 1067
    //   612: aload_2
    //   613: getfield 1495	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoCommentCount	I
    //   616: sipush 1000
    //   619: if_icmplt +415 -> 1034
    //   622: aload_1
    //   623: getfield 1496	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   626: ldc_w 1498
    //   629: invokevirtual 1252	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   632: aload_1
    //   633: getfield 1496	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   636: aload_0
    //   637: invokevirtual 1499	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   640: aload_1
    //   641: getfield 1496	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   644: aload_1
    //   645: invokevirtual 1500	android/widget/TextView:setTag	(Ljava/lang/Object;)V
    //   648: aload_1
    //   649: getfield 1503	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   652: aload_0
    //   653: invokevirtual 1506	android/widget/RelativeLayout:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   656: aload_1
    //   657: getfield 1503	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   660: aload_1
    //   661: invokevirtual 1507	android/widget/RelativeLayout:setTag	(Ljava/lang/Object;)V
    //   664: aload_2
    //   665: getfield 600	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   668: lconst_0
    //   669: lcmp
    //   670: ifgt +410 -> 1080
    //   673: aload_1
    //   674: getfield 1508	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:g	Landroid/widget/TextView;
    //   677: ldc_w 1510
    //   680: invokevirtual 1252	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   683: aload_0
    //   684: getfield 164	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   687: invokestatic 1208	com/tencent/mobileqq/utils/NetworkUtil:h	(Landroid/content/Context;)Z
    //   690: ifeq +426 -> 1116
    //   693: aload_1
    //   694: getfield 1512	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_d_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   697: iconst_0
    //   698: invokevirtual 1383	android/widget/ImageView:setVisibility	(I)V
    //   701: aload_1
    //   702: getfield 1508	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:g	Landroid/widget/TextView;
    //   705: bipush 8
    //   707: invokevirtual 1377	android/widget/TextView:setVisibility	(I)V
    //   710: aload_1
    //   711: getfield 1514	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   714: iconst_0
    //   715: invokevirtual 1515	android/view/View:setVisibility	(I)V
    //   718: aload_1
    //   719: getfield 1517	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   722: iconst_0
    //   723: invokevirtual 1485	android/view/View:setBackgroundColor	(I)V
    //   726: aload_1
    //   727: getfield 1519	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   730: bipush 8
    //   732: invokevirtual 1515	android/view/View:setVisibility	(I)V
    //   735: return
    //   736: aload_1
    //   737: getfield 1374	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   740: iconst_0
    //   741: invokevirtual 1377	android/widget/TextView:setVisibility	(I)V
    //   744: aload_1
    //   745: getfield 1380	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   748: iconst_0
    //   749: invokevirtual 1383	android/widget/ImageView:setVisibility	(I)V
    //   752: aload_1
    //   753: getfield 1374	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   756: aload_2
    //   757: getfield 1265	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoPlayCount	I
    //   760: invokestatic 1267	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsHelper:c	(I)Ljava/lang/String;
    //   763: invokevirtual 1252	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   766: goto -682 -> 84
    //   769: astore 6
    //   771: invokestatic 318	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   774: ifeq +13 -> 787
    //   777: ldc_w 320
    //   780: iconst_2
    //   781: ldc_w 1521
    //   784: invokestatic 325	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   787: goto -618 -> 169
    //   790: aload 6
    //   792: getfield 1524	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdCorporateImageName	Ljava/lang/String;
    //   795: astore 5
    //   797: goto -628 -> 169
    //   800: bipush 18
    //   802: istore_3
    //   803: goto -615 -> 188
    //   806: bipush 17
    //   808: istore_3
    //   809: goto -590 -> 219
    //   812: aload_1
    //   813: getfield 1409	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:i	Landroid/widget/TextView;
    //   816: aload_0
    //   817: getfield 164	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   820: ldc_w 1525
    //   823: invokevirtual 1447	android/app/Activity:getString	(I)Ljava/lang/String;
    //   826: invokevirtual 1252	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   829: goto -473 -> 356
    //   832: aload_1
    //   833: getfield 1444	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:j	Landroid/widget/TextView;
    //   836: aload_0
    //   837: getfield 164	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   840: ldc_w 1526
    //   843: invokevirtual 1447	android/app/Activity:getString	(I)Ljava/lang/String;
    //   846: invokevirtual 1252	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   849: goto -429 -> 420
    //   852: astore 5
    //   854: aload_1
    //   855: getfield 1444	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:j	Landroid/widget/TextView;
    //   858: aload_0
    //   859: getfield 164	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   862: ldc_w 1527
    //   865: invokevirtual 1447	android/app/Activity:getString	(I)Ljava/lang/String;
    //   868: invokevirtual 1252	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   871: goto -451 -> 420
    //   874: aload 5
    //   876: getfield 1530	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdBtnTxt	Ljava/lang/String;
    //   879: invokestatic 470	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   882: ifne +18 -> 900
    //   885: aload_1
    //   886: getfield 1444	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:j	Landroid/widget/TextView;
    //   889: aload 5
    //   891: getfield 1530	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdBtnTxt	Ljava/lang/String;
    //   894: invokevirtual 1252	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   897: goto -477 -> 420
    //   900: aload_1
    //   901: getfield 1444	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:j	Landroid/widget/TextView;
    //   904: aload_0
    //   905: getfield 164	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   908: ldc_w 1527
    //   911: invokevirtual 1447	android/app/Activity:getString	(I)Ljava/lang/String;
    //   914: invokevirtual 1252	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   917: goto -497 -> 420
    //   920: aload_1
    //   921: getfield 1409	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:i	Landroid/widget/TextView;
    //   924: bipush 8
    //   926: invokevirtual 1377	android/widget/TextView:setVisibility	(I)V
    //   929: aload_1
    //   930: getfield 1430	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_b_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   933: bipush 8
    //   935: invokevirtual 1433	android/widget/LinearLayout:setVisibility	(I)V
    //   938: aload_1
    //   939: getfield 1453	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup;
    //   942: iconst_0
    //   943: invokevirtual 1456	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup:setVisibility	(I)V
    //   946: aload_1
    //   947: getfield 1458	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   950: iconst_0
    //   951: invokevirtual 1433	android/widget/LinearLayout:setVisibility	(I)V
    //   954: aload_1
    //   955: getfield 1453	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup	Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup;
    //   958: aload_2
    //   959: aload_0
    //   960: aload_0
    //   961: getfield 94	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter:jdField_c_of_type_Int	I
    //   964: aload_0
    //   965: getfield 186	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   968: invokevirtual 1534	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyVideoInfoViewGroup:setArticleInfo	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;Landroid/widget/BaseAdapter;ILjava/util/Set;)V
    //   971: aload_1
    //   972: getfield 1536	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   975: aload_0
    //   976: invokevirtual 1537	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   979: aload_1
    //   980: getfield 1536	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   983: aload_1
    //   984: invokevirtual 1538	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   987: aload_1
    //   988: getfield 1540	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   991: aload_0
    //   992: invokevirtual 1537	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   995: aload_1
    //   996: getfield 1540	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   999: aload_1
    //   1000: invokevirtual 1538	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   1003: goto -560 -> 443
    //   1006: aload_2
    //   1007: getfield 1334	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSinglePicture	Ljava/net/URL;
    //   1010: ifnull +12 -> 1022
    //   1013: aload_2
    //   1014: getfield 1334	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSinglePicture	Ljava/net/URL;
    //   1017: astore 5
    //   1019: goto -542 -> 477
    //   1022: aload_2
    //   1023: getfield 1335	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFirstPagePicUrl	Ljava/lang/String;
    //   1026: invokestatic 1338	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyUtils:b	(Ljava/lang/String;)Ljava/net/URL;
    //   1029: astore 5
    //   1031: goto -554 -> 477
    //   1034: aload_1
    //   1035: getfield 1496	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1038: new 342	java/lang/StringBuilder
    //   1041: dup
    //   1042: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   1045: ldc_w 804
    //   1048: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1051: aload_2
    //   1052: getfield 1495	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoCommentCount	I
    //   1055: invokevirtual 360	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1058: invokevirtual 364	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1061: invokevirtual 1252	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1064: goto -432 -> 632
    //   1067: aload_1
    //   1068: getfield 1496	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1071: ldc_w 1542
    //   1074: invokevirtual 1252	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1077: goto -445 -> 632
    //   1080: aload_1
    //   1081: getfield 1508	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:g	Landroid/widget/TextView;
    //   1084: new 342	java/lang/StringBuilder
    //   1087: dup
    //   1088: invokespecial 343	java/lang/StringBuilder:<init>	()V
    //   1091: aload_2
    //   1092: getfield 600	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mXGFileSize	J
    //   1095: invokestatic 1543	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsHelper:b	(J)Ljava/lang/String;
    //   1098: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1101: ldc_w 1545
    //   1104: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1107: invokevirtual 364	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1110: invokevirtual 1252	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1113: goto -430 -> 683
    //   1116: aload_1
    //   1117: getfield 1512	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_d_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   1120: bipush 8
    //   1122: invokevirtual 1383	android/widget/ImageView:setVisibility	(I)V
    //   1125: aload_0
    //   1126: getfield 164	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1129: invokevirtual 482	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1132: ldc_w 1546
    //   1135: invokevirtual 1550	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   1138: astore_2
    //   1139: aload_1
    //   1140: getfield 1508	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:g	Landroid/widget/TextView;
    //   1143: aload_2
    //   1144: aconst_null
    //   1145: aconst_null
    //   1146: aconst_null
    //   1147: invokevirtual 1554	android/widget/TextView:setCompoundDrawablesWithIntrinsicBounds	(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    //   1150: aload_1
    //   1151: getfield 1508	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:g	Landroid/widget/TextView;
    //   1154: ldc_w 1555
    //   1157: aload_0
    //   1158: getfield 164	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1161: invokevirtual 482	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1164: invokestatic 487	com/tencent/mobileqq/activity/aio/AIOUtils:a	(FLandroid/content/res/Resources;)I
    //   1167: invokevirtual 1558	android/widget/TextView:setCompoundDrawablePadding	(I)V
    //   1170: aload_1
    //   1171: getfield 1508	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:g	Landroid/widget/TextView;
    //   1174: iconst_0
    //   1175: invokevirtual 1377	android/widget/TextView:setVisibility	(I)V
    //   1178: invokestatic 1562	com/tencent/mobileqq/vip/CUKingCardHelper:a	()I
    //   1181: iconst_1
    //   1182: if_icmpne +41 -> 1223
    //   1185: aload_1
    //   1186: getfield 1508	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:g	Landroid/widget/TextView;
    //   1189: ldc_w 1564
    //   1192: invokevirtual 1252	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1195: aload_1
    //   1196: getfield 1565	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:h	Landroid/widget/TextView;
    //   1199: bipush 8
    //   1201: invokevirtual 1377	android/widget/TextView:setVisibility	(I)V
    //   1204: aload_1
    //   1205: getfield 1514	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   1208: iconst_0
    //   1209: invokevirtual 1515	android/view/View:setVisibility	(I)V
    //   1212: aload_1
    //   1213: getfield 1517	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   1216: iconst_0
    //   1217: invokevirtual 1485	android/view/View:setBackgroundColor	(I)V
    //   1220: goto -494 -> 726
    //   1223: aload_0
    //   1224: getfield 1567	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter:o	Z
    //   1227: ifne +111 -> 1338
    //   1230: aload_1
    //   1231: getfield 1352	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_a_of_type_Int	I
    //   1234: ifne +104 -> 1338
    //   1237: ldc_w 1569
    //   1240: invokestatic 1571	com/tencent/mobileqq/vip/CUKingCardHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1243: invokestatic 470	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1246: ifne +48 -> 1294
    //   1249: aload_1
    //   1250: getfield 1565	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:h	Landroid/widget/TextView;
    //   1253: iconst_0
    //   1254: invokevirtual 1377	android/widget/TextView:setVisibility	(I)V
    //   1257: aload_0
    //   1258: getfield 164	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1261: aload_1
    //   1262: getfield 1565	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:h	Landroid/widget/TextView;
    //   1265: invokestatic 1574	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsHelper:a	(Landroid/content/Context;Landroid/widget/TextView;)V
    //   1268: aload_1
    //   1269: getfield 1517	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   1272: ldc_w 1575
    //   1275: invokevirtual 1485	android/view/View:setBackgroundColor	(I)V
    //   1278: aload_1
    //   1279: getfield 1514	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   1282: iconst_0
    //   1283: invokevirtual 1515	android/view/View:setVisibility	(I)V
    //   1286: aload_0
    //   1287: iconst_1
    //   1288: putfield 1567	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter:o	Z
    //   1291: goto -565 -> 726
    //   1294: aload_1
    //   1295: getfield 1565	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:h	Landroid/widget/TextView;
    //   1298: bipush 8
    //   1300: invokevirtual 1377	android/widget/TextView:setVisibility	(I)V
    //   1303: aload_1
    //   1304: getfield 1514	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   1307: iconst_0
    //   1308: invokevirtual 1515	android/view/View:setVisibility	(I)V
    //   1311: aload_1
    //   1312: getfield 1517	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   1315: iconst_0
    //   1316: invokevirtual 1485	android/view/View:setBackgroundColor	(I)V
    //   1319: invokestatic 318	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1322: ifeq -596 -> 726
    //   1325: ldc_w 997
    //   1328: iconst_2
    //   1329: ldc_w 1577
    //   1332: invokestatic 1580	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1335: goto -609 -> 726
    //   1338: aload_1
    //   1339: getfield 1565	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:h	Landroid/widget/TextView;
    //   1342: bipush 8
    //   1344: invokevirtual 1377	android/widget/TextView:setVisibility	(I)V
    //   1347: aload_1
    //   1348: getfield 1514	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   1351: iconst_0
    //   1352: invokevirtual 1515	android/view/View:setVisibility	(I)V
    //   1355: aload_1
    //   1356: getfield 1517	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter$VideoFeedsViewHolder:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   1359: iconst_0
    //   1360: invokevirtual 1485	android/view/View:setBackgroundColor	(I)V
    //   1363: goto -637 -> 726
    //   1366: goto -1197 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1369	0	this	ReadInJoyBaseAdapter
    //   0	1369	1	paramVideoFeedsViewHolder	ReadInJoyBaseAdapter.VideoFeedsViewHolder
    //   0	1369	2	paramBaseArticleInfo	BaseArticleInfo
    //   0	1369	3	paramInt	int
    //   176	16	4	i1	int
    //   123	673	5	localObject1	Object
    //   852	38	5	localJSONException1	JSONException
    //   1017	13	5	localURL	URL
    //   136	343	6	localObject2	Object
    //   769	22	6	localJSONException2	JSONException
    //   15	513	7	localVideoPlayParam	VideoPlayManager.VideoPlayParam
    // Exception table:
    //   from	to	target	type
    //   145	165	769	org/json/JSONException
    //   371	420	852	org/json/JSONException
    //   832	849	852	org/json/JSONException
  }
  
  private void a(ReadInJoyBaseAdapter.WeishiGridTwoItemViewHolder paramWeishiGridTwoItemViewHolder, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    paramWeishiGridTwoItemViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    paramWeishiGridTwoItemViewHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = ((BaseArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0));
    BaseArticleInfo localBaseArticleInfo = paramWeishiGridTwoItemViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    paramWeishiGridTwoItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localBaseArticleInfo.mTitle);
    paramWeishiGridTwoItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    paramWeishiGridTwoItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(VideoFeedsHelper.c(localBaseArticleInfo.mVideoPlayCount));
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840844);
    paramInt = ViewUtils.b(8.0F);
    ((Drawable)localObject).setBounds(0, 0, paramInt, paramInt);
    paramWeishiGridTwoItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
    paramWeishiGridTwoItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(ViewUtils.b(3.0F));
    if (localBaseArticleInfo.mVideoCommentCount > 0)
    {
      paramBaseArticleInfo = VideoFeedsHelper.c(localBaseArticleInfo.mVideoCommentCount);
      paramWeishiGridTwoItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(paramBaseArticleInfo + "评论");
      KandianUrlImageView localKandianUrlImageView = paramWeishiGridTwoItemViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
      if (localBaseArticleInfo.mVideoCoverUrl == null) {
        break label409;
      }
      paramBaseArticleInfo = localBaseArticleInfo.mVideoCoverUrl;
      label186:
      a(localKandianUrlImageView, paramBaseArticleInfo, false);
      paramWeishiGridTwoItemViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(paramWeishiGridTwoItemViewHolder);
      paramWeishiGridTwoItemViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
      VideoFeedsHelper.a(localBaseArticleInfo.mVideoArticleSubsText, localBaseArticleInfo.mVideoArticleSubsColor, paramWeishiGridTwoItemViewHolder.jdField_d_of_type_AndroidWidgetTextView);
      localBaseArticleInfo = paramWeishiGridTwoItemViewHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      paramWeishiGridTwoItemViewHolder.jdField_e_of_type_AndroidWidgetTextView.setText(localBaseArticleInfo.mTitle);
      paramWeishiGridTwoItemViewHolder.jdField_e_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      paramWeishiGridTwoItemViewHolder.jdField_f_of_type_AndroidWidgetTextView.setText(VideoFeedsHelper.c(localBaseArticleInfo.mVideoPlayCount));
      paramWeishiGridTwoItemViewHolder.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
      paramWeishiGridTwoItemViewHolder.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(ViewUtils.b(3.0F));
      if (localBaseArticleInfo.mVideoCommentCount <= 0) {
        break label438;
      }
      paramBaseArticleInfo = VideoFeedsHelper.c(localBaseArticleInfo.mVideoCommentCount);
      label313:
      paramWeishiGridTwoItemViewHolder.g.setText(paramBaseArticleInfo + "评论");
      localObject = paramWeishiGridTwoItemViewHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
      if (localBaseArticleInfo.mVideoCoverUrl == null) {
        break label445;
      }
      paramBaseArticleInfo = localBaseArticleInfo.mVideoCoverUrl;
    }
    for (;;)
    {
      a((KandianUrlImageView)localObject, paramBaseArticleInfo, false);
      paramWeishiGridTwoItemViewHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setTag(paramWeishiGridTwoItemViewHolder);
      paramWeishiGridTwoItemViewHolder.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
      VideoFeedsHelper.a(localBaseArticleInfo.mVideoArticleSubsText, localBaseArticleInfo.mVideoArticleSubsColor, paramWeishiGridTwoItemViewHolder.h);
      return;
      paramBaseArticleInfo = "0";
      break;
      label409:
      if (localBaseArticleInfo.mSinglePicture != null)
      {
        paramBaseArticleInfo = localBaseArticleInfo.mSinglePicture;
        break label186;
      }
      paramBaseArticleInfo = ReadInJoyUtils.b(localBaseArticleInfo.mFirstPagePicUrl);
      break label186;
      label438:
      paramBaseArticleInfo = "0";
      break label313;
      label445:
      if (localBaseArticleInfo.mSinglePicture != null) {
        paramBaseArticleInfo = localBaseArticleInfo.mSinglePicture;
      } else {
        paramBaseArticleInfo = ReadInJoyUtils.b(localBaseArticleInfo.mFirstPagePicUrl);
      }
    }
  }
  
  private void a(URLImageView paramURLImageView, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject = null;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ImageUtil.b();
    }
    if ((paramBaseArticleInfo.busiType == 1) && (!AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo)))
    {
      paramURLImageView.setImageDrawable(FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramBaseArticleInfo.mSubscribeID, 3, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable));
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = paramURLImageView.getWidth();
    localURLDrawableOptions.mRequestHeight = paramURLImageView.getHeight();
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    label207:
    label339:
    for (;;)
    {
      AdvertisementInfo localAdvertisementInfo;
      boolean bool;
      try
      {
        if (!AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo)) {
          break label275;
        }
        localAdvertisementInfo = (AdvertisementInfo)paramBaseArticleInfo;
        bool = AdvertisementInfo.isAppAdvertisementInfo(paramBaseArticleInfo);
        if (!bool) {
          break label245;
        }
      }
      catch (MalformedURLException paramURLImageView) {}
      try
      {
        paramBaseArticleInfo = new JSONObject(localAdvertisementInfo.mAdExt).getString("applogo");
        bool = TextUtils.isEmpty(paramBaseArticleInfo);
        if (!bool) {
          break label207;
        }
        paramBaseArticleInfo = null;
      }
      catch (JSONException paramBaseArticleInfo)
      {
        paramBaseArticleInfo = localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReadInJoyBaseAdapter", 2, "cannot get avatar from app advertisement");
        paramBaseArticleInfo = localObject;
        continue;
      }
      if (paramBaseArticleInfo == null)
      {
        paramURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        paramURLImageView.setVisibility(0);
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ReadInJoyBaseAdapter", 2, "configVideoItemUI() ERROR e = " + paramURLImageView.getMessage());
        return;
        paramBaseArticleInfo = new URL(paramBaseArticleInfo);
        continue;
        label245:
        paramBaseArticleInfo = localObject;
        if (TextUtils.isEmpty(localAdvertisementInfo.mAdCorporateLogo)) {
          continue;
        }
        paramBaseArticleInfo = new URL(localAdvertisementInfo.mAdCorporateLogo);
        continue;
        if (TextUtils.isEmpty(paramBaseArticleInfo.thirdIcon))
        {
          paramBaseArticleInfo = new URL("https://q.url.cn/s/jBJuV");
          break label339;
        }
        paramBaseArticleInfo = new URL(paramBaseArticleInfo.thirdIcon);
        break label339;
      }
      paramBaseArticleInfo = URLDrawable.getDrawable(paramBaseArticleInfo, localURLDrawableOptions);
      paramBaseArticleInfo.setDecodeHandler(URLDrawableDecodeHandler.a);
      paramURLImageView.setImageDrawable(paramBaseArticleInfo);
      paramURLImageView.setVisibility(0);
      return;
    }
  }
  
  private void a(AbsListView paramAbsListView)
  {
    if (paramAbsListView.getFirstVisiblePosition() == 0)
    {
      this.jdField_n_of_type_Int = 0;
      return;
    }
    ThreadManager.post(new mfv(this, paramAbsListView), 8, null, true);
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = ReadInJoyConstants.jdField_i_of_type_JavaLangString + Base64Util.encodeToString(String.valueOf(paramString).getBytes(), 2);
    ReadInJoyUtils.a(a(), paramString);
  }
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return false;
    }
    switch (paramArticleInfo.mFeedType)
    {
    case 10: 
    case 11: 
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mFeedType == 1) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.b != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.b.longValue() == 11L);
  }
  
  private boolean a(AbsListView paramAbsListView)
  {
    float f1 = paramAbsListView.getFlingVelocity();
    float f2 = (float)DeviceInfoUtil.k();
    return (f1 > 0.0F) && (f1 > f2 * 1.0F);
  }
  
  public static int b(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null))
    {
      QLog.d("ReadInJoyBaseAdapter", 1, "getTopicRecommendAndUpdateUGCType ugc feeds info is null.");
      return 54;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int)
    {
    case 1: 
    default: 
      return 54;
    case 2: 
    case 3: 
      return 55;
    }
    return 56;
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "cpu:" + DeviceInfoUtil.b() + " mem:" + DeviceInfoUtil.e() + " fre:" + DeviceInfoUtil.a());
    }
    int i1 = DeviceInfoUtil.b();
    long l1 = DeviceInfoUtil.e();
    if ((i1 >= 4) && (l1 >= 1610612736.0D))
    {
      jdField_k_of_type_Int = 6;
      return;
    }
    jdField_k_of_type_Int = 4;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "preloadImg start:" + paramInt1 + " count:" + paramInt2);
    }
    long l1 = System.currentTimeMillis();
    if (!NetworkUtil.h(this.jdField_a_of_type_AndroidAppActivity)) {
      return;
    }
    ArrayList localArrayList = new ArrayList(this.jdField_b_of_type_JavaUtilList);
    ThreadManager.post(new mgn(this, this.jdField_b_of_type_Long, localArrayList, paramInt1, paramInt2, l1), 5, null, true);
  }
  
  public static void b(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramArticleInfo == null) {
      return;
    }
    int i1;
    label17:
    int i2;
    label29:
    String str1;
    String str2;
    if (paramArticleInfo.hasChannelInfo())
    {
      i1 = paramArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
        break label233;
      }
      i2 = 0;
      str1 = ReadInJoyUtils.a(paramArticleInfo);
      str2 = ReadInJoyUtils.a(paramArticleInfo.mAlgorithmID, ReadInJoyUtils.a(paramArticleInfo), paramInt, i1, i2, NetworkUtil.h(null), str1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, ReadInJoyUtils.c(paramArticleInfo), paramArticleInfo);
      if ((!f(paramArticleInfo)) && (!g(paramArticleInfo)) && (!h(paramArticleInfo)) && (!i(paramArticleInfo))) {
        break label238;
      }
      if ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null)) {
        break label247;
      }
      str1 = Long.toString(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long);
    }
    for (;;)
    {
      PublicAccountReportUtils.a(null, "CliOper", "", str1, "0X8007625", "0X8007625", 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), str2, false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReadInJoyBaseAdapter", 2, new Object[] { "reportGridClickEvent channelId: ", Integer.valueOf(paramInt), ", toUin: ", str1, ", r5: ", str2 });
      return;
      i1 = 0;
      break label17;
      label233:
      i2 = 1;
      break label29;
      label238:
      str1 = paramArticleInfo.mSubscribeID;
      continue;
      label247:
      str1 = "";
    }
  }
  
  private static void b(BaseReportData paramBaseReportData)
  {
    if (ReadInJoyUtils.e(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
      paramBaseReportData.jdField_b_of_type_Boolean = true;
    }
    while (paramBaseReportData.jdField_b_of_type_Boolean) {
      return;
    }
    paramBaseReportData.jdField_b_of_type_Boolean = true;
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = ReadInJoyUtils.a();
    localReportInfo.mSource = 0;
    localReportInfo.mSourceArticleId = paramBaseReportData.jdField_a_of_type_JavaLangLong.longValue();
    localReportInfo.mChannelId = 0;
    localReportInfo.mAlgorithmId = ((int)paramBaseReportData.jdField_a_of_type_Long);
    localReportInfo.mStrategyId = paramBaseReportData.jdField_b_of_type_Int;
    localReportInfo.mOperation = 7;
    localReportInfo.mServerContext = paramBaseReportData.jdField_a_of_type_ArrayOfByte;
    localReportInfo.mReadTimeLength = -1;
    if ((paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo != null) && (!ReadInJoyUtils.f(paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)))
    {
      ReportInfo.FeedsReportData localFeedsReportData = new ReportInfo.FeedsReportData();
      localFeedsReportData.jdField_a_of_type_Long = paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null) {
        localFeedsReportData.jdField_b_of_type_Long = paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
      }
      localFeedsReportData.jdField_a_of_type_Int = paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      localFeedsReportData.jdField_b_of_type_Int = paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
      paramBaseReportData = paramBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((paramBaseReportData != null) && (!paramBaseReportData.isEmpty()))
      {
        localFeedsReportData.jdField_a_of_type_JavaUtilList = new ArrayList();
        paramBaseReportData = paramBaseReportData.iterator();
        while (paramBaseReportData.hasNext())
        {
          SocializeFeedsInfo.FeedsInfoUser localFeedsInfoUser = (SocializeFeedsInfo.FeedsInfoUser)paramBaseReportData.next();
          if (localFeedsInfoUser != null) {
            localFeedsReportData.jdField_a_of_type_JavaUtilList.add(Long.valueOf(localFeedsInfoUser.jdField_a_of_type_Long));
          }
        }
      }
      localReportInfo.mFeedsReportData = localFeedsReportData;
    }
    localArrayList.add(localReportInfo);
    QLog.d("ReadInJoyBaseAdapter", 2, "report0x64eExposureInfo: article " + localReportInfo.mSourceArticleId + " exposed!");
    ReadInJoyLogicEngine.a().a(localArrayList);
  }
  
  private void b(ReadInJoyBaseAdapter.VideoFeedsViewHolder paramVideoFeedsViewHolder)
  {
    if (paramVideoFeedsViewHolder == null) {
      return;
    }
    paramVideoFeedsViewHolder.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
    paramVideoFeedsViewHolder.j.setOnClickListener(this);
    paramVideoFeedsViewHolder.i.setOnClickListener(this);
    paramVideoFeedsViewHolder.i.setTag(paramVideoFeedsViewHolder);
    paramVideoFeedsViewHolder.j.setTag(paramVideoFeedsViewHolder);
    paramVideoFeedsViewHolder.jdField_e_of_type_AndroidWidgetImageView.setTag(paramVideoFeedsViewHolder);
  }
  
  private void b(AbsListView paramAbsListView)
  {
    paramAbsListView = a(paramAbsListView);
    if (paramAbsListView != null)
    {
      VideoPlayManager.VideoPlayParam localVideoPlayParam1 = paramAbsListView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam;
      VideoPlayManager.VideoPlayParam localVideoPlayParam2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
      if ((localVideoPlayParam2 == null) || (localVideoPlayParam2.jdField_a_of_type_Long != localVideoPlayParam1.jdField_a_of_type_Long) || (localVideoPlayParam2.jdField_e_of_type_Long != this.jdField_c_of_type_Int) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.c()) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.d()))
      {
        VideoVolumeControl.a().b();
        a(paramAbsListView);
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "checkPlayableArea vid: " + localVideoPlayParam1.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
  
  private void b(AbsListView paramAbsListView, int paramInt)
  {
    if ((this.jdField_c_of_type_Int == 0) || (this.jdField_c_of_type_Int == 40677)) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController.a()) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController.b()) || (paramAbsListView == null) || (paramAbsListView.getVisibility() != 0));
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, paramInt);
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video", 2, "checkPlayableArea delay: " + paramInt);
  }
  
  public static boolean b(ArticleInfo paramArticleInfo)
  {
    if ((!c(paramArticleInfo)) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo == null)) {
      return false;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.b.intValue())
    {
    case 10: 
    case 11: 
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean b(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mFeedType == 11) && (paramBaseArticleInfo.mTopicRecommendFeedsInfo != null) && (paramBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null);
  }
  
  public static int c(ArticleInfo paramArticleInfo)
  {
    return a(paramArticleInfo, 0);
  }
  
  private void c(List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0) && ((paramList.get(0) instanceof Long)))
    {
      int i1 = 0;
      if (i1 < paramList.size())
      {
        BaseArticleInfo localBaseArticleInfo = a(this.jdField_c_of_type_Int, ((Long)paramList.get(i1)).longValue());
        int i2;
        if ((localBaseArticleInfo != null) && (localBaseArticleInfo.mFeedType == 15))
        {
          ArkAppMessage localArkAppMessage = ReadInJoyArkUtil.a(localBaseArticleInfo.mArkAppFeedsInfo);
          boolean bool = ReadInJoyArkUtil.a();
          if ((!bool) || (!ReadInJoyArkUtil.a(localArkAppMessage)))
          {
            paramList.remove(i1);
            ReadInJoyArkUtil.a(this.jdField_c_of_type_Int, localBaseArticleInfo.mRecommendSeq);
            i2 = i1;
            if (bool)
            {
              ReadInJoyArkUtil.a(localArkAppMessage, 0);
              i2 = i1;
            }
            label139:
            i1 = i2;
          }
        }
        for (;;)
        {
          break;
          i2 = i1 + 1;
          break label139;
          i1 += 1;
        }
      }
    }
  }
  
  private boolean c()
  {
    if (!ReadInJoyHelper.a(this.jdField_d_of_type_Int)) {}
    String str;
    do
    {
      do
      {
        do
        {
          return false;
        } while (!NetworkUtil.g(this.jdField_a_of_type_AndroidAppActivity));
        str = ReadInJoyUtils.b();
      } while (ReadInJoyUtils.jdField_d_of_type_JavaLangString.equals(str));
      if (ReadInJoyUtils.jdField_b_of_type_JavaLangString.equals(str)) {
        return true;
      }
    } while (!ReadInJoyUtils.jdField_c_of_type_JavaLangString.equals(str));
    return VideoAutoPlayController.a(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public static boolean c(ArticleInfo paramArticleInfo)
  {
    boolean bool = true;
    if (paramArticleInfo == null) {
      return false;
    }
    if ((paramArticleInfo.mFeedType == 1) && (paramArticleInfo.mSocialFeedInfo != null)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean c(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.isEmpty());
  }
  
  public static boolean d(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null)) {
      return false;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean e(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while (paramArticleInfo.mFeedType != 10) {
      return false;
    }
    return true;
  }
  
  public static boolean f(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return false;
    }
    switch (paramArticleInfo.mFeedType)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean g(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null)) {
      return false;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.b.intValue())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean h(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while ((paramArticleInfo.mFeedType != 18) && (paramArticleInfo.mFeedType != 19)) {
      return false;
    }
    return true;
  }
  
  public static boolean i(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null)) {
      return false;
    }
    switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.b.intValue())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean j(ArticleInfo paramArticleInfo)
  {
    return (i(paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int == 1);
  }
  
  public static boolean k(ArticleInfo paramArticleInfo)
  {
    return (g(paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int == 1);
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = new VideoPreDownloadMgr(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
    VideoPreDownloadMgr localVideoPreDownloadMgr = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
    if (this.jdField_c_of_type_Int == 56) {}
    for (int i1 = VideoPreloadReportData.jdField_b_of_type_Int;; i1 = VideoPreloadReportData.jdField_a_of_type_Int)
    {
      localVideoPreDownloadMgr.a = new VideoPreloadReportData(i1, VideoPreloadReportData.jdField_d_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(new mgl(this));
      return;
    }
  }
  
  public static boolean l(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while ((paramArticleInfo.mFeedType != 16) && (paramArticleInfo.mFeedType != 17)) {
      return false;
    }
    return true;
  }
  
  private void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "prefetch data");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$PrefetchListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$PrefetchListener.a();
    }
  }
  
  public static boolean m(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null);
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(this.jdField_b_of_type_ComTencentWidgetAbsListView$OnScrollListener);
  }
  
  public static boolean n(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() == 0);
  }
  
  private void o()
  {
    if (!PublicAccountImageCollectionPreloadManager.a().a()) {}
    for (;;)
    {
      return;
      PublicAccountImageCollectionPreloadManager.a().c();
      int i1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition();
      int i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getLastVisiblePosition();
      a();
      while (i1 <= i2)
      {
        Object localObject = getItem(i1);
        if (localObject != null)
        {
          localObject = (BaseArticleInfo)localObject;
          if (localObject != null)
          {
            int i3 = a(i1);
            if ((i3 == 8) || (i3 == 7)) {
              PublicAccountImageCollectionPreloadManager.a().a(String.valueOf(((BaseArticleInfo)localObject).innerUniqueID));
            }
          }
        }
        i1 += 1;
      }
    }
  }
  
  public static boolean o(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.size() == 0);
  }
  
  private void p()
  {
    int i1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition();
    int i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getLastVisiblePosition();
    a();
    while (i1 <= i2)
    {
      Object localObject1 = getItem(i1);
      if (localObject1 != null)
      {
        localObject1 = (BaseArticleInfo)localObject1;
        Object localObject2;
        if ((localObject1 != null) && (((BaseArticleInfo)localObject1).isSocialFeed()))
        {
          long l1 = ((BaseArticleInfo)localObject1).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
          long l2 = ((BaseArticleInfo)localObject1).mSocialFeedInfo.jdField_a_of_type_Long;
          ReadInJoyWebDataManager.a().a((BaseArticleInfo)localObject1, ((BaseArticleInfo)localObject1).mRecommendSeq, l1, l2);
          if ((a((BaseArticleInfo)localObject1)) && (((BaseArticleInfo)localObject1).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo != null) && (((BaseArticleInfo)localObject1).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null))
          {
            localObject2 = ((BaseArticleInfo)localObject1).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              TopicRecommendFeedsInfo.TopicRecommendInfo localTopicRecommendInfo = (TopicRecommendFeedsInfo.TopicRecommendInfo)((Iterator)localObject2).next();
              ReadInJoyWebDataManager.a().a(localTopicRecommendInfo.jdField_a_of_type_Int);
              if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyBaseAdapter", 2, "isSocialTopic: true and invoke webpreload data ,topicId = " + localTopicRecommendInfo.jdField_a_of_type_Int);
              }
            }
          }
        }
        if ((localObject1 != null) && (((BaseArticleInfo)localObject1).mFeedType == 11) && (((BaseArticleInfo)localObject1).mTopicRecommendFeedsInfo != null) && (((BaseArticleInfo)localObject1).mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null) && (((BaseArticleInfo)localObject1).mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          localObject1 = ((BaseArticleInfo)localObject1).mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (TopicRecommendFeedsInfo.TopicRecommendInfo)((Iterator)localObject1).next();
            ReadInJoyWebDataManager.a().a(((TopicRecommendFeedsInfo.TopicRecommendInfo)localObject2).jdField_a_of_type_Int);
            if (QLog.isColorLevel()) {
              QLog.d("ReadInJoyBaseAdapter", 2, "isSingleTopic: true and invoke webpreload data ,topicId = " + ((TopicRecommendFeedsInfo.TopicRecommendInfo)localObject2).jdField_a_of_type_Int);
            }
          }
        }
      }
      i1 += 1;
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public abstract int a(int paramInt);
  
  public abstract Activity a();
  
  public Bitmap a(long paramLong)
  {
    return null;
  }
  
  public abstract BaseArticleInfo a(int paramInt);
  
  public abstract BaseArticleInfo a(int paramInt, long paramLong);
  
  public ReadInJoyBaseAdapter.OnGalleryImageClickListener a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$OnGalleryImageClickListener;
  }
  
  public ReadInJoyBaseAdapter.OnHorizontalSubArticleClick a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$OnHorizontalSubArticleClick;
  }
  
  public ReadInJoyBaseAdapter.OnLastReadRefreshListener a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$OnLastReadRefreshListener;
  }
  
  public ReadInJoyBaseAdapter.OnSubRegionClickListener a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$OnSubRegionClickListener;
  }
  
  public FaceDecoder a()
  {
    return null;
  }
  
  public KandianPopupWindow a()
  {
    return this.jdField_a_of_type_ComTencentWidgetKandianPopupWindow;
  }
  
  public KandianPopupWindowForAd a()
  {
    return this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd;
  }
  
  public ListView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView;
  }
  
  public List a()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "clearData " + this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    }
    this.jdField_n_of_type_Boolean = true;
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_a_of_type_ComTencentWidgetKandianPopupWindow = null;
    this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd = null;
    if (this.jdField_c_of_type_Int == 56) {
      VideoBehaviorsReporter.a().a();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoShareHelper != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoShareHelper.a();
    }
    ReadInJoyArkUtil.b();
  }
  
  public void a(int paramInt)
  {
    a(paramInt, true);
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager == null) {}
    long l1;
    int i1;
    label132:
    VideoPlayManager.VideoPlayParam localVideoPlayParam;
    do
    {
      do
      {
        return;
        switch (paramInt)
        {
        default: 
          return;
        case 0: 
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "onActivityResult for OPEN_FULLPLAY");
          }
          this.q = true;
          this.jdField_h_of_type_Boolean = false;
          l1 = -1L;
          i1 = -1;
          if (paramIntent != null)
          {
            l1 = paramIntent.getLongExtra("VIDEO_PLAY_POSITION", -1L);
            i1 = paramIntent.getIntExtra("VIDEO_PLAY_STATUS", -1);
          }
          if ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.c()) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b())) {
            break label132;
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.readinjoy.video", 2, "onActivityResult video is pause  && isPausedByMannul, just return");
      return;
      localVideoPlayParam = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
      if (localVideoPlayParam != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video", 2, "onActivityResult getCurrentPlayVideoParam = null, just return");
    return;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramIntent != null)
    {
      localObject1 = localObject2;
      if (paramIntent.getExtras() != null) {
        localObject1 = paramIntent.getExtras().getString("VIDEO_ARTICLE_ID");
      }
    }
    if (!TextUtils.equals(localVideoPlayParam.jdField_i_of_type_JavaLangString, (CharSequence)localObject1))
    {
      paramIntent = a((String)localObject1);
      if (paramIntent == null)
      {
        l1 = localVideoPlayParam.jdField_b_of_type_Long;
        paramInt = 0;
      }
    }
    for (;;)
    {
      label230:
      boolean bool;
      if ((i1 == 3) || (i1 == 0) || (i1 == 4))
      {
        bool = true;
        label247:
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "onActivityResult shouldContinuePlay = " + bool + ", playState=" + VideoPlayUtils.a(i1) + ", startPosition=" + l1 + "，curPlayParam=" + localVideoPlayParam);
        }
        if (!bool) {
          break label523;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "onActivityResult continue play");
        }
        if (paramInt == 0) {
          break label435;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "onActivityResult resume playResumeVideo:" + (String)localObject1);
        }
        a(paramIntent);
      }
      for (;;)
      {
        VideoVolumeControl.a().a(false, "readinoy video continuePlay", 1);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.readinjoy.video", 2, "volumeControl set mute shouldContinuePlay");
        return;
        if (paramIntent.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null) {
          paramIntent.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Long = l1;
        }
        paramInt = 1;
        break label230;
        bool = false;
        break label247;
        label435:
        if ((l1 >= 0L) && (localVideoPlayParam != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "onActivityResult resume with position:" + l1);
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a((int)l1, localVideoPlayParam);
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "onActivityResult resume");
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.f(true);
        }
      }
      label523:
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "onActivityResult stop");
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder == null) {
        break;
      }
      long l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b(4);
      paramIntent = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam;
      if (l1 > 0L) {
        l2 = l1;
      }
      paramIntent.jdField_b_of_type_Long = l2;
      if (l1 > 0L) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_d_of_type_Int = -1;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder = null;
      return;
      this.q = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "onActivityResult for REFRESH_EVENT_CHECK_PLAYAREA");
      }
      b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, 50);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.readinjoy.video", 2, "do nothing!");
      return;
      paramInt = 0;
      paramIntent = null;
    }
  }
  
  public abstract void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, ArrayList paramArrayList);
  
  public abstract void a(int paramInt, ArrayList paramArrayList1, ArrayList paramArrayList2);
  
  public void a(int paramInt, ArrayList paramArrayList1, ArrayList paramArrayList2, Object paramObject)
  {
    this.jdField_b_of_type_JavaUtilList.removeAll(paramArrayList1);
    this.p = true;
    notifyDataSetChanged();
    BaseArticleInfo localBaseArticleInfo = null;
    if (paramArrayList1.size() > 0) {
      localBaseArticleInfo = (BaseArticleInfo)paramArrayList1.get(0);
    }
    int i1 = 2131428470;
    if (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)) {
      i1 = 2131428471;
    }
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, -1, this.jdField_a_of_type_AndroidAppActivity.getString(i1), 0).b(((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getTitleBarHeight());
    }
    for (;;)
    {
      a(paramInt, paramArrayList1, paramArrayList2);
      if (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo))
      {
        long l2 = 0L;
        long l1 = l2;
        if (paramObject != null)
        {
          l1 = l2;
          if ((paramObject instanceof DislikeInfo)) {
            l1 = ((DislikeInfo)paramObject).jdField_a_of_type_Long;
          }
        }
        ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localBaseArticleInfo, l1);
      }
      try
      {
        paramArrayList1 = new JSONObject();
        paramArrayList1.put("time", System.currentTimeMillis() / 1000L);
        paramArrayList1.put("channel_id", this.jdField_c_of_type_Int);
        if (paramArrayList2 != null)
        {
          paramInt = paramArrayList2.size();
          label210:
          paramArrayList1.put("tag_num", paramInt);
          if (!(this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) {
            break label366;
          }
          paramArrayList1.put("folder_status", ReadInJoyUtils.jdField_d_of_type_Int);
          paramArrayList1.put("kandian_mode", ReadInJoyUtils.e());
          paramArrayList1.put("feeds_type", "" + ReadInJoyUtils.a(localBaseArticleInfo));
          paramArrayList1 = paramArrayList1.toString();
          PublicAccountReportUtils.a(null, "", "0X8007059", "0X8007059", 0, 0, "", "", ReadInJoyUtils.a(paramArrayList2), paramArrayList1, false);
        }
        label366:
        while (!(this.jdField_a_of_type_AndroidAppActivity instanceof PluginBaseActivity))
        {
          return;
          if (!(this.jdField_a_of_type_AndroidAppActivity instanceof PluginBaseActivity)) {
            break;
          }
          QQToast.a(this.jdField_a_of_type_AndroidAppActivity, -1, this.jdField_a_of_type_AndroidAppActivity.getString(i1), 0).b(((PluginBaseActivity)this.jdField_a_of_type_AndroidAppActivity).g());
          break;
          paramInt = 0;
          break label210;
        }
        paramArrayList1.put("folder_status", 1);
        ReportController.b(null, "CliOper", "", "", "0X8007060", "0X8007060", 0, 0, "", "", "", paramArrayList1.toString());
        return;
      }
      catch (JSONException paramArrayList1)
      {
        paramArrayList1.printStackTrace();
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramInt, paramBoolean);
    }
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo)
  {
    this.jdField_b_of_type_JavaUtilList.remove(paramBaseArticleInfo);
    notifyDataSetChanged();
    this.p = true;
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, IReadInJoyModel paramIReadInJoyModel)
  {
    a(paramBaseArticleInfo, paramIReadInJoyModel, 0L, 0);
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, IReadInJoyModel paramIReadInJoyModel, long paramLong, int paramInt)
  {
    if ((paramBaseArticleInfo == null) || (this.jdField_b_of_type_JavaUtilSet == null) || ((ReadInJoyUtils.e(paramBaseArticleInfo)) && (!ReadInJoyUtils.f(paramBaseArticleInfo)))) {}
    for (;;)
    {
      return;
      if ((paramBaseArticleInfo.hasOnlyTwoVideoFeeds()) && (paramBaseArticleInfo.mSubArtilceList.size() > 0))
      {
        Iterator localIterator = paramBaseArticleInfo.mSubArtilceList.iterator();
        while (localIterator.hasNext()) {
          a((ArticleInfo)localIterator.next(), new ReadInJoyModelImpl(this.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)paramBaseArticleInfo, 46, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, paramInt, this.jdField_b_of_type_Boolean, getCount(), null, this), 0L, 0);
        }
      }
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramBaseArticleInfo.mArticleID))) {}
      for (int i1 = 1; i1 != 0; i1 = 0)
      {
        ThreadManager.post(new mgp(this, paramBaseArticleInfo, paramIReadInJoyModel, paramInt, paramLong), 5, null, true);
        return;
      }
    }
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetKandianPopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetKandianPopupWindow.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetKandianPopupWindow.dismiss();
    }
    if ((this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd != null) && (this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd.dismiss();
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new mfy(this, paramVideoPlayParam), 1000L);
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, BaseArticleInfo paramBaseArticleInfo)
  {
    a(paramVideoPlayParam, paramBaseArticleInfo, false);
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "open full play activity, articleID : " + paramBaseArticleInfo.mArticleID + ", playPosition : " + paramVideoPlayParam.jdField_b_of_type_Long + ",vid : " + paramVideoPlayParam.jdField_a_of_type_JavaLangString + ", showComment : " + paramBoolean);
    }
    Bundle localBundle = a(paramVideoPlayParam, paramBaseArticleInfo);
    int i1;
    Object localObject;
    label240:
    label249:
    Intent localIntent;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b() == paramBaseArticleInfo.mArticleID)
      {
        i1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
        localBundle.putInt("VIDEO_PLAY_STATUS", i1);
      }
    }
    else
    {
      if (paramVideoPlayParam.jdField_e_of_type_Int == 2)
      {
        localObject = ThirdVideoManager.a(paramVideoPlayParam.jdField_a_of_type_JavaLangString);
        if (localObject != null)
        {
          localBundle.putString("VIDEO_THIRD_VID_URL", ((VidUrl)localObject).jdField_b_of_type_JavaLangString);
          localBundle.putLong("VIDEO_THIRD_VID_URL_TIME", ((VidUrl)localObject).jdField_a_of_type_Long);
        }
      }
      localBundle.putBoolean("VIDEO_LIST_SCROLL_EXIT", true);
      localBundle.putInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 3);
      if (this.jdField_c_of_type_Int != 0) {
        break label564;
      }
      if (!ReadInJoyUtils.d(paramBaseArticleInfo)) {
        break label552;
      }
      localBundle.putInt("VIDEO_FROM_TYPE", 4);
      localBundle.putLong("VIDEO_FROM_POLYMERIC_TOPIC_ID", paramBaseArticleInfo.mPolymericInfo.jdField_f_of_type_Long);
      localBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long);
      localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 3);
      localBundle.putInt("REPORT_VIDEO_FEEDS_CHANNEL_ID", this.jdField_c_of_type_Int);
      localObject = a();
      localIntent = new Intent((Context)localObject, VideoFeedsPlayActivity.class);
      if (BaseApplicationImpl.sProcessId != 1)
      {
        localBundle.putBoolean("param_needSmooth", VideoVolumeControl.a().c());
        VideoVolumeControl.a().f(true);
        localBundle.putBoolean("param_needAlertInXg", VideoAutoPlayController.e());
      }
      localIntent.putExtras(localBundle);
      if (paramVideoPlayParam.jdField_e_of_type_Int == 6) {
        localIntent.putExtra("VIDEO_ARTICLE_INFO_FOR_BIU", (ArticleInfo)paramBaseArticleInfo);
      }
      i1 = 9091;
      if (1 != paramBaseArticleInfo.mVideoType) {
        break label751;
      }
      i1 = 1;
    }
    for (;;)
    {
      localIntent.putExtra("VIDEO_FEEDS_INNER_SESSION_ID", paramVideoPlayParam.jdField_k_of_type_JavaLangString);
      localIntent.putExtra("VIDEO_CHANNEL_SESSION_ID", paramVideoPlayParam.l);
      localIntent.putExtra("item_x", paramVideoPlayParam.jdField_h_of_type_Int);
      localIntent.putExtra("item_y", paramVideoPlayParam.jdField_i_of_type_Int);
      localIntent.putExtra("item_width", paramVideoPlayParam.jdField_j_of_type_Int);
      localIntent.putExtra("item_height", paramVideoPlayParam.jdField_k_of_type_Int);
      localIntent.putExtra("VIDEO_SHOW_COMMENT", paramBoolean);
      ((Activity)localObject).startActivityForResult(localIntent, i1);
      ((Activity)localObject).overridePendingTransition(2131034194, 2131034195);
      VideoFeedsStartStatistic.a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.e();
        this.jdField_k_of_type_Boolean = true;
      }
      if (ReadInJoyHelper.g()) {
        PublicAccountReportUtils.a(null, "", "0X8008B68", "0X8008B68", 0, 0, "", "", "", VideoReporter.a(null, null, paramBaseArticleInfo.mVideoVid, paramBaseArticleInfo.innerUniqueID, a(), null), false);
      }
      return;
      i1 = 1;
      break;
      label552:
      localBundle.putInt("VIDEO_FROM_TYPE", 3);
      break label240;
      label564:
      if (this.jdField_c_of_type_Int == 56)
      {
        if (ReadInJoyUtils.d(paramBaseArticleInfo))
        {
          localBundle.putInt("VIDEO_FROM_TYPE", 5);
          localBundle.putLong("VIDEO_FROM_POLYMERIC_TOPIC_ID", paramBaseArticleInfo.mPolymericInfo.jdField_f_of_type_Long);
          localBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long);
        }
        for (;;)
        {
          localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 4);
          break;
          localBundle.putInt("VIDEO_FROM_TYPE", 2);
        }
      }
      if (this.jdField_c_of_type_Int == 70)
      {
        localBundle.putInt("VIDEO_FROM_TYPE", 8);
        localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 7);
        break label249;
      }
      if (this.jdField_c_of_type_Int == 40677)
      {
        localBundle.putInt("VIDEO_FROM_TYPE", 9);
        localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 8);
        break label249;
      }
      if (this.jdField_d_of_type_Int == 3) {
        localBundle.putInt("VIDEO_FROM_TYPE", 6);
      }
      for (;;)
      {
        localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 5);
        break;
        localBundle.putInt("VIDEO_FROM_TYPE", 7);
      }
      label751:
      if (0L == paramBaseArticleInfo.mChannelID) {
        i1 = 1;
      }
    }
  }
  
  public void a(VideoPlayManager paramVideoPlayManager, VideoAutoPlayController paramVideoAutoPlayController)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager = paramVideoPlayManager;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController = paramVideoAutoPlayController;
    if (VideoAutoPlayController.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController.b(true);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseAdapter", 2, "setVideoPlayManager " + this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler + " mVideoPlayManager " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager + " mIsCleanData " + this.jdField_n_of_type_Boolean);
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null) && (!this.jdField_n_of_type_Boolean))
      {
        l();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController);
        if (ReadInJoyHelper.a(this.jdField_d_of_type_Int)) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(0);
        }
      }
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController.b(false);
    }
  }
  
  public void a(VideoRecommendManager paramVideoRecommendManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoRecommendManager = paramVideoRecommendManager;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoRecommendManager.a(this);
  }
  
  public void a(ReadInJoyBaseAdapter.OnGalleryImageClickListener paramOnGalleryImageClickListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$OnGalleryImageClickListener = paramOnGalleryImageClickListener;
  }
  
  public void a(ReadInJoyBaseAdapter.OnHorizontalSubArticleClick paramOnHorizontalSubArticleClick)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$OnHorizontalSubArticleClick = paramOnHorizontalSubArticleClick;
  }
  
  public void a(ReadInJoyBaseAdapter.OnLastReadRefreshListener paramOnLastReadRefreshListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$OnLastReadRefreshListener = paramOnLastReadRefreshListener;
  }
  
  public void a(ReadInJoyBaseAdapter.OnSubRegionClickListener paramOnSubRegionClickListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$OnSubRegionClickListener = paramOnSubRegionClickListener;
  }
  
  public void a(ReadInJoyBaseAdapter.PrefetchListener paramPrefetchListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$PrefetchListener = paramPrefetchListener;
  }
  
  public void a(ReadInJoyBaseAdapter.VideoFeedsViewHolder paramVideoFeedsViewHolder)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b(2);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_d_of_type_Int >= 0))
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_d_of_type_Int);
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageBitmap((Bitmap)localObject);
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder = paramVideoFeedsViewHolder;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam);
    Object localObject = paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    if ((localObject != null) && (((BaseArticleInfo)localObject).mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject)))
    {
      jdField_h_of_type_Int = (int)(paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Long / 1000L);
      if (paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Long != 0L) {
        break label189;
      }
    }
    label189:
    for (int i1 = 1;; i1 = 0)
    {
      jdField_i_of_type_Int = i1;
      jdField_f_of_type_Int = 1;
      jdField_g_of_type_Int = 1;
      NativeAdUtils.a(null, this.jdField_a_of_type_AndroidAppActivity, NativeAdUtils.jdField_f_of_type_Int, NativeAdUtils.jdField_j_of_type_Int, (AdvertisementInfo)localObject, null, 0, NativeAdUtils.a(jdField_h_of_type_Int, 0, jdField_i_of_type_Int, 0, 1, 1, ((BaseArticleInfo)localObject).mVideoDuration, NativeAdUtils.jdField_m_of_type_Int));
      return;
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((this.jdField_c_of_type_Int == 0) || (this.jdField_c_of_type_Int == 40677)) {}
    do
    {
      do
      {
        return;
      } while ((!NetworkUtil.g(this.jdField_a_of_type_AndroidAppActivity)) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager == null) || (paramAbsListView == null));
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, paramInt);
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video", 2, "force checkPlayableArea delay: " + paramInt);
  }
  
  public void a(List paramList)
  {
    StringBuilder localStringBuilder;
    if ((paramList != null) && (this.jdField_b_of_type_JavaUtilList.getClass().isInstance(paramList)) && (paramList.size() > 0))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder("setData ");
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = localIterator.next();
          localStringBuilder.append("recommendSeq = " + localObject + ",\n ");
        }
        QLog.d("ReadInJoyBaseAdapter", 1, localStringBuilder.toString());
      }
      c(paramList);
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList.addAll(paramList);
      this.p = true;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("setData:");
      if (paramList != null) {
        break label207;
      }
    }
    label207:
    for (int i1 = 0;; i1 = paramList.size())
    {
      QLog.d("ReadInJoyBaseAdapter", 2, i1);
      this.jdField_b_of_type_Long = System.nanoTime();
      VideoBehaviorsReporter.a().a(this, this.jdField_b_of_type_JavaUtilList);
      return;
    }
  }
  
  public void a(Set paramSet, Map paramMap)
  {
    this.jdField_b_of_type_JavaUtilSet = paramSet;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, BaseArticleInfo paramBaseArticleInfo)
  {
    if (!paramBoolean) {}
    while (this.jdField_c_of_type_Int != 56) {
      return;
    }
    long l2 = 0L;
    int i1 = 0;
    for (;;)
    {
      long l1 = l2;
      if (i1 < this.jdField_b_of_type_JavaUtilList.size())
      {
        if (paramBaseArticleInfo.mRecommendSeq != ((BaseArticleInfo)this.jdField_b_of_type_JavaUtilList.get(i1)).mRecommendSeq) {
          break label117;
        }
        i1 += 1;
        l1 = l2;
        if (i1 <= this.jdField_b_of_type_JavaUtilList.size() - 1) {
          l1 = ((BaseArticleInfo)this.jdField_b_of_type_JavaUtilList.get(i1)).mAlgorithmID;
        }
      }
      ReadInJoyLogicEngine.a().a(56, 3, paramBaseArticleInfo.mArticleID, l1);
      return;
      label117:
      i1 += 1;
    }
  }
  
  public abstract boolean a();
  
  public abstract boolean a(int paramInt, long paramLong);
  
  public BaseArticleInfo b(int paramInt)
  {
    if ((this.jdField_b_of_type_JavaUtilList.size() > 0) && (paramInt < this.jdField_b_of_type_JavaUtilList.size())) {
      return (BaseArticleInfo)this.jdField_b_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public String b(long paramLong)
  {
    return null;
  }
  
  public void b(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  protected void b(VideoPlayManager.VideoPlayParam paramVideoPlayParam, BaseArticleInfo paramBaseArticleInfo)
  {
    int i3 = a();
    String str2 = ReadInJoyUtils.a(paramBaseArticleInfo);
    int i1;
    int i2;
    label40:
    String str1;
    if (((ArticleInfo)paramBaseArticleInfo).hasChannelInfo())
    {
      i1 = paramBaseArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleFriendLikeText)) {
        break label503;
      }
      i2 = 0;
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), ReadInJoyUtils.b(paramBaseArticleInfo.mAlgorithmID, ReadInJoyUtils.a(paramBaseArticleInfo), this.jdField_c_of_type_Int, i1), false);
      PublicAccountReportUtils.a("0X80066FA", "", "", Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), ReadInJoyUtils.b(paramBaseArticleInfo.mAlgorithmID, ReadInJoyUtils.a(paramBaseArticleInfo), this.jdField_c_of_type_Int, i1));
      str1 = ReadInJoyUtils.a(paramBaseArticleInfo.mAlgorithmID, ReadInJoyUtils.a(paramBaseArticleInfo), i3, i1, i2, NetworkUtil.h(this.jdField_a_of_type_AndroidAppActivity), str2, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, ReadInJoyUtils.c(paramBaseArticleInfo), 409409, (ArticleInfo)paramBaseArticleInfo);
    }
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(str1);
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoRecommendManager != null)
        {
          int i4 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoRecommendManager.a();
          localJSONObject.put("video_inserted", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoRecommendManager.a(paramBaseArticleInfo.mArticleID));
          localJSONObject.put("video_strategyid", i4);
        }
        localJSONObject.put("from", VideoReporter.jdField_a_of_type_Int);
        localJSONObject.put("jump_to_channel", 409409);
        localJSONObject.put("ads_jump", paramBaseArticleInfo.mVideoAdsJumpType);
        localJSONObject.put("ads_source", paramBaseArticleInfo.mVideoAdsSource);
        if (i3 != 0) {
          continue;
        }
        paramVideoPlayParam.jdField_k_of_type_JavaLangString = VideoReporter.b();
        localJSONObject.put("session_id", paramVideoPlayParam.jdField_k_of_type_JavaLangString);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a() == paramVideoPlayParam))
        {
          long l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
          if (l1 != 0L) {
            localJSONObject.put("video_play_duration", l1);
          }
        }
        paramVideoPlayParam = localJSONObject.toString();
      }
      catch (JSONException paramVideoPlayParam)
      {
        JSONObject localJSONObject;
        label503:
        paramVideoPlayParam.printStackTrace();
        paramVideoPlayParam = str1;
        continue;
        PublicAccountReportUtils.a(null, "CliOper", "", paramBaseArticleInfo.mSubscribeID, "0X8007625", "0X8007625", 0, 0, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), paramVideoPlayParam, false);
        PublicAccountReportUtils.a("0X8007625", paramBaseArticleInfo.mSubscribeID, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), ReadInJoyUtils.a(paramBaseArticleInfo.mAlgorithmID, ReadInJoyUtils.a(paramBaseArticleInfo), i3, i1, i2, NetworkUtil.h(this.jdField_a_of_type_AndroidAppActivity), str2, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, ReadInJoyUtils.c(paramBaseArticleInfo), 409409, (ArticleInfo)paramBaseArticleInfo));
      }
      if (this.jdField_c_of_type_Int != 40677) {
        continue;
      }
      PublicAccountReportUtils.a(null, "CliOper", "", paramBaseArticleInfo.mSubscribeID, "0X8009293", "0X8009293", 0, 0, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), paramVideoPlayParam, false);
      PublicAccountReportUtils.a("0X8009293", paramBaseArticleInfo.mSubscribeID, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), ReadInJoyUtils.a(paramBaseArticleInfo.mAlgorithmID, ReadInJoyUtils.a(paramBaseArticleInfo), i3, i1, i2, NetworkUtil.h(this.jdField_a_of_type_AndroidAppActivity), str2, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, ReadInJoyUtils.c(paramBaseArticleInfo), 409409, (ArticleInfo)paramBaseArticleInfo));
      return;
      i1 = 0;
      break;
      i2 = 1;
      break label40;
      if ((i3 == 56) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a())))
      {
        paramVideoPlayParam.l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
        localJSONObject.put("video_session_id", paramVideoPlayParam.l);
      }
    }
  }
  
  public void b(List paramList)
  {
    if ((paramList != null) && (this.jdField_b_of_type_JavaUtilList.getClass().isInstance(paramList)) && (paramList.size() > 0)) {
      this.jdField_b_of_type_JavaUtilList.removeAll(paramList);
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public abstract boolean b(int paramInt, long paramLong);
  
  public void c()
  {
    if ((this.jdField_k_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.b();
      int i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition();
      int i1 = i2;
      if (i2 >= getCount()) {
        i1 = 0;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(i1);
      this.jdField_k_of_type_Boolean = false;
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = null;
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(new mgo(this));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyBaseAdapter", 2, "mVideoPlayManager == null");
  }
  
  public void f()
  {
    if (!PreloadManager.a().a()) {}
    for (;;)
    {
      return;
      PreloadManager.a().e();
      int i1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition();
      int i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getLastVisiblePosition();
      int i3 = a();
      while (i1 <= i2)
      {
        Object localObject = getItem(i1);
        if ((localObject != null) && ((localObject instanceof BaseArticleInfo)))
        {
          localObject = (BaseArticleInfo)localObject;
          if ((!ReadInJoyUtils.a(((BaseArticleInfo)localObject).mArticleContentUrl, ((BaseArticleInfo)localObject).mChannelID, ((BaseArticleInfo)localObject).mFeedType, (ArticleInfo)localObject)) && (!ReadInJoyUtils.a((BaseArticleInfo)localObject)) && (!a(i3, ((BaseArticleInfo)localObject).mArticleID)))
          {
            localObject = ((BaseArticleInfo)localObject).mArticleContentUrl;
            if (PubAccountPreloadPlugin.a((String)localObject)) {
              PreloadManager.a().a((String)localObject);
            }
          }
        }
        i1 += 1;
      }
    }
  }
  
  public void g()
  {
    if ((!ReadInJoyHelper.q(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (!ReadInJoyHelper.r(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      return;
    }
    int i1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition();
    int i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getLastVisiblePosition();
    ArrayList localArrayList = new ArrayList();
    while (i1 <= i2)
    {
      Object localObject = getItem(i1);
      if (localObject != null)
      {
        localObject = (BaseArticleInfo)localObject;
        if (!ReadInJoyUtils.a((BaseArticleInfo)localObject)) {
          localArrayList.add((ArticleInfo)localObject);
        }
      }
      i1 += 1;
    }
    ReadInJoyLogicEngine.a().a().a(localArrayList);
  }
  
  public int getCount()
  {
    return this.jdField_b_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_b_of_type_JavaUtilList.size())) {
      return this.jdField_b_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return a(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    long l1 = System.currentTimeMillis();
    int i1 = getItemViewType(paramInt);
    Object localObject2;
    Object localObject3;
    Object localObject1;
    if (ProteusSupportUtil.a(i1))
    {
      localObject2 = b(paramInt);
      localObject3 = new ReadInJoyModelImpl(this.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)localObject2, i1, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, paramInt, this.jdField_b_of_type_Boolean, getCount(), null, this);
      if ((paramView != null) && ((paramView instanceof ProteusItemView)))
      {
        ProteusSupportUtil.a((ProteusItemView)paramView, i1, (BaseArticleInfo)localObject2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, a(), this, (IReadInJoyModel)localObject3);
        localObject1 = (ProteusItemView)paramView;
      }
      while ((localObject1 != null) && (((ProteusItemView)localObject1).a() != null))
      {
        paramView = a();
        ((ProteusItemView)localObject1).a().setTag(2131362291, paramView);
        a((BaseArticleInfo)localObject2, (IReadInJoyModel)localObject3, System.currentTimeMillis(), paramInt);
        return a((View)localObject1, paramInt);
        localObject1 = ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, i1, (BaseArticleInfo)localObject2);
        ProteusSupportUtil.a((ProteusItemView)localObject1, i1, (BaseArticleInfo)localObject2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, a(), this, (IReadInJoyModel)localObject3);
      }
    }
    if (i1 == 38)
    {
      localObject1 = b(paramInt);
      paramViewGroup = null;
      if (paramInt < getCount() - 1) {
        paramViewGroup = (ArticleInfo)b(paramInt + 1);
      }
      a((BaseArticleInfo)localObject1, paramInt);
      paramViewGroup = new ReadInJoyModelImpl(this.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)localObject1, i1, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, paramInt, this.jdField_b_of_type_Boolean, getCount(), paramViewGroup, this);
      paramView = a(paramInt, paramView);
      a((BaseArticleInfo)localObject1, paramViewGroup);
    }
    for (;;)
    {
      return super.a(paramView, paramInt);
      if (!CellFactory.a(i1))
      {
        localObject1 = null;
        if ((paramView == null) || (!(paramView.getTag() instanceof ReadInJoyBaseAdapter.ViewHolder))) {}
        label361:
        BaseArticleInfo localBaseArticleInfo;
        switch (i1)
        {
        default: 
          paramViewGroup = paramView;
          paramView = (View)localObject1;
          paramView.jdField_f_of_type_AndroidViewView = paramViewGroup;
          paramView.jdField_a_of_type_Int = paramInt;
          paramViewGroup.setTag(paramView);
          paramViewGroup.setTag(2131362291, a());
          localObject2 = new ReadInJoyPresenterImpl(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$OnLastReadRefreshListener, a(), this, this.jdField_a_of_type_ComTencentWidgetKandianPopupWindow, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
          paramViewGroup.setTag(2131362077, localObject2);
          localObject1 = new ReadInJoyView(paramViewGroup);
          paramViewGroup.setTag(2131362078, localObject1);
          localObject3 = paramView;
          localBaseArticleInfo = b(paramInt);
          switch (i1)
          {
          default: 
            paramView = null;
            if (paramInt < getCount() - 1) {
              paramView = (ArticleInfo)b(paramInt + 1);
            }
            a(localBaseArticleInfo, paramInt);
            paramView = new ReadInJoyModelImpl(this.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)localBaseArticleInfo, i1, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, paramInt, this.jdField_b_of_type_Boolean, getCount(), paramView, this);
            paramViewGroup.setTag(2131362079, paramView);
            ((IReadInJoyPresenter)localObject2).a((ReadInJoyView)localObject1, paramView, i1);
            if (QLog.isColorLevel()) {
              QLog.d("ReadInJoyBaseAdapter", 2, "getView cost:" + (System.currentTimeMillis() - l1));
            }
            a(localBaseArticleInfo, paramView, System.currentTimeMillis(), paramInt);
            paramView = paramViewGroup;
            if (!(a() instanceof ReadInJoyChannelActivity)) {
              continue;
            }
            if (((!this.jdField_e_of_type_Boolean) || (this.jdField_f_of_type_Boolean)) && ((i1 == 4) || (i1 == 46)) && (paramInt > 0) && (paramInt <= 2))
            {
              if ((paramInt != 1) || (!this.jdField_g_of_type_Boolean)) {
                break label1754;
              }
              this.jdField_g_of_type_Boolean = false;
              paramViewGroup.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
            }
            break;
          }
        case 4: 
        case 46: 
        case 70: 
          for (;;)
          {
            label448:
            label492:
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.videoanimation", 2, "adapter animation start at item position" + paramInt);
            }
            paramView = paramViewGroup;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Q.readinjoy.videoanimation", 2, " judge adapter animation show or not：");
            paramView = paramViewGroup;
            break;
            paramView = new ReadInJoyBaseAdapter.VideoFeedsViewHolder();
            paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130969669, paramViewGroup, false);
            paramView.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131367365));
            paramView.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramViewGroup.findViewById(2131367093));
            paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131363360));
            paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131361846));
            paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131367366));
            paramView.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131367367));
            paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramViewGroup.findViewById(2131362701));
            paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131362204));
            paramView.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367392));
            paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131364171));
            paramView.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367374));
            paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367376));
            paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367375));
            paramView.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367391));
            paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367210));
            paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)paramViewGroup.findViewById(2131367094));
            paramView.jdField_b_of_type_AndroidViewView = paramViewGroup.findViewById(2131366838);
            paramView.jdField_c_of_type_AndroidViewView = paramViewGroup.findViewById(2131367366);
            paramView.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131366808);
            paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup = ((ReadInJoyVideoInfoViewGroup)paramViewGroup.findViewById(2131367369));
            paramView.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367393));
            paramView.g = ((TextView)paramViewGroup.findViewById(2131367352));
            paramView.h = ((TextView)paramViewGroup.findViewById(2131367353));
            paramView.jdField_d_of_type_AndroidViewView = paramViewGroup.findViewById(2131363362);
            paramView.jdField_e_of_type_AndroidViewView = paramViewGroup.findViewById(2131367390);
            paramView.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131367370));
            paramView.i = ((TextView)paramViewGroup.findViewById(2131367368));
            paramView.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131367371));
            paramView.j = ((TextView)paramViewGroup.findViewById(2131367372));
            paramView.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367373));
            paramViewGroup.setTag(paramView);
            break label361;
            paramView = new ReadInJoyBaseAdapter.VideoFeedsTwoItemViewHolder();
            paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130969674, paramViewGroup, false);
            paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131367406));
            paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367407));
            paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367409));
            paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367410));
            paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramViewGroup.findViewById(2131367412));
            paramView.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367413));
            paramView.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131367405));
            paramView.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367408));
            paramView.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131367411));
            paramView.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131367415));
            paramView.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367416));
            paramView.g = ((TextView)paramViewGroup.findViewById(2131367418));
            paramView.h = ((TextView)paramViewGroup.findViewById(2131367419));
            paramView.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)paramViewGroup.findViewById(2131367421));
            paramView.i = ((TextView)paramViewGroup.findViewById(2131367422));
            paramView.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131367414));
            paramView.j = ((TextView)paramViewGroup.findViewById(2131367417));
            paramView.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131367420));
            paramViewGroup.setTag(paramView);
            break label361;
            paramView = new ReadInJoyBaseAdapter.WeishiGridTwoItemViewHolder();
            paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130969675, paramViewGroup, false);
            paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131367423));
            paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367407));
            paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367425));
            paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367426));
            paramView.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367408));
            paramView.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131367427));
            paramView.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367416));
            paramView.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367429));
            paramView.g = ((TextView)paramViewGroup.findViewById(2131367430));
            paramView.h = ((TextView)paramViewGroup.findViewById(2131367417));
            paramViewGroup.setTag(paramView);
            break label361;
            localObject3 = (ReadInJoyBaseAdapter.ViewHolder)paramView.getTag();
            ((ReadInJoyBaseAdapter.ViewHolder)localObject3).jdField_a_of_type_Int = paramInt;
            localObject2 = (IReadInJoyPresenter)paramView.getTag(2131362077);
            localObject1 = (ReadInJoyView)paramView.getTag(2131362078);
            paramViewGroup = paramView;
            break label448;
            if (!(localObject3 instanceof ReadInJoyBaseAdapter.VideoFeedsViewHolder)) {
              break label492;
            }
            a((ReadInJoyBaseAdapter.VideoFeedsViewHolder)localObject3, localBaseArticleInfo, paramInt);
            break label492;
            if (!(localObject3 instanceof ReadInJoyBaseAdapter.VideoFeedsTwoItemViewHolder)) {
              break label492;
            }
            a((ReadInJoyBaseAdapter.VideoFeedsTwoItemViewHolder)localObject3, localBaseArticleInfo);
            break label492;
            if (!(localObject3 instanceof ReadInJoyBaseAdapter.WeishiGridTwoItemViewHolder)) {
              break label492;
            }
            a((ReadInJoyBaseAdapter.WeishiGridTwoItemViewHolder)localObject3, localBaseArticleInfo, paramInt);
            break label492;
            label1754:
            if (paramInt == 2)
            {
              if (!this.jdField_e_of_type_Boolean) {
                this.jdField_e_of_type_Boolean = true;
              }
              if (this.jdField_f_of_type_Boolean) {
                this.jdField_f_of_type_Boolean = false;
              }
              paramViewGroup.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
            }
          }
        }
      }
      else
      {
        localObject1 = b(paramInt);
        paramViewGroup = null;
        if (paramInt < getCount() - 1) {
          paramViewGroup = (ArticleInfo)b(paramInt + 1);
        }
        a((BaseArticleInfo)localObject1, paramInt);
        localObject2 = new ReadInJoyModelImpl(this.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)localObject1, i1, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, paramInt, this.jdField_b_of_type_Boolean, getCount(), paramViewGroup, this);
        paramViewGroup = CellFactory.a(paramInt, localObject2, i1, paramView, this.jdField_a_of_type_AndroidAppActivity, this, a());
        if (paramViewGroup != null)
        {
          paramViewGroup.setTag(2131362079, localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyBaseAdapter", 2, "CellFactory.getView = " + ((FeedItemCell)paramViewGroup.getTag()).getClass().getSimpleName());
          }
          paramViewGroup.setTag(2131362291, a());
          a((BaseArticleInfo)localObject1, (IReadInJoyModel)localObject2, System.currentTimeMillis(), paramInt);
          if (localObject1 == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadInJoyBaseAdapter", 2, new Object[] { "getView() article is null, set view gone, position: ", Integer.valueOf(paramInt) });
            }
            if (paramViewGroup.getVisibility() != 8) {
              paramViewGroup.setVisibility(8);
            }
            paramView = paramViewGroup;
            if ((paramViewGroup.getLayoutParams() instanceof AbsListView.LayoutParams))
            {
              localObject1 = (AbsListView.LayoutParams)paramViewGroup.getLayoutParams();
              paramView = paramViewGroup;
              if (((AbsListView.LayoutParams)localObject1).height != 1)
              {
                ((AbsListView.LayoutParams)localObject1).height = 1;
                paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                paramView = paramViewGroup;
              }
            }
          }
          else
          {
            if (paramViewGroup.getVisibility() != 0) {
              paramViewGroup.setVisibility(0);
            }
            if ((paramViewGroup.getLayoutParams() instanceof AbsListView.LayoutParams))
            {
              paramView = (AbsListView.LayoutParams)paramViewGroup.getLayoutParams();
              if (paramView.height != -2)
              {
                paramView.height = -2;
                paramViewGroup.setLayoutParams(paramView);
              }
            }
            paramView = paramViewGroup;
            if ((a() instanceof ReadInJoyChannelActivity))
            {
              if (((!this.jdField_e_of_type_Boolean) || (this.jdField_f_of_type_Boolean)) && (i1 == 53) && (paramInt > 0) && (paramInt <= 2))
              {
                if ((paramInt != 1) || (!this.jdField_g_of_type_Boolean)) {
                  break label2242;
                }
                this.jdField_g_of_type_Boolean = false;
                paramViewGroup.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
              }
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.readinjoy.videoanimation", 2, "adapter animation start at item position" + paramInt);
                }
                paramView = paramViewGroup;
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("Q.readinjoy.videoanimation", 2, " judge adapter animation show or not：");
                paramView = paramViewGroup;
                break;
                label2242:
                if (paramInt == 2)
                {
                  if (!this.jdField_e_of_type_Boolean) {
                    this.jdField_e_of_type_Boolean = true;
                  }
                  if (this.jdField_f_of_type_Boolean) {
                    this.jdField_f_of_type_Boolean = false;
                  }
                  paramViewGroup.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
                }
              }
            }
          }
        }
        else
        {
          QLog.w("ReadInJoyBaseAdapter", 1, "CellFactory.getView = null");
          paramView = paramViewGroup;
        }
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 71;
  }
  
  public void h()
  {
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_c_of_type_Int == 0) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController.a()) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController.b()) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getVisibility() != 0));
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1001);
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video", 2, "checkPlayableArea after transAnim: ");
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video_" + this.jdField_c_of_type_Int, 2, "ReadInJoyBaseAdapter doOnResume()");
      }
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)) {
        notifyDataSetChanged();
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.q = true;
      this.jdField_a_of_type_Boolean = true;
      c();
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new mgm(this), 1000L);
    } while (Build.VERSION.SDK_INT >= 21);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setFriction(jdField_a_of_type_Float);
  }
  
  public boolean isEmpty()
  {
    return this.jdField_b_of_type_JavaUtilList.isEmpty();
  }
  
  public void j()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video_" + this.jdField_c_of_type_Int, 2, "ReadInJoyBaseAdapter doOnPause()");
    }
    this.jdField_a_of_type_Boolean = false;
    JSONObject localJSONObject;
    if ((this.jdField_c_of_type_Int == 56) && (this.jdField_a_of_type_Long != 0L)) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("channel_id", this.jdField_c_of_type_Int);
      localJSONObject.put("stay_duration", (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null))
      {
        localJSONObject.put("algorithm_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_f_of_type_Long);
        localJSONObject.put("strategy_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_g_of_type_Int);
      }
      label160:
      PublicAccountReportUtils.a(null, "", "0X8007DBB", "0X8007DBB", 0, 0, "", "", "", VideoReporter.a("", "", "", "", localJSONObject), false);
      this.jdField_a_of_type_Long = 0L;
      if ((this.jdField_a_of_type_ComTencentWidgetKandianPopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetKandianPopupWindow.isShowing())) {
        this.jdField_a_of_type_ComTencentWidgetKandianPopupWindow.dismiss();
      }
      if ((this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd != null) && (this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd.isShowing())) {
        this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd.dismiss();
      }
      this.jdField_m_of_type_Int = NetworkUtil.b(this.jdField_a_of_type_AndroidAppActivity);
      return;
    }
    catch (Exception localException)
    {
      break label160;
    }
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b(9);
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "notifyDataSetChanged");
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null))
    {
      int i1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(i1, true);
    }
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof ReadInJoyFeedsActivity)) {
      ((ReadInJoyFeedsActivity)this.jdField_a_of_type_AndroidAppActivity).b(16);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
    Object localObject1;
    long l1;
    int i1;
    label928:
    label1389:
    Object localObject5;
    Object localObject6;
    Object localObject2;
    switch (paramView.getId())
    {
    case 2131366838: 
    default: 
    case 2131361846: 
    case 2131367093: 
    case 2131367094: 
    case 2131367365: 
    case 2131362202: 
    case 2131367366: 
    case 2131367374: 
    case 2131367375: 
    case 2131367376: 
    case 2131366836: 
    case 2131367373: 
      do
      {
        for (;;)
        {
          return;
          if ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController.a()) && (ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) > 0))
          {
            paramView = (ReadInJoyBaseAdapter.VideoFeedsViewHolder)paramView.getTag();
            localObject1 = b(paramView.jdField_a_of_type_Int);
            if (localObject1 != null) {
              a(paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, (BaseArticleInfo)localObject1, false);
            }
          }
          else
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a().c(paramView);
            return;
            paramView = (oidb_cmd0x68b.ChannelInfo)paramView.getTag();
            if (paramView != null) {
              if ((paramView.bytes_channel_url.has()) && (paramView.bytes_channel_url.get() != null))
              {
                if (!TextUtils.isEmpty(paramView.bytes_channel_url.get().toStringUtf8())) {
                  ReadInJoyUtils.a(this.jdField_a_of_type_AndroidAppActivity, paramView.bytes_channel_url.get().toStringUtf8());
                }
              }
              else
              {
                ReadInJoyActivityHelper.b(this.jdField_a_of_type_AndroidAppActivity, paramView.uint32_channel_id.get(), ReadInJoyUtils.a(paramView), paramView.uint32_channel_type.get(), 6, null);
                return;
                paramView = (ReadInJoyBaseAdapter.VideoFeedsViewHolder)paramView.getTag();
                localObject1 = b(paramView.jdField_a_of_type_Int);
                if (localObject1 != null)
                {
                  ThreadManager.executeOnSubThread(new mgq(this, (BaseArticleInfo)localObject1));
                  if (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject1))
                  {
                    ReadinJoyActionUtil.b(this.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)localObject1, this, 56);
                    return;
                  }
                  a(paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, (BaseArticleInfo)localObject1);
                  this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
                  this.jdField_h_of_type_Boolean = true;
                  return;
                  paramView = (ReadInJoyBaseAdapter.VideoFeedsViewHolder)paramView.getTag();
                  localObject1 = b(paramView.jdField_a_of_type_Int);
                  if (localObject1 != null)
                  {
                    a(paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, (BaseArticleInfo)localObject1, true);
                    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
                    this.jdField_h_of_type_Boolean = true;
                    ThreadManager.executeOnSubThread(new mgr(this, (BaseArticleInfo)localObject1));
                    return;
                    localObject1 = b(((ReadInJoyBaseAdapter.VideoFeedsViewHolder)paramView.getTag()).jdField_a_of_type_Int);
                    if (localObject1 != null)
                    {
                      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a()) {
                        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
                      }
                      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoRecommendManager != null) {
                        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoRecommendManager.a(1, (BaseArticleInfo)localObject1, 0L, 0L);
                      }
                      paramView = new Intent(a(), ReadInJoyDeliverBiuActivity.class);
                      paramView.putExtra("arg_article_info", (ArticleInfo)localObject1);
                      paramView.putExtra("biu_src", 2);
                      paramView.putExtra("arg_from_type", 7);
                      a().startActivityForResult(paramView, 2);
                      a().overridePendingTransition(0, 0);
                      long l2 = 0L;
                      paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
                      l1 = l2;
                      if (paramView != null)
                      {
                        l1 = l2;
                        if (paramView.jdField_a_of_type_JavaLangString.equals(((BaseArticleInfo)localObject1).mVideoVid)) {
                          l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
                        }
                      }
                      localObject3 = new JSONObject();
                      Object localObject4;
                      try
                      {
                        ((JSONObject)localObject3).put("algorithm_id", ((BaseArticleInfo)localObject1).mAlgorithmID);
                        ((JSONObject)localObject3).put("strategy_id", ((BaseArticleInfo)localObject1).mStrategyId);
                        ((JSONObject)localObject3).put("channel_id", this.jdField_c_of_type_Int);
                        localObject4 = ((BaseArticleInfo)localObject1).mSubscribeID;
                        if (!TextUtils.isEmpty(((BaseArticleInfo)localObject1).innerUniqueID))
                        {
                          paramView = ((BaseArticleInfo)localObject1).innerUniqueID;
                          PublicAccountReportUtils.a(null, (String)localObject4, "0X8007B89", "0X8007B89", 0, 0, "1", "", paramView, VideoReporter.a(null, ((BaseArticleInfo)localObject1).mSubscribeID, ((BaseArticleInfo)localObject1).mVideoVid, ((BaseArticleInfo)localObject1).innerUniqueID, l1, ((BaseArticleInfo)localObject1).mVideoDuration * 1000, (JSONObject)localObject3), false);
                          l2 = a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
                          paramView = new ReportInfo.VideoExtraRepoerData();
                          paramView.jdField_d_of_type_Int = ((int)l1);
                          paramView.jdField_e_of_type_Int = (((BaseArticleInfo)localObject1).mVideoDuration * 1000);
                          if (l2 != 0L) {
                            break label928;
                          }
                          i1 = 1;
                          paramView.jdField_c_of_type_Int = i1;
                          VideoReporter.a(((BaseArticleInfo)localObject1).mArticleID, ((BaseArticleInfo)localObject1).innerUniqueID, this.jdField_c_of_type_Int, 25, -1L, paramView);
                        }
                      }
                      catch (JSONException paramView)
                      {
                        for (;;)
                        {
                          paramView.printStackTrace();
                          continue;
                          paramView = "0";
                          continue;
                          i1 = 2;
                        }
                      }
                      paramView = (ReadInJoyBaseAdapter.VideoFeedsViewHolder)paramView.getTag();
                      localObject1 = b(paramView.jdField_a_of_type_Int);
                      if (localObject1 == null)
                      {
                        if (QLog.isColorLevel()) {
                          QLog.d("ReadInJoyBaseAdapter", 2, "articleInfo == null, ERROR");
                        }
                      }
                      else
                      {
                        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a())
                        {
                          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
                          this.jdField_j_of_type_Boolean = true;
                        }
                        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoShareHelper.a(paramView.jdField_f_of_type_AndroidViewView, paramView.jdField_a_of_type_Int);
                        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoShareHelper.a(this);
                        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoShareHelper.a((BaseArticleInfo)localObject1, a(paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, (BaseArticleInfo)localObject1), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager, new mgs(this, (BaseArticleInfo)localObject1), this.jdField_c_of_type_Int);
                        return;
                        localObject3 = (ReadInJoyBaseAdapter.ViewHolder)paramView.getTag();
                        localObject1 = (BaseArticleInfo)this.jdField_b_of_type_JavaUtilList.get(((ReadInJoyBaseAdapter.ViewHolder)localObject3).jdField_a_of_type_Int);
                        try
                        {
                          localObject4 = new JSONObject();
                          ((JSONObject)localObject4).put("time", System.currentTimeMillis() / 1000L);
                          ((JSONObject)localObject4).put("channel_id", this.jdField_c_of_type_Int);
                          if ((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity))
                          {
                            ((JSONObject)localObject4).put("folder_status", ReadInJoyUtils.jdField_d_of_type_Int);
                            ((JSONObject)localObject4).put("kandian_mode", ReadInJoyUtils.e());
                            ((JSONObject)localObject4).put("feeds_type", "" + ReadInJoyUtils.a((BaseArticleInfo)localObject1));
                            PublicAccountReportUtils.a(null, "", "0X8007058", "0X8007058", 0, 0, "", "", "", ((JSONObject)localObject4).toString(), false);
                          }
                          while (localObject1 != null)
                          {
                            i1 = ((ReadInJoyBaseAdapter.ViewHolder)localObject3).jdField_a_of_type_Int;
                            localObject3 = new mgt(this, i1, (ReadInJoyBaseAdapter.ViewHolder)localObject3, (BaseArticleInfo)localObject1);
                            if (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject1)) {
                              break label1389;
                            }
                            if ((this.jdField_a_of_type_ComTencentWidgetKandianPopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetKandianPopupWindow.isShowing())) {
                              this.jdField_a_of_type_ComTencentWidgetKandianPopupWindow.dismiss();
                            }
                            if (!this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd.a()) {
                              this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd.a();
                            }
                            if (!this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd.a(i1, ((BaseArticleInfo)localObject1).mDislikeInfos)) {
                              break;
                            }
                            this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd.a(paramView, (KandianPopupWindow.OnUninterestConfirmListener)localObject3);
                            return;
                            if ((this.jdField_a_of_type_AndroidAppActivity instanceof PluginBaseActivity))
                            {
                              ((JSONObject)localObject4).put("folder_status", 1);
                              ReportController.b(null, "CliOper", "", "", "0X800705F", "0X800705F", 0, 0, "", "", "", ((JSONObject)localObject4).toString());
                            }
                          }
                        }
                        catch (JSONException localJSONException2)
                        {
                          for (;;)
                          {
                            localJSONException2.printStackTrace();
                          }
                          if ((this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd != null) && (this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd.isShowing())) {
                            this.jdField_a_of_type_ComTencentWidgetKandianPopupWindowForAd.dismiss();
                          }
                          if (!this.jdField_a_of_type_ComTencentWidgetKandianPopupWindow.a()) {
                            this.jdField_a_of_type_ComTencentWidgetKandianPopupWindow.a();
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      } while (!this.jdField_a_of_type_ComTencentWidgetKandianPopupWindow.a(i1, ((BaseArticleInfo)localObject1).mDislikeInfos));
      this.jdField_a_of_type_ComTencentWidgetKandianPopupWindow.a(paramView, (KandianPopupWindow.OnUninterestConfirmListener)localObject3);
      return;
    case 2131362204: 
    case 2131362701: 
    case 2131367367: 
    case 2131367411: 
    case 2131367420: 
      localObject3 = (BaseArticleInfo)paramView.getTag();
      localObject1 = null;
      if ((!TextUtils.isEmpty(((BaseArticleInfo)localObject3).mSubscribeID)) && (!"16888".equals(((BaseArticleInfo)localObject3).mSubscribeID))) {
        paramView = ((BaseArticleInfo)localObject3).mSubscribeID;
      }
      for (;;)
      {
        if (paramView != null) {
          a(paramView);
        }
        localObject5 = new JSONObject();
        try
        {
          ((JSONObject)localObject5).put("channel_id", this.jdField_c_of_type_Int);
          if (!TextUtils.isEmpty(((BaseArticleInfo)localObject3).innerUniqueID))
          {
            localObject1 = String.valueOf(((BaseArticleInfo)localObject3).innerUniqueID);
            localObject6 = ((BaseArticleInfo)localObject3).mVideoVid;
            String str = String.valueOf(((BaseArticleInfo)localObject3).innerUniqueID);
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null) {
              break label1696;
            }
            l1 = 0L;
            PublicAccountReportUtils.a(null, paramView, "0X8007410", "0X8007410", 0, 0, "2", "", (String)localObject1, VideoReporter.a(null, paramView, (String)localObject6, str, l1, ((BaseArticleInfo)localObject3).mVideoDuration * 1000, (JSONObject)localObject5), false);
            ReadinJoyActionUtil.b(this.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)localObject3, this, 56);
            return;
            paramView = (View)localObject1;
            if (TextUtils.isEmpty(((BaseArticleInfo)localObject3).thirdUin)) {
              continue;
            }
            paramView = (View)localObject1;
            if ("16888".equals(((BaseArticleInfo)localObject3).thirdUin)) {
              continue;
            }
            paramView = ((BaseArticleInfo)localObject3).thirdUin;
          }
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            localJSONException1.printStackTrace();
            continue;
            localObject2 = "0";
            continue;
            l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
          }
        }
      }
    case 2131367368: 
    case 2131367372: 
      paramView = b(((ReadInJoyBaseAdapter.VideoFeedsViewHolder)paramView.getTag()).jdField_a_of_type_Int);
      ReadinJoyActionUtil.b(this.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)paramView, this, 56);
      return;
    case 2131367406: 
    case 2131367415: 
      label1696:
      if (paramView.getId() == 2131367406)
      {
        localObject2 = ((ReadInJoyBaseAdapter.VideoFeedsTwoItemViewHolder)paramView.getTag()).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
        localObject5 = ((ReadInJoyBaseAdapter.VideoFeedsTwoItemViewHolder)paramView.getTag()).jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID;
        localObject3 = localObject2;
        label1778:
        localObject6 = a((BaseArticleInfo)localObject2);
        ((VideoPlayManager.VideoPlayParam)localObject6).m = ((String)localObject5);
        ((VideoPlayManager.VideoPlayParam)localObject6).jdField_k_of_type_JavaLangString = VideoReporter.b();
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a()))) {
          ((VideoPlayManager.VideoPlayParam)localObject6).l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
        }
        b((VideoPlayManager.VideoPlayParam)localObject6, (BaseArticleInfo)localObject2);
        localObject5 = new JSONObject();
      }
      for (;;)
      {
        try
        {
          if (paramView.getId() != 2131367406) {
            continue;
          }
          i1 = 0;
          ((JSONObject)localObject5).put("card_pos", i1);
          ((JSONObject)localObject5).put("session_id", ((VideoPlayManager.VideoPlayParam)localObject6).jdField_k_of_type_JavaLangString);
          ((JSONObject)localObject5).put("video_session_id", ((VideoPlayManager.VideoPlayParam)localObject6).l);
          ((JSONObject)localObject5).put("channel_id", this.jdField_c_of_type_Int);
          ((JSONObject)localObject5).put("ads_source", ((BaseArticleInfo)localObject2).mVideoAdsSource);
          ((JSONObject)localObject5).put("ads_jump", ((BaseArticleInfo)localObject2).mVideoAdsJumpType);
        }
        catch (JSONException localJSONException3)
        {
          localJSONException3.printStackTrace();
          continue;
          if (this.jdField_c_of_type_Int == 0) {
            continue;
          }
          localObject3 = new int[2];
          paramView.getLocationOnScreen((int[])localObject3);
          ((VideoPlayManager.VideoPlayParam)localObject6).jdField_h_of_type_Int = localObject3[0];
          ((VideoPlayManager.VideoPlayParam)localObject6).jdField_i_of_type_Int = localObject3[1];
          ((VideoPlayManager.VideoPlayParam)localObject6).jdField_j_of_type_Int = paramView.getWidth();
          ((VideoPlayManager.VideoPlayParam)localObject6).jdField_k_of_type_Int = paramView.getHeight();
          a((VideoPlayManager.VideoPlayParam)localObject6, (BaseArticleInfo)localObject2);
          return;
          if (((BaseArticleInfo)localObject2).videoJumpChannelID <= 0) {
            continue;
          }
          if (((BaseArticleInfo)localObject2).videoJumpChannelID != 56) {
            continue;
          }
          ReadInJoyActivityHelper.a(this.jdField_a_of_type_AndroidAppActivity, (BaseArticleInfo)localObject3, (BaseArticleInfo)localObject2, true);
          return;
          paramView = new HashMap();
          paramView.put("param_key_insert_article_id", Long.valueOf(((BaseArticleInfo)localObject2).mArticleID));
          ReadInJoyActivityHelper.b(this.jdField_a_of_type_AndroidAppActivity, ((BaseArticleInfo)localObject2).videoJumpChannelID, ((BaseArticleInfo)localObject2).videoJumpChannelName, ((BaseArticleInfo)localObject2).videoJumpChannelType, 5, paramView);
          return;
          if (ReadInJoyHelper.d(BaseApplicationImpl.getApplication().getRuntime()) != 1) {
            continue;
          }
          ReadInJoyActivityHelper.a(this.jdField_a_of_type_AndroidAppActivity, (BaseArticleInfo)localObject3, (BaseArticleInfo)localObject2, true);
          return;
          a((VideoPlayManager.VideoPlayParam)localObject6, (BaseArticleInfo)localObject2);
          return;
        }
        PublicAccountReportUtils.a(null, "", "0X8008D33", "0X8008D33", 0, 0, "", "", "", VideoReporter.a((JSONObject)localObject5), false);
        if (!((BaseArticleInfo)localObject2).isVideoItemForAdJump()) {
          continue;
        }
        paramView = a();
        if (paramView == null) {
          break;
        }
        localObject3 = new Intent(paramView, QQBrowserActivity.class);
        ((Intent)localObject3).putExtra("url", ((BaseArticleInfo)localObject2).mVideoAdsJumpUrl);
        paramView.startActivity((Intent)localObject3);
        return;
        localObject2 = ((ReadInJoyBaseAdapter.VideoFeedsTwoItemViewHolder)paramView.getTag()).jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
        localObject5 = ((ReadInJoyBaseAdapter.VideoFeedsTwoItemViewHolder)paramView.getTag()).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID;
        localObject3 = ((ReadInJoyBaseAdapter.VideoFeedsTwoItemViewHolder)paramView.getTag()).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
        break label1778;
        i1 = 1;
      }
    }
    if (paramView.getId() == 2131367423) {
      localObject2 = ((ReadInJoyBaseAdapter.WeishiGridTwoItemViewHolder)paramView.getTag()).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    }
    for (Object localObject3 = ((ReadInJoyBaseAdapter.WeishiGridTwoItemViewHolder)paramView.getTag()).jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID;; localObject3 = ((ReadInJoyBaseAdapter.WeishiGridTwoItemViewHolder)paramView.getTag()).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID)
    {
      localObject5 = a((BaseArticleInfo)localObject2);
      ((VideoPlayManager.VideoPlayParam)localObject5).m = ((String)localObject3);
      ((VideoPlayManager.VideoPlayParam)localObject5).jdField_k_of_type_JavaLangString = VideoReporter.b();
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a()))) {
        ((VideoPlayManager.VideoPlayParam)localObject5).l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
      }
      b((VideoPlayManager.VideoPlayParam)localObject5, (BaseArticleInfo)localObject2);
      localObject3 = new int[2];
      paramView.getLocationOnScreen((int[])localObject3);
      ((VideoPlayManager.VideoPlayParam)localObject5).jdField_h_of_type_Int = localObject3[0];
      ((VideoPlayManager.VideoPlayParam)localObject5).jdField_i_of_type_Int = localObject3[1];
      ((VideoPlayManager.VideoPlayParam)localObject5).jdField_j_of_type_Int = paramView.getWidth();
      ((VideoPlayManager.VideoPlayParam)localObject5).jdField_k_of_type_Int = paramView.getHeight();
      a((VideoPlayManager.VideoPlayParam)localObject5, (BaseArticleInfo)localObject2);
      return;
      localObject2 = ((ReadInJoyBaseAdapter.WeishiGridTwoItemViewHolder)paramView.getTag()).jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter
 * JD-Core Version:    0.7.0.1
 */