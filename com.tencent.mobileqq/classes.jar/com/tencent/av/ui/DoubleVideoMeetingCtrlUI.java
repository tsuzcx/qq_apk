package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import azqs;
import bdin;
import com.tencent.av.VideoConstants.EmShareOps;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.screenshare.ScreenShareCtrl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import lek;
import lfb;
import lhe;
import lid;
import lqq;
import mbl;
import mbt;
import mcv;
import mdd;
import meu;
import mfk;
import mfl;
import mfm;
import mfo;
import mkb;
import mls;
import mqq.app.BaseActivity;
import mti;
import mvj;
import mvw;
import mwk;
import mww;

public class DoubleVideoMeetingCtrlUI
  extends VideoControlUI
{
  public long a;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  DoubleVideoMeetingCtrlUI.QueryPeerVideoRunnable jdField_a_of_type_ComTencentAvUiDoubleVideoMeetingCtrlUI$QueryPeerVideoRunnable = new DoubleVideoMeetingCtrlUI.QueryPeerVideoRunnable(this);
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  String jdField_a_of_type_JavaLangString = null;
  lhe jdField_a_of_type_Lhe = new mfl(this);
  mkb jdField_a_of_type_Mkb = null;
  mvj jdField_a_of_type_Mvj = null;
  boolean jdField_a_of_type_Boolean = false;
  public long b;
  String b;
  public boolean b;
  public boolean c;
  
  public DoubleVideoMeetingCtrlUI(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, meu parammeu)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, parammeu);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    this.jdField_b_of_type_Long = Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue();
    paramVideoAppInterface = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if ((paramVideoAppInterface.j) || (paramVideoAppInterface.k)) {
      paramVideoAppInterface.a(-1033L, "DoubleVideoMeetingCtrlUI", 4);
    }
    for (;;)
    {
      paramVideoAppInterface.i = 0;
      paramVideoAppInterface.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(0, paramVideoAppInterface.jdField_d_of_type_JavaLangString, null);
      return;
      paramVideoAppInterface.a(-1033L, "DoubleVideoMeetingCtrlUI", 3);
    }
  }
  
  private void r()
  {
    lid locallid = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (locallid.i == -1) {
      locallid.i = 0;
    }
    if (TextUtils.isEmpty(locallid.jdField_d_of_type_JavaLangString)) {
      locallid.jdField_d_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Long);
    }
    int i = locallid.i;
    String str1 = locallid.jdField_d_of_type_JavaLangString;
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str1, null, true, true);
    String str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i, str1, null);
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_d_of_type_JavaLangString, 2, "updateHeadBitmap, uinType[" + i + "], peerUin[" + str1 + "], name[" + str2 + "]");
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372639));
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372640));
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    if (!TextUtils.equals(this.jdField_a_of_type_AndroidWidgetTextView.getText().toString(), str2))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
      this.jdField_a_of_type_Mvj.a(locallid.jdField_c_of_type_JavaLangString, str2, localBitmap, String.valueOf(locallid.jdField_g_of_type_Long), 48, 0, locallid.jdField_d_of_type_Int);
    }
  }
  
  protected int a()
  {
    return 2131559555;
  }
  
  public int a(int paramInt)
  {
    DoubleVideoCtrlUI.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt);
    return 0;
  }
  
  void a()
  {
    lid locallid = this.jdField_a_of_type_ComTencentAvVideoController.a();
    boolean bool = locallid.k;
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "resumeVideo, remoteHasVideo[" + bool + "], displayViewList[" + locallid.jdField_c_of_type_JavaUtilArrayList.size() + "], seq[" + l + "], \nsessionInfo[" + locallid + "]");
    }
    if ((locallid.jdField_d_of_type_Int == 4) && (!locallid.j) && ((locallid.jdField_c_of_type_JavaUtilArrayList.size() == 0) || (!bool)))
    {
      locallid.a(l, "resumeVideo", 3);
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "resumeVideo, fix SessionType");
    }
    ArrayList localArrayList = new ArrayList();
    lqq locallqq = new lqq();
    locallqq.jdField_a_of_type_Long = Long.valueOf(locallid.jdField_d_of_type_JavaLangString).longValue();
    locallqq.jdField_a_of_type_Int = 1;
    localArrayList.add(locallqq);
    locallqq = new lqq();
    locallqq.jdField_a_of_type_Long = Long.valueOf(locallid.jdField_d_of_type_JavaLangString).longValue();
    locallqq.jdField_a_of_type_Int = 2;
    localArrayList.add(locallqq);
    this.jdField_b_of_type_Meu.update(null, new Object[] { Integer.valueOf(104), localArrayList });
    if ((locallid.a(this.jdField_b_of_type_Long, 1) == -1) || (locallid.j))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "Go On Stage ");
      }
      this.jdField_a_of_type_ComTencentAvVideoController.k();
    }
    if ((locallid.j) && (!locallid.k)) {
      this.jdField_c_of_type_Boolean = true;
    }
    if (locallid.jdField_c_of_type_JavaUtilArrayList.size() > 0) {
      e();
    }
    K();
  }
  
  void a(int paramInt)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "avSwitch, sessionType[" + paramInt + "], seq[" + l + "]");
    }
    View localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365410);
    AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    boolean bool1;
    if (paramInt == 3)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(0);
      }
      K();
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(false);
      if (localAVActivity == null) {
        break label336;
      }
      localAVActivity.b(true);
      localAVActivity.f(true);
      localAVActivity.c(false);
      bool1 = false;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 3) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        this.jdField_a_of_type_Mvw.c(bool2);
        this.jdField_a_of_type_Mvw.b(bool2);
        a(Boolean.valueOf(bool1));
        f(l, 65535);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(102) });
        return;
        if (paramInt != 4) {
          break label336;
        }
        localView.setBackgroundColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131167140));
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
          this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(8);
        }
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(true);
        if (localAVActivity != null)
        {
          localAVActivity.b(false);
          localAVActivity.f(false);
          localAVActivity.c(true);
        }
        bool1 = true;
        break;
      }
      label336:
      bool1 = false;
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onStart, seq[" + paramLong + "]");
    }
    super.a(paramLong);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "refreshUI, relationId[" + paramLong2 + "], friendUin[" + paramLong3 + "], refreshType[" + paramInt + "], isAVActivityBackground[" + this.jdField_a_of_type_ComTencentAvVideoController.a().ao + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().ao) {}
    DoubleVideoMeetingCtrlUI.RefreshUIRunnable localRefreshUIRunnable;
    AVActivity localAVActivity;
    do
    {
      return;
      localRefreshUIRunnable = new DoubleVideoMeetingCtrlUI.RefreshUIRunnable(this, paramLong1, paramInt, paramLong3, paramLong2);
      localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localAVActivity != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e(this.jdField_d_of_type_JavaLangString, 2, "refreshUI-->Can not get AVActivity");
    return;
    localAVActivity.runOnUiThread(localRefreshUIRunnable);
  }
  
  public void a(long paramLong, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick, id[" + AudioHelper.a(paramView, paramView.getId()) + "], seq[" + paramLong + "]");
    }
    lid locallid = this.jdField_a_of_type_ComTencentAvVideoController.a();
    String str = locallid.jdField_d_of_type_JavaLangString;
    switch (paramView.getId())
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_d_of_type_JavaLangString, 2, "Error View Id.ID=" + paramView.getId());
      }
    case 2131372581: 
    case 2131372583: 
    case 2131695809: 
    case 2131372899: 
    case 2131695813: 
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              d(paramLong, paramView);
              return;
              f(paramLong, paramView);
              return;
              QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.ADD_MEMBER");
              if (QLog.isColorLevel()) {
                QLog.i("double_2_multi", 2, "onClick in meeting");
              }
              DoubleVideoCtrlUI.a(a(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, true);
              super.C(paramLong);
              azqs.b(null, "CliOper", "", "", "0X8005205", "0X8005205", 0, 0, "", "", "", "");
            } while (!mbt.f());
            paramView = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          } while ((paramView == null) || (!(paramView instanceof AVActivity)));
          paramView = (AVActivity)paramView;
        } while (paramView == null);
        paramView = paramView.a();
      } while (paramView == null);
      paramView.c();
      return;
    case 2131364130: 
    case 2131365136: 
    case 2131372898: 
      P();
      return;
    case 2131372591: 
    case 2131372592: 
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.HANG_UP");
      g(true);
      a(paramLong, locallid, 1);
      return;
    case 2131372597: 
      c(paramLong, paramView);
      return;
    case 2131372589: 
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.HAND_FREE");
      this.jdField_a_of_type_Mwk.a(mwk.c);
      if ((locallid.O) && (locallid.a != null)) {
        azqs.b(null, "CliOper", "", "", "0X8005202", "0X8005202", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        super.C(paramLong);
        return;
        azqs.b(null, "CliOper", "", "", "0X8005201", "0X8005201", 0, 0, "", "", "", "");
      }
    case 2131372594: 
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "avideo onClick QavPanel.ViewID.HIDE");
      a();
      azqs.b(null, "CliOper", "", "", "0X8005207", "0X8005207", 0, 0, "", "", "", "");
      if (locallid.j)
      {
        azqs.b(null, "CliOper", "", "", "0X8005214", "0X8005214", 0, 0, "", "", "", "");
        return;
      }
      azqs.b(null, "CliOper", "", "", "0X8005217", "0X8005217", 0, 0, "", "", "", "");
      return;
    case 2131372903: 
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick, switch_camera, seq[" + paramLong + "]");
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(107), Long.valueOf(paramLong) });
      return;
    case 2131372596: 
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.LEAVE_MSG");
      int i = locallid.i;
      paramView = locallid.jdField_e_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvVideoController.a(i, str, paramView, null, true);
      return;
    case 2131695817: 
      g(paramLong, paramView);
      return;
    }
    e(paramLong, paramView);
  }
  
  public void a(long paramLong, ArrayList<lqq> paramArrayList)
  {
    if (paramArrayList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_d_of_type_JavaLangString, 2, "notifyShowVideo-->info list is null");
      }
      return;
    }
    int i = 0;
    for (;;)
    {
      if (i < paramArrayList.size())
      {
        if ((((lqq)paramArrayList.get(i)).jdField_a_of_type_Long == this.jdField_b_of_type_Long) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().j)) {
          paramArrayList.remove(i);
        }
      }
      else
      {
        this.jdField_b_of_type_Meu.update(null, new Object[] { Integer.valueOf(103), paramArrayList, Long.valueOf(paramLong) });
        if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0) {
          break;
        }
        a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
        return;
      }
      i += 1;
    }
  }
  
  @TargetApi(21)
  public void a(long paramLong, lid paramlid, int paramInt)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_d_of_type_JavaLangString, 2, "closeChat, from[" + paramInt + "], session[" + paramlid + "]");
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (localObject != null) {
      ((ScreenShareCtrl)localObject).a(VideoConstants.EmShareOps.STOP);
    }
    localObject = a();
    int i;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        ((mls)localObject).a(1);
      }
      localObject = this.jdField_a_of_type_Mkb;
      if ((paramlid.ao) || (localObject == null)) {
        break label250;
      }
      i = j;
      switch (paramInt)
      {
      default: 
        i = j;
      }
    }
    for (;;)
    {
      if (i == 0) {
        break label233;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoMeetingCtrlUI.4(this, paramLong, i), 1000L);
      return;
      localObject = ((AVActivity)localObject).a();
      break;
      paramlid.a(paramLong, 0L);
      i = 12;
      j(43);
      continue;
      paramlid.a(paramLong, 0L);
      j(3);
      i = 3;
    }
    label233:
    ((mkb)localObject).a(new mfo(this, paramLong, i));
    return;
    label250:
    d(paramLong, 0);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_d_of_type_JavaLangString, 2, "updateWhenCreateOrEnterRoomSuc, seq[" + paramLong + "], create[" + paramBoolean + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    lid locallid;
    do
    {
      return;
      locallid = this.jdField_a_of_type_ComTencentAvVideoController.a();
      locallid.c("onEnterRoomSuc", true);
      locallid.ak = true;
      if (TextUtils.isEmpty(locallid.jdField_d_of_type_JavaLangString)) {
        locallid.jdField_d_of_type_JavaLangString = String.valueOf(locallid.jdField_g_of_type_Long);
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a(3, 0, true, true, locallid.jdField_d_of_type_JavaLangString);
      q();
      AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localAVActivity != null) && (!localAVActivity.isFinishing())) {
        localAVActivity.runOnUiThread(new DoubleVideoMeetingCtrlUI.6(this, localAVActivity, paramBoolean, paramLong));
      }
    } while (!locallid.aF);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoMeetingCtrlUI.7(this, paramLong), 500L);
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onAfterOpenCamera, success[" + paramBoolean + "], preSessionType[" + paramInt + "], seq[" + paramLong + "]");
    }
    if (g()) {}
    do
    {
      lid locallid;
      do
      {
        do
        {
          return;
          locallid = this.jdField_a_of_type_ComTencentAvVideoController.a();
        } while (locallid.ao);
        f(paramLong, 65535);
        if (!paramBoolean) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_d_of_type_JavaLangString, 2, "Go On Stage onAfterOpenCamera");
        }
        this.jdField_a_of_type_ComTencentAvVideoController.k();
        if ((paramInt == 3) && (!locallid.O) && ("DEVICE_EARPHONE".equals(locallid.q))) {
          this.jdField_a_of_type_Mwk.d();
        }
      } while ((locallid.k) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null));
      a(locallid.jdField_d_of_type_Int);
      return;
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_d_of_type_JavaLangString, 2, "Open Camera Failed");
  }
  
  void a(long paramLong1, boolean paramBoolean, int paramInt, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "showOrClosePeerVideo, bShow[" + paramBoolean + "], videoSrcType[" + paramInt + "], friendUin[" + paramLong2 + "], seq[" + paramLong1 + "]");
    }
    a(paramLong1);
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().k) {
      f("showOrClosePeerVideo");
    }
    if (paramBoolean)
    {
      d("showOrClosePeerVideo");
      return;
    }
    lqq locallqq = new lqq();
    locallqq.jdField_a_of_type_Long = paramLong2;
    locallqq.jdField_a_of_type_Int = paramInt;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(locallqq);
    this.jdField_b_of_type_Meu.update(null, new Object[] { Integer.valueOf(104), localArrayList });
    if (paramInt == 2) {
      mdd.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() > 0)
    {
      d("showOrClosePeerVideo");
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong1, "showOrClosePeerVideo", false, true);
    a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "onVideoViewChange-->BigViewUin = " + paramString1 + " ,BigViewVideoSrcType = " + paramInt1 + " ,SmallViewUin = " + paramString2 + " ,SmallViewVideoSrcType = " + paramInt2);
    }
    long l1 = mti.a(paramString1);
    long l2 = mti.a(paramString2);
    if ((l1 == 0L) || (l2 == 0L)) {}
    do
    {
      do
      {
        return;
        if (paramInt1 == 2) {
          mdd.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036);
        }
        paramInt1 = this.jdField_a_of_type_ComTencentAvVideoController.a().a(l1, paramInt1);
        paramInt2 = this.jdField_a_of_type_ComTencentAvVideoController.a().a(l2, paramInt2);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_d_of_type_JavaLangString, 2, "onVideoViewChange-->BigViewIndex = " + paramInt1 + " ,SmallViewIndex = " + paramInt2);
        }
      } while ((paramInt1 == -1) || (paramInt2 == -1));
      paramString1 = (lqq)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(paramInt1);
      paramString2 = (lqq)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(paramInt2);
      paramString2.jdField_a_of_type_Boolean = true;
      paramString1.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.set(paramInt1, paramString2);
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.set(paramInt2, paramString1);
      if (QLog.isColorLevel())
      {
        ??? = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList);
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "onVideoViewChange finish" + (String)???);
      }
      synchronized (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList.set(paramInt1, paramString2);
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList.set(paramInt2, paramString1);
        this.jdField_a_of_type_ComTencentAvVideoController.a().c();
        ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a.a(paramString1.jdField_a_of_type_Long, paramString1.jdField_a_of_type_Int, paramString2.jdField_a_of_type_Long, paramString2.jdField_a_of_type_Int);
        e();
        if (l2 == this.jdField_b_of_type_Long)
        {
          azqs.b(null, "CliOper", "", "", "0X800520E", "0X800520E", 0, 0, "", "", "", "");
          return;
        }
      }
    } while (l2 != this.jdField_a_of_type_Long);
    azqs.b(null, "CliOper", "", "", "0X800520F", "0X800520F", 0, 0, "", "", "", "");
    if (this.jdField_b_of_type_Boolean)
    {
      azqs.b(null, "CliOper", "", "", "0X8005213", "0X8005213", 0, 0, "", "", "", "");
      return;
    }
    azqs.b(null, "CliOper", "", "", "0X8005212", "0X8005212", 0, 0, "", "", "", "");
  }
  
  void a(boolean paramBoolean)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "quitDoubleVideoMeeting, needAnimation[" + paramBoolean + "], seq[" + l + "]");
    }
    if (paramBoolean)
    {
      l();
      this.jdField_a_of_type_ComTencentAvVideoController.a(l, this.jdField_a_of_type_Long, false, 2);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public boolean a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), localObject, Boolean.valueOf(false) });
    if (!mbt.f()) {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4) && (this.jdField_a_of_type_ComTencentAvVideoController.a().j)) {
        super.a(2131695966, 1, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131298914));
      }
    }
    do
    {
      do
      {
        do
        {
          return false;
          localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        } while ((localObject == null) || (!(localObject instanceof AVActivity)));
        localObject = (AVActivity)localObject;
      } while (localObject == null);
      localObject = ((AVActivity)localObject).a();
    } while (localObject == null);
    ((mbl)localObject).a();
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 24: 
    case 25: 
      this.jdField_a_of_type_Mwk.a();
      return false;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().j)
    {
      azqs.b(null, "CliOper", "", "", "0X8005215", "0X8005215", 0, 0, "", "", "", "");
      return false;
    }
    azqs.b(null, "CliOper", "", "", "0X8005218", "0X8005218", 0, 0, "", "", "", "");
    return false;
  }
  
  boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() == 0)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, "checkRemoteHasVideo.1", false, true);
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() == 1) && (((lqq)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long == this.jdField_b_of_type_Long))
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, "checkRemoteHasVideo.2", false, true);
      return false;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, "checkRemoteHasVideo.3", true, true);
    return true;
  }
  
  void b()
  {
    super.b();
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131559608);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.e();
      Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localActivity != null)
      {
        this.jdField_a_of_type_Mwk = mwk.a();
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_Mwk);
        this.jdField_a_of_type_Mvw = mvw.a(this.jdField_a_of_type_Mvw, localActivity, this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_Mwk);
        this.jdField_a_of_type_Mvw.a(true);
        this.jdField_a_of_type_Mwk.a();
      }
    }
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372619));
    if ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "initUI-->activity is null");
      }
      b(true);
      return;
    }
    this.jdField_a_of_type_Mkb = new mkb((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentAvVideoController, 2, this.jdField_a_of_type_ComTencentAvUiQavPanel, this.jdField_c_of_type_AndroidWidgetRelativeLayout, null, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372638), this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372769), null);
  }
  
  void b(int paramInt)
  {
    if (paramInt > 0) {
      g(-1016L, paramInt);
    }
  }
  
  public void b(long paramLong)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onResume, seq[" + paramLong + "]");
    }
    super.b(paramLong);
    o();
    mvw localmvw;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().ao = false;
      this.jdField_a_of_type_ComTencentAvVideoController.a().an = false;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().K)
      {
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().l()) {
          super.A(paramLong);
        }
        localmvw = this.jdField_a_of_type_Mvw;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 3) {
          break label189;
        }
        bool1 = true;
        localmvw.c(bool1);
        localmvw = this.jdField_a_of_type_Mvw;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 3) {
          break label194;
        }
      }
    }
    label189:
    label194:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localmvw.b(bool1);
      a();
      c();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(0, this.jdField_a_of_type_JavaLangString);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void b(long paramLong, int paramInt)
  {
    a(paramLong, 360 - paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), String.valueOf(this.jdField_a_of_type_Long), Boolean.valueOf(paramBoolean) });
    if (this.jdField_a_of_type_Boolean) {
      p();
    }
  }
  
  protected boolean b()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    boolean bool1;
    boolean bool2;
    do
    {
      return false;
      bool1 = this.jdField_a_of_type_ComTencentAvVideoController.a().l();
      bool2 = this.jdField_a_of_type_ComTencentAvVideoController.a().m();
    } while ((!bool1) && (!bool2));
    return true;
  }
  
  void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "resumeUI");
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().K) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.h()) {
      super.k(2131372597);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
      return;
      super.l(2131372597);
    }
  }
  
  public void c(int paramInt)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "showToolBars, isAllOnstageMembersNotRecvData[" + this.jdField_a_of_type_ComTencentAvVideoController.a().r() + "], mToolbarDisplay[" + this.i + "], session[" + this.jdField_a_of_type_ComTencentAvVideoController.a() + "], seq[" + l + "]");
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().r())
    {
      super.e(paramInt);
      C(l);
    }
  }
  
  public void c(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onStop, seq[" + paramLong + "]");
    }
    super.c(paramLong);
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.a().ao = true;
    }
  }
  
  void c(long paramLong, View paramView)
  {
    if (a(paramLong, "android.permission.RECORD_AUDIO", null))
    {
      boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.h();
      q(bool);
      if (!bool) {
        break label119;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a("DoubleVideoMeetingCtrlUI.doMute.1", this.jdField_a_of_type_Long, true);
      super.l(2131372597);
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
      }
      azqs.b(null, "CliOper", "", "", "0X8005204", "0X8005204", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      super.C(paramLong);
      return;
      label119:
      this.jdField_a_of_type_ComTencentAvVideoController.a("DoubleVideoMeetingCtrlUI.doMute.2", this.jdField_a_of_type_Long, false);
      super.k(2131372597);
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
      }
      azqs.b(null, "CliOper", "", "", "0X8005203", "0X8005203", 0, 0, "", "", "", "");
    }
  }
  
  public void c(long paramLong, boolean paramBoolean)
  {
    if (g()) {
      return;
    }
    lid locallid = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (!locallid.k)
    {
      a(locallid.jdField_d_of_type_Int);
      return;
    }
    f(paramLong, 65535);
  }
  
  public void d()
  {
    if ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {}
    for (;;)
    {
      return;
      super.d();
      long l = AudioHelper.b();
      lid locallid = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onCreate, SessionType[" + locallid.jdField_d_of_type_Int + "], localHasVideo[" + locallid.j + "], seq[" + l + "]");
      }
      if (locallid.aE)
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_d_of_type_JavaLangString, 2, "onCreate, localMute[" + locallid.jdField_g_of_type_Boolean + "], localHasVideo[" + locallid.j + "], hasLocalVideoWhenSwitch[" + locallid.aF + "], deviceName[" + locallid.q + "]");
        }
        this.jdField_a_of_type_ComTencentAvVideoController.b("switch2DoubleMeeting_onCreate", locallid.jdField_g_of_type_Boolean);
      }
      b();
      f(l, locallid.aE);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lhe);
      this.jdField_a_of_type_JavaLangString = locallid.jdField_d_of_type_JavaLangString;
      try
      {
        this.jdField_a_of_type_Long = Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue();
        this.jdField_a_of_type_Mvj = mvj.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        l(l);
        r();
        if (this.jdField_a_of_type_Mkb == null) {
          continue;
        }
        this.jdField_a_of_type_Mkb.a();
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          lek.e(this.jdField_d_of_type_JavaLangString, localNumberFormatException.getMessage());
        }
      }
    }
  }
  
  public void d(int paramInt) {}
  
  public void d(long paramLong)
  {
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onDestroy, seq[" + paramLong + "]");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lhe);
    this.jdField_a_of_type_Mvw.c(false);
    this.jdField_a_of_type_Mvw.b(false);
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    }
    if (this.jdField_a_of_type_Mkb != null)
    {
      this.jdField_a_of_type_Mkb.b();
      this.jdField_a_of_type_Mkb = null;
    }
    super.d(paramLong);
  }
  
  public void d(long paramLong, int paramInt)
  {
    mwk.a().b(paramLong);
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().R) {
      super.C(paramLong);
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_a_of_type_Long, true, paramInt);
    super.B(paramLong);
    b(true);
    azqs.b(null, "CliOper", "", "", "0X8005206", "0X8005206", 0, 0, "", "", "", "");
  }
  
  void d(long paramLong, View paramView)
  {
    if (a(paramLong, "android.permission.CAMERA", null))
    {
      paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
      paramView.aF = false;
      if (paramView.j) {
        break label123;
      }
      i(paramLong);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(105), Boolean.valueOf(false), Long.valueOf(paramLong) });
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick, Open Camera, seq[" + paramLong + "]");
      }
    }
    for (;;)
    {
      C(paramLong);
      j(paramLong, 2131695809);
      return;
      label123:
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick, Close Camera, seq[" + paramLong + "]");
      }
      j(paramLong);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
      n(paramLong);
    }
  }
  
  void d(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvUiDoubleVideoMeetingCtrlUI$QueryPeerVideoRunnable.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiDoubleVideoMeetingCtrlUI$QueryPeerVideoRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvUiDoubleVideoMeetingCtrlUI$QueryPeerVideoRunnable, 1000L);
  }
  
  void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "showOrHideAcceptBtn-->isShow = " + paramBoolean);
    }
    if (this.jdField_a_of_type_Mcv != null) {
      this.jdField_a_of_type_Mcv.a(paramBoolean, new mfm(this));
    }
    if (paramBoolean)
    {
      mdd.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1030);
      return;
    }
    mdd.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1030);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "request peer video");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_d_of_type_JavaLangString, 2, "requestPeerVideo-->ERROR mVideoControl is NULL");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_d_of_type_JavaLangString, 2, "Peer VideoInfoList Size is null");
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a("Meeting_requestPeerVideo");
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaUtilArrayList.clear();
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size())
    {
      if (((lqq)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Long != this.jdField_b_of_type_Long) {
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(i));
      }
      i += 1;
    }
    d(false);
    this.jdField_a_of_type_ComTencentAvVideoController.a(false);
  }
  
  public void e(long paramLong, View paramView)
  {
    super.e(paramLong, paramView);
    mww.a("0x800AD8D");
  }
  
  public void e(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "addRequestVideoTimeoutRunnable,Function = " + paramString);
    }
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new DoubleVideoMeetingCtrlUI.RequestVideoTimeoutRunnale(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void f(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "removeRequestVideoTimeoutRunnbale-->Function = " + paramString);
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void g(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "onLayoutModeChange --> ScreenType = " + paramInt + " , hasSetBigVideoView = " + this.jdField_a_of_type_ComTencentAvVideoController.a().u());
    }
    Iterator localIterator;
    lqq locallqq;
    if (paramInt == 3)
    {
      if (4 == this.jdField_a_of_type_ComTencentAvVideoController.g())
      {
        localIterator = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          locallqq = (lqq)localIterator.next();
          if (!locallqq.jdField_a_of_type_Boolean) {
            locallqq.jdField_c_of_type_Boolean = true;
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() > 0) {
        ((lqq)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_Boolean = true;
      }
    }
    for (;;)
    {
      e();
      return;
      if (paramInt == 4)
      {
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().u()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() > 0))
        {
          ((lqq)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_d_of_type_JavaLangString, 2, "MultiVideoCtrlLayerUIBase onLayoutModeChange --> displayList  not has big one");
          }
        }
        if (4 == this.jdField_a_of_type_ComTencentAvVideoController.g())
        {
          localIterator = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext())
          {
            locallqq = (lqq)localIterator.next();
            if (!locallqq.jdField_a_of_type_Boolean) {
              locallqq.jdField_c_of_type_Boolean = true;
            }
          }
        }
        else if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() > 0)
        {
          ((lqq)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_Boolean = true;
        }
      }
    }
  }
  
  public void i(long paramLong)
  {
    f(paramLong, 65535);
  }
  
  public void j(long paramLong) {}
  
  void l()
  {
    super.G();
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_Mvp);
  }
  
  void l(long paramLong)
  {
    Object localObject = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "processExtraData-->can not get the activity");
      }
      b(true);
    }
    do
    {
      return;
      localObject = ((AVActivity)localObject).getIntent();
      boolean bool = false;
      if (localObject != null) {
        bool = ((Intent)localObject).getBooleanExtra("isEnter", false);
      }
      localObject = lfb.a(100, String.valueOf(this.jdField_a_of_type_Long), new int[0]);
      localObject = lfb.a().c((String)localObject);
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_d_of_type_JavaLangString, 2, "processExtraData uin[" + this.jdField_a_of_type_Long + "], info[" + localObject + "]");
      }
      if ((bool) || ((localObject != null) && (((lid)localObject).i())))
      {
        mwk.a().b(paramLong);
        mwk.a();
        mwk.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        if ((localObject != null) && (((lid)localObject).jdField_g_of_type_Int == 0))
        {
          b(true);
          return;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 3, this.jdField_a_of_type_Long, null, false);
        g(paramLong, 2131695976);
        return;
      }
    } while ((localObject != null) && (((lid)localObject).jdField_g_of_type_Int != 0));
    this.jdField_a_of_type_ComTencentAvVideoController.a(3, this.jdField_a_of_type_Long, 8, new long[] { this.jdField_a_of_type_Long }, false);
    g(paramLong, 2131696319);
  }
  
  void m()
  {
    g(true);
    if (this.jdField_a_of_type_Mkb != null) {
      this.jdField_a_of_type_Mkb.a(new mfk(this));
    }
  }
  
  public void m(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onPause, seq[" + paramLong + "], quit[" + this.jdField_a_of_type_Boolean + "]");
    }
    super.m(paramLong);
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().ao = true;
      this.jdField_a_of_type_ComTencentAvVideoController.a().an = true;
      if (((!mbt.f()) || ((!bdin.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().ap))) && (this.jdField_a_of_type_ComTencentAvVideoController.a().j))
      {
        this.jdField_a_of_type_ComTencentAvVideoController.v();
        this.jdField_b_of_type_Meu.update(null, new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131372903, 8);
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a().n = true;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().K) {
        super.B(paramLong);
      }
      f("OnPause");
      if ((this.jdField_a_of_type_Boolean) || (!mbt.f())) {
        this.jdField_a_of_type_ComTencentAvVideoController.a("Meeting_onPause");
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_b_of_type_Long, true, true);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c("DoubleVideoMeetingCtrlUI");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.h);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiDoubleVideoMeetingCtrlUI$QueryPeerVideoRunnable);
  }
  
  public void n(long paramLong)
  {
    this.jdField_a_of_type_ComTencentAvVideoController.v();
    f(paramLong, 65535);
  }
  
  public void o()
  {
    super.o();
    r();
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_d_of_type_JavaLangString, 2, "cancelNotification");
    }
    if (this.jdField_a_of_type_Mvj != null) {
      this.jdField_a_of_type_Mvj.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentAvVideoController.t();
  }
  
  public void q()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_d_of_type_JavaLangString, 2, "showNotification quit[" + this.jdField_a_of_type_Boolean + "], inMeetingRoom[" + this.jdField_a_of_type_ComTencentAvVideoController.a().K + "]");
        }
      } while ((this.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().K) || (lfb.a().a()));
      String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaLangString;
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString, null, true, true);
      this.jdField_a_of_type_Mvj.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, str, localBitmap, String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Long), 48, 0, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
    } while (this.jdField_a_of_type_Mvj == null);
    this.jdField_a_of_type_ComTencentAvVideoController.s();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoMeetingCtrlUI
 * JD-Core Version:    0.7.0.1
 */