package com.tencent.av.ui.redbag;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.PopupMenu;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.AVC2CDataHandler;
import com.tencent.av.business.manager.BusinessManager;
import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.av.opengl.effects.EffectController;
import com.tencent.av.ptu.PtuResChecker;
import com.tencent.av.recog.AVVoiceRecog;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.ControlUIObserver.ZimuRequest;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class AVRedBagMgr
  extends BusinessManager
{
  AVRedBag jdField_a_of_type_ComTencentAvUiRedbagAVRedBag = null;
  AVRedBagConfig.Info jdField_a_of_type_ComTencentAvUiRedbagAVRedBagConfig$Info;
  AVRedBagConfig jdField_a_of_type_ComTencentAvUiRedbagAVRedBagConfig = null;
  public AVRedBagMgr.TestFlag a;
  GameSink jdField_a_of_type_ComTencentAvUiRedbagGameSink = null;
  GetRedBag.GetRedBagListener jdField_a_of_type_ComTencentAvUiRedbagGetRedBag$GetRedBagListener;
  GetRedBag jdField_a_of_type_ComTencentAvUiRedbagGetRedBag = null;
  public ListenPeerMsg a;
  OtherBtnController jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController;
  ResultUI jdField_a_of_type_ComTencentAvUiRedbagResultUI = null;
  SendRedBag jdField_a_of_type_ComTencentAvUiRedbagSendRedBag = null;
  WeakReference<AVActivity> jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean = false;
  public String b;
  WeakReference<AVRedBagMgr.Event> b;
  
  public AVRedBagMgr(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvUiRedbagListenPeerMsg = null;
  }
  
  static void a(VideoAppInterface paramVideoAppInterface, ResultData paramResultData)
  {
    if (paramResultData.jdField_a_of_type_Boolean) {
      ((AVRedPacketManager)paramVideoAppInterface.a(6)).a(paramResultData.c, paramResultData.i, paramResultData.jdField_e_of_type_JavaLangString, paramResultData.f, paramResultData.jdField_a_of_type_Int);
    }
    QLog.w("AVRedBag", 1, "notifyGetRedbagResultToStarter, js_amount[" + paramResultData.i + "], mPlayerGetRedbag_ResultCode[" + paramResultData.jdField_e_of_type_JavaLangString + "], mPlayerGetRedbag_ResultState[" + paramResultData.f + "], mHitScore[" + paramResultData.jdField_a_of_type_Int + "], mSucAboutGame[" + paramResultData.jdField_a_of_type_Boolean + "]");
  }
  
  private void f()
  {
    String str = this.jdField_b_of_type_JavaLangString;
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().d))) {}
    do
    {
      return;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().d;
      QLog.w("AVRedBag", 1, "init, mPeerUin[" + str + "->" + this.jdField_b_of_type_JavaLangString + "]");
      if (!RedBagUtil.a()) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentAvUiRedbagListenPeerMsg == null) {
        this.jdField_a_of_type_ComTencentAvUiRedbagListenPeerMsg = new ListenPeerMsg(this);
      }
      this.jdField_a_of_type_ComTencentAvUiRedbagListenPeerMsg.a("init");
      if ((this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagConfig$Info == null) || (!this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagConfig$Info.c)) {
        g();
      }
    } while (this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBag != null);
    this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBag = new AVRedBag(this);
    this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBag.a();
    return;
    a("init_when_not_support");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new AVRedBagMgr.1(this));
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagConfig == null) {
      this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagConfig = new AVRedBagConfig(this);
    }
    this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagConfig.a();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentAvUiRedbagListenPeerMsg != null) {
      return this.jdField_a_of_type_ComTencentAvUiRedbagListenPeerMsg.jdField_a_of_type_Int;
    }
    return -1;
  }
  
  public VideoAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  }
  
  public AVActivity a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localWeakReference != null) {
      return (AVActivity)localWeakReference.get();
    }
    return null;
  }
  
  public AVRedBagConfig.Info a()
  {
    return this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagConfig$Info;
  }
  
  AVRedBagMgr.Event a()
  {
    WeakReference localWeakReference = this.jdField_b_of_type_JavaLangRefWeakReference;
    if (localWeakReference != null) {
      return (AVRedBagMgr.Event)localWeakReference.get();
    }
    return null;
  }
  
  public GameSink a()
  {
    if (this.jdField_a_of_type_ComTencentAvUiRedbagGameSink == null) {
      this.jdField_a_of_type_ComTencentAvUiRedbagGameSink = new GameSink(this);
    }
    return this.jdField_a_of_type_ComTencentAvUiRedbagGameSink;
  }
  
  public GetRedBag a(AVActivity paramAVActivity, ResultData paramResultData, WeakReference<GetRedBag.GetRedBagListener> paramWeakReference)
  {
    if (this.jdField_a_of_type_ComTencentAvUiRedbagGetRedBag != null)
    {
      this.jdField_a_of_type_ComTencentAvUiRedbagGetRedBag.a("startActivity_getRegBag");
      this.jdField_a_of_type_ComTencentAvUiRedbagGetRedBag = null;
    }
    GetRedBag localGetRedBag = new GetRedBag(this);
    if (localGetRedBag.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramAVActivity, paramResultData, paramWeakReference)) {
      this.jdField_a_of_type_ComTencentAvUiRedbagGetRedBag = localGetRedBag;
    }
    return localGetRedBag;
  }
  
  public void a() {}
  
  void a(int paramInt, Intent paramIntent) {}
  
  public void a(PopupMenu paramPopupMenu)
  {
    if (this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagMgr$TestFlag == null) {
      this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagMgr$TestFlag = new AVRedBagMgr.TestFlag();
    }
  }
  
  void a(AVActivity paramAVActivity)
  {
    AVActivity localAVActivity = a();
    QLog.w("AVRedBag", 1, "onAVActivityCreate, NewActivity[" + paramAVActivity + "], oldActivity[" + localAVActivity + "]");
    RedBagUtil.a(paramAVActivity.getResources().getDisplayMetrics().densityDpi);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAVActivity);
    f();
  }
  
  void a(AVActivity paramAVActivity, ResultData paramResultData)
  {
    this.jdField_a_of_type_ComTencentAvUiRedbagGetRedBag$GetRedBagListener = new AVRedBagMgr.5(this);
    paramAVActivity = a(paramAVActivity, paramResultData, new WeakReference(this.jdField_a_of_type_ComTencentAvUiRedbagGetRedBag$GetRedBagListener));
    if (paramAVActivity.a.jdField_e_of_type_Int != 1)
    {
      a("getRedBag_Fail", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramAVActivity.a);
      return;
    }
    QLog.w("AVRedBag", 1, "callGetRedBag, 发送中，等红包回调通知, getRedBag[" + paramAVActivity.b + "]");
  }
  
  void a(AVRedBagConfig.Info paramInfo)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    AVRedBagMgr.Event localEvent;
    do
    {
      return;
      this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagConfig$Info = paramInfo;
      localEvent = a();
    } while (localEvent == null);
    if (paramInfo == null) {}
    for (boolean bool = false;; bool = paramInfo.jdField_a_of_type_Boolean)
    {
      localEvent.a(bool);
      return;
    }
  }
  
  void a(GameSink paramGameSink)
  {
    b(true);
    b("onGameStart_from_GameSink");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().az = true;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new AVRedBagMgr.6(this));
  }
  
  void a(ResultData paramResultData)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null)
    {
      QLog.w("AVRedBag", 1, "showResultUI, mWeakAVActivity为空");
      return;
    }
    ResultUI localResultUI = new ResultUI(this);
    localResultUI.a(paramResultData, new AVRedBagMgr.3(this));
    this.jdField_a_of_type_ComTencentAvUiRedbagResultUI = localResultUI;
  }
  
  void a(String paramString)
  {
    int i = 3;
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    AVC2CDataHandler localAVC2CDataHandler = AVC2CDataHandler.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (localAVC2CDataHandler == null)
    {
      QLog.w("AVRedBag", 1, "sendAbility[" + paramString + "], , avc2CDataHandler为空");
      return;
    }
    int j = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().g;
    int k = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().j();
    if (j == 4) {
      if (RedBagUtil.a()) {
        if (this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagConfig$Info != null) {
          if (this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagConfig$Info.c) {
            if (k == VideoController.k)
            {
              bool1 = bool2;
              localAVC2CDataHandler.a(11, i, null);
            }
          }
        }
      }
    }
    for (;;)
    {
      QLog.w("AVRedBag", 1, "sendAbility[" + paramString + "], Enable[" + i + "], state[" + j + "], isLoadPTuSoSuc[" + k + "], ptuSoExist[" + bool1 + "], GetConfigReady[" + this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagConfig$Info + "]");
      return;
      if (k == VideoController.l)
      {
        i = 2;
        bool1 = bool2;
        break;
      }
      bool1 = bool3;
      if (k == VideoController.j)
      {
        bool2 = PtuResChecker.b();
        bool1 = bool2;
        if (bool2) {
          break;
        }
        bool1 = bool2;
      }
      do
      {
        i = 2;
        break;
        bool1 = bool3;
      } while (this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagConfig$Info.jdField_a_of_type_Boolean);
      i = 1;
      bool1 = bool2;
      break;
      i = 1;
      bool1 = bool2;
      break;
      i = 0;
      bool1 = bool2;
      break;
      i = 0;
    }
  }
  
  void a(String paramString, VideoAppInterface paramVideoAppInterface, ResultData paramResultData)
  {
    this.jdField_a_of_type_ComTencentAvUiRedbagGetRedBag$GetRedBagListener = null;
    a(paramVideoAppInterface, paramResultData);
    paramVideoAppInterface = this.jdField_a_of_type_ComTencentAvUiRedbagResultUI;
    if (paramVideoAppInterface != null)
    {
      QLog.w("AVRedBag", 1, "onCallGetRedBag[" + paramString + "], new[" + paramResultData + "], src[" + paramVideoAppInterface.a + "]");
      paramVideoAppInterface.a(paramResultData);
    }
  }
  
  void a(String paramString1, AVActivity paramAVActivity, String paramString2)
  {
    boolean bool2 = false;
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "prepareAVActivity, Begin, from[" + paramString1 + "], seq[" + l + "]");
    }
    AVVoiceRecog.a().a(8);
    if (this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController == null) {
      this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController = new OtherBtnController(this);
    }
    this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController.b();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(134) });
    new ControlUIObserver.ZimuRequest(l, "prepareAVActivity", 2, null).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(6101), null, Boolean.valueOf(true) });
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(8001), paramString1 });
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(8002) });
    boolean bool3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2);
    if (bool3) {
      ((EffectPendantTools)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2)).a(l, null);
    }
    VideoLayerUI localVideoLayerUI = paramAVActivity.a;
    if (localVideoLayerUI != null) {}
    for (boolean bool1 = localVideoLayerUI.a(paramString1, paramString2);; bool1 = false)
    {
      paramString2 = VideoController.a().a(false);
      if (paramString2 != null) {
        paramString2.a(l);
      }
      TipsUtil.a(l, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      d(paramString1);
      paramString1 = new StringBuilder().append("prepareAVActivity, end, from[").append(paramString1).append("], seq[").append(l).append("], isPendantActive[").append(bool3).append("], setVideoToBigView[").append(bool1).append("], avActivity[").append(paramAVActivity).append("], videoLayerUI[");
      bool1 = bool2;
      if (localVideoLayerUI != null) {
        bool1 = true;
      }
      QLog.w("AVRedBag", 1, bool1 + "]");
      return;
    }
  }
  
  public void a(WeakReference<AVRedBagMgr.Event> paramWeakReference)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  public void a(boolean paramBoolean)
  {
    AVC2CDataHandler localAVC2CDataHandler = AVC2CDataHandler.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    int i;
    Object localObject;
    if (localAVC2CDataHandler != null)
    {
      if (paramBoolean)
      {
        i = 4;
        localAVC2CDataHandler.a(11, i, null);
      }
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder().append("sendEnterMode, bEnter[");
      if (this.jdField_a_of_type_ComTencentAvUiRedbagListenPeerMsg != null) {
        break label126;
      }
      localObject = null;
      label54:
      localObject = localStringBuilder.append(localObject).append("->").append(paramBoolean).append("], mHandlerForVideo[");
      if (localAVC2CDataHandler == null) {
        break label141;
      }
    }
    label141:
    for (boolean bool = true;; bool = false)
    {
      QLog.w("AVRedBag", 1, bool + "]");
      if (this.jdField_a_of_type_ComTencentAvUiRedbagListenPeerMsg != null) {
        this.jdField_a_of_type_ComTencentAvUiRedbagListenPeerMsg.jdField_b_of_type_Boolean = paramBoolean;
      }
      return;
      i = 5;
      break;
      label126:
      localObject = Boolean.valueOf(this.jdField_a_of_type_ComTencentAvUiRedbagListenPeerMsg.jdField_b_of_type_Boolean);
      break label54;
    }
  }
  
  void a(boolean paramBoolean, String paramString, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = paramBoolean;
    String str = paramString;
    if (this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagMgr$TestFlag != null)
    {
      bool1 = paramBoolean;
      str = paramString;
      if (this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagMgr$TestFlag.jdField_b_of_type_Boolean)
      {
        str = "10000448011711161400109338189700";
        bool1 = true;
      }
    }
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (bool1) && (!TextUtils.isEmpty(str)))
    {
      ((AVRedPacketManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(6)).a(true, str, paramInt);
      return;
    }
    paramString = new StringBuilder().append("startGame, fail, mApp[");
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString = paramString.append(paramBoolean).append("], bSuc[").append(bool1).append("], redbagId[");
      paramBoolean = bool2;
      if (!TextUtils.isEmpty(str)) {
        paramBoolean = true;
      }
      QLog.w("AVRedBag", 1, paramBoolean + "]");
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(AVActivity paramAVActivity, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiRedbagSendRedBag != null)
    {
      QLog.w("AVRedBag", 1, "startActivity_SendRedBag, 上次的红包操作还未结束");
      this.jdField_a_of_type_ComTencentAvUiRedbagSendRedBag.a();
      this.jdField_a_of_type_ComTencentAvUiRedbagSendRedBag = null;
    }
    this.jdField_a_of_type_ComTencentAvUiRedbagSendRedBag = new SendRedBag(this);
    boolean bool = this.jdField_a_of_type_ComTencentAvUiRedbagSendRedBag.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt, paramAVActivity, new AVRedBagMgr.2(this));
    if (bool)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAVActivity);
      a(true);
      return bool;
    }
    this.jdField_a_of_type_ComTencentAvUiRedbagSendRedBag = null;
    return bool;
  }
  
  public boolean a(String paramString)
  {
    return false;
  }
  
  void b()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new AVRedBagMgr.7(this));
    }
  }
  
  void b(int paramInt, Intent paramIntent)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentAvUiRedbagSendRedBag == null)
    {
      localObject = new StringBuilder().append("onActivityResult_SendRedBag, empty, resultCode[").append(paramInt).append("], data[");
      if (paramIntent != null) {
        bool = true;
      }
      QLog.w("AVRedBag", 1, bool + "]");
      if (paramIntent != null) {
        AudioHelper.a(HardCodeUtil.a(2131700968), paramIntent.getExtras());
      }
      return;
    }
    Object localObject = a();
    if (localObject == null)
    {
      QLog.w("AVRedBag", 1, "onActivityResult_SendRedBag, activity为空");
      return;
    }
    if ((paramIntent == null) && (((AVActivity)localObject).e()))
    {
      QLog.w("AVRedBag", 1, "onActivityResult_SendRedBag, 忽略");
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiRedbagSendRedBag.a(paramInt, paramIntent);
    a(false);
    this.jdField_a_of_type_ComTencentAvUiRedbagSendRedBag = null;
  }
  
  void b(AVRedBagConfig.Info paramInfo)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    b("onDownloadResResult");
    if ((paramInfo != null) && (paramInfo.c)) {
      a("onDownloadResResult");
    }
    this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagConfig = null;
  }
  
  void b(ResultData paramResultData)
  {
    b(false);
    b("onGameEnd_from_GameSink");
    if (this.jdField_a_of_type_ComTencentAvUiRedbagListenPeerMsg != null) {
      a(this.jdField_a_of_type_ComTencentAvUiRedbagListenPeerMsg.jdField_b_of_type_Boolean);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().az = false;
    c(paramResultData);
    a(paramResultData);
    if (this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController != null)
    {
      this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController.c();
      this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController = null;
    }
    this.jdField_a_of_type_ComTencentAvUiRedbagGameSink = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(8002) });
  }
  
  public void b(String paramString)
  {
    boolean bool2 = true;
    boolean bool3 = b();
    int i = a();
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder().append("notifyStatusChangedEvent[").append(paramString).append("], remoteHasVideo[").append(bool3).append("], peerSupportRedBag[").append(i).append("], isPeerInSendMode[").append(c()).append("], mInGameMode[").append(a()).append("], mApp[");
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
      {
        bool1 = true;
        QLog.w("AVRedBag", 2, bool1 + "]");
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        break label132;
      }
    }
    label132:
    do
    {
      return;
      bool1 = false;
      break;
      paramString = a();
    } while (paramString == null);
    if (i == 1) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramString.a(bool3, bool1, this.jdField_a_of_type_Boolean);
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      b();
    }
  }
  
  public boolean b()
  {
    return VideoController.a().a().k;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentAvUiRedbagSendRedBag != null)
    {
      this.jdField_a_of_type_ComTencentAvUiRedbagSendRedBag.a();
      this.jdField_a_of_type_ComTencentAvUiRedbagSendRedBag = null;
      a(false);
    }
  }
  
  void c(ResultData paramResultData)
  {
    if ((!paramResultData.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new AVRedBagMgr.4(this, paramResultData));
    }
  }
  
  void c(String paramString)
  {
    if (!a())
    {
      QLog.w("AVRedBag", 1, "tryPrepareAVActivity[" + paramString + "], 不是GameMode");
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvUiRedbagGameSink;
    if (localObject == null)
    {
      QLog.w("AVRedBag", 1, "tryPrepareAVActivity[" + paramString + "], GameSink为空");
      return;
    }
    localObject = ((GameSink)localObject).a;
    if (localObject == null)
    {
      QLog.w("AVRedBag", 1, "tryPrepareAVActivity[" + paramString + "], ResultData为空");
      return;
    }
    AVActivity localAVActivity = a();
    if ((localAVActivity == null) || (!localAVActivity.isResume()))
    {
      QLog.w("AVRedBag", 1, "tryPrepareAVActivity[" + paramString + "], 等待AVActivity显示, avActivity[" + localAVActivity + "]");
      return;
    }
    a(paramString, localAVActivity, ((ResultData)localObject).jdField_b_of_type_JavaLangString);
  }
  
  void c(boolean paramBoolean)
  {
    boolean bool2 = false;
    StringBuilder localStringBuilder = new StringBuilder().append("clearWhenAVactivityStop, bFinish[").append(paramBoolean).append(", SendRedBag[");
    if (this.jdField_a_of_type_ComTencentAvUiRedbagSendRedBag != null)
    {
      bool1 = true;
      localStringBuilder = localStringBuilder.append(bool1).append(", mResultUI[");
      if (this.jdField_a_of_type_ComTencentAvUiRedbagResultUI == null) {
        break label162;
      }
    }
    label162:
    for (boolean bool1 = true;; bool1 = false)
    {
      localStringBuilder = localStringBuilder.append(bool1).append(", mOtherBtnController[");
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController != null) {
        bool1 = true;
      }
      QLog.w("AVRedBag", 1, bool1 + ", AVActivity[" + a() + "]");
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController != null)
        {
          this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController.c();
          this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController = null;
        }
        this.jdField_a_of_type_JavaLangRefWeakReference = null;
      }
      c();
      d("clearWhenAVactivityStop");
      return;
      bool1 = false;
      break;
    }
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_ComTencentAvUiRedbagListenPeerMsg != null) {
      return this.jdField_a_of_type_ComTencentAvUiRedbagListenPeerMsg.jdField_a_of_type_Boolean;
    }
    return false;
  }
  
  public void d() {}
  
  void d(String paramString)
  {
    ResultUI localResultUI = this.jdField_a_of_type_ComTencentAvUiRedbagResultUI;
    this.jdField_a_of_type_ComTencentAvUiRedbagResultUI = null;
    if (localResultUI != null) {
      localResultUI.a(paramString);
    }
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_ComTencentAvUiRedbagGameSink != null)
    {
      ResultData localResultData = this.jdField_a_of_type_ComTencentAvUiRedbagGameSink.a;
      if (localResultData != null) {
        return localResultData.jdField_b_of_type_Boolean;
      }
    }
    return false;
  }
  
  public void e()
  {
    QLog.w("AVRedBag", 1, "requestSendMode");
    AVC2CDataHandler localAVC2CDataHandler = AVC2CDataHandler.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (localAVC2CDataHandler != null) {
      localAVC2CDataHandler.a(11, 6, null);
    }
  }
  
  boolean e()
  {
    AVActivity localAVActivity = a();
    if (localAVActivity != null) {
      return localAVActivity.e();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.redbag.AVRedBagMgr
 * JD-Core Version:    0.7.0.1
 */