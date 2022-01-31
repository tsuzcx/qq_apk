package com.tencent.av.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import awqx;
import badq;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import krx;
import ksn;
import kur;
import kvq;
import leb;
import loj;
import lor;
import lpt;
import lqb;
import lru;
import lsh;
import lsi;
import lsj;
import lsk;
import lwx;
import mht;
import mig;
import miu;
import mqq.app.BaseActivity;

public class DoubleVideoMeetingCtrlUI
  extends VideoControlUI
{
  public long a;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  DoubleVideoMeetingCtrlUI.QueryPeerVideoRunnable jdField_a_of_type_ComTencentAvUiDoubleVideoMeetingCtrlUI$QueryPeerVideoRunnable = new DoubleVideoMeetingCtrlUI.QueryPeerVideoRunnable(this);
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  String jdField_a_of_type_JavaLangString = null;
  kur jdField_a_of_type_Kur = new lsj(this);
  lwx jdField_a_of_type_Lwx = null;
  mht jdField_a_of_type_Mht = null;
  public boolean a;
  public long b;
  String b;
  public boolean b;
  public boolean c;
  
  public DoubleVideoMeetingCtrlUI(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, lru paramlru)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, paramlru);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    this.jdField_b_of_type_Long = Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue();
    this.jdField_a_of_type_ComTencentAvVideoController.a().a(-1033L, "DoubleVideoMeetingCtrlUI", 3);
    this.jdField_a_of_type_ComTencentAvVideoController.a().i = 0;
    paramVideoAppInterface = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(0, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString, null);
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaLangString = paramVideoAppInterface;
  }
  
  protected int a()
  {
    return 2131493936;
  }
  
  public int a(int paramInt)
  {
    DoubleVideoCtrlUI.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt);
    return 0;
  }
  
  void a()
  {
    kvq localkvq = this.jdField_a_of_type_ComTencentAvVideoController.a();
    boolean bool = localkvq.k;
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "resumeVideo, remoteHasVideo[" + bool + "], displayViewList[" + localkvq.jdField_c_of_type_JavaUtilArrayList.size() + "], seq[" + l + "], \nsessionInfo[" + localkvq + "]");
    }
    if ((localkvq.jdField_d_of_type_Int == 4) && (!localkvq.j) && ((localkvq.jdField_c_of_type_JavaUtilArrayList.size() == 0) || (!bool)))
    {
      localkvq.a(l, "resumeVideo", 3);
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "resumeVideo, fix SessionType");
    }
    ArrayList localArrayList = new ArrayList();
    leb localleb = new leb();
    localleb.jdField_a_of_type_Long = Long.valueOf(localkvq.jdField_d_of_type_JavaLangString).longValue();
    localleb.jdField_a_of_type_Int = 1;
    localArrayList.add(localleb);
    localleb = new leb();
    localleb.jdField_a_of_type_Long = Long.valueOf(localkvq.jdField_d_of_type_JavaLangString).longValue();
    localleb.jdField_a_of_type_Int = 2;
    localArrayList.add(localleb);
    this.jdField_b_of_type_Lru.update(null, new Object[] { Integer.valueOf(104), localArrayList });
    if ((localkvq.a(this.jdField_b_of_type_Long, 1) == -1) || (localkvq.j))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "Go On Stage ");
      }
      this.jdField_a_of_type_ComTencentAvVideoController.k();
    }
    if ((localkvq.j) && (!localkvq.k)) {
      this.jdField_c_of_type_Boolean = true;
    }
    if (localkvq.jdField_c_of_type_JavaUtilArrayList.size() > 0) {
      p();
    }
    K();
  }
  
  void a(int paramInt)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "avSwitch, sessionType[" + paramInt + "], seq[" + l + "]");
    }
    View localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131299756);
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
        break label334;
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
        this.jdField_a_of_type_Mig.c(bool2);
        this.jdField_a_of_type_Mig.b(bool2);
        a(Boolean.valueOf(bool1));
        f(l, 65535);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(102) });
        return;
        if (paramInt != 4) {
          break label334;
        }
        localView.setBackgroundColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131101491));
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
      label334:
      bool1 = false;
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onStart, seq[" + paramLong + "]");
    }
    super.a(paramLong);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "refreshUI, relationId[" + paramLong2 + "], friendUin[" + paramLong3 + "], refreshType[" + paramInt + "], isAVActivityBackground[" + this.jdField_a_of_type_ComTencentAvVideoController.a().an + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().an) {}
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
    QLog.e(this.jdField_c_of_type_JavaLangString, 2, "refreshUI-->Can not get AVActivity");
    return;
    localAVActivity.runOnUiThread(localRefreshUIRunnable);
  }
  
  public void a(long paramLong, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClick, id[" + AudioHelper.a(paramView, paramView.getId()) + "], seq[" + paramLong + "]");
    }
    kvq localkvq = this.jdField_a_of_type_ComTencentAvVideoController.a();
    String str = localkvq.jdField_d_of_type_JavaLangString;
    switch (paramView.getId())
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_c_of_type_JavaLangString, 2, "Error View Id.ID=" + paramView.getId());
      }
    case 2131306501: 
    case 2131306503: 
    case 2131629967: 
    case 2131306805: 
    case 2131629971: 
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
              e(paramLong, paramView);
              return;
              QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.ADD_MEMBER");
              if (QLog.isColorLevel()) {
                QLog.i("double_2_multi", 2, "onClick in meeting");
              }
              DoubleVideoCtrlUI.a(a(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, true);
              super.y(paramLong);
              awqx.b(null, "CliOper", "", "", "0X8005205", "0X8005205", 0, 0, "", "", "", "");
            } while (!lor.f());
            paramView = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          } while ((paramView == null) || (!(paramView instanceof AVActivity)));
          paramView = (AVActivity)paramView;
        } while (paramView == null);
        paramView = paramView.a();
      } while (paramView == null);
      paramView.c();
      return;
    case 2131298509: 
    case 2131299482: 
    case 2131306804: 
      P();
      return;
    case 2131306511: 
    case 2131306512: 
      QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.HANG_UP");
      g(true);
      if (this.jdField_a_of_type_Lwx != null)
      {
        this.jdField_a_of_type_Lwx.a(new lsi(this, paramLong));
        return;
      }
      miu.a().b(paramLong);
      if (!localkvq.Q) {
        super.y(paramLong);
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_a_of_type_Long, true, 0);
      super.x(paramLong);
      b(true);
      awqx.b(null, "CliOper", "", "", "0X8005206", "0X8005206", 0, 0, "", "", "", "");
      return;
    case 2131306517: 
      c(paramLong, paramView);
      return;
    case 2131306509: 
      QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.HAND_FREE");
      this.jdField_a_of_type_Miu.d();
      if ((localkvq.N) && (localkvq.a != null)) {
        awqx.b(null, "CliOper", "", "", "0X8005202", "0X8005202", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        super.y(paramLong);
        return;
        awqx.b(null, "CliOper", "", "", "0X8005201", "0X8005201", 0, 0, "", "", "", "");
      }
    case 2131306514: 
      QLog.d(this.jdField_c_of_type_JavaLangString, 1, "avideo onClick QavPanel.ViewID.HIDE");
      a();
      awqx.b(null, "CliOper", "", "", "0X8005207", "0X8005207", 0, 0, "", "", "", "");
      if (localkvq.j)
      {
        awqx.b(null, "CliOper", "", "", "0X8005214", "0X8005214", 0, 0, "", "", "", "");
        return;
      }
      awqx.b(null, "CliOper", "", "", "0X8005217", "0X8005217", 0, 0, "", "", "", "");
      return;
    case 2131306809: 
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClick, switch_camera, seq[" + paramLong + "]");
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(107), Long.valueOf(paramLong) });
      return;
    case 2131306516: 
      QLog.d(this.jdField_c_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.LEAVE_MSG");
      int i = localkvq.i;
      paramView = localkvq.jdField_e_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvVideoController.a(i, str, paramView, null, true);
      return;
    }
    f(paramLong, paramView);
  }
  
  public void a(long paramLong, ArrayList<leb> paramArrayList)
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
        if ((((leb)paramArrayList.get(i)).jdField_a_of_type_Long == this.jdField_b_of_type_Long) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().j)) {
          paramArrayList.remove(i);
        }
      }
      else
      {
        this.jdField_b_of_type_Lru.update(null, new Object[] { Integer.valueOf(103), paramArrayList, Long.valueOf(paramLong) });
        if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0) {
          break;
        }
        a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
        return;
      }
      i += 1;
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onAfterOpenCamera, success[" + paramBoolean + "], preSessionType[" + paramInt + "], seq[" + paramLong + "]");
    }
    if (g()) {}
    do
    {
      kvq localkvq;
      do
      {
        do
        {
          return;
          localkvq = this.jdField_a_of_type_ComTencentAvVideoController.a();
        } while (localkvq.an);
        f(paramLong, 65535);
        if (!paramBoolean) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_c_of_type_JavaLangString, 2, "Go On Stage onAfterOpenCamera");
        }
        this.jdField_a_of_type_ComTencentAvVideoController.k();
        if ((paramInt == 3) && (!localkvq.N) && ("DEVICE_EARPHONE".equals(localkvq.p))) {
          this.jdField_a_of_type_Miu.d();
        }
      } while ((localkvq.k) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null));
      a(localkvq.jdField_d_of_type_Int);
      return;
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_c_of_type_JavaLangString, 2, "Open Camera Failed");
  }
  
  void a(long paramLong1, boolean paramBoolean, int paramInt, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "showOrClosePeerVideo, bShow[" + paramBoolean + "], videoSrcType[" + paramInt + "], friendUin[" + paramLong2 + "], seq[" + paramLong1 + "]");
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
    leb localleb = new leb();
    localleb.jdField_a_of_type_Long = paramLong2;
    localleb.jdField_a_of_type_Int = paramInt;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localleb);
    this.jdField_b_of_type_Lru.update(null, new Object[] { Integer.valueOf(104), localArrayList });
    if (paramInt == 2) {
      lqb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() > 0)
    {
      d("showOrClosePeerVideo");
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong1, "showOrClosePeerVideo", false, true);
    a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
  }
  
  public void a(String arg1, int paramInt1, String paramString2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onVideoViewChange-->BigViewUin = " + ??? + " ,BigViewVideoSrcType = " + paramInt1 + " ,SmallViewUin = " + paramString2 + " ,SmallViewVideoSrcType = " + paramInt2);
    }
    if ((??? == null) || (paramString2 == null)) {}
    long l2;
    do
    {
      do
      {
        do
        {
          return;
        } while (super.h());
        if (paramInt1 == 2) {
          lqb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036);
        }
        long l1 = Long.valueOf(???).longValue();
        l2 = Long.valueOf(paramString2).longValue();
        paramInt1 = this.jdField_a_of_type_ComTencentAvVideoController.a().a(l1, paramInt1);
        paramInt2 = this.jdField_a_of_type_ComTencentAvVideoController.a().a(l2, paramInt2);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_c_of_type_JavaLangString, 2, "onVideoViewChange-->BigViewIndex = " + paramInt1 + " ,SmallViewIndex = " + paramInt2);
        }
      } while ((paramInt1 == -1) || (l2 == -1L));
      paramString2 = (leb)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(paramInt1);
      leb localleb = (leb)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(paramInt2);
      localleb.jdField_a_of_type_Boolean = true;
      paramString2.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.set(paramInt1, localleb);
      this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.set(paramInt2, paramString2);
      synchronized (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList.set(paramInt1, localleb);
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList.set(paramInt2, paramString2);
        this.jdField_a_of_type_ComTencentAvVideoController.a().c();
        p();
        if (l2 == this.jdField_b_of_type_Long)
        {
          awqx.b(null, "CliOper", "", "", "0X800520E", "0X800520E", 0, 0, "", "", "", "");
          return;
        }
      }
    } while (l2 != this.jdField_a_of_type_Long);
    awqx.b(null, "CliOper", "", "", "0X800520F", "0X800520F", 0, 0, "", "", "", "");
    if (this.jdField_b_of_type_Boolean)
    {
      awqx.b(null, "CliOper", "", "", "0X8005213", "0X8005213", 0, 0, "", "", "", "");
      return;
    }
    awqx.b(null, "CliOper", "", "", "0X8005212", "0X8005212", 0, 0, "", "", "", "");
  }
  
  void a(boolean paramBoolean)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "quitDoubleVideoMeeting, needAnimation[" + paramBoolean + "], seq[" + l + "]");
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
    if (!lor.f()) {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4) && (this.jdField_a_of_type_ComTencentAvVideoController.a().j)) {
        super.a(2131630116, 1, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131167766));
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
    ((loj)localObject).a();
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
      this.jdField_a_of_type_Miu.a();
      return false;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().j)
    {
      awqx.b(null, "CliOper", "", "", "0X8005215", "0X8005215", 0, 0, "", "", "", "");
      return false;
    }
    awqx.b(null, "CliOper", "", "", "0X8005218", "0X8005218", 0, 0, "", "", "", "");
    return false;
  }
  
  boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() == 0)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, "checkRemoteHasVideo.1", false, true);
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() == 1) && (((leb)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long == this.jdField_b_of_type_Long))
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
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131493987);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.e();
      Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localActivity != null)
      {
        this.jdField_a_of_type_Miu = miu.a();
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_Miu);
        this.jdField_a_of_type_Mig = mig.a(this.jdField_a_of_type_Mig, localActivity, this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_Miu);
        this.jdField_a_of_type_Mig.a(true);
        this.jdField_a_of_type_Miu.a();
      }
    }
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131306538));
    if ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "initUI-->activity is null");
      }
      b(true);
      return;
    }
    this.jdField_a_of_type_Lwx = new lwx((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentAvVideoController, 2, this.jdField_a_of_type_ComTencentAvUiQavPanel, this.jdField_c_of_type_AndroidWidgetRelativeLayout, null, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131306555), this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131306683), null);
  }
  
  public void b(long paramLong)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onResume, seq[" + paramLong + "]");
    }
    super.b(paramLong);
    mig localmig;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().an = false;
      this.jdField_a_of_type_ComTencentAvVideoController.a().am = false;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().J)
      {
        super.w(paramLong);
        localmig = this.jdField_a_of_type_Mig;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 3) {
          break label172;
        }
        bool1 = true;
        localmig.c(bool1);
        localmig = this.jdField_a_of_type_Mig;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 3) {
          break label177;
        }
      }
    }
    label172:
    label177:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localmig.b(bool1);
      a();
      e();
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
      q();
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
      bool1 = this.jdField_a_of_type_ComTencentAvVideoController.a().k();
      bool2 = this.jdField_a_of_type_ComTencentAvVideoController.a().l();
    } while ((!bool1) && (!bool2));
    return true;
  }
  
  void c()
  {
    int i = this.jdField_a_of_type_ComTencentAvVideoController.a().i;
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str, null, true, true);
    str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i, str, null);
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131306556));
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131306557));
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
  }
  
  public void c(int paramInt)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "showToolBars, isAllOnstageMembersNotRecvData[" + this.jdField_a_of_type_ComTencentAvVideoController.a().q() + "], mToolbarDisplay[" + this.jdField_h_of_type_Boolean + "], session[" + this.jdField_a_of_type_ComTencentAvVideoController.a() + "], seq[" + l + "]");
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().q())
    {
      super.e(paramInt);
      y(l);
    }
  }
  
  public void c(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onStop, seq[" + paramLong + "]");
    }
    super.c(paramLong);
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.a().an = true;
    }
  }
  
  void c(long paramLong, View paramView)
  {
    if (a(paramLong, "android.permission.RECORD_AUDIO", null))
    {
      if (!this.jdField_a_of_type_ComTencentAvVideoController.h()) {
        break label109;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a("DoubleVideoMeetingCtrlUI.doMute.1", this.jdField_a_of_type_Long, true);
      super.l(2131306517);
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
      }
      awqx.b(null, "CliOper", "", "", "0X8005204", "0X8005204", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      super.y(paramLong);
      return;
      label109:
      this.jdField_a_of_type_ComTencentAvVideoController.a("DoubleVideoMeetingCtrlUI.doMute.2", this.jdField_a_of_type_Long, false);
      super.k(2131306517);
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
      }
      awqx.b(null, "CliOper", "", "", "0X8005203", "0X8005203", 0, 0, "", "", "", "");
    }
  }
  
  public void c(long paramLong, boolean paramBoolean)
  {
    if (g()) {
      return;
    }
    kvq localkvq = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (!localkvq.k)
    {
      a(localkvq.jdField_d_of_type_Int);
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
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onCreate, SessionType[" + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int + "], localHasVideo[" + this.jdField_a_of_type_ComTencentAvVideoController.a().j + "], seq[" + l + "]");
      }
      b();
      this.jdField_a_of_type_Miu.c();
      this.jdField_a_of_type_Miu.a(this.jdField_d_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Kur);
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
      try
      {
        this.jdField_a_of_type_Long = Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue();
        this.jdField_a_of_type_Mht = mht.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        f(l);
        c();
        if (this.jdField_a_of_type_Lwx == null) {
          continue;
        }
        this.jdField_a_of_type_Lwx.a();
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          krx.e(this.jdField_c_of_type_JavaLangString, localNumberFormatException.getMessage());
        }
      }
    }
  }
  
  public void d(int paramInt) {}
  
  public void d(long paramLong)
  {
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onDestroy, seq[" + paramLong + "]");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Kur);
    this.jdField_a_of_type_Mig.c(false);
    this.jdField_a_of_type_Mig.b(false);
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    }
    if (this.jdField_a_of_type_Lwx != null)
    {
      this.jdField_a_of_type_Lwx.b();
      this.jdField_a_of_type_Lwx = null;
    }
    super.d(paramLong);
  }
  
  void d(long paramLong, View paramView)
  {
    if (a(paramLong, "android.permission.CAMERA", paramView))
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().j) {
        break label116;
      }
      i(paramLong);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(105), Boolean.valueOf(false), Long.valueOf(paramLong) });
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClick, Open Camera, seq[" + paramLong + "]");
      }
    }
    for (;;)
    {
      y(paramLong);
      j(paramLong, 2131629967);
      return;
      label116:
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onClick, Close Camera, seq[" + paramLong + "]");
      }
      j(paramLong);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
      l(paramLong);
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
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "showOrHideAcceptBtn-->isShow = " + paramBoolean);
    }
    if (this.jdField_a_of_type_Lpt != null) {
      this.jdField_a_of_type_Lpt.a(paramBoolean, new lsk(this));
    }
    if (paramBoolean)
    {
      lqb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1030);
      return;
    }
    lqb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1030);
  }
  
  void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "resumeUI");
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().J) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.h()) {
      super.k(2131306517);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
      return;
      super.l(2131306517);
    }
  }
  
  public void e(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "addRequestVideoTimeoutRunnable,Function = " + paramString);
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
  
  void f(long paramLong)
  {
    Object localObject = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "processExtraData-->can not get the activity");
      }
      b(true);
    }
    for (;;)
    {
      return;
      localObject = ((AVActivity)localObject).getIntent();
      if (localObject != null) {}
      for (boolean bool = ((Intent)localObject).getBooleanExtra("isEnter", false); bool; bool = false)
      {
        miu.a().b(paramLong);
        miu.a();
        miu.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        localObject = ksn.a().b(ksn.a(100, String.valueOf(this.jdField_a_of_type_Long), new int[0]));
        if ((localObject != null) && (((kvq)localObject).jdField_g_of_type_Int == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.e(this.jdField_c_of_type_JavaLangString, 2, "Wrong state, finish activity");
          }
          b(true);
        }
        for (;;)
        {
          g(paramLong, 2131630125);
          return;
          this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 3, this.jdField_a_of_type_Long, null, false);
        }
      }
    }
  }
  
  public void f(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "removeRequestVideoTimeoutRunnbale-->Function = " + paramString);
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void i(long paramLong)
  {
    f(paramLong, 65535);
  }
  
  public void j(long paramLong) {}
  
  public void k(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "onPause, seq[" + paramLong + "]");
    }
    super.k(paramLong);
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().an = true;
      this.jdField_a_of_type_ComTencentAvVideoController.a().am = true;
      if (((!lor.f()) || ((!badq.h((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().ao))) && (this.jdField_a_of_type_ComTencentAvVideoController.a().j))
      {
        this.jdField_a_of_type_ComTencentAvVideoController.v();
        this.jdField_b_of_type_Lru.update(null, new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131306809, 8);
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a().m = true;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().J) {
        super.x(paramLong);
      }
      f("OnPause");
      this.jdField_a_of_type_ComTencentAvVideoController.f();
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_b_of_type_Long, true, true);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c("DoubleVideoMeetingCtrlUI");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiDoubleVideoMeetingCtrlUI$QueryPeerVideoRunnable);
  }
  
  void l()
  {
    super.G();
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_Mhz);
  }
  
  public void l(long paramLong)
  {
    this.jdField_a_of_type_ComTencentAvVideoController.v();
    f(paramLong, 65535);
  }
  
  void m()
  {
    g(true);
    if (this.jdField_a_of_type_Lwx != null) {
      this.jdField_a_of_type_Lwx.a(new lsh(this));
    }
  }
  
  public void p()
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
    this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaUtilArrayList.clear();
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size())
    {
      if (((leb)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Long != this.jdField_b_of_type_Long) {
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(i));
      }
      i += 1;
    }
    d(false);
    this.jdField_a_of_type_ComTencentAvVideoController.a(false);
  }
  
  public void q()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_c_of_type_JavaLangString, 2, "cancelNotification");
    }
    if (this.jdField_a_of_type_Mht != null) {
      this.jdField_a_of_type_Mht.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentAvVideoController.t();
  }
  
  public void r()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    String str;
    Bitmap localBitmap;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_c_of_type_JavaLangString, 2, "showNotification quit[" + this.jdField_a_of_type_Boolean + "], inMeetingRoom[" + this.jdField_a_of_type_ComTencentAvVideoController.a().J + "]");
        }
      } while ((this.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().J) || (ksn.a().a()));
      str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaLangString;
      localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString, null, true, true);
    } while (this.jdField_a_of_type_Mht == null);
    this.jdField_a_of_type_Mht.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, str, localBitmap, String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Long), 48, 0, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
    this.jdField_a_of_type_ComTencentAvVideoController.s();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoMeetingCtrlUI
 * JD-Core Version:    0.7.0.1
 */