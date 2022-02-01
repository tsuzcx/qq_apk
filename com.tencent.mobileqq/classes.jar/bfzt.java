import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.screendetect.ScreenShotDetector;
import com.tencent.mobileqq.troop.quickat.ui.AIOAtSearchManager;
import com.tencent.mobileqq.troop.quickat.ui.AtPanel.3;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

public class bfzt
  implements PopupWindow.OnDismissListener, bbxi, bfzo, bfzw
{
  private View jdField_a_of_type_AndroidViewView;
  private aofu jdField_a_of_type_Aofu;
  bfzn jdField_a_of_type_Bfzn;
  private bgae jdField_a_of_type_Bgae;
  private bgaf jdField_a_of_type_Bgaf;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private final TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AIOAtSearchManager jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  
  public bfzt(TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramTroopChatPie.getActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramTroopChatPie.app;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramTroopChatPie.sessionInfo;
    this.jdField_a_of_type_Bfzn = new bfzn(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager = new AIOAtSearchManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.a(this);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Aofu == null) {
      this.jdField_a_of_type_Aofu = new bfzu(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aofu);
    if (QLog.isColorLevel()) {
      QLog.d("AtPanel", 2, " addObservers =" + this.jdField_a_of_type_Aofu);
    }
  }
  
  private void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131368909);
    View localView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131362385);
    this.jdField_a_of_type_Bgaf = bgaf.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, -1, -1);
    this.jdField_a_of_type_Bgaf.setTouchInterceptor(new bfzv(this, localView, (View)localObject));
    this.jdField_a_of_type_Bgaf.setOnDismissListener(this);
    localObject = (XListView)this.jdField_a_of_type_Bgaf.getContentView().findViewById(2131379545);
    this.jdField_a_of_type_Bgae = new bgae(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.context, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie, this.jdField_a_of_type_Bgaf.getContentView(), (XListView)localObject);
    this.jdField_a_of_type_Bgae.jdField_a_of_type_Bgah.a(this);
    this.jdField_a_of_type_Bgaf.a(this.jdField_a_of_type_Bgae.jdField_a_of_type_Bgah.a());
    d();
    ((aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).q(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AtPanel", 2, "initMultiSelectMode: invoked. ");
    }
    this.jdField_a_of_type_Bgae.jdField_a_of_type_Bgah.a().jdField_a_of_type_Boolean = false;
    TextView localTextView = (TextView)this.jdField_a_of_type_Bgaf.getContentView().findViewById(2131363035);
    if (localTextView != null) {
      localTextView.setText(2131694187);
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
    ancb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "aio_at", true);
    if (this.jdField_a_of_type_Bgaf == null) {
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
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.a();
    if ((TextUtils.isEmpty(paramString)) || (bool))
    {
      c();
      if ((!bool) && (this.jdField_a_of_type_Bfzn.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) && (!this.d))
      {
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.d("AtPanel", 2, new Object[] { "showDialogAtView: invoked. ", " noNeedToFetch: ", Boolean.valueOf(bool) });
        }
        if (!bool) {
          break label225;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.a(paramString, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.c());
      }
    }
    for (;;)
    {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A48E", "0X800A48E", 0, 0, "", "", "", "");
      return;
      bool = false;
      break;
      label225:
      this.jdField_a_of_type_Bgaf.a(0, 2131689873);
      this.jdField_a_of_type_Bfzn.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
      this.d = false;
      continue;
      this.jdField_a_of_type_Bgaf.a(8, 2131689873);
      this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.a(paramString, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.c());
    }
  }
  
  public void a(bgam parambgam)
  {
    if (!this.b) {
      if (QLog.isColorLevel()) {
        QLog.d("AtPanel", 2, "refreshUI =" + this.b);
      }
    }
    do
    {
      return;
      if ((parambgam.a == null) || (parambgam.a.isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AtPanel", 2, "resultList = null");
        }
        a();
        return;
      }
      this.jdField_a_of_type_Bgaf.a(8, 2131689873);
      c();
      this.jdField_a_of_type_Bgae.jdField_a_of_type_Bgah.a(parambgam);
      if (!this.c) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AtPanel", 2, "From Multi");
    return;
    this.jdField_a_of_type_Bgae.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Bgae.jdField_a_of_type_ComTencentWidgetXListView.getAdapter());
    this.jdField_a_of_type_Bgae.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_Bgae != null) && (this.jdField_a_of_type_Bgaf != null) && (this.jdField_a_of_type_Bgaf.isShowing())) {
      this.jdField_a_of_type_Bgae.jdField_a_of_type_Bgah.a(paramString);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.c = true;
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.a(paramString, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.c());
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Bgaf != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Bgaf.isShowing())
      {
        this.jdField_a_of_type_Bgaf.dismiss();
        bool1 = true;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.a();
    return bool1;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aofu != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aofu);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AtPanel", 2, " removeObserver =" + this.jdField_a_of_type_Aofu);
    }
    a();
    this.jdField_a_of_type_Bgaf = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.a(null);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.b();
    if ((this.jdField_a_of_type_Bgae != null) && (this.jdField_a_of_type_Bgae.jdField_a_of_type_Bgah != null)) {
      this.jdField_a_of_type_Bgae.jdField_a_of_type_Bgah.c();
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Bgae != null) {
      return this.jdField_a_of_type_Bgae.jdField_a_of_type_Bgah.jdField_a_of_type_Boolean;
    }
    return false;
  }
  
  public void c()
  {
    ScreenShotDetector.getInstance().a(this);
    bgan.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_Bgaf.b();
    this.jdField_a_of_type_Bgaf.showAtLocation(this.jdField_a_of_type_AndroidViewView, 48, 0, 0);
    this.jdField_a_of_type_Bgaf.a(bgan.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity), bgan.a, -1);
    this.jdField_a_of_type_Bgae.jdField_a_of_type_Bgah.a();
  }
  
  public void onDismiss()
  {
    this.c = false;
    this.b = false;
    this.jdField_a_of_type_JavaLangString = null;
    ScreenShotDetector.getInstance().a(null);
    ancb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "aio_at", false);
    if (this.jdField_a_of_type_Bgae != null) {
      this.jdField_a_of_type_Bgae.jdField_a_of_type_Bgah.b();
    }
    int i = bgan.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("input_method");
    View localView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131368909);
    if ((i == 2) && (localInputMethodManager != null) && (localView != null)) {
      localInputMethodManager.showSoftInput(localView, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfzt
 * JD-Core Version:    0.7.0.1
 */