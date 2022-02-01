package com.tencent.mobileqq.activity;

import Override;
import adjy;
import adjz;
import adka;
import adkb;
import adkc;
import adkd;
import adke;
import adkf;
import adkg;
import adkh;
import adki;
import adkj;
import amov;
import ampm;
import ampq;
import amsu;
import amsw;
import amtj;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import apgi;
import apgj;
import aymn;
import aymx;
import bcef;
import bczs;
import beyy;
import bfre;
import bfrj;
import bfur;
import bgae;
import bgdk;
import bhha;
import bhht;
import bhig;
import bjng;
import bjnw;
import bjon;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.QZoneDistributedAppCtrl;
import cooperation.qzone.util.QZoneDistributedAppCtrl.Control;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;

public class FriendProfileMoreInfoActivity
  extends ProfileActivity
  implements Handler.Callback, View.OnClickListener, View.OnFocusChangeListener
{
  private byte jdField_a_of_type_Byte;
  public int a;
  public adkj a;
  amov jdField_a_of_type_Amov;
  ampm jdField_a_of_type_Ampm;
  private ampq jdField_a_of_type_Ampq = new adkf(this);
  private amsu jdField_a_of_type_Amsu = new adke(this);
  protected BroadcastReceiver a;
  public Bundle a;
  private View jdField_a_of_type_AndroidViewView;
  public EditText a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private apgj jdField_a_of_type_Apgj = new adkd(this);
  bhha jdField_a_of_type_Bhha;
  bhht jdField_a_of_type_Bhht = null;
  bjng jdField_a_of_type_Bjng;
  public bjnw a;
  public ProfileActivity.AllInOne a;
  public CardObserver a;
  public BusinessCard a;
  private IphonePickerView jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  ColorNickTextView jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView;
  public String a;
  public boolean a;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int jdField_b_of_type_Int;
  public adkj b;
  private View jdField_b_of_type_AndroidViewView;
  public EditText b;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public bhht b;
  String jdField_b_of_type_JavaLangString = "";
  public boolean b;
  String[] jdField_b_of_type_ArrayOfJavaLangString;
  private int jdField_c_of_type_Int;
  public adkj c;
  private View jdField_c_of_type_AndroidViewView;
  public EditText c;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString = "";
  public boolean c;
  private int jdField_d_of_type_Int;
  public adkj d;
  private View jdField_d_of_type_AndroidViewView;
  public EditText d;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString;
  public boolean d;
  private int jdField_e_of_type_Int;
  private View jdField_e_of_type_AndroidViewView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private String jdField_e_of_type_JavaLangString;
  public boolean e;
  private View jdField_f_of_type_AndroidViewView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private String jdField_f_of_type_JavaLangString;
  public boolean f;
  private View jdField_g_of_type_AndroidViewView;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  public boolean g;
  private View jdField_h_of_type_AndroidViewView;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  public boolean h;
  private View jdField_i_of_type_AndroidViewView;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  public boolean i;
  private View jdField_j_of_type_AndroidViewView;
  private TextView jdField_j_of_type_AndroidWidgetTextView;
  private boolean jdField_j_of_type_Boolean;
  private View k;
  private View l;
  private View m;
  private View n;
  
  public FriendProfileMoreInfoActivity()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Bhht = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqAppCardObserver = new adjy(this);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new adkc(this);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    new bhig(this).a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  private void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Bhht == null) {
      this.jdField_a_of_type_Bhht = new bhht(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_Bhht.a(paramString);
    this.jdField_a_of_type_Bhht.show();
  }
  
  private void a(Card paramCard)
  {
    if ((paramCard != null) && (!this.jdField_i_of_type_Boolean) && (bfrj.a(paramCard, this.app)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FriendProfileMoreInfoActivity", 2, "checkEduFirstGuide:");
      }
      String str = amtj.a(2131704031);
      bfur.a(this, amtj.a(2131704010), str, null, 2131694587, 2131694588, new adkg(this), new adkh(this)).show();
      bfrj.a(paramCard, this.app);
      bcef.b(this.app, "dc00898", "", "", "0X800A0D7", "0X800A0D7", 0, 0, "", "", "", "");
    }
  }
  
  private void a(Card paramCard, boolean paramBoolean)
  {
    Object localObject2 = null;
    if (paramCard == null) {
      return;
    }
    if (paramCard.lCurrentStyleId != aymn.a) {}
    this.jdField_f_of_type_JavaLangString = paramCard.strNick;
    a(paramCard.getRichStatus());
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if ((!this.jdField_a_of_type_Adkj.jdField_b_of_type_Boolean) && (paramCard.strNick != null) && (!paramCard.strNick.equals(localObject1)))
    {
      this.jdField_a_of_type_Adkj.jdField_a_of_type_Boolean = true;
      a(paramCard.strNick);
      label90:
      if (!this.jdField_c_of_type_Boolean) {
        a(paramCard.shGender, false);
      }
      if (!this.jdField_d_of_type_Boolean) {
        a((int)paramCard.lBirthday, paramCard.age, paramCard.constellation);
      }
      if (!this.jdField_e_of_type_Boolean) {
        a(paramCard.iProfession);
      }
      localObject1 = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
      if ((!this.jdField_b_of_type_Adkj.jdField_b_of_type_Boolean) && (paramCard.strCompany != null) && (!paramCard.strCompany.equals(localObject1)))
      {
        this.jdField_b_of_type_Adkj.jdField_a_of_type_Boolean = true;
        b(paramCard.strCompany);
      }
      localObject1 = this.jdField_c_of_type_AndroidWidgetEditText.getText().toString();
      if ((!this.jdField_c_of_type_Adkj.jdField_b_of_type_Boolean) && (paramCard.strSchool != null) && (!paramCard.strSchool.equals(localObject1)))
      {
        this.jdField_c_of_type_Adkj.jdField_a_of_type_Boolean = true;
        c(paramCard.strSchool);
      }
      if (!this.jdField_f_of_type_Boolean) {
        if (TextUtils.isEmpty(paramCard.strLocationCodes)) {
          break label435;
        }
      }
    }
    label435:
    for (localObject1 = paramCard.strLocationCodes.split("-");; localObject1 = null)
    {
      this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])localObject1);
      d(paramCard.strLocationDesc);
      if (!this.jdField_g_of_type_Boolean)
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(paramCard.strHometownCodes)) {
          localObject1 = paramCard.strHometownCodes.split("-");
        }
        this.jdField_b_of_type_ArrayOfJavaLangString = ((String[])localObject1);
        e(paramCard.strHometownDesc);
      }
      localObject1 = this.jdField_d_of_type_AndroidWidgetEditText.getText().toString();
      if ((!this.jdField_d_of_type_Adkj.jdField_b_of_type_Boolean) && (paramCard.strEmail != null) && (!paramCard.strEmail.equals(localObject1)))
      {
        this.jdField_d_of_type_Adkj.jdField_a_of_type_Boolean = true;
        f(paramCard.strEmail);
      }
      if (this.jdField_h_of_type_Boolean) {
        break;
      }
      g(paramCard.strPersonalNote);
      return;
      if (TextUtils.isEmpty(paramCard.strNick)) {
        break label90;
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(paramCard.strNick);
      break label90;
    }
  }
  
  private void a(ArrayList<aymx> paramArrayList)
  {
    if ((paramArrayList != null) && (this.n.getVisibility() == 0) && (this.jdField_b_of_type_AndroidWidgetLinearLayout != null))
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
      Object localObject1;
      if (paramArrayList.size() > 0)
      {
        paramArrayList = paramArrayList.iterator();
        do
        {
          if (!paramArrayList.hasNext()) {
            break;
          }
          localObject1 = (aymx)paramArrayList.next();
        } while (TextUtils.isEmpty(((aymx)localObject1).jdField_b_of_type_JavaLangString));
        View localView = View.inflate(this, 2131561325, null);
        TextView localTextView = (TextView)localView.findViewById(2131376823);
        Object localObject2;
        if (((aymx)localObject1).jdField_b_of_type_Boolean)
        {
          localTextView.setText(((aymx)localObject1).jdField_b_of_type_JavaLangString);
          localObject2 = getResources().getDrawable(2130845045);
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
          localTextView.setCompoundDrawables(null, null, (Drawable)localObject2, null);
          localTextView.setCompoundDrawablePadding(AIOUtils.dp2px(4.5F, localTextView.getResources()));
          label161:
          localTextView = (TextView)localView.findViewById(2131365935);
          localObject2 = ((aymx)localObject1).a();
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label252;
          }
          localTextView.setVisibility(8);
          label194:
          localTextView = (TextView)localView.findViewById(2131365936);
          if (!((aymx)localObject1).jdField_a_of_type_Boolean) {
            break label262;
          }
          localTextView.setVisibility(0);
        }
        for (;;)
        {
          localView.setOnClickListener(this);
          localView.setTag(localObject1);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localView);
          break;
          localTextView.setText(((aymx)localObject1).jdField_b_of_type_JavaLangString);
          break label161;
          label252:
          localTextView.setText((CharSequence)localObject2);
          break label194;
          label262:
          localTextView.setVisibility(8);
        }
      }
      paramArrayList = ((amsw)this.app.getManager(51)).c(this.app.getCurrentAccountUin());
      if ((paramArrayList != null) && (!TextUtils.isEmpty(paramArrayList.strSchool)))
      {
        localObject1 = View.inflate(this, 2131561325, null);
        ((TextView)((View)localObject1).findViewById(2131376823)).setText(paramArrayList.strSchool);
        ((TextView)((View)localObject1).findViewById(2131365935)).setVisibility(8);
        ((View)localObject1).setOnClickListener(this);
        ((View)localObject1).setTag(paramArrayList);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      }
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount() < 2)
      {
        this.n.findViewById(2131376814).setVisibility(0);
        this.n.findViewById(2131376818).setVisibility(0);
        this.n.findViewById(2131376816).setVisibility(0);
        this.n.findViewById(2131376812).setVisibility(8);
      }
    }
    else
    {
      return;
    }
    this.n.findViewById(2131376814).setVisibility(8);
    this.n.findViewById(2131376818).setVisibility(8);
    this.n.findViewById(2131376816).setVisibility(8);
    this.n.findViewById(2131376812).setVisibility(0);
  }
  
  private void a(boolean paramBoolean, Card paramCard)
  {
    if (QLog.isColorLevel()) {
      QLog.e("FriendProfileMoreInfoActivity", 2, "onDeleteOldSchoolResult:" + paramBoolean);
    }
    this.jdField_j_of_type_Boolean = false;
    if (paramBoolean) {
      a(((apgi)this.app.getManager(112)).a());
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Adkj.jdField_b_of_type_Boolean) || (this.jdField_b_of_type_Adkj.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Adkj.jdField_b_of_type_Boolean) || (this.jdField_d_of_type_Adkj.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean) || (this.jdField_e_of_type_Boolean) || (this.jdField_f_of_type_Boolean) || (this.jdField_g_of_type_Boolean) || (this.jdField_h_of_type_Boolean);
  }
  
  private boolean a(Bundle paramBundle, int paramInt1, int paramInt2)
  {
    if (!NetworkUtil.isNetSupport(this)) {
      a(paramInt1, paramInt2);
    }
    while ((paramBundle == null) || (paramBundle.isEmpty())) {
      return false;
    }
    this.jdField_a_of_type_Amov.a(paramBundle);
    return true;
  }
  
  private boolean a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    boolean bool = true;
    if (paramArrayOfString1 == paramArrayOfString2) {}
    for (;;)
    {
      return bool;
      try
      {
        int i1;
        if (paramArrayOfString1.length == paramArrayOfString2.length) {
          i1 = 0;
        }
        for (;;)
        {
          if ((i1 >= paramArrayOfString1.length) || (!paramArrayOfString1[i1].equals(paramArrayOfString2[i1])))
          {
            int i2 = paramArrayOfString1.length;
            if (i1 == i2) {
              break;
            }
            bool = false;
            break;
          }
          i1 += 1;
        }
        return false;
      }
      catch (Exception paramArrayOfString1) {}
    }
  }
  
  private void b()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("college", "");
    if (a(localBundle, 2131694064, 0)) {
      this.jdField_j_of_type_Boolean = true;
    }
  }
  
  private void b(int paramInt)
  {
    bcef.b(this.app, "dc00898", "", "", "0X800A0D5", "0X800A0D5", 0, 0, paramInt + "", "", "", "");
  }
  
  private boolean b()
  {
    Bundle localBundle = new Bundle();
    Object localObject1;
    if (this.jdField_a_of_type_Adkj.jdField_b_of_type_Boolean)
    {
      localObject1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(((String)localObject1).trim()))) {}
    }
    else
    {
      if (this.jdField_c_of_type_Boolean) {
        localBundle.putByte("sex", this.jdField_a_of_type_Byte);
      }
      if (this.jdField_d_of_type_Boolean)
      {
        localBundle.putInt("birthday", this.jdField_b_of_type_Int);
        localBundle.putInt("age", this.jdField_c_of_type_Int);
        localBundle.putInt("key_constellation", this.jdField_d_of_type_Int);
      }
      if (this.jdField_e_of_type_Boolean) {
        localBundle.putInt("profession", this.jdField_e_of_type_Int);
      }
      if (this.jdField_b_of_type_Adkj.jdField_b_of_type_Boolean) {
        localBundle.putString("company", this.jdField_b_of_type_AndroidWidgetEditText.getText().toString());
      }
      if (this.jdField_c_of_type_Adkj.jdField_b_of_type_Boolean) {
        localBundle.putString("college", this.jdField_c_of_type_AndroidWidgetEditText.getText().toString());
      }
      if (this.jdField_f_of_type_Boolean)
      {
        localObject1 = this.jdField_h_of_type_AndroidWidgetTextView.getText().toString();
        localBundle.putStringArray("location", this.jdField_a_of_type_ArrayOfJavaLangString);
        localBundle.putString("locationo_desc", (String)localObject1);
        localObject1 = null;
      }
    }
    label390:
    try
    {
      localObject2 = this.jdField_a_of_type_Ampm.a(this.jdField_a_of_type_ArrayOfJavaLangString);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      label231:
      break label231;
    }
    localBundle.putStringArray("location_name", (String[])localObject1);
    if (this.jdField_g_of_type_Boolean)
    {
      localObject1 = this.jdField_i_of_type_AndroidWidgetTextView.getText().toString();
      localBundle.putStringArray("hometown", this.jdField_b_of_type_ArrayOfJavaLangString);
      localBundle.putString("hometown_desc", (String)localObject1);
    }
    if (this.jdField_d_of_type_Adkj.jdField_b_of_type_Boolean)
    {
      localObject1 = this.jdField_d_of_type_AndroidWidgetEditText.getText().toString();
      localObject2 = SearchBaseActivity.a.matcher((CharSequence)localObject1);
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (((Matcher)localObject2).matches())) {
        break label390;
      }
    }
    for (;;)
    {
      if (this.jdField_h_of_type_Boolean) {
        localBundle.putString("personalNote", this.jdField_e_of_type_JavaLangString);
      }
      return a(localBundle, 2131694064, 0);
      localBundle.putString("nick", ((String)localObject1).trim());
      localObject1 = new QZoneDistributedAppCtrl.Control();
      ((QZoneDistributedAppCtrl.Control)localObject1).cmd = 5;
      QZoneDistributedAppCtrl.getInstance(getAppRuntime().getAccount()).submitCtrl((QZoneDistributedAppCtrl.Control)localObject1);
      break;
      localBundle.putString("email", (String)localObject1);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Amov.a(this.app.getLongAccountUin());
  }
  
  private void c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.post(new FriendProfileMoreInfoActivity.9(this));
      return;
    case 2: 
      Intent localIntent = new Intent(this, AgeSelectionActivity.class);
      localIntent.putExtra("param_birthday", this.jdField_b_of_type_Int);
      startActivityForResult(localIntent, 1003);
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.post(new FriendProfileMoreInfoActivity.10(this));
      d(1);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.post(new FriendProfileMoreInfoActivity.11(this));
  }
  
  private void d()
  {
    bjnw localbjnw = (bjnw)bjon.a(this, null);
    localbjnw.a(2131694584, 0);
    localbjnw.a(2131694586, 0);
    localbjnw.a(2131694585, 0);
    localbjnw.c(2131690620);
    localbjnw.a(new adki(this, localbjnw));
    localbjnw.show();
  }
  
  private void d(int paramInt)
  {
    int i1 = this.jdField_a_of_type_Ampm.a();
    if (i1 != 0)
    {
      i1 = this.jdField_a_of_type_Ampm.a(i1, true);
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileMoreInfoActivity", 2, "startLocationSelectActivity | update result = " + i1);
      }
      if (i1 == 2)
      {
        QQToast.a(this, 2131694064, 0).b(getTitleBarHeight());
        return;
      }
      if (i1 == 0)
      {
        a(paramInt, getString(2131690948));
        this.jdField_a_of_type_Ampm.c(this.jdField_a_of_type_Ampq);
        return;
      }
      a(paramInt, getString(2131690948));
      this.jdField_a_of_type_Bjng.sendEmptyMessageDelayed(1000, 20000L);
      return;
    }
    Object localObject1;
    if (paramInt == 1)
    {
      i1 = 2;
      if (paramInt != 1) {
        break label273;
      }
      localObject1 = this.jdField_a_of_type_ArrayOfJavaLangString;
      label148:
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (localObject1.length == 4) {}
      }
      else
      {
        localObject2 = new String[4];
        localObject2[0] = "0";
        localObject2[1] = "0";
        localObject2[2] = "0";
        localObject2[3] = "0";
      }
      localObject1 = new Intent(this, LocationSelectActivity.class);
      ((Intent)localObject1).putExtra("param_is_popup", false);
      ((Intent)localObject1).putExtra("param_req_type", i1);
      ((Intent)localObject1).putExtra("param_location", (String[])localObject2);
      ((Intent)localObject1).putExtra("param_location_param", this.jdField_a_of_type_Ampm.b((String[])localObject2));
      if (paramInt != 1) {
        break label281;
      }
    }
    label273:
    label281:
    for (paramInt = 1005;; paramInt = 1006)
    {
      startActivityForResult((Intent)localObject1, paramInt);
      return;
      i1 = 3;
      break;
      localObject1 = this.jdField_b_of_type_ArrayOfJavaLangString;
      break label148;
    }
  }
  
  private void e()
  {
    if (a())
    {
      if (this.jdField_b_of_type_Bhht == null)
      {
        this.jdField_b_of_type_Bhht = new bhht(this, getTitleBarHeight());
        this.jdField_b_of_type_Bhht.a(amtj.a(2131704008));
      }
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_Bhht.dismiss();
        this.jdField_b_of_type_Boolean = true;
        if (!isFinishing()) {
          finish();
        }
      }
    }
    while (isFinishing())
    {
      do
      {
        return;
        if (b())
        {
          this.jdField_a_of_type_Boolean = true;
          this.jdField_b_of_type_Bhht.show();
          return;
        }
      } while (isFinishing());
      finish();
      return;
    }
    finish();
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131376697));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369115));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693060);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131693060));
    Object localObject = (TextView)findViewById(2131369068);
    ((TextView)localObject).setText("");
    ((TextView)localObject).setContentDescription(amtj.a(2131704053));
    ((TextView)localObject).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131365090));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131363149);
    this.jdField_a_of_type_AndroidViewView.setContentDescription(getString(2131691991));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363145));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131377489);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377491));
    a(null);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131379235);
    if (this.jdField_i_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)findViewById(2131379238));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379236));
      localObject = findViewById(2131379234);
      TroopInfo localTroopInfo = ((TroopManager)this.app.getManager(52)).b(this.jdField_a_of_type_JavaLangString);
      if (localTroopInfo == null) {
        break label1255;
      }
      if ((localTroopInfo.isTroopAdmin(this.app.getCurrentAccountUin())) || (localTroopInfo.isTroopOwner(this.app.getCurrentAccountUin())) || (TextUtils.equals(this.jdField_b_of_type_JavaLangString, this.app.getCurrentAccountUin())))
      {
        this.jdField_c_of_type_AndroidViewView.setClickable(true);
        this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
        ((View)localObject).setVisibility(0);
      }
    }
    for (;;)
    {
      a();
      this.jdField_d_of_type_AndroidViewView = findViewById(2131371785);
      if (this.jdField_c_of_type_AndroidViewView.getVisibility() == 0) {
        ((LinearLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams()).setMargins(0, 0, 0, 0);
      }
      this.jdField_d_of_type_AndroidViewView.setClickable(false);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131371784));
      this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this);
      this.jdField_a_of_type_Adkj = new adkj(this, 36, this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_Adkj);
      this.jdField_a_of_type_Adkj.jdField_a_of_type_Boolean = true;
      a(null);
      this.jdField_e_of_type_AndroidViewView = findViewById(2131377240);
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377241));
      a(-1, false);
      this.jdField_f_of_type_AndroidViewView = findViewById(2131363535);
      this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363536));
      a(0, 0, 0);
      if (bfrj.b())
      {
        int i1 = this.jdField_e_of_type_AndroidViewView.getPaddingLeft();
        int i2 = this.jdField_e_of_type_AndroidViewView.getPaddingTop();
        int i3 = this.jdField_e_of_type_AndroidViewView.getPaddingRight();
        int i4 = this.jdField_e_of_type_AndroidViewView.getPaddingBottom();
        this.jdField_e_of_type_AndroidViewView.setBackgroundResource(2130839482);
        this.jdField_e_of_type_AndroidViewView.setPadding(i1, i2, i3, i4);
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
        if (QLog.isDevelopLevel()) {
          QLog.i("FriendProfileMoreInfoActivity", 4, String.format(Locale.getDefault(), "EuropeAndAmerica sexLayout[%s, %s, %s, %s]", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4) }));
        }
      }
      this.jdField_g_of_type_AndroidViewView = findViewById(2131372977);
      this.jdField_g_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372976));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372978));
      a(-1);
      this.jdField_h_of_type_AndroidViewView = findViewById(2131364942);
      this.jdField_h_of_type_AndroidViewView.setClickable(false);
      this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131364941));
      this.jdField_b_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this);
      this.jdField_b_of_type_Adkj = new adkj(this, 120, this.jdField_b_of_type_AndroidWidgetEditText);
      this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_b_of_type_Adkj);
      this.jdField_b_of_type_Adkj.jdField_a_of_type_Boolean = true;
      b(null);
      this.jdField_i_of_type_AndroidViewView = findViewById(2131376822);
      this.jdField_i_of_type_AndroidViewView.setClickable(false);
      this.jdField_c_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131376819));
      this.jdField_c_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this);
      this.jdField_c_of_type_Adkj = new adkj(this, 40, this.jdField_c_of_type_AndroidWidgetEditText);
      this.jdField_c_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_c_of_type_Adkj);
      this.jdField_c_of_type_Adkj.jdField_a_of_type_Boolean = true;
      c(null);
      this.jdField_j_of_type_AndroidViewView = findViewById(2131370328);
      this.jdField_j_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370342));
      d(null);
      this.k = findViewById(2131368119);
      this.k.setOnClickListener(this);
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368120));
      e(null);
      this.l = findViewById(2131365951);
      this.l.setClickable(false);
      this.jdField_d_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131365950));
      this.jdField_d_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this);
      this.jdField_d_of_type_Adkj = new adkj(this, 50, this.jdField_d_of_type_AndroidWidgetEditText);
      this.jdField_d_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_d_of_type_Adkj);
      this.jdField_d_of_type_Adkj.jdField_a_of_type_Boolean = true;
      f(null);
      this.m = findViewById(2131372390);
      this.m.setOnClickListener(this);
      this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372391));
      g(null);
      this.n = findViewById(2131365938);
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131362207));
      findViewById(2131376813).setOnClickListener(this);
      findViewById(2131376817).setOnClickListener(this);
      findViewById(2131376815).setOnClickListener(this);
      findViewById(2131376811).setOnClickListener(this);
      if ((this.jdField_i_of_type_Boolean) && (TroopInfo.isQidianPrivateTroop(this.app, this.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_g_of_type_AndroidViewView.setVisibility(8);
        this.jdField_h_of_type_AndroidViewView.setVisibility(8);
        this.jdField_i_of_type_AndroidViewView.setVisibility(8);
        this.k.setVisibility(8);
        this.l.setVisibility(8);
        this.m.setVisibility(8);
      }
      if (!this.jdField_i_of_type_Boolean)
      {
        this.jdField_i_of_type_AndroidViewView.setVisibility(8);
        this.n.setVisibility(0);
      }
      return;
      label1255:
      this.jdField_c_of_type_AndroidViewView.setClickable(false);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(null);
      ((View)localObject).setVisibility(8);
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) {
      return;
    }
    bgae.a(this, this.app, 0, "signature_ziliaoka", 1002);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Bjnw == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getLayoutInflater().inflate(2131561127, null));
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(new adjz(this));
      this.jdField_a_of_type_Bjnw = bjnw.c(this);
      this.jdField_a_of_type_Bjnw.e(true);
      this.jdField_a_of_type_Bjnw.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
      localObject = (DispatchActionMoveScrollView)this.jdField_a_of_type_Bjnw.findViewById(2131361979);
      ((DispatchActionMoveScrollView)localObject).dispatchActionMove = true;
      ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = this.jdField_a_of_type_Bjnw.getWindow();
        if (localObject != null) {
          ((Window)localObject).setFlags(16777216, 16777216);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(new adka(this));
    }
    if ((this.jdField_a_of_type_Byte != 0) && (this.jdField_a_of_type_Byte != 1))
    {
      this.jdField_a_of_type_Byte = 0;
      this.jdField_c_of_type_Boolean = true;
    }
    a(this.jdField_a_of_type_Byte, true);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
    if (this.jdField_a_of_type_Byte != 1) {}
    for (int i1 = 0;; i1 = 1)
    {
      ((IphonePickerView)localObject).setSelection(0, i1);
      try
      {
        this.jdField_a_of_type_Bjnw.setOnDismissListener(new adkb(this));
        this.jdField_a_of_type_Bjnw.show();
        return;
      }
      catch (Exception localException) {}
    }
  }
  
  private void h(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileMoreInfoActivity", 2, "gotoSchoolWeb " + paramString);
    }
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("hide_more_button", true);
    startActivityForResult(localIntent, 1012);
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_Bhht != null) && (this.jdField_a_of_type_Bhht.isShowing())) {
      this.jdField_a_of_type_Bhht.dismiss();
    }
  }
  
  void a()
  {
    String str = ContactUtils.getTroopMemberNick(this.app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    if ((TextUtils.isEmpty(str)) || (TextUtils.equals(str, this.jdField_b_of_type_JavaLangString)))
    {
      str = "";
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      SpannableString localSpannableString = new bczs(str, 16).a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText(localSpannableString);
      bgdk.a(this.app, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, localSpannableString);
      a(this.jdField_c_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, getString(2131697036), str);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  void a(int paramInt)
  {
    boolean bool = false;
    Object localObject2;
    Object localObject1;
    label67:
    TextView localTextView;
    String str;
    if (bfre.a(paramInt))
    {
      this.jdField_e_of_type_Int = paramInt;
      localObject2 = bfre.e(paramInt);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        this.jdField_e_of_type_Int = -1;
        localObject1 = getString(2131694682);
      }
      if ((paramInt < bfre.e.length - 1) && (paramInt > 0)) {
        break label137;
      }
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      localObject2 = this.jdField_g_of_type_AndroidWidgetTextView;
      if (this.jdField_e_of_type_Int == -1) {
        bool = true;
      }
      a((TextView)localObject2, (CharSequence)localObject1, bool);
      localObject2 = this.jdField_g_of_type_AndroidViewView;
      localTextView = this.jdField_g_of_type_AndroidWidgetTextView;
      str = getString(2131694683);
      if (paramInt == -1) {
        break label192;
      }
    }
    for (;;)
    {
      a((View)localObject2, localTextView, str, (String)localObject1);
      return;
      this.jdField_e_of_type_Int = -1;
      break;
      label137:
      localObject2 = getResources().getDrawable(bfre.b[paramInt]);
      ProfileActivity.a(this.app, (Drawable)localObject2);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localObject2);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(bfre.e[paramInt]);
      break label67;
      label192:
      localObject1 = "";
    }
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_d_of_type_Int = paramInt3;
    String str1 = getString(2131694579);
    if (paramInt1 != 0) {
      str1 = String.format(Locale.getDefault(), "%d-%d-%d", new Object[] { Integer.valueOf((0xFFFF0000 & paramInt1) >>> 16), Integer.valueOf((0xFF00 & paramInt1) >>> 8), Integer.valueOf(paramInt1 & 0xFF) });
    }
    Object localObject = this.jdField_e_of_type_AndroidWidgetTextView;
    TextView localTextView;
    String str2;
    if (paramInt1 == 0)
    {
      a((TextView)localObject, str1, bool);
      localObject = this.jdField_f_of_type_AndroidViewView;
      localTextView = this.jdField_e_of_type_AndroidWidgetTextView;
      str2 = getString(2131694580);
      if (paramInt1 == 0) {
        break label149;
      }
    }
    for (;;)
    {
      a((View)localObject, localTextView, str2, str1);
      return;
      bool = false;
      break;
      label149:
      str1 = "";
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Byte = ((byte)paramInt);
    String str = getString(2131694686);
    if (paramInt == 0)
    {
      str = getString(2131693568);
      if (!paramBoolean) {
        break label88;
      }
      a(this.jdField_d_of_type_AndroidWidgetTextView, str, 2131167020);
      if ((paramInt != 0) && (paramInt != 1)) {
        break label121;
      }
    }
    for (;;)
    {
      a(this.jdField_e_of_type_AndroidViewView, this.jdField_d_of_type_AndroidWidgetTextView, getString(2131694687), str);
      return;
      if (paramInt != 1) {
        break;
      }
      str = getString(2131692108);
      break;
      label88:
      TextView localTextView = this.jdField_d_of_type_AndroidWidgetTextView;
      if ((paramInt != 0) && (paramInt != 1)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        a(localTextView, str, paramBoolean);
        break;
      }
      label121:
      str = "";
    }
  }
  
  public void a(View paramView1, View paramView2, String paramString1, String paramString2)
  {
    String str = paramString1 + "," + paramString2 + ",";
    paramView1.setContentDescription(str);
    paramView1 = str;
    if ((paramView2 instanceof EditText)) {
      paramView1 = paramString1 + amtj.a(2131704035) + paramString2 + ",";
    }
    paramView2.setContentDescription(paramView1);
  }
  
  void a(TextView paramTextView, CharSequence paramCharSequence, int paramInt)
  {
    paramTextView.setTextColor(getResources().getColor(paramInt));
    paramTextView.setText(paramCharSequence);
  }
  
  void a(TextView paramTextView, CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = 2131167098;; i1 = 2131167012)
    {
      a(paramTextView, paramCharSequence, i1);
      return;
    }
  }
  
  void a(RichStatus paramRichStatus)
  {
    boolean bool = false;
    if (paramRichStatus != null) {
      paramRichStatus = paramRichStatus.toSpannableString("").toString();
    }
    for (this.jdField_d_of_type_JavaLangString = paramRichStatus;; this.jdField_d_of_type_JavaLangString = "")
    {
      a(this.jdField_c_of_type_AndroidWidgetTextView, paramRichStatus, bool);
      a(this.jdField_b_of_type_AndroidViewView, this.jdField_c_of_type_AndroidWidgetTextView, getString(2131693112), paramRichStatus);
      return;
      paramRichStatus = amtj.a(2131704042);
      bool = true;
    }
  }
  
  void a(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString))
    {
      str = "";
      paramString = getString(2131694637);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(str);
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(paramString);
      a(this.jdField_d_of_type_AndroidViewView, this.jdField_a_of_type_AndroidWidgetEditText, getString(2131694638), str);
      return;
      str = paramString;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (TroopInfo.isHomeworkTroop(this.app, paramString1))
    {
      beyy.a(this, paramString2, paramString1, "qqProfile");
      return;
    }
    Intent localIntent = new Intent(this, EditInfoActivity.class);
    localIntent.putExtra("edit_type", 0);
    localIntent.putExtra("troopUin", paramString1);
    localIntent.putExtra("uin", paramString2);
    paramString1 = "";
    if (paramInt == 1011)
    {
      paramString1 = getString(2131697040);
      localIntent.putExtra("isTroopNick", true);
      localIntent.putExtra("default_text", this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getText().toString() + "");
      localIntent.putExtra("max_num", 60);
    }
    localIntent.putExtra("title", paramString1);
    if (TextUtils.isEmpty("")) {
      localIntent.putExtra("default_hint", amtj.a(2131704016));
    }
    for (;;)
    {
      startActivityForResult(localIntent, paramInt);
      return;
      localIntent.putExtra("default_text", "");
    }
  }
  
  void b(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    this.jdField_b_of_type_AndroidWidgetEditText.setText(str);
    this.jdField_b_of_type_AndroidWidgetEditText.setHint(2131694590);
    a(this.jdField_h_of_type_AndroidViewView, this.jdField_b_of_type_AndroidWidgetEditText, getString(2131694591), str);
  }
  
  void c(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    this.jdField_c_of_type_AndroidWidgetEditText.setText(str);
    this.jdField_c_of_type_AndroidWidgetEditText.setHint(2131694684);
    a(this.jdField_i_of_type_AndroidViewView, this.jdField_c_of_type_AndroidWidgetEditText, getString(2131694685), str);
  }
  
  void d(String paramString)
  {
    boolean bool = false;
    String str1;
    if (!TextUtils.isEmpty(paramString))
    {
      str1 = paramString;
      if (!paramString.equals("不限")) {}
    }
    else
    {
      str1 = getString(2131694633);
      bool = true;
    }
    a(this.jdField_h_of_type_AndroidWidgetTextView, str1, bool);
    paramString = this.jdField_j_of_type_AndroidViewView;
    TextView localTextView = this.jdField_h_of_type_AndroidWidgetTextView;
    String str2 = getString(2131694634);
    if (!bool) {}
    for (;;)
    {
      a(paramString, localTextView, str2, str1);
      return;
      str1 = "";
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1002) {
      if (paramInt2 != 1001) {
        this.jdField_a_of_type_Amov.f();
      }
    }
    label221:
    do
    {
      do
      {
        do
        {
          do
          {
            Object localObject;
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        int i1;
                        do
                        {
                          do
                          {
                            return;
                            if (paramInt1 != 1003) {
                              break;
                            }
                          } while (paramIntent == null);
                          i1 = paramIntent.getShortExtra("param_year", (short)1990);
                          int i2 = paramIntent.getByteExtra("param_month", (byte)1);
                          int i3 = paramIntent.getByteExtra("param_day", (byte)1);
                          paramInt1 = paramIntent.getIntExtra("param_age", 0);
                          paramInt2 = paramIntent.getIntExtra("param_constellation_id", 0);
                          i1 = i1 << 16 | i2 << 8 | i3;
                        } while (i1 == this.jdField_b_of_type_Int);
                        this.jdField_d_of_type_Boolean = true;
                        a(i1, paramInt1, paramInt2);
                        return;
                        if (paramInt1 != 1004) {
                          break;
                        }
                      } while (paramIntent == null);
                      paramInt1 = paramIntent.getIntExtra("param_id", -1);
                    } while (paramInt1 == this.jdField_e_of_type_Int);
                    this.jdField_e_of_type_Boolean = true;
                    a(paramInt1);
                    return;
                    if (paramInt1 != 1005) {
                      break;
                    }
                  } while (paramIntent == null);
                  localObject = paramIntent.getStringArrayExtra("param_location");
                } while (a(this.jdField_a_of_type_ArrayOfJavaLangString, (String[])localObject));
                this.jdField_f_of_type_Boolean = true;
                this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])localObject);
                paramIntent = null;
                try
                {
                  localObject = this.jdField_a_of_type_Ampm.a((String[])localObject);
                  paramIntent = (Intent)localObject;
                }
                catch (Exception localException2)
                {
                  break label221;
                }
                if (!TextUtils.isEmpty(paramIntent))
                {
                  localObject = paramIntent;
                  if (!paramIntent.equals("不限")) {}
                }
                else
                {
                  localObject = "";
                }
                d((String)localObject);
                return;
                if (paramInt1 != 1006) {
                  break;
                }
              } while (paramIntent == null);
              localObject = paramIntent.getStringArrayExtra("param_location");
            } while (a(this.jdField_b_of_type_ArrayOfJavaLangString, (String[])localObject));
            this.jdField_g_of_type_Boolean = true;
            this.jdField_b_of_type_ArrayOfJavaLangString = ((String[])localObject);
            paramIntent = null;
            try
            {
              localObject = this.jdField_a_of_type_Ampm.a((String[])localObject);
              paramIntent = (Intent)localObject;
            }
            catch (Exception localException1)
            {
              break label312;
            }
            if (!TextUtils.isEmpty(paramIntent))
            {
              localObject = paramIntent;
              if (!paramIntent.equals("不限")) {}
            }
            else
            {
              localObject = "";
            }
            e((String)localObject);
            return;
            if (paramInt1 != 1007) {
              break;
            }
          } while (paramIntent == null);
          paramIntent = paramIntent.getStringExtra("result");
        } while (paramIntent.equals(this.jdField_e_of_type_JavaLangString));
        this.jdField_h_of_type_Boolean = true;
        g(paramIntent);
        return;
        if (paramInt1 == 1011)
        {
          a();
          return;
        }
      } while (paramInt1 != 1012);
      if (QLog.isDevelopLevel()) {
        QLog.d("FriendProfileMoreInfoActivity", 2, "doOnActivityResult school web");
      }
    } while (this.jdField_a_of_type_Amov == null);
    label312:
    paramIntent = this.app.getCurrentAccountUin();
    this.jdField_a_of_type_Amov.a(paramIntent, paramIntent, 1, 0L, (byte)1, 0L, 0L, null, "", 0L, 10004, null, (byte)0);
    c();
  }
  
  /* Error */
  public boolean doOnCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 1297	com/tencent/mobileqq/activity/ProfileActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   5: pop
    //   6: aload_0
    //   7: ldc_w 1298
    //   10: invokespecial 1301	com/tencent/mobileqq/activity/ProfileActivity:setContentView	(I)V
    //   13: aload_0
    //   14: new 777	bjng
    //   17: dup
    //   18: invokestatic 1307	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   21: aload_0
    //   22: invokespecial 1310	bjng:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   25: putfield 773	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Bjng	Lbjng;
    //   28: aload_0
    //   29: invokevirtual 1314	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:getIntent	()Landroid/content/Intent;
    //   32: astore_1
    //   33: aload_0
    //   34: aload_1
    //   35: ldc_w 1316
    //   38: iconst_0
    //   39: invokevirtual 1320	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   42: putfield 80	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_i_of_type_Boolean	Z
    //   45: aload_0
    //   46: aload_1
    //   47: ldc_w 1203
    //   50: invokevirtual 1284	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   53: putfield 84	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   56: aload_0
    //   57: aload_1
    //   58: ldc_w 1322
    //   61: invokevirtual 1284	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   64: putfield 86	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   67: aload_0
    //   68: aload_1
    //   69: ldc_w 1324
    //   72: invokevirtual 1284	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   75: putfield 88	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   78: aload_0
    //   79: getfield 88	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   82: invokestatic 332	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   85: ifne +91 -> 176
    //   88: new 1326	org/json/JSONObject
    //   91: dup
    //   92: aload_0
    //   93: getfield 88	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   96: invokespecial 1328	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   99: astore_3
    //   100: aload_0
    //   101: aload_3
    //   102: ldc_w 1203
    //   105: invokevirtual 1331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   108: putfield 84	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   111: aload_0
    //   112: aload_3
    //   113: ldc_w 1322
    //   116: invokevirtual 1331	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   119: putfield 86	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   122: aload_0
    //   123: getfield 84	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   126: invokestatic 332	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   129: ifne +18 -> 147
    //   132: aload_0
    //   133: getfield 86	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   136: invokestatic 332	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   139: ifne +8 -> 147
    //   142: aload_0
    //   143: iconst_1
    //   144: putfield 80	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_i_of_type_Boolean	Z
    //   147: invokestatic 190	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +26 -> 176
    //   153: ldc 192
    //   155: iconst_2
    //   156: ldc_w 1333
    //   159: iconst_1
    //   160: anewarray 264	java/lang/Object
    //   163: dup
    //   164: iconst_0
    //   165: aload_0
    //   166: getfield 88	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   169: aastore
    //   170: invokestatic 1336	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   173: invokestatic 755	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: aload_0
    //   177: aload_0
    //   178: getfield 179	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   181: iconst_2
    //   182: invokevirtual 1340	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   185: checkcast 540	amov
    //   188: putfield 538	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Amov	Lamov;
    //   191: aload_0
    //   192: aload_0
    //   193: getfield 179	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   196: bipush 59
    //   198: invokevirtual 487	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   201: checkcast 618	ampm
    //   204: putfield 616	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Ampm	Lampm;
    //   207: aload_0
    //   208: new 1342	bhha
    //   211: dup
    //   212: aload_0
    //   213: getfield 179	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   216: aconst_null
    //   217: invokespecial 1345	bhha:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;Lbhhb;)V
    //   220: putfield 1347	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Bhha	Lbhha;
    //   223: aload_0
    //   224: aload_0
    //   225: getfield 95	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqAppCardObserver	Lcom/tencent/mobileqq/app/CardObserver;
    //   228: invokevirtual 1351	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:addObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   231: aload_0
    //   232: aload_0
    //   233: getfield 105	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Amsu	Lamsu;
    //   236: invokevirtual 1351	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:addObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   239: aload_0
    //   240: getfield 179	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   243: aload_0
    //   244: getfield 100	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Apgj	Lapgj;
    //   247: invokevirtual 1355	com/tencent/mobileqq/app/QQAppInterface:registObserver	(Lmqq/observer/BusinessObserver;)V
    //   250: aload_0
    //   251: getfield 616	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Ampm	Lampm;
    //   254: aload_0
    //   255: invokevirtual 1357	ampm:a	(Ljava/lang/Object;)V
    //   258: new 1359	android/content/IntentFilter
    //   261: dup
    //   262: invokespecial 1360	android/content/IntentFilter:<init>	()V
    //   265: astore_3
    //   266: aload_3
    //   267: ldc_w 1362
    //   270: invokevirtual 1365	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   273: aload_0
    //   274: aload_0
    //   275: getfield 115	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   278: aload_3
    //   279: invokevirtual 1369	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   282: pop
    //   283: aload_0
    //   284: ldc_w 1370
    //   287: invokespecial 1371	com/tencent/mobileqq/activity/ProfileActivity:findViewById	(I)Landroid/view/View;
    //   290: checkcast 384	android/widget/LinearLayout
    //   293: astore_3
    //   294: invokestatic 1376	com/tencent/widget/immersive/ImmersiveUtils:isSupporImmersive	()I
    //   297: iconst_1
    //   298: if_icmpne +19 -> 317
    //   301: aload_3
    //   302: iconst_1
    //   303: invokevirtual 1379	android/widget/LinearLayout:setFitsSystemWindows	(Z)V
    //   306: aload_3
    //   307: iconst_0
    //   308: aload_0
    //   309: invokestatic 1383	com/tencent/widget/immersive/ImmersiveUtils:getStatusBarHeight	(Landroid/content/Context;)I
    //   312: iconst_0
    //   313: iconst_0
    //   314: invokevirtual 1384	android/widget/LinearLayout:setPadding	(IIII)V
    //   317: aload_0
    //   318: invokespecial 1385	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:f	()V
    //   321: aload_0
    //   322: aload_0
    //   323: invokevirtual 1314	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:getIntent	()Landroid/content/Intent;
    //   326: ldc_w 1387
    //   329: invokevirtual 1391	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   332: checkcast 1393	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   335: putfield 1007	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   338: aload_0
    //   339: aload_0
    //   340: invokevirtual 1314	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:getIntent	()Landroid/content/Intent;
    //   343: ldc_w 1395
    //   346: invokevirtual 1391	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   349: checkcast 1397	com/tencent/mobileqq/businessCard/data/BusinessCard
    //   352: putfield 1399	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard	Lcom/tencent/mobileqq/businessCard/data/BusinessCard;
    //   355: aload_0
    //   356: getfield 1007	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   359: ifnonnull +22 -> 381
    //   362: aload_0
    //   363: new 1393	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   366: dup
    //   367: aload_0
    //   368: getfield 179	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   371: invokevirtual 1402	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   374: iconst_0
    //   375: invokespecial 1404	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   378: putfield 1007	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   381: aload_0
    //   382: getfield 1399	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard	Lcom/tencent/mobileqq/businessCard/data/BusinessCard;
    //   385: ifnonnull +14 -> 399
    //   388: aload_0
    //   389: aload_0
    //   390: getfield 179	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   393: invokestatic 1409	aphs:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/businessCard/data/BusinessCard;
    //   396: putfield 1399	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard	Lcom/tencent/mobileqq/businessCard/data/BusinessCard;
    //   399: new 1411	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity$5
    //   402: dup
    //   403: aload_0
    //   404: invokespecial 1412	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity$5:<init>	(Lcom/tencent/mobileqq/activity/FriendProfileMoreInfoActivity;)V
    //   407: iconst_5
    //   408: aconst_null
    //   409: iconst_1
    //   410: invokestatic 1417	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   413: aload_0
    //   414: getfield 80	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_i_of_type_Boolean	Z
    //   417: ifne +26 -> 443
    //   420: aload_0
    //   421: aload_0
    //   422: getfield 179	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   425: bipush 112
    //   427: invokevirtual 487	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   430: checkcast 522	apgi
    //   433: invokevirtual 525	apgi:a	()Ljava/util/ArrayList;
    //   436: invokespecial 171	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:a	(Ljava/util/ArrayList;)V
    //   439: aload_0
    //   440: invokespecial 1291	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:c	()V
    //   443: aload_1
    //   444: ldc_w 1419
    //   447: iconst_0
    //   448: invokevirtual 1267	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   451: istore_2
    //   452: iload_2
    //   453: ifle +40 -> 493
    //   456: invokestatic 190	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   459: ifeq +29 -> 488
    //   462: ldc 192
    //   464: iconst_2
    //   465: new 507	java/lang/StringBuilder
    //   468: dup
    //   469: invokespecial 508	java/lang/StringBuilder:<init>	()V
    //   472: ldc_w 1421
    //   475: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: iload_2
    //   479: invokevirtual 564	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   482: invokevirtual 518	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   485: invokestatic 755	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   488: aload_0
    //   489: iload_2
    //   490: invokespecial 1422	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:c	(I)V
    //   493: aload_0
    //   494: getfield 179	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   497: ldc 225
    //   499: ldc 82
    //   501: ldc 82
    //   503: ldc_w 1424
    //   506: ldc_w 1424
    //   509: iconst_0
    //   510: iconst_0
    //   511: ldc 82
    //   513: ldc 82
    //   515: ldc 82
    //   517: ldc 82
    //   519: invokestatic 232	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   522: iconst_1
    //   523: ireturn
    //   524: astore_1
    //   525: aload_1
    //   526: invokevirtual 1427	java/lang/Exception:printStackTrace	()V
    //   529: aload_0
    //   530: invokevirtual 819	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:finish	()V
    //   533: iconst_0
    //   534: ireturn
    //   535: astore_3
    //   536: aload_3
    //   537: invokevirtual 1428	org/json/JSONException:printStackTrace	()V
    //   540: ldc 192
    //   542: iconst_1
    //   543: aload_3
    //   544: invokevirtual 1431	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   547: invokestatic 755	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   550: goto -403 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	553	0	this	FriendProfileMoreInfoActivity
    //   0	553	1	paramBundle	Bundle
    //   451	39	2	i1	int
    //   99	208	3	localObject	Object
    //   535	9	3	localJSONException	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   6	13	524	java/lang/Exception
    //   88	147	535	org/json/JSONException
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Bhha != null)
    {
      this.jdField_a_of_type_Bhha.a();
      this.jdField_a_of_type_Bhha = null;
    }
    if (this.jdField_a_of_type_Ampm != null)
    {
      this.jdField_a_of_type_Ampm.b(this);
      this.jdField_a_of_type_Ampm.d(this.jdField_a_of_type_Ampq);
      this.jdField_a_of_type_Ampm = null;
    }
    if (!this.jdField_b_of_type_Boolean) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
    removeObserver(this.jdField_a_of_type_Amsu);
    this.app.unRegistObserver(this.jdField_a_of_type_Apgj);
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("FriendProfileMoreInfoActivity", 2, "doOnDestroy unregisterReceiver, e:" + localIllegalArgumentException.getMessage());
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("FriendProfileMoreInfoActivity", 2, "doOnDestroy unregisterReceiver, e:" + localException.getMessage());
    }
  }
  
  void e(String paramString)
  {
    boolean bool = false;
    String str1;
    if (!TextUtils.isEmpty(paramString))
    {
      str1 = paramString;
      if (!paramString.equals("不限")) {}
    }
    else
    {
      str1 = getString(2131694627);
      bool = true;
    }
    a(this.jdField_i_of_type_AndroidWidgetTextView, str1, bool);
    paramString = this.k;
    TextView localTextView = this.jdField_i_of_type_AndroidWidgetTextView;
    String str2 = getString(2131694628);
    if (!bool) {}
    for (;;)
    {
      a(paramString, localTextView, str2, str1);
      return;
      str1 = "";
    }
  }
  
  void f(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    this.jdField_d_of_type_AndroidWidgetEditText.setText(str);
    this.jdField_d_of_type_AndroidWidgetEditText.setHint(2131694620);
    a(this.l, this.jdField_d_of_type_AndroidWidgetEditText, getString(2131694621), str);
  }
  
  public void finish()
  {
    Intent localIntent = new Intent();
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      localIntent.putExtra("result", this.jdField_a_of_type_AndroidOsBundle);
    }
    setResult(-1, localIntent);
    super.finish();
  }
  
  void g(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
    int i1;
    if (TextUtils.isEmpty(paramString)) {
      i1 = 1;
    }
    for (String str1 = getString(2131694651);; str1 = paramString)
    {
      a(this.jdField_j_of_type_AndroidWidgetTextView, str1, TextUtils.isEmpty(paramString));
      paramString = this.m;
      TextView localTextView = this.jdField_j_of_type_AndroidWidgetTextView;
      String str2 = getString(2131694652);
      if (i1 == 0) {}
      for (;;)
      {
        a(paramString, localTextView, str2, str1);
        return;
        str1 = "";
      }
      i1 = 0;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return true;
    } while ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 2));
    i();
    QQToast.a(this, 2131690945, 0).b(getTitleBarHeight());
    return true;
  }
  
  public boolean onBackEvent()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.requestFocus();
      }
      label15:
      e();
      return true;
    }
    catch (Exception localException)
    {
      break label15;
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {}
    try
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.requestFocus();
      switch (paramView.getId())
      {
      default: 
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("FriendProfileMoreInfoActivity", 1, "onClick fail.", localThrowable);
        continue;
        e();
        continue;
        Object localObject = new Intent(this, AvatarPendantActivity.class);
        ((Intent)localObject).putExtra("AllInOne", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        ((Intent)localObject).putExtra("showActionSheet", true);
        startActivity((Intent)localObject);
        bcef.b(this.app, "dc00898", "", "", "0X8007EC5", "0X8007EC5", 0, 0, "", "", "", "");
        continue;
        g();
        bcef.b(this.app, "dc00898", "", "", "0X8007EC6", "0X8007EC6", 0, 0, "", "", "", "");
        continue;
        h();
        continue;
        localObject = ((TroopManager)this.app.getManager(52)).b(this.jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          if ((((TroopInfo)localObject).isTroopAdmin(this.app.getCurrentAccountUin())) || (((TroopInfo)localObject).isTroopOwner(this.app.getCurrentAccountUin())) || (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app.getCurrentAccountUin())))
          {
            a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 1011);
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("FriendProfileMoreInfoActivity", 2, "openModifyNickNamePage right invalidate-----------");
            continue;
            localObject = new Intent(this, AgeSelectionActivity.class);
            ((Intent)localObject).putExtra("param_birthday", this.jdField_b_of_type_Int);
            startActivityForResult((Intent)localObject, 1003);
            continue;
            localObject = new Intent(this, JobSelectionActivity.class);
            ((Intent)localObject).putExtra("param_id", this.jdField_e_of_type_Int);
            startActivityForResult((Intent)localObject, 1004);
            continue;
            d(1);
            continue;
            d(2);
            continue;
            localObject = new Intent(this, EditActivity.class);
            ((Intent)localObject).putExtra("title", 2131694652).putExtra("limit", 383).putExtra("canPostNull", true).putExtra("hint", 2131694651).putExtra("multiLine", true).putExtra("current", this.jdField_e_of_type_JavaLangString).putExtra("action", 104).putExtra("key_title_style", 0).putExtra("key_hide_clear_btn", true).putExtra("key_null_bg", true).putExtra("key_simple_count_style", true);
            startActivityForResult((Intent)localObject, 1007);
            continue;
            b(1);
            h(String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", new Object[] { Integer.valueOf(3) }));
            continue;
            b(2);
            h(String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", new Object[] { Integer.valueOf(2) }));
            continue;
            b(3);
            h(String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", new Object[] { Integer.valueOf(1) }));
            continue;
            b(4);
            d();
            continue;
            bcef.b(this.app, "dc00898", "", "", "0X800A0D6", "0X800A0D6", 0, 0, "", "", "", "");
            if ((paramView.getTag() instanceof aymx))
            {
              localObject = (aymx)paramView.getTag();
              h(String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994&idx=%d", new Object[] { Integer.valueOf(((aymx)localObject).jdField_b_of_type_Int), Integer.valueOf(((aymx)localObject).jdField_a_of_type_Int) }));
            }
            else if ((paramView.getTag() instanceof Card))
            {
              h("https://ti.qq.com/hybrid-h5/school_relation/chooseschool?_wv=67108994");
            }
          }
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (paramView != this.jdField_a_of_type_AndroidWidgetEditText) {
        break label70;
      }
      if (this.jdField_a_of_type_Adkj.jdField_b_of_type_Boolean)
      {
        paramView = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
        if ((!TextUtils.isEmpty(paramView)) && (!TextUtils.isEmpty(paramView.trim()))) {}
      }
    }
    label70:
    Matcher localMatcher;
    do
    {
      QQToast.a(this, amtj.a(2131704009), 0).b(getTitleBarHeight());
      do
      {
        return;
      } while ((paramView != this.jdField_d_of_type_AndroidWidgetEditText) || (!this.jdField_d_of_type_Adkj.jdField_b_of_type_Boolean));
      paramView = this.jdField_d_of_type_AndroidWidgetEditText.getText().toString();
      localMatcher = SearchBaseActivity.a.matcher(paramView);
    } while ((TextUtils.isEmpty(paramView)) || (localMatcher.matches()));
    QQToast.a(this, amtj.a(2131704033), 0).b(getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity
 * JD-Core Version:    0.7.0.1
 */