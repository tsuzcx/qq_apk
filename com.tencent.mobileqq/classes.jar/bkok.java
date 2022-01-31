import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.takevideo.tag.TagItemEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;

public class bkok
{
  private final int jdField_a_of_type_Int = 20;
  private aukp jdField_a_of_type_Aukp;
  private bjyr jdField_a_of_type_Bjyr;
  private final bkon jdField_a_of_type_Bkon;
  private String jdField_a_of_type_JavaLangString = "";
  private List<vvd> jdField_a_of_type_JavaUtilList = new ArrayList();
  private vvd jdField_a_of_type_Vvd;
  private int b = 1;
  
  public bkok(bkon parambkon, aukp paramaukp)
  {
    this.jdField_a_of_type_Bkon = parambkon;
    this.jdField_a_of_type_Aukp = paramaukp;
  }
  
  public static List<vvd> a(aukp paramaukp)
  {
    Object localObject = a(paramaukp, TagItemEntry.class, TagItemEntry.class.getSimpleName(), null, null);
    paramaukp = (aukp)localObject;
    if (localObject == null) {
      paramaukp = new ArrayList();
    }
    localObject = new ArrayList();
    paramaukp = paramaukp.iterator();
    while (paramaukp.hasNext()) {
      ((List)localObject).add(new vvd((TagItemEntry)paramaukp.next()));
    }
    return localObject;
  }
  
  public static List<? extends auko> a(aukp paramaukp, Class<? extends auko> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramaukp.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public static void a(aukp paramaukp, List<vvd> paramList)
  {
    try
    {
      Object localObject = a(paramaukp, TagItemEntry.class, TagItemEntry.class.getSimpleName(), null, null);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          TagItemEntry localTagItemEntry = (TagItemEntry)((Iterator)localObject).next();
          localTagItemEntry.setStatus(1001);
          paramaukp.b(localTagItemEntry);
        }
      }
    }
    finally
    {
      paramaukp.a().b();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramaukp.b(((vvd)paramList.next()).a());
    }
    paramaukp.a().c();
    paramaukp.a().b();
  }
  
  public List<vvd> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  @Nullable
  public vvd a()
  {
    return this.jdField_a_of_type_Vvd;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Bjyr = null;
    this.jdField_a_of_type_JavaLangString = "";
    this.b = 1;
    this.jdField_a_of_type_Vvd = null;
  }
  
  public void a(@Nonnull bjyr parambjyr)
  {
    ved.a("EditVideoTagPresenter", "%s refresh data, behavior:%s", this, parambjyr);
    this.jdField_a_of_type_Bjyr = parambjyr;
    if (parambjyr.jdField_a_of_type_Boolean) {}
    for (parambjyr = new tnd(parambjyr.jdField_a_of_type_Int, parambjyr.jdField_a_of_type_Long, "", 20);; parambjyr = new tnd("", 20))
    {
      syo.a().a(parambjyr, new bkol(this));
      return;
    }
  }
  
  public void a(List<vvd> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(vvd paramvvd)
  {
    this.jdField_a_of_type_Vvd = paramvvd;
  }
  
  public boolean a()
  {
    return this.b == 1;
  }
  
  public boolean a(bjyr parambjyr)
  {
    if (this.jdField_a_of_type_Bjyr != null) {
      if (this.jdField_a_of_type_Bjyr.equals(parambjyr)) {}
    }
    while (parambjyr != null)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public void b(@Nonnull bjyr parambjyr)
  {
    ved.a("EditVideoTagPresenter", "%s loadMore data, behavior:%s", this, parambjyr);
    this.jdField_a_of_type_Bjyr = parambjyr;
    if (parambjyr.jdField_a_of_type_Boolean) {}
    for (parambjyr = new tnd(parambjyr.jdField_a_of_type_Int, parambjyr.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, 20);; parambjyr = new tnd(this.jdField_a_of_type_JavaLangString, 20))
    {
      syo.a().a(parambjyr, new bkom(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkok
 * JD-Core Version:    0.7.0.1
 */