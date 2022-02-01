import android.animation.ValueAnimator;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Paint.Align;
import android.os.Handler;
import android.support.v4.util.ArraySet;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.animation.LinearInterpolator;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment;
import com.tencent.mobileqq.listentogether.lyrics.FloatIconLayout;
import com.tencent.mobileqq.listentogether.lyrics.FloatTextLayout;
import com.tencent.mobileqq.listentogether.lyrics.LyricsController.1;
import com.tencent.mobileqq.listentogether.lyrics.LyricsController.12;
import com.tencent.mobileqq.listentogether.lyrics.LyricsController.2;
import com.tencent.mobileqq.listentogether.lyrics.LyricsController.4;
import com.tencent.mobileqq.listentogether.lyrics.LyricsController.5;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayService;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenPermission;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Set;
import mqq.os.MqqHandler;

public class avuv
  implements avus
{
  public int a;
  ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  Application.ActivityLifecycleCallbacks jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks = new avvb(this);
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new avvc(this);
  protected avtk a;
  avts jdField_a_of_type_Avts;
  public avut a;
  protected QQAppInterface a;
  protected FloatIconLayout a;
  protected FloatTextLayout a;
  Boolean jdField_a_of_type_JavaLangBoolean;
  Runnable jdField_a_of_type_JavaLangRunnable = new LyricsController.5(this);
  public String a;
  HashMap<String, Boolean> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  protected Set<String> a;
  public boolean a;
  int jdField_b_of_type_Int = 0;
  private Runnable jdField_b_of_type_JavaLangRunnable = new LyricsController.2(this);
  String jdField_b_of_type_JavaLangString;
  public boolean b;
  int jdField_c_of_type_Int = 0;
  private Runnable jdField_c_of_type_JavaLangRunnable = new LyricsController.12(this);
  String jdField_c_of_type_JavaLangString;
  public boolean c;
  int d;
  public boolean d;
  int e;
  public boolean e;
  int jdField_f_of_type_Int;
  boolean jdField_f_of_type_Boolean = true;
  int jdField_g_of_type_Int;
  boolean jdField_g_of_type_Boolean = false;
  public int h;
  private boolean h;
  int i;
  
  public avuv(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilSet = new ArraySet();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Avut = new avut();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_Avtk = new avva(this);
    this.jdField_h_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Avtk);
    j();
    this.jdField_a_of_type_Avut.jdField_a_of_type_Boolean = true;
    paramQQAppInterface = BaseApplicationImpl.getContext();
    this.jdField_f_of_type_Int = bgtn.a();
    this.jdField_g_of_type_Int = bgtn.b();
    int j = afur.a(12.0F, paramQQAppInterface.getResources());
    this.jdField_d_of_type_Int = j;
    this.jdField_b_of_type_Int = j;
    j = afur.a(12.0F, paramQQAppInterface.getResources());
    this.jdField_e_of_type_Int = j;
    this.jdField_c_of_type_Int = j;
    this.jdField_a_of_type_Avut.jdField_a_of_type_Int = -1000;
    this.jdField_a_of_type_Avut.jdField_b_of_type_Int = -1000;
    ThreadManagerV2.excute(new LyricsController.1(this), 32, null, true);
  }
  
  private avuu a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout != null) {
      return this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a();
    }
    return null;
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LyricsController", 2, String.format("onPlaySongChange [pre,next]=[%s,%s]", new Object[] { this.jdField_b_of_type_JavaLangString, paramString }));
    }
    if (!bgjw.a(paramString, this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_b_of_type_JavaLangString = paramString;
      this.jdField_c_of_type_JavaLangString = null;
      this.jdField_a_of_type_JavaLangBoolean = null;
    }
    avuu localavuu = a();
    if ((localavuu != null) && (!bgjw.a(localavuu.a(), paramString)))
    {
      localavuu.setSongId(paramString);
      localavuu.setLyric(null, 1);
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if (!bgjw.a(paramString, this.jdField_b_of_type_JavaLangString)) {}
    do
    {
      return;
      this.i = paramInt;
    } while (!this.jdField_b_of_type_Boolean);
    b(paramString, paramInt);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_Boolean) {
      c(paramString, paramInt1);
    }
  }
  
  private boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LyricsController", 2, String.format("updateLyricContent [%s]", new Object[] { paramString1 }));
    }
    if (TextUtils.isEmpty(paramString1)) {}
    avuu localavuu;
    do
    {
      return false;
      localavuu = a();
    } while ((localavuu == null) || (!paramString1.equals(localavuu.a())) || (localavuu.a() == 2));
    paramString1 = paramString2;
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1 = paramString2.replace("&apos;", "'").replace("&quot;", "\"").replace("&nbsp;", " ").replace("&lt;", "<").replace("&gt;", ">").replace("&amp;", "&");
    }
    awdu localawdu = awec.a(paramString1, true);
    paramString2 = localawdu;
    if (localawdu == null) {
      paramString2 = awec.a(paramString1, false);
    }
    boolean bool;
    int j;
    if (QLog.isColorLevel())
    {
      if (paramString2 == null)
      {
        bool = true;
        QLog.i("LyricsController", 2, String.format("updateLyricContent parse lyric==null [%b]", new Object[] { Boolean.valueOf(bool) }));
      }
    }
    else
    {
      if (paramString2 == null) {
        break label224;
      }
      j = 2;
    }
    for (;;)
    {
      localavuu.c();
      localavuu.setLyric(paramString2, j);
      return true;
      bool = false;
      break;
      label224:
      if (paramBoolean) {
        j = 3;
      } else {
        j = 4;
      }
    }
  }
  
  private void b(String paramString, int paramInt)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.i("LyricsController", 2, String.format("updateLyricState [%s, %s]", new Object[] { avvg.a(paramInt), paramString }));
    }
    avuu localavuu = a();
    if (localavuu == null) {
      return;
    }
    localavuu.setSongId(paramString);
    int k = QQMusicPlayService.c();
    if (k < 0) {}
    for (;;)
    {
      if (paramInt == 2)
      {
        boolean bool = localavuu.a();
        if (!bool) {
          localavuu.a();
        }
        QLog.i("LyricsController", 1, "updateLyricPosition() seek to playPosition:" + j + " isPlaying:" + bool);
        localavuu.a(j);
        return;
      }
      if (3 == paramInt)
      {
        localavuu.a(j);
        localavuu.b();
        return;
      }
      if ((1 == paramInt) || (paramInt == 0))
      {
        localavuu.b();
        return;
      }
      localavuu.c();
      return;
      j = k;
    }
  }
  
  private boolean b()
  {
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp() == null)) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = FloatingScreenPermission.checkPermission(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.i("LyricsController", 2, "hasFloatPermission, isOpEnable: " + bool2);
    return bool2;
  }
  
  private boolean b(int paramInt, String paramString)
  {
    boolean bool2 = false;
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Avut.a(paramInt, paramString))) {
      return true;
    }
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilSet)
      {
        this.jdField_a_of_type_Avut.jdField_b_of_type_Boolean = this.jdField_a_of_type_JavaUtilSet.contains(paramInt + "_" + paramString);
        if (this.jdField_a_of_type_Avut.b(paramInt, paramString))
        {
          bool1 = false;
          if (bool1 != this.jdField_a_of_type_Avut.jdField_c_of_type_Boolean)
          {
            this.jdField_a_of_type_Avut.jdField_c_of_type_Boolean = bool1;
            this.jdField_a_of_type_Avut.jdField_d_of_type_Boolean = true;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout = new FloatIconLayout(localBaseApplication);
            this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.setFloatLayoutCallback(this);
            bdpg.a().a(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout = new FloatTextLayout(localBaseApplication);
            this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.setFloatLayoutCallback(this);
          }
          this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.e();
          if (this.jdField_a_of_type_Avut.jdField_c_of_type_Boolean) {
            break;
          }
          if (!this.jdField_a_of_type_Avut.jdField_a_of_type_Boolean) {
            break label478;
          }
          this.jdField_a_of_type_Avut.jdField_a_of_type_Int = (this.jdField_f_of_type_Int / 2 - this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.d() / 2 - this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.d() / 2);
          if (this.jdField_a_of_type_Avut.jdField_b_of_type_Int == -1000) {
            this.jdField_a_of_type_Avut.jdField_b_of_type_Int = (this.jdField_g_of_type_Int - this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.e() / 2 - afur.a(110.0F, BaseApplicationImpl.getContext().getResources()));
          }
          this.jdField_a_of_type_Avut.jdField_e_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.d("LyricsController", 2, "showLyricsInner mFloatParams: " + this.jdField_a_of_type_Avut);
          }
          this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a(this.jdField_a_of_type_Avut);
          this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a(this.jdField_a_of_type_Avut);
          this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a(this.jdField_a_of_type_Avut), this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.b(this.jdField_a_of_type_Avut));
          this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a(this.jdField_a_of_type_Avut), this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.b(this.jdField_a_of_type_Avut));
          boolean bool3 = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a(this.jdField_a_of_type_Avut);
          bool1 = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a(this.jdField_a_of_type_Avut);
          this.jdField_a_of_type_Avut.jdField_d_of_type_Boolean = false;
          if (bool1)
          {
            bool1 = bool2;
            if (bool3) {}
          }
          else
          {
            bool1 = true;
          }
          return bool1;
        }
      }
      boolean bool1 = true;
      continue;
      label478:
      this.jdField_a_of_type_Avut.jdField_a_of_type_Int = (this.jdField_f_of_type_Int / 2 + this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.d() / 2 + this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.d() / 2);
    }
    if (this.jdField_a_of_type_Avut.jdField_a_of_type_Boolean) {}
    for (this.jdField_a_of_type_Avut.jdField_a_of_type_Int = (this.jdField_d_of_type_Int + this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.d() / 2);; this.jdField_a_of_type_Avut.jdField_a_of_type_Int = (this.jdField_f_of_type_Int - this.jdField_b_of_type_Int - this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.d() / 2))
    {
      if (this.jdField_a_of_type_Avut.jdField_b_of_type_Int == -1000) {
        this.jdField_a_of_type_Avut.jdField_b_of_type_Int = (afur.a(70.0F, BaseApplicationImpl.getContext().getResources()) + this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.e() / 2);
      }
      this.jdField_a_of_type_Avut.jdField_e_of_type_Boolean = false;
      break;
    }
  }
  
  private void c(String paramString, int paramInt)
  {
    avuu localavuu = a();
    if (localavuu == null) {}
    while (!bgjw.a(localavuu.a(), paramString)) {
      return;
    }
    localavuu.a(paramInt);
  }
  
  private void j()
  {
    try
    {
      pmo.a();
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("mqq.intent.action.QQ_BACKGROUND");
      localIntentFilter.addAction("mqq.intent.action.QQ_FOREGROUND");
      BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void k()
  {
    if (!this.jdField_g_of_type_Boolean)
    {
      BaseApplicationImpl.getApplication().registerActivityLifecycleCallbacks(this.jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks);
      this.jdField_g_of_type_Boolean = true;
    }
  }
  
  private void l()
  {
    if (this.jdField_g_of_type_Boolean)
    {
      BaseApplicationImpl.getApplication().unregisterActivityLifecycleCallbacks(this.jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks);
      this.jdField_g_of_type_Boolean = false;
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.b();
    }
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
  }
  
  private void n()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    int j;
    int k;
    if (localBaseApplication != null)
    {
      j = localBaseApplication.getResources().getDisplayMetrics().widthPixels;
      k = localBaseApplication.getResources().getDisplayMetrics().heightPixels;
      if (j != this.jdField_f_of_type_Int)
      {
        this.jdField_f_of_type_Int = j;
        if (this.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.e();
        }
      }
      if (k != this.jdField_g_of_type_Int) {
        this.jdField_g_of_type_Int = k;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("LyricsController", 2, "updateLyricsFloatWindow mScreenWidth: " + this.jdField_f_of_type_Int + "  mScreenHeight: " + this.jdField_g_of_type_Int + " mIsListenFloatShowing=" + this.jdField_b_of_type_Boolean);
    }
    ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_Avut.jdField_h_of_type_Boolean = false;
    boolean bool1;
    if (this.jdField_b_of_type_Boolean) {
      if ((this.jdField_a_of_type_Avut.jdField_f_of_type_Boolean) && (!this.jdField_a_of_type_Avut.jdField_g_of_type_Boolean))
      {
        j = this.jdField_a_of_type_Avut.jdField_a_of_type_Int;
        k = this.jdField_a_of_type_Avut.jdField_b_of_type_Int;
        bool1 = this.jdField_a_of_type_Avut.jdField_a_of_type_Boolean;
        if (!this.jdField_a_of_type_Avut.jdField_c_of_type_Boolean) {
          break label473;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a() >= this.jdField_f_of_type_Int / 2) {
          break label445;
        }
        bool1 = true;
        if (!bool1) {
          break label450;
        }
        j = this.jdField_d_of_type_Int + this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.d() / 2;
        label251:
        this.jdField_a_of_type_Avut.jdField_e_of_type_Boolean = false;
      }
    }
    label259:
    label682:
    for (;;)
    {
      if (k < this.jdField_e_of_type_Int + this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.e() / 2) {
        k = this.jdField_e_of_type_Int + this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.e() / 2;
      }
      for (;;)
      {
        this.jdField_a_of_type_Avut.jdField_a_of_type_Boolean = bool1;
        this.jdField_a_of_type_Avut.jdField_a_of_type_Int = j;
        this.jdField_a_of_type_Avut.jdField_b_of_type_Int = k;
        this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a(this.jdField_a_of_type_Avut);
        this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a(this.jdField_a_of_type_Avut);
        if ((this.jdField_a_of_type_Avut.jdField_f_of_type_Boolean) && (!this.jdField_a_of_type_Avut.jdField_g_of_type_Boolean)) {
          h();
        }
        bool1 = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.c();
        this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a(this.jdField_a_of_type_Avut);
        this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a(this.jdField_a_of_type_Avut);
        boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.c();
        this.jdField_a_of_type_Avut.jdField_d_of_type_Boolean = false;
        if ((bool1 != bool2) && (bool2) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
          b(this.jdField_b_of_type_JavaLangString, this.i);
        }
        return;
        label445:
        bool1 = false;
        break;
        label450:
        j = this.jdField_f_of_type_Int - this.jdField_b_of_type_Int - this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.d() / 2;
        break label251;
        label473:
        if (this.jdField_a_of_type_Avut.jdField_d_of_type_Boolean)
        {
          if (bool1) {}
          for (j = this.jdField_f_of_type_Int / 2 - this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.d() / 2 - this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.d() / 2;; j = this.jdField_f_of_type_Int / 2 + this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.d() / 2 + this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.d() / 2)
          {
            this.jdField_a_of_type_Avut.jdField_e_of_type_Boolean = true;
            break;
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.c() <= this.jdField_d_of_type_Int)
        {
          j = this.jdField_d_of_type_Int - this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.d() / 2;
          bool1 = true;
          break label259;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.b() < this.jdField_f_of_type_Int - this.jdField_b_of_type_Int) {
          break label682;
        }
        j = this.jdField_f_of_type_Int - this.jdField_b_of_type_Int + this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.d() / 2;
        bool1 = false;
        break label259;
        if (k > this.jdField_g_of_type_Int - this.jdField_c_of_type_Int - this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.e() / 2) {
          k = this.jdField_g_of_type_Int - this.jdField_c_of_type_Int - this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.e() / 2;
        }
      }
    }
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
    synchronized (this.jdField_a_of_type_JavaUtilSet)
    {
      if (!this.jdField_a_of_type_JavaUtilSet.isEmpty())
      {
        localEditor.putStringSet("listen_together_lyric_user_closes", this.jdField_a_of_type_JavaUtilSet);
        localEditor.putInt("listen_together_float_loc_icon_cx", this.jdField_a_of_type_Avut.jdField_a_of_type_Int);
        localEditor.putInt("listen_together_float_loc_icon_cy", this.jdField_a_of_type_Avut.jdField_b_of_type_Int);
        localEditor.putBoolean("listen_together_float_align_right", this.jdField_a_of_type_Avut.jdField_a_of_type_Boolean);
        localEditor.apply();
        return;
      }
      localEditor.remove("listen_together_lyric_user_closes");
    }
  }
  
  public avut a()
  {
    return this.jdField_a_of_type_Avut;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LyricsController", 2, "onPositionChangeEnd mFloatParams:" + this.jdField_a_of_type_Avut + " mScreenWidth:" + this.jdField_f_of_type_Int + " mScreenHeight:" + this.jdField_g_of_type_Int);
    }
    n();
    o();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int j;
    int m;
    int k;
    if (this.jdField_b_of_type_Boolean)
    {
      j = this.jdField_a_of_type_Avut.jdField_a_of_type_Int;
      m = this.jdField_a_of_type_Avut.jdField_b_of_type_Int;
      k = j - paramInt1;
      j = this.jdField_f_of_type_Int;
      if (!this.jdField_a_of_type_Avut.jdField_a_of_type_Boolean) {
        break label231;
      }
      if ((!this.jdField_a_of_type_Avut.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Avut.jdField_b_of_type_Boolean)) {
        break label198;
      }
      paramInt1 = 0 - this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.d();
    }
    for (;;)
    {
      if (k < paramInt1)
      {
        label80:
        j = m - paramInt2;
        if (j >= 0) {
          break label313;
        }
        paramInt2 = 0;
      }
      for (;;)
      {
        this.jdField_a_of_type_Avut.jdField_e_of_type_Boolean = false;
        this.jdField_a_of_type_Avut.jdField_a_of_type_Int = paramInt1;
        this.jdField_a_of_type_Avut.jdField_b_of_type_Int = paramInt2;
        this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a(this.jdField_a_of_type_Avut), this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.b(this.jdField_a_of_type_Avut));
        this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a(this.jdField_a_of_type_Avut), this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.b(this.jdField_a_of_type_Avut));
        this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a(this.jdField_a_of_type_Avut);
        this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a(this.jdField_a_of_type_Avut);
        return;
        label198:
        if (this.jdField_a_of_type_Avut.jdField_b_of_type_Boolean) {
          break label331;
        }
        paramInt1 = 0 - this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.d();
        j -= this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.d();
        break;
        label231:
        if ((this.jdField_a_of_type_Avut.jdField_c_of_type_Boolean) && (!this.jdField_a_of_type_Avut.jdField_b_of_type_Boolean))
        {
          j += this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.d();
          paramInt1 = 0;
          break;
        }
        if (this.jdField_a_of_type_Avut.jdField_b_of_type_Boolean) {
          break label331;
        }
        paramInt1 = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.d() + 0;
        j += this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.d();
        break;
        paramInt1 = j;
        if (k > j) {
          break label80;
        }
        paramInt1 = k;
        break label80;
        label313:
        paramInt2 = j;
        if (j > this.jdField_g_of_type_Int) {
          paramInt2 = this.jdField_g_of_type_Int;
        }
      }
      label331:
      paramInt1 = 0;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.i("LyricsController", 2, "showLyrics, type:" + paramInt + " uin:" + paramString);
    }
    if (!b())
    {
      if (this.jdField_f_of_type_Boolean) {
        f();
      }
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_f_of_type_Boolean = false;
    }
    do
    {
      return;
      k();
      this.jdField_f_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = false;
      this.jdField_h_of_type_Int = 0;
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_JavaLangString = null;
    } while (!b(paramInt, paramString));
    this.jdField_a_of_type_Avut.a(paramInt, paramString);
    this.jdField_b_of_type_Boolean = true;
    String str;
    if (QLog.isColorLevel())
    {
      paramString = this.jdField_b_of_type_JavaLangString;
      str = avvg.a(this.i);
      if (this.jdField_c_of_type_JavaLangString != null) {
        break label261;
      }
    }
    label261:
    for (paramInt = j;; paramInt = this.jdField_c_of_type_JavaLangString.length())
    {
      QLog.i("LyricsController", 2, String.format("showLyrics[%s %s %d %s]", new Object[] { paramString, str, Integer.valueOf(paramInt), this.jdField_a_of_type_JavaLangBoolean }));
      a(this.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_JavaLangBoolean != null) {
        a(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangBoolean.booleanValue());
      }
      b(this.jdField_b_of_type_JavaLangString, this.i);
      if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.setPlayState(true);
      return;
    }
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LyricsController", 2, "onExitAIO, type:" + paramInt + " uin:" + paramString + ", isForeground: " + this.jdField_a_of_type_Boolean + " mFloatParams:" + this.jdField_a_of_type_Avut);
    }
    int k;
    int m;
    int j;
    if (this.jdField_a_of_type_Avut.b(paramInt, paramString))
    {
      this.jdField_a_of_type_Avut.b(0, null);
      if (!this.jdField_a_of_type_Avut.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_Avut.jdField_c_of_type_Boolean = true;
        this.jdField_a_of_type_Avut.jdField_d_of_type_Boolean = true;
        this.jdField_a_of_type_Avut.jdField_h_of_type_Boolean = false;
        if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout != null) && (this.jdField_a_of_type_Boolean))
        {
          if (!this.jdField_a_of_type_Avut.jdField_a_of_type_Boolean) {
            break label360;
          }
          paramString = Paint.Align.RIGHT;
          this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a.setAlign(paramString);
          k = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.f();
          m = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.f();
          if (!this.jdField_a_of_type_Avut.jdField_a_of_type_Boolean) {
            break label367;
          }
          j = -this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.d();
        }
      }
    }
    for (paramInt = -this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.d();; paramInt = this.jdField_f_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a(j, this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.g());
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a(paramInt, this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.g());
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.b();
      this.jdField_a_of_type_Avut.jdField_h_of_type_Boolean = true;
      this.jdField_a_of_type_Avut.jdField_g_of_type_Int = k;
      this.jdField_a_of_type_Avut.jdField_h_of_type_Int = m;
      this.jdField_a_of_type_Avut.jdField_a_of_type_AndroidGraphicsPaint$Align = Paint.Align.CENTER;
      ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      paramInt = 300;
      if (paramBoolean) {
        paramInt = 500;
      }
      ThreadManager.getUIHandlerV2().postDelayed(this.jdField_b_of_type_JavaLangRunnable, paramInt);
      bdpg.a().a(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout, this.jdField_a_of_type_Avut.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Avut.jdField_e_of_type_Int);
      return;
      label360:
      paramString = Paint.Align.LEFT;
      break;
      label367:
      j = this.jdField_f_of_type_Int;
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    int j = 0;
    String str;
    if (QLog.isColorLevel())
    {
      str = this.jdField_b_of_type_JavaLangString;
      if (paramString2 != null) {
        break label119;
      }
    }
    for (;;)
    {
      QLog.i("LyricsController", 2, String.format("onGetLyric [pre=%s,next=%s] netErr=%b lyric=%d %s", new Object[] { str, paramString1, Boolean.valueOf(paramBoolean), Integer.valueOf(j), paramString2 }));
      if ((paramString1 != null) && (paramString1.equals(this.jdField_b_of_type_JavaLangString)))
      {
        this.jdField_c_of_type_JavaLangString = paramString2;
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramBoolean);
        if (this.jdField_b_of_type_Boolean)
        {
          a(paramString1, paramString2, paramBoolean);
          b(this.jdField_b_of_type_JavaLangString, this.i);
        }
      }
      return;
      label119:
      j = paramString2.length();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    if (paramBoolean) {
      ThreadManager.getUIHandlerV2().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 500L);
    }
    do
    {
      return;
      this.jdField_a_of_type_Avut.jdField_f_of_type_Boolean = paramBoolean;
    } while (!this.jdField_b_of_type_Boolean);
    n();
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LyricsController", 2, "isListenFloatShowing : " + this.jdField_b_of_type_Boolean);
    }
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(int paramInt, String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilSet)
    {
      if (!this.jdField_a_of_type_JavaUtilSet.contains(paramInt + "_" + paramString))
      {
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.i("LyricsController", 2, "isLyricsTextShowing type:" + paramInt + " uin:" + paramString + " show:" + bool + " mLyricUserClosedAIOs:" + this.jdField_a_of_type_JavaUtilSet);
        }
        return bool;
      }
      boolean bool = false;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LyricsController", 2, "onClickLyrics mIsListenFloatShowing:" + this.jdField_b_of_type_Boolean);
    }
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    if ((this.jdField_a_of_type_Avut.a()) && (BaseActivity.sTopActivity != null))
    {
      localObject = bkho.a(BaseActivity.sTopActivity);
      boolean bool = avtq.a();
      if (bool) {
        ((bkho)localObject).b(2131693274);
      }
      ((bkho)localObject).b(2131693253);
      ((bkho)localObject).c(2131690582);
      ((bkho)localObject).a(new avvd(this));
      ((bkho)localObject).setOnCancelListener(new avve(this));
      ((bkho)localObject).a(new avuw(this, (bkho)localObject, bool));
      ((bkho)localObject).show();
      b(true);
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A5C1", 1, 0, "", "", "", "");
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("type", 1);
    ((Intent)localObject).putExtra("public_fragment_window_feature", 1);
    ((Intent)localObject).setFlags(268435456);
    aevv.a(BaseApplicationImpl.getContext(), (Intent)localObject, PublicTransFragmentActivity.class, ListenTogetherOverlayFragment.class);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout != null))
    {
      paramInt2 = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.d();
      if (QLog.isColorLevel()) {
        QLog.i("LyricsController", 2, "onLyricTextSizeChanged oldWidth:" + paramInt2 + " newWidth:" + paramInt1);
      }
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.setFloatWidth(paramInt1);
      if ((this.jdField_a_of_type_Avut.jdField_e_of_type_Boolean) && (!this.jdField_a_of_type_Avut.jdField_c_of_type_Boolean)) {
        if (!this.jdField_a_of_type_Avut.jdField_a_of_type_Boolean) {
          break label172;
        }
      }
    }
    label172:
    for (this.jdField_a_of_type_Avut.jdField_a_of_type_Int = (this.jdField_f_of_type_Int / 2 - this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.d() / 2 - this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.d() / 2);; this.jdField_a_of_type_Avut.jdField_a_of_type_Int = (this.jdField_f_of_type_Int / 2 + this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.d() / 2 + this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.d() / 2))
    {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a(this.jdField_a_of_type_Avut), this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.b(this.jdField_a_of_type_Avut));
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a();
      return;
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LyricsController", 2, "hideLyrics,  type:" + paramInt + " uin:" + paramString + " mFloatParams:" + this.jdField_a_of_type_Avut);
    }
    if (!this.jdField_a_of_type_Avut.a(paramInt, paramString)) {
      return;
    }
    ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    m();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Avut.a(0, null);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_h_of_type_Int = 0;
    l();
    bdpg.a().b();
  }
  
  protected void b(int paramInt, String paramString, boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilSet)
    {
      paramString = paramInt + "_" + paramString;
      if (paramBoolean) {
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
      }
      while (!this.jdField_a_of_type_JavaUtilSet.contains(paramString))
      {
        o();
        return;
      }
      this.jdField_a_of_type_JavaUtilSet.remove(paramString);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LyricsController", 2, "tmpGoneForSomePage yes: " + paramBoolean);
    }
    if (this.jdField_a_of_type_Avut.jdField_g_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Avut.jdField_g_of_type_Boolean = paramBoolean;
      if (this.jdField_b_of_type_Boolean) {
        n();
      }
    }
  }
  
  public void c()
  {
    int k = 1;
    if ((!this.jdField_b_of_type_Boolean) || (TextUtils.isEmpty(this.jdField_a_of_type_Avut.jdField_b_of_type_JavaLangString)) || ((this.jdField_a_of_type_Avut.jdField_e_of_type_Int != 2) && (this.jdField_a_of_type_Avut.jdField_e_of_type_Int != 1)) || (this.jdField_a_of_type_Avut.a())) {
      return;
    }
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    Object localObject = this.jdField_a_of_type_Avut.jdField_e_of_type_Int + "_" + this.jdField_a_of_type_Avut.jdField_b_of_type_JavaLangString;
    if (((BaseActivity.sTopActivity instanceof SplashActivity)) && (SplashActivity.jdField_a_of_type_Int == 1))
    {
      j = 1;
      if ((j == 0) && ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject)) || (!((Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)).booleanValue()))) {
        break label291;
      }
      localObject = new Intent(localBaseApplication, SplashActivity.class);
      if (j == 0) {
        break label286;
      }
      j = 1;
      label166:
      localObject = afur.a((Intent)localObject, new int[] { j });
      label178:
      ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_Avut.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_Avut.jdField_e_of_type_Int != 2) {
        break label328;
      }
      ((Intent)localObject).putExtra("uintype", 0);
      label213:
      ((Intent)localObject).addFlags(268435456);
      localBaseApplication.startActivity((Intent)localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!bdpg.a().a()) {
        break label355;
      }
    }
    label286:
    label291:
    label328:
    label355:
    for (int j = k;; j = 2)
    {
      bcst.b((QQAppInterface)localObject, "dc00898", "", "", "qq_vip", "0X800A5C0", j, 0, "", "", VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "");
      return;
      j = 0;
      break;
      j = 2;
      break label166;
      localObject = afur.a(new Intent(localBaseApplication, ChatActivity.class), new int[] { 2 });
      ((Intent)localObject).putExtra("leftViewText", "");
      break label178;
      ((Intent)localObject).putExtra("uintype", 1);
      ((Intent)localObject).putExtra("troop_uin", this.jdField_a_of_type_Avut.jdField_b_of_type_JavaLangString);
      break label213;
    }
  }
  
  public void c(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LyricsController", 2, "onEnterAIO, type:" + paramInt + " uin:" + paramString + " mFloatParams:" + this.jdField_a_of_type_Avut + " mIsForeground:" + this.jdField_a_of_type_Boolean);
    }
    this.jdField_a_of_type_Avut.b(paramInt, paramString);
    if (this.jdField_a_of_type_Avut.a(paramInt, paramString)) {}
    for (boolean bool = false;; bool = true)
    {
      if (bool != this.jdField_a_of_type_Avut.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_Avut.jdField_c_of_type_Boolean = bool;
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_Avut.jdField_d_of_type_Boolean = true;
        }
        n();
      }
      if (!(BaseActivity.sTopActivity instanceof SplashActivity)) {
        break;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramInt + "_" + paramString, Boolean.TRUE);
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramInt + "_" + paramString, Boolean.FALSE);
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LyricsController", 2, "tmpGoneForSomePageDelay yes: " + paramBoolean);
    }
    if (this.jdField_a_of_type_Avut.jdField_g_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Avut.jdField_g_of_type_Boolean = paramBoolean;
      if (this.jdField_b_of_type_Boolean)
      {
        ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        ThreadManager.getUIHandlerV2().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 500L);
      }
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      int j = this.jdField_a_of_type_Avut.jdField_e_of_type_Int;
      String str = this.jdField_a_of_type_Avut.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_Avts = new avux(this);
      ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(j, str, this.jdField_a_of_type_Avts);
    }
  }
  
  public void d(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LyricsController", 2, "onDestroyAIO, type:" + paramInt + " uin:" + paramString + ", isForeground: " + this.jdField_a_of_type_Boolean + " mFloatParams:" + this.jdField_a_of_type_Avut);
    }
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramInt + "_" + paramString);
  }
  
  public void e()
  {
    b(this.jdField_a_of_type_Avut.jdField_e_of_type_Int, this.jdField_a_of_type_Avut.jdField_b_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.b();
    }
    BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Avtk);
    l();
  }
  
  public void f()
  {
    boolean bool = b();
    this.jdField_f_of_type_Boolean = false;
    if (!bool)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LyricsController", 2, "checkPermissionAndShowDialog in mIsFirstJoinTipsShowing:" + this.jdField_d_of_type_Boolean);
      }
      if (!this.jdField_d_of_type_Boolean)
      {
        k();
        Intent localIntent = new Intent();
        localIntent.putExtra("type", 2);
        localIntent.putExtra("public_fragment_window_feature", 1);
        localIntent.setFlags(268435456);
        aevv.a(BaseApplicationImpl.getContext(), localIntent, PublicTransFragmentActivity.class, ListenTogetherOverlayFragment.class);
        this.jdField_c_of_type_Boolean = true;
        this.jdField_h_of_type_Int = 0;
        this.jdField_e_of_type_Boolean = false;
      }
    }
    for (;;)
    {
      ThreadManager.getSubThreadHandler().post(new LyricsController.4(this, bool));
      return;
      this.jdField_e_of_type_Boolean = true;
      continue;
      this.jdField_e_of_type_Boolean = false;
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_Avut.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Avut.jdField_g_of_type_Boolean = false;
    n();
    int j = this.jdField_a_of_type_Avut.jdField_e_of_type_Int;
    String str3 = this.jdField_a_of_type_Avut.jdField_b_of_type_JavaLangString;
    b(j, str3, true);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      ((avsy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(156)).notifyUI(14, true, new Object[] { Integer.valueOf(j), str3 });
      ((ListenTogetherManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(331)).a(j, str3, "closeLyric", 0);
      if ((j != 2) || (TextUtils.isEmpty(str3))) {
        break label156;
      }
      bcst.b(null, "dc00899", "c2c_AIO", "", "music_tab", "clk_close", 0, 0, str3, "", "", "");
    }
    label156:
    while ((j != 1) || (TextUtils.isEmpty(str3))) {
      return;
    }
    String str2 = "2";
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(str3);
    String str1 = str2;
    if (localTroopInfo != null)
    {
      if (!localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())) {
        break label249;
      }
      str1 = "0";
    }
    for (;;)
    {
      bcst.b(null, "dc00899", "Grp_AIO", "", "music_tab", "clk_close", 0, 0, str3, "", str1, "");
      return;
      label249:
      str1 = str2;
      if (localTroopInfo.isAdmin()) {
        str1 = "1";
      }
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a(this.jdField_a_of_type_Avut);
    int k = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.b(this.jdField_a_of_type_Avut);
    int m = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a(this.jdField_a_of_type_Avut);
    int n = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.b(this.jdField_a_of_type_Avut);
    int i1 = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.f();
    int i2 = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.g();
    int i3 = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.f();
    int i4 = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.g();
    if ((Math.abs(i1 - j) < 10) && (Math.abs(i2 - k) < 10) && (Math.abs(i3 - m) < 10) && (Math.abs(i4 - n) < 10))
    {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a(j, k);
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a(m, n);
      return;
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(250L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new avuy(this, i1, j, i2, k, i3, m, i4, n));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new avuz(this, j, k, m, n));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    Set localSet = ((SharedPreferences)localObject2).getStringSet("listen_together_lyric_user_closes", null);
    this.jdField_a_of_type_Avut.jdField_a_of_type_Int = ((SharedPreferences)localObject2).getInt("listen_together_float_loc_icon_cx", this.jdField_a_of_type_Avut.jdField_a_of_type_Int);
    this.jdField_a_of_type_Avut.jdField_b_of_type_Int = ((SharedPreferences)localObject2).getInt("listen_together_float_loc_icon_cy", this.jdField_a_of_type_Avut.jdField_b_of_type_Int);
    this.jdField_a_of_type_Avut.jdField_a_of_type_Boolean = ((SharedPreferences)localObject2).getBoolean("listen_together_float_align_right", this.jdField_a_of_type_Avut.jdField_a_of_type_Boolean);
    localObject2 = this.jdField_a_of_type_JavaUtilSet;
    if (localSet != null) {}
    try
    {
      if (!localSet.isEmpty()) {
        this.jdField_a_of_type_JavaUtilSet.addAll(localSet);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avuv
 * JD-Core Version:    0.7.0.1
 */