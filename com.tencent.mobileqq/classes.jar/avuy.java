import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import java.util.ArrayList;
import java.util.List;

public abstract class avuy
{
  public int a;
  public long a;
  public final avuz a;
  public String a;
  public int b;
  
  public avuy(GroupSearchEngine paramGroupSearchEngine, avuz paramavuz, String paramString, int paramInt)
  {
    this.jdField_a_of_type_Avuz = paramavuz;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  protected abstract avom a(List<avon> paramList, String paramString);
  
  public List<avom> a(avvn paramavvn)
  {
    boolean bool2 = false;
    long l = System.currentTimeMillis();
    if (paramavvn.jdField_a_of_type_AndroidOsBundle == null) {
      paramavvn.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    paramavvn.jdField_a_of_type_AndroidOsBundle.putBoolean("searchRequestFromHome", true);
    ArrayList localArrayList = new ArrayList();
    List localList = this.jdField_a_of_type_Avuz.a(paramavvn);
    this.jdField_a_of_type_Long = (System.currentTimeMillis() - l);
    if ((localList != null) && (!localList.isEmpty()))
    {
      avom localavom = a(localList, paramavvn.jdField_a_of_type_JavaLangString);
      if (((localavom instanceof avnx)) && (localavom.a() != null) && (localavom.a().size() > 0)) {
        paramavvn.jdField_a_of_type_AndroidOsBundle.putBoolean("hasLocalPeopleOrTroop", true);
      }
      boolean bool1;
      if (localavom != null)
      {
        bool1 = bool2;
        if (localavom.a() != null)
        {
          bool1 = bool2;
          if (localavom.a().size() > localavom.a()) {
            bool1 = true;
          }
        }
        if (!(localavom instanceof bfim)) {
          break label385;
        }
      }
      for (;;)
      {
        localArrayList.add(localavom);
        localavom = b(localList, paramavvn.jdField_a_of_type_JavaLangString);
        if (((localavom instanceof avnx)) && (localavom.a() != null) && (localavom.a().size() > 0)) {
          paramavvn.jdField_a_of_type_AndroidOsBundle.putBoolean("hasLocalPeopleOrTroop", true);
        }
        if (localavom != null)
        {
          localArrayList.add(new avnu(localavom));
          localArrayList.add(localavom);
        }
        localavom = c(localList, paramavvn.jdField_a_of_type_JavaLangString);
        if (((localavom instanceof avnz)) && (localavom.a() != null) && (localavom.a().size() > 0)) {
          paramavvn.jdField_a_of_type_AndroidOsBundle.putBoolean("hasLocalPeopleOrTroop", true);
        }
        if (localavom != null)
        {
          localArrayList.add(new avnu(localavom));
          localArrayList.add(localavom);
        }
        this.jdField_a_of_type_Int = localList.size();
        return localArrayList;
        label385:
        if ((localavom instanceof aooq)) {
          localArrayList.add(new avnu(localavom, ajjy.a(2131639595), bool1));
        } else if (bakq.e(GroupSearchEngine.a(this.jdField_b_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine)) == 1) {
          localArrayList.add(new avnu(localavom, localavom.a().toString() + " " + this.jdField_a_of_type_Long + "ms", bool1));
        } else if ((localavom instanceof avof)) {
          localArrayList.add(new avnu(localavom, ajjy.a(2131639575), true));
        } else if ((localavom instanceof avob)) {
          localArrayList.add(new avnu(localavom, localavom.a(), bool1));
        } else if ((localavom instanceof avmf)) {
          localArrayList.add(new avnu(localavom, ajjy.a(2131639583), bool1));
        } else {
          localArrayList.add(new avnu(localavom));
        }
      }
    }
    this.jdField_a_of_type_Int = 0;
    return localArrayList;
  }
  
  protected avom b(List<avon> paramList, String paramString)
  {
    return null;
  }
  
  protected avom c(List<avon> paramList, String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avuy
 * JD-Core Version:    0.7.0.1
 */