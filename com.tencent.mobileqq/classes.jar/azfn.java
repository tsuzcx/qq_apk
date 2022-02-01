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

public class azfn
  extends azlt
  implements View.OnClickListener, azhn, azif, azlo
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  public Handler a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new azgf(this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private anyu jdField_a_of_type_Anyu = new azfq(this);
  private aocj jdField_a_of_type_Aocj = new azfs(this);
  private aoib jdField_a_of_type_Aoib = new azfr(this);
  private azgh jdField_a_of_type_Azgh;
  private azgi jdField_a_of_type_Azgi;
  private azhk jdField_a_of_type_Azhk = new azft(this);
  private azhl jdField_a_of_type_Azhl;
  private azho jdField_a_of_type_Azho = new azho(true, true);
  private azie jdField_a_of_type_Azie = new azfw(this);
  private azik jdField_a_of_type_Azik = new azfx(this);
  private azip jdField_a_of_type_Azip;
  private azlq jdField_a_of_type_Azlq;
  private azlu jdField_a_of_type_Azlu;
  private azmg jdField_a_of_type_Azmg;
  private azms jdField_a_of_type_Azms = new azga(this);
  private bhpc jdField_a_of_type_Bhpc;
  public bjbs a;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AccountPanelRootLayout jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout;
  private ReboundHorizontalScrollView jdField_a_of_type_ComTencentMobileqqProfileViewReboundHorizontalScrollView;
  private SimpleAccount jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount;
  private Runnable jdField_a_of_type_JavaLangRunnable = new AccountPanel.16(this);
  private String jdField_a_of_type_JavaLangString;
  private Observer jdField_a_of_type_JavaUtilObserver = new azfu(this);
  private AppRuntime.Status jdField_a_of_type_MqqAppAppRuntime$Status;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new azfv(this);
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
  
  public azfn(@android.support.annotation.NonNull BaseActivity paramBaseActivity)
  {
    super(paramBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout = ((AccountPanelRootLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558427, null));
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.setAccountPanelRootLayoutListener(this);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout;
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131365043);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131361927);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131365079));
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131371618);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131371619));
    this.jdField_d_of_type_AndroidViewView.setOnTouchListener(new mve());
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(Typeface.defaultFromStyle(1));
    o();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131361896));
    this.f = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131377484);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewReboundHorizontalScrollView = ((ReboundHorizontalScrollView)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131361898));
    this.jdField_a_of_type_ComTencentMobileqqProfileViewReboundHorizontalScrollView.setOverScrollDistance(agej.a(48.0F, getContext().getResources()));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131372066));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131361924));
    this.e = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131369112);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131369205));
    this.jdField_a_of_type_Azho.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidViewViewGroup, 2);
    this.jdField_a_of_type_Azho.b().setOnClickListener(this);
    this.jdField_a_of_type_Azho.a().setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(new mve());
    setContentView(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    this.jdField_a_of_type_Azhl = new azhl();
    a(new float[] { 0.5F, 0.0F });
  }
  
  private int a()
  {
    int j = ((bdxc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(61)).b().size();
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
    localView.setTag(new azgg(this, localView));
    localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localView.setOnTouchListener(new azio(localView.findViewById(2131363141)));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(bhtq.a(64.0F), -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams);
    return localView;
  }
  
  private azgg a(String paramString)
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
      for (paramString = (azgg)paramString.getTag();; paramString = null)
      {
        return paramString;
        i += 1;
        break;
      }
    }
  }
  
  private void a(azgg paramazgg, SubAccountInfo paramSubAccountInfo, View paramView)
  {
    paramazgg.a(2);
    paramazgg.a(aoot.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramSubAccountInfo.subuin));
    paramazgg.a(bhlg.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSubAccountInfo.subuin, false));
    bdwy localbdwy = bdwt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSubAccountInfo.subuin);
    if ((localbdwy.jdField_a_of_type_Int > 0) && (paramSubAccountInfo.status == 1))
    {
      paramazgg.a(localbdwy.jdField_a_of_type_Int, localbdwy.jdField_a_of_type_Boolean);
      paramazgg.a(true);
      if (paramSubAccountInfo.status == 1) {
        break label127;
      }
      paramazgg.b(true);
    }
    for (;;)
    {
      paramView.setTag(2131361925, paramSubAccountInfo.subuin);
      paramView.setTag(2131361895, paramSubAccountInfo);
      return;
      paramazgg.a(0, false);
      break;
      label127:
      paramazgg.b(false);
    }
  }
  
  private void a(azgg paramazgg, SimpleAccount paramSimpleAccount, View paramView)
  {
    paramazgg.a(1);
    paramazgg.a(aoot.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramSimpleAccount.getUin()));
    paramazgg.a(bdwt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSimpleAccount));
    paramazgg.a(bdwt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSimpleAccount.getUin()), false);
    paramazgg.a(false);
    paramazgg.b(false);
    paramView.setTag(2131361925, paramSimpleAccount.getUin());
    paramView.setTag(2131361895, paramSimpleAccount);
    paramView.setTag(paramazgg);
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
    if ((this.jdField_a_of_type_Bhpc != null) && (this.jdField_a_of_type_Bhpc.isShowing()))
    {
      this.jdField_a_of_type_Bhpc.dismiss();
      this.jdField_a_of_type_Bhpc = null;
    }
    String str1 = azhq.a().a(paramLong, paramStatus);
    str1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131697735, new Object[] { str1 });
    String str2 = ((azhg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(319)).a().mRawText;
    Object localObject1 = new Paint();
    ((Paint)localObject1).setTextSize(bhtq.d(14.0F));
    int i;
    if ((paramLong == 1000L) || (paramLong == 1028L))
    {
      if (paramLong == 1000L) {}
      for (i = 2131697730;; i = 2131697726)
      {
        str2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(i);
        this.jdField_a_of_type_Bhpc = bhlq.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setTitle(str1).setMessageWithoutAutoLink(new begp(str2, 3, 16)).setMessageMaxLine(4);
        if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {
          this.jdField_a_of_type_Bhpc.show();
        }
        this.jdField_a_of_type_Bhpc.setPositiveButton(2131697733, new azgd(this, paramStatus, paramLong));
        this.jdField_a_of_type_Bhpc.setNegativeButton(2131697721, new azge(this));
        this.jdField_a_of_type_Bhpc.setCancelable(false);
        this.jdField_a_of_type_Bhpc.show();
        return;
      }
    }
    int j;
    if (paramStatus == AppRuntime.Status.dnd)
    {
      j = 2131697724;
      i = 4;
    }
    for (;;)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(j);
      str2 = behh.a(str2, (Paint)localObject1, 3, 16, (int)(agej.a(i * 242, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources()) - ((Paint)localObject1).measureText((String)localObject2)), true);
      str2 = AutoReplyText.trimRawString(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(j, new Object[] { str2 }), true);
      localObject1 = new SpannableString(str2);
      localObject2 = new azgb(this, paramStatus, paramLong);
      ((SpannableString)localObject1).setSpan(localObject2, str2.length() - 7, str2.length(), 33);
      this.jdField_a_of_type_Bhpc = bhlq.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setTitle(str1).setMessageWithoutAutoLink(new begp((CharSequence)localObject1, 3, 16)).setMessageMaxLine(i);
      if (!AppSetting.jdField_c_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_Bhpc.getMessageTextView().setAccessibilityDelegate(new azgc(this, (ClickableSpan)localObject2));
      break;
      i = 3;
      j = 2131697734;
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
      this.jdField_a_of_type_Azho.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_Azip != null) {
        this.jdField_a_of_type_Azip.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
      }
      if (this.jdField_a_of_type_Azgi != null) {
        this.jdField_a_of_type_Azgi.a(paramStatus);
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
    azib localazib = azhq.a().a(localStatus, this.jdField_a_of_type_Long);
    Friends localFriends = ((anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    azhq localazhq = azhq.a();
    if (localazib.jdField_a_of_type_Long > 0L)
    {
      bool = true;
      if ((localazhq.a(localazib, localFriends, bool)) || (localStatus != AppRuntime.Status.online)) {
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
  
  private boolean a(azib paramazib, AppRuntime.Status paramStatus)
  {
    if ((paramStatus == AppRuntime.Status.online) && (this.jdField_a_of_type_MqqAppAppRuntime$Status == AppRuntime.Status.online)) {
      if (this.jdField_a_of_type_Long != paramazib.jdField_a_of_type_Long) {}
    }
    while (this.jdField_a_of_type_MqqAppAppRuntime$Status == paramStatus)
    {
      return true;
      return false;
    }
    return false;
  }
  
  private boolean a(String paramString, bdxd parambdxd)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (parambdxd == null) || (TextUtils.isEmpty(paramString));
  }
  
  private boolean a(boolean paramBoolean, String paramString, bdxe parambdxe)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (parambdxe == null) || (TextUtils.isEmpty(paramString)))
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
    if (!bhnv.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131718340, 1).a();
      return;
    }
    if (a())
    {
      azir.a("0X800B0F2", 1);
      bhxv.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "panel");
    }
    for (;;)
    {
      azhx.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus());
      return;
      if (this.jdField_a_of_type_Long == 1040L)
      {
        azir.a("0X800B0F2", 3);
        azky.a.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, azla.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), 4013);
      }
      else if (this.jdField_a_of_type_Long == 1030L)
      {
        azir.a("0X800B0F2", 4);
        paramView = (arfp)aran.a().a(652);
        Friends localFriends = ((anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if ((paramView != null) && (paramView.a != null) && (!TextUtils.isEmpty(paramView.a.jdField_a_of_type_JavaLangString)) && (azin.a(localFriends)))
        {
          paramView = paramView.a.jdField_a_of_type_JavaLangString + localFriends.adCode;
          azky.a.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView, 4013);
        }
      }
      else if ((this.jdField_a_of_type_Long >= 40001L) && (this.jdField_a_of_type_MqqAppAppRuntime$Status == AppRuntime.Status.online))
      {
        azir.a("0X800B0F2", 2);
        c(paramView);
      }
    }
  }
  
  private void b(String paramString)
  {
    azgg localazgg = a(paramString);
    if (localazgg != null)
    {
      paramString = bdwt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      localazgg.a(paramString.jdField_a_of_type_Int, paramString.jdField_a_of_type_Boolean);
    }
  }
  
  private void b(List<Object> paramList)
  {
    int i = 0;
    if (i < paramList.size())
    {
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      azgg localazgg = (azgg)localView.getTag();
      Object localObject = paramList.get(i);
      if ((localObject instanceof SubAccountInfo)) {
        a(localazgg, (SubAccountInfo)localObject, localView);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof SimpleAccount)) {
          a(localazgg, (SimpleAccount)localObject, localView);
        }
      }
    }
  }
  
  private void c(View paramView)
  {
    if (this.jdField_a_of_type_Azlq == null)
    {
      this.jdField_a_of_type_Azlq = new azlq(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Azhl);
      this.jdField_a_of_type_Azlq.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_Azlq.jdField_a_of_type_Int = 1;
    }
    this.jdField_a_of_type_Azlq.a(azin.a(paramView));
    if (Build.VERSION.SDK_INT >= 23) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.requestPermissions(new azfo(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    }
    for (;;)
    {
      azir.a("0X800AF3E", 1);
      return;
      this.jdField_a_of_type_Azlq.a(null);
      this.jdField_a_of_type_Azlq.show();
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anyu);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aoib);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aocj);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Azhk);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Azik);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Azms);
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Azie);
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
    long l = azhq.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject3 = ((anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    azib localazib = azhq.a().a((AppRuntime.Status)localObject1, l);
    Object localObject4 = azhq.a().a(localazib);
    Object localObject2;
    boolean bool;
    if (localObject1 == AppRuntime.Status.online)
    {
      localObject2 = azhq.a();
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localazib.jdField_a_of_type_Long > 0L)
      {
        bool = true;
        localObject2 = ((azhq)localObject2).a(localQQAppInterface, (Friends)localObject3, localTextView, 3, localazib, Boolean.valueOf(bool));
        label124:
        if (localObject4 != AppRuntime.Status.online) {
          break label324;
        }
        localObject4 = azhq.a();
        if (localazib.jdField_a_of_type_Long <= 0L) {
          break label318;
        }
        bool = true;
        label150:
        if (((azhq)localObject4).a(localazib, (Friends)localObject3, bool)) {
          break label324;
        }
        localObject3 = azhq.a().a(0L, AppRuntime.Status.online, 1, (Friends)localObject3);
        label179:
        if ((l != 1030L) && (l != 1040L) && (!a())) {
          break label359;
        }
        if (!blqj.a()) {
          break label341;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130841450);
        label223:
        int i = agej.a(16.0F, BaseApplicationImpl.getContext().getResources());
        ((Drawable)localObject1).setBounds(0, 0, i, i);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(agej.a(0.0F, getContext().getResources()));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject3, null, (Drawable)localObject1, null);
      return;
      bool = false;
      break;
      localObject2 = azhq.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localazib, (AppRuntime.Status)localObject4, (Friends)localObject3, this.jdField_a_of_type_AndroidWidgetTextView, 3);
      break label124;
      label318:
      bool = false;
      break label150;
      label324:
      localObject3 = azhq.a().a(l, (AppRuntime.Status)localObject1, 1, (Friends)localObject3);
      break label179;
      label341:
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839280);
      break label223;
      label359:
      localObject1 = null;
    }
  }
  
  private void o()
  {
    if (blqj.a())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#d8d8d8"));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
  }
  
  private void p()
  {
    Object localObject1 = new ArrayList();
    ArrayList localArrayList1 = ((bdxc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(61)).b();
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
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131697719);
        label344:
        localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqProfileViewReboundHorizontalScrollView.getLayoutParams();
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() >= 7) {
          break label648;
        }
        this.e.setVisibility(0);
        this.e.setOnClickListener(this);
        this.e.setOnTouchListener(new mve());
        ((RelativeLayout.LayoutParams)localObject1).addRule(0, this.e.getId());
        boolean bool = azin.a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount(), this.jdField_a_of_type_AndroidWidgetLinearLayout.getResources());
        if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
          break label673;
        }
        i = 2130841448;
        label445:
        localObject1 = this.f;
        if (!bool) {
          break label680;
        }
        label455:
        ((View)localObject1).setBackgroundResource(i);
        azho.a(this.jdField_c_of_type_AndroidViewView, false, null, true);
        azho.a(this.jdField_d_of_type_AndroidViewView, false, null, true);
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
          this.jdField_b_of_type_AndroidWidgetTextView.setText(2131697720);
          break label344;
          this.e.setVisibility(8);
          ((RelativeLayout.LayoutParams)localObject1).addRule(0, this.jdField_a_of_type_AndroidWidgetImageView.getId());
          break label411;
          i = 2130841447;
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
    if (this.jdField_a_of_type_Azip == null)
    {
      this.jdField_a_of_type_Azip = new azip(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_b_of_type_AndroidWidgetLinearLayout, this, 3, 1);
      this.jdField_a_of_type_Azip.a();
    }
    for (;;)
    {
      c();
      return;
      this.jdField_a_of_type_Azip.a(true, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anyu);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aoib);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aocj);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Azhk);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Azik);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Azms);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
      }
      bhxt.a().a(this.jdField_a_of_type_JavaLangRunnable);
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessObserver(1).contains(this.jdField_a_of_type_Azie)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Azie);
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
        if ((!TextUtils.isEmpty(str)) && ((((View)localObject).getTag() instanceof azgg)))
        {
          localObject = (azgg)((View)localObject).getTag();
          if (((azgg)localObject).jdField_a_of_type_Int == 1) {
            ((azgg)localObject).a(bdwt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str), false);
          }
        }
        i += 1;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Azip != null) {
      this.jdField_a_of_type_Azip.c();
    }
    o();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Azip != null) {
      this.jdField_a_of_type_Azip.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
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
      if ((paramInt1 == 1001) && (this.jdField_a_of_type_Azlu != null))
      {
        this.jdField_a_of_type_Azlu.a(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent);
        n();
        return;
      }
      if ((paramInt1 == 999) && (this.jdField_a_of_type_Azlq != null))
      {
        this.jdField_a_of_type_Azlq.a(paramInt1, paramInt2, paramIntent);
        return;
      }
      if ((paramInt1 == 998) && (this.jdField_a_of_type_Azmg != null))
      {
        this.jdField_a_of_type_Azmg.a(paramInt1, paramInt2, paramIntent);
        return;
      }
    } while ((paramInt1 != 299) && (paramInt1 != 234));
    c();
  }
  
  public void a(View paramView)
  {
    b(true);
  }
  
  public void a(azgh paramazgh)
  {
    this.jdField_a_of_type_Azgh = paramazgh;
  }
  
  public void a(azgi paramazgi)
  {
    this.jdField_a_of_type_Azgi = paramazgi;
  }
  
  public void a(azib paramazib1, azib paramazib2, View paramView)
  {
    if (!bhnv.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131718340, 1).a();
      if (this.jdField_a_of_type_Azip != null)
      {
        this.jdField_a_of_type_Azho.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
        this.jdField_a_of_type_Azip.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
      }
    }
    for (;;)
    {
      return;
      AppRuntime.Status localStatus = azhq.a().a(paramazib2);
      paramazib1 = azhq.a().a(paramazib1);
      if ((localStatus != null) && (paramazib2 != null))
      {
        if (paramazib2.jdField_a_of_type_Long == 1040L)
        {
          if (this.jdField_a_of_type_Azlu == null)
          {
            this.jdField_a_of_type_Azlu = new azlu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Azhl, this);
            this.jdField_a_of_type_Azlu.a(azin.a(paramView));
          }
          this.jdField_a_of_type_Azlu.show();
          return;
        }
        if (paramazib2.jdField_a_of_type_Long == 1030L)
        {
          if (this.jdField_a_of_type_Azmg == null)
          {
            this.jdField_a_of_type_Azmg = new azmg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Azhl, this);
            this.jdField_a_of_type_Azmg.a(azin.a(paramView));
          }
          if (Build.VERSION.SDK_INT >= 23)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.requestPermissions(new azfy(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
            return;
          }
          ((azic)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(369)).a(9);
          this.jdField_a_of_type_Azmg.show();
          return;
        }
      }
      if ((localStatus != null) && (paramazib2 != null) && (!a(paramazib2, localStatus)))
      {
        azhx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localStatus, paramazib2.jdField_a_of_type_Long);
        paramView = BaseApplicationImpl.getContext().getSharedPreferences("online_battery", 0);
        boolean bool = paramView.getBoolean("has_set_battery", false);
        if ((azhq.a().a(paramazib2)) && (!bool))
        {
          paramView.edit().putBoolean("has_set_battery", true).apply();
          a(localStatus, paramazib2.jdField_a_of_type_Long);
        }
        while (QLog.isColorLevel())
        {
          QLog.d("AccountPanel", 2, String.format("onOnlineStatusChanged, %s -> %s, %d", new Object[] { paramazib1, localStatus, Long.valueOf(paramazib2.jdField_a_of_type_Long) }));
          return;
          if (azhv.a(localStatus))
          {
            a(localStatus, paramazib2.jdField_a_of_type_Long);
          }
          else if ((paramazib2.jdField_a_of_type_Long == 1028L) && (!azlk.a()))
          {
            azlk.a();
            a(localStatus, paramazib2.jdField_a_of_type_Long);
          }
          else
          {
            a(localStatus, paramazib2.jdField_a_of_type_Long, true);
          }
        }
      }
    }
  }
  
  public void a(SimpleAccount paramSimpleAccount)
  {
    if (!bhnv.e(BaseApplication.getContext()))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691989), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
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
    bdws.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    bhkd.b();
  }
  
  public void a(SimpleAccount paramSimpleAccount, QQAppInterface paramQQAppInterface)
  {
    bdwy localbdwy = bdwt.a(paramQQAppInterface, paramSimpleAccount.getUin());
    if ((localbdwy.jdField_a_of_type_Int <= 0) || (localbdwy.jdField_a_of_type_Boolean)) {
      a(paramSimpleAccount);
    }
    for (;;)
    {
      if (localbdwy.jdField_a_of_type_Int > 0) {
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
    paramArrayOfInt[1] = agej.a(554.0F, this.jdField_b_of_type_AndroidViewView.getResources());
  }
  
  public boolean a(SimpleAccount paramSimpleAccount, QQAppInterface paramQQAppInterface)
  {
    if ((paramSimpleAccount != null) && (bdwt.a(paramQQAppInterface, paramSimpleAccount)))
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
      if (this.jdField_a_of_type_Azlu != null) {
        this.jdField_a_of_type_Azlu.m();
      }
      if (this.jdField_a_of_type_Azmg != null) {
        this.jdField_a_of_type_Azmg.m();
      }
      if (this.jdField_a_of_type_Azlq != null) {
        this.jdField_a_of_type_Azlq.m();
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
    this.jdField_a_of_type_Azho.a();
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
    this.jdField_a_of_type_Long = azhq.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Azho.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
    if (this.jdField_a_of_type_Azip != null) {
      this.jdField_a_of_type_Azip.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
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
    if (this.jdField_a_of_type_Bjbs == null)
    {
      this.jdField_a_of_type_Bjbs = new bjbs(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      this.jdField_a_of_type_Bjbs.c(true);
    }
    this.jdField_a_of_type_Bjbs.c(2131694176);
    if ((this.jdField_a_of_type_Bjbs != null) && (!this.jdField_a_of_type_Bjbs.isShowing()) && (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())) {
      this.jdField_a_of_type_Bjbs.show();
    }
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_Bjbs != null) && (this.jdField_a_of_type_Bjbs.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bjbs.dismiss();
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
    this.jdField_a_of_type_Azmg = null;
    this.jdField_a_of_type_Azlu = null;
    this.jdField_a_of_type_Azlq = null;
    b(false);
    bdws.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    }
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "onAccoutChangeFailed");
    }
    this.jdField_a_of_type_Azmg = null;
    this.jdField_a_of_type_Azlu = null;
    this.jdField_a_of_type_Azlq = null;
    j();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      bhpc localbhpc = bhlq.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setTitle(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131718415)).setMessage(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131718414));
      localbhpc.setPositiveButton(2131690912, new azfp(this));
      localbhpc.setCancelable(true);
      localbhpc.show();
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
      if (this.jdField_a_of_type_Azgh != null) {
        this.jdField_a_of_type_Azgh.a();
      }
      azir.a("0X800AF3C");
      continue;
      if (!bhnv.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131718340, 1).a();
        if (this.jdField_a_of_type_Azip != null) {
          this.jdField_a_of_type_Azip.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
        }
      }
      else
      {
        c(paramView);
        continue;
        bhxv.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "panel");
        azir.a("0X800AF42", 1);
        continue;
        if (!AppNetConnInfo.isNetSupport())
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131718340, 0).a();
          if (this.jdField_a_of_type_Azlq != null) {
            this.jdField_a_of_type_Azlq.dismiss();
          }
          a(40001);
        }
        else if (this.jdField_a_of_type_Azlq != null)
        {
          boolean bool2 = azib.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus(), azhq.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
          this.jdField_c_of_type_Boolean = bool2;
          if (QLog.isColorLevel()) {
            QLog.d("AccountPanel", 4, new Object[] { " isCurStatusSmart =", Boolean.valueOf(bool2) });
          }
          Object localObject = this.jdField_a_of_type_Azlq.a();
          QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          ArrayList localArrayList = this.jdField_a_of_type_Azlq.c();
          if (!bool2) {
            bool1 = true;
          }
          azil.a(localQQAppInterface, (OnlineStatusPermissionChecker.OnlineStatusPermissionItem)localObject, localArrayList, bool1);
          this.jdField_a_of_type_Azlq.dismiss();
          localObject = paramView.getTag();
          if ((localObject instanceof Integer))
          {
            int i = ((Integer)localObject).intValue();
            if (i == 2)
            {
              localObject = this.jdField_a_of_type_Azlq.c().iterator();
              while (((Iterator)localObject).hasNext()) {
                azir.a("0X800AF40", ((Integer)((Iterator)localObject).next()).intValue(), "1");
              }
            }
            if (i == 1)
            {
              localObject = this.jdField_a_of_type_Azlq.c().iterator();
              while (((Iterator)localObject).hasNext()) {
                azir.a("0X800B00F", ((Integer)((Iterator)localObject).next()).intValue(), "1");
              }
            }
          }
          azir.a("0X8009DE0", 40001);
          continue;
          if (bhjx.c())
          {
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131693446, 0).a();
          }
          else
          {
            localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AddAccountActivity.class);
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(2130771997, 2130771990);
            bdws.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
            bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80072D4", "0X80072D4", 0, 0, "", "", "", "");
            azir.a("0X800AF3B");
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
      if (this.jdField_a_of_type_Azgi != null) {
        this.jdField_a_of_type_Azgi.a(this.jdField_a_of_type_MqqAppAppRuntime$Status);
      }
      r();
      q();
      this.jdField_a_of_type_AndroidOsHandler.post(new AccountPanel.3(this));
      Object localObject = new Intent("before_account_change");
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.sendBroadcast((Intent)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanel", 2, "show AccountPanel");
      }
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AC35", "0X800AC35", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Azho.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      ((azih)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(370)).a(40001L, false);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.a();
      b(true);
      return;
      localObject = new azhm();
      ((azhm)localObject).jdField_a_of_type_ComTencentMobileqqAppBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      this.jdField_a_of_type_Azhl.a((azhm)localObject, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azfn
 * JD-Core Version:    0.7.0.1
 */