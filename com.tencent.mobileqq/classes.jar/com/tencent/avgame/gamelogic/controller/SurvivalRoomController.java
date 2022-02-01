package com.tencent.avgame.gamelogic.controller;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.listener.GameActivityLifeCycleListener;
import com.tencent.avgame.ipc.AVGameClientQIPCModule;
import com.tencent.avgame.qav.IAVGameBusinessCtrl;
import com.tencent.avgame.qav.IAVGameBusinessCtrl.IOnEnterRoom;
import com.tencent.avgame.qav.videorecord.SimpleGameRoomStatusListener;
import com.tencent.avgame.report.AVGameNodeReportUtil;
import com.tencent.avgame.report.AVGamePerfReporter;
import com.tencent.avgame.report.exception.AVGameExceptionReporter;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.avgame.ui.AVGameHandler;
import com.tencent.avgame.ui.IAVGameRootContainer;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.avgame.util.AvGameEntranceUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class SurvivalRoomController
  implements ISurvivalRoomController, IAVGameBusinessCtrl.IOnEnterRoom
{
  private RoomController jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController;
  private final GameActivityLifeCycleListener jdField_a_of_type_ComTencentAvgameGamelogicListenerGameActivityLifeCycleListener = new SurvivalRoomController.2(this);
  private SimpleGameRoomStatusListener jdField_a_of_type_ComTencentAvgameQavVideorecordSimpleGameRoomStatusListener = new SurvivalRoomController.1(this);
  private Runnable jdField_a_of_type_JavaLangRunnable;
  
  public SurvivalRoomController(RoomController paramRoomController)
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController = paramRoomController;
    c();
  }
  
  private QBaseActivity a()
  {
    Activity localActivity = this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameActivityLifeCycleListener.a();
    if ((localActivity != null) && ((localActivity instanceof IAVGameRootContainer))) {
      return (QBaseActivity)localActivity;
    }
    return null;
  }
  
  private void a(QBaseActivity paramQBaseActivity, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enterAVGameFail, reason[");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("], retCode[");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("]");
    QLog.i("SurvivalRoomController", 1, localStringBuilder.toString());
    if (paramInt1 == 4)
    {
      AVGameNodeReportUtil.b(-102);
      AVGameUtil.a(paramQBaseActivity.getString(2131690457), paramQBaseActivity);
      AVGameNodeReportUtil.b(-202);
    }
    else
    {
      AVGameUtil.a(paramQBaseActivity.getString(2131690328), paramQBaseActivity);
      AVGameNodeReportUtil.b(-201);
    }
    if ((paramQBaseActivity instanceof IAVGameRootContainer)) {
      ((IAVGameRootContainer)paramQBaseActivity).notifyExitGamed();
    }
    IGameEngine.a().a(false, 7);
  }
  
  private void a(QBaseActivity paramQBaseActivity, long paramLong, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SurvivalRoomController", 2, "beginRoomProcess");
    }
    if (IGameEngine.k()) {
      return;
    }
    AVGamePerfReporter.a().a("param_StepGameReady");
    IGameEngine.a().a(Long.valueOf(paramLong).longValue());
    IGameEngine.a().a(Long.valueOf(paramLong).longValue(), paramQBaseActivity.getCurrentAccountUinFromRuntime());
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      AVGameHandler.a().a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_JavaLangRunnable = new SurvivalRoomController.3(this, paramQBaseActivity, paramLong, paramArrayOfByte);
    AVGameHandler.a().a().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  private void a(QBaseActivity paramQBaseActivity, String paramString, byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doEnterVirtualAVRoomProcess begin isFinishing:");
    localStringBuilder.append(paramQBaseActivity.isFinishing());
    localStringBuilder.append(" mRoomId:");
    localStringBuilder.append(paramString);
    QLog.i("SurvivalRoomController", 1, localStringBuilder.toString());
    if ((paramQBaseActivity instanceof IAVGameRootContainer)) {
      ((IAVGameRootContainer)paramQBaseActivity).updateRoomInfo(String.valueOf(paramString), paramArrayOfByte);
    }
    onEnterRoom(0);
  }
  
  private void b(QBaseActivity paramQBaseActivity, String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doEnterAVRoomProcess begin isFinishing:");
    ((StringBuilder)localObject).append(paramQBaseActivity.isFinishing());
    ((StringBuilder)localObject).append(" mRoomId:");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("SurvivalRoomController", 1, ((StringBuilder)localObject).toString());
    localObject = AVGameSession.a(11, Long.valueOf(paramString).longValue());
    if (IAVGameBusinessCtrl.f()) {
      return;
    }
    AVGameSession localAVGameSession = IAVGameBusinessCtrl.a().a();
    int i = 0;
    if ((localAVGameSession != null) && (localAVGameSession.a.equalsIgnoreCase((String)localObject)))
    {
      if (localAVGameSession.a() == 2)
      {
        onEnterRoom(5);
        break label141;
      }
      if (localAVGameSession.a() == 1)
      {
        onEnterRoom(6);
        break label141;
      }
    }
    i = 1;
    label141:
    if (i == 0) {
      return;
    }
    if ((localAVGameSession != null) && (!IGameEngine.k()))
    {
      l = System.currentTimeMillis();
      AVGamePerfReporter.a().a(0, IGameEngine.a().a().a(), IGameEngine.a().a().b(), 0L);
      AVGameHandler.a().a().post(new SurvivalRoomController.4(this, l));
      if (QLog.isColorLevel()) {
        QLog.d("SurvivalRoomController", 2, "mEnterAvRoomRunnable exit old session");
      }
    }
    long l = System.currentTimeMillis();
    if (TextUtils.isEmpty(paramString))
    {
      a(paramQBaseActivity, 1, 1);
      return;
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      AVGameNodeReportUtil.b();
      if (!IGameEngine.k())
      {
        if (IAVGameBusinessCtrl.f()) {
          return;
        }
        if ((IGameEngine.a().f()) && (IGameEngine.a().i())) {
          i = 4;
        } else {
          i = 2;
        }
        i = IAVGameBusinessCtrl.a().a(paramString, paramArrayOfByte, 1, i, this);
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("doEnterAVRoomProcess enterRoom coast ");
          paramString.append(System.currentTimeMillis() - l);
          paramString.append(" retCode=");
          paramString.append(i);
          QLog.d("SurvivalRoomController", 2, paramString.toString());
        }
        if (i != 0)
        {
          a(paramQBaseActivity, 2, i);
          return;
        }
        if (IAVGameBusinessCtrl.a().a() == null)
        {
          a(paramQBaseActivity, 3, 1);
          return;
        }
        paramString = new StringBuilder();
        paramString.append("doEnterAVRoomProcess end isFinishing:");
        paramString.append(paramQBaseActivity.isFinishing());
        QLog.i("SurvivalRoomController", 1, paramString.toString());
      }
      return;
    }
    a(paramQBaseActivity, 1, 2);
  }
  
  private void c(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dealWithRoomEnter ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" retCode:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("SurvivalRoomController", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    if ((paramInt == 0) && (paramRoomInfo != null))
    {
      paramLong = paramRoomInfo.id;
      paramString = (IAVGameRootContainer)localObject;
      if (!paramString.checkDestroyed())
      {
        IGameEngine.a().a(paramRoomInfo);
        paramString.updateRoomInfo(String.valueOf(paramLong), paramArrayOfByte);
        IGameEngine.a().a(paramLong, ((QBaseActivity)localObject).getCurrentAccountUinFromRuntime(), true, true);
        a((QBaseActivity)localObject, paramLong, paramArrayOfByte);
        return;
      }
      return;
    }
    paramString = AvGameEntranceUtil.a(paramBoolean, (Context)localObject, paramInt, paramLong, paramString);
    AVGameUtil.a(paramString, (Activity)localObject);
    paramRoomInfo = IGameEngine.a();
    int i = 7;
    paramRoomInfo.a(false, 7);
    if (IGameEngine.a().i())
    {
      paramRoomInfo = AVGameExceptionReporter.a();
      if (paramBoolean) {
        i = 6;
      }
      paramRoomInfo.a(i, null, String.valueOf(paramInt), paramString);
    }
  }
  
  private void d()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SurvivalRoomController", 2, "leavePkRoom ");
    }
    IGameEngine.a().b(false, 12);
    if (IGameEngine.a().a() == null) {
      return;
    }
    IGameEngine.a().a().a(0, "");
  }
  
  public void a(long paramLong, int paramInt, String paramString, RoomInfo paramRoomInfo)
  {
    if (IGameEngine.k()) {
      return;
    }
    paramString = IGameEngine.a().a();
    if (paramString.n() == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SurvivalRoomController", 2, "onLeaveGameRoomSuccess() pk to create or join new room ");
      }
      if (paramString.n() == 2) {
        d();
      }
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SurvivalRoomController", 2, String.format("onCreateRoom isSuc:%b retCode:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    if (!paramBoolean)
    {
      IGameEngine.a().m();
      return;
    }
    IGameEngine.a().a().e(4);
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController.a(paramRoomInfo, true);
    c(true, paramInt, paramString, paramRoomInfo, paramArrayOfByte, paramLong);
  }
  
  public void a(boolean paramBoolean1, long paramLong1, boolean paramBoolean2, long paramLong2, boolean paramBoolean3, long paramLong3)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void b()
  {
    IGameEngine.a().b(this.jdField_a_of_type_ComTencentAvgameQavVideorecordSimpleGameRoomStatusListener);
    IGameEngine.a().b(this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameActivityLifeCycleListener);
  }
  
  protected void b(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SurvivalRoomController", 2, String.format("onJoinRoom isSuc:%b retCode:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    if (!paramBoolean)
    {
      IGameEngine.a().m();
      return;
    }
    IGameEngine.a().a().f(2);
    IGameEngine.a().a().e(4);
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController.a(paramRoomInfo, true);
    c(false, paramInt, paramString, paramRoomInfo, paramArrayOfByte, paramLong);
    IGameEngine.a().b("", IGameEngine.a().a());
  }
  
  public void c()
  {
    IGameEngine.a().a(this.jdField_a_of_type_ComTencentAvgameQavVideorecordSimpleGameRoomStatusListener);
    IGameEngine.a().a(this.jdField_a_of_type_ComTencentAvgameGamelogicListenerGameActivityLifeCycleListener);
  }
  
  public void onEnterRoom(int paramInt)
  {
    QBaseActivity localQBaseActivity = a();
    if (localQBaseActivity == null) {
      return;
    }
    if (((IAVGameRootContainer)localQBaseActivity).getGameExitStatus()) {
      return;
    }
    AVGameNodeReportUtil.c();
    ThreadManager.c(new SurvivalRoomController.5(this, localQBaseActivity, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.SurvivalRoomController
 * JD-Core Version:    0.7.0.1
 */