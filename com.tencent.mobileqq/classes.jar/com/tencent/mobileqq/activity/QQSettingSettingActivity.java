package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.QQProtectRisks.QQProtectRisksRequest;
import com.tencent.mobileqq.activity.aio.helper.HiddenChatHelper;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.ark.debug.ArkIDESettingFragment;
import com.tencent.mobileqq.config.CfgProcess;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.identification.FaceAreaManager;
import com.tencent.mobileqq.managers.CUOpenCardGuideMng;
import com.tencent.mobileqq.managers.CUOpenCardGuideMng.GuideEntry;
import com.tencent.mobileqq.managers.TimUpgradeHongdianManager;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.profilecard.utils.QQDarenUtils;
import com.tencent.mobileqq.settings.fragment.PermissionPrivacyFragment;
import com.tencent.mobileqq.settings.message.AssistantSettingFragment;
import com.tencent.mobileqq.settings.message.NotifyPushSettingFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.ModeChoiceViewContainer;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.upgrade.UpgradeController;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqprotect.common.QPMiscUtils;
import com.tencent.widget.MultiImageTextView;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;
import protocol.KQQConfig.UpgradeInfo;

public class QQSettingSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final boolean u = AppSetting.e;
  private boolean A = false;
  private String B = "";
  private String C = "";
  private boolean D = false;
  private boolean E = false;
  private boolean F = false;
  private ModeChoiceViewContainer G;
  private boolean H;
  private TopGestureLayout I;
  private GameCenterObserver J = new QQSettingSettingActivity.1(this);
  private BroadcastReceiver K = new QQSettingSettingActivity.2(this);
  private UpgradeDetailWrapper L;
  private ConfigObserver M = new QQSettingSettingActivity.8(this);
  private ProgressBar N = null;
  private TextView O = null;
  private Bundle P = null;
  private long Q = 0L;
  private CardObserver R = new QQSettingSettingActivity.13(this);
  private ProfileCardObserver S = new QQSettingSettingActivity.14(this);
  private boolean T;
  FormItemRelativeLayout a;
  LinearLayout b;
  ImageView c;
  TextView d;
  RelativeLayout e;
  MultiImageTextView f;
  ThemeImageView g;
  TextView h = null;
  public boolean i;
  CUOpenCardGuideMng.GuideEntry j = null;
  FormSimpleItem k;
  boolean l;
  FormSimpleItem m;
  FormItemRelativeLayout n;
  TextView o = null;
  ImageView p = null;
  SecSvcObserver q = new QQSettingSettingActivity.3(this);
  Resources r = BaseApplication.getContext().getResources();
  public int s = 0;
  FriendListObserver t = new QQSettingSettingActivity.12(this);
  private RedTouch v;
  private RedTouch w;
  private RedTouch x;
  private boolean y = false;
  private boolean z = true;
  
  private void a(long paramLong, String paramString)
  {
    Object localObject = getSharedPreferences("sp_qs_settings", 0);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qsec_status_expired_time");
      localStringBuilder.append(this.app.getCurrentAccountUin());
      localObject = ((SharedPreferences.Editor)localObject).putLong(localStringBuilder.toString(), paramLong);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("qsec_status_tip_text");
      localStringBuilder.append(this.app.getCurrentAccountUin());
      paramString = ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), paramString);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("qsec_status_update_last_time");
      ((StringBuilder)localObject).append(this.app.getCurrentAccountUin());
      paramString.putLong(((StringBuilder)localObject).toString(), new Date().getTime()).commit();
    }
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle)
  {
    boolean bool = QLog.isDevelopLevel();
    int i1 = 1;
    if (bool) {
      QLog.i("QQSetting2Activity", 4, String.format(Locale.getDefault(), "updatePhoneUnityInfo suc: %s, data: %s", new Object[] { Boolean.valueOf(paramBoolean), paramBundle }));
    }
    if (!q())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("updatePhoneUnityInfo: Cannot UpdateViews, isRequest=");
      paramBundle.append(this.E);
      QLog.i("QQSetting2Activity", 1, paramBundle.toString());
      return;
    }
    int i2 = 8;
    if ((paramBoolean) && (paramBundle != null))
    {
      int i3 = paramBundle.getInt("status", 0);
      if (i3 != 4)
      {
        this.P = paramBundle;
        this.N.setVisibility(8);
        this.o.setVisibility(0);
        this.z = this.P.getBoolean("phone_verified", true);
        this.A = this.P.getBoolean("bool_is_IOT", false);
        if ((!b(paramBundle)) && (!a(paramBundle)))
        {
          Object localObject = paramBundle.getString("phone");
          if (i3 == 3) {
            this.o.setText(2131892466);
          } else if (!TextUtils.isEmpty((CharSequence)localObject)) {
            this.o.setText((CharSequence)localObject);
          } else {
            this.o.setText(2131892463);
          }
          if (r())
          {
            if ((paramBundle.getInt("need_unify", 0) != 1) || (TextUtils.isEmpty((CharSequence)localObject))) {
              i1 = 0;
            }
            localObject = this.p;
            if (i1 != 0) {
              i2 = 0;
            }
            ((ImageView)localObject).setVisibility(i2);
          }
        }
        PhoneUnityManager.a(this.app, "0X800B327", paramBundle);
        return;
      }
    }
    this.P = null;
    this.o.setText("");
    this.p.setVisibility(8);
    this.N.setVisibility(8);
  }
  
  private boolean a(Bundle paramBundle)
  {
    paramBundle = (Bundle[])paramBundle.getParcelableArray("phone_info");
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      int i2 = paramBundle.length;
      int i1 = 0;
      while (i1 < i2)
      {
        if (c(paramBundle[i1])) {
          return true;
        }
        i1 += 1;
      }
    }
    return false;
  }
  
  private boolean a(PhoneUnityManager paramPhoneUnityManager)
  {
    return (paramPhoneUnityManager.h == null) || (paramPhoneUnityManager.a) || (System.currentTimeMillis() - paramPhoneUnityManager.k > 1800000L);
  }
  
  private void b(Card paramCard)
  {
    String str = CfgProcess.a(this.app.getCurrentUin(), "hide_qq_xman");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("newxman_cfg =");
    ((StringBuilder)localObject2).append(str);
    QLog.d("QQSetting2Activity", 2, ((StringBuilder)localObject2).toString());
    int i1;
    try
    {
      i1 = new JSONObject(str).getInt("hide_qq_xman");
      if (i1 != 1) {
        i1 = 1;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      i1 = 0;
    }
    Object localObject1;
    if ((paramCard != null) && (paramCard.isShowXMan()) && (i1 != 0))
    {
      if (paramCard.lQQMasterLogindays > 0L) {
        QQDarenUtils.sQQDarenLoginDays = paramCard.lQQMasterLogindays;
      } else {
        QQDarenUtils.sQQDarenLoginDays = 30L;
      }
      if (!paramCard.allowClick)
      {
        this.e.setVisibility(8);
        localObject1 = this.m;
        if (localObject1 != null) {
          ((FormSimpleItem)localObject1).setBgType(0);
        }
        this.n.setBGType(3);
        this.b.setBackgroundDrawable(null);
      }
      else
      {
        this.b.setVisibility(8);
        h();
        localObject1 = this.m;
        if (localObject1 != null) {
          ((FormSimpleItem)localObject1).setBgType(1);
        }
        this.e.setOnClickListener(this);
        a(paramCard);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuffer(200);
        ((StringBuffer)localObject1).append("updataQQLoginDays card.lQQMasterLogindays=");
        ((StringBuffer)localObject1).append(paramCard.lQQMasterLogindays);
        ((StringBuffer)localObject1).append(";card.allowClick=");
        ((StringBuffer)localObject1).append(paramCard.allowClick);
        QLog.d("QQSetting2Activity", 2, ((StringBuffer)localObject1).toString());
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        StringBuffer localStringBuffer = new StringBuffer(200);
        localStringBuffer.append("updataQQLoginDays card=");
        localObject2 = "null";
        if (paramCard == null) {
          localObject1 = "null";
        } else {
          localObject1 = "obj";
        }
        localStringBuffer.append((String)localObject1);
        localStringBuffer.append(";card.isShowXMan()=");
        if (paramCard == null) {
          paramCard = (Card)localObject2;
        } else {
          paramCard = Boolean.toString(paramCard.isShowXMan());
        }
        localStringBuffer.append(paramCard);
        QLog.d("QQSetting2Activity", 2, localStringBuffer.toString());
      }
      this.b.setVisibility(8);
      this.e.setVisibility(8);
      paramCard = findViewById(2131442619);
      if ((this.m != null) && (paramCard != null) && (paramCard.getVisibility() != 0)) {
        this.m.setBgType(0);
      }
    }
  }
  
  private void b(String paramString)
  {
    RedTouch localRedTouch = this.x;
    if ((localRedTouch != null) && (localRedTouch.h()))
    {
      this.h.setVisibility(8);
      return;
    }
    c(paramString);
  }
  
  private boolean b(Bundle paramBundle)
  {
    if (paramBundle.getBoolean("bool_is_IOT", false))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramBundle.getString("phone", ""));
      ((StringBuilder)localObject).append("(");
      ((StringBuilder)localObject).append(paramBundle.getString("str_red_dot_tips", ""));
      ((StringBuilder)localObject).append(")");
      localObject = ((StringBuilder)localObject).toString();
      this.o.setText((CharSequence)localObject);
      this.o.setVisibility(0);
      this.C = paramBundle.getString("phone");
      if (!SharedPreUtils.a(this, this.app.getCurrentUin(), this.C)) {
        this.p.setVisibility(0);
      }
      this.N.setVisibility(8);
      return true;
    }
    return false;
  }
  
  private void c(String paramString)
  {
    if (this.h != null)
    {
      if (LocaleManager.a())
      {
        this.h.setVisibility(0);
        this.h.setText(paramString);
      }
      if (AppSetting.e) {
        this.h.setContentDescription(paramString);
      }
    }
  }
  
  private boolean c(Bundle paramBundle)
  {
    if (paramBundle.getInt("phone_type") == 4)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramBundle.getString("phone", ""));
      if (this.P != null)
      {
        localStringBuilder.append("(");
        localStringBuilder.append(this.P.getString("str_red_dot_tips", ""));
        localStringBuilder.append(")");
      }
      this.o.setText(localStringBuilder.toString());
      this.o.setVisibility(0);
      this.B = paramBundle.getString("phone");
      if (!SharedPreUtils.a(this, this.app.getCurrentUin(), this.B)) {
        this.p.setVisibility(0);
      }
      this.N.setVisibility(8);
      return true;
    }
    return false;
  }
  
  private void d()
  {
    if (this.x != null)
    {
      IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.app.getRuntimeService(IRedTouchManager.class, "");
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localIRedTouchManager.getAppInfoByPath("100190.100199");
      this.x.c(localAppInfo);
      m();
      localIRedTouchManager.onReportRedPointExposure(localAppInfo);
    }
  }
  
  private void e()
  {
    if (this.v != null)
    {
      IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.app.getRuntimeService(IRedTouchManager.class, "");
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localIRedTouchManager.getAppInfoByPath("100190.100191");
      this.v.a(localAppInfo);
      localIRedTouchManager.onReportRedPointExposure(localAppInfo);
    }
  }
  
  private void f()
  {
    if (this.w != null)
    {
      IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.app.getRuntimeService(IRedTouchManager.class, "");
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localIRedTouchManager.getAppInfoByPath("100190.100193");
      if (localAppInfo != null) {
        localIRedTouchManager.reportLevelOneRedInfo("100190.100193", 30);
      }
      this.w.a(localAppInfo);
    }
  }
  
  private void g()
  {
    if (!ModeChoiceViewContainer.a(this.app)) {
      return;
    }
    this.G = new ModeChoiceViewContainer(this.app, this);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131438794);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = ViewUtils.dpToPx(10.0F);
    localLinearLayout.addView(this.G.h(), localLayoutParams);
  }
  
  private void h()
  {
    this.e.setVisibility(8);
    this.a.setBGType(3);
  }
  
  private void i()
  {
    FaceAreaManager.a().a(this.app, this, 101810106, "setFaceData", null);
  }
  
  private void j()
  {
    View localView = findViewById(2131437176);
    if (!TextUtils.isEmpty(AboutActivity.b()))
    {
      if (Integer.parseInt(AboutActivity.b()) == 5)
      {
        localView.setVisibility(0);
        a(2131437176, 2131897228, 0, 2130839622);
        return;
      }
      ArkIDESettingFragment.a().g();
      localView.setVisibility(8);
      return;
    }
    localView.setVisibility(8);
  }
  
  private void k()
  {
    View localView = findViewById(2131427368);
    Drawable localDrawable = this.r.getDrawable(2130852591);
    boolean bool = a();
    if (bool) {
      a(localView, 0, localDrawable);
    } else {
      a(localView, 8, localDrawable);
    }
    if ((!bool) && (PrivacyPolicyHelper.a(1))) {
      a(localView, 0, this.r.getDrawable(2130852588));
    }
  }
  
  private void l()
  {
    ((ImageView)findViewById(2131442618).findViewById(2131449075)).setVisibility(8);
  }
  
  private void m()
  {
    ThreadManager.post(new QQSettingSettingActivity.9(this), 8, null, true);
  }
  
  private void n()
  {
    QQProtectRisks.QQProtectRisksRequest localQQProtectRisksRequest = new QQProtectRisks.QQProtectRisksRequest();
    localQQProtectRisksRequest.uint32_sec_cmd.set(1);
    localQQProtectRisksRequest.str_package_name.set(QPMiscUtils.a());
    localQQProtectRisksRequest.uint32_app_id.set(AppSetting.d());
    ProtoUtils.a(this.app, new QQSettingSettingActivity.10(this), localQQProtectRisksRequest.toByteArray(), "AccountSafeSvc.RiskDetect");
  }
  
  private void o()
  {
    Object localObject = this.P;
    int i1;
    if (localObject == null)
    {
      i1 = 4;
    }
    else
    {
      localObject = ((Bundle)localObject).getString("phone");
      if (this.P.getInt("status", 0) == 3) {
        i1 = 3;
      } else if (!TextUtils.isEmpty((CharSequence)localObject)) {
        i1 = 1;
      } else {
        i1 = 2;
      }
    }
    ReportController.b(this.app, "dc00898", "", "", "0X800B896", "0X800B896", i1, 0, "", "", "", "");
  }
  
  private void p()
  {
    Intent localIntent = new Intent(this, PhoneUnityBindInfoActivity.class);
    localIntent.putExtra("kSrouce", 1);
    Bundle localBundle = this.P;
    if (localBundle != null) {
      localIntent.putExtra("kBindPhoneData", localBundle);
    }
    startActivityForResult(localIntent, 2001);
  }
  
  private boolean q()
  {
    return (!this.E) && (this.o != null) && (this.p != null) && (this.N != null);
  }
  
  private boolean r()
  {
    Bundle localBundle = this.P;
    return (localBundle != null) && (localBundle.getBoolean("is_all_phone_get", true));
  }
  
  private void s()
  {
    if (!this.T)
    {
      ThreadManager.post(new QQSettingSettingActivity.17(this), 5, null, false);
      this.T = true;
    }
  }
  
  private TopGestureLayout t()
  {
    if (this.I == null)
    {
      Object localObject = (ViewGroup)getWindow().getDecorView();
      View localView = ((ViewGroup)localObject).getChildAt(0);
      if ((localView instanceof DragFrameLayout)) {
        localObject = (ViewGroup)localView;
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.I = ((TopGestureLayout)localObject);
      }
    }
    return this.I;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject1 = findViewById(paramInt1);
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = (TextView)((View)localObject1).findViewById(2131442629);
    ((TextView)localObject2).setText(paramInt2);
    if (u) {
      ((TextView)localObject2).setContentDescription(getString(paramInt2));
    }
    if (paramInt3 > 0) {
      ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(paramInt3), null, null, null);
    }
    ((View)localObject1).setBackgroundResource(paramInt4);
    ((View)localObject1).setOnClickListener(this);
    if ((localObject1 instanceof FormItemRelativeLayout))
    {
      localObject2 = (FormItemRelativeLayout)localObject1;
      if (paramInt4 == 2130839638) {
        ((FormItemRelativeLayout)localObject2).setBGType(1);
      } else if (paramInt4 == 2130839632) {
        ((FormItemRelativeLayout)localObject2).setBGType(2);
      } else if (paramInt4 == 2130839629) {
        ((FormItemRelativeLayout)localObject2).setBGType(3);
      }
    }
    if (paramInt1 == 2131442612)
    {
      this.x = new RedTouch(this, (View)localObject1).b(30.0F).a();
      d();
      this.n = ((FormItemRelativeLayout)localObject1);
      ((View)localObject1).findViewById(2131440771).setVisibility(8);
      ((View)localObject1).findViewById(2131431805).setVisibility(8);
      this.h = ((TextView)((View)localObject1).findViewById(2131431804));
      localObject1 = this.h;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
    }
    else
    {
      if (paramInt1 == 2131442620)
      {
        this.v = new RedTouch(this, (View)localObject1).b(30.0F).a();
        e();
        ((View)localObject1).findViewById(2131440771).setVisibility(8);
        ((View)localObject1).findViewById(2131431805).setVisibility(8);
        ((TextView)((View)localObject1).findViewById(2131431804)).setVisibility(8);
        return;
      }
      if (paramInt1 == 2131442619)
      {
        this.o = ((TextView)((View)localObject1).findViewById(2131431804));
        localObject2 = this.o;
        if (localObject2 != null)
        {
          ((TextView)localObject2).setVisibility(0);
          this.o.setText(2131892463);
          if (u) {
            this.o.setContentDescription(null);
          }
        }
        this.N = ((ProgressBar)((View)localObject1).findViewById(2131440771));
        localObject2 = this.N;
        if (localObject2 != null) {
          ((ProgressBar)localObject2).setVisibility(8);
        }
        this.p = ((ImageView)((View)localObject1).findViewById(2131431805));
        localObject1 = this.p;
        if (localObject1 != null)
        {
          ((ImageView)localObject1).setImageResource(2130852588);
          this.p.setVisibility(8);
        }
      }
      else
      {
        if (paramInt1 == 2131442618) {
          return;
        }
        if (u) {
          ((View)localObject1).setContentDescription(getString(paramInt2));
        }
      }
    }
  }
  
  public void a(View paramView, int paramInt, Drawable paramDrawable)
  {
    View localView2 = paramView.findViewById(2131442630);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = ((ViewStub)paramView.findViewById(2131442631)).inflate();
    }
    localView1.setVisibility(paramInt);
    paramView = (ImageView)localView1.findViewById(2131442625);
    paramView.setVisibility(0);
    paramView.setImageDrawable(paramDrawable);
  }
  
  void a(Card paramCard)
  {
    this.f.setText(" ");
    Object localObject1;
    if (paramCard.lLoginDays >= QQDarenUtils.sQQDarenLoginDays)
    {
      localObject1 = this.g;
      if (localObject1 != null) {
        ((ThemeImageView)localObject1).setImageDrawable(getResources().getDrawable(2130853417));
      }
      this.f.setTextColor(-155129);
    }
    else
    {
      localObject1 = this.g;
      if (localObject1 != null) {
        ((ThemeImageView)localObject1).setImageDrawable(getResources().getDrawable(2130853416));
      }
      this.f.setTextColor(-5855578);
    }
    Object localObject2;
    if (u)
    {
      localObject2 = getString(2131888158);
      localObject1 = localObject2;
      if (paramCard.allowPeopleSee)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(paramCard.lLoginDays);
        ((StringBuilder)localObject1).append(getString(2131888159));
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      this.e.setContentDescription((CharSequence)localObject1);
    }
    if (paramCard.allowPeopleSee)
    {
      this.f.a(3.0F);
      localObject1 = this.f;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramCard.lLoginDays);
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131888406));
      ((MultiImageTextView)localObject1).append(((StringBuilder)localObject2).toString());
      this.f.a(8.0F);
    }
    else
    {
      this.f.a(1.0F);
      this.f.append(" ");
      this.f.a(2.0F);
    }
    this.f.c();
  }
  
  void a(String paramString)
  {
    try
    {
      if (this.app != null)
      {
        FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (localFriendsManager != null)
        {
          ThreadManager.post(new QQSettingSettingActivity.15(this, localFriendsManager, paramString), 8, null, true);
          return;
        }
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("QQSetting2Activity", 2, "updateQQLevelInfo Exception!");
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, false);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.E)
    {
      QLog.i("QQSetting2Activity", 1, "startGetPhoneUnityStatus: on requesting, return.");
      return;
    }
    PhoneUnityManager localPhoneUnityManager = (PhoneUnityManager)this.app.getManager(QQManagerFactory.PHONE_UNITY_MANAGER);
    boolean bool;
    if ((!paramBoolean1) && (!a(localPhoneUnityManager))) {
      bool = false;
    } else {
      bool = true;
    }
    SecSvcHandler localSecSvcHandler = (SecSvcHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
    Object localObject;
    if (QLog.isColorLevel())
    {
      Locale localLocale = Locale.getDefault();
      if (localSecSvcHandler == null) {
        localObject = "null";
      } else {
        localObject = "is not null";
      }
      QLog.i("QQSetting2Activity", 2, String.format(localLocale, "startGetPhoneUnityStatus force: %s, isUserClicked: %s, need: %s, h: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(bool), localObject }));
    }
    if ((bool) && (localSecSvcHandler != null))
    {
      this.E = true;
      this.s += 1;
      localPhoneUnityManager.k = System.currentTimeMillis();
      localPhoneUnityManager.a = false;
      if (paramBoolean2) {
        localSecSvcHandler.a(2);
      } else {
        localSecSvcHandler.a(1);
      }
      this.P = null;
      localObject = this.N;
      if (localObject != null) {
        ((ProgressBar)localObject).setVisibility(0);
      }
      localObject = this.p;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
      localObject = this.o;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
    }
    else
    {
      a(true, localPhoneUnityManager.h);
    }
  }
  
  public boolean a()
  {
    Object localObject = this.L;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((UpgradeDetailWrapper)localObject).b != null)
      {
        bool1 = bool2;
        if (this.L.b.iUpgradeType > 0)
        {
          bool1 = bool2;
          if (this.L.b.bNewSwitch == 1) {
            bool1 = true;
          }
        }
      }
    }
    bool2 = bool1;
    if (!bool1)
    {
      localObject = (TimUpgradeHongdianManager)this.app.getManager(QQManagerFactory.TIM_UPGRADE_HONGDIAN_MANAGER);
      bool2 = bool1;
      if (localObject != null) {
        bool2 = ((TimUpgradeHongdianManager)localObject).a();
      }
    }
    return bool2;
  }
  
  void b()
  {
    if (this.k == null) {
      return;
    }
    CUOpenCardGuideMng.GuideEntry localGuideEntry = this.j;
    if ((localGuideEntry != null) && (!TextUtils.isEmpty(localGuideEntry.a)))
    {
      this.k.setVisibility(0);
      if (LocaleManager.a()) {
        this.k.setLeftText(this.j.a);
      } else {
        this.k.setLeftText(getResources().getText(2131897232));
      }
      this.k.setBackgroundResource(2130839622);
      this.k.setOnClickListener(this);
      if (!this.l)
      {
        this.l = true;
        ThreadManager.post(new QQSettingSettingActivity.16(this), 5, null, false);
      }
    }
    else
    {
      this.k.setVisibility(8);
      this.k.setOnClickListener(null);
    }
  }
  
  protected void c()
  {
    if ((this.H) && (!ModeChoiceViewContainer.a(this.app))) {
      return;
    }
    TopGestureLayout localTopGestureLayout = t();
    if (localTopGestureLayout == null)
    {
      QLog.e("QQSetting2Activity", 2, "processRvTouchEvent failed! topGestureLayout return null!");
      return;
    }
    this.H = true;
    localTopGestureLayout.setInterceptTouchEventListener(new QQSettingSettingActivity.18(this));
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    int i3 = 0;
    int i2 = 0;
    if (paramInt1 == 0)
    {
      int i1;
      if (paramInt2 != 0)
      {
        i1 = i3;
        if (paramInt2 != -1) {}
      }
      else
      {
        i1 = i3;
        if (paramIntent != null)
        {
          i1 = i3;
          if (paramIntent.getExtras() != null)
          {
            boolean bool = paramIntent.getExtras().getBoolean("auth_dev_open", false);
            i1 = i2;
            if (this.D != bool) {
              i1 = 1;
            }
            this.D = bool;
          }
        }
      }
      if (i1 != 0) {
        a(true);
      }
    }
    else if (paramInt1 == 2001)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQSetting2Activity", 2, String.format("REQ_CODE_PHONE_UNITY_BIND_INFO [%s]", new Object[] { Integer.valueOf(paramInt2) }));
      }
      if (paramInt2 == 4001) {
        a(true);
      } else {
        a(true, ((PhoneUnityManager)this.app.getManager(QQManagerFactory.PHONE_UNITY_MANAGER)).h);
      }
    }
    else if (paramInt1 == 2002)
    {
      this.y = false;
      a(true);
    }
    else if ((paramInt1 == 1000000) && (((IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class, "")).isBindedIgnoreUpload()))
    {
      localObject = new Intent(this, PhoneUnityBindInfoActivity.class);
      ((Intent)localObject).putExtra("kSrouce", 1);
      if (paramIntent != null) {
        ((Intent)localObject).putExtra("check_permission_result", paramIntent.getStringExtra("check_permission_result"));
      }
      startActivityForResult((Intent)localObject, 2001);
    }
    Object localObject = this.G;
    if (localObject != null) {
      ((ModeChoiceViewContainer)localObject).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131627822);
    setTitle(getString(2131897287));
    if (AppSetting.e)
    {
      paramBundle = getString(2131897287);
      this.centerView.setContentDescription(paramBundle);
    }
    setContentBackgroundResource(2130838958);
    this.m = ((FormSimpleItem)findViewById(2131427484));
    this.m.setLeftText(getString(2131897226));
    if (u) {
      this.m.setContentDescription(getString(2131897226));
    }
    this.m.setOnClickListener(this);
    this.w = new RedTouch(this, this.m.getRightTextView()).c(53).a();
    this.a = ((FormItemRelativeLayout)findViewById(2131442612));
    a(2131442619, 2131897269, 0, 2130839632);
    a(2131442612, 2131897233, 0, 2130839629);
    paramBundle = (FormSimpleItem)findViewById(2131442617);
    paramBundle.getLeftTextView().setText(2131897266);
    this.e = paramBundle;
    this.f = paramBundle.getRightTextView();
    this.g = new ThemeImageView(getBaseContext());
    this.g.setMaskShape(ThemeImageWrapper.MODE_OTHER);
    Object localObject = new RelativeLayout.LayoutParams(UIUtils.a(this.app.getApp(), 47.0F), UIUtils.a(this.app.getApp(), 21.0F));
    ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131433631);
    ((RelativeLayout.LayoutParams)localObject).setMargins(0, UIUtils.a(this.app.getApp(), 14.0F), 0, 0);
    this.e.addView(this.g, (ViewGroup.LayoutParams)localObject);
    this.e.setVisibility(8);
    paramBundle.setOnClickListener(this);
    g();
    a(2131442616, 2131897253, 0, 2130839638);
    a(2131442618, 2131897268, 0, 2130839632);
    a(2131442613, 2131897238, 0, 2130839632);
    a(2131442611, 2131897229, 0, 2130839629);
    a(2131427368, 2131897225, 0, 2130839622);
    paramBundle = FaceDrawable.getUserFaceDrawable(this.app, this.app.getCurrentAccountUin(), (byte)3);
    if (paramBundle != null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doOnCreate setIcon width =");
        ((StringBuilder)localObject).append(paramBundle.getMinimumWidth());
        QLog.d("QQSetting2Activity", 2, ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doOnCreate setIcon height =");
        ((StringBuilder)localObject).append(paramBundle.getMinimumHeight());
        QLog.d("QQSetting2Activity", 2, ((StringBuilder)localObject).toString());
      }
      this.m.setRightIcon(paramBundle, (int)(DeviceInfoUtil.A() * 40.0F), (int)(DeviceInfoUtil.A() * 40.0F));
    }
    this.app.addObserver(this.M);
    addObserver(this.R);
    addObserver(this.S);
    addObserver(this.t);
    addObserver(this.q);
    this.app.registObserver(this.J);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.InvitationWebViewPlugin.accountIdentityNotify");
    registerReceiver(this.K, paramBundle);
    this.L = UpgradeController.a().d();
    this.b = ((LinearLayout)findViewById(2131442125));
    this.c = ((ImageView)findViewById(2131442123));
    this.d = ((TextView)findViewById(2131442124));
    this.b.setVisibility(8);
    paramBundle = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.app, TempGetProfileDetailProcessor.class);
    if (paramBundle != null) {
      paramBundle.getLoginDaysSwitch();
    }
    this.k = ((FormSimpleItem)findViewById(2131431523));
    paramBundle = (CUOpenCardGuideMng)this.app.getManager(QQManagerFactory.CU_OPEN_CARD_GUIDE_MANAGER);
    if (paramBundle.a())
    {
      this.j = paramBundle.a(0);
      if (QLog.isColorLevel()) {
        QLog.i("QQSetting2Activity", 2, String.format(Locale.getDefault(), "cu_open_card_guide has init entry: %s ", new Object[] { this.j }));
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQSetting2Activity", 2, "cu_open_card_guide not init");
      }
      this.j = null;
      ThreadManager.post(new QQSettingSettingActivity.7(this), 5, null, true);
    }
    b();
    ReportController.a(this.app, "0X800B7C9");
    ReportController.a(this.app, "0X800B7CA");
    ReportController.a(this.app, "0X800B7CB");
    ReportController.a(this.app, "0X800B7CE");
    ReportController.a(this.app, "0X800B7CF");
    ReportController.a(this.app, "0X800B7CC");
    this.i = true;
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.t);
    this.app.removeObserver(this.M);
    removeObserver(this.R);
    removeObserver(this.S);
    removeObserver(this.q);
    this.app.unRegistObserver(this.J);
    unregisterReceiver(this.K);
    ModeChoiceViewContainer localModeChoiceViewContainer = this.G;
    if (localModeChoiceViewContainer != null) {
      localModeChoiceViewContainer.c();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    if (this.mSystemBarComp != null)
    {
      int i1 = getResources().getColor(2131168092);
      this.mSystemBarComp.setStatusColor(i1);
    }
    super.doOnResume();
    l();
    e();
    f();
    d();
    m();
    ((PhoneUnityManager)this.app.getManager(QQManagerFactory.PHONE_UNITY_MANAGER)).b();
    s();
    j();
    k();
    a(this.app.getCurrentAccountUin());
    i();
    h();
    c();
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    this.app = ((QQAppInterface)getAppRuntime());
    this.app.addObserver(this.M);
    addObserver(this.R);
    addObserver(this.S);
    addObserver(this.t);
    addObserver(this.q);
    FaceDrawable localFaceDrawable = FaceDrawable.getUserFaceDrawable(this.app, this.app.getCurrentAccountUin(), (byte)3);
    if (localFaceDrawable != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onAccountChanged setIcon width =");
        localStringBuilder.append(localFaceDrawable.getMinimumWidth());
        QLog.d("QQSetting2Activity", 2, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onAccountChanged setIcon height =");
        localStringBuilder.append(localFaceDrawable.getMinimumHeight());
        QLog.d("QQSetting2Activity", 2, localStringBuilder.toString());
      }
      this.m.setRightIcon(localFaceDrawable, (int)(DeviceInfoUtil.A() * 40.0F), (int)(DeviceInfoUtil.A() * 40.0F));
    }
    a(true);
    d();
    m();
    a(this.app.getCurrentAccountUin());
  }
  
  protected boolean onBackEvent()
  {
    HiddenChatHelper.c(this, SplashActivity.class);
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    Object localObject1 = "";
    switch (i1)
    {
    default: 
      break;
    case 2131442619: 
      if ((!this.z) && (!SharedPreUtils.a(this, this.app.getCurrentUin(), this.B)))
      {
        SharedPreUtils.a(this, this.app.getCurrentUin(), this.B, true);
        this.p.setVisibility(8);
      }
      if ((this.A) && (!SharedPreUtils.a(this, this.app.getCurrentUin(), this.C)))
      {
        SharedPreUtils.a(this, this.app.getCurrentUin(), this.C, true);
        this.p.setVisibility(8);
      }
      if (!this.E)
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8005DEA", "0X8005DEA", 0, 0, "", "", "", "");
        ReportController.b(this.app, "dc00898", "", "", "0X800689D", "0X800689D", 0, 0, "", "", "", "");
        ReportController.a(this.app, "0X800B82E");
        i1 = ((IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class, "")).getSelfBindState();
        if ((i1 == 1) || (i1 == 5)) {
          ReportController.b(this.app, "dc00898", "", "", "0X800689E", "0X800689E", 0, 0, "", "", "", "");
        }
        if (!r()) {
          o();
        }
        localObject1 = this.P;
        if (localObject1 == null)
        {
          a(true, true);
          this.F = true;
        }
        else if (this.A)
        {
          p();
          PhoneUnityManager.a(this.app, "0X800B328", this.P);
        }
        else if ((((Bundle)localObject1).getInt("check_result") == 1) && (TextUtils.isEmpty(this.B)))
        {
          localObject1 = this.P.getString("mibao_set_url");
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            PhoneUnityManager.a(this.app, "0X800B328", this.P);
            this.y = true;
            PhoneUnityManager.a(this, this.app, (String)localObject1, 2002);
          }
          else
          {
            QLog.e("QQSetting2Activity", 4, "mb set url is null.");
          }
        }
        else if (r())
        {
          PhoneUnityManager.a(this.app, "0X800B328", this.P);
          p();
        }
        else
        {
          a(true, true);
          this.F = true;
        }
      }
      break;
    case 2131442618: 
      PublicFragmentActivity.a(this, new Intent(), PermissionPrivacyFragment.class);
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_privacy_safe", 0, 0, "", "", "", "");
      break;
    case 2131442617: 
      localObject1 = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("uin", this.app.getCurrentAccountUin());
      ((Intent)localObject1).putExtra("url", "https://ti.qq.com/qqdaren/index?_wv=16777219&_wwv=128&ADTAG=set");
      ((Intent)localObject1).putExtra("hide_more_button", true);
      startActivity((Intent)localObject1);
      ReportController.b(this.app, "CliOper", "", "", "0X800487F", "0X800487F", 0, 0, "", "", "", "");
      break;
    case 2131442616: 
      ReportController.a(this.app, "0X800B830");
      PublicFragmentActivity.a(this, new Intent(), NotifyPushSettingFragment.class);
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_notifications", 0, 0, "", "", "", "");
      break;
    case 2131442613: 
      ReportController.a(this.app, "0X800B832");
      startActivity(new Intent(getActivity(), GeneralSettingActivity.class));
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "0X8009C04", 0, 0, "", "", "", "");
      break;
    case 2131442612: 
      localObject1 = new Intent(getActivity(), LoginInfoActivity.class);
      ((Intent)localObject1).putExtra("has_unverified_phone", this.z ^ true);
      startActivityForResult((Intent)localObject1, 0);
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "My_settab_safe", 0, 0, "", "", "", "");
      ReportController.a(this.app, "0X800B82F");
      break;
    case 2131442611: 
      ReportController.a(this.app, "0X800B833");
      localObject1 = new Intent();
      PublicFragmentActivity.a(getActivity(), (Intent)localObject1, AssistantSettingFragment.class);
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_accessibility", 0, 0, "", "", "", "");
      break;
    case 2131437176: 
      PublicFragmentActivity.a(this, new Intent(), ArkIDESettingFragment.class);
      break;
    case 2131431523: 
      Object localObject2 = this.j;
      if (localObject2 != null) {
        localObject1 = ((CUOpenCardGuideMng.GuideEntry)localObject2).c;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("uin", this.app.getCurrentAccountUin());
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        ((Intent)localObject2).putExtra("hide_more_button", true);
        startActivity((Intent)localObject2);
        ThreadManager.post(new QQSettingSettingActivity.11(this), 5, null, false);
      }
      if (QLog.isColorLevel()) {
        QLog.i("QQSetting2Activity", 2, String.format(Locale.getDefault(), "click cu_open_card_guide url: %s", new Object[] { localObject1 }));
      }
      break;
    case 2131427484: 
      startActivity(new Intent(this, AccountManageActivity.class));
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_manage_acc", 0, 0, "", "", "", "");
      ((IRedTouchManager)this.app.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("100190.100193");
      ReportController.a(this.app, "0X800B82D");
      break;
    case 2131427368: 
      startActivity(new Intent(getActivity(), AboutActivity.class));
      if (a()) {
        ReportController.b(this.app, "CliOper", "", "", "0X8004DB1", "0X8004DB1", 0, 0, "", "", UpgradeController.k(), "");
      }
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_about", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    Object localObject = FaceDrawable.getUserFaceDrawable(this.app, this.app.getCurrentAccountUin(), (byte)3);
    if (localObject != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onPostThemeChanged setIcon width =");
        localStringBuilder.append(((Drawable)localObject).getMinimumWidth());
        QLog.d("QQSetting2Activity", 2, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onPostThemeChanged setIcon height =");
        localStringBuilder.append(((Drawable)localObject).getMinimumHeight());
        QLog.d("QQSetting2Activity", 2, localStringBuilder.toString());
      }
      this.m.setRightIcon((Drawable)localObject, (int)(DeviceInfoUtil.A() * 40.0F), (int)(DeviceInfoUtil.A() * 40.0F));
    }
    localObject = this.G;
    if (localObject != null) {
      ((ModeChoiceViewContainer)localObject).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingSettingActivity
 * JD-Core Version:    0.7.0.1
 */