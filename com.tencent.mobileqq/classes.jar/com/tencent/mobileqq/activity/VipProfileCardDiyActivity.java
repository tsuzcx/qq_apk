package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
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
import android.view.MotionEvent;
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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hiboom.HiBoomConstants;
import com.tencent.mobileqq.hiboom.api.IHiBoomManager;
import com.tencent.mobileqq.profile.ProfileCardManager;
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
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.IVipStatusManager;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.upload.uinterface.data.UpsImageUploadResult;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class VipProfileCardDiyActivity
  extends BaseActivity
  implements Handler.Callback, TextWatcher, View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener, SeekBar.OnSeekBarChangeListener, HScrollView.ScrollViewListener, SingleTouchLayout.SingleTapListener, SoftInputDetectView.OnImStateChangedListener
{
  public static final String a;
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new VipProfileCardDiyActivity.5(this);
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
  VipProfileCardDiyActivity.DiyDefaultTextView jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView;
  VipProfileCardDiyActivity.HiBoomTemplateView jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView;
  VipProfileCardDiyActivity.OnMeasuredListener jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$OnMeasuredListener = new VipProfileCardDiyActivity.3(this);
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new VipProfileCardDiyActivity.4(this);
  Card jdField_a_of_type_ComTencentMobileqqDataCard;
  IHiBoomManager jdField_a_of_type_ComTencentMobileqqHiboomApiIHiBoomManager;
  DiyTextView jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView;
  HScrollView jdField_a_of_type_ComTencentMobileqqProfileViewHScrollView;
  SingleTouchLayout jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout;
  SoftInputDetectView jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView;
  VerticalSeekBar jdField_a_of_type_ComTencentMobileqqProfileViewVerticalSeekBar;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  AvatarLayout jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout;
  IVasQuickUpdateService jdField_a_of_type_ComTencentMobileqqVasUpdatesystemApiIVasQuickUpdateService;
  CallBacker jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker = new VipProfileCardDiyActivity.1(this);
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  VoteView jdField_a_of_type_ComTencentMobileqqWidgetVoteView;
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  boolean jdField_a_of_type_Boolean;
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int = 1;
  DialogInterface.OnClickListener jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new VipProfileCardDiyActivity.6(this);
  Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  VipProfileCardDiyActivity.HiBoomTemplateView jdField_b_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView;
  QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  QQProgressDialog jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  String jdField_b_of_type_JavaLangString;
  AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  boolean jdField_b_of_type_Boolean;
  float jdField_c_of_type_Float;
  int jdField_c_of_type_Int;
  DialogInterface.OnClickListener jdField_c_of_type_AndroidContentDialogInterface$OnClickListener = new VipProfileCardDiyActivity.7(this);
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = false;
  float jdField_d_of_type_Float;
  int jdField_d_of_type_Int;
  DialogInterface.OnClickListener jdField_d_of_type_AndroidContentDialogInterface$OnClickListener = new VipProfileCardDiyActivity.8(this);
  TextView jdField_d_of_type_AndroidWidgetTextView;
  String jdField_d_of_type_JavaLangString;
  volatile boolean jdField_d_of_type_Boolean = false;
  int jdField_e_of_type_Int;
  DialogInterface.OnClickListener jdField_e_of_type_AndroidContentDialogInterface$OnClickListener = new VipProfileCardDiyActivity.9(this);
  TextView jdField_e_of_type_AndroidWidgetTextView;
  String jdField_e_of_type_JavaLangString;
  int jdField_f_of_type_Int = -1;
  DialogInterface.OnClickListener jdField_f_of_type_AndroidContentDialogInterface$OnClickListener = new VipProfileCardDiyActivity.10(this);
  TextView jdField_f_of_type_AndroidWidgetTextView;
  String jdField_f_of_type_JavaLangString;
  int jdField_g_of_type_Int;
  TextView jdField_g_of_type_AndroidWidgetTextView;
  String jdField_g_of_type_JavaLangString;
  int h;
  int i;
  int j;
  int k;
  public int l;
  int m = 30000;
  int n = 2;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131716251);
  }
  
  public static boolean a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(VipDiyCardConstants.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append(paramInt);
    File localFile = new File(((StringBuilder)localObject).toString());
    if ((localFile.exists()) && (localFile.isDirectory())) {
      localObject = localFile.list();
    } else {
      localObject = null;
    }
    return (localFile.exists()) && (localObject != null) && (localObject.length > 0);
  }
  
  public static boolean a(long paramLong, String paramString, int paramInt)
  {
    if ((5L == paramLong) && (paramString.startsWith("font.diycard.android."))) {
      return String.valueOf(paramInt).equals(paramString.substring(21, paramString.length()));
    }
    return false;
  }
  
  int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i2 = 1;
    int i1 = 1;
    int i4 = i2;
    if (paramInt1 != 0)
    {
      i4 = i2;
      if (paramInt2 != 0)
      {
        i4 = i2;
        if (paramInt1 != -1)
        {
          if (paramInt2 == -1) {
            return 1;
          }
          i2 = paramOptions.outHeight;
          int i3 = paramOptions.outWidth;
          for (;;)
          {
            i4 = i1;
            if (i2 <= paramInt2) {
              break;
            }
            i4 = i1;
            if (i3 <= paramInt1) {
              break;
            }
            int i5 = Math.round(i2 / paramInt2);
            i4 = Math.round(i3 / paramInt1);
            if (i5 <= i4) {
              i5 = i4;
            }
            i4 = i1;
            if (i5 < 2) {
              break;
            }
            i3 /= 2;
            i2 /= 2;
            i1 *= 2;
          }
        }
      }
    }
    return i4;
  }
  
  String a()
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
    if (android.text.TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      this.jdField_c_of_type_JavaLangString = jdField_a_of_type_JavaLangString;
    }
    this.jdField_d_of_type_JavaLangString = localIntent.getStringExtra("extra_card_path");
    if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.diyText)) {
      this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataCard.diyText;
    } else {
      this.jdField_e_of_type_JavaLangString = localIntent.getStringExtra("extra_card_text");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextFontId > 0) {
      this.h = this.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextFontId;
    } else {
      this.h = localIntent.getIntExtra("extra_card_font", -1);
    }
    long l1 = this.jdField_a_of_type_Long;
    if ((l1 != 0L) && (l1 == this.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((i1 != 0) && (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.diyText)))
    {
      this.jdField_a_of_type_Float = (this.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextLocX * this.jdField_d_of_type_Int);
      this.jdField_b_of_type_Float = (this.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextLocY * this.jdField_e_of_type_Int);
      this.jdField_c_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextScale;
      this.jdField_d_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextDegree;
      this.i = ((int)(this.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextTransparency * 255.0F));
    }
    else
    {
      this.jdField_a_of_type_Float = localIntent.getFloatExtra("extra_card_x", 1.4E-45F);
      this.jdField_b_of_type_Float = localIntent.getFloatExtra("extra_card_y", 1.4E-45F);
      this.jdField_c_of_type_Float = localIntent.getFloatExtra("extra_card_scale", 1.0F);
      this.jdField_d_of_type_Float = localIntent.getFloatExtra("extra_card_rotation", 0.0F);
      this.i = ((int)(localIntent.getFloatExtra("extra_card_transparency", 0.0F) * 255.0F));
    }
    int i1 = this.i;
    if (i1 < -77) {
      this.i = -77;
    } else if (i1 > 77) {
      this.i = 77;
    }
    this.i += 77;
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 1) {
      VasWebviewUtil.a("", "card_mall", "0X8008115", "", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), "", "");
    }
  }
  
  void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    i();
    h();
    if ((!this.jdField_d_of_type_Boolean) && (!isFinishing()))
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView;
      int i1 = 0;
      if ((localObject1 != null) && (paramBoolean))
      {
        int i2 = ((VipProfileCardDiyActivity.HiBoomTemplateView)localObject1).jdField_a_of_type_Int;
        localObject1 = a();
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.a();
        localObject2 = String.format("%s_%s_%s_%s", new Object[] { Float.valueOf(((PointF)localObject2).x / this.jdField_d_of_type_Int), Float.valueOf(((PointF)localObject2).y / this.jdField_e_of_type_Int), Float.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.p / this.jdField_d_of_type_Int), Float.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.q / this.jdField_e_of_type_Int) });
        float f1 = this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.a();
        float f2 = this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.b();
        float f3 = (this.jdField_a_of_type_ComTencentMobileqqProfileViewVerticalSeekBar.a() - 77) / 255.0F;
        ProfileCardUtil.a(this.app, paramLong1, paramLong2, null, 0L, null, i2, (String)localObject1, (String)localObject2, f1, f2, f3, "", 0L);
      }
      else
      {
        ProfileCardUtil.a(this.app, paramLong1, paramLong2);
      }
      this.jdField_f_of_type_JavaLangString = a();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView;
      if (localObject1 != null) {
        i1 = ((VipProfileCardDiyActivity.HiBoomTemplateView)localObject1).jdField_a_of_type_Int;
      }
      this.j = i1;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(6, this.m);
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
    String str = HttpUtil.getNetWorkTypeByStr();
    if (paramFloat > 1.0F) {
      paramView = "0";
    } else {
      paramView = "1";
    }
    VasWebviewUtil.a("", "card_mall", "0X8008111", "", 1, 0, 0, str, paramView, "");
  }
  
  public void a(View paramView, float paramFloat1, float paramFloat2)
  {
    c();
    VasWebviewUtil.a("", "card_mall", "0X8008110", "", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), "", "");
  }
  
  void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setText(paramString);
    if (!android.text.TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramString.length());
    }
  }
  
  void a(String paramString, UpsImageUploadResult paramUpsImageUploadResult, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url from UPS:");
      localStringBuilder.append(paramUpsImageUploadResult.url);
      QLog.d("VipProfileCardDiyActivity", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramUpsImageUploadResult.url);
    a(paramString, paramUpsImageUploadResult.url, paramBoolean);
  }
  
  void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    h();
    long l1 = ProfileCardTemplate.PROFILE_CARD_STYLE_SIMPLE;
    if ((!this.jdField_d_of_type_Boolean) && (!isFinishing()))
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView;
      int i1;
      if ((localObject1 != null) && (paramBoolean))
      {
        int i2 = ((VipProfileCardDiyActivity.HiBoomTemplateView)localObject1).jdField_a_of_type_Int;
        localObject1 = a();
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.a();
        localObject2 = String.format("%s_%s_%s_%s", new Object[] { Float.valueOf(((PointF)localObject2).x / this.jdField_d_of_type_Int), Float.valueOf(((PointF)localObject2).y / this.jdField_e_of_type_Int), Float.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.p / this.jdField_d_of_type_Int), Float.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.q / this.jdField_e_of_type_Int) });
        float f1 = this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.a();
        float f2 = this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.b();
        float f3 = (this.jdField_a_of_type_ComTencentMobileqqProfileViewVerticalSeekBar.a() - 77) / 255.0F;
        if ((!android.text.TextUtils.isEmpty((CharSequence)localObject1)) && (i2 != 0)) {
          i1 = 1600;
        } else {
          i1 = 160;
        }
        ProfileCardUtil.a(this.app, l1, i1, paramString2, ProfileCardUtil.a(paramString1), null, i2, (String)localObject1, (String)localObject2, f1, f2, f3, "", 0L);
      }
      else
      {
        ProfileCardUtil.a(this.app, l1, 160L, paramString2, ProfileCardUtil.a(paramString1), null);
      }
      this.jdField_f_of_type_JavaLangString = a();
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView;
      if (paramString1 == null) {
        i1 = 0;
      } else {
        i1 = paramString1.jdField_a_of_type_Int;
      }
      this.j = i1;
    }
  }
  
  void a(String paramString, boolean paramBoolean)
  {
    if (android.text.TextUtils.isEmpty(paramString))
    {
      QLog.e("VipProfileCardDiyActivity", 1, "uploadBackgroundToUps filePath is empty");
      return;
    }
    VipProfileCardDiyActivity.12 local12 = new VipProfileCardDiyActivity.12(this, Long.parseLong(this.app.getCurrentAccountUin()), paramString, VipUploadUtils.a(this.app), "qqprofile", paramString, paramBoolean);
    local12.b = VipUploadUtils.a(this.app);
    local12.i = VipUploadUtils.a(this.app, paramString);
    j();
    paramString = (VipImageUploadManager)this.app.getManager(QQManagerFactory.IMAGE_UPLOAD_MANAGER);
    paramString.a(this.app, null);
    local12.a();
    paramString.a(this.app, local12, null);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetEditText.getLayoutParams();
      localLayoutParams.bottomMargin = paramInt;
      this.jdField_a_of_type_AndroidWidgetEditText.setLayoutParams(localLayoutParams);
      VasWebviewUtil.a("", "card_mall", "0X8008112", "", 1, 0, 0, "", "", "");
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
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
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
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView = ((SoftInputDetectView)findViewById(2131376809));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)findViewById(2131378881));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369202));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369233));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131373100));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131378383));
    this.jdField_a_of_type_ComTencentMobileqqProfileViewHScrollView = ((HScrollView)findViewById(2131378382));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365890));
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout = ((SingleTouchLayout)findViewById(2131365892));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131365885));
    this.jdField_a_of_type_ComTencentMobileqqProfileViewVerticalSeekBar = ((VerticalSeekBar)findViewById(2131370021));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370699);
    this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView = new DiyTextView(this);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView;
    boolean bool = false;
    ((DiyTextView)localObject).setBackgroundColor(0);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.a(this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView);
    int i1 = AIOUtils.b(10.0F, this.jdField_a_of_type_AndroidContentResResources);
    this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView = new VipProfileCardDiyActivity.DiyDefaultTextView(this, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView.setTextColor(-1);
    this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView.setTextSize(18.0F);
    this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView.setPadding(i1, i1, i1, i1);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131377298));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365884));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131373037);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)findViewById(2131368780));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368795));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368790));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368788));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368789));
    this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView = ((VoteView)findViewById(2131380996));
    localObject = this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout;
    ((AvatarLayout)localObject).a(0, ((AvatarLayout)localObject).findViewById(2131363438), false);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.resetBkColor(0);
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
    localObject = this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView;
    if (ImmersiveUtils.isSupporImmersive() != 1) {
      bool = true;
    }
    ((SoftInputDetectView)localObject).setExcludeStatusBar(bool);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView.setOnImStateChangedListener(this);
    float f1 = this.jdField_a_of_type_Float;
    if (f1 > 1.4E-45F)
    {
      float f2 = this.jdField_b_of_type_Float;
      if (f2 > 1.4E-45F) {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setCenterPoint(f1, f2);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setImageScale(this.jdField_c_of_type_Float);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setImageDegree(this.jdField_d_of_type_Float);
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 2)
    {
      VasH5PayUtil.a(this, "mvip.g.a.mp_wz", 3, "1450000516", "CJCLUBT", getString(2131719393), "svipdiyCardH5Pay");
      return;
    }
    VasH5PayUtil.a(this, "mvip.g.a.mp_wz", 3, "1450000515", "LTMCLUB", getString(2131695078), "vipdiyCardH5Pay");
  }
  
  public void b(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setVisibility(8);
    this.jdField_a_of_type_Boolean = true;
    a("");
    c();
    VasWebviewUtil.a("", "card_mall", "0X800810F", "", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), "", "");
  }
  
  void b(String paramString)
  {
    l();
    int i2;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView != null) && (!android.text.TextUtils.isEmpty(a()))) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    boolean bool = VasUtil.a(this.app).getVipStatus().isSVip();
    String str2 = getString(2131695026);
    String str1 = paramString;
    if (android.text.TextUtils.isEmpty(paramString))
    {
      l1 = this.jdField_a_of_type_Long;
      if ((l1 != 0L) && (l1 != 160L) && (l1 != 1600L))
      {
        if (bool) {
          str1 = getString(2131695025);
        } else {
          str1 = getString(2131695022);
        }
      }
      else if (i2 != 0)
      {
        if (bool) {
          str1 = getString(2131695024);
        } else {
          str1 = getString(2131695022);
        }
      }
      else {
        str1 = getString(2131695023);
      }
    }
    long l1 = this.jdField_a_of_type_Long;
    int i3;
    if (((l1 == 0L) || (l1 == 160L)) && (bool)) {
      i3 = 2131695044;
    } else {
      i3 = 2131690728;
    }
    int i1;
    if (this.n == 2)
    {
      if (bool) {
        i1 = 2131695040;
      } else {
        i1 = 2131695037;
      }
    }
    else if (VasUtil.a(this.app).getVipStatus().isVip()) {
      i1 = 2131695041;
    } else {
      i1 = 2131695038;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 0, str2, str1, i3, i1, this.jdField_d_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_c_of_type_AndroidContentDialogInterface$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    if (i2 != 0)
    {
      if (bool) {
        paramString = "4";
      } else {
        paramString = "3";
      }
      VasWebviewUtil.a("", "card_mall", "0X80081C9", "", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), paramString, "");
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
  
  void c(String paramString)
  {
    ThreadManager.executeOnFileThread(new VipProfileCardDiyActivity.11(this, paramString));
  }
  
  void d()
  {
    boolean bool = android.text.TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString);
    int i2 = 0;
    int i1;
    if (bool)
    {
      localObject2 = ProfileCardManager.a(this, ProfileCardTemplate.PROFILE_CARD_STYLE_DIY, this.jdField_a_of_type_Long);
      localObject1 = new File((String)localObject2);
      if ((((File)localObject1).isFile()) && (((File)localObject1).exists()))
      {
        c((String)localObject2);
        i1 = 0;
      }
      else
      {
        i1 = 1;
      }
      if (i1 != 0)
      {
        localObject1 = ((VasExtensionManager)this.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a;
        this.jdField_g_of_type_JavaLangString = ((String)localObject2);
        localObject2 = this.app;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("card.");
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_Long);
        ((ProfileCardManager)localObject1).a((QQAppInterface)localObject2, ((StringBuilder)localObject3).toString());
      }
    }
    else
    {
      c(this.jdField_d_of_type_JavaLangString);
    }
    Object localObject1 = new LinearLayout.LayoutParams(AIOUtils.b(86.0F, this.jdField_a_of_type_AndroidContentResResources), AIOUtils.b(123.0F, this.jdField_a_of_type_AndroidContentResResources));
    ((LinearLayout.LayoutParams)localObject1).setMargins(0, AIOUtils.b(12.0F, this.jdField_a_of_type_AndroidContentResResources), AIOUtils.b(5.0F, this.jdField_a_of_type_AndroidContentResResources), AIOUtils.b(10.0F, this.jdField_a_of_type_AndroidContentResResources));
    Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
    Object localObject3 = VipProfileDiyCardConfig.jdField_a_of_type_AndroidUtilSparseArray;
    if (localObject3 == null)
    {
      VipProfileDiyCardConfig.a(this.app);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView);
      f();
    }
    if ((localObject3 != null) && (((SparseArray)localObject3).size() > 0))
    {
      this.jdField_f_of_type_Int = this.h;
      i1 = this.jdField_f_of_type_Int;
      if ((i1 <= 0) || (((SparseArray)localObject3).indexOfKey(i1) < 0)) {
        this.jdField_f_of_type_Int = ((SparseArray)localObject3).keyAt(0);
      }
      Object localObject4 = (String)((SparseArray)localObject3).get(this.jdField_f_of_type_Int);
      bool = a(this.jdField_f_of_type_Int);
      this.jdField_b_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView = new VipProfileCardDiyActivity.HiBoomTemplateView(this, this, this.jdField_f_of_type_Int, bool);
      localObject4 = URLDrawable.getDrawable((String)localObject4, (URLDrawable.URLDrawableOptions)localObject2);
      this.jdField_b_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.setImageDrawable((Drawable)localObject4);
      if ((this.jdField_a_of_type_Long != 0L) && ((!android.text.TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) || (this.jdField_g_of_type_Int != 1)))
      {
        this.jdField_b_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.setChecked(true);
        this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView = this.jdField_b_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView;
        this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView.setHiBoom(this.jdField_f_of_type_Int, 1, HiBoomConstants.a);
        this.jdField_b_of_type_Boolean = (bool ^ true);
        if (this.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_b_of_type_Int = 1;
        }
        if (!android.text.TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
          a(this.jdField_e_of_type_JavaLangString);
        } else {
          e();
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setVisibility(8);
        this.jdField_a_of_type_Boolean = true;
        e();
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView, (ViewGroup.LayoutParams)localObject1);
      i1 = i2;
      while (i1 < ((SparseArray)localObject3).size())
      {
        i2 = ((SparseArray)localObject3).keyAt(i1);
        if (i2 != this.jdField_f_of_type_Int)
        {
          localObject4 = (String)((SparseArray)localObject3).get(i2);
          VipProfileCardDiyActivity.HiBoomTemplateView localHiBoomTemplateView = new VipProfileCardDiyActivity.HiBoomTemplateView(this, this, i2, a(i2));
          localHiBoomTemplateView.setImageDrawable(URLDrawable.getDrawable((String)localObject4, (URLDrawable.URLDrawableOptions)localObject2));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localHiBoomTemplateView, (ViewGroup.LayoutParams)localObject1);
        }
        i1 += 1;
      }
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
  
  public void doOnBackPressed()
  {
    onClick(this.jdField_a_of_type_AndroidWidgetTextView);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    super.setContentView(2131561314);
    this.jdField_a_of_type_AndroidContentSharedPreferences = getSharedPreferences("vip_profile_diy_card", 0);
    this.jdField_a_of_type_ComTencentMobileqqDataCard = ProfileCardUtil.a(this.app, this.app.getCurrentAccountUin());
    this.jdField_a_of_type_AndroidContentResResources = super.getResources();
    paramBundle = this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics();
    this.jdField_d_of_type_Int = paramBundle.widthPixels;
    this.jdField_e_of_type_Int = paramBundle.heightPixels;
    this.jdField_a_of_type_Int = AIOUtils.b(130.0F, this.jdField_a_of_type_AndroidContentResResources);
    a();
    this.jdField_c_of_type_Int = AIOUtils.b(5.0F, this.jdField_a_of_type_AndroidContentResResources);
    this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemApiIVasQuickUpdateService = ((IVasQuickUpdateService)this.app.getRuntimeService(IVasQuickUpdateService.class, ""));
    this.jdField_a_of_type_ComTencentMobileqqHiboomApiIHiBoomManager = ((IVasService)this.app.getRuntimeService(IVasService.class, "")).getHiBoomManager();
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    b();
    ((IVasQuickUpdateService)this.app.getRuntimeService(IVasQuickUpdateService.class, "")).addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker);
    d();
    VasWebviewUtil.a("", "card_mall", "0X800810D", "", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), "", String.valueOf(this.jdField_a_of_type_Long));
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
    ((IVasQuickUpdateService)this.app.getRuntimeService(IVasQuickUpdateService.class, "")).removeCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker);
  }
  
  @TargetApi(9)
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      if (!this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("vip_diy_card_guide_shown", false))
      {
        if (this.jdField_a_of_type_AndroidWidgetPopupWindow == null)
        {
          View localView = getLayoutInflater().inflate(2131561313, null);
          Button localButton = (Button)localView.findViewById(2131363965);
          this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131367911));
          this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131367903));
          localButton.setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(localView, -1, -1);
          this.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(true);
          this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        }
        if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (this.jdField_b_of_type_AndroidGraphicsBitmap != null))
          {
            this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(9);
            return;
          }
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          ThreadManager.executeOnFileThread(new VipProfileCardDiyActivity.2(this));
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("vip_diy_card_edit_guide_shown", false);
      }
    }
  }
  
  void e()
  {
    long l1 = this.jdField_a_of_type_Long;
    if ((l1 != 0L) && (l1 != 160L) && (l1 != 1600L))
    {
      if (!android.text.TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        a(this.jdField_c_of_type_JavaLangString);
      }
    }
    else {
      a(VipProfileDiyCardConfig.jdField_a_of_type_JavaLangString);
    }
  }
  
  void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.a();
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.invalidate();
  }
  
  void g()
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    long l1 = ProfileCardTemplate.PROFILE_CARD_STYLE_SIMPLE;
    long l2 = this.jdField_a_of_type_Long;
    Object localObject;
    if (l2 == 0L)
    {
      if (a())
      {
        localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_d_of_type_JavaLangString);
        if (!android.text.TextUtils.isEmpty((CharSequence)localObject))
        {
          a(this.jdField_d_of_type_JavaLangString, (String)localObject, true);
          return;
        }
        a(this.jdField_d_of_type_JavaLangString, true);
      }
    }
    else
    {
      if ((l2 != 160L) && (l2 != 1600L))
      {
        if (android.text.TextUtils.isEmpty(a()))
        {
          o();
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView;
          if (localObject == null) {
            localObject = "";
          } else {
            localObject = String.valueOf(((VipProfileCardDiyActivity.HiBoomTemplateView)localObject).jdField_a_of_type_Int);
          }
          VasWebviewUtil.a("", "card_mall", "0X80081C2", "", 1, 0, 0, "", "1", (String)localObject);
          return;
        }
        a(l1, this.jdField_a_of_type_Long, true);
        return;
      }
      if ((a()) && (!android.text.TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
        a(ProfileCardManager.a(this, ProfileCardTemplate.PROFILE_CARD_STYLE_DIY, this.jdField_a_of_type_Long), this.jdField_b_of_type_JavaLangString, true);
      }
    }
  }
  
  void h()
  {
    try
    {
      if (!isFinishing())
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131695132);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  @TargetApi(9)
  public boolean handleMessage(Message paramMessage)
  {
    if (!isFinishing())
    {
      if (this.jdField_d_of_type_Boolean) {
        return false;
      }
      Object localObject;
      switch (paramMessage.what)
      {
      default: 
        return false;
      case 9: 
        paramMessage = this.jdField_a_of_type_AndroidGraphicsBitmap;
        if ((paramMessage != null) && (this.jdField_b_of_type_AndroidGraphicsBitmap != null))
        {
          localObject = this.jdField_b_of_type_AndroidWidgetImageView;
          if ((localObject != null) && (this.jdField_c_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow != null))
          {
            ((ImageView)localObject).setImageBitmap(paramMessage);
            this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap);
            this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView, 80, 0, 0);
            this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setVisibility(8);
            this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("vip_diy_card_guide_shown", true).apply();
            return false;
          }
        }
        break;
      case 8: 
        localObject = String.format(getString(2131695048), new Object[] { Integer.valueOf(VipProfileDiyCardConfig.jdField_a_of_type_Int) });
        paramMessage = (String)paramMessage.obj;
        if (android.text.TextUtils.isEmpty(paramMessage)) {
          paramMessage = (Message)localObject;
        }
        QQToast.a(this, 1, paramMessage, 0).a();
        return false;
      case 7: 
        localObject = getString(2131695034);
        paramMessage = (String)paramMessage.obj;
        if (android.text.TextUtils.isEmpty(paramMessage)) {
          paramMessage = (Message)localObject;
        }
        QQToast.a(this, 1, paramMessage, 0).a();
        return false;
      case 6: 
        i();
        k();
        return false;
      case 5: 
        localObject = (View)paramMessage.obj;
        if (paramMessage.arg1 == 0)
        {
          if (localObject != null)
          {
            ((View)localObject).setVisibility(8);
            return false;
          }
        }
        else
        {
          if (localObject != null)
          {
            paramMessage = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
            paramMessage.bottomMargin = 0;
            ((View)localObject).setLayoutParams(paramMessage);
          }
          QQToast.a(this, 1, 2131695033, 0).a();
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView;
          if (paramMessage != null) {
            if ((paramMessage.jdField_a_of_type_Int == this.jdField_f_of_type_Int) && (this.jdField_b_of_type_Boolean))
            {
              if (this.h == -1)
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.setChecked(false);
                b(null);
              }
              else
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.setChecked(false);
              }
            }
            else {
              this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.setChecked(false);
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView, this.jdField_a_of_type_Int);
          return false;
        }
        break;
      case 4: 
        localObject = (View)paramMessage.obj;
        if (localObject != null)
        {
          FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
          localLayoutParams.bottomMargin = paramMessage.arg1;
          ((View)localObject).setLayoutParams(localLayoutParams);
          return false;
        }
        break;
      case 3: 
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        return false;
      case 2: 
        b((String)paramMessage.obj);
        return false;
      case 1: 
        if (!android.text.TextUtils.isEmpty((String)paramMessage.obj))
        {
          QQToast.a(this, (String)paramMessage.obj, 0).a();
          return false;
        }
        QQToast.a(this, 2131695045, 0).a();
        return false;
      case 0: 
        paramMessage = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getProfileCardIntentOnly(this, null);
        if (this.jdField_g_of_type_Int == 1)
        {
          setResult(-1, paramMessage);
        }
        else
        {
          paramMessage.putExtra("AllInOne", new AllInOne(this.app.getCurrentAccountUin(), 0));
          paramMessage.putExtra("diyTextEditResult", true);
          startActivity(paramMessage);
        }
        finish();
      }
    }
    return false;
  }
  
  void i()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      label23:
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label23;
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
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131690840);
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  void k()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      label23:
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label23;
    }
  }
  
  void l()
  {
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  void m()
  {
    n();
    boolean bool = android.text.TextUtils.isEmpty(a()) ^ true;
    int i1;
    if (bool) {
      i1 = 2131695042;
    } else {
      i1 = 2131695032;
    }
    String str = getString(i1);
    if (bool) {
      i1 = 2131695036;
    } else {
      i1 = 2131695031;
    }
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, str, i1, 2131695030, this.jdField_f_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_e_of_type_AndroidContentDialogInterface$OnClickListener);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    if (bool) {
      str = "1";
    } else {
      str = "0";
    }
    VasWebviewUtil.a("", "card_mall", "0X80081C9", "", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), str, "");
  }
  
  void n()
  {
    QQCustomDialog localQQCustomDialog = this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.dismiss();
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  void o()
  {
    n();
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, getString(2131695035), 2131695027, 2131695043, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    VasWebviewUtil.a("", "card_mall", "0X80081C9", "", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), "2", "");
  }
  
  public void onClick(View paramView)
  {
    int i2 = paramView.getId();
    Object localObject2 = "";
    int i1 = 0;
    Object localObject1;
    switch (i2)
    {
    default: 
      break;
    case 2131377298: 
      g();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView != null) {
        i1 = 1;
      }
      boolean bool1 = android.text.TextUtils.isEmpty(a()) ^ true;
      if (i1 != 0)
      {
        if (bool1) {
          localObject1 = "2";
        } else {
          localObject1 = "1";
        }
      }
      else if (bool1) {
        localObject1 = "";
      } else {
        localObject1 = "0";
      }
      if (i1 != 0) {
        localObject2 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_a_of_type_Int);
      }
      VasWebviewUtil.a("", "card_mall", "0X8008116", "", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), (String)localObject1, (String)localObject2);
      break;
    case 2131369233: 
      this.jdField_b_of_type_Int = 2;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695028);
      if (android.text.TextUtils.isEmpty(a())) {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setVisibility(8);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setEditable(false);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVerticalSeekBar.setVisibility(8);
      InputMethodUtil.a(this);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if (android.text.TextUtils.isEmpty(this.jdField_d_of_type_AndroidWidgetTextView.getText()))
      {
        this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setFaceDrawable(this.app, 1, this.app.getCurrentAccountUin(), 200, true, true, true, false, 3);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataCard.strNick);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(String.format("%s岁", new Object[] { Byte.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataCard.age) }));
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.shGender == 1) {}
        for (i1 = 2131716250;; i1 = 2131716255)
        {
          localObject1 = HardCodeUtil.a(i1);
          break label394;
          if (this.jdField_a_of_type_ComTencentMobileqqDataCard.shGender != 0) {
            break;
          }
        }
        localObject1 = "";
        this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        localObject1 = localObject2;
        if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.strCountry))
        {
          localObject1 = localObject2;
          if (!HardCodeUtil.a(2131716249).equals(this.jdField_a_of_type_ComTencentMobileqqDataCard.strCountry))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("");
            ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqDataCard.strCountry);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
        }
        localObject2 = localObject1;
        if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.strProvince))
        {
          localObject2 = localObject1;
          if (!android.text.TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append("，");
            localObject2 = ((StringBuilder)localObject2).toString();
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqDataCard.strProvince);
          localObject2 = ((StringBuilder)localObject1).toString();
        }
        localObject1 = localObject2;
        if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.strCity))
        {
          localObject1 = localObject2;
          if (!android.text.TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append("，");
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqDataCard.strCity);
          localObject1 = ((StringBuilder)localObject2).toString();
        }
        this.jdField_g_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView;
        boolean bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.bVoted == 1) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        ((VoteView)localObject1).a(true, bool2, (int)this.jdField_a_of_type_ComTencentMobileqqDataCard.lVoteCount, this.jdField_a_of_type_ComTencentMobileqqDataCard.iVoteIncrement, null, false);
      }
      VasWebviewUtil.a("", "card_mall", "0X80081CB", "", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), "", "");
      break;
    case 2131369202: 
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
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690707);
        VasWebviewUtil.a("", "card_mall", "0X800820F", "", 1, 0, 0, "", "", "");
      }
      else
      {
        m();
        VasWebviewUtil.a("", "card_mall", "0X800810E", "", 1, 0, 0, "", "", "");
      }
      break;
    case 2131365890: 
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Int == 1))
      {
        long l1 = this.jdField_a_of_type_Long;
        if ((l1 != 0L) && (l1 != 160L) && (l1 != 1600L)) {
          a(this.jdField_c_of_type_JavaLangString);
        } else {
          a(VipProfileDiyCardConfig.jdField_a_of_type_JavaLangString);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView == null)
        {
          localObject1 = this.jdField_b_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView;
          if (localObject1 != null) {
            ((VipProfileCardDiyActivity.HiBoomTemplateView)localObject1).performClick();
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setVisibility(0);
        f();
        this.jdField_a_of_type_Boolean = false;
        if (this.h == -1)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView;
          if ((localObject1 != null) && (((VipProfileCardDiyActivity.HiBoomTemplateView)localObject1).jdField_a_of_type_Int == this.jdField_f_of_type_Int) && (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_b_of_type_Int == 0))
          {
            this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView.setHiBoom(this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_a_of_type_Int, 1, HiBoomConstants.a);
            this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView.jdField_b_of_type_Int = 1;
          }
        }
        VasWebviewUtil.a("", "card_mall", "0X8008113", "", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), "", "");
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
        if (this.jdField_b_of_type_Int != 2) {
          this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setEditable(true);
        }
        InputMethodUtil.a(this);
      }
      break;
    case 2131363965: 
      label394:
      localObject1 = this.jdField_a_of_type_AndroidWidgetPopupWindow;
      if (localObject1 != null)
      {
        ((PopupWindow)localObject1).dismiss();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView != null) {
          this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setVisibility(0);
        }
      }
      break;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
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
    int i1;
    if (paramInt > 77) {
      i1 = -16777216;
    } else {
      i1 = -1;
    }
    paramSeekBar.setBackgroundColor(i1);
    this.jdField_a_of_type_AndroidViewView.getBackground().setAlpha(Math.abs(paramInt - 77));
    this.i = paramInt;
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.k = this.jdField_a_of_type_ComTencentMobileqqProfileViewVerticalSeekBar.a();
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewVerticalSeekBar.a() - this.k > 0) {
      str = "1";
    } else {
      str = "0";
    }
    VasWebviewUtil.a("", "card_mall", "0X80081CC", "", 1, 0, 0, "", str, "");
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramCharSequence = com.tencent.mobileqq.text.TextUtils.getStringWithoutEmoji(paramCharSequence.toString());
    boolean bool;
    if (!android.text.TextUtils.isEmpty(paramCharSequence))
    {
      this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView.setText(paramCharSequence);
      this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView.setText(paramCharSequence);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$HiBoomTemplateView == null) {
        bool = this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView, this.jdField_a_of_type_Int);
      } else {
        bool = this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.a(this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView);
      }
      if (bool) {
        f();
      }
    }
    else
    {
      bool = this.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView.setText(" ");
      this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity$DiyDefaultTextView.setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VipProfileCardDiyActivity
 * JD-Core Version:    0.7.0.1
 */