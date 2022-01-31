package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.AVLog;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.SensorHelper;
import com.tencent.av.utils.TintStateDrawable;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import jtc;
import jtd;
import jte;
import jtf;
import jtg;
import jth;
import mqq.app.BaseActivity;

public class DoubleVideoMeetingCtrlUI
  extends VideoControlUI
{
  public long a;
  Button jdField_a_of_type_AndroidWidgetButton = null;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new jte(this);
  QavInOutAnimation jdField_a_of_type_ComTencentAvUiQavInOutAnimation = null;
  QAVNotification jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  String jdField_a_of_type_JavaLangString = null;
  jtf jdField_a_of_type_Jtf = new jtf(this);
  public boolean a;
  public long b;
  TextView jdField_b_of_type_AndroidWidgetTextView = null;
  String jdField_b_of_type_JavaLangString = null;
  public boolean b;
  TextView c;
  public boolean c;
  
  public DoubleVideoMeetingCtrlUI(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, ControlUIObserver paramControlUIObserver)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, paramControlUIObserver);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_Long = Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue();
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int = 3;
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int = 0;
    paramVideoAppInterface = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(0, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, null);
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString = paramVideoAppInterface;
  }
  
  void A()
  {
    this.g = this.i;
  }
  
  public void D()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "request peer video");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "requestPeerVideo-->ERROR mVideoControl is NULL");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "Peer VideoInfoList Size is null");
      }
      this.jdField_a_of_type_ComTencentAvVideoController.f();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList.clear();
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size())
    {
      if (((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Long != this.jdField_b_of_type_Long) {
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(i));
      }
      i += 1;
    }
    h(false);
    this.jdField_a_of_type_ComTencentAvVideoController.e();
  }
  
  public int a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(38, paramInt);
    }
    return 0;
  }
  
  void a()
  {
    Object localObject = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "processExtraData-->can not get the activity");
      }
      d(true);
    }
    for (;;)
    {
      return;
      localObject = ((AVActivity)localObject).getIntent();
      if (localObject != null) {}
      for (boolean bool = ((Intent)localObject).getBooleanExtra("isEnter", false); bool; bool = false)
      {
        TraeHelper.a().a("DoubleVideoMeetingCtrlUI.processExtraData");
        TraeHelper.a();
        TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        localObject = SessionMgr.a().a(SessionMgr.a(100, String.valueOf(this.jdField_a_of_type_Long), new int[0]));
        if ((localObject != null) && (((SessionInfo)localObject).jdField_g_of_type_Int == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.e(this.jdField_c_of_type_JavaLangString, 2, "Wrong state, finish activity");
          }
          d(true);
        }
        for (;;)
        {
          localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131428977);
          this.i.setText((CharSequence)localObject);
          return;
          this.jdField_a_of_type_ComTencentAvVideoController.a(3, this.jdField_a_of_type_Long, null, false);
        }
      }
    }
  }
  
  void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "avSwitch sessionType = " + paramInt);
    }
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365934);
    AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramInt == 3)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.g.setVisibility(0);
      if (this.d != null) {
        this.d.setBackgroundDrawable(null);
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.b(0);
      }
      i(0);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(false);
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(false);
      }
      if (localAVActivity != null)
      {
        localAVActivity.b(true);
        localAVActivity.d(true);
        localAVActivity.c(false);
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().Q) {
          super.t(2131365399);
        }
        localObject = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 3) {
          break label416;
        }
        bool = true;
        label224:
        ((SensorHelper)localObject).c(bool);
        localObject = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 3) {
          break label421;
        }
      }
    }
    label416:
    label421:
    for (boolean bool = true;; bool = false)
    {
      ((SensorHelper)localObject).b(bool);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(102) });
      b(false);
      return;
      if (paramInt != 4) {
        break;
      }
      ((View)localObject).setBackgroundColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131492924));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (this.d != null) {
        this.d.setBackgroundResource(2130840340);
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.g.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.b(8);
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(true);
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(true);
      }
      if (localAVActivity == null) {
        break;
      }
      localAVActivity.b(false);
      localAVActivity.d(false);
      localAVActivity.c(true);
      break;
      bool = false;
      break label224;
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "refreshUI-->relationId=" + paramLong1 + " ,friendUin=" + paramLong2 + " ,refreshType=" + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().ar) {}
    jtg localjtg;
    AVActivity localAVActivity;
    do
    {
      return;
      localjtg = new jtg(this, paramInt, paramLong2, paramLong1);
      localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localAVActivity != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e(this.jdField_c_of_type_JavaLangString, 2, "refreshUI-->Can not get AVActivity");
    return;
    localAVActivity.runOnUiThread(localjtg);
  }
  
  public void a(Intent paramIntent) {}
  
  public void a(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "OnClick-->VideoController is null");
      }
    }
    String str;
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
                do
                {
                  return;
                  str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
                  switch (paramView.getId())
                  {
                  }
                } while (!QLog.isColorLevel());
                QLog.e(this.jdField_c_of_type_JavaLangString, 2, "Error View Id.ID=" + paramView.getId());
                return;
                QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick R.id.qav_btn_accept_video");
                D();
                this.jdField_a_of_type_ComTencentAvVideoController.a().as = true;
                return;
                QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.CAMERA");
                if (!this.jdField_a_of_type_ComTencentAvVideoController.a().f)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d(this.jdField_c_of_type_JavaLangString, 2, "Open Camera");
                  }
                  v();
                  this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(105), Boolean.valueOf(false) });
                }
                for (;;)
                {
                  super.ad();
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d(this.jdField_c_of_type_JavaLangString, 2, "Close Camera");
                  }
                  w();
                  this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106) });
                  x();
                }
                QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.ADD_MEMBER");
                paramView = new Intent();
                paramView.setAction("tencent.video.v2q.AddContactsFromC2C");
                paramView.putExtra("peerUin", str);
                paramView.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
                this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(paramView);
                super.ad();
                ReportController.b(null, "CliOper", "", "", "0X8005205", "0X8005205", 0, 0, "", "", "", "");
              } while (!SmallScreenUtils.b());
              paramView = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
            } while ((paramView == null) || (!(paramView instanceof AVActivity)));
            paramView = (AVActivity)paramView;
          } while (paramView == null);
          paramView = paramView.a();
        } while (paramView == null);
        paramView.c();
        return;
        QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick R.id.qav_titlebar_mid_txt");
        if (this.k - this.m > 2)
        {
          this.m = this.k;
          this.l = 0;
        }
        this.l += 1;
      } while (this.l <= 5);
      super.m(true);
      return;
      QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.HANG_UP");
      if (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null)
      {
        this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a(new jtd(this));
        return;
      }
      TraeHelper.a().a("DoubleVideoMeetingCtrlUI.onOutAnimationEnd_2");
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().Q) {
        super.ad();
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_Long, true, 0);
      super.aa();
      d(true);
      ReportController.b(null, "CliOper", "", "", "0X8005206", "0X8005206", 0, 0, "", "", "", "");
      return;
      QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.MUTE");
      y();
      super.ad();
      return;
      QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.HAND_FREE");
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.e();
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().N) && (this.jdField_a_of_type_ComTencentAvVideoController.a().a != null)) {
        ReportController.b(null, "CliOper", "", "", "0X8005202", "0X8005202", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        super.ad();
        return;
        ReportController.b(null, "CliOper", "", "", "0X8005201", "0X8005201", 0, 0, "", "", "", "");
      }
      QLog.d(this.jdField_c_of_type_JavaLangString, 1, "avideo onClick QavPanel.VIEW_ENUM.HIDE");
      a();
      ReportController.b(null, "CliOper", "", "", "0X8005207", "0X8005207", 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().f)
      {
        ReportController.b(null, "CliOper", "", "", "0X8005214", "0X8005214", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X8005217", "0X8005217", 0, 0, "", "", "", "");
      return;
      QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick qav_titlebar_switchcamera");
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(107) });
      return;
      QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.VIEW_ENUM.LEAVE_MSG");
    } while (this.jdField_a_of_type_ComTencentAvVideoController == null);
    int i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int;
    paramView = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentAvVideoController.a(i, str, paramView, null, true);
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onVideoViewChange-->BigViewUin = " + paramString1 + " ,BigViewVideoSrcType = " + paramInt1 + " ,SmallViewUin = " + paramString2 + " ,SmallViewVideoSrcType = " + paramInt2);
    }
    if ((paramString1 == null) || (paramString2 == null)) {}
    long l2;
    do
    {
      do
      {
        do
        {
          return;
        } while (super.g());
        if (paramInt1 == 2)
        {
          TipsManager.c(106);
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(106);
        }
        long l1 = Long.valueOf(paramString1).longValue();
        l2 = Long.valueOf(paramString2).longValue();
        paramInt1 = this.jdField_a_of_type_ComTencentAvVideoController.a().a(l1, paramInt1);
        paramInt2 = this.jdField_a_of_type_ComTencentAvVideoController.a().a(l2, paramInt2);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onVideoViewChange-->BigViewIndex = " + paramInt1 + " ,SmallViewIndex = " + paramInt2);
        }
      } while ((paramInt1 == -1) || (l2 == -1L));
      paramString1 = (VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(paramInt1);
      paramString2 = (VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(paramInt2);
      paramString2.jdField_a_of_type_Boolean = true;
      paramString1.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.set(paramInt1, paramString2);
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.set(paramInt2, paramString1);
      D();
      if (l2 == this.jdField_b_of_type_Long)
      {
        ReportController.b(null, "CliOper", "", "", "0X800520E", "0X800520E", 0, 0, "", "", "", "");
        return;
      }
    } while (l2 != this.jdField_a_of_type_Long);
    ReportController.b(null, "CliOper", "", "", "0X800520F", "0X800520F", 0, 0, "", "", "", "");
    if (this.jdField_b_of_type_Boolean)
    {
      ReportController.b(null, "CliOper", "", "", "0X8005213", "0X8005213", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X8005212", "0X8005212", 0, 0, "", "", "", "");
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "notifyShowVideo-->info list is null");
      }
      return;
    }
    int i = 0;
    for (;;)
    {
      if (i < paramArrayList.size())
      {
        if ((((VideoViewInfo)paramArrayList.get(i)).jdField_a_of_type_Long == this.jdField_b_of_type_Long) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().f)) {
          paramArrayList.remove(i);
        }
      }
      else
      {
        this.jdField_b_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(103), paramArrayList });
        if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0) {
          break;
        }
        a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
        return;
      }
      i += 1;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "show or close peer video, friendUin = " + paramLong + " ,video srouce type = " + paramInt + " ,bShow = " + paramBoolean);
    }
    b();
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean) {
      i("showOrClosePeerVideo");
    }
    if (paramBoolean)
    {
      g("showOrClosePeerVideo");
      return;
    }
    VideoViewInfo localVideoViewInfo = new VideoViewInfo();
    localVideoViewInfo.jdField_a_of_type_Long = paramLong;
    localVideoViewInfo.jdField_a_of_type_Int = paramInt;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localVideoViewInfo);
    this.jdField_b_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(104), localArrayList });
    if (paramInt == 2)
    {
      TipsManager.c(106);
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(106);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() > 0)
    {
      g("showOrClosePeerVideo");
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().a(false, true);
    a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
  }
  
  public boolean a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), localObject, Boolean.valueOf(false) });
    if (!SmallScreenUtils.b()) {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4) && (this.jdField_a_of_type_ComTencentAvVideoController.a().f)) {
        super.a(2131429114, 1, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131558448));
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
    ((SmallScreenActivityPlugin)localObject).a();
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
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
      return false;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().f)
    {
      ReportController.b(null, "CliOper", "", "", "0X8005215", "0X8005215", 0, 0, "", "", "", "");
      return false;
    }
    ReportController.b(null, "CliOper", "", "", "0X8005218", "0X8005218", 0, 0, "", "", "", "");
    return false;
  }
  
  void b()
  {
    super.q(2130969279);
    super.b();
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(8);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.e();
      localObject = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper = TraeHelper.a();
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_ComTencentAvUtilsTraeHelper);
        this.jdField_a_of_type_ComTencentAvUtilsSensorHelper = SensorHelper.a(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper, (Activity)localObject, this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_ComTencentAvUtilsTraeHelper);
        this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a(true);
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
      }
    }
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365383));
    Object localObject = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "initUI-->activity is null");
      }
      d(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365365));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365367));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131362754));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)((AVActivity)localObject).findViewById(2131365837));
    TintStateDrawable.a(this.jdField_a_of_type_AndroidWidgetButton, 2130840162, 2131494051);
    this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = new QavInOutAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentAvVideoController, 2, this.jdField_a_of_type_ComTencentAvUiQavPanel, this.d, null, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365936), this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365377), null);
  }
  
  protected void b(String paramString)
  {
    super.b(paramString);
    b(true);
  }
  
  @TargetApi(11)
  void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_a_of_type_ComTencentAvVideoController == null)) {
      return;
    }
    int j = UITools.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    int k = UITools.b((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)((ProgressBar)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131364245)).getLayoutParams();
    localLayoutParams1 = (LinearLayout.LayoutParams)((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131365830)).getLayoutParams();
    localLayoutParams1 = (LinearLayout.LayoutParams)((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131364246)).getLayoutParams();
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {}
    for (int i = this.jdField_a_of_type_ComTencentAvUiQavPanel.a();; i = 0)
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4) && (!paramBoolean)) {
        if (Build.VERSION.SDK_INT < 11) {
          break label360;
        }
      }
      label360:
      for (float f = this.jdField_a_of_type_AndroidWidgetLinearLayout.getRotation();; f = 0.0F)
      {
        if (f % 180.0F == 0.0F)
        {
          localLayoutParams.addRule(10, -1);
          localLayoutParams.addRule(13, 0);
          localLayoutParams.topMargin = (k / 3);
          localLayoutParams.height = -2;
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
          return;
          localLayoutParams.addRule(12, 0);
          localLayoutParams.addRule(13, -1);
          localLayoutParams.bottomMargin = 0;
          localLayoutParams.height = (j * 23 / 25);
          continue;
          localLayoutParams.addRule(12);
          localLayoutParams.addRule(13, 0);
          localLayoutParams.height = -2;
          if (j <= 320) {
            localLayoutParams.bottomMargin = (i + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559884));
          } else if (j <= 480) {
            localLayoutParams.bottomMargin = (i + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559883));
          } else {
            localLayoutParams.bottomMargin = (i + this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559882));
          }
        }
      }
    }
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onAfterOpenCamera success: " + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_ComTencentAvVideoController.a().ar);
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
        {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365399, true);
          this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365399, true);
        }
        if (!paramBoolean) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_c_of_type_JavaLangString, 2, "Go On Stage onAfterOpenCamera");
        }
        this.jdField_a_of_type_ComTencentAvVideoController.k();
        if ((this.jdField_b_of_type_AndroidWidgetImageButton != null) && (this.n > 1)) {
          this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
        }
        super.s(2131365399);
        if ((paramInt == 3) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().N) && ("DEVICE_EARPHONE".equals(this.jdField_a_of_type_ComTencentAvVideoController.a().o))) {
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.e();
        }
      } while ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null));
      a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
      return;
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_c_of_type_JavaLangString, 2, "Open Camera Failed");
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.b(paramBoolean1, paramBoolean2);
  }
  
  boolean b()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() == 0)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(false, true);
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() == 1) && (((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long == this.jdField_b_of_type_Long))
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(false, true);
      return false;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().a(true, true);
    return true;
  }
  
  void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "refreshVideo");
    }
    ArrayList localArrayList = new ArrayList();
    VideoViewInfo localVideoViewInfo = new VideoViewInfo();
    localVideoViewInfo.jdField_a_of_type_Long = Long.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString).longValue();
    localVideoViewInfo.jdField_a_of_type_Int = 1;
    localArrayList.add(localVideoViewInfo);
    localVideoViewInfo = new VideoViewInfo();
    localVideoViewInfo.jdField_a_of_type_Long = Long.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString).longValue();
    localVideoViewInfo.jdField_a_of_type_Int = 2;
    localArrayList.add(localVideoViewInfo);
    this.jdField_b_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(104), localArrayList });
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_b_of_type_Long, 1) == -1) || (this.jdField_a_of_type_ComTencentAvVideoController.a().f))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "Go On Stage ");
      }
      this.jdField_a_of_type_ComTencentAvVideoController.k();
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().f) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean)) {
      this.jdField_c_of_type_Boolean = true;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean)
    {
      D();
      z();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      s();
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_Long, false, 2);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void c_(boolean paramBoolean)
  {
    super.m(paramBoolean);
  }
  
  public void d()
  {
    if ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {}
    for (;;)
    {
      return;
      super.d();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onCreate SessionType = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int + ", localHasVideo = " + this.jdField_a_of_type_ComTencentAvVideoController.a().f);
      }
      b();
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.c();
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(this.e);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
      try
      {
        this.jdField_a_of_type_Long = Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue();
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        a();
        e();
        A();
        b(true);
        i(true);
        if (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a();
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          AVLog.e(this.jdField_c_of_type_JavaLangString, localNumberFormatException.getMessage());
        }
      }
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), String.valueOf(this.jdField_a_of_type_Long), Boolean.valueOf(paramBoolean) });
  }
  
  void e()
  {
    int i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Int;
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str, null, true, true);
    str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i, str, null);
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365375));
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365376));
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
  }
  
  void e(String paramString)
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onStart");
    }
    super.f();
  }
  
  void f(String paramString)
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
      UITools.a(this.jdField_c_of_type_AndroidWidgetTextView, paramString);
    }
  }
  
  public void g()
  {
    boolean bool2 = true;
    super.g();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onResume");
    }
    SensorHelper localSensorHelper;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().ar = false;
      this.jdField_a_of_type_ComTencentAvVideoController.a().aq = false;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().H)
      {
        super.Z();
        localSensorHelper = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 3) {
          break label180;
        }
        bool1 = true;
        localSensorHelper.c(bool1);
        localSensorHelper = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 3) {
          break label185;
        }
      }
    }
    label180:
    label185:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localSensorHelper.b(bool1);
      c();
      n();
      this.jdField_a_of_type_ComTencentAvVideoController.x();
      if ((this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null) && (this.jdField_a_of_type_ComTencentAvVideoController != null)) {
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(0, this.jdField_a_of_type_JavaLangString);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void g(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "showToolBars");
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().k())
    {
      super.i(paramInt);
      ad();
    }
  }
  
  void g(String paramString)
  {
    this.jdField_a_of_type_Jtf.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Jtf);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_Jtf, 1000L);
  }
  
  public void g(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean) {
      a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
    }
  }
  
  public void h()
  {
    super.h();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onPause");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().ar = true;
      this.jdField_a_of_type_ComTencentAvVideoController.a().aq = true;
      if (((!SmallScreenUtils.b()) || ((!NetworkUtil.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().as))) && (this.jdField_a_of_type_ComTencentAvVideoController.a().f))
      {
        this.jdField_a_of_type_ComTencentAvVideoController.z();
        this.jdField_b_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(106) });
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_i_of_type_Boolean = true;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().H) {
        super.aa();
      }
      i("OnPause");
      this.jdField_a_of_type_ComTencentAvVideoController.f();
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_b_of_type_Long, true, true);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c("DoubleVideoMeetingCtrlUI");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.j);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_Jtf);
  }
  
  public void h(int paramInt) {}
  
  public void h(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "addRequestVideoTimeoutRunnable,Function = " + paramString);
    }
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new jth(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void h(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "showOrHideAcceptBtn-->isShow = " + paramBoolean);
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      String str = this.jdField_a_of_type_AndroidContentResResources.getString(2131428705);
      TipsManager.a(107, str);
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(107, str, false);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    TipsManager.c(107);
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(107);
  }
  
  public void i(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "removeRequestVideoTimeoutRunnbale-->Function = " + paramString);
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  void i(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365936);
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    if (paramBoolean)
    {
      int i = 0;
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
        i = UITools.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      }
      if (i <= 320)
      {
        localLayoutParams1.topMargin = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560033);
        localLayoutParams2.width = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560036);
        localLayoutParams2.height = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560036);
      }
      for (;;)
      {
        localRelativeLayout.setLayoutParams(localLayoutParams1);
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams2);
        return;
        if (i <= 480)
        {
          localLayoutParams1.topMargin = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560032);
          localLayoutParams2.width = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560035);
          localLayoutParams2.height = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560035);
        }
        else
        {
          localLayoutParams1.topMargin = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560031);
          localLayoutParams2.width = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560034);
          localLayoutParams2.height = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131560034);
        }
      }
    }
    localLayoutParams1.topMargin = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559866);
    localRelativeLayout.setLayoutParams(localLayoutParams1);
    localLayoutParams2.width = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559842);
    localLayoutParams2.height = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559842);
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams2);
  }
  
  public void j()
  {
    super.j();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onStop");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().ar = true;
      if ((!this.jdField_a_of_type_Boolean) && (!SessionMgr.a().a()))
      {
        String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
        Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, null, true, true);
        if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null)
        {
          this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_JavaLangString, str, localBitmap, this.jdField_a_of_type_ComTencentAvVideoController.a().q, 48, 0, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
          this.jdField_a_of_type_ComTencentAvVideoController.w();
        }
      }
    }
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onDestory");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(false);
    this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(false);
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.b();
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = null;
    }
    super.k();
  }
  
  public void m() {}
  
  void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "resumeUI");
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().H) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.h())
    {
      super.s(2131365397);
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().f) {
        break label93;
      }
      super.s(2131365399);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
      return;
      super.t(2131365397);
      break;
      label93:
      super.t(2131365399);
    }
  }
  
  public void q() {}
  
  void s()
  {
    super.ac();
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation);
  }
  
  void t()
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null) {
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a(new jtc(this));
    }
  }
  
  public void v()
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365399, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365399, false);
    }
  }
  
  public void w() {}
  
  public void x()
  {
    this.jdField_a_of_type_ComTencentAvVideoController.z();
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(4);
    super.t(2131365399);
    super.a(2131365399, true);
  }
  
  void y()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "pressMuteBtn");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.h())
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a("DoubleVideoMeetingCtrlUI.pressMuteBtn.1", this.jdField_a_of_type_Long, true);
      super.t(2131365397);
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
      }
      ReportController.b(null, "CliOper", "", "", "0X8005204", "0X8005204", 0, 0, "", "", "", "");
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a("DoubleVideoMeetingCtrlUI.pressMuteBtn.2", this.jdField_a_of_type_Long, false);
    super.s(2131365397);
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
    }
    ReportController.b(null, "CliOper", "", "", "0X8005203", "0X8005203", 0, 0, "", "", "", "");
  }
  
  public void z()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "displayToolBar");
    }
    if (!super.g())
    {
      s(false);
      super.i(0);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoMeetingCtrlUI
 * JD-Core Version:    0.7.0.1
 */