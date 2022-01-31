package com.tencent.biz.pubaccount.readinjoy.view.fastweb.video;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.VideoAudioManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsCustomRelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsIPCClient;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsIPCClient.Observer;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsScrollLayout.ContentLayoutListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import mnn;
import mnq;
import mnr;
import mqq.app.AppRuntime;

public class FastWebVideoFeedsPlayActivity
  extends BaseActivity
  implements View.OnClickListener, VideoFeedsIPCClient.Observer, VideoFeedsScrollLayout.ContentLayoutListener
{
  private long jdField_a_of_type_Long;
  protected AnimatorSet a;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new mnr(this);
  protected TranslateAnimation a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public RelativeLayout a;
  private VideoAudioManager jdField_a_of_type_ComTencentBizPubaccountVideoAudioManager;
  private VideoFeedsCustomRelativeLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomRelativeLayout;
  private VideoFeedsIPCClient jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient;
  private FastWebVideoFeedsAdapter.VideoItemHolder jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter$VideoItemHolder;
  private FastWebVideoFeedsAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter;
  private FastWebVideoFeedsListView.ListViewEventListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsListView$ListViewEventListener = new mnq(this);
  private FastWebVideoFeedsListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsListView;
  FastWebVideoFeedsPlayManager.VideoStatusListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoStatusListener = new mnn(this);
  private FastWebVideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public HashSet a;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  protected TranslateAnimation b;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  private FastWebVideoInfo a(Bundle paramBundle)
  {
    FastWebVideoInfo localFastWebVideoInfo = new FastWebVideoInfo();
    Object localObject = (MessageForShortVideo)this.jdField_a_of_type_AndroidOsBundle.getParcelable("key_message_for_shortvideo");
    if (localObject != null)
    {
      localFastWebVideoInfo.jdField_a_of_type_Int = 0;
      localFastWebVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = ((MessageForShortVideo)localObject);
      return localFastWebVideoInfo;
    }
    localFastWebVideoInfo.jdField_a_of_type_JavaLangString = paramBundle.getString("VIDEO_VID");
    paramBundle = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_WIDTH");
    localObject = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_HEIGHT");
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_TIME");
    if (paramBundle != null) {}
    for (;;)
    {
      try
      {
        i = Integer.valueOf(paramBundle).intValue();
        localFastWebVideoInfo.jdField_b_of_type_Int = i;
        if (localObject == null) {
          continue;
        }
        i = Integer.valueOf((String)localObject).intValue();
        localFastWebVideoInfo.jdField_c_of_type_Int = i;
        if (str == null) {
          continue;
        }
        i = Integer.valueOf(str).intValue();
        localFastWebVideoInfo.jdField_d_of_type_Int = i;
      }
      catch (Exception paramBundle)
      {
        int i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayActivity", 2, "finishActivityWithResult() e=" + paramBundle.getMessage());
        continue;
      }
      localFastWebVideoInfo.f = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_H5_URL");
      localFastWebVideoInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_COVER");
      localFastWebVideoInfo.j = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_PUB_ACCOUNT_NAME");
      localFastWebVideoInfo.i = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_PUB_ACCOUNT_UIN");
      localFastWebVideoInfo.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_SUMMARY");
      localFastWebVideoInfo.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_TITLE");
      localFastWebVideoInfo.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_CREATE_TIME");
      localFastWebVideoInfo.g = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_ARTICLE_ID");
      localFastWebVideoInfo.m = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_THIRD_ICON");
      localFastWebVideoInfo.k = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_THIRD_NAME");
      localFastWebVideoInfo.l = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_THIRD_ACTION");
      localFastWebVideoInfo.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_ARTICLE_BUSITYPE");
      localFastWebVideoInfo.p = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_URL");
      localFastWebVideoInfo.jdField_c_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("VIDEO_FEED_ID");
      localFastWebVideoInfo.jdField_e_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FEED_TYPE");
      localFastWebVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)getIntent().getParcelableExtra("VIDEO_ARTICLE_INFO_FOR_BIU"));
      return localFastWebVideoInfo;
      i = 0;
      continue;
      i = 0;
      continue;
      i = 0;
    }
  }
  
  private void c()
  {
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("VIDEO_FROM_AIO", false);
    this.c = this.jdField_a_of_type_AndroidOsBundle.getBoolean("VIDEO_SHOW_SINGLE", false);
    if (this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_ARTICLE_BUSITYPE") == 6) {
      this.c = true;
    }
    this.jdField_b_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("VIDEO_PLAY_POSITION", 0L);
    this.jdField_a_of_type_JavaUtilArrayList.add(a(this.jdField_a_of_type_AndroidOsBundle));
    if (QLog.isColorLevel())
    {
      QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayActivity", 2, "initData() mBundle = " + this.jdField_a_of_type_AndroidOsBundle.toString());
      QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayActivity", 2, "initData() mVideoDataList[0] = " + ((FastWebVideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0)).a());
      QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayActivity", 2, "initData() needReloadTitle = " + this.jdField_b_of_type_Boolean + ", showSingleVideo = " + this.c + ", mFirstVideoStartPosition = " + this.jdField_b_of_type_Long);
    }
  }
  
  @TargetApi(11)
  private void d()
  {
    if (VersionUtils.d()) {
      getWindow().setFlags(16777216, 16777216);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsListView = new FastWebVideoFeedsListView(getApplicationContext(), this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsListView.setClipChildren(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsListView.setDivider(new ColorDrawable(16777215));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsListView.setDividerHeight(AIOUtils.a(2.0F, getResources()));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsListView.setScrollable(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomRelativeLayout = ((VideoFeedsCustomRelativeLayout)findViewById(2131365609));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131367093));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsListView, new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager = new FastWebVideoFeedsPlayManager(getApplicationContext(), this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoStatusListener);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager.a(this.jdField_b_of_type_Long);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager.b(2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager.a(new FastWebVideoFeedsPlayActivity.PhoneCallStateListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter = new FastWebVideoFeedsAdapter(getApplicationContext(), this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsListView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter.a(this.jdField_b_of_type_Boolean);
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter;
    int i;
    if (this.c)
    {
      i = 3;
      ((FastWebVideoFeedsAdapter)localObject).a(i);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsListView.a(((FastWebVideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0)).a(getApplicationContext(), this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsListView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsListView$ListViewEventListener);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomRelativeLayout.findViewById(2131367088));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.bringToFront();
      ((LinearLayout)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomRelativeLayout.findViewById(2131367089)).setOnClickListener(this);
      FastWebVideoVolumeControl.a().a(this);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient.a("CMD_VOLUMECONTROL_INSTANCE_SHOULDMUTEINVIDEOFEEDS_GET", null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient.a("CMD_IGNORE_VOLUME_CHANGE", null);
      if (localObject != null) {
        FastWebVideoVolumeControl.a().a(((Bundle)localObject).getBoolean("VOLUMECONTROL_INSTANCE_SHOULDMUTEINVIDEOFEEDS", false));
      }
      if (!getIntent().hasExtra("param_needSmooth")) {
        break label535;
      }
      FastWebVideoVolumeControl.a().c(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomRelativeLayout.findViewById(2131367092));
      if ((!this.d) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        FastWebVideoVolumeControl.a().a(this.jdField_a_of_type_AndroidWidgetImageView);
        FastWebVideoVolumeControl.a().a(FastWebVideoVolumeControl.a().b(), "init view set mute itself FromMutiVideo", 2);
      }
      return;
      i = 1;
      break;
      label535:
      FastWebVideoVolumeControl.a().c(false);
    }
  }
  
  private void e()
  {
    long l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager.a();
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager.a();
    if ((localObject != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_a_of_type_JavaUtilArrayList.get(0) == localObject))
    {
      this.jdField_a_of_type_AndroidOsBundle.putInt("VIDEO_PLAY_STATUS", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager.a());
      this.jdField_a_of_type_AndroidOsBundle.putLong("VIDEO_PLAY_POSITION", l);
    }
    for (;;)
    {
      if (localObject != null) {
        this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_ARTICLE_ID", ((FastWebVideoInfo)localObject).g);
      }
      localObject = new Intent();
      ((Intent)localObject).putExtras(this.jdField_a_of_type_AndroidOsBundle);
      setResult(-1, (Intent)localObject);
      finish();
      overridePendingTransition(2131034194, 2131034195);
      if (QLog.isColorLevel()) {
        QLog.w("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayActivity", 2, "finishActivityWithResult() position=" + l + ", currentPlayStatus=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager.a());
      }
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("VOLUMECONTROL_INSTANCE_SHOULDMUTEINVIDEOFEEDS", FastWebVideoVolumeControl.a().b());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient.a("CMD_VOLUMECONTROL_INSTANCE_SHOULDMUTEINVIDEOFEEDS_SET", (Bundle)localObject);
      FastWebVideoVolumeControl.a().b(this);
      return;
      this.jdField_a_of_type_AndroidOsBundle.putInt("VIDEO_PLAY_STATUS", 0);
      this.jdField_a_of_type_AndroidOsBundle.putLong("VIDEO_PLAY_POSITION", 0L);
    }
  }
  
  @TargetApi(11)
  private void f()
  {
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
  
  public int a()
  {
    int i = -1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter != null) {
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter.a();
    }
    return i;
  }
  
  public void a()
  {
    e();
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    if (("CMD_GET_NICK_NAME_BY_UIN".equals(paramString)) && (paramBundle != null))
    {
      paramString = (FastWebVideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      String str = paramBundle.getString("VALUE_USER_UIN_TO_GET_NICK_NAME");
      paramBundle = paramBundle.getString("VALUE_USER_NICK_NAME");
      if ((paramString.jdField_a_of_type_Int == 6) && (!TextUtils.isEmpty(str)) && (str.equals(paramString.i)))
      {
        paramString.j = paramBundle;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter.a();
        }
      }
    }
  }
  
  public void b() {}
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    if (paramInt1 == 21) {
      switch (paramInt2)
      {
      }
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient == null);
      Bundle localBundle = new Bundle();
      localBundle.putAll(paramIntent.getExtras());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient.a("CMD_HANDLE_FORWARD_DATA", localBundle);
      return;
      if (paramInt1 == 101)
      {
        switch (paramInt2)
        {
        default: 
          return;
        }
        paramInt1 = i;
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
    } while (paramInt1 != 10001);
    switch (paramInt2)
    {
    default: 
      return;
    }
    QQToast.a(this, 2131437343, 0).a();
  }
  
  public void doOnBackPressed()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsListView.c();
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayActivity", 2, "BackPressed, back to list from fullscreen");
      }
      return;
    }
    e();
    super.doOnBackPressed();
  }
  
  @TargetApi(11)
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayActivity", 2, "VideoFeedsPlayActivity doOnCreate()");
    }
    this.mActNeedImmersive = false;
    getWindow().setFlags(1024, 1024);
    requestWindowFeature(1);
    getWindow().setBackgroundDrawable(null);
    setRequestedOrientation(1);
    super.doOnCreate(paramBundle);
    super.setContentView(2130969611);
    overridePendingTransition(2131034194, 2131034195);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)getSystemService("audio"));
    this.jdField_a_of_type_AndroidOsBundle = getIntent().getExtras();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_ComTencentBizPubaccountVideoAudioManager = new VideoAudioManager(getApplicationContext());
    this.jdField_a_of_type_ComTencentBizPubaccountVideoAudioManager.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient = VideoFeedsIPCClient.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient.a("CMD_INIT_READINJOY_MANAGER", null);
    this.jdField_a_of_type_JavaLangString = VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_ARTICLE_ID"));
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    c();
    d();
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsListView.g();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoAudioManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountVideoAudioManager.b();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter.d();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager.h();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null)
    {
      this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(null);
      this.jdField_a_of_type_AndroidMediaAudioManager = null;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter$VideoItemHolder = null;
    f();
    super.doOnDestroy();
    if (((FastWebVideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int == 6)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient.a("CMD_GET_NICK_NAME_BY_UIN_CANCLE", null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient.b(this);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayActivity", 2, "VideoFeedsPlayActivity doOnDestroy()");
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayActivity", 2, "VideoFeedsPlayActivity doOnPause()");
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
      this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(null);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter.b();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager.g();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayActivity", 2, "VideoFeedsPlayActivity doOnResume()");
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
      this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(null, 3, 1);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager.f();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsAdapter.c();
    }
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
    }
    doOnBackPressed();
  }
  
  public void updateAppRuntime()
  {
    super.updateAppRuntime();
    AppRuntime localAppRuntime = getAppRuntime();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)localAppRuntime);
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.feeds.FastWebVideoFeedsPlayActivity", 4, "VideoFeedsPlayActivity updateAppRuntime, " + localAppRuntime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayActivity
 * JD-Core Version:    0.7.0.1
 */