package com.tencent.mobileqq.apollo.store;

import aepi;
import akpl;
import akrb;
import akrd;
import aldt;
import algj;
import alud;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import apkq;
import bddf;
import bdgk;
import bety;
import bhtd;
import bhuf;
import bhuk;
import bhup;
import bjev;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class ApolloImageShareLayout
  extends RelativeLayout
  implements akrb, akrd, DialogInterface.OnDismissListener, Handler.Callback, View.OnClickListener, AdapterView.OnItemClickListener, bhuk
{
  private float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  bety jdField_a_of_type_Bety;
  bhtd jdField_a_of_type_Bhtd = new bhtd(Looper.getMainLooper(), this);
  private bhuf jdField_a_of_type_Bhuf;
  private bhup jdField_a_of_type_Bhup;
  ApolloTextureView jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView;
  private String jdField_a_of_type_JavaLangString = "apollo_fakeurl";
  private WeakReference<AppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt;
  int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private int jdField_e_of_type_Int;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private int f;
  private int g;
  
  public ApolloImageShareLayout(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  @TargetApi(14)
  private Bitmap a()
  {
    Bitmap localBitmap = null;
    try
    {
      if (Build.VERSION.SDK_INT >= 14) {
        localBitmap = this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getBitmap();
      }
      return localBitmap;
    }
    catch (Exception localException)
    {
      QLog.e("ApolloImageShareLayout", 2, localException.getMessage());
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("ApolloImageShareLayout", 2, localOutOfMemoryError.getMessage());
    }
    return null;
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl() != null))
    {
      if (!paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a();
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, null, this.jdField_c_of_type_Int, this.jdField_a_of_type_Float, this.jdField_a_of_type_Int / bdgk.a() / 2.0F * 1.05F, 0.0F);
        if ((this.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfInt.length > 0)) {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, null, this.jdField_a_of_type_ArrayOfInt, null);
        }
      }
      String[] arrayOfString = algj.a(5, -1, this.jdField_c_of_type_Int, true);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, null, 5, 1000000, arrayOfString[0], arrayOfString[1]);
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_Bhuf != null) {
      this.jdField_a_of_type_Bhuf.dismiss();
    }
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {}
    do
    {
      return;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(bhup.a(1));
      localArrayList.add(bhup.a(0));
      if (this.jdField_a_of_type_Bhup == null) {
        this.jdField_a_of_type_Bhup = new bhup(this.jdField_a_of_type_AndroidAppActivity);
      }
      this.jdField_a_of_type_Bhup.a(localArrayList);
      if (this.jdField_a_of_type_Bhuf == null) {
        this.jdField_a_of_type_Bhuf = bhup.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Bhup, this, this, this, false);
      }
    } while ((this.jdField_a_of_type_Bhuf == null) || (this.jdField_a_of_type_Bhuf.isShowing()));
    this.jdField_a_of_type_Bhuf.show();
  }
  
  public void a(int paramInt1, int paramInt2, AppInterface paramAppInterface, int paramInt3, int[] paramArrayOfInt, float paramFloat)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    this.jdField_a_of_type_Float = paramFloat;
    super.setBackgroundColor(-1778384896);
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      super.setClickable(true);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(getContext());
      this.jdField_e_of_type_Int = ((int)(aepi.a(296.0F, getResources()) * 0.96F));
      this.f = (this.jdField_e_of_type_Int * 880 / 592);
      paramAppInterface = new RelativeLayout.LayoutParams(this.jdField_e_of_type_Int, this.f);
      paramAppInterface.addRule(14);
      paramAppInterface.addRule(10);
      paramInt3 = paramInt2;
      if (paramInt2 == 0) {
        paramInt3 = (int)bdgk.j();
      }
      paramInt2 = paramInt1;
      if (paramInt1 == 0) {
        paramInt2 = (int)bdgk.i();
      }
      paramInt1 = (paramInt3 - ImmersiveUtils.getStatusBarHeight(super.getContext()) - this.f) / 2;
      paramAppInterface.topMargin = paramInt1;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setDrawingCacheEnabled(true);
      super.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, paramAppInterface);
      int i = this.f * 272 / 880;
      this.jdField_a_of_type_Int = ((int)(368.0F * paramFloat));
      this.jdField_b_of_type_Int = ((int)(368.0F * paramFloat * 1.3F));
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = new ApolloTextureView(getContext(), null);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.init(this);
      paramAppInterface = new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      paramAppInterface.addRule(10);
      paramAppInterface.addRule(14);
      this.jdField_d_of_type_Int = (this.f - this.jdField_b_of_type_Int - i);
      paramAppInterface.topMargin = (this.jdField_d_of_type_Int + paramInt1);
      super.addView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView, paramAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRender().setRenderCallback(this);
      this.g = (this.jdField_d_of_type_Int + paramInt1 + this.jdField_b_of_type_Int / 2);
      i = (int)(aepi.a(40.0F, getResources()) * 0.96F);
      this.jdField_e_of_type_AndroidWidgetImageView = new ImageView(getContext());
      this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundResource(2130838343);
      paramAppInterface = new RelativeLayout.LayoutParams(i, i);
      paramAppInterface.addRule(14, -1);
      paramAppInterface.addRule(12, -1);
      paramAppInterface.bottomMargin = ((paramInt3 - ImmersiveUtils.getStatusBarHeight(super.getContext()) - this.f - paramInt1 - i) / 2);
      this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
      super.addView(this.jdField_e_of_type_AndroidWidgetImageView, paramAppInterface);
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(18.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth((int)(this.jdField_e_of_type_Int * 0.8F));
      this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      paramAppInterface = new RelativeLayout.LayoutParams(-2, -2);
      paramAppInterface.topMargin = ((int)(aepi.a(40.0F, getResources()) * 0.96F));
      paramAppInterface.addRule(10);
      paramAppInterface.addRule(14);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, paramAppInterface);
      paramAppInterface = new View(super.getContext());
      paramArrayOfInt = new RelativeLayout.LayoutParams(this.jdField_e_of_type_Int, (int)(aepi.a(55.0F, super.getResources()) * 0.96F));
      paramArrayOfInt.addRule(10);
      paramArrayOfInt.addRule(14);
      paramArrayOfInt.topMargin = ((int)(this.f + paramInt1 - aepi.a(55.0F, super.getResources()) * 0.96F));
      paramAppInterface.setBackgroundResource(2130838354);
      super.addView(paramAppInterface, paramArrayOfInt);
      paramInt3 = (int)(aepi.a(25.0F, getResources()) * 0.96F);
      paramFloat = aepi.a(41.0F, super.getResources()) * 0.96F;
      float f1 = (this.jdField_e_of_type_Int - 2.0F * paramFloat) / 3.0F;
      this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(getContext());
      paramAppInterface = new RelativeLayout.LayoutParams(paramInt3, paramInt3);
      paramAppInterface.topMargin = ((int)(this.f + paramInt1 - aepi.a(42.0F, super.getResources()) * 0.96F));
      paramAppInterface.leftMargin = ((int)((paramInt2 - this.jdField_e_of_type_Int) / 2 + paramFloat - paramInt3 / 2));
      paramAppInterface.addRule(10);
      paramAppInterface.addRule(9);
      super.addView(this.jdField_b_of_type_AndroidWidgetImageView, paramAppInterface);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130838494);
      this.jdField_d_of_type_AndroidWidgetImageView = new ImageView(getContext());
      paramAppInterface = new RelativeLayout.LayoutParams(paramInt3, paramInt3);
      paramAppInterface.topMargin = ((int)(this.f + paramInt1 - aepi.a(42.0F, super.getResources()) * 0.96F));
      paramAppInterface.leftMargin = ((int)((paramInt2 - this.jdField_e_of_type_Int) / 2 + paramFloat + f1 - paramInt3 / 2));
      paramAppInterface.addRule(10);
      paramAppInterface.addRule(9);
      super.addView(this.jdField_d_of_type_AndroidWidgetImageView, paramAppInterface);
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130838492);
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
      paramAppInterface = new RelativeLayout.LayoutParams(paramInt3, paramInt3);
      paramAppInterface.topMargin = ((int)(this.f + paramInt1 - aepi.a(42.0F, super.getResources()) * 0.96F));
      paramAppInterface.rightMargin = ((int)(f1 + ((paramInt2 - this.jdField_e_of_type_Int) / 2 + paramFloat) - paramInt3 / 2));
      paramAppInterface.addRule(10);
      paramAppInterface.addRule(11);
      super.addView(this.jdField_a_of_type_AndroidWidgetImageView, paramAppInterface);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838493);
      this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(getContext());
      paramAppInterface = new RelativeLayout.LayoutParams(paramInt3, paramInt3);
      paramAppInterface.topMargin = ((int)(paramInt1 + this.f - 0.96F * aepi.a(42.0F, super.getResources())));
      paramAppInterface.rightMargin = ((int)((paramInt2 - this.jdField_e_of_type_Int) / 2 + paramFloat - paramInt3 / 2));
      paramAppInterface.addRule(10);
      paramAppInterface.addRule(11);
      super.addView(this.jdField_c_of_type_AndroidWidgetImageView, paramAppInterface);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130838495);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.stopLoopDelayed(0L);
    }
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(int paramInt, int[] paramArrayOfInt, float paramFloat, String paramString1, String paramString2)
  {
    super.setVisibility(0);
    this.jdField_b_of_type_JavaLangString = paramString2;
    if ((paramInt != this.jdField_c_of_type_Int) || (paramArrayOfInt != this.jdField_a_of_type_ArrayOfInt) || (paramFloat != this.jdField_a_of_type_Float))
    {
      this.jdField_c_of_type_Int = paramInt;
      this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
      this.jdField_a_of_type_Float = paramFloat;
      b(false);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString2)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
      }
      if ((paramString1 != null) && (!paramString1.equals(this.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_JavaLangString = paramString1;
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          this.jdField_a_of_type_JavaLangString = "https://cmshow.qq.com/qqshow/admindata/comdata/vipApollo_mall_share_background/sha1.61aa8c34c1eefb6207b65e500da2f5eb.png";
        }
        paramArrayOfInt = URLDrawable.URLDrawableOptions.obtain();
        paramArrayOfInt.mRequestHeight = this.f;
        paramArrayOfInt.mRequestWidth = this.jdField_e_of_type_Int;
        paramString1 = new apkq(-8305182, 20.0F, this.jdField_e_of_type_Int, this.f);
        paramArrayOfInt.mLoadingDrawable = paramString1;
        paramArrayOfInt.mFailedDrawable = paramString1;
        paramArrayOfInt = aldt.a(Utils.Crc64String(this.jdField_a_of_type_JavaLangString), paramArrayOfInt, this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(paramArrayOfInt);
      }
      VipUtils.a(null, "cmshow", "Apollo", "PageView", 2, 0, new String[0]);
      return;
      b(true);
    }
  }
  
  void a(String paramString)
  {
    if (this.jdField_a_of_type_Bety == null) {
      this.jdField_a_of_type_Bety = new bety(this.jdField_a_of_type_AndroidAppActivity, this.g);
    }
    this.jdField_a_of_type_Bety.a(paramString);
    this.jdField_a_of_type_Bety.show();
  }
  
  public void a(boolean paramBoolean)
  {
    super.setVisibility(8);
    if (paramBoolean)
    {
      super.removeAllViews();
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl() != null)) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().c();
      }
    }
    this.jdField_a_of_type_Bhtd.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Bhuf != null) {
      this.jdField_a_of_type_Bhuf.dismiss();
    }
    b();
  }
  
  void b()
  {
    if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {
      this.jdField_a_of_type_Bety.dismiss();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    b();
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
                        do
                        {
                          do
                          {
                            return false;
                          } while (super.getVisibility() != 0);
                          paramMessage = (String)paramMessage.obj;
                        } while (TextUtils.isEmpty(paramMessage));
                        QQToast.a(getContext(), alud.a(2131700780) + paramMessage, 1).a();
                        return false;
                        if (this.jdField_a_of_type_Bhuf != null) {
                          this.jdField_a_of_type_Bhuf.dismiss();
                        }
                      } while ((super.getVisibility() != 0) || (this.jdField_a_of_type_JavaLangRefWeakReference == null));
                      localObject = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
                    } while (localObject == null);
                    paramMessage = (String)paramMessage.obj;
                    if (!TextUtils.isEmpty(paramMessage)) {
                      break;
                    }
                  } while (!QLog.isColorLevel());
                  QLog.e("ApolloImageShareLayout", 1, "onItemClick share QZone apolloImage no file");
                  return false;
                  Bundle localBundle = new Bundle();
                  ArrayList localArrayList = new ArrayList();
                  try
                  {
                    localArrayList.add(URLDecoder.decode(paramMessage));
                    localBundle.putStringArrayList("images", localArrayList);
                    localBundle.putString("summary", alud.a(2131700782));
                    localBundle.putInt("req_type", 7);
                    localBundle.putBoolean("key_need_save_draft", false);
                    bjev.a((AppInterface)localObject, this.jdField_a_of_type_AndroidAppActivity, localBundle, this, 15);
                    return false;
                  }
                  catch (Exception paramMessage)
                  {
                    QLog.d("ApolloImageShareLayout", 2, "publishToQzone:" + paramMessage.getMessage());
                    return false;
                  }
                  if (this.jdField_a_of_type_Bhuf != null) {
                    this.jdField_a_of_type_Bhuf.dismiss();
                  }
                } while (super.getVisibility() != 0);
                paramMessage = (String)paramMessage.obj;
                if (!TextUtils.isEmpty(paramMessage)) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.e("ApolloImageShareLayout", 1, "onItemClick share QQ apolloImage no file");
              return false;
              if (new File(paramMessage).exists()) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.e("ApolloImageShareLayout", 1, "onItemClick share QQ apolloImage no file");
            return false;
          } while (this.jdField_a_of_type_AndroidAppActivity == null);
          ApolloUtil.a(this.jdField_a_of_type_AndroidAppActivity, paramMessage, null, 1);
          return false;
        } while (super.getVisibility() != 0);
        paramMessage = (String)paramMessage.obj;
        if (!TextUtils.isEmpty(paramMessage)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("ApolloImageShareLayout", 1, "update avatar share QQ apolloImage no file");
      return false;
      if (new File(paramMessage).exists()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ApolloImageShareLayout", 1, "update avatar share QQ apolloImage no file");
    return false;
    int i = bddf.b(this.jdField_a_of_type_AndroidAppActivity);
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("keyFromUpdateAvatar", true);
    ((Intent)localObject).putExtra("Business_Origin", 100);
    PhotoUtils.a((Intent)localObject, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getClass().getName(), i, i, 1080, 1080, paramMessage, bddf.a());
    return false;
  }
  
  @TargetApi(14)
  public void onClick(View paramView)
  {
    long l;
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
    {
      l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_Long >= 800L) {}
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Long = l;
        if (this.jdField_a_of_type_Boolean)
        {
          QQToast.a(getContext(), alud.a(2131700779), 0).a();
          return;
        }
        this.jdField_a_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloImageShareLayout", 2, "download Request:" + l);
        }
        if (Build.VERSION.SDK_INT >= 14)
        {
          a(alud.a(2131700778));
          ThreadManager.executeOnSubThread(new ApolloImageShareLayout.SaveImageTask(this, a(), this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getWidth(), this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getHeight(), 15, l));
        }
        VipUtils.a(null, "cmshow", "Apollo", "SaveClick", 0, 0, new String[0]);
        return;
        if (paramView == this.jdField_b_of_type_AndroidWidgetImageView)
        {
          if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl() != null))
          {
            paramView = algj.a(5, -1, this.jdField_c_of_type_Int, true);
            this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, null, 5, 1000000, paramView[0], paramView[1]);
          }
          VipUtils.a(null, "cmshow", "Apollo", "PoseClick", 0, 0, new String[0]);
          return;
        }
        if (paramView == this.jdField_c_of_type_AndroidWidgetImageView)
        {
          a();
          VipUtils.a(null, "cmshow", "Apollo", "ShareClick", 0, 0, new String[0]);
          return;
        }
        if (paramView == this.jdField_e_of_type_AndroidWidgetImageView)
        {
          VipUtils.a(null, "cmshow", "Apollo", "CloseClick", 0, 0, new String[0]);
          a(false);
          return;
        }
      } while (paramView != this.jdField_d_of_type_AndroidWidgetImageView);
      l = System.currentTimeMillis();
    } while (l - this.jdField_b_of_type_Long < 800L);
    this.jdField_b_of_type_Long = l;
    if (this.jdField_a_of_type_Boolean)
    {
      QQToast.a(getContext(), alud.a(2131700776), 0).a();
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    VipUtils.a(null, "cmshow", "Apollo", "headClick", 0, 0, new String[0]);
    a(alud.a(2131700777));
    ThreadManager.executeOnSubThread(new ApolloImageShareLayout.SaveImageTask(this, a(), this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getWidth(), this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getHeight(), 18, System.currentTimeMillis()));
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
  
  @TargetApi(14)
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_c_of_type_Long < 2000L) {
      return;
    }
    this.jdField_c_of_type_Long = l;
    if (paramLong == 1L)
    {
      if (Build.VERSION.SDK_INT >= 14)
      {
        a(alud.a(2131700775));
        ThreadManager.executeOnSubThread(new ApolloImageShareLayout.SaveImageTask(this, a(), this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getWidth(), this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getHeight(), 16, l));
      }
      VipUtils.a(null, "cmshow", "Apollo", "Share2Qzone", 0, 0, new String[0]);
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      a(alud.a(2131700781));
      ThreadManager.executeOnSubThread(new ApolloImageShareLayout.SaveImageTask(this, a(), this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getWidth(), this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getHeight(), 17, l));
    }
    VipUtils.a(null, "cmshow", "Apollo", "Share2QQ", 0, 0, new String[0]);
  }
  
  public void onNotifyLongTouch(String paramString) {}
  
  public void onNotifyStatusChanged(int paramInt, String paramString) {}
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_c_of_type_Int > 0) {
      b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloImageShareLayout
 * JD-Core Version:    0.7.0.1
 */