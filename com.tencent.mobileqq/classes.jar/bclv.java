import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import java.util.ArrayList;
import java.util.List;

public abstract class bclv
{
  public long a;
  public final bclw a;
  public String a;
  public int b;
  public int c;
  
  public bclv(GroupSearchEngine paramGroupSearchEngine, bclw parambclw, String paramString, int paramInt)
  {
    this.jdField_a_of_type_Bclw = parambclw;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.c = paramInt;
  }
  
  protected abstract bcfi a(List<bcfj> paramList, String paramString);
  
  public List<bcfi> a(bcmk parambcmk)
  {
    boolean bool2 = false;
    long l = System.currentTimeMillis();
    if (parambcmk.jdField_a_of_type_AndroidOsBundle == null) {
      parambcmk.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    parambcmk.jdField_a_of_type_AndroidOsBundle.putBoolean("searchRequestFromHome", true);
    ArrayList localArrayList = new ArrayList();
    List localList = this.jdField_a_of_type_Bclw.a(parambcmk);
    this.jdField_a_of_type_Long = (System.currentTimeMillis() - l);
    if ((localList != null) && (!localList.isEmpty()))
    {
      bcfi localbcfi = a(localList, parambcmk.jdField_a_of_type_JavaLangString);
      if (((localbcfi instanceof bcet)) && (localbcfi.a() != null) && (localbcfi.a().size() > 0)) {
        parambcmk.jdField_a_of_type_AndroidOsBundle.putBoolean("hasLocalPeopleOrTroop", true);
      }
      boolean bool1;
      if (localbcfi != null)
      {
        bool1 = bool2;
        if (localbcfi.a() != null)
        {
          bool1 = bool2;
          if (localbcfi.a().size() > localbcfi.a()) {
            bool1 = true;
          }
        }
        if (!(localbcfi instanceof bmbe)) {
          break label385;
        }
      }
      for (;;)
      {
        localArrayList.add(localbcfi);
        localbcfi = b(localList, parambcmk.jdField_a_of_type_JavaLangString);
        if (((localbcfi instanceof bcet)) && (localbcfi.a() != null) && (localbcfi.a().size() > 0)) {
          parambcmk.jdField_a_of_type_AndroidOsBundle.putBoolean("hasLocalPeopleOrTroop", true);
        }
        if (localbcfi != null)
        {
          localArrayList.add(new bceq(localbcfi));
          localArrayList.add(localbcfi);
        }
        localbcfi = c(localList, parambcmk.jdField_a_of_type_JavaLangString);
        if (((localbcfi instanceof bcev)) && (localbcfi.a() != null) && (localbcfi.a().size() > 0)) {
          parambcmk.jdField_a_of_type_AndroidOsBundle.putBoolean("hasLocalPeopleOrTroop", true);
        }
        if (localbcfi != null)
        {
          localArrayList.add(new bceq(localbcfi));
          localArrayList.add(localbcfi);
        }
        this.jdField_b_of_type_Int = localList.size();
        return localArrayList;
        label385:
        if ((localbcfi instanceof atqq)) {
          localArrayList.add(new bceq(localbcfi, anvx.a(2131704864), bool1));
        } else if (bhkf.e(GroupSearchEngine.a(this.jdField_b_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine)) == 1) {
          localArrayList.add(new bceq(localbcfi, localbcfi.a().toString() + " " + this.jdField_a_of_type_Long + "ms", bool1));
        } else if ((localbcfi instanceof bcfb)) {
          localArrayList.add(new bceq(localbcfi, anvx.a(2131704844), true));
        } else if ((localbcfi instanceof bcex)) {
          localArrayList.add(new bceq(localbcfi, localbcfi.a(), bool1));
        } else if ((localbcfi instanceof bcdb)) {
          localArrayList.add(new bceq(localbcfi, anvx.a(2131704852), bool1));
        } else {
          localArrayList.add(new bceq(localbcfi));
        }
      }
    }
    this.jdField_b_of_type_Int = 0;
    return localArrayList;
  }
  
  protected bcfi b(List<bcfj> paramList, String paramString)
  {
    return null;
  }
  
  protected bcfi c(List<bcfj> paramList, String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bclv
 * JD-Core Version:    0.7.0.1
 */