package com.tencent.mobileqq.activity;

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
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hiboom.HiBoomManager;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profile.diy.DiyTextView;
import com.tencent.mobileqq.profile.diy.VipDiyCardConstants;
import com.tencent.mobileqq.profile.diy.VipProfileDiyCardConfig;
import com.tencent.mobileqq.profile.upload.VipUploadUtils;
import com.tencent.mobileqq.profile.upload.task.VipBaseUpsImageUploadTask;
import com.tencent.mobileqq.profile.upload.task.VipImageUploadManager;
import com.tencent.mobileqq.profile.view.HScrollView;
import com.tencent.mobileqq.profile.view.HScrollView.ScrollViewListener;
import com.tencent.mobileqq.profile.view.SingleTouchLayout;
import com.tencent.mobileqq.profile.view.SingleTouchLayout.SingleTapListener;
import com.tencent.mobileqq.profile.view.SoftInputDetectView;
import com.tencent.mobileqq.profile.view.SoftInputDetectView.OnImStateChangedListener;
import com.tencent.mobileqq.profile.view.VerticalSeekBar;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.data.UpsImageUploadResult;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import uea;
import ueb;
import uec;
import ued;
import uee;
import uef;
import ueg;
import uei;
import uej;
import uek;
import uel;
import uem;

