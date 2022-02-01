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
  int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new AvGameLoadingActivity.1(this);
  private Bundle jdField_a_of_type_AndroidOsBundle;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AvGameRoomListObserver jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver = new AvGameLoadingActivity.2(this);
  private RoomInfo jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo = null;
  AvGameResDownloadManager jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResDownloadManager;
  private AVGameBackAction jdField_a_of_type_ComTencentAvgameUiAVGameBackAction = null;
  private CasualTips jdField_a_of_type_ComTencentAvgameUiCasualTips;
  private AutoBgImageView jdField_a_of_type_ComTencentAvgameWidgetAutoBgImageView;
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  String jdField_a_of_type_JavaLangString = null;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  int jdField_b_of_type_Int = 2;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean = true;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private int jdField_c_of_type_Int = 0;
  private String jdField_c_of_type_JavaLangString = "0";
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int = 0;
  private String jdField_d_of_type_JavaLangString = null;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 1;
  private String jdField_e_of_type_JavaLangString = null;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean = true;
  private int jdField_g_of_type_Int = 3000;
  private boolean jdField_g_of_type_Boolean = false;
  private int jdField_h_of_type_Int = -1;
  private volatile boolean jdField_h_of_type_Boolean = false;
  private boolean i = false;
  private volatile boolean j = false;
  
  public static Intent a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2, Bundle paramBundle)
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
  
  private void a(int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.arg1 = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void a(int paramInt, String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
    if ((localObject != null) && (!((QBaseActivity)localObject).isFinishing()))
    {
      localObject = (AvGameRoomListHandler)((AppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime()).getBusinessHandler(AvGameRoomListHandler.jdField_a_of_type_JavaLangString);
      if (localObject != null) {
        ((AvGameRoomListHandler)localObject).a(paramInt, paramString, this.jdField_a_of_type_Long, this.jdField_e_of_type_Int);
      }
      return;
    }
    QLog.e("AvGameLoadingActivity", 1, "createAvGameRoom activity finish ");
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
    if ((localObject != null) && (!((QBaseActivity)localObject).isFinishing()))
    {
      if (TextUtils.isEmpty(paramString1))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131690501, 0).a();
        QLog.e("AvGameLoadingActivity", 1, "joinAvGameRoom with empty roomId!!");
        AVGameNodeReportUtil.b(-103);
        a(false, 114);
        return;
      }
      localObject = (AvGameRoomListHandler)((AppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime()).getBusinessHandler(AvGameRoomListHandler.jdField_a_of_type_JavaLangString);
      if (localObject != null) {
        ((AvGameRoomListHandler)localObject).a(paramInt, paramString1, paramString2, this.jdField_a_of_type_Long);
      }
      return;
    }
    QLog.e("AvGameLoadingActivity", 1, "joinAvGameRoom activity finish");
  }
  
  private void a(long paramLong)
  {
    if (paramLong != 0L)
    {
      localObject = (AvGameRoomListHandler)((AppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime()).getBusinessHandler(AvGameRoomListHandler.jdField_a_of_type_JavaLangString);
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
    this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResDownloadManager = new AvGameResDownloadManager((AppInterface)getQBaseActivity().getAppRuntime());
    this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResDownloadManager.a(paramResInfo, new AvGameLoadingActivity.5(this, paramResInfo));
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
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvgameUiAVGameBackAction);
      ((StringBuilder)localObject).append("], retCode[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("]");
      QLog.i("AvGameLoadingActivity", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    if (!paramBoolean)
    {
      localObject = this.jdField_a_of_type_ComTencentAvgameUiAVGameBackAction;
      if (localObject != null)
      {
        ((AVGameBackAction)localObject).a(getActivity());
        if (!"MsgPush".equals(this.jdField_a_of_type_ComTencentAvgameUiAVGameBackAction.jdField_a_of_type_JavaLangString)) {
          return;
        }
        ReportController.b(null, "dc00898", "", "", "0X800B247", "0X800B247", paramInt, 0, "", "", "", "");
        return;
      }
    }
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_ComTencentAvgameUiAVGameBackAction;
      if ((localObject != null) && ("MsgPush".equals(((AVGameBackAction)localObject).jdField_a_of_type_JavaLangString))) {
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
    long l = this.jdField_a_of_type_Long;
    int k = 1;
    if (paramLong1 == l)
    {
      if ((paramInt == 0) && (paramRoomInfo != null))
      {
        paramLong1 = paramRoomInfo.id;
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
        if ((paramString != null) && (!paramString.isFinishing()))
        {
          if ((this.jdField_c_of_type_Boolean) && (this.jdField_d_of_type_Int == 2)) {
            this.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
          }
          paramString = new StringBuilder();
          paramString.append(paramLong1);
          paramString.append("");
          this.jdField_d_of_type_JavaLangString = paramString.toString();
          AVGameNodeReportUtil.a(this.jdField_d_of_type_JavaLangString);
          this.jdField_e_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
          this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
          this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo = paramRoomInfo;
          f();
          break label359;
        }
        paramString = new StringBuilder();
        paramString.append("handleProtoEnterResult  ENTER WITH null activity bCreate:");
        paramString.append(paramBoolean);
        QLog.e("AvGameLoadingActivity", 2, paramString.toString());
      }
      else
      {
        paramRoomInfo = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
        if ((paramRoomInfo != null) && (!paramRoomInfo.isFinishing()))
        {
          if (this.jdField_d_of_type_Boolean)
          {
            m();
            break label359;
          }
          a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, paramInt, paramBoolean, paramString, paramLong2);
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
    k = 0;
    label359:
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
    if ((paramString != null) && (!paramString.isFinishing()))
    {
      int m;
      if (paramBoolean)
      {
        if (paramInt == 0)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X800B018", "0X800B018", this.jdField_d_of_type_Int, 0, "", this.jdField_d_of_type_JavaLangString, "", "");
          if (this.jdField_d_of_type_Int == 4) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X800B06C", "0X800B06C", this.jdField_e_of_type_Int, 0, "", this.jdField_d_of_type_JavaLangString, "", "");
          }
        }
        else
        {
          paramString = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime();
          m = this.jdField_d_of_type_Int;
          paramRoomInfo = new StringBuilder();
          paramRoomInfo.append(paramInt);
          paramRoomInfo.append("");
          ReportController.b(paramString, "dc00898", "", "", "0X800B019", "0X800B019", m, 0, paramRoomInfo.toString(), "", "", "");
        }
      }
      else if (paramInt == 0)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X800B026", "0X800B026", this.jdField_d_of_type_Int, 0, "", this.jdField_d_of_type_JavaLangString, "", "");
      }
      else
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime();
        m = this.jdField_d_of_type_Int;
        paramRoomInfo = new StringBuilder();
        paramRoomInfo.append(paramInt);
        paramRoomInfo.append("");
        ReportController.b(paramString, "dc00898", "", "", "0X800B027", "0X800B027", m, 0, paramRoomInfo.toString(), "", "", "");
      }
    }
    if (k == 0)
    {
      paramString = new StringBuilder();
      paramString.append("handleProtoEnterResult !bHandled bCreate:");
      paramString.append(paramBoolean);
      QLog.e("AvGameLoadingActivity", 2, paramString.toString());
      if (paramBoolean) {
        k = -102;
      } else {
        k = -103;
      }
      AVGameNodeReportUtil.b(k);
      a(false, paramInt);
    }
  }
  
  public static void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2, Bundle paramBundle)
  {
    AVGamePerfReporter.a().a("param_StepLoading");
    paramBundle = a(paramBoolean, paramInt1, paramString1, paramString2, paramInt2, paramBundle);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowClosedBroadcast(BaseApplicationImpl.getContext(), 56, 2);
    QPublicFragmentActivity.Launcher.a(paramBundle, QPublicFragmentActivity.class, AvGameLoadingActivity.class);
    paramBundle = new StringBuilder();
    paramBundle.append(" beCreate");
    paramBundle.append(paramBoolean);
    paramBundle.append(" fromType");
    paramBundle.append(paramInt1);
    paramBundle.append(" roomId");
    paramBundle.append(paramString2);
    paramBundle.append(" peer");
    paramBundle.append(paramString1);
    paramBundle.append("gt");
    paramBundle.append(paramInt2);
    QLog.e("AvGameLoadingActivity", 2, paramBundle.toString());
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
    paramActivity.overridePendingTransition(2130772147, 2130772147);
  }
  
  private boolean a()
  {
    return this.jdField_c_of_type_Int == 10;
  }
  
  private void c()
  {
    IAvGameResPreloadManager.ConfInfo localConfInfo = AvGameResPreloadManager.a();
    StringBuilder localStringBuilder;
    if ((!TextUtils.isEmpty(localConfInfo.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localConfInfo.jdField_b_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkResPreloadReady checkResDownloadReady ResInfo:");
        localStringBuilder.append(localConfInfo.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(", ");
        localStringBuilder.append(localConfInfo.jdField_b_of_type_JavaLangString);
        QLog.d("AvGameLoadingActivity", 2, localStringBuilder.toString());
      }
      a(new AvGameResDownloadManager.ResInfo(localConfInfo.jdField_a_of_type_JavaLangString, localConfInfo.jdField_b_of_type_JavaLangString));
      return;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkResPreloadReady manage url or md5 empty:");
      localStringBuilder.append(localConfInfo.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(", ");
      localStringBuilder.append(localConfInfo.jdField_b_of_type_JavaLangString);
      QLog.e("AvGameLoadingActivity", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(10);
    if (this.jdField_g_of_type_Boolean) {
      AVGameExceptionReporter.a().a(1, null, null, null);
    }
  }
  
  private void d()
  {
    AVGamePerfReporter.a().a("param_StepResource");
    this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResDownloadManager = new AvGameResDownloadManager((AppInterface)getQBaseActivity().getAppRuntime());
    this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResDownloadManager.a(new AvGameResDownloadManager.ResInfo(AvGameConfigUtil.a().a(), AvGameConfigUtil.a().b()), new AvGameLoadingActivity.6(this));
  }
  
  private void e()
  {
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
    if (localBundle != null)
    {
      this.jdField_d_of_type_Boolean = localBundle.getBoolean("key_stranger_match", false);
      this.jdField_e_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("key_stranger_match_v2", false);
      this.jdField_f_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("key_stranger_match_v2_from", 0);
      this.jdField_g_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("key_pk_qqcj", false);
    }
  }
  
  private void f()
  {
    AVGamePerfReporter.a().a("param_StepAvAlive");
    if (!AVGameUtilService.a())
    {
      QLog.d("AvGameLoadingActivity", 2, "preStartAvGameActivity  isAVGameAlive false ");
      h();
      return;
    }
    QLog.d("AvGameLoadingActivity", 2, "preStartAvGameActivity  isAVGameAlive true ");
    j();
  }
  
  private void g()
  {
    if (AVGameUtilService.a())
    {
      QLog.d("AvGameLoadingActivity", 2, "checkAvGameProcessReady live ");
      j();
      return;
    }
    QLog.d("AvGameLoadingActivity", 2, "checkAvGameProcessReady not  live send  MSG_CHECK_AV_GAME_PROCESS_READY");
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 1000L);
  }
  
  private void h()
  {
    QLog.d("AvGameLoadingActivity", 2, "startWaitProcessReady ");
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 1000L);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 15000L);
  }
  
  private void i()
  {
    QLog.d("AvGameLoadingActivity", 2, "stopWaitProcessReady ");
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(8);
  }
  
  private void j()
  {
    QLog.d("AvGameLoadingActivity", 2, "DoEnterActivity ");
    a(100);
    i();
    b();
    AVGamePerfReporter.a().a("param_StepAvAlive", 0);
    QBaseActivity localQBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    String str1 = this.jdField_d_of_type_JavaLangString;
    RoomInfo localRoomInfo = this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo;
    String str2 = this.jdField_a_of_type_JavaLangString;
    int k = this.jdField_c_of_type_Int;
    boolean bool;
    if ((k != 9) && (k != 11) && (k != 13)) {
      bool = false;
    } else {
      bool = true;
    }
    a(true, localQBaseActivity, arrayOfByte, str1, localRoomInfo, str2, bool, a(), this.jdField_a_of_type_AndroidOsBundle, this.jdField_c_of_type_Int, this.jdField_b_of_type_Boolean);
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(7, this.jdField_g_of_type_Int);
  }
  
  private void k()
  {
    AVGamePerfReporter.a().a("param_StepResource", 0);
    int k = this.jdField_a_of_type_Int;
    int m = this.jdField_b_of_type_Int;
    if (k <= 100 / m) {
      this.jdField_a_of_type_Int = (100 / m + (int)System.currentTimeMillis() % 5);
    }
    a(this.jdField_a_of_type_Int);
    ThreadManager.getUIHandlerV2().postDelayed(new AvGameLoadingActivity.9(this), 150L);
  }
  
  private void l()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stopStrangerMatch ");
      localStringBuilder.append(this.jdField_h_of_type_Int);
      localStringBuilder.append(" ");
      localStringBuilder.append(this.jdField_b_of_type_ArrayOfByte);
      QLog.i("AvGameLoadingActivity", 2, localStringBuilder.toString());
    }
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_h_of_type_Int != -1))
    {
      ((AvGameRoomListHandler)((AppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime()).getBusinessHandler(AvGameRoomListHandler.jdField_a_of_type_JavaLangString)).a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getLongAccountUin(), 0, 0, this.jdField_h_of_type_Int);
      this.jdField_h_of_type_Int = -1;
    }
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_b_of_type_ArrayOfByte != null))
    {
      ((AvGameRoomListHandler)((AppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime()).getBusinessHandler(AvGameRoomListHandler.jdField_a_of_type_JavaLangString)).a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getLongAccountUin(), this.jdField_e_of_type_Int, this.jdField_b_of_type_ArrayOfByte, 0);
      this.jdField_b_of_type_ArrayOfByte = null;
    }
  }
  
  private void m()
  {
    boolean bool = QLog.isColorLevel();
    int k = 2;
    if (bool) {
      QLog.i("AvGameLoadingActivity", 2, "startStrangerMatch ");
    }
    AvGameRoomListHandler localAvGameRoomListHandler = (AvGameRoomListHandler)((AppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime()).getBusinessHandler(AvGameRoomListHandler.jdField_a_of_type_JavaLangString);
    if (localAvGameRoomListHandler != null)
    {
      Card localCard = ((IProfileDataService)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getRuntimeService(IProfileDataService.class, "all")).getProfileCardFromCache(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getCurrentUin());
      if (localCard != null)
      {
        if (localCard.shGender == 0) {
          k = 1;
        } else if (localCard.shGender == 1) {}
      }
      else {
        k = 0;
      }
      localAvGameRoomListHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getLongAccountUin(), 0, k);
      a(true);
      this.jdField_h_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(9);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(9, 10000L);
    }
  }
  
  private void n()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startStrangerMatchV2 ");
      ((StringBuilder)localObject).append(this.jdField_e_of_type_Int);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(this.jdField_f_of_type_Int);
      QLog.i("AvGameLoadingActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (AvGameRoomListHandler)((AppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime()).getBusinessHandler(AvGameRoomListHandler.jdField_a_of_type_JavaLangString);
    if (localObject != null) {
      ((AvGameRoomListHandler)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getLongAccountUin(), this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
    }
  }
  
  private void o()
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getBaseContext().getString(2131690366));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getBaseContext().getString(2131690368));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getBaseContext().getString(2131690369));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getBaseContext().getString(2131690370));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getBaseContext().getString(2131690371));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getBaseContext().getString(2131690372));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getBaseContext().getString(2131690373));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getBaseContext().getString(2131690374));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getBaseContext().getString(2131690375));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getBaseContext().getString(2131690367));
  }
  
  public void a()
  {
    l();
    if (getActivity() != null)
    {
      AVGamePerfReporter.a().a(2);
      getQBaseActivity().superFinish();
      getActivity().overridePendingTransition(2130772147, 2130772147);
      QLog.d("AvGameLoadingActivity", 2, "finish ");
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
          localQQCustomDialog.setPositiveButton(2131690492, paramAppRuntime);
          localQQCustomDialog.setNegativeButton(2131690728, paramAppRuntime);
        }
        else
        {
          localQQCustomDialog.setNegativeButton(2131690499, paramAppRuntime);
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
      int k;
      if (paramBoolean) {
        k = -102;
      } else {
        k = -103;
      }
      AVGameNodeReportUtil.b(k);
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
    this.jdField_f_of_type_Boolean = true;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
    if ((localObject != null) && (!((QBaseActivity)localObject).isFinishing()))
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentAvgameWidgetAutoBgImageView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_ComTencentAvgameWidgetAutoBgImageView.setVisibility(8);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("enableExit isFinishing");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.e("AvGameLoadingActivity", 2, ((StringBuilder)localObject).toString());
  }
  
  void b()
  {
    this.jdField_f_of_type_Boolean = false;
    QBaseActivity localQBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
    if ((localQBaseActivity != null) && (!localQBaseActivity.isFinishing()))
    {
      this.jdField_a_of_type_ComTencentAvgameWidgetAutoBgImageView.setVisibility(8);
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
      this.jdField_h_of_type_Boolean = false;
      this.i = true;
      if (isAdded())
      {
        a(null, getString(2131690395), getString(2131690499), new AvGameLoadingActivity.7(this), null, null);
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
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = ((LottieDrawable)paramMessage.obj);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.pauseAnimation();
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
        return false;
      }
      break;
    case 5: 
      j();
      return false;
    case 4: 
      if (isAdded())
      {
        long l = System.currentTimeMillis();
        int k = this.jdField_a_of_type_Int;
        int m = (int)(l % 5L);
        if (k + m < 100)
        {
          this.jdField_a_of_type_Int = (k + m);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131690323, new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
        }
      }
      g();
      return false;
    case 3: 
      a();
      return false;
    case 2: 
      if (isAdded())
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131690323, new Object[] { Integer.valueOf(paramMessage.arg1) }));
        return false;
      }
      break;
    case 1: 
      QQToast.a(BaseApplicationImpl.getApplication(), 0, BaseApplicationImpl.getApplication().getString(2131690440), 0).a();
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
    paramActivity.setTheme(2131755751);
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
    if (this.jdField_f_of_type_Boolean)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mExitBtn ");
      ((StringBuilder)localObject).append(this.jdField_d_of_type_JavaLangString);
      QLog.d("AvGameLoadingActivity", 2, ((StringBuilder)localObject).toString());
      ReportController.b(null, "dc00898", "", "", "0X800B042", "0X800B042", 0, 0, "", "", "", "");
      localObject = this.jdField_d_of_type_JavaLangString;
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
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = getQBaseActivity();
    AVGamePerfReporter.a().a("param_StepEntrance", 0);
    if (ImmersiveUtils.couldSetStatusTextColor()) {
      ImmersiveUtils.setStatusTextColor(false, getActivity().getWindow());
    }
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent();
    if (paramBundle == null)
    {
      a(false, 501);
      QLog.e("AvGameLoadingActivity", 2, " intent null");
      return;
    }
    this.jdField_b_of_type_Boolean = paramBundle.getBooleanExtra("key_bCreate", true);
    this.jdField_c_of_type_Boolean = this.jdField_b_of_type_Boolean;
    this.jdField_c_of_type_Int = paramBundle.getIntExtra("key_fromType", 0);
    this.jdField_d_of_type_Int = this.jdField_c_of_type_Int;
    this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("key_peerUin");
    this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("key_roomId");
    this.jdField_e_of_type_Int = paramBundle.getIntExtra("key_game_type", 1);
    this.jdField_a_of_type_AndroidOsBundle = paramBundle.getBundleExtra("key_extra_bundle");
    e();
    this.jdField_a_of_type_ComTencentAvgameUiAVGameBackAction = AVGameBackAction.a(paramBundle);
    paramBundle = this.jdField_a_of_type_ComTencentAvgameUiAVGameBackAction;
    if ((paramBundle != null) && ("MsgPush".equals(paramBundle.jdField_a_of_type_JavaLangString))) {
      ReportController.b(null, "dc00898", "", "", "0X800B245", "0X800B245", 0, 0, "", "", "", "");
    }
    paramBundle = (AppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime();
    if (paramBundle != null) {
      paramBundle.addObserver(this.jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver);
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    getActivity().sendBroadcast(new Intent("tencent.avgame.notify.voice.record.off"), "com.tencent.msg.permission.pushnotify");
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.avgame.ui.AvGameLoadingActivity.ACTION_LOADING_FINISH");
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    AVGameUtilService.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), true);
    AVGameNodeReportUtil.a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.inflate(2131558652, null));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379630));
    this.jdField_a_of_type_ComTencentAvgameWidgetAutoBgImageView = ((AutoBgImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363180));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369411));
    this.jdField_a_of_type_ComTencentAvgameUiCasualTips = ((CasualTips)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378759));
    if (this.jdField_a_of_type_ComTencentAvgameUiCasualTips != null)
    {
      o();
      this.jdField_a_of_type_ComTencentAvgameUiCasualTips.setTipsString(this.jdField_a_of_type_JavaUtilArrayList);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131690323, new Object[] { Integer.valueOf(0) }));
    this.jdField_a_of_type_ComTencentAvgameWidgetAutoBgImageView.setOnClickListener(new AvGameLoadingActivity.3(this));
    int k = AvGameConfigUtil.a().b();
    if (k == 0)
    {
      a(true);
    }
    else
    {
      b();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(8, k * 1000);
    }
    AVGameLottieHelper.a(getActivity(), "avgame_loading/data.json", "avgame_loading/images/", 27, 9, -1, new AvGameLoadingActivity.4(this));
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
    if (localObject != null) {
      ((AppInterface)((QBaseActivity)localObject).getAppRuntime()).removeObserver(this.jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
    if (localObject != null)
    {
      BroadcastReceiver localBroadcastReceiver = this.jdField_a_of_type_AndroidContentBroadcastReceiver;
      if (localBroadcastReceiver != null)
      {
        ((QBaseActivity)localObject).unregisterReceiver(localBroadcastReceiver);
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      }
    }
    localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.jdField_a_of_type_ComTencentAvgameUiCasualTips;
    if (localObject != null) {
      ((CasualTips)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
    if ((localObject != null) && (((LottieDrawable)localObject).isAnimating())) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.endAnimation();
    }
    localObject = this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResDownloadManager;
    if (localObject != null) {
      ((AvGameResDownloadManager)localObject).b();
    }
    super.onDestroy();
  }
  
  public void onFinish()
  {
    super.onFinish();
    getActivity().overridePendingTransition(2130772147, 2130772147);
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    QLog.i("AvGameLoadingActivity", 4, "onResume");
    super.onResume();
  }
  
  public void onStart()
  {
    QLog.i("AvGameLoadingActivity", 4, "onStart");
    super.onStart();
  }
  
  public void onStop()
  {
    QLog.i("AvGameLoadingActivity", 4, "onStop");
    super.onStop();
    getActivity().overridePendingTransition(2130772147, 2130772147);
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
      paramView.append(this.jdField_g_of_type_Boolean);
      QLog.d("AvGameLoadingActivity", 2, paramView.toString());
    }
    if (this.jdField_g_of_type_Boolean) {
      c();
    } else {
      d();
    }
    if ((DeviceInfoUtils.b()) && (DeviceInfoUtils.b())) {
      this.jdField_g_of_type_Int = 8000;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AvGameLoadingActivity
 * JD-Core Version:    0.7.0.1
 */