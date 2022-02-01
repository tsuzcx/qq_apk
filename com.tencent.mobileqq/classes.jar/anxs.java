import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemServiceAccountFolderData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.applets.PublicAccountEventReport.1;
import com.tencent.mobileqq.applets.PublicAccountEventReport.10;
import com.tencent.mobileqq.applets.PublicAccountEventReport.11;
import com.tencent.mobileqq.applets.PublicAccountEventReport.12;
import com.tencent.mobileqq.applets.PublicAccountEventReport.13;
import com.tencent.mobileqq.applets.PublicAccountEventReport.2;
import com.tencent.mobileqq.applets.PublicAccountEventReport.3;
import com.tencent.mobileqq.applets.PublicAccountEventReport.4;
import com.tencent.mobileqq.applets.PublicAccountEventReport.5;
import com.tencent.mobileqq.applets.PublicAccountEventReport.6;
import com.tencent.mobileqq.applets.PublicAccountEventReport.7;
import com.tencent.mobileqq.applets.PublicAccountEventReport.8;
import com.tencent.mobileqq.applets.PublicAccountEventReport.9;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class anxs
{
  private static ConcurrentHashMap<String, Integer> a = new ConcurrentHashMap();
  private static ConcurrentHashMap<String, Integer> b = new ConcurrentHashMap();
  
  public static Bundle a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      Bundle localBundle = b(new JSONObject(paramString).optString("oac_triggle"));
      return localBundle;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("PublicAccountEventReport", 1, "parse input=" + paramString, localJSONException);
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    String str = "";
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      str = b(new JSONObject(paramString).optString("oac_triggle")).getString("ad_id");
      return str;
    }
    catch (Exception paramString)
    {
      QLog.e("PublicAccountEventReport", 2, "parseException error ");
    }
    return "";
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("red_cnt", paramString1);
    localHashMap.put("msg_seq", paramString2);
    localHashMap.put("msg_rand", paramString3);
    return new JSONObject(localHashMap).toString();
  }
  
  public static void a()
  {
    a.clear();
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    a(paramInt1, paramInt2, paramString1, paramString2, 1);
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3)
  {
    ThreadManagerV2.executeOnSubThread(new PublicAccountEventReport.13(paramString1, paramInt1, paramInt2, paramInt3, paramString2));
  }
  
  public static void a(int paramInt1, ChatMessage paramChatMessage, int paramInt2)
  {
    if (paramChatMessage == null) {}
    String str2;
    String str1;
    do
    {
      return;
      if (paramInt1 == 117) {
        a(paramChatMessage.frienduin, paramChatMessage.uniseq);
      }
      str2 = "";
      str1 = "";
      if (paramChatMessage.mExJsonObject != null)
      {
        str1 = paramChatMessage.mExJsonObject.optString("report_key_bytes_oac_msg_extend");
        str2 = a(str1);
      }
    } while (TextUtils.isEmpty(str2));
    a(paramInt1, paramInt2, str2, str1);
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    a(205, paramInt1, paramString1, paramString2, paramInt2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null)
    {
      String str = "";
      if (paramMessageRecord.mExJsonObject != null) {
        str = paramMessageRecord.mExJsonObject.optString("report_key_bytes_oac_msg_extend");
      }
      a(paramQQAppInterface, paramMessageRecord.frienduin, paramInt1, paramInt2, paramMessageRecord.msgUid, str);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentBaseData paramRecentBaseData)
  {
    int i = 0;
    if ((paramQQAppInterface == null) || (paramRecentBaseData == null)) {
      return;
    }
    int j = paramRecentBaseData.mUnreadNum;
    String str1 = "";
    Object localObject = "";
    if ((paramRecentBaseData instanceof RecentItemPublicAccountChatMsgData))
    {
      localObject = ((RecentItemPublicAccountChatMsgData)paramRecentBaseData).a();
      if (localObject != null)
      {
        str1 = ((QQMessageFacade.Message)localObject).msgseq + "";
        if (localObject == null) {
          break label377;
        }
        localObject = ((QQMessageFacade.Message)localObject).msgBackupMsgRandom + "";
      }
    }
    else
    {
      label100:
      localObject = a(j + "", str1, (String)localObject);
    }
    label229:
    int k;
    switch (paramRecentBaseData.getRecentUserType())
    {
    default: 
      return;
    case 1008: 
    case 3001: 
    case 7120: 
    case 7200: 
    case 7210: 
    case 7220: 
    case 7230: 
      str1 = "";
      String str2;
      if ((paramRecentBaseData instanceof RecentItemPublicAccountChatMsgData))
      {
        str1 = ((RecentItemPublicAccountChatMsgData)paramRecentBaseData).mReportKeyBytesOacMsgxtend;
        str2 = paramRecentBaseData.getRecentUserUin();
        k = paramRecentBaseData.getUnreadNum();
        j = paramRecentBaseData.mUnreadFlag;
        if (!agjp.a(str2)) {
          break label403;
        }
        algh.a().b(paramQQAppInterface);
        label261:
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountEventReport", 2, new Object[] { "Report from reportItemClickEventOnConversation, UIN=", str2, " unReadFlag=", Integer.valueOf(j), " unreadSum=", Integer.valueOf(k), " message=", paramRecentBaseData.mLastMsg.toString() });
        }
        if (k != 0) {
          break label421;
        }
        i = 0;
      }
      for (;;)
      {
        ThreadManagerV2.executeOnSubThread(new PublicAccountEventReport.6(str2, str1, i, k, (String)localObject, paramRecentBaseData, paramQQAppInterface, paramRecentBaseData.mLastMsg.toString()));
        return;
        str1 = "";
        break;
        label377:
        localObject = "";
        break label100;
        if (!(paramRecentBaseData instanceof RecentItemServiceAccountFolderData)) {
          break label229;
        }
        str1 = ((RecentItemServiceAccountFolderData)paramRecentBaseData).mReportKeyBytesOacMsgxtend;
        break label229;
        label403:
        if (!bgmy.b(str2)) {
          break label261;
        }
        bgmx.a(paramQQAppInterface, "qqsport_click_messagetab", null);
        break label261;
        label421:
        i = j;
        if (j != 2) {
          i = 1;
        }
      }
    }
    str1 = paramRecentBaseData.getRecentUserUin();
    paramQQAppInterface = "";
    if ((paramRecentBaseData instanceof RecentItemPublicAccountChatMsgData)) {
      paramQQAppInterface = ((RecentItemPublicAccountChatMsgData)paramRecentBaseData).mReportKeyBytesOacMsgxtend;
    }
    boolean bool;
    if ((paramRecentBaseData.mUnreadFlag != 0) || (paramRecentBaseData.mUnreadNum > 0))
    {
      bool = true;
      b(str1, 102, paramQQAppInterface, bool, (String)localObject, paramRecentBaseData.mPosition + "");
      k = paramRecentBaseData.getUnreadNum();
      j = paramRecentBaseData.mUnreadFlag;
      if (k != 0) {
        break label556;
      }
    }
    for (;;)
    {
      MiniProgramLpReportDC04239.reportByQQ("message", "message_list", "click", String.valueOf(i), String.valueOf(k), "", "");
      return;
      bool = false;
      break;
      label556:
      if (j != 2) {
        i = 1;
      } else {
        i = j;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramQQAppInterface == null) || (paramMessageRecord == null)) {}
    do
    {
      return;
      if ("1".equals(paramMessageRecord.getExtInfoFromExtStr("is_AdArrive_Msg")))
      {
        String str1 = paramMessageRecord.getExtInfoFromExtStr("gdt_msgImp");
        String str2 = paramMessageRecord.getExtInfoFromExtStr("pa_msgId");
        String str3 = paramMessageRecord.getExtInfoFromExtStr("gdt_view_id");
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(str2);
        uei.a(paramQQAppInterface, "", "", paramMessageRecord.senderuin, str1, str3, localArrayList);
        return;
      }
    } while (!"2290230341".equals(paramMessageRecord.frienduin));
    bcef.b(paramQQAppInterface, "CliOper", "", "", "0X80090E1", "0X80090E1", 0, 0, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AbsListView paramAbsListView, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramAbsListView == null) || (paramAbsListView.getChildCount() == 0) || (paramAbsListView.getAdapter() == null)) {}
    Object localObject;
    do
    {
      do
      {
        return;
        switch (paramInt)
        {
        case 1: 
        default: 
          return;
        }
      } while (!(paramAbsListView.getAdapter() instanceof bjqx));
      localObject = (bjqx)paramAbsListView.getAdapter();
    } while (!(((bjqx)localObject).getWrappedAdapter() instanceof akkk));
    b.clear();
    akkk localakkk = (akkk)((bjqx)localObject).getWrappedAdapter();
    int i = paramAbsListView.getFirstVisiblePosition();
    paramInt = i;
    if (i > 0) {
      paramInt = i - 1;
    }
    int k = paramAbsListView.getLastVisiblePosition();
    i = paramInt;
    int m;
    label220:
    label250:
    boolean bool;
    if (i < k - 1)
    {
      paramAbsListView = localakkk.getItem(i);
      RecentBaseData localRecentBaseData;
      String str1;
      String str2;
      if ((paramAbsListView instanceof RecentBaseData))
      {
        localRecentBaseData = (RecentBaseData)paramAbsListView;
        paramInt = localRecentBaseData.getRecentUserType();
        str1 = localRecentBaseData.getRecentUserUin();
        m = localRecentBaseData.mUnreadNum;
        paramAbsListView = "";
        localObject = "";
        if ((localRecentBaseData instanceof RecentItemPublicAccountChatMsgData))
        {
          localObject = ((RecentItemPublicAccountChatMsgData)localRecentBaseData).a();
          if (localObject == null) {
            break label354;
          }
          paramAbsListView = ((QQMessageFacade.Message)localObject).msgseq + "";
          if (localObject == null) {
            break label360;
          }
          localObject = ((QQMessageFacade.Message)localObject).msgBackupMsgRandom + "";
        }
        str2 = a(m + "", paramAbsListView, (String)localObject);
        if (!a.containsKey(str1))
        {
          if (!agjp.a(str1)) {
            break label367;
          }
          ThreadManager.excute(new PublicAccountEventReport.1(paramQQAppInterface), 16, null, true);
        }
        label312:
        if ((paramInt >= 1000) && (paramInt != 5000) && (paramInt != 7000) && (paramInt != 9000) && (paramInt != 9002)) {
          break label412;
        }
      }
      label354:
      label360:
      label367:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          paramAbsListView = "";
          break label220;
          localObject = "";
          break label250;
          if ((localRecentBaseData instanceof RecentItemServiceAccountFolderData))
          {
            ThreadManager.excute(new PublicAccountEventReport.2(paramQQAppInterface), 16, null, true);
            break label312;
          }
          if (!bgmy.b(str1)) {
            break label312;
          }
          bgmx.a(paramQQAppInterface, "qqsport_exposure_messagetab", null);
          break label312;
          switch (paramInt)
          {
          default: 
            if (QLog.isColorLevel()) {
              QLog.d("PublicAccountEventReport", 2, new Object[] { "uin=", str1, " uinTYPE=", Integer.valueOf(paramInt) });
            }
            break;
          }
        }
        paramAbsListView = "";
        if ((localRecentBaseData instanceof RecentItemPublicAccountChatMsgData)) {
          paramAbsListView = ((RecentItemPublicAccountChatMsgData)localRecentBaseData).mReportKeyBytesOacMsgxtend;
        }
        b.put(str1, Integer.valueOf(paramInt));
      } while (a.containsKey(str1));
      label412:
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountEventReport", 2, new Object[] { "Report from TAB, UIN=", str1, " unReadFlag=", Integer.valueOf(localRecentBaseData.mUnreadFlag), " unreadSum=", Integer.valueOf(localRecentBaseData.mUnreadNum), " message=", localRecentBaseData.mLastMsg });
      }
      int j = localRecentBaseData.mUnreadFlag;
      if (localRecentBaseData.mUnreadNum == 0) {
        paramInt = 0;
      }
      for (;;)
      {
        localObject = "";
        if (localRecentBaseData.mLastMsg != null) {
          localObject = localRecentBaseData.mLastMsg.toString();
        }
        ThreadManagerV2.executeOnSubThread(new PublicAccountEventReport.3(str1, paramAbsListView, paramInt, m, str2, localRecentBaseData, paramQQAppInterface, (String)localObject));
        break;
        paramInt = j;
        if (j != 2) {
          paramInt = 1;
        }
      }
      paramAbsListView = "";
      if ((localRecentBaseData instanceof RecentItemPublicAccountChatMsgData)) {
        paramAbsListView = ((RecentItemPublicAccountChatMsgData)localRecentBaseData).mReportKeyBytesOacMsgxtend;
      }
      if ((localRecentBaseData.mUnreadFlag != 0) || (localRecentBaseData.mUnreadNum > 0))
      {
        bool = true;
        label770:
        b(str1, 101, paramAbsListView, bool, str2, localRecentBaseData.mPosition + "");
        paramInt = localRecentBaseData.mUnreadFlag;
        if (localRecentBaseData.mUnreadNum != 0) {
          break label855;
        }
        paramInt = 0;
      }
    }
    for (;;)
    {
      MiniProgramLpReportDC04239.reportByQQ("message", "message_list", "expo", String.valueOf(paramInt), String.valueOf(m), "", "");
      break;
      bool = false;
      break label770;
      label855:
      if (paramInt != 2)
      {
        paramInt = 1;
        continue;
        a.clear();
        a.putAll(b);
        return;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountEventReport", 2, new Object[] { "report Menu Click On PublicAccount AIO, UIN=", paramString, " menuID=", Integer.valueOf(paramInt2) });
    }
    ThreadManagerV2.executeOnSubThread(new PublicAccountEventReport.8(paramQQAppInterface, paramString, paramInt1, paramInt2));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountEventReport", 2, new Object[] { "report report Stay Time In Page, UIN=", paramString, " from=", Integer.valueOf(paramInt1), " type=", Integer.valueOf(paramInt2), " time=", Long.valueOf(paramLong) });
    }
    ThreadManagerV2.executeOnSubThread(new PublicAccountEventReport.9(paramQQAppInterface, paramString, paramInt1, paramInt2, paramLong));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountEventReport", 2, new Object[] { "report report Msg item click in aio, UIN=", paramString1, " from=", Integer.valueOf(paramInt1), " type=", Integer.valueOf(paramInt2), " msgId=", Long.valueOf(paramLong) });
    }
    ThreadManagerV2.executeOnSubThread(new PublicAccountEventReport.10(paramQQAppInterface, paramString1, paramInt1, paramInt2, paramLong, paramString2));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountEventReport", 2, new Object[] { "Report from ACCOUNT_FOLDER, UIN=", paramString1, " unReadFlag=", Integer.valueOf(paramInt1), " unreadSum=", Integer.valueOf(paramInt2), " message=", paramString2 });
    }
    if (paramInt2 == 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      ThreadManagerV2.executeOnSubThread(new PublicAccountEventReport.5(paramString1, paramString3, paramInt1, paramInt2, paramString4, paramString5, paramQQAppInterface, paramString2));
      return;
      if (paramInt1 != 2) {
        paramInt1 = 1;
      }
    }
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountEventReport", 2, new Object[] { "report  Click On HealthBusinessPluginFollow , UIN=", paramString });
    }
    ThreadManagerV2.executeOnSubThread(new PublicAccountEventReport.11(paramString));
  }
  
  public static void a(String paramString, long paramLong)
  {
    ThreadManagerV2.executeOnSubThread(new PublicAccountEventReport.12(paramString, paramLong));
  }
  
  private static Bundle b(String paramString)
  {
    int i = 0;
    Bundle localBundle = new Bundle();
    paramString = paramString.split("&");
    for (;;)
    {
      if ((paramString != null) && (i < paramString.length))
      {
        String[] arrayOfString = paramString[i].split("=");
        if ((arrayOfString != null) && (arrayOfString.length == 2)) {}
        try
        {
          localBundle.putString(arrayOfString[0], URLDecoder.decode(arrayOfString[1], "UTF-8"));
          i += 1;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            localUnsupportedEncodingException.printStackTrace();
          }
        }
      }
    }
    return localBundle;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountEventReport", 2, new Object[] { "Report Click from ACCOUNT_FOLDER, UIN=", paramString1, " unReadFlag=", Integer.valueOf(paramInt1), " unreadSum=", Integer.valueOf(paramInt2), " message=", paramString2 });
    }
    if (paramInt2 == 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      ThreadManagerV2.executeOnSubThread(new PublicAccountEventReport.7(paramString1, paramString3, paramInt1, paramInt2, paramString4, paramString5, paramQQAppInterface, paramString2));
      return;
      if (paramInt1 != 2) {
        paramInt1 = 1;
      }
    }
  }
  
  private static void b(String paramString1, int paramInt, String paramString2, boolean paramBoolean, String paramString3, String paramString4)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    ThreadManagerV2.executeOnSubThread(new PublicAccountEventReport.4(paramString2, paramString1, paramInt, paramBoolean, paramString3, paramString4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anxs
 * JD-Core Version:    0.7.0.1
 */