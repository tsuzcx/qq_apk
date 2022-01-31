package com.tencent.mobileqq.activity;

import NS_MOBILE_MAIN_PAGE.PhotoWall;
import aawq;
import aawr;
import aaws;
import aawt;
import aawu;
import aawv;
import aaww;
import aawx;
import aawy;
import aawz;
import aaxa;
import aaxb;
import aaxc;
import aaxd;
import aaxf;
import ajfi;
import ajfn;
import ajfo;
import ajfw;
import ajga;
import ajjh;
import ajjj;
import ajjy;
import alov;
import alow;
import android.content.BroadcastReceiver;
import android.content.Intent;
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
import atxe;
import atxk;
import atxp;
import awqx;
import axjq;
import azgh;
import azyf;
import azyk;
import babh;
import babr;
import badq;
import bafb;
import baig;
import bajo;
import bami;
import bble;
import bbma;
import bbms;
import bbmy;
import bbne;
import befq;
import begr;
import behe;
import bgfw;
import bgfx;
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
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;

public class FriendProfileMoreInfoActivity
  extends ProfileActivity
  implements aaxf, Handler.Callback, View.OnClickListener, View.OnFocusChangeListener, CompoundButton.OnCheckedChangeListener
{
  private byte jdField_a_of_type_Byte;
  public int a;
  public aaxc a;
  public aaxd a;
  ajfi jdField_a_of_type_Ajfi;
  private ajfn jdField_a_of_type_Ajfn = new aawy(this);
  public ajfo a;
  ajfw jdField_a_of_type_Ajfw;
  private ajga jdField_a_of_type_Ajga = new aawx(this);
  private ajjh jdField_a_of_type_Ajjh = new aaww(this);
  private alow jdField_a_of_type_Alow = new aawv(this);
  protected BroadcastReceiver a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public Bundle a;
  View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public EditText a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private bble jdField_a_of_type_Bble = new bble();
  bbma jdField_a_of_type_Bbma;
  bbms jdField_a_of_type_Bbms = null;
  public befq a;
  public begr a;
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
  public aaxc b;
  private View jdField_b_of_type_AndroidViewView;
  public EditText b;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public bbms b;
  String jdField_b_of_type_JavaLangString = "";
  private ArrayList<ProfilePhotoWall> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  public boolean b;
  String[] jdField_b_of_type_ArrayOfJavaLangString;
  private int jdField_c_of_type_Int;
  public aaxc c;
  private View jdField_c_of_type_AndroidViewView;
  public EditText c;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString = "";
  public boolean c;
  private int jdField_d_of_type_Int;
  public aaxc d;
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
  private int jdField_f_of_type_Int = -1;
  private View jdField_f_of_type_AndroidViewView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private String jdField_f_of_type_JavaLangString;
  public boolean f;
  private int jdField_g_of_type_Int = -1;
  private View jdField_g_of_type_AndroidViewView;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  public boolean g;
  private int jdField_h_of_type_Int = -1;
  private View jdField_h_of_type_AndroidViewView;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  public boolean h;
  private int jdField_i_of_type_Int = -1;
  private View jdField_i_of_type_AndroidViewView;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  public boolean i;
  private int jdField_j_of_type_Int = -1;
  private View jdField_j_of_type_AndroidViewView;
  private TextView jdField_j_of_type_AndroidWidgetTextView;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
  private View jdField_k_of_type_AndroidViewView;
  private TextView jdField_k_of_type_AndroidWidgetTextView;
  private boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int;
  private View jdField_l_of_type_AndroidViewView;
  private boolean jdField_l_of_type_Boolean;
  private int jdField_m_of_type_Int;
  private View jdField_m_of_type_AndroidViewView;
  private boolean jdField_m_of_type_Boolean;
  private int jdField_n_of_type_Int;
  private View jdField_n_of_type_AndroidViewView;
  private boolean jdField_n_of_type_Boolean;
  private View jdField_o_of_type_AndroidViewView;
  private boolean jdField_o_of_type_Boolean;
  private View p;
  
  public FriendProfileMoreInfoActivity()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Bbms = null;
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
    this.jdField_a_of_type_Ajfo = new aawq(this);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aawu(this);
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
  
  private void a(int paramInt, Intent paramIntent)
  {
    if (paramIntent.hasExtra("param_interest_switch")) {
      this.jdField_f_of_type_Int = paramIntent.getIntExtra("param_interest_switch", 0);
    }
    if (!this.jdField_j_of_type_Boolean) {
      this.jdField_j_of_type_Boolean = paramIntent.getBooleanExtra("param_interest_switch_changed", false);
    }
    if (paramIntent.hasExtra("param_music_switch")) {
      this.jdField_g_of_type_Int = paramIntent.getIntExtra("param_music_switch", 0);
    }
    if (!this.jdField_k_of_type_Boolean) {
      this.jdField_k_of_type_Boolean = paramIntent.getBooleanExtra("param_music_switch_changed", false);
    }
    if (paramIntent.hasExtra("param_present_switch")) {
      this.jdField_j_of_type_Int = paramIntent.getIntExtra("param_present_switch_changed", 0);
    }
    if (!this.jdField_n_of_type_Boolean) {
      this.jdField_n_of_type_Boolean = paramIntent.getBooleanExtra("param_present_switch", false);
    }
    if (paramIntent.hasExtra("param_extendfriend_switch")) {
      this.jdField_i_of_type_Int = paramIntent.getIntExtra("param_extendfriend_switch", 0);
    }
    if (!this.jdField_m_of_type_Boolean) {
      this.jdField_m_of_type_Boolean = paramIntent.getBooleanExtra("param_extendfriend_switch_changed", false);
    }
    if (paramIntent.hasExtra("param_personlabel_switch")) {
      this.jdField_h_of_type_Int = paramIntent.getIntExtra("param_personlabel_switch", 0);
    }
    if (!this.jdField_l_of_type_Boolean) {
      this.jdField_l_of_type_Boolean = paramIntent.getBooleanExtra("param_personlabel_switch_changed", false);
    }
    if (a()) {
      j();
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Bbms == null) {
      this.jdField_a_of_type_Bbms = new bbms(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_Bbms.a(paramString);
    this.jdField_a_of_type_Bbms.show();
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
    if (paramCard.lCurrentStyleId != atxe.a) {}
    this.jdField_f_of_type_JavaLangString = paramCard.strNick;
    a(paramCard.getRichStatus());
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if ((!this.jdField_a_of_type_Aaxc.jdField_b_of_type_Boolean) && (paramCard.strNick != null) && (!paramCard.strNick.equals(localObject1)))
    {
      this.jdField_a_of_type_Aaxc.jdField_a_of_type_Boolean = true;
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
      if ((!this.jdField_b_of_type_Aaxc.jdField_b_of_type_Boolean) && (paramCard.strCompany != null) && (!paramCard.strCompany.equals(localObject1)))
      {
        this.jdField_b_of_type_Aaxc.jdField_a_of_type_Boolean = true;
        b(paramCard.strCompany);
      }
      localObject1 = this.jdField_c_of_type_AndroidWidgetEditText.getText().toString();
      if ((!this.jdField_c_of_type_Aaxc.jdField_b_of_type_Boolean) && (paramCard.strSchool != null) && (!paramCard.strSchool.equals(localObject1)))
      {
        this.jdField_c_of_type_Aaxc.jdField_a_of_type_Boolean = true;
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
      if ((!this.jdField_d_of_type_Aaxc.jdField_b_of_type_Boolean) && (paramCard.strEmail != null) && (!paramCard.strEmail.equals(localObject1)))
      {
        this.jdField_d_of_type_Aaxc.jdField_a_of_type_Boolean = true;
        f(paramCard.strEmail);
      }
      if (!this.jdField_h_of_type_Boolean) {
        g(paramCard.strPersonalNote);
      }
      if ((this.jdField_a_of_type_Aaxd == null) || (!this.jdField_a_of_type_Aaxd.jdField_a_of_type_Boolean)) {
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
  
  private void a(ArrayList<atxp> paramArrayList)
  {
    if ((paramArrayList != null) && (this.p.getVisibility() == 0) && (this.jdField_c_of_type_AndroidWidgetLinearLayout != null))
    {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.removeAllViews();
      Object localObject;
      if (paramArrayList.size() > 0)
      {
        paramArrayList = paramArrayList.iterator();
        do
        {
          if (!paramArrayList.hasNext()) {
            break;
          }
          localObject = (atxp)paramArrayList.next();
        } while (TextUtils.isEmpty(((atxp)localObject).jdField_b_of_type_JavaLangString));
        View localView = View.inflate(this, 2131495400, null);
        ((TextView)localView.findViewById(2131309865)).setText(((atxp)localObject).jdField_b_of_type_JavaLangString);
        TextView localTextView = (TextView)localView.findViewById(2131299960);
        String str = ((atxp)localObject).a();
        if (TextUtils.isEmpty(str)) {
          localTextView.setVisibility(8);
        }
        for (;;)
        {
          localView.setOnClickListener(this);
          localView.setTag(localObject);
          this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(localView);
          break;
          localTextView.setText(str);
        }
      }
      paramArrayList = ((ajjj)this.app.getManager(51)).c(this.app.getCurrentAccountUin());
      if ((paramArrayList != null) && (!TextUtils.isEmpty(paramArrayList.strSchool)))
      {
        localObject = View.inflate(this, 2131495400, null);
        ((TextView)((View)localObject).findViewById(2131309865)).setText(paramArrayList.strSchool);
        ((TextView)((View)localObject).findViewById(2131299960)).setVisibility(8);
        ((View)localObject).setOnClickListener(this);
        ((View)localObject).setTag(paramArrayList);
        this.jdField_c_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
      }
      if (this.jdField_c_of_type_AndroidWidgetLinearLayout.getChildCount() < 2)
      {
        this.p.findViewById(2131309858).setVisibility(0);
        this.p.findViewById(2131309862).setVisibility(0);
        this.p.findViewById(2131309860).setVisibility(0);
        this.p.findViewById(2131309856).setVisibility(8);
      }
    }
    else
    {
      return;
    }
    this.p.findViewById(2131309858).setVisibility(8);
    this.p.findViewById(2131309862).setVisibility(8);
    this.p.findViewById(2131309860).setVisibility(8);
    this.p.findViewById(2131309856).setVisibility(0);
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
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(((Resources)localObject2).getColor(2131100052));
            this.jdField_m_of_type_Int = ((Resources)localObject2).getDimensionPixelSize(2131167070);
            this.jdField_n_of_type_Int = ((Resources)localObject2).getDimensionPixelSize(2131167069);
          }
          Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.jdField_m_of_type_Int;
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.jdField_m_of_type_Int;
          localObject2 = URLDrawable.getDrawable(((ProfilePhotoWall)localObject1).getThumbUrl(this.jdField_l_of_type_Int), (URLDrawable.URLDrawableOptions)localObject2);
          localObject1 = new ImageView(getBaseContext());
          ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
          ((ImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_CROP);
          localObject2 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject2).width = this.jdField_m_of_type_Int;
          ((LinearLayout.LayoutParams)localObject2).height = this.jdField_m_of_type_Int;
          ((LinearLayout.LayoutParams)localObject2).rightMargin = this.jdField_n_of_type_Int;
          this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          i4 = this.jdField_m_of_type_Int;
          i5 = this.jdField_n_of_type_Int;
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
          i4 = this.jdField_m_of_type_Int;
          i5 = this.jdField_n_of_type_Int;
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
    this.jdField_o_of_type_Boolean = false;
    if (paramBoolean) {
      a(((alov)this.app.getManager(112)).a());
    }
  }
  
  private boolean a()
  {
    return (this.jdField_j_of_type_Boolean) || (this.jdField_k_of_type_Boolean) || (this.jdField_m_of_type_Boolean) || (this.jdField_l_of_type_Boolean) || (this.jdField_n_of_type_Boolean);
  }
  
  private boolean a(Bundle paramBundle, int paramInt1, int paramInt2)
  {
    if (!badq.d(this)) {
      a(paramInt1, paramInt2);
    }
    while ((paramBundle == null) || (paramBundle.isEmpty())) {
      return false;
    }
    this.jdField_a_of_type_Ajfi.a(paramBundle);
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
    if (a(localBundle, 2131628948, 0)) {
      this.jdField_o_of_type_Boolean = true;
    }
  }
  
  private void b(int paramInt)
  {
    awqx.b(this.app, "dc00898", "", "", "0X800A0D5", "0X800A0D5", 0, 0, paramInt + "", "", "", "");
  }
  
  private void b(Card paramCard)
  {
    if ((paramCard != null) && (!this.jdField_i_of_type_Boolean) && (azyk.a(paramCard, this.app)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FriendProfileMoreInfoActivity", 2, "checkEduFirstGuide:");
      }
      String str = ajjy.a(2131639118);
      babr.a(this, ajjy.a(2131639097), str, null, 2131629680, 2131629681, new aawz(this), new aaxa(this)).show();
      azyk.a(paramCard, this.app);
      awqx.b(this.app, "dc00898", "", "", "0X800A0D7", "0X800A0D7", 0, 0, "", "", "", "");
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Aaxc.jdField_b_of_type_Boolean) || (this.jdField_b_of_type_Aaxc.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Aaxc.jdField_b_of_type_Boolean) || (this.jdField_d_of_type_Aaxc.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean) || (this.jdField_e_of_type_Boolean) || (this.jdField_f_of_type_Boolean) || (this.jdField_g_of_type_Boolean) || (this.jdField_h_of_type_Boolean);
  }
  
  private void c()
  {
    this.jdField_a_of_type_Ajfi.a(this.app.getLongAccountUin());
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
  
  private boolean c()
  {
    Bundle localBundle = new Bundle();
    Object localObject1;
    if (this.jdField_a_of_type_Aaxc.jdField_b_of_type_Boolean)
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
      if (this.jdField_b_of_type_Aaxc.jdField_b_of_type_Boolean) {
        localBundle.putString("company", this.jdField_b_of_type_AndroidWidgetEditText.getText().toString());
      }
      if (this.jdField_c_of_type_Aaxc.jdField_b_of_type_Boolean) {
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
      localObject2 = this.jdField_a_of_type_Ajfw.a(this.jdField_a_of_type_ArrayOfJavaLangString);
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
    if (this.jdField_d_of_type_Aaxc.jdField_b_of_type_Boolean)
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
      return a(localBundle, 2131628948, 0);
      localBundle.putString("nick", ((String)localObject1).trim());
      localObject1 = new bgfx();
      ((bgfx)localObject1).jdField_a_of_type_Int = 5;
      bgfw.a(getAppRuntime().getAccount()).a((bgfx)localObject1);
      break;
      localBundle.putString("email", (String)localObject1);
    }
  }
  
  private void d()
  {
    begr localbegr = (begr)behe.a(this, null);
    localbegr.a(2131629677, 0);
    localbegr.a(2131629679, 0);
    localbegr.a(2131629678, 0);
    localbegr.c(2131625035);
    localbegr.a(new aaxb(this, localbegr));
    localbegr.show();
  }
  
  private void d(int paramInt)
  {
    int i1 = this.jdField_a_of_type_Ajfw.a();
    if (i1 != 0)
    {
      i1 = this.jdField_a_of_type_Ajfw.a(i1, true);
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileMoreInfoActivity", 2, "startLocationSelectActivity | update result = " + i1);
      }
      if (i1 == 2)
      {
        bbmy.a(this, 2131628948, 0).b(getTitleBarHeight());
        return;
      }
      if (i1 == 0)
      {
        a(paramInt, getString(2131625459));
        this.jdField_a_of_type_Ajfw.c(this.jdField_a_of_type_Ajga);
        return;
      }
      a(paramInt, getString(2131625459));
      this.jdField_a_of_type_Befq.sendEmptyMessageDelayed(1000, 20000L);
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
      ((Intent)localObject1).putExtra("param_location_param", this.jdField_a_of_type_Ajfw.b((String[])localObject2));
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
    if (b())
    {
      if (this.jdField_b_of_type_Bbms == null)
      {
        this.jdField_b_of_type_Bbms = new bbms(this, getTitleBarHeight());
        this.jdField_b_of_type_Bbms.a(ajjy.a(2131639095));
      }
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_Bbms.dismiss();
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
        if (c())
        {
          this.jdField_a_of_type_Boolean = true;
          this.jdField_b_of_type_Bbms.show();
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131309752));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302847));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131627814);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131627814));
    Object localObject = (TextView)findViewById(2131302804);
    ((TextView)localObject).setText("");
    ((TextView)localObject).setContentDescription(ajjy.a(2131639141));
    ((TextView)localObject).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131299149));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131305888);
    this.jdField_a_of_type_AndroidViewView.setContentDescription(getString(2131629827));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131305793));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131305794));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131297423);
    this.jdField_b_of_type_AndroidViewView.setContentDescription(getString(2131626680));
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297419));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131310411);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131310413));
    a(null);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131299245);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    a(null);
    this.jdField_e_of_type_AndroidViewView = findViewById(2131312021);
    if (this.jdField_i_of_type_Boolean)
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)findViewById(2131312024));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131312022));
      localObject = findViewById(2131312020);
      TroopInfo localTroopInfo = ((TroopManager)this.app.getManager(52)).b(this.jdField_a_of_type_JavaLangString);
      if (localTroopInfo != null)
      {
        if ((localTroopInfo.isTroopAdmin(this.app.getCurrentAccountUin())) || (localTroopInfo.isTroopOwner(this.app.getCurrentAccountUin())) || (TextUtils.equals(this.jdField_b_of_type_JavaLangString, this.app.getCurrentAccountUin())))
        {
          this.jdField_e_of_type_AndroidViewView.setClickable(true);
          this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
          ((View)localObject).setVisibility(0);
        }
        a();
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131305151));
      if (this.jdField_e_of_type_AndroidViewView.getVisibility() == 0) {
        ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams()).setMargins(0, 0, 0, 0);
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setClickable(true);
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131305150));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131305152));
      if (!baig.C(this, this.app.getCurrentAccountUin())) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this);
      this.jdField_a_of_type_Aaxc = new aaxc(this, 36, this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_Aaxc.jdField_a_of_type_Boolean = true;
      a(null);
      this.jdField_f_of_type_AndroidViewView = findViewById(2131310225);
      this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131310226));
      a(-1, false);
      this.jdField_g_of_type_AndroidViewView = findViewById(2131297707);
      this.jdField_g_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297708));
      a(0, 0, 0);
      if (azyk.b())
      {
        i1 = this.jdField_f_of_type_AndroidViewView.getPaddingLeft();
        int i2 = this.jdField_f_of_type_AndroidViewView.getPaddingTop();
        int i3 = this.jdField_f_of_type_AndroidViewView.getPaddingRight();
        int i4 = this.jdField_f_of_type_AndroidViewView.getPaddingBottom();
        this.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130839151);
        this.jdField_f_of_type_AndroidViewView.setPadding(i1, i2, i3, i4);
        this.jdField_g_of_type_AndroidViewView.setVisibility(8);
        if (QLog.isDevelopLevel()) {
          QLog.i("FriendProfileMoreInfoActivity", 4, String.format(Locale.getDefault(), "EuropeAndAmerica sexLayout[%s, %s, %s, %s]", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4) }));
        }
      }
      this.jdField_h_of_type_AndroidViewView = findViewById(2131306269);
      this.jdField_h_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131306268));
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131306270));
      a(-1);
      this.jdField_i_of_type_AndroidViewView = findViewById(2131299014);
      this.jdField_i_of_type_AndroidViewView.setClickable(false);
      this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131299013));
      this.jdField_b_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this);
      this.jdField_b_of_type_Aaxc = new aaxc(this, 120, this.jdField_b_of_type_AndroidWidgetEditText);
      this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_b_of_type_Aaxc);
      this.jdField_b_of_type_Aaxc.jdField_a_of_type_Boolean = true;
      b(null);
      this.jdField_j_of_type_AndroidViewView = findViewById(2131309864);
      this.jdField_j_of_type_AndroidViewView.setClickable(false);
      this.jdField_c_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131309863));
      this.jdField_c_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this);
      this.jdField_c_of_type_Aaxc = new aaxc(this, 40, this.jdField_c_of_type_AndroidWidgetEditText);
      this.jdField_c_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_c_of_type_Aaxc);
      this.jdField_c_of_type_Aaxc.jdField_a_of_type_Boolean = true;
      c(null);
      this.jdField_k_of_type_AndroidViewView = findViewById(2131303867);
      this.jdField_k_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131303879));
      d(null);
      this.jdField_l_of_type_AndroidViewView = findViewById(2131301948);
      this.jdField_l_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131301949));
      e(null);
      this.jdField_m_of_type_AndroidViewView = findViewById(2131299976);
      this.jdField_m_of_type_AndroidViewView.setClickable(false);
      this.jdField_d_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131299975));
      this.jdField_d_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this);
      this.jdField_d_of_type_Aaxc = new aaxc(this, 50, this.jdField_d_of_type_AndroidWidgetEditText);
      this.jdField_d_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_d_of_type_Aaxc);
      this.jdField_d_of_type_Aaxc.jdField_a_of_type_Boolean = true;
      f(null);
      this.jdField_n_of_type_AndroidViewView = findViewById(2131305703);
      this.jdField_n_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131305704));
      g(null);
      this.jdField_o_of_type_AndroidViewView = findViewById(2131302610);
      this.jdField_o_of_type_AndroidViewView.setContentDescription(getString(2131629727));
      this.jdField_o_of_type_AndroidViewView.setOnClickListener(this);
      this.p = findViewById(2131299962);
      this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296587));
      findViewById(2131309857).setOnClickListener(this);
      findViewById(2131309861).setOnClickListener(this);
      findViewById(2131309859).setOnClickListener(this);
      findViewById(2131309855).setOnClickListener(this);
      if ((this.jdField_a_of_type_Bbma != null) && (!this.jdField_a_of_type_Bbma.a(3)) && (!this.jdField_a_of_type_Bbma.a(5)) && (!this.jdField_a_of_type_Bbma.a(4)) && (!this.jdField_a_of_type_Bbma.a(6)) && (!this.jdField_a_of_type_Bbma.a(7)))
      {
        localObject = getIntent();
        if (localObject != null) {
          break label1556;
        }
        i1 = -1;
        label1378:
        if ((i1 == -1) || (i1 == 1)) {
          break label1569;
        }
      }
    }
    label1556:
    label1569:
    for (int i1 = 0;; i1 = 1)
    {
      if (i1 == 0) {
        this.jdField_o_of_type_AndroidViewView.setVisibility(8);
      }
      if ((this.jdField_i_of_type_Boolean) && (TroopInfo.isQidianPrivateTroop(this.app, this.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_h_of_type_AndroidViewView.setVisibility(8);
        this.jdField_i_of_type_AndroidViewView.setVisibility(8);
        this.jdField_j_of_type_AndroidViewView.setVisibility(8);
        this.jdField_l_of_type_AndroidViewView.setVisibility(8);
        this.jdField_m_of_type_AndroidViewView.setVisibility(8);
        this.jdField_n_of_type_AndroidViewView.setVisibility(8);
        this.jdField_o_of_type_AndroidViewView.setVisibility(8);
      }
      if (!this.jdField_i_of_type_Boolean)
      {
        this.jdField_j_of_type_AndroidViewView.setVisibility(8);
        this.p.setVisibility(0);
      }
      return;
      this.jdField_e_of_type_AndroidViewView.setClickable(false);
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(null);
      ((View)localObject).setVisibility(8);
      break;
      i1 = ((Intent)localObject).getIntExtra("extendFriendEntryAddFriend", -1);
      break label1378;
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) {
      return;
    }
    bajo.a(this, this.app, 0, "signature_ziliaoka", 1002);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Begr == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getLayoutInflater().inflate(2131495228, null));
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(new aawr(this));
      this.jdField_a_of_type_Begr = begr.c(this);
      this.jdField_a_of_type_Begr.d(true);
      this.jdField_a_of_type_Begr.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
      localObject = (DispatchActionMoveScrollView)this.jdField_a_of_type_Begr.findViewById(2131296387);
      ((DispatchActionMoveScrollView)localObject).jdField_a_of_type_Boolean = true;
      ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = this.jdField_a_of_type_Begr.getWindow();
        if (localObject != null) {
          ((Window)localObject).setFlags(16777216, 16777216);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(new aaws(this));
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
        this.jdField_a_of_type_Begr.setOnDismissListener(new aawt(this));
        this.jdField_a_of_type_Begr.show();
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
    Intent localIntent = new Intent(this, InterestSwitchEditActivity.class);
    if (-1 != this.jdField_f_of_type_Int) {
      localIntent.putExtra("param_interest_switch", this.jdField_f_of_type_Int);
    }
    if (-1 != this.jdField_g_of_type_Int) {
      localIntent.putExtra("param_music_switch", this.jdField_g_of_type_Int);
    }
    if (-1 != this.jdField_i_of_type_Int) {
      localIntent.putExtra("param_extendfriend_switch", this.jdField_i_of_type_Int);
    }
    if (-1 != this.jdField_h_of_type_Int) {
      localIntent.putExtra("param_personlabel_switch", this.jdField_h_of_type_Int);
    }
    if (-1 != this.jdField_j_of_type_Int) {
      localIntent.putExtra("param_present_switch", this.jdField_j_of_type_Int);
    }
    startActivityForResult(localIntent, 1008);
  }
  
  private void j()
  {
    Bundle localBundle = new Bundle();
    if (this.jdField_j_of_type_Boolean) {
      localBundle.putShort("key_interest_switch", (short)this.jdField_f_of_type_Int);
    }
    if (this.jdField_k_of_type_Boolean) {
      localBundle.putShort("key_music_switch", (short)this.jdField_g_of_type_Int);
    }
    if (this.jdField_n_of_type_Boolean) {
      localBundle.putShort("key_present_switch", (short)this.jdField_j_of_type_Int);
    }
    if (this.jdField_m_of_type_Boolean) {
      localBundle.putShort("key_extend_friend_switch", (short)this.jdField_i_of_type_Int);
    }
    if (this.jdField_l_of_type_Boolean) {
      localBundle.putShort("key_personality_label_switch", (short)this.jdField_h_of_type_Int);
    }
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing())) {
      this.jdField_a_of_type_Bbms.dismiss();
    }
  }
  
  void a()
  {
    String str = babh.i(this.app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    if ((TextUtils.isEmpty(str)) || (TextUtils.equals(str, this.jdField_b_of_type_JavaLangString)))
    {
      str = "";
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      SpannableString localSpannableString = new axjq(str, 16).a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText(localSpannableString);
      bami.a(this.app, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, localSpannableString);
      a(this.jdField_e_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, getString(2131632091), str);
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
    if (azyf.a(paramInt))
    {
      this.jdField_e_of_type_Int = paramInt;
      localObject2 = azyf.e(paramInt);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        this.jdField_e_of_type_Int = -1;
        localObject1 = getString(2131629759);
      }
      if ((paramInt < azyf.e.length - 1) && (paramInt > 0)) {
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
      str = getString(2131629760);
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
      localObject2 = getResources().getDrawable(azyf.b[paramInt]);
      ProfileActivity.a(this.app, (Drawable)localObject2);
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_g_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localObject2);
      this.jdField_g_of_type_AndroidWidgetTextView.setText(azyf.e[paramInt]);
      break label67;
      label192:
      localObject1 = "";
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    new bbne(this).a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_d_of_type_Int = paramInt3;
    String str1 = getString(2131629672);
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
      str2 = getString(2131629673);
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
    this.jdField_a_of_type_Bble.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_Bble.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_Bble.jdField_a_of_type_JavaLangString = paramString;
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
      this.jdField_a_of_type_Bble.jdField_a_of_type_Int = paramList.size();
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Byte = ((byte)paramInt);
    String str = getString(2131629763);
    if (paramInt == 0)
    {
      str = getString(2131628431);
      if (!paramBoolean) {
        break label88;
      }
      a(this.jdField_e_of_type_AndroidWidgetTextView, str, 2131101268);
      if ((paramInt != 0) && (paramInt != 1)) {
        break label121;
      }
    }
    for (;;)
    {
      a(this.jdField_f_of_type_AndroidViewView, this.jdField_e_of_type_AndroidWidgetTextView, getString(2131629764), str);
      return;
      if (paramInt != 1) {
        break;
      }
      str = getString(2131626792);
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
      paramView1 = paramString1 + ajjy.a(2131639122) + paramString2 + ",";
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
    for (int i1 = 2131101338;; i1 = 2131101260)
    {
      a(paramTextView, paramCharSequence, i1);
      return;
    }
  }
  
  void a(Card paramCard)
  {
    if (this.jdField_a_of_type_Aaxd != null) {
      this.jdField_a_of_type_Aaxd.a(paramCard);
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
      a(this.jdField_c_of_type_AndroidViewView, this.jdField_d_of_type_AndroidWidgetTextView, getString(2131627928), paramRichStatus);
      return;
      paramRichStatus = ajjy.a(2131639130);
      bool = true;
    }
  }
  
  public void a(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString))
    {
      str = "";
      paramString = getString(2131629734);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(str);
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(paramString);
      a(this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_AndroidWidgetEditText, getString(2131629735), str);
      return;
      str = paramString;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (TroopInfo.isHomeworkTroop(this.app, paramString1))
    {
      azgh.a(this, paramString2, paramString1, "qqProfile");
      return;
    }
    Intent localIntent = new Intent(this, EditInfoActivity.class);
    localIntent.putExtra("edit_type", 0);
    localIntent.putExtra("troopUin", paramString1);
    localIntent.putExtra("uin", paramString2);
    paramString1 = "";
    if (paramInt == 1011)
    {
      paramString1 = getString(2131632095);
      localIntent.putExtra("isTroopNick", true);
      localIntent.putExtra("default_text", this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getText().toString() + "");
      localIntent.putExtra("max_num", 60);
    }
    localIntent.putExtra("title", paramString1);
    if (TextUtils.isEmpty("")) {
      localIntent.putExtra("default_hint", ajjy.a(2131639103));
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
    this.jdField_b_of_type_AndroidWidgetEditText.setHint(2131629684);
    a(this.jdField_i_of_type_AndroidViewView, this.jdField_b_of_type_AndroidWidgetEditText, getString(2131629685), str);
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
    this.jdField_c_of_type_AndroidWidgetEditText.setHint(2131629761);
    a(this.jdField_j_of_type_AndroidViewView, this.jdField_c_of_type_AndroidWidgetEditText, getString(2131629762), str);
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Aaxd != null) {
      this.jdField_a_of_type_Aaxd.a(paramArrayOfByte);
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
      str1 = getString(2131629729);
      bool = true;
    }
    a(this.jdField_i_of_type_AndroidWidgetTextView, str1, bool);
    paramString = this.jdField_k_of_type_AndroidViewView;
    TextView localTextView = this.jdField_i_of_type_AndroidWidgetTextView;
    String str2 = getString(2131629730);
    if (!bool) {}
    for (;;)
    {
      a(paramString, localTextView, str2, str1);
      return;
      str1 = "";
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1001)
    {
      paramIntent = this.jdField_a_of_type_Befq.obtainMessage(1001);
      paramIntent.obj = null;
      this.jdField_a_of_type_Befq.sendMessage(paramIntent);
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
                                this.jdField_a_of_type_Ajfi.f();
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
                      localObject = this.jdField_a_of_type_Ajfw.a((String[])localObject);
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
                  localObject = this.jdField_a_of_type_Ajfw.a((String[])localObject);
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
            if (paramInt1 != 1008) {
              break;
            }
          } while (paramIntent == null);
          a(paramInt2, paramIntent);
          return;
          if (paramInt1 == 1011)
          {
            a();
            return;
          }
          if (paramInt1 != 1024) {
            break;
          }
        } while (this.jdField_a_of_type_Aaxd == null);
        this.jdField_a_of_type_Aaxd.b(paramInt2, paramIntent);
        return;
      } while (paramInt1 != 1012);
      if (QLog.isDevelopLevel()) {
        QLog.d("FriendProfileMoreInfoActivity", 2, "doOnActivityResult school web");
      }
    } while (this.jdField_a_of_type_Ajfi == null);
    label345:
    paramIntent = this.app.getCurrentAccountUin();
    this.jdField_a_of_type_Ajfi.a(paramIntent, paramIntent, 1, 0L, (byte)1, 0L, 0L, null, "", 0L, 10004, null, (byte)0);
    c();
  }
  
  /* Error */
  public boolean doOnCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 1585	com/tencent/mobileqq/activity/ProfileActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   5: pop
    //   6: aload_0
    //   7: ldc_w 1586
    //   10: invokespecial 1589	com/tencent/mobileqq/activity/ProfileActivity:setContentView	(I)V
    //   13: aload_0
    //   14: new 437	aaxd
    //   17: dup
    //   18: aload_0
    //   19: aload_0
    //   20: invokespecial 1592	aaxd:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Laaxf;)V
    //   23: putfield 435	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Aaxd	Laaxd;
    //   26: aload_0
    //   27: new 972	befq
    //   30: dup
    //   31: invokestatic 1509	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   34: aload_0
    //   35: invokespecial 1595	befq:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   38: putfield 968	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Befq	Lbefq;
    //   41: aload_0
    //   42: invokevirtual 1221	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:getIntent	()Landroid/content/Intent;
    //   45: astore_1
    //   46: aload_0
    //   47: aload_1
    //   48: ldc_w 1597
    //   51: iconst_0
    //   52: invokevirtual 214	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   55: putfield 115	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_i_of_type_Boolean	Z
    //   58: aload_0
    //   59: aload_1
    //   60: ldc_w 1472
    //   63: invokevirtual 1568	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   66: putfield 119	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   69: aload_0
    //   70: aload_1
    //   71: ldc_w 1599
    //   74: invokevirtual 1568	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   77: putfield 121	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   80: aload_0
    //   81: aload_1
    //   82: ldc_w 1601
    //   85: invokevirtual 1568	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   88: putfield 123	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   91: aload_0
    //   92: getfield 435	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Aaxd	Laaxd;
    //   95: aload_1
    //   96: ldc_w 1603
    //   99: iconst_0
    //   100: invokevirtual 206	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   103: putfield 1604	aaxd:jdField_a_of_type_Int	I
    //   106: aload_0
    //   107: getfield 435	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Aaxd	Laaxd;
    //   110: aload_1
    //   111: ldc_w 1606
    //   114: invokevirtual 1568	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   117: putfield 1607	aaxd:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   120: aload_0
    //   121: getfield 123	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   124: invokestatic 396	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   127: ifne +92 -> 219
    //   130: new 1609	org/json/JSONObject
    //   133: dup
    //   134: aload_0
    //   135: getfield 123	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   138: invokespecial 1611	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   141: astore_3
    //   142: aload_0
    //   143: aload_3
    //   144: ldc_w 1472
    //   147: invokevirtual 1614	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   150: putfield 119	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   153: aload_0
    //   154: aload_3
    //   155: ldc_w 1599
    //   158: invokevirtual 1614	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   161: putfield 121	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   164: aload_0
    //   165: getfield 119	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   168: invokestatic 396	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   171: ifne +18 -> 189
    //   174: aload_0
    //   175: getfield 121	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   178: invokestatic 396	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   181: ifne +8 -> 189
    //   184: aload_0
    //   185: iconst_1
    //   186: putfield 115	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_i_of_type_Boolean	Z
    //   189: invokestatic 542	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   192: ifeq +27 -> 219
    //   195: ldc_w 544
    //   198: iconst_2
    //   199: ldc_w 1616
    //   202: iconst_1
    //   203: anewarray 328	java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: aload_0
    //   209: getfield 123	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   212: aastore
    //   213: invokestatic 556	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   216: invokestatic 559	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: aload_0
    //   220: aload_0
    //   221: getfield 511	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   224: iconst_2
    //   225: invokevirtual 1619	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajfb;
    //   228: checkcast 704	ajfi
    //   231: putfield 702	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Ajfi	Lajfi;
    //   234: aload_0
    //   235: aload_0
    //   236: getfield 511	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   239: bipush 59
    //   241: invokevirtual 517	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   244: checkcast 862	ajfw
    //   247: putfield 860	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Ajfw	Lajfw;
    //   250: aload_0
    //   251: new 1214	bbma
    //   254: dup
    //   255: aload_0
    //   256: getfield 511	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   259: aconst_null
    //   260: invokespecial 1622	bbma:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;Lbbmb;)V
    //   263: putfield 1212	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Bbma	Lbbma;
    //   266: aload_0
    //   267: aload_0
    //   268: getfield 130	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Ajfo	Lajfo;
    //   271: invokevirtual 1626	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:addObserver	(Lajfe;)V
    //   274: aload_0
    //   275: aload_0
    //   276: getfield 140	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Ajjh	Lajjh;
    //   279: invokevirtual 1626	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:addObserver	(Lajfe;)V
    //   282: aload_0
    //   283: getfield 511	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   286: aload_0
    //   287: getfield 135	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Alow	Lalow;
    //   290: invokevirtual 1630	com/tencent/mobileqq/app/QQAppInterface:registObserver	(Lmqq/observer/BusinessObserver;)V
    //   293: aload_0
    //   294: getfield 860	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_Ajfw	Lajfw;
    //   297: aload_0
    //   298: invokevirtual 1632	ajfw:a	(Ljava/lang/Object;)V
    //   301: new 1634	android/content/IntentFilter
    //   304: dup
    //   305: invokespecial 1635	android/content/IntentFilter:<init>	()V
    //   308: astore_3
    //   309: aload_3
    //   310: ldc_w 1637
    //   313: invokevirtual 1640	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   316: aload_0
    //   317: aload_0
    //   318: getfield 155	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   321: aload_3
    //   322: invokevirtual 1644	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   325: pop
    //   326: aload_0
    //   327: ldc_w 1645
    //   330: invokespecial 1646	com/tencent/mobileqq/activity/ProfileActivity:findViewById	(I)Landroid/view/View;
    //   333: checkcast 455	android/widget/LinearLayout
    //   336: astore_3
    //   337: invokestatic 1651	com/tencent/widget/immersive/ImmersiveUtils:isSupporImmersive	()I
    //   340: iconst_1
    //   341: if_icmpne +19 -> 360
    //   344: aload_3
    //   345: iconst_1
    //   346: invokevirtual 1654	android/widget/LinearLayout:setFitsSystemWindows	(Z)V
    //   349: aload_3
    //   350: iconst_0
    //   351: aload_0
    //   352: invokestatic 1658	com/tencent/widget/immersive/ImmersiveUtils:getStatusBarHeight	(Landroid/content/Context;)I
    //   355: iconst_0
    //   356: iconst_0
    //   357: invokevirtual 1659	android/widget/LinearLayout:setPadding	(IIII)V
    //   360: aload_0
    //   361: invokespecial 1660	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:f	()V
    //   364: aload_0
    //   365: invokevirtual 576	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:getResources	()Landroid/content/res/Resources;
    //   368: invokevirtual 1664	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   371: astore_3
    //   372: aload_3
    //   373: getfield 1669	android/util/DisplayMetrics:widthPixels	I
    //   376: aload_3
    //   377: getfield 1672	android/util/DisplayMetrics:heightPixels	I
    //   380: invokestatic 1678	java/lang/Math:max	(II)I
    //   383: istore_2
    //   384: iload_2
    //   385: sipush 240
    //   388: if_icmpgt +244 -> 632
    //   391: aload_0
    //   392: bipush 60
    //   394: putfield 616	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_l_of_type_Int	I
    //   397: aload_0
    //   398: aload_0
    //   399: invokevirtual 1221	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:getIntent	()Landroid/content/Intent;
    //   402: ldc_w 1680
    //   405: invokevirtual 1684	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   408: checkcast 1401	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   411: putfield 1229	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   414: aload_0
    //   415: aload_0
    //   416: invokevirtual 1221	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:getIntent	()Landroid/content/Intent;
    //   419: ldc_w 1686
    //   422: invokevirtual 1684	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   425: checkcast 1688	com/tencent/mobileqq/businessCard/data/BusinessCard
    //   428: putfield 1690	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard	Lcom/tencent/mobileqq/businessCard/data/BusinessCard;
    //   431: aload_0
    //   432: getfield 1229	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   435: ifnonnull +22 -> 457
    //   438: aload_0
    //   439: new 1401	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   442: dup
    //   443: aload_0
    //   444: getfield 511	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   447: invokevirtual 1692	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   450: iconst_0
    //   451: invokespecial 1694	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   454: putfield 1229	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   457: aload_0
    //   458: getfield 1690	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard	Lcom/tencent/mobileqq/businessCard/data/BusinessCard;
    //   461: ifnonnull +14 -> 475
    //   464: aload_0
    //   465: aload_0
    //   466: getfield 511	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   469: invokestatic 1699	alqg:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/businessCard/data/BusinessCard;
    //   472: putfield 1690	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard	Lcom/tencent/mobileqq/businessCard/data/BusinessCard;
    //   475: new 1701	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity$6
    //   478: dup
    //   479: aload_0
    //   480: invokespecial 1702	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity$6:<init>	(Lcom/tencent/mobileqq/activity/FriendProfileMoreInfoActivity;)V
    //   483: iconst_5
    //   484: aconst_null
    //   485: iconst_1
    //   486: invokestatic 1707	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   489: aload_0
    //   490: getfield 115	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_i_of_type_Boolean	Z
    //   493: ifne +26 -> 519
    //   496: aload_0
    //   497: aload_0
    //   498: getfield 511	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   501: bipush 112
    //   503: invokevirtual 517	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   506: checkcast 686	alov
    //   509: invokevirtual 689	alov:a	()Ljava/util/ArrayList;
    //   512: invokespecial 293	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:a	(Ljava/util/ArrayList;)V
    //   515: aload_0
    //   516: invokespecial 1579	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:c	()V
    //   519: aload_1
    //   520: ldc_w 1709
    //   523: iconst_0
    //   524: invokevirtual 206	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   527: istore_2
    //   528: iload_2
    //   529: ifle +41 -> 570
    //   532: invokestatic 542	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   535: ifeq +30 -> 565
    //   538: ldc_w 544
    //   541: iconst_2
    //   542: new 669	java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial 670	java/lang/StringBuilder:<init>	()V
    //   549: ldc_w 1711
    //   552: invokevirtual 676	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: iload_2
    //   556: invokevirtual 728	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   559: invokevirtual 680	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   562: invokestatic 559	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   565: aload_0
    //   566: iload_2
    //   567: invokespecial 1712	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:c	(I)V
    //   570: aload_0
    //   571: getfield 511	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   574: ldc_w 723
    //   577: ldc 117
    //   579: ldc 117
    //   581: ldc_w 1714
    //   584: ldc_w 1714
    //   587: iconst_0
    //   588: iconst_0
    //   589: ldc 117
    //   591: ldc 117
    //   593: ldc 117
    //   595: ldc 117
    //   597: invokestatic 733	awqx:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   600: iconst_1
    //   601: ireturn
    //   602: astore_1
    //   603: aload_1
    //   604: invokevirtual 1717	java/lang/Exception:printStackTrace	()V
    //   607: aload_0
    //   608: invokevirtual 1014	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:finish	()V
    //   611: iconst_0
    //   612: ireturn
    //   613: astore_3
    //   614: aload_3
    //   615: invokevirtual 1718	org/json/JSONException:printStackTrace	()V
    //   618: ldc_w 544
    //   621: iconst_1
    //   622: aload_3
    //   623: invokevirtual 1721	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   626: invokestatic 559	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   629: goto -440 -> 189
    //   632: iload_2
    //   633: sipush 320
    //   636: if_icmpgt +12 -> 648
    //   639: aload_0
    //   640: bipush 100
    //   642: putfield 616	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_l_of_type_Int	I
    //   645: goto -248 -> 397
    //   648: aload_0
    //   649: sipush 160
    //   652: putfield 616	com/tencent/mobileqq/activity/FriendProfileMoreInfoActivity:jdField_l_of_type_Int	I
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
    if (this.jdField_a_of_type_Bbma != null)
    {
      this.jdField_a_of_type_Bbma.a();
      this.jdField_a_of_type_Bbma = null;
    }
    if (this.jdField_a_of_type_Aaxd != null)
    {
      this.jdField_a_of_type_Aaxd.a();
      this.jdField_a_of_type_Aaxd = null;
    }
    if (!this.jdField_b_of_type_Boolean) {
      removeObserver(this.jdField_a_of_type_Ajfo);
    }
    removeObserver(this.jdField_a_of_type_Ajjh);
    this.app.unRegistObserver(this.jdField_a_of_type_Alow);
    this.jdField_a_of_type_Ajfw.b(this);
    this.jdField_a_of_type_Ajfw.d(this.jdField_a_of_type_Ajga);
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
    if ((localArrayList != null) && (localArrayList.size() > 0) && (this.jdField_a_of_type_Aaxd != null)) {
      this.jdField_a_of_type_Aaxd.a(paramIntent, localArrayList);
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
      str1 = getString(2131629725);
      bool = true;
    }
    a(this.jdField_j_of_type_AndroidWidgetTextView, str1, bool);
    paramString = this.jdField_l_of_type_AndroidViewView;
    TextView localTextView = this.jdField_j_of_type_AndroidWidgetTextView;
    String str2 = getString(2131629726);
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
    this.jdField_d_of_type_AndroidWidgetEditText.setHint(2131629717);
    a(this.jdField_m_of_type_AndroidViewView, this.jdField_d_of_type_AndroidWidgetEditText, getString(2131629718), str);
  }
  
  public void finish()
  {
    Intent localIntent = new Intent();
    if (a()) {
      localIntent.putExtra("param_switches_changed", true);
    }
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      localIntent.putExtra("result", this.jdField_a_of_type_AndroidOsBundle);
    }
    if ((this.jdField_a_of_type_Aaxd != null) && (this.jdField_a_of_type_Aaxd.jdField_a_of_type_Boolean))
    {
      localIntent.putExtra("is_set_cover", true);
      localIntent.putExtra("cover_data", this.jdField_a_of_type_Aaxd.jdField_a_of_type_ArrayOfByte);
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
    for (String str1 = getString(2131629754);; str1 = paramString)
    {
      a(this.jdField_k_of_type_AndroidWidgetTextView, str1, TextUtils.isEmpty(paramString));
      paramString = this.jdField_n_of_type_AndroidViewView;
      TextView localTextView = this.jdField_k_of_type_AndroidWidgetTextView;
      String str2 = getString(2131629755);
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
          k();
          bbmy.a(this, 2131625456, 0).b(getTitleBarHeight());
          return true;
          a(paramMessage);
          a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Bble.jdField_b_of_type_Int);
          this.jdField_k_of_type_Int = 0;
          try
          {
            long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_Ajfi.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, "");
            this.jdField_a_of_type_Ajfi.a(l1, this.jdField_a_of_type_Ajfn);
            return true;
          }
          catch (Exception paramMessage) {}
        } while (!QLog.isColorLevel());
        QLog.e("FriendProfileMoreInfoActivity", 2, "handleMessage MSG_LOAD_PHOTO_WALL_FROM_DATABASE fail!", paramMessage);
        return true;
        this.jdField_k_of_type_Int |= 0x1;
        a(paramMessage);
      } while (this.jdField_k_of_type_Int != 17);
      a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Bble.jdField_b_of_type_Int);
      return true;
      this.jdField_k_of_type_Int |= 0x10;
      a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_b_of_type_JavaUtilArrayList);
    } while (this.jdField_k_of_type_Int != 17);
    a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Bble.jdField_b_of_type_Int);
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
    label799:
    do
    {
      do
      {
        do
        {
          try
          {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.requestFocus();
            switch (paramView.getId())
            {
            default: 
              return;
            }
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              QLog.e("FriendProfileMoreInfoActivity", 1, "onClick fail.", localThrowable);
            }
            e();
            return;
          }
          paramView = new Intent(paramView.getContext(), QQBrowserActivity.class);
          paramView.putExtra("hide_more_button", true);
          paramView.putExtra("hide_operation_bar", true);
          paramView.putExtra("url", "http://ti.qq.com/photowall/index.html?_wv=1027");
          paramView.putExtra("leftViewText", getString(2131624770));
          startActivityForResult(paramView, 1001);
          awqx.b(this.app, "dc00898", "", "", "0X8007EC4", "0X8007EC4", 0, 0, "", "", "", "");
          return;
          paramView = new Intent(this, AvatarPendantActivity.class);
          paramView.putExtra("AllInOne", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
          paramView.putExtra("showActionSheet", true);
          startActivity(paramView);
          awqx.b(this.app, "dc00898", "", "", "0X8007EC5", "0X8007EC5", 0, 0, "", "", "", "");
          return;
          g();
          awqx.b(this.app, "dc00898", "", "", "0X8007EC6", "0X8007EC6", 0, 0, "", "", "", "");
          return;
          h();
          return;
          paramView = ((TroopManager)this.app.getManager(52)).b(this.jdField_a_of_type_JavaLangString);
        } while (paramView == null);
        if ((paramView.isTroopAdmin(this.app.getCurrentAccountUin())) || (paramView.isTroopOwner(this.app.getCurrentAccountUin())) || (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app.getCurrentAccountUin())))
        {
          a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 1011);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("FriendProfileMoreInfoActivity", 2, "openModifyNickNamePage right invalidate-----------");
      return;
      paramView = new Intent(this, AgeSelectionActivity.class);
      paramView.putExtra("param_birthday", this.jdField_b_of_type_Int);
      startActivityForResult(paramView, 1003);
      return;
      paramView = new Intent(this, JobSelectionActivity.class);
      paramView.putExtra("param_id", this.jdField_e_of_type_Int);
      startActivityForResult(paramView, 1004);
      return;
      d(1);
      return;
      d(2);
      return;
      paramView = new Intent(this, EditActivity.class);
      paramView.putExtra("title", 2131629755).putExtra("limit", 383).putExtra("canPostNull", true).putExtra("hint", 2131629754).putExtra("multiLine", true).putExtra("current", this.jdField_e_of_type_JavaLangString).putExtra("action", 104).putExtra("key_title_style", 0).putExtra("key_hide_clear_btn", true).putExtra("key_null_bg", true).putExtra("key_simple_count_style", true);
      startActivityForResult(paramView, 1007);
      return;
      i();
      awqx.b(this.app, "dc00898", "", "", "0X8007ED1", "0X8007ED1", 0, 0, "", "", "", "");
      return;
      if (this.jdField_a_of_type_Aaxd != null)
      {
        paramView = this.jdField_a_of_type_Aaxd;
        if (this.jdField_a_of_type_Aaxd.jdField_a_of_type_Int != 0) {
          break label799;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        paramView.a(bool);
        awqx.b(this.app, "dc00898", "", "", "0X8009C0E", "0X8009C0E", 0, 0, "", "", "", "");
        return;
      }
      if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 0)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        baig.t(this, this.app.getCurrentAccountUin(), true);
      }
      atxk.a(this.app, this, this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      return;
      b(1);
      h(String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", new Object[] { Integer.valueOf(3) }));
      return;
      b(2);
      h(String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", new Object[] { Integer.valueOf(2) }));
      return;
      b(3);
      h(String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", new Object[] { Integer.valueOf(1) }));
      return;
      b(4);
      d();
      return;
      awqx.b(this.app, "dc00898", "", "", "0X800A0D6", "0X800A0D6", 0, 0, "", "", "", "");
      if ((paramView.getTag() instanceof atxp))
      {
        paramView = (atxp)paramView.getTag();
        h(String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994&idx=%d", new Object[] { Integer.valueOf(paramView.jdField_b_of_type_Int), Integer.valueOf(paramView.jdField_a_of_type_Int) }));
        return;
      }
    } while (!(paramView.getTag() instanceof Card));
    h("https://ti.qq.com/hybrid-h5/school_relation/chooseschool?_wv=67108994");
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (paramView != this.jdField_a_of_type_AndroidWidgetEditText) {
        break label70;
      }
      if (this.jdField_a_of_type_Aaxc.jdField_b_of_type_Boolean)
      {
        paramView = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
        if ((!TextUtils.isEmpty(paramView)) && (!TextUtils.isEmpty(paramView.trim()))) {}
      }
    }
    label70:
    Matcher localMatcher;
    do
    {
      bbmy.a(this, ajjy.a(2131639096), 0).b(getTitleBarHeight());
      do
      {
        return;
      } while ((paramView != this.jdField_d_of_type_AndroidWidgetEditText) || (!this.jdField_d_of_type_Aaxc.jdField_b_of_type_Boolean));
      paramView = this.jdField_d_of_type_AndroidWidgetEditText.getText().toString();
      localMatcher = SearchBaseActivity.a.matcher(paramView);
    } while ((TextUtils.isEmpty(paramView)) || (localMatcher.matches()));
    bbmy.a(this, ajjy.a(2131639120), 0).b(getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity
 * JD-Core Version:    0.7.0.1
 */