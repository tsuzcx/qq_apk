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
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.screenshare.ScreenShareCtrl;
import com.tencent.av.screenshare.ScreenShareReportHelper;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.tips.AvTipsView;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.SensorHelper;
import com.tencent.av.utils.TraeHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class DoubleVideoMeetingCtrlUI
  extends VideoControlUI
{
  long jdField_a_of_type_Long;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new DoubleVideoMeetingCtrlUI.1(this);
  DoubleVideoMeetingCtrlUI.QueryPeerVideoRunnable jdField_a_of_type_ComTencentAvUiDoubleVideoMeetingCtrlUI$QueryPeerVideoRunnable = new DoubleVideoMeetingCtrlUI.QueryPeerVideoRunnable(this);
  QavInOutAnimation jdField_a_of_type_ComTencentAvUiQavInOutAnimation = null;
  QAVNotification jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  String jdField_a_of_type_JavaLangString = null;
  boolean jdField_a_of_type_Boolean = false;
  long jdField_b_of_type_Long = Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue();
  String jdField_b_of_type_JavaLangString = null;
  boolean jdField_b_of_type_Boolean = false;
  boolean c;
  private boolean d;
  
  public DoubleVideoMeetingCtrlUI(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, ControlUIObserver paramControlUIObserver)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, paramControlUIObserver);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    paramVideoAppInterface = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if ((!paramVideoAppInterface.j) && (!paramVideoAppInterface.jdField_k_of_type_Boolean)) {
      paramVideoAppInterface.a(-1033L, "DoubleVideoMeetingCtrlUI", 3);
    } else {
      paramVideoAppInterface.a(-1033L, "DoubleVideoMeetingCtrlUI", 4);
    }
    paramVideoAppInterface.jdField_k_of_type_Int = 0;
    paramVideoAppInterface.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0, paramVideoAppInterface.jdField_c_of_type_JavaLangString, null);
  }
  
  private void r()
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (localSessionInfo.jdField_k_of_type_Int == -1) {
      localSessionInfo.jdField_k_of_type_Int = 0;
    }
    if (TextUtils.isEmpty(localSessionInfo.jdField_c_of_type_JavaLangString)) {
      localSessionInfo.jdField_c_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Long);
    }
    int i = localSessionInfo.jdField_k_of_type_Int;
    String str1 = localSessionInfo.jdField_c_of_type_JavaLangString;
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str1, null, true, true);
    String str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str1, null);
    if (QLog.isColorLevel())
    {
      String str3 = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateHeadBitmap, uinType[");
      localStringBuilder.append(i);
      localStringBuilder.append("], peerUin[");
      localStringBuilder.append(str1);
      localStringBuilder.append("], name[");
      localStringBuilder.append(str2);
      localStringBuilder.append("]");
      QLog.i(str3, 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373392));
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373393));
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
    if (!TextUtils.equals(this.jdField_a_of_type_AndroidWidgetTextView.getText().toString(), str2))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(localSessionInfo.jdField_b_of_type_JavaLangString, str2, localBitmap, String.valueOf(localSessionInfo.jdField_f_of_type_Long), 48, 0, localSessionInfo.jdField_d_of_type_Int);
    }
  }
  
  protected int a()
  {
    return 2131559688;
  }
  
  public int a(int paramInt)
  {
    DoubleVideoCtrlUI.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt);
    return 0;
  }
  
  void a()
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    boolean bool = localSessionInfo.jdField_k_of_type_Boolean;
    long l = AudioHelper.b();
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_d_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("resumeVideo, remoteHasVideo[");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append("], displayViewList[");
      ((StringBuilder)localObject2).append(localSessionInfo.jdField_c_of_type_JavaUtilArrayList.size());
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(l);
      ((StringBuilder)localObject2).append("], \nsessionInfo[");
      ((StringBuilder)localObject2).append(localSessionInfo);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    if ((localSessionInfo.jdField_d_of_type_Int == 4) && (!localSessionInfo.j) && ((localSessionInfo.jdField_c_of_type_JavaUtilArrayList.size() == 0) || (!bool)))
    {
      localSessionInfo.a(l, "resumeVideo", 3);
      QLog.w(this.jdField_d_of_type_JavaLangString, 1, "resumeVideo, fix SessionType");
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = new VideoViewInfo();
    ((VideoViewInfo)localObject2).jdField_a_of_type_Long = Long.valueOf(localSessionInfo.jdField_c_of_type_JavaLangString).longValue();
    ((VideoViewInfo)localObject2).jdField_a_of_type_Int = 1;
    ((ArrayList)localObject1).add(localObject2);
    localObject2 = new VideoViewInfo();
    ((VideoViewInfo)localObject2).jdField_a_of_type_Long = Long.valueOf(localSessionInfo.jdField_c_of_type_JavaLangString).longValue();
    ((VideoViewInfo)localObject2).jdField_a_of_type_Int = 2;
    ((ArrayList)localObject1).add(localObject2);
    this.jdField_b_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(104), localObject1 });
    localSessionInfo.a(this.jdField_b_of_type_Long, 1);
    if (localSessionInfo.j)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "Go On Stage ");
      }
      this.jdField_a_of_type_ComTencentAvVideoController.l();
    }
    if ((localSessionInfo.j) && (!localSessionInfo.jdField_k_of_type_Boolean)) {
      this.jdField_c_of_type_Boolean = true;
    }
    if (localSessionInfo.jdField_c_of_type_JavaUtilArrayList.size() > 0) {
      e();
    }
    N();
  }
  
  void a(int paramInt)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_d_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("avSwitch, sessionType[");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(l);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365816);
    Object localObject2 = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramInt == 3)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(0);
      }
      N();
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(false);
      if (localObject2 != null)
      {
        ((AVActivity)localObject2).b(true);
        ((AVActivity)localObject2).e(true);
        ((AVActivity)localObject2).c(false);
      }
    }
    else if (paramInt == 4)
    {
      ((View)localObject1).setBackgroundColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131167333));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(8);
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(true);
      if (localObject2 != null)
      {
        ((AVActivity)localObject2).b(false);
        ((AVActivity)localObject2).e(false);
        ((AVActivity)localObject2).c(true);
      }
      bool1 = true;
      break label284;
    }
    boolean bool1 = false;
    label284:
    boolean bool2;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 3) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(bool2);
    this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(bool2);
    a(Boolean.valueOf(bool1));
    i(l, 16777215);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(102) });
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStart, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    super.a(paramLong);
  }
  
  void a(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_d_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("refreshUI, relationId[");
      ((StringBuilder)localObject2).append(paramLong2);
      ((StringBuilder)localObject2).append("], friendUin[");
      ((StringBuilder)localObject2).append(paramLong3);
      ((StringBuilder)localObject2).append("], refreshType[");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("], isAVActivityBackground[");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentAvVideoController.a().af);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().af) {
      return;
    }
    Object localObject1 = new DoubleVideoMeetingCtrlUI.RefreshUIRunnable(this, paramLong1, paramInt, paramLong3, paramLong2);
    Object localObject2 = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_d_of_type_JavaLangString, 2, "refreshUI-->Can not get AVActivity");
      }
      return;
    }
    ((AVActivity)localObject2).runOnUiThread((Runnable)localObject1);
  }
  
  public void a(long paramLong, View paramView)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_d_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onClick, id[");
      ((StringBuilder)localObject2).append(AudioHelper.a(paramView, paramView.getId()));
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    Object localObject1 = ((SessionInfo)localObject2).jdField_c_of_type_JavaLangString;
    switch (paramView.getId())
    {
    default: 
      if (QLog.isColorLevel())
      {
        localObject1 = this.jdField_d_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Error View Id.ID=");
        ((StringBuilder)localObject2).append(paramView.getId());
        QLog.e((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        return;
      }
      break;
    case 2131695341: 
      h(paramLong, paramView);
      return;
    case 2131695339: 
      this.jdField_d_of_type_Boolean = true;
      f(paramLong, paramView);
      return;
    case 2131695337: 
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.ADD_MEMBER");
      if (QLog.isColorLevel()) {
        QLog.i("double_2_multi", 2, "onClick in meeting");
      }
      DoubleVideoCtrlUI.a(a(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, true);
      super.C(paramLong);
      ReportController.b(null, "CliOper", "", "", "0X8005205", "0X8005205", 0, 0, "", "", "", "");
      if (SmallScreenUtils.f())
      {
        paramView = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if ((paramView != null) && ((paramView instanceof AVActivity)))
        {
          paramView = (AVActivity)paramView;
          if (paramView != null)
          {
            paramView = paramView.a();
            if (paramView != null)
            {
              paramView.c();
              return;
            }
          }
        }
      }
      break;
    case 2131695333: 
      e(paramLong, paramView);
      return;
    case 2131373640: 
      paramView = this.jdField_d_of_type_JavaLangString;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onClick, switch_camera, seq[");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append("]");
      QLog.w(paramView, 1, ((StringBuilder)localObject1).toString());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(107), Long.valueOf(paramLong) });
      return;
    case 2131373636: 
      g(paramLong, paramView);
      return;
    case 2131373351: 
      d(paramLong, paramView);
      return;
    case 2131373350: 
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.LEAVE_MSG");
      int i = ((SessionInfo)localObject2).jdField_k_of_type_Int;
      paramView = ((SessionInfo)localObject2).jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvVideoController.a(i, (String)localObject1, paramView, null, true);
      return;
    case 2131373348: 
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "avideo onClick QavPanel.ViewID.HIDE");
      a();
      ReportController.b(null, "CliOper", "", "", "0X8005207", "0X8005207", 0, 0, "", "", "", "");
      if (((SessionInfo)localObject2).j)
      {
        ReportController.b(null, "CliOper", "", "", "0X8005214", "0X8005214", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X8005217", "0X8005217", 0, 0, "", "", "", "");
      return;
    case 2131373345: 
    case 2131373346: 
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.HANG_UP");
      h(true);
      a(paramLong, (SessionInfo)localObject2, 1);
      return;
    case 2131373343: 
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.HAND_FREE");
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(TraeHelper.c);
      if ((((SessionInfo)localObject2).E) && (((SessionInfo)localObject2).a != null)) {
        ReportController.b(null, "CliOper", "", "", "0X8005202", "0X8005202", 0, 0, "", "", "", "");
      } else {
        ReportController.b(null, "CliOper", "", "", "0X8005201", "0X8005201", 0, 0, "", "", "", "");
      }
      super.C(paramLong);
      return;
    case 2131364477: 
    case 2131365542: 
    case 2131373635: 
      S();
    }
  }
  
  @TargetApi(21)
  public void a(long paramLong, SessionInfo paramSessionInfo, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("closeChat, from[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], session[");
      localStringBuilder.append(paramSessionInfo);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (localObject != null) {
      ((ScreenShareCtrl)localObject).a(2);
    }
    localObject = a();
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((AVActivity)localObject).a();
    }
    if (localObject != null) {
      ((ScreenRecordHelper)localObject).a(1);
    }
    localObject = this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation;
    boolean bool = paramSessionInfo.af;
    int j = 0;
    if ((!bool) && (localObject != null))
    {
      int i = j;
      if (paramInt != 1) {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            i = j;
          }
          else
          {
            paramSessionInfo.a(paramLong, 0L);
            i = 12;
            j(43);
          }
        }
        else
        {
          paramSessionInfo.a(paramLong, 0L);
          j(3);
          i = 3;
        }
      }
      if (i != 0)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoMeetingCtrlUI.4(this, paramLong, i), 1000L);
        return;
      }
      ((QavInOutAnimation)localObject).a(new DoubleVideoMeetingCtrlUI.5(this, paramLong, i));
      return;
    }
    d(paramLong, 0);
  }
  
  void a(long paramLong, ArrayList<VideoViewInfo> paramArrayList)
  {
    if (paramArrayList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_d_of_type_JavaLangString, 2, "notifyShowVideo-->info list is null");
      }
      return;
    }
    int i = 0;
    while (i < paramArrayList.size())
    {
      if ((((VideoViewInfo)paramArrayList.get(i)).jdField_a_of_type_Long == this.jdField_b_of_type_Long) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().j))
      {
        paramArrayList.remove(i);
        break;
      }
      i += 1;
    }
    this.jdField_b_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(103), paramArrayList, Long.valueOf(paramLong) });
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
      a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_d_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("updateWhenCreateOrEnterRoomSuc, seq[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("], create[");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append("]");
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    ((SessionInfo)localObject1).e("onEnterRoomSuc", true);
    ((SessionInfo)localObject1).ab = true;
    if (TextUtils.isEmpty(((SessionInfo)localObject1).jdField_c_of_type_JavaLangString)) {
      ((SessionInfo)localObject1).jdField_c_of_type_JavaLangString = String.valueOf(((SessionInfo)localObject1).jdField_f_of_type_Long);
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a(3, 0, true, true, ((SessionInfo)localObject1).jdField_c_of_type_JavaLangString);
    q();
    Object localObject2 = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localObject2 != null) && (!((AVActivity)localObject2).isFinishing())) {
      ((AVActivity)localObject2).runOnUiThread(new DoubleVideoMeetingCtrlUI.6(this, (AVActivity)localObject2, paramBoolean, paramLong));
    }
    if (((SessionInfo)localObject1).aw) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new DoubleVideoMeetingCtrlUI.7(this, paramLong), 500L);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAfterOpenCamera, success[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], preSessionType[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    if (h()) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (((SessionInfo)localObject).af) {
      return;
    }
    i(paramLong, 16777215);
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "Go On Stage onAfterOpenCamera");
      }
      this.jdField_a_of_type_ComTencentAvVideoController.l();
      if ((!((SessionInfo)localObject).jdField_k_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)) {
        a(((SessionInfo)localObject).jdField_d_of_type_Int);
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "Open Camera Failed");
    }
  }
  
  void a(long paramLong1, boolean paramBoolean, int paramInt, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_d_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("showOrClosePeerVideo, bShow[");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append("], videoSrcType[");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("], friendUin[");
      ((StringBuilder)localObject2).append(paramLong2);
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(paramLong1);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    a(paramLong1);
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Boolean) {
      f("showOrClosePeerVideo");
    }
    if (paramBoolean)
    {
      d("showOrClosePeerVideo");
      return;
    }
    Object localObject1 = new VideoViewInfo();
    ((VideoViewInfo)localObject1).jdField_a_of_type_Long = paramLong2;
    ((VideoViewInfo)localObject1).jdField_a_of_type_Int = paramInt;
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(localObject1);
    this.jdField_b_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(104), localObject2 });
    if (paramInt == 2) {
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036);
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
    Object localObject2;
    if (QLog.isColorLevel())
    {
      ??? = this.jdField_d_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onVideoViewChange-->BigViewUin = ");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append(" ,BigViewVideoSrcType = ");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(" ,SmallViewUin = ");
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append(" ,SmallViewVideoSrcType = ");
      ((StringBuilder)localObject2).append(paramInt2);
      QLog.d((String)???, 2, ((StringBuilder)localObject2).toString());
    }
    long l1 = AVUtil.a(paramString1);
    long l2 = AVUtil.a(paramString2);
    if (l1 != 0L)
    {
      if (l2 == 0L) {
        return;
      }
      if (paramInt1 == 2) {
        TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036);
      }
      paramInt1 = this.jdField_a_of_type_ComTencentAvVideoController.a().a(l1, paramInt1);
      paramInt2 = this.jdField_a_of_type_ComTencentAvVideoController.a().a(l2, paramInt2);
      if (QLog.isColorLevel())
      {
        paramString1 = this.jdField_d_of_type_JavaLangString;
        paramString2 = new StringBuilder();
        paramString2.append("onVideoViewChange-->BigViewIndex = ");
        paramString2.append(paramInt1);
        paramString2.append(" ,SmallViewIndex = ");
        paramString2.append(paramInt2);
        QLog.d(paramString1, 2, paramString2.toString());
      }
      if (paramInt1 != -1)
      {
        if (paramInt2 == -1) {
          return;
        }
        paramString1 = (VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(paramInt1);
        paramString2 = (VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(paramInt2);
        paramString2.jdField_a_of_type_Boolean = true;
        paramString1.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.set(paramInt1, paramString2);
        this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.set(paramInt2, paramString1);
        if (QLog.isColorLevel())
        {
          ??? = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList);
          localObject2 = this.jdField_d_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onVideoViewChange finish");
          localStringBuilder.append((String)???);
          QLog.d((String)localObject2, 2, localStringBuilder.toString());
        }
        synchronized (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList.set(paramInt1, paramString2);
          this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList.set(paramInt2, paramString1);
          this.jdField_a_of_type_ComTencentAvVideoController.a().a();
          ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a.a(paramString1.jdField_a_of_type_Long, paramString1.jdField_a_of_type_Int, paramString2.jdField_a_of_type_Long, paramString2.jdField_a_of_type_Int);
          e();
          if (l2 == this.jdField_b_of_type_Long)
          {
            ReportController.b(null, "CliOper", "", "", "0X800520E", "0X800520E", 0, 0, "", "", "", "");
            return;
          }
          if (l2 == this.jdField_a_of_type_Long)
          {
            ReportController.b(null, "CliOper", "", "", "0X800520F", "0X800520F", 0, 0, "", "", "", "");
            if (this.jdField_b_of_type_Boolean)
            {
              ReportController.b(null, "CliOper", "", "", "0X8005213", "0X8005213", 0, 0, "", "", "", "");
              return;
            }
            ReportController.b(null, "CliOper", "", "", "0X8005212", "0X8005212", 0, 0, "", "", "", "");
          }
          return;
        }
      }
    }
  }
  
  void a(boolean paramBoolean)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("quitDoubleVideoMeeting, needAnimation[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
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
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), localObject, Boolean.valueOf(false) });
    if (!SmallScreenUtils.f())
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4) && (this.jdField_a_of_type_ComTencentAvVideoController.a().j))
      {
        super.a(2131695493, 1, this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131299168));
        return false;
      }
    }
    else
    {
      localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject != null) && ((localObject instanceof AVActivity)))
      {
        localObject = (AVActivity)localObject;
        if (localObject != null)
        {
          localObject = ((AVActivity)localObject).a();
          if (localObject != null) {
            ((SmallScreenActivityPlugin)localObject).a();
          }
        }
      }
    }
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt != 4)
    {
      if ((paramInt != 24) && (paramInt != 25)) {
        return false;
      }
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
      return false;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().j)
    {
      ReportController.b(null, "CliOper", "", "", "0X8005215", "0X8005215", 0, 0, "", "", "", "");
      return false;
    }
    ReportController.b(null, "CliOper", "", "", "0X8005218", "0X8005218", 0, 0, "", "", "", "");
    return false;
  }
  
  boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() == 0)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, "checkRemoteHasVideo.1", false, true);
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() == 1) && (((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long == this.jdField_b_of_type_Long))
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
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131559742);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.e();
      Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localActivity != null)
      {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper = TraeHelper.a();
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_ComTencentAvUtilsTraeHelper);
        this.jdField_a_of_type_ComTencentAvUtilsSensorHelper = SensorHelper.a(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper, localActivity, this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_ComTencentAvUtilsTraeHelper);
        this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a(true);
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
      }
    }
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373373));
    if ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "initUI-->activity is null");
      }
      b(true);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = new QavInOutAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentAvVideoController, 2, this.jdField_a_of_type_ComTencentAvUiQavPanel, this.jdField_d_of_type_AndroidWidgetRelativeLayout, null, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373391), this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373523), null);
  }
  
  void b(int paramInt)
  {
    if (paramInt > 0) {
      a_(-1016L, paramInt);
    }
  }
  
  public void b(long paramLong)
  {
    boolean bool1 = QLog.isColorLevel();
    boolean bool2 = true;
    Object localObject;
    if (bool1)
    {
      localObject = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    super.b(paramLong);
    o();
    this.jdField_a_of_type_ComTencentAvVideoController.a().af = false;
    this.jdField_a_of_type_ComTencentAvVideoController.a().ae = false;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().z)
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().k()) || (this.jdField_a_of_type_ComTencentAvVideoController.a().l())) {
        super.A(paramLong);
      }
      localObject = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 3) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((SensorHelper)localObject).c(bool1);
      localObject = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 3) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      ((SensorHelper)localObject).b(bool1);
      a();
      c();
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(0, this.jdField_a_of_type_JavaLangString);
  }
  
  public void b(long paramLong, int paramInt)
  {
    a(paramLong, 360 - paramInt);
  }
  
  void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), String.valueOf(this.jdField_a_of_type_Long), Boolean.valueOf(paramBoolean) });
    if (this.jdField_a_of_type_Boolean) {
      p();
    }
  }
  
  protected boolean b()
  {
    VideoController localVideoController = this.jdField_a_of_type_ComTencentAvVideoController;
    boolean bool1 = false;
    if (localVideoController == null) {
      return false;
    }
    boolean bool3 = this.jdField_a_of_type_ComTencentAvVideoController.a().k();
    boolean bool2 = this.jdField_a_of_type_ComTencentAvVideoController.a().l();
    if ((bool3) || (bool2)) {
      bool1 = true;
    }
    return bool1;
  }
  
  void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "resumeUI");
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().z) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.i()) {
      super.k(2131373351);
    } else {
      super.l(2131373351);
    }
    a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
    c(0L);
  }
  
  public void c(int paramInt)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showToolBars, isAllOnstageMembersNotRecvData[");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvVideoController.a().q());
      localStringBuilder.append("], mToolbarDisplay[");
      localStringBuilder.append(this.jdField_h_of_type_Boolean);
      localStringBuilder.append("], session[");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvVideoController.a());
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().q())
    {
      super.e(paramInt);
      C(l);
    }
  }
  
  public void c(long paramLong)
  {
    boolean bool;
    if ((this.m != 4) && (this.jdField_d_of_type_Boolean)) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_d_of_type_Boolean = false;
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStop, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]interceptStopAction:=");
      localStringBuilder.append(bool);
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (!bool) {
      super.c(paramLong);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.a().af = true;
    }
  }
  
  public void c(long paramLong, boolean paramBoolean)
  {
    if (h()) {
      return;
    }
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (!localSessionInfo.jdField_k_of_type_Boolean)
    {
      a(localSessionInfo.jdField_d_of_type_Int);
      return;
    }
    i(paramLong, 16777215);
  }
  
  public void d()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void d(int paramInt) {}
  
  public void d(long paramLong)
  {
    Object localObject = this.jdField_d_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDestroy, seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(false);
    this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(false);
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    }
    localObject = this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation;
    if (localObject != null)
    {
      ((QavInOutAnimation)localObject).b();
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = null;
    }
    super.d(paramLong);
  }
  
  void d(long paramLong, int paramInt)
  {
    TraeHelper.a().b(paramLong);
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().H) {
      super.C(paramLong);
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_a_of_type_Long, true, paramInt);
    super.B(paramLong);
    b(true);
    ReportController.b(null, "CliOper", "", "", "0X8005206", "0X8005206", 0, 0, "", "", "", "");
  }
  
  void d(long paramLong, View paramView)
  {
    if (a(paramLong, "android.permission.RECORD_AUDIO", null))
    {
      boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.i();
      r(bool);
      int i;
      if (bool)
      {
        i = this.jdField_a_of_type_ComTencentAvVideoController.e();
        this.jdField_a_of_type_ComTencentAvVideoController.a("DoubleVideoMeetingCtrlUI.doMute.1", this.jdField_a_of_type_Long, true);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a("DoubleVideoMeetingCtrlUI.doMute.1", i, this.jdField_a_of_type_ComTencentAvVideoController.e(), false);
        super.l(2131373351);
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
        }
        ReportController.b(null, "CliOper", "", "", "0X8005204", "0X8005204", 0, 0, "", "", "", "");
      }
      else
      {
        i = this.jdField_a_of_type_ComTencentAvVideoController.e();
        this.jdField_a_of_type_ComTencentAvVideoController.a("DoubleVideoMeetingCtrlUI.doMute.2", this.jdField_a_of_type_Long, false);
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a("DoubleVideoMeetingCtrlUI.doMute.2", i, this.jdField_a_of_type_ComTencentAvVideoController.e(), false);
        super.k(2131373351);
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
        }
        ReportController.b(null, "CliOper", "", "", "0X8005203", "0X8005203", 0, 0, "", "", "", "");
      }
    }
    super.C(paramLong);
  }
  
  void d(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvUiDoubleVideoMeetingCtrlUI$QueryPeerVideoRunnable.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiDoubleVideoMeetingCtrlUI$QueryPeerVideoRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvUiDoubleVideoMeetingCtrlUI$QueryPeerVideoRunnable, 1000L);
  }
  
  void e()
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
    this.jdField_a_of_type_ComTencentAvVideoController.a().e.clear();
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size())
    {
      if (((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Long != this.jdField_b_of_type_Long) {
        this.jdField_a_of_type_ComTencentAvVideoController.a().e.add(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(i));
      }
      i += 1;
    }
    e(false);
    this.jdField_a_of_type_ComTencentAvVideoController.a(false);
  }
  
  void e(long paramLong, View paramView)
  {
    if (a(paramLong, "android.permission.CAMERA", null))
    {
      paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
      paramView.aw = false;
      StringBuilder localStringBuilder;
      if (!paramView.j)
      {
        n(paramLong);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(105), Boolean.valueOf(false), Long.valueOf(paramLong) });
        if (QLog.isColorLevel())
        {
          paramView = this.jdField_d_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onClick, Open Camera, seq[");
          localStringBuilder.append(paramLong);
          localStringBuilder.append("]");
          QLog.w(paramView, 1, localStringBuilder.toString());
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          paramView = this.jdField_d_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onClick, Close Camera, seq[");
          localStringBuilder.append(paramLong);
          localStringBuilder.append("]");
          QLog.w(paramView, 1, localStringBuilder.toString());
        }
        k(paramLong);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
        o(paramLong);
      }
      C(paramLong);
    }
    l(paramLong, 2131695333);
  }
  
  void e(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addRequestVideoTimeoutRunnable,Function = ");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new DoubleVideoMeetingCtrlUI.RequestVideoTimeoutRunnale(this);
    } else {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
  }
  
  void e(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showOrHideAcceptBtn-->isShow = ");
      localStringBuilder.append(paramBoolean);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentAvTipsAvTipsView != null) {
      this.jdField_a_of_type_ComTencentAvTipsAvTipsView.a(paramBoolean, new DoubleVideoMeetingCtrlUI.3(this));
    }
    if (paramBoolean)
    {
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1030);
      return;
    }
    TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1030);
  }
  
  public void f(long paramLong, View paramView)
  {
    super.f(paramLong, paramView);
    ScreenShareReportHelper.a("0X800AD8D");
  }
  
  void f(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeRequestVideoTimeoutRunnbale-->Function = ");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void g(int paramInt)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_d_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onLayoutModeChange --> ScreenType = ");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(" , hasSetBigVideoView = ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentAvVideoController.a().w());
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (paramInt == 3)
    {
      if (4 == this.jdField_a_of_type_ComTencentAvVideoController.g())
      {
        localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (VideoViewInfo)((Iterator)localObject1).next();
          if (!((VideoViewInfo)localObject2).jdField_a_of_type_Boolean) {
            ((VideoViewInfo)localObject2).jdField_c_of_type_Boolean = true;
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() > 0) {
        ((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_Boolean = true;
      }
    }
    else if (paramInt == 4)
    {
      if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().w()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() > 0))
      {
        ((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_d_of_type_JavaLangString, 2, "MultiVideoCtrlLayerUIBase onLayoutModeChange --> displayList  not has big one");
        }
      }
      if (4 == this.jdField_a_of_type_ComTencentAvVideoController.g())
      {
        localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (VideoViewInfo)((Iterator)localObject1).next();
          if (!((VideoViewInfo)localObject2).jdField_a_of_type_Boolean) {
            ((VideoViewInfo)localObject2).jdField_c_of_type_Boolean = true;
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.size() > 0) {
        ((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_Boolean = true;
      }
    }
    e();
  }
  
  void j(long paramLong)
  {
    Object localObject = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "processExtraData-->can not get the activity");
      }
      b(true);
      return;
    }
    localObject = ((AVActivity)localObject).getIntent();
    boolean bool;
    if (localObject != null) {
      bool = ((Intent)localObject).getBooleanExtra("isEnter", false);
    } else {
      bool = false;
    }
    localObject = SessionMgr.a(100, String.valueOf(this.jdField_a_of_type_Long), new int[0]);
    localObject = SessionMgr.a().c((String)localObject);
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("processExtraData uin[");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("], info[");
      localStringBuilder.append(localObject);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    if ((!bool) && ((localObject == null) || (!((SessionInfo)localObject).h())))
    {
      if ((localObject == null) || (((SessionInfo)localObject).jdField_f_of_type_Int == 0))
      {
        localObject = this.jdField_a_of_type_ComTencentAvVideoController;
        long l = this.jdField_a_of_type_Long;
        ((VideoController)localObject).a(3, l, 8, new long[] { l }, false);
        a_(paramLong, 2131695857);
      }
    }
    else
    {
      TraeHelper.a().b(paramLong);
      TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if ((localObject != null) && (((SessionInfo)localObject).jdField_f_of_type_Int == 0))
      {
        b(true);
        return;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 3, this.jdField_a_of_type_Long, null, false);
      a_(paramLong, 2131695503);
    }
  }
  
  public void k(long paramLong) {}
  
  void l()
  {
    super.J();
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_ComTencentAvUtilsQQFrameByFrameAnimation);
  }
  
  void m()
  {
    h(true);
    QavInOutAnimation localQavInOutAnimation = this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation;
    if (localQavInOutAnimation != null) {
      localQavInOutAnimation.a(new DoubleVideoMeetingCtrlUI.2(this));
    }
  }
  
  public void m(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPause, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], quit[");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    super.m(paramLong);
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().af = true;
      this.jdField_a_of_type_ComTencentAvVideoController.a().ae = true;
      if (((!SmallScreenUtils.f()) || ((!NetworkUtil.isWifiConnected((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().ag))) && (this.jdField_a_of_type_ComTencentAvVideoController.a().j))
      {
        this.jdField_a_of_type_ComTencentAvVideoController.x();
        this.jdField_b_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131373640, 8);
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a().n = true;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().z) {
        super.B(paramLong);
      }
      f("OnPause");
      if ((this.jdField_a_of_type_Boolean) || (!SmallScreenUtils.f())) {
        this.jdField_a_of_type_ComTencentAvVideoController.a("Meeting_onPause");
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().b(this.jdField_b_of_type_Long, true, true);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c("DoubleVideoMeetingCtrlUI");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiDoubleVideoMeetingCtrlUI$QueryPeerVideoRunnable);
  }
  
  public void n(long paramLong)
  {
    i(paramLong, 16777215);
  }
  
  public void o()
  {
    super.o();
    r();
  }
  
  void o(long paramLong)
  {
    this.jdField_a_of_type_ComTencentAvVideoController.x();
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
    QAVNotification localQAVNotification = this.jdField_a_of_type_ComTencentAvUtilsQAVNotification;
    if (localQAVNotification != null) {
      localQAVNotification.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentAvVideoController.u();
  }
  
  public void q()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    String str;
    Object localObject;
    if (QLog.isColorLevel())
    {
      str = this.jdField_d_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showNotification quit[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append("], inMeetingRoom[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvVideoController.a().z);
      ((StringBuilder)localObject).append("]");
      QLog.i(str, 2, ((StringBuilder)localObject).toString());
    }
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController.a().z) && (!SessionMgr.a().a()))
    {
      str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
      localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, null, true, true);
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_JavaLangString, str, (Bitmap)localObject, String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Long), 48, 0, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
      this.jdField_a_of_type_ComTencentAvVideoController.t();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoMeetingCtrlUI
 * JD-Core Version:    0.7.0.1
 */