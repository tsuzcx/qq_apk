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
  private long A = 0L;
  private IVideoPlayerWrapper B;
  private MediaPlayListenerAdapter C = new KandianAdPandentMask.KandianAdPandentView.1(this);
  @Nullable
  private AudioManager D;
  private Handler E = new Handler(new KandianAdPandentMask.KandianAdPandentView.2(this));
  private AtomicBoolean F = new AtomicBoolean(false);
  private AtomicBoolean G = new AtomicBoolean(false);
  private Activity a;
  private ViewGroup b;
  @Nullable
  private URLDrawable c;
  private ApngDrawable.OnPlayRepeatListener d;
  @Nullable
  private ListView e;
  private ViewGroup f;
  @Nullable
  private Bitmap g;
  private ImageView h;
  private Bitmap i;
  private ImageView j;
  private Bitmap k;
  private ImageView l;
  private View m;
  private View n;
  private VPNGImageView o;
  private View p;
  private ImageView q;
  private TextView r;
  private View s;
  private boolean t = false;
  private int u = 0;
  private float v = 0.0F;
  private String w;
  private boolean x = false;
  private boolean y = true;
  private boolean z = true;
  
  public KandianAdPandentMask$KandianAdPandentView(Activity paramActivity, @Nullable ListView paramListView, String paramString)
  {
    super(paramActivity);
    this.a = paramActivity;
    this.e = paramListView;
    this.f = ((ViewGroup)paramActivity.getWindow().getDecorView());
    this.w = paramString;
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
    //   6: invokevirtual 146	android/view/View:setDrawingCacheEnabled	(Z)V
    //   9: aload_1
    //   10: invokevirtual 149	android/view/View:buildDrawingCache	()V
    //   13: aload_1
    //   14: invokevirtual 153	android/view/View:getDrawingCache	()Landroid/graphics/Bitmap;
    //   17: astore 4
    //   19: aload 4
    //   21: invokevirtual 159	android/graphics/Bitmap:getWidth	()I
    //   24: aload 4
    //   26: invokevirtual 162	android/graphics/Bitmap:getHeight	()I
    //   29: aload 4
    //   31: invokevirtual 166	android/graphics/Bitmap:getConfig	()Landroid/graphics/Bitmap$Config;
    //   34: invokestatic 170	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   37: astore_3
    //   38: new 172	android/graphics/Canvas
    //   41: dup
    //   42: aload_3
    //   43: invokespecial 175	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   46: astore 5
    //   48: iload_2
    //   49: ifne +13 -> 62
    //   52: aload 5
    //   54: ldc 177
    //   56: invokestatic 183	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   59: invokevirtual 187	android/graphics/Canvas:drawColor	(I)V
    //   62: aload 5
    //   64: aload 4
    //   66: fconst_0
    //   67: fconst_0
    //   68: aconst_null
    //   69: invokevirtual 191	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
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
    //   99: invokestatic 197	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq +109 -> 211
    //   105: new 199	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   112: astore 4
    //   114: aload 4
    //   116: ldc 203
    //   118: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload 4
    //   124: aload 5
    //   126: invokevirtual 211	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   129: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: ldc 213
    //   135: iconst_2
    //   136: aload 4
    //   138: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: aload 5
    //   146: invokevirtual 222	java/lang/OutOfMemoryError:printStackTrace	()V
    //   149: aload_3
    //   150: astore 4
    //   152: goto +59 -> 211
    //   155: aload_3
    //   156: astore 4
    //   158: invokestatic 197	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   161: ifeq +50 -> 211
    //   164: new 199	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   171: astore 4
    //   173: aload 4
    //   175: ldc 203
    //   177: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload 4
    //   183: aload 5
    //   185: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   188: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: ldc 213
    //   194: iconst_2
    //   195: aload 4
    //   197: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 219	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   203: aload 5
    //   205: invokevirtual 224	java/lang/Exception:printStackTrace	()V
    //   208: aload_3
    //   209: astore 4
    //   211: aload_1
    //   212: iconst_0
    //   213: invokevirtual 146	android/view/View:setDrawingCacheEnabled	(Z)V
    //   216: aload_1
    //   217: invokevirtual 227	android/view/View:destroyDrawingCache	()V
    //   220: aload 4
    //   222: areturn
    //   223: aload_1
    //   224: iconst_0
    //   225: invokevirtual 146	android/view/View:setDrawingCacheEnabled	(Z)V
    //   228: aload_1
    //   229: invokevirtual 227	android/view/View:destroyDrawingCache	()V
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
  
  private void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.o != null))
    {
      if (this.f == null) {
        return;
      }
      a(false);
      this.o.setVisibility(0);
      g();
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)(this.f.getWidth() * 1.778F));
      localLayoutParams.addRule(13, -1);
      this.o.setLayoutParams(localLayoutParams);
      this.o.setVideo(paramString, false, 1, new KandianAdPandentMask.KandianAdPandentView.4(this));
      c();
    }
  }
  
  private void b(int paramInt)
  {
    this.D = ((AudioManager)this.a.getSystemService("audio"));
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return;
        }
        a(this.w);
        return;
      }
      b(this.w);
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
    if (!((IVideoPluginInstallFactory)QRoute.api(IVideoPluginInstallFactory.class)).create().b()) {
      QLog.e("ReadInJoySuperMaskAd", 2, "sdk NOT installed");
    }
    this.B = ((IVideoPlayerWrapperFactory)QRoute.api(IVideoPlayerWrapperFactory.class)).createPlayer(this.a);
    Object localObject = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initNormalVideoPlayer  mVideoPlayerW = ");
    localStringBuilder.append(this.B);
    ((IRIJAdLogService)localObject).d("ReadInJoySuperMaskAd", localStringBuilder.toString());
    this.p = this.B.e();
    localObject = this.p;
    if (localObject != null)
    {
      ((View)localObject).setId(2131436659);
      a(this.b);
    }
    this.B.b(2);
    localObject = this.B;
    ((IVideoPlayerWrapper)localObject).a(((IVideoPlayerWrapper)localObject).c());
    this.B.a(this.C);
    localObject = this.p;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    this.B.a(null, paramString, 3, 1L, 0L, 0);
    this.B.g(false);
    c();
  }
  
  private void e()
  {
    LayoutInflater.from(getContext()).inflate(2131626270, this, true);
    setId(2131436715);
    this.b = ((ViewGroup)findViewById(2131439937));
    this.o = ((VPNGImageView)findViewById(2131436656));
    this.q = ((ImageView)findViewById(2131439932));
    this.h = ((ImageView)findViewById(2131436430));
    this.l = ((ImageView)findViewById(2131436427));
    this.j = ((ImageView)findViewById(2131436428));
    this.m = findViewById(2131439938);
    this.n = findViewById(2131439945);
    this.r = ((TextView)findViewById(2131436698));
    this.s = findViewById(2131436699);
    ((ImmersiveTitleBar2)findViewById(2131447747)).resetBkColor(0);
    setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.q.setOnClickListener(this);
  }
  
  private void f()
  {
    this.y ^= true;
    if (this.y) {
      this.q.setImageDrawable(this.a.getResources().getDrawable(2130851507));
    } else {
      this.q.setImageDrawable(this.a.getResources().getDrawable(2130851506));
    }
    if ((this.o.getVPNGRenderer() != null) && (this.o.getVPNGRenderer().e != null) && (this.o.getVPNGRenderer().e.isPlaying())) {
      if (this.y) {
        this.o.getVPNGRenderer().e.setVolume(1.0F, 1.0F);
      } else {
        this.o.getVPNGRenderer().e.setVolume(0.0F, 0.0F);
      }
    }
    IVideoPlayerWrapper localIVideoPlayerWrapper = this.B;
    if (localIVideoPlayerWrapper != null) {
      localIVideoPlayerWrapper.g(this.y ^ true);
    }
  }
  
  private void g()
  {
    Object localObject = this.D;
    if (localObject != null) {
      this.u = ((AudioManager)localObject).getStreamVolume(3);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("current volume =  ");
    ((StringBuilder)localObject).append(this.u);
    QLog.d("ReadInJoySuperMaskAd", 2, ((StringBuilder)localObject).toString());
    this.v = (this.u / 5.0F);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("current volume =  ");
    ((StringBuilder)localObject).append(this.u);
    ((StringBuilder)localObject).append("intervalVolume = ");
    ((StringBuilder)localObject).append(this.v);
    QLog.d("ReadInJoySuperMaskAd", 2, ((StringBuilder)localObject).toString());
  }
  
  private void h()
  {
    if (this.t) {
      return;
    }
    Object localObject3 = j();
    Object localObject1 = this.a.findViewById(16908307);
    Object localObject2 = this.a.findViewById(2131449311);
    int i1 = -1;
    int i2;
    if (localObject3 != null)
    {
      i2 = ((View)localObject3).getHeight();
      i1 = a((View)localObject3, this.f);
    }
    else
    {
      i2 = 0;
    }
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("hideAdsWithAnim, targetFeedsItemTop=");
    ((StringBuilder)localObject4).append(i1);
    ((StringBuilder)localObject4).append(", targetFeedsItemHeight=");
    ((StringBuilder)localObject4).append(i2);
    QLog.d("ReadInJoySuperMaskAd", 2, ((StringBuilder)localObject4).toString());
    int i3;
    if ((i1 >= 0) && (i2 > 0)) {
      i3 = 1;
    } else {
      i3 = 0;
    }
    if (i3 != 0)
    {
      this.g = a((View)localObject3, false);
      localObject3 = this.g;
      if (localObject3 != null)
      {
        this.h.setImageBitmap((Bitmap)localObject3);
        localObject3 = this.h.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = this.g.getWidth();
        ((ViewGroup.LayoutParams)localObject3).height = this.g.getHeight();
        this.h.requestLayout();
      }
      this.k = a((View)localObject2, true);
      localObject3 = this.k;
      if (localObject3 != null)
      {
        this.l.setImageBitmap((Bitmap)localObject3);
        localObject3 = this.l.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).height = this.k.getHeight();
        ((ViewGroup.LayoutParams)localObject3).width = this.k.getWidth();
        this.l.setY(((View)localObject2).getY());
        this.l.requestLayout();
      }
      this.i = a((View)localObject1, true);
      localObject2 = this.i;
      if (localObject2 != null)
      {
        this.j.setImageBitmap((Bitmap)localObject2);
        localObject2 = this.j.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).height = this.i.getHeight();
        ((ViewGroup.LayoutParams)localObject2).width = this.i.getWidth();
        this.j.setY(((View)localObject1).getY());
        this.j.requestLayout();
      }
      i1 = i1 + i2 / 2 - getHeight() / 2;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("hideAdsWithAnim, centerDiff=");
      ((StringBuilder)localObject1).append(i1);
      QLog.d("ReadInJoySuperMaskAd", 2, ((StringBuilder)localObject1).toString());
      localObject2 = ObjectAnimator.ofFloat(this.h, "scaleX", new float[] { 1.2F, 1.0F });
      localObject3 = ObjectAnimator.ofFloat(this.h, "scaleY", new float[] { 1.2F, 1.0F });
      localObject4 = ObjectAnimator.ofFloat(this.h, "alpha", new float[] { 0.0F, 1.0F });
      localObject1 = this.h;
      float f1 = i1;
      Object localObject5 = ObjectAnimator.ofFloat(localObject1, "translationY", new float[] { 0.0F, f1 });
      localObject1 = new AnimatorSet();
      ((AnimatorSet)localObject1).play((Animator)localObject2).with((Animator)localObject3).with((Animator)localObject4).with((Animator)localObject5);
      ((AnimatorSet)localObject1).setDuration(600L);
      localObject3 = ObjectAnimator.ofFloat(this.b, "alpha", new float[] { 1.0F, 0.0F });
      localObject4 = ObjectAnimator.ofFloat(this.b, "scaleY", new float[] { 1.0F, 0.8F });
      localObject5 = ObjectAnimator.ofFloat(this.b, "scaleY", new float[] { 1.0F, 0.8F });
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.b, "translationY", new float[] { 0.0F, f1 });
      localObject2 = new AnimatorSet();
      ((AnimatorSet)localObject2).play((Animator)localObject3).with(localObjectAnimator).with((Animator)localObject4).with((Animator)localObject5);
      ((AnimatorSet)localObject2).setDuration(600L);
      localObject3 = ObjectAnimator.ofFloat(this.n, "alpha", new float[] { 0.5F, 0.0F });
      ((ObjectAnimator)localObject3).setDuration(600L);
      localObject5 = ObjectAnimator.ofFloat(this.m, "alpha", new float[] { 1.0F, 0.0F });
      localObject4 = new AnimatorSet();
      ((AnimatorSet)localObject4).play((Animator)localObject5).after(150L);
      ((AnimatorSet)localObject4).setDuration(150L);
      localObject5 = new AnimatorSet();
      ((AnimatorSet)localObject5).setInterpolator(new AccelerateDecelerateInterpolator());
      ((AnimatorSet)localObject5).playTogether(new Animator[] { localObject1, localObject2, localObject3, localObject4 });
      ((AnimatorSet)localObject5).start();
      this.t = true;
      ((AnimatorSet)localObject5).addListener(new KandianAdPandentMask.KandianAdPandentView.5(this));
      return;
    }
    i();
  }
  
  private void i()
  {
    a();
  }
  
  @Nullable
  private View j()
  {
    Object localObject1 = this.e;
    if (localObject1 != null)
    {
      int i2 = ((ListView)localObject1).getFirstVisiblePosition();
      int i3 = this.e.getLastVisiblePosition();
      localObject1 = null;
      int i1 = i2;
      for (;;)
      {
        localObject2 = localObject1;
        if (i1 > i3) {
          break;
        }
        localObject2 = localObject1;
        try
        {
          Object localObject4 = this.e.getAdapter().getItem(i1);
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
                localObject1 = this.e.getChildAt(i1 - i2);
                localObject2 = localObject1;
                localObject3 = new StringBuilder();
                localObject2 = localObject1;
                ((StringBuilder)localObject3).append("hideAdsWithAnim, find AdvertisementInfo, targetPos=");
                localObject2 = localObject1;
                ((StringBuilder)localObject3).append(i1);
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
        i1 += 1;
        localObject1 = localObject3;
      }
    }
    localObject2 = null;
    return localObject2;
  }
  
  public int a(View paramView1, View paramView2)
  {
    int i1 = 0;
    int i2 = 0;
    for (;;)
    {
      if (i1 > 30) {
        return i2;
      }
      i2 += paramView1.getTop();
      paramView1 = (View)paramView1.getParent();
      if (paramView1 == null) {
        break;
      }
      if (paramView1 == paramView2) {
        return i2;
      }
      i1 += 1;
    }
    return i2;
  }
  
  public void a()
  {
    if (getParent() != null) {
      ((ViewGroup)getParent()).removeView(this);
    }
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).setShowing(false);
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).setShowStatus(5);
    Object localObject = this.g;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
      this.g.recycle();
    }
    localObject = this.c;
    if (localObject != null)
    {
      localObject = ((URLDrawable)localObject).getCurrDrawable();
      if ((localObject instanceof ApngDrawable))
      {
        localObject = (ApngDrawable)localObject;
        ((ApngDrawable)localObject).removeOnPlayRepeatListener(this.d);
        ((ApngDrawable)localObject).setOnPlayRepeatListener(null);
      }
    }
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = SuperMaskConfigMgr.a.c(((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).getChannelID());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("currentTime = ");
    ((StringBuilder)localObject).append(l1);
    ((StringBuilder)localObject).append(" lastShowMaskTime = ");
    ((StringBuilder)localObject).append(l2);
    QLog.d("ReadInJoySuperMaskAd", 1, ((StringBuilder)localObject).toString());
    if (SuperMaskReportMgr.a.b())
    {
      if (this.G.compareAndSet(false, true)) {
        SuperMaskReportMgr.a.a(1, SuperMaskDataMgr.a.a());
      }
    }
    else {
      QLog.d("ReadInJoySuperMaskAd", 1, "exposure time is less than one second, do not report strict");
    }
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).setShowStatus(5);
    localObject = this.e;
    if (localObject != null)
    {
      localObject = ((ListView)localObject).getAdapter();
      if ((localObject instanceof HeaderViewListAdapter))
      {
        localObject = ((HeaderViewListAdapter)localObject).getWrappedAdapter();
        if ((localObject instanceof IReadInJoyBaseAdapter)) {
          ((IReadInJoyBaseAdapter)localObject).a(this.e, 0);
        }
      }
    }
    localObject = this.E;
    if (localObject != null)
    {
      ((Handler)localObject).removeMessages(1);
      this.E = null;
    }
    localObject = this.o;
    if (localObject != null) {
      ((VPNGImageView)localObject).onRelease();
    }
    localObject = this.B;
    if (localObject != null)
    {
      ((IVideoPlayerWrapper)localObject).x();
      this.B.y();
    }
    localObject = this.D;
    if (localObject != null) {
      try
      {
        ((AudioManager)localObject).setStreamVolume(3, this.u, 4);
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
    SuperMaskDataMgr.a.f();
    ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).resetUIMgr();
  }
  
  public void a(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 0))
    {
      if (this.f.findViewById(2131436715) == null)
      {
        b(paramInt);
        this.f.addView(this);
      }
      ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).setShowing(true);
      if (this.F.compareAndSet(false, true)) {
        SuperMaskReportMgr.a.a(2, SuperMaskDataMgr.a.a());
      }
      ThreadManager.getUIHandler().postDelayed(new KandianAdPandentMask.KandianAdPandentView.3(this), 1000L);
      return;
    }
    SuperMaskReportMgr.a.a("invalidTypeWithAttach", "");
    KandianAdPandentMask.a(SuperMaskDataMgr.a.b());
  }
  
  public void a(View paramView)
  {
    if ((paramView.getParent() != null) && ((paramView.getParent() instanceof ViewGroup))) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    a(this.p);
    a(this.q);
    a(this.r);
    a(this.s);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(1, 1);
    localLayoutParams.height = -1;
    localLayoutParams.width = -1;
    localLayoutParams.addRule(13, -1);
    paramViewGroup.addView(this.p, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(1, 1);
    localLayoutParams.height = DisplayUtil.a(this.a, 27.0F);
    localLayoutParams.width = DisplayUtil.a(this.a, 72.0F);
    localLayoutParams.rightMargin = DisplayUtil.a(this.a, 20.0F);
    localLayoutParams.topMargin = DisplayUtil.a(this.a, 60.0F);
    localLayoutParams.addRule(11, -1);
    paramViewGroup.addView(this.r, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(1, 1);
    localLayoutParams.height = DisplayUtil.a(this.a, 52.0F);
    localLayoutParams.width = DisplayUtil.a(this.a, 90.0F);
    localLayoutParams.rightMargin = 0;
    localLayoutParams.topMargin = DisplayUtil.a(this.a, 45.0F);
    localLayoutParams.addRule(11, -1);
    if (Build.VERSION.SDK_INT >= 17) {
      localLayoutParams.addRule(18, 2131436698);
    }
    paramViewGroup.addView(this.s, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(1, 1);
    localLayoutParams.height = DisplayUtil.a(this.a, 26.0F);
    localLayoutParams.width = DisplayUtil.a(this.a, 26.0F);
    localLayoutParams.rightMargin = DisplayUtil.a(this.a, 2.0F);
    localLayoutParams.addRule(6, 2131436698);
    localLayoutParams.addRule(8, 2131436698);
    localLayoutParams.addRule(0, 2131436698);
    paramViewGroup.addView(this.q, localLayoutParams);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    this.q.setVisibility(0);
    this.r.setVisibility(0);
    this.s.setVisibility(0);
  }
  
  void b() {}
  
  public void c()
  {
    if (this.u != 0)
    {
      if (this.D == null) {
        return;
      }
      this.E.removeMessages(1);
      this.D.setStreamVolume(3, 0, 4);
      this.A = System.currentTimeMillis();
      this.E.sendEmptyMessage(1);
    }
  }
  
  public void d()
  {
    Object localObject = this.D;
    if (localObject != null)
    {
      int i1 = ((AudioManager)localObject).getStreamVolume(3);
      if (i1 >= this.u)
      {
        this.z = false;
        return;
      }
      i1 = (int)Math.ceil(i1 + this.v);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateVolume setVolume =  ");
      ((StringBuilder)localObject).append(i1);
      QLog.d("ReadInJoySuperMaskAd", 2, ((StringBuilder)localObject).toString());
      this.D.setStreamVolume(3, i1, 4);
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
    int i1 = paramView.getId();
    localObject2 = "0";
    switch (i1)
    {
    default: 
      return;
    case 2131439932: 
      if (this.y)
      {
        localAdvertisementInfo.mAdvertisementExtInfo.D = "0";
        SuperMaskReportMgr.a.b(27, localObject1);
      }
      else
      {
        localAdvertisementInfo.mAdvertisementExtInfo.D = "1";
        SuperMaskReportMgr.a.b(28, localObject1);
      }
      f();
      return;
    case 2131436715: 
      SuperMaskReportMgr.a.b(1, localObject1);
      if (SuperMaskReportMgr.a.b()) {
        paramView = "clickMask";
      } else {
        paramView = "clickMaskNoExpose";
      }
      SuperMaskReportMgr.a.a(paramView, ((AdvertisementInfo)localObject1).mAdTraceId);
      localObject1 = localAdvertisementInfo.mAdvertisementExtInfo;
      paramView = (View)localObject2;
      if (this.y) {
        paramView = "1";
      }
      ((AdvertisementExtInfo)localObject1).D = paramView;
      localObject1 = null;
      localObject2 = this.e;
      paramView = (View)localObject1;
      if (localObject2 != null)
      {
        paramView = (View)localObject1;
        if (((ListView)localObject2).getAdapter() != null)
        {
          paramView = (View)localObject1;
          if ((this.e.getAdapter() instanceof HeaderViewListAdapter))
          {
            localObject2 = (HeaderViewListAdapter)this.e.getAdapter();
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
                  long l1;
                  if (((IReadInJoyBaseAdapter)localObject1).g() != null) {
                    l1 = SystemClock.elapsedRealtime();
                  } else {
                    l1 = -2147483648L;
                  }
                  ((IReadInJoyBaseAdapter)localObject1).a(l1);
                  paramView = (View)localObject1;
                }
              }
            }
          }
        }
      }
      localAdvertisementInfo.clickPos = 11;
      ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).doActionAndReport(this.a, localAdvertisementInfo, paramView, 0, false, false, null);
      com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoySuperMaskAdUtil.a = false;
      paramView = this.c;
      if (paramView != null) {
        paramView.pauseVideo();
      }
      i();
      return;
    }
    SuperMaskReportMgr.a.b(26, localObject1);
    if (SuperMaskReportMgr.a.b()) {
      paramView = "skipMask";
    } else {
      paramView = "skipMaskNoExpose";
    }
    SuperMaskReportMgr.a.a(paramView, ((AdvertisementInfo)localObject1).mAdTraceId);
    paramView = this.c;
    if (paramView != null) {
      paramView.pauseVideo();
    }
    this.y = false;
    f();
    h();
  }
  
  public void setViewVisibility(int paramInt)
  {
    setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.KandianAdPandentMask.KandianAdPandentView
 * JD-Core Version:    0.7.0.1
 */