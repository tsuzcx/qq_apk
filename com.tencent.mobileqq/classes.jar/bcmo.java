import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopFileData;
import java.util.HashMap;
import java.util.Map;

public class bcmo
{
  public static Map<Long, bcmo> a;
  public long a;
  public Map<String, TroopFileData> b = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public bcmo(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public static bcmo a(long paramLong)
  {
    try
    {
      bcmo localbcmo2 = (bcmo)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      bcmo localbcmo1 = localbcmo2;
      if (localbcmo2 == null)
      {
        localbcmo1 = new bcmo(paramLong);
        jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), localbcmo1);
      }
      return localbcmo1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcmo
 * JD-Core Version:    0.7.0.1
 */