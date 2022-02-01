package com.tencent.av.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.QavChannelProxy;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.VideoUtils;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.InviteMemberObserverWithoutCache;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.compat.AVCallCompactHelper;
import com.tencent.av.gaudio.BaseGaInvite;
import com.tencent.av.gaudio.Memberinfo;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.AvCustomDialog;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QAVGroupConfig.Report;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import mqq.os.MqqHandler;

public class MultiIncomingCallsActivity
  extends BaseGaInvite
{
  public static boolean e = false;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new MultiIncomingCallsActivity.12(this);
  private InviteMemberObserverWithoutCache jdField_a_of_type_ComTencentAvAppInviteMemberObserverWithoutCache = new MultiIncomingCallsActivity.1(this);
  SessionInfo jdField_a_of_type_ComTencentAvAppSessionInfo = null;
  VideoObserver jdField_a_of_type_ComTencentAvAppVideoObserver = new MultiIncomingCallsActivity.13(this);
  MutiMemberThumbList jdField_a_of_type_ComTencentAvUiMutiMemberThumbList;
  AvCustomDialog jdField_a_of_type_ComTencentAvUtilsAvCustomDialog = null;
  QAVNotification jdField_a_of_type_ComTencentAvUtilsQAVNotification;
  private Runnable jdField_a_of_type_JavaLangRunnable = null;
  private ArrayList<Memberinfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  boolean jdField_a_of_type_Boolean = false;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new MultiIncomingCallsActivity.4(this);
  private GAudioUIObserver jdField_b_of_type_ComTencentAvAppGAudioUIObserver = new MultiIncomingCallsActivity.3(this);
  private Runnable jdField_b_of_type_JavaLangRunnable = new MultiIncomingCallsActivity.2(this);
  boolean jdField_b_of_type_Boolean = false;
  long[] jdField_b_of_type_ArrayOfLong = null;
  int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long = 0L;
  TextView jdField_c_of_type_AndroidWidgetTextView = null;
  private Runnable jdField_c_of_type_JavaLangRunnable = null;
  String jdField_c_of_type_JavaLangString = null;
  boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int = -1;
  private Runnable jdField_d_of_type_JavaLangRunnable = null;
  String jdField_d_of_type_JavaLangString = null;
  boolean jdField_d_of_type_Boolean = false;
  int jdField_e_of_type_Int = 0;
  String jdField_e_of_type_JavaLangString = "";
  String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean = false;
  private boolean g = false;
  private boolean h = false;
  
  private void a(long paramLong, ArrayList<VideoController.GAudioFriends> paramArrayList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "handleMemberListUpdate");
    }
    if ((paramLong == this.jdField_a_of_type_Long) && ((paramInt == 10) || (paramInt == 1)))
    {
      this.h = true;
      h();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendIsResumeBroadcast isResume = ");
      localStringBuilder.append(paramBoolean);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), paramBoolean);
  }
  
  private void c(int paramInt)
  {
    boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Long, paramInt);
    if (QLog.isColorLevel())
    {
      String str = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getGAudioRoomMemList ");
      localStringBuilder.append(bool);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (!bool)
    {
      QQToast.a(this, HardCodeUtil.a(2131707043), 1).b(getResources().getDimensionPixelSize(2131299168));
      finish();
    }
  }
  
  private void g()
  {
    MqqHandler localMqqHandler = this.jdField_a_of_type_MqqOsMqqHandler;
    if (localMqqHandler != null)
    {
      localMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 10000L);
    }
  }
  
  private void h()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_b_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("notifyDataChange mHasCallFromMemberList:=");
      ((StringBuilder)localObject2).append(this.h);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    g();
    Object localObject3 = this.jdField_a_of_type_ComTencentAvVideoController.e();
    Object localObject1 = new ArrayList();
    Object localObject2 = new HashSet();
    localObject3 = ((ArrayList)localObject3).iterator();
    Object localObject4;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (VideoController.GAudioFriends)((Iterator)localObject3).next();
      if (((VideoController.GAudioFriends)localObject4).jdField_a_of_type_Long != this.jdField_b_of_type_Long) {
        ((ArrayList)localObject1).add(localObject4);
      }
      ((Set)localObject2).add(Long.valueOf(((VideoController.GAudioFriends)localObject4).jdField_a_of_type_Long));
    }
    int i = ((ArrayList)localObject1).size();
    localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (Memberinfo)((Iterator)localObject3).next();
      if (!((Set)localObject2).contains(Long.valueOf(((Memberinfo)localObject4).jdField_a_of_type_Long)))
      {
        VideoController.GAudioFriends localGAudioFriends = new VideoController.GAudioFriends();
        localGAudioFriends.jdField_a_of_type_Long = ((Memberinfo)localObject4).jdField_a_of_type_Long;
        localGAudioFriends.e = ((Memberinfo)localObject4).jdField_b_of_type_Long;
        if (((Memberinfo)localObject4).jdField_a_of_type_Long == this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin())
        {
          ((ArrayList)localObject1).add(0, localGAudioFriends);
          i += 1;
        }
        else
        {
          ((ArrayList)localObject1).add(localGAudioFriends);
        }
      }
    }
    if (this.jdField_c_of_type_JavaLangRunnable != null)
    {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
      this.jdField_c_of_type_JavaLangRunnable = null;
    }
    this.jdField_c_of_type_JavaLangRunnable = new MultiIncomingCallsActivity.10(this, i, (ArrayList)localObject1);
    ThreadManager.getSubThreadHandler().post(this.jdField_c_of_type_JavaLangRunnable);
  }
  
  void a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    Object localObject = this.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("closeSession, reason[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    localObject = Long.valueOf(CharacterUtil.a(this.jdField_c_of_type_JavaLangString));
    if (this.jdField_a_of_type_Boolean)
    {
      if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, ((Long)localObject).longValue(), 7);
        return;
      }
      if (paramInt == 2) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, ((Long)localObject).longValue(), 2);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentAvAppSessionInfo;
      if (localObject == null) {
        localObject = this.jdField_c_of_type_JavaLangString;
      } else {
        localObject = ((SessionInfo)localObject).jdField_c_of_type_JavaLangString;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject, 241);
      this.jdField_a_of_type_ComTencentAvVideoController.b(241);
    }
  }
  
  void a(long paramLong1, int paramInt1, long paramLong2, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    String str = this.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ignoreMultiCall, refuse3rd[");
    localStringBuilder.append(paramBoolean2);
    localStringBuilder.append("], mVideoController[");
    boolean bool;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if (!paramBoolean2) {
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong1, paramInt1, paramLong2, 10, false);
    } else {
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong1, paramInt1, paramLong2, paramInt2, false);
    }
    if ((paramBoolean1) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(paramLong2), Integer.valueOf(3) });
    }
  }
  
  void a(long paramLong, Intent paramIntent)
  {
    e();
    boolean bool1 = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvUtilsAvCustomDialog = new AvCustomDialog(this, bool1);
    View localView = LayoutInflater.from(this).inflate(2131559687, null);
    if (b()) {
      localObject1 = (ViewStub)localView.findViewById(2131373528);
    } else {
      localObject1 = (ViewStub)localView.findViewById(2131373378);
    }
    if (localObject1 != null) {
      ((ViewStub)localObject1).inflate();
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131373534));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131373533));
    this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131373538));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131373532));
    if (VideoUtils.a())
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131695619);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166048));
    }
    else if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.i())
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131690489);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166048));
    }
    c();
    a(this.jdField_a_of_type_AndroidGraphicsBitmap, 4);
    if (b()) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    } else {
      a(this.jdField_b_of_type_AndroidWidgetTextView);
    }
    this.jdField_a_of_type_ComTencentAvUtilsAvCustomDialog.a(localView, false);
    if (b())
    {
      this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList = ((MutiMemberThumbList)localView.findViewById(2131373539));
      this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList.setBitMapFetcher(this.jdField_a_of_type_ComTencentAvVideoController);
      this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList.setRelationShipInfo(this.jdField_a_of_type_Long, this.jdField_b_of_type_Int);
      localObject2 = this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList;
      if (bool1) {
        localObject1 = "#757575";
      } else {
        localObject1 = "#878B99";
      }
      ((MutiMemberThumbList)localObject2).setTextColor((String)localObject1);
      this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList.setHeadImgMask(bool1);
      this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList.setMoreInfoDrawableColor("#F246505F");
      this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList.setDisPlayList(null);
      this.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_b_of_type_Int, this.jdField_e_of_type_Int, this.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentAvVideoController.a.a(this.jdField_a_of_type_Long, this.jdField_c_of_type_Long, true);
      c(this.jdField_e_of_type_Int);
    }
    Object localObject2 = (Button)localView.findViewById(2131373537);
    ((Button)localObject2).setOnClickListener(new MultiIncomingCallsActivity.6(this, paramLong));
    this.jdField_a_of_type_ComTencentAvUtilsAvCustomDialog.setOnCancelListener(new MultiIncomingCallsActivity.7(this, paramLong));
    this.jdField_a_of_type_ComTencentAvUtilsAvCustomDialog.setOnDismissListener(new MultiIncomingCallsActivity.8(this));
    SessionInfo localSessionInfo = SessionMgr.a().a();
    Object localObject1 = (Button)localView.findViewById(2131373531);
    ((Button)localObject1).setOnClickListener(new MultiIncomingCallsActivity.9(this, paramLong, paramIntent, localSessionInfo));
    if (b())
    {
      ((Button)localObject1).setText(2131695666);
      ((Button)localObject2).setText(2131695672);
    }
    else
    {
      ((Button)localObject1).setText(2131695666);
      ((Button)localObject2).setText(2131695673);
    }
    if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
      ((Button)localObject1).setCompoundDrawablesWithIntrinsicBounds(super.getResources().getDrawable(2130842261), null, null, null);
    }
    boolean bool2 = b();
    if (bool1)
    {
      int j = Color.parseColor("#A8A8A8");
      int i;
      if (bool2) {
        i = 2131373530;
      } else {
        i = 2131373379;
      }
      localView.findViewById(i).setBackgroundDrawable(getResources().getDrawable(2130851060));
      paramIntent = localView.findViewById(2131373535);
      paramIntent.setBackgroundDrawable(UITools.a(67.199997F, this));
      paramIntent.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(j);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(j);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(j);
      localView.findViewById(2131365624).setBackgroundColor(Color.parseColor("#262626"));
      paramIntent = getResources().getDrawable(2130842188);
      paramIntent.setBounds(0, 0, paramIntent.getIntrinsicWidth(), paramIntent.getIntrinsicHeight());
      ((Button)localObject2).setCompoundDrawables(paramIntent, null, null, null);
      ((Button)localObject2).setCompoundDrawablePadding(0);
      ((Button)localObject2).setTextColor(j);
      localView.findViewById(2131373541).setBackgroundColor(Color.parseColor("#262626"));
      paramIntent = getResources().getDrawable(2130842186);
      paramIntent.setBounds(0, 0, paramIntent.getIntrinsicWidth(), paramIntent.getIntrinsicHeight());
      ((Button)localObject1).setCompoundDrawables(paramIntent, null, null, null);
      ((Button)localObject1).setCompoundDrawablePadding(0);
      ((Button)localObject1).setTextColor(j);
    }
    this.jdField_a_of_type_ComTencentAvUtilsAvCustomDialog.show();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, String.format("begin show dialog, mPeerUin[%s], mExtraUin[%s], mIsDoubleVideoMeeting[%s], mUinType[%s], mRelationType[%s], mMemberType[%s], mHasGVideoJoined[%s], mIsAudioMode[%s], mBindType[%s]", new Object[] { this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, Boolean.valueOf(this.jdField_a_of_type_Boolean), Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_d_of_type_Int), Boolean.valueOf(this.jdField_c_of_type_Boolean), Boolean.valueOf(this.jdField_b_of_type_Boolean), Integer.valueOf(this.jdField_c_of_type_Int) }));
    }
    TraeHelper.a().a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230740, null, 0, null);
  }
  
  public void a(long paramLong, Intent paramIntent, SessionInfo paramSessionInfo)
  {
    QAVGroupConfig.Report.a(true);
    sendBroadcast(new Intent("com.tencent.werewoves.plugin"));
    sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
    sendBroadcast(new Intent("tencent.video.v2g.exitAVGame"));
    b(1);
    if (VideoUtils.a())
    {
      sendBroadcast(new Intent("tencent.av.EXIT_QZONE_LIVE_REQ_ACTION"));
      return;
    }
    a(paramLong, "onClickAccept", paramIntent, paramSessionInfo);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(3) });
    b("onClickAccept");
  }
  
  void a(long paramLong, String paramString, Intent paramIntent, SessionInfo paramSessionInfo)
  {
    SessionInfo localSessionInfo = SessionMgr.a().a();
    String str = this.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("acceptRequest, from[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], HandleSessionInfo[");
    localStringBuilder.append(paramSessionInfo);
    localStringBuilder.append("], CurMainSession[");
    localStringBuilder.append(localSessionInfo);
    localStringBuilder.append("], mSessionInfo[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvAppSessionInfo);
    localStringBuilder.append("], SameSession[");
    boolean bool;
    if (paramSessionInfo == localSessionInfo) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("], getAliveSessionCount[");
    localStringBuilder.append(SessionMgr.a().a());
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    this.jdField_d_of_type_Boolean = true;
    if ((paramSessionInfo != null) && (localSessionInfo == paramSessionInfo) && (SessionMgr.a().a() >= 2))
    {
      this.jdField_a_of_type_ComTencentAvVideoController.h(true);
      if (paramSessionInfo.h())
      {
        a(paramLong, paramString, false, paramSessionInfo, -1);
      }
      else
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(true, 205, new int[] { localSessionInfo.j });
        this.jdField_a_of_type_ComTencentAvVideoController.b(205);
      }
      a(paramSessionInfo);
    }
    paramString = this.jdField_a_of_type_ComTencentAvAppSessionInfo;
    if ((paramString != null) && (!paramString.h()))
    {
      if (QLog.isColorLevel())
      {
        paramString = this.jdField_b_of_type_JavaLangString;
        paramIntent = new StringBuilder();
        paramIntent.append("Session already destroyed, id:");
        paramIntent.append(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString);
        paramIntent.append(", status = ");
        paramIntent.append(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_f_of_type_Int);
        QLog.d(paramString, 2, paramIntent.toString());
      }
    }
    else
    {
      if (b())
      {
        d();
        return;
      }
      b(paramIntent);
    }
  }
  
  void a(long paramLong, String paramString, boolean paramBoolean, SessionInfo paramSessionInfo, int paramInt)
  {
    String str = this.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ignoreRequest[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], refuse3rd[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], mainSessionInfo[");
    localStringBuilder.append(paramSessionInfo);
    localStringBuilder.append("], iFlag[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (paramBoolean) {
      this.jdField_d_of_type_Boolean = false;
    }
    TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    paramString = this.jdField_c_of_type_JavaLangString;
    boolean bool1 = this.jdField_a_of_type_Boolean;
    int i = this.jdField_b_of_type_Int;
    long l = this.jdField_a_of_type_Long;
    if (!paramBoolean) {
      if (paramSessionInfo != null)
      {
        str = paramSessionInfo.jdField_c_of_type_JavaLangString;
        paramString = str;
        if (TextUtils.isEmpty(str)) {
          paramString = paramSessionInfo.r;
        }
        bool1 = paramSessionInfo.y;
        i = paramSessionInfo.E;
        l = paramSessionInfo.jdField_f_of_type_Long;
      }
      else
      {
        return;
      }
    }
    int j = UITools.c(i);
    boolean bool2;
    if ((!paramBoolean) && ((bool1) || (a(j)))) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if (a(j))
    {
      a(paramLong, i, l, bool2, paramInt, paramBoolean);
      return;
    }
    a(paramLong, bool1, paramString, bool2, paramBoolean);
  }
  
  void a(long paramLong, boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "refuseDoubleCall mVideoController is null");
      return;
    }
    String str = this.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("refuseDoubleCall, isDoubleVideoMeeting[");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append("], peerUin[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], notifyDestroyUI[");
    localStringBuilder.append(paramBoolean2);
    localStringBuilder.append("], refuse3rd[");
    localStringBuilder.append(paramBoolean3);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, paramString, 1, true);
      long l2 = -1L;
      long l1;
      try
      {
        l1 = CharacterUtil.a(paramString);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "", localNumberFormatException);
          l1 = l2;
        }
      }
      if (!paramBoolean3)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 3, l1, 10, false);
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, l1, 23);
      }
      else
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 3, l1);
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, l1, 1);
      }
    }
    else
    {
      VideoController localVideoController = this.jdField_a_of_type_ComTencentAvVideoController;
      localVideoController.a(paramLong, paramString, 1, false, new MultiIncomingCallsActivity.11(this, localVideoController, paramString, paramBoolean3));
    }
    if ((paramBoolean2) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), paramString, Boolean.valueOf(true) });
    }
  }
  
  public void a(Intent paramIntent)
  {
    long l = QQAudioHelper.b();
    this.jdField_b_of_type_Int = 3;
    super.a(paramIntent);
    if (paramIntent == null) {
      return;
    }
    this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("peerUin");
    this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("extraUin");
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("isDoubleVideoMeeting", false);
    this.jdField_d_of_type_Int = paramIntent.getIntExtra("memberType", -1);
    this.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("hasGVideoJoined", false);
    this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("isAudioMode", false);
    this.jdField_c_of_type_Int = paramIntent.getIntExtra("bindType", 0);
    String str = SessionMgr.a(3, this.jdField_c_of_type_JavaLangString, new int[0]);
    if (this.jdField_a_of_type_Boolean)
    {
      str = SessionMgr.a(100, this.jdField_c_of_type_JavaLangString, new int[0]);
      this.jdField_b_of_type_Boolean = false;
    }
    if (b())
    {
      this.jdField_e_of_type_Int = paramIntent.getIntExtra("MultiAVType", -1);
      if (this.jdField_e_of_type_Int == 2) {
        this.jdField_b_of_type_Boolean = false;
      } else {
        this.jdField_b_of_type_Boolean = true;
      }
      this.jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("inviteId");
      str = SessionMgr.a(this.jdField_b_of_type_Int, String.valueOf(this.jdField_a_of_type_Long), new int[0]);
      this.jdField_b_of_type_ArrayOfLong = paramIntent.getLongArrayExtra("memberList");
      int i = AVUtil.c(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, String.valueOf(this.jdField_b_of_type_Long), String.valueOf(this.jdField_a_of_type_Long));
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, String.valueOf(this.jdField_b_of_type_Long), this.jdField_d_of_type_JavaLangString, true, true);
    }
    else
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, true, true);
    }
    this.jdField_a_of_type_ComTencentAvAppSessionInfo = SessionMgr.a().c(str);
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo == null)
    {
      b("processIntent_fail");
      return;
    }
    if (!a(paramIntent)) {
      a(l, paramIntent);
    }
  }
  
  void a(TextView paramTextView)
  {
    if (paramTextView == null) {
      return;
    }
    float f1 = super.getResources().getDimensionPixelSize(2131297876);
    String str1;
    if (b())
    {
      String str2 = String.valueOf(this.jdField_a_of_type_Long);
      str1 = super.getApplicationContext().getString(2131695510);
      int j = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_b_of_type_Int, str2);
      int i = j;
      if (j == 0)
      {
        localObject = this.jdField_b_of_type_ArrayOfLong;
        if (localObject != null) {
          i = localObject.length + 1;
        } else {
          i = 1;
        }
      }
      if (i > 999) {}
      for (j = super.getResources().getDimensionPixelSize(2131297878);; j = super.getResources().getDimensionPixelSize(2131297877))
      {
        f1 = j;
        break;
        if (i <= 99) {
          break;
        }
      }
      str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Int, str2, null);
      str2 = UITools.a(super.getApplicationContext(), str2, paramTextView, f1);
      str1 = String.format(str1, new Object[] { Integer.valueOf(i) });
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append(str1);
      str1 = ((StringBuilder)localObject).toString();
    }
    else
    {
      str1 = this.jdField_a_of_type_JavaLangString;
    }
    paramTextView.setText(str1);
  }
  
  void a(SessionInfo paramSessionInfo)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (paramSessionInfo != null))
    {
      Intent localIntent = new Intent();
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      localIntent.setAction("tencent.av.v2q.StopVideoChat");
      localIntent.putExtra("stopReason3rd", 1);
      localIntent.putExtra("groupId", paramSessionInfo.jdField_f_of_type_Long);
      localIntent.putExtra("peerUin", paramSessionInfo.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
    }
  }
  
  public boolean a(Intent paramIntent)
  {
    boolean bool2 = false;
    if (paramIntent == null) {
      return false;
    }
    long l = QQAudioHelper.b();
    String str1 = paramIntent.getAction();
    boolean bool1 = bool2;
    Object localObject;
    if ("com.tencent.qav.notify.accept".equals(str1))
    {
      String str2 = paramIntent.getStringExtra("session_id");
      localObject = this.jdField_a_of_type_ComTencentAvAppSessionInfo;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((SessionInfo)localObject).jdField_b_of_type_JavaLangString;
      }
      if (TextUtils.equals(str2, (CharSequence)localObject))
      {
        a(l, paramIntent, SessionMgr.a().a());
        bool1 = true;
      }
      else
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          paramIntent = this.jdField_b_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkParamAndDoAction coming[");
          localStringBuilder.append(str2);
          localStringBuilder.append("], cur[");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("]");
          QLog.i(paramIntent, 2, localStringBuilder.toString());
          bool1 = bool2;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramIntent = this.jdField_b_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkParamAndDoAction action[");
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("]");
      QLog.i(paramIntent, 2, ((StringBuilder)localObject).toString());
    }
    return bool1;
  }
  
  public void b()
  {
    QAVNotification localQAVNotification = this.jdField_a_of_type_ComTencentAvUtilsQAVNotification;
    if (localQAVNotification != null) {
      localQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString);
    }
    b(2);
    a(QQAudioHelper.b(), "onInviteTimeOut", true, SessionMgr.a().a(), 8);
    b("onInviteTimeOut");
  }
  
  void b(int paramInt)
  {
    try
    {
      SessionInfo localSessionInfo = SessionMgr.a().a();
      if ((localSessionInfo != null) && (SessionMgr.a().a() >= 2))
      {
        int i = localSessionInfo.jdField_f_of_type_Int;
        int j = localSessionInfo.jdField_c_of_type_Int;
        Object localObject3 = null;
        StringBuilder localStringBuilder = null;
        Object localObject4 = null;
        Object localObject5 = null;
        Object localObject6 = null;
        Object localObject7 = null;
        Object localObject8 = null;
        Object localObject1 = null;
        if (localSessionInfo.y)
        {
          if (paramInt == 0)
          {
            localObject3 = "0X8005BAA";
          }
          else if (paramInt == 1)
          {
            localObject3 = "0X8005BAB";
          }
          else
          {
            localObject3 = localObject1;
            if (paramInt == 2) {
              localObject3 = "0X8005BAC";
            }
          }
          localObject1 = localObject3;
          if (QLog.isColorLevel())
          {
            localObject1 = this.jdField_b_of_type_JavaLangString;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("double share, action:");
            localStringBuilder.append(paramInt);
            localStringBuilder.append(", reportType:");
            localStringBuilder.append((String)localObject3);
            QLog.d((String)localObject1, 2, localStringBuilder.toString());
            localObject1 = localObject3;
          }
        }
        for (;;)
        {
          break;
          if ((localSessionInfo.E == 1) && (localSessionInfo.jdField_d_of_type_Int == 3))
          {
            if (paramInt == 0)
            {
              localObject3 = "0X8005BB3";
            }
            else if (paramInt == 1)
            {
              localObject3 = "0X8005BB4";
            }
            else
            {
              localObject3 = localStringBuilder;
              if (paramInt == 2) {
                localObject3 = "0X8005BB5";
              }
            }
            localObject1 = localObject3;
            if (QLog.isColorLevel())
            {
              localObject1 = this.jdField_b_of_type_JavaLangString;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("group audio, action:");
              localStringBuilder.append(paramInt);
              localStringBuilder.append(", reportType:");
              localStringBuilder.append((String)localObject3);
              QLog.d((String)localObject1, 2, localStringBuilder.toString());
              localObject1 = localObject3;
            }
          }
          else if ((localSessionInfo.E == 1) && (localSessionInfo.jdField_d_of_type_Int == 4))
          {
            if (paramInt == 0)
            {
              localObject3 = "0X8005BB6";
            }
            else if (paramInt == 1)
            {
              localObject3 = "0X8005BB7";
            }
            else
            {
              localObject3 = localObject4;
              if (paramInt == 2) {
                localObject3 = "0X8005BB8";
              }
            }
            localObject1 = localObject3;
            if (QLog.isColorLevel())
            {
              localObject1 = this.jdField_b_of_type_JavaLangString;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("group video, action:");
              localStringBuilder.append(paramInt);
              localStringBuilder.append(", reportType:");
              localStringBuilder.append((String)localObject3);
              QLog.d((String)localObject1, 2, localStringBuilder.toString());
              localObject1 = localObject3;
            }
          }
          else if ((localSessionInfo.E == 2) && (localSessionInfo.jdField_d_of_type_Int == 3))
          {
            if (paramInt == 0)
            {
              localObject3 = "0X8005BAD";
            }
            else if (paramInt == 1)
            {
              localObject3 = "0X8005BAE";
            }
            else
            {
              localObject3 = localObject5;
              if (paramInt == 2) {
                localObject3 = "0X8005BAF";
              }
            }
            localObject1 = localObject3;
            if (QLog.isColorLevel())
            {
              localObject1 = this.jdField_b_of_type_JavaLangString;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("discuss audio, action:");
              localStringBuilder.append(paramInt);
              localStringBuilder.append(", reportType:");
              localStringBuilder.append((String)localObject3);
              QLog.d((String)localObject1, 2, localStringBuilder.toString());
              localObject1 = localObject3;
            }
          }
          else if ((localSessionInfo.E == 2) && (localSessionInfo.jdField_d_of_type_Int == 4))
          {
            if (paramInt == 0)
            {
              localObject3 = "0X8005BB0";
            }
            else if (paramInt == 1)
            {
              localObject3 = "0X8005BB1";
            }
            else
            {
              localObject3 = localObject6;
              if (paramInt == 2) {
                localObject3 = "0X8005BB2";
              }
            }
            localObject1 = localObject3;
            if (QLog.isColorLevel())
            {
              localObject1 = this.jdField_b_of_type_JavaLangString;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("discuss video, action:");
              localStringBuilder.append(paramInt);
              localStringBuilder.append(", reportType:");
              localStringBuilder.append((String)localObject3);
              QLog.d((String)localObject1, 2, localStringBuilder.toString());
              localObject1 = localObject3;
            }
          }
          else if ((localSessionInfo.jdField_d_of_type_Int != 2) && ((localSessionInfo.jdField_e_of_type_Int != 2) || ((i != 1) && (i != 2))))
          {
            if ((localSessionInfo.jdField_d_of_type_Int != 1) && ((localSessionInfo.jdField_e_of_type_Int != 1) || ((i != 1) && (i != 2))))
            {
              localObject1 = localObject3;
              if (QLog.isColorLevel())
              {
                localObject1 = this.jdField_b_of_type_JavaLangString;
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("nothing, action:");
                localStringBuilder.append(paramInt);
                localStringBuilder.append(", reportType:");
                localStringBuilder.append(null);
                localStringBuilder.append("SessionType:");
                localStringBuilder.append(localSessionInfo.jdField_d_of_type_Int);
                localStringBuilder.append(", BeginSessionType:");
                localStringBuilder.append(localSessionInfo.jdField_e_of_type_Int);
                localStringBuilder.append(", sessionStatus:");
                localStringBuilder.append(j);
                localStringBuilder.append(", state:");
                localStringBuilder.append(i);
                QLog.d((String)localObject1, 2, localStringBuilder.toString());
                localObject1 = localObject3;
              }
            }
            else
            {
              if (paramInt == 0)
              {
                localObject3 = "0X8005BA4";
              }
              else if (paramInt == 1)
              {
                localObject3 = "0X8005BA5";
              }
              else
              {
                localObject3 = localObject7;
                if (paramInt == 2) {
                  localObject3 = "0X8005BA6";
                }
              }
              localObject1 = localObject3;
              if (QLog.isColorLevel())
              {
                localObject1 = this.jdField_b_of_type_JavaLangString;
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("double audio, action:");
                localStringBuilder.append(paramInt);
                localStringBuilder.append(", reportType:");
                localStringBuilder.append((String)localObject3);
                QLog.d((String)localObject1, 2, localStringBuilder.toString());
                localObject1 = localObject3;
              }
            }
          }
          else
          {
            if (paramInt == 0)
            {
              localObject3 = "0X8005BA7";
            }
            else if (paramInt == 1)
            {
              localObject3 = "0X8005BA8";
            }
            else
            {
              localObject3 = localObject8;
              if (paramInt == 2) {
                localObject3 = "0X8005BA9";
              }
            }
            localObject1 = localObject3;
            if (QLog.isColorLevel())
            {
              localObject1 = this.jdField_b_of_type_JavaLangString;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("double video, action:");
              localStringBuilder.append(paramInt);
              localStringBuilder.append(", reportType:");
              localStringBuilder.append((String)localObject3);
              QLog.d((String)localObject1, 2, localStringBuilder.toString());
              localObject1 = localObject3;
            }
          }
        }
        if (localObject1 != null) {
          ReportController.b(null, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
        }
        return;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  void b(Intent paramIntent)
  {
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "startVideoChatActivity");
    TraeHelper.a().a();
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.l)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(113) });
    }
    Intent localIntent = new Intent(super.getApplicationContext(), AVActivity.class);
    localIntent.addFlags(262144);
    Object localObject = this.jdField_a_of_type_ComTencentAvAppSessionInfo;
    String str = null;
    int i;
    if (localObject != null)
    {
      str = ((SessionInfo)localObject).o;
      i = this.jdField_a_of_type_ComTencentAvAppSessionInfo.A;
      localObject = this.jdField_a_of_type_ComTencentAvAppSessionInfo.a;
    }
    else
    {
      localObject = null;
      i = -1;
    }
    int j = paramIntent.getIntExtra("uinType", -1);
    boolean bool = paramIntent.getBooleanExtra("isAudioMode", false);
    if (this.jdField_a_of_type_Boolean)
    {
      paramIntent = super.getIntent().getStringExtra("peerUin");
      localIntent.putExtra("sessionType", 3);
      localIntent.putExtra("Type", 1);
      localIntent.putExtra("uin", paramIntent);
      localIntent.putExtra("uinType", 0);
      localIntent.putExtra("isDoubleVideoMeeting", true);
      localIntent.putExtra("inviteUin", paramIntent);
      localIntent.putExtra("sessionType", 1);
      localIntent.putExtra("isSender", false);
      localIntent.putExtra("isEnter", true);
      localIntent.putExtra("name", this.jdField_a_of_type_JavaLangString);
    }
    else
    {
      localIntent.putExtra("uinType", j);
      localIntent.putExtra("bindType", i);
      localIntent.putExtra("bindId", str);
      localIntent.putExtra("uin", this.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("name", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("extraUin", this.jdField_d_of_type_JavaLangString);
      localIntent.putExtra("receive", true);
      localIntent.putExtra("isAudioMode", bool);
      localIntent.putExtra("sig", (byte[])localObject);
      if (QLog.isColorLevel())
      {
        localObject = this.jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startVideoChatActivity: bindType = ");
        localStringBuilder.append(i);
        localStringBuilder.append(",bindId = ");
        localStringBuilder.append(str);
        localStringBuilder.append(",BindType = ");
        paramIntent = this.jdField_a_of_type_ComTencentAvAppSessionInfo;
        if (paramIntent == null) {
          paramIntent = "session info null";
        } else {
          paramIntent = Integer.valueOf(paramIntent.A);
        }
        localStringBuilder.append(paramIntent);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      if (j == 0) {
        localIntent.putExtra("isFriend", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_c_of_type_JavaLangString));
      }
      if (bool) {
        localIntent.putExtra("sessionType", 1);
      } else {
        localIntent.putExtra("sessionType", 2);
      }
      localIntent.putExtra("isSender", false);
    }
    super.startActivity(localIntent);
    super.overridePendingTransition(2130772220, 2130772219);
  }
  
  void b(String paramString)
  {
    String str = this.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("destroyUI[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    e();
    super.finish();
  }
  
  void c()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine();
    if (b())
    {
      localObject = a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Long, null, this.jdField_b_of_type_Boolean, true);
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695651);
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    int i;
    if (this.jdField_b_of_type_Boolean) {
      i = 2131695664;
    } else {
      i = 2131695665;
    }
    ((TextView)localObject).setText(i);
  }
  
  void d()
  {
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "startGActivity");
    Intent localIntent = new Intent(this, AVActivity.class);
    localIntent.addFlags(262144);
    localIntent.addFlags(268435456);
    localIntent.putExtra("sessionType", 3);
    localIntent.putExtra("GroupId", String.valueOf(this.jdField_a_of_type_Long));
    localIntent.putExtra("Type", 1);
    localIntent.putExtra("DiscussUinList", this.jdField_b_of_type_ArrayOfLong);
    localIntent.putExtra("needStartTRAE", true);
    localIntent.putExtra("MultiAVType", this.jdField_a_of_type_ComTencentAvAppSessionInfo.j);
    localIntent.putExtra("uin", String.valueOf(this.jdField_a_of_type_Long));
    localIntent.putExtra("uinType", this.jdField_a_of_type_Int);
    localIntent.putExtra("isFromInviteDialog", true);
    super.startActivity(localIntent);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  void e()
  {
    AvCustomDialog localAvCustomDialog = this.jdField_a_of_type_ComTencentAvUtilsAvCustomDialog;
    if (localAvCustomDialog != null)
    {
      try
      {
        localAvCustomDialog.dismiss();
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      this.jdField_a_of_type_ComTencentAvUtilsAvCustomDialog = null;
    }
  }
  
  void f()
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification == null) {
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    Object localObject;
    if (b())
    {
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo != null)
      {
        localObject = String.valueOf(this.jdField_a_of_type_Long);
        Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Int, (String)localObject, null, true, true);
        String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(AVUtil.c(this.jdField_b_of_type_Int), Long.toString(this.jdField_b_of_type_Long), (String)localObject);
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString, str, localBitmap, (String)localObject, 57, this.jdField_a_of_type_Int, 3);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, true, true);
      if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, (Bitmap)localObject, null, 56, this.jdField_a_of_type_Int, 2);
        return;
      }
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, (Bitmap)localObject, null, 55, this.jdField_a_of_type_Int, 1);
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    long l = QQAudioHelper.b();
    String str = this.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreate, seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    super.onCreate(paramBundle);
    super.getWindow().setBackgroundDrawableResource(2130851081);
    super.getWindow().addFlags(128);
    paramBundle = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if ((paramBundle != null) && (paramBundle.a(this)))
    {
      this.jdField_f_of_type_Boolean = true;
      return;
    }
    TraeHelper.a().b(l);
    a(super.getIntent());
    paramBundle = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (paramBundle != null) {
      paramBundle.a(getClass().getName(), getIntent());
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      if (!b()) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
      if (b())
      {
        this.jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getUIHandler();
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppInviteMemberObserverWithoutCache);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_b_of_type_ComTencentAvAppGAudioUIObserver);
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = new MultiIncomingCallsActivity.5(this);
        registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("tencent.video.q2v.GvideoMemInviteUpdate"));
      }
    }
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.av.EXIT_QZONE_LIVE_RSP_ACTION");
    try
    {
      registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, paramBundle);
    }
    catch (Throwable paramBundle)
    {
      paramBundle.printStackTrace();
    }
    this.g = true;
    int i;
    if (b()) {
      i = 30000;
    } else {
      i = 60000;
    }
    a(i);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    jdField_e_of_type_Boolean = false;
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onDestroy");
    e();
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppInviteMemberObserverWithoutCache);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_b_of_type_ComTencentAvAppGAudioUIObserver);
    }
    BroadcastReceiver localBroadcastReceiver = this.jdField_a_of_type_AndroidContentBroadcastReceiver;
    if (localBroadcastReceiver != null)
    {
      try
      {
        unregisterReceiver(localBroadcastReceiver);
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
      }
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList;
    if (localObject1 != null) {
      ((MutiMemberThumbList)localObject1).a();
    }
    localObject1 = this.jdField_a_of_type_MqqOsMqqHandler;
    if (localObject1 != null)
    {
      ((MqqHandler)localObject1).removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_MqqOsMqqHandler = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null)
    {
      localObject1 = SessionMgr.a().a();
      Object localObject2 = this.jdField_a_of_type_ComTencentAvAppSessionInfo;
      if (localObject2 != localObject1) {
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(((SessionInfo)localObject2).jdField_b_of_type_JavaLangString);
      }
      if (localObject1 != null) {
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.b(((SessionInfo)localObject1).jdField_b_of_type_JavaLangString);
      }
      if ((localObject1 != null) && (((SessionInfo)localObject1).jdField_b_of_type_JavaLangString != null) && (!((SessionInfo)localObject1).jdField_b_of_type_JavaLangString.equals(this.jdField_f_of_type_JavaLangString))) {
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_f_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
      if (QLog.isColorLevel())
      {
        localObject2 = this.jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onDestroy main[");
        localStringBuilder.append(localObject1);
        localStringBuilder.append("], cur[");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentAvAppSessionInfo);
        localStringBuilder.append("], id[");
        localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
        localStringBuilder.append("]");
        QLog.i((String)localObject2, 2, localStringBuilder.toString());
      }
    }
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (!this.jdField_f_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(707) });
    }
    try
    {
      if (this.g)
      {
        unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
        this.g = false;
      }
    }
    catch (Throwable localThrowable2)
    {
      localThrowable2.printStackTrace();
    }
    if (this.jdField_d_of_type_JavaLangRunnable != null)
    {
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
      this.jdField_d_of_type_JavaLangRunnable = null;
    }
    if (this.jdField_c_of_type_JavaLangRunnable != null)
    {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
      this.jdField_c_of_type_JavaLangRunnable = null;
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((!this.jdField_d_of_type_Boolean) && (paramInt == 4))
    {
      b(2);
      a(QQAudioHelper.b(), "onKeyDown", true, null, -1);
      b("onKeyDown");
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onNewIntent");
    }
    a(paramIntent);
  }
  
  protected void onPause()
  {
    super.onPause();
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onPause");
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(this, 2, true);
    a(false);
  }
  
  protected void onResume()
  {
    super.onResume();
    jdField_e_of_type_Boolean = true;
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onResume");
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(this, 2, false);
    a(true);
    b(0);
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvVideoController.a(MultiIncomingCallsActivity.class);
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onStart");
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification == null) {
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString);
    SessionInfo localSessionInfo = SessionMgr.a().a();
    if ((localSessionInfo != null) && (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString.equals(localSessionInfo.jdField_b_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(false, null);
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(localSessionInfo.jdField_b_of_type_JavaLangString);
      this.jdField_f_of_type_JavaLangString = localSessionInfo.jdField_b_of_type_JavaLangString;
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onStop");
    if (!super.isFinishing())
    {
      f();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(true, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallsActivity
 * JD-Core Version:    0.7.0.1
 */