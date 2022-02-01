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
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int = -1;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = null;
  protected Handler.Callback a;
  View jdField_a_of_type_AndroidViewView;
  protected ViewGroup a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  PhotoWallViewForAccountDetail.PhotoWallCallback jdField_a_of_type_ComTencentBizPubaccountPhotoWallViewForAccountDetail$PhotoWallCallback = new AccountDetailGroupListContainer.10(this);
  PublicAccountDetailImpl jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl;
  IPublicAccountConfigAttr.PaConfigInfo jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo = null;
  protected PublicAccountObserverImpl a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected NewPublicAccountObserver a;
  protected AvatarObserver a;
  String jdField_a_of_type_JavaLangString;
  WeakReference<BaseActivity> jdField_a_of_type_JavaLangRefWeakReference;
  protected ArrayList<String> a;
  protected MqqHandler a;
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean = true;
  boolean c = true;
  protected boolean d = false;
  protected boolean e = false;
  boolean f = false;
  
  public AccountDetailGroupListContainer(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, PublicAccountDetailImpl paramPublicAccountDetailImpl, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver = null;
    this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new AccountDetailGroupListContainer.21(this);
    this.jdField_a_of_type_AndroidOsHandler$Callback = new AccountDetailGroupListContainer.27(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((BaseActivity)paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl = paramPublicAccountDetailImpl;
    this.jdField_a_of_type_Boolean = paramBoolean;
    c();
    this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountObserverImpl = new PublicAccountObserverImpl();
    this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountObserverImpl.setOnCallback(new AccountDetailGroupListContainer.PublicAccountMoreInfoObserverCallback(this, this));
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountObserverImpl);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    paramContext = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl;
    if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.uin)) && (!TextUtils.isEmpty(paramQQAppInterface.getCurrentUin()))) {
      a(Long.parseLong(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.uin), Long.parseLong(paramQQAppInterface.getCurrentUin()));
    }
    a();
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    paramQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
  }
  
  private View a(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    if (!TextUtils.isEmpty(paramPaConfigInfo.g))
    {
      if (TextUtils.isEmpty(paramPaConfigInfo.f)) {
        return null;
      }
      View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559281, null);
      a(localView, paramPaConfigInfo.i);
      TextView localTextView = (TextView)localView.findViewById(2131378784);
      String str1 = paramPaConfigInfo.jdField_a_of_type_JavaLangString;
      String str2 = paramPaConfigInfo.jdField_b_of_type_JavaLangString;
      if (!TextUtils.isEmpty(str1))
      {
        localTextView.setText(str1);
        localView.setOnClickListener(new AccountDetailGroupListContainer.1(this, paramPaConfigInfo, str2));
        return localView;
      }
    }
    return null;
  }
  
  private View a(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo, int paramInt)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559281, null);
    a(localView, paramPaConfigInfo.i);
    ((TextView)localView.findViewById(2131378784)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131365169)).setText(paramPaConfigInfo.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new AccountDetailGroupListContainer.8(this, paramInt, paramPaConfigInfo));
    return localView;
  }
  
  private ViewGroup a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailGroupListContainer", 2, "createGroupLayout");
    }
    LinearLayout localLinearLayout = new LinearLayout((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    return localLinearLayout;
  }
  
  private ShareActionSheet.Detail a()
  {
    PublicAccountDetailImpl localPublicAccountDetailImpl = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl;
    if (localPublicAccountDetailImpl != null) {
      return new ShareActionSheet.Detail(this.jdField_a_of_type_JavaLangString, localPublicAccountDetailImpl.name, this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.summary);
    }
    return null;
  }
  
  private String a()
  {
    int i = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.accountFlag);
    if ((i != -2) && (i != -5))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=accountCard&puin=");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://share.mp.qq.com/cgi/share.php?uin=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("&account_flag=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.accountFlag);
    localStringBuilder.append("&jumptype=1&card_type=public_account");
    return localStringBuilder.toString();
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "ConfigSvc.getRecvMsgState");
    Object localObject = new GetRecvMsgStateReq();
    ((GetRecvMsgStateReq)localObject).puin = paramLong1;
    ((GetRecvMsgStateReq)localObject).uin = paramLong2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("GetRecvMsgStateReq", localObject);
    localToServiceMsg.setAttributes(localHashMap);
    localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountServlet.class));
    ((NewIntent)localObject).putExtra("cmd", "ConfigSvc.getRecvMsgState");
    ((NewIntent)localObject).putExtra("uin", paramLong1);
    ((NewIntent)localObject).putExtra(ToServiceMsg.class.getName(), localToServiceMsg);
    ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).configNeedHandler((Intent)localObject);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
  }
  
  private void a(View paramView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramView = (ImageView)paramView.findViewById(2131369083);
    paramView.setImageDrawable(URLDrawable.getDrawable(paramString));
    paramView.setVisibility(0);
  }
  
  private void a(ViewGroup paramViewGroup, List<IPublicAccountConfigAttr.PaConfigInfo> paramList)
  {
    PhotoWallViewForAccountDetail localPhotoWallViewForAccountDetail = new PhotoWallViewForAccountDetail((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    localPhotoWallViewForAccountDetail.setPhotoWallCallback(this.jdField_a_of_type_ComTencentBizPubaccountPhotoWallViewForAccountDetail$PhotoWallCallback);
    localPhotoWallViewForAccountDetail.a((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramList);
    localPhotoWallViewForAccountDetail.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    paramViewGroup.addView(localPhotoWallViewForAccountDetail);
  }
  
  private void a(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      int i = paramPaConfigInfo.jdField_d_of_type_Int;
      if ((i != 1) && (i != 2))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693622);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693621);
    }
  }
  
  private void a(String paramString)
  {
    Dialog localDialog = new Dialog((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131756189);
    localDialog.setContentView(2131561033);
    ((TextView)localDialog.findViewById(2131365681)).setVisibility(8);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131365669);
    TextView localTextView2 = (TextView)localDialog.findViewById(2131365667);
    TextView localTextView3 = (TextView)localDialog.findViewById(2131365673);
    localTextView1.setText(paramString);
    localTextView1.setGravity(3);
    localTextView2.setText(2131690728);
    localTextView3.setText(2131691600);
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
    int i = -1;
    if (paramJSONObject.has("retcode")) {
      i = paramJSONObject.optInt("retcode");
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseTribeTroopJsonObject errorCode is ");
      ((StringBuilder)localObject).append(i);
      QLog.d(".troop.troop_reward", 2, ((StringBuilder)localObject).toString());
    }
    if (i == 0)
    {
      localObject = paramJSONObject.optJSONObject("result").optJSONObject("group_bar");
      if (localObject == null) {
        return;
      }
      paramJSONObject = new ArrayList();
      localObject = ((JSONObject)localObject).optJSONArray("group_list");
      int j = ((JSONArray)localObject).length();
      i = j;
      if (j > 3) {
        i = 3;
      }
      j = 0;
      while (j < i)
      {
        paramJSONObject.add(((JSONArray)localObject).optJSONObject(j).optString("code"));
        j += 1;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramJSONObject);
      localObject = (TroopBindPublicAccountMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("mIsAbleBindTroop", this.d);
      localBundle.putStringArrayList("mBindedTroopUins", paramJSONObject);
      ((TroopBindPublicAccountMgr)localObject).a(this.jdField_a_of_type_JavaLangString, localBundle);
      d();
    }
  }
  
  private void a(boolean paramBoolean, LinearLayout paramLinearLayout, JSONArray paramJSONArray)
  {
    int m = paramJSONArray.length();
    if (m <= 0) {
      return;
    }
    int k;
    for (int i = 0; i < 3; i = k)
    {
      k = i + 1;
      if (k > m) {
        return;
      }
      float f1 = this.jdField_a_of_type_Float;
      int j = (int)(6.0F * f1);
      int n = (int)(f1 * 32.0F);
      ImageView localImageView = new ImageView((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(n, n);
      if (i == 2) {
        j = 0;
      }
      localLayoutParams.setMargins(0, 0, j, 0);
      localImageView.setLayoutParams(localLayoutParams);
      try
      {
        if (TextUtils.isEmpty(paramJSONArray.getString(i))) {
          localImageView.setImageResource(2130839553);
        } else {
          localImageView.setImageDrawable(URLDrawable.getDrawable(paramJSONArray.getString(i)));
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
    if ((paramPaConfigInfo.jdField_a_of_type_Int == 3) && ((paramPaConfigInfo.jdField_c_of_type_Int == 3) || (paramPaConfigInfo.jdField_c_of_type_Int == 16) || (paramPaConfigInfo.jdField_c_of_type_Int == 21) || (paramPaConfigInfo.jdField_c_of_type_Int == 13))) {
      return true;
    }
    if (paramPaConfigInfo.jdField_e_of_type_Int == 5) {
      return true;
    }
    return (paramPaConfigInfo.jdField_b_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.followType != 1);
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
    ViewGroup localViewGroup = a();
    if (paramIPublicAccountConfigAttr.getType() == 1)
    {
      localObject = paramIPublicAccountConfigAttr.getConfigs().iterator();
      while (((Iterator)localObject).hasNext())
      {
        IPublicAccountConfigAttr.PaConfigInfo localPaConfigInfo = (IPublicAccountConfigAttr.PaConfigInfo)((Iterator)localObject).next();
        if (TextUtils.isEmpty(localPaConfigInfo.jdField_e_of_type_JavaLangString)) {
          ((Iterator)localObject).remove();
        } else if ((localPaConfigInfo.jdField_b_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.followType != 1)) {
          ((Iterator)localObject).remove();
        }
      }
      if (paramIPublicAccountConfigAttr.getConfigs().size() < 3) {
        return false;
      }
      a(localViewGroup, paramIPublicAccountConfigAttr.getConfigs());
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localViewGroup);
      b(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      return false;
    }
    int i = ((List)localObject).size();
    if (i <= 0) {
      return true;
    }
    if ((paramInt1 > 0) && (i > 0) && (paramBoolean))
    {
      paramIPublicAccountConfigAttr = new View((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      paramIPublicAccountConfigAttr.setLayoutParams(new LinearLayout.LayoutParams(-1, (int)(this.jdField_a_of_type_Float * 9.0F)));
      paramIPublicAccountConfigAttr.setBackgroundColor(Color.parseColor("#f0f0f0"));
      localViewGroup.addView(paramIPublicAccountConfigAttr);
    }
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      if (i > 1)
      {
        if (paramInt2 == 0) {
          paramInt1 = 1;
        } else if (paramInt2 == i - 1) {
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
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localViewGroup);
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailGroupListContainer", 2, "addPublicAccountGroup exit");
    }
    return true;
  }
  
  private View b()
  {
    return ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559042, null);
  }
  
  private View b(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559281, null);
    a(localView, paramPaConfigInfo.i);
    String str = paramPaConfigInfo.h;
    if (str != null)
    {
      str = str.trim();
      if (!Pattern.compile("[\\d-]+?").matcher(str).matches()) {
        return null;
      }
      ((TextView)localView.findViewById(2131378784)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
      localView.setOnClickListener(new AccountDetailGroupListContainer.2(this, str, paramPaConfigInfo));
      return localView;
    }
    return null;
  }
  
  private void b(int paramInt)
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      Toast.makeText(((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getApplicationContext(), paramInt, 0).show();
    }
  }
  
  private void b(ViewGroup paramViewGroup)
  {
    View localView = new View((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    double d1 = this.jdField_a_of_type_Float;
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
    Intent localIntent = new Intent((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), PublicAccountBrowserImpl.class);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())) {
        return;
      }
      paramString = paramString.replace("${puin}", this.jdField_a_of_type_JavaLangString).replace("${uin}", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localIntent.putExtra("url", paramString);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("jumpWebView url=");
        localStringBuilder.append(paramString);
        QLog.d("AccountDetailGroupListContainer", 2, localStringBuilder.toString());
      }
      localIntent.putExtra("puin", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("big_brother_source_key", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId(this.jdField_a_of_type_JavaLangString));
      paramString = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.name;
      if (!TextUtils.isEmpty(paramString)) {
        localIntent.putExtra("source_name", paramString);
      }
      ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity(localIntent);
    }
  }
  
  private View c(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559042, null);
    ((TextView)localView.findViewById(2131365169)).setText(paramPaConfigInfo.jdField_b_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131378784)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    return localView;
  }
  
  private void c(int paramInt)
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if ((localTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView != null))
    {
      if (paramInt == 0)
      {
        localTextView.setText(2131693621);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      if (paramInt == 1)
      {
        localTextView.setText(2131693623);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131693624);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
      }
      if (paramInt == 2)
      {
        localTextView.setText(2131693620);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131693625);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
  }
  
  private void c(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_JavaLangString, "0X8005A27", "0X8005A27", 0, 0, str, "", "", "", false);
  }
  
  private View d(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    if ((paramPaConfigInfo.jdField_a_of_type_JavaLangString.contains(HardCodeUtil.a(2131699963))) && (this.jdField_a_of_type_Boolean)) {
      return null;
    }
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559567, null);
    ((TextView)localView.findViewById(2131378784)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    String str = paramPaConfigInfo.jdField_c_of_type_JavaLangString;
    boolean bool;
    if (!TextUtils.isEmpty(str))
    {
      bool = true;
      localView.findViewById(2131369605).setVisibility(0);
      localView.setOnClickListener(new AccountDetailGroupListContainer.3(this, str, paramPaConfigInfo));
    }
    else
    {
      localView.findViewById(2131369605).setVisibility(8);
      bool = false;
    }
    try
    {
      paramPaConfigInfo = new JSONArray(paramPaConfigInfo.jdField_e_of_type_JavaLangString);
      a(bool, (LinearLayout)localView.findViewById(2131368712), paramPaConfigInfo);
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
  
  private View e(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559281, null);
    a(localView, paramPaConfigInfo.i);
    ((TextView)localView.findViewById(2131378784)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131365169)).setText(paramPaConfigInfo.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new AccountDetailGroupListContainer.4(this, paramPaConfigInfo));
    return localView;
  }
  
  private View f(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559281, null);
    a(localView, paramPaConfigInfo.i);
    ((TextView)localView.findViewById(2131378784)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131365169)).setText(paramPaConfigInfo.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new AccountDetailGroupListContainer.5(this, paramPaConfigInfo));
    return localView;
  }
  
  private View g(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559281, null);
    a(localView, paramPaConfigInfo.i);
    ((TextView)localView.findViewById(2131378784)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131365169)).setText(paramPaConfigInfo.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new AccountDetailGroupListContainer.6(this, paramPaConfigInfo));
    return localView;
  }
  
  private View h(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559281, null);
    a(localView, paramPaConfigInfo.i);
    ((TextView)localView.findViewById(2131378784)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131365169)).setText(paramPaConfigInfo.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new AccountDetailGroupListContainer.7(this, paramPaConfigInfo));
    return localView;
  }
  
  private View i(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559281, null);
    a(localView, paramPaConfigInfo.i);
    String str = paramPaConfigInfo.jdField_c_of_type_JavaLangString;
    ((TextView)localView.findViewById(2131378784)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131365169)).setText(paramPaConfigInfo.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new AccountDetailGroupListContainer.9(this, str, paramPaConfigInfo));
    return localView;
  }
  
  private void i()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl;
    if (localObject != null)
    {
      if (TextUtils.isEmpty(((PublicAccountDetailImpl)localObject).certifiedEnterprise)) {
        return;
      }
      b(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559594, null);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.certifiedWeixin))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.certifiedWeixin);
        ((StringBuilder)localObject).append("\n");
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.certifiedEnterprise);
      localObject = localStringBuilder.toString();
      ((TextView)localView.findViewById(2131364431)).setText((CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
    }
  }
  
  private View j(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131563014, null);
    ((TextView)localView.findViewById(2131365169)).setText(paramPaConfigInfo.jdField_b_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131378784)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    return localView;
  }
  
  private void j()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl;
    if (localObject != null)
    {
      if (TextUtils.isEmpty(((PublicAccountDetailImpl)localObject).summary)) {
        return;
      }
      localObject = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559594, null);
      ((TextView)((View)localObject).findViewById(2131364431)).setText(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.summary);
      ((ImageView)((View)localObject).findViewById(2131369083)).setVisibility(8);
      ((TextView)((View)localObject).findViewById(2131378784)).setText(2131695268);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    }
  }
  
  private View k(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo = paramPaConfigInfo;
    if (paramPaConfigInfo.jdField_e_of_type_Int != 6)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Unhandled ConfigInfo(");
        ((StringBuilder)localObject).append(paramPaConfigInfo.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(paramPaConfigInfo.jdField_c_of_type_Int);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(paramPaConfigInfo.jdField_e_of_type_Int);
        ((StringBuilder)localObject).append(")");
        QLog.d("AccountDetailGroupListContainer", 2, ((StringBuilder)localObject).toString());
      }
      return null;
    }
    paramPaConfigInfo = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131562857, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramPaConfigInfo.findViewById(2131377850));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramPaConfigInfo.findViewById(2131377861));
    ((TextView)paramPaConfigInfo.findViewById(2131378784)).setText(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("public_account_detail_setting_status", 0);
    Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences;
    int i = -10000;
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setting_result_");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.uin);
      localStringBuilder.append("_");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      i = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), -10000);
      localObject = this.jdField_a_of_type_AndroidContentSharedPreferences;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setting_status_");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.uin);
      localStringBuilder.append("_");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      this.jdField_a_of_type_Int = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), -1);
    }
    if (i == 0)
    {
      i = this.jdField_a_of_type_Int;
      if (i > -1)
      {
        this.jdField_b_of_type_Boolean = false;
        c(i);
        paramPaConfigInfo.setOnClickListener(new AccountDetailGroupListContainer.11(this));
        return paramPaConfigInfo;
      }
    }
    a(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo);
    paramPaConfigInfo.setOnClickListener(new AccountDetailGroupListContainer.12(this));
    return paramPaConfigInfo;
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl == null) {
      return;
    }
    new ShareActionSheet(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), a(), 1, a()).a();
  }
  
  private View l(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131562896, null);
    ((TextView)localView.findViewById(2131378784)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    Switch localSwitch = (Switch)localView.findViewById(2131377841);
    if (paramPaConfigInfo.jdField_d_of_type_Int == 1) {
      localSwitch.setChecked(true);
    } else {
      localSwitch.setChecked(false);
    }
    localSwitch.setOnCheckedChangeListener(new AccountDetailGroupListContainer.17(this, paramPaConfigInfo, localSwitch));
    return localView;
  }
  
  private View m(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    if ((this.jdField_a_of_type_Boolean) && (paramPaConfigInfo.jdField_a_of_type_JavaLangString.contains(HardCodeUtil.a(2131699965)))) {
      return null;
    }
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559281, null);
    a(localView, paramPaConfigInfo.i);
    String str = paramPaConfigInfo.jdField_c_of_type_JavaLangString;
    ((TextView)localView.findViewById(2131378784)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131365169)).setText(paramPaConfigInfo.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new AccountDetailGroupListContainer.18(this, str, paramPaConfigInfo));
    return localView;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  void a()
  {
    if (!a()) {
      return;
    }
    Object localObject = ((TroopBindPublicAccountMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).a(this.jdField_a_of_type_JavaLangString);
    if (localObject != null)
    {
      this.d = ((Bundle)localObject).getBoolean("mIsAbleBindTroop", false);
      localObject = ((Bundle)localObject).getStringArrayList("mBindedTroopUins");
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject);
      }
    }
    g();
    h();
  }
  
  void a(int paramInt)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), null);
    localActionSheet.addRadioButton(2131693621, 5, false);
    localActionSheet.addRadioButton(2131693620, 5, false);
    localActionSheet.addRadioButton(2131693623, 5, false);
    if (paramInt == 0) {
      localActionSheet.setRadioButtonChecked(0);
    } else if (paramInt == 1) {
      localActionSheet.setRadioButtonChecked(2);
    } else if (paramInt == 2) {
      localActionSheet.setRadioButtonChecked(1);
    }
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnDismissListener(new AccountDetailGroupListContainer.15(this));
    localActionSheet.setOnButtonClickListener(new AccountDetailGroupListContainer.16(this, localActionSheet));
    if (!localActionSheet.isShowing())
    {
      this.f = false;
      localActionSheet.show();
    }
  }
  
  void a(ViewGroup paramViewGroup)
  {
    if (!a()) {
      return;
    }
    f();
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("addBindedTroopItem:");
      ((StringBuilder)localObject1).append(j);
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append(this.d);
      QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, ((StringBuilder)localObject1).toString());
    }
    if ((j == 0) && (!this.d)) {
      return;
    }
    Object localObject1 = LayoutInflater.from((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    int i = 0;
    localObject1 = ((LayoutInflater)localObject1).inflate(2131559962, paramViewGroup, false);
    LinearLayout localLinearLayout = (LinearLayout)((View)localObject1).findViewById(2131368712);
    Object localObject2 = ((View)localObject1).findViewById(2131365169);
    this.jdField_a_of_type_AndroidViewViewGroup = localLinearLayout;
    Object localObject3;
    if (j == 0)
    {
      localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl;
      if (localObject3 != null) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "connect", "exp_num", 0, 0, "", "", "", ((PublicAccountDetailImpl)localObject3).uin);
      }
      ((View)localObject2).setVisibility(0);
      localLinearLayout.setVisibility(8);
    }
    else
    {
      localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl;
      if (localObject3 != null) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "connect", "exp_grp", 0, 0, "", "", "", ((PublicAccountDetailImpl)localObject3).uin);
      }
      localLinearLayout.setVisibility(0);
      ((View)localObject2).setVisibility(8);
    }
    while (i < j)
    {
      localObject2 = new ImageView((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      int k = (int)(this.jdField_a_of_type_Float * 32.0F);
      localObject3 = new LinearLayout.LayoutParams(k, k);
      ((LinearLayout.LayoutParams)localObject3).leftMargin = ((int)(this.jdField_a_of_type_Float * 6.0F));
      ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      ((ImageView)localObject2).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopFaceDrawable((String)this.jdField_a_of_type_JavaUtilArrayList.get(i)));
      ((ImageView)localObject2).setTag(this.jdField_a_of_type_JavaUtilArrayList.get(i));
      localLinearLayout.addView((View)localObject2);
      i += 1;
    }
    ((View)localObject1).setOnClickListener(new AccountDetailGroupListContainer.19(this, j));
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
    if (paramPaConfigInfo.jdField_a_of_type_Int == 3)
    {
      if (paramPaConfigInfo.jdField_c_of_type_Int == 10)
      {
        this.jdField_a_of_type_AndroidViewView = k(paramPaConfigInfo);
        this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView;
      }
      else if (paramPaConfigInfo.jdField_c_of_type_Int == 7)
      {
        this.jdField_a_of_type_AndroidViewView = a(paramPaConfigInfo);
      }
      else if (paramPaConfigInfo.jdField_c_of_type_Int == 8)
      {
        this.jdField_a_of_type_AndroidViewView = b(paramPaConfigInfo);
      }
      else if (paramPaConfigInfo.jdField_c_of_type_Int == 11)
      {
        this.jdField_a_of_type_AndroidViewView = e(paramPaConfigInfo);
      }
      else if (paramPaConfigInfo.jdField_c_of_type_Int == 20)
      {
        this.jdField_a_of_type_AndroidViewView = f(paramPaConfigInfo);
      }
      else if (paramPaConfigInfo.jdField_c_of_type_Int == 2)
      {
        this.jdField_a_of_type_AndroidViewView = g(paramPaConfigInfo);
      }
      else if (paramPaConfigInfo.jdField_c_of_type_Int == 17)
      {
        this.jdField_a_of_type_AndroidViewView = h(paramPaConfigInfo);
      }
      else if (paramPaConfigInfo.jdField_c_of_type_Int == 19)
      {
        this.jdField_a_of_type_AndroidViewView = a(paramPaConfigInfo, 9);
      }
      else if (paramPaConfigInfo.jdField_c_of_type_Int == 18)
      {
        this.jdField_a_of_type_AndroidViewView = a(paramPaConfigInfo, 10);
      }
      else if (paramPaConfigInfo.jdField_c_of_type_Int == 22)
      {
        this.jdField_a_of_type_AndroidViewView = i(paramPaConfigInfo);
      }
      else if (paramPaConfigInfo.jdField_c_of_type_Int == 24)
      {
        this.jdField_a_of_type_AndroidViewView = j(paramPaConfigInfo);
      }
      else if (QLog.isColorLevel())
      {
        paramViewGroup = new StringBuilder();
        paramViewGroup.append("unhandled event_id: ");
        paramViewGroup.append(paramPaConfigInfo.jdField_c_of_type_Int);
        QLog.d("AccountDetailGroupListContainer", 2, paramViewGroup.toString());
      }
    }
    else if (paramPaConfigInfo.jdField_a_of_type_Int == 1) {
      this.jdField_a_of_type_AndroidViewView = m(paramPaConfigInfo);
    } else if (paramPaConfigInfo.jdField_a_of_type_Int == 2) {
      this.jdField_a_of_type_AndroidViewView = l(paramPaConfigInfo);
    } else if (paramPaConfigInfo.jdField_a_of_type_Int == 4) {
      this.jdField_a_of_type_AndroidViewView = c(paramPaConfigInfo);
    } else if (paramPaConfigInfo.jdField_a_of_type_Int == 5) {
      this.jdField_a_of_type_AndroidViewView = d(paramPaConfigInfo);
    } else {
      this.jdField_a_of_type_AndroidViewView = b();
    }
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130837608);
    float f1 = this.jdField_a_of_type_Float;
    paramInt = (int)(16.0F * f1);
    int i = (int)(f1 * 12.0F);
    if (paramPaConfigInfo.jdField_a_of_type_Int == 4) {
      this.jdField_a_of_type_AndroidViewView.setPadding(paramInt, i, paramInt, i);
    } else if ((paramPaConfigInfo.jdField_a_of_type_Int != 2) && ((paramPaConfigInfo.jdField_a_of_type_Int != 5) || (paramPaConfigInfo.jdField_e_of_type_JavaLangString.equals("[]")))) {
      this.jdField_a_of_type_AndroidViewView.setPadding(paramInt, i, paramInt, i);
    } else {
      this.jdField_a_of_type_AndroidViewView.setPadding(paramInt, 0, paramInt, 0);
    }
    paramViewGroup.addView(this.jdField_a_of_type_AndroidViewView);
    b(paramViewGroup);
  }
  
  void a(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo, int paramInt)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), null);
    localActionSheet.addRadioButton(2131693621, 5, false);
    localActionSheet.addRadioButton(2131693622, 5, false);
    if ((paramInt != 1) && (paramInt != 2)) {
      localActionSheet.setRadioButtonChecked(1);
    } else {
      localActionSheet.setRadioButtonChecked(0);
    }
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnDismissListener(new AccountDetailGroupListContainer.13(this));
    localActionSheet.setOnButtonClickListener(new AccountDetailGroupListContainer.14(this, paramPaConfigInfo, localActionSheet));
    if (!localActionSheet.isShowing())
    {
      this.f = false;
      localActionSheet.show();
    }
  }
  
  void a(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo, Switch paramSwitch)
  {
    int i = paramPaConfigInfo.jdField_d_of_type_Int;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    this.c = false;
    paramSwitch.setChecked(bool);
  }
  
  void a(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo, Switch paramSwitch, boolean paramBoolean)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 0);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    String str2 = HardCodeUtil.a(2131699961);
    String str1 = paramPaConfigInfo.jdField_d_of_type_JavaLangString;
    if (3 == paramPaConfigInfo.jdField_e_of_type_Int) {
      str1 = String.format(((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131692061), new Object[] { this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.name });
    }
    localQQCustomDialog.setTitle(str2);
    localQQCustomDialog.setMessage(str1);
    localQQCustomDialog.setOnCancelListener(new AccountDetailGroupListContainer.25(this, paramPaConfigInfo, paramSwitch));
    paramPaConfigInfo = new AccountDetailGroupListContainer.26(this, paramPaConfigInfo, paramBoolean, paramSwitch);
    localQQCustomDialog.setNegativeButton(HardCodeUtil.a(2131699960), paramPaConfigInfo);
    localQQCustomDialog.setPositiveButton(HardCodeUtil.a(2131699966), paramPaConfigInfo);
    try
    {
      localQQCustomDialog.show();
      return;
    }
    catch (Exception paramPaConfigInfo) {}
  }
  
  void a(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    AccountDetailBaseInfoModel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, paramPaConfigInfo, i);
  }
  
  protected boolean a()
  {
    boolean bool;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl != null) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.accountFlag) != -2)) {
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
  
  public void b()
  {
    PublicAccountObserverImpl localPublicAccountObserverImpl = this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountObserverImpl;
    if (localPublicAccountObserverImpl != null)
    {
      localPublicAccountObserverImpl.onDestroy();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountObserverImpl);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
  }
  
  void c()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getBaseContext());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
    this.jdField_a_of_type_Float = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDisplayMetrics().density;
    d();
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl;
    if (localObject != null)
    {
      List localList = ((PublicAccountDetailImpl)localObject).paConfigAttrs;
      localObject = localList;
      if (localList == null) {
        localObject = ((IPublicAccountConfigAttr)QRoute.api(IPublicAccountConfigAttr.class)).castToPaConfigAttrs(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.newGroupInfoList);
      }
    }
    else
    {
      localObject = null;
    }
    if (localObject != null)
    {
      int j = ((List)localObject).size();
      int i = 0;
      boolean bool2;
      for (boolean bool1 = false; i < j; bool1 = bool2)
      {
        if (((IPublicAccountConfigAttr)((List)localObject).get(i)).getType() != 0)
        {
          bool2 = bool1;
          if (((IPublicAccountConfigAttr)((List)localObject).get(i)).getType() != 1) {}
        }
        else
        {
          bool2 = a((IPublicAccountConfigAttr)((List)localObject).get(i), i, j, bool1);
        }
        i += 1;
      }
    }
    e();
  }
  
  void e()
  {
    a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    j();
    i();
  }
  
  void f()
  {
    if (a())
    {
      Object localObject = ((TroopBindPublicAccountMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).a(this.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        this.d = ((Bundle)localObject).getBoolean("mIsAbleBindTroop", false);
        localObject = ((Bundle)localObject).getStringArrayList("mBindedTroopUins");
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject);
        }
        if (QLog.isColorLevel()) {
          QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, "loadCache, hit cache");
        }
      }
    }
  }
  
  public void g()
  {
    if (!a()) {
      return;
    }
    try
    {
      l = Long.parseLong(this.jdField_a_of_type_JavaLangString);
    }
    catch (Exception localException)
    {
      long l;
      label19:
      Object localObject;
      break label19;
    }
    l = -1L;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getBindedTroops:");
      ((StringBuilder)localObject).append(l);
      QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, ((StringBuilder)localObject).toString());
    }
    if (l == -1L) {
      return;
    }
    localObject = new oidb_0x487.ReqBody();
    ((oidb_0x487.ReqBody)localObject).uint32_channel.set(1);
    ((oidb_0x487.ReqBody)localObject).uint64_subscribe_code.set(l);
    ProtoUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new AccountDetailGroupListContainer.20(this), ((oidb_0x487.ReqBody)localObject).toByteArray(), "OidbSvc.0x487_0", 1159, 0);
  }
  
  public void h()
  {
    if (a())
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl == null) {
        return;
      }
      String str1 = null;
      Object localObject1 = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
      String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (localObject1 != null) {
        str1 = ((TicketManager)localObject1).getSkey(str2);
      }
      Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.name;
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).endsWith(HardCodeUtil.a(2131699967))) {
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
      localBundle.putString("puin", this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.uin);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("uin=");
      ((StringBuilder)localObject1).append(str2);
      ((StringBuilder)localObject1).append(";skey=");
      ((StringBuilder)localObject1).append(str1);
      localBundle.putString("Cookie", ((StringBuilder)localObject1).toString());
      localBundle.putString("Referer", "https://buluo.qq.com/");
      ((HashMap)localObject2).put("BUNDLE", localBundle);
      ((HashMap)localObject2).put("CONTEXT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
      new HttpWebCgiAsyncTask2("https://buluo.qq.com/cgi-bin/bar/qunlist_all", "POST", new AccountDetailGroupListContainer.22(this), 1000, null).a((HashMap)localObject2);
      str1 = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.uin;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "exp_tribechat_data", "exp_tribechat_aio", 0, 0, this.jdField_a_of_type_JavaLangString, str1, "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer
 * JD-Core Version:    0.7.0.1
 */