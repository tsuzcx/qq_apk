package com.tencent.avgame.gameresult;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.listener.SimpleGameResultListener;
import com.tencent.avgame.ui.IAVGameRootContainer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import mqq.app.AppRuntime;

class GameResultHelper$1
  extends SimpleGameResultListener
{
  GameResultHelper$1(GameResultHelper paramGameResultHelper) {}
  
  public void a(EngineData paramEngineData, int paramInt)
  {
    String str = GameResultHelper.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onChangeUserStatusSuccess ");
    localStringBuilder.append(paramEngineData);
    localStringBuilder.append(" and from = ");
    localStringBuilder.append(paramInt);
    QLog.i(str, 1, localStringBuilder.toString());
    if (paramInt == 4) {
      this.a.a.showRoom();
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    String str = GameResultHelper.a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onChangeUserStatusFailed ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" and from = ");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.i(str, 1, ((StringBuilder)localObject).toString());
    if ((paramInt2 == 4) && ((this.a.a instanceof Activity)))
    {
      localObject = (Activity)this.a.a;
      if (!((Activity)localObject).isFinishing())
      {
        str = paramString;
        if (TextUtils.isEmpty(paramString)) {
          str = ((Activity)localObject).getString(2131690438);
        }
        QQToast.a((Context)localObject, 1, str, 1).a();
      }
    }
  }
  
  public void a(String paramString, int paramInt, EngineData paramEngineData)
  {
    if (QLog.isColorLevel())
    {
      paramEngineData = GameResultHelper.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pushOnChangeUserStatus uin = ");
      localStringBuilder.append(paramString);
      QLog.d(paramEngineData, 2, localStringBuilder.toString());
    }
    if ((paramString.equals(IGameEngine.a().getAccount())) && (paramInt == 1)) {
      this.a.a.showRoom();
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isDebugVersion()) {
      QLog.i(GameResultHelper.a(), 1, String.format(Locale.ENGLISH, "onGameResultUpload isSucc[%b],playId[%s],fileType[%d],fileUrl[%s]", new Object[] { Boolean.valueOf(paramBoolean), paramString1, Integer.valueOf(paramInt), paramString2 }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultHelper.1
 * JD-Core Version:    0.7.0.1
 */