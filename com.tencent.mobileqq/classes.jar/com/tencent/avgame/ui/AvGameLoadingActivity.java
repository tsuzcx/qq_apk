package com.tencent.avgame.ui;

import aevv;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
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
import aqlk;
import aqnx;
import bcst;
import bgln;
import bglp;
import bgpa;
import bies;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.ipc.AVGameUtilService;
import com.tencent.avgame.util.AVGameNodeReportUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.widget.AutoBgImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.ArrayList;
import mwn;
import mwq;
import myr;
import myu;
import mzt;
import nfl;
import nfm;
import nfn;
import nfo;
import nfp;
import nfq;
import nfu;
import nfy;
import nga;

public class AvGameLoadingActivity
  extends PublicBaseFragment
  implements Handler.Callback
{
  public int a;
  private long jdField_a_of_type_Long;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new nfl(this);
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
  private mwq jdField_a_of_type_Mwq = new nfm(this);
  myr jdField_a_of_type_Myr;
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
  private boolean jdField_d_of_type_Boolean = true;
  private int jdField_e_of_type_Int = 1;
  private String jdField_e_of_type_JavaLangString;
  private int f = 3000;
  
  public AvGameLoadingActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 2;
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
    mwn localmwn;
    do
    {
      return;
      localmwn = (mwn)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.a(178);
    } while (localmwn == null);
    localmwn.a(paramInt, paramString, this.jdField_a_of_type_Long, this.jdField_e_of_type_Int);
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {
      QLog.e("AvGameManagerAvGameLoadingActivity", 1, "joinAvGameRoom activity finish");
    }
    mwn localmwn;
    do
    {
      return;
      if (TextUtils.isEmpty(paramString1))
      {
        QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131690362, 0).a();
        QLog.e("AvGameManagerAvGameLoadingActivity", 1, "joinAvGameRoom with empty roomId!!");
        AVGameNodeReportUtil.b(-103);
        i();
        return;
      }
      localmwn = (mwn)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.a(178);
    } while (localmwn == null);
    localmwn.a(paramInt, paramString1, paramString2, this.jdField_a_of_type_Long);
  }
  
  private void a(long paramLong)
  {
    if (paramLong != 0L)
    {
      mwn localmwn = (mwn)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.a(178);
      if (localmwn != null) {
        localmwn.a(paramLong);
      }
    }
    QLog.d("AvGameManagerAvGameLoadingActivity", 2, "exitRoom " + paramLong);
  }
  
  private void a(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong1, long paramLong2)
  {
    QLog.d("AvGameManagerAvGameLoadingActivity", 2, "handleProtoEnterResult  bCreate:" + paramBoolean + " ret code " + paramInt);
    nfu.a().a("param_StepRoomProto", 0);
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
          d();
          if (!this.jdField_c_of_type_Boolean) {
            break label501;
          }
          if (paramInt != 0) {
            break label446;
          }
          bcst.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B018", "0X800B018", this.jdField_d_of_type_Int, 0, "", this.jdField_d_of_type_JavaLangString, "", "");
          if (this.jdField_d_of_type_Int == 4) {
            bcst.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B06C", "0X800B06C", this.jdField_e_of_type_Int, 0, "", this.jdField_d_of_type_JavaLangString, "", "");
          }
          label263:
          if (i == 0)
          {
            QLog.e("AvGameManagerAvGameLoadingActivity", 2, "handleProtoEnterResult !bHandled bCreate:" + paramBoolean);
            if (!paramBoolean) {
              break label600;
            }
          }
        }
      }
    }
    label446:
    label600:
    for (paramInt = -102;; paramInt = -103)
    {
      AVGameNodeReportUtil.b(paramInt);
      i();
      return;
      QLog.e("AvGameManagerAvGameLoadingActivity", 2, "handleProtoEnterResult  ENTER WITH null activity bCreate:" + paramBoolean);
      break;
      if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
      {
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
      bcst.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B019", "0X800B019", this.jdField_d_of_type_Int, 0, paramInt + "", "", "", "");
      break label263;
      label501:
      if (paramInt == 0)
      {
        bcst.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B026", "0X800B026", this.jdField_d_of_type_Int, 0, "", this.jdField_d_of_type_JavaLangString, "", "");
        break label263;
      }
      bcst.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B027", "0X800B027", this.jdField_d_of_type_Int, 0, paramInt + "", "", "", "");
      break label263;
    }
  }
  
  public static void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    nfu.a().a("param_StepLoading");
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.setFlags(268435456);
    localIntent.putExtra("key_bCreate", paramBoolean);
    localIntent.putExtra("key_fromType", paramInt1);
    localIntent.putExtra("key_peerUin", paramString1);
    localIntent.putExtra("key_roomId", paramString2);
    localIntent.putExtra("key_game_type", paramInt2);
    bies.a(BaseApplicationImpl.getContext(), 56, 2);
    aevv.a(localIntent, PublicFragmentActivity.class, AvGameLoadingActivity.class);
    QLog.e("AvGameManagerAvGameLoadingActivity", 2, " beCreate" + paramBoolean + " fromType" + paramInt1 + " roomId" + paramString2 + " peer" + paramString1 + "gt" + paramInt2);
  }
  
  public static void a(boolean paramBoolean, Activity paramActivity, byte[] paramArrayOfByte, String paramString1, RoomInfo paramRoomInfo, String paramString2)
  {
    if (paramActivity == null)
    {
      QLog.e("AvGameManagerAvGameLoadingActivity", 1, "enterAvGameActivity with empty activity");
      return;
    }
    nfu.a().a("param_StepPrepareGame");
    Intent localIntent = new Intent(paramActivity, AVGameActivity.class);
    if (paramString1 != null)
    {
      localIntent.putExtra("key_room_id", paramString1);
      QLog.e("AvGameManagerAvGameLoadingActivity", 1, "enterAvGameActivity roomId " + paramString1 + "be New:" + paramBoolean);
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
      localIntent.putExtra("key_room_be_new_enter", paramBoolean);
      if (paramString2 != null) {
        localIntent.putExtra("key_room_friend_uin", paramString2);
      }
      QLog.e("AvGameManagerAvGameLoadingActivity", 1, "enterAvGameActivity startActivity    current time:" + System.currentTimeMillis() + " bNewEnter: " + paramBoolean);
      localIntent.putExtra("key_start_time", SystemClock.elapsedRealtime());
      AVGameNodeReportUtil.a(localIntent);
      nfu.a().b(localIntent);
      paramActivity.startActivity(localIntent);
      paramActivity.overridePendingTransition(2130772100, 2130772100);
      return;
      QLog.e("AvGameManagerAvGameLoadingActivity", 1, "enterAvGameActivity roomId empty  be New:" + paramBoolean);
    }
  }
  
  private void c()
  {
    nfu.a().a("param_StepResource");
    this.jdField_a_of_type_Myr = new myr(getActivity().getAppInterface());
    this.jdField_a_of_type_Myr.a(new myu(aqnx.a().a(), aqnx.a().b()), new nfp(this));
  }
  
  private void d()
  {
    nfu.a().a("param_StepAvAlive");
    if (!AVGameUtilService.a())
    {
      QLog.d("AvGameManagerAvGameLoadingActivity", 2, "preStartAvGameActivity  isAVGameAlive false ");
      f();
      return;
    }
    QLog.d("AvGameManagerAvGameLoadingActivity", 2, "preStartAvGameActivity  isAVGameAlive true ");
    h();
  }
  
  private void e()
  {
    if (AVGameUtilService.a())
    {
      QLog.d("AvGameManagerAvGameLoadingActivity", 2, "checkAvGameProcessReady live ");
      h();
      return;
    }
    QLog.d("AvGameManagerAvGameLoadingActivity", 2, "checkAvGameProcessReady not  live send  MSG_CHECK_AV_GAME_PROCESS_READY");
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 1000L);
  }
  
  private void f()
  {
    QLog.d("AvGameManagerAvGameLoadingActivity", 2, "startWaitProcessReady ");
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 1000L);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 15000L);
  }
  
  private void g()
  {
    QLog.d("AvGameManagerAvGameLoadingActivity", 2, "stopWaitProcessReady ");
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(8);
  }
  
  private void h()
  {
    QLog.d("AvGameManagerAvGameLoadingActivity", 2, "DoEnterActivity ");
    a(100);
    g();
    b();
    nfu.a().a("param_StepAvAlive", 0);
    a(true, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ArrayOfByte, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvgameGamelogicDataRoomInfo, this.jdField_a_of_type_JavaLangString);
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(7, this.f);
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
  }
  
  private void j()
  {
    nfu.a().a("param_StepResource", 0);
    if (this.jdField_a_of_type_Int <= 100 / this.jdField_b_of_type_Int) {
      this.jdField_a_of_type_Int = (100 / this.jdField_b_of_type_Int + (int)System.currentTimeMillis() % 5);
    }
    a(this.jdField_a_of_type_Int);
    ThreadManager.getUIHandlerV2().postDelayed(new AvGameLoadingActivity.7(this), 150L);
  }
  
  private void k()
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext().getString(2131690294));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext().getString(2131690296));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext().getString(2131690297));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext().getString(2131690298));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext().getString(2131690299));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext().getString(2131690300));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext().getString(2131690301));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext().getString(2131690302));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext().getString(2131690303));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext().getString(2131690295));
  }
  
  public void a()
  {
    if (getActivity() != null)
    {
      nfu.a().a(2);
      getActivity().superFinish();
      getActivity().overridePendingTransition(2130772100, 2130772100);
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
      paramActivity = paramActivity.getBaseContext().getString(2131690358);
      QQToast.a(paramQQAppInterface.getApp().getBaseContext(), paramActivity, 0).a();
      return;
    }
    Object localObject = null;
    bgpa localbgpa = bglp.a(paramActivity, 230);
    String str;
    if (paramBoolean)
    {
      str = nga.a(paramBoolean, paramActivity, paramInt, paramLong, paramString);
      paramActivity = localObject;
      AVGameNodeReportUtil.a(paramInt);
      if (localbgpa == null) {
        break label286;
      }
      QLog.d("AvGameManagerAvGameLoadingActivity", 2, "alertDialogWithRetCode  " + paramInt + " " + paramString);
      paramQQAppInterface = new nfq(this, paramQQAppInterface, paramBoolean);
      if ((paramBoolean) || ((paramInt != 104) && (paramInt != 105) && (paramInt != 106) && (paramInt != 114))) {
        break label273;
      }
      localbgpa.setPositiveButton(2131690356, paramQQAppInterface);
      localbgpa.setNegativeButton(2131690582, paramQQAppInterface);
    }
    for (;;)
    {
      localbgpa.setCancelable(false);
      localbgpa.setMessage(str);
      if (paramActivity != null) {
        localbgpa.setTitle(paramActivity);
      }
      localbgpa.show();
      return;
      str = nga.a(paramBoolean, paramActivity, paramInt, paramLong, paramString);
      paramActivity = nga.a(paramActivity, paramInt);
      break;
      label273:
      localbgpa.setNegativeButton(2131690359, paramQQAppInterface);
    }
    label286:
    QLog.e("AvGameManagerAvGameLoadingActivity", 2, "alertDialogWithRetCode null");
    if (paramBoolean) {}
    for (paramInt = -102;; paramInt = -103)
    {
      AVGameNodeReportUtil.b(paramInt);
      i();
      return;
    }
  }
  
  void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = true;
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
    this.jdField_d_of_type_Boolean = false;
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
            QQToast.a(BaseApplicationImpl.getApplication(), 0, BaseApplicationImpl.getApplication().getString(2131690326), 0).a();
          } while (getActivity() == null);
          AVGameNodeReportUtil.b(-101);
          getActivity().finish();
          return false;
        } while (!isAdded());
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131690254, new Object[] { Integer.valueOf(paramMessage.arg1) }));
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
            this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131690254, new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
          }
        }
        e();
        return false;
        h();
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
    }
    a(true);
    return false;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.setTheme(2131755466);
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
    if (this.jdField_d_of_type_Boolean)
    {
      QLog.d("AvGameManagerAvGameLoadingActivity", 2, "mExitBtn " + this.jdField_d_of_type_JavaLangString);
      bcst.b(null, "dc00898", "", "", "0X800B042", "0X800B042", 0, 0, "", "", "", "");
      if (this.jdField_d_of_type_JavaLangString != null) {
        a(nga.a(this.jdField_d_of_type_JavaLangString));
      }
      AVGameNodeReportUtil.b(1);
      i();
      return super.onBackEvent();
    }
    QLog.d("AvGameManagerAvGameLoadingActivity", 2, "bExitEnable not ");
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    nfu.a().a("param_StepEntrance", 0);
    paramBundle = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    if (paramBundle == null)
    {
      i();
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
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.addObserver(this.jdField_a_of_type_Mwq);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.avgame.ui.AvGameLoadingActivity.ACTION_LOADING_FINISH");
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    AVGameUtilService.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, true);
    AVGameNodeReportUtil.a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.inflate(2131558704, null));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379621));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363134));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369179));
    this.jdField_a_of_type_ComTencentAvgameUiCasualTips = ((CasualTips)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378752));
    if (this.jdField_a_of_type_ComTencentAvgameUiCasualTips != null)
    {
      k();
      this.jdField_a_of_type_ComTencentAvgameUiCasualTips.setTipsString(this.jdField_a_of_type_JavaUtilArrayList);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131690254, new Object[] { Integer.valueOf(0) }));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(new nfn(this));
    paramLayoutInflater = (nfy)aqlk.a().a(642);
    if (paramLayoutInflater != null) {}
    for (int i = paramLayoutInflater.b();; i = 0)
    {
      if (i == 0) {
        a(true);
      }
      for (;;)
      {
        mzt.a(getActivity(), "avgame_loading/data.json", "avgame_loading/images/", 27, 9, -1, new nfo(this));
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
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.removeObserver(this.jdField_a_of_type_Mwq);
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
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
    if (this.jdField_a_of_type_Myr != null) {
      this.jdField_a_of_type_Myr.a();
    }
    super.onDestroy();
  }
  
  public void onFinish()
  {
    super.onFinish();
    getActivity().overridePendingTransition(2130772100, 2130772100);
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
    getActivity().overridePendingTransition(2130772100, 2130772100);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    nfu.a().a("param_StepSecure");
    nfu.a().a("param_StepSecure", 0);
    c();
    if (bgln.g()) {
      this.f = 8000;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.ui.AvGameLoadingActivity
 * JD-Core Version:    0.7.0.1
 */