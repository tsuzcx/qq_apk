package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.nearby.QQNearbyManager;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QzonePluginProxyActivity;
import friendlist.EAddFriendSourceID;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class AutoRemarkActivity
  extends DialogBaseActivity
  implements TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  int a;
  String b;
  int c;
  int d = 0;
  Bundle e;
  int f;
  EditText g = null;
  TextView h = null;
  BounceScrollView i;
  FriendListHandler j;
  Dialog k;
  boolean l = false;
  private View m = null;
  private View n = null;
  private View o;
  private Switch p;
  private View q;
  private Switch r;
  private RelativeLayout s;
  private ImageView t;
  private TextView u;
  private TextView v;
  private AutoRemarkActivity.InternalFriendListObserver w = new AutoRemarkActivity.InternalFriendListObserver(this, null);
  private FriendObserver x = new AutoRemarkActivity.3(this);
  private ViewTreeObserver.OnGlobalLayoutListener y = new AutoRemarkActivity.5(this);
  
  private void a(int paramInt)
  {
    if (this.a == 0) {
      localObject1 = getString(2131891834);
    } else {
      localObject1 = HardCodeUtil.a(2131899095);
    }
    setTitle((CharSequence)localObject1);
    this.m = findViewById(2131445011);
    this.n = findViewById(2131444961);
    this.g = ((EditText)findViewById(2131432631));
    this.h = ((TextView)findViewById(2131448505));
    this.h.setText(((IAddFriendApi)QRoute.api(IAddFriendApi.class)).getGroupName(this.app, this.d));
    Object localObject1 = this.n;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131899091));
    ((StringBuilder)localObject2).append(((IAddFriendApi)QRoute.api(IAddFriendApi.class)).getGroupName(this.app, this.d));
    ((View)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
    this.g.addTextChangedListener(this);
    this.n.setOnClickListener(this);
    if (Utils.c(this.b)) {
      this.m.setVisibility(8);
    } else {
      this.m.setVisibility(0);
    }
    if (((IAddFriendApi)QRoute.api(IAddFriendApi.class)).shouldUseLocalRemark(this.c))
    {
      localObject2 = getIntent().getStringExtra("nick_name");
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("initUI remark = ");
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(", source id=");
        ((StringBuilder)localObject1).append(this.c);
        QLog.d("AutoRemarkActivity", 2, ((StringBuilder)localObject1).toString());
        localObject1 = localObject2;
      }
    }
    else
    {
      localObject1 = this.e;
      if ((localObject1 != null) && (this.l)) {
        localObject1 = ((Bundle)localObject1).getString("base_nick");
      } else {
        localObject1 = "";
      }
    }
    this.g.setText((CharSequence)localObject1);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      this.g.setSelection(((String)localObject1).length());
    }
    if ((!EAddFriendSourceID.a(this.c)) && (this.c != 3016)) {
      paramInt = 0;
    } else {
      paramInt = 1;
    }
    if (paramInt == 0)
    {
      this.o = findViewById(2131443801);
      this.o.setVisibility(0);
      findViewById(2131443803).setVisibility(0);
      this.p = ((Switch)findViewById(2131443802));
      this.p.setOnCheckedChangeListener(this);
    }
    if (this.a == 0)
    {
      setRightHighlightButton(2131916261, this);
      enableRightHighlight(true);
      setLeftViewName(getIntent());
    }
    else
    {
      setRightHighlightButton(2131889474, this);
      enableRightHighlight(true);
      setLeftButton(2131887648, this);
      if (this.a == 1)
      {
        this.q = findViewById(2131445681);
        this.q.setVisibility(0);
        localObject1 = (TextView)findViewById(2131443803);
        ((TextView)localObject1).setVisibility(0);
        ((TextView)localObject1).setText(2131916276);
        ((TextView)localObject1).setContentDescription(getString(2131916276));
        this.r = ((Switch)findViewById(2131445707));
        if (AppSetting.e)
        {
          this.q.setContentDescription(HardCodeUtil.a(2131899094));
          this.q.setFocusable(true);
        }
        this.r.setOnCheckedChangeListener(this);
        this.leftView.setVisibility(8);
      }
    }
    this.s = ((RelativeLayout)findViewById(2131444917));
    this.t = ((ImageView)findViewById(2131440523));
    this.u = ((TextView)findViewById(2131439320));
    this.v = ((TextView)findViewById(2131449367));
    if (this.e != null)
    {
      this.s.setVisibility(0);
      localObject1 = (LinearLayout.LayoutParams)this.m.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).topMargin = AIOUtils.b(0.0F, getResources());
      this.m.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.e.getString("base_uin");
      localObject2 = this.e.getString("base_nick");
      this.e.getInt("verfy_type");
      Object localObject3 = this.e.getString("verfy_msg");
      if (TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject3 = (LinearLayout.LayoutParams)this.u.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject3).topMargin = AIOUtils.b(15.0F, getResources());
        this.u.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      }
      else
      {
        TextView localTextView = this.v;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(getString(2131886314));
        localStringBuilder.append(": ");
        localStringBuilder.append((String)localObject3);
        localTextView.setText(localStringBuilder.toString());
      }
      this.t.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 1, (String)localObject1));
      this.u.setText((CharSequence)localObject2);
    }
    else
    {
      this.s.setVisibility(8);
      localObject1 = (LinearLayout.LayoutParams)this.m.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).topMargin = AIOUtils.b(10.0F, getResources());
      this.m.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    this.i = ((BounceScrollView)findViewById(2131429719));
    this.i.setOnTouchListener(new AutoRemarkActivity.1(this));
    if (AppSetting.e)
    {
      localObject1 = this.leftView;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131901576));
      ((StringBuilder)localObject2).append(this.leftView.getText().toString());
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131899093));
      ((TextView)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
      this.m.setFocusable(true);
      localObject1 = this.m;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(getResources().getString(2131890924));
      ((StringBuilder)localObject2).append(this.g.getText().toString());
      ((View)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
      this.g.setContentDescription(null);
      if (paramInt == 0)
      {
        this.o.setFocusable(true);
        this.o.setContentDescription(getResources().getString(2131914894));
        findViewById(2131443803).setFocusable(true);
      }
    }
  }
  
  public static void a(Activity paramActivity, int paramInt, String paramString, long paramLong, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startAutoRemarkActivity, ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("AutoRemarkActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Intent(paramActivity, AutoRemarkActivity.class);
    ((Intent)localObject).putExtra("param_mode", 1);
    ((Intent)localObject).putExtra("uin", paramString);
    ((Intent)localObject).putExtra("k_msg_key", paramLong);
    if (paramBundle != null) {
      ((Intent)localObject).putExtras(paramBundle);
    }
    paramActivity.startActivityForResult((Intent)localObject, paramInt);
    paramActivity.overridePendingTransition(2130772434, 2130772007);
  }
  
  private void a(String paramString)
  {
    Dialog localDialog = this.k;
    if ((localDialog != null) && (localDialog.isShowing()) && (this.k.getWindow() != null)) {}
    try
    {
      this.k.dismiss();
      label33:
      this.k = DialogUtil.a(this, paramString, 0, 2131892267, null, new AutoRemarkActivity.2(this));
      try
      {
        this.k.show();
        return;
      }
      catch (Throwable paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AutoRemarkActivity", 2, "showErrorTipsDlg, tips dialog show failed", paramString);
        }
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      break label33;
    }
  }
  
  private void b()
  {
    ThreadManager.getSubThreadHandler().post(new AutoRemarkActivity.4(this));
  }
  
  void a()
  {
    Object localObject2 = getIntent().getStringExtra("param_return_addr");
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("goBack | retAddr = ");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.d("AutoRemarkActivity", 2, ((StringBuilder)localObject1).toString());
    }
    if (localObject2 != null) {
      try
      {
        localObject1 = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getProfileCardActivityClass();
        localObject2 = Class.forName((String)localObject2);
        Intent localIntent2 = new Intent();
        localIntent2.setComponent(new ComponentName("com.tencent.mobileqq", ((Class)localObject2).getName()));
        if ((!localObject2.equals(localObject1)) && (!localObject2.equals(QidianProfileCardActivity.class)))
        {
          if (localObject2.equals(QQNearbyManager.b()))
          {
            localIntent2.putExtra("AllInOne", new AllInOne(this.b, 41));
            localIntent2.putExtra("param_mode", 3);
          }
        }
        else {
          ProfileActivity.a(this, this.b, localIntent2);
        }
        localIntent2.setFlags(67108864);
        localIntent2.putExtra("key_back_from_add_friend", true);
        if (localObject2.equals(QQNearbyManager.b()))
        {
          RouteUtils.a(BaseApplicationImpl.getContext(), localIntent2, "/nearby/people/profile");
          return;
        }
        startActivity(localIntent2);
        return;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AutoRemarkActivity", 2, "goBack | exception = ", localClassNotFoundException);
        }
        localClassNotFoundException.printStackTrace();
        setResult(-1);
        finish();
        return;
      }
    }
    if (getIntent().getBooleanExtra("from_newer_guide", false))
    {
      Intent localIntent1 = new Intent();
      localIntent1.putExtra("has_operation", true);
      localIntent1.putExtra("uin", this.b);
      setResult(-1, localIntent1);
    }
    else
    {
      setResult(-1);
    }
    finish();
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.g.getText().toString();
    if (((IAddFriendApi)QRoute.api(IAddFriendApi.class)).countByByte(paramEditable) > 32)
    {
      int i1 = this.g.getSelectionStart();
      paramEditable = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).getRemark(paramEditable);
      this.g.setText(paramEditable);
      if (i1 >= paramEditable.length()) {
        this.g.setSelection(paramEditable.length());
      }
    }
    if (AppSetting.e)
    {
      paramEditable = this.m;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getResources().getString(2131890924));
      localStringBuilder.append(this.g.getText().toString());
      paramEditable.setContentDescription(localStringBuilder.toString());
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
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
    if (paramInt2 != -1) {
      return;
    }
    if (paramInt1 != 1001) {
      return;
    }
    paramInt1 = paramIntent.getByteExtra("result", (byte)0);
    this.d = paramInt1;
    this.h.setText(((IAddFriendApi)QRoute.api(IAddFriendApi.class)).getGroupName(this.app, paramInt1));
    if (AppSetting.e)
    {
      paramIntent = this.n;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131899092));
      localStringBuilder.append(((IAddFriendApi)QRoute.api(IAddFriendApi.class)).getGroupName(this.app, paramInt1));
      paramIntent.setContentDescription(localStringBuilder.toString());
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131624266);
    setContentBackgroundResource(2130838958);
    this.j = ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
    Intent localIntent = getIntent();
    this.a = localIntent.getIntExtra("param_mode", 0);
    this.b = localIntent.getStringExtra("uin");
    this.c = getIntent().getIntExtra("source_id", 3999);
    this.e = localIntent.getExtras();
    this.l = this.e.getBoolean("isFromWzry", false);
    a(this.c);
    this.app.addObserver(this.w);
    this.app.addObserver(this.x);
    if ((paramBundle == null) || (this.a == 1))
    {
      if ((NetworkUtil.isNetSupport(this)) && (((IAddFriendApi)QRoute.api(IAddFriendApi.class)).shouldReqAutoInfo(this.c, this.b))) {
        ((IFriendHandlerService)this.app.getRuntimeService(IFriendHandlerService.class)).requestAutoInfo(this.b, this.c, getIntent().getIntExtra("sub_source_id", 0));
      }
      getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.y);
    }
    b();
    return true;
  }
  
  public void doOnDestroy()
  {
    Dialog localDialog = this.k;
    if ((localDialog != null) && (localDialog.isShowing()) && (this.k.getWindow() != null)) {}
    try
    {
      this.k.dismiss();
    }
    catch (Throwable localThrowable)
    {
      label36:
      break label36;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this.y);
    } else {
      getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.y);
    }
    super.doOnDestroy();
    this.app.removeObserver(this.w);
    this.app.removeObserver(this.x);
  }
  
  protected boolean onBackEvent()
  {
    setResult(-1);
    finish();
    overridePendingTransition(2130772007, 2130772436);
    return true;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!NetworkUtil.isNetSupport(this))
    {
      QQToast.makeText(this.app.getApp(), 1, getString(2131892157), 0).show(getTitleBarHeight());
      paramCompoundButton.setOnCheckedChangeListener(null);
      paramCompoundButton.setChecked(paramBoolean ^ true);
      paramCompoundButton.setOnCheckedChangeListener(this);
    }
    else
    {
      Object localObject;
      if (paramCompoundButton == this.r)
      {
        localObject = new ArrayList(1);
        ((ArrayList)localObject).add(this.b);
        this.j.gatherContacts((short)1, (List)localObject, paramBoolean);
        if (this.r.isChecked()) {
          ReportController.b(this.app, "CliOper", "", "", "0X8004C59", "0X8004C59", 0, 0, "", "", "", "");
        }
        if ((this.app.getNotAllowedSeeMyDongtai(true)) && (paramBoolean))
        {
          localObject = this.p;
          if (localObject != null) {
            ((Switch)localObject).setChecked(true);
          }
        }
      }
      else if (paramCompoundButton == this.p)
      {
        if (AppSetting.e) {
          this.o.setContentDescription(getResources().getString(2131914894));
        }
        localObject = new Intent("com.tencent.qzone.action.OperateQZonePermission");
        ((Intent)localObject).setPackage(MobileQQ.getContext().getPackageName());
        ((Intent)localObject).putExtra("qzone_permission_uin", this.b);
        ((Intent)localObject).putExtra("qzone_permission_operateType", 1);
        ((Intent)localObject).putExtra("qzone_permission_value", paramBoolean);
        IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
        localPluginParams.g = "QQ空间";
        localPluginParams.d = QzonePluginProxyActivity.getQZonePluginName();
        localPluginParams.c = this.app.getCurrentAccountUin();
        localPluginParams.h = "com.qzone.permissionsetting.business.QZonePermissionReciver";
        localPluginParams.j = ((Intent)localObject);
        IPluginManager.b(this.app.getApp(), localPluginParams);
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    Object localObject;
    if (i1 != 2131436211)
    {
      if (i1 != 2131443801)
      {
        if (i1 != 2131444961)
        {
          setResult(-1);
          finish();
          overridePendingTransition(2130772007, 2130772436);
        }
        else
        {
          localObject = new Intent(this, MoveToGroupActivity.class).putExtra("friendUin", this.b).putExtra("mgid", (byte)this.d);
          ((Intent)localObject).putExtra("PARAM_EXECUTE_IMMEDIATELY", false);
          startActivityForResult((Intent)localObject, 1001);
        }
      }
      else
      {
        localObject = QZoneHelper.UserInfo.getInstance();
        ((QZoneHelper.UserInfo)localObject).qzone_uin = this.app.getCurrentAccountUin();
        ((QZoneHelper.UserInfo)localObject).nickname = this.app.getCurrentNickname();
        QZoneHelper.forwardToSinglePermissionSetting(this, (QZoneHelper.UserInfo)localObject, Long.valueOf(this.b).longValue(), -1);
      }
    }
    else if (!NetworkUtil.isNetSupport(this))
    {
      QQToast.makeText(this.app.getApp(), 1, getString(2131892157), 0).show(getTitleBarHeight());
    }
    else
    {
      showProgressDialog(2131916272, 1000L, true);
      i1 = this.a;
      if (i1 == 0)
      {
        localObject = getIntent();
        int i3 = ((Intent)localObject).getIntExtra("sub_source_id", 0);
        int i2 = ((Intent)localObject).getIntExtra("friend_setting", 0);
        i1 = i2;
        if (i2 == 3) {
          i1 = 100;
        }
        boolean bool = ((Intent)localObject).getBooleanExtra("contact_bothway", false);
        String str = ((Intent)localObject).getStringExtra("src_name");
        ((IFriendHandlerService)this.app.getRuntimeService(IFriendHandlerService.class)).requestAddFriendWithMyCard(this.b, ((Intent)localObject).getStringExtra("extra"), i1, (byte)this.d, ((Intent)localObject).getStringExtra("msg"), this.c, i3, true, ((Intent)localObject).getByteArrayExtra("sig"), bool, this.g.getText().toString(), str, ((Intent)localObject).getByteExtra("show_my_card", (byte)0), "", ((Intent)localObject).getBundleExtra("flc_extra_param"), false);
        if (!((IAddFriendApi)QRoute.api(IAddFriendApi.class)).couldAddFriendSuccessDirectly(i1, this.c, bool)) {
          ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).c(this.b, true);
        }
      }
      else if (i1 == 1)
      {
        showProgressDialog(2131916272, 1000L, true);
        this.f = 0;
        localObject = this.g.getText().toString().trim();
        if (((String)localObject).length() != 0) {
          this.j.setFriendComment(this.b, (String)localObject, false);
        } else {
          this.j.moveFriendToGroup(this.b, (byte)this.d, (byte)0);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AutoRemarkActivity
 * JD-Core Version:    0.7.0.1
 */