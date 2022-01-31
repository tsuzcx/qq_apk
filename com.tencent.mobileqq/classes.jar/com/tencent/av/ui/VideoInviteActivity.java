package com.tencent.av.ui;

import amkg;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import askl;
import axqw;
import bbcv;
import bbev;
import bbgg;
import bbio;
import bbon;
import bbyt;
import bctn;
import bfol;
import bkur;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQLSUnlockActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.vipav.VipFullScreenVideoView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import ldc;
import ldj;
import led;
import lfg;
import lgf;
import lgg;
import lgh;
import lgl;
import lix;
import liz;
import ljb;
import lla;
import llb;
import lwe;
import lzj;
import mal;
import mat;
import mho;
import mjv;
import mjx;
import mjz;
import mka;
import mkb;
import mkc;
import mke;
import mkf;
import mki;
import mkj;
import mkk;
import mkq;
import mkr;
import mkt;
import mms;
import mqq.app.BaseActivity;
import mqr;
import mqw;
import mqx;
import msi;
import mss;
import msw;
import mtt;
import muf;
import muk;

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
  lfg jdField_a_of_type_Lfg = new mjx(this);
  public lgf a;
  lgl jdField_a_of_type_Lgl = new mkf(this);
  private llb jdField_a_of_type_Llb = new llb();
  mal jdField_a_of_type_Mal;
  public mho a;
  public mkq a;
  mss jdField_a_of_type_Mss = null;
  muk jdField_a_of_type_Muk;
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
  boolean m = false;
  boolean n = false;
  
  static
  {
    jdField_b_of_type_Int = 60000;
    jdField_c_of_type_Int = 50000;
  }
  
  public VideoInviteActivity()
  {
    this.jdField_a_of_type_Lgf = null;
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
    this.jdField_a_of_type_Mho = null;
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
    if (bbyt.a(this, this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView, paramString, paramInt1, null, paramInt2, false))
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
    lzj.a(BaseApplicationImpl.getContext(), paramBoolean);
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Mss == null) {
      this.jdField_a_of_type_Mss = mss.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    if (mqr.a()) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QAVNotification", 2, "updateInviteNotification show[" + paramBoolean + "], mIsAudioMode[" + this.jdField_b_of_type_Boolean + "], isOnlyAudio[" + this.jdField_a_of_type_Lgf.Q + "], session[" + this.jdField_a_of_type_Lgf + "]");
      }
      if (paramBoolean)
      {
        Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, true, true);
        this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(this.jdField_e_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
        if (this.jdField_a_of_type_Lgf.Q)
        {
          this.jdField_a_of_type_Mss.a(true, this.jdField_a_of_type_Lgf.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, localBitmap, null, 45, this.jdField_e_of_type_Int, 1);
          return;
        }
        this.jdField_a_of_type_Mss.a(true, this.jdField_a_of_type_Lgf.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, localBitmap, null, 40, this.jdField_e_of_type_Int, 2);
        return;
      }
      this.jdField_a_of_type_Mss.a(this.jdField_a_of_type_Lgf.jdField_c_of_type_JavaLangString);
      return;
      paramBoolean = true;
    }
  }
  
  public void BtnOnClick(View paramView)
  {
    if (this.jdField_a_of_type_Mkq != null) {
      this.jdField_a_of_type_Mkq.BtnOnClick(paramView);
    }
  }
  
  bfol a(Context paramContext)
  {
    paramContext = new mkj(this, paramContext);
    paramContext.getWindow().setWindowAnimations(2131755219);
    return paramContext;
  }
  
  public VideoController a()
  {
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
  }
  
  public void a()
  {
    int i1 = 0;
    if (this.jdField_a_of_type_Lgf == null) {}
    label9:
    int i2;
    do
    {
      int i3;
      String str;
      do
      {
        do
        {
          break label9;
          do
          {
            return;
          } while (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null);
          i2 = mms.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_c_of_type_JavaLangString, false, this.jdField_b_of_type_Boolean);
        } while (i2 == 0);
        i3 = bbev.a(BaseApplicationImpl.getContext());
        if ((i3 == 4) || (i3 == 1)) {
          i1 = 1;
        }
        i3 = bbyt.a();
        str = bbyt.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, i2, bbyt.a(), null);
      } while (TextUtils.isEmpty(str));
      this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = bbyt.a(this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
      File localFile = new File(str);
      if ((localFile != null) && (localFile.exists()))
      {
        a(str, i3, i2);
        return;
      }
    } while (i1 == 0);
    this.jdField_j_of_type_Int = i2;
    mms.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, i2);
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
      mat.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1040, 2131696238);
      continue;
      mat.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1040, 2131696233);
      continue;
      mat.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1040, 2131696235);
    }
  }
  
  public void a(long paramLong)
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "stopRing, mLastPlayRingTime[" + this.jdField_a_of_type_Long + "->" + 0 + "]");
    this.jdField_a_of_type_Long = 0L;
    if (mtt.a() != null) {
      mtt.a().b(paramLong);
    }
  }
  
  public void a(long paramLong, Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (paramContext = a(paramContext);; paramContext = bfol.a(paramContext))
    {
      paramContext.b(2131695965);
      paramContext.b(2131695967);
      paramContext.b(2131695966);
      if (d()) {
        paramContext.b(2131695964);
      }
      paramContext.c(2131690596);
      paramContext.a(new mjz(this, paramBoolean));
      paramContext.a(new mka(this, paramContext, paramBoolean, paramLong));
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
    mtt.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if ((this.jdField_l_of_type_Boolean) && (this.jdField_a_of_type_Mho != null) && (!this.jdField_j_of_type_Boolean)) {
      this.jdField_a_of_type_Mho.a(new mkb(this, paramLong, paramBoolean));
    }
    do
    {
      return;
      if (this.jdField_i_of_type_Boolean)
      {
        a().a(paramLong, this.jdField_c_of_type_JavaLangString, 1, true);
        long l1 = mqx.a(this.jdField_c_of_type_JavaLangString);
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
      if (msw.a(paramIntent)) {
        axqw.b(null, "dc00898", "", "", "0X800A2C5", "0X800A2C5", 0, 0, "", "", "", "");
      }
      long l1 = AudioHelper.b();
      String str1 = paramIntent.getAction();
      String str2;
      if ("com.tencent.qav.notify.accept".equals(str1))
      {
        str2 = paramIntent.getStringExtra("session_id");
        if (this.jdField_a_of_type_Lgf == null)
        {
          paramIntent = null;
          if (!TextUtils.equals(str2, paramIntent)) {
            break label194;
          }
          c(l1);
          label98:
          axqw.b(null, "dc00898", "", "", "0X800A2C6", "0X800A2C6", 0, 0, "", "", "", "");
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label266;
        }
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "checkParamAndDoAction action[" + str1 + "], seq[" + l1 + "]");
        return;
        paramIntent = this.jdField_a_of_type_Lgf.jdField_c_of_type_JavaLangString;
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
        if (this.jdField_a_of_type_Mkq != null) {
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
        localObject = Integer.valueOf(this.jdField_a_of_type_Mkq.a());
        break label70;
        if (this.jdField_a_of_type_Mkq == null)
        {
          b(bool);
          return;
        }
      } while (i1 == this.jdField_a_of_type_Mkq.a());
      paramString = this.jdField_a_of_type_Mkq;
      this.jdField_a_of_type_Mkq.j();
      b(bool);
      this.jdField_a_of_type_Mkq.a(paramString);
      if (this.jdField_k_of_type_Boolean)
      {
        this.jdField_a_of_type_Mkq.d();
        this.jdField_a_of_type_Mkq.a();
      }
    } while (!this.jdField_l_of_type_Boolean);
    this.jdField_a_of_type_Mkq.g();
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(super.getResources().getColor(2131165925));
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(super.getResources().getColor(2131165925));
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(super.getResources().getColor(2131165925));
      }
      if (this.jdField_a_of_type_Mal != null)
      {
        this.jdField_a_of_type_Mal.a(super.getResources().getColor(2131165925));
        this.jdField_a_of_type_Mal.b(-1291845633);
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
    } while (this.jdField_a_of_type_Mal == null);
    this.jdField_a_of_type_Mal.a(-11113603);
    this.jdField_a_of_type_Mal.b(-11113603);
  }
  
  boolean a()
  {
    boolean bool4 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    Object localObject = super.getIntent();
    if ((localObject != null) && (!msw.a((Intent)localObject)))
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
    localObject = ldc.a().a();
    boolean bool1 = bool4;
    if (localObject != null)
    {
      this.jdField_e_of_type_Int = ((lgf)localObject).jdField_i_of_type_Int;
      this.jdField_c_of_type_JavaLangString = ((lgf)localObject).jdField_d_of_type_JavaLangString;
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
      this.jdField_e_of_type_Int = ((lgf)localObject).jdField_i_of_type_Int;
      this.jdField_e_of_type_JavaLangString = ((lgf)localObject).jdField_f_of_type_JavaLangString;
      this.jdField_d_of_type_Int = a().a();
      this.jdField_b_of_type_Boolean = ((lgf)localObject).Q;
      bool1 = bool2;
      if (((lgf)localObject).jdField_a_of_type_Lgg.jdField_b_of_type_Int <= 0) {
        if (((lgf)localObject).jdField_a_of_type_Lgh.jdField_a_of_type_Int != 0)
        {
          bool1 = bool2;
          if (((lgf)localObject).jdField_a_of_type_Lgh.jdField_a_of_type_Long > 0L) {}
        }
        else
        {
          bool1 = true;
        }
      }
      this.jdField_g_of_type_Boolean = bool1;
      this.jdField_i_of_type_Boolean = ((lgf)localObject).I;
    }
  }
  
  public void b()
  {
    k();
    this.jdField_a_of_type_Mal = new mal();
    this.jdField_a_of_type_Mal.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_Int = 1;
    if ((!bbev.h(super.getApplicationContext())) && (!bbev.f(super.getApplicationContext()))) {
      this.jdField_a_of_type_Int = 2;
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131362935));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131362924));
    if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_f_of_type_JavaLangString);
      muf.a(this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_f_of_type_JavaLangString);
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
      boolean bool = mqr.b((String)localObject);
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
        if (!msi.b(this)) {
          break label469;
        }
        if ((this.jdField_c_of_type_Boolean) || (!this.jdField_g_of_type_Boolean)) {
          break label237;
        }
        l1 = System.currentTimeMillis();
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "playRing, mIsRingPlaying[" + this.jdField_a_of_type_Long + "->" + l1 + "], seq[" + paramLong + "]");
      } while (this.jdField_a_of_type_Long != 0L);
      this.jdField_a_of_type_Long = l1;
      mtt.a().b(paramLong);
      if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp() == null))
      {
        this.jdField_b_of_type_Long = 0L;
        if (this.jdField_b_of_type_Long != 0L) {
          break label275;
        }
        mtt.a().a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230742, -1, null);
      }
      for (;;)
      {
        mtt.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false, paramLong);
        return;
        this.jdField_b_of_type_Long = bbyt.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount(), 3, false, this.jdField_c_of_type_JavaLangString);
        break;
        localObject = bbon.a(this.jdField_b_of_type_Long, 3);
        if (new File((String)localObject).exists())
        {
          mtt.a().b(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0, (String)localObject, -1, null);
          axqw.b(null, "CliOper", "", "", "0X8005004", "0X8005004", 0, 0, "", this.jdField_b_of_type_Long + "", "", "");
        }
        else
        {
          mtt.a().a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230742, -1, null);
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
    } while (!msi.a(this));
    label275:
    label469:
    mtt.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false, paramLong);
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TraceLogForAV", 2, "traceLog from[" + paramString + "], seq[" + this.jdField_d_of_type_Long + "], mode[" + this.jdField_a_of_type_Mkq + "]");
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (this.jdField_a_of_type_Mkq = new mkt(this);; this.jdField_a_of_type_Mkq = new mkr(this))
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
      this.jdField_a_of_type_Muk = new muk(super.getApplicationContext(), 1, "video wifi lock");
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
      if (!ChatActivityUtils.a(this, bool, new mkc(this, paramLong, bool))) {
        break label86;
      }
      d();
      if ((!a().jdField_e_of_type_Boolean) && (!a().l())) {
        break label88;
      }
      i();
    }
    for (;;)
    {
      mtt.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      a(paramLong);
      return;
      bool = false;
      break label24;
      label86:
      break;
      label88:
      e();
    }
  }
  
  protected boolean c()
  {
    if (this.jdField_a_of_type_Muk == null) {
      this.jdField_a_of_type_Muk = new muk(super.getApplicationContext(), 1, "video wifi lock");
    }
    if ((msi.e(super.getApplicationContext())) && (this.jdField_a_of_type_Muk != null)) {
      this.jdField_a_of_type_Muk.a();
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
    return (!bbio.a(super.getApplicationContext())) || (Build.VERSION.SDK_INT >= 16);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startVideoChatActivity");
    }
    mtt.a().a();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    if (a().n) {
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
      super.overridePendingTransition(2130772164, 2130772163);
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
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startVideoChatActivity: mBindType = " + this.jdField_f_of_type_Int + ",mBindId = " + this.jdField_b_of_type_JavaLangString + ",BindType = " + this.jdField_a_of_type_Lgf.z);
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
    return a().a(this.jdField_c_of_type_JavaLangString);
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
      if (this.jdField_a_of_type_Lgf != null) {
        break label127;
      }
    }
    label127:
    for (int i1 = -1;; i1 = this.jdField_a_of_type_Lgf.jdField_g_of_type_Int)
    {
      QLog.w(str, 2, i1 + "]");
      if ((this.jdField_a_of_type_Lgf == null) || ((!this.jdField_a_of_type_Lgf.i()) && (!this.jdField_a_of_type_Lgf.j())) || (this.jdField_c_of_type_JavaLangString == null) || (!this.jdField_c_of_type_JavaLangString.equals(this.jdField_a_of_type_Lgf.jdField_d_of_type_JavaLangString))) {
        break;
      }
      finish();
      return;
    }
    mtt.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    a(l1);
    if ((this.jdField_l_of_type_Boolean) && (this.jdField_a_of_type_Mho != null))
    {
      this.jdField_a_of_type_Mho.a(new mke(this, l1));
      return;
    }
    this.jdField_d_of_type_Boolean = false;
    if (this.jdField_i_of_type_Boolean)
    {
      long l2 = mqx.a(this.jdField_c_of_type_JavaLangString);
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
    return this.jdField_a_of_type_Mkq instanceof mkt;
  }
  
  public void finish()
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "finish", new Throwable());
    super.finish();
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_Mkq != null) {
      this.jdField_a_of_type_Mkq.b();
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Lgf == null) {}
    for (;;)
    {
      return;
      Object localObject2 = this.jdField_c_of_type_JavaLangString;
      int i2 = this.jdField_e_of_type_Int;
      int i1 = i2;
      Object localObject1 = localObject2;
      if (this.jdField_a_of_type_Lgf.z == 1)
      {
        i1 = i2;
        localObject1 = localObject2;
        if (this.jdField_e_of_type_Int == 9500)
        {
          i1 = i2;
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_Lgf.jdField_p_of_type_JavaLangString))
          {
            localObject1 = this.jdField_a_of_type_Lgf.jdField_p_of_type_JavaLangString;
            i1 = 0;
          }
        }
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i1, (String)localObject1, this.jdField_e_of_type_JavaLangString, true, true);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
        localObject2 = muf.a(super.getApplicationContext(), 2130841604);
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
          this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Lgf.a();
          if (QLog.isColorLevel()) {
            QLog.w(this.jdField_a_of_type_JavaLangString, 2, "mPeerName = " + this.jdField_d_of_type_JavaLangString);
          }
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_d_of_type_JavaLangString);
        return;
        label320:
        localObject2 = mqw.a(super.getApplicationContext(), 2130841604);
        if (localObject2 != null) {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable((Drawable)localObject2);
        } else {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130841604);
        }
      }
    }
  }
  
  void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showGAudioDialog");
    }
    mki localmki1 = new mki(this, 0);
    mki localmki2 = new mki(this, 1);
    bbcv.a(this, 230, null, super.getString(2131695826), 2131720725, 2131695743, localmki1, localmki2).show();
  }
  
  void j()
  {
    String str2 = "";
    int i1;
    String str1;
    if (a() != null)
    {
      i1 = this.jdField_a_of_type_Lgf.jdField_i_of_type_Int;
      str1 = this.jdField_a_of_type_Lgf.jdField_f_of_type_JavaLangString;
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
          str1 = super.getString(2131695955);
        }
        else
        {
          this.jdField_i_of_type_Int = 0;
          str1 = str2;
          continue;
          str1 = super.getString(2131695956) + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(1, str1, null);
          this.jdField_i_of_type_Int = 1;
          continue;
          str1 = super.getString(2131695956) + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(3000, str1, null);
          this.jdField_i_of_type_Int = 2;
          continue;
          str1 = super.getString(2131695953);
          this.jdField_i_of_type_Int = 3;
          continue;
          str1 = super.getString(2131695952);
          this.jdField_i_of_type_Int = 4;
          continue;
          str1 = super.getString(2131695957);
          this.jdField_i_of_type_Int = 5;
          continue;
          str1 = super.getString(2131695954);
          this.jdField_i_of_type_Int = 6;
          continue;
          str1 = super.getString(2131694405);
          this.jdField_i_of_type_Int = 7;
        }
      }
      str1 = null;
      i1 = 0;
    }
  }
  
  void k()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131375501));
    Drawable localDrawable = mqw.a(super.getApplicationContext(), 2130841604);
    if (localDrawable != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(localDrawable);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130841604);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    bkur.a(this);
    if ((bkur.b()) && (bkur.c(this)) && (QLog.isDevelopLevel())) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onAttachedToWindow");
    }
  }
  
  public void onBackPressed()
  {
    if (this.jdField_a_of_type_Mkq != null) {
      this.jdField_a_of_type_Mkq.c();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    long l3 = AudioHelper.b();
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "avideo onCreate, seq[" + l3 + "]");
    b("onCreate");
    if (this.jdField_a_of_type_Mkq == null) {
      b(VideoController.a(getApplicationContext()));
    }
    if (this.jdField_a_of_type_Mkq != null) {
      this.jdField_a_of_type_Mkq.a(true);
    }
    liz.a(29);
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    super.onCreate(paramBundle);
    super.overridePendingTransition(2130772164, 0);
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
      paramBundle = ldc.a(100, paramBundle, new int[0]);
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)super.getSystemService("audio"));
      this.jdField_a_of_type_Lgf = ldc.a().b(paramBundle);
      paramBundle = a();
      if (paramBundle != null) {
        break label998;
      }
      paramBundle = null;
      if (paramBundle != null) {
        paramBundle.a(getClass().getName(), getIntent());
      }
      StringBuilder localStringBuilder;
      if ((this.jdField_a_of_type_Lgf == null) || (!this.jdField_a_of_type_Lgf.h()))
      {
        if (QLog.isColorLevel())
        {
          paramBundle = this.jdField_a_of_type_JavaLangString;
          localStringBuilder = new StringBuilder().append("session state error! ");
          if (this.jdField_a_of_type_Lgf == null) {
            break label1006;
          }
          i1 = this.jdField_a_of_type_Lgf.jdField_g_of_type_Int;
          QLog.w(paramBundle, 2, i1);
        }
        if ((this.jdField_a_of_type_Lgf == null) || (!this.jdField_a_of_type_Lgf.f()) || (this.jdField_c_of_type_JavaLangString == null) || (!this.jdField_c_of_type_JavaLangString.equals(this.jdField_a_of_type_Lgf.jdField_d_of_type_JavaLangString))) {
          break label1011;
        }
        if (QLog.isColorLevel()) {
          QLog.w(this.jdField_a_of_type_JavaLangString, 2, "onCreate state[" + this.jdField_a_of_type_Lgf.jdField_g_of_type_Int + "], peerUin[" + this.jdField_c_of_type_JavaLangString + "]");
        }
      }
      a(getIntent());
      if (a().jdField_e_of_type_Boolean != true)
      {
        mtt.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), a());
        a(l3);
        if (this.jdField_a_of_type_Lgf.jdField_f_of_type_Int != 1) {
          break label1174;
        }
        mtt.a().a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lgl);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lfg);
      l2 = System.currentTimeMillis();
      l1 = this.jdField_a_of_type_Lgf.k;
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
      this.jdField_h_of_type_Int = msi.a(this);
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Lgf.jdField_p_of_type_JavaLangString;
      this.jdField_f_of_type_Int = this.jdField_a_of_type_Lgf.z;
      this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_Lgf.jdField_a_of_type_ArrayOfByte;
      this.jdField_g_of_type_Int = this.jdField_a_of_type_Lgf.jdField_p_of_type_Int;
      paramBundle = new IntentFilter();
      paramBundle.addAction("tencent.video.q2v.ACTION_ON_UPDATE_FRIEND_INFO");
      paramBundle.addAction("tencent.video.q2v.sdk.onRequestVideo");
      paramBundle.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
      paramBundle.addAction("android.intent.action.SCREEN_OFF");
      paramBundle.addAction("android.intent.action.SCREEN_ON");
      paramBundle.addAction("android.intent.action.USER_PRESENT");
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new mkk(this);
      super.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
      j();
      if (this.jdField_e_of_type_Int == 25)
      {
        askl localaskl = (askl)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getManager(11);
        localStringBuilder = null;
        paramBundle = localStringBuilder;
        if (localaskl != null)
        {
          paramBundle = localStringBuilder;
          if (this.jdField_e_of_type_JavaLangString != null) {
            paramBundle = localaskl.c(this.jdField_e_of_type_JavaLangString);
          }
        }
        if (paramBundle == null) {
          break label1278;
        }
        paramBundle = localaskl.a(this.jdField_e_of_type_JavaLangString);
        if ((paramBundle == null) || (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramBundle))) {
          break label1242;
        }
        axqw.b(null, "CliOper", "", "", "0X800624D", "0X800624D", 1, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      if ((!this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Lgf.h())) {
        d(false);
      }
      paramBundle = getIntent();
      if ((paramBundle != null) && (paramBundle.getBooleanExtra("fullscreen", false))) {
        led.b();
      }
      if (this.jdField_a_of_type_Mkq != null) {
        this.jdField_a_of_type_Mkq.d();
      }
      if ((this.jdField_a_of_type_Lgf.jdField_i_of_type_Int == 21) || (this.jdField_a_of_type_Lgf.jdField_i_of_type_Int == 1011))
      {
        this.jdField_d_of_type_Boolean = true;
        c(l3);
        if (this.jdField_a_of_type_Mkq != null) {
          this.jdField_a_of_type_Mkq.a();
        }
      }
      if (this.jdField_a_of_type_Mho != null) {
        this.jdField_a_of_type_Mho.a();
      }
      this.jdField_k_of_type_Boolean = true;
      return;
      paramBundle = ldc.a(3, paramBundle, new int[0]);
      break;
      label998:
      paramBundle = paramBundle.a();
      break label229;
      label1006:
      i1 = -1;
      break label306;
      label1011:
      if ((this.jdField_a_of_type_Lgf != null) && ((this.jdField_a_of_type_Lgf.i()) || (this.jdField_a_of_type_Lgf.j())) && (this.jdField_c_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString.equals(this.jdField_a_of_type_Lgf.jdField_d_of_type_JavaLangString)))
      {
        if (QLog.isColorLevel()) {
          QLog.w(this.jdField_a_of_type_JavaLangString, 2, "onCreate state[" + this.jdField_a_of_type_Lgf.jdField_g_of_type_Int + "], peerUin[" + this.jdField_c_of_type_JavaLangString + "]");
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
      mtt.a().a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
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
      axqw.b(null, "CliOper", "", "", "0X800624D", "0X800624D", 0, 0, "", "", "", "");
      continue;
      label1278:
      axqw.b(null, "CliOper", "", "", "0X800624D", "0X800624D", 2, 0, "", "", "", "");
    }
  }
  
  public void onDestroy()
  {
    long l1 = AudioHelper.b();
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "avideo onDestroy, seq[" + l1 + "]");
    super.onDestroy();
    if (this.jdField_a_of_type_Mal != null) {
      this.jdField_a_of_type_Mal.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    lix.a(this.jdField_c_of_type_Long);
    this.jdField_c_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_Muk != null)
    {
      this.jdField_a_of_type_Muk.a();
      this.jdField_a_of_type_Muk = null;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lgl);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lfg);
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      super.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    a(l1);
    mtt.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_Muk = null;
    this.jdField_a_of_type_Mss = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetImageButton = null;
    this.jdField_b_of_type_AndroidWidgetImageButton = null;
    this.jdField_a_of_type_AndroidMediaAudioManager = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_Lgl = null;
    this.jdField_a_of_type_Lfg = null;
    if (this.jdField_a_of_type_Mkq != null) {
      this.jdField_a_of_type_Mkq.j();
    }
    this.jdField_a_of_type_Lgf = null;
    this.m = true;
    b("onDestroy");
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Mkq != null) {
      bool = this.jdField_a_of_type_Mkq.a(paramInt, paramKeyEvent);
    }
    if (bool) {}
    while (this.jdField_d_of_type_Boolean) {
      return true;
    }
    long l1 = AudioHelper.b();
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onKeyDown, seq[" + l1 + "]");
    if ((paramInt == 25) || (paramInt == 24))
    {
      mtt.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      a(l1);
    }
    for (;;)
    {
      return super.onKeyDown(paramInt, paramKeyEvent);
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
    amkg.a(this, 2, true);
    c(false);
    a().a("state", "0");
    if ("0".equals(ldj.jdField_a_of_type_JavaLangString)) {
      a().a("backgroundReason", "5");
    }
    if (!this.jdField_f_of_type_Boolean) {
      bctn.a(BaseApplicationImpl.getContext(), true, 50, 1);
    }
    if (this.jdField_a_of_type_Mal != null) {
      this.jdField_a_of_type_Mal.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    if (this.jdField_a_of_type_Mkq != null) {
      this.jdField_a_of_type_Mkq.h();
    }
    this.jdField_l_of_type_Boolean = false;
    this.jdField_a_of_type_Llb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, a());
  }
  
  protected void onRestart()
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onRestart");
    super.onRestart();
    if (this.jdField_a_of_type_Mkq != null) {
      this.jdField_a_of_type_Mkq.f();
    }
  }
  
  public void onResume()
  {
    a("onResume");
    long l1 = AudioHelper.b();
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onResume, mCheckQAVPermission[" + this.n + "], isInLockMode[" + f() + "], seq[" + l1 + "]");
    super.onResume();
    amkg.a(this, 2, false);
    bctn.a(BaseApplicationImpl.getContext(), 50, 0);
    bctn.a(BaseApplicationImpl.getContext(), false, 50, 1);
    bctn.a(BaseApplicationImpl.getContext(), 50, 2);
    e();
    this.jdField_c_of_type_Boolean = false;
    c(true);
    lgf locallgf = ldc.a().a();
    ljb localljb = (ljb)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
    if ((localljb != null) && (locallgf != null))
    {
      long l2 = System.currentTimeMillis();
      long l3 = lwe.a().jdField_b_of_type_Long;
      localljb.a(locallgf.b(), 24, l2 - l3);
    }
    a().a(VideoInviteActivity.class);
    a().a("state", "1");
    ldj.jdField_a_of_type_JavaLangString = "0";
    if (this.jdField_a_of_type_Mal != null) {
      this.jdField_a_of_type_Mal.c(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    if (!this.n)
    {
      this.n = true;
      ChatActivityUtils.a(this, true, new mjv(this, l1));
    }
    if (this.jdField_a_of_type_Mkq != null) {
      this.jdField_a_of_type_Mkq.g();
    }
    if (!f()) {
      b(l1);
    }
    this.jdField_l_of_type_Boolean = true;
    this.jdField_a_of_type_Llb.a(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, a());
  }
  
  public void onStart()
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onStart");
    super.onStart();
    if (this.jdField_a_of_type_Mkq != null) {
      this.jdField_a_of_type_Mkq.e();
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
    boolean bool = msi.b(this);
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "avideo onStop, isRingerNormal[" + bool + "], mIsAccepted[" + this.jdField_d_of_type_Boolean + "], seq[" + l1 + "]");
    super.onStop();
    if ((bool) && (!this.jdField_d_of_type_Boolean)) {
      a(l1);
    }
    if (this.jdField_a_of_type_Lgf == null) {
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 2, "onStop mSessionInfo is null ");
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Mkq != null) {
        this.jdField_a_of_type_Mkq.i();
      }
      this.jdField_l_of_type_Boolean = false;
    } while ((this.jdField_e_of_type_Boolean) || (!this.jdField_a_of_type_Lgf.h()));
    d(true);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (this.jdField_a_of_type_Mkq != null) {
      this.jdField_a_of_type_Mkq.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteActivity
 * JD-Core Version:    0.7.0.1
 */