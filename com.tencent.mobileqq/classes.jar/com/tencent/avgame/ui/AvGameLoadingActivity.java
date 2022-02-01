package com.tencent.avgame.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.avgame.business.handler.AvGameRoomListHandler;
import com.tencent.avgame.business.observer.AvGameRoomListObserver;
import com.tencent.avgame.config.AvGameConfigUtil;
import com.tencent.avgame.config.data.AvGameConfBean;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadManager;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadManager.ResInfo;
import com.tencent.avgame.gamelogic.gameres.AvGameResPreloadManager;
import com.tencent.avgame.gamelogic.gameres.IAvGameResPreloadManager.ConfInfo;
import com.tencent.avgame.gameroom.AVGameLottieHelper;
import com.tencent.avgame.ipc.AVGameUtilService;
import com.tencent.avgame.report.AVGameNodeReportUtil;
import com.tencent.avgame.report.AVGamePerfReporter;
import com.tencent.avgame.report.exception.AVGameExceptionReporter;
import com.tencent.avgame.util.AvGameEntranceUtil;
import com.tencent.avgame.widget.AutoBgImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class AvGameLoadingActivity
  extends QPublicBaseFragment
  implements Handler.Callback
{
  private String A = null;
  private byte[] B = null;
  private RoomInfo C = null;
  private CasualTips D;
  private ArrayList<String> E = new ArrayList();
  private boolean F = true;
  private boolean G = false;
  private int H = 3000;
  private volatile boolean I = false;
  private boolean J = false;
  private int K = -1;
  private byte[] L;
  private volatile boolean M = false;
  private AVGameBackAction N = null;
  private AvGameRoomListObserver O = new AvGameLoadingActivity.2(this);
  String a = null;
  Handler b = new Handler(Looper.getMainLooper(), this);
  AvGameResDownloadManager c;
  BroadcastReceiver d = new AvGameLoadingActivity.1(this);
  int e = 0;
  int f = 2;
  private AutoBgImageView g;
  private TextView h;
  private ImageView i;
  private boolean j = false;
  private LottieDrawable k;
  private QBaseActivity l;
  private long m;
  private boolean n = true;
  private int o = 0;
  private int p = 0;
  private boolean q = true;
  private String r = "";
  private String s = "0";
  private int t = 1;
  private Bundle u;
  private boolean v;
  private boolean w;
  private int x;
  private ViewGroup y;
  private String z = null;
  
  private void a(int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.arg1 = paramInt;
    this.b.sendMessage(localMessage);
  }
  
  private void a(int paramInt, String paramString)
  {
    Object localObject = this.l;
    if ((localObject != null) && (!((QBaseActivity)localObject).isFinishing()))
    {
      localObject = (AvGameRoomListHandler)((AppInterface)this.l.getAppRuntime()).getBusinessHandler(AvGameRoomListHandler.a);
      if (localObject != null) {
        ((AvGameRoomListHandler)localObject).a(paramInt, paramString, this.m, this.t);
      }
      return;
    }
    QLog.e("AvGameLoadingActivity", 1, "createAvGameRoom activity finish ");
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    Object localObject = this.l;
    if ((localObject != null) && (!((QBaseActivity)localObject).isFinishing()))
    {
      if (TextUtils.isEmpty(paramString1))
      {
        QQToast.makeText(this.l, 2131887412, 0).show();
        QLog.e("AvGameLoadingActivity", 1, "joinAvGameRoom with empty roomId!!");
        AVGameNodeReportUtil.b(-103);
        a(false, 114);
        return;
      }
      localObject = (AvGameRoomListHandler)((AppInterface)this.l.getAppRuntime()).getBusinessHandler(AvGameRoomListHandler.a);
      if (localObject != null) {
        ((AvGameRoomListHandler)localObject).a(paramInt, paramString1, paramString2, this.m);
      }
      return;
    }
    QLog.e("AvGameLoadingActivity", 1, "joinAvGameRoom activity finish");
  }
  
  private void a(long paramLong)
  {
    if (paramLong != 0L)
    {
      localObject = (AvGameRoomListHandler)((AppInterface)this.l.getAppRuntime()).getBusinessHandler(AvGameRoomListHandler.a);
      if (localObject != null) {
        ((AvGameRoomListHandler)localObject).a(paramLong);
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("exitRoom ");
    ((StringBuilder)localObject).append(paramLong);
    QLog.d("AvGameLoadingActivity", 2, ((StringBuilder)localObject).toString());
  }
  
  private void a(AvGameResDownloadManager.ResInfo paramResInfo)
  {
    AVGamePerfReporter.a().a("param_StepResource");
    this.c = new AvGameResDownloadManager((AppInterface)getQBaseActivity().getAppRuntime());
    this.c.a(paramResInfo, new AvGameLoadingActivity.5(this, paramResInfo));
  }
  
  private void a(String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(getActivity(), 230);
    localQQCustomDialog.setTitle(paramString1);
    localQQCustomDialog.setMessage(paramString2);
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.setNegativeButton(paramString3, paramOnClickListener1);
    localQQCustomDialog.setPositiveButton(paramString4, paramOnClickListener2);
    localQQCustomDialog.show();
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("finish, hasEnterGame[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("], action[");
      ((StringBuilder)localObject).append(this.N);
      ((StringBuilder)localObject).append("], retCode[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("]");
      QLog.i("AvGameLoadingActivity", 2, ((StringBuilder)localObject).toString());
    }
    this.b.sendEmptyMessage(3);
    if (!paramBoolean)
    {
      localObject = this.N;
      if (localObject != null)
      {
        ((AVGameBackAction)localObject).a(getActivity());
        if (!"MsgPush".equals(this.N.a)) {
          return;
        }
        ReportController.b(null, "dc00898", "", "", "0X800B247", "0X800B247", paramInt, 0, "", "", "", "");
        return;
      }
    }
    if (paramBoolean)
    {
      localObject = this.N;
      if ((localObject != null) && ("MsgPush".equals(((AVGameBackAction)localObject).a))) {
        ReportController.b(null, "dc00898", "", "", "0X800B246", "0X800B246", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void a(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong1, long paramLong2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleProtoEnterResult  bCreate:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" ret code ");
    localStringBuilder.append(paramInt);
    QLog.d("AvGameLoadingActivity", 2, localStringBuilder.toString());
    AVGamePerfReporter.a().a("param_StepRoomProto", 0);
    long l1 = this.m;
    int i1 = 1;
    if (paramLong1 == l1)
    {
      if ((paramInt == 0) && (paramRoomInfo != null))
      {
        paramLong1 = paramRoomInfo.id;
        paramString = this.l;
        if ((paramString != null) && (!paramString.isFinishing()))
        {
          if ((this.q) && (this.p == 2)) {
            this.a = this.r;
          }
          paramString = new StringBuilder();
          paramString.append(paramLong1);
          paramString.append("");
          this.z = paramString.toString();
          AVGameNodeReportUtil.a(this.z);
          this.A = this.z;
          this.B = paramArrayOfByte;
          this.C = paramRoomInfo;
          g();
          break label359;
        }
        paramString = new StringBuilder();
        paramString.append("handleProtoEnterResult  ENTER WITH null activity bCreate:");
        paramString.append(paramBoolean);
        QLog.e("AvGameLoadingActivity", 2, paramString.toString());
      }
      else
      {
        paramRoomInfo = this.l;
        if ((paramRoomInfo != null) && (!paramRoomInfo.isFinishing()))
        {
          if (this.v)
          {
            n();
            break label359;
          }
          a(this.l.getAppRuntime(), this.l, paramInt, paramBoolean, paramString, paramLong2);
          break label359;
        }
        paramString = new StringBuilder();
        paramString.append("mObserver handleProtoEnterResult alertDialogWithRetCode  WITH null activity  bCreate:");
        paramString.append(paramBoolean);
        QLog.e("AvGameLoadingActivity", 2, paramString.toString());
      }
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append("handleProtoEnterResult get observer not by self bCreate:");
      paramString.append(paramBoolean);
      QLog.i("AvGameLoadingActivity", 2, paramString.toString());
    }
    i1 = 0;
    label359:
    paramString = this.l;
    if ((paramString != null) && (!paramString.isFinishing()))
    {
      int i2;
      if (paramBoolean)
      {
        if (paramInt == 0)
        {
          ReportController.b(this.l.getAppRuntime(), "dc00898", "", "", "0X800B018", "0X800B018", this.p, 0, "", this.z, "", "");
          if (this.p == 4) {
            ReportController.b(this.l.getAppRuntime(), "dc00898", "", "", "0X800B06C", "0X800B06C", this.t, 0, "", this.z, "", "");
          }
        }
        else
        {
          paramString = this.l.getAppRuntime();
          i2 = this.p;
          paramRoomInfo = new StringBuilder();
          paramRoomInfo.append(paramInt);
          paramRoomInfo.append("");
          ReportController.b(paramString, "dc00898", "", "", "0X800B019", "0X800B019", i2, 0, paramRoomInfo.toString(), "", "", "");
        }
      }
      else if (paramInt == 0)
      {
        ReportController.b(this.l.getAppRuntime(), "dc00898", "", "", "0X800B026", "0X800B026", this.p, 0, "", this.z, "", "");
      }
      else
      {
        paramString = this.l.getAppRuntime();
        i2 = this.p;
        paramRoomInfo = new StringBuilder();
        paramRoomInfo.append(paramInt);
        paramRoomInfo.append("");
        ReportController.b(paramString, "dc00898", "", "", "0X800B027", "0X800B027", i2, 0, paramRoomInfo.toString(), "", "", "");
      }
    }
    if (i1 == 0)
    {
      paramString = new StringBuilder();
      paramString.append("handleProtoEnterResult !bHandled bCreate:");
      paramString.append(paramBoolean);
      QLog.e("AvGameLoadingActivity", 2, paramString.toString());
      if (paramBoolean) {
        i1 = -102;
      } else {
        i1 = -103;
      }
      AVGameNodeReportUtil.b(i1);
      a(false, paramInt);
    }
  }
  
  public static void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2, Bundle paramBundle)
  {
    AVGamePerfReporter.a().a("param_StepLoading");
    paramString1 = b(paramBoolean, paramInt1, paramString1, paramString2, paramInt2, paramBundle);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowClosedBroadcast(BaseApplicationImpl.getContext(), 56, 2);
    QPublicFragmentActivity.Launcher.a(paramString1, QPublicFragmentActivity.class, AvGameLoadingActivity.class);
    paramString1 = new StringBuilder();
    paramString1.append(" beCreate");
    paramString1.append(paramBoolean);
    paramString1.append(" fromType");
    paramString1.append(paramInt1);
    paramString1.append(" roomId");
    paramString1.append(paramString2);
    paramString1.append("gt");
    paramString1.append(paramInt2);
    QLog.e("AvGameLoadingActivity", 2, paramString1.toString());
  }
  
  public static void a(boolean paramBoolean1, Activity paramActivity, byte[] paramArrayOfByte, String paramString1, RoomInfo paramRoomInfo, String paramString2, boolean paramBoolean2, boolean paramBoolean3, Bundle paramBundle)
  {
    a(paramBoolean1, paramActivity, paramArrayOfByte, paramString1, paramRoomInfo, paramString2, paramBoolean2, paramBoolean3, paramBundle, 0, true);
  }
  
  public static void a(boolean paramBoolean1, Activity paramActivity, byte[] paramArrayOfByte, String paramString1, RoomInfo paramRoomInfo, String paramString2, boolean paramBoolean2, boolean paramBoolean3, Bundle paramBundle, int paramInt, boolean paramBoolean4)
  {
    if (paramActivity == null)
    {
      QLog.e("AvGameLoadingActivity", 1, "enterAvGameActivity with empty activity");
      return;
    }
    AVGamePerfReporter.a().a("param_StepPrepareGame");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_room_from_type", paramInt);
    localIntent.putExtra("key_room_is_create", paramBoolean4);
    if (paramString1 != null)
    {
      localIntent.putExtra("key_room_id", paramString1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enterAvGameActivity roomId ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("be New:");
      localStringBuilder.append(paramBoolean1);
      QLog.e("AvGameLoadingActivity", 1, localStringBuilder.toString());
    }
    else
    {
      paramString1 = new StringBuilder();
      paramString1.append("enterAvGameActivity roomId empty  be New:");
      paramString1.append(paramBoolean1);
      QLog.e("AvGameLoadingActivity", 1, paramString1.toString());
    }
    if (paramArrayOfByte != null)
    {
      localIntent.putExtra("key_sig", paramArrayOfByte);
      QLog.d("AvGameLoadingActivity", 2, "enterAvGameActivity sig");
    }
    if (paramRoomInfo != null)
    {
      paramArrayOfByte = new Bundle();
      paramArrayOfByte.putSerializable("key_room_info", paramRoomInfo);
      localIntent.putExtra("key_room_bundle", paramArrayOfByte);
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("enterAvGameActivity roomInfo");
      paramArrayOfByte.append(paramRoomInfo.toString());
      QLog.d("AvGameLoadingActivity", 2, paramArrayOfByte.toString());
    }
    localIntent.putExtra("key_room_be_new_enter", paramBoolean1);
    if (paramString2 != null) {
      localIntent.putExtra("key_room_friend_uin", paramString2);
    }
    paramArrayOfByte = AVGameBackAction.a(paramActivity.getIntent());
    if (paramArrayOfByte != null) {
      AVGameBackAction.a(localIntent, paramArrayOfByte);
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("enterAvGameActivity, action[");
      paramString1.append(paramArrayOfByte);
      paramString1.append("], activity[");
      paramString1.append(paramActivity);
      paramString1.append("]");
      QLog.i("AvGameLoadingActivity", 2, paramString1.toString());
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("enterAvGameActivity startActivity    current time:");
    paramArrayOfByte.append(System.currentTimeMillis());
    paramArrayOfByte.append(" bNewEnter: ");
    paramArrayOfByte.append(paramBoolean1);
    paramArrayOfByte.append(" match:");
    paramArrayOfByte.append(paramBoolean2);
    paramArrayOfByte.append(" survival:");
    paramArrayOfByte.append(paramBoolean3);
    QLog.e("AvGameLoadingActivity", 1, paramArrayOfByte.toString());
    localIntent.putExtra("key_start_time", SystemClock.elapsedRealtime());
    localIntent.putExtra("key_start_match", paramBoolean2);
    localIntent.putExtra("key_from_survival", paramBoolean3);
    if (paramBundle != null)
    {
      if (paramBoolean3)
      {
        localIntent.putExtra("key_pk_type", paramBundle.getInt("key_pk_type", 0));
        localIntent.putExtra("key_pk_qqcj", paramBundle.getBoolean("key_pk_qqcj", false));
        localIntent.putExtra("key_pk_qqcj_source_type", paramBundle.getInt("key_pk_qqcj_source_type", 0));
        localIntent.putExtra("key_pk_qqcj_qr_to_uin", paramBundle.getString("key_pk_qqcj_qr_to_uin", "0"));
      }
      localIntent.putExtra("key_match_game_type", paramBundle.getInt("key_game_type", 0));
    }
    AVGameNodeReportUtil.a(localIntent);
    AVGamePerfReporter.a().b(localIntent);
    RouteUtils.a(paramActivity, localIntent, "/business/avgame/avgameactivity");
    paramActivity.overridePendingTransition(2130772196, 2130772196);
  }
  
  public static Intent b(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2, Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.setFlags(268435456);
    localIntent.putExtra("key_bCreate", paramBoolean);
    localIntent.putExtra("key_fromType", paramInt1);
    localIntent.putExtra("key_peerUin", paramString1);
    localIntent.putExtra("key_roomId", paramString2);
    localIntent.putExtra("key_game_type", paramInt2);
    if (paramBundle != null) {
      localIntent.putExtra("key_extra_bundle", paramBundle);
    }
    return localIntent;
  }
  
  private void c()
  {
    IAvGameResPreloadManager.ConfInfo localConfInfo = AvGameResPreloadManager.a();
    StringBuilder localStringBuilder;
    if ((!TextUtils.isEmpty(localConfInfo.a)) && (!TextUtils.isEmpty(localConfInfo.b)))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkResPreloadReady checkResDownloadReady ResInfo:");
        localStringBuilder.append(localConfInfo.a);
        localStringBuilder.append(", ");
        localStringBuilder.append(localConfInfo.b);
        QLog.d("AvGameLoadingActivity", 2, localStringBuilder.toString());
      }
      a(new AvGameResDownloadManager.ResInfo(localConfInfo.a, localConfInfo.b));
      return;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkResPreloadReady manage url or md5 empty:");
      localStringBuilder.append(localConfInfo.a);
      localStringBuilder.append(", ");
      localStringBuilder.append(localConfInfo.b);
      QLog.e("AvGameLoadingActivity", 2, localStringBuilder.toString());
    }
    this.b.sendEmptyMessage(10);
    if (this.G) {
      AVGameExceptionReporter.a().a(1, null, null, null);
    }
  }
  
  private void d()
  {
    AVGamePerfReporter.a().a("param_StepResource");
    this.c = new AvGameResDownloadManager((AppInterface)getQBaseActivity().getAppRuntime());
    this.c.a(new AvGameResDownloadManager.ResInfo(AvGameConfigUtil.a().b(), AvGameConfigUtil.a().c()), new AvGameLoadingActivity.6(this));
  }
  
  private void e()
  {
    Bundle localBundle = this.u;
    if (localBundle != null)
    {
      this.v = localBundle.getBoolean("key_stranger_match", false);
      this.w = this.u.getBoolean("key_stranger_match_v2", false);
      this.x = this.u.getInt("key_stranger_match_v2_from", 0);
      this.G = this.u.getBoolean("key_pk_qqcj", false);
    }
  }
  
  private boolean f()
  {
    return this.o == 10;
  }
  
  private void g()
  {
    AVGamePerfReporter.a().a("param_StepAvAlive");
    if (!AVGameUtilService.a())
    {
      QLog.d("AvGameLoadingActivity", 2, "preStartAvGameActivity  isAVGameAlive false ");
      i();
      return;
    }
    QLog.d("AvGameLoadingActivity", 2, "preStartAvGameActivity  isAVGameAlive true ");
    k();
  }
  
  private void h()
  {
    if (AVGameUtilService.a())
    {
      QLog.d("AvGameLoadingActivity", 2, "checkAvGameProcessReady live ");
      k();
      return;
    }
    QLog.d("AvGameLoadingActivity", 2, "checkAvGameProcessReady not  live send  MSG_CHECK_AV_GAME_PROCESS_READY");
    this.b.sendEmptyMessageDelayed(4, 1000L);
  }
  
  private void i()
  {
    QLog.d("AvGameLoadingActivity", 2, "startWaitProcessReady ");
    this.b.sendEmptyMessageDelayed(4, 1000L);
    this.b.sendEmptyMessageDelayed(5, 15000L);
  }
  
  private void j()
  {
    QLog.d("AvGameLoadingActivity", 2, "stopWaitProcessReady ");
    this.b.removeMessages(4);
    this.b.removeMessages(5);
    this.b.removeMessages(8);
  }
  
  private void k()
  {
    QLog.d("AvGameLoadingActivity", 2, "DoEnterActivity ");
    a(100);
    j();
    b();
    AVGamePerfReporter.a().a("param_StepAvAlive", 0);
    QBaseActivity localQBaseActivity = this.l;
    byte[] arrayOfByte = this.B;
    String str1 = this.z;
    RoomInfo localRoomInfo = this.C;
    String str2 = this.a;
    int i1 = this.o;
    boolean bool;
    if ((i1 != 9) && (i1 != 11) && (i1 != 13)) {
      bool = false;
    } else {
      bool = true;
    }
    a(true, localQBaseActivity, arrayOfByte, str1, localRoomInfo, str2, bool, f(), this.u, this.o, this.n);
    this.A = null;
    this.b.sendEmptyMessageDelayed(7, this.H);
  }
  
  private void l()
  {
    AVGamePerfReporter.a().a("param_StepResource", 0);
    int i1 = this.e;
    int i2 = this.f;
    if (i1 <= 100 / i2) {
      this.e = (100 / i2 + (int)System.currentTimeMillis() % 5);
    }
    a(this.e);
    ThreadManager.getUIHandlerV2().postDelayed(new AvGameLoadingActivity.9(this), 150L);
  }
  
  private void m()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stopStrangerMatch ");
      localStringBuilder.append(this.K);
      localStringBuilder.append(" ");
      localStringBuilder.append(this.L);
      QLog.i("AvGameLoadingActivity", 2, localStringBuilder.toString());
    }
    if ((this.v) && (this.K != -1))
    {
      ((AvGameRoomListHandler)((AppInterface)this.l.getAppRuntime()).getBusinessHandler(AvGameRoomListHandler.a)).a(this.l.getAppRuntime().getLongAccountUin(), 0, 0, this.K);
      this.K = -1;
    }
    if ((this.w) && (this.L != null))
    {
      ((AvGameRoomListHandler)((AppInterface)this.l.getAppRuntime()).getBusinessHandler(AvGameRoomListHandler.a)).a(this.l.getAppRuntime().getLongAccountUin(), this.t, this.L, 0);
      this.L = null;
    }
  }
  
  private void n()
  {
    boolean bool = QLog.isColorLevel();
    int i1 = 2;
    if (bool) {
      QLog.i("AvGameLoadingActivity", 2, "startStrangerMatch ");
    }
    AvGameRoomListHandler localAvGameRoomListHandler = (AvGameRoomListHandler)((AppInterface)this.l.getAppRuntime()).getBusinessHandler(AvGameRoomListHandler.a);
    if (localAvGameRoomListHandler != null)
    {
      Card localCard = ((IProfileDataService)this.l.getAppRuntime().getRuntimeService(IProfileDataService.class, "all")).getProfileCardFromCache(this.l.getAppRuntime().getCurrentUin());
      if (localCard != null)
      {
        if (localCard.shGender == 0) {
          i1 = 1;
        } else if (localCard.shGender == 1) {}
      }
      else {
        i1 = 0;
      }
      localAvGameRoomListHandler.a(this.l.getAppRuntime().getLongAccountUin(), 0, i1);
      a(true);
      this.I = false;
      this.b.removeMessages(9);
      this.b.sendEmptyMessageDelayed(9, 10000L);
    }
  }
  
  private void o()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startStrangerMatchV2 ");
      ((StringBuilder)localObject).append(this.t);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(this.x);
      QLog.i("AvGameLoadingActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (AvGameRoomListHandler)((AppInterface)this.l.getAppRuntime()).getBusinessHandler(AvGameRoomListHandler.a);
    if (localObject != null) {
      ((AvGameRoomListHandler)localObject).b(this.l.getAppRuntime().getLongAccountUin(), this.t, this.x);
    }
  }
  
  private void p()
  {
    this.E.add(this.l.getBaseContext().getString(2131887277));
    this.E.add(this.l.getBaseContext().getString(2131887279));
    this.E.add(this.l.getBaseContext().getString(2131887280));
    this.E.add(this.l.getBaseContext().getString(2131887281));
    this.E.add(this.l.getBaseContext().getString(2131887282));
    this.E.add(this.l.getBaseContext().getString(2131887283));
    this.E.add(this.l.getBaseContext().getString(2131887284));
    this.E.add(this.l.getBaseContext().getString(2131887285));
    this.E.add(this.l.getBaseContext().getString(2131887286));
    this.E.add(this.l.getBaseContext().getString(2131887278));
  }
  
  public void a()
  {
    m();
    if (getActivity() != null)
    {
      QLog.d("AvGameLoadingActivity", 2, "finish start");
      AVGamePerfReporter.a().a(2);
      getQBaseActivity().superFinish();
      getActivity().overridePendingTransition(2130772196, 2130772196);
      QLog.d("AvGameLoadingActivity", 2, "finish end");
      return;
    }
    QLog.e("AvGameLoadingActivity", 1, "finishFragment with null fragment");
  }
  
  public void a(AppRuntime paramAppRuntime, Activity paramActivity, int paramInt, boolean paramBoolean, String paramString, long paramLong)
  {
    if ((paramAppRuntime != null) && (paramActivity != null) && (!paramActivity.isFinishing()))
    {
      String str = null;
      QQCustomDialog localQQCustomDialog = DialogUtil.a(paramActivity, 230);
      Object localObject;
      if (paramBoolean)
      {
        paramActivity = AvGameEntranceUtil.a(paramBoolean, paramActivity, paramInt, paramLong, paramString);
      }
      else
      {
        localObject = AvGameEntranceUtil.a(paramBoolean, paramActivity, paramInt, paramLong, paramString);
        str = AvGameEntranceUtil.a(paramActivity, paramInt);
        paramActivity = (Activity)localObject;
      }
      AVGameNodeReportUtil.a(paramInt);
      if (localQQCustomDialog != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("alertDialogWithRetCode  ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("AvGameLoadingActivity", 2, ((StringBuilder)localObject).toString());
        paramAppRuntime = new AvGameLoadingActivity.8(this, paramAppRuntime, paramBoolean, paramInt);
        if ((!paramBoolean) && ((paramInt == 104) || (paramInt == 105) || (paramInt == 106) || (paramInt == 114)))
        {
          localQQCustomDialog.setPositiveButton(2131887403, paramAppRuntime);
          localQQCustomDialog.setNegativeButton(2131887648, paramAppRuntime);
        }
        else
        {
          localQQCustomDialog.setNegativeButton(2131887410, paramAppRuntime);
        }
        localQQCustomDialog.setCancelable(false);
        localQQCustomDialog.setMessage(paramActivity);
        if (str != null) {
          localQQCustomDialog.setTitle(str);
        }
        localQQCustomDialog.show();
        return;
      }
      QLog.e("AvGameLoadingActivity", 2, "alertDialogWithRetCode null");
      int i1;
      if (paramBoolean) {
        i1 = -102;
      } else {
        i1 = -103;
      }
      AVGameNodeReportUtil.b(i1);
      a(false, paramInt);
      return;
    }
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("alertDialogWithRetCode  null ac ");
    paramAppRuntime.append(paramInt);
    paramAppRuntime.append(" ");
    paramAppRuntime.append(paramString);
    QLog.e("AvGameLoadingActivity", 1, paramAppRuntime.toString());
  }
  
  void a(boolean paramBoolean)
  {
    this.F = true;
    Object localObject = this.l;
    if ((localObject != null) && (!((QBaseActivity)localObject).isFinishing()))
    {
      if (paramBoolean)
      {
        this.g.setVisibility(0);
        return;
      }
      this.g.setVisibility(8);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("enableExit isFinishing");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.e("AvGameLoadingActivity", 2, ((StringBuilder)localObject).toString());
  }
  
  void b()
  {
    this.F = false;
    QBaseActivity localQBaseActivity = this.l;
    if ((localQBaseActivity != null) && (!localQBaseActivity.isFinishing()))
    {
      this.g.setVisibility(8);
      return;
    }
    QLog.e("AvGameLoadingActivity", 2, "unEnableExit isFinishing");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 10: 
      if (getActivity() != null)
      {
        AVGameNodeReportUtil.b(-101);
        getActivity().finish();
        return false;
      }
      break;
    case 9: 
      QLog.d("AvGameLoadingActivity", 2, "stranger match timeout");
      this.I = false;
      this.J = true;
      if (isAdded())
      {
        a(null, getString(2131887306), getString(2131887410), new AvGameLoadingActivity.7(this), null, null);
        return false;
      }
      break;
    case 8: 
      a(true);
      return false;
    case 7: 
      a(false);
      return false;
    case 6: 
      if ((isAdded()) && ((paramMessage.obj instanceof LottieDrawable)))
      {
        this.k = ((LottieDrawable)paramMessage.obj);
        this.i.setImageDrawable(this.k);
        this.k.pauseAnimation();
        this.k.playAnimation();
        return false;
      }
      break;
    case 5: 
      k();
      return false;
    case 4: 
      if (isAdded())
      {
        long l1 = System.currentTimeMillis();
        int i1 = this.e;
        int i2 = (int)(l1 % 5L);
        if (i1 + i2 < 100)
        {
          this.e = (i1 + i2);
          this.h.setText(getString(2131887234, new Object[] { Integer.valueOf(this.e) }));
        }
      }
      h();
      return false;
    case 3: 
      a();
      return false;
    case 2: 
      if (isAdded())
      {
        this.h.setText(getString(2131887234, new Object[] { Integer.valueOf(paramMessage.arg1) }));
        return false;
      }
      break;
    case 1: 
      QQToast.makeText(BaseApplicationImpl.getApplication(), 0, BaseApplicationImpl.getApplication().getString(2131887351), 0).show();
      if (getActivity() != null)
      {
        AVGameNodeReportUtil.b(-101);
        getActivity().finish();
      }
      break;
    }
    return false;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.setTheme(2131952719);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public boolean onBackEvent()
  {
    if (this.F)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mExitBtn ");
      ((StringBuilder)localObject).append(this.z);
      QLog.d("AvGameLoadingActivity", 2, ((StringBuilder)localObject).toString());
      ReportController.b(null, "dc00898", "", "", "0X800B042", "0X800B042", 0, 0, "", "", "", "");
      localObject = this.z;
      if (localObject != null) {
        a(AvGameEntranceUtil.a((String)localObject));
      }
      AVGameNodeReportUtil.b(1);
      a(false, 0);
      return super.onBackEvent();
    }
    QLog.d("AvGameLoadingActivity", 2, "bExitEnable not ");
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.l = getQBaseActivity();
    QLog.i("AvGameLoadingActivity", 4, "-----onCreate-----");
    AVGamePerfReporter.a().a("param_StepEntrance", 0);
    if (ImmersiveUtils.couldSetStatusTextColor()) {
      ImmersiveUtils.setStatusTextColor(false, getActivity().getWindow());
    }
    paramBundle = this.l.getIntent();
    if (paramBundle == null)
    {
      a(false, 501);
      QLog.e("AvGameLoadingActivity", 2, " intent null");
      return;
    }
    this.n = paramBundle.getBooleanExtra("key_bCreate", true);
    this.q = this.n;
    this.o = paramBundle.getIntExtra("key_fromType", 0);
    this.p = this.o;
    this.r = paramBundle.getStringExtra("key_peerUin");
    this.s = paramBundle.getStringExtra("key_roomId");
    this.t = paramBundle.getIntExtra("key_game_type", 1);
    this.u = paramBundle.getBundleExtra("key_extra_bundle");
    e();
    this.N = AVGameBackAction.a(paramBundle);
    paramBundle = this.N;
    if ((paramBundle != null) && ("MsgPush".equals(paramBundle.a))) {
      ReportController.b(null, "dc00898", "", "", "0X800B245", "0X800B245", 0, 0, "", "", "", "");
    }
    paramBundle = (AppInterface)this.l.getAppRuntime();
    if (paramBundle != null) {
      paramBundle.addObserver(this.O);
    }
    this.m = System.currentTimeMillis();
    getActivity().sendBroadcast(new Intent("tencent.avgame.notify.voice.record.off"), "com.tencent.msg.permission.pushnotify");
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.avgame.ui.AvGameLoadingActivity.ACTION_LOADING_FINISH");
    this.l.registerReceiver(this.d, paramBundle);
    AVGameUtilService.a(this.l.getAppRuntime(), true);
    AVGameNodeReportUtil.a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.y = ((ViewGroup)paramLayoutInflater.inflate(2131624269, null));
    this.h = ((TextView)this.y.findViewById(2131448398));
    this.g = ((AutoBgImageView)this.y.findViewById(2131429054));
    this.i = ((ImageView)this.y.findViewById(2131436445));
    this.D = ((CasualTips)this.y.findViewById(2131447433));
    if (this.D != null)
    {
      p();
      this.D.setTipsString(this.E);
    }
    this.h.setText(getString(2131887234, new Object[] { Integer.valueOf(0) }));
    this.g.setOnClickListener(new AvGameLoadingActivity.3(this));
    int i1 = AvGameConfigUtil.a().g();
    if (i1 == 0)
    {
      a(true);
    }
    else
    {
      b();
      this.b.sendEmptyMessageDelayed(8, i1 * 1000);
    }
    AVGameLottieHelper.a(getActivity(), "avgame_loading/data.json", "avgame_loading/images/", 27, 9, -1, new AvGameLoadingActivity.4(this));
    paramLayoutInflater = this.y;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    QLog.i("AvGameLoadingActivity", 4, "-----onDestroy-----");
    Object localObject = this.l;
    if (localObject != null) {
      ((AppInterface)((QBaseActivity)localObject).getAppRuntime()).removeObserver(this.O);
    }
    localObject = this.l;
    if (localObject != null)
    {
      BroadcastReceiver localBroadcastReceiver = this.d;
      if (localBroadcastReceiver != null)
      {
        ((QBaseActivity)localObject).unregisterReceiver(localBroadcastReceiver);
        this.d = null;
      }
    }
    localObject = this.b;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.D;
    if (localObject != null) {
      ((CasualTips)localObject).a();
    }
    localObject = this.k;
    if ((localObject != null) && (((LottieDrawable)localObject).isAnimating())) {
      this.k.endAnimation();
    }
    localObject = this.c;
    if (localObject != null) {
      ((AvGameResDownloadManager)localObject).b();
    }
    super.onDestroy();
  }
  
  public void onFinish()
  {
    super.onFinish();
    getActivity().overridePendingTransition(2130772196, 2130772196);
  }
  
  public void onPause()
  {
    QLog.i("AvGameLoadingActivity", 4, "-----onPause-----");
    super.onPause();
  }
  
  public void onResume()
  {
    QLog.i("AvGameLoadingActivity", 4, "-----onResume-----");
    super.onResume();
  }
  
  public void onStart()
  {
    QLog.i("AvGameLoadingActivity", 4, "-----onStart-----");
    super.onStart();
  }
  
  public void onStop()
  {
    QLog.i("AvGameLoadingActivity", 4, "-----onStop-----");
    super.onStop();
    getActivity().overridePendingTransition(2130772196, 2130772196);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    AVGamePerfReporter.a().a("param_StepSecure");
    AVGamePerfReporter.a().a("param_StepSecure", 0);
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("onViewCreated mFromCJSurvivalScene:");
      paramView.append(this.G);
      QLog.d("AvGameLoadingActivity", 2, paramView.toString());
    }
    if (this.G) {
      c();
    } else {
      d();
    }
    if ((DeviceInfoUtils.isLowPerfDevice()) && (DeviceInfoUtils.isLowPerfDevice())) {
      this.H = 8000;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AvGameLoadingActivity
 * JD-Core Version:    0.7.0.1
 */