package com.tencent.avgame.gameresult;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.avgameshare.AVGameShareUtil.AVGameShareProxy;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class GamePKResultFragment$4
  implements AVGameShareUtil.AVGameShareProxy
{
  GamePKResultFragment$4(GamePKResultFragment paramGamePKResultFragment) {}
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    QLog.d("GamePKResultFragment", 1, "getShareLinkCallback isSuccess: " + paramBoolean + " shareUrl: " + paramString);
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      ThreadManager.getUIHandler().post(new GamePKResultFragment.4.1(this, paramString));
      return;
    }
    QQToast.a(this.a.a(), 1, 2131690599, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GamePKResultFragment.4
 * JD-Core Version:    0.7.0.1
 */