package com.tencent.mobileqq.apollo.utils;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ApolloGameUtil$CmStartTask
  implements Runnable
{
  public WeakReference a;
  public WeakReference b;
  
  public ApolloGameUtil$CmStartTask(QQAppInterface paramQQAppInterface, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramStartCheckParam);
  }
  
  public void a(QQAppInterface paramQQAppInterface, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramStartCheckParam);
  }
  
  public void run()
  {
    CmGameStartChecker.StartCheckParam localStartCheckParam;
    if ((this.a != null) && (this.a.get() != null) && (this.b != null) && (this.b.get() != null))
    {
      localObject = (QQAppInterface)this.a.get();
      localStartCheckParam = (CmGameStartChecker.StartCheckParam)this.b.get();
      if ((localObject != null) && (localStartCheckParam != null) && (CmGameUtil.a((QQAppInterface)localObject, localStartCheckParam))) {}
    }
    else
    {
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).setAction("com.tencent.mobileqq.webprocess.launch_cmgame");
    ((Intent)localObject).putExtra("extra_startcheckparam", localStartCheckParam);
    try
    {
      QLog.i("ApolloGameUtil", 2, "Send action launch_cmgame.");
      BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloGameUtil", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil.CmStartTask
 * JD-Core Version:    0.7.0.1
 */