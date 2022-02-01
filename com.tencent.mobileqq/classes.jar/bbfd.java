import android.os.Bundle;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import java.util.ArrayList;
import java.util.List;

public abstract class bbfd
{
  public long a;
  public final bbfe a;
  public String a;
  public int b;
  public int c;
  
  public bbfd(GroupSearchEngine paramGroupSearchEngine, bbfe parambbfe, String paramString, int paramInt)
  {
    this.jdField_a_of_type_Bbfe = parambbfe;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.c = paramInt;
  }
  
  protected abstract bays a(List<bayt> paramList, String paramString);
  
  public List<bays> a(bbfs parambbfs)
  {
    boolean bool2 = false;
    long l = System.currentTimeMillis();
    if (parambbfs.jdField_a_of_type_AndroidOsBundle == null) {
      parambbfs.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    parambbfs.jdField_a_of_type_AndroidOsBundle.putBoolean("searchRequestFromHome", true);
    ArrayList localArrayList = new ArrayList();
    List localList = this.jdField_a_of_type_Bbfe.a(parambbfs);
    this.jdField_a_of_type_Long = (System.currentTimeMillis() - l);
    if ((localList != null) && (!localList.isEmpty()))
    {
      bays localbays = a(localList, parambbfs.jdField_a_of_type_JavaLangString);
      if (((localbays instanceof bayd)) && (localbays.a() != null) && (localbays.a().size() > 0)) {
        parambbfs.jdField_a_of_type_AndroidOsBundle.putBoolean("hasLocalPeopleOrTroop", true);
      }
      boolean bool1;
      if (localbays != null)
      {
        bool1 = bool2;
        if (localbays.a() != null)
        {
          bool1 = bool2;
          if (localbays.a().size() > localbays.a()) {
            bool1 = true;
          }
        }
        if (!(localbays instanceof bkpw)) {
          break label385;
        }
      }
      for (;;)
      {
        localArrayList.add(localbays);
        localbays = b(localList, parambbfs.jdField_a_of_type_JavaLangString);
        if (((localbays instanceof bayd)) && (localbays.a() != null) && (localbays.a().size() > 0)) {
          parambbfs.jdField_a_of_type_AndroidOsBundle.putBoolean("hasLocalPeopleOrTroop", true);
        }
        if (localbays != null)
        {
          localArrayList.add(new baya(localbays));
          localArrayList.add(localbays);
        }
        localbays = c(localList, parambbfs.jdField_a_of_type_JavaLangString);
        if (((localbays instanceof bayf)) && (localbays.a() != null) && (localbays.a().size() > 0)) {
          parambbfs.jdField_a_of_type_AndroidOsBundle.putBoolean("hasLocalPeopleOrTroop", true);
        }
        if (localbays != null)
        {
          localArrayList.add(new baya(localbays));
          localArrayList.add(localbays);
        }
        this.jdField_b_of_type_Int = localList.size();
        return localArrayList;
        label385:
        if ((localbays instanceof asmk)) {
          localArrayList.add(new baya(localbays, amtj.a(2131704513), bool1));
        } else if (bgbo.e(GroupSearchEngine.a(this.jdField_b_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine)) == 1) {
          localArrayList.add(new baya(localbays, localbays.a().toString() + " " + this.jdField_a_of_type_Long + "ms", bool1));
        } else if ((localbays instanceof bayl)) {
          localArrayList.add(new baya(localbays, amtj.a(2131704493), true));
        } else if ((localbays instanceof bayh)) {
          localArrayList.add(new baya(localbays, localbays.a(), bool1));
        } else if ((localbays instanceof bawl)) {
          localArrayList.add(new baya(localbays, amtj.a(2131704501), bool1));
        } else {
          localArrayList.add(new baya(localbays));
        }
      }
    }
    this.jdField_b_of_type_Int = 0;
    return localArrayList;
  }
  
  protected bays b(List<bayt> paramList, String paramString)
  {
    return null;
  }
  
  protected bays c(List<bayt> paramList, String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbfd
 * JD-Core Version:    0.7.0.1
 */