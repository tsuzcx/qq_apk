import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import java.util.ArrayList;
import java.util.List;

public abstract class bcmb
{
  public int a;
  public long a;
  public final bcmc a;
  public String a;
  public int b;
  
  public bcmb(GroupSearchEngine paramGroupSearchEngine, bcmc parambcmc, String paramString, int paramInt)
  {
    this.jdField_a_of_type_Bcmc = parambcmc;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  protected abstract bcfq a(List<bcfr> paramList, String paramString);
  
  public List<bcfq> a(bcmq parambcmq)
  {
    boolean bool2 = false;
    long l = System.currentTimeMillis();
    if (parambcmq.jdField_a_of_type_AndroidOsBundle == null) {
      parambcmq.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    parambcmq.jdField_a_of_type_AndroidOsBundle.putBoolean("searchRequestFromHome", true);
    ArrayList localArrayList = new ArrayList();
    List localList = this.jdField_a_of_type_Bcmc.a(parambcmq);
    this.jdField_a_of_type_Long = (System.currentTimeMillis() - l);
    if ((localList != null) && (!localList.isEmpty()))
    {
      bcfq localbcfq = a(localList, parambcmq.jdField_a_of_type_JavaLangString);
      if (((localbcfq instanceof bcfb)) && (localbcfq.a() != null) && (localbcfq.a().size() > 0)) {
        parambcmq.jdField_a_of_type_AndroidOsBundle.putBoolean("hasLocalPeopleOrTroop", true);
      }
      boolean bool1;
      if (localbcfq != null)
      {
        bool1 = bool2;
        if (localbcfq.a() != null)
        {
          bool1 = bool2;
          if (localbcfq.a().size() > localbcfq.a()) {
            bool1 = true;
          }
        }
        if (!(localbcfq instanceof bmlp)) {
          break label385;
        }
      }
      for (;;)
      {
        localArrayList.add(localbcfq);
        localbcfq = b(localList, parambcmq.jdField_a_of_type_JavaLangString);
        if (((localbcfq instanceof bcfb)) && (localbcfq.a() != null) && (localbcfq.a().size() > 0)) {
          parambcmq.jdField_a_of_type_AndroidOsBundle.putBoolean("hasLocalPeopleOrTroop", true);
        }
        if (localbcfq != null)
        {
          localArrayList.add(new bcey(localbcfq));
          localArrayList.add(localbcfq);
        }
        localbcfq = c(localList, parambcmq.jdField_a_of_type_JavaLangString);
        if (((localbcfq instanceof bcfd)) && (localbcfq.a() != null) && (localbcfq.a().size() > 0)) {
          parambcmq.jdField_a_of_type_AndroidOsBundle.putBoolean("hasLocalPeopleOrTroop", true);
        }
        if (localbcfq != null)
        {
          localArrayList.add(new bcey(localbcfq));
          localArrayList.add(localbcfq);
        }
        this.jdField_a_of_type_Int = localList.size();
        return localArrayList;
        label385:
        if ((localbcfq instanceof auaa)) {
          localArrayList.add(new bcey(localbcfq, anzj.a(2131704283), bool1));
        } else if (bhut.e(GroupSearchEngine.a(this.jdField_b_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine)) == 1) {
          localArrayList.add(new bcey(localbcfq, localbcfq.a().toString() + " " + this.jdField_a_of_type_Long + "ms", bool1));
        } else if ((localbcfq instanceof bcfj)) {
          localArrayList.add(new bcey(localbcfq, anzj.a(2131704263), true));
        } else if ((localbcfq instanceof bcff)) {
          localArrayList.add(new bcey(localbcfq, localbcfq.a(), bool1));
        } else if ((localbcfq instanceof bcdj)) {
          localArrayList.add(new bcey(localbcfq, anzj.a(2131704271), bool1));
        } else {
          localArrayList.add(new bcey(localbcfq));
        }
      }
    }
    this.jdField_a_of_type_Int = 0;
    return localArrayList;
  }
  
  protected bcfq b(List<bcfr> paramList, String paramString)
  {
    return null;
  }
  
  protected bcfq c(List<bcfr> paramList, String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcmb
 * JD-Core Version:    0.7.0.1
 */