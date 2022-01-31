import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.onlinestatus.AccountPanel.1;
import com.tencent.mobileqq.onlinestatus.AccountPanel.17;
import com.tencent.mobileqq.onlinestatus.AccountPanel.2;
import com.tencent.mobileqq.onlinestatus.AccountPanel.3;
import com.tencent.mobileqq.onlinestatus.AccountPanel.9;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;

public class avyo
  extends Dialog
  implements View.OnClickListener, awan
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private alox jdField_a_of_type_Alox = new avyq(this);
  private alsi jdField_a_of_type_Alsi = new avys(this);
  private alyr jdField_a_of_type_Alyr = new avyr(this);
  public Handler a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new avzc(this);
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private avze jdField_a_of_type_Avze;
  private avzf jdField_a_of_type_Avzf;
  private awae jdField_a_of_type_Awae = new avyt(this);
  private awap jdField_a_of_type_Awap;
  private bdfq jdField_a_of_type_Bdfq;
  public bepp a;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SimpleAccount jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount;
  private String jdField_a_of_type_JavaLangString;
  private Observer jdField_a_of_type_JavaUtilObserver = new avyu(this);
  private AppRuntime.Status jdField_a_of_type_MqqAppAppRuntime$Status;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new avyw(this);
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long = -1L;
  private View jdField_b_of_type_AndroidViewView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d = true;
  
  public avyo(@NonNull BaseActivity paramBaseActivity)
  {
    super(paramBaseActivity, 2131755225);
    if (Build.VERSION.SDK_INT >= 14) {
      getWindow().setDimAmount(0.5F);
    }
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      getWindow().addFlags(67108864);
    }
    ImmersiveUtils.a(getWindow(), true);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558424, null));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364767);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364800));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131361861));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131371362));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131361878));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368758));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364963);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
    setContentView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
  }
  
  private int a()
  {
    int j = ((azyu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(61)).b().size();
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getAllAccounts();
    int i = j;
    if (localList != null)
    {
      i = j;
      if (localList.size() > 0) {
        i = j + 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "getRequestNum: " + i);
    }
    return i;
  }
  
  private View a()
  {
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558425, null);
    avzd localavzd = new avzd(this, localView, 0);
    localavzd.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130837527));
    localavzd.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getText(2131698732));
    localavzd.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131166871));
    localView.setTag(localavzd);
    return localView;
  }
  
  private View a(SubAccountInfo paramSubAccountInfo)
  {
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558425, null);
    avzd localavzd = new avzd(this, localView, 2);
    localavzd.a(bcxb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramSubAccountInfo.subuin));
    localavzd.a(bdbt.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSubAccountInfo.subuin, false));
    azyq localazyq = azyl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSubAccountInfo.subuin);
    if ((localazyq.jdField_a_of_type_Int > 0) && (paramSubAccountInfo.status == 1))
    {
      localavzd.a(localazyq.jdField_a_of_type_Int, localazyq.jdField_a_of_type_Boolean);
      localavzd.a(true);
      if (paramSubAccountInfo.status == 1) {
        break label151;
      }
      localavzd.b(true);
    }
    for (;;)
    {
      localView.setTag(2131361879, paramSubAccountInfo.subuin);
      localView.setTag(2131361860, paramSubAccountInfo);
      localView.setTag(localavzd);
      return localView;
      localavzd.a(0, false);
      break;
      label151:
      localavzd.b(false);
    }
  }
  
  private View a(SimpleAccount paramSimpleAccount)
  {
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558425, null);
    avzd localavzd = new avzd(this, localView, 1);
    localavzd.a(bcxb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramSimpleAccount.getUin()));
    localavzd.a(azyl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSimpleAccount));
    localavzd.a(0, false);
    localavzd.a(false);
    localavzd.b(false);
    localView.setTag(2131361879, paramSimpleAccount.getUin());
    localView.setTag(2131361860, paramSimpleAccount);
    localView.setTag(localavzd);
    return localView;
  }
  
  private avzd a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i;
    View localView;
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() > 0))
    {
      int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      i = 0;
      if (i < j)
      {
        localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        if (!paramString.equals((String)localView.getTag(2131361879))) {}
      }
    }
    for (paramString = localView;; paramString = null)
    {
      if (paramString != null) {}
      for (paramString = (avzd)paramString.getTag();; paramString = null)
      {
        return paramString;
        i += 1;
        break;
      }
    }
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      if (!bdog.a().a())
      {
        paramView.setVisibility(8);
        return;
      }
      paramView.setVisibility(0);
      paramView.findViewById(2131368472).setOnClickListener(new avyv(this));
      paramView = (TextView)paramView.findViewById(2131375784);
    } while (paramView == null);
    AccountPanel.17 local17 = new AccountPanel.17(this, paramView);
    local17.run();
    paramView.setTag("online_status_callback".hashCode(), local17);
    bdog.a().a(local17);
  }
  
  private void a(AppRuntime.Status paramStatus, long paramLong)
  {
    if (paramStatus != null)
    {
      this.jdField_a_of_type_MqqAppAppRuntime$Status = paramStatus;
      this.jdField_a_of_type_Long = paramLong;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramStatus, paramLong);
      if (this.jdField_a_of_type_Avzf != null) {
        this.jdField_a_of_type_Avzf.a(paramStatus);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, String.format("switchOnlineStatus %s", new Object[] { paramStatus }));
    }
  }
  
  private boolean a(awam paramawam, AppRuntime.Status paramStatus)
  {
    if ((paramStatus == AppRuntime.Status.online) && (this.jdField_a_of_type_MqqAppAppRuntime$Status == AppRuntime.Status.online)) {
      if (this.jdField_a_of_type_Long != paramawam.jdField_a_of_type_Long) {}
    }
    while (this.jdField_a_of_type_MqqAppAppRuntime$Status == paramStatus)
    {
      return true;
      return false;
    }
    return false;
  }
  
  private boolean a(String paramString, azyv paramazyv)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramazyv == null) || (TextUtils.isEmpty(paramString));
  }
  
  private boolean a(boolean paramBoolean, String paramString, azyw paramazyw)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramazyw == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.d("AccountPanel", 1, String.format("onGetSubAccountMsg return, isSuccess: %s, mainAccount: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
      return true;
    }
    if (!TextUtils.equals(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      QLog.d("AccountPanel", 1, String.format("onGetSubAccountMsg return, mainAccount: %s not equal", new Object[] { paramString }));
      return true;
    }
    return false;
  }
  
  private void b(AppRuntime.Status paramStatus, long paramLong)
  {
    if ((this.jdField_a_of_type_Bdfq != null) && (this.jdField_a_of_type_Bdfq.isShowing()))
    {
      this.jdField_a_of_type_Bdfq.dismiss();
      this.jdField_a_of_type_Bdfq = null;
    }
    String str1 = awaf.a().a(paramLong, paramStatus);
    str1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131698751, new Object[] { str1 });
    String str2 = ((awad)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(319)).a().mRawText;
    Object localObject1 = new Paint();
    ((Paint)localObject1).setTextSize(bdkf.d(14.0F));
    int i;
    if ((paramLong == 1000L) || (paramLong == 1028L))
    {
      if (paramLong == 1000L) {}
      for (i = 2131698748;; i = 2131698744)
      {
        str2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(i);
        this.jdField_a_of_type_Bdfq = bdcd.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setTitle(str1).setMessageWithoutAutoLink(new baig(str2, 3, 16)).setMessageMaxLine(4);
        if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {
          this.jdField_a_of_type_Bdfq.show();
        }
        this.jdField_a_of_type_Bdfq.setPositiveButton(2131698749, new avza(this, paramStatus, paramLong));
        this.jdField_a_of_type_Bdfq.setNegativeButton(2131698740, new avzb(this));
        this.jdField_a_of_type_Bdfq.setCancelable(false);
        this.jdField_a_of_type_Bdfq.show();
        return;
      }
    }
    int j;
    if (paramStatus == AppRuntime.Status.dnd)
    {
      j = 2131698742;
      i = 4;
    }
    for (;;)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(j);
      str2 = baiy.a(str2, (Paint)localObject1, 3, 16, (int)(aekt.a(i * 242, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources()) - ((Paint)localObject1).measureText((String)localObject2)), true);
      str2 = AutoReplyText.trimRawString(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(j, new Object[] { str2 }), true);
      localObject1 = new SpannableString(str2);
      localObject2 = new avyy(this, paramStatus, paramLong);
      ((SpannableString)localObject1).setSpan(localObject2, str2.length() - 7, str2.length(), 33);
      this.jdField_a_of_type_Bdfq = bdcd.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setTitle(str1).setMessageWithoutAutoLink(new baig((CharSequence)localObject1, 3, 16)).setMessageMaxLine(i);
      if (!AppSetting.c) {
        break;
      }
      this.jdField_a_of_type_Bdfq.getMessageTextView().setAccessibilityDelegate(new avyz(this, (ClickableSpan)localObject2));
      break;
      i = 3;
      j = 2131698750;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alox);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alyr);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alsi);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Awae);
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanel", 2, "removeObservers");
      }
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    Object localObject1 = ((azyu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(61)).b();
    Object localObject2 = new ArrayList();
    Object localObject5;
    Object localObject6;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject3 = ((List)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (SubAccountInfo)((Iterator)localObject3).next();
        if ((localObject4 != null) && (!TextUtils.isEmpty(((SubAccountInfo)localObject4).subuin)))
        {
          localObject5 = a((SubAccountInfo)localObject4);
          ((View)localObject5).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          ((View)localObject5).setOnTouchListener(new mwx());
          localObject6 = new LinearLayout.LayoutParams(bdkf.a(68.0F), -2);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
          ((List)localObject2).add(((SubAccountInfo)localObject4).subuin);
          if (QLog.isColorLevel()) {
            QLog.d("AccountPanel", 2, String.format("prepareContentViews, add sub account uin: %s", new Object[] { ((SubAccountInfo)localObject4).subuin }));
          }
        }
      }
    }
    Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getAllAccounts();
    Object localObject3 = new ArrayList();
    if (localObject4 != null) {
      ((List)localObject3).addAll((Collection)localObject4);
    }
    if ((localObject3 != null) && (((List)localObject3).size() > 0))
    {
      localObject4 = ((List)localObject3).iterator();
      localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    }
    label653:
    for (;;)
    {
      label294:
      int i;
      label313:
      int j;
      if (((Iterator)localObject4).hasNext())
      {
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() >= 7) {
          QLog.d("AccountPanel", 1, "add account exceed the limit");
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          if (localObject3 == null) {
            break label627;
          }
          i = ((List)localObject3).size();
          if (localObject1 == null) {
            break label632;
          }
          j = ((List)localObject1).size();
          label324:
          QLog.d("AccountPanel", 2, String.format("prepareContentViews, account size: %s, sub account size: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
        }
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0) {
          break label637;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698737);
        label374:
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() < 7)
        {
          localObject1 = a();
          ((View)localObject1).setOnTouchListener(new mwx());
          localObject2 = new LinearLayout.LayoutParams(bdkf.a(68.0F), -2);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1, 0, (ViewGroup.LayoutParams)localObject2);
          ((View)localObject1).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        }
        return;
      }
      localObject6 = (SimpleAccount)((Iterator)localObject4).next();
      if ((!TextUtils.isEmpty(((SimpleAccount)localObject6).getUin())) && (!((SimpleAccount)localObject6).getUin().equals(localObject5)))
      {
        Object localObject7 = ((List)localObject2).iterator();
        Object localObject8;
        do
        {
          if (!((Iterator)localObject7).hasNext()) {
            break;
          }
          localObject8 = (String)((Iterator)localObject7).next();
        } while (!((SimpleAccount)localObject6).getUin().equals(localObject8));
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label653;
          }
          localObject7 = a((SimpleAccount)localObject6);
          ((View)localObject7).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          ((View)localObject7).setOnTouchListener(new mwx());
          localObject8 = new LinearLayout.LayoutParams(bdkf.a(68.0F), -2);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject7, (ViewGroup.LayoutParams)localObject8);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("AccountPanel", 2, String.format("prepareContentViews, add account uin: %s", new Object[] { ((SimpleAccount)localObject6).getUin() }));
          break;
          QLog.d("AccountPanel", 1, "localAccountList is empty");
          break label294;
          label627:
          i = 0;
          break label313;
          label632:
          j = 0;
          break label324;
          label637:
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698738);
          break label374;
        }
      }
    }
  }
  
  private void i()
  {
    h();
    if (this.jdField_a_of_type_Awap == null)
    {
      this.jdField_a_of_type_Awap = new awap(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_b_of_type_AndroidWidgetLinearLayout, this, 5);
      this.jdField_a_of_type_Awap.a();
    }
    for (;;)
    {
      this.jdField_a_of_type_MqqAppAppRuntime$Status = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus();
      this.jdField_a_of_type_Long = awaf.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Awap.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
      return;
      this.jdField_a_of_type_Awap.b();
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alox);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alyr);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alsi);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Awae);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanel", 2, "addObservers");
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    b(true);
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "onDestory");
    }
  }
  
  public void a(avze paramavze)
  {
    this.jdField_a_of_type_Avze = paramavze;
  }
  
  public void a(avzf paramavzf)
  {
    this.jdField_a_of_type_Avzf = paramavzf;
  }
  
  public void a(awam paramawam1, awam paramawam2)
  {
    if (!bdee.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131720293, 1).a();
      if (this.jdField_a_of_type_Awap != null) {
        this.jdField_a_of_type_Awap.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
      }
    }
    for (;;)
    {
      return;
      AppRuntime.Status localStatus = awaf.a().a(paramawam2);
      paramawam1 = awaf.a().a(paramawam1);
      if ((localStatus != null) && (paramawam2 != null) && (!a(paramawam2, localStatus)))
      {
        awak.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localStatus, paramawam2.jdField_a_of_type_Long);
        a(true);
        SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("online_battery", 0);
        boolean bool = localSharedPreferences.getBoolean("has_set_battery", false);
        if ((awaf.a().a(paramawam2)) && (!bool))
        {
          localSharedPreferences.edit().putBoolean("has_set_battery", true).apply();
          b(localStatus, paramawam2.jdField_a_of_type_Long);
        }
        while (QLog.isColorLevel())
        {
          QLog.d("AccountPanel", 2, String.format("onOnlineStatusChanged, %s -> %s, %d", new Object[] { paramawam1, localStatus, Long.valueOf(paramawam2.jdField_a_of_type_Long) }));
          return;
          if (awai.a(localStatus))
          {
            b(localStatus, paramawam2.jdField_a_of_type_Long);
          }
          else if ((paramawam2.jdField_a_of_type_Long == 1028L) && (!awar.a()))
          {
            awar.a();
            b(localStatus, paramawam2.jdField_a_of_type_Long);
          }
          else
          {
            a(localStatus, paramawam2.jdField_a_of_type_Long);
          }
        }
      }
    }
  }
  
  public void a(SimpleAccount paramSimpleAccount)
  {
    if (!bdee.e(BaseApplication.getContext()))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692397), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "switchAccount toAccount=" + paramSimpleAccount);
    }
    d();
    this.jdField_a_of_type_JavaLangString = paramSimpleAccount.getUin();
    Intent localIntent = new Intent("before_account_change");
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.sendBroadcast(localIntent);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.switchAccount(paramSimpleAccount, null);
    azyk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    bdar.b();
  }
  
  public void a(SimpleAccount paramSimpleAccount, QQAppInterface paramQQAppInterface)
  {
    azyq localazyq = azyl.a(paramQQAppInterface, paramSimpleAccount.getUin());
    if ((localazyq.jdField_a_of_type_Int <= 0) || (localazyq.jdField_a_of_type_Boolean)) {
      a(paramSimpleAccount);
    }
    for (;;)
    {
      if (localazyq.jdField_a_of_type_Int > 0) {
        ThreadManagerV2.executeOnSubThread(new AccountPanel.9(this, paramQQAppInterface, paramSimpleAccount));
      }
      return;
      this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = paramSimpleAccount;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.c)
      {
        this.c = false;
        ThreadManager.getUIHandler().post(new AccountPanel.3(this));
      }
    }
    for (;;)
    {
      b(false);
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanel", 2, String.format("dismiss AccountPanel, needAnim: %s", new Object[] { Boolean.valueOf(paramBoolean) }));
      }
      return;
      try
      {
        super.dismiss();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public boolean a(SimpleAccount paramSimpleAccount, QQAppInterface paramQQAppInterface)
  {
    if ((paramSimpleAccount != null) && (azyl.a(paramQQAppInterface, paramSimpleAccount)))
    {
      a(paramSimpleAccount);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "onPause");
    }
    this.d = false;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "onResume");
    }
    this.d = true;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Bepp == null)
    {
      this.jdField_a_of_type_Bepp = new bepp(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      this.jdField_a_of_type_Bepp.c(true);
    }
    this.jdField_a_of_type_Bepp.c(2131695088);
    if ((this.jdField_a_of_type_Bepp != null) && (!this.jdField_a_of_type_Bepp.isShowing()) && (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())) {
      this.jdField_a_of_type_Bepp.show();
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Bepp != null) && (this.jdField_a_of_type_Bepp.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bepp.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void f()
  {
    QLog.d("AccountPanel", 2, "onAccountChanged");
    e();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
    this.jdField_a_of_type_JavaLangString = null;
    a(false);
    azyk.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "onAccoutChangeFailed");
    }
    e();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      bdfq localbdfq = bdcd.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setTitle(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131720394)).setMessage(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131720393));
      localbdfq.setPositiveButton(2131691088, new avyp(this));
      localbdfq.setCancelable(true);
      localbdfq.show();
    }
  }
  
  public void onBackPressed()
  {
    a(true);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      a(true);
      return;
    } while (this.jdField_a_of_type_Avze == null);
    this.jdField_a_of_type_Avze.a();
  }
  
  public void show()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (isShowing())) {
      return;
    }
    super.show();
    if (this.jdField_a_of_type_Avzf != null) {
      this.jdField_a_of_type_Avzf.a(this.jdField_a_of_type_MqqAppAppRuntime$Status);
    }
    j();
    i();
    ThreadManager.getUIHandler().post(new AccountPanel.1(this));
    this.jdField_a_of_type_AndroidOsHandler.post(new AccountPanel.2(this));
    Intent localIntent = new Intent("before_account_change");
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.sendBroadcast(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "show AccountPanel");
    }
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AC35", "0X800AC35", 0, 0, "", "", "", "");
    a(this.jdField_b_of_type_AndroidViewView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avyo
 * JD-Core Version:    0.7.0.1
 */