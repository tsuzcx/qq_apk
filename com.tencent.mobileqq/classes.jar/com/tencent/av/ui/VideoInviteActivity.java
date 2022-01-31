package com.tencent.av.ui;

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
import aobd;
import aubm;
import azmj;
import bdcd;
import bdee;
import bdfq;
import bdhy;
import bdnv;
import bdyi;
import betl;
import bhpy;
import bngs;
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
import lfb;
import lfh;
import lgb;
import lhe;
import lid;
import lie;
import lif;
import lij;
import lkv;
import lkx;
import lkz;
import lmy;
import lmz;
import lyg;
import mbt;
import mcv;
import mdd;
import mkb;
import mmm;
import mmo;
import mmq;
import mmr;
import mms;
import mmt;
import mmv;
import mmw;
import mmz;
import mna;
import mnb;
import mnh;
import mni;
import mnk;
import mpj;
import mqq.app.BaseActivity;
import mti;
import mtn;
import mto;
import muz;
import mvj;
import mvn;
import mwk;
import mww;
import mxb;

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
  lhe jdField_a_of_type_Lhe = new mmo(this);
  public lid a;
  lij jdField_a_of_type_Lij = new mmw(this);
  private lmz jdField_a_of_type_Lmz = new lmz();
  mcv jdField_a_of_type_Mcv;
  public mkb a;
  public mnh a;
  mvj jdField_a_of_type_Mvj = null;
  mxb jdField_a_of_type_Mxb;
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
    this.jdField_a_of_type_Lid = null;
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
    this.jdField_a_of_type_Mkb = null;
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
    if (bdyi.a(this, this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView, paramString, paramInt1, null, paramInt2, false))
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
    mbt.a(BaseApplicationImpl.getContext(), paramBoolean);
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Mvj == null) {
      this.jdField_a_of_type_Mvj = mvj.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    if (mti.a()) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QAVNotification", 2, "updateInviteNotification show[" + paramBoolean + "], mIsAudioMode[" + this.jdField_b_of_type_Boolean + "], isOnlyAudio[" + this.jdField_a_of_type_Lid.R + "], session[" + this.jdField_a_of_type_Lid + "]");
      }
      if (paramBoolean)
      {
        Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_e_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, true, true);
        this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(this.jdField_e_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
        if (this.jdField_a_of_type_Lid.R)
        {
          this.jdField_a_of_type_Mvj.a(true, this.jdField_a_of_type_Lid.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, localBitmap, null, 45, this.jdField_e_of_type_Int, 1);
          return;
        }
        this.jdField_a_of_type_Mvj.a(true, this.jdField_a_of_type_Lid.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, localBitmap, null, 40, this.jdField_e_of_type_Int, 2);
        return;
      }
      this.jdField_a_of_type_Mvj.a(this.jdField_a_of_type_Lid.jdField_c_of_type_JavaLangString);
      return;
      paramBoolean = true;
    }
  }
  
  public void BtnOnClick(View paramView)
  {
    if (this.jdField_a_of_type_Mnh != null) {
      this.jdField_a_of_type_Mnh.BtnOnClick(paramView);
    }
  }
  
  bhpy a(Context paramContext)
  {
    paramContext = new mna(this, paramContext);
    paramContext.getWindow().setWindowAnimations(2131755223);
    return paramContext;
  }
  
  public VideoController a()
  {
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
  }
  
  public void a()
  {
    int i1 = 0;
    if (this.jdField_a_of_type_Lid == null) {}
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
          i2 = mpj.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_c_of_type_JavaLangString, false, this.jdField_b_of_type_Boolean);
        } while (i2 == 0);
        i3 = bdee.a(BaseApplicationImpl.getContext());
        if ((i3 == 4) || (i3 == 1)) {
          i1 = 1;
        }
        i3 = bdyi.a();
        str = bdyi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, i2, bdyi.a(), null);
      } while (TextUtils.isEmpty(str));
      this.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView = bdyi.a(this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
      File localFile = new File(str);
      if ((localFile != null) && (localFile.exists()))
      {
        a(str, i3, i2);
        return;
      }
    } while (i1 == 0);
    this.jdField_j_of_type_Int = i2;
    mpj.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, i2);
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
      mdd.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1040, 2131696411);
      continue;
      mdd.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1040, 2131696406);
      continue;
      mdd.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1040, 2131696408);
    }
  }
  
  public void a(long paramLong)
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "stopRing, mLastPlayRingTime[" + this.jdField_a_of_type_Long + "->" + 0 + "]");
    this.jdField_a_of_type_Long = 0L;
    if (mwk.a() != null) {
      mwk.a().b(paramLong);
    }
  }
  
  public void a(long paramLong, Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (paramContext = a(paramContext);; paramContext = bhpy.a(paramContext))
    {
      paramContext.b(2131696127);
      paramContext.b(2131696129);
      paramContext.b(2131696128);
      if (d()) {
        paramContext.b(2131696126);
      }
      paramContext.c(2131690648);
      paramContext.a(new mmq(this, paramBoolean));
      paramContext.a(new mmr(this, paramContext, paramBoolean, paramLong));
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
    mwk.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if ((this.jdField_l_of_type_Boolean) && (this.jdField_a_of_type_Mkb != null) && (!this.jdField_j_of_type_Boolean)) {
      this.jdField_a_of_type_Mkb.a(new mms(this, paramLong, paramBoolean));
    }
    do
    {
      return;
      if (this.jdField_i_of_type_Boolean)
      {
        a().a(paramLong, this.jdField_c_of_type_JavaLangString, 1, true);
        long l1 = mto.a(this.jdField_c_of_type_JavaLangString);
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
      if (mvn.a(paramIntent)) {
        azmj.b(null, "dc00898", "", "", "0X800A2C5", "0X800A2C5", 0, 0, "", "", "", "");
      }
      long l1 = AudioHelper.b();
      String str1 = paramIntent.getAction();
      String str2;
      if ("com.tencent.qav.notify.accept".equals(str1))
      {
        str2 = paramIntent.getStringExtra("session_id");
        if (this.jdField_a_of_type_Lid == null)
        {
          paramIntent = null;
          if (!TextUtils.equals(str2, paramIntent)) {
            break label194;
          }
          c(l1);
          label98:
          azmj.b(null, "dc00898", "", "", "0X800A2C6", "0X800A2C6", 0, 0, "", "", "", "");
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label266;
        }
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "checkParamAndDoAction action[" + str1 + "], seq[" + l1 + "]");
        return;
        paramIntent = this.jdField_a_of_type_Lid.jdField_c_of_type_JavaLangString;
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
        if (this.jdField_a_of_type_Mnh != null) {
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
        localObject = Integer.valueOf(this.jdField_a_of_type_Mnh.a());
        break label70;
        if (this.jdField_a_of_type_Mnh == null)
        {
          b(bool);
          return;
        }
      } while (i1 == this.jdField_a_of_type_Mnh.a());
      paramString = this.jdField_a_of_type_Mnh;
      this.jdField_a_of_type_Mnh.j();
      b(bool);
      this.jdField_a_of_type_Mnh.a(paramString);
      if (this.jdField_k_of_type_Boolean)
      {
        this.jdField_a_of_type_Mnh.d();
        this.jdField_a_of_type_Mnh.a();
      }
    } while (!this.jdField_l_of_type_Boolean);
    this.jdField_a_of_type_Mnh.g();
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(super.getResources().getColor(2131165964));
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(super.getResources().getColor(2131165964));
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(super.getResources().getColor(2131165964));
      }
      if (this.jdField_a_of_type_Mcv != null)
      {
        this.jdField_a_of_type_Mcv.a(super.getResources().getColor(2131165964));
        this.jdField_a_of_type_Mcv.b(-1291845633);
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
    } while (this.jdField_a_of_type_Mcv == null);
    this.jdField_a_of_type_Mcv.a(-11113603);
    this.jdField_a_of_type_Mcv.b(-11113603);
  }
  
  boolean a()
  {
    boolean bool4 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    Object localObject = super.getIntent();
    if ((localObject != null) && (!mvn.a((Intent)localObject)))
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
    localObject = lfb.a().a();
    boolean bool1 = bool4;
    if (localObject != null)
    {
      this.jdField_e_of_type_Int = ((lid)localObject).jdField_i_of_type_Int;
      this.jdField_c_of_type_JavaLangString = ((lid)localObject).jdField_d_of_type_JavaLangString;
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
      this.jdField_e_of_type_Int = ((lid)localObject).jdField_i_of_type_Int;
      this.jdField_e_of_type_JavaLangString = ((lid)localObject).jdField_f_of_type_JavaLangString;
      this.jdField_d_of_type_Int = a().a();
      this.jdField_b_of_type_Boolean = ((lid)localObject).R;
      bool1 = bool2;
      if (((lid)localObject).jdField_a_of_type_Lie.jdField_b_of_type_Int <= 0) {
        if (((lid)localObject).jdField_a_of_type_Lif.jdField_a_of_type_Int != 0)
        {
          bool1 = bool2;
          if (((lid)localObject).jdField_a_of_type_Lif.jdField_a_of_type_Long > 0L) {}
        }
        else
        {
          bool1 = true;
        }
      }
      this.jdField_g_of_type_Boolean = bool1;
      this.jdField_i_of_type_Boolean = ((lid)localObject).J;
    }
  }
  
  public void b()
  {
    k();
    this.jdField_a_of_type_Mcv = new mcv();
    this.jdField_a_of_type_Mcv.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_Int = 1;
    if ((!bdee.h(super.getApplicationContext())) && (!bdee.f(super.getApplicationContext()))) {
      this.jdField_a_of_type_Int = 2;
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131362969));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131362958));
    if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_f_of_type_JavaLangString);
      mww.a(this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_f_of_type_JavaLangString);
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
      boolean bool = mti.b((String)localObject);
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
        if (!muz.b(this)) {
          break label469;
        }
        if ((this.jdField_c_of_type_Boolean) || (!this.jdField_g_of_type_Boolean)) {
          break label237;
        }
        l1 = System.currentTimeMillis();
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "playRing, mIsRingPlaying[" + this.jdField_a_of_type_Long + "->" + l1 + "], seq[" + paramLong + "]");
      } while (this.jdField_a_of_type_Long != 0L);
      this.jdField_a_of_type_Long = l1;
      mwk.a().b(paramLong);
      if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp() == null))
      {
        this.jdField_b_of_type_Long = 0L;
        if (this.jdField_b_of_type_Long != 0L) {
          break label275;
        }
        mwk.a().a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230742, -1, null);
      }
      for (;;)
      {
        mwk.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false, paramLong);
        return;
        this.jdField_b_of_type_Long = bdyi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount(), 3, false, this.jdField_c_of_type_JavaLangString);
        break;
        localObject = bdnv.a(this.jdField_b_of_type_Long, 3);
        if (new File((String)localObject).exists())
        {
          mwk.a().b(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0, (String)localObject, -1, null);
          azmj.b(null, "CliOper", "", "", "0X8005004", "0X8005004", 0, 0, "", this.jdField_b_of_type_Long + "", "", "");
        }
        else
        {
          mwk.a().a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230742, -1, null);
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
    } while (!muz.a(this));
    label275:
    label469:
    mwk.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false, paramLong);
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TraceLogForAV", 2, "traceLog from[" + paramString + "], seq[" + this.jdField_d_of_type_Long + "], mode[" + this.jdField_a_of_type_Mnh + "]");
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (this.jdField_a_of_type_Mnh = new mnk(this);; this.jdField_a_of_type_Mnh = new mni(this))
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
      this.jdField_a_of_type_Mxb = new mxb(super.getApplicationContext(), 1, "video wifi lock");
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
      if (!ChatActivityUtils.a(this, bool, new mmt(this, paramLong, bool))) {
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
      mwk.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
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
    if (this.jdField_a_of_type_Mxb == null) {
      this.jdField_a_of_type_Mxb = new mxb(super.getApplicationContext(), 1, "video wifi lock");
    }
    if ((muz.e(super.getApplicationContext())) && (this.jdField_a_of_type_Mxb != null)) {
      this.jdField_a_of_type_Mxb.a();
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
    return (!bdhy.a(super.getApplicationContext())) || (Build.VERSION.SDK_INT >= 16);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startVideoChatActivity");
    }
    mwk.a().a();
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
      super.overridePendingTransition(2130772166, 2130772165);
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
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startVideoChatActivity: mBindType = " + this.jdField_f_of_type_Int + ",mBindId = " + this.jdField_b_of_type_JavaLangString + ",BindType = " + this.jdField_a_of_type_Lid.z);
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
    return a().b(this.jdField_c_of_type_JavaLangString);
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
      if (this.jdField_a_of_type_Lid != null) {
        break label127;
      }
    }
    label127:
    for (int i1 = -1;; i1 = this.jdField_a_of_type_Lid.jdField_g_of_type_Int)
    {
      QLog.w(str, 2, i1 + "]");
      if ((this.jdField_a_of_type_Lid == null) || ((!this.jdField_a_of_type_Lid.j()) && (!this.jdField_a_of_type_Lid.k())) || (this.jdField_c_of_type_JavaLangString == null) || (!this.jdField_c_of_type_JavaLangString.equals(this.jdField_a_of_type_Lid.jdField_d_of_type_JavaLangString))) {
        break;
      }
      finish();
      return;
    }
    mwk.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    a(l1);
    if ((this.jdField_l_of_type_Boolean) && (this.jdField_a_of_type_Mkb != null))
    {
      this.jdField_a_of_type_Mkb.a(new mmv(this, l1));
      return;
    }
    this.jdField_d_of_type_Boolean = false;
    if (this.jdField_i_of_type_Boolean)
    {
      long l2 = mto.a(this.jdField_c_of_type_JavaLangString);
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
    return this.jdField_a_of_type_Mnh instanceof mnk;
  }
  
  public void finish()
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "finish", new Throwable());
    super.finish();
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_Mnh != null) {
      this.jdField_a_of_type_Mnh.b();
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Lid == null) {}
    for (;;)
    {
      return;
      Object localObject2 = this.jdField_c_of_type_JavaLangString;
      int i2 = this.jdField_e_of_type_Int;
      int i1 = i2;
      Object localObject1 = localObject2;
      if (this.jdField_a_of_type_Lid.z == 1)
      {
        i1 = i2;
        localObject1 = localObject2;
        if (this.jdField_e_of_type_Int == 9500)
        {
          i1 = i2;
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_Lid.jdField_p_of_type_JavaLangString))
          {
            localObject1 = this.jdField_a_of_type_Lid.jdField_p_of_type_JavaLangString;
            i1 = 0;
          }
        }
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i1, (String)localObject1, this.jdField_e_of_type_JavaLangString, true, true);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
        localObject2 = mww.a(super.getApplicationContext(), 2130841755);
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
          this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Lid.a();
          if (QLog.isColorLevel()) {
            QLog.w(this.jdField_a_of_type_JavaLangString, 2, "mPeerName = " + this.jdField_d_of_type_JavaLangString);
          }
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_d_of_type_JavaLangString);
        return;
        label320:
        localObject2 = mtn.a(super.getApplicationContext(), 2130841755);
        if (localObject2 != null) {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable((Drawable)localObject2);
        } else {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130841755);
        }
      }
    }
  }
  
  void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showGAudioDialog");
    }
    mmz localmmz1 = new mmz(this, 0);
    mmz localmmz2 = new mmz(this, 1);
    bdcd.a(this, 230, null, super.getString(2131695988), 2131721276, 2131695904, localmmz1, localmmz2).show();
  }
  
  void j()
  {
    String str2 = "";
    int i1;
    String str1;
    if (a() != null)
    {
      i1 = this.jdField_a_of_type_Lid.jdField_i_of_type_Int;
      str1 = this.jdField_a_of_type_Lid.jdField_f_of_type_JavaLangString;
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
          str1 = super.getString(2131696117);
        }
        else
        {
          this.jdField_i_of_type_Int = 0;
          str1 = str2;
          continue;
          str1 = super.getString(2131696118) + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(1, str1, null);
          this.jdField_i_of_type_Int = 1;
          continue;
          str1 = super.getString(2131696118) + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(3000, str1, null);
          this.jdField_i_of_type_Int = 2;
          continue;
          str1 = super.getString(2131696115);
          this.jdField_i_of_type_Int = 3;
          continue;
          str1 = super.getString(2131696114);
          this.jdField_i_of_type_Int = 4;
          continue;
          str1 = super.getString(2131696119);
          this.jdField_i_of_type_Int = 5;
          continue;
          str1 = super.getString(2131696116);
          this.jdField_i_of_type_Int = 6;
          continue;
          str1 = super.getString(2131694563);
          this.jdField_i_of_type_Int = 7;
        }
      }
      str1 = null;
      i1 = 0;
    }
  }
  
  void k()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131375991));
    Drawable localDrawable = mtn.a(super.getApplicationContext(), 2130841755);
    if (localDrawable != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(localDrawable);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130841755);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    bngs.a(this);
    if ((bngs.b()) && (bngs.c(this)) && (QLog.isDevelopLevel())) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onAttachedToWindow");
    }
  }
  
  public void onBackPressed()
  {
    if (this.jdField_a_of_type_Mnh != null) {
      this.jdField_a_of_type_Mnh.c();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    long l3 = AudioHelper.b();
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "avideo onCreate, seq[" + l3 + "]");
    b("onCreate");
    if (this.jdField_a_of_type_Mnh == null) {
      b(VideoController.a(getApplicationContext()));
    }
    if (this.jdField_a_of_type_Mnh != null) {
      this.jdField_a_of_type_Mnh.a(true);
    }
    lkx.a(29);
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    super.onCreate(paramBundle);
    super.overridePendingTransition(2130772166, 0);
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
      paramBundle = lfb.a(100, paramBundle, new int[0]);
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)super.getSystemService("audio"));
      this.jdField_a_of_type_Lid = lfb.a().c(paramBundle);
      paramBundle = a();
      if (paramBundle != null) {
        break label998;
      }
      paramBundle = null;
      if (paramBundle != null) {
        paramBundle.a(getClass().getName(), getIntent());
      }
      StringBuilder localStringBuilder;
      if ((this.jdField_a_of_type_Lid == null) || (!this.jdField_a_of_type_Lid.i()))
      {
        if (QLog.isColorLevel())
        {
          paramBundle = this.jdField_a_of_type_JavaLangString;
          localStringBuilder = new StringBuilder().append("session state error! ");
          if (this.jdField_a_of_type_Lid == null) {
            break label1006;
          }
          i1 = this.jdField_a_of_type_Lid.jdField_g_of_type_Int;
          QLog.w(paramBundle, 2, i1);
        }
        if ((this.jdField_a_of_type_Lid == null) || (!this.jdField_a_of_type_Lid.g()) || (this.jdField_c_of_type_JavaLangString == null) || (!this.jdField_c_of_type_JavaLangString.equals(this.jdField_a_of_type_Lid.jdField_d_of_type_JavaLangString))) {
          break label1011;
        }
        if (QLog.isColorLevel()) {
          QLog.w(this.jdField_a_of_type_JavaLangString, 2, "onCreate state[" + this.jdField_a_of_type_Lid.jdField_g_of_type_Int + "], peerUin[" + this.jdField_c_of_type_JavaLangString + "]");
        }
      }
      a(getIntent());
      if (a().jdField_e_of_type_Boolean != true)
      {
        mwk.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), a());
        a(l3);
        if (this.jdField_a_of_type_Lid.jdField_f_of_type_Int != 1) {
          break label1174;
        }
        mwk.a().a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lij);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lhe);
      l2 = System.currentTimeMillis();
      l1 = this.jdField_a_of_type_Lid.k;
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
      this.jdField_h_of_type_Int = muz.a(this);
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Lid.jdField_p_of_type_JavaLangString;
      this.jdField_f_of_type_Int = this.jdField_a_of_type_Lid.z;
      this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_Lid.jdField_a_of_type_ArrayOfByte;
      this.jdField_g_of_type_Int = this.jdField_a_of_type_Lid.jdField_p_of_type_Int;
      paramBundle = new IntentFilter();
      paramBundle.addAction("tencent.video.q2v.ACTION_ON_UPDATE_FRIEND_INFO");
      paramBundle.addAction("tencent.video.q2v.sdk.onRequestVideo");
      paramBundle.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
      paramBundle.addAction("android.intent.action.SCREEN_OFF");
      paramBundle.addAction("android.intent.action.SCREEN_ON");
      paramBundle.addAction("android.intent.action.USER_PRESENT");
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new mnb(this);
      super.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
      j();
      if (this.jdField_e_of_type_Int == 25)
      {
        aubm localaubm = (aubm)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getManager(11);
        localStringBuilder = null;
        paramBundle = localStringBuilder;
        if (localaubm != null)
        {
          paramBundle = localStringBuilder;
          if (this.jdField_e_of_type_JavaLangString != null) {
            paramBundle = localaubm.c(this.jdField_e_of_type_JavaLangString);
          }
        }
        if (paramBundle == null) {
          break label1278;
        }
        paramBundle = localaubm.a(this.jdField_e_of_type_JavaLangString);
        if ((paramBundle == null) || (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramBundle))) {
          break label1242;
        }
        azmj.b(null, "CliOper", "", "", "0X800624D", "0X800624D", 1, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      if ((!this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Lid.i())) {
        d(false);
      }
      paramBundle = getIntent();
      if ((paramBundle != null) && (paramBundle.getBooleanExtra("fullscreen", false))) {
        lgb.b();
      }
      if (this.jdField_a_of_type_Mnh != null) {
        this.jdField_a_of_type_Mnh.d();
      }
      if ((this.jdField_a_of_type_Lid.jdField_i_of_type_Int == 21) || (this.jdField_a_of_type_Lid.jdField_i_of_type_Int == 1011))
      {
        this.jdField_d_of_type_Boolean = true;
        c(l3);
        if (this.jdField_a_of_type_Mnh != null) {
          this.jdField_a_of_type_Mnh.a();
        }
      }
      if (this.jdField_a_of_type_Mkb != null) {
        this.jdField_a_of_type_Mkb.a();
      }
      this.jdField_k_of_type_Boolean = true;
      return;
      paramBundle = lfb.a(3, paramBundle, new int[0]);
      break;
      label998:
      paramBundle = paramBundle.a();
      break label229;
      label1006:
      i1 = -1;
      break label306;
      label1011:
      if ((this.jdField_a_of_type_Lid != null) && ((this.jdField_a_of_type_Lid.j()) || (this.jdField_a_of_type_Lid.k())) && (this.jdField_c_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString.equals(this.jdField_a_of_type_Lid.jdField_d_of_type_JavaLangString)))
      {
        if (QLog.isColorLevel()) {
          QLog.w(this.jdField_a_of_type_JavaLangString, 2, "onCreate state[" + this.jdField_a_of_type_Lid.jdField_g_of_type_Int + "], peerUin[" + this.jdField_c_of_type_JavaLangString + "]");
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
      mwk.a().a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
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
      azmj.b(null, "CliOper", "", "", "0X800624D", "0X800624D", 0, 0, "", "", "", "");
      continue;
      label1278:
      azmj.b(null, "CliOper", "", "", "0X800624D", "0X800624D", 2, 0, "", "", "", "");
    }
  }
  
  public void onDestroy()
  {
    long l1 = AudioHelper.b();
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "avideo onDestroy, seq[" + l1 + "]");
    super.onDestroy();
    if (this.jdField_a_of_type_Mcv != null) {
      this.jdField_a_of_type_Mcv.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    lkv.a(this.jdField_c_of_type_Long);
    this.jdField_c_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_Mxb != null)
    {
      this.jdField_a_of_type_Mxb.a();
      this.jdField_a_of_type_Mxb = null;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lij);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lhe);
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      super.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    a(l1);
    mwk.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_Mxb = null;
    this.jdField_a_of_type_Mvj = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetImageButton = null;
    this.jdField_b_of_type_AndroidWidgetImageButton = null;
    this.jdField_a_of_type_AndroidMediaAudioManager = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_Lij = null;
    this.jdField_a_of_type_Lhe = null;
    if (this.jdField_a_of_type_Mnh != null) {
      this.jdField_a_of_type_Mnh.j();
    }
    this.jdField_a_of_type_Lid = null;
    this.m = true;
    b("onDestroy");
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Mnh != null) {
      bool = this.jdField_a_of_type_Mnh.a(paramInt, paramKeyEvent);
    }
    if (bool) {}
    while (this.jdField_d_of_type_Boolean) {
      return true;
    }
    long l1 = AudioHelper.b();
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onKeyDown, seq[" + l1 + "]");
    if ((paramInt == 25) || (paramInt == 24))
    {
      mwk.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
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
    aobd.a(this, 2, true);
    c(false);
    a().a("state", "0");
    if ("0".equals(lfh.jdField_a_of_type_JavaLangString)) {
      a().a("backgroundReason", "5");
    }
    if (!this.jdField_f_of_type_Boolean) {
      betl.a(BaseApplicationImpl.getContext(), true, 50, 1);
    }
    if (this.jdField_a_of_type_Mcv != null) {
      this.jdField_a_of_type_Mcv.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    if (this.jdField_a_of_type_Mnh != null) {
      this.jdField_a_of_type_Mnh.h();
    }
    this.jdField_l_of_type_Boolean = false;
    this.jdField_a_of_type_Lmz.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, a());
  }
  
  protected void onRestart()
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onRestart");
    super.onRestart();
    if (this.jdField_a_of_type_Mnh != null) {
      this.jdField_a_of_type_Mnh.f();
    }
  }
  
  public void onResume()
  {
    a("onResume");
    long l1 = AudioHelper.b();
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onResume, mCheckQAVPermission[" + this.n + "], isInLockMode[" + f() + "], seq[" + l1 + "]");
    super.onResume();
    aobd.a(this, 2, false);
    betl.a(BaseApplicationImpl.getContext(), 50, 0);
    betl.a(BaseApplicationImpl.getContext(), false, 50, 1);
    betl.a(BaseApplicationImpl.getContext(), 50, 2);
    e();
    this.jdField_c_of_type_Boolean = false;
    c(true);
    lid locallid = lfb.a().a();
    lkz locallkz = (lkz)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
    if ((locallkz != null) && (locallid != null))
    {
      long l2 = System.currentTimeMillis();
      long l3 = lyg.a().jdField_b_of_type_Long;
      locallkz.a(locallid.b(), 24, l2 - l3);
    }
    a().a(VideoInviteActivity.class);
    a().a("state", "1");
    lfh.jdField_a_of_type_JavaLangString = "0";
    if (this.jdField_a_of_type_Mcv != null) {
      this.jdField_a_of_type_Mcv.c(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    if (!this.n)
    {
      this.n = true;
      ChatActivityUtils.a(this, true, new mmm(this, l1));
    }
    if (this.jdField_a_of_type_Mnh != null) {
      this.jdField_a_of_type_Mnh.g();
    }
    if (!f()) {
      b(l1);
    }
    this.jdField_l_of_type_Boolean = true;
    this.jdField_a_of_type_Lmz.a(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, a());
  }
  
  public void onStart()
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onStart");
    super.onStart();
    if (this.jdField_a_of_type_Mnh != null) {
      this.jdField_a_of_type_Mnh.e();
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
    boolean bool = muz.b(this);
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "avideo onStop, isRingerNormal[" + bool + "], mIsAccepted[" + this.jdField_d_of_type_Boolean + "], seq[" + l1 + "]");
    super.onStop();
    if ((bool) && (!this.jdField_d_of_type_Boolean)) {
      a(l1);
    }
    if (this.jdField_a_of_type_Lid == null) {
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 2, "onStop mSessionInfo is null ");
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Mnh != null) {
        this.jdField_a_of_type_Mnh.i();
      }
      this.jdField_l_of_type_Boolean = false;
    } while ((this.jdField_e_of_type_Boolean) || (!this.jdField_a_of_type_Lid.i()));
    d(true);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (this.jdField_a_of_type_Mnh != null) {
      this.jdField_a_of_type_Mnh.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteActivity
 * JD-Core Version:    0.7.0.1
 */