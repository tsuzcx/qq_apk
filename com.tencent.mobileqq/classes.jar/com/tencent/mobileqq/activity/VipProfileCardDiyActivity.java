package com.tencent.mobileqq.activity;

import acpn;
import acpo;
import acpp;
import acpq;
import acpr;
import acps;
import acpt;
import acpu;
import acpv;
import acpw;
import acpy;
import actn;
import ajtq;
import ajxn;
import ajyc;
import android.annotation.TargetApi;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import aqxh;
import auux;
import auvd;
import auwo;
import auwp;
import auyj;
import auyn;
import auyo;
import auzb;
import aval;
import avam;
import ayla;
import bazo;
import bbcv;
import bbgg;
import bbqs;
import bbqw;
import bcpq;
import bcpw;
import bfmr;
import bfnk;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.diy.DiyTextView;
import com.tencent.mobileqq.profile.view.HScrollView;
import com.tencent.mobileqq.profile.view.SingleTouchLayout;
import com.tencent.mobileqq.profile.view.SoftInputDetectView;
import com.tencent.mobileqq.profile.view.VerticalSeekBar;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.data.UpsImageUploadResult;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import nam;

public class VipProfileCardDiyActivity
  extends BaseActivity
  implements Handler.Callback, TextWatcher, View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener, SeekBar.OnSeekBarChangeListener, auzb, aval, avam
{
  public static final String a;
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  public long a;
  acpy jdField_a_of_type_Acpy = new acpq(this);
  ajtq jdField_a_of_type_Ajtq = new acpr(this);
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new acps(this);
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  Resources jdField_a_of_type_AndroidContentResResources;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  aqxh jdField_a_of_type_Aqxh;
  bbgg jdField_a_of_type_Bbgg;
  bcpq jdField_a_of_type_Bcpq;
  public bfnk a;
  VipProfileCardDiyActivity.DiyDefaultTextView jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView;
  VipProfileCardDiyActivity.HiBoomTemplateView jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView;
  Card jdField_a_of_type_ComTencentMobileqqDataCard;
  DiyTextView jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView;
  HScrollView jdField_a_of_type_ComTencentMobileqqProfileViewHScrollView;
  public SingleTouchLayout a;
  SoftInputDetectView jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView;
  VerticalSeekBar jdField_a_of_type_ComTencentMobileqqProfileViewVerticalSeekBar;
  VasQuickUpdateManager.CallBacker jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new acpn(this);
  public VasQuickUpdateManager a;
  AvatarLayout jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout;
  VoteView jdField_a_of_type_ComTencentMobileqqWidgetVoteView;
  ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  public HashMap<String, String> a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public boolean a;
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int = 1;
  DialogInterface.OnClickListener jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new acpt(this);
  Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  bbgg jdField_b_of_type_Bbgg;
  bcpq jdField_b_of_type_Bcpq;
  VipProfileCardDiyActivity.HiBoomTemplateView jdField_b_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView;
  public String b;
  public AtomicBoolean b;
  boolean jdField_b_of_type_Boolean;
  float jdField_c_of_type_Float;
  int jdField_c_of_type_Int;
  DialogInterface.OnClickListener jdField_c_of_type_AndroidContentDialogInterface$OnClickListener = new acpu(this);
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = false;
  float jdField_d_of_type_Float;
  int jdField_d_of_type_Int;
  DialogInterface.OnClickListener jdField_d_of_type_AndroidContentDialogInterface$OnClickListener = new acpv(this);
  TextView jdField_d_of_type_AndroidWidgetTextView;
  public String d;
  volatile boolean jdField_d_of_type_Boolean = false;
  int jdField_e_of_type_Int;
  DialogInterface.OnClickListener jdField_e_of_type_AndroidContentDialogInterface$OnClickListener = new acpw(this);
  TextView jdField_e_of_type_AndroidWidgetTextView;
  String jdField_e_of_type_JavaLangString;
  int jdField_f_of_type_Int = -1;
  DialogInterface.OnClickListener jdField_f_of_type_AndroidContentDialogInterface$OnClickListener = new acpo(this);
  TextView jdField_f_of_type_AndroidWidgetTextView;
  public String f;
  int jdField_g_of_type_Int;
  TextView jdField_g_of_type_AndroidWidgetTextView;
  public String g;
  int h;
  int i;
  public int j;
  int k;
  public int l;
  int m = 30000;
  public int n = 2;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajyc.a(2131716767);
  }
  
  public VipProfileCardDiyActivity()
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static boolean a(int paramInt)
  {
    File localFile = new File(auwo.jdField_a_of_type_JavaLangString + paramInt);
    if ((localFile.exists()) && (localFile.isDirectory())) {}
    for (String[] arrayOfString = localFile.list(); (localFile.exists()) && (arrayOfString != null) && (arrayOfString.length > 0); arrayOfString = null) {
      return true;
    }
    return false;
  }
  
  public static boolean a(long paramLong, String paramString, int paramInt)
  {
    if ((5L == paramLong) && (paramString.startsWith("font.diycard.android."))) {
      return String.valueOf(paramInt).equals(paramString.substring("font.diycard.android.".length(), paramString.length()));
    }
    return false;
  }
  
  int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i1 = 1;
    int i2 = 1;
    int i4 = i2;
    if (paramInt1 != 0)
    {
      i4 = i2;
      if (paramInt2 != 0)
      {
        i4 = i2;
        if (paramInt1 != -1)
        {
          if (paramInt2 != -1) {
            break label43;
          }
          i4 = i2;
        }
      }
    }
    label43:
    int i3;
    label55:
    do
    {
      do
      {
        return i4;
        i2 = paramOptions.outHeight;
        i3 = paramOptions.outWidth;
        i4 = i1;
      } while (i2 <= paramInt2);
      i4 = i1;
    } while (i3 <= paramInt1);
    int i5 = Math.round(i2 / paramInt2);
    i4 = Math.round(i3 / paramInt1);
    if (i5 > i4) {}
    for (;;)
    {
      i4 = i1;
      if (i5 < 2) {
        break;
      }
      i3 /= 2;
      i2 /= 2;
      i1 *= 2;
      break label55;
      i5 = i4;
    }
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView.getText().toString();
  }
  
  void a()
  {
    Intent localIntent = getIntent();
    this.jdField_g_of_type_Int = localIntent.getIntExtra("extra_from", -1);
    this.jdField_a_of_type_Long = localIntent.getLongExtra("extra_card_id", -1L);
    if (this.jdField_a_of_type_Long == -1L) {
      finish();
    }
    this.jdField_b_of_type_JavaLangString = localIntent.getStringExtra("extra_card_url");
    this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("extra_card_default_text");
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      this.jdField_c_of_type_JavaLangString = jdField_a_of_type_JavaLangString;
    }
    this.jdField_d_of_type_JavaLangString = localIntent.getStringExtra("extra_card_path");
    label141:
    int i1;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.diyText))
    {
      this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataCard.diyText;
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextFontId <= 0) {
        break label297;
      }
      this.h = this.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextFontId;
      if ((this.jdField_a_of_type_Long == 0L) || (this.jdField_a_of_type_Long != this.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId)) {
        break label312;
      }
      i1 = 1;
      label167:
      if ((i1 == 0) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.diyText))) {
        break label317;
      }
      this.jdField_a_of_type_Float = (this.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextLocX * this.jdField_d_of_type_Int);
      this.jdField_b_of_type_Float = (this.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextLocY * this.jdField_e_of_type_Int);
      this.jdField_c_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextScale;
      this.jdField_d_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextDegree;
      this.i = ((int)(this.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextTransparency * 255.0F));
      label256:
      if (this.i >= -77) {
        break label389;
      }
      this.i = -77;
    }
    for (;;)
    {
      this.i += 77;
      return;
      this.jdField_e_of_type_JavaLangString = localIntent.getStringExtra("extra_card_text");
      break;
      label297:
      this.h = localIntent.getIntExtra("extra_card_font", -1);
      break label141;
      label312:
      i1 = 0;
      break label167;
      label317:
      this.jdField_a_of_type_Float = localIntent.getFloatExtra("extra_card_x", 1.4E-45F);
      this.jdField_b_of_type_Float = localIntent.getFloatExtra("extra_card_y", 1.4E-45F);
      this.jdField_c_of_type_Float = localIntent.getFloatExtra("extra_card_scale", 1.0F);
      this.jdField_d_of_type_Float = localIntent.getFloatExtra("extra_card_rotation", 0.0F);
      this.i = ((int)(localIntent.getFloatExtra("extra_card_transparency", 0.0F) * 255.0F));
      break label256;
      label389:
      if (this.i > 77) {
        this.i = 77;
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 1) {
      VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X8008115", "", 1, 0, 0, nam.a(), "", "");
    }
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    i();
    h();
    if ((!this.jdField_d_of_type_Boolean) && (!isFinishing()))
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView != null) && (paramBoolean)) {
        break label91;
      }
      bazo.a(this.app, paramLong1, paramLong2);
      this.jdField_f_of_type_JavaLangString = a();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView != null) {
        break label266;
      }
    }
    label266:
    for (int i1 = 0;; i1 = this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_a_of_type_Int)
    {
      this.j = i1;
      this.jdField_a_of_type_Bfnk.sendEmptyMessageDelayed(6, this.m);
      return;
      label91:
      i1 = this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_a_of_type_Int;
      String str = a();
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.a();
      localObject = String.format("%s_%s_%s_%s", new Object[] { Float.valueOf(((PointF)localObject).x / this.jdField_d_of_type_Int), Float.valueOf(((PointF)localObject).y / this.jdField_e_of_type_Int), Float.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.o / this.jdField_d_of_type_Int), Float.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.p / this.jdField_e_of_type_Int) });
      float f1 = this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.a();
      float f2 = this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.b();
      float f3 = (this.jdField_a_of_type_ComTencentMobileqqProfileViewVerticalSeekBar.a() - 77) / 255.0F;
      bazo.a(this.app, paramLong1, paramLong2, null, 0L, null, i1, str, (String)localObject, f1, f2, f3, "", 0L);
      break;
    }
  }
  
  @TargetApi(11)
  public void a(View paramView)
  {
    if (this.jdField_b_of_type_Int == 2) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    bfmr.a(this.jdField_a_of_type_AndroidWidgetEditText);
    c();
  }
  
  public void a(View paramView, float paramFloat)
  {
    c();
    String str = nam.a();
    if (paramFloat > 1.0F) {}
    for (paramView = "0";; paramView = "1")
    {
      VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X8008111", "", 1, 0, 0, str, paramView, "");
      return;
    }
  }
  
  public void a(View paramView, float paramFloat1, float paramFloat2)
  {
    c();
    VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X8008110", "", 1, 0, 0, nam.a(), "", "");
  }
  
  void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setText(paramString);
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramString.length());
    }
  }
  
  public void a(String paramString, UpsImageUploadResult paramUpsImageUploadResult, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipProfileCardDiyActivity", 2, "url from UPS:" + paramUpsImageUploadResult.url);
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramUpsImageUploadResult.url);
    a(paramString, paramUpsImageUploadResult.url, paramBoolean);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    h();
    long l1 = auvd.g;
    if ((!this.jdField_d_of_type_Boolean) && (!isFinishing()))
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView != null) && (paramBoolean)) {
        break label86;
      }
      bazo.a(this.app, l1, 160L, paramString2, bazo.a(paramString1), null);
      this.jdField_f_of_type_JavaLangString = a();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView != null) {
        break label294;
      }
    }
    label294:
    for (int i1 = 0;; i1 = this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_a_of_type_Int)
    {
      this.j = i1;
      return;
      label86:
      int i2 = this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_a_of_type_Int;
      String str = a();
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.a();
      localObject = String.format("%s_%s_%s_%s", new Object[] { Float.valueOf(((PointF)localObject).x / this.jdField_d_of_type_Int), Float.valueOf(((PointF)localObject).y / this.jdField_e_of_type_Int), Float.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.o / this.jdField_d_of_type_Int), Float.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.p / this.jdField_e_of_type_Int) });
      float f1 = this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.a();
      float f2 = this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.b();
      float f3 = (this.jdField_a_of_type_ComTencentMobileqqProfileViewVerticalSeekBar.a() - 77) / 255.0F;
      if ((TextUtils.isEmpty(str)) || (i2 == 0)) {}
      for (i1 = 160;; i1 = 1600)
      {
        bazo.a(this.app, l1, i1, paramString2, bazo.a(paramString1), null, i2, str, (String)localObject, f1, f2, f3, "", 0L);
        break;
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("VipProfileCardDiyActivity", 1, "uploadBackgroundToUps filePath is empty");
      return;
    }
    acpp localacpp = new acpp(this, Long.parseLong(this.app.getCurrentAccountUin()), paramString, auyj.a(this.app), "qqprofile", paramString, paramBoolean);
    localacpp.a = auyj.a(this.app);
    localacpp.i = auyj.a(this.app, paramString);
    j();
    paramString = (auyo)this.app.getManager(90);
    paramString.a(this.app, null);
    localacpp.a();
    paramString.a(this.app, localacpp, null);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetEditText.getLayoutParams();
      localLayoutParams.bottomMargin = paramInt;
      this.jdField_a_of_type_AndroidWidgetEditText.setLayoutParams(localLayoutParams);
      VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X8008112", "", 1, 0, 0, "", "", "");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
  }
  
  boolean a()
  {
    return true;
  }
  
  boolean a(long paramLong, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    ajxn localajxn = (ajxn)this.app.getManager(51);
    Card localCard = localajxn.b(this.app.getCurrentAccountUin());
    if ((localCard != null) && (paramLong >= 0L))
    {
      localCard.lCurrentStyleId = paramLong;
      localCard.lCurrentBgId = paramInt1;
      localCard.strCurrentBgUrl = paramString;
      localCard.backgroundColor = paramInt2;
      localCard.templateRet = paramInt3;
      if (!localajxn.a(localCard))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("VipProfileCardDiyActivity", 4, "save card in db failed ");
        }
        return false;
      }
      return true;
    }
    return false;
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  @TargetApi(11)
  void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView = ((SoftInputDetectView)findViewById(2131375491));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)findViewById(2131377439));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368429));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368457));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371974));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376953));
    this.jdField_a_of_type_ComTencentMobileqqProfileViewHScrollView = ((HScrollView)findViewById(2131376951));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365403));
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout = ((SingleTouchLayout)findViewById(2131365404));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131365398));
    this.jdField_a_of_type_ComTencentMobileqqProfileViewVerticalSeekBar = ((VerticalSeekBar)findViewById(2131369175));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131369804);
    this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView = new DiyTextView(this);
    this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView.setBackgroundColor(0);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.a(this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView);
    int i1 = actn.a(10.0F, this.jdField_a_of_type_AndroidContentResResources);
    this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView = new VipProfileCardDiyActivity.DiyDefaultTextView(this, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView.setTextColor(-1);
    this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView.setTextSize(18.0F);
    this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView.setPadding(i1, i1, i1, i1);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131375933));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365397));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131371912);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)findViewById(2131368093));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368111));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368105));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368103));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368104));
    this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView = ((VoteView)findViewById(2131379323));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(0, this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.findViewById(2131363080), false);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.a(0);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewHScrollView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewVerticalSeekBar.setOnSeekBarChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewVerticalSeekBar.setMaxProgress(154);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewVerticalSeekBar.setProgress(this.i);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.a = this;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(auwp.jdField_a_of_type_Int) });
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(this);
    this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView.setOnMeasuredListener(this.jdField_a_of_type_Acpy);
    SoftInputDetectView localSoftInputDetectView = this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView;
    if (ImmersiveUtils.isSupporImmersive() != 1) {}
    for (boolean bool = true;; bool = false)
    {
      localSoftInputDetectView.setExcludeStatusBar(bool);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView.setOnImStateChangedListener(this);
      if ((this.jdField_a_of_type_Float > 1.4E-45F) && (this.jdField_b_of_type_Float > 1.4E-45F)) {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setCenterPoint(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setImageScale(this.jdField_c_of_type_Float);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setImageDegree(this.jdField_d_of_type_Float);
      return;
    }
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 2)
    {
      bbqw.a(this.app, this, "mvip.g.a.mp_wz", 3, "1450000516", "CJCLUBT", getString(2131719964), "svipdiyCardH5Pay");
      return;
    }
    bbqw.a(this.app, this, "mvip.g.a.mp_wz", 3, "1450000515", "LTMCLUB", getString(2131695432), "vipdiyCardH5Pay");
  }
  
  public void b(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setVisibility(8);
    this.jdField_a_of_type_Boolean = true;
    a("");
    c();
    VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X800810F", "", 1, 0, 0, nam.a(), "", "");
  }
  
  void b(String paramString)
  {
    l();
    int i2;
    boolean bool;
    String str;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView != null) && (!TextUtils.isEmpty(a())))
    {
      i2 = 1;
      bool = VipUtils.b(this.app);
      str = getString(2131695374);
      if (!TextUtils.isEmpty(paramString)) {
        break label309;
      }
      if ((this.jdField_a_of_type_Long != 0L) && (this.jdField_a_of_type_Long != 160L) && (this.jdField_a_of_type_Long != 1600L)) {
        break label236;
      }
      if (i2 == 0) {
        break label225;
      }
      if (!bool) {
        break label214;
      }
      paramString = getString(2131695372);
    }
    label143:
    label278:
    label302:
    label309:
    for (;;)
    {
      label96:
      int i3;
      label126:
      int i1;
      if (((this.jdField_a_of_type_Long == 0L) || (this.jdField_a_of_type_Long == 160L)) && (bool))
      {
        i3 = 2131695393;
        if (this.n != 2) {
          break label278;
        }
        if (!bool) {
          break label271;
        }
        i1 = 2131695389;
        this.jdField_a_of_type_Bbgg = bbcv.a(this, 0, str, paramString, i3, i1, this.jdField_d_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_c_of_type_AndroidContentDialogInterface$OnClickListener);
        this.jdField_a_of_type_Bbgg.show();
        if (i2 != 0) {
          if (!bool) {
            break label302;
          }
        }
      }
      for (paramString = "4";; paramString = "3")
      {
        VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X80081C9", "", 1, 0, 0, nam.a(), paramString, "");
        return;
        i2 = 0;
        break;
        label214:
        paramString = getString(2131695370);
        break label96;
        label225:
        paramString = getString(2131695371);
        break label96;
        label236:
        if (bool)
        {
          paramString = getString(2131695373);
          break label96;
        }
        paramString = getString(2131695370);
        break label96;
        i3 = 2131690596;
        break label126;
        i1 = 2131695386;
        break label143;
        if (VipUtils.c(this.app))
        {
          i1 = 2131695390;
          break label143;
        }
        i1 = 2131695387;
        break label143;
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  void c()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  public void c(String paramString)
  {
    ThreadManager.executeOnFileThread(new VipProfileCardDiyActivity.11(this, paramString));
  }
  
  void d()
  {
    int i2 = 0;
    Object localObject1;
    Object localObject2;
    if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
    {
      localObject1 = auux.a(this, auvd.n, this.jdField_a_of_type_Long);
      localObject2 = new File((String)localObject1);
      if ((!((File)localObject2).isFile()) || (!((File)localObject2).exists())) {
        break label577;
      }
      c((String)localObject1);
    }
    label391:
    label523:
    label576:
    label577:
    for (int i1 = 0;; i1 = 1)
    {
      if (i1 != 0)
      {
        localObject2 = ((bbqs)this.app.getManager(235)).a;
        this.jdField_g_of_type_JavaLangString = ((String)localObject1);
        ((auux)localObject2).a(this.app, "card." + this.jdField_a_of_type_Long);
      }
      localObject1 = new LinearLayout.LayoutParams(actn.a(86.0F, this.jdField_a_of_type_AndroidContentResResources), actn.a(123.0F, this.jdField_a_of_type_AndroidContentResResources));
      ((LinearLayout.LayoutParams)localObject1).setMargins(0, actn.a(12.0F, this.jdField_a_of_type_AndroidContentResResources), actn.a(5.0F, this.jdField_a_of_type_AndroidContentResResources), actn.a(10.0F, this.jdField_a_of_type_AndroidContentResResources));
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      SparseArray localSparseArray = auwp.jdField_a_of_type_AndroidUtilSparseArray;
      if (localSparseArray == null)
      {
        auwp.a(this.app);
        this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView);
        f();
      }
      if ((localSparseArray != null) && (localSparseArray.size() > 0))
      {
        this.jdField_f_of_type_Int = this.h;
        if ((this.jdField_f_of_type_Int <= 0) || (localSparseArray.indexOfKey(this.jdField_f_of_type_Int) < 0)) {
          this.jdField_f_of_type_Int = localSparseArray.keyAt(0);
        }
        Object localObject3 = (String)localSparseArray.get(this.jdField_f_of_type_Int);
        boolean bool = a(this.jdField_f_of_type_Int);
        this.jdField_b_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView = new VipProfileCardDiyActivity.HiBoomTemplateView(this, this, this.jdField_f_of_type_Int, bool);
        localObject3 = URLDrawable.getDrawable((String)localObject3, (URLDrawable.URLDrawableOptions)localObject2);
        this.jdField_b_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.setImageDrawable((Drawable)localObject3);
        if ((this.jdField_a_of_type_Long == 0L) || ((TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (this.jdField_g_of_type_Int == 1)))
        {
          this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setVisibility(8);
          this.jdField_a_of_type_Boolean = true;
          e();
          label376:
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView, (ViewGroup.LayoutParams)localObject1);
          i1 = i2;
          if (i1 >= localSparseArray.size()) {
            break label576;
          }
          i2 = localSparseArray.keyAt(i1);
          if (i2 != this.jdField_f_of_type_Int) {
            break label523;
          }
        }
        for (;;)
        {
          i1 += 1;
          break label391;
          c(this.jdField_d_of_type_JavaLangString);
          break;
          this.jdField_b_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.setChecked(true);
          this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView = this.jdField_b_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView;
          this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView.setHiBoom(this.jdField_f_of_type_Int, 1, aqxh.b);
          if (!bool) {}
          for (bool = true;; bool = false)
          {
            this.jdField_b_of_type_Boolean = bool;
            if (this.jdField_b_of_type_Boolean) {
              this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_b_of_type_Int = 1;
            }
            if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
              break label516;
            }
            a(this.jdField_e_of_type_JavaLangString);
            break;
          }
          e();
          break label376;
          localObject3 = (String)localSparseArray.get(i2);
          VipProfileCardDiyActivity.HiBoomTemplateView localHiBoomTemplateView = new VipProfileCardDiyActivity.HiBoomTemplateView(this, this, i2, a(i2));
          localHiBoomTemplateView.setImageDrawable(URLDrawable.getDrawable((String)localObject3, (URLDrawable.URLDrawableOptions)localObject2));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localHiBoomTemplateView, (ViewGroup.LayoutParams)localObject1);
        }
      }
      return;
    }
  }
  
  public void doOnBackPressed()
  {
    onClick(this.jdField_a_of_type_AndroidWidgetTextView);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    super.setContentView(2131560967);
    this.jdField_a_of_type_AndroidContentSharedPreferences = getSharedPreferences("vip_profile_diy_card", 0);
    this.jdField_a_of_type_ComTencentMobileqqDataCard = bazo.a(this.app, this.app.getCurrentAccountUin());
    this.jdField_a_of_type_AndroidContentResResources = super.getResources();
    paramBundle = this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics();
    this.jdField_d_of_type_Int = paramBundle.widthPixels;
    this.jdField_e_of_type_Int = paramBundle.heightPixels;
    this.jdField_a_of_type_Int = actn.a(130.0F, this.jdField_a_of_type_AndroidContentResResources);
    a();
    this.jdField_c_of_type_Int = actn.a(5.0F, this.jdField_a_of_type_AndroidContentResResources);
    this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager = ((VasQuickUpdateManager)this.app.getManager(184));
    this.jdField_a_of_type_Aqxh = ((aqxh)this.app.getManager(219));
    this.jdField_a_of_type_Bfnk = new bfnk(Looper.getMainLooper(), this);
    addObserver(this.jdField_a_of_type_Ajtq);
    b();
    ((VasQuickUpdateManager)this.app.getManager(184)).addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
    d();
    VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X800810D", "", 1, 0, 0, nam.a(), "", String.valueOf(this.jdField_a_of_type_Long));
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_Bfnk.removeCallbacks(null);
    removeObserver(this.jdField_a_of_type_Ajtq);
    i();
    k();
    ((VasQuickUpdateManager)this.app.getManager(184)).removeCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
  }
  
  @TargetApi(9)
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("vip_diy_card_guide_shown", false)) {
        break label179;
      }
      if (this.jdField_a_of_type_AndroidWidgetPopupWindow == null)
      {
        localView = getLayoutInflater().inflate(2131560966, null);
        localButton = (Button)localView.findViewById(2131363574);
        this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131367265));
        this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131367256));
        localButton.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(localView, -1, -1);
        this.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(true);
        this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new BitmapDrawable());
      }
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (this.jdField_b_of_type_AndroidGraphicsBitmap != null)) {
          break label168;
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        ThreadManager.executeOnFileThread(new VipProfileCardDiyActivity.2(this));
      }
    }
    label168:
    label179:
    while (this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("vip_diy_card_edit_guide_shown", false))
    {
      View localView;
      Button localButton;
      return;
      this.jdField_a_of_type_Bfnk.sendEmptyMessage(9);
      return;
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Long == 0L) || (this.jdField_a_of_type_Long == 160L) || (this.jdField_a_of_type_Long == 1600L)) {
      a(auwp.jdField_a_of_type_JavaLangString);
    }
    while (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      return;
    }
    a(this.jdField_c_of_type_JavaLangString);
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.a();
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.invalidate();
  }
  
  void g()
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    long l1;
    String str;
    do
    {
      do
      {
        return;
        l1 = auvd.g;
        if (this.jdField_a_of_type_Long != 0L) {
          break;
        }
      } while (!a());
      str = (String)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_d_of_type_JavaLangString);
      if (!TextUtils.isEmpty(str))
      {
        a(this.jdField_d_of_type_JavaLangString, str, true);
        return;
      }
      a(this.jdField_d_of_type_JavaLangString, true);
      return;
      if ((this.jdField_a_of_type_Long != 160L) && (this.jdField_a_of_type_Long != 1600L)) {
        break;
      }
    } while ((!a()) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)));
    a(auux.a(this, auvd.n, this.jdField_a_of_type_Long), this.jdField_b_of_type_JavaLangString, true);
    return;
    if (TextUtils.isEmpty(a()))
    {
      o();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView == null) {}
      for (str = "";; str = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_a_of_type_Int))
      {
        VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X80081C2", "", 1, 0, 0, "", "1", str);
        return;
      }
    }
    a(l1, this.jdField_a_of_type_Long, true);
  }
  
  void h()
  {
    try
    {
      if (!isFinishing())
      {
        this.jdField_a_of_type_Bcpq = new bcpq(this, getTitleBarHeight());
        this.jdField_a_of_type_Bcpq.setCancelable(false);
        this.jdField_a_of_type_Bcpq.c(2131695478);
        this.jdField_a_of_type_Bcpq.show();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  @TargetApi(9)
  public boolean handleMessage(Message paramMessage)
  {
    if ((isFinishing()) || (this.jdField_d_of_type_Boolean)) {}
    do
    {
      do
      {
        return false;
        switch (paramMessage.what)
        {
        default: 
          return false;
        case 0: 
          paramMessage = new Intent(this, FriendProfileCardActivity.class);
          if (this.jdField_g_of_type_Int == 1) {
            setResult(-1, paramMessage);
          }
        case 3: 
          for (;;)
          {
            finish();
            return false;
            this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
            return false;
            paramMessage.putExtra("AllInOne", new ProfileActivity.AllInOne(this.app.getCurrentAccountUin(), 0));
            paramMessage.putExtra("diyTextEditResult", true);
            startActivity(paramMessage);
          }
        case 1: 
          if (!TextUtils.isEmpty((String)paramMessage.obj))
          {
            bcpw.a(this, (String)paramMessage.obj, 0).a();
            return false;
          }
          bcpw.a(this, 2131695394, 0).a();
          return false;
        case 2: 
          b((String)paramMessage.obj);
          return false;
        case 4: 
          localObject = (View)paramMessage.obj;
        }
      } while (localObject == null);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
      localLayoutParams.bottomMargin = paramMessage.arg1;
      ((View)localObject).setLayoutParams(localLayoutParams);
      return false;
      localObject = (View)paramMessage.obj;
      if (paramMessage.arg1 != 0) {
        break;
      }
    } while (localObject == null);
    ((View)localObject).setVisibility(8);
    return false;
    if (localObject != null)
    {
      paramMessage = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
      paramMessage.bottomMargin = 0;
      ((View)localObject).setLayoutParams(paramMessage);
    }
    bcpw.a(this, 1, 2131695382, 0).a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_a_of_type_Int != this.jdField_f_of_type_Int) || (!this.jdField_b_of_type_Boolean)) {
        break label396;
      }
      if (this.h != -1) {
        break label385;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.setChecked(false);
      b(null);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView, this.jdField_a_of_type_Int);
      return false;
      label385:
      this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.setChecked(false);
      continue;
      label396:
      this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.setChecked(false);
    }
    i();
    k();
    return false;
    Object localObject = getString(2131695383);
    paramMessage = (String)paramMessage.obj;
    if (!TextUtils.isEmpty(paramMessage)) {}
    for (;;)
    {
      bcpw.a(this, 1, paramMessage, 0).a();
      return false;
      localObject = String.format(getString(2131695397), new Object[] { Integer.valueOf(auwp.jdField_a_of_type_Int) });
      paramMessage = (String)paramMessage.obj;
      if (!TextUtils.isEmpty(paramMessage)) {}
      for (;;)
      {
        bcpw.a(this, 1, paramMessage, 0).a();
        return false;
        if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_b_of_type_AndroidGraphicsBitmap == null) || (this.jdField_b_of_type_AndroidWidgetImageView == null) || (this.jdField_c_of_type_AndroidWidgetImageView == null) || (this.jdField_a_of_type_AndroidWidgetPopupWindow == null)) {
          break;
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap);
        this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView, 80, 0, 0);
        this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setVisibility(8);
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("vip_diy_card_guide_shown", true).apply();
        return false;
        paramMessage = (Message)localObject;
      }
      paramMessage = (Message)localObject;
    }
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_Bcpq != null) && (this.jdField_a_of_type_Bcpq.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bcpq.dismiss();
      label24:
      this.jdField_a_of_type_Bcpq = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  protected void j()
  {
    try
    {
      if (!isFinishing())
      {
        this.jdField_b_of_type_Bcpq = new bcpq(this, getTitleBarHeight());
        this.jdField_b_of_type_Bcpq.setCancelable(false);
        this.jdField_b_of_type_Bcpq.c(2131690774);
        this.jdField_b_of_type_Bcpq.show();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void k()
  {
    if ((this.jdField_b_of_type_Bcpq != null) && (this.jdField_b_of_type_Bcpq.isShowing())) {}
    try
    {
      this.jdField_b_of_type_Bcpq.dismiss();
      label24:
      this.jdField_b_of_type_Bcpq = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Bbgg != null)
    {
      this.jdField_a_of_type_Bbgg.dismiss();
      this.jdField_a_of_type_Bbgg = null;
    }
  }
  
  void m()
  {
    n();
    int i1;
    int i2;
    if (!TextUtils.isEmpty(a()))
    {
      i1 = 1;
      if (i1 == 0) {
        break label102;
      }
      i2 = 2131695391;
      label24:
      str = getString(i2);
      if (i1 == 0) {
        break label109;
      }
      i2 = 2131695385;
      label38:
      this.jdField_b_of_type_Bbgg = bbcv.a(this, str, i2, 2131695378, this.jdField_f_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_e_of_type_AndroidContentDialogInterface$OnClickListener);
      this.jdField_b_of_type_Bbgg.show();
      if (i1 == 0) {
        break label116;
      }
    }
    label102:
    label109:
    label116:
    for (String str = "1";; str = "0")
    {
      VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X80081C9", "", 1, 0, 0, nam.a(), str, "");
      return;
      i1 = 0;
      break;
      i2 = 2131695381;
      break label24;
      i2 = 2131695380;
      break label38;
    }
  }
  
  public void n()
  {
    if (this.jdField_b_of_type_Bbgg != null)
    {
      this.jdField_b_of_type_Bbgg.dismiss();
      this.jdField_b_of_type_Bbgg = null;
    }
  }
  
  void o()
  {
    n();
    this.jdField_b_of_type_Bbgg = bbcv.a(this, getString(2131695384), 2131695375, 2131695392, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
    this.jdField_b_of_type_Bbgg.show();
    VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X80081C9", "", 1, 0, 0, nam.a(), "2", "");
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    label370:
    label1023:
    do
    {
      do
      {
        return;
        if (this.jdField_b_of_type_Int == 2)
        {
          this.jdField_b_of_type_Int = 1;
          if (!this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setVisibility(0);
            this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setEditable(true);
          }
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqProfileViewVerticalSeekBar.setVisibility(0);
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690573);
          VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X800820F", "", 1, 0, 0, "", "", "");
          return;
        }
        m();
        VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X800810E", "", 1, 0, 0, "", "", "");
        return;
        this.jdField_b_of_type_Int = 2;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695376);
        if (TextUtils.isEmpty(a()))
        {
          this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqProfileViewVerticalSeekBar.setVisibility(8);
          bfmr.a(this);
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          if (TextUtils.isEmpty(this.jdField_d_of_type_AndroidWidgetTextView.getText()))
          {
            this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setFaceDrawable(this.app, 1, this.app.getCurrentAccountUin(), 200, true, true, true, false, 3);
            this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataCard.strNick);
            this.jdField_f_of_type_AndroidWidgetTextView.setText(String.format("%s岁", new Object[] { Byte.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataCard.age) }));
            if (this.jdField_a_of_type_ComTencentMobileqqDataCard.shGender != 1) {
              break label681;
            }
            paramView = ajyc.a(2131716766);
            this.jdField_e_of_type_AndroidWidgetTextView.setText(paramView);
            localObject = "";
            paramView = (View)localObject;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.strCountry))
            {
              paramView = (View)localObject;
              if (!ajyc.a(2131716765).equals(this.jdField_a_of_type_ComTencentMobileqqDataCard.strCountry)) {
                paramView = "" + this.jdField_a_of_type_ComTencentMobileqqDataCard.strCountry;
              }
            }
            localObject = paramView;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.strProvince))
            {
              localObject = paramView;
              if (!TextUtils.isEmpty(paramView)) {
                localObject = paramView + "，";
              }
              localObject = (String)localObject + this.jdField_a_of_type_ComTencentMobileqqDataCard.strProvince;
            }
            paramView = (View)localObject;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.strCity))
            {
              paramView = (View)localObject;
              if (!TextUtils.isEmpty((CharSequence)localObject)) {
                paramView = (String)localObject + "，";
              }
              paramView = paramView + this.jdField_a_of_type_ComTencentMobileqqDataCard.strCity;
            }
            this.jdField_g_of_type_AndroidWidgetTextView.setText(paramView);
            paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView;
            if (this.jdField_a_of_type_ComTencentMobileqqDataCard.bVoted != 1) {
              break label707;
            }
          }
        }
        for (boolean bool = true;; bool = false)
        {
          paramView.a(true, bool, (int)this.jdField_a_of_type_ComTencentMobileqqDataCard.lVoteCount, this.jdField_a_of_type_ComTencentMobileqqDataCard.iVoteIncrement, null, false);
          VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X80081CB", "", 1, 0, 0, nam.a(), "", "");
          return;
          this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setEditable(false);
          break;
          if (this.jdField_a_of_type_ComTencentMobileqqDataCard.shGender == 0)
          {
            paramView = ajyc.a(2131716771);
            break label370;
          }
          paramView = "";
          break label370;
        }
        if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Int == 1))
        {
          if ((this.jdField_a_of_type_Long == 0L) || (this.jdField_a_of_type_Long == 160L) || (this.jdField_a_of_type_Long == 1600L)) {
            a(auwp.jdField_a_of_type_JavaLangString);
          }
          for (;;)
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView == null) && (this.jdField_b_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView != null)) {
              this.jdField_b_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.performClick();
            }
            this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setVisibility(0);
            f();
            this.jdField_a_of_type_Boolean = false;
            if ((this.h == -1) && (this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_a_of_type_Int == this.jdField_f_of_type_Int) && (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_b_of_type_Int == 0))
            {
              this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView.setHiBoom(this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_a_of_type_Int, 1, aqxh.b);
              this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_b_of_type_Int = 1;
            }
            VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X8008113", "", 1, 0, 0, nam.a(), "", "");
            return;
            a(this.jdField_c_of_type_JavaLangString);
          }
        }
        this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
        if (this.jdField_b_of_type_Int != 2) {
          this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setEditable(true);
        }
        bfmr.a(this);
        return;
        g();
        int i1;
        int i2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView != null)
        {
          i1 = 1;
          if (TextUtils.isEmpty(a())) {
            break label1023;
          }
          i2 = 1;
          if (i1 == 0) {
            break label1035;
          }
          if (i2 == 0) {
            break label1028;
          }
          paramView = "2";
          if (i1 == 0) {
            break label1052;
          }
        }
        for (Object localObject = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_a_of_type_Int);; localObject = "")
        {
          VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X8008116", "", 1, 0, 0, nam.a(), paramView, (String)localObject);
          return;
          i1 = 0;
          break;
          i2 = 0;
          break label967;
          paramView = "1";
          break label979;
          if (i2 != 0)
          {
            paramView = "";
            break label979;
          }
          paramView = "0";
          break label979;
        }
      } while (this.jdField_a_of_type_AndroidWidgetPopupWindow == null);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView == null);
    label681:
    label707:
    label967:
    label979:
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setVisibility(0);
    label1028:
    label1035:
    label1052:
    return;
  }
  
  public void onGlobalLayout()
  {
    if (this.l <= 0)
    {
      this.l = (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getWidth() * 2 / 3);
      this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView.setMaxSize(this.l);
    }
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    paramSeekBar = this.jdField_a_of_type_AndroidViewView;
    if (paramInt > 77) {}
    for (int i1 = -16777216;; i1 = -1)
    {
      paramSeekBar.setBackgroundColor(i1);
      this.jdField_a_of_type_AndroidViewView.getBackground().setAlpha(Math.abs(paramInt - 77));
      this.i = paramInt;
      return;
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.k = this.jdField_a_of_type_ComTencentMobileqqProfileViewVerticalSeekBar.a();
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewVerticalSeekBar.a() - this.k > 0) {}
    for (paramSeekBar = "1";; paramSeekBar = "0")
    {
      VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X80081CC", "", 1, 0, 0, "", paramSeekBar, "");
      return;
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramCharSequence = ayla.c(paramCharSequence.toString());
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView.setText(paramCharSequence);
      this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView.setText(paramCharSequence);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView == null) {}
      for (boolean bool = this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView, this.jdField_a_of_type_Int);; bool = this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.a(this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView))
      {
        if (bool) {
          f();
        }
        return;
      }
    }
    if (!this.jdField_a_of_type_Boolean) {}
    this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView.setText(" ");
    this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView.setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VipProfileCardDiyActivity
 * JD-Core Version:    0.7.0.1
 */