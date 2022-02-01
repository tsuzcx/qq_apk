package com.tencent.mobileqq.activity.aio.rebuild.input.send;

import android.os.Environment;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.ISendMessageCallback;
import com.tencent.mobileqq.activity.aio.core.input.SendLogicParam;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.persistence.service.ICommonFunctionPublishConfigService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class DBFixMsgSendCallback
  implements ISendMessageCallback
{
  public void a(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam) {}
  
  public void a(QQAppInterface paramQQAppInterface, File paramFile)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
    localStringBuilder.append("/tencent/com.tencent.mobileqq/data/");
    localStringBuilder.append("chat.trace");
    if (FileUtils.copyFile(paramFile, new File(localStringBuilder.toString())))
    {
      QLog.d("DBFixMsgSendCallback", 1, "copy db success!");
      QQToast.a(paramQQAppInterface.getApp(), "拷贝成功！", 1).a();
      return;
    }
    QLog.d("DBFixMsgSendCallback", 1, "copy db fail!");
    QQToast.a(paramQQAppInterface.getApp(), "拷贝失败，请重试！", 1).a();
  }
  
  public boolean a(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam)
  {
    if (!((ICommonFunctionPublishConfigService)QRoute.api(ICommonFunctionPublishConfigService.class)).isCopyDBCommandEnable()) {
      return false;
    }
    if (paramSendLogicParam.a().equals("$dump#chat*history"))
    {
      paramSendLogicParam = paramAIOContext.a();
      File localFile = paramSendLogicParam.getApplication().getDatabasePath("chat.trace");
      if ((localFile.exists()) && (localFile.length() != 0L))
      {
        paramAIOContext = paramAIOContext.a();
        if (!CheckPermission.isHasStoragePermission(paramAIOContext))
        {
          CheckPermission.requestSDCardPermission(paramAIOContext, new DBFixMsgSendCallback.1(this, paramSendLogicParam, localFile));
          return true;
        }
        a(paramSendLogicParam, localFile);
        return true;
      }
      QLog.d("DBFixMsgSendCallback", 1, "could't find temp DB File");
      QQToast.a(paramSendLogicParam.getApp(), "找不到聊天记录文件！", 1).a();
      return true;
    }
    return false;
  }
  
  public boolean a(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.send.DBFixMsgSendCallback
 * JD-Core Version:    0.7.0.1
 */