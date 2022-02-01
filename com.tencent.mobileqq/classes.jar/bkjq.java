import java.util.HashMap;
import java.util.Map;

public class bkjq
{
  private static bkjq jdField_a_of_type_Bkjq;
  long jdField_a_of_type_Long = 1L;
  Map<Long, bkjr> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public static bkjq a()
  {
    if (jdField_a_of_type_Bkjq == null) {
      jdField_a_of_type_Bkjq = new bkjq();
    }
    return jdField_a_of_type_Bkjq;
  }
  
  long a()
  {
    return this.jdField_a_of_type_Long % 1000L + 1L;
  }
  
  public void a(int paramInt, bkjr parambkjr)
  {
    long l = a();
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(l), parambkjr);
    parambkjr = amwn.a();
    if (parambkjr != null) {
      parambkjr.a("apollo_game_av.get_av_ctrl_param", paramInt, l);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    bkjr localbkjr;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong)))
    {
      localbkjr = (bkjr)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      if (!paramBoolean) {
        break label62;
      }
      localbkjr.a(paramArrayOfByte);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
      return;
      label62:
      localbkjr.a(1, "Event");
    }
  }
  
  public void a(byte[] paramArrayOfByte, String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong, bkjr parambkjr)
  {
    long l = a();
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(l), parambkjr);
    paramString1 = amwn.a();
    if (paramString1 != null) {
      paramString1.a("apollo_game_av.join_av_room", paramInt1, paramInt2, paramLong, paramString2, paramArrayOfByte, l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkjq
 * JD-Core Version:    0.7.0.1
 */