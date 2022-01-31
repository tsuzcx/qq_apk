package com.tencent.av.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;

public class ShareUtils
{
  public static String a = "ShareUtils";
  
  public static void a(AppInterface paramAppInterface, Activity paramActivity, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramAppInterface = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).b(1).a("推荐公会：" + paramString2).c(paramString4).a();
    paramAppInterface.mSourceName = "QQ公会";
    paramString4 = StructMsgElementFactory.a(2);
    paramString4.a(paramString1, paramString2, paramString3);
    paramAppInterface.addItem(paramString4);
    paramString1 = new Intent();
    paramString1.putExtra("forward_type", -3);
    paramString1.putExtra("stuctmsg_bytes", paramAppInterface.getBytes());
    ForwardBaseOption.a(paramActivity, paramString1, paramInt);
  }
  
  @SuppressLint({"NewApi"})
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      paramAppInterface = "点击链接加入开黑语音房间\"" + paramString1 + "\":\n" + paramString2;
      if (Build.VERSION.SDK_INT < 11) {
        ((android.text.ClipboardManager)paramContext.getSystemService("clipboard")).setText(paramAppInterface);
      }
      for (;;)
      {
        QQToast.a(paramContext, 2, "已复制语音房间链接地址", 0).b(paramContext.getResources().getDimensionPixelSize(2131558448));
        return;
        ((android.content.ClipboardManager)paramContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("discussion_url", paramAppInterface));
      }
    }
    QQToast.a(paramContext, 2, "复制语音房间链接失败", 0).b(paramContext.getResources().getDimensionPixelSize(2131558448));
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
    QZoneShareManager.a(paramAppInterface, paramContext, localBundle, null);
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "shareToQzone. title:" + paramString2 + " desc:" + paramString3 + " shareLink:" + paramString4 + " icon:" + paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.utils.ShareUtils
 * JD-Core Version:    0.7.0.1
 */