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

public class axsv
  extends axzb
  implements View.OnClickListener, axuv, axvn, axyw
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private amsu jdField_a_of_type_Amsu = new axsy(this);
  private amwl jdField_a_of_type_Amwl = new axta(this);
  private anbq jdField_a_of_type_Anbq = new axsz(this);
  public Handler a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new axtn(this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private axtp jdField_a_of_type_Axtp;
  private axtq jdField_a_of_type_Axtq;
  private axus jdField_a_of_type_Axus = new axtb(this);
  private axut jdField_a_of_type_Axut;
  private axuw jdField_a_of_type_Axuw = new axuw(true, true);
  private axvm jdField_a_of_type_Axvm = new axte(this);
  private axvs jdField_a_of_type_Axvs = new axtf(this);
  private axvx jdField_a_of_type_Axvx;
  private axyy jdField_a_of_type_Axyy;
  private axzc jdField_a_of_type_Axzc;
  private axzo jdField_a_of_type_Axzo;
  private ayaa jdField_a_of_type_Ayaa = new axti(this);
  public bhht a;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AccountPanelRootLayout jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout;
  private ReboundHorizontalScrollView jdField_a_of_type_ComTencentMobileqqProfileViewReboundHorizontalScrollView;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private SimpleAccount jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount;
  private Runnable jdField_a_of_type_JavaLangRunnable = new AccountPanel.16(this);
  private String jdField_a_of_type_JavaLangString;
  private Observer jdField_a_of_type_JavaUtilObserver = new axtc(this);
  private AppRuntime.Status jdField_a_of_type_MqqAppAppRuntime$Status;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new axtd(this);
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
  
  public axsv(@android.support.annotation.NonNull BaseActivity paramBaseActivity)
  {
    super(paramBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout = ((AccountPanelRootLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558427, null));
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.setAccountPanelRootLayoutListener(this);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout;
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131365070);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131361927);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131365106));
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131371586);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131371587));
    this.jdField_d_of_type_AndroidViewView.setOnTouchListener(new mun());
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(Typeface.defaultFromStyle(1));
    o();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131361896));
    this.f = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131377247);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewReboundHorizontalScrollView = ((ReboundHorizontalScrollView)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131361898));
    this.jdField_a_of_type_ComTencentMobileqqProfileViewReboundHorizontalScrollView.setOverScrollDistance(AIOUtils.dp2px(48.0F, getContext().getResources()));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131372031));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131361924));
    this.e = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131369138);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.findViewById(2131369228));
    this.jdField_a_of_type_Axuw.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidViewViewGroup, 2);
    this.jdField_a_of_type_Axuw.b().setOnClickListener(this);
    this.jdField_a_of_type_Axuw.a().setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(new mun());
    setContentView(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    this.jdField_a_of_type_Axut = new axut();
    a(new float[] { 0.5F, 0.0F });
  }
  
  private int a()
  {
    int j = ((bcqt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(61)).b().size();
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
    localView.setTag(new axto(this, localView));
    localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localView.setOnTouchListener(new axvw(localView.findViewById(2131363157)));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(ViewUtils.dip2px(64.0F), -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams);
    return localView;
  }
  
  private axto a(String paramString)
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
        if (!paramString.equals((String)localView.getTag(2131361925))) {}
      }
    }
    for (paramString = localView;; paramString = null)
    {
      if (paramString != null) {}
      for (paramString = (axto)paramString.getTag();; paramString = null)
      {
        return paramString;
        i += 1;
        break;
      }
    }
  }
  
  private void a(axto paramaxto, SubAccountInfo paramSubAccountInfo, View paramView)
  {
    paramaxto.a(2);
    paramaxto.a(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramSubAccountInfo.subuin));
    paramaxto.a(ContactUtils.getBuddyName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSubAccountInfo.subuin, false));
    bcqp localbcqp = bcqk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSubAccountInfo.subuin);
    if ((localbcqp.jdField_a_of_type_Int > 0) && (paramSubAccountInfo.status == 1))
    {
      paramaxto.a(localbcqp.jdField_a_of_type_Int, localbcqp.jdField_a_of_type_Boolean);
      paramaxto.a(true);
      if (paramSubAccountInfo.status == 1) {
        break label127;
      }
      paramaxto.b(true);
    }
    for (;;)
    {
      paramView.setTag(2131361925, paramSubAccountInfo.subuin);
      paramView.setTag(2131361895, paramSubAccountInfo);
      return;
      paramaxto.a(0, false);
      break;
      label127:
      paramaxto.b(false);
    }
  }
  
  private void a(axto paramaxto, SimpleAccount paramSimpleAccount, View paramView)
  {
    paramaxto.a(1);
    paramaxto.a(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramSimpleAccount.getUin()));
    paramaxto.a(bcqk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSimpleAccount));
    paramaxto.a(bcqk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSimpleAccount.getUin()), false);
    paramaxto.a(false);
    paramaxto.b(false);
    paramView.setTag(2131361925, paramSimpleAccount.getUin());
    paramView.setTag(2131361895, paramSimpleAccount);
    paramView.setTag(paramaxto);
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
          paramString.aw_();
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
    String str1 = axuy.a().a(paramLong, paramStatus);
    str1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131697881, new Object[] { str1 });
    String str2 = ((axuo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(319)).a().mRawText;
    Object localObject1 = new Paint();
    ((Paint)localObject1).setTextSize(ViewUtils.spToPx(14.0F));
    int i;
    if ((paramLong == 1000L) || (paramLong == 1028L))
    {
      if (paramLong == 1000L) {}
      for (i = 2131697876;; i = 2131697872)
      {
        str2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(i);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setTitle(str1).setMessageWithoutAutoLink(new QQText(str2, 3, 16)).setMessageMaxLine(4);
        if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131697879, new axtl(this, paramStatus, paramLong));
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131697867, new axtm(this));
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        return;
      }
    }
    int j;
    if (paramStatus == AppRuntime.Status.dnd)
    {
      j = 2131697870;
      i = 4;
    }
    for (;;)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(j);
      str2 = com.tencent.mobileqq.text.TextUtils.subQQTextString(str2, (Paint)localObject1, 3, 16, (int)(AIOUtils.dp2px(i * 242, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources()) - ((Paint)localObject1).measureText((String)localObject2)), true);
      str2 = AutoReplyText.trimRawString(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(j, new Object[] { str2 }), true);
      localObject1 = new SpannableString(str2);
      localObject2 = new axtj(this, paramStatus, paramLong);
      ((SpannableString)localObject1).setSpan(localObject2, str2.length() - 7, str2.length(), 33);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setTitle(str1).setMessageWithoutAutoLink(new QQText((CharSequence)localObject1, 3, 16)).setMessageMaxLine(i);
      if (!AppSetting.jdField_c_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getMessageTextView().setAccessibilityDelegate(new axtk(this, (ClickableSpan)localObject2));
      break;
      i = 3;
      j = 2131697880;
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
      this.jdField_a_of_type_Axuw.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_Axvx != null) {
        this.jdField_a_of_type_Axvx.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
      }
      if (this.jdField_a_of_type_Axtq != null) {
        this.jdField_a_of_type_Axtq.a(paramStatus);
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
    axvj localaxvj = axuy.a().a(localStatus, this.jdField_a_of_type_Long);
    Friends localFriends = ((amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    axuy localaxuy = axuy.a();
    if (localaxvj.jdField_a_of_type_Long > 0L)
    {
      bool = true;
      if ((localaxuy.a(localaxvj, localFriends, bool)) || (localStatus != AppRuntime.Status.online)) {
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
  
  private boolean a(axvj paramaxvj, AppRuntime.Status paramStatus)
  {
    if ((paramStatus == AppRuntime.Status.online) && (this.jdField_a_of_type_MqqAppAppRuntime$Status == AppRuntime.Status.online)) {
      if (this.jdField_a_of_type_Long != paramaxvj.jdField_a_of_type_Long) {}
    }
    while (this.jdField_a_of_type_MqqAppAppRuntime$Status == paramStatus)
    {
      return true;
      return false;
    }
    return false;
  }
  
  private boolean a(String paramString, bcqu parambcqu)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (parambcqu == null) || (android.text.TextUtils.isEmpty(paramString));
  }
  
  private boolean a(boolean paramBoolean, String paramString, bcqv parambcqv)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (parambcqv == null) || (android.text.TextUtils.isEmpty(paramString)))
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
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131718582, 1).a();
      return;
    }
    if (a())
    {
      axvz.a("0X800B0F2", 1);
      bgeg.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "panel");
    }
    for (;;)
    {
      axvf.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus());
      return;
      if (this.jdField_a_of_type_Long == 1040L)
      {
        axvz.a("0X800B0F2", 3);
        axyg.a.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, axyi.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), 4013);
      }
      else if (this.jdField_a_of_type_Long == 1030L)
      {
        axvz.a("0X800B0F2", 4);
        paramView = (apzf)apub.a().a(652);
        Friends localFriends = ((amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if ((paramView != null) && (paramView.a != null) && (!android.text.TextUtils.isEmpty(paramView.a.jdField_a_of_type_JavaLangString)) && (axvv.a(localFriends)))
        {
          paramView = paramView.a.jdField_a_of_type_JavaLangString + localFriends.adCode;
          axyg.a.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView, 4013);
        }
      }
      else if ((this.jdField_a_of_type_Long >= 40001L) && (this.jdField_a_of_type_MqqAppAppRuntime$Status == AppRuntime.Status.online))
      {
        axvz.a("0X800B0F2", 2);
        c(paramView);
      }
    }
  }
  
  private void b(String paramString)
  {
    axto localaxto = a(paramString);
    if (localaxto != null)
    {
      paramString = bcqk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      localaxto.a(paramString.jdField_a_of_type_Int, paramString.jdField_a_of_type_Boolean);
    }
  }
  
  private void b(List<Object> paramList)
  {
    int i = 0;
    if (i < paramList.size())
    {
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      axto localaxto = (axto)localView.getTag();
      Object localObject = paramList.get(i);
      if ((localObject instanceof SubAccountInfo)) {
        a(localaxto, (SubAccountInfo)localObject, localView);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof SimpleAccount)) {
          a(localaxto, (SimpleAccount)localObject, localView);
        }
      }
    }
  }
  
  private void c(View paramView)
  {
    if (this.jdField_a_of_type_Axyy == null)
    {
      this.jdField_a_of_type_Axyy = new axyy(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Axut);
      this.jdField_a_of_type_Axyy.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_Axyy.jdField_a_of_type_Int = 1;
    }
    this.jdField_a_of_type_Axyy.a(axvv.a(paramView));
    if (Build.VERSION.SDK_INT >= 23) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.requestPermissions(new axsw(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    }
    for (;;)
    {
      axvz.a("0X800AF3E", 1);
      return;
      this.jdField_a_of_type_Axyy.a(null);
      this.jdField_a_of_type_Axyy.show();
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amsu);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anbq);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amwl);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Axus);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Axvs);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Ayaa);
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Axvm);
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
    long l = axuy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject3 = ((amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    axvj localaxvj = axuy.a().a((AppRuntime.Status)localObject1, l);
    Object localObject4 = axuy.a().a(localaxvj);
    Object localObject2;
    boolean bool;
    if (localObject1 == AppRuntime.Status.online)
    {
      localObject2 = axuy.a();
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localaxvj.jdField_a_of_type_Long > 0L)
      {
        bool = true;
        localObject2 = ((axuy)localObject2).a(localQQAppInterface, (Friends)localObject3, localTextView, 3, localaxvj, Boolean.valueOf(bool));
        label124:
        if (localObject4 != AppRuntime.Status.online) {
          break label324;
        }
        localObject4 = axuy.a();
        if (localaxvj.jdField_a_of_type_Long <= 0L) {
          break label318;
        }
        bool = true;
        label150:
        if (((axuy)localObject4).a(localaxvj, (Friends)localObject3, bool)) {
          break label324;
        }
        localObject3 = axuy.a().a(0L, AppRuntime.Status.online, 1, (Friends)localObject3);
        label179:
        if ((l != 1030L) && (l != 1040L) && (!a())) {
          break label359;
        }
        if (!bjuk.a()) {
          break label341;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130841486);
        label223:
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
      localObject2 = axuy.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaxvj, (AppRuntime.Status)localObject4, (Friends)localObject3, this.jdField_a_of_type_AndroidWidgetTextView, 3);
      break label124;
      label318:
      bool = false;
      break label150;
      label324:
      localObject3 = axuy.a().a(l, (AppRuntime.Status)localObject1, 1, (Friends)localObject3);
      break label179;
      label341:
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839315);
      break label223;
      label359:
      localObject1 = null;
    }
  }
  
  private void o()
  {
    if (bjuk.a())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#d8d8d8"));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
  }
  
  private void p()
  {
    Object localObject1 = new ArrayList();
    ArrayList localArrayList1 = ((bcqt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(61)).b();
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
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131697865);
        label344:
        localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqProfileViewReboundHorizontalScrollView.getLayoutParams();
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() >= 7) {
          break label648;
        }
        this.e.setVisibility(0);
        this.e.setOnClickListener(this);
        this.e.setOnTouchListener(new mun());
        ((RelativeLayout.LayoutParams)localObject1).addRule(0, this.e.getId());
        boolean bool = axvv.a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount(), this.jdField_a_of_type_AndroidWidgetLinearLayout.getResources());
        if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
          break label673;
        }
        i = 2130841484;
        label445:
        localObject1 = this.f;
        if (!bool) {
          break label680;
        }
        label455:
        ((View)localObject1).setBackgroundResource(i);
        axuw.a(this.jdField_c_of_type_AndroidViewView, false, null, true);
        axuw.a(this.jdField_d_of_type_AndroidViewView, false, null, true);
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
          this.jdField_b_of_type_AndroidWidgetTextView.setText(2131697866);
          break label344;
          this.e.setVisibility(8);
          ((RelativeLayout.LayoutParams)localObject1).addRule(0, this.jdField_a_of_type_AndroidWidgetImageView.getId());
          break label411;
          i = 2130841483;
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
    if (this.jdField_a_of_type_Axvx == null)
    {
      this.jdField_a_of_type_Axvx = new axvx(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_b_of_type_AndroidWidgetLinearLayout, this, 3, 1);
      this.jdField_a_of_type_Axvx.a();
    }
    for (;;)
    {
      c();
      return;
      this.jdField_a_of_type_Axvx.a(true, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amsu);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anbq);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amwl);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Axus);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Axvs);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Ayaa);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade() != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addObserver(this.jdField_a_of_type_JavaUtilObserver);
      }
      bgee.a().a(this.jdField_a_of_type_JavaLangRunnable);
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessObserver(1).contains(this.jdField_a_of_type_Axvm)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Axvm);
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
        if ((!android.text.TextUtils.isEmpty(str)) && ((((View)localObject).getTag() instanceof axto)))
        {
          localObject = (axto)((View)localObject).getTag();
          if (((axto)localObject).jdField_a_of_type_Int == 1) {
            ((axto)localObject).a(bcqk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str), false);
          }
        }
        i += 1;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Axvx != null) {
      this.jdField_a_of_type_Axvx.c();
    }
    o();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Axvx != null) {
      this.jdField_a_of_type_Axvx.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
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
      if ((paramInt1 == 1001) && (this.jdField_a_of_type_Axzc != null))
      {
        this.jdField_a_of_type_Axzc.a(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent);
        n();
        return;
      }
      if ((paramInt1 == 999) && (this.jdField_a_of_type_Axyy != null))
      {
        this.jdField_a_of_type_Axyy.a(paramInt1, paramInt2, paramIntent);
        return;
      }
      if ((paramInt1 == 998) && (this.jdField_a_of_type_Axzo != null))
      {
        this.jdField_a_of_type_Axzo.a(paramInt1, paramInt2, paramIntent);
        return;
      }
    } while ((paramInt1 != 299) && (paramInt1 != 234));
    c();
  }
  
  public void a(View paramView)
  {
    b(true);
  }
  
  public void a(axtp paramaxtp)
  {
    this.jdField_a_of_type_Axtp = paramaxtp;
  }
  
  public void a(axtq paramaxtq)
  {
    this.jdField_a_of_type_Axtq = paramaxtq;
  }
  
  public void a(axvj paramaxvj1, axvj paramaxvj2, View paramView)
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131718582, 1).a();
      if (this.jdField_a_of_type_Axvx != null)
      {
        this.jdField_a_of_type_Axuw.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
        this.jdField_a_of_type_Axvx.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
      }
    }
    for (;;)
    {
      return;
      AppRuntime.Status localStatus = axuy.a().a(paramaxvj2);
      paramaxvj1 = axuy.a().a(paramaxvj1);
      if ((localStatus != null) && (paramaxvj2 != null))
      {
        if (paramaxvj2.jdField_a_of_type_Long == 1040L)
        {
          if (this.jdField_a_of_type_Axzc == null)
          {
            this.jdField_a_of_type_Axzc = new axzc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Axut, this);
            this.jdField_a_of_type_Axzc.a(axvv.a(paramView));
          }
          this.jdField_a_of_type_Axzc.show();
          return;
        }
        if (paramaxvj2.jdField_a_of_type_Long == 1030L)
        {
          if (this.jdField_a_of_type_Axzo == null)
          {
            this.jdField_a_of_type_Axzo = new axzo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Axut, this);
            this.jdField_a_of_type_Axzo.a(axvv.a(paramView));
          }
          if (Build.VERSION.SDK_INT >= 23)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.requestPermissions(new axtg(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
            return;
          }
          ((axvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(369)).a(9);
          this.jdField_a_of_type_Axzo.show();
          return;
        }
      }
      if ((localStatus != null) && (paramaxvj2 != null) && (!a(paramaxvj2, localStatus)))
      {
        axvf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localStatus, paramaxvj2.jdField_a_of_type_Long);
        paramView = BaseApplicationImpl.getContext().getSharedPreferences("online_battery", 0);
        boolean bool = paramView.getBoolean("has_set_battery", false);
        if ((axuy.a().a(paramaxvj2)) && (!bool))
        {
          paramView.edit().putBoolean("has_set_battery", true).apply();
          a(localStatus, paramaxvj2.jdField_a_of_type_Long);
        }
        while (QLog.isColorLevel())
        {
          QLog.d("AccountPanel", 2, String.format("onOnlineStatusChanged, %s -> %s, %d", new Object[] { paramaxvj1, localStatus, Long.valueOf(paramaxvj2.jdField_a_of_type_Long) }));
          return;
          if (axvd.a(localStatus))
          {
            a(localStatus, paramaxvj2.jdField_a_of_type_Long);
          }
          else if ((paramaxvj2.jdField_a_of_type_Long == 1028L) && (!axys.a()))
          {
            axys.a();
            a(localStatus, paramaxvj2.jdField_a_of_type_Long);
          }
          else
          {
            a(localStatus, paramaxvj2.jdField_a_of_type_Long, true);
          }
        }
      }
    }
  }
  
  public void a(SimpleAccount paramSimpleAccount)
  {
    if (!NetworkUtil.isNetSupportHw(BaseApplication.getContext()))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692035), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
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
    bcqj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    AlbumUtil.clearLastAlbumInfo();
  }
  
  public void a(SimpleAccount paramSimpleAccount, QQAppInterface paramQQAppInterface)
  {
    bcqp localbcqp = bcqk.a(paramQQAppInterface, paramSimpleAccount.getUin());
    if ((localbcqp.jdField_a_of_type_Int <= 0) || (localbcqp.jdField_a_of_type_Boolean)) {
      a(paramSimpleAccount);
    }
    for (;;)
    {
      if (localbcqp.jdField_a_of_type_Int > 0) {
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
    if ((paramSimpleAccount != null) && (bcqk.a(paramQQAppInterface, paramSimpleAccount)))
    {
      a(paramSimpleAccount);
      return true;
    }
    return false;
  }
  
  public void aw_()
  {
    try
    {
      b(false);
      if (this.jdField_a_of_type_Axzc != null) {
        this.jdField_a_of_type_Axzc.m();
      }
      if (this.jdField_a_of_type_Axzo != null) {
        this.jdField_a_of_type_Axzo.m();
      }
      if (this.jdField_a_of_type_Axyy != null) {
        this.jdField_a_of_type_Axyy.m();
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
    this.jdField_a_of_type_Axuw.a();
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
    this.jdField_a_of_type_Long = axuy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Axuw.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
    if (this.jdField_a_of_type_Axvx != null) {
      this.jdField_a_of_type_Axvx.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
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
    if (this.jdField_a_of_type_Bhht == null)
    {
      this.jdField_a_of_type_Bhht = new bhht(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      this.jdField_a_of_type_Bhht.c(true);
    }
    this.jdField_a_of_type_Bhht.c(2131694279);
    if ((this.jdField_a_of_type_Bhht != null) && (!this.jdField_a_of_type_Bhht.isShowing()) && (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())) {
      this.jdField_a_of_type_Bhht.show();
    }
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_Bhht != null) && (this.jdField_a_of_type_Bhht.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bhht.dismiss();
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
    this.jdField_a_of_type_Axzo = null;
    this.jdField_a_of_type_Axzc = null;
    this.jdField_a_of_type_Axyy = null;
    b(false);
    bcqj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    }
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "onAccoutChangeFailed");
    }
    this.jdField_a_of_type_Axzo = null;
    this.jdField_a_of_type_Axzc = null;
    this.jdField_a_of_type_Axyy = null;
    j();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      QQCustomDialog localQQCustomDialog = bfur.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setTitle(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131718663)).setMessage(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131718662));
      localQQCustomDialog.setPositiveButton(2131690952, new axsx(this));
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
      if (this.jdField_a_of_type_Axtp != null) {
        this.jdField_a_of_type_Axtp.a();
      }
      axvz.a("0X800AF3C");
      continue;
      if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131718582, 1).a();
        if (this.jdField_a_of_type_Axvx != null) {
          this.jdField_a_of_type_Axvx.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
        }
      }
      else
      {
        c(paramView);
        continue;
        bgeg.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "panel");
        axvz.a("0X800AF42", 1);
        continue;
        if (!AppNetConnInfo.isNetSupport())
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131718582, 0).a();
          if (this.jdField_a_of_type_Axyy != null) {
            this.jdField_a_of_type_Axyy.dismiss();
          }
          a(40001);
        }
        else if (this.jdField_a_of_type_Axyy != null)
        {
          boolean bool2 = axvj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus(), axuy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
          this.jdField_c_of_type_Boolean = bool2;
          if (QLog.isColorLevel()) {
            QLog.d("AccountPanel", 4, new Object[] { " isCurStatusSmart =", Boolean.valueOf(bool2) });
          }
          Object localObject = this.jdField_a_of_type_Axyy.a();
          QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          ArrayList localArrayList = this.jdField_a_of_type_Axyy.c();
          if (!bool2) {
            bool1 = true;
          }
          axvt.a(localQQAppInterface, (OnlineStatusPermissionChecker.OnlineStatusPermissionItem)localObject, localArrayList, bool1);
          this.jdField_a_of_type_Axyy.dismiss();
          localObject = paramView.getTag();
          if ((localObject instanceof Integer))
          {
            int i = ((Integer)localObject).intValue();
            if (i == 2)
            {
              localObject = this.jdField_a_of_type_Axyy.c().iterator();
              while (((Iterator)localObject).hasNext()) {
                axvz.a("0X800AF40", ((Integer)((Iterator)localObject).next()).intValue(), "1");
              }
            }
            if (i == 1)
            {
              localObject = this.jdField_a_of_type_Axyy.c().iterator();
              while (((Iterator)localObject).hasNext()) {
                axvz.a("0X800B00F", ((Integer)((Iterator)localObject).next()).intValue(), "1");
              }
            }
          }
          axvz.a("0X8009DE0", 40001);
          continue;
          if (bftf.c())
          {
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131693541, 0).a();
          }
          else
          {
            localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AddAccountActivity.class);
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(2130771997, 2130771990);
            bcqj.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
            bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80072D4", "0X80072D4", 0, 0, "", "", "", "");
            axvz.a("0X800AF3B");
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
      if (this.jdField_a_of_type_Axtq != null) {
        this.jdField_a_of_type_Axtq.a(this.jdField_a_of_type_MqqAppAppRuntime$Status);
      }
      r();
      q();
      this.jdField_a_of_type_AndroidOsHandler.post(new AccountPanel.3(this));
      Object localObject = new Intent("before_account_change");
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.sendBroadcast((Intent)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanel", 2, "show AccountPanel");
      }
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AC35", "0X800AC35", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Axuw.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      ((axvp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(370)).a(40001L, false);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewAccountPanelRootLayout.a();
      b(true);
      return;
      localObject = new axuu();
      ((axuu)localObject).jdField_a_of_type_ComTencentMobileqqAppBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      this.jdField_a_of_type_Axut.a((axuu)localObject, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axsv
 * JD-Core Version:    0.7.0.1
 */