package com.tencent.biz.pubaccount.Advertisement.view;

import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoCoverItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.kandian.base.view.widget.ResizeURLImageView;
import com.tencent.mqpsdk.util.NetUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.net.URL;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class VideoCoverView
  extends RelativeLayout
{
  public int a;
  public long a;
  private AnimatorListenerAdapter jdField_a_of_type_AndroidAnimationAnimatorListenerAdapter = null;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator = null;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private View jdField_a_of_type_AndroidViewView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private AdvertisementItem jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem;
  private AdvertisementSplitedProgressBar jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar;
  private VideoCoverView.RotateAnimaterListener jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView$RotateAnimaterListener = null;
  private TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  private ResizeURLImageView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetResizeURLImageView;
  private TVK_IMediaPlayer.OnCompletionListener jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer$OnCompletionListener;
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  public TVK_PlayerVideoInfo a;
  public TVK_UserInfo a;
  Runnable jdField_a_of_type_JavaLangRunnable = new VideoCoverView.11(this);
  public String a;
  private ArrayList<VideoCoverItem> jdField_a_of_type_JavaUtilArrayList;
  public boolean a;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = 0L;
  private View jdField_b_of_type_AndroidViewView;
  public boolean b;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean = false;
  private boolean f = false;
  
  public VideoCoverView(Context paramContext, VideoCoverItem paramVideoCoverItem, int paramInt, AdvertisementSplitedProgressBar paramAdvertisementSplitedProgressBar, TVK_IMediaPlayer.OnCompletionListener paramOnCompletionListener, ArrayList<VideoCoverItem> paramArrayList, AdvertisementItem paramAdvertisementItem, TroopMemberApiClient paramTroopMemberApiClient)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    LayoutInflater.from(getContext()).inflate(2131559590, this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131380644));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetResizeURLImageView = ((ResizeURLImageView)findViewById(2131380563));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131370396);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131366460);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new VideoCoverView.1(this, paramContext));
    this.jdField_d_of_type_AndroidViewView = findViewById(2131377910);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(new VideoCoverView.2(this));
    this.jdField_c_of_type_Int = paramVideoCoverItem.jdField_a_of_type_Int;
    this.jdField_a_of_type_JavaLangString = paramVideoCoverItem.b;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar = paramAdvertisementSplitedProgressBar;
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer$OnCompletionListener = paramOnCompletionListener;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar.setTotalCount(this.jdField_b_of_type_Int);
    paramContext = getResources().getDisplayMetrics();
    this.jdField_e_of_type_Int = paramContext.widthPixels;
    this.jdField_d_of_type_Int = paramContext.heightPixels;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem = paramAdvertisementItem;
    this.jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = paramTroopMemberApiClient;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(1000L);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView$RotateAnimaterListener = new VideoCoverView.RotateAnimaterListener(this);
    this.jdField_a_of_type_AndroidAnimationAnimatorListenerAdapter = new VideoCoverView.3(this);
    if (this.jdField_c_of_type_Boolean)
    {
      paramContext = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetResizeURLImageView.getLayoutParams();
      paramInt = this.jdField_e_of_type_Int;
      paramContext.width = paramInt;
      paramContext.height = ((int)(paramInt * 0.5626F));
    }
    if (!TextUtils.isEmpty(paramVideoCoverItem.jdField_a_of_type_JavaLangString)) {
      try
      {
        paramContext = new URL(paramVideoCoverItem.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetResizeURLImageView.setImage(paramContext);
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (!VideoCoverFragment.jdField_b_of_type_Boolean)
    {
      b(paramBoolean);
      return;
    }
    if (VideoCoverFragment.jdField_a_of_type_Boolean)
    {
      b(this.jdField_a_of_type_AndroidContentContext);
      return;
    }
    b(paramBoolean);
  }
  
  private void b(boolean paramBoolean)
  {
    boolean bool = AdvertisementVideoPreloadManager.a(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" playByNet hasCache:");
      localStringBuilder.append(bool);
      localStringBuilder.append(" isStop");
      localStringBuilder.append(paramBoolean);
      QLog.d("VideoCoverView", 2, localStringBuilder.toString());
    }
    if (bool)
    {
      b(this.jdField_a_of_type_AndroidContentContext);
      return;
    }
    int i = NetUtil.a(null);
    if (i == 0)
    {
      FMToastUtil.a(2131689586);
      this.jdField_a_of_type_Int = 6;
      g();
      return;
    }
    if (i == 1)
    {
      if ((paramBoolean) && (this.jdField_a_of_type_Int == 5))
      {
        d();
        return;
      }
      b(this.jdField_a_of_type_AndroidContentContext);
      return;
    }
    a();
  }
  
  private void c(Context paramContext)
  {
    this.jdField_a_of_type_Int = 1;
    ThreadManager.post(new VideoCoverView.5(this, paramContext), 2, null, false);
  }
  
  private void d(Context paramContext)
  {
    QLog.i("VideoCoverView", 1, "initVideo");
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    Object localObject = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
    if (localObject != null)
    {
      this.jdField_a_of_type_AndroidViewView = ((View)((TVK_IProxyFactory)localObject).createVideoView_Scroll(paramContext));
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject != null)
      {
        ((View)localObject).setBackgroundColor(-16777216);
        if (this.jdField_c_of_type_Boolean)
        {
          int i = this.jdField_e_of_type_Int;
          localObject = new RelativeLayout.LayoutParams(i, (int)(i * 0.5626F));
        }
        else
        {
          localObject = new RelativeLayout.LayoutParams(-1, -1);
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(13, -1);
        this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(paramContext, (IVideoViewBase)this.jdField_a_of_type_AndroidViewView);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(new VideoCoverView.6(this));
        if (this.jdField_c_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewVideoCoverView$RotateAnimaterListener);
          this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(this.jdField_a_of_type_AndroidAnimationAnimatorListenerAdapter);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VideoCoverView.7(this), 3000L);
        }
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer$OnCompletionListener);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(new VideoCoverView.8(this));
        a(false);
      }
    }
  }
  
  private void h() {}
  
  public long a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    long l;
    if ((localObject != null) && (((TVK_IMediaPlayer)localObject).isPlaying())) {
      l = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
    } else {
      l = 0L;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("time = ");
      ((StringBuilder)localObject).append(l);
      QLog.d("Timer", 2, ((StringBuilder)localObject).toString());
    }
    return l;
  }
  
  public TVK_IMediaPlayer a()
  {
    return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  }
  
  public void a()
  {
    if ((PublicAccountAdvertisementActivity.class.isInstance(this.jdField_a_of_type_AndroidContentContext)) && (!((PublicAccountAdvertisementActivity)this.jdField_a_of_type_AndroidContentContext).isFinishing()))
    {
      this.jdField_d_of_type_Boolean = true;
      FMDialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131692561, 2131689584, new VideoCoverView.9(this));
    }
  }
  
  public void a(Context paramContext)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      TVK_SDKMgr.initSdk(paramContext, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      h();
      this.jdField_a_of_type_Boolean = true;
    }
    if (TVK_SDKMgr.isInstalled(paramContext))
    {
      this.jdField_b_of_type_Boolean = true;
      QLog.i("VideoCoverView", 1, "initSDK isInstalled");
      d(paramContext);
      return;
    }
    QLog.i("VideoCoverView", 1, "initSDK no isInstalled");
    this.jdField_b_of_type_Boolean = false;
    c(paramContext);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("stopVideo mVideoPlayer.isPlaying() =");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying());
        QLog.d("VideoCoverView", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_Int = 6;
      g();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.f = true;
  }
  
  public void b(Context paramContext)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void c()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null)
    {
      localTVK_IMediaPlayer.pause();
      this.jdField_a_of_type_Int = 5;
      g();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoCoverView", 2, "resumeVideo ");
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      if ((!VideoCoverFragment.jdField_b_of_type_Boolean) || (VideoCoverFragment.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Int = 4;
        g();
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      }
      if (!this.jdField_e_of_type_Boolean) {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      }
      if (this.jdField_b_of_type_Int == 1) {
        PublicAccountAdvertisementActivity.a = System.currentTimeMillis();
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void e()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null)
    {
      localTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
    }
  }
  
  public void f()
  {
    e();
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdvertisementSplitedProgressBar = null;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
    this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllListeners();
  }
  
  public void g()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManager.getUIHandler().post(new VideoCoverView.10(this));
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateView mVideoState=");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d("VideoCoverView", 2, localStringBuilder.toString());
    }
    int i = this.jdField_a_of_type_Int;
    if (i != 4)
    {
      if (i != 5)
      {
        if (i != 6)
        {
          if (i != 7)
          {
            if (AdvertisementVideoPreloadManager.a(this.jdField_a_of_type_JavaLangString)) {
              this.jdField_b_of_type_AndroidViewView.setVisibility(8);
            } else {
              this.jdField_b_of_type_AndroidViewView.setVisibility(0);
            }
            this.jdField_c_of_type_AndroidViewView.setVisibility(8);
            this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetResizeURLImageView.setVisibility(0);
            this.jdField_d_of_type_AndroidViewView.setVisibility(8);
            return;
          }
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetResizeURLImageView.setVisibility(8);
          this.jdField_d_of_type_AndroidViewView.setVisibility(8);
          return;
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetResizeURLImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetResizeURLImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetResizeURLImageView.setVisibility(8);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView
 * JD-Core Version:    0.7.0.1
 */