import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

public class arhn
{
  @SerializedName("enable")
  private int jdField_a_of_type_Int = 0;
  @SerializedName("troopType")
  private long[] jdField_a_of_type_ArrayOfLong = { -1L };
  
  public static arhn a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (arhn)new Gson().fromJson(paramString, arhn.class);
  }
  
  public static boolean a(long paramLong)
  {
    Object localObject = (arhn)aqxe.a().a(653);
    if (((arhn)localObject).jdField_a_of_type_Int == 1)
    {
      localObject = ((arhn)localObject).jdField_a_of_type_ArrayOfLong;
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
      return a(((bfox)paramQQAppInterface.getManager(QQManagerFactory.TROOP_CLASS_CONTROLLER_MANAGER)).a());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arhn
 * JD-Core Version:    0.7.0.1
 */