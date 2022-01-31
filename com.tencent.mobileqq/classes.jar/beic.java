import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class beic
{
  private static final beic jdField_a_of_type_Beic = new beic();
  private beid jdField_a_of_type_Beid;
  private Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
  private Map<String, beib> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Map<String, beib> b = new HashMap();
  private Map<String, beia> c = new HashMap();
  private Map<String, String> d = new HashMap();
  private Map<String, String> e = new HashMap();
  
  public static beic a()
  {
    return jdField_a_of_type_Beic;
  }
  
  private void b(beie... paramVarArgs)
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.b.clear();
    this.c.clear();
    this.d.clear();
    this.e.clear();
    int j = paramVarArgs.length;
    int i = 0;
    Object localObject;
    if (i < j)
    {
      localObject = paramVarArgs[i];
      if (!((beie)localObject).a()) {}
      for (;;)
      {
        i += 1;
        break;
        this.jdField_a_of_type_JavaUtilMap.putAll(((beie)localObject).a());
        this.b.putAll(((beie)localObject).b());
        this.c.putAll(((beie)localObject).c());
      }
    }
    paramVarArgs = this.c.values().iterator();
    while (paramVarArgs.hasNext())
    {
      localObject = (beia)paramVarArgs.next();
      Iterator localIterator = ((beia)localObject).jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (a(str))
        {
          this.d.put(str, ((beia)localObject).jdField_a_of_type_JavaLangString);
          this.e.put(((beia)localObject).jdField_a_of_type_JavaLangString, str);
        }
      }
    }
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    if (this.jdField_a_of_type_Beid != null) {
      this.jdField_a_of_type_Beid.a();
    }
  }
  
  public beia a(String paramString)
  {
    return (beia)this.c.get(paramString);
  }
  
  public beib a(String paramString)
  {
    return (beib)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public String a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null)
    {
      paramString = paramString.jdField_a_of_type_JavaUtilList.iterator();
      while (paramString.hasNext())
      {
        String str = (String)paramString.next();
        if (this.b.containsKey(str)) {
          return str;
        }
      }
    }
    return null;
  }
  
  public List<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilMap.keySet());
    localArrayList.addAll(this.b.keySet());
    return localArrayList;
  }
  
  public void a(String paramString, beib parambeib)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramString, parambeib);
  }
  
  public void a(beie... paramVarArgs)
  {
    synchronized (this.jdField_a_of_type_JavaLangBoolean)
    {
      if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
        b(paramVarArgs);
      }
      return;
    }
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilMap.containsKey(paramString);
  }
  
  public String b(String paramString)
  {
    return (String)this.d.get(paramString);
  }
  
  public String c(String paramString)
  {
    return (String)this.e.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beic
 * JD-Core Version:    0.7.0.1
 */