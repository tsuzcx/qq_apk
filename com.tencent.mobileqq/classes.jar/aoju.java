import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class aoju
  extends ndm
{
  aoju(aojq paramaojq, long paramLong, Map paramMap, AppInterface paramAppInterface, aojw paramaojw) {}
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (paramLong3 != this.jdField_a_of_type_Long) {
      QLog.e("AvGameRoomListObserver", 1, "onShareInviteBackflow fail: observer not match");
    }
    do
    {
      return;
      QLog.d("AvGameRoomListObserver", 1, "onShareInviteBackflow isSuccess: " + paramBoolean + " roomId: " + paramLong1 + " shareUin: " + paramLong2 + " mark: " + paramLong3 + " shareType: " + paramLong4);
      ndm localndm = (ndm)this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(this.jdField_a_of_type_Long));
      if (localndm == null)
      {
        QLog.e("AvGameRoomListObserver", 1, "onShareInviteBackflow fail: observer not exist");
        return;
      }
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(localndm);
    } while (this.jdField_a_of_type_Aojw == null);
    try
    {
      this.jdField_a_of_type_Aojw.a(paramBoolean, paramLong1, paramLong2, paramLong4);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AvGameRoomListObserver", 1, "onShareInviteBackflow exception: " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoju
 * JD-Core Version:    0.7.0.1
 */