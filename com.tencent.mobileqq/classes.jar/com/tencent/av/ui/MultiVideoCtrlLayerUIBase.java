package com.tencent.av.ui;

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
import bdla;
import bhdj;
import bkxc;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.ArrayList<Lmgv;>;
import java.util.Iterator;
import lch;
import lcu;
import lee;
import les;
import lfe;
import llq;
import lob;
import lsq;
import lzr;
import max;
import mbf;
import mcx;
import mgi;
import mgj;
import mgn;
import mgo;
import mgp;
import mgq;
import mgr;
import mgs;
import mgt;
import mgu;
import mgv;
import mif;
import mnm;
import mqq.app.BaseActivity;
import mqq.app.MobileQQ;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mqq.os.MqqHandler;
import mrr;
import mry;
import msa;
import msi;
import msy;
import mtr;
import mtt;
import muk;
import muy;
import mvk;

public abstract class MultiVideoCtrlLayerUIBase
  extends VideoControlUI
{
  private static boolean jdField_a_of_type_Boolean;
  static int jdField_b_of_type_Int;
  public long a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new mgp(this);
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  bkxc jdField_a_of_type_Bkxc = null;
  public MultiMembersAudioUI a;
  MultiMembersVideoUI jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI = null;
  public MultiVideoCtrlLayerUIBase.InviteUserNoticeRunnable a;
  MultiVideoCtrlLayerUIBase.StartRecvVideoRunnable jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable = new MultiVideoCtrlLayerUIBase.StartRecvVideoRunnable(this);
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  String jdField_a_of_type_JavaLangString = null;
  ArrayList<mgv> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private les jdField_a_of_type_Les = new mgi(this);
  mif jdField_a_of_type_Mif = null;
  msy jdField_a_of_type_Msy = new mgr(this);
  mtt jdField_a_of_type_Mtt = null;
  public long b;
  ImageView jdField_b_of_type_AndroidWidgetImageView = null;
  TextView jdField_b_of_type_AndroidWidgetTextView = null;
  Runnable jdField_b_of_type_JavaLangRunnable = null;
  String jdField_b_of_type_JavaLangString;
  ArrayList<mgv> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  lee jdField_b_of_type_Lee = new mgj(this);
  public boolean b;
  public int c;
  public long c;
  TextView jdField_c_of_type_AndroidWidgetTextView = null;
  Runnable jdField_c_of_type_JavaLangRunnable = null;
  String jdField_c_of_type_JavaLangString = "";
  boolean jdField_c_of_type_Boolean = false;
  public int d;
  TextView jdField_d_of_type_AndroidWidgetTextView = null;
  Runnable jdField_d_of_type_JavaLangRunnable = null;
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
  int i = -1;
  int j;
  int k = 0;
  int l = 1;
  private boolean q;
  private boolean r;
  
  static
  {
    int m = 16;
    jdField_b_of_type_Int = 16;
    if (Build.VERSION.SDK_INT >= 21)
    {
      jdField_b_of_type_Int = m;
      if ((!Build.MODEL.equalsIgnoreCase("SM-G7106")) && (!Build.MODEL.equalsIgnoreCase("MI 2")) && (!Build.MODEL.equalsIgnoreCase("GT-B9388")) && (!Build.MODEL.equalsIgnoreCase("L39u")) && (!Build.MODEL.equalsIgnoreCase("R7007")) && (!Build.MODEL.equalsIgnoreCase("VIVO X5S L"))) {
        break label99;
      }
    }
    label99:
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
      m = 9;
      break;
    }
  }
  
  public MultiVideoCtrlLayerUIBase(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, mcx parammcx)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, parammcx);
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI = null;
    this.jdField_e_of_type_JavaLangRunnable = null;
    this.jdField_f_of_type_JavaLangRunnable = null;
    this.jdField_h_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_j_of_type_Int = -1;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_JavaLangRunnable = new MultiVideoCtrlLayerUIBase.3(this);
    this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$InviteUserNoticeRunnable = new MultiVideoCtrlLayerUIBase.InviteUserNoticeRunnable(this);
  }
  
  private String a(ArrayList<mgv> paramArrayList)
  {
    lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i3 = mrr.b(locallfe.jdField_j_of_type_Int);
    Object localObject1;
    Object localObject2;
    int m;
    int n;
    int i1;
    if (paramArrayList.size() > 0)
    {
      localObject1 = ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131695631);
      localObject2 = new int[3];
      Object tmp50_48 = localObject2;
      tmp50_48[0] = -1;
      Object tmp54_50 = tmp50_48;
      tmp54_50[1] = -1;
      Object tmp58_54 = tmp54_50;
      tmp58_54[2] = -1;
      tmp58_54;
      m = 0;
      if (m < paramArrayList.size())
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_d_of_type_JavaLangString, 2, "speakingInfoList. idx = " + m + ", uin = " + ((mgv)paramArrayList.get(m)).jdField_a_of_type_JavaLangString + ", audioEnergy = " + ((mgv)paramArrayList.get(m)).jdField_a_of_type_Int);
        }
        if ((localObject2[0] == -1) || (((mgv)paramArrayList.get(localObject2[0])).jdField_a_of_type_Int < ((mgv)paramArrayList.get(m)).jdField_a_of_type_Int))
        {
          localObject2[2] = localObject2[1];
          localObject2[1] = localObject2[0];
          localObject2[0] = m;
        }
        for (;;)
        {
          m += 1;
          break;
          if ((localObject2[1] == -1) || (((mgv)paramArrayList.get(localObject2[1])).jdField_a_of_type_Int < ((mgv)paramArrayList.get(m)).jdField_a_of_type_Int))
          {
            localObject2[2] = localObject2[1];
            localObject2[1] = m;
          }
          else if ((localObject2[2] == -1) || (((mgv)paramArrayList.get(localObject2[2])).jdField_a_of_type_Int < ((mgv)paramArrayList.get(m)).jdField_a_of_type_Int))
          {
            localObject2[2] = m;
          }
        }
      }
      n = 0;
      if (n < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        i1 = 0;
        label322:
        if (i1 >= localObject2.length) {
          break label1171;
        }
        if (localObject2[i1] < 0) {
          m = 0;
        }
      }
    }
    for (;;)
    {
      label340:
      if (m != 0)
      {
        ((mgv)paramArrayList.get(localObject2[i1])).jdField_a_of_type_JavaLangString = "";
        ((mgv)this.jdField_b_of_type_JavaUtilArrayList.get(n)).jdField_a_of_type_Int = ((mgv)paramArrayList.get(localObject2[i1])).jdField_a_of_type_Int;
      }
      for (;;)
      {
        n += 1;
        break;
        if (((mgv)this.jdField_b_of_type_JavaUtilArrayList.get(n)).jdField_a_of_type_JavaLangString.equalsIgnoreCase(((mgv)paramArrayList.get(localObject2[i1])).jdField_a_of_type_JavaLangString))
        {
          m = 1;
          break label340;
        }
        i1 += 1;
        break label322;
        ((mgv)this.jdField_b_of_type_JavaUtilArrayList.get(n)).jdField_a_of_type_JavaLangString = "";
      }
      n = 0;
      m = 0;
      int i2;
      if (n < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        i1 = m;
        i2 = n;
        if (((mgv)this.jdField_b_of_type_JavaUtilArrayList.get(n)).jdField_a_of_type_JavaLangString.equalsIgnoreCase(""))
        {
          i1 = m;
          label511:
          m = i1;
          if (i1 < localObject2.length)
          {
            if (localObject2[i1] >= 0) {
              break label575;
            }
            m = i1;
          }
          label533:
          if ((m >= localObject2.length) || (localObject2[m] >= 0)) {
            break label1162;
          }
          this.jdField_b_of_type_JavaUtilArrayList.remove(n);
          i2 = n - 1;
          i1 = m;
        }
      }
      for (;;)
      {
        n = i2 + 1;
        m = i1;
        break;
        label575:
        if (!((mgv)paramArrayList.get(localObject2[i1])).jdField_a_of_type_JavaLangString.equalsIgnoreCase(""))
        {
          ((mgv)this.jdField_b_of_type_JavaUtilArrayList.get(n)).jdField_a_of_type_JavaLangString = ((mgv)paramArrayList.get(localObject2[i1])).jdField_a_of_type_JavaLangString;
          ((mgv)this.jdField_b_of_type_JavaUtilArrayList.get(n)).jdField_a_of_type_Int = ((mgv)paramArrayList.get(localObject2[i1])).jdField_a_of_type_Int;
          ((mgv)paramArrayList.get(localObject2[i1])).jdField_a_of_type_JavaLangString = "";
          m = i1 + 1;
          break label533;
        }
        i1 += 1;
        break label511;
        i1 = this.jdField_b_of_type_JavaUtilArrayList.size();
        if (i1 < 3)
        {
          n = m;
          for (;;)
          {
            m = n;
            if (n < localObject2.length) {
              if (localObject2[n] >= 0) {
                break label734;
              }
            }
            for (m = n;; m = n + 1)
            {
              i1 += 1;
              break;
              label734:
              if (((mgv)paramArrayList.get(localObject2[n])).jdField_a_of_type_JavaLangString.equalsIgnoreCase("")) {
                break label822;
              }
              this.jdField_b_of_type_JavaUtilArrayList.add(new mgv(((mgv)paramArrayList.get(localObject2[n])).jdField_a_of_type_JavaLangString, ((mgv)paramArrayList.get(localObject2[n])).jdField_a_of_type_Int));
              ((mgv)paramArrayList.get(localObject2[n])).jdField_a_of_type_JavaLangString = "";
            }
            label822:
            n += 1;
          }
        }
        m = 0;
        paramArrayList = (ArrayList<mgv>)localObject1;
        localObject1 = paramArrayList;
        if (m < this.jdField_b_of_type_JavaUtilArrayList.size())
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_d_of_type_JavaLangString, 2, "speakingInfoList. uin = " + ((mgv)this.jdField_b_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_JavaLangString + ", audioEnergy = " + ((mgv)this.jdField_b_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_Int);
          }
          localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i3, ((mgv)this.jdField_b_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_JavaLangString, String.valueOf(locallfe.jdField_g_of_type_Long));
          localObject1 = localObject2;
          if (mry.a((String)localObject2) > 9) {
            localObject1 = mry.a((String)localObject2, 0, 9) + "...";
          }
          if (m < this.jdField_b_of_type_JavaUtilArrayList.size() - 1) {}
          for (paramArrayList = paramArrayList + (String)localObject1 + ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131695630);; paramArrayList = paramArrayList + (String)localObject1)
          {
            m += 1;
            break;
          }
          localObject1 = ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131695631);
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.c().size() != 0)
        {
          paramArrayList = (ArrayList<mgv>)localObject1;
          if (this.jdField_a_of_type_ComTencentAvVideoController.c().size() == 1)
          {
            paramArrayList = (ArrayList<mgv>)localObject1;
            if (((lcu)this.jdField_a_of_type_ComTencentAvVideoController.c().get(0)).jdField_a_of_type_Long != Long.parseLong(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) {}
          }
        }
        else
        {
          paramArrayList = "";
        }
        return paramArrayList;
        label1162:
        i1 = m;
        i2 = n;
      }
      label1171:
      m = 0;
    }
  }
  
  private void b(long paramLong, boolean paramBoolean, int paramInt)
  {
    int n = 0;
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
      m = 2131373784;
      localTextView = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(m);
      localObject = Long.toString(paramLong);
      m = 0;
      label89:
      if (m >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label461;
      }
      if (!((mgv)this.jdField_a_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_JavaLangString.equalsIgnoreCase((String)localObject)) {
        break label362;
      }
      if (!paramBoolean) {
        break label349;
      }
      ((mgv)this.jdField_a_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_Int = paramInt;
      if (paramInt < 10) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(m);
      }
    }
    label162:
    label461:
    for (int m = 1;; m = 0)
    {
      if ((paramBoolean) && (m == 0) && (paramInt > 10)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(new mgv((String)localObject, paramInt));
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
        m = 2131373439;
        break label66;
        label349:
        this.jdField_a_of_type_JavaUtilArrayList.remove(m);
        break label162;
        label362:
        m += 1;
        break label89;
        localObject = new ArrayList();
        paramInt = n;
        while (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          ((ArrayList)localObject).add(new mgv(((mgv)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString, ((mgv)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int));
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
      super.l(2131373465);
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
      }
    }
    do
    {
      return;
      super.k(2131373465);
    } while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
  }
  
  void A()
  {
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      return;
    }
    float f1 = ImmersiveUtils.a() - AIOUtils.dp2px(180.0F, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources());
    String str = a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_AndroidWidgetTextView, f1);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(str);
    this.jdField_c_of_type_AndroidWidgetTextView.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(str);
    this.jdField_d_of_type_AndroidWidgetTextView.setClickable(false);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  protected void A(long paramLong)
  {
    if (!VideoController.a()) {
      return;
    }
    lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
    locallfe.c(paramLong, false);
    if (locallfe.jdField_c_of_type_JavaUtilArrayList.size() == 0) {
      locallfe.a(-1L, "onUserScreenShareOpen", 3);
    }
    a(paramLong);
    a("onUserScreenShareClose", paramLong);
  }
  
  public void B()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_d_of_type_JavaLangString, 2, "cancelNotification");
    }
    if (this.jdField_a_of_type_Mtt != null) {
      this.jdField_a_of_type_Mtt.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentAvVideoController.s();
  }
  
  public void C()
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
    if (this.jdField_a_of_type_Mtt != null)
    {
      lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
      str1 = String.valueOf(locallfe.jdField_g_of_type_Long);
      str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(this.jdField_d_of_type_Int, str1, null);
      localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_d_of_type_Int, str1, null, true, true);
      m = 44;
      if (locallfe.m()) {
        if (locallfe.jdField_d_of_type_Int != 3) {
          break label205;
        }
      }
    }
    label205:
    for (int m = 62;; m = 63)
    {
      this.jdField_a_of_type_Mtt.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, str2, localBitmap, str1, m, this.jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
      this.jdField_a_of_type_ComTencentAvVideoController.r();
      return;
    }
  }
  
  protected int a()
  {
    return 2131559742;
  }
  
  public int a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "onApnChanged --> NetType = " + paramInt);
    }
    DoubleVideoCtrlUI.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt);
    if ((NetworkUtil.isWifiConnected((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean) && (this.r)) {
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
  
  protected String a(Context paramContext, String paramString, TextView paramTextView, float paramFloat)
  {
    return mvk.a(paramContext, paramString, paramTextView, paramFloat - paramTextView.getPaint().measureText("(100)"));
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
        int m = AIOUtils.dp2px(160.0F, this.jdField_a_of_type_AndroidContentResResources);
        localTextPaint = paramTextView.getPaint();
        f2 = m - localTextPaint.measureText(String.format("(%d)", new Object[] { Integer.valueOf(paramInt) })) - 4.0F * this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().density;
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
  
  ArrayList<lcu> a()
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
    if ((paramInt1 == paramInt2) || (this.r)) {}
    label95:
    label98:
    label230:
    do
    {
      return;
      boolean bool;
      int m;
      if (paramInt2 == 3)
      {
        bool = true;
        if (4 == this.jdField_a_of_type_ComTencentAvVideoController.h()) {
          break label225;
        }
        paramInt1 = 1;
        m = 1;
        if (m >= this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size()) {
          continue;
        }
        paramString = (lob)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(m);
        paramString.jdField_a_of_type_Boolean = bool;
        if ((paramInt1 != 0) && (!paramString.jdField_c_of_type_Boolean))
        {
          int n = this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_c_of_type_Long);
          if (n != -1) {
            ((lob)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(n)).jdField_c_of_type_Boolean = false;
          }
        }
        if ((paramInt2 != 3) || (paramInt1 == 0)) {
          break label230;
        }
      }
      for (paramString.jdField_c_of_type_Boolean = false;; paramString.jdField_c_of_type_Boolean = true)
      {
        m += 1;
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
      q(this.jdField_b_of_type_Long);
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
    this.jdField_b_of_type_Mcx.update(null, new Object[] { Integer.valueOf(104), this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList });
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
      if (this.m == 3) {
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
  
  void a(long paramLong, ArrayList<lcu> paramArrayList)
  {
    if (h()) {}
    int m;
    do
    {
      return;
      if (paramArrayList != null) {
        break;
      }
      m = 0;
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "doInternalUIFreash, gaFList[" + m + "], seq[" + paramLong + "]");
      }
    } while (this.jdField_a_of_type_AndroidContentResResources == null);
    if (m <= 1) {
      a_(paramLong, 2131695309);
    }
    for (;;)
    {
      this.i = m;
      if (this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI != null)
      {
        this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(paramArrayList);
        s();
      }
      ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramArrayList);
      e(paramLong, m);
      f(paramLong, m);
      return;
      m = paramArrayList.size();
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
  
  protected void a(Context paramContext, String paramString, TextView paramTextView, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramInt <= 0)) {
      return;
    }
    paramContext = new StringBuilder(a(paramContext, paramString, paramTextView, ImmersiveUtils.a() - AIOUtils.dp2px(180.0F, paramContext.getResources())));
    if (paramInt > 1) {
      paramContext.append("(").append(paramInt).append(")");
    }
    paramTextView.setText(paramContext.toString());
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
    //   6: invokespecial 733	com/tencent/av/ui/VideoControlUI:a	(Ljava/lang/String;ILjava/lang/String;I)V
    //   9: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +62 -> 74
    //   15: aload_0
    //   16: getfield 242	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   19: iconst_2
    //   20: new 244	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   27: ldc_w 735
    //   30: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_1
    //   34: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc_w 737
    //   40: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_2
    //   44: invokevirtual 254	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: ldc_w 739
    //   50: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload_3
    //   54: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc_w 741
    //   60: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: iload 4
    //   65: invokevirtual 254	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   68: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: aload_1
    //   75: ifnull +7 -> 82
    //   78: aload_3
    //   79: ifnonnull +4 -> 83
    //   82: return
    //   83: aload_0
    //   84: getfield 523	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:r	Z
    //   87: ifne -5 -> 82
    //   90: aload_3
    //   91: invokestatic 744	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   94: invokevirtual 747	java/lang/Long:longValue	()J
    //   97: lstore 6
    //   99: iload_2
    //   100: iconst_2
    //   101: if_icmpne +20 -> 121
    //   104: aload_0
    //   105: sipush 1036
    //   108: invokevirtual 749	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:i	(I)V
    //   111: aload_0
    //   112: getfield 288	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   115: sipush 1036
    //   118: invokestatic 752	mbf:a	(Lcom/tencent/av/app/VideoAppInterface;I)V
    //   121: aload_0
    //   122: getfield 201	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   125: invokevirtual 206	com/tencent/av/VideoController:a	()Llfe;
    //   128: aload_1
    //   129: invokestatic 744	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   132: invokevirtual 747	java/lang/Long:longValue	()J
    //   135: iload_2
    //   136: invokevirtual 755	lfe:a	(JI)I
    //   139: istore 5
    //   141: iload 5
    //   143: iconst_m1
    //   144: if_icmpeq -62 -> 82
    //   147: aload_0
    //   148: getfield 201	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   151: invokevirtual 206	com/tencent/av/VideoController:a	()Llfe;
    //   154: getfield 339	lfe:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   157: iload 5
    //   159: invokevirtual 259	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   162: checkcast 604	lob
    //   165: astore_3
    //   166: iconst_0
    //   167: istore_2
    //   168: iload_2
    //   169: aload_0
    //   170: getfield 201	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   173: invokevirtual 206	com/tencent/av/VideoController:a	()Llfe;
    //   176: getfield 339	lfe:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   179: invokevirtual 218	java/util/ArrayList:size	()I
    //   182: if_icmpge +371 -> 553
    //   185: aload_0
    //   186: getfield 201	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   189: invokevirtual 206	com/tencent/av/VideoController:a	()Llfe;
    //   192: getfield 339	lfe:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   195: iload_2
    //   196: invokevirtual 259	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   199: checkcast 604	lob
    //   202: astore 8
    //   204: lload 6
    //   206: aload 8
    //   208: getfield 756	lob:jdField_a_of_type_Long	J
    //   211: lcmp
    //   212: ifne +365 -> 577
    //   215: iload 4
    //   217: aload 8
    //   219: getfield 757	lob:jdField_a_of_type_Int	I
    //   222: if_icmpne +355 -> 577
    //   225: aload_3
    //   226: iconst_0
    //   227: putfield 605	lob:jdField_a_of_type_Boolean	Z
    //   230: aload_3
    //   231: getfield 756	lob:jdField_a_of_type_Long	J
    //   234: aload_0
    //   235: getfield 88	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_c_of_type_Long	J
    //   238: lcmp
    //   239: ifeq +32 -> 271
    //   242: aload 8
    //   244: getfield 756	lob:jdField_a_of_type_Long	J
    //   247: aload_0
    //   248: getfield 88	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_c_of_type_Long	J
    //   251: lcmp
    //   252: ifeq +19 -> 271
    //   255: iconst_4
    //   256: aload_0
    //   257: getfield 201	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   260: invokevirtual 602	com/tencent/av/VideoController:h	()I
    //   263: if_icmpeq +8 -> 271
    //   266: aload_3
    //   267: iconst_0
    //   268: putfield 606	lob:jdField_c_of_type_Boolean	Z
    //   271: aload 8
    //   273: iconst_1
    //   274: putfield 605	lob:jdField_a_of_type_Boolean	Z
    //   277: iconst_4
    //   278: aload_0
    //   279: getfield 201	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   282: invokevirtual 602	com/tencent/av/VideoController:h	()I
    //   285: if_icmpeq +55 -> 340
    //   288: aload 8
    //   290: getfield 606	lob:jdField_c_of_type_Boolean	Z
    //   293: ifne +47 -> 340
    //   296: aload_0
    //   297: getfield 201	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   300: invokevirtual 206	com/tencent/av/VideoController:a	()Llfe;
    //   303: aload_0
    //   304: getfield 88	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_c_of_type_Long	J
    //   307: invokevirtual 609	lfe:a	(J)I
    //   310: istore 4
    //   312: iload 4
    //   314: iconst_m1
    //   315: if_icmpeq +25 -> 340
    //   318: aload_0
    //   319: getfield 201	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   322: invokevirtual 206	com/tencent/av/VideoController:a	()Llfe;
    //   325: getfield 339	lfe:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   328: iload 4
    //   330: invokevirtual 259	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   333: checkcast 604	lob
    //   336: iconst_0
    //   337: putfield 606	lob:jdField_c_of_type_Boolean	Z
    //   340: aload 8
    //   342: iconst_1
    //   343: putfield 606	lob:jdField_c_of_type_Boolean	Z
    //   346: aload 8
    //   348: getfield 756	lob:jdField_a_of_type_Long	J
    //   351: aload_0
    //   352: getfield 88	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_c_of_type_Long	J
    //   355: lcmp
    //   356: ifne +38 -> 394
    //   359: aload_0
    //   360: getfield 84	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_e_of_type_Int	I
    //   363: iconst_2
    //   364: if_icmpne +30 -> 394
    //   367: aconst_null
    //   368: ldc_w 759
    //   371: ldc 150
    //   373: ldc 150
    //   375: ldc_w 761
    //   378: ldc_w 761
    //   381: iconst_0
    //   382: iconst_0
    //   383: ldc 150
    //   385: ldc 150
    //   387: ldc 150
    //   389: ldc 150
    //   391: invokestatic 766	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   394: aload 8
    //   396: getfield 767	lob:jdField_b_of_type_Boolean	Z
    //   399: ifne +27 -> 426
    //   402: aload_0
    //   403: getfield 201	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   406: invokevirtual 602	com/tencent/av/VideoController:h	()I
    //   409: iconst_4
    //   410: if_icmpeq +16 -> 426
    //   413: aload_0
    //   414: getfield 201	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   417: invokevirtual 206	com/tencent/av/VideoController:a	()Llfe;
    //   420: getfield 770	lfe:D	I
    //   423: invokestatic 774	msa:b	(I)V
    //   426: aload_0
    //   427: getfield 201	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   430: invokevirtual 206	com/tencent/av/VideoController:a	()Llfe;
    //   433: getfield 339	lfe:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   436: iload 5
    //   438: aload 8
    //   440: invokevirtual 778	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   443: pop
    //   444: aload_0
    //   445: getfield 201	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   448: invokevirtual 206	com/tencent/av/VideoController:a	()Llfe;
    //   451: getfield 339	lfe:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   454: iload_2
    //   455: aload_3
    //   456: invokevirtual 778	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   459: pop
    //   460: aload_0
    //   461: getfield 201	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   464: invokevirtual 206	com/tencent/av/VideoController:a	()Llfe;
    //   467: getfield 780	lfe:jdField_d_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   470: astore_1
    //   471: aload_1
    //   472: monitorenter
    //   473: aload_0
    //   474: getfield 201	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   477: invokevirtual 206	com/tencent/av/VideoController:a	()Llfe;
    //   480: getfield 780	lfe:jdField_d_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   483: iload 5
    //   485: aload 8
    //   487: invokevirtual 778	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   490: pop
    //   491: aload_0
    //   492: getfield 201	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   495: invokevirtual 206	com/tencent/av/VideoController:a	()Llfe;
    //   498: getfield 780	lfe:jdField_d_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   501: iload_2
    //   502: aload_3
    //   503: invokevirtual 778	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   506: pop
    //   507: aload_0
    //   508: getfield 201	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   511: invokevirtual 206	com/tencent/av/VideoController:a	()Llfe;
    //   514: invokevirtual 782	lfe:c	()V
    //   517: aload_1
    //   518: monitorexit
    //   519: aload_0
    //   520: getfield 221	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   523: invokevirtual 227	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   526: checkcast 355	com/tencent/av/ui/AVActivity
    //   529: getfield 358	com/tencent/av/ui/AVActivity:jdField_a_of_type_ComTencentAvUiVideoLayerUI	Lcom/tencent/av/ui/VideoLayerUI;
    //   532: aload 8
    //   534: getfield 756	lob:jdField_a_of_type_Long	J
    //   537: aload 8
    //   539: getfield 757	lob:jdField_a_of_type_Int	I
    //   542: aload_3
    //   543: getfield 756	lob:jdField_a_of_type_Long	J
    //   546: aload_3
    //   547: getfield 757	lob:jdField_a_of_type_Int	I
    //   550: invokevirtual 785	com/tencent/av/ui/VideoLayerUI:a	(JIJI)V
    //   553: aload_0
    //   554: invokevirtual 525	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:e	()Z
    //   557: pop
    //   558: return
    //   559: astore_1
    //   560: aload_0
    //   561: getfield 242	com/tencent/av/ui/MultiVideoCtrlLayerUIBase:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   564: iconst_2
    //   565: ldc_w 787
    //   568: invokestatic 720	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   139	345	5	m	int
    //   97	108	6	l1	long
    //   202	336	8	locallob	lob
    // Exception table:
    //   from	to	target	type
    //   90	99	559	java/lang/Exception
    //   473	519	572	finally
    //   573	575	572	finally
  }
  
  public void a(String paramString, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    lfe locallfe;
    do
    {
      return;
      locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
    } while (locallfe == null);
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "switchUIMode[" + paramString + "], SessionType[" + locallfe.jdField_d_of_type_Int + "], seq[" + paramLong + "]");
    }
    if (locallfe.jdField_d_of_type_Int == 4)
    {
      this.jdField_a_of_type_Muk.c(false);
      this.jdField_a_of_type_Muk.b(false);
      this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setVisibility(8);
      ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoLayerUI.i(this.jdField_a_of_type_ComTencentAvVideoController.a().N);
      ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.jdField_a_of_type_ComTencentAvVideoController.a());
      y();
      if (!locallfe.jdField_j_of_type_Boolean) {
        break label405;
      }
    }
    label405:
    for (int m = 2;; m = 1)
    {
      a(true, m);
      if (this.jdField_a_of_type_Muy != null) {
        this.jdField_a_of_type_Muy.a(true);
      }
      a(true);
      b(true);
      h(paramLong, 0);
      g(paramLong, 8);
      j(paramLong, 8);
      for (boolean bool = true;; bool = false)
      {
        a(Boolean.valueOf(bool));
        i(paramLong, 16777215);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(102) });
        return;
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        o(true);
        this.jdField_a_of_type_Muk.c(true);
        this.jdField_a_of_type_Muk.b(true);
        this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setVisibility(0);
        paramString = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (!paramString.isFinishing()) {
          paramString.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i(-1);
        }
        y();
        a(false, 1);
        if (this.jdField_a_of_type_Muy != null) {
          this.jdField_a_of_type_Muy.a(false);
        }
        a(false);
        b(false);
        h(paramLong, 8);
        g(paramLong, 0);
        j(paramLong, 0);
        a(paramLong, 0.0F);
      }
    }
  }
  
  void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
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
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
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
    this.r = paramBoolean1;
    this.jdField_a_of_type_ComTencentAvVideoController.a().b(paramBoolean1);
    if (this.jdField_a_of_type_Max != null) {
      this.jdField_a_of_type_Max.a(paramBoolean1, new mgu(this));
    }
    if (paramBoolean1)
    {
      msa.d(NetworkUtil.isWifiConnected((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()), this.jdField_a_of_type_ComTencentAvVideoController.a().D);
      L();
      if (paramBoolean2) {
        mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3013);
      }
    }
    for (;;)
    {
      if (paramBoolean3) {
        b(AudioHelper.b(), this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList);
      }
      return;
      mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3013);
      continue;
      mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3013);
      mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1030);
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
    lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "checkRemoteVideo, displayViewList[" + locallfe.jdField_c_of_type_JavaUtilArrayList.size() + "], seq[" + paramLong + "]");
    }
    if (locallfe.jdField_c_of_type_JavaUtilArrayList.size() == 0)
    {
      a(paramLong, "checkRemoteVideo");
      a(false, false, false);
      return false;
    }
    if ((locallfe.jdField_c_of_type_JavaUtilArrayList.size() == 1) && (((lob)locallfe.jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long == this.jdField_c_of_type_Long))
    {
      a(false, false, false);
      e("checkRemoteVideo");
      return false;
    }
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    int m = 2;
    lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
    boolean bool2 = mtr.i();
    boolean bool1;
    if ((!locallfe.ac) && (!locallfe.ad))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "checkBlockOpenMicOrCamera, isAllowedControlMicAfterBeMuted[" + bool2 + "], isNormalUser[" + bool1 + "], isRoomMicOff[" + locallfe.W + "], micAuthByAdmin[" + locallfe.H + "], openMic[" + paramBoolean + "]");
      }
      if ((!bool1) || (!locallfe.W) || (locallfe.H == 0)) {
        break label222;
      }
      if (!paramBoolean) {
        break label215;
      }
    }
    label215:
    for (int n = 2131695294;; n = 2131695460)
    {
      mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1033, this.jdField_a_of_type_AndroidContentResResources.getString(n));
      if (paramBoolean) {
        m = 1;
      }
      bdla.b(null, "dc00898", "", "", "0X800AB7F", "0X800AB7F", m, 0, "1", "", "", "");
      return true;
      bool1 = false;
      break;
    }
    label222:
    if ((!bool2) && (bool1) && (locallfe.H == 1))
    {
      if (paramBoolean) {}
      for (n = 2131695297;; n = 2131695461)
      {
        mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1033, this.jdField_a_of_type_AndroidContentResResources.getString(n));
        if (paramBoolean) {
          m = 1;
        }
        bdla.b(null, "CliOper", "", "", "0X800AB7F", "0X800AB7F", m, 0, "2", "", "", "");
        return true;
      }
    }
    return false;
  }
  
  void a_(long paramLong, int paramInt)
  {
    this.jdField_j_of_type_Int = paramInt;
    if (this.jdField_j_of_type_Int == 2131695252) {
      A();
    }
    super.d(paramLong, this.jdField_a_of_type_AndroidContentResResources.getString(paramInt));
  }
  
  void b()
  {
    long l1 = AudioHelper.b();
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "initUI, SessionType[" + ((lfe)localObject1).jdField_d_of_type_Int + "], switchToGAudioMode[" + ((lfe)localObject1).G + "], localMute[" + ((lfe)localObject1).jdField_g_of_type_Boolean + "], seq[" + l1 + "]");
    super.b();
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      p();
      this.jdField_a_of_type_ComTencentAvUiQavPanel.e();
      localObject2 = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject2 != null)
      {
        this.jdField_a_of_type_Muy = muy.a();
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_Muy);
        this.jdField_a_of_type_Muk = muk.a(this.jdField_a_of_type_Muk, (Activity)localObject2, this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_Muy);
        this.jdField_a_of_type_Muk.a(true);
        this.jdField_a_of_type_Muy.a();
      }
    }
    this.jdField_e_of_type_AndroidWidgetTextView.post(this.jdField_g_of_type_JavaLangRunnable);
    k(l1, 8);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373507));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370849));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376675));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363055));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363061));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373508));
    i(l1, 16777215);
    Object localObject2 = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_d_of_type_JavaLangString, 2, "initUI-->can not get AVActivity");
      }
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373762));
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI = ((MultiMembersAudioUI)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373657));
    this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI = ((MultiMembersVideoUI)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373658));
    int m = ImmersiveUtils.b();
    if (ImmersiveUtils.isSupporImmersive() != 1) {
      m -= ImmersiveUtils.getStatusBarHeight((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    }
    for (;;)
    {
      m = (int)(m * 58 / 1000.0F);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.getLayoutParams();
      localMarginLayoutParams.topMargin = m;
      this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setLayoutParams(localMarginLayoutParams);
      this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI.setVisibility(8);
      r();
      msi.a(((AVActivity)localObject2).getApplicationContext());
      if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean)
      {
        this.jdField_a_of_type_Muk.b(true);
        this.jdField_a_of_type_Muk.c(true);
        if ((this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) && (!this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.b())) {
          this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.i();
        }
      }
      if ((((lfe)localObject1).b()) && (((lfe)localObject1).jdField_g_of_type_Boolean))
      {
        m = this.jdField_a_of_type_ComTencentAvVideoController.f();
        this.jdField_a_of_type_ComTencentAvVideoController.a("MultiVideoCtrlLayerUIBase.initUI", ((lfe)localObject1).jdField_g_of_type_Long, false, true, -1);
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.a("MultiVideoCtrlLayerUIBase.initUI", m, this.jdField_a_of_type_ComTencentAvVideoController.f(), false);
        }
        super.k(2131373465);
      }
      this.jdField_a_of_type_Muy.a();
      if (this.jdField_f_of_type_JavaLangRunnable == null) {
        this.jdField_f_of_type_JavaLangRunnable = new MultiVideoCtrlLayerUIBase.RefreshDisplayNameRunnable(this);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.jdField_f_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Mif = new mif((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentAvVideoController, 3, this.jdField_a_of_type_ComTencentAvUiQavPanel, this.jdField_d_of_type_AndroidWidgetRelativeLayout, null, null, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373637), null);
      this.jdField_a_of_type_Mif.a();
      if (((lfe)localObject1).jdField_d_of_type_Int == 4) {
        a("initUI", l1);
      }
      ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.h());
      if (AudioHelper.a(0) == 1) {
        this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setBackgroundColor(531496751);
      }
      localObject1 = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373471);
      ((ImageView)localObject1).setOnClickListener(new mgq(this, (ImageView)localObject1));
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
    p(paramLong);
    r(paramLong);
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
    this.t = paramInt;
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
  
  public void b(long paramLong, ArrayList<lob> paramArrayList)
  {
    int m = 0;
    for (;;)
    {
      if (m < paramArrayList.size())
      {
        lob locallob = (lob)paramArrayList.get(m);
        if ((locallob.jdField_a_of_type_Long == this.jdField_c_of_type_Long) && (locallob.jdField_a_of_type_Int == 1) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean)) {
          paramArrayList.remove(m);
        }
      }
      else
      {
        this.jdField_b_of_type_Mcx.update(null, new Object[] { Integer.valueOf(103), paramArrayList, Long.valueOf(paramLong) });
        return;
      }
      m += 1;
    }
  }
  
  void b(Intent paramIntent)
  {
    try
    {
      this.jdField_c_of_type_Long = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
      lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
      this.jdField_d_of_type_Int = locallfe.jdField_j_of_type_Int;
      if (this.jdField_d_of_type_Int == 3000)
      {
        this.jdField_e_of_type_Int = 2;
        locallfe.F = this.jdField_e_of_type_Int;
        int m = locallfe.E;
        this.jdField_a_of_type_Long = locallfe.jdField_g_of_type_Long;
        this.jdField_c_of_type_Int = locallfe.E;
        this.q = false;
        if (paramIntent != null) {
          this.jdField_e_of_type_Boolean = paramIntent.getBooleanExtra("isVideo", false);
        }
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "processIntentData, mUinType[" + this.jdField_d_of_type_Int + "], mRelationType[" + this.jdField_e_of_type_Int + "], mIntentRelationId[" + this.jdField_a_of_type_Long + "], mStatusType[" + this.jdField_c_of_type_Int + "], mStatusType[" + m + "->" + this.jdField_c_of_type_Int + "], getSimpleDataList[" + this.jdField_a_of_type_ComTencentAvVideoController.e() + "], getGAudioList[" + this.jdField_a_of_type_ComTencentAvVideoController.c() + "]");
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
        localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373514);
        localObject = (AVActivity)localObject;
        if (!paramBoolean) {
          break;
        }
        localRelativeLayout.setBackgroundColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131167296));
      } while (localObject == null);
      ((AVActivity)localObject).b(false);
      ((AVActivity)localObject).f(false);
      ((AVActivity)localObject).c(true);
      return;
      localRelativeLayout.setBackgroundColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131166046));
    } while (localObject == null);
    ((AVActivity)localObject).b(true);
    ((AVActivity)localObject).f(true);
    ((AVActivity)localObject).c(false);
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onPhoneCalling, isSelf[" + paramBoolean1 + "], seq[" + l1 + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    while (!paramBoolean1) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController.a().P)) {
      this.jdField_a_of_type_Muy.a(muy.jdField_b_of_type_Int);
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
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "showToolBars");
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().s())
    {
      e(paramInt);
      D(l1);
    }
  }
  
  public void c(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 2, "onStop, seq[" + paramLong + "]");
    }
    super.c(paramLong);
    C();
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void c(long paramLong, int paramInt)
  {
    if ((paramInt == 2) || (paramInt == 1))
    {
      t(paramLong);
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList, 1, false);
    }
    super.c(paramLong, paramInt);
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
      L();
    }
    a(paramIntent);
    if (bool) {
      this.jdField_a_of_type_Muy.c();
    }
    a();
  }
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      super.l(2131373465);
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
      mbf.a(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 9, 3000L);
      break;
      super.k(2131373465);
      mbf.a(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false);
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373465, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131692734));
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
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_b_of_type_Lee);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Les);
    ((BaseActivity)localObject).registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("tencent.video.q2v.GvideoMemInviteUpdate"));
    this.jdField_a_of_type_Mtt = mtt.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    localObject = a();
    b((Intent)localObject);
    a((Intent)localObject);
    this.jdField_a_of_type_ComTencentAvVideoController.p();
  }
  
  public void d(int paramInt) {}
  
  public void d(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "OnDestroy, seq[" + paramLong + "]");
    }
    this.jdField_a_of_type_ComTencentAvVideoController.q();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_b_of_type_Lee);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Les);
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
    F();
    mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1030);
    mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036);
    mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1037);
    mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3013);
    mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1034);
    mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1035);
    this.jdField_a_of_type_Muk.a(false);
    this.jdField_a_of_type_Muk.b(false);
    this.jdField_a_of_type_Muk.c(false);
    this.jdField_a_of_type_Muk = null;
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI = null;
    this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.i = -1;
    this.jdField_j_of_type_Int = -1;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    }
    if (this.jdField_a_of_type_Bkxc != null)
    {
      this.jdField_a_of_type_Bkxc.a(paramLong);
      this.jdField_a_of_type_Bkxc = null;
    }
    if (this.jdField_a_of_type_Mif != null)
    {
      this.jdField_a_of_type_Mif.b();
      this.jdField_a_of_type_Mif = null;
    }
    super.d(paramLong);
  }
  
  void d(long paramLong, View paramView)
  {
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_Mute, micPermission[" + this.jdField_a_of_type_ComTencentAvVideoController.a().p + "], seq[" + paramLong + "]");
    if (a(paramLong, "android.permission.RECORD_AUDIO", paramView)) {
      u(paramLong);
    }
    super.D(paramLong);
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
      B();
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
    if (paramInt <= 1)
    {
      String str = this.jdField_a_of_type_AndroidContentResResources.getString(2131695309);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(str);
    }
    for (boolean bool = false;; bool = true)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setClickable(bool);
      this.jdField_a_of_type_AndroidWidgetImageView.setClickable(bool);
      if (bool) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_AndroidWidgetTextView, paramInt);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  void e(long paramLong, View paramView)
  {
    lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick_CAMERA, sessionInfo[" + locallfe + "], mHasLauncnRequestFromCameraButton[" + this.q + "], seq[" + paramLong + "]");
    if (a(paramLong, "android.permission.CAMERA", paramView))
    {
      if (locallfe.jdField_j_of_type_Boolean) {
        break label321;
      }
      if (!f()) {
        break label94;
      }
      label94:
      while (a(false)) {
        return;
      }
      msa.f(true);
      if (NetworkUtil.isWifiConnected((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) {
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
    for (int m = 0;; m = 1)
    {
      if (m != 0)
      {
        paramView = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramView == null) {
          break;
        }
        bhdj.a(paramView, 230, this.jdField_a_of_type_AndroidContentResResources.getString(2131695436), this.jdField_a_of_type_AndroidContentResResources.getString(2131695433), 2131695168, 2131695180, new mgn(this, paramLong), new mgo(this)).show();
      }
      for (m = 0;; m = 1)
      {
        if (m != 0)
        {
          if ((locallfe.b() != -1) || (NetworkUtil.isWifiConnected((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()))) {
            break label278;
          }
          s(paramLong);
        }
        for (;;)
        {
          l(paramLong, 2131695080);
          return;
          if (d())
          {
            this.q = true;
            i(paramLong, 16777215);
          }
          else if (QLog.isColorLevel())
          {
            QLog.e(this.jdField_d_of_type_JavaLangString, 2, "PressCameraBtnRunnable-->go on stage fail,can not find the session");
            continue;
            t(paramLong);
            this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Long, locallfe.jdField_c_of_type_JavaUtilArrayList, locallfe.jdField_d_of_type_JavaUtilArrayList, 1, false);
          }
        }
      }
    }
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
    long l1 = AudioHelper.b();
    if (this.jdField_a_of_type_Bkxc == null)
    {
      this.jdField_a_of_type_Bkxc = new bkxc((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), null);
      if (!paramBoolean) {
        break label97;
      }
      if (msi.a("qav_gaudio_muted.mp3")) {
        this.jdField_a_of_type_Bkxc.a(l1, 2, 0, null, msi.a() + "qav_gaudio_muted.mp3", false, 1, false, true, 0);
      }
    }
    label97:
    while (!msi.a("qav_gaudio_cancel_muted.mp3"))
    {
      return;
      this.jdField_a_of_type_Bkxc.a(l1);
      break;
    }
    this.jdField_a_of_type_Bkxc.a(l1, 2, 0, null, msi.a() + "qav_gaudio_cancel_muted.mp3", false, 1, false, true, 0);
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
      int n = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size();
      int m = n;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean) {
        m = n - 1;
      }
      if (m <= 0)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e(this.jdField_d_of_type_JavaLangString, 2, "startRecvAllVideo --> There is no video need request");
        return false;
      }
      m = lsq.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp());
      if (m == 1)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e(this.jdField_d_of_type_JavaLangString, 2, "startRecvAllVideo --> This version is not supportsharpvideo or opengl.  GlVersion = " + m);
        return false;
      }
      bdla.b(null, "CliOper", "", "", "0X8005617", "0X8005617", 0, 0, "", "", "", "");
      m = this.jdField_a_of_type_ComTencentAvVideoController.h();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "startRecvAllVideo --> Ability = " + m);
      }
      if (m != 4)
      {
        if (this.jdField_e_of_type_Int == 2) {
          bdla.b(null, "CliOper", "", "", "0X8004CF6", "0X8004CF6", 0, 0, "", "", "", "");
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() > 1) {
          mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3007);
        }
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().e.clear();
      long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      m = 0;
      while (m < this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size())
      {
        localObject = (lob)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(m);
        if ((((lob)localObject).jdField_c_of_type_Boolean) && (l1 != ((lob)localObject).jdField_a_of_type_Long)) {
          this.jdField_a_of_type_ComTencentAvVideoController.a().e.add(localObject);
        }
        m += 1;
      }
      a(false, false, false);
      F();
      mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036);
      mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1037);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().N == 3) {}
      for (bool1 = bool2;; bool1 = false) {
        return this.jdField_a_of_type_ComTencentAvVideoController.a(bool1);
      }
    }
  }
  
  void f(long paramLong, int paramInt)
  {
    if (paramInt <= 1) {}
    for (boolean bool = false;; bool = true)
    {
      a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_AndroidWidgetTextView, paramInt);
      if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.isShown()))
      {
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setClickable(bool);
      this.jdField_b_of_type_AndroidWidgetImageView.setClickable(bool);
      if (!bool)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
  }
  
  boolean f()
  {
    if ((!llq.e()) || (lsq.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) == 1))
    {
      DoubleVideoCtrlUI.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      return false;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.b() >= jdField_b_of_type_Int)
    {
      mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1031);
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
    lob locallob;
    if (paramInt == 3)
    {
      if (4 == this.jdField_a_of_type_ComTencentAvVideoController.h())
      {
        localIterator = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          locallob = (lob)localIterator.next();
          if (!locallob.jdField_a_of_type_Boolean) {
            locallob.jdField_c_of_type_Boolean = true;
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() > 0) {
        ((lob)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_Boolean = true;
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
          ((lob)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_d_of_type_JavaLangString, 2, "MultiVideoCtrlLayerUIBase onLayoutModeChange --> displayList  not has big one");
          }
        }
        if (4 == this.jdField_a_of_type_ComTencentAvVideoController.h())
        {
          localIterator = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext())
          {
            locallob = (lob)localIterator.next();
            if (!locallob.jdField_a_of_type_Boolean) {
              locallob.jdField_c_of_type_Boolean = true;
            }
          }
        }
        else if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() > 0)
        {
          ((lob)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_Boolean = true;
        }
      }
    }
  }
  
  void g(long paramLong, int paramInt)
  {
    if (this.jdField_d_of_type_AndroidWidgetTextView != null)
    {
      if ((QLog.isDevelopLevel()) || (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() != paramInt)) {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "setVisibility_AudioMemberInfoText, visibility[" + this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() + "->" + paramInt + "], seq[" + paramLong + "]");
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(paramInt);
      CharSequence localCharSequence = this.jdField_d_of_type_AndroidWidgetTextView.getText();
      if ((TextUtils.equals(this.jdField_a_of_type_AndroidContentResResources.getString(2131695309), localCharSequence)) || (this.i <= 1)) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(paramInt);
  }
  
  protected boolean g()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return false;
    }
    lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
    boolean bool2 = mtr.i();
    if ((!locallfe.ac) && (!locallfe.ad)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "canStopMuteStatus, isAllowedControlMicAfterBeMuted[" + bool2 + "], isNormalUser[" + bool1 + "], isRoomMicOff[" + locallfe.W + "], micAuthByAdmin[" + locallfe.H + "], mIsPhoneCalling[" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Boolean + "]");
      }
      if (((bool1) && (locallfe.W) && (locallfe.H != 0)) || ((!bool2) && (bool1) && (locallfe.H == 1)) || (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_Boolean)) {
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
      } while (lsq.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) != 1);
      mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1012, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131719967));
      bdla.b(null, "CliOper", "", "", "0X8004E94", "0X8004E94", 0, 0, "", "", "", "");
      bdla.b(null, "CliOper", "", "", "0X8005618", "0X8005618", 0, 0, "", "", "", "");
    } while (!QLog.isColorLevel());
    QLog.e(this.jdField_d_of_type_JavaLangString, 2, "startRecvAllVideo-->GLVersion not support");
  }
  
  void h(long paramLong, int paramInt)
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      if ((QLog.isDevelopLevel()) || (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != paramInt)) {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "setVisibility_VideoMemberInfoText, visibility[" + this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() + "->" + paramInt + "], seq[" + paramLong + "]");
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(paramInt);
      CharSequence localCharSequence = this.jdField_c_of_type_AndroidWidgetTextView.getText();
      if (TextUtils.equals(this.jdField_a_of_type_AndroidContentResResources.getString(2131695309), localCharSequence)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(paramInt);
  }
  
  public void j(long paramLong) {}
  
  public void k(long paramLong) {}
  
  public void n(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "OnPause, seq[" + paramLong + "]");
    }
    super.n(paramLong);
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "OnPause Error : VideoController is null");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().ao = true;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b("MultiVideoCtrlLayerUIBase");
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      if (((!lzr.f()) || ((!NetworkUtil.isWifiConnected((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().aq))) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean)) {
        t(paramLong);
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
  
  protected abstract void p();
  
  void p(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean))
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.h())
      {
        super.k(2131373465);
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.b(this.jdField_a_of_type_ComTencentAvVideoController.h());
        }
      }
      this.jdField_a_of_type_ComTencentAvVideoController.o();
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int != 9) {
        break label113;
      }
      e(paramLong, true);
      a_(paramLong, 2131695309);
    }
    for (;;)
    {
      B(paramLong);
      this.jdField_a_of_type_Muk.c(true);
      this.jdField_a_of_type_Muk.b(true);
      return;
      label113:
      e(paramLong, false);
      d(paramLong, null);
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
  
  void q(long paramLong)
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
      this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setOnItemClickListener(this.jdField_a_of_type_Msy);
      b(l2, "initViewList");
      return;
    }
  }
  
  public void r(long paramLong)
  {
    if (h()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373465, true);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131373465, true);
      if (!this.jdField_a_of_type_ComTencentAvVideoController.h()) {
        break label110;
      }
      k(2131373465);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(this.jdField_a_of_type_ComTencentAvVideoController.h());
      y();
      long l1 = this.jdField_b_of_type_Long;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_d_of_type_Int, String.valueOf(l1));
      i(paramLong, 16777215);
      B(paramLong);
      return;
      label110:
      l(2131373465);
    }
  }
  
  public void s()
  {
    int n = 0;
    int i1 = 0;
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
        m = 1;
        localObject1 = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373439);
        localObject2 = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373784);
        localImageView = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373471);
        if (m == 0) {
          break label386;
        }
        ((TextView)localObject1).setVisibility(8);
        if ((!jdField_a_of_type_Boolean) && (!this.jdField_f_of_type_Boolean))
        {
          QLog.d(this.jdField_d_of_type_JavaLangString, 2, "refreshSpokesmanInfoUI video. txt = " + this.jdField_c_of_type_JavaLangString);
          if (!this.jdField_h_of_type_Boolean) {
            break label346;
          }
          n = 71;
          m = n;
          if (ImmersiveUtils.isSupporImmersive() != 1) {
            m = n - ImmersiveUtils.getStatusBarHeight((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
          }
          n = m;
          if (lch.jdField_c_of_type_Boolean)
          {
            if (!this.jdField_h_of_type_Boolean) {
              break label352;
            }
            n = m + 5;
          }
          localObject1 = (RelativeLayout.LayoutParams)((TextView)localObject2).getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)mvk.a(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), n));
          ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          ((TextView)localObject2).setText(this.jdField_c_of_type_JavaLangString);
          if (this.jdField_c_of_type_JavaLangString.length() <= 0) {
            break label360;
          }
          m = 0;
          ((TextView)localObject2).setVisibility(m);
          if (this.jdField_c_of_type_JavaLangString.length() <= 0) {
            break label366;
          }
          m = i1;
          localImageView.setVisibility(m);
        }
        localObject1 = a();
      } while ((localObject1 == null) || (((AVActivity)localObject1).jdField_a_of_type_ComTencentAvUiVideoLayerUI == null));
      if (this.jdField_h_of_type_Boolean)
      {
        m = 115;
        n = m;
        if (lch.jdField_c_of_type_Boolean) {
          if (!this.jdField_h_of_type_Boolean) {
            break label378;
          }
        }
      }
      for (n = m + 5;; n = m + 25)
      {
        ((AVActivity)localObject1).jdField_a_of_type_ComTencentAvUiVideoLayerUI.p(n);
        return;
        m = 0;
        break;
        n = 21;
        break label153;
        n = m + 25;
        break label197;
        m = 8;
        break label259;
        m = 8;
        break label277;
        m = 65;
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
    if (((localObject2 != null) && (((AVActivity)localObject2).jdField_a_of_type_Mnm != null) && (((AVActivity)localObject2).jdField_a_of_type_Mnm.b())) || (this.jdField_a_of_type_ComTencentAvVideoController.c().size() <= 8))
    {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "refreshSpokesmanInfoUI audio. txt = " + this.jdField_c_of_type_JavaLangString + ", isSoftKeyboardShown = " + ((AVActivity)localObject2).jdField_a_of_type_Mnm.b() + ", member cnt = " + this.jdField_a_of_type_ComTencentAvVideoController.c().size());
      ((TextView)localObject1).setVisibility(8);
      label534:
      if (((TextView)localObject1).getVisibility() == 0) {
        this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373637).setVisibility(8);
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
    for (int m = n;; m = 8)
    {
      ((TextView)localObject1).setVisibility(m);
      break label534;
      break;
    }
  }
  
  public void s(long paramLong)
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
    for (int m = 2131695448;; m = 2131695449)
    {
      bhdj.a(localContext, 230, null, this.jdField_a_of_type_AndroidContentResResources.getString(m), 2131695168, 2131695180, new mgs(this, paramLong), new mgt(this)).show();
      return;
    }
  }
  
  public void t(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "goOffStage, seq[" + paramLong + "]");
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_b_of_type_Mcx == null) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "goOffStage --> Error");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.u();
    this.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, "goOffStage", false, false);
    this.jdField_b_of_type_Mcx.update(null, new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
    b(2131373767, 8);
    AVActivity localAVActivity = a();
    if (localAVActivity != null) {
      localAVActivity.a(false);
    }
    a("goOffStage", paramLong);
  }
  
  void u(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentAvUiQavPanel.a()) && (!this.jdField_a_of_type_ComTencentAvUiQavPanel.b()))
    {
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "intercept doMute operation");
      return;
    }
    boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.h();
    if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean) {}
    for (long l1 = this.jdField_b_of_type_Long;; l1 = this.jdField_a_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "doMute, relationId[" + l1 + "], mute[" + bool + "], seq[" + paramLong + "]");
      }
      if (!bool) {
        break label275;
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
      msa.a(true, 1);
    }
    int m;
    for (;;)
    {
      q(true);
      m = this.jdField_a_of_type_ComTencentAvVideoController.f();
      this.jdField_a_of_type_ComTencentAvVideoController.a("MultiVideoCtrlLayerUIBase.doMute.1", l1, true, true, -1);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a("MultiVideoCtrlLayerUIBase.doMute.1", m, this.jdField_a_of_type_ComTencentAvVideoController.f(), false);
      super.l(2131373465);
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
      return;
      msa.a(true, 10);
    }
    label275:
    if (this.jdField_e_of_type_Int == 2) {
      msa.a(false, 1);
    }
    for (;;)
    {
      q(false);
      m = this.jdField_a_of_type_ComTencentAvVideoController.f();
      this.jdField_a_of_type_ComTencentAvVideoController.a("MultiVideoCtrlLayerUIBase.doMute.2", l1, false, true, -1);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a("MultiVideoCtrlLayerUIBase.doMute.2", m, this.jdField_a_of_type_ComTencentAvVideoController.f(), false);
      super.k(2131373465);
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
      return;
      msa.a(false, 10);
    }
  }
  
  void v()
  {
    long l1 = AudioHelper.b();
    boolean bool;
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("startOrResumeRemoteOrLocalVideo, seq[").append(l1).append("], mVideoController[");
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
    int n = this.jdField_a_of_type_ComTencentAvVideoController.b();
    int i1 = this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_c_of_type_Long, 1);
    int m;
    if (i1 != -1)
    {
      m = 1;
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "startOrResumeRemoteOrLocalVideo, onStageNum[" + n + "], index[" + i1 + "]");
      }
      if ((!NetworkUtil.isWifiConnected((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().aq)) {
        break label389;
      }
      if (m != 0)
      {
        if (n >= jdField_b_of_type_Int) {
          break label341;
        }
        if (!d()) {
          break label281;
        }
        i(l1, 16777215);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() <= 0) {
        break label384;
      }
      e();
      return;
      m = 0;
      break;
      label281:
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_d_of_type_JavaLangString, 2, "startOrResumeRemoteOrLocalVideo, Go on Stage Failed");
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList, 1, false);
      this.jdField_a_of_type_ComTencentAvVideoController.t();
      continue;
      label341:
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList, 1, false);
      this.jdField_a_of_type_ComTencentAvVideoController.t();
    }
    label384:
    L();
    return;
    label389:
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "startOrResumeRemoteOrLocalVideo --> is not connect wifi");
    }
    if (m != 0)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList, 1, false);
      this.jdField_a_of_type_ComTencentAvVideoController.t();
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() > 0)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(l1, "startOrResumeRemoteOrLocalVideo", true, true);
      a("startOrResumeRemoteOrLocalVideo", l1);
      if (!NetworkUtil.isNetworkAvailable((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()))
      {
        DoubleVideoCtrlUI.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0);
        return;
      }
      a(true, true, true);
      return;
    }
    L();
  }
  
  public void v(long paramLong)
  {
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "go on stage failed, info[" + paramLong + "]");
    }
    b(2131373767, 8);
    AVActivity localAVActivity = a();
    if (localAVActivity != null) {
      localAVActivity.a(false);
    }
    i(l1, 16777215);
    if (paramLong == 7L) {
      mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1029);
    }
    for (;;)
    {
      if (this.jdField_e_of_type_Int == 2) {
        bdla.b(null, "CliOper", "", "", "0X800441E", "0X800441E", 0, 0, "", "", "", "");
      }
      return;
      if (paramLong == 8L) {
        mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1033, this.jdField_a_of_type_AndroidContentResResources.getString(2131695460));
      } else {
        mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1028);
      }
    }
  }
  
  void w()
  {
    F();
    mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036);
    mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1037);
    mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1030);
    this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_c_of_type_Long, true, true);
    a(true, false, true);
  }
  
  void w(long paramLong)
  {
    QLog.d(this.jdField_d_of_type_JavaLangString, 1, "avideo onClick QavPanel.ViewID.SWITCH_DISPLAY_MODE");
    int n;
    int m;
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() > 0))
    {
      AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      n = localAVActivity.c();
      if (3 != n) {
        break label140;
      }
      m = 1;
      if (4 != n) {
        break label145;
      }
      n = 1;
      label77:
      if (n == 0) {
        break label151;
      }
      bdla.b(null, "CliOper", "", "", "0X8009F5E", "0X8009F5E", 0, 0, "", "", "", "");
      label109:
      if ((n == 0) && (m == 0)) {
        break label186;
      }
      if (m == 0) {
        break label181;
      }
      m = 4;
      label124:
      localAVActivity.a(m, false);
    }
    for (;;)
    {
      l(paramLong, 2131695091);
      return;
      label140:
      m = 0;
      break;
      label145:
      n = 0;
      break label77;
      label151:
      bdla.b(null, "CliOper", "", "", "0X8009F5F", "0X8009F5F", 0, 0, "", "", "", "");
      break label109;
      label181:
      m = 3;
      break label124;
      label186:
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "avideo onClick QavPanel.ViewID.SWITCH_DISPLAY_MODE error happen");
    }
  }
  
  public void x()
  {
    int m;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().N == 1)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.h() != 4) {
        break label131;
      }
      m = 3;
      if ((m != 3) || (mtr.c())) {
        break label136;
      }
      m = 4;
    }
    label131:
    label136:
    for (;;)
    {
      AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localAVActivity != null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d(this.jdField_d_of_type_JavaLangString, 4, "initScreenLayout Style=" + m + "|" + this.jdField_a_of_type_ComTencentAvVideoController.a().N + "|" + this.jdField_a_of_type_ComTencentAvVideoController.h());
        }
        localAVActivity.a(m, false);
      }
      return;
      m = 4;
      break;
    }
  }
  
  void x(long paramLong)
  {
    y(paramLong);
    l(paramLong, 2131695082);
  }
  
  void y()
  {
    long l1 = AudioHelper.b();
    lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "refreshMemberCtrlButton, SessionType[" + locallfe.jdField_d_of_type_Int + "], multiAVType[" + locallfe.D + "], mUinType[" + this.jdField_d_of_type_Int + "], isManager[" + locallfe.ac + "], isRoomCreator[" + locallfe.ad + "], mGAudioInRoom[" + this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean + "]");
    i(l1, 16777215);
  }
  
  void y(long paramLong)
  {
    boolean bool = false;
    QLog.d(this.jdField_d_of_type_JavaLangString, 1, "OnClick_MemberInfo");
    bdla.b(null, "CliOper", "", "", "0X8009F64", "0X8009F64", 0, 0, "", "", "", "");
    AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().ac) || (this.jdField_a_of_type_ComTencentAvVideoController.a().ad)) {
      bool = true;
    }
    VideoMsgTools.a(localAVActivity, String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Long), bool, true);
  }
  
  public void z()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0);
    int m = localSharedPreferences.getInt("group_video_push_cfg_txt." + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin() + ".level", 1);
    int n = localSharedPreferences.getInt("group_video_push_cfg_txt." + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin() + ".sendDura", 5000);
    int i1 = localSharedPreferences.getInt("group_video_push_cfg_txt." + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin() + ".validDura", 6000);
    this.jdField_a_of_type_ComTencentAvVideoController.a(m, n, i1);
  }
  
  protected void z(long paramLong)
  {
    if (!VideoController.a()) {
      return;
    }
    lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
    locallfe.c(paramLong, true);
    long l1 = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
    int m = 0;
    if (m < locallfe.jdField_c_of_type_JavaUtilArrayList.size())
    {
      lob locallob = (lob)locallfe.jdField_c_of_type_JavaUtilArrayList.get(m);
      if ((locallob.jdField_a_of_type_Long == l1) && (locallob.jdField_a_of_type_Int == 2)) {
        locallob.jdField_b_of_type_Boolean = true;
      }
      for (locallob.jdField_d_of_type_Boolean = true;; locallob.jdField_d_of_type_Boolean = false)
      {
        m += 1;
        break;
        locallob.jdField_b_of_type_Boolean = false;
      }
    }
    locallfe.a(-1L, "onUserScreenShareOpen", 4);
    a("onUserScreenShareOpen", paramLong);
    b(paramLong, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase
 * JD-Core Version:    0.7.0.1
 */