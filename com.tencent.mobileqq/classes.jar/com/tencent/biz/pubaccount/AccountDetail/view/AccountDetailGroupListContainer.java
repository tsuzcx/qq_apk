package com.tencent.biz.pubaccount.AccountDetail.view;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
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
import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailBaseInfoModel;
import com.tencent.biz.pubaccount.PaConfigAttr;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.PhotoWallViewForAccountDetail;
import com.tencent.biz.pubaccount.PhotoWallViewForAccountDetail.PhotoWallCallback;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.troopbar.ShareActionSheet;
import com.tencent.biz.troopbar.ShareActionSheet.Detail;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
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
import ktb;
import ktc;
import ktd;
import kte;
import ktf;
import ktg;
import kth;
import kti;
import ktj;
import ktk;
import ktl;
import ktm;
import ktn;
import kto;
import ktp;
import ktq;
import ktr;
import kts;
import ktt;
import ktu;
import ktv;
import ktw;
import ktx;
import kty;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x487.oidb_0x487.ReqBody;

public class AccountDetailGroupListContainer
{
  float jdField_a_of_type_Float;
  View jdField_a_of_type_AndroidViewView;
  public ViewGroup a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  PhotoWallViewForAccountDetail.PhotoWallCallback jdField_a_of_type_ComTencentBizPubaccountPhotoWallViewForAccountDetail$PhotoWallCallback = new ktc(this);
  protected FriendListObserver a;
  public QQAppInterface a;
  public AccountDetail a;
  public String a;
  public WeakReference a;
  public ArrayList a;
  protected kty a;
  boolean jdField_a_of_type_Boolean = false;
  public boolean b = true;
  public boolean c;
  public boolean d;
  public boolean e = false;
  
