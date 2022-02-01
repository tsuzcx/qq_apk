import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.app.QQAppInterface;

public class arkn
{
  @SerializedName("enable")
  private int jdField_a_of_type_Int = 0;
  @SerializedName("troopType")
  private long[] jdField_a_of_type_ArrayOfLong = { -1L };
  
  public static arkn a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (arkn)new Gson().fromJson(paramString, arkn.class);
  }
  
  public static boolean a(long paramLong)
  {
    Object localObject = (arkn)aran.a().a(653);
    if (((arkn)localObject).jdField_a_of_type_Int == 1)
    {
      localObject = ((arkn)localObject).jdField_a_of_type_ArrayOfLong;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        long l = localObject[i];
        if (l == -1L) {
          return true;
        }
        if (l == paramLong) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null) {
      return a(((bfyj)paramQQAppInterface.getManager(289)).a());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arkn
 * JD-Core Version:    0.7.0.1
 */