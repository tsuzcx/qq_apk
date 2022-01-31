package com.tencent.biz.pubaccount.readinjoy.video;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountArticleHandler;
import com.tencent.biz.pubaccount.PublicAccountArticleObserver;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoAudioManager;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoPlayCountHandler;
import com.tencent.biz.pubaccount.VideoPlayCountObserver;
import com.tencent.biz.pubaccount.VideoPlayRecommendHandler;
import com.tencent.biz.pubaccount.VideoPlayRecommendObserver;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.logic.KandianFavoriteBroadcastReceiver;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager.AtlasCallbackImpl;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyScreenShotReporter;
import com.tencent.biz.pubaccount.util.VideoFeedsWeiShiUtils;
import com.tencent.biz.pubaccount.util.VideoPlayDianZanHandler;
import com.tencent.biz.pubaccount.util.VideoPlayDianZanObserver;
import com.tencent.biz.qqstory.view.widget.DragFrameLayout;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AbsListView.OnScrollListener;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import mbs;
import mbt;
import mbu;
import mbv;
import mbx;
import mby;
import mbz;
import mca;
import mcb;
import mcc;
import mcd;
import mce;
import mcf;
import mcg;
import mch;
import mci;
import mcj;
import mck;
import mcl;
import mcm;
import mcn;
import mdi;
import org.json.JSONObject;

