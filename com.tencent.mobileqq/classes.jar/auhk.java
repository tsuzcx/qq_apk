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
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.onlinestatus.AccountPanel.17;
import com.tencent.mobileqq.onlinestatus.AccountPanel.2;
import com.tencent.mobileqq.onlinestatus.AccountPanel.3;
import com.tencent.mobileqq.onlinestatus.AccountPanel.4;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;

public class auhk
  extends Dialog
  implements View.OnClickListener, aujk
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ajxj jdField_a_of_type_Ajxj = new auhn(this);
  private akat jdField_a_of_type_Akat = new auhp(this);
  private akhb jdField_a_of_type_Akhb = new auho(this);
  public Handler a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new auhz(this);
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private auib jdField_a_of_type_Auib;
  private auic jdField_a_of_type_Auic;
  private aujb jdField_a_of_type_Aujb = new auhq(this);
  private aujm jdField_a_of_type_Aujm;
  private bbgu jdField_a_of_type_Bbgu;
  public bcqf a;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private Observer jdField_a_of_type_JavaUtilObserver = new auhr(this);
  private AppRuntime.Status jdField_a_of_type_MqqAppAppRuntime$Status;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new auht(this);
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long = -1L;
  private View jdField_b_of_type_AndroidViewView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d = true;
  
  public auhk(@NonNull BaseActivity paramBaseActivity)
  {
    super(paramBaseActivity, 2131755221);
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
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364688);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364721));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131361861));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131371049));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131361878));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368563));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364876);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
    setContentView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  private int a()
  {
    int j = ((ayax)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(61)).b().size();
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
    auia localauia = new auia(this, localView, 0);
    localauia.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130837527));
    localauia.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getText(2131698441));
    localauia.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131166824));
    localView.setTag(localauia);
    return localView;
  }
  
  private View a(SubAccountInfo paramSubAccountInfo)
  {
    akpb localakpb = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558425, null);
    auia localauia = new auia(this, localView, 2);
    localauia.a(bayh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramSubAccountInfo.subuin));
    localauia.a(bbcz.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSubAccountInfo.subuin, false));
    int i = localakpb.a(paramSubAccountInfo.subuin, 7000);
    if ((i > 0) && (paramSubAccountInfo.status == 1))
    {
      localauia.b(i);
      localauia.a(true);
      if (paramSubAccountInfo.status == 1) {
        break label161;
      }
      localauia.b(true);
    }
    for (;;)
    {
      localView.setTag(2131361879, paramSubAccountInfo.subuin);
      localView.setTag(2131361860, paramSubAccountInfo);
      localView.setTag(localauia);
      return localView;
      localauia.b(0);
      break;
      label161:
      localauia.b(false);
    }
  }
  
  private View a(SimpleAccount paramSimpleAccount)
  {
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558425, null);
    auia localauia = new auia(this, localView, 1);
    localauia.a(bayh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramSimpleAccount.getUin()));
    localauia.a(ayaq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSimpleAccount));
    localauia.b(ayaq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSimpleAccount.getUin()));
    localauia.a(false);
    localauia.b(false);
    localView.setTag(2131361879, paramSimpleAccount.getUin());
    localView.setTag(2131361860, paramSimpleAccount);
    localView.setTag(localauia);
    return localView;
  }
  
  private auia a(String paramString)
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
      for (paramString = (auia)paramString.getTag();; paramString = null)
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
      if (!bbpm.a().a())
      {
        paramView.setVisibility(8);
        return;
      }
      paramView.setVisibility(0);
      paramView.findViewById(2131368325).setOnClickListener(new auhs(this));
      paramView = (TextView)paramView.findViewById(2131375302);
    } while (paramView == null);
    AccountPanel.17 local17 = new AccountPanel.17(this, paramView);
    local17.run();
    paramView.setTag("online_status_callback".hashCode(), local17);
    bbpm.a().a(local17);
  }
  
  private void a(SimpleAccount paramSimpleAccount)
  {
    if (!bbfj.e(BaseApplication.getContext()))
    {
      bcql.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692321), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
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
    ayap.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    bbbx.b();
  }
  
  private void a(AppRuntime.Status paramStatus, long paramLong)
  {
    if (paramStatus != null)
    {
      this.jdField_a_of_type_MqqAppAppRuntime$Status = paramStatus;
      this.jdField_a_of_type_Long = paramLong;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramStatus, paramLong);
      if (this.jdField_a_of_type_Auic != null) {
        this.jdField_a_of_type_Auic.a(paramStatus);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, String.format("switchOnlineStatus %s", new Object[] { paramStatus }));
    }
  }
  
  private boolean a(aujj paramaujj, AppRuntime.Status paramStatus)
  {
    if ((paramStatus == AppRuntime.Status.online) && (this.jdField_a_of_type_MqqAppAppRuntime$Status == AppRuntime.Status.online)) {
      if (this.jdField_a_of_type_Long != paramaujj.jdField_a_of_type_Long) {}
    }
    while (this.jdField_a_of_type_MqqAppAppRuntime$Status == paramStatus)
    {
      return true;
      return false;
    }
    return false;
  }
  
  private void b(AppRuntime.Status paramStatus, long paramLong)
  {
    if ((this.jdField_a_of_type_Bbgu != null) && (this.jdField_a_of_type_Bbgu.isShowing()))
    {
      this.jdField_a_of_type_Bbgu.dismiss();
      this.jdField_a_of_type_Bbgu = null;
    }
    String str1 = aujc.a().a(paramLong, paramStatus);
    str1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131698456, new Object[] { str1 });
    String str2 = ((auja)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(319)).a().mRawText;
    Object localObject1 = new Paint();
    ((Paint)localObject1).setTextSize(bbll.d(14.0F));
    if (paramLong == 1000L)
    {
      str2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131698453);
      this.jdField_a_of_type_Bbgu = bbdj.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setTitle(str1).setMessageWithoutAutoLink(new aykk(str2, 3, 16)).setMessageMaxLine(4);
      if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {
        this.jdField_a_of_type_Bbgu.show();
      }
      this.jdField_a_of_type_Bbgu.setPositiveButton(2131698454, new auhx(this, paramStatus, paramLong));
      this.jdField_a_of_type_Bbgu.setNegativeButton(2131698449, new auhy(this));
      this.jdField_a_of_type_Bbgu.setCancelable(false);
      this.jdField_a_of_type_Bbgu.show();
      return;
    }
    int j;
    int i;
    if (paramStatus == AppRuntime.Status.dnd)
    {
      j = 2131698451;
      i = 4;
    }
    for (;;)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(j);
      str2 = aylc.a(str2, (Paint)localObject1, 3, 16, (int)(actj.a(i * 242, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources()) - ((Paint)localObject1).measureText((String)localObject2)), true);
      str2 = AutoReplyText.trimRawString(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(j, new Object[] { str2 }), true);
      localObject1 = new SpannableString(str2);
      localObject2 = new auhv(this, paramStatus, paramLong);
      ((SpannableString)localObject1).setSpan(localObject2, str2.length() - 7, str2.length(), 33);
      this.jdField_a_of_type_Bbgu = bbdj.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setTitle(str1).setMessageWithoutAutoLink(new aykk((CharSequence)localObject1, 3, 16)).setMessageMaxLine(i);
      if (!AppSetting.d) {
        break;
      }
      this.jdField_a_of_type_Bbgu.getMessageTextView().setAccessibilityDelegate(new auhw(this, (ClickableSpan)localObject2));
      break;
      i = 3;
      j = 2131698455;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajxj);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akhb);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akat);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Aujb);
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanel", 2, "addObservers");
      }
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    Object localObject1 = ((ayax)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(61)).b();
    Object localObject2 = new ArrayList();
    Object localObject5;
    Object localObject6;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      Collections.sort((List)localObject1, new auhl(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a()));
      localObject3 = ((List)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (SubAccountInfo)((Iterator)localObject3).next();
        if ((localObject4 != null) && (!TextUtils.isEmpty(((SubAccountInfo)localObject4).subuin)))
        {
          localObject5 = a((SubAccountInfo)localObject4);
          ((View)localObject5).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          ((View)localObject5).setOnTouchListener(new mud());
          localObject6 = new LinearLayout.LayoutParams(bbll.a(68.0F), -2);
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
    label396:
    label654:
    label659:
    label675:
    for (;;)
    {
      label316:
      int i;
      label335:
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
            break label649;
          }
          i = ((List)localObject3).size();
          if (localObject1 == null) {
            break label654;
          }
          j = ((List)localObject1).size();
          label346:
          QLog.d("AccountPanel", 2, String.format("prepareContentViews, account size: %s, sub account size: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
        }
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0) {
          break label659;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698446);
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() < 7)
        {
          localObject1 = a();
          ((View)localObject1).setOnTouchListener(new mud());
          localObject2 = new LinearLayout.LayoutParams(bbll.a(68.0F), -2);
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
            break label675;
          }
          localObject7 = a((SimpleAccount)localObject6);
          ((View)localObject7).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          ((View)localObject7).setOnTouchListener(new mud());
          localObject8 = new LinearLayout.LayoutParams(bbll.a(68.0F), -2);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject7, (ViewGroup.LayoutParams)localObject8);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("AccountPanel", 2, String.format("prepareContentViews, add account uin: %s", new Object[] { ((SimpleAccount)localObject6).getUin() }));
          break;
          QLog.d("AccountPanel", 1, "localAccountList is empty");
          break label316;
          i = 0;
          break label335;
          j = 0;
          break label346;
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698447);
          break label396;
        }
      }
    }
  }
  
  private void i()
  {
    h();
    if (this.jdField_a_of_type_Aujm == null)
    {
      this.jdField_a_of_type_Aujm = new aujm(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_b_of_type_AndroidWidgetLinearLayout, this, 5);
      this.jdField_a_of_type_Aujm.a();
    }
    for (;;)
    {
      this.jdField_a_of_type_MqqAppAppRuntime$Status = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus();
      this.jdField_a_of_type_Long = aujc.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Aujm.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
      return;
      this.jdField_a_of_type_Aujm.b();
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajxj);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akhb);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akat);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Aujb);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
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
  
  public void a(auib paramauib)
  {
    this.jdField_a_of_type_Auib = paramauib;
  }
  
  public void a(auic paramauic)
  {
    this.jdField_a_of_type_Auic = paramauic;
  }
  
  public void a(aujj paramaujj1, aujj paramaujj2)
  {
    AppRuntime.Status localStatus = aujc.a().a(paramaujj2);
    paramaujj1 = aujc.a().a(paramaujj1);
    if ((localStatus != null) && (paramaujj2 != null) && (!a(paramaujj2, localStatus)))
    {
      if (bbfj.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity)) {
        break label85;
      }
      bcql.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131719767, 1).a();
      if (this.jdField_a_of_type_Aujm != null) {
        this.jdField_a_of_type_Aujm.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
      }
    }
    for (;;)
    {
      return;
      label85:
      aujh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localStatus, paramaujj2.jdField_a_of_type_Long);
      a(true);
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("online_battery", 0);
      boolean bool = localSharedPreferences.getBoolean("has_set_battery", false);
      if ((aujc.a().a(paramaujj2)) && (!bool))
      {
        localSharedPreferences.edit().putBoolean("has_set_battery", true).apply();
        b(localStatus, paramaujj2.jdField_a_of_type_Long);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("AccountPanel", 2, String.format("onOnlineStatusChanged, %s -> %s", new Object[] { paramaujj1, localStatus }));
        return;
        if (aujf.a(localStatus)) {
          b(localStatus, paramaujj2.jdField_a_of_type_Long);
        } else {
          a(localStatus, paramaujj2.jdField_a_of_type_Long);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.c)
      {
        this.c = false;
        ThreadManager.getUIHandler().post(new AccountPanel.4(this));
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
    if (this.jdField_a_of_type_Bcqf == null)
    {
      this.jdField_a_of_type_Bcqf = new bcqf(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      this.jdField_a_of_type_Bcqf.c(true);
    }
    this.jdField_a_of_type_Bcqf.c(2131694931);
    if ((this.jdField_a_of_type_Bcqf != null) && (!this.jdField_a_of_type_Bcqf.isShowing()) && (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())) {
      this.jdField_a_of_type_Bcqf.show();
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bcqf.dismiss();
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
    ayap.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
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
      bbgu localbbgu = bbdj.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setTitle(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719863)).setMessage(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719862));
      localbbgu.setPositiveButton(2131691035, new auhm(this));
      localbbgu.setCancelable(true);
      localbbgu.show();
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
    } while (this.jdField_a_of_type_Auib == null);
    this.jdField_a_of_type_Auib.a();
  }
  
  public void show()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (isShowing())) {
      return;
    }
    super.show();
    if (this.jdField_a_of_type_Auic != null) {
      this.jdField_a_of_type_Auic.a(this.jdField_a_of_type_MqqAppAppRuntime$Status);
    }
    j();
    i();
    ThreadManager.getUIHandler().post(new AccountPanel.2(this));
    this.jdField_a_of_type_AndroidOsHandler.post(new AccountPanel.3(this));
    Intent localIntent = new Intent("before_account_change");
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.sendBroadcast(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "show AccountPanel");
    }
    a(this.jdField_b_of_type_AndroidViewView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auhk
 * JD-Core Version:    0.7.0.1
 */