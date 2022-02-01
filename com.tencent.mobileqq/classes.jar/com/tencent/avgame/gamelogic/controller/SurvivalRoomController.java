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
  private RoomController a;
  private Runnable b;
  private SimpleGameRoomStatusListener c = new SurvivalRoomController.1(this);
  private final GameActivityLifeCycleListener d = new SurvivalRoomController.2(this);
  
  public SurvivalRoomController(RoomController paramRoomController)
  {
    this.a = paramRoomController;
    c();
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
      AVGameUtil.a(paramQBaseActivity.getString(2131887368), paramQBaseActivity);
      AVGameNodeReportUtil.b(-202);
    }
    else
    {
      AVGameUtil.a(paramQBaseActivity.getString(2131887239), paramQBaseActivity);
      AVGameNodeReportUtil.b(-201);
    }
    if ((paramQBaseActivity instanceof IAVGameRootContainer)) {
      ((IAVGameRootContainer)paramQBaseActivity).notifyExitGamed();
    }
    IGameEngine.I().a(false, 7);
  }
  
  private void a(QBaseActivity paramQBaseActivity, long paramLong, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SurvivalRoomController", 2, "beginRoomProcess");
    }
    if (IGameEngine.J()) {
      return;
    }
    AVGamePerfReporter.a().a("param_StepGameReady");
    IGameEngine.I().a(Long.valueOf(paramLong).longValue());
    IGameEngine.I().a(Long.valueOf(paramLong).longValue(), paramQBaseActivity.getCurrentAccountUinFromRuntime());
    if (this.b != null) {
      AVGameHandler.a().b().removeCallbacks(this.b);
    }
    this.b = new SurvivalRoomController.3(this, paramQBaseActivity, paramLong, paramArrayOfByte);
    AVGameHandler.a().b().post(this.b);
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
    if (IAVGameBusinessCtrl.q()) {
      return;
    }
    AVGameSession localAVGameSession = IAVGameBusinessCtrl.p().j();
    int i = 0;
    if ((localAVGameSession != null) && (localAVGameSession.b.equalsIgnoreCase((String)localObject)))
    {
      if (localAVGameSession.c() == 2)
      {
        onEnterRoom(5);
        break label141;
      }
      if (localAVGameSession.c() == 1)
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
    if ((localAVGameSession != null) && (!IGameEngine.J()))
    {
      l = System.currentTimeMillis();
      AVGamePerfReporter.a().a(0, IGameEngine.I().s().i(), IGameEngine.I().s().n(), 0L);
      AVGameHandler.a().b().post(new SurvivalRoomController.4(this, l));
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
      if (!IGameEngine.J())
      {
        if (IAVGameBusinessCtrl.q()) {
          return;
        }
        if ((IGameEngine.I().A()) && (IGameEngine.I().D())) {
          i = 4;
        } else {
          i = 2;
        }
        i = IAVGameBusinessCtrl.p().a(paramString, paramArrayOfByte, 1, i, this);
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
        if (IAVGameBusinessCtrl.p().j() == null)
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
    Object localObject = d();
    if (localObject == null) {
      return;
    }
    if ((paramInt == 0) && (paramRoomInfo != null))
    {
      paramLong = paramRoomInfo.id;
      paramString = (IAVGameRootContainer)localObject;
      if (!paramString.checkDestroyed())
      {
        IGameEngine.I().a(paramRoomInfo);
        paramString.updateRoomInfo(String.valueOf(paramLong), paramArrayOfByte);
        IGameEngine.I().a(paramLong, ((QBaseActivity)localObject).getCurrentAccountUinFromRuntime(), true, true);
        a((QBaseActivity)localObject, paramLong, paramArrayOfByte);
        return;
      }
      return;
    }
    paramString = AvGameEntranceUtil.a(paramBoolean, (Context)localObject, paramInt, paramLong, paramString);
    AVGameUtil.a(paramString, (Activity)localObject);
    paramRoomInfo = IGameEngine.I();
    int i = 7;
    paramRoomInfo.a(false, 7);
    if (IGameEngine.I().D())
    {
      paramRoomInfo = AVGameExceptionReporter.a();
      if (paramBoolean) {
        i = 6;
      }
      paramRoomInfo.a(i, null, String.valueOf(paramInt), paramString);
    }
  }
  
  private QBaseActivity d()
  {
    Activity localActivity = this.d.b();
    if ((localActivity != null) && ((localActivity instanceof IAVGameRootContainer))) {
      return (QBaseActivity)localActivity;
    }
    return null;
  }
  
  private void e()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SurvivalRoomController", 2, "leavePkRoom ");
    }
    IGameEngine.I().b(false, 12);
    if (IGameEngine.I().L() == null) {
      return;
    }
    IGameEngine.I().L().b(0, "");
  }
  
  public void a(long paramLong, int paramInt, String paramString, RoomInfo paramRoomInfo)
  {
    if (IGameEngine.J()) {
      return;
    }
    paramString = IGameEngine.I().s();
    if (paramString.W() == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SurvivalRoomController", 2, "onLeaveGameRoomSuccess() pk to create or join new room ");
      }
      if (paramString.W() == 2) {
        e();
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
      IGameEngine.I().y();
      return;
    }
    IGameEngine.I().s().f(4);
    this.a.a(paramRoomInfo, true);
    c(true, paramInt, paramString, paramRoomInfo, paramArrayOfByte, paramLong);
  }
  
  public void a(boolean paramBoolean1, long paramLong1, boolean paramBoolean2, long paramLong2, boolean paramBoolean3, long paramLong3)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void b()
  {
    IGameEngine.I().b(this.c);
    IGameEngine.I().b(this.d);
  }
  
  protected void b(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SurvivalRoomController", 2, String.format("onJoinRoom isSuc:%b retCode:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    if (!paramBoolean)
    {
      IGameEngine.I().y();
      return;
    }
    IGameEngine.I().s().g(2);
    IGameEngine.I().s().f(4);
    this.a.a(paramRoomInfo, true);
    c(false, paramInt, paramString, paramRoomInfo, paramArrayOfByte, paramLong);
    IGameEngine.I().b("", IGameEngine.I().s());
  }
  
  public void c()
  {
    IGameEngine.I().a(this.c);
    IGameEngine.I().a(this.d);
  }
  
  public void onEnterRoom(int paramInt)
  {
    QBaseActivity localQBaseActivity = d();
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