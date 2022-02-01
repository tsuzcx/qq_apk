import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

public class bbds
{
  private int jdField_a_of_type_Int;
  private bbdu jdField_a_of_type_Bbdu;
  private bbdv jdField_a_of_type_Bbdv = new bbdt(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  
  public bbds(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OneWayFriendHelper", 0, String.format("OneWayFriendHelper app=%s curType=%s friendUin=%s", new Object[] { paramQQAppInterface, Integer.valueOf(paramInt), paramString }));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bbdv);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OneWayFriendHelper", 0, String.format("notifyOneWayFriend friendUin=%s oneWayFriend=%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    }
    if (this.jdField_a_of_type_Bbdu != null) {
      this.jdField_a_of_type_Bbdu.a(paramString, paramBoolean);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    paramQQAppInterface = (anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    return (paramInt == 0) && (!paramQQAppInterface.b(paramString));
  }
  
  public void a()
  {
    if (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString))
    {
      bbdr localbbdr = (bbdr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ONE_WAY_FRIEND_HANDLER);
      if (localbbdr != null) {
        localbbdr.a(Long.parseLong(this.jdField_a_of_type_JavaLangString));
      }
      return;
    }
    a(this.jdField_a_of_type_JavaLangString, false);
  }
  
  public void a(bbdu parambbdu)
  {
    this.jdField_a_of_type_Bbdu = parambbdu;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bbdu = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bbdv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbds
 * JD-Core Version:    0.7.0.1
 */