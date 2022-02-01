package com.tencent.av.ui;

import afur;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bcst;
import bglp;
import bgnt;
import bgpa;
import bkej;
import com.tencent.av.VideoConstants;
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
import java.util.ArrayList<Lmfu;>;
import java.util.Iterator;
import lco;
import ldy;
import lem;
import ley;
import lkw;
import lnn;
import lrz;
import lyu;
import lzx;
import maf;
import mbx;
import mfh;
import mfi;
import mfm;
import mfn;
import mfo;
import mfp;
import mfq;
import mfr;
import mfs;
import mft;
import mfu;
import mhe;
import mmj;
import mqo;
import mqq.app.BaseActivity;
import mqq.app.MobileQQ;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mqq.os.MqqHandler;
import mqu;
import mqw;
import mre;
import mru;
import msn;
import msp;
import mte;
import mts;
import mue;

public abstract class MultiVideoCtrlLayerUIBase
  extends VideoControlUI
{
  private static boolean jdField_a_of_type_Boolean;
  static int jdField_b_of_type_Int;
  public long a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new mfo(this);
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  bkej jdField_a_of_type_Bkej = null;
  public MultiMembersAudioUI a;
  MultiMembersVideoUI jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI = null;
  public MultiVideoCtrlLayerUIBase.InviteUserNoticeRunnable a;
  MultiVideoCtrlLayerUIBase.StartRecvVideoRunnable jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable = new MultiVideoCtrlLayerUIBase.StartRecvVideoRunnable(this);
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  String jdField_a_of_type_JavaLangString = null;
  ArrayList<mfu> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private lem jdField_a_of_type_Lem = new mfh(this);
  mhe jdField_a_of_type_Mhe = null;
  mru jdField_a_of_type_Mru = new mfq(this);
  msp jdField_a_of_type_Msp = null;
  public long b;
  TextView jdField_b_of_type_AndroidWidgetTextView = null;
  Runnable jdField_b_of_type_JavaLangRunnable = null;
  String jdField_b_of_type_JavaLangString;
  ArrayList<mfu> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  ldy jdField_b_of_type_Ldy = new mfi(this);
  public boolean b;
  public int c;
  public long c;
  TextView jdField_c_of_type_AndroidWidgetTextView = null;
  Runnable jdField_c_of_type_JavaLangRunnable = null;
  String jdField_c_of_type_JavaLangString = "";
  boolean jdField_c_of_type_Boolean = false;
  public int d;
  Runnable d;
  public boolean d;
  public int e;
  public Runnable e;
  public boolean e;
  public int f;
  public Runnable f;
  public boolean f;
  public int g;
  Runnable g;
  int h;
  int i = 0;
  int j;
  private boolean q;
  private boolean r;
  
  static
  {
    int k = 16;
    jdField_b_of_type_Int = 16;
    if (Build.VERSION.SDK_INT >= 21)
    {
      jdField_b_of_type_Int = k;
      if ((!Build.MODEL.equalsIgnoreCase("SM-G7106")) && (!Build.MODEL.equalsIgnoreCase("MI 2")) && (!Build.MODEL.equalsIgnoreCase("GT-B9388")) && (!Build.MODEL.equalsIgnoreCase("L39u")) && (!Build.MODEL.equalsIgnoreCase("R7007")) && (!Build.MODEL.equalsIgnoreCase("VIVO X5S L"))) {
        break label99;
      }
    }
    label99:
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
      k = 9;
      break;
    }
  }
  
  public MultiVideoCtrlLayerUIBase(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, mbx parammbx)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, parammbx);
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
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_JavaLangRunnable = new MultiVideoCtrlLayerUIBase.3(this);
    this.jdField_j_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$InviteUserNoticeRunnable = new MultiVideoCtrlLayerUIBase.InviteUserNoticeRunnable(this);
  }
  
  private String a(ArrayList<mfu> paramArrayList)
  {
    ley localley = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i2 = mqo.b(localley.jdField_j_of_type_Int);
    Object localObject1;
    Object localObject2;
    int k;
    int m;
    int n;
    if (paramArrayList.size() > 0)
    {
      localObject1 = ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131695232);
      localObject2 = new int[3];
      Object tmp50_48 = localObject2;
      tmp50_48[0] = -1;
      Object tmp54_50 = tmp50_48;
      tmp54_50[1] = -1;
      Object tmp58_54 = tmp54_50;
      tmp58_54[2] = -1;
      tmp58_54;
      k = 0;
      if (k < paramArrayList.size())
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_d_of_type_JavaLangString, 2, "speakingInfoList. idx = " + k + ", uin = " + ((mfu)paramArrayList.get(k)).jdField_a_of_type_JavaLangString + ", audioEnergy = " + ((mfu)paramArrayList.get(k)).jdField_a_of_type_Int);
        }
        if ((localObject2[0] == -1) || (((mfu)paramArrayList.get(localObject2[0])).jdField_a_of_type_Int < ((mfu)paramArrayList.get(k)).jdField_a_of_type_Int))
        {
          localObject2[2] = localObject2[1];
          localObject2[1] = localObject2[0];
          localObject2[0] = k;
        }
        for (;;)
        {
          k += 1;
          break;
          if ((localObject2[1] == -1) || (((mfu)paramArrayList.get(localObject2[1])).jdField_a_of_type_Int < ((mfu)paramArrayList.get(k)).jdField_a_of_type_Int))
          {
            localObject2[2] = localObject2[1];
            localObject2[1] = k;
          }
          else if ((localObject2[2] == -1) || (((mfu)paramArrayList.get(localObject2[2])).jdField_a_of_type_Int < ((mfu)paramArrayList.get(k)).jdField_a_of_type_Int))
          {
            localObject2[2] = k;
          }
        }
      }
      m = 0;
      if (m < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        n = 0;
        label320:
        if (n >= localObject2.length) {
          break label1168;
        }
        if (localObject2[n] < 0) {
          k = 0;
        }
      }
    }
    for (;;)
    {
      label338:
      if (k != 0)
      {
        ((mfu)paramArrayList.get(localObject2[n])).jdField_a_of_type_JavaLangString = "";
        ((mfu)this.jdField_b_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_Int = ((mfu)paramArrayList.get(localObject2[n])).jdField_a_of_type_Int;
      }
      for (;;)
      {
        m += 1;
        break;
        if (((mfu)this.jdField_b_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_JavaLangString.equalsIgnoreCase(((mfu)paramArrayList.get(localObject2[n])).jdField_a_of_type_JavaLangString))
        {
          k = 1;
          break label338;
        }
        n += 1;
        break label320;
        ((mfu)this.jdField_b_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_JavaLangString = "";
      }
      m = 0;
      k = 0;
      int i1;
      if (m < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        n = k;
        i1 = m;
        if (((mfu)this.jdField_b_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_JavaLangString.equalsIgnoreCase(""))
        {
          n = k;
          label509:
          k = n;
          if (n < localObject2.length)
          {
            if (localObject2[n] >= 0) {
              break label573;
            }
            k = n;
          }
          label531:
          if ((k >= localObject2.length) || (localObject2[k] >= 0)) {
            break label1159;
          }
          this.jdField_b_of_type_JavaUtilArrayList.remove(m);
          i1 = m - 1;
          n = k;
        }
      }
      for (;;)
      {
        m = i1 + 1;
        k = n;
        break;
        label573:
        if (!((mfu)paramArrayList.get(localObject2[n])).jdField_a_of_type_JavaLangString.equalsIgnoreCase(""))
        {
          ((mfu)this.jdField_b_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_JavaLangString = ((mfu)paramArrayList.get(localObject2[n])).jdField_a_of_type_JavaLangString;
          ((mfu)this.jdField_b_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_Int = ((mfu)paramArrayList.get(localObject2[n])).jdField_a_of_type_Int;
          ((mfu)paramArrayList.get(localObject2[n])).jdField_a_of_type_JavaLangString = "";
          k = n + 1;
          break label531;
        }
        n += 1;
        break label509;
        n = this.jdField_b_of_type_JavaUtilArrayList.size();
        if (n < 3)
        {
          m = k;
          for (;;)
          {
            k = m;
            if (m < localObject2.length) {
              if (localObject2[m] >= 0) {
                break label732;
              }
            }
            for (k = m;; k = m + 1)
            {
              n += 1;
              break;
              label732:
              if (((mfu)paramArrayList.get(localObject2[m])).jdField_a_of_type_JavaLangString.equalsIgnoreCase("")) {
                break label820;
              }
              this.jdField_b_of_type_JavaUtilArrayList.add(new mfu(((mfu)paramArrayList.get(localObject2[m])).jdField_a_of_type_JavaLangString, ((mfu)paramArrayList.get(localObject2[m])).jdField_a_of_type_Int));
              ((mfu)paramArrayList.get(localObject2[m])).jdField_a_of_type_JavaLangString = "";
            }
            label820:
            m += 1;
          }
        }
        k = 0;
        paramArrayList = (ArrayList<mfu>)localObject1;
        localObject1 = paramArrayList;
        if (k < this.jdField_b_of_type_JavaUtilArrayList.size())
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_d_of_type_JavaLangString, 2, "speakingInfoList. uin = " + ((mfu)this.jdField_b_of_type_JavaUtilArrayList.get(k)).jdField_a_of_type_JavaLangString + ", audioEnergy = " + ((mfu)this.jdField_b_of_type_JavaUtilArrayList.get(k)).jdField_a_of_type_Int);
          }
          localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i2, ((mfu)this.jdField_b_of_type_JavaUtilArrayList.get(k)).jdField_a_of_type_JavaLangString, String.valueOf(localley.jdField_g_of_type_Long));
          localObject1 = localObject2;
          if (mqu.a((String)localObject2) > 9) {
            localObject1 = mqu.a((String)localObject2, 0, 9) + "...";
          }
          if (k < this.jdField_b_of_type_JavaUtilArrayList.size() - 1) {}
          for (paramArrayList = paramArrayList + (String)localObject1 + ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131695231);; paramArrayList = paramArrayList + (String)localObject1)
          {
            k += 1;
            break;
          }
          localObject1 = ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131695232);
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.c().size() != 0)
        {
          paramArrayList = (ArrayList<mfu>)localObject1;
          if (this.jdField_a_of_type_ComTencentAvVideoController.c().size() == 1)
          {
            paramArrayList = (ArrayList<mfu>)localObject1;
            if (((lco)this.jdField_a_of_type_ComTencentAvVideoController.c().get(0)).jdField_a_of_type_Long != Long.parseLong(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) {}
          }
        }
        else
        {
          paramArrayList = "";
        }
        return paramArrayList;
        label1159:
        n = k;
        i1 = m;
      }
      label1168:
      k = 0;
    }
  }
  
  private void b(long paramLong, boolean paramBoolean, int paramInt)
  {
    int m = 0;
    if (((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_a_of_type_ComTencentAvVideoController == null)) {
      return;
    }
    boolean bool;
    label66:
    TextView localTextView;
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() > 0))
    {
      bool = true;
      if (!bool) {
        break label341;
      }
      k = 2131373531;
      localTextView = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(k);
      localObject = Long.toString(paramLong);
      k = 0;
      label89:
      if (k >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label461;
      }
      if (!((mfu)this.jdField_a_of_type_JavaUtilArrayList.get(k)).jdField_a_of_type_JavaLangString.equalsIgnoreCase((String)localObject)) {
        break label362;
      }
      if (!paramBoolean) {
        break label349;
      }
      ((mfu)this.jdField_a_of_type_JavaUtilArrayList.get(k)).jdField_a_of_type_Int = paramInt;
      if (paramInt < 10) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(k);
      }
    }
    label162:
    label461:
    for (int k = 1;; k = 0)
    {
      if ((paramBoolean) && (k == 0) && (paramInt > 10)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(new mfu((String)localObject, paramInt));
      }
      ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, paramBoolean);
      if ((!bool) && (this.jdField_a_of_type_ComTencentAvVideoController.c().size() <= 8)) {}
      for (this.jdField_c_of_type_JavaLangString = "";; this.jdField_c_of_type_JavaLangString = a((ArrayList)localObject))
      {
        localTextView.setText(this.jdField_c_of_type_JavaLangString);
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "refreshSpokesmanInfoContent. uin = " + paramLong + ", isSpeaking = " + paramBoolean + ", hasVideo = " + bool + ", member cnt = " + this.jdField_a_of_type_ComTencentAvVideoController.c().size() + ", mSpokesmanNicknameListStr = " + this.jdField_c_of_type_JavaLangString);
        return;
        bool = false;
        break;
        label341:
        k = 2131373180;
        break label66;
        label349:
        this.jdField_a_of_type_JavaUtilArrayList.remove(k);
        break label162;
        label362:
        k += 1;
        break label89;
        localObject = new ArrayList();
        paramInt = m;
        while (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          ((ArrayList)localObject).add(new mfu(((mfu)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString, ((mfu)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int));
          paramInt += 1;
        }
      }
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.h();
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a("doRefreshGaudioMuteUIStatus", paramInt1, paramInt2, false);
    }
    if (bool)
    {
      super.l(2131373207);
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
      }
    }
    do
    {
      return;
      super.k(2131373207);
    } while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
  }
  
  public void A()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_d_of_type_JavaLangString, 2, "cancelNotification");
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
        QLog.i(this.jdField_d_of_type_JavaLangString, 2, "showNotification quit[" + this.jdField_b_of_type_Boolean + "], inRoom[" + this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean + "]");
      }
    } while ((this.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean));
    String str1;
    String str2;
    Bitmap localBitmap;
    if (this.jdField_a_of_type_Msp != null)
    {
      ley localley = this.jdField_a_of_type_ComTencentAvVideoController.a();
      str1 = String.valueOf(localley.jdField_g_of_type_Long);
      str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(this.jdField_d_of_type_Int, str1, null);
      localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_d_of_type_Int, str1, null, true, true);
      k = 44;
      if (localley.m()) {
        if (localley.jdField_d_of_type_Int != 3) {
          break label205;
        }
      }
    }
    label205:
    for (int k = 62;; k = 63)
    {
      this.jdField_a_of_type_Msp.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, str2, localBitmap, str1, k, this.jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
      this.jdField_a_of_type_ComTencentAvVideoController.s();
      return;
    }
  }
  
  protected int a()
  {
    return 2131559698;
  }
  
  public int a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "onApnChanged --> NetType = " + paramInt);
    }
    DoubleVideoCtrlUI.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt);
    if ((bgnt.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean) && (this.jdField_r_of_type_Boolean)) {
      e();
    }
    return 0;
  }
  
  protected long a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean) {
      return this.jdField_b_of_type_Long;
    }
    return this.jdField_a_of_type_Long;
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
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "genDiscussTitle, name == null");
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
        int k = afur.a(160.0F, this.jdField_a_of_type_AndroidContentResResources);
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
          QLog.d(this.jdField_d_of_type_JavaLangString, 2, "genDiscussTitle, name widht[" + f1 + "]");
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
  
  ArrayList<lco> a()
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
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "onVideoViewModeChange --> lastMode = " + paramInt1 + " , currentMode = " + paramInt2 + ",bigUin=" + paramString);
    }
    if ((paramInt1 == paramInt2) || (this.jdField_r_of_type_Boolean)) {}
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
        if (4 == this.jdField_a_of_type_ComTencentAvVideoController.h()) {
          break label225;
        }
        paramInt1 = 1;
        k = 1;
        if (k >= this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size()) {
          continue;
        }
        paramString = (lnn)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(k);
        paramString.jdField_a_of_type_Boolean = bool;
        if ((paramInt1 != 0) && (!paramString.jdField_c_of_type_Boolean))
        {
          int m = this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_c_of_type_Long);
          if (m != -1) {
            ((lnn)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(m)).jdField_c_of_type_Boolean = false;
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
    this.jdField_a_of_type_ComTencentAvVideoController.a().ae = true;
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onStart, seq[" + paramLong + "]");
    }
    super.a(paramLong);
    if (this.jdField_c_of_type_Boolean)
    {
      p(this.jdField_b_of_type_Long);
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    c(paramInt1, paramInt2);
  }
  
  abstract void a(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2);
  
  public void a(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    if (h()) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "refreshUI, uin[" + paramLong + "], refreshType[" + paramInt1 + "], needRefresh[" + paramBoolean + "], originalType[" + paramInt2 + "], audioEnergy[" + paramInt3 + "]");
      }
    } while (paramLong == 0L);
    MultiVideoCtrlLayerUIBase.RefreshUIRunnable localRefreshUIRunnable = new MultiVideoCtrlLayerUIBase.RefreshUIRunnable(this, paramLong, paramInt1, paramBoolean, paramInt2);
    AVActivity localAVActivity = a();
    localAVActivity.runOnUiThread(localRefreshUIRunnable);
    if (this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI != null)
    {
      this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(this.jdField_c_of_type_Long, 0, 0, this.jdField_a_of_type_ComTencentAvVideoController.h());
      localAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.h());
    }
    if (paramInt2 == 42) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      b(paramLong, paramBoolean, paramInt3);
      s();
      return;
    }
  }
  
  void a(long paramLong, String paramString)
  {
    String str;
    if (QLog.isColorLevel())
    {
      str = this.jdField_d_of_type_JavaLangString;
      paramString = new StringBuilder().append("closeRemoteVideo[").append(paramString).append("], seq[").append(paramLong).append("], mVideoController[");
      if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
        break label85;
      }
    }
    label85:
    for (boolean bool = true;; bool = false)
    {
      QLog.d(str, 2, bool + "]");
      if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
        break;
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a("Multi_closeRemoteVideo");
    this.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, "closeRemoteVideo", false, true);
    a("closeRemoteVideo", paramLong);
    e("closeRemoteVideo");
    this.jdField_b_of_type_Mbx.update(null, new Object[] { Integer.valueOf(104), this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList });
  }
  
  void a(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "notifyDataChangeByQuitUin, from[" + paramString + "], seq[" + paramLong1 + "]");
    }
    Object localObject;
    if ((paramInt == 1) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      localObject = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      localObject = this.jdField_a_of_type_ComTencentAvVideoController;
      if (this.k == 3) {
        break label111;
      }
    }
    label111:
    for (boolean bool = true;; bool = false)
    {
      ((VideoController)localObject).a(paramLong2, bool);
      b(paramLong1, paramString);
      return;
    }
  }
  
  void a(long paramLong, ArrayList<lco> paramArrayList)
  {
    if (h()) {}
    int k;
    do
    {
      return;
      if (paramArrayList != null) {
        break;
      }
      k = 0;
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "doInternalUIFreash, gaFList[" + k + "], seq[" + paramLong + "]");
      }
    } while (this.jdField_a_of_type_AndroidContentResResources == null);
    if (k <= 1) {
      g(paramLong, 2131694913);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI != null)
      {
        this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(paramArrayList);
        s();
      }
      ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramArrayList);
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
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e(this.jdField_d_of_type_JavaLangString, 2, "notifyMemberSpeak, MemberUI is null --> Uin = " + paramLong + " , Speak = " + paramBoolean);
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    s();
  }
  
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
    //   6: invokespecial 664	com/tencent/av/ui/VideoControlUI:a	(Ljava/lang/String;ILjava/lang/String;I)V
    //   9: invokestatic 230	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +62 -> 74
    //   15: aload_0
    //   16: getfield 232	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   19: iconst_2
    //   20: new 234	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 235	java/lang/StringBuilder:<init>	()V
    //   27: ldc_w 666
    //   30: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_1
    //   34: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc_w 668
    //   40: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_2
    //   44: invokevirtual 244	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: ldc_w 670
    //   50: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload_3
    //   54: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc_w 672
    //   60: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: iload 4
    //   65: invokevirtual 244	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   68: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: aload_1
    //   75: ifnull +7 -> 82
    //   78: aload_3
    //   79: ifnonnull +4 -> 83
    //   82: return
    //   83: aload_0
    //   84: getfield 459	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_r_of_type_Boolean	Z
    //   87: ifne -5 -> 82
    //   90: aload_3
    //   91: invokestatic 675	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   94: invokevirtual 678	java/lang/Long:longValue	()J
    //   97: lstore 6
    //   99: iload_2
    //   100: iconst_2
    //   101: if_icmpne +20 -> 121
    //   104: aload_0
    //   105: sipush 1036
    //   108: invokevirtual 680	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:i	(I)V
    //   111: aload_0
    //   112: getfield 278	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   115: sipush 1036
    //   118: invokestatic 683	maf:a	(Lcom/tencent/av/app/VideoAppInterface;I)V
    //   121: aload_0
    //   122: getfield 191	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   125: invokevirtual 196	com/tencent/av/VideoController:a	()Lley;
    //   128: aload_1
    //   129: invokestatic 675	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   132: invokevirtual 678	java/lang/Long:longValue	()J
    //   135: iload_2
    //   136: invokevirtual 686	ley:a	(JI)I
    //   139: istore 5
    //   141: iload 5
    //   143: iconst_m1
    //   144: if_icmpeq -62 -> 82
    //   147: aload_0
    //   148: getfield 191	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   151: invokevirtual 196	com/tencent/av/VideoController:a	()Lley;
    //   154: getfield 329	ley:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   157: iload 5
    //   159: invokevirtual 249	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   162: checkcast 540	lnn
    //   165: astore_3
    //   166: iconst_0
    //   167: istore_2
    //   168: iload_2
    //   169: aload_0
    //   170: getfield 191	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   173: invokevirtual 196	com/tencent/av/VideoController:a	()Lley;
    //   176: getfield 329	ley:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   179: invokevirtual 208	java/util/ArrayList:size	()I
    //   182: if_icmpge +371 -> 553
    //   185: aload_0
    //   186: getfield 191	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   189: invokevirtual 196	com/tencent/av/VideoController:a	()Lley;
    //   192: getfield 329	ley:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   195: iload_2
    //   196: invokevirtual 249	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   199: checkcast 540	lnn
    //   202: astore 8
    //   204: lload 6
    //   206: aload 8
    //   208: getfield 687	lnn:jdField_a_of_type_Long	J
    //   211: lcmp
    //   212: ifne +365 -> 577
    //   215: iload 4
    //   217: aload 8
    //   219: getfield 688	lnn:jdField_a_of_type_Int	I
    //   222: if_icmpne +355 -> 577
    //   225: aload_3
    //   226: iconst_0
    //   227: putfield 541	lnn:jdField_a_of_type_Boolean	Z
    //   230: aload_3
    //   231: getfield 687	lnn:jdField_a_of_type_Long	J
    //   234: aload_0
    //   235: getfield 86	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_c_of_type_Long	J
    //   238: lcmp
    //   239: ifeq +32 -> 271
    //   242: aload 8
    //   244: getfield 687	lnn:jdField_a_of_type_Long	J
    //   247: aload_0
    //   248: getfield 86	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_c_of_type_Long	J
    //   251: lcmp
    //   252: ifeq +19 -> 271
    //   255: iconst_4
    //   256: aload_0
    //   257: getfield 191	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   260: invokevirtual 538	com/tencent/av/VideoController:h	()I
    //   263: if_icmpeq +8 -> 271
    //   266: aload_3
    //   267: iconst_0
    //   268: putfield 542	lnn:jdField_c_of_type_Boolean	Z
    //   271: aload 8
    //   273: iconst_1
    //   274: putfield 541	lnn:jdField_a_of_type_Boolean	Z
    //   277: iconst_4
    //   278: aload_0
    //   279: getfield 191	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   282: invokevirtual 538	com/tencent/av/VideoController:h	()I
    //   285: if_icmpeq +55 -> 340
    //   288: aload 8
    //   290: getfield 542	lnn:jdField_c_of_type_Boolean	Z
    //   293: ifne +47 -> 340
    //   296: aload_0
    //   297: getfield 191	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   300: invokevirtual 196	com/tencent/av/VideoController:a	()Lley;
    //   303: aload_0
    //   304: getfield 86	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_c_of_type_Long	J
    //   307: invokevirtual 545	ley:a	(J)I
    //   310: istore 4
    //   312: iload 4
    //   314: iconst_m1
    //   315: if_icmpeq +25 -> 340
    //   318: aload_0
    //   319: getfield 191	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   322: invokevirtual 196	com/tencent/av/VideoController:a	()Lley;
    //   325: getfield 329	ley:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   328: iload 4
    //   330: invokevirtual 249	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   333: checkcast 540	lnn
    //   336: iconst_0
    //   337: putfield 542	lnn:jdField_c_of_type_Boolean	Z
    //   340: aload 8
    //   342: iconst_1
    //   343: putfield 542	lnn:jdField_c_of_type_Boolean	Z
    //   346: aload 8
    //   348: getfield 687	lnn:jdField_a_of_type_Long	J
    //   351: aload_0
    //   352: getfield 86	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_c_of_type_Long	J
    //   355: lcmp
    //   356: ifne +38 -> 394
    //   359: aload_0
    //   360: getfield 82	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_e_of_type_Int	I
    //   363: iconst_2
    //   364: if_icmpne +30 -> 394
    //   367: aconst_null
    //   368: ldc_w 690
    //   371: ldc 140
    //   373: ldc 140
    //   375: ldc_w 692
    //   378: ldc_w 692
    //   381: iconst_0
    //   382: iconst_0
    //   383: ldc 140
    //   385: ldc 140
    //   387: ldc 140
    //   389: ldc 140
    //   391: invokestatic 697	bcst:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   394: aload 8
    //   396: getfield 698	lnn:jdField_b_of_type_Boolean	Z
    //   399: ifne +27 -> 426
    //   402: aload_0
    //   403: getfield 191	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   406: invokevirtual 538	com/tencent/av/VideoController:h	()I
    //   409: iconst_4
    //   410: if_icmpeq +16 -> 426
    //   413: aload_0
    //   414: getfield 191	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   417: invokevirtual 196	com/tencent/av/VideoController:a	()Lley;
    //   420: getfield 701	ley:D	I
    //   423: invokestatic 705	mqw:b	(I)V
    //   426: aload_0
    //   427: getfield 191	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   430: invokevirtual 196	com/tencent/av/VideoController:a	()Lley;
    //   433: getfield 329	ley:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   436: iload 5
    //   438: aload 8
    //   440: invokevirtual 709	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   443: pop
    //   444: aload_0
    //   445: getfield 191	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   448: invokevirtual 196	com/tencent/av/VideoController:a	()Lley;
    //   451: getfield 329	ley:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   454: iload_2
    //   455: aload_3
    //   456: invokevirtual 709	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   459: pop
    //   460: aload_0
    //   461: getfield 191	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   464: invokevirtual 196	com/tencent/av/VideoController:a	()Lley;
    //   467: getfield 711	ley:jdField_d_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   470: astore_1
    //   471: aload_1
    //   472: monitorenter
    //   473: aload_0
    //   474: getfield 191	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   477: invokevirtual 196	com/tencent/av/VideoController:a	()Lley;
    //   480: getfield 711	ley:jdField_d_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   483: iload 5
    //   485: aload 8
    //   487: invokevirtual 709	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   490: pop
    //   491: aload_0
    //   492: getfield 191	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   495: invokevirtual 196	com/tencent/av/VideoController:a	()Lley;
    //   498: getfield 711	ley:jdField_d_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   501: iload_2
    //   502: aload_3
    //   503: invokevirtual 709	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   506: pop
    //   507: aload_0
    //   508: getfield 191	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   511: invokevirtual 196	com/tencent/av/VideoController:a	()Lley;
    //   514: invokevirtual 713	ley:c	()V
    //   517: aload_1
    //   518: monitorexit
    //   519: aload_0
    //   520: getfield 211	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   523: invokevirtual 217	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   526: checkcast 345	com/tencent/av/ui/AVActivity
    //   529: getfield 348	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   532: aload 8
    //   534: getfield 687	lnn:jdField_a_of_type_Long	J
    //   537: aload 8
    //   539: getfield 688	lnn:jdField_a_of_type_Int	I
    //   542: aload_3
    //   543: getfield 687	lnn:jdField_a_of_type_Long	J
    //   546: aload_3
    //   547: getfield 688	lnn:jdField_a_of_type_Int	I
    //   550: invokevirtual 716	com/tencent/av/ui/VideoLayerUI:a	(JIJI)V
    //   553: aload_0
    //   554: invokevirtual 461	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:e	()Z
    //   557: pop
    //   558: return
    //   559: astore_1
    //   560: aload_0
    //   561: getfield 232	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   564: iconst_2
    //   565: ldc_w 718
    //   568: invokestatic 658	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   571: return
    //   572: astore_3
    //   573: aload_1
    //   574: monitorexit
    //   575: aload_3
    //   576: athrow
    //   577: iload_2
    //   578: iconst_1
    //   579: iadd
    //   580: istore_2
    //   581: goto -413 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	584	0	this	MultiVideoCtrlLayerUIBase
    //   0	584	2	paramInt1	int
    //   0	584	3	paramString2	String
    //   0	584	4	paramInt2	int
    //   139	345	5	k	int
    //   97	108	6	l	long
    //   202	336	8	locallnn	lnn
    // Exception table:
    //   from	to	target	type
    //   90	99	559	java/lang/Exception
    //   473	519	572	finally
    //   573	575	572	finally
  }
  
  public void a(String paramString, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    ley localley;
    do
    {
      return;
      localley = this.jdField_a_of_type_ComTencentAvVideoController.a();
    } while (localley == null);
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "switchUIMode[" + paramString + "], SessionType[" + localley.jdField_d_of_type_Int + "], seq[" + paramLong + "]");
    }
    if (localley.jdField_d_of_type_Int == 4)
    {
      this.jdField_a_of_type_Mte.c(false);
      this.jdField_a_of_type_Mte.b(false);
      this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setVisibility(8);
      ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoLayerUI.i(this.jdField_a_of_type_ComTencentAvVideoController.a().N);
      ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.jdField_a_of_type_ComTencentAvVideoController.a());
      y();
      if (!localley.jdField_j_of_type_Boolean) {
        break label392;
      }
    }
    label392:
    for (int k = 2;; k = 1)
    {
      a(true, k);
      if (this.jdField_a_of_type_Mts != null) {
        this.jdField_a_of_type_Mts.a(true);
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
        this.jdField_a_of_type_Mte.c(true);
        this.jdField_a_of_type_Mte.b(true);
        this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setVisibility(0);
        paramString = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (!paramString.isFinishing()) {
          paramString.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i(-1);
        }
        y();
        a(false, 1);
        if (this.jdField_a_of_type_Mts != null) {
          this.jdField_a_of_type_Mts.a(false);
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
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "showOrHideRecvVideoBtnAndTips --> bShow = " + paramBoolean1 + " , needNoticeWiFiTips = " + paramBoolean2 + " , needShowGLView = " + paramBoolean3);
    }
    this.jdField_r_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_ComTencentAvVideoController.a().b(paramBoolean1);
    if (this.jdField_a_of_type_Lzx != null) {
      this.jdField_a_of_type_Lzx.a(paramBoolean1, new mft(this));
    }
    if (paramBoolean1)
    {
      mqw.d(bgnt.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()), this.jdField_a_of_type_ComTencentAvVideoController.a().D);
      K();
      if (paramBoolean2) {
        maf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3013);
      }
    }
    for (;;)
    {
      if (paramBoolean3) {
        b(AudioHelper.b(), this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList);
      }
      return;
      maf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3013);
      continue;
      maf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3013);
      maf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1030);
    }
  }
  
  boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_d_of_type_JavaLangString, 2, "checkRemoteVideo --> VideoController is null");
      }
      return false;
    }
    ley localley = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "checkRemoteVideo, displayViewList[" + localley.jdField_c_of_type_JavaUtilArrayList.size() + "], seq[" + paramLong + "]");
    }
    if (localley.jdField_c_of_type_JavaUtilArrayList.size() == 0)
    {
      a(paramLong, "checkRemoteVideo");
      a(false, false, false);
      return false;
    }
    if ((localley.jdField_c_of_type_JavaUtilArrayList.size() == 1) && (((lnn)localley.jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long == this.jdField_c_of_type_Long))
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
    ley localley = this.jdField_a_of_type_ComTencentAvVideoController.a();
    boolean bool2 = msn.i();
    boolean bool1;
    if ((!localley.ac) && (!localley.ad))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "checkBlockOpenMicOrCamera, isAllowedControlMicAfterBeMuted[" + bool2 + "], isNormalUser[" + bool1 + "], isRoomMicOff[" + localley.W + "], micAuthByAdmin[" + localley.H + "], openMic[" + paramBoolean + "]");
      }
      if ((!bool1) || (!localley.W) || (localley.H == 0)) {
        break label222;
      }
      if (!paramBoolean) {
        break label215;
      }
    }
    label215:
    for (int m = 2131694898;; m = 2131695061)
    {
      maf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1033, this.jdField_a_of_type_AndroidContentResResources.getString(m));
      if (paramBoolean) {
        k = 1;
      }
      bcst.b(null, "dc00898", "", "", "0X800AB7F", "0X800AB7F", k, 0, "1", "", "", "");
      return true;
      bool1 = false;
      break;
    }
    label222:
    if ((!bool2) && (bool1) && (localley.H == 1))
    {
      if (paramBoolean) {}
      for (m = 2131694901;; m = 2131695062)
      {
        maf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1033, this.jdField_a_of_type_AndroidContentResResources.getString(m));
        if (paramBoolean) {
          k = 1;
        }
        bcst.b(null, "CliOper", "", "", "0X800AB7F", "0X800AB7F", k, 0, "2", "", "", "");
        return true;
      }
    }
    return false;
  }
  
  void b()
  {
    long l = AudioHelper.b();
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "initUI, SessionType[" + ((ley)localObject1).jdField_d_of_type_Int + "], switchToGAudioMode[" + ((ley)localObject1).G + "], localMute[" + ((ley)localObject1).jdField_g_of_type_Boolean + "], seq[" + l + "]");
    super.b();
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      p();
      this.jdField_a_of_type_ComTencentAvUiQavPanel.e();
      localObject2 = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject2 != null)
      {
        this.jdField_a_of_type_Mts = mts.a();
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_Mts);
        this.jdField_a_of_type_Mte = mte.a(this.jdField_a_of_type_Mte, (Activity)localObject2, this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_Mts);
        this.jdField_a_of_type_Mte.a(true);
        this.jdField_a_of_type_Mts.a();
      }
    }
    this.jdField_d_of_type_AndroidWidgetTextView.post(this.jdField_g_of_type_JavaLangRunnable);
    i(l, 8);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373255));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370592));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376523));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373256));
    f(l, 65535);
    Object localObject2 = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_d_of_type_JavaLangString, 2, "initUI-->can not get AVActivity");
      }
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373509));
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI = ((MultiMembersAudioUI)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373404));
    this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI = ((MultiMembersVideoUI)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373405));
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
      mre.a(((AVActivity)localObject2).getApplicationContext());
      if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean)
      {
        this.jdField_a_of_type_Mte.b(true);
        this.jdField_a_of_type_Mte.c(true);
        if ((this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) && (!this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.b())) {
          this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.i();
        }
      }
      if ((((ley)localObject1).b()) && (((ley)localObject1).jdField_g_of_type_Boolean))
      {
        k = this.jdField_a_of_type_ComTencentAvVideoController.f();
        this.jdField_a_of_type_ComTencentAvVideoController.a("MultiVideoCtrlLayerUIBase.initUI", ((ley)localObject1).jdField_g_of_type_Long, false, true, -1);
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a("MultiVideoCtrlLayerUIBase.initUI", k, this.jdField_a_of_type_ComTencentAvVideoController.f(), false);
        }
        super.k(2131373207);
      }
      this.jdField_a_of_type_Mts.a();
      if (this.jdField_f_of_type_JavaLangRunnable == null) {
        this.jdField_f_of_type_JavaLangRunnable = new MultiVideoCtrlLayerUIBase.RefreshDisplayNameRunnable(this);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.jdField_f_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Mhe = new mhe((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentAvVideoController, 3, this.jdField_a_of_type_ComTencentAvUiQavPanel, this.jdField_c_of_type_AndroidWidgetRelativeLayout, null, null, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373384), null);
      this.jdField_a_of_type_Mhe.a();
      if (((ley)localObject1).jdField_d_of_type_Int == 4) {
        a("initUI", l);
      }
      ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.h());
      if (AudioHelper.a(0) == 1) {
        this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setBackgroundColor(531496751);
      }
      localObject1 = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373214);
      ((ImageView)localObject1).setOnClickListener(new mfp(this, (ImageView)localObject1));
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
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onResume, seq[" + paramLong + "]");
    }
    super.b(paramLong);
    o(paramLong);
    q(paramLong);
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.a().ao = false;
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
    this.jdField_r_of_type_Int = paramInt;
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a().s())) {
      return;
    }
    this.jdField_f_of_type_Int = (360 - paramInt);
    a(paramLong, this.jdField_f_of_type_Int);
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onGroupVideoChatClosed, relationId[" + paramLong + "], mIntentRelationId[" + this.jdField_a_of_type_Long + "]");
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
      localIntent.putExtra("from", this.jdField_d_of_type_JavaLangString);
      AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localAVActivity != null)
      {
        localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName());
        localAVActivity.sendBroadcast(localIntent);
        d(true);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e(this.jdField_d_of_type_JavaLangString, 2, "onGroupVideoChatClosed-->can not get the activity");
  }
  
  void b(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "notifyDataChange, from[" + paramString + "], seq[" + paramLong + "]");
    }
    paramString = this.jdField_a_of_type_ComTencentAvVideoController.a();
    ThreadManager.getSubThreadHandler().post(new MultiVideoCtrlLayerUIBase.6(this, paramString, paramLong));
  }
  
  public void b(long paramLong, ArrayList<lnn> paramArrayList)
  {
    int k = 0;
    for (;;)
    {
      if (k < paramArrayList.size())
      {
        lnn locallnn = (lnn)paramArrayList.get(k);
        if ((locallnn.jdField_a_of_type_Long == this.jdField_c_of_type_Long) && (locallnn.jdField_a_of_type_Int == 1) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean)) {
          paramArrayList.remove(k);
        }
      }
      else
      {
        this.jdField_b_of_type_Mbx.update(null, new Object[] { Integer.valueOf(103), paramArrayList, Long.valueOf(paramLong) });
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
      ley localley = this.jdField_a_of_type_ComTencentAvVideoController.a();
      this.jdField_d_of_type_Int = localley.jdField_j_of_type_Int;
      if (this.jdField_d_of_type_Int == 3000)
      {
        this.jdField_e_of_type_Int = 2;
        localley.F = this.jdField_e_of_type_Int;
        int k = localley.E;
        this.jdField_a_of_type_Long = localley.jdField_g_of_type_Long;
        this.jdField_c_of_type_Int = localley.E;
        this.q = false;
        if (paramIntent != null) {
          this.jdField_e_of_type_Boolean = paramIntent.getBooleanExtra("isVideo", false);
        }
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "processIntentData, mUinType[" + this.jdField_d_of_type_Int + "], mRelationType[" + this.jdField_e_of_type_Int + "], mIntentRelationId[" + this.jdField_a_of_type_Long + "], mStatusType[" + this.jdField_c_of_type_Int + "], mStatusType[" + k + "->" + this.jdField_c_of_type_Int + "], getSimpleDataList[" + this.jdField_a_of_type_ComTencentAvVideoController.e() + "], getGAudioList[" + this.jdField_a_of_type_ComTencentAvVideoController.c() + "]");
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_d_of_type_JavaLangString, 2, "Can not get AccountUin WHY!!!???");
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
        QLog.e(this.jdField_d_of_type_JavaLangString, 2, "switchMode --> Can not get activity");
      }
    }
    do
    {
      RelativeLayout localRelativeLayout;
      do
      {
        return;
        localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373262);
        localObject = (AVActivity)localObject;
        if (!paramBoolean) {
          break;
        }
        localRelativeLayout.setBackgroundColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131167224));
      } while (localObject == null);
      ((AVActivity)localObject).b(false);
      ((AVActivity)localObject).f(false);
      ((AVActivity)localObject).c(true);
      return;
      localRelativeLayout.setBackgroundColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131166018));
    } while (localObject == null);
    ((AVActivity)localObject).b(true);
    ((AVActivity)localObject).f(true);
    ((AVActivity)localObject).c(false);
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onPhoneCalling, isSelf[" + paramBoolean1 + "], seq[" + l + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    while (!paramBoolean1) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController.a().P)) {
      this.jdField_a_of_type_Mts.a(mts.jdField_b_of_type_Int);
    }
    e();
  }
  
  protected boolean b()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentAvVideoController.a().m();
  }
  
  abstract void c();
  
  public void c(int paramInt)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "showToolBars");
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().s())
    {
      e(paramInt);
      C(l);
    }
  }
  
  public void c(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 2, "onStop, seq[" + paramLong + "]");
    }
    super.c(paramLong);
    B();
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void c(long paramLong, int paramInt)
  {
    if ((paramInt == 2) || (paramInt == 1))
    {
      s(paramLong);
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList, 1, false);
    }
    super.c(paramLong, paramInt);
  }
  
  void c(long paramLong, View paramView)
  {
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_Mute, micPermission[" + this.jdField_a_of_type_ComTencentAvVideoController.a().p + "], seq[" + paramLong + "]");
    if (a(paramLong, "android.permission.RECORD_AUDIO", paramView)) {
      t(paramLong);
    }
    super.C(paramLong);
  }
  
  public void c(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {
      e();
    }
    s();
  }
  
  public void c(Intent paramIntent)
  {
    boolean bool = false;
    super.c(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "OnNewIntent");
    }
    b(paramIntent);
    if (paramIntent != null)
    {
      bool = paramIntent.getBooleanExtra("needStartTRAE", false);
      K();
    }
    a(paramIntent);
    if (bool) {
      this.jdField_a_of_type_Mts.c();
    }
    a();
  }
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      super.l(2131373207);
      if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (paramBoolean2))
      {
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel.a() == 3) {
          break label58;
        }
        q(true);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
      }
    }
    label58:
    do
    {
      return;
      maf.a(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 9, 3000L);
      break;
      super.k(2131373207);
      maf.a(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false);
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373207, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131692578));
      }
    } while ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (!paramBoolean2));
    q(false);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
  }
  
  protected abstract boolean c();
  
  public void d()
  {
    super.d();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "OnCreate");
    }
    Object localObject = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_d_of_type_JavaLangString, 2, "Can not get activity");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_b_of_type_Ldy);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lem);
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
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "OnDestroy, seq[" + paramLong + "]");
    }
    this.jdField_a_of_type_ComTencentAvVideoController.r();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_b_of_type_Ldy);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lem);
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
    maf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1030);
    maf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036);
    maf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1037);
    maf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3013);
    maf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1034);
    maf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1035);
    this.jdField_a_of_type_Mte.a(false);
    this.jdField_a_of_type_Mte.b(false);
    this.jdField_a_of_type_Mte.c(false);
    this.jdField_a_of_type_Mte = null;
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI = null;
    this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI = null;
    this.jdField_b_of_type_JavaLangString = null;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    }
    if (this.jdField_a_of_type_Bkej != null)
    {
      this.jdField_a_of_type_Bkej.a(paramLong);
      this.jdField_a_of_type_Bkej = null;
    }
    if (this.jdField_a_of_type_Mhe != null)
    {
      this.jdField_a_of_type_Mhe.b();
      this.jdField_a_of_type_Mhe = null;
    }
    super.d(paramLong);
  }
  
  void d(long paramLong, int paramInt)
  {
    boolean bool = true;
    String str;
    if (paramInt <= 1)
    {
      str = this.jdField_a_of_type_AndroidContentResResources.getString(2131694913);
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
      str = String.format(this.jdField_a_of_type_AndroidContentResResources.getString(2131694685), new Object[] { Integer.valueOf(paramInt) });
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  void d(long paramLong, View paramView)
  {
    ley localley = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_CAMERA, sessionInfo[" + localley + "], mHasLauncnRequestFromCameraButton[" + this.q + "], seq[" + paramLong + "]");
    if (a(paramLong, "android.permission.CAMERA", paramView))
    {
      if (localley.jdField_j_of_type_Boolean) {
        break label321;
      }
      if (!f()) {
        break label94;
      }
      label94:
      while (a(false)) {
        return;
      }
      mqw.f(true);
      if (bgnt.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) {
        break label352;
      }
      if (VideoController.d(VideoController.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()) <= 0) {
        break label358;
      }
    }
    label278:
    label321:
    label352:
    label358:
    for (int k = 0;; k = 1)
    {
      if (k != 0)
      {
        paramView = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramView == null) {
          break;
        }
        bglp.a(paramView, 230, this.jdField_a_of_type_AndroidContentResResources.getString(2131695038), this.jdField_a_of_type_AndroidContentResResources.getString(2131695035), 2131694772, 2131694784, new mfm(this, paramLong), new mfn(this)).show();
      }
      for (k = 0;; k = 1)
      {
        if (k != 0)
        {
          if ((localley.b() != -1) || (bgnt.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()))) {
            break label278;
          }
          r(paramLong);
        }
        for (;;)
        {
          j(paramLong, 2131694686);
          return;
          if (d())
          {
            this.q = true;
            f(paramLong, 65535);
          }
          else if (QLog.isColorLevel())
          {
            QLog.e(this.jdField_d_of_type_JavaLangString, 2, "PressCameraBtnRunnable-->go on stage fail,can not find the session");
            continue;
            s(paramLong);
            this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Long, localley.jdField_c_of_type_JavaUtilArrayList, localley.jdField_d_of_type_JavaUtilArrayList, 1, false);
          }
        }
      }
    }
  }
  
  public void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "addRequestVideoTimeoutRunnable[" + paramString + "]");
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
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "Go on Stage");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      return this.jdField_a_of_type_ComTencentAvVideoController.k();
    }
    if (QLog.isColorLevel()) {
      QLog.e(this.jdField_d_of_type_JavaLangString, 2, "Go On Stage, VideoController is null");
    }
    return false;
  }
  
  @QQPermissionDenied(2)
  public void deniedForAudioRecord()
  {
    QLog.d(this.jdField_d_of_type_JavaLangString, 1, "showPermissionDialog deniedForAudioRecord(2) 10");
  }
  
  public abstract void e();
  
  void e(long paramLong, int paramInt)
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      if ((QLog.isDevelopLevel()) || (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != paramInt)) {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "setVisibility_ConnectInfoView_TopCenter, visibility[" + this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() + "->" + paramInt + "], seq[" + paramLong + "]");
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(paramInt);
      CharSequence localCharSequence = this.jdField_c_of_type_AndroidWidgetTextView.getText();
      if (TextUtils.equals(this.jdField_a_of_type_AndroidContentResResources.getString(2131694913), localCharSequence)) {
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
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "removeRequestVideoTimeoutRunnable[" + paramString + "]");
    }
    if (this.jdField_b_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    long l = AudioHelper.b();
    if (this.jdField_a_of_type_Bkej == null)
    {
      this.jdField_a_of_type_Bkej = new bkej((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), null);
      if (!paramBoolean) {
        break label97;
      }
      if (mre.a("qav_gaudio_muted.mp3")) {
        this.jdField_a_of_type_Bkej.a(l, 2, 0, null, mre.a() + "qav_gaudio_muted.mp3", false, 1, false, true, 0);
      }
    }
    label97:
    while (!mre.a("qav_gaudio_cancel_muted.mp3"))
    {
      return;
      this.jdField_a_of_type_Bkej.a(l);
      break;
    }
    this.jdField_a_of_type_Bkej.a(l, 2, 0, null, mre.a() + "qav_gaudio_cancel_muted.mp3", false, 1, false, true, 0);
  }
  
  public boolean e()
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "startRecvAllVideo");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_d_of_type_JavaLangString, 2, "startRecvAllVideo --> VideoController is null");
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
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "startRecvAllVideo --> isResume = " + bool1);
      }
      if (!bool1) {
        break;
      }
      int m = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size();
      int k = m;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean) {
        k = m - 1;
      }
      if (k <= 0)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e(this.jdField_d_of_type_JavaLangString, 2, "startRecvAllVideo --> There is no video need request");
        return false;
      }
      k = lrz.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp());
      if (k == 1)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e(this.jdField_d_of_type_JavaLangString, 2, "startRecvAllVideo --> This version is not supportsharpvideo or opengl.  GlVersion = " + k);
        return false;
      }
      bcst.b(null, "CliOper", "", "", "0X8005617", "0X8005617", 0, 0, "", "", "", "");
      k = this.jdField_a_of_type_ComTencentAvVideoController.h();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "startRecvAllVideo --> Ability = " + k);
      }
      if (k != 4)
      {
        if (this.jdField_e_of_type_Int == 2) {
          bcst.b(null, "CliOper", "", "", "0X8004CF6", "0X8004CF6", 0, 0, "", "", "", "");
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() > 1) {
          maf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3007);
        }
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().e.clear();
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      k = 0;
      while (k < this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size())
      {
        localObject = (lnn)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(k);
        if ((((lnn)localObject).jdField_c_of_type_Boolean) && (l != ((lnn)localObject).jdField_a_of_type_Long)) {
          this.jdField_a_of_type_ComTencentAvVideoController.a().e.add(localObject);
        }
        k += 1;
      }
      a(false, false, false);
      E();
      maf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036);
      maf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1037);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().N == 3) {}
      for (bool1 = bool2;; bool1 = false) {
        return this.jdField_a_of_type_ComTencentAvVideoController.a(bool1);
      }
    }
  }
  
  boolean f()
  {
    if ((!lkw.e()) || (lrz.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) == 1))
    {
      DoubleVideoCtrlUI.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      return false;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.b() >= jdField_b_of_type_Int)
    {
      maf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1031);
      return false;
    }
    return true;
  }
  
  public void g(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "onLayoutModeChange --> ScreenType = " + paramInt + " , hasSetBigVideoView = " + this.jdField_a_of_type_ComTencentAvVideoController.a().v());
    }
    Iterator localIterator;
    lnn locallnn;
    if (paramInt == 3)
    {
      if (4 == this.jdField_a_of_type_ComTencentAvVideoController.h())
      {
        localIterator = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          locallnn = (lnn)localIterator.next();
          if (!locallnn.jdField_a_of_type_Boolean) {
            locallnn.jdField_c_of_type_Boolean = true;
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() > 0) {
        ((lnn)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_Boolean = true;
      }
    }
    for (;;)
    {
      e();
      return;
      if (paramInt == 4)
      {
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().v()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() > 0))
        {
          ((lnn)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_d_of_type_JavaLangString, 2, "MultiVideoCtrlLayerUIBase onLayoutModeChange --> displayList  not has big one");
          }
        }
        if (4 == this.jdField_a_of_type_ComTencentAvVideoController.h())
        {
          localIterator = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext())
          {
            locallnn = (lnn)localIterator.next();
            if (!locallnn.jdField_a_of_type_Boolean) {
              locallnn.jdField_c_of_type_Boolean = true;
            }
          }
        }
        else if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() > 0)
        {
          ((lnn)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_Boolean = true;
        }
      }
    }
  }
  
  protected boolean g()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return false;
    }
    ley localley = this.jdField_a_of_type_ComTencentAvVideoController.a();
    boolean bool2 = msn.i();
    if ((!localley.ac) && (!localley.ad)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "canStopMuteStatus, isAllowedControlMicAfterBeMuted[" + bool2 + "], isNormalUser[" + bool1 + "], isRoomMicOff[" + localley.W + "], micAuthByAdmin[" + localley.H + "], mIsPhoneCalling[" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Boolean + "]");
      }
      if (((bool1) && (localley.W) && (localley.H != 0)) || ((!bool2) && (bool1) && (localley.H == 1)) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Boolean)) {
        break;
      }
      return true;
    }
  }
  
  @QQPermissionGrant(2)
  public void grantForAudioRecord()
  {
    QLog.d(this.jdField_d_of_type_JavaLangString, 1, "showPermissionDialog grantForAudioRecord(2) 09");
  }
  
  void h(int paramInt)
  {
    if ((paramInt == 6) || (paramInt == 8) || (paramInt == 74)) {}
    do
    {
      do
      {
        return;
      } while (lrz.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) != 1);
      maf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1012, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131719060));
      bcst.b(null, "CliOper", "", "", "0X8004E94", "0X8004E94", 0, 0, "", "", "", "");
      bcst.b(null, "CliOper", "", "", "0X8005618", "0X8005618", 0, 0, "", "", "", "");
    } while (!QLog.isColorLevel());
    QLog.e(this.jdField_d_of_type_JavaLangString, 2, "startRecvAllVideo-->GLVersion not support");
  }
  
  public void i(long paramLong) {}
  
  public void j(long paramLong) {}
  
  public void m(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "OnPause, seq[" + paramLong + "]");
    }
    super.m(paramLong);
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "OnPause Error : VideoController is null");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().ao = true;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c("MultiVideoCtrlLayerUIBase");
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      if (((!lyu.f()) || ((!bgnt.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().aq))) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean)) {
        s(paramLong);
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().b() != -1) {
        this.jdField_a_of_type_ComTencentAvVideoController.a("Multi_onPause");
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_c_of_type_Long, true, true);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable);
  }
  
  public void o()
  {
    super.o();
  }
  
  void o(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean))
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.h())
      {
        super.k(2131373207);
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.b(this.jdField_a_of_type_ComTencentAvVideoController.h());
        }
      }
      this.jdField_a_of_type_ComTencentAvVideoController.p();
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int != 9) {
        break label113;
      }
      e(paramLong, true);
      g(paramLong, 2131694913);
    }
    for (;;)
    {
      A(paramLong);
      this.jdField_a_of_type_Mte.c(true);
      this.jdField_a_of_type_Mte.b(true);
      return;
      label113:
      e(paramLong, false);
      d(paramLong, null);
    }
  }
  
  protected abstract void p();
  
  void p(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "sendVideoMsgBroadcast--> discussionId = " + paramLong);
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
        localIntent.putExtra("MultiAVType", this.jdField_a_of_type_ComTencentAvVideoController.a().D);
        localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName());
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
      }
    }
  }
  
  void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "resumeVideo");
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
    if (h()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373207, true);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131373207, true);
      if (!this.jdField_a_of_type_ComTencentAvVideoController.h()) {
        break label117;
      }
      k(2131373207);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.b(this.jdField_a_of_type_ComTencentAvVideoController.h());
      }
      y();
      long l = this.jdField_b_of_type_Long;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_d_of_type_Int, String.valueOf(l));
      f(paramLong, 65535);
      A(paramLong);
      return;
      label117:
      l(2131373207);
    }
  }
  
  void r()
  {
    long l2 = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "initViewList, seq[" + l2 + "]");
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
    Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    String str = this.jdField_d_of_type_JavaLangString;
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
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().t()) {}
    for (int k = 2131695050;; k = 2131695051)
    {
      bglp.a(localContext, 230, null, this.jdField_a_of_type_AndroidContentResResources.getString(k), 2131694772, 2131694784, new mfr(this, paramLong), new mfs(this)).show();
      return;
    }
  }
  
  public void s()
  {
    int m = 0;
    int n = 0;
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    Object localObject1;
    label153:
    label197:
    label346:
    label352:
    label360:
    label366:
    label378:
    do
    {
      ImageView localImageView;
      do
      {
        return;
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() <= 0)) {
          break;
        }
        k = 1;
        localObject1 = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373180);
        localObject2 = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373531);
        localImageView = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373214);
        if (k == 0) {
          break label386;
        }
        ((TextView)localObject1).setVisibility(8);
        if ((!jdField_a_of_type_Boolean) && (!this.jdField_f_of_type_Boolean))
        {
          QLog.d(this.jdField_d_of_type_JavaLangString, 2, "refreshSpokesmanInfoUI video. txt = " + this.jdField_c_of_type_JavaLangString);
          if (!this.jdField_h_of_type_Boolean) {
            break label346;
          }
          m = 71;
          k = m;
          if (ImmersiveUtils.isSupporImmersive() != 1) {
            k = m - ImmersiveUtils.getStatusBarHeight((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
          }
          m = k;
          if (VideoConstants.jdField_c_of_type_Boolean)
          {
            if (!this.jdField_h_of_type_Boolean) {
              break label352;
            }
            m = k + 5;
          }
          localObject1 = (RelativeLayout.LayoutParams)((TextView)localObject2).getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)mue.a(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), m));
          ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          ((TextView)localObject2).setText(this.jdField_c_of_type_JavaLangString);
          if (this.jdField_c_of_type_JavaLangString.length() <= 0) {
            break label360;
          }
          k = 0;
          ((TextView)localObject2).setVisibility(k);
          if (this.jdField_c_of_type_JavaLangString.length() <= 0) {
            break label366;
          }
          k = n;
          localImageView.setVisibility(k);
        }
        localObject1 = a();
      } while ((localObject1 == null) || (((AVActivity)localObject1).jdField_a_of_type_ComTencentAvUiVideoLayerUI == null));
      if (this.jdField_h_of_type_Boolean)
      {
        k = 115;
        m = k;
        if (VideoConstants.jdField_c_of_type_Boolean) {
          if (!this.jdField_h_of_type_Boolean) {
            break label378;
          }
        }
      }
      for (m = k + 5;; m = k + 25)
      {
        ((AVActivity)localObject1).jdField_a_of_type_ComTencentAvUiVideoLayerUI.o(m);
        return;
        k = 0;
        break;
        m = 21;
        break label153;
        m = k + 25;
        break label197;
        k = 8;
        break label259;
        k = 8;
        break label277;
        k = 65;
        break label312;
      }
      ((TextView)localObject2).setVisibility(8);
      localImageView.setVisibility(8);
    } while (jdField_a_of_type_Boolean);
    label259:
    label277:
    label312:
    ((TextView)localObject1).setText(this.jdField_c_of_type_JavaLangString);
    label386:
    Object localObject2 = a();
    if (((localObject2 != null) && (((AVActivity)localObject2).jdField_a_of_type_Mmj != null) && (((AVActivity)localObject2).jdField_a_of_type_Mmj.b())) || (this.jdField_a_of_type_ComTencentAvVideoController.c().size() <= 8))
    {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "refreshSpokesmanInfoUI audio. txt = " + this.jdField_c_of_type_JavaLangString + ", isSoftKeyboardShown = " + ((AVActivity)localObject2).jdField_a_of_type_Mmj.b() + ", member cnt = " + this.jdField_a_of_type_ComTencentAvVideoController.c().size());
      ((TextView)localObject1).setVisibility(8);
      label534:
      if (((TextView)localObject1).getVisibility() == 0) {
        this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373384).setVisibility(8);
      }
    }
    else
    {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "refreshSpokesmanInfoUI audio. txt = " + this.jdField_c_of_type_JavaLangString);
      if (this.jdField_c_of_type_JavaLangString.length() <= 0) {
        break label610;
      }
    }
    label610:
    for (int k = m;; k = 8)
    {
      ((TextView)localObject1).setVisibility(k);
      break label534;
      break;
    }
  }
  
  public void s(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "goOffStage, seq[" + paramLong + "]");
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_b_of_type_Mbx == null) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "goOffStage --> Error");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.v();
    this.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, "goOffStage", false, false);
    this.jdField_b_of_type_Mbx.update(null, new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
    b(2131373514, 8);
    AVActivity localAVActivity = a();
    if (localAVActivity != null) {
      localAVActivity.a(false);
    }
    a("goOffStage", paramLong);
  }
  
  void t(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentAvUiQavPanel.a()) && (!this.jdField_a_of_type_ComTencentAvUiQavPanel.b()))
    {
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "intercept doMute operation");
      return;
    }
    boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.h();
    if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean) {}
    for (long l = this.jdField_b_of_type_Long;; l = this.jdField_a_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "doMute, relationId[" + l + "], mute[" + bool + "], seq[" + paramLong + "]");
      }
      if (!bool) {
        break label282;
      }
      if (a(true)) {
        break;
      }
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Boolean) {
        break label172;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "PhoneCalling-status not support open MIC");
      return;
    }
    label172:
    if (this.jdField_e_of_type_Int == 2) {
      mqw.a(true, 1);
    }
    int k;
    for (;;)
    {
      q(true);
      k = this.jdField_a_of_type_ComTencentAvVideoController.f();
      this.jdField_a_of_type_ComTencentAvVideoController.a("MultiVideoCtrlLayerUIBase.doMute.1", l, true, true, -1);
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a("MultiVideoCtrlLayerUIBase.doMute.1", k, this.jdField_a_of_type_ComTencentAvVideoController.f(), false);
      }
      super.l(2131373207);
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
      return;
      mqw.a(true, 10);
    }
    label282:
    if (this.jdField_e_of_type_Int == 2) {
      mqw.a(false, 1);
    }
    for (;;)
    {
      q(false);
      k = this.jdField_a_of_type_ComTencentAvVideoController.f();
      this.jdField_a_of_type_ComTencentAvVideoController.a("MultiVideoCtrlLayerUIBase.doMute.2", l, false, true, -1);
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a("MultiVideoCtrlLayerUIBase.doMute.2", k, this.jdField_a_of_type_ComTencentAvVideoController.f(), false);
      }
      super.k(2131373207);
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
      return;
      mqw.a(false, 10);
    }
  }
  
  public void u(long paramLong)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "go on stage failed, info[" + paramLong + "]");
    }
    b(2131373514, 8);
    AVActivity localAVActivity = a();
    if (localAVActivity != null) {
      localAVActivity.a(false);
    }
    f(l, 65535);
    if (paramLong == 7L) {
      maf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1029);
    }
    for (;;)
    {
      if (this.jdField_e_of_type_Int == 2) {
        bcst.b(null, "CliOper", "", "", "0X800441E", "0X800441E", 0, 0, "", "", "", "");
      }
      return;
      if (paramLong == 8L) {
        maf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1033, this.jdField_a_of_type_AndroidContentResResources.getString(2131695061));
      } else {
        maf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1028);
      }
    }
  }
  
  void v()
  {
    long l = AudioHelper.b();
    boolean bool;
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
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
        break label89;
      }
    }
    label89:
    do
    {
      return;
      bool = false;
      break;
      if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean) {
        break label117;
      }
    } while (!QLog.isColorLevel());
    QLog.e(this.jdField_d_of_type_JavaLangString, 2, "startOrResumeRemoteOrLocalVideo, Not in MultiVideoRoom");
    return;
    label117:
    int m = this.jdField_a_of_type_ComTencentAvVideoController.b();
    int n = this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_c_of_type_Long, 1);
    int k;
    if (n != -1)
    {
      k = 1;
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "startOrResumeRemoteOrLocalVideo, onStageNum[" + m + "], index[" + n + "]");
      }
      if ((!bgnt.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().aq)) {
        break label389;
      }
      if (k != 0)
      {
        if (m >= jdField_b_of_type_Int) {
          break label341;
        }
        if (!d()) {
          break label281;
        }
        f(l, 65535);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() <= 0) {
        break label384;
      }
      e();
      return;
      k = 0;
      break;
      label281:
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_d_of_type_JavaLangString, 2, "startOrResumeRemoteOrLocalVideo, Go on Stage Failed");
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList, 1, false);
      this.jdField_a_of_type_ComTencentAvVideoController.u();
      continue;
      label341:
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList, 1, false);
      this.jdField_a_of_type_ComTencentAvVideoController.u();
    }
    label384:
    K();
    return;
    label389:
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "startOrResumeRemoteOrLocalVideo --> is not connect wifi");
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
      if (!bgnt.g((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()))
      {
        DoubleVideoCtrlUI.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0);
        return;
      }
      a(true, true, true);
      return;
    }
    K();
  }
  
  void v(long paramLong)
  {
    QLog.d(this.jdField_d_of_type_JavaLangString, 1, "avideo onClick QavPanel.ViewID.SWITCH_DISPLAY_MODE");
    int m;
    int k;
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() > 0))
    {
      AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      m = localAVActivity.c();
      if (3 != m) {
        break label140;
      }
      k = 1;
      if (4 != m) {
        break label145;
      }
      m = 1;
      label77:
      if (m == 0) {
        break label151;
      }
      bcst.b(null, "CliOper", "", "", "0X8009F5E", "0X8009F5E", 0, 0, "", "", "", "");
      label109:
      if ((m == 0) && (k == 0)) {
        break label186;
      }
      if (k == 0) {
        break label181;
      }
      k = 4;
      label124:
      localAVActivity.a(k, false);
    }
    for (;;)
    {
      j(paramLong, 2131694697);
      return;
      label140:
      k = 0;
      break;
      label145:
      m = 0;
      break label77;
      label151:
      bcst.b(null, "CliOper", "", "", "0X8009F5F", "0X8009F5F", 0, 0, "", "", "", "");
      break label109;
      label181:
      k = 3;
      break label124;
      label186:
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "avideo onClick QavPanel.ViewID.SWITCH_DISPLAY_MODE error happen");
    }
  }
  
  void w()
  {
    E();
    maf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036);
    maf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1037);
    maf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1030);
    this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_c_of_type_Long, true, true);
    a(true, false, true);
  }
  
  void w(long paramLong)
  {
    x(paramLong);
    j(paramLong, 2131694688);
  }
  
  public void x()
  {
    int k;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().N == 1)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.h() != 4) {
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
          QLog.d(this.jdField_d_of_type_JavaLangString, 4, "initScreenLayout Style=" + k + "|" + this.jdField_a_of_type_ComTencentAvVideoController.a().N + "|" + this.jdField_a_of_type_ComTencentAvVideoController.h());
        }
        localAVActivity.a(k, false);
      }
      return;
      k = 4;
      break;
    }
  }
  
  void x(long paramLong)
  {
    boolean bool = false;
    QLog.d(this.jdField_d_of_type_JavaLangString, 1, "OnClick_MemberInfo");
    bcst.b(null, "CliOper", "", "", "0X8009F64", "0X8009F64", 0, 0, "", "", "", "");
    AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().ac) || (this.jdField_a_of_type_ComTencentAvVideoController.a().ad)) {
      bool = true;
    }
    VideoMsgTools.a(localAVActivity, String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Long), bool, true);
  }
  
  void y()
  {
    long l = AudioHelper.b();
    ley localley = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "refreshMemberCtrlButton, SessionType[" + localley.jdField_d_of_type_Int + "], multiAVType[" + localley.D + "], mUinType[" + this.jdField_d_of_type_Int + "], isManager[" + localley.ac + "], isRoomCreator[" + localley.ad + "], mGAudioInRoom[" + this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean + "]");
    f(l, 65535);
  }
  
  protected void y(long paramLong)
  {
    if (!VideoController.a()) {
      return;
    }
    ley localley = this.jdField_a_of_type_ComTencentAvVideoController.a();
    localley.c(paramLong, true);
    long l = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
    int k = 0;
    if (k < localley.jdField_c_of_type_JavaUtilArrayList.size())
    {
      lnn locallnn = (lnn)localley.jdField_c_of_type_JavaUtilArrayList.get(k);
      if ((locallnn.jdField_a_of_type_Long == l) && (locallnn.jdField_a_of_type_Int == 2)) {
        locallnn.jdField_b_of_type_Boolean = true;
      }
      for (locallnn.jdField_d_of_type_Boolean = true;; locallnn.jdField_d_of_type_Boolean = false)
      {
        k += 1;
        break;
        locallnn.jdField_b_of_type_Boolean = false;
      }
    }
    localley.a(-1L, "onUserScreenShareOpen", 4);
    a("onUserScreenShareOpen", paramLong);
    b(paramLong, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList);
  }
  
  public void z()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0);
    int k = localSharedPreferences.getInt("group_video_push_cfg_txt." + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin() + ".level", 1);
    int m = localSharedPreferences.getInt("group_video_push_cfg_txt." + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin() + ".sendDura", 5000);
    int n = localSharedPreferences.getInt("group_video_push_cfg_txt." + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin() + ".validDura", 6000);
    this.jdField_a_of_type_ComTencentAvVideoController.a(k, m, n);
  }
  
  protected void z(long paramLong)
  {
    if (!VideoController.a()) {
      return;
    }
    ley localley = this.jdField_a_of_type_ComTencentAvVideoController.a();
    localley.c(paramLong, false);
    if (localley.jdField_c_of_type_JavaUtilArrayList.size() == 0) {
      localley.a(-1L, "onUserScreenShareOpen", 3);
    }
    a(paramLong);
    a("onUserScreenShareClose", paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase
 * JD-Core Version:    0.7.0.1
 */