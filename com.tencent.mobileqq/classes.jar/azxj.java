import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;

public class azxj
{
  private int jdField_a_of_type_Int;
  private azxl jdField_a_of_type_Azxl;
  private azxm jdField_a_of_type_Azxm = new azxk(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  
  public azxj(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OneWayFriendHelper", 0, String.format("OneWayFriendHelper app=%s curType=%s friendUin=%s", new Object[] { paramQQAppInterface, Integer.valueOf(paramInt), paramString }));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Azxm);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OneWayFriendHelper", 0, String.format("notifyOneWayFriend friendUin=%s oneWayFriend=%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    }
    if (this.jdField_a_of_type_Azxl != null) {
      this.jdField_a_of_type_Azxl.a(paramString, paramBoolean);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    paramQQAppInterface = (amsw)paramQQAppInterface.getManager(51);
    return (paramInt == 0) && (!paramQQAppInterface.b(paramString));
  }
  
  public void a()
  {
    if (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString))
    {
      azxi localazxi = (azxi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(179);
      if (localazxi != null) {
        localazxi.a(Long.parseLong(this.jdField_a_of_type_JavaLangString));
      }
      return;
    }
    a(this.jdField_a_of_type_JavaLangString, false);
  }
  
  public void a(azxl paramazxl)
  {
    this.jdField_a_of_type_Azxl = paramazxl;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Azxl = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Azxm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azxj
 * JD-Core Version:    0.7.0.1
 */