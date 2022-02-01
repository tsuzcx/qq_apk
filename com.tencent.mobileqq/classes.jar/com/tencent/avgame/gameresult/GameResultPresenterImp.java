package com.tencent.avgame.gameresult;

import android.app.Activity;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.floatwindow.FloatWindowController;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.GameRecordInfo;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.listener.GameResultListener;
import com.tencent.avgame.util.AVGameNodeReportUtil;
import com.tencent.avgame.util.AVGameUtils;
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
    Object localObject1 = null;
    if (paramGameRecordInfo.extraJsonData != null) {}
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject(paramGameRecordInfo.extraJsonData);
        str = ((JSONObject)localObject2).optString("textContent", null);
      }
      catch (JSONException paramGameRecordInfo)
      {
        Object localObject2;
        paramGameRecordInfo = null;
        str = null;
        continue;
      }
      try
      {
        paramGameRecordInfo = ((JSONObject)localObject2).optString("bgUrl", null);
      }
      catch (JSONException paramGameRecordInfo)
      {
        paramGameRecordInfo = null;
        continue;
      }
      try
      {
        localObject2 = ((JSONObject)localObject2).optString("imageUrl", null);
        localObject1 = localObject2;
      }
      catch (JSONException localJSONException)
      {
        continue;
      }
      this.a.b(str, localObject1, paramGameRecordInfo);
      return;
      paramGameRecordInfo = null;
      String str = null;
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameResultPresenterImp", 1, "uploadRes:" + paramInt + " " + paramString1 + " " + paramString2);
    }
    this.a.a(paramInt, paramString2, paramString1);
    GameEngine.a().a(paramString2, paramString1);
  }
  
  public void a(EngineData paramEngineData, int paramInt)
  {
    QLog.i("GameResultPresenterImp", 1, "onChangeUserStatusSuccess " + paramEngineData + " and from = " + paramInt);
    if (paramInt == 4) {
      this.a.b(paramEngineData);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    QLog.i("GameResultPresenterImp", 1, "onChangeUserStatusFailed " + paramString + " and from = " + paramInt2);
    if (paramInt2 == 4) {
      this.a.a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt, EngineData paramEngineData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameResultPresenterImp", 2, "pushOnChangeUserStatus uin = " + paramString);
    }
    if ((paramString.equals(GameEngine.a().a().getAccount())) && (paramInt == 1)) {
      this.a.b(paramEngineData);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (this.a != null) {
      this.a.a(paramString1, paramString2, paramString3);
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
    if (QLog.isColorLevel()) {
      QLog.i("GameResultPresenterImp_GameRC", 1, "pic:" + str1 + ",\nvod:" + str2);
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
    if ((localEngineData.j()) && (localEngineData.e(GameEngine.a().a().getCurrentAccountUin())) && (AVGameUtils.b() == 2))
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
    AVGameAppInterface localAVGameAppInterface = GameEngine.a().a();
    String str1 = localAVGameAppInterface.getCurrentAccountUin();
    EngineData localEngineData = GameEngine.a().a();
    long l = localEngineData.a();
    String str2 = localEngineData.a().getNick(str1);
    String str3 = localEngineData.b();
    int i = localEngineData.c();
    int j = localEngineData.d();
    if ((i == 2) || (i == 4) || (i == 5))
    {
      this.a.a(localAVGameAppInterface, l, str1, j, str2, str3);
      return;
    }
    AVGameShareUtil.a().a(localAVGameAppInterface, this.a.a(), l, Long.valueOf(str1).longValue(), str2, str3, j);
  }
  
  public void i(EngineData paramEngineData)
  {
    if (this.a != null) {
      this.a.a(paramEngineData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultPresenterImp
 * JD-Core Version:    0.7.0.1
 */