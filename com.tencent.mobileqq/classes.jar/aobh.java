import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class aobh
  extends mwq
{
  aobh(aobd paramaobd, long paramLong, Map paramMap, AppInterface paramAppInterface, aobj paramaobj) {}
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong3 != this.jdField_a_of_type_Long) {
      QLog.e("AvGameRoomListObserver", 1, "onShareInviteBackflow fail: observer not match");
    }
    do
    {
      return;
      QLog.d("AvGameRoomListObserver", 1, "onShareInviteBackflow isSuccess: " + paramBoolean + " roomId: " + paramLong1 + " shareUin: " + paramLong2 + " mark: " + paramLong3);
      mwq localmwq = (mwq)this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(this.jdField_a_of_type_Long));
      if (localmwq == null)
      {
        QLog.e("AvGameRoomListObserver", 1, "onShareInviteBackflow fail: observer not exist");
        return;
      }
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(localmwq);
    } while (this.jdField_a_of_type_Aobj == null);
    try
    {
      this.jdField_a_of_type_Aobj.a(paramBoolean, paramLong1, paramLong2);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AvGameRoomListObserver", 1, "onShareInviteBackflow exception: " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aobh
 * JD-Core Version:    0.7.0.1
 */