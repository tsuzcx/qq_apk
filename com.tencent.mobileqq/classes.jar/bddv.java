import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.open.agent.datamodel.Friend;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bddv
{
  protected static bddv a;
  protected static byte[] a;
  public int a;
  protected List<bddw> a;
  public int b;
  protected List<Friend> b;
  protected List<String> c = new ArrayList(20);
  
  static
  {
    jdField_a_of_type_ArrayOfByte = new byte[1];
  }
  
  protected bddv()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(20);
    this.jdField_b_of_type_JavaUtilList = new ArrayList(5);
  }
  
  public static bddv a()
  {
    if (jdField_a_of_type_Bddv == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Bddv == null) {
        jdField_a_of_type_Bddv = new bddv();
      }
      return jdField_a_of_type_Bddv;
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_JavaUtilList.size();
  }
  
  public int a(int paramInt)
  {
    List localList = ((bddw)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Friend a(int paramInt)
  {
    return (Friend)this.jdField_b_of_type_JavaUtilList.get(paramInt);
  }
  
  public Friend a(String paramString)
  {
    Friend localFriend;
    do
    {
      Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
      Iterator localIterator2;
      while (!localIterator2.hasNext())
      {
        if (!localIterator1.hasNext()) {
          break;
        }
        localIterator2 = ((bddw)localIterator1.next()).jdField_a_of_type_JavaUtilList.iterator();
      }
      localFriend = (Friend)localIterator2.next();
    } while (!paramString.equals(localFriend.jdField_a_of_type_JavaLangString));
    return localFriend;
    return null;
  }
  
  public String a(int paramInt)
  {
    return ((bddw)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString;
  }
  
  public List<Friend> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((bddw)localIterator1.next()).jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator2.hasNext()) {
        localArrayList.add(localIterator2.next());
      }
    }
    return localArrayList;
  }
  
  public List<Friend> a(int paramInt)
  {
    return ((bddw)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaUtilList;
  }
  
  public void a(String paramString)
  {
    if (!this.c.contains(paramString)) {
      this.c.add(paramString);
    }
  }
  
  public void a(List<bddw> paramList, int paramInt1, int paramInt2)
  {
    label9:
    String str2;
    Iterator localIterator1;
    if (paramList.size() <= 0)
    {
      return;
    }
    else
    {
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList.clear();
      this.c.clear();
      str2 = bcxm.a().a().getResources().getString(2131690902);
      localIterator1 = paramList.iterator();
    }
    for (;;)
    {
      if (localIterator1.hasNext())
      {
        paramList = (bddw)localIterator1.next();
        if (str2.equals(paramList.jdField_a_of_type_JavaLangString)) {
          this.jdField_b_of_type_JavaUtilList.addAll(paramList.jdField_a_of_type_JavaUtilList);
        }
      }
      else
      {
        break label9;
      }
      this.jdField_a_of_type_JavaUtilList.add(paramList);
      paramList = paramList.jdField_a_of_type_JavaUtilList;
      if (paramList == null) {
        break;
      }
      Iterator localIterator2 = paramList.iterator();
      while (localIterator2.hasNext())
      {
        Friend localFriend = (Friend)localIterator2.next();
        String str1 = localFriend.c;
        if (str1 != null)
        {
          paramList = str1;
          if (!"".equals(str1)) {}
        }
        else
        {
          paramList = localFriend.b;
        }
        localFriend.f = ChnToSpell.a(paramList, 2);
        localFriend.g = ChnToSpell.a(paramList, 1);
      }
    }
  }
  
  public boolean a(String paramString)
  {
    return this.c.contains(paramString);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public List<String> b()
  {
    return this.c;
  }
  
  public void b(String paramString)
  {
    if (this.c.contains(paramString)) {
      this.c.remove(paramString);
    }
  }
  
  public int c()
  {
    return this.c.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bddv
 * JD-Core Version:    0.7.0.1
 */