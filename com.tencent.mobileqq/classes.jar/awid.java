import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.fragment.ListenTogetherPlayFragment;
import com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel.5;
import com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel.6;
import com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel.7;
import com.tencent.mobileqq.listentogether.ui.MusicPanelView;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.SweepGradientCircleProgress;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;

public abstract class awid
  implements agin, Drawable.Callback, View.OnClickListener, beic
{
  long jdField_a_of_type_Long = 0L;
  private aiky jdField_a_of_type_Aiky;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public ViewGroup a;
  public FrameLayout a;
  public PopupWindow a;
  anvi jdField_a_of_type_Anvi = new awie(this);
  awfk jdField_a_of_type_Awfk = new awif(this);
  awfu jdField_a_of_type_Awfu;
  awfv jdField_a_of_type_Awfv;
  awik jdField_a_of_type_Awik;
  awil jdField_a_of_type_Awil = new awil();
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  public BaseActivity a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new BaseListenTogetherPanel.7(this);
  boolean jdField_a_of_type_Boolean = false;
  boolean b;
  boolean c;
  boolean d;
  protected boolean e;
  
  public awid(BaseChatPie paramBaseChatPie)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "oncreate");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseChatPie.getActivity();
    this.jdField_a_of_type_AndroidViewViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAIORootView;
    behu.a().a(a());
    behu.a().a(this);
  }
  
  private aiky a()
  {
    if (this.jdField_a_of_type_Aiky == null)
    {
      this.jdField_a_of_type_Aiky = new aiky(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getTipManager() != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getTipManager().a(this.jdField_a_of_type_Aiky);
      }
    }
    return this.jdField_a_of_type_Aiky;
  }
  
  private CharSequence a()
  {
    Object localObject1 = a(16);
    String str = this.jdField_a_of_type_Awil.jdField_d_of_type_JavaLangString;
    Object localObject2 = this.jdField_a_of_type_Awil.jdField_b_of_type_JavaLangString;
    int i;
    if (this.jdField_a_of_type_Awil.jdField_a_of_type_Int == 1)
    {
      i = 1;
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!anvx.a(2131693555).equalsIgnoreCase((String)localObject2))) {
        break label188;
      }
      if ((i == 0) || (TextUtils.isEmpty(str))) {
        break label183;
      }
      i = 1;
    }
    for (;;)
    {
      if ((i == 0) || (TextUtils.isEmpty((CharSequence)localObject1))) {
        break label266;
      }
      localObject2 = FaceDrawable.getUserFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_Awil.jdField_c_of_type_JavaLangString, (byte)4);
      i = AIOUtils.dp2px(11.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
      ((Drawable)localObject2).setBounds(0, 0, i, i);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject2);
      localObject1 = new SpannableString("[avatar]  " + (String)localObject1);
      ((SpannableString)localObject1).setSpan(new awij((Drawable)localObject2, 1), 0, "[avatar]  ".length() - 1, 18);
      return localObject1;
      i = 0;
      break;
      label183:
      i = 0;
      continue;
      label188:
      if (i != 0)
      {
        if (!TextUtils.isEmpty(str))
        {
          localObject1 = str + "发起 | " + (String)localObject2;
          i = 1;
        }
        else
        {
          localObject1 = (String)localObject2 + " | " + (String)localObject1;
          i = 0;
        }
      }
      else
      {
        i = 0;
        localObject1 = localObject2;
      }
    }
    label266:
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    return localObject1;
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onListenTogetherJoinedCountChange");
    }
    if (!a(paramInt, paramString1)) {
      return;
    }
    this.jdField_a_of_type_Awil.jdField_b_of_type_JavaLangString = paramString2;
    a();
    a(this.jdField_a_of_type_Awil);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    MusicPanelView localMusicPanelView;
    do
    {
      return;
      localMusicPanelView = a();
    } while ((!c()) || (localMusicPanelView == null));
    SweepGradientCircleProgress localSweepGradientCircleProgress = (SweepGradientCircleProgress)localMusicPanelView.findViewById(2131371734);
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 3))
    {
      int k = (paramInt - 1) * 4;
      paramInt = awer.a[k];
      int i = awer.a[(k + 1)];
      int j = awer.a[(k + 2)];
      k = awer.a[(k + 3)];
      localSweepGradientCircleProgress.setBgAndProgressColor(100, paramInt, 100, i);
      localSweepGradientCircleProgress.setNeedSweepGradient(true, i, j);
      localSweepGradientCircleProgress.setmShadowColor(k);
      localSweepGradientCircleProgress.setShadowRadius(AIOUtils.dp2px(1.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources()));
      return;
    }
    localMusicPanelView.setMusicProgressDefaultShow();
  }
  
  public static void a(View paramView1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView2)
  {
    if ((paramView2 == null) || (Thread.currentThread() != Looper.getMainLooper().getThread()) || ((VersionUtils.isKITKAT()) && (!paramView2.isAttachedToWindow()))) {
      return;
    }
    paramView2.post(new BaseListenTogetherPanel.5(paramView1, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public static void a(View paramView1, View paramView2)
  {
    if ((paramView2 == null) || (Thread.currentThread() != Looper.getMainLooper().getThread()) || ((VersionUtils.isKITKAT()) && (!paramView2.isAttachedToWindow()))) {
      return;
    }
    paramView2.post(new BaseListenTogetherPanel.6(paramView1));
  }
  
  private boolean a(int paramInt, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Awil.jdField_a_of_type_JavaLangString.equals(paramString))
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Awil.jdField_a_of_type_Int == paramInt) {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "checkTypeAndUin, result=" + bool1 + ",type=" + paramInt + ",uin=" + paramString);
    }
    return bool1;
  }
  
  private boolean a(ListenTogetherSession paramListenTogetherSession)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramListenTogetherSession != null)
    {
      bool1 = bool2;
      if (paramListenTogetherSession.e.equals(this.jdField_a_of_type_Awil.jdField_a_of_type_JavaLangString))
      {
        bool1 = bool2;
        if (paramListenTogetherSession.jdField_f_of_type_Int == this.jdField_a_of_type_Awil.jdField_a_of_type_Int) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void b(awil paramawil)
  {
    MusicPanelView localMusicPanelView = a();
    if ((!c()) || (localMusicPanelView == null)) {
      return;
    }
    localMusicPanelView.b(0, paramawil.jdField_d_of_type_Int);
    localMusicPanelView.a(0, awfq.a(paramawil.jdField_a_of_type_Long) + " / " + awfq.a(paramawil.jdField_b_of_type_Long));
  }
  
  private void b(ListenTogetherSession paramListenTogetherSession)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.i("BaseListenTogetherPanel", 2, "updateCurUiData");
    }
    MusicInfo localMusicInfo = null;
    if (this.jdField_a_of_type_Awil.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession != null) {
      localMusicInfo = this.jdField_a_of_type_Awil.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.a();
    }
    Object localObject = paramListenTogetherSession.a();
    if ((localMusicInfo == null) || (localObject == null) || (localMusicInfo.jdField_a_of_type_JavaLangString != ((MusicInfo)localObject).jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Awil.jdField_d_of_type_Int = 0;
      this.jdField_a_of_type_Awil.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_Awil.jdField_b_of_type_Long = 0L;
      this.jdField_a_of_type_Awil.jdField_d_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Awil.jdField_b_of_type_Int = paramListenTogetherSession.h;
    this.jdField_a_of_type_Awil.jdField_c_of_type_Int = paramListenTogetherSession.i;
    this.jdField_a_of_type_Awil.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession = paramListenTogetherSession;
    localObject = this.jdField_a_of_type_Awil;
    if (!paramListenTogetherSession.jdField_a_of_type_Boolean) {
      bool = true;
    }
    ((awil)localObject).jdField_c_of_type_Boolean = bool;
    this.jdField_a_of_type_Awil.jdField_c_of_type_JavaLangString = paramListenTogetherSession.jdField_f_of_type_JavaLangString;
    this.jdField_a_of_type_Awil.jdField_d_of_type_JavaLangString = paramListenTogetherSession.g;
    this.jdField_a_of_type_Awil.jdField_a_of_type_Boolean = a();
    this.jdField_a_of_type_Awil.jdField_b_of_type_Boolean = b();
    this.jdField_a_of_type_Awil.e = paramListenTogetherSession.jdField_c_of_type_Int;
    this.jdField_a_of_type_Awil.jdField_f_of_type_Int = paramListenTogetherSession.jdField_d_of_type_Int;
    if (localMusicInfo != null)
    {
      if (localMusicInfo.jdField_a_of_type_Long >= 0L) {
        this.jdField_a_of_type_Awil.jdField_a_of_type_Long = localMusicInfo.jdField_a_of_type_Long;
      }
      if ((this.jdField_a_of_type_Awil.jdField_b_of_type_Long == 0L) && (localMusicInfo.d != 0L)) {
        this.jdField_a_of_type_Awil.jdField_d_of_type_Boolean = true;
      }
      this.jdField_a_of_type_Awil.jdField_b_of_type_Long = (localMusicInfo.d * 1000L);
    }
    behu.a().a(this.jdField_a_of_type_Awil.jdField_a_of_type_Boolean);
  }
  
  private void j()
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131694461), 0).a();
      return;
    }
    int i = this.jdField_a_of_type_Awil.jdField_a_of_type_Int;
    String str = this.jdField_a_of_type_Awil.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Awfv = new awih(this, i, str);
    ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, i, str, this.jdField_a_of_type_Awfv);
  }
  
  private void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "destroyUI()");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getAIORootView() != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getAIORootView().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null)
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.aioTipsController != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.aioTipsController.a(null);
    }
    this.jdField_a_of_type_Awil.a();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
    a();
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "jumpWeb, isLaunchingWeb=" + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    awfq.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Awil.jdField_a_of_type_Int, this.jdField_a_of_type_Awil.jdField_a_of_type_JavaLangString, 1);
  }
  
  private void o()
  {
    boolean bool = awfq.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
    if ((!bool) && ((this.jdField_a_of_type_AndroidWidgetPopupWindow == null) || (!this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) && (d()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getAIORootView() != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getAIORootView().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
      awfq.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "showGuide, hasShow=" + bool);
    }
  }
  
  public MusicPanelView a()
  {
    if (this.jdField_a_of_type_Aiky != null) {
      return (MusicPanelView)this.jdField_a_of_type_Aiky.a();
    }
    return null;
  }
  
  public String a(int paramInt)
  {
    String str = this.jdField_a_of_type_Awil.jdField_d_of_type_JavaLangString;
    if (str == null) {
      return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693533);
    }
    if (TextUtils.isEmpty(str)) {
      return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693549);
    }
    str = beki.a(paramInt, str);
    return str + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693572);
  }
  
  public String a(boolean paramBoolean)
  {
    if (anvx.a(2131693555).equals(this.jdField_a_of_type_Awil.jdField_b_of_type_JavaLangString)) {}
    for (String str = a(16);; str = this.jdField_a_of_type_Awil.jdField_b_of_type_JavaLangString)
    {
      if (paramBoolean) {
        str = anvx.a(2131693576);
      }
      return str;
    }
  }
  
  public abstract void a();
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    case 7: 
    case 9: 
    case 12: 
    case 13: 
    default: 
      return;
    case 4: 
      d();
      return;
    case 8: 
      c();
      return;
    case 6: 
      e();
      return;
    case 10: 
      f();
      return;
    case 11: 
      g();
      return;
    }
    h();
  }
  
  public void a(int paramInt, ailp paramailp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onOtherTipsShow tip=" + paramailp + " type=" + paramInt);
    }
    if (paramInt == 1) {}
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onExitListenTogetherFail");
    }
    if (!a(paramInt, paramString)) {
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, anvx.a(2131700514), 1).a();
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onJoinListenTogetherFail");
    }
    if (!a(paramInt, paramString)) {
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, anvx.a(2131700513), 1).a();
    this.jdField_a_of_type_Awil.jdField_c_of_type_Int = 1;
    a(this.jdField_a_of_type_Awil);
  }
  
  protected void a(awil paramawil)
  {
    int j = 0;
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "freshUI, isListenTogetherTime=" + c() + ",isPanelShow=" + d());
    }
    MusicPanelView localMusicPanelView = a();
    if ((!c()) || (localMusicPanelView == null)) {
      return;
    }
    Object localObject = paramawil.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession;
    int k = paramawil.jdField_b_of_type_Int;
    localObject = ((ListenTogetherSession)localObject).a();
    if (paramawil.jdField_c_of_type_Int == 2) {
      if (k == 4)
      {
        localMusicPanelView.a(8, k);
        localMusicPanelView.c(0);
        localMusicPanelView.a(0);
        localMusicPanelView.a("");
        localMusicPanelView.b(8);
        localMusicPanelView.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693554), 2131167008);
        localMusicPanelView.a(8, "");
        localMusicPanelView.b(0, 0);
        localMusicPanelView.b();
        label183:
        localMusicPanelView.d(8);
        if (k == 4) {
          localMusicPanelView.a(8, k);
        }
        localMusicPanelView.postInvalidate();
      }
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Awil.jdField_f_of_type_Int, this.e);
      if (i != 0) {
        break;
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      return;
      if (paramawil.jdField_b_of_type_Boolean)
      {
        localMusicPanelView.a(0, k);
        label250:
        if (localObject == null) {
          break label409;
        }
        localMusicPanelView.a(((MusicInfo)localObject).e);
        localMusicPanelView.a(awfq.a((MusicInfo)localObject), 2131167006);
        label278:
        localMusicPanelView.a(0);
        localMusicPanelView.c(0);
        localMusicPanelView.e(0);
        if (k != 2) {
          break label451;
        }
        localMusicPanelView.b(0);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Awil.jdField_d_of_type_Boolean)
        {
          localMusicPanelView.b(0, paramawil.jdField_d_of_type_Int);
          localMusicPanelView.a(0, awfq.a(paramawil.jdField_a_of_type_Long) + " / " + awfq.a(paramawil.jdField_b_of_type_Long));
          localMusicPanelView.b();
          this.jdField_a_of_type_Awil.jdField_d_of_type_Boolean = false;
        }
        if (k != 1) {
          break label461;
        }
        localMusicPanelView.a();
        break;
        localMusicPanelView.a(8, k);
        break label250;
        label409:
        localMusicPanelView.a("");
        localMusicPanelView.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693554), 2131167008);
        localMusicPanelView.a(8, "");
        break label278;
        label451:
        localMusicPanelView.b(8);
      }
      label461:
      if (k != 2) {
        break label183;
      }
      localMusicPanelView.c();
      break label183;
      if ((paramawil.jdField_c_of_type_Int == 1) || (paramawil.jdField_c_of_type_Int == 3))
      {
        localMusicPanelView.b(8);
        localMusicPanelView.c(8);
        localMusicPanelView.a(8, k);
        localMusicPanelView.d(0);
        localMusicPanelView.a(8);
        localMusicPanelView.b(0, 0);
        localMusicPanelView.b();
        if (k != 4) {
          break label609;
        }
        localMusicPanelView.a("");
        localMusicPanelView.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693554), 2131167008);
        localMusicPanelView.a(8, "");
        i = j;
        if (k == 4) {
          localMusicPanelView.a(8, k);
        }
        localMusicPanelView.postInvalidate();
      }
    }
    label609:
    if (localObject != null)
    {
      localMusicPanelView.a(((MusicInfo)localObject).e);
      localMusicPanelView.a(awfq.a((MusicInfo)localObject), 2131167006);
      localObject = a();
      paramawil = (awil)localObject;
      if (localObject == null) {
        paramawil = "";
      }
      localMusicPanelView.a(0, paramawil);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        break label726;
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(this);
    }
    label726:
    for (i = 1;; i = 0)
    {
      break;
      localMusicPanelView.a("");
      localMusicPanelView.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693554), 2131167008);
      localMusicPanelView.a(8, "");
      i = j;
      break;
    }
  }
  
  public void a(ListenTogetherSession paramListenTogetherSession)
  {
    if (!a(paramListenTogetherSession))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseListenTogetherPanel", 2, "onUIModuleNeedRefresh, checkSession is false");
      }
      return;
    }
    b(paramListenTogetherSession);
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onUIModuleNeedRefresh, uidata=" + this.jdField_a_of_type_Awil);
    }
    behu.a().a(paramListenTogetherSession.e, paramListenTogetherSession.jdField_f_of_type_Int);
    if (this.jdField_a_of_type_Awil.jdField_b_of_type_Int == 3)
    {
      String str;
      if (c())
      {
        str = this.jdField_a_of_type_Awik.jdField_a_of_type_JavaLangString;
        if (!d()) {
          break label210;
        }
      }
      label210:
      for (paramListenTogetherSession = "clk_expand";; paramListenTogetherSession = "clk_fold")
      {
        bdla.b(null, "dc00899", str, "", "music_tab", paramListenTogetherSession, 0, 0, this.jdField_a_of_type_Awik.jdField_b_of_type_JavaLangString, "", this.jdField_a_of_type_Awik.jdField_a_of_type_Int + "", "");
        bdla.b(null, "dc00898", "", "", "qq_vip", "0X800A5BD", 0, 0, "", "", "", "");
        f();
        return;
      }
    }
    behu.a().a(a());
    boolean bool = this.jdField_a_of_type_Awil.jdField_c_of_type_Boolean;
    if (d() != bool)
    {
      if (!bool) {
        break label292;
      }
      e();
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Awil);
      a();
      if ((!bool) || (this.jdField_d_of_type_Boolean) || (this.jdField_c_of_type_Boolean)) {
        break;
      }
      this.jdField_d_of_type_Boolean = true;
      i();
      return;
      label292:
      f();
    }
  }
  
  protected void a(String paramString, int paramInt1, int paramInt2)
  {
    if ((!c()) || (this.jdField_a_of_type_Awil.jdField_c_of_type_Int != 2)) {}
    do
    {
      do
      {
        return;
        MusicInfo localMusicInfo = this.jdField_a_of_type_Awil.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.a();
        if ((localMusicInfo == null) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(localMusicInfo.jdField_a_of_type_JavaLangString))) {
          break;
        }
        int i = paramInt1;
        try
        {
          if (this.jdField_a_of_type_Awil.jdField_d_of_type_Int > 97)
          {
            i = paramInt1;
            if (paramInt1 < 0) {
              i = paramInt2;
            }
          }
          paramInt1 = (int)(i * 1.0F / paramInt2 * 100.0F);
          this.jdField_a_of_type_Awil.jdField_a_of_type_Long = i;
          this.jdField_a_of_type_Awil.jdField_b_of_type_Long = paramInt2;
          this.jdField_a_of_type_Awil.jdField_d_of_type_Int = paramInt1;
          b(this.jdField_a_of_type_Awil);
          return;
        }
        catch (Exception paramString) {}
      } while (!QLog.isColorLevel());
      QLog.e("BaseListenTogetherPanel", 2, "onPlayProgressChange, exception:", paramString);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("BaseListenTogetherPanel", 2, "onPlayProgressChange, music id is not same");
  }
  
  public abstract boolean a();
  
  public int[] a()
  {
    return new int[] { 4, 8, 6, 10, 11, 14 };
  }
  
  public void b()
  {
    if ((!c()) || (Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_Long) < 500L)) {
      return;
    }
    boolean bool = d();
    if (bool) {
      f();
    }
    for (;;)
    {
      a();
      ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app).a(bool, this.jdField_a_of_type_Awil.jdField_a_of_type_Int, this.jdField_a_of_type_Awil.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      return;
      e();
    }
  }
  
  public void b(int paramInt, ailp paramailp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onOtherTipsHide tip=" + paramailp + " type=" + paramInt);
    }
    if (!c()) {
      if (QLog.isColorLevel()) {
        QLog.d("BaseListenTogetherPanel", 2, "onOtherTipsHide mUIData is null or session is null");
      }
    }
    while ((paramInt != 1) || (this.jdField_a_of_type_Aiky == null) || (this.jdField_a_of_type_Aiky == paramailp)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onOtherTipsHide tip not equal TogetherTip");
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onOtherTipsHide expand=" + this.jdField_a_of_type_Awil.jdField_c_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Awil.jdField_c_of_type_Boolean) {
      e();
    }
    a();
  }
  
  protected void b(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onLyricModuleCloseByFloat");
    }
    if (!a(paramInt, paramString)) {
      return;
    }
    o();
  }
  
  public abstract boolean b();
  
  public void c()
  {
    awfq.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin);
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_Awil.jdField_b_of_type_Int != 0) && (this.jdField_a_of_type_Awil.jdField_b_of_type_Int != 3) && (this.jdField_a_of_type_Awil.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession != null);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onCreate()");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.addObserver(this.jdField_a_of_type_Awfk);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.addObserver(this.jdField_a_of_type_Anvi);
  }
  
  public boolean d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getTipManager() == null) || (this.jdField_a_of_type_Aiky == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("BaseListenTogetherPanel", 2, "tipManager is null or together is null");
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getTipManager().a() != this.jdField_a_of_type_Aiky) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "curTip is togetherTip");
    }
    return true;
  }
  
  public void e()
  {
    this.jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onResume()");
    }
    this.jdField_a_of_type_Boolean = false;
    ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app).a(this.jdField_a_of_type_Awil.jdField_a_of_type_Int, this.jdField_a_of_type_Awil.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hashCode());
    ChatFragment localChatFragment = ((FragmentActivity)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity()).getChatFragment();
    behu.a().a(localChatFragment, String.valueOf(this.jdField_a_of_type_Awil.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Awil.jdField_a_of_type_Int);
  }
  
  public boolean e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "showTogetherTip");
    }
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getTipManager() == null) {
      if (QLog.isColorLevel()) {
        QLog.d("BaseListenTogetherPanel", 2, "tipManager is null");
      }
    }
    do
    {
      return false;
      ailp localailp = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getTipManager().a();
      if ((localailp == null) || (localailp == this.jdField_a_of_type_Aiky)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("BaseListenTogetherPanel", 2, "currTip is other");
    return false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getTipManager().a(this.jdField_a_of_type_Aiky, new Object[0]);
    return true;
  }
  
  public void f()
  {
    this.jdField_b_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onPause()");
    }
    ailr localailr = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getTipManager();
    if (localailr != null) {
      localailr.a(1003, new Object[0]);
    }
    ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app).b(this.jdField_a_of_type_Awil.jdField_a_of_type_Int, this.jdField_a_of_type_Awil.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hashCode());
  }
  
  public boolean f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "dismissTogetherTip");
    }
    if ((this.jdField_a_of_type_Aiky == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getTipManager() == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("BaseListenTogetherPanel", 2, "tipManager is null or together is null");
      }
    }
    ailp localailp;
    do
    {
      return false;
      localailp = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getTipManager().a();
    } while ((localailp == null) || (localailp != this.jdField_a_of_type_Aiky));
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "currTip is togetherTip");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getTipManager().a();
    return true;
  }
  
  public void g()
  {
    this.jdField_b_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onStop()");
    }
    this.jdField_a_of_type_Boolean = false;
    String str2;
    if (c())
    {
      str2 = this.jdField_a_of_type_Awik.jdField_a_of_type_JavaLangString;
      if (!d()) {
        break label108;
      }
    }
    label108:
    for (String str1 = "clk_expand";; str1 = "clk_fold")
    {
      bdla.b(null, "dc00899", str2, "", "music_tab", str1, 0, 0, this.jdField_a_of_type_Awik.jdField_b_of_type_JavaLangString, "", this.jdField_a_of_type_Awik.jdField_a_of_type_Int + "", "");
      return;
    }
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onDestroy()");
    }
    behu.a().c();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.removeObserver(this.jdField_a_of_type_Awfk);
    ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app).d(this.jdField_a_of_type_Awil.jdField_a_of_type_Int, this.jdField_a_of_type_Awil.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hashCode());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getApp().removeObserver(this.jdField_a_of_type_Anvi);
    m();
  }
  
  protected void i() {}
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    a(this.jdField_a_of_type_Awil);
  }
  
  public void k() {}
  
  public void l() {}
  
  public void onClick(View paramView)
  {
    int i = 1;
    int j = paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.i("BaseListenTogetherPanel", 2, "onClick, id = " + j);
    }
    if (BaseChatItemLayout.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (j)
      {
      default: 
        break;
      case 2131369617: 
        j();
        break;
      case 2131378016: 
        if ((this.jdField_a_of_type_Awil.jdField_c_of_type_Int == 2) && (b()))
        {
          if (NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity)) {
            break label168;
          }
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131694461), 0).a();
        }
        break;
      }
    }
    label168:
    j = this.jdField_a_of_type_Awil.jdField_b_of_type_Int;
    if (j == 1)
    {
      ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app).a(this.jdField_a_of_type_Awil.jdField_a_of_type_Int, this.jdField_a_of_type_Awil.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Awil.jdField_b_of_type_Int = 2;
      bdla.b(null, "dc00899", this.jdField_a_of_type_Awik.jdField_a_of_type_JavaLangString, "", "music_tab", "clk_pause", 0, 0, this.jdField_a_of_type_Awik.jdField_b_of_type_JavaLangString, "", this.jdField_a_of_type_Awik.jdField_a_of_type_Int + "", "");
    }
    while (i != 0)
    {
      a(this.jdField_a_of_type_Awil);
      break;
      if (j == 2)
      {
        ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app).b(this.jdField_a_of_type_Awil.jdField_a_of_type_Int, this.jdField_a_of_type_Awil.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Awil.jdField_b_of_type_Int = 1;
        continue;
        if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131694461), 0).a();
          break;
        }
        this.jdField_a_of_type_Awfu = new awig(this);
        ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app).a(this.jdField_a_of_type_Awil.jdField_a_of_type_Int, this.jdField_a_of_type_Awil.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Awfu);
        break;
        if (this.jdField_a_of_type_Awil.jdField_c_of_type_Int == 2)
        {
          ListenTogetherSession localListenTogetherSession = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a(this.jdField_a_of_type_Awil.jdField_a_of_type_Int, this.jdField_a_of_type_Awil.jdField_a_of_type_JavaLangString);
          if ((this.jdField_a_of_type_Awil.jdField_b_of_type_Int == 1) || (this.jdField_a_of_type_Awil.jdField_b_of_type_Int == 2)) {}
          for (i = 1;; i = 0)
          {
            if ((localListenTogetherSession != null) && (i != 0))
            {
              MusicInfo localMusicInfo = localListenTogetherSession.a();
              ListenTogetherPlayFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localListenTogetherSession, localMusicInfo, this.jdField_a_of_type_Awil.jdField_a_of_type_Boolean, null);
            }
            bdla.b(null, "dc00899", this.jdField_a_of_type_Awik.jdField_a_of_type_JavaLangString, "", "music_tab", "clk_detail", 0, 0, this.jdField_a_of_type_Awik.jdField_b_of_type_JavaLangString, "", this.jdField_a_of_type_Awik.jdField_a_of_type_Int + "", "");
            break;
          }
        }
        if ((this.jdField_a_of_type_Awil.jdField_c_of_type_Int != 1) && (this.jdField_a_of_type_Awil.jdField_c_of_type_Int != 3)) {
          break;
        }
        j();
        break;
        n();
        bdla.b(null, "dc00899", this.jdField_a_of_type_Awik.jdField_a_of_type_JavaLangString, "", "music_tab", "clk_list", 0, 0, this.jdField_a_of_type_Awik.jdField_b_of_type_JavaLangString, "", this.jdField_a_of_type_Awik.jdField_a_of_type_Int + "", "");
        break;
      }
      i = 0;
    }
  }
  
  public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong) {}
  
  public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awid
 * JD-Core Version:    0.7.0.1
 */