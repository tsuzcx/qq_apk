import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.takevideo.tag.TagItemEntry;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;

public class bqxh
{
  private final int jdField_a_of_type_Int = 20;
  private bqho jdField_a_of_type_Bqho;
  private final bqxk jdField_a_of_type_Bqxk;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private String jdField_a_of_type_JavaLangString = "";
  private List<zlk> jdField_a_of_type_JavaUtilList = new ArrayList();
  private zlk jdField_a_of_type_Zlk;
  private int b = 1;
  
  public bqxh(bqxk parambqxk, EntityManager paramEntityManager)
  {
    this.jdField_a_of_type_Bqxk = parambqxk;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramEntityManager;
  }
  
  public static List<zlk> a(EntityManager paramEntityManager)
  {
    Object localObject = a(paramEntityManager, TagItemEntry.class, TagItemEntry.class.getSimpleName(), null, null);
    paramEntityManager = (EntityManager)localObject;
    if (localObject == null) {
      paramEntityManager = new ArrayList();
    }
    localObject = new ArrayList();
    paramEntityManager = paramEntityManager.iterator();
    while (paramEntityManager.hasNext()) {
      ((List)localObject).add(new zlk((TagItemEntry)paramEntityManager.next()));
    }
    return localObject;
  }
  
  public static List<? extends Entity> a(EntityManager paramEntityManager, Class<? extends Entity> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.query(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public static void a(EntityManager paramEntityManager, List<zlk> paramList)
  {
    try
    {
      Object localObject = a(paramEntityManager, TagItemEntry.class, TagItemEntry.class.getSimpleName(), null, null);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          TagItemEntry localTagItemEntry = (TagItemEntry)((Iterator)localObject).next();
          localTagItemEntry.setStatus(1001);
          paramEntityManager.remove(localTagItemEntry);
        }
      }
    }
    finally
    {
      paramEntityManager.getTransaction().end();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramEntityManager.persistOrReplace(((zlk)paramList.next()).a());
    }
    paramEntityManager.getTransaction().commit();
    paramEntityManager.getTransaction().end();
  }
  
  public List<zlk> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  @Nullable
  public zlk a()
  {
    return this.jdField_a_of_type_Zlk;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Bqho = null;
    this.jdField_a_of_type_JavaLangString = "";
    this.b = 1;
    this.jdField_a_of_type_Zlk = null;
  }
  
  public void a(@Nonnull bqho parambqho)
  {
    yuk.a("EditVideoTagPresenter", "%s refresh data, behavior:%s", this, parambqho);
    this.jdField_a_of_type_Bqho = parambqho;
    if (parambqho.jdField_a_of_type_Boolean) {}
    for (parambqho = new xdl(parambqho.jdField_a_of_type_Int, parambqho.jdField_a_of_type_Long, "", 20);; parambqho = new xdl("", 20))
    {
      wow.a().a(parambqho, new bqxi(this));
      return;
    }
  }
  
  public void a(List<zlk> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(zlk paramzlk)
  {
    this.jdField_a_of_type_Zlk = paramzlk;
  }
  
  public boolean a()
  {
    return this.b == 1;
  }
  
  public boolean a(bqho parambqho)
  {
    if (this.jdField_a_of_type_Bqho != null) {
      if (this.jdField_a_of_type_Bqho.equals(parambqho)) {}
    }
    while (parambqho != null)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public void b(@Nonnull bqho parambqho)
  {
    yuk.a("EditVideoTagPresenter", "%s loadMore data, behavior:%s", this, parambqho);
    this.jdField_a_of_type_Bqho = parambqho;
    if (parambqho.jdField_a_of_type_Boolean) {}
    for (parambqho = new xdl(parambqho.jdField_a_of_type_Int, parambqho.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, 20);; parambqho = new xdl(this.jdField_a_of_type_JavaLangString, 20))
    {
      wow.a().a(parambqho, new bqxj(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqxh
 * JD-Core Version:    0.7.0.1
 */