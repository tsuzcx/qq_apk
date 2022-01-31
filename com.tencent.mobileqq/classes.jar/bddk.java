import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class bddk
{
  private static final bddk jdField_a_of_type_Bddk = new bddk();
  private bddl jdField_a_of_type_Bddl;
  private Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
  private Map<String, bddj> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Map<String, bddj> b = new HashMap();
  private Map<String, bddi> c = new HashMap();
  private Map<String, String> d = new HashMap();
  private Map<String, String> e = new HashMap();
  
  public static bddk a()
  {
    return jdField_a_of_type_Bddk;
  }
  
  private void b(bddm... paramVarArgs)
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
      if (!((bddm)localObject).a()) {}
      for (;;)
      {
        i += 1;
        break;
        this.jdField_a_of_type_JavaUtilMap.putAll(((bddm)localObject).a());
        this.b.putAll(((bddm)localObject).b());
        this.c.putAll(((bddm)localObject).c());
      }
    }
    paramVarArgs = this.c.values().iterator();
    while (paramVarArgs.hasNext())
    {
      localObject = (bddi)paramVarArgs.next();
      Iterator localIterator = ((bddi)localObject).jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (a(str))
        {
          this.d.put(str, ((bddi)localObject).jdField_a_of_type_JavaLangString);
          this.e.put(((bddi)localObject).jdField_a_of_type_JavaLangString, str);
        }
      }
    }
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    if (this.jdField_a_of_type_Bddl != null) {
      this.jdField_a_of_type_Bddl.a();
    }
  }
  
  public bddi a(String paramString)
  {
    return (bddi)this.c.get(paramString);
  }
  
  public bddj a(String paramString)
  {
    return (bddj)this.jdField_a_of_type_JavaUtilMap.get(paramString);
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
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilMap.keySet());
    return localArrayList;
  }
  
  public void a(String paramString, bddj parambddj)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramString, parambddj);
  }
  
  public void a(bddm... paramVarArgs)
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
 * Qualified Name:     bddk
 * JD-Core Version:    0.7.0.1
 */