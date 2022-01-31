import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.takevideo.tag.TagItemEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;

public class bknt
{
  private final int jdField_a_of_type_Int = 20;
  private aukn jdField_a_of_type_Aukn;
  private bjya jdField_a_of_type_Bjya;
  private final bknw jdField_a_of_type_Bknw;
  private String jdField_a_of_type_JavaLangString = "";
  private List<vvg> jdField_a_of_type_JavaUtilList = new ArrayList();
  private vvg jdField_a_of_type_Vvg;
  private int b = 1;
  
  public bknt(bknw parambknw, aukn paramaukn)
  {
    this.jdField_a_of_type_Bknw = parambknw;
    this.jdField_a_of_type_Aukn = paramaukn;
  }
  
  public static List<vvg> a(aukn paramaukn)
  {
    Object localObject = a(paramaukn, TagItemEntry.class, TagItemEntry.class.getSimpleName(), null, null);
    paramaukn = (aukn)localObject;
    if (localObject == null) {
      paramaukn = new ArrayList();
    }
    localObject = new ArrayList();
    paramaukn = paramaukn.iterator();
    while (paramaukn.hasNext()) {
      ((List)localObject).add(new vvg((TagItemEntry)paramaukn.next()));
    }
    return localObject;
  }
  
  public static List<? extends aukm> a(aukn paramaukn, Class<? extends aukm> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramaukn.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public static void a(aukn paramaukn, List<vvg> paramList)
  {
    try
    {
      Object localObject = a(paramaukn, TagItemEntry.class, TagItemEntry.class.getSimpleName(), null, null);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          TagItemEntry localTagItemEntry = (TagItemEntry)((Iterator)localObject).next();
          localTagItemEntry.setStatus(1001);
          paramaukn.b(localTagItemEntry);
        }
      }
    }
    finally
    {
      paramaukn.a().b();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramaukn.b(((vvg)paramList.next()).a());
    }
    paramaukn.a().c();
    paramaukn.a().b();
  }
  
  public List<vvg> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  @Nullable
  public vvg a()
  {
    return this.jdField_a_of_type_Vvg;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Bjya = null;
    this.jdField_a_of_type_JavaLangString = "";
    this.b = 1;
    this.jdField_a_of_type_Vvg = null;
  }
  
  public void a(@Nonnull bjya parambjya)
  {
    veg.a("EditVideoTagPresenter", "%s refresh data, behavior:%s", this, parambjya);
    this.jdField_a_of_type_Bjya = parambjya;
    if (parambjya.jdField_a_of_type_Boolean) {}
    for (parambjya = new tng(parambjya.jdField_a_of_type_Int, parambjya.jdField_a_of_type_Long, "", 20);; parambjya = new tng("", 20))
    {
      syr.a().a(parambjya, new bknu(this));
      return;
    }
  }
  
  public void a(List<vvg> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(vvg paramvvg)
  {
    this.jdField_a_of_type_Vvg = paramvvg;
  }
  
  public boolean a()
  {
    return this.b == 1;
  }
  
  public boolean a(bjya parambjya)
  {
    if (this.jdField_a_of_type_Bjya != null) {
      if (this.jdField_a_of_type_Bjya.equals(parambjya)) {}
    }
    while (parambjya != null)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public void b(@Nonnull bjya parambjya)
  {
    veg.a("EditVideoTagPresenter", "%s loadMore data, behavior:%s", this, parambjya);
    this.jdField_a_of_type_Bjya = parambjya;
    if (parambjya.jdField_a_of_type_Boolean) {}
    for (parambjya = new tng(parambjya.jdField_a_of_type_Int, parambjya.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, 20);; parambjya = new tng(this.jdField_a_of_type_JavaLangString, 20))
    {
      syr.a().a(parambjya, new bknv(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bknt
 * JD-Core Version:    0.7.0.1
 */