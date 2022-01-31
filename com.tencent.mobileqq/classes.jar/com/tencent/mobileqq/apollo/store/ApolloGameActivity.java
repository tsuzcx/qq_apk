package com.tencent.mobileqq.apollo.store;

import aciy;
import aikb;
import aikz;
import ailm;
import ailv;
import aiml;
import aing;
import aioy;
import aipj;
import aips;
import aire;
import airm;
import aisz;
import aita;
import aitb;
import aitc;
import aite;
import aitf;
import aitg;
import aith;
import aiti;
import aitj;
import aitk;
import aitl;
import aivc;
import aiys;
import ajab;
import ajed;
import ajjy;
import anad;
import android.annotation.TargetApi;
import android.app.ActivityManager.TaskDescription;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.text.TextUtils;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anfc;
import awrn;
import awuw;
import babp;
import babr;
import bacm;
import badq;
import bafb;
import bajr;
import batm;
import bato;
import bbmy;
import bbth;
import befq;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.data.CmGamePushItem;
import com.tencent.mobileqq.apollo.debug.CmGameDebugView;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.apollo.game.WebGameFakeView;
import com.tencent.mobileqq.apollo.lightGame.CmGameLoadingView;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.process.ui.framework.CmGameFloatView;
import com.tencent.mobileqq.apollo.process.ui.framework.FrameworkView;
import com.tencent.mobileqq.apollo.process.ui.framework.QzoneGameFloatView;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import mjg;
import org.json.JSONObject;

