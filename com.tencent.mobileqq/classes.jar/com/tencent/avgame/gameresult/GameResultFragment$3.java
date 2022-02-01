package com.tencent.avgame.gameresult;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.avgameshare.AVGameShareUtil.AVGameShareProxy;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class GameResultFragment$3
  implements AVGameShareUtil.AVGameShareProxy
{
  GameResultFragment$3(GameResultFragment paramGameResultFragment) {}
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getShareLinkCallback isSuccess: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" shareUrl: ");
    localStringBuilder.append(paramString);
    QLog.d("GameResultFragment", 1, localStringBuilder.toString());
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      ThreadManager.getUIHandler().post(new GameResultFragment.3.1(this, paramString));
      return;
    }
    QQToast.a(this.a.a(), 1, 2131690527, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultFragment.3
 * JD-Core Version:    0.7.0.1
 */