package com.tencent.biz.pubaccount.readinjoy.video;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.VideoAudioManager;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.VideoFeedsViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.VideoViewGroup;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.businessCard.helpers.ViewHelper;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.net.URL;
import mji;
import mjj;
import mjk;
import mjl;
import mjm;
import mjn;

public class VideoUIManager
  implements View.OnClickListener, OrientationDetector.OnOrientationChangedListener, VideoFeedsGestureLayout.CustomClickListener, VideoPlayManager.OnPlayStateListener, AbsListView.OnScrollListener
{
  protected int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler = new mji(this);
  private View jdField_a_of_type_AndroidViewView;
  private RotateAnimation jdField_a_of_type_AndroidViewAnimationRotateAnimation;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private SeekBar.OnSeekBarChangeListener jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new mjl(this);
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VideoAudioManager jdField_a_of_type_ComTencentBizPubaccountVideoAudioManager;
  private OrientationDetector jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector;
  private VideoFeedsGestureLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout;
  private VideoPlayManager.VideoPlayParam jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam;
  private VideoPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager;
  private VideoUIManager.OnScreenChangeListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager$OnScreenChangeListener;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private ReadInJoyBaseListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView;
  private VideoViewGroup jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  protected int b;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private SeekBar jdField_b_of_type_AndroidWidgetSeekBar;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private int jdField_f_of_type_Int;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private int jdField_g_of_type_Int;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private int jdField_h_of_type_Int;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private TextView i;
  private TextView j;
  private TextView k;
  private TextView l;
  
  public VideoUIManager(FrameLayout paramFrameLayout, ReadInJoyBaseListView paramReadInJoyBaseListView, Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = paramFrameLayout;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView = paramReadInJoyBaseListView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector = new OrientationDetector(this.jdField_a_of_type_AndroidAppActivity, this);
    paramFrameLayout = this.jdField_a_of_type_AndroidAppActivity.getWindow();
    this.jdField_a_of_type_Int = paramFrameLayout.getAttributes().flags;
    this.jdField_b_of_type_Int = paramFrameLayout.getDecorView().getSystemUiVisibility();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.setScrollEventCallback(new mjj(this));
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setDuration(1000L);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setRepeatCount(-1);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setRepeatMode(1);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setStartTime(-1L);
    paramFrameLayout = new LinearInterpolator();
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setInterpolator(paramFrameLayout);
    this.jdField_a_of_type_ComTencentBizPubaccountVideoAudioManager = new VideoAudioManager(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
    i();
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL)
  {
    ReadInJoyDisplayUtils.a(paramKandianUrlImageView, paramURL, this.jdField_a_of_type_AndroidAppActivity, false);
  }
  
  private void a(AbsListView paramAbsListView)
  {
    if (a()) {}
    int i1;
    int n;
    int m;
    int i2;
    do
    {
      do
      {
        return;
        i1 = ((ReadInJoyBaseListView)paramAbsListView).getHeaderViewsCount();
        n = paramAbsListView.getFirstVisiblePosition() - i1;
        m = n;
        if (n < 0) {
          m = 0;
        }
        n = paramAbsListView.getLastVisiblePosition();
      } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a() == null));
      i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a().jdField_f_of_type_Int;
    } while ((i2 < 0) || ((i2 >= m) && (i2 <= n - i1)));
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "triggerVideoRecycleCheck => stop video;");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b(10);
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      this.jdField_b_of_type_AndroidViewView = ((ViewStub)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367462)).inflate();
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131367181));
      this.i = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131367452));
      this.i.setOnClickListener(this);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    q();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    Drawable localDrawable = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840894);
    this.i.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
    this.i.setCompoundDrawablePadding(AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
    this.jdField_h_of_type_AndroidWidgetTextView.setText(paramString1);
    this.i.setText(paramString2);
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130839778));
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130839779));
  }
  
  private boolean c()
  {
    return (this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0);
  }
  
  private void d(int paramInt)
  {
    if (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() == 0) {
      VideoFeedsHelper.a(this.jdField_d_of_type_AndroidWidgetTextView, 8, 300);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
    this.jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840940));
        this.jdField_b_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(1));
      } while (d());
      VideoFeedsHelper.a(this.jdField_b_of_type_AndroidWidgetImageView, 0, 300);
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationRotateAnimation);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840938));
      this.jdField_b_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(3));
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840939));
      this.jdField_b_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2));
    } while (d());
    VideoFeedsHelper.a(this.jdField_b_of_type_AndroidWidgetImageView, 0, 300);
  }
  
  private boolean d()
  {
    return this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 0;
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131366705));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout = ((VideoFeedsGestureLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367407));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131363399));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131363397));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367463);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131364220));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131361846));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367464));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367259));
    this.l = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367467));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367466));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367422));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367423));
    this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367468));
    this.k = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367465));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367453));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367454));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367455));
    this.j = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367456));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367458));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367459));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367460));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367461));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setContext(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setOnCustomClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setSeekBar(this.jdField_a_of_type_AndroidWidgetSeekBar);
  }
  
  private void j()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTitle);
    this.j.setText(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTitle);
    this.j.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131492969));
    label195:
    float f1;
    label274:
    float f2;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoPlayCount == 0)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoArticleSubsText, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoArticleSubsColor, this.k);
      this.jdField_g_of_type_AndroidWidgetTextView.setText(ReadInJoyDisplayUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_Int));
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getVideoCoverUrlWithSmartCut(false));
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mXGFileSize > 0L) {
        break label465;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText("流量播放");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setChannelID(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.e);
      if (!NetworkUtil.h(this.jdField_a_of_type_AndroidAppActivity)) {
        break label507;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840940));
      this.jdField_b_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(1));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      f1 = (float)DeviceInfoUtil.j() - DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 12.0F);
      f2 = f1 * ReadInJoyDisplayUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_c_of_type_Int);
      if (!(this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
        break label596;
      }
      localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).width = ((int)f1);
      ((FrameLayout.LayoutParams)localObject).height = ((int)f2);
      ((FrameLayout.LayoutParams)localObject).gravity = 1;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setCustomSize(1.0F, ReadInJoyDisplayUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_c_of_type_Int));
      this.jdField_b_of_type_AndroidWidgetSeekBar.setMax(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_Int);
      p();
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(VideoFeedsHelper.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoPlayCount));
      break;
      label465:
      this.jdField_d_of_type_AndroidWidgetTextView.setText(VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mXGFileSize) + "流量");
      break label195;
      label507:
      this.jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      localObject = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840894);
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      if (CUKingCardHelper.a() != 1) {
        break label274;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText("免流量播放");
      break label274;
      label596:
      if ((this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams))
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).width = ((int)f1);
        ((RelativeLayout.LayoutParams)localObject).height = ((int)f2);
        ((RelativeLayout.LayoutParams)localObject).addRule(14);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup;
  }
  
  private void l()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mXGFileSize <= 0L)) {
      return;
    }
    if (CUKingCardHelper.a() == 1) {}
    for (String str = "正在使用免流量播放";; str = "正在使用流量观看，约" + VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mXGFileSize))
    {
      int[] arrayOfInt = new int[2];
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_AndroidViewView.getLocationOnScreen(arrayOfInt);
      int m = arrayOfInt[1] - ImmersiveUtils.a(this.jdField_a_of_type_AndroidAppActivity);
      m = (m + (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_AndroidViewView.getHeight() + m) - DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 40.0F)) / 2;
      VideoFeedsHelper.a(this.jdField_a_of_type_AndroidAppActivity, str, m);
      return;
    }
  }
  
  private void m()
  {
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0))
    {
      VideoFeedsHelper.a(this.jdField_b_of_type_AndroidViewView, 8, 300);
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
    }
  }
  
  private void n()
  {
    VideoFeedsHelper.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 8, 300);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    VideoFeedsHelper.a(this.jdField_b_of_type_AndroidWidgetImageView, 8, 300);
    if (a())
    {
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
  }
  
  private void o()
  {
    int m = 0;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null) {
      m = (int)(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a() / 1000L);
    }
    if (this.jdField_b_of_type_AndroidWidgetSeekBar.getVisibility() == 0) {
      this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(m);
    }
    if (this.jdField_a_of_type_AndroidWidgetSeekBar.getVisibility() == 0) {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(m);
    }
    if (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() == 0) {
      this.jdField_f_of_type_AndroidWidgetTextView.setText(ReadInJoyDisplayUtils.a(m));
    }
  }
  
  private void p()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.removeAllViews();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    f();
    m();
    this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void q()
  {
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "onOrientationChanged=> orientation=" + paramInt);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      d();
      return;
    case 0: 
      b(0);
      return;
    case 8: 
      b(8);
      return;
    }
    d();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0) {}
    int m;
    do
    {
      do
      {
        return;
        m = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
        if ((m != 0) && (m != 1) && (m != 7) && (m != 2) && (m != 4)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("Q.readinjoy.video.VideoUIManager", 2, "innerEnterFullScreen => playState=" + VideoPlayUtils.a(m) + ", illegal state just ignore fullscreen.");
      return;
    } while (this.jdField_b_of_type_Boolean);
    this.jdField_b_of_type_Boolean = true;
    b(true);
    this.jdField_h_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b();
    if ((paramBoolean) && (ReadInJoyDisplayUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_c_of_type_Int))) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector.a(false)) {
        this.jdField_c_of_type_Boolean = true;
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager$OnScreenChangeListener != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager$OnScreenChangeListener.b(true);
      }
      this.jdField_a_of_type_AndroidAppActivity.getWindow().setFlags(1024, 1024);
      if (((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) && (((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).mSystemBarComp != null)) {
        ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).mSystemBarComp.setStatusBarVisible(2, 0);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.setVisibility(4);
      }
      n();
      f();
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
      this.jdField_f_of_type_Int = this.jdField_a_of_type_AndroidWidgetFrameLayout.getWidth();
      this.jdField_g_of_type_Int = this.jdField_a_of_type_AndroidWidgetFrameLayout.getHeight();
      ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setTranslationY(0.0F);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoUIManager", 2, "innerEnterFullScreen => mOriginalWidth=" + this.jdField_f_of_type_Int + ", mOriginalHeight=" + this.jdField_g_of_type_Int + ", playState=" + VideoPlayUtils.a(m) + "，userClickEnter:" + paramBoolean);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.a(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setIsInFullScreen(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(-16777216);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setForeground(null);
      return;
      if (paramInt == 0) {
        this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(0);
      } else {
        this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(8);
      }
    }
  }
  
  public void a(View paramView)
  {
    if (b())
    {
      f();
      return;
    }
    e();
  }
  
  public void a(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (!b());
        f();
      } while (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.c());
      this.jdField_d_of_type_Boolean = true;
      return;
    } while (!this.jdField_d_of_type_Boolean);
    e();
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2) {}
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = paramVideoPlayParam;
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "playVideo(): videoPlayParam=" + paramVideoPlayParam);
    }
    j();
    k();
    b();
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt1, int paramInt2, Object paramObject)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam == null) || (paramVideoPlayParam == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != paramVideoPlayParam)) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.readinjoy.video.VideoUIManager", 2, "onStateChange(): mPlayingVideoParam and videoPlayParam not equal, just return;");
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (paramInt2 == 0)
              {
                if (paramInt1 == 3)
                {
                  if (a()) {
                    d();
                  }
                  a();
                  return;
                }
                a();
                return;
              }
              if (paramInt2 == 1)
              {
                this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
                this.jdField_a_of_type_AndroidViewView.setVisibility(0);
                this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
                this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
                this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(103, 1200L);
                this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
                this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
                return;
              }
              if (paramInt2 != 2) {
                break;
              }
            } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getFirstVisiblePosition() != 0) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getChildAt(1) == null) || (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getChildAt(1).getTag() instanceof ReadInJoyBaseAdapter.VideoFeedsViewHolder)));
            paramVideoPlayParam = (ReadInJoyBaseAdapter.VideoFeedsViewHolder)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getChildAt(1).getTag();
          } while ((paramVideoPlayParam == null) || (paramVideoPlayParam.jdField_g_of_type_AndroidWidgetTextView == null) || (paramVideoPlayParam.jdField_a_of_type_Int != 0));
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        } while (!QLog.isColorLevel());
        QLog.e("Q.readinjoy.video.VideoUIManager", 2, "隐藏大王卡引导Textview");
        return;
        if (paramInt2 == 3)
        {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
          if (paramInt1 == 2)
          {
            VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, 8, 300);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131492971));
            q();
            this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 3000L);
            if (NetworkUtil.b(this.jdField_a_of_type_AndroidAppActivity)) {
              l();
            }
          }
          for (;;)
          {
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(102);
            return;
            if (paramInt1 == 4) {
              q();
            } else if (paramInt1 == 5) {
              if ((d()) && (b()))
              {
                d(2);
                this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
                this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 3000L);
              }
              else if (c())
              {
                m();
                if (NetworkUtil.b(this.jdField_a_of_type_AndroidAppActivity)) {
                  l();
                }
              }
            }
          }
        }
        if (paramInt2 == 4)
        {
          if (paramInt1 == 0)
          {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            this.jdField_a_of_type_AndroidViewView.setVisibility(0);
            this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            m();
            d(3);
            this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
          }
          for (;;)
          {
            this.jdField_a_of_type_AndroidOsHandler.removeMessages(102);
            this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
            return;
            if (paramInt1 == 3) {
              d(3);
            }
          }
        }
        if (paramInt2 == 5)
        {
          if (d()) {
            d(1);
          }
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(102);
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
          return;
        }
        if (paramInt2 != 6) {
          break;
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(102);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.removeAllViews();
      } while (!(paramObject instanceof int[]));
      paramVideoPlayParam = (int[])paramObject;
      a(VideoPlayUtils.a(paramVideoPlayParam[0], paramVideoPlayParam[1]), "点击重试");
      return;
    } while (paramInt2 != 7);
    d();
    a();
  }
  
  public void a(VideoPlayManager paramVideoPlayManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager = paramVideoPlayManager;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setChannelID(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.c());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoPlayManager(paramVideoPlayManager);
  }
  
  public void a(VideoUIManager.OnScreenChangeListener paramOnScreenChangeListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager$OnScreenChangeListener = paramOnScreenChangeListener;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      a(paramAbsListView);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = paramInt1 + paramInt2 - 1;
    if (((this.jdField_c_of_type_Int != -1) && (this.jdField_c_of_type_Int != paramInt1)) || ((this.jdField_d_of_type_Int != -1) && (this.jdField_d_of_type_Int != paramInt2))) {
      a(paramAbsListView);
    }
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0) {
      return false;
    }
    return this.jdField_b_of_type_Boolean;
  }
  
  @TargetApi(11)
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0) {}
    int m;
    do
    {
      do
      {
        return;
      } while ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam == null));
      if (this.jdField_e_of_type_Int == 0)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
        this.jdField_e_of_type_Int = this.jdField_a_of_type_ArrayOfInt[1];
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_AndroidViewView.getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
      m = this.jdField_a_of_type_ArrayOfInt[1] - this.jdField_e_of_type_Int;
    } while (m == this.jdField_a_of_type_AndroidWidgetFrameLayout.getTranslationY());
    ViewHelper.g(this.jdField_a_of_type_AndroidWidgetFrameLayout, m);
  }
  
  public void b(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void b(View paramView) {}
  
  public boolean b()
  {
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) {}
    while (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
      return false;
    }
    return true;
  }
  
  public void c()
  {
    a(0, true);
  }
  
  public void c(int paramInt) {}
  
  public void c(View paramView)
  {
    int m = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
    ReadInJoyBaseAdapter.VideoFeedsViewHolder localVideoFeedsViewHolder = (ReadInJoyBaseAdapter.VideoFeedsViewHolder)paramView.getTag();
    if (localVideoFeedsViewHolder == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.video.VideoUIManager", 2, "handleItemClick():  playState=" + VideoPlayUtils.a(m) + ", view id: " + VideoFeedsHelper.a(paramView));
            }
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a() != null) {
              break;
            }
            if (!VideoAutoPlayController.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext()).a()) {
              VideoVolumeControl.a().a(false, "noAutoPlayClickVideoInReadInjoy", 1);
            }
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(localVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam);
            paramView = localVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
          } while ((paramView == null) || (paramView.mChannelID != 56L) || (!AdvertisementInfo.isAdvertisementInfo(paramView)));
          ReadInJoyBaseAdapter.jdField_h_of_type_Int = (int)(localVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Long / 1000L);
          if (localVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Long == 0L) {}
          for (m = 1;; m = 0)
          {
            ReadInJoyBaseAdapter.i = m;
            ReadInJoyBaseAdapter.jdField_f_of_type_Int = 1;
            ReadInJoyBaseAdapter.jdField_g_of_type_Int = 2;
            NativeAdUtils.a(null, this.jdField_a_of_type_AndroidAppActivity, NativeAdUtils.jdField_f_of_type_Int, NativeAdUtils.l, (AdvertisementInfo)paramView, null, 0L, NativeAdUtils.a(ReadInJoyBaseAdapter.jdField_h_of_type_Int, 0, ReadInJoyBaseAdapter.i, 0, 1, 2, paramView.mVideoDuration, NativeAdUtils.t));
            return;
          }
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b() != localVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_Long) {
            break;
          }
        } while (m == 1);
        if ((m != 5) || (!c())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.w("Q.readinjoy.video.VideoUIManager", 2, "handleItemClick():  paused && isErrorLayoutShowing, just return.");
      return;
      if (b())
      {
        f();
        return;
      }
      e();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoUIManager", 2, "handleItemClick():  点击非当前播放的视频feeds，播放点击的视频");
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b(2);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(localVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam);
      paramView = localVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((paramView != null) && (paramView.mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo(paramView)))
      {
        NativeAdUtils.a(null, this.jdField_a_of_type_AndroidAppActivity, NativeAdUtils.jdField_f_of_type_Int, NativeAdUtils.l, (AdvertisementInfo)paramView, null, 0L, NativeAdUtils.a(0, 0, 1, 0, 1, 2, paramView.mVideoDuration, NativeAdUtils.t));
        ReadInJoyBaseAdapter.jdField_h_of_type_Int = 0;
        ReadInJoyBaseAdapter.i = 1;
        ReadInJoyBaseAdapter.jdField_f_of_type_Int = 1;
        ReadInJoyBaseAdapter.jdField_g_of_type_Int = 2;
      }
    } while (VideoAutoPlayController.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext()).a());
    VideoVolumeControl.a().a(false, "noAutoPlayClickVideoInReadInjoy", 1);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0) {}
    while (!this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    b(false);
    this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager$OnScreenChangeListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager$OnScreenChangeListener.b(false);
    }
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getWindow();
    ((Window)localObject).clearFlags(1024);
    ((Window)localObject).addFlags(this.jdField_a_of_type_Int);
    ((Window)localObject).getDecorView().setSystemUiVisibility(this.jdField_b_of_type_Int);
    if (((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) && (((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).mSystemBarComp != null)) {
      ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).mSystemBarComp.setStatusBarVisible(0, 0);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView.setVisibility(0);
    }
    f();
    this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
    localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = this.jdField_f_of_type_Int;
    ((ViewGroup.LayoutParams)localObject).height = this.jdField_g_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.a(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setIsInFullScreen(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.a();
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector.a(true);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(this.jdField_h_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(0);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setForeground(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840896));
  }
  
  public void e()
  {
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)) {
      return;
    }
    int m;
    if (a())
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      m = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
      if (m != 5) {
        break label200;
      }
      d(1);
      label51:
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      VideoFeedsHelper.a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, 0, 300);
      if (!this.jdField_a_of_type_Boolean)
      {
        UIUtils.a(this.jdField_c_of_type_AndroidWidgetImageView, 10, 10, 10, 10);
        this.jdField_a_of_type_Boolean = true;
      }
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
      this.k.setVisibility(8);
      if (m != 5) {
        break label213;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    }
    for (;;)
    {
      ThreadManager.executeOnSubThread(new mjk(this));
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) {
        break;
      }
      VideoFeedsHelper.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 0, 300);
      break;
      label200:
      if (m != 3) {
        break label51;
      }
      d(2);
      break label51;
      label213:
      if (m == 3)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 3000L);
      }
    }
  }
  
  public void f()
  {
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0)) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)) {
      this.k.setVisibility(8);
    }
    VideoFeedsHelper.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 8, 300);
    this.jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
    VideoFeedsHelper.a(this.jdField_b_of_type_AndroidWidgetImageView, 8, 300);
    VideoFeedsHelper.a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, 8, 300);
    if (a())
    {
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
  }
  
  public void g()
  {
    a("当前为非WiFi环境，继续播放将消耗流量", VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mXGFileSize) + "流量");
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b(this);
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoAudioManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountVideoAudioManager.b();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoAudioManager = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector = null;
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void onClick(View paramView)
  {
    int m = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoUIManager", 2, "onClick(): current playState=" + VideoPlayUtils.a(m) + ", view id: " + VideoFeedsHelper.a(paramView));
    }
    if (paramView.getId() == 2131367461) {
      if (a())
      {
        d();
        ThreadManager.executeOnSubThread(new mjm(this));
      }
    }
    label539:
    do
    {
      do
      {
        do
        {
          return;
          c();
          break;
          if (paramView.getId() == 2131367466)
          {
            switch (((Integer)paramView.getTag()).intValue())
            {
            }
            for (;;)
            {
              ThreadManager.executeOnSubThread(new mjn(this));
              return;
              if (!VideoAutoPlayController.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext()).a()) {
                VideoVolumeControl.a().a(false, "noAutoPlayClickVideoInReadInjoy", 1);
              }
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.f(true);
              if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null)
              {
                paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
                if ((paramView != null) && (paramView.mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo(paramView)))
                {
                  NativeAdUtils.a(null, this.jdField_a_of_type_AndroidAppActivity, NativeAdUtils.jdField_f_of_type_Int, NativeAdUtils.l, (AdvertisementInfo)paramView, null, 0L, NativeAdUtils.a((int)(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a() / 1000L), 0, 0, 0, 2, 2, paramView.mVideoDuration, NativeAdUtils.t));
                  ReadInJoyBaseAdapter.jdField_h_of_type_Int = (int)(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a() / 1000L);
                  ReadInJoyBaseAdapter.i = 0;
                  ReadInJoyBaseAdapter.jdField_f_of_type_Int = 2;
                  ReadInJoyBaseAdapter.jdField_g_of_type_Int = 2;
                  continue;
                  this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.e(true);
                  if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null)
                  {
                    paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
                    if ((paramView != null) && (paramView.mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo(paramView))) {
                      NativeAdUtils.a(null, this.jdField_a_of_type_AndroidAppActivity, NativeAdUtils.jdField_f_of_type_Int, NativeAdUtils.l, (AdvertisementInfo)paramView, null, 0L, NativeAdUtils.a(ReadInJoyBaseAdapter.jdField_h_of_type_Int, (int)(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a() / 1000L), ReadInJoyBaseAdapter.i, 0, ReadInJoyBaseAdapter.jdField_f_of_type_Int, ReadInJoyBaseAdapter.jdField_g_of_type_Int, paramView.mVideoDuration, NativeAdUtils.t));
                    }
                  }
                }
              }
            }
          }
          if (paramView.getId() != 2131367452) {
            break label539;
          }
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.c())
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.f(true);
            return;
          }
        } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a() != 6);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam);
        paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      } while ((paramView == null) || (paramView.mChannelID != 56L) || (!AdvertisementInfo.isAdvertisementInfo(paramView)));
      NativeAdUtils.a(null, this.jdField_a_of_type_AndroidAppActivity, NativeAdUtils.jdField_f_of_type_Int, NativeAdUtils.l, (AdvertisementInfo)paramView, null, 0L, NativeAdUtils.a(0, 0, 1, 0, 1, 2, paramView.mVideoDuration, NativeAdUtils.t));
      ReadInJoyBaseAdapter.jdField_h_of_type_Int = 0;
      ReadInJoyBaseAdapter.i = 1;
      ReadInJoyBaseAdapter.jdField_f_of_type_Int = 1;
      ReadInJoyBaseAdapter.jdField_g_of_type_Int = 2;
      return;
    } while (paramView.getId() != 2131367455);
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager
 * JD-Core Version:    0.7.0.1
 */