  public AccountDetailGroupListContainer(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, AccountDetail paramAccountDetail, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ktk(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((BaseActivity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = paramAccountDetail;
    this.jdField_a_of_type_Boolean = paramBoolean;
    c();
    this.jdField_a_of_type_Kty = new kty(this, this);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Kty);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    a();
  }
  
  private View a(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    if ((TextUtils.isEmpty(paramPaConfigInfo.g)) || (TextUtils.isEmpty(paramPaConfigInfo.f))) {
      return null;
    }
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2130969039, null);
    a(localView, paramPaConfigInfo.i);
    TextView localTextView = (TextView)localView.findViewById(2131363397);
    String str1 = paramPaConfigInfo.jdField_a_of_type_JavaLangString;
    String str2 = paramPaConfigInfo.jdField_b_of_type_JavaLangString;
    if (!TextUtils.isEmpty(str1))
    {
      localTextView.setText(str1);
      localView.setOnClickListener(new ktb(this, paramPaConfigInfo, str2));
      return localView;
    }
    return null;
  }
  
  private View a(PaConfigAttr.PaConfigInfo paramPaConfigInfo, int paramInt)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2130969039, null);
    a(localView, paramPaConfigInfo.i);
    ((TextView)localView.findViewById(2131363397)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131363062)).setText(paramPaConfigInfo.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new ktw(this, paramInt, paramPaConfigInfo));
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
    int i = PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag);
    if ((i == -2) || (i == -5)) {
      return "http://share.mp.qq.com/cgi/share.php?uin=" + this.jdField_a_of_type_JavaLangString + "&account_flag=" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag + "&jumptype=1&card_type=public_account";
    }
    return "https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=accountCard&puin=" + this.jdField_a_of_type_JavaLangString;
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      Toast.makeText(((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getApplicationContext(), paramInt, 0).show();
    }
  }
  
  private void a(View paramView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramView = (ImageView)paramView.findViewById(2131362752);
    paramView.setImageDrawable(URLDrawable.getDrawable(paramString));
    paramView.setVisibility(0);
  }
  
  private void a(ViewGroup paramViewGroup, List paramList)
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
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131437794);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131437795);
  }
  
  private void a(String paramString)
  {
    Dialog localDialog = new Dialog((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131624516);
    localDialog.setContentView(2130970317);
    ((TextView)localDialog.findViewById(2131369996)).setVisibility(8);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131369997);
    TextView localTextView2 = (TextView)localDialog.findViewById(2131369998);
    TextView localTextView3 = (TextView)localDialog.findViewById(2131369999);
    localTextView1.setText(paramString);
    localTextView1.setGravity(3);
    localTextView2.setText(2131433029);
    localTextView3.setText(2131435108);
    localDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new ktn(this, localDialog));
    localTextView3.setOnClickListener(new kto(this, paramString));
    try
    {
      localDialog.show();
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
    localObject = (TroopBindPublicAccountMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(131);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("mIsAbleBindTroop", this.c);
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
          localImageView.setImageResource(2130838728);
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
    return ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2130968910, null);
  }
  
  private View b(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2130969039, null);
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
    ((TextView)localView.findViewById(2131363397)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    localView.setOnClickListener(new ktm(this, str, paramPaConfigInfo));
    return localView;
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
      localIntent = new Intent((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), PublicAccountBrowser.class);
    } while ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())));
    paramString = paramString.replace("${puin}", this.jdField_a_of_type_JavaLangString).replace("${uin}", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localIntent.putExtra("url", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailGroupListContainer", 2, "jumpWebView url=" + paramString);
    }
    localIntent.putExtra("puin", this.jdField_a_of_type_JavaLangString);
    paramString = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name;
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("source_name", paramString);
    }
    ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity(localIntent);
  }
  
  private View c(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2130968910, null);
    ((TextView)localView.findViewById(2131363062)).setText(paramPaConfigInfo.jdField_b_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131363397)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    return localView;
  }
  
  private void c(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      PublicAccountReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_JavaLangString, "0X8005A27", "0X8005A27", 0, 0, paramString, "", "", "", false);
      return;
    }
  }
  
  private View d(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    boolean bool = false;
    if ((paramPaConfigInfo.jdField_a_of_type_JavaLangString.contains("历史")) && (this.jdField_a_of_type_Boolean)) {
      return null;
    }
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2130969185, null);
    ((TextView)localView.findViewById(2131363397)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    String str = paramPaConfigInfo.jdField_c_of_type_JavaLangString;
    if (!TextUtils.isEmpty(str))
    {
      localView.findViewById(2131365551).setVisibility(0);
      localView.setOnClickListener(new ktr(this, str, paramPaConfigInfo));
      bool = true;
    }
    try
    {
      for (;;)
      {
        paramPaConfigInfo = new JSONArray(paramPaConfigInfo.jdField_e_of_type_JavaLangString);
        a(bool, (LinearLayout)localView.findViewById(2131365550), paramPaConfigInfo);
        return localView;
        localView.findViewById(2131365551).setVisibility(8);
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
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2130969039, null);
    a(localView, paramPaConfigInfo.i);
    ((TextView)localView.findViewById(2131363397)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131363062)).setText(paramPaConfigInfo.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new kts(this, paramPaConfigInfo));
    return localView;
  }
  
  private View f(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2130969039, null);
    a(localView, paramPaConfigInfo.i);
    ((TextView)localView.findViewById(2131363397)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131363062)).setText(paramPaConfigInfo.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new ktt(this, paramPaConfigInfo));
    return localView;
  }
  
  private View g(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2130969039, null);
    a(localView, paramPaConfigInfo.i);
    ((TextView)localView.findViewById(2131363397)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131363062)).setText(paramPaConfigInfo.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new ktu(this, paramPaConfigInfo));
    return localView;
  }
  
  private View h(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2130969039, null);
    a(localView, paramPaConfigInfo.i);
    ((TextView)localView.findViewById(2131363397)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131363062)).setText(paramPaConfigInfo.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new ktv(this, paramPaConfigInfo));
    return localView;
  }
  
  private View i(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2130969039, null);
    a(localView, paramPaConfigInfo.i);
    String str = paramPaConfigInfo.jdField_c_of_type_JavaLangString;
    ((TextView)localView.findViewById(2131363397)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131363062)).setText(paramPaConfigInfo.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new ktx(this, str, paramPaConfigInfo));
    return localView;
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedEnterprise))) {
      return;
    }
    b(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2130969204, null);
    String str = "";
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedWeixin)) {
      str = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedWeixin + "\n";
    }
    str = str + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedEnterprise;
    ((TextView)localView.findViewById(2131365608)).setText(str);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
  }
  
  private View j(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2130971737, null);
    ((TextView)localView.findViewById(2131363062)).setText(paramPaConfigInfo.jdField_b_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131363397)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    return localView;
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary))) {
      return;
    }
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2130969204, null);
    ((TextView)localView.findViewById(2131365608)).setText(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary);
    ((ImageView)localView.findViewById(2131362752)).setVisibility(8);
    ((TextView)localView.findViewById(2131363397)).setText(2131430058);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
  }
  
  private View k(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    if (paramPaConfigInfo.jdField_e_of_type_Int != 6)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailGroupListContainer", 2, "Unhandled ConfigInfo(" + paramPaConfigInfo.jdField_a_of_type_Int + ", " + paramPaConfigInfo.jdField_c_of_type_Int + ", " + paramPaConfigInfo.jdField_e_of_type_Int + ")");
      }
      return null;
    }
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2130971613, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131363207));
    if ((paramPaConfigInfo.jdField_d_of_type_Int == 1) || (paramPaConfigInfo.jdField_d_of_type_Int == 2)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131437794);
    }
    for (;;)
    {
      ((TextView)localView.findViewById(2131363397)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
      localView.setOnClickListener(new ktd(this, paramPaConfigInfo));
      return localView;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131437795);
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
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2130971652, null);
    ((TextView)localView.findViewById(2131363397)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    Switch localSwitch = (Switch)localView.findViewById(2131364145);
    if (paramPaConfigInfo.jdField_d_of_type_Int == 1) {
      localSwitch.setChecked(true);
    }
    for (;;)
    {
      localSwitch.setOnCheckedChangeListener(new ktg(this, paramPaConfigInfo, localSwitch));
      return localView;
      localSwitch.setChecked(false);
    }
  }
  
  private View m(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    if ((this.jdField_a_of_type_Boolean) && (paramPaConfigInfo.jdField_a_of_type_JavaLangString.contains("历史"))) {
      return null;
    }
    View localView = ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2130969039, null);
    a(localView, paramPaConfigInfo.i);
    String str = paramPaConfigInfo.jdField_c_of_type_JavaLangString;
    ((TextView)localView.findViewById(2131363397)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString);
    ((TextView)localView.findViewById(2131363062)).setText(paramPaConfigInfo.jdField_b_of_type_JavaLangString);
    localView.setOnClickListener(new kth(this, str, paramPaConfigInfo));
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
    Object localObject = ((TroopBindPublicAccountMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(131)).a(this.jdField_a_of_type_JavaLangString);
    if (localObject != null)
    {
      this.c = ((Bundle)localObject).getBoolean("mIsAbleBindTroop", false);
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
        QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, "addBindedTroopItem:" + j + "," + this.c);
      }
    } while ((j == 0) && (!this.c));
    View localView = LayoutInflater.from((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).inflate(2130969514, paramViewGroup, false);
    LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131365550);
    Object localObject = localView.findViewById(2131363062);
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
        ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((String)this.jdField_a_of_type_JavaUtilArrayList.get(i)));
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
    localView.setOnClickListener(new kti(this, j));
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
    label50:
    int i;
    if (paramPaConfigInfo.jdField_a_of_type_Int == 3) {
      if (paramPaConfigInfo.jdField_c_of_type_Int == 10)
      {
        this.jdField_a_of_type_AndroidViewView = k(paramPaConfigInfo);
        if (this.jdField_a_of_type_AndroidViewView == null) {
          break label489;
        }
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, (int)(46.0F * this.jdField_a_of_type_Float));
        this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130837516);
        paramInt = (int)(16.0F * this.jdField_a_of_type_Float);
        i = (int)(12.0F * this.jdField_a_of_type_Float);
        if (paramPaConfigInfo.jdField_a_of_type_Int != 4) {
          break label491;
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
        break label50;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 8)
      {
        this.jdField_a_of_type_AndroidViewView = b(paramPaConfigInfo);
        break label50;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 11)
      {
        this.jdField_a_of_type_AndroidViewView = e(paramPaConfigInfo);
        break label50;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 20)
      {
        this.jdField_a_of_type_AndroidViewView = f(paramPaConfigInfo);
        break label50;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 2)
      {
        this.jdField_a_of_type_AndroidViewView = g(paramPaConfigInfo);
        break label50;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 17)
      {
        this.jdField_a_of_type_AndroidViewView = h(paramPaConfigInfo);
        break label50;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 19)
      {
        this.jdField_a_of_type_AndroidViewView = a(paramPaConfigInfo, 9);
        break label50;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 18)
      {
        this.jdField_a_of_type_AndroidViewView = a(paramPaConfigInfo, 10);
        break label50;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 22)
      {
        this.jdField_a_of_type_AndroidViewView = i(paramPaConfigInfo);
        break label50;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 24)
      {
        this.jdField_a_of_type_AndroidViewView = j(paramPaConfigInfo);
        break label50;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AccountDetailGroupListContainer", 2, "unhandled event_id: " + paramPaConfigInfo.jdField_c_of_type_Int);
      return;
      if (paramPaConfigInfo.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidViewView = m(paramPaConfigInfo);
        break label50;
      }
      if (paramPaConfigInfo.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_AndroidViewView = l(paramPaConfigInfo);
        break label50;
      }
      if (paramPaConfigInfo.jdField_a_of_type_Int == 4)
      {
        this.jdField_a_of_type_AndroidViewView = c(paramPaConfigInfo);
        break label50;
      }
      if (paramPaConfigInfo.jdField_a_of_type_Int == 5)
      {
        this.jdField_a_of_type_AndroidViewView = d(paramPaConfigInfo);
        break label50;
      }
      this.jdField_a_of_type_AndroidViewView = b();
      break label50;
      label489:
      break;
      label491:
      if ((paramPaConfigInfo.jdField_a_of_type_Int == 2) || ((paramPaConfigInfo.jdField_a_of_type_Int == 5) && (!paramPaConfigInfo.jdField_e_of_type_JavaLangString.equals("[]")))) {
        this.jdField_a_of_type_AndroidViewView.setPadding(paramInt, 0, paramInt, 0);
      } else {
        this.jdField_a_of_type_AndroidViewView.setPadding(paramInt, i, paramInt, i);
      }
    }
  }
  
  public void a(PaConfigAttr.PaConfigInfo paramPaConfigInfo, int paramInt)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), null);
    localActionSheet.a(2131437794, 5, false);
    localActionSheet.a(2131437795, 5, false);
    if ((paramInt == 1) || (paramInt == 2)) {
      localActionSheet.d(0);
    }
    for (;;)
    {
      if ((paramInt != 1) && (paramInt == 2)) {}
      localActionSheet.c(2131433029);
      localActionSheet.setOnDismissListener(new kte(this));
      localActionSheet.a(new ktf(this, paramPaConfigInfo, localActionSheet));
      if (!localActionSheet.isShowing())
      {
        this.e = false;
        localActionSheet.show();
      }
      return;
      localActionSheet.d(1);
    }
  }
  
  public void a(PaConfigAttr.PaConfigInfo paramPaConfigInfo, Switch paramSwitch)
  {
    boolean bool = true;
    if (paramPaConfigInfo.jdField_d_of_type_Int == 1) {}
    for (;;)
    {
      this.b = false;
      paramSwitch.setChecked(bool);
      return;
      bool = false;
    }
  }
  
  public void a(PaConfigAttr.PaConfigInfo paramPaConfigInfo, Switch paramSwitch, boolean paramBoolean)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 0);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    String str = paramPaConfigInfo.jdField_d_of_type_JavaLangString;
    if (3 == paramPaConfigInfo.jdField_e_of_type_Int) {
      str = String.format(((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131428082), new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name });
    }
    localQQCustomDialog.setTitle("温馨提示");
    localQQCustomDialog.setMessage(str);
    localQQCustomDialog.setOnCancelListener(new ktp(this, paramPaConfigInfo, paramSwitch));
    paramPaConfigInfo = new ktq(this, paramPaConfigInfo, paramBoolean, paramSwitch);
    localQQCustomDialog.setNegativeButton("取消", paramPaConfigInfo);
    localQQCustomDialog.setPositiveButton("确定", paramPaConfigInfo);
    try
    {
      localQQCustomDialog.show();
      return;
    }
    catch (Exception paramPaConfigInfo) {}
  }
  
  public void a(PaConfigAttr.PaConfigInfo paramPaConfigInfo, boolean paramBoolean)
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
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null)
    {
      bool1 = bool2;
      if (PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag) != -2) {
        bool1 = false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, "needShowBindTroopItem:" + bool1);
    }
    return bool1;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Kty != null)
    {
      this.jdField_a_of_type_Kty.a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Kty);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
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
      Object localObject = ((TroopBindPublicAccountMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(131)).a(this.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        this.c = ((Bundle)localObject).getBoolean("mIsAbleBindTroop", false);
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
        ProtoUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ktj(this), localReqBody.toByteArray(), "OidbSvc.0x487_0", 1159, 0);
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
        if (((String)localObject3).endsWith("·部落")) {
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
      new HttpWebCgiAsyncTask2("https://buluo.qq.com/cgi-bin/bar/qunlist_all", "POST", new ktl(this), 1000, null).a((HashMap)localObject3);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "exp_tribechat_data", "exp_tribechat_aio", 0, 0, this.jdField_a_of_type_JavaLangString, (String)localObject1, "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailGroupListContainer
 * JD-Core Version:    0.7.0.1
 */