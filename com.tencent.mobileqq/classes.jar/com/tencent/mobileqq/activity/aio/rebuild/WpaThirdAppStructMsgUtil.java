package com.tencent.mobileqq.activity.aio.rebuild;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.biz.widgets.ShareAioResultDialog;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class WpaThirdAppStructMsgUtil
{
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    paramActivity = paramActivity.getIntent();
    if (paramActivity == null) {
      return;
    }
    if ((paramActivity.getBooleanExtra("showFirstStructMsg", false)) && (paramBoolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("send3rdAppStructMsg", 2, "send first struct msg");
      }
      paramActivity = paramActivity.getByteArrayExtra("stuctmsg_bytes");
      if (paramActivity != null)
      {
        paramActivity = StructMsgFactory.a(paramActivity);
        if (paramActivity != null)
        {
          ShareMsgHelper.a(paramQQAppInterface, paramSessionInfo.b, paramSessionInfo.a, paramActivity, null);
          ReportController.b(paramQQAppInterface, "CliOper", "", paramSessionInfo.b, "0X8004B51", "0X8004B51", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, AbsShareMsg paramAbsShareMsg, String paramString)
  {
    ShareAioResultDialog localShareAioResultDialog = new ShareAioResultDialog(paramBaseActivity);
    String str = paramBaseActivity.getString(2131916399);
    Object localObject = str;
    if (paramString != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    paramAbsShareMsg = new WpaThirdAppStructMsgUtil.1(paramAbsShareMsg, paramBaseActivity, paramBaseActivity, paramQQAppInterface, paramSessionInfo);
    localShareAioResultDialog.a((String)localObject, paramAbsShareMsg);
    localShareAioResultDialog.a(paramBaseActivity.getResources().getString(2131916406));
    localShareAioResultDialog.a(paramAbsShareMsg);
    localShareAioResultDialog.a(false);
    localShareAioResultDialog.show();
    ReportController.b(paramQQAppInterface, "CliOper", "", paramSessionInfo.b, "0X8004B54", "0X8004B54", 0, 0, "", "", "", "");
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Intent paramIntent)
  {
    if ((paramIntent.getBooleanExtra("from3rdApp", false)) && (paramIntent.getBooleanExtra("showFirstStructMsg", false)))
    {
      paramIntent = paramIntent.getByteArrayExtra("stuctmsg_bytes");
      if (paramIntent != null)
      {
        paramIntent = StructMsgFactory.a(paramIntent);
        long l = MobileQQService.seq;
        paramSessionInfo = MessageRecordFactory.c(paramQQAppInterface, paramSessionInfo.b, paramSessionInfo.b, paramSessionInfo.b, paramSessionInfo.a, l, paramIntent);
        paramIntent = new ArrayList();
        paramIntent.add(paramSessionInfo);
        paramQQAppInterface.getMessageFacade().b(paramIntent, paramQQAppInterface.getCurrentAccountUin());
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, SessionInfo paramSessionInfo)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", paramSessionInfo.b, "0X8004B53", "0X8004B53", 0, 0, "", "", "", "");
    Object localObject = paramBaseActivity.getIntent().getByteArrayExtra("stuctmsg_bytes");
    String str = paramBaseActivity.getIntent().getStringExtra("thirdAppDisplayName");
    localObject = StructMsgFactory.a((byte[])localObject);
    if ((localObject != null) && ((localObject instanceof AbsShareMsg))) {
      localObject = (AbsShareMsg)localObject;
    } else {
      localObject = null;
    }
    if ("webview".equals(paramBaseActivity.getIntent().getStringExtra("from")))
    {
      JumpAction.l -= 1;
      if (!(paramBaseActivity instanceof SplashActivity))
      {
        paramBaseActivity.finish();
        return true;
      }
      return false;
    }
    a(paramQQAppInterface, paramBaseActivity, paramSessionInfo, (AbsShareMsg)localObject, str);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.WpaThirdAppStructMsgUtil
 * JD-Core Version:    0.7.0.1
 */