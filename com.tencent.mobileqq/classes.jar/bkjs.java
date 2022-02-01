import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.ilive.group.IliveGroupTipsManager.1;
import java.util.HashMap;
import mqq.manager.Manager;
import tencent.im.oidb.cmd0x857.TroopTips0x857.QQVaLiveNotifyMsg;

public class bkjs
  implements Manager
{
  public static String a;
  public static String b = "source_push";
  public static String c = "source_loop";
  private bkjn jdField_a_of_type_Bkjn;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<Long, Boolean> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = "source_resume";
  }
  
  public bkjs(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static String a(String paramString)
  {
    String str2 = QzoneConfig.getInstance().getConfig("H5Url", "VASLiveTipsGroupSetting", "https://h5.qzone.qq.com/v2/vip/live/group-follow-list?groupId={group_uin}");
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (paramString != null) {
        str1 = str2.replace("{group_uin}", paramString);
      }
    }
    return str1;
  }
  
  private void a(long paramLong, boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_Bkjn == null) {
      return;
    }
    if (paramBoolean) {}
    for (long l = 3000L;; l = 0L)
    {
      ThreadManagerV2.getUIHandlerV2().postDelayed(new IliveGroupTipsManager.1(this, paramBoolean, paramString, paramLong), l);
      return;
    }
  }
  
  public static boolean a()
  {
    return QzoneConfig.getInstance().getConfig("qqLive", "iliveTopsLoopEnable", 1) == 1;
  }
  
  public void a(bkjn parambkjn)
  {
    this.jdField_a_of_type_Bkjn = parambkjn;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(parambkjn);
  }
  
  public void a(String paramString1, String paramString2)
  {
    ((bkjm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(192)).a("", paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    ((bkjm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(192)).a(paramString1, paramString2, paramString3);
  }
  
  public void a(TroopTips0x857.QQVaLiveNotifyMsg paramQQVaLiveNotifyMsg, long paramLong)
  {
    boolean bool2 = false;
    if (paramQQVaLiveNotifyMsg == null) {
      return;
    }
    boolean bool1 = bool2;
    if (paramQQVaLiveNotifyMsg.notify_type.has())
    {
      bool1 = bool2;
      if (paramQQVaLiveNotifyMsg.notify_type.get() == 1) {
        bool1 = true;
      }
    }
    if (paramQQVaLiveNotifyMsg.bytes_uid.has()) {}
    for (paramQQVaLiveNotifyMsg = paramQQVaLiveNotifyMsg.bytes_uid.get().toStringUtf8();; paramQQVaLiveNotifyMsg = "")
    {
      QLog.d("IliveGroupTipsManager", 1, "handlePushLiveData isLive = " + bool1 + " puid = " + paramQQVaLiveNotifyMsg + " troopUin = " + paramLong);
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), Boolean.valueOf(bool1));
      ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(String.valueOf(paramLong)).setIsTroopLive(bool1);
      if (this.jdField_a_of_type_Bkjn == null) {
        break;
      }
      a(paramLong, bool1, paramQQVaLiveNotifyMsg);
      return;
    }
  }
  
  public void b(bkjn parambkjn)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(parambkjn);
    this.jdField_a_of_type_Bkjn = null;
  }
  
  public void onDestroy()
  {
    if ((this.jdField_a_of_type_Bkjn != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bkjn);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkjs
 * JD-Core Version:    0.7.0.1
 */