import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager.1;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager.4;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class aqne
  implements Manager
{
  private final anvk jdField_a_of_type_Anvk;
  private aqnh jdField_a_of_type_Aqnh;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  private Map<Integer, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public aqne(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Anvk = ((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER));
    this.jdField_a_of_type_JavaUtilMap = new MessageNotificationSettingManager.1(this);
  }
  
  private int a(String paramString, int paramInt)
  {
    if (b(paramString))
    {
      if ((b()) && (a(paramString))) {
        return 2131230758;
      }
      return a();
    }
    return paramInt;
  }
  
  public static aqne a(QQAppInterface paramQQAppInterface)
  {
    return (aqne)paramQQAppInterface.getManager(QQManagerFactory.MESSAGE_NOTIFICATION_SETTING_MANAGER);
  }
  
  public static ExtensionInfo a(ExtensionInfo paramExtensionInfo)
  {
    ExtensionInfo localExtensionInfo = new ExtensionInfo();
    localExtensionInfo.uin = paramExtensionInfo.uin;
    localExtensionInfo.messageEnableSoundNew = paramExtensionInfo.messageEnableSoundNew;
    localExtensionInfo.messageEnableVibrateNew = paramExtensionInfo.messageEnableVibrateNew;
    localExtensionInfo.messageEnablePreviewNew = paramExtensionInfo.messageEnablePreviewNew;
    return localExtensionInfo;
  }
  
  private void a(String paramString)
  {
    paramString = new MessageNotificationSettingManager.4(this, paramString);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ThreadManager.post(paramString, 10, null, false);
      return;
    }
    paramString.run();
  }
  
  private boolean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingManager", 2, new Object[] { "isLocalRingId: invoked. ", " id: ", Integer.valueOf(paramInt), " R.raw.system: ", Integer.valueOf(2131230759), " R.raw.classic: ", Integer.valueOf(2131230720) });
    }
    boolean bool = this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingManager", 2, new Object[] { "isLocalRingId: invoked. ", " isLocal: ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool = true;
    if (paramMessageRecord == null) {
      return false;
    }
    int i;
    if ((paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 0))
    {
      i = 1;
      if ((i == 0) || (!Friends.isValidUin(paramMessageRecord.frienduin))) {
        break label46;
      }
    }
    for (;;)
    {
      return bool;
      i = 0;
      break;
      label46:
      bool = false;
    }
  }
  
  public static byte[] a(ExtensionInfo paramExtensionInfo)
  {
    int i;
    int j;
    if (paramExtensionInfo.messageEnablePreviewNew == 1)
    {
      i = 1;
      if (paramExtensionInfo.messageEnableVibrateNew != 1) {
        break label60;
      }
      j = 2;
      label20:
      if (paramExtensionInfo.messageEnableSoundNew != 1) {
        break label65;
      }
    }
    label60:
    label65:
    for (int k = 4;; k = 0)
    {
      paramExtensionInfo = PkgTools.intToBytes(i | j | k);
      return new byte[] { paramExtensionInfo[1], paramExtensionInfo[0] };
      i = 0;
      break;
      j = 0;
      break label20;
    }
  }
  
  private boolean b()
  {
    if (bhhi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MessageNotificationSettingManager", 2, new Object[] { "globalSpCaredRingEnable: invoked. ", "enable: ", Boolean.valueOf(bool), new RuntimeException() });
      }
      return bool;
    }
  }
  
  private boolean b(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    return c(paramMessageRecord.senderuin, paramMessageRecord.istroop);
  }
  
  private void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingManager", 2, new Object[] { "playRingId: invoked. ", " id: ", Integer.valueOf(paramInt) });
    }
    int j = a();
    int i;
    if (j == AppSetting.d) {
      i = j;
    }
    for (;;)
    {
      j = paramInt;
      if (paramInt == 0) {
        j = i;
      }
      if (!a(j)) {
        break;
      }
      paramInt = j;
      if (j == AppSetting.e) {
        paramInt = 2131230721;
      }
      bhcl.b(paramInt, false);
      return;
      i = j;
      if (j == AppSetting.e) {
        i = 2131230721;
      }
    }
    Object localObject = new aqng(this, j);
    boolean bool = bhrv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), j);
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingManager", 2, new Object[] { "playRingId: invoked. ", " ringExists: ", Boolean.valueOf(bool), " targetId: ", Integer.valueOf(j) });
    }
    if (!bool)
    {
      bhrv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, j, (bhog)localObject, false);
      return;
    }
    localObject = bhrv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), j);
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingManager", 2, new Object[] { "playRingId: invoked. ", " wavPath: ", localObject });
    }
    a((String)localObject);
  }
  
  private void c(MessageRecord paramMessageRecord)
  {
    a(paramMessageRecord);
    int i = a();
    paramMessageRecord = paramMessageRecord.senderuin;
    ExtensionInfo localExtensionInfo = this.jdField_a_of_type_Anvk.a(paramMessageRecord);
    if (localExtensionInfo == null)
    {
      QLog.d("MessageNotificationSettingManager", 1, new Object[] { "playFriendRing: invoked. using global id ", " extensionInfo: ", localExtensionInfo });
      c(i);
      return;
    }
    int j = localExtensionInfo.friendRingId;
    i = j;
    if (j == 0) {
      i = a(paramMessageRecord, j);
    }
    c(i);
  }
  
  private boolean c(String paramString, int paramInt)
  {
    boolean bool = b(paramString);
    return (paramInt == 1) && (bool);
  }
  
  public int a()
  {
    int i = SettingCloneUtil.readValueForInt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "sound_type", "qqsetting_notify_soundtype_key", SoundAndVibrateActivity.b);
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingManager", 2, new Object[] { "getGlobalRingId: invoked. ", " soundRid: ", Integer.valueOf(i) });
    }
    return i;
  }
  
  public Bitmap a(Bitmap paramBitmap, QQMessageFacade.Message paramMessage)
  {
    if (a(paramMessage.frienduin, paramMessage.istroop)) {
      return paramBitmap;
    }
    return null;
  }
  
  public String a(int paramInt1, String paramString, int paramInt2)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.context;
    String str = bhrv.b(localBaseApplication, paramInt1);
    if (a(paramInt1)) {
      paramString = (String)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1));
    }
    for (;;)
    {
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = "";
      }
      return str;
      if (paramInt1 == 0)
      {
        int i = a();
        if (QLog.isColorLevel()) {
          QLog.d("MessageNotificationSettingManager", 2, new Object[] { "setRingFormSimpleItem: invoked. from sp key:QQSETTING_NOTIFY_SOUNDTYPE_KEY ", " globalRingId: ", Integer.valueOf(i) });
        }
        paramInt1 = i;
        if (paramInt2 == 0) {
          paramInt1 = a(paramString, i);
        }
        if (QLog.isColorLevel()) {
          QLog.d("MessageNotificationSettingManager", 2, new Object[] { "setRingFormSimpleItem: invoked. getRingIdCheckSpCaredFriendAndGlobalSwitch:: ", " targetRingId: ", Integer.valueOf(paramInt1) });
        }
        if (a(paramInt1))
        {
          paramString = (String)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1));
        }
        else
        {
          paramString = bhrv.b(localBaseApplication, paramInt1);
          if (TextUtils.isEmpty(paramString)) {
            a(paramInt1);
          }
        }
      }
      else
      {
        paramString = str;
        if (TextUtils.isEmpty(str))
        {
          a(paramInt1);
          paramString = str;
        }
      }
    }
  }
  
  public String a(String paramString, QQMessageFacade.Message paramMessage)
  {
    if (a(paramMessage.frienduin, paramMessage.istroop)) {
      return paramString;
    }
    return anvx.a(2131706117) + paramMessage.counter + anvx.a(2131706118);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit().putBoolean("SP_KEY_RESET_GRAY_USER_RING_ID", true).apply();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MessageNotificationSettingManager", 2, new Object[] { "preDownloadRing: invoked. ", "ring-id: ", Integer.valueOf(paramInt) });
    }
    if ((paramInt > 0) && (!bhrv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramInt)) && (!a(paramInt)))
    {
      aqnf localaqnf = new aqnf(this, paramInt);
      bhrv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, localaqnf, false);
    }
  }
  
  public void a(aqnh paramaqnh)
  {
    this.jdField_a_of_type_Aqnh = paramaqnh;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    String str = paramMessageRecord.senderuin;
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingManager", 2, new Object[] { "compactUpdateRingData: invoked. ", " message.senderuin: ", str });
    }
    b(str, paramMessageRecord.istroop);
  }
  
  public void a(FormSimpleItem paramFormSimpleItem, int paramInt)
  {
    a(paramFormSimpleItem, paramInt, null, -1);
  }
  
  public void a(FormSimpleItem paramFormSimpleItem, int paramInt1, String paramString, int paramInt2)
  {
    if (paramFormSimpleItem == null) {
      return;
    }
    BaseApplication localBaseApplication = BaseApplicationImpl.context;
    String str = bhrv.b(localBaseApplication, paramInt1);
    if (a(paramInt1)) {
      paramString = (String)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1));
    }
    for (;;)
    {
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = "";
      }
      paramFormSimpleItem.setRightText(str);
      paramFormSimpleItem.setContentDescription(localBaseApplication.getString(2131690821) + str);
      return;
      if (paramInt1 == 0)
      {
        int i = a();
        if (QLog.isColorLevel()) {
          QLog.d("MessageNotificationSettingManager", 2, new Object[] { "setRingFormSimpleItem: invoked. from sp key:QQSETTING_NOTIFY_SOUNDTYPE_KEY ", " globalRingId: ", Integer.valueOf(i) });
        }
        paramInt1 = i;
        if (paramInt2 == 0) {
          paramInt1 = a(paramString, i);
        }
        if (QLog.isColorLevel()) {
          QLog.d("MessageNotificationSettingManager", 2, new Object[] { "setRingFormSimpleItem: invoked. getRingIdCheckSpCaredFriendAndGlobalSwitch:: ", " targetRingId: ", Integer.valueOf(paramInt1) });
        }
        if (a(paramInt1))
        {
          paramString = (String)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1));
        }
        else
        {
          paramString = bhrv.b(localBaseApplication, paramInt1);
          if (TextUtils.isEmpty(paramString)) {
            a(paramInt1);
          }
        }
      }
      else
      {
        paramString = str;
        if (TextUtils.isEmpty(str))
        {
          a(paramInt1);
          paramString = str;
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramInt < 0) {}
    ExtensionInfo localExtensionInfo2 = this.jdField_a_of_type_Anvk.a(paramString);
    ExtensionInfo localExtensionInfo1 = localExtensionInfo2;
    if (localExtensionInfo2 == null)
    {
      localExtensionInfo1 = new ExtensionInfo();
      localExtensionInfo1.uin = paramString;
    }
    if (localExtensionInfo1.friendRingId != paramInt)
    {
      localExtensionInfo1.friendRingId = paramInt;
      this.jdField_a_of_type_Anvk.a(localExtensionInfo1);
    }
    a(paramInt);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    TroopInfo localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(paramString);
    if (localTroopInfo == null)
    {
      localTroopInfo = new TroopInfo();
      localTroopInfo.troopuin = paramString;
      localTroopInfo.troopcode = paramString;
    }
    for (paramString = localTroopInfo;; paramString = localTroopInfo)
    {
      boolean bool;
      if (paramInt1 != 1)
      {
        bool = true;
        if (paramInt2 != 1024) {
          break label116;
        }
        paramString.setCmdUinFlagEx2(bool, 1024);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MessageNotificationSettingManager", 2, new Object[] { "saveTroopInfo: invoked. ", " troopInfo.cmdUinFlagEx2: ", Long.valueOf(paramString.cmdUinFlagEx2) });
        }
        this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(paramString);
        return;
        bool = false;
        break;
        label116:
        if (paramInt2 == 2048) {
          paramString.setCmdUinFlagEx2(bool, 2048);
        } else if (paramInt2 == 4096) {
          paramString.setCmdUinFlagEx2(bool, 4096);
        } else if (paramInt2 != 9) {}
      }
    }
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    ExtensionInfo localExtensionInfo = this.jdField_a_of_type_Anvk.a(paramString);
    if (localExtensionInfo == null)
    {
      localExtensionInfo = new ExtensionInfo();
      localExtensionInfo.uin = paramString;
    }
    for (;;)
    {
      if (paramInt == 1) {
        if (paramBoolean)
        {
          i = 0;
          localExtensionInfo.messageEnablePreviewNew = i;
        }
      }
      do
      {
        if (QLog.isColorLevel()) {
          QLog.d("MessageNotificationSettingManager", 2, new Object[] { "saveExtensionInfo: invoked. ", " uin: ", paramString, " type: ", Integer.valueOf(paramInt), " enable: ", Boolean.valueOf(paramBoolean) });
        }
        this.jdField_a_of_type_Anvk.a(localExtensionInfo);
        return;
        i = 1;
        break;
        if (paramInt == 3)
        {
          if (paramBoolean) {}
          for (i = 0;; i = 1)
          {
            localExtensionInfo.messageEnableVibrateNew = i;
            break;
          }
        }
      } while (paramInt != 2);
      if (paramBoolean) {}
      for (int i = 0;; i = 1)
      {
        localExtensionInfo.messageEnableSoundNew = i;
        break;
      }
    }
  }
  
  public void a(ConcurrentHashMap<String, Entity> paramConcurrentHashMap)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
    paramConcurrentHashMap = paramConcurrentHashMap.entrySet().iterator();
    while (paramConcurrentHashMap.hasNext())
    {
      Object localObject = (Map.Entry)paramConcurrentHashMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (Entity)((Map.Entry)localObject).getValue();
      if ((localObject instanceof ExtensionInfo))
      {
        localObject = (ExtensionInfo)localObject;
        if (((ExtensionInfo)localObject).friendRingId != 0)
        {
          int i = localSharedPreferences.getInt("special_sound_type" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + str, -1);
          if (QLog.isColorLevel()) {
            QLog.d("MessageNotificationSettingManager", 2, new Object[] { "resetGrayUserRingId: invoked. ", " specialSoundId: ", Integer.valueOf(i), " uin: ", str });
          }
          if (((ExtensionInfo)localObject).friendRingId == i)
          {
            ((ExtensionInfo)localObject).friendRingId = 0;
            this.jdField_a_of_type_Anvk.a((ExtensionInfo)localObject);
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getBoolean("SP_KEY_RESET_GRAY_USER_RING_ID", false);
  }
  
  public boolean a(String paramString)
  {
    SpecialCareInfo localSpecialCareInfo = this.jdField_a_of_type_Anvk.a(paramString);
    if (localSpecialCareInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MessageNotificationSettingManager", 2, new Object[] { "isSpCareFriendRingEnable: invoked. ", " info: ", localSpecialCareInfo, " info.globalSwitch: ", Integer.valueOf(localSpecialCareInfo.globalSwitch), " info.specialRingSwitch: ", Integer.valueOf(localSpecialCareInfo.specialRingSwitch) });
      }
      return (localSpecialCareInfo.globalSwitch == 1) && (localSpecialCareInfo.specialRingSwitch == 1);
    }
    boolean bool = this.jdField_a_of_type_Anvk.e();
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingManager", 2, new Object[] { "isSpCareFriendRingEnable: invoked. ", " spCareInfoCacheInited: ", Boolean.valueOf(bool), " uin: ", paramString });
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isShowMsgContent()) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return true;
            if (Friends.isValidUin(paramString)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("MessageNotificationSettingManager", 2, new Object[] { "enablePreview: invoked. ", " uin: ", paramString });
          return true;
          if (paramInt != 0) {
            break;
          }
          paramString = this.jdField_a_of_type_Anvk.a(paramString, false);
        } while ((paramString == null) || (paramString.messageEnablePreviewNew == 0));
        return false;
        if (paramInt != 1) {
          break;
        }
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(paramString);
      } while (paramString == null);
      return paramString.messageEnablePreview();
    } while (!QLog.isColorLevel());
    QLog.d("MessageNotificationSettingManager", 2, new Object[] { "enablePreview: invoked. ", " uinType: ", Integer.valueOf(paramInt) });
    return true;
  }
  
  public boolean a(boolean paramBoolean, String paramString, int paramInt)
  {
    boolean bool = true;
    if (!paramBoolean) {
      paramBoolean = false;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return paramBoolean;
              if (Friends.isValidUin(paramString)) {
                break;
              }
              paramBoolean = bool;
            } while (!QLog.isColorLevel());
            QLog.d("MessageNotificationSettingManager", 2, new Object[] { "enableSeparateVibrate: invoked. ", " uin: ", paramString });
            return true;
            if (paramInt != 0) {
              break;
            }
            paramString = this.jdField_a_of_type_Anvk.a(paramString, false);
            paramBoolean = bool;
          } while (paramString == null);
          paramBoolean = bool;
        } while (paramString.messageEnableVibrateNew == 0);
        return false;
        if (paramInt != 1) {
          break;
        }
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(paramString);
        paramBoolean = bool;
      } while (paramString == null);
      return paramString.messageEnableVibrate();
      paramBoolean = bool;
    } while (!QLog.isColorLevel());
    QLog.d("MessageNotificationSettingManager", 2, new Object[] { "enableSeparateVibrate: invoked. ", " uinType: ", Integer.valueOf(paramInt) });
    return true;
  }
  
  public String b(String paramString, QQMessageFacade.Message paramMessage)
  {
    if (a(paramMessage.frienduin, paramMessage.istroop)) {
      return paramString;
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694350);
  }
  
  public void b()
  {
    int i = a();
    c(i);
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingManager", 2, new Object[] { "playGlobalRing: invoked. ", " globalRingId: ", Integer.valueOf(i) });
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingManager", 2, new Object[] { "saveGlobalRingId: invoked. ", " id: ", Integer.valueOf(paramInt) });
    }
    if ((a() != paramInt) && (paramInt != 0))
    {
      SettingCloneUtil.writeValueForInt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "sound_type", "qqsetting_notify_soundtype_key", paramInt);
      a(paramInt);
    }
  }
  
  public void b(aqnh paramaqnh)
  {
    this.jdField_a_of_type_Aqnh = null;
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    int i = a();
    if (paramMessageRecord.istroop == 0) {
      c(paramMessageRecord);
    }
    while (paramMessageRecord.istroop != 1) {
      return;
    }
    if (b(paramMessageRecord))
    {
      c(paramMessageRecord);
      return;
    }
    if (bhsv.a(paramMessageRecord))
    {
      c(2131230758);
      return;
    }
    paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(paramMessageRecord.frienduin);
    if (paramMessageRecord == null)
    {
      c(i);
      return;
    }
    c((int)paramMessageRecord.udwCmdUinRingtoneID);
  }
  
  public void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingManager", 2, new Object[] { "compactUpdateRingData: invoked. ", " targetUin: ", paramString, " uinType: ", Integer.valueOf(paramInt) });
    }
    if ((paramInt == 0) || (c(paramString, paramInt)))
    {
      boolean bool1 = a(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("MessageNotificationSettingManager", 2, new Object[] { "compactUpdateRingData: invoked. ", " spCareFriendRingEnable: ", Boolean.valueOf(bool1), " targetUin: ", paramString });
      }
      boolean bool2 = b();
      if (QLog.isColorLevel()) {
        QLog.d("MessageNotificationSettingManager", 2, new Object[] { "compactUpdateRingData: invoked. ", " globalSpCaredRingEnable: ", Boolean.valueOf(bool2) });
      }
      if ((bool1) && (bool2))
      {
        ExtensionInfo localExtensionInfo = this.jdField_a_of_type_Anvk.a(paramString);
        if ((localExtensionInfo == null) || (localExtensionInfo.friendRingId == 0))
        {
          paramInt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0).getInt("special_sound_type" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + paramString, -1);
          if (QLog.isColorLevel()) {
            QLog.d("MessageNotificationSettingManager", 2, new Object[] { "compactUpdateRingData: invoked. ", " specialSoundId: ", Integer.valueOf(paramInt) });
          }
          if (paramInt != -1) {
            a(paramString, paramInt);
          }
        }
      }
    }
  }
  
  public boolean b(String paramString)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = this.jdField_a_of_type_Anvk.a(paramString);
    } while (paramString == null);
    if (paramString.globalSwitch == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean b(String paramString, int paramInt)
  {
    boolean bool = true;
    if (!Friends.isValidUin(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("MessageNotificationSettingManager", 2, new Object[] { "enableSeparateSoundWhenGlobalSwitchOff: invoked. ", " uin: ", paramString });
      }
    }
    label147:
    label242:
    do
    {
      do
      {
        do
        {
          return false;
          if (paramInt != 0) {
            break label147;
          }
          paramString = this.jdField_a_of_type_Anvk.a(paramString, true);
          if (paramString != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("MessageNotificationSettingManager", 2, new Object[] { "enableSeparateSoundWhenGlobalSwitchOff: invoked. ", " extensionInfo: ", paramString });
        return false;
        if (QLog.isColorLevel()) {
          QLog.d("MessageNotificationSettingManager", 2, new Object[] { "enableSeparateSoundWhenGlobalSwitchOff: invoked. ", " messageEnableSoundNew: ", Integer.valueOf(paramString.messageEnableSoundNew) });
        }
        if (paramString.messageEnableSoundNew == 0) {}
        for (;;)
        {
          return bool;
          bool = false;
        }
        if (paramInt != 1) {
          break label242;
        }
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(paramString);
        if (paramString != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("MessageNotificationSettingManager", 2, new Object[] { "enableSeparateSoundWhenGlobalSwitchOff: invoked. ", " troopInfo: ", paramString });
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("MessageNotificationSettingManager", 2, new Object[] { "enableSeparateSoundWhenGlobalSwitchOff: invoked. ", " messageEnableSound: ", Boolean.valueOf(paramString.messageEnableSound()) });
      }
      return paramString.messageEnableSound();
    } while (!QLog.isColorLevel());
    QLog.d("MessageNotificationSettingManager", 2, new Object[] { "enableSeparateSoundWhenGlobalSwitchOff: invoked. ", " uinType: ", Integer.valueOf(paramInt) });
    return false;
  }
  
  public boolean b(boolean paramBoolean, String paramString, int paramInt)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingManager", 2, new Object[] { "enableSeparateSound: invoked. ", " globalSwitch: ", Boolean.valueOf(paramBoolean), " uin: ", paramString, " uinType: ", Integer.valueOf(paramInt) });
    }
    if (!paramBoolean) {
      paramBoolean = false;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return paramBoolean;
              if (Friends.isValidUin(paramString)) {
                break;
              }
              paramBoolean = bool;
            } while (!QLog.isColorLevel());
            QLog.d("MessageNotificationSettingManager", 2, new Object[] { "enableSeparateSound: invoked. ", " uin: ", paramString });
            return true;
            if (paramInt != 0) {
              break;
            }
            paramString = this.jdField_a_of_type_Anvk.a(paramString, false);
            if (QLog.isColorLevel()) {
              QLog.d("MessageNotificationSettingManager", 2, new Object[] { "enableSeparateSound: invoked. ", " extensionInfo: ", paramString });
            }
            paramBoolean = bool;
          } while (paramString == null);
          if (QLog.isColorLevel()) {
            QLog.d("MessageNotificationSettingManager", 2, new Object[] { "enableSeparateSound: invoked. ", " extensionInfo.messageEnableSoundNew: ", Integer.valueOf(paramString.messageEnableSoundNew) });
          }
          paramBoolean = bool;
        } while (paramString.messageEnableSoundNew == 0);
        return false;
        if (paramInt != 1) {
          break;
        }
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(paramString);
        paramBoolean = bool;
      } while (paramString == null);
      return paramString.messageEnableSound();
      paramBoolean = bool;
    } while (!QLog.isColorLevel());
    QLog.d("MessageNotificationSettingManager", 2, new Object[] { "enableSeparateSound: invoked. ", " uinType: ", Integer.valueOf(paramInt) });
    return true;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqne
 * JD-Core Version:    0.7.0.1
 */