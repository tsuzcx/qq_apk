import android.os.Handler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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

public class blvf
  implements Manager
{
  public static String a;
  public static String b = "source_push";
  public static String c = "source_loop";
  private blva jdField_a_of_type_Blva;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<Long, Boolean> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = "source_resume";
  }
  
  public blvf(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(long paramLong, boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_Blva == null) {
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
  
  public void a(blva paramblva)
  {
    this.jdField_a_of_type_Blva = paramblva;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(paramblva);
  }
  
  public void a(String paramString1, String paramString2)
  {
    ((bluz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ILIVE_COMMON_HANDLER)).a("", paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    ((bluz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ILIVE_COMMON_HANDLER)).a(paramString1, paramString2, paramString3);
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
      ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(String.valueOf(paramLong)).setIsTroopLive(bool1);
      if (this.jdField_a_of_type_Blva == null) {
        break;
      }
      a(paramLong, bool1, paramQQVaLiveNotifyMsg);
      return;
    }
  }
  
  public void b(blva paramblva)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(paramblva);
    this.jdField_a_of_type_Blva = null;
  }
  
  public void onDestroy()
  {
    if ((this.jdField_a_of_type_Blva != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Blva);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blvf
 * JD-Core Version:    0.7.0.1
 */