package com.tencent.biz.pubaccount.accountdetail.view;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.pubaccount.PhotoWallViewForAccountDetail;
import com.tencent.biz.pubaccount.PhotoWallViewForAccountDetail.PhotoWallCallback;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.accountdetail.jce.GetRecvMsgStateReq;
import com.tencent.biz.pubaccount.accountdetail.model.AccountDetailBaseInfoModel;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl;
import com.tencent.biz.pubaccount.api.impl.PublicAccountObserverImpl;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.troopbar.ShareActionSheet;
import com.tencent.biz.troopbar.ShareActionSheet.Detail;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.applets.NewPublicAccountObserver;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Switch;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x487.oidb_0x487.ReqBody;

public class AccountDetailGroupListContainer
{
  protected Handler.Callback A = new AccountDetailGroupListContainer.27(this);
  WeakReference<BaseActivity> a;
  QQAppInterface b;
  View c;
  View d;
  LinearLayout e;
  PublicAccountDetailImpl f;
  String g;
  boolean h = false;
  boolean i = true;
  int j = -1;
  TextView k;
  TextView l;
  IPublicAccountConfigAttr.PaConfigInfo m = null;
  float n;
  boolean o = true;
  protected ArrayList<String> p = new ArrayList();
  protected boolean q = false;
  protected boolean r = false;
  protected ViewGroup s = null;
  protected PublicAccountObserverImpl t;
  protected NewPublicAccountObserver u = null;
  SharedPreferences v = null;
  protected MqqHandler w;
  PhotoWallViewForAccountDetail.PhotoWallCallback x = new AccountDetailGroupListContainer.10(this);
  boolean y = false;
  protected AvatarObserver z = new AccountDetailGroupListContainer.21(this);
  
