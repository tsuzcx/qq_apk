import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import java.util.ArrayList;
import java.util.List;

public abstract class ayuf
{
  public int a;
  public long a;
  public final ayug a;
  public String a;
  public int b;
  
  public ayuf(GroupSearchEngine paramGroupSearchEngine, ayug paramayug, String paramString, int paramInt)
  {
    this.jdField_a_of_type_Ayug = paramayug;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  protected abstract aynt a(List<aynu> paramList, String paramString);
  
  public List<aynt> a(ayuu paramayuu)
  {
    boolean bool2 = false;
    long l = System.currentTimeMillis();
    if (paramayuu.jdField_a_of_type_AndroidOsBundle == null) {
      paramayuu.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    paramayuu.jdField_a_of_type_AndroidOsBundle.putBoolean("searchRequestFromHome", true);
    ArrayList localArrayList = new ArrayList();
    List localList = this.jdField_a_of_type_Ayug.a(paramayuu);
    this.jdField_a_of_type_Long = (System.currentTimeMillis() - l);
    if ((localList != null) && (!localList.isEmpty()))
    {
      aynt localaynt = a(localList, paramayuu.jdField_a_of_type_JavaLangString);
      if (((localaynt instanceof ayne)) && (localaynt.a() != null) && (localaynt.a().size() > 0)) {
        paramayuu.jdField_a_of_type_AndroidOsBundle.putBoolean("hasLocalPeopleOrTroop", true);
      }
      boolean bool1;
      if (localaynt != null)
      {
        bool1 = bool2;
        if (localaynt.a() != null)
        {
          bool1 = bool2;
          if (localaynt.a().size() > localaynt.a()) {
            bool1 = true;
          }
        }
        if (!(localaynt instanceof biwb)) {
          break label385;
        }
      }
      for (;;)
      {
        localArrayList.add(localaynt);
        localaynt = b(localList, paramayuu.jdField_a_of_type_JavaLangString);
        if (((localaynt instanceof ayne)) && (localaynt.a() != null) && (localaynt.a().size() > 0)) {
          paramayuu.jdField_a_of_type_AndroidOsBundle.putBoolean("hasLocalPeopleOrTroop", true);
        }
        if (localaynt != null)
        {
          localArrayList.add(new aynb(localaynt));
          localArrayList.add(localaynt);
        }
        localaynt = c(localList, paramayuu.jdField_a_of_type_JavaLangString);
        if (((localaynt instanceof ayng)) && (localaynt.a() != null) && (localaynt.a().size() > 0)) {
          paramayuu.jdField_a_of_type_AndroidOsBundle.putBoolean("hasLocalPeopleOrTroop", true);
        }
        if (localaynt != null)
        {
          localArrayList.add(new aynb(localaynt));
          localArrayList.add(localaynt);
        }
        this.jdField_a_of_type_Int = localList.size();
        return localArrayList;
        label385:
        if ((localaynt instanceof arcw)) {
          localArrayList.add(new aynb(localaynt, alud.a(2131705775), bool1));
        } else if (bdpr.e(GroupSearchEngine.a(this.jdField_b_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine)) == 1) {
          localArrayList.add(new aynb(localaynt, localaynt.a().toString() + " " + this.jdField_a_of_type_Long + "ms", bool1));
        } else if ((localaynt instanceof aynm)) {
          localArrayList.add(new aynb(localaynt, alud.a(2131705755), true));
        } else if ((localaynt instanceof ayni)) {
          localArrayList.add(new aynb(localaynt, localaynt.a(), bool1));
        } else if ((localaynt instanceof aylm)) {
          localArrayList.add(new aynb(localaynt, alud.a(2131705763), bool1));
        } else {
          localArrayList.add(new aynb(localaynt));
        }
      }
    }
    this.jdField_a_of_type_Int = 0;
    return localArrayList;
  }
  
  protected aynt b(List<aynu> paramList, String paramString)
  {
    return null;
  }
  
  protected aynt c(List<aynu> paramList, String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayuf
 * JD-Core Version:    0.7.0.1
 */