package com.tencent.biz.pubaccount.AccountDetail.view;

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
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.pubaccount.AccountDetail.jce.GetRecvMsgStateReq;
import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailBaseInfoModel;
import com.tencent.biz.pubaccount.PaConfigAttr;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.PhotoWallViewForAccountDetail;
import com.tencent.biz.pubaccount.PhotoWallViewForAccountDetail.PhotoWallCallback;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl;
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
import com.tencent.mobileqq.data.AccountDetail;
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
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
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
  protected AccountDetailGroupListContainer.PublicAccountMoreInfoObserver a;
  PaConfigAttr.PaConfigInfo jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo = null;
  PhotoWallViewForAccountDetail.PhotoWallCallback jdField_a_of_type_ComTencentBizPubaccountPhotoWallViewForAccountDetail$PhotoWallCallback = new AccountDetailGroupListContainer.10(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected NewPublicAccountObserver a;
  protected AvatarObserver a;
  AccountDetail jdField_a_of_type_ComTencentMobileqqDataAccountDetail;
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
  
  public AccountDetailGroupListContainer(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, AccountDetail paramAccountDetail, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer$PublicAccountMoreInfoObserver = null;
    this.jdField_a_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver = null;
    this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new AccountDetailGroupListContainer.21(this);
    this.jdField_a_of_type_AndroidOsHandler$Callback = new AccountDetailGroupListContainer.27(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((BaseActivity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = paramAccountDetail;
    this.jdField_a_of_type_Boolean = paramBoolean;
    c();
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer$PublicAccountMoreInfoObserver = new AccountDetailGroupListContainer.PublicAccountMoreInfoObserver(this, this);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer$PublicAccountMoreInfoObserver);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin)) && (!TextUtils.isEmpty(paramQQAppInterface.getCurrentUin()))) {
      a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin), Long.parseLong(paramQQAppInterface.getCurrentUin()));
    }
    a();
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    paramQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
  }
  
  private View a(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    if ((TextUtils.isEmpty(paramPaConfigInfo.g)) || (TextUtils.isEmpty(paramPaConfigInfo.f))) {
      return null;
    }
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559406, null);
    a(localView, paramPaConfigInfo.i);
    TextView localTextView = (TextView)localView.findViewById(2131379432);
    String str1 = paramPaConfigInfo.jdField_a_of_type_JavaLangString;
    String str2 = paramPaConfigInfo.jdField_b_of_type_JavaLangString;
    if (!TextUtils.isEmpty(str1))
    {
      localTextView.setText(str1);
      localView.setOnClickListener(new AccountDetailGroupListContainer.1(this, paramPaConfigInfo, str2));
      return localView;
    }
    return null;
  }
  
  private View a(PaConfigAttr.PaConfigInfo paramPaConfigInfo, int paramInt)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559406, null);
    a(localView, paramPaConfigInfo.i);
    ((TextView)localView.findViewById(2131379432)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131365294)).setText(paramPaConfigInfo.jdField_b_of_type_JavaLangString);
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
    ShareActionSheet.Detail localDetail = null;
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      localDetail = new ShareActionSheet.Detail(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary);
    }
    return localDetail;
  }
  
  private String a()
  {
    int i = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag);
    if ((i == -2) || (i == -5)) {
      return "https://share.mp.qq.com/cgi/share.php?uin=" + this.jdField_a_of_type_JavaLangString + "&account_flag=" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag + "&jumptype=1&card_type=public_account";
    }
    return "https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=accountCard&puin=" + this.jdField_a_of_type_JavaLangString;
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
    paramView = (ImageView)paramView.findViewById(2131369351);
    paramView.setImageDrawable(URLDrawable.getDrawable(paramString));
    paramView.setVisibility(0);
  }
  
  private void a(ViewGroup paramViewGroup, List<PaConfigAttr.PaConfigInfo> paramList)
  {
    PhotoWallViewForAccountDetail localPhotoWallViewForAccountDetail = new PhotoWallViewForAccountDetail((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    localPhotoWallViewForAccountDetail.setPhotoWallCallback(this.jdField_a_of_type_ComTencentBizPubaccountPhotoWallViewForAccountDetail$PhotoWallCallback);
    localPhotoWallViewForAccountDetail.a((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramList);
    localPhotoWallViewForAccountDetail.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    paramViewGroup.addView(localPhotoWallViewForAccountDetail);
  }
  
  private void a(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      int i = paramPaConfigInfo.jdField_d_of_type_Int;
      if ((i == 1) || (i == 2)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693668);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693669);
  }
  
  private void a(String paramString)
  {
    ReportDialog localReportDialog = new ReportDialog((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131755842);
    localReportDialog.setContentView(2131561170);
    ((TextView)localReportDialog.findViewById(2131365845)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365832);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365830);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131365836);
    localTextView1.setText(paramString);
    localTextView1.setGravity(3);
    localTextView2.setText(2131690800);
    localTextView3.setText(2131691678);
    localReportDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new AccountDetailGroupListContainer.23(this, localReportDialog));
    localTextView3.setOnClickListener(new AccountDetailGroupListContainer.24(this, paramString));
    try
    {
      localReportDialog.show();
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_reward", 2, "parseTribeTroopJsonObject jsonObject is null");
      }
    }
    do
    {
      do
      {
        return;
        i = -1;
        if (paramJSONObject.has("retcode")) {
          i = paramJSONObject.optInt("retcode");
        }
        if (QLog.isColorLevel()) {
          QLog.d(".troop.troop_reward", 2, "parseTribeTroopJsonObject errorCode is " + i);
        }
      } while (i != 0);
      localObject = paramJSONObject.optJSONObject("result").optJSONObject("group_bar");
    } while (localObject == null);
    paramJSONObject = new ArrayList();
    Object localObject = ((JSONObject)localObject).optJSONArray("group_list");
    int j = ((JSONArray)localObject).length();
    int i = j;
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
  
  private void a(boolean paramBoolean, LinearLayout paramLinearLayout, JSONArray paramJSONArray)
  {
    int k = paramJSONArray.length();
    if (k <= 0) {
      return;
    }
    int i = 0;
    while ((i < 3) && (i + 1 <= k))
    {
      int j = (int)(6.0F * this.jdField_a_of_type_Float);
      int m = (int)(32.0F * this.jdField_a_of_type_Float);
      ImageView localImageView = new ImageView((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(m, m);
      if (i == 2)
      {
        j = 0;
        label101:
        localLayoutParams.setMargins(0, 0, j, 0);
        localImageView.setLayoutParams(localLayoutParams);
      }
      try
      {
        if (TextUtils.isEmpty(paramJSONArray.getString(i))) {
          localImageView.setImageResource(2130839695);
        }
        for (;;)
        {
          paramLinearLayout.addView(localImageView);
          i += 1;
          break;
          break label101;
          localImageView.setImageDrawable(URLDrawable.getDrawable(paramJSONArray.getString(i)));
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  private boolean a(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    if ((paramPaConfigInfo.jdField_a_of_type_Int == 3) && ((paramPaConfigInfo.jdField_c_of_type_Int == 3) || (paramPaConfigInfo.jdField_c_of_type_Int == 16) || (paramPaConfigInfo.jdField_c_of_type_Int == 21) || (paramPaConfigInfo.jdField_c_of_type_Int == 13))) {}
    while ((paramPaConfigInfo.jdField_e_of_type_Int == 5) || ((paramPaConfigInfo.jdField_b_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType != 1))) {
      return true;
    }
    return false;
  }
  
  private boolean a(PaConfigAttr paramPaConfigAttr, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailGroupListContainer", 2, "addPublicAccountGroup start");
    }
    Object localObject = paramPaConfigAttr.jdField_a_of_type_JavaUtilList;
    if (localObject == null) {}
    ViewGroup localViewGroup;
    do
    {
      return false;
      localViewGroup = a();
      if (paramPaConfigAttr.jdField_a_of_type_Int != 1) {
        break;
      }
      localObject = paramPaConfigAttr.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        PaConfigAttr.PaConfigInfo localPaConfigInfo = (PaConfigAttr.PaConfigInfo)((Iterator)localObject).next();
        if (TextUtils.isEmpty(localPaConfigInfo.jdField_e_of_type_JavaLangString)) {
          ((Iterator)localObject).remove();
        } else if ((localPaConfigInfo.jdField_b_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType != 1)) {
          ((Iterator)localObject).remove();
        }
      }
    } while (paramPaConfigAttr.jdField_a_of_type_JavaUtilList.size() < 3);
    a(localViewGroup, paramPaConfigAttr.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localViewGroup);
    b(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    return false;
    int i = ((List)localObject).size();
    if (i <= 0) {
      return true;
    }
    if ((paramInt1 > 0) && (i > 0) && (paramBoolean))
    {
      paramPaConfigAttr = new View((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      paramPaConfigAttr.setLayoutParams(new LinearLayout.LayoutParams(-1, (int)(9.0F * this.jdField_a_of_type_Float)));
      paramPaConfigAttr.setBackgroundColor(Color.parseColor("#f0f0f0"));
      localViewGroup.addView(paramPaConfigAttr);
    }
    paramInt2 = 0;
    if (paramInt2 < i)
    {
      if (i > 1) {
        if (paramInt2 == 0) {
          paramInt1 = 1;
        }
      }
      for (;;)
      {
        a(localViewGroup, (PaConfigAttr.PaConfigInfo)((List)localObject).get(paramInt2), paramInt1);
        paramInt2 += 1;
        break;
        if (paramInt2 == i - 1)
        {
          paramInt1 = 2;
        }
        else
        {
          paramInt1 = 3;
          continue;
          paramInt1 = 0;
        }
      }
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localViewGroup);
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailGroupListContainer", 2, "addPublicAccountGroup exit");
    }
    return true;
  }
  
  private View b()
  {
    return ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559148, null);
  }
  
  private View b(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559406, null);
    a(localView, paramPaConfigInfo.i);
    String str = paramPaConfigInfo.h;
    if (str != null)
    {
      str = str.trim();
      if (!Pattern.compile("[\\d-]+?").matcher(str).matches()) {
        return null;
      }
    }
    else
    {
      return null;
    }
    ((TextView)localView.findViewById(2131379432)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    localView.setOnClickListener(new AccountDetailGroupListContainer.2(this, str, paramPaConfigInfo));
    return localView;
  }
  
  private void b(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      Toast.makeText(((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getApplicationContext(), paramInt, 0).show();
    }
  }
  
  private void b(ViewGroup paramViewGroup)
  {
    View localView = new View((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    localView.setLayoutParams(new LinearLayout.LayoutParams(-1, (int)(0.7D * this.jdField_a_of_type_Float)));
    localView.setBackgroundColor(Color.parseColor("#dedfe0"));
    paramViewGroup.addView(localView);
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Intent localIntent;
    do
    {
      return;
      localIntent = new Intent((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), PublicAccountBrowserImpl.class);
    } while ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())));
    paramString = paramString.replace("${puin}", this.jdField_a_of_type_JavaLangString).replace("${uin}", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localIntent.putExtra("url", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailGroupListContainer", 2, "jumpWebView url=" + paramString);
    }
    localIntent.putExtra("puin", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("big_brother_source_key", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId(this.jdField_a_of_type_JavaLangString));
    paramString = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name;
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("source_name", paramString);
    }
    ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity(localIntent);
  }
  
  private View c(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559148, null);
    ((TextView)localView.findViewById(2131365294)).setText(paramPaConfigInfo.jdField_b_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131379432)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    return localView;
  }
  
  private void c(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView != null))
    {
      if (paramInt != 0) {
        break label38;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693668);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    label38:
    do
    {
      return;
      if (paramInt == 1)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693670);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131693671);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
      }
    } while (paramInt != 2);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693667);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131693672);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  private void c(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_JavaLangString, "0X8005A27", "0X8005A27", 0, 0, paramString, "", "", "", false);
      return;
    }
  }
  
  private View d(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    boolean bool = false;
    if ((paramPaConfigInfo.jdField_a_of_type_JavaLangString.contains(HardCodeUtil.a(2131699822))) && (this.jdField_a_of_type_Boolean)) {
      return null;
    }
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559690, null);
    ((TextView)localView.findViewById(2131379432)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    String str = paramPaConfigInfo.jdField_c_of_type_JavaLangString;
    if (!TextUtils.isEmpty(str))
    {
      localView.findViewById(2131369920).setVisibility(0);
      localView.setOnClickListener(new AccountDetailGroupListContainer.3(this, str, paramPaConfigInfo));
      bool = true;
    }
    try
    {
      for (;;)
      {
        paramPaConfigInfo = new JSONArray(paramPaConfigInfo.jdField_e_of_type_JavaLangString);
        a(bool, (LinearLayout)localView.findViewById(2131368990), paramPaConfigInfo);
        return localView;
        localView.findViewById(2131369920).setVisibility(8);
      }
    }
    catch (JSONException paramPaConfigInfo)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AccountDetailGroupListContainer", 2, "RICH_PIC_TEXT:pic json error!");
        }
        paramPaConfigInfo.printStackTrace();
      }
    }
  }
  
  private View e(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559406, null);
    a(localView, paramPaConfigInfo.i);
    ((TextView)localView.findViewById(2131379432)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131365294)).setText(paramPaConfigInfo.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new AccountDetailGroupListContainer.4(this, paramPaConfigInfo));
    return localView;
  }
  
  private View f(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559406, null);
    a(localView, paramPaConfigInfo.i);
    ((TextView)localView.findViewById(2131379432)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131365294)).setText(paramPaConfigInfo.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new AccountDetailGroupListContainer.5(this, paramPaConfigInfo));
    return localView;
  }
  
  private View g(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559406, null);
    a(localView, paramPaConfigInfo.i);
    ((TextView)localView.findViewById(2131379432)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131365294)).setText(paramPaConfigInfo.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new AccountDetailGroupListContainer.6(this, paramPaConfigInfo));
    return localView;
  }
  
  private View h(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559406, null);
    a(localView, paramPaConfigInfo.i);
    ((TextView)localView.findViewById(2131379432)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131365294)).setText(paramPaConfigInfo.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new AccountDetailGroupListContainer.7(this, paramPaConfigInfo));
    return localView;
  }
  
  private View i(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559406, null);
    a(localView, paramPaConfigInfo.i);
    String str = paramPaConfigInfo.jdField_c_of_type_JavaLangString;
    ((TextView)localView.findViewById(2131379432)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131365294)).setText(paramPaConfigInfo.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new AccountDetailGroupListContainer.9(this, str, paramPaConfigInfo));
    return localView;
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedEnterprise))) {
      return;
    }
    b(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559718, null);
    String str = "";
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedWeixin)) {
      str = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedWeixin + "\n";
    }
    str = str + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedEnterprise;
    ((TextView)localView.findViewById(2131364543)).setText(str);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
  }
  
  private View j(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131563191, null);
    ((TextView)localView.findViewById(2131365294)).setText(paramPaConfigInfo.jdField_b_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131379432)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    return localView;
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary))) {
      return;
    }
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559718, null);
    ((TextView)localView.findViewById(2131364543)).setText(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary);
    ((ImageView)localView.findViewById(2131369351)).setVisibility(8);
    ((TextView)localView.findViewById(2131379432)).setText(2131695265);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
  }
  
  private View k(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo = paramPaConfigInfo;
    if (paramPaConfigInfo.jdField_e_of_type_Int != 6)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailGroupListContainer", 2, "Unhandled ConfigInfo(" + paramPaConfigInfo.jdField_a_of_type_Int + ", " + paramPaConfigInfo.jdField_c_of_type_Int + ", " + paramPaConfigInfo.jdField_e_of_type_Int + ")");
      }
      return null;
    }
    paramPaConfigInfo = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131563034, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramPaConfigInfo.findViewById(2131378436));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramPaConfigInfo.findViewById(2131378447));
    ((TextView)paramPaConfigInfo.findViewById(2131379432)).setText(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("public_account_detail_setting_status", 0);
    int i;
    if (this.jdField_a_of_type_AndroidContentSharedPreferences != null)
    {
      i = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("setting_result_" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin + "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), -10000);
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("setting_status_" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin + "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), -1);
    }
    for (;;)
    {
      if ((i == 0) && (this.jdField_a_of_type_Int > -1))
      {
        this.jdField_b_of_type_Boolean = false;
        c(this.jdField_a_of_type_Int);
        paramPaConfigInfo.setOnClickListener(new AccountDetailGroupListContainer.11(this));
      }
      for (;;)
      {
        return paramPaConfigInfo;
        a(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo);
        paramPaConfigInfo.setOnClickListener(new AccountDetailGroupListContainer.12(this));
      }
      i = -10000;
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {
      return;
    }
    new ShareActionSheet(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), a(), 1, a()).a();
  }
  
  private View l(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131563071, null);
    ((TextView)localView.findViewById(2131379432)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    Switch localSwitch = (Switch)localView.findViewById(2131378428);
    if (paramPaConfigInfo.jdField_d_of_type_Int == 1) {
      localSwitch.setChecked(true);
    }
    for (;;)
    {
      localSwitch.setOnCheckedChangeListener(new AccountDetailGroupListContainer.17(this, paramPaConfigInfo, localSwitch));
      return localView;
      localSwitch.setChecked(false);
    }
  }
  
  private View m(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    if ((this.jdField_a_of_type_Boolean) && (paramPaConfigInfo.jdField_a_of_type_JavaLangString.contains(HardCodeUtil.a(2131699824)))) {
      return null;
    }
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559406, null);
    a(localView, paramPaConfigInfo.i);
    String str = paramPaConfigInfo.jdField_c_of_type_JavaLangString;
    ((TextView)localView.findViewById(2131379432)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131365294)).setText(paramPaConfigInfo.jdField_b_of_type_JavaLangString);
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
    localActionSheet.addRadioButton(2131693668, 5, false);
    localActionSheet.addRadioButton(2131693667, 5, false);
    localActionSheet.addRadioButton(2131693670, 5, false);
    if (paramInt == 0) {
      localActionSheet.setRadioButtonChecked(0);
    }
    for (;;)
    {
      localActionSheet.addCancelButton(2131690800);
      localActionSheet.setOnDismissListener(new AccountDetailGroupListContainer.15(this));
      localActionSheet.setOnButtonClickListener(new AccountDetailGroupListContainer.16(this, localActionSheet));
      if (!localActionSheet.isShowing())
      {
        this.f = false;
        localActionSheet.show();
      }
      return;
      if (paramInt == 1) {
        localActionSheet.setRadioButtonChecked(2);
      } else if (paramInt == 2) {
        localActionSheet.setRadioButtonChecked(1);
      }
    }
  }
  
  void a(ViewGroup paramViewGroup)
  {
    if (!a()) {}
    int j;
    do
    {
      return;
      f();
      j = this.jdField_a_of_type_JavaUtilArrayList.size();
      if (QLog.isColorLevel()) {
        QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, "addBindedTroopItem:" + j + "," + this.d);
      }
    } while ((j == 0) && (!this.d));
    View localView = LayoutInflater.from((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).inflate(2131560091, paramViewGroup, false);
    LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131368990);
    Object localObject = localView.findViewById(2131365294);
    this.jdField_a_of_type_AndroidViewViewGroup = localLinearLayout;
    if (j == 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "connect", "exp_num", 0, 0, "", "", "", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
      }
      ((View)localObject).setVisibility(0);
      localLinearLayout.setVisibility(8);
    }
    for (;;)
    {
      int i = 0;
      while (i < j)
      {
        localObject = new ImageView((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
        int k = (int)(32.0F * this.jdField_a_of_type_Float);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(k, k);
        localLayoutParams.leftMargin = ((int)(6.0F * this.jdField_a_of_type_Float));
        ((ImageView)localObject).setLayoutParams(localLayoutParams);
        ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopFaceDrawable((String)this.jdField_a_of_type_JavaUtilArrayList.get(i)));
        ((ImageView)localObject).setTag(this.jdField_a_of_type_JavaUtilArrayList.get(i));
        localLinearLayout.addView((View)localObject);
        i += 1;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "connect", "exp_grp", 0, 0, "", "", "", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
      }
      localLinearLayout.setVisibility(0);
      ((View)localObject).setVisibility(8);
    }
    localView.setOnClickListener(new AccountDetailGroupListContainer.19(this, j));
    paramViewGroup.addView(localView);
    b(paramViewGroup);
  }
  
  void a(ViewGroup paramViewGroup, PaConfigAttr.PaConfigInfo paramPaConfigInfo, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailGroupListContainer", 2, "addPublicAccountDetailItem");
    }
    if (a(paramPaConfigInfo)) {
      return;
    }
    label58:
    int i;
    if (paramPaConfigInfo.jdField_a_of_type_Int == 3) {
      if (paramPaConfigInfo.jdField_c_of_type_Int == 10)
      {
        this.jdField_a_of_type_AndroidViewView = k(paramPaConfigInfo);
        this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView;
        if (this.jdField_a_of_type_AndroidViewView == null) {
          break label490;
        }
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130837521);
        paramInt = (int)(16.0F * this.jdField_a_of_type_Float);
        i = (int)(12.0F * this.jdField_a_of_type_Float);
        if (paramPaConfigInfo.jdField_a_of_type_Int != 4) {
          break label492;
        }
        this.jdField_a_of_type_AndroidViewView.setPadding(paramInt, i, paramInt, i);
      }
    }
    for (;;)
    {
      paramViewGroup.addView(this.jdField_a_of_type_AndroidViewView);
      b(paramViewGroup);
      return;
      if (paramPaConfigInfo.jdField_c_of_type_Int == 7)
      {
        this.jdField_a_of_type_AndroidViewView = a(paramPaConfigInfo);
        break label58;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 8)
      {
        this.jdField_a_of_type_AndroidViewView = b(paramPaConfigInfo);
        break label58;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 11)
      {
        this.jdField_a_of_type_AndroidViewView = e(paramPaConfigInfo);
        break label58;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 20)
      {
        this.jdField_a_of_type_AndroidViewView = f(paramPaConfigInfo);
        break label58;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 2)
      {
        this.jdField_a_of_type_AndroidViewView = g(paramPaConfigInfo);
        break label58;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 17)
      {
        this.jdField_a_of_type_AndroidViewView = h(paramPaConfigInfo);
        break label58;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 19)
      {
        this.jdField_a_of_type_AndroidViewView = a(paramPaConfigInfo, 9);
        break label58;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 18)
      {
        this.jdField_a_of_type_AndroidViewView = a(paramPaConfigInfo, 10);
        break label58;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 22)
      {
        this.jdField_a_of_type_AndroidViewView = i(paramPaConfigInfo);
        break label58;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 24)
      {
        this.jdField_a_of_type_AndroidViewView = j(paramPaConfigInfo);
        break label58;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AccountDetailGroupListContainer", 2, "unhandled event_id: " + paramPaConfigInfo.jdField_c_of_type_Int);
      return;
      if (paramPaConfigInfo.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidViewView = m(paramPaConfigInfo);
        break label58;
      }
      if (paramPaConfigInfo.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_AndroidViewView = l(paramPaConfigInfo);
        break label58;
      }
      if (paramPaConfigInfo.jdField_a_of_type_Int == 4)
      {
        this.jdField_a_of_type_AndroidViewView = c(paramPaConfigInfo);
        break label58;
      }
      if (paramPaConfigInfo.jdField_a_of_type_Int == 5)
      {
        this.jdField_a_of_type_AndroidViewView = d(paramPaConfigInfo);
        break label58;
      }
      this.jdField_a_of_type_AndroidViewView = b();
      break label58;
      label490:
      break;
      label492:
      if ((paramPaConfigInfo.jdField_a_of_type_Int == 2) || ((paramPaConfigInfo.jdField_a_of_type_Int == 5) && (!paramPaConfigInfo.jdField_e_of_type_JavaLangString.equals("[]")))) {
        this.jdField_a_of_type_AndroidViewView.setPadding(paramInt, 0, paramInt, 0);
      } else {
        this.jdField_a_of_type_AndroidViewView.setPadding(paramInt, i, paramInt, i);
      }
    }
  }
  
  void a(PaConfigAttr.PaConfigInfo paramPaConfigInfo, int paramInt)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), null);
    localActionSheet.addRadioButton(2131693668, 5, false);
    localActionSheet.addRadioButton(2131693669, 5, false);
    if ((paramInt == 1) || (paramInt == 2)) {
      localActionSheet.setRadioButtonChecked(0);
    }
    for (;;)
    {
      if ((paramInt != 1) && (paramInt == 2)) {}
      localActionSheet.addCancelButton(2131690800);
      localActionSheet.setOnDismissListener(new AccountDetailGroupListContainer.13(this));
      localActionSheet.setOnButtonClickListener(new AccountDetailGroupListContainer.14(this, paramPaConfigInfo, localActionSheet));
      if (!localActionSheet.isShowing())
      {
        this.f = false;
        localActionSheet.show();
      }
      return;
      localActionSheet.setRadioButtonChecked(1);
    }
  }
  
  void a(PaConfigAttr.PaConfigInfo paramPaConfigInfo, Switch paramSwitch)
  {
    boolean bool = true;
    if (paramPaConfigInfo.jdField_d_of_type_Int == 1) {}
    for (;;)
    {
      this.c = false;
      paramSwitch.setChecked(bool);
      return;
      bool = false;
    }
  }
  
  void a(PaConfigAttr.PaConfigInfo paramPaConfigInfo, Switch paramSwitch, boolean paramBoolean)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 0);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    String str2 = HardCodeUtil.a(2131699820);
    String str1 = paramPaConfigInfo.jdField_d_of_type_JavaLangString;
    if (3 == paramPaConfigInfo.jdField_e_of_type_Int) {
      str1 = String.format(((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131692142), new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name });
    }
    localQQCustomDialog.setTitle(str2);
    localQQCustomDialog.setMessage(str1);
    localQQCustomDialog.setOnCancelListener(new AccountDetailGroupListContainer.25(this, paramPaConfigInfo, paramSwitch));
    paramPaConfigInfo = new AccountDetailGroupListContainer.26(this, paramPaConfigInfo, paramBoolean, paramSwitch);
    localQQCustomDialog.setNegativeButton(HardCodeUtil.a(2131699819), paramPaConfigInfo);
    localQQCustomDialog.setPositiveButton(HardCodeUtil.a(2131699825), paramPaConfigInfo);
    try
    {
      localQQCustomDialog.show();
      return;
    }
    catch (Exception paramPaConfigInfo) {}
  }
  
  void a(PaConfigAttr.PaConfigInfo paramPaConfigInfo, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      AccountDetailBaseInfoModel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, paramPaConfigInfo, i);
      return;
    }
  }
  
  protected boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag) != -2)) {}
    for (boolean bool = false;; bool = true)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, "needShowBindTroopItem:" + bool);
      }
      return bool;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer$PublicAccountMoreInfoObserver != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer$PublicAccountMoreInfoObserver.a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer$PublicAccountMoreInfoObserver);
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
    List localList;
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null)
    {
      localList = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.paConfigAttrs;
      if (localList == null) {
        localList = PaConfigAttr.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.newGroupInfoList);
      }
    }
    for (;;)
    {
      int i;
      if (localList != null)
      {
        int j = localList.size();
        i = 0;
        boolean bool = false;
        if (i < j)
        {
          if ((((PaConfigAttr)localList.get(i)).jdField_a_of_type_Int != 0) && (((PaConfigAttr)localList.get(i)).jdField_a_of_type_Int != 1)) {
            break label128;
          }
          bool = a((PaConfigAttr)localList.get(i), i, j, bool);
        }
      }
      label128:
      for (;;)
      {
        i += 1;
        break;
        e();
        return;
      }
      continue;
      localList = null;
    }
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
    if (!a()) {}
    for (;;)
    {
      return;
      try
      {
        l = Long.parseLong(this.jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, "getBindedTroops:" + l);
        }
        if (l == -1L) {
          continue;
        }
        oidb_0x487.ReqBody localReqBody = new oidb_0x487.ReqBody();
        localReqBody.uint32_channel.set(1);
        localReqBody.uint64_subscribe_code.set(l);
        ProtoUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new AccountDetailGroupListContainer.20(this), localReqBody.toByteArray(), "OidbSvc.0x487_0", 1159, 0);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          long l = -1L;
        }
      }
    }
  }
  
  public void h()
  {
    if ((!a()) || (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null)) {
      return;
    }
    Object localObject1 = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (localObject1 != null) {}
    for (localObject1 = ((TicketManager)localObject1).getSkey(str);; localObject1 = null)
    {
      Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name;
      Object localObject2 = localObject3;
      if (localObject3 != null)
      {
        localObject2 = localObject3;
        if (((String)localObject3).endsWith(HardCodeUtil.a(2131699826))) {
          localObject2 = ((String)localObject3).substring(0, ((String)localObject3).length() - 3);
        }
      }
      localObject3 = new HashMap();
      Bundle localBundle = new Bundle();
      localBundle.putString("bid", "0");
      localBundle.putString("keyword", (String)localObject2);
      localBundle.putString("ver", "1");
      localBundle.putString("from", "1");
      localBundle.putString("link", "0");
      localBundle.putString("puin", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
      localBundle.putString("Cookie", "uin=" + str + ";skey=" + (String)localObject1);
      localBundle.putString("Referer", "https://buluo.qq.com/");
      ((HashMap)localObject3).put("BUNDLE", localBundle);
      ((HashMap)localObject3).put("CONTEXT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
      new HttpWebCgiAsyncTask2("https://buluo.qq.com/cgi-bin/bar/qunlist_all", "POST", new AccountDetailGroupListContainer.22(this), 1000, null).a((HashMap)localObject3);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "exp_tribechat_data", "exp_tribechat_aio", 0, 0, this.jdField_a_of_type_JavaLangString, (String)localObject1, "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailGroupListContainer
 * JD-Core Version:    0.7.0.1
 */