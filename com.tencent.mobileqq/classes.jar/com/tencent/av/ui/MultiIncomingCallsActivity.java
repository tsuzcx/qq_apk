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
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.SessionInfo.GuildInfo;
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
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.QAVGroupConfig.Report;
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
  public static boolean e;
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
  
  static
  {
    jdField_e_of_type_Boolean = false;
  }
  
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
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "sendIsResumeBroadcast isResume = " + paramBoolean);
    }
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), paramBoolean);
  }
  
  private void c(int paramInt)
  {
    boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Long, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "getGAudioRoomMemList " + bool);
    }
    if (!bool)
    {
      QQToast.a(this, HardCodeUtil.a(2131707021), 1).b(getResources().getDimensionPixelSize(2131299166));
      finish();
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 10000L);
    }
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "notifyDataChange mHasCallFromMemberList:=" + this.h);
    }
    g();
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.e();
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    localObject1 = ((ArrayList)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (VideoController.GAudioFriends)((Iterator)localObject1).next();
      if (((VideoController.GAudioFriends)localObject2).jdField_a_of_type_Long != this.jdField_b_of_type_Long) {
        localArrayList.add(localObject2);
      }
      localHashSet.add(Long.valueOf(((VideoController.GAudioFriends)localObject2).jdField_a_of_type_Long));
    }
    int i = localArrayList.size();
    localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Memberinfo)((Iterator)localObject1).next();
      VideoController.GAudioFriends localGAudioFriends;
      if (!localHashSet.contains(Long.valueOf(((Memberinfo)localObject2).jdField_a_of_type_Long)))
      {
        localGAudioFriends = new VideoController.GAudioFriends();
        localGAudioFriends.jdField_a_of_type_Long = ((Memberinfo)localObject2).jdField_a_of_type_Long;
        localGAudioFriends.e = ((Memberinfo)localObject2).jdField_b_of_type_Long;
        if (((Memberinfo)localObject2).jdField_a_of_type_Long == this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin())
        {
          localArrayList.add(0, localGAudioFriends);
          i += 1;
        }
      }
      for (;;)
      {
        break;
        localArrayList.add(localGAudioFriends);
      }
    }
    if (this.jdField_c_of_type_JavaLangRunnable != null)
    {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
      this.jdField_c_of_type_JavaLangRunnable = null;
    }
    this.jdField_c_of_type_JavaLangRunnable = new MultiIncomingCallsActivity.10(this, i, localArrayList);
    ThreadManager.getSubThreadHandler().post(this.jdField_c_of_type_JavaLangRunnable);
  }
  
  void a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    do
    {
      return;
      QLog.w(this.jdField_b_of_type_JavaLangString, 1, "closeSession, reason[" + paramInt + "], seq[" + paramLong + "]");
      localObject = Long.valueOf(CharacterUtil.a(this.jdField_c_of_type_JavaLangString));
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, ((Long)localObject).longValue(), 7);
        return;
      }
    } while (paramInt != 2);
    this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, ((Long)localObject).longValue(), 2);
    return;
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo == null) {}
    for (Object localObject = this.jdField_c_of_type_JavaLangString;; localObject = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_d_of_type_JavaLangString)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject, 241);
      this.jdField_a_of_type_ComTencentAvVideoController.b(241);
      return;
    }
  }
  
  void a(long paramLong1, int paramInt1, long paramLong2, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    String str = this.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("ignoreMultiCall, refuse3rd[").append(paramBoolean2).append("], mVideoController[");
    boolean bool;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      bool = true;
      QLog.w(str, 1, bool + "], seq[" + paramLong1 + "]");
      if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
        break label88;
      }
    }
    for (;;)
    {
      return;
      bool = false;
      break;
      label88:
      if (!paramBoolean2) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong1, paramInt1, paramLong2, 10, false);
      }
      while ((paramBoolean1) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(paramLong2), Integer.valueOf(3) });
        return;
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong1, paramInt1, paramLong2, paramInt2, false);
      }
    }
  }
  
  void a(long paramLong, Intent paramIntent)
  {
    e();
    boolean bool1 = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvUtilsAvCustomDialog = new AvCustomDialog(this, bool1);
    View localView = LayoutInflater.from(this).inflate(2131559810, null);
    Object localObject1;
    label171:
    label211:
    Object localObject2;
    label285:
    label488:
    int j;
    if (b())
    {
      localObject1 = (ViewStub)localView.findViewById(2131373956);
      if (localObject1 != null) {
        ((ViewStub)localObject1).inflate();
      }
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131373962));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131373961));
      this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine();
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131373966));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131373960));
      if (!VideoUtils.a()) {
        break label903;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131695608);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166037));
      c();
      if (!b()) {
        break label943;
      }
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvUtilsAvCustomDialog.a(localView, false);
      if (b())
      {
        this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList = ((MutiMemberThumbList)localView.findViewById(2131373967));
        this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList.setBitMapFetcher(this.jdField_a_of_type_ComTencentAvVideoController);
        this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList.setRelationShipInfo(this.jdField_a_of_type_Long, this.jdField_b_of_type_Int);
        localObject2 = this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList;
        if (!bool1) {
          break label972;
        }
        localObject1 = "#757575";
        ((MutiMemberThumbList)localObject2).setTextColor((String)localObject1);
        this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList.setHeadImgMask(bool1);
        this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList.setMoreInfoDrawableColor("#F246505F");
        this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList.setDisPlayList(null);
        this.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_b_of_type_Int, this.jdField_e_of_type_Int, this.jdField_a_of_type_Long);
        this.jdField_a_of_type_ComTencentAvVideoController.a.a(this.jdField_a_of_type_Long, this.jdField_c_of_type_Long, true);
        c(this.jdField_e_of_type_Int);
      }
      localObject2 = (Button)localView.findViewById(2131373965);
      ((Button)localObject2).setOnClickListener(new MultiIncomingCallsActivity.6(this, paramLong));
      this.jdField_a_of_type_ComTencentAvUtilsAvCustomDialog.setOnCancelListener(new MultiIncomingCallsActivity.7(this, paramLong));
      this.jdField_a_of_type_ComTencentAvUtilsAvCustomDialog.setOnDismissListener(new MultiIncomingCallsActivity.8(this));
      SessionInfo localSessionInfo = SessionMgr.a().a();
      localObject1 = (Button)localView.findViewById(2131373959);
      ((Button)localObject1).setOnClickListener(new MultiIncomingCallsActivity.9(this, paramLong, paramIntent, localSessionInfo));
      if (!b()) {
        break label980;
      }
      ((Button)localObject1).setText(2131695652);
      ((Button)localObject2).setText(2131695658);
      if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
        ((Button)localObject1).setCompoundDrawablesWithIntrinsicBounds(super.getResources().getDrawable(2130842363), null, null, null);
      }
      boolean bool2 = b();
      if (bool1)
      {
        j = Color.parseColor("#A8A8A8");
        if (!bool2) {
          break label999;
        }
      }
    }
    label903:
    label943:
    label972:
    label980:
    label999:
    for (int i = 2131373958;; i = 2131373807)
    {
      localView.findViewById(i).setBackgroundDrawable(getResources().getDrawable(2130851146));
      paramIntent = localView.findViewById(2131373963);
      paramIntent.setBackgroundDrawable(UITools.a(67.199997F, this));
      paramIntent.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(j);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(j);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(j);
      localView.findViewById(2131365787).setBackgroundColor(Color.parseColor("#262626"));
      paramIntent = getResources().getDrawable(2130842290);
      paramIntent.setBounds(0, 0, paramIntent.getIntrinsicWidth(), paramIntent.getIntrinsicHeight());
      ((Button)localObject2).setCompoundDrawables(paramIntent, null, null, null);
      ((Button)localObject2).setCompoundDrawablePadding(0);
      ((Button)localObject2).setTextColor(j);
      localView.findViewById(2131373969).setBackgroundColor(Color.parseColor("#262626"));
      paramIntent = getResources().getDrawable(2130842288);
      paramIntent.setBounds(0, 0, paramIntent.getIntrinsicWidth(), paramIntent.getIntrinsicHeight());
      ((Button)localObject1).setCompoundDrawables(paramIntent, null, null, null);
      ((Button)localObject1).setCompoundDrawablePadding(0);
      ((Button)localObject1).setTextColor(j);
      this.jdField_a_of_type_ComTencentAvUtilsAvCustomDialog.show();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, String.format("begin show dialog, mPeerUin[%s], mExtraUin[%s], mIsDoubleVideoMeeting[%s], mUinType[%s], mRelationType[%s], mMemberType[%s], mHasGVideoJoined[%s], mIsAudioMode[%s], mBindType[%s]", new Object[] { this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, Boolean.valueOf(this.jdField_a_of_type_Boolean), Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_d_of_type_Int), Boolean.valueOf(this.jdField_c_of_type_Boolean), Boolean.valueOf(this.jdField_b_of_type_Boolean), Integer.valueOf(this.jdField_c_of_type_Int) }));
      }
      TraeHelper.a().a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230736, null, 0, null);
      return;
      localObject1 = (ViewStub)localView.findViewById(2131373806);
      break;
      if (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.j()) {
        break label171;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131690562);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166037));
      break label171;
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      a(this.jdField_b_of_type_AndroidWidgetTextView);
      break label211;
      localObject1 = "#878B99";
      break label285;
      ((Button)localObject1).setText(2131695652);
      ((Button)localObject2).setText(2131695659);
      break label488;
    }
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
    StringBuilder localStringBuilder = new StringBuilder().append("acceptRequest, from[").append(paramString).append("], HandleSessionInfo[").append(paramSessionInfo).append("], CurMainSession[").append(localSessionInfo).append("], mSessionInfo[").append(this.jdField_a_of_type_ComTencentAvAppSessionInfo).append("], SameSession[");
    boolean bool;
    if (paramSessionInfo == localSessionInfo)
    {
      bool = true;
      QLog.w(str, 1, bool + "], mAnyChatCloseByFriend[" + this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean + "], getAliveSessionCount[" + SessionMgr.a().a() + "], seq[" + paramLong + "]");
      this.jdField_d_of_type_Boolean = true;
      if (!this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean) {
        break label250;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.e(true);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo != null) && (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.j()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "Session already destroyed, id:" + this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString + ", status = " + this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_g_of_type_Int);
        }
        return;
        bool = false;
        break;
        label250:
        if ((paramSessionInfo != null) && (localSessionInfo == paramSessionInfo) && (SessionMgr.a().a() >= 2))
        {
          this.jdField_a_of_type_ComTencentAvVideoController.i(true);
          if (paramSessionInfo.j()) {
            a(paramLong, paramString, false, paramSessionInfo, -1);
          }
          for (;;)
          {
            a(paramSessionInfo);
            break;
            this.jdField_a_of_type_ComTencentAvVideoController.a(true, 205, new int[] { localSessionInfo.D });
            this.jdField_a_of_type_ComTencentAvVideoController.b(205);
          }
        }
      }
    }
    if (b())
    {
      d();
      return;
    }
    b(paramIntent);
  }
  
  void a(long paramLong, String paramString, boolean paramBoolean, SessionInfo paramSessionInfo, int paramInt)
  {
    boolean bool3 = true;
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "ignoreRequest[" + paramString + "], refuse3rd[" + paramBoolean + "], mainSessionInfo[" + paramSessionInfo + "], iFlag[" + paramInt + "], seq[" + paramLong + "]");
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
        String str = paramSessionInfo.jdField_d_of_type_JavaLangString;
        paramString = str;
        if (TextUtils.isEmpty(str)) {
          paramString = paramSessionInfo.s;
        }
        bool1 = paramSessionInfo.J;
        i = paramSessionInfo.F;
        l = paramSessionInfo.jdField_g_of_type_Long;
      }
    }
    for (;;)
    {
      int j = UITools.c(i);
      if (!paramBoolean)
      {
        bool2 = bool3;
        if (!bool1) {
          if (!a(j)) {
            break label234;
          }
        }
      }
      label234:
      for (boolean bool2 = bool3; a(j); bool2 = false)
      {
        a(paramLong, i, l, bool2, paramInt, paramBoolean);
        return;
      }
      a(paramLong, bool1, paramString, bool2, paramBoolean);
      return;
    }
  }
  
  void a(long paramLong, boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "refuseDoubleCall mVideoController is null");
      return;
    }
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "refuseDoubleCall, isDoubleVideoMeeting[" + paramBoolean1 + "], peerUin[" + paramString + "], notifyDestroyUI[" + paramBoolean2 + "], refuse3rd[" + paramBoolean3 + "], seq[" + paramLong + "]");
    long l2;
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, paramString, 1, true);
      l2 = -1L;
    }
    for (;;)
    {
      try
      {
        l1 = CharacterUtil.a(paramString);
        if (!paramBoolean3)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 3, l1, 10, false);
          this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, l1, 23);
          if ((!paramBoolean2) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)) {
            break;
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), paramString, Boolean.valueOf(true) });
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        long l1 = l2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "", localNumberFormatException);
        l1 = l2;
        continue;
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 3, l1);
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, l1, 1);
        continue;
      }
      VideoController localVideoController = this.jdField_a_of_type_ComTencentAvVideoController;
      localVideoController.a(paramLong, paramString, 1, false, new MultiIncomingCallsActivity.11(this, localVideoController, paramString, paramBoolean3));
    }
  }
  
  public void a(Intent paramIntent)
  {
    long l = AudioHelper.b();
    this.jdField_b_of_type_Int = 3;
    super.a(paramIntent);
    if (paramIntent == null) {}
    label358:
    do
    {
      return;
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
      int i;
      if (b())
      {
        this.jdField_e_of_type_Int = paramIntent.getIntExtra("MultiAVType", -1);
        if (this.jdField_e_of_type_Int == 2)
        {
          this.jdField_b_of_type_Boolean = false;
          this.jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("inviteId");
          str = SessionMgr.a(this.jdField_b_of_type_Int, String.valueOf(this.jdField_a_of_type_Long), new int[0]);
          this.jdField_b_of_type_ArrayOfLong = paramIntent.getLongArrayExtra("memberList");
          i = AVUtil.c(this.jdField_b_of_type_Int);
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, String.valueOf(this.jdField_b_of_type_Long), String.valueOf(this.jdField_a_of_type_Long));
        }
      }
      for (this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, String.valueOf(this.jdField_b_of_type_Long), this.jdField_d_of_type_JavaLangString, true, true);; this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, true, true))
      {
        this.jdField_a_of_type_ComTencentAvAppSessionInfo = SessionMgr.a().c(str);
        if (this.jdField_a_of_type_ComTencentAvAppSessionInfo != null) {
          break label358;
        }
        b("processIntent_fail");
        return;
        this.jdField_b_of_type_Boolean = true;
        break;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString);
      }
    } while (a(paramIntent));
    a(l, paramIntent);
  }
  
  void a(TextView paramTextView)
  {
    if (paramTextView == null) {
      return;
    }
    float f1 = super.getResources().getDimensionPixelSize(2131297882);
    String str2;
    int i;
    if (b())
    {
      str2 = String.valueOf(this.jdField_a_of_type_Long);
      str1 = super.getApplicationContext().getString(2131695499);
      int j = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_b_of_type_Int, str2);
      i = j;
      if (j == 0)
      {
        if (this.jdField_b_of_type_ArrayOfLong != null) {
          i = this.jdField_b_of_type_ArrayOfLong.length + 1;
        }
      }
      else
      {
        if (i <= 999) {
          break label183;
        }
        f1 = super.getResources().getDimensionPixelSize(2131297884);
        label102:
        str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Int, str2, null);
        str2 = UITools.a(super.getApplicationContext(), str2, paramTextView, f1);
        str1 = String.format(str1, new Object[] { Integer.valueOf(i) });
      }
    }
    for (String str1 = str2 + str1;; str1 = this.jdField_a_of_type_JavaLangString)
    {
      paramTextView.setText(str1);
      return;
      i = 1;
      break;
      label183:
      if (i <= 99) {
        break label102;
      }
      f1 = super.getResources().getDimensionPixelSize(2131297883);
      break label102;
    }
  }
  
  void a(SessionInfo paramSessionInfo)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (paramSessionInfo != null))
    {
      Intent localIntent = new Intent();
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      localIntent.setAction("tencent.av.v2q.StopVideoChat");
      localIntent.putExtra("stopReason3rd", 1);
      localIntent.putExtra("groupId", paramSessionInfo.jdField_g_of_type_Long);
      localIntent.putExtra("peerUin", paramSessionInfo.jdField_d_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
    }
  }
  
  public boolean a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    long l = AudioHelper.b();
    String str1 = paramIntent.getAction();
    String str2;
    Object localObject;
    if ("com.tencent.qav.notify.accept".equals(str1))
    {
      str2 = paramIntent.getStringExtra("session_id");
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo == null)
      {
        localObject = null;
        if (!TextUtils.equals(str2, (CharSequence)localObject)) {
          break label137;
        }
        a(l, paramIntent, SessionMgr.a().a());
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_b_of_type_JavaLangString, 2, "checkParamAndDoAction action[" + str1 + "], seq[" + l + "]");
      }
      return bool;
      localObject = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString;
      break;
      label137:
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_b_of_type_JavaLangString, 2, "checkParamAndDoAction coming[" + str2 + "], cur[" + (String)localObject + "]");
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null) {
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString);
    }
    b(2);
    a(AudioHelper.b(), "onInviteTimeOut", true, SessionMgr.a().a(), 8);
    b("onInviteTimeOut");
  }
  
  void b(int paramInt)
  {
    label258:
    label1410:
    for (;;)
    {
      SessionInfo localSessionInfo;
      int i;
      int j;
      Object localObject5;
      Object localObject6;
      Object localObject7;
      Object localObject8;
      Object localObject9;
      Object localObject10;
      Object localObject11;
      Object localObject12;
      Object localObject4;
      try
      {
        localSessionInfo = SessionMgr.a().a();
        if ((localSessionInfo == null) || (SessionMgr.a().a() < 2)) {
          return;
        }
        i = localSessionInfo.jdField_g_of_type_Int;
        j = localSessionInfo.jdField_c_of_type_Int;
        Object localObject1 = null;
        localObject5 = null;
        localObject6 = null;
        localObject7 = null;
        localObject8 = null;
        localObject9 = null;
        localObject10 = null;
        localObject11 = null;
        localObject12 = null;
        localObject4 = null;
        if ((localSessionInfo.j != 21) && ((localSessionInfo.j != 1011) || (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info == null) || (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int <= 0) || (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int != 1))) {
          break label258;
        }
        if (paramInt == 0)
        {
          localObject4 = "0X8005BB9";
          localObject1 = localObject4;
          if (!QLog.isColorLevel()) {
            break label1410;
          }
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "double random chat, action:" + paramInt + ", reportType:" + (String)localObject4);
          localObject1 = localObject4;
          if (localObject1 == null) {
            break;
          }
          ReportController.b(null, "CliOper", "", "", localObject1, localObject1, 0, 0, "", "", "", "");
          return;
        }
      }
      finally {}
      if (paramInt == 1)
      {
        localObject4 = "0X8005BBA";
      }
      else if (paramInt == 2)
      {
        localObject4 = "0X8005BBB";
        continue;
        if ((localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo != null) && (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Int != 0) && (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Long > 0L))
        {
          if (paramInt == 0) {
            localObject4 = "0X8005BBF";
          }
          for (;;)
          {
            localObject3 = localObject4;
            if (!QLog.isColorLevel()) {
              break label1410;
            }
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "multi gonghui, action:" + paramInt + ", reportType:" + (String)localObject4);
            localObject3 = localObject4;
            break;
            if (paramInt == 1)
            {
              localObject4 = "0X8005BC0";
            }
            else
            {
              localObject4 = localObject3;
              if (paramInt == 2) {
                localObject4 = "0X8005BC1";
              }
            }
          }
        }
        if ((localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info != null) && (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int > 0) && (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int == 3))
        {
          if (paramInt == 0) {
            localObject4 = "0X8005BBC";
          }
          for (;;)
          {
            localObject3 = localObject4;
            if (!QLog.isColorLevel()) {
              break label1410;
            }
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "multi random chat, action:" + paramInt + ", reportType:" + (String)localObject4);
            localObject3 = localObject4;
            break;
            if (paramInt == 1)
            {
              localObject4 = "0X8005BBD";
            }
            else
            {
              localObject4 = localObject5;
              if (paramInt == 2) {
                localObject4 = "0X8005BBE";
              }
            }
          }
        }
        if (localSessionInfo.J)
        {
          if (paramInt == 0) {
            localObject4 = "0X8005BAA";
          }
          for (;;)
          {
            localObject3 = localObject4;
            if (!QLog.isColorLevel()) {
              break label1410;
            }
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "double share, action:" + paramInt + ", reportType:" + (String)localObject4);
            localObject3 = localObject4;
            break;
            if (paramInt == 1)
            {
              localObject4 = "0X8005BAB";
            }
            else
            {
              localObject4 = localObject6;
              if (paramInt == 2) {
                localObject4 = "0X8005BAC";
              }
            }
          }
        }
        if ((localSessionInfo.F == 1) && (localSessionInfo.jdField_d_of_type_Int == 3))
        {
          if (paramInt == 0) {
            localObject4 = "0X8005BB3";
          }
          for (;;)
          {
            localObject3 = localObject4;
            if (!QLog.isColorLevel()) {
              break label1410;
            }
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "group audio, action:" + paramInt + ", reportType:" + (String)localObject4);
            localObject3 = localObject4;
            break;
            if (paramInt == 1)
            {
              localObject4 = "0X8005BB4";
            }
            else
            {
              localObject4 = localObject7;
              if (paramInt == 2) {
                localObject4 = "0X8005BB5";
              }
            }
          }
        }
        if ((localSessionInfo.F == 1) && (localSessionInfo.jdField_d_of_type_Int == 4))
        {
          if (paramInt == 0) {
            localObject4 = "0X8005BB6";
          }
          for (;;)
          {
            localObject3 = localObject4;
            if (!QLog.isColorLevel()) {
              break label1410;
            }
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "group video, action:" + paramInt + ", reportType:" + (String)localObject4);
            localObject3 = localObject4;
            break;
            if (paramInt == 1)
            {
              localObject4 = "0X8005BB7";
            }
            else
            {
              localObject4 = localObject8;
              if (paramInt == 2) {
                localObject4 = "0X8005BB8";
              }
            }
          }
        }
        if ((localSessionInfo.F == 2) && (localSessionInfo.jdField_d_of_type_Int == 3))
        {
          if (paramInt == 0) {
            localObject4 = "0X8005BAD";
          }
          for (;;)
          {
            localObject3 = localObject4;
            if (!QLog.isColorLevel()) {
              break label1410;
            }
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "discuss audio, action:" + paramInt + ", reportType:" + (String)localObject4);
            localObject3 = localObject4;
            break;
            if (paramInt == 1)
            {
              localObject4 = "0X8005BAE";
            }
            else
            {
              localObject4 = localObject9;
              if (paramInt == 2) {
                localObject4 = "0X8005BAF";
              }
            }
          }
        }
        if ((localSessionInfo.F == 2) && (localSessionInfo.jdField_d_of_type_Int == 4))
        {
          if (paramInt == 0) {
            localObject4 = "0X8005BB0";
          }
          for (;;)
          {
            localObject3 = localObject4;
            if (!QLog.isColorLevel()) {
              break label1410;
            }
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "discuss video, action:" + paramInt + ", reportType:" + (String)localObject4);
            localObject3 = localObject4;
            break;
            if (paramInt == 1)
            {
              localObject4 = "0X8005BB1";
            }
            else
            {
              localObject4 = localObject10;
              if (paramInt == 2) {
                localObject4 = "0X8005BB2";
              }
            }
          }
        }
        if ((localSessionInfo.jdField_d_of_type_Int == 2) || ((localSessionInfo.f == 2) && ((i == 1) || (i == 2))))
        {
          if (paramInt == 0) {
            localObject4 = "0X8005BA7";
          }
          for (;;)
          {
            localObject3 = localObject4;
            if (!QLog.isColorLevel()) {
              break label1410;
            }
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "double video, action:" + paramInt + ", reportType:" + (String)localObject4);
            localObject3 = localObject4;
            break;
            if (paramInt == 1)
            {
              localObject4 = "0X8005BA8";
            }
            else
            {
              localObject4 = localObject11;
              if (paramInt == 2) {
                localObject4 = "0X8005BA9";
              }
            }
          }
        }
        if ((localSessionInfo.jdField_d_of_type_Int == 1) || ((localSessionInfo.f == 1) && ((i == 1) || (i == 2))))
        {
          if (paramInt == 0) {
            localObject4 = "0X8005BA4";
          }
          for (;;)
          {
            localObject3 = localObject4;
            if (!QLog.isColorLevel()) {
              break label1410;
            }
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "double audio, action:" + paramInt + ", reportType:" + (String)localObject4);
            localObject3 = localObject4;
            break;
            if (paramInt == 1)
            {
              localObject4 = "0X8005BA5";
            }
            else
            {
              localObject4 = localObject12;
              if (paramInt == 2) {
                localObject4 = "0X8005BA6";
              }
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "nothing, action:" + paramInt + ", reportType:" + null + "SessionType:" + localSessionInfo.jdField_d_of_type_Int + ", BeginSessionType:" + localSessionInfo.f + ", sessionStatus:" + j + ", state:" + i);
        }
        Object localObject3 = null;
      }
    }
  }
  
  void b(Intent paramIntent)
  {
    Object localObject2 = null;
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "startVideoChatActivity");
    TraeHelper.a().a();
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.m)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(113) });
    }
    Intent localIntent = new Intent(super.getApplicationContext(), AVActivity.class);
    localIntent.addFlags(262144);
    Object localObject1;
    int i;
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentAvAppSessionInfo.p;
      i = this.jdField_a_of_type_ComTencentAvAppSessionInfo.A;
      localObject2 = this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_ArrayOfByte;
    }
    for (;;)
    {
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
        super.startActivity(localIntent);
        super.overridePendingTransition(2130772193, 2130772192);
        return;
      }
      localIntent.putExtra("uinType", j);
      localIntent.putExtra("bindType", i);
      localIntent.putExtra("bindId", (String)localObject1);
      localIntent.putExtra("uin", this.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("name", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("extraUin", this.jdField_d_of_type_JavaLangString);
      localIntent.putExtra("receive", true);
      localIntent.putExtra("isAudioMode", bool);
      localIntent.putExtra("sig", (byte[])localObject2);
      if (QLog.isColorLevel())
      {
        localObject2 = this.jdField_b_of_type_JavaLangString;
        localObject1 = new StringBuilder().append("startVideoChatActivity: bindType = ").append(i).append(",bindId = ").append((String)localObject1).append(",BindType = ");
        if (this.jdField_a_of_type_ComTencentAvAppSessionInfo == null)
        {
          paramIntent = "session info null";
          label433:
          QLog.d((String)localObject2, 2, paramIntent);
        }
      }
      else
      {
        if (j == 0) {
          localIntent.putExtra("isFriend", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_c_of_type_JavaLangString));
        }
        if (!bool) {
          break label514;
        }
        localIntent.putExtra("sessionType", 1);
      }
      for (;;)
      {
        localIntent.putExtra("isSender", false);
        break;
        paramIntent = Integer.valueOf(this.jdField_a_of_type_ComTencentAvAppSessionInfo.A);
        break label433;
        label514:
        localIntent.putExtra("sessionType", 2);
      }
      i = -1;
      localObject1 = null;
    }
  }
  
  void b(String paramString)
  {
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "destroyUI[" + paramString + "]");
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
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695637);
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (this.jdField_b_of_type_Boolean) {}
    for (int i = 2131695650;; i = 2131695651)
    {
      ((TextView)localObject).setText(i);
      return;
    }
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
    localIntent.putExtra("MultiAVType", this.jdField_a_of_type_ComTencentAvAppSessionInfo.D);
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
    if (this.jdField_a_of_type_ComTencentAvUtilsAvCustomDialog != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvUtilsAvCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentAvUtilsAvCustomDialog = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  void f()
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification == null) {
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    if (b())
    {
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo != null)
      {
        localObject = String.valueOf(this.jdField_a_of_type_Long);
        Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Int, (String)localObject, null, true, true);
        String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(AVUtil.c(this.jdField_b_of_type_Int), Long.toString(this.jdField_b_of_type_Long), (String)localObject);
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString, str, localBitmap, (String)localObject, 57, this.jdField_a_of_type_Int, 3);
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, true, true);
    if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, (Bitmap)localObject, null, 56, this.jdField_a_of_type_Int, 2);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, (Bitmap)localObject, null, 55, this.jdField_a_of_type_Int, 1);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    long l = AudioHelper.b();
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "onCreate, seq[" + l + "]");
    super.onCreate(paramBundle);
    super.getWindow().setBackgroundDrawableResource(2130851165);
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
      this.g = true;
      if (b())
      {
        i = 30000;
        a(i);
        return;
      }
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
        continue;
        int i = 60000;
      }
    }
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
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      if (this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList != null) {
        this.jdField_a_of_type_ComTencentAvUiMutiMemberThumbList.a();
      }
      if (this.jdField_a_of_type_MqqOsMqqHandler != null)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        this.jdField_a_of_type_MqqOsMqqHandler = null;
      }
      if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null)
      {
        SessionInfo localSessionInfo = SessionMgr.a().a();
        if (this.jdField_a_of_type_ComTencentAvAppSessionInfo != localSessionInfo) {
          this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString);
        }
        if (localSessionInfo != null) {
          this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.b(localSessionInfo.jdField_c_of_type_JavaLangString);
        }
        if ((localSessionInfo != null) && (localSessionInfo.jdField_c_of_type_JavaLangString != null) && (!localSessionInfo.jdField_c_of_type_JavaLangString.equals(this.jdField_f_of_type_JavaLangString))) {
          this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_f_of_type_JavaLangString);
        }
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_b_of_type_JavaLangString, 2, "onDestroy main[" + localSessionInfo + "], cur[" + this.jdField_a_of_type_ComTencentAvAppSessionInfo + "], id[" + this.jdField_f_of_type_JavaLangString + "]");
        }
      }
      if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (!this.jdField_f_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(707) });
      }
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        if (this.g)
        {
          unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
          this.g = false;
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
        return;
        localThrowable1 = localThrowable1;
        localThrowable1.printStackTrace();
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          localThrowable2.printStackTrace();
        }
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((!this.jdField_d_of_type_Boolean) && (paramInt == 4))
    {
      b(2);
      a(AudioHelper.b(), "onKeyDown", true, null, -1);
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
  
  public void onPause()
  {
    super.onPause();
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onPause");
    ColorNoteSmallScreenUtil.a(this, 2, true);
    a(false);
  }
  
  public void onResume()
  {
    super.onResume();
    jdField_e_of_type_Boolean = true;
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onResume");
    ColorNoteSmallScreenUtil.a(this, 2, false);
    a(true);
    b(0);
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvVideoController.a(MultiIncomingCallsActivity.class);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onStart");
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo == null) {}
    SessionInfo localSessionInfo;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification == null) {
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      }
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString);
      localSessionInfo = SessionMgr.a().a();
    } while ((localSessionInfo == null) || (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString.equals(localSessionInfo.jdField_c_of_type_JavaLangString)));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(false, null);
    this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(localSessionInfo.jdField_c_of_type_JavaLangString);
    this.jdField_f_of_type_JavaLangString = localSessionInfo.jdField_c_of_type_JavaLangString;
  }
  
  public void onStop()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallsActivity
 * JD-Core Version:    0.7.0.1
 */