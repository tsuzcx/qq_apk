package com.tencent.av.ui.redbag;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.widget.PopupMenu;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.AVC2CDataHandler;
import com.tencent.av.business.manager.BusinessManager;
import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.av.opengl.effects.EffectController;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.utils.TipsManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kdx;
import kdy;
import kdz;
import kea;
import keb;
import kec;
import ked;
import key;
import kfe;

public class AVRedBagMgr
  extends BusinessManager
{
  AVRedBag jdField_a_of_type_ComTencentAvUiRedbagAVRedBag = null;
  AVRedBagConfig.Info jdField_a_of_type_ComTencentAvUiRedbagAVRedBagConfig$Info;
  AVRedBagConfig jdField_a_of_type_ComTencentAvUiRedbagAVRedBagConfig = null;
  public AVRedBagMgr.TestFlag a;
  public GameSink a;
  public GetRedBag a;
  OtherBtnController jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController;
  public ResultUI a;
  public SendRedBag a;
  public String a;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  public key a;
  public kfe a;
  public boolean a;
  WeakReference b;
  
  public AVRedBagMgr(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_Kfe = null;
    this.jdField_a_of_type_ComTencentAvUiRedbagGetRedBag = null;
    this.jdField_a_of_type_ComTencentAvUiRedbagSendRedBag = null;
    this.jdField_a_of_type_ComTencentAvUiRedbagResultUI = null;
    this.jdField_a_of_type_ComTencentAvUiRedbagGameSink = null;
    this.jdField_a_of_type_Boolean = false;
  }
  
  static MenuItem a(VideoAppInterface paramVideoAppInterface, Menu paramMenu, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    SpannableString localSpannableString = new SpannableString(paramString);
    localSpannableString.setSpan(new AbsoluteSizeSpan(AIOUtils.a(15.0F, paramVideoAppInterface.getApp().getResources())), 0, paramString.length(), 33);
    return paramMenu.add(localSpannableString).setOnMenuItemClickListener(paramOnMenuItemClickListener);
  }
  
  static SubMenu a(VideoAppInterface paramVideoAppInterface, Menu paramMenu, String paramString)
  {
    paramString = paramString + ":";
    SpannableString localSpannableString = new SpannableString(paramString);
    localSpannableString.setSpan(new AbsoluteSizeSpan(AIOUtils.a(15.0F, paramVideoAppInterface.getApp().getResources())), 0, paramString.length(), 33);
    localSpannableString.setSpan(new StyleSpan(1), 0, paramString.length(), 33);
    return paramMenu.addSubMenu(localSpannableString);
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, ResultData paramResultData)
  {
    if (paramResultData.jdField_a_of_type_Boolean) {
      ((AVRedPacketManager)paramVideoAppInterface.a(6)).a(paramResultData.c, paramResultData.i, paramResultData.jdField_e_of_type_JavaLangString, paramResultData.f, paramResultData.jdField_a_of_type_Int);
    }
    QLog.w("AVRedBag", 1, "notifyGetRedbagResultToStarter, js_amount[" + paramResultData.i + "], mPlayerGetRedbag_ResultCode[" + paramResultData.jdField_e_of_type_JavaLangString + "], mPlayerGetRedbag_ResultState[" + paramResultData.f + "], mHitScore[" + paramResultData.jdField_a_of_type_Int + "], mSucAboutGame[" + paramResultData.jdField_a_of_type_Boolean + "]");
  }
  
  private void f()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().c))) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().c;
      QLog.w("AVRedBag", 1, "init, mPeerUin[" + str + "->" + this.jdField_a_of_type_JavaLangString + "]");
      if (!RedBagUtil.a()) {
        break;
      }
      if (this.jdField_a_of_type_Kfe == null) {
        this.jdField_a_of_type_Kfe = new kfe(this);
      }
      this.jdField_a_of_type_Kfe.a("init");
      if ((this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagConfig$Info == null) || (!this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagConfig$Info.c)) {
        g();
      }
    } while (this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBag != null);
    this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBag = new AVRedBag(this);
    this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBag.a();
    return;
    a("init_when_not_support");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new kdx(this));
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
    if (this.jdField_a_of_type_Kfe != null) {
      return this.jdField_a_of_type_Kfe.jdField_a_of_type_Int;
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
    WeakReference localWeakReference = this.b;
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
  
  public GetRedBag a(AVActivity paramAVActivity, ResultData paramResultData, WeakReference paramWeakReference)
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
  
  protected void a() {}
  
  void a(int paramInt, Intent paramIntent) {}
  
  public void a(PopupMenu paramPopupMenu)
  {
    if (this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagMgr$TestFlag == null) {
      this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagMgr$TestFlag = new AVRedBagMgr.TestFlag();
    }
    this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagMgr$TestFlag.a(this, paramPopupMenu);
  }
  
  void a(AVActivity paramAVActivity)
  {
    AVActivity localAVActivity = a();
    QLog.w("AVRedBag", 1, "onAVActivityCreate, NewActivity[" + paramAVActivity + "], oldActivity[" + localAVActivity + "]");
    RedBagUtil.a(paramAVActivity.getResources().getDisplayMetrics().densityDpi);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAVActivity);
    if (this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController != null) {
      this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController.a();
    }
    f();
  }
  
  public void a(AVActivity paramAVActivity, ResultData paramResultData)
  {
    this.jdField_a_of_type_Key = new keb(this);
    paramAVActivity = a(paramAVActivity, paramResultData, new WeakReference(this.jdField_a_of_type_Key));
    if (paramAVActivity.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_e_of_type_Int != 1)
    {
      a("getRedBag_Fail", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramAVActivity.jdField_a_of_type_ComTencentAvUiRedbagResultData);
      return;
    }
    QLog.w("AVRedBag", 1, "callGetRedBag, 发送中，等红包回调通知, getRedBag[" + paramAVActivity.jdField_a_of_type_Long + "]");
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
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new kec(this));
  }
  
  void a(ResultData paramResultData)
  {
    ResultUI localResultUI = new ResultUI(this);
    localResultUI.a(paramResultData, new kdz(this));
    this.jdField_a_of_type_ComTencentAvUiRedbagResultUI = localResultUI;
  }
  
  public void a(String paramString)
  {
    int i = 3;
    boolean bool3 = false;
    boolean bool2 = false;
    AVC2CDataHandler localAVC2CDataHandler = AVC2CDataHandler.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (localAVC2CDataHandler == null)
    {
      QLog.w("AVRedBag", 1, "sendAbility[" + paramString + "], , avc2CDataHandler为空");
      return;
    }
    int j = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().jdField_g_of_type_Int;
    int k = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().j();
    boolean bool1;
    if (j == 4) {
      if (RedBagUtil.a()) {
        if (this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagConfig$Info != null) {
          if (this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagConfig$Info.c) {
            if (k == VideoController.v)
            {
              bool1 = false;
              localAVC2CDataHandler.a(11, i, null);
            }
          }
        }
      }
    }
    for (;;)
    {
      QLog.w("AVRedBag", 1, "sendAbility[" + paramString + "], Enable[" + i + "], state[" + j + "], isLoadPTuSoSuc[" + k + "], ptuSo[" + bool1 + "], ptuSoVersion[" + bool2 + "], GetConfigReady[" + this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagConfig$Info + "]");
      return;
      if (k == VideoController.w)
      {
        bool1 = false;
        i = 2;
        break;
      }
      if (k == VideoController.u)
      {
        bool3 = PtvFilterSoLoad.a(BaseApplicationImpl.getContext(), false);
        boolean bool4 = PtvFilterSoLoad.a();
        if (bool3)
        {
          bool2 = bool4;
          bool1 = bool3;
          if (bool4) {
            break;
          }
        }
        i = 2;
        bool2 = bool4;
        bool1 = bool3;
        break;
        if (!this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagConfig$Info.jdField_a_of_type_Boolean)
        {
          bool1 = false;
          i = 1;
          break;
          bool1 = false;
          i = 1;
          break;
        }
      }
      bool1 = false;
      i = 2;
      break;
      bool1 = false;
      i = 0;
      break;
      bool1 = false;
      i = 0;
      bool2 = bool3;
    }
  }
  
  public void a(String paramString, VideoAppInterface paramVideoAppInterface, ResultData paramResultData)
  {
    this.jdField_a_of_type_Key = null;
    a(paramVideoAppInterface, paramResultData);
    paramVideoAppInterface = this.jdField_a_of_type_ComTencentAvUiRedbagResultUI;
    if (paramVideoAppInterface != null)
    {
      QLog.w("AVRedBag", 1, "onCallGetRedBag[" + paramString + "], new[" + paramResultData + "], src[" + paramVideoAppInterface.jdField_a_of_type_ComTencentAvUiRedbagResultData + "]");
      paramVideoAppInterface.a(paramResultData);
    }
  }
  
  void a(String paramString1, AVActivity paramAVActivity, String paramString2)
  {
    boolean bool2 = false;
    if (this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController == null) {
      this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController = new OtherBtnController(this);
    }
    this.jdField_a_of_type_ComTencentAvUiRedbagOtherBtnController.b();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(134) });
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(6007), Integer.valueOf(0) });
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(6101), null, Boolean.valueOf(true) });
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(8001), paramString1 });
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(8002) });
    boolean bool3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2);
    if (bool3) {
      ((EffectPendantTools)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2)).a(null);
    }
    VideoLayerUI localVideoLayerUI = paramAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
    if (localVideoLayerUI != null) {}
    for (boolean bool1 = localVideoLayerUI.a(paramString1, paramString2);; bool1 = false)
    {
      paramString2 = VideoController.a().a(paramAVActivity.getApplicationContext());
      if (paramString2 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("AVRedBag", 2, "prepareAVActivity  clear effect state");
        }
        paramString2.b();
        if (paramAVActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
        {
          paramAVActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager.i();
          paramAVActivity.jdField_a_of_type_ComTencentAvUtilsTipsManager.f();
        }
      }
      d(paramString1);
      paramString1 = new StringBuilder().append("prepareAVActivity[").append(paramString1).append("], isPendantActive[").append(bool3).append("], setVideoToBigView[").append(bool1).append("], avActivity[").append(paramAVActivity).append("], videoLayerUI[");
      bool1 = bool2;
      if (localVideoLayerUI != null) {
        bool1 = true;
      }
      QLog.w("AVRedBag", 1, bool1 + "]");
      return;
    }
  }
  
  public void a(WeakReference paramWeakReference)
  {
    this.b = paramWeakReference;
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
      if (this.jdField_a_of_type_Kfe != null) {
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
      if (this.jdField_a_of_type_Kfe != null) {
        this.jdField_a_of_type_Kfe.jdField_b_of_type_Boolean = paramBoolean;
      }
      return;
      i = 5;
      break;
      label126:
      localObject = Boolean.valueOf(this.jdField_a_of_type_Kfe.jdField_b_of_type_Boolean);
      break label54;
    }
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
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
    boolean bool = this.jdField_a_of_type_ComTencentAvUiRedbagSendRedBag.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt, paramAVActivity, new kdy(this));
    if (bool)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAVActivity);
      a(true);
      return bool;
    }
    this.jdField_a_of_type_ComTencentAvUiRedbagSendRedBag = null;
    return bool;
  }
  
  protected boolean a(String paramString)
  {
    return false;
  }
  
  void b()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new ked(this));
    }
  }
  
  void b(int paramInt, Intent paramIntent)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentAvUiRedbagSendRedBag == null)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onActivityResult_SendRedBag, empty, resultCode[").append(paramInt).append("], data[");
      if (paramIntent != null) {
        bool = true;
      }
      QLog.w("AVRedBag", 1, bool + "]");
      if (paramIntent != null) {
        AudioHelper.a("发红包", paramIntent.getExtras());
      }
      return;
    }
    if (paramIntent == null)
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
    if (this.jdField_a_of_type_Kfe != null) {
      a(this.jdField_a_of_type_Kfe.jdField_b_of_type_Boolean);
    }
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
    return VideoController.a().a().jdField_g_of_type_Boolean;
  }
  
  public void c()
  {
    QLog.w("AVRedBag", 1, "clearWhenAVactivityStop, SendRedBag[" + this.jdField_a_of_type_ComTencentAvUiRedbagSendRedBag + "]");
    if (this.jdField_a_of_type_ComTencentAvUiRedbagSendRedBag != null)
    {
      this.jdField_a_of_type_ComTencentAvUiRedbagSendRedBag.a();
      this.jdField_a_of_type_ComTencentAvUiRedbagSendRedBag = null;
      a(false);
    }
    d("clearWhenAVactivityStop");
  }
  
  void c(ResultData paramResultData)
  {
    if ((!paramResultData.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new kea(this, paramResultData));
    }
  }
  
  public void c(String paramString)
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
    localObject = ((GameSink)localObject).jdField_a_of_type_ComTencentAvUiRedbagResultData;
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
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Kfe != null) {
      return this.jdField_a_of_type_Kfe.jdField_a_of_type_Boolean;
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
      ResultData localResultData = this.jdField_a_of_type_ComTencentAvUiRedbagGameSink.jdField_a_of_type_ComTencentAvUiRedbagResultData;
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
      return localAVActivity.d();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.redbag.AVRedBagMgr
 * JD-Core Version:    0.7.0.1
 */