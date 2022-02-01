import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.takevideo.tag.TagItemEntry;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;

public class bpvm
{
  private final int jdField_a_of_type_Int = 20;
  private bpft jdField_a_of_type_Bpft;
  private final bpvp jdField_a_of_type_Bpvp;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private String jdField_a_of_type_JavaLangString = "";
  private List<zhp> jdField_a_of_type_JavaUtilList = new ArrayList();
  private zhp jdField_a_of_type_Zhp;
  private int b = 1;
  
  public bpvm(bpvp parambpvp, EntityManager paramEntityManager)
  {
    this.jdField_a_of_type_Bpvp = parambpvp;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramEntityManager;
  }
  
  public static List<zhp> a(EntityManager paramEntityManager)
  {
    Object localObject = a(paramEntityManager, TagItemEntry.class, TagItemEntry.class.getSimpleName(), null, null);
    paramEntityManager = (EntityManager)localObject;
    if (localObject == null) {
      paramEntityManager = new ArrayList();
    }
    localObject = new ArrayList();
    paramEntityManager = paramEntityManager.iterator();
    while (paramEntityManager.hasNext()) {
      ((List)localObject).add(new zhp((TagItemEntry)paramEntityManager.next()));
    }
    return localObject;
  }
  
  public static List<? extends Entity> a(EntityManager paramEntityManager, Class<? extends Entity> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.query(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public static void a(EntityManager paramEntityManager, List<zhp> paramList)
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
      paramEntityManager.persistOrReplace(((zhp)paramList.next()).a());
    }
    paramEntityManager.getTransaction().commit();
    paramEntityManager.getTransaction().end();
  }
  
  public List<zhp> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  @Nullable
  public zhp a()
  {
    return this.jdField_a_of_type_Zhp;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Bpft = null;
    this.jdField_a_of_type_JavaLangString = "";
    this.b = 1;
    this.jdField_a_of_type_Zhp = null;
  }
  
  public void a(@Nonnull bpft parambpft)
  {
    yqp.a("EditVideoTagPresenter", "%s refresh data, behavior:%s", this, parambpft);
    this.jdField_a_of_type_Bpft = parambpft;
    if (parambpft.jdField_a_of_type_Boolean) {}
    for (parambpft = new wzq(parambpft.jdField_a_of_type_Int, parambpft.jdField_a_of_type_Long, "", 20);; parambpft = new wzq("", 20))
    {
      wlb.a().a(parambpft, new bpvn(this));
      return;
    }
  }
  
  public void a(List<zhp> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(zhp paramzhp)
  {
    this.jdField_a_of_type_Zhp = paramzhp;
  }
  
  public boolean a()
  {
    return this.b == 1;
  }
  
  public boolean a(bpft parambpft)
  {
    if (this.jdField_a_of_type_Bpft != null) {
      if (this.jdField_a_of_type_Bpft.equals(parambpft)) {}
    }
    while (parambpft != null)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public void b(@Nonnull bpft parambpft)
  {
    yqp.a("EditVideoTagPresenter", "%s loadMore data, behavior:%s", this, parambpft);
    this.jdField_a_of_type_Bpft = parambpft;
    if (parambpft.jdField_a_of_type_Boolean) {}
    for (parambpft = new wzq(parambpft.jdField_a_of_type_Int, parambpft.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, 20);; parambpft = new wzq(this.jdField_a_of_type_JavaLangString, 20))
    {
      wlb.a().a(parambpft, new bpvo(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpvm
 * JD-Core Version:    0.7.0.1
 */