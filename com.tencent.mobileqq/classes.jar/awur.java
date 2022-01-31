import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import java.util.ArrayList;
import java.util.List;

public abstract class awur
{
  public int a;
  public long a;
  public final awus a;
  public String a;
  public int b;
  
  public awur(GroupSearchEngine paramGroupSearchEngine, awus paramawus, String paramString, int paramInt)
  {
    this.jdField_a_of_type_Awus = paramawus;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  protected abstract awof a(List<awog> paramList, String paramString);
  
  public List<awof> a(awvg paramawvg)
  {
    boolean bool2 = false;
    long l = System.currentTimeMillis();
    if (paramawvg.jdField_a_of_type_AndroidOsBundle == null) {
      paramawvg.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    paramawvg.jdField_a_of_type_AndroidOsBundle.putBoolean("searchRequestFromHome", true);
    ArrayList localArrayList = new ArrayList();
    List localList = this.jdField_a_of_type_Awus.a(paramawvg);
    this.jdField_a_of_type_Long = (System.currentTimeMillis() - l);
    if ((localList != null) && (!localList.isEmpty()))
    {
      awof localawof = a(localList, paramawvg.jdField_a_of_type_JavaLangString);
      if (((localawof instanceof awnq)) && (localawof.a() != null) && (localawof.a().size() > 0)) {
        paramawvg.jdField_a_of_type_AndroidOsBundle.putBoolean("hasLocalPeopleOrTroop", true);
      }
      boolean bool1;
      if (localawof != null)
      {
        bool1 = bool2;
        if (localawof.a() != null)
        {
          bool1 = bool2;
          if (localawof.a().size() > localawof.a()) {
            bool1 = true;
          }
        }
        if (!(localawof instanceof bgqe)) {
          break label385;
        }
      }
      for (;;)
      {
        localArrayList.add(localawof);
        localawof = b(localList, paramawvg.jdField_a_of_type_JavaLangString);
        if (((localawof instanceof awnq)) && (localawof.a() != null) && (localawof.a().size() > 0)) {
          paramawvg.jdField_a_of_type_AndroidOsBundle.putBoolean("hasLocalPeopleOrTroop", true);
        }
        if (localawof != null)
        {
          localArrayList.add(new awnn(localawof));
          localArrayList.add(localawof);
        }
        localawof = c(localList, paramawvg.jdField_a_of_type_JavaLangString);
        if (((localawof instanceof awns)) && (localawof.a() != null) && (localawof.a().size() > 0)) {
          paramawvg.jdField_a_of_type_AndroidOsBundle.putBoolean("hasLocalPeopleOrTroop", true);
        }
        if (localawof != null)
        {
          localArrayList.add(new awnn(localawof));
          localArrayList.add(localawof);
        }
        this.jdField_a_of_type_Int = localList.size();
        return localArrayList;
        label385:
        if ((localawof instanceof apfl)) {
          localArrayList.add(new awnn(localawof, ajyc.a(2131705380), bool1));
        } else if (bbma.e(GroupSearchEngine.a(this.jdField_b_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine)) == 1) {
          localArrayList.add(new awnn(localawof, localawof.a().toString() + " " + this.jdField_a_of_type_Long + "ms", bool1));
        } else if ((localawof instanceof awny)) {
          localArrayList.add(new awnn(localawof, ajyc.a(2131705360), true));
        } else if ((localawof instanceof awnu)) {
          localArrayList.add(new awnn(localawof, localawof.a(), bool1));
        } else if ((localawof instanceof awly)) {
          localArrayList.add(new awnn(localawof, ajyc.a(2131705368), bool1));
        } else {
          localArrayList.add(new awnn(localawof));
        }
      }
    }
    this.jdField_a_of_type_Int = 0;
    return localArrayList;
  }
  
  protected awof b(List<awog> paramList, String paramString)
  {
    return null;
  }
  
  protected awof c(List<awog> paramList, String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awur
 * JD-Core Version:    0.7.0.1
 */