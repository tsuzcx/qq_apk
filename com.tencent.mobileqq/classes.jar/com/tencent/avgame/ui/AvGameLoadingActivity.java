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
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.avgame.business.handler.AvGameRoomListHandler;
import com.tencent.avgame.business.observer.AvGameRoomListObserver;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadManager;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadManager.ResInfo;
import com.tencent.avgame.gamelogic.gameres.AvGameResPreloadManager;
import com.tencent.avgame.gamelogic.gameres.AvGameResPreloadManager.ConfInfo;
import com.tencent.avgame.gamelogic.gameres.AvGameResPreloadManager.PathInfo;
import com.tencent.avgame.gameroom.AVGameLottieHelper;
import com.tencent.avgame.gameroom.festivalreport.CJSurvivalFestivalReporter;
import com.tencent.avgame.ipc.AVGameUtilService;
import com.tencent.avgame.util.AVGameNodeReportUtil;
import com.tencent.avgame.util.AVGamePerfReporter;
import com.tencent.avgame.util.AvGameConfBean;
import com.tencent.avgame.util.AvGameEntranceUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.AvGameConfProcessor;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.AutoBgImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;

public class AvGameLoadingActivity
  extends PublicBaseFragment
  implements Handler.Callback
{
  int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new AvGameLoadingActivity.1(this);
  private Bundle jdField_a_of_type_AndroidOsBundle;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AvGameRoomListObserver jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver = new AvGameLoadingActivity.2(this);
  private RoomInfo jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo = null;
  AvGameResDownloadManager jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResDownloadManager;
  private AVGameBackAction jdField_a_of_type_ComTencentAvgameUiAVGameBackAction = null;
  private CasualTips jdField_a_of_type_ComTencentAvgameUiCasualTips;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  private AutoBgImageView jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView;
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
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {
      QLog.e("AvGameManagerAvGameLoadingActivity", 1, "createAvGameRoom activity finish ");
    }
    AvGameRoomListHandler localAvGameRoomListHandler;
    do
    {
      return;
      localAvGameRoomListHandler = (AvGameRoomListHandler)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getBusinessHandler(BusinessHandlerFactory.AV_GAME_HANDLER);
    } while (localAvGameRoomListHandler == null);
    localAvGameRoomListHandler.a(paramInt, paramString, this.jdField_a_of_type_Long, this.jdField_e_of_type_Int);
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {
      QLog.e("AvGameManagerAvGameLoadingActivity", 1, "joinAvGameRoom activity finish");
    }
    AvGameRoomListHandler localAvGameRoomListHandler;
    do
    {
      return;
      if (TextUtils.isEmpty(paramString1))
      {
        QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131690573, 0).a();
        QLog.e("AvGameManagerAvGameLoadingActivity", 1, "joinAvGameRoom with empty roomId!!");
        AVGameNodeReportUtil.b(-103);
        a(false, 114);
        return;
      }
      localAvGameRoomListHandler = (AvGameRoomListHandler)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getBusinessHandler(BusinessHandlerFactory.AV_GAME_HANDLER);
    } while (localAvGameRoomListHandler == null);
    localAvGameRoomListHandler.a(paramInt, paramString1, paramString2, this.jdField_a_of_type_Long);
  }
  
  private void a(long paramLong)
  {
    if (paramLong != 0L)
    {
      AvGameRoomListHandler localAvGameRoomListHandler = (AvGameRoomListHandler)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getBusinessHandler(BusinessHandlerFactory.AV_GAME_HANDLER);
      if (localAvGameRoomListHandler != null) {
        localAvGameRoomListHandler.a(paramLong);
      }
    }
    QLog.d("AvGameManagerAvGameLoadingActivity", 2, "exitRoom " + paramLong);
  }
  
  private void a(AvGameResDownloadManager.ResInfo paramResInfo)
  {
    AVGamePerfReporter.a().a("param_StepResource");
    this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResDownloadManager = new AvGameResDownloadManager(getActivity().getAppInterface());
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
    if (QLog.isColorLevel()) {
      QLog.i("AvGameManagerAvGameLoadingActivity", 2, "finish, hasEnterGame[" + paramBoolean + "], action[" + this.jdField_a_of_type_ComTencentAvgameUiAVGameBackAction + "], retCode[" + paramInt + "]");
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    if ((!paramBoolean) && (this.jdField_a_of_type_ComTencentAvgameUiAVGameBackAction != null))
    {
      this.jdField_a_of_type_ComTencentAvgameUiAVGameBackAction.a(getActivity());
      if ("MsgPush".equals(this.jdField_a_of_type_ComTencentAvgameUiAVGameBackAction.jdField_a_of_type_JavaLangString)) {
        ReportController.b(null, "dc00898", "", "", "0X800B247", "0X800B247", paramInt, 0, "", "", "", "");
      }
    }
    while ((!paramBoolean) || (this.jdField_a_of_type_ComTencentAvgameUiAVGameBackAction == null) || (!"MsgPush".equals(this.jdField_a_of_type_ComTencentAvgameUiAVGameBackAction.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B246", "0X800B246", 0, 0, "", "", "", "");
  }
  
  private void a(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong1, long paramLong2)
  {
    QLog.d("AvGameManagerAvGameLoadingActivity", 2, "handleProtoEnterResult  bCreate:" + paramBoolean + " ret code " + paramInt);
    AVGamePerfReporter.a().a("param_StepRoomProto", 0);
    int k = 0;
    if (paramLong1 == this.jdField_a_of_type_Long) {
      if ((paramInt == 0) && (paramRoomInfo != null))
      {
        paramLong1 = paramRoomInfo.id;
        if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
        {
          k = 1;
          if ((this.jdField_c_of_type_Boolean) && (this.jdField_d_of_type_Int == 2)) {
            this.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
          }
          this.jdField_d_of_type_JavaLangString = (paramLong1 + "");
          AVGameNodeReportUtil.a(this.jdField_d_of_type_JavaLangString);
          this.jdField_e_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
          this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
          this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo = paramRoomInfo;
          f();
          if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
          {
            if (!paramBoolean) {
              break label542;
            }
            if (paramInt != 0) {
              break label486;
            }
            ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B018", "0X800B018", this.jdField_d_of_type_Int, 0, "", this.jdField_d_of_type_JavaLangString, "", "");
            if (this.jdField_d_of_type_Int == 4) {
              ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B06C", "0X800B06C", this.jdField_e_of_type_Int, 0, "", this.jdField_d_of_type_JavaLangString, "", "");
            }
          }
          label282:
          if (k == 0)
          {
            QLog.e("AvGameManagerAvGameLoadingActivity", 2, "handleProtoEnterResult !bHandled bCreate:" + paramBoolean);
            if (!paramBoolean) {
              break label643;
            }
          }
        }
      }
    }
    label643:
    for (k = -102;; k = -103)
    {
      AVGameNodeReportUtil.b(k);
      a(false, paramInt);
      return;
      QLog.e("AvGameManagerAvGameLoadingActivity", 2, "handleProtoEnterResult  ENTER WITH null activity bCreate:" + paramBoolean);
      break;
      if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
      {
        if (this.jdField_d_of_type_Boolean)
        {
          m();
          k = 1;
          break;
        }
        a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramInt, paramBoolean, paramString, paramLong2);
        k = 1;
        break;
      }
      QLog.e("AvGameManagerAvGameLoadingActivity", 2, "mObserver handleProtoEnterResult alertDialogWithRetCode  WITH null activity  bCreate:" + paramBoolean);
      k = 0;
      break;
      QLog.i("AvGameManagerAvGameLoadingActivity", 2, "handleProtoEnterResult get observer not by self bCreate:" + paramBoolean);
      k = 0;
      break;
      label486:
      ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B019", "0X800B019", this.jdField_d_of_type_Int, 0, paramInt + "", "", "", "");
      break label282;
      label542:
      if (paramInt == 0)
      {
        ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B026", "0X800B026", this.jdField_d_of_type_Int, 0, "", this.jdField_d_of_type_JavaLangString, "", "");
        break label282;
      }
      ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B027", "0X800B027", this.jdField_d_of_type_Int, 0, paramInt + "", "", "", "");
      break label282;
    }
  }
  
  public static void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2, Bundle paramBundle)
  {
    AVGamePerfReporter.a().a("param_StepLoading");
    paramBundle = a(paramBoolean, paramInt1, paramString1, paramString2, paramInt2, paramBundle);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowClosedBroadcast(BaseApplicationImpl.getContext(), 56, 2);
    PublicFragmentActivity.Launcher.a(paramBundle, PublicFragmentActivity.class, AvGameLoadingActivity.class);
    QLog.e("AvGameManagerAvGameLoadingActivity", 2, " beCreate" + paramBoolean + " fromType" + paramInt1 + " roomId" + paramString2 + " peer" + paramString1 + "gt" + paramInt2);
  }
  
  public static void a(boolean paramBoolean1, Activity paramActivity, byte[] paramArrayOfByte, String paramString1, RoomInfo paramRoomInfo, String paramString2, boolean paramBoolean2, boolean paramBoolean3, Bundle paramBundle)
  {
    a(paramBoolean1, paramActivity, paramArrayOfByte, paramString1, paramRoomInfo, paramString2, paramBoolean2, paramBoolean3, paramBundle, 0, true);
  }
  
  public static void a(boolean paramBoolean1, Activity paramActivity, byte[] paramArrayOfByte, String paramString1, RoomInfo paramRoomInfo, String paramString2, boolean paramBoolean2, boolean paramBoolean3, Bundle paramBundle, int paramInt, boolean paramBoolean4)
  {
    if (paramActivity == null)
    {
      QLog.e("AvGameManagerAvGameLoadingActivity", 1, "enterAvGameActivity with empty activity");
      return;
    }
    AVGamePerfReporter.a().a("param_StepPrepareGame");
    Intent localIntent = new Intent(paramActivity, AVGameActivity.class);
    localIntent.putExtra("key_room_from_type", paramInt);
    localIntent.putExtra("key_room_is_create", paramBoolean4);
    if (paramString1 != null)
    {
      localIntent.putExtra("key_room_id", paramString1);
      QLog.e("AvGameManagerAvGameLoadingActivity", 1, "enterAvGameActivity roomId " + paramString1 + "be New:" + paramBoolean1);
    }
    for (;;)
    {
      if (paramArrayOfByte != null)
      {
        localIntent.putExtra("key_sig", paramArrayOfByte);
        QLog.d("AvGameManagerAvGameLoadingActivity", 2, "enterAvGameActivity sig");
      }
      if (paramRoomInfo != null)
      {
        paramArrayOfByte = new Bundle();
        paramArrayOfByte.putSerializable("key_room_info", paramRoomInfo);
        localIntent.putExtra("key_room_bundle", paramArrayOfByte);
        QLog.d("AvGameManagerAvGameLoadingActivity", 2, "enterAvGameActivity roomInfo" + paramRoomInfo.toString());
      }
      localIntent.putExtra("key_room_be_new_enter", paramBoolean1);
      if (paramString2 != null) {
        localIntent.putExtra("key_room_friend_uin", paramString2);
      }
      paramArrayOfByte = AVGameBackAction.a(paramActivity.getIntent());
      if (paramArrayOfByte != null) {
        AVGameBackAction.a(localIntent, paramArrayOfByte);
      }
      if (QLog.isColorLevel()) {
        QLog.i("AvGameManagerAvGameLoadingActivity", 2, "enterAvGameActivity, action[" + paramArrayOfByte + "], activity[" + paramActivity + "]");
      }
      QLog.e("AvGameManagerAvGameLoadingActivity", 1, "enterAvGameActivity startActivity    current time:" + System.currentTimeMillis() + " bNewEnter: " + paramBoolean1 + " match:" + paramBoolean2 + " survival:" + paramBoolean3);
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
      paramActivity.startActivity(localIntent);
      paramActivity.overridePendingTransition(2130772121, 2130772121);
      return;
      QLog.e("AvGameManagerAvGameLoadingActivity", 1, "enterAvGameActivity roomId empty  be New:" + paramBoolean1);
    }
  }
  
  private boolean a()
  {
    return this.jdField_c_of_type_Int == 10;
  }
  
  private void c()
  {
    AvGameResPreloadManager.PathInfo localPathInfo = AvGameResPreloadManager.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
    AvGameResPreloadManager.ConfInfo localConfInfo = AvGameResPreloadManager.a();
    if ((TextUtils.isEmpty(localConfInfo.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(localConfInfo.jdField_b_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("AvGameManagerAvGameLoadingActivity", 2, "checkResPreloadReady manage url or md5 empty:" + localConfInfo.jdField_a_of_type_JavaLangString + ", " + localConfInfo.jdField_b_of_type_JavaLangString);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(10);
      if (this.jdField_g_of_type_Boolean) {
        CJSurvivalFestivalReporter.a(1, false, "-1", null, true);
      }
      return;
    }
    if (TextUtils.isEmpty(localPathInfo.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.w("AvGameManagerAvGameLoadingActivity", 2, "checkResPreloadReady mediaResPath empty as not ready, go with AvGameResDownloadManager");
      }
      if (QLog.isColorLevel()) {
        QLog.d("AvGameManagerAvGameLoadingActivity", 2, "checkResPreloadReady checkResDownloadReady ResInfo:" + localConfInfo.jdField_a_of_type_JavaLangString + ", " + localConfInfo.jdField_b_of_type_JavaLangString);
      }
      a(new AvGameResDownloadManager.ResInfo(localConfInfo.jdField_a_of_type_JavaLangString, localConfInfo.jdField_b_of_type_JavaLangString));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AvGameManagerAvGameLoadingActivity", 2, "checkResPreloadReady mediaResPath ready:" + localPathInfo.jdField_a_of_type_JavaLangString);
    }
    AvGameResDownloadManager.jdField_a_of_type_JavaLangString = localPathInfo.jdField_a_of_type_JavaLangString;
    AvGameResPreloadManager.a(localPathInfo);
    AvGameResPreloadManager.a(localConfInfo);
    this.jdField_a_of_type_Int = 0;
    k();
  }
  
  private void d()
  {
    AVGamePerfReporter.a().a("param_StepResource");
    this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResDownloadManager = new AvGameResDownloadManager(getActivity().getAppInterface());
    this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResDownloadManager.a(new AvGameResDownloadManager.ResInfo(AvGameConfProcessor.a().a(), AvGameConfProcessor.a().b()), new AvGameLoadingActivity.6(this));
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidOsBundle != null)
    {
      this.jdField_d_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("key_stranger_match", false);
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
      QLog.d("AvGameManagerAvGameLoadingActivity", 2, "preStartAvGameActivity  isAVGameAlive false ");
      h();
      return;
    }
    QLog.d("AvGameManagerAvGameLoadingActivity", 2, "preStartAvGameActivity  isAVGameAlive true ");
    j();
  }
  
  private void g()
  {
    if (AVGameUtilService.a())
    {
      QLog.d("AvGameManagerAvGameLoadingActivity", 2, "checkAvGameProcessReady live ");
      j();
      return;
    }
    QLog.d("AvGameManagerAvGameLoadingActivity", 2, "checkAvGameProcessReady not  live send  MSG_CHECK_AV_GAME_PROCESS_READY");
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 1000L);
  }
  
  private void h()
  {
    QLog.d("AvGameManagerAvGameLoadingActivity", 2, "startWaitProcessReady ");
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 1000L);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 15000L);
  }
  
  private void i()
  {
    QLog.d("AvGameManagerAvGameLoadingActivity", 2, "stopWaitProcessReady ");
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(8);
  }
  
  private void j()
  {
    boolean bool = false;
    QLog.d("AvGameManagerAvGameLoadingActivity", 2, "DoEnterActivity ");
    a(100);
    i();
    b();
    AVGamePerfReporter.a().a("param_StepAvAlive", 0);
    FragmentActivity localFragmentActivity = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    String str1 = this.jdField_d_of_type_JavaLangString;
    RoomInfo localRoomInfo = this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo;
    String str2 = this.jdField_a_of_type_JavaLangString;
    if ((this.jdField_c_of_type_Int == 9) || (this.jdField_c_of_type_Int == 11) || (this.jdField_c_of_type_Int == 13)) {
      bool = true;
    }
    a(true, localFragmentActivity, arrayOfByte, str1, localRoomInfo, str2, bool, a(), this.jdField_a_of_type_AndroidOsBundle, this.jdField_c_of_type_Int, this.jdField_b_of_type_Boolean);
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(7, this.jdField_g_of_type_Int);
  }
  
  private void k()
  {
    AVGamePerfReporter.a().a("param_StepResource", 0);
    if (this.jdField_a_of_type_Int <= 100 / this.jdField_b_of_type_Int) {
      this.jdField_a_of_type_Int = (100 / this.jdField_b_of_type_Int + (int)System.currentTimeMillis() % 5);
    }
    a(this.jdField_a_of_type_Int);
    ThreadManager.getUIHandlerV2().postDelayed(new AvGameLoadingActivity.9(this), 150L);
  }
  
  private void l()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameManagerAvGameLoadingActivity", 2, "stopStrangerMatch " + this.jdField_h_of_type_Int + " " + this.jdField_b_of_type_ArrayOfByte);
    }
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_h_of_type_Int != -1))
    {
      ((AvGameRoomListHandler)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getBusinessHandler(BusinessHandlerFactory.AV_GAME_HANDLER)).a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getLongAccountUin(), 0, 0, this.jdField_h_of_type_Int);
      this.jdField_h_of_type_Int = -1;
    }
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_b_of_type_ArrayOfByte != null))
    {
      ((AvGameRoomListHandler)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getBusinessHandler(BusinessHandlerFactory.AV_GAME_HANDLER)).a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getLongAccountUin(), this.jdField_e_of_type_Int, this.jdField_b_of_type_ArrayOfByte, 0);
      this.jdField_b_of_type_ArrayOfByte = null;
    }
  }
  
  private void m()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameManagerAvGameLoadingActivity", 2, "startStrangerMatch ");
    }
    AvGameRoomListHandler localAvGameRoomListHandler = (AvGameRoomListHandler)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getBusinessHandler(BusinessHandlerFactory.AV_GAME_HANDLER);
    Card localCard;
    int k;
    if (localAvGameRoomListHandler != null)
    {
      localCard = ((FriendsManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).c(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getCurrentUin());
      if (localCard == null) {
        break label146;
      }
      if (localCard.shGender != 0) {
        break label128;
      }
      k = 1;
    }
    for (;;)
    {
      localAvGameRoomListHandler.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getLongAccountUin(), 0, k);
      a(true);
      this.jdField_h_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(9);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(9, 10000L);
      return;
      label128:
      if (localCard.shGender == 1)
      {
        k = 2;
      }
      else
      {
        k = 0;
        continue;
        label146:
        k = 0;
      }
    }
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameManagerAvGameLoadingActivity", 2, "startStrangerMatchV2 " + this.jdField_e_of_type_Int + " " + this.jdField_f_of_type_Int);
    }
    AvGameRoomListHandler localAvGameRoomListHandler = (AvGameRoomListHandler)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getBusinessHandler(BusinessHandlerFactory.AV_GAME_HANDLER);
    if (localAvGameRoomListHandler != null) {
      localAvGameRoomListHandler.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getLongAccountUin(), this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
    }
  }
  
  private void o()
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext().getString(2131690442));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext().getString(2131690444));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext().getString(2131690445));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext().getString(2131690446));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext().getString(2131690447));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext().getString(2131690448));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext().getString(2131690449));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext().getString(2131690450));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext().getString(2131690451));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext().getString(2131690443));
  }
  
  public void a()
  {
    l();
    if (getActivity() != null)
    {
      AVGamePerfReporter.a().a(2);
      getActivity().superFinish();
      getActivity().overridePendingTransition(2130772121, 2130772121);
      QLog.d("AvGameManagerAvGameLoadingActivity", 2, "finish ");
      return;
    }
    QLog.e("AvGameManagerAvGameLoadingActivity", 1, "finishFragment with null fragment");
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, boolean paramBoolean, String paramString, long paramLong)
  {
    if ((paramQQAppInterface == null) || (paramActivity == null) || (paramActivity.isFinishing()))
    {
      QLog.e("AvGameManagerAvGameLoadingActivity", 1, "alertDialogWithRetCode  null ac " + paramInt + " " + paramString);
      return;
    }
    Object localObject = null;
    QQCustomDialog localQQCustomDialog = DialogUtil.a(paramActivity, 230);
    String str;
    if (paramBoolean)
    {
      str = AvGameEntranceUtil.a(paramBoolean, paramActivity, paramInt, paramLong, paramString);
      paramActivity = localObject;
      AVGameNodeReportUtil.a(paramInt);
      if (localQQCustomDialog == null) {
        break label260;
      }
      QLog.d("AvGameManagerAvGameLoadingActivity", 2, "alertDialogWithRetCode  " + paramInt + " " + paramString);
      paramQQAppInterface = new AvGameLoadingActivity.8(this, paramQQAppInterface, paramBoolean, paramInt);
      if ((paramBoolean) || ((paramInt != 104) && (paramInt != 105) && (paramInt != 106) && (paramInt != 114))) {
        break label247;
      }
      localQQCustomDialog.setPositiveButton(2131690565, paramQQAppInterface);
      localQQCustomDialog.setNegativeButton(2131690800, paramQQAppInterface);
    }
    for (;;)
    {
      localQQCustomDialog.setCancelable(false);
      localQQCustomDialog.setMessage(str);
      if (paramActivity != null) {
        localQQCustomDialog.setTitle(paramActivity);
      }
      localQQCustomDialog.show();
      return;
      str = AvGameEntranceUtil.a(paramBoolean, paramActivity, paramInt, paramLong, paramString);
      paramActivity = AvGameEntranceUtil.a(paramActivity, paramInt);
      break;
      label247:
      localQQCustomDialog.setNegativeButton(2131690571, paramQQAppInterface);
    }
    label260:
    QLog.e("AvGameManagerAvGameLoadingActivity", 2, "alertDialogWithRetCode null");
    if (paramBoolean) {}
    for (int k = -102;; k = -103)
    {
      AVGameNodeReportUtil.b(k);
      a(false, paramInt);
      return;
    }
  }
  
  void a(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = true;
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
    {
      QLog.e("AvGameManagerAvGameLoadingActivity", 2, "enableExit isFinishing" + paramBoolean);
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(8);
  }
  
  void b()
  {
    this.jdField_f_of_type_Boolean = false;
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
    {
      QLog.e("AvGameManagerAvGameLoadingActivity", 2, "unEnableExit isFinishing");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(8);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
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
              return false;
              QQToast.a(BaseApplicationImpl.getApplication(), 0, BaseApplicationImpl.getApplication().getString(2131690515), 0).a();
            } while (getActivity() == null);
            AVGameNodeReportUtil.b(-101);
            getActivity().finish();
            return false;
          } while (!isAdded());
          this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131690399, new Object[] { Integer.valueOf(paramMessage.arg1) }));
          return false;
          a();
          return false;
          if (isAdded())
          {
            long l = System.currentTimeMillis() % 5L;
            if (this.jdField_a_of_type_Int + (int)l < 100)
            {
              int k = this.jdField_a_of_type_Int;
              this.jdField_a_of_type_Int = ((int)l + k);
              this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131690399, new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
            }
          }
          g();
          return false;
          j();
          return false;
        } while ((!isAdded()) || (!(paramMessage.obj instanceof LottieDrawable)));
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = ((LottieDrawable)paramMessage.obj);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.pauseAnimation();
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
        return false;
        a(false);
        return false;
        a(true);
        return false;
        QLog.d("AvGameManagerAvGameLoadingActivity", 2, "stranger match timeout");
        this.jdField_h_of_type_Boolean = false;
        this.i = true;
      } while (!isAdded());
      a(null, getString(2131690471), getString(2131690571), new AvGameLoadingActivity.7(this), null, null);
      return false;
    } while (getActivity() == null);
    AVGameNodeReportUtil.b(-101);
    getActivity().finish();
    return false;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.setTheme(2131755476);
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
      QLog.d("AvGameManagerAvGameLoadingActivity", 2, "mExitBtn " + this.jdField_d_of_type_JavaLangString);
      ReportController.b(null, "dc00898", "", "", "0X800B042", "0X800B042", 0, 0, "", "", "", "");
      if (this.jdField_d_of_type_JavaLangString != null) {
        a(AvGameEntranceUtil.a(this.jdField_d_of_type_JavaLangString));
      }
      AVGameNodeReportUtil.b(1);
      a(false, 0);
      return super.onBackEvent();
    }
    QLog.d("AvGameManagerAvGameLoadingActivity", 2, "bExitEnable not ");
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    AVGamePerfReporter.a().a("param_StepEntrance", 0);
    if (ImmersiveUtils.couldSetStatusTextColor()) {
      ImmersiveUtils.setStatusTextColor(false, getActivity().getWindow());
    }
    paramBundle = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    if (paramBundle == null)
    {
      a(false, 501);
      QLog.e("AvGameManagerAvGameLoadingActivity", 2, " intent null");
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
    if ((this.jdField_a_of_type_ComTencentAvgameUiAVGameBackAction != null) && ("MsgPush".equals(this.jdField_a_of_type_ComTencentAvgameUiAVGameBackAction.jdField_a_of_type_JavaLangString))) {
      ReportController.b(null, "dc00898", "", "", "0X800B245", "0X800B245", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.addObserver(this.jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    getActivity().sendBroadcast(new Intent("tencent.avgame.notify.voice.record.off"), "com.tencent.msg.permission.pushnotify");
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.avgame.ui.AvGameLoadingActivity.ACTION_LOADING_FINISH");
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    AVGameUtilService.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, true);
    AVGameNodeReportUtil.a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.inflate(2131558753, null));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380319));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363248));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369712));
    this.jdField_a_of_type_ComTencentAvgameUiCasualTips = ((CasualTips)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379408));
    if (this.jdField_a_of_type_ComTencentAvgameUiCasualTips != null)
    {
      o();
      this.jdField_a_of_type_ComTencentAvgameUiCasualTips.setTipsString(this.jdField_a_of_type_JavaUtilArrayList);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131690399, new Object[] { Integer.valueOf(0) }));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(new AvGameLoadingActivity.3(this));
    paramLayoutInflater = (AvGameConfBean)QConfigManager.a().a(642);
    if (paramLayoutInflater != null) {}
    for (int k = paramLayoutInflater.b();; k = 0)
    {
      if (k == 0) {
        a(true);
      }
      for (;;)
      {
        AVGameLottieHelper.a(getActivity(), "avgame_loading/data.json", "avgame_loading/images/", 27, 9, -1, new AvGameLoadingActivity.4(this));
        paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
        V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
        return paramLayoutInflater;
        b();
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(8, k * 1000);
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.removeObserver(this.jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver);
    }
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null))
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_ComTencentAvgameUiCasualTips != null) {
      this.jdField_a_of_type_ComTencentAvgameUiCasualTips.a();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) && (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.isAnimating())) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.endAnimation();
    }
    if (this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResDownloadManager != null) {
      this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResDownloadManager.a();
    }
    super.onDestroy();
  }
  
  public void onFinish()
  {
    super.onFinish();
    getActivity().overridePendingTransition(2130772121, 2130772121);
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    QLog.i("AvGameManagerAvGameLoadingActivity", 4, "onResume");
    super.onResume();
  }
  
  public void onStart()
  {
    QLog.i("AvGameManagerAvGameLoadingActivity", 4, "onStart");
    super.onStart();
  }
  
  public void onStop()
  {
    QLog.i("AvGameManagerAvGameLoadingActivity", 4, "onStop");
    super.onStop();
    getActivity().overridePendingTransition(2130772121, 2130772121);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    AVGamePerfReporter.a().a("param_StepSecure");
    AVGamePerfReporter.a().a("param_StepSecure", 0);
    if (QLog.isColorLevel()) {
      QLog.d("AvGameManagerAvGameLoadingActivity", 2, "onViewCreated mFromCJSurvivalScene:" + this.jdField_g_of_type_Boolean);
    }
    if (this.jdField_g_of_type_Boolean) {
      c();
    }
    for (;;)
    {
      if ((DeviceInfoUtils.b()) && (DeviceInfoUtils.b())) {
        this.jdField_g_of_type_Int = 8000;
      }
      return;
      d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ui.AvGameLoadingActivity
 * JD-Core Version:    0.7.0.1
 */