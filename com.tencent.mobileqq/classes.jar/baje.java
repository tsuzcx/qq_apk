import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopFileData;
import java.util.HashMap;
import java.util.Map;

public class baje
{
  public static Map<Long, baje> a;
  public long a;
  public Map<String, TroopFileData> b = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public baje(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public static baje a(long paramLong)
  {
    try
    {
      baje localbaje2 = (baje)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      baje localbaje1 = localbaje2;
      if (localbaje2 == null)
      {
        localbaje1 = new baje(paramLong);
        jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), localbaje1);
      }
      return localbaje1;
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
 * Qualified Name:     baje
 * JD-Core Version:    0.7.0.1
 */