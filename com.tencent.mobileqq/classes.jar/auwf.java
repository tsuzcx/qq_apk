import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class auwf
  extends alwx
{
  auwf(auwd paramauwd) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramInt != 1) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NearbyProxy", 2, "onRemoveFromBlackList from nearby");
    }
    if (paramBoolean)
    {
      auac localauac = (auac)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(16);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(paramString));
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.a.jdField_a_of_type_Amcm);
      localauac.b(1001, localArrayList, 1);
      return;
    }
    auwd.a(this.a, 4116, new Object[] { Boolean.valueOf(false) });
  }
  
  protected void a(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (((Integer)paramArrayOfObject[0]).intValue() != 1) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NearbyProxy", 2, "onInsertIntoBlackList from nearby");
    }
    if ((paramBoolean) && (paramArrayOfObject.length == 4))
    {
      ((Long)paramArrayOfObject[1]).longValue();
      String str = (String)paramArrayOfObject[2];
      int i = ((Integer)paramArrayOfObject[3]).intValue();
      auwq.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "blacklist_sequence", Integer.valueOf(i));
      paramArrayOfObject = new ArrayList();
      paramArrayOfObject.add(Long.valueOf(str));
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.a.jdField_a_of_type_Amcm);
      ((auac)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(16)).a(1001, paramArrayOfObject, 1);
      return;
    }
    auwd.a(this.a, 4115, new Object[] { Boolean.valueOf(false) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auwf
 * JD-Core Version:    0.7.0.1
 */