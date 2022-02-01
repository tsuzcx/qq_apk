package com.tencent.biz.pubaccount.readinjoy.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyPageItemCache;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ListenerBuilder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.OnLastReadRefreshListener;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJInvokeHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJStatisticCollectorReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtReportHelper;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.handlers.HandlerFactory;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskVideoTimer;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.FeedsReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.VideoExtraRepoerData;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.BaseVideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.TopicShareHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFullPlayController.OnFullPlayListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.OnPlayStateListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.OnScreenChangeListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.OnUIChangeListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyArticleAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView.RefreshCallback;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyScreenShotReporter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.biz.webviewplugin.PubAccountPreloadPlugin;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyVideoSubChannelActivity
  extends FragmentActivity
  implements View.OnClickListener, OnLastReadRefreshListener, VideoFullPlayController.OnFullPlayListener, VideoPlayManager.OnPlayStateListener, VideoUIManager.OnScreenChangeListener, VideoUIManager.OnUIChangeListener, ReadInJoyBaseListView.RefreshCallback, AbsListView.OnScrollListener
{
  public int a;
  protected long a;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected ReadInJoyPageItemCache a;
  RIJInvokeHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler;
  protected ReadInJoyObserver a;
  private RIJRewardTaskVideoTimer jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskVideoTimer;
  private TopicShareHelper jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoTopicShareHelper;
  private VideoAutoPlayController jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController;
  private VideoPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager;
  private VideoUIManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager;
  private ReadInJoyBaseAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
  ReadInJoyXListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView;
  protected IFaceDecoder a;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private String jdField_a_of_type_JavaLangString;
  public Map<Integer, Boolean> a;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private int jdField_b_of_type_Int = -1;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private Map<Integer, Set<Long>> jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean = false;
  private int[] jdField_b_of_type_ArrayOfInt = new int[2];
  private int jdField_c_of_type_Int = -1;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private Map<Integer, Map<Long, BaseReportData>> jdField_c_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 1;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean = false;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean = false;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private boolean jdField_f_of_type_Boolean = false;
  private TextView g;
  
  public ReadInJoyVideoSubChannelActivity()
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new ReadInJoyVideoSubChannelActivity.VideoSubChannelObserver(this, null);
  }
  
  private int a()
  {
    if (this.jdField_b_of_type_Int != -1) {
      return this.jdField_b_of_type_Int;
    }
    return getIntent().getIntExtra("channel_id", 0);
  }
  
  private Context a()
  {
    return this;
  }
  
  private Intent a(ChannelInfo paramChannelInfo)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_flag_from_plugin", true);
    localIntent.putExtra("forward_type", -3);
    localIntent.putExtra("struct_share_key_source_icon", "https://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png");
    localIntent.putExtra("struct_share_key_source_a_action_data", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
    localIntent.putExtra("struct_share_key_source_i_action_data", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
    localIntent.putExtra("struct_share_key_source_action", "plugin");
    localIntent.putExtra("app_name", "QQ看点");
    localIntent.putExtra("detail_url", TopicShareHelper.a(paramChannelInfo, 0));
    localIntent.putExtra("title", "「" + paramChannelInfo.mChannelName + HardCodeUtil.a(2131712998));
    localIntent.putExtra("desc", paramChannelInfo.mFollowNum + HardCodeUtil.a(2131713054));
    localIntent.putExtra("image_url_remote", paramChannelInfo.mHeaderPicUrl);
    localIntent.putExtra("req_type", 1);
    localIntent.putExtra("pluginName", "web_share");
    localIntent.putExtra("struct_share_key_content_action", "web");
    paramChannelInfo = StructMsgFactory.a(localIntent.getExtras());
    paramChannelInfo.mMsgServiceID = 83;
    localIntent.putExtra("stuctmsg_bytes", paramChannelInfo.getBytes());
    return localIntent;
  }
  
  private String a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return this.jdField_a_of_type_JavaLangString;
    }
    return getIntent().getStringExtra("channel_name");
  }
  
  private Map<Long, BaseReportData> a(Integer paramInteger)
  {
    Map localMap = (Map)this.jdField_c_of_type_JavaUtilMap.get(paramInteger);
    Object localObject = localMap;
    if (localMap == null)
    {
      localObject = new HashMap();
      this.jdField_c_of_type_JavaUtilMap.put(paramInteger, localObject);
    }
    return localObject;
  }
  
  private void a(ChannelInfo paramChannelInfo)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.create(this);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(HardCodeUtil.a(2131712796), 3);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(HardCodeUtil.a(2131712715));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new ReadInJoyVideoSubChannelActivity.7(this, paramChannelInfo));
  }
  
  private void a(ChannelInfo paramChannelInfo, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.SubChannelActivity", 2, "doFollowUnFollow(): isFollow =" + paramBoolean);
    }
    paramChannelInfo.mIsFollowed = paramBoolean;
    d(paramChannelInfo.mIsFollowed);
    ReadInJoyLogicEngine.a().a(paramChannelInfo);
    ReadInJoyLogicEngine.a().a(paramBoolean, 56, paramChannelInfo.mChannelID);
    ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.8(this, paramChannelInfo, paramBoolean));
  }
  
  private void a(ListView paramListView)
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      View localView = LayoutInflater.from(a()).inflate(2131560495, paramListView, false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131368375));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131368372));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131368366));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131368373));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131368365));
      this.jdField_c_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      this.jdField_d_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
      paramListView.addHeaderView(localView);
    }
  }
  
  private void a(String paramString)
  {
    findViewById(2131374174).setVisibility(8);
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = ((ViewStub)findViewById(2131372189)).inflate();
      this.g = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376550));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376549));
    }
    this.g.setText(paramString);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setEmptyView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.jdField_a_of_type_Long = System.currentTimeMillis();
    ReadInJoyHelper.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.jdField_a_of_type_Long, (QQAppInterface)ReadInJoyUtils.a());
    Object localObject2 = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.d(paramBoolean);
    }
    int j = -1;
    Object localObject1 = localObject2;
    int i = j;
    if (c() == 5)
    {
      Object localObject3 = (ReadInJoyChannelActivity.SerializableMap)getIntent().getSerializableExtra("channel_map_data");
      localObject1 = localObject2;
      i = j;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        i = j;
        if (((ReadInJoyChannelActivity.SerializableMap)localObject3).getMap() != null)
        {
          localObject3 = ((ReadInJoyChannelActivity.SerializableMap)localObject3).getMap();
          Long localLong = (Long)((Map)localObject3).get("param_key_insert_article_id");
          localObject1 = localObject2;
          i = j;
          if (localLong != null)
          {
            localObject1 = new ArrayList();
            ((List)localObject1).add(localLong);
            i = 5;
            ((Map)localObject3).remove("param_key_insert_article_id");
          }
        }
      }
    }
    ReadInJoyLogicEngine.a().a(this.jdField_b_of_type_Int, (List)localObject1, i, true, false, this.jdField_d_of_type_Int, null, -1L, null, b(), 0L, 0L, null, paramInt, false, null, 0);
    this.jdField_d_of_type_Int += 1;
    ReadinjoyReportUtils.a(paramInt, this.jdField_b_of_type_Int, this, -this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getScrollY());
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0)
      {
        if (!paramBoolean2) {
          break label31;
        }
        VideoFeedsHelper.a(this.jdField_b_of_type_AndroidWidgetTextView, 0, 300);
      }
    }
    label31:
    while (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0)
    {
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    if (paramBoolean2)
    {
      VideoFeedsHelper.a(this.jdField_b_of_type_AndroidWidgetTextView, 4, 300);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  private boolean a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.a()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.c(paramInt);
      return true;
    }
    return false;
  }
  
  private boolean a(Integer paramInteger)
  {
    paramInteger = (Boolean)this.jdField_a_of_type_JavaUtilMap.get(paramInteger);
    if (paramInteger != null) {
      return paramInteger.booleanValue();
    }
    return false;
  }
  
  private boolean a(boolean paramBoolean)
  {
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.getCount() == 0)
    {
      bool1 = true;
      if ((!bool1) && (!paramBoolean)) {
        break label77;
      }
    }
    label77:
    for (boolean bool2 = true;; bool2 = false)
    {
      QLog.d("Q.readinjoy.video.SubChannelActivity", 1, String.format("loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, isFristLoadFromDB=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(paramBoolean) }));
      if (bool2) {
        a(false, 1);
      }
      return bool2;
      bool1 = false;
      break;
    }
  }
  
  private int b()
  {
    return 3;
  }
  
  private void b(ChannelInfo paramChannelInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == 0) {
      break label7;
    }
    label7:
    while (paramChannelInfo == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.SubChannelActivity", 2, "updateHeaderUI(): fromServer = " + paramBoolean + ", channelInfo = " + paramChannelInfo.toString());
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setText(a());
    this.jdField_b_of_type_AndroidWidgetTextView.setText(a());
    if (this.jdField_f_of_type_AndroidWidgetTextView != null)
    {
      if (paramChannelInfo.mFollowNum <= 0) {
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    else {
      label103:
      if (this.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        if (!paramChannelInfo.mIsTopic) {
          break label202;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    for (;;)
    {
      d(paramChannelInfo.mIsFollowed);
      if (this.jdField_e_of_type_Boolean) {
        break;
      }
      this.jdField_e_of_type_Boolean = true;
      ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.9(this, paramChannelInfo));
      return;
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(paramChannelInfo.mFollowNum + HardCodeUtil.a(2131712768));
      break label103;
      label202:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private void b(Map<Long, BaseReportData> paramMap, boolean paramBoolean)
  {
    if ((paramMap == null) || (paramMap.values() == null) || (!paramBoolean)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      paramMap = paramMap.values().iterator();
      for (;;)
      {
        if (paramMap.hasNext())
        {
          BaseReportData localBaseReportData = (BaseReportData)paramMap.next();
          if (localBaseReportData.jdField_a_of_type_Boolean) {
            continue;
          }
          localBaseReportData.jdField_a_of_type_Boolean = true;
          if (localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) {
            continue;
          }
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80066FC", "0X80066FC", 0, 0, "", Long.toString(localBaseReportData.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localBaseReportData.jdField_b_of_type_Int), RIJTransMergeKanDianReport.a(localBaseReportData.jdField_a_of_type_Long, localBaseReportData.jdField_c_of_type_Int, this.jdField_b_of_type_Int, localBaseReportData.jdField_d_of_type_Int), false);
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X80066FC", "", "", Long.toString(localBaseReportData.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localBaseReportData.jdField_b_of_type_Int), RIJTransMergeKanDianReport.a(localBaseReportData.jdField_a_of_type_Long, localBaseReportData.jdField_c_of_type_Int, this.jdField_b_of_type_Int, localBaseReportData.jdField_d_of_type_Int));
          if (RIJItemViewType.i(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
          {
            int i = 0;
            while (i < localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTopicRecommendFeedsInfo.a.size())
            {
              ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, localBaseReportData.jdField_d_of_type_JavaLangString, "0X8007626", "0X8007626", 0, 0, Long.toString(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), ((TopicRecommendFeedsInfo.TopicRecommendInfo)localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTopicRecommendFeedsInfo.a.get(i)).jdField_a_of_type_Int + "", Integer.toString(localBaseReportData.jdField_b_of_type_Int), RIJTransMergeKanDianReport.a(localBaseReportData.jdField_a_of_type_Long, localBaseReportData.jdField_c_of_type_Int, this.jdField_b_of_type_Int, localBaseReportData.jdField_d_of_type_Int, localBaseReportData.jdField_e_of_type_Int, NetworkUtil.h(a()), localBaseReportData.jdField_a_of_type_JavaLangString, localBaseReportData.jdField_c_of_type_JavaLangString, localBaseReportData.jdField_e_of_type_JavaLangString, RIJFeedsType.d(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, 0L, -1, localBaseReportData.jdField_f_of_type_Int, localBaseReportData.g, localBaseReportData.h, localBaseReportData.jdField_f_of_type_Boolean, localBaseReportData.j, localBaseReportData.i, localBaseReportData.m), false);
              i += 1;
            }
          }
          Object localObject1 = new VideoR5.Builder(RIJTransMergeKanDianReport.a(localBaseReportData.jdField_a_of_type_Long, localBaseReportData.jdField_c_of_type_Int, this.jdField_b_of_type_Int, localBaseReportData.jdField_d_of_type_Int, localBaseReportData.jdField_e_of_type_Int, NetworkUtil.h(a()), localBaseReportData.jdField_a_of_type_JavaLangString, localBaseReportData.jdField_c_of_type_JavaLangString, localBaseReportData.jdField_e_of_type_JavaLangString, RIJFeedsType.d(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, 0L, -1, localBaseReportData.jdField_f_of_type_Int, localBaseReportData.g, localBaseReportData.h, localBaseReportData.jdField_f_of_type_Boolean, localBaseReportData.j, localBaseReportData.i, localBaseReportData.m)).a(localBaseReportData.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).N(c()).b(localBaseReportData.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).f(localBaseReportData.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).a().a();
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", localBaseReportData.jdField_d_of_type_JavaLangString, "0X8007626", "0X8007626", 0, 0, Long.toString(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(localBaseReportData.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localBaseReportData.jdField_b_of_type_Int), (String)localObject1, false);
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8007626", localBaseReportData.jdField_d_of_type_JavaLangString, Long.toString(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(localBaseReportData.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localBaseReportData.jdField_b_of_type_Int), RIJTransMergeKanDianReport.a(localBaseReportData.jdField_a_of_type_Long, localBaseReportData.jdField_c_of_type_Int, this.jdField_b_of_type_Int, localBaseReportData.jdField_d_of_type_Int, localBaseReportData.jdField_e_of_type_Int, NetworkUtil.h(a()), localBaseReportData.jdField_a_of_type_JavaLangString, localBaseReportData.jdField_c_of_type_JavaLangString, localBaseReportData.jdField_e_of_type_JavaLangString, RIJFeedsType.d(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, 0L, -1, localBaseReportData.jdField_f_of_type_Int, localBaseReportData.g, localBaseReportData.h, localBaseReportData.jdField_f_of_type_Boolean, localBaseReportData.j, localBaseReportData.i, localBaseReportData.m));
          localObject1 = new ReportInfo();
          ((ReportInfo)localObject1).mUin = ReadInJoyUtils.a();
          ((ReportInfo)localObject1).mSource = 0;
          ((ReportInfo)localObject1).mSourceArticleId = localBaseReportData.jdField_a_of_type_JavaLangLong.longValue();
          ((ReportInfo)localObject1).mChannelId = this.jdField_b_of_type_Int;
          ((ReportInfo)localObject1).mAlgorithmId = ((int)localBaseReportData.jdField_a_of_type_Long);
          ((ReportInfo)localObject1).mStrategyId = localBaseReportData.jdField_b_of_type_Int;
          ((ReportInfo)localObject1).mOperation = 7;
          ((ReportInfo)localObject1).mServerContext = localBaseReportData.jdField_a_of_type_ArrayOfByte;
          ((ReportInfo)localObject1).mReadTimeLength = -1;
          ((ReportInfo)localObject1).mInnerId = localBaseReportData.jdField_e_of_type_JavaLangString;
          if (localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo != null) {
            ((ReportInfo)localObject1).mColumnID = localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int;
          }
          Object localObject2;
          if (localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo != null)
          {
            localObject2 = new ReportInfo.FeedsReportData();
            ((ReportInfo.FeedsReportData)localObject2).jdField_a_of_type_Long = localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
            if (localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null) {
              ((ReportInfo.FeedsReportData)localObject2).jdField_b_of_type_Long = localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
            }
            ((ReportInfo.FeedsReportData)localObject2).jdField_a_of_type_Int = localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
            ((ReportInfo.FeedsReportData)localObject2).jdField_b_of_type_Int = localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
            Object localObject3 = localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
            if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
            {
              ((ReportInfo.FeedsReportData)localObject2).jdField_a_of_type_JavaUtilList = new ArrayList();
              localObject3 = ((List)localObject3).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                SocializeFeedsInfo.FeedsInfoUser localFeedsInfoUser = (SocializeFeedsInfo.FeedsInfoUser)((Iterator)localObject3).next();
                if (localFeedsInfoUser != null) {
                  ((ReportInfo.FeedsReportData)localObject2).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localFeedsInfoUser.jdField_a_of_type_Long));
                }
              }
            }
            ((ReportInfo)localObject1).mFeedsReportData = ((ReportInfo.FeedsReportData)localObject2);
          }
          localArrayList.add(localObject1);
          if (localBaseReportData.jdField_c_of_type_Boolean) {}
          try
          {
            if (localBaseReportData.jdField_d_of_type_Boolean)
            {
              localObject2 = RIJTransMergeKanDianReport.a();
              ((JSONObject)localObject2).put("feeds_source", localBaseReportData.jdField_a_of_type_JavaLangString);
              ((JSONObject)localObject2).put("kandian_mode", RIJAppSetting.a());
              ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X800744E", "0X800744E", 0, 0, RIJFeedsType.c(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), "", "", ((JSONObject)localObject2).toString(), false);
            }
            if (this.jdField_b_of_type_Int == 56)
            {
              ((ReportInfo)localObject1).mOpSource = 11;
              localObject2 = new ReportInfo.VideoExtraRepoerData();
              ((ReportInfo.VideoExtraRepoerData)localObject2).jdField_c_of_type_Int = 1;
              localObject2 = ((ReportInfo.VideoExtraRepoerData)localObject2).toString();
              ((ReportInfo)localObject1).mInnerId = localBaseReportData.jdField_e_of_type_JavaLangString;
              if (QLog.isColorLevel()) {
                QLog.d("VideoReporter", 2, "reportVideoUserOperationByOidbOfFeed subchannel--mUin:" + ((ReportInfo)localObject1).mUin + "; mSource:" + ((ReportInfo)localObject1).mSource + "; mOpSource:" + ((ReportInfo)localObject1).mOpSource + "; mInnerId:" + ((ReportInfo)localObject1).mInnerId + "; mChannelId:" + ((ReportInfo)localObject1).mChannelId + "; mAlgorithmId:" + ((ReportInfo)localObject1).mAlgorithmId + "; mStrategyId:" + ((ReportInfo)localObject1).mStrategyId + "; mOperation:" + ((ReportInfo)localObject1).mOperation + "; mPlayTimeLength:" + ((ReportInfo)localObject1).mPlayTimeLength + "; videoExtraRepoerData:" + (String)localObject2);
              }
            }
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      }
    } while (localArrayList.isEmpty());
    ReadInJoyLogicEngine.a().a(localArrayList);
  }
  
  private void b(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.h();
    if ((paramBoolean) && (paramInt > 0)) {}
    for (String str = String.format(getResources().getString(2131718094), new Object[] { Integer.valueOf(paramInt) });; str = getResources().getString(2131718093))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(true, str);
      return;
    }
  }
  
  private int c()
  {
    return getIntent().getIntExtra("channel_from", -1);
  }
  
  private void c(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Long != 0L) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a().size() > 0)) {
      RIJStatisticCollectorReport.a(a(), (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(), (BaseArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a().get(0), paramBoolean);
    }
  }
  
  private void d()
  {
    this.jdField_b_of_type_Int = a();
    this.jdField_c_of_type_Int = b();
    this.jdField_a_of_type_JavaLangString = a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager = new VideoPlayManager(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache = new ReadInJoyPageItemCache();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.jdField_a_of_type_Long = ReadInJoyHelper.a(a(), (QQAppInterface)ReadInJoyUtils.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController = VideoAutoPlayController.a();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
    ReadInJoyChannelActivity.SerializableMap localSerializableMap = (ReadInJoyChannelActivity.SerializableMap)getIntent().getSerializableExtra("channel_map_data");
    if ((localSerializableMap != null) && (localSerializableMap.getMap() != null)) {
      this.jdField_a_of_type_Int = ((Integer)localSerializableMap.getMap().get("param_key_channel_column_type")).intValue();
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.jdField_e_of_type_AndroidWidgetTextView != null)
    {
      if (paramBoolean)
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131712925));
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-9211021);
        this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundResource(2130843203);
        this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      }
    }
    else {
      return;
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131713005));
    this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundResource(2130843196);
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-1);
  }
  
  private void e()
  {
    g();
    h();
    f();
    ChannelInfo localChannelInfo = ReadInJoyLogicEngine.a().a(a());
    if (localChannelInfo != null) {
      b(localChannelInfo, false);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager = new VideoUIManager((FrameLayout)findViewById(2131381485), (ReadInJoyBaseListView)findViewById(2131370504), this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(c());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskVideoTimer = new RIJRewardTaskVideoTimer();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskVideoTimer.a(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    View localView = findViewById(2131374174);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setEmptyView(localView);
    localView.setOnClickListener(null);
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131379544));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379470));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379529));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379518));
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(a());
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = ((ReadInJoyXListView)findViewById(2131370504));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setChannelId(a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setRefreshCallback(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(this);
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter = new ReadInJoyArticleAdapter(this, getLayoutInflater(), a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.b(b());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.c();
    ListenerBuilder localListenerBuilder = new ListenerBuilder().a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(localListenerBuilder);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a(findViewById(16908290), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, c());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController);
  }
  
  private void i()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_AndroidViewViewGroup == null) || (this.jdField_d_of_type_AndroidWidgetTextView == null)) {}
    label143:
    for (;;)
    {
      return;
      this.jdField_d_of_type_AndroidWidgetTextView.getLocationOnScreen(this.jdField_b_of_type_ArrayOfInt);
      this.jdField_a_of_type_AndroidViewViewGroup.getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
      int i = this.jdField_b_of_type_ArrayOfInt[1] + this.jdField_d_of_type_AndroidWidgetTextView.getHeight();
      int j = this.jdField_a_of_type_ArrayOfInt[1] + this.jdField_a_of_type_AndroidViewViewGroup.getHeight();
      if ((i != 0) && (j != 0))
      {
        if (i <= j) {}
        for (;;)
        {
          if (bool == this.jdField_a_of_type_Boolean) {
            break label143;
          }
          this.jdField_a_of_type_Boolean = bool;
          a(this.jdField_a_of_type_Boolean);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.readinjoy.video.SubChannelActivity", 2, "checkIsTopFixed(): mFixed=" + this.jdField_a_of_type_Boolean);
          return;
          bool = false;
        }
      }
    }
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a() != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(ReportConstants.VideoEndType.EXIT_SCENE);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b(11);
    }
  }
  
  public Set<Long> a(Integer paramInteger)
  {
    Set localSet = (Set)this.jdField_b_of_type_JavaUtilMap.get(paramInteger);
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new HashSet();
      this.jdField_b_of_type_JavaUtilMap.put(paramInteger, localObject);
    }
    return localObject;
  }
  
  public void a()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      this.mSystemBarComp.init();
      if (!ThemeUtil.isInNightMode(this.app)) {
        break label104;
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
    label104:
    if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
    {
      getWindow().getDecorView().setSystemUiVisibility(9216);
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
  
  public void a(BaseVideoPlayParam paramBaseVideoPlayParam1, BaseVideoPlayParam paramBaseVideoPlayParam2, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyBaseAdapter", 2, "onNextVideoPlay:  enterVideoPlayParam:" + paramBaseVideoPlayParam1 + "  nextVideoPlayParam:" + paramBaseVideoPlayParam2 + "\n nextScrollByDistance:" + paramInt + " isPlayFirstNext:" + paramBoolean);
    }
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter;
    if ((paramBaseVideoPlayParam1 != null) && ((paramBaseVideoPlayParam1 instanceof VideoPlayManager.VideoPlayParam)) && (paramBaseVideoPlayParam2 != null) && ((paramBaseVideoPlayParam2 instanceof VideoPlayManager.VideoPlayParam)))
    {
      paramBaseVideoPlayParam1 = ((VideoPlayManager.VideoPlayParam)paramBaseVideoPlayParam1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      paramBaseVideoPlayParam2 = ((VideoPlayManager.VideoPlayParam)paramBaseVideoPlayParam2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((paramBaseVideoPlayParam1 != null) && (paramBaseVideoPlayParam2 != null))
      {
        localReadInJoyBaseAdapter = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
        if (paramBoolean) {
          break label134;
        }
      }
    }
    label134:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localReadInJoyBaseAdapter.a(paramBaseVideoPlayParam1, paramBaseVideoPlayParam2, paramBoolean);
      return;
    }
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt1, int paramInt2) {}
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam1, VideoPlayManager.VideoPlayParam paramVideoPlayParam2)
  {
    b(false);
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt1, int paramInt2, Object paramObject) {}
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    if (paramInt != 0) {}
    a(true, 3);
    ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.2(this));
  }
  
  public void a(List<Long> paramList)
  {
    if (!PreloadManager.a().a()) {}
    for (;;)
    {
      return;
      PreloadManager.a().e();
      int j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a();
      if ((paramList != null) && (paramList.size() >= 5))
      {
        int i = 0;
        while (i < 5)
        {
          long l = ((Long)paramList.get(i)).longValue();
          Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(j, l);
          if ((localObject != null) && (!RIJFeedsType.a((BaseArticleInfo)localObject)) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(j, ((BaseArticleInfo)localObject).mArticleID)))
          {
            localObject = ((BaseArticleInfo)localObject).mArticleContentUrl;
            if (PubAccountPreloadPlugin.a((String)localObject)) {
              PreloadManager.a().a((String)localObject);
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public void a(List<Long> paramList, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(ReadInJoyLogicEngine.a().a(Integer.valueOf(this.jdField_b_of_type_Int), paramList));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.notifyDataSetChanged();
  }
  
  public void a(Map<Long, BaseReportData> paramMap, boolean paramBoolean)
  {
    b(paramMap, paramBoolean);
    ReadInJoyDisplayUtils.a();
    ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.a(), System.currentTimeMillis(), this.jdField_b_of_type_Int);
    getIntent().putExtra("from_search", false);
  }
  
  public void a(Set<Long> paramSet, Map<Long, BaseReportData> paramMap)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(paramSet, paramMap);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.d = ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.a(), this.jdField_b_of_type_Int);
    ReadInJoyLogicEngine.a().a(this.jdField_b_of_type_Int, 20, 9223372036854775807L, true);
    ReadInJoyLogicEngine.a().b(56, 3, a());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(this.jdField_b_of_type_Int), Boolean.valueOf(true));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    a(paramBoolean, true);
  }
  
  public void b() {}
  
  public void b(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    if (paramInt == 4) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      ReadInJoyLogicEngine.a().a(this.jdField_b_of_type_Int, b(), paramInt, 0, 1);
      ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.3(this));
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setVisibility(4);
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setVisibility(0);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.f();
    k();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.SubChannelActivity", 2, "doOnActivityResult(): requestCode = " + paramInt1 + ", resultCode = " + paramInt2);
    }
    if (paramInt1 == 103) {
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      if (!paramIntent.getBooleanExtra("bFailed", false)) {
        i = 1;
      }
      QQToast localQQToast = new QQToast(this);
      localQQToast.d(2000);
      if (i != 0)
      {
        localQQToast.a(QQToast.a(2));
        localQQToast.c(2131692259);
        localQQToast.b(getApplicationContext().getResources().getDimensionPixelSize(2131299166) - (int)DisplayUtils.a(getApplicationContext(), 5.0F));
      }
      else
      {
        localQQToast.a(QQToast.a(1));
        localQQToast.c(2131692260);
        localQQToast.b(getApplicationContext().getResources().getDimensionPixelSize(2131299166) - (int)DisplayUtils.a(getApplicationContext(), 5.0F));
        continue;
        if (paramInt1 == 9091) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(0, paramIntent);
        } else if ((paramInt1 == 21) && (paramInt2 == -1)) {
          ForwardUtils.a((QQAppInterface)ReadInJoyUtils.a(), this, getApplicationContext(), paramIntent, null);
        }
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    RIJDtReportHelper.a.a(getActivity());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler = new RIJInvokeHandler();
    SparseArray localSparseArray = new SparseArray();
    localSparseArray.put(0, HandlerFactory.a(0));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokRIJInvokeHandler.a(localSparseArray);
    VideoVolumeControl.a().a(this);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    getWindow().setBackgroundDrawable(null);
    setContentView(2131560494);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131379546));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFitsSystemWindows(true);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    super.doOnCreate(paramBundle);
    d();
    e();
    a(a(Integer.valueOf(a())), a(Integer.valueOf(a())));
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_Long = 0L;
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    VideoVolumeControl.a().b(this);
    a(a(Integer.valueOf(a())), a(Integer.valueOf(a())));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.d();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.b();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a();
    }
    this.jdField_b_of_type_JavaUtilMap.clear();
    this.jdField_c_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
    ReadInJoyScreenShotReporter.a(this).b();
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramInt == 25) {
      bool1 = a(-1);
    }
    for (;;)
    {
      if (!bool1)
      {
        bool1 = bool2;
        if (!super.doOnKeyDown(paramInt, paramKeyEvent)) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
      if (paramInt == 24) {
        bool1 = a(1);
      } else {
        bool1 = false;
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.e();
    ReadInJoyScreenShotReporter.a(this).a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.e();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskVideoTimer != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskVideoTimer.b();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.d(a());
    ReadInJoyScreenShotReporter.a(this).a(b(), a());
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.d();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskVideoTimer != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRewardRIJRewardTaskVideoTimer.a();
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.notifyDataSetChanged();
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler))) {
      ((FlingGestureHandler)this.mFlingHandler).mTopLayout.setOnFlingGesture(new ReadInJoyVideoSubChannelActivity.1(this));
    }
  }
  
  public void doOnStop()
  {
    VideoVolumeControl.a().a(false, "videoSubChannel onStop");
    super.doOnStop();
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a() != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a().j();
    }
  }
  
  public boolean onBackEvent()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager;
    if ((localObject != null) && (((VideoPlayManager)localObject).a() != null))
    {
      localObject = ((VideoPlayManager)localObject).a();
      if (((VideoUIManager)localObject).a())
      {
        ((VideoUIManager)localObject).j();
        return true;
      }
    }
    c(false);
    finish();
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      finish();
      continue;
      f();
      a(true, 3);
      ReadInJoyLogicEngine.a().b(56, 3, a());
      continue;
      if (!HttpUtil.isConnect(this))
      {
        QQToast.a(this, HardCodeUtil.a(2131712742), 0).a();
      }
      else
      {
        this.jdField_d_of_type_Boolean = true;
        ChannelInfo localChannelInfo = ReadInJoyLogicEngine.a().a(a());
        if (localChannelInfo != null) {
          if (localChannelInfo.mIsFollowed)
          {
            a(localChannelInfo);
          }
          else
          {
            a(localChannelInfo, true);
            continue;
            if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int == 0))
            {
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.f();
              ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.4(this));
              continue;
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.f();
              ThreadManager.executeOnSubThread(new ReadInJoyVideoSubChannelActivity.5(this));
              continue;
              if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b())
              {
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
                this.jdField_f_of_type_Boolean = true;
              }
              if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoTopicShareHelper == null) {
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoTopicShareHelper = new TopicShareHelper(this);
              }
              localChannelInfo = ReadInJoyLogicEngine.a().a(a());
              if (localChannelInfo != null)
              {
                localChannelInfo = localChannelInfo.clone();
                if (localChannelInfo != null)
                {
                  if (TextUtils.isEmpty(localChannelInfo.mChannelName)) {
                    localChannelInfo.mChannelName = a();
                  }
                  this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoTopicShareHelper.a(localChannelInfo, a(localChannelInfo), new ReadInJoyVideoSubChannelActivity.6(this));
                }
              }
            }
          }
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Int != 0) {
      i();
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_Int != 0) {
      i();
    }
  }
  
  public void p()
  {
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyVideoSubChannelActivity
 * JD-Core Version:    0.7.0.1
 */