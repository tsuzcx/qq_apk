import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.fragment.ListenTogetherPlayFragment;
import com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel.4;
import com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel.5;
import com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel.6;
import com.tencent.mobileqq.listentogether.ui.MusicPanelView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public abstract class atpc
  implements affa, View.OnClickListener
{
  long jdField_a_of_type_Long = 0L;
  private ahaa jdField_a_of_type_Ahaa;
  public ViewGroup a;
  public FrameLayout a;
  public PopupWindow a;
  atml jdField_a_of_type_Atml = new atpd(this);
  atmt jdField_a_of_type_Atmt;
  atmu jdField_a_of_type_Atmu;
  atph jdField_a_of_type_Atph;
  atpi jdField_a_of_type_Atpi = new atpi();
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  public BaseActivity a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new BaseListenTogetherPanel.6(this);
  boolean jdField_a_of_type_Boolean = false;
  boolean b;
  boolean c;
  boolean d;
  
  public atpc(BaseChatPie paramBaseChatPie)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "oncreate");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseChatPie.a();
    this.jdField_a_of_type_AndroidViewViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c;
    banz.a().a(a());
  }
  
  private ahaa a()
  {
    if (this.jdField_a_of_type_Ahaa == null)
    {
      this.jdField_a_of_type_Ahaa = new ahaa(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a(this.jdField_a_of_type_Ahaa);
      }
    }
    return this.jdField_a_of_type_Ahaa;
  }
  
  private String a()
  {
    try
    {
      String str4 = a(0);
      String str3 = this.jdField_a_of_type_Atpi.jdField_b_of_type_JavaLangString;
      if ((TextUtils.isEmpty(str3)) || (alud.a(2131693962).equalsIgnoreCase(str3))) {
        return a(0);
      }
      String str1 = str3;
      if (this.jdField_a_of_type_Atpi.jdField_a_of_type_Int == 1)
      {
        int i = str4.indexOf(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693985));
        if (i > 0)
        {
          str1 = str4.substring(0, i);
          return str3 + " | 发起人 " + str1;
        }
        str1 = str3 + " | " + str4;
        return str1;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.d("BaseListenTogetherPanel", 1, localThrowable.getMessage(), localThrowable);
      String str2 = "";
      return str2;
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onListenTogetherJoinedCountChange");
    }
    if (!a(paramInt, paramString1)) {
      return;
    }
    this.jdField_a_of_type_Atpi.jdField_b_of_type_JavaLangString = paramString2;
    a();
    a(this.jdField_a_of_type_Atpi);
  }
  
  public static void a(View paramView)
  {
    ((View)paramView.getParent()).post(new BaseListenTogetherPanel.5(paramView));
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ((View)paramView.getParent()).post(new BaseListenTogetherPanel.4(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  private void a(atpi paramatpi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "freshUI, isListenTogetherTime=" + c() + ",isPanelShow=" + d());
    }
    MusicPanelView localMusicPanelView = a();
    if ((!c()) || (localMusicPanelView == null)) {}
    Object localObject;
    int i;
    label209:
    label234:
    do
    {
      return;
      localObject = paramatpi.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession;
      i = paramatpi.jdField_b_of_type_Int;
      localObject = ((ListenTogetherSession)localObject).a();
      if (paramatpi.jdField_c_of_type_Int == 2)
      {
        if (i == 4)
        {
          localMusicPanelView.a(8, i);
          localMusicPanelView.c(0);
          localMusicPanelView.a(0);
          localMusicPanelView.a("");
          localMusicPanelView.b(8);
          localMusicPanelView.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693961), 2131166887);
          localMusicPanelView.a(8, "");
          localMusicPanelView.b(0, 0);
          localMusicPanelView.b();
        }
        for (;;)
        {
          localMusicPanelView.d(8);
          if (i == 4) {
            localMusicPanelView.a(8, i);
          }
          localMusicPanelView.postInvalidate();
          return;
          if (paramatpi.jdField_b_of_type_Boolean)
          {
            localMusicPanelView.a(0, i);
            if (localObject == null) {
              break label362;
            }
            localMusicPanelView.a(((MusicInfo)localObject).jdField_e_of_type_JavaLangString);
            localMusicPanelView.a(atmr.a((MusicInfo)localObject), 2131166885);
            localMusicPanelView.a(0);
            localMusicPanelView.c(0);
            localMusicPanelView.e(0);
            if (i != 2) {
              break label402;
            }
            localMusicPanelView.b(0);
          }
          for (;;)
          {
            if (this.jdField_a_of_type_Atpi.jdField_d_of_type_Boolean)
            {
              localMusicPanelView.b(0, paramatpi.jdField_d_of_type_Int);
              localMusicPanelView.a(0, atmr.a(paramatpi.jdField_a_of_type_Long) + " / " + atmr.a(paramatpi.jdField_b_of_type_Long));
              localMusicPanelView.b();
              this.jdField_a_of_type_Atpi.jdField_d_of_type_Boolean = false;
            }
            if (i != 1) {
              break label412;
            }
            localMusicPanelView.a();
            break;
            localMusicPanelView.a(8, i);
            break label209;
            localMusicPanelView.a("");
            localMusicPanelView.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693961), 2131166887);
            localMusicPanelView.a(8, "");
            break label234;
            localMusicPanelView.b(8);
          }
          if (i == 2) {
            localMusicPanelView.c();
          }
        }
      }
    } while ((paramatpi.jdField_c_of_type_Int != 1) && (paramatpi.jdField_c_of_type_Int != 3));
    label362:
    localMusicPanelView.b(8);
    label402:
    label412:
    localMusicPanelView.c(8);
    localMusicPanelView.a(8, i);
    localMusicPanelView.d(0);
    localMusicPanelView.a(8);
    localMusicPanelView.b(0, 0);
    localMusicPanelView.b();
    if (i == 4)
    {
      localMusicPanelView.a("");
      localMusicPanelView.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693961), 2131166887);
      localMusicPanelView.a(8, "");
    }
    for (;;)
    {
      if (i == 4) {
        localMusicPanelView.a(8, i);
      }
      localMusicPanelView.postInvalidate();
      return;
      if (localObject != null)
      {
        localMusicPanelView.a(((MusicInfo)localObject).jdField_e_of_type_JavaLangString);
        localMusicPanelView.a(atmr.a((MusicInfo)localObject), 2131166885);
        localObject = a();
        paramatpi = (atpi)localObject;
        if (localObject == null) {
          paramatpi = "";
        }
        localMusicPanelView.a(0, paramatpi);
      }
      else
      {
        localMusicPanelView.a("");
        localMusicPanelView.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693961), 2131166887);
        localMusicPanelView.a(8, "");
      }
    }
  }
  
  private boolean a(int paramInt, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Atpi.jdField_a_of_type_JavaLangString.equals(paramString))
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Atpi.jdField_a_of_type_Int == paramInt) {
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
      if (paramListenTogetherSession.jdField_e_of_type_JavaLangString.equals(this.jdField_a_of_type_Atpi.jdField_a_of_type_JavaLangString))
      {
        bool1 = bool2;
        if (paramListenTogetherSession.jdField_e_of_type_Int == this.jdField_a_of_type_Atpi.jdField_a_of_type_Int) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void b(atpi paramatpi)
  {
    MusicPanelView localMusicPanelView = a();
    if ((!c()) || (localMusicPanelView == null)) {
      return;
    }
    localMusicPanelView.b(0, paramatpi.jdField_d_of_type_Int);
    localMusicPanelView.a(0, atmr.a(paramatpi.jdField_a_of_type_Long) + " / " + atmr.a(paramatpi.jdField_b_of_type_Long));
  }
  
  private void b(ListenTogetherSession paramListenTogetherSession)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.i("BaseListenTogetherPanel", 2, "updateCurUiData");
    }
    MusicInfo localMusicInfo = null;
    if (this.jdField_a_of_type_Atpi.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession != null) {
      localMusicInfo = this.jdField_a_of_type_Atpi.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.a();
    }
    Object localObject = paramListenTogetherSession.a();
    if ((localMusicInfo == null) || (localObject == null) || (localMusicInfo.jdField_a_of_type_JavaLangString != ((MusicInfo)localObject).jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Atpi.jdField_d_of_type_Int = 0;
      this.jdField_a_of_type_Atpi.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_Atpi.jdField_b_of_type_Long = 0L;
      this.jdField_a_of_type_Atpi.jdField_d_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Atpi.jdField_b_of_type_Int = paramListenTogetherSession.jdField_g_of_type_Int;
    this.jdField_a_of_type_Atpi.jdField_c_of_type_Int = paramListenTogetherSession.h;
    this.jdField_a_of_type_Atpi.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession = paramListenTogetherSession;
    localObject = this.jdField_a_of_type_Atpi;
    if (!paramListenTogetherSession.jdField_a_of_type_Boolean) {
      bool = true;
    }
    ((atpi)localObject).jdField_c_of_type_Boolean = bool;
    this.jdField_a_of_type_Atpi.jdField_c_of_type_JavaLangString = paramListenTogetherSession.f;
    this.jdField_a_of_type_Atpi.jdField_d_of_type_JavaLangString = paramListenTogetherSession.jdField_g_of_type_JavaLangString;
    this.jdField_a_of_type_Atpi.jdField_a_of_type_Boolean = a();
    this.jdField_a_of_type_Atpi.jdField_b_of_type_Boolean = b();
    this.jdField_a_of_type_Atpi.jdField_e_of_type_Int = paramListenTogetherSession.jdField_c_of_type_Int;
    if (localMusicInfo != null)
    {
      if (localMusicInfo.jdField_a_of_type_Long >= 0L) {
        this.jdField_a_of_type_Atpi.jdField_a_of_type_Long = localMusicInfo.jdField_a_of_type_Long;
      }
      if ((this.jdField_a_of_type_Atpi.jdField_b_of_type_Long == 0L) && (localMusicInfo.d != 0L)) {
        this.jdField_a_of_type_Atpi.jdField_d_of_type_Boolean = true;
      }
      this.jdField_a_of_type_Atpi.jdField_b_of_type_Long = (localMusicInfo.d * 1000L);
    }
    banz.a().a(this.jdField_a_of_type_Atpi.jdField_a_of_type_Boolean);
  }
  
  private void i()
  {
    if (!bdin.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131695065), 0).a();
      return;
    }
    int i = this.jdField_a_of_type_Atpi.jdField_a_of_type_Int;
    String str = this.jdField_a_of_type_Atpi.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Atmu = new atpf(this, i, str);
    ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, i, str, this.jdField_a_of_type_Atmu);
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "destroyUI()");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null)
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aepc != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aepc.a(null);
    }
    this.jdField_a_of_type_Atpi.a();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
    a();
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "jumpWeb, isLaunchingWeb=" + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    atmr.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Atpi.jdField_a_of_type_Int, this.jdField_a_of_type_Atpi.jdField_a_of_type_JavaLangString, 1);
  }
  
  private void l()
  {
    boolean bool = atmr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
    if ((!bool) && ((this.jdField_a_of_type_AndroidWidgetPopupWindow == null) || (!this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) && (d()) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
      atmr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "showGuide, hasShow=" + bool);
    }
  }
  
  public MusicPanelView a()
  {
    if (this.jdField_a_of_type_Ahaa != null) {
      return (MusicPanelView)this.jdField_a_of_type_Ahaa.a();
    }
    return null;
  }
  
  public String a(int paramInt)
  {
    String str = this.jdField_a_of_type_Atpi.jdField_d_of_type_JavaLangString;
    if (str == null) {
      return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693939);
    }
    if (TextUtils.isEmpty(str)) {
      return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693955);
    }
    str = bapu.a(paramInt, str);
    return str + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693985);
  }
  
  public String a(boolean paramBoolean)
  {
    if (alud.a(2131693962).equals(this.jdField_a_of_type_Atpi.jdField_b_of_type_JavaLangString)) {}
    for (String str = a(16);; str = this.jdField_a_of_type_Atpi.jdField_b_of_type_JavaLangString)
    {
      if (paramBoolean) {
        str = alud.a(2131693989);
      }
      return str;
    }
  }
  
  public abstract void a();
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    case 10: 
    default: 
      return;
    case 2: 
      c();
      return;
    case 4: 
      d();
      return;
    case 8: 
      e();
      return;
    case 9: 
      f();
      return;
    }
    g();
  }
  
  public void a(int paramInt, ahan paramahan)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onOtherTipsShow tip=" + paramahan + " type=" + paramInt);
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
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, alud.a(2131701397), 1).a();
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onJoinListenTogetherFail");
    }
    if (!a(paramInt, paramString)) {
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, alud.a(2131701396), 1).a();
    this.jdField_a_of_type_Atpi.jdField_c_of_type_Int = 1;
    a(this.jdField_a_of_type_Atpi);
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
      QLog.d("BaseListenTogetherPanel", 2, "onUIModuleNeedRefresh, uidata=" + this.jdField_a_of_type_Atpi);
    }
    banz.a().a(paramListenTogetherSession.jdField_e_of_type_JavaLangString, paramListenTogetherSession.jdField_e_of_type_Int);
    if (this.jdField_a_of_type_Atpi.jdField_b_of_type_Int == 3)
    {
      String str;
      if (c())
      {
        str = this.jdField_a_of_type_Atph.jdField_a_of_type_JavaLangString;
        if (!d()) {
          break label200;
        }
      }
      label200:
      for (paramListenTogetherSession = "clk_expand";; paramListenTogetherSession = "clk_fold")
      {
        azqs.b(null, "dc00899", str, "", "music_tab", paramListenTogetherSession, 0, 0, this.jdField_a_of_type_Atph.jdField_b_of_type_JavaLangString, "", this.jdField_a_of_type_Atph.jdField_a_of_type_Int + "", "");
        azqs.b(null, "dc00898", "", "", "qq_vip", "0X800A5BD", 0, 0, "", "", "", "");
        f();
        return;
      }
    }
    banz.a().a(a());
    boolean bool = this.jdField_a_of_type_Atpi.jdField_c_of_type_Boolean;
    if (d() != bool)
    {
      if (!bool) {
        break label282;
      }
      e();
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Atpi);
      a();
      if ((!bool) || (this.jdField_d_of_type_Boolean) || (this.jdField_c_of_type_Boolean)) {
        break;
      }
      this.jdField_d_of_type_Boolean = true;
      h();
      return;
      label282:
      f();
    }
  }
  
  protected void a(String paramString, int paramInt1, int paramInt2)
  {
    if ((!c()) || (this.jdField_a_of_type_Atpi.jdField_c_of_type_Int != 2)) {}
    do
    {
      do
      {
        return;
        MusicInfo localMusicInfo = this.jdField_a_of_type_Atpi.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.a();
        if ((localMusicInfo == null) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(localMusicInfo.jdField_a_of_type_JavaLangString))) {
          break;
        }
        int i = paramInt1;
        try
        {
          if (this.jdField_a_of_type_Atpi.jdField_d_of_type_Int > 97)
          {
            i = paramInt1;
            if (paramInt1 < 0) {
              i = paramInt2;
            }
          }
          paramInt1 = (int)(i * 1.0F / paramInt2 * 100.0F);
          this.jdField_a_of_type_Atpi.jdField_a_of_type_Long = i;
          this.jdField_a_of_type_Atpi.jdField_b_of_type_Long = paramInt2;
          this.jdField_a_of_type_Atpi.jdField_d_of_type_Int = paramInt1;
          b(this.jdField_a_of_type_Atpi);
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
    return new int[] { 2, 4, 8, 9, 11 };
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
      ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(bool, this.jdField_a_of_type_Atpi.jdField_a_of_type_Int, this.jdField_a_of_type_Atpi.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      return;
      e();
    }
  }
  
  public void b(int paramInt, ahan paramahan)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onOtherTipsHide tip=" + paramahan + " type=" + paramInt);
    }
    if (!c()) {
      if (QLog.isColorLevel()) {
        QLog.d("BaseListenTogetherPanel", 2, "onOtherTipsHide mUIData is null or session is null");
      }
    }
    while ((paramInt != 1) || (this.jdField_a_of_type_Ahaa == null) || (this.jdField_a_of_type_Ahaa == paramahan)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onOtherTipsHide tip not equal TogetherTip");
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onOtherTipsHide expand=" + this.jdField_a_of_type_Atpi.jdField_c_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Atpi.jdField_c_of_type_Boolean) {
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
    l();
  }
  
  public abstract boolean b();
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onCreate()");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Atml);
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_Atpi.jdField_b_of_type_Int != 0) && (this.jdField_a_of_type_Atpi.jdField_b_of_type_Int != 3) && (this.jdField_a_of_type_Atpi.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession != null);
  }
  
  public void d()
  {
    this.jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onResume()");
    }
    this.jdField_a_of_type_Boolean = false;
    ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_Atpi.jdField_a_of_type_Int, this.jdField_a_of_type_Atpi.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.hashCode());
    ChatFragment localChatFragment = ((FragmentActivity)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a()).getChatFragment();
    banz.a().a(localChatFragment, String.valueOf(this.jdField_a_of_type_Atpi.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Atpi.jdField_a_of_type_Int);
  }
  
  public boolean d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() == null) || (this.jdField_a_of_type_Ahaa == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("BaseListenTogetherPanel", 2, "tipManager is null or together is null");
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a() != this.jdField_a_of_type_Ahaa) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "curTip is togetherTip");
    }
    return true;
  }
  
  public void e()
  {
    this.jdField_b_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onPause()");
    }
    ahap localahap = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    if (localahap != null) {
      localahap.a(1003, new Object[0]);
    }
    ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_Atpi.jdField_a_of_type_Int, this.jdField_a_of_type_Atpi.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.hashCode());
  }
  
  public boolean e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "showTogetherTip");
    }
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() == null) {
      if (QLog.isColorLevel()) {
        QLog.d("BaseListenTogetherPanel", 2, "tipManager is null");
      }
    }
    do
    {
      return false;
      ahan localahan = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a();
      if ((localahan == null) || (localahan == this.jdField_a_of_type_Ahaa)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("BaseListenTogetherPanel", 2, "currTip is other");
    return false;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a(this.jdField_a_of_type_Ahaa, new Object[0]);
    return true;
  }
  
  public void f()
  {
    this.jdField_b_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onStop()");
    }
    this.jdField_a_of_type_Boolean = false;
    String str2;
    if (c())
    {
      str2 = this.jdField_a_of_type_Atph.jdField_a_of_type_JavaLangString;
      if (!d()) {
        break label104;
      }
    }
    label104:
    for (String str1 = "clk_expand";; str1 = "clk_fold")
    {
      azqs.b(null, "dc00899", str2, "", "music_tab", str1, 0, 0, this.jdField_a_of_type_Atph.jdField_b_of_type_JavaLangString, "", this.jdField_a_of_type_Atph.jdField_a_of_type_Int + "", "");
      return;
    }
  }
  
  public boolean f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "dismissTogetherTip");
    }
    if ((this.jdField_a_of_type_Ahaa == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("BaseListenTogetherPanel", 2, "tipManager is null or together is null");
      }
    }
    ahan localahan;
    do
    {
      return false;
      localahan = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a();
    } while ((localahan == null) || (localahan != this.jdField_a_of_type_Ahaa));
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "currTip is togetherTip");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a();
    return true;
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onDestroy()");
    }
    banz.a().c();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Atml);
    ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).d(this.jdField_a_of_type_Atpi.jdField_a_of_type_Int, this.jdField_a_of_type_Atpi.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.hashCode());
    j();
  }
  
  protected void h() {}
  
  public void onClick(View paramView)
  {
    int i = 1;
    int j = paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.i("BaseListenTogetherPanel", 2, "onClick, id = " + j);
    }
    switch (j)
    {
    default: 
    case 2131377009: 
      do
      {
        return;
      } while ((this.jdField_a_of_type_Atpi.jdField_c_of_type_Int != 2) || (!b()));
      if (!bdin.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131695065), 0).a();
        return;
      }
      j = this.jdField_a_of_type_Atpi.jdField_b_of_type_Int;
      if (j == 1)
      {
        ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_Atpi.jdField_a_of_type_Int, this.jdField_a_of_type_Atpi.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Atpi.jdField_b_of_type_Int = 2;
        azqs.b(null, "dc00899", this.jdField_a_of_type_Atph.jdField_a_of_type_JavaLangString, "", "music_tab", "clk_pause", 0, 0, this.jdField_a_of_type_Atph.jdField_b_of_type_JavaLangString, "", this.jdField_a_of_type_Atph.jdField_a_of_type_Int + "", "");
      }
      break;
    }
    while (i != 0)
    {
      a(this.jdField_a_of_type_Atpi);
      return;
      if (j == 2)
      {
        ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_Atpi.jdField_a_of_type_Int, this.jdField_a_of_type_Atpi.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Atpi.jdField_b_of_type_Int = 1;
        continue;
        if (!bdin.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131695065), 0).a();
          return;
        }
        this.jdField_a_of_type_Atmt = new atpe(this);
        ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_Atpi.jdField_a_of_type_Int, this.jdField_a_of_type_Atpi.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Atmt);
        return;
        if (this.jdField_a_of_type_Atpi.jdField_c_of_type_Int == 2)
        {
          paramView = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a(this.jdField_a_of_type_Atpi.jdField_a_of_type_Int, this.jdField_a_of_type_Atpi.jdField_a_of_type_JavaLangString);
          if ((this.jdField_a_of_type_Atpi.jdField_b_of_type_Int == 1) || (this.jdField_a_of_type_Atpi.jdField_b_of_type_Int == 2)) {}
          for (i = 1;; i = 0)
          {
            if ((paramView != null) && (i != 0))
            {
              MusicInfo localMusicInfo = paramView.a();
              ListenTogetherPlayFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView, localMusicInfo, this.jdField_a_of_type_Atpi.jdField_a_of_type_Boolean, null);
            }
            azqs.b(null, "dc00899", this.jdField_a_of_type_Atph.jdField_a_of_type_JavaLangString, "", "music_tab", "clk_detail", 0, 0, this.jdField_a_of_type_Atph.jdField_b_of_type_JavaLangString, "", this.jdField_a_of_type_Atph.jdField_a_of_type_Int + "", "");
            return;
          }
        }
        if ((this.jdField_a_of_type_Atpi.jdField_c_of_type_Int != 1) && (this.jdField_a_of_type_Atpi.jdField_c_of_type_Int != 3)) {
          break;
        }
        i();
        return;
        i();
        return;
        k();
        azqs.b(null, "dc00899", this.jdField_a_of_type_Atph.jdField_a_of_type_JavaLangString, "", "music_tab", "clk_list", 0, 0, this.jdField_a_of_type_Atph.jdField_b_of_type_JavaLangString, "", this.jdField_a_of_type_Atph.jdField_a_of_type_Int + "", "");
        return;
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atpc
 * JD-Core Version:    0.7.0.1
 */