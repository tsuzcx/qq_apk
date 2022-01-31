import android.annotation.TargetApi;
import android.content.res.Resources;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.fragment.ListenTogetherPlayFragment;
import com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel.6;
import com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel.7;
import com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel.8;
import com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel.9;
import com.tencent.mobileqq.listentogether.ui.MusicPanelView;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class aqyg
  implements acxg, View.OnClickListener
{
  int jdField_a_of_type_Int = -1;
  long jdField_a_of_type_Long = 0L;
  public ViewGroup a;
  public FrameLayout a;
  public PopupWindow a;
  aqvp jdField_a_of_type_Aqvp = new aqyh(this);
  aqvx jdField_a_of_type_Aqvx;
  aqvy jdField_a_of_type_Aqvy;
  aqyn jdField_a_of_type_Aqyn;
  aqyo jdField_a_of_type_Aqyo = new aqyo();
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  public BaseActivity a;
  MusicPanelView jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView;
  public QQBlurView a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new BaseListenTogetherPanel.6(this);
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  boolean jdField_a_of_type_Boolean = false;
  private Runnable jdField_b_of_type_JavaLangRunnable = new BaseListenTogetherPanel.9(this);
  AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  boolean jdField_b_of_type_Boolean = false;
  boolean c;
  boolean d;
  
  public aqyg(BaseChatPie paramBaseChatPie)
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "oncreate");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseChatPie.a();
    this.jdField_a_of_type_AndroidViewViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c;
    axlm.a().a(a());
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onListenTogetherJoinedCountChange");
    }
    if (!a(paramInt, paramString1)) {
      return;
    }
    this.jdField_a_of_type_Aqyo.jdField_b_of_type_JavaLangString = paramString2;
    a();
    a(this.jdField_a_of_type_Aqyo);
  }
  
  public static void a(View paramView)
  {
    ((View)paramView.getParent()).post(new BaseListenTogetherPanel.8(paramView));
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ((View)paramView.getParent()).post(new BaseListenTogetherPanel.7(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  private void a(aqyo paramaqyo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "freshUI, mUiState=" + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Int == -1) {}
    Object localObject;
    int i;
    label215:
    label243:
    do
    {
      do
      {
        return;
        localObject = paramaqyo.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession;
      } while (localObject == null);
      i = paramaqyo.jdField_b_of_type_Int;
      localObject = ((ListenTogetherSession)localObject).a();
      if (paramaqyo.jdField_c_of_type_Int == 2)
      {
        if (i == 4)
        {
          this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.a(8, i);
          this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.c(0);
          this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.a(0);
          this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.a("");
          this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.b(8);
          this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131628201), 2131101244);
          this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.a(8, "");
          this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.b(0, 0);
          this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.b();
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.d(8);
          if (i == 4) {
            this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.a(8, i);
          }
          this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.postInvalidate();
          return;
          if (paramaqyo.jdField_b_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.a(0, i);
            if (localObject == null) {
              break label388;
            }
            this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.a(((MusicInfo)localObject).jdField_e_of_type_JavaLangString);
            this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.a(aqvv.a((MusicInfo)localObject), 2131101242);
            this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.a(0);
            this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.c(0);
            this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.e(0);
            if (i != 2) {
              break label432;
            }
            this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.b(0);
          }
          for (;;)
          {
            if (this.jdField_a_of_type_Aqyo.jdField_d_of_type_Boolean)
            {
              this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.b(0, paramaqyo.jdField_d_of_type_Int);
              this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.a(0, aqvv.a(paramaqyo.jdField_a_of_type_Long) + " / " + aqvv.a(paramaqyo.jdField_b_of_type_Long));
              this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.b();
              this.jdField_a_of_type_Aqyo.jdField_d_of_type_Boolean = false;
            }
            if (i != 1) {
              break label444;
            }
            this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.a();
            break;
            this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.a(8, i);
            break label215;
            this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.a("");
            this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131628201), 2131101244);
            this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.a(8, "");
            break label243;
            this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.b(8);
          }
          if (i == 2) {
            this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.c();
          }
        }
      }
    } while ((paramaqyo.jdField_c_of_type_Int != 1) && (paramaqyo.jdField_c_of_type_Int != 3));
    label388:
    label432:
    label444:
    this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.b(8);
    this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.c(8);
    this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.a(8, i);
    this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.d(0);
    this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.a(8);
    this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.b(0, 0);
    this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.b();
    if (i == 4)
    {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.a("");
      this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131628201), 2131101244);
      this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.a(8, "");
    }
    for (;;)
    {
      if (i == 4) {
        this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.a(8, i);
      }
      this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.postInvalidate();
      return;
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.a(((MusicInfo)localObject).jdField_e_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.a(aqvv.a((MusicInfo)localObject), 2131101242);
        localObject = this.jdField_a_of_type_Aqyo.jdField_b_of_type_JavaLangString;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramaqyo = (aqyo)localObject;
          if (!ajjy.a(2131628202).equalsIgnoreCase((String)localObject)) {}
        }
        else
        {
          paramaqyo = a(0);
        }
        this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.a(0, paramaqyo);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.a("");
        this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131628201), 2131101244);
        this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.a(8, "");
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "setPanelVisible, visible=" + paramBoolean);
    }
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout;
      if (paramBoolean)
      {
        i = 0;
        ((FrameLayout)localObject).setVisibility(i);
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
      if ((!paramBoolean) || (axlm.a().c())) {
        break label100;
      }
    }
    label100:
    for (int i = j;; i = 8)
    {
      ((QQBlurView)localObject).setVisibility(i);
      return;
      i = 8;
      break;
    }
  }
  
  private boolean a(int paramInt, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Aqyo.jdField_a_of_type_JavaLangString.equals(paramString))
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Aqyo.jdField_a_of_type_Int == paramInt) {
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
      if (paramListenTogetherSession.jdField_e_of_type_JavaLangString.equals(this.jdField_a_of_type_Aqyo.jdField_a_of_type_JavaLangString))
      {
        bool1 = bool2;
        if (paramListenTogetherSession.jdField_e_of_type_Int == this.jdField_a_of_type_Aqyo.jdField_a_of_type_Int) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void b(aqyo paramaqyo)
  {
    if (this.jdField_a_of_type_Int == -1) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.b(0, paramaqyo.jdField_d_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.a(0, aqvv.a(paramaqyo.jdField_a_of_type_Long) + " / " + aqvv.a(paramaqyo.jdField_b_of_type_Long));
  }
  
  private void b(ListenTogetherSession paramListenTogetherSession)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.i("BaseListenTogetherPanel", 2, "updateCurUiData");
    }
    MusicInfo localMusicInfo = null;
    if (this.jdField_a_of_type_Aqyo.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession != null) {
      localMusicInfo = this.jdField_a_of_type_Aqyo.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.a();
    }
    Object localObject = paramListenTogetherSession.a();
    if ((localMusicInfo == null) || (localObject == null) || (localMusicInfo.jdField_a_of_type_JavaLangString != ((MusicInfo)localObject).jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Aqyo.jdField_d_of_type_Int = 0;
      this.jdField_a_of_type_Aqyo.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_Aqyo.jdField_b_of_type_Long = 0L;
      this.jdField_a_of_type_Aqyo.jdField_d_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Aqyo.jdField_b_of_type_Int = paramListenTogetherSession.jdField_g_of_type_Int;
    this.jdField_a_of_type_Aqyo.jdField_c_of_type_Int = paramListenTogetherSession.h;
    this.jdField_a_of_type_Aqyo.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession = paramListenTogetherSession;
    localObject = this.jdField_a_of_type_Aqyo;
    if (!paramListenTogetherSession.jdField_a_of_type_Boolean) {
      bool = true;
    }
    ((aqyo)localObject).jdField_c_of_type_Boolean = bool;
    this.jdField_a_of_type_Aqyo.jdField_c_of_type_JavaLangString = paramListenTogetherSession.f;
    this.jdField_a_of_type_Aqyo.jdField_d_of_type_JavaLangString = paramListenTogetherSession.jdField_g_of_type_JavaLangString;
    this.jdField_a_of_type_Aqyo.jdField_a_of_type_Boolean = a();
    this.jdField_a_of_type_Aqyo.jdField_b_of_type_Boolean = b();
    this.jdField_a_of_type_Aqyo.jdField_e_of_type_Int = paramListenTogetherSession.jdField_c_of_type_Int;
    if (localMusicInfo != null)
    {
      if (localMusicInfo.jdField_a_of_type_Long >= 0L) {
        this.jdField_a_of_type_Aqyo.jdField_a_of_type_Long = localMusicInfo.jdField_a_of_type_Long;
      }
      if ((this.jdField_a_of_type_Aqyo.jdField_b_of_type_Long == 0L) && (localMusicInfo.d != 0L)) {
        this.jdField_a_of_type_Aqyo.jdField_d_of_type_Boolean = true;
      }
      this.jdField_a_of_type_Aqyo.jdField_b_of_type_Long = (localMusicInfo.d * 1000L);
    }
    axlm.a().a(this.jdField_a_of_type_Aqyo.jdField_a_of_type_Boolean);
  }
  
  private boolean e()
  {
    boolean bool3 = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Acis != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Acis.a())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.w()) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BaseListenTogetherPanel", 2, "hasTipsShow, hasTipsShow=" + bool1 + ",hasMsgBoxShow=" + bool2);
        }
        if (!bool1)
        {
          bool1 = bool3;
          if (!bool2) {}
        }
        else
        {
          bool1 = true;
        }
        return bool1;
      }
    }
  }
  
  private boolean f()
  {
    boolean bool2 = false;
    aeob localaeob = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    int i = -1;
    boolean bool1 = bool2;
    if (localaeob != null)
    {
      int j = localaeob.a();
      i = j;
      bool1 = bool2;
      if (j == 19)
      {
        bool1 = true;
        i = j;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "isSpecTipsShowing, isShowing" + bool1 + ",curTipType=" + i);
    }
    return bool1;
  }
  
  @TargetApi(19)
  private void l()
  {
    if ((this.jdField_a_of_type_AndroidWidgetFrameLayout == null) || (this.jdField_a_of_type_AndroidViewViewGroup == null)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131297761));
    } while (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView == null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(4);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
  }
  
  private void m()
  {
    if (!badq.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131629228), 0).a();
      return;
    }
    int i = this.jdField_a_of_type_Aqyo.jdField_a_of_type_Int;
    String str = this.jdField_a_of_type_Aqyo.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Aqvy = new aqyj(this, i, str);
    ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, i, str, this.jdField_a_of_type_Aqvy);
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "destroyUI()");
    }
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
    a(false);
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null)
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Acis != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Acis.a(null);
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = null;
    }
    this.jdField_a_of_type_Aqyo.a();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Boolean = false;
    b(-1);
  }
  
  private void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "jumpWeb, isLaunchingWeb=" + this.jdField_b_of_type_Boolean);
    }
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    aqvv.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Aqyo.jdField_a_of_type_Int, this.jdField_a_of_type_Aqyo.jdField_a_of_type_JavaLangString, 1);
  }
  
  private void p()
  {
    boolean bool = aqvv.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
    if ((!bool) && ((this.jdField_a_of_type_AndroidWidgetPopupWindow == null) || (!this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) && (this.jdField_a_of_type_AndroidWidgetFrameLayout != null))
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 500L);
      aqvv.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "showGuide, hasShow=" + bool);
    }
  }
  
  private void q()
  {
    aeob localaeob = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    int i = -1;
    if (localaeob != null)
    {
      int j = localaeob.a();
      i = j;
      if (j == 19)
      {
        localaeob.a();
        i = j;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "hideSpecTips, curTipType" + i);
    }
  }
  
  public abstract MusicPanelView a();
  
  public String a(int paramInt)
  {
    String str = this.jdField_a_of_type_Aqyo.jdField_d_of_type_JavaLangString;
    if (str == null) {
      return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131628179);
    }
    if (TextUtils.isEmpty(str)) {
      return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131628195);
    }
    str = axng.a(paramInt, str);
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131628225, new Object[] { str });
  }
  
  public String a(boolean paramBoolean)
  {
    if (ajjy.a(2131628202).equals(this.jdField_a_of_type_Aqyo.jdField_b_of_type_JavaLangString)) {}
    for (String str = a(16);; str = this.jdField_a_of_type_Aqyo.jdField_b_of_type_JavaLangString)
    {
      if (paramBoolean) {
        str = ajjy.a(2131628229);
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
      f();
      return;
    case 4: 
      g();
      return;
    case 8: 
      h();
      return;
    case 9: 
      i();
      return;
    }
    j();
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onExitListenTogetherFail");
    }
    if (!a(paramInt, paramString)) {
      return;
    }
    bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ajjy.a(2131635221), 1).a();
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onJoinListenTogetherFail");
    }
    if (!a(paramInt, paramString)) {
      return;
    }
    bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ajjy.a(2131635220), 1).a();
    this.jdField_a_of_type_Aqyo.jdField_c_of_type_Int = 1;
    a(this.jdField_a_of_type_Aqyo);
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
      QLog.d("BaseListenTogetherPanel", 2, "onUIModuleNeedRefresh, uidata=" + this.jdField_a_of_type_Aqyo);
    }
    axlm.a().a(paramListenTogetherSession.jdField_e_of_type_JavaLangString, paramListenTogetherSession.jdField_e_of_type_Int);
    if (this.jdField_a_of_type_Aqyo.jdField_b_of_type_Int == 3)
    {
      String str;
      if (this.jdField_a_of_type_Int != -1)
      {
        str = this.jdField_a_of_type_Aqyn.jdField_a_of_type_JavaLangString;
        if (!d()) {
          break label200;
        }
      }
      label200:
      for (paramListenTogetherSession = "clk_expand";; paramListenTogetherSession = "clk_fold")
      {
        awqx.b(null, "dc00899", str, "", "music_tab", paramListenTogetherSession, 0, 0, this.jdField_a_of_type_Aqyn.jdField_b_of_type_JavaLangString, "", this.jdField_a_of_type_Aqyn.jdField_a_of_type_Int + "", "");
        awqx.b(null, "dc00898", "", "", "qq_vip", "0X800A5BD", 0, 0, "", "", "", "");
        n();
        return;
      }
    }
    axlm.a().a(a());
    b();
    a(this.jdField_a_of_type_Aqyo);
  }
  
  protected void a(String paramString, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Int == -1) || (this.jdField_a_of_type_Aqyo.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession == null) || (this.jdField_a_of_type_Aqyo.jdField_c_of_type_Int != 2)) {}
    do
    {
      do
      {
        return;
        MusicInfo localMusicInfo = this.jdField_a_of_type_Aqyo.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.a();
        if ((localMusicInfo == null) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(localMusicInfo.jdField_a_of_type_JavaLangString))) {
          break;
        }
        int i = paramInt1;
        try
        {
          if (this.jdField_a_of_type_Aqyo.jdField_d_of_type_Int > 97)
          {
            i = paramInt1;
            if (paramInt1 < 0) {
              i = paramInt2;
            }
          }
          paramInt1 = (int)(i * 1.0F / paramInt2 * 100.0F);
          this.jdField_a_of_type_Aqyo.jdField_a_of_type_Long = i;
          this.jdField_a_of_type_Aqyo.jdField_b_of_type_Long = paramInt2;
          this.jdField_a_of_type_Aqyo.jdField_d_of_type_Int = paramInt1;
          b(this.jdField_a_of_type_Aqyo);
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
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "ensureInit, mUiState=" + this.jdField_a_of_type_Int);
    }
    boolean bool;
    if (this.jdField_a_of_type_Int == -1)
    {
      Object localObject = (ViewStub)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131304904);
      if ((this.jdField_a_of_type_AndroidWidgetFrameLayout != null) || (localObject == null) || (((ViewStub)localObject).getParent() == null)) {
        break label317;
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)((ViewStub)localObject).inflate());
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)
      {
        l();
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimension(2131167766));
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131303646);
        if (localObject != null) {
          this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView((View)localObject);
        }
        localObject = new FrameLayout.LayoutParams(-1, -1);
        this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView = a();
        this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.a = this;
        this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.setId(2131303646);
        this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.setOnClickListener(this);
        this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.setOnTouchListener(mjg.a);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView);
        if (f()) {
          q();
        }
        bool = e();
        if (this.jdField_a_of_type_Aqyo.jdField_c_of_type_Int != 2) {
          break label337;
        }
        i = 1;
        label267:
        if ((i != 0) && ((i == 0) || (!this.jdField_a_of_type_Aqyo.jdField_c_of_type_Boolean))) {
          break label350;
        }
      }
    }
    label317:
    label337:
    label350:
    for (int i = 1;; i = 0)
    {
      if ((bool) || (i == 0)) {
        a(false);
      }
      for (;;)
      {
        b(1);
        if (!this.jdField_d_of_type_Boolean) {
          k();
        }
        return;
        this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131307166));
        break;
        i = 0;
        break label267;
        a(true);
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "updateViewStatus, oldstate=" + this.jdField_a_of_type_Int + ",newState=" + paramInt);
    }
    this.jdField_a_of_type_Int = paramInt;
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
    p();
  }
  
  public abstract boolean b();
  
  public void c()
  {
    if ((this.jdField_a_of_type_Int == -1) || (Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_Long) < 500L)) {
      return;
    }
    boolean bool = d();
    if (bool) {
      e();
    }
    for (;;)
    {
      ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(bool, this.jdField_a_of_type_Aqyo.jdField_a_of_type_Int, this.jdField_a_of_type_Aqyo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      return;
      d();
    }
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Int == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseListenTogetherPanel", 2, "onTipsShow, mUiState is empty");
      }
      return;
    }
    if (f())
    {
      q();
      return;
    }
    if (paramInt == 1) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
    for (;;)
    {
      boolean bool = d();
      if ((bool) && ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))) {
        e();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("BaseListenTogetherPanel", 2, "onTipsShow, isPanelShow=" + bool + ", type=" + paramInt + ", onTipsShow=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", onMsgBoxShow=" + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      return;
      if (paramInt == 2) {
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      }
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Int != -1;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseListenTogetherPanel", 2, "showPanelView, isDodingAnimation=" + this.jdField_a_of_type_Boolean + ",mUiState=" + this.jdField_a_of_type_Int);
    }
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int == -1) || (this.jdField_a_of_type_AndroidWidgetFrameLayout == null) || (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("BaseListenTogetherPanel", 2, "showPanelView fail");
      }
      a();
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout.getAnimation();
    if (localObject != null)
    {
      ((Animation)localObject).setAnimationListener(null);
      ((Animation)localObject).cancel();
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.clearAnimation();
    localObject = new TranslateAnimation(0.0F, 0.0F, -this.jdField_a_of_type_AndroidWidgetFrameLayout.getHeight(), 0.0F);
    ((TranslateAnimation)localObject).setDuration(300L);
    ((TranslateAnimation)localObject).setFillAfter(true);
    ((TranslateAnimation)localObject).setAnimationListener(new aqyk(this));
    this.jdField_a_of_type_Boolean = true;
    a(true);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.startAnimation((Animation)localObject);
  }
  
  public void d(int paramInt)
  {
    if (this.jdField_a_of_type_Int == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseListenTogetherPanel", 2, "onTipsHide, mUiState is empty");
      }
      return;
    }
    if (paramInt == 1) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
    for (;;)
    {
      boolean bool = d();
      if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (!bool)) {
        d();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("BaseListenTogetherPanel", 2, "onTipsHide, isPanelShow=" + bool + ", type=" + paramInt + ", onTipsShow=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", onMsgBoxShow=" + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      return;
      if (paramInt == 2) {
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      }
    }
  }
  
  public boolean d()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Int != -1)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseListenTogetherPanel", 2, "hidePanelView, isDodingAnimation=" + this.jdField_a_of_type_Boolean + ",mUiState=" + this.jdField_a_of_type_Int);
    }
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int == -1) || (this.jdField_a_of_type_AndroidWidgetFrameLayout == null) || (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("BaseListenTogetherPanel", 2, "hidePanelView fail");
      }
      a();
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout.getAnimation();
    if (localObject != null)
    {
      ((Animation)localObject).setAnimationListener(null);
      ((Animation)localObject).cancel();
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.clearAnimation();
    localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.jdField_a_of_type_AndroidWidgetFrameLayout.getHeight());
    ((TranslateAnimation)localObject).setDuration(300L);
    ((TranslateAnimation)localObject).setFillAfter(true);
    ((TranslateAnimation)localObject).setAnimationListener(new aqyl(this));
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.startAnimation((Animation)localObject);
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onCreate()");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aqvp);
  }
  
  public void g()
  {
    this.jdField_c_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onResume()");
    }
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null)
    {
      ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      ThreadManager.getUIHandlerV2().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 400L);
    }
    ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_Aqyo.jdField_a_of_type_Int, this.jdField_a_of_type_Aqyo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.hashCode());
    ChatFragment localChatFragment = ((FragmentActivity)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a()).getChatFragment();
    axlm.a().a(localChatFragment, String.valueOf(this.jdField_a_of_type_Aqyo.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Aqyo.jdField_a_of_type_Int);
  }
  
  public void h()
  {
    this.jdField_c_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onPause()");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null)
    {
      ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b();
    }
    ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_Aqyo.jdField_a_of_type_Int, this.jdField_a_of_type_Aqyo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.hashCode());
  }
  
  public void i()
  {
    this.jdField_c_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onStop()");
    }
    this.jdField_b_of_type_Boolean = false;
    String str2;
    if (this.jdField_a_of_type_Int != -1)
    {
      str2 = this.jdField_a_of_type_Aqyn.jdField_a_of_type_JavaLangString;
      if (!d()) {
        break label105;
      }
    }
    label105:
    for (String str1 = "clk_expand";; str1 = "clk_fold")
    {
      awqx.b(null, "dc00899", str2, "", "music_tab", str1, 0, 0, this.jdField_a_of_type_Aqyn.jdField_b_of_type_JavaLangString, "", this.jdField_a_of_type_Aqyn.jdField_a_of_type_Int + "", "");
      return;
    }
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseListenTogetherPanel", 2, "onDestroy()");
    }
    axlm.a().c();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aqvp);
    ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).d(this.jdField_a_of_type_Aqyo.jdField_a_of_type_Int, this.jdField_a_of_type_Aqyo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.hashCode());
    n();
    if ((this.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView != null)) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView);
    }
  }
  
  protected void k() {}
  
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
    case 2131310660: 
      do
      {
        return;
      } while ((this.jdField_a_of_type_Aqyo.jdField_c_of_type_Int != 2) || (!b()));
      if (!badq.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
      {
        bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131629228), 0).a();
        return;
      }
      j = this.jdField_a_of_type_Aqyo.jdField_b_of_type_Int;
      if (j == 1)
      {
        ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_Aqyo.jdField_a_of_type_Int, this.jdField_a_of_type_Aqyo.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Aqyo.jdField_b_of_type_Int = 2;
        awqx.b(null, "dc00899", this.jdField_a_of_type_Aqyn.jdField_a_of_type_JavaLangString, "", "music_tab", "clk_pause", 0, 0, this.jdField_a_of_type_Aqyn.jdField_b_of_type_JavaLangString, "", this.jdField_a_of_type_Aqyn.jdField_a_of_type_Int + "", "");
      }
      break;
    }
    while (i != 0)
    {
      a(this.jdField_a_of_type_Aqyo);
      return;
      if (j == 2)
      {
        ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_Aqyo.jdField_a_of_type_Int, this.jdField_a_of_type_Aqyo.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Aqyo.jdField_b_of_type_Int = 1;
        continue;
        if (!badq.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
        {
          bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131629228), 0).a();
          return;
        }
        this.jdField_a_of_type_Aqvx = new aqyi(this);
        ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_Aqyo.jdField_a_of_type_Int, this.jdField_a_of_type_Aqyo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aqvx);
        return;
        if (this.jdField_a_of_type_Aqyo.jdField_c_of_type_Int == 2)
        {
          paramView = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a(this.jdField_a_of_type_Aqyo.jdField_a_of_type_Int, this.jdField_a_of_type_Aqyo.jdField_a_of_type_JavaLangString);
          if ((this.jdField_a_of_type_Aqyo.jdField_b_of_type_Int == 1) || (this.jdField_a_of_type_Aqyo.jdField_b_of_type_Int == 2)) {}
          for (i = 1;; i = 0)
          {
            if ((paramView != null) && (i != 0))
            {
              MusicInfo localMusicInfo = paramView.a();
              ListenTogetherPlayFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView, localMusicInfo, this.jdField_a_of_type_Aqyo.jdField_a_of_type_Boolean, null);
            }
            awqx.b(null, "dc00899", this.jdField_a_of_type_Aqyn.jdField_a_of_type_JavaLangString, "", "music_tab", "clk_detail", 0, 0, this.jdField_a_of_type_Aqyn.jdField_b_of_type_JavaLangString, "", this.jdField_a_of_type_Aqyn.jdField_a_of_type_Int + "", "");
            return;
          }
        }
        if ((this.jdField_a_of_type_Aqyo.jdField_c_of_type_Int != 1) && (this.jdField_a_of_type_Aqyo.jdField_c_of_type_Int != 3)) {
          break;
        }
        m();
        return;
        m();
        return;
        o();
        awqx.b(null, "dc00899", this.jdField_a_of_type_Aqyn.jdField_a_of_type_JavaLangString, "", "music_tab", "clk_list", 0, 0, this.jdField_a_of_type_Aqyn.jdField_b_of_type_JavaLangString, "", this.jdField_a_of_type_Aqyn.jdField_a_of_type_Int + "", "");
        return;
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aqyg
 * JD-Core Version:    0.7.0.1
 */