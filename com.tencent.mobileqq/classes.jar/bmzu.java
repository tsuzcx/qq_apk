import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.takevideo.tag.TagItemEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;

public class bmzu
{
  private final int jdField_a_of_type_Int = 20;
  private awbw jdField_a_of_type_Awbw;
  private bmkb jdField_a_of_type_Bmkb;
  private final bmzx jdField_a_of_type_Bmzx;
  private String jdField_a_of_type_JavaLangString = "";
  private List<xjv> jdField_a_of_type_JavaUtilList = new ArrayList();
  private xjv jdField_a_of_type_Xjv;
  private int b = 1;
  
  public bmzu(bmzx parambmzx, awbw paramawbw)
  {
    this.jdField_a_of_type_Bmzx = parambmzx;
    this.jdField_a_of_type_Awbw = paramawbw;
  }
  
  public static List<xjv> a(awbw paramawbw)
  {
    Object localObject = a(paramawbw, TagItemEntry.class, TagItemEntry.class.getSimpleName(), null, null);
    paramawbw = (awbw)localObject;
    if (localObject == null) {
      paramawbw = new ArrayList();
    }
    localObject = new ArrayList();
    paramawbw = paramawbw.iterator();
    while (paramawbw.hasNext()) {
      ((List)localObject).add(new xjv((TagItemEntry)paramawbw.next()));
    }
    return localObject;
  }
  
  public static List<? extends awbv> a(awbw paramawbw, Class<? extends awbv> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramawbw.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public static void a(awbw paramawbw, List<xjv> paramList)
  {
    try
    {
      Object localObject = a(paramawbw, TagItemEntry.class, TagItemEntry.class.getSimpleName(), null, null);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          TagItemEntry localTagItemEntry = (TagItemEntry)((Iterator)localObject).next();
          localTagItemEntry.setStatus(1001);
          paramawbw.b(localTagItemEntry);
        }
      }
    }
    finally
    {
      paramawbw.a().b();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramawbw.b(((xjv)paramList.next()).a());
    }
    paramawbw.a().c();
    paramawbw.a().b();
  }
  
  public List<xjv> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  @Nullable
  public xjv a()
  {
    return this.jdField_a_of_type_Xjv;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Bmkb = null;
    this.jdField_a_of_type_JavaLangString = "";
    this.b = 1;
    this.jdField_a_of_type_Xjv = null;
  }
  
  public void a(@Nonnull bmkb parambmkb)
  {
    wsv.a("EditVideoTagPresenter", "%s refresh data, behavior:%s", this, parambmkb);
    this.jdField_a_of_type_Bmkb = parambmkb;
    if (parambmkb.jdField_a_of_type_Boolean) {}
    for (parambmkb = new vbv(parambmkb.jdField_a_of_type_Int, parambmkb.jdField_a_of_type_Long, "", 20);; parambmkb = new vbv("", 20))
    {
      ung.a().a(parambmkb, new bmzv(this));
      return;
    }
  }
  
  public void a(List<xjv> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(xjv paramxjv)
  {
    this.jdField_a_of_type_Xjv = paramxjv;
  }
  
  public boolean a()
  {
    return this.b == 1;
  }
  
  public boolean a(bmkb parambmkb)
  {
    if (this.jdField_a_of_type_Bmkb != null) {
      if (this.jdField_a_of_type_Bmkb.equals(parambmkb)) {}
    }
    while (parambmkb != null)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public void b(@Nonnull bmkb parambmkb)
  {
    wsv.a("EditVideoTagPresenter", "%s loadMore data, behavior:%s", this, parambmkb);
    this.jdField_a_of_type_Bmkb = parambmkb;
    if (parambmkb.jdField_a_of_type_Boolean) {}
    for (parambmkb = new vbv(parambmkb.jdField_a_of_type_Int, parambmkb.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, 20);; parambmkb = new vbv(this.jdField_a_of_type_JavaLangString, 20))
    {
      ung.a().a(parambmkb, new bmzw(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmzu
 * JD-Core Version:    0.7.0.1
 */