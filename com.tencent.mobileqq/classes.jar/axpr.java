import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class axpr
  extends anyz
{
  axpr(axpp paramaxpp) {}
  
  protected void onInsertIntoBlackList(boolean paramBoolean, Object[] paramArrayOfObject)
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
      axqc.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "blacklist_sequence", Integer.valueOf(i));
      paramArrayOfObject = new ArrayList();
      paramArrayOfObject.add(Long.valueOf(str));
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.a.jdField_a_of_type_Aodm);
      ((awtp)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SHIELD_LIST_MANAGER)).a(1001, paramArrayOfObject, 1);
      return;
    }
    axpp.a(this.a, 4115, new Object[] { Boolean.valueOf(false) });
  }
  
  protected void onRemoveFromBlackList(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramInt != 1) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NearbyProxy", 2, "onRemoveFromBlackList from nearby");
    }
    if (paramBoolean)
    {
      awtp localawtp = (awtp)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(paramString));
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.a.jdField_a_of_type_Aodm);
      localawtp.b(1001, localArrayList, 1);
      return;
    }
    axpp.a(this.a, 4116, new Object[] { Boolean.valueOf(false) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axpr
 * JD-Core Version:    0.7.0.1
 */