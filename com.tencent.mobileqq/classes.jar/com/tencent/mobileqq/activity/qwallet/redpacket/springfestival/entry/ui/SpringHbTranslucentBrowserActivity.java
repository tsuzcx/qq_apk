package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui;

import ahgl;
import ahhk;
import ahhl;
import ahhm;
import ahhn;
import ahht;
import ahih;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bbdj;
import bbjw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.thread.BaseHandler;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class SpringHbTranslucentBrowserActivity
  extends QQTranslucentBrowserActivity
  implements ahht
{
  private int jdField_a_of_type_Int = 2000;
  private long jdField_a_of_type_Long = System.currentTimeMillis();
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ahhl(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private SpringHbVideoView jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new SpringHbTranslucentBrowserActivity.6(this);
  private String jdField_a_of_type_JavaLangString = "";
  boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private Runnable jdField_b_of_type_JavaLangRunnable = new SpringHbTranslucentBrowserActivity.7(this);
  private String jdField_b_of_type_JavaLangString = "";
  private volatile boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  private Runnable jdField_c_of_type_JavaLangRunnable = new SpringHbTranslucentBrowserActivity.8(this);
  private String jdField_c_of_type_JavaLangString;
  private volatile boolean jdField_c_of_type_Boolean = true;
  private String jdField_d_of_type_JavaLangString;
  private volatile boolean jdField_d_of_type_Boolean;
  private volatile boolean e;
  private boolean f;
  private volatile boolean g;
  private volatile boolean h;
  private volatile boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private volatile boolean m;
  private volatile boolean n;
  private volatile boolean o;
  private boolean p;
  
  /* Error */
  private void a(View paramView)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 92	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/entry/ui/SpringHbTranslucentBrowserActivity:m	Z
    //   4: ifne +170 -> 174
    //   7: aload_0
    //   8: iconst_1
    //   9: putfield 92	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/entry/ui/SpringHbTranslucentBrowserActivity:m	Z
    //   12: aload_1
    //   13: ifnull +8 -> 21
    //   16: aload_1
    //   17: fconst_1
    //   18: invokevirtual 98	android/view/View:setAlpha	(F)V
    //   21: aload_0
    //   22: getfield 100	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/entry/ui/SpringHbTranslucentBrowserActivity:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   25: ifnull +29 -> 54
    //   28: aload_0
    //   29: getfield 102	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/entry/ui/SpringHbTranslucentBrowserActivity:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   32: ifnull +22 -> 54
    //   35: ldc 104
    //   37: iconst_2
    //   38: ldc 106
    //   40: invokestatic 111	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: aload_0
    //   44: getfield 100	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/entry/ui/SpringHbTranslucentBrowserActivity:jdField_a_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   47: aload_0
    //   48: getfield 102	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/entry/ui/SpringHbTranslucentBrowserActivity:jdField_b_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   51: invokevirtual 116	android/view/ViewGroup:removeView	(Landroid/view/View;)V
    //   54: aload_0
    //   55: getfield 118	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/entry/ui/SpringHbTranslucentBrowserActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   58: ifnull +14 -> 72
    //   61: aload_0
    //   62: getfield 118	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/entry/ui/SpringHbTranslucentBrowserActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   65: aload_0
    //   66: getfield 68	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/entry/ui/SpringHbTranslucentBrowserActivity:jdField_b_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   69: invokevirtual 124	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   72: aload_0
    //   73: getfield 126	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/entry/ui/SpringHbTranslucentBrowserActivity:k	Z
    //   76: ifeq +99 -> 175
    //   79: aload_0
    //   80: iconst_1
    //   81: putfield 128	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/entry/ui/SpringHbTranslucentBrowserActivity:n	Z
    //   84: ldc 104
    //   86: iconst_2
    //   87: new 130	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   94: ldc 133
    //   96: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_0
    //   100: getfield 126	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/entry/ui/SpringHbTranslucentBrowserActivity:k	Z
    //   103: invokevirtual 140	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   106: ldc 142
    //   108: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_0
    //   112: getfield 128	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/entry/ui/SpringHbTranslucentBrowserActivity:n	Z
    //   115: invokevirtual 140	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   118: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 111	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   124: aload_0
    //   125: getfield 148	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/entry/ui/SpringHbTranslucentBrowserActivity:i	Z
    //   128: istore_2
    //   129: iload_2
    //   130: ifne +29 -> 159
    //   133: invokestatic 154	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   136: invokevirtual 158	com/tencent/mobileqq/qipc/QIPCClientHelper:getClient	()Leipc/EIPCClient;
    //   139: ldc 160
    //   141: ldc 162
    //   143: new 164	android/os/Bundle
    //   146: dup
    //   147: invokespecial 165	android/os/Bundle:<init>	()V
    //   150: invokevirtual 171	eipc/EIPCClient:callServer	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Leipc/EIPCResult;
    //   153: pop
    //   154: aload_0
    //   155: iconst_1
    //   156: putfield 148	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/entry/ui/SpringHbTranslucentBrowserActivity:i	Z
    //   159: aload_0
    //   160: getfield 173	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/entry/ui/SpringHbTranslucentBrowserActivity:jdField_a_of_type_Boolean	Z
    //   163: ifeq +11 -> 174
    //   166: ldc 175
    //   168: iconst_0
    //   169: iconst_0
    //   170: aconst_null
    //   171: invokestatic 180	ahih:a	(Ljava/lang/String;IILjava/util/Map;)V
    //   174: return
    //   175: aload_0
    //   176: ldc 182
    //   178: invokespecial 185	com/tencent/mobileqq/activity/qwallet/redpacket/springfestival/entry/ui/SpringHbTranslucentBrowserActivity:a	(Ljava/lang/String;)V
    //   181: goto -97 -> 84
    //   184: astore_1
    //   185: ldc 104
    //   187: iconst_2
    //   188: ldc 187
    //   190: aload_1
    //   191: invokestatic 190	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   194: goto -110 -> 84
    //   197: astore_1
    //   198: ldc 104
    //   200: iconst_1
    //   201: ldc 192
    //   203: aload_1
    //   204: invokestatic 190	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   207: return
    //   208: astore_1
    //   209: ldc 104
    //   211: iconst_1
    //   212: ldc 194
    //   214: aload_1
    //   215: invokestatic 190	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   218: goto -59 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	SpringHbTranslucentBrowserActivity
    //   0	221	1	paramView	View
    //   128	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   72	84	184	java/lang/Exception
    //   175	181	184	java/lang/Exception
    //   16	21	197	java/lang/Throwable
    //   21	54	197	java/lang/Throwable
    //   54	72	197	java/lang/Throwable
    //   72	84	197	java/lang/Throwable
    //   84	129	197	java/lang/Throwable
    //   133	159	197	java/lang/Throwable
    //   159	174	197	java/lang/Throwable
    //   175	181	197	java/lang/Throwable
    //   185	194	197	java/lang/Throwable
    //   209	218	197	java/lang/Throwable
    //   133	159	208	java/lang/Exception
  }
  
  private void a(RelativeLayout paramRelativeLayout, String paramString)
  {
    if (paramRelativeLayout == null)
    {
      QLog.e("springHb_SpringHbTranslucentBrowserActivity", 2, "addVideoView contentView is null");
      return;
    }
    SpringHbVideoView localSpringHbVideoView;
    if (ahgl.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView == null)
    {
      QLog.i("springHb_SpringHbTranslucentBrowserActivity", 2, "no cache new a QQFudaiVideoView");
      localSpringHbVideoView = new SpringHbVideoView(BaseApplicationImpl.getContext());
    }
    for (;;)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(13);
      paramRelativeLayout.addView(localSpringHbVideoView, localLayoutParams);
      if (localSpringHbVideoView.a() != null) {
        localSpringHbVideoView.a().setXYaxis(2);
      }
      localSpringHbVideoView.setDataByLocalPath(paramString, false, false);
      localSpringHbVideoView.setVideoListener(this);
      localSpringHbVideoView.setOnClickListener(new ahhn(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView = localSpringHbVideoView;
      return;
      QLog.i("springHb_SpringHbTranslucentBrowserActivity", 2, "use cache QQFudaiVideoView");
      localSpringHbVideoView = ahgl.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView;
      ahgl.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView = null;
    }
  }
  
  private void a(String paramString)
  {
    ThreadManager.getUIHandler().post(new SpringHbTranslucentBrowserActivity.9(this, paramString));
  }
  
  public static boolean a()
  {
    try
    {
      EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("SpringHbIPCModule", "getIsVideoChatting", new Bundle());
      if ((localEIPCResult != null) && (localEIPCResult.isSuccess()) && (localEIPCResult.data != null)) {
        return localEIPCResult.data.getBoolean("isVideoChatting");
      }
      QLog.e("springHb_SpringHbTranslucentBrowserActivity", 2, "getIsVideoChatting,failed， result=" + localEIPCResult);
      return false;
    }
    catch (Exception localException)
    {
      QLog.e("springHb_SpringHbTranslucentBrowserActivity", 1, "getIsVideoChatting,exception.", localException);
    }
    return false;
  }
  
  private boolean b()
  {
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      QLog.e("springHb_SpringHbTranslucentBrowserActivity", 2, "isNeedPlayInnerVideo --> mEntryId is empty,no need to play");
      return false;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      QLog.e("springHb_SpringHbTranslucentBrowserActivity", 2, "isNeedPlayInnerVideo --> video path is empty,no need to play");
      return false;
    }
    if (c())
    {
      QLog.i("springHb_SpringHbTranslucentBrowserActivity", 2, "isNeedPlayInnerVideo -->video hasPlayed,no need to play");
      return false;
    }
    if (a())
    {
      QLog.i("springHb_SpringHbTranslucentBrowserActivity", 2, "isNeedPlayInnerVideo -->IsVideoChatting,no need to play");
      return false;
    }
    if (!bbdj.a(this.jdField_a_of_type_JavaLangString))
    {
      QLog.e("springHb_SpringHbTranslucentBrowserActivity", 2, "isNeedPlayInnerVideo -->file is no exists,mVideoPath=" + this.jdField_a_of_type_JavaLangString);
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringHbTranslucentBrowserActivity", 2, "isNeedPlayInnerVideo -->true");
    }
    return true;
  }
  
  private boolean c()
  {
    for (;;)
    {
      try
      {
        if (!bbjw.a(this.jdField_b_of_type_JavaLangString)) {
          bool = getApplicationContext().getSharedPreferences("spring_entry_video_sp", 0).getBoolean(this.jdField_b_of_type_JavaLangString, false);
        }
        boolean bool = false;
      }
      catch (Exception localException1)
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.i("springHb_SpringHbTranslucentBrowserActivity", 2, "isHasPlayed:" + bool);
          }
          return bool;
        }
        catch (Exception localException2)
        {
          continue;
        }
        localException1 = localException1;
        bool = false;
        QLog.e("springHb_SpringHbTranslucentBrowserActivity", 2, "get sp fail", localException1);
        return bool;
      }
    }
  }
  
  private void d()
  {
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131364706);
    if (localViewGroup != null)
    {
      localViewGroup.setAlpha(0.0F);
      localViewGroup.setBackgroundResource(2131167134);
    }
  }
  
  private void i()
  {
    try
    {
      if (!bbjw.a(this.jdField_b_of_type_JavaLangString))
      {
        QLog.i("springHb_SpringHbTranslucentBrowserActivity", 2, "setHasPlayed ");
        getApplicationContext().getSharedPreferences("spring_entry_video_sp", 0).edit().putBoolean(this.jdField_b_of_type_JavaLangString, true).apply();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("springHb_SpringHbTranslucentBrowserActivity", 1, "set sp fail", localException);
    }
  }
  
  private void j()
  {
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131364706);
    if (localViewGroup == null)
    {
      QLog.e("springHb_SpringHbTranslucentBrowserActivity", 2, "addVideoContainer content_fragment==null");
      return;
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      QLog.e("springHb_SpringHbTranslucentBrowserActivity", 2, "addVideoContainer mVideoLayout is not null,exist.");
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    localViewGroup = (ViewGroup)localViewGroup.getParent();
    if (localViewGroup == null)
    {
      QLog.e("springHb_SpringHbTranslucentBrowserActivity", 2, "addVideoContainer content_fragment parent is  null");
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup = localViewGroup;
    View localView = LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2131562614, null);
    if (localView == null)
    {
      QLog.e("springHb_SpringHbTranslucentBrowserActivity", 2, "webview_fragment_fudai_videolayout inflate fail.");
      return;
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    if (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long > 8000L)
    {
      QLog.e("springHb_SpringHbTranslucentBrowserActivity", 2, "addVideo so long,give up play video");
      this.jdField_c_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_c_of_type_JavaLangRunnable, 5000L);
    localView.setAlpha(0.0F);
    localViewGroup.addView(localView);
    this.jdField_a_of_type_AndroidViewView = localView;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131366861));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131366859));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ahhk(this));
    this.jdField_a_of_type_AndroidViewViewGroup.bringChildToFront(this.jdField_a_of_type_AndroidViewView);
    a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_JavaLangString);
    QLog.i("springHb_SpringHbTranslucentBrowserActivity", 2, "inflate view webview_fragment_fudai_videolayout");
  }
  
  private void k()
  {
    try
    {
      ViewGroup localViewGroup = (ViewGroup)findViewById(2131364706);
      if (localViewGroup == null)
      {
        QLog.e("springHb_SpringHbTranslucentBrowserActivity", 2, "addVideoContainer content_fragment==null");
        return;
      }
      localViewGroup = (ViewGroup)localViewGroup.getParent();
      if (localViewGroup == null)
      {
        QLog.i("springHb_SpringHbTranslucentBrowserActivity", 2, "content_fragment getParent，is null");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("springHb_SpringHbTranslucentBrowserActivity", 1, "setWebViewLayoutVisible addEmptyVideoContainer");
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup = localException;
    QLog.i("springHb_SpringHbTranslucentBrowserActivity", 2, "setWebViewLayoutVisible addEmptyVideoContainer");
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(BaseApplicationImpl.getContext());
    this.jdField_b_of_type_AndroidWidgetImageView.setId(2131366848);
    this.jdField_b_of_type_AndroidWidgetImageView.setAlpha(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(null);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_b_of_type_AndroidWidgetImageView, -1, -1);
    this.jdField_a_of_type_AndroidViewViewGroup.bringChildToFront(this.jdField_b_of_type_AndroidWidgetImageView);
  }
  
  private void l()
  {
    if (this.l) {
      QLog.i("springHb_SpringHbTranslucentBrowserActivity", 2, "onOuterVideoEnd mOnOuterVideoEndIsCalled is call");
    }
    do
    {
      return;
      QLog.i("springHb_SpringHbTranslucentBrowserActivity", 2, "onOuterVideoEnd...");
      this.l = true;
      this.jdField_b_of_type_Boolean = true;
    } while (!this.f);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView != null)
    {
      QLog.i("springHb_SpringHbTranslucentBrowserActivity", 2, "playVideo... mVideoView start");
      if (this.h)
      {
        m();
        return;
      }
      this.g = true;
      return;
    }
    QLog.e("springHb_SpringHbTranslucentBrowserActivity", 2, "mIsNeedPlayVideo true,but mVideoView is null");
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView.a();
    this.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView.a();
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringHbTranslucentBrowserActivity", 2, "doStartPlayVideo,mDuration:" + this.jdField_c_of_type_Long);
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setAnimationListener(new ahhm(this));
    localAlphaAnimation.setDuration(400L);
    this.jdField_a_of_type_AndroidViewView.setAnimation(localAlphaAnimation);
    localAlphaAnimation.start();
    i();
    ahih.a("sq.kcsp.bf", 0, 0, null);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void n()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      l();
      o();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("springHb_SpringHbTranslucentBrowserActivity", 1, "onPreVideoOrAnimationEnd exception", localException);
    }
  }
  
  private void o()
  {
    long l1;
    try
    {
      View localView = findViewById(2131364706);
      if (localView == null)
      {
        QLog.w("springHb_SpringHbTranslucentBrowserActivity", 2, "view content_fragment is null");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("springHb_SpringHbTranslucentBrowserActivity", 2, "setPageAlpha --> mIsLoadingAnimFinished:" + this.jdField_b_of_type_Boolean + " mIsInnerVideoPlayFinish:" + this.jdField_c_of_type_Boolean + " mIsUrlLoadFinish:" + this.e);
      }
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean) && (this.e)) {
        break label239;
      }
      l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      if (l1 > 25000L)
      {
        QLog.i("springHb_SpringHbTranslucentBrowserActivity", 2, "overtime,show webview totalTimeCost=" + l1);
        a(localView);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbTranslucentBrowserActivity", 1, localThrowable, new Object[0]);
      return;
    }
    if ((this.j) && (this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean))
    {
      QLog.i("springHb_SpringHbTranslucentBrowserActivity", 2, "loading and video finish, force show webview" + l1);
      a(localThrowable);
      return;
    }
    localThrowable.setAlpha(0.0F);
    this.m = false;
    QLog.i("springHb_SpringHbTranslucentBrowserActivity", 2, "setAlpha(0)");
    return;
    label239:
    QLog.i("springHb_SpringHbTranslucentBrowserActivity", 2, "pre anim ,inner video and webView finish ,show webView");
    a(localThrowable);
  }
  
  private void p()
  {
    try
    {
      IntentFilter localIntentFilter;
      if (!this.o)
      {
        localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("ACTION_LOADING_ANIM_PLAY_FINISH");
        localIntentFilter.addAction("action_notify_view_update");
      }
      try
      {
        registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
        this.o = true;
        return;
      }
      catch (Exception localException1)
      {
        QLog.e("springHb_SpringHbTranslucentBrowserActivity", 2, "regist receiver error:", localException1);
        return;
      }
      return;
    }
    catch (Exception localException2)
    {
      QLog.e("springHb_SpringHbTranslucentBrowserActivity", 1, "registerBroadcast error", localException2);
    }
  }
  
  private void q()
  {
    try
    {
      if (this.o)
      {
        QLog.i("springHb_SpringHbTranslucentBrowserActivity", 2, "removeBroadcast");
        try
        {
          unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
          this.o = false;
          return;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            QLog.e("springHb_SpringHbTranslucentBrowserActivity", 2, "unregisterReceiver error ", localException1);
          }
        }
      }
      return;
    }
    catch (Exception localException2)
    {
      QLog.e("springHb_SpringHbTranslucentBrowserActivity", 1, "removeBroadcast error", localException2);
    }
  }
  
  private void r()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("springHb_SpringHbTranslucentBrowserActivity", 2, "onPlayInnerVideoEnd:hasHoldPageShowNotify:" + this.n + ",isPaused" + this.k);
      }
      s();
      this.j = true;
      this.jdField_c_of_type_Boolean = true;
      o();
      if ((this.n) && (!this.k))
      {
        this.n = false;
        a("javascript:androidPageShow()");
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("springHb_SpringHbTranslucentBrowserActivity", 1, "onPlayInnerVideoEnd exception", localException);
    }
  }
  
  private void s()
  {
    try
    {
      QLog.i("springHb_SpringHbTranslucentBrowserActivity", 2, "hideVideoLayout");
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView.g();
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView = null;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("springHb_SpringHbTranslucentBrowserActivity", 1, "hideVideoLayout exception", localException);
    }
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
      this.h = true;
      this.jdField_d_of_type_Boolean = true;
      if (this.g)
      {
        this.g = false;
        if (!this.k) {
          break label88;
        }
        this.p = true;
      }
      for (;;)
      {
        QLog.i("springHb_SpringHbTranslucentBrowserActivity", 2, "onPrepared..mNeedPlayAfterPrepared:" + this.g + ",hasHoldAutoPlay:" + this.p);
        return;
        label88:
        this.jdField_a_of_type_AndroidOsHandler.post(new SpringHbTranslucentBrowserActivity.11(this));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbTranslucentBrowserActivity", 1, localThrowable, new Object[0]);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Object paramObject)
  {
    this.jdField_d_of_type_Boolean = false;
    QLog.e("springHb_SpringHbTranslucentBrowserActivity", 2, "video onError what=" + paramInt1 + ",position=" + paramInt2 + ",detailInfo=" + paramString);
    this.jdField_a_of_type_AndroidOsHandler.post(new SpringHbTranslucentBrowserActivity.13(this));
  }
  
  public void a(WebView paramWebView, String paramString)
  {
    super.a(paramWebView, paramString);
    this.e = true;
    o();
    QLog.i("springHb_SpringHbTranslucentBrowserActivity", 2, "webLoad finish url=" + paramString);
  }
  
  public void ar_()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView != null)
      {
        long l1 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView.a() / 1000L;
        HashMap localHashMap = new HashMap();
        localHashMap.put("ext1", l1 + "");
        localHashMap.put("ext2", l1 + "");
        ahih.a("sq.kcsp.bw", 0, 0, localHashMap);
        if (QLog.isColorLevel()) {
          QLog.i("springHb_SpringHbTranslucentBrowserActivity", 2, "onCompletion...duration:" + l1 + ",position:" + l1);
        }
      }
      this.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.post(new SpringHbTranslucentBrowserActivity.12(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbTranslucentBrowserActivity", 1, localThrowable, new Object[0]);
    }
  }
  
  public void c()
  {
    this.e = true;
    o();
    QLog.i("springHb_SpringHbTranslucentBrowserActivity", 2, "h5NotifyLoadFinished...time:" + System.currentTimeMillis() + ",mIsUrlLoadFinish:" + this.e + "mIsInnerVideoPlayFinish:" + this.jdField_c_of_type_Boolean + "mIsLoadingAnimFinished:" + this.jdField_b_of_type_Boolean);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool2 = super.doOnCreate(paramBundle);
    d();
    this.f = b();
    boolean bool1;
    label43:
    long l1;
    if (!this.f)
    {
      bool1 = true;
      this.jdField_c_of_type_Boolean = bool1;
      if (!this.f) {
        break label143;
      }
      j();
      l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      if (l1 < this.jdField_a_of_type_Int) {
        break label150;
      }
      if (QLog.isColorLevel()) {
        QLog.i("springHb_SpringHbTranslucentBrowserActivity", 2, "mPreAnimTimeout...");
      }
      l();
    }
    for (;;)
    {
      QLog.i("springHb_SpringHbTranslucentBrowserActivity", 1, "doOnCreate...mIsNeedPlayVideo:" + this.f + ",cost=" + l1 + ",mPreAnimTimeout" + this.jdField_a_of_type_Int);
      return bool2;
      bool1 = false;
      break;
      label143:
      k();
      break label43;
      label150:
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.jdField_a_of_type_Int - l1);
      if (QLog.isColorLevel()) {
        QLog.i("springHb_SpringHbTranslucentBrowserActivity", 2, "mPreAnimTimeout=" + this.jdField_a_of_type_Int + ",cost=" + l1);
      }
    }
  }
  
  public void doOnDestroy()
  {
    try
    {
      super.doOnDestroy();
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          q();
          s();
          if (this.jdField_a_of_type_AndroidOsHandler != null) {
            this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
          }
          QLog.d("springHb_SpringHbTranslucentBrowserActivity", 2, "doOnDestroy...");
          return;
        }
        catch (Throwable localThrowable2)
        {
          QLog.e("springHb_SpringHbTranslucentBrowserActivity", 1, "doOnDestroy" + localThrowable2);
        }
        localThrowable1 = localThrowable1;
        QLog.e("springHb_SpringHbTranslucentBrowserActivity", 1, "doOnDestroy" + localThrowable1);
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.k = true;
    try
    {
      if (this.jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new SpringHbTranslucentBrowserActivity.5(this), 500L);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("springHb_SpringHbTranslucentBrowserActivity", 1, localThrowable, new Object[0]);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.k = false;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("springHb_SpringHbTranslucentBrowserActivity", 1, "doOnResume,mIsInnerVideoPlaying" + this.jdField_d_of_type_Boolean + ",hasHoldPageShowNotify:" + this.n + ",hasHoldAutoPlayVideo：" + this.p);
        }
        if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView.a().isPauseing()))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalEntryUiSpringHbVideoView.a().start();
          ImmersiveUtils.a(getWindow(), true);
          return;
        }
        if (this.p)
        {
          this.p = false;
          this.jdField_a_of_type_AndroidOsHandler.post(new SpringHbTranslucentBrowserActivity.4(this));
          continue;
        }
        if (!this.n) {
          continue;
        }
      }
      catch (Exception localException)
      {
        QLog.e("springHb_SpringHbTranslucentBrowserActivity", 1, "doOnResume clearCoverForStatus erro");
        return;
      }
      this.n = false;
      a("javascript:androidPageShow()");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null)
      {
        this.jdField_a_of_type_Int = ((Bundle)localObject).getInt("preAnimTimeout", 2000);
        this.jdField_a_of_type_JavaLangString = ((Bundle)localObject).getString("videoPath");
        this.jdField_a_of_type_Long = ((Bundle)localObject).getLong("startTime", System.currentTimeMillis());
        this.jdField_c_of_type_JavaLangString = ((Bundle)localObject).getString("entryId");
        this.jdField_d_of_type_JavaLangString = ((Bundle)localObject).getString("uin");
        if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
          this.jdField_b_of_type_JavaLangString = (this.jdField_d_of_type_JavaLangString + "_" + "spring_entry_video_played_" + "entryId" + "_" + this.jdField_c_of_type_JavaLangString);
        }
        if (QLog.isColorLevel()) {
          QLog.i("springHb_SpringHbTranslucentBrowserActivity", 2, "onCreate：preAnimTimeout=" + this.jdField_a_of_type_Int + "," + "videoPath" + "=" + this.jdField_a_of_type_JavaLangString + "," + "startTime" + "=" + this.jdField_a_of_type_Long + "mVideoCacheKey:" + this.jdField_b_of_type_JavaLangString + "mUin:" + this.jdField_d_of_type_JavaLangString);
        }
      }
    }
    p();
    this.jdField_a_of_type_AndroidOsHandler = new BaseHandler();
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 25100L);
    super.onCreate(paramBundle);
  }
  
  public boolean themeChangeRightNow()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbTranslucentBrowserActivity
 * JD-Core Version:    0.7.0.1
 */