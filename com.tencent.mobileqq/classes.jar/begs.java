import java.util.HashMap;
import java.util.Map;

public class begs
{
  private static begs jdField_a_of_type_Begs;
  long jdField_a_of_type_Long = 1L;
  Map<Long, begt> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public static begs a()
  {
    if (jdField_a_of_type_Begs == null) {
      jdField_a_of_type_Begs = new begs();
    }
    return jdField_a_of_type_Begs;
  }
  
  long a()
  {
    return this.jdField_a_of_type_Long % 1000L + 1L;
  }
  
  public void a(int paramInt, begt parambegt)
  {
    long l = a();
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(l), parambegt);
    parambegt = ajac.a();
    if (parambegt != null) {
      parambegt.a("apollo_game_av.get_av_ctrl_param", paramInt, l);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    begt localbegt;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong)))
    {
      localbegt = (begt)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      if (!paramBoolean) {
        break label62;
      }
      localbegt.a(paramArrayOfByte);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
      return;
      label62:
      localbegt.a(1, "Event");
    }
  }
  
  public void a(byte[] paramArrayOfByte, String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong, begt parambegt)
  {
    long l = a();
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(l), parambegt);
    paramString1 = ajac.a();
    if (paramString1 != null) {
      paramString1.a("apollo_game_av.join_av_room", paramInt1, paramInt2, paramLong, paramString2, paramArrayOfByte, l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     begs
 * JD-Core Version:    0.7.0.1
 */