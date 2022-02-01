import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.manager.Manager;

public class bgrs
  implements Manager
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  ConcurrentHashMap<String, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  Lock jdField_a_of_type_JavaUtilConcurrentLocksLock;
  boolean jdField_a_of_type_Boolean = false;
  public ConcurrentHashMap<String, Integer> b;
  boolean b;
  public ConcurrentHashMap<String, Boolean> c;
  boolean c;
  
  public bgrs(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (bgrs)paramQQAppInterface.getManager(31);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.b("message.ring.care", 0);
    }
    return 0;
  }
  
  public static int a(String paramString)
  {
    if (paramString.contains("message.group.policy.")) {
      return 1;
    }
    if (paramString.contains("message.group.ring")) {
      return 2;
    }
    if (paramString.contains("message.group.vibrate")) {
      return 3;
    }
    if (paramString.contains("message.ring.switch")) {
      return 4;
    }
    if (paramString.contains("message.vibrate.switch")) {
      return 5;
    }
    if (paramString.contains("sync.c2c_message")) {
      return 6;
    }
    if (paramString.contains("message.ring.care")) {
      return 7;
    }
    return -1;
  }
  
  public static String a(String paramString, int paramInt)
  {
    if (paramInt == 1) {
      paramString = "message.group.policy." + paramString;
    }
    do
    {
      return paramString;
      if (paramInt == 2) {
        return "message.group.ring";
      }
      if (paramInt == 3) {
        return "message.group.vibrate";
      }
      if (paramInt == 4) {
        return "message.ring.switch";
      }
      if (paramInt == 5) {
        return "message.vibrate.switch";
      }
      if (paramInt == 6) {
        return "sync.c2c_message";
      }
    } while (paramInt != 7);
    return "message.ring.care";
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RoamSetting", 2, "uploadNewValue...");
    }
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRunning())) {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("uploadNewValue return directly, app.isRunning=");
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          break label75;
        }
        localObject = "null";
        QLog.d("RoamSetting", 2, localObject);
      }
    }
    label75:
    label205:
    do
    {
      do
      {
        return;
        localObject = Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRunning());
        break;
        if (this.jdField_b_of_type_Boolean)
        {
          if ((this.jdField_a_of_type_Long <= 0L) || (this.jdField_a_of_type_Long + 45000L >= System.currentTimeMillis())) {
            break label205;
          }
          if (QLog.isColorLevel()) {
            QLog.d("RoamSetting", 2, "uploadNewValue state_allLoading=" + this.jdField_b_of_type_Boolean + " more than 45s, forced to stop");
          }
          this.jdField_a_of_type_Long = 0L;
          this.jdField_b_of_type_Boolean = false;
        }
        b();
        localObject = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
      } while (localObject == null);
      ((FriendListHandler)localObject).a(a().a(), this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("RoamSetting", 2, "uploadNewValue but return, state_allLoading=" + this.jdField_b_of_type_Boolean + ", time_allLoading less than 60s, waitting...");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = (bgrs)paramQQAppInterface.getManager(31);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a("message.ring.care", Integer.valueOf(paramInt));
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.putAll(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      if (QLog.isColorLevel()) {
        QLog.d("RoamSetting", 2, "copyNewValue2Uploading, change state_newValue=false, mapUploading:" + this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.toString());
      }
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public int a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return 1;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    return ((Integer)a(localArrayList, paramInt).get(paramString)).intValue();
  }
  
  anuj a()
  {
    return (anuj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(40);
  }
  
  public Map<String, Integer> a(List<String> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return new HashMap();
    }
    Map localMap = bglj.a().a(paramList, paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      try
      {
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          str = (String)paramList.next();
          StringBuilder localStringBuilder = new StringBuilder(40);
          localStringBuilder.append("message.group.policy.");
          localStringBuilder.append(str);
          str = localStringBuilder.toString();
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
          {
            localMap.put(str, Integer.valueOf(((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).intValue()));
            continue;
          }
        }
      }
      catch (OutOfMemoryError paramList)
      {
        String str;
        if (QLog.isColorLevel()) {
          QLog.e("RoamSetting", 2, "getTroopMsgFilterList OutOfMemoryError");
        }
        return localMap;
        if (!this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {
          continue;
        }
        localMap.put(str, Integer.valueOf(((Integer)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).intValue()));
        continue;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, FriendListHandler paramFriendListHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RoamSetting", 2, "loadRoamSettingsByPage,localRevision=" + paramInt1 + " offset=" + paramLong + " respRevision=" + paramInt2 + " needTroopSettings=" + paramBoolean + " thread=" + Thread.currentThread().getName());
    }
    if (paramFriendListHandler == null) {
      paramFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
    }
    for (;;)
    {
      paramFriendListHandler.a(paramInt1, paramLong, paramInt2, paramBoolean);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      return;
    }
  }
  
  public void a(String paramString, Integer paramInteger)
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramInteger);
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      if (QLog.isColorLevel()) {
        QLog.d("RoamSetting", 2, "state_newValue=" + this.jdField_c_of_type_Boolean + " setRoamSettingNewValue, path=" + paramString + " value=" + paramInteger + " uploadingCount=" + this.jdField_a_of_type_Int);
      }
      a();
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public void a(boolean paramBoolean, FriendListHandler paramFriendListHandler)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRunning())) {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("loadAllRoamSetting return directly, app.isRunning=");
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          break label64;
        }
        paramFriendListHandler = "null";
        QLog.d("RoamSetting", 2, paramFriendListHandler);
      }
    }
    label64:
    do
    {
      return;
      paramFriendListHandler = Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRunning());
      break;
      if (!this.jdField_b_of_type_Boolean) {
        break label121;
      }
    } while (!QLog.isColorLevel());
    QLog.d("RoamSetting", 2, "loadAllRoamSettings but return, state_allUpdating=" + this.jdField_b_of_type_Boolean);
    return;
    label121:
    this.jdField_b_of_type_Boolean = true;
    int i = a().a();
    if (QLog.isColorLevel()) {
      QLog.d("RoamSetting", 2, "loadAllRoamSettings, localRevision=" + i + " needTroopSettings=" + paramBoolean + " thread=" + Thread.currentThread().getName());
    }
    a(i, 0L, -1, paramBoolean, paramFriendListHandler);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RoamSetting", 2, "onGetAllSettingsFinish isSucc=" + paramBoolean1 + " next=" + paramBoolean2);
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    if ((paramBoolean2) && (this.jdField_c_of_type_Boolean)) {
      a();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int < 3;
  }
  
  public int b(String paramString, int paramInt)
  {
    if (paramString == null) {
      return paramInt;
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
      {
        paramInt = ((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).intValue();
        return paramInt;
      }
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
      {
        paramInt = ((Integer)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).intValue();
        return paramInt;
      }
      return a().a(paramString, paramInt);
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RoamSetting", 2, "onUploadRomingSettingsFinish isSuccess=" + paramBoolean1 + " reload=" + paramBoolean2);
    }
    c();
    if ((paramBoolean1) && (paramBoolean2)) {
      a(true, null);
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgrs
 * JD-Core Version:    0.7.0.1
 */