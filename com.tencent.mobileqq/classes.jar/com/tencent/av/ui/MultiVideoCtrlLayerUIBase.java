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
import com.tencent.av.VideoConstants;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.InviteMemberObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.tips.AvTipsView;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.ui.chatroom.VideoChatRoomUIContoller;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.GAudioSoundUtil;
import com.tencent.av.utils.MultiVideoMembersClickListener;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.SensorHelper;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.api.ITraeMediaPlayerApi;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.av.ui.MultiVideoCtrlLayerUIBase.SpeakingInfo;>;
import java.util.Iterator;
import mqq.app.BaseActivity;
import mqq.app.MobileQQ;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mqq.os.MqqHandler;

public abstract class MultiVideoCtrlLayerUIBase
  extends VideoControlUI
{
  private static boolean jdField_a_of_type_Boolean = false;
  static int jdField_b_of_type_Int = 16;
  long jdField_a_of_type_Long = 0L;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new MultiVideoCtrlLayerUIBase.2(this);
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private InviteMemberObserver jdField_a_of_type_ComTencentAvAppInviteMemberObserver = new MultiVideoCtrlLayerUIBase.1(this);
  MultiMembersAudioUI jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI = null;
  MultiMembersVideoUI jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI = null;
  MultiVideoCtrlLayerUIBase.InviteUserNoticeRunnable jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$InviteUserNoticeRunnable = new MultiVideoCtrlLayerUIBase.InviteUserNoticeRunnable(this);
  MultiVideoCtrlLayerUIBase.StartRecvVideoRunnable jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable = new MultiVideoCtrlLayerUIBase.StartRecvVideoRunnable(this);
  QavInOutAnimation jdField_a_of_type_ComTencentAvUiQavInOutAnimation = null;
  MultiVideoMembersClickListener jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener = new MultiVideoCtrlLayerUIBase.6(this);
  QAVNotification jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
  ITraeMediaPlayerApi jdField_a_of_type_ComTencentSharpJniApiITraeMediaPlayerApi = null;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  String jdField_a_of_type_JavaLangString = null;
  ArrayList<MultiVideoCtrlLayerUIBase.SpeakingInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public long b;
  ImageView jdField_b_of_type_AndroidWidgetImageView = null;
  TextView jdField_b_of_type_AndroidWidgetTextView = null;
  GAudioUIObserver jdField_b_of_type_ComTencentAvAppGAudioUIObserver = new MultiVideoCtrlLayerUIBase.11(this);
  Runnable jdField_b_of_type_JavaLangRunnable = null;
  String jdField_b_of_type_JavaLangString;
  ArrayList<MultiVideoCtrlLayerUIBase.SpeakingInfo> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  public boolean b;
  public int c;
  long jdField_c_of_type_Long = 0L;
  TextView jdField_c_of_type_AndroidWidgetTextView = null;
  Runnable jdField_c_of_type_JavaLangRunnable = null;
  String jdField_c_of_type_JavaLangString = "";
  boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int = -1;
  TextView jdField_d_of_type_AndroidWidgetTextView = null;
  Runnable jdField_d_of_type_JavaLangRunnable = null;
  boolean jdField_d_of_type_Boolean = true;
  public int e;
  Runnable jdField_e_of_type_JavaLangRunnable = null;
  boolean jdField_e_of_type_Boolean = false;
  int jdField_f_of_type_Int = 0;
  Runnable jdField_f_of_type_JavaLangRunnable = null;
  boolean jdField_f_of_type_Boolean = false;
  int jdField_g_of_type_Int = 0;
  Runnable jdField_g_of_type_JavaLangRunnable = new MultiVideoCtrlLayerUIBase.3(this);
  int h;
  int i = -1;
  int j;
  int k;
  int l = 1;
  private boolean q = false;
  private boolean r = false;
  
  static
  {
    int m;
    if (Build.VERSION.SDK_INT >= 21) {
      m = 16;
    } else {
      m = 9;
    }
    jdField_b_of_type_Int = m;
    boolean bool;
    if ((!Build.MODEL.equalsIgnoreCase("SM-G7106")) && (!Build.MODEL.equalsIgnoreCase("MI 2")) && (!Build.MODEL.equalsIgnoreCase("GT-B9388")) && (!Build.MODEL.equalsIgnoreCase("L39u")) && (!Build.MODEL.equalsIgnoreCase("R7007")) && (!Build.MODEL.equalsIgnoreCase("VIVO X5S L"))) {
      bool = false;
    } else {
      bool = true;
    }
    jdField_a_of_type_Boolean = bool;
  }
  
  public MultiVideoCtrlLayerUIBase(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, ControlUIObserver paramControlUIObserver)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, paramControlUIObserver);
    this.jdField_c_of_type_Int = -1;
    this.jdField_e_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_h_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_j_of_type_Int = -1;
    this.jdField_k_of_type_Int = 0;
  }
  
  private String a(ArrayList<MultiVideoCtrlLayerUIBase.SpeakingInfo> paramArrayList)
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i3 = AVUtil.b(localSessionInfo.jdField_k_of_type_Int);
    Object localObject1;
    if (paramArrayList.size() > 0)
    {
      localObject1 = ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131695886);
      Object localObject2 = new int[3];
      Object tmp50_48 = localObject2;
      tmp50_48[0] = -1;
      Object tmp54_50 = tmp50_48;
      tmp54_50[1] = -1;
      Object tmp58_54 = tmp54_50;
      tmp58_54[2] = -1;
      tmp58_54;
      int m = 0;
      while (m < paramArrayList.size())
      {
        if (QLog.isColorLevel())
        {
          String str = this.jdField_d_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("speakingInfoList. idx = ");
          localStringBuilder.append(m);
          localStringBuilder.append(", uin = ");
          localStringBuilder.append(((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(m)).jdField_a_of_type_JavaLangString);
          localStringBuilder.append(", audioEnergy = ");
          localStringBuilder.append(((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(m)).jdField_a_of_type_Int);
          QLog.d(str, 2, localStringBuilder.toString());
        }
        if ((localObject2[0] != -1) && (((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(localObject2[0])).jdField_a_of_type_Int >= ((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(m)).jdField_a_of_type_Int))
        {
          if ((localObject2[1] != -1) && (((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(localObject2[1])).jdField_a_of_type_Int >= ((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(m)).jdField_a_of_type_Int))
          {
            if ((localObject2[2] == -1) || (((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(localObject2[2])).jdField_a_of_type_Int < ((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(m)).jdField_a_of_type_Int)) {
              localObject2[2] = m;
            }
          }
          else
          {
            localObject2[2] = localObject2[1];
            localObject2[1] = m;
          }
        }
        else
        {
          localObject2[2] = localObject2[1];
          localObject2[1] = localObject2[0];
          localObject2[0] = m;
        }
        m += 1;
      }
      m = 0;
      while (m < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        n = 0;
        while ((n < localObject2.length) && (localObject2[n] >= 0))
        {
          if (((MultiVideoCtrlLayerUIBase.SpeakingInfo)this.jdField_b_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_JavaLangString.equalsIgnoreCase(((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(localObject2[n])).jdField_a_of_type_JavaLangString))
          {
            i1 = 1;
            break label421;
          }
          n += 1;
        }
        i1 = 0;
        label421:
        if (i1 != 0)
        {
          ((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(localObject2[n])).jdField_a_of_type_JavaLangString = "";
          ((MultiVideoCtrlLayerUIBase.SpeakingInfo)this.jdField_b_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_Int = ((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(localObject2[n])).jdField_a_of_type_Int;
        }
        else
        {
          ((MultiVideoCtrlLayerUIBase.SpeakingInfo)this.jdField_b_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_JavaLangString = "";
        }
        m += 1;
      }
      int n = 0;
      for (m = 0; n < this.jdField_b_of_type_JavaUtilArrayList.size(); m = i1)
      {
        int i2 = n;
        i1 = m;
        if (((MultiVideoCtrlLayerUIBase.SpeakingInfo)this.jdField_b_of_type_JavaUtilArrayList.get(n)).jdField_a_of_type_JavaLangString.equalsIgnoreCase(""))
        {
          i1 = m;
          for (;;)
          {
            m = i1;
            if (i1 >= localObject2.length) {
              break;
            }
            if (localObject2[i1] < 0)
            {
              m = i1;
              break;
            }
            if (!((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(localObject2[i1])).jdField_a_of_type_JavaLangString.equalsIgnoreCase(""))
            {
              ((MultiVideoCtrlLayerUIBase.SpeakingInfo)this.jdField_b_of_type_JavaUtilArrayList.get(n)).jdField_a_of_type_JavaLangString = ((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(localObject2[i1])).jdField_a_of_type_JavaLangString;
              ((MultiVideoCtrlLayerUIBase.SpeakingInfo)this.jdField_b_of_type_JavaUtilArrayList.get(n)).jdField_a_of_type_Int = ((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(localObject2[i1])).jdField_a_of_type_Int;
              ((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(localObject2[i1])).jdField_a_of_type_JavaLangString = "";
              m = i1 + 1;
              break;
            }
            i1 += 1;
          }
          i2 = n;
          i1 = m;
          if (m < localObject2.length)
          {
            i2 = n;
            i1 = m;
            if (localObject2[m] < 0)
            {
              this.jdField_b_of_type_JavaUtilArrayList.remove(n);
              i2 = n - 1;
              i1 = m;
            }
          }
        }
        n = i2 + 1;
      }
      int i1 = this.jdField_b_of_type_JavaUtilArrayList.size();
      while (i1 < 3)
      {
        n = m;
        for (;;)
        {
          m = n;
          if (n >= localObject2.length) {
            break;
          }
          if (localObject2[n] < 0)
          {
            m = n;
            break;
          }
          if (!((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(localObject2[n])).jdField_a_of_type_JavaLangString.equalsIgnoreCase(""))
          {
            this.jdField_b_of_type_JavaUtilArrayList.add(new MultiVideoCtrlLayerUIBase.SpeakingInfo(((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(localObject2[n])).jdField_a_of_type_JavaLangString, ((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(localObject2[n])).jdField_a_of_type_Int));
            ((MultiVideoCtrlLayerUIBase.SpeakingInfo)paramArrayList.get(localObject2[n])).jdField_a_of_type_JavaLangString = "";
            m = n + 1;
            break;
          }
          n += 1;
        }
        i1 += 1;
      }
      m = 0;
      paramArrayList = (ArrayList<MultiVideoCtrlLayerUIBase.SpeakingInfo>)localObject1;
      while (m < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        if (QLog.isColorLevel())
        {
          localObject1 = this.jdField_d_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("speakingInfoList. uin = ");
          ((StringBuilder)localObject2).append(((MultiVideoCtrlLayerUIBase.SpeakingInfo)this.jdField_b_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject2).append(", audioEnergy = ");
          ((StringBuilder)localObject2).append(((MultiVideoCtrlLayerUIBase.SpeakingInfo)this.jdField_b_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_Int);
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
        localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i3, ((MultiVideoCtrlLayerUIBase.SpeakingInfo)this.jdField_b_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_JavaLangString, String.valueOf(localSessionInfo.jdField_f_of_type_Long));
        localObject1 = localObject2;
        if (CharacterUtil.a((String)localObject2) > 9)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(CharacterUtil.a((String)localObject2, 0, 9));
          ((StringBuilder)localObject1).append("...");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        if (m < this.jdField_b_of_type_JavaUtilArrayList.size() - 1)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramArrayList);
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131695885));
          paramArrayList = ((StringBuilder)localObject2).toString();
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramArrayList);
          ((StringBuilder)localObject2).append((String)localObject1);
          paramArrayList = ((StringBuilder)localObject2).toString();
        }
        m += 1;
      }
    }
    else
    {
      paramArrayList = ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131695886);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.c().size() != 0)
    {
      localObject1 = paramArrayList;
      if (this.jdField_a_of_type_ComTencentAvVideoController.c().size() == 1)
      {
        localObject1 = paramArrayList;
        if (((VideoController.GAudioFriends)this.jdField_a_of_type_ComTencentAvVideoController.c().get(0)).jdField_a_of_type_Long != Long.parseLong(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) {}
      }
    }
    else
    {
      localObject1 = "";
    }
    return localObject1;
  }
  
  private void a(View paramView1, View paramView2)
  {
    paramView1.setOnTouchListener(new MultiVideoCtrlLayerUIBase.5(this, paramView2));
  }
  
  private void b(long paramLong, boolean paramBoolean, int paramInt)
  {
    if ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
        return;
      }
      boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean;
      int i1 = 0;
      int i2 = 1;
      if ((!bool) && (this.jdField_a_of_type_ComTencentAvVideoController.a().c.size() <= 0)) {
        bool = false;
      } else {
        bool = true;
      }
      if (bool) {
        m = 2131373653;
      } else {
        m = 2131373325;
      }
      Object localObject1 = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(m);
      Object localObject2 = Long.toString(paramLong);
      int m = 0;
      while (m < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (((MultiVideoCtrlLayerUIBase.SpeakingInfo)this.jdField_a_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_JavaLangString.equalsIgnoreCase((String)localObject2))
        {
          if (paramBoolean)
          {
            ((MultiVideoCtrlLayerUIBase.SpeakingInfo)this.jdField_a_of_type_JavaUtilArrayList.get(m)).jdField_a_of_type_Int = paramInt;
            n = i2;
            if (paramInt >= 10) {
              break label226;
            }
            this.jdField_a_of_type_JavaUtilArrayList.remove(m);
            n = i2;
            break label226;
          }
          this.jdField_a_of_type_JavaUtilArrayList.remove(m);
          n = i2;
          break label226;
        }
        m += 1;
      }
      int n = 0;
      label226:
      if ((paramBoolean) && (n == 0) && (paramInt > 10)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(new MultiVideoCtrlLayerUIBase.SpeakingInfo((String)localObject2, paramInt));
      }
      ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, paramBoolean);
      if ((!bool) && (this.jdField_a_of_type_ComTencentAvVideoController.c().size() <= 8))
      {
        this.jdField_c_of_type_JavaLangString = "";
      }
      else
      {
        localObject2 = new ArrayList();
        paramInt = i1;
        while (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          ((ArrayList)localObject2).add(new MultiVideoCtrlLayerUIBase.SpeakingInfo(((MultiVideoCtrlLayerUIBase.SpeakingInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString, ((MultiVideoCtrlLayerUIBase.SpeakingInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int));
          paramInt += 1;
        }
        this.jdField_c_of_type_JavaLangString = a((ArrayList)localObject2);
      }
      ((TextView)localObject1).setText(this.jdField_c_of_type_JavaLangString);
      localObject1 = this.jdField_d_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("refreshSpokesmanInfoContent. uin = ");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append(", isSpeaking = ");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append(", hasVideo = ");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append(", member cnt = ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentAvVideoController.c().size());
      ((StringBuilder)localObject2).append(", mSpokesmanNicknameListStr = ");
      ((StringBuilder)localObject2).append(this.jdField_c_of_type_JavaLangString);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.i();
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a("doRefreshGaudioMuteUIStatus", paramInt1, paramInt2, false);
    }
    if (bool)
    {
      super.l(2131373351);
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
      }
    }
    else
    {
      super.k(2131373351);
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
      }
    }
  }
  
  void A()
  {
    long l1 = AudioHelper.b();
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    String str = this.jdField_d_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("refreshMemberCtrlButton, SessionType[");
    localStringBuilder.append(localSessionInfo.jdField_d_of_type_Int);
    localStringBuilder.append("], multiAVType[");
    localStringBuilder.append(localSessionInfo.jdField_j_of_type_Int);
    localStringBuilder.append("], mUinType[");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append("], isManager[");
    localStringBuilder.append(localSessionInfo.S);
    localStringBuilder.append("], isRoomCreator[");
    localStringBuilder.append(localSessionInfo.T);
    localStringBuilder.append("], mGAudioInRoom[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvVideoController.jdField_d_of_type_Boolean);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    i(l1, 16777215);
  }
  
  void B()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("group_video_push_cfg_txt.");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    localStringBuilder.append(".level");
    int m = localSharedPreferences.getInt(localStringBuilder.toString(), 1);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("group_video_push_cfg_txt.");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    localStringBuilder.append(".sendDura");
    int n = localSharedPreferences.getInt(localStringBuilder.toString(), 5000);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("group_video_push_cfg_txt.");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    localStringBuilder.append(".validDura");
    int i1 = localSharedPreferences.getInt(localStringBuilder.toString(), 6000);
    this.jdField_a_of_type_ComTencentAvVideoController.a(m, n, i1);
  }
  
  void C()
  {
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      return;
    }
    float f1 = ImmersiveUtils.getScreenWidth() - AIOUtils.b(180.0F, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources());
    String str = a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_AndroidWidgetTextView, f1);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(str);
    this.jdField_c_of_type_AndroidWidgetTextView.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(str);
    this.jdField_d_of_type_AndroidWidgetTextView.setClickable(false);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void D()
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
  
  public void E()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_d_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("showNotification quit[");
      ((StringBuilder)localObject2).append(this.jdField_b_of_type_Boolean);
      ((StringBuilder)localObject2).append("], inRoom[");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentAvVideoController.jdField_d_of_type_Boolean);
      ((StringBuilder)localObject2).append("]");
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController.jdField_d_of_type_Boolean))
    {
      if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
        localObject2 = String.valueOf(((SessionInfo)localObject1).jdField_f_of_type_Long);
        String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_d_of_type_Int, (String)localObject2, null);
        Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_d_of_type_Int, (String)localObject2, null, true, true);
        int m;
        if (((SessionInfo)localObject1).k())
        {
          if (((SessionInfo)localObject1).jdField_d_of_type_Int == 3) {
            m = 62;
          } else {
            m = 63;
          }
        }
        else {
          m = 44;
        }
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_b_of_type_JavaLangString, str, localBitmap, (String)localObject2, m, this.jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
      }
      this.jdField_a_of_type_ComTencentAvVideoController.t();
    }
  }
  
  protected int a()
  {
    return 2131559694;
  }
  
  public int a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onApnChanged --> NetType = ");
      localStringBuilder.append(paramInt);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    DoubleVideoCtrlUI.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt);
    if ((NetworkUtil.isWifiConnected((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.jdField_d_of_type_Boolean) && (this.r)) {
      e();
    }
    return 0;
  }
  
  protected long a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_d_of_type_Boolean) {
      return this.jdField_b_of_type_Long;
    }
    return this.jdField_a_of_type_Long;
  }
  
  Intent a()
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
    return UITools.a(paramContext, paramString, paramTextView, paramFloat - paramTextView.getPaint().measureText("(100)"));
  }
  
  public String a(String paramString, int paramInt, TextView paramTextView)
  {
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "genDiscussTitle, name == null");
      }
      return "";
    }
    int m = AIOUtils.b(160.0F, this.jdField_a_of_type_AndroidContentResResources);
    TextPaint localTextPaint = paramTextView.getPaint();
    float f1 = m - localTextPaint.measureText(String.format("(%d)", new Object[] { Integer.valueOf(paramInt) })) - this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().density * 4.0F;
    String str = paramString;
    if (f1 > 0.0F)
    {
      float f2 = localTextPaint.measureText(paramString);
      str = paramString;
      if (f2 > f1)
      {
        float f3 = f1 - localTextPaint.measureText("…");
        paramTextView = paramString;
        while ((f3 > 0.0F) && (f2 > f3) && (paramTextView.length() > 0))
        {
          str = paramTextView.substring(0, paramTextView.length() - 1);
          f2 = localTextPaint.measureText(str);
          f1 = f2;
          if (f2 == 0.0F)
          {
            f1 = f2;
            if (str.length() > 0) {
              f1 = 1.0F + f3;
            }
          }
          f2 = f1;
          paramTextView = str;
          if (QLog.isDevelopLevel())
          {
            paramTextView = this.jdField_d_of_type_JavaLangString;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("genDiscussTitle, name widht[");
            localStringBuilder.append(f1);
            localStringBuilder.append("]");
            QLog.d(paramTextView, 2, localStringBuilder.toString());
            f2 = f1;
            paramTextView = str;
          }
        }
        str = paramString;
        if (f3 > 0.0F)
        {
          str = paramString;
          if (paramTextView.length() > 0)
          {
            paramString = new StringBuilder();
            paramString.append(paramTextView);
            paramString.append("…");
            str = paramString.toString();
          }
        }
      }
    }
    return str;
  }
  
  ArrayList<VideoController.GAudioFriends> a()
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
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onVideoViewModeChange --> lastMode = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" , currentMode = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(",bigUin=");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramInt1 != paramInt2)
    {
      if (this.r) {
        return;
      }
      boolean bool;
      if (paramInt2 == 3) {
        bool = true;
      } else {
        bool = false;
      }
      if (4 != this.jdField_a_of_type_ComTencentAvVideoController.g()) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      int m = 1;
      while (m < this.jdField_a_of_type_ComTencentAvVideoController.a().c.size())
      {
        paramString = (VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(m);
        paramString.jdField_a_of_type_Boolean = bool;
        if ((paramInt1 != 0) && (!paramString.jdField_c_of_type_Boolean))
        {
          int n = this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_c_of_type_Long);
          if (n != -1) {
            ((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(n)).jdField_c_of_type_Boolean = false;
          }
        }
        if ((paramInt2 == 3) && (paramInt1 != 0)) {
          paramString.jdField_c_of_type_Boolean = false;
        } else {
          paramString.jdField_c_of_type_Boolean = true;
        }
        m += 1;
      }
      if (e()) {
        this.jdField_a_of_type_ComTencentAvVideoController.a().U = true;
      }
    }
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
    if (this.jdField_c_of_type_Boolean)
    {
      p(this.jdField_b_of_type_Long);
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    c(paramInt1, paramInt2);
  }
  
  abstract void a(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2);
  
  void a(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    if (h()) {
      return;
    }
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = true;
    if (bool2)
    {
      localObject1 = this.jdField_d_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("refreshUI, uin[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("], refreshType[");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("], needRefresh[");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append("], originalType[");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append("], audioEnergy[");
      ((StringBuilder)localObject2).append(paramInt3);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    if (paramLong == 0L) {
      return;
    }
    Object localObject1 = new MultiVideoCtrlLayerUIBase.RefreshUIRunnable(this, paramLong, paramInt1, paramBoolean, paramInt2);
    Object localObject2 = a();
    ((AVActivity)localObject2).runOnUiThread((Runnable)localObject1);
    if (this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI != null)
    {
      this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(this.jdField_c_of_type_Long, 0, 0, this.jdField_a_of_type_ComTencentAvVideoController.i());
      ((AVActivity)localObject2).jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.i());
    }
    if (paramInt2 == 42) {
      paramBoolean = bool1;
    } else {
      paramBoolean = false;
    }
    b(paramLong, paramBoolean, paramInt3);
    w();
  }
  
  void a(long paramLong, String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("closeRemoteVideo[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], mVideoController[");
      boolean bool;
      if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a("Multi_closeRemoteVideo");
    this.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, "closeRemoteVideo", false, true);
    a("closeRemoteVideo", paramLong);
    e("closeRemoteVideo");
    this.jdField_b_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(104), this.jdField_a_of_type_ComTencentAvVideoController.a().c });
  }
  
  void a(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = true;
    Object localObject;
    if (bool2)
    {
      localObject = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyDataChangeByQuitUin, from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    if ((paramInt == 1) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      localObject = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      localObject = this.jdField_a_of_type_ComTencentAvVideoController;
      if (this.m == 3) {
        bool1 = false;
      }
      ((VideoController)localObject).a(paramLong2, bool1);
    }
    b(paramLong1, paramString);
  }
  
  void a(long paramLong, ArrayList<VideoController.GAudioFriends> paramArrayList)
  {
    if (h()) {
      return;
    }
    int m;
    if (paramArrayList == null) {
      m = 0;
    } else {
      m = paramArrayList.size();
    }
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doInternalUIFreash, gaFList[");
      localStringBuilder.append(m);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_AndroidContentResResources == null) {
      return;
    }
    if (m <= 1) {
      a_(paramLong, 2131695560);
    } else {
      d(paramLong, null);
    }
    this.i = m;
    Object localObject = this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI;
    if (localObject != null)
    {
      ((MultiMembersAudioUI)localObject).a(paramArrayList);
      w();
    }
    ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramArrayList);
    e(paramLong, m);
    f(paramLong, m);
  }
  
  void a(long paramLong, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI;
    if (localObject != null)
    {
      ((MultiMembersAudioUI)localObject).a(paramLong, paramBoolean);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyMemberSpeak, MemberUI is null --> Uin = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" , Speak = ");
      localStringBuilder.append(paramBoolean);
      QLog.e((String)localObject, 2, localStringBuilder.toString());
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    w();
  }
  
  protected void a(Context paramContext, String paramString, TextView paramTextView, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramInt <= 0) {
        return;
      }
      paramContext = new StringBuilder(a(paramContext, paramString, paramTextView, ImmersiveUtils.getScreenWidth() - AIOUtils.b(180.0F, paramContext.getResources())));
      if (paramInt > 1)
      {
        paramContext.append("(");
        paramContext.append(paramInt);
        paramContext.append(")");
      }
      paramTextView.setText(paramContext.toString());
    }
  }
  
  abstract void a(Intent paramIntent);
  
  public void a(String arg1, int paramInt1, String paramString2, int paramInt2)
  {
    super.a(???, paramInt1, paramString2, paramInt2);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onVideoViewChange --> BigViewUin = ");
      localStringBuilder.append(???);
      localStringBuilder.append(" , BigViewVideoViewType = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" , SmallViewUin = ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" , SmallViewVideoViewType = ");
      localStringBuilder.append(paramInt2);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (??? != null)
    {
      if (paramString2 == null) {
        return;
      }
      if (this.r) {
        return;
      }
    }
    try
    {
      long l1 = Long.valueOf(paramString2).longValue();
      if (paramInt1 == 2)
      {
        i(1036);
        TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036);
      }
      int m = this.jdField_a_of_type_ComTencentAvVideoController.a().a(Long.valueOf(???).longValue(), paramInt1);
      if (m == -1) {
        return;
      }
      paramString2 = (VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(m);
      paramInt1 = 0;
      while (paramInt1 < this.jdField_a_of_type_ComTencentAvVideoController.a().c.size())
      {
        localObject = (VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(paramInt1);
        if ((l1 == ((VideoViewInfo)localObject).jdField_a_of_type_Long) && (paramInt2 == ((VideoViewInfo)localObject).jdField_a_of_type_Int))
        {
          paramString2.jdField_a_of_type_Boolean = false;
          if ((paramString2.jdField_a_of_type_Long != this.jdField_c_of_type_Long) && (((VideoViewInfo)localObject).jdField_a_of_type_Long != this.jdField_c_of_type_Long) && (4 != this.jdField_a_of_type_ComTencentAvVideoController.g())) {
            paramString2.jdField_c_of_type_Boolean = false;
          }
          ((VideoViewInfo)localObject).jdField_a_of_type_Boolean = true;
          if ((4 != this.jdField_a_of_type_ComTencentAvVideoController.g()) && (!((VideoViewInfo)localObject).jdField_c_of_type_Boolean))
          {
            paramInt2 = this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_c_of_type_Long);
            if (paramInt2 != -1) {
              ((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(paramInt2)).jdField_c_of_type_Boolean = false;
            }
          }
          ((VideoViewInfo)localObject).jdField_c_of_type_Boolean = true;
          if ((((VideoViewInfo)localObject).jdField_a_of_type_Long == this.jdField_c_of_type_Long) && (this.jdField_e_of_type_Int == 2)) {
            ReportController.b(null, "CliOper", "", "", "0X80041B2", "0X80041B2", 0, 0, "", "", "", "");
          }
          if ((!((VideoViewInfo)localObject).jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController.g() != 4)) {
            DataReport.b(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int);
          }
          this.jdField_a_of_type_ComTencentAvVideoController.a().c.set(m, localObject);
          this.jdField_a_of_type_ComTencentAvVideoController.a().c.set(paramInt1, paramString2);
          synchronized (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList)
          {
            this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList.set(m, localObject);
            this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList.set(paramInt1, paramString2);
            this.jdField_a_of_type_ComTencentAvVideoController.a().a();
            ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(((VideoViewInfo)localObject).jdField_a_of_type_Long, ((VideoViewInfo)localObject).jdField_a_of_type_Int, paramString2.jdField_a_of_type_Long, paramString2.jdField_a_of_type_Int);
          }
        }
        paramInt1 += 1;
      }
      e();
      return;
    }
    catch (Exception ???)
    {
      label608:
      break label608;
    }
    QLog.e(this.jdField_d_of_type_JavaLangString, 2, "onVideoViewChange --> Parse String 2 Long Failed");
  }
  
  void a(String paramString, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (localSessionInfo == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchUIMode[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], SessionType[");
      localStringBuilder.append(localSessionInfo.jdField_d_of_type_Int);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    boolean bool;
    if (localSessionInfo.jdField_d_of_type_Int == 4)
    {
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(false);
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(false);
      this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setVisibility(8);
      ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoLayerUI.i(this.jdField_a_of_type_ComTencentAvVideoController.a().L);
      ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.jdField_a_of_type_ComTencentAvVideoController.a());
      A();
      int m;
      if ((!localSessionInfo.jdField_j_of_type_Boolean) && (!localSessionInfo.jdField_k_of_type_Boolean)) {
        m = 1;
      } else {
        m = 2;
      }
      a(true, m);
      if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(true);
      }
      a(true);
      b(true);
      h(paramLong, 0);
      g(paramLong, 8);
      j(paramLong, 8);
      bool = true;
    }
    else
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      p(true);
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(true);
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(true);
      this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setVisibility(0);
      paramString = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (!paramString.isFinishing()) {
        paramString.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i(-1);
      }
      A();
      a(false, 1);
      if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(false);
      }
      a(false);
      b(false);
      h(paramLong, 8);
      g(paramLong, 0);
      j(paramLong, 0);
      a(paramLong, 0.0F);
      bool = false;
    }
    a(Boolean.valueOf(bool));
    i(paramLong, 16777215);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(102) });
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
    else
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(0);
      }
    }
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showOrHideRecvVideoBtnAndTips --> bShow = ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" , needNoticeWiFiTips = ");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append(" , needShowGLView = ");
      localStringBuilder.append(paramBoolean3);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.r = paramBoolean1;
    this.jdField_a_of_type_ComTencentAvVideoController.a().b(paramBoolean1);
    if (this.jdField_a_of_type_ComTencentAvTipsAvTipsView != null) {
      this.jdField_a_of_type_ComTencentAvTipsAvTipsView.a(paramBoolean1, new MultiVideoCtrlLayerUIBase.10(this));
    }
    if (paramBoolean1)
    {
      DataReport.d(NetworkUtil.isWifiConnected((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()), this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int);
      N();
      if (paramBoolean2) {
        TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3013);
      } else {
        TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3013);
      }
    }
    else
    {
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3013);
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1030);
    }
    if (paramBoolean3) {
      b(AudioHelper.b(), this.jdField_a_of_type_ComTencentAvVideoController.a().c);
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
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkRemoteVideo, displayViewList[");
      localStringBuilder.append(localSessionInfo.c.size());
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (localSessionInfo.c.size() == 0)
    {
      a(paramLong, "checkRemoteVideo");
      a(false, false, false);
      return false;
    }
    if ((localSessionInfo.c.size() == 1) && (((VideoViewInfo)localSessionInfo.c.get(0)).jdField_a_of_type_Long == this.jdField_c_of_type_Long))
    {
      a(false, false, false);
      e("checkRemoteVideo");
      return false;
    }
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    boolean bool2 = QAVConfigUtils.i();
    boolean bool1;
    if ((!localSessionInfo.S) && (!localSessionInfo.T)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkBlockOpenMicOrCamera, isAllowedControlMicAfterBeMuted[");
      localStringBuilder.append(bool2);
      localStringBuilder.append("], isNormalUser[");
      localStringBuilder.append(bool1);
      localStringBuilder.append("], isRoomMicOff[");
      localStringBuilder.append(localSessionInfo.M);
      localStringBuilder.append("], micAuthByAdmin[");
      localStringBuilder.append(localSessionInfo.G);
      localStringBuilder.append("], openMic[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    int m;
    if ((bool1) && (localSessionInfo.M) && (localSessionInfo.G != 0))
    {
      if (paramBoolean) {
        m = 2131695545;
      } else {
        m = 2131695715;
      }
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1033, this.jdField_a_of_type_AndroidContentResResources.getString(m));
      if (paramBoolean) {
        m = 1;
      } else {
        m = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800AB7F", "0X800AB7F", m, 0, "1", "", "", "");
      return true;
    }
    if ((!bool2) && (bool1) && (localSessionInfo.G == 1))
    {
      if (paramBoolean) {
        m = 2131695548;
      } else {
        m = 2131695716;
      }
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1033, this.jdField_a_of_type_AndroidContentResResources.getString(m));
      if (paramBoolean) {
        m = 1;
      } else {
        m = 2;
      }
      ReportController.b(null, "CliOper", "", "", "0X800AB7F", "0X800AB7F", m, 0, "2", "", "", "");
      return true;
    }
    return false;
  }
  
  void a_(long paramLong, int paramInt)
  {
    this.jdField_j_of_type_Int = paramInt;
    if (this.jdField_j_of_type_Int == 2131695503) {
      C();
    }
    super.d(paramLong, this.jdField_a_of_type_AndroidContentResResources.getString(paramInt));
  }
  
  void b()
  {
    long l1 = AudioHelper.b();
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    Object localObject2 = this.jdField_d_of_type_JavaLangString;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("initUI, SessionType[");
    ((StringBuilder)localObject3).append(((SessionInfo)localObject1).jdField_d_of_type_Int);
    ((StringBuilder)localObject3).append("], switchToGAudioMode[");
    ((StringBuilder)localObject3).append(((SessionInfo)localObject1).F);
    ((StringBuilder)localObject3).append("], localMute[");
    ((StringBuilder)localObject3).append(((SessionInfo)localObject1).g);
    ((StringBuilder)localObject3).append("], seq[");
    ((StringBuilder)localObject3).append(l1);
    ((StringBuilder)localObject3).append("]");
    QLog.w((String)localObject2, 1, ((StringBuilder)localObject3).toString());
    super.b();
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      p();
      this.jdField_a_of_type_ComTencentAvUiQavPanel.e();
      localObject2 = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject2 != null)
      {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper = TraeHelper.a();
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(this.jdField_a_of_type_ComTencentAvUtilsTraeHelper);
        this.jdField_a_of_type_ComTencentAvUtilsSensorHelper = SensorHelper.a(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper, (Activity)localObject2, this.jdField_a_of_type_ComTencentAvVideoController, this.jdField_a_of_type_ComTencentAvUtilsTraeHelper);
        this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a(true);
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
      }
    }
    this.jdField_e_of_type_AndroidWidgetTextView.post(this.jdField_g_of_type_JavaLangRunnable);
    k(l1, 8);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373393));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370754));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376548));
    a(this.jdField_c_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetImageView);
    a(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_c_of_type_AndroidWidgetTextView);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363038));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363044));
    a(this.jdField_d_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetImageView);
    a(this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_d_of_type_AndroidWidgetTextView);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373394));
    i(l1, 16777215);
    localObject2 = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_d_of_type_JavaLangString, 2, "initUI-->can not get AVActivity");
      }
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373631));
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI = ((MultiMembersAudioUI)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373543));
    this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI = ((MultiMembersVideoUI)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373544));
    int n = ImmersiveUtils.getScreenHeight();
    int m = n;
    if (ImmersiveUtils.isSupporImmersive() != 1) {
      m = n - ImmersiveUtils.getStatusBarHeight((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    }
    m = (int)(m * 58 / 1000.0F);
    localObject3 = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject3).topMargin = m;
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setLayoutParams((ViewGroup.LayoutParams)localObject3);
    this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI.setVisibility(8);
    v();
    GAudioSoundUtil.a(((AVActivity)localObject2).getApplicationContext());
    if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(true);
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(true);
      if ((this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) && (!this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.b())) {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.i();
      }
    }
    if ((((SessionInfo)localObject1).b()) && (((SessionInfo)localObject1).g))
    {
      m = this.jdField_a_of_type_ComTencentAvVideoController.e();
      this.jdField_a_of_type_ComTencentAvVideoController.a("MultiVideoCtrlLayerUIBase.initUI", ((SessionInfo)localObject1).jdField_f_of_type_Long, false, true, -1);
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a("MultiVideoCtrlLayerUIBase.initUI", m, this.jdField_a_of_type_ComTencentAvVideoController.e(), false);
      }
      super.k(2131373351);
    }
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a();
    if (this.jdField_f_of_type_JavaLangRunnable == null) {
      this.jdField_f_of_type_JavaLangRunnable = new MultiVideoCtrlLayerUIBase.RefreshDisplayNameRunnable(this);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.jdField_f_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = new QavInOutAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentAvVideoController, 3, this.jdField_a_of_type_ComTencentAvUiQavPanel, this.jdField_d_of_type_AndroidWidgetRelativeLayout, null, null, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373523), null);
    this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a();
    if (((SessionInfo)localObject1).jdField_d_of_type_Int == 4) {
      a("initUI", l1);
    }
    ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.i());
    if (AudioHelper.a(0) == 1) {
      this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setBackgroundColor(531496751);
    }
    localObject1 = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373357);
    ((ImageView)localObject1).setOnClickListener(new MultiVideoCtrlLayerUIBase.4(this, (ImageView)localObject1));
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
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    super.b(paramLong);
    o(paramLong);
    q(paramLong);
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.a().ae = false;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.jdField_d_of_type_Boolean)) {
      s();
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
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().q()) {
        return;
      }
      this.jdField_f_of_type_Int = (360 - paramInt);
      a(paramLong, this.jdField_f_of_type_Int);
    }
  }
  
  void b(long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_d_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onGroupVideoChatClosed, relationId[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("], mIntentRelationId[");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    if (this.jdField_a_of_type_Long != paramLong) {
      return;
    }
    Object localObject1 = new Intent();
    ((Intent)localObject1).setAction("tencent.av.v2q.MultiVideo");
    ((Intent)localObject1).putExtra("type", 32);
    ((Intent)localObject1).putExtra("relationId", paramLong);
    ((Intent)localObject1).putExtra("uinType", this.jdField_d_of_type_Int);
    ((Intent)localObject1).putExtra("closeType", paramInt1);
    ((Intent)localObject1).putExtra("MultiAVType", paramInt2);
    ((Intent)localObject1).putExtra("from", this.jdField_d_of_type_JavaLangString);
    Object localObject2 = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject2 != null)
    {
      ((Intent)localObject1).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName());
      ((AVActivity)localObject2).sendBroadcast((Intent)localObject1);
      e(true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e(this.jdField_d_of_type_JavaLangString, 2, "onGroupVideoChatClosed-->can not get the activity");
    }
  }
  
  void b(long paramLong, String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyDataChange, from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    paramString = this.jdField_a_of_type_ComTencentAvVideoController.a();
    ThreadManager.getSubThreadHandler().post(new MultiVideoCtrlLayerUIBase.7(this, paramString, paramLong));
  }
  
  void b(long paramLong, ArrayList<VideoViewInfo> paramArrayList)
  {
    int m = 0;
    while (m < paramArrayList.size())
    {
      VideoViewInfo localVideoViewInfo = (VideoViewInfo)paramArrayList.get(m);
      if ((localVideoViewInfo.jdField_a_of_type_Long == this.jdField_c_of_type_Long) && (localVideoViewInfo.jdField_a_of_type_Int == 1) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean))
      {
        paramArrayList.remove(m);
        break;
      }
      m += 1;
    }
    this.jdField_b_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(103), paramArrayList, Long.valueOf(paramLong) });
  }
  
  void b(Intent paramIntent)
  {
    try
    {
      this.jdField_c_of_type_Long = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
    }
    catch (Exception localException)
    {
      label20:
      Object localObject;
      int m;
      break label20;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "Can not get AccountUin WHY!!!???");
    }
    this.jdField_c_of_type_Long = 0L;
    localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    this.jdField_d_of_type_Int = ((SessionInfo)localObject).jdField_k_of_type_Int;
    m = this.jdField_d_of_type_Int;
    if (m == 3000) {
      this.jdField_e_of_type_Int = 2;
    } else if (m == 1) {
      this.jdField_e_of_type_Int = 1;
    }
    ((SessionInfo)localObject).jdField_E_of_type_Int = this.jdField_e_of_type_Int;
    m = ((SessionInfo)localObject).D;
    this.jdField_a_of_type_Long = ((SessionInfo)localObject).jdField_f_of_type_Long;
    this.jdField_c_of_type_Int = ((SessionInfo)localObject).D;
    this.q = false;
    if (paramIntent != null) {
      this.jdField_e_of_type_Boolean = paramIntent.getBooleanExtra("isVideo", false);
    }
    paramIntent = this.jdField_d_of_type_JavaLangString;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("processIntentData, mUinType[");
    ((StringBuilder)localObject).append(this.jdField_d_of_type_Int);
    ((StringBuilder)localObject).append("], mRelationType[");
    ((StringBuilder)localObject).append(this.jdField_e_of_type_Int);
    ((StringBuilder)localObject).append("], mIntentRelationId[");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
    ((StringBuilder)localObject).append("], mStatusType[");
    ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
    ((StringBuilder)localObject).append("], mStatusType[");
    ((StringBuilder)localObject).append(m);
    ((StringBuilder)localObject).append("->");
    ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
    ((StringBuilder)localObject).append("], getSimpleDataList[");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvVideoController.e());
    ((StringBuilder)localObject).append("], getGAudioList[");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvVideoController.c());
    ((StringBuilder)localObject).append("]");
    QLog.w(paramIntent, 1, ((StringBuilder)localObject).toString());
  }
  
  void b(boolean paramBoolean)
  {
    Object localObject = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_d_of_type_JavaLangString, 2, "switchMode --> Can not get activity");
      }
      return;
    }
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373400);
    localObject = (AVActivity)localObject;
    if (paramBoolean)
    {
      localRelativeLayout.setBackgroundColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131167333));
      if (localObject != null)
      {
        ((AVActivity)localObject).b(false);
        ((AVActivity)localObject).e(false);
        ((AVActivity)localObject).c(true);
      }
    }
    else
    {
      localRelativeLayout.setBackgroundColor(this.jdField_a_of_type_AndroidContentResResources.getColor(2131166061));
      if (localObject != null)
      {
        ((AVActivity)localObject).b(true);
        ((AVActivity)localObject).e(true);
        ((AVActivity)localObject).c(false);
      }
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPhoneCalling, isSelf[");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if (paramBoolean1)
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_E_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.a(TraeHelper.jdField_b_of_type_Int);
      }
      e();
    }
  }
  
  protected boolean b()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentAvVideoController.a().k();
  }
  
  abstract void c();
  
  public void c(int paramInt)
  {
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "showToolBars");
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().q())
    {
      e(paramInt);
      C(l1);
    }
  }
  
  public void c(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStop, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 2, localStringBuilder.toString());
    }
    super.c(paramLong);
    E();
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void c(long paramLong, int paramInt)
  {
    if ((paramInt == 2) || (paramInt == 1))
    {
      s(paramLong);
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().c, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList, 1, false);
    }
    super.c(paramLong, paramInt);
  }
  
  public void c(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {
      e();
    }
    w();
  }
  
  public void c(Intent paramIntent)
  {
    super.c(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "OnNewIntent");
    }
    b(paramIntent);
    boolean bool = false;
    if (paramIntent != null)
    {
      bool = paramIntent.getBooleanExtra("needStartTRAE", false);
      N();
    }
    a(paramIntent);
    if (bool) {
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.c();
    }
    a();
  }
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      super.l(2131373351);
      if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (paramBoolean2))
      {
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel.a() != 3) {
          r(true);
        } else {
          TipsUtil.a(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 9, 3000L);
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
      }
    }
    else
    {
      super.k(2131373351);
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false);
      if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
        this.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131373351, ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131692832));
      }
      if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (paramBoolean2))
      {
        r(false);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
      }
    }
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
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_b_of_type_ComTencentAvAppGAudioUIObserver);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppInviteMemberObserver);
    ((BaseActivity)localObject).registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("tencent.video.q2v.GvideoMemInviteUpdate"));
    this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    localObject = a();
    b((Intent)localObject);
    a((Intent)localObject);
    this.jdField_a_of_type_ComTencentAvVideoController.r();
  }
  
  public void d(int paramInt) {}
  
  public void d(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnDestroy, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAvVideoController.s();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_b_of_type_ComTencentAvAppGAudioUIObserver);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppInviteMemberObserver);
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
    H();
    TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1030);
    TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036);
    TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1037);
    TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3013);
    TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1034);
    TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1035);
    this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a(false);
    this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(false);
    this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(false);
    this.jdField_a_of_type_ComTencentAvUtilsSensorHelper = null;
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI = null;
    this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.i = -1;
    this.jdField_j_of_type_Int = -1;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    }
    Object localObject = this.jdField_a_of_type_ComTencentSharpJniApiITraeMediaPlayerApi;
    if (localObject != null)
    {
      ((ITraeMediaPlayerApi)localObject).stopRing(paramLong);
      this.jdField_a_of_type_ComTencentSharpJniApiITraeMediaPlayerApi = null;
    }
    localObject = this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation;
    if (localObject != null)
    {
      ((QavInOutAnimation)localObject).b();
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = null;
    }
    super.d(paramLong);
  }
  
  void d(long paramLong, View paramView)
  {
    String str = this.jdField_d_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClick_Mute, micPermission[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvVideoController.a().p);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (a(paramLong, "android.permission.RECORD_AUDIO", paramView)) {
      t(paramLong);
    }
    super.C(paramLong);
  }
  
  void d(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addRequestVideoTimeoutRunnable[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.jdField_b_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    } else {
      this.jdField_b_of_type_JavaLangRunnable = new MultiVideoCtrlLayerUIBase.RequestVideoTimeOutRunnable(this);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 30000L);
  }
  
  public void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNotifyAIDenoiseTips, isFromlocal[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (a() != null)
    {
      if (paramBoolean)
      {
        TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3016);
        return;
      }
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3015);
    }
  }
  
  boolean d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "Go on Stage");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      return this.jdField_a_of_type_ComTencentAvVideoController.l();
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
  
  abstract void e();
  
  void e(long paramLong, int paramInt)
  {
    boolean bool = true;
    if (paramInt <= 1)
    {
      String str = this.jdField_a_of_type_AndroidContentResResources.getString(2131695560);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(str);
      bool = false;
    }
    else
    {
      a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_AndroidWidgetTextView, paramInt);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setClickable(bool);
    this.jdField_a_of_type_AndroidWidgetImageView.setClickable(bool);
    if (!bool)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  void e(long paramLong, View paramView)
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    String str = this.jdField_d_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClick_CAMERA, sessionInfo[");
    localStringBuilder.append(localSessionInfo);
    localStringBuilder.append("], mHasLauncnRequestFromCameraButton[");
    localStringBuilder.append(this.q);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (a(paramLong, "android.permission.CAMERA", paramView)) {
      if (!localSessionInfo.jdField_j_of_type_Boolean)
      {
        if (!f()) {
          return;
        }
        int n = 0;
        if (a(false)) {
          return;
        }
        DataReport.f(true);
        if (!NetworkUtil.isWifiConnected((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()))
        {
          paramView = new StringBuilder();
          paramView.append(VideoController.jdField_b_of_type_JavaLangString);
          paramView.append(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
          if (VideoController.d(paramView.toString()) > 0) {
            m = 0;
          } else {
            m = 1;
          }
          if (m != 0)
          {
            paramView = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
            if (paramView == null) {
              return;
            }
            DialogUtil.a(paramView, 230, this.jdField_a_of_type_AndroidContentResResources.getString(2131695691), this.jdField_a_of_type_AndroidContentResResources.getString(2131695687), 2131695421, 2131695433, new MultiVideoCtrlLayerUIBase.12(this, paramLong), new MultiVideoCtrlLayerUIBase.13(this)).show();
            m = n;
            break label287;
          }
        }
        int m = 1;
        label287:
        if (m != 0) {
          if ((localSessionInfo.c() == -1) && (!NetworkUtil.isWifiConnected((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())))
          {
            r(paramLong);
          }
          else if (d())
          {
            this.q = true;
            i(paramLong, 16777215);
          }
          else if (QLog.isColorLevel())
          {
            QLog.e(this.jdField_d_of_type_JavaLangString, 2, "PressCameraBtnRunnable-->go on stage fail,can not find the session");
          }
        }
      }
      else
      {
        s(paramLong);
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Long, localSessionInfo.c, localSessionInfo.jdField_d_of_type_JavaUtilArrayList, 1, false);
      }
    }
    l(paramLong, 2131695333);
  }
  
  void e(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeRequestVideoTimeoutRunnable[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.jdField_b_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
  }
  
  void e(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), String.valueOf(this.jdField_a_of_type_Long), Boolean.valueOf(paramBoolean) });
    if (this.jdField_b_of_type_Boolean) {
      D();
    }
  }
  
  boolean e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "startRecvAllVideo");
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController;
    boolean bool2 = false;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_d_of_type_JavaLangString, 2, "startRecvAllVideo --> VideoController is null");
      }
      return false;
    }
    localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localObject != null) && ((localObject instanceof AVActivity)))
    {
      localObject = (AVActivity)localObject;
      if (localObject != null)
      {
        bool1 = ((AVActivity)localObject).isResume();
        break label98;
      }
    }
    boolean bool1 = true;
    label98:
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_d_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startRecvAllVideo --> isResume = ");
      localStringBuilder.append(bool1);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (!bool1) {
      return false;
    }
    int n = this.jdField_a_of_type_ComTencentAvVideoController.a().c.size();
    int m = n;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean) {
      m = n - 1;
    }
    if (m <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_d_of_type_JavaLangString, 2, "startRecvAllVideo --> There is no video need request");
      }
      return false;
    }
    m = Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp());
    if (m == 1)
    {
      if (QLog.isColorLevel())
      {
        localObject = this.jdField_d_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("startRecvAllVideo --> This version is not supportsharpvideo or opengl.  GlVersion = ");
        localStringBuilder.append(m);
        QLog.e((String)localObject, 2, localStringBuilder.toString());
      }
      return false;
    }
    ReportController.b(null, "CliOper", "", "", "0X8005617", "0X8005617", 0, 0, "", "", "", "");
    m = this.jdField_a_of_type_ComTencentAvVideoController.g();
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_d_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startRecvAllVideo --> Ability = ");
      localStringBuilder.append(m);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (m != 4)
    {
      if (this.jdField_e_of_type_Int == 2) {
        ReportController.b(null, "CliOper", "", "", "0X8004CF6", "0X8004CF6", 0, 0, "", "", "", "");
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().c.size() > 1) {
        TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3007);
      }
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().e.clear();
    long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    m = 0;
    while (m < this.jdField_a_of_type_ComTencentAvVideoController.a().c.size())
    {
      localObject = (VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(m);
      if ((((VideoViewInfo)localObject).jdField_c_of_type_Boolean) && (l1 != ((VideoViewInfo)localObject).jdField_a_of_type_Long)) {
        this.jdField_a_of_type_ComTencentAvVideoController.a().e.add(localObject);
      }
      m += 1;
    }
    a(false, false, false);
    H();
    TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036);
    TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1037);
    bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().L == 3) {
      bool1 = true;
    }
    return this.jdField_a_of_type_ComTencentAvVideoController.a(bool1);
  }
  
  void f(long paramLong, int paramInt)
  {
    boolean bool = true;
    if (paramInt <= 1) {
      bool = false;
    }
    a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_AndroidWidgetTextView, paramInt);
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if ((localTextView != null) && (localTextView.isShown()))
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
  }
  
  void f(boolean paramBoolean)
  {
    long l1 = AudioHelper.b();
    ITraeMediaPlayerApi localITraeMediaPlayerApi = this.jdField_a_of_type_ComTencentSharpJniApiITraeMediaPlayerApi;
    if (localITraeMediaPlayerApi == null)
    {
      this.jdField_a_of_type_ComTencentSharpJniApiITraeMediaPlayerApi = ((ITraeMediaPlayerApi)QRoute.api(ITraeMediaPlayerApi.class));
      this.jdField_a_of_type_ComTencentSharpJniApiITraeMediaPlayerApi.init((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), null);
    }
    else
    {
      localITraeMediaPlayerApi.stopRing(l1);
    }
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      if (GAudioSoundUtil.a("qav_gaudio_muted.mp3"))
      {
        localITraeMediaPlayerApi = this.jdField_a_of_type_ComTencentSharpJniApiITraeMediaPlayerApi;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(GAudioSoundUtil.a());
        localStringBuilder.append("qav_gaudio_muted.mp3");
        localITraeMediaPlayerApi.playRing(l1, 2, 0, null, localStringBuilder.toString(), false, 1, false, true, 0);
      }
    }
    else if (GAudioSoundUtil.a("qav_gaudio_cancel_muted.mp3"))
    {
      localITraeMediaPlayerApi = this.jdField_a_of_type_ComTencentSharpJniApiITraeMediaPlayerApi;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(GAudioSoundUtil.a());
      localStringBuilder.append("qav_gaudio_cancel_muted.mp3");
      localITraeMediaPlayerApi.playRing(l1, 2, 0, null, localStringBuilder.toString(), false, 1, false, true, 0);
    }
  }
  
  boolean f()
  {
    if ((VcSystemInfo.isNormalSharp()) && (Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) != 1))
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.b() >= jdField_b_of_type_Int)
      {
        TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1031);
        return false;
      }
      return true;
    }
    DoubleVideoCtrlUI.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    return false;
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
        localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a().c.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (VideoViewInfo)((Iterator)localObject1).next();
          if (!((VideoViewInfo)localObject2).jdField_a_of_type_Boolean) {
            ((VideoViewInfo)localObject2).jdField_c_of_type_Boolean = true;
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().c.size() > 0) {
        ((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0)).jdField_c_of_type_Boolean = true;
      }
    }
    else if (paramInt == 4)
    {
      if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().w()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().c.size() > 0))
      {
        ((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0)).jdField_a_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_d_of_type_JavaLangString, 2, "MultiVideoCtrlLayerUIBase onLayoutModeChange --> displayList  not has big one");
        }
      }
      if (4 == this.jdField_a_of_type_ComTencentAvVideoController.g())
      {
        localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a().c.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (VideoViewInfo)((Iterator)localObject1).next();
          if (!((VideoViewInfo)localObject2).jdField_a_of_type_Boolean) {
            ((VideoViewInfo)localObject2).jdField_c_of_type_Boolean = true;
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().c.size() > 0) {
        ((VideoViewInfo)this.jdField_a_of_type_ComTencentAvVideoController.a().c.get(0)).jdField_c_of_type_Boolean = true;
      }
    }
    e();
  }
  
  void g(long paramLong, int paramInt)
  {
    if (this.jdField_d_of_type_AndroidWidgetTextView != null)
    {
      if ((QLog.isDevelopLevel()) || (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() != paramInt))
      {
        localObject = this.jdField_d_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setVisibility_AudioMemberInfoText, visibility[");
        localStringBuilder.append(this.jdField_d_of_type_AndroidWidgetTextView.getVisibility());
        localStringBuilder.append("->");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w((String)localObject, 1, localStringBuilder.toString());
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(paramInt);
      Object localObject = this.jdField_d_of_type_AndroidWidgetTextView.getText();
      if ((!TextUtils.equals(this.jdField_a_of_type_AndroidContentResResources.getString(2131695560), (CharSequence)localObject)) && (this.i > 1))
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(paramInt);
        return;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  protected boolean g()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return false;
    }
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    boolean bool2 = QAVConfigUtils.i();
    boolean bool1;
    if ((!localSessionInfo.S) && (!localSessionInfo.T)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("canStopMuteStatus, isAllowedControlMicAfterBeMuted[");
      localStringBuilder.append(bool2);
      localStringBuilder.append("], isNormalUser[");
      localStringBuilder.append(bool1);
      localStringBuilder.append("], isRoomMicOff[");
      localStringBuilder.append(localSessionInfo.M);
      localStringBuilder.append("], micAuthByAdmin[");
      localStringBuilder.append(localSessionInfo.G);
      localStringBuilder.append("], mIsPhoneCalling[");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Boolean);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if ((bool1) && (localSessionInfo.M) && (localSessionInfo.G != 0)) {
      return false;
    }
    if ((!bool2) && (bool1) && (localSessionInfo.G == 1)) {
      return false;
    }
    return !this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Boolean;
  }
  
  @QQPermissionGrant(2)
  public void grantForAudioRecord()
  {
    QLog.d(this.jdField_d_of_type_JavaLangString, 1, "showPermissionDialog grantForAudioRecord(2) 09");
  }
  
  void h(int paramInt)
  {
    if ((paramInt != 6) && (paramInt != 8))
    {
      if (paramInt == 74) {
        return;
      }
      if (Utils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp()) == 1)
      {
        TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1012, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131720255));
        ReportController.b(null, "CliOper", "", "", "0X8004E94", "0X8004E94", 0, 0, "", "", "", "");
        ReportController.b(null, "CliOper", "", "", "0X8005618", "0X8005618", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_d_of_type_JavaLangString, 2, "startRecvAllVideo-->GLVersion not support");
        }
      }
    }
  }
  
  void h(long paramLong, int paramInt)
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      if ((QLog.isDevelopLevel()) || (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != paramInt))
      {
        localObject = this.jdField_d_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setVisibility_VideoMemberInfoText, visibility[");
        localStringBuilder.append(this.jdField_c_of_type_AndroidWidgetTextView.getVisibility());
        localStringBuilder.append("->");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w((String)localObject, 1, localStringBuilder.toString());
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(paramInt);
      Object localObject = this.jdField_c_of_type_AndroidWidgetTextView.getText();
      if (TextUtils.equals(this.jdField_a_of_type_AndroidContentResResources.getString(2131695560), (CharSequence)localObject))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(paramInt);
    }
  }
  
  public void k(long paramLong) {}
  
  public void m(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnPause, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    super.m(paramLong);
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "OnPause Error : VideoController is null");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().ae = true;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c("MultiVideoCtrlLayerUIBase");
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      if (((!SmallScreenUtils.f()) || ((!NetworkUtil.isWifiConnected((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().ag))) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean)) {
        s(paramLong);
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().c() != -1) {
        this.jdField_a_of_type_ComTencentAvVideoController.a("Multi_onPause");
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().b(this.jdField_c_of_type_Long, true, true);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_h_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$StartRecvVideoRunnable);
  }
  
  public void o()
  {
    super.o();
  }
  
  void o(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.jdField_d_of_type_Boolean))
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.i())
      {
        super.k(2131373351);
        if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
          this.jdField_a_of_type_ComTencentAvUiQavPanel.b(this.jdField_a_of_type_ComTencentAvVideoController.i());
        }
      }
      this.jdField_a_of_type_ComTencentAvVideoController.q();
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 9)
      {
        e(paramLong, true);
        a_(paramLong, 2131695560);
      }
      else
      {
        e(paramLong, false);
        d(paramLong, null);
      }
      A(paramLong);
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(true);
      this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(true);
    }
  }
  
  protected abstract void p();
  
  void p(long paramLong)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendVideoMsgBroadcast--> discussionId = ");
      localStringBuilder.append(paramLong);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      localObject = new Intent();
      ((Intent)localObject).setAction("tencent.video.v2q.AddVideoMsg");
      ((Intent)localObject).putExtra("uinType", this.jdField_d_of_type_Int);
      ((Intent)localObject).putExtra("msgType", 13);
      ((Intent)localObject).putExtra("isVideoMsg", false);
      ((Intent)localObject).putExtra("friendUin", Long.toString(paramLong));
      ((Intent)localObject).putExtra("senderUin", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      ((Intent)localObject).putExtra("isSender", true);
      ((Intent)localObject).putExtra("isRead", true);
      ((Intent)localObject).putExtra("MultiAVType", this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int);
      ((Intent)localObject).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast((Intent)localObject);
    }
  }
  
  protected void q(long paramLong)
  {
    if (h()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131373351, true);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131373351, true);
      if (this.jdField_a_of_type_ComTencentAvVideoController.i()) {
        k(2131373351);
      } else {
        l(2131373351);
      }
      this.jdField_a_of_type_ComTencentAvUiQavPanel.b(this.jdField_a_of_type_ComTencentAvVideoController.i());
      A();
    }
    long l1 = this.jdField_b_of_type_Long;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_d_of_type_Int, String.valueOf(l1));
    i(paramLong, 16777215);
    A(paramLong);
  }
  
  void r(long paramLong)
  {
    Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    String str = this.jdField_d_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("goOnStageWithoutWiFiCheck, mContext[");
    boolean bool;
    if (localContext != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (localContext == null) {
      return;
    }
    int m;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().t()) {
      m = 2131695703;
    } else {
      m = 2131695704;
    }
    DialogUtil.a(localContext, 230, null, this.jdField_a_of_type_AndroidContentResResources.getString(m), 2131695421, 2131695433, new MultiVideoCtrlLayerUIBase.8(this, paramLong), new MultiVideoCtrlLayerUIBase.9(this)).show();
  }
  
  void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "resumeVideo");
    }
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new MultiVideoCtrlLayerUIBase.AutoCheckRunnable(this);
    } else {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
  }
  
  void s(long paramLong)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("goOffStage, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_b_of_type_ComTencentAvUiControlUIObserver != null) && (this.jdField_a_of_type_ComTencentAvUiQavPanel != null))
    {
      this.jdField_a_of_type_ComTencentAvVideoController.x();
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, "goOffStage", false, false);
      this.jdField_b_of_type_ComTencentAvUiControlUIObserver.update(null, new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
      b(2131373636, 8);
      localObject = a();
      if (localObject != null) {
        ((AVActivity)localObject).a(false);
      }
      a("goOffStage", paramLong);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_d_of_type_JavaLangString, 2, "goOffStage --> Error");
    }
  }
  
  void t(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentAvUiQavPanel.a()) && (!this.jdField_a_of_type_ComTencentAvUiQavPanel.b()))
    {
      QLog.d(this.jdField_d_of_type_JavaLangString, 1, "intercept doMute operation");
      return;
    }
    boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.i();
    long l1;
    if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_d_of_type_Boolean) {
      l1 = this.jdField_b_of_type_Long;
    } else {
      l1 = this.jdField_a_of_type_Long;
    }
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doMute, relationId[");
      localStringBuilder.append(l1);
      localStringBuilder.append("], mute[");
      localStringBuilder.append(bool);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    int m;
    if (bool)
    {
      if (a(true)) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.w(this.jdField_d_of_type_JavaLangString, 1, "PhoneCalling-status not support open MIC");
        }
        return;
      }
      if (this.jdField_e_of_type_Int == 2) {
        DataReport.a(true, 1);
      } else {
        DataReport.a(true, 10);
      }
      r(true);
      m = this.jdField_a_of_type_ComTencentAvVideoController.e();
      this.jdField_a_of_type_ComTencentAvVideoController.a("MultiVideoCtrlLayerUIBase.doMute.1", l1, true, true, -1);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a("MultiVideoCtrlLayerUIBase.doMute.1", m, this.jdField_a_of_type_ComTencentAvVideoController.e(), false);
      super.l(2131373351);
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
      }
    }
    else
    {
      if (this.jdField_e_of_type_Int == 2) {
        DataReport.a(false, 1);
      } else {
        DataReport.a(false, 10);
      }
      r(false);
      m = this.jdField_a_of_type_ComTencentAvVideoController.e();
      this.jdField_a_of_type_ComTencentAvVideoController.a("MultiVideoCtrlLayerUIBase.doMute.2", l1, false, true, -1);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.a("MultiVideoCtrlLayerUIBase.doMute.2", m, this.jdField_a_of_type_ComTencentAvVideoController.e(), false);
      super.k(2131373351);
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(109) });
      }
    }
  }
  
  public void u(long paramLong)
  {
    long l1 = AudioHelper.b();
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("go on stage failed, info[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    b(2131373636, 8);
    Object localObject = a();
    if (localObject != null) {
      ((AVActivity)localObject).a(false);
    }
    i(l1, 16777215);
    if (paramLong == 7L) {
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1029);
    } else if (paramLong == 8L) {
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1033, this.jdField_a_of_type_AndroidContentResResources.getString(2131695715));
    } else {
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1028);
    }
    if (this.jdField_e_of_type_Int == 2) {
      ReportController.b(null, "CliOper", "", "", "0X800441E", "0X800441E", 0, 0, "", "", "", "");
    }
  }
  
  void v()
  {
    long l2 = AudioHelper.b();
    if (QLog.isColorLevel())
    {
      String str = this.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initViewList, seq[");
      localStringBuilder.append(l2);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    int m = this.jdField_c_of_type_Int;
    long l1;
    if ((m != 0) && (m != 1)) {
      l1 = this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long;
    } else {
      l1 = this.jdField_a_of_type_Long;
    }
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(l1, this.jdField_e_of_type_Int, false);
    this.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setOnItemClickListener(this.jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener);
    b(l2, "initViewList");
  }
  
  void v(long paramLong)
  {
    QLog.d(this.jdField_d_of_type_JavaLangString, 1, "avideo onClick QavPanel.ViewID.SWITCH_DISPLAY_MODE");
    int m = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
    int i1 = 4;
    if ((m == 4) && (this.jdField_a_of_type_ComTencentAvVideoController.a().c.size() > 0))
    {
      AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      int n = localAVActivity.c();
      if (3 == n) {
        m = 1;
      } else {
        m = 0;
      }
      if (4 == n) {
        n = 1;
      } else {
        n = 0;
      }
      if (n != 0) {
        ReportController.b(null, "CliOper", "", "", "0X8009F5E", "0X8009F5E", 0, 0, "", "", "", "");
      } else {
        ReportController.b(null, "CliOper", "", "", "0X8009F5F", "0X8009F5F", 0, 0, "", "", "", "");
      }
      if ((n == 0) && (m == 0))
      {
        QLog.d(this.jdField_d_of_type_JavaLangString, 1, "avideo onClick QavPanel.ViewID.SWITCH_DISPLAY_MODE error happen");
      }
      else
      {
        if (m != 0) {
          m = i1;
        } else {
          m = 3;
        }
        localAVActivity.a(m, false);
      }
    }
    l(paramLong, 2131695344);
  }
  
  public void w()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    boolean bool = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean;
    int n = 0;
    int i1 = 0;
    int m;
    if ((!bool) && (this.jdField_a_of_type_ComTencentAvVideoController.a().c.size() <= 0)) {
      m = 0;
    } else {
      m = 1;
    }
    Object localObject1 = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373325);
    Object localObject2 = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373653);
    Object localObject3 = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373357);
    StringBuilder localStringBuilder;
    if (m != 0)
    {
      ((TextView)localObject1).setVisibility(8);
      if ((!jdField_a_of_type_Boolean) && (!this.jdField_f_of_type_Boolean))
      {
        localObject1 = this.jdField_d_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("refreshSpokesmanInfoUI video. txt = ");
        localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
        QLog.d((String)localObject1, 2, localStringBuilder.toString());
        if (this.jdField_h_of_type_Boolean) {
          n = 71;
        } else {
          n = 21;
        }
        m = n;
        if (ImmersiveUtils.isSupporImmersive() != 1) {
          m = n - ImmersiveUtils.getStatusBarHeight((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
        }
        n = m;
        if (VideoConstants.jdField_c_of_type_Boolean) {
          if (this.jdField_h_of_type_Boolean) {
            n = m + 5;
          } else {
            n = m + 25;
          }
        }
        localObject1 = (RelativeLayout.LayoutParams)((TextView)localObject2).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)UITools.a(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), n));
        ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        ((TextView)localObject2).setText(this.jdField_c_of_type_JavaLangString);
        if (this.jdField_c_of_type_JavaLangString.length() > 0) {
          m = 0;
        } else {
          m = 8;
        }
        ((TextView)localObject2).setVisibility(m);
        if (this.jdField_c_of_type_JavaLangString.length() > 0) {
          m = i1;
        } else {
          m = 8;
        }
        ((ImageView)localObject3).setVisibility(m);
      }
      localObject1 = a();
      if ((localObject1 != null) && (((AVActivity)localObject1).jdField_a_of_type_ComTencentAvUiVideoLayerUI != null))
      {
        if (this.jdField_h_of_type_Boolean) {
          m = 115;
        } else {
          m = 65;
        }
        n = m;
        if (VideoConstants.jdField_c_of_type_Boolean) {
          if (this.jdField_h_of_type_Boolean) {
            n = m + 5;
          } else {
            n = m + 25;
          }
        }
        ((AVActivity)localObject1).jdField_a_of_type_ComTencentAvUiVideoLayerUI.p(n);
      }
    }
    else
    {
      ((TextView)localObject2).setVisibility(8);
      ((ImageView)localObject3).setVisibility(8);
      if (!jdField_a_of_type_Boolean)
      {
        ((TextView)localObject1).setText(this.jdField_c_of_type_JavaLangString);
        localObject2 = a();
        if (((localObject2 != null) && (((AVActivity)localObject2).jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller != null) && (((AVActivity)localObject2).jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.b())) || (this.jdField_a_of_type_ComTencentAvVideoController.c().size() <= 8))
        {
          localObject3 = this.jdField_d_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("refreshSpokesmanInfoUI audio. txt = ");
          localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
          localStringBuilder.append(", isSoftKeyboardShown = ");
          localStringBuilder.append(((AVActivity)localObject2).jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.b());
          localStringBuilder.append(", member cnt = ");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentAvVideoController.c().size());
          QLog.d((String)localObject3, 2, localStringBuilder.toString());
          ((TextView)localObject1).setVisibility(8);
        }
        else
        {
          localObject2 = this.jdField_d_of_type_JavaLangString;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("refreshSpokesmanInfoUI audio. txt = ");
          ((StringBuilder)localObject3).append(this.jdField_c_of_type_JavaLangString);
          QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
          if (this.jdField_c_of_type_JavaLangString.length() > 0) {
            m = n;
          } else {
            m = 8;
          }
          ((TextView)localObject1).setVisibility(m);
        }
        if (((TextView)localObject1).getVisibility() == 0) {
          this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373523).setVisibility(8);
        }
      }
    }
  }
  
  void w(long paramLong)
  {
    x(paramLong);
    l(paramLong, 2131695335);
  }
  
  void x()
  {
    long l1 = AudioHelper.b();
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = this.jdField_d_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startOrResumeRemoteOrLocalVideo, seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("], mVideoController[");
      boolean bool;
      if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.jdField_d_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_d_of_type_JavaLangString, 2, "startOrResumeRemoteOrLocalVideo, Not in MultiVideoRoom");
      }
      return;
    }
    int n = this.jdField_a_of_type_ComTencentAvVideoController.b();
    int i1 = this.jdField_a_of_type_ComTencentAvVideoController.a().a(this.jdField_c_of_type_Long, 1);
    int m;
    if (i1 != -1) {
      m = 1;
    } else {
      m = 0;
    }
    if (QLog.isColorLevel())
    {
      str = this.jdField_d_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startOrResumeRemoteOrLocalVideo, onStageNum[");
      localStringBuilder.append(n);
      localStringBuilder.append("], index[");
      localStringBuilder.append(i1);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if ((!NetworkUtil.isWifiConnected((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get())) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().ag))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_d_of_type_JavaLangString, 2, "startOrResumeRemoteOrLocalVideo --> is not connect wifi");
      }
      if (m != 0)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().c, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList, 1, false);
        this.jdField_a_of_type_ComTencentAvVideoController.w();
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().c.size() > 0)
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
      N();
      return;
    }
    if (m != 0) {
      if (n < jdField_b_of_type_Int)
      {
        if (d())
        {
          i(l1, 16777215);
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.e(this.jdField_d_of_type_JavaLangString, 2, "startOrResumeRemoteOrLocalVideo, Go on Stage Failed");
          }
          this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().c, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList, 1, false);
          this.jdField_a_of_type_ComTencentAvVideoController.w();
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Long, this.jdField_a_of_type_ComTencentAvVideoController.a().c, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaUtilArrayList, 1, false);
        this.jdField_a_of_type_ComTencentAvVideoController.w();
      }
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().c.size() > 0)
    {
      e();
      return;
    }
    N();
  }
  
  void x(long paramLong)
  {
    QLog.d(this.jdField_d_of_type_JavaLangString, 1, "OnClick_MemberInfo");
    ReportController.b(null, "CliOper", "", "", "0X8009F64", "0X8009F64", 0, 0, "", "", "", "");
    AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    boolean bool;
    if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().S) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().T)) {
      bool = false;
    } else {
      bool = true;
    }
    VideoMsgTools.a(localAVActivity, String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Long), bool, true);
  }
  
  void y()
  {
    H();
    TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036);
    TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1037);
    TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1030);
    this.jdField_a_of_type_ComTencentAvVideoController.a().b(this.jdField_c_of_type_Long, true, true);
    a(true, false, true);
  }
  
  protected void y(long paramLong)
  {
    if (!VideoController.b()) {
      return;
    }
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    localSessionInfo.a(paramLong, true);
    long l1 = Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
    int m = 0;
    while (m < localSessionInfo.c.size())
    {
      VideoViewInfo localVideoViewInfo = (VideoViewInfo)localSessionInfo.c.get(m);
      if ((localVideoViewInfo.jdField_a_of_type_Long == l1) && (localVideoViewInfo.jdField_a_of_type_Int == 2))
      {
        localVideoViewInfo.jdField_b_of_type_Boolean = true;
        localVideoViewInfo.jdField_d_of_type_Boolean = true;
      }
      else
      {
        localVideoViewInfo.jdField_b_of_type_Boolean = false;
        localVideoViewInfo.jdField_d_of_type_Boolean = false;
      }
      m += 1;
    }
    localSessionInfo.a(-1L, "onUserScreenShareOpen", 4);
    a("onUserScreenShareOpen", paramLong);
    b(paramLong, this.jdField_a_of_type_ComTencentAvVideoController.a().c);
  }
  
  protected void z()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().L == 1)
    {
      int m;
      if (this.jdField_a_of_type_ComTencentAvVideoController.g() == 4) {
        m = 3;
      } else {
        m = 4;
      }
      int n = m;
      if (m == 3)
      {
        n = m;
        if (!QAVConfigUtils.b()) {
          n = 4;
        }
      }
      AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localAVActivity != null)
      {
        if (QLog.isDevelopLevel())
        {
          String str = this.jdField_d_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("initScreenLayout Style=");
          localStringBuilder.append(n);
          localStringBuilder.append("|");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentAvVideoController.a().L);
          localStringBuilder.append("|");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentAvVideoController.g());
          QLog.d(str, 4, localStringBuilder.toString());
        }
        localAVActivity.a(n, false);
      }
    }
  }
  
  protected void z(long paramLong)
  {
    if (!VideoController.b()) {
      return;
    }
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    localSessionInfo.a(paramLong, false);
    if (localSessionInfo.c.size() == 0) {
      localSessionInfo.a(-1L, "onUserScreenShareOpen", 3);
    }
    a(paramLong);
    a("onUserScreenShareClose", paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase
 * JD-Core Version:    0.7.0.1
 */