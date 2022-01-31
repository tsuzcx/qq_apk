import java.util.HashMap;
import java.util.Map;

public class begb
{
  private static begb jdField_a_of_type_Begb;
  long jdField_a_of_type_Long = 1L;
  Map<Long, begc> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public static begb a()
  {
    if (jdField_a_of_type_Begb == null) {
      jdField_a_of_type_Begb = new begb();
    }
    return jdField_a_of_type_Begb;
  }
  
  long a()
  {
    return this.jdField_a_of_type_Long % 1000L + 1L;
  }
  
  public void a(int paramInt, begc parambegc)
  {
    long l = a();
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(l), parambegc);
    parambegc = ajae.a();
    if (parambegc != null) {
      parambegc.a("apollo_game_av.get_av_ctrl_param", paramInt, l);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    begc localbegc;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong)))
    {
      localbegc = (begc)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      if (!paramBoolean) {
        break label62;
      }
      localbegc.a(paramArrayOfByte);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
      return;
      label62:
      localbegc.a(1, "Event");
    }
  }
  
  public void a(byte[] paramArrayOfByte, String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong, begc parambegc)
  {
    long l = a();
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(l), parambegc);
    paramString1 = ajae.a();
    if (paramString1 != null) {
      paramString1.a("apollo_game_av.join_av_room", paramInt1, paramInt2, paramLong, paramString2, paramArrayOfByte, l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     begb
 * JD-Core Version:    0.7.0.1
 */