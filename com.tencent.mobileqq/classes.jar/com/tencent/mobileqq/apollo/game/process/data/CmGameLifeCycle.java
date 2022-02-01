package com.tencent.mobileqq.apollo.game.process.data;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.game.process.chanel.CmGameCmdChannel;
import com.tencent.mobileqq.apollo.game.process.chanel.GeneralEventHandler;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class CmGameLifeCycle
{
  public static String a = "cmgame_process.CmGameLifeCycle";
  public int b;
  private StartCheckParam c;
  private WeakReference<Activity> d;
  private GeneralEventHandler e;
  private int f;
  
  public CmGameLifeCycle(int paramInt)
  {
    this.f = paramInt;
  }
  
  private Activity b()
  {
    WeakReference localWeakReference = this.d;
    if (localWeakReference == null) {
      return null;
    }
    return (Activity)localWeakReference.get();
  }
  
  private QQAppInterface c()
  {
    AppInterface localAppInterface = CmGameUtil.b();
    if ((localAppInterface instanceof QQAppInterface)) {
      return (QQAppInterface)localAppInterface;
    }
    return null;
  }
  
  public int a()
  {
    return this.f;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[handleActLifeCycle], gameId:");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append(",status:");
    ((StringBuilder)localObject2).append(paramInt2);
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    localObject1 = c();
    if (localObject1 == null)
    {
      QLog.w(a, 1, "app is null.");
      return;
    }
    if (1 == paramInt2)
    {
      localObject2 = b();
      StartCheckParam localStartCheckParam = this.c;
      if ((localStartCheckParam != null) && (localObject2 != null))
      {
        if (localStartCheckParam.gameId != paramInt1)
        {
          QLog.w(a, 1, "not the same game.");
          return;
        }
        if (this.e != null) {
          CmGameCmdChannel.a((AppInterface)localObject1).b(this.e);
        }
        this.e = new GeneralEventHandler((Activity)localObject2, (QQAppInterface)localObject1, this.f);
        CmGameCmdChannel.a((AppInterface)localObject1).a(this.e);
        return;
      }
      QLog.w(a, 1, "null error.");
      return;
    }
    if (5 == paramInt2)
    {
      localObject2 = this.e;
      if (localObject2 != null)
      {
        ((GeneralEventHandler)localObject2).b();
        CmGameCmdChannel.a((AppInterface)localObject1).b(this.e);
        this.e = null;
      }
    }
  }
  
  public void a(Activity paramActivity, StartCheckParam paramStartCheckParam)
  {
    this.c = paramStartCheckParam;
    this.d = new WeakReference(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.data.CmGameLifeCycle
 * JD-Core Version:    0.7.0.1
 */