public class VideoFeedsPlayActivity
  extends FragmentActivity
  implements View.OnClickListener, VideoFeedsScrollLayout.ContentLayoutListener, mdi
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  protected AnimatorSet a;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private Handler jdField_a_of_type_AndroidOsHandler = new mcl(this, Looper.getMainLooper());
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public TranslateAnimation a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public RelativeLayout a;
  private PublicAccountArticleHandler jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleHandler;
  private PublicAccountArticleObserver jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleObserver;
  private VideoAudioManager jdField_a_of_type_ComTencentBizPubaccountVideoAudioManager;
  private VideoPlayCountHandler jdField_a_of_type_ComTencentBizPubaccountVideoPlayCountHandler;
  private VideoPlayCountObserver jdField_a_of_type_ComTencentBizPubaccountVideoPlayCountObserver;
  private VideoPlayRecommendHandler jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendHandler;
  private VideoPlayRecommendObserver jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendObserver;
  private KandianFavoriteBroadcastReceiver jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver;
  private ReadInJoyAtlasManager.AtlasCallbackImpl jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallbackImpl = new mcg(this);
  private VideoFeedsAdapter.AdapterEventListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$AdapterEventListener = new mcm(this);
  private VideoFeedsAdapter.VideoItemHolder jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$VideoItemHolder;
  private VideoFeedsAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter;
  private VideoFeedsAppJumpManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAppJumpManager;
  private VideoFeedsCommentManager.CommentEventListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager$CommentEventListener = new mbv(this);
  private VideoFeedsCommentManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager;
  private VideoFeedsCustomRelativeLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomRelativeLayout;
  private VideoFeedsListView.ListViewEventListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView$ListViewEventListener = new mbu(this);
  private VideoFeedsListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView;
  VideoFeedsPlayManager.VideoStatusListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoStatusListener = new mcn(this);
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private VideoFeedsRecommendManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager;
  private VideoPlayDianZanHandler jdField_a_of_type_ComTencentBizPubaccountUtilVideoPlayDianZanHandler;
  private VideoPlayDianZanObserver jdField_a_of_type_ComTencentBizPubaccountUtilVideoPlayDianZanObserver;
  private DragFrameLayout jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new mca(this);
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public HashSet a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 5;
  private long jdField_b_of_type_Long;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  public TranslateAnimation b;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = -1L;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l = true;
  private boolean m;
  private boolean n;
  private boolean o = true;
  private boolean p;
  private boolean q;
  
  private VideoInfo a(Bundle paramBundle)
  {
    VideoInfo localVideoInfo = new VideoInfo();
    Object localObject = (MessageForShortVideo)this.jdField_a_of_type_AndroidOsBundle.getParcelable("key_message_for_shortvideo");
    if (localObject != null)
    {
      localVideoInfo.jdField_a_of_type_Int = 0;
      localVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = ((MessageForShortVideo)localObject);
      return localVideoInfo;
    }
    localVideoInfo.jdField_a_of_type_JavaLangString = paramBundle.getString("VIDEO_VID");
    paramBundle = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_WIDTH");
    localObject = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_HEIGHT");
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_TIME");
    if (paramBundle != null) {}
    for (;;)
    {
      try
      {
        i1 = Integer.valueOf(paramBundle).intValue();
        localVideoInfo.jdField_b_of_type_Int = i1;
        if (localObject == null) {
          continue;
        }
        i1 = Integer.valueOf((String)localObject).intValue();
        localVideoInfo.jdField_c_of_type_Int = i1;
        if (str == null) {
          continue;
        }
        i1 = Integer.valueOf(str).intValue();
        localVideoInfo.jdField_d_of_type_Int = i1;
      }
      catch (Exception paramBundle)
      {
        int i1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "finishActivityWithResult() e=" + paramBundle.getMessage());
        continue;
      }
      localVideoInfo.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_H5_URL");
      localVideoInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_COVER");
      localVideoInfo.j = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_PUB_ACCOUNT_UIN");
      localVideoInfo.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_SUMMARY");
      localVideoInfo.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_TITLE");
      localVideoInfo.e = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_CREATE_TIME");
      localVideoInfo.g = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_ARTICLE_ID");
      localVideoInfo.m = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_THIRD_ICON");
      localVideoInfo.k = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_PUB_ACCOUNT_NAME");
      paramBundle = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_THIRD_NAME");
      if (!TextUtils.isEmpty(paramBundle)) {
        localVideoInfo.k = paramBundle;
      }
      localVideoInfo.l = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_THIRD_ACTION");
      localVideoInfo.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_ARTICLE_BUSITYPE");
      localVideoInfo.n = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_URL");
      localVideoInfo.jdField_c_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("VIDEO_FEED_ID");
      localVideoInfo.jdField_f_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FEED_TYPE");
      localVideoInfo.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_SECOND_INDEX_INNER_ID");
      localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)getIntent().getParcelableExtra("VIDEO_ARTICLE_INFO_FOR_BIU"));
      localVideoInfo.jdField_b_of_type_Long = getIntent().getLongExtra("VIDEO_XG_FILE_SIZE", 0L);
      localVideoInfo.jdField_i_of_type_Int = getIntent().getIntExtra("VIDEO_STRATEGY_ID", 0);
      localVideoInfo.jdField_d_of_type_Long = getIntent().getLongExtra("VIDEO_ALGORITHM_ID", 0L);
      localVideoInfo.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidOsBundle.getParcelableArrayList("VIDEO_TOPIC_INFO_LIST");
      VideoFeedsHelper.a(localVideoInfo);
      return localVideoInfo;
      i1 = 0;
      continue;
      i1 = 0;
      continue;
      i1 = 0;
    }
  }
  
  private void a(int paramInt)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager.a()) && (paramInt == 2)) {}
    do
    {
      while (this.n)
      {
        this.n = false;
        return;
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager.a()) || (paramInt != 1)) {
          bool = false;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "innerHandleActivityHideEvent() isNeedHandleEvert = " + bool);
      }
    } while (!bool);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.f();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g();
    }
    ReadInJoyScreenShotReporter.a(this).a();
  }
  
  @TargetApi(11)
  private void a(View paramView1, View paramView2, long paramLong1, long paramLong2)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramView1.setAlpha(0.0F);
      paramView1.setVisibility(0);
      paramView2.setAlpha(0.0F);
      paramView2.setVisibility(0);
      paramView1 = ObjectAnimator.ofFloat(paramView1, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
      paramView2 = ObjectAnimator.ofFloat(paramView2, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
      paramView1.setDuration(1800L);
      paramView1.setRepeatCount(-1);
      paramView1.setRepeatMode(1);
      paramView1.setStartDelay(paramLong1);
      paramView2.setDuration(1800L);
      paramView2.setRepeatCount(-1);
      paramView2.setRepeatMode(1);
      paramView2.setStartDelay(paramLong2);
      if (this.jdField_a_of_type_AndroidAnimationAnimatorSet == null) {
        this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      }
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { paramView1, paramView2 });
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
      return;
    }
    paramView1.setVisibility(0);
    paramView2.setVisibility(0);
  }
  
  private void a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || ("16888".equals(paramString))) {
      return;
    }
    ThreadManager.post(new mbx(this, paramString), 1, null, true);
  }
  
  private void b(String paramString)
  {
    VideoInfo localVideoInfo = (VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    if ((localVideoInfo.jdField_a_of_type_Int == 6) && (TextUtils.isEmpty(localVideoInfo.k)) && (!TextUtils.isEmpty(paramString)))
    {
      localVideoInfo.k = paramString;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a();
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$VideoItemHolder;
    try
    {
      localJSONObject.put("session_id", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("channel_id", 409409);
      localJSONObject.put("stay_duration", (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L);
      if ((localObject != null) && (((VideoFeedsAdapter.VideoItemHolder)localObject).a != null) && (((VideoFeedsAdapter.VideoItemHolder)localObject).a.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
      {
        localJSONObject.put("algorithm_id", ((VideoFeedsAdapter.VideoItemHolder)localObject).a.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Long);
        localJSONObject.put("strategy_id", ((VideoFeedsAdapter.VideoItemHolder)localObject).a.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_i_of_type_Int);
        localJSONObject.put("video_index", ((VideoFeedsAdapter.VideoItemHolder)localObject).a.jdField_a_of_type_Int);
        localJSONObject.put("item_type", ((VideoFeedsAdapter.VideoItemHolder)localObject).a.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.d());
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("Q.readinjoy.video", 2, "ERROR Exception=" + localException.getMessage());
          continue;
          String str = "0";
        }
      }
    }
    if (paramBoolean)
    {
      localObject = "1";
      PublicAccountReportUtils.a(null, "", "0X8007DBB", "0X8007DBB", 0, 0, (String)localObject, "", "", VideoReporter.a("", "", "", "", localJSONObject), false);
      return;
    }
  }
  
  private void e()
  {
    int i1 = this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1);
    if ((this.jdField_a_of_type_Int == 1) || ((i1 >= 100) && (1 == this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_IS_SHOW_READINJOY_ENTRANCE", -1)))) {
      this.g = true;
    }
  }
  
  private void f()
  {
    boolean bool2 = true;
    this.f = this.jdField_a_of_type_AndroidOsBundle.getBoolean("VIDEO_FROM_AIO", false);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1);
    this.jdField_c_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("VIDEO_FROM_POLYMERIC_TOPIC_ID", -1L);
    this.jdField_d_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("VIDEO_FROM_POLYMERIC_PUIN", 0L);
    this.h = this.jdField_a_of_type_AndroidOsBundle.getBoolean("VIDEO_SHOW_SINGLE", false);
    this.jdField_b_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("VIDEO_PLAY_POSITION", 0L);
    this.j = this.jdField_a_of_type_AndroidOsBundle.getBoolean("VIDEO_SHOW_COMMENT", false);
    label187:
    label210:
    label233:
    Object localObject;
    if ((this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1) == 2) || (this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1) == 3) || (this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1) == 6) || (this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1) == 7))
    {
      bool1 = true;
      this.k = bool1;
      if (this.k) {
        break label630;
      }
      bool1 = true;
      this.l = bool1;
      if ((this.jdField_b_of_type_Long <= 0L) || (!this.k)) {
        break label635;
      }
      bool1 = true;
      this.m = bool1;
      if (this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1) != 9) {
        break label640;
      }
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      e();
      if ((this.jdField_a_of_type_AndroidOsBundle.getInt("REPORT_VIDEO_FEEDS_JUMP_FROM") == 5) && (this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_ARTICLE_BUSITYPE") == 7))
      {
        getIntent().putExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 4);
        this.g = true;
      }
      this.jdField_b_of_type_Int = ReadInJoyUtils.e();
      this.jdField_c_of_type_Int = VideoReporter.a();
      localObject = a(this.jdField_a_of_type_AndroidOsBundle);
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      if (CUKingCardHelper.a() != 1) {
        break label645;
      }
    }
    label640:
    label645:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_b_of_type_Boolean = bool1;
      if (!TextUtils.isEmpty(((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0)).g))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0)).g);
        ReadInJoyAtlasManager.a().a(localArrayList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallbackImpl);
      }
      this.jdField_c_of_type_Boolean = VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (VideoInfo)localObject);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver = new KandianFavoriteBroadcastReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallbackImpl);
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("com.tencent.process.fav");
      registerReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver, (IntentFilter)localObject);
      if (QLog.isColorLevel())
      {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "initData() mVideoFromType = " + this.jdField_a_of_type_Int);
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "initData() mBundle = " + this.jdField_a_of_type_AndroidOsBundle.toString());
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "initData() mVideoDataList[0] = " + ((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0)).b());
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "initData() needReloadTitle = " + this.f + ", showSingleVideo = " + this.h + ", mFirstVideoStartPosition = " + this.jdField_b_of_type_Long + ", mIsShortVideoMode = " + this.jdField_c_of_type_Boolean);
      }
      return;
      bool1 = false;
      break;
      label630:
      bool1 = false;
      break label187;
      label635:
      bool1 = false;
      break label210;
      bool1 = false;
      break label233;
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendHandler = ((VideoPlayRecommendHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(90));
    this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendObserver = new mbs(this);
    super.addObserver(this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendObserver);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager = new VideoFeedsRecommendManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList, this.h);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager);
    if (!this.h)
    {
      long l2 = this.jdField_d_of_type_Long;
      long l1 = l2;
      if (l2 == 0L) {
        l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
      this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendHandler.a(l1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager.a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager.b(), this.jdField_c_of_type_Long, this.jdField_c_of_type_Boolean);
      this.i = true;
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager.a();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayCountHandler = ((VideoPlayCountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(99));
    this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayCountObserver = new mce(this);
    super.addObserver(this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayCountObserver);
    this.jdField_a_of_type_ComTencentBizPubaccountUtilVideoPlayDianZanHandler = ((VideoPlayDianZanHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(127));
    this.jdField_a_of_type_ComTencentBizPubaccountUtilVideoPlayDianZanObserver = new mch(this);
    super.addObserver(this.jdField_a_of_type_ComTencentBizPubaccountUtilVideoPlayDianZanObserver);
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleHandler = ((PublicAccountArticleHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(93));
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleObserver = new mci(this);
    super.addObserver(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleObserver);
    Object localObject = (VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    if (((VideoInfo)localObject).jdField_a_of_type_Int != 0)
    {
      if ((!TextUtils.isEmpty(((VideoInfo)localObject).jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(((VideoInfo)localObject).g))) {
        this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayCountHandler.a(((VideoInfo)localObject).jdField_a_of_type_JavaLangString, ((VideoInfo)localObject).g);
      }
      if (!TextUtils.isEmpty(((VideoInfo)localObject).j)) {
        a(((VideoInfo)localObject).j);
      }
    }
    if ((!VideoFeedsHelper.a((VideoInfo)localObject)) && (!TextUtils.isEmpty(((VideoInfo)localObject).a())))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleHandler.e(((VideoInfo)localObject).a());
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleHandler.c(((VideoInfo)localObject).a());
    }
    if (!TextUtils.isEmpty(((VideoInfo)localObject).g)) {
      this.jdField_a_of_type_ComTencentBizPubaccountUtilVideoPlayDianZanHandler.a(((VideoInfo)localObject).g);
    }
    String str1;
    if ((((VideoInfo)localObject).jdField_a_of_type_Int == 6) && (TextUtils.isEmpty(((VideoInfo)localObject).k)))
    {
      str1 = ((VideoInfo)localObject).j;
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new mcj(this, str1);
      super.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      ((VideoInfo)localObject).k = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, true);
    }
    VideoInfo localVideoInfo = (VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    int i1 = getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
    int i2 = getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", 0);
    if ((localVideoInfo.jdField_a_of_type_Int == 0) && (localVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
      localObject = localVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager != null)
        {
          localJSONObject.put("session_id", this.jdField_a_of_type_JavaLangString);
          localJSONObject.put("video_session_id", this.jdField_b_of_type_JavaLangString);
          localJSONObject.put("dynamic_recommend_strategyid", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager.a());
        }
        label622:
        String str2 = localVideoInfo.j;
        if (!TextUtils.isEmpty(localVideoInfo.g)) {}
        for (str1 = localVideoInfo.g;; str1 = "0")
        {
          PublicAccountReportUtils.a(null, str2, "0X800740A", "0X800740A", 0, 0, String.valueOf(i1), String.valueOf(i2), str1, VideoReporter.a((String)localObject, localVideoInfo.j, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.g, this.jdField_b_of_type_Long, localVideoInfo.a() * 1000L, localJSONObject), false);
          return;
          localObject = null;
          break;
        }
      }
      catch (Exception localException)
      {
        break label622;
      }
    }
  }
  
  @TargetApi(11)
  private void h()
  {
    if (VersionUtils.d()) {
      getWindow().setFlags(16777216, 16777216);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView = new VideoFeedsListView(getApplicationContext(), this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.setClipChildren(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.setDivider(null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.setSelector(new ColorDrawable(0));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.setScrollable(false);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout = ((DragFrameLayout)findViewById(2131365545));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomRelativeLayout = ((VideoFeedsCustomRelativeLayout)findViewById(2131365609));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomRelativeLayout.setListViewEventListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView$ListViewEventListener);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomRelativeLayout.setScrollable(false);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.setEnabled(false);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.setDraggableView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomRelativeLayout);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131367093));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView, new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = new VideoFeedsPlayManager(getApplicationContext(), this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoStatusListener);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_b_of_type_Long);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(new VideoFeedsPlayActivity.PhoneCallStateListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.f(this.jdField_b_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g(this.m);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter = new VideoFeedsAdapter(getApplicationContext(), this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.b(this.f);
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter;
    int i1;
    if (this.h)
    {
      i1 = 3;
      ((VideoFeedsAdapter)localObject).a(i1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$AdapterEventListener);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.c(this.l);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.d(this.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.e(this.jdField_c_of_type_Boolean);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.e();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView$ListViewEventListener);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomRelativeLayout.findViewById(2131367303));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomRelativeLayout.findViewById(2131367088));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.bringToFront();
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomRelativeLayout.findViewById(2131365626));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomRelativeLayout.findViewById(2131367305));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomRelativeLayout.findViewById(2131367310));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager = new VideoFeedsCommentManager(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_b_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager.c();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager.a((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager.a(this.j, false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager$CommentEventListener);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager);
      this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomRelativeLayout.findViewById(2131367306));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAppJumpManager = new VideoFeedsAppJumpManager(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_AndroidViewViewGroup, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAppJumpManager);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAppJumpManager);
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomRelativeLayout.findViewById(2131367304));
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
      if ((this.g) && (((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0)).b())) {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      }
      ((LinearLayout)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomRelativeLayout.findViewById(2131367089)).setOnClickListener(this);
      VideoVolumeControl.a().a(this);
      if (!getIntent().hasExtra("param_needSmooth")) {
        break label987;
      }
      VideoVolumeControl.a().e(true);
    }
    int i2;
    int i3;
    int i5;
    for (;;)
    {
      VideoVolumeControl.a().a(VideoVolumeControl.a().a(true), "init view set mute itself FromMutiVideo", 2);
      VideoBehaviorsReporter.a().a(true);
      VideoBehaviorsReporter.a().a(2);
      VideoBrightnessControl.a().a(this);
      localObject = getIntent();
      i1 = ((Intent)localObject).getIntExtra("item_x", 0);
      i2 = ((Intent)localObject).getIntExtra("item_y", 0);
      i3 = ((Intent)localObject).getIntExtra("item_width", 0);
      int i4 = ((Intent)localObject).getIntExtra("item_height", 0);
      i5 = (int)DeviceInfoUtil.l();
      int i6 = (int)DeviceInfoUtil.m();
      if (((i1 != 0) || (i2 != 0) || (i3 != 0)) && (i3 < i4)) {
        break label997;
      }
      overridePendingTransition(2131034309, 0);
      return;
      i1 = 1;
      break;
      label987:
      VideoVolumeControl.a().e(false);
    }
    label997:
    overridePendingTransition(0, 0);
    float f1 = 1.0F * i3 / i5;
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.setSizeAndPosition(f1, i1, i2);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.post(new mck(this));
  }
  
  private void i()
  {
    ThreadManager.post(new mbt(this), 1, null, true);
  }
  
  private void j()
  {
    if (this.h) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "doOnLoadMoreData() 拉取推荐视频列表 mGettingRecommendList=" + this.i);
      }
    } while (this.i);
    ThreadManager.post(new mby(this), 1, null, true);
    this.i = true;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.d();
  }
  
  private void k()
  {
    long l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a();
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a();
    if ((localObject != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_a_of_type_JavaUtilArrayList.get(0) == localObject))
    {
      this.jdField_a_of_type_AndroidOsBundle.putInt("VIDEO_PLAY_STATUS", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a());
      this.jdField_a_of_type_AndroidOsBundle.putLong("VIDEO_PLAY_POSITION", l1);
    }
    for (;;)
    {
      if (localObject != null) {
        this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_ARTICLE_ID", ((VideoInfo)localObject).g);
      }
      localObject = new Intent();
      ((Intent)localObject).putExtras(this.jdField_a_of_type_AndroidOsBundle);
      setResult(-1, (Intent)localObject);
      finish();
      overridePendingTransition(0, 2131034143);
      if (QLog.isColorLevel()) {
        QLog.w("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "finishActivityWithResult() position=" + l1 + ", currentPlayStatus=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a());
      }
      VideoVolumeControl.a().b(this);
      return;
      this.jdField_a_of_type_AndroidOsBundle.putInt("VIDEO_PLAY_STATUS", 0);
      this.jdField_a_of_type_AndroidOsBundle.putLong("VIDEO_PLAY_POSITION", 0L);
    }
  }
  
  private void l()
  {
    Intent localIntent = new Intent(this, ReadInJoyChannelActivity.class);
    localIntent.putExtra("channel_id", 56);
    localIntent.putExtra("channel_name", "视频");
    localIntent.putExtra("channel_type", 3);
    localIntent.putExtra("channel_from", 2);
    localIntent.putExtra("is_channel_activity", true);
    startActivity(localIntent);
  }
  
  @TargetApi(11)
  private void m()
  {
    this.p = false;
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility() == 8) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "hide user guide");
    }
    n();
    this.jdField_a_of_type_AndroidOsHandler.post(new mcb(this));
  }
  
  @TargetApi(11)
  private void n()
  {
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout.getAnimation() != null)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.getAnimation().setAnimationListener(null);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.getAnimation().cancel();
      this.jdField_b_of_type_AndroidWidgetLinearLayout.clearAnimation();
    }
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null)
    {
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(null);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.cancel();
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = null;
    }
    if (this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation != null)
    {
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(null);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.cancel();
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = null;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null)
      {
        Iterator localIterator = this.jdField_a_of_type_AndroidAnimationAnimatorSet.getChildAnimations().iterator();
        while (localIterator.hasNext())
        {
          Animator localAnimator = (Animator)localIterator.next();
          localAnimator.end();
          localAnimator.cancel();
        }
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.end();
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
      }
      this.jdField_a_of_type_AndroidAnimationAnimatorSet = null;
    }
  }
  
  @TargetApi(11)
  private void o()
  {
    this.p = true;
    if ((this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) || (this.jdField_d_of_type_Boolean)) {}
    int i1;
    do
    {
      do
      {
        return;
      } while (this.j);
      i1 = ReadInJoyHelper.K(this.mRuntime);
    } while (i1 >= 3);
    ReadInJoyHelper.x(this.mRuntime, i1 + 1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 5000L);
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "show user guide");
    }
    TextView localTextView = (TextView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131365627);
    if (!TextUtils.isEmpty(((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0)).g)) {
      localTextView.setText("浏览更多相关视频");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null) {
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.cancel();
      }
      if (this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation != null) {
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.cancel();
      }
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, -0.2F);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(200L);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -0.2F, 1, 0.0F);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new mcc(this));
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new mcd(this));
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new mcf(this), 300L);
      return;
      localTextView.setText("浏览更多热门视频");
    }
  }
  
  public int a()
  {
    int i1 = -1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter != null) {
      i1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a();
    }
    return i1;
  }
  
  public void a()
  {
    k();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilVideoPlayDianZanHandler != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountUtilVideoPlayDianZanHandler.a(paramString, paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomRelativeLayout.setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131492923)));
  }
  
  public void b(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "onDynamicRequestVideoList()");
    }
    this.i = true;
    long l2 = this.jdField_d_of_type_Long;
    long l1 = l2;
    if (l2 == 0L) {
      l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendHandler.a(l1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager.a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager.b(), this.jdField_c_of_type_Long, this.jdField_c_of_type_Boolean);
  }
  
  public void d()
  {
    getWindow().getDecorView().setSystemUiVisibility(3846);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i1 = 0;
    if (paramInt1 == 21) {
      switch (paramInt2)
      {
      }
    }
    do
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putAll(paramIntent.getExtras());
      VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localBundle);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new mbz(this), 500L);
      return;
      if (paramInt1 == 101)
      {
        switch (paramInt2)
        {
        default: 
          return;
        }
        paramInt1 = i1;
        if (!paramIntent.getBooleanExtra("bFailed", false)) {
          paramInt1 = 1;
        }
        paramIntent = new QQToast(getApplicationContext());
        paramIntent.d(2000);
        if (paramInt1 != 0)
        {
          paramIntent.a(QQToast.a(2));
          paramIntent.c(2131431555);
          paramIntent.b(getApplicationContext().getResources().getDimensionPixelSize(2131558448) - (int)DisplayUtils.a(getApplicationContext(), 5.0F));
          return;
        }
        paramIntent.a(QQToast.a(1));
        paramIntent.c(2131431563);
        paramIntent.b(getApplicationContext().getResources().getDimensionPixelSize(2131558448) - (int)DisplayUtils.a(getApplicationContext(), 5.0F));
        return;
      }
      if (paramInt1 == 10001)
      {
        switch (paramInt2)
        {
        default: 
          return;
        }
        QQToast.a(this, 2131437343, 0).a();
        return;
      }
    } while ((paramInt1 != 117) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager == null));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnBackPressed()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.d();
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "BackPressed, back to list from fullscreen");
      }
      return;
    }
    c(false);
    k();
    super.doOnBackPressed();
  }
  
  @TargetApi(11)
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      ReadInJoyUtils.a("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "VideoFeedsPlayActivity doOnCreate()");
    }
    this.mActNeedImmersive = false;
    getWindow().setFlags(1024, 1024);
    getWindow().setBackgroundDrawable(null);
    setRequestedOrientation(1);
    super.doOnCreate(paramBundle);
    super.setContentView(2130969654);
    this.jdField_a_of_type_AndroidOsBundle = getIntent().getExtras();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_ComTencentBizPubaccountVideoAudioManager = new VideoAudioManager(getApplicationContext());
    if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_FEEDS_INNER_SESSION_ID"))) {}
    for (this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_FEEDS_INNER_SESSION_ID");; this.jdField_a_of_type_JavaLangString = VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_ARTICLE_ID")))
    {
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_CHANNEL_SESSION_ID");
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      f();
      h();
      g();
      i();
      return true;
    }
  }
  
  public void doOnDestroy()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.f();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.h();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.h();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver != null) {
      super.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver != null) {
      unregisterReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAppJumpManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAppJumpManager.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAppJumpManager = null;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$VideoItemHolder = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    n();
    super.removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendObserver);
    super.removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayCountObserver);
    super.removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleObserver);
    try
    {
      super.doOnDestroy();
      VideoBehaviorsReporter.a().a();
      ReadInJoyScreenShotReporter.a(this).b();
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "VideoFeedsPlayActivity doOnDestroy()");
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 1, new Object[] { "super.doOnDestroy failed. \n", localIllegalArgumentException.toString() });
      }
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "VideoFeedsPlayActivity doOnPause()");
    }
    a(1);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "VideoFeedsPlayActivity doOnResume()");
    }
    d();
    VideoVolumeControl.a().a(true, "videoFeeds doOnResume");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.f();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.g();
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$VideoItemHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$VideoItemHolder.a != null)) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$VideoItemHolder.a.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.j);
    }
    ReadInJoyScreenShotReporter.a(this).a(-1, -1);
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    VideoVolumeControl.a().a(false, "videoFeeds doOnPause");
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "VideoFeedsPlayActivity doOnStop()");
    }
    a(2);
  }
  
  protected String getModuleId()
  {
    return "module_videofeeds";
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131367089: 
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager.a())
      {
        k();
        c(false);
        return;
      }
      doOnBackPressed();
      return;
    case 2131367304: 
      l();
      return;
    case 2131367305: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.e();
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g();
    }
    if (this.jdField_a_of_type_Int == 0) {
      paramView = "video_type_videoguid";
    }
    int i1;
    for (;;)
    {
      VideoFeedsWeiShiUtils.a(this, paramView);
      i1 = getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      PublicAccountReportUtils.b(null, "", "0X800931E", "0X800931E", 0, 0, String.valueOf(i1), "", "", VideoReporter.a(null), false);
      return;
      if (this.jdField_a_of_type_Int == 9) {
        paramView = "video_type_videopublic";
      } else {
        paramView = "video_type_videocard";
      }
    }
    PublicAccountReportUtils.b(null, "", "0X800924E", "0X800924E", 0, 0, String.valueOf(i1), "", "", VideoReporter.a(null), false);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void updateAppRuntime()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)ReadInJoyUtils.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity
 * JD-Core Version:    0.7.0.1
 */