import android.content.SharedPreferences;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.GroupSystemMsgOldData;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController.1;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController.2;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController.3;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController.4;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class bafj
{
  private static volatile bafj jdField_a_of_type_Bafj;
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = -1L;
  private MessageHandler jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private final String jdField_a_of_type_JavaLangString = bafj.class.getName();
  private HashMap<Long, structmsg.StructMsg> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private structmsg.StructMsg jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private long jdField_b_of_type_Long = -1L;
  private String jdField_b_of_type_JavaLangString;
  private HashMap<Long, Long> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  
  public static bafj a()
  {
    if (jdField_a_of_type_Bafj == null) {}
    try
    {
      if (jdField_a_of_type_Bafj == null) {
        jdField_a_of_type_Bafj = new bafj();
      }
      return jdField_a_of_type_Bafj;
    }
    finally {}
  }
  
  private int c(QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null) {
      i = paramQQAppInterface.getInt("unread_Group_system_msg", 0);
    }
    return i;
  }
  
  private int d(QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null) {
      i = paramQQAppInterface.getInt("unread_Group_suspicious_msg", 0);
    }
    return i;
  }
  
  public int a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_Int == -1) {
      this.jdField_a_of_type_Int = c(paramQQAppInterface);
    }
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public String a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.getString("group_display", "");
    }
    return "";
  }
  
  public structmsg.StructMsg a()
  {
    return this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
  }
  
  public structmsg.StructMsg a(Long paramLong)
  {
    structmsg.StructMsg localStructMsg = null;
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      localStructMsg = (structmsg.StructMsg)this.jdField_a_of_type_JavaUtilHashMap.get(paramLong);
    }
    return localStructMsg;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler = null;
    try
    {
      jdField_a_of_type_Bafj = null;
      return;
    }
    finally {}
  }
  
  public void a(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void a(long paramLong1, long paramLong2, QQAppInterface paramQQAppInterface)
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    long l = 0L;
    try
    {
      if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong1))) {
        l = ((Long)this.jdField_b_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong1))).longValue();
      }
      if (l >= paramLong2) {
        return;
      }
      this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "addSystemMsgOldData " + paramLong1 + " " + paramLong2);
      }
      paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      if (paramQQAppInterface == null) {
        return;
      }
    }
    finally {}
    GroupSystemMsgOldData localGroupSystemMsgOldData = new GroupSystemMsgOldData();
    localGroupSystemMsgOldData.uin = paramLong1;
    localGroupSystemMsgOldData.msgtime = paramLong2;
    paramQQAppInterface.b(localGroupSystemMsgOldData);
    paramQQAppInterface.a();
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    if (paramQQAppInterface == null) {
      return;
    }
    Object localObject = paramQQAppInterface.a(GroupSystemMsgOldData.class, false, null, null, null, null, "msgtime desc", null);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        GroupSystemMsgOldData localGroupSystemMsgOldData = (GroupSystemMsgOldData)((Iterator)localObject).next();
        this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(localGroupSystemMsgOldData.uin), Long.valueOf(localGroupSystemMsgOldData.msgtime));
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_JavaLangString, 2, "initSystemMsgOldData " + localGroupSystemMsgOldData.uin + " " + localGroupSystemMsgOldData.msgtime);
        }
      }
    }
    paramQQAppInterface.a();
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    paramQQAppInterface.a(new GroupSystemMsgController.1(this, paramQQAppInterface, paramInt));
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface.a(new GroupSystemMsgController.3(this, paramQQAppInterface, paramString));
  }
  
  public void a(Long paramLong, structmsg.StructMsg paramStructMsg)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "putStructMsgToMap key=" + paramLong);
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramLong, paramStructMsg);
    }
  }
  
  public void a(structmsg.StructMsg paramStructMsg)
  {
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = paramStructMsg;
  }
  
  public void a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface.a(new GroupSystemMsgController.4(this, paramQQAppInterface, paramBoolean));
  }
  
  public int b(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_b_of_type_Int == -1) {
      this.jdField_b_of_type_Int = d(paramQQAppInterface);
    }
    return this.jdField_b_of_type_Int;
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    paramQQAppInterface.a(new GroupSystemMsgController.2(this, paramQQAppInterface, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bafj
 * JD-Core Version:    0.7.0.1
 */