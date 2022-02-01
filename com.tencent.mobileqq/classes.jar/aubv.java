import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import mqq.manager.Manager;

public class aubv
  implements Manager
{
  private int jdField_a_of_type_Int;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private int b;
  
  public aubv(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = ((Integer)bfyz.a("gray_tips_wording_id", Integer.valueOf(0))).intValue();
    this.jdField_a_of_type_JavaLangString = ((String)bfyz.a("add_guide_gray_tips_time", ""));
    this.b = ((Integer)bfyz.a("add_guide_gray_tips_times", Integer.valueOf(0))).intValue();
  }
  
  private static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 10;
    case 0: 
      return 1;
    }
    return 2;
  }
  
  @NonNull
  private MessageForUniteGrayTip a(@NonNull QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2)
  {
    QLog.d("CustomizeGrayTipsManager", 1, "makeGuideCustomizeGrayTips, friendUin = " + paramString1 + ", senderUin = " + paramString2 + ", uinType = " + paramInt + ", time = " + paramLong1 + ", shMsgSeq = " + paramLong2);
    String str = amtj.a(2131691223);
    paramString1 = new aucf(paramString1, paramString2, str + amtj.a(2131691222), paramInt, -5020, 3, paramLong1);
    paramString1.e = true;
    paramString2 = new Bundle();
    paramString2.putInt("key_action", 56);
    paramString1.a(0, str.length(), paramString2);
    paramString2 = new MessageForUniteGrayTip();
    paramString2.initGrayTipMsg(paramQQAppInterface, paramString1);
    paramString2.shmsgseq = paramLong2;
    return paramString2;
  }
  
  @Nullable
  private <T extends MessageRecord> MessageForUniteGrayTip a(@NonNull List<T> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
      if (((localMessageRecord instanceof MessageForUniteGrayTip)) && (a((MessageForUniteGrayTip)localMessageRecord))) {
        return (MessageForUniteGrayTip)localMessageRecord;
      }
      i -= 1;
    }
    return null;
  }
  
  private String a()
  {
    Object localObject = Calendar.getInstance();
    int i = ((Calendar)localObject).get(1);
    int j = ((Calendar)localObject).get(2);
    int k = ((Calendar)localObject).get(5);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(i).append(j + 1).append(k);
    return ((StringBuilder)localObject).toString();
  }
  
  private void a()
  {
    this.b += 1;
    this.jdField_a_of_type_JavaLangString = a();
    bfyz.a("add_guide_gray_tips_time", this.jdField_a_of_type_JavaLangString);
    bfyz.a("add_guide_gray_tips_times", Integer.valueOf(this.b));
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    if ((paramContext instanceof ChatHistoryActivity)) {}
    do
    {
      return;
      if (TextUtils.equals("1", paramString))
      {
        paramContext.startActivity(new Intent(paramContext, QQSettingSettingActivity.class));
        paramContext.startActivity(new Intent(paramContext, NotifyPushSettingActivity.class));
        localIntent = new Intent(paramContext, QQBrowserActivity.class);
        localIntent.putExtra("url", "https://zb.vip.qq.com/v2/pages/withdrawMessage?_wv=2&dwop_via=" + paramString);
        paramContext.startActivity(localIntent);
        c(paramInt);
        return;
      }
    } while (!TextUtils.equals("2", paramString));
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://zb.vip.qq.com/v2/pages/withdrawMessage?_wv=2&dwop_via=" + paramString);
    paramContext.startActivity(localIntent);
    b();
  }
  
  private void a(@NonNull QQAppInterface paramQQAppInterface, int paramInt, List<MessageRecord> paramList, MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    a();
    MessageForUniteGrayTip localMessageForUniteGrayTip = a(paramQQAppInterface, paramMessageForUniteGrayTip.frienduin, paramMessageForUniteGrayTip.senderuin, paramInt, paramMessageForUniteGrayTip.time, paramMessageForUniteGrayTip.shmsgseq);
    paramQQAppInterface.getMessageFacade().getBaseMessageManager(paramInt).a(paramInt, paramMessageForUniteGrayTip.frienduin, localMessageForUniteGrayTip, paramList);
    aucg.a(paramQQAppInterface, localMessageForUniteGrayTip);
    if (QLog.isColorLevel()) {
      QLog.d("CustomizeGrayTipsManager", 2, "insert guide customize gray tips to aioList and db");
    }
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_Int != 0) {}
    String str;
    do
    {
      do
      {
        return false;
      } while (this.b >= 3);
      str = a();
    } while (TextUtils.equals(this.jdField_a_of_type_JavaLangString, str));
    return true;
  }
  
  private boolean a(MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    return (paramMessageForUniteGrayTip.tipParam.b == 1) && (!nmy.a(paramMessageForUniteGrayTip)) && (TextUtils.equals(String.valueOf(0), paramMessageForUniteGrayTip.getExtInfoFromExtStr("revoke_op_type")));
  }
  
  private <T extends MessageRecord> boolean a(@NonNull List<T> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if (((localMessageRecord instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)localMessageRecord).tipParam.b == 3)) {
        return true;
      }
    }
    return false;
  }
  
  private static void b()
  {
    bcef.b(null, "dc00898", "", "", "0X800B25B", "0X800B25B", 0, 0, "", "", "", "");
  }
  
  static void b(int paramInt)
  {
    bcef.b(null, "dc00898", "", "", "0X800B1FC", "0X800B1FC", a(paramInt), 0, "", "", "", "");
  }
  
  private static void c(int paramInt)
  {
    bcef.b(null, "dc00898", "", "", "0X800B25A", "0X800B25A", a(paramInt), 0, "", "", "", "");
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    bfyz.a("gray_tips_wording_id", Integer.valueOf(paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("CustomizeGrayTipsManager", 2, "setGrayTipsWordingId, id = " + paramInt);
    }
  }
  
  public boolean a(@NonNull QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomizeGrayTipsManager", 2, "insertGuideCustomizeGrayTipsIfNeed: uinType = " + paramInt + ", mGrayTipsWordingId = " + this.jdField_a_of_type_Int + ", mAddGuideGrayTipsTimes = " + this.b + ", mAddGuideGrayTipsDate = " + this.jdField_a_of_type_JavaLangString);
    }
    if (paramInt == 3000) {}
    do
    {
      return false;
      if (a()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("CustomizeGrayTipsManager", 2, "do not need to insert guide customize gray tips to aioList");
    return false;
    List localList = paramQQAppInterface.getMessageProxy(paramInt).g(paramString, paramInt);
    paramString = paramQQAppInterface.getMessageProxy(paramInt).a().a(paramString, paramInt);
    paramString.lock();
    try
    {
      if (bfwk.a(localList))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CustomizeGrayTipsManager", 2, "aioList is empty");
        }
        return false;
      }
      MessageForUniteGrayTip localMessageForUniteGrayTip = a(localList);
      if (localMessageForUniteGrayTip == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CustomizeGrayTipsManager", 2, "aioList do not contains revoke gray tip");
        }
        return false;
      }
      if (a(localList))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CustomizeGrayTipsManager", 2, "aioList contains GuideCustomizeGrayTips");
        }
        return false;
      }
      a(paramQQAppInterface, paramInt, localList, localMessageForUniteGrayTip);
      return true;
    }
    finally
    {
      paramString.unlock();
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aubv
 * JD-Core Version:    0.7.0.1
 */