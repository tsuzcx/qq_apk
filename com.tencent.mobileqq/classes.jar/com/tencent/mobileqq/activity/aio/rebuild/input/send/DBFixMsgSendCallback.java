package com.tencent.mobileqq.activity.aio.rebuild.input.send;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.ISendMessageCallback;
import com.tencent.mobileqq.activity.aio.core.input.SendLogicParam;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.persistence.service.ICommonFunctionPublishConfigService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class DBFixMsgSendCallback
  implements ISendMessageCallback
{
  public void a(AIOContext paramAIOContext, String paramString1, String paramString2)
  {
    QQAppInterface localQQAppInterface = paramAIOContext.a();
    File localFile = localQQAppInterface.getApplication().getDatabasePath(paramString1);
    if ((localFile.exists()) && (localFile.length() != 0L))
    {
      paramAIOContext = paramAIOContext.b();
      if (!CheckPermission.isHasStoragePermission(paramAIOContext))
      {
        CheckPermission.requestSDCardPermission(paramAIOContext, new DBFixMsgSendCallback.1(this, localQQAppInterface, localFile, paramString1, paramString2));
        return;
      }
      a(localQQAppInterface, localFile, paramString1, paramString2);
      return;
    }
    QLog.d("DBFixMsgSendCallback", 1, new Object[] { "could't find temp DB File: ", paramString1 });
    QQToast.makeText(localQQAppInterface.getApp(), "找不到聊天记录文件！", 1).show();
  }
  
  public void a(QQAppInterface paramQQAppInterface, File paramFile, String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramFile.getAbsolutePath());
    Object localObject = paramQQAppInterface.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("-wal");
    localObject = ((MobileQQ)localObject).getDatabasePath(localStringBuilder.toString());
    if ((((File)localObject).exists()) && (paramFile.length() > 0L)) {
      localArrayList.add(((File)localObject).getAbsolutePath());
    }
    localObject = paramQQAppInterface.getApplication();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("-shm");
    paramString1 = ((MobileQQ)localObject).getDatabasePath(localStringBuilder.toString());
    if ((paramString1.exists()) && (paramFile.length() > 0L)) {
      localArrayList.add(paramString1.getAbsolutePath());
    }
    ThreadManager.getFileThreadHandler().post(new DBFixMsgSendCallback.2(this, paramString2, localArrayList, paramQQAppInterface));
  }
  
  public void afterMessageSend(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam) {}
  
  public boolean beforeMessageSend(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam)
  {
    if (!((ICommonFunctionPublishConfigService)QRoute.api(ICommonFunctionPublishConfigService.class)).isCopyDBCommandEnable()) {
      return false;
    }
    if (paramSendLogicParam.a().equals("$dump#chat*history"))
    {
      a(paramAIOContext, "chat.trace", "chat.zip");
      a(paramAIOContext, "chat_ex.trace", "chat_ex.zip");
      return true;
    }
    return false;
  }
  
  public boolean onMessageSending(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.send.DBFixMsgSendCallback
 * JD-Core Version:    0.7.0.1
 */