import java.util.HashMap;
import java.util.Map;

public class bjsj
{
  private static bjsj jdField_a_of_type_Bjsj;
  long jdField_a_of_type_Long = 1L;
  Map<Long, bjsk> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public static bjsj a()
  {
    if (jdField_a_of_type_Bjsj == null) {
      jdField_a_of_type_Bjsj = new bjsj();
    }
    return jdField_a_of_type_Bjsj;
  }
  
  long a()
  {
    return this.jdField_a_of_type_Long % 1000L + 1L;
  }
  
  public void a(int paramInt, bjsk parambjsk)
  {
    long l = a();
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(l), parambjsk);
    parambjsk = ampj.a();
    if (parambjsk != null) {
      parambjsk.a("apollo_game_av.get_av_ctrl_param", paramInt, l);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    bjsk localbjsk;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong)))
    {
      localbjsk = (bjsk)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      if (!paramBoolean) {
        break label62;
      }
      localbjsk.a(paramArrayOfByte);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
      return;
      label62:
      localbjsk.a(1, "Event");
    }
  }
  
  public void a(byte[] paramArrayOfByte, String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong, bjsk parambjsk)
  {
    long l = a();
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(l), parambjsk);
    paramString1 = ampj.a();
    if (paramString1 != null) {
      paramString1.a("apollo_game_av.join_av_room", paramInt1, paramInt2, paramLong, paramString2, paramArrayOfByte, l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjsj
 * JD-Core Version:    0.7.0.1
 */