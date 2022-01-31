import java.util.HashMap;
import java.util.Map;

public class bggq
{
  private static bggq jdField_a_of_type_Bggq;
  long jdField_a_of_type_Long = 1L;
  Map<Long, bggr> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public static bggq a()
  {
    if (jdField_a_of_type_Bggq == null) {
      jdField_a_of_type_Bggq = new bggq();
    }
    return jdField_a_of_type_Bggq;
  }
  
  long a()
  {
    return this.jdField_a_of_type_Long % 1000L + 1L;
  }
  
  public void a(int paramInt, bggr parambggr)
  {
    long l = a();
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(l), parambggr);
    parambggr = akro.a();
    if (parambggr != null) {
      parambggr.a("apollo_game_av.get_av_ctrl_param", paramInt, l);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    bggr localbggr;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong)))
    {
      localbggr = (bggr)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      if (!paramBoolean) {
        break label62;
      }
      localbggr.a(paramArrayOfByte);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
      return;
      label62:
      localbggr.a(1, "Event");
    }
  }
  
  public void a(byte[] paramArrayOfByte, String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong, bggr parambggr)
  {
    long l = a();
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(l), parambggr);
    paramString1 = akro.a();
    if (paramString1 != null) {
      paramString1.a("apollo_game_av.join_av_room", paramInt1, paramInt2, paramLong, paramString2, paramArrayOfByte, l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bggq
 * JD-Core Version:    0.7.0.1
 */