  public AccountDetailGroupListContainer(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, PublicAccountDetailImpl paramPublicAccountDetailImpl, boolean paramBoolean)
  {
    this.b = paramQQAppInterface;
    this.g = paramString;
    this.a = new WeakReference((BaseActivity)paramContext);
    this.f = paramPublicAccountDetailImpl;
    this.h = paramBoolean;
    d();
    this.t = new PublicAccountObserverImpl();
    this.t.setOnCallback(new AccountDetailGroupListContainer.PublicAccountMoreInfoObserverCallback(this, this));
    paramQQAppInterface.addObserver(this.t);
    paramQQAppInterface.addObserver(this.z);
    paramContext = this.f;
    if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.uin)) && (!TextUtils.isEmpty(paramQQAppInterface.getCurrentUin()))) {
      a(Long.parseLong(this.f.uin), Long.parseLong(paramQQAppInterface.getCurrentUin()));
    }
    a();
    this.w = new CustomHandler(Looper.getMainLooper(), this.A);
    paramQQAppInterface.setHandler(getClass(), this.w);
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.b.getCurrentAccountUin(), "ConfigSvc.getRecvMsgState");
    Object localObject = new GetRecvMsgStateReq();
    ((GetRecvMsgStateReq)localObject).puin = paramLong1;
    ((GetRecvMsgStateReq)localObject).uin = paramLong2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("GetRecvMsgStateReq", localObject);
    localToServiceMsg.setAttributes(localHashMap);
    localObject = new NewIntent(this.b.getApplication(), ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountServlet.class));
    ((NewIntent)localObject).putExtra("cmd", "ConfigSvc.getRecvMsgState");
    ((NewIntent)localObject).putExtra("uin", paramLong1);
    ((NewIntent)localObject).putExtra(ToServiceMsg.class.getName(), localToServiceMsg);
    ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).configNeedHandler((Intent)localObject);
    this.b.startServlet((NewIntent)localObject);
  }
  
  private void a(View paramView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramView = (ImageView)paramView.findViewById(2131436047);
    paramView.setImageDrawable(URLDrawable.getDrawable(paramString));
    paramView.setVisibility(0);
  }
  
  private void a(ViewGroup paramViewGroup, List<IPublicAccountConfigAttr.PaConfigInfo> paramList)
  {
    PhotoWallViewForAccountDetail localPhotoWallViewForAccountDetail = new PhotoWallViewForAccountDetail((Context)this.a.get());
    localPhotoWallViewForAccountDetail.setPhotoWallCallback(this.x);
    localPhotoWallViewForAccountDetail.a((BaseActivity)this.a.get(), paramList);
    localPhotoWallViewForAccountDetail.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    paramViewGroup.addView(localPhotoWallViewForAccountDetail);
  }
  
  private void a(String paramString)
  {
    Dialog localDialog = new Dialog((Context)this.a.get(), 2131953338);
    localDialog.setContentView(2131627374);
    ((TextView)localDialog.findViewById(2131431915)).setVisibility(8);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131431902);
    TextView localTextView2 = (TextView)localDialog.findViewById(2131431900);
    TextView localTextView3 = (TextView)localDialog.findViewById(2131431907);
    localTextView1.setText(paramString);
    localTextView1.setGravity(3);
    localTextView2.setText(2131887648);
    localTextView3.setText(2131888562);
    localDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new AccountDetailGroupListContainer.23(this, localDialog));
    localTextView3.setOnClickListener(new AccountDetailGroupListContainer.24(this, paramString));
    try
    {
      localDialog.show();
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_reward", 2, "parseTribeTroopJsonObject jsonObject is null");
      }
      return;
    }
    int i1 = -1;
    if (paramJSONObject.has("retcode")) {
      i1 = paramJSONObject.optInt("retcode");
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseTribeTroopJsonObject errorCode is ");
      ((StringBuilder)localObject).append(i1);
      QLog.d(".troop.troop_reward", 2, ((StringBuilder)localObject).toString());
    }
    if (i1 == 0)
    {
      localObject = paramJSONObject.optJSONObject("result").optJSONObject("group_bar");
      if (localObject == null) {
        return;
      }
      paramJSONObject = new ArrayList();
      localObject = ((JSONObject)localObject).optJSONArray("group_list");
      int i2 = ((JSONArray)localObject).length();
      i1 = i2;
      if (i2 > 3) {
        i1 = 3;
      }
      i2 = 0;
      while (i2 < i1)
      {
        paramJSONObject.add(((JSONArray)localObject).optJSONObject(i2).optString("code"));
        i2 += 1;
      }
      this.p.clear();
      this.p.addAll(paramJSONObject);
      localObject = (TroopBindPublicAccountMgr)this.b.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("mIsAbleBindTroop", this.q);
      localBundle.putStringArrayList("mBindedTroopUins", paramJSONObject);
      ((TroopBindPublicAccountMgr)localObject).a(this.g, localBundle);
      e();
    }
  }
  
  private void a(boolean paramBoolean, LinearLayout paramLinearLayout, JSONArray paramJSONArray)
  {
    int i4 = paramJSONArray.length();
    if (i4 <= 0) {
      return;
    }
    int i3;
    for (int i1 = 0; i1 < 3; i1 = i3)
    {
      i3 = i1 + 1;
      if (i3 > i4) {
        return;
      }
      float f1 = this.n;
      int i2 = (int)(6.0F * f1);
      int i5 = (int)(f1 * 32.0F);
      ImageView localImageView = new ImageView((Context)this.a.get());
      localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i5, i5);
      if (i1 == 2) {
        i2 = 0;
      }
      localLayoutParams.setMargins(0, 0, i2, 0);
      localImageView.setLayoutParams(localLayoutParams);
      try
      {
        if (TextUtils.isEmpty(paramJSONArray.getString(i1))) {
          localImageView.setImageResource(2130839760);
        } else {
          localImageView.setImageDrawable(URLDrawable.getDrawable(paramJSONArray.getString(i1)));
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      paramLinearLayout.addView(localImageView);
    }
  }
  
  private boolean a(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    if ((paramPaConfigInfo.a == 3) && ((paramPaConfigInfo.e == 3) || (paramPaConfigInfo.e == 16) || (paramPaConfigInfo.e == 21) || (paramPaConfigInfo.e == 13))) {
      return true;
    }
    if (paramPaConfigInfo.g == 5) {
      return true;
    }
    return (paramPaConfigInfo.d == 1) && (this.f.followType != 1);
  }
  
  private boolean a(IPublicAccountConfigAttr paramIPublicAccountConfigAttr, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailGroupListContainer", 2, "addPublicAccountGroup start");
    }
    Object localObject = paramIPublicAccountConfigAttr.getConfigs();
    if (localObject == null) {
      return false;
    }
    ViewGroup localViewGroup = k();
    if (paramIPublicAccountConfigAttr.getType() == 1)
    {
      localObject = paramIPublicAccountConfigAttr.getConfigs().iterator();
      while (((Iterator)localObject).hasNext())
      {
        IPublicAccountConfigAttr.PaConfigInfo localPaConfigInfo = (IPublicAccountConfigAttr.PaConfigInfo)((Iterator)localObject).next();
        if (TextUtils.isEmpty(localPaConfigInfo.k)) {
          ((Iterator)localObject).remove();
        } else if ((localPaConfigInfo.d == 1) && (this.f.followType != 1)) {
          ((Iterator)localObject).remove();
        }
      }
      if (paramIPublicAccountConfigAttr.getConfigs().size() < 3) {
        return false;
      }
      a(localViewGroup, paramIPublicAccountConfigAttr.getConfigs());
      this.e.addView(localViewGroup);
      b(this.e);
      return false;
    }
    int i1 = ((List)localObject).size();
    if (i1 <= 0) {
      return true;
    }
    if ((paramInt1 > 0) && (i1 > 0) && (paramBoolean))
    {
      paramIPublicAccountConfigAttr = new View((Context)this.a.get());
      paramIPublicAccountConfigAttr.setLayoutParams(new LinearLayout.LayoutParams(-1, (int)(this.n * 9.0F)));
      paramIPublicAccountConfigAttr.setBackgroundColor(Color.parseColor("#f0f0f0"));
      localViewGroup.addView(paramIPublicAccountConfigAttr);
    }
    paramInt2 = 0;
    while (paramInt2 < i1)
    {
      if (i1 > 1)
      {
        if (paramInt2 == 0) {
          paramInt1 = 1;
        } else if (paramInt2 == i1 - 1) {
          paramInt1 = 2;
        } else {
          paramInt1 = 3;
        }
      }
      else {
        paramInt1 = 0;
      }
      a(localViewGroup, (IPublicAccountConfigAttr.PaConfigInfo)((List)localObject).get(paramInt2), paramInt1);
      paramInt2 += 1;
    }
    this.e.addView(localViewGroup);
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailGroupListContainer", 2, "addPublicAccountGroup exit");
    }
    return true;
  }
  
  private View b(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    if (!TextUtils.isEmpty(paramPaConfigInfo.m))
    {
      if (TextUtils.isEmpty(paramPaConfigInfo.l)) {
        return null;
      }
      View localView = ((BaseActivity)this.a.get()).getLayoutInflater().inflate(2131625206, null);
      a(localView, paramPaConfigInfo.q);
      TextView localTextView = (TextView)localView.findViewById(2131447463);
      String str1 = paramPaConfigInfo.b;
      String str2 = paramPaConfigInfo.c;
      if (!TextUtils.isEmpty(str1))
      {
        localTextView.setText(str1);
        localView.setOnClickListener(new AccountDetailGroupListContainer.1(this, paramPaConfigInfo, str2));
        return localView;
      }
    }
    return null;
  }
  
  private View b(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo, int paramInt)
  {
    View localView = ((BaseActivity)this.a.get()).getLayoutInflater().inflate(2131625206, null);
    a(localView, paramPaConfigInfo.q);
    ((TextView)localView.findViewById(2131447463)).setText(paramPaConfigInfo.b);
    ((TextView)localView.findViewById(2131431322)).setText(paramPaConfigInfo.c);
    localView.setOnClickListener(new AccountDetailGroupListContainer.8(this, paramInt, paramPaConfigInfo));
    return localView;
  }
  
  private void b(int paramInt)
  {
    WeakReference localWeakReference = this.a;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      Toast.makeText(((BaseActivity)this.a.get()).getApplicationContext(), paramInt, 0).show();
    }
  }
  
  private void b(ViewGroup paramViewGroup)
  {
    View localView = new View((Context)this.a.get());
    double d1 = this.n;
    Double.isNaN(d1);
    localView.setLayoutParams(new LinearLayout.LayoutParams(-1, (int)(d1 * 0.7D)));
    localView.setBackgroundColor(Color.parseColor("#dedfe0"));
    paramViewGroup.addView(localView);
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Intent localIntent = new Intent((Context)this.a.get(), PublicAccountBrowserImpl.class);
    if ((this.b != null) && (!TextUtils.isEmpty(this.g)))
    {
      if (TextUtils.isEmpty(this.b.getAccount())) {
        return;
      }
      paramString = paramString.replace("${puin}", this.g).replace("${uin}", this.b.getAccount());
      localIntent.putExtra("uin", this.b.getCurrentAccountUin());
      localIntent.putExtra("url", paramString);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("jumpWebView url=");
        localStringBuilder.append(paramString);
        QLog.d("AccountDetailGroupListContainer", 2, localStringBuilder.toString());
      }
      localIntent.putExtra("puin", this.g);
      localIntent.putExtra("big_brother_source_key", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId(this.g));
      paramString = this.f.name;
      if (!TextUtils.isEmpty(paramString)) {
        localIntent.putExtra("source_name", paramString);
      }
      ((BaseActivity)this.a.get()).startActivity(localIntent);
    }
  }
  
  private View c(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = ((BaseActivity)this.a.get()).getLayoutInflater().inflate(2131625206, null);
    a(localView, paramPaConfigInfo.q);
    String str = paramPaConfigInfo.n;
    if (str != null)
    {
      str = str.trim();
      if (!Pattern.compile("[\\d-]+?").matcher(str).matches()) {
        return null;
      }
      ((TextView)localView.findViewById(2131447463)).setText(paramPaConfigInfo.b);
      localView.setOnClickListener(new AccountDetailGroupListContainer.2(this, str, paramPaConfigInfo));
      return localView;
    }
    return null;
  }
  
  private void c(int paramInt)
  {
    TextView localTextView = this.k;
    if ((localTextView != null) && (this.l != null))
    {
      if (paramInt == 0)
      {
        localTextView.setText(2131891196);
        this.l.setVisibility(8);
        return;
      }
      if (paramInt == 1)
      {
        localTextView.setText(2131891198);
        this.l.setText(2131891199);
        this.l.setVisibility(0);
        return;
      }
      if (paramInt == 2)
      {
        localTextView.setText(2131891195);
        this.l.setText(2131891200);
        this.l.setVisibility(0);
      }
    }
  }
  
  private void c(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.b, "P_CliOper", "Pb_account_lifeservice", this.g, "0X8005A27", "0X8005A27", 0, 0, str, "", "", "", false);
  }
  
  private View d(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = ((BaseActivity)this.a.get()).getLayoutInflater().inflate(2131624694, null);
    ((TextView)localView.findViewById(2131431322)).setText(paramPaConfigInfo.c);
    ((TextView)localView.findViewById(2131447463)).setText(paramPaConfigInfo.b);
    return localView;
  }
  
  private View e(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    if ((paramPaConfigInfo.b.contains(HardCodeUtil.a(2131898010))) && (this.h)) {
      return null;
    }
    View localView = ((BaseActivity)this.a.get()).getLayoutInflater().inflate(2131625591, null);
    ((TextView)localView.findViewById(2131447463)).setText(paramPaConfigInfo.b);
    String str = paramPaConfigInfo.h;
    boolean bool;
    if (!TextUtils.isEmpty(str))
    {
      bool = true;
      localView.findViewById(2131436713).setVisibility(0);
      localView.setOnClickListener(new AccountDetailGroupListContainer.3(this, str, paramPaConfigInfo));
    }
    else
    {
      localView.findViewById(2131436713).setVisibility(8);
      bool = false;
    }
    try
    {
      paramPaConfigInfo = new JSONArray(paramPaConfigInfo.k);
      a(bool, (LinearLayout)localView.findViewById(2131435625), paramPaConfigInfo);
      return localView;
    }
    catch (JSONException paramPaConfigInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailGroupListContainer", 2, "RICH_PIC_TEXT:pic json error!");
      }
      paramPaConfigInfo.printStackTrace();
    }
    return localView;
  }
  
  private View f(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = ((BaseActivity)this.a.get()).getLayoutInflater().inflate(2131625206, null);
    a(localView, paramPaConfigInfo.q);
    ((TextView)localView.findViewById(2131447463)).setText(paramPaConfigInfo.b);
    ((TextView)localView.findViewById(2131431322)).setText(paramPaConfigInfo.c);
    localView.setOnClickListener(new AccountDetailGroupListContainer.4(this, paramPaConfigInfo));
    return localView;
  }
  
  private View g(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = ((BaseActivity)this.a.get()).getLayoutInflater().inflate(2131625206, null);
    a(localView, paramPaConfigInfo.q);
    ((TextView)localView.findViewById(2131447463)).setText(paramPaConfigInfo.b);
    ((TextView)localView.findViewById(2131431322)).setText(paramPaConfigInfo.c);
    localView.setOnClickListener(new AccountDetailGroupListContainer.5(this, paramPaConfigInfo));
    return localView;
  }
  
  private View h(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = ((BaseActivity)this.a.get()).getLayoutInflater().inflate(2131625206, null);
    a(localView, paramPaConfigInfo.q);
    ((TextView)localView.findViewById(2131447463)).setText(paramPaConfigInfo.b);
    ((TextView)localView.findViewById(2131431322)).setText(paramPaConfigInfo.c);
    localView.setOnClickListener(new AccountDetailGroupListContainer.6(this, paramPaConfigInfo));
    return localView;
  }
  
  private View i(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = ((BaseActivity)this.a.get()).getLayoutInflater().inflate(2131625206, null);
    a(localView, paramPaConfigInfo.q);
    ((TextView)localView.findViewById(2131447463)).setText(paramPaConfigInfo.b);
    ((TextView)localView.findViewById(2131431322)).setText(paramPaConfigInfo.c);
    localView.setOnClickListener(new AccountDetailGroupListContainer.7(this, paramPaConfigInfo));
    return localView;
  }
  
  private View j(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = ((BaseActivity)this.a.get()).getLayoutInflater().inflate(2131625206, null);
    a(localView, paramPaConfigInfo.q);
    String str = paramPaConfigInfo.h;
    ((TextView)localView.findViewById(2131447463)).setText(paramPaConfigInfo.b);
    ((TextView)localView.findViewById(2131431322)).setText(paramPaConfigInfo.c);
    localView.setOnClickListener(new AccountDetailGroupListContainer.9(this, str, paramPaConfigInfo));
    return localView;
  }
  
  private View k(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = ((BaseActivity)this.a.get()).getLayoutInflater().inflate(2131629622, null);
    ((TextView)localView.findViewById(2131431322)).setText(paramPaConfigInfo.c);
    ((TextView)localView.findViewById(2131447463)).setText(paramPaConfigInfo.b);
    return localView;
  }
  
  private ViewGroup k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailGroupListContainer", 2, "createGroupLayout");
    }
    LinearLayout localLinearLayout = new LinearLayout((Context)this.a.get());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    return localLinearLayout;
  }
  
  private View l()
  {
    return ((BaseActivity)this.a.get()).getLayoutInflater().inflate(2131624694, null);
  }
  
  private View l(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    this.m = paramPaConfigInfo;
    if (paramPaConfigInfo.g != 6)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Unhandled ConfigInfo(");
        ((StringBuilder)localObject).append(paramPaConfigInfo.a);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(paramPaConfigInfo.e);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(paramPaConfigInfo.g);
        ((StringBuilder)localObject).append(")");
        QLog.d("AccountDetailGroupListContainer", 2, ((StringBuilder)localObject).toString());
      }
      return null;
    }
    paramPaConfigInfo = ((BaseActivity)this.a.get()).getLayoutInflater().inflate(2131629308, null);
    this.k = ((TextView)paramPaConfigInfo.findViewById(2131446326));
    this.l = ((TextView)paramPaConfigInfo.findViewById(2131446338));
    ((TextView)paramPaConfigInfo.findViewById(2131447463)).setText(this.m.b);
    this.v = this.b.getApp().getSharedPreferences("public_account_detail_setting_status", 0);
    Object localObject = this.v;
    int i1 = -10000;
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setting_result_");
      localStringBuilder.append(this.f.uin);
      localStringBuilder.append("_");
      localStringBuilder.append(this.b.getCurrentAccountUin());
      i1 = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), -10000);
      localObject = this.v;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setting_status_");
      localStringBuilder.append(this.f.uin);
      localStringBuilder.append("_");
      localStringBuilder.append(this.b.getCurrentAccountUin());
      this.j = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), -1);
    }
    if (i1 == 0)
    {
      i1 = this.j;
      if (i1 > -1)
      {
        this.i = false;
        c(i1);
        paramPaConfigInfo.setOnClickListener(new AccountDetailGroupListContainer.11(this));
        return paramPaConfigInfo;
      }
    }
    o(this.m);
    paramPaConfigInfo.setOnClickListener(new AccountDetailGroupListContainer.12(this));
    return paramPaConfigInfo;
  }
  
  private View m(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = ((BaseActivity)this.a.get()).getLayoutInflater().inflate(2131629356, null);
    ((TextView)localView.findViewById(2131447463)).setText(paramPaConfigInfo.b);
    Switch localSwitch = (Switch)localView.findViewById(2131446314);
    if (paramPaConfigInfo.f == 1) {
      localSwitch.setChecked(true);
    } else {
      localSwitch.setChecked(false);
    }
    localSwitch.setOnCheckedChangeListener(new AccountDetailGroupListContainer.17(this, paramPaConfigInfo, localSwitch));
    return localView;
  }
  
  private void m()
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      if (TextUtils.isEmpty(((PublicAccountDetailImpl)localObject).certifiedEnterprise)) {
        return;
      }
      b(this.e);
      View localView = ((BaseActivity)this.a.get()).getLayoutInflater().inflate(2131625623, null);
      if (!TextUtils.isEmpty(this.f.certifiedWeixin))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.f.certifiedWeixin);
        ((StringBuilder)localObject).append("\n");
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(this.f.certifiedEnterprise);
      localObject = localStringBuilder.toString();
      ((TextView)localView.findViewById(2131430462)).setText((CharSequence)localObject);
      this.e.addView(localView);
    }
  }
  
  private View n(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    if ((this.h) && (paramPaConfigInfo.b.contains(HardCodeUtil.a(2131898012)))) {
      return null;
    }
    View localView = ((BaseActivity)this.a.get()).getLayoutInflater().inflate(2131625206, null);
    a(localView, paramPaConfigInfo.q);
    String str = paramPaConfigInfo.h;
    ((TextView)localView.findViewById(2131447463)).setText(paramPaConfigInfo.b);
    ((TextView)localView.findViewById(2131431322)).setText(paramPaConfigInfo.c);
    localView.setOnClickListener(new AccountDetailGroupListContainer.18(this, str, paramPaConfigInfo));
    return localView;
  }
  
  private void n()
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      if (TextUtils.isEmpty(((PublicAccountDetailImpl)localObject).summary)) {
        return;
      }
      localObject = ((BaseActivity)this.a.get()).getLayoutInflater().inflate(2131625623, null);
      ((TextView)((View)localObject).findViewById(2131430462)).setText(this.f.summary);
      ((ImageView)((View)localObject).findViewById(2131436047)).setVisibility(8);
      ((TextView)((View)localObject).findViewById(2131447463)).setText(2131893003);
      this.e.addView((View)localObject);
    }
  }
  
  private String o()
  {
    int i1 = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(this.f.accountFlag);
    if ((i1 != -2) && (i1 != -5))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=accountCard&puin=");
      localStringBuilder.append(this.g);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://share.mp.qq.com/cgi/share.php?uin=");
    localStringBuilder.append(this.g);
    localStringBuilder.append("&account_flag=");
    localStringBuilder.append(this.f.accountFlag);
    localStringBuilder.append("&jumptype=1&card_type=public_account");
    return localStringBuilder.toString();
  }
  
  private void o(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    if (this.k != null)
    {
      int i1 = paramPaConfigInfo.f;
      if ((i1 != 1) && (i1 != 2))
      {
        this.k.setText(2131891197);
        return;
      }
      this.k.setText(2131891196);
    }
  }
  
  private void p()
  {
    if (this.f == null) {
      return;
    }
    new ShareActionSheet(this.b, (BaseActivity)this.a.get(), q(), 1, o()).a();
  }
  
  private ShareActionSheet.Detail q()
  {
    PublicAccountDetailImpl localPublicAccountDetailImpl = this.f;
    if (localPublicAccountDetailImpl != null) {
      return new ShareActionSheet.Detail(this.g, localPublicAccountDetailImpl.name, this.f.summary);
    }
    return null;
  }
  
  void a()
  {
    if (!g()) {
      return;
    }
    Object localObject = ((TroopBindPublicAccountMgr)this.b.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).i(this.g);
    if (localObject != null)
    {
      this.q = ((Bundle)localObject).getBoolean("mIsAbleBindTroop", false);
      localObject = ((Bundle)localObject).getStringArrayList("mBindedTroopUins");
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        this.p.clear();
        this.p.addAll((Collection)localObject);
      }
    }
    i();
    j();
  }
  
  void a(int paramInt)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.c((Context)this.a.get(), null);
    localActionSheet.addRadioButton(2131891196, 5, false);
    localActionSheet.addRadioButton(2131891195, 5, false);
    localActionSheet.addRadioButton(2131891198, 5, false);
    if (paramInt == 0) {
      localActionSheet.setRadioButtonChecked(0);
    } else if (paramInt == 1) {
      localActionSheet.setRadioButtonChecked(2);
    } else if (paramInt == 2) {
      localActionSheet.setRadioButtonChecked(1);
    }
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnDismissListener(new AccountDetailGroupListContainer.15(this));
    localActionSheet.setOnButtonClickListener(new AccountDetailGroupListContainer.16(this, localActionSheet));
    if (!localActionSheet.isShowing())
    {
      this.y = false;
      localActionSheet.show();
    }
  }
  
  void a(ViewGroup paramViewGroup)
  {
    if (!g()) {
      return;
    }
    h();
    int i2 = this.p.size();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("addBindedTroopItem:");
      ((StringBuilder)localObject1).append(i2);
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append(this.q);
      QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, ((StringBuilder)localObject1).toString());
    }
    if ((i2 == 0) && (!this.q)) {
      return;
    }
    Object localObject1 = LayoutInflater.from((Context)this.a.get());
    int i1 = 0;
    localObject1 = ((LayoutInflater)localObject1).inflate(2131626005, paramViewGroup, false);
    LinearLayout localLinearLayout = (LinearLayout)((View)localObject1).findViewById(2131435625);
    Object localObject2 = ((View)localObject1).findViewById(2131431322);
    this.s = localLinearLayout;
    Object localObject3;
    if (i2 == 0)
    {
      localObject3 = this.f;
      if (localObject3 != null) {
        ReportController.b(this.b, "P_CliOper", "Grp_public", "", "connect", "exp_num", 0, 0, "", "", "", ((PublicAccountDetailImpl)localObject3).uin);
      }
      ((View)localObject2).setVisibility(0);
      localLinearLayout.setVisibility(8);
    }
    else
    {
      localObject3 = this.f;
      if (localObject3 != null) {
        ReportController.b(this.b, "P_CliOper", "Grp_public", "", "connect", "exp_grp", 0, 0, "", "", "", ((PublicAccountDetailImpl)localObject3).uin);
      }
      localLinearLayout.setVisibility(0);
      ((View)localObject2).setVisibility(8);
    }
    while (i1 < i2)
    {
      localObject2 = new ImageView((Context)this.a.get());
      int i3 = (int)(this.n * 32.0F);
      localObject3 = new LinearLayout.LayoutParams(i3, i3);
      ((LinearLayout.LayoutParams)localObject3).leftMargin = ((int)(this.n * 6.0F));
      ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      ((ImageView)localObject2).setImageDrawable(this.b.getTroopFaceDrawable((String)this.p.get(i1)));
      ((ImageView)localObject2).setTag(this.p.get(i1));
      localLinearLayout.addView((View)localObject2);
      i1 += 1;
    }
    ((View)localObject1).setOnClickListener(new AccountDetailGroupListContainer.19(this, i2));
    paramViewGroup.addView((View)localObject1);
    b(paramViewGroup);
  }
  
  void a(ViewGroup paramViewGroup, IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailGroupListContainer", 2, "addPublicAccountDetailItem");
    }
    if (a(paramPaConfigInfo)) {
      return;
    }
    if (paramPaConfigInfo.a == 3)
    {
      if (paramPaConfigInfo.e == 10)
      {
        this.c = l(paramPaConfigInfo);
        this.d = this.c;
      }
      else if (paramPaConfigInfo.e == 7)
      {
        this.c = b(paramPaConfigInfo);
      }
      else if (paramPaConfigInfo.e == 8)
      {
        this.c = c(paramPaConfigInfo);
      }
      else if (paramPaConfigInfo.e == 11)
      {
        this.c = f(paramPaConfigInfo);
      }
      else if (paramPaConfigInfo.e == 20)
      {
        this.c = g(paramPaConfigInfo);
      }
      else if (paramPaConfigInfo.e == 2)
      {
        this.c = h(paramPaConfigInfo);
      }
      else if (paramPaConfigInfo.e == 17)
      {
        this.c = i(paramPaConfigInfo);
      }
      else if (paramPaConfigInfo.e == 19)
      {
        this.c = b(paramPaConfigInfo, 9);
      }
      else if (paramPaConfigInfo.e == 18)
      {
        this.c = b(paramPaConfigInfo, 10);
      }
      else if (paramPaConfigInfo.e == 22)
      {
        this.c = j(paramPaConfigInfo);
      }
      else if (paramPaConfigInfo.e == 24)
      {
        this.c = k(paramPaConfigInfo);
      }
      else if (QLog.isColorLevel())
      {
        paramViewGroup = new StringBuilder();
        paramViewGroup.append("unhandled event_id: ");
        paramViewGroup.append(paramPaConfigInfo.e);
        QLog.d("AccountDetailGroupListContainer", 2, paramViewGroup.toString());
      }
    }
    else if (paramPaConfigInfo.a == 1) {
      this.c = n(paramPaConfigInfo);
    } else if (paramPaConfigInfo.a == 2) {
      this.c = m(paramPaConfigInfo);
    } else if (paramPaConfigInfo.a == 4) {
      this.c = d(paramPaConfigInfo);
    } else if (paramPaConfigInfo.a == 5) {
      this.c = e(paramPaConfigInfo);
    } else {
      this.c = l();
    }
    if (this.c == null) {
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.c.setLayoutParams(localLayoutParams);
    this.c.setBackgroundResource(2130837614);
    float f1 = this.n;
    paramInt = (int)(16.0F * f1);
    int i1 = (int)(f1 * 12.0F);
    if (paramPaConfigInfo.a == 4) {
      this.c.setPadding(paramInt, i1, paramInt, i1);
    } else if ((paramPaConfigInfo.a != 2) && ((paramPaConfigInfo.a != 5) || (paramPaConfigInfo.k.equals("[]")))) {
      this.c.setPadding(paramInt, i1, paramInt, i1);
    } else {
      this.c.setPadding(paramInt, 0, paramInt, 0);
    }
    paramViewGroup.addView(this.c);
    b(paramViewGroup);
  }
  
  void a(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo, int paramInt)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.c((Context)this.a.get(), null);
    localActionSheet.addRadioButton(2131891196, 5, false);
    localActionSheet.addRadioButton(2131891197, 5, false);
    if ((paramInt != 1) && (paramInt != 2)) {
      localActionSheet.setRadioButtonChecked(1);
    } else {
      localActionSheet.setRadioButtonChecked(0);
    }
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnDismissListener(new AccountDetailGroupListContainer.13(this));
    localActionSheet.setOnButtonClickListener(new AccountDetailGroupListContainer.14(this, paramPaConfigInfo, localActionSheet));
    if (!localActionSheet.isShowing())
    {
      this.y = false;
      localActionSheet.show();
    }
  }
  
  void a(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo, Switch paramSwitch)
  {
    int i1 = paramPaConfigInfo.f;
    boolean bool = true;
    if (i1 != 1) {
      bool = false;
    }
    this.o = false;
    paramSwitch.setChecked(bool);
  }
  
  void a(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo, Switch paramSwitch, boolean paramBoolean)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a((Context)this.a.get(), 0);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    String str2 = HardCodeUtil.a(2131898008);
    String str1 = paramPaConfigInfo.j;
    if (3 == paramPaConfigInfo.g) {
      str1 = String.format(((BaseActivity)this.a.get()).getString(2131889028), new Object[] { this.f.name });
    }
    localQQCustomDialog.setTitle(str2);
    localQQCustomDialog.setMessage(str1);
    localQQCustomDialog.setOnCancelListener(new AccountDetailGroupListContainer.25(this, paramPaConfigInfo, paramSwitch));
    paramPaConfigInfo = new AccountDetailGroupListContainer.26(this, paramPaConfigInfo, paramBoolean, paramSwitch);
    localQQCustomDialog.setNegativeButton(HardCodeUtil.a(2131898212), paramPaConfigInfo);
    localQQCustomDialog.setPositiveButton(HardCodeUtil.a(2131899883), paramPaConfigInfo);
    try
    {
      localQQCustomDialog.show();
      return;
    }
    catch (Exception paramPaConfigInfo) {}
  }
  
  void a(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo, boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    AccountDetailBaseInfoModel.a(this.b, this.g, paramPaConfigInfo, i1);
  }
  
  public void b()
  {
    PublicAccountObserverImpl localPublicAccountObserverImpl = this.t;
    if (localPublicAccountObserverImpl != null)
    {
      localPublicAccountObserverImpl.onDestroy();
      this.b.removeObserver(this.t);
    }
    this.b.removeObserver(this.u);
    this.b.removeObserver(this.z);
  }
  
  public View c()
  {
    return this.e;
  }
  
  void d()
  {
    this.e = new LinearLayout(((BaseActivity)this.a.get()).getBaseContext());
    this.e.setOrientation(1);
    this.e.setBackgroundColor(Color.parseColor("#FFFFFF"));
    this.n = ((BaseActivity)this.a.get()).getResources().getDisplayMetrics().density;
    e();
  }
  
  public void e()
  {
    this.e.removeAllViews();
    Object localObject = this.f;
    if (localObject != null)
    {
      List localList = ((PublicAccountDetailImpl)localObject).paConfigAttrs;
      localObject = localList;
      if (localList == null) {
        localObject = ((IPublicAccountConfigAttr)QRoute.api(IPublicAccountConfigAttr.class)).castToPaConfigAttrs(this.f.newGroupInfoList);
      }
    }
    else
    {
      localObject = null;
    }
    if (localObject != null)
    {
      int i2 = ((List)localObject).size();
      int i1 = 0;
      boolean bool2;
      for (boolean bool1 = false; i1 < i2; bool1 = bool2)
      {
        if (((IPublicAccountConfigAttr)((List)localObject).get(i1)).getType() != 0)
        {
          bool2 = bool1;
          if (((IPublicAccountConfigAttr)((List)localObject).get(i1)).getType() != 1) {}
        }
        else
        {
          bool2 = a((IPublicAccountConfigAttr)((List)localObject).get(i1), i1, i2, bool1);
        }
        i1 += 1;
      }
    }
    f();
  }
  
  void f()
  {
    a(this.e);
    n();
    m();
  }
  
  protected boolean g()
  {
    boolean bool;
    if ((this.f != null) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(this.f.accountFlag) != -2)) {
      bool = false;
    } else {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("needShowBindTroopItem:");
      localStringBuilder.append(bool);
      QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  void h()
  {
    if (g())
    {
      Object localObject = ((TroopBindPublicAccountMgr)this.b.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).i(this.g);
      if (localObject != null)
      {
        this.q = ((Bundle)localObject).getBoolean("mIsAbleBindTroop", false);
        localObject = ((Bundle)localObject).getStringArrayList("mBindedTroopUins");
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          this.p.clear();
          this.p.addAll((Collection)localObject);
        }
        if (QLog.isColorLevel()) {
          QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, "loadCache, hit cache");
        }
      }
    }
  }
  
  public void i()
  {
    if (!g()) {
      return;
    }
    try
    {
      l1 = Long.parseLong(this.g);
    }
    catch (Exception localException)
    {
      long l1;
      label19:
      Object localObject;
      break label19;
    }
    l1 = -1L;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getBindedTroops:");
      ((StringBuilder)localObject).append(l1);
      QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, ((StringBuilder)localObject).toString());
    }
    if (l1 == -1L) {
      return;
    }
    localObject = new oidb_0x487.ReqBody();
    ((oidb_0x487.ReqBody)localObject).uint32_channel.set(1);
    ((oidb_0x487.ReqBody)localObject).uint64_subscribe_code.set(l1);
    ProtoUtils.b(this.b, new AccountDetailGroupListContainer.20(this), ((oidb_0x487.ReqBody)localObject).toByteArray(), "OidbSvc.0x487_0", 1159, 0);
  }
  
  public void j()
  {
    if (g())
    {
      if (this.f == null) {
        return;
      }
      String str1 = null;
      Object localObject1 = (TicketManager)this.b.getManager(2);
      String str2 = this.b.getCurrentAccountUin();
      if (localObject1 != null) {
        str1 = ((TicketManager)localObject1).getSkey(str2);
      }
      Object localObject2 = this.f.name;
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).endsWith(HardCodeUtil.a(2131898013))) {
          localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 3);
        }
      }
      localObject2 = new HashMap();
      Bundle localBundle = new Bundle();
      localBundle.putString("bid", "0");
      localBundle.putString("keyword", (String)localObject1);
      localBundle.putString("ver", "1");
      localBundle.putString("from", "1");
      localBundle.putString("link", "0");
      localBundle.putString("puin", this.f.uin);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("uin=");
      ((StringBuilder)localObject1).append(str2);
      ((StringBuilder)localObject1).append(";skey=");
      ((StringBuilder)localObject1).append(str1);
      localBundle.putString("Cookie", ((StringBuilder)localObject1).toString());
      localBundle.putString("Referer", "https://buluo.qq.com/");
      ((HashMap)localObject2).put("BUNDLE", localBundle);
      ((HashMap)localObject2).put("CONTEXT", this.b.getApp().getApplicationContext());
      new HttpWebCgiAsyncTask2("https://buluo.qq.com/cgi-bin/bar/qunlist_all", "POST", new AccountDetailGroupListContainer.22(this), 1000, null).a((HashMap)localObject2);
      str1 = this.f.uin;
      ReportController.b(this.b, "dc00899", "Grp_tribe", "", "exp_tribechat_data", "exp_tribechat_aio", 0, 0, this.g, str1, "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer
 * JD-Core Version:    0.7.0.1
 */