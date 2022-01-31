package com.tencent.av.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.VideoUtils;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.SessionInfo.GuildInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.av.gaudio.BaseGaInvite;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.AvCustomDialog;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import jxn;
import jxo;
import jxp;
import jxq;
import jxr;
import jxs;
import jxt;
import jxu;

public class MultiIncomingCallsActivity
  extends BaseGaInvite
{
  public static boolean e;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new jxn(this);
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new jxt(this);
  SessionInfo jdField_a_of_type_ComTencentAvAppSessionInfo = null;
  VideoObserver jdField_a_of_type_ComTencentAvAppVideoObserver = new jxu(this);
  AvCustomDialog jdField_a_of_type_ComTencentAvUtilsAvCustomDialog = null;
  QAVNotification jdField_a_of_type_ComTencentAvUtilsQAVNotification;
  public boolean a;
  boolean jdField_b_of_type_Boolean = false;
  long[] jdField_b_of_type_ArrayOfLong = null;
  int jdField_c_of_type_Int = 0;
  TextView jdField_c_of_type_AndroidWidgetTextView = null;
  public String c;
  boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int = -1;
  String jdField_d_of_type_JavaLangString = null;
  boolean jdField_d_of_type_Boolean = false;
  public String e;
  String f;
  
  public MultiIncomingCallsActivity()
  {
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_e_of_type_JavaLangString = "";
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "sendIsResumeBroadcast isResume = " + paramBoolean);
    }
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), paramBoolean);
  }
  
  void a(int paramInt1, long paramLong, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "ignoreMultiCall refuse3rd = " + paramBoolean2);
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "ignoreMultiCall mVideoController is null");
    }
    for (;;)
    {
      return;
      if (!paramBoolean2) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramInt1, paramLong, 10, false);
      }
      while ((paramBoolean1) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(paramLong), Integer.valueOf(3) });
        return;
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramInt1, paramLong, paramInt2, false);
      }
    }
  }
  
  public void a(Intent paramIntent)
  {
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
    if (b()) {
      if (paramIntent.getIntExtra("MultiAVType", -1) == 2)
      {
        this.jdField_b_of_type_Boolean = false;
        this.jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("inviteId");
        str = SessionMgr.a(this.jdField_b_of_type_Int, String.valueOf(this.jdField_a_of_type_Long), new int[0]);
        this.jdField_b_of_type_ArrayOfLong = paramIntent.getLongArrayExtra("memberList");
        int i = a(this.jdField_b_of_type_Int);
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i, String.valueOf(this.jdField_b_of_type_Long), String.valueOf(this.jdField_a_of_type_Long));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppSessionInfo = SessionMgr.a().a(str);
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo != null) {
        break label306;
      }
      b("processIntent_fail");
      return;
      this.jdField_b_of_type_Boolean = true;
      break;
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, true, true);
    }
    label306:
    b(paramIntent);
  }
  
  void a(TextView paramTextView)
  {
    if (paramTextView == null) {
      return;
    }
    float f1 = super.getResources().getDimensionPixelSize(2131559974);
    String str2;
    int i;
    if (b())
    {
      str2 = String.valueOf(this.jdField_a_of_type_Long);
      str1 = super.getApplicationContext().getString(2131428963);
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
          break label181;
        }
        f1 = super.getResources().getDimensionPixelSize(2131559976);
        label100:
        str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(this.jdField_a_of_type_Int, str2, null);
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
      label181:
      if (i <= 99) {
        break label100;
      }
      f1 = super.getResources().getDimensionPixelSize(2131559975);
      break label100;
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
      localIntent.putExtra("groupId", paramSessionInfo.jdField_f_of_type_Long);
      localIntent.putExtra("peerUin", paramSessionInfo.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void a(String paramString, Intent paramIntent, SessionInfo paramSessionInfo)
  {
    SessionInfo localSessionInfo = SessionMgr.a().a();
    String str = this.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("acceptRequest, from[").append(paramString).append("], HandleSessionInfo[").append(paramSessionInfo).append("], CurMainSession[").append(localSessionInfo).append("], mSessionInfo[").append(this.jdField_a_of_type_ComTencentAvAppSessionInfo).append("], SameSession[");
    boolean bool;
    if (paramSessionInfo == localSessionInfo)
    {
      bool = true;
      QLog.w(str, 1, bool + "], mAnyChatCloseByFriend[" + this.jdField_a_of_type_ComTencentAvVideoController.f + "], getAliveSessionCount[" + SessionMgr.a().a() + "]");
      this.jdField_d_of_type_Boolean = true;
      if (!this.jdField_a_of_type_ComTencentAvVideoController.f) {
        break label238;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.h(true);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo != null) && (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.d()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "Session already destroyed, id:" + this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString + ", status = " + this.jdField_a_of_type_ComTencentAvAppSessionInfo.g);
        }
        return;
        bool = false;
        break;
        label238:
        if ((paramSessionInfo != null) && (localSessionInfo == paramSessionInfo) && (SessionMgr.a().a() >= 2))
        {
          if (paramSessionInfo.d()) {
            a(paramString, false, paramSessionInfo, -1);
          }
          for (;;)
          {
            a(paramSessionInfo);
            break;
            this.jdField_a_of_type_ComTencentAvVideoController.a(true, 7, new int[] { localSessionInfo.D });
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
    c(paramIntent);
  }
  
  public void a(String paramString, boolean paramBoolean, SessionInfo paramSessionInfo, int paramInt)
  {
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "ignoreRequest[" + paramString + "], refuse3rd[" + paramBoolean + "], mainSessionInfo[" + paramSessionInfo + "], iFlag[" + paramInt + "]");
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
        String str = paramSessionInfo.jdField_c_of_type_JavaLangString;
        paramString = str;
        if (TextUtils.isEmpty(str)) {
          paramString = paramSessionInfo.r;
        }
        bool1 = paramSessionInfo.G;
        i = paramSessionInfo.F;
        l = paramSessionInfo.jdField_f_of_type_Long;
      }
    }
    for (;;)
    {
      UITools.b(i);
      if ((!paramBoolean) && ((bool1) || (b()))) {}
      for (boolean bool2 = true; b(); bool2 = false)
      {
        a(i, l, bool2, paramInt, paramBoolean);
        return;
      }
      a(bool1, paramString, bool2, paramBoolean);
      return;
    }
  }
  
  void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "refuseDoubleCall mVideoController is null");
      return;
    }
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, new Object[] { "refuseDoubleCall", Boolean.valueOf(paramBoolean1), paramString, Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3) });
    long l2;
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramString, 1, true);
      l2 = -1L;
    }
    for (;;)
    {
      try
      {
        l1 = CharacterUtil.a(paramString);
        if (!paramBoolean3)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a(3, l1, 10, false);
          this.jdField_a_of_type_ComTencentAvVideoController.a(l1, 23);
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
        this.jdField_a_of_type_ComTencentAvVideoController.b(3, l1);
        this.jdField_a_of_type_ComTencentAvVideoController.a(l1, 1);
        continue;
      }
      VideoController localVideoController = this.jdField_a_of_type_ComTencentAvVideoController;
      localVideoController.a(paramString, 1, false, new jxs(this, localVideoController, paramString, paramBoolean3));
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null) {
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString);
    }
    c(2);
    a("onInviteTimeOut", true, SessionMgr.a().a(), 8);
    b("onInviteTimeOut");
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    Long localLong;
    do
    {
      return;
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "closeSession reason = " + paramInt);
      localLong = Long.valueOf(CharacterUtil.a(this.jdField_c_of_type_JavaLangString));
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(localLong.longValue(), 7);
        return;
      }
    } while (paramInt != 2);
    this.jdField_a_of_type_ComTencentAvVideoController.a(localLong.longValue(), 2);
    return;
    this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString, 0);
    this.jdField_a_of_type_ComTencentAvVideoController.b(241);
  }
  
  void b(Intent paramIntent)
  {
    e();
    this.jdField_a_of_type_ComTencentAvUtilsAvCustomDialog = new AvCustomDialog(this);
    Object localObject = LayoutInflater.from(this).inflate(2130969276, null);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131365932));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131365933));
    this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131365934));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131365935));
    if (VideoUtils.a())
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131429609);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131493576));
    }
    c();
    Button localButton;
    if (b())
    {
      a("showDialog");
      this.jdField_a_of_type_ComTencentAvUtilsAvCustomDialog.a((View)localObject, false);
      localButton = (Button)((View)localObject).findViewById(2131365937);
      localButton.setOnClickListener(new jxo(this));
      this.jdField_a_of_type_ComTencentAvUtilsAvCustomDialog.setOnCancelListener(new jxp(this));
      this.jdField_a_of_type_ComTencentAvUtilsAvCustomDialog.setOnDismissListener(new jxq(this));
      SessionInfo localSessionInfo = SessionMgr.a().a();
      localObject = (Button)((View)localObject).findViewById(2131365938);
      ((Button)localObject).setOnClickListener(new jxr(this, paramIntent, localSessionInfo));
      if (!b()) {
        break label469;
      }
      ((Button)localObject).setText(2131429449);
      localButton.setText(2131429448);
    }
    for (;;)
    {
      if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
        ((Button)localObject).setCompoundDrawablesWithIntrinsicBounds(super.getResources().getDrawable(2130840292), null, null, null);
      }
      this.jdField_a_of_type_ComTencentAvUtilsAvCustomDialog.show();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, String.format("begin show dialog, mPeerUin[%s], mExtraUin[%s], mIsDoubleVideoMeeting[%s], mUinType[%s], mRelationType[%s], mMemberType[%s], mHasGVideoJoined[%s], mIsAudioMode[%s], mBindType[%s]", new Object[] { this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, Boolean.valueOf(this.jdField_a_of_type_Boolean), Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_d_of_type_Int), Boolean.valueOf(this.jdField_c_of_type_Boolean), Boolean.valueOf(this.jdField_b_of_type_Boolean), Integer.valueOf(this.jdField_c_of_type_Int) }));
      }
      TraeHelper.a().a("MultiIncomingCallsActivity.showDialog", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230736, null, 0, null);
      return;
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      a(this.jdField_b_of_type_AndroidWidgetTextView);
      break;
      label469:
      ((Button)localObject).setText(2131429449);
      localButton.setText(2131429447);
    }
  }
  
  public void b(String paramString)
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
      float f1 = super.getResources().getDimensionPixelSize(2131559977);
      localObject1 = "";
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        localObject1 = UITools.a(super.getApplicationContext(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidWidgetTextView, f1);
      }
      Object localObject2 = super.getResources();
      if (this.jdField_b_of_type_Boolean) {}
      for (i = 2131429455;; i = 2131429456)
      {
        localObject2 = ((Resources)localObject2).getString(i);
        this.jdField_a_of_type_AndroidWidgetTextView.setText((String)localObject1 + (String)localObject2);
        return;
      }
    }
    if (VideoUtils.a(this.jdField_a_of_type_Int, this.jdField_c_of_type_Int))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131429454);
      return;
    }
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) {}
    for (int i = 2131429452;; i = 2131429453)
    {
      ((TextView)localObject1).setText(i);
      return;
    }
  }
  
  public void c(int paramInt)
  {
    label254:
    label1406:
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
        i = localSessionInfo.g;
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
        if ((localSessionInfo.i != 21) && ((localSessionInfo.i != 1011) || (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info == null) || (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int <= 0) || (localSessionInfo.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int != 1))) {
          break label254;
        }
        if (paramInt == 0)
        {
          localObject4 = "0X8005BB9";
          localObject1 = localObject4;
          if (!QLog.isColorLevel()) {
            break label1406;
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
              break label1406;
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
              break label1406;
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
        if (localSessionInfo.G)
        {
          if (paramInt == 0) {
            localObject4 = "0X8005BAA";
          }
          for (;;)
          {
            localObject3 = localObject4;
            if (!QLog.isColorLevel()) {
              break label1406;
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
              break label1406;
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
              break label1406;
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
              break label1406;
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
              break label1406;
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
        if ((localSessionInfo.jdField_d_of_type_Int == 2) || ((localSessionInfo.jdField_f_of_type_Int == 2) && ((i == 1) || (i == 2))))
        {
          if (paramInt == 0) {
            localObject4 = "0X8005BA7";
          }
          for (;;)
          {
            localObject3 = localObject4;
            if (!QLog.isColorLevel()) {
              break label1406;
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
        if ((localSessionInfo.jdField_d_of_type_Int == 1) || ((localSessionInfo.jdField_f_of_type_Int == 1) && ((i == 1) || (i == 2))))
        {
          if (paramInt == 0) {
            localObject4 = "0X8005BA4";
          }
          for (;;)
          {
            localObject3 = localObject4;
            if (!QLog.isColorLevel()) {
              break label1406;
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
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "nothing, action:" + paramInt + ", reportType:" + null + "SessionType:" + localSessionInfo.jdField_d_of_type_Int + ", BeginSessionType:" + localSessionInfo.jdField_f_of_type_Int + ", sessionStatus:" + j + ", state:" + i);
        }
        Object localObject3 = null;
      }
    }
  }
  
  void c(Intent paramIntent)
  {
    Object localObject2 = null;
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "startVideoChatActivity");
    TraeHelper.a().a();
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.q)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(113) });
    }
    Intent localIntent = new Intent(super.getApplicationContext(), AVActivity.class);
    localIntent.addFlags(262144);
    Object localObject1;
    int i;
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentAvAppSessionInfo.n;
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
        super.overridePendingTransition(2131034270, 2131034269);
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
          label427:
          QLog.d((String)localObject2, 2, paramIntent);
        }
      }
      else
      {
        if (j == 0) {
          localIntent.putExtra("isFriend", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_c_of_type_JavaLangString));
        }
        if (!bool) {
          break label508;
        }
        localIntent.putExtra("sessionType", 1);
      }
      for (;;)
      {
        localIntent.putExtra("isSender", false);
        break;
        paramIntent = Integer.valueOf(this.jdField_a_of_type_ComTencentAvAppSessionInfo.A);
        break label427;
        label508:
        localIntent.putExtra("sessionType", 2);
      }
      i = -1;
      localObject1 = null;
    }
  }
  
  void d()
  {
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "startGActivity");
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.p) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(40), this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString, Boolean.valueOf(true) });
    }
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
  
  void e()
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsAvCustomDialog != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvUtilsAvCustomDialog.dismiss();
      label14:
      this.jdField_a_of_type_ComTencentAvUtilsAvCustomDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label14;
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
        String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(a(this.jdField_b_of_type_Int), Long.toString(this.jdField_b_of_type_Long), (String)localObject);
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString, str, localBitmap, (String)localObject, 57, this.jdField_a_of_type_Int, 3);
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, true, true);
    if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, (Bitmap)localObject, null, 56, this.jdField_a_of_type_Int, 2);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, (Bitmap)localObject, null, 55, this.jdField_a_of_type_Int, 1);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onCreate");
    super.onCreate(paramBundle);
    super.getWindow().setBackgroundDrawableResource(2130846525);
    super.getWindow().addFlags(128);
    VideoNodeManager.a(this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_JavaLangString), 29);
    TraeHelper.a().a("MultiIncomingCallsActivity.onCreate");
    a(super.getIntent());
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      if (!b()) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    }
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.av.EXIT_QZONE_LIVE_RSP_ACTION");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    if (b()) {}
    for (int i = 30000;; i = 60000)
    {
      a(i);
      return;
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
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null)
    {
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo != null) {
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.b(this.f);
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(707) });
    }
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((!this.jdField_d_of_type_Boolean) && (paramInt == 4))
    {
      c(2);
      a("onKeyDown", true, null, -1);
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
  }
  
  protected void onPause()
  {
    super.onPause();
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onPause");
    a(false);
  }
  
  protected void onResume()
  {
    super.onResume();
    jdField_e_of_type_Boolean = true;
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onResume");
    a(true);
    c(0);
  }
  
  protected void onStart()
  {
    super.onStart();
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onStart");
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification == null) {
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      }
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString);
    } while ((SessionMgr.a().a() == null) || (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString.equals(SessionMgr.a().a().jdField_b_of_type_JavaLangString)));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(false, null);
    this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(SessionMgr.a().a().jdField_b_of_type_JavaLangString);
    this.f = SessionMgr.a().a().jdField_b_of_type_JavaLangString;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallsActivity
 * JD-Core Version:    0.7.0.1
 */