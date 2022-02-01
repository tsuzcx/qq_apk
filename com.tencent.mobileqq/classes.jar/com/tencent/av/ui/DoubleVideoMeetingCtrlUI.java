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
import bdla;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.screenshare.ScreenShareCtrl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import lbd;
import lbz;
import lee;
import lfe;
import lob;
import lzh;
import lzr;
import max;
import mbf;
import mcx;
import mdp;
import mdq;
import mdr;
import mdt;
import mif;
import mjw;
import mnm;
import mqq.app.BaseActivity;
import mrr;
import mtt;
import muk;
import muy;
import mvk;

public class DoubleVideoMeetingCtrlUI
  extends VideoControlUI
{
  public long a;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  DoubleVideoMeetingCtrlUI.QueryPeerVideoRunnable jdField_a_of_type_ComTencentAvUiDoubleVideoMeetingCtrlUI$QueryPeerVideoRunnable = new DoubleVideoMeetingCtrlUI.QueryPeerVideoRunnable(this);
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  String jdField_a_of_type_JavaLangString = null;
  lee jdField_a_of_type_Lee = new mdp(this);
  mif jdField_a_of_type_Mif = null;
  mtt jdField_a_of_type_Mtt = null;
  boolean jdField_a_of_type_Boolean = false;
  public long b;
  String b;
  public boolean b;
  public boolean c;
  private boolean d;
  
  public DoubleVideoMeetingCtrlUI(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, mcx parammcx)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, parammcx);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    this.jdField_b_of_type_Long = Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue();
    paramVideoAppInterface = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if ((paramVideoAppInterface.jdField_j_of_type_Boolean) || (paramVideoAppInterface.k)) {
      paramVideoAppInterface.a(-1033L, "DoubleVideoMeetingCtrlUI", 4);
    }
    for (;;)
    {
      paramVideoAppInterface.jdField_j_of_type_Int = 0;
      paramVideoAppInterface.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(0, paramVideoAppInterface.jdField_d_of_type_JavaLangString, null);
      return;
      paramVideoAppInterface.a(-1033L, "DoubleVideoMeetingCtrlUI", 3);
    }
  }
  
  private void r()
  {
    lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (locallfe.jdField_j_of_type_Int == -1) {
      locallfe.jdField_j_of_type_Int = 0;
    }
    if (TextUtils.isEmpty(locallfe.jdField_d_of_type_JavaLangString)) {
      locallfe.jdField_d_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Long);
    }
    int i = locallfe.jdField_j_of_type_Int;
    String str1 = locallfe.jdField_d_of_type_JavaLangString;
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str1, null, true, true);
    String str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i, str1, null);
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_d_of_type_JavaLangString, 2, "updateHeadBitmap, uinType[" + i + "], peerUin[" + str1 + "], name[" + str2 + "]");
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373506));
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373507));
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    if (!TextUtils.equals(this.jdField_a_of_type_AndroidWidgetTextView.getText().toString(), str2))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
      this.jdField_a_of_type_Mtt.a(locallfe.jdField_c_of_type_JavaLangString, str2, localBitmap, String.valueOf(locallfe.jdField_g_of_type_Long), 48, 0, locallfe.jdField_d_of_type_Int);
    }
  }
  
  protected int a()
  {
    return 2131559735;
  }
  
  public int a(int paramInt)
  {
    DoubleVideoCtrlUI.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt);
    return 0;
  }
  
  void a()
  {
    lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
    boolean bool = locallfe.k;
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "resumeVideo, remoteHasVideo[" + bool + "], displayViewList[" + locallfe.jdField_c_of_type_JavaUtilArrayList.size() + "], seq[" + l + "], \nsessionInfo[" + locallfe + "]");
    }
    if ((locallfe.jdField_d_of_type_Int == 4) && (!locallfe.jdField_j_of_type_Boolean) && ((locallfe.jdField_c_of_type_JavaUtilArrayList.size() == 0) || (!bool)))
    {
      locallfe.a(l, "resumeVideo", 3);
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "resumeVideo, fix SessionType");
    }
    ArrayList localArrayList = new ArrayList();
    lob locallob = new lob();
    locallob.jdField_a_of_type_Long = Long.valueOf(locallfe.jdField_d_of_type_JavaLangString).longValue();
    locallob.jdField_a_of_type_Int = 1;
    localArrayList.add(locallob);
    locallob = new lob();
    locallob.jdField_a_of_type_Long = Long.valueOf(locallfe.jdField_d_of_type_JavaLangString).longValue();
    locallob.jdField_a_of_type_Int = 2;
    localArrayList.add(locallob);
    this.jdField_b_of_type_Mcx.update(null, new Object[] { Integer.valueOf(104), localArrayList });
    if ((locallfe.a(this.jdField_b_of_type_Long, 1) == -1) || (locallfe.jdField_j_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "Go On Stage ");
      }
      this.jdField_a_of_type_ComTencentAvVideoController.k();
    }
    if ((locallfe.jdField_j_of_type_Boolean) && (!locallfe.k)) {
      this.jdField_c_of_type_Boolean = true;
    }
    if (locallfe.jdField_c_of_type_JavaUtilArrayList.size() > 0) {
      e();
    }
    L();
  }
  
  void a(int paramInt)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "avSwitch, sessionType[" + paramInt + "], seq[" + l + "]");
    }
    View localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365815);
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
      L();
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
        this.jdField_a_of_type_Muk.c(bool2);
        this.jdField_a_of_type_Muk.b(bool2);
        a(Boolean.valueOf(bool1));
        i(l, 16777215);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(102) });
        return;
        if (paramInt != 4) {
          break label336;
        }
        localView.setBackgroundColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131167296));
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
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "refreshUI, relationId[" + paramLong2 + "], friendUin[" + paramLong3 + "], refreshType[" + paramInt + "], isAVActivityBackground[" + this.jdField_a_of_type_ComTencentAvVideoController.a().ap + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().ap) {}
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
    lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
    String str = locallfe.jdField_d_of_type_JavaLangString;
    switch (paramView.getId())
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_d_of_type_JavaLangString, 2, "Error View Id.ID=" + paramView.getId());
      }
    case 2131373449: 
    case 2131373451: 
    case 2131695080: 
    case 2131373767: 
    case 2131695084: 
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              e(paramLong, paramView);
              return;
              g(paramLong, paramView);
              return;
              QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.ADD_MEMBER");
              if (QLog.isColorLevel()) {
                QLog.i("double_2_multi", 2, "onClick in meeting");
              }
              DoubleVideoCtrlUI.a(a(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, true);
              super.D(paramLong);
              bdla.b(null, "CliOper", "", "", "0X8005205", "0X8005205", 0, 0, "", "", "", "");
            } while (!lzr.f());
            paramView = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          } while ((paramView == null) || (!(paramView instanceof AVActivity)));
          paramView = (AVActivity)paramView;
        } while (paramView == null);
        paramView = paramView.a();
      } while (paramView == null);
      paramView.c();
      return;
    case 2131364480: 
    case 2131365544: 
    case 2131373766: 
      Q();
      return;
    case 2131373459: 
    case 2131373460: 
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.HANG_UP");
      g(true);
      a(paramLong, locallfe, 1);
      return;
    case 2131373465: 
      d(paramLong, paramView);
      return;
    case 2131373457: 
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.HAND_FREE");
      this.jdField_a_of_type_Muy.a(muy.c);
      if ((locallfe.P) && (locallfe.a != null)) {
        bdla.b(null, "CliOper", "", "", "0X8005202", "0X8005202", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        super.D(paramLong);
        return;
        bdla.b(null, "CliOper", "", "", "0X8005201", "0X8005201", 0, 0, "", "", "", "");
      }
    case 2131373462: 
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "avideo onClick QavPanel.ViewID.HIDE");
      a();
      bdla.b(null, "CliOper", "", "", "0X8005207", "0X8005207", 0, 0, "", "", "", "");
      if (locallfe.jdField_j_of_type_Boolean)
      {
        bdla.b(null, "CliOper", "", "", "0X8005214", "0X8005214", 0, 0, "", "", "", "");
        return;
      }
      bdla.b(null, "CliOper", "", "", "0X8005217", "0X8005217", 0, 0, "", "", "", "");
      return;
    case 2131373771: 
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick, switch_camera, seq[" + paramLong + "]");
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(107), Long.valueOf(paramLong) });
      return;
    case 2131373464: 
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.LEAVE_MSG");
      int i = locallfe.jdField_j_of_type_Int;
      paramView = locallfe.jdField_e_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvVideoController.a(i, str, paramView, null, true);
      return;
    case 2131695088: 
      h(paramLong, paramView);
      return;
    }
    this.jdField_d_of_type_Boolean = true;
    f(paramLong, paramView);
  }
  
  public void a(long paramLong, ArrayList<lob> paramArrayList)
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
        if ((((lob)paramArrayList.get(i)).jdField_a_of_type_Long == this.jdField_b_of_type_Long) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean)) {
          paramArrayList.remove(i);
        }
      }
      else
      {
        this.jdField_b_of_type_Mcx.update(null, new Object[] { Integer.valueOf(103), paramArrayList, Long.valueOf(paramLong) });
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
  public void a(long paramLong, lfe paramlfe, int paramInt)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_d_of_type_JavaLangString, 2, "closeChat, from[" + paramInt + "], session[" + paramlfe + "]");
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (localObject != null) {
      ((ScreenShareCtrl)localObject).a(2);
    }
    localObject = a();
    int i;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        ((mjw)localObject).a(1);
      }
      localObject = this.jdField_a_of_type_Mif;
      if ((paramlfe.ap) || (localObject == null)) {
        break label246;
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
        break label229;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoMeetingCtrlUI.4(this, paramLong, i), 1000L);
      return;
      localObject = ((AVActivity)localObject).a();
      break;
      paramlfe.a(paramLong, 0L);
      i = 12;
      j(43);
      continue;
      paramlfe.a(paramLong, 0L);
      j(3);
      i = 3;
    }
    label229:
    ((mif)localObject).a(new mdt(this, paramLong, i));
    return;
    label246:
    d(paramLong, 0);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_d_of_type_JavaLangString, 2, "updateWhenCreateOrEnterRoomSuc, seq[" + paramLong + "], create[" + paramBoolean + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    lfe locallfe;
    do
    {
      return;
      locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
      locallfe.d("onEnterRoomSuc", true);
      locallfe.al = true;
      if (TextUtils.isEmpty(locallfe.jdField_d_of_type_JavaLangString)) {
        locallfe.jdField_d_of_type_JavaLangString = String.valueOf(locallfe.jdField_g_of_type_Long);
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a(3, 0, true, true, locallfe.jdField_d_of_type_JavaLangString);
      q();
      AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localAVActivity != null) && (!localAVActivity.isFinishing())) {
        localAVActivity.runOnUiThread(new DoubleVideoMeetingCtrlUI.6(this, localAVActivity, paramBoolean, paramLong));
      }
    } while (!locallfe.aG);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoMeetingCtrlUI.7(this, paramLong), 500L);
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onAfterOpenCamera, success[" + paramBoolean + "], preSessionType[" + paramInt + "], seq[" + paramLong + "]");
    }
    if (h()) {}
    do
    {
      lfe locallfe;
      do
      {
        do
        {
          return;
          locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
        } while (locallfe.ap);
        i(paramLong, 16777215);
        if (!paramBoolean) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_d_of_type_JavaLangString, 2, "Go On Stage onAfterOpenCamera");
        }
        this.jdField_a_of_type_ComTencentAvVideoController.k();
      } while ((locallfe.k) || (this.jdField_a_of_type_ComTencentAvUiQavPanel == null));
      a(locallfe.jdField_d_of_type_Int);
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
    lob locallob = new lob();
    locallob.jdField_a_of_type_Long = paramLong2;
    locallob.jdField_a_of_type_Int = paramInt;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(locallob);
    this.jdField_b_of_type_Mcx.update(null, new Object[] { Integer.valueOf(104), localArrayList });
    if (paramInt == 2) {
      mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036);
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
    long l1 = mrr.a(paramString1);
    long l2 = mrr.a(paramString2);
    if ((l1 == 0L) || (l2 == 0L)) {}
    do
    {
      do
      {
        return;
        if (paramInt1 == 2) {
          mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036);
        }
        paramInt1 = this.jdField_a_of_type_ComTencentAvVideoController.a().a(l1, paramInt1);
        paramInt2 = this.jdField_a_of_type_ComTencentAvVideoController.a().a(l2, paramInt2);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_d_of_type_JavaLangString, 2, "onVideoViewChange-->BigViewIndex = " + paramInt1 + " ,SmallViewIndex = " + paramInt2);
        }
      } while ((paramInt1 == -1) || (paramInt2 == -1));
      paramString1 = (lob)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(paramInt1);
      paramString2 = (lob)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(paramInt2);
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
        ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramString1.jdField_a_of_type_Long, paramString1.jdField_a_of_type_Int, paramString2.jdField_a_of_type_Long, paramString2.jdField_a_of_type_Int);
        e();
        if (l2 == this.jdField_b_of_type_Long)
        {
          bdla.b(null, "CliOper", "", "", "0X800520E", "0X800520E", 0, 0, "", "", "", "");
          return;
        }
      }
    } while (l2 != this.jdField_a_of_type_Long);
    bdla.b(null, "CliOper", "", "", "0X800520F", "0X800520F", 0, 0, "", "", "", "");
    if (this.jdField_b_of_type_Boolean)
    {
      bdla.b(null, "CliOper", "", "", "0X8005213", "0X8005213", 0, 0, "", "", "", "");
      return;
    }
    bdla.b(null, "CliOper", "", "", "0X8005212", "0X8005212", 0, 0, "", "", "", "");
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
    if (!lzr.f()) {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean)) {
        super.a(2131695242, 1, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131299080));
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
    ((lzh)localObject).a();
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
      this.jdField_a_of_type_Muy.a();
      return false;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean)
    {
      bdla.b(null, "CliOper", "", "", "0X8005215", "0X8005215", 0, 0, "", "", "", "");
      return false;
    }
    bdla.b(null, "CliOper", "", "", "0X8005218", "0X8005218", 0, 0, "", "", "", "");
    return false;
  }
  
  boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() == 0)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, "checkRemoteHasVideo.1", false, true);
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() == 1) && (((lob)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long == this.jdField_b_of_type_Long))
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
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131559790);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.e();
      Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localActivity != null)
      {
        this.jdField_a_of_type_Muy = muy.a();
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_Muy);
        this.jdField_a_of_type_Muk = muk.a(this.jdField_a_of_type_Muk, localActivity, this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_Muy);
        this.jdField_a_of_type_Muk.a(true);
        this.jdField_a_of_type_Muy.a();
      }
    }
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373487));
    if ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "initUI-->activity is null");
      }
      b(true);
      return;
    }
    this.jdField_a_of_type_Mif = new mif((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentAvVideoController, 2, this.jdField_a_of_type_ComTencentAvUiQavPanel, this.jdField_d_of_type_AndroidWidgetRelativeLayout, null, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373505), this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373637), null);
  }
  
  void b(int paramInt)
  {
    if (paramInt > 0) {
      a_(-1016L, paramInt);
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
    this.jdField_a_of_type_ComTencentAvVideoController.a().ap = false;
    this.jdField_a_of_type_ComTencentAvVideoController.a().ao = false;
    muk localmuk;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().K)
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().m()) || (this.jdField_a_of_type_ComTencentAvVideoController.a().n())) {
        super.B(paramLong);
      }
      localmuk = this.jdField_a_of_type_Muk;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 3) {
        break label195;
      }
      bool1 = true;
      localmuk.c(bool1);
      localmuk = this.jdField_a_of_type_Muk;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 3) {
        break label200;
      }
    }
    label195:
    label200:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localmuk.b(bool1);
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
      bool1 = this.jdField_a_of_type_ComTencentAvVideoController.a().m();
      bool2 = this.jdField_a_of_type_ComTencentAvVideoController.a().n();
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
      super.k(2131373465);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
      c(0L);
      return;
      super.l(2131373465);
    }
  }
  
  public void c(int paramInt)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "showToolBars, isAllOnstageMembersNotRecvData[" + this.jdField_a_of_type_ComTencentAvVideoController.a().s() + "], mToolbarDisplay[" + this.jdField_h_of_type_Boolean + "], session[" + this.jdField_a_of_type_ComTencentAvVideoController.a() + "], seq[" + l + "]");
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().s())
    {
      super.e(paramInt);
      D(l);
    }
  }
  
  public void c(long paramLong)
  {
    if ((this.m != 4) && (this.jdField_d_of_type_Boolean)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_d_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onStop, seq[" + paramLong + "]interceptStopAction:=" + bool);
      }
      if (!bool) {
        super.c(paramLong);
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
        this.jdField_a_of_type_ComTencentAvVideoController.a().ap = true;
      }
      return;
    }
  }
  
  public void c(long paramLong, boolean paramBoolean)
  {
    if (h()) {
      return;
    }
    lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (!locallfe.k)
    {
      a(locallfe.jdField_d_of_type_Int);
      return;
    }
    i(paramLong, 16777215);
  }
  
  public void d()
  {
    int i = 1;
    Object localObject = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {}
    for (;;)
    {
      return;
      super.d();
      long l = AudioHelper.b();
      lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onCreate, SessionType[" + locallfe.jdField_d_of_type_Int + "], localHasVideo[" + locallfe.jdField_j_of_type_Boolean + "], seq[" + l + "]");
      }
      if (locallfe.aF)
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_d_of_type_JavaLangString, 2, "onCreate, localMute[" + locallfe.jdField_g_of_type_Boolean + "], localHasVideo[" + locallfe.jdField_j_of_type_Boolean + "], hasLocalVideoWhenSwitch[" + locallfe.aG + "], deviceName[" + locallfe.q + "]");
        }
        this.jdField_a_of_type_ComTencentAvVideoController.b("switch2DoubleMeeting_onCreate", locallfe.jdField_g_of_type_Boolean);
        VideoController localVideoController = this.jdField_a_of_type_ComTencentAvVideoController;
        if (locallfe.jdField_g_of_type_Boolean) {
          localVideoController.g("switch2DoubleMeeting_onCreate", i);
        }
      }
      else
      {
        b();
        f(l, locallfe.aF);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lee);
        this.jdField_a_of_type_JavaLangString = locallfe.jdField_d_of_type_JavaLangString;
      }
      try
      {
        this.jdField_a_of_type_Long = Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue();
        this.jdField_a_of_type_Mtt = mtt.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        m(l);
        r();
        if (this.jdField_a_of_type_Mif != null) {
          this.jdField_a_of_type_Mif.a();
        }
        if (!(localObject instanceof AVActivity)) {
          continue;
        }
        localObject = (AVActivity)localObject;
        if (((AVActivity)localObject).jdField_a_of_type_Mnm == null) {
          continue;
        }
        ((AVActivity)localObject).jdField_a_of_type_Mnm.c(3);
        return;
        i = 0;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          lbd.h(this.jdField_d_of_type_JavaLangString, localNumberFormatException.getMessage());
        }
      }
    }
  }
  
  public void d(int paramInt) {}
  
  public void d(long paramLong)
  {
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onDestroy, seq[" + paramLong + "]");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lee);
    this.jdField_a_of_type_Muk.c(false);
    this.jdField_a_of_type_Muk.b(false);
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    }
    if (this.jdField_a_of_type_Mif != null)
    {
      this.jdField_a_of_type_Mif.b();
      this.jdField_a_of_type_Mif = null;
    }
    super.d(paramLong);
  }
  
  public void d(long paramLong, int paramInt)
  {
    muy.a().b(paramLong);
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().S) {
      super.D(paramLong);
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_a_of_type_Long, true, paramInt);
    super.C(paramLong);
    b(true);
    bdla.b(null, "CliOper", "", "", "0X8005206", "0X8005206", 0, 0, "", "", "", "");
  }
  
  void d(long paramLong, View paramView)
  {
    int i;
    if (a(paramLong, "android.permission.RECORD_AUDIO", null))
    {
      boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.h();
      q(bool);
      if (!bool) {
        break label148;
      }
      i = this.jdField_a_of_type_ComTencentAvVideoController.f();
      this.jdField_a_of_type_ComTencentAvVideoController.a("DoubleVideoMeetingCtrlUI.doMute.1", this.jdField_a_of_type_Long, true);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a("DoubleVideoMeetingCtrlUI.doMute.1", i, this.jdField_a_of_type_ComTencentAvVideoController.f(), false);
      super.l(2131373465);
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
      }
      bdla.b(null, "CliOper", "", "", "0X8005204", "0X8005204", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      super.D(paramLong);
      return;
      label148:
      i = this.jdField_a_of_type_ComTencentAvVideoController.f();
      this.jdField_a_of_type_ComTencentAvVideoController.a("DoubleVideoMeetingCtrlUI.doMute.2", this.jdField_a_of_type_Long, false);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a("DoubleVideoMeetingCtrlUI.doMute.2", i, this.jdField_a_of_type_ComTencentAvVideoController.f(), false);
      super.k(2131373465);
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
      }
      bdla.b(null, "CliOper", "", "", "0X8005203", "0X8005203", 0, 0, "", "", "", "");
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
    if (this.jdField_a_of_type_Max != null) {
      this.jdField_a_of_type_Max.a(paramBoolean, new mdr(this));
    }
    if (paramBoolean)
    {
      mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1030);
      return;
    }
    mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1030);
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
      if (((lob)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Long != this.jdField_b_of_type_Long) {
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(i));
      }
      i += 1;
    }
    d(false);
    this.jdField_a_of_type_ComTencentAvVideoController.a(false);
  }
  
  void e(long paramLong, View paramView)
  {
    if (a(paramLong, "android.permission.CAMERA", null))
    {
      paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
      paramView.aG = false;
      if (paramView.jdField_j_of_type_Boolean) {
        break label123;
      }
      j(paramLong);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(105), Boolean.valueOf(false), Long.valueOf(paramLong) });
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick, Open Camera, seq[" + paramLong + "]");
      }
    }
    for (;;)
    {
      D(paramLong);
      l(paramLong, 2131695080);
      return;
      label123:
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onClick, Close Camera, seq[" + paramLong + "]");
      }
      k(paramLong);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
      o(paramLong);
    }
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
  
  public void f(long paramLong, View paramView)
  {
    super.f(paramLong, paramView);
    mvk.a("0X800AD8D");
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
  
  public void j(long paramLong)
  {
    i(paramLong, 16777215);
  }
  
  public void k(long paramLong) {}
  
  void l()
  {
    super.H();
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_Mtz);
  }
  
  void m()
  {
    g(true);
    if (this.jdField_a_of_type_Mif != null) {
      this.jdField_a_of_type_Mif.a(new mdq(this));
    }
  }
  
  void m(long paramLong)
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
      localObject = lbz.a(100, String.valueOf(this.jdField_a_of_type_Long), new int[0]);
      localObject = lbz.a().c((String)localObject);
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_d_of_type_JavaLangString, 2, "processExtraData uin[" + this.jdField_a_of_type_Long + "], info[" + localObject + "]");
      }
      if ((bool) || ((localObject != null) && (((lfe)localObject).j())))
      {
        muy.a().b(paramLong);
        muy.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        if ((localObject != null) && (((lfe)localObject).jdField_g_of_type_Int == 0))
        {
          b(true);
          return;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 3, this.jdField_a_of_type_Long, null, false);
        a_(paramLong, 2131695252);
        return;
      }
    } while ((localObject != null) && (((lfe)localObject).jdField_g_of_type_Int != 0));
    this.jdField_a_of_type_ComTencentAvVideoController.a(3, this.jdField_a_of_type_Long, 8, new long[] { this.jdField_a_of_type_Long }, false);
    a_(paramLong, 2131695600);
  }
  
  public void n(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "onPause, seq[" + paramLong + "], quit[" + this.jdField_a_of_type_Boolean + "]");
    }
    super.n(paramLong);
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().ap = true;
      this.jdField_a_of_type_ComTencentAvVideoController.a().ao = true;
      if (((!lzr.f()) || ((!NetworkUtil.isWifiConnected((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().aq))) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentAvVideoController.u();
        this.jdField_b_of_type_Mcx.update(null, new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131373771, 8);
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a().n = true;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().K) {
        super.C(paramLong);
      }
      f("OnPause");
      if ((this.jdField_a_of_type_Boolean) || (!lzr.f())) {
        this.jdField_a_of_type_ComTencentAvVideoController.a("Meeting_onPause");
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_b_of_type_Long, true, true);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b("DoubleVideoMeetingCtrlUI");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiDoubleVideoMeetingCtrlUI$QueryPeerVideoRunnable);
  }
  
  public void o()
  {
    super.o();
    r();
  }
  
  public void o(long paramLong)
  {
    this.jdField_a_of_type_ComTencentAvVideoController.u();
    i(paramLong, 16777215);
  }
  
  public void p()
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
  
  public void q()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_d_of_type_JavaLangString, 2, "showNotification quit[" + this.jdField_a_of_type_Boolean + "], inMeetingRoom[" + this.jdField_a_of_type_ComTencentAvVideoController.a().K + "]");
      }
    } while ((this.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().K) || (lbz.a().a()));
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaLangString;
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString, null, true, true);
    this.jdField_a_of_type_Mtt.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, str, localBitmap, String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Long), 48, 0, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
    this.jdField_a_of_type_ComTencentAvVideoController.r();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoMeetingCtrlUI
 * JD-Core Version:    0.7.0.1
 */