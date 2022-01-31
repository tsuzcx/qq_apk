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

public class atjj
  extends Dialog
  implements View.OnClickListener, atlk
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ajjh jdField_a_of_type_Ajjh = new atjm(this);
  private ajmm jdField_a_of_type_Ajmm = new atjo(this);
  private ajss jdField_a_of_type_Ajss = new atjn(this);
  public Handler a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new atjy(this);
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private atka jdField_a_of_type_Atka;
  private atkb jdField_a_of_type_Atkb;
  private atla jdField_a_of_type_Atla = new atjp(this);
  private atlm jdField_a_of_type_Atlm;
  private bafb jdField_a_of_type_Bafb;
  public bbms a;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private Observer jdField_a_of_type_JavaUtilObserver = new atjq(this);
  private AppRuntime.Status jdField_a_of_type_MqqAppAppRuntime$Status;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new atjs(this);
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long = -1L;
  private View jdField_b_of_type_AndroidViewView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public atjj(@NonNull BaseActivity paramBaseActivity)
  {
    super(paramBaseActivity, 2131689684);
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
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131492888, null));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131299129);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131299161));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131296326));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131305356));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131296343));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131302934));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131299313);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
    setContentView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  private int a()
  {
    int j = ((axat)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(61)).b().size();
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
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131492889, null);
    atjz localatjz = new atjz(this, localView, 0);
    localatjz.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130837527));
    localatjz.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getText(2131632695));
    localatjz.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131101230));
    localView.setTag(localatjz);
    return localView;
  }
  
  private View a(SubAccountInfo paramSubAccountInfo)
  {
    akaq localakaq = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131492889, null);
    atjz localatjz = new atjz(this, localView, 2);
    localatjz.a(azwp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramSubAccountInfo.subuin));
    localatjz.a(babh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSubAccountInfo.subuin, false));
    int i = localakaq.a(paramSubAccountInfo.subuin, 7000);
    if ((i > 0) && (paramSubAccountInfo.status == 1))
    {
      localatjz.b(i);
      localatjz.a(true);
      if (paramSubAccountInfo.status == 1) {
        break label161;
      }
      localatjz.b(true);
    }
    for (;;)
    {
      localView.setTag(2131296344, paramSubAccountInfo.subuin);
      localView.setTag(2131296325, paramSubAccountInfo);
      localView.setTag(localatjz);
      return localView;
      localatjz.b(0);
      break;
      label161:
      localatjz.b(false);
    }
  }
  
  private View a(SimpleAccount paramSimpleAccount)
  {
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131492889, null);
    atjz localatjz = new atjz(this, localView, 1);
    localatjz.a(azwp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramSimpleAccount.getUin()));
    localatjz.a(axam.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSimpleAccount));
    localatjz.b(axam.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSimpleAccount.getUin()));
    localatjz.a(false);
    localatjz.b(false);
    localView.setTag(2131296344, paramSimpleAccount.getUin());
    localView.setTag(2131296325, paramSimpleAccount);
    localView.setTag(localatjz);
    return localView;
  }
  
  private atjz a(String paramString)
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
        if (!paramString.equals((String)localView.getTag(2131296344))) {}
      }
    }
    for (paramString = localView;; paramString = null)
    {
      if (paramString != null) {}
      for (paramString = (atjz)paramString.getTag();; paramString = null)
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
      if (!banc.a().a())
      {
        paramView.setVisibility(8);
        return;
      }
      paramView.setVisibility(0);
      paramView.findViewById(2131302703).setOnClickListener(new atjr(this));
      paramView = (TextView)paramView.findViewById(2131309552);
    } while (paramView == null);
    AccountPanel.17 local17 = new AccountPanel.17(this, paramView);
    local17.run();
    paramView.setTag("online_status_callback".hashCode(), local17);
    banc.a().a(local17);
  }
  
  private void a(SimpleAccount paramSimpleAccount)
  {
    if (!badq.e(BaseApplication.getContext()))
    {
      bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131626719), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "switchAccount toAccount=" + paramSimpleAccount);
    }
    c();
    this.jdField_a_of_type_JavaLangString = paramSimpleAccount.getUin();
    Intent localIntent = new Intent("before_account_change");
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.sendBroadcast(localIntent);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.switchAccount(paramSimpleAccount, null);
    axal.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    baaf.b();
  }
  
  private void a(AppRuntime.Status paramStatus, long paramLong)
  {
    if (paramStatus != null)
    {
      this.jdField_a_of_type_MqqAppAppRuntime$Status = paramStatus;
      this.jdField_a_of_type_Long = paramLong;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramStatus, paramLong);
      if (this.jdField_a_of_type_Atkb != null) {
        this.jdField_a_of_type_Atkb.a(paramStatus);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, String.format("switchOnlineStatus %s", new Object[] { paramStatus }));
    }
  }
  
  private boolean a(atlj paramatlj, AppRuntime.Status paramStatus)
  {
    if ((paramStatus == AppRuntime.Status.online) && (this.jdField_a_of_type_MqqAppAppRuntime$Status == AppRuntime.Status.online)) {
      if (this.jdField_a_of_type_Long != paramatlj.jdField_a_of_type_Long) {}
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
    if ((this.jdField_a_of_type_Bafb != null) && (this.jdField_a_of_type_Bafb.isShowing()))
    {
      this.jdField_a_of_type_Bafb.dismiss();
      this.jdField_a_of_type_Bafb = null;
    }
    String str1 = atlb.a().a(paramLong, paramStatus);
    str1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131632710, new Object[] { str1 });
    String str2 = ((atkz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(319)).a().mRawText;
    Object localObject1 = new Paint();
    ((Paint)localObject1).setTextSize(bajq.d(14.0F));
    if (paramLong == 1000L)
    {
      str2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131632707);
      this.jdField_a_of_type_Bafb = babr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setTitle(str1).setMessageWithoutAutoLink(new axkd(str2, 3, 16)).setMessageMaxLine(4);
      if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {
        this.jdField_a_of_type_Bafb.show();
      }
      this.jdField_a_of_type_Bafb.setPositiveButton(2131632708, new atjw(this, paramStatus, paramLong));
      this.jdField_a_of_type_Bafb.setNegativeButton(2131632703, new atjx(this));
      this.jdField_a_of_type_Bafb.setCancelable(false);
      this.jdField_a_of_type_Bafb.show();
      return;
    }
    int j;
    int i;
    if (paramStatus == AppRuntime.Status.dnd)
    {
      j = 2131632705;
      i = 4;
    }
    for (;;)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(j);
      str2 = axku.a(str2, (Paint)localObject1, 3, 16, (int)(aciy.a(i * 242, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources()) - ((Paint)localObject1).measureText((String)localObject2)), true);
      str2 = AutoReplyText.trimRawString(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(j, new Object[] { str2 }), true);
      localObject1 = new SpannableString(str2);
      localObject2 = new atju(this, paramStatus, paramLong);
      ((SpannableString)localObject1).setSpan(localObject2, str2.length() - 7, str2.length(), 33);
      this.jdField_a_of_type_Bafb = babr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setTitle(str1).setMessageWithoutAutoLink(new axkd((CharSequence)localObject1, 3, 16)).setMessageMaxLine(i);
      if (!AppSetting.c) {
        break;
      }
      this.jdField_a_of_type_Bafb.getMessageTextView().setAccessibilityDelegate(new atjv(this, (ClickableSpan)localObject2));
      break;
      i = 3;
      j = 2131632709;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajjh);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajss);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajmm);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Atla);
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
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    Object localObject1 = ((axat)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(61)).b();
    Object localObject2 = new ArrayList();
    Object localObject5;
    Object localObject6;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      Collections.sort((List)localObject1, new atjk(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a()));
      localObject3 = ((List)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (SubAccountInfo)((Iterator)localObject3).next();
        if ((localObject4 != null) && (!TextUtils.isEmpty(((SubAccountInfo)localObject4).subuin)))
        {
          localObject5 = a((SubAccountInfo)localObject4);
          ((View)localObject5).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          ((View)localObject5).setOnTouchListener(new mjh());
          localObject6 = new LinearLayout.LayoutParams(bajq.a(68.0F), -2);
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
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131632700);
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() < 7)
        {
          localObject1 = a();
          ((View)localObject1).setOnTouchListener(new mjh());
          localObject2 = new LinearLayout.LayoutParams(bajq.a(68.0F), -2);
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
          ((View)localObject7).setOnTouchListener(new mjh());
          localObject8 = new LinearLayout.LayoutParams(bajq.a(68.0F), -2);
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
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131632701);
          break label396;
        }
      }
    }
  }
  
  private void h()
  {
    g();
    if (this.jdField_a_of_type_Atlm == null)
    {
      this.jdField_a_of_type_Atlm = new atlm(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_b_of_type_AndroidWidgetLinearLayout, this, 5);
      this.jdField_a_of_type_Atlm.a();
    }
    for (;;)
    {
      this.jdField_a_of_type_MqqAppAppRuntime$Status = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus();
      this.jdField_a_of_type_Long = atlb.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Atlm.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
      return;
      this.jdField_a_of_type_Atlm.b();
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajjh);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajss);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajmm);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Atla);
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
  
  public void a(atka paramatka)
  {
    this.jdField_a_of_type_Atka = paramatka;
  }
  
  public void a(atkb paramatkb)
  {
    this.jdField_a_of_type_Atkb = paramatkb;
  }
  
  public void a(atlj paramatlj1, atlj paramatlj2)
  {
    AppRuntime.Status localStatus = atlb.a().a(paramatlj2);
    paramatlj1 = atlb.a().a(paramatlj1);
    if ((localStatus != null) && (paramatlj2 != null) && (!a(paramatlj2, localStatus)))
    {
      if (badq.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity)) {
        break label85;
      }
      bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131653872, 1).a();
      if (this.jdField_a_of_type_Atlm != null) {
        this.jdField_a_of_type_Atlm.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
      }
    }
    for (;;)
    {
      return;
      label85:
      atlh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localStatus, paramatlj2.jdField_a_of_type_Long);
      a(true);
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("online_battery", 0);
      boolean bool = localSharedPreferences.getBoolean("has_set_battery", false);
      if ((atlb.a().a(paramatlj2)) && (!bool))
      {
        localSharedPreferences.edit().putBoolean("has_set_battery", true).apply();
        b(localStatus, paramatlj2.jdField_a_of_type_Long);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("AccountPanel", 2, String.format("onOnlineStatusChanged, %s -> %s", new Object[] { paramatlj1, localStatus }));
        return;
        if (atlf.a(localStatus)) {
          b(localStatus, paramatlj2.jdField_a_of_type_Long);
        } else {
          a(localStatus, paramatlj2.jdField_a_of_type_Long);
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
      QLog.d("AccountPanel", 2, "onDestory");
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bbms == null)
    {
      this.jdField_a_of_type_Bbms = new bbms(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      this.jdField_a_of_type_Bbms.c(true);
    }
    this.jdField_a_of_type_Bbms.c(2131629253);
    if ((this.jdField_a_of_type_Bbms != null) && (!this.jdField_a_of_type_Bbms.isShowing()) && (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())) {
      this.jdField_a_of_type_Bbms.show();
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bbms.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void e()
  {
    QLog.d("AccountPanel", 2, "onAccountChanged");
    d();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
    this.jdField_a_of_type_JavaLangString = null;
    a(false);
    axal.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "onAccoutChangeFailed");
    }
    d();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      bafb localbafb = babr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setTitle(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131653968)).setMessage(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131653967));
      localbafb.setPositiveButton(2131625463, new atjl(this));
      localbafb.setCancelable(true);
      localbafb.show();
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
    } while (this.jdField_a_of_type_Atka == null);
    this.jdField_a_of_type_Atka.a();
  }
  
  public void show()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (isShowing())) {
      return;
    }
    super.show();
    if (this.jdField_a_of_type_Atkb != null) {
      this.jdField_a_of_type_Atkb.a(this.jdField_a_of_type_MqqAppAppRuntime$Status);
    }
    i();
    h();
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
 * Qualified Name:     atjj
 * JD-Core Version:    0.7.0.1
 */