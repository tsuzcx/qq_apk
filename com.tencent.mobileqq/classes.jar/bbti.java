import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import java.util.ArrayList;
import java.util.List;

public abstract class bbti
{
  public int a;
  public long a;
  public final bbtj a;
  public String a;
  public int b;
  
  public bbti(GroupSearchEngine paramGroupSearchEngine, bbtj parambbtj, String paramString, int paramInt)
  {
    this.jdField_a_of_type_Bbtj = parambbtj;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  protected abstract bbmx a(List<bbmy> paramList, String paramString);
  
  public List<bbmx> a(bbtx parambbtx)
  {
    boolean bool2 = false;
    long l = System.currentTimeMillis();
    if (parambbtx.jdField_a_of_type_AndroidOsBundle == null) {
      parambbtx.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    parambbtx.jdField_a_of_type_AndroidOsBundle.putBoolean("searchRequestFromHome", true);
    ArrayList localArrayList = new ArrayList();
    List localList = this.jdField_a_of_type_Bbtj.a(parambbtx);
    this.jdField_a_of_type_Long = (System.currentTimeMillis() - l);
    if ((localList != null) && (!localList.isEmpty()))
    {
      bbmx localbbmx = a(localList, parambbtx.jdField_a_of_type_JavaLangString);
      if (((localbbmx instanceof bbmi)) && (localbbmx.a() != null) && (localbbmx.a().size() > 0)) {
        parambbtx.jdField_a_of_type_AndroidOsBundle.putBoolean("hasLocalPeopleOrTroop", true);
      }
      boolean bool1;
      if (localbbmx != null)
      {
        bool1 = bool2;
        if (localbbmx.a() != null)
        {
          bool1 = bool2;
          if (localbbmx.a().size() > localbbmx.a()) {
            bool1 = true;
          }
        }
        if (!(localbbmx instanceof blkm)) {
          break label385;
        }
      }
      for (;;)
      {
        localArrayList.add(localbbmx);
        localbbmx = b(localList, parambbtx.jdField_a_of_type_JavaLangString);
        if (((localbbmx instanceof bbmi)) && (localbbmx.a() != null) && (localbbmx.a().size() > 0)) {
          parambbtx.jdField_a_of_type_AndroidOsBundle.putBoolean("hasLocalPeopleOrTroop", true);
        }
        if (localbbmx != null)
        {
          localArrayList.add(new bbmf(localbbmx));
          localArrayList.add(localbbmx);
        }
        localbbmx = c(localList, parambbtx.jdField_a_of_type_JavaLangString);
        if (((localbbmx instanceof bbmk)) && (localbbmx.a() != null) && (localbbmx.a().size() > 0)) {
          parambbtx.jdField_a_of_type_AndroidOsBundle.putBoolean("hasLocalPeopleOrTroop", true);
        }
        if (localbbmx != null)
        {
          localArrayList.add(new bbmf(localbbmx));
          localArrayList.add(localbbmx);
        }
        this.jdField_a_of_type_Int = localList.size();
        return localArrayList;
        label385:
        if ((localbbmx instanceof atig)) {
          localArrayList.add(new bbmf(localbbmx, anni.a(2131704176), bool1));
        } else if (bguq.e(GroupSearchEngine.a(this.jdField_b_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine)) == 1) {
          localArrayList.add(new bbmf(localbbmx, localbbmx.a().toString() + " " + this.jdField_a_of_type_Long + "ms", bool1));
        } else if ((localbbmx instanceof bbmq)) {
          localArrayList.add(new bbmf(localbbmx, anni.a(2131704156), true));
        } else if ((localbbmx instanceof bbmm)) {
          localArrayList.add(new bbmf(localbbmx, localbbmx.a(), bool1));
        } else if ((localbbmx instanceof bbkq)) {
          localArrayList.add(new bbmf(localbbmx, anni.a(2131704164), bool1));
        } else {
          localArrayList.add(new bbmf(localbbmx));
        }
      }
    }
    this.jdField_a_of_type_Int = 0;
    return localArrayList;
  }
  
  protected bbmx b(List<bbmy> paramList, String paramString)
  {
    return null;
  }
  
  protected bbmx c(List<bbmy> paramList, String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbti
 * JD-Core Version:    0.7.0.1
 */