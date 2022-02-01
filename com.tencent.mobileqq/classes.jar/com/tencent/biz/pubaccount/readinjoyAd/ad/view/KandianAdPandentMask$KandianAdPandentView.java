package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.MediaPlayListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPluginInstall;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyArticleAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskConfigMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskDataMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskReportMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskUIMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngDrawable.OnPlayRepeatListener;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.vpng.glrenderer.VPNGRenderer;
import com.tencent.mobileqq.vpng.view.VPNGImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HeaderViewListAdapter;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

@SuppressLint({"ViewConstructor"})
class KandianAdPandentMask$KandianAdPandentView
  extends RelativeLayout
  implements View.OnClickListener
{
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private Activity jdField_a_of_type_AndroidAppActivity;
  @Nullable
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  @Nullable
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(new KandianAdPandentMask.KandianAdPandentView.2(this));
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private MediaPlayListenerAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoMediaPlayListenerAdapter = new KandianAdPandentMask.KandianAdPandentView.1(this);
  private VideoPlayerWrapper jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
  private ApngDrawable.OnPlayRepeatListener jdField_a_of_type_ComTencentImageApngDrawable$OnPlayRepeatListener;
  @Nullable
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private VPNGImageView jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView;
  @Nullable
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean = false;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_b_of_type_Boolean = false;
  private Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean = true;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private boolean jdField_d_of_type_Boolean = true;
  
  public KandianAdPandentMask$KandianAdPandentView(Activity paramActivity, @Nullable ListView paramListView, String paramString)
  {
    super(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramActivity.getWindow().getDecorView());
    this.jdField_a_of_type_JavaLangString = paramString;
    e();
  }
  
  @Nullable
  private Bitmap a(@Nullable View paramView, boolean paramBoolean)
  {
    Canvas localCanvas = null;
    Object localObject4 = null;
    Bitmap localBitmap1 = null;
    Object localObject2;
    Object localObject3;
    if (paramView != null)
    {
      paramView.setDrawingCacheEnabled(true);
      paramView.buildDrawingCache();
      localObject2 = localCanvas;
      localObject3 = localObject4;
    }
    try
    {
      Bitmap localBitmap2 = paramView.getDrawingCache();
      localObject2 = localCanvas;
      localObject3 = localObject4;
      localBitmap1 = Bitmap.createBitmap(localBitmap2.getWidth(), localBitmap2.getHeight(), localBitmap2.getConfig());
      localObject2 = localBitmap1;
      localObject3 = localBitmap1;
      localCanvas = new Canvas(localBitmap1);
      if (!paramBoolean)
      {
        localObject2 = localBitmap1;
        localObject3 = localBitmap1;
        localCanvas.drawColor(Color.parseColor("#f8f8f8"));
      }
      localObject2 = localBitmap1;
      localObject3 = localBitmap1;
      localCanvas.drawBitmap(localBitmap2, 0.0F, 0.0F, null);
      return localBitmap1;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("ReadInJoySuperMaskAd", 2, "buildBitmapFromView, error" + localException.getMessage());
        localException.printStackTrace();
      }
      return localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("ReadInJoySuperMaskAd", 2, "buildBitmapFromView, error" + localOutOfMemoryError.getMessage());
        localOutOfMemoryError.printStackTrace();
      }
      return localObject3;
    }
    finally
    {
      paramView.setDrawingCacheEnabled(false);
      paramView.destroyDrawingCache();
    }
  }
  
  @Nullable
  private View a()
  {
    localObject2 = null;
    View localView = null;
    int j;
    int k;
    int i;
    if (this.jdField_a_of_type_ComTencentWidgetListView != null)
    {
      j = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
      k = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
      i = j;
    }
    for (;;)
    {
      localObject2 = localView;
      if (i <= k) {
        localObject2 = localView;
      }
      try
      {
        Object localObject3 = this.jdField_a_of_type_ComTencentWidgetListView.getAdapter().getItem(i);
        localObject2 = localView;
        if ((localObject3 instanceof AdvertisementInfo))
        {
          localObject2 = localView;
          localObject3 = (AdvertisementInfo)localObject3;
          localObject2 = localView;
          Object localObject4 = SuperMaskDataMgr.a.a();
          localObject2 = localView;
          if ((localObject4 instanceof AdvertisementInfo))
          {
            localObject2 = localView;
            if (((AdvertisementInfo)localObject3).mAdAid == ((AdvertisementInfo)localObject4).mAdAid)
            {
              localObject2 = localView;
              localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i - j);
              localObject2 = localView;
              QLog.d("ReadInJoySuperMaskAd", 2, "hideAdsWithAnim, find AdvertisementInfo, targetPos=" + i + ", targetItemView=" + localView);
              localObject2 = localView;
              return localObject2;
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1 = localObject2;
        }
      }
      i += 1;
    }
  }
  
  private void a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView == null) || (this.jdField_b_of_type_AndroidViewViewGroup == null)) {
      return;
    }
    a(false);
    this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.setVisibility(0);
    g();
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)(this.jdField_b_of_type_AndroidViewViewGroup.getWidth() * 1.778F));
    localLayoutParams.addRule(13, -1);
    this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.setVideo(paramString, false, 1, new KandianAdPandentMask.KandianAdPandentView.4(this));
    c();
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("audio"));
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      b();
      return;
    case 3: 
      a(this.jdField_a_of_type_JavaLangString);
      return;
    }
    b(this.jdField_a_of_type_JavaLangString);
  }
  
  private void b(String paramString)
  {
    a(false);
    g();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySuperMaskAd", 2, new Object[] { "initTVKVideoController with path:", paramString });
    }
    if (!new VideoPluginInstall().a()) {
      QLog.e("ReadInJoySuperMaskAd", 2, "sdk NOT installed");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper = new VideoPlayerWrapper(this.jdField_a_of_type_AndroidAppActivity);
    ReadInJoyAdLog.a("ReadInJoySuperMaskAd", "initNormalVideoPlayer  mVideoPlayerW = " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.b();
    if (this.jdField_c_of_type_AndroidViewView != null)
    {
      this.jdField_c_of_type_AndroidViewView.setId(2131369871);
      a(this.jdField_a_of_type_AndroidViewViewGroup);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.b(2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoMediaPlayListenerAdapter);
    if (this.jdField_c_of_type_AndroidViewView != null) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(null, paramString, 3, 1L, 0L, 0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.c(false);
    c();
  }
  
  private void e()
  {
    LayoutInflater.from(getContext()).inflate(2131560336, this, true);
    setId(2131369922);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131372836));
    this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView = ((VPNGImageView)findViewById(2131369868));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372831));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369698));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369695));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369696));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131372837);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131372844);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369905));
    this.jdField_d_of_type_AndroidViewView = findViewById(2131369906);
    ((ImmersiveTitleBar2)findViewById(2131379684)).resetBkColor(0);
    setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  private void f()
  {
    boolean bool2 = true;
    label43:
    label104:
    VideoPlayerWrapper localVideoPlayerWrapper;
    if (!this.jdField_c_of_type_Boolean)
    {
      bool1 = true;
      this.jdField_c_of_type_Boolean = bool1;
      if (!this.jdField_c_of_type_Boolean) {
        break label136;
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130849904));
      if ((this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.getVPNGRenderer() != null) && (this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.getVPNGRenderer().a != null) && (this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.getVPNGRenderer().a.isPlaying()))
      {
        if (!this.jdField_c_of_type_Boolean) {
          break label159;
        }
        this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.getVPNGRenderer().a.setVolume(1.0F, 1.0F);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null)
      {
        localVideoPlayerWrapper = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
        if (this.jdField_c_of_type_Boolean) {
          break label177;
        }
      }
    }
    label136:
    label159:
    label177:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localVideoPlayerWrapper.c(bool1);
      return;
      bool1 = false;
      break;
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130849903));
      break label43;
      this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.getVPNGRenderer().a.setVolume(0.0F, 0.0F);
      break label104;
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3);
    }
    QLog.d("ReadInJoySuperMaskAd", 2, "current volume =  " + this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Float = (this.jdField_a_of_type_Int / 5.0F);
    QLog.d("ReadInJoySuperMaskAd", 2, "current volume =  " + this.jdField_a_of_type_Int + "intervalVolume = " + this.jdField_a_of_type_Float);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject3 = a();
    Object localObject1 = this.jdField_a_of_type_AndroidAppActivity.findViewById(16908307);
    Object localObject2 = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131381111);
    int i;
    int j;
    if (localObject3 != null)
    {
      i = ((View)localObject3).getHeight();
      j = a((View)localObject3, this.jdField_b_of_type_AndroidViewViewGroup);
    }
    for (;;)
    {
      QLog.d("ReadInJoySuperMaskAd", 2, "hideAdsWithAnim, targetFeedsItemTop=" + j + ", targetFeedsItemHeight=" + i);
      if ((j >= 0) && (i > 0)) {}
      for (int k = 1; k != 0; k = 0)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = a((View)localObject3, false);
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
          localObject3 = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject3).width = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
          ((ViewGroup.LayoutParams)localObject3).height = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
          this.jdField_a_of_type_AndroidWidgetImageView.requestLayout();
        }
        this.jdField_c_of_type_AndroidGraphicsBitmap = a((View)localObject2, true);
        if (this.jdField_c_of_type_AndroidGraphicsBitmap != null)
        {
          this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap);
          localObject3 = this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject3).height = this.jdField_c_of_type_AndroidGraphicsBitmap.getHeight();
          ((ViewGroup.LayoutParams)localObject3).width = this.jdField_c_of_type_AndroidGraphicsBitmap.getWidth();
          this.jdField_c_of_type_AndroidWidgetImageView.setY(((View)localObject2).getY());
          this.jdField_c_of_type_AndroidWidgetImageView.requestLayout();
        }
        this.jdField_b_of_type_AndroidGraphicsBitmap = a((View)localObject1, true);
        if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap);
          localObject2 = this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).height = this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight();
          ((ViewGroup.LayoutParams)localObject2).width = this.jdField_b_of_type_AndroidGraphicsBitmap.getWidth();
          this.jdField_b_of_type_AndroidWidgetImageView.setY(((View)localObject1).getY());
          this.jdField_b_of_type_AndroidWidgetImageView.requestLayout();
        }
        i = i / 2 + j - getHeight() / 2;
        QLog.d("ReadInJoySuperMaskAd", 2, "hideAdsWithAnim, centerDiff=" + i);
        localObject2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "scaleX", new float[] { 1.2F, 1.0F });
        localObject3 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "scaleY", new float[] { 1.2F, 1.0F });
        Object localObject4 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "alpha", new float[] { 0.0F, 1.0F });
        Object localObject5 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "translationY", new float[] { 0.0F, i });
        localObject1 = new AnimatorSet();
        ((AnimatorSet)localObject1).play((Animator)localObject2).with((Animator)localObject3).with((Animator)localObject4).with((Animator)localObject5);
        ((AnimatorSet)localObject1).setDuration(600L);
        localObject3 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewViewGroup, "alpha", new float[] { 1.0F, 0.0F });
        localObject4 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewViewGroup, "scaleY", new float[] { 1.0F, 0.8F });
        localObject5 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewViewGroup, "scaleY", new float[] { 1.0F, 0.8F });
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewViewGroup, "translationY", new float[] { 0.0F, i });
        localObject2 = new AnimatorSet();
        ((AnimatorSet)localObject2).play((Animator)localObject3).with(localObjectAnimator).with((Animator)localObject4).with((Animator)localObject5);
        ((AnimatorSet)localObject2).setDuration(600L);
        localObject3 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView, "alpha", new float[] { 0.5F, 0.0F });
        ((ObjectAnimator)localObject3).setDuration(600L);
        localObject5 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "alpha", new float[] { 1.0F, 0.0F });
        localObject4 = new AnimatorSet();
        ((AnimatorSet)localObject4).play((Animator)localObject5).after(150L);
        ((AnimatorSet)localObject4).setDuration(150L);
        localObject5 = new AnimatorSet();
        ((AnimatorSet)localObject5).setInterpolator(new AccelerateDecelerateInterpolator());
        ((AnimatorSet)localObject5).playTogether(new Animator[] { localObject1, localObject2, localObject3, localObject4 });
        ((AnimatorSet)localObject5).start();
        this.jdField_a_of_type_Boolean = true;
        ((AnimatorSet)localObject5).addListener(new KandianAdPandentMask.KandianAdPandentView.5(this));
        return;
      }
      i();
      return;
      j = -1;
      i = 0;
    }
  }
  
  private void i()
  {
    a();
  }
  
  public int a(View paramView1, View paramView2)
  {
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (i > 30) {
        return j;
      }
      j = paramView1.getTop() + j;
      paramView1 = (View)paramView1.getParent();
      if ((paramView1 == null) || (paramView1 == paramView2)) {
        return j;
      }
      i += 1;
    }
  }
  
  public void a()
  {
    if (getParent() != null) {
      ((ViewGroup)getParent()).removeView(this);
    }
    SuperMaskUIMgr.a.b(false);
    SuperMaskUIMgr.a.a(5);
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    Object localObject;
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null)
    {
      localObject = this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable();
      if ((localObject instanceof ApngDrawable))
      {
        localObject = (ApngDrawable)localObject;
        ((ApngDrawable)localObject).removeOnPlayRepeatListener(this.jdField_a_of_type_ComTencentImageApngDrawable$OnPlayRepeatListener);
        ((ApngDrawable)localObject).setOnPlayRepeatListener(null);
      }
    }
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = SuperMaskConfigMgr.a.a(SuperMaskUIMgr.a.b());
    QLog.d("ReadInJoySuperMaskAd", 1, "currentTime = " + l1 + " lastShowMaskTime = " + l2);
    if (SuperMaskReportMgr.a.a()) {
      if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
        SuperMaskReportMgr.a.a(1, SuperMaskDataMgr.a.a());
      }
    }
    for (;;)
    {
      SuperMaskUIMgr.a.a(5);
      if (this.jdField_a_of_type_ComTencentWidgetListView != null)
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetListView.getAdapter();
        if ((localObject instanceof HeaderViewListAdapter))
        {
          localObject = ((HeaderViewListAdapter)localObject).getWrappedAdapter();
          if ((localObject instanceof ReadInJoyBaseAdapter)) {
            ((ReadInJoyBaseAdapter)localObject).a(this.jdField_a_of_type_ComTencentWidgetListView, 0);
          }
        }
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        this.jdField_a_of_type_AndroidOsHandler = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView != null) {
        this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.onRelease();
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.g();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.h();
      }
      if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {}
      try
      {
        this.jdField_a_of_type_AndroidMediaAudioManager.setStreamVolume(3, this.jdField_a_of_type_Int, 4);
        SuperMaskReportMgr.a.a("showMaskEnd", "");
        SuperMaskDataMgr.a.a();
        SuperMaskUIMgr.a.e();
        return;
        QLog.d("ReadInJoySuperMaskAd", 1, "exposure time is less than one second, do not report strict");
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("KandianAdPandentMask", 2, "audioManager setStreamVolume error :" + localException.toString());
          }
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 0))
    {
      SuperMaskReportMgr.a.a("invalidTypeWithAttach", "");
      KandianAdPandentMask.a(SuperMaskDataMgr.a.a());
      return;
    }
    if (this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131369922) == null)
    {
      b(paramInt);
      this.jdField_b_of_type_AndroidViewViewGroup.addView(this);
    }
    SuperMaskUIMgr.a.b(true);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
      SuperMaskReportMgr.a.a(2, SuperMaskDataMgr.a.a());
    }
    ThreadManager.getUIHandler().postDelayed(new KandianAdPandentMask.KandianAdPandentView.3(this), 1000L);
  }
  
  public void a(View paramView)
  {
    if ((paramView.getParent() != null) && ((paramView.getParent() instanceof ViewGroup))) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    a(this.jdField_c_of_type_AndroidViewView);
    a(this.jdField_d_of_type_AndroidWidgetImageView);
    a(this.jdField_a_of_type_AndroidWidgetTextView);
    a(this.jdField_d_of_type_AndroidViewView);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(1, 1);
    localLayoutParams.height = -1;
    localLayoutParams.width = -1;
    localLayoutParams.addRule(13, -1);
    paramViewGroup.addView(this.jdField_c_of_type_AndroidViewView, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(1, 1);
    localLayoutParams.height = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 27.0F);
    localLayoutParams.width = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 72.0F);
    localLayoutParams.rightMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 20.0F);
    localLayoutParams.topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 60.0F);
    localLayoutParams.addRule(11, -1);
    paramViewGroup.addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(1, 1);
    localLayoutParams.height = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 52.0F);
    localLayoutParams.width = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 90.0F);
    localLayoutParams.rightMargin = 0;
    localLayoutParams.topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 45.0F);
    localLayoutParams.addRule(11, -1);
    if (Build.VERSION.SDK_INT >= 17) {
      localLayoutParams.addRule(18, 2131369905);
    }
    paramViewGroup.addView(this.jdField_d_of_type_AndroidViewView, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(1, 1);
    localLayoutParams.height = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 26.0F);
    localLayoutParams.width = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 26.0F);
    localLayoutParams.rightMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 2.0F);
    localLayoutParams.addRule(6, 2131369905);
    localLayoutParams.addRule(8, 2131369905);
    localLayoutParams.addRule(0, 2131369905);
    paramViewGroup.addView(this.jdField_d_of_type_AndroidWidgetImageView, localLayoutParams);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
  }
  
  void b() {}
  
  public void c()
  {
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_AndroidMediaAudioManager == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidMediaAudioManager.setStreamVolume(3, 0, 4);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null)
    {
      i = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3);
      if (i >= this.jdField_a_of_type_Int) {
        this.jdField_d_of_type_Boolean = false;
      }
    }
    else
    {
      return;
    }
    int i = (int)Math.ceil(i + this.jdField_a_of_type_Float);
    QLog.d("ReadInJoySuperMaskAd", 2, "updateVolume setVolume =  " + i);
    this.jdField_a_of_type_AndroidMediaAudioManager.setStreamVolume(3, i, 4);
  }
  
  public void onClick(View paramView)
  {
    Object localObject3 = SuperMaskDataMgr.a.a();
    if (!(localObject3 instanceof AdvertisementInfo)) {}
    Object localObject2;
    Object localObject1;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject2 = (AdvertisementInfo)localObject3;
      ReadInJoyAdLog.a("ReadInJoySuperMaskAd", "click data is : " + localObject2.hashCode());
      ArticleInfo localArticleInfo = ((AdvertisementInfo)localObject2).clone();
      localObject1 = localObject2;
      if ((localArticleInfo instanceof AdvertisementInfo))
      {
        localObject1 = localObject2;
        if (((AdvertisementInfo)localArticleInfo).mAdAid == ((AdvertisementInfo)localObject2).mAdAid)
        {
          localObject1 = (AdvertisementInfo)localArticleInfo;
          ReadInJoyAdLog.a("ReadInJoySuperMaskAd", "clone data is : " + localObject1.hashCode());
        }
      }
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131369905: 
      case 2131369906: 
        SuperMaskReportMgr.a.b(26, localObject1);
        if (!SuperMaskReportMgr.a.a()) {
          break label512;
        }
        localObject2 = "skipMask";
        label211:
        SuperMaskReportMgr.a.a((String)localObject2, ((AdvertisementInfo)localObject1).mAdTraceId);
        if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
          this.jdField_a_of_type_ComTencentImageURLDrawable.pauseVideo();
        }
        this.jdField_c_of_type_Boolean = false;
        f();
        h();
      }
    }
    SuperMaskReportMgr.a.b(1, localObject1);
    label277:
    label312:
    long l;
    if (SuperMaskReportMgr.a.a())
    {
      localObject2 = "clickMask";
      SuperMaskReportMgr.a.a((String)localObject2, ((AdvertisementInfo)localObject1).mAdTraceId);
      localObject2 = ((AdvertisementInfo)localObject3).mAdvertisementExtInfo;
      if (!this.jdField_c_of_type_Boolean) {
        break label497;
      }
      localObject1 = "1";
      ((AdvertisementExtInfo)localObject2).g = ((String)localObject1);
      if ((this.jdField_a_of_type_ComTencentWidgetListView == null) || (this.jdField_a_of_type_ComTencentWidgetListView.getAdapter() == null) || (!(this.jdField_a_of_type_ComTencentWidgetListView.getAdapter() instanceof HeaderViewListAdapter))) {
        break label585;
      }
      localObject1 = (HeaderViewListAdapter)this.jdField_a_of_type_ComTencentWidgetListView.getAdapter();
      if ((((HeaderViewListAdapter)localObject1).getWrappedAdapter() == null) || (!(((HeaderViewListAdapter)localObject1).getWrappedAdapter() instanceof ReadInJoyArticleAdapter))) {
        break label585;
      }
      localObject1 = (ReadInJoyArticleAdapter)((HeaderViewListAdapter)localObject1).getWrappedAdapter();
      if (localObject1 != null)
      {
        ((ReadInJoyArticleAdapter)localObject1).jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = ReadinJoyActionUtil.a(getContext(), (AdvertisementInfo)localObject3, (ReadInJoyBaseAdapter)localObject1, 0, false, null);
        if (((ReadInJoyArticleAdapter)localObject1).jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params == null) {
          break label505;
        }
        l = SystemClock.elapsedRealtime();
        label429:
        ((ReadInJoyArticleAdapter)localObject1).jdField_a_of_type_Long = l;
      }
    }
    for (;;)
    {
      ((AdvertisementInfo)localObject3).clickPos = 11;
      ReadinJoyActionUtil.a(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject3, (ReadInJoyBaseAdapter)localObject1, 0, false, false, null);
      com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoySuperMaskAdUtil.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
        this.jdField_a_of_type_ComTencentImageURLDrawable.pauseVideo();
      }
      i();
      break;
      localObject2 = "clickMaskNoExpose";
      break label277;
      label497:
      localObject1 = "0";
      break label312;
      label505:
      l = -2147483648L;
      break label429;
      label512:
      localObject2 = "skipMaskNoExpose";
      break label211;
      if (this.jdField_c_of_type_Boolean)
      {
        ((AdvertisementInfo)localObject3).mAdvertisementExtInfo.g = "0";
        SuperMaskReportMgr.a.b(27, localObject1);
      }
      for (;;)
      {
        f();
        break;
        ((AdvertisementInfo)localObject3).mAdvertisementExtInfo.g = "1";
        SuperMaskReportMgr.a.b(28, localObject1);
      }
      label585:
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.KandianAdPandentMask.KandianAdPandentView
 * JD-Core Version:    0.7.0.1
 */