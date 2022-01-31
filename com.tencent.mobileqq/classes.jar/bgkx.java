import java.util.HashMap;
import java.util.Map;

public class bgkx
{
  private static bgkx jdField_a_of_type_Bgkx;
  long jdField_a_of_type_Long = 1L;
  Map<Long, bgky> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public static bgkx a()
  {
    if (jdField_a_of_type_Bgkx == null) {
      jdField_a_of_type_Bgkx = new bgkx();
    }
    return jdField_a_of_type_Bgkx;
  }
  
  long a()
  {
    return this.jdField_a_of_type_Long % 1000L + 1L;
  }
  
  public void a(int paramInt, bgky parambgky)
  {
    long l = a();
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(l), parambgky);
    parambgky = akwd.a();
    if (parambgky != null) {
      parambgky.a("apollo_game_av.get_av_ctrl_param", paramInt, l);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    bgky localbgky;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong)))
    {
      localbgky = (bgky)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      if (!paramBoolean) {
        break label62;
      }
      localbgky.a(paramArrayOfByte);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
      return;
      label62:
      localbgky.a(1, "Event");
    }
  }
  
  public void a(byte[] paramArrayOfByte, String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong, bgky parambgky)
  {
    long l = a();
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(l), parambgky);
    paramString1 = akwd.a();
    if (paramString1 != null) {
      paramString1.a("apollo_game_av.join_av_room", paramInt1, paramInt2, paramLong, paramString2, paramArrayOfByte, l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgkx
 * JD-Core Version:    0.7.0.1
 */