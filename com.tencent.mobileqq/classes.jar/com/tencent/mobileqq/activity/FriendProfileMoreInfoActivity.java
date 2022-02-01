package com.tencent.mobileqq.activity;

import NS_MOBILE_MAIN_PAGE.PhotoWall;
import Override;
import aehw;
import aehx;
import aehy;
import aehz;
import aeia;
import aeib;
import aeic;
import aeid;
import aeie;
import aeif;
import aeig;
import aeih;
import aeii;
import aeij;
import aeil;
import afur;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anip;
import aniv;
import aniz;
import anjh;
import anjl;
import anmu;
import anmw;
import anni;
import apyx;
import apyy;
import azfl;
import azfr;
import azfw;
import bcst;
import bdnf;
import bfpj;
import bght;
import bghy;
import bglf;
import bglp;
import bgnt;
import bgpa;
import bgsg;
import bgtl;
import bgwv;
import bhzj;
import biab;
import biau;
import bibh;
import bkgm;
import bkho;
import bkif;
import bmjh;
import bmji;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ProfilePhotoWall;
import com.tencent.mobileqq.data.QZonePhotoInfo;
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
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;

public class FriendProfileMoreInfoActivity
  extends ProfileActivity
  implements aeil, Handler.Callback, View.OnClickListener, View.OnFocusChangeListener, CompoundButton.OnCheckedChangeListener
{
  private byte jdField_a_of_type_Byte;
  public int a;
  public aeii a;
  public aeij a;
  protected BroadcastReceiver a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public Bundle a;
  View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public EditText a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  anip jdField_a_of_type_Anip;
  private aniv jdField_a_of_type_Aniv = new aeie(this);
  public aniz a;
  anjh jdField_a_of_type_Anjh;
  private anjl jdField_a_of_type_Anjl = new aeid(this);
  private anmu jdField_a_of_type_Anmu = new aeic(this);
  private apyy jdField_a_of_type_Apyy = new aeib(this);
  private bhzj jdField_a_of_type_Bhzj = new bhzj();
  biab jdField_a_of_type_Biab;
  biau jdField_a_of_type_Biau = null;
  public bkgm a;
  public bkho a;
  public ProfileActivity.AllInOne a;
  public BusinessCard a;
  private IphonePickerView jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  ColorNickTextView jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView;
  public String a;
  private ArrayList<ProfilePhotoWall> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int jdField_b_of_type_Int;
  public aeii b;
  private View jdField_b_of_type_AndroidViewView;
  public EditText b;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public biau b;
  String jdField_b_of_type_JavaLangString = "";
  private ArrayList<ProfilePhotoWall> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  public boolean b;
  String[] jdField_b_of_type_ArrayOfJavaLangString;
  private int jdField_c_of_type_Int;
  public aeii c;
  private View jdField_c_of_type_AndroidViewView;
  public EditText c;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString = "";
  public boolean c;
  private int jdField_d_of_type_Int;
  public aeii d;
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
  private int jdField_f_of_type_Int;
  private View jdField_f_of_type_AndroidViewView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private String jdField_f_of_type_JavaLangString;
  public boolean f;
  private int jdField_g_of_type_Int;
  private View jdField_g_of_type_AndroidViewView;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  public boolean g;
  private int jdField_h_of_type_Int;
  private View jdField_h_of_type_AndroidViewView;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  public boolean h;
  private int jdField_i_of_type_Int;
  private View jdField_i_of_type_AndroidViewView;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  public boolean i;
  private View jdField_j_of_type_AndroidViewView;
  private TextView jdField_j_of_type_AndroidWidgetTextView;
  private boolean jdField_j_of_type_Boolean;
  private View jdField_k_of_type_AndroidViewView;
  private TextView jdField_k_of_type_AndroidWidgetTextView;
  private View l;
  private View m;
  private View n;
  private View o;
  
  public FriendProfileMoreInfoActivity()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Biau = null;
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
    this.jdField_a_of_type_Aniz = new aehw(this);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aeia(this);
  }
  
  public static List<ProfilePhotoWall> a(List<ProfilePhotoWall> paramList1, List<ProfilePhotoWall> paramList2)
  {
    if (paramList2.size() == 0) {
      return paramList1;
    }
    if (paramList1.size() == 0)
    {
      paramList1.addAll(paramList2);
      return paramList1;
    }
    int i2 = 0;
    int i1 = 0;
    label34:
    if (i2 < paramList2.size())
    {
      ProfilePhotoWall localProfilePhotoWall1 = (ProfilePhotoWall)paramList2.get(i2);
      label56:
      if (i1 >= paramList1.size()) {
        break label123;
      }
      ProfilePhotoWall localProfilePhotoWall2 = (ProfilePhotoWall)paramList1.get(i1);
      if (localProfilePhotoWall1.time >= localProfilePhotoWall2.time) {
        break label116;
      }
      int i3 = i1 + 1;
      paramList1.add(i1, localProfilePhotoWall1);
      i1 = i3;
    }
    label116:
    label123:
    for (;;)
    {
      i2 += 1;
      break label34;
      break;
      i1 += 1;
      break label56;
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Biau == null) {
      this.jdField_a_of_type_Biau = new biau(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_Biau.a(paramString);
    this.jdField_a_of_type_Biau.show();
  }
  
  private void a(Message paramMessage)
  {
    paramMessage = (ArrayList)paramMessage.obj;
    if (paramMessage != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramMessage);
      if (this.jdField_b_of_type_JavaUtilArrayList.size() != 0) {
        a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_b_of_type_JavaUtilArrayList);
      }
    }
  }
  
  private void a(Card paramCard, boolean paramBoolean)
  {
    Object localObject2 = null;
    if (paramCard == null) {
      return;
    }
    if (paramCard.lCurrentStyleId != azfl.a) {}
    this.jdField_f_of_type_JavaLangString = paramCard.strNick;
    a(paramCard.getRichStatus());
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if ((!this.jdField_a_of_type_Aeii.jdField_b_of_type_Boolean) && (paramCard.strNick != null) && (!paramCard.strNick.equals(localObject1)))
    {
      this.jdField_a_of_type_Aeii.jdField_a_of_type_Boolean = true;
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
      if ((!this.jdField_b_of_type_Aeii.jdField_b_of_type_Boolean) && (paramCard.strCompany != null) && (!paramCard.strCompany.equals(localObject1)))
      {
        this.jdField_b_of_type_Aeii.jdField_a_of_type_Boolean = true;
        b(paramCard.strCompany);
      }
      localObject1 = this.jdField_c_of_type_AndroidWidgetEditText.getText().toString();
      if ((!this.jdField_c_of_type_Aeii.jdField_b_of_type_Boolean) && (paramCard.strSchool != null) && (!paramCard.strSchool.equals(localObject1)))
      {
        this.jdField_c_of_type_Aeii.jdField_a_of_type_Boolean = true;
        c(paramCard.strSchool);
      }
      if (!this.jdField_f_of_type_Boolean) {
        if (TextUtils.isEmpty(paramCard.strLocationCodes)) {
          break label457;
        }
      }
    }
    label457:
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
      if ((!this.jdField_d_of_type_Aeii.jdField_b_of_type_Boolean) && (paramCard.strEmail != null) && (!paramCard.strEmail.equals(localObject1)))
      {
        this.jdField_d_of_type_Aeii.jdField_a_of_type_Boolean = true;
        f(paramCard.strEmail);
      }
      if (!this.jdField_h_of_type_Boolean) {
        g(paramCard.strPersonalNote);
      }
      if ((this.jdField_a_of_type_Aeij == null) || (!this.jdField_a_of_type_Aeij.jdField_a_of_type_Boolean)) {
        break;
      }
      a(paramCard);
      return;
      if (TextUtils.isEmpty(paramCard.strNick)) {
        break label90;
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(paramCard.strNick);
      break label90;
    }
  }
  
  private void a(ArrayList<azfw> paramArrayList)
  {
    if ((paramArrayList != null) && (this.o.getVisibility() == 0) && (this.jdField_c_of_type_AndroidWidgetLinearLayout != null))
    {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.removeAllViews();
      Object localObject1;
      if (paramArrayList.size() > 0)
      {
        paramArrayList = paramArrayList.iterator();
        do
        {
          if (!paramArrayList.hasNext()) {
            break;
          }
          localObject1 = (azfw)paramArrayList.next();
        } while (TextUtils.isEmpty(((azfw)localObject1).jdField_b_of_type_JavaLangString));
        View localView = View.inflate(this, 2131561400, null);
        TextView localTextView = (TextView)localView.findViewById(2131376933);
        Object localObject2;
        if (((azfw)localObject1).jdField_b_of_type_Boolean)
        {
          localTextView.setText(((azfw)localObject1).jdField_b_of_type_JavaLangString);
          localObject2 = getResources().getDrawable(2130845143);
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
          localTextView.setCompoundDrawables(null, null, (Drawable)localObject2, null);
          localTextView.setCompoundDrawablePadding(afur.a(4.5F, localTextView.getResources()));
          label161:
          localTextView = (TextView)localView.findViewById(2131365860);
          localObject2 = ((azfw)localObject1).a();
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label252;
          }
          localTextView.setVisibility(8);
          label194:
          localTextView = (TextView)localView.findViewById(2131365861);
          if (!((azfw)localObject1).jdField_a_of_type_Boolean) {
            break label262;
          }
          localTextView.setVisibility(0);
        }
        for (;;)
        {
          localView.setOnClickListener(this);
          localView.setTag(localObject1);
          this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(localView);
          break;
          localTextView.setText(((azfw)localObject1).jdField_b_of_type_JavaLangString);
          break label161;
          label252:
          localTextView.setText((CharSequence)localObject2);
          break label194;
          label262:
          localTextView.setVisibility(8);
        }
      }
      paramArrayList = ((anmw)this.app.getManager(51)).c(this.app.getCurrentAccountUin());
      if ((paramArrayList != null) && (!TextUtils.isEmpty(paramArrayList.strSchool)))
      {
        localObject1 = View.inflate(this, 2131561400, null);
        ((TextView)((View)localObject1).findViewById(2131376933)).setText(paramArrayList.strSchool);
        ((TextView)((View)localObject1).findViewById(2131365860)).setVisibility(8);
        ((View)localObject1).setOnClickListener(this);
        ((View)localObject1).setTag(paramArrayList);
        this.jdField_c_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      }
      if (this.jdField_c_of_type_AndroidWidgetLinearLayout.getChildCount() < 2)
      {
        this.o.findViewById(2131376924).setVisibility(0);
        this.o.findViewById(2131376928).setVisibility(0);
        this.o.findViewById(2131376926).setVisibility(0);
        this.o.findViewById(2131376922).setVisibility(8);
      }
    }
    else
    {
      return;
    }
    this.o.findViewById(2131376924).setVisibility(8);
    this.o.findViewById(2131376928).setVisibility(8);
    this.o.findViewById(2131376926).setVisibility(8);
    this.o.findViewById(2131376922).setVisibility(0);
  }
  
  private void a(List<ProfilePhotoWall> paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileMoreInfoActivity", 2, String.format("updatePhotoWall curSize=%s totalSize=%s", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(paramInt) }));
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if ((paramList == null) || (paramList.isEmpty()))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("%s张", new Object[] { Integer.valueOf(paramInt) }));
    int i2 = this.jdField_b_of_type_AndroidWidgetLinearLayout.getWidth();
    int i3 = paramList.size();
    int i1 = 0;
    paramInt = 0;
    label117:
    Object localObject1;
    if (i1 < i3)
    {
      localObject1 = (ProfilePhotoWall)paramList.get(i1);
      if (localObject1 == null) {
        break label393;
      }
    }
    label393:
    for (;;)
    {
      for (;;)
      {
        try
        {
          if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
          {
            localObject2 = getResources();
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(((Resources)localObject2).getColor(2131165712));
            this.jdField_h_of_type_Int = ((Resources)localObject2).getDimensionPixelSize(2131298267);
            this.jdField_i_of_type_Int = ((Resources)localObject2).getDimensionPixelSize(2131298266);
          }
          Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.jdField_h_of_type_Int;
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.jdField_h_of_type_Int;
          localObject2 = URLDrawable.getDrawable(((ProfilePhotoWall)localObject1).getThumbUrl(this.jdField_g_of_type_Int), (URLDrawable.URLDrawableOptions)localObject2);
          localObject1 = new ImageView(getBaseContext());
          ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
          ((ImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_CROP);
          localObject2 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject2).width = this.jdField_h_of_type_Int;
          ((LinearLayout.LayoutParams)localObject2).height = this.jdField_h_of_type_Int;
          ((LinearLayout.LayoutParams)localObject2).rightMargin = this.jdField_i_of_type_Int;
          this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          i4 = this.jdField_h_of_type_Int;
          i5 = this.jdField_i_of_type_Int;
          paramInt = i4 + i5 + paramInt;
        }
        catch (Exception localException1)
        {
          int i4;
          int i5;
          continue;
        }
        try
        {
          i4 = this.jdField_h_of_type_Int;
          i5 = this.jdField_i_of_type_Int;
          if (i4 + paramInt + i5 > i2) {
            break;
          }
        }
        catch (Exception localException2) {}
      }
      i1 += 1;
      break label117;
      break;
    }
  }
  
  private void a(boolean paramBoolean, Card paramCard)
  {
    if (QLog.isColorLevel()) {
      QLog.e("FriendProfileMoreInfoActivity", 2, "onDeleteOldSchoolResult:" + paramBoolean);
    }
    this.jdField_j_of_type_Boolean = false;
    if (paramBoolean) {
      a(((apyx)this.app.getManager(112)).a());
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Aeii.jdField_b_of_type_Boolean) || (this.jdField_b_of_type_Aeii.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Aeii.jdField_b_of_type_Boolean) || (this.jdField_d_of_type_Aeii.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean) || (this.jdField_e_of_type_Boolean) || (this.jdField_f_of_type_Boolean) || (this.jdField_g_of_type_Boolean) || (this.jdField_h_of_type_Boolean);
  }
  
  private boolean a(Bundle paramBundle, int paramInt1, int paramInt2)
  {
    if (!bgnt.d(this)) {
      a(paramInt1, paramInt2);
    }
    while ((paramBundle == null) || (paramBundle.isEmpty())) {
      return false;
    }
    this.jdField_a_of_type_Anip.a(paramBundle);
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
    if (a(localBundle, 2131693948, 0)) {
      this.jdField_j_of_type_Boolean = true;
    }
  }
  
  private void b(int paramInt)
  {
    bcst.b(this.app, "dc00898", "", "", "0X800A0D5", "0X800A0D5", 0, 0, paramInt + "", "", "", "");
  }
  
  private void b(Card paramCard)
  {
    if ((paramCard != null) && (!this.jdField_i_of_type_Boolean) && (bghy.a(paramCard, this.app)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FriendProfileMoreInfoActivity", 2, "checkEduFirstGuide:");
      }
      String str = anni.a(2131703694);
      bglp.a(this, anni.a(2131703673), str, null, 2131694431, 2131694432, new aeif(this), new aeig(this)).show();
      bghy.a(paramCard, this.app);
      bcst.b(this.app, "dc00898", "", "", "0X800A0D7", "0X800A0D7", 0, 0, "", "", "", "");
    }
  }
  
  private boolean b()
  {
    Bundle localBundle = new Bundle();
    Object localObject1;
    if (this.jdField_a_of_type_Aeii.jdField_b_of_type_Boolean)
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
      if (this.jdField_b_of_type_Aeii.jdField_b_of_type_Boolean) {
        localBundle.putString("company", this.jdField_b_of_type_AndroidWidgetEditText.getText().toString());
      }
      if (this.jdField_c_of_type_Aeii.jdField_b_of_type_Boolean) {
        localBundle.putString("college", this.jdField_c_of_type_AndroidWidgetEditText.getText().toString());
      }
      if (this.jdField_f_of_type_Boolean)
      {
        localObject1 = this.jdField_i_of_type_AndroidWidgetTextView.getText().toString();
        localBundle.putStringArray("location", this.jdField_a_of_type_ArrayOfJavaLangString);
        localBundle.putString("locationo_desc", (String)localObject1);
        localObject1 = null;
      }
    }
    label390:
    try
    {
      localObject2 = this.jdField_a_of_type_Anjh.a(this.jdField_a_of_type_ArrayOfJavaLangString);
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
      localObject1 = this.jdField_j_of_type_AndroidWidgetTextView.getText().toString();
      localBundle.putStringArray("hometown", this.jdField_b_of_type_ArrayOfJavaLangString);
      localBundle.putString("hometown_desc", (String)localObject1);
    }
    if (this.jdField_d_of_type_Aeii.jdField_b_of_type_Boolean)
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
      return a(localBundle, 2131693948, 0);
      localBundle.putString("nick", ((String)localObject1).trim());
      localObject1 = new bmji();
      ((bmji)localObject1).jdField_a_of_type_Int = 5;
      bmjh.a(getAppRuntime().getAccount()).a((bmji)localObject1);
      break;
      localBundle.putString("email", (String)localObject1);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Anip.a(this.app.getLongAccountUin());
  }
  
  private void c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.post(new FriendProfileMoreInfoActivity.10(this));
      return;
    case 2: 
      Intent localIntent = new Intent(this, AgeSelectionActivity.class);
      localIntent.putExtra("param_birthday", this.jdField_b_of_type_Int);
      startActivityForResult(localIntent, 1003);
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.post(new FriendProfileMoreInfoActivity.11(this));
      d(1);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.post(new FriendProfileMoreInfoActivity.12(this));
  }
  
  private void d()
  {
    bkho localbkho = (bkho)bkif.a(this, null);
    localbkho.a(2131694428, 0);
    localbkho.a(2131694430, 0);
    localbkho.a(2131694429, 0);
    localbkho.c(2131690582);
    localbkho.a(new aeih(this, localbkho));
    localbkho.show();
  }
  
  private void d(int paramInt)
  {
    int i1 = this.jdField_a_of_type_Anjh.a();
    if (i1 != 0)
    {
      i1 = this.jdField_a_of_type_Anjh.a(i1, true);
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileMoreInfoActivity", 2, "startLocationSelectActivity | update result = " + i1);
      }
      if (i1 == 2)
      {
        QQToast.a(this, 2131693948, 0).b(getTitleBarHeight());
        return;
      }
      if (i1 == 0)
      {
        a(paramInt, getString(2131690908));
        this.jdField_a_of_type_Anjh.c(this.jdField_a_of_type_Anjl);
        return;
      }
      a(paramInt, getString(2131690908));
      this.jdField_a_of_type_Bkgm.sendEmptyMessageDelayed(1000, 20000L);
      return;
    }
    Object localObject1;
    if (paramInt == 1)
    {
      i1 = 2;
      if (paramInt != 1) {
        break label274;
      }
      localObject1 = this.jdField_a_of_type_ArrayOfJavaLangString;
      label149:
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
      ((Intent)localObject1).putExtra("param_location_param", this.jdField_a_of_type_Anjh.b((String[])localObject2));
      if (paramInt != 1) {
        break label282;
      }
    }
    label274:
    label282:
    for (paramInt = 1005;; paramInt = 1006)
    {
      startActivityForResult((Intent)localObject1, paramInt);
      return;
      i1 = 3;
      break;
      localObject1 = this.jdField_b_of_type_ArrayOfJavaLangString;
      break label149;
    }
  }
  
  private void e()
  {
    if (a())
    {
      if (this.jdField_b_of_type_Biau == null)
      {
        this.jdField_b_of_type_Biau = new biau(this, getTitleBarHeight());
        this.jdField_b_of_type_Biau.a(anni.a(2131703671));
      }
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_Biau.dismiss();
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
          this.jdField_b_of_type_Biau.show();
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131376805));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368994));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131692996);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131692996));
    Object localObject = (TextView)findViewById(2131368947);
    ((TextView)localObject).setText("");
    ((TextView)localObject).setContentDescription(anni.a(2131703717));
    ((TextView)localObject).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131365016));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131372493);
    this.jdField_a_of_type_AndroidViewView.setContentDescription(getString(2131694568));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131372396));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372397));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131363111);
    this.jdField_b_of_type_AndroidViewView.setContentDescription(getString(2131691941));
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363107));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131377567);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377569));
    a(null);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131365123);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    a(null);
    this.jdField_e_of_type_AndroidViewView = findViewById(2131379298);
    if (this.jdField_i_of_type_Boolean)
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)findViewById(2131379301));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379299));
      localObject = findViewById(2131379297);
      TroopInfo localTroopInfo = ((TroopManager)this.app.getManager(52)).b(this.jdField_a_of_type_JavaLangString);
      if (localTroopInfo == null) {
        break label1386;
      }
      if ((localTroopInfo.isTroopAdmin(this.app.getCurrentAccountUin())) || (localTroopInfo.isTroopOwner(this.app.getCurrentAccountUin())) || (TextUtils.equals(this.jdField_b_of_type_JavaLangString, this.app.getCurrentAccountUin())))
      {
        this.jdField_e_of_type_AndroidViewView.setClickable(true);
        this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
        ((View)localObject).setVisibility(0);
      }
    }
    for (;;)
    {
      a();
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131371713));
      if (this.jdField_e_of_type_AndroidViewView.getVisibility() == 0) {
        ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams()).setMargins(0, 0, 0, 0);
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setClickable(true);
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131371712));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371714));
      if (!bgsg.D(this, this.app.getCurrentAccountUin())) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this);
      this.jdField_a_of_type_Aeii = new aeii(this, 36, this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_Aeii.jdField_a_of_type_Boolean = true;
      a(null);
      this.jdField_f_of_type_AndroidViewView = findViewById(2131377337);
      this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377338));
      a(-1, false);
      this.jdField_g_of_type_AndroidViewView = findViewById(2131363483);
      this.jdField_g_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363484));
      a(0, 0, 0);
      if (bghy.b())
      {
        int i1 = this.jdField_f_of_type_AndroidViewView.getPaddingLeft();
        int i2 = this.jdField_f_of_type_AndroidViewView.getPaddingTop();
        int i3 = this.jdField_f_of_type_AndroidViewView.getPaddingRight();
        int i4 = this.jdField_f_of_type_AndroidViewView.getPaddingBottom();
        this.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130839439);
        this.jdField_f_of_type_AndroidViewView.setPadding(i1, i2, i3, i4);
        this.jdField_g_of_type_AndroidViewView.setVisibility(8);
        if (QLog.isDevelopLevel()) {
          QLog.i("FriendProfileMoreInfoActivity", 4, String.format(Locale.getDefault(), "EuropeAndAmerica sexLayout[%s, %s, %s, %s]", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4) }));
        }
      }
      this.jdField_h_of_type_AndroidViewView = findViewById(2131372893);
      this.jdField_h_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372892));
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372894));
      a(-1);
      this.jdField_i_of_type_AndroidViewView = findViewById(2131364868);
      this.jdField_i_of_type_AndroidViewView.setClickable(false);
      this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131364867));
      this.jdField_b_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this);
      this.jdField_b_of_type_Aeii = new aeii(this, 120, this.jdField_b_of_type_AndroidWidgetEditText);
      this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_b_of_type_Aeii);
      this.jdField_b_of_type_Aeii.jdField_a_of_type_Boolean = true;
      b(null);
      this.jdField_j_of_type_AndroidViewView = findViewById(2131376932);
      this.jdField_j_of_type_AndroidViewView.setClickable(false);
      this.jdField_c_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131376929));
      this.jdField_c_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this);
      this.jdField_c_of_type_Aeii = new aeii(this, 40, this.jdField_c_of_type_AndroidWidgetEditText);
      this.jdField_c_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_c_of_type_Aeii);
      this.jdField_c_of_type_Aeii.jdField_a_of_type_Boolean = true;
      c(null);
      this.jdField_k_of_type_AndroidViewView = findViewById(2131370259);
      this.jdField_k_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370273));
      d(null);
      this.l = findViewById(2131368016);
      this.l.setOnClickListener(this);
      this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368017));
      e(null);
      this.m = findViewById(2131365876);
      this.m.setClickable(false);
      this.jdField_d_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131365875));
      this.jdField_d_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this);
      this.jdField_d_of_type_Aeii = new aeii(this, 50, this.jdField_d_of_type_AndroidWidgetEditText);
      this.jdField_d_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_d_of_type_Aeii);
      this.jdField_d_of_type_Aeii.jdField_a_of_type_Boolean = true;
      f(null);
      this.n = findViewById(2131372309);
      this.n.setOnClickListener(this);
      this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372310));
      g(null);
      this.o = findViewById(2131365863);
      this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131362196));
      findViewById(2131376923).setOnClickListener(this);
      findViewById(2131376927).setOnClickListener(this);
      findViewById(2131376925).setOnClickListener(this);
      findViewById(2131376921).setOnClickListener(this);
      if ((this.jdField_i_of_type_Boolean) && (TroopInfo.isQidianPrivateTroop(this.app, this.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_h_of_type_AndroidViewView.setVisibility(8);
        this.jdField_i_of_type_AndroidViewView.setVisibility(8);
        this.jdField_j_of_type_AndroidViewView.setVisibility(8);
        this.l.setVisibility(8);
        this.m.setVisibility(8);
        this.n.setVisibility(8);
      }
      if (!this.jdField_i_of_type_Boolean)
      {
        this.jdField_j_of_type_AndroidViewView.setVisibility(8);
        this.o.setVisibility(0);
      }
      return;
      label1386:
      this.jdField_e_of_type_AndroidViewView.setClickable(false);
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(null);
      ((View)localObject).setVisibility(8);
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) {
      return;
    }
    bgtl.a(this, this.app, 0, "signature_ziliaoka", 1002);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Bkho == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getLayoutInflater().inflate(2131561215, null));
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(new aehx(this));
      this.jdField_a_of_type_Bkho = bkho.c(this);
      this.jdField_a_of_type_Bkho.e(true);
      this.jdField_a_of_type_Bkho.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
      localObject = (DispatchActionMoveScrollView)this.jdField_a_of_type_Bkho.findViewById(2131361980);
      ((DispatchActionMoveScrollView)localObject).jdField_a_of_type_Boolean = true;
      ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = this.jdField_a_of_type_Bkho.getWindow();
        if (localObject != null) {
          ((Window)localObject).setFlags(16777216, 16777216);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(new aehy(this));
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
        this.jdField_a_of_type_Bkho.setOnDismissListener(new aehz(this));
        this.jdField_a_of_type_Bkho.show();
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
    if ((this.jdField_a_of_type_Biau != null) && (this.jdField_a_of_type_Biau.isShowing())) {
      this.jdField_a_of_type_Biau.dismiss();
    }
  }
  
  void a()
  {
    String str = bglf.i(this.app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    if ((TextUtils.isEmpty(str)) || (TextUtils.equals(str, this.jdField_b_of_type_JavaLangString)))
    {
      str = "";
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      SpannableString localSpannableString = new bdnf(str, 16).a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText(localSpannableString);
      bgwv.a(this.app, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, localSpannableString);
      a(this.jdField_e_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, getString(2131696846), str);
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
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
    if (bght.a(paramInt))
    {
      this.jdField_e_of_type_Int = paramInt;
      localObject2 = bght.e(paramInt);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        this.jdField_e_of_type_Int = -1;
        localObject1 = getString(2131694524);
      }
      if ((paramInt < bght.e.length - 1) && (paramInt > 0)) {
        break label137;
      }
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      localObject2 = this.jdField_h_of_type_AndroidWidgetTextView;
      if (this.jdField_e_of_type_Int == -1) {
        bool = true;
      }
      a((TextView)localObject2, (CharSequence)localObject1, bool);
      localObject2 = this.jdField_h_of_type_AndroidViewView;
      localTextView = this.jdField_h_of_type_AndroidWidgetTextView;
      str = getString(2131694525);
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
      localObject2 = getResources().getDrawable(bght.b[paramInt]);
      ProfileActivity.a(this.app, (Drawable)localObject2);
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_g_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localObject2);
      this.jdField_g_of_type_AndroidWidgetTextView.setText(bght.e[paramInt]);
      break label67;
      label192:
      localObject1 = "";
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    new bibh(this).a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_d_of_type_Int = paramInt3;
    String str1 = getString(2131694423);
    if (paramInt1 != 0) {
      str1 = String.format(Locale.getDefault(), "%d-%d-%d", new Object[] { Integer.valueOf((0xFFFF0000 & paramInt1) >>> 16), Integer.valueOf((0xFF00 & paramInt1) >>> 8), Integer.valueOf(paramInt1 & 0xFF) });
    }
    Object localObject = this.jdField_f_of_type_AndroidWidgetTextView;
    TextView localTextView;
    String str2;
    if (paramInt1 == 0)
    {
      a((TextView)localObject, str1, bool);
      localObject = this.jdField_g_of_type_AndroidViewView;
      localTextView = this.jdField_f_of_type_AndroidWidgetTextView;
      str2 = getString(2131694424);
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
  
  public void a(int paramInt1, int paramInt2, String paramString, ArrayList<PhotoWall> paramArrayList, List<ProfilePhotoWall> paramList)
  {
    this.jdField_a_of_type_Bhzj.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_Bhzj.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_Bhzj.jdField_a_of_type_JavaLangString = paramString;
    if (paramArrayList != null)
    {
      paramString = paramArrayList.iterator();
      while (paramString.hasNext())
      {
        paramArrayList = (PhotoWall)paramString.next();
        QZonePhotoInfo localQZonePhotoInfo = new QZonePhotoInfo();
        localQZonePhotoInfo.uin = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
        localQZonePhotoInfo.time = paramArrayList.ctime;
        localQZonePhotoInfo.photoId = paramArrayList.photoId;
        localQZonePhotoInfo.photoUrls = paramArrayList.photoUrls;
        paramList.add(localQZonePhotoInfo);
      }
      this.jdField_a_of_type_Bhzj.jdField_a_of_type_Int = paramList.size();
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Byte = ((byte)paramInt);
    String str = getString(2131694528);
    if (paramInt == 0)
    {
      str = getString(2131693461);
      if (!paramBoolean) {
        break label88;
      }
      a(this.jdField_e_of_type_AndroidWidgetTextView, str, 2131166994);
      if ((paramInt != 0) && (paramInt != 1)) {
        break label121;
      }
    }
    for (;;)
    {
      a(this.jdField_f_of_type_AndroidViewView, this.jdField_e_of_type_AndroidWidgetTextView, getString(2131694529), str);
      return;
      if (paramInt != 1) {
        break;
      }
      str = getString(2131692055);
      break;
      label88:
      TextView localTextView = this.jdField_e_of_type_AndroidWidgetTextView;
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
      paramView1 = paramString1 + anni.a(2131703698) + paramString2 + ",";
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
    for (int i1 = 2131167066;; i1 = 2131166986)
    {
      a(paramTextView, paramCharSequence, i1);
      return;
    }
  }
  
  void a(Card paramCard)
  {
    if (this.jdField_a_of_type_Aeij != null) {
      this.jdField_a_of_type_Aeij.a(paramCard);
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
      a(this.jdField_d_of_type_AndroidWidgetTextView, paramRichStatus, bool);
      a(this.jdField_c_of_type_AndroidViewView, this.jdField_d_of_type_AndroidWidgetTextView, getString(2131693045), paramRichStatus);
      return;
      paramRichStatus = anni.a(2131703706);
      bool = true;
    }
  }
  
  public void a(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString))
    {
      str = "";
      paramString = getString(2131694480);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(str);
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(paramString);
      a(this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_AndroidWidgetEditText, getString(2131694481), str);
      return;
      str = paramString;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (TroopInfo.isHomeworkTroop(this.app, paramString1))
    {
      bfpj.a(this, paramString2, paramString1, "qqProfile");
      return;
    }
    Intent localIntent = new Intent(this, EditInfoActivity.class);
    localIntent.putExtra("edit_type", 0);
    localIntent.putExtra("troopUin", paramString1);
    localIntent.putExtra("uin", paramString2);
    paramString1 = "";
    if (paramInt == 1011)
    {
      paramString1 = getString(2131696850);
      localIntent.putExtra("isTroopNick", true);
      localIntent.putExtra("default_text", this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getText().toString() + "");
      localIntent.putExtra("max_num", 60);
    }
    localIntent.putExtra("title", paramString1);
    if (TextUtils.isEmpty("")) {
      localIntent.putExtra("default_hint", anni.a(2131703679));
    }
    for (;;)
    {
      startActivityForResult(localIntent, paramInt);
      return;
      localIntent.putExtra("default_text", "");
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      c(paramArrayOfByte);
    }
  }
  
  void b(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    this.jdField_b_of_type_AndroidWidgetEditText.setText(str);
    this.jdField_b_of_type_AndroidWidgetEditText.setHint(2131694434);
    a(this.jdField_i_of_type_AndroidViewView, this.jdField_b_of_type_AndroidWidgetEditText, getString(2131694435), str);
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      c(paramArrayOfByte);
    }
  }
  
  void c(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    this.jdField_c_of_type_AndroidWidgetEditText.setText(str);
    this.jdField_c_of_type_AndroidWidgetEditText.setHint(2131694526);
    a(this.jdField_j_of_type_AndroidViewView, this.jdField_c_of_type_AndroidWidgetEditText, getString(2131694527), str);
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Aeij != null) {
      this.jdField_a_of_type_Aeij.a(paramArrayOfByte);
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      a(null);
      return;
    }
    runOnUiThread(new FriendProfileMoreInfoActivity.17(this));
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
      str1 = getString(2131694476);
      bool = true;
    }
    a(this.jdField_i_of_type_AndroidWidgetTextView, str1, bool);
    paramString = this.jdField_k_of_type_AndroidViewView;
    TextView localTextView = this.jdField_i_of_type_AndroidWidgetTextView;
    String str2 = getString(2131694477);
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
    if (paramInt1 == 1001)
    {
      paramIntent = this.jdField_a_of_type_Bkgm.obtainMessage(1001);
      paramIntent.obj = null;
      this.jdField_a_of_type_Bkgm.sendMessage(paramIntent);
    }
    label254:
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
                              do
                              {
                                return;
                                if (paramInt1 != 1002) {
                                  break;
                                }
                              } while (paramInt2 == 1001);
                              this.jdField_a_of_type_Anip.f();
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
                    localObject = this.jdField_a_of_type_Anjh.a((String[])localObject);
                    paramIntent = (Intent)localObject;
                  }
                  catch (Exception localException2)
                  {
                    break label254;
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
                localObject = this.jdField_a_of_type_Anjh.a((String[])localObject);
                paramIntent = (Intent)localObject;
              }
              catch (Exception localException1)
              {
                break label345;
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
          if (paramInt1 != 1024) {
            break;
          }
        } while (this.jdField_a_of_type_Aeij == null);
        this.jdField_a_of_type_Aeij.a(paramInt2, paramIntent);
        return;
      } while (paramInt1 != 1012);
      if (QLog.isDevelopLevel()) {
        QLog.d("FriendProfileMoreInfoActivity", 2, "doOnActivityResult school web");
      }
    } while (this.jdField_a_of_type_Anip == null);
    label345:
    paramIntent = this.app.getCurrentAccountUin();
    this.jdField_a_of_type_Anip.a(paramIntent, paramIntent, 1, 0L, (byte)1, 0L, 0L, null, "", 0L, 10004, null, (byte)0);
    c();
  }
  
  /* Error */
  public boolean doOnCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 1545	com/tencent/mobileqq/activity/ProfileActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   5: pop
    //   6: aload_0
    //   7: ldc_w 1546
    //   10: invokespecial 1549	com/tencent/mobileqq/activity/ProfileActivity:setContentView	(I)V
    //   13: aload_0
    //   14: new 376	aeij
    //   17: dup
    //   18: aload_0
    //   19: aload_0
    //   20: invokespecial 1552	aeij:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Laeil;)V
    //   23: putfield 374	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Aeij	Laeij;
    //   26: aload_0
    //   27: new 947	bkgm
    //   30: dup
    //   31: invokestatic 1450	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   34: aload_0
    //   35: invokespecial 1555	bkgm:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   38: putfield 943	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Bkgm	Lbkgm;
    //   41: aload_0
    //   42: invokevirtual 1559	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:getIntent	()Landroid/content/Intent;
    //   45: astore_1
    //   46: aload_0
    //   47: aload_1
    //   48: ldc_w 1561
    //   51: iconst_0
    //   52: invokevirtual 1565	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   55: putfield 104	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_i_of_type_Boolean	Z
    //   58: aload_0
    //   59: aload_1
    //   60: ldc_w 1413
    //   63: invokevirtual 1529	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   66: putfield 108	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   69: aload_0
    //   70: aload_1
    //   71: ldc_w 1567
    //   74: invokevirtual 1529	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   77: putfield 110	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   80: aload_0
    //   81: aload_1
    //   82: ldc_w 1569
    //   85: invokevirtual 1529	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   88: putfield 112	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   91: aload_0
    //   92: getfield 374	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Aeij	Laeij;
    //   95: aload_1
    //   96: ldc_w 1571
    //   99: iconst_0
    //   100: invokevirtual 1512	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   103: putfield 1572	aeij:jdField_a_of_type_Int	I
    //   106: aload_0
    //   107: getfield 374	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Aeij	Laeij;
    //   110: aload_1
    //   111: ldc_w 1574
    //   114: invokevirtual 1529	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   117: putfield 1575	aeij:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   120: aload_0
    //   121: getfield 112	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   124: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   127: ifne +92 -> 219
    //   130: new 1577	org/json/JSONObject
    //   133: dup
    //   134: aload_0
    //   135: getfield 112	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   138: invokespecial 1579	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   141: astore_3
    //   142: aload_0
    //   143: aload_3
    //   144: ldc_w 1413
    //   147: invokevirtual 1582	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   150: putfield 108	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   153: aload_0
    //   154: aload_3
    //   155: ldc_w 1567
    //   158: invokevirtual 1582	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   161: putfield 110	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   164: aload_0
    //   165: getfield 108	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   168: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   171: ifne +18 -> 189
    //   174: aload_0
    //   175: getfield 110	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   178: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   181: ifne +8 -> 189
    //   184: aload_0
    //   185: iconst_1
    //   186: putfield 104	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_i_of_type_Boolean	Z
    //   189: invokestatic 522	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   192: ifeq +27 -> 219
    //   195: ldc_w 524
    //   198: iconst_2
    //   199: ldc_w 1584
    //   202: iconst_1
    //   203: anewarray 267	java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: aload_0
    //   209: getfield 112	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   212: aastore
    //   213: invokestatic 536	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   216: invokestatic 539	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: aload_0
    //   220: aload_0
    //   221: getfield 491	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   224: iconst_2
    //   225: invokevirtual 1587	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lanii;
    //   228: checkcast 677	anip
    //   231: putfield 675	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Anip	Lanip;
    //   234: aload_0
    //   235: aload_0
    //   236: getfield 491	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   239: bipush 59
    //   241: invokevirtual 497	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   244: checkcast 794	anjh
    //   247: putfield 792	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Anjh	Lanjh;
    //   250: aload_0
    //   251: new 1589	biab
    //   254: dup
    //   255: aload_0
    //   256: getfield 491	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   259: aconst_null
    //   260: invokespecial 1592	biab:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;Lbiac;)V
    //   263: putfield 1594	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Biab	Lbiab;
    //   266: aload_0
    //   267: aload_0
    //   268: getfield 119	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Aniz	Laniz;
    //   271: invokevirtual 1598	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:addObserver	(Lanil;)V
    //   274: aload_0
    //   275: aload_0
    //   276: getfield 129	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Anmu	Lanmu;
    //   279: invokevirtual 1598	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:addObserver	(Lanil;)V
    //   282: aload_0
    //   283: getfield 491	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   286: aload_0
    //   287: getfield 124	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Apyy	Lapyy;
    //   290: invokevirtual 1602	com/tencent/mobileqq/app/QQAppInterface:registObserver	(Lmqq/observer/BusinessObserver;)V
    //   293: aload_0
    //   294: getfield 792	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Anjh	Lanjh;
    //   297: aload_0
    //   298: invokevirtual 1604	anjh:a	(Ljava/lang/Object;)V
    //   301: new 1606	android/content/IntentFilter
    //   304: dup
    //   305: invokespecial 1607	android/content/IntentFilter:<init>	()V
    //   308: astore_3
    //   309: aload_3
    //   310: ldc_w 1609
    //   313: invokevirtual 1612	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   316: aload_0
    //   317: aload_0
    //   318: getfield 144	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   321: aload_3
    //   322: invokevirtual 1616	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   325: pop
    //   326: aload_0
    //   327: ldc_w 1617
    //   330: invokespecial 1618	com/tencent/mobileqq/activity/ProfileActivity:findViewById	(I)Landroid/view/View;
    //   333: checkcast 394	android/widget/LinearLayout
    //   336: astore_3
    //   337: invokestatic 1623	com/tencent/widget/immersive/ImmersiveUtils:isSupporImmersive	()I
    //   340: iconst_1
    //   341: if_icmpne +19 -> 360
    //   344: aload_3
    //   345: iconst_1
    //   346: invokevirtual 1626	android/widget/LinearLayout:setFitsSystemWindows	(Z)V
    //   349: aload_3
    //   350: iconst_0
    //   351: aload_0
    //   352: invokestatic 1630	com/tencent/widget/immersive/ImmersiveUtils:getStatusBarHeight	(Landroid/content/Context;)I
    //   355: iconst_0
    //   356: iconst_0
    //   357: invokevirtual 1631	android/widget/LinearLayout:setPadding	(IIII)V
    //   360: aload_0
    //   361: invokespecial 1632	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:f	()V
    //   364: aload_0
    //   365: invokevirtual 434	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:getResources	()Landroid/content/res/Resources;
    //   368: invokevirtual 1636	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   371: astore_3
    //   372: aload_3
    //   373: getfield 1641	android/util/DisplayMetrics:widthPixels	I
    //   376: aload_3
    //   377: getfield 1644	android/util/DisplayMetrics:heightPixels	I
    //   380: invokestatic 1650	java/lang/Math:max	(II)I
    //   383: istore_2
    //   384: iload_2
    //   385: sipush 240
    //   388: if_icmpgt +244 -> 632
    //   391: aload_0
    //   392: bipush 60
    //   394: putfield 590	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_g_of_type_Int	I
    //   397: aload_0
    //   398: aload_0
    //   399: invokevirtual 1559	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:getIntent	()Landroid/content/Intent;
    //   402: ldc_w 1652
    //   405: invokevirtual 1656	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   408: checkcast 1342	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   411: putfield 1187	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   414: aload_0
    //   415: aload_0
    //   416: invokevirtual 1559	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:getIntent	()Landroid/content/Intent;
    //   419: ldc_w 1658
    //   422: invokevirtual 1656	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   425: checkcast 1660	com/tencent/mobileqq/businessCard/data/BusinessCard
    //   428: putfield 1662	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard	Lcom/tencent/mobileqq/businessCard/data/BusinessCard;
    //   431: aload_0
    //   432: getfield 1187	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   435: ifnonnull +22 -> 457
    //   438: aload_0
    //   439: new 1342	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   442: dup
    //   443: aload_0
    //   444: getfield 491	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   447: invokevirtual 1664	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   450: iconst_0
    //   451: invokespecial 1666	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   454: putfield 1187	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   457: aload_0
    //   458: getfield 1662	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard	Lcom/tencent/mobileqq/businessCard/data/BusinessCard;
    //   461: ifnonnull +14 -> 475
    //   464: aload_0
    //   465: aload_0
    //   466: getfield 491	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   469: invokestatic 1671	aqaj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/businessCard/data/BusinessCard;
    //   472: putfield 1662	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard	Lcom/tencent/mobileqq/businessCard/data/BusinessCard;
    //   475: new 1673	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity$6
    //   478: dup
    //   479: aload_0
    //   480: invokespecial 1674	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity$6:<init>	(Lcom/tencent/mobileqq/activity/FriendProfileMoreInfoActivity;)V
    //   483: iconst_5
    //   484: aconst_null
    //   485: iconst_1
    //   486: invokestatic 1679	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   489: aload_0
    //   490: getfield 104	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_i_of_type_Boolean	Z
    //   493: ifne +26 -> 519
    //   496: aload_0
    //   497: aload_0
    //   498: getfield 491	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   501: bipush 112
    //   503: invokevirtual 497	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   506: checkcast 659	apyx
    //   509: invokevirtual 662	apyx:a	()Ljava/util/ArrayList;
    //   512: invokespecial 232	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:a	(Ljava/util/ArrayList;)V
    //   515: aload_0
    //   516: invokespecial 1539	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:c	()V
    //   519: aload_1
    //   520: ldc_w 1681
    //   523: iconst_0
    //   524: invokevirtual 1512	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   527: istore_2
    //   528: iload_2
    //   529: ifle +41 -> 570
    //   532: invokestatic 522	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   535: ifeq +30 -> 565
    //   538: ldc_w 524
    //   541: iconst_2
    //   542: new 642	java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial 643	java/lang/StringBuilder:<init>	()V
    //   549: ldc_w 1683
    //   552: invokevirtual 649	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: iload_2
    //   556: invokevirtual 701	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   559: invokevirtual 653	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   562: invokestatic 539	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   565: aload_0
    //   566: iload_2
    //   567: invokespecial 1684	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:c	(I)V
    //   570: aload_0
    //   571: getfield 491	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   574: ldc_w 696
    //   577: ldc 106
    //   579: ldc 106
    //   581: ldc_w 1686
    //   584: ldc_w 1686
    //   587: iconst_0
    //   588: iconst_0
    //   589: ldc 106
    //   591: ldc 106
    //   593: ldc 106
    //   595: ldc 106
    //   597: invokestatic 706	bcst:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   600: iconst_1
    //   601: ireturn
    //   602: astore_1
    //   603: aload_1
    //   604: invokevirtual 1689	java/lang/Exception:printStackTrace	()V
    //   607: aload_0
    //   608: invokevirtual 989	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:finish	()V
    //   611: iconst_0
    //   612: ireturn
    //   613: astore_3
    //   614: aload_3
    //   615: invokevirtual 1690	org/json/JSONException:printStackTrace	()V
    //   618: ldc_w 524
    //   621: iconst_1
    //   622: aload_3
    //   623: invokevirtual 1693	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   626: invokestatic 539	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   629: goto -440 -> 189
    //   632: iload_2
    //   633: sipush 320
    //   636: if_icmpgt +12 -> 648
    //   639: aload_0
    //   640: bipush 100
    //   642: putfield 590	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_g_of_type_Int	I
    //   645: goto -248 -> 397
    //   648: aload_0
    //   649: sipush 160
    //   652: putfield 590	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_g_of_type_Int	I
    //   655: goto -258 -> 397
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	658	0	this	FriendProfileMoreInfoActivity
    //   0	658	1	paramBundle	Bundle
    //   383	254	2	i1	int
    //   141	236	3	localObject	Object
    //   613	10	3	localJSONException	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   6	13	602	java/lang/Exception
    //   130	189	613	org/json/JSONException
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Biab != null)
    {
      this.jdField_a_of_type_Biab.a();
      this.jdField_a_of_type_Biab = null;
    }
    if (this.jdField_a_of_type_Aeij != null)
    {
      this.jdField_a_of_type_Aeij.a();
      this.jdField_a_of_type_Aeij = null;
    }
    if (this.jdField_a_of_type_Anjh != null)
    {
      this.jdField_a_of_type_Anjh.b(this);
      this.jdField_a_of_type_Anjh.d(this.jdField_a_of_type_Anjl);
      this.jdField_a_of_type_Anjh = null;
    }
    if (!this.jdField_b_of_type_Boolean) {
      removeObserver(this.jdField_a_of_type_Aniz);
    }
    removeObserver(this.jdField_a_of_type_Anmu);
    this.app.unRegistObserver(this.jdField_a_of_type_Apyy);
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
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((localArrayList != null) && (localArrayList.size() > 0) && (this.jdField_a_of_type_Aeij != null)) {
      this.jdField_a_of_type_Aeij.a(paramIntent, localArrayList);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
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
      str1 = getString(2131694470);
      bool = true;
    }
    a(this.jdField_j_of_type_AndroidWidgetTextView, str1, bool);
    paramString = this.l;
    TextView localTextView = this.jdField_j_of_type_AndroidWidgetTextView;
    String str2 = getString(2131694471);
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
    this.jdField_d_of_type_AndroidWidgetEditText.setHint(2131694464);
    a(this.m, this.jdField_d_of_type_AndroidWidgetEditText, getString(2131694465), str);
  }
  
  public void finish()
  {
    Intent localIntent = new Intent();
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      localIntent.putExtra("result", this.jdField_a_of_type_AndroidOsBundle);
    }
    if ((this.jdField_a_of_type_Aeij != null) && (this.jdField_a_of_type_Aeij.jdField_a_of_type_Boolean))
    {
      localIntent.putExtra("is_set_cover", true);
      localIntent.putExtra("cover_data", this.jdField_a_of_type_Aeij.jdField_a_of_type_ArrayOfByte);
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
    for (String str1 = getString(2131694494);; str1 = paramString)
    {
      a(this.jdField_k_of_type_AndroidWidgetTextView, str1, TextUtils.isEmpty(paramString));
      paramString = this.n;
      TextView localTextView = this.jdField_k_of_type_AndroidWidgetTextView;
      String str2 = getString(2131694495);
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
      do
      {
        do
        {
          do
          {
            return true;
          } while ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 2));
          i();
          QQToast.a(this, 2131690905, 0).b(getTitleBarHeight());
          return true;
          a(paramMessage);
          a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Bhzj.jdField_b_of_type_Int);
          this.jdField_f_of_type_Int = 0;
          try
          {
            long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_Anip.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, "");
            this.jdField_a_of_type_Anip.a(l1, this.jdField_a_of_type_Aniv);
            return true;
          }
          catch (Exception paramMessage) {}
        } while (!QLog.isColorLevel());
        QLog.e("FriendProfileMoreInfoActivity", 2, "handleMessage MSG_LOAD_PHOTO_WALL_FROM_DATABASE fail!", paramMessage);
        return true;
        this.jdField_f_of_type_Int |= 0x1;
        a(paramMessage);
      } while (this.jdField_f_of_type_Int != 17);
      a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Bhzj.jdField_b_of_type_Int);
      return true;
      this.jdField_f_of_type_Int |= 0x10;
      a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_b_of_type_JavaUtilArrayList);
    } while (this.jdField_f_of_type_Int != 17);
    a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Bhzj.jdField_b_of_type_Int);
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
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
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
        Object localObject = new Intent(paramView.getContext(), QQBrowserActivity.class);
        ((Intent)localObject).putExtra("hide_more_button", true);
        ((Intent)localObject).putExtra("hide_operation_bar", true);
        ((Intent)localObject).putExtra("url", "https://ti.qq.com/photowall/index.html?_wv=1027");
        ((Intent)localObject).putExtra("leftViewText", getString(2131690389));
        startActivityForResult((Intent)localObject, 1001);
        bcst.b(this.app, "dc00898", "", "", "0X8007EC4", "0X8007EC4", 0, 0, "", "", "", "");
        continue;
        localObject = new Intent(this, AvatarPendantActivity.class);
        ((Intent)localObject).putExtra("AllInOne", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        ((Intent)localObject).putExtra("showActionSheet", true);
        startActivity((Intent)localObject);
        bcst.b(this.app, "dc00898", "", "", "0X8007EC5", "0X8007EC5", 0, 0, "", "", "", "");
        continue;
        g();
        bcst.b(this.app, "dc00898", "", "", "0X8007EC6", "0X8007EC6", 0, 0, "", "", "", "");
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
            ((Intent)localObject).putExtra("title", 2131694495).putExtra("limit", 383).putExtra("canPostNull", true).putExtra("hint", 2131694494).putExtra("multiLine", true).putExtra("current", this.jdField_e_of_type_JavaLangString).putExtra("action", 104).putExtra("key_title_style", 0).putExtra("key_hide_clear_btn", true).putExtra("key_null_bg", true).putExtra("key_simple_count_style", true);
            startActivityForResult((Intent)localObject, 1007);
            continue;
            if (this.jdField_a_of_type_Aeij != null)
            {
              localObject = this.jdField_a_of_type_Aeij;
              if (this.jdField_a_of_type_Aeij.jdField_a_of_type_Int != 0) {
                break label789;
              }
            }
            label789:
            for (boolean bool = true;; bool = false)
            {
              ((aeij)localObject).a(bool);
              bcst.b(this.app, "dc00898", "", "", "0X8009C0E", "0X8009C0E", 0, 0, "", "", "", "");
              break;
            }
            if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 0)
            {
              this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
              bgsg.u(this, this.app.getCurrentAccountUin(), true);
            }
            azfr.a(this.app, this, this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
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
            bcst.b(this.app, "dc00898", "", "", "0X800A0D6", "0X800A0D6", 0, 0, "", "", "", "");
            if ((paramView.getTag() instanceof azfw))
            {
              localObject = (azfw)paramView.getTag();
              h(String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994&idx=%d", new Object[] { Integer.valueOf(((azfw)localObject).jdField_b_of_type_Int), Integer.valueOf(((azfw)localObject).jdField_a_of_type_Int) }));
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
      if (this.jdField_a_of_type_Aeii.jdField_b_of_type_Boolean)
      {
        paramView = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
        if ((!TextUtils.isEmpty(paramView)) && (!TextUtils.isEmpty(paramView.trim()))) {}
      }
    }
    label70:
    Matcher localMatcher;
    do
    {
      QQToast.a(this, anni.a(2131703672), 0).b(getTitleBarHeight());
      do
      {
        return;
      } while ((paramView != this.jdField_d_of_type_AndroidWidgetEditText) || (!this.jdField_d_of_type_Aeii.jdField_b_of_type_Boolean));
      paramView = this.jdField_d_of_type_AndroidWidgetEditText.getText().toString();
      localMatcher = SearchBaseActivity.a.matcher(paramView);
    } while ((TextUtils.isEmpty(paramView)) || (localMatcher.matches()));
    QQToast.a(this, anni.a(2131703696), 0).b(getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity
 * JD-Core Version:    0.7.0.1
 */