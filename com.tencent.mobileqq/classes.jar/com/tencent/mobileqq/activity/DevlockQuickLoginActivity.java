package com.tencent.mobileqq.activity;

import Override;
import addb;
import addc;
import addf;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import azjv;
import bcef;
import bfur;
import bhht;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.qrcode.activity.QRLoginAuthActivity;
import com.tencent.ims.devlock_verify_scheme.SchemePkg;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;
import yyi;

public class DevlockQuickLoginActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 1;
  private addf jdField_a_of_type_Addf;
  Handler jdField_a_of_type_AndroidOsHandler = new addb(this);
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  bhht jdField_a_of_type_Bhht;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  String jdField_a_of_type_JavaLangString;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new addc(this);
  byte[] jdField_a_of_type_ArrayOfByte = null;
  int jdField_b_of_type_Int = 1;
  Button jdField_b_of_type_AndroidWidgetButton;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString;
  byte[] jdField_b_of_type_ArrayOfByte;
  int jdField_c_of_type_Int = 2;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString;
  int d = 0;
  int e = 0;
  
  private void d()
  {
    Object localObject3 = getString(2131691897);
    Object localObject6 = getString(2131716176);
    Object localObject4 = getString(2131716177);
    Object localObject1 = null;
    Object localObject20 = null;
    Object localObject18 = null;
    Object localObject19 = null;
    Object localObject7 = null;
    Object localObject17 = null;
    Object localObject15 = null;
    Object localObject16 = null;
    int i = 1;
    int i8 = 1;
    int i6 = 1;
    int j = 1;
    int i5 = 1;
    int i7 = 1;
    int i9 = 0;
    int i3 = 0;
    int i4 = 0;
    int i2 = 0;
    devlock_verify_scheme.SchemePkg localSchemePkg;
    int m;
    int n;
    int i1;
    Object localObject9;
    Object localObject10;
    Object localObject12;
    Object localObject13;
    Object localObject14;
    int k;
    if (this.jdField_a_of_type_ArrayOfByte != null)
    {
      localSchemePkg = new devlock_verify_scheme.SchemePkg();
      m = i3;
      n = j;
      i1 = i8;
      localObject9 = localObject17;
      localObject10 = localObject20;
      localObject12 = localObject4;
      localObject13 = localObject6;
      localObject14 = localObject3;
      try
      {
        localSchemePkg.mergeFrom(this.jdField_a_of_type_ArrayOfByte);
        i = 1;
        m = i3;
        n = j;
        i1 = i8;
        localObject9 = localObject17;
        localObject10 = localObject20;
        localObject12 = localObject4;
        localObject13 = localObject6;
        localObject14 = localObject3;
        if (localSchemePkg.u32_verify_type.has())
        {
          m = i3;
          n = j;
          i1 = i8;
          localObject9 = localObject17;
          localObject10 = localObject20;
          localObject12 = localObject4;
          localObject13 = localObject6;
          localObject14 = localObject3;
          i = localSchemePkg.u32_verify_type.get();
        }
        k = i9;
        n = i7;
        m = i6;
        localObject14 = localObject7;
        localObject13 = localObject1;
        localObject12 = localObject4;
        localObject9 = localObject6;
        localObject10 = localObject3;
        if (i == 2)
        {
          i = 1;
          m = i3;
          n = j;
          i1 = i8;
          localObject9 = localObject17;
          localObject10 = localObject20;
          localObject12 = localObject4;
          localObject13 = localObject6;
          localObject14 = localObject3;
          if (localSchemePkg.u32_use_local_scheme.has())
          {
            m = i3;
            n = j;
            i1 = i8;
            localObject9 = localObject17;
            localObject10 = localObject20;
            localObject12 = localObject4;
            localObject13 = localObject6;
            localObject14 = localObject3;
            i = localSchemePkg.u32_use_local_scheme.get();
          }
          k = i9;
          n = i7;
          m = i6;
          localObject14 = localObject7;
          localObject13 = localObject1;
          localObject12 = localObject4;
          localObject9 = localObject6;
          localObject10 = localObject3;
          if (i == 0)
          {
            localObject1 = localObject3;
            m = i3;
            n = j;
            i1 = i8;
            localObject9 = localObject17;
            localObject10 = localObject20;
            localObject12 = localObject4;
            localObject13 = localObject6;
            localObject14 = localObject3;
            if (localSchemePkg.str_title.has())
            {
              m = i3;
              n = j;
              i1 = i8;
              localObject9 = localObject17;
              localObject10 = localObject20;
              localObject12 = localObject4;
              localObject13 = localObject6;
              localObject14 = localObject3;
              localObject1 = localSchemePkg.str_title.get();
            }
            localObject3 = localObject6;
            m = i3;
            n = j;
            i1 = i8;
            localObject9 = localObject17;
            localObject10 = localObject20;
            localObject12 = localObject4;
            localObject13 = localObject6;
            localObject14 = localObject1;
            if (localSchemePkg.str_text.has())
            {
              m = i3;
              n = j;
              i1 = i8;
              localObject9 = localObject17;
              localObject10 = localObject20;
              localObject12 = localObject4;
              localObject13 = localObject6;
              localObject14 = localObject1;
              localObject3 = localSchemePkg.str_text.get();
            }
            localObject7 = localObject4;
            localObject6 = localObject4;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
      {
        for (;;)
        {
          try
          {
            boolean bool;
            label601:
            localObject7 = localSchemePkg.str_button2_caption.get();
            k = 1;
            m = k;
            n = j;
            i1 = i;
            localObject9 = localObject7;
            localObject10 = localObject6;
            localObject12 = localObject4;
            localObject13 = localObject3;
            localObject14 = localObject1;
            if (localSchemePkg.u32_button2_auth.has())
            {
              m = k;
              n = j;
              i1 = i;
              localObject9 = localObject7;
              localObject10 = localObject6;
              localObject12 = localObject4;
              localObject13 = localObject3;
              localObject14 = localObject1;
              this.d = localSchemePkg.u32_button2_auth.get();
            }
            m = k;
            n = j;
            i1 = i;
            localObject9 = localObject7;
            localObject10 = localObject6;
            localObject12 = localObject4;
            localObject13 = localObject3;
            localObject14 = localObject1;
            i2 = this.e;
            n = j;
            m = i;
            localObject14 = localObject7;
            localObject13 = localObject6;
            localObject12 = localObject4;
            localObject9 = localObject3;
            localObject10 = localObject1;
            if (i2 == 0)
            {
              k = 0;
              localObject10 = localObject1;
              localObject9 = localObject3;
              localObject12 = localObject4;
              localObject13 = localObject6;
              localObject14 = localObject7;
              m = i;
              n = j;
            }
            j = k;
            k = n;
            localObject1 = localObject14;
            localObject3 = localObject13;
            localObject4 = localObject12;
            localObject6 = localObject9;
            i = m;
            setTitle(localObject10);
            localObject9 = this.jdField_a_of_type_AndroidWidgetTextView;
            if (this.app != null)
            {
              localObject7 = this.app.getCurrentNickname();
              ((TextView)localObject9).setText((CharSequence)localObject7);
              this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject6);
              if (i == 0) {
                continue;
              }
            }
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException3)
          {
            k = 1;
            localObject9 = localObject15;
            localObject14 = localObject2;
            localObject2 = localInvalidProtocolBufferMicroException3;
            continue;
          }
          try
          {
            if (((String)localObject4).startsWith(getString(2131698071)))
            {
              bcef.b(null, "dc00898", "", "", "0X800AE02", "0X800AE02", 0, 0, "", "", "", "");
              this.jdField_a_of_type_Addf = new addf(new WeakReference(this), new WeakReference(this.jdField_c_of_type_AndroidWidgetTextView));
              azjv.a().a(this.jdField_a_of_type_Addf);
              this.jdField_c_of_type_AndroidWidgetTextView.setText(azjv.a().a((String)localObject4, this.app, this));
              this.jdField_c_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
              if (k == 0) {
                continue;
              }
              localObject4 = localObject3;
              if (TextUtils.isEmpty((CharSequence)localObject3))
              {
                if (this.jdField_b_of_type_Int != 1) {
                  continue;
                }
                localObject4 = getString(2131691896);
              }
              this.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject4);
              if (this.jdField_c_of_type_Int != 2) {
                continue;
              }
              this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839326);
              this.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this, 2131755085);
              if (j == 0) {
                continue;
              }
              localObject3 = localObject1;
              if (TextUtils.isEmpty((CharSequence)localObject1))
              {
                if (this.d != 1) {
                  continue;
                }
                localObject3 = getString(2131691896);
              }
              this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
              this.jdField_b_of_type_AndroidWidgetButton.setText((CharSequence)localObject3);
              if (this.e != 2) {
                continue;
              }
              this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130839326);
              this.jdField_b_of_type_AndroidWidgetButton.setTextAppearance(this, 2131755085);
              return;
              j = 0;
              localObject6 = localObject19;
              continue;
              localInvalidProtocolBufferMicroException1 = localInvalidProtocolBufferMicroException1;
              localObject3 = localObject13;
              localObject4 = localObject12;
              localObject6 = localObject10;
              i = i1;
              j = n;
              k = m;
              localInvalidProtocolBufferMicroException1.printStackTrace();
              m = j;
              localObject2 = localObject9;
              localObject7 = localObject6;
              localObject6 = localObject3;
              localObject10 = localObject14;
              j = k;
              k = m;
              localObject3 = localObject7;
              continue;
              localObject7 = "";
              continue;
            }
            this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject4);
            continue;
          }
          catch (Exception localException)
          {
            QLog.e("DevlockQuickLoginActivity", 1, "mSmallTipView.setText error: " + localException.getMessage());
            continue;
          }
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          continue;
          localObject5 = getString(2131716204);
          continue;
          if (this.jdField_c_of_type_Int == 3)
          {
            this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839343);
            this.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this, 2131755088);
          }
          else if (this.jdField_c_of_type_Int == 1)
          {
            this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839365);
            this.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this, 2131755091);
            continue;
            this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            continue;
            localObject3 = getString(2131716204);
            continue;
            if (this.e == 3)
            {
              this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130839343);
              this.jdField_b_of_type_AndroidWidgetButton.setTextAppearance(this, 2131755088);
              return;
            }
            if (this.e == 1)
            {
              this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130839365);
              this.jdField_b_of_type_AndroidWidgetButton.setTextAppearance(this, 2131755091);
              return;
            }
          }
        }
      }
      try
      {
        if (!localSchemePkg.str_subtext.has()) {
          break label1826;
        }
        localObject7 = localObject4;
        localObject4 = localSchemePkg.str_subtext.get();
        localObject7 = localObject4;
        bool = TextUtils.isEmpty((CharSequence)localObject4);
        localObject6 = localObject4;
        if (bool) {
          break label1826;
        }
        i = 1;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException4)
      {
        i = 0;
        k = i4;
        j = i5;
        localObject9 = localObject15;
        localObject6 = localObject18;
        localObject5 = localObject7;
        localObject14 = localObject2;
        localObject2 = localInvalidProtocolBufferMicroException4;
        break label1480;
        i = 0;
        localObject5 = localObject6;
        break label601;
      }
      m = i3;
      n = j;
      i1 = i;
      localObject9 = localObject17;
      localObject10 = localObject20;
      localObject12 = localObject4;
      localObject13 = localObject3;
      localObject14 = localObject1;
      if (localSchemePkg.u32_button1_type.has())
      {
        m = i3;
        n = j;
        i1 = i;
        localObject9 = localObject17;
        localObject10 = localObject20;
        localObject12 = localObject4;
        localObject13 = localObject3;
        localObject14 = localObject1;
        this.jdField_c_of_type_Int = localSchemePkg.u32_button1_type.get();
      }
      m = i3;
      n = j;
      i1 = i;
      localObject9 = localObject17;
      localObject10 = localObject20;
      localObject12 = localObject4;
      localObject13 = localObject3;
      localObject14 = localObject1;
      if (localSchemePkg.str_button1_caption.has())
      {
        m = i3;
        n = j;
        i1 = i;
        localObject9 = localObject17;
        localObject10 = localObject20;
        localObject12 = localObject4;
        localObject13 = localObject3;
        localObject14 = localObject1;
        localObject6 = localSchemePkg.str_button1_caption.get();
        j = 1;
      }
      try
      {
        if (localSchemePkg.u32_button1_auth.has()) {
          this.jdField_b_of_type_Int = localSchemePkg.u32_button1_auth.get();
        }
        k = this.jdField_c_of_type_Int;
        if (k != 0) {
          break label1823;
        }
        j = 0;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
      {
        for (;;)
        {
          k = i4;
          localObject9 = localObject15;
          localObject14 = localObject2;
          localObject2 = localInvalidProtocolBufferMicroException2;
        }
      }
      m = i3;
      n = j;
      i1 = i;
      localObject9 = localObject17;
      localObject10 = localObject6;
      localObject12 = localObject4;
      localObject13 = localObject3;
      localObject14 = localObject1;
      if (localSchemePkg.u32_button2_type.has())
      {
        m = i3;
        n = j;
        i1 = i;
        localObject9 = localObject17;
        localObject10 = localObject6;
        localObject12 = localObject4;
        localObject13 = localObject3;
        localObject14 = localObject1;
        this.e = localSchemePkg.u32_button2_type.get();
      }
      m = i3;
      n = j;
      i1 = i;
      localObject9 = localObject17;
      localObject10 = localObject6;
      localObject12 = localObject4;
      localObject13 = localObject3;
      localObject14 = localObject1;
      bool = localSchemePkg.str_button2_caption.has();
      k = i2;
      localObject7 = localObject16;
      if (!bool) {}
    }
    for (;;)
    {
      label1480:
      Object localObject5;
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      return;
      label1823:
      label1826:
      j = 0;
      k = 1;
      Object localObject2 = null;
      Object localObject8 = null;
      Object localObject11 = localObject3;
      localObject3 = localObject8;
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener)
  {
    a();
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(this, 230).setTitle(paramString1).setMessage(paramString2);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(paramString3, paramOnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void b()
  {
    Object localObject1 = yyi.a(this.app.getOnlineStauts());
    Object localObject2 = ByteBuffer.allocate(localObject1.length + 4);
    ((ByteBuffer)localObject2).putShort((short)2);
    ((ByteBuffer)localObject2).putShort((short)localObject1.length);
    ((ByteBuffer)localObject2).put((byte[])localObject1);
    Object localObject3 = ((ByteBuffer)localObject2).array();
    localObject1 = this.app.getCurrentAccountUin();
    Object localObject4 = this.app.getUinDisplayNameBeforeLogin((String)localObject1);
    localObject2 = new ArrayList();
    if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (!((String)localObject4).equals(localObject1)))
    {
      localObject4 = ((String)localObject4).getBytes();
      ByteBuffer localByteBuffer = ByteBuffer.allocate(localObject4.length + 4);
      localByteBuffer.putShort((short)1);
      localByteBuffer.putShort((short)localObject4.length);
      localByteBuffer.put((byte[])localObject4);
      localObject4 = localByteBuffer.array();
      localByteBuffer = ByteBuffer.allocate(localObject4.length + 4);
      localByteBuffer.putShort((short)4);
      localByteBuffer.putShort((short)localObject4.length);
      localByteBuffer.put((byte[])localObject4);
      localObject4 = localByteBuffer.array();
      ((ArrayList)localObject2).add(HexUtil.bytes2HexStr((byte[])localObject3));
      ((ArrayList)localObject2).add(HexUtil.bytes2HexStr((byte[])localObject4));
      localObject3 = ByteBuffer.allocate(8);
      ((ByteBuffer)localObject3).putShort((short)21);
      ((ByteBuffer)localObject3).putShort((short)4);
      if (this.jdField_a_of_type_Int != 2) {
        break label311;
      }
    }
    label311:
    for (int i = 1;; i = 0)
    {
      ((ByteBuffer)localObject3).putInt(i);
      ((ArrayList)localObject2).add(HexUtil.bytes2HexStr(((ByteBuffer)localObject3).array()));
      if (QLog.isColorLevel()) {
        QLog.d("DevlockQuickLoginActivity", 2, "confirmLogin start CloseCode..");
      }
      ((WtloginManager)this.app.getManager(1)).closeCode((String)localObject1, 16L, this.jdField_b_of_type_ArrayOfByte, 1, (ArrayList)localObject2, this.jdField_a_of_type_MqqObserverWtloginObserver);
      return;
      ((ArrayList)localObject2).add(HexUtil.bytes2HexStr((byte[])localObject3));
      break;
    }
  }
  
  public void c()
  {
    try
    {
      if ((this.jdField_a_of_type_Bhht != null) && (this.jdField_a_of_type_Bhht.isShowing()))
      {
        this.jdField_a_of_type_Bhht.dismiss();
        this.jdField_a_of_type_Bhht.cancel();
      }
      this.jdField_a_of_type_Bhht = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
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
  
  public boolean onBackEvent()
  {
    super.finish();
    super.overridePendingTransition(0, 2130772001);
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    switch (i)
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      super.finish();
      super.overridePendingTransition(0, 2130772001);
      continue;
      if (!NetworkUtil.isNetSupport(this))
      {
        QQToast.a(this, super.getString(2131692035), 0).b(super.getTitleBarHeight());
        continue;
      }
      if ((this.app == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DevlockQuickLoginActivity", 2, "requestQRLogin qrCodeString is empty");
        }
        QQToast.a(super.getApplicationContext(), 1, super.getString(2131691900), 0).b(getTitleBarHeight());
        super.finish();
        super.overridePendingTransition(0, 2130772001);
        continue;
      }
      int j = this.jdField_a_of_type_JavaLangString.indexOf("?k=") + 3;
      if (j < 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DevlockQuickLoginActivity", 2, "requestQRLogin qrCodeString  error");
        }
        QQToast.a(super.getApplicationContext(), 1, super.getString(2131691900), 0).b(getTitleBarHeight());
        super.finish();
        super.overridePendingTransition(0, 2130772001);
        continue;
      }
      String str = this.jdField_a_of_type_JavaLangString.substring(j, j + 32);
      this.jdField_b_of_type_ArrayOfByte = QRLoginAuthActivity.a(str.getBytes(), str.length());
      str = this.app.getCurrentAccountUin();
      try
      {
        if ((this.jdField_a_of_type_Bhht == null) && (!super.isFinishing()))
        {
          this.jdField_a_of_type_Bhht = new bhht(this, super.getTitleBarHeight());
          this.jdField_a_of_type_Bhht.c(2131694279);
        }
        if ((this.jdField_a_of_type_Bhht != null) && (!this.jdField_a_of_type_Bhht.isShowing())) {
          this.jdField_a_of_type_Bhht.show();
        }
        if (QLog.isColorLevel()) {
          QLog.d("DevlockQuickLoginActivity", 2, "requestQRLogin start verifyCode..");
        }
        if (i == 2131364988)
        {
          i = this.jdField_b_of_type_Int;
          this.jdField_a_of_type_Int = i;
          WtloginManager localWtloginManager = (WtloginManager)this.app.getManager(1);
          byte[] arrayOfByte = this.jdField_b_of_type_ArrayOfByte;
          WtloginObserver localWtloginObserver = this.jdField_a_of_type_MqqObserverWtloginObserver;
          localWtloginManager.verifyCode(str, 16L, true, arrayOfByte, new int[] { 5 }, 1, localWtloginObserver);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
          continue;
          i = this.d;
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
  
  public void onCreate(Bundle paramBundle)
  {
    super.setTheme(2131755575);
    super.onCreate(paramBundle);
    super.setContentView(2131561040);
    this.leftView.setVisibility(4);
    super.setRightButton(2131690768, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131366245));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131371772));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131378674));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131378675));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131364988));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131378277));
    paramBundle = super.getIntent();
    if (paramBundle != null)
    {
      this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("qrcode");
      this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("maintip");
      this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("smalltip");
      this.jdField_a_of_type_ArrayOfByte = paramBundle.getByteArrayExtra("loginConfig");
    }
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (QLog.isColorLevel()) {
      QLog.d("DevlockQuickLoginActivity", 2, "onCreate qrCodeSting=" + this.jdField_a_of_type_JavaLangString + " mainTip=" + this.jdField_b_of_type_JavaLangString + " smallTip=" + this.jdField_c_of_type_JavaLangString);
    }
    ThreadManager.post(new DevlockQuickLoginActivity.2(this), 5, null, false);
    d();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Addf != null) {
      azjv.a().a();
    }
    c();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("qrcode");
      this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("maintip");
      this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("smalltip");
      this.jdField_a_of_type_ArrayOfByte = paramIntent.getByteArrayExtra("loginConfig");
      if (QLog.isColorLevel()) {
        QLog.d("DevlockQuickLoginActivity", 2, "onNewIntent qrCodeSting=" + this.jdField_a_of_type_JavaLangString + " mainTip=" + this.jdField_b_of_type_JavaLangString + " smallTip=" + this.jdField_c_of_type_JavaLangString);
      }
      d();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("DevlockQuickLoginActivity", 2, "onNewIntent intent is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DevlockQuickLoginActivity
 * JD-Core Version:    0.7.0.1
 */