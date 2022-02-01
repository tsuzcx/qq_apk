import java.util.HashMap;
import java.util.Map;

public class biyo
{
  private static biyo jdField_a_of_type_Biyo;
  long jdField_a_of_type_Long = 1L;
  Map<Long, biyp> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public static biyo a()
  {
    if (jdField_a_of_type_Biyo == null) {
      jdField_a_of_type_Biyo = new biyo();
    }
    return jdField_a_of_type_Biyo;
  }
  
  long a()
  {
    return this.jdField_a_of_type_Long % 1000L + 1L;
  }
  
  public void a(int paramInt, biyp parambiyp)
  {
    long l = a();
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(l), parambiyp);
    parambiyp = alvx.a();
    if (parambiyp != null) {
      parambiyp.a("apollo_game_av.get_av_ctrl_param", paramInt, l);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    biyp localbiyp;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong)))
    {
      localbiyp = (biyp)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      if (!paramBoolean) {
        break label62;
      }
      localbiyp.a(paramArrayOfByte);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
      return;
      label62:
      localbiyp.a(1, "Event");
    }
  }
  
  public void a(byte[] paramArrayOfByte, String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong, biyp parambiyp)
  {
    long l = a();
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(l), parambiyp);
    paramString1 = alvx.a();
    if (paramString1 != null) {
      paramString1.a("apollo_game_av.join_av_room", paramInt1, paramInt2, paramLong, paramString2, paramArrayOfByte, l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biyo
 * JD-Core Version:    0.7.0.1
 */