import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Handler;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpic.CircleProgressView;
import com.tencent.mobileqq.hotpic.DiskStorageManager;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.mobileqq.hotpic.HotVideoMongoliaRelativeLayout;
import com.tencent.mobileqq.hotpic.PresenceInterfaceImpl.1;
import com.tencent.mobileqq.hotpic.PresenceInterfaceImpl.10;
import com.tencent.mobileqq.hotpic.PresenceInterfaceImpl.2;
import com.tencent.mobileqq.hotpic.PresenceInterfaceImpl.5;
import com.tencent.mobileqq.hotpic.PresenceInterfaceImpl.6;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.io.File;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class asvy
  implements asvp, asww, asxb
{
  public static final DiskStorageManager a;
  public static volatile boolean a;
  static boolean d;
  static boolean e;
  final float jdField_a_of_type_Float = 1.777778F;
  long jdField_a_of_type_Long = 0L;
  public Context a;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  public Handler a;
  public aswm a;
  public HotVideoMongoliaRelativeLayout a;
  public final Runnable a;
  public WeakReference<HotPicPageView> a;
  long b;
  public final Runnable b;
  public boolean b;
  boolean c = false;
  private boolean f;
  private volatile boolean g = true;
  private volatile boolean h;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqHotpicDiskStorageManager = new DiskStorageManager(50);
  }
  
  public asvy(Context paramContext)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_b_of_type_Long = -1L;
    this.jdField_a_of_type_JavaLangRunnable = new PresenceInterfaceImpl.1(this);
    this.jdField_b_of_type_JavaLangRunnable = new PresenceInterfaceImpl.2(this);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Aswm = aswm.a(paramContext, 1);
    this.jdField_a_of_type_Aswm.a(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(Dialog paramDialog)
  {
    try
    {
      paramDialog.show();
      return;
    }
    catch (Throwable paramDialog) {}
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    d = false;
    e = false;
    jdField_a_of_type_Boolean = false;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    d = paramBoolean;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return e;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    e = paramBoolean;
  }
  
  private void n()
  {
    TVK_SDKMgr.installPlugin(BaseApplicationImpl.getApplication(), new aswg(this));
  }
  
  public void a()
  {
    g();
    e();
    this.c = true;
    this.h = false;
    this.jdField_a_of_type_Aswm.a();
    aswy.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.getContext()).b(this);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 1) {
      if (this.jdField_a_of_type_Aswm.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
      {
        this.jdField_a_of_type_Aswm.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setDownloadNetworkChange(2);
        localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        if ((this.jdField_a_of_type_Aswm.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()) && (!a(localQQAppInterface)))
        {
          b();
          m();
        }
      }
    }
    while ((paramInt != 4) || (this.jdField_a_of_type_Aswm.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null))
    {
      QQAppInterface localQQAppInterface;
      return;
    }
    this.jdField_a_of_type_Aswm.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setDownloadNetworkChange(1);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      a(6, this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout);
    }
    while (this.jdField_a_of_type_Aswm.a() != 6) {
      return;
    }
    a(5, this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout);
  }
  
  public void a(int paramInt, View paramView)
  {
    Object localObject;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if (this.g) {
        this.g = false;
      }
      while (jdField_a_of_type_Boolean)
      {
        this.g = true;
        return;
        if ((!this.g) && (!this.h)) {
          return;
        }
      }
      asvt.a();
      if (!asvt.b())
      {
        jdField_a_of_type_Boolean = true;
        l();
        this.g = true;
        QLog.d("PresenceInterfaceImpl", 2, "start install isRunInstallTencentSDK");
        return;
      }
      if (bdin.b(BaseApplication.getContext()) == 1) {}
      for (paramInt = 1;; paramInt = 0)
      {
        localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        if ((paramInt != 0) || (a((QQAppInterface)localObject))) {
          break;
        }
        bdgm.a(paramView.getContext(), 232, null, alud.a(2131708795), new aswc(this, (QQAppInterface)localObject), new aswd(this, (QQAppInterface)localObject)).show();
        return;
      }
      new PresenceInterfaceImpl.5(this).run();
      QLog.d("PresenceInterfaceImpl", 2, "onHandleUseOperations 0");
      return;
    case 1: 
      if (!this.f)
      {
        this.jdField_a_of_type_Aswm.a(null);
        label245:
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.b(3);
        d();
        return;
      }
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        localObject = (HotPicPageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramView == null) {
          break;
        }
      }
      break;
    }
    for (boolean bool = HotPicPageView.jdField_a_of_type_Boolean;; bool = false)
    {
      this.jdField_a_of_type_Aswm.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_Asvq.jdField_a_of_type_Long, bool);
      this.f = false;
      break label245;
      if (!this.h) {
        break;
      }
      g();
      this.jdField_a_of_type_Aswm.a();
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.b(4);
      paramView = new StringBuilder();
      paramView.append(asvt.a(this.jdField_a_of_type_Aswm.jdField_a_of_type_Long));
      paramView.append(" / ");
      paramView.append(this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_Asvq.b);
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.a(paramView.toString());
      return;
      bool = this.jdField_a_of_type_Aswm.a();
      if (bool)
      {
        paramView = "0X8007ED7";
        label412:
        if (bool)
        {
          if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {
            this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio"));
          }
          if (this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3) == 0) {
            break;
          }
        }
        if (bool) {
          break label563;
        }
      }
      label563:
      for (bool = true;; bool = false)
      {
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.a(bool);
        azqs.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "dc00898", "", "", paramView, paramView, 0, 0, "", "", "", "");
        QLog.d("PresenceInterfaceImpl", 2, "you have press mute button here, Current MuteStatus is" + bool);
        if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
          break;
        }
        paramView = (HotPicPageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramView == null) {
          break;
        }
        paramView.a(bool);
        return;
        paramView = "0X8007ED8";
        break label412;
      }
      if ((!this.h) || ((!this.jdField_a_of_type_Aswm.b()) && (!this.f))) {
        break;
      }
      paramView = new StringBuilder();
      long l = this.jdField_a_of_type_Aswm.a();
      this.jdField_a_of_type_Aswm.a();
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.b(4);
      if (this.jdField_a_of_type_Aswm.c == 4) {
        paramView.append(this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_Asvq.b);
      }
      for (;;)
      {
        paramView.append(" / ");
        paramView.append(this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_Asvq.b);
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.a(paramView.toString());
        c();
        e();
        QLog.d("PresenceInterfaceImpl", 2, "current position is mVideoPlayControl.getCurrentPosition()" + this.jdField_a_of_type_Aswm.a());
        return;
        paramView.append(asvt.a(l));
      }
      g();
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.b(3);
      d();
      return;
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_ComTencentMobileqqHotpicCircleProgressView.setProgress(this.jdField_a_of_type_Aswm.b());
      f();
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.b(6);
      c();
      e();
      return;
      if ((!this.h) || (!this.jdField_a_of_type_Aswm.b())) {
        break;
      }
      this.jdField_a_of_type_Aswm.a();
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.b(5);
      c();
      e();
      return;
      if (!this.h) {
        break;
      }
      g();
      this.jdField_a_of_type_Aswm.a();
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.b(5);
      return;
      if (!this.f)
      {
        this.jdField_a_of_type_Aswm.a(null);
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.b(3);
        d();
        return;
      }
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        localObject = (HotPicPageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramView == null) {}
      }
      for (bool = HotPicPageView.jdField_a_of_type_Boolean;; bool = false)
      {
        this.jdField_a_of_type_Aswm.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_Asvq.jdField_a_of_type_Long, bool);
        this.f = false;
        break;
      }
    }
  }
  
  public void a(int paramInt1, TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt2, int paramInt3, int paramInt4, String paramString, Object paramObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.b(-11);
    new beuj(this.jdField_a_of_type_AndroidContentContext).a(HotVideoMongoliaRelativeLayout.jdField_a_of_type_JavaLangString, 100, 0, 1);
    if (QLog.isColorLevel()) {
      QLog.d("PresenceInterfaceImpl", 2, "onInnerError i:" + paramInt2 + "   i1:" + paramInt3 + "  i2:" + paramInt4 + "   s:" + paramString);
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout = ((HotVideoMongoliaRelativeLayout)paramView);
    aswy.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.getContext()).a(this);
  }
  
  public void a(HotPicPageView paramHotPicPageView)
  {
    if (paramHotPicPageView == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramHotPicPageView);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new PresenceInterfaceImpl.10(this, paramString));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Aswm.a(paramBoolean);
  }
  
  boolean a()
  {
    long l = this.jdField_a_of_type_Aswm.b();
    if (QLog.isColorLevel()) {
      QLog.d("PresenceInterfaceImpl", 2, "initDuration: duration=" + l);
    }
    this.jdField_b_of_type_Long = ((int)l);
    return l > 0L;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aswm.a() == 2) {
      a(4, this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout);
    }
    while (this.jdField_a_of_type_Aswm.a() != 6) {
      return;
    }
    a(2, this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout);
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      b();
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Aswm != null) && (this.jdField_a_of_type_Aswm.b());
  }
  
  public void c()
  {
    if ((this.jdField_b_of_type_Long <= 0L) && (!a())) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Aswm == null);
      this.jdField_a_of_type_Long = this.jdField_a_of_type_Aswm.a();
    } while (this.jdField_a_of_type_Long == 0L);
    int i = (int)(this.jdField_a_of_type_Long * 10000L / this.jdField_b_of_type_Long + 0.5D);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.a(i);
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean == true) {
      b();
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 100L);
  }
  
  public void d(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      File localFile = new File(asvt.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.jdField_a_of_type_Asvq.d));
      jdField_a_of_type_ComTencentMobileqqHotpicDiskStorageManager.a(localFile);
    }
    this.f = true;
    a(4, this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout.e();
    QLog.d("PresenceInterfaceImpl", 2, "onPlayComplete ok here localPlay value is " + paramBoolean);
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  void f()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 100L);
  }
  
  public void g()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
  }
  
  public void h()
  {
    b();
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio"));
    }
    int i = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3);
    Object localObject;
    boolean bool;
    if ((this.jdField_a_of_type_Aswm != null) && (this.jdField_a_of_type_Aswm.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout;
      if (i <= 0)
      {
        bool = true;
        ((HotVideoMongoliaRelativeLayout)localObject).a(bool);
      }
    }
    else
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
        break label79;
      }
    }
    label79:
    do
    {
      return;
      bool = false;
      break;
      localObject = (HotPicPageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localObject == null);
    ((HotPicPageView)localObject).a(i);
  }
  
  public void j()
  {
    this.h = true;
    ThreadManager.getUIHandler().post(new PresenceInterfaceImpl.6(this));
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Aswm.a() == 3) {
      a(1, this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout);
    }
  }
  
  public void l()
  {
    int i = 1;
    if (bdin.b(BaseApplication.getContext()) == 1) {}
    while (i != 0)
    {
      n();
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698160), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131298914));
      return;
      i = 0;
    }
    bdgm.a(this.jdField_a_of_type_AndroidContentContext, 232, null, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698157), new aswe(this), new aswf(this)).show();
  }
  
  void m()
  {
    a(bdgm.a(this.jdField_a_of_type_AndroidContentContext, 232, null, this.jdField_a_of_type_AndroidContentContext.getString(2131720130), new aswa(this), new aswb(this)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asvy
 * JD-Core Version:    0.7.0.1
 */