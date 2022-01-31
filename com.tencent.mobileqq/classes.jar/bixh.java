import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.takevideo.tag.TagItemEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;

public class bixh
{
  private final int jdField_a_of_type_Int = 20;
  private atmp jdField_a_of_type_Atmp;
  private bihf jdField_a_of_type_Bihf;
  private final bixk jdField_a_of_type_Bixk;
  private String jdField_a_of_type_JavaLangString = "";
  private List<vik> jdField_a_of_type_JavaUtilList = new ArrayList();
  private vik jdField_a_of_type_Vik;
  private int b = 1;
  
  public bixh(bixk parambixk, atmp paramatmp)
  {
    this.jdField_a_of_type_Bixk = parambixk;
    this.jdField_a_of_type_Atmp = paramatmp;
  }
  
  public static List<vik> a(atmp paramatmp)
  {
    Object localObject = a(paramatmp, TagItemEntry.class, TagItemEntry.class.getSimpleName(), null, null);
    paramatmp = (atmp)localObject;
    if (localObject == null) {
      paramatmp = new ArrayList();
    }
    localObject = new ArrayList();
    paramatmp = paramatmp.iterator();
    while (paramatmp.hasNext()) {
      ((List)localObject).add(new vik((TagItemEntry)paramatmp.next()));
    }
    return localObject;
  }
  
  public static List<? extends atmo> a(atmp paramatmp, Class<? extends atmo> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramatmp.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public static void a(atmp paramatmp, List<vik> paramList)
  {
    try
    {
      Object localObject = a(paramatmp, TagItemEntry.class, TagItemEntry.class.getSimpleName(), null, null);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          TagItemEntry localTagItemEntry = (TagItemEntry)((Iterator)localObject).next();
          localTagItemEntry.setStatus(1001);
          paramatmp.b(localTagItemEntry);
        }
      }
    }
    finally
    {
      paramatmp.a().b();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramatmp.b(((vik)paramList.next()).a());
    }
    paramatmp.a().c();
    paramatmp.a().b();
  }
  
  public List<vik> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  @Nullable
  public vik a()
  {
    return this.jdField_a_of_type_Vik;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Bihf = null;
    this.jdField_a_of_type_JavaLangString = "";
    this.b = 1;
    this.jdField_a_of_type_Vik = null;
  }
  
  public void a(@Nonnull bihf parambihf)
  {
    urk.a("EditVideoTagPresenter", "%s refresh data, behavior:%s", this, parambihf);
    this.jdField_a_of_type_Bihf = parambihf;
    if (parambihf.jdField_a_of_type_Boolean) {}
    for (parambihf = new tak(parambihf.jdField_a_of_type_Int, parambihf.jdField_a_of_type_Long, "", 20);; parambihf = new tak("", 20))
    {
      slv.a().a(parambihf, new bixi(this));
      return;
    }
  }
  
  public void a(List<vik> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(vik paramvik)
  {
    this.jdField_a_of_type_Vik = paramvik;
  }
  
  public boolean a()
  {
    return this.b == 1;
  }
  
  public boolean a(bihf parambihf)
  {
    if (this.jdField_a_of_type_Bihf != null) {
      if (this.jdField_a_of_type_Bihf.equals(parambihf)) {}
    }
    while (parambihf != null)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public void b(@Nonnull bihf parambihf)
  {
    urk.a("EditVideoTagPresenter", "%s loadMore data, behavior:%s", this, parambihf);
    this.jdField_a_of_type_Bihf = parambihf;
    if (parambihf.jdField_a_of_type_Boolean) {}
    for (parambihf = new tak(parambihf.jdField_a_of_type_Int, parambihf.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, 20);; parambihf = new tak(this.jdField_a_of_type_JavaLangString, 20))
    {
      slv.a().a(parambihf, new bixj(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bixh
 * JD-Core Version:    0.7.0.1
 */