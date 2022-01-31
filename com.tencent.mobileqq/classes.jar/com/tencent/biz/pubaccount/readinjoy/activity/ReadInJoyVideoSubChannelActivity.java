package com.tencent.biz.pubaccount.readinjoy.activity;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
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
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyPageItemCache;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
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
import com.tencent.biz.pubaccount.readinjoy.video.TopicShareHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoBrightnessControl;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.OnScreenChangeListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyArticleAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView.RefreshCallback;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyScreenShotReporter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.webviewplugin.PubAccountPreloadPlugin;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
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
import lfh;
import lfi;
import lfj;
import lfk;
import lfl;
import lfm;
import lfn;
import lfo;
import lfp;
import lfq;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyVideoSubChannelActivity
  extends FragmentActivity
  implements View.OnClickListener, VideoUIManager.OnScreenChangeListener, ReadInJoyBaseListView.RefreshCallback, AbsListView.OnScrollListener
{
  public int a;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public ReadInJoyPageItemCache a;
  protected ReadInJoyObserver a;
  private TopicShareHelper jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoTopicShareHelper;
  private VideoAutoPlayController jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController;
  private VideoPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager;
  private ReadInJoyBaseAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
  public ReadInJoyXListView a;
  protected FaceDecoder a;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private Runnable jdField_a_of_type_JavaLangRunnable = new lfo(this);
  private String jdField_a_of_type_JavaLangString;
  public Map a;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private int jdField_b_of_type_Int = -1;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private Map jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean;
  private int[] jdField_b_of_type_ArrayOfInt = new int[2];
  private int jdField_c_of_type_Int = -1;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private Map jdField_c_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 1;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private boolean jdField_f_of_type_Boolean;
  private TextView g;
  
  public ReadInJoyVideoSubChannelActivity()
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new lfq(this);
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
    localIntent.putExtra("struct_share_key_source_icon", "https://q.url.cn/s/jBJuV");
    localIntent.putExtra("struct_share_key_source_a_action_data", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
    localIntent.putExtra("struct_share_key_source_i_action_data", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
    localIntent.putExtra("struct_share_key_source_action", "plugin");
    localIntent.putExtra("app_name", "QQ看点");
    localIntent.putExtra("detail_url", TopicShareHelper.a(paramChannelInfo, 0));
    localIntent.putExtra("title", "「" + paramChannelInfo.mChannelName + "」，一大波看点精彩视频来袭 ~  ");
    localIntent.putExtra("desc", paramChannelInfo.mFollowNum + "人正在关注，快来戳我啊~ ");
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
  
  private Map a(Integer paramInteger)
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
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a("取消关注", 3);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.d("取消");
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new lfm(this, paramChannelInfo));
  }
  
  private void a(ChannelInfo paramChannelInfo, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.SubChannelActivity", 2, "doFollowUnFollow(): isFollow =" + paramBoolean);
    }
    paramChannelInfo.mIsFollowed = paramBoolean;
    c(paramChannelInfo.mIsFollowed);
    ReadInJoyLogicEngine.a().a(paramChannelInfo);
    ReadInJoyLogicEngine.a().a(paramBoolean, 56, paramChannelInfo.mChannelID);
    ThreadManager.executeOnSubThread(new lfn(this, paramChannelInfo, paramBoolean));
  }
  
  private void a(ListView paramListView)
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      View localView = LayoutInflater.from(a()).inflate(2130969673, paramListView, false);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131367399));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367401));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367404));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367402));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367403));
      this.jdField_c_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      this.jdField_d_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
      paramListView.addHeaderView(localView);
    }
  }
  
  private void a(String paramString)
  {
    findViewById(2131367048).setVisibility(8);
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = ((ViewStub)findViewById(2131367270)).inflate();
      this.g = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367175));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367174));
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(paramBoolean);
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
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0)
      {
        if (!paramBoolean2) {
          break label30;
        }
        VideoFeedsHelper.a(this.jdField_b_of_type_AndroidWidgetTextView, 0, 300);
      }
    }
    label30:
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
          break label199;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    for (;;)
    {
      c(paramChannelInfo.mIsFollowed);
      if (this.jdField_e_of_type_Boolean) {
        break;
      }
      this.jdField_e_of_type_Boolean = true;
      ThreadManager.executeOnSubThread(new lfi(this, paramChannelInfo));
      return;
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(paramChannelInfo.mFollowNum + "人正在关注");
      break label103;
      label199:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private void b(Map paramMap, boolean paramBoolean)
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
          PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80066FC", "0X80066FC", 0, 0, "", Long.toString(localBaseReportData.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localBaseReportData.jdField_b_of_type_Int), ReadInJoyUtils.a(localBaseReportData.jdField_a_of_type_Long, localBaseReportData.jdField_c_of_type_Int, this.jdField_b_of_type_Int, localBaseReportData.jdField_d_of_type_Int), false);
          PublicAccountReportUtils.a("0X80066FC", "", "", Long.toString(localBaseReportData.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localBaseReportData.jdField_b_of_type_Int), ReadInJoyUtils.a(localBaseReportData.jdField_a_of_type_Long, localBaseReportData.jdField_c_of_type_Int, this.jdField_b_of_type_Int, localBaseReportData.jdField_d_of_type_Int));
          if (ReadInJoyBaseAdapter.b(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
          {
            int i = 0;
            while (i < localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTopicRecommendFeedsInfo.a.size())
            {
              PublicAccountReportUtils.a(null, localBaseReportData.jdField_d_of_type_JavaLangString, "0X8007626", "0X8007626", 0, 0, Long.toString(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), ((TopicRecommendFeedsInfo.TopicRecommendInfo)localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTopicRecommendFeedsInfo.a.get(i)).jdField_a_of_type_Int + "", Integer.toString(localBaseReportData.jdField_b_of_type_Int), ReadInJoyUtils.a(localBaseReportData.jdField_a_of_type_Long, localBaseReportData.jdField_c_of_type_Int, this.jdField_b_of_type_Int, localBaseReportData.jdField_d_of_type_Int, localBaseReportData.jdField_e_of_type_Int, NetworkUtil.h(a()), localBaseReportData.jdField_a_of_type_JavaLangString, localBaseReportData.jdField_c_of_type_JavaLangString, localBaseReportData.jdField_e_of_type_JavaLangString, ReadInJoyUtils.c(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, 0L, -1, localBaseReportData.jdField_f_of_type_Int, localBaseReportData.g, localBaseReportData.h, localBaseReportData.jdField_f_of_type_Boolean, localBaseReportData.j, localBaseReportData.i), false);
              i += 1;
            }
          }
          PublicAccountReportUtils.a(null, "CliOper", "", localBaseReportData.jdField_d_of_type_JavaLangString, "0X8007626", "0X8007626", 0, 0, Long.toString(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(localBaseReportData.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localBaseReportData.jdField_b_of_type_Int), ReadInJoyUtils.a(localBaseReportData.jdField_a_of_type_Long, localBaseReportData.jdField_c_of_type_Int, this.jdField_b_of_type_Int, localBaseReportData.jdField_d_of_type_Int, localBaseReportData.jdField_e_of_type_Int, NetworkUtil.h(a()), localBaseReportData.jdField_a_of_type_JavaLangString, localBaseReportData.jdField_c_of_type_JavaLangString, localBaseReportData.jdField_e_of_type_JavaLangString, ReadInJoyUtils.c(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, 0L, -1, localBaseReportData.jdField_f_of_type_Int, localBaseReportData.g, localBaseReportData.h, localBaseReportData.jdField_f_of_type_Boolean, localBaseReportData.j, localBaseReportData.i), false);
          PublicAccountReportUtils.a("0X8007626", localBaseReportData.jdField_d_of_type_JavaLangString, Long.toString(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(localBaseReportData.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localBaseReportData.jdField_b_of_type_Int), ReadInJoyUtils.a(localBaseReportData.jdField_a_of_type_Long, localBaseReportData.jdField_c_of_type_Int, this.jdField_b_of_type_Int, localBaseReportData.jdField_d_of_type_Int, localBaseReportData.jdField_e_of_type_Int, NetworkUtil.h(a()), localBaseReportData.jdField_a_of_type_JavaLangString, localBaseReportData.jdField_c_of_type_JavaLangString, localBaseReportData.jdField_e_of_type_JavaLangString, ReadInJoyUtils.c(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, 0L, -1, localBaseReportData.jdField_f_of_type_Int, localBaseReportData.g, localBaseReportData.h, localBaseReportData.jdField_f_of_type_Boolean, localBaseReportData.j, localBaseReportData.i));
          ReportInfo localReportInfo = new ReportInfo();
          localReportInfo.mUin = ReadInJoyUtils.a();
          localReportInfo.mSource = 0;
          localReportInfo.mSourceArticleId = localBaseReportData.jdField_a_of_type_JavaLangLong.longValue();
          localReportInfo.mChannelId = this.jdField_b_of_type_Int;
          localReportInfo.mAlgorithmId = ((int)localBaseReportData.jdField_a_of_type_Long);
          localReportInfo.mStrategyId = localBaseReportData.jdField_b_of_type_Int;
          localReportInfo.mOperation = 7;
          localReportInfo.mServerContext = localBaseReportData.jdField_a_of_type_ArrayOfByte;
          localReportInfo.mReadTimeLength = -1;
          Object localObject1;
          if (localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo != null)
          {
            localObject1 = new ReportInfo.FeedsReportData();
            ((ReportInfo.FeedsReportData)localObject1).jdField_a_of_type_Long = localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
            if (localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null) {
              ((ReportInfo.FeedsReportData)localObject1).jdField_b_of_type_Long = localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
            }
            ((ReportInfo.FeedsReportData)localObject1).jdField_a_of_type_Int = localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
            ((ReportInfo.FeedsReportData)localObject1).jdField_b_of_type_Int = localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
            Object localObject2 = localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
            if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
            {
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
          }
          localArrayList.add(localReportInfo);
          if (localBaseReportData.jdField_c_of_type_Boolean) {}
          try
          {
            if (localBaseReportData.jdField_d_of_type_Boolean)
            {
              localObject1 = ReadInJoyUtils.a();
              ((JSONObject)localObject1).put("feeds_source", localBaseReportData.jdField_a_of_type_JavaLangString);
              ((JSONObject)localObject1).put("kandian_mode", ReadInJoyUtils.e());
              PublicAccountReportUtils.a(null, "CliOper", "", "", "0X800744E", "0X800744E", 0, 0, ReadInJoyUtils.b(localBaseReportData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), "", "", ((JSONObject)localObject1).toString(), false);
            }
            if (this.jdField_b_of_type_Int == 56)
            {
              localReportInfo.mOpSource = 11;
              localObject1 = new ReportInfo.VideoExtraRepoerData();
              ((ReportInfo.VideoExtraRepoerData)localObject1).jdField_c_of_type_Int = 1;
              localObject1 = ((ReportInfo.VideoExtraRepoerData)localObject1).toString();
              localReportInfo.mInnerId = localBaseReportData.jdField_e_of_type_JavaLangString;
              if (QLog.isColorLevel()) {
                QLog.d("VideoReporter", 2, "reportVideoUserOperationByOidbOfFeed subchannel--mUin:" + localReportInfo.mUin + "; mSource:" + localReportInfo.mSource + "; mOpSource:" + localReportInfo.mOpSource + "; mInnerId:" + localReportInfo.mInnerId + "; mChannelId:" + localReportInfo.mChannelId + "; mAlgorithmId:" + localReportInfo.mAlgorithmId + "; mStrategyId:" + localReportInfo.mStrategyId + "; mOperation:" + localReportInfo.mOperation + "; mPlayTimeLength:" + localReportInfo.mPlayTimeLength + "; videoExtraRepoerData:" + (String)localObject1);
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.g();
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      this.jdField_b_of_type_AndroidViewView = ((ViewStub)findViewById(2131367271)).inflate();
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(new lfp(this));
    }
    if ((paramBoolean) && (paramInt > 0)) {}
    for (Object localObject = String.format(getResources().getString(2131428434), new Object[] { Integer.valueOf(paramInt) });; localObject = getResources().getString(2131428436))
    {
      ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131364081)).setText((CharSequence)localObject);
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
  
  private int c()
  {
    return getIntent().getIntExtra("channel_from", -1);
  }
  
  private void c()
  {
    this.jdField_b_of_type_Int = a();
    this.jdField_c_of_type_Int = b();
    this.jdField_a_of_type_JavaLangString = a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager = new VideoPlayManager(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache = new ReadInJoyPageItemCache();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.jdField_a_of_type_Long = ReadInJoyHelper.a(a(), (QQAppInterface)ReadInJoyUtils.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController = VideoAutoPlayController.a(getApplicationContext());
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.app);
    ReadInJoyChannelActivity.SerializableMap localSerializableMap = (ReadInJoyChannelActivity.SerializableMap)getIntent().getSerializableExtra("channel_map_data");
    if ((localSerializableMap != null) && (localSerializableMap.getMap() != null)) {
      this.jdField_a_of_type_Int = ((Integer)localSerializableMap.getMap().get("param_key_channel_column_type")).intValue();
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_e_of_type_AndroidWidgetTextView != null)
    {
      if (paramBoolean)
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setText("已关注");
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-4473925);
        this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundResource(0);
      }
    }
    else {
      return;
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setText("关注");
    this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundResource(2130840758);
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-1);
  }
  
  private void d()
  {
    f();
    g();
    e();
    Object localObject = ReadInJoyLogicEngine.a().a(a());
    if (localObject != null) {
      b((ChannelInfo)localObject, false);
    }
    localObject = new VideoUIManager((FrameLayout)findViewById(2131367093), (ReadInJoyBaseListView)findViewById(2131367398), this);
    ((VideoUIManager)localObject).a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a((VideoUIManager)localObject);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    View localView = findViewById(2131367048);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setEmptyView(localView);
    localView.setOnClickListener(null);
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131363730));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367396));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367090));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367397));
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(a());
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = ((ReadInJoyXListView)findViewById(2131367398));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAnimType(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setChannelId(a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setRefreshCallback(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(this);
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter = new ReadInJoyArticleAdapter(this, getLayoutInflater(), a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.b(b());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.e();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter);
  }
  
  private void h()
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
  
  public Set a(Integer paramInteger)
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
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    if (paramInt == 4) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      ReadInJoyLogicEngine.a().a(this.jdField_b_of_type_Int, b(), paramInt, 0);
      ThreadManager.executeOnSubThread(new lfj(this));
      return;
    }
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 3)
    {
      a(true, i);
      ThreadManager.executeOnSubThread(new lfh(this));
      return;
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_Int != 0) {
      h();
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Int != 0) {
      h();
    }
  }
  
  public void a(List paramList)
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
          if ((localObject != null) && (!ReadInJoyUtils.a((BaseArticleInfo)localObject)) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(j, ((BaseArticleInfo)localObject).mArticleID)))
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
  
  public void a(List paramList, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(ReadInJoyLogicEngine.a().a(Integer.valueOf(this.jdField_b_of_type_Int), paramList));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.notifyDataSetChanged();
  }
  
  public void a(Map paramMap, boolean paramBoolean)
  {
    b(paramMap, paramBoolean);
    ReadInJoyDisplayUtils.a();
    ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.a(), System.currentTimeMillis(), this.jdField_b_of_type_Int);
    getIntent().putExtra("from_search", false);
  }
  
  public void a(Set paramSet, Map paramMap)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(paramSet, paramMap);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyPageItemCache.d = ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.a(), this.jdField_b_of_type_Int);
    ReadInJoyLogicEngine.a().a(this.jdField_b_of_type_Int, 20, 9223372036854775807L, true);
    ReadInJoyLogicEngine.a().a(56, 3, a());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(this.jdField_b_of_type_Int), Boolean.valueOf(true));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    a(paramBoolean, true);
  }
  
  public void b() {}
  
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
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.SubChannelActivity", 2, "doOnActivityResult(): requestCode = " + paramInt1 + ", resultCode = " + paramInt2);
    }
    if (paramInt1 == 101) {
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
        localQQToast.c(2131431555);
        localQQToast.b(getApplicationContext().getResources().getDimensionPixelSize(2131558448) - (int)DisplayUtils.a(getApplicationContext(), 5.0F));
      }
      else
      {
        localQQToast.a(QQToast.a(1));
        localQQToast.c(2131431563);
        localQQToast.b(getApplicationContext().getResources().getDimensionPixelSize(2131558448) - (int)DisplayUtils.a(getApplicationContext(), 5.0F));
        continue;
        if (paramInt1 == 9091) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(0, paramIntent);
        } else if ((paramInt1 == 21) && (paramInt2 == -1)) {
          ForwardUtils.a((QQAppInterface)ReadInJoyUtils.a(), this, getApplicationContext(), paramIntent, null);
        }
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    VideoVolumeControl.a().a(this);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    getWindow().setBackgroundDrawable(null);
    setContentView(2130969672);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131363995));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFitsSystemWindows(true);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    super.doOnCreate(paramBundle);
    c();
    d();
    a(a(Integer.valueOf(a())), a(Integer.valueOf(a())));
    VideoBrightnessControl.a().a(this);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    VideoVolumeControl.a().b(this);
    a(a(Integer.valueOf(a())), a(Integer.valueOf(a())));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.c();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.d();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a();
    this.jdField_b_of_type_JavaUtilMap.clear();
    this.jdField_c_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.d();
    ReadInJoyScreenShotReporter.a(this).a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.j();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.e();
    ReadInJoyScreenShotReporter.a(this).a(b(), a());
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.i();
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.notifyDataSetChanged();
  }
  
  protected void doOnStop()
  {
    VideoVolumeControl.a().a(false, "videoSubChannel onStop");
    super.doOnStop();
  }
  
  protected boolean onBackEvent()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager;
    if ((localObject != null) && (((VideoPlayManager)localObject).a() != null))
    {
      localObject = ((VideoPlayManager)localObject).a();
      if (((VideoUIManager)localObject).a())
      {
        ((VideoUIManager)localObject).d();
        return true;
      }
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
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
            finish();
            return;
            e();
            a(true, 3);
            ReadInJoyLogicEngine.a().a(56, 3, a());
            return;
            if (!HttpUtil.a(this))
            {
              QQToast.a(this, "无网络连接,请检测网络配置!", 0).a();
              return;
            }
            this.jdField_d_of_type_Boolean = true;
            paramView = ReadInJoyLogicEngine.a().a(a());
          } while (paramView == null);
          if (paramView.mIsFollowed)
          {
            a(paramView);
            return;
          }
          a(paramView, true);
          return;
        } while ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int != 0));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.e();
        ThreadManager.executeOnSubThread(new lfk(this));
        return;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a())
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
          this.jdField_f_of_type_Boolean = true;
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoTopicShareHelper == null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoTopicShareHelper = new TopicShareHelper(this);
        }
        paramView = ReadInJoyLogicEngine.a().a(a());
      } while (paramView == null);
      paramView = paramView.clone();
    } while (paramView == null);
    if (TextUtils.isEmpty(paramView.mChannelName)) {
      paramView.mChannelName = a();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoTopicShareHelper.a(paramView, a(paramView), new lfl(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyVideoSubChannelActivity
 * JD-Core Version:    0.7.0.1
 */