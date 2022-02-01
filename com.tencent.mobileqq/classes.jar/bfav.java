import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TroopFileData;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.HashMap;
import java.util.Map;

public class bfav
{
  public static Map<Long, bfav> a;
  public long a;
  public Map<String, TroopFileData> b = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public bfav(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public static bfav a(long paramLong)
  {
    try
    {
      bfav localbfav2 = (bfav)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      bfav localbfav1 = localbfav2;
      if (localbfav2 == null)
      {
        localbfav1 = new bfav(paramLong);
        jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), localbfav1);
      }
      return localbfav1;
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
        localTroopFileData2 = (TroopFileData)paramQQAppInterface.find(TroopFileData.class, paramString);
        paramQQAppInterface.close();
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
      paramQQAppInterface.persist(paramTroopFileData);
      paramQQAppInterface.close();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfav
 * JD-Core Version:    0.7.0.1
 */