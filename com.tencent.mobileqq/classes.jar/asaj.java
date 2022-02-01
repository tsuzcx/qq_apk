import android.text.TextUtils;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import mqq.manager.Manager;

public class asaj
  implements Manager
{
  public static long a;
  public static long b;
  public static long c;
  private byte jdField_a_of_type_Byte;
  private int jdField_a_of_type_Int;
  protected NearbyAppInterface a;
  protected EntityManager a;
  private String jdField_a_of_type_JavaLangString;
  
  public asaj(NearbyAppInterface paramNearbyAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramNearbyAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_Byte = 0;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = -2147483648;
  }
  
  public static void a(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!axxb.c())
    {
      axws.a(paramString, "DatingManager.maplng", Long.valueOf(paramLong1));
      axws.a(paramString, "DatingManager.maplat", Long.valueOf(paramLong2));
      axws.a(paramString, "DatingManager.timestamp", Long.valueOf(paramLong3));
      return;
    }
    jdField_a_of_type_Long = paramLong1;
    b = paramLong2;
    c = paramLong3;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asaj
 * JD-Core Version:    0.7.0.1
 */