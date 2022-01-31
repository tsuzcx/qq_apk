import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.takevideo.tag.TagItemEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;

public class bneg
{
  private final int jdField_a_of_type_Int = 20;
  private awgf jdField_a_of_type_Awgf;
  private bmon jdField_a_of_type_Bmon;
  private final bnej jdField_a_of_type_Bnej;
  private String jdField_a_of_type_JavaLangString = "";
  private List<xoe> jdField_a_of_type_JavaUtilList = new ArrayList();
  private xoe jdField_a_of_type_Xoe;
  private int b = 1;
  
  public bneg(bnej parambnej, awgf paramawgf)
  {
    this.jdField_a_of_type_Bnej = parambnej;
    this.jdField_a_of_type_Awgf = paramawgf;
  }
  
  public static List<xoe> a(awgf paramawgf)
  {
    Object localObject = a(paramawgf, TagItemEntry.class, TagItemEntry.class.getSimpleName(), null, null);
    paramawgf = (awgf)localObject;
    if (localObject == null) {
      paramawgf = new ArrayList();
    }
    localObject = new ArrayList();
    paramawgf = paramawgf.iterator();
    while (paramawgf.hasNext()) {
      ((List)localObject).add(new xoe((TagItemEntry)paramawgf.next()));
    }
    return localObject;
  }
  
  public static List<? extends awge> a(awgf paramawgf, Class<? extends awge> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramawgf.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public static void a(awgf paramawgf, List<xoe> paramList)
  {
    try
    {
      Object localObject = a(paramawgf, TagItemEntry.class, TagItemEntry.class.getSimpleName(), null, null);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          TagItemEntry localTagItemEntry = (TagItemEntry)((Iterator)localObject).next();
          localTagItemEntry.setStatus(1001);
          paramawgf.b(localTagItemEntry);
        }
      }
    }
    finally
    {
      paramawgf.a().b();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramawgf.b(((xoe)paramList.next()).a());
    }
    paramawgf.a().c();
    paramawgf.a().b();
  }
  
  public List<xoe> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  @Nullable
  public xoe a()
  {
    return this.jdField_a_of_type_Xoe;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Bmon = null;
    this.jdField_a_of_type_JavaLangString = "";
    this.b = 1;
    this.jdField_a_of_type_Xoe = null;
  }
  
  public void a(@Nonnull bmon parambmon)
  {
    wxe.a("EditVideoTagPresenter", "%s refresh data, behavior:%s", this, parambmon);
    this.jdField_a_of_type_Bmon = parambmon;
    if (parambmon.jdField_a_of_type_Boolean) {}
    for (parambmon = new vge(parambmon.jdField_a_of_type_Int, parambmon.jdField_a_of_type_Long, "", 20);; parambmon = new vge("", 20))
    {
      urp.a().a(parambmon, new bneh(this));
      return;
    }
  }
  
  public void a(List<xoe> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(xoe paramxoe)
  {
    this.jdField_a_of_type_Xoe = paramxoe;
  }
  
  public boolean a()
  {
    return this.b == 1;
  }
  
  public boolean a(bmon parambmon)
  {
    if (this.jdField_a_of_type_Bmon != null) {
      if (this.jdField_a_of_type_Bmon.equals(parambmon)) {}
    }
    while (parambmon != null)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public void b(@Nonnull bmon parambmon)
  {
    wxe.a("EditVideoTagPresenter", "%s loadMore data, behavior:%s", this, parambmon);
    this.jdField_a_of_type_Bmon = parambmon;
    if (parambmon.jdField_a_of_type_Boolean) {}
    for (parambmon = new vge(parambmon.jdField_a_of_type_Int, parambmon.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, 20);; parambmon = new vge(this.jdField_a_of_type_JavaLangString, 20))
    {
      urp.a().a(parambmon, new bnei(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bneg
 * JD-Core Version:    0.7.0.1
 */