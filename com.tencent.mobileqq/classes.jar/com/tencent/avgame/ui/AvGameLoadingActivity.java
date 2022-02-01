package com.tencent.avgame.ui;

import aeow;
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
import anvk;
import aqxe;
import aqzv;
import bdla;
import bhdj;
import biwn;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.ipc.AVGameUtilService;
import com.tencent.avgame.util.AVGameNodeReportUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.AutoBgImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import ndj;
import ndm;
import ngl;
import ngo;
import nhu;
import nol;
import npq;
import npr;
import npt;
import npu;
import npv;
import npw;
import npx;
import nqc;
import nqg;
import nqi;

public class AvGameLoadingActivity
  extends PublicBaseFragment
  implements Handler.Callback
{
  public int a;
  private long jdField_a_of_type_Long;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new npq(this);
  private Bundle jdField_a_of_type_AndroidOsBundle;
  public Handler a;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RoomInfo jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo;
  private CasualTips jdField_a_of_type_ComTencentAvgameUiCasualTips;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  private AutoBgImageView jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView;
  String jdField_a_of_type_JavaLangString = null;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ndm jdField_a_of_type_Ndm = new npr(this);
  ngl jdField_a_of_type_Ngl;
  private nol jdField_a_of_type_Nol;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  public int b;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int = 0;
  private String jdField_c_of_type_JavaLangString = "0";
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int = 0;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 1;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean = true;
  private int jdField_f_of_type_Int = 3000;
  private volatile boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int = -1;
  private boolean jdField_g_of_type_Boolean;
  
  public AvGameLoadingActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 2;
  }
  
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
      QLog.e("AvGameManagerAvGameLoadingActivity", 1, "createAvGameRoom activity finish");
    }
    ndj localndj;
    do
    {
      return;
      localndj = (ndj)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getBusinessHandler(BusinessHandlerFactory.AV_GAME_HANDLER);
    } while (localndj == null);
    localndj.a(paramInt, paramString, this.jdField_a_of_type_Long, this.jdField_e_of_type_Int);
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {
      QLog.e("AvGameManagerAvGameLoadingActivity", 1, "joinAvGameRoom activity finish");
    }
    ndj localndj;
    do
    {
      return;
      if (TextUtils.isEmpty(paramString1))
      {
        QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131690471, 0).a();
        QLog.e("AvGameManagerAvGameLoadingActivity", 1, "joinAvGameRoom with empty roomId!!");
        AVGameNodeReportUtil.b(-103);
        a(false, 114);
        return;
      }
      localndj = (ndj)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getBusinessHandler(BusinessHandlerFactory.AV_GAME_HANDLER);
    } while (localndj == null);
    localndj.a(paramInt, paramString1, paramString2, this.jdField_a_of_type_Long);
  }
  
  private void a(long paramLong)
  {
    if (paramLong != 0L)
    {
      ndj localndj = (ndj)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getBusinessHandler(BusinessHandlerFactory.AV_GAME_HANDLER);
      if (localndj != null) {
        localndj.a(paramLong);
      }
    }
    QLog.d("AvGameManagerAvGameLoadingActivity", 2, "exitRoom " + paramLong);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2)
  {
    QQCustomDialog localQQCustomDialog = bhdj.a(getActivity(), 230);
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
      QLog.i("AvGameManagerAvGameLoadingActivity", 2, "finish, hasEnterGame[" + paramBoolean + "], action[" + this.jdField_a_of_type_Nol + "], retCode[" + paramInt + "]");
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    if ((!paramBoolean) && (this.jdField_a_of_type_Nol != null))
    {
      this.jdField_a_of_type_Nol.a(getActivity());
      if ("MsgPush".equals(this.jdField_a_of_type_Nol.jdField_a_of_type_JavaLangString)) {
        bdla.b(null, "dc00898", "", "", "0X800B247", "0X800B247", paramInt, 0, "", "", "", "");
      }
    }
    while ((!paramBoolean) || (this.jdField_a_of_type_Nol == null) || (!"MsgPush".equals(this.jdField_a_of_type_Nol.jdField_a_of_type_JavaLangString))) {
      return;
    }
    bdla.b(null, "dc00898", "", "", "0X800B246", "0X800B246", 0, 0, "", "", "", "");
  }
  
  private void a(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong1, long paramLong2)
  {
    QLog.d("AvGameManagerAvGameLoadingActivity", 2, "handleProtoEnterResult  bCreate:" + paramBoolean + " ret code " + paramInt);
    nqc.a().a("param_StepRoomProto", 0);
    int i = 0;
    if (paramLong1 == this.jdField_a_of_type_Long) {
      if ((paramInt == 0) && (paramRoomInfo != null))
      {
        paramLong1 = paramRoomInfo.id;
        if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
        {
          i = 1;
          if ((this.jdField_c_of_type_Boolean) && (this.jdField_d_of_type_Int == 2)) {
            this.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
          }
          this.jdField_d_of_type_JavaLangString = (paramLong1 + "");
          AVGameNodeReportUtil.a(this.jdField_d_of_type_JavaLangString);
          this.jdField_e_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
          this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
          this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo = paramRoomInfo;
          e();
          if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
          {
            if (!paramBoolean) {
              break label542;
            }
            if (paramInt != 0) {
              break label486;
            }
            bdla.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B018", "0X800B018", this.jdField_d_of_type_Int, 0, "", this.jdField_d_of_type_JavaLangString, "", "");
            if (this.jdField_d_of_type_Int == 4) {
              bdla.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B06C", "0X800B06C", this.jdField_e_of_type_Int, 0, "", this.jdField_d_of_type_JavaLangString, "", "");
            }
          }
          label282:
          if (i == 0)
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
    for (i = -102;; i = -103)
    {
      AVGameNodeReportUtil.b(i);
      a(false, paramInt);
      return;
      QLog.e("AvGameManagerAvGameLoadingActivity", 2, "handleProtoEnterResult  ENTER WITH null activity bCreate:" + paramBoolean);
      break;
      if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
      {
        if (this.jdField_d_of_type_Boolean)
        {
          l();
          i = 1;
          break;
        }
        a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramInt, paramBoolean, paramString, paramLong2);
        i = 1;
        break;
      }
      QLog.e("AvGameManagerAvGameLoadingActivity", 2, "mObserver handleProtoEnterResult alertDialogWithRetCode  WITH null activity  bCreate:" + paramBoolean);
      i = 0;
      break;
      QLog.i("AvGameManagerAvGameLoadingActivity", 2, "handleProtoEnterResult get observer not by self bCreate:" + paramBoolean);
      i = 0;
      break;
      label486:
      bdla.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B019", "0X800B019", this.jdField_d_of_type_Int, 0, paramInt + "", "", "", "");
      break label282;
      label542:
      if (paramInt == 0)
      {
        bdla.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B026", "0X800B026", this.jdField_d_of_type_Int, 0, "", this.jdField_d_of_type_JavaLangString, "", "");
        break label282;
      }
      bdla.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B027", "0X800B027", this.jdField_d_of_type_Int, 0, paramInt + "", "", "", "");
      break label282;
    }
  }
  
  public static void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2, Bundle paramBundle)
  {
    nqc.a().a("param_StepLoading");
    paramBundle = a(paramBoolean, paramInt1, paramString1, paramString2, paramInt2, paramBundle);
    biwn.a(BaseApplicationImpl.getContext(), 56, 2);
    aeow.a(paramBundle, PublicFragmentActivity.class, AvGameLoadingActivity.class);
    QLog.e("AvGameManagerAvGameLoadingActivity", 2, " beCreate" + paramBoolean + " fromType" + paramInt1 + " roomId" + paramString2 + " peer" + paramString1 + "gt" + paramInt2);
  }
  
  public static void a(boolean paramBoolean1, Activity paramActivity, byte[] paramArrayOfByte, String paramString1, RoomInfo paramRoomInfo, String paramString2, boolean paramBoolean2, boolean paramBoolean3, Bundle paramBundle)
  {
    if (paramActivity == null)
    {
      QLog.e("AvGameManagerAvGameLoadingActivity", 1, "enterAvGameActivity with empty activity");
      return;
    }
    nqc.a().a("param_StepPrepareGame");
    Intent localIntent = new Intent(paramActivity, AVGameActivity.class);
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
      paramArrayOfByte = nol.a(paramActivity.getIntent());
      if (paramArrayOfByte != null) {
        nol.a(localIntent, paramArrayOfByte);
      }
      if (QLog.isColorLevel()) {
        QLog.i("AvGameManagerAvGameLoadingActivity", 2, "enterAvGameActivity, action[" + paramArrayOfByte + "], activity[" + paramActivity + "]");
      }
      QLog.e("AvGameManagerAvGameLoadingActivity", 1, "enterAvGameActivity startActivity    current time:" + System.currentTimeMillis() + " bNewEnter: " + paramBoolean1 + " match:" + paramBoolean2 + " survival:" + paramBoolean3);
      localIntent.putExtra("key_start_time", SystemClock.elapsedRealtime());
      localIntent.putExtra("key_start_match", paramBoolean2);
      localIntent.putExtra("key_from_survival", paramBoolean3);
      if ((paramBundle != null) && (paramBoolean3)) {
        localIntent.putExtra("key_pk_type", paramBundle.getInt("key_pk_type", 0));
      }
      AVGameNodeReportUtil.a(localIntent);
      nqc.a().b(localIntent);
      paramActivity.startActivity(localIntent);
      paramActivity.overridePendingTransition(2130772106, 2130772106);
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
    nqc.a().a("param_StepResource");
    this.jdField_a_of_type_Ngl = new ngl(getActivity().getAppInterface());
    this.jdField_a_of_type_Ngl.a(new ngo(aqzv.a().a(), aqzv.a().b()), new npv(this));
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      this.jdField_d_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("key_stranger_match", false);
    }
  }
  
  private void e()
  {
    nqc.a().a("param_StepAvAlive");
    if (!AVGameUtilService.a())
    {
      QLog.d("AvGameManagerAvGameLoadingActivity", 2, "preStartAvGameActivity  isAVGameAlive false ");
      g();
      return;
    }
    QLog.d("AvGameManagerAvGameLoadingActivity", 2, "preStartAvGameActivity  isAVGameAlive true ");
    i();
  }
  
  private void f()
  {
    if (AVGameUtilService.a())
    {
      QLog.d("AvGameManagerAvGameLoadingActivity", 2, "checkAvGameProcessReady live ");
      i();
      return;
    }
    QLog.d("AvGameManagerAvGameLoadingActivity", 2, "checkAvGameProcessReady not  live send  MSG_CHECK_AV_GAME_PROCESS_READY");
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 1000L);
  }
  
  private void g()
  {
    QLog.d("AvGameManagerAvGameLoadingActivity", 2, "startWaitProcessReady ");
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 1000L);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 15000L);
  }
  
  private void h()
  {
    QLog.d("AvGameManagerAvGameLoadingActivity", 2, "stopWaitProcessReady ");
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(8);
  }
  
  private void i()
  {
    boolean bool = false;
    QLog.d("AvGameManagerAvGameLoadingActivity", 2, "DoEnterActivity ");
    a(100);
    h();
    b();
    nqc.a().a("param_StepAvAlive", 0);
    FragmentActivity localFragmentActivity = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    String str1 = this.jdField_d_of_type_JavaLangString;
    RoomInfo localRoomInfo = this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo;
    String str2 = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_c_of_type_Int == 9) {
      bool = true;
    }
    a(true, localFragmentActivity, arrayOfByte, str1, localRoomInfo, str2, bool, a(), this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(7, this.jdField_f_of_type_Int);
  }
  
  private void j()
  {
    nqc.a().a("param_StepResource", 0);
    if (this.jdField_a_of_type_Int <= 100 / this.jdField_b_of_type_Int) {
      this.jdField_a_of_type_Int = (100 / this.jdField_b_of_type_Int + (int)System.currentTimeMillis() % 5);
    }
    a(this.jdField_a_of_type_Int);
    ThreadManager.getUIHandlerV2().postDelayed(new AvGameLoadingActivity.8(this), 150L);
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameManagerAvGameLoadingActivity", 2, "stopStrangerMatch " + this.jdField_g_of_type_Int);
    }
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_g_of_type_Int != -1))
    {
      ((ndj)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getBusinessHandler(BusinessHandlerFactory.AV_GAME_HANDLER)).a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getLongAccountUin(), 0, 0, this.jdField_g_of_type_Int);
      this.jdField_g_of_type_Int = -1;
    }
  }
  
  private void l()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameManagerAvGameLoadingActivity", 2, "startStrangerMatch ");
    }
    ndj localndj = (ndj)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getBusinessHandler(BusinessHandlerFactory.AV_GAME_HANDLER);
    Card localCard;
    int i;
    if (localndj != null)
    {
      localCard = ((anvk)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getCurrentUin());
      if (localCard == null) {
        break label146;
      }
      if (localCard.shGender != 0) {
        break label128;
      }
      i = 1;
    }
    for (;;)
    {
      localndj.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getLongAccountUin(), 0, i);
      a(true);
      this.jdField_f_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(9);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(9, 10000L);
      return;
      label128:
      if (localCard.shGender == 1)
      {
        i = 2;
      }
      else
      {
        i = 0;
        continue;
        label146:
        i = 0;
      }
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext().getString(2131690362));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext().getString(2131690364));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext().getString(2131690365));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext().getString(2131690366));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext().getString(2131690367));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext().getString(2131690368));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext().getString(2131690369));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext().getString(2131690370));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext().getString(2131690371));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext().getString(2131690363));
  }
  
  public void a()
  {
    k();
    if (getActivity() != null)
    {
      nqc.a().a(2);
      getActivity().superFinish();
      getActivity().overridePendingTransition(2130772106, 2130772106);
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
    QQCustomDialog localQQCustomDialog = bhdj.a(paramActivity, 230);
    String str;
    if (paramBoolean)
    {
      str = nqi.a(paramBoolean, paramActivity, paramInt, paramLong, paramString);
      paramActivity = localObject;
      AVGameNodeReportUtil.a(paramInt);
      if (localQQCustomDialog == null) {
        break label260;
      }
      QLog.d("AvGameManagerAvGameLoadingActivity", 2, "alertDialogWithRetCode  " + paramInt + " " + paramString);
      paramQQAppInterface = new npx(this, paramQQAppInterface, paramBoolean, paramInt);
      if ((paramBoolean) || ((paramInt != 104) && (paramInt != 105) && (paramInt != 106) && (paramInt != 114))) {
        break label247;
      }
      localQQCustomDialog.setPositiveButton(2131690466, paramQQAppInterface);
      localQQCustomDialog.setNegativeButton(2131690697, paramQQAppInterface);
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
      str = nqi.a(paramBoolean, paramActivity, paramInt, paramLong, paramString);
      paramActivity = nqi.a(paramActivity, paramInt);
      break;
      label247:
      localQQCustomDialog.setNegativeButton(2131690469, paramQQAppInterface);
    }
    label260:
    QLog.e("AvGameManagerAvGameLoadingActivity", 2, "alertDialogWithRetCode null");
    if (paramBoolean) {}
    for (int i = -102;; i = -103)
    {
      AVGameNodeReportUtil.b(i);
      a(false, paramInt);
      return;
    }
  }
  
  void a(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = true;
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
    this.jdField_e_of_type_Boolean = false;
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
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
      do
      {
        do
        {
          do
          {
            return false;
            QQToast.a(BaseApplicationImpl.getApplication(), 0, BaseApplicationImpl.getApplication().getString(2131690422), 0).a();
          } while (getActivity() == null);
          AVGameNodeReportUtil.b(-101);
          getActivity().finish();
          return false;
        } while (!isAdded());
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131690325, new Object[] { Integer.valueOf(paramMessage.arg1) }));
        return false;
        a();
        return false;
        if (isAdded())
        {
          long l = System.currentTimeMillis() % 5L;
          if (this.jdField_a_of_type_Int + (int)l < 100)
          {
            int i = this.jdField_a_of_type_Int;
            this.jdField_a_of_type_Int = ((int)l + i);
            this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131690325, new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
          }
        }
        f();
        return false;
        i();
        return false;
      } while ((!isAdded()) || (!(paramMessage.obj instanceof LottieDrawable)));
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = ((LottieDrawable)paramMessage.obj);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.pauseAnimation();
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
      return false;
    case 7: 
      a(false);
      return false;
    case 8: 
      a(true);
      return false;
    }
    QLog.d("AvGameManagerAvGameLoadingActivity", 2, "stranger match timeout");
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = true;
    a(null, getString(2131690382), getString(2131690469), new npw(this), null, null);
    return false;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.setTheme(2131755470);
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
    if (this.jdField_e_of_type_Boolean)
    {
      QLog.d("AvGameManagerAvGameLoadingActivity", 2, "mExitBtn " + this.jdField_d_of_type_JavaLangString);
      bdla.b(null, "dc00898", "", "", "0X800B042", "0X800B042", 0, 0, "", "", "", "");
      if (this.jdField_d_of_type_JavaLangString != null) {
        a(nqi.a(this.jdField_d_of_type_JavaLangString));
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
    nqc.a().a("param_StepEntrance", 0);
    if (ImmersiveUtils.c()) {
      ImmersiveUtils.a(false, getActivity().getWindow());
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
    d();
    this.jdField_a_of_type_Nol = nol.a(paramBundle);
    if ((this.jdField_a_of_type_Nol != null) && ("MsgPush".equals(this.jdField_a_of_type_Nol.jdField_a_of_type_JavaLangString))) {
      bdla.b(null, "dc00898", "", "", "0X800B245", "0X800B245", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.addObserver(this.jdField_a_of_type_Ndm);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.avgame.ui.AvGameLoadingActivity.ACTION_LOADING_FINISH");
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    AVGameUtilService.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, true);
    AVGameNodeReportUtil.a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.inflate(2131558723, null));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379889));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363193));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369453));
    this.jdField_a_of_type_ComTencentAvgameUiCasualTips = ((CasualTips)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378977));
    if (this.jdField_a_of_type_ComTencentAvgameUiCasualTips != null)
    {
      m();
      this.jdField_a_of_type_ComTencentAvgameUiCasualTips.setTipsString(this.jdField_a_of_type_JavaUtilArrayList);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131690325, new Object[] { Integer.valueOf(0) }));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(new npt(this));
    paramLayoutInflater = (nqg)aqxe.a().a(642);
    if (paramLayoutInflater != null) {}
    for (int i = paramLayoutInflater.b();; i = 0)
    {
      if (i == 0) {
        a(true);
      }
      for (;;)
      {
        nhu.a(getActivity(), "avgame_loading/data.json", "avgame_loading/images/", 27, 9, -1, new npu(this));
        paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
        V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
        return paramLayoutInflater;
        b();
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(8, i * 1000);
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.removeObserver(this.jdField_a_of_type_Ndm);
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
    if (this.jdField_a_of_type_Ngl != null) {
      this.jdField_a_of_type_Ngl.a();
    }
    super.onDestroy();
  }
  
  public void onFinish()
  {
    super.onFinish();
    getActivity().overridePendingTransition(2130772106, 2130772106);
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
    getActivity().overridePendingTransition(2130772106, 2130772106);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    nqc.a().a("param_StepSecure");
    nqc.a().a("param_StepSecure", 0);
    c();
    if (DeviceInfoUtil.isLowPerfDevice()) {
      this.jdField_f_of_type_Int = 8000;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.ui.AvGameLoadingActivity
 * JD-Core Version:    0.7.0.1
 */