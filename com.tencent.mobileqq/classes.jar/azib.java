import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopFileData;
import java.util.HashMap;
import java.util.Map;

public class azib
{
  public static Map<Long, azib> a;
  public long a;
  public Map<String, TroopFileData> b = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public azib(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public static azib a(long paramLong)
  {
    try
    {
      azib localazib2 = (azib)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      azib localazib1 = localazib2;
      if (localazib2 == null)
      {
        localazib1 = new azib(paramLong);
        jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), localazib1);
      }
      return localazib1;
    }
    finally {}
  }
  
  public TroopFileData a(QQAppInterface paramQQAppInterface, String paramString)
  {
    TroopFileData localTroopFileData1 = null;
    try
    {
      if (this.b != null) {
        localTroopFileData1 = (TroopFileData)this.b.get(paramString);
      }
      TroopFileData localTroopFileData2 = localTroopFileData1;
      if (localTroopFileData1 == null)
      {
        paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
        localTroopFileData2 = (TroopFileData)paramQQAppInterface.a(TroopFileData.class, paramString);
        paramQQAppInterface.a();
      }
      return localTroopFileData2;
    }
    finally {}
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, TroopFileData paramTroopFileData)
  {
    try
    {
      if (this.b != null) {
        this.b.put(paramTroopFileData.fileUrl, paramTroopFileData);
      }
      paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      paramQQAppInterface.a(paramTroopFileData);
      paramQQAppInterface.a();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azib
 * JD-Core Version:    0.7.0.1
 */