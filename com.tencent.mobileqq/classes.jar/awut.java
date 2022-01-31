import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import java.util.ArrayList;
import java.util.List;

public abstract class awut
{
  public int a;
  public long a;
  public final awuu a;
  public String a;
  public int b;
  
  public awut(GroupSearchEngine paramGroupSearchEngine, awuu paramawuu, String paramString, int paramInt)
  {
    this.jdField_a_of_type_Awuu = paramawuu;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  protected abstract awoh a(List<awoi> paramList, String paramString);
  
  public List<awoh> a(awvi paramawvi)
  {
    boolean bool2 = false;
    long l = System.currentTimeMillis();
    if (paramawvi.jdField_a_of_type_AndroidOsBundle == null) {
      paramawvi.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    paramawvi.jdField_a_of_type_AndroidOsBundle.putBoolean("searchRequestFromHome", true);
    ArrayList localArrayList = new ArrayList();
    List localList = this.jdField_a_of_type_Awuu.a(paramawvi);
    this.jdField_a_of_type_Long = (System.currentTimeMillis() - l);
    if ((localList != null) && (!localList.isEmpty()))
    {
      awoh localawoh = a(localList, paramawvi.jdField_a_of_type_JavaLangString);
      if (((localawoh instanceof awns)) && (localawoh.a() != null) && (localawoh.a().size() > 0)) {
        paramawvi.jdField_a_of_type_AndroidOsBundle.putBoolean("hasLocalPeopleOrTroop", true);
      }
      boolean bool1;
      if (localawoh != null)
      {
        bool1 = bool2;
        if (localawoh.a() != null)
        {
          bool1 = bool2;
          if (localawoh.a().size() > localawoh.a()) {
            bool1 = true;
          }
        }
        if (!(localawoh instanceof bgqv)) {
          break label385;
        }
      }
      for (;;)
      {
        localArrayList.add(localawoh);
        localawoh = b(localList, paramawvi.jdField_a_of_type_JavaLangString);
        if (((localawoh instanceof awns)) && (localawoh.a() != null) && (localawoh.a().size() > 0)) {
          paramawvi.jdField_a_of_type_AndroidOsBundle.putBoolean("hasLocalPeopleOrTroop", true);
        }
        if (localawoh != null)
        {
          localArrayList.add(new awnp(localawoh));
          localArrayList.add(localawoh);
        }
        localawoh = c(localList, paramawvi.jdField_a_of_type_JavaLangString);
        if (((localawoh instanceof awnu)) && (localawoh.a() != null) && (localawoh.a().size() > 0)) {
          paramawvi.jdField_a_of_type_AndroidOsBundle.putBoolean("hasLocalPeopleOrTroop", true);
        }
        if (localawoh != null)
        {
          localArrayList.add(new awnp(localawoh));
          localArrayList.add(localawoh);
        }
        this.jdField_a_of_type_Int = localList.size();
        return localArrayList;
        label385:
        if ((localawoh instanceof apfp)) {
          localArrayList.add(new awnp(localawoh, ajya.a(2131705391), bool1));
        } else if (bbmo.e(GroupSearchEngine.a(this.jdField_b_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine)) == 1) {
          localArrayList.add(new awnp(localawoh, localawoh.a().toString() + " " + this.jdField_a_of_type_Long + "ms", bool1));
        } else if ((localawoh instanceof awoa)) {
          localArrayList.add(new awnp(localawoh, ajya.a(2131705371), true));
        } else if ((localawoh instanceof awnw)) {
          localArrayList.add(new awnp(localawoh, localawoh.a(), bool1));
        } else if ((localawoh instanceof awma)) {
          localArrayList.add(new awnp(localawoh, ajya.a(2131705379), bool1));
        } else {
          localArrayList.add(new awnp(localawoh));
        }
      }
    }
    this.jdField_a_of_type_Int = 0;
    return localArrayList;
  }
  
  protected awoh b(List<awoi> paramList, String paramString)
  {
    return null;
  }
  
  protected awoh c(List<awoi> paramList, String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awut
 * JD-Core Version:    0.7.0.1
 */