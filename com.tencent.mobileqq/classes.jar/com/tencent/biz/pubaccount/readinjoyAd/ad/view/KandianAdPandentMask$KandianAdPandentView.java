package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
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
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskConfigMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskDataMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskReportMgr;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngDrawable.OnPlayRepeatListener;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJSuperMaskService;
import com.tencent.mobileqq.kandian.base.video.player.MediaPlayListenerAdapter;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.plugin.api.IVideoPluginInstall;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoPlayerWrapperFactory;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoPluginInstallFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.vpng.glrenderer.VPNGRenderer;
import com.tencent.mobileqq.vpng.view.VPNGImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HeaderViewListAdapter;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

@SuppressLint({"ViewConstructor"})
class KandianAdPandentMask$KandianAdPandentView
  extends RelativeLayout
  implements View.OnClickListener, KandianAdPandent
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
  private ApngDrawable.OnPlayRepeatListener jdField_a_of_type_ComTencentImageApngDrawable$OnPlayRepeatListener;
  @Nullable
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private MediaPlayListenerAdapter jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerMediaPlayListenerAdapter = new KandianAdPandentMask.KandianAdPandentView.1(this);
  private IVideoPlayerWrapper jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper;
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
  
  /* Error */
  @Nullable
  private Bitmap a(@Nullable View paramView, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +233 -> 234
    //   4: aload_1
    //   5: iconst_1
    //   6: invokevirtual 120	android/view/View:setDrawingCacheEnabled	(Z)V
    //   9: aload_1
    //   10: invokevirtual 123	android/view/View:buildDrawingCache	()V
    //   13: aload_1
    //   14: invokevirtual 127	android/view/View:getDrawingCache	()Landroid/graphics/Bitmap;
    //   17: astore 4
    //   19: aload 4
    //   21: invokevirtual 133	android/graphics/Bitmap:getWidth	()I
    //   24: aload 4
    //   26: invokevirtual 136	android/graphics/Bitmap:getHeight	()I
    //   29: aload 4
    //   31: invokevirtual 140	android/graphics/Bitmap:getConfig	()Landroid/graphics/Bitmap$Config;
    //   34: invokestatic 144	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   37: astore_3
    //   38: new 146	android/graphics/Canvas
    //   41: dup
    //   42: aload_3
    //   43: invokespecial 149	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   46: astore 5
    //   48: iload_2
    //   49: ifne +13 -> 62
    //   52: aload 5
    //   54: ldc 151
    //   56: invokestatic 157	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   59: invokevirtual 161	android/graphics/Canvas:drawColor	(I)V
    //   62: aload 5
    //   64: aload 4
    //   66: fconst_0
    //   67: fconst_0
    //   68: aconst_null
    //   69: invokevirtual 165	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   72: aload_3
    //   73: astore 4
    //   75: goto +136 -> 211
    //   78: astore 5
    //   80: goto +16 -> 96
    //   83: astore 5
    //   85: goto +70 -> 155
    //   88: astore_3
    //   89: goto +134 -> 223
    //   92: astore 5
    //   94: aconst_null
    //   95: astore_3
    //   96: aload_3
    //   97: astore 4
    //   99: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq +109 -> 211
    //   105: new 173	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   112: astore 4
    //   114: aload 4
    //   116: ldc 177
    //   118: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload 4
    //   124: aload 5
    //   126: invokevirtual 185	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   129: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: ldc 187
    //   135: iconst_2
    //   136: aload 4
    //   138: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: aload 5
    //   146: invokevirtual 196	java/lang/OutOfMemoryError:printStackTrace	()V
    //   149: aload_3
    //   150: astore 4
    //   152: goto +59 -> 211
    //   155: aload_3
    //   156: astore 4
    //   158: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   161: ifeq +50 -> 211
    //   164: new 173	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   171: astore 4
    //   173: aload 4
    //   175: ldc 177
    //   177: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload 4
    //   183: aload 5
    //   185: invokevirtual 197	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   188: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: ldc 187
    //   194: iconst_2
    //   195: aload 4
    //   197: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   203: aload 5
    //   205: invokevirtual 198	java/lang/Exception:printStackTrace	()V
    //   208: aload_3
    //   209: astore 4
    //   211: aload_1
    //   212: iconst_0
    //   213: invokevirtual 120	android/view/View:setDrawingCacheEnabled	(Z)V
    //   216: aload_1
    //   217: invokevirtual 201	android/view/View:destroyDrawingCache	()V
    //   220: aload 4
    //   222: areturn
    //   223: aload_1
    //   224: iconst_0
    //   225: invokevirtual 120	android/view/View:setDrawingCacheEnabled	(Z)V
    //   228: aload_1
    //   229: invokevirtual 201	android/view/View:destroyDrawingCache	()V
    //   232: aload_3
    //   233: athrow
    //   234: aconst_null
    //   235: areturn
    //   236: astore 5
    //   238: aconst_null
    //   239: astore_3
    //   240: goto -85 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	KandianAdPandentView
    //   0	243	1	paramView	View
    //   0	243	2	paramBoolean	boolean
    //   37	36	3	localBitmap	Bitmap
    //   88	1	3	localObject1	Object
    //   95	145	3	localObject2	Object
    //   17	204	4	localObject3	Object
    //   46	17	5	localCanvas	android.graphics.Canvas
    //   78	1	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   83	1	5	localException1	Exception
    //   92	112	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   236	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   38	48	78	java/lang/OutOfMemoryError
    //   52	62	78	java/lang/OutOfMemoryError
    //   62	72	78	java/lang/OutOfMemoryError
    //   38	48	83	java/lang/Exception
    //   52	62	83	java/lang/Exception
    //   62	72	83	java/lang/Exception
    //   13	38	88	finally
    //   38	48	88	finally
    //   52	62	88	finally
    //   62	72	88	finally
    //   99	149	88	finally
    //   158	208	88	finally
    //   13	38	92	java/lang/OutOfMemoryError
    //   13	38	236	java/lang/Exception
  }
  
  @Nullable
  private View a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentWidgetListView;
    if (localObject1 != null)
    {
      int j = ((ListView)localObject1).getFirstVisiblePosition();
      int k = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
      localObject1 = null;
      int i = j;
      for (;;)
      {
        localObject2 = localObject1;
        if (i > k) {
          break;
        }
        localObject2 = localObject1;
        try
        {
          Object localObject4 = this.jdField_a_of_type_ComTencentWidgetListView.getAdapter().getItem(i);
          localObject3 = localObject1;
          localObject2 = localObject1;
          if ((localObject4 instanceof AdvertisementInfo))
          {
            localObject2 = localObject1;
            localObject4 = (AdvertisementInfo)localObject4;
            localObject2 = localObject1;
            Object localObject5 = SuperMaskDataMgr.a.a();
            localObject3 = localObject1;
            localObject2 = localObject1;
            if ((localObject5 instanceof AdvertisementInfo))
            {
              localObject3 = localObject1;
              localObject2 = localObject1;
              if (((AdvertisementInfo)localObject4).mAdAid == ((AdvertisementInfo)localObject5).mAdAid)
              {
                localObject2 = localObject1;
                localObject1 = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i - j);
                localObject2 = localObject1;
                localObject3 = new StringBuilder();
                localObject2 = localObject1;
                ((StringBuilder)localObject3).append("hideAdsWithAnim, find AdvertisementInfo, targetPos=");
                localObject2 = localObject1;
                ((StringBuilder)localObject3).append(i);
                localObject2 = localObject1;
                ((StringBuilder)localObject3).append(", targetItemView=");
                localObject2 = localObject1;
                ((StringBuilder)localObject3).append(localObject1);
                localObject2 = localObject1;
                QLog.d("ReadInJoySuperMaskAd", 2, ((StringBuilder)localObject3).toString());
                return localObject1;
              }
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject3 = localObject2;
          }
        }
        i += 1;
        localObject1 = localObject3;
      }
    }
    localObject2 = null;
    return localObject2;
  }
  
  private void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView != null))
    {
      if (this.jdField_b_of_type_AndroidViewViewGroup == null) {
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
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("audio"));
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return;
        }
        a(this.jdField_a_of_type_JavaLangString);
        return;
      }
      b(this.jdField_a_of_type_JavaLangString);
      return;
    }
    b();
  }
  
  private void b(String paramString)
  {
    a(false);
    g();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySuperMaskAd", 2, new Object[] { "initTVKVideoController with path:", paramString });
    }
    if (!((IVideoPluginInstallFactory)QRoute.api(IVideoPluginInstallFactory.class)).create().a()) {
      QLog.e("ReadInJoySuperMaskAd", 2, "sdk NOT installed");
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper = ((IVideoPlayerWrapperFactory)QRoute.api(IVideoPlayerWrapperFactory.class)).createPlayer(this.jdField_a_of_type_AndroidAppActivity);
    Object localObject = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initNormalVideoPlayer  mVideoPlayerW = ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper);
    ((IRIJAdLogService)localObject).d("ReadInJoySuperMaskAd", localStringBuilder.toString());
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper.b();
    localObject = this.jdField_c_of_type_AndroidViewView;
    if (localObject != null)
    {
      ((View)localObject).setId(2131369556);
      a(this.jdField_a_of_type_AndroidViewViewGroup);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper.b(2);
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper;
    ((IVideoPlayerWrapper)localObject).a(((IVideoPlayerWrapper)localObject).a());
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerMediaPlayListenerAdapter);
    localObject = this.jdField_c_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper.a(null, paramString, 3, 1L, 0L, 0);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper.c(false);
    c();
  }
  
  private void e()
  {
    LayoutInflater.from(getContext()).inflate(2131560223, this, true);
    setId(2131369607);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131372415));
    this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView = ((VPNGImageView)findViewById(2131369553));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372410));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369397));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369394));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369395));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131372416);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131372423);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369590));
    this.jdField_d_of_type_AndroidViewView = findViewById(2131369591);
    ((ImmersiveTitleBar2)findViewById(2131379025)).resetBkColor(0);
    setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  private void f()
  {
    this.jdField_c_of_type_Boolean ^= true;
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130849802));
    } else {
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130849801));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.getVPNGRenderer() != null) && (this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.getVPNGRenderer().a != null) && (this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.getVPNGRenderer().a.isPlaying())) {
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.getVPNGRenderer().a.setVolume(1.0F, 1.0F);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.getVPNGRenderer().a.setVolume(0.0F, 0.0F);
      }
    }
    IVideoPlayerWrapper localIVideoPlayerWrapper = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper;
    if (localIVideoPlayerWrapper != null) {
      localIVideoPlayerWrapper.c(this.jdField_c_of_type_Boolean ^ true);
    }
  }
  
  private void g()
  {
    Object localObject = this.jdField_a_of_type_AndroidMediaAudioManager;
    if (localObject != null) {
      this.jdField_a_of_type_Int = ((AudioManager)localObject).getStreamVolume(3);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("current volume =  ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    QLog.d("ReadInJoySuperMaskAd", 2, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_Float = (this.jdField_a_of_type_Int / 5.0F);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("current volume =  ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append("intervalVolume = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Float);
    QLog.d("ReadInJoySuperMaskAd", 2, ((StringBuilder)localObject).toString());
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject3 = a();
    Object localObject1 = this.jdField_a_of_type_AndroidAppActivity.findViewById(16908307);
    Object localObject2 = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131380365);
    int i = -1;
    int j;
    if (localObject3 != null)
    {
      j = ((View)localObject3).getHeight();
      i = a((View)localObject3, this.jdField_b_of_type_AndroidViewViewGroup);
    }
    else
    {
      j = 0;
    }
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("hideAdsWithAnim, targetFeedsItemTop=");
    ((StringBuilder)localObject4).append(i);
    ((StringBuilder)localObject4).append(", targetFeedsItemHeight=");
    ((StringBuilder)localObject4).append(j);
    QLog.d("ReadInJoySuperMaskAd", 2, ((StringBuilder)localObject4).toString());
    int k;
    if ((i >= 0) && (j > 0)) {
      k = 1;
    } else {
      k = 0;
    }
    if (k != 0)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = a((View)localObject3, false);
      localObject3 = this.jdField_a_of_type_AndroidGraphicsBitmap;
      if (localObject3 != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject3);
        localObject3 = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
        ((ViewGroup.LayoutParams)localObject3).height = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
        this.jdField_a_of_type_AndroidWidgetImageView.requestLayout();
      }
      this.jdField_c_of_type_AndroidGraphicsBitmap = a((View)localObject2, true);
      localObject3 = this.jdField_c_of_type_AndroidGraphicsBitmap;
      if (localObject3 != null)
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject3);
        localObject3 = this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).height = this.jdField_c_of_type_AndroidGraphicsBitmap.getHeight();
        ((ViewGroup.LayoutParams)localObject3).width = this.jdField_c_of_type_AndroidGraphicsBitmap.getWidth();
        this.jdField_c_of_type_AndroidWidgetImageView.setY(((View)localObject2).getY());
        this.jdField_c_of_type_AndroidWidgetImageView.requestLayout();
      }
      this.jdField_b_of_type_AndroidGraphicsBitmap = a((View)localObject1, true);
      localObject2 = this.jdField_b_of_type_AndroidGraphicsBitmap;
      if (localObject2 != null)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
        localObject2 = this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).height = this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight();
        ((ViewGroup.LayoutParams)localObject2).width = this.jdField_b_of_type_AndroidGraphicsBitmap.getWidth();
        this.jdField_b_of_type_AndroidWidgetImageView.setY(((View)localObject1).getY());
        this.jdField_b_of_type_AndroidWidgetImageView.requestLayout();
      }
      i = i + j / 2 - getHeight() / 2;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("hideAdsWithAnim, centerDiff=");
      ((StringBuilder)localObject1).append(i);
      QLog.d("ReadInJoySuperMaskAd", 2, ((StringBuilder)localObject1).toString());
      localObject2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "scaleX", new float[] { 1.2F, 1.0F });
      localObject3 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "scaleY", new float[] { 1.2F, 1.0F });
      localObject4 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "alpha", new float[] { 0.0F, 1.0F });
      localObject1 = this.jdField_a_of_type_AndroidWidgetImageView;
      float f = i;
      Object localObject5 = ObjectAnimator.ofFloat(localObject1, "translationY", new float[] { 0.0F, f });
      localObject1 = new AnimatorSet();
      ((AnimatorSet)localObject1).play((Animator)localObject2).with((Animator)localObject3).with((Animator)localObject4).with((Animator)localObject5);
      ((AnimatorSet)localObject1).setDuration(600L);
      localObject3 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewViewGroup, "alpha", new float[] { 1.0F, 0.0F });
      localObject4 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewViewGroup, "scaleY", new float[] { 1.0F, 0.8F });
      localObject5 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewViewGroup, "scaleY", new float[] { 1.0F, 0.8F });
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewViewGroup, "translationY", new float[] { 0.0F, f });
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
  }
  
  private void i()
  {
    a();
  }
  
  public int a(View paramView1, View paramView2)
  {
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (i > 30) {
        return j;
      }
      j += paramView1.getTop();
      paramView1 = (View)paramView1.getParent();
      if (paramView1 == null) {
        break;
      }
      if (paramView1 == paramView2) {
        return j;
      }
      i += 1;
    }
    return j;
  }
  
  public void a()
  {
    if (getParent() != null) {
      ((ViewGroup)getParent()).removeView(this);
    }
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).setShowing(false);
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).setShowStatus(5);
    Object localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    localObject = this.jdField_a_of_type_ComTencentImageURLDrawable;
    if (localObject != null)
    {
      localObject = ((URLDrawable)localObject).getCurrDrawable();
      if ((localObject instanceof ApngDrawable))
      {
        localObject = (ApngDrawable)localObject;
        ((ApngDrawable)localObject).removeOnPlayRepeatListener(this.jdField_a_of_type_ComTencentImageApngDrawable$OnPlayRepeatListener);
        ((ApngDrawable)localObject).setOnPlayRepeatListener(null);
      }
    }
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = SuperMaskConfigMgr.a.a(((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).getChannelID());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("currentTime = ");
    ((StringBuilder)localObject).append(l1);
    ((StringBuilder)localObject).append(" lastShowMaskTime = ");
    ((StringBuilder)localObject).append(l2);
    QLog.d("ReadInJoySuperMaskAd", 1, ((StringBuilder)localObject).toString());
    if (SuperMaskReportMgr.a.a())
    {
      if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
        SuperMaskReportMgr.a.a(1, SuperMaskDataMgr.a.a());
      }
    }
    else {
      QLog.d("ReadInJoySuperMaskAd", 1, "exposure time is less than one second, do not report strict");
    }
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).setShowStatus(5);
    localObject = this.jdField_a_of_type_ComTencentWidgetListView;
    if (localObject != null)
    {
      localObject = ((ListView)localObject).getAdapter();
      if ((localObject instanceof HeaderViewListAdapter))
      {
        localObject = ((HeaderViewListAdapter)localObject).getWrappedAdapter();
        if ((localObject instanceof IReadInJoyBaseAdapter)) {
          ((IReadInJoyBaseAdapter)localObject).a(this.jdField_a_of_type_ComTencentWidgetListView, 0);
        }
      }
    }
    localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView;
    if (localObject != null) {
      ((VPNGImageView)localObject).onRelease();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper;
    if (localObject != null)
    {
      ((IVideoPlayerWrapper)localObject).g();
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper.h();
    }
    localObject = this.jdField_a_of_type_AndroidMediaAudioManager;
    if (localObject != null) {
      try
      {
        ((AudioManager)localObject).setStreamVolume(3, this.jdField_a_of_type_Int, 4);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("audioManager setStreamVolume error :");
          localStringBuilder.append(localException.toString());
          QLog.i("KandianAdPandentMask", 2, localStringBuilder.toString());
        }
      }
    }
    SuperMaskReportMgr.a.a("showMaskEnd", "");
    SuperMaskDataMgr.a.a();
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).resetUIMgr();
  }
  
  public void a(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 0))
    {
      if (this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131369607) == null)
      {
        b(paramInt);
        this.jdField_b_of_type_AndroidViewViewGroup.addView(this);
      }
      ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).setShowing(true);
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
        SuperMaskReportMgr.a.a(2, SuperMaskDataMgr.a.a());
      }
      ThreadManager.getUIHandler().postDelayed(new KandianAdPandentMask.KandianAdPandentView.3(this), 1000L);
      return;
    }
    SuperMaskReportMgr.a.a("invalidTypeWithAttach", "");
    KandianAdPandentMask.a(SuperMaskDataMgr.a.a());
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
      localLayoutParams.addRule(18, 2131369590);
    }
    paramViewGroup.addView(this.jdField_d_of_type_AndroidViewView, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(1, 1);
    localLayoutParams.height = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 26.0F);
    localLayoutParams.width = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 26.0F);
    localLayoutParams.rightMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 2.0F);
    localLayoutParams.addRule(6, 2131369590);
    localLayoutParams.addRule(8, 2131369590);
    localLayoutParams.addRule(0, 2131369590);
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
    if (this.jdField_a_of_type_Int != 0)
    {
      if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidMediaAudioManager.setStreamVolume(3, 0, 4);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  public void d()
  {
    Object localObject = this.jdField_a_of_type_AndroidMediaAudioManager;
    if (localObject != null)
    {
      int i = ((AudioManager)localObject).getStreamVolume(3);
      if (i >= this.jdField_a_of_type_Int)
      {
        this.jdField_d_of_type_Boolean = false;
        return;
      }
      i = (int)Math.ceil(i + this.jdField_a_of_type_Float);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateVolume setVolume =  ");
      ((StringBuilder)localObject).append(i);
      QLog.d("ReadInJoySuperMaskAd", 2, ((StringBuilder)localObject).toString());
      this.jdField_a_of_type_AndroidMediaAudioManager.setStreamVolume(3, i, 4);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = SuperMaskDataMgr.a.a();
    if (!(localObject1 instanceof AdvertisementInfo)) {
      return;
    }
    AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)localObject1;
    localObject1 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("click data is : ");
    ((StringBuilder)localObject2).append(localAdvertisementInfo.hashCode());
    ((IRIJAdLogService)localObject1).d("ReadInJoySuperMaskAd", ((StringBuilder)localObject2).toString());
    localObject1 = localAdvertisementInfo.clone();
    if ((localObject1 instanceof AdvertisementInfo))
    {
      localObject1 = (AdvertisementInfo)localObject1;
      if (((AdvertisementInfo)localObject1).mAdAid == localAdvertisementInfo.mAdAid)
      {
        localObject2 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("clone data is : ");
        localStringBuilder.append(localObject1.hashCode());
        ((IRIJAdLogService)localObject2).d("ReadInJoySuperMaskAd", localStringBuilder.toString());
        break label175;
      }
    }
    localObject1 = localAdvertisementInfo;
    label175:
    int i = paramView.getId();
    localObject2 = "0";
    switch (i)
    {
    default: 
      return;
    case 2131372410: 
      if (this.jdField_c_of_type_Boolean)
      {
        localAdvertisementInfo.mAdvertisementExtInfo.g = "0";
        SuperMaskReportMgr.a.b(27, localObject1);
      }
      else
      {
        localAdvertisementInfo.mAdvertisementExtInfo.g = "1";
        SuperMaskReportMgr.a.b(28, localObject1);
      }
      f();
      return;
    case 2131369607: 
      SuperMaskReportMgr.a.b(1, localObject1);
      if (SuperMaskReportMgr.a.a()) {
        paramView = "clickMask";
      } else {
        paramView = "clickMaskNoExpose";
      }
      SuperMaskReportMgr.a.a(paramView, ((AdvertisementInfo)localObject1).mAdTraceId);
      localObject1 = localAdvertisementInfo.mAdvertisementExtInfo;
      paramView = (View)localObject2;
      if (this.jdField_c_of_type_Boolean) {
        paramView = "1";
      }
      ((AdvertisementExtInfo)localObject1).g = paramView;
      localObject1 = null;
      localObject2 = this.jdField_a_of_type_ComTencentWidgetListView;
      paramView = (View)localObject1;
      if (localObject2 != null)
      {
        paramView = (View)localObject1;
        if (((ListView)localObject2).getAdapter() != null)
        {
          paramView = (View)localObject1;
          if ((this.jdField_a_of_type_ComTencentWidgetListView.getAdapter() instanceof HeaderViewListAdapter))
          {
            localObject2 = (HeaderViewListAdapter)this.jdField_a_of_type_ComTencentWidgetListView.getAdapter();
            paramView = (View)localObject1;
            if (((HeaderViewListAdapter)localObject2).getWrappedAdapter() != null)
            {
              paramView = (View)localObject1;
              if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isReadInJoyArticleAdapter(((HeaderViewListAdapter)localObject2).getWrappedAdapter()))
              {
                localObject1 = (IReadInJoyBaseAdapter)((HeaderViewListAdapter)localObject2).getWrappedAdapter();
                paramView = (View)localObject1;
                if (localObject1 != null)
                {
                  ((IReadInJoyBaseAdapter)localObject1).a(((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).getAdInfoParams(getContext(), localAdvertisementInfo, (IReadInJoyBaseAdapter)localObject1, 0, false, null));
                  long l;
                  if (((IReadInJoyBaseAdapter)localObject1).a() != null) {
                    l = SystemClock.elapsedRealtime();
                  } else {
                    l = -2147483648L;
                  }
                  ((IReadInJoyBaseAdapter)localObject1).a(l);
                  paramView = (View)localObject1;
                }
              }
            }
          }
        }
      }
      localAdvertisementInfo.clickPos = 11;
      ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).doActionAndReport(this.jdField_a_of_type_AndroidAppActivity, localAdvertisementInfo, paramView, 0, false, false, null);
      com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoySuperMaskAdUtil.jdField_a_of_type_Boolean = false;
      paramView = this.jdField_a_of_type_ComTencentImageURLDrawable;
      if (paramView != null) {
        paramView.pauseVideo();
      }
      i();
      return;
    }
    SuperMaskReportMgr.a.b(26, localObject1);
    if (SuperMaskReportMgr.a.a()) {
      paramView = "skipMask";
    } else {
      paramView = "skipMaskNoExpose";
    }
    SuperMaskReportMgr.a.a(paramView, ((AdvertisementInfo)localObject1).mAdTraceId);
    paramView = this.jdField_a_of_type_ComTencentImageURLDrawable;
    if (paramView != null) {
      paramView.pauseVideo();
    }
    this.jdField_c_of_type_Boolean = false;
    f();
    h();
  }
  
  public void setViewVisibility(int paramInt)
  {
    setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.KandianAdPandentMask.KandianAdPandentView
 * JD-Core Version:    0.7.0.1
 */