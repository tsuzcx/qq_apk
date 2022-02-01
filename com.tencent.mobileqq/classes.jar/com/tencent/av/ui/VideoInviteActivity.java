package com.tencent.av.ui;

import Override;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aquy;
import axfr;
import bdll;
import bhlq;
import bhnv;
import bhpc;
import bhrl;
import bhxi;
import biki;
import bjfr;
import blir;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQLSUnlockActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.vipav.VipFullScreenVideoView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import lcb;
import lcj;
import ldc;
import lef;
import lff;
import lfg;
import lfh;
import lfl;
import lia;
import lic;
import lie;
import lkg;
import lkh;
import lwe;
import lzq;
import mat;
import mbb;
import mia;
import mkl;
import mkn;
import mkp;
import mkq;
import mkr;
import mks;
import mku;
import mkv;
import mky;
import mkz;
import mla;
import mlg;
import mlh;
import mlj;
import mnl;
import mqq.app.BaseActivity;
import mrl;
import mrr;
import mrs;
import mtd;
import mtn;
import mtr;
import mur;
import mvd;
import mvi;

public class VideoInviteActivity
  extends BaseActivity
{
  public static int b;
  public static int c;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  AudioManager jdField_a_of_type_AndroidMediaAudioManager = null;
  public ImageButton a;
  public ImageView a;
  public RelativeLayout a;
  public TextView a;
  public VideoAppInterface a;
  public QavPanel a;
  public VipFullScreenVideoView a;
  Runnable jdField_a_of_type_JavaLangRunnable = new VideoInviteActivity.7(this);
  public final String a;
  public WeakReference<Activity> a;
  lef jdField_a_of_type_Lef = new mkn(this);
  public lff a;
  lfl jdField_a_of_type_Lfl = new mkv(this);
  private lkh jdField_a_of_type_Lkh = new lkh();
  mat jdField_a_of_type_Mat;
  public mia a;
  public mlg a;
  mtn jdField_a_of_type_Mtn = null;
  mvi jdField_a_of_type_Mvi;
  public boolean a;
  byte[] jdField_a_of_type_ArrayOfByte = null;
  long jdField_b_of_type_Long = -1L;
  public ImageButton b;
  public TextView b;
  Runnable jdField_b_of_type_JavaLangRunnable = new VideoInviteActivity.8(this);
  String jdField_b_of_type_JavaLangString = null;
  public boolean b;
  long jdField_c_of_type_Long = -1L;
  TextView jdField_c_of_type_AndroidWidgetTextView = null;
  public String c;
  public boolean c;
  public int d;
  long d;
  public String d;
  public boolean d;
  public int e;
  public String e;
  public boolean e;
  int jdField_f_of_type_Int = 0;
  String jdField_f_of_type_JavaLangString;
  boolean jdField_f_of_type_Boolean = false;
  int jdField_g_of_type_Int = 0;
  boolean jdField_g_of_type_Boolean = true;
  public int h;
  public boolean h;
  public int i;
  public boolean i;
  public int j;
  public boolean j;
  final int jdField_k_of_type_Int = 0;
  boolean jdField_k_of_type_Boolean = false;
  final int l;
  public boolean l;
  public boolean m = false;
  boolean n = false;
  
  static
  {
    jdField_b_of_type_Int = 60000;
    jdField_c_of_type_Int = 50000;
  }
  
  public VideoInviteActivity()
  {
    this.jdField_a_of_type_Lff = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_h_of_type_Int = 0;
    this.jdField_i_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
    this.jdField_a_of_type_ComTencentAvUiQavPanel = null;
    this.jdField_a_of_type_Mia = null;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_j_of_type_Int = 0;
    this.jdField_l_of_type_Int = 1;
    long l1 = AudioHelper.b();
    this.jdField_a_of_type_JavaLangString = (getClass().getSimpleName() + "_" + l1);
    this.jdField_d_of_type_Long = l1;
    b("VideoInviteActivity");
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    if (biki.a(this, this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView, paramString, paramInt1, null, paramInt2, false))
    {
      a(true);
      ImmersiveUtils.a(false, getWindow());
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "sendIsResumeBroadcast isResume = " + paramBoolean);
    }
    lzq.a(BaseApplicationImpl.getContext(), paramBoolean);
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Mtn == null) {
      this.jdField_a_of_type_Mtn = mtn.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    if (mrl.a()) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QAVNotification", 2, "updateInviteNotification show[" + paramBoolean + "], mIsAudioMode[" + this.jdField_b_of_type_Boolean + "], isOnlyAudio[" + this.jdField_a_of_type_Lff.S + "], session[" + this.jdField_a_of_type_Lff + "]");
      }
      if (paramBoolean)
      {
        Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, true, true);
        this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(this.jdField_e_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
        if (this.jdField_a_of_type_Lff.S)
        {
          this.jdField_a_of_type_Mtn.a(true, this.jdField_a_of_type_Lff.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, localBitmap, null, 45, this.jdField_e_of_type_Int, 1);
          return;
        }
        this.jdField_a_of_type_Mtn.a(true, this.jdField_a_of_type_Lff.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, localBitmap, null, 40, this.jdField_e_of_type_Int, 2);
        return;
      }
      this.jdField_a_of_type_Mtn.a(this.jdField_a_of_type_Lff.jdField_c_of_type_JavaLangString);
      return;
      paramBoolean = true;
    }
  }
  
  public void BtnOnClick(View paramView)
  {
    if (this.jdField_a_of_type_Mlg != null) {
      this.jdField_a_of_type_Mlg.BtnOnClick(paramView);
    }
  }
  
  blir a(Context paramContext)
  {
    paramContext = new mkz(this, paramContext);
    paramContext.getWindow().setWindowAnimations(2131755227);
    return paramContext;
  }
  
  public VideoController a()
  {
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
  }
  
  public void a()
  {
    int i1 = 0;
    if ((this.jdField_a_of_type_Lff == null) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.m)) {}
    int i2;
    do
    {
      int i3;
      String str;
      do
      {
        do
        {
          return;
          i2 = mnl.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_c_of_type_JavaLangString, false, this.jdField_b_of_type_Boolean);
        } while (i2 == 0);
        i3 = bhnv.a(BaseApplicationImpl.getContext());
        if ((i3 == 4) || (i3 == 1)) {
          i1 = 1;
        }
        i3 = biki.a();
        str = biki.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, i2, biki.a(), null);
      } while (TextUtils.isEmpty(str));
      this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = biki.a(this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
      File localFile = new File(str);
      if ((localFile != null) && (localFile.exists()))
      {
        a(str, i3, i2);
        return;
      }
    } while (i1 == 0);
    this.jdField_j_of_type_Int = i2;
    mnl.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, i2);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int == paramInt) {
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
      mbb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1040, 2131695338);
      continue;
      mbb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1040, 2131695333);
      continue;
      mbb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1040, 2131695335);
    }
  }
  
  public void a(long paramLong)
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "stopRing, mLastPlayRingTime[" + this.jdField_a_of_type_Long + "->" + 0 + "]");
    this.jdField_a_of_type_Long = 0L;
    if (mur.a() != null) {
      mur.a().b(paramLong);
    }
  }
  
  public void a(long paramLong, Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (paramContext = a(paramContext);; paramContext = blir.a(paramContext))
    {
      paramContext.b(2131695052);
      paramContext.b(2131695054);
      paramContext.b(2131695053);
      if (d()) {
        paramContext.b(2131695051);
      }
      paramContext.c(2131690580);
      paramContext.a(new mkp(this, paramBoolean));
      paramContext.a(new mkq(this, paramContext, paramBoolean, paramLong));
      paramContext.show();
      return;
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "refuseVideoRequest", new Throwable("refuseVideoRequest"));
    }
    this.jdField_d_of_type_Boolean = false;
    mur.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if ((this.jdField_l_of_type_Boolean) && (this.jdField_a_of_type_Mia != null) && (!this.jdField_j_of_type_Boolean)) {
      this.jdField_a_of_type_Mia.a(new mkr(this, paramLong, paramBoolean));
    }
    do
    {
      return;
      if (this.jdField_i_of_type_Boolean)
      {
        a().a(paramLong, this.jdField_c_of_type_JavaLangString, 1, true);
        long l1 = mrs.a(this.jdField_c_of_type_JavaLangString);
        a().a(paramLong, 3, l1);
        this.jdField_h_of_type_Boolean = true;
        a().a(paramLong, l1, 1);
        this.jdField_e_of_type_Boolean = true;
        super.finish();
        return;
      }
      a().a(paramLong, this.jdField_c_of_type_JavaLangString, 1, false);
      a().a(this.jdField_c_of_type_JavaLangString, 249);
      a().b(249);
    } while (!paramBoolean);
    a().b(this.jdField_c_of_type_JavaLangString, 1);
  }
  
  public void a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    label266:
    for (;;)
    {
      return;
      if (mtr.a(paramIntent)) {
        bdll.b(null, "dc00898", "", "", "0X800A2C5", "0X800A2C5", 0, 0, "", "", "", "");
      }
      long l1 = AudioHelper.b();
      String str1 = paramIntent.getAction();
      String str2;
      if ("com.tencent.qav.notify.accept".equals(str1))
      {
        str2 = paramIntent.getStringExtra("session_id");
        if (this.jdField_a_of_type_Lff == null)
        {
          paramIntent = null;
          if (!TextUtils.equals(str2, paramIntent)) {
            break label194;
          }
          c(l1);
          label98:
          bdll.b(null, "dc00898", "", "", "0X800A2C6", "0X800A2C6", 0, 0, "", "", "", "");
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label266;
        }
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "checkParamAndDoAction action[" + str1 + "], seq[" + l1 + "]");
        return;
        paramIntent = this.jdField_a_of_type_Lff.jdField_c_of_type_JavaLangString;
        break;
        label194:
        if (!QLog.isColorLevel()) {
          break label98;
        }
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "checkParamAndDoAction not same , coming[" + str2 + "], cur[" + paramIntent + "]");
        break label98;
        if ("com.tencent.qav.notify.refuse".equals(str1)) {
          a(l1, true);
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    boolean bool = VideoController.a(this);
    int i1;
    Object localObject;
    if (bool)
    {
      i1 = 1;
      if (QLog.isColorLevel())
      {
        String str = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder().append("checkAndSwitchMode isLocked[").append(bool).append("], mode[").append(i1).append("], cur[");
        if (this.jdField_a_of_type_Mlg != null) {
          break label135;
        }
        localObject = "null";
        label70:
        QLog.i(str, 2, localObject + "], destroy[" + this.m + "], from[" + paramString + "]");
      }
      b("checkAndSwitchMode");
      if (!this.m) {
        break label150;
      }
    }
    label135:
    label150:
    do
    {
      do
      {
        return;
        i1 = 2;
        break;
        localObject = Integer.valueOf(this.jdField_a_of_type_Mlg.a());
        break label70;
        if (this.jdField_a_of_type_Mlg == null)
        {
          b(bool);
          return;
        }
      } while (i1 == this.jdField_a_of_type_Mlg.a());
      paramString = this.jdField_a_of_type_Mlg;
      this.jdField_a_of_type_Mlg.j();
      b(bool);
      this.jdField_a_of_type_Mlg.a(paramString);
      if (this.jdField_k_of_type_Boolean)
      {
        this.jdField_a_of_type_Mlg.d();
        this.jdField_a_of_type_Mlg.a();
      }
    } while (!this.jdField_l_of_type_Boolean);
    this.jdField_a_of_type_Mlg.g();
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(super.getResources().getColor(2131166020));
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(super.getResources().getColor(2131166020));
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(super.getResources().getColor(2131166020));
      }
      if (this.jdField_a_of_type_Mat != null)
      {
        this.jdField_a_of_type_Mat.a(super.getResources().getColor(2131166020));
        this.jdField_a_of_type_Mat.b(-1291845633);
      }
    }
    do
    {
      return;
      if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-11113603);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#566B7D"));
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#566B7D"));
      }
    } while (this.jdField_a_of_type_Mat == null);
    this.jdField_a_of_type_Mat.a(-11113603);
    this.jdField_a_of_type_Mat.b(-11113603);
  }
  
  boolean a()
  {
    boolean bool4 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    Object localObject = super.getIntent();
    if ((localObject != null) && (!mtr.a((Intent)localObject)))
    {
      this.jdField_c_of_type_JavaLangString = ((Intent)localObject).getStringExtra("peerUin");
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
      {
        bool1 = bool3;
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_a_of_type_JavaLangString, 2, "initVideoParam uin is empty!");
        }
      }
      for (bool1 = bool3;; bool1 = true)
      {
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.i(this.jdField_a_of_type_JavaLangString, 2, "initVideoParam fromIntent peer[" + this.jdField_c_of_type_JavaLangString + "], uinType[" + this.jdField_e_of_type_Int + "], audioMode[" + this.jdField_b_of_type_Boolean + "], ret[" + bool1 + "]");
          bool2 = bool1;
        }
        return bool2;
        this.jdField_e_of_type_Int = ((Intent)localObject).getIntExtra("uinType", 0);
        this.jdField_e_of_type_JavaLangString = ((Intent)localObject).getStringExtra("extraUin");
        this.jdField_d_of_type_Int = ((Intent)localObject).getIntExtra("curUserStatus", 0);
        this.jdField_b_of_type_Boolean = ((Intent)localObject).getBooleanExtra("isAudioMode", false);
        this.jdField_c_of_type_Boolean = ((Intent)localObject).getBooleanExtra("powerKey", false);
        this.jdField_g_of_type_Boolean = ((Intent)localObject).getBooleanExtra("isPlayRing", true);
        this.jdField_i_of_type_Boolean = ((Intent)localObject).getBooleanExtra("isDoubleVideoMeeting", false);
      }
    }
    localObject = lcb.a().a();
    boolean bool1 = bool4;
    if (localObject != null)
    {
      this.jdField_e_of_type_Int = ((lff)localObject).jdField_j_of_type_Int;
      this.jdField_c_of_type_JavaLangString = ((lff)localObject).jdField_d_of_type_JavaLangString;
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        break label399;
      }
      bool1 = bool4;
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "initVideoParam uin is empty!");
      }
    }
    for (bool1 = bool4;; bool1 = true)
    {
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "initVideoParam from Session peer[" + this.jdField_c_of_type_JavaLangString + "], uinType[" + this.jdField_e_of_type_Int + "], audioMode[" + this.jdField_b_of_type_Boolean + "], ret[" + bool1 + "]");
      return bool1;
      label399:
      this.jdField_e_of_type_Int = ((lff)localObject).jdField_j_of_type_Int;
      this.jdField_e_of_type_JavaLangString = ((lff)localObject).jdField_f_of_type_JavaLangString;
      this.jdField_d_of_type_Int = a().a();
      this.jdField_b_of_type_Boolean = ((lff)localObject).S;
      bool1 = bool2;
      if (((lff)localObject).jdField_a_of_type_Lfg.jdField_b_of_type_Int <= 0) {
        if (((lff)localObject).jdField_a_of_type_Lfh.jdField_a_of_type_Int != 0)
        {
          bool1 = bool2;
          if (((lff)localObject).jdField_a_of_type_Lfh.jdField_a_of_type_Long > 0L) {}
        }
        else
        {
          bool1 = true;
        }
      }
      this.jdField_g_of_type_Boolean = bool1;
      this.jdField_i_of_type_Boolean = ((lff)localObject).J;
    }
  }
  
  public void b()
  {
    k();
    this.jdField_a_of_type_Mat = new mat();
    this.jdField_a_of_type_Mat.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_Int = 1;
    if ((!bhnv.h(super.getApplicationContext())) && (!bhnv.f(super.getApplicationContext()))) {
      this.jdField_a_of_type_Int = 2;
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363105));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363094));
    if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_f_of_type_JavaLangString);
      mvd.a(this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_f_of_type_JavaLangString);
      if (this.jdField_i_of_type_Boolean) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      }
    }
  }
  
  public void b(long paramLong)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
    {
      localObject = null;
      boolean bool = mrl.b((String)localObject);
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "playRing avCallBtnState[" + bool + "], seq[" + paramLong + "]");
      }
      if (bool) {
        break label86;
      }
    }
    label86:
    label237:
    do
    {
      long l1;
      do
      {
        return;
        localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
        break;
        if (!mtd.b(this)) {
          break label469;
        }
        if ((this.jdField_c_of_type_Boolean) || (!this.jdField_g_of_type_Boolean)) {
          break label237;
        }
        l1 = System.currentTimeMillis();
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "playRing, mIsRingPlaying[" + this.jdField_a_of_type_Long + "->" + l1 + "], seq[" + paramLong + "]");
      } while (this.jdField_a_of_type_Long != 0L);
      this.jdField_a_of_type_Long = l1;
      mur.a().b(paramLong);
      if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp() == null))
      {
        this.jdField_b_of_type_Long = 0L;
        if (this.jdField_b_of_type_Long != 0L) {
          break label275;
        }
        mur.a().a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230742, -1, null);
      }
      for (;;)
      {
        mur.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false, paramLong);
        return;
        this.jdField_b_of_type_Long = biki.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount(), 3, false, this.jdField_c_of_type_JavaLangString);
        break;
        localObject = bhxi.a(this.jdField_b_of_type_Long, 3);
        if (new File((String)localObject).exists())
        {
          mur.a().b(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0, (String)localObject, -1, null);
          bdll.b(null, "CliOper", "", "", "0X8005004", "0X8005004", 0, 0, "", this.jdField_b_of_type_Long + "", "", "");
        }
        else
        {
          mur.a().a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230742, -1, null);
          if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp() != null))
          {
            localObject = new Intent();
            ((Intent)localObject).setAction("tencent.video.v2q.commingRingDownload");
            ((Intent)localObject).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
            ((Intent)localObject).putExtra("comming_ring_down_key", this.jdField_b_of_type_Long);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast((Intent)localObject);
          }
        }
      }
    } while (!mtd.a(this));
    label275:
    label469:
    mur.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false, paramLong);
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TraceLogForAV", 2, "traceLog from[" + paramString + "], seq[" + this.jdField_d_of_type_Long + "], mode[" + this.jdField_a_of_type_Mlg + "]");
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (this.jdField_a_of_type_Mlg = new mlj(this);; this.jdField_a_of_type_Mlg = new mlh(this))
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "initVideoInviteUI isLocked[" + paramBoolean + "]");
      }
      return;
    }
  }
  
  boolean b()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)super.getAppRuntime());
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_Mvi = new mvi(super.getApplicationContext(), 1, "video wifi lock");
      return true;
    }
    return false;
  }
  
  @TargetApi(16)
  void c()
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    try
    {
      KeyguardManager localKeyguardManager = (KeyguardManager)super.getSystemService("keyguard");
      if ((localKeyguardManager != null) && (localKeyguardManager.isKeyguardLocked()))
      {
        boolean bool = localKeyguardManager.isKeyguardSecure();
        if (bool) {
          return;
        }
      }
      super.startActivity(new Intent(super.getApplicationContext(), QQLSUnlockActivity.class));
      return;
    }
    catch (SecurityException localSecurityException) {}
  }
  
  public void c(long paramLong)
  {
    if (!c()) {
      return;
    }
    boolean bool;
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean))
    {
      bool = true;
      label24:
      if (!ChatActivityUtils.a(this, bool, new mks(this, paramLong, bool))) {
        break label117;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "acceptVideoRequest");
      }
      d();
      sendBroadcast(new Intent("tencent.video.v2g.exitAVGame"));
      if ((!a().jdField_e_of_type_Boolean) && (!a().l())) {
        break label119;
      }
      i();
    }
    for (;;)
    {
      mur.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      a(paramLong);
      return;
      bool = false;
      break label24;
      label117:
      break;
      label119:
      e();
    }
  }
  
  protected boolean c()
  {
    if (this.jdField_a_of_type_Mvi == null) {
      this.jdField_a_of_type_Mvi = new mvi(super.getApplicationContext(), 1, "video wifi lock");
    }
    if ((mtd.e(super.getApplicationContext())) && (this.jdField_a_of_type_Mvi != null)) {
      this.jdField_a_of_type_Mvi.a();
    }
    return true;
  }
  
  public void d()
  {
    sendBroadcast(new Intent("tencent.video.v2nearbyV.exit"));
    if (QLog.isColorLevel()) {
      QLog.d("nearby.video.multiMsg", 2, "exitNearbyVideo");
    }
  }
  
  boolean d()
  {
    return (!bhrl.a(super.getApplicationContext())) || (Build.VERSION.SDK_INT >= 16);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startVideoChatActivity");
    }
    mur.a().a();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    if (a().m) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(113) });
    }
    Intent localIntent = new Intent(super.getApplicationContext(), AVActivity.class);
    localIntent.addFlags(262144);
    if (this.jdField_i_of_type_Boolean)
    {
      String str = this.jdField_c_of_type_JavaLangString;
      localIntent.putExtra("sessionType", 3);
      localIntent.putExtra("Type", 1);
      localIntent.putExtra("uin", str);
      localIntent.putExtra("uinType", 0);
      localIntent.putExtra("isDoubleVideoMeeting", true);
      localIntent.putExtra("inviteUin", str);
      localIntent.putExtra("sessionType", 1);
      localIntent.putExtra("isSender", false);
      localIntent.putExtra("isEnter", true);
      localIntent.putExtra("name", this.jdField_d_of_type_JavaLangString);
      super.startActivity(localIntent);
      this.jdField_e_of_type_Boolean = false;
      this.jdField_f_of_type_Boolean = true;
      super.finish();
      super.overridePendingTransition(2130772170, 2130772169);
      return;
    }
    localIntent.putExtra("uinType", this.jdField_e_of_type_Int);
    localIntent.putExtra("bindType", this.jdField_f_of_type_Int);
    localIntent.putExtra("bindId", this.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("uin", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("name", this.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("extraUin", this.jdField_e_of_type_JavaLangString);
    localIntent.putExtra("receive", true);
    localIntent.putExtra("isAudioMode", this.jdField_b_of_type_Boolean);
    localIntent.putExtra("sig", this.jdField_a_of_type_ArrayOfByte);
    localIntent.putExtra("subServiceType", this.jdField_g_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startVideoChatActivity: mBindType = " + this.jdField_f_of_type_Int + ",mBindId = " + this.jdField_b_of_type_JavaLangString + ",BindType = " + this.jdField_a_of_type_Lff.A);
    }
    if (this.jdField_e_of_type_Int == 0) {
      localIntent.putExtra("isFriend", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_c_of_type_JavaLangString));
    }
    if (this.jdField_b_of_type_Boolean) {
      localIntent.putExtra("sessionType", 1);
    }
    for (;;)
    {
      localIntent.putExtra("shutCamera", this.jdField_a_of_type_Boolean);
      localIntent.putExtra("isSender", false);
      break;
      localIntent.putExtra("sessionType", 2);
    }
  }
  
  public boolean e()
  {
    return a().c(this.jdField_c_of_type_JavaLangString);
  }
  
  void f()
  {
    long l1 = AudioHelper.b();
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("onVideoRequestTimeout, seq[").append(l1).append("], state[");
      if (this.jdField_a_of_type_Lff != null) {
        break label127;
      }
    }
    label127:
    for (int i1 = -1;; i1 = this.jdField_a_of_type_Lff.jdField_g_of_type_Int)
    {
      QLog.w(str, 2, i1 + "]");
      if ((this.jdField_a_of_type_Lff == null) || ((!this.jdField_a_of_type_Lff.k()) && (!this.jdField_a_of_type_Lff.l())) || (this.jdField_c_of_type_JavaLangString == null) || (!this.jdField_c_of_type_JavaLangString.equals(this.jdField_a_of_type_Lff.jdField_d_of_type_JavaLangString))) {
        break;
      }
      finish();
      return;
    }
    mur.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    a(l1);
    if ((this.jdField_l_of_type_Boolean) && (this.jdField_a_of_type_Mia != null))
    {
      this.jdField_a_of_type_Mia.a(new mku(this, l1));
      return;
    }
    this.jdField_d_of_type_Boolean = false;
    if (this.jdField_i_of_type_Boolean)
    {
      long l2 = mrs.a(this.jdField_c_of_type_JavaLangString);
      a().a(l1, 3, l2);
      if (!this.jdField_h_of_type_Boolean)
      {
        this.jdField_h_of_type_Boolean = true;
        a().a(l1, l2, 2);
      }
      this.jdField_e_of_type_Boolean = true;
      finish();
      return;
    }
    a().a(this.jdField_c_of_type_JavaLangString, 247);
    a().b(247);
    a().b(this.jdField_c_of_type_JavaLangString, 0);
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_Mlg instanceof mlj;
  }
  
  public void finish()
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "finish", new Throwable());
    super.finish();
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_Mlg != null) {
      this.jdField_a_of_type_Mlg.b();
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Lff == null) {}
    for (;;)
    {
      return;
      Object localObject2 = this.jdField_c_of_type_JavaLangString;
      int i2 = this.jdField_e_of_type_Int;
      int i1 = i2;
      Object localObject1 = localObject2;
      if (this.jdField_a_of_type_Lff.A == 1)
      {
        i1 = i2;
        localObject1 = localObject2;
        if (this.jdField_e_of_type_Int == 9500)
        {
          i1 = i2;
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_Lff.p))
          {
            localObject1 = this.jdField_a_of_type_Lff.p;
            i1 = 0;
          }
        }
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i1, (String)localObject1, this.jdField_e_of_type_JavaLangString, true, true);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
        localObject2 = mvd.a(super.getApplicationContext(), 2130842086);
        if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
        {
          if (localObject2 == null) {
            break label320;
          }
          long l1 = System.currentTimeMillis();
          localObject2 = new BitmapDrawable((Bitmap)localObject2);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable((Drawable)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "blur time = " + (System.currentTimeMillis() - l1) + "ms");
          }
        }
      }
      while (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i1, (String)localObject1, this.jdField_e_of_type_JavaLangString);
        if ((this.jdField_e_of_type_Int == 25) && (this.jdField_d_of_type_JavaLangString.equals(this.jdField_c_of_type_JavaLangString)))
        {
          this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Lff.a();
          if (QLog.isColorLevel()) {
            QLog.w(this.jdField_a_of_type_JavaLangString, 2, "mPeerName = " + this.jdField_d_of_type_JavaLangString);
          }
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_d_of_type_JavaLangString);
        return;
        label320:
        localObject2 = mrr.a(super.getApplicationContext(), 2130842086);
        if (localObject2 != null) {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable((Drawable)localObject2);
        } else {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130842086);
        }
      }
    }
  }
  
  void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showGAudioDialog");
    }
    mky localmky1 = new mky(this, 0);
    mky localmky2 = new mky(this, 1);
    bhlq.a(this, 230, null, super.getString(2131694912), 2131719173, 2131694826, localmky1, localmky2).show();
  }
  
  void j()
  {
    String str2 = "";
    int i1;
    String str1;
    if (a() != null)
    {
      i1 = this.jdField_a_of_type_Lff.jdField_j_of_type_Int;
      str1 = this.jdField_a_of_type_Lff.jdField_f_of_type_JavaLangString;
    }
    for (;;)
    {
      switch (i1)
      {
      default: 
        this.jdField_i_of_type_Int = 99;
        str1 = str2;
      }
      for (;;)
      {
        this.jdField_f_of_type_JavaLangString = str1;
        return;
        if (this.jdField_i_of_type_Boolean)
        {
          this.jdField_i_of_type_Int = 7;
          str1 = super.getString(2131695042);
        }
        else
        {
          this.jdField_i_of_type_Int = 0;
          str1 = str2;
          continue;
          str1 = super.getString(2131695043) + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(1, str1, null);
          this.jdField_i_of_type_Int = 1;
          continue;
          str1 = super.getString(2131695043) + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(3000, str1, null);
          this.jdField_i_of_type_Int = 2;
          continue;
          str1 = super.getString(2131695040);
          this.jdField_i_of_type_Int = 3;
          continue;
          str1 = super.getString(2131695039);
          this.jdField_i_of_type_Int = 4;
          continue;
          str1 = super.getString(2131695044);
          this.jdField_i_of_type_Int = 5;
          continue;
          str1 = super.getString(2131695041);
          this.jdField_i_of_type_Int = 6;
          continue;
          str1 = super.getString(2131693848);
          this.jdField_i_of_type_Int = 7;
        }
      }
      str1 = null;
      i1 = 0;
    }
  }
  
  void k()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131376935));
    Drawable localDrawable = mrr.a(super.getApplicationContext(), 2130842086);
    if (localDrawable != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(localDrawable);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130842086);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    LiuHaiUtils.a(this);
    if ((LiuHaiUtils.b()) && (LiuHaiUtils.enableNotch(this)) && (QLog.isDevelopLevel())) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onAttachedToWindow");
    }
  }
  
  public void onBackPressed()
  {
    if (this.jdField_a_of_type_Mlg != null) {
      this.jdField_a_of_type_Mlg.c();
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
    long l3 = AudioHelper.b();
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "avideo onCreate, seq[" + l3 + "]");
    b("onCreate");
    if (this.jdField_a_of_type_Mlg == null) {
      b(VideoController.a(getApplicationContext()));
    }
    if (this.jdField_a_of_type_Mlg != null) {
      this.jdField_a_of_type_Mlg.a(true);
    }
    lic.a(29);
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    super.onCreate(paramBundle);
    super.overridePendingTransition(2130772170, 0);
    AVActivity.a(getWindow(), true);
    ImmersiveUtils.a(true, getWindow());
    AVActivity.a(super.getWindow());
    if ((!b()) || (!a()))
    {
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 2, "init param failure.");
      }
      this.jdField_e_of_type_Boolean = true;
      super.finish();
      return;
    }
    paramBundle = this.jdField_c_of_type_JavaLangString;
    label229:
    int i1;
    label306:
    label484:
    long l2;
    label420:
    long l1;
    if (this.jdField_i_of_type_Boolean)
    {
      paramBundle = lcb.a(100, paramBundle, new int[0]);
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)super.getSystemService("audio"));
      this.jdField_a_of_type_Lff = lcb.a().c(paramBundle);
      paramBundle = a();
      if (paramBundle != null) {
        break label998;
      }
      paramBundle = null;
      if (paramBundle != null) {
        paramBundle.a(getClass().getName(), getIntent());
      }
      StringBuilder localStringBuilder;
      if ((this.jdField_a_of_type_Lff == null) || (!this.jdField_a_of_type_Lff.j()))
      {
        if (QLog.isColorLevel())
        {
          paramBundle = this.jdField_a_of_type_JavaLangString;
          localStringBuilder = new StringBuilder().append("session state error! ");
          if (this.jdField_a_of_type_Lff == null) {
            break label1006;
          }
          i1 = this.jdField_a_of_type_Lff.jdField_g_of_type_Int;
          QLog.w(paramBundle, 2, i1);
        }
        if ((this.jdField_a_of_type_Lff == null) || (!this.jdField_a_of_type_Lff.h()) || (this.jdField_c_of_type_JavaLangString == null) || (!this.jdField_c_of_type_JavaLangString.equals(this.jdField_a_of_type_Lff.jdField_d_of_type_JavaLangString))) {
          break label1011;
        }
        if (QLog.isColorLevel()) {
          QLog.w(this.jdField_a_of_type_JavaLangString, 2, "onCreate state[" + this.jdField_a_of_type_Lff.jdField_g_of_type_Int + "], peerUin[" + this.jdField_c_of_type_JavaLangString + "]");
        }
      }
      a(getIntent());
      if (a().jdField_e_of_type_Boolean != true)
      {
        mur.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), a());
        a(l3);
        if (this.jdField_a_of_type_Lff.jdField_f_of_type_Int != 1) {
          break label1174;
        }
        mur.a().a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lfl);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lef);
      l2 = System.currentTimeMillis();
      l1 = this.jdField_a_of_type_Lff.k;
      i1 = 0;
      if ((l1 <= 0L) || (l2 - l1 >= jdField_b_of_type_Int)) {
        break label1192;
      }
      if (l2 - l1 < jdField_c_of_type_Int) {
        break label1187;
      }
      i1 = 1;
      label553:
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, jdField_b_of_type_Int + l1 - l2);
      if (i1 == 0) {
        break label1198;
      }
      g();
      label585:
      if (a().e() <= 0) {
        break label1225;
      }
      a().b(203, this.jdField_c_of_type_JavaLangString);
      label609:
      this.jdField_h_of_type_Int = mtd.a(this);
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Lff.p;
      this.jdField_f_of_type_Int = this.jdField_a_of_type_Lff.A;
      this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_Lff.jdField_a_of_type_ArrayOfByte;
      this.jdField_g_of_type_Int = this.jdField_a_of_type_Lff.q;
      paramBundle = new IntentFilter();
      paramBundle.addAction("tencent.video.q2v.ACTION_ON_UPDATE_FRIEND_INFO");
      paramBundle.addAction("tencent.video.q2v.sdk.onRequestVideo");
      paramBundle.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
      paramBundle.addAction("android.intent.action.SCREEN_OFF");
      paramBundle.addAction("android.intent.action.SCREEN_ON");
      paramBundle.addAction("android.intent.action.USER_PRESENT");
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new mla(this);
      super.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
      j();
      if (this.jdField_e_of_type_Int == 25)
      {
        axfr localaxfr = (axfr)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getManager(11);
        localStringBuilder = null;
        paramBundle = localStringBuilder;
        if (localaxfr != null)
        {
          paramBundle = localStringBuilder;
          if (this.jdField_e_of_type_JavaLangString != null) {
            paramBundle = localaxfr.c(this.jdField_e_of_type_JavaLangString);
          }
        }
        if (paramBundle == null) {
          break label1278;
        }
        paramBundle = localaxfr.a(this.jdField_e_of_type_JavaLangString);
        if ((paramBundle == null) || (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramBundle))) {
          break label1242;
        }
        bdll.b(null, "CliOper", "", "", "0X800624D", "0X800624D", 1, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      if ((!this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Lff.j())) {
        d(false);
      }
      paramBundle = getIntent();
      if ((paramBundle != null) && (paramBundle.getBooleanExtra("fullscreen", false))) {
        ldc.b();
      }
      if (this.jdField_a_of_type_Mlg != null) {
        this.jdField_a_of_type_Mlg.d();
      }
      if ((this.jdField_a_of_type_Lff.jdField_j_of_type_Int == 21) || (this.jdField_a_of_type_Lff.jdField_j_of_type_Int == 1011))
      {
        this.jdField_d_of_type_Boolean = true;
        c(l3);
        if (this.jdField_a_of_type_Mlg != null) {
          this.jdField_a_of_type_Mlg.a();
        }
      }
      if (this.jdField_a_of_type_Mia != null) {
        this.jdField_a_of_type_Mia.a();
      }
      this.jdField_k_of_type_Boolean = true;
      return;
      paramBundle = lcb.a(3, paramBundle, new int[0]);
      break;
      label998:
      paramBundle = paramBundle.a();
      break label229;
      label1006:
      i1 = -1;
      break label306;
      label1011:
      if ((this.jdField_a_of_type_Lff != null) && ((this.jdField_a_of_type_Lff.k()) || (this.jdField_a_of_type_Lff.l())) && (this.jdField_c_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString.equals(this.jdField_a_of_type_Lff.jdField_d_of_type_JavaLangString)))
      {
        if (QLog.isColorLevel()) {
          QLog.w(this.jdField_a_of_type_JavaLangString, 2, "onCreate state[" + this.jdField_a_of_type_Lff.jdField_g_of_type_Int + "], peerUin[" + this.jdField_c_of_type_JavaLangString + "]");
        }
        finish();
        break label420;
      }
      a().a(this.jdField_c_of_type_JavaLangString, 245);
      a().b(245);
      a().b(this.jdField_c_of_type_JavaLangString, 2);
      this.jdField_e_of_type_Boolean = true;
      super.finish();
      return;
      label1174:
      mur.a().a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      break label484;
      label1187:
      i1 = 0;
      break label553;
      label1192:
      l1 = l2;
      break label553;
      label1198:
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, l1 + jdField_c_of_type_Int - l2);
      break label585;
      label1225:
      a().b(202, this.jdField_c_of_type_JavaLangString);
      break label609;
      label1242:
      bdll.b(null, "CliOper", "", "", "0X800624D", "0X800624D", 0, 0, "", "", "", "");
      continue;
      label1278:
      bdll.b(null, "CliOper", "", "", "0X800624D", "0X800624D", 2, 0, "", "", "", "");
    }
  }
  
  public void onDestroy()
  {
    long l1 = AudioHelper.b();
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "avideo onDestroy, seq[" + l1 + "]");
    super.onDestroy();
    if (this.jdField_a_of_type_Mat != null) {
      this.jdField_a_of_type_Mat.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    lia.a(this.jdField_c_of_type_Long);
    this.jdField_c_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_Mvi != null)
    {
      this.jdField_a_of_type_Mvi.a();
      this.jdField_a_of_type_Mvi = null;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lfl);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lef);
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      super.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    a(l1);
    mur.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_Mvi = null;
    this.jdField_a_of_type_Mtn = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetImageButton = null;
    this.jdField_b_of_type_AndroidWidgetImageButton = null;
    this.jdField_a_of_type_AndroidMediaAudioManager = null;
    this.jdField_a_of_type_Lfl = null;
    this.jdField_a_of_type_Lef = null;
    if (this.jdField_a_of_type_Mlg != null) {
      this.jdField_a_of_type_Mlg.j();
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.stopPlayback();
        if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
          this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
        }
        this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = null;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.suspend();
          if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
          {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
            this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
          }
          this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = null;
        }
      }
    }
    this.jdField_a_of_type_Lff = null;
    this.m = true;
    mrl.a(this);
    mrl.a(this);
    b("onDestroy");
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_Mlg != null) {
      this.jdField_a_of_type_Mlg.a(paramInt, paramKeyEvent);
    }
    long l1;
    if (!this.jdField_d_of_type_Boolean)
    {
      l1 = AudioHelper.b();
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onKeyDown, seq[" + l1 + "]");
      if ((paramInt != 25) && (paramInt != 24)) {
        break label100;
      }
      mur.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      a(l1);
    }
    for (;;)
    {
      bool = super.onKeyDown(paramInt, paramKeyEvent);
      return bool;
      label100:
      if (paramInt == 26) {
        a(l1);
      }
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onNewIntent()");
    b("onNewIntent");
    a(paramIntent);
  }
  
  public void onPause()
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onPause");
    super.onPause();
    aquy.a(this, 2, true);
    c(false);
    a().a("state", "0");
    if ("0".equals(lcj.jdField_a_of_type_JavaLangString)) {
      a().a("backgroundReason", "5");
    }
    if (!this.jdField_f_of_type_Boolean) {
      bjfr.a(BaseApplicationImpl.getContext(), true, 50, 1);
    }
    if (this.jdField_a_of_type_Mat != null) {
      this.jdField_a_of_type_Mat.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    if (this.jdField_a_of_type_Mlg != null) {
      this.jdField_a_of_type_Mlg.h();
    }
    this.jdField_l_of_type_Boolean = false;
    this.jdField_a_of_type_Lkh.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, a());
  }
  
  protected void onRestart()
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onRestart");
    super.onRestart();
    if (this.jdField_a_of_type_Mlg != null) {
      this.jdField_a_of_type_Mlg.f();
    }
  }
  
  public void onResume()
  {
    a("onResume");
    long l1 = AudioHelper.b();
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onResume, mCheckQAVPermission[" + this.n + "], isInLockMode[" + f() + "], seq[" + l1 + "]");
    super.onResume();
    aquy.a(this, 2, false);
    bjfr.a(BaseApplicationImpl.getContext(), 50, 0);
    bjfr.a(BaseApplicationImpl.getContext(), false, 50, 1);
    bjfr.a(BaseApplicationImpl.getContext(), 50, 2);
    e();
    this.jdField_c_of_type_Boolean = false;
    c(true);
    lff locallff = lcb.a().a();
    lie locallie = (lie)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
    if ((locallie != null) && (locallff != null))
    {
      long l2 = System.currentTimeMillis();
      long l3 = lwe.a().jdField_b_of_type_Long;
      locallie.a(locallff.b(), 24, l2 - l3);
    }
    a().a(VideoInviteActivity.class);
    a().a("state", "1");
    lcj.jdField_a_of_type_JavaLangString = "0";
    if (this.jdField_a_of_type_Mat != null) {
      this.jdField_a_of_type_Mat.c(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    if (!this.n)
    {
      this.n = true;
      ChatActivityUtils.a(this, true, new mkl(this, l1));
    }
    if (this.jdField_a_of_type_Mlg != null) {
      this.jdField_a_of_type_Mlg.g();
    }
    if (!f()) {
      b(l1);
    }
    this.jdField_l_of_type_Boolean = true;
    this.jdField_a_of_type_Lkh.a(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, a());
  }
  
  public void onStart()
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onStart");
    super.onStart();
    if (this.jdField_a_of_type_Mlg != null) {
      this.jdField_a_of_type_Mlg.e();
    }
    if (f())
    {
      long l1 = AudioHelper.b();
      if (VideoController.b(this)) {
        b(l1);
      }
    }
  }
  
  public void onStop()
  {
    long l1 = AudioHelper.b();
    boolean bool = mtd.b(this);
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "avideo onStop, isRingerNormal[" + bool + "], mIsAccepted[" + this.jdField_d_of_type_Boolean + "], seq[" + l1 + "]");
    super.onStop();
    if ((bool) && (!this.jdField_d_of_type_Boolean)) {
      a(l1);
    }
    if (this.jdField_a_of_type_Lff == null) {
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 2, "onStop mSessionInfo is null ");
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Mlg != null) {
        this.jdField_a_of_type_Mlg.i();
      }
      this.jdField_l_of_type_Boolean = false;
    } while ((this.jdField_e_of_type_Boolean) || (!this.jdField_a_of_type_Lff.j()));
    d(true);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (this.jdField_a_of_type_Mlg != null) {
      this.jdField_a_of_type_Mlg.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteActivity
 * JD-Core Version:    0.7.0.1
 */