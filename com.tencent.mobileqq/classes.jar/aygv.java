import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager.1;
import com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager.2;
import com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager.3;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class aygv
  implements Manager
{
  public long a;
  private aygx jdField_a_of_type_Aygx;
  private ayhd jdField_a_of_type_Ayhd;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString = "https://docs.qq.com/scenario/createpad.html?";
  private List<MessageRecord> jdField_a_of_type_JavaUtilList = new ArrayList();
  private long b;
  
  public aygv(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Ayhd = new ayhd(paramQQAppInterface);
  }
  
  private float a(String paramString1, String paramString2)
  {
    Object localObject3 = a(paramString1);
    Object localObject2 = a(paramString2);
    Object localObject1 = new LinkedHashSet();
    paramString1 = new ArrayList();
    paramString2 = new LinkedHashMap();
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localObject3 = ((List)localObject3).iterator();
    Object localObject4;
    label148:
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (String)((Iterator)localObject3).next();
      if (paramString2.containsKey(localObject4))
      {
        Float localFloat = (Float)paramString2.get(localObject4);
        localFloat.floatValue();
        paramString2.put(localObject4, localFloat);
      }
      for (;;)
      {
        if (!((LinkedHashSet)localObject1).add(localObject4)) {
          break label148;
        }
        paramString1.add(localObject4);
        break;
        paramString2.put(localObject4, Float.valueOf(1.0F));
      }
    }
    localObject2 = ((List)localObject2).iterator();
    label254:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      if (localLinkedHashMap.containsKey(localObject3))
      {
        localObject4 = (Float)localLinkedHashMap.get(localObject3);
        ((Float)localObject4).floatValue();
        localLinkedHashMap.put(localObject3, localObject4);
      }
      for (;;)
      {
        if (!((LinkedHashSet)localObject1).add(localObject3)) {
          break label254;
        }
        paramString1.add(localObject3);
        break;
        localLinkedHashMap.put(localObject3, Float.valueOf(1.0F));
      }
    }
    localObject1 = new ArrayList();
    localObject2 = new ArrayList();
    int i = 0;
    if (i < paramString1.size())
    {
      localObject3 = (String)paramString1.get(i);
      if (paramString2.containsKey(localObject3))
      {
        ((List)localObject1).add(Float.valueOf(((Float)paramString2.get(localObject3)).floatValue()));
        label333:
        if (!localLinkedHashMap.containsKey(localObject3)) {
          break label391;
        }
        ((List)localObject2).add(Float.valueOf(((Float)localLinkedHashMap.get(localObject3)).floatValue()));
      }
      for (;;)
      {
        i += 1;
        break;
        ((List)localObject1).add(Float.valueOf(0.0F));
        break label333;
        label391:
        ((List)localObject2).add(Float.valueOf(0.0F));
      }
    }
    if (((List)localObject1).size() != ((List)localObject2).size()) {
      return 0.0F;
    }
    if (((List)localObject1).size() == 0) {
      return 0.0F;
    }
    float f3 = 0.0F;
    float f2 = 0.0F;
    float f1 = 0.0F;
    i = 0;
    while (i < ((List)localObject1).size())
    {
      float f4 = ((Float)((List)localObject1).get(i)).floatValue();
      f3 += ((Float)((List)localObject2).get(i)).floatValue() * f4;
      f4 = ((Float)((List)localObject1).get(i)).floatValue();
      f2 += ((Float)((List)localObject1).get(i)).floatValue() * f4;
      f4 = ((Float)((List)localObject2).get(i)).floatValue();
      f1 += ((Float)((List)localObject2).get(i)).floatValue() * f4;
      i += 1;
    }
    return f3 / ((float)Math.pow(f2, 0.5D) * (float)Math.pow(f1, 0.5D));
  }
  
  private List<String> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return localArrayList;
      int j = paramString.length();
      int i = 0;
      while (i < j) {
        if (i + 1 < j)
        {
          if (a(paramString.charAt(i), paramString.charAt(i + 1)))
          {
            localArrayList.add(new String(new char[] { paramString.charAt(i), paramString.charAt(i + 1) }));
            i += 2;
          }
          else
          {
            localArrayList.add(String.valueOf(paramString.charAt(i)));
            i += 1;
          }
        }
        else
        {
          localArrayList.add(String.valueOf(paramString.charAt(i)));
          i += 1;
        }
      }
    }
  }
  
  private void a(ChatMessage paramChatMessage, String paramString1, String paramString2, String paramString3, ancv paramancv)
  {
    if ((!this.jdField_a_of_type_Ayhd.a()) && (QLog.isColorLevel()))
    {
      QLog.i("AIOMessageSpreadManager", 1, "last insert time less");
      return;
    }
    if (QLog.isDebugVersion()) {
      QLog.i("AIOMessageSpreadManager", 1, "insertGaryTips:" + paramString1 + " link:" + paramString2);
    }
    this.jdField_a_of_type_Ayhd.a(paramChatMessage);
    new Handler(ThreadManager.getSubThreadLooper()).postDelayed(new AIOMessageSpreadManager.2(this, paramChatMessage, paramString1, paramancv, paramString2, paramString3), 1000L);
  }
  
  static boolean a(char paramChar)
  {
    return (paramChar >= 55296) && (paramChar < 56320);
  }
  
  private boolean a(char paramChar1, char paramChar2)
  {
    return (a(paramChar1)) && (b(paramChar2));
  }
  
  private boolean a(ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    int i = this.jdField_a_of_type_Ayhd.a();
    int j = ancw.a().a();
    boolean bool1;
    if (j == 0)
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.i("AIOMessageSpreadManager", 1, "config is max: 0, return");
        bool1 = bool2;
      }
    }
    do
    {
      do
      {
        return bool1;
        if (i <= j) {
          break;
        }
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.i("AIOMessageSpreadManager", 1, "file count over[" + i + "], return");
      return false;
      if (!(paramChatMessage instanceof MessageForText)) {
        break;
      }
      bool2 = ancw.a().a();
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.i("AIOMessageSpreadManager", 1, " is Text Switch On:" + bool2);
    return bool2;
    return true;
  }
  
  static boolean b(char paramChar)
  {
    return (paramChar >= 56320) && (paramChar < 57344);
  }
  
  public void a(anct paramanct)
  {
    this.jdField_a_of_type_Ayhd.a(paramanct);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if (QLog.isDebugVersion())
    {
      QLog.i("AIOMessageSpreadManager", 4, "ready to post to SubThread Process， msgUid[" + paramChatMessage.msgUid + "], hashCode:" + paramChatMessage.hashCode());
      if (paramChatMessage.msgUid == 0L) {
        apue.a();
      }
    }
    if ((this.b == paramChatMessage.uniseq) && ((paramChatMessage instanceof MessageForText))) {
      return;
    }
    if ((paramChatMessage instanceof MessageForText)) {
      this.b = paramChatMessage.uniseq;
    }
    ThreadManager.executeOnSubThread(new AIOMessageSpreadManager.1(this, paramChatMessage));
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, SessionInfo paramSessionInfo)
  {
    Object localObject1 = paramChatMessage.getExtInfoFromExtStr("tim_aio_file_msg_uiniseq");
    Object localObject3;
    Object localObject2;
    do
    {
      try
      {
        l = Long.parseLong((String)localObject1);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramChatMessage.frienduin, paramChatMessage.istroop, l);
        if (localObject1 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AIOMessageSpreadManager", 1, "garyTips not find fileMsg");
          }
          return;
        }
      }
      catch (Exception localException1)
      {
        long l;
        for (;;)
        {
          QLog.e("AIOMessageSpreadManager", 1, localException1.toString());
          l = 0L;
        }
        localObject3 = paramChatMessage.getExtInfoFromExtStr("tim_aio_tips_type");
        if (((String)localObject3).equalsIgnoreCase("keyword")) {
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009078", "0X8009078", 0, 0, "", "", "", "");
        }
        while ((localException1 instanceof MessageForFile))
        {
          paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l, paramChatMessage.frienduin, paramChatMessage.istroop);
          if (paramChatMessage == null)
          {
            QLog.e("AIOMessageSpreadManager", 1, "query Entity is nyll!!!, uniseq[" + l + "]");
            return;
            if (((String)localObject3).equalsIgnoreCase("precent")) {
              axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800907B", "0X800907B", 0, 0, "", "", "", "");
            } else if (((String)localObject3).equalsIgnoreCase("text_keyword")) {
              axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009072", "0X800907B", 0, 0, "", "", "", "");
            }
          }
          else
          {
            ayec.a(paramChatMessage, paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2);
            return;
          }
        }
      }
      if ((localException1 instanceof MessageForTroopFile))
      {
        paramChatMessage = (MessageForTroopFile)localException1;
        localObject2 = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        localObject3 = new TeamWorkFileImportInfo();
        ((TeamWorkFileImportInfo)localObject3).c = ((azqt)localObject2).jdField_a_of_type_JavaLangString;
        ((TeamWorkFileImportInfo)localObject3).jdField_b_of_type_JavaLangString = ((azqt)localObject2).g;
        ((TeamWorkFileImportInfo)localObject3).j = apue.a(((azqt)localObject2).g);
        ((TeamWorkFileImportInfo)localObject3).jdField_b_of_type_Boolean = true;
        ((TeamWorkFileImportInfo)localObject3).jdField_d_of_type_Int = 1;
        ((TeamWorkFileImportInfo)localObject3).jdField_d_of_type_Long = paramChatMessage.fileSize;
        ((TeamWorkFileImportInfo)localObject3).jdField_d_of_type_JavaLangString = ((azqt)localObject2).jdField_e_of_type_JavaLangString;
        ((TeamWorkFileImportInfo)localObject3).jdField_b_of_type_Int = ((azqt)localObject2).h;
        ((TeamWorkFileImportInfo)localObject3).jdField_e_of_type_JavaLangString = paramSessionInfo.jdField_b_of_type_JavaLangString;
        ((TeamWorkFileImportInfo)localObject3).jdField_a_of_type_JavaLangString = paramSessionInfo.jdField_a_of_type_JavaLangString;
        if (((azqt)localObject2).jdField_b_of_type_Int != 12) {
          ((TeamWorkFileImportInfo)localObject3).jdField_a_of_type_Boolean = true;
        }
        ((TeamWorkFileImportInfo)localObject3).jdField_a_of_type_Int = 1;
        ayec.a((TeamWorkFileImportInfo)localObject3, paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((TeamWorkFileImportInfo)localObject3).jdField_d_of_type_Int);
        return;
      }
      if (!(localObject2 instanceof MessageForText)) {
        break;
      }
      localObject2 = paramChatMessage.getExtInfoFromExtStr("tim_aio_tips_template_id");
      localObject3 = paramChatMessage.getExtInfoFromExtStr("tim_aio_tips_template_type");
      paramChatMessage = paramChatMessage.getExtInfoFromExtStr("tim_aio_tips_keyword");
    } while (TextUtils.isEmpty((CharSequence)localObject2));
    Bundle localBundle = new Bundle();
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
    try
    {
      if (Integer.parseInt((String)localObject3) == 0) {}
      for (localTeamWorkFileImportInfo.jdField_e_of_type_Int = 3;; localTeamWorkFileImportInfo.jdField_e_of_type_Int = 6)
      {
        localBundle.putString("url", this.jdField_a_of_type_JavaLangString + "type=" + (String)localObject3 + "&template_id=" + (String)localObject2 + "&title=" + paramChatMessage);
        localBundle.putBoolean("doc_from_aio", true);
        localTeamWorkFileImportInfo.jdField_b_of_type_Boolean = true;
        localTeamWorkFileImportInfo.jdField_d_of_type_Int = 1;
        localTeamWorkFileImportInfo.jdField_a_of_type_Int = paramSessionInfo.jdField_a_of_type_Int;
        localTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString = paramSessionInfo.jdField_a_of_type_JavaLangString;
        localTeamWorkFileImportInfo.jdField_e_of_type_JavaLangString = paramSessionInfo.jdField_b_of_type_JavaLangString;
        localTeamWorkFileImportInfo.f = true;
        localBundle.putParcelable("key_team_work_file_import_info", localTeamWorkFileImportInfo);
        localBundle.putString("tdsourcetag", "s_qq_aio_grey");
        TeamWorkDocEditBrowserActivity.a(paramContext, localBundle, false);
        return;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        QLog.e("AIOMessageSpreadManager", 2, localException2.getMessage());
      }
    }
    QLog.e("AIOMessageSpreadManager", 1, "unknow msg type!");
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null)
    {
      QLog.e("AIOMessageSpreadManager", 1, apue.a());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AIOMessageSpreadManager", 1, "send file:" + paramMessageRecord.msgUid);
    }
    ThreadManager.getUIHandler().postDelayed(new AIOMessageSpreadManager.3(this), 1000L);
    try
    {
      this.jdField_a_of_type_JavaUtilList.add(paramMessageRecord);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("AIOMessageSpreadManager", 1, "lastInsertTime[" + this.jdField_a_of_type_Long + "],lstCache size[" + this.jdField_a_of_type_JavaUtilList.size() + "]");
      }
      return;
    }
    finally {}
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    String str = paramMessageRecord.getExtInfoFromExtStr("tim_aio_gary_uniseq");
    if (QLog.isColorLevel()) {
      QLog.i("AIOMessageSpreadManager", 1, "del garyTips id[" + str + "],targetId[" + paramMessageRecord.msgUid + "], hashCode:" + paramMessageRecord.hashCode());
    }
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      long l = Long.parseLong(str);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageRecord.frienduin, paramMessageRecord.istroop, l, true);
      return;
    }
    catch (Exception paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
      QLog.e("AIOMessageSpreadManager", 1, paramMessageRecord.toString());
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aygv
 * JD-Core Version:    0.7.0.1
 */