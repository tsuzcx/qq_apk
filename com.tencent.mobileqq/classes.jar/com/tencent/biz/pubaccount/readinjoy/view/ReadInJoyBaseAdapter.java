package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ProteusSupportUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJReportDataCollectionManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ClickHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ListenerBuilder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.PrefetchListener;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJDislikeAnimation;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJInvokeHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJOnScrollChangeListener;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJOnScrollListener;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJProteusParserObserver;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.click.RIJFrameworkHandleClick;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.dislike.RIJDislikeManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.image.RIJPreloadImage;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.shake.RIJShakeManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.RIJConfigVideoItem;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.RIJFullVideoPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click.RIJVideoHandleClick;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.report.RIJVideoReportManager;
import com.tencent.biz.pubaccount.readinjoy.handlers.BaseHandler;
import com.tencent.biz.pubaccount.readinjoy.handlers.HandlerFactory;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.utils.DynamicItemViewHelper;
import com.tencent.biz.pubaccount.readinjoy.proteus.wrap.ReadInjoyContext;
import com.tencent.biz.pubaccount.readinjoy.pts.lite.PTSLiteItemViewBuilder;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.video.RecommendADVideoFeedsManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoBehaviorsReporter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.viewholder.BigImgVideoColumnItemViewHolder;
import com.tencent.biz.pubaccount.readinjoy.video.viewholder.BigImgVideoItemViewHolder;
import com.tencent.biz.pubaccount.readinjoy.video.viewholder.VideoColumnItemViewHolder;
import com.tencent.biz.pubaccount.readinjoy.video.viewholder.VideoFeedsTwoItemViewHolder;
import com.tencent.biz.pubaccount.readinjoy.video.viewholder.VideoFeedsViewHolder;
import com.tencent.biz.pubaccount.readinjoy.video.viewholder.WeishiGridTwoItemViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyFeedbackPopupWindow;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ExposureSupplementUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.util.FeedExposureHelper;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.biz.ui.CustomAnimationAdapter;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.TextHook;
import com.tencent.widget.AbsListView;
import com.tencent.widget.KandianNegativeWindow;
import com.tencent.widget.KandianNegativeWindowForAd;
import com.tencent.widget.ListView;
import com.tencent.widget.TraceUtils;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class ReadInJoyBaseAdapter
  extends CustomAnimationAdapter
  implements View.OnClickListener, View.OnLongClickListener, IAdapterDeleteListener
{
  public static float a;
  public static int a;
  static DynamicItemViewHelper jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusUtilsDynamicItemViewHelper = new DynamicItemViewHelper();
  public static int b;
  public static int e;
  public long a;
  protected Activity a;
  protected LayoutInflater a;
  private ADBaseAppDownloadManager jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilADBaseAppDownloadManager;
  protected RIJDataManager a;
  protected ListenerBuilder a;
  protected RIJInvokeHandler a;
  public RIJOnScrollListener a;
  private RIJProteusParserObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJProteusParserObserver;
  protected RIJFrameworkHandleClick a;
  private RIJShakeManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokShakeRIJShakeManager;
  protected RIJVideoHandleClick a;
  protected RecommendADVideoFeedsManager a;
  private IReadInJoyListItemLifeCycle jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewIReadInJoyListItemLifeCycle;
  protected ReadInJoyXListView a;
  public GdtHandler.Params a;
  private ArrayList<IReadInJoyListItemLifeCycle> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<Integer, ClickHandler> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public HashSet<String> a;
  protected Set<Long> a;
  protected boolean a;
  public long b;
  public HashSet<String> b;
  public boolean b;
  protected int c;
  private long jdField_c_of_type_Long = -1L;
  private boolean jdField_c_of_type_Boolean;
  protected int d = 0;
  
  static
  {
    jdField_a_of_type_Int = 20;
    jdField_b_of_type_Int = 250;
    e = 1000;
    jdField_a_of_type_Float = ViewConfiguration.getScrollFriction();
    if (Build.VERSION.SDK_INT < 21) {
      jdField_a_of_type_Float = 0.025F;
    }
  }
  
  public ReadInJoyBaseAdapter(Activity paramActivity, LayoutInflater paramLayoutInflater, int paramInt, ListView paramListView, SparseArray<BaseHandler> paramSparseArray)
  {
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = -2147483648L;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
    this.jdField_c_of_type_Int = paramInt;
    paramLayoutInflater = new ReadInjoyContext();
    paramLayoutInflater.setContext(paramActivity);
    paramLayoutInflater.setCurActivity(paramActivity);
    ProteusSupportUtil.a(paramLayoutInflater, "default_feeds");
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusUtilsDynamicItemViewHelper.a(paramLayoutInflater);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = ((ReadInJoyXListView)paramListView);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler = new RIJInvokeHandler();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a(paramSparseArray, this);
    paramActivity = new RIJPreloadImage();
    paramActivity.a();
    paramSparseArray = new RIJDislikeManager();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager = new RIJDataManager(new RIJDataManager.Builder().a(this.jdField_a_of_type_AndroidAppActivity).a(this.jdField_c_of_type_Int).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a().a()).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a().a()).a(this).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a().a()).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a().a()).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a().a()).a(jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusUtilsDynamicItemViewHelper).a(paramActivity).a(paramLayoutInflater).a(paramSparseArray).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a().a()));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickRIJFrameworkHandleClick = new RIJFrameworkHandleClick(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerVideoClickRIJVideoHandleClick = new RIJVideoHandleClick(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokShakeRIJShakeManager = new RIJShakeManager(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJProteusParserObserver = new RIJProteusParserObserver(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJOnScrollListener = new RIJOnScrollListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager);
    ((ReadInJoyXListView)paramListView).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJOnScrollListener);
    ((ReadInJoyXListView)paramListView).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a);
    ((ReadInJoyXListView)paramListView).setOnDrawCompleteListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a());
    ((ReadInJoyXListView)paramListView).a(new RIJOnScrollChangeListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager));
  }
  
  public static VideoPlayManager.VideoPlayParam a(BaseArticleInfo paramBaseArticleInfo)
  {
    return RIJConfigVideoItem.a(paramBaseArticleInfo);
  }
  
  public static VideoPlayManager.VideoPlayParam a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    return RIJConfigVideoItem.a(paramBaseArticleInfo, paramBoolean);
  }
  
  public static String a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if ((jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusUtilsDynamicItemViewHelper != null) && (DynamicItemViewHelper.a(paramArticleInfo)))
    {
      paramArticleInfo = jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusUtilsDynamicItemViewHelper.b(paramArticleInfo);
      QLog.d("ReadInJoyBaseAdapter", 2, "getProteusFamilyCardViewType | dynamic viewType : " + paramArticleInfo);
      return paramArticleInfo;
    }
    paramArticleInfo = String.valueOf(RIJItemViewType.a(paramArticleInfo, paramInt));
    QLog.d("ReadInJoyBaseAdapter", 2, "getProteusFamilyCardViewType | normal viewType : " + paramArticleInfo);
    return paramArticleInfo;
  }
  
  private void a(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.feedsFirstExposurePos == -1)) {
      paramBaseArticleInfo.feedsFirstExposurePos = paramInt;
    }
    ReadinjoyReportUtils.a(paramBaseArticleInfo, ReadinjoyReportUtils.e, false, "");
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public abstract int a(int paramInt);
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a().a();
  }
  
  public abstract Activity a();
  
  public Bitmap a(long paramLong)
  {
    return null;
  }
  
  public AnimationSet a()
  {
    return new RIJDislikeAnimation(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager).a();
  }
  
  public ADBaseAppDownloadManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilADBaseAppDownloadManager;
  }
  
  public RIJDataManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager;
  }
  
  public ListenerBuilder a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokListenerBuilder;
  }
  
  public DynamicItemViewHelper a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().b();
  }
  
  public ArticleInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a(a());
  }
  
  public abstract BaseArticleInfo a(int paramInt);
  
  public abstract BaseArticleInfo a(int paramInt, long paramLong);
  
  public RecommendADVideoFeedsManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoRecommendADVideoFeedsManager;
  }
  
  public VideoPlayManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a().a();
  }
  
  public VafContext a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a();
  }
  
  public ReadInJoyFeedbackPopupWindow a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a().a(a(), this);
  }
  
  public ExposureSupplementUtil a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a();
  }
  
  public IFaceDecoder a()
  {
    return null;
  }
  
  public KandianNegativeWindow a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a().a(a());
  }
  
  public KandianNegativeWindowForAd a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a().a(a());
  }
  
  public ListView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView;
  }
  
  public String a(long paramLong)
  {
    return null;
  }
  
  public ArrayList<BaseReportData> a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a();
  }
  
  public List<BaseArticleInfo> a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a();
  }
  
  public void a()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.b();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a().a();
    if (this.jdField_c_of_type_Int == 56) {
      VideoBehaviorsReporter.a().a();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoRecommendADVideoFeedsManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoRecommendADVideoFeedsManager.d();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a().s();
  }
  
  public void a(int paramInt)
  {
    a(paramInt, true);
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a().a(paramInt, paramIntent);
  }
  
  public abstract void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, ArrayList<DislikeInfo> paramArrayList);
  
  public abstract void a(int paramInt, ArrayList<BaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1);
  
  public void a(int paramInt, ArrayList<BaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1, Object paramObject)
  {
    a(paramInt, paramArrayList, paramArrayList1, paramObject, false, true);
  }
  
  public void a(int paramInt, ArrayList<BaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1, Object paramObject, boolean paramBoolean)
  {
    a(paramInt, paramArrayList, paramArrayList1, paramObject, paramBoolean, true);
  }
  
  public void a(int paramInt, ArrayList<BaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1, Object paramObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a(paramInt, paramArrayList, paramArrayList1, paramObject, paramBoolean1, paramBoolean2);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a().b(paramInt, paramBoolean);
  }
  
  public void a(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a(this.jdField_c_of_type_Long);
  }
  
  public void a(ADBaseAppDownloadManager paramADBaseAppDownloadManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilADBaseAppDownloadManager = paramADBaseAppDownloadManager;
  }
  
  public void a(ListenerBuilder paramListenerBuilder)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokListenerBuilder = paramListenerBuilder;
  }
  
  public void a(PrefetchListener paramPrefetchListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a(paramPrefetchListener);
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {
      return;
    }
    g();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a(paramAdvertisementInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().remove(paramBaseArticleInfo);
    notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().e(true);
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, IReadInJoyModel paramIReadInJoyModel, long paramLong, int paramInt)
  {
    RIJReportDataCollectionManager.a(paramBaseArticleInfo, paramIReadInJoyModel, paramLong, paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager);
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo1, BaseArticleInfo paramBaseArticleInfo2, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a(paramBaseArticleInfo1, paramBaseArticleInfo2, paramBoolean);
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a().a(a()) != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a().a(a()).isShowing())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a().a(a()).dismiss();
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a().a(a()) != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a().a(a()).isShowing())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a().a(a()).dismiss();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a().a(paramVideoPlayParam);
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a().a(paramVideoPlayParam, paramInt);
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, BaseArticleInfo paramBaseArticleInfo)
  {
    a(paramVideoPlayParam, paramBaseArticleInfo, false, true);
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    RIJFullVideoPlayActivity.a(paramVideoPlayParam, paramBaseArticleInfo, paramBoolean1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager);
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam1, VideoPlayManager.VideoPlayParam paramVideoPlayParam2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a().a(paramVideoPlayParam1, paramVideoPlayParam2);
  }
  
  public void a(VideoPlayManager paramVideoPlayManager, VideoAutoPlayController paramVideoAutoPlayController)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a(paramVideoPlayManager).a(paramVideoAutoPlayController).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a().a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a().a(paramVideoPlayManager, paramVideoAutoPlayController);
    paramVideoPlayManager = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a().a();
    if ((ReadInJoyAdUtils.a(a())) && (paramVideoPlayManager != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoRecommendADVideoFeedsManager = new RecommendADVideoFeedsManager(this.jdField_a_of_type_AndroidAppActivity, this, paramVideoPlayManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, a());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a().a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoRecommendADVideoFeedsManager);
    }
  }
  
  public void a(BigImgVideoColumnItemViewHolder paramBigImgVideoColumnItemViewHolder, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    RIJConfigVideoItem.a(paramBigImgVideoColumnItemViewHolder, paramBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager, this, this);
  }
  
  public void a(BigImgVideoItemViewHolder paramBigImgVideoItemViewHolder, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    RIJConfigVideoItem.a(paramBigImgVideoItemViewHolder, paramBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager, this, this);
  }
  
  public void a(VideoColumnItemViewHolder paramVideoColumnItemViewHolder, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    RIJConfigVideoItem.a(paramVideoColumnItemViewHolder, paramBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager, this, this);
  }
  
  public void a(VideoFeedsTwoItemViewHolder paramVideoFeedsTwoItemViewHolder, BaseArticleInfo paramBaseArticleInfo)
  {
    RIJConfigVideoItem.a(paramVideoFeedsTwoItemViewHolder, paramBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager, this);
  }
  
  public void a(VideoFeedsViewHolder paramVideoFeedsViewHolder, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    RIJConfigVideoItem.a(paramVideoFeedsViewHolder, paramBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager, this, this, this.jdField_a_of_type_JavaUtilSet);
  }
  
  public void a(WeishiGridTwoItemViewHolder paramWeishiGridTwoItemViewHolder, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    RIJConfigVideoItem.a(paramWeishiGridTwoItemViewHolder, paramBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager, this, this);
  }
  
  public void a(IReadInJoyListItemLifeCycle paramIReadInJoyListItemLifeCycle)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewIReadInJoyListItemLifeCycle = paramIReadInJoyListItemLifeCycle;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setNoteCardLifeCycle(paramIReadInJoyListItemLifeCycle);
    }
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a(paramReadInJoyBaseListView);
  }
  
  public void a(ExposureSupplementUtil paramExposureSupplementUtil)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a(paramExposureSupplementUtil);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a().b(paramAbsListView, paramInt);
  }
  
  public void a(List<BaseArticleInfo> paramList)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a(paramList);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a(paramList);
  }
  
  public void a(List<ArticleInfo> paramList, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a(paramList, paramInt);
  }
  
  public void a(Set<Long> paramSet, Map<Long, BaseReportData> paramMap)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a(paramSet, paramMap);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().c(paramBoolean);
  }
  
  public void a(boolean paramBoolean, ArticleInfo paramArticleInfo1, ArticleInfo paramArticleInfo2, String paramString, Map<String, Object> paramMap)
  {
    RIJVideoReportManager.a(paramBoolean, paramArticleInfo1, paramArticleInfo2, paramString, paramMap, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager);
  }
  
  public void a(boolean paramBoolean, BaseArticleInfo paramBaseArticleInfo)
  {
    RIJVideoReportManager.a(paramBoolean, paramBaseArticleInfo, a(), this.jdField_c_of_type_Int, this.jdField_c_of_type_Long);
  }
  
  public abstract boolean a();
  
  public boolean a(int paramInt)
  {
    return paramInt == 46;
  }
  
  public abstract boolean a(int paramInt, long paramLong);
  
  public int b()
  {
    return this.d;
  }
  
  public BaseArticleInfo b(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a(paramInt);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a().o();
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void b(BaseArticleInfo paramBaseArticleInfo)
  {
    RIJVideoReportManager.a(paramBaseArticleInfo, a(), this.jdField_c_of_type_Int);
  }
  
  public void b(IReadInJoyListItemLifeCycle paramIReadInJoyListItemLifeCycle)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramIReadInJoyListItemLifeCycle);
  }
  
  public void b(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a().c(paramAbsListView, paramInt);
  }
  
  public void b(List<BaseArticleInfo> paramList)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.b(paramList);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().f(paramBoolean);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().d();
  }
  
  public abstract boolean b(int paramInt, long paramLong);
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a().l();
  }
  
  public void c(IReadInJoyListItemLifeCycle paramIReadInJoyListItemLifeCycle)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramIReadInJoyListItemLifeCycle);
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().g(paramBoolean);
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().b();
  }
  
  public void d()
  {
    int k = 0;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoRecommendADVideoFeedsManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoRecommendADVideoFeedsManager.b();
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video_" + this.jdField_c_of_type_Int, 2, "ReadInJoyBaseAdapter doOnResume()");
    }
    if (ReadInJoyHelper.o()) {
      RIJReportDataCollectionManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getHeaderViewsCount(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager);
    }
    this.jdField_a_of_type_Boolean = true;
    if (Build.VERSION.SDK_INT < 21) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setFriction(jdField_a_of_type_Float);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJOnScrollListener.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, 4);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().c(false);
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount()) {
        break;
      }
      View localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i);
      if (((localView instanceof IReadInJoyLifeCycleView)) && (!((IReadInJoyLifeCycleView)localView).a()))
      {
        ((IReadInJoyLifeCycleView)localView).setIsResume(true);
        ((IReadInJoyLifeCycleView)localView).a();
      }
      i += 1;
    }
    while (j < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((IReadInJoyListItemLifeCycle)this.jdField_a_of_type_JavaUtilArrayList.get(j)).a();
      j += 1;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewIReadInJoyListItemLifeCycle != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewIReadInJoyListItemLifeCycle.a();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokShakeRIJShakeManager.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJProteusParserObserver.a();
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().d(paramBoolean);
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a();
  }
  
  public void e()
  {
    int k = 0;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoRecommendADVideoFeedsManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoRecommendADVideoFeedsManager.c();
    }
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video_" + this.jdField_c_of_type_Int, 2, "ReadInJoyBaseAdapter doOnPause()");
    }
    this.jdField_a_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a().a(a()) != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a().a(a()).isShowing())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a().a(a()).dismiss();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJOnScrollListener.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, 5);
    if ((!ReadInJoyHelper.t()) && (ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().a(), "default_feeds")))
    {
      QLog.d("ReadInJoyBaseAdapter", 2, "hasRefresh notifyDataSetChanged");
      notifyDataSetChanged();
    }
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount()) {
        break;
      }
      View localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i);
      if (((localView instanceof IReadInJoyLifeCycleView)) && (((IReadInJoyLifeCycleView)localView).a()))
      {
        ((IReadInJoyLifeCycleView)localView).setIsResume(false);
        ((IReadInJoyLifeCycleView)localView).b();
      }
      i += 1;
    }
    while (j < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((IReadInJoyListItemLifeCycle)this.jdField_a_of_type_JavaUtilArrayList.get(j)).b();
      j += 1;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewIReadInJoyListItemLifeCycle != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewIReadInJoyListItemLifeCycle.b();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokShakeRIJShakeManager.b();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJProteusParserObserver.b();
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a().b(paramBoolean);
  }
  
  public boolean e()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a().p();
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a().a() != null) && (ReadInJoyAdUtils.a(this.jdField_c_of_type_Int))) {
      f();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a(paramInt);
  }
  
  public int getItemViewType(int paramInt)
  {
    int j = a(paramInt);
    int i = j;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a().a(j, paramInt)) {
      i = 119;
    }
    return i;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TraceUtils.traceBegin("ReadInJoyBaseAdapter.getView");
    System.currentTimeMillis();
    a(b(paramInt), paramInt);
    BaseArticleInfo localBaseArticleInfo = b(paramInt);
    int i = getItemViewType(paramInt);
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a((ArticleInfo)localBaseArticleInfo, i, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "getView:  pos: " + paramInt + " " + localBaseArticleInfo + " type= " + i);
    }
    View localView = (View)HandlerFactory.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a(), new ReadInJoyBaseAdapter.1(this, "onAdapterGetView", i, localBaseArticleInfo, paramInt, paramView, paramViewGroup));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a(localView, paramView, localBaseArticleInfo, paramInt);
    if (localView != null)
    {
      RIJReportDataCollectionManager.a(localBaseArticleInfo, (IReadInJoyModel)localObject, System.currentTimeMillis(), paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager);
      localObject = super.a(localView, paramInt);
      RIJReportDataCollectionManager.a((View)localObject, i, localBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager);
      TextHook.updateFont(paramView);
      TraceUtils.traceEnd();
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
      QLog.d("ReadInJoyBaseAdapter", 1, "get view has error, return then convert view， viewType : " + i);
      localObject = paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusUtilsDynamicItemViewHelper.a() + 148 + PTSLiteItemViewBuilder.a();
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.c(7);
    }
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.b();
  }
  
  public boolean isEmpty()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingAccesslayerDataRIJDataManager.a().isEmpty();
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a().i();
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.g();
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof ReadInJoyFeedsActivity)) {
      ((ReadInJoyFeedsActivity)this.jdField_a_of_type_AndroidAppActivity).b(16);
    }
    ClickHandler localClickHandler = (ClickHandler)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramView.getId()));
    if (localClickHandler != null) {
      localClickHandler.onClick(paramView);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokClickRIJFrameworkHandleClick.a(paramView);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerVideoClickRIJVideoHandleClick.a(paramView);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a().onClick(paramView);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QLog.e("ReadInJoyBaseAdapter", 1, "onClick, has no click handler for id(" + paramView.getId() + "}");
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerVideoClickRIJVideoHandleClick.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter
 * JD-Core Version:    0.7.0.1
 */