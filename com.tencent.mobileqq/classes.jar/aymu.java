import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.AddAccountActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.onlinestatus.AccountPanel.16;
import com.tencent.mobileqq.onlinestatus.AccountPanel.3;
import com.tencent.mobileqq.onlinestatus.AccountPanel.9;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.mobileqq.onlinestatus.view.AccountPanelRootLayout;
import com.tencent.mobileqq.profile.view.ReboundHorizontalScrollView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;
import mqq.observer.AccountObserver;

public class aymu
  extends ayti
  implements View.OnClickListener, ayou, aypm, aytd
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  public Handler a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aynm(this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private anmu jdField_a_of_type_Anmu = new aymx(this);
  private anqd jdField_a_of_type_Anqd = new aymz(this);
  private anvp jdField_a_of_type_Anvp = new aymy(this);
  private ayno jdField_a_of_type_Ayno;
  private aynp jdField_a_of_type_Aynp;
  private ayor jdField_a_of_type_Ayor = new ayna(this);
  private ayos jdField_a_of_type_Ayos;
  private ayov jdField_a_of_type_Ayov = new ayov(true, true);
  private aypl jdField_a_of_type_Aypl = new aynd(this);
  private aypr jdField_a_of_type_Aypr = new ayne(this);
  private aypw jdField_a_of_type_Aypw;
  private aytf jdField_a_of_type_Aytf;
  private aytj jdField_a_of_type_Aytj;
  private aytv jdField_a_of_type_Aytv;
  private ayuf jdField_a_of_type_Ayuf = new aynh(this);
  private bgpa jdField_a_of_type_Bgpa;
  public biau a;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AccountPanelRootLayout jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout;
  private ReboundHorizontalScrollView jdField_a_of_type_ComTencentMobileqqProfileViewReboundHorizontalScrollView;
  private SimpleAccount jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount;
  private Runnable jdField_a_of_type_JavaLangRunnable = new AccountPanel.16(this);
  private String jdField_a_of_type_JavaLangString;
  private Observer jdField_a_of_type_JavaUtilObserver = new aynb(this);
  private AppRuntime.Status jdField_a_of_type_MqqAppAppRuntime$Status;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new aync(this);
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long = -1L;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean = true;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean = true;
  private View e;
  private View f;
  
  public aymu(@android.support.annotation.NonNull BaseActivity paramBaseActivity)
  {
    super(paramBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout = ((AccountPanelRootLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558427, null));
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.setAccountPanelRootLayoutListener(this);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout;
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131364996);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131361927);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131365031));
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131371510);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131371511));
    this.jdField_d_of_type_AndroidViewView.setOnTouchListener(new muf());
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(Typeface.defaultFromStyle(1));
    o();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131361896));
    this.f = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131377344);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewReboundHorizontalScrollView = ((ReboundHorizontalScrollView)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131361898));
    this.jdField_a_of_type_ComTencentMobileqqProfileViewReboundHorizontalScrollView.setOverScrollDistance(afur.a(48.0F, getContext().getResources()));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131371952));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131361924));
    this.e = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131369018);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131369115));
    this.jdField_a_of_type_Ayov.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidViewViewGroup, 2);
    this.jdField_a_of_type_Ayov.b().setOnClickListener(this);
    this.jdField_a_of_type_Ayov.a().setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(new muf());
    setContentView(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    this.jdField_a_of_type_Ayos = new ayos();
    a(new float[] { 0.5F, 0.0F });
  }
  
  private int a()
  {
    int j = ((bdeh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(61)).b().size();
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
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558428, null);
    localView.setTag(new aynn(this, localView));
    localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localView.setOnTouchListener(new aypv(localView.findViewById(2131363120)));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(bgtn.a(64.0F), -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams);
    return localView;
  }
  
  private aynn a(String paramString)
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
        if (!paramString.equals((String)localView.getTag(2131361925))) {}
      }
    }
    for (paramString = localView;; paramString = null)
    {
      if (paramString != null) {}
      for (paramString = (aynn)paramString.getTag();; paramString = null)
      {
        return paramString;
        i += 1;
        break;
      }
    }
  }
  
  private void a(aynn paramaynn, SubAccountInfo paramSubAccountInfo, View paramView)
  {
    paramaynn.a(2);
    paramaynn.a(aoch.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramSubAccountInfo.subuin));
    paramaynn.a(bglf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSubAccountInfo.subuin, false));
    bded localbded = bddy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSubAccountInfo.subuin);
    if ((localbded.jdField_a_of_type_Int > 0) && (paramSubAccountInfo.status == 1))
    {
      paramaynn.a(localbded.jdField_a_of_type_Int, localbded.jdField_a_of_type_Boolean);
      paramaynn.a(true);
      if (paramSubAccountInfo.status == 1) {
        break label127;
      }
      paramaynn.b(true);
    }
    for (;;)
    {
      paramView.setTag(2131361925, paramSubAccountInfo.subuin);
      paramView.setTag(2131361895, paramSubAccountInfo);
      return;
      paramaynn.a(0, false);
      break;
      label127:
      paramaynn.b(false);
    }
  }
  
  private void a(aynn paramaynn, SimpleAccount paramSimpleAccount, View paramView)
  {
    paramaynn.a(1);
    paramaynn.a(aoch.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramSimpleAccount.getUin()));
    paramaynn.a(bddy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSimpleAccount));
    paramaynn.a(bddy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSimpleAccount.getUin()), false);
    paramaynn.a(false);
    paramaynn.b(false);
    paramView.setTag(2131361925, paramSimpleAccount.getUin());
    paramView.setTag(2131361895, paramSimpleAccount);
    paramView.setTag(paramaynn);
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, new Object[] { "[foreground] closeAccountPanelRecursive: invoked. ", " reason: ", paramString });
    }
    if ((BaseActivity.sTopActivity != null) && ((BaseActivity.sTopActivity instanceof FragmentActivity)))
    {
      paramString = FrameHelperActivity.a(BaseActivity.sTopActivity);
      if (paramString != null)
      {
        paramString = paramString.a;
        if ((paramString != null) && (paramString.isShowing())) {
          paramString.aH_();
        }
      }
    }
  }
  
  private void a(List<Object> paramList)
  {
    int j = paramList.size();
    if (j <= 0)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      return;
    }
    int k = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    if (k == j)
    {
      b(paramList);
      return;
    }
    int m;
    int i;
    if (k < j)
    {
      m = 1;
      if (m == 0) {
        break label90;
      }
      i = k;
      label57:
      if (m == 0) {
        break label95;
      }
    }
    for (;;)
    {
      if (m == 0) {
        break label101;
      }
      while (i < j)
      {
        a();
        i += 1;
      }
      m = 0;
      break;
      label90:
      i = j;
      break label57;
      label95:
      j = k;
    }
    label101:
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeViews(i, j - i);
    b(paramList);
  }
  
  private void a(AppRuntime.Status paramStatus, long paramLong)
  {
    if ((this.jdField_a_of_type_Bgpa != null) && (this.jdField_a_of_type_Bgpa.isShowing()))
    {
      this.jdField_a_of_type_Bgpa.dismiss();
      this.jdField_a_of_type_Bgpa = null;
    }
    String str1 = ayox.a().a(paramLong, paramStatus);
    str1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131697651, new Object[] { str1 });
    String str2 = ((ayon)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(319)).a().mRawText;
    Object localObject1 = new Paint();
    ((Paint)localObject1).setTextSize(bgtn.d(14.0F));
    int i;
    if ((paramLong == 1000L) || (paramLong == 1028L))
    {
      if (paramLong == 1000L) {}
      for (i = 2131697646;; i = 2131697642)
      {
        str2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(i);
        this.jdField_a_of_type_Bgpa = bglp.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setTitle(str1).setMessageWithoutAutoLink(new bdnt(str2, 3, 16)).setMessageMaxLine(4);
        if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {
          this.jdField_a_of_type_Bgpa.show();
        }
        this.jdField_a_of_type_Bgpa.setPositiveButton(2131697649, new aynk(this, paramStatus, paramLong));
        this.jdField_a_of_type_Bgpa.setNegativeButton(2131697637, new aynl(this));
        this.jdField_a_of_type_Bgpa.setCancelable(false);
        this.jdField_a_of_type_Bgpa.show();
        return;
      }
    }
    int j;
    if (paramStatus == AppRuntime.Status.dnd)
    {
      j = 2131697640;
      i = 4;
    }
    for (;;)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(j);
      str2 = bdol.a(str2, (Paint)localObject1, 3, 16, (int)(afur.a(i * 242, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources()) - ((Paint)localObject1).measureText((String)localObject2)), true);
      str2 = AutoReplyText.trimRawString(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(j, new Object[] { str2 }), true);
      localObject1 = new SpannableString(str2);
      localObject2 = new ayni(this, paramStatus, paramLong);
      ((SpannableString)localObject1).setSpan(localObject2, str2.length() - 7, str2.length(), 33);
      this.jdField_a_of_type_Bgpa = bglp.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setTitle(str1).setMessageWithoutAutoLink(new bdnt((CharSequence)localObject1, 3, 16)).setMessageMaxLine(i);
      if (!AppSetting.jdField_c_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_Bgpa.getMessageTextView().setAccessibilityDelegate(new aynj(this, (ClickableSpan)localObject2));
      break;
      i = 3;
      j = 2131697650;
    }
  }
  
  private void a(AppRuntime.Status paramStatus, long paramLong, boolean paramBoolean)
  {
    if (paramStatus != null)
    {
      this.jdField_a_of_type_MqqAppAppRuntime$Status = paramStatus;
      this.jdField_a_of_type_Long = paramLong;
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramStatus, paramLong);
      }
      this.jdField_a_of_type_Ayov.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_Aypw != null) {
        this.jdField_a_of_type_Aypw.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
      }
      if (this.jdField_a_of_type_Aynp != null) {
        this.jdField_a_of_type_Aynp.a(paramStatus);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, String.format("switchOnlineStatus %s", new Object[] { paramStatus }));
    }
  }
  
  private void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (paramBoolean1) {
        this.jdField_b_of_type_Boolean = true;
      }
      if (this.jdField_a_of_type_Int > 0) {
        this.jdField_a_of_type_Int -= 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanel", 2, new Object[] { " mRequestNum=", Integer.valueOf(this.jdField_a_of_type_Int), " subAccountMsgComing=", Boolean.valueOf(paramBoolean2) });
      }
      if (this.jdField_a_of_type_Int == 0)
      {
        this.jdField_a_of_type_Boolean = false;
        if (this.jdField_b_of_type_Boolean) {
          p();
        }
      }
    }
    while (!paramBoolean1) {
      return;
    }
    if (paramBoolean2)
    {
      b(paramString);
      return;
    }
    s();
  }
  
  private boolean a()
  {
    AppRuntime.Status localStatus = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatusNonSync();
    aypi localaypi = ayox.a().a(localStatus, this.jdField_a_of_type_Long);
    Friends localFriends = ((anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    ayox localayox = ayox.a();
    if (localaypi.jdField_a_of_type_Long > 0L)
    {
      bool = true;
      if ((localayox.a(localaypi, localFriends, bool)) || (localStatus != AppRuntime.Status.online)) {
        break label124;
      }
    }
    label124:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanel", 2, new Object[] { "isDisplayOnline ", " useFallbackOnlineText: ", Boolean.valueOf(bool) });
      }
      return bool;
      bool = false;
      break;
    }
  }
  
  private boolean a(aypi paramaypi, AppRuntime.Status paramStatus)
  {
    if ((paramStatus == AppRuntime.Status.online) && (this.jdField_a_of_type_MqqAppAppRuntime$Status == AppRuntime.Status.online)) {
      if (this.jdField_a_of_type_Long != paramaypi.jdField_a_of_type_Long) {}
    }
    while (this.jdField_a_of_type_MqqAppAppRuntime$Status == paramStatus)
    {
      return true;
      return false;
    }
    return false;
  }
  
  private boolean a(String paramString, bdei parambdei)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (parambdei == null) || (TextUtils.isEmpty(paramString));
  }
  
  private boolean a(boolean paramBoolean, String paramString, bdej parambdej)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (parambdej == null) || (TextUtils.isEmpty(paramString)))
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
  
  private void b(View paramView)
  {
    if (this.jdField_a_of_type_Aytf == null)
    {
      this.jdField_a_of_type_Aytf = new aytf(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Ayos);
      this.jdField_a_of_type_Aytf.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_Aytf.jdField_a_of_type_Int = 1;
    }
    this.jdField_a_of_type_Aytf.a(aypu.a(paramView));
    if (Build.VERSION.SDK_INT >= 23) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.requestPermissions(new aymv(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    }
    for (;;)
    {
      aypy.a("0X800AF3E", 1);
      return;
      this.jdField_a_of_type_Aytf.a(null);
      this.jdField_a_of_type_Aytf.show();
    }
  }
  
  private void b(String paramString)
  {
    aynn localaynn = a(paramString);
    if (localaynn != null)
    {
      paramString = bddy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      localaynn.a(paramString.jdField_a_of_type_Int, paramString.jdField_a_of_type_Boolean);
    }
  }
  
  private void b(List<Object> paramList)
  {
    int i = 0;
    if (i < paramList.size())
    {
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      aynn localaynn = (aynn)localView.getTag();
      Object localObject = paramList.get(i);
      if ((localObject instanceof SubAccountInfo)) {
        a(localaynn, (SubAccountInfo)localObject, localView);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof SimpleAccount)) {
          a(localaynn, (SimpleAccount)localObject, localView);
        }
      }
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anmu);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anvp);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anqd);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Ayor);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Aypr);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Ayuf);
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aypl);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanel", 2, "removeObservers");
      }
    }
  }
  
  private void n()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatusNonSync();
    long l = ayox.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject3 = ((anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    aypi localaypi = ayox.a().a((AppRuntime.Status)localObject1, l);
    Object localObject4 = ayox.a().a(localaypi);
    Object localObject2;
    boolean bool;
    if (localObject1 == AppRuntime.Status.online)
    {
      localObject2 = ayox.a();
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localaypi.jdField_a_of_type_Long > 0L)
      {
        bool = true;
        localObject2 = ((ayox)localObject2).a(localQQAppInterface, (Friends)localObject3, localTextView, 3, localaypi, Boolean.valueOf(bool));
        label124:
        if (localObject4 != AppRuntime.Status.online) {
          break label326;
        }
        localObject4 = ayox.a();
        if (localaypi.jdField_a_of_type_Long <= 0L) {
          break label320;
        }
        bool = true;
        label150:
        if (((ayox)localObject4).a(localaypi, (Friends)localObject3, bool)) {
          break label326;
        }
        localObject3 = ayox.a().a(0L, AppRuntime.Status.online, 1, (Friends)localObject3);
        label179:
        if ((l != 1030L) && (l != 1040L) && (!a())) {
          break label361;
        }
        if (!bkpg.a()) {
          break label343;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130841440);
        label223:
        int i = afur.a(16.0F, BaseApplicationImpl.getContext().getResources());
        ((Drawable)localObject1).setBounds(0, 0, i, i);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(afur.a(4.0F, getContext().getResources()));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject3, null, (Drawable)localObject1, null);
      return;
      bool = false;
      break;
      localObject2 = ayox.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaypi, (AppRuntime.Status)localObject4, (Friends)localObject3, this.jdField_a_of_type_AndroidWidgetTextView, 3);
      break label124;
      label320:
      bool = false;
      break label150;
      label326:
      localObject3 = ayox.a().a(l, (AppRuntime.Status)localObject1, 1, (Friends)localObject3);
      break label179;
      label343:
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839272);
      break label223;
      label361:
      localObject1 = null;
    }
  }
  
  private void o()
  {
    if (bkpg.a())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#d8d8d8"));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
  }
  
  private void p()
  {
    Object localObject1 = new ArrayList();
    ArrayList localArrayList1 = ((bdeh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(61)).b();
    ArrayList localArrayList2 = new ArrayList();
    if ((localArrayList1 != null) && (localArrayList1.size() > 0))
    {
      localObject2 = localArrayList1.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (SubAccountInfo)((Iterator)localObject2).next();
        if ((localObject3 != null) && (!TextUtils.isEmpty(((SubAccountInfo)localObject3).subuin)))
        {
          ((List)localObject1).add(localObject3);
          localArrayList2.add(((SubAccountInfo)localObject3).subuin);
          if (QLog.isColorLevel()) {
            QLog.d("AccountPanel", 2, String.format("prepareContentViews, add sub account uin: %s", new Object[] { ((SubAccountInfo)localObject3).subuin }));
          }
        }
      }
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getAllAccounts();
    Object localObject2 = new ArrayList();
    if (localObject3 != null) {
      ((List)localObject2).addAll((Collection)localObject3);
    }
    String str1;
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject3 = ((List)localObject2).iterator();
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    }
    label280:
    label293:
    label680:
    label688:
    for (;;)
    {
      label255:
      int i;
      int j;
      if (((Iterator)localObject3).hasNext())
      {
        if (localArrayList2.size() >= 7) {
          QLog.d("AccountPanel", 1, "add account exceed the limit");
        }
      }
      else
      {
        a((List)localObject1);
        if (QLog.isColorLevel())
        {
          if (localObject2 == null) {
            break label625;
          }
          i = ((List)localObject2).size();
          if (localArrayList1 == null) {
            break label630;
          }
          j = localArrayList1.size();
          QLog.d("AccountPanel", 2, String.format("prepareContentViews, account size: %s, sub account size: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
        }
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0) {
          break label635;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131697635);
        label344:
        localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqProfileViewReboundHorizontalScrollView.getLayoutParams();
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() >= 7) {
          break label648;
        }
        this.e.setVisibility(0);
        this.e.setOnClickListener(this);
        this.e.setOnTouchListener(new muf());
        ((RelativeLayout.LayoutParams)localObject1).addRule(0, this.e.getId());
        boolean bool = aypu.a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount(), this.jdField_a_of_type_AndroidWidgetLinearLayout.getResources());
        if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
          break label673;
        }
        i = 2130841438;
        label445:
        localObject1 = this.f;
        if (!bool) {
          break label680;
        }
        label455:
        ((View)localObject1).setBackgroundResource(i);
        ayov.a(this.jdField_c_of_type_AndroidViewView, false, null, true);
        ayov.a(this.jdField_d_of_type_AndroidViewView, false, null, true);
        return;
      }
      SimpleAccount localSimpleAccount = (SimpleAccount)((Iterator)localObject3).next();
      if ((!TextUtils.isEmpty(localSimpleAccount.getUin())) && (!localSimpleAccount.getUin().equals(str1)))
      {
        Iterator localIterator = localArrayList2.iterator();
        String str2;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          str2 = (String)localIterator.next();
        } while (!localSimpleAccount.getUin().equals(str2));
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label688;
          }
          ((List)localObject1).add(localSimpleAccount);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("AccountPanel", 2, String.format("prepareContentViews, add account uin: %s", new Object[] { localSimpleAccount.getUin() }));
          break;
          QLog.d("AccountPanel", 1, "localAccountList is empty");
          break label255;
          label625:
          i = 0;
          break label280;
          label630:
          j = 0;
          break label293;
          label635:
          this.jdField_b_of_type_AndroidWidgetTextView.setText(2131697636);
          break label344;
          this.e.setVisibility(8);
          ((RelativeLayout.LayoutParams)localObject1).addRule(0, this.jdField_a_of_type_AndroidWidgetImageView.getId());
          break label411;
          i = 2130841437;
          break label445;
          i = 0;
          break label455;
        }
      }
    }
  }
  
  private void q()
  {
    p();
    if (this.jdField_a_of_type_Aypw == null)
    {
      this.jdField_a_of_type_Aypw = new aypw(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_b_of_type_AndroidWidgetLinearLayout, this, 3, 1);
      this.jdField_a_of_type_Aypw.a();
    }
    for (;;)
    {
      c();
      return;
      this.jdField_a_of_type_Aypw.a(true, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anmu);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anvp);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anqd);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Ayor);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Aypr);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Ayuf);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
      }
      bgxp.a().a(this.jdField_a_of_type_JavaLangRunnable);
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessObserver(1).contains(this.jdField_a_of_type_Aypl)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aypl);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanel", 2, "addObservers");
      }
    }
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {}
    for (;;)
    {
      return;
      int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        String str = (String)((View)localObject).getTag(2131361925);
        if ((!TextUtils.isEmpty(str)) && ((((View)localObject).getTag() instanceof aynn)))
        {
          localObject = (aynn)((View)localObject).getTag();
          if (((aynn)localObject).jdField_a_of_type_Int == 1) {
            ((aynn)localObject).a(bddy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str), false);
          }
        }
        i += 1;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aypw != null) {
      this.jdField_a_of_type_Aypw.c();
    }
    o();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Aypw != null) {
      this.jdField_a_of_type_Aypw.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 100) {
      OnlineStatusPermissionChecker.a(paramIntent, paramInt2, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, true);
    }
    do
    {
      return;
      if ((paramInt1 == 1001) && (this.jdField_a_of_type_Aytj != null))
      {
        this.jdField_a_of_type_Aytj.a(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent);
        n();
        return;
      }
      if ((paramInt1 == 999) && (this.jdField_a_of_type_Aytf != null))
      {
        this.jdField_a_of_type_Aytf.a(paramInt1, paramInt2, paramIntent);
        return;
      }
      if ((paramInt1 == 998) && (this.jdField_a_of_type_Aytv != null))
      {
        this.jdField_a_of_type_Aytv.a(paramInt1, paramInt2, paramIntent);
        return;
      }
    } while ((paramInt1 != 299) && (paramInt1 != 234));
    c();
  }
  
  public void a(View paramView)
  {
    b(true);
  }
  
  public void a(ayno paramayno)
  {
    this.jdField_a_of_type_Ayno = paramayno;
  }
  
  public void a(aynp paramaynp)
  {
    this.jdField_a_of_type_Aynp = paramaynp;
  }
  
  public void a(aypi paramaypi1, aypi paramaypi2, View paramView)
  {
    if (!bgnt.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131718205, 1).a();
      if (this.jdField_a_of_type_Aypw != null)
      {
        this.jdField_a_of_type_Ayov.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
        this.jdField_a_of_type_Aypw.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
      }
    }
    for (;;)
    {
      return;
      AppRuntime.Status localStatus = ayox.a().a(paramaypi2);
      paramaypi1 = ayox.a().a(paramaypi1);
      if ((localStatus != null) && (paramaypi2 != null))
      {
        if (paramaypi2.jdField_a_of_type_Long == 1040L)
        {
          if (this.jdField_a_of_type_Aytj == null)
          {
            this.jdField_a_of_type_Aytj = new aytj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Ayos, this);
            this.jdField_a_of_type_Aytj.a(aypu.a(paramView));
          }
          this.jdField_a_of_type_Aytj.show();
          return;
        }
        if (paramaypi2.jdField_a_of_type_Long == 1030L)
        {
          if (this.jdField_a_of_type_Aytv == null)
          {
            this.jdField_a_of_type_Aytv = new aytv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Ayos, this);
            this.jdField_a_of_type_Aytv.a(aypu.a(paramView));
          }
          if (Build.VERSION.SDK_INT >= 23)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.requestPermissions(new aynf(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
            return;
          }
          ((aypj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(369)).a(9);
          this.jdField_a_of_type_Aytv.show();
          return;
        }
      }
      if ((localStatus != null) && (paramaypi2 != null) && (!a(paramaypi2, localStatus)))
      {
        aype.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localStatus, paramaypi2.jdField_a_of_type_Long);
        paramView = BaseApplicationImpl.getContext().getSharedPreferences("online_battery", 0);
        boolean bool = paramView.getBoolean("has_set_battery", false);
        if ((ayox.a().a(paramaypi2)) && (!bool))
        {
          paramView.edit().putBoolean("has_set_battery", true).apply();
          a(localStatus, paramaypi2.jdField_a_of_type_Long);
        }
        while (QLog.isColorLevel())
        {
          QLog.d("AccountPanel", 2, String.format("onOnlineStatusChanged, %s -> %s, %d", new Object[] { paramaypi1, localStatus, Long.valueOf(paramaypi2.jdField_a_of_type_Long) }));
          return;
          if (aypc.a(localStatus))
          {
            a(localStatus, paramaypi2.jdField_a_of_type_Long);
          }
          else if ((paramaypi2.jdField_a_of_type_Long == 1028L) && (!aysz.a()))
          {
            aysz.a();
            a(localStatus, paramaypi2.jdField_a_of_type_Long);
          }
          else
          {
            a(localStatus, paramaypi2.jdField_a_of_type_Long, true);
          }
        }
      }
    }
  }
  
  public void a(SimpleAccount paramSimpleAccount)
  {
    if (!bgnt.e(BaseApplication.getContext()))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691985), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "switchAccount toAccount=" + paramSimpleAccount);
    }
    i();
    this.jdField_a_of_type_JavaLangString = paramSimpleAccount.getUin();
    Intent localIntent = new Intent("before_account_change");
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.sendBroadcast(localIntent);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.switchAccount(paramSimpleAccount, null);
    bddx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    bgkc.b();
  }
  
  public void a(SimpleAccount paramSimpleAccount, QQAppInterface paramQQAppInterface)
  {
    bded localbded = bddy.a(paramQQAppInterface, paramSimpleAccount.getUin());
    if ((localbded.jdField_a_of_type_Int <= 0) || (localbded.jdField_a_of_type_Boolean)) {
      a(paramSimpleAccount);
    }
    for (;;)
    {
      if (localbded.jdField_a_of_type_Int > 0) {
        ThreadManagerV2.executeOnSubThread(new AccountPanel.9(this, paramQQAppInterface, paramSimpleAccount));
      }
      return;
      this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = paramSimpleAccount;
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, Bitmap paramBitmap, int paramInt)
  {
    if ((paramBoolean) && (paramBitmap != null) && (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout != null)) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
    }
    while (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.setBackgroundColor(paramInt);
  }
  
  protected void a(int[] paramArrayOfInt)
  {
    if ((this.jdField_b_of_type_AndroidViewView.getWidth() != 0) && (this.jdField_b_of_type_AndroidViewView.getHeight() != 0))
    {
      paramArrayOfInt[0] = this.jdField_b_of_type_AndroidViewView.getWidth();
      paramArrayOfInt[1] = this.jdField_b_of_type_AndroidViewView.getHeight();
      return;
    }
    paramArrayOfInt[0] = this.jdField_b_of_type_AndroidViewView.getResources().getDisplayMetrics().widthPixels;
    paramArrayOfInt[1] = afur.a(554.0F, this.jdField_b_of_type_AndroidViewView.getResources());
  }
  
  public boolean a(SimpleAccount paramSimpleAccount, QQAppInterface paramQQAppInterface)
  {
    if ((paramSimpleAccount != null) && (bddy.a(paramQQAppInterface, paramSimpleAccount)))
    {
      a(paramSimpleAccount);
      return true;
    }
    return false;
  }
  
  public void aH_()
  {
    try
    {
      b(false);
      if (this.jdField_a_of_type_Aytj != null) {
        this.jdField_a_of_type_Aytj.m();
      }
      if (this.jdField_a_of_type_Aytv != null) {
        this.jdField_a_of_type_Aytv.m();
      }
      if (this.jdField_a_of_type_Aytf != null) {
        this.jdField_a_of_type_Aytf.m();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AccountPanel", 1, "dismissRecursive: failed. ", localException);
    }
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    b(false);
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, String.format("dismiss AccountPanel, needAnim: %s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    this.jdField_a_of_type_Ayov.a();
    if (!paramBoolean)
    {
      m();
      return;
    }
    dismiss();
  }
  
  public void c()
  {
    if (!isShowing()) {
      return;
    }
    this.jdField_a_of_type_MqqAppAppRuntime$Status = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus();
    this.jdField_a_of_type_Long = ayox.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Ayov.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
    if (this.jdField_a_of_type_Aypw != null) {
      this.jdField_a_of_type_Aypw.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
    }
    n();
  }
  
  protected void c(boolean paramBoolean)
  {
    float f6 = 1.0F;
    float f1;
    float f2;
    label17:
    float f3;
    label24:
    float f4;
    label31:
    float f5;
    if (paramBoolean)
    {
      f1 = 0.5F;
      if (!paramBoolean) {
        break label235;
      }
      f2 = 1.0F;
      if (!paramBoolean) {
        break label242;
      }
      f3 = 0.0F;
      if (!paramBoolean) {
        break label248;
      }
      f4 = 1.0F;
      if (!paramBoolean) {
        break label254;
      }
      f5 = 0.02F;
      label40:
      if (!paramBoolean) {
        break label260;
      }
    }
    for (;;)
    {
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView, "scaleX", new float[] { f1, f2 });
      localObjectAnimator1.setDuration(230L);
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView, "scaleY", new float[] { f1, f2 });
      localObjectAnimator2.setDuration(230L);
      ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView, "alpha", new float[] { f5, f6 });
      if (paramBoolean) {
        localObjectAnimator3.setStartDelay(70L);
      }
      localObjectAnimator3.setDuration(70L);
      ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "alpha", new float[] { f3, f4 });
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2).with(localObjectAnimator3).with(localObjectAnimator4);
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.setDuration(300L);
      return;
      f1 = 1.0F;
      break;
      label235:
      f2 = 0.5F;
      break label17;
      label242:
      f3 = 1.0F;
      break label24;
      label248:
      f4 = 0.0F;
      break label31;
      label254:
      f5 = 1.0F;
      break label40;
      label260:
      f6 = 0.02F;
    }
  }
  
  protected void e()
  {
    super.e();
    d(false);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    d(true);
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "onDestory");
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "onPause");
    }
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "onResume");
    }
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Biau == null)
    {
      this.jdField_a_of_type_Biau = new biau(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      this.jdField_a_of_type_Biau.c(true);
    }
    this.jdField_a_of_type_Biau.c(2131694158);
    if ((this.jdField_a_of_type_Biau != null) && (!this.jdField_a_of_type_Biau.isShowing()) && (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())) {
      this.jdField_a_of_type_Biau.show();
    }
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_Biau != null) && (this.jdField_a_of_type_Biau.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Biau.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void k()
  {
    QLog.d("AccountPanel", 2, "onAccountChanged");
    j();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Aytv = null;
    this.jdField_a_of_type_Aytj = null;
    this.jdField_a_of_type_Aytf = null;
    b(false);
    bddx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    }
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "onAccoutChangeFailed");
    }
    this.jdField_a_of_type_Aytv = null;
    this.jdField_a_of_type_Aytj = null;
    this.jdField_a_of_type_Aytf = null;
    j();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      bgpa localbgpa = bglp.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setTitle(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131718279)).setMessage(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131718278));
      localbgpa.setPositiveButton(2131690912, new aymw(this));
      localbgpa.setCancelable(true);
      localbgpa.show();
    }
  }
  
  public void onBackPressed()
  {
    b(true);
  }
  
  public void onClick(View paramView)
  {
    boolean bool1 = false;
    switch (paramView.getId())
    {
    }
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      b(true);
      continue;
      if (this.jdField_a_of_type_Ayno != null) {
        this.jdField_a_of_type_Ayno.a();
      }
      aypy.a("0X800AF3C");
      continue;
      if (!bgnt.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131718205, 1).a();
        if (this.jdField_a_of_type_Aypw != null) {
          this.jdField_a_of_type_Aypw.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
        }
      }
      else
      {
        b(paramView);
        continue;
        bgxr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "panel");
        aypy.a("0X800AF42", 1);
        continue;
        if (!AppNetConnInfo.isNetSupport())
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131718205, 0).a();
          if (this.jdField_a_of_type_Aytf != null) {
            this.jdField_a_of_type_Aytf.dismiss();
          }
          a(40001);
        }
        else if (this.jdField_a_of_type_Aytf != null)
        {
          boolean bool2 = aypi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus(), ayox.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
          this.jdField_c_of_type_Boolean = bool2;
          if (QLog.isColorLevel()) {
            QLog.d("AccountPanel", 4, new Object[] { " isCurStatusSmart =", Boolean.valueOf(bool2) });
          }
          localObject1 = this.jdField_a_of_type_Aytf.a();
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          ArrayList localArrayList = this.jdField_a_of_type_Aytf.c();
          if (!bool2) {
            bool1 = true;
          }
          ayps.a((QQAppInterface)localObject2, (OnlineStatusPermissionChecker.OnlineStatusPermissionItem)localObject1, localArrayList, bool1);
          this.jdField_a_of_type_Aytf.dismiss();
          localObject1 = paramView.getTag();
          if ((localObject1 instanceof Integer))
          {
            int i = ((Integer)localObject1).intValue();
            if (i == 2)
            {
              localObject1 = this.jdField_a_of_type_Aytf.c().iterator();
              while (((Iterator)localObject1).hasNext()) {
                aypy.a("0X800AF40", ((Integer)((Iterator)localObject1).next()).intValue(), "1");
              }
            }
            if (i == 1)
            {
              localObject1 = this.jdField_a_of_type_Aytf.c().iterator();
              while (((Iterator)localObject1).hasNext()) {
                aypy.a("0X800B00F", ((Integer)((Iterator)localObject1).next()).intValue(), "1");
              }
            }
          }
          aypy.a("0X8009DE0", 40001);
          continue;
          if (bgjw.c())
          {
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131693434, 0).a();
          }
          else
          {
            localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AddAccountActivity.class);
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject1);
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(2130771997, 2130771990);
            bddx.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
            bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80072D4", "0X80072D4", 0, 0, "", "", "", "");
            aypy.a("0X800AF3B");
            continue;
            if (bgnt.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity)) {
              break;
            }
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131718205, 1).a();
          }
        }
      }
    }
    if (a())
    {
      aypy.a("0X800B0F2", 1);
      bgxr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "panel");
    }
    for (;;)
    {
      aype.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus());
      break;
      if (this.jdField_a_of_type_Long == 1040L)
      {
        aypy.a("0X800B0F2", 3);
        aysf.a.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, aysh.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), 4013);
      }
      else if (this.jdField_a_of_type_Long == 1030L)
      {
        aypy.a("0X800B0F2", 4);
        localObject1 = (aqqh)aqlk.a().a(652);
        localObject2 = ((anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if ((localObject1 != null) && (((aqqh)localObject1).a != null) && (!TextUtils.isEmpty(((aqqh)localObject1).a.jdField_a_of_type_JavaLangString)) && (aypu.a((Friends)localObject2)))
        {
          localObject1 = ((aqqh)localObject1).a.jdField_a_of_type_JavaLangString + ((Friends)localObject2).adCode;
          aysf.a.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (String)localObject1, 4013);
        }
      }
      else if ((this.jdField_a_of_type_Long >= 40001L) && (this.jdField_a_of_type_MqqAppAppRuntime$Status == AppRuntime.Status.online))
      {
        aypy.a("0X800B0F2", 2);
        b(paramView);
      }
    }
  }
  
  public boolean onKeyUp(int paramInt, @androidx.annotation.NonNull KeyEvent paramKeyEvent)
  {
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void show()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (isShowing())) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    if (ThemeUtil.isNowThemeIsNight(null, false, "")) {
      a(false, null, Color.parseColor("#FF010101"));
    }
    for (;;)
    {
      super.show();
      if (this.jdField_a_of_type_Aynp != null) {
        this.jdField_a_of_type_Aynp.a(this.jdField_a_of_type_MqqAppAppRuntime$Status);
      }
      r();
      q();
      this.jdField_a_of_type_AndroidOsHandler.post(new AccountPanel.3(this));
      Object localObject = new Intent("before_account_change");
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.sendBroadcast((Intent)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanel", 2, "show AccountPanel");
      }
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AC35", "0X800AC35", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Ayov.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      ((aypo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(370)).a(40001L, false);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.a();
      b(true);
      return;
      localObject = new ayot();
      ((ayot)localObject).jdField_a_of_type_ComTencentMobileqqAppBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      this.jdField_a_of_type_Ayos.a((ayot)localObject, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aymu
 * JD-Core Version:    0.7.0.1
 */