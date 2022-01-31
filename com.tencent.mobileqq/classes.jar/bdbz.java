import java.util.HashMap;
import java.util.Map;

public class bdbz
{
  private static bdbz jdField_a_of_type_Bdbz;
  long jdField_a_of_type_Long = 1L;
  Map<Long, bdca> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public static bdbz a()
  {
    if (jdField_a_of_type_Bdbz == null) {
      jdField_a_of_type_Bdbz = new bdbz();
    }
    return jdField_a_of_type_Bdbz;
  }
  
  long a()
  {
    return this.jdField_a_of_type_Long % 1000L + 1L;
  }
  
  public void a(int paramInt, bdca parambdca)
  {
    long l = a();
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(l), parambdca);
    parambdca = aing.a();
    if (parambdca != null) {
      parambdca.a("apollo_game_av.get_av_ctrl_param", paramInt, l);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    bdca localbdca;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong)))
    {
      localbdca = (bdca)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      if (!paramBoolean) {
        break label62;
      }
      localbdca.a(paramArrayOfByte);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
      return;
      label62:
      localbdca.a(1, "Event");
    }
  }
  
  public void a(byte[] paramArrayOfByte, String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong, bdca parambdca)
  {
    long l = a();
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(l), parambdca);
    paramString1 = aing.a();
    if (paramString1 != null) {
      paramString1.a("apollo_game_av.join_av_room", paramInt1, paramInt2, paramLong, paramString2, paramArrayOfByte, l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bdbz
 * JD-Core Version:    0.7.0.1
 */