public class ApolloGameActivity
  extends FragmentActivity
  implements ailv, Handler.Callback, View.OnClickListener, Observer
{
  public static int a;
  public static final String a;
  private long jdField_a_of_type_Long;
  private aipj jdField_a_of_type_Aipj;
  private airm jdField_a_of_type_Airm;
  private aitl jdField_a_of_type_Aitl;
  private anad jdField_a_of_type_Anad = new aitg(this);
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private bafb jdField_a_of_type_Bafb;
  private befq jdField_a_of_type_Befq = new befq(Looper.getMainLooper(), this);
  private CmGameStartChecker.StartCheckParam jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam;
  private CmGameStartChecker jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker;
  private CmGameDebugView jdField_a_of_type_ComTencentMobileqqApolloDebugCmGameDebugView;
  private WebGameFakeView jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView;
  private CmGameLoadingView jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView;
  private FrameworkView jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ApolloGameActivity.1(this);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private bafb jdField_b_of_type_Bafb;
  public String b;
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int;
  private bafb jdField_c_of_type_Bafb;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private bafb jdField_d_of_type_Bafb;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajed.aT + "/QQ_Screenshot/cmshow_game_splash.png";
  }
  
  public ApolloGameActivity()
  {
    this.jdField_b_of_type_JavaLangString = "cmgame_process.ApolloGameActivity";
  }
  
  private CmGameStartChecker.StartCheckParam a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    try
    {
      paramIntent = (CmGameStartChecker.StartCheckParam)paramIntent.getSerializableExtra("extra_startcheckparam");
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 1, paramIntent, new Object[0]);
    }
    return null;
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mLoadingOnMainProcess) && (ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam)))
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_b_of_type_JavaLangString, 1, new Object[] { "game is cancel mStartCheckParam:", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId) });
      }
      i();
      finish();
      if (QLog.isColorLevel()) {}
      return true;
    }
    return false;
  }
  
  private void b(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (paramStartCheckParam == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131309745));
    if (!paramStartCheckParam.mLoadingOnMainProcess)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView = CmGameLoadingView.a(this, this.g);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView, new RelativeLayout.LayoutParams(-1, -1));
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView.a(paramStartCheckParam);
      return;
    }
    QLog.i(this.jdField_b_of_type_JavaLangString, 1, "initView mLoadingOnMainProcess:true");
  }
  
  private void b(CmGameInitParams paramCmGameInitParams)
  {
    if (paramCmGameInitParams == null) {
      return;
    }
    if ((paramCmGameInitParams.commFlag & 0x2) == 2)
    {
      Message localMessage = this.jdField_a_of_type_Befq.obtainMessage(107);
      localMessage.arg1 = 1;
      localMessage.obj = new Pair(paramCmGameInitParams.rpUrl, paramCmGameInitParams.rpIconUrl);
      this.jdField_a_of_type_Befq.sendMessage(localMessage);
      return;
    }
    paramCmGameInitParams = this.jdField_a_of_type_Befq.obtainMessage(107);
    paramCmGameInitParams.arg1 = 0;
    this.jdField_a_of_type_Befq.sendMessage(paramCmGameInitParams);
  }
  
  private void d(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {
      return;
    }
    ailm.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    long l1;
    long l2;
    long l3;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap != null)
    {
      l1 = SystemClock.uptimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.put("game_loading_create_time", Long.valueOf(l1));
      if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.containsKey("game_launch_time"))
      {
        l2 = ((Long)this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.get("game_launch_time")).longValue();
        if ((l2 <= 0L) || (l2 != aing.c)) {
          break label510;
        }
        l3 = l1 - l2;
        if (l3 <= 0L) {
          break label416;
        }
        localObject = "cmgame_loading_ui_launch_time";
        if (l3 >= 10000L)
        {
          localObject = "cmgame_loading_ui_launch_time_exception";
          this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.clear();
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_gameId", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId));
        localHashMap.put("param_src", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.src));
        awrn.a(BaseApplicationImpl.getContext()).a(getCurrentAccountUin(), (String)localObject, true, l3, 0L, localHashMap, "", false);
        QLog.d("CmGameStat", 1, new Object[] { localObject, ", duration=", Long.valueOf(l3), ", launchTime=", Long.valueOf(l2), ", createTime=", Long.valueOf(l1), " [gameId=", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), "]" });
      }
    }
    for (;;)
    {
      paramLong = SystemClock.uptimeMillis() - paramLong;
      QLog.d("CmGameStat", 1, new Object[] { "cmgame_game_activity_create, duration=", Long.valueOf(paramLong), " [gameId=", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), "]" });
      if (paramLong <= 0L) {
        break;
      }
      localObject = new HashMap();
      ((HashMap)localObject).put("param_gameId", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId));
      awrn.a(BaseApplicationImpl.getContext()).a(getCurrentAccountUin(), "cmgame_game_activity_create", true, paramLong, 0L, (HashMap)localObject, "", false);
      return;
      label416:
      QLog.d("CmGameStat", 1, new Object[] { "cmgame_loading_ui_launch_time, invalid duration=", Long.valueOf(l3), ", receiveTime=", Long.valueOf(l2), ", createTime=", Long.valueOf(l1), " [gameId=", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), "]" });
      this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.clear();
      continue;
      label510:
      this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.clear();
      QLog.d("CmGameStat", 1, new Object[] { "invalid receiveTime=", Long.valueOf(l2), ", sLaunchGameTs=", Long.valueOf(aing.c), " [gameId=", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), "]" });
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {
      break label7;
    }
    label7:
    while (a()) {
      return;
    }
    long l = SystemClock.uptimeMillis();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.isGameRscExist)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType != 1) {
        break label234;
      }
      if (this.jdField_a_of_type_Aipj != null) {
        this.jdField_a_of_type_Aipj.a(this, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.isEnableMSAA);
      }
    }
    label62:
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView = aire.a(this, this.jdField_a_of_type_Aipj, this.jdField_a_of_type_Befq, this, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    if (aikb.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam)) {
      b(true);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.pushItem == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.pushItem.is_show_red == 0)) {}
    for (int i = 0;; i = 1)
    {
      bajr.a(null, "cmshow", "Apollo", "exposureUniversialFrameShareButton", 0, 0, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), String.valueOf(i) });
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, new Object[] { " onCreate_doInitGameUI cost time:" + (SystemClock.uptimeMillis() - l), ",isGameRscExist:", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.isGameRscExist) });
      return;
      label234:
      r();
      break label62;
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {}
    AppInterface localAppInterface;
    do
    {
      do
      {
        return;
        int i = jdField_a_of_type_Int + 1;
        jdField_a_of_type_Int = i;
        this.jdField_d_of_type_Int = i;
        this.jdField_a_of_type_Aipj = aing.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, this.jdField_d_of_type_Int);
        if (this.jdField_a_of_type_Aipj != null)
        {
          this.jdField_a_of_type_Aipj.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
          this.jdField_a_of_type_Aipj.a(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.requestCode = System.currentTimeMillis();
        localAppInterface = aing.a();
        if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mLoadingOnMainProcess) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker = new CmGameStartChecker(localAppInterface);
        this.jdField_a_of_type_Aitl = new aitl(this, localAppInterface);
      } while (localAppInterface == null);
      if ((!badq.d(this)) && (!aing.b(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam))) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam, this.jdField_a_of_type_Aitl);
    } while (aing.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam));
    aiml.a(localAppInterface, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, "android.subgame", new aith(this));
    return;
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "[onCreate] no net");
    this.jdField_a_of_type_Befq.sendEmptyMessageDelayed(113, 1000L);
    return;
    QLog.i(this.jdField_b_of_type_JavaLangString, 1, "onCreate_doInitLaunchData mLoadingOnMainProcess:true");
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {}
    long l;
    do
    {
      return;
      l = SystemClock.uptimeMillis();
      String str1 = ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);
      if (TextUtils.isEmpty(aing.a(str1)))
      {
        String str2 = aivc.a(new File(str1));
        if (!TextUtils.isEmpty(str2)) {
          aing.b(str1, str2);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, " onCreate_doInitGameJs cost time:" + (SystemClock.uptimeMillis() - l));
  }
  
  private void o()
  {
    this.g = true;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.viewMode == 1)
    {
      this.g = false;
      super.setRequestedOrientation(8);
      if (!this.g) {
        break label139;
      }
    }
    label139:
    for (int i = 1;; i = 2)
    {
      this.jdField_c_of_type_Int = i;
      this.jdField_a_of_type_Long = babp.a(true);
      this.jdField_b_of_type_Long = babp.j();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, new Object[] { "onCreate_doActivityInfo mLastScreenWidth:", Long.valueOf(this.jdField_a_of_type_Long), ",mLastScrrenHeight:", Long.valueOf(this.jdField_b_of_type_Long) });
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.viewMode == 2)
      {
        this.g = false;
        super.setRequestedOrientation(0);
        break;
      }
      super.setRequestedOrientation(1);
      break;
    }
  }
  
  private void p()
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(this).inflate(2131492900, null));
    super.setContentView(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
    b(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.src == 319) || (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.src == 318)) {
      k();
    }
    aing.a(1, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam, this.jdField_d_of_type_Int);
    anfc.a().a(this.jdField_a_of_type_Anad);
    if (!anfc.a().a()) {
      anfc.a().a().doBindService(getApplicationContext());
    }
    aips localaips = aing.a();
    if (localaips != null) {
      localaips.a(this, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    }
    ThreadManagerV2.excute(new ApolloGameActivity.5(this), 128, null, false);
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mLoadingOnMainProcess) && (this.jdField_a_of_type_Aipj != null)) {
      this.jdField_a_of_type_Aipj.j();
    }
    a();
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType == 1) || (this.f)) {
      return;
    }
    QQBrowserActivity.jdField_c_of_type_Int += 1;
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.setStatusColor(-1);
      this.mSystemBarComp.setStatusBarColor(-1);
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("session_uin", this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.sessionUin);
    localBundle.putSerializable("game_init", this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView = new WebGameFakeView(getWindow(), localBundle);
    this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView.jdField_b_of_type_Boolean = true;
    this.f = true;
  }
  
  private void s()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType != 1))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.viewMode == 1) {
        super.setRequestedOrientation(8);
      }
    }
    else {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.viewMode == 2)
    {
      super.setRequestedOrientation(0);
      return;
    }
    super.setRequestedOrientation(1);
  }
  
  private void t()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) || (!this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.showAlertTips)) {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "checkShowMsgAlert mStartCheckParam == null || !mStartCheckParam.showAlertTips");
      }
    }
    while (this.e) {
      return;
    }
    this.e = true;
    String str = "";
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.msgGameStatus == 2) {
      str = ajjy.a(2131634577);
    }
    for (;;)
    {
      if (this.jdField_d_of_type_Bafb == null) {
        this.jdField_d_of_type_Bafb = babr.a(this, 0, null, str, 2131629116, 2131625035, null, new aitb(this));
      }
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_d_of_type_Bafb.setMessage(str);
        this.jdField_d_of_type_Bafb.show();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, new Object[] { "checkShowMsgAlert msgText:", str });
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.msgGameStatus == 3) {
        str = ajjy.a(2131634564);
      } else if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.msgGameStatus == 4) || (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.msgGameStatus == 5) || (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.msgGameStatus == 6) || (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.msgGameStatus == 7) || (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.msgGameStatus == 8)) {
        str = ajjy.a(2131634587);
      }
    }
  }
  
  private void u()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mLoadingOnMainProcess) && (!this.h))
    {
      Bundle localBundle = new Bundle();
      localBundle.putSerializable("StartCheckParam", this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
      QIPCClientHelper.getInstance().callServer("cm_game_module", "action_on_game_activity_closed", localBundle, null);
      this.h = true;
    }
  }
  
  public airm a()
  {
    return this.jdField_a_of_type_Airm;
  }
  
  public Bitmap a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      return this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    return null;
  }
  
  public CmGameStartChecker.StartCheckParam a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam;
  }
  
  public WebGameFakeView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView.d();
    }
  }
  
  public void a(int paramInt)
  {
    this.mNeedStatusTrans = true;
    setImmersiveStatus(0);
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.setStatusColor(paramInt);
      this.mSystemBarComp.setStatusBarColor(paramInt);
    }
  }
  
  public void a(int paramInt, Intent paramIntent, String paramString, Bitmap paramBitmap, ajab paramajab)
  {
    String str = String.format(ajjy.a(2131634540), new Object[] { paramString });
    if (this.jdField_a_of_type_Bafb == null)
    {
      this.jdField_a_of_type_Bafb = babr.a(this, 0, 2131493331, ajjy.a(2131634547), str, ajjy.a(2131634589), ajjy.a(2131634574), new aitc(this, paramIntent, paramString, paramBitmap, paramajab, paramInt), new aite(this, paramajab, paramInt));
      this.jdField_a_of_type_Bafb.setPreviewImage(new BitmapDrawable(paramBitmap), true, 1);
      this.jdField_a_of_type_Bafb.show();
      return;
    }
    this.jdField_a_of_type_Bafb.setMessage(str);
    this.jdField_a_of_type_Bafb.setPreviewImage(new BitmapDrawable(paramBitmap), true, 1);
    this.jdField_a_of_type_Bafb.show();
  }
  
  public void a(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (paramLong > 0L))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_gameId", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId));
      awrn.a(getAppInterface().getApp()).a(getCurrentAccountUin(), "cmgame_game_view_create_time", true, paramLong, 0L, localHashMap, "", false);
      QLog.d("CmGameStat", 1, new Object[] { "cmgame_game_view_create_time, duration=", Long.valueOf(paramLong), " [gameId=", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), "]" });
    }
  }
  
  public void a(Intent paramIntent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType == 3)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView.a(paramIntent);
    }
    a(true);
  }
  
  public void a(ApolloSurfaceView paramApolloSurfaceView)
  {
    ((FrameLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131301332)).addView(paramApolloSurfaceView, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if ((paramStartCheckParam == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null)) {
      return;
    }
    paramStartCheckParam.statMap = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap;
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = paramStartCheckParam;
  }
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView.b(paramStartCheckParam, paramInt);
    }
  }
  
  public void a(CmGameInitParams paramCmGameInitParams)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) || (paramCmGameInitParams == null)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.openId = paramCmGameInitParams.openId;
      paramCmGameInitParams.mIsEnableMSAA = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.isEnableMSAA;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mLoadingOnMainProcess)
      {
        aips localaips = aing.a();
        if (localaips != null) {
          localaips.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, paramCmGameInitParams.mSSORule);
        }
        aifg.jdField_b_of_type_JavaLangString = paramCmGameInitParams.apolloGameSt;
        aifg.c = paramCmGameInitParams.apolloGameStkey;
      }
      b(paramCmGameInitParams);
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (this.jdField_a_of_type_Aipj != null)) {
        this.jdField_a_of_type_Aipj.a(this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      aing.a(new Object[] { "[startGame], gameType:", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType) });
      if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType != 1) {
        break;
      }
    } while (this.jdField_a_of_type_Aipj == null);
    this.jdField_a_of_type_Aipj.a(this, paramCmGameInitParams);
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.startCallEngine = System.currentTimeMillis();
    return;
    if (this.jdField_a_of_type_Aipj != null) {
      this.jdField_a_of_type_Aipj.b(this, paramCmGameInitParams);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType == 5) && (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView != null) && (!(this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView instanceof QzoneGameFloatView)) && (this.jdField_a_of_type_Befq != null)) {
      this.jdField_a_of_type_Befq.post(this.jdField_a_of_type_JavaLangRunnable);
    }
    r();
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView != null) && ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView instanceof QzoneGameFloatView)) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType == 5)) {
      ((QzoneGameFloatView)this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView).setFrameViewStyle(a());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView != null) {
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView.jdField_a_of_type_ComTencentMobileqqApolloGameApolloFragment == null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType != 1)) {
          ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam, this, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, null, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType, this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.extendJson);
        }
        for (;;)
        {
          if (aing.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam)) {
            this.jdField_a_of_type_Befq.sendEmptyMessage(109);
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView.a(paramCmGameInitParams);
          a(true, 50L);
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mUpdated) {
            ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam, this, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView.jdField_a_of_type_ComTencentMobileqqApolloGameApolloFragment, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType, this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.extendJson);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e(this.jdField_b_of_type_JavaLangString, 1, localThrowable, new Object[0]);
        }
      }
    }
    QLog.e(this.jdField_b_of_type_JavaLangString, 1, "startGame but mWebGameFakeView is null, finish it!");
    finish();
  }
  
  public void a(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 110;
    localMessage.obj = paramString;
    this.jdField_a_of_type_Befq.removeMessages(110);
    this.jdField_a_of_type_Befq.sendMessage(localMessage);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aipj != null) {
      this.jdField_a_of_type_Aipj.b(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, new Object[] { "[dismissLoadingPage] delayTime：", Long.valueOf(paramLong) });
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView.a(paramBoolean);
    }
    this.jdField_a_of_type_Befq.removeMessages(103);
    this.jdField_a_of_type_Befq.sendEmptyMessageDelayed(103, paramLong);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView instanceof CmGameFloatView)) {
      ((CmGameFloatView)this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView).a(paramBoolean, paramString);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView instanceof CmGameFloatView)) {
      ((CmGameFloatView)this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView).a(paramBoolean1, paramBoolean2, paramString);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView.c();
    }
  }
  
  public void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, new Object[] { "[onReadGameMainJs] duration=", Long.valueOf(paramLong) });
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (paramLong >= 0L))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_gameId", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId));
      awrn.a(getAppInterface().getApp()).a(getCurrentAccountUin(), "cmgame_game_mainjs_read_time", true, paramLong, 0L, localHashMap, "", false);
      QLog.d("CmGameStat", 1, new Object[] { "cmgame_game_mainjs_read_time, duration=", Long.valueOf(paramLong), " [gameId=", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), "]" });
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloDebugCmGameDebugView == null)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloDebugCmGameDebugView == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloDebugCmGameDebugView = ((CmGameDebugView)aire.a(this, this.jdField_a_of_type_Aipj, this.jdField_a_of_type_Befq, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam, 2));
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloDebugCmGameDebugView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloDebugCmGameDebugView.setVisibility(8);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView.b();
    }
  }
  
  public void c(long paramLong)
  {
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, new Object[] { "[onExeJsEnd] duration=", Long.valueOf(paramLong) });
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.put("exe_js_end_time", Long.valueOf(SystemClock.uptimeMillis()));
      }
      if (paramLong >= 0L)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_gameId", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId));
        localHashMap.put("param_src", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.src));
        awrn.a(getAppInterface().getApp()).a(getCurrentAccountUin(), "cmgame_exe_js_time", true, paramLong, 0L, localHashMap, "", false);
        aing.a(new Object[] { "[executeJs], done cost:", Long.valueOf(paramLong) });
        QLog.d("CmGameStat", 1, new Object[] { "cmgame_exe_js_time, duration=", Long.valueOf(paramLong), " [gameId=", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), "]" });
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView.a();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView.e();
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "[doOnActivityResult], resultCode:" + paramInt2);
    }
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      do
      {
        return;
        if (paramIntent == null) {
          break;
        }
      } while (awuw.a(paramIntent.getByteArrayExtra("stuctmsg_bytes")) == null);
      paramIntent.getStringExtra("uin");
      int i = paramIntent.getIntExtra("uintype", -1);
      int j = paramIntent.getIntExtra("cmshow_game_id", -1);
      bajr.a(null, "cmshow", "Apollo", "share_url_succeed", ApolloUtil.b(i), 0, new String[] { Integer.toString(j) });
      continue;
      if (this.jdField_a_of_type_Aipj != null) {
        if (paramInt2 == -1)
        {
          this.jdField_a_of_type_Aipj.a(0, 1, 0, "");
        }
        else
        {
          this.jdField_a_of_type_Aipj.a(1, 1, 0, "");
          continue;
          if ((this.jdField_a_of_type_Aipj != null) && (paramIntent != null))
          {
            i = paramIntent.getIntExtra("share_result_key", -1);
            if (i == 0) {}
            try
            {
              bbmy.a(getApplicationContext(), ajjy.a(2131634541), 0).a();
              j = paramIntent.getIntExtra("uintype", -1);
              String str = paramIntent.getStringExtra("uin");
              j = ApolloGameUtil.a(aing.a(), j, str);
              this.jdField_a_of_type_Aipj.a(i, 0, j, str);
            }
            catch (Throwable localThrowable1)
            {
              for (;;)
              {
                QLog.e(this.jdField_b_of_type_JavaLangString, 1, localThrowable1, new Object[0]);
              }
            }
            if ((this.jdField_a_of_type_Aipj != null) && (paramIntent != null))
            {
              i = paramIntent.getIntExtra("share_result_key", -1);
              if (i == 0) {}
              try
              {
                bbmy.a(getApplicationContext(), ajjy.a(2131634573), 0).a();
                this.jdField_a_of_type_Aipj.d(i);
              }
              catch (Throwable localThrowable2)
              {
                for (;;)
                {
                  QLog.e(this.jdField_b_of_type_JavaLangString, 1, localThrowable2, new Object[0]);
                }
              }
              if ((this.jdField_a_of_type_Aipj != null) && (this.jdField_a_of_type_Aipj.a() != null)) {
                this.jdField_a_of_type_Aipj.a().runRenderTask(new ApolloGameActivity.12(this, paramInt1, paramInt2, paramIntent));
              }
            }
          }
        }
      }
    }
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if (paramConfiguration != null)
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, new Object[] { "[doOnConfigurationChanged] new orientation=", Integer.valueOf(paramConfiguration.orientation), ", mOrientation=", Integer.valueOf(this.jdField_c_of_type_Int) });
      if (this.jdField_c_of_type_Int != paramConfiguration.orientation)
      {
        this.jdField_c_of_type_Int = paramConfiguration.orientation;
        this.jdField_a_of_type_Befq.removeMessages(105);
        this.jdField_a_of_type_Befq.sendEmptyMessageDelayed(105, 500L);
      }
      long l = babp.a(true);
      if ((this.jdField_a_of_type_Long != l) && (this.jdField_a_of_type_Long != this.jdField_b_of_type_Long))
      {
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, new Object[] { "[doOnConfigurationChanged] mLastScreenWidth:", Long.valueOf(l) });
        this.jdField_a_of_type_Befq.sendEmptyMessageDelayed(102, 500L);
      }
      this.jdField_a_of_type_Long = l;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    long l1 = SystemClock.uptimeMillis();
    ApolloGameStateMachine.a().a();
    ApolloGameStateMachine.a().addObserver(this);
    this.mNeedStatusTrans = false;
    super.getWindow().addFlags(67108864);
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = a(super.getIntent());
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null)
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 1, "[doOnCreate] no start param");
      finish();
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game == null) {
      QLog.i(this.jdField_b_of_type_JavaLangString, 1, "[doOnCreate] game is new, gameId:" + this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);
    }
    paramBundle = aing.a();
    if (paramBundle != null) {
      paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.isWhiteUsr);
    }
    long l2;
    int i;
    if (!this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.isWhiteUsr)
    {
      aing.jdField_a_of_type_Boolean = true;
      l2 = System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mCreateTs;
      QLog.i(this.jdField_b_of_type_JavaLangString, 1, "[game_launch_cost], activity onCreate:" + l2);
      i = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game != null) {
        break label442;
      }
    }
    label442:
    for (paramBundle = null;; paramBundle = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.name)
    {
      aing.a(new Object[] { "[launchGame], gameId:", Integer.valueOf(i), ", gameName:", paramBundle, ", mLoadingOnMainProcess:", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mLoadingOnMainProcess), ", start cost:", Long.valueOf(l2) });
      ThreadManager.post(new ApolloGameActivity.3(this), 8, null, false);
      o();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, " onCreate_doActivityInfo cost time:" + (SystemClock.uptimeMillis() - l1));
      }
      l2 = SystemClock.uptimeMillis();
      p();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, " onCreate_doInitUI cost time:" + (SystemClock.uptimeMillis() - l2));
      }
      l2 = SystemClock.uptimeMillis();
      d(l1);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, " onCreate_doReport cost time:" + (SystemClock.uptimeMillis() - l2));
      }
      return true;
      aing.jdField_a_of_type_Boolean = false;
      break;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    QLog.i(this.jdField_b_of_type_JavaLangString, 1, "[doOnDestroy] this:" + this);
    ailm.b(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    this.jdField_a_of_type_Befq.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView.a(false);
    }
    if (this.jdField_a_of_type_Airm != null) {
      this.jdField_a_of_type_Airm.h();
    }
    this.jdField_a_of_type_Boolean = true;
    ApolloGameStateMachine.a().deleteObserver(this);
    if (this.jdField_d_of_type_Bafb != null) {
      this.jdField_d_of_type_Bafb.dismiss();
    }
    if (this.jdField_a_of_type_Aipj != null)
    {
      this.jdField_a_of_type_Aipj.f();
      aing.b(this.jdField_a_of_type_Aipj.a(), this.jdField_d_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null)
    {
      aing.a(5, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, this.jdField_d_of_type_Int);
      localObject = aing.a();
      if (localObject != null) {
        ((aips)localObject).c(this, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType != 1) {
        QQBrowserActivity.jdField_c_of_type_Int -= 1;
      }
      if (aing.jdField_b_of_type_Long == this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mCreateTs) {
        aing.jdField_b_of_type_Long = 0L;
      }
    }
    aikz.a().a();
    if (this.jdField_a_of_type_Bafb != null) {
      this.jdField_a_of_type_Bafb.dismiss();
    }
    if (this.jdField_b_of_type_Bafb != null) {
      this.jdField_b_of_type_Bafb.dismiss();
    }
    if (this.jdField_c_of_type_Bafb != null) {
      this.jdField_c_of_type_Bafb.dismiss();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("key_game_friUin", this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mTempAIOUin);
      QIPCClientHelper.getInstance().callServer("cm_game_module", "action_audio_exit_room", (Bundle)localObject, null);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mLoadingOnMainProcess) {
        ApolloGameUtil.c();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloDebugCmGameDebugView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloDebugCmGameDebugView.e();
    }
    Object localObject = aing.a();
    if (localObject != null) {
      ((aikb)localObject).a();
    }
    anfc.a().b(this.jdField_a_of_type_Anad);
    u();
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (3 == paramInt)
    {
      onBackEvent();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    s();
    super.doOnNewIntent(paramIntent);
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "[doOnNewIntent]");
    ailm.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    try
    {
      if (this.jdField_a_of_type_Aipj != null)
      {
        if (this.jdField_a_of_type_Aipj.a() == null) {
          return;
        }
        if (paramIntent != null)
        {
          paramIntent = a(paramIntent);
          if (paramIntent != null)
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (paramIntent != null)) {
              this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap = paramIntent.statMap;
            }
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_b_of_type_JavaLangString, 2, new Object[] { "try update gameParam:", paramIntent.extendJson });
            }
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("gameParam", paramIntent.extendJson);
            aing.a().callbackFromRequest(this.jdField_a_of_type_Aipj.a().getLuaState(), 0, "sc.game_param_update.local", localJSONObject.toString());
            return;
          }
        }
      }
    }
    catch (Throwable paramIntent)
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 1, paramIntent, new Object[0]);
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "[doOnPause]");
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) {
      aing.a(3, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, this.jdField_d_of_type_Int);
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Aipj != null)
        {
          if (!this.jdField_a_of_type_Aipj.b()) {
            continue;
          }
          ApolloSurfaceView localApolloSurfaceView = this.jdField_a_of_type_Aipj.a();
          if (localApolloSurfaceView != null) {
            aing.a().callbackFromRequest(localApolloSurfaceView.getLuaState(), 0, "cs.xy_life_cycle_event_disactivity.local", "{}");
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e(this.jdField_b_of_type_JavaLangString, 1, localException, new Object[0]);
        continue;
      }
      this.jdField_a_of_type_Befq.removeMessages(100);
      if (this.jdField_a_of_type_Aipj != null) {
        this.jdField_a_of_type_Aipj.e();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView.g();
      }
      if (this.jdField_a_of_type_Airm != null) {
        this.jdField_a_of_type_Airm.f();
      }
      ailm.b(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
      this.jdField_d_of_type_Boolean = true;
      return;
      aing.a().callbackFromRequest(this.jdField_a_of_type_Aipj.a(), 0, "cs.xy_life_cycle_event_disactivity.local", "{}");
    }
  }
  
  public void doOnResume()
  {
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "doOnResume");
    s();
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) {
      aing.a(2, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, this.jdField_d_of_type_Int);
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Aipj != null)
        {
          if (!this.jdField_a_of_type_Aipj.b()) {
            continue;
          }
          localObject = this.jdField_a_of_type_Aipj.a();
          if (localObject != null) {
            aing.a().callbackFromRequest(((ApolloSurfaceView)localObject).getLuaState(), 0, "cs.xy_life_cycle_event_activity.local", "{}");
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        QLog.e(this.jdField_b_of_type_JavaLangString, 1, localException, new Object[0]);
        continue;
      }
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Befq.sendEmptyMessageDelayed(100, 500L);
      if (this.jdField_a_of_type_Aipj != null) {
        this.jdField_a_of_type_Aipj.d();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView.f();
      }
      localObject = aing.a();
      if (localObject != null) {
        ((aips)localObject).b(this, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
      }
      if (this.jdField_a_of_type_Airm != null) {
        this.jdField_a_of_type_Airm.g();
      }
      ailm.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap != null)) {
        this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.put("game_loading_resume_time", Long.valueOf(SystemClock.uptimeMillis()));
      }
      a();
      return;
      aing.a().callbackFromRequest(this.jdField_a_of_type_Aipj.a(), 0, "cs.xy_life_cycle_event_activity.local", "{}");
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) {
      aing.a(4, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, this.jdField_d_of_type_Int);
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 19))
    {
      View localView = getWindow().getDecorView();
      if (!aing.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam)) {
        localView.setSystemUiVisibility(5894);
      }
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mOpenTempAIOOnFinish) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mTempAIOUin))) {}
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("friendUin", this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mTempAIOUin);
      localJSONObject.put("nickName", this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mTempAIONickName);
      aioy.a("cs.open_cm_aio.local", localJSONObject.toString(), true, null, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 1, localException, new Object[0]);
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "[onFirstFrameDrawn]");
    }
    if (!this.jdField_b_of_type_Boolean) {
      QLog.w(this.jdField_b_of_type_JavaLangString, 2, "[onFirstFrameDrawn] call more than once");
    }
    a(false, 50L);
    this.jdField_a_of_type_Befq.removeMessages(108);
    long l5;
    long l2;
    Object localObject;
    if ((this.jdField_b_of_type_Boolean) && (!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap != null))
    {
      l5 = SystemClock.uptimeMillis();
      l2 = 0L;
      QLog.d("CmGameStat", 1, new Object[] { "firstFrameTime=", Long.valueOf(l5), " [gameId=", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), "]" });
      this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.put("first_frame_callback_time", Long.valueOf(l5));
      l1 = l2;
      if (!this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.containsKey("click_time")) {
        break label1409;
      }
      localObject = (Long)this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.get("click_time");
      l1 = l2;
      if (localObject == null) {
        break label1409;
      }
      l1 = l2;
      if (((Long)localObject).longValue() <= 0L) {
        break label1409;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.containsKey("game_process_on")) {
        break label1438;
      }
    }
    label1409:
    label1412:
    label1438:
    for (long l1 = ((Long)this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.get("game_process_on")).longValue();; l1 = 0L)
    {
      l2 = l5 - ((Long)localObject).longValue();
      if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.containsKey("download_game_res")) {}
      for (long l3 = ((Long)this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.get("download_game_res")).longValue();; l3 = 0L)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.containsKey("download_confirm")) {}
        for (long l4 = ((Long)this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.get("download_confirm")).longValue();; l4 = 0L)
        {
          int i = bbth.a(null);
          localObject = new HashMap();
          ((HashMap)localObject).put("param_gameId", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId));
          ((HashMap)localObject).put("param_processOn", String.valueOf(l1));
          ((HashMap)localObject).put("param_download", String.valueOf(l3));
          ((HashMap)localObject).put("param_downloadConfirm", String.valueOf(l4));
          ((HashMap)localObject).put("param_netType", String.valueOf(i));
          ((HashMap)localObject).put("param_src", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.src));
          awrn.a(getAppInterface().getApp()).a(getCurrentAccountUin(), "cmgame_click_to_show_game", true, l2, 0L, (HashMap)localObject, "", false);
          QLog.d("CmGameStat", 1, new Object[] { "cmgame_click_to_show_game, duration=", Long.valueOf(l2), " [gameId=", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), ", processOn=", Long.valueOf(l1), ", downloadRes=", Long.valueOf(l3), ", downloadConfirm=", Long.valueOf(l4), ", netType=", Integer.valueOf(i), ", src=", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.src), "]" });
          l1 = l2;
          if (l4 == 0L) {
            if (l3 == 0L)
            {
              awrn.a(getAppInterface().getApp()).a(getCurrentAccountUin(), "cmgame_launch_total_time_not_download", true, l2, 0L, (HashMap)localObject, "", false);
              l1 = l2;
              localObject = new HashMap();
              ((HashMap)localObject).put("param_gameId", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId));
              ((HashMap)localObject).put("param_src", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.src));
              if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.containsKey("start_exe_js_time"))
              {
                l2 = ((Long)this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.get("start_exe_js_time")).longValue();
                if (l2 > 0L)
                {
                  l3 = l5 - l2;
                  if (l3 >= 0L) {
                    awrn.a(getAppInterface().getApp()).a(getCurrentAccountUin(), "cmgame_first_frame_time", true, l3, 0L, (HashMap)localObject, "", false);
                  }
                  QLog.d("CmGameStat", 1, new Object[] { "cmgame_first_frame_time, duration=", Long.valueOf(l3), ", extJsTime=", Long.valueOf(l2), " [gameId=", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), "]" });
                }
              }
              if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.containsKey("exe_js_end_time"))
              {
                l2 = ((Long)this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.get("exe_js_end_time")).longValue();
                if (l2 > 0L)
                {
                  l3 = l5 - l2;
                  if (l3 >= 0L) {
                    awrn.a(getAppInterface().getApp()).a(getCurrentAccountUin(), "cmgame_first_frame_time_new", true, l3, 0L, (HashMap)localObject, "", false);
                  }
                  aing.a(new Object[] { "[handleFirstFrame], done cost:", Long.valueOf(l3) });
                  QLog.d("CmGameStat", 1, new Object[] { "cmgame_first_frame_time_new, duration=", Long.valueOf(l3), ", exeJsEndTime=", Long.valueOf(l2), " [gameId=", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), "]" });
                }
              }
              if ((this.jdField_a_of_type_Aipj != null) && (this.jdField_a_of_type_Aipj.jdField_a_of_type_Long > 0L))
              {
                l2 = l5 - this.jdField_a_of_type_Aipj.jdField_a_of_type_Long;
                if (l2 >= 0L) {
                  awrn.a(getAppInterface().getApp()).a(getCurrentAccountUin(), "cmgame_start_engine_to_first_frame", true, l2, 0L, (HashMap)localObject, "", false);
                }
                QLog.d("CmGameStat", 1, new Object[] { "cmgame_start_engine_to_first_frame, duration=", Long.valueOf(l2), ", mStartGameEngineTs=", Long.valueOf(this.jdField_a_of_type_Aipj.jdField_a_of_type_Long), " [gameId=", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), "]" });
              }
              if (this.jdField_c_of_type_Boolean) {
                break label1412;
              }
              ((HashMap)localObject).put("param_Result", "1");
              awrn.a(getAppInterface().getApp()).a(getCurrentAccountUin(), "cmgame_launch_result", true, 0L, 0L, (HashMap)localObject, "", false);
              QLog.d("CmGameStat", 1, new Object[] { "cmgame_launch_result, success", " [gameId=", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), "]" });
              aing.a(getAppInterface(), 1, 0, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, 0L, null);
              ((HashMap)localObject).clear();
              ((HashMap)localObject).put("param_gameId", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId));
              ((HashMap)localObject).put("param_timeout", "0");
              awrn.a(getAppInterface().getApp()).a(getCurrentAccountUin(), "cmgame_first_frame_timeout", true, 0L, 0L, (HashMap)localObject, "", false);
            }
          }
          for (;;)
          {
            aing.a(new Object[] { "[launchGame] success, all cost:", Long.valueOf(l1) });
            a(true);
            this.jdField_b_of_type_Boolean = false;
            return;
            awrn.a(getAppInterface().getApp()).a(getCurrentAccountUin(), "cmgame_launch_total_time_with_download", true, l2, 0L, (HashMap)localObject, "", false);
            l1 = l2;
            break;
            QLog.w(this.jdField_b_of_type_JavaLangString, 2, "[onFirstFrameDrawn] first frame too long");
          }
        }
      }
    }
  }
  
  public void finish()
  {
    super.finish();
    u();
  }
  
  public void g()
  {
    long l2;
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.containsKey("game_loading_resume_time")))
    {
      l2 = ((Long)this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.get("game_loading_resume_time")).longValue();
      if (l2 > 0L) {
        if (!this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.containsKey("game_process_on")) {
          break label487;
        }
      }
    }
    label487:
    for (long l1 = ((Long)this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.get("game_process_on")).longValue();; l1 = 0L)
    {
      long l4 = SystemClock.uptimeMillis() - l2;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.containsKey("download_game_res")) {}
      for (l2 = ((Long)this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.get("download_game_res")).longValue();; l2 = 0L)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.containsKey("download_confirm")) {}
        for (long l3 = ((Long)this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.get("download_confirm")).longValue();; l3 = 0L)
        {
          int i = bbth.a(null);
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView.getVisibility() == 0)) {}
          for (String str = "1";; str = "0")
          {
            HashMap localHashMap = new HashMap();
            localHashMap.put("param_gameId", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId));
            localHashMap.put("param_processOn", String.valueOf(l1));
            localHashMap.put("param_isLoading", str);
            localHashMap.put("param_download", String.valueOf(l2));
            localHashMap.put("param_downloadConfirm", String.valueOf(l3));
            localHashMap.put("param_netType", String.valueOf(i));
            localHashMap.put("param_gameProc", "1");
            awrn.a(getAppInterface().getApp()).a(getCurrentAccountUin(), "cmgame_click_to_close", true, l4, 0L, localHashMap, "", false);
            QLog.d("CmGameStat", 1, new Object[] { "cmgame_click_to_close, game proc, duration=", Long.valueOf(l4), " [gameId=", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), ", processOn=", Long.valueOf(l1), ", isLoading=", str, ", downloadRes=", Long.valueOf(l2), ", downloadConfirm=", Long.valueOf(l3), ", netType=", Integer.valueOf(i), "]" });
            return;
          }
        }
      }
    }
  }
  
  public String getModuleId()
  {
    return "cmshowgame_module";
  }
  
  public void h()
  {
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "[onExeJsStart]");
    this.jdField_a_of_type_Befq.removeMessages(108);
    this.jdField_a_of_type_Befq.sendEmptyMessageDelayed(108, 10000L);
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap != null)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.put("start_exe_js_time", Long.valueOf(SystemClock.uptimeMillis()));
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, new Object[] { "handleMessage what:", Integer.valueOf(paramMessage.what) });
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      l();
      continue;
      this.jdField_b_of_type_Int += 1;
      if (this.jdField_b_of_type_Int < 3)
      {
        this.jdField_a_of_type_Befq.sendEmptyMessageDelayed(100, 500L);
        continue;
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, "[handleMessage] close game timeout, just finish");
        finish();
        e();
        continue;
        u();
        if (this.jdField_a_of_type_Aipj != null) {
          this.jdField_a_of_type_Aipj.a(true);
        }
        boolean bool;
        if (this.jdField_a_of_type_Airm == null)
        {
          bool = true;
          if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.viewMode != 1) {
            break label358;
          }
          bool = false;
        }
        for (;;)
        {
          this.jdField_a_of_type_Airm = new airm(this.jdField_b_of_type_AndroidWidgetRelativeLayout, bool, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);
          if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView == null) {
            break label374;
          }
          QLog.d(this.jdField_b_of_type_JavaLangString, 1, "[handleMessage] remove loading rootView.");
          paramMessage = new AlphaAnimation(1.0F, 0.0F);
          paramMessage.setDuration(300L);
          paramMessage.setAnimationListener(new aiti(this));
          if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView.b.getVisibility() == 0) {
            this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView.b.setText("100%");
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView.startAnimation(paramMessage);
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.enableMenu)) {
            break;
          }
          QLog.d(this.jdField_b_of_type_JavaLangString, 1, "[handleMessage] remove top menu");
          this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView.setVisibility(8);
          break;
          label358:
          if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.viewMode == 2) {
            bool = false;
          }
        }
        label374:
        QLog.e(this.jdField_b_of_type_JavaLangString, 1, "[handleMessage] loading root is null");
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView.d();
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
            this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView != null) && ((this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView instanceof CmGameFloatView)))
          {
            CmGameFloatView localCmGameFloatView = (CmGameFloatView)this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView;
            int i;
            if (paramMessage.arg1 == 1) {
              i = 1;
            }
            for (;;)
            {
              if ((i != 0) && (paramMessage.obj != null))
              {
                paramMessage = (Pair)paramMessage.obj;
                String str = (String)paramMessage.first;
                if (!TextUtils.isEmpty(str))
                {
                  localCmGameFloatView.a(true, str, (String)paramMessage.second);
                  break;
                  i = 0;
                  continue;
                }
                localCmGameFloatView.a(false, null, null);
                break;
              }
            }
            localCmGameFloatView.a(false, null, null);
            continue;
            if (this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView.jdField_a_of_type_Boolean = true;
              this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView.a(getWindow().getDecorView());
              getWindow().addFlags(2048);
              getWindow().clearFlags(1024);
              getWindow().clearFlags(67108864);
              getWindow().clearFlags(134217728);
              getWindow().setFlags(256, 65536);
              getWindow().clearFlags(256);
              getWindow().clearFlags(512);
              getWindow().addFlags(256);
              findViewById(2131302075).setVisibility(8);
              getWindow().getDecorView().setSystemUiVisibility(0);
              ImmersiveUtils.a(getWindow(), true);
              continue;
              if ((!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null))
              {
                paramMessage = new HashMap();
                paramMessage.put("param_gameId", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId));
                paramMessage.put("param_Result", "0");
                paramMessage.put("param_FailCode", String.valueOf(-14));
                awrn.a(getAppInterface().getApp()).a(getCurrentAccountUin(), "cmgame_launch_result", false, 0L, 0L, paramMessage, "", false);
                QLog.d("CmGameStat", 1, new Object[] { "cmgame_launch_result, failed, first frame timeout", " [gameId=", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), ", failCode=", Integer.valueOf(-14), "]" });
                paramMessage.clear();
                paramMessage.put("param_gameId", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId));
                paramMessage.put("param_timeout", "1");
                awrn.a(getAppInterface().getApp()).a(getCurrentAccountUin(), "cmgame_first_frame_timeout", true, 0L, 0L, paramMessage, "", false);
                this.jdField_c_of_type_Boolean = true;
                aing.a(getAppInterface(), 1, 1, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, -14L, null);
                aing.a(new Object[] { "[handleFirstFrame], wait time out" });
                aing.a(new Object[] { "[handleFirstFrame], 未收到游戏方的首帧回调，请优化" });
                if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.isWhiteUsr)
                {
                  bbmy.a(getApplicationContext(), ajjy.a(2131634576), 1).a();
                  continue;
                  if ("dialog_type_permission".equals((String)paramMessage.obj))
                  {
                    if (this.jdField_c_of_type_Bafb == null)
                    {
                      paramMessage = babr.a(this, 230).setMessage(getString(2131630265)).setTitle(getString(2131630266)).setNegativeButton(2131625035, new aitk(this));
                      if (!mjg.a(this)) {
                        break label1094;
                      }
                    }
                    label1094:
                    for (i = 2131630267;; i = 2131630268)
                    {
                      this.jdField_c_of_type_Bafb = paramMessage.setPositiveButton(i, new aitj(this));
                      this.jdField_c_of_type_Bafb.show();
                      break;
                    }
                  }
                  if (this.jdField_b_of_type_Bafb == null) {
                    this.jdField_b_of_type_Bafb = babr.a(this, 230).setMessage(ajjy.a(2131634569)).setPositiveButton(getString(2131629116), new aita(this)).setNegativeButton(getString(2131625035), new aisz(this));
                  }
                  this.jdField_b_of_type_Bafb.show();
                  continue;
                  aire.a(this, this.jdField_a_of_type_Aipj, this.jdField_a_of_type_Befq, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam, 1);
                  if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView != null)
                  {
                    this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkFrameworkView.a();
                    continue;
                    if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView != null) {
                      this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView.b(null, -10L);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void i()
  {
    this.h = true;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  @TargetApi(21)
  public void j()
  {
    Object localObject1;
    Object localObject2;
    if ((Build.VERSION.SDK_INT >= 21) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game != null))
    {
      localObject1 = aiys.k + "boxcard/" + Utils.Crc64String(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.logoUrl);
      localObject2 = new File((String)localObject1);
      if (((File)localObject2).exists()) {
        break label153;
      }
      localObject2 = new batm(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.logoUrl, (File)localObject2);
      ((batm)localObject2).p = false;
      ((batm)localObject2).f = "apollo_res";
      ((batm)localObject2).jdField_b_of_type_Int = 1;
      ((batm)localObject2).q = true;
      if (bato.a((batm)localObject2, this.app) == 0) {
        break label153;
      }
      QLog.e(this.jdField_b_of_type_JavaLangString, 1, "setTaskDescription download failed");
    }
    for (;;)
    {
      return;
      try
      {
        label153:
        localObject1 = BitmapFactory.decodeFile((String)localObject1);
        if (localObject1 != null)
        {
          int i = aciy.a(28.0F, getResources());
          int j = (int)(((Bitmap)localObject1).getWidth() / 3.0F);
          localObject2 = RoundedBitmapDrawableFactory.create(getResources(), (Bitmap)localObject1);
          ((RoundedBitmapDrawable)localObject2).setCornerRadius(j);
          ((RoundedBitmapDrawable)localObject2).setAntiAlias(true);
          setTaskDescription(new ActivityManager.TaskDescription(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.name, bacm.a((Drawable)localObject2, i, i)));
          ((Bitmap)localObject1).recycle();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e(this.jdField_b_of_type_JavaLangString, 1, localThrowable, new Object[0]);
      }
    }
  }
  
  public void k()
  {
    aitf localaitf = new aitf(this);
    if (this.jdField_a_of_type_Aipj != null)
    {
      String str = this.jdField_a_of_type_Aipj.a().mTempAIOUin;
      Bundle localBundle = new Bundle();
      localBundle.putString("key_game_friUin", str);
      QIPCClientHelper.getInstance().callServer("cm_game_module", "action_aduio_query_voice_status", localBundle, localaitf);
    }
  }
  
  public boolean onBackEvent()
  {
    QLog.i(this.jdField_b_of_type_JavaLangString, 1, "[onBackEvent]");
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId == 3112)) {
      return super.onBackEvent();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.disableMinGame))
    {
      e();
      return super.onBackEvent();
    }
    if ((this.jdField_a_of_type_Aipj != null) && (this.jdField_a_of_type_Aipj.a()))
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "[onBackEvent] apollo game is running");
      this.jdField_a_of_type_Aipj.h();
      overridePendingTransition(0, 0);
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(paramIntent);
    super.requestWindowFeature(1);
    super.getWindow().setFormat(-3);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 0) || (paramInt == 8))
    {
      super.setRequestedOrientation(paramInt);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "[setRequestedOrientation], requestedOrientation:" + paramInt);
      }
    }
  }
  
  public void setTheme(int paramInt)
  {
    for (;;)
    {
      try
      {
        CmGameStartChecker.StartCheckParam localStartCheckParam = a(getIntent());
        if ((localStartCheckParam != null) && (localStartCheckParam.notFullScreen))
        {
          super.setTheme(2131689623);
          if (!QLog.isColorLevel()) {
            break;
          }
          String str = this.jdField_b_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder().append("onCreate notFullScreen:");
          if ((localStartCheckParam != null) && (localStartCheckParam.notFullScreen))
          {
            bool = true;
            QLog.d(str, 2, bool);
          }
        }
        else
        {
          super.setTheme(2131689622);
          continue;
        }
        boolean bool = false;
      }
      catch (Exception localException)
      {
        QLog.e(this.jdField_b_of_type_JavaLangString, 1, localException, new Object[0]);
        return;
      }
    }
  }
  
  public void update(Observable paramObservable, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloGameActivity
 * JD-Core Version:    0.7.0.1
 */