import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TempMsgInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.managers.TempMsgManager.3;
import com.tencent.mobileqq.managers.TempMsgManager.4;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class axae
  implements Manager
{
  private axah jdField_a_of_type_Axah;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private String jdField_a_of_type_JavaLangString;
  private final List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<String, Boolean> jdField_a_of_type_JavaUtilMap = new HashMap(8);
  private final String[] jdField_a_of_type_ArrayOfJavaLangString = { "temp_msg_setting_consult_", "temp_msg_setting_contact_", "temp_msg_setting_interest_v2", "temp_msg_setting_nearby_", "temp_msg_setting_troop_", "temp_msg_setting_circle_v2", "temp_msg_setting_game_buddy_", "temp_msg_setting_audio_room" };
  
  public axae(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.c();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    a();
  }
  
  private int a(SessionInfo paramSessionInfo)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
    if ((1000 == paramSessionInfo.jdField_a_of_type_Int) || (1004 == paramSessionInfo.jdField_a_of_type_Int) || (1022 == paramSessionInfo.jdField_a_of_type_Int)) {}
    for (localObject = ChatActivityUtils.b((List)localObject, paramSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface); localObject == null; localObject = ChatActivityUtils.a((List)localObject, paramSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      return paramSessionInfo.jdField_a_of_type_Int;
    }
    return ((MessageRecord)localObject).istroop;
  }
  
  private DialogInterface.OnClickListener a(BaseChatPie paramBaseChatPie, short paramShort)
  {
    return new axag(this, paramBaseChatPie, paramShort);
  }
  
  private String a(short paramShort)
  {
    switch (paramShort)
    {
    default: 
      throw new RuntimeException("getTypeStringFromType failed " + paramShort);
    case -23308: 
      return "temp_msg_setting_troop_";
    case -23309: 
      return "temp_msg_setting_consult_";
    case -23310: 
      return "temp_msg_setting_contact_";
    case -23166: 
      return "temp_msg_setting_interest_v2";
    case -23312: 
      return "temp_msg_setting_nearby_";
    case -23168: 
      return "temp_msg_setting_circle_v2";
    case -23161: 
      return "temp_msg_setting_audio_room";
    }
    return "temp_msg_setting_game_buddy_";
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilList.add("temp_msg_setting_interest_v2");
    this.jdField_a_of_type_JavaUtilList.add("temp_msg_setting_circle_v2");
    this.jdField_a_of_type_JavaUtilList.add("temp_msg_setting_game_buddy_");
    this.jdField_a_of_type_JavaUtilList.add("temp_msg_setting_audio_room");
  }
  
  private void a(SessionInfo paramSessionInfo, short paramShort, String paramString, int paramInt, BaseChatPie paramBaseChatPie)
  {
    if (!a(a(paramShort)))
    {
      paramSessionInfo = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getString(2131718660), new Object[] { paramString, paramString });
      paramSessionInfo = bhlq.a(paramBaseChatPie.a, 230, anzj.a(2131713622), paramSessionInfo, 2131718658, 2131718659, a(paramBaseChatPie, paramShort), a(paramBaseChatPie, paramShort));
      paramSessionInfo.setOnCancelListener(new axaf(this, paramBaseChatPie));
      paramSessionInfo.setCanceledOnTouchOutside(false);
      paramSessionInfo.show();
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009977", "0X8009977", a(paramShort), a(paramShort), "", "", "", "");
    }
    while ((!a(paramSessionInfo)) || (!a(a(paramShort), paramSessionInfo))) {
      return;
    }
    a(paramSessionInfo, paramString, paramInt, paramShort);
  }
  
  private boolean a(SessionInfo paramSessionInfo)
  {
    paramSessionInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
    int i;
    ChatMessage localChatMessage;
    if (paramSessionInfo.size() > 0)
    {
      i = paramSessionInfo.size();
      paramSessionInfo = paramSessionInfo.iterator();
      if (!paramSessionInfo.hasNext()) {
        break label151;
      }
      localChatMessage = (ChatMessage)paramSessionInfo.next();
      if (!localChatMessage.isSend()) {}
    }
    else
    {
      return false;
    }
    if (localChatMessage.senderuin == null) {
      i -= 1;
    }
    for (;;)
    {
      break;
      if (localChatMessage.senderuin.compareTo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) == 0) {
        i -= 1;
      } else if (localChatMessage.msgtype == -1034) {
        i -= 1;
      } else if (QLog.isColorLevel()) {
        QLog.d("TempMsgManager", 2, localChatMessage.toString());
      }
    }
    label151:
    if (i > 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean a(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
    boolean bool1 = b(paramString);
    if (paramInt == 0) {
      bool1 = localSharedPreferences.getBoolean(paramString + this.jdField_a_of_type_JavaLangString + "_setting", bool1);
    }
    boolean bool2;
    do
    {
      return bool1;
      if (paramInt != 1) {
        break;
      }
      bool2 = localSharedPreferences.getBoolean(paramString + this.jdField_a_of_type_JavaLangString + "_show", bool1);
      bool1 = bool2;
    } while (!bool2);
    localSharedPreferences.edit().putBoolean(paramString + this.jdField_a_of_type_JavaLangString + "_show", false).apply();
    return bool2;
    return false;
  }
  
  private boolean b(String paramString)
  {
    return !this.jdField_a_of_type_JavaUtilList.contains(paramString);
  }
  
  public int a(short paramShort)
  {
    switch (paramShort)
    {
    default: 
      return 0;
    case -23308: 
      return 1;
    case -23309: 
      return 5;
    case -23310: 
      return 4;
    case -23166: 
      return 3;
    case -23312: 
      return 2;
    case -23168: 
      return 6;
    case -23158: 
      return 7;
    }
    return 8;
  }
  
  public Map<String, Boolean> a()
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
    String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(str))
      {
        boolean bool = b(str);
        this.jdField_a_of_type_JavaUtilMap.put(str, Boolean.valueOf(localSharedPreferences.getBoolean(str + this.jdField_a_of_type_JavaLangString + "_setting", bool)));
      }
      i += 1;
    }
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public void a(axah paramaxah)
  {
    this.jdField_a_of_type_Axah = paramaxah;
  }
  
  public void a(SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TempMsgManager", 2, "onEnterChat" + paramSessionInfo.jdField_a_of_type_Int);
    }
    int j = paramSessionInfo.jdField_a_of_type_Int;
    int i = j;
    if (j == 1000) {
      i = a(paramSessionInfo);
    }
    switch (i)
    {
    case 1004: 
    case 1009: 
    case 1010: 
    case 1020: 
    case 1024: 
    case 1025: 
    case 10004: 
    default: 
      return;
    case 1000: 
      a(paramSessionInfo, (short)-23308, anzj.a(2131713621), i, paramBaseChatPie);
      return;
    case 1006: 
      a(paramSessionInfo, (short)-23310, anzj.a(2131713619), i, paramBaseChatPie);
      return;
    case 1001: 
    case 1003: 
      a(paramSessionInfo, (short)-23312, anzj.a(2131713618), i, paramBaseChatPie);
      return;
    case 10002: 
      a(paramSessionInfo, (short)-23166, anzj.a(2131713620), i, paramBaseChatPie);
      return;
    case 10010: 
      a(paramSessionInfo, (short)-23161, anzj.a(2131693847), i, paramBaseChatPie);
      return;
    case 1005: 
      a(paramSessionInfo, (short)-23309, "QQ咨询", i, paramBaseChatPie);
      return;
    case 10008: 
      a(paramSessionInfo, (short)-23168, anzj.a(2131718520), i, paramBaseChatPie);
      return;
    }
    a(paramSessionInfo, (short)-23158, ((avld)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(358)).a(), i, paramBaseChatPie);
  }
  
  public void a(SessionInfo paramSessionInfo, String paramString, int paramInt, short paramShort)
  {
    Object localObject;
    if (paramInt == 1000)
    {
      paramString = bhlg.o(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSessionInfo.c);
      String str = bhlg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSessionInfo.c, true);
      if (QLog.isColorLevel()) {
        QLog.d("TempMsgManager", 2, "getTroopNickName:" + paramString + " new From:" + str);
      }
      paramString = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getString(2131718665), new Object[] { str });
      localObject = new avpd(paramSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString, paramSessionInfo.jdField_a_of_type_Int, -5023, 655381, bcrg.a());
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_action", 39);
      localBundle.putString("textColor", "");
      localBundle.putString("image_resource", null);
      localBundle.putString("key_action_DATA", paramSessionInfo.c);
      ((avpd)localObject).a(5, str.length() + 5, localBundle);
      paramSessionInfo = new Bundle();
      paramSessionInfo.putInt("key_action", 38);
      paramSessionInfo.putString("textColor", "");
      paramSessionInfo.putString("image_resource", null);
      paramSessionInfo.putString("key_action_DATA", a(paramShort) + "");
      ((avpd)localObject).a(paramString.length() - 5, paramString.length() - 1, paramSessionInfo);
      paramSessionInfo = (SessionInfo)localObject;
    }
    for (;;)
    {
      localObject = new MessageForUniteGrayTip();
      ((MessageForUniteGrayTip)localObject).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSessionInfo);
      avpe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("TempMsgManager", 2, "add gray tip =" + paramString);
      }
      return;
      paramString = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getString(2131718664), new Object[] { paramString });
      paramSessionInfo = new avpd(paramSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString, paramSessionInfo.jdField_a_of_type_Int, -5023, 655381, bcrg.a());
      localObject = new Bundle();
      ((Bundle)localObject).putInt("key_action", 38);
      ((Bundle)localObject).putString("textColor", "");
      ((Bundle)localObject).putString("image_resource", null);
      ((Bundle)localObject).putString("key_action_DATA", a(paramShort) + "");
      paramSessionInfo.a(paramString.length() - 5, paramString.length() - 1, (Bundle)localObject);
    }
  }
  
  public void a(short paramShort, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TempMsgManager", 2, "onSetResult t=" + paramShort + " result=" + paramBoolean1 + " fm=" + paramString + " value=" + paramBoolean2);
    }
    if (!paramBoolean1)
    {
      a(paramShort, paramBoolean2, false);
      if (!bhsr.a(paramString)) {
        ThreadManager.getUIHandler().post(new TempMsgManager.3(this, paramString));
      }
    }
    ThreadManager.getUIHandler().post(new TempMsgManager.4(this, paramShort, paramBoolean1));
  }
  
  public void a(short paramShort, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TempMsgManager", 2, "changeSetting t=" + paramShort + " s=" + paramBoolean1 + "sync=" + paramBoolean2);
    }
    Object localObject = a(paramShort);
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(localObject))
    {
      this.jdField_a_of_type_JavaUtilMap.remove(localObject);
      this.jdField_a_of_type_JavaUtilMap.put(localObject, Boolean.valueOf(paramBoolean1));
      PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()).edit().putBoolean((String)localObject + this.jdField_a_of_type_JavaLangString + "_setting", paramBoolean1).apply();
      if (paramBoolean2)
      {
        localObject = (anum)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
        if (localObject != null) {
          if (paramBoolean1) {
            break label211;
          }
        }
      }
    }
    label211:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      ((anum)localObject).a(paramShort, paramBoolean1);
      return;
      this.jdField_a_of_type_JavaUtilMap.put(localObject, Boolean.valueOf(paramBoolean1));
      break;
    }
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      return ((Boolean)this.jdField_a_of_type_JavaUtilMap.get(paramString)).booleanValue();
    }
    boolean bool = a(paramString, 0);
    this.jdField_a_of_type_JavaUtilMap.put(paramString, Boolean.valueOf(bool));
    return bool;
  }
  
  public boolean a(String paramString, SessionInfo paramSessionInfo)
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(TempMsgInfo.class, paramString + paramSessionInfo.jdField_a_of_type_JavaLangString) instanceof TempMsgInfo)) {
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TempMsgManager", 2, "can't tempMsgInfo, insert a new tempMsgInfo! type=" + paramString + "curFriendUin=" + paramSessionInfo.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persist(new TempMsgInfo(paramString + paramSessionInfo.jdField_a_of_type_JavaLangString, System.currentTimeMillis()));
      return true;
    }
    finally {}
  }
  
  public boolean a(short paramShort)
  {
    return a(a(paramShort));
  }
  
  public boolean b(short paramShort)
  {
    String str = a(paramShort);
    return this.jdField_a_of_type_JavaUtilList.contains(str);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_Axah = null;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axae
 * JD-Core Version:    0.7.0.1
 */