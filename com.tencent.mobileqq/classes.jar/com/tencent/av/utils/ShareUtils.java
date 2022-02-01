package com.tencent.av.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;

public class ShareUtils
{
  public static String a = "ShareUtils";
  
  public static JumpAction a(JumpAction paramJumpAction, Context paramContext, String paramString)
  {
    if ((paramContext instanceof JumpActivity))
    {
      paramContext = ((JumpActivity)paramContext).getIntent();
      if (paramContext != null) {
        paramJumpAction.a("from_url_InternalCheck", paramContext.getStringExtra("url"));
      }
    }
    Object localObject = JumpParser.a(paramString, "?");
    paramContext = localObject[0];
    localObject = localObject[1];
    paramContext = paramContext.split("//");
    if (paramContext.length != 2) {
      return null;
    }
    paramJumpAction.a = paramString;
    paramJumpAction.b = "mqqavshare://";
    paramJumpAction.c = paramContext[1];
    paramContext = new StringBuilder();
    paramContext.append("parser, jumpStr[");
    paramContext.append(paramString);
    paramContext.append("], server_name[");
    paramContext.append(paramJumpAction.b);
    paramContext.append("], action_name[");
    paramContext.append(paramJumpAction.c);
    paramContext.append("]");
    paramContext = paramContext.toString();
    localObject = ((String)localObject).split("&");
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      String[] arrayOfString = localObject[i].split("=");
      paramString = paramContext;
      if (arrayOfString.length == 2)
      {
        paramString = JumpParser.a(arrayOfString[1], false);
        paramJumpAction.a(arrayOfString[0], paramString);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramContext);
        localStringBuilder.append(", [");
        localStringBuilder.append(arrayOfString[0]);
        localStringBuilder.append("]=[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        paramString = localStringBuilder.toString();
      }
      i += 1;
      paramContext = paramString;
    }
    QLog.w(a, 1, paramContext);
    return paramJumpAction;
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString1);
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("image_url", localArrayList);
    localBundle.putString("title", paramString2);
    localBundle.putString("desc", paramString3);
    localBundle.putLong("req_share_id", 0L);
    localBundle.putString("detail_url", paramString4);
    QZoneShareManager.jumpToQzoneShare(paramAppInterface, paramContext, localBundle, null);
    if (QLog.isColorLevel())
    {
      paramAppInterface = a;
      paramContext = new StringBuilder();
      paramContext.append("shareToQzone. title:");
      paramContext.append(paramString2);
      paramContext.append(" desc:");
      paramContext.append(paramString3);
      paramContext.append(" shareLink:");
      paramContext.append(paramString4);
      paramContext.append(" icon:");
      paramContext.append(paramString1);
      QLog.i(paramAppInterface, 2, paramContext.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.ShareUtils
 * JD-Core Version:    0.7.0.1
 */