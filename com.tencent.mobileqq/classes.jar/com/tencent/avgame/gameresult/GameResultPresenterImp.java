package com.tencent.avgame.gameresult;

import android.app.Activity;
import com.tencent.avgame.floatwindow.FloatWindowController;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.GameRecordInfo;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.listener.GameResultListener;
import com.tencent.avgame.report.AVGameNodeReportUtil;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.common.app.business.BaseAVGameAppInterface;
import com.tencent.mobileqq.app.avgameshare.AVGameShareUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class GameResultPresenterImp
  implements GameResultListener, IGameResultPresenter
{
  protected IGameResultView a;
  
  public GameResultPresenterImp(IGameResultView paramIGameResultView)
  {
    this.a = paramIGameResultView;
  }
  
  private void a()
  {
    EngineData localEngineData = GameEngine.a().a();
    GameEngine.a().a(localEngineData.b());
  }
  
  private void a(GameRecordInfo paramGameRecordInfo)
  {
    String str = paramGameRecordInfo.extraJsonData;
    Object localObject1 = null;
    if (str != null) {}
    try
    {
      localObject2 = new JSONObject(paramGameRecordInfo.extraJsonData);
      str = ((JSONObject)localObject2).optString("textContent", null);
    }
    catch (JSONException paramGameRecordInfo)
    {
      Object localObject2;
      label58:
      label63:
      label67:
      break label63;
    }
    try
    {
      paramGameRecordInfo = ((JSONObject)localObject2).optString("bgUrl", null);
    }
    catch (JSONException paramGameRecordInfo)
    {
      break label58;
    }
    try
    {
      localObject2 = ((JSONObject)localObject2).optString("imageUrl", null);
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      break label67;
    }
    paramGameRecordInfo = null;
    break label67;
    str = null;
    paramGameRecordInfo = str;
    this.a.b(str, localObject1, paramGameRecordInfo);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uploadRes:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString2);
      QLog.i("GameResultPresenterImp", 1, localStringBuilder.toString());
    }
    this.a.a(paramInt, paramString2, paramString1);
    GameEngine.a().a(paramString2, paramString1);
  }
  
  public void a(EngineData paramEngineData, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onChangeUserStatusSuccess ");
    localStringBuilder.append(paramEngineData);
    localStringBuilder.append(" and from = ");
    localStringBuilder.append(paramInt);
    QLog.i("GameResultPresenterImp", 1, localStringBuilder.toString());
    if (paramInt == 4) {
      this.a.b(paramEngineData);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onChangeUserStatusFailed ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" and from = ");
    localStringBuilder.append(paramInt2);
    QLog.i("GameResultPresenterImp", 1, localStringBuilder.toString());
    if (paramInt2 == 4) {
      this.a.a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt, EngineData paramEngineData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pushOnChangeUserStatus uin = ");
      localStringBuilder.append(paramString);
      QLog.d("GameResultPresenterImp", 2, localStringBuilder.toString());
    }
    if ((paramString.equals(GameEngine.a().a().getAccount())) && (paramInt == 1)) {
      this.a.b(paramEngineData);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    IGameResultView localIGameResultView = this.a;
    if (localIGameResultView != null) {
      localIGameResultView.a(paramString1, paramString2, paramString3);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isDebugVersion()) {
      QLog.i("GameResultPresenterImp_GameRC", 1, String.format("onGameResultUpload isSucc[%b],playId[%s],fileType[%d],fileUrl[%s]", new Object[] { Boolean.valueOf(paramBoolean), paramString1, Integer.valueOf(paramInt), paramString2 }));
    }
    if ((paramBoolean) && (paramInt == 0)) {
      AVGameShareUtil.a().a(paramString1, paramString2);
    }
  }
  
  public boolean a()
  {
    return GameEngine.a().d();
  }
  
  public void b()
  {
    GameEngine.a().a(this);
    GameRecordInfo localGameRecordInfo = GameEngine.a().a().a();
    if (localGameRecordInfo.gameType == 5)
    {
      a(localGameRecordInfo);
      return;
    }
    String str1 = localGameRecordInfo.photoFilePath;
    String str2 = localGameRecordInfo.videoFilePath;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pic:");
      localStringBuilder.append(str1);
      localStringBuilder.append(",\nvod:");
      localStringBuilder.append(str2);
      QLog.i("GameResultPresenterImp_GameRC", 1, localStringBuilder.toString());
    }
    GameEngine.a().a(str1, str2);
    this.a.a(localGameRecordInfo.gameType, str1, str2);
  }
  
  public void c()
  {
    GameEngine.a().b(this);
  }
  
  public void d()
  {
    EngineData localEngineData = GameEngine.a().a();
    GameEngine.a().a(localEngineData.a(), GameEngine.a().a().getAccount(), 1, 4);
    a();
    GameEngine.a().a().a(null, null, 0L);
    GameEngine.a().a().a(null);
    if ((localEngineData.j()) && (localEngineData.e(GameEngine.a().a().getCurrentAccountUin())) && (AVGameUtil.b() == 2))
    {
      GameEngine.a().c(0);
      localEngineData.e(true);
    }
    AVGameNodeReportUtil.f();
  }
  
  public void e()
  {
    if (this.a != null) {
      FloatWindowController.a().a(this.a.a(), false, true);
    }
  }
  
  public void f()
  {
    a();
    QLog.i("GameResultPresenterImp", 1, "exitGameRoom from result.");
    GameEngine.a().a(false, 1);
    if (this.a.a() != null) {
      this.a.a().finish();
    }
  }
  
  public void g()
  {
    GameEngine.a().d();
    BaseAVGameAppInterface localBaseAVGameAppInterface = GameEngine.a().a();
    String str1 = localBaseAVGameAppInterface.getCurrentAccountUin();
    EngineData localEngineData = GameEngine.a().a();
    long l = localEngineData.a();
    String str2 = localEngineData.a().getNick(str1);
    String str3 = localEngineData.b();
    int i = localEngineData.c();
    int j = localEngineData.d();
    if ((i != 2) && (i != 4) && (i != 5))
    {
      AVGameShareUtil.a().a(localBaseAVGameAppInterface, this.a.a(), l, Long.valueOf(str1).longValue(), str2, str3, j);
      return;
    }
    this.a.a(localBaseAVGameAppInterface, l, str1, j, str2, str3);
  }
  
  public void i(EngineData paramEngineData)
  {
    IGameResultView localIGameResultView = this.a;
    if (localIGameResultView != null) {
      localIGameResultView.a(paramEngineData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultPresenterImp
 * JD-Core Version:    0.7.0.1
 */