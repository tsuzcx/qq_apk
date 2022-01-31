import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class behl
{
  private static final behl jdField_a_of_type_Behl = new behl();
  private behm jdField_a_of_type_Behm;
  private Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
  private Map<String, behk> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Map<String, behk> b = new HashMap();
  private Map<String, behj> c = new HashMap();
  private Map<String, String> d = new HashMap();
  private Map<String, String> e = new HashMap();
  
  public static behl a()
  {
    return jdField_a_of_type_Behl;
  }
  
  private void b(behn... paramVarArgs)
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
      if (!((behn)localObject).a()) {}
      for (;;)
      {
        i += 1;
        break;
        this.jdField_a_of_type_JavaUtilMap.putAll(((behn)localObject).a());
        this.b.putAll(((behn)localObject).b());
        this.c.putAll(((behn)localObject).c());
      }
    }
    paramVarArgs = this.c.values().iterator();
    while (paramVarArgs.hasNext())
    {
      localObject = (behj)paramVarArgs.next();
      Iterator localIterator = ((behj)localObject).jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (a(str))
        {
          this.d.put(str, ((behj)localObject).jdField_a_of_type_JavaLangString);
          this.e.put(((behj)localObject).jdField_a_of_type_JavaLangString, str);
        }
      }
    }
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    if (this.jdField_a_of_type_Behm != null) {
      this.jdField_a_of_type_Behm.a();
    }
  }
  
  public behj a(String paramString)
  {
    return (behj)this.c.get(paramString);
  }
  
  public behk a(String paramString)
  {
    return (behk)this.jdField_a_of_type_JavaUtilMap.get(paramString);
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
  
  public void a(String paramString, behk parambehk)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramString, parambehk);
  }
  
  public void a(behn... paramVarArgs)
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
 * Qualified Name:     behl
 * JD-Core Version:    0.7.0.1
 */