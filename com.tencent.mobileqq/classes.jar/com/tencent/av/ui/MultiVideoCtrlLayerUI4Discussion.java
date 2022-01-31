package com.tencent.av.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import azqk;
import azqs;
import bdgm;
import bdin;
import bdjn;
import bdjz;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import lhe;
import lid;
import lqq;
import mbl;
import mbt;
import mdd;
import meu;
import mhu;
import mhv;
import mhw;
import mhx;
import mhy;
import mhz;
import mkb;
import moi;
import mqq.app.MobileQQ;
import mtq;
import mvg;
import mvw;
import mwk;
import mww;

public class MultiVideoCtrlLayerUI4Discussion
  extends MultiVideoCtrlLayerUIBase
{
  Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  lhe jdField_a_of_type_Lhe = new mhx(this);
  boolean jdField_a_of_type_Boolean = false;
  
  public MultiVideoCtrlLayerUI4Discussion(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, meu parammeu)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, parammeu);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "MultiVideoCtrlLayerUI4Discussion --> Create");
    }
  }
  
  void a()
  {
    if ((this.jdField_c_of_type_Int == 0) || (this.jdField_c_of_type_Int == 1))
    {
      a(-1022L, "handleExtraData");
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
  
  void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getResources().getString(2131693465);
    localObject = bdgm.a(localAVActivity, 230).setMessage(str).setNegativeButton(2131693466, new mhz(this)).setPositiveButton(2131693467, new mhy(this, (VideoAppInterface)localObject, paramInt));
    if (localAVActivity.isResume()) {
      ((bdjz)localObject).show();
    }
  }
  
  void a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new MultiVideoCtrlLayerUI4Discussion.1(this, paramInt2, paramString1), 1000L);
  }
  
  void a(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "drawUI, uin[" + paramLong + "], refreshType[" + paramInt1 + "], needRefresh[" + paramBoolean + "], originalType[" + paramInt2 + "], seq[" + l + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    label181:
    label333:
    do
    {
      return;
      int j;
      int i;
      if (paramInt1 == 0)
      {
        if ((paramLong != this.jdField_c_of_type_Long) && (this.jdField_a_of_type_ComTencentAvVideoController.a().ak)) {
          mwk.a().a(l, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230736, null, 0, null);
        }
        if ((paramLong != this.jdField_a_of_type_ComTencentAvVideoController.a().h) && (paramLong != this.jdField_c_of_type_Long)) {
          mdd.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1047);
        }
        if (paramLong == this.jdField_c_of_type_Long) {
          y();
        }
        if ((paramInt1 != 0) && (paramInt1 != 1)) {
          break label442;
        }
        j = -1;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Int != 9) {
          break label333;
        }
        if (paramInt1 == 1)
        {
          j = 1;
          b(this.i, 2131696015, String.valueOf(paramLong), null);
        }
        g(l, 2131696033);
        i = j;
        if (!this.h) {
          break label436;
        }
        e(l, true);
        paramInt1 = j;
        a(l, "drawUI", paramInt1, paramLong);
      }
      for (;;)
      {
        if (paramInt2 != 42) {
          break label1536;
        }
        a(paramLong, true);
        return;
        if (paramInt1 != 1) {
          break label181;
        }
        if (paramLong != this.jdField_c_of_type_Long) {
          mwk.a().a(l, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230737, null, 0, null);
        }
        mdd.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1047);
        break label181;
        if (paramInt1 == 0)
        {
          e(l, false);
          d(l, null);
          A(l);
          i = j;
          if (paramLong == this.jdField_c_of_type_Long) {
            break label436;
          }
          i = j;
          if (!this.jdField_a_of_type_ComTencentAvVideoController.a().ak) {
            break label436;
          }
          b(this.i, 2131695964, String.valueOf(paramLong), null);
          paramInt1 = 0;
          break label262;
        }
        i = j;
        if (paramInt1 == 1)
        {
          i = 1;
          b(this.i, 2131696015, String.valueOf(paramLong), null);
        }
        paramInt1 = i;
        break label262;
        Object localObject1;
        Object localObject2;
        if (paramInt1 == 68)
        {
          float f = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297038);
          localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a(String.valueOf(paramLong), String.valueOf(this.jdField_b_of_type_Long), this.jdField_e_of_type_Int);
          localObject2 = mww.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (String)localObject1, this.jdField_d_of_type_AndroidWidgetTextView, f);
          if (this.jdField_g_of_type_Int == 1) {}
          for (localObject1 = this.jdField_a_of_type_AndroidContentResResources.getString(2131695987);; localObject1 = String.format(this.jdField_a_of_type_AndroidContentResResources.getString(2131695986), new Object[] { Integer.valueOf(this.jdField_g_of_type_Int) }))
          {
            localObject1 = this.jdField_a_of_type_AndroidContentResResources.getString(2131695985) + (String)localObject2 + (String)localObject1;
            b(this.j, 0, null, (String)localObject1);
            break;
          }
        }
        if (paramInt1 == 82)
        {
          b(this.j, 0, null, this.jdField_a_of_type_JavaLangString);
        }
        else
        {
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
              bool = a(l);
              if (this.jdField_a_of_type_ComTencentAvVideoController.a().r())
              {
                K();
                a(l, 0.0F);
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
                h(paramInt1);
                this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable);
                this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable.jdField_a_of_type_JavaLangString = ("DrawUI:TYPE=" + String.valueOf(paramInt1));
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
              this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable.jdField_a_of_type_JavaLangString = ("DrawUI:TYPE=" + String.valueOf(paramInt1));
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable, 1000L);
              continue;
            }
            if (i != 0) {
              continue;
            }
            this.jdField_a_of_type_ComTencentAvVideoController.a().a(l, "drawUI.1", true, true);
            a("drawUI.1", l);
            a(true, true, true);
            continue;
          }
          if ((paramInt1 == 7) || (paramInt1 == 8))
          {
            paramBoolean = true;
            if (paramInt1 == 8)
            {
              localObject1 = new lqq();
              ((lqq)localObject1).jdField_a_of_type_Long = paramLong;
              ((lqq)localObject1).jdField_a_of_type_Int = 2;
              localObject2 = new ArrayList();
              ((ArrayList)localObject2).add(localObject1);
              this.jdField_b_of_type_Meu.update(null, new Object[] { Integer.valueOf(104), localObject2 });
            }
            if (paramInt1 == 8)
            {
              bool = a(l);
              paramBoolean = bool;
              if (this.jdField_a_of_type_ComTencentAvVideoController.a().r())
              {
                K();
                a(l, 0.0F);
                paramBoolean = bool;
              }
            }
            for (;;)
            {
              if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().ak) || (!paramBoolean)) {
                break label1409;
              }
              if (this.k >= 4) {
                break;
              }
              if ((!bdin.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (this.jdField_a_of_type_ComTencentAvVideoController.a().a() == -1) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().ap)) {
                break label1411;
              }
              h(paramInt1);
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable);
              this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable.jdField_a_of_type_JavaLangString = ("DrawUI:TYPE=" + String.valueOf(paramInt1));
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable, 1000L);
              break label273;
              azqs.b(null, "CliOper", "", "", "0X8004CF0", "0X8004CF0", 0, 0, "", "", "", "");
            }
            continue;
            this.jdField_a_of_type_ComTencentAvVideoController.a().a(l, "drawUI.2", true, true);
            a("drawUI.2", l);
            a(true, true, true);
          }
          else if ((paramInt1 == 97) || (paramInt1 == 98))
          {
            if (QLog.isColorLevel()) {
              QLog.e(this.jdField_d_of_type_JavaLangString, 2, "Request remote video failed.Uin = " + paramLong + ",type=" + paramInt1);
            }
            this.jdField_a_of_type_ComTencentAvVideoController.a().a(l, "drawUI.3", true, true);
            a("drawUI.3", l);
            w();
          }
        }
      }
    } while (paramInt2 != 43);
    label262:
    label273:
    label436:
    label442:
    a(paramLong, false);
    label1409:
    label1411:
    return;
  }
  
  public void a(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    super.a(paramLong, paramInt1, paramBoolean, paramInt2, paramInt3);
    if (((paramInt1 == 0) || (5 == paramInt1)) && (bdjn.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(String.valueOf(this.jdField_b_of_type_Long))))) {
      b(paramLong, paramInt1, paramBoolean, paramInt2);
    }
  }
  
  public void a(long paramLong, View paramView)
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (!(this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof AVActivity))) {}
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
          mtq.a(this.jdField_a_of_type_ComTencentAvVideoController.a().k, this.jdField_a_of_type_ComTencentAvVideoController.a().j, 1);
          if ((!mbt.f()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().j)) {
            a(2131695966, 1, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131298914));
          }
        }
        if (mbt.f())
        {
          paramView = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if ((paramView instanceof AVActivity))
          {
            paramView = ((AVActivity)paramView).a();
            if (paramView != null) {
              paramView.a();
            }
          }
        }
        d(false);
        return;
      case 2131695811: 
        w(paramLong);
        return;
      case 2131695813: 
        n(paramLong);
        return;
      case 2131372591: 
      case 2131372592: 
        QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.HANG_UP");
        moi.a(this.jdField_a_of_type_ComTencentAvVideoController.a());
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4) {
          azqk.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        }
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().f.size() > 0) && (this.jdField_a_of_type_ComTencentAvVideoController.a().ac))
        {
          bdgm.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 230).setTitle(((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131696097)).setMessage(((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131696095)).setNegativeButton(((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131696094), new mhv(this)).setPositiveButton(((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131696096), new mhu(this, paramLong)).show();
          return;
        }
        paramView = new Bundle();
        paramView.putString("uin", String.valueOf(this.jdField_b_of_type_Long));
        paramView = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(5, 0, 0, paramView, null);
        if (paramView == null)
        {
          l(paramLong);
          return;
        }
        long l1 = paramView.getLong("Origin", 0L);
        long l2 = paramView.getLong("OriginExtra", 0L);
        i = paramView.getInt("SelfRight", -1);
        if (((l1 & 0x2) == 2L) && (bdjn.a(l2) == 0))
        {
          a(i);
          return;
        }
        l(paramLong);
        return;
      case 2131372597: 
        c(paramLong, paramView);
        return;
      case 2131372589: 
        this.jdField_a_of_type_Mwk.a(mwk.jdField_c_of_type_Int);
        return;
      case 2131695809: 
        d(paramLong, paramView);
        return;
      case 2131372903: 
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick, switch_camera, seq[" + paramLong + "]");
        this.jdField_b_of_type_Meu.update(null, new Object[] { Integer.valueOf(107), Long.valueOf(paramLong) });
        paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().m) {
          bool = true;
        }
        paramView.m = bool;
      }
    } while (this.jdField_a_of_type_ComTencentAvUiQavPanel == null);
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().m) {}
    for (int i = 2131693070;; i = 2131693069)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131372903, this.jdField_a_of_type_AndroidContentResResources.getString(i));
      return;
    }
    f(paramLong, paramView);
    return;
    g(paramLong, paramView);
  }
  
  void a(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "processExtraData--> Type = " + this.jdField_a_of_type_ComTencentAvVideoController.a().D + " , relationId = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Long + " , isInRoom = " + this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean + " , RoomRelationId = " + this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long);
    }
  }
  
  public void a(String paramString, String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    if (i < 1) {
      return;
    }
    paramArrayOfString = paramArrayOfString[0];
    String str1 = this.jdField_a_of_type_ComTencentAvVideoController.a(paramArrayOfString, String.valueOf(this.jdField_b_of_type_Long), this.jdField_e_of_type_Int);
    float f = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297038);
    if (i == 1)
    {
      paramArrayOfString = this.jdField_a_of_type_AndroidContentResResources.getString(2131695987);
      if (paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) {
        break label289;
      }
      String str2 = this.jdField_a_of_type_ComTencentAvVideoController.a(paramString, String.valueOf(this.jdField_b_of_type_Long), this.jdField_e_of_type_Int);
      f = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297040);
      str1 = mww.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), str1, this.jdField_d_of_type_AndroidWidgetTextView, f);
      str2 = mww.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), str2, this.jdField_d_of_type_AndroidWidgetTextView, f);
      this.jdField_a_of_type_JavaLangString = (str2 + this.jdField_a_of_type_AndroidContentResResources.getString(2131695984) + str1 + paramArrayOfString);
    }
    for (paramArrayOfString = str1;; paramArrayOfString = str1)
    {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onOtherMemberInvited, inviterUin[" + paramString + "], invitedName[" + paramArrayOfString + "]");
      a(Long.valueOf(paramString).longValue(), 82, true, -1, 0);
      return;
      paramArrayOfString = String.format(this.jdField_a_of_type_AndroidContentResResources.getString(2131695986), new Object[] { Integer.valueOf(i) });
      break;
      label289:
      str1 = mww.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), str1, this.jdField_d_of_type_AndroidWidgetTextView, f);
      this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_AndroidContentResResources.getString(2131695985) + str1 + paramArrayOfString);
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(paramBoolean, paramInt);
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    long l1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(String.valueOf(this.jdField_b_of_type_Long));
    String str1;
    String str2;
    String str3;
    if (l1 > 0L)
    {
      long l2 = this.jdField_a_of_type_ComTencentAvVideoController.d();
      long l3 = this.jdField_a_of_type_ComTencentAvVideoController.e();
      str1 = String.valueOf(l2);
      str2 = String.valueOf(l1);
      str3 = String.valueOf(paramLong) + "_" + str1 + "_" + String.valueOf(l3) + "_" + str2;
      if (!paramBoolean) {
        break label189;
      }
    }
    label189:
    for (int i = 1;; i = 2)
    {
      azqs.b(null, "dc00898", "", "", "0X800827C", "0X800827C", i, 0, str2, "", str3, "");
      QLog.e(this.jdField_d_of_type_JavaLangString, 1, "onCreateRoomSuc post conf, GroupID = " + paramLong + ", strRoomId=" + str1);
      return;
    }
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
              return false;
              this.jdField_a_of_type_Mwk.a();
              return false;
            } while (this.jdField_a_of_type_ComTencentAvVideoController == null);
            mtq.b(this.jdField_a_of_type_ComTencentAvVideoController.a().k, this.jdField_a_of_type_ComTencentAvVideoController.a().j, 1);
            if (mbt.f()) {
              break;
            }
          } while (!this.jdField_a_of_type_ComTencentAvVideoController.a().j);
          a(2131695966, 1, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131298914));
          return false;
        } while (this.jdField_a_of_type_JavaLangRefWeakReference == null);
        paramKeyEvent = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      } while ((paramKeyEvent == null) || (!(paramKeyEvent instanceof AVActivity)));
      paramKeyEvent = ((AVActivity)paramKeyEvent).a();
    } while (paramKeyEvent == null);
    paramKeyEvent.a();
    return false;
  }
  
  void b(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "setMembersInOrOutWording --> Type = " + paramInt1 + " , Id = " + paramInt2 + " , Uin = " + paramString1 + " , value = " + paramString2);
    }
    if (paramInt1 == this.i)
    {
      if (paramString1 == null)
      {
        paramString2 = this.jdField_a_of_type_AndroidContentResResources.getString(paramInt2);
        mdd.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3009, paramString2);
        return;
      }
      if (this.jdField_d_of_type_Boolean)
      {
        if (bdjn.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(String.valueOf(this.jdField_b_of_type_Long))))
        {
          a(paramInt1, paramInt2, paramString1, paramString2);
          return;
        }
        paramString1 = this.jdField_a_of_type_ComTencentAvVideoController.a(paramString1, String.valueOf(this.jdField_b_of_type_Long), this.jdField_e_of_type_Int);
      }
    }
    for (;;)
    {
      float f = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297038);
      paramString1 = mww.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramString1, this.jdField_d_of_type_AndroidWidgetTextView, f);
      paramString2 = paramString1 + this.jdField_a_of_type_AndroidContentResResources.getString(paramInt2);
      break;
      long l = Long.valueOf(paramString1).longValue();
      paramString1 = this.jdField_a_of_type_ComTencentAvVideoController.a().a(l, this.jdField_a_of_type_ComTencentAvVideoController.a().f);
      if (paramString1 == null)
      {
        paramString1 = this.jdField_a_of_type_AndroidContentResResources.getString(2131693347);
      }
      else
      {
        paramString2 = paramString1.telInfo.mobile;
        if (paramString2 == null)
        {
          paramString1 = this.jdField_a_of_type_AndroidContentResResources.getString(2131693347);
        }
        else
        {
          paramString1 = this.jdField_a_of_type_ComTencentAvVideoController.a(paramString2);
          if (paramString1 == null)
          {
            paramString1 = mvg.a(paramString2, 4);
            if (paramString1 == null) {
              paramString1 = this.jdField_a_of_type_AndroidContentResResources.getString(2131693347);
            }
          }
          else
          {
            continue;
            if (paramInt1 == this.j) {
              break;
            }
            paramString2 = null;
            break;
          }
        }
      }
    }
  }
  
  public void b(long paramLong, int paramInt)
  {
    super.b(paramLong, paramInt);
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a().r())) {}
    for (;;)
    {
      return;
      boolean bool;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().c.size() > 0) {
        bool = ((lqq)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0)).b;
      }
      for (int i = ((lqq)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0)).jdField_a_of_type_Int; (bool) && (i != 0); i = 0)
      {
        mtq.b(i, paramInt);
        return;
        bool = true;
      }
    }
  }
  
  void b(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new MultiVideoCtrlLayerUI4Discussion.7(this, paramLong), 1000L);
  }
  
  public void b(String paramString, String[] paramArrayOfString)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new MultiVideoCtrlLayerUI4Discussion.5(this, paramString, paramArrayOfString), 1000L);
  }
  
  void c()
  {
    long l = AudioHelper.b();
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "createOrEnterVideo, mRelationId[" + this.jdField_b_of_type_Long + "], mIntentRelationId[" + this.jdField_a_of_type_Long + "], seq[" + l + "]");
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
        break label265;
      }
      localObject2 = ((Intent)localObject1).getParcelableArrayListExtra("invitelist");
      if ((localObject2 == null) || (((ArrayList)localObject2).size() <= 0)) {
        break label265;
      }
      localObject1 = new long[((ArrayList)localObject2).size()];
      localObject2 = ((ArrayList)localObject2).iterator();
      int i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject1[i] = AudioHelper.a(((ResultRecord)((Iterator)localObject2).next()).jdField_a_of_type_JavaLangString);
        i += 1;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.a().a;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_e_of_type_Int, this.jdField_b_of_type_Long, 0, (long[])localObject2, this.jdField_e_of_type_Boolean);
      this.jdField_c_of_type_Boolean = true;
      return;
      if (this.jdField_c_of_type_Int != 1) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a(l, this.jdField_e_of_type_Int, this.jdField_b_of_type_Long, null, this.jdField_e_of_type_Boolean);
      return;
      label265:
      localObject1 = null;
    }
  }
  
  protected boolean c()
  {
    int i = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_e_of_type_Int, Long.toString(this.jdField_b_of_type_Long));
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "isFull-->Discuss Num = " + i);
    }
    return i >= 100;
  }
  
  public void d()
  {
    super.d();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "OnCreate");
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lhe);
    b();
    f(0L, this.jdField_a_of_type_ComTencentAvVideoController.a().b());
    a();
  }
  
  public void d(long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onDestroy, seq[" + paramLong + "]");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lhe);
    super.d(paramLong);
  }
  
  void e()
  {
    if ((!this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131372597)) && (this.jdField_a_of_type_ComTencentAvVideoController != null))
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131372597, true);
      if (this.jdField_a_of_type_ComTencentAvVideoController.h()) {
        k(2131372597);
      }
    }
    else
    {
      return;
    }
    l(2131372597);
  }
  
  public void e(long paramLong, View paramView)
  {
    j(paramLong, 2131695815);
  }
  
  public void l(long paramLong)
  {
    g(true);
    if (this.jdField_a_of_type_Mkb != null) {
      this.jdField_a_of_type_Mkb.a(new mhw(this, paramLong));
    }
    do
    {
      return;
      super.B(paramLong);
      d(true);
      if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long, 102);
      }
      for (;;)
      {
        azqs.b(null, "CliOper", "", "", "0X8004CF2", "0X8004CF2", 0, 0, "", "", "", "");
        if (((this.f != 90) && (this.f != 270)) || (this.jdField_a_of_type_ComTencentAvVideoController.a().a() == -1) || (((lqq)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0)).jdField_a_of_type_Int != 1)) {
          break;
        }
        azqs.b(null, "CliOper", "", "", "0X8004CFB", "0X8004CFB", 0, 0, "", "", "", "");
        return;
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_e_of_type_Int, this.jdField_b_of_type_Long, 103);
      }
    } while (((this.f != 90) && (this.f != 270)) || (this.jdField_a_of_type_ComTencentAvVideoController.a().a() == -1) || (((lqq)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0)).jdField_a_of_type_Int != 2));
    azqs.b(null, "CliOper", "", "", "0X8004CFC", "0X8004CFC", 0, 0, "", "", "", "");
  }
  
  void n(long paramLong)
  {
    if (c()) {
      mdd.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1032, 2131696058);
    }
    for (;;)
    {
      j(paramLong, 2131695813);
      return;
      azqs.b(null, "CliOper", "", "", "0X8004CEC", "0X8004CEC", 0, 0, "", "", "", "");
      Object localObject = new Intent();
      ((Intent)localObject).setAction("tencent.video.v2q.AddContactsToDiscuss");
      ((Intent)localObject).putExtra("discussUin", Long.toString(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long));
      ((Intent)localObject).putExtra("notAcceptUserList", this.jdField_a_of_type_ComTencentAvVideoController.f());
      ((Intent)localObject).putExtra("notAcceptPhoneList", this.jdField_a_of_type_ComTencentAvVideoController.a().b);
      ((Intent)localObject).putExtra("selectNotAcceptFlag", false);
      ((Intent)localObject).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast((Intent)localObject);
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_g_of_type_Int = 1;
      if (mbt.f())
      {
        localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if ((localObject instanceof AVActivity))
        {
          localObject = ((AVActivity)localObject).a();
          if (localObject != null) {
            ((mbl)localObject).c();
          }
        }
      }
    }
  }
  
  protected void p()
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131559611);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion
 * JD-Core Version:    0.7.0.1
 */