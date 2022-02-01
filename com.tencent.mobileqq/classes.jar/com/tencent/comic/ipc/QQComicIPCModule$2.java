package com.tencent.comic.ipc;

import android.os.Bundle;
import com.tencent.comic.config.QQComicConfBean;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.io.Serializable;

class QQComicIPCModule$2
  implements Runnable
{
  QQComicIPCModule$2(QQComicIPCModule paramQQComicIPCModule, int paramInt) {}
  
  public void run()
  {
    Object localObject1 = new Bundle();
    Object localObject2 = QQComicConfBean.a();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" ipExpressionConfig");
      localStringBuilder.append(localObject2);
      QLog.d("QQComicIPCModule", 2, localStringBuilder.toString());
    }
    ((Bundle)localObject1).putSerializable("ipExpressionConfig", (Serializable)localObject2);
    localObject2 = QQComicConfBean.a();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" hippyConfig");
      localStringBuilder.append(localObject2);
      QLog.d("QQComicIPCModule", 2, localStringBuilder.toString());
    }
    ((Bundle)localObject1).putSerializable("hippyConfig", (Serializable)localObject2);
    localObject1 = EIPCResult.createSuccessResult((Bundle)localObject1);
    this.this$0.callbackResult(this.a, (EIPCResult)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.ipc.QQComicIPCModule.2
 * JD-Core Version:    0.7.0.1
 */