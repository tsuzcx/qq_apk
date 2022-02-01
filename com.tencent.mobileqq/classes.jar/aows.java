import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aows
  extends aoxg
{
  public aows(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean C()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("roomcode");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromid");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("isgroupcode");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("backtype");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("open_type");
    String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("extra");
    awaa localawaa = (awaa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(236);
    try
    {
      i = Integer.parseInt(str3);
      QLog.i("GroupVideoAction", 1, "[goToGroupVideoPlugin], roomId:" + str1 + ",fromId:" + str2 + " isGroupCode:" + str3);
      localawaa.a(this.jdField_a_of_type_AndroidContentContext, str1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), i, "download", str2, str4, str5, str6);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 1;
      }
    }
  }
  
  private boolean D()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromid");
    localObject = (awaa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(236);
    QLog.i("GroupVideoAction", 1, "[goToPreLoadGroupVideoPlugin]");
    ((awaa)localObject).a(null, 10L);
    return true;
  }
  
  public boolean a()
  {
    try
    {
      if (this.c.equals("openroom")) {
        return C();
      }
      if (this.c.equals("preload"))
      {
        boolean bool = D();
        return bool;
      }
    }
    catch (Exception localException)
    {
      QLog.e("GroupVideoAction", 1, "doAction error: " + localException.getMessage());
      a("GroupVideoAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aows
 * JD-Core Version:    0.7.0.1
 */