import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.ShareMsgHelper.1;
import com.tencent.mobileqq.utils.ShareMsgHelper.2;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class bhhn
  implements AppConstants
{
  public static Intent a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, Intent paramIntent, int paramInt3, String paramString19, long paramLong)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null)
    {
      localIntent = new Intent();
      localIntent.putExtra("key_flag_from_plugin", true);
      localIntent.setClass(paramContext, ForwardRecentActivity.class);
    }
    localIntent.putExtra("isFromShare", true);
    localIntent.putExtra("forward_type", paramInt1);
    localIntent.putExtra("pluginName", paramString1);
    localIntent.putExtra("req_type", paramInt2);
    localIntent.putExtra("detail_url", paramString7);
    localIntent.putExtra("image_url_remote", paramString3);
    localIntent.putExtra("source_url", paramString19);
    if (paramLong != -1L) {
      localIntent.putExtra("req_share_id", paramLong);
    }
    localIntent.putExtra("pubUin", paramString2);
    localIntent.putExtra("struct_uin", paramString2);
    if ((paramContext instanceof biex))
    {
      paramString2 = ((biex)paramContext).a();
      if (paramString2 != null)
      {
        localIntent.putExtra("strurt_msgid", paramString2.msgid);
        localIntent.putExtra("emoInputType", 1);
        localIntent.putExtra("forward _key_nojump", true);
      }
    }
    if ((paramInt2 == 44) || (paramInt2 == 1) || (paramInt2 == 95)) {
      localIntent.putExtra("forward _key_nojump", true);
    }
    paramString2 = paramString4;
    if (paramString4 != null)
    {
      paramString2 = paramString4;
      if (paramString4.length() > 45) {
        paramString2 = paramString4.substring(0, 45) + "…";
      }
    }
    localIntent.putExtra("title", paramString2);
    paramString2 = paramString5;
    if (paramString5 != null)
    {
      paramString2 = paramString5;
      if (paramString5.length() > 60) {
        paramString2 = paramString5.substring(0, 60) + "…";
      }
    }
    localIntent.putExtra("desc", paramString2);
    localIntent.putExtra("forward_thumb", paramString18);
    localIntent.putExtra("struct_share_key_content_action", paramString8);
    localIntent.putExtra("struct_share_key_content_a_action_DATA", paramString10);
    localIntent.putExtra("struct_share_key_content_i_action_DATA", paramString11);
    localIntent.putExtra("struct_share_key_content_action_DATA", paramString9);
    localIntent.putExtra("req_share_id", -1L);
    localIntent.putExtra("struct_share_key_source_action", paramString12);
    localIntent.putExtra("struct_share_key_source_action_data", paramString13);
    localIntent.putExtra("struct_share_key_source_a_action_data", paramString14);
    localIntent.putExtra("struct_share_key_source_i_action_data", paramString15);
    localIntent.putExtra("struct_share_key_source_icon", paramString16);
    localIntent.putExtra("app_name", paramString17);
    localIntent.putExtra("brief_key", paramString6);
    if ("struct_favorite".equals(paramString1))
    {
      localIntent.putExtra("k_favorites", false);
      localIntent.putExtra("forward _key_nojump", true);
    }
    paramString1 = bdof.a(localIntent.getExtras());
    if (paramString1 != null)
    {
      localIntent.putExtra("stuctmsg_bytes", paramString1.getBytes());
      if ((paramInt3 >= 0) && ((paramContext instanceof Activity))) {}
      do
      {
        do
        {
          do
          {
            return localIntent;
          } while (((1001 != paramInt1) && (38 != paramInt1)) || (!(paramContext instanceof biex)));
          paramContext = ((biex)paramContext).a();
        } while (paramContext == null);
        localIntent.putExtra("strurt_msgid", paramContext.msgid);
        localIntent.putExtra("struct_uin", paramContext.publicUin);
        localIntent.putExtra("struct_url", paramContext.mUrl);
        localIntent.putExtra("from_web", true);
      } while ((paramContext.sourcePuin == null) || ("".equals(paramContext.sourcePuin)));
      localIntent.putExtra("source_puin", paramContext.sourcePuin);
      return localIntent;
    }
    return null;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, AbsStructMsg paramAbsStructMsg)
  {
    String str = null;
    switch (paramInt)
    {
    default: 
      paramQQAppInterface = str;
    }
    for (;;)
    {
      return paramQQAppInterface;
      try
      {
        str = paramQQAppInterface.getCurrentAccountUin();
        int i = bcpt.a;
        bcpt.a = i + 1;
        paramString = bcsa.a(paramQQAppInterface, str, paramString, str, paramInt, i, paramAbsStructMsg);
        agfe.a().a(paramString.uniseq, 0L, paramAbsStructMsg.forwardID);
        paramQQAppInterface.getMessageFacade().addSendMessage(paramString, 0);
        paramQQAppInterface = paramString;
      }
      finally {}
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, AbsStructMsg paramAbsStructMsg, BusinessObserver paramBusinessObserver)
  {
    if (paramAbsStructMsg != null) {
      bdki.a(paramAbsStructMsg);
    }
    ThreadManager.post(new ShareMsgHelper.1(paramQQAppInterface, paramString, paramInt, paramAbsStructMsg, paramBusinessObserver), 8, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, AbsStructMsg paramAbsStructMsg, BusinessObserver paramBusinessObserver, String paramString2, String paramString3)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    String str = paramQQAppInterface.getCurrentAccountUin();
    int i = bcpt.a;
    bcpt.a = i + 1;
    long l = i;
    if (TextUtils.isEmpty(paramString1)) {}
    for (paramBusinessObserver = str;; paramBusinessObserver = paramString1)
    {
      paramAbsStructMsg = bcsa.a(paramQQAppInterface, str, paramString1, paramBusinessObserver, paramInt, l, paramAbsStructMsg);
      QLog.i(beay.i, 1, "sendDocsStructingMsg. disUin = " + paramString1 + ", disUinType = " + paramInt + ", seq = " + l + ", shmsgseq = " + paramAbsStructMsg.shmsgseq + ", time = " + paramAbsStructMsg.time);
      paramQQAppInterface.getMessageFacade().addAndSendMessage(paramAbsStructMsg, null);
      if ((paramInt != 0) && (paramInt != 1)) {
        break;
      }
      becr.a(paramQQAppInterface, paramString1, paramInt, paramAbsStructMsg.shmsgseq, paramAbsStructMsg.time + 1L, paramString2, paramString3);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, AbsStructMsg paramAbsStructMsg, BusinessObserver paramBusinessObserver)
  {
    if (paramAbsStructMsg != null) {
      bdki.a(paramAbsStructMsg);
    }
    ThreadManager.getSubThreadHandler().post(new ShareMsgHelper.2(paramQQAppInterface, paramString1, paramString2, paramInt, paramAbsStructMsg, paramBusinessObserver));
  }
  
  public static boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, Intent paramIntent, int paramInt3)
  {
    return a(paramContext, paramInt1, paramInt2, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13, paramString14, paramString15, paramString16, paramString17, "", paramIntent, paramInt3, null, -1L);
  }
  
  public static boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18)
  {
    return a(paramContext, paramInt1, paramInt2, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13, paramString14, paramString15, paramString16, paramString17, "", null, -1, paramString18, -1L);
  }
  
  public static boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, Intent paramIntent, int paramInt3, String paramString19, long paramLong)
  {
    paramString1 = a(paramContext, paramInt1, paramInt2, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13, paramString14, paramString15, paramString16, paramString17, paramString18, paramIntent, paramInt3, paramString19, paramLong);
    if (paramString1 != null)
    {
      if ((paramInt3 >= 0) && ((paramContext instanceof Activity))) {
        ((Activity)paramContext).startActivityForResult(paramString1, paramInt3);
      }
      for (;;)
      {
        return true;
        paramContext.startActivity(paramString1);
      }
    }
    return false;
  }
  
  public static boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_flag_from_plugin", true);
    localIntent.putExtra("forward _key_nojump", true);
    localIntent.putExtra("k_back", false);
    localIntent.setClass(paramContext, ForwardRecentActivity.class);
    localIntent.putExtra("isFromShare", true);
    localIntent.putExtra("forward_type", paramInt1);
    localIntent.putExtra("pluginName", paramString1);
    localIntent.putExtra("req_type", paramInt2);
    localIntent.putExtra("detail_url", paramString7);
    localIntent.putExtra("image_url_remote", paramString3);
    localIntent.putExtra("source_url", paramString18);
    localIntent.putExtra("pubUin", paramString2);
    localIntent.putExtra("struct_uin", paramString2);
    paramString1 = paramString4;
    if (paramString4 != null)
    {
      paramString1 = paramString4;
      if (paramString4.length() > 45) {
        paramString1 = paramString4.substring(0, 45) + "…";
      }
    }
    localIntent.putExtra("title", paramString1);
    paramString1 = paramString5;
    if (paramString5 != null)
    {
      paramString1 = paramString5;
      if (paramString5.length() > 60) {
        paramString1 = paramString5.substring(0, 60) + "…";
      }
    }
    localIntent.putExtra("desc", paramString1);
    localIntent.putExtra("forward_thumb", "");
    localIntent.putExtra("struct_share_key_content_action", paramString8);
    localIntent.putExtra("struct_share_key_content_a_action_DATA", paramString10);
    localIntent.putExtra("struct_share_key_content_i_action_DATA", paramString11);
    localIntent.putExtra("struct_share_key_content_action_DATA", paramString9);
    localIntent.putExtra("req_share_id", -1L);
    localIntent.putExtra("struct_share_key_source_action", paramString12);
    localIntent.putExtra("struct_share_key_source_action_data", paramString13);
    localIntent.putExtra("struct_share_key_source_a_action_data", paramString14);
    localIntent.putExtra("struct_share_key_source_i_action_data", paramString15);
    localIntent.putExtra("struct_share_key_source_icon", paramString16);
    localIntent.putExtra("app_name", paramString17);
    localIntent.putExtra("brief_key", paramString6);
    localIntent.putExtra("compatible_text", paramString19);
    localIntent.putExtra("flag", 2);
    if (paramBoolean) {
      localIntent.putExtra("icon_need_round", "1");
    }
    localIntent.putExtra("emoInputType", 2);
    paramString1 = bdof.a(localIntent.getExtras());
    if (paramString1 != null)
    {
      localIntent.putExtra("stuctmsg_bytes", paramString1.getBytes());
      paramContext.startActivity(localIntent);
      return true;
    }
    return false;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, AbsStructMsg paramAbsStructMsg, BusinessObserver paramBusinessObserver)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        paramBusinessObserver = paramQQAppInterface.getCurrentAccountUin();
        i = bcpt.a;
        bcpt.a = i + 1;
        long l = i;
        i = paramAbsStructMsg.forwardID;
        if (paramAbsStructMsg.mMsgServiceID == 80)
        {
          if (TextUtils.isEmpty(paramString2)) {
            paramString2 = paramBusinessObserver;
          }
          for (;;)
          {
            paramString2 = bcsa.a(paramQQAppInterface, paramBusinessObserver, paramString1, paramString2, paramInt, l, paramAbsStructMsg);
            if (paramAbsStructMsg.mMsgServiceID != 41) {
              break;
            }
            agfe.a().a(paramString2.uniseq, paramAbsStructMsg.parentUniseq, i);
            paramQQAppInterface.getMessageFacade().sendMessage(paramString2, null);
            return;
          }
        }
        if (paramAbsStructMsg.mMsgServiceID == 118)
        {
          if (TextUtils.isEmpty(paramString2)) {
            paramString2 = paramBusinessObserver;
          }
          for (;;)
          {
            paramString2 = bcsa.a(paramQQAppInterface, paramBusinessObserver, paramString1, paramString2, paramInt, l, paramAbsStructMsg);
            break;
          }
        }
        if (TextUtils.isEmpty(paramString2)) {
          paramString2 = paramBusinessObserver;
        }
        for (;;)
        {
          paramString2 = bcsa.a(paramQQAppInterface, paramBusinessObserver, paramString1, paramString2, paramInt, l, paramAbsStructMsg);
          break;
        }
        if (paramAbsStructMsg.mMsgServiceID == 100)
        {
          paramAbsStructMsg.mMsgServiceID = 1;
          paramString1 = bcsa.a(paramQQAppInterface, paramBusinessObserver, paramString1, paramBusinessObserver, paramInt, l, paramAbsStructMsg);
          agfe.a().a(paramString1.uniseq, paramAbsStructMsg.parentUniseq, i);
          paramQQAppInterface.getMessageFacade().addAndSendMessage(paramString1, new bhho());
          return;
        }
        agfe.a().a(paramString2.uniseq, paramAbsStructMsg.parentUniseq, i);
        paramQQAppInterface.getMessageFacade().addAndSendMessage(paramString2, null);
        return;
      } while (paramAbsStructMsg == null);
      if (paramAbsStructMsg.mMsgServiceID == 1)
      {
        paramString2 = paramQQAppInterface.getCurrentAccountUin();
        i = bcpt.a;
        bcpt.a = i + 1;
        paramString1 = bcsa.a(paramQQAppInterface, paramString2, paramString1, paramString2, paramInt, i, paramAbsStructMsg);
        paramQQAppInterface.getMessageFacade().addAndSendMessage(paramString1, null);
        return;
      }
    } while (paramAbsStructMsg.mMsgServiceID != 41);
    paramString2 = paramQQAppInterface.getCurrentAccountUin();
    int i = bcpt.a;
    bcpt.a = i + 1;
    paramString1 = bcsa.a(paramQQAppInterface, paramString2, paramString1, paramString2, paramInt, i, paramAbsStructMsg);
    paramQQAppInterface.getMessageFacade().sendMessage(paramString1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhhn
 * JD-Core Version:    0.7.0.1
 */