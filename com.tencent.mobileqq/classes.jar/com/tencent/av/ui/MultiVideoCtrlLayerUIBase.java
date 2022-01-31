package com.tencent.av.ui;

import actj;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import axqy;
import bbdj;
import bbfj;
import bbgu;
import bfly;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import ldr;
import lfb;
import lfp;
import lga;
import llw;
import lon;
import lsq;
import lze;
import mag;
import mao;
import mcf;
import mfn;
import mfo;
import mfp;
import mfq;
import mfr;
import mfs;
import mft;
import mfu;
import mfv;
import mhj;
import mqq.app.BaseActivity;
import mqq.app.MobileQQ;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mqq.os.MqqHandler;
import mqw;
import mre;
import mru;
import msn;
import msp;
import mtc;
import mtq;

public abstract class MultiVideoCtrlLayerUIBase
  extends VideoControlUI
{
  static int jdField_b_of_type_Int;
  public long a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new mfq(this);
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  bfly jdField_a_of_type_Bfly = null;
  public MultiMembersAudioUI a;
  MultiMembersVideoUI jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI = null;
  public MultiVideoCtrlLayerUIBase.InviteUserNoticeRunnable a;
  MultiVideoCtrlLayerUIBase.StartRecvVideoRunnable jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable = new MultiVideoCtrlLayerUIBase.StartRecvVideoRunnable(this);
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  String jdField_a_of_type_JavaLangString = null;
  private lfp jdField_a_of_type_Lfp = new mfn(this);
  mhj jdField_a_of_type_Mhj = null;
  mru jdField_a_of_type_Mru = new mfr(this);
  msp jdField_a_of_type_Msp = null;
  private boolean jdField_a_of_type_Boolean;
  public long b;
  TextView jdField_b_of_type_AndroidWidgetTextView = null;
  Runnable jdField_b_of_type_JavaLangRunnable = null;
  String jdField_b_of_type_JavaLangString;
  lfb jdField_b_of_type_Lfb = new mfv(this);
  public boolean b;
  public int c;
  public long c;
  TextView jdField_c_of_type_AndroidWidgetTextView = null;
  Runnable jdField_c_of_type_JavaLangRunnable = null;
  boolean jdField_c_of_type_Boolean = false;
  public int d;
  Runnable d;
  public boolean d;
  public int e;
  public Runnable e;
  public boolean e;
  public int f;
  public Runnable f;
  boolean f;
  public int g;
  Runnable g;
  int h;
  int i = 0;
  int j = 1;
  
  static
  {
    int k = 16;
    jdField_b_of_type_Int = 16;
    if (Build.VERSION.SDK_INT >= 21) {}
    for (;;)
    {
      jdField_b_of_type_Int = k;
      return;
      k = 9;
    }
  }
  
  public MultiVideoCtrlLayerUIBase(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, mcf parammcf)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, parammcf);
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI = null;
    this.jdField_d_of_type_JavaLangRunnable = null;
    this.jdField_e_of_type_JavaLangRunnable = null;
    this.jdField_f_of_type_JavaLangRunnable = null;
    this.jdField_h_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_g_of_type_JavaLangRunnable = new MultiVideoCtrlLayerUIBase.3(this);
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$InviteUserNoticeRunnable = new MultiVideoCtrlLayerUIBase.InviteUserNoticeRunnable(this);
  }
  
  public void A()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_c_of_type_JavaLangString, 2, "cancelNotification");
    }
    if (this.jdField_a_of_type_Msp != null) {
      this.jdField_a_of_type_Msp.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentAvVideoController.t();
  }
  
  public void B()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_c_of_type_JavaLangString, 2, "showNotification quit[" + this.jdField_b_of_type_Boolean + "], inRoom[" + this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean + "]");
      }
    } while ((this.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean));
    String str1;
    String str2;
    Bitmap localBitmap;
    if (this.jdField_a_of_type_Msp != null)
    {
      lga locallga = this.jdField_a_of_type_ComTencentAvVideoController.a();
      str1 = String.valueOf(locallga.jdField_g_of_type_Long);
      str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(this.jdField_d_of_type_Int, str1, null);
      localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_d_of_type_Int, str1, null, true, true);
      k = 44;
      if (locallga.k()) {
        if (locallga.jdField_d_of_type_Int != 3) {
          break label202;
        }
      }
    }
    label202:
    for (int k = 62;; k = 63)
    {
      this.jdField_a_of_type_Msp.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, str2, localBitmap, str1, k, this.jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
      this.jdField_a_of_type_ComTencentAvVideoController.s();
      return;
    }
  }
  
  protected int a()
  {
    return 2131559510;
  }
  
  public int a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onApnChanged --> NetType = " + paramInt);
    }
    DoubleVideoCtrlUI.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt);
    if ((bbfj.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean) && (this.jdField_f_of_type_Boolean)) {
      e();
    }
    return 0;
  }
  
  public Intent a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localAVActivity != null) {
        return localAVActivity.getIntent();
      }
    }
    return null;
  }
  
  public String a(String paramString, int paramInt, TextView paramTextView)
  {
    String str;
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "genDiscussTitle, name == null");
      }
      str = "";
    }
    TextPaint localTextPaint;
    float f2;
    float f1;
    do
    {
      do
      {
        return str;
        int k = actj.a(160.0F, this.jdField_a_of_type_AndroidContentResResources);
        localTextPaint = paramTextView.getPaint();
        f2 = k - localTextPaint.measureText(String.format("(%d)", new Object[] { Integer.valueOf(paramInt) })) - 4.0F * this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().density;
        str = paramString;
      } while (f2 <= 0.0F);
      f1 = localTextPaint.measureText(paramString);
      str = paramString;
    } while (f1 <= f2);
    float f3 = f2 - localTextPaint.measureText("…");
    paramTextView = paramString;
    for (;;)
    {
      if ((f3 > 0.0F) && (f1 > f3) && (paramTextView.length() > 0))
      {
        paramTextView = paramTextView.substring(0, paramTextView.length() - 1);
        f2 = localTextPaint.measureText(paramTextView);
        f1 = f2;
        if (f2 == 0.0F)
        {
          f1 = f2;
          if (paramTextView.length() > 0) {
            f1 = 1.0F + f3;
          }
        }
        if (QLog.isDevelopLevel()) {
          QLog.d(this.jdField_c_of_type_JavaLangString, 2, "genDiscussTitle, name widht[" + f1 + "]");
        }
      }
      else
      {
        str = paramString;
        if (f3 <= 0.0F) {
          break;
        }
        str = paramString;
        if (paramTextView.length() <= 0) {
          break;
        }
        return paramTextView + "…";
      }
    }
  }
  
  ArrayList<ldr> a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      return this.jdField_a_of_type_ComTencentAvVideoController.c();
    }
    return null;
  }
  
  abstract void a();
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    super.a(paramInt1, paramInt2, paramString);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onVideoViewModeChange --> lastMode = " + paramInt1 + " , currentMode = " + paramInt2 + ",bigUin=" + paramString);
    }
    if ((paramInt1 == paramInt2) || (this.jdField_f_of_type_Boolean)) {}
    label95:
    label98:
    label230:
    do
    {
      return;
      boolean bool;
      int k;
      if (paramInt2 == 3)
      {
        bool = true;
        if (4 == this.jdField_a_of_type_ComTencentAvVideoController.g()) {
          break label225;
        }
        paramInt1 = 1;
        k = 1;
        if (k >= this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size()) {
          continue;
        }
        paramString = (lon)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(k);
        paramString.jdField_a_of_type_Boolean = bool;
        if ((paramInt1 != 0) && (!paramString.jdField_c_of_type_Boolean))
        {
          int m = this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_c_of_type_Long);
          if (m != -1) {
            ((lon)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(m)).jdField_c_of_type_Boolean = false;
          }
        }
        if ((paramInt2 != 3) || (paramInt1 == 0)) {
          break label230;
        }
      }
      for (paramString.jdField_c_of_type_Boolean = false;; paramString.jdField_c_of_type_Boolean = true)
      {
        k += 1;
        break label98;
        bool = false;
        break;
        paramInt1 = 0;
        break label95;
      }
    } while (!e());
    label225:
    this.jdField_a_of_type_ComTencentAvVideoController.a().ac = true;
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onStart, seq[" + paramLong + "]");
    }
    super.a(paramLong);
    if (this.jdField_c_of_type_Boolean)
    {
      o(this.jdField_b_of_type_Long);
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onGroupVideoChatClosed, relationId[" + paramLong + "], mIntentRelationId[" + this.jdField_a_of_type_Long + "]");
    }
    if (this.jdField_a_of_type_Long != paramLong) {}
    do
    {
      return;
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.av.v2q.MultiVideo");
      localIntent.putExtra("type", 32);
      localIntent.putExtra("relationId", paramLong);
      localIntent.putExtra("uinType", this.jdField_d_of_type_Int);
      localIntent.putExtra("closeType", paramInt1);
      localIntent.putExtra("MultiAVType", paramInt2);
      localIntent.putExtra("from", this.jdField_c_of_type_JavaLangString);
      AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localAVActivity != null)
      {
        localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName());
        localAVActivity.sendBroadcast(localIntent);
        d(true);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e(this.jdField_c_of_type_JavaLangString, 2, "onGroupVideoChatClosed-->can not get the activity");
  }
  
  abstract void a(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2);
  
  void a(long paramLong, String paramString)
  {
    String str;
    if (QLog.isColorLevel())
    {
      str = this.jdField_c_of_type_JavaLangString;
      paramString = new StringBuilder().append("closeRemoteVideo[").append(paramString).append("], seq[").append(paramLong).append("], mVideoController[");
      if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
        break label84;
      }
    }
    label84:
    for (boolean bool = true;; bool = false)
    {
      QLog.d(str, 2, bool + "]");
      if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
        break;
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.f();
    this.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, "closeRemoteVideo", false, true);
    a("closeRemoteVideo", paramLong);
    e("closeRemoteVideo");
    this.jdField_b_of_type_Mcf.update(null, new Object[] { Integer.valueOf(104), this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList });
  }
  
  void a(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "notifyDataChangeByQuitUin, from[" + paramString + "], seq[" + paramLong1 + "]");
    }
    Object localObject;
    if ((paramInt == 1) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      localObject = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      localObject = this.jdField_a_of_type_ComTencentAvVideoController;
      if (this.k == 3) {
        break label110;
      }
    }
    label110:
    for (boolean bool = true;; bool = false)
    {
      ((VideoController)localObject).a(paramLong2, bool);
      b(paramLong1, paramString);
      return;
    }
  }
  
  void a(long paramLong, ArrayList<ldr> paramArrayList)
  {
    if (g()) {}
    int k;
    do
    {
      return;
      if (paramArrayList != null) {
        break;
      }
      k = 0;
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "doInternalUIFreash, gaFList[" + k + "], seq[" + paramLong + "]");
      }
    } while (this.jdField_a_of_type_AndroidContentResResources == null);
    if (k <= 1) {
      g(paramLong, 2131695870);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI != null) {
        this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(paramArrayList);
      }
      ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a.a(paramArrayList);
      d(paramLong, k);
      return;
      k = paramArrayList.size();
      break;
      d(paramLong, null);
    }
  }
  
  void a(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI != null) {
      this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(paramLong, paramBoolean);
    }
    for (;;)
    {
      ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a.a(paramLong, paramBoolean);
      return;
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "notifyMemberSpeak, MemberUI is null --> Uin = " + paramLong + " , Speak = " + paramBoolean);
      }
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt) {}
  
  abstract void a(Intent paramIntent);
  
  /* Error */
  public void a(String arg1, int paramInt1, String paramString2, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iload_2
    //   3: aload_3
    //   4: iload 4
    //   6: invokespecial 536	com/tencent/av/ui/VideoControlUI:a	(Ljava/lang/String;ILjava/lang/String;I)V
    //   9: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +62 -> 74
    //   15: aload_0
    //   16: getfield 162	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   19: iconst_2
    //   20: new 186	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   27: ldc_w 538
    //   30: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_1
    //   34: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc_w 540
    //   40: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_2
    //   44: invokevirtual 246	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: ldc_w 542
    //   50: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload_3
    //   54: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc_w 544
    //   60: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: iload 4
    //   65: invokevirtual 246	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   68: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 248	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: aload_1
    //   75: ifnull +7 -> 82
    //   78: aload_3
    //   79: ifnonnull +4 -> 83
    //   82: return
    //   83: aload_0
    //   84: getfield 131	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_f_of_type_Boolean	Z
    //   87: ifne -5 -> 82
    //   90: aload_3
    //   91: invokestatic 549	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   94: invokevirtual 553	java/lang/Long:longValue	()J
    //   97: lstore 6
    //   99: iload_2
    //   100: iconst_2
    //   101: if_icmpne +20 -> 121
    //   104: aload_0
    //   105: sipush 1036
    //   108: invokevirtual 556	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:i	(I)V
    //   111: aload_0
    //   112: getfield 219	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   115: sipush 1036
    //   118: invokestatic 559	mao:a	(Lcom/tencent/av/app/VideoAppInterface;I)V
    //   121: aload_0
    //   122: getfield 154	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   125: invokevirtual 172	com/tencent/av/VideoController:a	()Llga;
    //   128: aload_1
    //   129: invokestatic 549	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   132: invokevirtual 553	java/lang/Long:longValue	()J
    //   135: iload_2
    //   136: invokevirtual 562	lga:a	(JI)I
    //   139: istore 5
    //   141: iload 5
    //   143: iconst_m1
    //   144: if_icmpeq -62 -> 82
    //   147: aload_0
    //   148: getfield 154	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   151: invokevirtual 172	com/tencent/av/VideoController:a	()Llga;
    //   154: getfield 365	lga:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   157: iload 5
    //   159: invokevirtual 373	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   162: checkcast 375	lon
    //   165: astore_3
    //   166: iconst_0
    //   167: istore_2
    //   168: iload_2
    //   169: aload_0
    //   170: getfield 154	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   173: invokevirtual 172	com/tencent/av/VideoController:a	()Llga;
    //   176: getfield 365	lga:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   179: invokevirtual 370	java/util/ArrayList:size	()I
    //   182: if_icmpge +377 -> 559
    //   185: aload_0
    //   186: getfield 154	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   189: invokevirtual 172	com/tencent/av/VideoController:a	()Llga;
    //   192: getfield 365	lga:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   195: iload_2
    //   196: invokevirtual 373	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   199: checkcast 375	lon
    //   202: astore 8
    //   204: lload 6
    //   206: aload 8
    //   208: getfield 563	lon:jdField_a_of_type_Long	J
    //   211: lcmp
    //   212: ifne +371 -> 583
    //   215: iload 4
    //   217: aload 8
    //   219: getfield 565	lon:jdField_a_of_type_Int	I
    //   222: if_icmpne +361 -> 583
    //   225: aload_3
    //   226: iconst_0
    //   227: putfield 376	lon:jdField_a_of_type_Boolean	Z
    //   230: aload_3
    //   231: getfield 563	lon:jdField_a_of_type_Long	J
    //   234: aload_0
    //   235: getfield 57	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_c_of_type_Long	J
    //   238: lcmp
    //   239: ifeq +32 -> 271
    //   242: aload 8
    //   244: getfield 563	lon:jdField_a_of_type_Long	J
    //   247: aload_0
    //   248: getfield 57	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_c_of_type_Long	J
    //   251: lcmp
    //   252: ifeq +19 -> 271
    //   255: iconst_4
    //   256: aload_0
    //   257: getfield 154	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   260: invokevirtual 362	com/tencent/av/VideoController:g	()I
    //   263: if_icmpeq +8 -> 271
    //   266: aload_3
    //   267: iconst_0
    //   268: putfield 377	lon:jdField_c_of_type_Boolean	Z
    //   271: aload 8
    //   273: iconst_1
    //   274: putfield 376	lon:jdField_a_of_type_Boolean	Z
    //   277: iconst_4
    //   278: aload_0
    //   279: getfield 154	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   282: invokevirtual 362	com/tencent/av/VideoController:g	()I
    //   285: if_icmpeq +55 -> 340
    //   288: aload 8
    //   290: getfield 377	lon:jdField_c_of_type_Boolean	Z
    //   293: ifne +47 -> 340
    //   296: aload_0
    //   297: getfield 154	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   300: invokevirtual 172	com/tencent/av/VideoController:a	()Llga;
    //   303: aload_0
    //   304: getfield 57	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_c_of_type_Long	J
    //   307: invokevirtual 380	lga:a	(J)I
    //   310: istore 4
    //   312: iload 4
    //   314: iconst_m1
    //   315: if_icmpeq +25 -> 340
    //   318: aload_0
    //   319: getfield 154	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   322: invokevirtual 172	com/tencent/av/VideoController:a	()Llga;
    //   325: getfield 365	lga:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   328: iload 4
    //   330: invokevirtual 373	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   333: checkcast 375	lon
    //   336: iconst_0
    //   337: putfield 377	lon:jdField_c_of_type_Boolean	Z
    //   340: aload 8
    //   342: iconst_1
    //   343: putfield 377	lon:jdField_c_of_type_Boolean	Z
    //   346: aload 8
    //   348: getfield 563	lon:jdField_a_of_type_Long	J
    //   351: aload_0
    //   352: getfield 57	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_c_of_type_Long	J
    //   355: lcmp
    //   356: ifne +44 -> 400
    //   359: aload_0
    //   360: getfield 53	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_e_of_type_Int	I
    //   363: iconst_2
    //   364: if_icmpne +36 -> 400
    //   367: aconst_null
    //   368: ldc_w 567
    //   371: ldc_w 282
    //   374: ldc_w 282
    //   377: ldc_w 569
    //   380: ldc_w 569
    //   383: iconst_0
    //   384: iconst_0
    //   385: ldc_w 282
    //   388: ldc_w 282
    //   391: ldc_w 282
    //   394: ldc_w 282
    //   397: invokestatic 574	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   400: aload 8
    //   402: getfield 575	lon:jdField_b_of_type_Boolean	Z
    //   405: ifne +27 -> 432
    //   408: aload_0
    //   409: getfield 154	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   412: invokevirtual 362	com/tencent/av/VideoController:g	()I
    //   415: iconst_4
    //   416: if_icmpeq +16 -> 432
    //   419: aload_0
    //   420: getfield 154	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   423: invokevirtual 172	com/tencent/av/VideoController:a	()Llga;
    //   426: getfield 578	lga:C	I
    //   429: invokestatic 582	mqw:b	(I)V
    //   432: aload_0
    //   433: getfield 154	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   436: invokevirtual 172	com/tencent/av/VideoController:a	()Llga;
    //   439: getfield 365	lga:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   442: iload 5
    //   444: aload 8
    //   446: invokevirtual 586	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   449: pop
    //   450: aload_0
    //   451: getfield 154	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   454: invokevirtual 172	com/tencent/av/VideoController:a	()Llga;
    //   457: getfield 365	lga:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   460: iload_2
    //   461: aload_3
    //   462: invokevirtual 586	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   465: pop
    //   466: aload_0
    //   467: getfield 154	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   470: invokevirtual 172	com/tencent/av/VideoController:a	()Llga;
    //   473: getfield 588	lga:jdField_d_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   476: astore_1
    //   477: aload_1
    //   478: monitorenter
    //   479: aload_0
    //   480: getfield 154	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   483: invokevirtual 172	com/tencent/av/VideoController:a	()Llga;
    //   486: getfield 588	lga:jdField_d_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   489: iload 5
    //   491: aload 8
    //   493: invokevirtual 586	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   496: pop
    //   497: aload_0
    //   498: getfield 154	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   501: invokevirtual 172	com/tencent/av/VideoController:a	()Llga;
    //   504: getfield 588	lga:jdField_d_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   507: iload_2
    //   508: aload_3
    //   509: invokevirtual 586	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   512: pop
    //   513: aload_0
    //   514: getfield 154	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   517: invokevirtual 172	com/tencent/av/VideoController:a	()Llga;
    //   520: invokevirtual 590	lga:c	()V
    //   523: aload_1
    //   524: monitorexit
    //   525: aload_0
    //   526: getfield 256	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   529: invokevirtual 262	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   532: checkcast 274	com/tencent/av/ui/AVActivity
    //   535: getfield 516	com/tencent/av/ui/AVActivity:a	Lcom/tencent/av/ui/VideoLayerUI;
    //   538: aload 8
    //   540: getfield 563	lon:jdField_a_of_type_Long	J
    //   543: aload 8
    //   545: getfield 565	lon:jdField_a_of_type_Int	I
    //   548: aload_3
    //   549: getfield 563	lon:jdField_a_of_type_Long	J
    //   552: aload_3
    //   553: getfield 565	lon:jdField_a_of_type_Int	I
    //   556: invokevirtual 593	com/tencent/av/ui/VideoLayerUI:a	(JIJI)V
    //   559: aload_0
    //   560: invokevirtual 271	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:e	()Z
    //   563: pop
    //   564: return
    //   565: astore_1
    //   566: aload_0
    //   567: getfield 162	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   570: iconst_2
    //   571: ldc_w 595
    //   574: invokestatic 458	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   577: return
    //   578: astore_3
    //   579: aload_1
    //   580: monitorexit
    //   581: aload_3
    //   582: athrow
    //   583: iload_2
    //   584: iconst_1
    //   585: iadd
    //   586: istore_2
    //   587: goto -419 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	590	0	this	MultiVideoCtrlLayerUIBase
    //   0	590	2	paramInt1	int
    //   0	590	3	paramString2	String
    //   0	590	4	paramInt2	int
    //   139	351	5	k	int
    //   97	108	6	l	long
    //   202	342	8	locallon	lon
    // Exception table:
    //   from	to	target	type
    //   90	99	565	java/lang/Exception
    //   479	525	578	finally
    //   579	581	578	finally
  }
  
  public void a(String paramString, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    lga locallga;
    do
    {
      return;
      locallga = this.jdField_a_of_type_ComTencentAvVideoController.a();
    } while (locallga == null);
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "switchUIMode[" + paramString + "], SessionType[" + locallga.jdField_d_of_type_Int + "], seq[" + paramLong + "]");
    }
    if (locallga.jdField_d_of_type_Int == 4)
    {
      this.jdField_a_of_type_Mtc.c(false);
      this.jdField_a_of_type_Mtc.b(false);
      this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setVisibility(8);
      ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a.i(this.jdField_a_of_type_ComTencentAvVideoController.a().M);
      ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a.a(this.jdField_a_of_type_ComTencentAvVideoController.a());
      x();
      if (!locallga.j) {
        break label391;
      }
    }
    label391:
    for (int k = 2;; k = 1)
    {
      a(true, k);
      if (this.jdField_a_of_type_Mtq != null) {
        this.jdField_a_of_type_Mtq.a(true);
      }
      a(true);
      b(true);
      e(paramLong, 0);
      h(paramLong, 8);
      for (boolean bool = true;; bool = false)
      {
        a(Boolean.valueOf(bool));
        f(paramLong, 65535);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(102) });
        return;
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        o(true);
        this.jdField_a_of_type_Mtc.c(true);
        this.jdField_a_of_type_Mtc.b(true);
        this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setVisibility(0);
        paramString = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (!paramString.isFinishing()) {
          paramString.a.i(-1);
        }
        x();
        a(false, 1);
        if (this.jdField_a_of_type_Mtq != null) {
          this.jdField_a_of_type_Mtq.a(false);
        }
        a(false);
        b(false);
        e(paramLong, 8);
        h(paramLong, 0);
        a(paramLong, 0.0F);
      }
    }
  }
  
  void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(8);
      }
    }
    do
    {
      return;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    } while (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar == null);
    this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(0);
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "showOrHideRecvVideoBtnAndTips --> bShow = " + paramBoolean1 + " , needNoticeWiFiTips = " + paramBoolean2 + " , needShowGLView = " + paramBoolean3);
    }
    this.jdField_f_of_type_Boolean = paramBoolean1;
    if (this.jdField_a_of_type_Mag != null) {
      this.jdField_a_of_type_Mag.a(paramBoolean1, new mfu(this));
    }
    if (paramBoolean1)
    {
      mqw.d(bbfj.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()), this.jdField_a_of_type_ComTencentAvVideoController.a().C);
      K();
      if (paramBoolean2) {
        mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3013);
      }
    }
    for (;;)
    {
      if (paramBoolean3) {
        b(AudioHelper.b(), this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList);
      }
      return;
      mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3013);
      continue;
      mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3013);
      mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1030);
    }
  }
  
  boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "checkRemoteVideo --> VideoController is null");
      }
      return false;
    }
    lga locallga = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "checkRemoteVideo, displayViewList[" + locallga.jdField_c_of_type_JavaUtilArrayList.size() + "], seq[" + paramLong + "]");
    }
    if (locallga.jdField_c_of_type_JavaUtilArrayList.size() == 0)
    {
      a(paramLong, "checkRemoteVideo");
      a(false, false, false);
      return false;
    }
    if ((locallga.jdField_c_of_type_JavaUtilArrayList.size() == 1) && (((lon)locallga.jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long == this.jdField_c_of_type_Long))
    {
      a(false, false, false);
      e("checkRemoteVideo");
      return false;
    }
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    int k = 2;
    lga locallga = this.jdField_a_of_type_ComTencentAvVideoController.a();
    boolean bool2 = msn.h();
    boolean bool1;
    if ((!locallga.aa) && (!locallga.ab))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "checkBlockOpenMicOrCamera, isAllowedControlMicAfterBeMuted[" + bool2 + "], isNormalUser[" + bool1 + "], isRoomMicOff[" + locallga.U + "], micAuthByAdmin[" + locallga.G + "], openMic[" + paramBoolean + "]");
      }
      if ((!bool1) || (!locallga.U) || (locallga.G == 0)) {
        break label226;
      }
      if (!paramBoolean) {
        break label219;
      }
    }
    label219:
    for (int m = 2131695855;; m = 2131696017)
    {
      mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1033, this.jdField_a_of_type_AndroidContentResResources.getString(m));
      if (paramBoolean) {
        k = 1;
      }
      axqy.b(null, "dc00898", "", "", "0X800AB7F", "0X800AB7F", k, 0, "1", "", "", "");
      return true;
      bool1 = false;
      break;
    }
    label226:
    if ((!bool2) && (bool1) && (locallga.G == 1))
    {
      if (paramBoolean) {}
      for (m = 2131695858;; m = 2131696018)
      {
        mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1033, this.jdField_a_of_type_AndroidContentResResources.getString(m));
        if (paramBoolean) {
          k = 1;
        }
        axqy.b(null, "CliOper", "", "", "0X800AB7F", "0X800AB7F", k, 0, "2", "", "", "");
        return true;
      }
    }
    return false;
  }
  
  void b()
  {
    long l = AudioHelper.b();
    lga locallga = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "initUI, SessionType[" + locallga.jdField_d_of_type_Int + "], switchToGAudioMode[" + locallga.F + "], localMute[" + locallga.jdField_g_of_type_Boolean + "], seq[" + l + "]");
    super.b();
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      p();
      this.jdField_a_of_type_ComTencentAvUiQavPanel.e();
      localObject = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null)
      {
        this.jdField_a_of_type_Mtq = mtq.a();
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_Mtq);
        this.jdField_a_of_type_Mtc = mtc.a(this.jdField_a_of_type_Mtc, (Activity)localObject, this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_Mtq);
        this.jdField_a_of_type_Mtc.a(true);
        this.jdField_a_of_type_Mtq.a();
      }
    }
    this.jdField_d_of_type_AndroidWidgetTextView.post(this.jdField_g_of_type_JavaLangRunnable);
    i(l, 8);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372258));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369868));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131375260));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372259));
    f(l, 65535);
    Object localObject = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "initUI-->can not get AVActivity");
      }
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372512));
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI = ((MultiMembersAudioUI)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372407));
    this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI = ((MultiMembersVideoUI)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372408));
    int k = ImmersiveUtils.b();
    if (ImmersiveUtils.isSupporImmersive() != 1) {
      k -= ImmersiveUtils.getStatusBarHeight((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    }
    for (;;)
    {
      k = (int)(k * 58 / 1000.0F);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.getLayoutParams();
      localMarginLayoutParams.topMargin = k;
      this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setLayoutParams(localMarginLayoutParams);
      this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI.setVisibility(8);
      r();
      mre.a(((AVActivity)localObject).getApplicationContext());
      if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean)
      {
        this.jdField_a_of_type_Mtc.b(true);
        this.jdField_a_of_type_Mtc.c(true);
        if ((this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) && (!this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.b())) {
          this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.i();
        }
      }
      if ((locallga.a()) && (locallga.jdField_g_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a("MultiVideoCtrlLayerUIBase.initUI", locallga.jdField_g_of_type_Long, false, true);
        super.k(2131372216);
      }
      this.jdField_a_of_type_Mtq.a();
      if (this.jdField_f_of_type_JavaLangRunnable == null) {
        this.jdField_f_of_type_JavaLangRunnable = new MultiVideoCtrlLayerUIBase.RefreshDisplayNameRunnable(this);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.jdField_f_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Mhj = new mhj((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentAvVideoController, 3, this.jdField_a_of_type_ComTencentAvUiQavPanel, this.jdField_c_of_type_AndroidWidgetRelativeLayout, null, null, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372387), null);
      this.jdField_a_of_type_Mhj.a();
      if (locallga.jdField_d_of_type_Int == 4) {
        a("initUI", l);
      }
      ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a.b(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.h());
      if (AudioHelper.a(0) != 1) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setBackgroundColor(531496751);
      return;
    }
  }
  
  void b(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(paramInt1, paramInt2);
  }
  
  abstract void b(int paramInt1, int paramInt2, String paramString1, String paramString2);
  
  public void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onResume, seq[" + paramLong + "]");
    }
    super.b(paramLong);
    n(paramLong);
    p(paramLong);
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.a().am = false;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean)) {
      q();
    }
    if (this.jdField_d_of_type_JavaLangRunnable == null)
    {
      this.jdField_d_of_type_JavaLangRunnable = new MultiVideoCtrlLayerUIBase.RefreshFaceRunnable(this);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_d_of_type_JavaLangRunnable, 2000L);
    }
  }
  
  public void b(long paramLong, int paramInt)
  {
    this.r = paramInt;
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a().q())) {
      return;
    }
    this.jdField_f_of_type_Int = (360 - paramInt);
    a(paramLong, this.jdField_f_of_type_Int);
  }
  
  void b(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "notifyDataChange, from[" + paramString + "], seq[" + paramLong + "]");
    }
    paramString = this.jdField_a_of_type_ComTencentAvVideoController.a();
    ThreadManager.getSubThreadHandler().post(new MultiVideoCtrlLayerUIBase.5(this, paramString, paramLong));
  }
  
  public void b(long paramLong, ArrayList<lon> paramArrayList)
  {
    int k = 0;
    for (;;)
    {
      if (k < paramArrayList.size())
      {
        if ((((lon)paramArrayList.get(k)).jdField_a_of_type_Long == this.jdField_c_of_type_Long) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().j)) {
          paramArrayList.remove(k);
        }
      }
      else
      {
        this.jdField_b_of_type_Mcf.update(null, new Object[] { Integer.valueOf(103), paramArrayList, Long.valueOf(paramLong) });
        return;
      }
      k += 1;
    }
  }
  
  void b(Intent paramIntent)
  {
    try
    {
      this.jdField_c_of_type_Long = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
      lga locallga = this.jdField_a_of_type_ComTencentAvVideoController.a();
      this.jdField_d_of_type_Int = locallga.i;
      if (this.jdField_d_of_type_Int == 3000)
      {
        this.jdField_e_of_type_Int = 2;
        locallga.E = this.jdField_e_of_type_Int;
        int k = locallga.D;
        this.jdField_a_of_type_Long = locallga.jdField_g_of_type_Long;
        this.jdField_c_of_type_Int = locallga.D;
        this.jdField_a_of_type_Boolean = false;
        if (paramIntent != null) {
          this.jdField_e_of_type_Boolean = paramIntent.getBooleanExtra("isVideo", false);
        }
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "processIntentData, mUinType[" + this.jdField_d_of_type_Int + "], mRelationType[" + this.jdField_e_of_type_Int + "], mIntentRelationId[" + this.jdField_a_of_type_Long + "], mStatusType[" + this.jdField_c_of_type_Int + "], mStatusType[" + k + "->" + this.jdField_c_of_type_Int + "], getSimpleDataList[" + this.jdField_a_of_type_ComTencentAvVideoController.e() + "], getGAudioList[" + this.jdField_a_of_type_ComTencentAvVideoController.c() + "]");
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_c_of_type_JavaLangString, 2, "Can not get AccountUin WHY!!!???");
        }
        this.jdField_c_of_type_Long = 0L;
        continue;
        if (this.jdField_d_of_type_Int == 1) {
          this.jdField_e_of_type_Int = 1;
        }
      }
    }
  }
  
  void b(boolean paramBoolean)
  {
    Object localObject = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "switchMode --> Can not get activity");
      }
    }
    do
    {
      RelativeLayout localRelativeLayout;
      do
      {
        return;
        localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372265);
        localObject = (AVActivity)localObject;
        if (!paramBoolean) {
          break;
        }
        localRelativeLayout.setBackgroundColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131167087));
      } while (localObject == null);
      ((AVActivity)localObject).b(false);
      ((AVActivity)localObject).f(false);
      ((AVActivity)localObject).c(true);
      return;
      localRelativeLayout.setBackgroundColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131165924));
    } while (localObject == null);
    ((AVActivity)localObject).b(true);
    ((AVActivity)localObject).f(true);
    ((AVActivity)localObject).c(false);
  }
  
  protected boolean b()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentAvVideoController.a().k();
  }
  
  abstract void c();
  
  public void c(int paramInt)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "showToolBars");
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().q())
    {
      e(paramInt);
      z(l);
    }
  }
  
  public void c(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 2, "onStop, seq[" + paramLong + "]");
    }
    super.c(paramLong);
    B();
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void c(long paramLong, int paramInt)
  {
    if ((paramInt == 2) || (paramInt == 1))
    {
      r(paramLong);
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList, 1, false);
    }
    super.c(paramLong, paramInt);
  }
  
  public void c(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (g()) {}
    AVActivity localAVActivity;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.w(this.jdField_c_of_type_JavaLangString, 1, "refreshUI, uin[" + paramLong + "], refreshType[" + paramInt1 + "], needRefresh[" + paramBoolean + "], originalType[" + paramInt2 + "]");
        }
      } while (paramLong == 0L);
      MultiVideoCtrlLayerUIBase.RefreshUIRunnable localRefreshUIRunnable = new MultiVideoCtrlLayerUIBase.RefreshUIRunnable(this, paramLong, paramInt1, paramBoolean, paramInt2);
      localAVActivity = a();
      localAVActivity.runOnUiThread(localRefreshUIRunnable);
    } while (this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI == null);
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(this.jdField_c_of_type_Long, 0, 0, this.jdField_a_of_type_ComTencentAvVideoController.h());
    localAVActivity.a.b(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.h());
  }
  
  void c(long paramLong, View paramView)
  {
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClick_Mute, micPermission[" + this.jdField_a_of_type_ComTencentAvVideoController.a().o + "], seq[" + paramLong + "]");
    if (a(paramLong, "android.permission.RECORD_AUDIO", paramView))
    {
      q(this.jdField_a_of_type_ComTencentAvVideoController.h());
      s(paramLong);
    }
    super.z(paramLong);
  }
  
  public void c(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {
      e();
    }
  }
  
  public void c(Intent paramIntent)
  {
    boolean bool = false;
    super.c(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "OnNewIntent");
    }
    b(paramIntent);
    if (paramIntent != null)
    {
      bool = paramIntent.getBooleanExtra("needStartTRAE", false);
      K();
    }
    a(paramIntent);
    if (bool) {
      this.jdField_a_of_type_Mtq.c();
    }
    a();
  }
  
  protected abstract boolean c();
  
  public void d()
  {
    super.d();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "OnCreate");
    }
    Object localObject = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "Can not get activity");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_b_of_type_Lfb);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lfp);
    ((BaseActivity)localObject).registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("tencent.video.q2v.GvideoMemInviteUpdate"));
    this.jdField_a_of_type_Msp = msp.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    localObject = a();
    b((Intent)localObject);
    a((Intent)localObject);
    this.jdField_a_of_type_ComTencentAvVideoController.q();
  }
  
  public void d(int paramInt) {}
  
  public void d(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "OnDestroy, seq[" + paramLong + "]");
    }
    this.jdField_a_of_type_ComTencentAvVideoController.r();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_b_of_type_Lfb);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lfp);
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
      ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ShowSharpInfoRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$InviteUserNoticeRunnable);
    if (this.jdField_e_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_f_of_type_JavaLangRunnable);
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_b_of_type_JavaLangRunnable = null;
    this.jdField_c_of_type_JavaLangRunnable = null;
    this.jdField_d_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ShowSharpInfoRunnable = null;
    this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$InviteUserNoticeRunnable = null;
    this.jdField_e_of_type_JavaLangRunnable = null;
    this.jdField_f_of_type_JavaLangRunnable = null;
    E();
    mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1030);
    mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036);
    mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1037);
    mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3013);
    mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1034);
    mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1035);
    this.jdField_a_of_type_Mtc.a(false);
    this.jdField_a_of_type_Mtc.b(false);
    this.jdField_a_of_type_Mtc.c(false);
    this.jdField_a_of_type_Mtc = null;
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI = null;
    this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI = null;
    this.jdField_b_of_type_JavaLangString = null;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    }
    if (this.jdField_a_of_type_Bfly != null)
    {
      this.jdField_a_of_type_Bfly.a(paramLong);
      this.jdField_a_of_type_Bfly = null;
    }
    if (this.jdField_a_of_type_Mhj != null)
    {
      this.jdField_a_of_type_Mhj.b();
      this.jdField_a_of_type_Mhj = null;
    }
    super.d(paramLong);
  }
  
  void d(long paramLong, int paramInt)
  {
    boolean bool = true;
    String str;
    if (paramInt <= 1)
    {
      str = this.jdField_a_of_type_AndroidContentResResources.getString(2131695870);
      bool = false;
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setClickable(bool);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_a_of_type_AndroidWidgetImageView.setClickable(bool);
      if (bool) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      str = String.format(this.jdField_a_of_type_AndroidContentResResources.getString(2131695648), new Object[] { Integer.valueOf(paramInt) });
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  void d(long paramLong, View paramView)
  {
    lga locallga = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClick_CAMERA, sessionInfo[" + locallga + "], mHasLauncnRequestFromCameraButton[" + this.jdField_a_of_type_Boolean + "], seq[" + paramLong + "]");
    if (a(paramLong, "android.permission.CAMERA", paramView))
    {
      if (locallga.j) {
        break label320;
      }
      if (!f()) {
        break label93;
      }
      label93:
      while (a(false)) {
        return;
      }
      mqw.f(true);
      if (bbfj.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) {
        break label351;
      }
      if (VideoController.d(VideoController.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()) <= 0) {
        break label357;
      }
    }
    label277:
    label320:
    label351:
    label357:
    for (int k = 0;; k = 1)
    {
      if (k != 0)
      {
        paramView = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramView == null) {
          break;
        }
        bbdj.a(paramView, 230, this.jdField_a_of_type_AndroidContentResResources.getString(2131695995), this.jdField_a_of_type_AndroidContentResResources.getString(2131695992), 2131695732, 2131695744, new mfo(this, paramLong), new mfp(this)).show();
      }
      for (k = 0;; k = 1)
      {
        if (k != 0)
        {
          if ((locallga.a() != -1) || (bbfj.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()))) {
            break label277;
          }
          q(paramLong);
        }
        for (;;)
        {
          j(paramLong, 2131695649);
          return;
          if (d())
          {
            this.jdField_a_of_type_Boolean = true;
            f(paramLong, 65535);
          }
          else if (QLog.isColorLevel())
          {
            QLog.e(this.jdField_c_of_type_JavaLangString, 2, "PressCameraBtnRunnable-->go on stage fail,can not find the session");
            continue;
            r(paramLong);
            this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Long, locallga.jdField_c_of_type_JavaUtilArrayList, locallga.jdField_d_of_type_JavaUtilArrayList, 1, false);
          }
        }
      }
    }
  }
  
  public void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "addRequestVideoTimeoutRunnable[" + paramString + "]");
    }
    if (this.jdField_b_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 30000L);
      return;
      this.jdField_b_of_type_JavaLangRunnable = new MultiVideoCtrlLayerUIBase.RequestVideoTimeOutRunnable(this);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), String.valueOf(this.jdField_a_of_type_Long), Boolean.valueOf(paramBoolean) });
    if (this.jdField_b_of_type_Boolean) {
      A();
    }
  }
  
  public boolean d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "Go on Stage");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      return this.jdField_a_of_type_ComTencentAvVideoController.k();
    }
    if (QLog.isColorLevel()) {
      QLog.e(this.jdField_c_of_type_JavaLangString, 2, "Go On Stage, VideoController is null");
    }
    return false;
  }
  
  @QQPermissionDenied(2)
  public void deniedForAudioRecord()
  {
    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "showPermissionDialog deniedForAudioRecord(2) 10");
  }
  
  public abstract void e();
  
  void e(long paramLong, int paramInt)
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      if ((QLog.isDevelopLevel()) || (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != paramInt)) {
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "setVisibility_ConnectInfoView_TopCenter, visibility[" + this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() + "->" + paramInt + "], seq[" + paramLong + "]");
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(paramInt);
      CharSequence localCharSequence = this.jdField_c_of_type_AndroidWidgetTextView.getText();
      if (TextUtils.equals(this.jdField_a_of_type_AndroidContentResResources.getString(2131695870), localCharSequence)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(paramInt);
  }
  
  public void e(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "removeRequestVideoTimeoutRunnable[" + paramString + "]");
    }
    if (this.jdField_b_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    long l = AudioHelper.b();
    if (this.jdField_a_of_type_Bfly == null)
    {
      this.jdField_a_of_type_Bfly = new bfly((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), null);
      if (!paramBoolean) {
        break label97;
      }
      if (mre.a("qav_gaudio_muted.mp3")) {
        this.jdField_a_of_type_Bfly.a(l, 2, 0, null, mre.a() + "qav_gaudio_muted.mp3", false, 1, false, true, 0);
      }
    }
    label97:
    while (!mre.a("qav_gaudio_cancel_muted.mp3"))
    {
      return;
      this.jdField_a_of_type_Bfly.a(l);
      break;
    }
    this.jdField_a_of_type_Bfly.a(l, 2, 0, null, mre.a() + "qav_gaudio_cancel_muted.mp3", false, 1, false, true, 0);
  }
  
  public boolean e()
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "startRecvAllVideo");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "startRecvAllVideo --> VideoController is null");
      }
      return false;
    }
    Object localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localObject != null) && ((localObject instanceof AVActivity)))
    {
      localObject = (AVActivity)localObject;
      if (localObject == null) {}
    }
    for (boolean bool1 = ((AVActivity)localObject).isResume();; bool1 = true)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "startRecvAllVideo --> isResume = " + bool1);
      }
      if (!bool1) {
        break;
      }
      int m = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size();
      int k = m;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().j) {
        k = m - 1;
      }
      if (k <= 0)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "startRecvAllVideo --> There is no video need request");
        return false;
      }
      k = lsq.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp());
      if (k == 1)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "startRecvAllVideo --> This version is not supportsharpvideo or opengl.  GlVersion = " + k);
        return false;
      }
      axqy.b(null, "CliOper", "", "", "0X8005617", "0X8005617", 0, 0, "", "", "", "");
      k = this.jdField_a_of_type_ComTencentAvVideoController.g();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "startRecvAllVideo --> Ability = " + k);
      }
      if (k != 4)
      {
        if (this.jdField_e_of_type_Int == 2) {
          axqy.b(null, "CliOper", "", "", "0X8004CF6", "0X8004CF6", 0, 0, "", "", "", "");
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() > 1) {
          mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3007);
        }
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().e.clear();
      k = 0;
      while (k < this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size())
      {
        localObject = (lon)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(k);
        if (((lon)localObject).jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentAvVideoController.a().e.add(localObject);
        }
        k += 1;
      }
      a(false, false, false);
      E();
      mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036);
      mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1037);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().M == 3) {}
      for (bool1 = bool2;; bool1 = false) {
        return this.jdField_a_of_type_ComTencentAvVideoController.a(bool1);
      }
    }
  }
  
  boolean f()
  {
    if ((!llw.f()) || (lsq.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) == 1))
    {
      DoubleVideoCtrlUI.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      return false;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.b() >= jdField_b_of_type_Int)
    {
      mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1031);
      return false;
    }
    return true;
  }
  
  public void g(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onLayoutModeChange --> ScreenType = " + paramInt + " , hasSetBigVideoView = " + this.jdField_a_of_type_ComTencentAvVideoController.a().t());
    }
    Iterator localIterator;
    lon locallon;
    if (paramInt == 3)
    {
      if (4 == this.jdField_a_of_type_ComTencentAvVideoController.g())
      {
        localIterator = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          locallon = (lon)localIterator.next();
          if (!locallon.jdField_a_of_type_Boolean) {
            locallon.jdField_c_of_type_Boolean = true;
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() > 0) {
        ((lon)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_Boolean = true;
      }
    }
    for (;;)
    {
      e();
      return;
      if (paramInt == 4)
      {
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().t()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() > 0))
        {
          ((lon)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_c_of_type_JavaLangString, 2, "MultiVideoCtrlLayerUIBase onLayoutModeChange --> displayList  not has big one");
          }
        }
        if (4 == this.jdField_a_of_type_ComTencentAvVideoController.g())
        {
          localIterator = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext())
          {
            locallon = (lon)localIterator.next();
            if (!locallon.jdField_a_of_type_Boolean) {
              locallon.jdField_c_of_type_Boolean = true;
            }
          }
        }
        else if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() > 0)
        {
          ((lon)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_Boolean = true;
        }
      }
    }
  }
  
  @QQPermissionGrant(2)
  public void grantForAudioRecord()
  {
    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "showPermissionDialog grantForAudioRecord(2) 09");
  }
  
  void h(int paramInt)
  {
    if ((paramInt == 6) || (paramInt == 8) || (paramInt == 74)) {}
    do
    {
      do
      {
        return;
      } while (lsq.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) != 1);
      mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1012, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131720788));
      axqy.b(null, "CliOper", "", "", "0X8004E94", "0X8004E94", 0, 0, "", "", "", "");
      axqy.b(null, "CliOper", "", "", "0X8005618", "0X8005618", 0, 0, "", "", "", "");
    } while (!QLog.isColorLevel());
    QLog.e(this.jdField_c_of_type_JavaLangString, 2, "startRecvAllVideo-->GLVersion not support");
  }
  
  public void i(long paramLong) {}
  
  public void j(long paramLong) {}
  
  public void l(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "OnPause, seq[" + paramLong + "]");
    }
    super.l(paramLong);
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "OnPause Error : VideoController is null");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().am = true;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c("MultiVideoCtrlLayerUIBase");
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      if (((!lze.f()) || ((!bbfj.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().ao))) && (this.jdField_a_of_type_ComTencentAvVideoController.a().j)) {
        r(paramLong);
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().a() != -1) {
        this.jdField_a_of_type_ComTencentAvVideoController.f();
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_c_of_type_Long, true, true);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable);
  }
  
  void n(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean))
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.h()) {
        super.k(2131372216);
      }
      this.jdField_a_of_type_ComTencentAvVideoController.p();
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int != 9) {
        break label92;
      }
      e(paramLong, true);
      g(paramLong, 2131695870);
    }
    for (;;)
    {
      x(paramLong);
      this.jdField_a_of_type_Mtc.c(true);
      this.jdField_a_of_type_Mtc.b(true);
      return;
      label92:
      e(paramLong, false);
      d(paramLong, null);
    }
  }
  
  public void o()
  {
    super.o();
  }
  
  void o(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "sendVideoMsgBroadcast--> discussionId = " + paramLong);
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      Intent localIntent = new Intent();
      if (localIntent != null)
      {
        localIntent.setAction("tencent.video.v2q.AddVideoMsg");
        localIntent.putExtra("uinType", this.jdField_d_of_type_Int);
        localIntent.putExtra("msgType", 13);
        localIntent.putExtra("isVideoMsg", false);
        localIntent.putExtra("friendUin", Long.toString(paramLong));
        localIntent.putExtra("senderUin", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
        localIntent.putExtra("isSender", true);
        localIntent.putExtra("isRead", true);
        localIntent.putExtra("MultiAVType", this.jdField_a_of_type_ComTencentAvVideoController.a().C);
        localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName());
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
      }
    }
  }
  
  protected abstract void p();
  
  public void p(long paramLong)
  {
    if (g()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372216, true);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131372216, true);
      if (!this.jdField_a_of_type_ComTencentAvVideoController.h()) {
        break label96;
      }
      k(2131372216);
    }
    for (;;)
    {
      x();
      long l = this.jdField_b_of_type_Long;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_d_of_type_Int, String.valueOf(l));
      f(paramLong, 65535);
      x(paramLong);
      return;
      label96:
      l(2131372216);
    }
  }
  
  void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "resumeVideo");
    }
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new MultiVideoCtrlLayerUIBase.AutoCheckRunnable(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void q(long paramLong)
  {
    Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    String str = this.jdField_c_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("goOnStageWithoutWiFiCheck, mContext[");
    if (localContext != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w(str, 1, bool + "], seq[" + paramLong + "]");
      if (localContext != null) {
        break;
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().r()) {}
    for (int k = 2131696007;; k = 2131696008)
    {
      bbdj.a(localContext, 230, null, this.jdField_a_of_type_AndroidContentResResources.getString(k), 2131695732, 2131695744, new mfs(this, paramLong), new mft(this)).show();
      return;
    }
  }
  
  void r()
  {
    long l2 = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "initViewList, seq[" + l2 + "]");
    }
    if ((this.jdField_c_of_type_Int == 0) || (this.jdField_c_of_type_Int == 1)) {}
    for (long l1 = this.jdField_a_of_type_Long;; l1 = this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(l1, this.jdField_e_of_type_Int, false);
      this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setOnItemClickListener(this.jdField_a_of_type_Mru);
      b(l2, "initViewList");
      return;
    }
  }
  
  public void r(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "goOffStage, seq[" + paramLong + "]");
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_b_of_type_Mcf == null) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "goOffStage --> Error");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.v();
    this.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, "goOffStage", false, false);
    this.jdField_b_of_type_Mcf.update(null, new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
    b(2131372517, 8);
    AVActivity localAVActivity = a();
    if (localAVActivity != null) {
      localAVActivity.a(false);
    }
    a("goOffStage", paramLong);
  }
  
  void s()
  {
    long l = AudioHelper.b();
    boolean bool;
    if (QLog.isColorLevel())
    {
      String str = this.jdField_c_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("startOrResumeRemoteOrLocalVideo, seq[").append(l).append("], mVideoController[");
      if (this.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        bool = true;
        QLog.w(str, 1, bool + "]");
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
        break label88;
      }
    }
    label88:
    do
    {
      return;
      bool = false;
      break;
      if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean) {
        break label116;
      }
    } while (!QLog.isColorLevel());
    QLog.e(this.jdField_c_of_type_JavaLangString, 2, "startOrResumeRemoteOrLocalVideo, Not in MultiVideoRoom");
    return;
    label116:
    int m = this.jdField_a_of_type_ComTencentAvVideoController.b();
    int n = this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_c_of_type_Long, 1);
    int k;
    if (n != -1)
    {
      k = 1;
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "startOrResumeRemoteOrLocalVideo, onStageNum[" + m + "], index[" + n + "]");
      }
      if ((!bbfj.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().ao)) {
        break label387;
      }
      if (k != 0)
      {
        if (m >= jdField_b_of_type_Int) {
          break label339;
        }
        if (!d()) {
          break label279;
        }
        f(l, 65535);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() <= 0) {
        break label382;
      }
      e();
      return;
      k = 0;
      break;
      label279:
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "startOrResumeRemoteOrLocalVideo, Go on Stage Failed");
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList, 1, false);
      this.jdField_a_of_type_ComTencentAvVideoController.u();
      continue;
      label339:
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList, 1, false);
      this.jdField_a_of_type_ComTencentAvVideoController.u();
    }
    label382:
    K();
    return;
    label387:
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "startOrResumeRemoteOrLocalVideo --> is not connect wifi");
    }
    if (k != 0)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList, 1, false);
      this.jdField_a_of_type_ComTencentAvVideoController.u();
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() > 0)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(l, "startOrResumeRemoteOrLocalVideo", true, true);
      a("startOrResumeRemoteOrLocalVideo", l);
      if (!bbfj.g((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()))
      {
        DoubleVideoCtrlUI.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0);
        return;
      }
      a(true, true, true);
      return;
    }
    K();
  }
  
  void s(long paramLong)
  {
    boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.h();
    if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean) {}
    for (long l = this.jdField_b_of_type_Long;; l = this.jdField_a_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "doMute, relationId[" + l + "], mute[" + bool + "], seq[" + paramLong + "]");
      }
      if (!bool) {
        break label175;
      }
      if (!a(true)) {
        break;
      }
      return;
    }
    if (this.jdField_e_of_type_Int == 2) {
      mqw.a(true, 1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a("MultiVideoCtrlLayerUIBase.doMute.1", l, true, true);
      super.l(2131372216);
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
      return;
      mqw.a(true, 10);
    }
    label175:
    if (this.jdField_e_of_type_Int == 2) {
      mqw.a(false, 1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a("MultiVideoCtrlLayerUIBase.doMute.2", l, false, true);
      super.k(2131372216);
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
      return;
      mqw.a(false, 10);
    }
  }
  
  public void t(long paramLong)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "go on stage failed, info[" + paramLong + "]");
    }
    b(2131372517, 8);
    AVActivity localAVActivity = a();
    if (localAVActivity != null) {
      localAVActivity.a(false);
    }
    f(l, 65535);
    if (paramLong == 7L) {
      mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1029);
    }
    for (;;)
    {
      if (this.jdField_e_of_type_Int == 2) {
        axqy.b(null, "CliOper", "", "", "0X800441E", "0X800441E", 0, 0, "", "", "", "");
      }
      return;
      if (paramLong == 8L) {
        mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1033, this.jdField_a_of_type_AndroidContentResResources.getString(2131696017));
      } else {
        mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1028);
      }
    }
  }
  
  void u(long paramLong)
  {
    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "avideo onClick QavPanel.ViewID.SWITCH_DISPLAY_MODE");
    int m;
    int k;
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() > 0))
    {
      AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      m = localAVActivity.c();
      if (3 != m) {
        break label146;
      }
      k = 1;
      if (4 != m) {
        break label151;
      }
      m = 1;
      label77:
      if (m == 0) {
        break label157;
      }
      axqy.b(null, "CliOper", "", "", "0X8009F5E", "0X8009F5E", 0, 0, "", "", "", "");
      label115:
      if ((m == 0) && (k == 0)) {
        break label198;
      }
      if (k == 0) {
        break label193;
      }
      k = 4;
      label130:
      localAVActivity.a(k, false);
    }
    for (;;)
    {
      j(paramLong, 2131695658);
      return;
      label146:
      k = 0;
      break;
      label151:
      m = 0;
      break label77;
      label157:
      axqy.b(null, "CliOper", "", "", "0X8009F5F", "0X8009F5F", 0, 0, "", "", "", "");
      break label115;
      label193:
      k = 3;
      break label130;
      label198:
      QLog.d(this.jdField_c_of_type_JavaLangString, 1, "avideo onClick QavPanel.ViewID.SWITCH_DISPLAY_MODE error happen");
    }
  }
  
  void v()
  {
    E();
    mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036);
    mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1037);
    mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1030);
    this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_c_of_type_Long, true, true);
    a(true, false, true);
  }
  
  void v(long paramLong)
  {
    w(paramLong);
    j(paramLong, 2131695651);
  }
  
  public void w()
  {
    int k;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().M == 1)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.g() != 4) {
        break label131;
      }
      k = 3;
      if ((k != 3) || (msn.c())) {
        break label136;
      }
      k = 4;
    }
    label131:
    label136:
    for (;;)
    {
      AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localAVActivity != null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d(this.jdField_c_of_type_JavaLangString, 4, "initScreenLayout Style=" + k + "|" + this.jdField_a_of_type_ComTencentAvVideoController.a().M + "|" + this.jdField_a_of_type_ComTencentAvVideoController.g());
        }
        localAVActivity.a(k, false);
      }
      return;
      k = 4;
      break;
    }
  }
  
  void w(long paramLong)
  {
    boolean bool = false;
    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "OnClick_MemberInfo");
    axqy.b(null, "CliOper", "", "", "0X8009F64", "0X8009F64", 0, 0, "", "", "", "");
    AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().aa) || (this.jdField_a_of_type_ComTencentAvVideoController.a().ab)) {
      bool = true;
    }
    VideoMsgTools.a(localAVActivity, String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Long), bool, true);
  }
  
  void x()
  {
    long l = AudioHelper.b();
    lga locallga = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "refreshMemberCtrlButton, SessionType[" + locallga.jdField_d_of_type_Int + "], multiAVType[" + locallga.C + "], mUinType[" + this.jdField_d_of_type_Int + "], isManager[" + locallga.aa + "], isRoomCreator[" + locallga.ab + "], mGAudioInRoom[" + this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean + "]");
    f(l, 65535);
  }
  
  public void y()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0);
    int k = localSharedPreferences.getInt("group_video_push_cfg_txt." + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin() + ".level", 1);
    int m = localSharedPreferences.getInt("group_video_push_cfg_txt." + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin() + ".sendDura", 5000);
    int n = localSharedPreferences.getInt("group_video_push_cfg_txt." + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin() + ".validDura", 6000);
    this.jdField_a_of_type_ComTencentAvVideoController.a(k, m, n);
  }
  
  protected void z()
  {
    this.jdField_a_of_type_Mtq.c();
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().a())
    {
      long l = AudioHelper.b();
      String str = this.jdField_a_of_type_ComTencentAvVideoController.a().q;
      this.jdField_a_of_type_Mtq.a(l, this.jdField_d_of_type_JavaLangString, str);
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onCreate, switchToGaudio, mAudioSesstionType[" + this.jdField_d_of_type_JavaLangString + "], deviceName[" + str + "], seq[" + l + "]");
      }
      this.jdField_a_of_type_Mtq.a(l, str);
      return;
    }
    this.jdField_a_of_type_Mtq.a(this.jdField_d_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase
 * JD-Core Version:    0.7.0.1
 */