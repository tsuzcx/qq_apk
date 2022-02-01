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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDrawable;
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
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
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

public class ayzg
  extends azfn
  implements View.OnClickListener, azbg, azbz, azfi
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  public Handler a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ayzy(this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private anvi jdField_a_of_type_Anvi = new ayzj(this);
  private anyz jdField_a_of_type_Anyz = new ayzl(this);
  private aoef jdField_a_of_type_Aoef = new ayzk(this);
  private azaa jdField_a_of_type_Azaa;
  private azab jdField_a_of_type_Azab;
  private azbd jdField_a_of_type_Azbd = new ayzm(this);
  private azbe jdField_a_of_type_Azbe;
  private azbh jdField_a_of_type_Azbh = new azbh(true, true);
  private azby jdField_a_of_type_Azby = new ayzp(this);
  private azce jdField_a_of_type_Azce = new ayzq(this);
  private azcj jdField_a_of_type_Azcj;
  private azfk jdField_a_of_type_Azfk;
  private azfo jdField_a_of_type_Azfo;
  private azga jdField_a_of_type_Azga;
  private azgm jdField_a_of_type_Azgm = new ayzt(this);
  public bisl a;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AccountPanelRootLayout jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout;
  private ReboundHorizontalScrollView jdField_a_of_type_ComTencentMobileqqProfileViewReboundHorizontalScrollView;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private SimpleAccount jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount;
  private Runnable jdField_a_of_type_JavaLangRunnable = new AccountPanel.16(this);
  private String jdField_a_of_type_JavaLangString;
  private Observer jdField_a_of_type_JavaUtilObserver = new ayzn(this);
  private AppRuntime.Status jdField_a_of_type_MqqAppAppRuntime$Status;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new ayzo(this);
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
  
  public ayzg(@android.support.annotation.NonNull BaseActivity paramBaseActivity)
  {
    super(paramBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout = ((AccountPanelRootLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558428, null));
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.setAccountPanelRootLayoutListener(this);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout;
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131365154);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131361929);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131365191));
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131371774);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131371775));
    this.jdField_d_of_type_AndroidViewView.setOnTouchListener(new mvl());
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(Typeface.defaultFromStyle(1));
    o();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131361898));
    this.f = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131377520);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewReboundHorizontalScrollView = ((ReboundHorizontalScrollView)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131361900));
    this.jdField_a_of_type_ComTencentMobileqqProfileViewReboundHorizontalScrollView.setOverScrollDistance(AIOUtils.dp2px(48.0F, getContext().getResources()));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131372223));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131361926));
    this.e = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131369301);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131369391));
    this.jdField_a_of_type_Azbh.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidViewViewGroup, 2);
    this.jdField_a_of_type_Azbh.b().setOnClickListener(this);
    this.jdField_a_of_type_Azbh.a().setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(new mvl());
    setContentView(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    this.jdField_a_of_type_Azbe = new azbe();
    a(new float[] { 0.5F, 0.0F });
  }
  
  private int a()
  {
    int j = ((bdxs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER)).b().size();
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
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558429, null);
    localView.setTag(new ayzz(this, localView));
    localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localView.setOnTouchListener(new azci(localView.findViewById(2131363176)));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(ViewUtils.dip2px(64.0F), -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams);
    return localView;
  }
  
  private ayzz a(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
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
        if (!paramString.equals((String)localView.getTag(2131361927))) {}
      }
    }
    for (paramString = localView;; paramString = null)
    {
      if (paramString != null) {}
      for (paramString = (ayzz)paramString.getTag();; paramString = null)
      {
        return paramString;
        i += 1;
        break;
      }
    }
  }
  
  private void a(ayzz paramayzz, SubAccountInfo paramSubAccountInfo, View paramView)
  {
    paramayzz.a(2);
    paramayzz.a(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramSubAccountInfo.subuin));
    paramayzz.a(ContactUtils.getBuddyName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSubAccountInfo.subuin, false));
    bdxo localbdxo = bdxj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSubAccountInfo.subuin);
    if ((localbdxo.jdField_a_of_type_Int > 0) && (paramSubAccountInfo.status == 1))
    {
      paramayzz.a(localbdxo.jdField_a_of_type_Int, localbdxo.jdField_a_of_type_Boolean);
      paramayzz.a(true);
      if (paramSubAccountInfo.status == 1) {
        break label127;
      }
      paramayzz.b(true);
    }
    for (;;)
    {
      paramView.setTag(2131361927, paramSubAccountInfo.subuin);
      paramView.setTag(2131361897, paramSubAccountInfo);
      return;
      paramayzz.a(0, false);
      break;
      label127:
      paramayzz.b(false);
    }
  }
  
  private void a(ayzz paramayzz, SimpleAccount paramSimpleAccount, View paramView)
  {
    paramayzz.a(1);
    paramayzz.a(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramSimpleAccount.getUin()));
    paramayzz.a(bdxj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSimpleAccount));
    paramayzz.a(bdxj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSimpleAccount.getUin()), false);
    paramayzz.a(false);
    paramayzz.b(false);
    paramView.setTag(2131361927, paramSimpleAccount.getUin());
    paramView.setTag(2131361897, paramSimpleAccount);
    paramView.setTag(paramayzz);
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
          paramString.ay_();
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
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    String str1 = azbj.a().a(paramLong, paramStatus);
    str1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131698164, new Object[] { str1 });
    String str2 = ((azaz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AUTO_REPLY_MANAGER)).a().mRawText;
    Object localObject1 = new Paint();
    ((Paint)localObject1).setTextSize(ViewUtils.spToPx(14.0F));
    int i;
    if ((paramLong == 1000L) || (paramLong == 1028L))
    {
      if (paramLong == 1000L) {}
      for (i = 2131698159;; i = 2131698155)
      {
        str2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(i);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setTitle(str1).setMessageWithoutAutoLink(new QQText(str2, 3, 16)).setMessageMaxLine(4);
        if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131698162, new ayzw(this, paramStatus, paramLong));
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131698150, new ayzx(this));
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        return;
      }
    }
    int j;
    if (paramStatus == AppRuntime.Status.dnd)
    {
      j = 2131698153;
      i = 4;
    }
    for (;;)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(j);
      str2 = com.tencent.mobileqq.text.TextUtils.subQQTextString(str2, (Paint)localObject1, 3, 16, (int)(AIOUtils.dp2px(i * 242, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources()) - ((Paint)localObject1).measureText((String)localObject2)), true);
      str2 = AutoReplyText.trimRawString(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(j, new Object[] { str2 }), true);
      localObject1 = new SpannableString(str2);
      localObject2 = new ayzu(this, paramStatus, paramLong);
      ((SpannableString)localObject1).setSpan(localObject2, str2.length() - 7, str2.length(), 33);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setTitle(str1).setMessageWithoutAutoLink(new QQText((CharSequence)localObject1, 3, 16)).setMessageMaxLine(i);
      if (!AppSetting.jdField_c_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getMessageTextView().setAccessibilityDelegate(new ayzv(this, (ClickableSpan)localObject2));
      break;
      i = 3;
      j = 2131698163;
    }
  }
  
  private void a(AppRuntime.Status paramStatus, long paramLong, boolean paramBoolean)
  {
    if (paramStatus != null)
    {
      this.jdField_a_of_type_MqqAppAppRuntime$Status = paramStatus;
      this.jdField_a_of_type_Long = paramLong;
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.updateOnlineStatus(paramStatus, paramLong);
      }
      this.jdField_a_of_type_Azbh.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_Azcj != null) {
        this.jdField_a_of_type_Azcj.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
      }
      if (this.jdField_a_of_type_Azab != null) {
        this.jdField_a_of_type_Azab.a(paramStatus);
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
    azbu localazbu = azbj.a().a(localStatus, this.jdField_a_of_type_Long);
    Friends localFriends = ((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    azbj localazbj = azbj.a();
    if (localazbu.jdField_a_of_type_Long > 0L)
    {
      bool = true;
      if ((localazbj.a(localazbu, localFriends, bool)) || (localStatus != AppRuntime.Status.online)) {
        break label125;
      }
    }
    label125:
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
  
  private boolean a(azbu paramazbu, AppRuntime.Status paramStatus)
  {
    if ((paramStatus == AppRuntime.Status.online) && (this.jdField_a_of_type_MqqAppAppRuntime$Status == AppRuntime.Status.online)) {
      if (this.jdField_a_of_type_Long != paramazbu.jdField_a_of_type_Long) {}
    }
    while (this.jdField_a_of_type_MqqAppAppRuntime$Status == paramStatus)
    {
      return true;
      return false;
    }
    return false;
  }
  
  private boolean a(String paramString, bdxt parambdxt)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (parambdxt == null) || (android.text.TextUtils.isEmpty(paramString));
  }
  
  private boolean a(boolean paramBoolean, String paramString, bdxu parambdxu)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (parambdxu == null) || (android.text.TextUtils.isEmpty(paramString)))
    {
      QLog.d("AccountPanel", 1, String.format("onGetSubAccountMsg return, isSuccess: %s, mainAccount: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
      return true;
    }
    if (!android.text.TextUtils.equals(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      QLog.d("AccountPanel", 1, String.format("onGetSubAccountMsg return, mainAccount: %s not equal", new Object[] { paramString }));
      return true;
    }
    return false;
  }
  
  private void b(View paramView)
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131718971, 1).a();
      return;
    }
    if (a())
    {
      azcl.a("0X800B0F2", 1);
      bhmz.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "panel");
    }
    for (;;)
    {
      azbq.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus());
      return;
      if (this.jdField_a_of_type_Long == 1040L)
      {
        azcl.a("0X800B0F2", 3);
        azes.a.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, azeu.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), 4013);
      }
      else if (this.jdField_a_of_type_Long == 1030L)
      {
        azcl.a("0X800B0F2", 4);
        paramView = (arci)aqxe.a().a(652);
        Friends localFriends = ((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if ((paramView != null) && (paramView.a != null) && (!android.text.TextUtils.isEmpty(paramView.a.jdField_a_of_type_JavaLangString)) && (azch.a(localFriends)))
        {
          paramView = paramView.a.jdField_a_of_type_JavaLangString + localFriends.adCode;
          azes.a.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView, 4013);
        }
      }
      else if ((this.jdField_a_of_type_Long >= 40001L) && (this.jdField_a_of_type_MqqAppAppRuntime$Status == AppRuntime.Status.online))
      {
        azcl.a("0X800B0F2", 2);
        c(paramView);
      }
    }
  }
  
  private void b(String paramString)
  {
    ayzz localayzz = a(paramString);
    if (localayzz != null)
    {
      paramString = bdxj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      localayzz.a(paramString.jdField_a_of_type_Int, paramString.jdField_a_of_type_Boolean);
    }
  }
  
  private void b(List<Object> paramList)
  {
    int i = 0;
    if (i < paramList.size())
    {
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      ayzz localayzz = (ayzz)localView.getTag();
      Object localObject = paramList.get(i);
      if ((localObject instanceof SubAccountInfo)) {
        a(localayzz, (SubAccountInfo)localObject, localView);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof SimpleAccount)) {
          a(localayzz, (SimpleAccount)localObject, localView);
        }
      }
    }
  }
  
  private void c(View paramView)
  {
    if (this.jdField_a_of_type_Azfk == null)
    {
      this.jdField_a_of_type_Azfk = new azfk(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Azbe);
      this.jdField_a_of_type_Azfk.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_Azfk.jdField_a_of_type_Int = 1;
    }
    this.jdField_a_of_type_Azfk.a(azch.a(paramView));
    if (Build.VERSION.SDK_INT >= 23) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.requestPermissions(new ayzh(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    }
    for (;;)
    {
      azcl.a("0X800AF3E", 1);
      return;
      this.jdField_a_of_type_Azfk.a(null);
      this.jdField_a_of_type_Azfk.show();
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anvi);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aoef);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anyz);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Azbd);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Azce);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Azgm);
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Azby);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade() != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanel", 2, "removeObservers");
      }
    }
  }
  
  private void n()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatusNonSync();
    long l = azbj.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject3 = ((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    azbu localazbu = azbj.a().a((AppRuntime.Status)localObject1, l);
    Object localObject4 = azbj.a().a(localazbu);
    Object localObject2;
    boolean bool;
    if (localObject1 == AppRuntime.Status.online)
    {
      localObject2 = azbj.a();
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localazbu.jdField_a_of_type_Long > 0L)
      {
        bool = true;
        localObject2 = ((azbj)localObject2).a(localQQAppInterface, (Friends)localObject3, localTextView, 3, localazbu, Boolean.valueOf(bool));
        label125:
        if (localObject4 != AppRuntime.Status.online) {
          break label325;
        }
        localObject4 = azbj.a();
        if (localazbu.jdField_a_of_type_Long <= 0L) {
          break label319;
        }
        bool = true;
        label151:
        if (((azbj)localObject4).a(localazbu, (Friends)localObject3, bool)) {
          break label325;
        }
        localObject3 = azbj.a().a(0L, AppRuntime.Status.online, 1, (Friends)localObject3);
        label180:
        if ((l != 1030L) && (l != 1040L) && (!a())) {
          break label360;
        }
        if (!blfw.a()) {
          break label342;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130841493);
        label224:
        int i = AIOUtils.dp2px(16.0F, BaseApplicationImpl.getContext().getResources());
        ((Drawable)localObject1).setBounds(0, 0, i, i);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.dp2px(0.0F, getContext().getResources()));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject3, null, (Drawable)localObject1, null);
      return;
      bool = false;
      break;
      localObject2 = azbj.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localazbu, (AppRuntime.Status)localObject4, (Friends)localObject3, this.jdField_a_of_type_AndroidWidgetTextView, 3);
      break label125;
      label319:
      bool = false;
      break label151;
      label325:
      localObject3 = azbj.a().a(l, (AppRuntime.Status)localObject1, 1, (Friends)localObject3);
      break label180;
      label342:
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839336);
      break label224;
      label360:
      localObject1 = null;
    }
  }
  
  private void o()
  {
    if (blfw.a())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#d8d8d8"));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
  }
  
  private void p()
  {
    Object localObject1 = new ArrayList();
    ArrayList localArrayList1 = ((bdxs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER)).b();
    ArrayList localArrayList2 = new ArrayList();
    if ((localArrayList1 != null) && (localArrayList1.size() > 0))
    {
      localObject2 = localArrayList1.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (SubAccountInfo)((Iterator)localObject2).next();
        if ((localObject3 != null) && (!android.text.TextUtils.isEmpty(((SubAccountInfo)localObject3).subuin)))
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
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    }
    label256:
    label281:
    label294:
    label681:
    label689:
    for (;;)
    {
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
            break label626;
          }
          i = ((List)localObject2).size();
          if (localArrayList1 == null) {
            break label631;
          }
          j = localArrayList1.size();
          QLog.d("AccountPanel", 2, String.format("prepareContentViews, account size: %s, sub account size: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
        }
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0) {
          break label636;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698148);
        label345:
        localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqProfileViewReboundHorizontalScrollView.getLayoutParams();
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() >= 7) {
          break label649;
        }
        this.e.setVisibility(0);
        this.e.setOnClickListener(this);
        this.e.setOnTouchListener(new mvl());
        ((RelativeLayout.LayoutParams)localObject1).addRule(0, this.e.getId());
        boolean bool = azch.a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount(), this.jdField_a_of_type_AndroidWidgetLinearLayout.getResources());
        if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
          break label674;
        }
        i = 2130841491;
        label446:
        localObject1 = this.f;
        if (!bool) {
          break label681;
        }
        label456:
        ((View)localObject1).setBackgroundResource(i);
        azbh.a(this.jdField_c_of_type_AndroidViewView, false, null, true);
        azbh.a(this.jdField_d_of_type_AndroidViewView, false, null, true);
        return;
      }
      SimpleAccount localSimpleAccount = (SimpleAccount)((Iterator)localObject3).next();
      if ((!android.text.TextUtils.isEmpty(localSimpleAccount.getUin())) && (!localSimpleAccount.getUin().equals(str1)))
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
            break label689;
          }
          ((List)localObject1).add(localSimpleAccount);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("AccountPanel", 2, String.format("prepareContentViews, add account uin: %s", new Object[] { localSimpleAccount.getUin() }));
          break;
          QLog.d("AccountPanel", 1, "localAccountList is empty");
          break label256;
          label626:
          i = 0;
          break label281;
          label631:
          j = 0;
          break label294;
          label636:
          this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698149);
          break label345;
          this.e.setVisibility(8);
          ((RelativeLayout.LayoutParams)localObject1).addRule(0, this.jdField_a_of_type_AndroidWidgetImageView.getId());
          break label412;
          i = 2130841490;
          break label446;
          i = 0;
          break label456;
        }
      }
    }
  }
  
  private void q()
  {
    p();
    if (this.jdField_a_of_type_Azcj == null)
    {
      this.jdField_a_of_type_Azcj = new azcj(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_b_of_type_AndroidWidgetLinearLayout, this, 3, 1);
      this.jdField_a_of_type_Azcj.a();
    }
    for (;;)
    {
      c();
      return;
      this.jdField_a_of_type_Azcj.a(true, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anvi);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aoef);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anyz);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Azbd);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Azce);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Azgm);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade() != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addObserver(this.jdField_a_of_type_JavaUtilObserver);
      }
      bhmx.a().a(this.jdField_a_of_type_JavaLangRunnable);
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessObserver(1).contains(this.jdField_a_of_type_Azby)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Azby);
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
        String str = (String)((View)localObject).getTag(2131361927);
        if ((!android.text.TextUtils.isEmpty(str)) && ((((View)localObject).getTag() instanceof ayzz)))
        {
          localObject = (ayzz)((View)localObject).getTag();
          if (((ayzz)localObject).jdField_a_of_type_Int == 1) {
            ((ayzz)localObject).a(bdxj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str), false);
          }
        }
        i += 1;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Azcj != null) {
      this.jdField_a_of_type_Azcj.c();
    }
    o();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Azcj != null) {
      this.jdField_a_of_type_Azcj.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
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
      if ((paramInt1 == 1001) && (this.jdField_a_of_type_Azfo != null))
      {
        this.jdField_a_of_type_Azfo.a(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent);
        n();
        return;
      }
      if ((paramInt1 == 999) && (this.jdField_a_of_type_Azfk != null))
      {
        this.jdField_a_of_type_Azfk.a(paramInt1, paramInt2, paramIntent);
        return;
      }
      if ((paramInt1 == 998) && (this.jdField_a_of_type_Azga != null))
      {
        this.jdField_a_of_type_Azga.a(paramInt1, paramInt2, paramIntent);
        return;
      }
    } while ((paramInt1 != 299) && (paramInt1 != 234));
    c();
  }
  
  public void a(View paramView)
  {
    b(true);
  }
  
  public void a(azaa paramazaa)
  {
    this.jdField_a_of_type_Azaa = paramazaa;
  }
  
  public void a(azab paramazab)
  {
    this.jdField_a_of_type_Azab = paramazab;
  }
  
  public void a(azbu paramazbu1, azbu paramazbu2, View paramView)
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131718971, 1).a();
      if (this.jdField_a_of_type_Azcj != null)
      {
        this.jdField_a_of_type_Azbh.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
        this.jdField_a_of_type_Azcj.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
      }
    }
    for (;;)
    {
      return;
      AppRuntime.Status localStatus = azbj.a().a(paramazbu2);
      paramazbu1 = azbj.a().a(paramazbu1);
      if ((localStatus != null) && (paramazbu2 != null))
      {
        if (paramazbu2.jdField_a_of_type_Long == 1040L)
        {
          if (this.jdField_a_of_type_Azfo == null)
          {
            this.jdField_a_of_type_Azfo = new azfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Azbe, this);
            this.jdField_a_of_type_Azfo.a(azch.a(paramView));
          }
          this.jdField_a_of_type_Azfo.show();
          return;
        }
        if (paramazbu2.jdField_a_of_type_Long == 1030L)
        {
          if (this.jdField_a_of_type_Azga == null)
          {
            this.jdField_a_of_type_Azga = new azga(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Azbe, this);
            this.jdField_a_of_type_Azga.a(azch.a(paramView));
          }
          if (Build.VERSION.SDK_INT >= 23)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.requestPermissions(new ayzr(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
            return;
          }
          ((azbv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ONLINE_STATUS_MANAGER)).a(9);
          this.jdField_a_of_type_Azga.show();
          return;
        }
      }
      if ((localStatus != null) && (paramazbu2 != null) && (!a(paramazbu2, localStatus)))
      {
        azbq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localStatus, paramazbu2.jdField_a_of_type_Long);
        paramView = BaseApplicationImpl.getContext().getSharedPreferences("online_battery", 0);
        boolean bool = paramView.getBoolean("has_set_battery", false);
        if ((azbj.a().a(paramazbu2)) && (!bool))
        {
          paramView.edit().putBoolean("has_set_battery", true).apply();
          a(localStatus, paramazbu2.jdField_a_of_type_Long);
        }
        while (QLog.isColorLevel())
        {
          QLog.d("AccountPanel", 2, String.format("onOnlineStatusChanged, %s -> %s, %d", new Object[] { paramazbu1, localStatus, Long.valueOf(paramazbu2.jdField_a_of_type_Long) }));
          return;
          if (azbo.a(localStatus))
          {
            a(localStatus, paramazbu2.jdField_a_of_type_Long);
          }
          else if ((paramazbu2.jdField_a_of_type_Long == 1028L) && (!azfe.a()))
          {
            azfe.a();
            a(localStatus, paramazbu2.jdField_a_of_type_Long);
          }
          else
          {
            a(localStatus, paramazbu2.jdField_a_of_type_Long, true);
          }
        }
      }
    }
  }
  
  public void a(SimpleAccount paramSimpleAccount)
  {
    if (!NetworkUtil.isNetSupportHw(BaseApplication.getContext()))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692125), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
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
    bdxi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    AlbumUtil.clearLastAlbumInfo();
  }
  
  public void a(SimpleAccount paramSimpleAccount, QQAppInterface paramQQAppInterface)
  {
    bdxo localbdxo = bdxj.a(paramQQAppInterface, paramSimpleAccount.getUin());
    if ((localbdxo.jdField_a_of_type_Int <= 0) || (localbdxo.jdField_a_of_type_Boolean)) {
      a(paramSimpleAccount);
    }
    for (;;)
    {
      if (localbdxo.jdField_a_of_type_Int > 0) {
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
    paramArrayOfInt[1] = AIOUtils.dp2px(554.0F, this.jdField_b_of_type_AndroidViewView.getResources());
  }
  
  public boolean a(SimpleAccount paramSimpleAccount, QQAppInterface paramQQAppInterface)
  {
    if ((paramSimpleAccount != null) && (bdxj.a(paramQQAppInterface, paramSimpleAccount)))
    {
      a(paramSimpleAccount);
      return true;
    }
    return false;
  }
  
  public void ay_()
  {
    try
    {
      b(false);
      if (this.jdField_a_of_type_Azfo != null) {
        this.jdField_a_of_type_Azfo.m();
      }
      if (this.jdField_a_of_type_Azga != null) {
        this.jdField_a_of_type_Azga.m();
      }
      if (this.jdField_a_of_type_Azfk != null) {
        this.jdField_a_of_type_Azfk.m();
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
    this.jdField_a_of_type_Azbh.a();
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
    this.jdField_a_of_type_Long = azbj.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Azbh.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
    if (this.jdField_a_of_type_Azcj != null) {
      this.jdField_a_of_type_Azcj.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
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
    if (this.jdField_a_of_type_Bisl == null)
    {
      this.jdField_a_of_type_Bisl = new bisl(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      this.jdField_a_of_type_Bisl.c(true);
    }
    this.jdField_a_of_type_Bisl.c(2131694477);
    if ((this.jdField_a_of_type_Bisl != null) && (!this.jdField_a_of_type_Bisl.isShowing()) && (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())) {
      this.jdField_a_of_type_Bisl.show();
    }
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bisl.dismiss();
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
    this.jdField_a_of_type_Azga = null;
    this.jdField_a_of_type_Azfo = null;
    this.jdField_a_of_type_Azfk = null;
    b(false);
    bdxi.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    }
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "onAccoutChangeFailed");
    }
    this.jdField_a_of_type_Azga = null;
    this.jdField_a_of_type_Azfo = null;
    this.jdField_a_of_type_Azfk = null;
    j();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      QQCustomDialog localQQCustomDialog = bhdj.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setTitle(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719052)).setMessage(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719051));
      localQQCustomDialog.setPositiveButton(2131691037, new ayzi(this));
      localQQCustomDialog.setCancelable(true);
      localQQCustomDialog.show();
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
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      b(true);
      continue;
      if (this.jdField_a_of_type_Azaa != null) {
        this.jdField_a_of_type_Azaa.a();
      }
      azcl.a("0X800AF3C");
      continue;
      if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131718971, 1).a();
        if (this.jdField_a_of_type_Azcj != null) {
          this.jdField_a_of_type_Azcj.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
        }
      }
      else
      {
        c(paramView);
        continue;
        bhmz.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "panel");
        azcl.a("0X800AF42", 1);
        continue;
        if (!AppNetConnInfo.isNetSupport())
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131718971, 0).a();
          if (this.jdField_a_of_type_Azfk != null) {
            this.jdField_a_of_type_Azfk.dismiss();
          }
          a(40001);
        }
        else if (this.jdField_a_of_type_Azfk != null)
        {
          boolean bool2 = azbu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus(), azbj.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
          this.jdField_c_of_type_Boolean = bool2;
          if (QLog.isColorLevel()) {
            QLog.d("AccountPanel", 4, new Object[] { " isCurStatusSmart =", Boolean.valueOf(bool2) });
          }
          Object localObject = this.jdField_a_of_type_Azfk.a();
          QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          ArrayList localArrayList = this.jdField_a_of_type_Azfk.c();
          if (!bool2) {
            bool1 = true;
          }
          azcf.a(localQQAppInterface, (OnlineStatusPermissionChecker.OnlineStatusPermissionItem)localObject, localArrayList, bool1);
          this.jdField_a_of_type_Azfk.dismiss();
          localObject = paramView.getTag();
          if ((localObject instanceof Integer))
          {
            int i = ((Integer)localObject).intValue();
            if (i == 2)
            {
              localObject = this.jdField_a_of_type_Azfk.c().iterator();
              while (((Iterator)localObject).hasNext()) {
                azcl.a("0X800AF40", ((Integer)((Iterator)localObject).next()).intValue(), "1");
              }
            }
            if (i == 1)
            {
              localObject = this.jdField_a_of_type_Azfk.c().iterator();
              while (((Iterator)localObject).hasNext()) {
                azcl.a("0X800B00F", ((Integer)((Iterator)localObject).next()).intValue(), "1");
              }
            }
          }
          azcl.a("0X8009DE0", 40001);
          continue;
          if (bhbx.c())
          {
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131693722, 0).a();
          }
          else
          {
            localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AddAccountActivity.class);
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(2130771997, 2130771990);
            bdxi.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
            bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80072D4", "0X80072D4", 0, 0, "", "", "", "");
            azcl.a("0X800AF3B");
            continue;
            b(paramView);
          }
        }
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
      if (this.jdField_a_of_type_Azab != null) {
        this.jdField_a_of_type_Azab.a(this.jdField_a_of_type_MqqAppAppRuntime$Status);
      }
      r();
      q();
      this.jdField_a_of_type_AndroidOsHandler.post(new AccountPanel.3(this));
      Object localObject = new Intent("before_account_change");
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.sendBroadcast((Intent)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanel", 2, "show AccountPanel");
      }
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AC35", "0X800AC35", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Azbh.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      ((azcb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ONLINE_STATUS_PERMISSION_MANAGER)).a(40001L, false);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.a();
      b(true);
      return;
      localObject = new azbf();
      ((azbf)localObject).jdField_a_of_type_ComTencentMobileqqAppBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      this.jdField_a_of_type_Azbe.a((azbf)localObject, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayzg
 * JD-Core Version:    0.7.0.1
 */