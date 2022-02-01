import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class bfuq
  implements bfuu
{
  bfuq(bfuo parambfuo, bful parambful) {}
  
  public void a(long paramLong, HashMap<bful, bfum> paramHashMap)
  {
    if (paramHashMap == null) {}
    do
    {
      return;
      paramHashMap = (bfum)paramHashMap.get(this.jdField_a_of_type_Bful);
    } while ((paramHashMap == null) || (paramHashMap.a != 1));
    if (QLog.isColorLevel()) {
      QLog.i("TroopEssenceMsgManager", 2, "isEssenceMsg refreshAio key:" + paramLong);
    }
    bfuo.a(this.jdField_a_of_type_Bfuo, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfuq
 * JD-Core Version:    0.7.0.1
 */