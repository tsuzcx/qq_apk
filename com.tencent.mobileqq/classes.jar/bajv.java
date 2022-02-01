import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;

public class bajv
{
  private int jdField_a_of_type_Int;
  private bajx jdField_a_of_type_Bajx;
  private bajy jdField_a_of_type_Bajy = new bajw(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  
  public bajv(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OneWayFriendHelper", 0, String.format("OneWayFriendHelper app=%s curType=%s friendUin=%s", new Object[] { paramQQAppInterface, Integer.valueOf(paramInt), paramString }));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bajy);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OneWayFriendHelper", 0, String.format("notifyOneWayFriend friendUin=%s oneWayFriend=%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    }
    if (this.jdField_a_of_type_Bajx != null) {
      this.jdField_a_of_type_Bajx.a(paramString, paramBoolean);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    paramQQAppInterface = (anmw)paramQQAppInterface.getManager(51);
    return (paramInt == 0) && (!paramQQAppInterface.b(paramString));
  }
  
  public void a()
  {
    if (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString))
    {
      baju localbaju = (baju)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(179);
      if (localbaju != null) {
        localbaju.a(Long.parseLong(this.jdField_a_of_type_JavaLangString));
      }
      return;
    }
    a(this.jdField_a_of_type_JavaLangString, false);
  }
  
  public void a(bajx parambajx)
  {
    this.jdField_a_of_type_Bajx = parambajx;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bajx = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bajy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bajv
 * JD-Core Version:    0.7.0.1
 */