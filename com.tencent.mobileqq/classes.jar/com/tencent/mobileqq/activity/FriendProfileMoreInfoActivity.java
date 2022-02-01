package com.tencent.mobileqq.activity;

import Override;
import aera;
import aerb;
import aerc;
import aerd;
import aere;
import aerf;
import aerg;
import aerh;
import aeri;
import aerj;
import aerk;
import aerl;
import agej;
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
import anum;
import anuw;
import anve;
import anvi;
import anyu;
import anyw;
import anzj;
import aqmx;
import aqmy;
import azxy;
import azyi;
import bdll;
import begb;
import bgpk;
import bhhu;
import bhhz;
import bhlg;
import bhlq;
import bhnv;
import bhpc;
import bhto;
import bhwz;
import bjaz;
import bjbs;
import bjcf;
import blhq;
import blir;
import blji;
import bnkk;
import bnkl;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
  public aerl a;
  protected BroadcastReceiver a;
  public Bundle a;
  private View jdField_a_of_type_AndroidViewView;
  public EditText a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  anum jdField_a_of_type_Anum;
  public anuw a;
  anve jdField_a_of_type_Anve;
  private anvi jdField_a_of_type_Anvi = new aerh(this);
  private anyu jdField_a_of_type_Anyu = new aerg(this);
  private aqmy jdField_a_of_type_Aqmy = new aerf(this);
  bjaz jdField_a_of_type_Bjaz;
  bjbs jdField_a_of_type_Bjbs = null;
  blhq jdField_a_of_type_Blhq;
  public blir a;
  public ProfileActivity.AllInOne a;
  public BusinessCard a;
  private IphonePickerView jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  ColorNickTextView jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView;
  public String a;
  public boolean a;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int jdField_b_of_type_Int;
  public aerl b;
  private View jdField_b_of_type_AndroidViewView;
  public EditText b;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public bjbs b;
  String jdField_b_of_type_JavaLangString = "";
  public boolean b;
  String[] jdField_b_of_type_ArrayOfJavaLangString;
  private int jdField_c_of_type_Int;
  public aerl c;
  private View jdField_c_of_type_AndroidViewView;
  public EditText c;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString = "";
  public boolean c;
  private int jdField_d_of_type_Int;
  public aerl d;
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
    this.jdField_b_of_type_Bjbs = null;
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
    this.jdField_a_of_type_Anuw = new aera(this);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aere(this);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    new bjcf(this).a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  private void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Bjbs == null) {
      this.jdField_a_of_type_Bjbs = new bjbs(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_Bjbs.a(paramString);
    this.jdField_a_of_type_Bjbs.show();
  }
  
  private void a(Card paramCard)
  {
    if ((paramCard != null) && (!this.jdField_i_of_type_Boolean) && (bhhz.a(paramCard, this.app)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FriendProfileMoreInfoActivity", 2, "checkEduFirstGuide:");
      }
      String str = anzj.a(2131703801);
      bhlq.a(this, anzj.a(2131703780), str, null, 2131694473, 2131694474, new aeri(this), new aerj(this)).show();
      bhhz.a(paramCard, this.app);
      bdll.b(this.app, "dc00898", "", "", "0X800A0D7", "0X800A0D7", 0, 0, "", "", "", "");
    }
  }
  
  private void a(Card paramCard, boolean paramBoolean)
  {
    Object localObject2 = null;
    if (paramCard == null) {
      return;
    }
    if (paramCard.lCurrentStyleId != azxy.a) {}
    this.jdField_f_of_type_JavaLangString = paramCard.strNick;
    a(paramCard.getRichStatus());
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if ((!this.jdField_a_of_type_Aerl.jdField_b_of_type_Boolean) && (paramCard.strNick != null) && (!paramCard.strNick.equals(localObject1)))
    {
      this.jdField_a_of_type_Aerl.jdField_a_of_type_Boolean = true;
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
      if ((!this.jdField_b_of_type_Aerl.jdField_b_of_type_Boolean) && (paramCard.strCompany != null) && (!paramCard.strCompany.equals(localObject1)))
      {
        this.jdField_b_of_type_Aerl.jdField_a_of_type_Boolean = true;
        b(paramCard.strCompany);
      }
      localObject1 = this.jdField_c_of_type_AndroidWidgetEditText.getText().toString();
      if ((!this.jdField_c_of_type_Aerl.jdField_b_of_type_Boolean) && (paramCard.strSchool != null) && (!paramCard.strSchool.equals(localObject1)))
      {
        this.jdField_c_of_type_Aerl.jdField_a_of_type_Boolean = true;
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
      if ((!this.jdField_d_of_type_Aerl.jdField_b_of_type_Boolean) && (paramCard.strEmail != null) && (!paramCard.strEmail.equals(localObject1)))
      {
        this.jdField_d_of_type_Aerl.jdField_a_of_type_Boolean = true;
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
  
  private void a(ArrayList<azyi> paramArrayList)
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
          localObject1 = (azyi)paramArrayList.next();
        } while (TextUtils.isEmpty(((azyi)localObject1).jdField_b_of_type_JavaLangString));
        View localView = View.inflate(this, 2131561441, null);
        TextView localTextView = (TextView)localView.findViewById(2131377072);
        Object localObject2;
        if (((azyi)localObject1).jdField_b_of_type_Boolean)
        {
          localTextView.setText(((azyi)localObject1).jdField_b_of_type_JavaLangString);
          localObject2 = getResources().getDrawable(2130845158);
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
          localTextView.setCompoundDrawables(null, null, (Drawable)localObject2, null);
          localTextView.setCompoundDrawablePadding(agej.a(4.5F, localTextView.getResources()));
          label161:
          localTextView = (TextView)localView.findViewById(2131365905);
          localObject2 = ((azyi)localObject1).a();
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label252;
          }
          localTextView.setVisibility(8);
          label194:
          localTextView = (TextView)localView.findViewById(2131365906);
          if (!((azyi)localObject1).jdField_a_of_type_Boolean) {
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
          localTextView.setText(((azyi)localObject1).jdField_b_of_type_JavaLangString);
          break label161;
          label252:
          localTextView.setText((CharSequence)localObject2);
          break label194;
          label262:
          localTextView.setVisibility(8);
        }
      }
      paramArrayList = ((anyw)this.app.getManager(51)).c(this.app.getCurrentAccountUin());
      if ((paramArrayList != null) && (!TextUtils.isEmpty(paramArrayList.strSchool)))
      {
        localObject1 = View.inflate(this, 2131561441, null);
        ((TextView)((View)localObject1).findViewById(2131377072)).setText(paramArrayList.strSchool);
        ((TextView)((View)localObject1).findViewById(2131365905)).setVisibility(8);
        ((View)localObject1).setOnClickListener(this);
        ((View)localObject1).setTag(paramArrayList);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      }
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount() < 2)
      {
        this.n.findViewById(2131377063).setVisibility(0);
        this.n.findViewById(2131377067).setVisibility(0);
        this.n.findViewById(2131377065).setVisibility(0);
        this.n.findViewById(2131377061).setVisibility(8);
      }
    }
    else
    {
      return;
    }
    this.n.findViewById(2131377063).setVisibility(8);
    this.n.findViewById(2131377067).setVisibility(8);
    this.n.findViewById(2131377065).setVisibility(8);
    this.n.findViewById(2131377061).setVisibility(0);
  }
  
  private void a(boolean paramBoolean, Card paramCard)
  {
    if (QLog.isColorLevel()) {
      QLog.e("FriendProfileMoreInfoActivity", 2, "onDeleteOldSchoolResult:" + paramBoolean);
    }
    this.jdField_j_of_type_Boolean = false;
    if (paramBoolean) {
      a(((aqmx)this.app.getManager(112)).a());
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Aerl.jdField_b_of_type_Boolean) || (this.jdField_b_of_type_Aerl.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Aerl.jdField_b_of_type_Boolean) || (this.jdField_d_of_type_Aerl.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean) || (this.jdField_e_of_type_Boolean) || (this.jdField_f_of_type_Boolean) || (this.jdField_g_of_type_Boolean) || (this.jdField_h_of_type_Boolean);
  }
  
  private boolean a(Bundle paramBundle, int paramInt1, int paramInt2)
  {
    if (!bhnv.d(this)) {
      a(paramInt1, paramInt2);
    }
    while ((paramBundle == null) || (paramBundle.isEmpty())) {
      return false;
    }
    this.jdField_a_of_type_Anum.a(paramBundle);
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
    if (a(localBundle, 2131693965, 0)) {
      this.jdField_j_of_type_Boolean = true;
    }
  }
  
  private void b(int paramInt)
  {
    bdll.b(this.app, "dc00898", "", "", "0X800A0D5", "0X800A0D5", 0, 0, paramInt + "", "", "", "");
  }
  
  private boolean b()
  {
    Bundle localBundle = new Bundle();
    Object localObject1;
    if (this.jdField_a_of_type_Aerl.jdField_b_of_type_Boolean)
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
      if (this.jdField_b_of_type_Aerl.jdField_b_of_type_Boolean) {
        localBundle.putString("company", this.jdField_b_of_type_AndroidWidgetEditText.getText().toString());
      }
      if (this.jdField_c_of_type_Aerl.jdField_b_of_type_Boolean) {
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
      localObject2 = this.jdField_a_of_type_Anve.a(this.jdField_a_of_type_ArrayOfJavaLangString);
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
    if (this.jdField_d_of_type_Aerl.jdField_b_of_type_Boolean)
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
      return a(localBundle, 2131693965, 0);
      localBundle.putString("nick", ((String)localObject1).trim());
      localObject1 = new bnkl();
      ((bnkl)localObject1).jdField_a_of_type_Int = 5;
      bnkk.a(getAppRuntime().getAccount()).a((bnkl)localObject1);
      break;
      localBundle.putString("email", (String)localObject1);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Anum.a(this.app.getLongAccountUin());
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
    blir localblir = (blir)blji.a(this, null);
    localblir.a(2131694470, 0);
    localblir.a(2131694472, 0);
    localblir.a(2131694471, 0);
    localblir.c(2131690580);
    localblir.a(new aerk(this, localblir));
    localblir.show();
  }
  
  private void d(int paramInt)
  {
    int i1 = this.jdField_a_of_type_Anve.a();
    if (i1 != 0)
    {
      i1 = this.jdField_a_of_type_Anve.a(i1, true);
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileMoreInfoActivity", 2, "startLocationSelectActivity | update result = " + i1);
      }
      if (i1 == 2)
      {
        QQToast.a(this, 2131693965, 0).b(getTitleBarHeight());
        return;
      }
      if (i1 == 0)
      {
        a(paramInt, getString(2131690908));
        this.jdField_a_of_type_Anve.c(this.jdField_a_of_type_Anvi);
        return;
      }
      a(paramInt, getString(2131690908));
      this.jdField_a_of_type_Blhq.sendEmptyMessageDelayed(1000, 20000L);
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
      ((Intent)localObject1).putExtra("param_location_param", this.jdField_a_of_type_Anve.b((String[])localObject2));
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
      if (this.jdField_b_of_type_Bjbs == null)
      {
        this.jdField_b_of_type_Bjbs = new bjbs(this, getTitleBarHeight());
        this.jdField_b_of_type_Bjbs.a(anzj.a(2131703778));
      }
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_Bjbs.dismiss();
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
          this.jdField_b_of_type_Bjbs.show();
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131376942));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369088));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693005);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131693005));
    Object localObject = (TextView)findViewById(2131369042);
    ((TextView)localObject).setText("");
    ((TextView)localObject).setContentDescription(anzj.a(2131703824));
    ((TextView)localObject).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131365063));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131363132);
    this.jdField_a_of_type_AndroidViewView.setContentDescription(getString(2131691945));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363128));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131377721);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377723));
    a(null);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131379465);
    if (this.jdField_i_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)findViewById(2131379468));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379466));
      localObject = findViewById(2131379464);
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
      this.jdField_d_of_type_AndroidViewView = findViewById(2131371821);
      if (this.jdField_c_of_type_AndroidViewView.getVisibility() == 0) {
        ((LinearLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams()).setMargins(0, 0, 0, 0);
      }
      this.jdField_d_of_type_AndroidViewView.setClickable(false);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131371820));
      this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this);
      this.jdField_a_of_type_Aerl = new aerl(this, 36, this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_Aerl);
      this.jdField_a_of_type_Aerl.jdField_a_of_type_Boolean = true;
      a(null);
      this.jdField_e_of_type_AndroidViewView = findViewById(2131377477);
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377478));
      a(-1, false);
      this.jdField_f_of_type_AndroidViewView = findViewById(2131363506);
      this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363507));
      a(0, 0, 0);
      if (bhhz.b())
      {
        int i1 = this.jdField_e_of_type_AndroidViewView.getPaddingLeft();
        int i2 = this.jdField_e_of_type_AndroidViewView.getPaddingTop();
        int i3 = this.jdField_e_of_type_AndroidViewView.getPaddingRight();
        int i4 = this.jdField_e_of_type_AndroidViewView.getPaddingBottom();
        this.jdField_e_of_type_AndroidViewView.setBackgroundResource(2130839447);
        this.jdField_e_of_type_AndroidViewView.setPadding(i1, i2, i3, i4);
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
        if (QLog.isDevelopLevel()) {
          QLog.i("FriendProfileMoreInfoActivity", 4, String.format(Locale.getDefault(), "EuropeAndAmerica sexLayout[%s, %s, %s, %s]", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4) }));
        }
      }
      this.jdField_g_of_type_AndroidViewView = findViewById(2131373006);
      this.jdField_g_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373005));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373007));
      a(-1);
      this.jdField_h_of_type_AndroidViewView = findViewById(2131364915);
      this.jdField_h_of_type_AndroidViewView.setClickable(false);
      this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131364914));
      this.jdField_b_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this);
      this.jdField_b_of_type_Aerl = new aerl(this, 120, this.jdField_b_of_type_AndroidWidgetEditText);
      this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_b_of_type_Aerl);
      this.jdField_b_of_type_Aerl.jdField_a_of_type_Boolean = true;
      b(null);
      this.jdField_i_of_type_AndroidViewView = findViewById(2131377071);
      this.jdField_i_of_type_AndroidViewView.setClickable(false);
      this.jdField_c_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131377068));
      this.jdField_c_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this);
      this.jdField_c_of_type_Aerl = new aerl(this, 40, this.jdField_c_of_type_AndroidWidgetEditText);
      this.jdField_c_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_c_of_type_Aerl);
      this.jdField_c_of_type_Aerl.jdField_a_of_type_Boolean = true;
      c(null);
      this.jdField_j_of_type_AndroidViewView = findViewById(2131370360);
      this.jdField_j_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370374));
      d(null);
      this.k = findViewById(2131368088);
      this.k.setOnClickListener(this);
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368089));
      e(null);
      this.l = findViewById(2131365921);
      this.l.setClickable(false);
      this.jdField_d_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131365920));
      this.jdField_d_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this);
      this.jdField_d_of_type_Aerl = new aerl(this, 50, this.jdField_d_of_type_AndroidWidgetEditText);
      this.jdField_d_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_d_of_type_Aerl);
      this.jdField_d_of_type_Aerl.jdField_a_of_type_Boolean = true;
      f(null);
      this.m = findViewById(2131372423);
      this.m.setOnClickListener(this);
      this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372424));
      g(null);
      this.n = findViewById(2131365908);
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131362207));
      findViewById(2131377062).setOnClickListener(this);
      findViewById(2131377066).setOnClickListener(this);
      findViewById(2131377064).setOnClickListener(this);
      findViewById(2131377060).setOnClickListener(this);
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
    bhto.a(this, this.app, 0, "signature_ziliaoka", 1002);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Blir == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getLayoutInflater().inflate(2131561252, null));
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(new aerb(this));
      this.jdField_a_of_type_Blir = blir.c(this);
      this.jdField_a_of_type_Blir.e(true);
      this.jdField_a_of_type_Blir.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
      localObject = (DispatchActionMoveScrollView)this.jdField_a_of_type_Blir.findViewById(2131361980);
      ((DispatchActionMoveScrollView)localObject).jdField_a_of_type_Boolean = true;
      ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = this.jdField_a_of_type_Blir.getWindow();
        if (localObject != null) {
          ((Window)localObject).setFlags(16777216, 16777216);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(new aerc(this));
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
        this.jdField_a_of_type_Blir.setOnDismissListener(new aerd(this));
        this.jdField_a_of_type_Blir.show();
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
    if ((this.jdField_a_of_type_Bjbs != null) && (this.jdField_a_of_type_Bjbs.isShowing())) {
      this.jdField_a_of_type_Bjbs.dismiss();
    }
  }
  
  void a()
  {
    String str = bhlg.i(this.app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    if ((TextUtils.isEmpty(str)) || (TextUtils.equals(str, this.jdField_b_of_type_JavaLangString)))
    {
      str = "";
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      SpannableString localSpannableString = new begb(str, 16).a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText(localSpannableString);
      bhwz.a(this.app, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, localSpannableString);
      a(this.jdField_c_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, getString(2131696895), str);
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
    if (bhhu.a(paramInt))
    {
      this.jdField_e_of_type_Int = paramInt;
      localObject2 = bhhu.e(paramInt);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        this.jdField_e_of_type_Int = -1;
        localObject1 = getString(2131694566);
      }
      if ((paramInt < bhhu.e.length - 1) && (paramInt > 0)) {
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
      str = getString(2131694567);
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
      localObject2 = getResources().getDrawable(bhhu.b[paramInt]);
      ProfileActivity.a(this.app, (Drawable)localObject2);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localObject2);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(bhhu.e[paramInt]);
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
    String str1 = getString(2131694465);
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
      str2 = getString(2131694466);
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
    String str = getString(2131694570);
    if (paramInt == 0)
    {
      str = getString(2131693473);
      if (!paramBoolean) {
        break label88;
      }
      a(this.jdField_d_of_type_AndroidWidgetTextView, str, 2131166998);
      if ((paramInt != 0) && (paramInt != 1)) {
        break label121;
      }
    }
    for (;;)
    {
      a(this.jdField_e_of_type_AndroidViewView, this.jdField_d_of_type_AndroidWidgetTextView, getString(2131694571), str);
      return;
      if (paramInt != 1) {
        break;
      }
      str = getString(2131692060);
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
      paramView1 = paramString1 + anzj.a(2131703805) + paramString2 + ",";
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
    for (int i1 = 2131167076;; i1 = 2131166990)
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
      a(this.jdField_b_of_type_AndroidViewView, this.jdField_c_of_type_AndroidWidgetTextView, getString(2131693054), paramRichStatus);
      return;
      paramRichStatus = anzj.a(2131703813);
      bool = true;
    }
  }
  
  void a(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString))
    {
      str = "";
      paramString = getString(2131694522);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(str);
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(paramString);
      a(this.jdField_d_of_type_AndroidViewView, this.jdField_a_of_type_AndroidWidgetEditText, getString(2131694523), str);
      return;
      str = paramString;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (TroopInfo.isHomeworkTroop(this.app, paramString1))
    {
      bgpk.a(this, paramString2, paramString1, "qqProfile");
      return;
    }
    Intent localIntent = new Intent(this, EditInfoActivity.class);
    localIntent.putExtra("edit_type", 0);
    localIntent.putExtra("troopUin", paramString1);
    localIntent.putExtra("uin", paramString2);
    paramString1 = "";
    if (paramInt == 1011)
    {
      paramString1 = getString(2131696899);
      localIntent.putExtra("isTroopNick", true);
      localIntent.putExtra("default_text", this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getText().toString() + "");
      localIntent.putExtra("max_num", 60);
    }
    localIntent.putExtra("title", paramString1);
    if (TextUtils.isEmpty("")) {
      localIntent.putExtra("default_hint", anzj.a(2131703786));
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
    this.jdField_b_of_type_AndroidWidgetEditText.setHint(2131694476);
    a(this.jdField_h_of_type_AndroidViewView, this.jdField_b_of_type_AndroidWidgetEditText, getString(2131694477), str);
  }
  
  void c(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    this.jdField_c_of_type_AndroidWidgetEditText.setText(str);
    this.jdField_c_of_type_AndroidWidgetEditText.setHint(2131694568);
    a(this.jdField_i_of_type_AndroidViewView, this.jdField_c_of_type_AndroidWidgetEditText, getString(2131694569), str);
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
      str1 = getString(2131694518);
      bool = true;
    }
    a(this.jdField_h_of_type_AndroidWidgetTextView, str1, bool);
    paramString = this.jdField_j_of_type_AndroidViewView;
    TextView localTextView = this.jdField_h_of_type_AndroidWidgetTextView;
    String str2 = getString(2131694519);
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
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1002) {
      if (paramInt2 != 1001) {
        this.jdField_a_of_type_Anum.f();
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
                  localObject = this.jdField_a_of_type_Anve.a((String[])localObject);
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
              localObject = this.jdField_a_of_type_Anve.a((String[])localObject);
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
    } while (this.jdField_a_of_type_Anum == null);
    label312:
    paramIntent = this.app.getCurrentAccountUin();
    this.jdField_a_of_type_Anum.a(paramIntent, paramIntent, 1, 0L, (byte)1, 0L, 0L, null, "", 0L, 10004, null, (byte)0);
    c();
  }
  
  /* Error */
  public boolean doOnCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 1289	com/tencent/mobileqq/activity/ProfileActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   5: pop
    //   6: aload_0
    //   7: ldc_w 1290
    //   10: invokespecial 1293	com/tencent/mobileqq/activity/ProfileActivity:setContentView	(I)V
    //   13: aload_0
    //   14: new 771	blhq
    //   17: dup
    //   18: invokestatic 1299	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   21: aload_0
    //   22: invokespecial 1302	blhq:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   25: putfield 767	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Blhq	Lblhq;
    //   28: aload_0
    //   29: invokevirtual 1306	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:getIntent	()Landroid/content/Intent;
    //   32: astore_1
    //   33: aload_0
    //   34: aload_1
    //   35: ldc_w 1308
    //   38: iconst_0
    //   39: invokevirtual 1312	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   42: putfield 80	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_i_of_type_Boolean	Z
    //   45: aload_0
    //   46: aload_1
    //   47: ldc_w 1194
    //   50: invokevirtual 1276	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   53: putfield 84	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   56: aload_0
    //   57: aload_1
    //   58: ldc_w 1314
    //   61: invokevirtual 1276	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   64: putfield 86	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   67: aload_0
    //   68: aload_1
    //   69: ldc_w 1316
    //   72: invokevirtual 1276	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   75: putfield 88	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   78: aload_0
    //   79: getfield 88	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   82: invokestatic 332	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   85: ifne +91 -> 176
    //   88: new 1318	org/json/JSONObject
    //   91: dup
    //   92: aload_0
    //   93: getfield 88	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   96: invokespecial 1320	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   99: astore_3
    //   100: aload_0
    //   101: aload_3
    //   102: ldc_w 1194
    //   105: invokevirtual 1323	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   108: putfield 84	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   111: aload_0
    //   112: aload_3
    //   113: ldc_w 1314
    //   116: invokevirtual 1323	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
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
    //   156: ldc_w 1325
    //   159: iconst_1
    //   160: anewarray 264	java/lang/Object
    //   163: dup
    //   164: iconst_0
    //   165: aload_0
    //   166: getfield 88	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   169: aastore
    //   170: invokestatic 1328	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   173: invokestatic 749	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: aload_0
    //   177: aload_0
    //   178: getfield 179	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   181: iconst_2
    //   182: invokevirtual 1331	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lanud;
    //   185: checkcast 538	anum
    //   188: putfield 536	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Anum	Lanum;
    //   191: aload_0
    //   192: aload_0
    //   193: getfield 179	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   196: bipush 59
    //   198: invokevirtual 486	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   201: checkcast 616	anve
    //   204: putfield 614	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Anve	Lanve;
    //   207: aload_0
    //   208: new 1333	bjaz
    //   211: dup
    //   212: aload_0
    //   213: getfield 179	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   216: aconst_null
    //   217: invokespecial 1336	bjaz:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;Lbjba;)V
    //   220: putfield 1338	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Bjaz	Lbjaz;
    //   223: aload_0
    //   224: aload_0
    //   225: getfield 95	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Anuw	Lanuw;
    //   228: invokevirtual 1342	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:addObserver	(Lanui;)V
    //   231: aload_0
    //   232: aload_0
    //   233: getfield 105	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Anyu	Lanyu;
    //   236: invokevirtual 1342	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:addObserver	(Lanui;)V
    //   239: aload_0
    //   240: getfield 179	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   243: aload_0
    //   244: getfield 100	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Aqmy	Laqmy;
    //   247: invokevirtual 1346	com/tencent/mobileqq/app/QQAppInterface:registObserver	(Lmqq/observer/BusinessObserver;)V
    //   250: aload_0
    //   251: getfield 614	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Anve	Lanve;
    //   254: aload_0
    //   255: invokevirtual 1348	anve:a	(Ljava/lang/Object;)V
    //   258: new 1350	android/content/IntentFilter
    //   261: dup
    //   262: invokespecial 1351	android/content/IntentFilter:<init>	()V
    //   265: astore_3
    //   266: aload_3
    //   267: ldc_w 1353
    //   270: invokevirtual 1356	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   273: aload_0
    //   274: aload_0
    //   275: getfield 115	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   278: aload_3
    //   279: invokevirtual 1360	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   282: pop
    //   283: aload_0
    //   284: ldc_w 1361
    //   287: invokespecial 1362	com/tencent/mobileqq/activity/ProfileActivity:findViewById	(I)Landroid/view/View;
    //   290: checkcast 384	android/widget/LinearLayout
    //   293: astore_3
    //   294: invokestatic 1367	com/tencent/widget/immersive/ImmersiveUtils:isSupporImmersive	()I
    //   297: iconst_1
    //   298: if_icmpne +19 -> 317
    //   301: aload_3
    //   302: iconst_1
    //   303: invokevirtual 1370	android/widget/LinearLayout:setFitsSystemWindows	(Z)V
    //   306: aload_3
    //   307: iconst_0
    //   308: aload_0
    //   309: invokestatic 1374	com/tencent/widget/immersive/ImmersiveUtils:getStatusBarHeight	(Landroid/content/Context;)I
    //   312: iconst_0
    //   313: iconst_0
    //   314: invokevirtual 1375	android/widget/LinearLayout:setPadding	(IIII)V
    //   317: aload_0
    //   318: invokespecial 1376	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:f	()V
    //   321: aload_0
    //   322: aload_0
    //   323: invokevirtual 1306	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:getIntent	()Landroid/content/Intent;
    //   326: ldc_w 1378
    //   329: invokevirtual 1382	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   332: checkcast 1384	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   335: putfield 1001	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   338: aload_0
    //   339: aload_0
    //   340: invokevirtual 1306	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:getIntent	()Landroid/content/Intent;
    //   343: ldc_w 1386
    //   346: invokevirtual 1382	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   349: checkcast 1388	com/tencent/mobileqq/businessCard/data/BusinessCard
    //   352: putfield 1390	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard	Lcom/tencent/mobileqq/businessCard/data/BusinessCard;
    //   355: aload_0
    //   356: getfield 1001	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   359: ifnonnull +22 -> 381
    //   362: aload_0
    //   363: new 1384	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   366: dup
    //   367: aload_0
    //   368: getfield 179	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   371: invokevirtual 1392	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   374: iconst_0
    //   375: invokespecial 1394	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   378: putfield 1001	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   381: aload_0
    //   382: getfield 1390	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard	Lcom/tencent/mobileqq/businessCard/data/BusinessCard;
    //   385: ifnonnull +14 -> 399
    //   388: aload_0
    //   389: aload_0
    //   390: getfield 179	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   393: invokestatic 1399	aqoj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/businessCard/data/BusinessCard;
    //   396: putfield 1390	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard	Lcom/tencent/mobileqq/businessCard/data/BusinessCard;
    //   399: new 1401	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity$5
    //   402: dup
    //   403: aload_0
    //   404: invokespecial 1402	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity$5:<init>	(Lcom/tencent/mobileqq/activity/FriendProfileMoreInfoActivity;)V
    //   407: iconst_5
    //   408: aconst_null
    //   409: iconst_1
    //   410: invokestatic 1407	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   413: aload_0
    //   414: getfield 80	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_i_of_type_Boolean	Z
    //   417: ifne +26 -> 443
    //   420: aload_0
    //   421: aload_0
    //   422: getfield 179	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   425: bipush 112
    //   427: invokevirtual 486	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   430: checkcast 521	aqmx
    //   433: invokevirtual 524	aqmx:a	()Ljava/util/ArrayList;
    //   436: invokespecial 171	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:a	(Ljava/util/ArrayList;)V
    //   439: aload_0
    //   440: invokespecial 1283	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:c	()V
    //   443: aload_1
    //   444: ldc_w 1409
    //   447: iconst_0
    //   448: invokevirtual 1259	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   451: istore_2
    //   452: iload_2
    //   453: ifle +40 -> 493
    //   456: invokestatic 190	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   459: ifeq +29 -> 488
    //   462: ldc 192
    //   464: iconst_2
    //   465: new 506	java/lang/StringBuilder
    //   468: dup
    //   469: invokespecial 507	java/lang/StringBuilder:<init>	()V
    //   472: ldc_w 1411
    //   475: invokevirtual 513	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: iload_2
    //   479: invokevirtual 562	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   482: invokevirtual 517	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   485: invokestatic 749	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   488: aload_0
    //   489: iload_2
    //   490: invokespecial 1412	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:c	(I)V
    //   493: aload_0
    //   494: getfield 179	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   497: ldc 225
    //   499: ldc 82
    //   501: ldc 82
    //   503: ldc_w 1414
    //   506: ldc_w 1414
    //   509: iconst_0
    //   510: iconst_0
    //   511: ldc 82
    //   513: ldc 82
    //   515: ldc 82
    //   517: ldc 82
    //   519: invokestatic 232	bdll:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   522: iconst_1
    //   523: ireturn
    //   524: astore_1
    //   525: aload_1
    //   526: invokevirtual 1417	java/lang/Exception:printStackTrace	()V
    //   529: aload_0
    //   530: invokevirtual 813	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:finish	()V
    //   533: iconst_0
    //   534: ireturn
    //   535: astore_3
    //   536: aload_3
    //   537: invokevirtual 1418	org/json/JSONException:printStackTrace	()V
    //   540: ldc 192
    //   542: iconst_1
    //   543: aload_3
    //   544: invokevirtual 1421	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   547: invokestatic 749	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    if (this.jdField_a_of_type_Bjaz != null)
    {
      this.jdField_a_of_type_Bjaz.a();
      this.jdField_a_of_type_Bjaz = null;
    }
    if (this.jdField_a_of_type_Anve != null)
    {
      this.jdField_a_of_type_Anve.b(this);
      this.jdField_a_of_type_Anve.d(this.jdField_a_of_type_Anvi);
      this.jdField_a_of_type_Anve = null;
    }
    if (!this.jdField_b_of_type_Boolean) {
      removeObserver(this.jdField_a_of_type_Anuw);
    }
    removeObserver(this.jdField_a_of_type_Anyu);
    this.app.unRegistObserver(this.jdField_a_of_type_Aqmy);
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
      str1 = getString(2131694512);
      bool = true;
    }
    a(this.jdField_i_of_type_AndroidWidgetTextView, str1, bool);
    paramString = this.k;
    TextView localTextView = this.jdField_i_of_type_AndroidWidgetTextView;
    String str2 = getString(2131694513);
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
    this.jdField_d_of_type_AndroidWidgetEditText.setHint(2131694506);
    a(this.l, this.jdField_d_of_type_AndroidWidgetEditText, getString(2131694507), str);
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
    for (String str1 = getString(2131694536);; str1 = paramString)
    {
      a(this.jdField_j_of_type_AndroidWidgetTextView, str1, TextUtils.isEmpty(paramString));
      paramString = this.m;
      TextView localTextView = this.jdField_j_of_type_AndroidWidgetTextView;
      String str2 = getString(2131694537);
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
    QQToast.a(this, 2131690905, 0).b(getTitleBarHeight());
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
        bdll.b(this.app, "dc00898", "", "", "0X8007EC5", "0X8007EC5", 0, 0, "", "", "", "");
        continue;
        g();
        bdll.b(this.app, "dc00898", "", "", "0X8007EC6", "0X8007EC6", 0, 0, "", "", "", "");
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
            ((Intent)localObject).putExtra("title", 2131694537).putExtra("limit", 383).putExtra("canPostNull", true).putExtra("hint", 2131694536).putExtra("multiLine", true).putExtra("current", this.jdField_e_of_type_JavaLangString).putExtra("action", 104).putExtra("key_title_style", 0).putExtra("key_hide_clear_btn", true).putExtra("key_null_bg", true).putExtra("key_simple_count_style", true);
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
            bdll.b(this.app, "dc00898", "", "", "0X800A0D6", "0X800A0D6", 0, 0, "", "", "", "");
            if ((paramView.getTag() instanceof azyi))
            {
              localObject = (azyi)paramView.getTag();
              h(String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994&idx=%d", new Object[] { Integer.valueOf(((azyi)localObject).jdField_b_of_type_Int), Integer.valueOf(((azyi)localObject).jdField_a_of_type_Int) }));
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
      if (this.jdField_a_of_type_Aerl.jdField_b_of_type_Boolean)
      {
        paramView = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
        if ((!TextUtils.isEmpty(paramView)) && (!TextUtils.isEmpty(paramView.trim()))) {}
      }
    }
    label70:
    Matcher localMatcher;
    do
    {
      QQToast.a(this, anzj.a(2131703779), 0).b(getTitleBarHeight());
      do
      {
        return;
      } while ((paramView != this.jdField_d_of_type_AndroidWidgetEditText) || (!this.jdField_d_of_type_Aerl.jdField_b_of_type_Boolean));
      paramView = this.jdField_d_of_type_AndroidWidgetEditText.getText().toString();
      localMatcher = SearchBaseActivity.a.matcher(paramView);
    } while ((TextUtils.isEmpty(paramView)) || (localMatcher.matches()));
    QQToast.a(this, anzj.a(2131703803), 0).b(getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity
 * JD-Core Version:    0.7.0.1
 */