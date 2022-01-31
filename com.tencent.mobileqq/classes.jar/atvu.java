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
import com.tencent.mobileqq.data.TempMsgInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.managers.TempMsgManager.3;
import com.tencent.mobileqq.managers.TempMsgManager.4;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class atvu
  implements Manager
{
  private atvx jdField_a_of_type_Atvx;
  private awbw jdField_a_of_type_Awbw;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private Map<String, Boolean> jdField_a_of_type_JavaUtilMap = new HashMap(5);
  private final String[] jdField_a_of_type_ArrayOfJavaLangString = { "temp_msg_setting_consult_", "temp_msg_setting_contact_", "temp_msg_setting_interest_", "temp_msg_setting_nearby_", "temp_msg_setting_troop_", "temp_msg_setting_circle_" };
  
  public atvu(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.c();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_Awbw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
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
    return new atvw(this, paramBaseChatPie, paramShort);
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
    case -23311: 
      return "temp_msg_setting_interest_";
    case -23312: 
      return "temp_msg_setting_nearby_";
    }
    return "temp_msg_setting_circle_";
  }
  
  private void a(SessionInfo paramSessionInfo, short paramShort, String paramString, int paramInt, BaseChatPie paramBaseChatPie)
  {
    if (!a(a(paramShort)))
    {
      paramSessionInfo = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getString(2131720719), new Object[] { paramString, paramString });
      paramSessionInfo = bdcd.a(paramBaseChatPie.a, 230, alpo.a(2131715201), paramSessionInfo, 2131720717, 2131720718, a(paramBaseChatPie, paramShort), a(paramBaseChatPie, paramShort));
      paramSessionInfo.setOnCancelListener(new atvv(this, paramBaseChatPie));
      paramSessionInfo.setCanceledOnTouchOutside(false);
      paramSessionInfo.show();
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009977", "0X8009977", a(paramShort), a(paramShort), "", "", "", "");
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
    boolean bool1;
    if (paramInt == 0) {
      bool1 = localSharedPreferences.getBoolean(paramString + this.jdField_a_of_type_JavaLangString + "_setting", true);
    }
    boolean bool2;
    do
    {
      return bool1;
      if (paramInt != 1) {
        break;
      }
      bool2 = localSharedPreferences.getBoolean(paramString + this.jdField_a_of_type_JavaLangString + "_show", true);
      bool1 = bool2;
    } while (!bool2);
    localSharedPreferences.edit().putBoolean(paramString + this.jdField_a_of_type_JavaLangString + "_show", false).apply();
    return bool2;
    return false;
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
    case -23311: 
      return 3;
    case -23312: 
      return 2;
    }
    return 6;
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
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(str)) {
        this.jdField_a_of_type_JavaUtilMap.put(str, Boolean.valueOf(localSharedPreferences.getBoolean(str + this.jdField_a_of_type_JavaLangString + "_setting", true)));
      }
      i += 1;
    }
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public void a(atvx paramatvx)
  {
    this.jdField_a_of_type_Atvx = paramatvx;
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
      a(paramSessionInfo, (short)-23308, alpo.a(2131715200), i, paramBaseChatPie);
      return;
    case 1006: 
      a(paramSessionInfo, (short)-23310, alpo.a(2131715198), i, paramBaseChatPie);
      return;
    case 1001: 
    case 1003: 
      a(paramSessionInfo, (short)-23312, alpo.a(2131715197), i, paramBaseChatPie);
      return;
    case 10002: 
      a(paramSessionInfo, (short)-23311, alpo.a(2131715199), i, paramBaseChatPie);
      return;
    case 1005: 
      a(paramSessionInfo, (short)-23309, "QQ咨询", i, paramBaseChatPie);
      return;
    }
    a(paramSessionInfo, (short)-23171, alpo.a(2131720566), i, paramBaseChatPie);
  }
  
  public void a(SessionInfo paramSessionInfo, String paramString, int paramInt, short paramShort)
  {
    Object localObject;
    if (paramInt == 1000)
    {
      paramString = bdbt.o(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSessionInfo.c);
      String str = bdbt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSessionInfo.c, true);
      if (QLog.isColorLevel()) {
        QLog.d("TempMsgManager", 2, "getTroopNickName:" + paramString + " new From:" + str);
      }
      paramString = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getString(2131720724), new Object[] { str });
      localObject = new aslp(paramSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString, paramSessionInfo.jdField_a_of_type_Int, -5023, 655381, ayvc.a());
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_action", 39);
      localBundle.putString("textColor", "");
      localBundle.putString("image_resource", null);
      localBundle.putString("key_action_DATA", paramSessionInfo.c);
      ((aslp)localObject).a(5, str.length() + 5, localBundle);
      paramSessionInfo = new Bundle();
      paramSessionInfo.putInt("key_action", 38);
      paramSessionInfo.putString("textColor", "");
      paramSessionInfo.putString("image_resource", null);
      paramSessionInfo.putString("key_action_DATA", a(paramShort) + "");
      ((aslp)localObject).a(paramString.length() - 5, paramString.length() - 1, paramSessionInfo);
      paramSessionInfo = (SessionInfo)localObject;
    }
    for (;;)
    {
      localObject = new MessageForUniteGrayTip();
      ((MessageForUniteGrayTip)localObject).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSessionInfo);
      aslq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("TempMsgManager", 2, "add gray tip =" + paramString);
      }
      return;
      paramString = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getString(2131720723), new Object[] { paramString });
      paramSessionInfo = new aslp(paramSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString, paramSessionInfo.jdField_a_of_type_Int, -5023, 655381, ayvc.a());
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
      if (!bdje.a(paramString)) {
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
        localObject = (alkv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
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
      ((alkv)localObject).a(paramShort, paramBoolean1);
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
      if ((this.jdField_a_of_type_Awbw.a(TempMsgInfo.class, paramString + paramSessionInfo.jdField_a_of_type_JavaLangString) instanceof TempMsgInfo)) {
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TempMsgManager", 2, "can't tempMsgInfo, insert a new tempMsgInfo! type=" + paramString + "curFriendUin=" + paramSessionInfo.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Awbw.a(new TempMsgInfo(paramString + paramSessionInfo.jdField_a_of_type_JavaLangString, System.currentTimeMillis()));
      return true;
    }
    finally {}
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_Atvx = null;
    if (this.jdField_a_of_type_Awbw != null) {
      this.jdField_a_of_type_Awbw.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atvu
 * JD-Core Version:    0.7.0.1
 */