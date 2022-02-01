import java.util.HashMap;
import java.util.Map;

public class bktj
{
  private static bktj jdField_a_of_type_Bktj;
  long jdField_a_of_type_Long = 1L;
  Map<Long, bktk> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public static bktj a()
  {
    if (jdField_a_of_type_Bktj == null) {
      jdField_a_of_type_Bktj = new bktj();
    }
    return jdField_a_of_type_Bktj;
  }
  
  long a()
  {
    return this.jdField_a_of_type_Long % 1000L + 1L;
  }
  
  public void a(int paramInt, bktk parambktk)
  {
    long l = a();
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(l), parambktk);
    parambktk = anbd.a();
    if (parambktk != null) {
      parambktk.a("apollo_game_av.get_av_ctrl_param", paramInt, l);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    bktk localbktk;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong)))
    {
      localbktk = (bktk)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      if (!paramBoolean) {
        break label62;
      }
      localbktk.a(paramArrayOfByte);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
      return;
      label62:
      localbktk.a(1, "Event");
    }
  }
  
  public void a(byte[] paramArrayOfByte, String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong, bktk parambktk)
  {
    long l = a();
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(l), parambktk);
    paramString1 = anbd.a();
    if (paramString1 != null) {
      paramString1.a("apollo_game_av.join_av_room", paramInt1, paramInt2, paramLong, paramString2, paramArrayOfByte, l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bktj
 * JD-Core Version:    0.7.0.1
 */