public class VipProfileCardDiyActivity
  extends BaseActivity
  implements Handler.Callback, TextWatcher, View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener, SeekBar.OnSeekBarChangeListener, HScrollView.ScrollViewListener, SingleTouchLayout.SingleTapListener, SoftInputDetectView.OnImStateChangedListener
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  public long a;
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new uei(this);
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public Resources a;
  public Bitmap a;
  public Drawable a;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  VipProfileCardDiyActivity.DiyDefaultTextView jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView;
  VipProfileCardDiyActivity.HiBoomTemplateView jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView;
  VipProfileCardDiyActivity.OnMeasuredListener jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$OnMeasuredListener = new uef(this);
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new ueg(this);
  DynamicAvatarView jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView;
  Card jdField_a_of_type_ComTencentMobileqqDataCard;
  HiBoomManager jdField_a_of_type_ComTencentMobileqqHiboomHiBoomManager;
  DiyTextView jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView;
  HScrollView jdField_a_of_type_ComTencentMobileqqProfileViewHScrollView;
  public SingleTouchLayout a;
  SoftInputDetectView jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView;
  VerticalSeekBar jdField_a_of_type_ComTencentMobileqqProfileViewVerticalSeekBar;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  public VasQuickUpdateManager a;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  VoteView jdField_a_of_type_ComTencentMobileqqWidgetVoteView;
  public WeakReferenceHandler a;
  ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  public String a;
  public HashMap a;
  public AtomicBoolean a;
  public boolean a;
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int = 1;
  DialogInterface.OnClickListener jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new uej(this);
  public Bitmap b;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  VipProfileCardDiyActivity.HiBoomTemplateView jdField_b_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView;
  QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  QQProgressDialog jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  String jdField_b_of_type_JavaLangString;
  public AtomicBoolean b;
  boolean jdField_b_of_type_Boolean;
  float jdField_c_of_type_Float;
  int jdField_c_of_type_Int;
  DialogInterface.OnClickListener jdField_c_of_type_AndroidContentDialogInterface$OnClickListener = new uek(this);
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public String c;
  boolean jdField_c_of_type_Boolean = false;
  float jdField_d_of_type_Float;
  public int d;
  DialogInterface.OnClickListener jdField_d_of_type_AndroidContentDialogInterface$OnClickListener = new uel(this);
  TextView jdField_d_of_type_AndroidWidgetTextView;
  String jdField_d_of_type_JavaLangString;
  volatile boolean jdField_d_of_type_Boolean = false;
  public int e;
  DialogInterface.OnClickListener jdField_e_of_type_AndroidContentDialogInterface$OnClickListener = new uem(this);
  TextView jdField_e_of_type_AndroidWidgetTextView;
  public String e;
  int jdField_f_of_type_Int = -1;
  DialogInterface.OnClickListener jdField_f_of_type_AndroidContentDialogInterface$OnClickListener = new ueb(this);
  TextView jdField_f_of_type_AndroidWidgetTextView;
  int jdField_g_of_type_Int;
  TextView jdField_g_of_type_AndroidWidgetTextView;
  int h;
  int i;
  public int j;
  int k;
  public int l;
  int m = 30000;
  public int n = 2;
  
  public VipProfileCardDiyActivity()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static boolean a(int paramInt)
  {
    File localFile = new File(VipDiyCardConstants.jdField_a_of_type_JavaLangString + paramInt);
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
  
  public int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
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
    this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("extra_card_url");
    this.jdField_b_of_type_JavaLangString = localIntent.getStringExtra("extra_card_default_text");
    if (android.text.TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = "请输入文字";
    }
    this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("extra_card_path");
    label139:
    int i1;
    if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.diyText))
    {
      this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataCard.diyText;
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextFontId <= 0) {
        break label295;
      }
      this.h = this.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextFontId;
      if ((this.jdField_a_of_type_Long == 0L) || (this.jdField_a_of_type_Long != this.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId)) {
        break label310;
      }
      i1 = 1;
      label165:
      if ((i1 == 0) || (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.diyText))) {
        break label315;
      }
      this.jdField_a_of_type_Float = (this.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextLocX * this.jdField_d_of_type_Int);
      this.jdField_b_of_type_Float = (this.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextLocY * this.jdField_e_of_type_Int);
      this.jdField_c_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextScale;
      this.jdField_d_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextDegree;
      this.i = ((int)(this.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextTransparency * 255.0F));
      label254:
      if (this.i >= -77) {
        break label387;
      }
      this.i = -77;
    }
    for (;;)
    {
      this.i += 77;
      return;
      this.jdField_d_of_type_JavaLangString = localIntent.getStringExtra("extra_card_text");
      break;
      label295:
      this.h = localIntent.getIntExtra("extra_card_font", -1);
      break label139;
      label310:
      i1 = 0;
      break label165;
      label315:
      this.jdField_a_of_type_Float = localIntent.getFloatExtra("extra_card_x", 1.4E-45F);
      this.jdField_b_of_type_Float = localIntent.getFloatExtra("extra_card_y", 1.4E-45F);
      this.jdField_c_of_type_Float = localIntent.getFloatExtra("extra_card_scale", 1.0F);
      this.jdField_d_of_type_Float = localIntent.getFloatExtra("extra_card_rotation", 0.0F);
      this.i = ((int)(localIntent.getFloatExtra("extra_card_transparency", 0.0F) * 255.0F));
      break label254;
      label387:
      if (this.i > 77) {
        this.i = 77;
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 1) {
      VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X8008115", "", 1, 0, 0, HttpUtil.a(), "", "");
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
      ProfileCardUtil.a(this.app, paramLong1, paramLong2);
      this.jdField_e_of_type_JavaLangString = a();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView != null) {
        break label263;
      }
    }
    label263:
    for (int i1 = 0;; i1 = this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_a_of_type_Int)
    {
      this.j = i1;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(6, this.m);
      return;
      label91:
      i1 = this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_a_of_type_Int;
      String str = a();
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.a();
      localObject = String.format("%s_%s_%s_%s", new Object[] { Float.valueOf(((PointF)localObject).x / this.jdField_d_of_type_Int), Float.valueOf(((PointF)localObject).y / this.jdField_e_of_type_Int), Float.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.o / this.jdField_d_of_type_Int), Float.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.p / this.jdField_e_of_type_Int) });
      float f1 = this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.a();
      float f2 = this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.b();
      float f3 = (this.jdField_a_of_type_ComTencentMobileqqProfileViewVerticalSeekBar.a() - 77) / 255.0F;
      ProfileCardUtil.a(this.app, paramLong1, paramLong2, null, 0L, null, i1, str, (String)localObject, f1, f2, f3);
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
    InputMethodUtil.a(this.jdField_a_of_type_AndroidWidgetEditText);
    c();
  }
  
  public void a(View paramView, float paramFloat)
  {
    c();
    String str = HttpUtil.a();
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
    VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X8008110", "", 1, 0, 0, HttpUtil.a(), "", "");
  }
  
  void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setText(paramString);
    if (!android.text.TextUtils.isEmpty(paramString)) {
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
    long l1 = ProfileCardTemplate.g;
    if ((!this.jdField_d_of_type_Boolean) && (!isFinishing()))
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView != null) && (paramBoolean)) {
        break label86;
      }
      ProfileCardUtil.a(this.app, l1, 160L, paramString2, ProfileCardUtil.a(paramString1), null);
      this.jdField_e_of_type_JavaLangString = a();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView != null) {
        break label291;
      }
    }
    label291:
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
      if ((android.text.TextUtils.isEmpty(str)) || (i2 == 0)) {}
      for (i1 = 160;; i1 = 1600)
      {
        ProfileCardUtil.a(this.app, l1, i1, paramString2, ProfileCardUtil.a(paramString1), null, i2, str, (String)localObject, f1, f2, f3);
        break;
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (android.text.TextUtils.isEmpty(paramString))
    {
      QLog.e("VipProfileCardDiyActivity", 1, "uploadBackgroundToUps filePath is empty");
      return;
    }
    ued localued = new ued(this, Long.parseLong(this.app.getCurrentAccountUin()), paramString, VipUploadUtils.a(this.app), "qqprofile", paramString, paramBoolean);
    localued.b = VipUploadUtils.a(this.app);
    localued.i = VipUploadUtils.a(this.app, paramString);
    j();
    paramString = (VipImageUploadManager)this.app.getManager(89);
    paramString.a(this.app, null);
    localued.a();
    paramString.a(this.app, localued, null);
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
  
  public boolean a(long paramLong, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(50);
    Card localCard = localFriendsManager.a(this.app.getCurrentAccountUin());
    if ((localCard != null) && (paramLong >= 0L))
    {
      localCard.lCurrentStyleId = paramLong;
      localCard.lCurrentBgId = paramInt1;
      localCard.strCurrentBgUrl = paramString;
      localCard.backgroundColor = paramInt2;
      localCard.templateRet = paramInt3;
      if (!localFriendsManager.a(localCard))
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
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView = ((SoftInputDetectView)findViewById(2131362822));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)findViewById(2131363361));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363227));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363410));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370856));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370858));
    this.jdField_a_of_type_ComTencentMobileqqProfileViewHScrollView = ((HScrollView)findViewById(2131370857));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131370860));
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout = ((SingleTouchLayout)findViewById(2131370861));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131370865));
    this.jdField_a_of_type_ComTencentMobileqqProfileViewVerticalSeekBar = ((VerticalSeekBar)findViewById(2131370864));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131365570);
    this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView = new DiyTextView(this);
    this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView.setBackgroundColor(0);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.a(this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView);
    int i1 = AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentResResources);
    this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView = new VipProfileCardDiyActivity.DiyDefaultTextView(this, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView.setTextColor(-1);
    this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView.setTextSize(18.0F);
    this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView.setPadding(i1, i1, i1, i1);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131370859));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370862));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131368814);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView = ((DynamicAvatarView)findViewById(2131369034));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370146));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370872));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370871));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370873));
    this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView = ((VoteView)findViewById(2131370395));
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
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(VipProfileDiyCardConfig.jdField_a_of_type_Int) });
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(this);
    this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView.setOnMeasuredListener(this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$OnMeasuredListener);
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
      VasH5PayUtil.a(this.app, this, "mvip.g.a.mp_wz", 3, "1450000516", "CJCLUBT", getString(2131436926), "svipdiyCardH5Pay");
      return;
    }
    VasH5PayUtil.a(this.app, this, "mvip.g.a.mp_wz", 3, "1450000515", "LTMCLUB", getString(2131436723), "vipdiyCardH5Pay");
  }
  
  public void b(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setVisibility(8);
    this.jdField_a_of_type_Boolean = true;
    a("");
    c();
    VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X800810F", "", 1, 0, 0, HttpUtil.a(), "", "");
  }
  
  void b(String paramString)
  {
    l();
    int i2;
    boolean bool;
    String str;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView != null) && (!android.text.TextUtils.isEmpty(a())))
    {
      i2 = 1;
      bool = VipUtils.a(this.app);
      str = getString(2131438990);
      if (!android.text.TextUtils.isEmpty(paramString)) {
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
      paramString = getString(2131438994);
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
        i3 = 2131438984;
        if (this.n != 2) {
          break label278;
        }
        if (!bool) {
          break label271;
        }
        i1 = 2131438985;
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.b(this, 0, str, paramString, i3, i1, this.jdField_d_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_c_of_type_AndroidContentDialogInterface$OnClickListener);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        if (i2 != 0) {
          if (!bool) {
            break label302;
          }
        }
      }
      for (paramString = "4";; paramString = "3")
      {
        VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X80081C9", "", 1, 0, 0, HttpUtil.a(), paramString, "");
        return;
        i2 = 0;
        break;
        label214:
        paramString = getString(2131438991);
        break label96;
        label225:
        paramString = getString(2131438993);
        break label96;
        label236:
        if (bool)
        {
          paramString = getString(2131438992);
          break label96;
        }
        paramString = getString(2131438991);
        break label96;
        i3 = 2131432998;
        break label126;
        i1 = 2131438986;
        break label143;
        if (VipUtils.b(this.app))
        {
          i1 = 2131438987;
          break label143;
        }
        i1 = 2131438988;
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
    ThreadManager.executeOnFileThread(new uec(this, paramString));
  }
  
  void d()
  {
    int i2 = 0;
    Object localObject1;
    Object localObject2;
    if (android.text.TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      localObject1 = ProfileCardUtil.a(this, this.jdField_a_of_type_JavaLangString);
      localObject2 = new File((String)localObject1);
      if ((!((File)localObject2).isFile()) || (!((File)localObject2).exists())) {
        break label537;
      }
      c((String)localObject1);
    }
    label536:
    label537:
    for (int i1 = 0;; i1 = 1)
    {
      if (i1 != 0) {
        ThreadManager.post(new uee(this, (File)localObject2, (String)localObject1), 8, null, true);
      }
      localObject1 = new LinearLayout.LayoutParams(AIOUtils.a(86.0F, this.jdField_a_of_type_AndroidContentResResources), AIOUtils.a(123.0F, this.jdField_a_of_type_AndroidContentResResources));
      ((LinearLayout.LayoutParams)localObject1).setMargins(0, AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidContentResResources), AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidContentResResources), AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentResResources));
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      SparseArray localSparseArray = VipProfileDiyCardConfig.jdField_a_of_type_AndroidUtilSparseArray;
      if (localSparseArray == null)
      {
        VipProfileDiyCardConfig.a(this.app);
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
        if ((this.jdField_a_of_type_Long == 0L) || ((android.text.TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (this.jdField_g_of_type_Int == 1)))
        {
          this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setVisibility(8);
          this.jdField_a_of_type_Boolean = true;
          e();
          label336:
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView, (ViewGroup.LayoutParams)localObject1);
          i1 = i2;
          label351:
          if (i1 >= localSparseArray.size()) {
            break label536;
          }
          i2 = localSparseArray.keyAt(i1);
          if (i2 != this.jdField_f_of_type_Int) {
            break label483;
          }
        }
        for (;;)
        {
          i1 += 1;
          break label351;
          c(this.jdField_c_of_type_JavaLangString);
          break;
          this.jdField_b_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.setChecked(true);
          this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView = this.jdField_b_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView;
          this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView.setHiBoom(this.jdField_f_of_type_Int, 2, HiBoomManager.b);
          if (!bool) {}
          for (bool = true;; bool = false)
          {
            this.jdField_b_of_type_Boolean = bool;
            if (this.jdField_b_of_type_Boolean) {
              this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_b_of_type_Int = 1;
            }
            if (android.text.TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
              break label476;
            }
            a(this.jdField_d_of_type_JavaLangString);
            break;
          }
          label476:
          e();
          break label336;
          label483:
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    super.setContentView(2130970490);
    this.jdField_a_of_type_AndroidContentSharedPreferences = getSharedPreferences("vip_profile_diy_card", 0);
    this.jdField_a_of_type_ComTencentMobileqqDataCard = ProfileCardUtil.a(this.app, this.app.getCurrentAccountUin());
    this.jdField_a_of_type_AndroidContentResResources = super.getResources();
    paramBundle = this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics();
    this.jdField_d_of_type_Int = paramBundle.widthPixels;
    this.jdField_e_of_type_Int = paramBundle.heightPixels;
    this.jdField_a_of_type_Int = AIOUtils.a(130.0F, this.jdField_a_of_type_AndroidContentResResources);
    a();
    this.jdField_c_of_type_Int = AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidContentResResources);
    this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager = ((VasQuickUpdateManager)this.app.getManager(183));
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomManager = ((HiBoomManager)this.app.getManager(218));
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    b();
    d();
    VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X800810D", "", 1, 0, 0, HttpUtil.a(), "", String.valueOf(this.jdField_a_of_type_Long));
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacks(null);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    i();
    k();
  }
  
  @TargetApi(9)
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("vip_diy_card_guide_shown", false)) {
        break label179;
      }
      if (this.jdField_a_of_type_AndroidWidgetPopupWindow == null)
      {
        localView = getLayoutInflater().inflate(2130970489, null);
        localButton = (Button)localView.findViewById(2131370855);
        this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131370853));
        this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131370854));
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
        ThreadManager.executeOnFileThread(new uea(this));
      }
    }
    label168:
    label179:
    while (this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("vip_diy_card_edit_guide_shown", false))
    {
      View localView;
      Button localButton;
      return;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(9);
      return;
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Long == 0L) || (this.jdField_a_of_type_Long == 160L) || (this.jdField_a_of_type_Long == 1600L)) {
      a(VipProfileDiyCardConfig.jdField_a_of_type_JavaLangString);
    }
    while (android.text.TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      return;
    }
    a(this.jdField_b_of_type_JavaLangString);
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
        l1 = ProfileCardTemplate.g;
        if (this.jdField_a_of_type_Long != 0L) {
          break;
        }
      } while (!a());
      str = (String)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_c_of_type_JavaLangString);
      if (!android.text.TextUtils.isEmpty(str))
      {
        a(this.jdField_c_of_type_JavaLangString, str, true);
        return;
      }
      a(this.jdField_c_of_type_JavaLangString, true);
      return;
      if ((this.jdField_a_of_type_Long != 160L) && (this.jdField_a_of_type_Long != 1600L)) {
        break;
      }
    } while ((!a()) || (android.text.TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)));
    a(ProfileCardUtil.a(this, this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_JavaLangString, true);
    return;
    if (android.text.TextUtils.isEmpty(a()))
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
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131436736);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
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
          if (!android.text.TextUtils.isEmpty((String)paramMessage.obj))
          {
            QQToast.a(this, (String)paramMessage.obj, 0).a();
            return false;
          }
          QQToast.a(this, 2131438983, 0).a();
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
    QQToast.a(this, 1, 2131439003, 0).a();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_a_of_type_Int == this.jdField_f_of_type_Int) && (this.jdField_b_of_type_Boolean)) {
      if (this.h == -1)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.setChecked(false);
        b(null);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView, this.jdField_a_of_type_Int);
      return false;
      this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.setChecked(false);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.setChecked(false);
    }
    i();
    k();
    return false;
    Object localObject = getString(2131439001);
    paramMessage = (String)paramMessage.obj;
    if (!android.text.TextUtils.isEmpty(paramMessage)) {}
    for (;;)
    {
      QQToast.a(this, 1, paramMessage, 0).a();
      return false;
      localObject = String.format(getString(2131439002), new Object[] { Integer.valueOf(VipProfileDiyCardConfig.jdField_a_of_type_Int) });
      paramMessage = (String)paramMessage.obj;
      if (!android.text.TextUtils.isEmpty(paramMessage)) {}
      for (;;)
      {
        QQToast.a(this, 1, paramMessage, 0).a();
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
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      label24:
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
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
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131433628);
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
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
    if ((this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      label24:
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  void m()
  {
    n();
    int i1;
    int i2;
    if (!android.text.TextUtils.isEmpty(a()))
    {
      i1 = 1;
      if (i1 == 0) {
        break label102;
      }
      i2 = 2131438995;
      label24:
      str = getString(i2);
      if (i1 == 0) {
        break label109;
      }
      i2 = 2131438996;
      label38:
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, str, i2, 2131438997, this.jdField_f_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_e_of_type_AndroidContentDialogInterface$OnClickListener);
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      if (i1 == 0) {
        break label116;
      }
    }
    label102:
    label109:
    label116:
    for (String str = "1";; str = "0")
    {
      VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X80081C9", "", 1, 0, 0, HttpUtil.a(), str, "");
      return;
      i1 = 0;
      break;
      i2 = 2131438999;
      break label24;
      i2 = 2131438998;
      break label38;
    }
  }
  
  public void n()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  void o()
  {
    n();
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, getString(2131439004), 2131439005, 2131439007, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X80081C9", "", 1, 0, 0, HttpUtil.a(), "2", "");
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    label367:
    label1014:
    label1019:
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
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131433682);
          VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X800820F", "", 1, 0, 0, "", "", "");
          return;
        }
        m();
        VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X800810E", "", 1, 0, 0, "", "", "");
        return;
        this.jdField_b_of_type_Int = 2;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131439006);
        if (android.text.TextUtils.isEmpty(a()))
        {
          this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqProfileViewVerticalSeekBar.setVisibility(8);
          InputMethodUtil.a(this);
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          if (android.text.TextUtils.isEmpty(this.jdField_d_of_type_AndroidWidgetTextView.getText()))
          {
            this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setFaceDrawable(this.app, 1, this.app.getCurrentAccountUin(), 200, true, true, true, false, 3);
            this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataCard.strNick);
            this.jdField_f_of_type_AndroidWidgetTextView.setText(String.format("%s岁", new Object[] { Byte.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataCard.age) }));
            if (this.jdField_a_of_type_ComTencentMobileqqDataCard.shGender != 1) {
              break label675;
            }
            paramView = "女";
            this.jdField_e_of_type_AndroidWidgetTextView.setText(paramView);
            localObject = "";
            paramView = (View)localObject;
            if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.strCountry))
            {
              paramView = (View)localObject;
              if (!"中国".equals(this.jdField_a_of_type_ComTencentMobileqqDataCard.strCountry)) {
                paramView = "" + this.jdField_a_of_type_ComTencentMobileqqDataCard.strCountry;
              }
            }
            localObject = paramView;
            if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.strProvince))
            {
              localObject = paramView;
              if (!android.text.TextUtils.isEmpty(paramView)) {
                localObject = paramView + "，";
              }
              localObject = (String)localObject + this.jdField_a_of_type_ComTencentMobileqqDataCard.strProvince;
            }
            paramView = (View)localObject;
            if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.strCity))
            {
              paramView = (View)localObject;
              if (!android.text.TextUtils.isEmpty((CharSequence)localObject)) {
                paramView = (String)localObject + "，";
              }
              paramView = paramView + this.jdField_a_of_type_ComTencentMobileqqDataCard.strCity;
            }
            this.jdField_g_of_type_AndroidWidgetTextView.setText(paramView);
            paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView;
            if (this.jdField_a_of_type_ComTencentMobileqqDataCard.bVoted != 1) {
              break label698;
            }
          }
        }
        for (boolean bool = true;; bool = false)
        {
          paramView.a(true, bool, (int)this.jdField_a_of_type_ComTencentMobileqqDataCard.lVoteCount, this.jdField_a_of_type_ComTencentMobileqqDataCard.iVoteIncrement, null, false);
          VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X80081CB", "", 1, 0, 0, HttpUtil.a(), "", "");
          return;
          this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setEditable(false);
          break;
          if (this.jdField_a_of_type_ComTencentMobileqqDataCard.shGender == 0)
          {
            paramView = "男";
            break label367;
          }
          paramView = "";
          break label367;
        }
        if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Int == 1))
        {
          if ((this.jdField_a_of_type_Long == 0L) || (this.jdField_a_of_type_Long == 160L) || (this.jdField_a_of_type_Long == 1600L)) {
            a(VipProfileDiyCardConfig.jdField_a_of_type_JavaLangString);
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
              this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView.setHiBoom(this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_a_of_type_Int, 2, HiBoomManager.b);
              this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_b_of_type_Int = 1;
            }
            VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X8008113", "", 1, 0, 0, HttpUtil.a(), "", "");
            return;
            a(this.jdField_b_of_type_JavaLangString);
          }
        }
        this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
        if (this.jdField_b_of_type_Int != 2) {
          this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setEditable(true);
        }
        InputMethodUtil.a(this);
        return;
        g();
        int i1;
        int i2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView != null)
        {
          i1 = 1;
          if (android.text.TextUtils.isEmpty(a())) {
            break label1014;
          }
          i2 = 1;
          if (i1 == 0) {
            break label1026;
          }
          if (i2 == 0) {
            break label1019;
          }
          paramView = "2";
          if (i1 == 0) {
            break label1043;
          }
        }
        for (Object localObject = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_a_of_type_Int);; localObject = "")
        {
          VasWebviewUtil.reportCommercialDrainage("", "card_mall", "0X8008116", "", 1, 0, 0, HttpUtil.a(), paramView, (String)localObject);
          return;
          i1 = 0;
          break;
          i2 = 0;
          break label958;
          paramView = "1";
          break label970;
          if (i2 != 0)
          {
            paramView = "";
            break label970;
          }
          paramView = "0";
          break label970;
        }
      } while (this.jdField_a_of_type_AndroidWidgetPopupWindow == null);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView == null);
    label675:
    label698:
    label958:
    label970:
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setVisibility(0);
    label1026:
    label1043:
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
    paramCharSequence = com.tencent.mobileqq.text.TextUtils.b(paramCharSequence.toString());
    if (!android.text.TextUtils.isEmpty(paramCharSequence))
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