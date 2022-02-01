import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class anhd
  extends nbn
{
  anhd(anha paramanha, long paramLong, Map paramMap, AVGameAppInterface paramAVGameAppInterface, anhg paramanhg) {}
  
  public void a(boolean paramBoolean, String paramString, long paramLong)
  {
    if (paramLong != this.jdField_a_of_type_Long) {
      QLog.e("GameRoomObserver", 1, "onGameShare fail: observer not match");
    }
    do
    {
      return;
      QLog.d("GameRoomObserver", 1, "onGameShare isSuccess: " + paramBoolean + " shareUrl: " + paramString + " mark: " + paramLong);
      nbn localnbn = (nbn)this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(this.jdField_a_of_type_Long));
      if (localnbn == null)
      {
        QLog.e("GameRoomObserver", 1, "onGameShare fail: observer not exist");
        return;
      }
      this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.removeObserver(localnbn);
    } while (this.jdField_a_of_type_Anhg == null);
    try
    {
      this.jdField_a_of_type_Anhg.a(paramBoolean, paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("GameRoomObserver", 1, "onGameShare exception: " + paramString.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anhd
 * JD-Core Version:    0.7.0.1
 */