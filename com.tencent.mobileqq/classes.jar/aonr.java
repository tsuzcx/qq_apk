import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class aonr
  extends nam
{
  aonr(aono paramaono, long paramLong, Map paramMap, AVGameAppInterface paramAVGameAppInterface, aonu paramaonu) {}
  
  public void a(boolean paramBoolean, String paramString, long paramLong)
  {
    if (paramLong != this.jdField_a_of_type_Long) {
      QLog.e("GameRoomObserver", 1, "onGameShare fail: observer not match");
    }
    do
    {
      return;
      QLog.d("GameRoomObserver", 1, "onGameShare isSuccess: " + paramBoolean + " shareUrl: " + paramString + " mark: " + paramLong);
      nam localnam = (nam)this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(this.jdField_a_of_type_Long));
      if (localnam == null)
      {
        QLog.e("GameRoomObserver", 1, "onGameShare fail: observer not exist");
        return;
      }
      this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.removeObserver(localnam);
    } while (this.jdField_a_of_type_Aonu == null);
    try
    {
      this.jdField_a_of_type_Aonu.a(paramBoolean, paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("GameRoomObserver", 1, "onGameShare exception: " + paramString.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aonr
 * JD-Core Version:    0.7.0.1
 */