import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class bfle
  implements bfli
{
  bfle(bflc parambflc, bfkz parambfkz) {}
  
  public void a(long paramLong, HashMap<bfkz, bfla> paramHashMap)
  {
    if (paramHashMap == null) {}
    do
    {
      return;
      paramHashMap = (bfla)paramHashMap.get(this.jdField_a_of_type_Bfkz);
    } while ((paramHashMap == null) || (paramHashMap.a != 1));
    if (QLog.isColorLevel()) {
      QLog.i("TroopEssenceMsgManager", 2, "isEssenceMsg refreshAio key:" + paramLong);
    }
    bflc.a(this.jdField_a_of_type_Bflc, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfle
 * JD-Core Version:    0.7.0.1
 */