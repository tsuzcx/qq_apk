import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.screendetect.ScreenShotDetector;
import com.tencent.mobileqq.troop.quickat.ui.AIOAtSearchManager;
import com.tencent.mobileqq.troop.quickat.ui.AtPanel.3;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

public class azdd
  implements PopupWindow.OnDismissListener, avgq, azcy, azdg
{
  private final aejb jdField_a_of_type_Aejb;
  private ajuc jdField_a_of_type_Ajuc;
  private View jdField_a_of_type_AndroidViewView;
  azcx jdField_a_of_type_Azcx;
  private azdo jdField_a_of_type_Azdo;
  private azdp jdField_a_of_type_Azdp;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AIOAtSearchManager jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  
  public azdd(aejb paramaejb)
  {
    this.jdField_a_of_type_Aejb = paramaejb;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramaejb.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramaejb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramaejb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_Azcx = new azcx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager = new AIOAtSearchManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.a(this);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Ajuc == null) {
      this.jdField_a_of_type_Ajuc = new azde(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajuc);
    if (QLog.isColorLevel()) {
      QLog.d("AtPanel", 2, " addObservers =" + this.jdField_a_of_type_Ajuc);
    }
  }
  
  private void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131302566);
    View localView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131296723);
    this.jdField_a_of_type_Azdp = azdp.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, -1, -1);
    this.jdField_a_of_type_Azdp.setTouchInterceptor(new azdf(this, localView, (View)localObject));
    this.jdField_a_of_type_Azdp.setOnDismissListener(this);
    localObject = (XListView)this.jdField_a_of_type_Azdp.getContentView().findViewById(2131312027);
    this.jdField_a_of_type_Azdo = new azdo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.context, this.jdField_a_of_type_Aejb, this.jdField_a_of_type_Azdp.getContentView(), (XListView)localObject);
    this.jdField_a_of_type_Azdo.jdField_a_of_type_Azdr.a(this);
    this.jdField_a_of_type_Azdp.a(this.jdField_a_of_type_Azdo.jdField_a_of_type_Azdr.a());
    d();
    ((ajtg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).q(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AtPanel", 2, "initMultiSelectMode: invoked. ");
    }
    this.jdField_a_of_type_Azdo.jdField_a_of_type_Azdr.a().jdField_a_of_type_Boolean = false;
    TextView localTextView = (TextView)this.jdField_a_of_type_Azdp.getContentView().findViewById(2131297297);
    if (localTextView != null) {
      localTextView.setText(2131628806);
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
    aisc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "aio_at", true);
    if (this.jdField_a_of_type_Azdp == null) {
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
      if ((!paramView.isEmpty()) && (this.jdField_a_of_type_Azcx.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!this.d))
      {
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.d("AtPanel", 2, new Object[] { "showDialogAtView: invoked. ", " noNeedToFetch: ", Boolean.valueOf(bool) });
        }
        if (!bool) {
          break label231;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.a(paramString, paramBoolean, this.jdField_a_of_type_Aejb.F());
      }
    }
    for (;;)
    {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A48E", "0X800A48E", 0, 0, "", "", "", "");
      return;
      bool = false;
      break;
      label231:
      this.jdField_a_of_type_Azdp.a(0, 2131624331);
      this.jdField_a_of_type_Azcx.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.d = false;
      continue;
      this.jdField_a_of_type_Azdp.a(8, 2131624331);
      this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.a(paramString, paramBoolean, this.jdField_a_of_type_Aejb.F());
    }
  }
  
  public void a(azdw paramazdw)
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
        if ((paramazdw.a == null) || (paramazdw.a.isEmpty()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AtPanel", 2, "resultList = null");
          }
          a();
          return;
        }
        this.jdField_a_of_type_Azdp.a(8, 2131624331);
        c();
        if (this.jdField_a_of_type_Azdo != null) {
          this.jdField_a_of_type_Azdo.jdField_a_of_type_Azdr.a(paramazdw);
        }
        if (!this.c) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AtPanel", 2, "From Multi");
      return;
    } while (this.jdField_a_of_type_Azdo == null);
    this.jdField_a_of_type_Azdo.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Azdo.jdField_a_of_type_ComTencentWidgetXListView.getAdapter());
    this.jdField_a_of_type_Azdo.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_Azdo != null) && (this.jdField_a_of_type_Azdp != null) && (this.jdField_a_of_type_Azdp.isShowing())) {
      this.jdField_a_of_type_Azdo.jdField_a_of_type_Azdr.a(paramString);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.c = true;
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.a(paramString, paramBoolean, this.jdField_a_of_type_Aejb.F());
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Azdp != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Azdp.isShowing())
      {
        this.jdField_a_of_type_Azdp.dismiss();
        bool1 = true;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.a();
    return bool1;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Ajuc != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajuc);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AtPanel", 2, " removeObserver =" + this.jdField_a_of_type_Ajuc);
    }
    a();
    this.jdField_a_of_type_Azdp = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.a(null);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.b();
    if ((this.jdField_a_of_type_Azdo != null) && (this.jdField_a_of_type_Azdo.jdField_a_of_type_Azdr != null)) {
      this.jdField_a_of_type_Azdo.jdField_a_of_type_Azdr.c();
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Azdo != null) {
      return this.jdField_a_of_type_Azdo.jdField_a_of_type_Azdr.jdField_a_of_type_Boolean;
    }
    return false;
  }
  
  public void c()
  {
    ScreenShotDetector.getInstance().a(this);
    azdx.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_Azdp.a();
    this.jdField_a_of_type_Azdp.showAtLocation(this.jdField_a_of_type_AndroidViewView, 48, 0, 0);
    this.jdField_a_of_type_Azdp.a(azdx.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity), azdx.a, -1);
    this.jdField_a_of_type_Azdo.jdField_a_of_type_Azdr.a();
  }
  
  public void onDismiss()
  {
    this.c = false;
    this.b = false;
    this.jdField_a_of_type_JavaLangString = null;
    ScreenShotDetector.getInstance().a(null);
    aisc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "aio_at", false);
    if (this.jdField_a_of_type_Azdo != null) {
      this.jdField_a_of_type_Azdo.jdField_a_of_type_Azdr.b();
    }
    int i = azdx.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("input_method");
    View localView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131302566);
    if ((i == 2) && (localInputMethodManager != null) && (localView != null)) {
      localInputMethodManager.showSoftInput(localView, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azdd
 * JD-Core Version:    0.7.0.1
 */