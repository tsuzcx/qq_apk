package com.tencent.avgame.gameresult;

import android.text.TextUtils;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.listener.SimpleGameResultListener;
import com.tencent.avgame.ui.AVGameActivity;
import com.tencent.avgame.ui.IAVGameRootContainer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

class GameResultHelper$1
  extends SimpleGameResultListener
{
  GameResultHelper$1(GameResultHelper paramGameResultHelper) {}
  
  public void a(EngineData paramEngineData, int paramInt)
  {
    QLog.i(GameResultHelper.a(), 1, "onChangeUserStatusSuccess " + paramEngineData + " and from = " + paramInt);
    if (paramInt == 4) {
      this.a.a.b();
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    QLog.i(GameResultHelper.a(), 1, "onChangeUserStatusFailed " + paramString + " and from = " + paramInt2);
    if ((paramInt2 == 4) && ((this.a.a instanceof AVGameActivity)))
    {
      AVGameActivity localAVGameActivity = (AVGameActivity)this.a.a;
      if (!localAVGameActivity.isFinishing())
      {
        String str = paramString;
        if (TextUtils.isEmpty(paramString)) {
          str = localAVGameActivity.getString(2131690513);
        }
        QQToast.a(localAVGameActivity, 1, str, 1).a();
      }
    }
  }
  
  public void a(String paramString, int paramInt, EngineData paramEngineData)
  {
    if (QLog.isColorLevel()) {
      QLog.d(GameResultHelper.a(), 2, "pushOnChangeUserStatus uin = " + paramString);
    }
    if ((paramString.equals(GameEngine.a().a().getAccount())) && (paramInt == 1)) {
      this.a.a.b();
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isDebugVersion()) {
      QLog.i(GameResultHelper.a(), 1, String.format(Locale.ENGLISH, "onGameResultUpload isSucc[%b],playId[%s],fileType[%d],fileUrl[%s]", new Object[] { Boolean.valueOf(paramBoolean), paramString1, Integer.valueOf(paramInt), paramString2 }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultHelper.1
 * JD-Core Version:    0.7.0.1
 */