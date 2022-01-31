import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.screendetect.ScreenShotDetector;
import com.tencent.mobileqq.troop.quickat.ui.AIOAtSearchManager;
import com.tencent.mobileqq.troop.quickat.ui.AtPanel.3;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

public class baem
  implements PopupWindow.OnDismissListener, awgl, baeh, baep
{
  private akil jdField_a_of_type_Akil;
  private View jdField_a_of_type_AndroidViewView;
  baeg jdField_a_of_type_Baeg;
  private baex jdField_a_of_type_Baex;
  private baey jdField_a_of_type_Baey;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private final TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AIOAtSearchManager jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  
  public baem(TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie = paramTroopChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramTroopChatPie.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_Baeg = new baeg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager = new AIOAtSearchManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.a(this);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Akil == null) {
      this.jdField_a_of_type_Akil = new baen(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akil);
    if (QLog.isColorLevel()) {
      QLog.d("AtPanel", 2, " addObservers =" + this.jdField_a_of_type_Akil);
    }
  }
  
  private void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131368186);
    View localView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131362263);
    this.jdField_a_of_type_Baey = baey.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, -1, -1);
    this.jdField_a_of_type_Baey.setTouchInterceptor(new baeo(this, localView, (View)localObject));
    this.jdField_a_of_type_Baey.setOnDismissListener(this);
    localObject = (XListView)this.jdField_a_of_type_Baey.getContentView().findViewById(2131377855);
    this.jdField_a_of_type_Baex = new baex(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.context, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie, this.jdField_a_of_type_Baey.getContentView(), (XListView)localObject);
    this.jdField_a_of_type_Baex.jdField_a_of_type_Bafa.a(this);
    this.jdField_a_of_type_Baey.a(this.jdField_a_of_type_Baex.jdField_a_of_type_Bafa.a());
    d();
    ((akhp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).q(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AtPanel", 2, "initMultiSelectMode: invoked. ");
    }
    this.jdField_a_of_type_Baex.jdField_a_of_type_Bafa.a().jdField_a_of_type_Boolean = false;
    TextView localTextView = (TextView)this.jdField_a_of_type_Baey.getContentView().findViewById(2131362836);
    if (localTextView != null) {
      localTextView.setText(2131694468);
    }
  }
  
  public void a()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      a();
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new AtPanel.3(this));
  }
  
  public void a(View paramView, String paramString, boolean paramBoolean)
  {
    ajey.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "aio_at", true);
    if (this.jdField_a_of_type_Baey == null) {
      e();
    }
    this.b = true;
    this.c = false;
    this.jdField_a_of_type_AndroidViewView = paramView;
    if ((TextUtils.isEmpty(paramString)) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      f();
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    paramView = this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.a();
    boolean bool;
    if ((TextUtils.isEmpty(paramString)) || (paramView.isEmpty()))
    {
      c();
      if ((!paramView.isEmpty()) && (this.jdField_a_of_type_Baeg.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!this.d))
      {
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.d("AtPanel", 2, new Object[] { "showDialogAtView: invoked. ", " noNeedToFetch: ", Boolean.valueOf(bool) });
        }
        if (!bool) {
          break label231;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.a(paramString, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.F());
      }
    }
    for (;;)
    {
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A48E", "0X800A48E", 0, 0, "", "", "", "");
      return;
      bool = false;
      break;
      label231:
      this.jdField_a_of_type_Baey.a(0, 2131689876);
      this.jdField_a_of_type_Baeg.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.d = false;
      continue;
      this.jdField_a_of_type_Baey.a(8, 2131689876);
      this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.a(paramString, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.F());
    }
  }
  
  public void a(baff parambaff)
  {
    if (!this.b) {
      if (QLog.isColorLevel()) {
        QLog.d("AtPanel", 2, "refreshUI =" + this.b);
      }
    }
    do
    {
      do
      {
        return;
        if ((parambaff.a == null) || (parambaff.a.isEmpty()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AtPanel", 2, "resultList = null");
          }
          a();
          return;
        }
        this.jdField_a_of_type_Baey.a(8, 2131689876);
        c();
        if (this.jdField_a_of_type_Baex != null) {
          this.jdField_a_of_type_Baex.jdField_a_of_type_Bafa.a(parambaff);
        }
        if (!this.c) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AtPanel", 2, "From Multi");
      return;
    } while (this.jdField_a_of_type_Baex == null);
    this.jdField_a_of_type_Baex.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Baex.jdField_a_of_type_ComTencentWidgetXListView.getAdapter());
    this.jdField_a_of_type_Baex.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_Baex != null) && (this.jdField_a_of_type_Baey != null) && (this.jdField_a_of_type_Baey.isShowing())) {
      this.jdField_a_of_type_Baex.jdField_a_of_type_Bafa.a(paramString);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.c = true;
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.a(paramString, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.F());
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Baey != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Baey.isShowing())
      {
        this.jdField_a_of_type_Baey.dismiss();
        bool1 = true;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.a();
    return bool1;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Akil != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akil);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AtPanel", 2, " removeObserver =" + this.jdField_a_of_type_Akil);
    }
    a();
    this.jdField_a_of_type_Baey = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.a(null);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.b();
    if ((this.jdField_a_of_type_Baex != null) && (this.jdField_a_of_type_Baex.jdField_a_of_type_Bafa != null)) {
      this.jdField_a_of_type_Baex.jdField_a_of_type_Bafa.c();
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Baex != null) {
      return this.jdField_a_of_type_Baex.jdField_a_of_type_Bafa.jdField_a_of_type_Boolean;
    }
    return false;
  }
  
  public void c()
  {
    ScreenShotDetector.getInstance().a(this);
    bafg.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_Baey.a();
    this.jdField_a_of_type_Baey.showAtLocation(this.jdField_a_of_type_AndroidViewView, 48, 0, 0);
    this.jdField_a_of_type_Baey.a(bafg.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity), bafg.a, -1);
    this.jdField_a_of_type_Baex.jdField_a_of_type_Bafa.a();
  }
  
  public void onDismiss()
  {
    this.c = false;
    this.b = false;
    this.jdField_a_of_type_JavaLangString = null;
    ScreenShotDetector.getInstance().a(null);
    ajey.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "aio_at", false);
    if (this.jdField_a_of_type_Baex != null) {
      this.jdField_a_of_type_Baex.jdField_a_of_type_Bafa.b();
    }
    int i = bafg.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("input_method");
    View localView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131368186);
    if ((i == 2) && (localInputMethodManager != null) && (localView != null)) {
      localInputMethodManager.showSoftInput(localView, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baem
 * JD-Core Version:    0.7.0.1
 */