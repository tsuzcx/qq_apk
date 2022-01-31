package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import azqk;
import azqs;
import bdin;
import bdjg;
import bdjl;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import lhe;
import lid;
import lmv;
import lqq;
import mbl;
import mbt;
import mdd;
import meu;
import mia;
import mib;
import mic;
import mkb;
import moi;
import mpe;
import mqq.app.MobileQQ;
import mtq;
import mvw;
import mwd;
import mwk;
import mww;

public class MultiVideoCtrlLayerUI4NewGroupChat
  extends MultiVideoCtrlLayerUIBase
{
  int jdField_a_of_type_Int = 0;
  lhe jdField_a_of_type_Lhe = new mic(this);
  meu jdField_a_of_type_Meu = new mia(this);
  public boolean a;
  
  public MultiVideoCtrlLayerUI4NewGroupChat(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, meu parammeu)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, parammeu);
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "MultiVideoCtrlLayerUI4NewGroupChat --> Create");
    }
  }
  
  private void Q()
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel == null) {}
    while (this.jdField_a_of_type_ComTencentAvVideoController.a().v()) {
      return;
    }
    if (this.jdField_a_of_type_Int != 0)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentAvUiQavPanel.getContext(), this.jdField_a_of_type_ComTencentAvUiQavPanel.getResources().getString(this.jdField_a_of_type_Int), 1).a();
      return;
    }
    mdd.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1032);
  }
  
  public static int a(String paramString1, VideoAppInterface paramVideoAppInterface, String paramString2, boolean paramBoolean)
  {
    int i = 0;
    if (bdjg.b() <= 0) {
      i = 2131696060;
    }
    int j;
    do
    {
      return i;
      j = paramVideoAppInterface.a().c().size();
      if (bdjg.c() <= j)
      {
        if (AudioHelper.e()) {
          QLog.w(paramString1, 1, "isFull, 通话成员超出上限[" + j + "]");
        }
        return 2131696058;
      }
    } while (!AudioHelper.e());
    QLog.w(paramString1, 1, "isGAudioFull, gAudioMemCount[" + j + "], canAutoInviteMemIntoTroop[" + paramBoolean + "], wording[" + 0 + "]");
    return 0;
  }
  
  private void n(long paramLong)
  {
    a(paramLong, 0.0F);
  }
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_d_of_type_JavaLangString, 2, "handleExtraData, mStatusType[" + this.jdField_c_of_type_Int + "]");
    }
    if ((this.jdField_c_of_type_Int == 0) || (this.jdField_c_of_type_Int == 1))
    {
      super.a(-1022L, "handleExtraData");
      c();
    }
    do
    {
      return;
      if (this.jdField_c_of_type_Int == 2)
      {
        this.jdField_a_of_type_Mvw.b(true);
        this.jdField_a_of_type_Mvw.c(true);
        this.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e(this.jdField_d_of_type_JavaLangString, 2, "handleExterData-->Wrong gaudioStatusType-->type = " + this.jdField_c_of_type_Int + " , relationId = " + this.jdField_a_of_type_Long + " , relationType = " + this.jdField_e_of_type_Int);
  }
  
  @TargetApi(11)
  void a(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "drawUI, uin[" + paramLong + "], refreshType[" + paramInt1 + "], needRefresh[" + paramBoolean + "], originalType[" + paramInt2 + "], seq[" + l + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    label154:
    label235:
    label1270:
    do
    {
      return;
      int i;
      int j;
      if (paramInt1 == 0)
      {
        if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (paramLong != this.jdField_c_of_type_Long) && (this.jdField_a_of_type_ComTencentAvVideoController.a().ak)) {
          mwk.a().a(l, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230736, null, 0, null);
        }
        if (paramLong == this.jdField_c_of_type_Long) {
          super.y();
        }
        if ((paramInt1 != 0) && (paramInt1 != 1)) {
          break label392;
        }
        i = -1;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int != 9) {
          break label296;
        }
        if (paramInt1 == 1)
        {
          i = 1;
          b(this.i, 2131696048, String.valueOf(paramLong), null);
        }
        g(l, 2131696033);
        j = i;
        if (!this.h) {
          break label386;
        }
        e(l, true);
        paramInt1 = i;
        a(l, "drawUI", paramInt1, paramLong);
      }
      for (;;)
      {
        if (paramInt2 != 42) {
          break label1270;
        }
        super.a(paramLong, true);
        return;
        if ((paramInt1 != 1) || (paramLong == this.jdField_c_of_type_Long)) {
          break label154;
        }
        mwk.a().a(l, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230737, null, 0, null);
        break label154;
        if (paramInt1 == 0)
        {
          e(l, false);
          d(l, null);
          super.A(l);
          j = i;
          if (!this.jdField_a_of_type_ComTencentAvVideoController.a().ak) {
            break label386;
          }
          b(this.i, 2131696040, String.valueOf(paramLong), null);
          paramInt1 = 0;
          break label235;
        }
        j = i;
        if (paramInt1 == 1)
        {
          j = 1;
          b(this.i, 2131696048, String.valueOf(paramLong), null);
        }
        paramInt1 = j;
        break label235;
        boolean bool;
        if ((paramInt1 == 5) || (paramInt1 == 6))
        {
          i = 0;
          paramBoolean = true;
          if (paramLong == this.jdField_c_of_type_Long) {
            i = 1;
          }
          if (paramInt1 == 6)
          {
            bool = super.a(l);
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().r())
            {
              super.K();
              n(l);
            }
            paramBoolean = bool;
            if (i != 0)
            {
              paramBoolean = bool;
              if (!this.jdField_a_of_type_ComTencentAvVideoController.a().an)
              {
                this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().c, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList, 1, false);
                paramBoolean = bool;
              }
            }
          }
          if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().ak) || (!paramBoolean)) {
            continue;
          }
          if (this.k >= 4) {
            break;
          }
          if ((bdin.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) || (this.jdField_a_of_type_ComTencentAvVideoController.a().a() != -1) || (this.jdField_a_of_type_ComTencentAvVideoController.a().ap))
          {
            if (i == 0)
            {
              super.h(paramInt1);
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable);
              this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable.a = ("DrawUI:TYPE=" + String.valueOf(paramInt1));
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable, 1000L);
              continue;
            }
            i = this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_c_of_type_Long, 1);
            j = this.jdField_a_of_type_ComTencentAvVideoController.a().a();
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_d_of_type_JavaLangString, 2, "onSelfVideoIn.-->FirstVideo=" + j + ",index=" + i);
            }
            if ((j != -1) && ((i != j) || (i == 0))) {
              continue;
            }
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable);
            this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable.a = ("DrawUI:TYPE=" + String.valueOf(paramInt1));
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable, 1000L);
            continue;
          }
          if (i != 0) {
            continue;
          }
          this.jdField_a_of_type_ComTencentAvVideoController.a().a(l, "drawUI.1", true, true);
          super.a("drawUI.1", l);
          super.a(true, true, true);
          continue;
        }
        if ((paramInt1 == 7) || (paramInt1 == 8))
        {
          paramBoolean = true;
          if (paramInt1 == 8)
          {
            lqq locallqq = new lqq();
            locallqq.jdField_a_of_type_Long = paramLong;
            locallqq.jdField_a_of_type_Int = 2;
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(locallqq);
            this.jdField_b_of_type_Meu.update(null, new Object[] { Integer.valueOf(104), localArrayList });
          }
          if (paramInt1 == 8)
          {
            bool = super.a(l);
            paramBoolean = bool;
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().r())
            {
              super.K();
              paramBoolean = bool;
              if (Build.VERSION.SDK_INT >= 11)
              {
                a(l, 0.0F);
                paramBoolean = bool;
              }
            }
          }
          if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().ak) || (!paramBoolean)) {
            continue;
          }
          if (this.k >= 4) {
            break;
          }
          if ((bdin.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) || (this.jdField_a_of_type_ComTencentAvVideoController.a().a() != -1) || (this.jdField_a_of_type_ComTencentAvVideoController.a().ap))
          {
            super.h(paramInt1);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable);
            this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable.a = ("DrawUI:TYPE=" + String.valueOf(paramInt1));
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable, 1000L);
            continue;
          }
          this.jdField_a_of_type_ComTencentAvVideoController.a().a(l, "drawUI.2", true, true);
          super.a("drawUI.2", l);
          super.a(true, true, true);
          continue;
        }
        if ((paramInt1 == 97) || (paramInt1 == 98))
        {
          if (QLog.isColorLevel()) {
            QLog.e(this.jdField_d_of_type_JavaLangString, 2, "Request remote video failed.Uin = " + paramLong + ",type=" + paramInt1);
          }
          this.jdField_a_of_type_ComTencentAvVideoController.a().a(l, "drawUI.3", true, true);
          super.a("drawUI.3", l);
          super.w();
        }
      }
    } while (paramInt2 != 43);
    label296:
    super.a(paramLong, false);
    label386:
    label392:
    return;
  }
  
  public void a(long paramLong, View paramView)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (!(this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof AVActivity))) {}
    boolean bool;
    do
    {
      return;
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131364130: 
      case 2131365136: 
      case 2131372898: 
        P();
        return;
      case 2131695812: 
        i(paramLong, paramView);
        return;
      case 2131695821: 
        h(paramLong, paramView);
        return;
      case 2131695820: 
        v(paramLong);
        return;
      case 2131370151: 
      case 2131375793: 
        x(paramLong);
        return;
      case 2131372594: 
        QLog.d(this.jdField_d_of_type_JavaLangString, 1, "avideo onClick QavPanel.ViewID.HIDE");
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4)
        {
          mtq.a(this.jdField_a_of_type_ComTencentAvVideoController.a().k, this.jdField_a_of_type_ComTencentAvVideoController.a().j, 10);
          if ((!mbt.f()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().j)) {
            super.a(2131695966, 1, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131298914));
          }
        }
        if (mbt.f())
        {
          paramView = ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a();
          if (paramView != null) {
            paramView.a();
          }
        }
        super.d(false);
        return;
      case 2131695811: 
        w(paramLong);
        return;
      case 2131372591: 
      case 2131372592: 
        QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.HANG_UP");
        moi.a(this.jdField_a_of_type_ComTencentAvVideoController.a());
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4) {
          azqk.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        }
        g(true);
        if (this.jdField_a_of_type_Mkb != null)
        {
          this.jdField_a_of_type_Mkb.a(new mib(this, paramLong));
          return;
        }
        azqs.b(null, "CliOper", "", "", "0X800592D", "0X800592D", 0, 0, "", "", "", "");
        if (((this.f == 90) || (this.f == 270)) && (this.jdField_a_of_type_ComTencentAvVideoController.a().a() != -1) && (((lqq)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0)).jdField_a_of_type_Int == 1)) {
          azqs.b(null, "CliOper", "", "", "0X800594D", "0X800594D", 0, 0, "", "", "", "");
        }
        for (;;)
        {
          super.B(paramLong);
          super.d(true);
          if (!this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean) {
            break;
          }
          this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long, 102);
          return;
          if (((this.f == 90) || (this.f == 270)) && (this.jdField_a_of_type_ComTencentAvVideoController.a().a() != -1) && (((lqq)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0)).jdField_a_of_type_Int == 2)) {
            azqs.b(null, "CliOper", "", "", "0X800594E", "0X800594E", 0, 0, "", "", "", "");
          }
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_e_of_type_Int, this.jdField_b_of_type_Long, 103);
        return;
      case 2131372597: 
        c(paramLong, paramView);
        return;
      case 2131372589: 
        QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.HAND_FREE");
        paramView = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfJavaLangString;
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().O) && (paramView != null)) {
          mtq.c(true, 10);
        }
        for (;;)
        {
          this.jdField_a_of_type_Mwk.a(mwk.jdField_c_of_type_Int);
          return;
          if (paramView == null)
          {
            if (QLog.isColorLevel()) {
              QLog.e(this.jdField_d_of_type_JavaLangString, 2, "DeviceList is null");
            }
          }
          else {
            mtq.c(false, 10);
          }
        }
      case 2131695809: 
        d(paramLong, paramView);
        return;
      case 2131372903: 
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick, switch_camera, seq[" + paramLong + "]");
        this.jdField_b_of_type_Meu.update(null, new Object[] { Integer.valueOf(107), Long.valueOf(paramLong) });
        paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().m) {
          break label951;
        }
        bool = true;
        paramView.m = bool;
      }
    } while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null);
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().m) {}
    for (int i = 2131693070;; i = 2131693069)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131372903, this.jdField_a_of_type_AndroidContentResResources.getString(i));
      return;
      label951:
      bool = false;
      break;
    }
    f(paramLong, paramView);
    return;
    g(paramLong, paramView);
    return;
    e(paramLong, paramView);
    return;
    l(paramLong);
    return;
    b(paramLong, paramView);
  }
  
  void a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (!paramIntent.hasExtra("enableInvite")) {
        break label152;
      }
      this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("enableInvite", false);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "processExtraData, gaudioStatusType[" + this.jdField_a_of_type_ComTencentAvVideoController.a().D + "], relationId[" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Long + "], isInRoom[" + this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean + "], mGAudioGroupId[" + this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long + "], isVideo[" + this.jdField_e_of_type_Boolean + "], mCanAutoInviteMemIntoTroop[" + this.jdField_a_of_type_Boolean + "]");
      }
      return;
      label152:
      paramIntent = new Bundle();
      paramIntent.putString("uin", this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Long + "");
      Bundle localBundle = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3, 0, 0, paramIntent, null);
      AudioHelper.a("request", paramIntent);
      AudioHelper.a("response", localBundle);
      if (localBundle != null) {
        this.jdField_a_of_type_Boolean = localBundle.getBoolean("enableInvite", false);
      }
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanel.b(paramBoolean, paramInt);
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "OnKeyDown --> WRONG KeyCode = " + paramInt);
      }
      break;
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
                return false;
                this.jdField_a_of_type_Mwk.a();
                return false;
              } while (this.jdField_a_of_type_ComTencentAvVideoController == null);
              mtq.b(this.jdField_a_of_type_ComTencentAvVideoController.a().k, this.jdField_a_of_type_ComTencentAvVideoController.a().j, 10);
              if (mbt.f()) {
                break;
              }
            } while (!this.jdField_a_of_type_ComTencentAvVideoController.a().j);
            super.a(2131695966, 1, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131298914));
            return false;
          } while (this.jdField_a_of_type_JavaLangRefWeakReference == null);
          paramKeyEvent = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        } while ((paramKeyEvent == null) || (!(paramKeyEvent instanceof AVActivity)));
        paramKeyEvent = (AVActivity)paramKeyEvent;
      } while (paramKeyEvent == null);
      paramKeyEvent = paramKeyEvent.a();
    } while (paramKeyEvent == null);
    paramKeyEvent.a();
    return false;
  }
  
  void b(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "setMembersInOrOutWording, type[" + paramInt1 + "], id[" + paramInt2 + "], uin[" + paramString1 + "], value[" + paramString2 + "]");
    }
    if (paramInt1 == this.i) {
      if (paramString1 == null) {
        paramString2 = this.jdField_a_of_type_AndroidContentResResources.getString(paramInt2);
      }
    }
    for (;;)
    {
      mdd.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3009, paramString2);
      return;
      paramString1 = this.jdField_a_of_type_ComTencentAvVideoController.a(paramString1, String.valueOf(this.jdField_b_of_type_Long), this.jdField_e_of_type_Int);
      float f = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297038);
      paramString1 = mww.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramString1, this.jdField_d_of_type_AndroidWidgetTextView, f);
      paramString2 = paramString1 + this.jdField_a_of_type_AndroidContentResResources.getString(paramInt2);
      continue;
      if (paramInt1 != this.j) {
        paramString2 = null;
      }
    }
  }
  
  public void b(long paramLong, View paramView)
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramLong, 0, false);
    paramView = a();
    if (paramView.a != null)
    {
      if (!paramView.a.a()) {
        break label51;
      }
      paramView.a.c(3);
    }
    for (;;)
    {
      s();
      lmv.a("0X800A8D0");
      return;
      label51:
      paramView.a.a(0);
    }
  }
  
  void c()
  {
    long l = AudioHelper.b();
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "createOrEnterVideo, mRelationId[" + this.jdField_b_of_type_Long + "], mIntentRelationId[" + this.jdField_a_of_type_Long + "], mStatusType[" + this.jdField_c_of_type_Int + "], seq[" + l + "]");
    this.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
    if (this.jdField_b_of_type_Long <= 0L) {
      return;
    }
    g(l, 2131695976);
    Object localObject1;
    Object localObject2;
    if (this.jdField_c_of_type_Int == 0)
    {
      localObject1 = a();
      if (localObject1 == null) {
        break label278;
      }
      localObject2 = ((Intent)localObject1).getParcelableArrayListExtra("invitelist");
      if ((localObject2 == null) || (((ArrayList)localObject2).size() <= 0)) {
        break label278;
      }
      localObject1 = new long[((ArrayList)localObject2).size()];
      localObject2 = ((ArrayList)localObject2).iterator();
      int i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject1[i] = AudioHelper.a(((ResultRecord)((Iterator)localObject2).next()).a);
        i += 1;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfLong;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_e_of_type_Int, this.jdField_b_of_type_Long, 0, (long[])localObject2, this.jdField_e_of_type_Boolean);
      this.jdField_c_of_type_Boolean = true;
      return;
      if (this.jdField_c_of_type_Int != 1) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a(l, this.jdField_e_of_type_Int, this.jdField_b_of_type_Long, null, this.jdField_e_of_type_Boolean);
      return;
      label278:
      localObject1 = null;
    }
  }
  
  protected boolean c()
  {
    if (g()) {}
    do
    {
      return true;
      this.jdField_a_of_type_Int = a(this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_b_of_type_Long + "", this.jdField_a_of_type_Boolean);
    } while (this.jdField_a_of_type_Int != 0);
    return false;
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lhe);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Meu);
    b();
    f(0L, this.jdField_a_of_type_ComTencentAvVideoController.a().b());
    a();
  }
  
  public void d(long paramLong)
  {
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onDestroy, seq[" + paramLong + "]");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lhe);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Meu);
    super.d(paramLong);
  }
  
  void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "refreshMuteBtnState");
    }
    if ((!this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131372597)) && (this.jdField_a_of_type_ComTencentAvVideoController != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372597, true);
      if (this.jdField_a_of_type_ComTencentAvVideoController.h()) {
        super.k(2131372597);
      }
    }
    else
    {
      return;
    }
    super.l(2131372597);
  }
  
  @TargetApi(21)
  public void e(long paramLong, View paramView)
  {
    super.e(paramLong, paramView);
    mww.a("0x800AD8D");
  }
  
  void l(long paramLong)
  {
    if (!b(paramLong))
    {
      bdjl.c(false);
      Q();
      f(paramLong, 65535);
    }
    for (;;)
    {
      j(paramLong, 2131695813);
      return;
      bdjl.c(true);
      Object localObject = new Intent();
      ((Intent)localObject).setAction("tencent.video.v2q.AddMembersToGroup");
      ((Intent)localObject).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName());
      this.jdField_a_of_type_ComTencentAvVideoController.d();
      lid locallid = this.jdField_a_of_type_ComTencentAvVideoController.a();
      long l = locallid.b();
      int i = locallid.e();
      ((Intent)localObject).putExtra("room_id", l);
      ((Intent)localObject).putExtra("room_create_time", i);
      ((Intent)localObject).putExtra("uin", Long.toString(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long));
      mwd.a((Intent)localObject, paramLong);
      ((Intent)localObject).putParcelableArrayListExtra("memberlist", this.jdField_a_of_type_ComTencentAvVideoController.d());
      AudioHelper.a("ACTION_ADD_MEMBERS_TO_GROUP", ((Intent)localObject).getExtras(), true);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast((Intent)localObject);
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_g_of_type_Int = 1;
      if (mbt.f())
      {
        localObject = ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a();
        if (localObject != null) {
          ((mbl)localObject).c();
        }
      }
    }
  }
  
  protected void p()
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131559610);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat
 * JD-Core Version:    0.7.0.1
 */