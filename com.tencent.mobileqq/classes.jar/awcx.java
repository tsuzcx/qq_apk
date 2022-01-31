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

public class awcx
  extends Dialog
  implements View.OnClickListener, awew
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private altm jdField_a_of_type_Altm = new awcz(this);
  private alwx jdField_a_of_type_Alwx = new awdb(this);
  private amdg jdField_a_of_type_Amdg = new awda(this);
  public Handler a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new awdl(this);
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private awdn jdField_a_of_type_Awdn;
  private awdo jdField_a_of_type_Awdo;
  private awen jdField_a_of_type_Awen = new awdc(this);
  private awey jdField_a_of_type_Awey;
  private bdjz jdField_a_of_type_Bdjz;
  public bety a;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SimpleAccount jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount;
  private String jdField_a_of_type_JavaLangString;
  private Observer jdField_a_of_type_JavaUtilObserver = new awdd(this);
  private AppRuntime.Status jdField_a_of_type_MqqAppAppRuntime$Status;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new awdf(this);
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long = -1L;
  private View jdField_b_of_type_AndroidViewView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d = true;
  
  public awcx(@NonNull BaseActivity paramBaseActivity)
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
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364768);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364801));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131361861));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131371381));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131361878));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368771));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364965);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
    setContentView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
  }
  
  private int a()
  {
    int j = ((badd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(61)).b().size();
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
    awdm localawdm = new awdm(this, localView, 0);
    localawdm.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130837527));
    localawdm.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getText(2131698744));
    localawdm.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131166873));
    localView.setTag(localawdm);
    return localView;
  }
  
  private View a(SubAccountInfo paramSubAccountInfo)
  {
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558425, null);
    awdm localawdm = new awdm(this, localView, 2);
    localawdm.a(bdbk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramSubAccountInfo.subuin));
    localawdm.a(bdgc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSubAccountInfo.subuin, false));
    bacz localbacz = bacu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSubAccountInfo.subuin);
    if ((localbacz.jdField_a_of_type_Int > 0) && (paramSubAccountInfo.status == 1))
    {
      localawdm.a(localbacz.jdField_a_of_type_Int, localbacz.jdField_a_of_type_Boolean);
      localawdm.a(true);
      if (paramSubAccountInfo.status == 1) {
        break label151;
      }
      localawdm.b(true);
    }
    for (;;)
    {
      localView.setTag(2131361879, paramSubAccountInfo.subuin);
      localView.setTag(2131361860, paramSubAccountInfo);
      localView.setTag(localawdm);
      return localView;
      localawdm.a(0, false);
      break;
      label151:
      localawdm.b(false);
    }
  }
  
  private View a(SimpleAccount paramSimpleAccount)
  {
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558425, null);
    awdm localawdm = new awdm(this, localView, 1);
    localawdm.a(bdbk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramSimpleAccount.getUin()));
    localawdm.a(bacu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSimpleAccount));
    localawdm.a(0, false);
    localawdm.a(false);
    localawdm.b(false);
    localView.setTag(2131361879, paramSimpleAccount.getUin());
    localView.setTag(2131361860, paramSimpleAccount);
    localView.setTag(localawdm);
    return localView;
  }
  
  private awdm a(String paramString)
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
      for (paramString = (awdm)paramString.getTag();; paramString = null)
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
      if (!bdsp.a().a())
      {
        paramView.setVisibility(8);
        return;
      }
      paramView.setVisibility(0);
      paramView.findViewById(2131368483).setOnClickListener(new awde(this));
      paramView = (TextView)paramView.findViewById(2131375835);
    } while (paramView == null);
    AccountPanel.17 local17 = new AccountPanel.17(this, paramView);
    local17.run();
    paramView.setTag("online_status_callback".hashCode(), local17);
    bdsp.a().a(local17);
  }
  
  private void a(AppRuntime.Status paramStatus, long paramLong)
  {
    if (paramStatus != null)
    {
      this.jdField_a_of_type_MqqAppAppRuntime$Status = paramStatus;
      this.jdField_a_of_type_Long = paramLong;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramStatus, paramLong);
      if (this.jdField_a_of_type_Awdo != null) {
        this.jdField_a_of_type_Awdo.a(paramStatus);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, String.format("switchOnlineStatus %s", new Object[] { paramStatus }));
    }
  }
  
  private boolean a(awev paramawev, AppRuntime.Status paramStatus)
  {
    if ((paramStatus == AppRuntime.Status.online) && (this.jdField_a_of_type_MqqAppAppRuntime$Status == AppRuntime.Status.online)) {
      if (this.jdField_a_of_type_Long != paramawev.jdField_a_of_type_Long) {}
    }
    while (this.jdField_a_of_type_MqqAppAppRuntime$Status == paramStatus)
    {
      return true;
      return false;
    }
    return false;
  }
  
  private boolean a(String paramString, bade parambade)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (parambade == null) || (TextUtils.isEmpty(paramString));
  }
  
  private boolean a(boolean paramBoolean, String paramString, badf parambadf)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (parambadf == null) || (TextUtils.isEmpty(paramString)))
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
    if ((this.jdField_a_of_type_Bdjz != null) && (this.jdField_a_of_type_Bdjz.isShowing()))
    {
      this.jdField_a_of_type_Bdjz.dismiss();
      this.jdField_a_of_type_Bdjz = null;
    }
    String str1 = aweo.a().a(paramLong, paramStatus);
    str1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131698763, new Object[] { str1 });
    String str2 = ((awem)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(319)).a().mRawText;
    Object localObject1 = new Paint();
    ((Paint)localObject1).setTextSize(bdoo.d(14.0F));
    int i;
    if ((paramLong == 1000L) || (paramLong == 1028L))
    {
      if (paramLong == 1000L) {}
      for (i = 2131698760;; i = 2131698756)
      {
        str2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(i);
        this.jdField_a_of_type_Bdjz = bdgm.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setTitle(str1).setMessageWithoutAutoLink(new bamp(str2, 3, 16)).setMessageMaxLine(4);
        if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {
          this.jdField_a_of_type_Bdjz.show();
        }
        this.jdField_a_of_type_Bdjz.setPositiveButton(2131698761, new awdj(this, paramStatus, paramLong));
        this.jdField_a_of_type_Bdjz.setNegativeButton(2131698752, new awdk(this));
        this.jdField_a_of_type_Bdjz.setCancelable(false);
        this.jdField_a_of_type_Bdjz.show();
        return;
      }
    }
    int j;
    if (paramStatus == AppRuntime.Status.dnd)
    {
      j = 2131698754;
      i = 4;
    }
    for (;;)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(j);
      str2 = banh.a(str2, (Paint)localObject1, 3, 16, (int)(aepi.a(i * 242, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources()) - ((Paint)localObject1).measureText((String)localObject2)), true);
      str2 = AutoReplyText.trimRawString(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(j, new Object[] { str2 }), true);
      localObject1 = new SpannableString(str2);
      localObject2 = new awdh(this, paramStatus, paramLong);
      ((SpannableString)localObject1).setSpan(localObject2, str2.length() - 7, str2.length(), 33);
      this.jdField_a_of_type_Bdjz = bdgm.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setTitle(str1).setMessageWithoutAutoLink(new bamp((CharSequence)localObject1, 3, 16)).setMessageMaxLine(i);
      if (!AppSetting.c) {
        break;
      }
      this.jdField_a_of_type_Bdjz.getMessageTextView().setAccessibilityDelegate(new awdi(this, (ClickableSpan)localObject2));
      break;
      i = 3;
      j = 2131698762;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Altm);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amdg);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alwx);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Awen);
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
    Object localObject1 = ((badd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(61)).b();
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
          localObject6 = new LinearLayout.LayoutParams(bdoo.a(68.0F), -2);
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
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698749);
        label374:
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() < 7)
        {
          localObject1 = a();
          ((View)localObject1).setOnTouchListener(new mwx());
          localObject2 = new LinearLayout.LayoutParams(bdoo.a(68.0F), -2);
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
          localObject8 = new LinearLayout.LayoutParams(bdoo.a(68.0F), -2);
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
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698750);
          break label374;
        }
      }
    }
  }
  
  private void i()
  {
    h();
    if (this.jdField_a_of_type_Awey == null)
    {
      this.jdField_a_of_type_Awey = new awey(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_b_of_type_AndroidWidgetLinearLayout, this, 5);
      this.jdField_a_of_type_Awey.a();
    }
    for (;;)
    {
      this.jdField_a_of_type_MqqAppAppRuntime$Status = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus();
      this.jdField_a_of_type_Long = aweo.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Awey.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
      return;
      this.jdField_a_of_type_Awey.b();
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Altm);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amdg);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alwx);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Awen);
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
  
  public void a(awdn paramawdn)
  {
    this.jdField_a_of_type_Awdn = paramawdn;
  }
  
  public void a(awdo paramawdo)
  {
    this.jdField_a_of_type_Awdo = paramawdo;
  }
  
  public void a(awev paramawev1, awev paramawev2)
  {
    if (!bdin.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131720305, 1).a();
      if (this.jdField_a_of_type_Awey != null) {
        this.jdField_a_of_type_Awey.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
      }
    }
    for (;;)
    {
      return;
      AppRuntime.Status localStatus = aweo.a().a(paramawev2);
      paramawev1 = aweo.a().a(paramawev1);
      if ((localStatus != null) && (paramawev2 != null) && (!a(paramawev2, localStatus)))
      {
        awet.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localStatus, paramawev2.jdField_a_of_type_Long);
        a(true);
        SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("online_battery", 0);
        boolean bool = localSharedPreferences.getBoolean("has_set_battery", false);
        if ((aweo.a().a(paramawev2)) && (!bool))
        {
          localSharedPreferences.edit().putBoolean("has_set_battery", true).apply();
          b(localStatus, paramawev2.jdField_a_of_type_Long);
        }
        while (QLog.isColorLevel())
        {
          QLog.d("AccountPanel", 2, String.format("onOnlineStatusChanged, %s -> %s, %d", new Object[] { paramawev1, localStatus, Long.valueOf(paramawev2.jdField_a_of_type_Long) }));
          return;
          if (awer.a(localStatus))
          {
            b(localStatus, paramawev2.jdField_a_of_type_Long);
          }
          else if ((paramawev2.jdField_a_of_type_Long == 1028L) && (!awfa.a()))
          {
            awfa.a();
            b(localStatus, paramawev2.jdField_a_of_type_Long);
          }
          else
          {
            a(localStatus, paramawev2.jdField_a_of_type_Long);
          }
        }
      }
    }
  }
  
  public void a(SimpleAccount paramSimpleAccount)
  {
    if (!bdin.e(BaseApplication.getContext()))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692398), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
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
    bact.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    bdfa.b();
  }
  
  public void a(SimpleAccount paramSimpleAccount, QQAppInterface paramQQAppInterface)
  {
    bacz localbacz = bacu.a(paramQQAppInterface, paramSimpleAccount.getUin());
    if ((localbacz.jdField_a_of_type_Int <= 0) || (localbacz.jdField_a_of_type_Boolean)) {
      a(paramSimpleAccount);
    }
    for (;;)
    {
      if (localbacz.jdField_a_of_type_Int > 0) {
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
    if ((paramSimpleAccount != null) && (bacu.a(paramQQAppInterface, paramSimpleAccount)))
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
    if (this.jdField_a_of_type_Bety == null)
    {
      this.jdField_a_of_type_Bety = new bety(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      this.jdField_a_of_type_Bety.c(true);
    }
    this.jdField_a_of_type_Bety.c(2131695090);
    if ((this.jdField_a_of_type_Bety != null) && (!this.jdField_a_of_type_Bety.isShowing()) && (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())) {
      this.jdField_a_of_type_Bety.show();
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bety.dismiss();
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
    bact.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
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
      bdjz localbdjz = bdgm.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setTitle(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131720406)).setMessage(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131720405));
      localbdjz.setPositiveButton(2131691089, new awcy(this));
      localbdjz.setCancelable(true);
      localbdjz.show();
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
    } while (this.jdField_a_of_type_Awdn == null);
    this.jdField_a_of_type_Awdn.a();
  }
  
  public void show()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (isShowing())) {
      return;
    }
    super.show();
    if (this.jdField_a_of_type_Awdo != null) {
      this.jdField_a_of_type_Awdo.a(this.jdField_a_of_type_MqqAppAppRuntime$Status);
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
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AC35", "0X800AC35", 0, 0, "", "", "", "");
    a(this.jdField_b_of_type_AndroidViewView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awcx
 * JD-Core Version:    0.7.0.1
 */