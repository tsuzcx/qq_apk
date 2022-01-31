import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import java.util.ArrayList;
import java.util.List;

public abstract class aypw
{
  public int a;
  public long a;
  public final aypx a;
  public String a;
  public int b;
  
  public aypw(GroupSearchEngine paramGroupSearchEngine, aypx paramaypx, String paramString, int paramInt)
  {
    this.jdField_a_of_type_Aypx = paramaypx;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  protected abstract ayjk a(List<ayjl> paramList, String paramString);
  
  public List<ayjk> a(ayql paramayql)
  {
    boolean bool2 = false;
    long l = System.currentTimeMillis();
    if (paramayql.jdField_a_of_type_AndroidOsBundle == null) {
      paramayql.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    paramayql.jdField_a_of_type_AndroidOsBundle.putBoolean("searchRequestFromHome", true);
    ArrayList localArrayList = new ArrayList();
    List localList = this.jdField_a_of_type_Aypx.a(paramayql);
    this.jdField_a_of_type_Long = (System.currentTimeMillis() - l);
    if ((localList != null) && (!localList.isEmpty()))
    {
      ayjk localayjk = a(localList, paramayql.jdField_a_of_type_JavaLangString);
      if (((localayjk instanceof ayiv)) && (localayjk.a() != null) && (localayjk.a().size() > 0)) {
        paramayql.jdField_a_of_type_AndroidOsBundle.putBoolean("hasLocalPeopleOrTroop", true);
      }
      boolean bool1;
      if (localayjk != null)
      {
        bool1 = bool2;
        if (localayjk.a() != null)
        {
          bool1 = bool2;
          if (localayjk.a().size() > localayjk.a()) {
            bool1 = true;
          }
        }
        if (!(localayjk instanceof biru)) {
          break label385;
        }
      }
      for (;;)
      {
        localArrayList.add(localayjk);
        localayjk = b(localList, paramayql.jdField_a_of_type_JavaLangString);
        if (((localayjk instanceof ayiv)) && (localayjk.a() != null) && (localayjk.a().size() > 0)) {
          paramayql.jdField_a_of_type_AndroidOsBundle.putBoolean("hasLocalPeopleOrTroop", true);
        }
        if (localayjk != null)
        {
          localArrayList.add(new ayis(localayjk));
          localArrayList.add(localayjk);
        }
        localayjk = c(localList, paramayql.jdField_a_of_type_JavaLangString);
        if (((localayjk instanceof ayix)) && (localayjk.a() != null) && (localayjk.a().size() > 0)) {
          paramayql.jdField_a_of_type_AndroidOsBundle.putBoolean("hasLocalPeopleOrTroop", true);
        }
        if (localayjk != null)
        {
          localArrayList.add(new ayis(localayjk));
          localArrayList.add(localayjk);
        }
        this.jdField_a_of_type_Int = localList.size();
        return localArrayList;
        label385:
        if ((localayjk instanceof aqyn)) {
          localArrayList.add(new ayis(localayjk, alpo.a(2131705763), bool1));
        } else if (bdli.e(GroupSearchEngine.a(this.jdField_b_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine)) == 1) {
          localArrayList.add(new ayis(localayjk, localayjk.a().toString() + " " + this.jdField_a_of_type_Long + "ms", bool1));
        } else if ((localayjk instanceof ayjd)) {
          localArrayList.add(new ayis(localayjk, alpo.a(2131705743), true));
        } else if ((localayjk instanceof ayiz)) {
          localArrayList.add(new ayis(localayjk, localayjk.a(), bool1));
        } else if ((localayjk instanceof ayhd)) {
          localArrayList.add(new ayis(localayjk, alpo.a(2131705751), bool1));
        } else {
          localArrayList.add(new ayis(localayjk));
        }
      }
    }
    this.jdField_a_of_type_Int = 0;
    return localArrayList;
  }
  
  protected ayjk b(List<ayjl> paramList, String paramString)
  {
    return null;
  }
  
  protected ayjk c(List<ayjl> paramList, String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aypw
 * JD-Core Version:    0.7.0.1
 */